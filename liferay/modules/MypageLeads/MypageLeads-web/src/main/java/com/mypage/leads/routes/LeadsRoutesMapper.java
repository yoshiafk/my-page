package com.mypage.leads.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.mypage.leads.constants.MypageLeadsPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	     property = {
	         "com.liferay.portlet.friendly-url-routes=META-INF/routes/leads.xml",
	         "javax.portlet.name=" + MypageLeadsPortletKeys.MYPAGELEADS
	     },
	     service = FriendlyURLMapper.class
	 )
public class LeadsRoutesMapper extends DefaultFriendlyURLMapper {
    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "leads";
}