//package com.axa.payment.portlet.action;
//
//import com.axa.payment.constants.AuthenticationPortletKeys;
//import com.axa.payment.helpers.ActionHelper;
//import com.axa.payment.helpers.EncryptionHelper;
//import com.liferay.captcha.configuration.CaptchaConfiguration;
//import com.liferay.captcha.util.CaptchaUtil;
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.captcha.CaptchaConfigurationException;
//import com.liferay.portal.kernel.captcha.CaptchaException;
//import com.liferay.portal.kernel.json.JSONFactoryUtil;
//import com.liferay.portal.kernel.json.JSONObject;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
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
//		"javax.portlet.name=" + AuthenticationPortletKeys.ATH,
//		"mvc.command.name=/verify/captcha"
//	},
//	service = MVCResourceCommand.class
//)
//public class CaptchaMVCResourceCommand extends BaseMVCResourceCommand {
//	private static ActionHelper helper = new ActionHelper();
//	private static Log _log = LogFactoryUtil.getLog(CaptchaMVCResourceCommand.class);
//	
//	@Override
//	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
//		JSONObject _response = JSONFactoryUtil.createJSONObject();
//		
//		String policyNo = ParamUtil.getString(httpRequest, "policyNo");
//		String profileId = ParamUtil.getString(httpRequest, "profileId");
//		
//		if (helper.isLog()) _log.info("REQUEST PAYLOAD");
//		if (helper.isLog()) _log.info(policyNo);
//		if (helper.isLog()) _log.info(profileId);
//		if (helper.isLog()) _log.info(ParamUtil.getString(httpRequest, "captchaText"));
//		
//		boolean status = true;
//		String message = StringPool.BLANK;
//		
//		try {
//			if (helper.isLog()) _log.info("SMARTPAY: Masuk Try");
//			_checkCaptcha(httpRequest);
//			if (helper.isLog()) _log.info("SMARTPAY: Setelah checkCaptcha");
//
//			if (helper.isLog()) _log.info("CAPTCHA verification successful.");
//			
//			HttpSession session = httpRequest.getSession();
//        	session.setAttribute("POLICY_NUMBER", EncryptionHelper.encrypt(policyNo));
//        	session.setAttribute("PROFILE_ID", EncryptionHelper.encrypt(profileId));
//        	
//        	if (helper.isLog()) _log.info("SESSION ID: " + session.getId());
//        	if (helper.isLog()) _log.info(session.getAttribute("POLICY_NUMBER"));
//    		if (helper.isLog()) _log.info(session.getAttribute("PROFILE_ID"));
//			
////			String tokenTimestamp = _setToken(policyNo, profileId);
////			String[] splitTokenTimestamp = tokenTimestamp.split("\\|");
////			
////			Cookie tokenCookie = new Cookie("ACCESS_TOKEN", splitTokenTimestamp[0]);
////        	tokenCookie.setSecure(true);
////        	tokenCookie.setMaxAge(3600);
////        	tokenCookie.setPath("/");
////        	
////        	httpResponse.addCookie(tokenCookie);
////        	
////        	Cookie timestampCookie = new Cookie("TOKEN_EXP", splitTokenTimestamp[1]);
////        	timestampCookie.setMaxAge(3600);
////        	timestampCookie.setPath("/");
////        	
////        	httpResponse.addCookie(timestampCookie);
//        } catch (Exception e) {
//			if (helper.isLog()) _log.info("SMARTPAY: Masuk catch");
//
//        	for (StackTraceElement item : e.getStackTrace()) {
//        		if (helper.isLog()) _log.info(item.toString());
//			}
//        	if (e instanceof CaptchaException) {
//        		if (helper.isLog()) _log.info(e.getMessage());
//        		for (StackTraceElement item : e.getStackTrace()) {
//            		if (helper.isLog()) _log.info(item.toString());
//    			}
//			}
//        	if (e instanceof CaptchaConfigurationException) {
//        		if (helper.isLog()) _log.info(e.getMessage());
//        		for (StackTraceElement item : e.getStackTrace()) {
//            		if (helper.isLog()) _log.info(item.toString());
//    			}
//			}
//        	if (helper.isLog()) _log.info("CAPTCHA verification failed.");
//        	
//        	status = false;
//			message = "Maaf Verifikasi Teks Anda tidak sesuai";
//        }
//		if (helper.isLog()) _log.info("SMARTPAY: Keluar try catch");
//		
//		_response.put("status", status);
//		_response.put("message", message);
//		resourceResponse.getWriter().write(_response.toString());
//	}
//	
//	protected CaptchaConfiguration getCaptchaConfiguration()
//		throws CaptchaConfigurationException {
//
//		try {
//			return _configurationProvider.getSystemConfiguration(
//				CaptchaConfiguration.class);
//		}
//		catch (Exception exception) {
//			throw new CaptchaConfigurationException(exception);
//		}
//	}
//
//	private void _checkCaptcha(HttpServletRequest httpServletRequest)
//		throws CaptchaConfigurationException, CaptchaException {
//
//		CaptchaConfiguration captchaConfiguration = getCaptchaConfiguration();
//
//		if (captchaConfiguration.sendPasswordCaptchaEnabled()) {
//			CaptchaUtil.check(httpServletRequest);
//		}
//	}
//	
////	private String _setToken(String policyNumber, String profileId) throws Exception {
////		String token = EncryptionHelper.encrypt(policyNumber.concat("|").concat(profileId));
////		long timestamp = System.currentTimeMillis() / 1000 + 3600;
////		
////		UserTransactionToken data = _userTransactionTokenLocalService.updateToken(policyNumber, profileId, null, null, null, null, null, 0, null, null, null, token, timestamp);
////		
////		return token.concat("|").concat(String.valueOf(timestamp));
////	}
//	
//	@Reference
//	private ConfigurationProvider _configurationProvider;
//	
////	@Reference
////	private UserTransactionTokenLocalService _userTransactionTokenLocalService;
//}