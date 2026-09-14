<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.mypage.agencyportal.dto.DataDetailsLeadsDto"%>
<%@ include file="../../../init.jsp"%>

<%
	DataDetailsLeadsDto datasRes = (DataDetailsLeadsDto) renderRequest.getAttribute("detailLeadsResponse");
	JSONObject joPayment = (JSONObject) renderRequest.getAttribute("payment");
%>


<div class="panel-wrapper mb-8level">
   <h1 class="mb-4level">Rincian Produk</h1>
   <div class="panel">
      <div class="panel-top">
         <div class="panel-top__left">
            <span><%=datasRes.getPolicyHolder().getName() %> (<%=datasRes.getReferenceNumber() %>)</span>
            <span>
               <fmt:parseDate value="<%= datasRes.getOrderDate() %>" pattern="yyyyMMdd" var="odate" />
               <fmt:formatDate value="${odate}" pattern="dd MMM yyyy" />
            </span>
         </div>
         <div class="panel-top__right">
            <% 
               String statusPembayaran = datasRes.getStatus();
               String statusPaymentIdn = "";
               if(statusPembayaran != null) {
                   switch (statusPembayaran.toLowerCase()) {
                   
	                   case "paymentsuccess":
	                	   statusPaymentIdn = "Polis Terbit";
	                       break;
	                   case "paymentwaiting":
	                	   statusPaymentIdn = "Menunggu Pembayaran";
	                       break;
	                   case "expired":
	                	   statusPaymentIdn = "Kedaluwarsa Penawaran";
	                       break;
	                   case "expire":
	                	   statusPaymentIdn = "Kedaluwarsa Penawaran";
	                       break;
	                   default:
	                	   statusPaymentIdn = "Lain lain";
	                       break;
	                       
	                }
               }
               
               
               %>
            <span>Status</span> <span><%=statusPaymentIdn %></span>
         </div>
      </div>
      <div class="panel-body border-b-sienna">
         <div class="pl-0px px-6level-large py-8level">
            <div class="panel-grid-wide">
               <div class="col">
                  <ul class="list-group">
                     
                     <% if ((datasRes.getPolicyHolder().getMobilePhone() != null && !datasRes.getPolicyHolder().getMobilePhone().trim().isEmpty())) { %>
                     
                     <li class="grid-col-temp-narrow"><span
                        class="position-relative">Telp</span> <span
                        class="agency-text-center">:</span>
                        <span>
						    <%= "+" + datasRes.getPolicyHolder().getMobilePhone() %>
						</span>
                         <%-- <span>+<%=datasRes.getPolicyHolder().getMobilePhone() %></span> --%>
                     </li>
                     
                     <%  } %>
                     
                     
                     <% if ((datasRes.getPolicyHolder().getEmail() != null && !datasRes.getPolicyHolder().getEmail().trim().isEmpty())) { %>
                     
                     <li class="grid-col-temp-narrow"><span
                        class="position-relative">Email</span> <span
                        class="agency-text-center">:</span> <span><%=datasRes.getPolicyHolder().getEmail() %></span>
                     </li>
                     
                     <%  } %>
                     
                     
                     <% if ((datasRes.getPolicyHolder().getAddress() != null && !datasRes.getPolicyHolder().getAddress().trim().isEmpty())) { %>
                     
                     <li class="grid-col-temp-narrow"><span
                        class="position-relative">Alamat</span> <span
                        class="agency-text-center">:</span> 
                        
                        <span>
                            <%= (datasRes.getPolicyHolder().getAddress() != null && !datasRes.getPolicyHolder().getAddress().trim().isEmpty()) ? datasRes.getPolicyHolder().getAddress() + ". " : "" %>
                            <%= (datasRes.getPolicyHolder().getCity() != null && !datasRes.getPolicyHolder().getCity().trim().isEmpty()) ? datasRes.getPolicyHolder().getCity() + ", " : "" %>
                            <%= (datasRes.getPolicyHolder().getProvince() != null && !datasRes.getPolicyHolder().getProvince().trim().isEmpty()) ? datasRes.getPolicyHolder().getProvince() + " " : "" %>
                            <%= (datasRes.getPolicyHolder().getZip() != null && !datasRes.getPolicyHolder().getZip().trim().isEmpty()) ? datasRes.getPolicyHolder().getZip() : "" %>
                        </span>
                        
                        <%-- <span><%=datasRes.getPolicyHolder().getAddress() %>. <%=datasRes.getPolicyHolder().getCity() %>, <%=datasRes.getPolicyHolder().getProvince() %> <%=datasRes.getPolicyHolder().getZip() %></span> --%>
                       </li>
                       
                     <%  } %>
                       
                  </ul>
               </div>
               <div class="col">
                  <ul class="list-group">
                  
                   <% if (datasRes.getReferenceNumber() != null) { %>
                  
                     <li class="grid-col-temp-wide"><span
                        class="position-relative">No Referensi</span> <span
                        class="agency-text-center">:</span> <span><%=datasRes.getReferenceNumber() %></span>
                     </li>
                     
                     <%  } %>
                     
                     
                     <% if (datasRes.getStartDate() != null) { %>
                     
                     <li class="grid-col-temp-wide">
                        <span
                           class="position-relative">tanggal efektif</span> <span
                           class="agency-text-center">:</span> 
                        <span>
                           <fmt:parseDate value="<%= datasRes.getStartDate() %>" pattern="yyyyMMdd" var="datestart" />
                           <fmt:formatDate value="${datestart}" pattern="dd MMM yyyy" />
                        </span>
                     </li>
                     <%  } %>
                     
                     
                     
                     <% if (datasRes.getExpiredDate() != null) { %>
                     <li class="grid-col-temp-wide">
                        <span
                           class="position-relative">tanggal Kedaluwarsa</span> <span
                           class="agency-text-center">:</span> 
                        <span>
                           <fmt:parseDate value="<%= datasRes.getExpiredDate() %>" pattern="yyyyMMdd" var="expiryDate" />
                           <fmt:formatDate value="${expiryDate}" pattern="dd MMM yyyy" />
                        </span>
                     </li>
                     <%  } %>
                     
                  </ul>
               </div>
               <div class="col">
                  <div class="total-premi">
                     <div class="display-flex gap-3level">
                        <span
                           class="text-total-premi agency-uppercase text-14px letter-spacing-1px">Total Premi</span>
                        <div class="agency-tooltip position-relative" id="tooltip-click-premi">
                           <span class="tooltip-click-premi agency-pointer">
                              <svg
                                 class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg"
                                 viewBox="0 0 24 24" fill="none">
                                 <path
                                    d="M11.9999 11.9999L11.9999 16.7999M11.9999 8.44209V8.3999M2.3999 11.9999C2.3999 6.69797 6.69797 2.3999 11.9999 2.3999C17.3018 2.3999 21.5999 6.69797 21.5999 11.9999C21.5999 17.3018 17.3018 21.5999 11.9999 21.5999C6.69797 21.5999 2.3999 17.3018 2.3999 11.9999Z"
                                    stroke="#00008F" stroke-width="2" stroke-linecap="round"
                                    stroke-linejoin="round"></path>
                              </svg>
                           </span>
                           <div class="tooltip__wrapper">
                              <div class="bubble">
                                 <p class="agency-text-center">Tanpa Komisi</p>
                                 <div class="arrow-triangle-right"></div>
                              </div>
                           </div>
                        </div>
                     </div>
                     
                     <p class="text-26px mb-2level">
                        <%=datasRes.getCurrency() %> 
                        <fmt:setLocale value="id_ID" />
                        <fmt:formatNumber value="<%=datasRes.getNetPremium() %>" type="number" maxFractionDigits="0" minFractionDigits="2" /> <!-- premi from NetPremi -->
                     </p>
                     
                     
                     <p class="col-text agency-uppercase">
                        <span>Komisi</span> <span class="mx-3level">:</span> 
                        <span><%= (int) Math.round(datasRes.getCommission()) %>%</span>
                     </p>
                  </div>
               </div>
               <div class="col">
                  <p class="agency-uppercase text-14px letter-spacing-1px">Total NETPremi</p>
                  <p class="text-30px">
                     <%=datasRes.getCurrency() %> 
                     <fmt:setLocale value="id_ID" />
                     <fmt:formatNumber value="<%= ((joPayment != null && !joPayment.toString().equals("{}")) && datasRes.getPolicyType().equalsIgnoreCase("Policy") && datasRes.getStatus().equalsIgnoreCase("paymentsuccess")) ? Double.parseDouble(joPayment.getString("Amount")) : datasRes.getNetPremium() %>" type="number" maxFractionDigits="0" minFractionDigits="2" /> <!-- if policytype is policy and payment is not null ot {} ? get from payment amount else netpremi -->
                  		
                  </p>
               </div>
               
               
               
            </div>
         </div>
      </div>
   </div>
</div>

<script>


$(document).ready(function() {
	
	$(".tooltip-click-premi").on("click", function() {
		$("#tooltip-click-premi").toggleClass("is-show");
	});
	
	//renderPage();
});

$(document).mouseup(function(e){
	var	bubble = $("#tooltip-click-premi");
	
	  if(!bubble.is(e.target) && bubble.has(e.target).length === 0) {
		  bubble.removeClass('is-show');
  	}
});

/* function renderPage(){
	$.ajax({
        url: loadAgentDashboardPortofolioDetailDataURL,
        type: "POST",
        data: {
            dataCategory: "main"
        },
        dataType: "json",
        success: function(response) {
            if (response.status) {
                console.log(response.status)
                console.log(response.dataProfile)
                
            }
            
        },
        error: function(xhr, status, error) {
            console.error("Error while fetch data:", status, error);
        }
    });	
} */



</script>
