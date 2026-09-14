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

public class InternationalTravelManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

	public InternationalTravelManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
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

	// Order By Filter
	@Override
	public List<DropdownItem> getOrderByDropdownItems() {
		return _getOrderBy();
	}

	private DropdownItemList _getOrderBy() {
		if (_getPageType().equals("premi")) {
			DropdownItemList item = new DropdownItemList();
			
			item.add(dropdownItem -> {
				dropdownItem.setActive(Objects.equals(getOrderByCol(), "premiId"));
				dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "premiId");
				dropdownItem.setLabel(LanguageUtil.get(request, "Premi ID"));
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
		if (_mvcPath.equals("/product/international_travel/premi/list.jsp")) {
			return "premi";
		}
		return "premi";
	}

	private String _getEditUrl() {
		String editPath = null;

		if (_getPageType().equals("premi")) {
			editPath = "/product/international_travel/premi/edit.jsp";
		}

		return editPath;
	}

	private String _getImportUrl() {
		if (_getPageType().equals("premi")) {
			return "/product/international_travel/premi/import.jsp";
		}
		return null;
	}

	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;

}
