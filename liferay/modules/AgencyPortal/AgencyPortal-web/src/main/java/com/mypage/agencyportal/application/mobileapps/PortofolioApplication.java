package com.mypage.agencyportal.application.mobileapps;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.dto.APIResponse;
import com.mypage.agencyportal.dto.BodyDto;
import com.mypage.agencyportal.dto.CustomerInformationDto;
import com.mypage.agencyportal.dto.DataItemDto;
import com.mypage.agencyportal.dto.DeleteResponseDto;
import com.mypage.agencyportal.dto.HasNameValueDto;
import com.mypage.agencyportal.dto.PartyDetailsDto;
import com.mypage.agencyportal.dto.PolicyDto;
import com.mypage.agencyportal.dto.PolicySummaryDto;
import com.mypage.agencyportal.dto.ResponseDto;
import com.mypage.agencyportal.dto.ResponseTransaksiKeseluruhanDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.crypto.SecretKey;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
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
 * REST API endpoint for Calendar.
 */
@Component(
	    property = {
	        "osgi.jaxrs.application.base=/portofolio",
	        "osgi.jaxrs.name=Portofolio.Rest",
	        "auth.verifier.guest.allowed=true",
	        "liferay.access.control.disable=true"
	    },
	    service = Application.class
	)

@Path("/v2")
public class PortofolioApplication extends Application {
	
	private static String apiURL;
	private static String agencyBinderNo;
	private static String bodyOperation;
	private static String bodyService;
	
   
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

	private static final Log _log = LogFactoryUtil.getLog(PortofolioApplication.class);
	private JwtKeyService _jwtKeyService;

	@Reference
	protected void setJwtKeyService(JwtKeyService jwtKeyService) {
		this._jwtKeyService = jwtKeyService;
		_log.info("JwtKeyService has been injected into PortofolioApplication");
	}

	/**
	 *
	 * GET DATA TRANSACTION ONLINE
	 * forward to pc -> http://localhost/dashboard/api/agency/get-leads
	 * GET DATA POSSIBLE TO ALL AND FILTER
	 * 
	 */
	@POST
	@Path("/online")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionOnline(@HeaderParam("Authorization") String authHeader, @HeaderParam("X-MOBILE-TOKEN") String mToken,  String requestBody) {
	    _log.info("[PortofolioApplication] Get data transaction endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        // Check and parse request body
	        JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

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
	        
	        if (!jsonRequest.has("start")) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(createErrorResponse("start param is required"))
                    .build();
            }
			
	        // --- Extract request parameters ---
	        String startStr = jsonRequest.getString("start");
	        String limitStr = jsonRequest.getString("limit");

	        String referenceNumber = jsonRequest.getString("referenceNumber");
	        String name = jsonRequest.getString("name");
	        String products = jsonRequest.getString("products");
	        String policyType = jsonRequest.getString("policyType");
	        String state = jsonRequest.getString("state");
	        String startDateStr = jsonRequest.getString("startDate");
	        String endDateStr = jsonRequest.getString("endDate");

	        
	        String encodeToken = mtoken;

	        // --- Parse start & limit with default 0 ---
	        int start = 0;
	        int limit = 0;

	        try {
	            start = startStr.trim().isEmpty() ? 0 : Integer.parseInt(startStr.trim());
	        } catch (NumberFormatException e) {
	            _log.warn("Invalid start value: " + startStr + ", defaulting to 0");
	        }

	        try {
	            limit = limitStr.trim().isEmpty() ? 0 : Integer.parseInt(limitStr.trim());
	        } catch (NumberFormatException e) {
	            _log.warn("Invalid limit value: " + limitStr + ", defaulting to 0");
	        }

	        int page = (limit != 0) ? (start / limit + 1) : 1;

	        // --- Build post data ---
	        StringBuilder postDataBuilder = new StringBuilder();
	        postDataBuilder.append("Code=").append(deptoreCode)
	                       .append("&Start=").append(start)
	                       .append("&Limit=").append(limit)
	        			   .append("&md=").append(MD_PARAM);

	        if (!referenceNumber.isEmpty()) postDataBuilder.append("&ReferenceNumber=").append(referenceNumber);
	        if (!name.isEmpty()) postDataBuilder.append("&Name=").append(name);
	        if (!products.isEmpty()) postDataBuilder.append("&Product=").append(products);
	        if (!policyType.isEmpty()) postDataBuilder.append("&PolicyType=").append(policyType);
	        if (!state.isEmpty()) postDataBuilder.append("&Status=").append(state);

	        // --- Format tanggal ---
	        SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
	        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");

	        if (!startDateStr.isEmpty()) {
	            try {
	                Date date = inputFormat.parse(startDateStr);
	                postDataBuilder.append("&StartDate=").append(outputFormat.format(date));
	            } catch (ParseException e) {
	                _log.warn("Invalid startDate format: " + startDateStr);
	            }
	        }

	        if (!endDateStr.isEmpty()) {
	            try {
	                Date date = inputFormat.parse(endDateStr);
	                postDataBuilder.append("&EndDate=").append(outputFormat.format(date));
	            } catch (ParseException e) {
	                _log.warn("Invalid endDate format: " + endDateStr);
	            }
	        }

	        String postData = postDataBuilder.toString();
	        if (helpers.isLog()) _log.info(postData);

	        // --- Call API ---
	        URI uriLeads = new URI(PIMCORE_ADDRESS + dashboardApiAgencyLeadsUrl);
	        String URLleads = uriLeads.toString();
	        byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);

	        Gson gson = new Gson();
	        APIResponse<DataItemDto> response = helpers.APIClients(URLleads, postDataBytes, DataItemDto.class, encodeToken);

	        if (helpers.isLog()) _log.info("Pimcore response >>> " + gson.toJson(response));

	        // --- Encrypt OID for each data item ---
	        if (Integer.valueOf(response.getStatus()) >= 1) {
	        	
	            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.ENGLISH);
	            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta")); // Set zona waktu Jakarta

	            for (DataItemDto item : response.getData()) {
	                // Encrypt OID
	                //String encryptOid = EncryptionHelper.encryptRandom(String.valueOf(item.getO_id()));
	                //item.setTarget(encryptOid);

	                // Convert transactionDate to epoch millis
	                String dateStr = item.getTransactionDate();
	                if (dateStr != null && !dateStr.trim().isEmpty()) {
	                    try {
	                        Date parsedDate = sdf.parse(dateStr.trim());
	                        long epochMillis = parsedDate.getTime();
	                        //System.out.println("Epoch time (Jakarta): " + epochMillis);
	                        item.setTransactionDate(String.valueOf(epochMillis));
	                    } catch (ParseException e) {
	                        System.err.println("Failed to parse transactionDate: " + dateStr);
	                    }
	                }

	            }
	        } else {
	        	
	        	_log.warn("API response status: " + response.getStatus());
	            _log.warn("API response error: " + response.getMessage());
	            
	 	        
	 	        if(response.getMessage().equalsIgnoreCase("Not authorized") || response.getMessage().equalsIgnoreCase("Need authorized")) { //respon pimcore = Not authorized jika token not valid
		        	 _log.error("[PortofolioApplication] Mobile Token is not valid");
		 	        return Response.status(Response.Status.UNAUTHORIZED)
		 	                .entity(createErrorResponse("Mobile Token is not valid")).build();
		        }
	        }
	        

	        // --- Build JSON response ---
	        JSONObject responseJson = JSONFactoryUtil.createJSONObject();
	        JSONObject dataJson = JSONFactoryUtil.createJSONObject();

	        dataJson.put("start", start);
	        dataJson.put("page", page);
	        dataJson.put("totalData", response.getCount());
	        dataJson.put("leads", response.getData());

	        responseJson.put("status", 1);
	        responseJson.put("message", "success get leads");
	        responseJson.put("data", dataJson);

	        _log.info("[PortofolioApplication] Successfully retrieved leads online");
	        return Response.ok(responseJson.toString()).build();

	        

	    } catch (ExpiredJwtException e) {
	        _log.error("[PortofolioApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[PortofolioApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[PortofolioApplication] Error retrieving portoflio: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error retrieving portoflio: " + e.getMessage())).build();
	    }
	}
	
	
	/**
	 *
	 * API FOR UNPUBLISH LEADS
	 * forward to pc -> http://localhost/dashboard/api/agency/unpublish-leads
	
	 * 
	 */
	@POST
	@Path("/online/unpublish")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response unpublishLeads(@HeaderParam("Authorization") String authHeader, @HeaderParam("X-MOBILE-TOKEN") String mToken,  String requestBody) {
	    _log.info("[PortofolioApplication] unpublish endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        // Check and parse request body
	        JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

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


	        if (expiration == null || expiration.before(new Date())) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Token invalid atau sudah expired")).build();
	        }
	        
			
	        String LeadsIds = jsonRequest.getString("LeadsId"); //bisa array

	        String encodeToken = mtoken;

	        Gson gson = new Gson();
			String leadsUnpublishPayload = "";

			HashMap<String, Object> _leadsUnpublishPayload = new HashMap<>();

			_leadsUnpublishPayload.put("Code", deptoreCode);
			_leadsUnpublishPayload.put("LeadsId", String.join(",", LeadsIds));
			_leadsUnpublishPayload.put("md", MD_PARAM);
			
			
			leadsUnpublishPayload = gson.toJson(_leadsUnpublishPayload);
			if (helpers.isLog()) _log.info(leadsUnpublishPayload);

			JSONObject leadsUnpublishResponse = ActionHelpers.hitAPI(PIMCORE_ADDRESS + dashboardApiAgencyLeadsDeleteUrl, leadsUnpublishPayload, encodeToken);
			
			if (helpers.isLog()) _log.info(leadsUnpublishResponse.get("response").toString());
			
			// Mengonversi respons menjadi JSONObject
			JSONObject responseJson = JSONFactoryUtil.createJSONObject(leadsUnpublishResponse.get("response").toString());

			// Mengambil status dari respons JSON
			String status = responseJson.getString("Status");
			JSONObject _response = JSONFactoryUtil.createJSONObject();
			
			if(status.equals("0")) {
				_response.put("status", 0);
				_response.put("data", new ArrayList<>());
				_response.put("message", responseJson.getString("Message"));
				
				return Response.ok(_response.toString()).build();
			}

			DeleteResponseDto leadsUnpublishAPIResponseDto = new Gson().fromJson(leadsUnpublishResponse.get("response").toString(), DeleteResponseDto.class);
			
			if (helpers.isLog()) _log.info("response"+gson.toJson(leadsUnpublishAPIResponseDto));

			JSONObject dataJson = JSONFactoryUtil.createJSONObject();
			dataJson.put("total", leadsUnpublishAPIResponseDto.getData().getTotal());
			
			_response.put("status", leadsUnpublishAPIResponseDto.getStatus());
			_response.put("message", "success unpublish leads");
			_response.put("data", dataJson);

			_log.info("[PortofolioApplication] Successfully unpublish leads online");
	        return Response.ok(_response.toString()).build();

	        

	    } catch (ExpiredJwtException e) {
	        _log.error("[PortofolioApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[PortofolioApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[PortofolioApplication] Error unpublish portoflio: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error unpublish portoflio: " + e.getMessage())).build();
	    }
	}
	
	
	@POST
	@Path("/online/detail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionOnlineDetail(@HeaderParam("Authorization") String authHeader, @HeaderParam("X-MOBILE-TOKEN") String mToken, String requestBody) {
	    _log.info("[PortofolioApplication] Get data transaction endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        // Check and parse request body
	        JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

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
			
	        
	        if (!jsonRequest.has("referenceNumber")) {
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(createErrorResponse("referenceNumber is required"))
                    .build();
            }
	        
	        
	        String referenceNumber = jsonRequest.getString("referenceNumber");
	        String encodeToken = mtoken;

	        JSONObject responseJson = JSONFactoryUtil.createJSONObject();
	        JSONObject dataJson = JSONFactoryUtil.createJSONObject();
	        JSONObject leadJson = JSONFactoryUtil.createJSONObject();
	        
	        String reqPayloadString = "";
	        HashMap<String, Object> reqpayload = new HashMap<String, Object>();
	        reqpayload.put("ReferenceNumber", referenceNumber);
	        reqpayload.put("Code", deptoreCode);
	        reqpayload.put("md", MD_PARAM);
	        
	        Gson gson = new Gson();
	        // Konversi payload ke JSON string
	        reqPayloadString = gson.toJson(reqpayload);

	        // Panggil API
	        JSONObject detailsLeadsResponse = ActionHelpers.hitAPI(PIMCORE_ADDRESS + dashboardApiAgencyDetailsLeadsUrl, reqPayloadString, encodeToken);

	        // Ambil hasil dari key "response" dan parse jadi JSONObject
	        String responseBodyStr = detailsLeadsResponse.getString("response");
	        int statusCode = detailsLeadsResponse.getInt("statusCode");

	        if (helpers.isLog()) _log.info("Pimcore response >>> " + gson.toJson(detailsLeadsResponse));
	        
	        if (statusCode == 200) {
	            try {
	            	
	            	leadJson = JSONFactoryUtil.createJSONObject(responseBodyStr);
	            	
	            	System.out.println("jo leadJson" + leadJson);
	            	
	            	if(leadJson.getString("Message").equalsIgnoreCase("Not authorized") || leadJson.getString("Message").equalsIgnoreCase("Need authorized")) { //respon pimcore = Not authorized jika token not valid
			        	 _log.error("[PortofolioApplication] Mobile Token is not valid");
			 	        //return Response.status(Response.Status.UNAUTHORIZED)
			 	        //        .entity(createErrorResponse(leadJson.getString("Message"))).build();
			 	        
			 	       return Response.status(Response.Status.UNAUTHORIZED)
			 	                .entity(createErrorResponse("Mobile Token is not valid")).build();
			        }
	            	
	               
	            } catch (Exception e) {
	                _log.error("Failed parsing lead detail response", e);
	                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	    	                .entity(createErrorResponse("Failed parsing lead detail response : " + e)).build();
	            }
	        } else {
	            _log.error("Failed call API get-leads-detail. Status: " + statusCode);
	            return Response.status(Response.Status.BAD_REQUEST)
    	                .entity(createErrorResponse("Failed call API get-leads-detail. Status: " + statusCode)).build();
	        }

	        dataJson.put("lead", leadJson);
	        
	        responseJson.put("status", 1);
	        responseJson.put("message", "success get lead detail");
	        responseJson.put("data", dataJson);

	        _log.info("[PortofolioApplication] Successfully retrieved leads online");
	        return Response.ok(responseJson.toString()).build();

	        

	    } catch (ExpiredJwtException e) {
	        _log.error("[PortofolioApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[PortofolioApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[PortofolioApplication] Error retrieving portoflio: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error retrieving portoflio: " + e.getMessage())).build();
	    }
	}
	
	/**
	 * fungsi untuk download file
	 * @param authHeader
	 * @param mToken
	 * @param requestBody
	 * @return file xls
	 */
	@POST
	@Path("/online/download")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/vnd.ms-excel")
	public Response downloadTrxOnline(@HeaderParam("Authorization") String authHeader, @HeaderParam("X-MOBILE-TOKEN") String mToken, String requestBody) {
	    _log.info("[PortofolioApplication] download transaction endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

	        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Missing or invalid Authorization header")).build();
	        }

	        if (mToken == null) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Missing or invalid X-MOBILE-TOKEN header")).build();
	        }

	        String jwtToken = authHeader.substring(BEARER_PREFIX.length());

	        SecretKey key = _jwtKeyService.getKey();
	        Claims claims = Jwts.parserBuilder()
	                .setSigningKey(key)
	                .build()
	                .parseClaimsJws(jwtToken)
	                .getBody();

	        String deptoreCode = claims.getSubject();
	        Date expiration = claims.getExpiration();

	        if (expiration == null || expiration.before(new Date())) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Token invalid atau sudah expired")).build();
	        }

	        MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);

	        if (user == null) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("User not found")).build();
	        }

	        if (!jsonRequest.has("start")) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity(createErrorResponse("start param is required")).build();
	        }

	        String startStr = jsonRequest.getString("start");
	        String limitStr = jsonRequest.getString("limit");

	        String referenceNumber = jsonRequest.getString("referenceNumber");
	        String name = jsonRequest.getString("name");
	        String products = jsonRequest.getString("products");
	        String policyType = jsonRequest.getString("policyType");
	        String state = jsonRequest.getString("state");
	        String startDateStr = jsonRequest.getString("startDate");
	        String endDateStr = jsonRequest.getString("endDate");

	        int start = 0, limit = 0;

	        try {
	            start = startStr.trim().isEmpty() ? 0 : Integer.parseInt(startStr.trim());
	        } catch (NumberFormatException e) {
	            _log.warn("Invalid start value: " + startStr + ", defaulting to 0");
	        }

	        try {
	            limit = limitStr.trim().isEmpty() ? 0 : Integer.parseInt(limitStr.trim());
	        } catch (NumberFormatException e) {
	            _log.warn("Invalid limit value: " + limitStr + ", defaulting to 0");
	        }

	        StringBuilder postDataBuilder = new StringBuilder();
	        postDataBuilder.append("Code=").append(deptoreCode)
	                       .append("&Start=").append(start)
	                       .append("&Limit=").append(limit)
	                       .append("&md=").append(MD_PARAM);

	        if (!referenceNumber.isEmpty()) postDataBuilder.append("&ReferenceNumber=").append(referenceNumber);
	        if (!name.isEmpty()) postDataBuilder.append("&Name=").append(name);
	        if (!products.isEmpty()) postDataBuilder.append("&Product=").append(products);
	        if (!policyType.isEmpty()) postDataBuilder.append("&PolicyType=").append(policyType);
	        if (!state.isEmpty()) postDataBuilder.append("&Status=").append(state);

	        SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
	        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");

	        Calendar calendar = Calendar.getInstance();
	        Date endDateDefault = calendar.getTime();

	        //get 3 bulan terakhir jika param date null
	        calendar.add(Calendar.MONTH, -3);
	        Date startDateDefault = calendar.getTime();

	        try {
	            Date startDate = startDateStr.isEmpty() ? startDateDefault : inputFormat.parse(startDateStr);
	            postDataBuilder.append("&StartDate=").append(outputFormat.format(startDate));
	        } catch (ParseException e) {
	            _log.warn("Invalid startDate format: " + startDateStr);
	        }

	        try {
	            Date endDate = endDateStr.isEmpty() ? endDateDefault : inputFormat.parse(endDateStr);
	            postDataBuilder.append("&EndDate=").append(outputFormat.format(endDate));
	        } catch (ParseException e) {
	            _log.warn("Invalid endDate format: " + endDateStr);
	        }

	        String postData = postDataBuilder.toString();
	        if (helpers.isLog()) _log.info(postData);

	        URI uriDownload = new URI(PIMCORE_ADDRESS + dashboardApiAgencyDownloadReport);
	        URL url = uriDownload.toURL();
	        HttpURLConnection connection;

	        if (url.getProtocol().equalsIgnoreCase("https")) {
	            HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
	            httpsConnection.setHostnameVerifier((requestedHost, session) -> true);

	            SSLContext sslContext = SSLContext.getInstance("TLS");
	            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
	                public void checkClientTrusted(X509Certificate[] chain, String authType) {}
	                public void checkServerTrusted(X509Certificate[] chain, String authType) {}
	                public X509Certificate[] getAcceptedIssuers() { return null; }
	            }}, new SecureRandom());

	            httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
	            connection = httpsConnection;
	        } else {
	            connection = (HttpURLConnection) url.openConnection();
	        }

	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Authorization", mToken);
	        connection.setDoOutput(true);

	        try (OutputStream os = connection.getOutputStream()) {
	            os.write(postData.getBytes(StandardCharsets.UTF_8));
	        }

	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            InputStream inputStream = connection.getInputStream();
	            //byte[] fileBytes = inputStream.readAllBytes();
	            
	            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	            byte[] data = new byte[1024];
	            int nRead;
	            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
	                buffer.write(data, 0, nRead);
	            }
	            buffer.flush();
	            byte[] fileBytes = buffer.toByteArray();
	            
	            _log.error("Download API returned file successfully");
	            
	            return Response.ok(fileBytes)
	                    .header("Content-Disposition", "attachment; filename=report.xls")
	                    .header("Content-Type", "application/vnd.ms-excel")
	                    .build();
	            
	        } else {
	            _log.error("Download API returned non-OK: " + connection.getResponseCode());
	            return Response.status(Response.Status.BAD_GATEWAY)
	                    .entity(createErrorResponse("Failed to download file")).build();
	        }

	    } catch (ExpiredJwtException e) {
	        _log.error("Token expired", e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("JWT error", e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("Unexpected error", e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Terjadi kesalahan: " + e.getMessage())).build();
	    }
	}
	
	
	
	/**
	 * API KIRIM ULANG PENAWARAN. forward to pimcore
	 * @param authHeader
	 * @param mToken
	 * @param requestBody
	 * @return
	 */
	@POST
	@Path("/resend-quotation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response resendQuotation(@HeaderParam("Authorization") String authHeader, @HeaderParam("X-MOBILE-TOKEN") String mToken, String requestBody) {
	    _log.info("[PortofolioApplication] Resend quotation endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        // Check and parse request body
	        JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

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

	        if (expiration == null || expiration.before(new Date())) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("Token invalid atau sudah expired")).build();
	        }

	        MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);

	        if (user == null) {
	            return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("User not found")).build();
	        }

	        if (!jsonRequest.has("referenceNumber")) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity(createErrorResponse("referenceNumber is required")).build();
	        }

	        String referenceNumber = jsonRequest.getString("referenceNumber");
	        String type = jsonRequest.has("type") ? jsonRequest.getString("type") : "";

	        // Build payload
	        JSONObject payload = JSONFactoryUtil.createJSONObject();
	        payload.put("Code", deptoreCode);
	        payload.put("ReferenceNumber", referenceNumber);
	        payload.put("md", MD_PARAM);
	        
	        if (!type.isEmpty()) {
	            payload.put("Type", type);
	        }
	        
	        if (helpers.isLog()) _log.info("payload request>>" +  payload.toString());

	        // Call API
	        JSONObject pimcoreResponse = ActionHelpers.hitAPI(PIMCORE_ADDRESS + dashboardApiAgencyLeadsResendQuotationUrl, payload.toString(), mToken);

	        if (helpers.isLog()) _log.info("pimcore response>>" +  pimcoreResponse.toString());

	        JSONObject responseObject = JSONFactoryUtil.createJSONObject(pimcoreResponse.get("response").toString());

	        if (helpers.isLog()) _log.info("pimcore response.response>>" + responseObject);

	        if (responseObject.getInt("Status") == 0) {
	        	if (helpers.isLog()) _log.info("pimcore response.Message>>" + responseObject.getString("Message"));
	            return Response.status(Response.Status.BAD_REQUEST)
	                    .entity(createErrorResponse(responseObject.getString("Message"))).build();
	        }

	        // Success
	        JSONObject responseJson = JSONFactoryUtil.createJSONObject();
	        
	        responseJson.put("status", 1);
	        responseJson.put("message", responseObject.getString("Message"));
	        responseJson.put("data", responseObject);

	        _log.info("[PortofolioApplication] Successfully resend quote");
	        return Response.ok(responseJson.toString()).build();

	    } catch (ExpiredJwtException e) {
	        _log.error("[PortofolioApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[PortofolioApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[PortofolioApplication] Error resend quote: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error resend quote: " + e.getMessage())).build();
	    }
	}

	
	
	/**
	 * 
	 * @param authHeader
	 * @param requestBody body request purchaseStartDate and purchaseEndDate
	 * @return liferay forward to eg:  https://prodapwsg.axa-tech.com:10443/prod/id/eip/rest/invoke/PolicyManagementR-id-v2/1.0/
	 */
	@POST
	//@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionAll(@HeaderParam("Authorization") String authHeader, String requestBody) {
	    _log.info("[PortofolioApplication] Get data transaction All endpoint called");

	    final String BEARER_PREFIX = "Bearer ";

	    try {
	        // Check and parse request body
	        JSONObject jsonRequest = JSONFactoryUtil.createJSONObject(requestBody);

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
			
	        // --- Extract request parameters ---
	        String startStr = jsonRequest.getString("start");
	        String limitStr = jsonRequest.getString("limit");

	        String policyNumber = jsonRequest.getString("policyNumber");
	        String name = jsonRequest.getString("name");
	        String products = jsonRequest.getString("products");
	        
	        String startDateStr = jsonRequest.getString("purchaseStartDate");
	        String endDateStr = jsonRequest.getString("purchaseEndDate");


	        // --- Parse start & limit with default 0 ---
	        int start = 0;
	        int limit = 0;

	        try {
	            start = startStr.trim().isEmpty() ? 0 : Integer.parseInt(startStr.trim());
	        } catch (NumberFormatException e) {
	            _log.warn("Invalid start value: " + startStr + ", defaulting to 0");
	        }

	        try {
	            limit = limitStr.trim().isEmpty() ? 0 : Integer.parseInt(limitStr.trim());
	        } catch (NumberFormatException e) {
	            _log.warn("Invalid limit value: " + limitStr + ", defaulting to 0");
	        }

	        int page = (limit != 0) ? (start / limit + 1) : 1;

	        // --- Build post data ---
	        StringBuilder postDataBuilder = new StringBuilder();
	        postDataBuilder.append("Code=").append(deptoreCode)
	                       .append("&Start=").append(start)
	                       .append("&Limit=").append(limit);

	        if (!policyNumber.isEmpty()) postDataBuilder.append("&policyNumber=").append(policyNumber);
	        if (!name.isEmpty()) postDataBuilder.append("&Name=").append(name);
	        if (!products.isEmpty()) postDataBuilder.append("&Product=").append(products);
	        
	        
	        //GET BINDER
	        agencyBinderNo = getBinderNumber(deptoreCode, httpRequest);
	        
	        // --- Format tanggal ---
	        SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
	        SimpleDateFormat outputFormat2 = new SimpleDateFormat("yyyy-MM-dd");

	        String _validFromDttmFormatted = "";
			String _validToDttmformatted = "";
	        
	        if (!startDateStr.isEmpty()) {
	            try {
	                Date date = inputFormat.parse(startDateStr);
	                _validFromDttmFormatted = outputFormat2.format(date);
	            } catch (ParseException e) {
	                _log.warn("Invalid startDate format: " + startDateStr);
	            }
	        }

	        if (!endDateStr.isEmpty()) {
	            try {
	                Date date = inputFormat.parse(endDateStr);
	                _validToDttmformatted = outputFormat2.format(date);
	            } catch (ParseException e) {
	                _log.warn("Invalid endDate format: " + endDateStr);
	            }
	        }
	        
	        
	        Gson gson = new Gson();
			
			if (helpers.isLog()) _log.info("start>> " + start);
			if (helpers.isLog()) _log.info("page>> " + page);
			if (helpers.isLog()) _log.info("validFromDttm>> " + _validFromDttmFormatted);
			if (helpers.isLog()) _log.info("validToDttm>> " + _validToDttmformatted);
			if (helpers.isLog()) _log.info("agencyBinderNo>> " + agencyBinderNo);
			
			
			List<HasNameValueDto> reqPagination = new ArrayList<>();
			reqPagination.add(new HasNameValueDto("page", String.valueOf(page)));
			reqPagination.add(new HasNameValueDto("data_perpage", String.valueOf(limit)));
			
			String jsonpag = gson.toJson(reqPagination);
	        if (helpers.isLog()) _log.info("reqPagination>> " + jsonpag);
	        
	        
	        List<PolicySummaryDto> dailies = new ArrayList<PolicySummaryDto>();
			ResponseTransaksiKeseluruhanDto keseluruhanDto = listPoliciesDaily("daily", _validFromDttmFormatted, _validToDttmformatted, reqPagination ,httpRequest);

			int total = 0;
			if (keseluruhanDto.getDatas().size() > 0) {
			    dailies.addAll(keseluruhanDto.getDatas());
			    total = keseluruhanDto.getTotalData();
			}
			
			//set epoch time			
			for (PolicySummaryDto dto : dailies) {
			    long effectiveMillis = convertToEpochMillis(dto.getPolicyEffectiveDTTM());
			    long expirationMillis = convertToEpochMillis(dto.getPolicyExpirationDTTM());

			    // Untuk issueDt dengan zona waktu Jakarta
			    LocalDate issueDate = LocalDate.parse(dto.getIssueDt());
			    Instant issueInstant = issueDate.atStartOfDay(ZoneId.of("Asia/Jakarta")).toInstant();
			    long issueDateMillis = issueInstant.toEpochMilli();

			    dto.setPolicyEffectiveDTTMEpoch(effectiveMillis);
			    dto.setPolicyExpirationDTTMEpoch(expirationMillis);
			    dto.setIssueDtEpoch(issueDateMillis);
			}


			String ResponseTransaksiKeseluruhanDto = gson.toJson(keseluruhanDto);
	        String json = gson.toJson(dailies);
	        if (helpers.isLog()) _log.info("ResponseTransaksiKeseluruhanDto>> " + ResponseTransaksiKeseluruhanDto);
	        if (helpers.isLog()) _log.info("data>> " + json);
	        if (helpers.isLog()) _log.info("total data final>>" + total);
			

	        String postData = postDataBuilder.toString();
	        if (helpers.isLog()) _log.info(postData);


	        // --- Build JSON response ---
	        JSONObject responseJson = JSONFactoryUtil.createJSONObject();
	        JSONObject dataJson = JSONFactoryUtil.createJSONObject();

	        dataJson.put("start", start);
	        dataJson.put("page", page);
	        dataJson.put("totalData", total);
	        dataJson.put("leads", dailies);

	        responseJson.put("status", 1);
	        responseJson.put("message", "success get leads daily");
	        responseJson.put("data", dataJson);

	        _log.info("[PortofolioApplication] Successfully retrieved leads daily");
	        return Response.ok(responseJson.toString()).build();

	        

	    } catch (ExpiredJwtException e) {
	        _log.error("[PortofolioApplication] Token expired: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token sudah expired")).build();
	    } catch (JwtException e) {
	        _log.error("[PortofolioApplication] JWT error: " + e.getMessage(), e);
	        return Response.status(Response.Status.UNAUTHORIZED)
	                .entity(createErrorResponse("Token tidak valid")).build();
	    } catch (Exception e) {
	        _log.error("[PortofolioApplication] Error retrieving portofolio all: " + e.getMessage(), e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(createErrorResponse("Error retrieving portofolio all: " + e.getMessage())).build();
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
	
	public static long convertToEpochMillis(Date date) {
	    return date.toInstant().atZone(ZoneId.of("Asia/Jakarta")).toInstant().toEpochMilli();
	}

	
	protected ResponseTransaksiKeseluruhanDto listPoliciesDaily(String dataCategory, String startDate, String endDate, List<HasNameValueDto> hasNameValueDtoReq, HttpServletRequest httpRequest) throws Exception {
	    List<PolicyDto> bodyPolicies = new ArrayList<>();
	    PolicyDto bodyPolicy = new PolicyDto();
	    
	    bodyOperation = "getDailyAgent";
	    bodyService = "getPolicyList";

	    BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);

	    bodyPolicy.setAgencyBinderNo(agencyBinderNo);
	    bodyPolicy.setValidFromDttm(startDate);
	    bodyPolicy.setValidToDttm(endDate);
	    bodyPolicy.setHasNameValueDtos(hasNameValueDtoReq);
	    bodyPolicies.add(bodyPolicy);

	    Gson gson = new Gson();
	    String jsonbodyPolicies = gson.toJson(bodyPolicies);
	    if (helpers.isLog()) _log.info("jsonbodyPolicies>> " + jsonbodyPolicies);
	    
	    requestBody.setPolicies(bodyPolicies);

	    String jsonbodyrequestBody = gson.toJson(requestBody);
	    if (helpers.isLog()) _log.info("jsonbodyrequestBody>> " + jsonbodyrequestBody);
	    
	    apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPolicyManagementUrl");

	    Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
	    ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
	    
	    if (helpers.isLog()) _log.info(gson.toJson(response.getBody()));
		if(Integer.valueOf(response.getStatusCode()) < 1) {
			if (helpers.isLog()) _log.info(response.getBody().getException().getMessage());
			//return;
		}
	    
	    List<PolicySummaryDto> summaryPolicies = new ArrayList<>();
	    
	    int totalData = 0;
	    if (response.getStatusCode() == 200 && response.getBody().getException().getCode() == null) {
	        List<PolicyDto> respPolicies = response.getBody().getPolicies();
	        
	        // Ambil total_data dari response pada indeks 0
	        if (respPolicies != null && !respPolicies.isEmpty()) {
	            PolicyDto firstPolicy = respPolicies.get(0);
	            List<HasNameValueDto> hasNameValueList = firstPolicy.getHasNameValueDtos();
	            
	            if (hasNameValueList != null) {
	                for (HasNameValueDto hasNameValue : hasNameValueList) {
	                    if ("total_data".equals(hasNameValue.getName())) {
	                        totalData = Integer.parseInt(hasNameValue.getValue());
	                        break;
	                    }
	                }
	            }
	        }

	        
	        for (PolicyDto policy : respPolicies) {
	            PolicySummaryDto summary = new PolicySummaryDto();
	            summary.setPolicyNO(policy.getPolicyNO());
	            summary.setApplicationRk(policy.getApplicationRk());
	            summary.setIssueDt(policy.getIssueDt());

	            // Extract fullNM from hasCustomerInformationIn
	            List<CustomerInformationDto> customers = policy.getHasCustomerInformationIn();
	            if (customers != null && !customers.isEmpty()) {
	                for (CustomerInformationDto customer : customers) {
	                    if (customer.getCanBeIndividual() !=  null) {
	                        summary.setFullNM(customer.getCanBeIndividual().getFullNM());
	                        break;
	                    }
	                }
	            }

	            summary.setInsuranceProductRk(policy.getInsuranceProductRk());
	            summary.setPolicyEffectiveDTTM(policy.getPolicyEffectiveDTTM());
	            summary.setPolicyExpirationDTTM(policy.getPolicyExpirationDTTM());
	            summary.setCurrencyCD(policy.getCurrencyCD());
	            summary.setPremiumAMT(policy.getPremiumAMT());

	            summaryPolicies.add(summary);
	        }
	        
	    } else {
	        if (helpers.isLog()) _log.info("error>>" + response.getBody().getException().getMessage());
	        // Set error response
	        ResponseTransaksiKeseluruhanDto errorResponse = new ResponseTransaksiKeseluruhanDto();
	        errorResponse.setResponseCode(response.getStatusCode());
	        errorResponse.setDatas(new ArrayList<PolicySummaryDto>()); //set data null / [] if error transaction
	        
	        errorResponse.setStatusMessage(response.getBody().getException().getMessage());
	        return errorResponse;
	    }

	    // Prepare the final response
	    ResponseTransaksiKeseluruhanDto finalResponse = new ResponseTransaksiKeseluruhanDto();
	    finalResponse.setResponseCode(response.getStatusCode());
	    finalResponse.setStatusMessage("Success");
	    finalResponse.setTotalData(totalData);
	    finalResponse.setDatas(summaryPolicies);

	    return finalResponse;
	}
	
	protected String getBinderNumber(String deptoreCode, HttpServletRequest httpRequest) throws Exception {
		PolicyDto bodyPolicy = new PolicyDto();

		bodyOperation = "getProfileAgentAlias";
		bodyService = "getAgentInfo";

		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);

		List<PartyDetailsDto> bodyPartyDetails = new ArrayList<PartyDetailsDto>();
		PartyDetailsDto bodyPartyDetail = new PartyDetailsDto();
		bodyPartyDetail.setPartyID(deptoreCode);
		bodyPartyDetails.add(bodyPartyDetail);

		bodyPolicy.setHasPartyDetailsIn(bodyPartyDetails);
		requestBody.setPolicy(bodyPolicy);

		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPartyManagementUrl");
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);

		if (response.getStatusCode() == 200) {
			agencyBinderNo = Validator
					.isNull(response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO()) == true ? ""
							: response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO();
		}

		return agencyBinderNo;
	}

	
	private static final ActionHelpers helpers = new ActionHelpers();
	
	private static final String PIMCORE_ADDRESS = helpers.getConfig("com.mypage.agent.config.pimcoreAddress"); // untuk api
	private static final String dashboardApiAgencyLeadsUrl = helpers.getConfig("dashboard.api.agency.leads");
	private static final String dashboardApiAgencyDownloadReport = helpers.getConfig("dashboard.api.agency.download.report");
	private static final String dashboardApiAgencyDetailsLeadsUrl = helpers.getConfig("dashboard.api.agency.leads.detail");
	
	private static final String dashboardApiAgencyLeadsResendQuotationUrl = helpers.getConfig("dashboard.api.agency.leads.detail.resendQuotation");
	

	private static final String dashboardApiAgencyLeadsDeleteUrl = helpers.getConfig("dashboard.api.agency.leads.delete");
	
}
