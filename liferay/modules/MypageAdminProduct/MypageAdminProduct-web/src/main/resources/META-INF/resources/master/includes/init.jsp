<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="http://liferay.com/tld/frontend"
	prefix="liferay-frontend"%>

<!-- Service Util -->
<%@ page
	import="com.mypage.admin.product.service.MasterCountryLocalServiceUtil"%>
<%@ page
	import="com.mypage.admin.product.service.MasterCurrencyLocalServiceUtil"%>
<%@ page
	import="com.mypage.admin.product.service.BlacklistCustomerLocalServiceUtil"%>
<%@ page
	import="com.mypage.admin.product.service.PromocodesLocalServiceUtil"%>
<%@ page
	import="com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil"%>
<%@ page
	import="com.mypage.admin.product.service.MasterProvinceLocalServiceUtil"%>
	<%@ page
	import="com.mypage.admin.product.service.MasterCityLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.IndustryCategoryLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.IndustryLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.JobPositionLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterBankLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.PaymentChannelLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.PaymentChannelTenorLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.ReferenceNumberLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterOccupationLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterOccupationCategoryLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.CompanyTypeLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterBranchLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil"%>
<%@ page import="com.mypage.admin.product.service.MasterPromoCodeLocalServiceUtil"%>

<!--  Model -->
<%@ page import="com.mypage.admin.product.model.MasterCountry"%>
<%@ page import="com.mypage.admin.product.model.MasterCurrency"%>
<%@ page import="com.mypage.admin.product.model.BlacklistCustomer"%>
<%@ page import="com.mypage.admin.product.model.Promocodes"%>
<%@ page import="com.mypage.admin.product.model.ProductConfiguration"%>
<%@ page import="com.mypage.admin.product.model.MasterProvince"%>
<%@ page import="com.mypage.admin.product.model.MasterCity"%>
<%@ page import="com.mypage.admin.product.model.IndustryCategory"%>
<%@ page import="com.mypage.admin.product.model.Industry"%>
<%@ page import="com.mypage.admin.product.model.JobPosition"%>
<%@ page import="com.mypage.admin.product.model.MasterBank"%>
<%@ page import="com.mypage.admin.product.model.PaymentChannel"%>
<%@ page import="com.mypage.admin.product.model.PaymentChannelTenor"%>
<%@ page import="com.mypage.admin.product.model.ReferenceNumber"%>
<%@ page import="com.mypage.admin.product.model.MasterOccupation"%>
<%@ page import="com.mypage.admin.product.model.MasterOccupationCategory"%>
<%@ page import="com.mypage.admin.product.model.CompanyType"%>
<%@ page import="com.mypage.admin.product.model.MasterBranch"%>
<%@ page import="com.mypage.admin.product.model.MasterGlobalVariable"%>
<%@ page import="com.mypage.admin.product.model.MasterPromoCode"%>

<!-- Display Context -->
<%@ page
	import="com.mypage.admin.product.display.context.MasterDisplayContext"%>
<%@ page
	import="com.mypage.admin.product.display.context.MasterManagementToolbarDisplayContext"%>

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
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.portlet.PortletURL"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.portlet.PortletProviderUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletProvider" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="countryURL">
	<portlet:param name="mvcPath" value="/master/country/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editCountryURL">
	<portlet:param name="mvcPath" value="/master/country/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addCountry" var="addCountryURL" />

<portlet:renderURL var="currencyURL">
	<portlet:param name="mvcPath" value="/master/currency/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editCurrencyURL">
	<portlet:param name="mvcPath" value="/master/currency/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addCurrency" var="addCurrencyURL" />

<portlet:renderURL var="blacklistCustomerURL">
	<portlet:param name="mvcPath"
		value="/master/blacklist_customer/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBlacklistCustomerURL">
	<portlet:param name="mvcPath"
		value="/master/blacklist_customer/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBlacklistCustomer"
	var="addBlacklistCustomerURL" />
	
<portlet:renderURL var="provinceURL">
	<portlet:param name="mvcPath" value="/master/province/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editProvinceURL">
	<portlet:param name="mvcPath" value="/master/province/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addProvince" var="addProvinceURL" />

<portlet:renderURL var="cityURL">
	<portlet:param name="mvcPath" value="/master/city/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editCityURL">
	<portlet:param name="mvcPath" value="/master/city/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addCity" var="addCityURL" />

<portlet:renderURL var="promocodeURL">
	<portlet:param name="mvcPath" value="/master/promocode/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPromocodeURL">
	<portlet:param name="mvcPath" value="/master/promocode/edit.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addPromocode"
	var="addPromocodeURL" />
	
<portlet:renderURL var="industryCategoryURL">
	<portlet:param name="mvcPath" value="/master/industry_category/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editIndustryCategoryURL">
	<portlet:param name="mvcPath" value="/master/industry_category/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addIndustryCategory" var="addIndustryCategoryURL" />

<portlet:renderURL var="industryURL">
	<portlet:param name="mvcPath" value="/master/industry/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editIndustryURL">
	<portlet:param name="mvcPath" value="/master/industry/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addIndustry" var="addIndustryURL" />

<portlet:renderURL var="jobPositionURL">
	<portlet:param name="mvcPath" value="/master/job_position/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editJobPositionURL">
	<portlet:param name="mvcPath" value="/master/job_positiony/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addJobPosition" var="addJobPositionURL" />

<portlet:renderURL var="bankURL">
	<portlet:param name="mvcPath" value="/master/bank/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBankURL">
	<portlet:param name="mvcPath" value="/master/bank/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBank" var="addBankURL" />

<portlet:renderURL var="paymentchannelURL">
	<portlet:param name="mvcPath" value="/master/paymentchannel/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editPaymentchannelURL">
	<portlet:param name="mvcPath" value="/master/paymentchannel/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addPaymentChannel" var="addPaymentchannelURL" />

<portlet:renderURL var="referenceNumberURL">
	<portlet:param name="mvcPath" value="/master/reference_number/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editReferenceNumberURL">
	<portlet:param name="mvcPath" value="/master/reference_number/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addReferenceNumber" var="addReferenceNumberURL" />

<portlet:renderURL var="occupationURL">
	<portlet:param name="mvcPath" value="/master/occupation/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editOccupationURL">
	<portlet:param name="mvcPath" value="/master/occupation/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addOccupation" var="addOccupationURL" />

<portlet:renderURL var="occupationCategoryURL">
	<portlet:param name="mvcPath" value="/master/occupation_category/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editOccupationCategoryURL">
	<portlet:param name="mvcPath" value="/master/occupation_category/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addOccupationCategory" var="addOccupationCategoryURL" />

<portlet:renderURL var="companyTypeURL">
	<portlet:param name="mvcPath" value="/master/company_type/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editCompanyTypeURL">
	<portlet:param name="mvcPath" value="/master/company_type/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addCompanyType" var="addCompanyTypeURL" />

<portlet:renderURL var="branchURL">
	<portlet:param name="mvcPath" value="/master/branch/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editBranchURL">
	<portlet:param name="mvcPath" value="/master/branch/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addBranch" var="addBranchURL" />

<portlet:renderURL var="globalVariableURL">
	<portlet:param name="mvcPath" value="/master/global_variable/list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editGlobalVariableURL">
	<portlet:param name="mvcPath" value="/master/global_variable/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addGlobalVariable" var="addGlobalVariableURL" />
