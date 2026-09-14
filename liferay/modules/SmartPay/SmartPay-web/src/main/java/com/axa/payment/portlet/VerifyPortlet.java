package com.axa.payment.portlet;

import com.axa.payment.constants.VerifyPortletKeys;
import com.axa.payment.helpers.ActionHelper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prawiranegara
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=axaPay",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Payment Verification SmartPay",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/payment/verify.jsp",
		"javax.portlet.name=" + VerifyPortletKeys.VERIFY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class VerifyPortlet extends MVCPortlet {
	private static ActionHelper helper = new ActionHelper();
	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
	private static Log _log = LogFactoryUtil.getLog(VerifyPortlet.class);
	
	@Override 
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		try {
			request.setAttribute("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
		} catch (Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}
		 
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/payment/verify.jsp");
		dispatcher.include(request, response);
	}
}
