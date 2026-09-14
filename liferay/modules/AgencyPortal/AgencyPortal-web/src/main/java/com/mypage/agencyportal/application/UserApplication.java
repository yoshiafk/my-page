package com.mypage.agencyportal.application;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.agencyportal.constants.AgentAuthenticationPortletKeys;
import com.mypage.agencyportal.dto.StatusUserDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EmailHelper;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.UserOneTimeCode;
import com.mypage.user.service.MypageUserLocalServiceUtil;
import com.mypage.user.service.UserOneTimeCodeLocalServiceUtil;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/user",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=User.Rest",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true"
	},
	service = Application.class
)
public class UserApplication extends Application {
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	@POST
	@Path("/otp-login")
	@Produces("application/json")
	public String otpLogin(String request) throws Exception {
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();

		ActionHelpers actionHelpers = new ActionHelpers();
		EmailHelper emailHelper = new EmailHelper();
		
		String message = StringPool.BLANK;
		StatusUserDto statusUser = actionHelpers.checkUserExist(params);
		
		if (statusUser.getStatus().equalsIgnoreCase("locked") && statusUser.getIsTimetoUnlock() == true) {
			int counter = 0;
			String status = "Active";
			long expiresTime = (MypageUserLocalServiceUtil.fetchMypageUser(statusUser.getUserId()).getEndDate().getTime() / 1000) + (-7 * 3600);
			
			MypageUserLocalServiceUtil.updateCounterById(statusUser.getAuthUserId(), counter);
			MypageUserLocalServiceUtil.updateStatusById(statusUser.getAuthUserId(), status);
			
			statusUser.setStatus(status);
			statusUser.setExpiresTime(expiresTime);
		}
		
		if (statusUser.getUserId() == 0) {
			String password = params.getString("Password");
			
			if (Validator.isNotNull(password)) {
				message = AgentAuthenticationPortletKeys.MSG_LOGIN_FAILED;
				
				if (statusUser.getAuthUserId() > 0) {
					int counter = MypageUserLocalServiceUtil.fetchMypageUser(statusUser.getAuthUserId()).getLoginCounter();
					
					counter += 1;
					MypageUserLocalServiceUtil.updateCounterById(statusUser.getAuthUserId(), counter);
					
					if (counter > 4) {
						String status = "Locked"; 
						status = MypageUserLocalServiceUtil.updateStatusById(statusUser.getAuthUserId(), status).getStatus();
						
						if (status.equalsIgnoreCase("locked")) message = AgentAuthenticationPortletKeys.MSG_LOGIN_LOCKED;
					}
				}
			}
			
			if (Validator.isNull(password)) message = AgentAuthenticationPortletKeys.MSG_EMAIL_FAILED;
			
			_output.put("status", false);
			_output.put("message", message);
			
			return _output.toString();
		}
		
		long currentTime = System.currentTimeMillis() / 1000;
		
		if (statusUser.getStatus().equalsIgnoreCase("active") && currentTime > statusUser.getExpiresTime()) {
			message = AgentAuthenticationPortletKeys.MSG_ACCOUNT_EXPIRES;
			
			_output.put("status", false);
			_output.put("message", message);
			
			return _output.toString();
		}
		
		if (statusUser.getStatus().equalsIgnoreCase("active") == false) {
			if (Validator.isNull(statusUser.getStatus())) message = AgentAuthenticationPortletKeys.MSG_LOGIN_INACTIVE;
			if (statusUser.getStatus().equalsIgnoreCase("inactive")) message = AgentAuthenticationPortletKeys.MSG_LOGIN_INACTIVE;
			if (statusUser.getStatus().equalsIgnoreCase("locked")) message = AgentAuthenticationPortletKeys.MSG_LOGIN_LOCKED;
			
			_output.put("status", false);
			_output.put("message", message);
			
			return _output.toString();
		}
		
		List<UserOneTimeCode> userOneTimeCodes = UserOneTimeCodeLocalServiceUtil.getUserOTPUnused(statusUser.getUserId());
		
		if (userOneTimeCodes.size() > 0) {
			for (UserOneTimeCode item : userOneTimeCodes) UserOneTimeCodeLocalServiceUtil.updateUserOTP(statusUser.getUserId(), item.getSharedSecret());
		}

		int minuteExpires = 5;
		String sharedSecret = actionHelpers.getOTP(6);
		String recipient = "demo@localhost.com"; // actionHelpers.getEmail(params);
		String subject = "[AgencyPortal] Kode Verifikasi";
		message = "Kode Verifikasi Anda adalah ".concat(sharedSecret);
		
		boolean success = emailHelper.sendEmail(recipient, subject, message);
		
		if (success == true) UserOneTimeCodeLocalServiceUtil.addUserOTP(statusUser.getUserId(), sharedSecret, minuteExpires);
		
		_data.put("email", actionHelpers.obfuscateEmail(recipient));
		_output.put("status", true);
		_output.put("message", "");
		_output.put("data", _data);

		return _output.toString();
	}
	
	@POST
	@Path("/login")
	@Produces("application/json")
	public String login(String request, @Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) throws JSONException, PortalException {
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		ActionHelpers actionHelpers = new ActionHelpers();

		String username = actionHelpers.getEmail(params);
		MypageUser user = MypageUserLocalServiceUtil.getUserByEmail(username);
		
		String sharedSecret = params.getString("Verification");
		long userId = user.getMypageUserId();

		UserOneTimeCode userOneTimeCode = UserOneTimeCodeLocalServiceUtil.getUserOTP(userId, sharedSecret);
		
		if (Validator.isNull(userOneTimeCode)) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		long currentTime = System.currentTimeMillis() / 1000;
		long expireTime = userOneTimeCode.getTimestampExpiryDate();
		boolean isUsed = (userOneTimeCode.getIsUsed() > 0);
		
		if ((currentTime > expireTime) && isUsed == false) {
			UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, sharedSecret);
			
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		if (isUsed == true) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, sharedSecret);
		
		HttpSession session = httpServletRequest.getSession();
    	session.setAttribute(WebKeys.USER_ID, userId);
		
		_data.put("url", "/dashboard");
		_output.put("status", true);
		_output.put("message", AgentAuthenticationPortletKeys.MSG_LOGIN_SUCCESS);
		_output.put("data", _data);

		return _output.toString();
	}
	
	@POST
	@Path("/otp-activation")
	@Produces("application/json")
	public String otpActivation(String request) throws JSONException {
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		ActionHelpers actionHelpers = new ActionHelpers();
		EmailHelper emailHelper = new EmailHelper();
		
		String message = StringPool.BLANK;
		String username = actionHelpers.getEmail(params);
		
		if (Validator.isEmailAddress(username) == false) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_NOT_FOUND);
			
			return _output.toString();
		}
		
		MypageUser user = MypageUserLocalServiceUtil.getUserByEmail(username);
		
		if (Validator.isNull(user)) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_ACTIVATION_FAILED);
			
			return _output.toString();
		}
		
		long userId = user.getMypageUserId();
		String status = user.getStatus();
		long currentTime = System.currentTimeMillis() / 1000;
		long expiresTime = (user.getEndDate().getTime() / 1000) + (-7 * 3600);
		
		if (currentTime > expiresTime) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_ACTIVATION_EXPIRES);
			
			return _output.toString();
		}
		
		if (status.equalsIgnoreCase("inactive") == false) {
			if (Validator.isNull(status)) message = AgentAuthenticationPortletKeys.MSG_ACTIVATION_LOCKED;
			if (status.equalsIgnoreCase("active")) message = AgentAuthenticationPortletKeys.MSG_ACTIVATION_ACTIVE;
			if (status.equalsIgnoreCase("locked")) message = AgentAuthenticationPortletKeys.MSG_ACTIVATION_LOCKED;
			
			_output.put("status", false);
			_output.put("message", message);
			
			return _output.toString();
		}
		
		List<UserOneTimeCode> userOneTimeCodes = UserOneTimeCodeLocalServiceUtil.getUserOTPUnused(userId);
		
		if (userOneTimeCodes.size() > 0) {
			for (UserOneTimeCode item : userOneTimeCodes) UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, item.getSharedSecret());
		}

		int minuteExpires = 5;
		String sharedSecret = actionHelpers.getOTP(6);
		String recipient = "demo@localhost.com"; // username;
		String subject = "[AgencyPortal] Kode Aktivasi";
		message = "Kode Aktivasi Anda adalah ".concat(sharedSecret);
		
		boolean success = emailHelper.sendEmail(recipient, subject, message);
		
		if (success == true) UserOneTimeCodeLocalServiceUtil.addUserOTP(userId, sharedSecret, minuteExpires);
		
		_data.put("email", actionHelpers.obfuscateEmail(recipient));
		_output.put("status", true);
		_output.put("message", "");
		_output.put("data", _data);

		return _output.toString();
	}
	
	@POST
	@Path("/activation")
	@Produces("application/json")
	public String activation(String request) throws Exception {
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		
		ActionHelpers actionHelpers = new ActionHelpers();

		String username = actionHelpers.getEmail(params);
		MypageUser user = MypageUserLocalServiceUtil.getUserByEmail(username);
		
		byte[] encryptedBytes = Base64.getDecoder().decode(params.getString("Password"));
		String password = new String(encryptedBytes);
		String encryptedPassword = EncryptionHelper.encryptPassword(password);
		String sharedSecret = params.getString("Verification");
		long userId = user.getMypageUserId();
		String status = "Active";

		UserOneTimeCode userOneTimeCode = UserOneTimeCodeLocalServiceUtil.getUserOTP(userId, sharedSecret);
		
		if (Validator.isNull(userOneTimeCode)) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		long currentTime = System.currentTimeMillis() / 1000;
		long expireTime = userOneTimeCode.getTimestampExpiryDate();
		boolean isUsed = (userOneTimeCode.getIsUsed() > 0);
		
		if ((currentTime > expireTime) && isUsed == false) {
			UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, sharedSecret);
			
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		if (isUsed == true) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, sharedSecret);
		MypageUserLocalServiceUtil.updateStatusById(userId, status);
		
		boolean isSamePassword = (MypageUserLocalServiceUtil.authenticateForBasic(username, encryptedPassword) > 0);
		
		if (isSamePassword == false) {
			MypageUser data = MypageUserLocalServiceUtil.fetchMypageUser(userId);
			data.setUserPassword(encryptedPassword);
			
			MypageUserLocalServiceUtil.updateMypageUser(data);
		}
		
		_output.put("status", true);
		_output.put("message", AgentAuthenticationPortletKeys.MSG_ACTIVATION_SUCCESS);

		return _output.toString();
	}
	
	@POST
	@Path("/link-forgot-password")
	@Produces("application/json")
	public String linkForgotPassword(String request) throws Exception {
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		
		EmailHelper emailHelper = new EmailHelper();
		
		String username = params.getString("Username");
		
		if (Validator.isEmailAddress(username) == false) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_EMAIL_FAILED);
			
			return _output.toString();
		}
		
		MypageUser user = MypageUserLocalServiceUtil.getUserByEmail(username);
		
		if (Validator.isNull(user)) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_EMAIL_FAILED);
			
			return _output.toString();
		}
		
		long userId = user.getMypageUserId();
		int minuteExpires = 5;
		String _secureToken = EncryptionHelper.generateSecureToken(32);
		String link = "http://localhost:8080/forgot-password?a=".concat(_secureToken);
		
		MypageUserLocalServiceUtil.updateTempCodeById(userId, _secureToken, minuteExpires);
	
		String recipient = "demo@localhost.com"; // username;
		String subject = "[AgencyPortal] Link Forgot Password";
		String message = "Silakan klik link berikut untuk mengubah password Anda ".concat(link);
		
		emailHelper.sendEmail(recipient, subject, message);
		
		_output.put("status", true);
		_output.put("message", AgentAuthenticationPortletKeys.MSG_LINK_FORGOT_SEND);

		return _output.toString();
	}
	
	@POST
	@Path("/otp-forgot-password")
	@Produces("application/json")
	public String otpForgotPassword(String request) throws JSONException {
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		ActionHelpers actionHelpers = new ActionHelpers();
		EmailHelper emailHelper = new EmailHelper();
		
		String message = StringPool.BLANK;
		String username = actionHelpers.getEmail(params);
		
		MypageUser user = MypageUserLocalServiceUtil.getUserByEmail(username);
		long userId = user.getMypageUserId();
		
		List<UserOneTimeCode> userOneTimeCodes = UserOneTimeCodeLocalServiceUtil.getUserOTPUnused(userId);
		
		if (userOneTimeCodes.size() > 0) {
			for (UserOneTimeCode item : userOneTimeCodes) UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, item.getSharedSecret());
		}
		
		int minuteExpires = 5;
		String sharedSecret = actionHelpers.getOTP(6);
		String recipient = "demo@localhost.com"; // username;
		String subject = "[AgencyPortal] Kode Verifikasi";
		message = "Kode Verifikasi Anda adalah ".concat(sharedSecret);
		
		boolean success = emailHelper.sendEmail(recipient, subject, message);
		
		if (success == true) UserOneTimeCodeLocalServiceUtil.addUserOTP(userId, sharedSecret, minuteExpires);
		
		_data.put("email", actionHelpers.obfuscateEmail(recipient));
		_output.put("status", true);
		_output.put("message", "");
		_output.put("data", _data);

		return _output.toString();
	}
	
	@POST
	@Path("/forgot-password")
	@Produces("application/json")
	public String forgotPassword(String request) throws Exception {
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		ActionHelpers actionHelpers = new ActionHelpers();

		String username = actionHelpers.getEmail(params);
		MypageUser user = MypageUserLocalServiceUtil.getUserByEmail(username);
		
		byte[] encryptedBytes = Base64.getDecoder().decode(params.getString("Password"));
		String password = new String(encryptedBytes);
		String encryptedPassword = EncryptionHelper.encryptPassword(password);
		String sharedSecret = params.getString("Verification");
		long userId = user.getMypageUserId();
		String token = null;
		int expiresIn = 0;

		UserOneTimeCode userOneTimeCode = UserOneTimeCodeLocalServiceUtil.getUserOTP(userId, sharedSecret);
		
		if (Validator.isNull(userOneTimeCode)) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		long currentTime = System.currentTimeMillis() / 1000;
		long expireTime = userOneTimeCode.getTimestampExpiryDate();
		boolean isUsed = (userOneTimeCode.getIsUsed() > 0);
		
		if ((currentTime > expireTime) && isUsed == false) {
			UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, sharedSecret);
			
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		if (isUsed == true) {
			_output.put("status", false);
			_output.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
			
			return _output.toString();
		}
		
		UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, sharedSecret);
		MypageUserLocalServiceUtil.updateTempCodeById(userId, token, expiresIn);
		
		boolean isSamePassword = (MypageUserLocalServiceUtil.authenticateForBasic(username, encryptedPassword) > 0);
		
		if (isSamePassword == false) {
			MypageUser data = MypageUserLocalServiceUtil.fetchMypageUser(userId);
			data.setUserPassword(encryptedPassword);
			
			MypageUserLocalServiceUtil.updateMypageUser(data);
		}
		
		_data.put("url", "/auth");
		_output.put("status", true);
		_output.put("message", AgentAuthenticationPortletKeys.MSG_FORGOT_SUCCESS);
		_output.put("data", _data);

		return _output.toString();
	}
}