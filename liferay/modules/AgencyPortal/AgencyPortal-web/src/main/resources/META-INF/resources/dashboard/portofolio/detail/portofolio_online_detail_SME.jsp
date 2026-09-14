<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="java.util.Map"%>
<%@page import="com.mypage.agencyportal.dto.DataDetailsLeadsDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../../../init.jsp"%>


<%
	DataDetailsLeadsDto datas = (DataDetailsLeadsDto) renderRequest.getAttribute("detailLeadsResponse");
    JSONObject joDetail = (JSONObject) renderRequest.getAttribute("detail");
%>

<!-- include navbar -->
<%@ include file="breadcrumbs.jsp" %>

<div class="dashboard">
	<div class="dashboard__portofolio-detail">
		<div class="container-axa">
			
			<!-- inluce rincian nasabah -->
			<%@ include file="rincian_transaksi_nasabah.jsp" %>
			
			<div class="dashboard__portofolio-product">
			
				<!-- main rincian product -->
				<%@ include file="rincian_produk.jsp" %>
			
				<div class="panel-wrapper mb-4level">
					<h1 class="mb-4level">Ringkasan Polis</h1>
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Perjalanan</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
                                            <% if (joDetail.has("CorporateName") && !joDetail.getString("CorporateName").isEmpty()) { %>
											<li>
												<span class="position-relative">Nama Perusahaan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("CorporateName") %></span>
											</li>
                                            <% } %>
                                            <% if (joDetail.has("CompanyType") && !joDetail.getString("CompanyType").isEmpty()) { %>
											<li>
												<span class="position-relative">Kategori Usaha</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("CompanyType") %></span>
											</li>
                                            <% } %>
                                            <% if (joDetail.has("BusinessType") && !joDetail.getString("BusinessType").isEmpty()) { %>
											<li>
												<span class="position-relative">Jenis Usaha</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("BusinessType") %></span>
											</li>
                                            <% } %>
                                            <% if (joDetail.has("CorporateAddress") && !joDetail.getString("CorporateAddress").isEmpty()) { %>
											<li>
												<span class="position-relative">Alamat Perusahaan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("CorporateAddress") %></span>
											</li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getCity() != null && !datas.getPolicyHolder().getCity().isEmpty()) { %>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getCity() %></span>
											</li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getProvince() != null && !datas.getPolicyHolder().getProvince().isEmpty()) { %>
											<li>
												<span class="position-relative">Provinsi</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getProvince() %></span>
											</li>
                                            <% } %>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
                                            <% if (datas.getPolicyHolder().getZip() != null && !datas.getPolicyHolder().getZip().isEmpty()) { %>
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getZip() %></span>
											</li>
                                            <% } %>
                                            <% if (datas.getStartDate() != null && !datas.getStartDate().isEmpty()) { %>
											<li>
												<span class="position-relative">Periode Awal Polis</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="startDate" />
                           							<fmt:formatDate value="${startDate}" pattern="dd MMM yyyy" />
												</span>
											</li>
                                            <% } %>
                                            <% if (datas.getExpiredDate() != null && !datas.getExpiredDate().isEmpty()) { %>
											<li>
												<span class="position-relative">Periode Akhir Polis</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="expiryDate" />
        											<fmt:formatDate value="${expiryDate}" pattern="dd MMM yyyy" />
												</span>
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
								
								<!-- ------------------------------------------- -->
								<h4 class="my-4level mb-4level">Detail Pemegang Polis</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group">
                                            <li>
												<span class="position-relative">Political Exposed Person (PEP)</span> 
												<span class="agency-text-center">:</span>
												<span><%=datas.getPolicyHolder().isPep() ? "Ya" : "Tidak" %></span>
											</li>
                                            <% if (datas.getPolicyHolder().getName() != null && !datas.getPolicyHolder().getName().isEmpty()) { %>
											<li>
												<span class="position-relative">Nama yang di tunjuk mewakili perusahaan (PIC)</span>
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
											</li>
                                            <% } %>
                                            <% if (joDetail.has("JobPosition") && !joDetail.getString("JobPosition").isEmpty()) { %>
											<li>
												<span class="position-relative">Jabatan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("JobPosition") %></span>
											</li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getIdNumber() != null && !datas.getPolicyHolder().getIdNumber().isEmpty()) { %>
											<li>
												<span class="position-relative">No. KTP</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getIdNumber() %></span>
											</li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getPassportNumber() != null && !datas.getPolicyHolder().getPassportNumber().isEmpty()) { %>
											<li>
												<span class="position-relative">No. Passpor</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getPassportNumber() %></span>
											</li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getKitasNumber() != null && !datas.getPolicyHolder().getKitasNumber().isEmpty()) { %>
											<li>
												<span class="position-relative">No. Kitas</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getKitasNumber() %></span>
											</li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) { %>
											<li>
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%= (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) ? datas.getPolicyHolder().getNationalityCountry() : datas.getPolicyHolder().getNationality() %></span>
											</li>
                                            <% } %>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
                                            <% if (joDetail.has("SumberDana") && !joDetail.getString("SumberDana").isEmpty()) { %>
											<li>
												<span class="position-relative">Darimana pembayaran premi bersumber?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("SumberDana") %></span>
											</li>
                                            <% } %>
                                            <% if (joDetail.has("AsuransiPurpose") && !joDetail.getString("AsuransiPurpose").isEmpty()) { %>
											<li>
												<span class="position-relative">Apa tujuan berasuransi?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("AsuransiPurpose") %></span>
											</li>
                                            <% } %>
                                            <% if (joDetail.has("AlreadyHavePolice") && !joDetail.getString("AlreadyHavePolice").isEmpty()) { %>
											<li>
												<span class="position-relative">Apakah memiliki polis lain di perusahaan kami?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("AlreadyHavePolice").equals("false") ? "Tidak" : "Ya" %></span>
											</li>
                                            <% } %>
                                            <% if (joDetail.has("TransferTo") && !joDetail.getString("TransferTo").isEmpty()) { %>
											<li>
												<span class="position-relative">Pembayaran klaim di transfer ke rekening?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("TransferTo") %></span>
											</li>
                                            <% } %>
										</ul>
									</div>
								</div>
								
								<div class="panel-download">
										<h4 class="my-4level">Unduh</h4>
										<div class="btn-flex">
										
											<% if (joDetail.has("Members") && !joDetail.getString("Members").isEmpty()) { %>
												<a onclick="downloadMembers('<%=joDetail.getString("Members") %>')" class="btn btn__agency btn--dark-blue-outline agency-pointer">
													<span class="position-relative order-10">Daftar Member</span>
												</a>
                                            <% } %>
											<% if (joDetail.has("Documents") && !joDetail.getString("Documents").isEmpty()) { %>
												<a onclick="downloadDocs('<%=joDetail.getString("Documents") %>')" class="btn btn__agency btn--dark-blue agency-pointer">
													<span class="position-relative order-10">Kelengkapan Dokumen</span>
												</a>
											<% } %>
										</div>
									</div>
								
							</div>
							
							
							
						</div>
					</div>
				</div>

				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="border-b-grey">
								<div class="panel-grid">
									<div class="col">
										<div class="px-6level py-8level">
											<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Kontak Darurat</h4>
											<ul class="list-group">
                                                <% if (datas.getPolicyHolder().getName() != null && !datas.getPolicyHolder().getName().isEmpty()) { %>
												<li>
													<span class="position-relative">Nama</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
												</li>
                                                <% } %>
                                                <% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
												<li>
													<span class="position-relative">No. Handphone</span> 
													<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
												</li>
                                                <% } %>
											</ul>
										</div>
									</div>
									<div class="col">
										<div class="px-6level py-8level">
											<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Kontak Darurat</h4>
											<ul class="list-group">
                                                <% if (datas.getPolicyHolder().getEmail() != null && !datas.getPolicyHolder().getEmail().isEmpty()) { %>
												<li>
													<span class="position-relative">Alamat Email</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
												</li>
                                                <% } %>
                                                <% if (datas.getPolicyHolder().getPhone() != null && !datas.getPolicyHolder().getPhone().isEmpty()) { %>
												<li>
													<span class="position-relative">No. Telepon</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getPhone() %></span>
												</li>
                                                <% } %>
                                                
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<%-- <div class="dashboard">
	<div class="dashboard__portofolio-detail">
		<div class="container-axa">
			
			<!-- inluce rincian nasabah -->
			<%@ include file="rincian_transaksi_nasabah.jsp" %>
			
			<div class="dashboard__portofolio-product">
			
				<!-- main rincian product -->
				<%@ include file="rincian_produk.jsp" %>
			
				<div class="panel-wrapper mb-4level">
					<h1 class="mb-4level">Ringkasan Polis</h1>
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Perjalanan</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Nama Perusahaan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("CorporateName") %></span>
											</li>
											<li>
												<span class="position-relative">Kategori Usaha</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("CompanyType") %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Usaha</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("BusinessType") %></span>
											</li>
											<li>
												<span class="position-relative">Alamat Perusahaan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("CorporateAddress") %></span>
											</li>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getCity() %></span>
											</li>
											<li>
												<span class="position-relative">Provinsi</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getProvince() %></span>
											</li>
											
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getZip() %></span>
											</li>
											<li>
												<span class="position-relative">Periode Awal Polis</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="startDate" />
                           							<fmt:formatDate value="${startDate}" pattern="dd MMM yyyy" />
												</span>
											</li>
											<li>
												<span class="position-relative">Periode Akhir Polis</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="expiryDate" />
        											<fmt:formatDate value="${expiryDate}" pattern="dd MMM yyyy" />
												</span>
											</li>
											
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
								<h4 class="mb-4level">Detail Pemegang Polis</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Political Exposed Person (PEP)</span> 
												<span class="agency-text-center">:</span>
												<span><%=datas.getPolicyHolder().isPep() ? "Ya" : "Tidak" %></span>
											</li>
											<li>
												<span class="position-relative">Nama yang di tunjuk mewakili perusahaan (PIC)</span>
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
											</li>
											<li>
												<span class="position-relative">Jabatan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("JobPosition") %></span>
											</li>
											<li>
												<span class="position-relative">No. KTP</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getIdNumber() %></span>
											</li>
											<li>
												<span class="position-relative">No. Passpor</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getPassportNumber() %></span>
											</li>
											<li>
												<span class="position-relative">No. Kitas</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getKitasNumber() %></span>
											</li>
											<li>
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getNationality() %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Darimana pembayaran premi bersumber?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("SumberDana") %></span>
											</li>
											<li>
												<span class="position-relative">Apa tujuan berasuransi?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("AsuransiPurpose") %></span>
											</li>
											<li>
												<span class="position-relative">Apakah memiliki polis lain di perusahaan kami?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("AlreadyHavePolice").equals("false") ? "Tidak" : "Ya" %></span>
											</li>
											<li>
												<span class="position-relative">Pembayaran klaim di transfer ke rekening?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("TransferTo") %></span>
											</li>
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
							<div class="border-b-grey">
								<div class="panel-grid">
									<div class="col">
										<div class="px-6level py-8level">
											<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Kontak Darurat</h4>
											<ul class="list-group">
												<li>
													<span class="position-relative">Nama</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
												</li>
												<li>
													<span class="position-relative">Pekerjaan</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getJob() %></span>
												</li>
											</ul>
										</div>
									</div>
									<div class="col">
										<div class="px-6level py-8level">
											<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Kontak Darurat</h4>
											<ul class="list-group">
												<li>
													<span class="position-relative">Alamat Email</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
												</li>
												<li>
													<span class="position-relative">Nomor Handphone</span> 
													<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> --%>


<script>

function downloadMembers(url) {
	console.log('hit member>>' ,url)
    window.open(url, '_blank');
	
}

function downloadDocs(url) {
	console.log('hit docs>>' ,url)
	window.open(url, '_blank');
	//parent.location.href = url;
}


</script>
