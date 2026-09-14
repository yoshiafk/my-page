//package com.axa.payment.portlet.action;
//
//import com.axa.payment.constants.PaymentInstructionPortletKeys;
//import com.axa.payment.helpers.ActionHelper;
//import com.axa.payment.helpers.EncryptionHelper;
//import com.axa.payment.service.PaymentTransactionLocalService;
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.json.JSONFactoryUtil;
//import com.liferay.portal.kernel.json.JSONObject;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.Validator;
//
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(
//		immediate = true,
//		property = {
//			"javax.portlet.name=" + PaymentInstructionPortletKeys.PAYMENT_INSTRUCTION,
//			"mvc.command.name=/data/payment/status"
//		},
//		service = MVCResourceCommand.class
//	)
//public class PaymentInstructionMVCResourceCommand extends BaseMVCResourceCommand {
//	private static ActionHelper helper = new ActionHelper();
//	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
//	private static String mode = helper.getConfig("com.axa.payment.mode");
//	private static Log _log = LogFactoryUtil.getLog(PaymentInstructionMVCResourceCommand.class);
//
//	@Override
//	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
//		JSONObject _response = JSONFactoryUtil.createJSONObject();
//		JSONObject _data = JSONFactoryUtil.createJSONObject();
//		
//		boolean status = true;
//		String message = StringPool.BLANK;
//		
//		HttpSession session = httpRequest.getSession();
//		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
//		String profileId = (String) session.getAttribute("PROFILE_ID");
//		
//		if (helper.isLog()) _log.info("SESSION ID INSTRUCTION: " + session.getId());
//		if (helper.isLog()) _log.info(policyNo);
//		if (helper.isLog()) _log.info(profileId);
//		
//		if (Validator.isNull(policyNo) == true && Validator.isNull(profileId) == true) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay") : "/signin-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//
//		double amount = (double) session.getAttribute("AMOUNT");
//		
//		if (amount == 0) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		String channel = (String) session.getAttribute("CHANNEL");
//		
//		if (Validator.isNull(channel) == true) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		String vaBca = (String) session.getAttribute("BCA");
//		String vaMandiri = (String) session.getAttribute("MANDIRI");
//		
//		if (Validator.isNull(vaBca) == true || Validator.isNull(vaMandiri) == true) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
//		String fullName = (String) session.getAttribute("FULLNAME");
//		String emailAddress = (String) session.getAttribute("EMAIL");
//		String mobileNumber = (String) session.getAttribute("PHONE");
//		
//		_data.put("invoiceNumber", EncryptionHelper.decrypt(invoiceNumber));
//		_data.put("fullName", Validator.isNotNull(fullName) ? EncryptionHelper.decrypt(fullName).length() > 46 ? helper.obfuscateFullName(EncryptionHelper.decrypt(fullName)).substring(0, 46).concat("....") : helper.obfuscateFullName(EncryptionHelper.decrypt(fullName)) : "");
//		_data.put("emailAddress", helper.obfuscateEmail(EncryptionHelper.decrypt(emailAddress)));
//		_data.put("mobileNumber", helper.obfuscatePhone(EncryptionHelper.decrypt(mobileNumber)));
//		_data.put("amount", amount);
//		_data.put("vaNumber", channel.equalsIgnoreCase("bca") == true ? EncryptionHelper.decrypt(vaBca) : EncryptionHelper.decrypt(vaMandiri));
//		_data.put("channel", channel.equalsIgnoreCase("bca") == true ? "Bank Central Asia" : "Bank Mandiri");
//		_response.put("data", _data);
//		_response.put("status", status);
//		_response.put("message", message);
//		
//		resourceResponse.getWriter().write(_response.toString());
//	}
//	
//	@Reference
//	private PaymentTransactionLocalService _paymentTransactionLocalService;
//}
