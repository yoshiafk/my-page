<%@page import="java.util.stream.Collectors"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.mypage.leads.service.CustomerLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.Customer"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.mypage.product.it.helper.EncryptionHelper" %>
<%@ include file="init.jsp"%>

<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<% String myInsuranceLink = (String)renderRequest.getAttribute("myInsuranceLink"); %>

<%
LocalDateTime timestampForJSURI = LocalDateTime.now();
DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>

<%
	String portalURL = PortalUtil.getPortalURL(request);
	String restApiUrl = portalURL + "/o/api/sti/step3"; ///o access from osgi, /api/sti/kyc is path api 
	String restApiOcrUrl = portalURL + "/o/api/sti/ocr";
	String restApiProcessUrl = portalURL + "/o/api/sti/process";
	String restApiCalculateUrl = portalURL + "/o/api/sti/calculate";
	String lparam = (String) renderRequest.getAttribute("paramL");
	//boolean isB2B = (Boolean) request.getAttribute("isB2B");
	
	boolean isScanOcr = (Boolean) request.getAttribute("isScanOcr");
	
	String apiLiferayCountries = (String) request.getAttribute("apiLiferayCountries");
	
	String restApiCountriesUrl = portalURL + "/o/api/sti/countries";
	String restApiImageUrl = portalURL + "/o/api/sti/images";
	
	String managedBy = (String)renderRequest.getAttribute("managedBy");
	String managedById = (String)renderRequest.getAttribute("managedById");
	String businessModel = (String)renderRequest.getAttribute("businessModel");
	String tokenLimiter = (String)renderRequest.getAttribute("tokenLimiter");
	boolean continueQuotation = (boolean)renderRequest.getAttribute("continueQuotation");
	long lId = Long.valueOf((long)renderRequest.getAttribute("lId"));
	String quouteId = (String)renderRequest.getAttribute("quouteId");
	boolean simpleQuotation = (boolean) renderRequest.getAttribute("simpleQuotation");
	String prevToken = (String)renderRequest.getAttribute("pvt");
	String aParam = (String) renderRequest.getAttribute("a");
	String rcParam = (String) renderRequest.getAttribute("rc");
	String bParam = (String) renderRequest.getAttribute("b");
%>

<% String sanctionCountry = (String)renderRequest.getAttribute("sanctionCountry"); %>

<%
	Leads _leads = null;
	DetailInternationalTravel _detailInternationalTravel = null;
%>

<%
	if (continueQuotation && simpleQuotation) {
		if (lId > 0) {
			_leads = LeadsLocalServiceUtil.getLeads(lId);
			if (_leads != null) {
				_detailInternationalTravel = DetailInternationalTravelLocalServiceUtil.findByLeadsId(lId);
			}
		}
	}
%>

<%
	if(!prevToken.isEmpty()) {
		_leads = LeadsLocalServiceUtil.findByToken(prevToken);
		if(_leads != null) {
			_detailInternationalTravel = DetailInternationalTravelLocalServiceUtil.findByLeadsId(_leads.getLeadsId());
		}
	}
%>

<%-- Membuat URL untuk riplay.jsp --%>
<portlet:renderURL var="riplayBaseURL">
	<portlet:param name="jspPage" value="/step4.jsp" />
</portlet:renderURL>

<%
	String riplayURL = riplayBaseURL;
	if (Validator.isNotNull(aParam)) riplayURL = riplayURL + "&a=" + aParam;
	if (Validator.isNotNull(rcParam)) riplayURL = riplayURL + "&rc=" + rcParam;
	if (Validator.isNotNull(bParam)) riplayURL = riplayURL + "&b=" + bParam;
%>

<portlet:renderURL var="step2BaseURL">
	<portlet:param name="jspPage" value="/step2.jsp" />
</portlet:renderURL>

<% 
    String step2URL = step2BaseURL;
    if (Validator.isNotNull(aParam)) step2URL = step2URL + "&a=" + aParam;
    if (Validator.isNotNull(rcParam)) step2URL = step2URL + "&rc=" + rcParam;
    if (Validator.isNotNull(bParam)) step2URL = step2URL + "&b=" + bParam;
%>

<script src="<%=request.getContextPath()%>/js/main.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/util.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>

<%
	if ((_leads != null && _detailInternationalTravel != null && continueQuotation && simpleQuotation) || !prevToken.isEmpty()) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
		String _dDate = formatter.format(_detailInternationalTravel.getDepartureDate());
		String _aDate = formatter.format(_detailInternationalTravel.getArrivalDate());
%>
<script>
	updateSess(_smartTravelInternationalFormDetailSess, "Name", '<%=_leads.getName()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Email", '<%=_leads.getEmail()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ManagedBy", '<%=_leads.getManagedBy()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Role", '<%=_leads.getChannel()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "QuoteId", '<%=quouteId%>');
	updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", '<%=_leads.getPromoCode()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Currency", '<%=_leads.getCurrency().toLowerCase()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "TravellerType", '<%=_detailInternationalTravel.getTravellerType()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "AdultTotal", '<%=_detailInternationalTravel.getAdult()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ChildTotal", '<%=_detailInternationalTravel.getChild()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "DepartureDate", '<%=_dDate%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ArrivalDate", '<%=_aDate%>');
	updateSess(_smartTravelInternationalFormDetailSess, "TravelType", '<%=_detailInternationalTravel.getTravelType()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ChoosenPlan", '<%=_detailInternationalTravel.getPackageType()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "AdultTotalFromStep1", '<%=_detailInternationalTravel.getAdult()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ChildTotalFromStep1", '<%=_detailInternationalTravel.getChild()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "BusinessModel", '<%=_leads.getBussinesModel()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Tlmtr", '<%=tokenLimiter%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Token", '<%=_leads.getToken()%>');
	
	let additionalBenefits = '<%=_detailInternationalTravel.getListBenefitId()%>';
	
	if(additionalBenefits === "[]" || additionalBenefits === "") {
		updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", []);
	} else {
		updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", JSON.parse(additionalBenefits));
	}
</script>
<% } %>

<script>
var lId = 0;
let _sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

if(_sessData && typeof _sessData.lid !== "undefined") {
	lId = _sessData.lid;
}

var kycURL = "<%=restApiUrl%>";
var ocrURL = "<%=restApiOcrUrl%>";
var link = "<%=riplayURL%>";
var restApiProcessUrl = "<%=restApiProcessUrl%>";
var restApiCalculateUrl = "<%=restApiCalculateUrl%>";
var isScanOcr = "<%=isScanOcr%>";
var linkstep2 = "<%=step2URL%>";
var apiLRCountries = "<%=apiLiferayCountries%>";
var restApiCountriesUrl = "<%=restApiCountriesUrl%>";
var restApiImageUrl = "<%=restApiImageUrl%>";
var riplayURL = "<%=riplayURL%>";
var simpleQuotation = "<%=simpleQuotation%>";

var managedById = '<%= managedById %>'.trim();
if (managedById !== "null" && managedById !== "") {
    updateSess(_smartTravelInternationalFormDetailSess, "ManagedById", managedById);
}
</script>

<% 
	if(!prevToken.isEmpty()) { 
		
		JSONObject payloadData = null;
		List<Customer> customers = CustomerLocalServiceUtil.findByLeadsId(_leads.getLeadsId());
		
		if (customers.size() > 0) {
			JSONObject policyholder = JSONFactoryUtil.createJSONObject();
		    policyholder.put("_ispep", _leads.getIsPep());
		    policyholder.put("_name", _leads.getName());
		    policyholder.put("_ktppaspor", _leads.getPassportNumber());
		    policyholder.put("_dob", _leads.getDob());
		    policyholder.put("_pdob", _leads.getBirthPlace());
		    policyholder.put("_gender", _leads.getGender());
		    policyholder.put("_kodenegara", _leads.getCountryCode());
		    policyholder.put("_hp", _leads.getMobilePhone());
		    policyholder.put("_negara", _leads.getNationality());
		    policyholder.put("_job", _leads.getJob());
		    policyholder.put("_otherjob", _leads.getJobOther());
		    
		    String nationality = _leads.getNationality();
			if (nationality.equalsIgnoreCase("indonesia")) {
				policyholder.put("_ktpkitas", _leads.getIdNumber());
			} else {
				policyholder.put("_ktpkitas", _leads.getKitasNumber());
			}
		    
		    policyholder.put("_age", _leads.getAge());
		    policyholder.put("_statuskawin", _leads.getMaritalStatus());
		    policyholder.put("_telepon", _leads.getPhone());
		    policyholder.put("_email", _leads.getEmail());
		    policyholder.put("_kodepos", _leads.getZip());
		    policyholder.put("_alamat", _leads.getAddress());
		    
		    if (_leads.getIdPhotoFileEntryId() > 0) {
		    	policyholder.put("_photoUrl", restApiImageUrl + "/" + EncryptionHelper.encrypt(String.valueOf(_leads.getIdPhotoFileEntryId())));
			    policyholder.put("_photoFileEntryId",  _leads.getIdPhotoFileEntryId());
		    }
		    
		    JSONArray insuredList = JSONFactoryUtil.createJSONArray();
		    for (Customer customer : customers) {
		    	
		        JSONObject insured = JSONFactoryUtil.createJSONObject();
	
		        insured.put("_ispep", customer.getIsPep());
		        insured.put("_name", customer.getName());
		        insured.put("_ktppaspor", customer.getPassportNumber());
		        insured.put("_dob", customer.getDob());
		        insured.put("_pdob", customer.getBirthPlace());
		        insured.put("_gender", customer.getGender());
		        insured.put("_kodenegara", customer.getCountryCode());
		        insured.put("_hp", customer.getMobilePhone());
		        insured.put("_negara", customer.getNationality());
		        insured.put("_job", customer.getJob());
		        insured.put("_otherjob", customer.getJobOther());
		        
		        String nationalityins = customer.getNationality();
				if (nationalityins.equalsIgnoreCase("indonesia")) {
					insured.put("_ktpkitas", customer.getIdNumber());
				} else {
					insured.put("_ktpkitas", customer.getKitasNumber());
				}
		        
		        
		        insured.put("_age", customer.getAge());
		        insured.put("_statuskawin", customer.getMaritalStatus());
		        insured.put("_telepon", customer.getPhone());
		        insured.put("_email", customer.getEmail());
		        insured.put("_kodepos", customer.getZip());
		        insured.put("_alamat", customer.getAddress());
		        
		        if (customer.getIdPhotoFileEntryId() > 0) {
			        insured.put("_photoUrl", restApiImageUrl + "/" + EncryptionHelper.encrypt(String.valueOf(customer.getIdPhotoFileEntryId())));
			        insured.put("_photoFileEntryId",  customer.getIdPhotoFileEntryId());
		        }
		        
		        insured.put("_relationship", customer.getRelationship());
		        insuredList.put(insured);
		    }
		    
					
					// Separate the list into listChildren and listAdult using Java Streams
					List<Customer> listChildren = new ArrayList<>();
					List<Customer> listAdult = new ArrayList<>();
	
					int totalAdults = _detailInternationalTravel.getAdult();
					int totalChildren = _detailInternationalTravel.getChild();
					String travellerType = _detailInternationalTravel.getTravellerType();
					
					if ("Duo".equalsIgnoreCase(travellerType)) {
						Customer utama = customers.stream()
				                .filter(cus -> "Pasangan".equalsIgnoreCase(cus.getRelationship()) || "Tertanggung Utama".equalsIgnoreCase(cus.getRelationship()))
				                .findFirst().orElse(null); // collect(Collectors.toList()).get(0);
				    
						Customer kerabatTeman = customers.stream()
						        .filter(cus -> "Kerabat".equalsIgnoreCase(cus.getRelationship()) || "Teman".equalsIgnoreCase(cus.getRelationship()))
						        .findFirst().orElse(null); // collect(Collectors.toList()).get(0);
	
						
						if (totalAdults == 2) {
					        // Semua menjadi dewasa
					        
					    	if (utama != null) listAdult.add(utama); 
					    	if (kerabatTeman != null) listAdult.add(kerabatTeman);
					        
					    } else if (totalChildren == 1 && totalAdults == 1) {
					    	
					    	if (utama != null) listAdult.add(utama);   // Data pertama menjadi dewasa
					    	if (kerabatTeman != null) listChildren.add(kerabatTeman); // Data kedua menjadi anak
					    }
					} else {
					    listChildren = customers.stream()
					            .filter(cus -> "Anak".equalsIgnoreCase(cus.getRelationship()) || "Anak / Pelajar".equalsIgnoreCase(cus.getRelationship()))
					            .collect(Collectors.toList());
	
					    listAdult = customers.stream()
					            .filter(cus -> "Pasangan".equalsIgnoreCase(cus.getRelationship()) || "Tertanggung Utama".equalsIgnoreCase(cus.getRelationship()))
					            .collect(Collectors.toList());
					}      
		    
	
		    // Bangun JSONArray untuk insured
		    JSONArray adultList = JSONFactoryUtil.createJSONArray();
		    if (listAdult.size() > 0) {
			    for (Customer customer : listAdult) {
			    	if (customer == null) {
			            continue;
			        }
			    	
			        JSONObject adult = JSONFactoryUtil.createJSONObject();
		
			        adult.put("_ispep", customer.getIsPep());
			        adult.put("_name", customer.getName());
			        adult.put("_ktppaspor", customer.getPassportNumber());
			        adult.put("_dob", customer.getDob());
			        adult.put("_pdob", customer.getBirthPlace());
			        adult.put("_gender", customer.getGender());
			        adult.put("_kodenegara", customer.getCountryCode());
			        adult.put("_hp", customer.getMobilePhone());
			        adult.put("_negara", customer.getNationality());
			        adult.put("_job", customer.getJob());
			        adult.put("_otherjob", customer.getJobOther());
			        
			        String nationalityins = customer.getNationality();
					if (nationalityins.equalsIgnoreCase("indonesia")) {
						adult.put("_ktpkitas", customer.getIdNumber());
					} else {
						adult.put("_ktpkitas", customer.getKitasNumber());
					}
			        
					adult.put("_age", customer.getAge());
					adult.put("_statuskawin", customer.getMaritalStatus());
					adult.put("_telepon", customer.getPhone());
					adult.put("_email", customer.getEmail());
					adult.put("_kodepos", customer.getZip());
					adult.put("_alamat", customer.getAddress());
					
					if (customer.getIdPhotoFileEntryId() > 0) {
						adult.put("_photoUrl", restApiImageUrl + "/" + EncryptionHelper.encrypt(String.valueOf(customer.getIdPhotoFileEntryId())));
						adult.put("_photoFileEntryId",  customer.getIdPhotoFileEntryId());
					}
					
					adult.put("_relationship", customer.getRelationship());
		
					adultList.put(adult);
			        
			    }
		    }
		   
		    
		 // Bangun JSONArray untuk insured
		    JSONArray childList = JSONFactoryUtil.createJSONArray();
		 	if (listChildren.size() > 0) {
			    for (Customer customer : listChildren) {
			    	if (customer == null) {
			            continue;
			        }
			    	
			        JSONObject child = JSONFactoryUtil.createJSONObject();
		
			        child.put("_ispep", customer.getIsPep());
			        child.put("_name", customer.getName());
			        child.put("_ktppaspor", customer.getPassportNumber());
			        child.put("_dob", customer.getDob());
			        child.put("_pdob", customer.getBirthPlace());
			        child.put("_gender", customer.getGender());
			        child.put("_kodenegara", customer.getCountryCode());
			        child.put("_hp", customer.getMobilePhone());
			        child.put("_negara", customer.getNationality());
			        child.put("_job", customer.getJob());
			        child.put("_otherjob", customer.getJobOther());
			        
			        String nationalityins = customer.getNationality();
					if (nationalityins.equalsIgnoreCase("indonesia")) {
						child.put("_ktpkitas", customer.getIdNumber());
					} else {
						child.put("_ktpkitas", customer.getKitasNumber());
					}
			        
					child.put("_age", customer.getAge());
					child.put("_statuskawin", customer.getMaritalStatus());
					child.put("_telepon", customer.getPhone());
					child.put("_email", customer.getEmail());
					child.put("_kodepos", customer.getZip());
					child.put("_alamat", customer.getAddress());
					
					if (customer.getIdPhotoFileEntryId() > 0) {
						child.put("_photoUrl", restApiImageUrl + "/" + EncryptionHelper.encrypt(String.valueOf(customer.getIdPhotoFileEntryId())));
						child.put("_photoFileEntryId",  customer.getIdPhotoFileEntryId());
					}
					
					child.put("_relationship", customer.getRelationship());
		
					childList.put(child);
			        
			    }
		 	}
		    
		    payloadData = JSONFactoryUtil.createJSONObject();
		    payloadData.put("policyholder", policyholder);
		    payloadData.put("insured", insuredList);
		    
		    payloadData.put("adults", adultList);
		    payloadData.put("children", childList);
		    
		    payloadData.put("travellerType", _detailInternationalTravel.getTravellerType());
		    payloadData.put("AdultTotal", _detailInternationalTravel.getAdult());
		    payloadData.put("ChildTotal", _detailInternationalTravel.getChild());
		}
%>
<script>
	lId = <%= _leads.getLeadsId() %>
	
	<% if (customers.size() > 0) { %>
		var _SmartTravelInternationalDataPayloadSess = "SmartTravelInternationalDataPayload";
		
		let dataPayloadSessData = sessionStorage.getItem(_SmartTravelInternationalDataPayloadSess);
		dataPayloadSessData = dataPayloadSessData ? JSON.parse(dataPayloadSessData) : {};
		
		dataPayloadSessData = JSON.parse('<%=payloadData%>');
		sessionStorage.setItem(_SmartTravelInternationalDataPayloadSess, JSON.stringify(dataPayloadSessData));
	<% } %>
</script>
<% } %>

<header class="hero">
	<img src="/o/mypage-theme/images/step2hero.png" alt="herostep2" class="width-full height-full">
</header>

<%-- <%=lparam %> --%>
<section class="chosee-plan">

	<!-- navbar -->
	<%@ include file="/includes/navbar.jsp"%>


	<!-- step bar -->
		<div class="stepper-wrapper">
		<div class="stepper-item completed">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Pilih Perlindungan</div>
		</div>
		<div class="stepper-item active">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Data Pemegang Polis</div>
		</div>
		<div class="stepper-item">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Persetujuan</div>
		</div>
		<div class="stepper-item">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Pembayaran</div>
		</div>
	</div>
	<!-- end step bar -->

	<div class="chosee-plan__tabs">
		<div class="container-axa">
			<div class="tab-content__sm">
				<div class="tab-pane fade show active" tabindex="0">
					<div class="tab-content__step2">
						<div class="col-tabstep2">
							<section class="smart-mediacare-inter__table step3" id="Sec-1">

								<!-- data polis holder -->
								<div class="panel-cover pt-10level px-10level container-form policy_holder mobile-view">

									<h1 style="text-align: left;">Data Pemegang Polis</h1>

									<div class="ispep">
										<span> Apakah pemegang polis
											termasuk ke dalam kategori Orang yang <span
											class="agency__text-axa-sienna-400"> Populer secara
												politisi / <span class="agency__italic">Politically
													Exposed Persons </span> (PEP)
										</span> ?
										</span> <a class="btn--white__step3  ml-2level agency__pointer" href="javascript:;" onclick="openModal()"> <span>
												Baca Selengkapnya <i class="fas fa-arrow-right"></i>
										</span>
										</a>

										<div class="radio-group ispep-container">

											<div>
												<div
													class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
													<input id="no" class="radio-custom ispepInputNo"
														name="input_ispep_polisholder" type="radio" value="0" required="required"> <label for="no"
														class="radio-custom-label mb-0"><span>Tidak</span></label>
												</div>
											</div>
											<div>
												<div
													class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
													<input id="yes" class="radio-custom ispepInputYes"
														name="input_ispep_polisholder" type="radio" value="1" required="required">
													<label for="yes" class="radio-custom-label mb-0"><span>Iya
															<span class="ispepYes">(Data Anda akan kami tinjau
																untuk melewati persetujuan dari Underwriting)</span>
													</span></label>
												</div>
											</div>
										</div>
									</div>


									<div
										class="form-column display-flex agency__flex-wrap gap-4level">
										<form class="display-flex agency__flex-wrap gap-4level">

											<!-- Kolom Kiri -->
											<div class="agency__flex-1 agency__min-w-300px">

												<!-- Negara -->
												<div>
													<label for="negara">Kewarganegaraan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative negara-container">
														<select class="input-control-axa negara" name="input_negara_polisholder" required>
														</select>
													</div>
												</div>


												<!-- foto ktp -->
												<div class="upload-container">
													<label for="name"> Upload File (Paspor/KTP/KITAS)</label>
													<div class="thumbnail-wrapper">
														<img class="thumbnail img-thumbnail img-fluid " src="/o/mypage-theme/images/ktp-image.png" alt="foto ktp">
															
															<!-- Icon Loading -->
														    <div class="loading-icon">
														        Memindai OCR  <i class="fas fa-spinner fa-spin"></i>
														    </div>

														<div class="ml-5level mt-2level agency__pointer">
															<span class="file-name agency__text-xs"></span>
															<a style="text-align: center; width: 100px; font-size: 12px;" class="uploadButton btn btn__agency btn--dark-blue width-full">
													            <span class="position-relative agency__uppercase agency__pointer">Pilih File </span>
													        </a>
														</div>
														<input type="file" class="fileInput input_fotoktp_polisholder display-hidden docupload" accept="image/*" name="input_fotoktp_polisholder">
														<input type="hidden" name="img_polisholder" class="imgupload"/>
													</div>
												</div>


												<!-- NAMA -->
												<div>
													<label for="name"> Nama lengkap sesuai Paspor/KTP/KITAS
														<span class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputName"
															placeholder="Tulis Nama" name="input_name_polisholder" tabindex="1"
															type="text" required="required"
															oninput="handleInputHurufDanSpasi(event)">
													</div>
												</div>

												<!-- PASSPORT -->
												<div>
													<label for="ktppasspor"> Nomor Paspor <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input id="ktppasspor" class="input-control-axa classInputPaspor passport-field" placeholder="Tulis Nomor Paspor" name="input_ktppaspor_polisholder" type="text" tabindex="3" maxlength="10" required="required">
													</div>
												</div>

												<!-- dob -->
												<div>
													<label class="display-block" for="dateofbirth">Tanggal
														Lahir <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="calendar-wrapper position-relative"
														id="calendar-wrapper-claim">
														<div class="calendar-col position-relative dob-wrapper">
															<input style="color: #00008f;"
																class="input-control-axa input-control-axa--outline input-icon-date dob dob-adult"
																type="text" name="input_dob_polisholder" tabindex="5"
																autocomplete="off" placeholder="Pilih Tanggal Lahir"
																readonly="readonly" required="required">
														</div>
													</div>
												</div>

												<!-- place -->
												<!-- move to right column below age -->
												<!-- <div class="place">
													<label for="place"> Tempat Lahir <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputPlaceOfBirth"
															placeholder="Tulis Tempat Lahir"
															name="input_pdob_polisholder" type="text"
															required="required">
													</div>
												</div> -->

												<!-- gender -->
												<div>
													<label for="gender">Jenis Kelamin <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>

													<div class="form-radio-wrapper display-flex">
														<div class="display-flex gender-container">
															<div class="form-radio mr-8px">
																<input class="classInputGenderMale" type="radio"
																	name="input_gender_polisholder" tabindex="6" value="M"
																	required="required">
																<div class="box-radio-wrapper agency__text-center">
																	<div class="box-radio">
																		<img src="/o/mypage-theme/images/man-nb.png"
																			alt="laki">
																	</div>
																	<div class="box-text">Laki-Laki</div>
																</div>
															</div>
															<div class="form-radio">
																<div class="form-radio-input">
																	<input type="radio" name="input_gender_polisholder"
																		value="F" class="form-control classInputGenderFemale"
																		required="required">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/woman-nb.png"
																				alt="perempuan">
																		</div>
																		<div class="box-text">Perempuan</div>
																	</div>
																</div>
															</div>
														</div>

													</div>
												</div>
												

												<!-- Kode negara dan telepon -->
												<div class="kodenegara_container">
													<label for="kode">Kode Negara dan Telepon </label>
													<!-- <div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa kode"
															name="input_kodenegara_polisholder">

															Options will be dynamically added by JavaScript

														</select>
														
														
													</div> -->
													
													<div class="input-group-axa input-group-axa--border">
														<input style="border: none;" class="input-control-axa ignoreValid"
															placeholder="Tulis Kode Negara"
															name="input_kodenegara_polisholder" tabindex="8" type="text" maxlength="5"
															oninput="handleInput(event)">
													</div>
													
												</div>

												<!-- hp -->
												<div>
													<label for="hp"> Nomor Handphone <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Nomor Handphone"
															name="input_hp_polisholder" tabindex="10" type="text" maxlength="15"
															required="required" oninput="handleInput(event)">
													</div>
												</div>

												<!-- provinsi -->
												<!-- <div>
													<label for="provinsi">Provinsi <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa provinsi" name="provinsi"
															required>
															<option></option>
															<option value="Lorem Ipsum">provinsi lorem1</option>
															<option value="Lorem Ipsum 2">provinsi lorem2</option>
														</select>
													</div>
												</div> -->

												<!-- job -->
												<!-- <div>
													<label for="job">Pekerjaan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative job-container">
														<select class="input-control-axa job"
															name="input_job_polisholder" tabindex="12" required>
															<option></option>
															<option value="Pelajar/Mahasiswa">
																Pelajar/Mahasiswa</option>
															<option value="Karyawan Swasta">Karyawan Swasta</option>
															<option value="TNI/POLRI">TNI/POLRI</option>
															<option value="PNS">PNS</option>
															<option value="Ibu Rumah Tangga">Ibu Rumah
																Tangga</option>
															<option value="Wiraswasta">Wiraswasta</option>
															<option value="Lainnya">Lainnya</option>

														</select>
													</div>
												</div>
												
												<div class="other-job-wrapper" style="display: none;">
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa otherjob"
															placeholder="Tulis Pekerjaan"
															name="input_otherjob_polisholder" tabindex="12" type="text">
													</div>
												</div> -->
												
												<div class="job-container-wrapper">
												    <label for="job">Pekerjaan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span></label>
												    <div id="single-journey-wrapper" class="position-relative job-container">
												        <select class="input-control-axa job" name="input_job_polisholder" tabindex="12" required>
												            <option></option>
												            <option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option>
												            <option value="Karyawan Swasta">Karyawan Swasta</option>
												            <option value="TNI/POLRI">TNI/POLRI</option>
												            <option value="PNS">PNS</option>
												            <option value="Ibu Rumah Tangga">Ibu Rumah Tangga</option>
												            <option value="Wiraswasta">Wiraswasta</option>
												            <option value="Lainnya">Lainnya</option>
												        </select>
												    </div>
												    <div class="other-job-wrapper agency__hidden" style="margin-top: 20px">
												        <div class="input-group-axa input-group-axa--border">
												            <input class="input-control-axa otherjob" placeholder="Tulis Pekerjaan" name="input_otherjob_polisholder" tabindex="12" type="text">
												        </div>
												    </div>
												</div>
												

											</div>

											<!-- Kolom Kanan -->
											<div class="agency__flex-1 agency__min-w-300px">

												<!-- Negara -->
												<!-- move to top left column -->
												<!-- <div class="passpordiv">
													<label for="negara">Kewarganegaraan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative negara-container">
														<select class="input-control-axa negara"
															name="input_negara_polisholder" required>

															Options will be dynamically added by JavaScript
														</select>
													</div>
												</div> -->

												<!-- KTP KITAS -->
												<div class="mt-desktop-only__mt-321px" >
													<label for="ktppaspor"> Nomor KTP / KITAS <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputKtpKitas"
															placeholder="Tulis No. KTP / KITAS"
															name="input_ktpkitas_polisholder" tabindex="2" type="text"
															minlength="16" maxlength="16" required="required"
															oninput="handleInput(event)">
													</div>
												</div>

												<!-- place -->
												<div class="place">
													<label for="place"> Tempat Lahir <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputPlaceOfBirth"
															placeholder="Tulis Tempat Lahir"
															name="input_pdob_polisholder" tabindex="4" type="text"
															required="required" oninput="handleInputHurufDanSpasi(event)">
													</div>
												</div>

												<!-- age -->
												<div>
													<label for="age"> Usia </label>
													<div
														class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome">
														<input disabled="disabled" class="input-control-axa age"
															placeholder="0" name="input_age_polisholder" type="text" readonly="readonly">
														<span class="font_tahun">Tahun</span>
													</div>
												</div>


												<!-- status kawin -->
												<div>
													<!--no need 150 px top.  before <div class="mt-150px"> -->
													<label for="status-kawin">Status Perkawinan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative status-kawin-container">
														<select class="input-control-axa status-kawin"
															name="input_status-kawin_polisholder" tabindex="7" required>
															<option></option>
															<option value="Belum Menikah">Belum Menikah</option>
															<option value="Sudah Menikah">Sudah Menikah</option>
														</select>
													</div>
												</div>

												<!-- telepon -->
												<div class="telepondiv">
													<div class="input-group-axa input-group-axa--border">
														<input style="border: none;" class="input-control-axa"
															placeholder="Tulis Nomor Telepon"
															name="input_telepon_polisholder" tabindex="9" type="text" maxlength="15" oninput="handleInput(event)">
													</div>
												</div>

												<!-- email -->
												<div class="emaildiv">
													<label for="email">Email <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa email" tabindex="11" placeholder="Tulis email"
															name="input_email_polisholder" type="email"
															required="required">
													</div>
												</div>

												<!-- kode pos -->
												<div>
													<label for="kodepos">Kode Pos <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Kode Pos"
															name="input_kodepos_polisholder" tabindex="13" type="text"
															required="required" maxlength="5" oninput="handleInput(event)">
													</div>
												</div>

												<!-- kab -->
												<!-- <div>
													<label for="kabupaten">Kabupaten/Kota <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa kabupaten"
															name="kabupaten" required>
															<option></option>
															<option value="Lorem Ipsum">kabupaten lorem1</option>
															<option value="Lorem Ipsum 2">kabupaten lorem2</option>
														</select>
													</div>
												</div> -->


											</div>

											<!-- alamat -->
											<div class="alamatdiv">
												<label for="alamat">Alamat Lengkap <span
													class="agency__text-axa-sienna-400 agency__text-xs">*</span>
												</label>
												<div class="input-group-axa input-group-axa--border">
													<input class="input-control-axa classInputAddress"
														placeholder="Tulis Alamat Lengkap"
														name="input_alamat_polisholder" tabindex="14" required="required" maxlength="254" oninput="handleInputHurufAngkaDanKarakterAlamat(event)" ></input>
												</div>
											</div>
										</form>
									</div>
								</div>

								<!-- //HERE INSURED FORM LOOP-->
								<div id="container-generate-insured"></div>


							</section>
						</div>
						
						
						<!-- SIDEPANEL -->
						<!-- <div class="col-tabstep2">
								<div class="panel-cover py-5level">
									<h3>Perjalanan International</h3>
									<h1 class="my-3level" id="PlanSummary-PlanName">-</h1>
									<h4>Proteksi Anda</h4>
									<div class="px-10level">
										<div class="flex-justify-between mb-1level">
											<span id="PlanSummary-TotalDays">0 Hari</span> <span></span>
											<span class="text_nondiscount agency__w-1per3"
												id="PlanSummary-SubTotalPremiPrice">-</span>
										</div>
										<div class="flex-justify-between mb-1level">
											<span>Biaya Polis</span> <span></span> <span
												class="text_nondiscount agency__w-1per3"
												id="PlanSummary-PolicyCost">-</span>
										</div>
										<div class="flex-justify-between mb-1level">
											<span>Materai</span> <span></span> <span
												class="text_nondiscount agency__w-1per3"
												id="PlanSummary-Stamp">-</span>
										</div>
									</div>

								</div>
								<div class="panel-cover py-3level">
									<div class="sticky-collapse-promo">
										<div class="sticky-collapse-promo-step2">
											<div class="col">
												<label for="kode-promo">Kode Promo</label>
												<div
													class="input-group-axa input-group-axa--border input-group-step2">
													<input class="input-control-axa promo-code"
														placeholder="Isi Kode Promo" type="text" maxlength="13"
														id="promo_code">
													<button type="button" class="btnClear">
														<svg xmlns="http://www.w3.org/2000/svg" width="20"
															height="20" viewBox="0 0 24 24" fill="none">
                                                            <path
																d="M3.17766 14.9999C4.43741 18.8326 8.04535 21.5999 12.2996 21.5999C17.6015 21.5999 21.8996 17.3018 21.8996 11.9999C21.8996 6.69797 17.6015 2.3999 12.2996 2.3999C8.74625 2.3999 5.6438 4.33046 3.98392 7.1999M6.89961 8.3999H2.09961V3.5999"
																stroke-width="2" stroke-linecap="round"
																stroke-linejoin="round" />
                                                        </svg>
													</button>
												</div>
											</div>
										</div>
									</div>

									<div class="mt-5level">
										<table class="table table-discount">
											<tbody>
												<tr>
													<td>Diskon</td>
													<td class="agency__text-axa-ocean-100 cost-total-premiclamp">-</td>
												</tr>
												<tr class="gohide">
													<td>Total Premi</td>
													<td class="total-premi pl-85px">USD 4.233</td>
												</tr>
												<tr>
													<td>Total Premi</td>
													<td class="cost-total-premi2 cost-total-premiclamp"
														id="PlanSummary-TotalPremiPrice">-</td>
												</tr>
												<tr class="gohide">
													<td></td>
													<td class="agency__text-axa-ocean-100 pl-85px">-</td>
												</tr>
											</tbody>
										</table>
									</div>
									
									<div class="sidebar-nav">
									    <a class="btn btn__submit btn--dark-blue width-full" href="javascript:void(0)" id="next-step-btn-a">
									        <span class="position-relative text-transform-uppercase">
									            <span id="btn-text">Lanjut Ke Persetujuan <i class="fas fa-arrow-right"></i></span>
									            
									        </span>
									    </a>
									</div>

								</div>
							</div> -->
						
						
							<div class="col-tabstep2">
								<%@ include file="/includes/sidebar.jsp" %>
							</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<!-- sticky plan -->
<%@include file="/includes/sticky.jsp"%>
<!-- end sticky plan -->

<div class="banner-bottom">
	<div class="banner-bottom__inner">
		<div class="col align-self-center">
			<div class="col--inner">
				<h1>
					Klaim mudah <br />dengan AXA MyInsurance
				</h1>
				<a class="btn btn__agency btn--white" href="<%=myInsuranceLink%>" target="_blank"> <span
					class="position-relative order-10">lihat sekarang</span>
				</a>
			</div>
		</div>
		<div class="col">
			<img src="/o/mypage-theme/images/banner_teman_emma.jpg" alt="">
		</div>
	</div>
</div>
    

<!-- footer -->
<%@ include file="/includes/footer.jsp"%>


<!-- Modal KIRIM PENAWARAN Popup -->
<!-- <div id="modal" class="modal_penawaran-modal"> -->
<!--     <div class="modal_penawaran-modal-content"> -->
<!--         <span id="closeModalBtn" class="modal_penawaran-close-btn">&times;</span> -->
<!--         <h2 class="modal_penawaran-text_header">KIRIM PENAWARAN</h2> -->
<!--         <form id="userForm" style="margin-top: 20px"> -->
<!--             <div class="modal_penawaran-form-group"> -->
<!--                 <label for="name" class="mb-4level">Nama Lengkap: <span class="modal_penawaran-agency__text-red-500">*</span></label> -->
<!--                 <input type="text" id="name_modal" name="name_modal" required readonly="readonly"> -->
<!--             </div> -->
<!--             <div class="modal_penawaran-form-group mt-8level"> -->
<!--                 <label for="email" class="modal_penawaran-mb-4level">Email: <span class="modal_penawaran-agency__text-red-500">*</span></label> -->
<!--                 <input type="email" id="email_modal" name="email_modal" required readonly="readonly"> -->
<!--             </div> -->
<!--             <div class="modal_penawaran-items-center"> -->
<!--                 <button type="button" class="modal_penawaran-submit-btn btn__penawaran"> -->
<!--                     <span class="modal_penawaran-agency__text-amber-300"> KIRIM </span>  -->
<!--                     <i class="fas fa-arrow-right ml-2level"></i> -->
<!--                 </button> -->
<!--             </div> -->
<!--         </form> -->
<!--     </div> -->
<!-- </div> -->

<div class="modal modal-axa-smarttravel fade" id="quotation-modal" tabindex="-1" aria-labelledby="" aria-hidden="true" style="display: none">
  <div class="modal-dialog modal-axa-smarttravel-dialog modal-lg">
    <div class="modal_penawaran-modal-content">
      <span id="send_quotation_btn_close" class="modal_penawaran-close-btn">&times;</span>
      <h2 class="modal_penawaran-text_header">KIRIM PENAWARAN</h2>
      <form id="send_quotation_form" style="margin-top: 20px">
        <div class="modal_penawaran-form-group">
          <label for="name" class="mb-4level">Nama Lengkap: <span class="modal_penawaran-agency__text-red-500">*</span></label>
          <input type="text" id="name_modal" name="send_quotation_name" required />
        </div>
        <div class="modal_penawaran-form-group mt-8level">
          <label for="email" class="modal_penawaran-mb-4level">Email: <span class="modal_penawaran-agency__text-red-500">*</span></label>
          <input type="email" id="email_modal" name="send_quotation_email" required />
        </div>
        <div class="modal_penawaran-items-center">
          <button type="submit" id="send_quotation_btn" class="modal_penawaran-submit-btn btn__penawaran">
            <span class="modal_penawaran-agency__text-amber-300"> KIRIM </span> <i class="fas fa-arrow-right ml-2level"></i>
          </button>
        </div>
      </form>
    </div>
  </div>
</div>


<!-- Modal BACA KETERANGAN IS PEP-->
    <div id="modal_baca" class="modal_baca agency__hidden">
        <div class="modal_baca-content">
            <!-- Tombol Tutup -->
            <button onclick="closeModal()" class="modal_baca-close-button">&times;</button>

            <!-- Bagian Title -->
            <div class="modal_baca-title">
                <h2>Politically Exposed Person (PEP)</h2>
            </div>

            <!-- Garis Pemisah -->
            <hr class="modal_baca-divider">

            <!-- Bagian Content -->
            <div class="modal_baca-body">
                <p>Politically Exposed Person (PEP) berdasarkan POJK No 12 Tahun 2017 tentang Penerapan Program Anti
                    Pencucian Uang dan Pencegahan Pendanaan Terorisme Sektor Jasa Keuangan.</p>

                <p>Orang yang Populer Secara Politis (Politically Exposed Person) yang selanjutnya disingkat PEP
                    meliputi:</p>

                <ul class="modal_baca-list">
                    <li class="modal_baca-list-item"><strong>PEP Asing</strong> yaitu orang yang diberi kewenangan untuk
                        melakukan fungsi penting
                        (prominent function) oleh negara lain (asing), seperti kepala negara atau pemerintahan, politisi
                        senior, pejabat pemerintah senior, pejabat militer atau pejabat di bidang penegakan hukum,
                        eksekutif senior pada perusahaan yang dimiliki oleh negara, pejabat penting dalam partai
                        politik.</li>

                    <li class="modal_baca-list-item"><strong>PEP Domestik</strong> yaitu orang yang diberi kewenangan
                        untuk melakukan fungsi penting
                        (prominent function) oleh negara, seperti kepala negara atau pemerintahan, politisi senior,
                        pejabat pemerintah senior, pejabat militer atau pejabat di bidang penegakan hukum, eksekutif
                        senior pada perusahaan yang dimiliki oleh negara, pejabat penting dalam partai politik.</li>

                    <li class="modal_baca-list-item"><strong>PEP Internasional</strong>, yaitu orang yang diberi
                        kewenangan untuk melakukan fungsi
                        penting (prominent function) oleh organisasi internasional, seperti senior manajer yang meliputi
                        antara lain direktur, deputi direktur, dan anggota dewan atau fungsi yang setara.</li>

                    <li class="modal_baca-list-item"><strong>Anggota keluarga dan/atau afiliasi (close
                            associates)</strong> dari PEP.</li>
                </ul>

                <br />

                <p><strong>Ketentuan khusus tentang anggota keluarga dan/atau afiliasi (close associates) dari
                        PEP:</strong></p>

                <p>Anggota keluarga dari PEP adalah anggota keluarga PEP sampai dengan derajat kedua, baik horisontal
                    maupun vertikal, yaitu:</p>

                <ul class="modal_baca-list">
                    <li class="modal_baca-list-item">Orang tua kandung/tiri/angkat;</li>
                    <li class="modal_baca-list-item">Saudara kandung/tiri/angkat;</li>
                    <li class="modal_baca-list-item">Anak kandung/tiri/angkat;</li>
                    <li class="modal_baca-list-item">Kakek atau Nenek kandung/tiri/angkat;</li>
                    <li class="modal_baca-list-item">Cucu kandung/tiri/angkat;</li>
                    <li class="modal_baca-list-item">Saudara kandung/tiri/angkat dari Orang tua;</li>
                    <li class="modal_baca-list-item">Suami atau Istri;</li>
                    <li class="modal_baca-list-item">Mertua atau Besan;</li>
                    <li class="modal_baca-list-item">Suami atau Istri dari Anak kandung/tiri/angkat;</li>
                    <li class="modal_baca-list-item">Kakek atau Nenek dari Suami atau Istri;</li>
                    <li class="modal_baca-list-item">Suami atau Istri dari Cucu kandung/tiri/angkat;</li>
                    <li class="modal_baca-list-item">Saudara kandung/tiri/angkat dari Suami atau Istri;</li>
                    <li class="modal_baca-list-item">Beserta Suami atau Istrinya dari Saudara yang bersangkutan.</li>
                </ul>

                <br />

                <p><strong>Pihak yang terkait dengan PEP antara lain:</strong></p>

                <ul class="modal_baca-list">
                    <li class="modal_baca-list-item">Perusahaan yang dimiliki atau dikelola oleh PEP; atau</li>
                    <li class="modal_baca-list-item">Pihak-pihak yang secara umum dan diketahui publik mempunyai
                        hubungan dekat dengan PEP. Contoh
                        supir, asisten pribadi, sekretaris pribadi.</li>
                </ul>
            </div>
        </div>
    </div>
    
    
<!-- MODAL ALERT BLOCKED -->
    <div id="modal_alert" class="modal_alert agency__hidden">
        <div class="modal_alert-content">
            <!-- Tombol Tutup -->
            <!-- <button onclick="closeModalAlertBlocked()" class="modal_alert-close-button">&times;</button> -->

            <!-- Bagian Title -->
            <div class="modal_alert-title">
                <h2>Perhatian</h2>
            </div>

            <!-- Garis Pemisah -->
            <hr class="modal_alert-divider">
			
            <!-- Bagian Content -->
            <div class="modal_alert-body">
			
				<!-- content message akan di update disini -->
			
            </div>
            
            <div class="ispep_modal__inner-footer" style="text-align: center; margin-top: 40px;">
                <button onclick="closeModalAlertBlocked()" class="ispep_modal__inner-footer-btn">
                    <i class="fas fa-check"></i> OK
                </button>
            </div>
        </div>
    </div>    
    
    
<!-- MODAL IS PEP -->    
<div class="ispep_modal" id="ispepModal">
        <!-- Modal Inner -->
        <div class="ispep_modal__inner">
            <!-- Modal Header -->
            <div class="ispep_modal__inner-header" style="font-size: 30px;">
                <span class="ispep_modal__inner-header-inner">
                    <i class="text-4xl fas fa-exclamation-triangle"></i>
                </span>
            </div>

            <!-- Modal Content -->
            <div class="ispep_modal__inner-content">
                <!-- <h1 class="ispep_modal__inner-content-h1">Informasi</h1> -->
                <div class="ispep_modal__inner-content-h1" style="font-family:Publico ; font-size: 24px; color: rgb(18 56 116);">Informasi</div>
                <p class="ispep_modal__inner-content-p content-message-popup-ispep">
                    <!-- message dinamis here -->
                </p>
            </div>

            <!-- Modal Footer -->
            <div class="ispep_modal__inner-footer">
                <button onclick="closeModalIspep()" class="ispep_modal__inner-footer-btn btn__ok__ispep">
                    <i class="fas fa-check"></i> OK
                </button>
            </div>
        </div>
    </div>

<script src="<%=request.getContextPath()%>/js/step3.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>