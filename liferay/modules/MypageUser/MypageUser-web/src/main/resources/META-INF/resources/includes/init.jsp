<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/item-selector" prefix="liferay-item-selector" %>

<!-- Service Util -->
<%@ page import="com.mypage.user.service.MypageUserLocalServiceUtil"%>
<%@ page import="com.mypage.user.service.MypageUserGracePeriodLocalServiceUtil"%>
<%@ page import="com.mypage.user.service.MypageUserWorkingHourLocalServiceUtil"%>
<%@ page import="com.mypage.user.service.CreditTypeLocalServiceUtil"%>
<%@ page import="com.mypage.user.service.CreditWalletLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterCountryLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterProvinceLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterCityLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterBranchLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@ page import="com.mypage.user.service.UserRegistrationLocalServiceUtil" %>
<%@ page import="com.mypage.user.service.MypageUserTimelineLocalServiceUtil"%>
<%@ page import="com.mypage.user.service.MypageUserRoleLocalServiceUtil"%>
<%@ page import="com.mypage.user.service.MypageUserGroupLocalServiceUtil"%>

<!--  Model -->
<%@ page import="com.mypage.user.model.MypageUser"%>
<%@ page import="com.mypage.user.model.MypageUserGracePeriod"%>
<%@ page import="com.mypage.user.model.MypageUserWorkingHour"%>
<%@ page import="com.mypage.user.model.CreditType"%>
<%@ page import="com.mypage.user.model.CreditWallet"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.mypage.admin.product.model.MasterCountry"%>
<%@ page import="com.mypage.admin.product.model.MasterProvince"%>
<%@ page import="com.mypage.admin.product.model.MasterCity"%>
<%@ page import="com.mypage.admin.product.model.ProductConfiguration"%>
<%@ page import="com.mypage.admin.product.model.MasterBranch"%>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.mypage.user.model.UserRegistration"%>
<%@ page import="com.mypage.user.model.MypageUserTimeline"%>
<%@ page import="com.mypage.user.model.MypageUserRole"%>
<%@ page import="com.mypage.user.model.MypageUserGroup"%>

<!-- Display Context -->
<%@ page import="com.mypage.user.display.context.MypageUserDisplayContext"%>
<%@ page import="com.mypage.user.display.context.MypageUserManagementToolbarDisplayContext"%>
<%@ page import="com.mypage.user.display.context.UserCreditDisplayContext"%>
<%@ page import="com.mypage.user.display.context.UserCreditManagementToolbarDisplayContext"%>
<%@ page import="com.mypage.user.display.context.UserRegistrationDisplayContext"%>
<%@ page import="com.mypage.user.display.context.UserRegistrationManagementToolbarDisplayContext"%>
<%@ page import="com.mypage.user.display.context.UserRoleDisplayContext"%>
<%@ page import="com.mypage.user.display.context.UserRoleManagementToolbarDisplayContext"%>
<%@ page import="com.mypage.user.display.context.UserGroupDisplayContext"%>
<%@ page import="com.mypage.user.display.context.UserGroupManagementToolbarDisplayContext"%>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.DayOfWeek"%>
<%@ page import="java.time.format.TextStyle"%>
<%@ page import="java.util.Locale"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="com.liferay.roles.admin.kernel.util.RolesAdminUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletProviderUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletProvider" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.mypage.user.display.context.InitDisplayContext" %>
<%@ page import="com.liferay.portal.kernel.security.membershippolicy.RoleMembershipPolicyUtil" %>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %>

<!-- PERMISSION -->
<%@ page import="com.mypage.user.service.permission.MypageUserModelPermission" %>
<%@ page import="com.mypage.user.service.permission.MypageUserPermission" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>

<!-- EXCEPTION -->
<%@ page import="com.liferay.portal.kernel.exception.UserPasswordException" %>
<%@ page import="com.liferay.portal.kernel.exception.UserScreenNameException" %>
<%@ page import="com.liferay.portal.kernel.exception.UserEmailAddressException" %>
<%@ page import="com.mypage.user.exception.MypageUserException" %>


<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="userURL">
	<portlet:param name="mvcPath" value="/user/list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editUserURL">
	<portlet:param name="mvcPath" value="/user/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addUser" var="addUserURL" />

<portlet:renderURL var="creditTypeURL">
	<portlet:param name="mvcPath" value="/user_credit/credit_type/list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editCreditTypeURL">
	<portlet:param name="mvcPath" value="/user_credit/credit_type/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addCreditType" var="addCreditTypeURL" />

<portlet:renderURL var="creditWalletURL">
	<portlet:param name="mvcPath" value="/user_credit/credit_wallet/list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editCreditWalletURL">
	<portlet:param name="mvcPath" value="/user_credit/credit_wallet/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addWalletType" var="addCreditWalletURL" />

<portlet:renderURL var="userRegistrationURL">
	<portlet:param name="mvcPath" value="/user_registration/list.jsp" />
</portlet:renderURL>
<portlet:renderURL var="editUserRegistrationURL">
	<portlet:param name="mvcPath" value="/user_registration/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addUserRegistration" var="addUserRegistrationURL" />
<portlet:actionURL name="approveUserRegistration" var="approveUserRegistrationURL" />
<portlet:actionURL name="addCreditWallet" var="addCreditWalletURL" />

<portlet:renderURL var="userRoleURL">
	<portlet:param name="mvcPath" value="/user_role/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editUserRoleURL">
	<portlet:param name="mvcPath" value="/user_role/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addUserRole" var="addUserRoleURL" />

<portlet:renderURL var="userGroupURL">
	<portlet:param name="mvcPath" value="/user_group/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editUserGroupURL">
	<portlet:param name="mvcPath" value="/user_group/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addUserGroup" var="addUserGroupURL" />
