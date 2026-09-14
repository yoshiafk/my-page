//package com.axa.payment.portlet.action;
//
//import com.axa.payment.constants.PaymentPortletKeys;
//import com.axa.payment.helpers.ActionHelper;
//import com.axa.payment.helpers.EncryptionHelper;
//import com.axa.payment.model.PaymentTransaction;
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
//	immediate = true,
//	property = {
//		"javax.portlet.name=" + PaymentPortletKeys.PAYMENT,
//		"mvc.command.name=/get/list/channel"
//	},
//	service = MVCResourceCommand.class
//)
//public class PaymentMVCResourceCommand extends BaseMVCResourceCommand {
//	private static ActionHelper helper = new ActionHelper();
//	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
//	private static String mode = helper.getConfig("com.axa.payment.mode");
//	private static Log _log = LogFactoryUtil.getLog(PaymentMVCResourceCommand.class);
//
//	@Override
//	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
//		JSONObject _response = JSONFactoryUtil.createJSONObject();
//		JSONObject _data = JSONFactoryUtil.createJSONObject();
//		
//		HttpSession session = httpRequest.getSession();
//		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
//		String profileId = (String) session.getAttribute("PROFILE_ID");
//		
//		if (helper.isLog()) _log.info("SESSION ID PAYMENT: " + session.getId());
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
//		String referenceNumber = (String) session.getAttribute("REFERENCE");
//		String dueDate = (String) session.getAttribute("DUE_DATE");
//		double amount = (double) session.getAttribute("AMOUNT");
//		String invoiceNumber = generateInvoiceNumber(EncryptionHelper.decrypt(policyNo), EncryptionHelper.decrypt(profileId));
//		
//		int countInvoice = _paymentTransactionLocalService.countByPolicyProfileInvoice(EncryptionHelper.decrypt(policyNo), EncryptionHelper.decrypt(profileId), invoiceNumber);
//		
//		if (countInvoice > 0) {
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			
////			session.invalidate();
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		PaymentTransaction trx = _paymentTransactionLocalService.addTransaction(EncryptionHelper.decrypt(policyNo), EncryptionHelper.decrypt(profileId), invoiceNumber, EncryptionHelper.decrypt(referenceNumber), dueDate, amount);
//		
//		if (Validator.isNull(trx) == true) {
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			
////			session.invalidate();
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		session.setAttribute("INVOICE_NUMBER", EncryptionHelper.encrypt(trx.getInvoiceNumber()));
//		
//		String channel = (String) session.getAttribute("CHANNEL");
//		
//		if (Validator.isNotNull(channel) == true) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//			
//			session.removeAttribute("CHANNEL");
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
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
//		invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
//		
//		if (Validator.isNull(invoiceNumber) == true) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		String fullName = (String) session.getAttribute("FULLNAME");
//		String emailAddress = (String) session.getAttribute("EMAIL");
//		String mobileNumber = (String) session.getAttribute("PHONE");
//		
//		_data.put("invoiceNumber", EncryptionHelper.decrypt(invoiceNumber));
//		_data.put("fullName", Validator.isNotNull(fullName) ? EncryptionHelper.decrypt(fullName).length() > 46 ? helper.obfuscateFullName(EncryptionHelper.decrypt(fullName)).substring(0, 46).concat("....") : helper.obfuscateFullName(EncryptionHelper.decrypt(fullName)) : "");
//		_data.put("emailAddress", helper.obfuscateEmail(EncryptionHelper.decrypt(emailAddress)));
//		_data.put("mobileNumber", helper.obfuscatePhone(EncryptionHelper.decrypt(mobileNumber)));
//		_data.put("amount", amount);
//		_response.put("status", true);
//		_response.put("message", "");
//		_response.put("data", _data);
//		
//		resourceResponse.getWriter().write(_response.toString());
//	}
//	
//	protected String generateInvoiceNumber(String policyNo, String profileId) {
//		String latestInvoiceNumber = StringPool.BLANK;
//		
//		try {
//			latestInvoiceNumber = _paymentTransactionLocalService.getByPolicyProfile(policyNo, profileId).get(0).getInvoiceNumber();
//		} catch (Exception e) {
//			if (helper.isLog()) _log.info(e.getMessage());
//			return policyNo.concat("/XP0001");
//		}
//		
//		if (Validator.isNull(latestInvoiceNumber) == true) return policyNo.concat("/XP0001");
//		
//		long incrementNumber = Long.parseLong(latestInvoiceNumber.substring(latestInvoiceNumber.indexOf("XP") + 2)) + 1;
//		String formattedNumber = String.format("%04d", incrementNumber);
//		
//		return policyNo.concat("/XP").concat(formattedNumber);
//	}
//	
//	@Reference
//	private PaymentTransactionLocalService _paymentTransactionLocalService;
//}
