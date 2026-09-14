package com.mypage.user.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.user.constants.UserRolePortletKeys;
import com.mypage.user.model.MypageUserRole;
import com.mypage.user.service.MypageUserRoleLocalService;
import com.mypage.user.service.MypageUserRoleLocalServiceUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.layout-cacheable=true",
			"com.liferay.portlet.private-request-attributes=false",
			"com.liferay.portlet.private-session-attributes=false",
			"com.liferay.portlet.render-weight=50",
			"com.liferay.portlet.use-default-template=true",
			"javax.portlet.display-name=User Role",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/user_role/list.jsp",
			"javax.portlet.name=" + UserRolePortletKeys.MYPAGEUSER_ROLE,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserRolePortlet extends MVCPortlet {
	
	public void addUserRole(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int mypageUserRoleId = ParamUtil.get(actionRequest, "mypageUserRoleId", 0);
		String name = ParamUtil.getString(actionRequest, "name", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (mypageUserRoleId > 0) {
			try {
				ParamUtil.print(actionRequest);
				MypageUserRoleLocalServiceUtil.updateUserRole(mypageUserRoleId, name, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/user_role/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/user_role/edit.jsp");
			}
		} else {
			try {
				MypageUserRoleLocalServiceUtil.addUserRole(name, active);
				
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/user_role/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/user_role/edit.jsp");
			}
		}
	}
	
	/**
	 * Set Status
	 */
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long mypageUserRoleId = ParamUtil.getLong(actionRequest, "mypageUserRoleId", 0);
		String _actionVal = ParamUtil.getString(actionRequest, "action", "");
		int active = 1;

		long[] entryIds = ParamUtil.getLongValues(actionRequest, "EntryIds");
		String cmd = ParamUtil.getString(actionRequest, "cmd", "");

		try {
			if (_actionVal.equals("unpublish")) {
				active = 0;
			}
		} catch (Exception e) {
//			System.out.println(e);
		}

		try {
			if (mypageUserRoleId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MypageUserRole.class.getName(),
						actionRequest);
				_mypageUserRoleLocalService.setActive(mypageUserRoleId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/user_role/list.jsp");
			}
		} catch (Exception e) {
//			System.out.println(e);
		}
	}
	
	@Reference
	private MypageUserRoleLocalService _mypageUserRoleLocalService;
}
