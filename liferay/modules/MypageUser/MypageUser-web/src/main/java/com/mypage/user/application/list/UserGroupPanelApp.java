package com.mypage.user.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.mypage.user.constants.MypageUserPanelCategoryKeys;
import com.mypage.user.constants.UserGroupPortletKeys;

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
public class UserGroupPanelApp extends BasePanelApp {
	
	@Override
	public String getPortletId() {
		return UserGroupPortletKeys.MYPAGEUSER_GROUP;
	}
	
	@Override
	@Reference(target = "(javax.portlet.name=" + UserGroupPortletKeys.MYPAGEUSER_GROUP + ")", unbind = "-")

	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
