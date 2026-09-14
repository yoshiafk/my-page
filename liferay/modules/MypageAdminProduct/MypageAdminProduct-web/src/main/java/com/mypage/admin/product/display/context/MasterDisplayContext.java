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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.BlacklistCustomer;
import com.mypage.admin.product.model.CompanyType;
import com.mypage.admin.product.model.Industry;
import com.mypage.admin.product.model.IndustryCategory;
import com.mypage.admin.product.model.JobPosition;
import com.mypage.admin.product.model.MasterBank;
import com.mypage.admin.product.model.MasterBranch;
import com.mypage.admin.product.model.MasterCity;
import com.mypage.admin.product.model.MasterCountry;
import com.mypage.admin.product.model.MasterCurrency;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.model.MasterOccupation;
import com.mypage.admin.product.model.MasterOccupationCategory;
import com.mypage.admin.product.model.MasterProvince;
import com.mypage.admin.product.model.PaymentChannel;
import com.mypage.admin.product.model.Promocodes;
import com.mypage.admin.product.model.ReferenceNumber;
import com.mypage.admin.product.service.BlacklistCustomerLocalServiceUtil;
import com.mypage.admin.product.service.CompanyTypeLocalServiceUtil;
import com.mypage.admin.product.service.IndustryCategoryLocalServiceUtil;
import com.mypage.admin.product.service.IndustryLocalServiceUtil;
import com.mypage.admin.product.service.JobPositionLocalServiceUtil;
import com.mypage.admin.product.service.MasterBankLocalServiceUtil;
import com.mypage.admin.product.service.MasterBranchLocalServiceUtil;
import com.mypage.admin.product.service.MasterCityLocalServiceUtil;
import com.mypage.admin.product.service.MasterCountryLocalServiceUtil;
import com.mypage.admin.product.service.MasterCurrencyLocalServiceUtil;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.admin.product.service.MasterOccupationCategoryLocalServiceUtil;
import com.mypage.admin.product.service.MasterOccupationLocalServiceUtil;
import com.mypage.admin.product.service.MasterPromoCodeLocalServiceUtil;
import com.mypage.admin.product.service.MasterProvinceLocalServiceUtil;
import com.mypage.admin.product.service.PaymentChannelLocalServiceUtil;
import com.mypage.admin.product.service.PromocodesLocalServiceUtil;
import com.mypage.admin.product.service.ReferenceNumberLocalServiceUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class MasterDisplayContext {
	public MasterDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/master/country/list.jsp");
	}

	/**
	 * Country Search Container
	 */
	public SearchContainer countrySearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterCountry> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("countryId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsCountry(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Master Country Populate Results
	private void _populateResultsCountry(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "countryId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("countryId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
		int searchShow = ParamUtil.getInteger(_httpServletRequest, "searchShow", 2);
		int searchPlatinum = ParamUtil.getInteger(_httpServletRequest, "searchPlatinum", 2);
		int searchGold = ParamUtil.getInteger(_httpServletRequest, "searchGold", 2);
		int searchSpecialAsia = ParamUtil.getInteger(_httpServletRequest, "searchSpecialAsia", 2);
		int searchSchengen = ParamUtil.getInteger(_httpServletRequest, "searchSchengen", 2);
		int searchSanctionCountry = ParamUtil.getInteger(_httpServletRequest, "searchSanctionCountry", 2);

		List entriesResults = null;
		DynamicQuery query = MasterCountryLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		if (searchShow != 2) {
			conjunction.add(RestrictionsFactoryUtil.eq("isShow", searchShow));
		}

		if (searchPlatinum != 2) {
			conjunction.add(RestrictionsFactoryUtil.eq("isPlatinum", searchPlatinum));
		}

		if (searchGold != 2) {
			conjunction.add(RestrictionsFactoryUtil.eq("isGold", searchGold));
		}

		if (searchSpecialAsia != 2) {
			conjunction.add(RestrictionsFactoryUtil.eq("isSpecialAsia", searchSpecialAsia));
		}

		if (searchSchengen != 2) {
			conjunction.add(RestrictionsFactoryUtil.eq("isSchengen", searchSchengen));
		}

		if (searchSanctionCountry != 2) {
			conjunction.add(RestrictionsFactoryUtil.eq("isSanctionCountry", searchSanctionCountry));
		}

		query.add(conjunction);

		entriesResults = MasterCountryLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MasterCountryLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterCountryLocalServiceUtil.getMasterCountryCount())
					.size());
		} else {
			searchContainer.setTotal(MasterCountryLocalServiceUtil.getMasterCountryCount());
		}

		searchContainer.setResults(entriesResults);
	}

	// Currency Search Container
	public SearchContainer currencySearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterCurrency> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "currencyId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("currencyId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsCurrency(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Currency Populate Results
	private void _populateResultsCurrency(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "currencyId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("currencyId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

		List entriesResults = null;
		DynamicQuery query = MasterCurrencyLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = MasterCurrencyLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MasterCurrencyLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterCurrencyLocalServiceUtil.getMasterCurrencyCount())
					.size());
		} else {
			searchContainer.setTotal(MasterCurrencyLocalServiceUtil.getMasterCurrencyCount());
		}

		searchContainer.setResults(entriesResults);
	}

	// Blacklist Customer Search Container
	public SearchContainer blacklistCustomerSearchContainer() throws PortalException, PortletException {

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<BlacklistCustomer> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("blacklistCustomerId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBlacklistCustomer(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Blacklist Customer Populate Results
	private void _populateResultsBlacklistCustomer(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "blacklistCustomerId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("blacklistCustomerId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchFullName = ParamUtil.getString(_httpServletRequest, "searchFullName", "");
		String searchFirstName = ParamUtil.getString(_httpServletRequest, "searchFirstName", "");
		String searchMiddleName = ParamUtil.getString(_httpServletRequest, "searchMiddleName", "");
		String searchLastName = ParamUtil.getString(_httpServletRequest, "searchLastName", "");

		List entriesResults = null;

		DynamicQuery query = BlacklistCustomerLocalServiceUtil.dynamicQuery();

		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

//		if (!searchFullName.isEmpty()) {
//			query.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("fullName", searchFullName.toString()),
//					RestrictionsFactoryUtil.eq("firstName", searchFirstName.toString())));
//		}

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchFullName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("fullName", searchFullName.toString()));
		}

		if (!searchFirstName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("firstName", searchFirstName.toString()));
		}

		if (!searchMiddleName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("middleName", searchMiddleName.toString()));
		}

		if (!searchLastName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("lastName", searchLastName.toString()));
		}

		query.add(conjunction);

		entriesResults = BlacklistCustomerLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(BlacklistCustomerLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS,
					BlacklistCustomerLocalServiceUtil.getBlacklistCustomerCount()).size());
		} else {
			searchContainer.setTotal(BlacklistCustomerLocalServiceUtil.getBlacklistCustomerCount());
		}

		searchContainer.setResults(entriesResults);
	}

	/**
	 * Province Search Container
	 */
	public SearchContainer provinceSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterProvince> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterProvinceId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsProvince(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Master Province Populate Results
	private void _populateResultsProvince(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "masterProvinceId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterProvinceId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
		int searchCountryId = ParamUtil.getInteger(_httpServletRequest, "searchCountryId");

		List entriesResults = null;
		DynamicQuery query = MasterProvinceLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		if (searchCountryId != 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("countryId", searchCountryId));
		}

		query.add(conjunction);

		entriesResults = MasterProvinceLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MasterProvinceLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterProvinceLocalServiceUtil.getMasterProvincesCount())
					.size());
		} else {
			searchContainer.setTotal(MasterProvinceLocalServiceUtil.getMasterProvincesCount());
		}

		searchContainer.setResults(entriesResults);
	}

	/**
	 * Province City Container
	 */
	public SearchContainer citySearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterCity> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterCityId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsCity(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Master City Populate Results
	private void _populateResultsCity(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "masterCityId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterCityId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
		long searchProvinceId = ParamUtil.getLong(_httpServletRequest, "searchProvinceId");
		String searchStatus = ParamUtil.getString(_httpServletRequest, "searchStatus", "");
		int searchParEarthquakeZone = ParamUtil.getInteger(_httpServletRequest, "searchParEarthquakeZone");

		List entriesResults = null;
		DynamicQuery query = MasterCityLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		if (searchProvinceId != 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("provinceId", searchProvinceId));
		}

		if (!searchStatus.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("status", "%" + searchStatus + "%"));
		}

		if (searchParEarthquakeZone != 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("parEarthquakeZone", searchParEarthquakeZone));
		}

		query.add(conjunction);

		entriesResults = MasterCityLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MasterCityLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterCityLocalServiceUtil.getMasterCitiesCount()).size());
		} else {
			searchContainer.setTotal(MasterCityLocalServiceUtil.getMasterCitiesCount());
		}

		searchContainer.setResults(entriesResults);
	}

	/**
	 * Promocodes Search Container
	 */
	public SearchContainer promocodesSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<Promocodes> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("promoCodeId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsPromocodes(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Master promocodes Populate Results
	private void _populateResultsPromocodes(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "promoCodeId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("promoCodeId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String s_promocode = ParamUtil.getString(_httpServletRequest, "s_promocode", "");

		List entriesResults = null;
		DynamicQuery query = MasterPromoCodeLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (Validator.isNotNull(s_promocode)) {
			conjunction.add(RestrictionsFactoryUtil.ilike("promoCode", "%" + s_promocode + "%"));
		}

		query.add(conjunction);

		entriesResults = MasterPromoCodeLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MasterPromoCodeLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterPromoCodeLocalServiceUtil.getMasterPromoCodesCount()).size());
		} else {
			searchContainer.setTotal(MasterPromoCodeLocalServiceUtil.getMasterPromoCodesCount());
		}

		searchContainer.setResults(entriesResults);
	}

	// Industry Category Search Container
	public SearchContainer industryCategorySearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<IndustryCategory> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "industryCategoryId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("industryCategoryId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsIndustryCategory(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Industry Category Populate Results
	private void _populateResultsIndustryCategory(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "industryCategoryId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("industryCategoryId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

		List entriesResults = null;
		DynamicQuery query = IndustryCategoryLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = IndustryCategoryLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(IndustryCategoryLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, IndustryCategoryLocalServiceUtil.getIndustryCategoryCount())
					.size());
		} else {
			searchContainer.setTotal(IndustryCategoryLocalServiceUtil.getIndustryCategoryCount());
		}

		searchContainer.setResults(entriesResults);
	}

	// Industry Search Container
	public SearchContainer industrySearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<Industry> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "industryId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("industryId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsIndustry(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Industry Populate Results
	private void _populateResultsIndustry(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "industryId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("industryCategoryId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

		List entriesResults = null;
		DynamicQuery query = IndustryLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = IndustryLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(IndustryLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, IndustryLocalServiceUtil.getIndustryCount()).size());
		} else {
			searchContainer.setTotal(IndustryLocalServiceUtil.getIndustryCount());
		}

		searchContainer.setResults(entriesResults);
	}

	// Job Position Search Container
	public SearchContainer jobPositionSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<JobPosition> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "jobPositionId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("jobPositionId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsJobPosition(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Job Position Populate Results
	private void _populateResultsJobPosition(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "jobPositionId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("jobPositionId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

		List entriesResults = null;
		DynamicQuery query = JobPositionLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = JobPositionLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(JobPositionLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, JobPositionLocalServiceUtil.getJobPositionCount()).size());
		} else {
			searchContainer.setTotal(JobPositionLocalServiceUtil.getJobPositionCount());
		}

		searchContainer.setResults(entriesResults);
	}

	/**
	 * Bank Search Container
	 */
	public SearchContainer bankSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterBank> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterBankId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBank(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Master Bank Populate Results
	private void _populateResultsBank(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "masterBankId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterBankId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchBankCode = ParamUtil.getString(_httpServletRequest, "searchBankCode", "");
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

		List entriesResults = null;
		DynamicQuery query = MasterBankLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		if (!searchBankCode.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("bankCode", "%" + searchBankCode + "%"));
		}

		query.add(conjunction);

		entriesResults = MasterBankLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MasterBankLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterBankLocalServiceUtil.getMasterBanksCount()).size());
		} else {
			searchContainer.setTotal(MasterBankLocalServiceUtil.getMasterBanksCount());
		}

		searchContainer.setResults(entriesResults);
	}

	/**
	 * Payment Channel Search Container
	 */
	public SearchContainer paymentchannelSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<PaymentChannel> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("paymentChannelId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsPaymentchannel(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Payment Channel Populate Results
	private void _populateResultsPaymentchannel(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "paymentChannelId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("paymentChannelId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchCode = ParamUtil.getString(_httpServletRequest, "searchCode", "");
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
		long searchBank = ParamUtil.getLong(_httpServletRequest, "searchBank");

		List entriesResults = null;
		DynamicQuery query = PaymentChannelLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		if (!searchCode.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("code", "%" + searchCode + "%"));
		}

		if (searchBank > 0) {
			conjunction.add(RestrictionsFactoryUtil.eq("masterBankId", searchBank));
		}

		query.add(conjunction);

		entriesResults = PaymentChannelLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(PaymentChannelLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, PaymentChannelLocalServiceUtil.getPaymentChannelsCount())
					.size());
		} else {
			searchContainer.setTotal(PaymentChannelLocalServiceUtil.getPaymentChannelsCount());
		}

		searchContainer.setResults(entriesResults);
	}

	/**
	 * Payment Channel Search Container
	 */
	public SearchContainer referenceNumberSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<ReferenceNumber> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("referenceNumberId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsReferenceNumber(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Payment Channel Populate Results
	private void _populateResultsReferenceNumber(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "referenceNumberId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("referenceNumberId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchChannel = ParamUtil.getString(_httpServletRequest, "searchChannel", "");
		String searchType = ParamUtil.getString(_httpServletRequest, "searchType", "");
		String searchProductCode = ParamUtil.getString(_httpServletRequest, "searchProductCode", "");
		String searchBusinessType = ParamUtil.getString(_httpServletRequest, "searchBusinessType", "");
		String searchCurrency = ParamUtil.getString(_httpServletRequest, "searchCurrency", "");
		String searchPrefix = ParamUtil.getString(_httpServletRequest, "searchPrefix", "");

		List entriesResults = null;
		DynamicQuery query = ReferenceNumberLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchChannel.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("channel", searchChannel));
		}
		if (!searchType.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("type", searchType));
		}
		if (!searchProductCode.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("productCode", searchProductCode));
		}
		if (!searchBusinessType.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("businessType", searchBusinessType));
		}
		if (!searchCurrency.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("currency", searchCurrency));
		}
		if (!searchPrefix.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("prefix", searchPrefix));
		}

		query.add(conjunction);

		entriesResults = ReferenceNumberLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(ReferenceNumberLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, ReferenceNumberLocalServiceUtil.getReferenceNumbersCount())
					.size());
		} else {
			searchContainer.setTotal(ReferenceNumberLocalServiceUtil.getReferenceNumbersCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Occupation Category Search Container
	 */
	public SearchContainer occupationCategorySearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterOccupationCategory> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterOccupationCategoryId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsOccupationCategory(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Occupation Category Populate Results
	private void _populateResultsOccupationCategory(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "masterOccupationCategoryId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterOccupationCategoryId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

		List entriesResults = null;
		DynamicQuery query = MasterOccupationCategoryLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = MasterOccupationCategoryLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MasterOccupationCategoryLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterOccupationCategoryLocalServiceUtil.getMasterOccupationCategoriesCount())
					.size());
		} else {
			searchContainer.setTotal(MasterOccupationCategoryLocalServiceUtil.getMasterOccupationCategoriesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Occupation Search Container
	 */
	public SearchContainer occupationSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterOccupation> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterOccupationId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsOccupation(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Occupation Populate Results
	private void _populateResultsOccupation(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "masterOccupationId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterOccupationId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
		String searchMasterOccupationCategoryId = ParamUtil.getString(_httpServletRequest, "searchMasterOccupationCategoryId", "");

		List entriesResults = null;
		DynamicQuery query = MasterOccupationLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}
		if (!searchMasterOccupationCategoryId.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("masterOccupationCategoryId", Long.parseLong(searchMasterOccupationCategoryId)));
		}

		query.add(conjunction);

		entriesResults = MasterOccupationLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MasterOccupationLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterOccupationLocalServiceUtil.getMasterOccupationsCount())
					.size());
		} else {
			searchContainer.setTotal(MasterOccupationLocalServiceUtil.getMasterOccupationsCount());
		}

		searchContainer.setResults(entriesResults);
	}

	// Company Type
	public SearchContainer companyTypeSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<CompanyType> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "companyTypeId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("companyTypeId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsCompanyType(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Job Position Populate Results
	private void _populateResultsCompanyType(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "companyTypeId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("companyTypeId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

		List entriesResults = null;
		DynamicQuery query = CompanyTypeLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}

		query.add(conjunction);

		entriesResults = CompanyTypeLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(CompanyTypeLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, CompanyTypeLocalServiceUtil.getCompanyTypeCount()).size());
		} else {
			searchContainer.setTotal(CompanyTypeLocalServiceUtil.getCompanyTypeCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Occupation Search Container
	 */
	public SearchContainer branchSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterBranch> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterBranchId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsBranch(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Occupation Populate Results
	private void _populateResultsBranch(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "masterBranchId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterBranchId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

		List entriesResults = null;
		DynamicQuery query = MasterBranchLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!keywords.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + keywords + "%"));
		}
		
		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}
		
		query.add(conjunction);

		entriesResults = MasterBranchLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch() || !keywords.isEmpty()) {
			searchContainer.setTotal(MasterBranchLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterBranchLocalServiceUtil.getMasterBranchesCount())
					.size());
		} else {
			searchContainer.setTotal(MasterBranchLocalServiceUtil.getMasterBranchesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Global Variable Search Container
	 */
	public SearchContainer globalVariableSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<MasterGlobalVariable> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterGlobalVariableId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsGlobalVariable(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Global Variable Populate Results
	private void _populateResultsGlobalVariable(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "masterGlobalVariableId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("masterGlobalVariableId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchGroup = ParamUtil.getString(_httpServletRequest, "searchGroup", "");
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
		String searchValue = ParamUtil.getString(_httpServletRequest, "searchValue", "");

		List entriesResults = null;
		DynamicQuery query = MasterGlobalVariableLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchGroup.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("group", "%" + searchGroup + "%"));
		}
		
		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}
		
		if (!searchValue.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("value", "%" + searchValue + "%"));
		}
		
		query.add(conjunction);

		entriesResults = MasterGlobalVariableLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch() || !keywords.isEmpty()) {
			searchContainer.setTotal(MasterGlobalVariableLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MasterGlobalVariableLocalServiceUtil.getMasterGlobalVariablesCount())
					.size());
		} else {
			searchContainer.setTotal(MasterGlobalVariableLocalServiceUtil.getMasterGlobalVariablesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	
	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/master/country/list.jsp")) {
			return "country";
		}
		if (_mvcPath.equals("/master/currency/list.jsp")) {
			return "currency";
		}
		if (_mvcPath.equals("/master/blacklist_customer/list.jsp")) {
			return "blacklist_customer";
		}
		if (_mvcPath.equals("/master/province/list.jsp")) {
			return "province";
		}
		if (_mvcPath.equals("/master/city/list.jsp")) {
			return "city";
		}
		if (_mvcPath.equals("/master/promocode/list.jsp")) {
			return "promocode";
		}
		if (_mvcPath.equals("/master/industry_category/list.jsp")) {
			return "industry_category";
		}
		if (_mvcPath.equals("/master/industry/list.jsp")) {
			return "industry";
		}
		if (_mvcPath.equals("/master/job_position/list.jsp")) {
			return "job_position";
		}
		if (_mvcPath.equals("/master/bank/list.jsp")) {
			return "bank";
		}
		if (_mvcPath.equals("/master/paymentchannel/list.jsp")) {
			return "paymentchannel";
		}
		if (_mvcPath.equals("/master/reference_number/list.jsp")) {
			return "referenceNumber";
		}
		if (_mvcPath.equals("/master/company_type/list.jsp")) {
			return "company_type";
		}
		if (_mvcPath.equals("/master/branch/list.jsp")) {
			return "branch";
		}
		if (_mvcPath.equals("/master/global_variable/list.jsp")) {
			return "global_variable";
		}
		
		return "country";
	}

	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {

		if (_getPageType().equalsIgnoreCase("country")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchPlatinum = ParamUtil.getString(_httpServletRequest, "searchPlatinum", "");
			String searchGold = ParamUtil.getString(_httpServletRequest, "searchGold", "");
			String searchSpecialAsia = ParamUtil.getString(_httpServletRequest, "searchSpecialAsia", "");
			String searchSchengen = ParamUtil.getString(_httpServletRequest, "searchSchengen", "");
			String searchSanctionCountry = ParamUtil.getString(_httpServletRequest, "searchSanctionCountry", "");

			if (!searchName.isEmpty()) {
				return true;
			}

			if (!searchPlatinum.isEmpty()) {
				return true;
			}

			if (!searchGold.isEmpty()) {
				return true;
			}

			if (!searchSpecialAsia.isEmpty()) {
				return true;
			}

			if (!searchSchengen.isEmpty()) {
				return true;
			}

			if (!searchSanctionCountry.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("currency")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("blacklist_customer")) {
			String searchFullName = ParamUtil.getString(_httpServletRequest, "searchFullName", "");
			String searchFirstname = ParamUtil.getString(_httpServletRequest, "searchFirstname", "");
			String searchMiddleName = ParamUtil.getString(_httpServletRequest, "searchMiddleName", "");
			String searchLastName = ParamUtil.getString(_httpServletRequest, "searchLastName", "");

			if (!searchFullName.isEmpty()) {
				return true;
			}

			if (!searchFirstname.isEmpty()) {
				return true;
			}

			if (!searchMiddleName.isEmpty()) {
				return true;
			}

			if (!searchLastName.isEmpty()) {
				return true;
			}

		}

		if (_getPageType().equalsIgnoreCase("province")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchCountryId = ParamUtil.getString(_httpServletRequest, "searchCountryId", "");

			if (!searchName.isEmpty()) {
				return true;
			}

			if (!searchCountryId.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("city")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchProvinceId = ParamUtil.getString(_httpServletRequest, "searchProvinceId", "");
			String searchStatus = ParamUtil.getString(_httpServletRequest, "searchStatus", "");
			String searchParEarthquakeZone = ParamUtil.getString(_httpServletRequest, "searchParEarthquakeZone", "");

			if (!searchName.isEmpty()) {
				return true;
			}

			if (!searchProvinceId.isEmpty()) {
				return true;
			}

			if (!searchStatus.isEmpty()) {
				return true;
			}

			if (!searchParEarthquakeZone.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("promocode")) {
			String s_promocode = ParamUtil.getString(_httpServletRequest, "s_promocode", "");
			if (Validator.isNotNull(s_promocode)) {
				return true;
			}

		}

		if (_getPageType().equalsIgnoreCase("industry_category")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("industry")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("job_position")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("bank")) {
			String searchBankCode = ParamUtil.getString(_httpServletRequest, "searchBankCode", "");
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchBankCode.isEmpty()) {
				return true;
			}

			if (!searchName.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("paymentchannel")) {
			String searchCode = ParamUtil.getString(_httpServletRequest, "searchCode", "");
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchBank = ParamUtil.getString(_httpServletRequest, "searchBank", "");

			if (!searchCode.isEmpty()) {
				return true;
			}
			if (!searchName.isEmpty()) {
				return true;
			}
			if (!searchBank.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("referenceNumber")) {
			String searchChannel = ParamUtil.getString(_httpServletRequest, "searchChannel", "");
			String searchType = ParamUtil.getString(_httpServletRequest, "searchType", "");
			String searchProductCode = ParamUtil.getString(_httpServletRequest, "searchProductCode", "");
			String searchBusinessType = ParamUtil.getString(_httpServletRequest, "searchBusinessType", "");
			String searchCurrency = ParamUtil.getString(_httpServletRequest, "searchCurrency", "");
			String searchPrefix = ParamUtil.getString(_httpServletRequest, "searchPrefix", "");

			if (!searchChannel.isEmpty()) {
				return true;
			}
			if (!searchType.isEmpty()) {
				return true;
			}
			if (!searchProductCode.isEmpty()) {
				return true;
			}
			if (!searchBusinessType.isEmpty()) {
				return true;
			}
			if (!searchCurrency.isEmpty()) {
				return true;
			}
			if (!searchPrefix.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("occupationCategory")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			
			if (!searchName.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("occupation")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchMasterOccupationCategoryId = ParamUtil.getString(_httpServletRequest, "searchMasterOccupationCategoryId");

			if (!searchName.isEmpty()) {
				return true;
			}
			if (!searchMasterOccupationCategoryId.isEmpty()) {
				return true;
			}
		}

		if (_getPageType().equalsIgnoreCase("company_type")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

			if (!searchName.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("branch")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			
			if (!searchName.isEmpty()) {
				return true;
			}
		}
		
		if (_getPageType().equalsIgnoreCase("global_variable")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
			String searchValue = ParamUtil.getString(_httpServletRequest, "searchValue", "");
			
			if (!searchName.isEmpty()) {
				return true;
			}
			
			if (!searchValue.isEmpty()) {
				return true;
			}
		}
		
		
		return false;
	}

	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
		if (_getPageType().equals("country")) {
			return "countryId";
		}

		if (_getPageType().equals("currency")) {
			return "currencyId";
		}

		if (_getPageType().equals("blacklist_customer")) {
			return "blacklistCustomerId";
		}

		if (_getPageType().equals("province")) {
			return "masterProvinceId";
		}

		if (_getPageType().equals("city")) {
			return "masterCityId";
		}

		if (_getPageType().equals("promocode")) {
			return "promoCodeId";
		}

		if (_getPageType().equals("industry_category")) {
			return "industryCategoryId";
		}

		if (_getPageType().equals("industry")) {
			return "industryId";
		}

		if (_getPageType().equals("job_position")) {
			return "jobPositionId";
		}

		if (_getPageType().equals("bank")) {
			return "masterBankId";
		}

		if (_getPageType().equals("paymentchannel")) {
			return "paymentChannelId";
		}

		if (_getPageType().equals("referenceNumber")) {
			return "referenceNumberId";
		}
		
		if (_getPageType().equals("occupationCategory")) {
			return "masterOccupationCategoryId";
		}
		
		if (_getPageType().equals("occupation")) {
			return "masterOccupationId";
		}

		if (_getPageType().equals("company_type")) {
			return "companyTypeId";
		}
		
		if (_getPageType().equals("global_variable")) {
			return "masterGlobalVariableId";
		}
		
		
		if (_mvcPath.equals("/master/currency/list.jsp")) {
			return "currency";
		}
		if (_mvcPath.equals("/master/blacklist_customer/list.jsp")) {
			return "blacklist_customer";
		}
		if (_mvcPath.equals("/master/province/list.jsp")) {
			return "province";
		}
		if (_mvcPath.equals("/master/city/list.jsp")) {
			return "city";
		}
		if (_mvcPath.equals("/master/promocode/list.jsp")) {
			return "promocode";
		}
		if (_mvcPath.equals("/master/industry_category/list.jsp")) {
			return "industry_category";
		}
		if (_mvcPath.equals("/master/industry/list.jsp")) {
			return "industry";
		}
		if (_mvcPath.equals("/master/job_position/list.jsp")) {
			return "job_position";
		}
		if (_mvcPath.equals("/master/bank/list.jsp")) {
			return "bank";
		}
		if (_mvcPath.equals("/master/paymentchannel/list.jsp")) {
			return "paymentchannel";
		}
		if (_mvcPath.equals("/master/reference_number/list.jsp")) {
			return "referenceNumber";
		}
		if (_mvcPath.equals("/master/occupation_category/list.jsp")) {
			return "occupationCategory";
		}
		if (_mvcPath.equals("/master/occupation/list.jsp")) {
			return "occupation";
		}
		if (_mvcPath.equals("/master/branch/list.jsp")) {
			return "masterBranchId";
		}
		if (_mvcPath.equals("/master/global_variable/list.jsp")) {
			return "masterGlobalVariableId";
		}
		
		
		return null;
	}

	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		String delta = ParamUtil.getString(_httpServletRequest, "delta");
		portletURL.setParameter("delta", delta);

		if (_getPageType().equals("country")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

			portletURL.setParameter("searchName", searchName);
		}

		if (_getPageType().equals("company_type")) {
			String searchName = ParamUtil.getString(_httpServletRequest, "searchName");

			portletURL.setParameter("searchName", searchName);
		}

		return portletURL;
	}
	
	public JSONArray getProducts() {
		JSONArray result = JSONFactoryUtil.createJSONArray();
		
		String PIMCORE_HOST = getConfig("com.mypage.agent.config.pimcoreAddress");
		String dashboardApiAgencyProductsUrl = getConfig("dashboard.api.agency.products");
		List<MasterGlobalVariable> _listToken = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("token");
		String _eToken = StringPool.BLANK;
		
		for (MasterGlobalVariable item : _listToken) {
			if (item.getName().equalsIgnoreCase("x_api_key")) _eToken = item.getValue();
		}
		
		try {
			JSONObject productResponse = hitAPI(PIMCORE_HOST + dashboardApiAgencyProductsUrl, StringPool.BLANK, _eToken);
			
			JSONObject productApiResponse = JSONFactoryUtil.createJSONObject(productResponse.get("response").toString());
			
			if (productApiResponse.getInt("Status") == 0) {
				return result;
			}
			
			if (productApiResponse.getInt("Count") > 0) {
				result = productApiResponse.getJSONArray("Data");
			}
		} catch(Exception e) {
			
		}
		
		return result;
	}
	
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
	
	/**
	 * Call API with body payload JSON
	 * @throws KeyManagementException 
	 * @throws NoSuchAlgorithmException 
	 */
	public JSONObject hitAPI(String url, String payload, String token) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
        String line = StringPool.BLANK;
        StringBuilder responseBody = new StringBuilder();
        int responseCode = 0;
        
		try {
			URL requestUrl = new URL(url);
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
			HttpURLConnection connection = null;

			if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();
				
//				httpsConnection.setHostnameVerifier((hostname, session) -> true);
				httpsConnection.setHostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String requestedHost, SSLSession remoteServerSession) {
						return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
					}
				});
	
				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, new TrustManager[] { new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
					}
	
					public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
					}
	
					public X509Certificate[] getAcceptedIssuers() {
						return null; //new X509Certificate[0];
					}
				} }, new SecureRandom());
//				TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//                trustManagerFactory.init((KeyStore) null);
//                
//                SSLContext sslContext = SSLContext.getInstance("TLS");
//                sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
	
				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
				
				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}
			
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            
            connection.setRequestProperty("x-api-key", token); // Set Authorization header
            
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.setDoOutput(true);
            
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(payload.getBytes());
            outputStream.flush();
            outputStream.close();

            if (connection.getResponseCode() == 200) {
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));            
	            while ((line = bufferedReader.readLine()) != null) {
	                responseBody.append(line);
	            }
	            bufferedReader.close();
            } else {
            	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));            
	            while ((line = bufferedReader.readLine()) != null) {
	                responseBody.append(line);
	            }
	            bufferedReader.close();
            }
            
            responseCode = connection.getResponseCode();
		} catch (IOException e) {
			log.info(e.getMessage());
		}
		
		_response.put("statusCode", responseCode);
		_response.put("response", responseBody.toString());
		
		return _response;
	}

	private static final Log log = LogFactoryUtil.getLog(MasterDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;
}
