package com.mypage.esppk.portlet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;
import com.mypage.esppk.helper.ValidationAuthHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AiiEsppkWebPortletKeys.AIIESPPKWEB,
        "javax.portlet.name=" + AiiEsppkWebPortletKeys.DASHBOARD,
        "javax.portlet.name=" + AiiEsppkWebPortletKeys.DEBITUR,
        "javax.portlet.name=" + AiiEsppkWebPortletKeys.MONITORING,
        "mvc.command.name=/logout"
    },
    service = MVCResourceCommand.class
)
public class LogoutMVCResourceCommand extends BaseMVCResourceCommand {
    private static final Log log = LogFactoryUtil.getLog(LogoutMVCResourceCommand.class);

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
        HttpServletRequest httpRequest = PortalUtil
                .getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);
        JSONObject response = JSONFactoryUtil.createJSONObject();

        validationAuthHelper.clearSessionCookie(httpResponse);

        HttpSession session = httpRequest.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        response.put("Status", 1);
        response.put("Message", "");

        resourceResponse.getWriter().write(response.toString());
    }

    @Reference(unbind = "-")
    private ValidationAuthHelper validationAuthHelper;
}
