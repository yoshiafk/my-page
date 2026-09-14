<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
	
<!-- Service Util -->
<%@ page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.PetPlanLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.PetRemarksLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.PetRateLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.PetAnimalTypeLocalServiceUtil"%>

<!--  Model -->	
<%@ page import="com.mypage.admin.product.model.ProductConfiguration" %>
<%@ page import="com.mypage.admin.product.model.PetPlan"%>
<%@ page import="com.mypage.admin.product.model.PetRemarks"%>
<%@ page import="com.mypage.admin.product.model.PetRate"%>
<%@ page import="com.mypage.admin.product.model.PetAnimalType"%>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.petra.string.StringPool"%>
<%@ page import="com.liferay.portal.kernel.model.PersistedModel"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@ page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker"%>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList"%>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu"%>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPViewTypeItemList"%>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainerResults"%>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>

<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.Criterion"%>

<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/adaptive-media-image" prefix="liferay-adaptive-media" %>

<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%--<%@ page import="com.mypage.admin.product.misc.PetPlanDisplayTerms"%>--%>


<!-- DISPLAY CONTEXT -->
<%@ page import="com.mypage.admin.product.display.context.PetDisplayContext"%>
<%@ page import="com.mypage.admin.product.display.context.PetManagementToolbarDisplayContext"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%-- URL Configuration --%>
<portlet:renderURL var="configurationURL">
	<portlet:param name="mvcPath" value="/product/pet/configuration.jsp" />
</portlet:renderURL>

<%-- PLAN --%>
<portlet:renderURL var="planURL">
	<portlet:param name="mvcPath" value="/product/pet/plan/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPlanURL">
	<portlet:param name="mvcPath" value="/product/pet/plan/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPlan" var="addPlanURL" />
<%-- PLAN --%>

<!--  REMARKS  -->
<portlet:renderURL var="remarksURL">
	<portlet:param name="mvcPath" value="/product/pet/remarks/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editRemarksURL">
	<portlet:param name="mvcPath" value="/product/pet/remarks/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addRemarks" var="addRemarksURL" />
<!--  REMARKS  -->

<!-- RATE -->
<portlet:renderURL var="rateURL">
	<portlet:param name="mvcPath" value="/product/pet/rate/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editRateURL">
	<portlet:param name="mvcPath" value="/product/pet/rate/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addRate" var="addRateURL" />
<!-- RATE -->

<!-- ANIMAL TYPE -->
<portlet:renderURL var="animalTypeURL">
	<portlet:param name="mvcPath" value="/product/pet/animal_type/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editAnimalTypeURL">
	<portlet:param name="mvcPath" value="/product/pet/animal_type/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addAnimalType" var="addAnimalTypeURL" />
<!-- ANIMAL TYPE -->

<portlet:renderURL var="emailTemplateURL">
	<portlet:param name="mvcPath" value="/product/pet/email_template.jsp" />
</portlet:renderURL>