package com.mypage.agencyportal.portlet;

import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.constants.AdminSalesToolsPortletKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.model.AgentCategorySalesTools;
import com.mypage.agencyportal.model.AgentNotification;
import com.mypage.agencyportal.model.AgentSalesTools;
import com.mypage.agencyportal.service.AgentCategorySalesToolsLocalService;
import com.mypage.agencyportal.service.AgentCategorySalesToolsLocalServiceUtil;
import com.mypage.agencyportal.service.AgentNotificationLocalService;
import com.mypage.agencyportal.service.AgentNotificationLocalServiceUtil;
import com.mypage.agencyportal.service.AgentSalesToolsLocalService;
import com.mypage.agencyportal.service.AgentSalesToolsLocalServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus-IdeapadSlim5
 */
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
			"javax.portlet.display-name=Sales Tools",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/salestools/master/salestools/list.jsp",
			"javax.portlet.name=" + AdminSalesToolsPortletKeys.ADMIN_SALES_TOOLS,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminSalesToolsPortlet extends MVCPortlet {

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			
			// START image selector
			String imageSelectedItemEventName = renderResponse.getNamespace() + "imageSelectedItem";

			RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil
					.create(renderRequest);

			ImageItemSelectorCriterion imageItemSelectorCriterion = new ImageItemSelectorCriterion();

			imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(new FileEntryItemSelectorReturnType());

			PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(requestBackedPortletURLFactory,
					imageSelectedItemEventName, imageItemSelectorCriterion);

			renderRequest.setAttribute("imageSelectedItemEventName", imageSelectedItemEventName);
			renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
			// END image selector
		} catch (Exception e) {
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}
	
	/*
	 * Add or Update Sales Tools
	 */
	public void addSalesTools(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		ActionHelpers helpers = new ActionHelpers();
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentSalesTools.class.getName(),
				actionRequest);
		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		int agentSalesToolsId = ParamUtil.getInteger(actionRequest, "agentSalesToolsId");
		String title = ParamUtil.getString(actionRequest, "title", "");
		String description = ParamUtil.getString(actionRequest, "description", "");
		int categoryId = ParamUtil.getInteger(actionRequest, "category");
		int roleId = ParamUtil.getInteger(actionRequest, "role");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		String fileURL = ParamUtil.getString(actionRequest, "fileUrl", "");
		long fileEntryId = 0;
		
		if (Validator.isNotNull(uploadPortletRequest.getFileName("file"))) {
			File file = uploadPortletRequest.getFile("file");
			String imageFileName = uploadPortletRequest.getFileName("file");

			if (Validator.isNotNull(imageFileName)) {
				String imageFileContentType = uploadPortletRequest.getContentType("file");

				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Sales Tools");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							themeDisplay.getScopeGroupId(), false, 0, "Sales Tools", "", false, serviceContext);
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
		
		MasterGlobalVariable variable = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Message Template")
										.stream().filter(v -> v.getName().equalsIgnoreCase("sales tools") && v.getActive() == 1)
										.findFirst().get();
		String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");

		if (agentSalesToolsId > 0) {
			try {
				ParamUtil.print(actionRequest);
				AgentSalesToolsLocalServiceUtil.updateSalesTools(agentSalesToolsId, title, description, categoryId, fileURL,
						fileEntryId, roleId, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/salestools/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/salestools/edit.jsp");
			}
		} else {
			try {
				AgentSalesTools agentSalesTools = AgentSalesToolsLocalServiceUtil.addSalesTools(title, description, categoryId, fileURL, fileEntryId, roleId, active);
				
				title = "Training Materi Terbaru di Sales Tools";
				description = variable.getValue();
				String link = host.concat("/dashboard/sales-tools");
				
				AgentNotificationLocalServiceUtil.addNotification(title, "", "", description, link, variable.getName(), roleId,
						0, 0, "", "", "", "", "", 0, 1, active, 0);
				
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/salestools/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/salestools/edit.jsp");
			}
		}
	}
	
	/*
	 * Add or Update Category Sales Tools
	 */
	public void addCategorySalesTools(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int agentCategorySalesToolsId = ParamUtil.get(actionRequest, "agentCategorySalesToolsId", 0);
		String category = ParamUtil.getString(actionRequest, "category", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (agentCategorySalesToolsId > 0) {
			try {
				ParamUtil.print(actionRequest);
				AgentCategorySalesToolsLocalServiceUtil.updateCategorySalesTools(agentCategorySalesToolsId, category, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/category/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/category/edit.jsp");
			}
		} else {
			try {
				AgentCategorySalesToolsLocalServiceUtil.addCategorySalesTools(category, active);
				
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/category/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/category/edit.jsp");
			}
		}
	}
	
	/**
	 * Set Status
	 */
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long agentSalesToolsId = ParamUtil.getLong(actionRequest, "agentSalesToolsId", 0);
		long agentCategorySalesToolsId = ParamUtil.getLong(actionRequest, "agentCategorySalesToolsId", 0);
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
			if (agentSalesToolsId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentSalesTools.class.getName(),
						actionRequest);
				_agentSalesToolsLocalService.setActive(agentSalesToolsId, active, serviceContext);
				
				ServiceContext serviceContextNotification = ServiceContextFactory.getInstance(AgentNotification.class.getName(),
						actionRequest);
				_agentNotificationLocalService.setActive(0, agentSalesToolsId, active, serviceContextNotification);
				
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/salestools/list.jsp");
			}
			
			if (agentCategorySalesToolsId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentCategorySalesTools.class.getName(),
						actionRequest);
				_agentCategorySalesToolsLocalService.setActive(agentCategorySalesToolsId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/salestools/master/category/list.jsp");
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
	private AgentSalesToolsLocalService _agentSalesToolsLocalService;
	
	@Reference
	private AgentCategorySalesToolsLocalService _agentCategorySalesToolsLocalService;
	
	@Reference
	private AgentNotificationLocalService _agentNotificationLocalService;
	
	@Reference
	private ItemSelector _itemSelector;
	
	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;
}