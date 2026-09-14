package com.mypage.agencyportal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.agencyportal.constants.AgentHeaderPortletKeys;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalService;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=myPage",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Agent Dashboard Header",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/includes/header.jsp",
			"javax.portlet.name=" + AgentHeaderPortletKeys.AGENT_HEADER,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AgentHeaderPortlet extends MVCPortlet {
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		HttpSession session = httpRequest.getSession();
		long mypageUserId = Validator.isNull(session.getAttribute(WebKeys.USER_ID)) == true ? 1 : (long) session.getAttribute(WebKeys.USER_ID);
		
		try {
			String url = PortalUtil.getCurrentURL(httpRequest);
			String[] parts = url.split("/");
			String lastPart = parts[parts.length - 1];
			
			if (lastPart.indexOf("?") != -1) {
			    String[] splitLastPart = lastPart.split("\\?");
			    lastPart = splitLastPart[0];
			}
			
			MypageUser user = _mypageUserLocalService.getMypageUser(mypageUserId);
			renderRequest.setAttribute("myPageUser", user);
			renderRequest.setAttribute("pageActive", lastPart);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;

}
