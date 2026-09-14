<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java"%>
<%@ page import="java.util.regex.Matcher"%>
<%@ page import="java.util.regex.Pattern"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ page import="com.mypage.admin.product.model.MasterGlobalVariable" %>
<%@page import="com.mypage.admin.product.model.ProductConfiguration"%>
<%@page import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil"%>

<%@ page import="com.mypage.admin.product.model.BenefitType"%>
<%@ page import="com.mypage.admin.product.model.Benefit"%>

<%@ page import="com.mypage.leads.model.Leads"%>
<%@ page import="com.mypage.leads.model.DetailInternationalTravel"%>

<%@ page import="com.mypage.leads.service.LeadsLocalServiceUtil"%>
<%@ page import="com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil"%>

<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.mypage.admin.product.service.BenefitTypeLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.BenefitLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.model.BenefitValueMapping"%>
<%@ page import="com.mypage.admin.product.service.BenefitValueMappingLocalServiceUtil"%>

<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat;"%>