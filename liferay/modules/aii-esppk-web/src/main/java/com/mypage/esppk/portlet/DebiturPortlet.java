package com.mypage.esppk.portlet;

import com.aii.esppk.admin.model.SppkDebitur;
import com.aii.esppk.admin.service.SppkDebiturLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.mypage.esppk.helper.ValidationAuthHelper;
import com.mypage.esppk.helper.ValidationHelper;
import com.mypage.esppk.jwt.JwtUtil;
import com.mypage.esppk.util.ClockUtil;
import com.mypage.esppk.util.GenerationUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jsonwebtoken.Claims;

/**
 * @author GOSITUS
 */
@Component(property = { "com.liferay.portlet.display-category=AXA Insurance Indonesia",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DebiturEsppk", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/step2.jsp", "javax.portlet.name=" + AiiEsppkWebPortletKeys.DEBITUR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DebiturPortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(DebiturPortlet.class);
    private static final String ACCESS_DATA = "accessData";
    private static final String ACCESS_MONITORING = "accessMonitoring";
    private static final String CREATE_DEBITUR = "createDebitur";
    private static final String FULLNAME = "fullName";
    private static final String IDNUM = "idNumber";
    private static final String MAIL = "email";

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		log.info("Render Debitur Portlet");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn()) {
			return;
		}

        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(renderResponse);

		// Set CSRF Token
		String secureToken = EncryptionHelper.generateSecureToken(32);
		renderRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken,
				PortletSession.PORTLET_SCOPE);

        HttpSession session = httpRequest.getSession();
        session.setAttribute("CSRF_TOKEN", secureToken);

		renderRequest.setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken);
        renderRequest.setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN_API, secureToken);

		log.info(renderRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN,
				PortletSession.PORTLET_SCOPE));

        Optional<Claims> claimsOpt = validationAuthHelper.validateAndAuthorize(
                httpRequest,
                httpResponse,
                renderRequest,
                ACCESS_DATA
        );

        if (!claimsOpt.isPresent()) {
            return;
        }

        Claims claims = claimsOpt.get();

        if (!validationAuthHelper.hasAccess(validationAuthHelper.getCookieValue(httpRequest), ACCESS_DATA)) {
            populateUserAttributes(renderRequest, claims);
            render404(renderRequest, renderResponse);
            return;
        }

        handleCommonRender(renderRequest, claims, "debitur");
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse)
			throws IOException {
		String resourceID = resourceRequest.getResourceID();

		try {
			if (CREATE_DEBITUR.equals(resourceID)) {
				updateDebitur(resourceRequest, resourceResponse);
			} else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}

	private void updateDebitur(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject responseJson = JSONFactoryUtil.createJSONObject();
		JSONObject data = JSONFactoryUtil.createJSONObject();

		String jsonString = jsonString(httpRequest, resourceResponse);

		try {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

			String csrfTokenFromSession = (String) resourceRequest.getPortletSession()
					.getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, PortletSession.PORTLET_SCOPE);
			String secureToken = EncryptionHelper.generateSecureToken(32);

			log.info(csrfTokenFromSession);
			log.info(jsonObject.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER));

			boolean isValidCsrfToken = !csrfTokenFromSession.isEmpty() && jsonObject
					.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER).equalsIgnoreCase(csrfTokenFromSession);

			resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken,
					PortletSession.PORTLET_SCOPE);
			data.put(AiiEsppkWebPortletKeys.TOKEN_LIMITER, secureToken);

            String jwtToken = validationAuthHelper.getCookieValue(httpRequest);

            if (jwtToken == null || jwtToken.isEmpty() || !validationAuthHelper.isTokenValid(jwtToken)
                    || validationAuthHelper.getTokenRemainingTime(jwtToken) <= 0
                    || !validationAuthHelper.hasAccess(jwtToken, ACCESS_DATA)) {
                resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "200");
                resourceResponse.setContentType(AiiEsppkWebPortletKeys.CONTENT_TYPE_JSON);
                responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 0);
                responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "Terjadi kesalahan, akses ditolak.");
                responseJson.put("Data", data);

                resourceResponse.getWriter().write(responseJson.toString());
                return;
            }

			if (!isValidCsrfToken) {
				resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "200");
				resourceResponse.setContentType(AiiEsppkWebPortletKeys.CONTENT_TYPE_JSON);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 0);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "Terjadi kesalahan, silakan coba beberapa saat lagi.");
				responseJson.put("Data", data);

				resourceResponse.getWriter().write(responseJson.toString());
				return;
			}

			ValidationHelper validate = new ValidationHelper();

			boolean validateInput = validate.validateJSON(jsonObject);

			if (!validateInput) {
				resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "200");
				resourceResponse.setContentType(AiiEsppkWebPortletKeys.CONTENT_TYPE_JSON);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 0);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "Verifikasi data gagal, pastikan data telah sesuai [Gagal Validasi Data].");
				responseJson.put("Data", data);

				resourceResponse.getWriter().write(responseJson.toString());
				return;
			}

			ActionHelper helper = new ActionHelper();

            String applicationNumber = helper.sanitizeHtml(jsonObject.getString("applicationNumber")).toUpperCase();
			String fullName = helper.sanitizeHtml(jsonObject.getString("name")).toUpperCase();
			String birthPlace = helper.sanitizeHtml(jsonObject.getString("birthPlace")).toUpperCase();

			String birthDateString = jsonObject.getString("birthDateAlt");

			boolean validAge = validateAge(birthDateString);

			if (!validAge) {
				resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "200");
				resourceResponse.setContentType(AiiEsppkWebPortletKeys.CONTENT_TYPE_JSON);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 0);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "Verifikasi data gagal, pastikan data telah sesuai [Usia tidak sesuai].");
				responseJson.put("Data", data);

				resourceResponse.getWriter().write(responseJson.toString());
				return;
			}

			LocalDate localDate = LocalDate.parse(birthDateString, DateTimeFormatter.ISO_LOCAL_DATE);
			Date birthDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

			String idNumber = jsonObject.getString(IDNUM);

			if (idNumber.length() < 16) {
				resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "200");
				resourceResponse.setContentType(AiiEsppkWebPortletKeys.CONTENT_TYPE_JSON);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 0);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "Verifikasi data gagal, pastikan data telah sesuai [Nomor KTP tidak sesuai].");
				responseJson.put("Data", data);

				resourceResponse.getWriter().write(responseJson.toString());
				return;
			}

            String address = helper.sanitizeHtml(jsonObject.getString("address")).toUpperCase();
			String occupation = helper.sanitizeHtml(jsonObject.getString("occupation")).toUpperCase();
			String email = jsonObject.getString(MAIL).toLowerCase();
			String phoneNumber = jsonObject.getString("phoneNumber");
			String gender = helper.sanitizeHtml(jsonObject.getString("gender"));

			String sumInsuredString = jsonObject.getString("sumInsured");
			sumInsuredString = sumInsuredString.replace(".", "");
			BigDecimal sumInsured = new BigDecimal(sumInsuredString);

			if (!validateSumInsured(sumInsured)) {
				resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "200");
				resourceResponse.setContentType(AiiEsppkWebPortletKeys.CONTENT_TYPE_JSON);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 0);
				responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "Verifikasi data gagal, pastikan data telah sesuai [Limit pengajuan tidak sesuai].");
				responseJson.put("Data", data);

				resourceResponse.getWriter().write(responseJson.toString());
				return;
			}

			String product = helper.sanitizeHtml(jsonObject.getString("product")).toUpperCase();

			long nowTimestamp = Instant.now(ClockUtil.getSystemClock()).toEpochMilli();
			SppkDebitur dataDebitur = null;

			if (CREATE_DEBITUR.equalsIgnoreCase(resourceRequest.getResourceID())) {
				
				String submissionNumber = GenerationUtil.generateSubmissionNumber("PA");
				
				dataDebitur = SppkDebiturLocalServiceUtil.addSppkDebitur(fullName, birthPlace, birthDate, idNumber,
						occupation, email, phoneNumber, gender, sumInsured, product, applicationNumber, address, submissionNumber);

				sendSPPK(dataDebitur, email, nowTimestamp, true);
			}

			log.info(nowTimestamp);

			resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.LAST_ACTIVE, nowTimestamp,
					PortletSession.PORTLET_SCOPE);

			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "200");

			responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 1);
			responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "Sukses menambahkan data debitur");
			responseJson.put("Data", data);

			resourceResponse.setContentType(AiiEsppkWebPortletKeys.CONTENT_TYPE_JSON);
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(responseJson.toString());
			writer.flush();

		} catch (Exception e) {
			log.debug(e.getMessage());
			String secureToken = EncryptionHelper.generateSecureToken(32);
			resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken,
					PortletSession.PORTLET_SCOPE);
			data.put(AiiEsppkWebPortletKeys.TOKEN_LIMITER, secureToken);

			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "400");

			responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 0);
			responseJson.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, "Gagal menambahkan data debitur");
			responseJson.put("Data", data);

			resourceResponse.setContentType(AiiEsppkWebPortletKeys.CONTENT_TYPE_JSON);
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(responseJson.toString());
			writer.flush();
		}
	}

	private void sendSPPK(SppkDebitur dataDebitur, String email, long now, boolean isNew)
			throws PortalException, InvalidAlgorithmParameterException, NoSuchPaddingException,
			IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
		if (isNew || !email.equalsIgnoreCase(dataDebitur.getEmail())) {
			ActionHelper helper = new ActionHelper();
			String liferayAddr = helper.getLiferayAddr();
			String pimcoreAddr = helper.getPimcoreAddr();
			String apiEmailUrl = helper.getConfig("esppk.api.send.email");

			// effective date
			long effectiveDateMinutes = getGlobalVariable("EFFECTIVE_DATE_EMAIL");
			long effectiveDateSeconds = effectiveDateMinutes * 60;
			Instant expiryInstant = Instant.now().plusSeconds(effectiveDateSeconds);
			Date expiry = Date.from(expiryInstant);

			// exp jwt
			long validityMinutes = getGlobalVariable("ACCESS_TOKEN_VALIDITY_EMAIL");
			long expSeconds = validityMinutes * 60;

			String tokenEmail = jwtUtil.generateEmailToken(dataDebitur.getEmail(), "",
					"[#"+dataDebitur.getSubmissionNumber()+"] Surat Permintaan Pernyataan Kesehatan (SPPK) - AXA Insurance Indonesia", (now / 1000) + effectiveDateSeconds, expSeconds,
					liferayAddr + "/asuransi-proteksi-kecelakaan-diri-plus/esppk?a="
							+ EncryptionHelper.encrypt(String.valueOf(dataDebitur.getSppkDebiturId())), dataDebitur.getSubmissionNumber());

			JSONObject emailResponse = helper.hitAPI(pimcoreAddr + apiEmailUrl, "", tokenEmail);

			log.info(emailResponse);

			if (emailResponse.has("statusCode") && emailResponse.getInt("statusCode") != 200) {
				log.info("Gagal request ke email server");
			}

			JSONObject emailResponseDto = JSONFactoryUtil.createJSONObject(emailResponse.get("response").toString());

			if (emailResponseDto.getInt("Status") == 0) {
				log.info(emailResponseDto.getString("Message"));
			}

			SppkDebiturLocalServiceUtil.updateSppkDebitur(dataDebitur.getSppkDebiturId(), tokenEmail, expiry);
		}
	}

	private long getGlobalVariable(String name) {
		return Long.parseLong(masterGlobalVariableLocalService.getActiveGlobalVariableByGroup("JWT").stream()
				.filter(v -> name.equalsIgnoreCase(v.getName()) && v.getActive() == 1).findFirst()
				.map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "0" : v.getValue()).orElse("0"));
	}

    private void handleCommonRender(RenderRequest renderRequest, Claims claims, String pageActive) {
        String target = ParamUtil.getString(renderRequest, "t");
        String path = ParamUtil.getString(renderRequest, "mvcPath");

        if (path.contains("step4")) {
            populateDetailSPPK(renderRequest, target);
        }

        populateUserAttributes(renderRequest, claims);
        renderRequest.setAttribute(AiiEsppkWebPortletKeys.PAGE_ACTIVE, pageActive);
    }

	private boolean validateAge(String birthDate) {
		if (birthDate.isEmpty())
			return false;

		LocalDate dob;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dob = LocalDate.parse(birthDate, formatter);
		} catch (Exception e) {
			log.debug(e.getMessage());
			return false;
		}

		LocalDate today = LocalDate.now(ClockUtil.getSystemClock());

		int age = Period.between(dob, today).getYears();

		return age >= 18 && age <= 51;
	}

    private void populateDetailSPPK(RenderRequest renderRequest, String target) {
        // get data by target
        ActionHelper helper = new ActionHelper();
        long debiturId = helper.decryptDebiturId(target);

        SppkDebitur dataDebitur = SppkDebiturLocalServiceUtil.fetchSppkDebitur(debiturId);

        String constYa = "ya";
        String constTidak = "tidak";

        renderRequest.setAttribute("submissionNumberDebitur", dataDebitur.getSubmissionNumber());
        renderRequest.setAttribute("fullNameDebitur", dataDebitur.getFullName());
        renderRequest.setAttribute(IDNUM, dataDebitur.getIdNumber());
        renderRequest.setAttribute("birthDate", dataDebitur.getBirthDate());
        renderRequest.setAttribute("status", helper.statusDebitur(dataDebitur.getEsppkQ1(), dataDebitur.getEsppkQ2(), dataDebitur.getEsppkQ3()));
        renderRequest.setAttribute("esppkQ1", dataDebitur.getEsppkQ1() == 1 ? constYa : constTidak);
        renderRequest.setAttribute("esppkQ2", dataDebitur.getEsppkQ2() == 1 ? constYa : constTidak);
        renderRequest.setAttribute("esppkQ3", dataDebitur.getEsppkQ3() == 1 ? constYa : constTidak);
        renderRequest.setAttribute("agreeRiplay", dataDebitur.getAgreeRiplay() == 1 ? constYa : constTidak);
        renderRequest.setAttribute("agreeStatement", dataDebitur.getAgreeStatement() == 1 ? constYa : constTidak);
    }

	private boolean validateSumInsured(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) >= 0 && value.compareTo(new BigDecimal("1000000000")) <= 0;
	}

    private void populateUserAttributes(RenderRequest renderRequest, Claims claims) {
        if (claims == null || claims.isEmpty()) return;

        Object fullName = claims.get(FULLNAME);
        if (fullName != null) renderRequest.setAttribute(FULLNAME, fullName.toString().toUpperCase());

        Object accessData = claims.get(ACCESS_DATA);
        if (accessData != null) renderRequest.setAttribute(ACCESS_DATA, claims.get(ACCESS_DATA));

        Object accessMonitoring = claims.get(ACCESS_MONITORING);
        if (accessMonitoring != null) renderRequest.setAttribute(ACCESS_MONITORING, claims.get(ACCESS_MONITORING));
    }

    private String jsonString(HttpServletRequest httpRequest, ResourceResponse resourceResponse) {
        StringBuilder jsonBuffer = new StringBuilder();
        try {
            BufferedReader reader = httpRequest.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "400");
        }

        return jsonBuffer.toString();
    }

    private void render404(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        renderRequest.setAttribute(AiiEsppkWebPortletKeys.PAGE_ACTIVE, "debitur");
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/404.jsp");

        dispatcher.include(renderRequest, renderResponse);
    }

	@Reference(unbind = "-")
	private JwtUtil jwtUtil;

	@Reference(unbind = "-")
	private ValidationAuthHelper validationAuthHelper;

	@Reference(unbind = "-")
	private MasterGlobalVariableLocalService masterGlobalVariableLocalService;
}
