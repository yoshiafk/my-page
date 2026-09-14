package com.mypage.admin.product.display.context;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.petra.string.StringPool;
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
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.model.BenefitValueMapping;
import com.mypage.admin.product.model.Plan;
import com.mypage.admin.product.model.Premi;
import com.mypage.admin.product.service.BenefitLocalServiceUtil;
import com.mypage.admin.product.service.BenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.BenefitValueMappingLocalServiceUtil;
import com.mypage.admin.product.service.PremiLocalServiceUtil;
import com.mypage.admin.product.service.SmartTravelIntLinkLocalServiceUtil;
import com.mypage.admin.product.service.SmartTravelIntPlanLocalServiceUtil;

import java.io.FileReader;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class InternationalTravelStandardNewDisplayContext {
	public InternationalTravelStandardNewDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath");
	}

//	public SearchContainer<IntTravelStandardNewPremi> premiSearchContainer() throws PortalException, PortletException {
//		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
//		portletURL.setParameter("mvcPath", _mvcPath);
//
//		SearchContainer<IntTravelStandardNewPremi> entriesSearchContainer = new SearchContainer<>(
//				_liferayPortletRequest, PortletURLUtil.clone(portletURL, _liferayPortletResponse), null,
//				"No Premi were found");
//
//		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
//
//		entriesSearchContainer.setTotal(IntTravelStandardNewPremiLocalServiceUtil.getPremisCount());
//
//		DynamicQuery _query = IntTravelStandardNewPremiLocalServiceUtil.dynamicQuery();
//		List<IntTravelStandardNewPremi> _result = null;
//
//		_result = IntTravelStandardNewPremiLocalServiceUtil.dynamicQuery(_query, entriesSearchContainer.getStart(),
//				entriesSearchContainer.getEnd());
//
//		entriesSearchContainer.setResults(_result);
//
//		return entriesSearchContainer;
//	}
	
	
	
	
/* SMARTTRAVEL INTERNATIONAL */
	
	/* benefit type search container */
	public SearchContainer benefitTypeSearchContainer() throws PortalException, PortletException{
		
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<BenefitType> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "benefitTypeId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		//String ascOrDesc = orderByCol != "benefitTypeId" ? "asc" : "desc";
		String ascOrDesc = !orderByCol.equalsIgnoreCase("benefitTypeId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		//entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		_populateResultsBenefitType(entriesSearchContainer);
		
		return entriesSearchContainer;

	}
	
	/* benefit type populate results */
	private void _populateResultsBenefitType(SearchContainer searchContainer) throws PortalException{
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "benefitTypeId");
		
		//String ascOrDesc = orderByCol != "benefitTypeId" ? "asc" : "desc";
		String ascOrDesc = !orderByCol.equalsIgnoreCase("benefitTypeId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
		String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn");
		
		List entriesResults = null;
		
		DynamicQuery query = BenefitTypeLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));
		
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("nameId", "%" + searchName + "%"));
		}
		if (!searchNameEn.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("nameEn", "%" + searchNameEn + "%"));
		}
		
		query.add(conjunction);
		
		entriesResults = BenefitTypeLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());
		
		
		if (_getOnSearch()) {
			searchContainer.setTotal(BenefitTypeLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, BenefitTypeLocalServiceUtil.getBenefitTypeCount())
					.size());
		} else {
			searchContainer.setTotal(BenefitTypeLocalServiceUtil.getBenefitTypeCount());
		}

		searchContainer.setResults(entriesResults);
		
	}
	
	/* benefit search container */
	public SearchContainer benefitSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<Benefit> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "benefitId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		//String ascOrDesc = orderByCol != "benefitId" ? "asc" : "desc";
		String ascOrDesc = !orderByCol.equalsIgnoreCase("benefitId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		//entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBenefit(entriesSearchContainer);

		return entriesSearchContainer;
	
	}
	
	/* benefit populate results */
	private void _populateResultsBenefit(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "benefitId");
		//String ascOrDesc = orderByCol != "benefitId" ? "asc" : "desc";
		String ascOrDesc = !orderByCol.equalsIgnoreCase("benefitId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
		String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn");
		long typeId = ParamUtil.getInteger(_httpServletRequest, "searchBenefitType");
		
		
		List entriesResults = null;
		DynamicQuery query = BenefitLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("nameId", "%" + searchName + "%"));
		}
		
		if (!searchNameEn.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("nameEn", "%" + searchNameEn + "%"));
		}
		
		if (typeId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("benefitTypeId", typeId));
		}
		
		query.add(conjunction);
		
		entriesResults = BenefitLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(BenefitLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, BenefitLocalServiceUtil.getBenefitCount()).size());
		} else {
			searchContainer.setTotal(BenefitLocalServiceUtil.getBenefitCount());
		}

		searchContainer.setResults(entriesResults);

	}
	
	/* benefit value mapping search container */
	public SearchContainer benefitValueMappingSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<BenefitValueMapping> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "benefitId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		//String ascOrDesc = orderByCol != "benefitId" ? "asc" : "desc";
		String ascOrDesc = !orderByCol.equalsIgnoreCase("benefitValueMappingId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		//entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBenefitValueMapping(entriesSearchContainer);

		return entriesSearchContainer;
	
	}
	
	/* benefit populate results */
	private void _populateResultsBenefitValueMapping(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "benefitValueMappingId");
		//String ascOrDesc = orderByCol != "benefitId" ? "asc" : "desc";
		String ascOrDesc = !orderByCol.equalsIgnoreCase("benefitValueMappingId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
//		String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn");
//		long typeId = ParamUtil.getInteger(_httpServletRequest, "searchBenefitType");
		
		long searchBenefitType = ParamUtil.getLong(_httpServletRequest, "searchBenefitType", 0);
		long searchBenefitName = ParamUtil.getLong(_httpServletRequest, "searchBenefitName", 0);
		
		
		
		List entriesResults = null;
		DynamicQuery query = BenefitValueMappingLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if(searchBenefitType > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("benefitTypeId", searchBenefitType));
		}
		
		if(searchBenefitName > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("benefitId", searchBenefitName));
		}
		
		

//		if (!searchBenefitType.isEmpty()) {
//			conjunction.add(RestrictionsFactoryUtil.ilike("nameId", "%" + searchName + "%"));
//		}
//		
//		if (!searchNameEn.isEmpty()) {
//			conjunction.add(RestrictionsFactoryUtil.ilike("nameEn", "%" + searchNameEn + "%"));
//		}
//		
//		if (typeId > 0) {
//			conjunction.add(RestrictionsFactoryUtil.eq("benefitTypeId", typeId));
//		}
		
		query.add(conjunction);
		
		entriesResults = BenefitValueMappingLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(BenefitLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, BenefitValueMappingLocalServiceUtil.getBenefitValueMappingCount()).size());
		} else {
			searchContainer.setTotal(BenefitValueMappingLocalServiceUtil.getBenefitValueMappingCount());
		}

		searchContainer.setResults(entriesResults);

	}
	
	//HERE PLAN PREMI
	
	/* plan search container */
	public SearchContainer planSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<Plan> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "planId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartTravelIntPlanId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		//entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsPlan(entriesSearchContainer);

		return entriesSearchContainer;
	
	}
	
	/* plan populate results */
	private void _populateResultsPlan(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartTravelIntPlanId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartTravelIntPlanId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
		String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn");
		
		
		List entriesResults = null;
		DynamicQuery query = SmartTravelIntPlanLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("nameId", "%" + searchName + "%"));
		}
		
		if (!searchNameEn.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("nameEn", "%" + searchNameEn + "%"));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartTravelIntPlanLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartTravelIntPlanLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartTravelIntPlanLocalServiceUtil.getPlanCount()).size());
		} else {
			searchContainer.setTotal(SmartTravelIntPlanLocalServiceUtil.getPlanCount());
		}

		searchContainer.setResults(entriesResults);

	}
	
	/* premi search container */
	public SearchContainer premiSearchContainer2() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<Premi> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "premiId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("planId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		//entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsPremi(entriesSearchContainer);

		return entriesSearchContainer;
	
	}
	
	/* premi populate results */
	private void _populateResultsPremi(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "premiId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("premiId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchTravellerType = ParamUtil.getString(_httpServletRequest, "searchTravellerType");
		long benefitId = ParamUtil.getInteger(_httpServletRequest, "searchBenefit");
		long planId = ParamUtil.getInteger(_httpServletRequest, "searchPlan");
		
		
		List entriesResults = null;
		DynamicQuery query = PremiLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchTravellerType.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("travellerType", "%" + searchTravellerType + "%"));
		}
		
		if (benefitId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("benefitId", benefitId));
		}
		
		if (planId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("planId", planId));
		}
		
		query.add(conjunction);
		
		entriesResults = PremiLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(PremiLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, PremiLocalServiceUtil.getPremiCount()).size());
		} else {
			searchContainer.setTotal(PremiLocalServiceUtil.getPremiCount());
		}

		searchContainer.setResults(entriesResults);

	}
	
	/* link search container */
	public SearchContainer linkSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<Premi> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest, PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartTravelIntLinkId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartTravelIntLinkId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		//entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsLink(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	private void _populateResultsLink(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartTravelIntLinkId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartTravelIntLinkId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		List entriesResults = null;
		DynamicQuery query = SmartTravelIntLinkLocalServiceUtil.dynamicQuery();
		query.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));
		
		entriesResults = SmartTravelIntLinkLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartTravelIntLinkLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartTravelIntLinkLocalServiceUtil.getLinksCount()).size());
		} else {
			searchContainer.setTotal(SmartTravelIntLinkLocalServiceUtil.getLinksCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* END SMARTTRAVEL INTERNATIONAL */

	// Get Page Type
		private String _getPageType() {
			if (_mvcPath.equals("/product/international_travel_standard_new/benefit_type/list.jsp")) {
				return "benefit_type";
			}
			if (_mvcPath.equals("/product/international_travel_standard_new/benefit/list.jsp")) {
				return "benefit";
			}
			
			if (_mvcPath.equals("/product/international_travel_standard_new/plan/list.jsp")) {
				return "plan";
			}
			if (_mvcPath.equals("/product/international_travel_standard_new/premi2/list.jsp")) {
				return "premi";
			}
			if (_mvcPath.equals("/product/international_travel_standard_new/link/list.jsp")) {
				return "link";
			}
			
			return "premi";
		}
	
	
	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {

		if (_getPageType().equalsIgnoreCase( "benefit_type")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn", "");
			
			if (!searchName.isEmpty()) {
				return true;
			}
			if (!searchNameEn.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase( "benefit")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn", "");
			long typeId = ParamUtil.getInteger(_httpServletRequest, "searchBenefitType", 0);
			
			if (!searchName.isEmpty()) {
				return true;
			}
			if (!searchNameEn.isEmpty()) {
				return true;
			}
			if (typeId > 0) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase( "plan")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn", "");
			
			
			if (!searchName.isEmpty()) {
				return true;
			}
			if (!searchNameEn.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase( "premi")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchTravellerType", "");
			long benefitId = ParamUtil.getInteger(_httpServletRequest, "searchBenefit");
			long planId = ParamUtil.getInteger(_httpServletRequest, "searchPlan");
			if (!searchName.isEmpty()) {
				return true;
			}
			if (benefitId > 0) {
				return true;
			}
			if (planId > 0) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
		if (_mvcPath.equals("/product/international_travel_standard_new/benefit_type/list.jsp")) {
			return "benefit_type";
		}
		if (_mvcPath.equals("/product/international_travel_standard_new/benefit/list.jsp")) {
			return "benefit";
		}
		
		if (_mvcPath.equals("/product/international_travel_standard_new/plan/list.jsp")) {
			return "plan";
		}
		if (_mvcPath.equals("/product/international_travel_standard_new/premi2/list.jsp")) {
			return "premi";
		}
		if (_mvcPath.equals("/product/international_travel_standard_new/link/list.jsp")) {
			return "link";
		}
		return null;
	}
	
//	@SuppressWarnings("deprecation")
//	private PortletURL _iteratorURL() {
//		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
//		portletURL.setParameter("mvcPath", _mvcPath);
//
//		String delta = ParamUtil.getString(_httpServletRequest, "delta");
//		portletURL.setParameter("delta", delta);
//
//		if (_getPageType().equals("country")) {
//			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
//
//			portletURL.setParameter("searchName", searchName);
//		}
//
//		if (_getPageType().equals("company_type")) {
//			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
//
//			portletURL.setParameter("searchName", searchName);
//		}
//
//		return portletURL;
//	}
	
	public String getConfig(String key) {
		String result = StringPool.BLANK;

		try {
			String currentDir = System.getProperty("catalina.base");
            String filePath = currentDir + "/../agency-portal.json";
			
			JsonElement jsonElement = JsonParser.parseReader(new FileReader(filePath));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            
            if (Validator.isNotNull(jsonObject)) result = jsonObject.get(key).toString().replace("\"", "");
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		return result;
	}
	
	private static final Log log = LogFactoryUtil.getLog(InternationalTravelStandardNewDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	public boolean _onSearch;

	private String _mvcPath;
}
