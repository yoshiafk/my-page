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
<%@ page import="com.mypage.admin.product.display.context.PersonalAccidentDisplayContext" %>
<%@ page import="com.mypage.admin.product.display.context.PersonalAccidentManagementToolbarDisplayContext" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%-- Model --%>
<%@ page import="com.mypage.admin.product.model.ProductConfiguration"%>
<%@ page import="com.mypage.admin.product.model.PersonalAccidentPremi"%>

<%-- Service Util --%>
<%@ page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.PersonalAccidentPremiLocalServiceUtil"%>

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
	<portlet:param name="mvcPath" value="/product/personal_accident/configuration.jsp" />
</portlet:renderURL>

<portlet:renderURL var="webContentURL">
	<portlet:param name="mvcPath" value="/product/personal_accident/web_content/configuration.jsp" />
</portlet:renderURL>

<portlet:renderURL var="premiURL">
	<portlet:param name="mvcPath" value="/product/personal_accident/premi/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPremiURL">
	<portlet:param name="mvcPath" value="/product/personal_accident/premi/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPremi" var="addPremiURL" />