package com.mypage.user.display.context;

import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mypage.user.model.UserRegistration;
import com.mypage.user.service.UserRegistrationLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class UserRegistrationDisplayContext {
	public UserRegistrationDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath");
	}

	/**
	 * User Registration Search Container
	 */
	public SearchContainer userRegistrationSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<UserRegistration> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = orderByCol != "userRegistrationId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsUserRegistration(entriesSearchContainer);
		return entriesSearchContainer;
	}

	// Populate Results User Registration
	private void _populateResultsUserRegistration(SearchContainer<UserRegistration> searchContainer) throws PortalException {
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "userRegistrationId");
		String ascOrDesc = orderByCol != "userRegistrationId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");

		// Advance search parameter
		String searchFullName = ParamUtil.getString(_httpServletRequest, "searchFullName", "");

		List<UserRegistration> entriesResults = null;

		// Query
		DynamicQuery query = UserRegistrationLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchFullName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchFullName + "%"));
		}
		query.add(conjunction);

		entriesResults = UserRegistrationLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(UserRegistrationLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS,
					UserRegistrationLocalServiceUtil.getUserRegistrationsCount()).size());
		} else {
			searchContainer.setTotal(UserRegistrationLocalServiceUtil.getUserRegistrationsCount());
		}

		// Set result to search container
		searchContainer.setResults(entriesResults);
	}

	/**
	 * Get page type by detect value in mvcPath param
	 */
	private String _getPageType() {

		String defaultPageType = "userRegistration";

		if (_mvcPath.equals("/user_registration/list.jsp")) {
			return "userRegistration";
		}
		return defaultPageType;
	}

	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
		if (_getPageType().equals("userRegistration")) {
			return "userRegistrationId";
		}

		return null;
	}

	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {

		if (_getPageType() == "userRegistration") {
			String searchFullName = ParamUtil.getString(_httpServletRequest, "searchFullName", "");

			if (!searchFullName.isEmpty()) {
				return true;
			}
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		String delta = ParamUtil.getString(_httpServletRequest, "delta");
		portletURL.setParameter("delta", delta);

		if (_getPageType().equals("userRegistration")) {
			String searchFullName = ParamUtil.getString(_httpServletRequest, "searchFullName");

			portletURL.setParameter("searchFullName", searchFullName);
		}
		return portletURL;
	}

	private static final Log _log = LogFactoryUtil.getLog(UserRegistrationDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;

}
