package com.mypage.admin.product.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.mypage.admin.product.constants.PetAdminPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(property = { "com.liferay.portlet.friendly-url-routes=META-INF/routes/pet.xml",
		"javax.portlet.name=" + PetAdminPortletKeys.PET_ADMIN }, service = FriendlyURLMapper.class)
public class PetAdminRoutesMapper extends DefaultFriendlyURLMapper {
	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "pet-admin";
}
