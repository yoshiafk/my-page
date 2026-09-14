package com.mypage.esppk.portlet;

import com.aii.esppk.admin.model.SppkDebitur;
import com.aii.esppk.admin.service.SppkDebiturLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;
import com.mypage.esppk.helper.ActionHelper;
import com.mypage.esppk.helper.EncryptionHelper;
import com.mypage.esppk.helper.ValidationAuthHelper;
import io.jsonwebtoken.Claims;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

/**
 * @author GOSITUS
 */
@Component(
    property = {
        "com.liferay.portlet.display-category=AXA Insurance Indonesia",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=MonitoringEsppk",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/step3.jsp",
        "javax.portlet.name=" + AiiEsppkWebPortletKeys.MONITORING,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class MonitoringPortlet extends MVCPortlet {
    private static final Log log = LogFactoryUtil.getLog(MonitoringPortlet.class);
    private static final String ACCESS_DATA = "accessData";
    private static final String ACCESS_MONITORING = "accessMonitoring";
    private static final String FULLNAME = "fullName";

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        log.info("Render Monitoring Portlet");

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (themeDisplay.isSignedIn()) {
            return;
        }

        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(renderResponse);

        // Set CSRF Token
        String secureToken = EncryptionHelper.generateSecureToken(32);

        HttpSession session = httpRequest.getSession();
        session.setAttribute("CSRF_TOKEN", secureToken);

        renderRequest.setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN, secureToken);
        renderRequest.setAttribute(AiiEsppkWebPortletKeys.CSRF_TOKEN_API, secureToken);

        Optional<Claims> claimsOpt = validationAuthHelper.validateAndAuthorize(
                httpRequest,
                httpResponse,
                renderRequest,
                ACCESS_MONITORING
        );

        if (!claimsOpt.isPresent()) {
            return;
        }

        Claims claims = claimsOpt.get();

        if (!validationAuthHelper.hasAccess(validationAuthHelper.getCookieValue(httpRequest), ACCESS_MONITORING)) {
            populateUserAttributes(renderRequest, claims);
            render404(renderRequest, renderResponse);
            return;
        }

        handleCommonRender(renderRequest, claims, "monitoring");
        super.render(renderRequest, renderResponse);
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
        renderRequest.setAttribute("idNumber", dataDebitur.getIdNumber());
        renderRequest.setAttribute("birthDate", dataDebitur.getBirthDate());
        renderRequest.setAttribute("status", helper.statusDebitur(dataDebitur.getEsppkQ1(), dataDebitur.getEsppkQ2(), dataDebitur.getEsppkQ3()));
        renderRequest.setAttribute("esppkQ1", dataDebitur.getEsppkQ1() == 1 ? constYa : constTidak);
        renderRequest.setAttribute("esppkQ2", dataDebitur.getEsppkQ2() == 1 ? constYa : constTidak);
        renderRequest.setAttribute("esppkQ3", dataDebitur.getEsppkQ3() == 1 ? constYa : constTidak);
        renderRequest.setAttribute("agreeRiplay", dataDebitur.getAgreeRiplay() == 1 ? constYa : constTidak);
        renderRequest.setAttribute("agreeStatement", dataDebitur.getAgreeStatement() == 1 ? constYa : constTidak);
    }

    private void render404(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        renderRequest.setAttribute(AiiEsppkWebPortletKeys.PAGE_ACTIVE, "monitoring");
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/404.jsp");

        dispatcher.include(renderRequest, renderResponse);
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

    private void populateUserAttributes(RenderRequest renderRequest, Claims claims) {
        if (claims == null || claims.isEmpty()) return;

        Object accessMonitoring = claims.get(ACCESS_MONITORING);
        if (accessMonitoring != null) renderRequest.setAttribute(ACCESS_MONITORING, claims.get(ACCESS_MONITORING));

        Object fullName = claims.get(FULLNAME);
        if (fullName != null) renderRequest.setAttribute(FULLNAME, fullName.toString().toUpperCase());

        Object accessData = claims.get(ACCESS_DATA);
        if (accessData != null) renderRequest.setAttribute(ACCESS_DATA, claims.get(ACCESS_DATA));
    }

    @Reference(unbind = "-")
    private ValidationAuthHelper validationAuthHelper;
}
