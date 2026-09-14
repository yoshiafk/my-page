package com.mypage.agencyportal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.agencyportal.constants.AgentAuthenticationPortletKeys;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=myPage",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Agent Forgot Password",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/auth/reset_password/view.jsp",
			"javax.portlet.name=" + AgentAuthenticationPortletKeys.AGENT_FGTPSW,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AgentForgotPasswordPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		try {
			String token = ParamUtil.getString(httpRequest, "a");
			
			MypageUser mypageUser = MypageUserLocalServiceUtil.getByToken(token);
			
			long userId = mypageUser.getLiferayUserId();
			String email = UserLocalServiceUtil.fetchUser(userId).getEmailAddress();
			long currentTime = System.currentTimeMillis() / 1000;
			long expiresTime = (mypageUser.getTempCodeExpiryDate().getTime() / 1000) + (-7 * 3600);
			
			if (currentTime > expiresTime) {
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/auth/reset_password/404.jsp");
				dispatcher.include(renderRequest, renderResponse);
			} else {
				renderRequest.setAttribute("email", email);
				
				PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/auth/reset_password/view.jsp");
				dispatcher.include(renderRequest, renderResponse);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/auth/reset_password/404.jsp");
			dispatcher.include(renderRequest, renderResponse);
		}
	}
}
