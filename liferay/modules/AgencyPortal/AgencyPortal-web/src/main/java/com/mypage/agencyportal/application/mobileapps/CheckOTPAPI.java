package com.mypage.agencyportal.application.mobileapps;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mypage.agencyportal.helpers.JsonResponseHelper;
import com.mypage.agencyportal.helpers.JwtAuthHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.agencyportal.helpers.SendHttpRequestToPimcore;
import com.mypage.agencyportal.helpers.JwtAuthHelper.AuthResult;


import java.util.*;

import javax.crypto.SecretKey;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component(property = {
    JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/m/send-otp",
    JaxrsWhiteboardConstants.JAX_RS_NAME + "=SendOTP.Rest",
    "auth.verifier.guest.allowed=true",
    "liferay.access.control.disable=true"
}, service = Application.class)

public class CheckOTPAPI extends Application {
    
    private static final Log _log = LogFactoryUtil.getLog(CheckOTPAPI.class);

	private static final String MOBILE_API_SEND_OTP = "/api/mapi/send-otp";

    @Override
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        return classes;
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkOTP(
        @HeaderParam("X-App-Token") String app_token,
        String requestBody
    ) {

        try {

            //extract the OTP and other parameters from the request body
            JSONObject json = JSONFactoryUtil.createJSONObject(requestBody);


            String code = json.getString("Uid");
            String otp = json.getString("Ocd");
            String email = json.getString("Email");

            if (code == null || code.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity(JsonResponseHelper.error("Code is invalid!")).build();
            }
            if (otp == null || otp.isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity(JsonResponseHelper.error("Otp is invalid!")).build();
            }

            JSONObject pimcoreRequestBody = JSONFactoryUtil.createJSONObject();
            pimcoreRequestBody.put("Uid", code);
            pimcoreRequestBody.put("Ocd", otp);
            pimcoreRequestBody.put("Email", email);



            String pimcoreResponseStr = SendHttpRequestToPimcore.post(MOBILE_API_SEND_OTP, pimcoreRequestBody.toString(), app_token);
            
            JSONObject pimcoreResponse = JSONFactoryUtil.createJSONObject(pimcoreResponseStr);
            if (pimcoreResponse.getInt("Status") != 1) {
                return Response.status(Response.Status.BAD_REQUEST).entity(JsonResponseHelper.error(pimcoreResponse.getString("Message"))).build();
            }

            String resData = pimcoreResponse.getString("Data");
            return Response.ok(JsonResponseHelper.success(resData, "OTP is valid")).build();

        }
        catch (java.io.IOException e) {
            _log.error("Error sending OTP: " + e.getMessage(), e);
            String errorMessage = e.getMessage();
            
            if (errorMessage.contains("Unauthorized")) {
                return Response.status(Response.Status.UNAUTHORIZED).entity(JsonResponseHelper.error("Pimcore-response : " +errorMessage)).build();
            } else if (errorMessage.contains("Forbidden")) {
                return Response.status(Response.Status.FORBIDDEN).entity(JsonResponseHelper.error("Pimcore-response : "+errorMessage)).build();
            } else if (errorMessage.contains("Bad Request")) {
                return Response.status(Response.Status.BAD_REQUEST).entity(JsonResponseHelper.error("Pimcore-response : "+errorMessage)).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(JsonResponseHelper.error("Pimcore-response : "+errorMessage)).build();
            }
        }
        catch (Exception e) {
            _log.error("Error validating OTP: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(JsonResponseHelper.error(e.getMessage())).build();
        }
    }

}
