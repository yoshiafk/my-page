package com.mypage.esppk.helper;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;
import com.mypage.esppk.jwt.JwtUtil;
import com.mypage.esppk.util.ClockUtil;
import io.jsonwebtoken.Claims;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.crypto.SecretKey;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@Component(
    immediate = true,
    service = ValidationAuthHelper.class
)
public class ValidationAuthHelper {
    private static final Log log = LogFactoryUtil.getLog(ValidationAuthHelper.class);

    public String getCookieValue(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        for (Cookie cookie : cookies) {
            if (AiiEsppkWebPortletKeys.SESS_NAME.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public boolean isTokenValid(String token) {
        Claims claims = jwtUtil.validateToken(token);
        return claims != null && !claims.isEmpty();
    }

    public boolean isSessionIdle(RenderRequest request) {
        log.info("Idle In");
        log.info(request.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.LAST_ACTIVE, PortletSession.APPLICATION_SCOPE));
        Long lastActive = (Long) request.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.LAST_ACTIVE, PortletSession.APPLICATION_SCOPE);
        if (lastActive == null) return false;

        long now = Instant.now(clock).toEpochMilli();
        long idleDuration = now - lastActive;

        String accessIdleTimeout = masterGlobalVariableLocalService.getActiveGlobalVariableByGroup(AiiEsppkWebPortletKeys.ESPPK_GROUP_GLOBAL_VAR).stream()
                .filter(v -> "idle timeout".equalsIgnoreCase(v.getName()) && v.getActive() == 1)
                .findFirst()
                .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "0" : v.getValue())
                .orElse("0");

        long maxIdleMillis = 1000L * 60 * Integer.parseInt(accessIdleTimeout);

        log.info(idleDuration);
        log.info(maxIdleMillis);

        if (idleDuration > maxIdleMillis) {
            request.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.LAST_ACTIVE, null, PortletSession.APPLICATION_SCOPE);
            return true;
        }

        log.info(now);
        request.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.LAST_ACTIVE, now, PortletSession.APPLICATION_SCOPE);
        return false;
    }

    public Claims getClaims(String token) {
        return jwtUtil.validateToken(token);
    }

    public long getTokenRemainingTime(String token) {
        SecretKey key = jwtUtil.getSigningKey();
        return jwtUtil.remainingTime(token, key);
    }

    public String refreshToken(String token, HttpServletResponse response) {
        long remaining = getTokenRemainingTime(token);

        log.info(remaining);

        String accessRefreshTime = masterGlobalVariableLocalService.getActiveGlobalVariableByGroup(AiiEsppkWebPortletKeys.ESPPK_GROUP_GLOBAL_VAR).stream()
                .filter(v -> "refresh time".equalsIgnoreCase(v.getName()) && v.getActive() == 1)
                .findFirst()
                .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "0" : v.getValue())
                .orElse("0");
        long refreshTime = 60L * Integer.parseInt(accessRefreshTime);

        log.info(refreshTime);

        if (remaining < refreshTime && remaining > 0) {
            Claims claims = getClaims(token);

            String newToken = jwtUtil.generateAccessToken(
                claims.get("fullName").toString(),
                claims.getSubject(),
                claims.get("role").toString(),
                Boolean.parseBoolean(claims.get("accessData").toString()),
                Boolean.parseBoolean(claims.get("accessMonitoring").toString())
            );

            String accessMaxAge = masterGlobalVariableLocalService.getActiveGlobalVariableByGroup(AiiEsppkWebPortletKeys.ESPPK_GROUP_GLOBAL_VAR).stream()
                    .filter(v -> v.getName().equalsIgnoreCase("max age") && v.getActive() == 1)
                    .findFirst()
                    .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "0" : v.getValue())
                    .orElse("0");

            Cookie cookie = new Cookie(AiiEsppkWebPortletKeys.SESS_NAME, newToken);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(Integer.parseInt(accessMaxAge) * 60);
            cookie.setSecure(false);
            response.addCookie(cookie);

            return newToken;
        }
        return token;
    }

    public void clearSessionCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie(AiiEsppkWebPortletKeys.SESS_NAME, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        response.addCookie(cookie);
    }

    public void redirectToLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect(AiiEsppkWebPortletKeys.LOGINURL);
    }

    public boolean hasAccess(String token, String claimName) {
        Claims claims = jwtUtil.validateToken(token);
        if (claims == null) return false;

        Object val = claims.get(claimName);
        return val != null && Boolean.parseBoolean(val.toString());
    }

    public Optional<Claims> validateAndAuthorize(
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse,
            RenderRequest renderRequest,
            String requiredAccess
    ) throws IOException {
        String jwtToken = getCookieValue(httpRequest);

        if (jwtToken == null || jwtToken.isEmpty()
                || !isTokenValid(jwtToken)
                || getTokenRemainingTime(jwtToken) <= 0) {

            clearSessionCookie(httpResponse);
            redirectToLogin(httpResponse);
            return Optional.empty();
        }

        if (isSessionIdle(renderRequest)) {
            clearSessionCookie(httpResponse);
            redirectToLogin(httpResponse);
            return Optional.empty();
        }

        jwtToken = refreshToken(jwtToken, httpResponse);

        if (!hasAccess(jwtToken, requiredAccess)) {
            return Optional.ofNullable(getClaims(jwtToken));
        }

        return Optional.of(getClaims(jwtToken));
    }

    public Optional<Response> validateJwtAndCsrf(
            HttpServletRequest httpServletRequest,
            String requiredAccess
    ) {
        JSONObject response = JSONFactoryUtil.createJSONObject();
        response.put("status", 0);
        response.put("message", "Layanan tidak ditemukan atau tidak tersedia.");

        String jwtToken = getCookieValue(httpServletRequest);

        if (jwtToken == null || jwtToken.isEmpty()
                || !isTokenValid(jwtToken)
                || getTokenRemainingTime(jwtToken) <= 0
                || !hasAccess(jwtToken, requiredAccess)) {

            return Optional.of(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity(response.toString())
                            .build()
            );
        }

        String csrfHeader = httpServletRequest.getHeader("X-CSRF-TOKEN");

        HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);

        String csrfSession = (String) originalRequest.getSession().getAttribute("CSRF_TOKEN");

        if (!Objects.equals(csrfHeader, csrfSession)) {
            return Optional.of(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity(response.toString())
                            .build()
            );
        }

        return Optional.empty(); // valid
    }

    private Clock clock = ClockUtil.getSystemClock();

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    @Reference(unbind = "-")
    private JwtUtil jwtUtil;

    @Reference(unbind = "-")
    private MasterGlobalVariableLocalService masterGlobalVariableLocalService;
}
