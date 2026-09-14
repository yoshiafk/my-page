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

public class PetManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
	public PetManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
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
		
		if (!_getPageType().equals("animalType")) {
			item.add(dropdownItem -> {
				dropdownItem.putData("action", "exportMultiple");
				dropdownItem.setIcon("download");
				dropdownItem.setLabel("Export Selected");
				dropdownItem.setQuickAction(true);
			});
		}
		
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
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getMvcPath(), "redirect", currentURLObj.toString());
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
		if (_mvcPath.equals("/product/pet/plan/list.jsp")) {
			return "plan";
		}
		if (_mvcPath.equals("/product/pet/remarks/list.jsp")) {
			return "remarks";
		}
		if (_mvcPath.equals("/product/pet/rate/list.jsp")) {
			return "rate";
		}
		if (_mvcPath.equals("/product/pet/animal_type/list.jsp")) {
			return "animalType";
		}
		return "plan";
	}

	private String _getEditUrl() {
		String editPath = null;

		if (_getPageType().equals("plan")) {
			editPath = "/product/pet/plan/edit.jsp";
		}
		if (_getPageType().equals("remarks")) {
			editPath = "/product/pet/remarks/edit.jsp";
		}
		if (_getPageType().equals("rate")) {
			editPath = "/product/pet/rate/edit.jsp";
		}
		if (_getPageType().equals("animalType")) {
			editPath = "/product/pet/animal_type/edit.jsp";
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

	private String _getMvcPath() {
		if (_getPageType().equals("plan")) {
			return "/product/pet/plan/import.jsp";
		}
		if (_getPageType().equals("remarks")) {
			return "/product/pet/remarks/import.jsp";
		}
		if (_getPageType().equals("rate")) {
			return "/product/pet/rate/import.jsp";
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
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "petPlanId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "petPlanId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Plan ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Plan Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("remarks")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "petRemarksId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "petRemarksId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Remarks ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Remarks Name"));
			});
			
			return item;
		}

		if (_getPageType().equals("rate")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "petRateId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "petRateId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Rate ID"));
			});
			
			return item;
		}
		
		if (_getPageType().equals("animalType")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "petAnimalTypeId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "petAnimalTypeId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Animal Type ID"));
			});
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "name"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "name");
				dropdownItem.setLabel(LanguageUtil.get(request, "Animal Type Name"));
			});
			
			return item;
		}

		return null;
	}	
	
	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
}
