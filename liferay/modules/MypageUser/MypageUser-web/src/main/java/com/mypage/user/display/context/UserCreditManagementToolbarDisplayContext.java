package com.mypage.user.display.context;

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

public class UserCreditManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
	public UserCreditManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
			SearchContainer<?> searchContainer) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest, searchContainer);

		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = httpServletRequest;
		_mvcPath = ParamUtil.getString(liferayPortletRequest, "mvcPath", "/user_credit/credit_type/list.jsp");
	}

	// Action Dropdown
	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return new DropdownItemList() {
			{
//				add(dropdownItem -> {
//					dropdownItem.putData("action", "exportMultiple");
//					dropdownItem.setIcon("download");
//					dropdownItem.setLabel("Export Selected");
//					dropdownItem.setQuickAction(true);
//				});
				add(dropdownItem -> {
					String label = "Publish";

					dropdownItem.putData("action", "publish");
					dropdownItem.setIcon("disk");
					dropdownItem.setLabel(label);
					dropdownItem.setQuickAction(true);
				});
				add(dropdownItem -> {
					String label = "Unpublish";

					dropdownItem.putData("action", "unpublish");
					dropdownItem.setIcon("times");
					dropdownItem.setLabel(label);
					dropdownItem.setQuickAction(true);
				});
				add(dropdownItem -> {
					String label = "Delete";

					dropdownItem.putData("action", "deleteItem");
					dropdownItem.setIcon("trash");
					dropdownItem.setLabel(label);
					dropdownItem.setQuickAction(true);
				});
			}
		};
	}

	// Creation Menu
	@Override
	public CreationMenu getCreationMenu() {
		return new CreationMenu() {
			{
				addDropdownItem(dropdownItem -> {
					dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getAddUrl(), "redirect",
							currentURLObj.toString());
					dropdownItem.setLabel("New");
				});
				addDropdownItem(dropdownItem -> {
					dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcPath", _getImportPagePath(),
							"redirect", currentURLObj.toString());
					dropdownItem.setLabel("Import");
				});
			}
		};
	}

	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/user_credit/credit_type/list.jsp")) {
			return "creditType";
		}
		if (_mvcPath.equals("/user_credit/credit_wallet/list.jsp")) {
			return "creditWallet";
		}
		
		return "creditType";
	}
	
	// Get Edit URL
	private String _getAddUrl() {
		String addPath = null;

		if (_getPageType().equals("creditType")) {
			addPath = "/user_credit/credit_type/edit.jsp";
		}
		if (_getPageType().equals("creditWallet")) {
			addPath = "/user_credit/credit_wallet/edit.jsp";
		}
		
		return addPath;
	}

	// Get Edit URL
	private String _getEditUrl() {
		String editPath = null;

		if (_getPageType().equals("creditType")) {
			editPath = "/user_credit/credit_type/edit.jsp";
		}
		if (_getPageType().equals("creditWallet")) {
			editPath = "/user_credit/credit_wallet/edit.jsp";
		}
		
		return editPath;
	}

	// Get Import Page Path
	private String _getImportPagePath() {
		if (_getPageType().equals("creditType")) {
			return "/user_credit/credit_type/import.jsp";
		}
		if (_getPageType().equals("creditWallet")) {
			return "/user_credit/credit_wallet/import.jsp";
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
		if (_getPageType().equals("creditType")) {
			return new DropdownItemList() {
				{
					add(dropdownItem -> {
						dropdownItem.setActive(Objects.equals(getOrderByCol(), "creditTypeId"));
						dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "creditTypeId");
						dropdownItem.setLabel(LanguageUtil.get(request, "Credit Type ID"));
					});
				}
			};
		}
		if (_getPageType().equals("creditWallet")) {
			return new DropdownItemList() {
				{
					add(dropdownItem -> {
						dropdownItem.setActive(Objects.equals(getOrderByCol(), "creditWalletId"));
						dropdownItem.setHref(_getCurrentSortingURL(), "orderByCol", "creditWalletId");
						dropdownItem.setLabel(LanguageUtil.get(request, "Credit Wallet ID"));
					});
				}
			};
		}

		return null;
	}

	private final ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private String _mvcPath;
}
