<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<!-- Service Util -->
<%@ page import="com.mypage.leads.service.LeadsLocalServiceUtil" %>
<%@ page import="com.mypage.leads.service.PaymentLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.PaymentChannelLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil"%>
<%@ page import="com.mypage.leads.service.DetailDomesticTravelLocalServiceUtil"%>
<%@ page import="com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil"%>
<%@ page import="com.mypage.leads.service.DetailHealthIndividuLocalServiceUtil"%>
<%@ page import="com.mypage.leads.service.DetailPetLocalServiceUtil"%>
<%@ page import="com.mypage.leads.service.CustomerLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.TravelDomesticPlanLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.MasterCountryLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterProvinceLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterCityLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.TravelDomesticInsuredTypeLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.MasterCurrencyLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.PetAnimalTypeLocalServiceUtil"%>
<%@ page import="com.mypage.user.service.MypageUserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<!--  Model -->
<%@ page import="com.mypage.leads.model.Leads" %>
<%@ page import="com.mypage.leads.model.Payment" %>
<%@ page import="com.mypage.admin.product.model.PaymentChannel" %>
<%@ page import="com.mypage.admin.product.model.ProductConfiguration"%>
<%@ page import="com.mypage.leads.model.DetailDomesticTravel"%>
<%@ page import="com.mypage.leads.model.DetailInternationalTravel"%>
<%@ page import="com.mypage.leads.model.DetailHealthIndividu"%>
<%@ page import="com.mypage.leads.model.DetailPet"%>
<%@ page import="com.mypage.leads.model.Customer"%>
<%@ page import="com.mypage.admin.product.model.TravelDomesticPlan" %>
<%@ page import="com.mypage.admin.product.model.MasterCountry"%>
<%@ page import="com.mypage.admin.product.model.MasterProvince"%>
<%@ page import="com.mypage.admin.product.model.MasterCity"%>
<%@ page import="com.mypage.admin.product.model.TravelDomesticInsuredType" %>
<%@ page import="com.mypage.admin.product.model.MasterCurrency"%>
<%@ page import="com.mypage.admin.product.model.PetAnimalType"%>
<%@ page import="com.mypage.user.model.MypageUser"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>

<!-- Display Context -->
<%@ page import="com.mypage.leads.display.context.LeadsDisplayContext" %>
<%@ page import="com.mypage.leads.display.context.LeadsManagementToolbarDisplayContext" %>
<%@ page import="com.mypage.leads.display.context.PaymentDisplayContext" %>
<%@ page import="com.mypage.leads.display.context.PaymentManagementToolbarDisplayContext" %>

<!-- Libraries Etc -->
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletProviderUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletProvider" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.time.LocalDate"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>


<%@ page import="com.mypage.leads.web.internal.security.permission.resource.LeadsPermission" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>


<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="parentsURL">
	<portlet:param name="mvcPath" value="/parents/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editParentsURL">
	<portlet:param name="mvcPath" value="/parents/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addLeads" var="addLeadsURL" />

<portlet:renderURL var="paymentURL">
	<portlet:param name="mvcPath" value="/payment/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPaymentURL">
	<portlet:param name="mvcPath" value="/payment/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPayment" var="addPaymentURL" />
