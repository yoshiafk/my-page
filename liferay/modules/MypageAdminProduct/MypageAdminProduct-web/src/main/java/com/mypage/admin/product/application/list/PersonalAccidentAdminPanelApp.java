package com.mypage.admin.product.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.mypage.admin.product.constants.MyPageAdminProductPanelCategoryKeys;
import com.mypage.admin.product.constants.PersonalAccidentAdminPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "panel.app.order:Integer=70", "panel.category.key="
		+ MyPageAdminProductPanelCategoryKeys.MYPAGE_ADMIN_PRODUCT_CATEGORY }, service = PanelApp.class)
public class PersonalAccidentAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return PersonalAccidentAdminPortletKeys.PERSONALACCIDENTADMIN;
	}

	@Override
	@Reference(target = "(javax.portlet.name=" + PersonalAccidentAdminPortletKeys.PERSONALACCIDENTADMIN + ")", unbind = "-")

	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
