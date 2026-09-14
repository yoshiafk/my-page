package com.mypage.agencyportal.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.mypage.agencyportal.constants.AgentDashboardPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
     property = {
         "com.liferay.portlet.friendly-url-routes=META-INF/routes/masterdata.xml",
         "javax.portlet.name=" + AgentDashboardPortletKeys.AGENT_DASHBOARD
     },
     service = FriendlyURLMapper.class
 )
public class AgentDashboardCalendarEventRoutesMapper extends DefaultFriendlyURLMapper {
    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "events";

}
