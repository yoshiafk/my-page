package com.mypage.admin.product.display.context;

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
import com.mypage.admin.product.model.SmartHealthBenefit;
import com.mypage.admin.product.model.SmartHealthBenefitGroup;
import com.mypage.admin.product.model.SmartHealthPlan;
import com.mypage.admin.product.model.SmartHealthPremi;
import com.mypage.admin.product.service.SmartHealthBenefitGroupLocalServiceUtil;
import com.mypage.admin.product.service.SmartHealthBenefitLocalServiceUtil;
import com.mypage.admin.product.service.SmartHealthPlanLocalServiceUtil;
import com.mypage.admin.product.service.SmartHealthPremiLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class SmartHealthDisplayContext {
	public SmartHealthDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/product/smarth_health/list.jsp");
	}
	
	
	public SearchContainer planSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartHealthPlan> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartHealthPlanId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);
		
		entriesSearchContainer.setIteratorURL(_iteratorURL());
		
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		_populateResultsPlan(entriesSearchContainer);
		
		return entriesSearchContainer;
	}
	
	public void _populateResultsPlan(SearchContainer<SmartHealthPlan> searchContainer) throws PortalException {
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartHealthPlanId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartHealthPlanId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

		List entriesResults = null;
		DynamicQuery query = SmartHealthPlanLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("planName", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = SmartHealthPlanLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());
		
//		System.out.println(entriesResults);

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartHealthPlanLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartHealthPlanLocalServiceUtil.getSmartHealthPlansCount())
					.size());
		} else {
			searchContainer.setTotal(SmartHealthPlanLocalServiceUtil.getSmartHealthPlansCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	// PREMI SEARCH CONTAINER
	public SearchContainer premiSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartHealthPremi> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartHealthPremiId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);
		
		entriesSearchContainer.setIteratorURL(_iteratorURL());
		
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		_populateResultsPremi(entriesSearchContainer);
		
		return entriesSearchContainer;
	}
	
	// PREMI POPULATE RESULTS
	public void _populateResultsPremi(SearchContainer<SmartHealthPremi> searchContainer) throws PortalException {
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartHealthPremiId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartHealthPremiId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		int searchAge = ParamUtil.getInteger(_httpServletRequest, "searchAge", 0);
		String searchGender = ParamUtil.getString(_httpServletRequest, "searchGender", "");
		String searchCurrency = ParamUtil.getString(_httpServletRequest, "searchCurrency", "");
		long searchAmount = ParamUtil.getLong(_httpServletRequest, "searchAmount", 0);		

		List entriesResults = null;
		DynamicQuery query = SmartHealthPremiLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (searchAge != 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("age", searchAge));
		}
		
		if(!searchGender.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("gender", searchGender));
		}
		
		if(!searchCurrency.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("currency", searchCurrency));
		}
		
		if(searchAmount != 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("amount", searchAmount));
		}

		query.add(conjunction);

		entriesResults = SmartHealthPremiLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());
		
//		System.out.println(entriesResults);

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartHealthPremiLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartHealthPremiLocalServiceUtil.getSmartHealthPremiCount())
					.size());
		} else {
			searchContainer.setTotal(SmartHealthPremiLocalServiceUtil.getSmartHealthPremiCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	
	// BENEFIT GROUP SEARCH CONTAINER
	public SearchContainer benefitGroupSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartHealthBenefitGroup> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartHealthBenefitGroupId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);
		
		entriesSearchContainer.setIteratorURL(_iteratorURL());
		
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		_populateResultsBenefitGroup(entriesSearchContainer);
		
		return entriesSearchContainer;
	}
	
	// BENEFIT GROUP POPULATE RESULTS
	public void _populateResultsBenefitGroup(SearchContainer<SmartHealthBenefitGroup> searchContainer) throws PortalException {
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartHealthBenefitGroupId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartHealthBenefitGroupId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

		List entriesResults = null;
		DynamicQuery query = SmartHealthBenefitGroupLocalServiceUtil.dynamicQuery();
		
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("groupName", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = SmartHealthBenefitGroupLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartHealthBenefitGroupLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartHealthBenefitGroupLocalServiceUtil.getSmartHealthBenefitGroupCounts())
					.size());
		} else {
			searchContainer.setTotal(SmartHealthBenefitGroupLocalServiceUtil.getSmartHealthBenefitGroupCounts());
		}

		searchContainer.setResults(entriesResults);
	}
	
	// BENEFIT SEARCH CONTAINER
	public SearchContainer benefitSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<SmartHealthBenefit> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartHealthBenefitId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBenefit(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// BENEFIT POPULATE RESULTS
	public void _populateResultsBenefit(SearchContainer<SmartHealthBenefit> searchContainer) throws PortalException {
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartHealthBenefitId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartHealthBenefitId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");

		List entriesResults = null;
		DynamicQuery query = SmartHealthBenefitLocalServiceUtil.dynamicQuery();

		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchTitle.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("benefitTitle", "%" + searchTitle + "%"));
		}

		query.add(conjunction);

		entriesResults = SmartHealthBenefitLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartHealthBenefitLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS,
					SmartHealthBenefitLocalServiceUtil.getSmartHealthBenefitCounts()).size());
		} else {
			searchContainer.setTotal(SmartHealthBenefitLocalServiceUtil.getSmartHealthBenefitCounts());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {

		if (_getPageType().equalsIgnoreCase("plan")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equals("premi")) {
			int searchAge = ParamUtil.getInteger(_httpServletRequest, "searchAge", 0);
			String searchGender = ParamUtil.getString(_httpServletRequest, "searchGender", "");
			String searchCurrency = ParamUtil.getString(_httpServletRequest, "searchCurrency", "");
			long searchAmount = ParamUtil.getLong(_httpServletRequest, "searchAmount", 0);
			
			if(searchAge != 0) {
				return true;
			}
			
			if(!searchGender.isEmpty()) {
				return true;
			}
			
			if(!searchCurrency.isEmpty()) {
				return true;
			}			
			
			if (searchAmount != 0) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("benefit_group")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("benefit")) {
			String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");

			if (!searchTitle.isEmpty()) {
				return true;
			}
		}		

		return false;
	}
	
	// Order by default
	private String _orderByColDefault() {
		if (_getPageType().equals("plan")) {
			return "smartHealthPlanId";
		}

		if (_getPageType().equals("premi")) {
			return "smartHealthPremiId";
		}
		
		if (_getPageType().equals("benefit_group")) {
			return "smartHealthBenefitGroupId";
		}
		
		if (_getPageType().equals("benefit")) {
			return "smartHealthBenefitId";
		}
		return null;
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
	
	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		String delta = ParamUtil.getString(_httpServletRequest, "delta");
		portletURL.setParameter("delta", delta);

		if (_getPageType().equals("plan")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
			portletURL.setParameter("searchName", searchName);
		}

		if (_getPageType().equals("premi")) {
			int searchAge = ParamUtil.getInteger(_httpServletRequest, "searchAge", 0);
			String searchGender = ParamUtil.getString(_httpServletRequest, "searchGender", "");
			String searchCurrency = ParamUtil.getString(_httpServletRequest, "searchCurrency", "");
			long searchAmount = ParamUtil.getLong(_httpServletRequest, "searchAmount", 0);

			portletURL.setParameter("searchAge", String.valueOf(searchAge));
			portletURL.setParameter("searchGender", searchGender);
			portletURL.setParameter("searchCurrency", searchCurrency);
			portletURL.setParameter("searchAmount", String.valueOf(searchAmount));
		}
		
		if (_getPageType().equals("benefit_group")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
			portletURL.setParameter("searchName", searchName);
		}
		
		if (_getPageType().equals("benefit")) {
			String searchTitle = ParamUtil.getString(_httpServletRequest, "searchName");
			portletURL.setParameter("searchTitle", searchTitle);
		}		

		return portletURL;
	}

	private static final Log _log = LogFactoryUtil.getLog(SmartHealthDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;

}
