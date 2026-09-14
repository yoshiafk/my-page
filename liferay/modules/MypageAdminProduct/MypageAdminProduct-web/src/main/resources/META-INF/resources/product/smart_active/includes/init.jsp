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

<!-- Display Context -->
<%@ page import="com.mypage.admin.product.display.context.SmartActiveDisplayContext" %>
<%@ page import="com.mypage.admin.product.display.context.SmartActiveManagementToolbarDisplayContext" %>

<!-- Service Util -->
<%@ page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveBenefitLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveBenefitTypeLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveBenefitValueLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveBenefitValueMappingLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActivePremiLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveLinkLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveClassRateLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveOccupationLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveToproLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveToproBenefitMappingLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.SmartActiveFeatureLocalServiceUtil" %>

<!--  Model -->	
<%@ page import="com.mypage.admin.product.model.ProductConfiguration" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveBenefit" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveBenefitType" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveBenefitValue" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveBenefitValueMapping" %>
<%@ page import="com.mypage.admin.product.model.SmartActivePremi" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveLink" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveClassRate" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveOccupation" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveTopro" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveToproBenefitMapping" %>
<%@ page import="com.mypage.admin.product.model.SmartActiveFeature" %>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList" %>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="com.liferay.portal.kernel.portlet.PortletProviderUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletProvider" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<!-- Liferay API -->
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<!-- JAVA API -->
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="javax.portlet.PortletURL" %>

<%-- URL Configuration --%>
<portlet:renderURL var="configurationURL">
	<portlet:param name="mvcPath" value="/product/smart_active/configuration.jsp" />
</portlet:renderURL>

<%-- Class Rate --%>
<portlet:renderURL var="classRateURL">
	<portlet:param name="mvcPath" value="/product/smart_active/class_rate/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editClassRateURL">
	<portlet:param name="mvcPath" value="/product/smart_active/class_rate/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addClassRate" var="addClassRateURL" />

<%-- Occupation --%>
<portlet:renderURL var="occupationURL">
	<portlet:param name="mvcPath" value="/product/smart_active/occupation/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editOccupationURL">
	<portlet:param name="mvcPath" value="/product/smart_active/occupation/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addOccupation" var="addOccupationURL" />

<%-- Topro --%>
<portlet:renderURL var="toproURL">
	<portlet:param name="mvcPath" value="/product/smart_active/topro/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editToproURL">
	<portlet:param name="mvcPath" value="/product/smart_active/topro/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addTopro" var="addToproURL" />

<%-- Topro Benefit Mapping --%>
<portlet:renderURL var="toproBenefitMappingURL">
	<portlet:param name="mvcPath" value="/product/smart_active/topro_benefit_mapping/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editToproBenefitMappingURL">
	<portlet:param name="mvcPath" value="/product/smart_active/topro_benefit_mapping/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addToproBenefitMapping" var="addToproBenefitMappingURL" />

<%-- Premi --%>
<portlet:renderURL var="premiURL">
	<portlet:param name="mvcPath" value="/product/smart_active/premi/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPremiURL">
	<portlet:param name="mvcPath" value="/product/smart_active/premi/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPremi" var="addPremiURL" />

<%-- Features --%>
<portlet:renderURL var="featureURL">
	<portlet:param name="mvcPath" value="/product/smart_active/feature/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editFeatureURL">
	<portlet:param name="mvcPath" value="/product/smart_active/feature/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addFeature" var="addFeatureURL" />

<%-- Files --%>
<portlet:renderURL var="fileURL">
	<portlet:param name="mvcPath" value="/product/smart_active/link/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editFileURL">
	<portlet:param name="mvcPath" value="/product/smart_active/link/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addFile" var="addFileURL" />

<%-- Benefit Type Configuration --%>
<portlet:renderURL var="benefitTypeURL">
	<portlet:param name="mvcPath" value="/product/smart_active/benefit_type/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBenefitTypeURL">
	<portlet:param name="mvcPath" value="/product/smart_active/benefit_type/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBenefitType" var="addBenefitTypeURL" />

<%-- Benefit Configuration --%>
<portlet:renderURL var="benefitURL">
	<portlet:param name="mvcPath" value="/product/smart_active/benefit/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBenefitURL">
	<portlet:param name="mvcPath" value="/product/smart_active/benefit/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBenefit" var="addBenefitURL" />

<%-- Benefit Value --%>
<portlet:renderURL var="benefitValueURL">
	<portlet:param name="mvcPath" value="/product/smart_active/benefit_value/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBenefitValueURL">
	<portlet:param name="mvcPath" value="/product/smart_active/benefit_value/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBenefitValue" var="addBenefitValueURL" />

<%-- Benefit Value Mapping --%>
<portlet:renderURL var="benefitValueMappingURL">
	<portlet:param name="mvcPath" value="/product/smart_active/benefit_value_mapping/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBenefitValueMappingURL">
	<portlet:param name="mvcPath" value="/product/smart_active/benefit_value_mapping/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBenefitValueMapping" var="addBenefitValueMappingURL" />