package com.mypage.agencyportal.application.mobileapps;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.crypto.SecretKey;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

/**
 * Authentication endpoint for JWT token generation.
 */
@Component(
    property = {
        "osgi.jaxrs.application.base=/auth",
        "osgi.jaxrs.name=Auth.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)

@Path("/v2")
public class AuthApplication extends Application {
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilterHelper.class);
        return classes;
    }
    
    
    private static final Log _log = LogFactoryUtil.getLog(AuthApplication.class);
    private JwtKeyService _jwtKeyService;
    
    @Reference
    protected void setJwtKeyService(JwtKeyService jwtKeyService) {
        this._jwtKeyService = jwtKeyService;
        _log.info("JwtKeyService has been injected into AuthApplication");
    }

    private static final long ACCESS_TOKEN_VALIDITY = 1000L * 60 * 30; // 30 minutes
    private static final long REFRESH_TOKEN_VALIDITY = 1000L * 60 * 60 * 24 * 7; // 7 days
    

    /**
     * V2 BY SAFAR
     */ 
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String requestBody) {
    	
        try {
        	System.out.println("requestBody>>"+requestBody);
            JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

            if (!jsonRequest.has("mcd") || !jsonRequest.has("mtk")) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(createErrorResponse("mcd and mtk are required"))
                    .build();
            }

            // Buat JSON buat kirim ke Pimcore
            JSONObject pimcoreRequest = JSONFactoryUtil.createJSONObject();
            pimcoreRequest.put("mcd", jsonRequest.getString("mcd"));
            pimcoreRequest.put("mtk", jsonRequest.getString("mtk"));

            // Kirim ke Pimcore
            String pimcoreUrl = PIMCORE_ADDRESS + MOBILE_API_GET_TOKEN; //forward to pimcore
            System.out.println("url>>"+PIMCORE_ADDRESS + MOBILE_API_GET_TOKEN);
            String pimcoreResponseStr = sendPostToPimcore(pimcoreUrl, pimcoreRequest.toString());

            JSONObject pimcoreResponse = JSONFactoryUtil.createJSONObject(pimcoreResponseStr);

            if (pimcoreResponse.getInt("Status") != 1) {
                return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Login failed"))
                    .build();
            }
            
            // Ambil token dari Pimcore
            JSONObject data = pimcoreResponse.getJSONObject("Data");
            String token = data.getString("token");

            // Decode JWT (jika perlu)
            JSONObject decodedPayload = decodeJwtPayload(token);
            System.out.println("decodedPayload>>"+decodedPayload);
            
            String depCode = decodedPayload.getString("sub");
            System.out.println("depCode>>"+depCode);
            
            String mtoken = jsonRequest.getString("mtk");
            System.out.println("mtoken>>"+mtoken);
            
            
            JSONObject response = JSONFactoryUtil.createJSONObject();
            JSONObject responseData = JSONFactoryUtil.createJSONObject();
            
            
            // Get user details for token claims
            JSONObject userDetails =  JSONFactoryUtil.createJSONObject(); 
            
            //if agent no code
            if(depCode.equalsIgnoreCase("no-code")) {
            	
            	System.out.println("agent no code!!");
            	
            	String aud = decodedPayload.getString("aud");
            	userDetails = getUserDetailsByDeptoreCodeNoCode(depCode, aud);
            	
            }else {
            	userDetails = getUserDetailsByDeptoreCode(depCode);
                if (userDetails == null) {
                    return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(createErrorResponse("User not found"))
                        .build();
                }
            }
            
            
            SecretKey key = _jwtKeyService.getKey();
            String accessTokenInternal = generateTokenWithClaims(depCode, userDetails, ACCESS_TOKEN_VALIDITY, mtoken, key);
            String refreshToken = generateTokenWithClaims(depCode, userDetails, REFRESH_TOKEN_VALIDITY, mtoken, key);
                        
            
            // Cek kondisi khusus "no-code"
            if ("no-code".equals(depCode)) {
            	response.put("status", 1);
            	response.put("message", "no-code");
            } else {
            	response.put("status", 1);
                response.put("message", "");
            }
            
            responseData.put("access_token", accessTokenInternal);
            responseData.put("refresh_token", refreshToken);
            responseData.put("token_type", "Bearer");
            responseData.put("access_token_expires_in", ACCESS_TOKEN_VALIDITY / 1000);
            responseData.put("refresh_token_expires_in", REFRESH_TOKEN_VALIDITY / 1000);
            
            response.put("data", responseData);
                
            return Response.ok(response.toString()).build();

        } catch (Exception e) {
            _log.error("Login error", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(createErrorResponse("Error processing request: " + e.getMessage()))
                .build();
        }
    }
    
    
    
    @POST
    @Path("/refresh")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response refreshToken(String requestBody) {
        try {
            JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

            if (!jsonRequest.has("refresh_token")) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(createErrorResponse("refresh_token is required"))
                    .build();
            }

            String refreshToken = jsonRequest.getString("refresh_token");

            // Validasi dan parse token
            SecretKey key = _jwtKeyService.getKey();

            Claims claims;
            try {
                claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(refreshToken)
                    .getBody();
            } catch (JwtException e) {
                return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Invalid or expired refresh token"))
                    .build();
            }

            String depCode = claims.getSubject();
            
            
            String issPimcoreApiToken = claims.getIssuer();
            System.out.println("issPimcoreApiToken>>"+issPimcoreApiToken);

            JSONObject userDetails = getUserDetailsByDeptoreCode(depCode);
            if (userDetails == null) {
                return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("User not found"))
                    .build();
            }

            
            // Generate new access token
            String newAccessToken = generateTokenWithClaims(depCode, userDetails, ACCESS_TOKEN_VALIDITY, issPimcoreApiToken,  key);

            JSONObject response = JSONFactoryUtil.createJSONObject();
            response.put("status", 1);

            JSONObject responseData = JSONFactoryUtil.createJSONObject();
            responseData.put("access_token", newAccessToken);
            responseData.put("token_type", "Bearer");
            responseData.put("access_token_expires_in", ACCESS_TOKEN_VALIDITY / 1000);

            response.put("data", responseData);

            return Response.ok(response.toString()).build();

        } catch (Exception e) {
            _log.error("Refresh token error", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(createErrorResponse("Error processing request: " + e.getMessage()))
                .build();
        }
    }

    
    
    private String generateTokenWithClaims(String email, JSONObject userDetails, long validity, String mtoken, SecretKey key) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + validity);

        return Jwts.builder()
            .setId(UUID.randomUUID().toString())
            .setSubject(email)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .setNotBefore(now)
            .claim("userId", userDetails.getLong("id"))
            .claim("name", userDetails.getString("name"))
            .claim("deptCode", userDetails.getString("deptCode"))
            .claim("agentCode", userDetails.getString("agentCode"))
            .claim("agentFlag", userDetails.getString("agentFlag"))
            .claim("statusAgent", userDetails.getString("statusAgent"))
            .setAudience("agencyportal")
            .setIssuer(mtoken)
            .signWith(key)
            .compact();
    }
    
    private String sendPostToPimcore(String url, String jsonBody) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        return response.toString();
    }

    private JSONObject decodeJwtPayload(String jwt) throws Exception {
        String[] parts = jwt.split("\\.");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid JWT token format");
        }

        String payload = parts[1];
        byte[] decodedBytes = Base64.getUrlDecoder().decode(payload);
        String decodedJson = new String(decodedBytes, StandardCharsets.UTF_8);

        return JSONFactoryUtil.createJSONObject(decodedJson);
    }
    
    
    private JSONObject getUserDetailsByDeptoreCode(String deptoreCode) {
    	
    	MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);
    	
        try {
        	
        	if(user != null) {

                JSONObject userDetails = JSONFactoryUtil.createJSONObject();
                
                userDetails.put("id", user.getMypageUserId());
                userDetails.put("name", user.getUserName());
                userDetails.put("deptCode", user.getDeptoreCode());
                userDetails.put("agentCode", user.getCode());
                userDetails.put("agentFlag", user.getAgentFlag());
                userDetails.put("statusAgent", user.getStatusAgent());
                userDetails.put("email", user.getEmail());
                return userDetails;
        	}
        	
            return null;
        } catch (Exception e) {
            _log.error("Error getting user details: " + e.getMessage(), e);
            return null;
        } 
    }
    
    private JSONObject getUserDetailsByDeptoreCodeNoCode(String sub, String aud) {
        try {
            JSONObject userDetails = JSONFactoryUtil.createJSONObject();

            userDetails.put("id", "");
            userDetails.put("name", aud);
            userDetails.put("deptCode", sub);
            userDetails.put("agentCode", aud);
            userDetails.put("agentFlag", "");
            userDetails.put("statusAgent", "");
            userDetails.put("email", "");

            return userDetails;
        } catch (Exception e) {
            _log.error("Error getting user details: " + e.getMessage(), e);
            return null;
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
    
    
    private static final ActionHelpers helpers = new ActionHelpers();
	
	private static final String PIMCORE_ADDRESS = helpers.getConfig("com.mypage.agent.config.pimcoreAddress"); // untuk
																												// api
	private static final String MOBILE_API_GET_TOKEN = helpers.getConfig("com.mypage.agent.config.mobileApi.token");
	
}
