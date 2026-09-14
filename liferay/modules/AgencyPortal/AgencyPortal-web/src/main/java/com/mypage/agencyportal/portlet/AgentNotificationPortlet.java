package com.mypage.agencyportal.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.constants.AgentNotificationPortletKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserGroupLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
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
			"javax.portlet.display-name=Agent Notification",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/notification/view.jsp",
			"javax.portlet.name=" + AgentNotificationPortletKeys.AGENT_NOTIFICATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AgentNotificationPortlet extends MVCPortlet {
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentNotificationPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		try {
			String token = StringPool.BLANK;
			
			try {
				token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));

				// Tampilkan halaman 404 jika parameter tidak lengkap
				if (Validator.isNull(token) == true) {
					PortletRequestDispatcher dispatcher = getPortletContext()
							.getRequestDispatcher("/META-INF/resources/includes/404.jsp");
					dispatcher.include(renderRequest, renderResponse);
					return;
				}
			} catch (Exception e) {
				// e.printStackTrace();
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
				// berarti belum pernah hit o/promo-code/show
				if (helpers.isLog()) _log.info("DeptCode tidak pernah terdaftar di DB.");
			}
			
			if (authStatus) {
				List<String> categoryNotifications = new ArrayList<String>();
				List<String> categoryMessages = new ArrayList<String>();
				MypageUser myPageUser = MypageUserLocalServiceUtil.getByDeptoreCode(agentToken.getDeptCode());
				List<Long> groups = MypageUserGroupLocalServiceUtil.findBymypageUserId(myPageUser.getMypageUserId());
				
				List<MasterGlobalVariable> variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Notification");
				
				if (variables.size() > 0) {
					for (MasterGlobalVariable item : variables) categoryNotifications.add(item.getValue());
				}
				
				variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Message");
				
				if (variables.size() > 0) {
					for (MasterGlobalVariable item : variables) categoryMessages.add(item.getValue());
				}
				
				if (helpers.isLog()) _log.info(categoryNotifications);
				if (helpers.isLog()) _log.info(categoryMessages);
				
				List<AgentNotification> notifications = AgentNotificationLocalServiceUtil.getActiveNotificationByRole(myPageUser.getMypageUserId(), myPageUser.getMypageUserRoleId(), groups, categoryNotifications);
				List<AgentNotification> messages = AgentNotificationLocalServiceUtil.getActiveNotificationByRole(myPageUser.getMypageUserId(), myPageUser.getMypageUserRoleId(), groups, categoryMessages);
		        
		        if (helpers.isLog()) _log.info(notifications);
				if (helpers.isLog()) _log.info(messages);
				
				int size = 10;
				int totalItemsNotification = notifications.size();
				int totalItemsMessage = messages.size();
		        int totalPagesNotification = (int) Math.ceil((double) totalItemsNotification / size);
		        int totalPagesMessage = (int) Math.ceil((double) totalItemsMessage / size);
		        
				int pagesNotification = Validator.isNull(httpRequest.getParameter("page")) == true ? 1 : Validator.isNumber(httpRequest.getParameter("page")) == true ? Integer.valueOf(httpRequest.getParameter("page")) : 0;
		        
		        if (pagesNotification > totalPagesNotification) pagesNotification = totalPagesNotification;
		        
		        int pagesMessage = Validator.isNull(httpRequest.getParameter("page")) == true ? 1 : Validator.isNumber(httpRequest.getParameter("page")) == true ? Integer.valueOf(httpRequest.getParameter("page")) : 0;
		        
		        if (pagesMessage > totalPagesMessage) pagesMessage = totalPagesMessage;
		        
		        for (AgentNotification item : notifications) {
		        	item.setDescription(item.getDescription().replace("Agen, ", myPageUser.getUserName().concat(",<br>")));
		        }
		        
		        for (AgentNotification item : messages) {
		        	item.setDescription(item.getDescription().replace("Agen, ", myPageUser.getUserName().concat(",<br>")));
		        }
				
				renderRequest.setAttribute("notifications", notifications);
				renderRequest.setAttribute("messages", messages);
				renderRequest.setAttribute("size", size);
				renderRequest.setAttribute("current_page_notification", pagesNotification);
				renderRequest.setAttribute("current_page_message", pagesMessage);
				renderRequest.setAttribute("total_pages_notification", totalPagesNotification);
				renderRequest.setAttribute("total_pages_message", totalPagesMessage);
				
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/notification/view.jsp");
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
		}
	}
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
