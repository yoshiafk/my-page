package com.mypage.agencyportal.portlet;

import com.mypage.agencyportal.constants.AdminFAQPortletKey;
import com.mypage.agencyportal.model.AgentFAQ;
import com.mypage.agencyportal.model.AgentFAQCategory;
import com.mypage.agencyportal.service.AgentFAQCategoryLocalService;
import com.mypage.agencyportal.service.AgentFAQCategoryLocalServiceUtil;
import com.mypage.agencyportal.service.AgentFAQLocalService;
import com.mypage.agencyportal.service.AgentFAQLocalServiceUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

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
			"javax.portlet.display-name=FAQ",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/faq/master/faq/list.jsp",
			"javax.portlet.name=" + AdminFAQPortletKey.ADMIN_FAQ_PORTLET_KEY,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminAgentFAQPortlet extends MVCPortlet {

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

try {
	
	System.out.println("AdminAgentFAQPortlet.render() ADMIN HERE");
			
//			// START image selector
//			String imageSelectedItemEventName = renderResponse.getNamespace() + "imageSelectedItem";
//
//			RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil
//					.create(renderRequest);
//
//			ImageItemSelectorCriterion imageItemSelectorCriterion = new ImageItemSelectorCriterion();
//
//			imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(new FileEntryItemSelectorReturnType());
//
//			PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(requestBackedPortletURLFactory,
//					imageSelectedItemEventName, imageItemSelectorCriterion);
//
//			renderRequest.setAttribute("imageSelectedItemEventName", imageSelectedItemEventName);
//			renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
			// END image selector
		} catch (Exception e) {
			throw new PortletException(e);
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	/*
	 * Add or Update FAQ
	 */
	public void addFaq(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		int agentFaqId = ParamUtil.getInteger(actionRequest, "agentFaqId");
		String title = ParamUtil.getString(actionRequest, "title", "");
		String description = ParamUtil.getString(actionRequest, "description", "");
		int categoryId = ParamUtil.getInteger(actionRequest, "category");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
//		long fileEntryId = 0;
		

		if (agentFaqId > 0) {
			try {
				ParamUtil.print(actionRequest);
				AgentFAQLocalServiceUtil.updateFaq(agentFaqId, title, description, categoryId, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/faq/master/faq/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/faq/master/faq/edit.jsp");
			}
		} else {
			try {
				AgentFAQLocalServiceUtil.addFaq(title, description, categoryId, active);
				
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/faq/master/faq/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/faq/master/faq/edit.jsp");
			}
		}
	}
	
	/*
	 * Add or Update Category FAQ
	 */
	public void addFaqCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int agentFaqCategoryId = ParamUtil.get(actionRequest, "agentFaqCategoryId", 0);
		String category = ParamUtil.getString(actionRequest, "category", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (agentFaqCategoryId > 0) {
			try {
				ParamUtil.print(actionRequest);
				AgentFAQCategoryLocalServiceUtil.updateFaqCategory(agentFaqCategoryId, category, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/faq/master/category/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/faq/master/category/edit.jsp");
			}
		} else {
			try {
				AgentFAQCategoryLocalServiceUtil.addFaqCategory(category, active);
				
				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", "/faq/master/category/list.jsp");
			} catch (Exception e) {
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/faq/master/category/edit.jsp");
			}
		}
	}
	
	/**
	 * Set Status
	 */
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long agentFaqId = ParamUtil.getLong(actionRequest, "agentFaqId", 0);
		long agentFaqCategoryId = ParamUtil.getLong(actionRequest, "agentFaqCategoryId", 0);
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
			if (agentFaqId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentFAQ.class.getName(),
						actionRequest);
				_agentFAQLocalService.setActive(agentFaqId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/faq/master/faq/list.jsp");
			}
			
			if (agentFaqCategoryId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentFAQCategory.class.getName(),
						actionRequest);
				_agentFAQCategoryLocalService.setActive(agentFaqCategoryId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/faq/master/category/list.jsp");
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
	private AgentFAQLocalService  _agentFAQLocalService;
	
	@Reference
	private AgentFAQCategoryLocalService _agentFAQCategoryLocalService;
	
	@Reference
	private ItemSelector _itemSelector;
	
	
}