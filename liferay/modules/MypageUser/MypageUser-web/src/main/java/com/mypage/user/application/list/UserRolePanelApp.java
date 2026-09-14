package com.mypage.user.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.mypage.user.constants.MypageUserPanelCategoryKeys;
import com.mypage.user.constants.UserRolePortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
immediate = true,
property = {
    "panel.app.order:Integer=100",
    "panel.category.key=" + MypageUserPanelCategoryKeys.MYPAGE_USER_CATEGORY
    },
    service = PanelApp.class
)
public class UserRolePanelApp extends BasePanelApp {
	
	@Override
	public String getPortletId() {
		return UserRolePortletKeys.MYPAGEUSER_ROLE;
	}
	
	@Override
	@Reference(target = "(javax.portlet.name=" + UserRolePortletKeys.MYPAGEUSER_ROLE + ")", unbind = "-")

	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
