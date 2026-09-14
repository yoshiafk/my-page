package com.aii.esppk.admin.display.context;

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

import java.util.List;
import java.util.Objects;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class UserEsppkManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

	public UserEsppkManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
			SearchContainer<?> searchContainer) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest, searchContainer);

		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = httpServletRequest;
		_mvcPath = ParamUtil.getString(liferayPortletRequest, "mvcPath", "/user/list.jsp");
	}

	// Creation Menu
	@Override
	public CreationMenu getCreationMenu() {
		CreationMenu item = new CreationMenu();

		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getEditUrl(), "redirect",
					currentURLObj.toString());
			dropdownItem.setLabel("New");
		});

		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getImportPagePath(), "redirect",
					currentURLObj.toString());
			dropdownItem.setLabel("Import");
		});

		return item;
	}

	private String _getPageType() {
		if (_mvcPath.equals("/user/list.jsp")) {
			return "userSppk";
		}

		return "userSppk";
	}

	// Get Add URL
	private String _getAddUrl() {
		String addPath = null;

		if (_getPageType().equals("userSppk")) {
			addPath = "/user/add.jsp";
		}

		return addPath;
	}
	
	// Get Edit URL
	private String _getEditUrl() {
		String editPath = null;

		if (_getPageType().equals("userSppk")) {
			editPath = "/user/edit.jsp";
		}

		return editPath;
	}	

	// Get Import Page Path
	private String _getImportPagePath() {
		if (_getPageType().equals("userSppk")) {
			return "/user/import.jsp";
		}

		return null;
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

	// Order By
	@Override
	public List<DropdownItem> getOrderByDropdownItems() {
		return _getOrderBy();
	}

	private DropdownItemList _getOrderBy() {
		if (_getPageType().equals("userSppk")) {
			DropdownItemList item = new DropdownItemList();

			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "sppkUserId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "sppkUserId");
				dropdownItem.setLabel(LanguageUtil.get(request, "SPPK User ID"));
			});
			return item;
		}
		return null;
	}

	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
}
