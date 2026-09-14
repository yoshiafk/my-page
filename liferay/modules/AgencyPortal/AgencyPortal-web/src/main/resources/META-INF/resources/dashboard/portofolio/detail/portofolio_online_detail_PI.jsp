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
            
                <!-- main rincian product -->
                <%@ include file="rincian_produk.jsp" %>    
        
                <div class="panel-wrapper mb-4level">
                    <h1 class="mb-4level">Ringkasan Polis</h1>
                    <div class="panel">
                        <div class="panel-body border-grey">
                            <div class="px-6level py-8level">
                                <div class="panel-grid mb-8level">
                                    <div class="col">
                                        <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Plan Terpilih</h4>
                                        <ul class="list-group mb-8level">
                                            <% if (joDetail.has("Plan") && !joDetail.getString("Plan").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Nama plan</span> 
                                                <span class="agency-text-center">:</span> <span><%=joDetail.getString("Plan") %></span>
                                            </li>
                                            <% } %>
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Periode Polis</h4>
                                        <ul class="list-group display-block flex-justify-between-lg mb-8level">
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
                                                <span class="position-relative">Nama Pemegang Polis</span>
                                                <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
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
                                                <span class="position-relative">Tanggal lahir</span>
                                                <span class="agency-text-center">:</span> 
                                                <span>
                                                    <fmt:parseDate value="<%=datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
                                                    <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
                                                </span>
                                            </li>
                                            <% } %>
                                            <% if (datas.getPolicyHolder().getGender() != null && !datas.getPolicyHolder().getGender().isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Jenis Kelamin</span> 
                                                <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getGender().equalsIgnoreCase("F") ? "Perempuan":"Laki-Laki" %></span>
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
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul class="list-group">
                                            <% if (datas.getPolicyHolder().getAddress() != null && !datas.getPolicyHolder().getAddress().isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Alamat</span> 
                                                <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %></span>
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
                                                <span class="position-relative">Propinsi</span> 
                                                <span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getProvince() %></span>
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
                                <h4 class="mb-4level">Detail Hewan Perliharaan</h4>
                                <div class="panel-grid">
                                    <div class="col">
                                        <ul class="list-group">
                                            <% if (joDetail.has("PetName") && !joDetail.getString("PetName").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Nama Hewan Peliharaan</span>
                                                <span class="agency-text-center">:</span> <span><%=joDetail.getString("PetName") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("PetType") && !joDetail.getString("PetType").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Jenis Hewan Peliharaan</span> 
                                                <span class="agency-text-center">:</span> <span><%=joDetail.getString("PetType") %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("PetGender") && !joDetail.getString("PetGender").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Jenis Kelamin</span> 
                                                <span class="agency-text-center">:</span> <span><%=joDetail.getString("PetGender").equalsIgnoreCase("F")? "Betina" : "Jantan" %></span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("PetDob") && !joDetail.getString("PetDob").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Tanggal Lahir</span> 
                                                <span class="agency-text-center">:</span> 
                                                <span>
                                                    <fmt:parseDate value="<%=joDetail.getString("PetDob") %>" pattern="yyyyMMdd" var="petdob" />
                                                    <fmt:formatDate value="${petdob}" pattern="dd MMM yyyy" />
                                                </span>
                                            </li>
                                            <% } %>
                                            <% if (joDetail.has("PetLocation") && !joDetail.getString("PetLocation").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Lokasi Pemeliharaan</span> 
                                                <span class="agency-text-center">:</span>
                                                <span><%=joDetail.getString("PetLocation") %></span>
                                            </li>
                                            <% } %>
                                            
                                            <% if (joDetail.has("PetPhoto") && !joDetail.getString("PetPhoto").isEmpty()) { %>
														<li>
															<span class="position-relative">Foto Hewan Peliharaan</span> 
															<span class="agency-text-center">:</span>
															<span>
																<a href="<%=joDetail.getString("PetPhoto") %>"><img class="img-thumbnail" src="<%=joDetail.getString("PetPhoto") %>" alt="foto"></a>
															</span>
														</li>
													<% } %>
                                            
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul class="list-group">
                                            <% if (joDetail.has("PetVaccine") && joDetail.getString("PetVaccine").equals("true")) { %>
                                            <li>
                                                <span class="position-relative">Apakah Hewan Peliharaan pernah mendapatkan vaksinasi rabies sesuai rekomendasi dokter ?</span> 
                                                <span class="agency-text-center">:</span> <span>Ya</span>
                                            </li>
                                            <% } else { %>
                                            <li>
                                                <span class="position-relative">Apakah Hewan Peliharaan pernah mendapatkan vaksinasi rabies sesuai rekomendasi dokter ?</span> 
                                                <span class="agency-text-center">:</span> <span>Tidak</span>
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
                                <h4 class="mb-4level">Sertifikat / Akta Kelahiran</h4>
                                <div class="panel-grid">
                                    <div class="col">
                                        <ul class="list-group">
                                            <% if (joDetail.has("PetIdNumber") && !joDetail.getString("PetIdNumber").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">No. Sertifikat / Akta Kelahiran Hewan Peliharaan</span>
                                                <span class="agency-text-center">:</span> <span><%=joDetail.getString("PetIdNumber") %></span>
                                            </li>
                                            <% } %>
                                            
                                             <% if (joDetail.has("PetIdNumberFile") && !joDetail.getString("PetIdNumberFile").isEmpty()) { %>
														<li>
															<span class="position-relative">Sertifikat / Akta Kelahiran Hewan Peliharaan</span> 
															<span class="agency-text-center">:</span>
															<span>
																<a href="<%=joDetail.getString("PetIdNumberFile") %>"><img class="img-thumbnail" src="<%=joDetail.getString("PetIdNumberFile") %>" alt="foto"></a>
															</span>
														</li>
													<% } %>
                                            
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul class="list-group">
                                            <% if (joDetail.has("PetIdNumberIssuing") && !joDetail.getString("PetIdNumberIssuing").isEmpty()) { %>
                                            <li>
                                                <span class="position-relative">Lembaga yang menerbitkan Sertifikat / Akta kelahiran</span> 
                                                <span class="agency-text-center">:</span> <span><%=joDetail.getString("PetIdNumberIssuing") %></span>
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
								<div class="panel-grid mb-8level">
									<div class="col">
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Plan Terpilih</h4>
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Nama plan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("Plan") %></span>
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
												<span class="position-relative">Nama Pemegang Polis</span>
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getName() %></span>
											</li>
											<li>
												<span class="position-relative">Tempat Lahir</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getBirthPlace() %></span>
											</li>
											<li>
												<span class="position-relative">Tanggal lahir</span>
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%=datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
											        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
												</span>
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
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Alamat</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %></span>
											</li>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getCity() %></span>
											</li>
											<li>
												<span class="position-relative">Propinsi</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getProvince() %></span>
											</li>
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getZip()%></span>
											</li>
											<li>
												<span class="position-relative">Pekerjaan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getJob()%></span>
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
								<h4 class="mb-4level">Detail Hewan Perliharaan</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Nama Hewan Peliharaan</span>
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PetName") %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Hewan Peliharaan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PetType") %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Kelamin</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PetGender").equalsIgnoreCase("F")? "Betina" : "Jantan" %></span>
											</li>
											<li>
												<span class="position-relative">Tanggal Lahir</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%=joDetail.getString("PetDob") %>" pattern="yyyyMMdd" var="petdob" />
											        <fmt:formatDate value="${petdob}" pattern="dd MMM yyyy" />
												</span>
											</li>
											<li>
												<span class="position-relative">Lokasi Pemeliharaan</span> 
												<span class="agency-text-center">:</span>
												<span><%=joDetail.getString("PetLocation") %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Apakah Hewan Peliharaanpernah mendapatkan vaksinasi rabies sesuai rekomendasi dokter ?</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PetVaccine").equals("false") ? "Tidak" : "Ya" %></span>
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
								<h4 class="mb-4level">Sertifikat / Akta Kelahiran</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">No. Sertifikat / Akta Kelahiran Hewan Peliharaan</span>
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PetIdNumber") %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Lembaga yang menerbitkan Sertifikat / Akta kelahiran</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("PetIdNumberIssuing") %></span>
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


