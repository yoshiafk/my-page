package com.mypage.agencyportal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.mypage.agencyportal.constants.FAQPortletKey;
import com.mypage.agencyportal.model.AgentFAQCategory;
import com.mypage.agencyportal.service.AgentFAQCategoryLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=myPage",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Agency FAQ",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/faq/faq.jsp",
			"javax.portlet.name=" + FAQPortletKey.FAQ_KEY_PORTLET,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class FAQPortlet extends MVCPortlet{
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		try {
			
			List<AgentFAQCategory> categories = AgentFAQCategoryLocalServiceUtil.getActiveCategoryInUse();
			renderRequest.setAttribute("categories", categories);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		super.render(renderRequest, renderResponse);
	}

}
