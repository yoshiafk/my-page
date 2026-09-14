package com.mypage.esppk.portlet;

import com.aii.esppk.admin.model.SppkUser;
import com.aii.esppk.admin.service.SppkUserLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;
import com.mypage.esppk.helper.ActionHelper;
import com.mypage.esppk.helper.EncryptionHelper;
import com.mypage.esppk.jwt.JwtUtil;
import com.mypage.esppk.service.AuthService;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author GOSITUS
 */
@Component(property = { "com.liferay.portlet.display-category=AXA Insurance Indonesia",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AiiEsppkWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/step1.jsp", "javax.portlet.name=" + AiiEsppkWebPortletKeys.AIIESPPKWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AiiEsppkWebPortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(AiiEsppkWebPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		Boolean isOtp = (Boolean) renderRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.ISOTP, PortletSession.PORTLET_SCOPE);
		String userEmail = (String) renderRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.USEREMAIL,
				PortletSession.PORTLET_SCOPE);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			return;
		}

		// Set CSRF Token
		String secureToken = EncryptionHelper.generateSecureToken(32);
		renderRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken,
				PortletSession.PORTLET_SCOPE);
		renderRequest.setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken);

		if (isOtp != null && isOtp) {
			renderRequest.setAttribute(AiiEsppkWebPortletKeys.ISOTP, isOtp);
		}

		if (userEmail != null && !userEmail.isEmpty()) {
			renderRequest.setAttribute(AiiEsppkWebPortletKeys.USEREMAIL, userEmail);

			String emailMask = "";

			String[] parts = userEmail.split("@");
			String username = parts[0];
			String domain = parts[1];

			if (username.length() <= 2) {
				emailMask = username.charAt(0) + "*" + "@" + domain;
			} else {
                int visibleCount = 2;
                int maskCount = username.length() - visibleCount;

                String maskedUsername = username.substring(0, visibleCount) + repeatChar('*', maskCount);

                emailMask = maskedUsername + "@" + domain;
            }
			
			renderRequest.setAttribute("EMAILMASK", emailMask);

		}

		log.debug(renderRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN,
				PortletSession.PORTLET_SCOPE));

		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String resourceID = resourceRequest.getResourceID();

		try {
			if (resourceID.equalsIgnoreCase("signinEntry")) {
				signinEntry(resourceRequest, resourceResponse);
			} else if (resourceID.equalsIgnoreCase("otpEntry")) {
				processOTP(resourceRequest, resourceResponse);
			} else if (resourceID.equalsIgnoreCase("resendOtpEntry")) {
				resendOTP(resourceRequest, resourceResponse);
			} else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}

	public void processOTP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, JSONException {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		JSONObject data = JSONFactoryUtil.createJSONObject();

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);

		JSONObject params = JSONFactoryUtil.createJSONObject(ParamUtil.getString(httpRequest, "data"));

		String csrfTokenFromSession = (String) resourceRequest.getPortletSession()
				.getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, PortletSession.PORTLET_SCOPE);
		String secureToken = EncryptionHelper.generateSecureToken(32);

        log.info(csrfTokenFromSession);
        log.info(params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER));

		resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken,
				PortletSession.PORTLET_SCOPE);
		data.put(AiiEsppkWebPortletKeys.TOKEN_LIMITER, secureToken);

		AuthService.AuthResult result = authService.processOTP(params.getString("email"), params.getString("otp"),
				params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER), csrfTokenFromSession);

        if (!result.isValidCsrf() || result.getErrorMessage() != null) {
            ActionHelper helper = new ActionHelper();
            resourceResponse.getWriter().write(helper.errorMessage(result.getErrorMessage(), data).toString());
            return;
        }

		if (!result.isValidOtp() || result.getErrorMessage() != null) {
			ActionHelper helper = new ActionHelper();
			resourceResponse.getWriter().write(helper.errorMessage(result.getErrorMessage(), data).toString());
			return;
		}

		// REMOVE SESSION OTP
		resourceRequest.getPortletSession().removeAttribute(AiiEsppkWebPortletKeys.ISOTP, PortletSession.PORTLET_SCOPE);
		resourceRequest.getPortletSession().removeAttribute(AiiEsppkWebPortletKeys.USEREMAIL, PortletSession.PORTLET_SCOPE);

		log.info(result.getLastActive());
		resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.LAST_ACTIVE, result.getLastActive(),
				PortletSession.APPLICATION_SCOPE);

        String accessMaxAge = getGlobalVariable(AiiEsppkWebPortletKeys.ESPPK_GROUP_GLOBAL_VAR, "max age", "0");

		Cookie cookie = new Cookie(AiiEsppkWebPortletKeys.SESS_NAME, result.getToken());
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.parseInt(accessMaxAge) * 60);
        cookie.setSecure(false);
		httpResponse.addCookie(cookie);

        HttpSession session = httpRequest.getSession();
        session.setAttribute("CSRF_TOKEN", secureToken);

		response.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 1);
		response.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "");
		response.put("Data", data);

		resourceResponse.getWriter().write(response.toString());

	}
	
	public void resendOTP(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, JSONException {
		
		JSONObject response = JSONFactoryUtil.createJSONObject();
		JSONObject data = JSONFactoryUtil.createJSONObject();

        HttpServletRequest httpRequest = PortalUtil
                .getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

        JSONObject params = JSONFactoryUtil.createJSONObject(ParamUtil.getString(httpRequest, "data"));

        String csrfTokenFromSession = (String) resourceRequest.getPortletSession()
                .getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, PortletSession.PORTLET_SCOPE);
        String secureToken = EncryptionHelper.generateSecureToken(32);

        log.info(csrfTokenFromSession);
        log.info(params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER));

        resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken,
                PortletSession.PORTLET_SCOPE);
        data.put(AiiEsppkWebPortletKeys.TOKEN_LIMITER, secureToken);

        AuthService.AuthResult result = authService.validateCsrfToken(params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER),
                csrfTokenFromSession);

        if (!result.isValidCsrf() || result.getErrorMessage() != null) {
            ActionHelper helper = new ActionHelper();
            resourceResponse.getWriter().write(helper.errorMessage(result.getErrorMessage(), data).toString());
            return;
        }
		
		Boolean isOtp = (Boolean) resourceRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.ISOTP, PortletSession.PORTLET_SCOPE);
		String userEmail = (String) resourceRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.USEREMAIL,
				PortletSession.PORTLET_SCOPE);
		String loginCode = (String) resourceRequest.getPortletSession().getAttribute("LC",
				PortletSession.PORTLET_SCOPE);
		
		if (isOtp != null && isOtp && userEmail != null && !userEmail.isEmpty()) {
            SppkUser currentUser = SppkUserLocalServiceUtil.getByLoginCode(loginCode);

            sendOtp(currentUser);

            response.put("Type", 3);
		}
		
		response.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 1);
		response.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "");
		response.put("Data", data);

		resourceResponse.getWriter().write(response.toString());
	}

	public void signinEntry(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, JSONException {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		JSONObject data = JSONFactoryUtil.createJSONObject();

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);

		JSONObject params = JSONFactoryUtil.createJSONObject(ParamUtil.getString(httpRequest, "data"));

		String csrfTokenFromSession = (String) resourceRequest.getPortletSession()
				.getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, PortletSession.PORTLET_SCOPE);
		String secureToken = EncryptionHelper.generateSecureToken(32);

		log.info(csrfTokenFromSession);
		log.info(params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER));

        boolean otpStat = Boolean.parseBoolean(getGlobalVariable(AiiEsppkWebPortletKeys.ESPPK_GROUP_GLOBAL_VAR, "OTP_STAT", "false"));
		
		AuthService.AuthResult result = null;
        String username = params.getString("username");
		
		if (otpStat) {
			result = authService.signin(username,
					getFieldData(params.getString("password")), params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER),
					csrfTokenFromSession);
		} else {
			result = authService.signinNonOtp(username,
					getFieldData(params.getString("password")), params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER),
					csrfTokenFromSession);
		}

		SppkUser currentUser = SppkUserLocalServiceUtil.getByLoginCode(username);

		resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken,
				PortletSession.PORTLET_SCOPE);
		data.put(AiiEsppkWebPortletKeys.TOKEN_LIMITER, secureToken);

		if (!result.isValidCsrf() || result.getErrorMessage() != null) {
			ActionHelper helper = new ActionHelper();
			resourceResponse.getWriter().write(helper.errorMessage(result.getErrorMessage(), data).toString());
			return;
		}
		
		if(otpStat) {
			// UPDATE OTP UNTUK USER SAAT INI
			currentUser = SppkUserLocalServiceUtil.updateOtp(currentUser.getSppkUserId());

            sendOtp(currentUser);

			// OTP AKTIF
			resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.ISOTP, true, PortletSession.PORTLET_SCOPE);
			resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.USEREMAIL, currentUser.getEmail(),
					PortletSession.PORTLET_SCOPE);
			resourceRequest.getPortletSession().setAttribute("LC", currentUser.getSppkLoginCode(),
					PortletSession.PORTLET_SCOPE);
			
			response.put("Type", 2);
			
		} else {
			
			log.info(result.getLastActive());
			resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.LAST_ACTIVE, result.getLastActive(),
					PortletSession.APPLICATION_SCOPE);

            String accessMaxAge = getGlobalVariable(AiiEsppkWebPortletKeys.ESPPK_GROUP_GLOBAL_VAR, "max age", "0");

			Cookie cookie = new Cookie(AiiEsppkWebPortletKeys.SESS_NAME, result.getToken());
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(Integer.parseInt(accessMaxAge) * 60);
            cookie.setSecure(false);
			httpResponse.addCookie(cookie);
			
			response.put("Type", 1); // non otp
		}

		response.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 1);
		response.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "");
		response.put("Data", data);

		resourceResponse.getWriter().write(response.toString());
	}

	public static String getFieldData(String input) {
		StringBuilder result = new StringBuilder();

		for (char c : input.toCharArray()) {
			if (Character.isLetter(c)) {
				char base = Character.isUpperCase(c) ? 'A' : 'a';
				c = (char) ((c - base + 13) % 26 + base);
			}
			result.append(c);
		}

		return result.toString();
	}

	private static String repeatChar(char c, int count) {
		if (count <= 0)
			return "";
		StringBuilder sb = new StringBuilder(count);
		for (int i = 0; i < count; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	private String getGlobalVariable(String group, String name, String defaultValue) {
		return masterGlobalVariableLocalService.getActiveGlobalVariableByGroup(group).stream()
				.filter(v -> name.equalsIgnoreCase(v.getName()) && v.getActive() == 1).findFirst()
				.map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? defaultValue : v.getValue()).orElse(defaultValue);
	}

    private void sendOtp(SppkUser currentUser) throws JSONException {
        // KIRIM EMAIL OTP VIA PIMCORE API UNTUK USER SAAT INI
        ActionHelper helper = new ActionHelper();
        String pimcoreAddr = helper.getPimcoreAddr();
        String apiEmailUrl = helper.getConfig("esppk.api.send.emailotp");

        // exp jwt
        long validityMinutes = Long.parseLong(getGlobalVariable("JWT", "ACCESS_TOKEN_VALIDITY_EMAIL", "0"));
        long expSeconds = validityMinutes * 60;

        String tokenEmail = jwtUtil.generateEmailOtpToken(currentUser.getEmail(), "", "Kode OTP Login User SPPK", currentUser.getFullName(), currentUser.getOtpCode(), expSeconds);

        JSONObject emailResponse = helper.hitAPI(pimcoreAddr + apiEmailUrl, "", tokenEmail);
        log.info(emailResponse);

        if (emailResponse.has(AiiEsppkWebPortletKeys.STATUS_CODE) && emailResponse.getInt(AiiEsppkWebPortletKeys.STATUS_CODE) != 200) {
            log.info("Gagal request ke email server");
        }

        JSONObject emailResponseDto = JSONFactoryUtil.createJSONObject(emailResponse.get("response").toString());

        if (emailResponseDto.getInt("Status") == 0) {
            log.info(emailResponseDto.getString("Message"));
        }
    }

	private AuthService authService;
	
	@Reference(unbind = "-")
	private JwtUtil jwtUtil;

	@Reference(unbind = "-")
	private MasterGlobalVariableLocalService masterGlobalVariableLocalService;

	@Reference(unbind = "-")
	protected void setAuthService(AuthService authService) {
		this.authService = authService;
	}
}