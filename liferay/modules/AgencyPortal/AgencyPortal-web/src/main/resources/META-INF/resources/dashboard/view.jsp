<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page
	import="com.mypage.user.service.MypageUserTimelineLocalServiceUtil"%>
<%@page import="com.mypage.user.model.MypageUserTimeline"%>
<%@page
	import="com.mypage.user.service.MypageUserWorkingHourLocalServiceUtil"%>
<%@page import="com.mypage.user.model.MypageUserWorkingHour"%>
<%@page import="java.util.List"%>
<%@page import="com.mypage.user.model.MypageUser"%>
<%@ include file="../init.jsp"%>

<%@ page language="java"%>
<%@ page import="java.util.regex.Matcher"%>
<%@ page import="java.util.regex.Pattern"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	boolean showClub = (boolean) renderRequest.getAttribute("showClub");
	String deptoreCode = (String) renderRequest.getAttribute("_deptoreCode");
	MypageUser myPageUser = (MypageUser) renderRequest.getAttribute("myPageUser");
	List<Long> groups = MypageUserGroupLocalServiceUtil.findBymypageUserId(myPageUser.getMypageUserId());
	List<AgentCalendar> events = AgentCalendarLocalServiceUtil.getActiveCalendarByRole(myPageUser.getMypageUserId(), myPageUser.getMypageUserRoleId(), groups);
	Date today = new Date();
	today.setHours(0);
	today.setMinutes(0);
	today.setSeconds(0);
	
	long timestamp = Math.round(Math.floor(today.getTime() / 1000));
	
	ActionHelpers helpers = new ActionHelpers();
	String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
	
    String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
    String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
%>

<portlet:resourceURL id="/data/agentdashboard" var="loadAgentViewDashboardData" />

<div class="breadcrumbs container-breadcrumbs-axa">
	<nav class="width-full">
		<ol class="list-reset display-inline-flex">
			<li class="text-13px agency-uppercase agency-self-center">Beranda</li>
		</ol>
	</nav>
</div>

<% if (showClub) { %>
	<div class="club">
		<div class="club__hero" id="no-club">
			<div class="container-axa">
				<div class="club__hero--inner">
					<div class="club__hero--left">
					
						<div class="level-now">
							<div id="level-noclub"></div>
							<div class="level-name agency-self-center line-height-30px">
								<span class="display-block text-responsive-14px agency-uppercase agency-leading-normal mb-responsive-4px">Klub Sekarang</span>
								<span class="display-block text-responsive-35px agency-break-all">No Club</span>
							</div>
						</div>
						
						<!-- <div class="level-after">
							<div id="level-palladium" class="w-40px-h-50px agency-self-center"></div>
							<div class="level-name agency-self-center ml-24px">
								<span class="display-block text-responsive-14px agency-uppercase agency-leading-none">Klub Sebelumnya</span>
								<span class="display-block text-responsive-16px">Palladium</span>
							</div>
						</div> -->
						
						
					</div>
					<div class="club__hero--right">
						<span class="branch-name">Cabang </span> <!-- Cabang bandung -->
						<span class="name">Loading ...</span> <%-- Alvin Yudhi Putra --%>
					</div>
				</div>
				<div class="club-progress-bar-wrapper">
					<div class="club-progress-bar" style="width: 0%"></div>
				</div>
				<div class="club-total-product">
					<div class="club-total-product__left">
						<span>Total Produksi saat ini</span>
						<strong>Rp</strong> <!-- Rp 1.100.000 --> 
					</div>
					<div class="club-total-product__right text-right">
						<span>Untuk Ke</span> <!-- Untuk Ke Platinum -->
						<strong>Rp</strong> <!-- Rp 2.500.000 -->
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="alert-member-club">
		<div class="container-axa">
			<div class="alert-member-club__inner">
				<div class="alert-member-club__left">
					<p class="text-member"></p>
					<p class="text-member-btn">
						<strong></strong> 
						<a href="<%= host %>/dashboard/scorecard" class="btn__agency btn--dark-blue display-block agency-text-center btn-scorecard">
							<span class="position-relative order-10">Lihat Scorecard <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
						</a>
					</p>
				</div>
				<div class="alert-member-club__right">
					<a href="<%= host %>/dashboard/scorecard" class="btn__agency btn--dark-blue display-block agency-text-center btn-scorecard">
						<span class="position-relative order-10">Lihat Scorecard <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
					</a>
				</div>
			</div>
		</div>
	</div>
<% } %>

<div class="dashboard">
	<div class="dashboard__home">
		<div class="container-axa">
			<div class="dashboard__home--inner gap-16px">
			
				<%@ include file="includes/calendar.jsp" %>
				<%@ include file="includes/portofolio.jsp" %>
				
			</div>
		</div>
	</div>
</div>	

<script>
	window.resourceURL = "<%= resourceURL.toString() %>";
	window.loadAgentViewDashboardDataURL = "<%= loadAgentViewDashboardData %>";
	window.rToken = "<%= renderToken %>";
	window.apToken = "<%= apiRequestToken %>";
</script>
<script src="/o/agency-theme/js/multiform/multiform.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/dashboard/js/main.js" type="text/javascript"></script>	