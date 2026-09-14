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
    JSONObject joInsured = (JSONObject) renderRequest.getAttribute("insured");
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
                                            <% if (datas.getStartDate() != null) { %>
                                                <li>
                                                    <span class="position-relative">Tanggal Mulai</span> 
                                                    <span class="agency-text-center">:</span> 
                                                    <span>
                                                        <fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="startDate" />
                                                        <fmt:formatDate value="${startDate}" pattern="dd MMM yyyy" />
                                                    </span>
                                                </li>
                                            <% } %>
                                            <% if (datas.getExpiredDate() != null) { %>
                                                <li>
                                                    <span class="position-relative">Tanggal Selesai</span> 
                                                    <span class="agency-text-center">:</span> 
                                                    <span>
                                                        <fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="expDate" />
                                                        <fmt:formatDate value="${expDate}" pattern="dd MMM yyyy" />
                                                    </span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("BuildingType") && !joDetail.getString("BuildingType").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Jenis Bangunan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("BuildingType") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("Description") && !joDetail.getString("Description").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Aktivitas/Deskripsi Kegiatan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("Description") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("RiskLossHistory") && !joDetail.getString("RiskLossHistory").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Riwayat kerugian 3 tahun terakhir</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("RiskLossHistory").equals("false") ? "Tidak":"Ya" %></span>
                                                </li>
                                            <% } %>
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul class="list-group mb-8level">
                                            <% if (joDetail.has("RiskAddress") && !joDetail.getString("RiskAddress").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Alamat/Lokasi Risiko</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("RiskAddress") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("RiskProvince") && !joDetail.getString("RiskProvince").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Propinsi</span> 
                                                    <span class="agency-text-center">:</span>
                                                    <span><%=joDetail.getString("RiskProvince") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("RiskCity") && !joDetail.getString("RiskCity").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kota</span> 
                                                    <span class="agency-text-center">:</span> 
                                                    <span><%=joDetail.getString("RiskCity") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("RiskKecamatan") && !joDetail.getString("RiskKecamatan").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kecamatan</span> 
                                                    <span class="agency-text-center">:</span> 
                                                    <span><%=joDetail.getString("RiskKecamatan") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("RiskZip") && !joDetail.getString("RiskZip").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kode Pos</span> 
                                                    <span class="agency-text-center">:</span> 
                                                    <span><%=joDetail.getString("RiskZip") %></span>
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
                                <h4 class="mb-4level">Detail Pemegang Polis</h4>
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
                                            <% if (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kewarganegaraan</span> 
                                                    <span class="agency-text-center">:</span> <span><%= (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) ? datas.getPolicyHolder().getNationalityCountry() : datas.getPolicyHolder().getNationality() %></span>
                                                </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getEmail() != null && !datas.getPolicyHolder().getEmail().isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Email</span> 
                                                    <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
                                                </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">No. HP</span> 
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
                                        <ul class="list-group">
                                            <% if (datas.getPolicyHolder().getBirthPlace() != null && !datas.getPolicyHolder().getBirthPlace().isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Tempat Lahir</span> 
                                                    <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBirthPlace() %></span>
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
                                                    <span class="position-relative">Propinsi</span> 
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
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- info Informasi Tertanggung -->
                <div class="panel-wrapper mb-4level">
                    <div class="panel">
                        <div class="panel-body border-grey">
                            <div class="px-6level py-8level">
                                <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Tertanggung</h4>
                                <div class="panel-grid">
                                    <div class="col">
                                        <ul class="list-group mb-8level">
                                        
                                        	
                                                <li>
                                                    <span class="position-relative">Political Exposed Persons (PEP)</span> 
                                                    <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().isPep() ? "Ya":"Tidak" %></span>
                                                </li>
                                            <% if (joInsured.has("Name") && !joInsured.getString("Name").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Nama</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Name") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("Gender") && !joInsured.getString("Gender").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Jenis Kelamin</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Gender").equalsIgnoreCase("F") ? "Perempuan" : "Laki-Laki" %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("BirthPlace") && !joInsured.getString("BirthPlace").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Tempat Lahir</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("BirthPlace") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("Dob") && !joInsured.getString("Dob").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Tanggal Lahir</span> 
                                                    <span class="agency-text-center">:</span> 
                                                    <span>
                                                        <fmt:parseDate value="<%=joInsured.getString("Dob") %>" pattern="yyyyMMdd" var="dob" />
                                                        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
                                                    </span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("NationalityCountry") && !joInsured.getString("NationalityCountry").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kewarganegaraan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("NationalityCountry") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("IdNumber") && !joInsured.getString("IdNumber").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">No. KTP</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("IdNumber") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("Email") && !joInsured.getString("Email").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Email</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Email") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("MobilePhone") && !joInsured.getString("MobilePhone").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">No. HP</span> 
                                                    <span class="agency-text-center">:</span> <span>+<%=joInsured.getString("MobilePhone") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("IdPhoto") && !joInsured.getString("IdPhoto").isEmpty()) { %>
														<li>
															<span class="position-relative">Foto Identitas</span> 
															<span class="agency-text-center">:</span>
															<span>
																<a href="<%=joInsured.getString("IdPhoto") %>"><img class="img-thumbnail" src="<%=joInsured.getString("IdPhoto") %>" alt="foto"></a>
															</span>
														</li>
													<% } %>
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul class="list-group mb-8level">
                                            <% if (joInsured.has("Address") && !joInsured.getString("Address").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Alamat</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Address") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("Province") && !joInsured.getString("Province").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Propinsi</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Province") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("City") && !joInsured.getString("City").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kota</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("City") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("Kecamatan") && !joInsured.getString("Kecamatan").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kecamatan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Kecamatan") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("Zip") && !joInsured.getString("Zip").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kode Pos</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Zip") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("Occupation") && !joInsured.getString("Occupation").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Pekerjaan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Occupation") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("IncomeSource") && !joInsured.getString("IncomeSource").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Sumber Penghasilan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("IncomeSource") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joInsured.has("Income") && !joInsured.getString("Income").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Penghasilan Perbulan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joInsured.getString("Income") %></span>
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
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Polis</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
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
													<fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="expDate" />
                           							<fmt:formatDate value="${expDate}" pattern="dd MMM yyyy" />
												</span>
											</li>
											<li>
												<span class="position-relative">Jenis Bangunan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("BuildingType") %></span>
											</li>
											<li>
												<span class="position-relative">Aktivitas/Deskripsi Kegiatan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("Description") %></span>
											</li>
											<li>
												<span class="position-relative">Riwayat kerugian 3 tahun terakhir</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("RiskLossHistory").equals("false") ? "Tidak":"Ya" %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Alamat/Lokasi Risiko</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("RiskAddress") %></span>
											</li>
											<li>
												<span class="position-relative">Propinsi</span> 
												<span class="agency-text-center">:</span>
												<span><%=joDetail.getString("RiskProvince") %></span>
											</li>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> 
												<span><%=joDetail.getString("RiskCity") %></span>
											</li>
											<li>
												<span class="position-relative">Kecamatan</span> 
												<span class="agency-text-center">:</span> 
												<span><%=joDetail.getString("RiskKecamatan") %></span>
											</li>
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> 
												<span><%=joDetail.getString("RiskZip") %></span>
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
												<span class="position-relative">Nama</span>
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Kelamin</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getGender().equalsIgnoreCase("F") ? "Perempuan":"Laki-Laki" %></span>
											</li>
											<li>
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getNationality() %></span>
											</li>
											<li>
												<span class="position-relative">Email</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
											</li>
											<li>
												<span class="position-relative">No. HP</span> 
												<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Tempat Lahir</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBirthPlace()%></span>
											</li>
											<li>
												<span class="position-relative">Alamat</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %></span>
											</li>
											<li>
												<span class="position-relative">Propinsi</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getProvince() %></span>
											</li>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getCity() %></span>
											</li>
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getZip() %></span>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- info Informasi Tertanggung -->
				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Tertanggung</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Political Exposed Persons (PEP)</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().isPep() ? "Ya":"TIdak" %></span>
											</li>
											<li>
												<span class="position-relative">Nama</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Name") %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Kelamin</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Gender").equalsIgnoreCase("F") ? "Perempuan" : "Laki-Laki" %></span>
											</li>
											<li>
												<span class="position-relative">Tempat Lahir</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("BirthPlace") %></span>
											</li>
											<li>
												<span class="position-relative">Tanggal Lahir</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%=joInsured.getString("Dob") %>" pattern="yyyyMMdd" var="dob" />
											        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
												</span>
											</li>
											<li>
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Nationality") %></span>
											</li>
											<li>
												<span class="position-relative">No. KTP</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("IdNumber") %></span>
											</li>
											<li>
												<span class="position-relative">Email</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Email") %></span>
											</li>
											<li>
												<span class="position-relative">No. HP</span> 
												<span class="agency-text-center">:</span> <span>+<%=joInsured.getString("MobilePhone") %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Alamat</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Address") %></span>
											</li>
											<li>
												<span class="position-relative">Propinsi</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Province") %></span>
											</li>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("City") %></span>
											</li>
											<li>
												<span class="position-relative">Kecamatan</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Kecamatan") %></span>
											</li>
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Zip") %></span>
											</li>
											<li>
												<span class="position-relative">Pekerjaan</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Occupation") %></span>
											</li>
											<li>
												<span class="position-relative">Sumber Penghasilan</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("IncomeSource") %></span>
											</li>
											<li>
												<span class="position-relative">Penghasilan Perbulan</span> 
												<span class="agency-text-center">:</span> <span><%=joInsured.getString("Income") %></span>
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

