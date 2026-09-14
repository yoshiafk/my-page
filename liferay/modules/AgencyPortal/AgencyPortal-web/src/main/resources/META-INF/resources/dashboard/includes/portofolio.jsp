<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.mypage.agencyportal.dto.DataItemDto"%>
<%@ include file="../portofolio/view.jsp" %>
<div class="dashboard__tbl-online-booking">
	<div
		class="dashboard__tbl-online-booking-heading flex-justify-between mb-20px">
		<h4>Daftar Transaksi AXA myPage</h4>
		
		<!-- <a href="/portofolio-transaction-online" -->
		<a href="<%= host %>/dashboard/leads/online" class="btn__agency btn--sienna agency-self-center btn-see-all">
			<span class="position-relative order-10">lihat Semua <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
		</a> 

	</div>
	<div class="table-wrapper mt-12px">
		<table class="table table__agency">
			<thead>
				<tr>
					<td>No ref</td>
					<td>Tanggal</td>
					<td>Nama</td>
					<td>Produk</td>
					<td>Tipe Polis</td>
					<td>Total Premi</td>
					<td>Status</td>
				</tr>
			</thead>
			
			<tbody>
			
				<%
					if (Validator.isNotNull(_response)) {
				for(int i = 0; i < _response.getData().size(); i ++) {
					DataItemDto data = _response.getData().get(i);
					
					String formattedDate = data.getTransactionDate().substring(0, 11);
					
					double netPremium = data.getNetPremium();
					long harga = Math.round(netPremium);
					NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("id", "ID"));
			        String formattedPremi = numberFormat.format(harga);
			        
			        String status = "";
			        String statusClass = "";
			        if (data.getStatus() != null) {
			            switch (data.getStatus().toLowerCase()) {
			                case "paymentsuccess":
			                    status = "Polis Terbit";
			                    statusClass = "approve";
			                    break;
			                case "paymentwaiting":
			                    status = "Menunggu Pembayaran";
			                    break;
			                case "expired":
			                    status = "Kedaluwarsa Penawaran";
			                    statusClass = "expire";
			                    break;
			                    
			                default:
			                    status = "Lain lain";
			                    break;
			            }
			        }
			        
			        String polisType = "";
			        if (data.getPolicyType() != null) {
			            switch (data.getPolicyType().toString().toLowerCase()) {
			                case "policy":
			                	polisType = "Polis";
			                    break;
			                default : 
			                	polisType = "Penawaran";
			                    break;
			            }
			        } 
			        
				%>
					<tr class="<%= statusClass %>">
					    <td><%= data.getReferenceNumber() %></td>
					    <td><%= formattedDate != null ? formattedDate : "" %></td>
					    <td><%= data.getName() != null ? data.getName() : "" %></td>
					    <td><%= data.getProduct() != null ? data.getProduct() : "" %></td>
					    <td><%= polisType %></td>
					    <td><%= data.getCurrency() != null ? data.getCurrency() : "" %> <%= formattedPremi %></td>
					    <td><%= status %></td>
					</tr>
					
					<% }} %>
				
			</tbody>
			
		</table>
	</div>
	<div class="btn-see-all-responsive">
		<a href="<%= host %>/dashboard/leads/online" class="btn__agency btn--sienna agency-self-center btn-see-all">lihat
			Semua <i class="fas fa-arrow-right fa-fw ml-5px"></i>
		</a>
	</div>
</div>

<script>
$(document).ready(function(){
    $('.btn-see-all').click(function(e) {
    	e.preventDefault();
        parent.location.href = this.href;
    });
});
</script>
