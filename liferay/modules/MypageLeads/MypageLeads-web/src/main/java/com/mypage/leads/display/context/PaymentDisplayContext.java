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
import com.mypage.leads.model.Payment;
import com.mypage.leads.service.PaymentLocalServiceUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class PaymentDisplayContext {
  private static final Log log = LogFactoryUtil.getLog(PaymentDisplayContext.class);
  private final HttpServletRequest _httpServletRequest;
  private final LiferayPortletRequest _liferayPortletRequest;
  private final LiferayPortletResponse _liferayPortletResponse;
  private final PortalPreferences _portalPreferences;
  private String _mvcPath;
  
  public PaymentDisplayContext(LiferayPortletRequest liferayPortletRequest,
      LiferayPortletResponse liferayPortletResponse) {

    _liferayPortletRequest = liferayPortletRequest;
    _liferayPortletResponse = liferayPortletResponse;
    _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
    _httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

    _mvcPath = ParamUtil.getString(_httpServletRequest, "mvcPath", "/payment/list.jsp");
  }

  /**
   * State for collapsible panel wether collapsed or expanded by detect current
   * active field
   */
  public boolean _getOnSearch() {
    if (_getPageType().equalsIgnoreCase("payment")) {
    	String s_LeadsId= ParamUtil.getString(_httpServletRequest, "s_LeadsId", "");
        String s_TransactionId= ParamUtil.getString(_httpServletRequest, "s_TransactionId", "");
        String s_PaymentStatus= ParamUtil.getString(_httpServletRequest, "s_PaymentStatus", "");
        String s_PaymentChannelId= ParamUtil.getString(_httpServletRequest, "s_PaymentChannelId", "");
        String s_PaymentMessage= ParamUtil.getString(_httpServletRequest, "s_PaymentMessage", "");
        String s_TransactionDateTime= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTime", "");
        String s_TransactionDateTimeAfter= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTimeAfter", "");
        String s_TransactionDateTimeBefore= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTimeBefore", "");

      if (
    		  !s_LeadsId.isEmpty()
    		  || !s_TransactionId.isEmpty()
    		  || !s_PaymentStatus.isEmpty()
    		  || !s_PaymentChannelId.isEmpty()
    		  || !s_PaymentMessage.isEmpty()
    		  || !s_TransactionDateTime.isEmpty()
    		  || !s_TransactionDateTimeAfter.isEmpty()
    		  || !s_TransactionDateTimeBefore.isEmpty()
    	) {
        return true;
      }
    }
    return false;
  }

  /**
   * Order by Col Default
   */
  private String _orderByColDefault() {
    if (_getPageType().equals("payment")) {
      return "paymentId";
    }

    return null;
  }

  // Get Page Type
  private String _getPageType() {
    if (_mvcPath.equals("/payment/list.jsp")) {
      return "payment";
    }
    
    // default
    return "payment";
  }

  @SuppressWarnings("deprecation")
  private PortletURL _iteratorURL() {
    PortletURL portletURL = _liferayPortletResponse.createRenderURL();
    portletURL.setParameter("mvcPath", _mvcPath);

    String delta = ParamUtil.getString(_httpServletRequest, "delta");
    portletURL.setParameter("delta", delta);

    if (_getPageType().equals("payment")) {
    	String s_LeadsId= ParamUtil.getString(_httpServletRequest, "s_LeadsId", "");
        String s_TransactionId= ParamUtil.getString(_httpServletRequest, "s_TransactionId", "");
        String s_PaymentStatus= ParamUtil.getString(_httpServletRequest, "s_PaymentStatus", "");
        String s_PaymentChannelId= ParamUtil.getString(_httpServletRequest, "s_PaymentChannelId", "");
        String s_PaymentMessage= ParamUtil.getString(_httpServletRequest, "s_PaymentMessage", "");
        String s_TransactionDateTime= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTime", "");
        String s_TransactionDateTimeAfter= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTimeAfter", "");
        String s_TransactionDateTimeBefore= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTimeBefore", "");

      portletURL.setParameter("s_LeadsId", s_LeadsId);
      portletURL.setParameter("s_TransactionId", s_TransactionId);
      portletURL.setParameter("s_PaymentStatus", s_PaymentStatus);
      portletURL.setParameter("s_PaymentChannelId", s_PaymentChannelId);
      portletURL.setParameter("s_PaymentMessage", s_PaymentMessage);
      portletURL.setParameter("s_TransactionDateTime", s_TransactionDateTime);
      portletURL.setParameter("s_TransactionDateTimeAfter", s_TransactionDateTimeAfter);
      portletURL.setParameter("s_TransactionDateTimeBefore", s_TransactionDateTimeBefore);
    }

    return portletURL;
  }
  
  /**
   * Promocodes Search Container
   */
  public SearchContainer paymentSearchContainer() throws PortalException, PortletException {
    PortletURL portletURL = _liferayPortletResponse.createRenderURL();
    portletURL.setParameter("mvcPath", _mvcPath);

    SearchContainer<Payment> entriesSearchContainer = new SearchContainer<>(_liferayPortletRequest,
        PortletURLUtil.clone(portletURL, _liferayPortletResponse), null, "no-entries-were-found");

    String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", _orderByColDefault());
    entriesSearchContainer.setOrderByCol(orderByCol);

    String ascOrDesc = !orderByCol.equalsIgnoreCase("paymentId") ? "asc" : "desc";
    String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
    entriesSearchContainer.setOrderByType(orderByType);

    int delta = ParamUtil.getInteger(_httpServletRequest, "delta", entriesSearchContainer.getDelta());
    entriesSearchContainer.setDelta(delta);

    entriesSearchContainer.setIteratorURL(_iteratorURL());

    entriesSearchContainer.setRowChecker(new EmptyOnClickRowChecker(_liferayPortletResponse));

    _populateResultsPayment(entriesSearchContainer);

    return entriesSearchContainer;
  }

  // Master promocodes Populate Results
  private void _populateResultsPayment(SearchContainer searchContainer) throws PortalException {

    String orderByCol = ParamUtil.getString(_httpServletRequest, "orderByCol", "paymentId");
    String ascOrDesc = !orderByCol.equalsIgnoreCase("paymentId") ? "asc" : "desc";
    String orderByType = ParamUtil.getString(_httpServletRequest, "orderByType", ascOrDesc);
    String keywords = ParamUtil.getString(_httpServletRequest, "keywords");
    String filterByCol = ParamUtil.getString(_httpServletRequest, "filterByCol");

    // Advanced Search
    String s_LeadsId= ParamUtil.getString(_httpServletRequest, "s_LeadsId", "");
    String s_TransactionId= ParamUtil.getString(_httpServletRequest, "s_TransactionId", "");
    String s_PaymentStatus= ParamUtil.getString(_httpServletRequest, "s_PaymentStatus", "");
    String s_PaymentChannelId= ParamUtil.getString(_httpServletRequest, "s_PaymentChannelId", "");
    String s_PaymentMessage= ParamUtil.getString(_httpServletRequest, "s_PaymentMessage", "");
    String s_TransactionDateTime= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTime", "");
    String s_TransactionDateTimeAfter= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTimeAfter", "");
    String s_TransactionDateTimeBefore= ParamUtil.getString(_httpServletRequest, "s_TransactionDateTimeBefore", "");

    List entriesResults = null;
    DynamicQuery query = PaymentLocalServiceUtil.dynamicQuery();
    
    query.addOrder(
        orderByType.equals("asc") ? OrderFactoryUtil.asc(orderByCol) : OrderFactoryUtil.desc(orderByCol));

    Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
    
    if (Validator.isNotNull(s_LeadsId)) {
        conjunction.add(RestrictionsFactoryUtil.eq("LeadsId", Long.parseLong(s_LeadsId)));
    }
    
    if (Validator.isNotNull(s_TransactionId)) {
        conjunction.add(RestrictionsFactoryUtil.ilike("TransactionId", "%" + s_TransactionId + "%"));
    }
    
    if (Validator.isNotNull(s_PaymentStatus)) {
        conjunction.add(RestrictionsFactoryUtil.ilike("PaymentStatus", s_PaymentStatus));
    }
    
    if (Validator.isNotNull(s_PaymentChannelId)) {
        conjunction.add(RestrictionsFactoryUtil.eq("PaymentChannelId", Long.parseLong(s_PaymentChannelId)));
    }
    
    if (Validator.isNotNull(s_PaymentMessage)) {
        conjunction.add(RestrictionsFactoryUtil.ilike("PaymentMessage", "%" + s_PaymentMessage + "%"));
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date _searchDate;
    if (Validator.isNotNull(s_TransactionDateTime)) {
      try {
        _searchDate = sdf.parse(s_TransactionDateTime + " 00:00:01");
        conjunction.add(RestrictionsFactoryUtil.ge("createDate", _searchDate));
        
        _searchDate = sdf.parse(s_TransactionDateTime + " 23:59:59");
        conjunction.add(RestrictionsFactoryUtil.le("TransactionDateTime", _searchDate));
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        log.info(e);
      }
    }else {
      if (Validator.isNotNull(s_TransactionDateTimeAfter)) {
        try {
          _searchDate = sdf.parse(s_TransactionDateTimeAfter + " 00:00:01");
          conjunction.add(RestrictionsFactoryUtil.ge("TransactionDateTime", _searchDate));
        } catch (ParseException e) {
          // TODO Auto-generated catch block
          log.info(e);
        }
        
      }

      if (Validator.isNotNull(s_TransactionDateTimeBefore)) {
        try {
          _searchDate = sdf.parse(s_TransactionDateTimeBefore + " 23:59:59");
          conjunction.add(RestrictionsFactoryUtil.le("TransactionDateTime", _searchDate));
        } catch (ParseException e) {
          // TODO Auto-generated catch block
          log.info(e);
        }
      }     
    }

    query.add(conjunction);

    entriesResults = PaymentLocalServiceUtil.dynamicQuery(query, searchContainer.getStart(),
        searchContainer.getEnd());

    if (_getOnSearch()) {
      searchContainer.setTotal(PaymentLocalServiceUtil
          .dynamicQuery(query, QueryUtil.ALL_POS, PaymentLocalServiceUtil.getPaymentsCount()).size());
    } else {
      searchContainer.setTotal(PaymentLocalServiceUtil.getPaymentsCount());
    }

    searchContainer.setResults(entriesResults);
  }
}
