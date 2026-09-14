<%@ include file="../../init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<%
	/* HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
	String url = PortalUtil.getCurrentURL(httpRequest);
	String[] parts = url.split("/");
	String value = parts[parts.length - 1];
	String[] subparts = value.split("-"); */
    long agentCalendarId = (long) renderRequest.getAttribute("agentCalendarId"); // Long.valueOf(subparts[0]);

	AgentCalendar agentCalendar = null;
	
	try {
		agentCalendar = AgentCalendarLocalServiceUtil.getAgentCalendar(agentCalendarId);
	} catch (Exception e) {
		
	}
	
	ActionHelpers helpers = new ActionHelpers();
	String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
%>

<% if (Validator.isNotNull(agentCalendar)) { %>
	<div class="breadcrumbs container-breadcrumbs-axa">
		<nav class="width-full">
			<ol class="list-reset display-inline-flex">
				<li class="text-13px agency-self-center">
					<a href="<%= host %>/dashboard" class="link-dashboard">Beranda</a>
				</li>
				<li class="agency-self-center">
					<span class="text-13px">/</span>
				</li>
				<li class="text-13px agency-uppercase agency-self-center"><%= agentCalendar.getTitle() %></li>
			</ol>
		</nav>
	</div>
	
	<div class="event-detail">
	    <div class="container-axa-blogs">
	        <div class="event-detail__header">
	            <span class="label-event sienna"><%= agentCalendar.getCategory() %></span>
	            <h1><%= agentCalendar.getTitle() %></h1>
	            <div class="event-detail__date-time">
	                <div class="display-flex gap-8px">
	                    <svg class="icon-calendar" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
	                        <path d="M7.25 17.5534V17.4688M12.3125 17.5534V17.4688M12.3125 12.9688V12.8842M16.8125 12.9688V12.8842M3.875 8.46875H19.625M5.91071 2V3.68771M17.375 2V3.6875M17.375 3.6875H6.125C4.26104 3.6875 2.75 5.19854 2.75 7.0625V18.3126C2.75 20.1766 4.26104 21.6876 6.125 21.6876H17.375C19.239 21.6876 20.75 20.1766 20.75 18.3126L20.75 7.0625C20.75 5.19854 19.239 3.6875 17.375 3.6875Z" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
	                    </svg>
	                    <fmt:formatDate value="<%= agentCalendar.getStartDate() %>" pattern="d MMM yyyy" var="formattedStartDate" />
	                    <fmt:formatDate value="<%= Validator.isNull(agentCalendar.getEndDate()) ? null : agentCalendar.getEndDate() %>" pattern="d MMM yyyy" var="formattedEndDate" />
	                    <% if (agentCalendar.getIsAllDay() == 1 && Validator.isNull(agentCalendar.getEndDate())) { %>
	                    	<span>${formattedStartDate}</span>
	                   	<% } %>
	                   	<% if (agentCalendar.getIsAllDay() == 1 && Validator.isNotNull(agentCalendar.getEndDate())) { %>
	                    	<% if (agentCalendar.getStartDate().equals(agentCalendar.getEndDate())) { %>
	                   			<span>${formattedStartDate}</span>
	                    	<% } else { %>
	                    		<span>${formattedStartDate} - ${formattedEndDate}</span>
	                    	<% } %>
	                   	<% } %>
	                   	<% if (agentCalendar.getIsAllDay() == 0 && Validator.isNull(agentCalendar.getEndDate())) { %>
	                    	<span>${formattedStartDate} | <%= agentCalendar.getStartTime() %></span>
	                   	<% } %>
	                   	<% if (agentCalendar.getIsAllDay() == 0 && (Validator.isNotNull(agentCalendar.getStartDate()) && Validator.isNotNull(agentCalendar.getEndDate()))) { %>
	                   		<% if (agentCalendar.getStartDate().equals(agentCalendar.getEndDate())) { %>
	                    		<span>${formattedStartDate} | <%= agentCalendar.getStartTime() %> - <%= agentCalendar.getEndTime() %></span>
	                    	<% } else { %>
	                    		<span>${formattedStartDate} - ${formattedEndDate} | <%= agentCalendar.getStartTime() %> - <%= agentCalendar.getEndTime() %></span>
	                    	<% } %>
	                   	<% } %>
	                </div>
	                <% if (Validator.isNotNull(agentCalendar.getRole()) || Validator.isNotNull(agentCalendar.getGroup())) { %>
		                <div class="display-flex gap-8px">
		                    <svg class="icon-user" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 23 23" fill="none">
		                        <path d="M17.6424 13.4941C18.8069 14.3642 19.8477 16.5548 19.8477 17.9046C19.8477 18.3251 19.5409 18.666 19.1624 18.666H18.745M14.3345 9.9278C15.0878 9.49202 15.5947 8.67753 15.5947 7.74467C15.5947 6.8118 15.0878 5.99731 14.3345 5.56154M2.89082 18.666H14.9619C15.3404 18.666 15.6472 18.3251 15.6472 17.9046C15.6472 15.2614 13.4389 13.1186 8.92637 13.1186C4.41383 13.1186 2.20557 15.2614 2.20557 17.9046C2.20557 18.3251 2.51237 18.666 2.89082 18.666ZM11.4467 7.74467C11.4467 9.13659 10.3183 10.265 8.92637 10.265C7.53444 10.265 6.40607 9.13659 6.40607 7.74467C6.40607 6.35274 7.53444 5.22437 8.92637 5.22437C10.3183 5.22437 11.4467 6.35274 11.4467 7.74467Z" stroke-width="1.83772" stroke-linecap="round"/>
		                    </svg>
		                    <span><%= Validator.isNotNull(agentCalendar.getRole()) ? agentCalendar.getRole() : agentCalendar.getGroup() %></span>
		                </div>
	               	<% } %>
	               	<% if (Validator.isNotNull(agentCalendar.getLocation())) { %>
		                <div class="display-flex gap-8px">
		                    <svg class="icon-marker" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 23 23" fill="none">
		                        <path d="M11.0266 16.5396V9.1887V3.67554L15.9885 7.53475L11.5779 10.8426M7.71872 13.1313C4.486 13.6765 2.20557 14.9971 2.20557 16.5396C2.20557 18.5695 6.15489 20.215 11.0266 20.215C15.8984 20.215 19.8477 18.5695 19.8477 16.5396C19.8477 14.9971 17.5672 13.6765 14.3345 13.1313" stroke-width="1.83772" stroke-linecap="round" stroke-linejoin="round"/>
		                    </svg>
		                    <span><%= agentCalendar.getLocation() %></span>
		                </div>
		            <% } %>
	            </div>
	            <% if (Validator.isNotNull(agentCalendar.getAddress())) { %>
	            	<address><%= agentCalendar.getAddress() %></address>
	            <% } %>
	            <% if (Validator.isNotNull(agentCalendar.getLink())) { %>
		            <div class="link">
		                <a class="display-grid gap-8px link__zoom" href="<%= agentCalendar.getLink() %>" target="_blank">
		                    <svg class="icon-link" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 22 22" fill="none">
		                        <path d="M6.76278 9.34144L4.71545 11.3888C3.95082 12.1534 3.51112 13.1938 3.51915 14.2872C3.52719 15.3806 3.95727 16.4273 4.75818 17.2035C5.5343 18.0044 6.58126 18.4345 7.67449 18.4425C8.79266 18.4507 9.80843 18.0358 10.5731 17.2712L12.6204 15.2238M15.2355 12.6588L17.2828 10.6114C18.0475 9.84682 18.4872 8.80644 18.4791 7.71303C18.4711 6.61961 18.041 5.57289 17.2401 4.79671C16.4642 4.02077 15.4174 3.59066 14.324 3.58262C13.2306 3.57459 12.19 3.98934 11.4254 4.75398L9.37804 6.80131M7.89449 14.05L14.0365 7.90801" stroke-width="1.83772" stroke-linecap="round" stroke-linejoin="round"/>
		                    </svg>
		                    <span><%= agentCalendar.getLink() %></span>
		                </a>
		            </div>
				<% } %>
	        </div>
	        <div class="event-detail__body"><%= agentCalendar.getDescription() %></div>
	    </div>
	</div>
<% } else { %>
	<div class="not-found oops">
		<div class="container-axa agency-self-center">
            <div class="not-found__inner agency-text-center">
                <h1 class="text-responsive-35px p-bottom">Halaman tidak ditemukan</h1>
                <a class="btn__agency btn--dark-blue link-dashboard" href="<%= host %>/dashboard">
                    <span class="position-relative order-10">Kembali ke Beranda</span>
                </a>
            </div>
		</div>
	</div>
<% } %>

<script>
	var html = $("html");
	var body = $("body");
	
	html.addClass("html__agency");
	body.addClass("body__agency body-white");
	
	$(document).ready(function() {
		$('.link-dashboard').click(function(e) {
			e.preventDefault();
			parent.location.href = this.href;
		});
	});
	
	//Send the height of the content to the parent document
	function sendHeightToParent() {
		var height = document.getElementById('content').scrollHeight;
		window.parent.postMessage({ height: height }, '*');
	}

	//Call sendHeightToParent when the content of the iframe changes
	document.addEventListener('DOMContentLoaded', function() {
		sendHeightToParent();
	});

	window.addEventListener('resize', function() {
		sendHeightToParent();
	});
</script>	