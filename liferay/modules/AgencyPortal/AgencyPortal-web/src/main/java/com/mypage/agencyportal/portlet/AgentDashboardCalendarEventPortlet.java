package com.mypage.agencyportal.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.AgentDashboardCalendarEventPortletKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentCalendar;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentCalendarLocalService;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageGroupUserLocalService;
import com.mypage.user.service.MypageUserLocalService;

import java.io.IOException;
import java.util.Date;

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
			"javax.portlet.display-name=Agent Event Detail",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/dashboard/calendar/detail.jsp",
			"javax.portlet.name=" + AgentDashboardCalendarEventPortletKeys.AGENT_EVENT_DETAIL,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AgentDashboardCalendarEventPortlet extends MVCPortlet {
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentDashboardCalendarEventPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		try {
			String token = StringPool.BLANK;
			long eventId = 0L;
			
			try {
				token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));
				String param = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "b"));
				String[] paramSplit = param.split("\\|");
				eventId = Long.parseLong(paramSplit[1]);

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
				// berarti belum pernah hit o/sales-tools/show
				if (helpers.isLog()) _log.info("DeptCode tidak pernah terdaftar di DB.");
			}
			
			MypageUser user = _mypageUserLocalService.getByDeptoreCode(agentToken.getDeptCode());
			AgentCalendar agentCalendar = _agentCalendarLocalService.getAgentCalendar(eventId);
			
			if (helpers.isLog()) _log.info(user.getMypageUserId());
			if (helpers.isLog()) _log.info(agentCalendar.getMypageUserId());
			
			if (user.getMypageUserId() != agentCalendar.getMypageUserId() && agentCalendar.getCategory().equalsIgnoreCase("reminder") == true) eventId = 0;
			
			if (agentCalendar.getMypageUserRoleId() > 0 && user.getMypageUserRoleId() != agentCalendar.getMypageUserRoleId() && agentCalendar.getCategory().equalsIgnoreCase("event") == true) eventId = 0;
			
			if (agentCalendar.getMypageUserGroupId() > 0 && agentCalendar.getCategory().equalsIgnoreCase("event") == true) {
				long findUser = _mypageGroupUserLocalService.findBymypageGroupId(agentCalendar.getMypageUserGroupId()).stream()
								.filter(v -> v.getMypageUserId() == user.getMypageUserId())
							   	.count();
				
				if (findUser == 0) eventId = 0;
			}
			
//			if (agentCalendar.getActive() == 0) eventId = 0;
			
//			if (agentCalendar.getCategory().equalsIgnoreCase("reminder") == true) {
//				Date today = new Date();
//				today.setHours(0);
//				today.setMinutes(0);
//				today.setSeconds(0);
//				
//				long timestamp = Math.round(Math.floor(today.getTime() / 1000));
//				
//				if (timestamp > (agentCalendar.getStartDate().getTime() / 1000) || (Validator.isNotNull(agentCalendar.getEndDate()) == true && timestamp > agentCalendar.getEndDate().getTime() / 1000)) eventId = 0;
//			}
			
			if (authStatus) {
				renderRequest.setAttribute("agentCalendarId", eventId);
				
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/dashboard/calendar/detail.jsp");
				dispatcher.include(renderRequest, renderResponse);
			} else {
				String url = PortalUtil.getCurrentURL(httpRequest);
				int lastIndex = url.lastIndexOf("/");
				String lastPart = url.substring(lastIndex + 1).split("\\?")[0].concat("/").concat(String.valueOf(ParamUtil.getLong(httpRequest, "b")));
				
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
			String lastPart = url.substring(lastIndex + 1).split("\\?")[0].concat("/").concat(String.valueOf(ParamUtil.getLong(httpRequest, "b")));
			
			renderRequest.setAttribute("endpoint", lastPart);
			
//			if (helpers.isLog()) _log.info(e.getStackTrace());
			
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/includes/404.jsp");
			dispatcher.include(renderRequest, renderResponse);
		}
	}
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	
	@Reference
	private MypageGroupUserLocalService _mypageGroupUserLocalService;
	
	@Reference
	private AgentCalendarLocalService _agentCalendarLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
