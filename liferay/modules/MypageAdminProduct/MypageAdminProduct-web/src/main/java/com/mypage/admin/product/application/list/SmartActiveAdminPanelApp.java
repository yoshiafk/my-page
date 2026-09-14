package com.mypage.admin.product.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.mypage.admin.product.constants.MyPageAdminProductPanelCategoryKeys;
import com.mypage.admin.product.constants.SmartActiveAdminPortletKeys;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "panel.app.order:Integer=13", "panel.category.key="
		+ MyPageAdminProductPanelCategoryKeys.MYPAGE_ADMIN_PRODUCT_CATEGORY }, service = PanelApp.class)
public class SmartActiveAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SmartActiveAdminPortletKeys.SMART_ACTIVE_ADMIN;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "mypage_admin_product_smart_active");
	}

	@Override
	@Reference(target = "(javax.portlet.name=" + SmartActiveAdminPortletKeys.SMART_ACTIVE_ADMIN + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
