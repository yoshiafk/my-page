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
								
								<h4 class="mb-4level">Detail Diri</h4>
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
											
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
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
								<h4 class="mb-4level">Informasi Gadget</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group">
											<% if (joDetail.has("GadgetModel") && !joDetail.getString("GadgetModel").isEmpty()) { %>
												<li>
													<span class="position-relative">Gadget Model</span>
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("GadgetModel") %></span>
												</li>
											<% } %>
											<% if (joDetail.has("Imei1") && !joDetail.getString("Imei1").isEmpty()) { %>
												<li>
													<span class="position-relative">IMEI 1</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("Imei1") %></span>
												</li>
											<% } %>
											<% if (joDetail.has("ImeiFromScreen") && !joDetail.getString("ImeiFromScreen").isEmpty()) { %>
												<li>
													<span class="position-relative">Foto Layar & Nomor Imei</span> 
													<span class="agency-text-center">:</span> 
													<span>
														<a href="<%=joDetail.getString("ImeiFromScreen") %>"><img class="img-thumbnail" src="<%=joDetail.getString("ImeiFromScreen") %>" alt="foto"></a>
													</span>
												</li>
											<% } %>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
											<% if (joDetail.has("SumInsured") && !joDetail.getString("SumInsured").isEmpty()) { %>
												<li>
													<span class="position-relative">Nilai Pertanggungan</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("SumInsured") %></span>
												</li>
											<% } %>
											<% if (joDetail.has("InsuredPeriod") && !joDetail.getString("InsuredPeriod").isEmpty()) { %>
												<li>
													<span class="position-relative">Periode Perlindungan</span> 
													<span class="agency-text-center">:</span> <span><%=joDetail.getString("InsuredPeriod") %></span>
												</li>
											<% } %>
											<% if (joDetail.has("ImeiPicture") && !joDetail.getString("ImeiPicture").isEmpty()) { %>
												<li>
													<span class="position-relative">Foto Bagian Belakang Handphone</span> 
													<span class="agency-text-center">:</span> 
													<span>
														<a href="<%=joDetail.getString("ImeiPicture") %>"><img class="img-thumbnail" src="<%=joDetail.getString("ImeiPicture") %>" alt="foto"></a>
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
								
								<h4 class="mb-4level">Detail Diri</h4>
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
												<span class="position-relative">Kewarganegaraan</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getNationality() %></span>
											</li>
											<li>
												<span class="position-relative">No. KTP</span> 
												<span class="agency-text-center">:</span> <span><%=datas.getPolicyHolder().getIdNumber() %></span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
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
								<h4 class="mb-4level">Informasi Gadget</h4>
								<div class="panel-grid">
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Gadget Model</span>
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("GadgetModel") %></span>
											</li>
											<li>
												<span class="position-relative">IMEI 1</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("Imei1") %></span>
											</li>
											<li>
												<span class="position-relative">Foto Layar & Nomor Imei</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<a href="<%=joDetail.getString("ImeiFromScreen") %>"><img class="img-thumbnail" src="<%=joDetail.getString("ImeiFromScreen") %>" alt="foto"></a>
												</span>
											</li>
										</ul>
									</div>
									<div class="col">
										<ul class="list-group">
											<li>
												<span class="position-relative">Nilai Pertanggungan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("SumInsured") %></span>
											</li>
											<li>
												<span class="position-relative">Periode Perlindungan</span> 
												<span class="agency-text-center">:</span> <span><%=joDetail.getString("InsuredPeriod") %></span>
											</li>
											<li>
												<span class="position-relative">Foto Bagian Belakang Handphone</span> 
												<span class="agency-text-center">:</span> 
												<span>
													<a href="<%=joDetail.getString("ImeiPicture") %>"><img class="img-thumbnail" src="<%=joDetail.getString("ImeiPicture") %>" alt="foto"></a>
												</span>
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
