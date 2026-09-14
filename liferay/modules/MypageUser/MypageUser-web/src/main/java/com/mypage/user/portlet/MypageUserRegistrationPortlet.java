package com.mypage.user.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.user.constants.MypageUserRegistrationPortletKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.private-session-attributes=false", "com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=Mypage User Registration",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/user_registration/list.jsp",
		"javax.portlet.name=" + MypageUserRegistrationPortletKeys.MYPAGEUSERREGISTRATION,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false" }, service = Portlet.class)
public class MypageUserRegistrationPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

//		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {

		} catch(Exception e) {
			e.printStackTrace();
		}

		super.render(renderRequest, renderResponse);
	}
}
