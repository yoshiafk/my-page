package com.mypage.agencyportal.application.mobileapps;

import com.google.gson.Gson;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

/**
 * REST API endpoint for Products.
 */
@Component(
	    property = {
	        "osgi.jaxrs.application.base=/products",
	        "osgi.jaxrs.name=Product.Rest",
	        "auth.verifier.guest.allowed=true",
	        "liferay.access.control.disable=true"
	    },
	    service = Application.class
	)

@Path("/v2")
public class ProductApplication extends Application {
	
	
   
	/**
	 * WAJIB JIKA HIT AS GET MOBILE
	 * hardcode saja, value = mapi
	 */
	private static final String MD_PARAM = "mapi";
	
	@Context
	private HttpServletRequest httpRequest;

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(CorsFilterHelper.class);
		return classes;
	}

	private static final Log _log = LogFactoryUtil.getLog(ProductApplication.class);
	private JwtKeyService _jwtKeyService;

	@Reference
	protected void setJwtKeyService(JwtKeyService jwtKeyService) {
		this._jwtKeyService = jwtKeyService;
		_log.info("JwtKeyService has been injected into ProductApplication");
	}

	/**
	 *
	 * GET DATA PRODUCT BY DEPT CODE
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductByCode(@HeaderParam("Authorization") String authHeader, @HeaderParam("X-MOBILE-TOKEN") String mToken) {
	    _log.info("[ProductApplication] Get data transaction endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {

	        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Missing or invalid Authorization header")).build();
	        }
	        
	        if (mToken == null) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Missing or invalid X-MOBILE-TOKEN header")).build();
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
	        
	        String mtoken = mToken;
            System.out.println("mtoken>>"+mtoken);

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
			
	        
	        String encodeToken = mtoken;

	        JSONObject responseJson = JSONFactoryUtil.createJSONObject();
	        JSONObject dataJson = JSONFactoryUtil.createJSONObject();
	        JSONObject leadJson = JSONFactoryUtil.createJSONObject();
	        
	        String reqPayloadString = "";
	        HashMap<String, Object> reqpayload = new HashMap<String, Object>();
	        reqpayload.put("Code", deptoreCode);
	        reqpayload.put("md", MD_PARAM);
	        
	        Gson gson = new Gson();
	        // Konversi payload ke JSON string
	        reqPayloadString = gson.toJson(reqpayload);

	        // Panggil API
	        JSONObject responseProduct = ActionHelpers.hitAPI(PIMCORE_ADDRESS + dashboardApiAgencyGetProductsUrl, reqPayloadString, encodeToken);

	        // Ambil hasil dari key "response" dan parse jadi JSONObject
	        String responseBodyStr = responseProduct.getString("response");
	        int statusCode = responseProduct.getInt("statusCode");

	        if (helpers.isLog()) _log.info("Pimcore response >>> " + gson.toJson(responseProduct));
	        
	        if (statusCode == 200) {
	            try {
	            	
	            	leadJson = JSONFactoryUtil.createJSONObject(responseBodyStr);
	            	
	            	if(leadJson.getString("Message").equalsIgnoreCase("Not authorized") || leadJson.getString("Message").equalsIgnoreCase("Need authorized")) { //respon pimcore = Not authorized jika token not valid
			        	 _log.error("[ProductApplication] Mobile Token is not valid");
			 	        return Response.status(Response.Status.UNAUTHORIZED)
			 	                .entity(createErrorResponse("Mobile Token is not valid")).build();
			        }
	            	
	               
	            } catch (Exception e) {
	                _log.error("Failed parsing products response", e);
	                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	    	                .entity(createErrorResponse("Failed parsing lead detail response : " + e)).build();
	            }
	        } else {
	            _log.error("Failed call API get-products. Status: " + statusCode);
	            return Response.status(Response.Status.BAD_REQUEST)
    	                .entity(createErrorResponse("Failed call API get-products. Status: " + statusCode)).build();
	        }

	        int total = leadJson.getInt("Count");
	        // Ambil array "Data" dari response
	        JSONArray productsArray = leadJson.getJSONArray("Data");
	        
	        dataJson.put("total", total);
	        dataJson.put("products", productsArray);

	        responseJson.put("status", 1);
	        responseJson.put("message", "success get products");
	        responseJson.put("data", dataJson);


	        _log.info("[ProductApplication] Successfully retrieved products");
	        return Response.ok(responseJson.toString()).build();

	        

	    } catch (ExpiredJwtException e) {
	        _log.error("[ProductApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[ProductApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[ProductApplication] Error retrieving products: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error retrieving products: " + e.getMessage())).build();
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
	
	private static final String PIMCORE_ADDRESS = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
	private static final String dashboardApiAgencyGetProductsUrl = helpers.getConfig("dashboard.api.agency.products");
	

}
