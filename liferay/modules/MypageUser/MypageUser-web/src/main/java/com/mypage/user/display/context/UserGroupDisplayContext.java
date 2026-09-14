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
import com.mypage.user.model.MypageUserGroup;
import com.mypage.user.service.MypageUserGroupLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class UserGroupDisplayContext {
	public UserGroupDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/user_group/list.jsp");
	}
	
	/**
	 * User Group Search Container
	 */
	public SearchContainer userGroupSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MypageUserGroup> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = orderByCol != "mypageUserGroupId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsUserGroup(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// User Group Populate Results
	private void _populateResultsUserGroup(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "mypageUserGroupId");
		String ascOrDesc = orderByCol != "mypageUserGroupId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

		List entriesResults = null;
		DynamicQuery query = MypageUserGroupLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = MypageUserGroupLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MypageUserGroupLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MypageUserGroupLocalServiceUtil.getMypageUserGroupsCount())
					.size());
		} else {
			searchContainer.setTotal(MypageUserGroupLocalServiceUtil.getMypageUserGroupsCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/user_group/list.jsp")) {
			return "user_group";
		}
		return "user_group";
	}

	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {
		
		if (_getPageType() == "user_group") {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
		
		if (_getPageType().equals("user_group")) {
			return "mypageUserGroupId";
		}
		
		return null;
	}

	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		String delta = ParamUtil.getString(_httpServletRequest, "delta");
		portletURL.setParameter("delta", delta);
		
		if (_getPageType().equals("user_group")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

			portletURL.setParameter("searchName", searchName);
		}

		return portletURL;
	}

	private static final Log _log = LogFactoryUtil.getLog(UserRoleDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;
}
