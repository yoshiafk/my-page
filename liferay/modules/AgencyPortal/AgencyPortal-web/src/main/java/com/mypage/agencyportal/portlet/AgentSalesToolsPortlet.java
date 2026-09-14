package com.mypage.agencyportal.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.AgentSalesToolsPortletKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentSalesToolsLocalService;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalService;

import java.io.IOException;

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
		"javax.portlet.display-name=Agent Sales Tools",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/salestools/view.jsp",
		"javax.portlet.name=" + AgentSalesToolsPortletKeys.AGENT_SALES_TOOLS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AgentSalesToolsPortlet extends MVCPortlet {
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentSalesToolsPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
//		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(renderResponse);
		
//		HttpSession session = httpRequest.getSession();
//		long mypageUserId = Validator.isNull(session.getAttribute(WebKeys.USER_ID)) == true ? 1 : (long) session.getAttribute(WebKeys.USER_ID);
		
//		if (Validator.isNull(mypageUserId)) {
//			String portalURL = PortalUtil.getPortalURL(renderRequest);
//			
//			httpResponse.sendRedirect(portalURL + "/auth");
//			return;
//		}
		
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
				// berarti belum pernah hit o/sales-tools/show
				if (helpers.isLog()) _log.info("DeptCode tidak pernah terdaftar di DB.");
			}
			
			if (authStatus) {
				MypageUser user = _mypageUserLocalService.getByDeptoreCode(agentToken.getDeptCode());
				
				int size = 10;
				int totalItems = _agentSalesToolsLocalService.getCountByFilter("", "", user.getMypageUserRoleId());
		        int totalPages = (int) Math.ceil((double) totalItems / size);
		        
				int page = Validator.isNull(httpRequest.getParameter("page")) == true ? 1 : Validator.isNumber(httpRequest.getParameter("page")) == true ? Integer.valueOf(httpRequest.getParameter("page")) : 0;
		        
		        if (page > totalPages) page = totalPages;
				
				renderRequest.setAttribute("role", user.getMypageUserRoleId());
				renderRequest.setAttribute("size", size);
				renderRequest.setAttribute("current_page", page);
				renderRequest.setAttribute("total_pages", totalPages);
				
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/salestools/view.jsp");
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
	private AgentSalesToolsLocalService _agentSalesToolsLocalService;
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}