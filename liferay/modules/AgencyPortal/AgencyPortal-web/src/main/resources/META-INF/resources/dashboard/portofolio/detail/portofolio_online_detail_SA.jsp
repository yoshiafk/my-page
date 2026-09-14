<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="java.util.Map"%>
<%@page import="com.mypage.agencyportal.dto.DataDetailsLeadsDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../../../init.jsp"%>
<%@ page import="java.text.DecimalFormat" %>

<%
	DataDetailsLeadsDto datas = (DataDetailsLeadsDto) renderRequest.getAttribute("detailLeadsResponse");
    JSONObject joDetail = (JSONObject) renderRequest.getAttribute("detail");
	JSONArray insureds = (JSONArray) renderRequest.getAttribute("insureds");
%>

<!-- include navbar -->
<%@ include file="breadcrumbs.jsp" %>

<div class="dashboard">
	<div class="dashboard__portofolio-detail">
		<div class="container-axa">
			
			<!-- include rincian nasabah -->
			<%@ include file="rincian_transaksi_nasabah.jsp" %>
			
			<div class="dashboard__portofolio-product">
			
				<!-- main rincian product -->
				<%@ include file="rincian_produk.jsp" %>
			
				<div class="panel-wrapper mb-4level">
					<h1 class="mb-4level">Ringkasan Polis</h1>
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Polis</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
										
										<% if (datas.getStartDate() != null && !datas.getStartDate().isEmpty()) { %>
											<li>
												<span class="position-relative">Tanggal Mulai</span> 
												<span class="agency-text-center">:</span>
												<span>
													<fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="depart" />
											        <fmt:formatDate value="${depart}" pattern="dd MMM yyyy" />
										       </span>
											</li>
											<% } %>
											<% if (datas.getExpiredDate() != null && !datas.getExpiredDate().isEmpty()) { %>
											<li>
												<span class="position-relative">Tanggal Selesai</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="arrive" />
											        <fmt:formatDate value="${arrive}" pattern="dd MMM yyyy" />
										       </span>
											</li>
											<% } %>
											<% if (datas.getCurrency() != null && !datas.getCurrency().isEmpty()) { %>
											<li>
												<span class="position-relative">Jenis Mata Uang</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getCurrency() %></span>
											</li>
											<% } %>
										
											
											
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											
											<!-- format decimal -->
											<% 
											    if (joDetail.has("SumInsured") && !joDetail.getString("SumInsured").trim().isEmpty()) { 
											        String sumInsured = joDetail.getString("SumInsured").trim();
											        String formattedSumInsured = sumInsured;
											        
											        try {
											            long amount = Long.parseLong(sumInsured.replaceAll("[^0-9]", "")); 
											            DecimalFormat formatter = new DecimalFormat("#,###");
											            formattedSumInsured = formatter.format(amount).replace(",", "."); 
											        } catch (NumberFormatException e) {
											        }
											%>
											        <li>
											            <span class="position-relative">Nilai Manfaat Utama</span> 
											            <span class="agency-text-center">:</span> 
											            <span><%= formattedSumInsured %></span>
											        </li>
											<% 
											    } 
											%>
											
											
											<% if (joDetail.has("OccupationClass") && !joDetail.getString("OccupationClass").isEmpty()) { %>
											<li>
												<span class="position-relative">Kelas Pekerjaan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("OccupationClass") %></span>
											</li>
											<% } %>
											
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- info data diri -->
				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Data Diri</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Political Exposed Persons (PEP)</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().isPep() ? "Ya" : "Tidak" %></span>
											</li>
											
											<% if (datas.getPolicyHolder().getName() != null && !datas.getPolicyHolder().getName().isEmpty()) { %>
											<li>
												<span class="position-relative">Nama</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getGender() != null && !datas.getPolicyHolder().getGender().isEmpty()) { %>
											<li>
												<span class="position-relative">Jenis Kelamin</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getGender().equalsIgnoreCase("F") ? "Perempuan" : "Laki-Laki" %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getBirthPlace() != null && !datas.getPolicyHolder().getBirthPlace().isEmpty()) { %>
											<li>
												<span class="position-relative">Tempat Lahir</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBirthPlace() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getDob() != null && !datas.getPolicyHolder().getDob().isEmpty()) { %>
											<li>
												<span class="position-relative">Tanggal Lahir</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%=datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
											        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
												</span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getAge() != null && !datas.getPolicyHolder().getAge().isEmpty()) { %>
											<li>
												<span class="position-relative">Usia</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAge() %> tahun</span>
											</li>
											<% } %>
											
											
											<% if (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) { %>
											<li>
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%= (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) ? datas.getPolicyHolder().getNationalityCountry() : datas.getPolicyHolder().getNationality() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getIdNumber() != null && !datas.getPolicyHolder().getIdNumber().isEmpty()) { %>
											<li>
												<span class="position-relative">No. KTP</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getIdNumber() %></span>
											</li>
											<% } %>
											
											<%
												String passportNumber = datas.getPolicyHolder().getPassportNumber();
												String kitasNumber = datas.getPolicyHolder().getKitasNumber();
												boolean hasPassportNumber = passportNumber != null && !passportNumber.isEmpty();
												boolean hasKitasNumber = kitasNumber != null && !kitasNumber.isEmpty();
											%>
											
											<% if (hasPassportNumber || hasKitasNumber) { %>
											    <li>
											        <span class="position-relative">
											        	<%= hasPassportNumber ? "No. Passpor" : "" %>
												        <%= hasPassportNumber && hasKitasNumber ? " / " : "" %>
												        <%= hasKitasNumber ? "No. Kitas" : "" %>
											        </span>
											        <span class="agency-text-center">:</span> 
											        <span>
											            <%= hasPassportNumber ? passportNumber : "" %>
												        <%= hasPassportNumber && hasKitasNumber ? " / " : "" %>
												        <%= hasKitasNumber ? kitasNumber : "" %>
											        </span>
											    </li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
											<li>
												<span class="position-relative">No. HP</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getMobilePhone() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getIdPhotoUrl() != null && !datas.getPolicyHolder().getIdPhotoUrl().isEmpty()) { %>
											<li>
												<span class="position-relative">Foto Identitas</span> 
												<span class="agency-text-center">:</span> 
													<span>
													<a href="<%=datas.getPolicyHolder().getIdPhotoUrl() %>"><img class="img-thumbnail" src="<%=datas.getPolicyHolder().getIdPhotoUrl() %>" alt="foto id"></a>
													</span>
											</li>
											<% } %>
											
											
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<% if (datas.getPolicyHolder().getEmail() != null && !datas.getPolicyHolder().getEmail().isEmpty()) { %>
											<li>
												<span class="position-relative">Email</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getAddress() != null && !datas.getPolicyHolder().getAddress().isEmpty()) { %>
											<li>
												<span class="position-relative">Alamat</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getProvince() != null && !datas.getPolicyHolder().getProvince().isEmpty()) { %>
											<li>
												<span class="position-relative">Provinsi</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getProvince() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getCity() != null && !datas.getPolicyHolder().getCity().isEmpty()) { %>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getCity() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getZip() != null && !datas.getPolicyHolder().getZip().isEmpty()) { %>
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getZip() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getJob() != null && !datas.getPolicyHolder().getJob().isEmpty()) { %>
											<li>
												<span class="position-relative">Pekerjaan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getJob() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getSalary() != null && !datas.getPolicyHolder().getSalary().isEmpty()) { %>
											<li>
												<span class="position-relative">Penghasilan Per Bulan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getSalary() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getBeneficiary() != null && !datas.getPolicyHolder().getBeneficiary().isEmpty()) { %>
											<li>
												<span class="position-relative">Nama Ahli Waris</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBeneficiary() %></span>
											</li>
											<% } %>
											
											<% if (datas.getPolicyHolder().getBeneficiaryRelationship() != null && !datas.getPolicyHolder().getBeneficiaryRelationship().isEmpty()) { %>
											<li>
												<span class="position-relative">Hubungan dengan Ahli Waris</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBeneficiaryRelationship() %></span>
											</li>
											<% } %>
											
											
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Jaminan</h4>
								<div class="panel-grid-guarantee">
									
									<table style="width: 100%; border-collapse: collapse; font-family: Arial, sans-serif; font-size: 12px; line-height: 1.8">
									    
									    	<tr>
									            <th style="border: 1px solid #ddd; padding: 8px; background-color: #005bbb; color: white; text-align: center; width: 10%;">No</th>
									            <th style="border: 1px solid #ddd; padding: 8px; background-color: #005bbb; color: white; text-align: center; width: 60%;">Jaminan<br /><i>Coverage</i></th>
									            <th style="border: 1px solid #ddd; padding: 8px; background-color: #005bbb; color: white; text-align: center; width: 30%;">Nilai Manfaat<br /><i>Benefit Limit</i><br />(<span class="currency">IDR</span>)</th>
									        </tr>
									        
									    
									    
									    <tbody id="dynamicTableBody">
									    </tbody>
									</table>
									
									
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>

<script>
	<%-- window.detail = <%= joDetail %>; --%>
	window.detail = <%= joDetail.toString() %>;
	/* alert('detail jsp>>'+detail); */
	window.curr = "<%=datas.getCurrency() %>";
	/* alert('detail curr>>'+curr); */
</script>

<script src="<%= request.getContextPath() %>/dashboard/portofolio/js/portofolio_online_detail_SA.js" type="text/javascript"></script>

