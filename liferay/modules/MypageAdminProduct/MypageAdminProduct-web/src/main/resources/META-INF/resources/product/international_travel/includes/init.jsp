<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>


<%@ page import="com.mypage.admin.product.display.context.InternationalTravelDisplayContext" %>
<%@ page import="com.mypage.admin.product.display.context.InternationalTravelManagementToolbarDisplayContext" %>
	
<!-- Service Util -->
<%@ page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil" %>
<%@ page import="com.mypage.admin.product.service.TravelInternationalPremiLocalServiceUtil" %>

<!--  Model -->	
<%@ page import="com.mypage.admin.product.model.ProductConfiguration" %>
<%@ page import="com.mypage.admin.product.model.TravelInternationalPremi" %>

<!-- Liferay API -->
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<!-- JAVA API -->
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="javax.portlet.PortletURL" %>


<%@ taglib uri="http://liferay.com/tld/adaptive-media-image" prefix="liferay-adaptive-media" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%-- URL Configuration --%>
<portlet:renderURL var="configurationURL">
	<portlet:param name="mvcPath" value="/product/international_travel/configuration.jsp" />
</portlet:renderURL>

<portlet:renderURL var="premiURL"> 
	<portlet:param name="mvcPath" value="/product/international_travel/premi/list.jsp" /> 
</portlet:renderURL>