package com.mypage.user.display.context;

import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.users.admin.kernel.util.UsersAdminUtil;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.user.constants.MypageUserPortletKeys;
import com.mypage.user.model.MypageGroupUser;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserLicenses;
import com.mypage.user.service.MypageGroupUserLocalServiceUtil;
import com.mypage.user.service.MypageUserLicensesLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class MypageUserDisplayContext {
	private static final Log _log = LogFactoryUtil.getLog(MypageUserDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	private String _mvcPath;
	
	public MypageUserDisplayContext(LiferayPortletRequest liferayPortletRequest,
	      LiferayPortletResponse liferayPortletResponse) throws PortalException {

	    _liferayPortletRequest = liferayPortletRequest;
	    _liferayPortletResponse = liferayPortletResponse;
	    _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
	    _httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

	    _mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/user/list.jsp");
	    
	    _initDisplayContext = new InitDisplayContext(_httpServletRequest, MypageUserPortletKeys.MYPAGEUSER);
	    
	    _mypageUserId = ParamUtil.getLong(_httpServletRequest, "mypageUserId", 0);
	    _liferayUserId = 0;
	    _selUser = null;
	    _mypageUser = null;
	    if(_mypageUserId > 0) {	    	
	    	_mypageUser = MypageUserLocalServiceUtil.getMypageUser(_mypageUserId);
	    	_liferayUserId = _mypageUser.getLiferayUserId();
	    	_selUser = UserLocalServiceUtil.getUserById(_liferayUserId);
	    }
	    ThemeDisplay themeDisplay = (ThemeDisplay)_httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_permissionChecker = themeDisplay.getPermissionChecker();
	}
	
	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {
	    if (_getPageType() == "user") {
	    	String searchUserName = ParamUtil.getString(_httpServletRequest, "searchUserName", "");
	        String searchEmailAddress = ParamUtil.getString(_httpServletRequest, "searchEmailAddress", "");
	        String searchCode = ParamUtil.getString(_httpServletRequest, "searchCode", "");

	        if (!searchUserName.isEmpty()) {
	            return true;
	        }
	        if (!searchEmailAddress.isEmpty()) {
	            return true;
	        }
	        if (!searchCode.isEmpty()) {
	            return true;
	        }
	    }
	    return false;
	}

	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
	    if (_getPageType().equals("user")) {
	        return "mypageUserId";
	    }

	    return null;
	}

	// Get Page Type
	private String _getPageType() {
	    if (_mvcPath.equals("/user/list.jsp")) {
	        return "user";
	    }

	    // default
	    return "user";
	}

	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
	    PortletURL portletURL = _liferayPortletResponse.createRenderURL();
	    portletURL.setParameter("mvcPath", _mvcPath);

	    String delta = ParamUtil.getString(_httpServletRequest, "delta");
	    portletURL.setParameter("delta", delta);
	    portletURL.setParameter("liferayUserId", Long.toString(_liferayUserId));
	    
	    return portletURL;
	}
	
	public List<ProductConfiguration> getLicenses() throws PortalException {
		List<ProductConfiguration> licenses = new ArrayList<>();
		List<MypageUserLicenses> getLicenses = null;
		if(_mypageUser != null) {
			getLicenses = MypageUserLicensesLocalServiceUtil.getByMypageUserId(_mypageUser.getMypageUserId());
		}
		
		if(getLicenses != null) {
			for(MypageUserLicenses getLicense : getLicenses) {
				ProductConfiguration product = ProductConfigurationLocalServiceUtil.getProductConfiguration(getLicense.getProductId());
				licenses.add(product);
			}
		}
		
		return licenses;
	}
	
	public List<MypageUser> getUsers(long mypageGroupId) throws PortalException {
		List<MypageUser> users = MypageGroupUserLocalServiceUtil.findBymypageGroupId(mypageGroupId);
		
		return users;
	}
	
	public long[] getProductIds() throws PortalException {
		List<MypageUserLicenses> getLicenses = null;
		if(_mypageUser != null) {
			getLicenses = MypageUserLicensesLocalServiceUtil.getByMypageUserId(_mypageUser.getMypageUserId());
		}
		long[] productIds = new long[_mypageUser != null ? getLicenses.size() : 0];

		if(getLicenses != null) {
			int num = 0;
			for(MypageUserLicenses getLicense : getLicenses) {
				ProductConfiguration product = ProductConfigurationLocalServiceUtil.getProductConfiguration(getLicense.getProductId());
				productIds[num] = product.getProductId();
				num++;
			}
		}

		return productIds;
	}
	
	/**
	 * Product configuration Container
	 */
	public SearchContainer productConfigurationSearchContainer() throws PortalException, PortletException {
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta");
		
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		portletURL.setParameter("liferayUserId", Long.toString(_liferayUserId));
	    portletURL.setParameter("delta", Integer.toString(delta));

		SearchContainer<ProductConfiguration> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "productName");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = orderByCol != "productId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		entriesSearchContainer.setDelta(delta);
		entriesSearchContainer.setIteratorURL(portletURL);

		_populateResultsProductConfiguration(entriesSearchContainer);

		return entriesSearchContainer;
	}
	private void _populateResultsProductConfiguration(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "productName");
		String ascOrDesc = orderByCol != "productId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		List entriesResults = null;
		DynamicQuery query = ProductConfigurationLocalServiceUtil.dynamicQuery();
		query.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

		if (!keywords.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("productName", "%" + keywords + "%"));
		}

		query.add(conjunction);

		entriesResults = ProductConfigurationLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(), searchContainer.getEnd());

		if (keywords != "") {
			searchContainer.setTotal(ProductConfigurationLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS, ProductConfigurationLocalServiceUtil.getProductConfigurationsCount()).size());
		} else {
			searchContainer.setTotal(ProductConfigurationLocalServiceUtil.getProductConfigurationsCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Product configuration Container
	 */
	public SearchContainer selectUserSearchContainer() throws PortalException, PortletException {
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta");
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		portletURL.setParameter("mypageUserId", Long.toString(_mypageUserId));
	    portletURL.setParameter("delta", Integer.toString(delta));
	    portletURL.setParameter("keywords", keywords);

		SearchContainer<ProductConfiguration> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "mypageUserId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = orderByCol != "mypageUserId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		entriesSearchContainer.setDelta(delta);
		entriesSearchContainer.setIteratorURL(portletURL);

		_populateResultsSelectUser(entriesSearchContainer);

		return entriesSearchContainer;
	}
	private void _populateResultsSelectUser(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "mypageUserId");
		String ascOrDesc = orderByCol != "mypageUserId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		List entriesResults = null;
		DynamicQuery query = MypageUserLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		
		if (!keywords.isEmpty()) {
			disjunction.add(RestrictionsFactoryUtil.ilike("userName", "%" + keywords + "%"));
		}
		
		if (!keywords.isEmpty()) {
			disjunction.add(RestrictionsFactoryUtil.ilike("email", "%" + keywords + "%"));
		}
		
		if (!keywords.isEmpty()) {
			disjunction.add(RestrictionsFactoryUtil.ilike("code", "%" + keywords + "%"));
		}

		query.add(disjunction);

		entriesResults = MypageUserLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());
		
		if (!keywords.isEmpty()) {
			if (entriesResults.size() > 0) {
				searchContainer.setTotal(MypageUserLocalServiceUtil.dynamicQuery(query, QueryUtil.ALL_POS, MypageUserLocalServiceUtil.getMypageUsersCount()).size());
			} else {
				searchContainer.setTotal(0);
			}
		} else {
			searchContainer.setTotal(MypageUserLocalServiceUtil.getMypageUsersCount());
		}
		
//		List userResults = null;
//		DynamicQuery liferayQuery = UserLocalServiceUtil.dynamicQuery();
//		
//		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
//		
//		if (!keywords.isEmpty()) {
//			disjunction.add(RestrictionsFactoryUtil.ilike("firstName", "%" + keywords + "%"));
//		}
//		if (!keywords.isEmpty()) {
//			disjunction.add(RestrictionsFactoryUtil.ilike("middleName", "%" + keywords + "%"));
//		}
//		if (!keywords.isEmpty()) {
//			disjunction.add(RestrictionsFactoryUtil.ilike("lastName", "%" + keywords + "%"));
//		}
//		if (!keywords.isEmpty()) {
//			disjunction.add(RestrictionsFactoryUtil.ilike("emailAddress", "%" + keywords + "%"));
//		}
//		
//		liferayQuery.add(disjunction);
//		liferayQuery.setProjection(ProjectionFactoryUtil.property("userId"));
//		userResults = UserLocalServiceUtil.dynamicQuery(liferayQuery);
//
//		// get liferay user
//		DynamicQuery mypageQuery = MypageUserLocalServiceUtil.dynamicQuery();
//		
//		if(userResults.size() > 0) {		
//			Conjunction conjunctionMypageUser = RestrictionsFactoryUtil.conjunction();
//			mypageQuery.add(conjunctionMypageUser);
//			
//			if(!keywords.isEmpty()) {				
//				mypageQuery.add(PropertyFactoryUtil.forName("liferayUserId").in(userResults));
//			}
//			
//			mypageQuery.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));
//			
//			// get mypage user
//			entriesResults = MypageUserLocalServiceUtil.dynamicQuery(mypageQuery, searchContainer.getStart(), searchContainer.getEnd());
//		} 
//
//		if (!keywords.isEmpty()) {
//			if(userResults.size() > 0) {
//				searchContainer.setTotal(MypageUserLocalServiceUtil.dynamicQuery(mypageQuery, QueryUtil.ALL_POS, MypageUserLocalServiceUtil.getMypageUsersCount()).size());
//			} else {
//				searchContainer.setTotal(0);
//			}
//		} else {
//			searchContainer.setTotal(MypageUserLocalServiceUtil.getMypageUsersCount());
//		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * Product configuration Container
	 */
	public SearchContainer userSearchContainer() throws PortalException, PortletException {
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta");
		
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		portletURL.setParameter("mypageUserId", Long.toString(_mypageUserId));
	    portletURL.setParameter("delta", Integer.toString(delta));

		SearchContainer<ProductConfiguration> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "mypageUserId");
		entriesSearchContainer.setOrderByCol(orderByCol);

		String ascOrDesc = orderByCol != "mypageUserId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		entriesSearchContainer.setDelta(delta);
		entriesSearchContainer.setIteratorURL(portletURL);

		_populateResultsUser(entriesSearchContainer);

		return entriesSearchContainer;
	}
	private void _populateResultsUser(SearchContainer searchContainer) throws PortalException {

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "mypageUserId");
		String ascOrDesc = orderByCol != "mypageUserId" ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");
		
		// Advanced Search
		String searchUserName = ParamUtil.getString(_httpServletRequest, "searchUserName", "");
		String searchEmail = ParamUtil.getString(_httpServletRequest, "searchEmailAddress", "");
		String searchCode = ParamUtil.getString(_httpServletRequest, "searchCode", "");
		
		List entriesResults = null;
		DynamicQuery query = MypageUserLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if (!searchUserName.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("userName", "%" + searchUserName + "%"));
		}
		
		if (!searchEmail.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("email", "%" + searchEmail + "%"));
		}
		
		if (!searchCode.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("code", "%" + searchCode + "%"));
		}

		query.add(conjunction);

		entriesResults = MypageUserLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

		if (_getOnSearch()) {
			searchContainer.setTotal(MypageUserLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, MypageUserLocalServiceUtil.getMypageUsersCount())
					.size());
		} else {
			searchContainer.setTotal(MypageUserLocalServiceUtil.getMypageUsersCount());
		}
		
//		List userResults = null;
//		DynamicQuery liferayQuery = UserLocalServiceUtil.dynamicQuery();
//		
//		Conjunction conjunctionUser = RestrictionsFactoryUtil.conjunction();
//		
//		if (!searchFirstName.isEmpty()) {
//			conjunctionUser.add(RestrictionsFactoryUtil.ilike("firstName", "%" + searchFirstName + "%"));
//		}
//		if (!searchMiddleName.isEmpty()) {
//			conjunctionUser.add(RestrictionsFactoryUtil.ilike("middleName", "%" + searchMiddleName + "%"));
//		}
//		if (!searchLastName.isEmpty()) {
//			conjunctionUser.add(RestrictionsFactoryUtil.ilike("lastName", "%" + searchLastName + "%"));
//		}
//		if (!searchEmailAddress.isEmpty()) {
//			conjunctionUser.add(RestrictionsFactoryUtil.ilike("emailAddress", "%" + searchEmailAddress + "%"));
//		}
//				
//		liferayQuery.add(conjunctionUser);
//		liferayQuery.setProjection(ProjectionFactoryUtil.property("userId"));
//		userResults = UserLocalServiceUtil.dynamicQuery(liferayQuery);
//		
//		// get liferay user
//		DynamicQuery mypageQuery = MypageUserLocalServiceUtil.dynamicQuery();
//		
//		if(userResults.size() > 0) {		
//			Conjunction conjunctionMypageUser = RestrictionsFactoryUtil.conjunction();
//			if (!searchCode.isEmpty()) {
//				conjunctionMypageUser.add(RestrictionsFactoryUtil.ilike("code", "%" + searchCode + "%"));
//			}
//			mypageQuery.add(conjunctionMypageUser);
//			
//			if(_getOnSearch()) {				
//				mypageQuery.add(PropertyFactoryUtil.forName("liferayUserId").in(userResults));
//			}
//			
//			mypageQuery.addOrder(orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));
//			
//			// get mypage user
//			entriesResults = MypageUserLocalServiceUtil.dynamicQuery(mypageQuery, searchContainer.getStart(), searchContainer.getEnd());
//		} 
//
//		if (_getOnSearch()) {
//			if(userResults.size() > 0) {
//				searchContainer.setTotal(MypageUserLocalServiceUtil.dynamicQuery(mypageQuery, QueryUtil.ALL_POS, MypageUserLocalServiceUtil.getMypageUsersCount()).size());
//			} else {
//				searchContainer.setTotal(0);
//			}
//		} else {
//			searchContainer.setTotal(MypageUserLocalServiceUtil.getMypageUsersCount());
//		}

		searchContainer.setResults(entriesResults);
	}
	
	public List<Role> getRoles() {
		if (_selUser == null) {
			return Collections.emptyList();
		}

		if (!_initDisplayContext.isFilterManageableRoles()) {
			return _selUser.getRoles();
		}

		return UsersAdminUtil.filterRoles(
			_permissionChecker, _selUser.getRoles());
	}
	
	public User getSelectedUser() {
		return _selUser;
	}
	
	public List<MypageUser> getUsers() {
		return MypageUserLocalServiceUtil.getMypageUsers().stream().filter(v -> v.getActive() == 1).collect(Collectors.toList());
	}
	
	private final InitDisplayContext _initDisplayContext;
	private final PermissionChecker _permissionChecker;
	private MypageUser _mypageUser;
	private User _selUser;
	private long _mypageUserId;
	private long _liferayUserId;
}