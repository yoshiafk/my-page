
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="java.util.HashMap"%>
<%@ include file="init.jsp"%>

<% 
	HashMap<String, String> contactUsMap =  (HashMap<String, String>) renderRequest.getAttribute("contactUs");
	JSONObject dataObject = (JSONObject)renderRequest.getAttribute("dataObject");
%>

<div class="breadcrumbs container-breadcrumbs-axa">
		<nav class="w-full">
			<ol class="list-reset display-inline-flex">
				<li class="text-13px agency-self-center">
					<a href="/dashboard">Beranda</a>
				</li>
				<li class="agency-self-center">
					<span class="text-13px">/</span>
				</li>
				<li class="text-13px agency-uppercase agency-self-center">Kontak Kami</li>
			</ol>
		</nav>
	</div>

    <div class="contact-us">
        <div class="container-axa">
			
 			<div class="contact-us__inner">
				<h1><%=contactUsMap.get("namaPerusahaan") %> Customer Care Center</h1>
				<address class="display-block mb-5level">
					<%=contactUsMap.get("alamatPerusahaan") %>
				</address>
				<div class="contact-us__left">
					<div class="contact-us-grid">
						
						<% 
							String wa = contactUsMap.get("whatsappAgencySupport"); 
							String waCall = wa.replaceFirst("^0", "62").replaceAll("\\s", "");
						%>
						<a  href="https://wa.me/<%=waCall %>" class="chatbot-wrapper" target="_blank">
							<div class="chatbot-wrapper-inner">
								<i class="fab fa-whatsapp agency-self-center text-30px"></i>
								<span>
									Whatsapp Agency Support: 
									<span><%=wa %> </span>
								</span>
							</div>
						</a>
						
						<% String mail= contactUsMap.get("email"); %>
						<a href="mailto:<%=mail %>" class="email-wrapper send-email" target="_blank">
							<div class="email-wrapper-inner">
								<i class="fas fa-envelope agency-self-center text-30px"></i>
								<span>
									Email: 
									<span><%=mail %> </span>
								</span>
							</div>
						</a>
						
						
						<%-- <% if(dataObject.has("ParentEmail") && !dataObject.getString("ParentEmail").equals("")) { 
							String mailbde= dataObject.getString("ParentEmail");
						%>
						<a href="mailto:<%=mailbde %>" class="email-wrapper bde-call" target="_blank">
							<div class="email-wrapper-inner">
								<span>
									Atau hubungi Business Development Executive Anda
								</span>
							</div>
						</a>
						
						<% } %> --%>
						
						<a class="email-wrapper bde-call" target="_blank">
							<div class="email-wrapper-inner">
								<span>
									Atau hubungi Business Development Executive Anda
								</span>
							</div>
						</a>
						
						<%
							String telp= contactUsMap.get("telepon");
							String telpCall= telp.replaceAll("\\s", ""); 
						%>
						<a href="tel:<%=telpCall %>" class="email-wrapper phone-call" target="_blank">
							<div class="email-wrapper-inner">
								<i class="fas fa-phone-alt agency-self-center text-25px"></i>
								<span>
									Customer Care Center:
									<span><%=telp %> <span>(Senin-Jumat, <br/>08.00-17.00 WIB)</span></span>
								</span>
							</div>
						</a>
					</div>
				</div>
			</div>
			
			
		<%-- <div class="contact-us__inner">
				<h1><%=contactUsMap.get("namaPerusahaan") %> Customer Care Center</h1>
				<address class="display-block mb-5level">
					<%=contactUsMap.get("alamatPerusahaan") %>
				</address>
				<div class="contact-us__left">
					<div class="contact-us-grid">
						
						<% 
							String wa = contactUsMap.get("whatsappAgencySupport"); 
							String waCall = wa.replaceFirst("^0", "62").replaceAll("\\s", "");
						%> 
						<a href="https://wa.me/<%=waCall %>" class="chatbot-wrapper" target="_blank">
							<div class="chatbot-wrapper-inner">
								<i class="fab fa-whatsapp agency-self-center text-30px"></i>
								<span>
									Whatsapp Agency Support: <span><%=wa %> </span>
								</span>
							</div>
						</a>
						
						
						<% String mail= contactUsMap.get("email"); %>
						<a href="mailto:<%=mail %>" class="email-wrapper" target="_blank">
							<div class="email-wrapper-inner">
								<i class="fas fa-envelope agency-self-center text-30px"></i>
								<span>
									Email: <span><%=mail %> </span>
								</span>
							</div>
						</a>
						
						
						<% if(dataObject.has("ParentEmail") && !dataObject.getString("ParentEmail").equals("")) { 
							String mailbde= dataObject.getString("ParentEmail");
						%>
							<a href="mailto:<%=mailbde %>" class="email-wrapper" target="_blank">
								<div class="email-wrapper-inner">
									<span>
										Atau hubungi Business Development Executive Anda
									</span>
								</div>
							</a>
						
						<% } %>
						
						<%
							String telp= contactUsMap.get("telepon");
							String telpCall= telp.replaceAll("\\s", ""); 
						%>
						<a href="tel:<%=telpCall %>" class="email-wrapper" target="_blank">
							<div class="email-wrapper-inner">
								<i class="fas fa-phone-alt agency-self-center text-25px"></i>
								<span>Customer Care Center
									<span><%=telp %> <span>(Senin-Jumat, 08.00-17.00 WIB)</span></span>
								</span>
							</div>
						</a>
					
						
					</div>
				</div>
			</div>  --%>
			
			
		</div>
    </div>
    
<script>

var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency body-white");


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