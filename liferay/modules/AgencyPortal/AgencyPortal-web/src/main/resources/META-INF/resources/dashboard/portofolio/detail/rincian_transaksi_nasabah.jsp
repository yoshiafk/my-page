<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.mypage.agencyportal.dto.DataDetailsLeadsDto"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ include file="../../../init.jsp"%>

<%
	DataDetailsLeadsDto datasResponse = (DataDetailsLeadsDto) renderRequest.getAttribute("detailLeadsResponse");
	String agentName = (String) renderRequest.getAttribute("agentName");
	String agentRole = (String) renderRequest.getAttribute("agentRole");
    
    String urlDownloadPolis = datasResponse.getUrlDownloadPolis();
    boolean showDownloadButton = !urlDownloadPolis.isEmpty();
    
    String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
	String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
	String encodeToken = !Validator.isNull((String) renderRequest.getAttribute("encodeToken")) ? (String) renderRequest.getAttribute("encodeToken") : "";
%>

<portlet:resourceURL id="/data/dashboard/portofolio/detail" var="loadAgentDashboardPortofolioDetailData" />

<div class="col-portofolio-detail">
   <div class="dashboard-portofolio-detail__left">
      <div class="display-flex gap-2level">
         <a href="<%= host %>/dashboard/leads/online" class="agency-self-center go-to-link hide-icon-mobile">
            <svg width="23" height="23" viewBox="0 0 23 23" fill="none" xmlns="http://www.w3.org/2000/svg">
               <path d="M10.3818 17.25L4.7915 11.5M4.7915 11.5L10.3818 5.75M4.7915 11.5H18.2082" stroke="#00008F" stroke-width="2.875" stroke-linecap="round" stroke-linejoin="round" />
            </svg>
         </a>
         <h1 class="text-responsive-32px">Rincian Transaksi Nasabah</h1>
      </div>
      
      <div class="btn-portofolio-detail">
      		<% if (agentRole.equalsIgnoreCase("BDE") == false) { %>
      			<% if (datasResponse.isTemp() == true) { %>
      				<% if (datasResponse.getProduct().getCode().equalsIgnoreCase("SME")) { %>
      					<% if (datasResponse.getStatusQuotation().isEmpty() == false && (datasResponse.getStatusQuotation().equalsIgnoreCase("Rejected") == false && datasResponse.getStatusQuotation().equalsIgnoreCase("Pending") == false)) { %>
      						<a onclick="resendQuotation()" class="btn__agency btn--dark-blue-outline agency-pointer btn-resend-quotation">
							    <span class="position-relative order-10">Kirim Ulang Quotation</span>
							</a>
							<a onclick="payQuotation()" class="btn__agency btn--sienna agency-pointer">
			                    <span class="position-relative order-10 flex-justify-center gap-2level">
			                        <span>Bayar</span>
			                        <svg class="agency-self-center" width="17" height="16" viewBox="0 0 17 16" fill="none" xmlns="http://www.w3.org/2000/svg">
			                            <path d="M2.49979 6.20029H14.4998M4.89979 9.00029H6.89979M3.7001 3.40039H13.2998C14.1835 3.40039 14.8998 4.11617 14.8998 4.99981L14.9 11.0011C14.9 11.8847 14.1837 12.6004 13.3 12.6004L3.70025 12.6003C2.81662 12.6003 2.10029 11.884 2.10027 11.0003L2.1001 5.00044C2.10007 4.11676 2.81642 3.40039 3.7001 3.40039Z" stroke="white" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round" />
			                        </svg>
			                    </span>
			                </a>
      					<% } %>
      					<% if (datasResponse.getStatusQuotation().isEmpty() == false && (datasResponse.getStatusQuotation().equalsIgnoreCase("Accepted") == true)) { %>
      						<a onclick="resendPayment()" class="btn__agency btn--dark-blue-outline agency-pointer btn-resend-quotation">
							    <span class="position-relative order-10">Kirim Ulang Link Pembayaran</span>
							</a>
      					<% } %>	
      				<% } else { %>
      					<% if ((datasResponse.getPep().isPepLeads() == false || (datasResponse.getPep().isPepLeads() == true && datasResponse.getPep().getStatusPep().equalsIgnoreCase("Accepted") == true)) && (datasResponse.getUwApproval().isPropertyRiskLeads() == false || (datasResponse.getUwApproval().isPropertyRiskLeads() == true && datasResponse.getUwApproval().getStatusPropertyRisk().equalsIgnoreCase("Accepted") == true))) { %>
      						<a onclick="resendQuotation()" class="btn__agency btn--dark-blue-outline agency-pointer btn-resend-quotation">
							    <span class="position-relative order-10">Kirim Ulang Quotation</span>
							</a>
							<a onclick="payQuotation()" class="btn__agency btn--sienna agency-pointer">
			                    <span class="position-relative order-10 flex-justify-center gap-2level">
			                        <span>Bayar</span>
			                        <svg class="agency-self-center" width="17" height="16" viewBox="0 0 17 16" fill="none" xmlns="http://www.w3.org/2000/svg">
			                            <path d="M2.49979 6.20029H14.4998M4.89979 9.00029H6.89979M3.7001 3.40039H13.2998C14.1835 3.40039 14.8998 4.11617 14.8998 4.99981L14.9 11.0011C14.9 11.8847 14.1837 12.6004 13.3 12.6004L3.70025 12.6003C2.81662 12.6003 2.10029 11.884 2.10027 11.0003L2.1001 5.00044C2.10007 4.11676 2.81642 3.40039 3.7001 3.40039Z" stroke="white" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round" />
			                        </svg>
			                    </span>
			                </a>
      					<% } %>
      				<% } %>
      			<% } else if (datasResponse.getStatusPayment().equalsIgnoreCase("Success") == true && datasResponse.getStatus().equalsIgnoreCase("Refund") == false) { %>
      				<% if (showDownloadButton == true) { %> 
	                    <a onclick="downloadPolicy()" class="btn__agency btn--dark-blue agency-pointer">
						    <span class="position-relative order-10 flex-justify-center gap-2level">
						        <span>Unduh Polis</span>
						        <svg class="agency-self-center" width="17" height="16" viewBox="0 0 17 16" fill="none" xmlns="http://www.w3.org/2000/svg">
						            <path d="M8 1V10M8 10L5 7M8 10L11 7M2 14H14" stroke="white" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round" />
						        </svg>
						    </span>
						</a>
                	<% } %>
                <% } %>
      		<% } else { %>
      			<% if (showDownloadButton == true) { %>
                    <a onclick="downloadPolicy()" class="btn__agency btn--dark-blue agency-pointer">
					    <span class="position-relative order-10 flex-justify-center gap-2level">
					        <span>Unduh Polis</span>
					        <svg class="agency-self-center" width="17" height="16" viewBox="0 0 17 16" fill="none" xmlns="http://www.w3.org/2000/svg">
					            <path d="M8 1V10M8 10L5 7M8 10L11 7M2 14H14" stroke="white" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round" />
					        </svg>
					    </span>
					</a>
               	<% } %>
      		<% } %>
      		
      		<% if (agentRole.equalsIgnoreCase("BDE") == false && (datasResponse.getPep().isPepLeads() == false || (datasResponse.getPep().isPepLeads() == true && datasResponse.getPep().getStatusPep().equalsIgnoreCase("Accepted") == true)) && (datasResponse.getUwApproval().isPropertyRiskLeads() == false || (datasResponse.getUwApproval().isPropertyRiskLeads() == true && datasResponse.getUwApproval().getStatusPropertyRisk().equalsIgnoreCase("Accepted") == true))) { %>
      			<% if (datasResponse.getProduct().getCode().equalsIgnoreCase("SME") == false && datasResponse.getProduct().getCode().equalsIgnoreCase("GP") == false && datasResponse.getProduct().getCode().equalsIgnoreCase("PA") == false && datasResponse.getPolicyType().equalsIgnoreCase("Renewal") == false) { %>
      				<% 
      					LocalDate currentDate = LocalDate.now();
	      				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	      		        LocalDate expiredDate = LocalDate.parse(datasResponse.getExpiredDate(), formatter);
	      		      	expiredDate = expiredDate.plusDays(datasResponse.getProduct().getRenewalSetting().getRenewalMaxDays());
	      		      	
	      		      	if ((datasResponse.getRenewal().isRenewal1DateFlag() == true || datasResponse.getRenewal().isRenewal2DateFlag() == true || datasResponse.getRenewal().isRenewal3DateFlag() == true) && currentDate.compareTo(expiredDate) <= 0) {
      				%>
      					
      				<% } else { %>
      					<a onclick="reOrder()" href="javascript:;" class="btn__agency <% if (datasResponse.getStatusPayment().equalsIgnoreCase("Success") == true || datasResponse.isTemp() == false) { %>btn--sienna<% } else { %>btn--dark-blue<% } %> agency-pointer">
		                    <span class="position-relative order-10 flex-justify-center gap-2level">
		                        <span><% if (datasResponse.getStatusPayment().equalsIgnoreCase("Success") == true || datasResponse.isTemp() == false) { %>Beli Kembali<% } else { %>Ubah Penawaran<% } %></span>
		                        <svg class="agency-self-center" width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
		                            <path d="M4.8001 13.5114C2.88713 12.4048 1.6001 10.3365 1.6001 7.96758C1.6001 5.28168 3.25463 2.98221 5.6001 2.03279M5.6001 11.5676L5.6001 14.7676L2.4001 14.7676M11.2001 2.48941C13.1131 3.596 14.4001 5.6643 14.4001 8.0332C14.4001 10.7191 12.7456 13.0186 10.4001 13.968M10.4001 4.4332L10.4001 1.2332L13.6001 1.2332" stroke="white" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round" />
		                        </svg>
		                    </span>
	                	</a>
      				<% } %>
      			<% } %>
      		<% } %>
	</div>
      
   </div>
   <div class="dashboard-portofolio-detail__right">
      <p class="text-name">Nama Produk</p>
      <h3 class="text-ansurance"><%=datasResponse.getProduct().getName() %></h3>
      <p class="col-text">
         <span>Dikelolah oleh</span> <span class="mx-3level">:</span> <span><%=agentName %></span>
      </p>
      <p class="col-text">
         <span>Bisnis model</span> <span class="ml-33px mr-12px mx-3level-large">:</span> <span><%=datasResponse.getBusinessModel() %></span>
      </p>
      <%-- <p class="col-text">
         <span>Tipe Produk</span> <span class="mx-3level">:</span> <span><%=datasResponse.getCategory() %></span>
      </p> --%>
   </div>
</div>

<script>
	var hostpim = "<%= host %>";
	var rToken = "<%= renderToken %>";
	var apToken = "<%= apiRequestToken %>";
	var eToken = "<%= encodeToken %>";
	var html = $("html");
	var body = $("body");
	
	html.addClass("html__agency");
	body.addClass("body__agency body-white");
	
	function downloadPolicy() {
	    window.open('<%= urlDownloadPolis %>', '_blank');
	}
	
	function payQuotation() {
		parent.location.href = '<%= datasResponse.getLinkBayar() %>';
	}
	
	function resendQuotation() {
		$.ajax({
	        url: "<%= loadAgentDashboardPortofolioDetailData %>",
	        type: "POST",
	        data: { rtoken: rToken, aptoken: apToken, etoken: eToken, referenceResend: "<%= datasResponse.getReferenceNumber() %>" },
	        timeout: 20000, 
	        dataType: "json",
	        beforeSend: function() {
	        	$(".btn-resend-quotation").addClass("btn--disabled");
	        	$(".btn-resend-quotation").css("pointer-events", "none");
	        },
	        success: function(response) {
	        	alert(response.message);
	        	
	        	apToken = response.token ? response.token : "";
			},
			complete: function () {
	        	$(".btn-resend-quotation").removeClass("btn--disabled");
	        	$(".btn-resend-quotation").css("pointer-events", "auto");
	        }
	    });
	}
	
	function resendPayment() {
		$.ajax({
	        url: "<%= loadAgentDashboardPortofolioDetailData %>",
	        type: "POST",
	        data: { rtoken: rToken, aptoken: apToken, etoken: eToken, referenceResend: "<%= datasResponse.getReferenceNumber() %>", type: "payment" },
	        timeout: 20000, 
	        dataType: "json",
	        beforeSend: function() {
	        	$(".btn-resend-quotation").addClass("btn--disabled");
	        	$(".btn-resend-quotation").css("pointer-events", "none");
	        },
	        success: function(response) {
	        	alert(response.message);
	        	
	        	apToken = response.token ? response.token : "";
			},
			complete: function () {
	        	$(".btn-resend-quotation").removeClass("btn--disabled");
	        	$(".btn-resend-quotation").css("pointer-events", "auto");
	        }
	    });
	}
	
	function reOrder() {
		setTimeout(function() {
			window.parent.postMessage({ reorder: true }, '*');
		}, 100);
	}
	
	window.addEventListener('reorder', function() {
		reOrder();
	});
</script>