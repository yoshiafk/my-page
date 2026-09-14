package com.mypage.agencyportal.portlet;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.agencyportal.constants.AgentPerformanceBookingPortletKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

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
		"javax.portlet.display-name=Agent Performance Booking",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/performancebooking/view.jsp",
		"javax.portlet.name=" + AgentPerformanceBookingPortletKeys.AGENT_PERFORMANCE_BOOKING,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AgentPerformanceBookingPortlet extends MVCPortlet {
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(AgentPerformanceBookingPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		try {
			String referer = httpRequest.getHeader("referer") == null ? "" : httpRequest.getHeader("referer");
			// Menghapus karakter ekstra di akhir URL
			referer = referer.replaceAll("/$", "");

			String token = StringPool.BLANK;
			String tokenMobile = StringPool.BLANK;

			int currentYear = Year.now().getValue();
			LocalDate startLocalDate = LocalDate.of(currentYear, 1, 1);
			LocalDate dailyEndLocalDate = startLocalDate.withDayOfMonth(startLocalDate.lengthOfMonth());
			LocalDate monthlyEndLocalDate = LocalDate.of(currentYear, 12, 1);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String startDate = startLocalDate.format(formatter);
			String dailyEndDate = dailyEndLocalDate.format(formatter);
			String monthlyEndDate = monthlyEndLocalDate.format(formatter);

			try {
				token = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "a"));
				tokenMobile = ParamUtil.getString(httpRequest, "m");
				startDate = Validator.isNull(ParamUtil.getString(httpRequest, "d")) == true ? startDate
						: ParamUtil.getString(httpRequest, "d");
				dailyEndDate = Validator.isNull(ParamUtil.getString(httpRequest, "e")) == true ? dailyEndDate
						: ParamUtil.getString(httpRequest, "e");

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
				// berarti belum pernah hit o/performance-booking/show
				if (helpers.isLog()) _log.info("DeptCode tidak pernah terdaftar di DB.");
			}

			if (authStatus) {
				JournalArticle _webContent = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, "scorecard-disclaimer");
				JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
						_webContent.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay);
				String disclaimerContent = articleDisplay.getContent();
				
				renderRequest.setAttribute("tokenMobile", tokenMobile);
				renderRequest.setAttribute("startDate", startDate);
				renderRequest.setAttribute("dailyEndDate", dailyEndDate);
				renderRequest.setAttribute("monthlyEndDate", monthlyEndDate);
				renderRequest.setAttribute("currentYear", currentYear);
				renderRequest.setAttribute("disclaimerContent", disclaimerContent);

				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/performancebooking/view.jsp");
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
//			 e.printStackTrace();
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
