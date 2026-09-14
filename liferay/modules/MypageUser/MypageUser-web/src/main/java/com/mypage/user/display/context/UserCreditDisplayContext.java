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
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.user.constants.MypageUserPortletKeys;
import com.mypage.user.service.CreditTypeLocalServiceUtil;
import com.mypage.user.service.CreditWalletLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class UserCreditDisplayContext {
	private static final Log _log = LogFactoryUtil.getLog(MypageUserDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	private String _mvcPath;
	
	public UserCreditDisplayContext(LiferayPortletRequest liferayPortletRequest,
	      LiferayPortletResponse liferayPortletResponse) throws PortalException {

	    _liferayPortletRequest = liferayPortletRequest;
	    _liferayPortletResponse = liferayPortletResponse;
	    _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
	    _httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

	    _mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/user/list.jsp");
	    
	    _initDisplayContext = new InitDisplayContext(_httpServletRequest, MypageUserPortletKeys.MYPAGEUSER);
	    
	    ThemeDisplay themeDisplay = (ThemeDisplay)_httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_permissionChecker = themeDisplay.getPermissionChecker();
	}
	
	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {
	    if (_getPageType() == "creditType") {
	        String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
	        String searchAgentType = ParamUtil.getString(_httpServletRequest, "searchAgentType", "");

	        if (!searchName.isEmpty()) {
	            return true;
	        }
	        if (!searchAgentType.isEmpty()) {
	            return true;
	        }
	    }
	    if (_getPageType() == "creditWallet") {
	        String searchMypageUserId = ParamUtil.getString(_httpServletRequest, "searchMypageUserId", "");
	        String searchStatus = ParamUtil.getString(_httpServletRequest, "searchStatus", "");

	        if (!searchMypageUserId.isEmpty()) {
	            return true;
	        }
	        if (!searchStatus.isEmpty()) {
	            return true;
	        }
	    }
	    
	    return false;
	}

	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
	    if (_getPageType().equals("creditType")) {
	        return "creditTypeId";
	    }
	    if (_getPageType().equals("creditWallet")) {
	        return "creditWalletId";
	    }

	    return null;
	}

	// Get Page Type
	private String _getPageType() {
	    if (_mvcPath.equals("/user_credit/credit_type/list.jsp")) {
	        return "creditType";
	    }
	    if (_mvcPath.equals("/user_credit/credit_wallet/list.jsp")) {
	        return "creditWallet";
	    }

	    // default
	    return "creditType";
	}

	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
	    PortletURL portletURL = _liferayPortletResponse.createRenderURL();
	    portletURL.setParameter("mvcPath", _mvcPath);

	    String delta = ParamUtil.getString(_httpServletRequest, "delta");
	    portletURL.setParameter("delta", delta);
	    
	    return portletURL;
	}
	
	/**
	 * Credit Type
	 */
	public SearchContainer creditTypeConfigurationSearchContainer() throws PortalException, PortletException {
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta");
		
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
	    portletURL.setParameter("delta", Integer.toString(delta));

		SearchContainer<ProductConfiguration> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "creditTypeId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = orderByCol != "productId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		entriesSearchContainer.setDelta(delta);
		entriesSearchContainer.setIteratorURL(portletURL);
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsCreditType(entriesSearchContainer);

		return entriesSearchContainer;
	}
	private void _populateResultsCreditType(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "creditTypeId");
		String ascOrDesc = orderByCol != "creditTypeId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");
		String searchAgentType = ParamUtil.getString(_httpServletRequest, "searchAgentType", "");

		List entriesResults = null;
		DynamicQuery query = CreditTypeLocalServiceUtil.dynamicQuery();
		query.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!searchName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + searchName + "%"));
		}
		if (!searchAgentType.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("agentType", "%" + searchAgentType + "%"));
		}

		query.add(conjunction);

		entriesResults = CreditTypeLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch() || keywords != "") {
			searchContainer.setTotal(CreditTypeLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS, CreditTypeLocalServiceUtil.getCreditTypesCount()).size());
		} else {
			searchContainer.setTotal(CreditTypeLocalServiceUtil.getCreditTypesCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Credit Type
	 */
	public SearchContainer creditWalletConfigurationSearchContainer() throws PortalException, PortletException {
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta");
		
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
	    portletURL.setParameter("delta", Integer.toString(delta));

		SearchContainer<ProductConfiguration> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "creditWalletId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = orderByCol != "productId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		entriesSearchContainer.setDelta(delta);
		entriesSearchContainer.setIteratorURL(portletURL);
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsCreditWallet(entriesSearchContainer);

		return entriesSearchContainer;
	}
	private void _populateResultsCreditWallet(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "creditWalletId");
		String ascOrDesc = orderByCol != "creditWalletId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchMypageUserId = ParamUtil.getString(_httpServletRequest, "searchMypageUserId", "");
		String searchStatus = ParamUtil.getString(_httpServletRequest, "searchStatus", "");

		List entriesResults = null;
		DynamicQuery query = CreditWalletLocalServiceUtil.dynamicQuery();
		query.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!keywords.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("mypageUserId", Long.parseLong(keywords)));
		}
		if (!searchMypageUserId.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("mypageUserId", Long.parseLong(searchMypageUserId)));
		}
		if (!searchStatus.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("status", "%" + searchStatus + "%"));
		}

		query.add(conjunction);

		entriesResults = CreditWalletLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (_getOnSearch() || keywords != "") {
			searchContainer.setTotal(CreditWalletLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS, CreditWalletLocalServiceUtil.getCreditWalletsCount()).size());
		} else {
			searchContainer.setTotal(CreditWalletLocalServiceUtil.getCreditWalletsCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	private final InitDisplayContext _initDisplayContext;
	private final PermissionChecker _permissionChecker;
}
