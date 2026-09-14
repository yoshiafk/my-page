package com.mypage.esppk.portlet;

import com.aii.esppk.admin.model.SppkDebitur;
import com.aii.esppk.admin.service.SppkDebiturLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;
import com.mypage.esppk.helper.ActionHelper;
import com.mypage.esppk.helper.EncryptionHelper;
import com.mypage.esppk.util.ClockUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

/**
 * @author GOSITUS
 */
@Component(
    property = {
        "com.liferay.portlet.display-category=AXA Insurance Indonesia",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=AgreementEsppk",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/step5.jsp",
        "javax.portlet.name=" + AiiEsppkWebPortletKeys.AGREEEMENT,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class AgreementPortlet extends MVCPortlet {
    private static final Log log = LogFactoryUtil.getLog(AgreementPortlet.class);

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        log.info("Render Agreement Portlet");

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (themeDisplay.isSignedIn()) {
            return;
        }

        // Set CSRF Token
        String secureToken = EncryptionHelper.generateSecureToken(32);
        renderRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken, PortletSession.PORTLET_SCOPE);

        log.info(renderRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, PortletSession.PORTLET_SCOPE));

        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

        String aParam = ParamUtil.getString(httpRequest, "a");
        String path = ParamUtil.getString(httpRequest, renderResponse.getNamespace() + "mvcPath");

        if (Validator.isNull(path)) {
            if (Validator.isNull(aParam)) {
                render404(renderRequest, renderResponse);
                return;
            }

            ActionHelper helper = new ActionHelper();
            Long debiturId = helper.decryptDebiturId(aParam);

            if (debiturId == null || debiturId <= 0) {
                render404(renderRequest, renderResponse);
                return;
            }

            SppkDebitur dataDebitur = SppkDebiturLocalServiceUtil.fetchSppkDebitur(debiturId);

            if (dataDebitur == null) {
                render404(renderRequest, renderResponse);
                return;
            }

            if (isTokenExpired(dataDebitur.getEsppkTokenExpiry())) {
                render404(renderRequest, renderResponse);
                return;
            }

            boolean submitted = isSubmit(dataDebitur.getSubmitEsppkDate());

            if (submitted) {
                render404(renderRequest, renderResponse);
                return;
            }

            String riplayVersi = "umum"; // umum/personal

            // Web Content
            String infoProduk = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-informasi-produk", themeDisplay);
            String fiturUtama = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-fitur-utama", themeDisplay);
            String manfaat = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-manfaat", themeDisplay);
            String risiko = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-risiko", themeDisplay);
            String biaya = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-biaya", themeDisplay);
            String pengecualian = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-pengecualian", themeDisplay);
            String persyaratan = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-persyaratan", themeDisplay);
            String simulasi = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-simulasi", themeDisplay);
            String infoTambahan = getWebContentByFriendlyUrl(AiiEsppkWebPortletKeys.ESPPK + riplayVersi + "-info-tambahan", themeDisplay);
            String persetujuan = getWebContentByFriendlyUrl("esppk-pernyataan-persetujuan", themeDisplay);

            renderRequest.setAttribute("info-produk", infoProduk);
            renderRequest.setAttribute("fitur-utama", fiturUtama);
            renderRequest.setAttribute("manfaat", manfaat);
            renderRequest.setAttribute("risiko", risiko);
            renderRequest.setAttribute("biaya", biaya);
            renderRequest.setAttribute("pengecualian", pengecualian);
            renderRequest.setAttribute("persyaratan", persyaratan);
            renderRequest.setAttribute("simulasi", simulasi);
            renderRequest.setAttribute("info-tambahan", infoTambahan);
            renderRequest.setAttribute("persetujuan", persetujuan);

            renderRequest.setAttribute("submitted", submitted);

            renderRequest.setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken);
        }

        renderRequest.setAttribute(AiiEsppkWebPortletKeys.PAGE_ACTIVE, "");

        super.render(renderRequest, renderResponse);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        String resourceID = resourceRequest.getResourceID();

        try {
            if (resourceID.equalsIgnoreCase("signAgreement")) {
                signAgreement(resourceRequest, resourceResponse);
            } else {
                super.serveResource(resourceRequest, resourceResponse);
            }
        } catch(Exception e) {
            log.debug(e.getMessage());
        }
    }

    public void signAgreement(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortalException, IOException {
        ActionHelper helper = new ActionHelper();
        JSONObject response = JSONFactoryUtil.createJSONObject();
        JSONObject data = JSONFactoryUtil.createJSONObject();

        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

        JSONObject params = JSONFactoryUtil.createJSONObject(ParamUtil.getString(httpRequest, "data"));

        String csrfTokenFromSession = (String) resourceRequest.getPortletSession().getAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, PortletSession.PORTLET_SCOPE);
        String secureToken = EncryptionHelper.generateSecureToken(32);

        log.info(csrfTokenFromSession);
        log.info(params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER));

        boolean isValidCsrfToken = !csrfTokenFromSession.isEmpty() && params.getString(AiiEsppkWebPortletKeys.TOKEN_LIMITER).equalsIgnoreCase(csrfTokenFromSession);

        resourceRequest.getPortletSession().setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken, PortletSession.PORTLET_SCOPE);
        data.put(AiiEsppkWebPortletKeys.TOKEN_LIMITER, secureToken);

        if (!isValidCsrfToken) {
            resourceResponse.getWriter().write(helper.errorMessage("Terjadi kesalahan, silakan coba beberapa saat lagi.", data).toString());
            return;
        }

        String aParam = ParamUtil.getString(httpRequest,resourceResponse.getNamespace() + "a");
        Long debiturId = helper.decryptDebiturId(aParam);
        int esppkQ1 = params.getString("firstSppk").equalsIgnoreCase("ya") ? 1 : 0;
        int esppkQ2 = params.getString("secondSppk").equalsIgnoreCase("ya") ? 1 : 0;
        int esppkQ3 = params.getString("thirdSppk").equalsIgnoreCase("ya") ? 1 : 0;
        int agreeRiplay = params.getString("agreeRiplay").equalsIgnoreCase("ya") ? 1 : 0;
        int agreeStatement = params.getBoolean("agreeStatement") ? 1 : 0;
        int needAssistance = 0;
        Instant now = Instant.now(ClockUtil.getSystemClock());
        Date nowDate = Date.from(now);

        try {
            SppkDebiturLocalServiceUtil.updateSppkDebitur(debiturId, esppkQ1, esppkQ2, esppkQ3, agreeRiplay, agreeStatement, needAssistance, nowDate);
        } catch (Exception e) {
            log.info(e.getMessage());
            resourceResponse.getWriter().write(helper.errorMessage("Terjadi kesalahan, silakan coba beberapa saat lagi.", data).toString());
            return;
        }

        response.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 1);
        response.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, statusDebitur(esppkQ1, esppkQ2, esppkQ3));
        response.put("Data", data);

        resourceResponse.getWriter().write(response.toString());
    }

    private String getWebContentByFriendlyUrl(String friendlyUrl, ThemeDisplay themeDisplay) {
        long groupId = themeDisplay.getScopeGroupId();
        String webContent = "";
        try {
            JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, friendlyUrl);
            JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
                    journalArticle.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay);
            webContent = articleDisplay.getContent();
        } catch (PortalException e) {
            log.debug(e.getMessage());
        }

        return webContent;
    }

    private String statusDebitur(int esppkQ1, int esppkQ2, int esppkQ3) {
        if (esppkQ1 == 1 || esppkQ2 == 1 || esppkQ3 == 1) {
            return "NOT ELIGIBLE";
        }
        return "ELIGIBLE";
    }

    private boolean isTokenExpired(Date expiryDate) {
        if (expiryDate == null) {
            return true;
        }

        long now = Instant.now(ClockUtil.getSystemClock()).toEpochMilli();
        long expiry = expiryDate.getTime();

        return now > expiry;
    }

    private boolean isSubmit(Date submitDate) {
        return submitDate != null;
    }

    private void render404(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        renderRequest.setAttribute(AiiEsppkWebPortletKeys.PAGE_ACTIVE, "");
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/404.jsp");

        dispatcher.include(renderRequest, renderResponse);
    }
}