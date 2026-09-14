<%@ include file="../init.jsp" %>

<%
	ActionHelpers helpers = new ActionHelpers();
	String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
	String endpoint = (String) renderRequest.getAttribute("endpoint");
	
	if (endpoint.contains("dashboard") == false) {
		endpoint = "dashboard/".concat(endpoint);
	}
%>

<div class="not-found oops">
	<div class="container-axa agency-self-center">
           <div class="not-found__inner agency-text-center">
               <h1 class="text-responsive-35px p-bottom">Mohon maaf, loading data gagal</h1>
               <a class="btn__agency btn--dark-blue link-reload" href="<%= host %>/<%= endpoint %>">
                   <span class="position-relative order-10">Mohon Coba Kembali</span>
               </a>
           </div>
	</div>
</div>

<script>
	var html = $("html");
	var body = $("body");
	
	html.addClass("html__agency");
    body.addClass("body__agency body-white");
	
	$('.portlet-header').hide();
	
	$(document).ready(function() {
		$('.link-reload').click(function(e) {
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