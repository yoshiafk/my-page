//package com.axa.payment.portlet.action;
//
//import com.axa.payment.constants.PaymentPortletKeys;
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
//import com.liferay.portal.kernel.util.ParamUtil;
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
//		"javax.portlet.name=" + PaymentPortletKeys.PAYMENT_INTERN,
//		"mvc.command.name=/data/internal"
//	},
//	service = MVCResourceCommand.class
//)
//public class PaymentInternalMVCResourceCommand extends BaseMVCResourceCommand {
//	private static ActionHelper helper = new ActionHelper();
//	private static Log _log = LogFactoryUtil.getLog(PaymentInternalMVCResourceCommand.class);
//
//	@Override
//	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
//		JSONObject _response = JSONFactoryUtil.createJSONObject();
//		
//		boolean status = true;
//		String message = StringPool.BLANK;
//		String target = ParamUtil.getString(httpRequest, "target");
//		
//		if (Validator.isNull(target) == true) {
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		HttpSession session = httpRequest.getSession();
//		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
//		String profileId = (String) session.getAttribute("PROFILE_ID");
//		
//		if (helper.isLog()) _log.info("SESSION ID PAYMENT INTERNAL: " + session.getId());
//		if (helper.isLog()) _log.info(policyNo);
//		if (helper.isLog()) _log.info(profileId);
//		
//		if (Validator.isNull(policyNo) == true && Validator.isNull(profileId) == true) {
//			String PIMCORE_HOST = helper.getConfig("com.mypage.agent.config.pimcoreHost");
//			String mode = helper.getConfig("com.axa.payment.mode");
//			JSONObject _data = JSONFactoryUtil.createJSONObject();
//			
//			_data.put("target", mode.equalsIgnoreCase("prod") ? PIMCORE_HOST.concat("/smartpay") : "/signin-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
//		
//		try {
//			String paymentChannel = target.contains("BCA") ? "BCA" : "MANDIRI";
//			_paymentTransactionLocalService.updateTransactionMethodChannel(EncryptionHelper.decrypt(invoiceNumber), target, paymentChannel);
//			
//			session.setAttribute("CHANNEL", paymentChannel);
//		} catch (Exception e) {
//			status = false;
//			message = "Sorry we couldn't complete your request, please try again in a moment";
//		}
//		
//		_response.put("status", status);
//		_response.put("message", message);
//		resourceResponse.getWriter().write(_response.toString());
//	}
//	
//	@Reference
//	private PaymentTransactionLocalService _paymentTransactionLocalService;
//}
