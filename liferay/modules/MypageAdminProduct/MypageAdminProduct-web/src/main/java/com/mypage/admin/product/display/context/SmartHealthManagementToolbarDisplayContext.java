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

public class SmartHealthManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
	public SmartHealthManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
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
		if (_mvcPath.equals("/product/smart_health/plan/list.jsp")) {
			return "plan";
		}
		if (_mvcPath.equals("/product/smart_health/premi/list.jsp")) {
			return "premi";
		}
		
		if (_mvcPath.equals("/product/smart_health/benefit_group/list.jsp")) {
			return "benefit_group";
		}
		
		if (_mvcPath.equals("/product/smart_health/benefit/list.jsp")) {
			return "benefit";
		}
		return "plan";
	}

	private String _getEditUrl() {
		String editPath = null;

		if (_getPageType().equals("plan")) {
			editPath = "/product/smart_health/plan/edit.jsp";
		}
		if (_getPageType().equals("premi")) {
			editPath = "/product/smart_health/premi/edit.jsp";
		}
		if (_getPageType().equals("benefit_group")) {
			editPath = "/product/smart_health/benefit_group/edit.jsp";
		}
		if (_getPageType().equals("benefit")) {
			editPath = "/product/smart_health/benefit/edit.jsp";
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
		if (_getPageType().equals("plan")) {
			return "/product/smart_health/plan/import.jsp";
		}
		if (_getPageType().equals("premi")) {
			return "/product/smart_health/premi/import.jsp";
		}
		if (_getPageType().equals("benefit_group")) {
			return "/product/smart_health/benefit_group/import.jsp";
		}
		if (_getPageType().equals("benefit")) {
			return "/product/smart_health/benefit/import.jsp";
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
		if (_getPageType().equals("plan")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartHealthPlanId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartHealthPlanId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Smart Health Plan ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "planName"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "planName");
				dropdownItem.setLabel(LanguageUtil.get(request, "Plan Name"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("premi")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartHealthPremiId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartHealthPremiId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Smart Health Premi ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "age"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "age");
				dropdownItem.setLabel(LanguageUtil.get(request, "Age"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("benefit_group")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartHealthBenefitGroupId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartHealthBenefitGroupId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Benefit Group ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "groupName"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "groupName");
				dropdownItem.setLabel(LanguageUtil.get(request, "Group Name"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("benefit")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "smartHealthBenefitId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "smartHealthBenefitId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Benefit ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "benefitTitle"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "benefitTitle");
				dropdownItem.setLabel(LanguageUtil.get(request, "Benefit Title"));
			});
			
			return item;
		}		

		return null;
	}

	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
}
