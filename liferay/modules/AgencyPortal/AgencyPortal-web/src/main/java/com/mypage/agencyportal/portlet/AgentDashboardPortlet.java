package com.mypage.agencyportal.portlet;

import com.google.gson.Gson;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.constants.AgentDashboardPortletKeys;
import com.mypage.agencyportal.dto.APIResponse;
import com.mypage.agencyportal.dto.DataItemDto;
import com.mypage.agencyportal.dto.UserDetailAPIResponseDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.helpers.SignatureHelper;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserRole;
import com.mypage.user.service.MypageUserLocalService;
import com.mypage.user.service.MypageUserRoleLocalService;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Agent Dashboard",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dashboard/view.jsp",
		"javax.portlet.name=" + AgentDashboardPortletKeys.AGENT_DASHBOARD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AgentDashboardPortlet extends MVCPortlet {
	
	private static String PIMCORE_HOST;
	private static String dashboardApiAgencyLeadsUrl;
	private static String dashboardApiAgencyUserUrl;
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentDashboardPortlet.class);
	private static String deptoreCode = StringPool.BLANK;
	private static String USER_ID = "User-Id";
    private static String REQUEST_ID = "Request-Id";
    private static String REQUEST_TIMESTAMP = "Request-Timestamp";
    private static String SIGNATURE = "Signature";
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
		dashboardApiAgencyLeadsUrl = helpers.getConfig("dashboard.api.agency.leads");
		dashboardApiAgencyUserUrl = helpers.getConfig("dashboard.api.agency.user");
		
		String token = StringPool.BLANK;
		
		try {
			token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));
			
			String decodeTokenBrowser = ParamUtil.getString(httpRequest, "a");
			String encodeToken = URLEncoder.encode(decodeTokenBrowser, "UTF-8");
			   
			if (Validator.isBlank(token) == true) {
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
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
					    	if (helpers.isLog()) _log.info("Failed to renew agent token api request token");
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
				deptoreCode = agentToken.getDeptCode();
				
				MypageUser user = null;
				
				if (helpers.isLog()) _log.info(deptoreCode);
				
				try {
					user = _mypageUserLocalService.getByDeptoreCode(deptoreCode);
				} catch (Exception e) {
					
				}
				
				Gson gson = new Gson();
				String userDetailPayload = "";
				JSONObject userDetailResponse = JSONFactoryUtil.createJSONObject();
//				JSONObject signatureObject = JSONFactoryUtil.createJSONObject();
//				String uuid = UUID.randomUUID().toString();
//				ZonedDateTime nowInUTC = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
//		        String reqTimestamp = nowInUTC.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
				
				HashMap<String, Object> _userDetailPayload = new HashMap<String, Object>();
				_userDetailPayload.put("Code", deptoreCode);
				userDetailPayload = gson.toJson(_userDetailPayload);
				
//				signatureObject.put(USER_ID, deptoreCode);
//				signatureObject.put(REQUEST_ID, uuid);
//				signatureObject.put(REQUEST_TIMESTAMP, reqTimestamp);
//				signatureObject.put(SIGNATURE, SignatureHelper.generateSignature(deptoreCode, uuid, reqTimestamp, SignatureHelper.generateDigest(userDetailPayload.toString())));
//				
//				if (helpers.isLog()) _log.info(signatureObject);
				
				userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyUserUrl, userDetailPayload, encodeToken);
				
				UserDetailAPIResponseDto userDetailAPIResponseDto = new Gson().fromJson(userDetailResponse.get("response").toString(), UserDetailAPIResponseDto.class);
				
				if (helpers.isLog()) _log.info(gson.toJson(userDetailAPIResponseDto.getData()));
				if(Integer.valueOf(userDetailAPIResponseDto.getStatus()) < 1) {
					if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getMessage());
					PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
					dispatcher.include(renderRequest, renderResponse);
					return;
				}
				
				
				JSONObject dataMypageUser = JSONFactoryUtil.createJSONObject();
				dataMypageUser.put("userName", userDetailAPIResponseDto.getData().getName());
				 
				MypageUserRole currentRole = _mypageUserRoleLocalService.getByName(userDetailAPIResponseDto.getData().getRole());
				dataMypageUser.put("mypageUserRoleId", currentRole.getMypageUserRoleId());
				  
				dataMypageUser.put("status", userDetailAPIResponseDto.getData().getStatus());
				dataMypageUser.put("email", userDetailAPIResponseDto.getData().getEmail());
				dataMypageUser.put("code", userDetailAPIResponseDto.getData().getAgentCode());
				dataMypageUser.put("deptoreCode", userDetailAPIResponseDto.getData().getDeptoreCode());
				dataMypageUser.put("prettyUrl", userDetailAPIResponseDto.getData().getPrettyUrl());
				dataMypageUser.put("prettyUrlChange", userDetailAPIResponseDto.getData().getPrettyUrlChange());
				
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
				LocalDate dobDate = Validator.isNotNull(userDetailAPIResponseDto.getData().getDob()) ? LocalDate.parse(userDetailAPIResponseDto.getData().getDob(), dateFormat) : null;
				LocalDate joinDate = Validator.isNotNull(userDetailAPIResponseDto.getData().getJoinDate()) ? LocalDate.parse(userDetailAPIResponseDto.getData().getJoinDate(), dateFormat) : null;
				LocalDate endDate = Validator.isNotNull(userDetailAPIResponseDto.getData().getEndDate()) ? LocalDate.parse(userDetailAPIResponseDto.getData().getEndDate(), dateFormat) : null;
	            
				dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String formattedDobDate = Validator.isNotNull(dobDate) ? dobDate.format(dateFormat) : StringPool.BLANK;
	            String formattedJoinDate = Validator.isNotNull(joinDate) ? joinDate.format(dateFormat) : StringPool.BLANK;
	            String formattedEndDate = Validator.isNotNull(endDate) ? endDate.format(dateFormat) : StringPool.BLANK;
				
				dataMypageUser.put("dob", formattedDobDate);
				dataMypageUser.put("joinDate", formattedJoinDate);
				dataMypageUser.put("endDate", formattedEndDate);
				dataMypageUser.put("gender", userDetailAPIResponseDto.getData().getGender());
				dataMypageUser.put("mobilePhone", userDetailAPIResponseDto.getData().getMobilePhone());

				MypageUser newMypageUser =  _mypageUserLocalService.addMypageUserForAgencyPortal(dataMypageUser);
				 
				user = newMypageUser;
				
				int start = ParamUtil.getInteger(renderRequest, "start", 0);
				int limit = ParamUtil.getInteger(renderRequest, "limit", 10);
			
				URI uriLeads = new URI(PIMCORE_HOST + dashboardApiAgencyLeadsUrl);
			    String URLleads = uriLeads.toString();
			    
			    String postData = "Code=" + deptoreCode + "&Start=" + start + "&Limit=" + limit ;
				byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
				APIResponse<DataItemDto> response = helpers.APIClients(URLleads, postDataBytes, DataItemDto.class, encodeToken);
				
				if (helpers.isLog()) _log.info(gson.toJson(response));
				if(Validator.isNotNull(response) && Integer.valueOf(response.getStatus()) < 1) {
					if (helpers.isLog()) _log.info(response.getMessage());
					//return;
				}
				
				// Send notification license agent
				LocalDate expireDate = LocalDate.parse(formattedEndDate, dateFormat);
				long notifyDay = Long.parseLong(MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Notification Day")
								.stream().filter(v -> v.getName().equalsIgnoreCase("license agent") && v.getActive() == 1)
								.findFirst().get().getValue());
				LocalDate notifyDate = expireDate.minusDays(notifyDay);
				LocalDate today = LocalDate.now();
				
				if (today.isEqual(notifyDate)) {
					String category = "License Agent";
					long notificationSize = AgentNotificationLocalServiceUtil.findEndLicenseByYear(user.getMypageUserId(), category, today.getYear());
					
					if (notificationSize == 0) {
						MasterGlobalVariable variable = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Notification Template")
														.stream().filter(v -> v.getName().equalsIgnoreCase("license agent") && v.getActive() == 1)
														.findFirst().get();
						
						String title = "Lisensi ke Agenan";
						String description = variable.getValue();
						PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
						String link = PIMCORE_HOST.concat("/dashboard/scorecard");
						
						AgentNotificationLocalServiceUtil.addNotification(title, "", "", description, link, variable.getName(), 0,
								0, 0, "", "", formattedEndDate, "", "", 0, 1, 1, user.getMypageUserId());
					}
				}
				
				boolean showClub = Boolean.parseBoolean(MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Agency")
								   .stream().filter(v -> v.getName().equalsIgnoreCase("show club") && v.getActive() == 1)
							   	   .findFirst().get().getValue());
				
				renderRequest.setAttribute("_deptoreCode", agentToken.getDeptCode());
				renderRequest.setAttribute("myPageUser", user);
				renderRequest.setAttribute("response", response);
				renderRequest.setAttribute("mypageUserRoleId", user.getMypageUserRoleId());
				renderRequest.setAttribute("showClub", showClub);

				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/dashboard/view.jsp");
				dispatcher.include(renderRequest, renderResponse);
			} else {
				String url = PortalUtil.getCurrentURL(httpRequest);
				int lastIndex = url.lastIndexOf("/");
				String lastPart = url.substring(lastIndex + 1).split("\\?")[0];
				
				renderRequest.setAttribute("endpoint", lastPart);
				
				if (helpers.isLog()) _log.info(authStatus);
				
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
				dispatcher.include(renderRequest, renderResponse);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (helpers.isLog()) _log.info(e.getMessage());
			
			String url = PortalUtil.getCurrentURL(httpRequest);
			int lastIndex = url.lastIndexOf("/");
			String lastPart = url.substring(lastIndex + 1).split("\\?")[0];
			
			renderRequest.setAttribute("endpoint", lastPart);
			
//			if (helpers.isLog()) _log.info(e.getStackTrace());
			
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
			dispatcher.include(renderRequest, renderResponse);
			return;
		}
	}
	
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	
	@Reference
	private MypageUserRoleLocalService _mypageUserRoleLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;

}
