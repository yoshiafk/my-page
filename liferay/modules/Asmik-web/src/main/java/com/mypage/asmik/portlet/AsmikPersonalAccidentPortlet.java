package com.mypage.asmik.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.asmik.constants.AsmikPersonalAccidentPortletKeys;
import com.mypage.asmik.constants.AsmikPortletKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;


@Component(immediate = true, property = { "com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Asmik Personal Accident", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/pa.jsp", "javax.portlet.name=" + AsmikPersonalAccidentPortletKeys.ASMIK_PERSONAL_ACCIDENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AsmikPersonalAccidentPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
//		HttpServletRequest _httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
//		PortalUtil.setPageTitle("ASMIK PA Kalkulator", _httpServletRequest);
		
		super.render(renderRequest, renderResponse);
	}
}
