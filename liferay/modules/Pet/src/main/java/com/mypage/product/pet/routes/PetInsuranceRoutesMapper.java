package com.mypage.product.pet.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.mypage.product.pet.constants.PetPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(property = { "com.liferay.portlet.friendly-url-routes=META-INF/routes/pet.xml", "javax.portlet.name=" + PetPortletKeys.PET }, service = FriendlyURLMapper.class)
public class PetInsuranceRoutesMapper extends DefaultFriendlyURLMapper {
	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "quote";
}
