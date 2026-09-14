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
	JSONArray insureds = (JSONArray) renderRequest.getAttribute("insureds");
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
								<div class="panel-grid">
									<div class="col">
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Plan Terpilih</h4>
										<ul class="list-group mb-8level">
											<% if (joDetail.has("PlanName") && !joDetail.getString("PlanName").isEmpty()) { %>
												<li>
													<span class="position-relative">Nama plan</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("PlanName") %></span>
												</li>
											<% } %>
										</ul>
										
									</div>
									<div class="col">
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Periode Polis</h4>
										<ul
											class="list-group display-block flex-justify-between-lg mb-8level">
											<% if (datas.getStartDate() != null && !datas.getStartDate().isEmpty()) { %>
												<li>
													<span class="position-relative">Tanggal Mulai</span>
													<span class="agency-text-center">:</span> 
													<span>
														<fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="startDate" />
												        <fmt:formatDate value="${startDate}" pattern="dd MMM yyyy" />
													</span>
												</li>
											<% } %>
											<% if (datas.getExpiredDate() != null && !datas.getExpiredDate().isEmpty()) { %>
											<li>
												<span class="position-relative">Tanggal Selesai</span> 
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
								<div class="panel-grid">
									<% for(int i = 0 ; i < insureds.length(); i++ ) { 
										JSONObject insuredObj = insureds.getJSONObject(i);
										
										String labelDataTertanggung = "Data Tertanggung ";
										if(insuredObj.getString("Relationship").toLowerCase().equalsIgnoreCase("spouse")){
											labelDataTertanggung += "Pasangan";
										}else if(insuredObj.getString("Relationship").toLowerCase().contains("child")){
											labelDataTertanggung += insuredObj.getString("Relationship").replace("Child", "Anak ");
										}
											
										String genderFormat = insuredObj.getString("Gender").equals("M") ? "Laki-Laki" : "Perempuan";
										
										%>
										
										<div class="col">
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level"><%=labelDataTertanggung %></h4>
										<ul class="list-group mb-8level">
											<% if (insuredObj.has("Name") && !insuredObj.getString("Name").isEmpty()) { %>
												<li>
													<span class="position-relative">Nama</span> 
													<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Name") %></span>
												</li>
											<% } %>
											<% if (insuredObj.has("Email") && !insuredObj.getString("Email").isEmpty()) { %>
												<li>
													<span class="position-relative">Email</span> 
													<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Email") %></span>
												</li>
											<% } %>
											<% if (insuredObj.has("IdNumber") && !insuredObj.getString("IdNumber").isEmpty()) { %>
												<li>
													<span class="position-relative">No. Identitas</span>
													<span class="agency-text-center">:</span> <span><%=insuredObj.getString("IdNumber") %></span>
												</li>
											<% } %>
											<% if (insuredObj.has("Dob") && !insuredObj.getString("Dob").isEmpty()) { %>
												<li>
													<span class="position-relative">Tanggal Lahir</span>
													<span class="agency-text-center">:</span> 
													<span>
														<fmt:parseDate value="<%= insuredObj.getString("Dob") %>" pattern="yyyyMMdd" var="dob" />
												        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
											       </span>
												</li>
											<% } %>
											<% if (insuredObj.has("NationalityCountry") && !insuredObj.getString("NationalityCountry").isEmpty()) { %>
												<li>
													<span class="position-relative">Kewarganegaraan</span> 
													<span class="agency-text-center">:</span> <span><%=insuredObj.getString("NationalityCountry") %></span>
												</li>
											<% } %>
											<% if (insuredObj.has("Gender") && !insuredObj.getString("Gender").isEmpty()) { %>
											<li>
												<span class="position-relative">Jenis Kelamin</span>
												<span class="agency-text-center">:</span> <span><%=genderFormat %></span>
											</li>
											<% } %>
										</ul>
									</div>
									<%  } %>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<div class="panel-grid">
									<div class="col">
										<h4 class="mb-4level">Detail Pemegang Polis</h4>
										<ul class="list-group">
											<li>
												<span class="position-relative">Political Exposed Person (PEP)</span> 
												<span class="agency-text-center">:</span>
												<span><%=datas.getPolicyHolder().isPep() ? "Ya" : "Tidak" %></span>
											</li>
											
											<% if (datas.getPolicyHolder().getBirthPlace() != null && !datas.getPolicyHolder().getBirthPlace().isEmpty()) { %>
												<li>
													<span class="position-relative">Tempat lahir</span>
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBirthPlace() %></span>
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
											<% if (datas.getPolicyHolder().getAddress() != null && !datas.getPolicyHolder().getAddress().isEmpty()) { %>
												<li>
													<span class="position-relative">Alamat</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %>, <%=datas.getPolicyHolder().getZip() %></span>
												</li>
											<% } %>
												<li>
													<span class="position-relative">Alamat Surat menyurat sama dengan KTP</span> 
													<span class="agency-text-center">:</span>
													<span><%=datas.isCommercialOffers() ? "Ya" : "Tidak" %></span>
												</li>
											<% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
												<li>
													<span class="position-relative">Nomor Handphone</span> 
													<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
												</li>
											<% } %>
											<% if (datas.getPolicyHolder().getIdPhoto() != null && !datas.getPolicyHolder().getIdPhoto().isEmpty()) { %>
												<li>
													<span class="position-relative">Foto Identitas</span> 
													<span class="agency-text-center">:</span> 
													<span>
														<a href="<%=datas.getPolicyHolder().getIdPhoto() %>"><img class="img-thumbnail" src="<%=datas.getPolicyHolder().getIdPhoto() %>" alt="foto"></a>
													</span>
												</li>
											<% } %>
										</ul>
									</div>
									<div class="col">
										<h4 class="mb-4level">Detail Pekerjaan</h4>
										<ul class="list-group">
											<% if (joDetail.has("JobType") && !joDetail.getString("JobType").isEmpty()) { %>
												<li>
													<span class="position-relative">Jenis Pekerjaan</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("JobType") %></span>
												</li>
											<% } %>
											<% if (joDetail.has("Job") && !joDetail.getString("Job").isEmpty()) { %>
												<li>
													<span class="position-relative">Pekerjaan</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("Job") %></span>
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
							<div class="panel-grid">
								<div class="col-span-12-12">
									<div class="px-6level py-8level">
										<h4 class="mb-4level">Detail Rekening Bank</h4>
										<ul class="list-group column-responsive">
											<% if (joDetail.has("AccountBankNumber") && !joDetail.getString("AccountBankNumber").isEmpty()) { %>
												<li>
													<span class="position-relative">Nomor rekening</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("AccountBankNumber") %></span>
												</li>
											<% } %>
											<% if (joDetail.has("AccountBankName") && !joDetail.getString("AccountBankName").isEmpty()) { %>
												<li>
													<span class="position-relative">Nama Pemilik rekening</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("AccountBankName") %></span>
												</li>
											<% } %>
											<% if (joDetail.has("BankName") && !joDetail.getString("BankName").isEmpty()) { %>
												<li>
													<span class="position-relative">Nama Bank</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("BankName") %></span>
												</li>
											<% } %>
											<% if (joDetail.has("AlreadyHavePolice") && !joDetail.getString("AlreadyHavePolice").isEmpty()) { %>
												<li>
													<span class="position-relative">apakah memiliki polis lain di axa </span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("AlreadyHavePolice").equals("false") ? "Tidak" : "Ya"  %></span>
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
								<div class="panel-grid">
									<div class="col">
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Plan Terpilih</h4>
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Nama plan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PlanName") %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Periode Polis</h4>
										<ul
											class="list-group display-block flex-justify-between-lg mb-8level">
											<li>
												<span class="position-relative">Tanggal Mulai</span>
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="startDate" />
											        <fmt:formatDate value="${startDate}" pattern="dd MMM yyyy" />
												</span>
											</li>
											<li>
												<span class="position-relative">Tanggal Selesai</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="expiryDate" />
        											<fmt:formatDate value="${expiryDate}" pattern="dd MMM yyyy" />
												</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="panel-grid">
									<% for(int i = 0 ; i < insureds.length(); i++ ) { 
										JSONObject insuredObj = insureds.getJSONObject(i);
										
										String labelDataTertanggung = "Data Tertanggung ";
										if(insuredObj.getString("Relationship").toLowerCase().equalsIgnoreCase("spouse")){
											labelDataTertanggung += "Pasangan";
										}else if(insuredObj.getString("Relationship").toLowerCase().contains("child")){
											labelDataTertanggung += insuredObj.getString("Relationship").replace("Child", "Anak ");
										}
											
										String genderFormat = insuredObj.getString("Gender").equals("M") ? "Laki-Laki" : "Perempuan";
										
										%>
										
										<div class="col">
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level"><%=labelDataTertanggung %></h4>
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Nama</span> 
												<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Name") %></span>
											</li>
											<li>
												<span class="position-relative">Email</span> 
												<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Email") %></span>
											</li>
											<li>
												<span class="position-relative">No. Identitas</span>
												<span class="agency-text-center">:</span> <span><%=insuredObj.getString("IdNumber") %></span>
											</li>
											<li>
												<span class="position-relative">Tanggal Lahir</span>
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= insuredObj.getString("Dob") %>" pattern="yyyyMMdd" var="dob" />
											        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
										       </span>
											</li>
											<li>
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Nationality") %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Kelamin</span>
												<span class="agency-text-center">:</span> <span><%=genderFormat %></span>
											</li>
										</ul>
									</div>
									<%  } %>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<div class="panel-grid">
									<div class="col">
										<h4 class="mb-4level">Detail Pemegang Polis</h4>
										<ul class="list-group">
											<li>
												<span class="position-relative">Political Exposed Person (PEP)</span> 
												<span class="agency-text-center">:</span>
												<span><%=datas.getPolicyHolder().isPep() ? "Ya" : "Tidak" %></span>
											</li>
											<li>
												<span class="position-relative">Tempat lahir</span>
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBirthPlace() %></span>
											</li>
											<li>
												<span class="position-relative">Provinsi</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getProvince() %></span>
											</li>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getCity() %></span>
											</li>
											<li>
												<span class="position-relative">Alamat</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %>, <%=datas.getPolicyHolder().getZip() %></span>
											</li>
											<li>
												<span class="position-relative">Alamat Surat menyurat sama dengan KTP</span> 
												<span class="agency-text-center">:</span>
												<span><%=datas.isCommercialOffers() ? "Ya" : "Tidak" %></span>
											</li>
											<li>
												<span class="position-relative">Nomor handphone</span> 
												<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<h4 class="mb-4level">Detail Pekerjaan Pemegang Polis</h4>
										<ul class="list-group">
											<li>
												<span class="position-relative">Jenis Pekerjaan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("JobType") %></span>
											</li>
											<li>
												<span class="position-relative">Pekerjaan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("Job") %></span>
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
							<div class="panel-grid">
								<div class="col-span-12-12">
									<div class="px-6level py-8level">
										<h4 class="mb-4level">Detail Rekening Bank</h4>
										<ul class="list-group column-responsive">
											<li>
												<span class="position-relative">Nomor rekening</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("AccountBankNumber") %></span>
											</li>
											<li>
												<span class="position-relative">Nama Pemilik rekening</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("AccountBankName") %></span>
											</li>
											<li>
												<span class="position-relative">Nama Bank</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("BankName") %></span>
											</li>
											<li>
												<span class="position-relative">apakah memiliki polis lain di axa </span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("AlreadyHavePolice").equals("false") ? "Tidak" : "Ya"  %></span>
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
</div> --%>
