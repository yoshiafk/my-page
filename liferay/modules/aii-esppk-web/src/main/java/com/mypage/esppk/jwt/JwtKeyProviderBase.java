package com.mypage.esppk.jwt;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class JwtKeyProviderBase {
    private static final Log log = LogFactoryUtil.getLog(JwtKeyProviderBase.class);

    private final String secretKey;
    private SecretKey key;

    public JwtKeyProviderBase(String secretKey) {
        this.secretKey = secretKey;
    }

    public void initKey() {
        if (secretKey == null || secretKey.isEmpty()) {
            log.debug("JWT secret key not found or empty. Check configuration.");
            return;
        }

        if (secretKey.length() < 32) {
            log.debug("JWT secret key must be at least 32 characters. Check configuration.");
            return;
        }

        key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public SecretKey getSigningKey() {
        return key;
    }
}
