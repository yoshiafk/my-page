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

public class SmartActiveManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
	public SmartActiveManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
			SearchContainer<?> searchContainer) {
		super(httpServletRequest, liferayPortletRequest, liferayPortletResponse, searchContainer);

		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = httpServletRequest;
		_mvcPath = ParamUtil.getString(liferayPortletRequest, "mvcPath");
	}
	
	// Saat checkbox diklik
	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return null;
	}
	
	// Order By Filter
	
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
	
	private DropdownItemList _getOrderBy() {
		String topro_id = "Topro ID";
		
		if (_getPageType().equals("benefit_type")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveBenefitTypeId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveBenefitTypeId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Benefit Type ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "nameId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "nameId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name (Indonesia)"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "nameEn"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "nameEn");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name (English)"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "sort"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "sort");
				dropdownItem.setLabel(LanguageUtil.get(request, "Sort"));
			});
			
			return item;
		}

		if (_getPageType().equals("benefit")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveBenefitId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveBenefitId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Benefit ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "nameId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "nameId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name (Indonesia)"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "nameEn"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "nameEn");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name (English)"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "sort"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "sort");
				dropdownItem.setLabel(LanguageUtil.get(request, "Sort"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("benefit_value")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveBenefitValueId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveBenefitValueId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Benefit Value ID"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("benefit_value_mapping")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveBenefitValueMappingId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveBenefitValueMappingId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Benefit Value Mapping ID"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("class_rate")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveClassRateId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveClassRateId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Class Rate ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "nameId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "nameId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name (Indonesia)"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "nameEn"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "nameEn");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name (English)"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("occupation")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveOccupationId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveOccupationId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Occupation ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "nameId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "nameId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name (Indonesia)"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "nameEn"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "nameEn");
				dropdownItem.setLabel(LanguageUtil.get(request, "Name (English)"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("topro")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveToproId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveToproId");
				dropdownItem.setLabel(LanguageUtil.get(request, topro_id));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "topro"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "topro");
				dropdownItem.setLabel(LanguageUtil.get(request, "Topro"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("topro_benefit_mapping")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveToproBenefitMappingId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveToproBenefitMappingId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Topro Benefit Mapping ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveToproId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveToproId");
				dropdownItem.setLabel(LanguageUtil.get(request, topro_id));
			});
			
			return item;
		}
		
		if (_getPageType().equals("premi")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActivePremiId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActivePremiId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Premi ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveToproId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveToproId");
				dropdownItem.setLabel(LanguageUtil.get(request, topro_id));
			});
			
			return item;
		}
		
		if (_getPageType().equals("feature")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveFeatureId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveFeatureId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Feature ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "title"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "title");
				dropdownItem.setLabel(LanguageUtil.get(request, "Title"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "sort"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "sort");
				dropdownItem.setLabel(LanguageUtil.get(request, "Sort"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("link")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartActiveLinkId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartActiveLinkId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Link ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "category"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "category");
				dropdownItem.setLabel(LanguageUtil.get(request, "Category"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "title"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "title");
				dropdownItem.setLabel(LanguageUtil.get(request, "Title"));
			});
			
			return item;
		}

		return null;
	}
	
	// Add / Import button
	@Override
	public CreationMenu getCreationMenu() {
		return _getImport();
	}
	
	private CreationMenu _getImport() {
		String redirect = "redirect";
		
		if (_getPageType().equals("occupation") || _getPageType().equals("topro")) {
			CreationMenu item = new CreationMenu();
			
			item.addDropdownItem(dropdownItem -> {
				dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getEditUrl(), redirect, currentURLObj.toString());
				dropdownItem.setLabel("New");
			});
			
			item.addDropdownItem(dropdownItem -> {
				dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getImportUrl(), redirect, currentURLObj.toString());
				dropdownItem.setLabel("Import");
			});

			return item;
		}
		
		if (_getPageType().equals("topro_benefit_mapping")) {
			CreationMenu item = new CreationMenu();
			
			item.addDropdownItem(dropdownItem -> {
				dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getImportUrl(), redirect, currentURLObj.toString());
				dropdownItem.setLabel("Import");
			});

			return item;
		}
		
		CreationMenu item = new CreationMenu();
		
		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getEditUrl(), redirect, currentURLObj.toString());
			dropdownItem.setLabel("New");
		});

		return item;
	}

	// Get Page Type
	private String _getPageType() {
		
		if (_mvcPath.equals("/product/smart_active/benefit_type/list.jsp")) {
			return "benefit_type";
		}
		if (_mvcPath.equals("/product/smart_active/benefit/list.jsp")) {
			return "benefit";
		}
		if (_mvcPath.equals("/product/smart_active/benefit_value/list.jsp")) {
			return "benefit_value";
		}
		if (_mvcPath.equals("/product/smart_active/benefit_value_mapping/list.jsp")) {
			return "benefit_value_mapping";
		}
		if (_mvcPath.equals("/product/smart_active/class_rate/list.jsp")) {
			return "class_rate";
		}
		if (_mvcPath.equals("/product/smart_active/occupation/list.jsp")) {
			return "occupation";
		}
		if (_mvcPath.equals("/product/smart_active/topro/list.jsp")) {
			return "topro";
		}
		if (_mvcPath.equals("/product/smart_active/topro_benefit_mapping/list.jsp")) {
			return "topro_benefit_mapping";
		}
		if (_mvcPath.equals("/product/smart_active/premi/list.jsp")) {
			return "premi";
		}
		if (_mvcPath.equals("/product/smart_active/feature/list.jsp")) {
			return "feature";
		}
		if (_mvcPath.equals("/product/smart_active/link/list.jsp")) {
			return "link";
		}
		
		return "premi";
	}

	private String _getEditUrl() {
		String editPath = null;
		
		if (_getPageType().equals("benefit_type")) {
			editPath = "/product/smart_active/benefit_type/edit.jsp";
		}
		if (_getPageType().equals("benefit")) {
			editPath = "/product/smart_active/benefit/edit.jsp";
		}
		if (_getPageType().equals("benefit_value")) {
			editPath = "/product/smart_active/benefit_value/edit.jsp";
		}
		if (_getPageType().equals("benefit_value_mapping")) {
			editPath = "/product/smart_active/benefit_value_mapping/edit.jsp";
		}
		if (_getPageType().equals("class_rate")) {
			editPath = "/product/smart_active/class_rate/edit.jsp";
		}
		if (_getPageType().equals("occupation")) {
			editPath = "/product/smart_active/occupation/edit.jsp";
		}
		if (_getPageType().equals("topro")) {
			editPath = "/product/smart_active/topro/edit.jsp";
		}
		if (_getPageType().equals("topro_benefit_mapping")) {
			editPath = "/product/smart_active/topro_benefit_mapping/edit.jsp";
		}
		if (_getPageType().equals("premi")) {
			editPath = "/product/smart_active/premi/edit.jsp";
		}
		if (_getPageType().equals("feature")) {
			editPath = "/product/smart_active/feature/edit.jsp";
		}
		if (_getPageType().equals("link")) {
			editPath = "/product/smart_active/link/edit.jsp";
		}

		return editPath;
	}

	private String _getImportUrl() {
		
		if (_getPageType().equals("benefit_type")) {
			return "/product/smart_active/benefit_type/import.jsp";
		}
		if (_getPageType().equals("benefit")) {
			return "/product/smart_active/benefit/import.jsp";
		}
		if (_getPageType().equals("benefit_value")) {
			return "/product/smart_active/benefit_value/import.jsp";
		}
		if (_getPageType().equals("benefit_value_mapping")) {
			return "/product/smart_active/benefit_value_mapping/import.jsp";
		}
		if (_getPageType().equals("class_rate")) {
			return "/product/smart_active/class_rate/import.jsp";
		}
		if (_getPageType().equals("occupation")) {
			return "/product/smart_active/occupation/import.jsp";
		}
		if (_getPageType().equals("topro")) {
			return "/product/smart_active/topro/import.jsp";
		}
		if (_getPageType().equals("topro_benefit_mapping")) {
			return "/product/smart_active/topro_benefit_mapping/import.jsp";
		}
		if (_getPageType().equals("premi")) {
			return "/product/smart_active/premi/import.jsp";
		}
		if (_getPageType().equals("feature")) {
			return "/product/smart_active/feature/import.jsp";
		}
		if (_getPageType().equals("link")) {
			return "/product/smart_active/link/import.jsp";
		}
		
		return null;
	}
	
	
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
	
	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
}
