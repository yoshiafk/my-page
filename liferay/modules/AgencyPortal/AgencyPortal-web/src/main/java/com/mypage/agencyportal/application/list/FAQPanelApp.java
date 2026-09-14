package com.mypage.agencyportal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.mypage.agencyportal.constants.AdminFAQPortletKey;
import com.mypage.agencyportal.constants.AgencyPortalPanelCategoryKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
immediate = true,
property = {
    "panel.app.order:Integer=100",
    "panel.category.key=" + AgencyPortalPanelCategoryKeys.AGENCY_PORTAL_CATEGORY
    },
    service = PanelApp.class
)
public class FAQPanelApp extends BasePanelApp{

	@Override
	public String getPortletId() {
		return AdminFAQPortletKey.ADMIN_FAQ_PORTLET_KEY;
	}
	
	@Override
	@Reference(target = "(javax.portlet.name=" + AdminFAQPortletKey.ADMIN_FAQ_PORTLET_KEY + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
