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
            
            <!-- include rincian nasabah -->
            <%@ include file="rincian_transaksi_nasabah.jsp" %>
            
            <div class="dashboard__portofolio-product">
            
                <!-- include rincian produk -->
                <%@ include file="rincian_produk.jsp" %>
            
                <div class="panel-wrapper mb-4level">
                    <h1 class="mb-4level">Ringkasan Polis</h1>
                    <div class="panel">
                        <div class="panel-body border-grey">
                            <div class="px-6level py-8level">
                                <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Properti</h4>
                                <div class="panel-grid">
                                    <div class="col">
                                        <ul class="list-group mb-8level">
                                            <% if (joDetail.has("BuildingAddress") && !joDetail.getString("BuildingAddress").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Lokasi</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("BuildingAddress") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("Province") && !joDetail.getString("Province").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Propinsi</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("Province") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("City") && !joDetail.getString("City").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kota</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("City") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("Kecamatan") && !joDetail.getString("Kecamatan").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kecamatan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("Kecamatan") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("Kelurahan") && !joDetail.getString("Kelurahan").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kelurahan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("Kelurahan") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("BuildingZip") && !joDetail.getString("BuildingZip").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kode Pos</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("BuildingZip") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("FrontBuilding") && !joDetail.getString("FrontBuilding").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Bagian Depan Bangunan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("FrontBuilding") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("BackBuilding") && !joDetail.getString("BackBuilding").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Bagian Belakang Bangunan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("BackBuilding") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("RightSideBuilding") && !joDetail.getString("RightSideBuilding").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Bagian Samping Kanan Bangunan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("RightSideBuilding") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("LeftSideBuilding") && !joDetail.getString("LeftSideBuilding").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Bagian Samping Kiri Bangunan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("LeftSideBuilding") %></span>
                                                </li>
                                            <% } %>
                                            <% if (datasRes.getCurrency() != null && !datasRes.getCurrency().isEmpty() && joDetail.has("BuildingCoverage")) { %>
                                                <li>
                                                    <span class="position-relative">Harga Pertanggungan Bangunan</span> 
                                                    <span class="agency-text-center">:</span> 
                                                    <span>
                                                        <%=datasRes.getCurrency() %> 
                                                        <fmt:setLocale value="id_ID" />
                                                        <fmt:formatNumber value="<%=joDetail.getString("BuildingCoverage") %>" type="number" />
                                                    </span>
                                                </li>
                                            <% } %>
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul class="list-group mb-8level">
                                            <% if (joDetail.has("PropertyOccupancy") && !joDetail.getString("PropertyOccupancy").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Jenis Hunian</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("PropertyOccupancy") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("PropertyCoverType") && !joDetail.getString("PropertyCoverType").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Jenis Cover</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("PropertyCoverType") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("PropertyConstructionClass") && !joDetail.getString("PropertyConstructionClass").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kelas Kontruksi</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("PropertyConstructionClass") %></span>
                                                </li>
                                            <% } %>
                                            <% if (joDetail.has("EarthquakeCover") && !joDetail.getString("EarthquakeCover").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Perlindungan Gempa</span> 
                                                    <span class="agency-text-center">:</span> <span><%=joDetail.getString("EarthquakeCover").equalsIgnoreCase("false") ? "Tidak" : "Ya" %></span>
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
                                                    <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().isPep() ? "Ya":"Tidak" %></span>
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
                                            <% if (datas.getPolicyHolder().getDob() != null) { %>
                                                <li>
                                                    <span class="position-relative">Tanggal Lahir</span> 
                                                    <span class="agency-text-center">:</span> 
                                                    <span>
                                                        <fmt:parseDate value="<%=datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
                                                        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
                                                    </span>
                                                </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Kewarganegaraan</span> 
                                                    <span class="agency-text-center">:</span> <span><%= (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) ? datas.getPolicyHolder().getNationalityCountry() : datas.getPolicyHolder().getNationality() %></span>
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
                                        <ul class="list-group mb-8level">
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
											        <%-- No. Passpor<% if (hasKitasNumber) { %> / No. Kitas<% } %> --%>
											        	<%= hasPassportNumber ? "No. Passpor" : "" %>
												        <%= hasPassportNumber && hasKitasNumber ? " / " : "" %>
												        <%= hasKitasNumber ? "No. Kitas" : "" %>
											        </span>
											        <span class="agency-text-center">:</span> 
											        <span>
											            <%-- <%= hasPassportNumber ? passportNumber : "" %>
											            <% if (hasKitasNumber) { %>/ <%= kitasNumber %><% } %> --%>
											            <%= hasPassportNumber ? passportNumber : "" %>
												        <%= hasPassportNumber && hasKitasNumber ? " / " : "" %>
												        <%= hasKitasNumber ? kitasNumber : "" %>
											        </span>
											    </li>
											<% } %>
                                            
                                            <% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">No. HP</span> 
                                                    <span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
                                                </li>
                                            <% } %>
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
                                            <% if (datas.getPolicyHolder().getJob() != null && !datas.getPolicyHolder().getJob().isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Pekerjaan</span> 
                                                    <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getJob() %></span>
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
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Properti</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Lokasi</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("BuildingAddress") %></span>
											</li>
											<li>
												<span class="position-relative">Propinsi</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("Province") %></span>
											</li>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("City") %></span>
											</li>
											<li>
												<span class="position-relative">Kecamatan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("Kecamatan") %></span>
											</li>
											<li>
												<span class="position-relative">Kelurahan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("Kelurahan") %></span>
											</li>
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("BuildingZip") %></span>
											</li>
											<li>
												<span class="position-relative">Bagian Depan Bangunan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("FrontBuilding") %></span>
											</li>
											<li>
												<span class="position-relative">Bagian Belakang Bangunan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("BackBuilding") %></span>
											</li>
											<li>
												<span class="position-relative">Bagian Samping Kanan Bangunan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("RightSideBuilding") %></span>
											</li>
											<li>
												<span class="position-relative">Bagian Samping Kiri Bangunan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("LeftSideBuilding") %></span>
											</li>
											<li>
												<span class="position-relative">Harga Pertanggungan Bangunan</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<%=datasRes.getCurrency() %> 
							                        <fmt:setLocale value="id_ID" />
							                        <fmt:formatNumber value="<%=joDetail.getString("BuildingCoverage") %>" type="number" />
												</span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Jenis Hunian</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PropertyOccupancy") %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Cover</span> 
												<span class="agency-text-center">:</span>
												<span><%=joDetail.getString("PropertyCoverType") %></span>
											</li>
											<li>
												<span class="position-relative">Kelas Kontruksi</span> 
												<span class="agency-text-center">:</span> 
												<span><%=joDetail.getString("PropertyConstructionClass") %></span>
											</li>
											<li>
												<span class="position-relative">Perlindungan Gempa</span> 
												<span class="agency-text-center">:</span> 
												<span><%=joDetail.getString("EarthquakeCover").equalsIgnoreCase("false") ? "Tidak" : "Ya" %></span>
											</li>
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
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().isPep() ? "Ya":"TIdak" %></span>
											</li>
											<li>
												<span class="position-relative">Nama</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Kelamin</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getGender().equalsIgnoreCase("F") ? "Perempuan" : "Laki-Laki" %></span>
											</li>
											<li>
												<span class="position-relative">Tempat Lahir</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBirthPlace() %></span>
											</li>
											<li>
												<span class="position-relative">Tanggal Lahir</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%=datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
											        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
												</span>
											</li>
											<li>
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getNationality() %></span>
											</li>
											<li>
												<span class="position-relative">Foto Identitas</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<a href="<%=datas.getPolicyHolder().getIdPhoto() %>"><img class="img-thumbnail" src="<%=datas.getPolicyHolder().getIdPhoto() %>" alt="foto"></a>
												</span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">No. KTP</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getIdNumber() %></span>
											</li>
											<li>
												<span class="position-relative">No. HP</span> 
												<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
											</li>
											<li>
												<span class="position-relative">Email</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
											</li>
											<li>
												<span class="position-relative">Alamat</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %></span>
											</li>
											<li>
												<span class="position-relative">Pekerjaan</span> 
												<span class="agency-text-center">:</span> 
												<span><%=datas.getPolicyHolder().getJob() %></span>
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

