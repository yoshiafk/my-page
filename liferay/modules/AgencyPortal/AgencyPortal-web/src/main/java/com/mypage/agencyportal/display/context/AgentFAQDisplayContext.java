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
import com.mypage.agencyportal.model.AgentFAQ;
import com.mypage.agencyportal.model.AgentFAQCategory;
import com.mypage.agencyportal.service.AgentFAQCategoryLocalServiceUtil;
import com.mypage.agencyportal.service.AgentFAQLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class AgentFAQDisplayContext {
	public AgentFAQDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/faq/master/faq/list.jsp");
	}

	/**
	 * FAQ Search Container
	 */
	public SearchContainer faqSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<AgentFAQ> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		//String ascOrDesc = orderByCol != "agentFaqId" ? "asc" : "desc";
		String ascOrDesc = !"agentFaqId".equals(orderByCol) ? "asc" : "desc";

		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsAgentFaq(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// FAQ Populate Results
	private void _populateResultsAgentFaq(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "agentFaqId");
		//String ascOrDesc = orderByCol != "agentFaqId" ? "asc" : "desc";
		String ascOrDesc = !"agentFaqId".equals(orderByCol) ? "asc" : "desc";

		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");
		String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory", "");

		List entriesResults = null;
		DynamicQuery query = AgentFAQLocalServiceUtil.dynamicQuery();
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

		entriesResults = AgentFAQLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(AgentFAQLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, AgentFAQLocalServiceUtil.getAgentFAQsCount())
					.size());
		} else {
			searchContainer.setTotal(AgentFAQLocalServiceUtil.getAgentFAQsCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Category FAQ Search Container
	 */
	public SearchContainer faqCategorySearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<AgentFAQCategory> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		//String ascOrDesc = orderByCol != "agentFaqCategoryId" ? "asc" : "desc";
		String ascOrDesc = !"agentFaqCategoryId".equals(orderByCol) ? "asc" : "desc";

		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsFaqCategory(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Category FAQ Populate Results
	private void _populateResultsFaqCategory(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "agentFaqCategoryId");
		//String ascOrDesc = orderByCol != "agentFaqCategoryId" ? "asc" : "desc";
		String ascOrDesc = !"agentFaqCategoryId".equals(orderByCol) ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory", "");

		List entriesResults = null;
		DynamicQuery query = AgentFAQCategoryLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchCategory.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("category", "%" + searchCategory + "%"));
		}

		query.add(conjunction);

		entriesResults = AgentFAQCategoryLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(AgentFAQCategoryLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, AgentFAQCategoryLocalServiceUtil.getAgentFAQCategoriesCount())
					.size());
		} else {
			searchContainer.setTotal(AgentFAQCategoryLocalServiceUtil.getAgentFAQCategoriesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/faq/master/faq/list.jsp")) {
			return "faq";
		}
		if (_mvcPath.equals("/faq/master/category/list.jsp")) {
			return "category";
		}
		return "faq";
	}

	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {
		//if (_getPageType() == "faq") {
		if ("faq".equals(_getPageType())) {
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
		if ("category".equals(_getPageType())) {
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
		if (_getPageType().equals("faq")) {
			return "agentFaqId";
		}
		
		if (_getPageType().equals("category")) {
			return "agentFaqCategoryId";
		}
		
		return null;
	}

	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		String delta = ParamUtil.getString(_httpServletRequest, "delta");
		portletURL.setParameter("delta", delta);

		if (_getPageType().equals("faq")) {
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

	private static final Log _log = LogFactoryUtil.getLog(AgentFAQDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;
}
