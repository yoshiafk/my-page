package com.mypage.admin.product.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.mypage.admin.product.constants.MasterAdminPortletKeys;
import com.mypage.admin.product.constants.MyPageAdminProductPanelCategoryKeys;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "panel.app.order:Integer=10", "panel.category.key="
		+ MyPageAdminProductPanelCategoryKeys.MYPAGE_ADMIN_PRODUCT_CATEGORY }, service = PanelApp.class)

public class MasterAdminPanelApp extends BasePanelApp {
	@Override
	public String getPortletId() {
		return MasterAdminPortletKeys.MASTER_DATA;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "mypage_admin_master_data");
	}

	@Override
	@Reference(target = "(javax.portlet.name=" + MasterAdminPortletKeys.MASTER_DATA + ")", unbind = "-")

	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
