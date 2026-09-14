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
import com.mypage.admin.product.model.PetPlan;
import com.mypage.admin.product.model.PetRate;
import com.mypage.admin.product.model.PetRemarks;
import com.mypage.admin.product.service.PetAnimalTypeLocalServiceUtil;
import com.mypage.admin.product.service.PetPlanLocalServiceUtil;
import com.mypage.admin.product.service.PetRateLocalServiceUtil;
import com.mypage.admin.product.service.PetRemarksLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class PetDisplayContext {
	public PetDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath");
	}
	
	/**
	 * Plan Search Container
	 */
	public SearchContainer planSearchContainer() throws PortalException, PortletException {

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<PetPlan> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("petPlanId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsPlan(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	// Plan Populate Results
	private void _populateResultsPlan(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "petPlanId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("petPlanId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
		String searchRecommended = ParamUtil.getString(_httpServletRequest, "searchRecommended", "");
		String searchCustomPlan = ParamUtil.getString(_httpServletRequest, "searchCustomPlan", "");
		int _searchRecommended = searchRecommended.equals("yes") ? 1 : 0;
		int _searchCustomPlan = searchCustomPlan.equals("yes") ? 1 : 0;
		
		List entriesResults = null;
		DynamicQuery query = PetPlanLocalServiceUtil.dynamicQuery();
		
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		if (!searchRecommended.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("recommended", _searchRecommended));
		}

		if (!searchCustomPlan.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("customPlan", _searchCustomPlan));
		}

		query.add(conjunction);

		entriesResults = PetPlanLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(PetPlanLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, PetPlanLocalServiceUtil.getPetPlansCount()).size());
		} else {
			searchContainer.setTotal(PetPlanLocalServiceUtil.getPetPlansCount());
		}

		searchContainer.setResults(entriesResults);
	}
	

	// Remarks Search Container
	public SearchContainer remarksSearchContainer() throws PortalException, PortletException {

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<PetRemarks> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("petPlanId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsRemarks(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Remarks Populate Results
	private void _populateResultsRemarks(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "petRemarksId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("petPlanId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

		List entriesResults = null;
		DynamicQuery query = PetRemarksLocalServiceUtil.dynamicQuery();

		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = PetRemarksLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(PetRemarksLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, PetRemarksLocalServiceUtil.getPetRemarksCount()).size());
		} else {
			searchContainer.setTotal(PetRemarksLocalServiceUtil.getPetRemarksCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	// Animal Type Search Container
	public SearchContainer animalTypeSearchContainer() throws PortalException, PortletException {

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<PetRemarks> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("petAnimalTypeId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		try {
			_populateResultsAnimalType(entriesSearchContainer);	
		} catch (Exception e) {
			log.info("No animal type found");
			log.info(e.getMessage());
		}

		return entriesSearchContainer;
	}

	// Remarks Populate Results
	private void _populateResultsAnimalType(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "petAnimalTypeId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("petAnimalTypeId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

		List entriesResults = null;
		DynamicQuery query = PetAnimalTypeLocalServiceUtil.dynamicQuery();

		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = PetAnimalTypeLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(PetAnimalTypeLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, PetAnimalTypeLocalServiceUtil.getPetAnimalTypesCount()).size());
		} else {
			searchContainer.setTotal(PetAnimalTypeLocalServiceUtil.getPetAnimalTypesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	// Rate Search Container
	public SearchContainer rateSearchContainer() throws PortalException, PortletException {

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<PetRate> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("petRateId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsRate(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Rate Populate Results
	private void _populateResultsRate(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "petRateId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("petRateId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		long searchPlan = ParamUtil.getLong(_httpServletRequest, "searchPlan", 0);
		long searchRemarks = ParamUtil.getLong(_httpServletRequest, "searchRemarks", 0);
		String searchRatePercentage = ParamUtil.getString(_httpServletRequest, "searchRatePercentage", "");

		List entriesResults = null;
		DynamicQuery query = PetRateLocalServiceUtil.dynamicQuery();

		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (searchPlan != 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("petPlan", searchPlan));
		}

		if (searchRemarks != 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("petRemarks", searchRemarks));
		}

		if (!searchRatePercentage.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("rate", searchRatePercentage));
		}

		query.add(conjunction);

		entriesResults = PetRateLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(PetRateLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, PetRateLocalServiceUtil.getPetRatesCount()).size());
		} else {
			searchContainer.setTotal(PetRateLocalServiceUtil.getPetRatesCount());
		}

		searchContainer.setResults(entriesResults);
	}	
	
	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
		if (_getPageType().equals("plan")) {
			return "petPlanId";
		}

		if (_getPageType().equals("remarks")) {
			return "petRemarksId";
		}

		if (_getPageType().equals("rate")) {
			return "petRateId";
		}
		
		if (_getPageType().equals("animalType")) {
			return "petAnimalTypeId";
		}

		return null;
	}	
	
	/**
	 * Get page type by detect value in mvcPath param
	 */	
	private String _getPageType() {

		String defaultPageType = "plan";

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
		return defaultPageType;
	}
	
	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {

		if (_getPageType().equalsIgnoreCase("plan")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchRecommended = ParamUtil.getString(_httpServletRequest, "searchRecommended", "");
			String searchCustomPlan = ParamUtil.getString(_httpServletRequest, "searchCustomPlan", "");

			if (!searchName.isEmpty()) {
				return true;
			}

			if (!searchRecommended.isEmpty()) {
				return true;
			}

			if (!searchCustomPlan.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("remarks")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("rate")) {
			String searchPlan = ParamUtil.getString(_httpServletRequest, "searchPlan", "");
			String searchRemarks = ParamUtil.getString(_httpServletRequest, "searchRemarks", "");
			String searchRatePercentage = ParamUtil.getString(_httpServletRequest, "searchRatePercentage", "");

			if (!searchPlan.isEmpty()) {
				return true;
			}

			if (!searchRemarks.isEmpty()) {
				return true;
			}

			if (!searchRatePercentage.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("animalType")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
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

		if (_getPageType().equals("plan")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
			String searchRecommended = ParamUtil.getString(_httpServletRequest, "searchRecommended");
			String searchCustomPlan = ParamUtil.getString(_httpServletRequest, "searchCustomPlan");

			portletURL.setParameter("searchName", searchName);
			portletURL.setParameter("searchRecommended", searchRecommended);
			portletURL.setParameter("searchCustomPlan", searchCustomPlan);
		}

		if (_getPageType().equals("remarks")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

			portletURL.setParameter("searchName", searchName);
		}

		if (_getPageType().equals("rate")) {
			String searchPlan = ParamUtil.getString(_httpServletRequest, "searchPlan");
			String searchRemarks = ParamUtil.getString(_httpServletRequest, "searchRemarks");
			String searchRatePercentage = ParamUtil.getString(_httpServletRequest, "searchRatePercentage");

			portletURL.setParameter("searchPlan", searchPlan);
			portletURL.setParameter("searchRemarks", searchRemarks);
			portletURL.setParameter("searchRatePercentage", searchRatePercentage);
		}

		return portletURL;
	}	

	private static final Log log = LogFactoryUtil.getLog(PetDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;
}
