<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Service Util -->
<%@ page
	import="com.mypage.agencyportal.service.AgentCalendarLocalServiceUtil"%>
<%@ page
	import="com.mypage.user.service.MypageUserRoleLocalServiceUtil"%>
<%@ page
	import="com.mypage.user.service.MypageUserGroupLocalServiceUtil"%>
	
<!--  Model -->
<%@ page import="com.mypage.agencyportal.model.AgentCalendar"%>
<%@ page import="com.mypage.user.model.MypageUserRole"%>
<%@ page import="com.mypage.user.model.MypageUserGroup"%>

<!-- Display Context -->
<%@ page
	import="com.mypage.agencyportal.display.context.CalendarDisplayContext"%>
<%@ page
	import="com.mypage.agencyportal.display.context.CalendarManagementToolbarDisplayContext"%>

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
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.portlet.PortletURL"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="agentCalendarURL">
	<portlet:param name="mvcPath" value="/dashboard/calendar/master/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editAgentCalendarURL">
	<portlet:param name="mvcPath" value="/dashboard/calendar/master/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addCalendar" var="addAgentCalendarURL" />
