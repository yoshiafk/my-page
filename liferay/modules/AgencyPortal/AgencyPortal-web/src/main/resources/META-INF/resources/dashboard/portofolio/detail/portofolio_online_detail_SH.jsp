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
    JSONArray jaCoverage = (JSONArray) renderRequest.getAttribute("coverages");
    JSONArray jaBuilding = (JSONArray) renderRequest.getAttribute("buildingcontents");
    JSONArray jaOtherPremises = (JSONArray) renderRequest.getAttribute("premises");
    
    // child of data
    JSONObject coverageType = null;
    if (joDetail.has("CoverageType")) { //expected object
    	coverageType = joDetail.getJSONObject("CoverageType");
    }
    
    JSONObject constructionClass = null;
    if (joDetail.has("ConstructionClass")) { //expected object
    	constructionClass = joDetail.getJSONObject("ConstructionClass");
    }
    
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
								        <%-- Asuransi SmartHome --%>
								        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%"><strong>Asuransi SmartHome</strong></td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                <table style="border-collapse: collapse; border: 1px solid #ccc; width: 100%">
								                    <tbody>
								                        <% if (datas.getReferenceNumber() != null && !datas.getReferenceNumber().isEmpty()) { %>
								                        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Reference number</td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><strong><%= datas.getReferenceNumber() %></strong></td>
								                        </tr>
								                        <% } %>
								                        <tr style="background-color: #fff; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Total Premi</td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                                <%= datas.getCurrency() %> 
								                                <fmt:setLocale value="id_ID" />
								                                <fmt:formatNumber value="<%= datasRes.getPremium() %>" type="number" />
								                            </td>
								                        </tr>
								                        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Biaya Materai</td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                                <%= datas.getCurrency() %> 
								                                <fmt:setLocale value="id_ID" />
								                                <fmt:formatNumber value="<%= datas.getStampDuty() %>" type="number" />
								                            </td>
								                        </tr>
								                        <tr style="background-color: #fff; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%"><strong>Total NetPremi</strong></td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><strong>
								                                <%= datas.getCurrency() %> 
								                                <fmt:setLocale value="id_ID" />
								                                <fmt:formatNumber value="<%= datas.getNetPremium() %>" type="number" /></strong>
								                            </td>
								                        </tr>
								                    </tbody>
								                </table>
								            </td>
								        </tr>
								        
								        <%-- Asuransi Gempa Bumi --%>
								        <tr style="background-color: #fff; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%"><strong>Asuransi Gempa Bumi</strong></td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                <table style="border-collapse: collapse; border: 1px solid #ccc; width: 100%">
								                    <tbody>
								                        <% if (joDetail.has("EarthquakeReferenceNumber") && !joDetail.getString("EarthquakeReferenceNumber").isEmpty()) { %>
								                        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Reference number</td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><strong><%= joDetail.getString("EarthquakeReferenceNumber") %></strong></td>
								                        </tr>
								                        <% } %>
								                        <% if (joDetail.has("EarthquakePremium") && !joDetail.getString("EarthquakePremium").isEmpty()) { %>
								                        <tr style="background-color: #fff; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Total Premi</td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                                <%= datas.getCurrency() %> 
								                                <fmt:setLocale value="id_ID" />
								                                <fmt:formatNumber value="<%= joDetail.getString("EarthquakePremium") %>" type="number" />
								                            </td>
								                        </tr>
								                        <% } %>
								                        <% if (joDetail.has("EarthquakeStampDuty") && !joDetail.getString("EarthquakeStampDuty").isEmpty()) { %>
								                        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Biaya Materai</td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                                <%= datas.getCurrency() %> 
								                                <fmt:setLocale value="id_ID" />
								                                <fmt:formatNumber value="<%= joDetail.getString("EarthquakeStampDuty") %>" type="number" />
								                            </td>
								                        </tr>
								                        <% } %>
								                        <% if (joDetail.has("EarthquakeNetPremium") && !joDetail.getString("EarthquakeNetPremium").isEmpty()) { %>
								                        <tr style="background-color: #fff; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%"><strong>Total NetPremi</strong></td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><strong>
								                                <%= datas.getCurrency() %> 
								                                <fmt:setLocale value="id_ID" />
								                                <fmt:formatNumber value="<%= joDetail.getString("EarthquakeNetPremium") %>" type="number" /></strong>
								                            </td>
								                        </tr>
								                        <% } %>
								                    </tbody>
								                </table>
								            </td>
								        </tr>
								        
								        <%-- Rate --%>
								        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%"><strong>Rate</strong></td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                <table style="border-collapse: collapse; border: 1px solid #ccc; width: 100%">
								                    <tbody>
								                        <% for(int i = 0 ; i < jaCoverage.length(); i++ ) { 
								                            JSONObject covObject = jaCoverage.getJSONObject(i);
								                            if (covObject.has("Rate") && !covObject.getString("Rate").isEmpty()) {
								                                String color = i % 2 == 0 ? "#f9f9f9" : "#fff";
								                                double rate = covObject.getDouble("Rate");
								                                rate = rate * 100;  // Mengonversi ke persentase
								                                DecimalFormat df = new DecimalFormat("#.####");
								                                String formattedRate = df.format(rate) + "%";
								                        %>
								                        <tr style="background-color: <%=color%>; border: 1px solid #ccc;">
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 40%"><%= covObject.getString("Name") %></td>
								                            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%= formattedRate %></td>
								                        </tr>
								                        <% } } %>
								                    </tbody>
								                </table>
								            </td>
								        </tr>
								        
								        <%-- Tanggal Mulai --%>
								        <% if (datas.getStartDate() != null && !datas.getStartDate().isEmpty()) { %>
								        <tr style="background-color: #fff; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Mulai</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                <fmt:parseDate value="<%= datas.getStartDate() %>" pattern="yyyyMMdd" var="startDate" />
								                <fmt:formatDate value="${startDate}" pattern="dd MMM yyyy" />
								            </td>
								        </tr>
								        <% } %>
								        
								        <%-- Tanggal Selesai --%>
								        <% if (datas.getExpiredDate() != null && !datas.getExpiredDate().isEmpty()) { %>
								        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Selesai</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                <fmt:parseDate value="<%= datas.getExpiredDate() %>" pattern="yyyyMMdd" var="expdate" />
								                <fmt:formatDate value="${expdate}" pattern="dd MMM yyyy" />
								            </td>
								        </tr>
								        <% } %>
								    </tbody>
								</table>
								
								
								<!-- ----------------------Detail Pemegang Polis------------------------- -->
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Pemegang Polis</h4>
								<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
								    <tbody>
								        <%-- Political Exposed Persons (PEP) --%>
								        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Political Exposed Persons (PEP)</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().isPep()?"Ya":"Tidak" %></td>
								        </tr>
								        
								        <%-- Nama --%>
								        <% if (datas.getPolicyHolder().getName() != null && !datas.getPolicyHolder().getName().isEmpty()) { %>
								        <tr style="background-color: #fff; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Nama</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getName() %></td>
								        </tr>
								        <% } %>
								        
								        <%-- Jenis Kelamin --%>
								        <% if (datas.getPolicyHolder().getGender() != null && !datas.getPolicyHolder().getGender().isEmpty()) { %>
								        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Jenis Kelamin</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getGender().equalsIgnoreCase("F")?"Perempuan":"Laki-Laki" %></td>
								        </tr>
								        <% } %>
								        
								        <%-- Tempat Lahir --%>
								        <% if (datas.getPolicyHolder().getBirthPlace() != null && !datas.getPolicyHolder().getBirthPlace().isEmpty()) { %>
								        <tr style="background-color: #fff; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tempat Lahir</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getBirthPlace() %></td>
								        </tr>
								        <% } %>
								        
								        <%-- Tanggal Lahir --%>
								        <% if (datas.getPolicyHolder().getDob() != null && !datas.getPolicyHolder().getDob().isEmpty()) { %>
								        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggal Lahir</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                <fmt:parseDate value="<%= datas.getPolicyHolder().getDob() %>" pattern="yyyyMMdd" var="dob" />
								                <fmt:formatDate value="${dob}" pattern="dd MMM yyyy" />
								            </td>
								        </tr>
								        <% } %>
								        
								        <%-- Kewarganegaraan --%>
								        <% if ((datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) || 
								                (datas.getPolicyHolder().getNationality() != null && !datas.getPolicyHolder().getNationality().isEmpty())) { %>
								        <tr style="background-color: #fff; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kewarganegaraan</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%= (datas.getPolicyHolder().getNationalityCountry() != null && !datas.getPolicyHolder().getNationalityCountry().isEmpty()) ? datas.getPolicyHolder().getNationalityCountry() : datas.getPolicyHolder().getNationality() %></td>
								        </tr>
								        <% } %>
								        
								        <%-- No. KTP --%>
								        <% if (datas.getPolicyHolder().getIdNumber() != null && !datas.getPolicyHolder().getIdNumber().isEmpty()) { %>
								        <tr style="background-color:#f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. KTP</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getIdNumber() %></td>
								        </tr>
								        <% } %>
								       
								        <%-- No. Passpor / No. Kitas --%>
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
										        <%= hasPassportNumber ? passportNumber : "" %>
										        <%= hasPassportNumber && hasKitasNumber ? " / " : "" %>
										        <%= hasKitasNumber ? kitasNumber : "" %>
										    </td>
										</tr>
										<% } %>
								        
								        
								        <%-- Email --%>
								        <% if (datas.getPolicyHolder().getEmail() != null && !datas.getPolicyHolder().getEmail().isEmpty()) { %>
								        <tr style="background-color: #fff; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Email</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getEmail() %></td>
								        </tr>
								        <% } %>
								        
								        <%-- No. HP --%>
								        <% if (datas.getPolicyHolder().getMobilePhone() != null && !datas.getPolicyHolder().getMobilePhone().isEmpty()) { %>
								        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">No. HP</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">+<%=datas.getPolicyHolder().getMobilePhone() %></td>
								        </tr>
								        <% } %>
								        
								        <%-- Alamat Sesuai KTP --%>
								        <% if (datas.getPolicyHolder().getAddress() != null && !datas.getPolicyHolder().getAddress().isEmpty()) { %>
								        <tr style="background-color: #fff; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Alamat Sesuai KTP</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getAddress() %></td>
								        </tr>
								        <% } %>
								        
								        <%-- Kode Pos --%>
								        <% if (datas.getPolicyHolder().getZip() != null && !datas.getPolicyHolder().getZip().isEmpty()) { %>
								        <tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kode Pos</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=datas.getPolicyHolder().getZip() %></td>
								        </tr>
								        <% } %>
								        
								        <%-- Foto Identitas --%>
								        <% if (datas.getPolicyHolder().getIdPhoto() != null && !datas.getPolicyHolder().getIdPhoto().isEmpty()) { %>
								        <tr style="background-color: #fff; border: 1px solid #ccc;">
								            <td style="border: 1px solid #ccc; padding: 12px; width: 40%">Foto Identitas</td>
								            <td style="border: 1px solid #ccc; padding: 12px; width: 60%">
								                <div style="width: 200px; max-width: 100%;">
								                    <a href="<%=datas.getPolicyHolder().getIdPhoto() %>"><img class="img-thumbnail" src="<%=datas.getPolicyHolder().getIdPhoto() %>" alt="Foto Identitas"></a>
								                </div>
								            </td>
								        </tr>
								        <% } %>
								    </tbody>
								</table>
								
								
								<!-- ----------------------Detail Proteksi------------------------- -->
								
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Detail Proteksi</h4>
								<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									<tbody>
										<% if(coverageType.has("Name") && !coverageType.getString("Name").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Jenis Pertanggungan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=coverageType.getString("Name") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("BuildingCoverage") && !joDetail.getString("BuildingCoverage").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Harga Pertanggungan Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%">
												<%-- <%=joDetail.getString("BuildingCoverage") %> --%>
												<%=datas.getCurrency() %> 
						                        <fmt:setLocale value="id_ID" />
						                        <fmt:formatNumber value="<%=joDetail.getString("BuildingCoverage") %>" type="number" />
											</td>
										</tr>
										<% } %>
										<% if(joDetail.has("EarthquakeCover") && !joDetail.getString("EarthquakeCover").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Perlindungan earthquake / gempa bumi</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("EarthquakeCover").equals("false") ? "Tidak" : "Ya" %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("PersonalLiability") && !joDetail.getString("PersonalLiability").isEmpty() && joDetail.has("PersonalLiabilityRate")) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Tanggung Jawab Hukum Pribadi Terhadap Pihak Ketiga</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%">
												<%-- <%=datas.getCurrency() %> 
						                        <fmt:setLocale value="id_ID" />
						                        <fmt:formatNumber value="<%=joDetail.getString("PersonalLiability") %>" type="number" /> --%>
												<%=joDetail.getString("PersonalLiability").replace(",", ".") %> (Rate <%=joDetail.getDouble("PersonalLiabilityRate")*100 %>%)
											</td>
										</tr>
										<% } %>
									</tbody>
								</table>
																
								
								
								<!-- ----------------------Informasi properti------------------------- -->
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Informasi Properti</h4>
								<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									<tbody>
										<% if(joDetail.has("BuildingAddress") && !joDetail.getString("BuildingAddress").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Lokasi</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("BuildingAddress") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("Province") && !joDetail.getString("Province").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Propinsi</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("Province") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("City") && !joDetail.getString("City").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kota</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("City") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("Kecamatan") && !joDetail.getString("Kecamatan").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kecamatan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("Kecamatan") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("KodePos") && !joDetail.getString("KodePos").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kode Pos</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("KodePos") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("AreaCode") && !joDetail.getString("AreaCode").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Zona</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("AreaCode") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("BuildingType") && !joDetail.getString("BuildingType").isEmpty()) { %>
										<tr style="background-color:#f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Penggunaan dari Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("BuildingType") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("NumberOfFloors") && !joDetail.getString("NumberOfFloors").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Jumlah Lantai</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("NumberOfFloors") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("BuildingStatus") && !joDetail.getString("BuildingStatus").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Status Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("BuildingStatus") %></td>
										</tr>
										<% } %>
										<% if(constructionClass.has("Name") && !constructionClass.getString("Name").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Kelas Konstruksi Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=constructionClass.getString("Name") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("BuildingAge") && !joDetail.getString("BuildingAge").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Usia Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("BuildingAge") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("FrontSideBuilding") && !joDetail.getString("FrontSideBuilding").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Bagian Depan Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("FrontSideBuilding") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("RearSideBuilding") && !joDetail.getString("RearSideBuilding").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Bagian Belakang Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("RearSideBuilding") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("RightSideBuilding") && !joDetail.getString("RightSideBuilding").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Bagian Kanan Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("RightSideBuilding") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("LeftSideBuilding") && !joDetail.getString("LeftSideBuilding").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Bagian Kiri Bangunan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%"><%=joDetail.getString("LeftSideBuilding") %></td>
										</tr>
										<% } %>
										<% if(joDetail.has("FrontSidePhoto") && !joDetail.getString("FrontSidePhoto").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Foto Depan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%">
												<div style="width: 200px; max-width: 100%;">
													<a href="<%=joDetail.getString("FrontSidePhoto") %>"><img class="img-thumbnail" src="<%=joDetail.getString("FrontSidePhoto") %>" alt="Foto depan bangunan"></a>
												</div>
											</td>
										</tr>
										<% } %>
										<% if(joDetail.has("RearSidePhoto") && !joDetail.getString("RearSidePhoto").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Foto Belakang</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%">
												<div style="width: 200px; max-width: 100%;">
													<a href="<%=joDetail.getString("RearSidePhoto") %>"><img class="img-thumbnail" src="<%=joDetail.getString("RearSidePhoto") %>" alt="Foto belakang bangunan"></a>
												</div>
											</td>
										</tr>
										<% } %>
										<% if(joDetail.has("RightSidePhoto") && !joDetail.getString("RightSidePhoto").isEmpty()) { %>
										<tr style="background-color: #fff; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Foto Samping Kanan</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%">
												<div style="width: 200px; max-width: 100%;">
													<a href="<%=joDetail.getString("RightSidePhoto") %>"><img class="img-thumbnail" src="<%=joDetail.getString("RightSidePhoto") %>" alt="Foto kanan bangunan"></a>
												</div>
											</td>
										</tr>
										<% } %>
										<% if(joDetail.has("LeftSidePhoto") && !joDetail.getString("LeftSidePhoto").isEmpty()) { %>
										<tr style="background-color: #f9f9f9; border: 1px solid #ccc;">
											<td style="border: 1px solid #ccc; padding: 12px; width: 40%">Foto Samping Kiri</td>
											<td style="border: 1px solid #ccc; padding: 12px; width: 60%">
												<div style="width: 200px; max-width: 100%;">
													<a href="<%=joDetail.getString("LeftSidePhoto") %>"><img class="img-thumbnail" src="<%=joDetail.getString("LeftSidePhoto") %>" alt="Foto kiri bangunan"></a>
												</div>
											</td>
										</tr>
										<% } %>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				
				<!-- building content and promises -->
				<%
				if ((joDetail.has("BuildingContent") && joDetail.getJSONArray("BuildingContent").length() > 0) || 
				    (joDetail.has("OutsidePremises") && joDetail.getJSONArray("OutsidePremises").length() > 0)) {
				%>
								
				<div class="panel-wrapper mb-4level">
					<div class="panel">
						<div class="panel-body border-grey">
							<div class="border-b-grey">
								<div class="px-6level py-8level">
								
								<% if(jaBuilding.length() > 0) { %>
									<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Perlindungan Isi Bangunan</h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									  <thead>
									  	<tr style="background-color: #333;">
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">#</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Tipe Barang</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Jenis Barang</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Total Pertanggungan</td>
										</tr>
									  </thead>
									  <tbody>
									  	<% for(int i = 0 ; i < jaBuilding.length(); i++ ) { 
											JSONObject buildContentObject = jaBuilding.getJSONObject(i);
											String color = i % 2 == 0 ? "#f9f9f9" : "#fff";
										%>
									  	
									     <tr style="background-color: <%=color %>; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=i+1 %></td>
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=buildContentObject.getString("Type") %></td>
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=buildContentObject.getString("Name") %></td>
									      <td style="border: 1px solid #ccc; padding: 12px; ">
									      	<%=datas.getCurrency() %> 
							                <fmt:setLocale value="id_ID" />
							                <fmt:formatNumber value="<%=buildContentObject.getString("Coverage") %>" type="number" />
									      </td>
									    </tr>
									    
									    <% } %>
									  </tbody>
									</table>
									
									<% } %>
								</div>
							</div>
							
							<% if(jaOtherPremises.length() > 0)  { %>
							
							<div class="px-6level py-8level">
								<h4 class="text-20px agency-font-semibold agency-text-grey-800 mb-4level">Barang-Barang di Luar Lokasi Pertanggungan</h4>
									<table class="mb-8level" style="border-collapse: collapse; font-family: 'SourceSansPro-Regular', sans-serif; border: 1px solid #ccc; width: 100%">
									  <thead>
									  	<tr style="background-color: #333;">
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">#</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Tipe Barang</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Kategori Barang</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Merek Pertanggungan</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Seri/Model Pertanggungan</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Rate</td>
										  <td style="border: 1px solid #999; color: #fff; font-weight: bold; padding: 12px;">Total Pertanggungan</td>
										</tr>
									  </thead>
									  <tbody>
									  	<% for(int i = 0 ; i < jaOtherPremises.length(); i++ ) { 
											JSONObject otherPremiseObject = jaOtherPremises.getJSONObject(i);
											String color = i % 2 == 0 ? "#f9f9f9" : "#fff";
										%>
									    
									    <tr style="background-color: <%=color %>; border: 1px solid #ccc;">
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=i+1 %></td>
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=otherPremiseObject.getString("Type") %></td>
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=otherPremiseObject.getString("Category") %></td>
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=otherPremiseObject.getString("Name") %></td>
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=otherPremiseObject.getString("Series") %></td>
									      <td style="border: 1px solid #ccc; padding: 12px; "><%=otherPremiseObject.getDouble("Rate")*100 %>%</td>
									      <td style="border: 1px solid #ccc; padding: 12px; ">
									      	<%=datas.getCurrency() %> 
							                <fmt:setLocale value="id_ID" />
							                <fmt:formatNumber value="<%=otherPremiseObject.getString("Coverage") %>" type="number" />
									      </td>
									    </tr>
									    
									    <% } %>
									  </tbody>
									</table>
							</div>
							
							<% } %>
						</div>
					</div>
				</div>
				
				<% } %>

			</div>
		</div>
	</div>
</div>


