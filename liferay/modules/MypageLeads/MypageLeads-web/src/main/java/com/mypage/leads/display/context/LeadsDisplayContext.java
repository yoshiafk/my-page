package com.mypage.leads.display.context;

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
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.LeadsLocalServiceUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class LeadsDisplayContext {
  private static final Log log = LogFactoryUtil.getLog(LeadsDisplayContext.class);
  private final HttpServletRequest _httpServletRequest;
  private final LiferayPortletRequest _liferayPortletRequest;
  private final LiferayPortletResponse _liferayPortletResponse;
  private final PortalPreferences _portalPreferences;
  private String _mvcPath;
  
  public LeadsDisplayContext(LiferayPortletRequest liferayPortletRequest,
      LiferayPortletResponse liferayPortletResponse) {

    _liferayPortletRequest = liferayPortletRequest;
    _liferayPortletResponse = liferayPortletResponse;
    _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
    _httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

    _mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/parents/list.jsp");
  }

  /**
   * State for collapsible panel wether collapsed or expanded by detect current
   * active field
   */
  public boolean _getOnSearch() {
    if (_getPageType().equalsIgnoreCase("leads")) {
      String searchName = ParamUtil.getString(_httpServletRequest, "searchName", "");

      if (!searchName.isEmpty()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Order by Col Default
   */
  private String _orderByColDefault() {
    if (_getPageType().equals("leads")) {
      return "LeadsId";
    }

    return null;
  }

  // Get Page Type
  private String _getPageType() {
    if (_mvcPath.equals("/parents/list.jsp")) {
      return "leads";
    }
    
    // default
    return "leads";
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

    return portletURL;
  }
  
  /**
   * Promocodes Search Container
   */
  public SearchContainer leadsSearchContainer() throws PortalException, PortletException {
    PortletURL portletURL = _liferayPortletResponse.createRenderURL();
    portletURL.setParameter("mvcPath", _mvcPath);

    SearchContainer<Leads> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
        PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

    String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
    entriesSearchContainer.setOrderByCol(orderByCol);

    String ascOrDesc = !orderByCol.equalsIgnoreCase("LeadsId") ? "asc" : "desc";
    String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
    entriesSearchContainer.setOrderByType(orderByType);

    int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
    entriesSearchContainer.setDelta(delta);

    entriesSearchContainer.setIteratorURL(_iteratorURL());

    entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

    _populateResultsLeads(entriesSearchContainer);

    return entriesSearchContainer;
  }

  // Master promocodes Populate Results
  private void _populateResultsLeads(SearchContainer searchContainer) throws PortalException {

    String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "LeadsId");
    String ascOrDesc = !orderByCol.equalsIgnoreCase("LeadsId") ? "asc" : "desc";
    String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
    String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
    String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

    // Advanced Search
    String s_product= ParamUtil.getString(_httpServletRequest, "s_product", "");
    String s_referenceNumber= ParamUtil.getString(_httpServletRequest, "s_referenceNumber", "");
    String s_type= ParamUtil.getString(_httpServletRequest, "s_type", "");
    String s_channel= ParamUtil.getString(_httpServletRequest, "s_channel", "");
    String s_promocode= ParamUtil.getString(_httpServletRequest, "s_promocode", "");
    String s_name= ParamUtil.getString(_httpServletRequest, "s_name", "");
    String s_email= ParamUtil.getString(_httpServletRequest, "s_email", "");
    String s_create_on= ParamUtil.getString(_httpServletRequest, "s_create_on", "");
    String s_create_after= ParamUtil.getString(_httpServletRequest, "s_create_after", "");
    String s_create_before= ParamUtil.getString(_httpServletRequest, "s_create_before", "");

    List entriesResults = null;
    DynamicQuery query = LeadsLocalServiceUtil.dynamicQuery();
    
    query.addOrder(
        orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

    Conjunction conjunction = RestrictionsFactoryUtil.conjunction();


    if (Validator.isNotNull(s_product)) {
      conjunction.add(RestrictionsFactoryUtil.ilike("ProductCode", s_product));
    }

    if (Validator.isNotNull(s_referenceNumber)) {
      conjunction.add(RestrictionsFactoryUtil.ilike("ReferenceNumber", "%" + s_referenceNumber + "%"));
    }

    if (Validator.isNotNull(s_type)) {
      conjunction.add(RestrictionsFactoryUtil.ilike("LeadsType", s_type));
    }

    if (Validator.isNotNull(s_channel)) {
      if(s_channel.equalsIgnoreCase("agent")) {
        conjunction.add(RestrictionsFactoryUtil.ilike("Channel", "b2b"));
        conjunction.add(RestrictionsFactoryUtil.ilike("Channel", "b2b2c"));
      }else {
        conjunction.add(RestrictionsFactoryUtil.ilike("Channel", s_channel));
      }
    }

    if (Validator.isNotNull(s_promocode)) {
      conjunction.add(RestrictionsFactoryUtil.ilike("PromoCode", "%" + s_promocode + "%"));
    }

    if (Validator.isNotNull(s_name)) {
      conjunction.add(RestrictionsFactoryUtil.ilike("Name", "%" + s_name + "%"));
    }

    if (Validator.isNotNull(s_email)) {
      conjunction.add(RestrictionsFactoryUtil.ilike("Email", "%" + s_email + "%"));
    }

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date _searchDate;
    if (Validator.isNotNull(s_create_on)) {
      try {
        _searchDate = sdf.parse(s_create_on + " 00:00:01");
        conjunction.add(RestrictionsFactoryUtil.ge("createDate", _searchDate));
        
        _searchDate = sdf.parse(s_create_on + " 23:59:59");
        conjunction.add(RestrictionsFactoryUtil.le("createDate", _searchDate));
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        log.info(e);
      }
    }else {
      if (Validator.isNotNull(s_create_after)) {
        try {
          _searchDate = sdf.parse(s_create_after + " 00:00:01");
          conjunction.add(RestrictionsFactoryUtil.ge("createDate", _searchDate));
        } catch (ParseException e) {
          // TODO Auto-generated catch block
          log.info(e);
        }
        
      }

      if (Validator.isNotNull(s_create_before)) {
        try {
          _searchDate = sdf.parse(s_create_before + " 23:59:59");
          conjunction.add(RestrictionsFactoryUtil.le("createDate", _searchDate));
        } catch (ParseException e) {
          // TODO Auto-generated catch block
          log.info(e);
        }
      }     
    }

    query.add(conjunction);

    entriesResults = LeadsLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
        searchContainer.getEnd());

    if (_getOnSearch()) {
      searchContainer.setTotal(LeadsLocalServiceUtil
          .dynamicQuery(query, QueryUtil.ALL_POS, LeadsLocalServiceUtil.getLeadsesCount()).size());
    } else {
      searchContainer.setTotal(LeadsLocalServiceUtil.getLeadsesCount());
    }

    searchContainer.setResults(entriesResults);
  }


}