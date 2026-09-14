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
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.model.AgentCalendar;
import com.mypage.agencyportal.service.AgentCalendarLocalServiceUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class CalendarDisplayContext {
	public CalendarDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/dashboard/calendar/master/list.jsp");
	}

	/**
	 * Calendar Search Container
	 * @throws ParseException 
	 */
	public SearchContainer calendarSearchContainer() throws PortalException, PortletException, ParseException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		SearchContainer<AgentCalendar> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
		entriesSearchContainer.setOrderByCol(orderByCol);

		//String ascOrDesc = orderByCol != "agentCalendarId" ? "asc" : "desc";
		String ascOrDesc = "agentCalendarId".equalsIgnoreCase(orderByCol)==false ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		entriesSearchContainer.setOrderByType(orderByType);

		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
		entriesSearchContainer.setDelta(delta);

		entriesSearchContainer.setIteratorURL(_iteratorURL());

		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResultsCalendar(entriesSearchContainer);

		return entriesSearchContainer;
	}

	// Calendar Populate Results
	private void _populateResultsCalendar(SearchContainer searchContainer) throws PortalException, ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "agentCalendarId");
		//String ascOrDesc = orderByCol != "agentCalendarId" ? "asc" : "desc";
		String ascOrDesc = "agentCalendarId".equalsIgnoreCase(orderByCol)==false ? "asc" : "desc";
		
		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
		String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
		String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

		// Advanced Search
		String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");
		String searchLocation = ParamUtil.getString(_httpServletRequest, "searchLocation", "");
		String searchStartDate = ParamUtil.getString(_httpServletRequest, "searchStartDate", "");
		String searchEndDate = ParamUtil.getString(_httpServletRequest, "searchEndDate", "");
		String searchUserRole = ParamUtil.getString(_httpServletRequest, "searchUserRole", "");
		String searchUserGroup = ParamUtil.getString(_httpServletRequest, "searchUserGroup", "");

		List entriesResults = null;
		DynamicQuery query = AgentCalendarLocalServiceUtil.dynamicQuery();
		query.addOrder(
				orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		
		conjunction.add(RestrictionsFactoryUtil.ilike("category", "%event%"));

		if (!searchTitle.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("title", "%" + searchTitle + "%"));
		}
		
		if (!searchLocation.isEmpty()) {
			conjunction.add(RestrictionsFactoryUtil.ilike("location", "%" + searchLocation + "%"));
		}
		
		if (Validator.isNotNull(searchUserRole)) {
			conjunction.add(RestrictionsFactoryUtil.ilike("role", "%" + searchUserRole + "%"));
		}
		
		if (Validator.isNotNull(searchUserGroup)) {
			conjunction.add(RestrictionsFactoryUtil.ilike("group", "%" + searchUserGroup + "%"));
		}
		
		if (!searchStartDate.isEmpty()) {
			Date startDate = dateFormat.parse(searchStartDate);
			conjunction.add(RestrictionsFactoryUtil.ge("startDate", startDate));
		}
		
		if (!searchEndDate.isEmpty()) {
			Date endDate = dateFormat.parse(searchEndDate);
			conjunction.add(RestrictionsFactoryUtil.le("endDate", endDate));
		}

		query.add(conjunction);

		entriesResults = AgentCalendarLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
				searchContainer.getEnd());

//		if (_getOnSearch()) {
			searchContainer.setTotal(AgentCalendarLocalServiceUtil
					.dynamicQuery(query, QueryUtil.ALL_POS, AgentCalendarLocalServiceUtil.getAgentCalendarsCount())
					.size());
//		} else {
//			searchContainer.setTotal(AgentCalendarLocalServiceUtil.getAgentCalendarsCount());
//		}

		searchContainer.setResults(entriesResults);
	}
	
	// Get Page Type
	private String _getPageType() {
		if (_mvcPath.equals("/dashboard/calendar/master/list.jsp")) {
			return "calendar";
		}
		return "calendar";
	}

	/**
	 * State for collapsible panel wether collapsed or expanded by detect current
	 * active field
	 */
	public boolean _getOnSearch() {

		//if (_getPageType() == "calendar") {
		if (_getPageType().equals("calendar")) {
			String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle", "");
			String searchLocation = ParamUtil.getString(_httpServletRequest, "searchLocation", "");
			String searchUserRole = ParamUtil.getString(_httpServletRequest, "searchUserRole", "");
			String searchUserGroup = ParamUtil.getString(_httpServletRequest, "searchUserGroup", "");
			String searchStartDate = ParamUtil.getString(_httpServletRequest, "searchStartDate", "");
			String searchEndDate = ParamUtil.getString(_httpServletRequest, "searchEndDate", "");

			if (!searchTitle.isEmpty()) {
				return true;
			}
			
			if (!searchLocation.isEmpty()) {
				return true;
			}
			
			if (!searchUserRole.isEmpty()) {
				return true;
			}
			
			if (!searchUserGroup.isEmpty()) {
				return true;
			}
			
			if (!searchStartDate.isEmpty()) {
				return true;
			}
			
			if (!searchEndDate.isEmpty()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Order by Col Default
	 */
	private String _orderByColDefault() {
		if (_getPageType().equals("calendar")) {
			return "agentCalendarId";
		}
		
		return null;
	}

	@SuppressWarnings("deprecation")
	private PortletURL _iteratorURL() {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);

		String delta = ParamUtil.getString(_httpServletRequest, "delta");
		portletURL.setParameter("delta", delta);

		if (_getPageType().equals("calendar")) {
			String searchTitle = ParamUtil.getString(_httpServletRequest, "searchTitle");
			String searchDateRange = ParamUtil.getString(_httpServletRequest, "searchDateRange");

			portletURL.setParameter("searchTitle", searchTitle);
			portletURL.setParameter("searchDateRange", searchDateRange);
		}

		return portletURL;
	}

	private static final Log _log = LogFactoryUtil.getLog(CalendarDisplayContext.class);
	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;

	private String _mvcPath;
}
