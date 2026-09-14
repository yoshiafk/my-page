package com.mypage.admin.product.display.context;

import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mypage.admin.product.model.SmartActivePremi;
import com.mypage.admin.product.model.BenefitValueMapping;
import com.mypage.admin.product.model.SmartActiveBenefit;
import com.mypage.admin.product.model.SmartActiveBenefitType;
import com.mypage.admin.product.service.SmartActivePremiLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveToproBenefitMappingLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveToproLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitValueMappingLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveClassRateLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveFeatureLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitValueLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveLinkLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveOccupationLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class SmartActiveDisplayContext {
	public SmartActiveDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath");
	}
	
	/* benefit type search container */
	public SearchContainer benefitTypeSearchContainer() throws PortalException, PortletException{
		
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActiveBenefitType> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveBenefitTypeId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveBenefitTypeId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		_populateResultsBenefitType(entriesSearchContainer);
		
		return entriesSearchContainer;
	}
	
	/* benefit type populate results */
	private void _populateResultsBenefitType(SearchContainer searchContainer) throws PortalException{
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveBenefitTypeId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveBenefitTypeId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
		String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn");
		
		List entriesResults = null;
		
		DynamicQuery query = SmartActiveBenefitTypeLocalServiceUtil.dynamicQuery();
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
		
		entriesResults = SmartActiveBenefitTypeLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());
		
		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveBenefitTypeLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveBenefitTypeLocalServiceUtil.getSmartActiveBenefitTypesCount())
					.size());
		} else {
			searchContainer.setTotal(SmartActiveBenefitTypeLocalServiceUtil.getSmartActiveBenefitTypesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* benefit search container */
	public SearchContainer benefitSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActiveBenefit> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveBenefitId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveBenefitId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBenefit(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	/* benefit populate results */
	private void _populateResultsBenefit(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveBenefitId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveBenefitId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
		String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn");
		long typeId = ParamUtil.getInteger(_httpServletRequest, "searchBenefitType");
		
		List entriesResults = null;
		DynamicQuery query = SmartActiveBenefitLocalServiceUtil.dynamicQuery();
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
			conjunction.add(RestrictionsFactoryUtil.eq("smartActiveBenefitTypeId", typeId));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActiveBenefitLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveBenefitLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveBenefitLocalServiceUtil.getSmartActiveBenefitsCount()).size());
		} else {
			searchContainer.setTotal(SmartActiveBenefitLocalServiceUtil.getSmartActiveBenefitsCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* benefit value search container */
	public SearchContainer benefitValueSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActiveBenefit> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveBenefitValueId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveBenefitValueId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBenefitValue(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	/* benefit value populate results */
	private void _populateResultsBenefitValue(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveBenefitValueId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveBenefitValueId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		long searchValue = ParamUtil.getLong(_httpServletRequest, "searchValue");
		
		List entriesResults = null;
		DynamicQuery query = SmartActiveBenefitValueLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (searchValue > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("value", searchValue));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActiveBenefitValueLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveBenefitValueLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveBenefitValueLocalServiceUtil.getSmartActiveBenefitValuesCount()).size());
		} else {
			searchContainer.setTotal(SmartActiveBenefitValueLocalServiceUtil.getSmartActiveBenefitValuesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* benefit value mapping search container */
	public SearchContainer benefitValueMappingSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<BenefitValueMapping> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveBenefitValueMappingId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveBenefitValueMappingId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBenefitValueMapping(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	/* benefit value mapping populate results */
	private void _populateResultsBenefitValueMapping(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveBenefitValueMappingId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveBenefitValueMappingId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		long typeId = ParamUtil.getInteger(_httpServletRequest, "searchBenefitType");
		long benefitId = ParamUtil.getLong(_httpServletRequest, "searchBenefit");
		long benefitValueId = ParamUtil.getLong(_httpServletRequest, "searchBenefitValue");
		
		List entriesResults = null;
		DynamicQuery query = SmartActiveBenefitValueMappingLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (typeId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("smartActiveBenefitTypeId", typeId));
		}
		
		if (benefitId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("smartActiveBenefitId", benefitId));
		}
		
		if (benefitValueId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("smartActiveBenefitValueId", benefitValueId));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActiveBenefitValueMappingLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveBenefitValueMappingLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveBenefitValueMappingLocalServiceUtil.getSmartActiveBenefitValueMappingsCount()).size());
		} else {
			searchContainer.setTotal(SmartActiveBenefitValueMappingLocalServiceUtil.getSmartActiveBenefitValueMappingsCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* class rate search container */
	public SearchContainer classRateSearchContainer() throws PortalException, PortletException{
		
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActiveBenefitType> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveClassRateId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveClassRateId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		_populateResultsClassRate(entriesSearchContainer);
		
		return entriesSearchContainer;
	}
	
	/* class rate populate results */
	private void _populateResultsClassRate(SearchContainer searchContainer) throws PortalException{
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveClassRateId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveClassRateId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
		String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn");
		
		List entriesResults = null;
		
		DynamicQuery query = SmartActiveClassRateLocalServiceUtil.dynamicQuery();
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
		
		entriesResults = SmartActiveClassRateLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());
		
		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveClassRateLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveClassRateLocalServiceUtil.getSmartActiveClassRatesCount())
					.size());
		} else {
			searchContainer.setTotal(SmartActiveClassRateLocalServiceUtil.getSmartActiveClassRatesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* occupation search container */
	public SearchContainer occupationSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActiveBenefit> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveOccupationId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveOccupationId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsOccupation(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	/* occupation populate results */
	private void _populateResultsOccupation(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveOccupationId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveOccupationId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");
		String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn");
		long classRateId = ParamUtil.getInteger(_httpServletRequest, "searchClassRate");
		
		List entriesResults = null;
		DynamicQuery query = SmartActiveOccupationLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("nameId", "%" + searchName + "%"));
		}
		
		if (!searchNameEn.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("nameEn", "%" + searchNameEn + "%"));
		}
		
		if (classRateId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("smartActiveClassRateId", classRateId));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActiveOccupationLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveOccupationLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveOccupationLocalServiceUtil.getSmartActiveOccupationsCount()).size());
		} else {
			searchContainer.setTotal(SmartActiveOccupationLocalServiceUtil.getSmartActiveOccupationsCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* topro search container */
	public SearchContainer toproSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActiveBenefit> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveToproId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveToproId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsTopro(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	/* topro populate results */
	private void _populateResultsTopro(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveToproId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveToproId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchTopro = ParamUtil.getString(_httpServletRequest, "searchTopro");
		
		List entriesResults = null;
		DynamicQuery query = SmartActiveToproLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchTopro.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("topro", "%" + searchTopro + "%"));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActiveToproLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveToproLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveToproLocalServiceUtil.getSmartActiveToprosCount()).size());
		} else {
			searchContainer.setTotal(SmartActiveToproLocalServiceUtil.getSmartActiveToprosCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* topro benefit mapping search container */
	public SearchContainer toproBenefitMappingSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<BenefitValueMapping> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveToproBenefitMappingId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveToproBenefitMappingId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsToproBenefitMapping(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	/* topro benefit mapping populate results */
	private void _populateResultsToproBenefitMapping(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveToproBenefitMappingId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveToproBenefitMappingId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		long toproId = ParamUtil.getInteger(_httpServletRequest, "searchTopro");
		
		List entriesResults = null;
		DynamicQuery query = SmartActiveToproBenefitMappingLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (toproId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("smartActiveToproId", toproId));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActiveToproBenefitMappingLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveToproBenefitMappingLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveToproBenefitMappingLocalServiceUtil.getSmartActiveToproBenefitMappingsCount()).size());
		} else {
			searchContainer.setTotal(SmartActiveToproBenefitMappingLocalServiceUtil.getSmartActiveToproBenefitMappingsCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* premi search container */
	public SearchContainer premiSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActivePremi> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActivePremiId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActivePremiId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsPremi(entriesSearchContainer);

		return entriesSearchContainer;
	
	}
	
	/* premi populate results */
	private void _populateResultsPremi(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActivePremiId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActivePremiId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		long benefitId = ParamUtil.getInteger(_httpServletRequest, "searchBenefit");
		long classRateId = ParamUtil.getLong(_httpServletRequest, "searchClassRate");
		
		List entriesResults = null;
		DynamicQuery query = SmartActivePremiLocalServiceUtil.dynamicQuery();
		query.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (benefitId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("smartActiveBenefitId", benefitId));
		}
		
		if (classRateId > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("smartActiveClassRateId", classRateId));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActivePremiLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActivePremiLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActivePremiLocalServiceUtil.getSmartActivePremisCount()).size());
		} else {
			searchContainer.setTotal(SmartActivePremiLocalServiceUtil.getSmartActivePremisCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* feature search container */
	public SearchContainer featureSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActivePremi> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveFeatureId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveFeatureId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsFeature(entriesSearchContainer);

		return entriesSearchContainer;
	
	}
	
	/* feature populate results */
	private void _populateResultsFeature(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveFeatureId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveFeatureId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle");
		
		List entriesResults = null;
		DynamicQuery query = SmartActiveFeatureLocalServiceUtil.dynamicQuery();
		query.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchTitle.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("title", "%" + searchTitle + "%"));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActiveFeatureLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveFeatureLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveFeatureLocalServiceUtil.getSmartActiveFeaturesCount()).size());
		} else {
			searchContainer.setTotal(SmartActiveFeatureLocalServiceUtil.getSmartActiveFeaturesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/* link files search container */
	public SearchContainer fileSearchContainer() throws PortalException, PortletException {
	
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<SmartActivePremi> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
	
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveLinkId");
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveLinkId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsFile(entriesSearchContainer);

		return entriesSearchContainer;
	
	}
	
	/* link files populate results */
	private void _populateResultsFile(SearchContainer searchContainer) throws PortalException{
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "smartActiveLinkId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("smartActiveLinkId") ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory");
		String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle");
		
		List entriesResults = null;
		DynamicQuery query = SmartActiveLinkLocalServiceUtil.dynamicQuery();
		query.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchCategory.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("category", "%" + searchCategory + "%"));
		}
		
		if (!searchTitle.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("title", "%" + searchTitle + "%"));
		}
		
		query.add(conjunction);
		
		entriesResults = SmartActiveLinkLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(SmartActiveLinkLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, SmartActiveLinkLocalServiceUtil.getSmartActiveLinksCount()).size());
		} else {
			searchContainer.setTotal(SmartActiveLinkLocalServiceUtil.getSmartActiveLinksCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/product/smart_active/benefit_type/list.jsp")) {
			return "benefit_type";
		}
		if (_mvcPath.equals("/product/smart_active/benefit/list.jsp")) {
			return "benefit";
		}
		if (_mvcPath.equals("/product/smart_active/benefit_value_mapping/list.jsp")) {
			return "benefit_value_mapping";
		}
		if (_mvcPath.equals("/product/smart_active/class_rate/list.jsp")) {
			return "class_rate";
		}
		if (_mvcPath.equals("/product/smart_active/occupation/list.jsp")) {
			return "occupation";
		}
		if (_mvcPath.equals("/product/smart_active/topro/list.jsp")) {
			return "topro";
		}
		if (_mvcPath.equals("/product/smart_active/topro_benefit_mapping/list.jsp")) {
			return "topro_benefit_mapping";
		}
		if (_mvcPath.equals("/product/smart_active/premi/list.jsp")) {
			return "premi";
		}
		if (_mvcPath.equals("/product/smart_active/feature/list.jsp")) {
			return "feature";
		}
		if (_mvcPath.equals("/product/smart_active/link/list.jsp")) {
			return "link";
		}
		
		return "premi";
	}


	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {
	
		if (_getPageType().equalsIgnoreCase("benefit_type")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn", "");
			
			if (!searchName.isEmpty()) {
				return true;
			}
			if (!searchNameEn.isEmpty()) {
				return true;
			}
		}
	
		if (_getPageType().equalsIgnoreCase("benefit")) {
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
		
		if (_getPageType().equalsIgnoreCase("benefit_value_mapping")) {
			long typeId = ParamUtil.getInteger(_httpServletRequest, "searchBenefitType", 0);
			long benefitId = ParamUtil.getInteger(_httpServletRequest, "searchBenefit", 0);
			long benefitValueId = ParamUtil.getInteger(_httpServletRequest, "searchBenefitValue", 0);
			
			if (typeId > 0) {
				return true;
			}
			if (benefitId > 0) {
				return true;
			}
			if (benefitValueId > 0) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("class_rate")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn", "");
			
			if (!searchName.isEmpty()) {
				return true;
			}
			if (!searchNameEn.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("occupation")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchNameEn = ParamUtil.getString(_httpServletRequest, "searchNameEn", "");
			long classRateId = ParamUtil.getInteger(_httpServletRequest, "searchClassRate", 0);
			
			if (!searchName.isEmpty()) {
				return true;
			}
			if (!searchNameEn.isEmpty()) {
				return true;
			}
			if (classRateId > 0) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("topro")) {
			String searchTopro = ParamUtil.getString(_httpServletRequest, "searchTopro", "");
			
			if (!searchTopro.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("topro_benefit_mapping")) {
			long toproId = ParamUtil.getInteger(_httpServletRequest, "searchTopro", 0);
			long benefitId = ParamUtil.getInteger(_httpServletRequest, "searchBenefit", 0);
			
			if (toproId > 0) {
				return true;
			}
			if (benefitId > 0) {
				return true;
			}
		}
	
		if (_getPageType().equalsIgnoreCase("premi")) {
			long benefitId = ParamUtil.getInteger(_httpServletRequest, "searchBenefit");
			if (benefitId > 0) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("feature")) {
			String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");
			
			if (!searchTitle.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("link")) {
			String searchCategory = ParamUtil.getString(_httpServletRequest, "searchCategory", "");
			String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");
			
			if (!searchCategory.isEmpty()) {
				return true;
			}
			
			if (!searchTitle.isEmpty()) {
				return true;
			}
		}
	
		return false;
	}
	
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	public boolean _onSearch;

	private String _mvcPath;
}
