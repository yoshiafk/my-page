<%@ include file="../../../init.jsp"%>
<%
	ActionHelpers helpers = new ActionHelpers();
    String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
%>

<div class="breadcrumbs container-breadcrumbs-axa">
	<nav class="w-full">
		<ol class="list-reset display-inline-flex">
			<li class="text-13px agency-self-center"><a
				href="<%= host %>/dashboard" class="go-to-link">Beranda</a></li>
			<li class="agency-self-center"><span class="text-13px">/</span></li>
			<li class="text-13px agency-self-center"><a
				href="<%= host %>/dashboard/leads/online" class="go-to-link">Portofolio Transaksi Online</a></li>
			<li class="agency-self-center"><span class="text-13px">/</span></li>
			<li class="text-13px agency-uppercase agency-self-center">Detail</li>
		</ol>
	</nav>
</div>

<script>
	$(document).ready(function() {
		$('.go-to-link').click(function(e) {
			e.preventDefault();
			parent.location.href = this.href;
		});
	});
</script>