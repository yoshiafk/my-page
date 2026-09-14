package com.mypage.esppk.jwt;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.impl.DefaultClaims;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

@Component(
        immediate = true,
        service = JwtUtil.class
)
public class JwtUtil {
    private static final Log log = LogFactoryUtil.getLog(JwtUtil.class);

    private JwtKeyProvider jwtKeyProvider;
    private MasterGlobalVariableLocalService masterGlobalVariableLocalService;
    private JwtHelper jwtHelper;

    public String generateAccessToken(String fullName, String loginCode, String role, boolean accessData, boolean accessMonitoring) {
        if (masterGlobalVariableLocalService == null || jwtKeyProvider == null) {
            log.debug("Dependencies not injected. Cannot generate token.");
            return "";
        }

        String accessTokenValidity = masterGlobalVariableLocalService.getActiveGlobalVariableByGroup("JWT").stream()
                .filter(v -> v.getName().equalsIgnoreCase("ACCESS_TOKEN_VALIDITY") && v.getActive() == 1)
                .findFirst()
                .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "0" : v.getValue())
                .orElse("0");

        long validity = Long.parseLong(accessTokenValidity) * 60;
        SecretKey key = jwtKeyProvider.getSigningKey();
        return jwtHelper.generateToken(fullName, loginCode, role, accessData, accessMonitoring, validity, key);
    }

    public Claims validateToken(String token) throws JwtException {
        if (jwtKeyProvider == null) {
            log.debug("JwtKeyProvider not injected. Cannot validate token.");
            return new DefaultClaims();
        }

        SecretKey key = jwtKeyProvider.getSigningKey();
        return jwtHelper.validateToken(token, key);
    }

    public long remainingTime(String token, SecretKey key) throws JwtException {
        if (jwtKeyProvider == null) {
            log.debug("JwtKeyProvider not injected. Cannot validate token.");
            return 0;
        }

        return jwtHelper.remainingTime(token, key);
    }

    public String generateEmailToken(String to, String cc, String subject, long effectiveDate, long expSeconds, String urlSppk, String submissionNumber) {
        if (jwtHelper == null || jwtKeyProvider == null) {
            log.debug("Dependencies not injected. Cannot generate email token.");
            return "";
        }

        SecretKey key = jwtKeyProvider.getSigningKey();

        Map<String, Object> claims = buildEmailClaims(to, cc, subject, effectiveDate, expSeconds, urlSppk, submissionNumber);

        return jwtHelper.generateEmailToken(claims, expSeconds, key);
    }
    
    public String generateEmailOtpToken(String to, String cc, String subject, String name, String otp, long expSeconds) {
        if (jwtHelper == null || jwtKeyProvider == null) {
            log.debug("Dependencies not injected. Cannot generate email token.");
            return "";
        }

        SecretKey key = jwtKeyProvider.getSigningKey();

        Map<String, Object> otpEmail = buildEmailOtp(to, cc, subject, name, otp, expSeconds);

        return jwtHelper.generateEmailToken(otpEmail, expSeconds, key);
    }

    private Map<String, Object> buildEmailClaims(String to, String cc, String subject, long effectiveDate, long expSeconds, String urlSppk, String submissionNumber) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("to", to);

        if (cc != null && !cc.isEmpty()) {
            claims.put("cc", cc);
        }

        claims.put("subject", subject);
        claims.put("effectiveDate", effectiveDate);
        claims.put("urlSppk", urlSppk);
        claims.put("exp", expSeconds);
        claims.put("submissionNumber", submissionNumber);
        return claims;
    }
    
    private Map<String, Object> buildEmailOtp(String to, String cc, String subject, String name, String otp, long expSeconds) {
        Map<String, Object> emailOtp = new HashMap<>();
        emailOtp.put("to", to);

        if (cc != null && !cc.isEmpty()) {
        	emailOtp.put("cc", cc);
        }

        emailOtp.put("subject", subject);
        emailOtp.put("name", name);
        emailOtp.put("otp", otp);
        emailOtp.put("exp", expSeconds);
        return emailOtp;
    }

    public SecretKey getSigningKey() {
        return jwtKeyProvider.getSigningKey();
    }

    @Reference(unbind = "-")
    protected void setJwtKeyProvider(JwtKeyProvider jwtKeyProvider) {
        this.jwtKeyProvider = jwtKeyProvider;
    }

    @Reference(unbind = "-")
    protected void setMasterGlobalVariableLocalService(MasterGlobalVariableLocalService service) {
        this.masterGlobalVariableLocalService = service;
    }

    @Reference(unbind = "-")
    protected void setJwtHelper(JwtHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }
}
