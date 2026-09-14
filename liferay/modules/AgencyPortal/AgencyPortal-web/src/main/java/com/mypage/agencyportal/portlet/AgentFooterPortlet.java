package com.mypage.agencyportal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.agencyportal.constants.AgentFooterPortletKeys;
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
			"javax.portlet.display-name=Agent Dashboard Footer",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/includes/footer.jsp",
			"javax.portlet.name=" + AgentFooterPortletKeys.AGENT_FOOTER,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AgentFooterPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		System.out.println("AgentDashboardFooterPortlet.render() FOOTER RENDER UPDATE");
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		HttpSession session = httpRequest.getSession();
		long mypageUserId = Validator.isNull(session.getAttribute(WebKeys.USER_ID)) == true ? 1 : (long) session.getAttribute(WebKeys.USER_ID);
		
		try {
			
			MypageUser user = _mypageUserLocalService.getMypageUser(mypageUserId);
			renderRequest.setAttribute("myPageUser", user);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	
}
