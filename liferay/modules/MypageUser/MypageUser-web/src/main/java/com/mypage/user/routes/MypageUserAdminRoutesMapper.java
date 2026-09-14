package com.mypage.user.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.mypage.user.constants.MypageUserPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	     property = {
	         "com.liferay.portlet.friendly-url-routes=META-INF/routes/mypageuser.xml",
	         "javax.portlet.name=" + MypageUserPortletKeys.MYPAGEUSER
	     },
	     service = FriendlyURLMapper.class
	 )
public class MypageUserAdminRoutesMapper extends DefaultFriendlyURLMapper {
	@Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "mypageUserAdmin";
}
