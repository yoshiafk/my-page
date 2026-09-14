package com.mypage.user.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.mypage.user.constants.MypageUserPanelCategoryKeys;
import com.mypage.user.constants.UserCreditPortletKeys;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
			immediate = true, 
			property = { 
						"panel.app.order:Integer=200", 
						"panel.category.key="+ MypageUserPanelCategoryKeys.MYPAGE_USER_CATEGORY 
					}, 
			service = PanelApp.class
		)
public class UserCreditPanelApp extends BasePanelApp {
	@Override
	public String getPortletId() {
		return UserCreditPortletKeys.USERCREDIT;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", locale, getClass());
		return LanguageUtil.get(resourceBundle, "admin_sidebar_user");
	}

	@Override
	@Reference(target = "(javax.portlet.name=" + UserCreditPortletKeys.USERCREDIT + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
