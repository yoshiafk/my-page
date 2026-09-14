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
import com.mypage.admin.product.model.PersonalAccidentPremi;
import com.mypage.admin.product.service.PersonalAccidentPremiLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class PersonalAccidentDisplayContext {
	public PersonalAccidentDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/product/personal_accident/premi/list.jsp");
	}
	
	public SearchContainer premiSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<PersonalAccidentPremi> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");
		
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);
		
		String ascOrDesc = !orderByCol.equalsIgnoreCase("personalAccidentPremiId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);
		
		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);
		
		entriesSearchContainer.setIteratorURL(_iteratorURL());
		
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		_populateResultsPremi(entriesSearchContainer);
		
		return entriesSearchContainer;
	}
	
	public void _populateResultsPremi(SearchContainer<PersonalAccidentPremi> searchContainer) throws PortalException {
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "personalAccidentPremiId");
		String ascOrDesc = !orderByCol.equalsIgnoreCase("personalAccidentPremiId") ? "asc" : "desc";
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchType = ParamUtil.getString(_httpServletRequest, "searchType", "");

		List entriesResults = null;
		DynamicQuery query = PersonalAccidentPremiLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		if(!searchType.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.eq("premiType", searchType));
		}
		
		query.add(conjunction);

		entriesResults = PersonalAccidentPremiLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());
		
//			System.out.println(entriesResults);

		if (_getOnSearch()) {
			searchContainer.setTotal(PersonalAccidentPremiLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, PersonalAccidentPremiLocalServiceUtil.getPersonalAccidentPremiCount())
					.size());
		} else {
			searchContainer.setTotal(PersonalAccidentPremiLocalServiceUtil.getPersonalAccidentPremiCount());
		}

		searchContainer.setResults(entriesResults);
	}
	
	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {

		if (_getPageType().equals("premi")) {
			String searchType = ParamUtil.getString(_httpServletRequest, "searchType", "");
			long searchAmount = ParamUtil.getLong(_httpServletRequest, "searchAmount", 0);
			
			if(!searchType.isEmpty()) {
				return true;
			}			
			
			if (searchAmount != 0) {
				return true;
			}
		}	

		return false;
	}
	
	// Order by default
	private String _orderByColDefault() {
		if (_getPageType().equals("premi")) {
			return "personalAccidentPremiId";
		}
		
		return null;
	}
	
	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/product/personal_accident/premi/list.jsp")) {
			return "premi";
		}	

		return "page";
	}
	
	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		String delta = ParamUtil.getString(_httpServletRequest, "delta");
		portletURL.setParameter("delta", delta);

		if (_getPageType().equals("premi")) {
			String searchType = ParamUtil.getString(_httpServletRequest, "searchType", "");
			long searchAmount = ParamUtil.getLong(_httpServletRequest, "searchAmount", 0);

			portletURL.setParameter("searchType", String.valueOf(searchType));
			portletURL.setParameter("searchAmount", String.valueOf(searchAmount));
		}		

		return portletURL;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PersonalAccidentDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;
}
