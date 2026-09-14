package com.aii.esppk.admin.application.list;

import com.aii.esppk.admin.constants.AiiEsppkAdminPanelCategoryKeys;
import com.aii.esppk.admin.constants.AiiEsppkAdminPortletKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "panel.app.order:Integer=110", "panel.category.key="
		+ AiiEsppkAdminPanelCategoryKeys.AIIESPPKADMIN_PANEL_CATEGORY }, service = PanelApp.class)
public class AiiEsppkAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return AiiEsppkAdminPortletKeys.AIIESPPKADMIN;
	}
	
	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());
		return LanguageUtil.get(resourceBundle, "aii_esppk_user");
	}
	
	@Override
	@Reference(target = "(javax.portlet.name=" + AiiEsppkAdminPortletKeys.AIIESPPKADMIN + ")", unbind = "-")

	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
