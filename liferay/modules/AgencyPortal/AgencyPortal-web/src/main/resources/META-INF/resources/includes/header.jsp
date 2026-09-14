<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.mypage.user.model.MypageUser"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ include file="../init.jsp"%>

<%
	MypageUser myPageUser = (MypageUser) renderRequest.getAttribute("myPageUser");
	String pageActive = (String) renderRequest.getAttribute("pageActive");
	String pimcore = PropsUtil.get("com.mypage.agent.config.pimcoreHost");
%>

<nav class="nav-axa-wrapper">
	<div class="container-nav-axa">
		<div class="width-full agency-flex-wrap align-items-center flex-justify-between">
			<a class="brand-logo" href="/dashboard">
				<img class="h-50px mr-1rem" src="/o/agency-theme/images/logo_axa_mandiri.png" alt="" loading="lazy">
			</a>
			<div class="nav-left">
				<a class="brand-logo-responsive" href="/dashboard">
					<img class="h-50px mr-1rem" src="/o/agency-theme/images/logo_axa_mandiri.png" alt="" loading="lazy">
				</a>
				<ul class="nav-ul">
					<li>
						<a class="<% if (pageActive.equalsIgnoreCase("dashboard")) { %>is-active<% } %> agency-uppercase rounded-20px display-flex" href="/dashboard">
							<svg class="w-15px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 18 19" fill="none">
								<path d="M6.67773 18H1.67773V8.85714L9.17773 2L16.6777 8.85714V18H11.0527" stroke-width="2"></path>
							</svg>
							<span class="ml-8px">Beranda</span>
						</a>
					</li>
					<li>
						<a class="<% if (pageActive.equalsIgnoreCase("scorecard")) { %>is-active<% } %> agency-uppercase rounded-20px display-block" href="<%= pimcore %>/dashboard/scorecard">Scorecard</a>
					</li>
					<li>
						<a class="<% if (pageActive.equalsIgnoreCase("sales-tools")) { %>is-active<% } %> agency-uppercase rounded-20px display-block" href="/sales-tools">Sales Tools</a>
					</li>
				</ul>
			</div>
			<div class="nav-right">
				<div class="position-relative">
					<a class="dropdown-toggle dropdown-toggle--user" href="javascript:void(0)" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<img class="h-35px" src="/o/agency-theme/images/placeholder-profile.png" alt="" loading="lazy">
						<span><%= myPageUser.getUserName() %> <i class="fas fa-caret-down fa-fw"></i></span>
					</a>
					<ul class="dropdown-menu dropdown-menu-alt dropdown-menu--user">
						<li><a class="<% if (pageActive.equalsIgnoreCase("edit-profile")) { %>is-active<% } %> dropdown-item" href="/edit-profile">Ubah Profil Penguna</a></li>
						<li><a class="<% if (pageActive.equalsIgnoreCase("profile")) { %>is-active<% } %>dropdown-item" href="/profile">Lihat Profil Penguna</a></li>
						<li>
							<a class="dropdown-item dropdown-item--logout" href="/auth">
								<span class="btn__agency btn--dark-blue display-block agency-text-center"><span class="position-relative order-10">Keluar <i class="far fa-sign-out ml-8px"></i></span></span>
							</a>
						</li>
					</ul>
				</div>
			</div>

			<!--  Navigation  mobile -->
			<div class="nav-axa-button">
				<div class="display-flex position-relative">
					<button class="w-28px-h-28px display-block" type="button" id="toggle-menu">
						<div id="hamburger">
							<span></span>
							<span></span>
							<span></span>
						</div>
					</button>
				</div>
			</div>
		</div>
	</div>
</nav>

<!--  Navigation container mobile -->
<div id="navbar">
	<ul class="nav-ul max-h-545px">
		<li><a class="p-18px-25px-18px-25px display-block" href="javascript:void(0)"><img class="h-35px display-inline-block mr-12px" src="/o/agency-theme/images/placeholder-profile.png" alt="" loading="lazy" /><span class="display-inline-block agency-uppercase agency-text-blue-300"><%= myPageUser.getUserName() %></span></a></li>
		<li>
			<a class="<% if (pageActive.equalsIgnoreCase("dashboard")) { %>is-active-link<% } %> p-12px-25px-12px-25px display-block" href="/dashboard">
				Beranda
			</a>
		</li>
		<li><a class="<% if (pageActive.equalsIgnoreCase("scorecard")) { %>is-active-link<% } %>p-12px-25px-12px-25px display-block" href="<%= pimcore %>/dashboard/scorecard">Scorecard</a></li>
		<li><a class="<% if (pageActive.equalsIgnoreCase("sales-tools")) { %>is-active-link<% } %>p-12px-25px-12px-25px display-block" href="/sales-tools">Sales Tools</a></li>
		<li><a class="<% if (pageActive.equalsIgnoreCase("edit-profile")) { %>is-active-link<% } %>p-12px-25px-12px-25px display-block" href="/edit-profile">Ubah Profil Penguna</a></li>
		<li><a class="<% if (pageActive.equalsIgnoreCase("profile")) { %>is-active-link<% } %>p-12px-25px-12px-25px display-block" href="/profile">Lihat Profil Penguna</a></li>
		<li>
			<a class="dropdown-item dropdown-item--logout" href="/auth">
				<span class="btn__agency btn--dark-blue display-block agency-text-center"><span class="position-relative order-10">Keluar <i class="far fa-sign-out ml-8px"></i></span></span>
			</a>
		</li>
	</ul>
</div>
