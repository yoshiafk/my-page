package com.mypage.agencyportal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.mypage.agencyportal.constants.AgentDashboardPortofolioPortletKeys;
import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Agent Dashboard Portofolio", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dashboard/portofolio/view.jsp",
		"javax.portlet.name=" + AgentDashboardPortofolioPortletKeys.AGENT_DASHBOARD_PORTOFOLIO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AgentDashboardPortofolioPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.render(renderRequest, renderResponse);
	}

}
