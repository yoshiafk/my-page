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
    JSONArray jaAksesories = (JSONArray) renderRequest.getAttribute("accessories");
    JSONArray jaCoverage = (JSONArray) renderRequest.getAttribute("coverages");
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
                                <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Kendaraan</h4>
                                <div class="panel-grid">
                                    <div class="col">
                                        <ul class="list-group mb-8level">
                                            <% if (joDetail.has("PoliceNumber") && !joDetail.getString("PoliceNumber").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Nomor Polisi</span> 
                                                <span class="agency-text-center">:</span> <span><%= joDetail.getString("PoliceNumber") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("VehicleManufacture") && !joDetail.getString("VehicleManufacture").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Merek Mobil</span> 
                                                <span class="agency-text-center">:</span> <span><%= joDetail.getString("VehicleManufacture") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("ManufactureYear") && !joDetail.getString("ManufactureYear").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Tahun Pembuatan</span> 
                                                <span class="agency-text-center">:</span> <span><%= joDetail.getString("ManufactureYear") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("VehicleModel") && !joDetail.getString("VehicleModel").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Model Mobil</span> 
                                                <span class="agency-text-center">:</span> <span><%= joDetail.getString("VehicleModel") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("VehicleSubModel") && !joDetail.getString("VehicleSubModel").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Seri Mobil</span> 
                                                <span class="agency-text-center">:</span> <span><%= joDetail.getString("VehicleSubModel") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("EngineNumber") && !joDetail.getString("EngineNumber").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Nomor Mesin</span> 
                                                <span class="agency-text-center">:</span> <span><%= joDetail.getString("EngineNumber") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("ChassisNumber") && !joDetail.getString("ChassisNumber").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Nomor Kerangka</span> 
                                                <span class="agency-text-center">:</span> <span><%= joDetail.getString("ChassisNumber") %></span>
                                            </li>
                                            <% } %>
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul class="list-group mb-8level">
                                            <% if (joDetail.has("CoverageType") && !joDetail.getString("CoverageType").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Plan</span> 
                                                <span class="agency-text-center">:</span> <span><%= joDetail.getString("CoverageType") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("SumInsured") && !joDetail.getString("SumInsured").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Harga Jual Mobil</span> 
                                                <span class="agency-text-center">:</span> 
                                                <span>
                                                    <%= datas.getCurrency() %> 
                                                    <fmt:setLocale value="id_ID" />
                                                    <fmt:formatNumber value="<%= joDetail.getString("SumInsured") %>" type="number" />
                                                </span>
                                            </li>
                                            <% } %>
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
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel-wrapper mb-4level">
                    <div class="panel">
                        <div class="panel-body border-grey">
                            <div class="px-6level py-8level">
                                <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Pemegang Polis</h4>
                                <div class="panel-grid">
                                    <div class="col">
                                        <ul class="list-group">
                                            <% 
                                                String idNumber = datas.getPolicyHolder().getIdNumber();
                                             %>
                                            <li>
                                                <span class="position-relative">Political Exposed Person (PEP)</span> 
                                                <span class="agency-text-center">:</span>
                                                <span><%=datas.getPolicyHolder().isPep() ? "Ya" : "Tidak" %></span>
                                            </li>
                                            
                                            <% if (datas.getPolicyHolder().getName() != null && !datas.getPolicyHolder().getName().isEmpty()) { %>
	                                            <li>
	                                                <span class="position-relative">Nama Lengkap</span>
	                                                <span class="agency-text-center">:</span> <span><%= datas.getPolicyHolder().getName() %></span>
	                                            </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getBirthPlace() != null && !datas.getPolicyHolder().getBirthPlace().isEmpty()) { %>
	                                            <li>
	                                                <span class="position-relative">Tempat Lahir</span> 
	                                                <span class="agency-text-center">:</span> <span><%= datas.getPolicyHolder().getBirthPlace() %></span>
	                                            </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getDob() != null && !datas.getPolicyHolder().getDob().isEmpty()) { %>
	                                            <li>
	                                                <span class="position-relative">Tanggal Lahir</span> 
	                                                <span class="agency-text-center">:</span> 
	                                                <span>
	                                                    <fmt:parseDate value="<%= datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
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
                                            <% if (idNumber != null && !idNumber.isEmpty()) { %>
	                                            <li>
	                                                <span class="position-relative">No. KTP</span> 
	                                                <span class="agency-text-center">:</span> <span><%= idNumber %></span>
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
	                                                <span class="position-relative">Nomor HP</span> 
	                                                <span class="agency-text-center">:</span> <span>+<%= datas.getPolicyHolder().getMobilePhone() %></span>
	                                            </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getEmail() != null && !datas.getPolicyHolder().getEmail().isEmpty()) { %>
	                                            <li>
	                                                <span class="position-relative">Email</span> 
	                                                <span class="agency-text-center">:</span> <span><%= datas.getPolicyHolder().getEmail() %></span>
	                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("KwitansiImage") && !joDetail.getString("KwitansiImage").isEmpty()) { %>
	                                            <li>
	                                                <span class="position-relative">Foto Kwitansi</span> 
	                                                <span class="agency-text-center">:</span>
	                                                <span>
	                                                    <a href="<%= joDetail.getString("KwitansiImage") %>">
	                                                        <img class="img-thumbnail img-fluid" src="<%= joDetail.getString("KwitansiImage") %>" alt="foto kwitansi" width="200">
	                                                    </a>
	                                                </span>
	                                            </li>
                                            <% } %>
                                            
                                            <!-- foto mobil -->
                                            <% if (joDetail.has("FrontVehicleImage") && !joDetail.getString("FrontVehicleImage").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Foto sisi depan</span> 
                                                <span class="agency-text-center">:</span> 
                                                <span>
                                                    <a href="<%= joDetail.getString("FrontVehicleImage") %>">
                                                        <img class="img-thumbnail img-fluid" src="<%= joDetail.getString("FrontVehicleImage") %>" alt="FrontVehicleImage" width="200">
                                                    </a>
                                                </span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("RightSideVehicleImage") && !joDetail.getString("RightSideVehicleImage").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Foto samping kanan</span> 
                                                <span class="agency-text-center">:</span>
                                                <span>
                                                    <a href="<%= joDetail.getString("RightSideVehicleImage") %>">
                                                        <img class="img-thumbnail img-fluid" src="<%= joDetail.getString("RightSideVehicleImage") %>" alt="RightSideVehicleImage" width="200">
                                                    </a>
                                                </span> 
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("STNKImage") && !joDetail.getString("STNKImage").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Foto STNK</span> 
                                                <span class="agency-text-center">:</span>
                                                <span>
                                                    <a href="<%= joDetail.getString("STNKImage") %>">
                                                        <img class="img-thumbnail img-fluid" src="<%= joDetail.getString("STNKImage") %>" alt="STNKImage" width="200">
                                                    </a>
                                                </span> 
                                            </li>
                                            <% } %>
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul class="list-group">
                                            <% if (datas.getPolicyHolder().getAddress() != null && !datas.getPolicyHolder().getAddress().isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Alamat</span> 
                                                <span class="agency-text-center">:</span> <span><%= datas.getPolicyHolder().getAddress() %></span>
                                            </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getProvince() != null && !datas.getPolicyHolder().getProvince().isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Propinsi</span> 
                                                <span class="agency-text-center">:</span> <span><%= datas.getPolicyHolder().getProvince() %></span>
                                            </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getCity() != null && !datas.getPolicyHolder().getCity().isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Kota</span> 
                                                <span class="agency-text-center">:</span> <span><%= datas.getPolicyHolder().getCity() %></span>
                                            </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getZip() != null && !datas.getPolicyHolder().getZip().isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Kode Pos</span> 
                                                <span class="agency-text-center">:</span> <span><%= datas.getPolicyHolder().getZip() %></span>
                                            </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getJob() != null && !datas.getPolicyHolder().getJob().isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Pekerjaan</span> 
                                                <span class="agency-text-center">:</span> <span><%= datas.getPolicyHolder().getJob() %></span>
                                            </li>
                                            <% } %>
                                            
                                            <!-- foto mobil -->
                                            <% if (joDetail.has("LeftSideVehicleImage") && !joDetail.getString("LeftSideVehicleImage").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Foto samping kiri</span> 
                                                <span class="agency-text-center">:</span>
                                                <span>
                                                    <a href="<%= joDetail.getString("LeftSideVehicleImage") %>">
                                                        <img class="img-thumbnail img-fluid" src="<%= joDetail.getString("LeftSideVehicleImage") %>" alt="LeftSideVehicleImage" width="200">
                                                    </a>
                                                </span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("RearVehicleImage") && !joDetail.getString("RearVehicleImage").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Foto sisi Belakang</span> 
                                                <span class="agency-text-center">:</span>
                                                <span>
                                                    <a href="<%= joDetail.getString("RearVehicleImage") %>">
                                                        <img class="img-thumbnail img-fluid" src="<%= joDetail.getString("RearVehicleImage") %>" alt="RearVehicleImage" width="200">
                                                    </a>
                                                </span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("Files") && !joDetail.getString("Files").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Lainnya (KTP/SIUP/TDP)</span> 
                                                <span class="agency-text-center">:</span>
                                                <span>
                                                    <a href="<%= joDetail.getString("Files") %>">
                                                        <img class="img-thumbnail img-fluid" src="<%= joDetail.getString("Files") %>" alt="Filesimage" width="200">
                                                    </a>
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
                            <div class="border-b-grey">
                                <div class="px-6level py-8level">
                                    <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Aksesoris</h4>
                                    <div class="panel-grid">
                                        <% for(int i = 0 ; i < jaAksesories.length(); i++ ) { 
                                            JSONObject aksesoriesObject = jaAksesories.getJSONObject(i);
                                            if (aksesoriesObject != null && aksesoriesObject.length() > 0) {
                                        %>
                                        <div class="col">
                                            <h5 class="text-18px agency-font-semibold agency-text-grey-800 mb-4level">Aksesoris <%= i+1 %></h5>
                                            <ul class="list-group">
                                                <% if (aksesoriesObject.has("Name") && !aksesoriesObject.getString("Name").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Nama</span>
                                                    <span class="agency-text-center">:</span> <span><%= aksesoriesObject.getString("Name") %></span>
                                                </li>
                                                <% } %>
                                                <% if (aksesoriesObject.has("Description") && !aksesoriesObject.getString("Description").isEmpty()) { %>
                                                <li>
                                                    <span class="position-relative">Deskripsi</span> 
                                                    <span class="agency-text-center">:</span> <span><%= aksesoriesObject.getString("Description") %></span>
                                                </li>
                                                <% } %>
                                            </ul>
                                        </div>
                                        <% } } %>
                                    </div>
                                </div>
                                
                                <div class="px-6level py-8level">
                                    <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Perlindungan</h4>
                                    <% for(int i = 0 ; i < jaCoverage.length(); i++ ) { 
                                        JSONObject covObject = jaCoverage.getJSONObject(i);
                                        if (covObject != null && covObject.length() > 0) {
                                    %>
                                    <ul class="list-group">
                                        <% if (covObject.has("Name") && !covObject.getString("Name").isEmpty()) { %>
                                        <li>
                                            <span class="position-relative"><%= covObject.getString("Name") %></span>
                                        </li>
                                        <% } %>
                                    </ul>
                                    <% } } %>
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
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Kendaraan</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Nomor Polisi</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PoliceNumber") %></span>
											</li>
											<li>
												<span class="position-relative">Merek Mobil</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("VehicleManufacture") %></span>
											</li>
											<li>
												<span class="position-relative">Tahun Pembuatan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("ManufactureYear") %></span>
											</li>
											<li>
												<span class="position-relative">Model Mobil</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("VehicleModel") %></span>
											</li>
											<li>
												<span class="position-relative">Seri Mobil</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("VehicleSubModel") %></span>
											</li>
											<li>
												<span class="position-relative">Nomor Mesin</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("EngineNumber") %></span>
											</li>
											<li>
												<span class="position-relative">Nomor Kerangka</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("ChassisNumber") %></span>
											</li>
											
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Plan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("CoverageType") %></span>
											</li>
											<li>
												<span class="position-relative">Harga Jual Mobil</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<%=datas.getCurrency() %> 
													<fmt:setLocale value="id_ID" />
                        							<fmt:formatNumber value="<%=joDetail.getString("SumInsured") %>" type="number" />
												</span>
											</li>
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
							</div>
						</div>
					</div>
				</div>
				
				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Pemegang Polis</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group">
										
											<% 
											    String idNumber = datas.getPolicyHolder().getIdNumber();
											    String passportNumber = datas.getPolicyHolder().getPassportNumber();
											    String kitasNumber = datas.getPolicyHolder().getKitasNumber();
											%>
										
											<li>
												<span class="position-relative">Political Exposed Person (PEP)</span> 
												<span class="agency-text-center">:</span>
												<span><%=datas.getPolicyHolder().isPep() ? "Ya" : "Tidak" %></span>
											</li>
											<li>
												<span class="position-relative">Nama Lengkap</span>
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
											</li>
											<li>
												<span class="position-relative">Tempat Lahir</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBirthPlace() %></span>
											</li>
											<li>
												<span class="position-relative">Tanggal Lahir</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
											        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
												</span>
											</li>
											<li>
												<span class="position-relative">Warga Negara</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getNationality() %></span>
											</li>
											
											<% if (idNumber != null && !idNumber.isEmpty()) { %>
											    <li>
											        <span class="position-relative">No. KTP</span>
											        <span class="agency-text-center">:</span> <span><%= idNumber %></span>
											    </li>
											<% } %>
											
											<% if ((passportNumber != null && !passportNumber.isEmpty()) || (kitasNumber != null && !kitasNumber.isEmpty())) { %>
											    <li>
											        <span class="position-relative">No. Passpor / No. Kitas</span>
											        <span class="agency-text-center">:</span> <span><%= passportNumber %> / <%= kitasNumber %></span>
											    </li>
											<% } %>
											
											li>
												<span class="position-relative">No. KTP</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getIdNumber() %></span>
											</li>
											
											<li>
												<span class="position-relative">No. Passpor / No. Kitas</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getPassportNumber() %> / <%=datas.getPolicyHolder().getKitasNumber() %></span>
											</li>
											
											<li>
												<span class="position-relative">Nomor HP</span> 
												<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
											</li>
											<li>
												<span class="position-relative">Email</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
											</li>
											<li>
												<span class="position-relative">Foto Kwitansi</span> 
												<span class="agency-text-center">:</span>
												<span>
													<a href="<%=joDetail.getString("KwitansiImage") %>"><img class="img-thumbnail" src="<%=joDetail.getString("KwitansiImage") %>" alt="foto"></a>
													
													 <a href="<%=joDetail.getString("KwitansiImage") %>">
														<img class="img-thumbnail img-fluid" src="<%=joDetail.getString("KwitansiImage") %>" alt="foto kwitansi" width="200">
													</a>
												</span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
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
											<li>
												<span class="position-relative">Pekerjaan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getJob() %></span>
											</li>
											
											<li>
												<span class="position-relative">Gambar Kendaraan Depan</span> 
												<span class="agency-text-center">:</span> 
												<span>
													 <a href="<%=joDetail.getString("FrontVehicleImage") %>">
														<img class="img-thumbnail img-fluid" src="<%=joDetail.getString("FrontVehicleImage") %>" alt="FrontVehicleImage" width="200">
													</a>
												</span>
											</li>
											
											<li>
												<span class="position-relative">Gambar Kendaraan Kanan</span> 
												<span class="agency-text-center">:</span>
												<span>
													 <a href="<%=joDetail.getString("RightSideVehicleImage") %>">
														<img class="img-thumbnail img-fluid" src="<%=joDetail.getString("RightSideVehicleImage") %>" alt="RightSideVehicleImage" width="200">
													</a>
												</span> 
											</li>
											
											<li>
												<span class="position-relative">Gambar Kendaraan Kiri</span> 
												<span class="agency-text-center">:</span>
												<span>
													 <a href="<%=joDetail.getString("LeftSideVehicleImage") %>">
														<img class="img-thumbnail img-fluid" src="<%=joDetail.getString("LeftSideVehicleImage") %>" alt="LeftSideVehicleImage" width="200">
													</a>
												</span>
											</li>
											
											<li>
												<span class="position-relative">Gambar Kendaraan Belakang</span> 
												<span class="agency-text-center">:</span>
												<span>
													 <a href="<%=joDetail.getString("RearVehicleImage") %>">
														<img class="img-thumbnail img-fluid" src="<%=joDetail.getString("RearVehicleImage") %>" alt="RearVehicleImage" width="200">
													</a>
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
								<div class="border-b-grey">
									<div class="px-6level py-8level">
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Aksesoris</h4>
										<div class="panel-grid">
												<% for(int i = 0 ; i < jaAksesories.length(); i++ ) { 
														JSONObject aksesoriesObject = jaAksesories.getJSONObject(i);
													%>
													<div class="col">
														
															<h5 class="text-18px agency-font-semibold agency-text-grey-800 mb-4level">Aksesoris <%=i+1 %></h5>
															<ul class="list-group">
															
																<li>
																	<span class="position-relative">Nama</span>
																	<span class="agency-text-center">:</span> <span><%=aksesoriesObject.getString("Name") %></span>
																</li>
																<li>
																	<span class="position-relative">Deskripsi</span> 
																	<span class="agency-text-center">:</span> <span><%=aksesoriesObject.getString("Description") %></span>
																</li>
															</ul>
													</div>
												<%  } %>
										</div>
									</div>
								</div>
								
								<div class="px-6level py-8level">
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Perlindungan</h4>
										<!-- <div class="panel-grid"> 
													<div class="col"> -->
													<% for(int i = 0 ; i < jaCoverage.length(); i++ ) { 
														JSONObject covObject = jaCoverage.getJSONObject(i);
													%>
															<ul class="list-group">
																<li>
																	<span class="position-relative"><%=covObject.getString("Name") %></span>
																</li>
															</ul>
													<%  } %>
													<!-- </div>
													
										</div> -->
								</div>
							</div>
						</div>
					</div>
				
				
			</div>
		</div>
	</div>
</div> --%>
