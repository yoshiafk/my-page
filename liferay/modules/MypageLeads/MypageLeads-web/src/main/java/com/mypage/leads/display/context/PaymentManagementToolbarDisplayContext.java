package com.mypage.leads.display.context;

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

public class PaymentManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
	
	// Constructor
	public PaymentManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
			SearchContainer<?> searchContainer) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest, searchContainer);

		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = httpServletRequest;
		_mvcPath = ParamUtil.getString(liferayPortletRequest, "mvcPath", "/payment/list.jsp");
	}
	

	// Action Dropdown
	@Override
	public List<DropdownItem> getActionDropdownItems() {
		DropdownItemList item = new DropdownItemList();
		
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

		item.add(dropdownItem -> {
			String label = "Delete";

			dropdownItem.putData("action", "deleteItem");
			dropdownItem.setIcon("trash");
			dropdownItem.setLabel(label);
			dropdownItem.setQuickAction(true);
		});
		
		return item;
	}

	// Creation Menu
	@Override
	public CreationMenu getCreationMenu() {
		CreationMenu item = new CreationMenu();
		
		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getEditUrl(), "redirect", currentURLObj.toString());
			dropdownItem.setLabel("New");
		});

		return item;
	}

	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/payment/list.jsp")) {
			return "payment";
		}
		// Default
		return "payment";
	}

	// Get Edit URL
	private String _getEditUrl() {
		String editPath = null;

		if (_getPageType().equals("payment")) {
			editPath = "/payment/edit.jsp";
		}
		
		return editPath;
	}

	/*
	// Get Import Page Path
	private String _getImportPagePath() {
		if (_getPageType().equals("country")) {
			return "/master/country/import.jsp";
		}
		if (_getPageType().equals("currency")) {
			return "/master/currency/import.jsp";
		}
		if (_getPageType().equals("blacklist_customer")) {
			return "/master/blacklist_customer/import.jsp";
		}
		if (_getPageType().equals("province")) {
			return "/master/province/import.jsp";
		}
		if (_getPageType().equals("city")) {
			return "/master/city/import.jsp";
		}
		if (_getPageType().equals("promocode")) {
			return "/master/promocode/import.jsp";
		}
		if (_getPageType().equals("industry_category")) {
			return "/master/industry_category/import.jsp";
		}
		if (_getPageType().equals("industry")) {
			return "/master/industry/import.jsp";
		}
		if (_getPageType().equals("job_position")) {
			return "/master/job_position/import.jsp";
		}
		return null;
	} */

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

		if (_getPageType().equals("payment")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "paymentId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "paymentId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Payment Id"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "TransactionDateTime"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "TransactionDateTime");
				dropdownItem.setLabel(LanguageUtil.get(request, "Transaction Time"));
			});
			
			return item;
		}


		return null;
	}
}
