package com.mypage.agencyportal.application.mobileapps;

import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.fragment.service.FragmentEntryLinkLocalServiceUtil;
import com.liferay.fragment.service.FragmentEntryLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.mypage.agencyportal.dto.mobileapps.BannerDTO;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * REST API endpoint for Banner.
 */
@Component(
    property = {
        "osgi.jaxrs.application.base=/banner",
        "osgi.jaxrs.name=BannerImage.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
@Path("/v2")
public class BannerImageApplication extends Application {
	
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilterHelper.class);
        return classes;
    }

	private static final Log _log = LogFactoryUtil.getLog(BannerImageApplication.class);
    private JwtKeyService _jwtKeyService;
    
    @Reference
    protected void setJwtKeyService(JwtKeyService jwtKeyService) {
        this._jwtKeyService = jwtKeyService;
        _log.info("JwtKeyService has been injected into BannerApplication");
    }

    @GET
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBanners(@HeaderParam("Authorization") String authHeader) {
    	
    	_log.info("Get getBanners data endpoint called");

        final String BEARER_PREFIX = "Bearer ";
    	
        try {
        	if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(createErrorResponse("Missing or invalid Authorization header")).build();
            }

            String jwtToken = authHeader.substring(BEARER_PREFIX.length());

            // Validate token
            SecretKey key = _jwtKeyService.getKey();
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody();

            String deptoreCode = claims.getSubject();
            Date expiration = claims.getExpiration();
            MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);

            if (expiration == null || expiration.before(new Date())) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(createErrorResponse("Token invalid atau sudah expired")).build();
            }
            
            if(user == null) {
	        	return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("User not found"))
	                    .build();
	        }


            long groupId = ServiceContextThreadLocal.getServiceContext().getScopeGroupId();
            Layout layout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, false, "/dashboard");

            if (layout == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Layout not found").build();
            }

            List<FragmentEntryLink> fragmentLinks = FragmentEntryLinkLocalServiceUtil
                    .getFragmentEntryLinksByPlid(groupId, layout.getPlid());

            List<BannerDTO> banners = new ArrayList<>();

            try {
                for (FragmentEntryLink fragmentEntryLink : fragmentLinks) {
                    String editableValues = fragmentEntryLink.getEditableValues();
                    System.out.println(editableValues);
                    JSONObject editableValuesJson = JSONFactoryUtil.createJSONObject(editableValues);
                    JSONObject editableProcessor = editableValuesJson.getJSONObject("com.liferay.fragment.entry.processor.editable.EditableFragmentEntryProcessor");

                    if (editableProcessor == null) {
                        continue;
                    }

                    for (int i = 1; i <= 10; i++) {
                        JSONObject titleJson = editableProcessor.getJSONObject("title" + i);
                        JSONObject subtitleJson = editableProcessor.getJSONObject("subtitle" + i);
                        JSONObject imageJson = editableProcessor.getJSONObject("image-" + i);

                        String title = (titleJson != null) ? titleJson.getString("en_US", "") : "";
                        String subtitle = (subtitleJson != null) ? subtitleJson.getString("en_US", "") : "";
                        String imageUrl = (imageJson != null && imageJson.has("en_US")) ? imageJson.getJSONObject("en_US").getString("url", "") : "";
                        String href = (imageJson != null && imageJson.has("config") && imageJson.getJSONObject("config").has("href"))
                                ? imageJson.getJSONObject("config").getString("href")
                                : "";
                        if (!imageUrl.isEmpty()) {
                            banners.add(new BannerDTO(i, title, subtitle, imageUrl, href));
                        }
                    }
                }
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error processing banners: " + e.getMessage()).build();
            }

            if (banners.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No banners found with images").build();
            }

            return Response.ok(banners).build();
        	
        } catch (ExpiredJwtException e) {
            _log.error("Token expired: " + e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Token sudah expired")).build();
        } catch (JwtException e) {
            _log.error("JWT error: " + e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Token tidak valid")).build();
        } catch (Exception e) {
            _log.error("Error in getBanner: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error retrieving profile: " + e.getMessage())).build();
        }
        
    }
    
    private String createErrorResponse(String message) {
        JSONObject response = JSONFactoryUtil.createJSONObject();
        response.put("status", 0);
        response.put("message", message);
        JSONObject data = JSONFactoryUtil.createJSONObject();
        response.put("data", data);
        return response.toString();
    }

    @Reference
    private FragmentEntryLocalService fragmentEntryLocalService;
}