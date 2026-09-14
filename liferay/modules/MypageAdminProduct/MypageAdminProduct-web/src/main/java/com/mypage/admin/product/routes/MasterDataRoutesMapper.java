package com.mypage.admin.product.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.mypage.admin.product.constants.MasterAdminPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	     property = {
	         "com.liferay.portlet.friendly-url-routes=META-INF/routes/masterdata.xml",
	         "javax.portlet.name=" + MasterAdminPortletKeys.MASTER_DATA
	     },
	     service = FriendlyURLMapper.class
	 )
public class MasterDataRoutesMapper extends DefaultFriendlyURLMapper {
    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "masterData";
}
