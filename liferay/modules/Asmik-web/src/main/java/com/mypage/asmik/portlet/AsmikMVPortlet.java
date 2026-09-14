package com.mypage.asmik.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.mypage.asmik.constants.AsmikMVPortletKeys;
import com.mypage.asmik.constants.AsmikPersonalAccidentPortletKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Asmik MV", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/mv.jsp", "javax.portlet.name=" + AsmikMVPortletKeys.ASMIK_MV,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AsmikMVPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
//		HttpServletRequest _httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
//		PortalUtil.setPageTitle("ASMIK MV Kalkulaltor", _httpServletRequest);
		
		super.render(renderRequest, renderResponse);
	}
}
