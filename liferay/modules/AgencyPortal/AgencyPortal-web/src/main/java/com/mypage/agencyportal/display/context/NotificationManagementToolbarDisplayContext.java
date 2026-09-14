package com.mypage.agencyportal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class NotificationManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

	// Constructor
	public NotificationManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
			SearchContainer<?> searchContainer) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest, searchContainer);

		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = httpServletRequest;
		_mvcPath = ParamUtil.getString(liferayPortletRequest, "mvcPath", "/notification/master/list.jsp");
	}

	// Action Dropdown
	@Override
	public List<DropdownItem> getActionDropdownItems() {
		List<DropdownItem> dropdownItems = new ArrayList<>();
		
		return dropdownItems;
	}

	// Creation Menu
	@Override
	public CreationMenu getCreationMenu() {
		CreationMenu creationMenu = new CreationMenu();
		
		creationMenu.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getEditUrl(), "redirect",
					currentURLObj.toString());
			dropdownItem.setLabel("New");
		});
		
		if (Validator.isNull(_getImportPagePath()) == false) {
			creationMenu.addDropdownItem(dropdownItem -> {
				dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getImportPagePath(),
						"redirect", currentURLObj.toString());
				dropdownItem.setLabel("Import");
			});	
		}
		
		return creationMenu;
	}

	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/notification/master/list.jsp")) {
			return "notification";
		}
		return "notification";
	}

	// Get Edit URL
	private String _getEditUrl() {
		String editPath = null;

		if (_getPageType().equals("notification")) {
			editPath = "/notification/master/edit.jsp";
		}
		return editPath;
	}

	// Get Import Page Path
	private String _getImportPagePath() {
		return null;
	}

	/**
	 * FORM
	 */

	@Override
	public String getSearchFormName() {
		return "searchForm";
	}

	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}

	// Search Action URL
	public String _getSearchActionURL() {
		String filterByCol = ParamUtil.getString(liferayPortletRequest, "filterByCol");
		PortletURL searchURL = liferayPortletResponse.createRenderURL();

		searchURL.setParameter("mvcPath", _mvcPath);
		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());
		searchURL.setParameter("filterByCol", filterByCol);

		return searchURL.toString();
	}

	// Current Sorting URL
	public PortletURL _getCurrentSortingURL() {
		PortletURL sortingURL = getPortletURL();

		sortingURL.setParameter("mvcPath", _mvcPath);
		sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");

		String keywords = ParamUtil.getString(request, "keywords");

		if (Validator.isNotNull(keywords)) {
			sortingURL.setParameter("keywords", keywords);
		}

		return sortingURL;
	}

	/**
	 * FILTER & ORDER
	 */
	@Override
	protected String getFilterNavigationDropdownItemsLabel() {
		return "Filter By";
	}

	@Override
	public List<DropdownItem> getOrderByDropdownItems() {
		return _getOrderBy();
	}

	// Order By
	private DropdownItemList _getOrderBy() {
		if (_getPageType().equals("notification")) {
			DropdownItemList dropdownItemList = new DropdownItemList();
			
			dropdownItemList.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "agentNotificationId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "agentNotificationId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Notification ID"));
			});
			dropdownItemList.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "title"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "title");
				dropdownItem.setLabel(LanguageUtil.get(request, "Title"));
			});
			dropdownItemList.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "category"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "category");
				dropdownItem.setLabel(LanguageUtil.get(request, "Category"));
			});
			
			return dropdownItemList;
		}

		return null;
	}

	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
}