package com.mypage.asmik.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.asmik.constants.AsmikPortletKeys;
import com.mypage.asmik.constants.EIPOperation;
import com.mypage.asmik.misc.EIP;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Asmik", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + AsmikPortletKeys.ASMIK,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AsmikPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		HttpServletRequest _httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		
		String currentParam = renderRequest.getParameter("mvcPath");
		
		if(!Validator.isNull(currentParam) && currentParam.equals("/mv.jsp")) {
			PortalUtil.setPageTitle("Kalkulator Mikro - MV Multiyear", _httpServletRequest);
		}
		
		if(!Validator.isNull(currentParam) && currentParam.equals("/pa.jsp")) {
			PortalUtil.setPageTitle("Kalkulator Mikro - PA Plus", _httpServletRequest);
		}
		
		if(!Validator.isNull(currentParam) && currentParam.equals("/fire.jsp")) {
			PortalUtil.setPageTitle("Kalkulator Mikro - Fire", _httpServletRequest);
		}
		
		super.render(renderRequest, renderResponse);
	}

}