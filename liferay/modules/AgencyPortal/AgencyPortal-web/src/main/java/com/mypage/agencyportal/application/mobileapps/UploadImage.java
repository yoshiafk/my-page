package com.mypage.agencyportal.application.mobileapps;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.JsonResponseHelper;
import com.mypage.agencyportal.helpers.JwtAuthHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.user.model.MypageUser;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.crypto.SecretKey;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.*;
import java.util.*;

@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/m/upload",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Upload.Rest",
                "auth.verifier.guest.allowed=true",
                "liferay.access.control.disable=true"
        },
        service = Application.class
)
public class UploadImage extends Application {

    private static final Log _log = LogFactoryUtil.getLog(UploadImage.class);

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilterHelper.class);
        return classes;
    }

    private JwtKeyService _jwtKeyService;

    @Reference
    protected void setJwtKeyService(JwtKeyService jwtKeyService) {
        this._jwtKeyService = jwtKeyService;
        _log.info("JwtKeyService has been injected into UpPhoto");
    }

    @POST
    @Path("/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadProfilePhoto(
            @HeaderParam("Authorization") String authHeader,
            @Context HttpServletRequest request
    ) {
        try {
            // Authenticate JWT token
            MypageUser user = getAuthenticatedUser(authHeader);

            // Log headers for debugging
            _log.info("Request content type: " + request.getContentType());
            _log.info("Is multipart: " + ServletFileUpload.isMultipartContent(request));

            // Check if request is multipart
            if (!ServletFileUpload.isMultipartContent(request)) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Request is not multipart").build();
            }

            // Prepare to handle file upload
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(10 * 1024); // 10 KB for threshold in memory
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(50 * 1024 * 1024); // Max file size 50 MB
            upload.setSizeMax(100 * 1024 * 1024); // Max total request size 100 MB

            List<FileItem> formItems = upload.parseRequest(request);

            for (FileItem item : formItems) {
                _log.info("Field name: " + item.getFieldName());
                _log.info("Item name: " + item.getName());

                // Process file if it's not a form field
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    File uploadedFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);

                    // Write the file to the temporary directory
                    item.write(uploadedFile);

                    // Log file details
                    long fileSize = uploadedFile.length();
                    _log.info("Uploaded file: " + fileName + ", size: " + fileSize);

                    return Response.ok("File uploaded: " + fileName + " (" + fileSize + " bytes)").build();
                }
            }

            // Return error if no file found in form data
            return Response.status(Response.Status.BAD_REQUEST).entity("No file found").build();

        } catch (Exception e) {
            // Log the error and return server error response
            _log.error("Upload failed", e);
            return Response.serverError().entity("Upload failed!").build();
        }
    }

    private MypageUser getAuthenticatedUser(String authHeader) throws Exception {
        SecretKey key = _jwtKeyService.getKey();
        JwtAuthHelper.AuthResult authResult = JwtAuthHelper.authenticate(authHeader, key);
        if (!authResult.valid) {
            throw new WebApplicationException(
                Response.status(Response.Status.UNAUTHORIZED)
                    .entity(JsonResponseHelper.error(authResult.error).toString())
                    .build()
            );
        }
        if (authResult.user == null) {
            throw new WebApplicationException(
                Response.status(Response.Status.NOT_FOUND)
                    .entity(JsonResponseHelper.error("Agent not found").toString())
                    .build()
            );
        }
        return authResult.user;
    }

}
