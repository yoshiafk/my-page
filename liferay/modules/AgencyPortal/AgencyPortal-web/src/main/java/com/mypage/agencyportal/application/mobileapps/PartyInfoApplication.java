package com.mypage.agencyportal.application.mobileapps;

import com.google.gson.reflect.TypeToken;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.dto.BodyDto;
import com.mypage.agencyportal.dto.PartyDetailsDto;
import com.mypage.agencyportal.dto.PolicyDto;
import com.mypage.agencyportal.dto.ProfileAgentDto;
import com.mypage.agencyportal.dto.ResponseDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
 * REST API endpoint for Party Information.
 * Provides endpoint to fetch agent/party details.
 */
@Component(
    property = {
        "osgi.jaxrs.application.base=/party",
        "osgi.jaxrs.name=PartyInfo.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
@Path("/v2")
public class PartyInfoApplication extends Application {
	
	@Context
	private HttpServletRequest httpRequest;

	private static String apiURL;
	private static String agencyBinderNo;
	private static String bodyOperation;
	private static String bodyService;
	
	
	public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilterHelper.class);
        return classes;
    }
    
    private static final Log _log = LogFactoryUtil.getLog(PartyInfoApplication.class);
    private JwtKeyService _jwtKeyService;
    
    @Reference
    protected void setJwtKeyService(JwtKeyService jwtKeyService) {
        this._jwtKeyService = jwtKeyService;
        _log.info("JwtKeyService has been injected into PartyInfoApplication");
    }
    
    @GET
    @Path("/info")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgentInfo(@HeaderParam("Authorization") String authHeader) {
    	
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
            MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);
            Date expiration = claims.getExpiration();

            // Check if expired or subject invalid
            if (expiration == null || expiration.before(new Date())) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(createErrorResponse("Token invalid atau sudah expired")).build();
            }
            
            if(user == null) {
	        	return Response.status(Response.Status.UNAUTHORIZED)
	                    .entity(createErrorResponse("User not found"))
	                    .build();
	        }
            
            //bind number
            agencyBinderNo = getBinderNumber(user.getDeptoreCode(), httpRequest);
            if (Validator.isNull(agencyBinderNo)) {
                _log.error("Agency binder number not found for deptCode: " + user.getDeptoreCode());
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Agency binder number not found")).build();
            }
            System.out.println("BINDER NUMBER>>" + agencyBinderNo);

            // Token valid & user found -> fetch profile
            ProfileAgentDto profileData = getProfile(httpRequest);
            if (profileData == null) {
            	 _log.error("Failed to get profile data");
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Data Profile kosong")).build();
            }
            
            
            // Map profileData ke response
            JSONObject data = JSONFactoryUtil.createJSONObject();
            data.put("KODE_AGEN", defaultStr(profileData.getAgentCode()));
            data.put("NAMA_AGEN", defaultStr(profileData.getAgentName()));
            data.put("TANGGAL_BERGABUNG", defaultStr(profileData.getAgentJoinDate()));
            data.put("STATUS_REGISTRASI", defaultStr(profileData.getAgentRegistStatus()));
            data.put("REGIONAL", defaultStr(profileData.getAgentRegional()));
            data.put("KEPALA_REGIONAL", defaultStr(profileData.getAgentRegionalHead()));
            data.put("BDE", defaultStr(profileData.getAgentManager()));
            data.put("BRANCH", defaultStr(profileData.getBranch()));
            data.put("STATUS_KARTU_AAUI", defaultStr(profileData.getAgentAauiStatus()));

            
            return Response.ok(data.toString(), MediaType.APPLICATION_JSON).build();

        } catch (ExpiredJwtException e) {
            _log.error("Token expired: " + e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Token sudah expired")).build();
        } catch (JwtException e) {
            _log.error("JWT error: " + e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Token tidak valid")).build();
        } catch (Exception e) {
            _log.error("Error in profileData: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error retrieving profile: " + e.getMessage())).build();
        }
    }

    // Optional helper for null safety
    private String defaultStr(String input) {
        return input != null ? input : "";
    }

    
    
    protected ProfileAgentDto getProfile(HttpServletRequest httpRequest) throws Exception {
    	
    	_log.info("[PartyInfoApplication] >> RUN PROFILE");
    	
        PolicyDto bodyPolicy = new PolicyDto();
        ProfileAgentDto profile = new ProfileAgentDto();

        bodyOperation = "getProfileAgent";
        bodyService = "getAgentInfo";

        BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);

        bodyPolicy.setAgencyBinderNo(agencyBinderNo);
        requestBody.setPolicy(bodyPolicy);

        String apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPartyManagementUrl");

        _log.info("PAYLOAD REQ HIT AGENT PROFILE AXA >> " + requestBody);
        
        Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
        ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);

        if (response.getStatusCode() == 200) {
            if (Validator.isNull(response) || Validator.isNull(response.getBody())
                    || Validator.isNull(response.getBody().getPolicy())
                    || Validator.isNull(response.getBody().getPolicy().getAgencyBinderNo())) {
                return profile;
            }

            //KODE_AGEN
            profile.setAgentCode(response.getBody().getPolicy().getAgencyBinderNo());
            
            //NAMA_AGEN
            profile.setAgentName(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
                    .getHasPersonalDetailsIn().get(0).getFullNM());
            
            //TANGGAL_BERGABUNG
            profile.setAgentJoinDate(
                    response.getBody().getPolicy().getHasProducerInformationIn().get(0).getEffectiveDT() == null ? ""
                            : helpers.ConvertDateFormat(response.getBody().getPolicy().getHasProducerInformationIn()
                                    .get(0).getEffectiveDT().toString(), "dd MMM yyy"));
            
            //STATUS_REGISTRASI
            profile.setAgentRegistStatus(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
                    .getHasLicensingIInformationIn().get(0).getLicenseStatusCd());
            
            //REGIONAL
            profile.setAgentRegional(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
                    .getHasAssociationWith().get(0).getAreaCD());
            
            //KEPALA_REGIONAL
            profile.setAgentRegionalHead(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
                    .getHasAssociationWith().get(0).getHasStaffInformationIn().get(0).getBranchManagerNM());
            
            //BDE
            profile.setAgentManager(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
                    .getHasPersonalDetailsIn().get(0).getHasPartyAccountDetailsIn().getPartyAccountNM());
            
            //BRANCH REFER AGENT REGIONAL??
            profile.setBranch(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
					.getHasAssociationWith().get(0).getAreaCD());
            
            //STATUS_KARTU_AAUI
            profile.setAgentAauiStatus(
                    response.getBody().getPolicy().getHasProducerInformationIn().get(0).getProducerStatusCD());
        }

        return profile;
    }
    
    
    protected String getBinderNumber(String deptoreCode, HttpServletRequest httpRequest) throws Exception {
    	
    	_log.info("[PartyInfoApplication] >> RUN BIND NUM");
    	
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
		
		_log.info("PAYLOAD REQ BINDER NUMBER HIT AXA >> " + requestBody);
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);

		if (response.getStatusCode() == 200) {
			agencyBinderNo = Validator
					.isNull(response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO()) == true ? ""
							: response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO();
		}

		return agencyBinderNo;
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
    

}
