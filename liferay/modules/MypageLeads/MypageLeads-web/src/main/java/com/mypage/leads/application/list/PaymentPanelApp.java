package com.mypage.leads.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.mypage.leads.constants.MypageLeadsPanelCategoryKeys;
import com.mypage.leads.constants.PaymentPortletKeys;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus Programmer
 */

@Component(immediate = true, property = { "panel.app.order:Integer=200", "panel.category.key="
		+ MypageLeadsPanelCategoryKeys.MYPAGE_LEADS_CATEGORY }, service = PanelApp.class)

public class PaymentPanelApp extends BasePanelApp {
	@Override
	public String getPortletId() {
		return PaymentPortletKeys.PAYMENT;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());
		return LanguageUtil.get(resourceBundle, "mypageleads_payment");
	}

	@Override
	@Reference(target = "(javax.portlet.name=" + PaymentPortletKeys.PAYMENT + ")", unbind = "-")

	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
