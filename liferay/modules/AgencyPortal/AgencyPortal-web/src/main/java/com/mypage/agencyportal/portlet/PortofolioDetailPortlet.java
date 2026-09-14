package com.mypage.agencyportal.portlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.PortofolioDetailPortletKeys;
import com.mypage.agencyportal.dto.BodyDto;
import com.mypage.agencyportal.dto.DataDetailsLeadsDto;
import com.mypage.agencyportal.dto.PartyDetailsDto;
import com.mypage.agencyportal.dto.PolicyDto;
import com.mypage.agencyportal.dto.ProfileAgentDto;
import com.mypage.agencyportal.dto.ResponseDto;
import com.mypage.agencyportal.dto.UserDetailAPIResponseDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Portofolio Leads Detail",
		"javax.portlet.init-param.template-path=/",
		//"javax.portlet.init-param.view-template=/dashboard/portofolio/dashboard_portofolio_detail.jsp",
		"javax.portlet.name=" + PortofolioDetailPortletKeys.PORTOFLIO_DETAIL_PORTLET_KEYS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, 
service = Portlet.class)
public class PortofolioDetailPortlet extends MVCPortlet {
	
	private static String PIMCORE_HOST;
	private static String dashboardApiAgencyDetailsLeadsUrl;
	private static String dashboardApiAgencyUserUrl;
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(PortofolioDetailPortlet.class);
	private static String deptoreCode = StringPool.BLANK;
	
	private static String apiURL;
	private static String agencyBinderNo;
	private static String bodyOperation;
	private static String bodyService;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		try {
			
			String token = StringPool.BLANK;
			
			
			token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));
			
			String decodeTokenBrowser = ParamUtil.getString(httpRequest, "a");
			String encodeToken = URLEncoder.encode(decodeTokenBrowser, "UTF-8");
			   
			if (Validator.isBlank(token) == true) {
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/dashboard/404.jsp");
				dispatcher.include(renderRequest, renderResponse);
				return;
			}
			
			// VALIDASI TOKEN SEKALI PAKAI
			String tokenFromParam = token;
			boolean authStatus = false;
			AgentToken agentToken = _agentTokenLocalService.getAgentTokenByToken(tokenFromParam);
			
			if (!Validator.isNull(agentToken)) {
				if (agentToken.getToken().equals(tokenFromParam)) {
					if (agentToken.getIsValid() == 0) {
						if (helpers.isLog()) _log.info("Token tidak valid: token dari param sama dengan token di DB tapi di DB statusnya tidak valid.");
					} else {
						if (helpers.isLog()) _log.info("Token Valid: Token dari param sama dengan token yang ada di DB dan status token valid.");
						
						// Invalidate Render token and set to attribute
						_agentTokenLocalService.setAgentTokenToInvalid(agentToken.getAgentTokenId());
					    renderRequest.setAttribute("renderToken", agentToken.getToken());
						
						// Renew api request token
					    AgentToken agentTokenRenewApiToken = _agentTokenLocalService.renewAgentToken(agentToken.getAgentTokenId());
					    if(Validator.isNull(agentTokenRenewApiToken)) {
					    	throw new Exception("Failed to renew agent token api request token");
					    }
					    renderRequest.setAttribute("apiRequestToken", agentTokenRenewApiToken.getApiRequestToken());
					    
					    // ini nanti dihapus kalau di resource command sudah selesai
						renderRequest.setAttribute("token", agentTokenRenewApiToken.getApiRequestToken());
						
					    // Set auth status to true
						authStatus = true;
					}
				} else {
					if (helpers.isLog()) _log.info("Token Tidak Valid: Token dari param tidak sama dengan token yang ada di DB.");
				}
			} else {
				// berarti belum pernah hit o/performance-booking/show
				if (helpers.isLog()) _log.info("DeptCode tidak pernah terdaftar di DB.");
			}
		
			if (authStatus) {
				
				//if (helpers.isLog()) _log.info("PortofolioDetailPortlet authStatus true");
				
				deptoreCode = agentToken.getDeptCode();
				
				//if (helpers.isLog()) _log.info("PortofolioDetailPortlet deptoreCode >> "+ deptoreCode);
				
				agencyBinderNo = getBinderNumber(deptoreCode, httpRequest);
				
				//if (helpers.isLog()) _log.info("PortofolioDetailPortlet agencyBinderNo >> "+ agencyBinderNo);
				
				ProfileAgentDto profile = getProfile(httpRequest);
				
				//if (helpers.isLog()) _log.info("PortofolioDetailPortlet profile >> "+ profile);
				
				String refNum = StringPool.BLANK;
				
				String param = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "b"));
				
				String[] paramSplit = param.split("\\|");
				 refNum = paramSplit[1];
				 
				 //if (helpers.isLog()) _log.info("PortofolioDetailPortlet paramSplit >> "+ paramSplit);

				PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
				dashboardApiAgencyDetailsLeadsUrl = helpers.getConfig("dashboard.api.agency.leads.detail");
				dashboardApiAgencyUserUrl = helpers.getConfig("dashboard.api.agency.user");
				
					Gson gson = new Gson();
					String reqPayloadString = "";
					JSONObject detailsLeadsResponse = JSONFactoryUtil.createJSONObject();
					
					HashMap<String, Object> reqpayload = new HashMap<String, Object>();
					reqpayload.put("ReferenceNumber", refNum);
					reqpayload.put("Code", deptoreCode);
					
					reqPayloadString = gson.toJson(reqpayload);
					
					//if (helpers.isLog()) _log.info("PortofolioDetailPortlet -> reqPayloadString >>" + reqPayloadString);
					
					
					detailsLeadsResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyDetailsLeadsUrl, reqPayloadString, encodeToken);
					
					//if (helpers.isLog()) _log.info("PortofolioDetailPortlet -> detailsLeadsResponse >>" + detailsLeadsResponse);
					
					
					UserDetailAPIResponseDto userDetailAPIResponseDto = new Gson().fromJson(detailsLeadsResponse.get("response").toString(), UserDetailAPIResponseDto.class);
					
					//if (helpers.isLog()) _log.info("PortofolioDetailPortlet -> userDetailAPIResponseDto >>" + userDetailAPIResponseDto);
					
					if (helpers.isLog()) _log.info(gson.toJson(userDetailAPIResponseDto.getData()));
					
					//if (helpers.isLog()) _log.info("PortofolioDetailPortlet -> userDetailAPIResponseDto.getStatus() >>" + userDetailAPIResponseDto.getStatus());
					
					if(Integer.valueOf(userDetailAPIResponseDto.getStatus()) < 1) {
						if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getMessage());
						PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
						dispatcher.include(renderRequest, renderResponse);
						return;
					}
					
					if (helpers.isLog()) _log.info("PortofolioDetailPortlet -> userDetailAPIResponseDto >>" + userDetailAPIResponseDto);
					
					
					String response =  detailsLeadsResponse.get("response").toString();
					
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response);

		            JSONObject dataObject = jsonObject.getJSONObject("Data");
			        
			        if (dataObject.has("Insured")) {
			        	
			        	if (dataObject.get("Insured") instanceof JSONObject) {
			        	    // Insured is an object
			        		JSONObject insuredObj = dataObject.getJSONObject("Insured");
					        renderRequest.setAttribute("insured", insuredObj); // return json object

			        		
			        	} else if (dataObject.get("Insured") instanceof JSONArray) {
			        	    // Insured is an array
			        		JSONArray insuredArray = dataObject.getJSONArray("Insured");
					        renderRequest.setAttribute("insureds", insuredArray); //return json array
			        	}
			        	   
			        }
			        
			        // gey payment
			        if (dataObject.has("Payment")) {
			        	
			        	if (dataObject.get("Payment") instanceof JSONObject) {
			        	    // Insured is an object
			        		JSONObject paymentObj = dataObject.getJSONObject("Payment");
					        renderRequest.setAttribute("payment", paymentObj); // return json object

			        	}
			        	   
			        }
			        
			        
			        // child of Data
			        JSONObject dataObjectDetail = dataObject.getJSONObject("Detail");
			        
			        if (Validator.isNotNull(dataObjectDetail) == true) {
				        if (dataObjectDetail.has("Accessories")) { //expected array
				            JSONArray jaAccessories = dataObjectDetail.getJSONArray("Accessories");
				            renderRequest.setAttribute("accessories", jaAccessories);
				        }
				        if (dataObjectDetail.has("Coverage")) { //expected array
				            JSONArray jaCoverage = dataObjectDetail.getJSONArray("Coverage");
				            renderRequest.setAttribute("coverages", jaCoverage);
				        }
				        
				        if (dataObjectDetail.has("BuildingContent")) { //expected array
				            JSONArray jabuildcontent = dataObjectDetail.getJSONArray("BuildingContent");
				            renderRequest.setAttribute("buildingcontents", jabuildcontent);
				        }
				        
				        if (dataObjectDetail.has("OutsidePremises")) { //expected array
				            JSONArray jaotherPremises = dataObjectDetail.getJSONArray("OutsidePremises");
				            renderRequest.setAttribute("premises", jaotherPremises);
				        }
			        }
			        
			        
			        // child of data
			        JSONObject dataObjectPolisHolder = dataObject.getJSONObject("PolicyHolder");
			        if (dataObjectPolisHolder.has("AddressDetail")) { //expected object
			        	// Insured is an object
		        		JSONObject addressDetailObj = dataObjectPolisHolder.getJSONObject("AddressDetail");
				        renderRequest.setAttribute("addressDetail", addressDetailObj); // return json object
			        }
			        
			        if (dataObjectPolisHolder.has("IncomeSource")) { //expected object
			        	// Insured is an object
		        		JSONObject incomeSourceObj = dataObjectPolisHolder.getJSONObject("IncomeSource");
				        renderRequest.setAttribute("incomeSource", incomeSourceObj); // return json object
			        }
			        
			        if (dataObjectPolisHolder.has("BankAccount")) { //expected object
			        	// Insured is an object
		        		JSONObject BankAccount = dataObjectPolisHolder.getJSONObject("BankAccount");
				        renderRequest.setAttribute("bankAccount", BankAccount); // return json object
			        }

					DataDetailsLeadsDto _detailLeadsResponse = new Gson().fromJson(dataObject.toString(), DataDetailsLeadsDto.class);

					String productCodeRaw = _detailLeadsResponse.getProduct().getCode().toUpperCase();
				String productCode;

					if ("IT6".equals(productCodeRaw)) {
						productCode = "IT6";
					} else if (productCodeRaw.contains("IT")) {
						productCode = "IT";
					} else {
						productCode = _detailLeadsResponse.getProduct().getCode();
					}

					if (helpers.isLog()) _log.info("Product Code>>" + productCode);
					if (helpers.isLog()) _log.info("Response API>>" + response);
					if (helpers.isLog()) _log.info("UrlDownloadPolis>>" + _detailLeadsResponse.getUrlDownloadPolis());
					if (helpers.isLog()) _log.info("LinkBayar>>" + _detailLeadsResponse.getLinkBayar());
					if (helpers.isLog()) _log.info("CsrfToken>>" + _detailLeadsResponse.getCsrfToken());
					if (helpers.isLog()) _log.info("Id>>" + _detailLeadsResponse.getId());
					if (helpers.isLog()) _log.info("TempCode>>"+_detailLeadsResponse.getTempCode());
					if (helpers.isLog()) _log.info("LinkXls>>"+_detailLeadsResponse.getLinkXls());
					if (helpers.isLog()) _log.info("isFromExcel>>"+_detailLeadsResponse.isFromExcel());
					
					JSONObject userDetailPayload = JSONFactoryUtil.createJSONObject();
					userDetailPayload.put("Code", deptoreCode);
					
					JSONObject userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyUserUrl, userDetailPayload.toString(), encodeToken);
					
					JSONObject userDetailResponseDto = JSONFactoryUtil.createJSONObject(userDetailResponse.get("response").toString());
					
					if (helpers.isLog()) _log.info(userDetailResponseDto.getJSONObject("Data").getString("Role"));
					
					renderRequest.setAttribute("detailLeadsResponse", _detailLeadsResponse);

					if (helpers.isLog()) _log.info("data detail >> " + dataObjectDetail);
					renderRequest.setAttribute("detail", dataObjectDetail);
					
					renderRequest.setAttribute("agentName", profile.getAgentName());
					renderRequest.setAttribute("agentRole", userDetailResponseDto.getJSONObject("Data").getString("Role"));
					renderRequest.setAttribute("encodeToken", encodeToken);
					
					
					PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/dashboard/portofolio/detail/portofolio_online_detail_"+productCode.toUpperCase()+".jsp");
					dispatcher.include(renderRequest, renderResponse);
				
			}
			
		} catch (Exception e) {
			if (helpers.isLog()) _log.info(e.getMessage());
			// TODO: handle exception
		}
		
	    
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
		
		//if (helpers.isLog()) _log.info("getProfile requestBody >> "+ requestBody);
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);

		//if (helpers.isLog()) _log.info("getProfile response >> "+ response);
		
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
		Gson gson = new Gson();
        String json = gson.toJson(profile);
		if (helpers.isLog()) _log.info("PortofolioDetailPortlet.getProfile()>>"+json);

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
		
		//if (helpers.isLog()) _log.info("getBinderNumber -> requestBody>>" + requestBody);

		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPartyManagementUrl");
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);

		//if (helpers.isLog()) _log.info("getBinderNumber -> response>>" + response);
		
		if (response.getStatusCode() == 200) {
			agencyBinderNo = Validator
					.isNull(response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO()) == true ? ""
							: response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO();
		}

		return agencyBinderNo;
	}
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;

}
