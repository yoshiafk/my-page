<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>

<%@ taglib uri="http://liferay.com/tld/adaptive-media-image" prefix="liferay-adaptive-media" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%@ page import="com.mypage.admin.product.display.context.InternationalTravelStandardNewDisplayContext" %>
<%@ page import="com.mypage.admin.product.display.context.InternationalTravelStandardNewManagementToolbarDisplayContext" %>

<!-- Service Util -->
<%@ page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.IntTravelStandardNewPremiLocalServiceUtil" %>

<%@ page import="com.mypage.admin.product.service.BenefitLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.BenefitTypeLocalServiceUtil"%>

<%@ page import="com.mypage.admin.product.service.PlanLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.PremiLocalServiceUtil"%>

<%@ page import="com.mypage.admin.product.service.SmartTravelIntPlanLocalServiceUtil"%>


<!--  Model -->	
<%@ page import="com.mypage.admin.product.model.ProductConfiguration" %>
<%@ page import="com.mypage.admin.product.model.IntTravelStandardNewPremi" %>

<%@ page import="com.mypage.admin.product.model.Benefit"%>
<%@ page import="com.mypage.admin.product.model.BenefitType"%>

<%@ page import="com.mypage.admin.product.model.Plan"%>
<%@ page import="com.mypage.admin.product.model.SmartTravelIntPlan"%>
<%@ page import="com.mypage.admin.product.model.Premi"%>

<%@ page import="com.mypage.admin.product.model.SmartTravelIntLink"%>

<%@ page import="com.mypage.admin.product.model.BenefitValueMapping"%>
<%@ page import="com.mypage.admin.product.service.BenefitValueMappingLocalServiceUtil"%>

<%@ page import="com.mypage.admin.product.service.SmartTravelIntLinkLocalServiceUtil"%>

<!-- Display Context -->

<%@ page
	import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>
<%@ page
	import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.portlet.PortletURL"%>

<%@ page import="com.liferay.portal.kernel.portlet.PortletProviderUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletProvider" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<!-- Liferay API -->
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<!-- JAVA API -->
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="javax.portlet.PortletURL" %>

<%-- URL Configuration --%>
<portlet:renderURL var="configurationURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/configuration.jsp" />
</portlet:renderURL>

<%-- <portlet:renderURL var="premiURL"> 
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/premi/list.jsp" /> 
</portlet:renderURL> --%>


<!-- smart travel -->
<portlet:renderURL var="benefitTypeURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit_type/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBenefitTypeURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit_type/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBenefitType" var="addBenefitTypeURL" />

<portlet:renderURL var="benefitURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBenefitURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBenefit" var="addBenefitURL" />

<%-- Benefit Value Mapping --%>
<portlet:renderURL var="benefitValueMappingURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit_value_mapping/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBenefitValueMappingURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit_value_mapping/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBenefitValueMapping" var="addBenefitValueMappingURL" />

<portlet:renderURL var="planURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/plan/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPlanURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/plan/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPlan" var="addPlanURL" />

<portlet:renderURL var="premiURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/premi2/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPremiURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/premi2/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPremi" var="addPremiURL" />

<portlet:renderURL var="linkURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/link/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editLinkURL">
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/link/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addLink" var="addLinkURL" />