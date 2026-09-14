package com.mypage.user.portlet;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.BrowsePortletProvider;
import com.mypage.user.constants.MypageUserPortletKeys;
import com.mypage.user.constants.UserCreditPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "model.class.name=com.mypage.user.model.CreditType",
	        "service.ranking:Integer=100"
	    },
	    service = BrowsePortletProvider.class
	)
public class UserCreditPortletProvider extends BasePortletProvider implements BrowsePortletProvider {
	@Override
    public String getPortletName() {
        return UserCreditPortletKeys.USERCREDIT;
    }
}
