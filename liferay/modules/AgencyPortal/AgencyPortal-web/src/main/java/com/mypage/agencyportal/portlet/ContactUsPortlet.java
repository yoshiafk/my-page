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
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import com.mypage.agencyportal.constants.ContactUsPortletKey;
import com.mypage.agencyportal.dto.UserDetailAPIResponseDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.io.IOException;
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

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=myPage",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Agency Contact Us",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/contact_us.jsp",
			"javax.portlet.name=" + ContactUsPortletKey.CONTACT_US_KEY_PORTLET,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class ContactUsPortlet extends MVCPortlet{
	
	private static String PIMCORE_HOST;
	private static String dashboardApiAgencyUserUrl;
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(ContactUsPortlet.class);
	private static String deptoreCode = StringPool.BLANK;
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
		dashboardApiAgencyUserUrl = helpers.getConfig("dashboard.api.agency.user");
		
		String token = StringPool.BLANK;
		
		try {
			token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));
			   
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
				
				deptoreCode = agentToken.getDeptCode();
				
				Gson gson = new Gson();
				JSONObject userDetailResponse = JSONFactoryUtil.createJSONObject();
				String userDetailPayload = "";
				HashMap<String, Object> _userDetailPayload = new HashMap<String, Object>();
				_userDetailPayload.put("Code", deptoreCode);
				userDetailPayload = gson.toJson(_userDetailPayload);
				
				userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyUserUrl, userDetailPayload, null);
				
				UserDetailAPIResponseDto userDetailAPIResponseDto = new Gson().fromJson(userDetailResponse.get("response").toString(), UserDetailAPIResponseDto.class);
				
				if (helpers.isLog()) _log.info(gson.toJson(userDetailAPIResponseDto.getData()));
				if(Integer.valueOf(userDetailAPIResponseDto.getStatus()) < 1) {
					if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getMessage());
					PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
					dispatcher.include(renderRequest, renderResponse);
					return;
				}
				
				String response =  userDetailResponse.get("response").toString();
				JSONObject responseJsonObject = JSONFactoryUtil.createJSONObject(response);
	            JSONObject dataObject = responseJsonObject.getJSONObject("Data");
	            
				List<MasterGlobalVariable> contactUs = _MasterGlobalVariableLocalService.getActiveGlobalVariableByGroup("contact us");		
				HashMap<String, String> contactUsMap = new HashMap<String, String>();
				
				for (MasterGlobalVariable masterGlobalVariable : contactUs) {
					contactUsMap.put(toCamelCase(masterGlobalVariable.getName()), masterGlobalVariable.getValue());
				}
				
				renderRequest.setAttribute("dataObject", dataObject);
				renderRequest.setAttribute("contactUs", contactUsMap);
				super.render(renderRequest, renderResponse);
				
			} else {
				String url = PortalUtil.getCurrentURL(httpRequest);
				int lastIndex = url.lastIndexOf("/");
				String lastPart = url.substring(lastIndex + 1).split("\\?")[0];
				
				renderRequest.setAttribute("endpoint", lastPart);
				
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
			
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
			dispatcher.include(renderRequest, renderResponse);
			return;
		}
		
		
		
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
	private MasterGlobalVariableLocalService _MasterGlobalVariableLocalService;
	

	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
