//package com.axa.payment.portlet.action;
//
//import com.axa.payment.constants.ProductPortletKeys;
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
////@Component(
////	immediate = true,
////	property = {
////		"javax.portlet.name=" + ProductPortletKeys.TRX,
////		"mvc.command.name=/data/trx"
////	},
////	service = MVCResourceCommand.class
////)
//public class TransactionMVCResourceCommand extends BaseMVCResourceCommand {
//	private static ActionHelper helper = new ActionHelper();
//	private static Log _log = LogFactoryUtil.getLog(TransactionMVCResourceCommand.class);
//
//	@Override
//	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
//		JSONObject _response = JSONFactoryUtil.createJSONObject();
//		
//		HttpSession session = httpRequest.getSession();
//		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
//		String profileId = (String) session.getAttribute("PROFILE_ID");
//		
//		if (helper.isLog()) _log.info("SESSION ID TRX: " + session.getId());
//		if (helper.isLog()) _log.info(policyNo);
//		if (helper.isLog()) _log.info(profileId);
//		
//		if (Validator.isNull(policyNo) == true && Validator.isNull(profileId) == true) {
//			String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
//			String mode = helper.getConfig("com.axa.payment.mode");
//			JSONObject _data = JSONFactoryUtil.createJSONObject();
//			
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
//		_response.put("status", true);
//		_response.put("message", "");
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
