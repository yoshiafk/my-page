package com.mypage.agencyportal.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.agencyportal.constants.AdminDashboardCalendarPortletKeys;
import com.mypage.agencyportal.model.AgentCalendar;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.service.AgentCalendarLocalService;
import com.mypage.agencyportal.service.AgentCalendarLocalServiceUtil;
import com.mypage.agencyportal.service.AgentEmailBucketLocalServiceUtil;
import com.mypage.agencyportal.service.AgentNotificationLocalService;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageGroupUserLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
			"javax.portlet.display-name=Calendar",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/dashboard/calendar/master/list.jsp",
			"javax.portlet.name=" + AdminDashboardCalendarPortletKeys.ADMIN_DASHBOARD_CALENDAR,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminDashboardCalendarPortlet extends MVCPortlet {

	/*
	 * Add or Update Calendar
	 */
	public void addCalendar(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentCalendar.class.getName(),
				actionRequest);
		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		int agentCalendarId = ParamUtil.get(actionRequest, "agentCalendarId", 0);
		String title = ParamUtil.getString(actionRequest, "title", "");
		String location = ParamUtil.getString(actionRequest, "location", "");
		String address = ParamUtil.getString(actionRequest, "address", "");
		String description = ParamUtil.getString(actionRequest, "description", "");
		String link = ParamUtil.getString(actionRequest, "link", "");
		String startDate = ParamUtil.getString(actionRequest, "startDate");
		String startTime = ParamUtil.getString(actionRequest, "startTime");
		String endDate = ParamUtil.getString(actionRequest, "endDate");
		String endTime = ParamUtil.getString(actionRequest, "endTime");
		String category = "Event";
		long roleId = ParamUtil.getLong(actionRequest, "role", 0);
		long groupId = ParamUtil.getLong(actionRequest, "group", 0);
		int isAllDay = ParamUtil.getBoolean(actionRequest, "isAllDay", false) ? 1 : 0;
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		String fileURL = ParamUtil.getString(actionRequest, "fileUrl", "");
		long fileEntryId = 0;
		
		if (Validator.isNotNull(uploadPortletRequest.getFileName("file"))) {
			File file = uploadPortletRequest.getFile("file");
			String imageFileName = uploadPortletRequest.getFileName("file");

			if (Validator.isNotNull(imageFileName)) {
				String imageFileContentType = uploadPortletRequest.getContentType("file");

				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Calendar");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							themeDisplay.getScopeGroupId(), false, 0, "Calendar", "", false, serviceContext);
				}
				
				_setGuestPermission(themeDisplay, DLFolder.class.getName(), userFolder.getPrimaryKey());
				
				long folderId = userFolder.getFolderId();
				
				// set filename
				String uniqueFileName = _uniqueFileNameProvider.provide(
						imageFileName, curFileName -> _exists(themeDisplay, folderId, curFileName));
				
				// add file
				FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
		                repositoryId, folderId, uniqueFileName, 
		                imageFileContentType, uniqueFileName, "", "", 
		                file, serviceContext
		        );
				
				_setGuestPermission(themeDisplay, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());
				
				fileEntryId = fileEntry.getFileEntryId();
				fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
				fileURL = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getFileName();
			}
		}

		if (agentCalendarId > 0) {
			try {
				ParamUtil.print(actionRequest);
				if (roleId > 0 || groupId > 0) {
					AgentCalendarLocalServiceUtil.updateCalendar(agentCalendarId, title, location, address,
												  description, link, category, roleId, groupId, startDate, startTime, endDate, endTime,
												  fileURL, fileEntryId, isAllDay, active);
					
					AgentNotificationLocalServiceUtil.updateNotification(title, location, address, description, link, category, 
							roleId, groupId, agentCalendarId, startDate, startTime, endDate, endTime, fileURL, fileEntryId, isAllDay, active);
				}

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/dashboard/calendar/master/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/dashboard/calendar/master/edit.jsp");
			}
		} else {
			try {
				if (roleId > 0 || groupId > 0) {
					AgentCalendar agentCalendar = AgentCalendarLocalServiceUtil.addCalendar(title, location, address, description, link,
												  category, roleId, groupId, startDate, startTime, endDate, endTime, fileURL,
												  fileEntryId, isAllDay, active, 0);

					List<MypageUser> users = roleId > 0 ? MypageUserLocalServiceUtil.getByRoleId(roleId) : groupId > 0 ? MypageGroupUserLocalServiceUtil.findBymypageGroupId(groupId) : null;
					
					if (Validator.isNotNull(users) && !users.isEmpty() && users.size() > 0) {
						String template = "/META-INF/resources/emailtemplate/event.ftl";
						SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id"));
						for (MypageUser user : users) {
							JSONObject params = JSONFactoryUtil.createJSONObject();
							params.put("name", user.getUserName());
							params.put("startDate", outputFormat.format(inputFormat.parse(startDate)));
							params.put("startTime", startTime);
							params.put("endTime", endTime);
							params.put("location", location);
							params.put("link", link);
							
							AgentEmailBucketLocalServiceUtil.addEmailBucket(title, "Event AXA MyPage", user.getEmail(), template, params.toString(), fileURL, fileEntryId);
						}
					}
					
					AgentNotificationLocalServiceUtil.addNotification(title, location, address, description, link, category, roleId,
							groupId, agentCalendar.getAgentCalendarId(), startDate, startTime, endDate, endTime, fileURL, fileEntryId,
							isAllDay, active, 0);
				}
				
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/dashboard/calendar/master/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/dashboard/calendar/master/edit.jsp");
			}
		}
	}
	
	/**
	 * Set Status
	 */
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long agentCalendarId = ParamUtil.getLong(actionRequest, "agentCalendarId", 0);
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
			if (agentCalendarId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentCalendar.class.getName(),
						actionRequest);
				_agentCalendarLocalService.setActive(agentCalendarId, active, serviceContext);
				
				ServiceContext serviceContextNotification = ServiceContextFactory.getInstance(AgentNotification.class.getName(),
						actionRequest);
				_agentNotificationLocalService.setActive(0, agentCalendarId, active, serviceContextNotification);
				
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/dashboard/calendar/master/list.jsp");
			}
		} catch (Exception e) {
//			System.out.println(e);
		}
	}
	
	private boolean _setGuestPermission(ThemeDisplay themeDisplay, String name, long primKey) {
		Map<Long, String[]> roleIdsToActionIds = new HashMap<>();
		roleIdsToActionIds.put(RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), RoleConstants.GUEST).getRoleId(), new String[]{ActionKeys.VIEW});
		
		try {
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
	                themeDisplay.getCompanyId(), name,
	                ResourceConstants.SCOPE_INDIVIDUAL,
	                String.valueOf(primKey),
	                roleIdsToActionIds);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean _exists(ThemeDisplay themeDisplay, long folderId, String curFileName) {
		try {
			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, curFileName);

			if (tempFileEntry != null) {
				return true;
			}

			return false;
		}
		catch (PortalException portalException) {
			return false;
		}
	}
	
	@Reference
	private AgentCalendarLocalService _agentCalendarLocalService;
	
	@Reference
	private AgentNotificationLocalService _agentNotificationLocalService;
	
	@Reference
	private ItemSelector _itemSelector;
	
	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;
}
