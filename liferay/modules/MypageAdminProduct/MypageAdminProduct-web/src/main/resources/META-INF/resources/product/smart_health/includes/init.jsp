<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>


<%-- Display Context --%>
<%@ page import="com.mypage.admin.product.display.context.SmartHealthDisplayContext" %>
<%@ page import="com.mypage.admin.product.display.context.SmartHealthManagementToolbarDisplayContext" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%-- Model --%>
<%@ page import="com.mypage.admin.product.model.ProductConfiguration"%>
<%@ page import="com.mypage.admin.product.model.SmartHealthPlan"%>
<%@ page import="com.mypage.admin.product.model.SmartHealthPremi"%>
<%@ page import="com.mypage.admin.product.model.SmartHealthBenefitGroup"%>
<%@ page import="com.mypage.admin.product.model.SmartHealthBenefit"%>

<%-- Service Util --%>
<%@ page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.SmartHealthPlanLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.SmartHealthPremiLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.SmartHealthBenefitGroupLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.SmartHealthBenefitLocalServiceUtil"%>

<%-- JAVA Lib --%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>

<%-- JAVAX --%>
<%@ page import="javax.portlet.PortletURL"%>

<%-- Liferay API --%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>


<portlet:renderURL var="configurationURL">
	<portlet:param name="mvcPath" value="/product/smart_health/configuration.jsp" />
</portlet:renderURL>
<portlet:renderURL var="planURL">
	<portlet:param name="mvcPath" value="/product/smart_health/plan/list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editPlanURL">
	<portlet:param name="mvcPath" value="/product/smart_health/plan/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addPlan" var="addPlanURL" />

<portlet:renderURL var="premiURL">
	<portlet:param name="mvcPath" value="/product/smart_health/premi/list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editPremiURL">
	<portlet:param name="mvcPath" value="/product/smart_health/premi/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addPremi" var="addPremiURL" />

<%-- BENEFIT --%>
<portlet:renderURL var="benefitURL">
	<portlet:param name="mvcPath" value="/product/smart_health/benefit/list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editBenefitURL">
	<portlet:param name="mvcPath" value="/product/smart_health/benefit/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addBenefit" var="addBenefitURL" />

<portlet:renderURL var="benefitGroupURL">
	<portlet:param name="mvcPath" value="/product/smart_health/benefit_group/list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editBenefitGroupURL">
	<portlet:param name="mvcPath" value="/product/smart_health/benefit_group/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addBenefitGroup" var="addBenefitGroupURL" />