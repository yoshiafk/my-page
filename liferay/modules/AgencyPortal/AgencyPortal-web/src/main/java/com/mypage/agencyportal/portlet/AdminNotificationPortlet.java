package com.mypage.agencyportal.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.agencyportal.constants.AdminNotificationPortletKeys;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.service.AgentNotificationLocalService;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;

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
			"com.liferay.portlet.header-portlet-css=/css/master_admin.css",
			"com.liferay.portlet.layout-cacheable=true",
			"com.liferay.portlet.private-request-attributes=false",
			"com.liferay.portlet.private-session-attributes=false",
			"com.liferay.portlet.render-weight=50",
			"com.liferay.portlet.use-default-template=true",
			"javax.portlet.display-name=Notification",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/notification/master/list.jsp",
			"javax.portlet.name=" + AdminNotificationPortletKeys.ADMIN_NOTIFICATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminNotificationPortlet extends MVCPortlet {
	/*
	 * Add or Update Notification
	 */
	public void addNotification(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		int agentNotificationId = ParamUtil.get(actionRequest, "agentNotificationId", 0);
		String title = ParamUtil.getString(actionRequest, "title", "");
		String location = ParamUtil.getString(actionRequest, "location", "");
		String address = ParamUtil.getString(actionRequest, "address", "");
		String description = ParamUtil.getString(actionRequest, "description", "");
		String link = ParamUtil.getString(actionRequest, "link", "");
		String startDate = ParamUtil.getString(actionRequest, "startDate");
		String startTime = ParamUtil.getString(actionRequest, "startTime");
		String endDate = ParamUtil.getString(actionRequest, "endDate");
		String endTime = ParamUtil.getString(actionRequest, "endTime");
		String category = "Information";
		long roleId = ParamUtil.getLong(actionRequest, "role", 0);
		long groupId = ParamUtil.getLong(actionRequest, "group", 0);
		int isAllDay = ParamUtil.getBoolean(actionRequest, "isAllDay", false) ? 1 : 0;
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (agentNotificationId > 0) {
			try {
				ParamUtil.print(actionRequest);
				if (roleId > 0 || groupId > 0) {
					AgentNotificationLocalServiceUtil.updateNotificationAdmin(agentNotificationId, title, location, address, description, link, category, 
							roleId, groupId, 0, startDate, startTime, endDate, endTime, isAllDay, active);
				}

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/notification/master/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/notification/master/edit.jsp");
			}
		} else {
			try {
				if (roleId > 0 || groupId > 0) {
					AgentNotificationLocalServiceUtil.addNotification(title, location, address, description, link, category, roleId,
							groupId, 0, startDate, startTime, endDate, endTime, "", 0, isAllDay, active, 0);
				}
				
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/notification/master/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/notification/master/edit.jsp");
			}
		}
	}
	
	/**
	 * Set Status
	 */
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long agentNotificationId = ParamUtil.getLong(actionRequest, "agentNotificationId", 0);
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
			if (agentNotificationId != 0) {
				ServiceContext serviceContextNotification = ServiceContextFactory.getInstance(AgentNotification.class.getName(),
						actionRequest);
				_agentNotificationLocalService.setActive(agentNotificationId, 0, active, serviceContextNotification);
				
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/notification/master/list.jsp");
			}
		} catch (Exception e) {
//			System.out.println(e);
		}
	}
	
	@Reference
	private AgentNotificationLocalService _agentNotificationLocalService;
}
