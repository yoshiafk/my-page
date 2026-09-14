package com.mypage.admin.product.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.mypage.admin.product.constants.InternationalTravelStandardNewAdminPortletKeys;
import com.mypage.admin.product.constants.MyPageAdminProductPanelCategoryKeys;
import com.mypage.admin.product.constants.SmartHealthAdminPortletKeys;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "panel.app.order:Integer=12", "panel.category.key="
		+ MyPageAdminProductPanelCategoryKeys.MYPAGE_ADMIN_PRODUCT_CATEGORY }, service = PanelApp.class)
public class InternationalTravelStandardNewAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return InternationalTravelStandardNewAdminPortletKeys.IT_STANDARD_NEW_ADMIN;
	}
	
	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "mypage_admin_product_smart_travel_international");
	}

	@Override
	@Reference(target = "(javax.portlet.name=" + InternationalTravelStandardNewAdminPortletKeys.IT_STANDARD_NEW_ADMIN
			+ ")", unbind = "-")

	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
