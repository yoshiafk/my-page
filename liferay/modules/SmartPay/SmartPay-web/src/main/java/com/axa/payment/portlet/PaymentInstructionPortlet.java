package com.axa.payment.portlet;

import com.axa.payment.constants.PaymentInstructionPortletKeys;
import com.axa.payment.helpers.ActionHelper;
import com.axa.payment.helpers.EncryptionHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		"javax.portlet.display-name=Payment Instruction SmartPay",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/payment/instruction/view.jsp",
		"javax.portlet.name=" + PaymentInstructionPortletKeys.PAYMENT_INSTRUCTION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PaymentInstructionPortlet extends MVCPortlet {
	private static ActionHelper helper = new ActionHelper();
	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
	private static Log _log = LogFactoryUtil.getLog(PaymentInstructionPortlet.class);
	
	@Override 
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		
		try {
			HttpSession session = httpRequest.getSession();
			String channel = (String) session.getAttribute("CHANNEL");
			String vaBca = (String) session.getAttribute("BCA");
			String vaMandiri = (String) session.getAttribute("MANDIRI");
			
			if (Validator.isNotNull(channel)) {
				request.setAttribute("channel", channel);
				request.setAttribute("vaNumber", channel.equalsIgnoreCase("bca") == true ? EncryptionHelper.decrypt(vaBca) : EncryptionHelper.decrypt(vaMandiri));
			}
			request.setAttribute("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
		} catch (Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}
		 
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/payment/instruction/view.jsp");
		dispatcher.include(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		
		if (helper.isLog()) _log.info(resourceID);
			
		try {
			if (resourceID.equalsIgnoreCase("getdatapaymentstatus")) {
				getDataPaymentStatus(resourceRequest, resourceResponse);
			} else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		} catch(Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}
	}
	
	public void getDataPaymentStatus(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		boolean status = true;
		String message = StringPool.BLANK;
		
		HttpSession session = httpRequest.getSession();
		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
		String profileId = (String) session.getAttribute("PROFILE_ID");
		
		if (helper.isLog()) _log.info("SESSION ID INSTRUCTION: " + session.getId());
		if (helper.isLog()) _log.info(policyNo);
		if (helper.isLog()) _log.info(profileId);
		
		if (Validator.isNull(policyNo) == true && Validator.isNull(profileId) == true) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay") : "/signin-smartpay");
			_response.put("status", false);
			_response.put("message", "Periksa kembali Nomor Polis dan ID Profil Anda, lalu silakan coba lagi.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}

		double amount = (double) session.getAttribute("AMOUNT");
		
		if (amount == 0) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
			_response.put("status", false);
			_response.put("message", "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		String channel = (String) session.getAttribute("CHANNEL");
		
		if (Validator.isNull(channel) == true) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
			_response.put("status", false);
			_response.put("message", "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		String vaBca = (String) session.getAttribute("BCA");
		String vaMandiri = (String) session.getAttribute("MANDIRI");
		
		if (Validator.isNull(vaBca) == true && Validator.isNull(vaMandiri) == true) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
			_response.put("status", false);
			_response.put("message", "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
		String fullName = (String) session.getAttribute("FULLNAME");
		String emailAddress = (String) session.getAttribute("EMAIL");
		String mobileNumber = (String) session.getAttribute("PHONE");
		
		_data.put("invoiceNumber", EncryptionHelper.decrypt(invoiceNumber));
		_data.put("fullName", Validator.isNotNull(fullName) ? EncryptionHelper.decrypt(fullName).length() > 46 ? helper.obfuscateFullName(EncryptionHelper.decrypt(fullName)).substring(0, 46).concat("....") : helper.obfuscateFullName(EncryptionHelper.decrypt(fullName)) : "");
		_data.put("emailAddress", Validator.isNotNull(emailAddress) ? helper.obfuscateEmail(EncryptionHelper.decrypt(emailAddress)) : "");
		_data.put("mobileNumber", Validator.isNotNull(mobileNumber) ? helper.obfuscatePhone(EncryptionHelper.decrypt(mobileNumber)) : "");
		_data.put("amount", amount);
		_data.put("vaNumber", channel.equalsIgnoreCase("bca") == true ? EncryptionHelper.decrypt(vaBca) : EncryptionHelper.decrypt(vaMandiri));
		_data.put("channel", channel.equalsIgnoreCase("bca") == true ? "Bank Central Asia" : "Bank Mandiri");
		_response.put("data", _data);
		_response.put("status", status);
		_response.put("message", message);
		
		resourceResponse.getWriter().write(_response.toString());
	}
}
