<%@page import="java.text.DecimalFormat"%>
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
    JSONObject joAddressDetail = (JSONObject) renderRequest.getAttribute("addressDetail");
    JSONObject joIncomeSource = (JSONObject) renderRequest.getAttribute("incomeSource");
    JSONObject joBankAccount = (JSONObject) renderRequest.getAttribute("bankAccount");
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
								
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Polis</h4>
								<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
								  <tbody>
								    <% if(datas.getStartDate() != null && !datas.getStartDate().isEmpty()) { %>
								    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Mulai</td>
								      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								        <fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="startDate" />
								        <fmt:formatDate value="${startDate}" pattern="dd MMM yyyy" />
								      </td>
								    </tr>
								    <% } %>
								    
								    <% if(datas.getExpiredDate() != null && !datas.getExpiredDate().isEmpty()) { %>
								    <tr style="background-color: #fff; border: 1px solid #ccc;">
								      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Selesai</td>
								      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								        <fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="expdate" />
								        <fmt:formatDate value="${expdate}" pattern="dd MMM yyyy" />
								      </td>
								    </tr>
								    <% } %>
								    
								    <% if(joDetail.has("Area") && !joDetail.getString("Area").isEmpty()) { %>
								    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Wilayah Pertanggungan</td>
								      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("Area") %></td>
								    </tr>
								    <% } %>
								    
								    <% if(joDetail.has("Plan") && !joDetail.getString("Plan").isEmpty()) { %>
								    <tr style="background-color: #fff; border: 1px solid #ccc;">
								      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama Plan</td>
								      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("Plan") %></td>
								    </tr>
								    <% } %>
								  </tbody>
								</table>
								
							</div>
						</div>
					</div>
				</div>
				
				<div class="detailPolis mb-8level">
					<div class="panel-wrapper mb-4level">
						<div class="panel">
							<div class="panel-body border-grey">
								<div class="border-b-grey">
									<div class="px-6level py-8level">
										
									<!-- ----------------------Detail Pemegang Polis------------------------- -->
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Pemegang Polis</h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									  <tbody>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Political Exposed Persons (PEP)</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().isPep() ? "Ya" : "Tidak" %></td>
									    </tr>
									    
									    <% if (datas.getPolicyHolder().getName() != null && !datas.getPolicyHolder().getName().isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getName() %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getGender() != null && !datas.getPolicyHolder().getGender().isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Jenis Kelamin</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getGender().equalsIgnoreCase("F") ? "Perempuan" : "Laki-Laki" %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getBirthPlace() != null && !datas.getPolicyHolder().getBirthPlace().isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tempat Lahir</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getBirthPlace() %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getDob() != null && !datas.getPolicyHolder().getDob().isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Lahir</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
									        <fmt:parseDate value="<%= datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
									        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
									      </td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getMaritalStatus() != null && !datas.getPolicyHolder().getMaritalStatus().isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Status Perkawinan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getMaritalStatus().equalsIgnoreCase("married") ? "Menikah" : "Lajang" %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getNationalityCountry() != null || datas.getPolicyHolder().getNationality() != null) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kewarganegaraan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%= (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) ? datas.getPolicyHolder().getNationalityCountry() : datas.getPolicyHolder().getNationality() %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getIdNumber() != null && !datas.getPolicyHolder().getIdNumber().isEmpty()) { %>
									    <tr style="background-color:#fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. KTP</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getIdNumber() %></td>
									    </tr>
									    <% } %>
									
									    <% 
									      String passportNumber = datas.getPolicyHolder().getPassportNumber();
									      String kitasNumber = datas.getPolicyHolder().getKitasNumber();
									      boolean hasPassportNumber = passportNumber != null && !passportNumber.isEmpty();
									      boolean hasKitasNumber = kitasNumber != null && !kitasNumber.isEmpty();
									    %>
									
									    <% if (hasPassportNumber || hasKitasNumber) { %>
									    <tr style="background-color:#f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">
									      	<%-- No. Passpor<% if (hasKitasNumber) { %> / No. Kitas<% } %> --%>
									      	<%= hasPassportNumber ? "No. Passpor" : "" %>
										  	<%= hasPassportNumber && hasKitasNumber ? " / " : "" %>
											<%= hasKitasNumber ? "No. Kitas" : "" %>
									      </td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
									        <%-- <%= hasPassportNumber ? passportNumber : "" %>
									        <% if (hasKitasNumber) { %> / <%= kitasNumber %><% } %> --%>
									        <%= hasPassportNumber ? passportNumber : "" %>
											<%= hasPassportNumber && hasKitasNumber ? " / " : "" %>
											<%= hasKitasNumber ? kitasNumber : "" %>
									      </td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getEmail() != null && !datas.getPolicyHolder().getEmail().isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Email</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getEmail() %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. HP</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">+<%=datas.getPolicyHolder().getMobilePhone() %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getCountryCode() != null && !datas.getPolicyHolder().getCountryCode().isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kode Negara</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getCountryCode() %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getAreaCode() != null && !datas.getPolicyHolder().getAreaCode().isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kode Area</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getAreaCode() %></td>
									    </tr>
									    <% } %>
									
									    <% if (datas.getPolicyHolder().getPhone() != null && !datas.getPolicyHolder().getPhone().isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. Telepon</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getPhone() %></td>
									    </tr>
									    <% } %>
									
									    <% if (joAddressDetail.has("PHResidentialCountry") && !joAddressDetail.getString("PHResidentialCountry").isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Negara</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHResidentialCountry") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joAddressDetail.has("PHResidentialAddress") && !joAddressDetail.getString("PHResidentialAddress").isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Alamat Lengkap</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHResidentialAddress") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joAddressDetail.has("PHDifferentResidential") && !joAddressDetail.getString("PHDifferentResidential").isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah alamat negara asal Anda berbeda dari alamat tempat tinggal utama Anda?</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHDifferentResidential").equals("false") ? "Tidak" : "Ya" %></td>
									    </tr>
									    <% } %>
									
									    <% if (joAddressDetail.has("PHDifferentMailing") && !joAddressDetail.getString("PHDifferentMailing").isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah alamat surat menyurat Anda berbeda dengan negara tempat tinggal utama</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHDifferentMailing").equals("false") ? "Tidak" : "Ya" %></td>
									    </tr>
									    <% } %>
									
									    <% if (joAddressDetail.has("PHLiveAbroad") && !joAddressDetail.getString("PHLiveAbroad").isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah Anda atau salah satu dari tertanggung tinggal di luar negeri?</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHLiveAbroad").equals("false") ? "Tidak" : "Ya" %></td>
									    </tr>
									    <% } %>
									  </tbody>
									</table>
																			
									
									
									
									<!-- ----------------------Sumber Penghasilan------------------------- -->
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Sumber Penghasilan</h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									  <tbody>
									    <% if (joIncomeSource.has("PHCompanyName") && !joIncomeSource.getString("PHCompanyName").isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama perusahaan tempat bekerja</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHCompanyName") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joIncomeSource.has("PHJobPosition") && !joIncomeSource.getString("PHJobPosition").isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Pekerjaan / Jabatan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHJobPosition") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joIncomeSource.has("PHBusinessField") && !joIncomeSource.getString("PHBusinessField").isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Bidang Usaha</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHBusinessField") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joIncomeSource.has("PHPaymentSource") && !joIncomeSource.getString("PHPaymentSource").isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Sumber Pembayaran Premi</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHPaymentSource") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joIncomeSource.has("PHAnnualIncome") && !joIncomeSource.getString("PHAnnualIncome").isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Total Penghasilan Tahunan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHAnnualIncome") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joIncomeSource.has("PHInsuranceReason") && !joIncomeSource.getString("PHInsuranceReason").isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Alasan mengajukan polis asuransi?</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHInsuranceReason") %></td>
									    </tr>
									    <% } %>
									  </tbody>
									</table>
									
									
									
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Dokter yang paling sering dikunjungi selama 5 tahun terakhir</h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									  <tbody>
									    <% if (joDetail.has("DoctorName") && !joDetail.getString("DoctorName").isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama Dokter</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorName") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joDetail.has("DoctorCountry") && !joDetail.getString("DoctorCountry").isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Negara</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorCountry") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joDetail.has("DoctorAddress") && !joDetail.getString("DoctorAddress").isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Alamat</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorAddress") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joDetail.has("DoctorPhone") && !joDetail.getString("DoctorPhone").isEmpty()) { %>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. Telepon</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorPhone") %></td>
									    </tr>
									    <% } %>
									
									    <% if (joDetail.has("DoctorEmail") && !joDetail.getString("DoctorEmail").isEmpty()) { %>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Email</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorEmail") %></td>
									    </tr>
									    <% } %>
									  </tbody>
									</table>

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
					          <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Rekening Bank</h4>
					          
					          <table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
					            <tbody>
					              <% if (joBankAccount.has("AccountBankNumber") && !joBankAccount.getString("AccountBankNumber").isEmpty()) { %>
					              <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
					                <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nomor Rekening</td>
					                <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joBankAccount.getString("AccountBankNumber") %></td>
					              </tr>
					              <% } %>
					              
					              <% if (joBankAccount.has("BankName") && !joBankAccount.getString("BankName").isEmpty()) { %>
					              <tr style="background-color: #fff; border: 1px solid #ccc;">
					                <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama Bank</td>
					                <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joBankAccount.getString("BankName") %></td>
					              </tr>
					              <% } %>
					              
					              <% if (joBankAccount.has("AccountBankName") && !joBankAccount.getString("AccountBankName").isEmpty()) { %>
					              <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
					                <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama Pemilik Rekening</td>
					                <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joBankAccount.getString("AccountBankName") %></td>
					              </tr>
					              <% } %>
					            </tbody>
					          </table>
					          
					        </div>
					      </div>
					      
					      <div class="px-6level py-8level">
					        <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Perusahaan asuransi yang menjamin Anda saat ini atau sebelumnya</h4>
					        
					        <table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
					          <tbody>
					            <% if (joDetail.has("CurrentInsuranceHistory") && !joDetail.getString("CurrentInsuranceHistory").isEmpty()) { %>
					            <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
					              <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah orang yang akan ditanggung saat ini atau sebelumnya pernah memiliki pertanggungan kesehatan dengan perusahaan asuransi manapun, termasuk AXA Insurance?</td>
					              <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
					                <%= "0".equals(joDetail.getString("CurrentInsuranceHistory")) ? "Tidak" : "Ya" %>
					              </td>
					            </tr>
					            <% } %>
					            
					            <% if (joDetail.has("CurrentInsuranceRejected") && !joDetail.getString("CurrentInsuranceRejected").isEmpty()) { %>
					            <tr style="background-color: #fff; border: 1px solid #ccc;">
					              <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah orang yang akan ditanggung memiliki permohonan asuransi jiwa atau kesehatan yang pernah ditolak, ditunda, diterima dengan syarat-syarat khusus oleh perusahaan asuransi atau perpanjangannya pernah ditolak</td>
					              <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
					                <%= "0".equals(joDetail.getString("CurrentInsuranceRejected")) ? "Tidak" : "Ya" %>
					              </td>
					            </tr>
					            <% } %>
					          </tbody>
					        </table>
					      </div>
					    </div>
					  </div>
					</div>
					
					
				</div>
				
				
				<!-- DETAIL TERTANGGUNG -->
				<div id="detailTertanggung">
					<div class="panel-wrapper mb-4level">
						<div class="panel">
							<div class="panel-body border-grey">
								<div class="border-b-grey">
								    <div class="px-6level py-8level">
								        <h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-8level">Detail Tertanggung</h4>
								        <% for(int i = 0 ; i < insureds.length(); i++ ) { 
								            JSONObject insuredObj = insureds.getJSONObject(i);
								            
								            String labelDataTertanggung = insuredObj.getString("Relationship");
								            String camelCaseString = labelDataTertanggung.substring(0, 1).toUpperCase() + labelDataTertanggung.substring(1).toLowerCase();
								            if(insuredObj.getString("Relationship").toLowerCase().contains("tertanggung")){
								                camelCaseString += " Utama";
								            }
								                
								            String genderFormat = insuredObj.getString("Gender").equals("M") ? "Laki-Laki" : "Perempuan";
								        %>
								        
								        <h4 class="text-18px agency-font-semibold agency-text-grey-800 mb-4level"><%=camelCaseString %></h4>
								        <table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
								            <tbody>
								                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Political Exposed Persons (PEP)</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("IsPep").equals("false") ? "Tidak" : "Ya" %></td>
								                </tr>
								                <% if (insuredObj.has("Relationship") && !insuredObj.getString("Relationship").isEmpty()) { %>
								                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Hubungan dengan pemegang polis</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("Relationship") %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("Relationship") && !insuredObj.getString("Relationship").isEmpty()) { %>
								                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("Relationship") %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("Gender") && !insuredObj.getString("Gender").isEmpty()) { %>
								                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Jenis Kelamin</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=genderFormat %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("BirthPlace") && !insuredObj.getString("BirthPlace").isEmpty()) { %>
								                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tempat Lahir</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("BirthPlace") %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("Dob") && !insuredObj.getString("Dob").isEmpty()) { %>
								                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Lahir</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                        <fmt:parseDate value="<%=insuredObj.getString("Dob") %>" pattern="yyyyMMdd" var="dob" />
								                        <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
								                    </td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("NationalityCountry") && !insuredObj.getString("NationalityCountry").isEmpty()) { %>
								                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kewarganegaraan</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("NationalityCountry") %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("IdNumber") && !insuredObj.getString("IdNumber").isEmpty()) { %>
								                <tr style="background-color:#fff; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. KTP</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("IdNumber") %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("PrimaryResidenceCountry") && !insuredObj.getString("PrimaryResidenceCountry").isEmpty()) { %>
								                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Negara Tempat Tinggal Utama</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("PrimaryResidenceCountry") %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("Job") && !insuredObj.getString("Job").isEmpty()) { %>
								                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Pekerjaan / Jabatan</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("Job") %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("BusinessFields") && !insuredObj.getString("BusinessFields").isEmpty()) { %>
								                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Bidang Usaha</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("BusinessFields") %></td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("IdPhoto") && !insuredObj.getString("IdPhoto").isEmpty()) { %>
								                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Foto Identitas</td>
								                    <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                        <div style="width: 200px; max-width: 100%;">
								                            <a href="<%=insuredObj.getString("IdPhoto") %>"><img class="img-thumbnail" src="<%=insuredObj.getString("IdPhoto") %>" alt="foto id"></a>
								                        </div>
								                    </td>
								                </tr>
								                <% } %>
								                <% if (insuredObj.has("MedicalHistory")) { //expected object
								                    JSONObject MedicalHistoryObj = insuredObj.getJSONObject("MedicalHistory");
								                    if (MedicalHistoryObj != null) { %>
								                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                    <td style="border: 1px solid #ccc; padding: 20px 12px 12px 12px;" colspan="2">
								                        <h5 class="text-16px agency-font-semibold agency-text-grey-800 mb-4level">Riwayat Medis yang Bersifat Rahasia</h5>
								                        <table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
								                            <tbody>
								                                <% if (MedicalHistoryObj.has("MedicalHeight") && !MedicalHistoryObj.getString("MedicalHeight").isEmpty()) { %>
								                                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Tinggi Badan</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalHeight") %> cm</td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalWeight") && !MedicalHistoryObj.getString("MedicalWeight").isEmpty()) { %>
								                                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Berat Badan</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalWeight") %> kg</td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalRecentCareFacility") && !MedicalHistoryObj.getString("MedicalRecentCareFacility").isEmpty()) { %>
								                                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Dirawat di fasilitas medis dalam lima tahun terakhir?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalRecentCareFacility").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalConsultation") && !MedicalHistoryObj.getString("MedicalConsultation").isEmpty()) { %>
								                                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Berkonsultasi dengan spesialis dalam lima tahun terakhir?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalConsultation").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalHealthIssues") && !MedicalHistoryObj.getString("MedicalHealthIssues").isEmpty()) { %>
								                                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Masalah kesehatan belum dikonsultasikan?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalHealthIssues").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalConsultationTreatment") && !MedicalHistoryObj.getString("MedicalConsultationTreatment").isEmpty()) { %>
								                                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Konsultasi dan pengobatan dalam dua tahun terakhir?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalConsultationTreatment").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalDentalCondition") && !MedicalHistoryObj.getString("MedicalDentalCondition").isEmpty()) { %>
								                                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Kondisi gigi kronis/jangka panjang?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalDentalCondition").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalCareAndTesting") && !MedicalHistoryObj.getString("MedicalCareAndTesting").isEmpty()) { %>
								                                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Sedang menjalani perawatan atau tes medis?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalCareAndTesting").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalDisclosures") && !MedicalHistoryObj.getString("MedicalDisclosures").isEmpty()) { %>
								                                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Pengungkapan tambahan terkait kondisi medis?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalDisclosures").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalPregnantStatus") && !MedicalHistoryObj.getString("MedicalPregnantStatus").isEmpty()) { %>
								                                <tr style="background-color: #fff; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Sedang hamil?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalPregnantStatus").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                                <% if (MedicalHistoryObj.has("MedicalTreatment") && !MedicalHistoryObj.getString("MedicalTreatment").isEmpty()) { %>
								                                <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Pernah/sedang menjalani pengobatan sakit/ketidakmampuan?</td>
								                                    <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalTreatment").equals("false") ? "Tidak" : "Ya" %></td>
								                                </tr>
								                                <% } %>
								                            </tbody>
								                        </table>
								                    </td>
								                </tr>
								                <% } } %>
								            </tbody>
								        </table>
								        <% } %>    
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
								<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
								  <tbody>
								    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Mulai</td>
								      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								      	<fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="startDate" />
                           				<fmt:formatDate value="${startDate}" pattern="dd MMM yyyy" />
								      </td>
								    </tr>
								    <tr style="background-color: #fff; border: 1px solid #ccc;">
								      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Selesai</td>
								      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								      	<fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="expdate" />
                           				<fmt:formatDate value="${expdate}" pattern="dd MMM yyyy" />
								      </td>
								    </tr>
								    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Wilayah Pertanggungan</td>
								      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("Area") %></td>
								    </tr>
								    <tr style="background-color: #fff; border: 1px solid #ccc;">
								      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama Plan</td>
								      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("Plan") %></td>
								    </tr>
								  </tbody>
								</table>	
								
							</div>
						</div>
					</div>
				</div>
				
				<div class="detailPolis mb-8level">
					<div class="panel-wrapper mb-4level">
						<div class="panel">
							<div class="panel-body border-grey">
								<div class="border-b-grey">
									<div class="px-6level py-8level">
										
									<!-- ----------------------Detail Pemegang Polis------------------------- -->
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Pemegang Polis</h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									  <tbody>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Political Exposed Persons (PEP)</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().isPep()?"Ya":"Tidak" %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getName() %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Jenis Kelamin</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getGender().equalsIgnoreCase("F")?"Perempuan":"Laki-Laki" %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tempat Lahir</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getBirthPlace() %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Lahir</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
									      	<fmt:parseDate value="<%= datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
	                           				<fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
									      </td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Status Perkawinan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getMaritalStatus().equalsIgnoreCase("married")?"Menikah" : "Lajang" %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
										  <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kewarganegaraan</td>
										  <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
										    <%= datas.getPolicyHolder().getNationalityCountry() != null ? datas.getPolicyHolder().getNationalityCountry() : datas.getPolicyHolder().getNationality() %>
										  </td>
										</tr>
									    <tr style="background-color:#fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. KTP</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getIdNumber() %></td>
									    </tr>
									    
									    <%
											String passportNumber = datas.getPolicyHolder().getPassportNumber();
											String kitasNumber = datas.getPolicyHolder().getKitasNumber();
											boolean hasPassportNumber = passportNumber != null && !passportNumber.isEmpty();
											boolean hasKitasNumber = kitasNumber != null && !kitasNumber.isEmpty();
										%>
										
										<% if (hasPassportNumber || hasKitasNumber) { %>
										    <tr style="background-color:#f9f9f9; border: 1px solid #ccc;">
										        <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. Passpor<% if (hasKitasNumber) { %> / No. Kitas<% } %></td>
										        <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
										            <%= hasPassportNumber ? passportNumber : "" %>
										            <% if (hasKitasNumber) { %>/ <%= kitasNumber %><% } %>
										        </td>
										    </tr>
										<% } %>
									    
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Email</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getEmail() %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. HP</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">+<%=datas.getPolicyHolder().getMobilePhone() %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kode Negara</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getCountryCode() %></td>
									    </tr>
									    
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kode Area</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getAreaCode() %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. Telepon</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getPhone() %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Alamat Tempat Tinggal Utama</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
									      <table style="border-collapse: collapse; border: 1px solid #ccc; width: 100%">
											  <tbody>
											    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Negara</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHResidentialCountry") %></td>
											    </tr>
											    <tr style="background-color: #fff; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Alamat Lengkap</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHResidentialAddress") %></td>
											    </tr>
											  </tbody>
											</table>
									      </td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah alamat negara asal Anda berbeda dari alamat tempat tinggal utama Anda?</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHDifferentResidential").equals("false")?"Tidak":"Ya" %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah alamat surat menyurat Anda berbeda dengan negara tempat tinggal utama</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHDifferentMailing").equals("false")?"Tidak":"Ya" %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah Anda atau salah satu dari tertanggung tinggal di luar negeri?</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joAddressDetail.getString("PHLiveAbroad").equals("false")?"Tidak":"Ya" %></td>
									    </tr>
									  </tbody>
									</table>	
									
									
									
									<!-- ----------------------Sumber Penghasilan------------------------- -->
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Sumber Penghasilan</h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									  <tbody>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama perusahaan tempat bekerja</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHCompanyName") %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Pekerjaan / Jabatan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHJobPosition") %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Bidang Usaha</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHBusinessField") %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Sumber Pembayaran Premi</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHPaymentSource") %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Total Penghasilan Tahunan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHAnnualIncome") %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Alasan mengajukan polis asuransi?</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joIncomeSource.getString("PHInsuranceReason") %></td>
									    </tr>
									  </tbody>
									</table>
									
									
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Dokter yang paling sering dikunjungi selama 5 tahun terakhir</h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
										  <tbody>
										    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
										      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama Dokter</td>
										      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorName") %></td>
										    </tr>
										    <tr style="background-color: #fff; border: 1px solid #ccc;">
										      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Negara</td>
										      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorCountry") %></td>
										    </tr>
										    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
										      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Alamat</td>
										      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorAddress") %></td>
										    </tr>
										    <tr style="background-color: #fff; border: 1px solid #ccc;">
										      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. Telepon</td>
										      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorPhone") %></td>
										    </tr>
										    
										    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
										      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Email</td>
										      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("DoctorEmail") %></td>
										    </tr>
										  </tbody>
										</table>
									
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
									
										<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Rekening Bank</h4>
										
										<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
										  <tbody>
										    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
										      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nomor Rekening</td>
										      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joBankAccount.getString("AccountBankNumber") %></td>
										    </tr>
										    <tr style="background-color: #fff; border: 1px solid #ccc;">
										      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama Bank</td>
										      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joBankAccount.getString("BankName") %></td>
										    </tr>
										    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
										      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama Pemilik Rekening</td>
										      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joBankAccount.getString("AccountBankName") %></td>
										    </tr>
										  </tbody>
										</table>
										
									</div>
								</div>
								
								<div class="px-6level py-8level">
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Perusahaan asuransi yang menjamin Anda saat ini atau sebelumnya</h4>
											
											<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
											  <tbody>
											    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah orang yang akan ditanggung saat ini atau sebelumnya pernah memiliki pertanggungan kesehatan dengan perusahaan asuransi manapun, termasuk AXA Insurance?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
											        <%= "0".equals(joDetail.getString("CurrentInsuranceHistory")) ? "Tidak" : "Ya" %>
											      </td>
											    </tr>
											    <tr style="background-color: #fff; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Apakah orang yang akan ditanggung memiliki permohonan asuransi jiwa atau kesehatan yang pernah ditolak, ditunda, diterima dengan syarat-syarat khusus oleh perusahaan asuransi atau perpanjangannya pernah ditolak</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
											        <%= "0".equals(joDetail.getString("CurrentInsuranceRejected")) ? "Tidak" : "Ya" %>
											      </td>
											    </tr>
											  </tbody>
											</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
				<!-- DETAIL TERTANGGUNG -->
				<div id="detailTertanggung">
					<div class="panel-wrapper mb-4level">
						<div class="panel">
							<div class="panel-body border-grey">
								<div class="border-b-grey">
									<div class="px-6level py-8level">
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-8level">Detail Tertanggung</h4>
										
									<% for(int i = 0 ; i < insureds.length(); i++ ) { 
										JSONObject insuredObj = insureds.getJSONObject(i);
										
										String labelDataTertanggung = insuredObj.getString("Relationship");
										String camelCaseString = labelDataTertanggung.substring(0, 1).toUpperCase() + labelDataTertanggung.substring(1).toLowerCase();
										if(insuredObj.getString("Relationship").toLowerCase().contains("tertanggung")){
											camelCaseString += " Utama";
										}
											
										String genderFormat = insuredObj.getString("Gender").equals("M") ? "Laki-Laki" : "Perempuan";
										
										%>
										
						
									<h4 class="text-18px agency-font-semibold agency-text-grey-800 mb-4level"><%=camelCaseString %></h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									  <tbody>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Political Exposed Persons (PEP)</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("IsPep").equals("false")?"Tidak":"Ya" %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Hubungan dengan pemegang polis</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("Relationship") %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("Relationship") %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Jenis Kelamin</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=genderFormat %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tempat Lahir</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("BirthPlace") %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Lahir</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
										    <fmt:parseDate value="<%=insuredObj.getString("Dob") %>" pattern="yyyyMMdd" var="dob" />
	                           				<fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
									      </td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kewarganegaraan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("NationalityCountry") %></td>
									    </tr>
									    <tr style="background-color:#fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. KTP</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("IdNumber") %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Negara Tempat Tinggal Utama</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("PrimaryResidenceCountry") %></td>
									    </tr>
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Pekerjaan / Jabatan</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("Job") %></td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Bidang Usaha</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=insuredObj.getString("BusinessFields") %></td>
									    </tr>
									    
									    <tr style="background-color: #fff; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Foto Identitas</td>
									      <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
										      <div style="width: 200px; max-width: 100%;">
												<a href="<%=insuredObj.getString("IdPhoto") %>"><img class="img-thumbnail" src="<%=insuredObj.getString("IdPhoto") %>" alt="foto id"></a>
											 </div>
									      </td>
									    </tr>
									    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 20px 12px 12px 12px;" colspan="2">
									      <h5 class="text-16px agency-font-semibold agency-text-grey-800 mb-4level">Riwayat Medis yang Bersifat Rahasia</h5>
									      
									      	<%

											if (insuredObj.has("MedicalHistory")) { //expected object
								        		JSONObject MedicalHistoryObj = insuredObj.getJSONObject("MedicalHistory");
									        
									      	%>
									      
									      	<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
											  <tbody>
											    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Tinggi Badan</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalHeight") %> cm</td>
											    </tr>
											    <tr style="background-color: #fff; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Berat Badan</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalWeight") %> kg</td>
											    </tr>
											    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Apakah Anda pernah dirawat inap di rumah sakit, fasilitas medis, panti jompo, atau tempat serupa lainnya dalam lima tahun terakhir?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalRecentCareFacility").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											    <tr style="background-color: #fff; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Apakah Anda berkonsultasi dengan spesialis atau praktisi medis dalam lima tahun terakhir?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalConsultation").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Apakah Anda mengalami gejala, kondisi medis, atau masalah kesehatan apa pun, tetapi belum berkonsultasi dengan praktisi medis dalam lima tahun terakhir?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalHealthIssues").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											    <tr style="background-color: #fff; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Apakah Anda berkonsultasi dengan praktisi medis atau profesional kesehatan dan/atau diberikan resep obat, pengobatan, atau bentuk perawatan lain dalam dua tahun terakhir?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalConsultationTreatment").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Apakah Anda memiliki kondisi medis atau gigi kronis/jangka panjang atau cedera, kecacatan, kelainan, atau penyakit berulang selama lima tahun terakhir?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalDentalCondition").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											    <tr style="background-color: #fff; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">diresepkan, konsultasi, pemeriksaan, investigasi, tes diagnostik, atau pemeriksaan yang sedang berlangsung, direncanakan, tertunda, atau menunggu hasil/diagnosis yang dikonfirmasi?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalCareAndTesting").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Apakah Anda memiliki pengungkapan lebih lanjut sehubungan dengan tanda, gejala, penyelidikan medis konsultasi, saran, konseling, operasi, obat-obatan, pengobatan, atau perawatan dan/atau masuk ke rumah sakit atau tempat serupa lainnya tidak disebutkan di atas?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalDisclosures").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											    <tr style="background-color: #fff; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Apakah Anda sedang hamil?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalPregnantStatus").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											    <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%">Apakah Anda pernah/sedang menjalani pengobatan sakit/ketidakmampuan?</td>
											      <td style="border: 1px solid #ccc; padding: 12px; width: 50%"><%=MedicalHistoryObj.getString("MedicalTreatment").equals("false")?"Tidak":"Ya" %></td>
											    </tr>
											  </tbody>
											</table>
											<% } %>
											
									      </td>
									    </tr>
									  </tbody>
									</table>
									
									<% } %>	
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


