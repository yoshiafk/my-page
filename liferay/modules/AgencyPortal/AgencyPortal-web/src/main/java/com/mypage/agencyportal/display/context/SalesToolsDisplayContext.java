package com.mypage.agencyportal.display.context;

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
import com.mypage.agencyportal.model.AgentCategorySalesTools;
import com.mypage.agencyportal.model.AgentSalesTools;
import com.mypage.agencyportal.service.AgentCategorySalesToolsLocalServiceUtil;
import com.mypage.agencyportal.service.AgentSalesToolsLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class SalesToolsDisplayContext {
	public SalesToolsDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/salestools/master/salestools/list.jsp");
	}

	/**
	 * Sales Tools Search Container
	 */
	public SearchContainer salesToolsSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<AgentSalesTools> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		//String ascOrDesc = orderByCol != "agentSalesToolsId" ? "asc" : "desc";
		String ascOrDesc = "agentSalesToolsId".equalsIgnoreCase(orderByCol)==false ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsSalesTools(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Sales Tools Populate Results
	private void _populateResultsSalesTools(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "agentSalesToolsId");
		//String ascOrDesc = orderByCol != "agentSalesToolsId" ? "asc" : "desc";
		String ascOrDesc = "agentSalesToolsId".equalsIgnoreCase(orderByCol)==false ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");
		String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory", "");

		List entriesResults = null;
		DynamicQuery query = AgentSalesToolsLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchTitle.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("title", "%" + searchTitle + "%"));
		}
		
		if (!searchCategory.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("category", "%" + searchCategory + "%"));
		}

		query.add(conjunction);

		entriesResults = AgentSalesToolsLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(AgentSalesToolsLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, AgentSalesToolsLocalServiceUtil.getAgentSalesToolsesCount())
					.size());
		} else {
			searchContainer.setTotal(AgentSalesToolsLocalServiceUtil.getAgentSalesToolsesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Category Sales Tools Search Container
	 */
	public SearchContainer categorySalesToolsSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<AgentCategorySalesTools> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		//String ascOrDesc = orderByCol != "agentCategorySalesToolsId" ? "asc" : "desc";
		String ascOrDesc = "agentCategorySalesToolsId".equalsIgnoreCase(orderByCol)==false ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsCategorySalesTools(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Category Sales Tools Populate Results
	private void _populateResultsCategorySalesTools(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "agentCategorySalesToolsId");
		
		//String ascOrDesc = orderByCol != "agentCategorySalesToolsId" ? "asc" : "desc";
		String ascOrDesc = "agentCategorySalesToolsId".equalsIgnoreCase(orderByCol)==false ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory", "");

		List entriesResults = null;
		DynamicQuery query = AgentCategorySalesToolsLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchCategory.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("category", "%" + searchCategory + "%"));
		}

		query.add(conjunction);

		entriesResults = AgentCategorySalesToolsLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(AgentCategorySalesToolsLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, AgentCategorySalesToolsLocalServiceUtil.getAgentCategorySalesToolsesCount())
					.size());
		} else {
			searchContainer.setTotal(AgentCategorySalesToolsLocalServiceUtil.getAgentCategorySalesToolsesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/salestools/master/salestools/list.jsp")) {
			return "sales_tools";
		}
		if (_mvcPath.equals("/salestools/master/category/list.jsp")) {
			return "category";
		}
		return "sales_tools";
	}

	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {

		//if (_getPageType() == "sales_tools") {
		if ("sales_tools".equalsIgnoreCase(_getPageType())) {
			String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");
			String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory", "");

			if (!searchTitle.isEmpty()) {
				return true;
			}

			if (!searchCategory.isEmpty()) {
				return true;
			}
		}
		
		//if (_getPageType() == "category") {
		if ("category".equalsIgnoreCase(_getPageType())) {
			String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory", "");

			if (!searchCategory.isEmpty()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
		if (_getPageType().equals("sales_tools")) {
			return "agentSalesToolsId";
		}
		
		if (_getPageType().equals("category")) {
			return "agentCategorySalesToolsId";
		}
		
		return null;
	}

	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		String delta = ParamUtil.getString(_httpServletRequest, "delta");
		portletURL.setParameter("delta", delta);

		if (_getPageType().equals("sales_tools")) {
			String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle");
			String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory");

			portletURL.setParameter("searchTitle", searchTitle);
			portletURL.setParameter("searchCategory", searchCategory);
		}
		
		if (_getPageType().equals("category")) {
			String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory");

			portletURL.setParameter("searchCategory", searchCategory);
		}

		return portletURL;
	}

	private static final Log _log = LogFactoryUtil.getLog(SalesToolsDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;
}
