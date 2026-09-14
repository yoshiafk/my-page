package com.mypage.product.pet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.product.pet.constants.PetPortletKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + PetPortletKeys.PET,
"mvc.command.name=/pet_pimcore" }, service = MVCResourceCommand.class)

public class PetPimcoreMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		ParamUtil.getString(httpRequest, "currentToken");
		
		
		System.out.println("test");
		
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		resourceResponse.getWriter().write(jsonResponse.toString());
	}

}
