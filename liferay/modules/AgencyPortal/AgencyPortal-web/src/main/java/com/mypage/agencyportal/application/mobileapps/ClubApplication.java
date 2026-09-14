package com.mypage.agencyportal.application.mobileapps;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import com.mypage.agencyportal.dto.BodyDto;
import com.mypage.agencyportal.dto.ClubYearDto;
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
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
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
 * REST API endpoint for Club Information.
 */
@Component(
    property = {
        "osgi.jaxrs.application.base=/club",
        "osgi.jaxrs.name=Club.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
@Path("/v2")
public class ClubApplication extends Application {
	
	@Context
	private HttpServletRequest httpRequest;

	private static String apiURL;
	private static String agencyBinderNo;
	private static String bodyOperation;
	private static String bodyService;
	
	private static final String QUARTZ = "Quartz";
	private static final String JADE = "Jade";
	private static final String SAPPHIRE = "Sapphire";
	private static final String RUBY = "Ruby";
	private static final String EMERALD = "Emerald";
	private static final String DIAMOND = "Diamond";
	
	
	public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilterHelper.class);
        return classes;
    }
    
    private static final Log _log = LogFactoryUtil.getLog(ClubApplication.class);
    private JwtKeyService _jwtKeyService;
    
    @Reference
    protected void setJwtKeyService(JwtKeyService jwtKeyService) {
        this._jwtKeyService = jwtKeyService;
        _log.info("JwtKeyService has been injected into ClubApplication");
    }
    
    @GET
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClub(@HeaderParam("Authorization") String authHeader) {
        _log.info("Get Club data endpoint called");

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

            // Bind agency binder number
            agencyBinderNo = getBinderNumber(user.getDeptoreCode(), httpRequest);
            if (Validator.isNull(agencyBinderNo)) {
                _log.error("Agency binder number not found for deptCode: " + user.getDeptoreCode());
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Agency binder number not found")).build();
            }
            System.out.println("BINDER NUMBER>>" + agencyBinderNo);

            // Get profile
            ProfileAgentDto profileData = getProfile(httpRequest);
            if (profileData == null) {
                _log.error("Failed to get profile data");
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Data Profile kosong")).build();
            }
            
            System.out.println("profile >> "+ profileData);

//            // Get club year data
//            List<ClubYearDto> clubYears = getClub(httpRequest);
//            ClubYearDto clubNow = new ClubYearDto();
//
//            if (clubYears == null || clubYears.isEmpty()) {
//                clubNow.setAmount(0);
//                clubNow.setClub("No Club");
//                clubNow.setYear(0);
//                clubNow.setLastUpdate("");
//            } else {
//                // Sorting
//                Collections.sort(clubYears, Comparator.comparingInt(ClubYearDto::getYear).reversed());
//
//                ClubYearDto latestClubYear = clubYears.get(0);
//                int thisYear = YearMonth.now().getYear();
//
//                if (thisYear == latestClubYear.getYear()) {
//                    clubNow = latestClubYear;
//                } else {
//                    clubNow.setAmount(0);
//                    clubNow.setClub("No Club");
//                    clubNow.setYear(0);
//                    clubNow.setLastUpdate("");
//                }
//            }
//
//            System.out.println("club now>>" + clubNow);
//
//            Gson gson = new Gson();
//            
//            
//	        // --- Build JSON response ---
//	        JSONObject dataJson = JSONFactoryUtil.createJSONObject();
//
//	        dataJson.put("pimcoreHost", helpers.getConfig("com.mypage.agent.config.pimcoreHost"));
//	        dataJson.put("profile", JSONFactoryUtil.createJSONObject(gson.toJson(profileData)));
//	        dataJson.put("club", JSONFactoryUtil.createJSONObject(gson.toJson(clubNow)));
            
         // Get club year data
            List<ClubYearDto> clubYears = getClub(httpRequest);
            ClubYearDto clubNow = new ClubYearDto();
            ClubYearDto clubLastYear = new ClubYearDto();

            if (clubYears == null || clubYears.isEmpty()) {
                clubNow.setAmount(0);
                clubNow.setClub("No Club");
                clubNow.setYear(0);
                clubNow.setLastUpdate("");

                clubLastYear.setAmount(0);
                clubLastYear.setClub("No Club");
                clubLastYear.setYear(0);
                clubLastYear.setLastUpdate("");
            } else {
                // Sorting descending by year
                Collections.sort(clubYears, Comparator.comparingInt(ClubYearDto::getYear).reversed());

                int thisYear = YearMonth.now().getYear();
                int lastYear = thisYear - 1;

                // Ambil clubNow
                Optional<ClubYearDto> currentClubOpt = clubYears.stream()
                    .filter(c -> c.getYear() == thisYear)
                    .findFirst();

                if (currentClubOpt.isPresent()) {
                    clubNow = currentClubOpt.get();
                } else {
                    clubNow.setAmount(0);
                    clubNow.setClub("No Club");
                    clubNow.setYear(0);
                    clubNow.setLastUpdate("");
                }

                // Ambil clubLastYear
                Optional<ClubYearDto> lastYearClubOpt = clubYears.stream()
                    .filter(c -> c.getYear() == lastYear)
                    .findFirst();

                if (lastYearClubOpt.isPresent()) {
                    clubLastYear = lastYearClubOpt.get();
                } else {
                    clubLastYear.setAmount(0);
                    clubLastYear.setClub("No Club");
                    clubLastYear.setYear(0);
                    clubLastYear.setLastUpdate("");
                }
            }

            Gson gson = new Gson();
            System.out.println("club now >> " + gson.toJson(clubNow));
            System.out.println("club last year >> " + gson.toJson(clubLastYear));


            // --- Build JSON response ---
            JSONObject dataJson = JSONFactoryUtil.createJSONObject();

            dataJson.put("pimcoreHost", helpers.getConfig("com.mypage.agent.config.pimcoreHost"));
            dataJson.put("profile", JSONFactoryUtil.createJSONObject(gson.toJson(profileData)));
            dataJson.put("club", JSONFactoryUtil.createJSONObject(gson.toJson(clubNow)));
            dataJson.put("clubLastYear", JSONFactoryUtil.createJSONObject(gson.toJson(clubLastYear)));

	        JSONObject responseJson = JSONFactoryUtil.createJSONObject();
	        responseJson.put("status", 1);
	        responseJson.put("message", "Success get club");
	        responseJson.put("data", dataJson);

            return Response.ok(responseJson.toString(), MediaType.APPLICATION_JSON).build();


        } catch (ExpiredJwtException e) {
            _log.error("Token expired: " + e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Token sudah expired")).build();
        } catch (JwtException e) {
            _log.error("JWT error: " + e.getMessage(), e);
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(createErrorResponse("Token tidak valid")).build();
        } catch (Exception e) {
            _log.error("Error in getClub: " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error retrieving profile: " + e.getMessage())).build();
        }
    }

    
    
    protected ProfileAgentDto getProfile(HttpServletRequest httpRequest) throws Exception {
    	
    	_log.info("[ClubApplication] >> RUN PROFILE");
    	
        PolicyDto bodyPolicy = new PolicyDto();
        ProfileAgentDto profile = new ProfileAgentDto();

        bodyOperation = "getProfileAgent";
        bodyService = "getAgentInfo";

        BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);

        bodyPolicy.setAgencyBinderNo(agencyBinderNo);
        requestBody.setPolicy(bodyPolicy);

        String apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPartyManagementUrl");
        
        _log.info("PAYLOAD REQ AGENT PROFILE HIT AXA >> " + requestBody);
        
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
    	
    	_log.info("[ClubApplication] >> RUN BIND NUM");
    	
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
    
    
    protected List<ClubYearDto> getClub(HttpServletRequest httpRequest) throws Exception {
    	
    	_log.info("[ClubApplication] >> RUN CLUB");
    	
		List<PolicyDto> bodyPolicies = new ArrayList<PolicyDto>();
		PolicyDto bodyPolicy = new PolicyDto();
		List<ClubYearDto> clubYears = new ArrayList<ClubYearDto>();

		bodyOperation = "getClubYears";
		bodyService = "getPolicyList";

		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);
		bodyPolicy.setAgencyBinderNo(agencyBinderNo);
		bodyPolicies.add(bodyPolicy);

		requestBody.setPolicies(bodyPolicies);

		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPolicyManagementUrl");
		
		_log.info("PAYLOAD REQ CLUB HIT AXA >> " + requestBody);
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation,typeOfResponse, requestBody, httpRequest);

		if (response.getStatusCode() == 200) {
			if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getPolicies()) == true) {
				return clubYears;
			}
			
			List<PolicyDto> policies = response.getBody().getPolicies();

			for (PolicyDto policy : policies) {
				if (Validator.isNull(policy.getGeneralRk()) == true) {
					break;
				}

				ClubYearDto clubYear = new ClubYearDto();

				clubYear.setYear(Integer.parseInt(policy.getChangeEffectiveFromDttm()));
				clubYear.setLastUpdate(policy.getChangeEffectiveToDttm() == null ? ""
						: helpers.ConvertDateFormat(policy.getChangeEffectiveToDttm().toString(), "dd MMM yyy"));
				clubYear.setCurrency(policy.getCurrencyCD());
				clubYear.setClub(policy.getGeneralRk());
				clubYear.setAmount(policy.getPremiumAMT());

				clubYears.add(clubYear);
			}
		}

		return clubYears;
	}
    
    
    protected Map<String, String> targetClub(ClubYearDto clubNow, List<MasterGlobalVariable> clubs) {
		Map<String, String> datas = new HashMap<>();

		String clubType = clubNow.getClub().trim();
		
		if (clubType.equalsIgnoreCase(QUARTZ)) {
			datas = getData(clubs, JADE);
		} else if (clubType.equalsIgnoreCase(JADE)) {
			datas = getData(clubs, SAPPHIRE);
		} else if (clubType.equalsIgnoreCase(SAPPHIRE)) {
			datas = getData(clubs, RUBY);
		} else if (clubType.equalsIgnoreCase(RUBY)) {
			datas = getData(clubs, EMERALD);
		} else if (clubType.equalsIgnoreCase(EMERALD)) {
			datas = getData(clubs, DIAMOND);
		} else if (clubType.equalsIgnoreCase(DIAMOND)) {
			datas = getData(clubs, DIAMOND);
		} else {
			datas = getData(clubs, QUARTZ);
		}
		
		return datas;
	}
    
    protected Map<String, String> getData(List<MasterGlobalVariable> datas, String dataType) {
		Map<String, String> data = new HashMap<>();
		
		for (MasterGlobalVariable masterGlobalVariable : datas) {
			String name = masterGlobalVariable.getName().replaceAll(dataType, "");
			
			if (masterGlobalVariable.getName().contains(dataType)) {
				data.put(toCamelCase(name), masterGlobalVariable.getValue());
			}
		}
		return data;
	}

	public static String toCamelCase(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}

		String[] words = input.trim().split("\\s+");
		StringBuilder camelCase = new StringBuilder(words[0].toLowerCase());

		for (int i = 1; i < words.length; i++) {
			String word = words[i];
			camelCase.append(word.substring(0, 1).toUpperCase());
			if (word.length() > 1) {
				camelCase.append(word.substring(1).toLowerCase());
			}
		}

		return camelCase.toString();
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
    
    @Reference
	private MasterGlobalVariableLocalService _MasterGlobalVariableLocalService;
    

}
