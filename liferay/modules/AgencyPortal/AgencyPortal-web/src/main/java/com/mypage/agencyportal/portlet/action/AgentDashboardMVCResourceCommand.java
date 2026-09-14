package com.mypage.agencyportal.portlet.action;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.constants.AgentDashboardPortletKeys;
import com.mypage.agencyportal.dto.BodyDto;
import com.mypage.agencyportal.dto.ClubYearDto;
import com.mypage.agencyportal.dto.PartyDetailsDto;
import com.mypage.agencyportal.dto.PolicyDto;
import com.mypage.agencyportal.dto.ProfileAgentDto;
import com.mypage.agencyportal.dto.ResponseDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalService;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.lang.reflect.Type;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + AgentDashboardPortletKeys.AGENT_DASHBOARD,
		"mvc.command.name=/data/agentdashboard" }, 
service = MVCResourceCommand.class)
public class AgentDashboardMVCResourceCommand extends BaseMVCResourceCommand {
	
	private static String apiURL;
	private static String agencyBinderNo;
	private static String bodyOperation;
	private static String bodyService;
	
	private static String pimcoreHostLink;
	

//	private static final String BRONZE = "Bronze";
//	private static final String SILVER = "Silver";
//	private static final String GOLD = "Gold";
//	private static final String PLATINUM = "Platinum";
//	private static final String PALLADIUM = "Palladium";
	
	private static final String QUARTZ = "Quartz";
	private static final String JADE = "Jade";
	private static final String SAPPHIRE = "Sapphire";
	private static final String RUBY = "Ruby";
	private static final String EMERALD = "Emerald";
	private static final String DIAMOND = "Diamond";

	String deptoreCode = StringPool.BLANK;
	private static ActionHelpers helpers = new ActionHelpers();
	
	private static String apiRequestTokenRenew=null;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		Gson gson = new Gson();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

		String deptoreCode = StringPool.BLANK;
		
		
		/* Validate API Request Token */
		boolean validateApiRequestToken = false;
		String renderToken = ParamUtil.getString(httpRequest, "rtoken");
		String _apiRequestToken = ParamUtil.getString(httpRequest, "aptoken");

		AgentToken verifyAgentToken = _agentTokenLocalService.verifyToken(renderToken, _apiRequestToken);

		if (!Validator.isNull(verifyAgentToken)) {

			AgentToken renewAgentApiRequestToken = _agentTokenLocalService.renewAgentToken(verifyAgentToken.getAgentTokenId());

			if (!Validator.isNull(renewAgentApiRequestToken)) {
				apiRequestTokenRenew = renewAgentApiRequestToken.getApiRequestToken();
			}

			validateApiRequestToken = true;
			deptoreCode = verifyAgentToken.getDeptCode();
		}

		if (!validateApiRequestToken) {
			_response.put("status", false);
			_response.put("message", "Access Forbidden");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		 /* END Validate API Request Token */

		/* Init Params Request */
//		long userId = Validator.isNull(ParamUtil.getLong(httpRequest, "userId")) == true
//				? ParamUtil.getLong(uploadPortletRequest, "userId")
//				: ParamUtil.getLong(httpRequest, "userId");
		String dataCategory = Validator.isNull(ParamUtil.getString(httpRequest, "dataCategory")) == true
				? ParamUtil.getString(uploadPortletRequest, "dataCategory")
				: ParamUtil.getString(httpRequest, "dataCategory");

//		MypageUser user = _mypageUserLocalService.getMypageUser(userId);
//		deptoreCode = user.getDeptoreCode();
		
	
		//deptoreCode = ParamUtil.getString(httpRequest, "deptoreCode"); *deptorecode currently get from token
		agencyBinderNo = getBinderNumber(deptoreCode, httpRequest);

		pimcoreHostLink = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
		
		if (dataCategory.equalsIgnoreCase("main")) {

			
			/**
			 * profile
			 */
			ProfileAgentDto profile = getProfile(httpRequest);
			
//			logger.info("Profile Agent Code (null value --> response false)>> " + profile.getAgentCode());
//			if (Validator.isNull(profile.getAgentCode()) == true) {
//				_response.put("status", false);
//				_response.put("message", "Your data is not found!");
//				_response.put("pimcoreHost", pimcoreHostLink);
//				_response.put("dataProfile", gson.fromJson(gson.toJson(profile), Object.class));
//
//			}

			_response.put("dataProfile", gson.fromJson(gson.toJson(profile), Object.class));
			_response.put("status", true);
			_response.put("message", "");
			_response.put("pimcoreHost", pimcoreHostLink);
			_response.put("token", apiRequestTokenRenew);
			
			/**
			 * end profile
			 */

		}
		
		if(dataCategory.equalsIgnoreCase("club")) {
			/**
			 * club year API
			 */
			List<ClubYearDto> clubYears = getClub(httpRequest);
			
			Map<String, String> datas = new HashMap<>();
			ClubYearDto clubNow = new ClubYearDto();
			List<MasterGlobalVariable> clubs = _MasterGlobalVariableLocalService.getActiveGlobalVariableByGroup("scorecard");

			if (clubYears.size() == 0) {
				clubNow.setAmount(0);
				clubNow.setClub("No Club");
				clubNow.setYear(0);
				clubNow.setLastUpdate("");

				datas = targetClub(clubNow, clubs);

				_response.put("status", true);
				_response.put("message", "Your data is not found!");
				_response.put("pimcoreHost", pimcoreHostLink);
				_response.put("data", gson.fromJson(gson.toJson(clubNow), Object.class));
				_response.put("dataTargetClubYear", gson.fromJson(gson.toJson(datas), Object.class));
				_response.put("token", apiRequestTokenRenew);

				resourceResponse.getWriter().write(_response.toString());

				return;
			}
			
			
			int thisYear = YearMonth.now().getYear();
			String userClub = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode).getClub();
			long userId = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode).getMypageUserId();
			String agentClub = StringPool.BLANK;

			// Sorting the list based on year (descending order)
			Collections.sort(clubYears, Comparator.comparingInt(ClubYearDto::getYear).reversed());

			// club year now (latest)
			ClubYearDto latestClubYear = clubYears.get(0);

			if (thisYear == latestClubYear.getYear()) {
				clubNow = latestClubYear;
				agentClub = latestClubYear.getClub();
				//clubNow.setAmount(549000233423D);
				//clubNow.setClub("Palladium");
			} else {
				clubNow.setAmount(0);
				clubNow.setClub("No Club");
				clubNow.setYear(0);
				clubNow.setLastUpdate("");
				agentClub = "No Club";
			}
			
			if (agentClub.equalsIgnoreCase(userClub) == false) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MypageUser.class.getName(),
						resourceRequest);
				MypageUserLocalServiceUtil.updateClub(deptoreCode, agentClub, serviceContext);
				
				if (agentClub.equalsIgnoreCase("no club") == false && Validator.isNotNull(userClub)) {
					MasterGlobalVariable variable = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Message Template")
							.stream().filter(v -> v.getName().equalsIgnoreCase("club") && v.getActive() == 1)
							.findFirst().get();
					String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
					String title = "Club/Rank Baru";
					String description = variable.getValue().replace("new", agentClub).replace("current", userClub);
					String link = host.concat("/dashboard");
					
					AgentNotificationLocalServiceUtil.addNotification(title, "", "", description, link, variable.getName(), 0,
							0, 0, "", "", "", "", "", 0, 1, 1, userId);
				}
			}

			datas = targetClub(clubNow, clubs);

			_response.put("status", true);
			_response.put("message", "");
			_response.put("pimcoreHost", pimcoreHostLink);
			_response.put("data", gson.fromJson(gson.toJson(clubNow), Object.class));
			_response.put("dataTargetClubYear", gson.fromJson(gson.toJson(datas), Object.class));
			_response.put("token", apiRequestTokenRenew);

			/**
			 * and club year API
			 */
		}

		resourceResponse.getWriter().write(_response.toString());
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

	protected List<ClubYearDto> getClub(HttpServletRequest httpRequest) throws Exception {
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
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);

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

	protected ProfileAgentDto getProfile(HttpServletRequest httpRequest) throws Exception {
		PolicyDto bodyPolicy = new PolicyDto();
		ProfileAgentDto profile = new ProfileAgentDto();

		bodyOperation = "getProfileAgent";
		bodyService = "getAgentInfo";

		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);

		bodyPolicy.setAgencyBinderNo(agencyBinderNo);
		requestBody.setPolicy(bodyPolicy);

		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPartyManagementUrl");
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);

		if (response.getStatusCode() == 200) {
			if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true
					|| Validator.isNull(response.getBody().getPolicy()) == true
					|| Validator.isNull(response.getBody().getPolicy().getAgencyBinderNo()) == true) {
				return profile;
			}

			profile.setAgentCode(response.getBody().getPolicy().getAgencyBinderNo());
			profile.setAgentName(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
					.getHasPersonalDetailsIn().get(0).getFullNM());
			profile.setAgentAge("");
			profile.setAgentJoinDate(
					response.getBody().getPolicy().getHasProducerInformationIn().get(0).getEffectiveDT() == null ? ""
							: helpers.ConvertDateFormat(response.getBody().getPolicy().getHasProducerInformationIn()
									.get(0).getEffectiveDT().toString(), "dd MMM yyy"));
			profile.setAgentRegistStatus(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
					.getHasLicensingIInformationIn().get(0).getLicenseStatusCd());
			profile.setAgentRegional(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
					.getHasAssociationWith().get(0).getAreaCD());
			profile.setAgentRegionalHead(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
					.getHasAssociationWith().get(0).getHasStaffInformationIn().get(0).getBranchManagerNM());
			profile.setAgentManager(response.getBody().getPolicy().getHasProducerInformationIn().get(0)
					.getHasPersonalDetailsIn().get(0).getHasPartyAccountDetailsIn().getPartyAccountNM());
			profile.setAgentAauiStatus(
					response.getBody().getPolicy().getHasProducerInformationIn().get(0).getProducerStatusCD());
		}

		return profile;
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

	@Reference
	private MypageUserLocalService _mypageUserLocalService;

	@Reference
	private MasterGlobalVariableLocalService _MasterGlobalVariableLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;

}
