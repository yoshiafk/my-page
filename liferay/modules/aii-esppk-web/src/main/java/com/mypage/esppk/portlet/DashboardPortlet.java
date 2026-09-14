package com.mypage.esppk.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;
import com.mypage.esppk.helper.ValidationAuthHelper;
import io.jsonwebtoken.Claims;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GOSITUS
 */
@Component(
    property = {
        "com.liferay.portlet.display-category=AXA Insurance Indonesia",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=DashboardEsppk",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/dashboard.jsp",
        "javax.portlet.name=" + AiiEsppkWebPortletKeys.DASHBOARD,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class DashboardPortlet extends MVCPortlet {
    private static final Log log = LogFactoryUtil.getLog(DashboardPortlet.class);

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        log.info("Render Dashboard Portlet");

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (themeDisplay.isSignedIn()) {
            return;
        }

        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(renderResponse);

        String jwtToken = validationAuthHelper.getCookieValue(httpRequest);

        if (jwtToken == null || jwtToken.isEmpty() ||
            !validationAuthHelper.isTokenValid(jwtToken) || validationAuthHelper.getTokenRemainingTime(jwtToken) <= 0) {

            validationAuthHelper.clearSessionCookie(httpResponse);
            validationAuthHelper.redirectToLogin(httpResponse);
            return;
        }

        if (validationAuthHelper.isSessionIdle(renderRequest)) {
            validationAuthHelper.clearSessionCookie(httpResponse);
            validationAuthHelper.redirectToLogin(httpResponse);
            return;
        }

        jwtToken = validationAuthHelper.refreshToken(jwtToken, httpResponse);

        Claims claims = validationAuthHelper.getClaims(jwtToken);

        renderRequest.setAttribute("fullName", claims.get("fullName").toString().toUpperCase());
        renderRequest.setAttribute("accessData", claims.get("accessData"));
        renderRequest.setAttribute("accessMonitoring", claims.get("accessMonitoring"));
        renderRequest.setAttribute(AiiEsppkWebPortletKeys.PAGE_ACTIVE, "dashboard");

        super.render(renderRequest, renderResponse);
    }

    @Reference(unbind = "-")
    private ValidationAuthHelper validationAuthHelper;
}