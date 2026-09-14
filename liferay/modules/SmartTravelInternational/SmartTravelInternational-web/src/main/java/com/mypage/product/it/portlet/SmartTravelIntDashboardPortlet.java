package com.mypage.product.it.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.mypage.product.it.constants.SmartTravelIntDashboardPortletKey;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=myPage",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=SmartTravel International Dashboard",
			"javax.portlet.init-param.template-path=/",
			//"javax.portlet.init-param.view-template=/dashboard/view.jsp",
			"javax.portlet.name=" + SmartTravelIntDashboardPortletKey.SMART_TRAVEL_INTERNATIONAL_DASHBOARD,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class SmartTravelIntDashboardPortlet extends MVCPortlet{

//	@Override
//	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		System.out.println("SmartTravelIntDashboardPortlet.render() TRACE SMART TRAVEL INTERNATIONAL RENDER!!!");
//
//		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/dashboard/view.jsp");
//		dispatcher.include(renderRequest, renderResponse);
//		
//		//super.render(renderRequest, renderResponse);
//	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {

	    // Lanjutkan render halaman seperti biasa
	    String jspPage = renderRequest.getParameter("jspPage");
	    if (jspPage == null || jspPage.isEmpty()) {
	        jspPage = "/dashboard/view.jsp";
	    }
	    

	    PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(jspPage);
	    dispatcher.include(renderRequest, renderResponse);
	}


}
