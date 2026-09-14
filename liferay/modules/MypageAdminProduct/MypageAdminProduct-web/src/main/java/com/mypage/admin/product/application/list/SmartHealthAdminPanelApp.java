package com.mypage.admin.product.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.mypage.admin.product.constants.MyPageAdminProductPanelCategoryKeys;
import com.mypage.admin.product.constants.SmartHealthAdminPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "panel.app.order:Integer=60", "panel.category.key="
		+ MyPageAdminProductPanelCategoryKeys.MYPAGE_ADMIN_PRODUCT_CATEGORY }, service = PanelApp.class)
public class SmartHealthAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SmartHealthAdminPortletKeys.SMARTHEALTHADMIN;
	}

	@Override
	@Reference(target = "(javax.portlet.name=" + SmartHealthAdminPortletKeys.SMARTHEALTHADMIN + ")", unbind = "-")

	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
