<%@ include file="../init.jsp" %>

<div class="agency-text-center">
	<span>Your session is expired, please refresh the page or login!</span>
</div>

<script>
	var html = $("html");
	var body = $("body");
	
	html.addClass("html__agency");
    body.addClass("body__agency body-white");
	
	$('.portlet-header').hide();
</script>