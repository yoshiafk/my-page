package com.mypage.agencyportal.helpers;

import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import javax.crypto.SecretKey;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class JwtAuthHelper {

    public static class AuthResult {
        public final boolean valid;
        public final String error;
        public final MypageUser user;
        public final Claims claims;

        public AuthResult(boolean valid, String error, MypageUser user, Claims claims) {
            this.valid = valid;
            this.error = error;
            this.user = user;
            this.claims = claims;
        }
    }

    public static AuthResult authenticate(String authHeader, SecretKey key) {
        final String BEARER_PREFIX = "Bearer ";
        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
            return new AuthResult(false, "Missing or invalid Authorization header", null, null);
        }
        try {
            String jwtToken = authHeader.substring(BEARER_PREFIX.length());
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody();

            String deptoreCode = claims.getSubject();
            if (claims.getExpiration() == null || claims.getExpiration().before(new java.util.Date())) {
                return new AuthResult(false, "Token invalid atau sudah expired", null, null);
            }
            MypageUser user = MypageUserLocalServiceUtil.getByDeptoreCode(deptoreCode);
            if (user == null) {
                return new AuthResult(false, "User not found", null, null);
            }
            return new AuthResult(true, null, user, claims);
        } catch (JwtException e) {
            return new AuthResult(false, "Token tidak valid", null, null);
        } catch (Exception e) {
            return new AuthResult(false, "Auth error: " + e.getMessage(), null, null);
        }
    }

    public static String getJwtToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.substring(7);
    }

    public static MypageUser getAuthenticatedUser(String authHeader, JwtKeyService jwtKetService) throws Exception {
        SecretKey key = jwtKetService.getKey();
        JwtAuthHelper.AuthResult authResult = JwtAuthHelper.authenticate(authHeader, key);
        if (!authResult.valid) {
            throw new WebApplicationException(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity(JsonResponseHelper.error(authResult.error).toString())
                            .build());
        }
        if (authResult.user == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity(JsonResponseHelper.error("Agent not found").toString())
                            .build());
        }
        return authResult.user;
    }
}