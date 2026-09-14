package com.mypage.asmik.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.mypage.asmik.constants.AsmikPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(property = { "com.liferay.portlet.friendly-url-routes=META-INF/routes/asmik.xml",
		"javax.portlet.name=" + AsmikPortletKeys.ASMIK }, service = FriendlyURLMapper.class)
public class AsmikRoutesMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "calculator";
}
