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

public class MasterManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

	// Constructor
	public MasterManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
			SearchContainer<?> searchContainer) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest, searchContainer);

		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = httpServletRequest;
		_mvcPath = ParamUtil.getString(liferayPortletRequest, "mvcPath", "/master/country/list.jsp");
	}

	// Action Dropdown
	@Override
	public List<DropdownItem> getActionDropdownItems() {
		if (!_getPageType().equals("promocode")) {
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
			
			item.add(dropdownItem -> {
				String label = "Delete";
				
				dropdownItem.putData("action", "deleteItem");
				dropdownItem.setIcon("trash");
				dropdownItem.setLabel(label);
				dropdownItem.setQuickAction(true);
			});
			
			return item;
		}
		
		return null;
	}

	// Creation Menu
	@Override
	public CreationMenu getCreationMenu() {
		CreationMenu item = new CreationMenu();
		
		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getEditUrl(), "redirect", currentURLObj.toString());
			dropdownItem.setLabel("New");
		});
		
		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getImportPagePath(), "redirect", currentURLObj.toString());
			dropdownItem.setLabel("Import");
		});

		return item;
	}

	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/master/country/list.jsp")) {
			return "country";
		}
		if (_mvcPath.equals("/master/currency/list.jsp")) {
			return "currency";
		}
		if (_mvcPath.equals("/master/blacklist_customer/list.jsp")) {
			return "blacklist_customer";
		}
		if (_mvcPath.equals("/master/province/list.jsp")) {
			return "province";
		}
		if (_mvcPath.equals("/master/city/list.jsp")) {
			return "city";
		}
		if (_mvcPath.equals("/master/promocode/list.jsp")) {
			return "promocode";
		}
		if (_mvcPath.equals("/master/industry_category/list.jsp")) {
			return "industry_category";
		}
		if (_mvcPath.equals("/master/industry/list.jsp")) {
			return "industry";
		}
		if (_mvcPath.equals("/master/job_position/list.jsp")) {
			return "job_position";
		}
		if (_mvcPath.equals("/master/bank/list.jsp")) {
			return "bank";
		}
		if (_mvcPath.equals("/master/paymentchannel/list.jsp")) {
			return "paymentchannel";
		}
		if (_mvcPath.equals("/master/reference_number/list.jsp")) {
			return "referenceNumber";
		}
		if (_mvcPath.equals("/master/occupation/list.jsp")) {
			return "occupation";
		}
		if (_mvcPath.equals("/master/occupation_category/list.jsp")) {
			return "occupationCategory";
		}
		if (_mvcPath.equals("/master/company_type/list.jsp")) {
			return "company_type";
		}
		if (_mvcPath.equals("/master/branch/list.jsp")) {
			return "branch";
		}
		if (_mvcPath.equals("/master/global_variable/list.jsp")) {
			return "global_variable";
		}
		
		return "country";
	}

	// Get Edit URL
	private String _getEditUrl() {
		String editPath = null;

		if (_getPageType().equals("country")) {
			editPath = "/master/country/edit.jsp";
		}
		if (_getPageType().equals("currency")) {
			editPath = "/master/currency/edit.jsp";
		}
		if (_getPageType().equals("blacklist_customer")) {
			editPath = "/master/blacklist_customer/edit.jsp";
		}
		if (_getPageType().equals("province")) {
			editPath = "/master/province/edit.jsp";
		}
		if (_getPageType().equals("city")) {
			editPath = "/master/city/edit.jsp";
		}
		if (_getPageType().equals("promocode")) {
			editPath = "/master/promocode/edit.jsp";
		}
		if (_getPageType().equals("industry_category")) {
			editPath = "/master/industry_category/edit.jsp";
		}
		if (_getPageType().equals("industry")) {
			editPath = "/master/industry/edit.jsp";
		}
		if (_getPageType().equals("job_position")) {
			editPath = "/master/job_position/edit.jsp";
		}
		if (_getPageType().equals("bank")) {
			editPath = "/master/bank/edit.jsp";
		}
		if (_getPageType().equals("paymentchannel")) {
			editPath = "/master/paymentchannel/edit.jsp";
		}
		if (_getPageType().equals("referenceNumber")) {
			editPath = "/master/reference_number/edit.jsp";
		}
		if (_getPageType().equals("occupationCategory")) {
			editPath = "/master/occupation_category/edit.jsp";
		}
		if (_getPageType().equals("occupation")) {
			editPath = "/master/occupation/edit.jsp";
		}
		if (_getPageType().equals("company_type")) {
			editPath = "/master/company_type/edit.jsp";
		}
		if (_getPageType().equals("branch")) {
			editPath = "/master/branch/edit.jsp";
		}
		if (_getPageType().equals("global_variable")) {
			editPath = "/master/global_variable/edit.jsp";
		}
		
		return editPath;
	}

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
		if (_getPageType().equals("bank")) {
			return "/master/bank/import.jsp";
		}
		if (_getPageType().equals("paymentchannel")) {
			return "/master/paymentchannel/import.jsp";
		}
		if (_getPageType().equals("referenceNumber")) {
			return "/master/reference_number/import.jsp";
		}
		if (_getPageType().equals("occupation")) {
			return "/master/occupation/import.jsp";
		}
		if (_getPageType().equals("occupationCategory")) {
			return "/master/occupation_category/import.jsp";
		}
		if (_getPageType().equals("company_type")) {
			return "/master/company_type/import.jsp";
		}
		if (_getPageType().equals("branch")) {
			return "/master/branch/import.jsp";
		}
		
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
		if (_getPageType().equals("country")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "countryId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "countryId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Country ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Country Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("currency")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Currency Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("blacklist_customer")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "blacklistCustomerId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "blacklistCustomerId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Blacklist Customer ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "fullName"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "fullName");
				dropdownItem.setLabel(LanguageUtil.get(request, "Full Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("province")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "masterProvinceId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "masterProvinceId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Province ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Province Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("city")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "masterCityId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "masterCityId");
				dropdownItem.setLabel(LanguageUtil.get(request, "City ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "City Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("promocode")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "promoCodeId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "promoCodeId");
				dropdownItem.setLabel("Promocode ID");
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "promoCode"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "promoCode");
				dropdownItem.setLabel("Promocode");
			});
			
			return item;
		}

		if (_getPageType().equals("industry_category")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "industryCategoryId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "industryCategoryId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Industry Category ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("industry")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "industryId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "industryId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Industry ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("job_position")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "jobPositionId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "jobPositionId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Job Position ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("bank")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "masterBankId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "masterBankId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Bank ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Bank Name"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "order"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "order");
				dropdownItem.setLabel(LanguageUtil.get(request, "Order"));
			});
			
			return item;
		}

		if (_getPageType().equals("paymentchannel")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "paymentChannelId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "paymentChannelId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Payment Channel ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "code"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "code");
				dropdownItem.setLabel(LanguageUtil.get(request, "Code"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("referenceNumber")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "referenceNumberId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "referenceNumberId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Reference NumberId ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "type"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "type");
				dropdownItem.setLabel(LanguageUtil.get(request, "Type"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "productCode"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "productCode");
				dropdownItem.setLabel(LanguageUtil.get(request, "Product Code"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("occupationCategory")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "masterOccupationCategoryId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "masterOccupationCategoryId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Occupation Category ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("occupation")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "masterOccupationId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "masterOccupationId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Occupation ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("company_type")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "companyTypeId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "companyTypeId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Company Type ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("branch")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "masterBranchId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "masterBranchId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Branch ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("global_variable")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "masterGlobalVariableId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "masterGlobalVariableId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Global Variable ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "group"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "group");
				dropdownItem.setLabel(LanguageUtil.get(request, "Group"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name"));
			});
			
			return item;
		}
		
		return null;
	}

	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
}
