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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.user.constants.UserGroupPortletKeys;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserGroup;
import com.mypage.user.service.MypageGroupUserLocalServiceUtil;
import com.mypage.user.service.MypageUserGroupLocalService;
import com.mypage.user.service.MypageUserGroupLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

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
				"javax.portlet.display-name=User Group",
				"javax.portlet.expiration-cache=0",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/user_group/list.jsp",
				"javax.portlet.name=" + UserGroupPortletKeys.MYPAGEUSER_GROUP,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class UserGroupPortlet extends MVCPortlet {
	public void addUserGroup(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int mypageUserGroupId = ParamUtil.get(actionRequest, "mypageUserGroupId", 0);
		String name = ParamUtil.getString(actionRequest, "name", "");
		String mypageUserId = ParamUtil.getString(actionRequest, "mypageUserId", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		List<Long> listMypageUserId = new ArrayList<>();
		
		if (Validator.isNotNull(mypageUserId)) {
			String[] mypageUserIdArray = mypageUserId.split(",");
			
			for (String item : mypageUserIdArray) {
				listMypageUserId.add(Long.parseLong(item));
	        }
		}

		if (mypageUserGroupId > 0) {
			try {
				ParamUtil.print(actionRequest);
				MypageUserGroupLocalServiceUtil.updateUserGroup(mypageUserGroupId, name, active);	
				
				if (Validator.isNotNull(mypageUserId)) {
					List<Long> listRemoveUser = listRemoveUser(mypageUserGroupId, listMypageUserId);
					
					if (listRemoveUser.size() > 0) {
						MypageGroupUserLocalServiceUtil.removeGroupUser(mypageUserGroupId, listRemoveUser);
					}
					
					if (listMypageUserId.size() > 0) {
						MypageGroupUserLocalServiceUtil.addGroupUser(mypageUserGroupId, listMypageUserId);
					}
				} else {
					MypageGroupUserLocalServiceUtil.removeGroupUser(mypageUserGroupId, listMypageUserId);
				}

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/user_group/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/user_group/edit.jsp");
			}
		} else {
			try {
				MypageUserGroup mypageUserGroup = MypageUserGroupLocalServiceUtil.addUserGroup(name, active);
				
				if (listMypageUserId.size() > 0) {
					MypageGroupUserLocalServiceUtil.addGroupUser(mypageUserGroup.getMypageUserGroupId(), listMypageUserId);
				}
				
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/user_group/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/user_group/edit.jsp");
			}
		}
	}
	
	/**
	 * Set Status
	 */
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long mypageUserGroupId = ParamUtil.getLong(actionRequest, "mypageUserGroupId", 0);
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
			if (mypageUserGroupId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(MypageUserGroup.class.getName(),
						actionRequest);
				_mypageUserGroupLocalService.setActive(mypageUserGroupId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/user_group/list.jsp");
			}
		} catch (Exception e) {
//			System.out.println(e);
		}
	}
	
	public List<Long> listRemoveUser(long mypageUserGroupId, List<Long> listMypageUserId) {		
		List<Long> ids = new ArrayList<>();

		List<MypageUser> users = MypageGroupUserLocalServiceUtil.findBymypageGroupId(mypageUserGroupId);
		
		for (MypageUser user : users) {
			ids.add(user.getMypageUserId());
        }
		
		ids.removeAll(listMypageUserId);
		
		return ids;
	}
	
	@Reference
	private MypageUserGroupLocalService _mypageUserGroupLocalService;
}
