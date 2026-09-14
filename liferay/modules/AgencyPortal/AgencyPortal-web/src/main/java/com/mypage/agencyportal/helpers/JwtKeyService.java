package com.mypage.agencyportal.helpers;

import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Activate;

/**
 * Service to provide a consistent JWT signing key across the application.
 */
@Component(
    immediate = true,
    service = JwtKeyService.class
)
public class JwtKeyService {
    private static final Log _log = LogFactoryUtil.getLog(JwtKeyService.class);
    
    // Use a fixed key for development - in production, this should be securely stored
    private static final String FIXED_KEY = "mypage-agencyportal-jwt-secret-key-for-development-only";
    
    private SecretKey key;
    
    /**
     * Initializes the JWT signing key.
     */
    @Activate
    protected void activate() {
        _log.info("Initializing JWT key service with fixed key");
        // Use a fixed key instead of generating a new one each time
        key = Keys.hmacShaKeyFor(FIXED_KEY.getBytes());
    }
    
    /**
     * Gets the shared JWT signing key.
     * 
     * @return SecretKey for JWT operations
     */
    public SecretKey getSigningKey() {
        return key;
    }
    
    /**
     * Gets the shared JWT signing key.
     * Alias for getSigningKey() for backward compatibility.
     * 
     * @return SecretKey for JWT operations
     */
    public SecretKey getKey() {
        return key;
    }

    /**
     * Validates a JWT token and returns the subject (email).
     * 
     * @param token The JWT token to validate
     * @return The subject (email) from the token if valid, null otherwise
     */
    public String validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            _log.error("Error validating token: " + e.getMessage());
            return null;
        }
    }
}
