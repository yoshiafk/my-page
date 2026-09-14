package com.mypage.esppk.jwt;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.mypage.esppk.util.ClockUtil;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import org.osgi.service.component.annotations.Component;

import javax.crypto.SecretKey;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

@Component(
    immediate = true,
    service = JwtHelper.class
)
public class JwtHelper {
    private static final Log log = LogFactoryUtil.getLog(JwtHelper.class);

    private final Clock clock;
    private final Supplier<UUID> uuidGenerator;

    public JwtHelper(Clock clock, Supplier<UUID> uuidGenerator) {
        this.clock = clock;
        this.uuidGenerator = uuidGenerator;
    }

    public JwtHelper() {
        this(ClockUtil.getSystemClock(), UUID::randomUUID);
    }

    public String generateToken(String fullName, String loginCode, String role, boolean accessData, boolean accessMonitoring, long validity, SecretKey key) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("fullName", fullName);
        claims.put("role", role);
        claims.put("accessData", accessData);
        claims.put("accessMonitoring", accessMonitoring);

        Instant now = Instant.now(clock);
        Date nowDate = Date.from(now);
        Date expiryDate = Date.from(now.plusSeconds(validity));

        return Jwts.builder()
                .setId(uuidGenerator.get().toString())
                .setSubject(loginCode)
                .setIssuedAt(nowDate)
                .setExpiration(expiryDate)
                .setNotBefore(nowDate)
                .setIssuer("esppk")
                .setAudience("internal")
                .addClaims(claims)
                .signWith(key)
                .compact();
    }

    public Claims validateToken(String token, SecretKey key) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            log.info("JWT expired at: " + e.getClaims().getExpiration());
        } catch (UnsupportedJwtException | MalformedJwtException | SecurityException | IllegalArgumentException e) {
            log.debug("Invalid JWT signature", e);
        }

        return new DefaultClaims();
    }

    public long remainingTime(String token, SecretKey key) {
        Claims claims = validateToken(token, key);
        if (claims.isEmpty()) return 0;

        Date expiration = claims.getExpiration();
        long now = Instant.now(clock).toEpochMilli();
        long diff = expiration.getTime() - now;
        return Math.max(diff / 1000, 0);
    }

    public String generateEmailToken(Map<String, Object> claims, long expirySeconds, SecretKey key) {
        Instant now = Instant.now(clock);
        Date nowDate = Date.from(now);

        Instant expiryInstant = now.plusSeconds(expirySeconds);
        Date expiry = Date.from(expiryInstant);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(nowDate)
                .setExpiration(expiry)
                .setIssuer("esppk")
                .signWith(key)
                .compact();
    }
}
