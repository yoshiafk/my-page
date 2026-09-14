<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<!-- Display Context -->
<%@ page import="com.aii.esppk.admin.display.context.UserEsppkDisplayContext"%>
<%@ page import="com.aii.esppk.admin.display.context.UserEsppkManagementToolbarDisplayContext"%>

<!--  Model -->
<%@ page import="com.aii.esppk.admin.model.SppkUser"%>

<%@ page import="com.aii.esppk.admin.service.SppkUserLocalServiceUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<portlet:renderURL var="sppkUserUrl">
	<portlet:param name="mvcPath" value="/user/list.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addSppkUser" var="addSppkUserURL" />