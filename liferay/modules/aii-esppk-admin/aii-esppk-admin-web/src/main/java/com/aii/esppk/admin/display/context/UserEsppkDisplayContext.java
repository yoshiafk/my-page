package com.aii.esppk.admin.display.context;

import com.aii.esppk.admin.model.SppkUser;
import com.aii.esppk.admin.service.SppkUserLocalServiceUtil;
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

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class UserEsppkDisplayContext {
	public UserEsppkDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath");
	}
	
	public SearchContainer userEsppkSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<SppkUser> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("sppkUserId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsUserEsppk(entriesSearchContainer);
		return entriesSearchContainer;
	}
	
	private void _populateResultsUserEsppk(SearchContainer<SppkUser> searchContainer) throws PortalException {
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "sppkUserId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("sppkUserId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		
		// Advance search parameter
		String searchFullName = ParamUtil.getString(_httpServletRequest, "searchFullName", "");
		
		List<SppkUser> entriesResults = null;
		
		// Query
		DynamicQuery query = SppkUserLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchFullName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("fullName", "%" + searchFullName + "%"));
		}
		query.add(conjunction);
		
		entriesResults = SppkUserLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),searchContainer.getEnd());
		
		if (_getOnSearch()) {
			searchContainer.setTotal(SppkUserLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS, SppkUserLocalServiceUtil.getSppkUsersCount()).size());
		} else {
			searchContainer.setTotal(SppkUserLocalServiceUtil.getSppkUsersCount());
		}
		
		searchContainer.setResults(entriesResults);
	}
	
	private String _getPageType() {

		String defaultPageType = "userSppk";
		if (_mvcPath.equals("/user/list.jsp")) {
			return defaultPageType;
		}
		return defaultPageType;
	}
	
	private String _orderByColDefault() {
		if (_getPageType().equals("userSppk")) {
			return "sppkUserId";
		}

		return null;
	}
	
	public boolean _getOnSearch() {

		if (_getPageType().equalsIgnoreCase("userSppk")) {
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

		if (_getPageType().equals("userSppk")) {
			String searchFullName = ParamUtil.getString(_httpServletRequest, "searchFullName");

			portletURL.setParameter("searchFullName", searchFullName);
		}
		return portletURL;
	}

	private static final Log _log = LogFactoryUtil.getLog(UserEsppkDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;
}
