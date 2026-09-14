package com.mypage.esppk.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;
import com.mypage.esppk.helper.EncryptionHelper;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "com.liferay.portlet.display-category=AXA Insurance Indonesia",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EsppkOtp", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/otp.jsp", "javax.portlet.name=" + AiiEsppkWebPortletKeys.OTP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)

public class OtpPortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(OtpPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		log.info("Render OTP Portlet");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn()) {
			return;
		}

		// Set CSRF Token
		String secureToken = EncryptionHelper.generateSecureToken(32);
		renderRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken,
				PortletSession.PORTLET_SCOPE);

		renderRequest.setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken);

		log.debug(renderRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN,
				PortletSession.PORTLET_SCOPE));

		super.render(renderRequest, renderResponse);
	}
}
