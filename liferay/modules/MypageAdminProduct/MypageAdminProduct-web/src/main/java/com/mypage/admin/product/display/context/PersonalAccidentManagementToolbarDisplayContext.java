package com.mypage.admin.product.display.context;

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

public class PersonalAccidentManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
	public PersonalAccidentManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
			SearchContainer<?> searchContainer) {
		super(httpServletRequest, liferayPortletRequest, liferayPortletResponse, searchContainer);

		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = httpServletRequest;
		_mvcPath = ParamUtil.getString(liferayPortletRequest, "mvcPath");
	}
	
	@Override
	public List<DropdownItem> getActionDropdownItems() {
		DropdownItemList item = new DropdownItemList();
		
		item.add(dropdownItem -> {
			dropdownItem.putData("action", "exportMultiple");
			dropdownItem.setIcon("download");
			dropdownItem.setLabel("Export Selected");
			dropdownItem.setQuickAction(true);
		});
		
		item.add(dropdownItem -> {
			String label = "Publish";
			
			dropdownItem.putData("action", "publish");
			dropdownItem.setIcon("disk");
			dropdownItem.setLabel(label);
			dropdownItem.setQuickAction(true);
		});
		
		item.add(dropdownItem -> {
			String label = "Unpublish";
			
			dropdownItem.putData("action", "unpublish");
			dropdownItem.setIcon("times");
			dropdownItem.setLabel(label);
			dropdownItem.setQuickAction(true);
		});
		
		return item;
	}
	
	@Override
	public String getSearchFormName() {
		return "searchForm";
	}

	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}

	// Add button
	@Override
	public CreationMenu getCreationMenu() {
		CreationMenu item = new CreationMenu();
		
		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getEditUrl(), "redirect", currentURLObj.toString());
			dropdownItem.setLabel("New");
		});
		
		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getImportPath(), "redirect", currentURLObj.toString());
			dropdownItem.setLabel("Import");
		});

		return item;
	}
	
	// Get Current Sorting URL
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

	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/product/personal_accident/premi/list.jsp")) {
			return "premi";
		}
		
		return "page";
	}
	
	private String _getEditUrl() {
		String editPath = null;
		
		if (_getPageType().equals("premi")) {
			editPath = "/product/personal_accident/premi/edit.jsp";
		}
		
		return editPath;
	}
	
	public String _getSearchActionURL() {
		String filterByCol = ParamUtil.getString(liferayPortletRequest, "filterByCol");
		PortletURL searchURL = liferayPortletResponse.createRenderURL();

		searchURL.setParameter("mvcPath", _mvcPath);
		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());
		searchURL.setParameter("filterByCol", filterByCol);

		return searchURL.toString();
	}

	private String _getImportPath() {
		if (_getPageType().equals("premi")) {
			return "/product/personal_accident/premi/import.jsp";
		}
		
		return null;
	}
	
	/**
	 * FILTER AND ORDER
	 */

	@Override
	protected String getFilterNavigationDropdownItemsLabel() {
		return "Filter By";
	}

	@Override
	public List<DropdownItem> getOrderByDropdownItems() {
		return _getOrderBy();
	}

	// Order By Filter
	private DropdownItemList _getOrderBy() {
		if (_getPageType().equals("premi")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "personalAccidentPremiId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "personalAccidentPremiId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Personal Accident Premi ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "premiType"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "premiType");
				dropdownItem.setLabel(LanguageUtil.get(request, "Premi Type"));
			});
			
			return item;
		}	

		return null;
	}

	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
}
