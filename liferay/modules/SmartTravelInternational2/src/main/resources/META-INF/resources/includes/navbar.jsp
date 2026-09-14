<%@ include file="../init.jsp"%>
<% String brochureLink = (String)renderRequest.getAttribute("brochureLink"); %>
<% String riplayLink = (String)renderRequest.getAttribute("riplayLink"); %>

<div class="banner__step2 download__icon banner__panel">
	<span class="banner__panel-inner">Ringkasan Produk</span>
	<div class="banner__panel-item">
		<a href="<%=riplayLink %>" target="_blank"><span class="position-relative">RIPLAY Umum</span></a>
<!-- 		<a href="#" target="_blank"><span class="position-relative">RIPLAY Domestik</span></a> -->
		<a href="<%= brochureLink %>" target="_blank"><span class="position-relative">Brosur</span></a>
	</div>
</div>

