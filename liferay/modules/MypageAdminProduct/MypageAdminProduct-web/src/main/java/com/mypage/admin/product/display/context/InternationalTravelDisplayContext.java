package com.mypage.admin.product.display.context;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mypage.admin.product.model.TravelInternationalPremi;
import com.mypage.admin.product.service.TravelInternationalPremiLocalServiceUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class InternationalTravelDisplayContext {
	public InternationalTravelDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		
		_mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath");
		
	}
	
	public SearchContainer<TravelInternationalPremi> premiSearchContainer() throws PortalException, PortletException {
		PortletURL portletURL = _liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcPath", _mvcPath);
		
		SearchContainer<TravelInternationalPremi> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "No Premi were found");
		
		// default delta, getDelta default dari search container.
//		int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
//		entriesSearchContainer.setDelta(delta); // setDelta sesuai dengan delta default dari search container.
//		
//		String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "premiId");
//		entriesSearchContainer.setOrderByCol(orderByCol);
//		
//		String defaultAscOrDesc = orderByCol != "premiId" ? "asc" : "desc"; // premiId harus selalu desc secara default
//		String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", defaultAscOrDesc);
//		entriesSearchContainer.setOrderByType(orderByType);
//		
//		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));
		
		entriesSearchContainer.setTotal(TravelInternationalPremiLocalServiceUtil.getPremiCounts());
		
		DynamicQuery _query = TravelInternationalPremiLocalServiceUtil.dynamicQuery();
		List<TravelInternationalPremi> _result = null;
		
		_result = TravelInternationalPremiLocalServiceUtil.dynamicQuery(_query, entriesSearchContainer.getStart(), entriesSearchContainer.getEnd());
		
		entriesSearchContainer.setResults(_result);
		
		return entriesSearchContainer;
	}

	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	public boolean _onSearch;

	private String _mvcPath;
}
