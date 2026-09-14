<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/adaptive-media-image" prefix="liferay-adaptive-media" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher"%>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>

<!-- Service Util -->
<%@ page import="com.mypage.admin.product.service.MasterPromoCodeLocalServiceUtil" %>
<%@ page import="com.mypage.user.service.MypageUserLocalServiceUtil" %>
<%@ page import="com.mypage.user.service.MypageUserGroupLocalServiceUtil" %>
<%@ page import="com.mypage.agencyportal.service.AgentSalesToolsLocalServiceUtil" %>
<%@ page import="com.mypage.agencyportal.service.AgentCategorySalesToolsLocalServiceUtil" %>
<%@ page import="com.mypage.agencyportal.service.AgentCalendarLocalServiceUtil" %>

<!--  Model -->
<%@ page import="com.mypage.admin.product.model.MasterPromoCode" %>	
<%@ page import="com.mypage.user.model.MypageUser" %>
<%@ page import="com.mypage.user.model.MypageUserGroup" %>
<%@ page import="com.mypage.agencyportal.model.AgentSalesTools" %>
<%@ page import="com.mypage.agencyportal.model.AgentCategorySalesTools" %>
<%@ page import="com.mypage.agencyportal.model.AgentCalendar" %>
<%@ page import="com.mypage.agencyportal.model.AgentNotification" %>

<!-- Helper -->
<%@ page import="com.mypage.agencyportal.helpers.ActionHelpers" %>
<%@ page import="com.mypage.agencyportal.helpers.EncryptionHelper" %>

<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %>