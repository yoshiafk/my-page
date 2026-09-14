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
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Perjalanan</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
											<% if (joDetail.has("TravelType") && !joDetail.getString("TravelType").isEmpty()) { %>
	                                            <li>
													<span class="position-relative">Jenis Perjalanan</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("TravelType").equalsIgnoreCase("single") ? "Perjalanan Tunggal": "Perjalanan "+joDetail.getString("TravelType") %></span>
												</li>
											<% } %>
                                            
                                            <% if (joDetail.has("TravelPlan") && !joDetail.getString("TravelPlan").isEmpty()) { %>
	                                            <li>
													<span class="position-relative">Jenis Paket</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("TravelPlan") %></span>
												</li>
											<% } %>
                                            
                                            <% if (joDetail.has("TravellerType") && !joDetail.getString("TravellerType").isEmpty()) { %>
												<li>
													<span class="position-relative">Jenis Penumpang</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("TravellerType") %></span>
												</li>
											<% } %>
                                            
                                            <% if ((joDetail.has("Adult") && !joDetail.getString("Adult").isEmpty()) || (joDetail.has("Child") && !joDetail.getString("Child").isEmpty())) { %>
												<li>
													<span class="position-relative">Jumlah Tertanggung</span> 
													<span class="agency-text-center">:</span> <span>Dewasa(<%=joDetail.getString("Adult") %>), Anak (<%=joDetail.getString("Child") %>)</span>
												</li>
											<% } %>
                                            
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<% if (datas.getStartDate() != null && !datas.getStartDate().isEmpty()) { %>
												<li>
													<span class="position-relative">Tanggal Keberangkatan</span> 
													<span class="agency-text-center">:</span>
													<span>
														<fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="depart" />
												        <fmt:formatDate value="${depart}" pattern="dd MMM yyyy" />
											       </span>
												</li>
											<% } %>
											
											<% if (datas.getExpiredDate() != null && !datas.getExpiredDate().isEmpty()) { %>
												<li>
													<span class="position-relative">Tanggal Kedatangan</span> 
													<span class="agency-text-center">:</span> 
													<span>
														<fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="arrive" />
												        <fmt:formatDate value="${arrive}" pattern="dd MMM yyyy" />
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
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Data Diri</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Political Exposed Persons (PEP)</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().isPep() ? "Ya":"TIdak" %></span>
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
											<% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
												<li>
													<span class="position-relative">Nomor HP</span> 
													<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
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
                                            
                                            <% if (datas.getPolicyHolder().getEmail() != null && !datas.getPolicyHolder().getEmail().isEmpty()) { %>
		                                        <li>
													<span class="position-relative">Email</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
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
											<% if (datas.getPolicyHolder().getAddress() != null && !datas.getPolicyHolder().getAddress().isEmpty()) { %>
												<li>
													<span class="position-relative">Alamat</span> 
													<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %></span>
												</li>
											<% } %>
											<% if (datas.getPolicyHolder().getProvince() != null && !datas.getPolicyHolder().getProvince().isEmpty()) { %>
												<li>
													<span class="position-relative">Propinsi</span> 
													<span class="agency-text-center">:</span> 
													<span><%=datas.getPolicyHolder().getProvince() %></span>
												</li>
											<% } %>
											<% if (datas.getPolicyHolder().getCity() != null && !datas.getPolicyHolder().getCity().isEmpty()) { %>
												<li>
													<span class="position-relative">Kota</span> 
													<span class="agency-text-center">:</span> 
													<span><%=datas.getPolicyHolder().getCity() %></span>
												</li>
											<% } %>
											<% if (datas.getPolicyHolder().getZip() != null && !datas.getPolicyHolder().getZip().isEmpty()) { %>
												<li>
													<span class="position-relative">Kode Pos</span> 
													<span class="agency-text-center">:</span> 
													<span><%=datas.getPolicyHolder().getZip() %></span>
												</li>
											<% } %>
											<% if (datas.getPolicyHolder().getJob() != null && !datas.getPolicyHolder().getJob().isEmpty()) { %>
												<li>
													<span class="position-relative">Pekerjaan</span> 
													<span class="agency-text-center">:</span> 
													<span><%=datas.getPolicyHolder().getJob() %></span>
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
								<h4 class="mb-8level">Informasi Tertanggung</h4>
								
								<% 
								
								String totalAdultStr = joDetail.getString("Adult");
								String totalChildStr = joDetail.getString("Child");
								
								int adultInt = Integer.parseInt(totalAdultStr);
								int childInt = Integer.parseInt(totalChildStr);
								
								int totalSisa = 0;
								
								%>
								
								<% for(int i = 0 ; i < insureds.length(); i++ ) { 
										JSONObject insuredObj = insureds.getJSONObject(i);
										
										String labelDataTertanggung = "";
										
										if(i<adultInt){
											labelDataTertanggung = "Dewasa " + (i+1);
										}else{
											
											labelDataTertanggung = "Anak " + (totalSisa+1);
											totalSisa++;
										}
										
										String genderFormat = insuredObj.getString("Gender").equals("M") ? "Laki-Laki" : "Perempuan";
										
										%>
										<h5 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level"><%=labelDataTertanggung %></h5>
										<div class="panel-grid mb-8level">
											<div class="col">
												<ul class="list-group">
													<li>
														<span class="position-relative">Political Exposed Person (PEP)</span> 
														<span class="agency-text-center">:</span>
														<span><%=insuredObj.getString("IsPep").equals("false") ? "Tidak": "Ya" %></span>
													</li>
													
													<% if (insuredObj.has("Name") && !insuredObj.getString("Name").isEmpty()) { %>
														<li>
															<span class="position-relative">Nama Lengkap</span>
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Name") %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("Gender") && !insuredObj.getString("Gender").isEmpty()) { %>
														<li>
															<span class="position-relative">Jenis Kelamin</span> 
															<span class="agency-text-center">:</span> <span><%=genderFormat %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("Dob") && !insuredObj.getString("Dob").isEmpty()) { %>
														<li>
															<span class="position-relative">Tanggal Lahir</span> 
															<span class="agency-text-center">:</span> 
															<span>
																<fmt:parseDate value="<%=insuredObj.getString("Dob") %>" pattern="yyyyMMdd" var="dob" />
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
													<% if (insuredObj.has("IdNumber") && !insuredObj.getString("IdNumber").isEmpty()) { %>
														<li>
															<span class="position-relative">No. KTP</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("IdNumber") %></span>
														</li>
													<% } %>
													<% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
														<li>
															<span class="position-relative">Nomor HP</span> 
															<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("Email") && !insuredObj.getString("Email").isEmpty()) { %>
														<li>
															<span class="position-relative">Email</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Email") %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("IdPhoto") && !insuredObj.getString("IdPhoto").isEmpty()) { %>
														<li>
															<span class="position-relative">Foto Identitas</span> 
															<span class="agency-text-center">:</span>
															<span>
																<a href="<%=insuredObj.getString("IdPhoto") %>"><img class="img-thumbnail" src="<%=insuredObj.getString("IdPhoto") %>" alt="foto"></a>
															</span>
														</li>
													<% } %>
												</ul>
											</div>
											<div class="col">
												<ul class="list-group">
													<% if (insuredObj.has("Address") && !insuredObj.getString("Address").isEmpty()) { %>
														<li>
															<span class="position-relative">Alamat</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Address") %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("Province") && !insuredObj.getString("Province").isEmpty()) { %>
														<li>
															<span class="position-relative">Propinsi</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Province") %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("City") && !insuredObj.getString("City").isEmpty()) { %>
														<li>
															<span class="position-relative">Kota</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("City") %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("Zip") && !insuredObj.getString("Zip").isEmpty()) { %>
														<li>
															<span class="position-relative">Kode Pos</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Zip") %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("Beneficiary") && !insuredObj.getString("Beneficiary").isEmpty()) { %>
														<li>
															<span class="position-relative">Ahli Waris</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Beneficiary") %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("RelationshipToBeneficiary") && !insuredObj.getString("RelationshipToBeneficiary").isEmpty()) { %>
														<li>
															<span class="position-relative">Hubungan dengan Ahli Waris</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("RelationshipToBeneficiary") %></span>
														</li>
													<% } %>
													<% if (insuredObj.has("Job") && !insuredObj.getString("Job").isEmpty()) { %>
														<li>
															<span class="position-relative">Pekerjaan</span> 
															<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Job") %></span>
														</li>
													<% } %>
												</ul>
											</div>
										</div>
								
								<%  } %>
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
												<span class="position-relative">Jenis Perjalanan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("TravelType").equalsIgnoreCase("single") ? "Perjalanan Tunggal": "Perjalanan "+joDetail.getString("TravelType") %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Paket</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("TravelPlan") %></span>
											</li>
											<li>
												<span class="position-relative">Jenis Penumpang</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("TravellerType") %></span>
											</li>
											<li>
												<span class="position-relative">Jumlah Tertanggung</span> 
												<span class="agency-text-center">:</span> <span>Dewasa(<%=joDetail.getString("Adult") %>), Anak (<%=joDetail.getString("Child") %>)</span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group mb-8level">
											<li>
												<span class="position-relative">Tanggal Keberangkatan</span> 
												<span class="agency-text-center">:</span>
												<span>
													<fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="depart" />
											        <fmt:formatDate value="${depart}" pattern="dd MMM yyyy" />
										       </span>
											</li>
											<li>
												<span class="position-relative">Tanggal Kedatangan</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="arrive" />
											        <fmt:formatDate value="${arrive}" pattern="dd MMM yyyy" />
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
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getNationality() %></span>
											</li>
											<li>
												<span class="position-relative">Nomor HP</span> 
												<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
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
												<span class="position-relative">No. KTP</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getIdNumber() %></span>
											</li>
											<li>
												<span class="position-relative">Email</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getEmail() %></span>
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
												<span class="position-relative">Alamat</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getAddress() %></span>
											</li>
											<li>
												<span class="position-relative">Propinsi</span> 
												<span class="agency-text-center">:</span> 
												<span><%=datas.getPolicyHolder().getProvince() %></span>
											</li>
											<li>
												<span class="position-relative">Kota</span> 
												<span class="agency-text-center">:</span> 
												<span><%=datas.getPolicyHolder().getCity() %></span>
											</li>
											<li>
												<span class="position-relative">Kode Pos</span> 
												<span class="agency-text-center">:</span> 
												<span><%=datas.getPolicyHolder().getZip() %></span>
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
				
				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="px-6level py-8level">
								<h4 class="mb-8level">Informasi Tertanggung</h4>
								
								<% 
								
								String totalAdultStr = joDetail.getString("Adult");
								String totalChildStr = joDetail.getString("Child");
								
								int adultInt = Integer.parseInt(totalAdultStr);
								int childInt = Integer.parseInt(totalChildStr);
								
								int totalSisa = 0;
								
								%>
								
								<% for(int i = 0 ; i < insureds.length(); i++ ) { 
										JSONObject insuredObj = insureds.getJSONObject(i);
										
										String labelDataTertanggung = "";
										
										if(i<adultInt){
											labelDataTertanggung = "Dewasa " + (i+1);
										}else{
											
											labelDataTertanggung = "Anak " + (totalSisa+1);
											totalSisa++;
										}
										
										String genderFormat = insuredObj.getString("Gender").equals("M") ? "Laki-Laki" : "Perempuan";
										
										%>
										<h5 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level"><%=labelDataTertanggung %></h5>
										<div class="panel-grid mb-8level">
											<div class="col">
												<ul class="list-group">
													<li>
														<span class="position-relative">Political Exposed Person (PEP)</span> 
														<span class="agency-text-center">:</span>
														<span><%=insuredObj.getString("IsPep").equals("false") ? "Tidak": "Ya" %></span>
													</li>
													<li>
														<span class="position-relative">Nama Lengkap</span>
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Name") %></span>
													</li>
													<li>
														<span class="position-relative">Jenis Kelamin</span> 
														<span class="agency-text-center">:</span> <span><%=genderFormat %></span>
													</li>
													<li>
														<span class="position-relative">Tanggal Lahir</span> 
														<span class="agency-text-center">:</span> 
														<span>
															<fmt:parseDate value="<%=insuredObj.getString("Dob") %>" pattern="yyyyMMdd" var="dob" />
													        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
														</span>
													</li>
													<li>
														<span class="position-relative">Kewarganegaraan</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Nationality") %></span>
													</li>
													<li>
														<span class="position-relative">No. KTP</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("IdNumber") %></span>
													</li>
													<li>
														<span class="position-relative">Nomor HP</span> 
														<span class="agency-text-center">:</span> <span>+<%=datas.getPolicyHolder().getMobilePhone() %></span>
													</li>
													<li>
														<span class="position-relative">Email</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Email") %></span>
													</li>
													<li>
														<span class="position-relative">Foto Identitas</span> 
														<span class="agency-text-center">:</span>
														<span>
															<a href="<%=insuredObj.getString("IdPhoto") %>"><img class="img-thumbnail" src="<%=insuredObj.getString("IdPhoto") %>" alt="foto"></a>
														</span>
													</li>
												</ul>
											</div>
											<div class="col">
												<ul class="list-group">
													<li>
														<span class="position-relative">Alamat</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Address") %></span>
													</li>
													<li>
														<span class="position-relative">Propinsi</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Province") %></span>
													</li>
													<li>
														<span class="position-relative">Kota</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("City") %></span>
													</li>
													<li>
														<span class="position-relative">Kode Pos</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Zip") %></span>
													</li>
													<li>
														<span class="position-relative">Ahli Waris</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Beneficiary") %></span>
													</li>
													<li>
														<span class="position-relative">Hubungan dengan Ahli Waris</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("RelationshipToBeneficiary") %></span>
													</li>
													<li>
														<span class="position-relative">Pekerjaan</span> 
														<span class="agency-text-center">:</span> <span><%=insuredObj.getString("Job") %></span>
													</li>
												</ul>
											</div>
										</div>
								
								<%  } %>
							</div>
						</div>
					</div>
				</div>

				
			</div>
		</div>
	</div>
</div> --%>


