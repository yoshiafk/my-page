package com.mypage.esppk.service;

import com.aii.esppk.admin.model.SppkUser;
import com.aii.esppk.admin.service.SppkUserLocalService;
import com.aii.esppk.admin.service.SppkUserLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;
import com.mypage.esppk.helper.EncryptionHelper;
import com.mypage.esppk.jwt.JwtUtil;
import com.mypage.esppk.util.ClockUtil;

import java.time.Clock;
import java.time.Instant;
import java.util.function.Supplier;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Component(immediate = true, service = AuthService.class)
public class AuthService {

	private JwtUtil jwtUtil;
	private SppkUserLocalService sppkUserLocalService;
	private Clock clock;
	private Supplier<String> csrfGenerator;

	public AuthService() {
		this.clock = ClockUtil.getSystemClock();
		this.csrfGenerator = () -> EncryptionHelper.generateSecureToken(32);
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	public void setCsrfGenerator(Supplier<String> csrfGenerator) {
		this.csrfGenerator = csrfGenerator;
	}

	// Process OTP
	public AuthResult processOTP(String email, String otpCode, String csrfTokenFromRequest, String csrfTokenSession) {
		AuthResult result = new AuthResult();

        AuthResult csrfResult = validateCsrfToken(csrfTokenFromRequest, csrfTokenSession);

        if (!csrfResult.isValidCsrf()) {
            return csrfResult;
        }

        result.setValidCsrf(csrfResult.isValidCsrf());
        result.setNewCsrfToken(csrfResult.getNewCsrfToken());
		
		// Validate OTP
		SppkUser user = SppkUserLocalServiceUtil.verifyOtp(email, otpCode);
		
		if(Validator.isNull(user)) {
			result.setValidOtp(false);
			result.setErrorMessage("Kode OTP tidak valid.");
			return result;
		} else {
			result.setValidOtp(true);
		}

		// Generate JWT
		String token = jwtUtil.generateAccessToken(user.getFullName(), user.getSppkLoginCode(), user.getRoleCode(),
				user.getAccessData() == 1, user.getAccessMonitoring() == 1);

		long nowTimestamp = Instant.now(clock).toEpochMilli();
		result.setToken(token);
		result.setLastActive(nowTimestamp);

		return result;
	}

	// Process Login
	public AuthResult signin(String username, String password, String csrfTokenFromRequest, String csrfTokenSession) {
		AuthResult result = new AuthResult();

        AuthResult csrfResult = validateCsrfToken(csrfTokenFromRequest, csrfTokenSession);

        if (!csrfResult.isValidCsrf()) {
            return csrfResult;
        }

        result.setValidCsrf(csrfResult.isValidCsrf());
        result.setNewCsrfToken(csrfResult.getNewCsrfToken());

		// Get user
		SppkUser user = sppkUserLocalService.getByLoginCode(username);
		if (user == null || user.getActive() != 1) {
			result.setErrorMessage(AiiEsppkWebPortletKeys.MSG_INVALID_USER);
			return result;
		}

		// Password verification
		BCrypt.Result isAuthenticated = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
		if (!isAuthenticated.verified) {
			result.setErrorMessage(AiiEsppkWebPortletKeys.MSG_INVALID_USER);
			return result;
		}

		return result;
	}
	
	public AuthResult signinNonOtp(String username, String password, String csrfTokenFromRequest, String csrfTokenSession) {
		AuthResult result = new AuthResult();

        AuthResult csrfResult = validateCsrfToken(csrfTokenFromRequest, csrfTokenSession);

        if (!csrfResult.isValidCsrf()) {
            return csrfResult;
        }

        result.setValidCsrf(csrfResult.isValidCsrf());
        result.setNewCsrfToken(csrfResult.getNewCsrfToken());

		// Get user
		SppkUser user = sppkUserLocalService.getByLoginCode(username);
		if (user == null) {
			result.setErrorMessage(AiiEsppkWebPortletKeys.MSG_INVALID_USER);
			return result;
		}

		// Password verification
		BCrypt.Result isAuthenticated = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
		if (!isAuthenticated.verified) {
			result.setErrorMessage(AiiEsppkWebPortletKeys.MSG_INVALID_USER);
			return result;
		}
		
		// Generate JWT
		String token = jwtUtil.generateAccessToken(user.getFullName(), user.getSppkLoginCode(), user.getRoleCode(),
				user.getAccessData() == 1, user.getAccessMonitoring() == 1);

		long nowTimestamp = Instant.now(clock).toEpochMilli();
		result.setToken(token);
		result.setLastActive(nowTimestamp);

		return result;
	}

    public AuthResult validateCsrfToken(String csrfTokenFromRequest, String csrfTokenSession) {
        AuthResult result = new AuthResult();

        boolean isValid = csrfTokenSession != null &&
                csrfTokenSession.equalsIgnoreCase(csrfTokenFromRequest);

        result.setValidCsrf(isValid);
        result.setNewCsrfToken(csrfGenerator.get());

        if (!isValid) {
            result.setErrorMessage(AiiEsppkWebPortletKeys.MSG_INVALID_CSRF);
        }

        return result;
    }

    public static class AuthResult {
		private boolean validCsrf;
		private String newCsrfToken;
		private String errorMessage;
		private String token;
		private long lastActive;
		private boolean validOtp;

		// Getters & Setters
		public boolean isValidCsrf() {
			return validCsrf;
		}

		public void setValidCsrf(boolean validCsrf) {
			this.validCsrf = validCsrf;
		}

		public String getNewCsrfToken() {
			return newCsrfToken;
		}

		public void setNewCsrfToken(String newCsrfToken) {
			this.newCsrfToken = newCsrfToken;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public long getLastActive() {
			return lastActive;
		}

		public void setLastActive(long lastActive) {
			this.lastActive = lastActive;
		}
		
		public boolean isValidOtp() {
			return validOtp;
		}
		
		public void setValidOtp(boolean validOtp) {
			this.validOtp = validOtp;
		}
	}

    private static Log log = LogFactoryUtil.getLog(AuthService.class);

	@Reference(unbind = "-")
	protected void setJwtUtil(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Reference(unbind = "-")
	protected void setSppkUserLocalService(SppkUserLocalService sppkUserLocalService) {
		this.sppkUserLocalService = sppkUserLocalService;
	}
}
