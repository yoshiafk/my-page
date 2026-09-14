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

public class InternationalTravelStandardNewManagementToolbarDisplayContext
		extends SearchContainerManagementToolbarDisplayContext {
	public InternationalTravelStandardNewManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
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
		DropdownItemList item = new DropdownItemList();
		
		item.add(dropdownItem -> {
			dropdownItem.putData("action", "exportMultiple");
			dropdownItem.setIcon("download");
			dropdownItem.setLabel("Export Selected");
			dropdownItem.setQuickAction(true);
		});
		
		return item;
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
//		if (_getPageType().equals("premi")) {
//			return new DropdownItemList() {
//				{
//					add(dropdownItem -> {
//						dropdownItem.setActive(Objects.equals(getOrderByCol(), "intTravelStandardNewPremiId"));
//						dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "intTravelStandardNewPremiId");
//						dropdownItem.setLabel(LanguageUtil.get(request, "Premi ID"));
//					});
//				}
//			};
//		}
		
		if (_getPageType().equals("benefit_type")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "benefitTypeId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "benefitTypeId");
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
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "benefitId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "benefitId");
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
		
		if (_getPageType().equals("plan")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartTravelIntPlanId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartTravelIntPlanId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Plan ID"));
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
		
		if (_getPageType().equals("premi")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "premiId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "premiId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Premi ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "travellerType"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "travellerType");
				dropdownItem.setLabel(LanguageUtil.get(request, "Traveller Type"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "basic"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "basic");
				dropdownItem.setLabel(LanguageUtil.get(request, "Basic"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "additional"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "additional");
				dropdownItem.setLabel(LanguageUtil.get(request, "Additional"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "annual"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "annual");
				dropdownItem.setLabel(LanguageUtil.get(request, "Annual"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("benefit_value_mapping")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "benefitValueMappingId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "benefitValueMappingId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Benefit Value Mapping ID"));
			});
			
			return item;
		}

		return null;
	}

	// Add / Import button
	@Override
	public CreationMenu getCreationMenu() {
		CreationMenu item = new CreationMenu();
		
		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getEditUrl(), "redirect", currentURLObj.toString());
			dropdownItem.setLabel("New");
		});
		
		item.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getImportUrl(), "redirect", currentURLObj.toString());
			dropdownItem.setLabel("Import");
		});

		return item;
	}

	// Get Page Type
	private String _getPageType() {
		
		if (_mvcPath.equals("/product/international_travel_standard_new/benefit_type/list.jsp")) {
			return "benefit_type";
		}
		if (_mvcPath.equals("/product/international_travel_standard_new/benefit/list.jsp")) {
			return "benefit";
		}
		
		if (_mvcPath.equals("/product/international_travel_standard_new/plan/list.jsp")) {
			return "plan";
		}
		if (_mvcPath.equals("/product/international_travel_standard_new/premi2/list.jsp")) {
			return "premi";
		}
		if (_mvcPath.equals("/product/international_travel_standard_new/benefit_value_mapping/list.jsp")) {
			return "benefit_value_mapping";
		}
		if (_mvcPath.equals("/product/international_travel_standard_new/link/list.jsp")) {
			return "link";
		}
		
//		if (_mvcPath.equals("/product/international_travel_standard_new/premi/list.jsp")) {
//			return "premi";
//		}
		
		return "premi";
	}

	private String _getEditUrl() {
		String editPath = null;
		
		if (_getPageType().equals("benefit_type")) {
			editPath = "/product/international_travel_standard_new/benefit_type/edit.jsp";
		}
		if (_getPageType().equals("benefit")) {
			editPath = "/product/international_travel_standard_new/benefit/edit.jsp";
		}
		
		if (_getPageType().equals("plan")) {
			editPath = "/product/international_travel_standard_new/plan/edit.jsp";
		}
		if (_getPageType().equals("premi")) {
			editPath = "/product/international_travel_standard_new/premi2/edit.jsp";
		}
		if (_getPageType().equals("benefit_value_mapping")) {
			editPath = "/product/international_travel_standard_new/benefit_value_mapping/edit.jsp";
		}
		if (_getPageType().equals("link")) {
			editPath = "/product/international_travel_standard_new/link/edit.jsp";
		}

//		if (_getPageType().equals("premi")) {
//			editPath = "/product/international_travel_standard_new/premi/edit.jsp";
//		}

		return editPath;
	}

	private String _getImportUrl() {
		
		if (_getPageType().equals("benefit_type")) {
			return "/product/international_travel_standard_new/benefit_type/import.jsp";
		}
		if (_getPageType().equals("benefit")) {
			return "/product/international_travel_standard_new/benefit/import.jsp";
		}
		
		if (_getPageType().equals("plan")) {
			return "/product/international_travel_standard_new/plan/import.jsp";
		}
		if (_getPageType().equals("premi")) {
			return "/product/international_travel_standard_new/premi2/import.jsp";
		}
		if (_getPageType().equals("benefit_value_mapping")) {
			return "/product/international_travel_standard_new/benefit_value_mapping/import.jsp";
		}
		if (_getPageType().equals("link")) {
			return "/product/international_travel_standard_new/link/import.jsp";
		}
		
//		if (_getPageType().equals("premi")) {
//			return "/product/international_travel_standard_new/premi/import.jsp";
//		}
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
