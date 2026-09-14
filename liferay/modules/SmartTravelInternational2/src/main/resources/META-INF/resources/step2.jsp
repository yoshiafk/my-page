<%@ include file="init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
LocalDateTime timestampForJSURI = LocalDateTime.now();
DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>
<% String myInsuranceLink = (String)renderRequest.getAttribute("myInsuranceLink"); %>

<% ProductConfiguration _product = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"); %>
<% String managedBy = (String)renderRequest.getAttribute("managedBy"); %>
<% String managedById = (String)renderRequest.getAttribute("managedById"); %>
<% String businessModel = (String)renderRequest.getAttribute("businessModel"); %>
<% boolean continueQuotation = (boolean)renderRequest.getAttribute("continueQuotation"); %>
<% long lId = Long.valueOf((long)renderRequest.getAttribute("lId")); %>
<% String quouteId = (String)renderRequest.getAttribute("quouteId"); %>
<% String promoCode = (String)renderRequest.getAttribute("pc"); %>
<% String tokenLimiter = (String)renderRequest.getAttribute("tokenLimiter"); %>
<% int repeatOrder = Integer.valueOf((int)renderRequest.getAttribute("repeatOrder")); %>
<% int fromContinue = Integer.valueOf((int)ParamUtil.getInteger(renderRequest, "fromContinue")); %>

<% String agentName = Validator.isNotNull((String) renderRequest.getAttribute("agentName")) ? (String) renderRequest.getAttribute("agentName") : ""; %>
<% String agentRole = (String) renderRequest.getAttribute("agentRole"); %>
<% String agentCode = Validator.isNotNull((String) renderRequest.getAttribute("agentCode")) ? (String) renderRequest.getAttribute("agentCode") : ""; %>

<% String prevToken = (String)renderRequest.getAttribute("pvt"); %>
<% 
	String aParam = (String) renderRequest.getAttribute("a");
	String rcParam = (String) renderRequest.getAttribute("rc");
	String bParam = (String) renderRequest.getAttribute("b");
%>

<% String sanctionCountry = (String)renderRequest.getAttribute("sanctionCountry"); %>
<% String utmSource = (String) renderRequest.getAttribute("utm_source"); %>

<%
	Leads _leads = null;
	DetailInternationalTravel _detailInternationalTravel = null;
%>

<%
	if(continueQuotation) {
		if(lId > 0) {
			_leads = LeadsLocalServiceUtil.getLeads(lId);
			if(_leads != null) {
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

<%
	List<BenefitType> _allBenefitTypes = BenefitTypeLocalServiceUtil.getAllBenefitTypes();
%>

<portlet:renderURL var="stepBase3URL">
	<portlet:param name="mvcPath" value="/step3.jsp"></portlet:param>
</portlet:renderURL>

<%
	String step3URL = stepBase3URL;
	if (Validator.isNotNull(aParam)) step3URL = step3URL + "&a=" + aParam;
	if (Validator.isNotNull(rcParam)) step3URL = step3URL + "&rc=" + rcParam;
	if (Validator.isNotNull(bParam)) step3URL = step3URL + "&b=" + bParam;
	if (Validator.isNotNull(prevToken)) step3URL = step3URL + "&pvt=" + prevToken;
%>

<% String _portalURL = themeDisplay.getPortalURL(); %>

<%
	String portalURL = PortalUtil.getPortalURL(request);
	String restApiUrl = portalURL + "/o/api/sti/step2"; //  /o access from osgi, /api/sti/step2 is path api

	List<BenefitType> type = BenefitTypeLocalServiceUtil.getBenefitTypeAdditional();
	List<BenefitType> typeMain = BenefitTypeLocalServiceUtil.getBenefitTypeMain();

	String plan = (String) request.getAttribute("plan");
	String benefitChosen = (String) renderRequest.getAttribute("benefit-chosen");

	// Pecah string menjadi array dengan separator ","
	// Convert array of Strings to a List of Longs
	String[] chosenBenefitIds = null;
	List<Long> chosenBenefits = new ArrayList<>();

	if (benefitChosen != null) {
		chosenBenefitIds = benefitChosen.split(",");

		for (String id : chosenBenefitIds) {
			chosenBenefits.add(Long.valueOf(id));
		}
	}
%>

<script src="<%=request.getContextPath()%>/js/main.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/util.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>


<script type="text/javascript">
var fromContinuejsp = "<%=fromContinue%>";
var fromPrev = <% if (!prevToken.isEmpty()) { %>true<% } else { %>false<% } %>;

// jika step2 diakses bukan dari continue.jsp, maka baca param fromContinue dari renderportlet
// kalau nilainya 1 (benar) maka set ro di sessionstorage ke false
// supaya fungsi clear sessionstorage tidak terpanggil di halaman ini
// karena session storage sudah diset sebelumnya di continue.jsp
if(fromContinuejsp === "0") {
	updateSess(_smartTravelInternationalFormDetailSess, "ro", false);	
}
</script>

<script type="text/javascript">
let _sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
</script>


<script type="text/javascript">
var ro = false; // indikator beli kembali, jika true maka halaman ini diakses via beli kembali
if(_sessData) {
	if(typeof _sessData.ro !== "undefined") {
		ro = _sessData.ro;
	}
}
</script>

<script type="text/javascript">
var utm_source = '<%=utmSource%>';
var checkAdditionalBenefit = false; 
</script>

<% if(continueQuotation) { %>
<script type="text/javascript">
sessionStorage.clear();
</script>
<% } else { %>

<script type="text/javascript">
// Jika bukan beli kembali
if(!ro) {
	// Flow normal - diakses langsung oleh agent
	// tidak ada data sess sebelumnya
	
	checkAdditionalBenefit = true;
	let pc = '<%=promoCode%>';
	
	if (fromPrev == false) {
		if(!_sessData) {
			sessionStorage.clear();
			if(pc !== "") {
				sessionStorage.setItem("pc", pc);
				 $('input[name="PromoCode"]').val(pc);
				 updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
			}
		} else {
			if(typeof _sessData.FromStep1 === 'undefined') {
				sessionStorage.clear();
				if(pc !== "") {
					sessionStorage.setItem("pc", pc);
					 $('input[name="PromoCode"]').val(pc);
					 updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
				}
				
			} else if(!_sessData.FromStep1) {
				sessionStorage.clear();
				if(pc !== "") {
					sessionStorage.setItem("pc", pc);
					 $('input[name="PromoCode"]').val(pc);
					 updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
				}
			}
		}
	} else {
		if(pc !== "") {
			sessionStorage.setItem("pc", pc);
			 $('input[name="PromoCode"]').val(pc);
			 updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
		}
	}
}
</script>

<% } %>

<script type="text/javascript">
if(!ro) {
var managedBy = '<%=managedBy%>';
var managedById = '<%=managedById%>';
var tl = '<%=tokenLimiter%>';
	if(managedBy) {
		updateSess(_smartTravelInternationalFormDetailSess, "ManagedBy", managedBy);
		updateSess(_smartTravelInternationalFormDetailSess, "ManagedById", managedById);
		updateSess(_smartTravelInternationalFormDetailSess, "Tlmtr", tl);
	} else {
		updateSess(_smartTravelInternationalFormDetailSess, "ManagedBy", "");
		updateSess(_smartTravelInternationalFormDetailSess, "ManagedById", "");
		updateSess(_smartTravelInternationalFormDetailSess, "Tlmtr", "");
	}
}

var agentRole = '<%= agentRole %>'.trim();
if (agentRole !== "null" && agentRole !== "") {
    updateSess(_smartTravelInternationalFormDetailSess, "Role", agentRole);
}

var step3URL = '<%=step3URL%>';
var _apiURL = "<%=_portalURL %>";
</script>

<% 
	
	if(_leads != null && _detailInternationalTravel != null) { 
	
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
		String _dDate = formatter.format(_detailInternationalTravel.getDepartureDate());
		String _aDate = formatter.format(_detailInternationalTravel.getArrivalDate());
		
		if(promoCode.isEmpty()) {
			promoCode = _leads.getPromoCode();
		}
	%>
	
	<script type="text/javascript">
	continueQuote = true;
	updateSess(_smartTravelInternationalFormDetailSess, "Name", '<%=_leads.getName()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "Email", '<%=_leads.getEmail()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "ManagedBy", '<%=_leads.getManagedBy()%>');
	
	var managedById = '<%= managedById %>'.trim();
	if (managedById !== "null" && managedById !== "") {
	    updateSess(_smartTravelInternationalFormDetailSess, "ManagedById", managedById);
	}
	
    updateSess(_smartTravelInternationalFormDetailSess, "Role", '<%=_leads.getChannel()%>');
	updateSess(_smartTravelInternationalFormDetailSess, "QuoteId", '<%=quouteId%>');
	updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", '<%=promoCode%>');
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
	updateSess(_smartTravelInternationalFormDetailSess, "FromStep1", true);
	
	let additionalBenefits = '<%=_detailInternationalTravel.getListBenefitId()%>';
	
	if(additionalBenefits === "[]" || additionalBenefits === "") {
		updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", []);
	} else {
		updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", JSON.parse(additionalBenefits));
	}
	
	<% if(!prevToken.isEmpty()) { %>
		updateSess(_smartTravelInternationalFormDetailSess, "Token", '<%=_leads.getToken()%>');
	<%} %>
	</script>
	<%} %>

<script type="text/javascript">
// jika ini bukan beli kembali / repeat order
if(!ro) {
var businessModel = '<%=businessModel%>';
updateSess(_smartTravelInternationalFormDetailSess, "BusinessModel", businessModel);
}

// console.log('check current session');
// console.log(JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess)));
</script>

<script src="<%=request.getContextPath()%>/js/step2.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>
	
	<nav class="navbar-axa-wrapper">
	<div class="navbar-axa">
		<div class="container-axa">
			<div class="navbar-axa__inner">
<!-- 				<div class="btn-responsive-wrapper" id="toggle-menu">
					Mobile menu button
					<button class="display-block">
						<div id="hamburger">
							<span></span> <span></span> <span></span>
						</div>
					</button>
				</div> -->
				<div class="brand-logo-wrapper">
					<a class="brand-logo-link" href="javascript:void(0)"><img class="brand-logo" src="/o/mypage-theme/images/logo_axa_mandiri.png" alt="AXA Insurance Indonesia"></a>
					<div class="cloak"></div>
				</div>
				<div class="nav-axa-wrapper">
				
<!-- 					<div class="nav-axa"> -->
<!-- 						<div class="nav-axa__inner"> -->
<!-- 							<div class="nav-axa__mega-menu"> -->
<!-- 								<span>Asuransi Kami</span> -->
<!-- 								<div class="nav-axa__mega-menu--hover"> -->
<!-- 									<div class="container-axa"> -->
<!-- 										<div class="nav-axa__mega-menu-content"> -->
<!-- 											<div class="col align-self-center border-separate"> -->
<!-- 												<h3>Asuransi Kami</h3> -->
<!-- 												<p>Temukan berbagai jenis asuransi dengan solusi -->
<!-- 													perlindungan sempurna dan manfaat optimal, sesuai dengan -->
<!-- 													kebutuhan Anda dan keluarga.</p> -->
<!-- 											</div> -->
<!-- 											<div class="col"> -->
<!-- 												<div class="col-grid"> -->
<!-- 													<div class="col"> -->
<!-- 														<span>Solusi Kamu</span> -->
<!-- 														<ul> -->
<!-- 															<li><a class="insurance-solutions" href="#" -->
<!-- 																data-id="travel-insurance">Asuransi Perjalanan <i -->
<!-- 																	class="far fa-chevron-right fa-fw"></i></a></li> -->
<!-- 															<li><a class="insurance-solutions" href="#" -->
<!-- 																data-id="vehicle-insurance">Asuransi Kendaraan <i -->
<!-- 																	class="far fa-chevron-right fa-fw"></i></a></li> -->
<!-- 															<li><a class="insurance-solutions" href="#" -->
<!-- 																data-id="health-insurance">Asuransi Kesehatan <i -->
<!-- 																	class="far fa-chevron-right fa-fw"></i></a></li> -->
<!-- 															<li><a class="insurance-solutions" href="#" -->
<!-- 																data-id="other-insurance">Asuransi Lainnya <i -->
<!-- 																	class="far fa-chevron-right fa-fw"></i></a></li> -->
<!-- 														</ul> -->
<!-- 													</div> -->
<!-- 													<div class="col"> -->
<!-- 														<div class="card-mega-menu insurance-solutions-details" -->
<!-- 															id="travel-insurance" style="display: block;"> -->
<!-- 															<span>Asuransi Perjalanan</span> -->
<!-- 															<div class="card-mega-menu-inner"> -->
<!-- 																<div class="col"> -->
<!-- 																	<a href="#"> -->
<!-- 																		<figure> -->
<!-- 																			<img -->
<!-- 																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp" -->
<!-- 																				class="img-product" -->
<!-- 																				alt="Asuransi SmartTravel Domestik"> -->
<!-- 																		</figure> -->
<!-- 																		<figcaption>Asuransi SmartTravel Domestik</figcaption> -->
<!-- 																	</a> -->
<!-- 																</div> -->
<!-- 																<div class="col"> -->
<!-- 																	<a href="#"> -->
<!-- 																		<figure> -->
<!-- 																			<img -->
<!-- 																				src="https://mypage.axa.co.id/Product/Banner - Travel International.webp"> -->
<!-- 																		</figure> -->
<!-- 																		<figcaption>Asuransi SmartTravel -->
<!-- 																			Internasional</figcaption> -->
<!-- 																	</a> -->
<!-- 																</div> -->
<!-- 															</div> -->
<!-- 														</div> -->
<!-- 														<div class="card-mega-menu insurance-solutions-details" -->
<!-- 															id="vehicle-insurance"> -->
<!-- 															<span>Asuransi Kendaraan</span> -->
<!-- 															<div class="card-mega-menu-inner"> -->
<!-- 																<div class="col"> -->
<!-- 																	<a href="#"> -->
<!-- 																		<figure> -->
<!-- 																			<img -->
<!-- 																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp" -->
<!-- 																				class="img-product" -->
<!-- 																				alt="Asuransi SmartTravel Domestik"> -->
<!-- 																		</figure> -->
<!-- 																		<figcaption>Asuransi SmartTravel Domestik</figcaption> -->
<!-- 																	</a> -->
<!-- 																</div> -->
<!-- 																<div class="col"> -->
<!-- 																	<a href="#"> -->
<!-- 																		<figure> -->
<!-- 																			<img -->
<!-- 																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp" -->
<!-- 																				class="img-product" -->
<!-- 																				alt="Asuransi SmartTravel Domestik"> -->
<!-- 																		</figure> -->
<!-- 																		<figcaption>Asuransi SmartTravel Domestik</figcaption> -->
<!-- 																	</a> -->
<!-- 																</div> -->
<!-- 															</div> -->
<!-- 														</div> -->
<!-- 														<div class="card-mega-menu insurance-solutions-details" -->
<!-- 															id="health-insurance"> -->
<!-- 															<span>Asuransi Kesehatan</span> -->
<!-- 															<div class="card-mega-menu-inner"> -->
<!-- 																<div class="col"> -->
<!-- 																	<a href="#"> -->
<!-- 																		<figure> -->
<!-- 																			<img -->
<!-- 																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp" -->
<!-- 																				class="img-product" -->
<!-- 																				alt="Asuransi SmartTravel Domestik"> -->
<!-- 																		</figure> -->
<!-- 																		<figcaption>Asuransi SmartTravel Domestik</figcaption> -->
<!-- 																	</a> -->
<!-- 																</div> -->
<!-- 																<div class="col"> -->
<!-- 																	<a href="#"> -->
<!-- 																		<figure> -->
<!-- 																			<img -->
<!-- 																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp" -->
<!-- 																				class="img-product" -->
<!-- 																				alt="Asuransi SmartTravel Domestik"> -->
<!-- 																		</figure> -->
<!-- 																		<figcaption>Asuransi SmartTravel Domestik</figcaption> -->
<!-- 																	</a> -->
<!-- 																</div> -->
<!-- 															</div> -->
<!-- 														</div> -->
<!-- 														<div class="card-mega-menu insurance-solutions-details" -->
<!-- 															id="other-insurance"> -->
<!-- 															<span>Asuransi Lainnya</span> -->
<!-- 															<div class="card-mega-menu-inner"> -->
<!-- 																<div class="col"> -->
<!-- 																	<a href="#"> -->
<!-- 																		<figure> -->
<!-- 																			<img -->
<!-- 																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp" -->
<!-- 																				class="img-product" -->
<!-- 																				alt="Asuransi SmartTravel Domestik"> -->
<!-- 																		</figure> -->
<!-- 																		<figcaption>Asuransi SmartTravel Domestik</figcaption> -->
<!-- 																	</a> -->
<!-- 																</div> -->
<!-- 																<div class="col"> -->
<!-- 																	<a href="#"> -->
<!-- 																		<figure> -->
<!-- 																			<img -->
<!-- 																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp" -->
<!-- 																				class="img-product" -->
<!-- 																				alt="Asuransi SmartTravel Domestik"> -->
<!-- 																		</figure> -->
<!-- 																		<figcaption>Asuransi SmartTravel Domestik</figcaption> -->
<!-- 																	</a> -->
<!-- 																</div> -->
<!-- 															</div> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<a href="#" class="nav-link-axa align-self-center">Promo & -->
<!-- 								News</a> <a href="#" class="nav-link-axa align-self-center">Kirim -->
<!-- 								Ulang Polis</a> <a href="#" class="nav-link-axa align-self-center">Tentang -->
<!-- 								Axa Insurance</a> <a href="#" class="nav-link-axa align-self-center">Emma -->
<!-- 								By Axa</a> -->
<!-- 						</div> -->
<!-- 					</div> -->
				
				</div>
			</div>
		</div>
	</div>
</nav>

<header class="hero">
	<img src="/o/mypage-theme/images/step2hero.png" alt="herostep2"
		class="width-full height-full">
</header>

<portlet:resourceURL id="/data/dashboard/smart_travel_international"
	var="loadSmartTravelInternationalData" />

<section class="chosee-plan">

	<!-- navbar -->
	<%@ include file="includes/navbar.jsp"%>

	<!-- step bar -->
	<div class="stepper-wrapper">
		<div class="stepper-item active">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Pilih Perlindungan</div>
		</div>
		<div class="stepper-item">
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

	<form id="step2Form">
		<div class="chosee-plan__tabs">
			<div class="container-axa">
				<div class="tab-content__sm">
					<div class="tab-pane fade show active" tabindex="0">
						<div class="tab-content__step2">

							<div class="col-tabstep2">
								<section class="smart-mediacare-inter__table" id="Sec-1">

									<div class="panel-cover mb-10level">
										<section class="simulasi">
											<div class="container-axa">
												<h1>Informasi Perjalanan Anda</h1>
												<div class="simulasi__inner__step2">
													<div class="simulasi__inner--left-step2">
														<div class="mt-4level">
															<label class="display-block" for="pilih-mata-uang">Pilih Jenis Mata Uang <a href="javascript:void(0)" class="tooltip"><i class="fas fa-info-circle"></i> <span class="tooltip-content">Mata Uang Manfaat adalah mata uang yang akan digunakan untuk pembayaran manfaat atau klaim Anda. Biaya premi Anda akan tetap dikenakan dengan mata uang IDR walaupun Anda memilih mata uang lainnya.</span></a></label>
															<div class="grid-radio mb-8level">
																<div>
																	<div
																		class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
																		<input id="idr" class="radio-custom form-item-step2" type="radio" name="Currency" value="idr"> <label for="idr" class="radio-custom-label mb-0level"><span>IDR</span></label>
																	</div>
																</div>
																<div>
																	<div
																		class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
																		<input id="usd" class="radio-custom form-item-step2" type="radio" name="Currency" value="usd"> <label for="usd" class="radio-custom-label mb-0level"><span>USD</span></label>
																	</div>
																</div>
															</div>
														</div>

														<!-- Jenis Penumpang -->
														<div class="mt-4level">
					<label class="display-block" for="pilih-jenis-penumpang">Anda melakukan perjalanan <a href="javascript:void(0)" class="tooltip"><i class="fas fa-info-circle"></i> <span class="tooltip-content">
                		<ul>
                    		<li>Perorangan Maksimal 1 orang</li>
                    		<li>Keluarga Maksimal 7 orang (tertanggung, pasangan, 5 anak)</li>
                    		<li>Duo Maksimal 2 orang (tertanggung dengan kerabat/teman)</li>
                		</ul>
            </span></a></label>
															<div class="form-radio-wrapper">

																<div class="form-radio">
																	<input type="radio" id="individual" name="TravellerType" value="Individual" class="form-control">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/man-nb.png" alt="Individual">
																		</div>
																		<div class="box-text">Sendiri</div>
																	</div>
																</div>

																<div class="form-radio">
																	<input type="radio" id="duo" name="TravellerType" value="Duo" class="form-control">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/duo-nb.png" alt="Duo">
																		</div>
																		<div class="box-text">Duo</div>
																	</div>
																</div>

																<div class="form-radio">
																	<input type="radio" id="family" name="TravellerType" value="Family" class="form-control">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/familiy-nb.png" alt="Family">
																		</div>
																		<div class="box-text">Keluarga</div>
																	</div>
																</div>

															</div>
														</div>

														<!-- Jumlah Tangggunan -->
														<div class="simulasi__inner--right">
															<div class="mt-4level">
																<label class="display-block" for="jumlah-tanggungan">Jumlah Tanggungan</label>
																<div class="input-grid w-400px">
																	<div class="input-group-axa input-group-axa--border adult-total">
																		<div id="select-adult-wrapper" class="select-adult-wrapper">
																			<select class="self-center" name="AdultTotal" id="select-adult">
																			</select>
																		</div>
																	</div>
																	<div class="input-group-axa input-group-axa--border child-total gohide">
																		<div id="select-kid-wrapper">
																			<select class="self-center" name="ChildTotal" id="select-kid">
																				<option value="1">1 Anak</option>
																				<option value="2">2 Anak</option>
																				<option value="3">3 Anak</option>
																				<option value="4">4 Anak</option>
																				<option value="5">5 Anak</option>
																			</select>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<!-- Jenis Perjalanan -->
														<div class="mt-4level w-400px">
															<label class="display-block" for="travel-type-step2">Pilih jenis perjalanan <a href="javascript:void(0)" class="tooltip"><i class="fas fa-info-circle"></i> <span class="tooltip-content">
																<ul>
																	<li><b>Perjalanan tunggal:</b> Lamanya setiap perjalanan berdasarkan "Perjalanan Tunggal" tidak akan melebihi 90 (sembilan puluh) hari kalender sejak tanggal dimulainya Perjalanan.</li>
																	<li><b>Program tahunan:</b> Lamanya setiap perjalanan berdasarkan "Program Tahunan" tidak akan melebihi 90 (sembilan puluh) hari kalender dari tanggal dimulainya Perjalanan.</li>
																</ul>
															</span></a></label>
															<div id="travel-type-wrapper" class="position-relative">
																<select class="input-control-axa form-item-step2 travel-type-step2" name="TravelType" id="travel-type-step2" required>
																	<option value="Single">Perjalanan Tunggal</option>
																	<option value="Annual">Program Tahunan</option>
																</select>
															</div>
														</div>
														
														<!-- Tanggal Perjalanan -->
														<div class="mt-4level w-400px">
															<label class="display-block" for="tgl-perjalanan">Tanggal Perjalanan</label>
															<div class="calendar-wrapper position-relative"
																id="calendar-wrapper-claim">
																<div class="calendar-col position-relative"
																	id="Fromtravel-wrapper">
																	<input class="input-control-axa input-control-axa--outline" type="text" id="Fromtravel" name="from" autocomplete="off" readonly>
																	<input class="form-item-step2" type="hidden" name="DepartureDate"/>
																	<div class="label-text">Dari</div>
																</div>
																<div class="separated-arrow">
																	<i
																		class="fas fa-arrow-right align-self-center text-12px"></i>
																</div>
																<div class="calendar-col position-relative"
																	id="Totravel-wrapper">
																	<input class="input-control-axa input-control-axa--outline input-icon-date" type="text" id="Totravel" name="to" autocomplete="off" readonly>
																	<input class="form-item-step2" type="hidden" name="ArrivalDate"/>
																	<div class="label-text">Ke</div>
																</div>
															</div>
														</div>
														
														<!-- Destination -->
														<div class="mt-4level w-400px">
															<label class="display-block" for="Destination">Destinasi </label>
															<div id="destination-wrapper" class="position-relative">
																<select class="input-control-axa" name="Destination" id="destination">
																	<!-- <option value="Worldwide" selected>Worldwide including Schengen Countries</option> -->
																	
																	 <c:forEach var="entry" items="${destinationMap}" varStatus="status">
																        <option value="${entry.key}" ${status.first ? 'selected' : ''}>${entry.value}</option>
																    </c:forEach>
																	
																</select>
																
															</div>

															    <div class="display-inline-flex align-items-center align-self-center it-purchase_before_departs_container">
															    	<input type="checkbox" id="it-purchase-before-departs-checkbox" class="purchase_before_departs_input" name="it-purchase-before-departs" value="yes" required>
															    	<label for="it-purchase-before-departs-checkbox" class="mb-0 it-purchase-before-departs-label"><span>Dengan ini saya menyatakan bahwa saya membeli polis asuransi sebelum keberangkatan saya dari Indonesia.</span><span class="agency__text-axa-sienna-400 agency__text-xs">*</span></label>
															    </div>
															    
														</div>


														<!-- Plan Option -->
														<div class="mt-4level w-400px">
															<label class="display-block" for="ChoosenPlan">Pilih Plan Polis </label>
															<div id="plan-option-wrapper" class="position-relative">
																<select class="input-control-axa" name="ChoosenPlan" id="plan-option" required>
																</select>
															</div>

														</div>
													</div>
												</div>

												<!-- Main Benefit -->
												<div class="panel-table hide__checkbox__step2 mt-8level">
													<div class="panel-table-header">
														<h4 class="agency__font-bold">Jaminan Utama</h4>
													</div>

													<div class="panel-main-benefit"
														id="main-benefit-list-wrapper"></div>

												</div>

											</div>
										</section>
									</div>

									<div class="content__left panel-cover pt-10level">
										<h1>Jaminan Tambahan (Pilihan)</h1>
										<div id="additional-benefit-wrapper"></div>

	
<!-- 										<div class="panel-table hide__checkbox__step2"> -->

<!-- 											<div class="panel-table-header"> -->
<!-- 												<h4 class="agency__font-bold">judul benefit type (Tambahan)</h4> -->
<!-- 											</div> -->

<!-- 											<div class="panel-table-body"> -->

<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a" name="switch-a" -->
<!-- 															class="parent" /> <label class="label_toggle" -->
<!-- 															for="switch-a">Toggle</label> <span -->
<!-- 															class="agency__font-bold ml-3level">Pilih Semua</span> -->
<!-- 													</div> -->
<!-- 													<span class="toogle__row-span_parent"></span> -->
<!-- 												</div> -->
												
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-435345" name="switch-345345" class="child benefitcheckbox" data-benefit="345345" /> <label class="label_toggle" for="switch-a1">Toggle</label> <span class="toogle__row-span-item">namenamename</span> -->
<!-- 															<span class="penjelasan-link-mobile"> <a href="#">Penjelasan</a></span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">info value</span> -->
<!-- 														<span class="penjelasan-link"> <a href="#">Penjelasan</a></span> -->
<!-- 													</div> -->
<!-- 												</div> -->
													

<!-- 											</div> -->

<!-- 										</div> -->

<!-- 										<div class="panel-table hide__checkbox__step2"> -->

<!-- 											<div class="panel-table-header"> -->
<!-- 												<h4 class="agency__font-bold">Proteksi Ketidaknyamanan -->
<!-- 													Perjalanan (Tambahan)</h4> -->
<!-- 											</div> -->

<!-- 											<div class="panel-table-body"> -->

<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a" name="switch-a" -->
<!-- 															class="parent" /> <label class="label_toggle" -->
<!-- 															for="switch-a">Toggle</label> <span -->
<!-- 															class="agency__font-bold ml-3level">Pilih Semua</span> -->
<!-- 													</div> -->
<!-- 													<span class="toogle__row-span_parent"></span> -->
<!-- 												</div> -->

<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a1" name="switch-a1" -->
<!-- 															class="child benefitcheckbox" data-benefit="56409" /> <label -->
<!-- 															class="label_toggle" for="switch-a1">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">Keterlambatan -->
<!-- 															Perjalanan</span> <span class="penjelasan-link-mobile"> <a -->
<!-- 															href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">IDR 750.000 / 4 hrs up to -->
<!-- 															IDR 6.000.000</span> <span class="penjelasan-link"> <a -->
<!-- 															href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a2" name="switch-a2" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a2">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">Pembatalan -->
<!-- 															Perjalanan</span> <span class="penjelasan-link-mobile"> <a -->
<!-- 															href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">RP 40.000.000</span> <span -->
<!-- 															class="penjelasan-link"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a3" name="switch-a3" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a3">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">Penerbangan Tidak -->
<!-- 															Sinambung</span> <span class="penjelasan-link-mobile"> <a -->
<!-- 															href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">IDR 650.000 / 4 hrs up to -->
<!-- 															IDR 6.500.000</span> <span class="penjelasan-link"> <a -->
<!-- 															href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a4" name="switch-a4" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a4">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">Bagasi dan Barang -->
<!-- 															Milik Pribadi</span> <span class="penjelasan-link-mobile"> -->
<!-- 															<a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">IDR 4.000.000/ITEM/SET, -->
<!-- 															MAX. IDR 30.000.000 (IN AGGREGATE)</span> <span -->
<!-- 															class="penjelasan-link"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a5" name="switch-a5" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a5">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">Keterlambatan Bagasi</span> -->
<!-- 														<span class="penjelasan-link-mobile"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">IDR 1.000.000 / 6 hrs up to -->
<!-- 															IDR 6.000.000</span> <span class="penjelasan-link"> <a -->
<!-- 															href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a6" name="switch-a6" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a6">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">Pembatasan -->
<!-- 															Perjalanan</span> <span class="penjelasan-link-mobile"> <a -->
<!-- 															href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">RP 65.000.000</span> <span -->
<!-- 															class="penjelasan-link"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a7" name="switch-a7" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a7">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">Kehilangan Uang Muka -->
<!-- 															atau Pembatalan</span> <span class="penjelasan-link-mobile"> -->
<!-- 															<a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">RP 18.000.000</span> <span -->
<!-- 															class="penjelasan-link"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a8" name="switch-a8" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a8">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">*Dokumen Perjalanan -->
<!-- 															Tiket karena Pencurian dan Pembobolan</span> <span -->
<!-- 															class="penjelasan-link-mobile"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">RP 15.000.000</span> <span -->
<!-- 															class="penjelasan-link"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a9" name="switch-a9" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a9">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">*Uang : hilang -->
<!-- 															bersama dengan dokumen Perjalanan</span> <span -->
<!-- 															class="penjelasan-link-mobile"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">RP 15.000.000</span> <span -->
<!-- 															class="penjelasan-link"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 												<div class="toogle__row"> -->
<!-- 													Responsive layout -->
<!-- 													<div class="display-flex align-items-center"> -->
<!-- 														<input type="checkbox" id="switch-a10" name="switch-a10" -->
<!-- 															class="child" /> <label class="label_toggle" -->
<!-- 															for="switch-a10">Toggle</label> <span -->
<!-- 															class="toogle__row-span-item">Perlindungan Kartu -->
<!-- 															Kredit</span> <span class="penjelasan-link-mobile"> <a -->
<!-- 															href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di mobile -->
<!-- 													</div> -->
<!-- 													<div class="toogle__row-span_cost"> -->
<!-- 														<span class="cost-text">RP 15.000.000</span> <span -->
<!-- 															class="penjelasan-link"> <a href="#">Penjelasan</a> -->
<!-- 														</span> -->
<!-- 														Penjelasan di desktop -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->


										<!-- end panel group benefit -->
									</div>

<!-- 									<div class="agency__text-center mt-5level"> -->
<!-- 										<a class="btn__agency btn--dark-blue width-full" href="#"> -->
<!-- 											<span class="position-relative">Perbarui Perhitungan <i -->
<!-- 												class="fas fa-arrow-right"></i></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
								</section>
							</div>

							<div class="col-tabstep2 sti-right">
							<%@ include file="/includes/sidebar.jsp" %>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
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
<%@ include file="includes/footer.jsp"%>

<!-- Modal Warning -->
<!-- <div class="modal modal-axa-smarttravel-theme width-full fade" -->
<!-- 	id="modalAlert" tabindex="-1" style="display: none;" -->
<!-- 	aria-labelledby="modalAlertLabel" aria-hidden="true"> -->
<!-- 	<div -->
<!-- 		class="modal-max-w-430px modal-axa-smarttravel-theme-dialog modal-dialog modal-axa-smarttravel-theme-dialog-centered"> -->
<!-- 		<div class="modal-axa-smarttravel-theme-content"> -->
<!-- 			<div -->
<!-- 				class="modal-axa-smarttravel-theme-body agency__text-center p-80px-40px-0px-40px position-relative"> -->
<!-- 				<svg class="w-100px-h-100px m-0-auto-20px-auto" -->
<!-- 					xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" -->
<!-- 					fill="none"> -->
<!-- 						<path -->
<!-- 						d="M50.0017 54.0462V33.8864M50.0017 68.9888V69.166M75.2014 85.956H24.802C17.9177 85.956 12.108 81.3551 10.2802 75.0604C9.49989 72.3733 10.4586 69.5745 11.9251 67.1915L37.1248 21.2417C43.0288 11.6476 56.9746 11.6476 62.8787 21.2418L88.0783 67.1915C89.5448 69.5745 90.5035 72.3733 89.7232 75.0603C87.8954 81.3551 82.0857 85.956 75.2014 85.956Z" -->
<!-- 						stroke="#1F1F9C" stroke-width="8.33333" stroke-linecap="round" -->
<!-- 						stroke-linejoin="round" /> -->
<!-- 					</svg> -->
<!-- 				<h1 -->
<!-- 					class="text-axa-grey-800 font-publico font-bold text-32px mb-15px">Peringatan!</h1> -->
<!-- 				<p class="text-axa-grey-600 mb-20px">Apakah anda yakin -->
<!-- 					membatalkan proses ini?</p> -->
<!-- 			</div> -->
<!-- 			<div -->
<!-- 				class="modal-axa-smarttravel-theme-footer flex-justify-between p-20px-30px mt-12"> -->
<!-- 				<button class="btn-no text-14px agency__uppercase align-self-center" -->
<!-- 					data-bs-toggle="modal" data-bs-target="#ModalCreateReminder" -->
<!-- 					aria-label="Close">Tidak</button> -->
<!-- 				<button type="button" -->
<!-- 					class="btn btn__agency btn--dark-blue btn-close p-12px-25px-10px-25px" -->
<!-- 					type="button" data-bs-dismiss="modal" aria-label="Close" -->
<!-- 					aria-controls="login"> -->
<!-- 					<span class="position-relative order-50"> Iya <svg -->
<!-- 							class="display-inline-block position-relative top-min-1px left-6px" -->
<!-- 							xmlns="http://www.w3.org/2000/svg" width="16" height="16" -->
<!-- 							viewBox="0 0 16 16" fill="none"> -->
<!-- 								<path -->
<!-- 								d="M5.22353 4L11.9059 4.09412M11.9059 4.09412L12 10.7765M11.9059 4.09412L4 12" -->
<!-- 								stroke="white" stroke-width="2" stroke-linecap="round" -->
<!-- 								stroke-linejoin="round" /> -->
<!-- 							</svg> -->
<!-- 					</span> -->
<!-- 				</button> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
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
            <span class="modal_penawaran-agency__text-amber-300"> KIRIM </span>
            <i class="fas fa-arrow-right ml-2level"></i>
          </button>
        </div>
      </form>
    </div>
  </div>
</div>

<div class="modal modal-axa-smarttravel fade" id="benefit-plan-description-modal" tabindex="-1" aria-labelledby="" aria-hidden="true" style="display: none">
  <div class="modal-dialog modal-axa-smarttravel-dialog modal-lg">
    <div class="modal-content modal-axa-smarttravel-content">
      <div class="modal-header modal-axa-smarttravel-header">
        <h1 class="modal-title fs-5" id="">Info Tambahan</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
          <i class="far fa-times fa-fw"></i>
        </button>
      </div>
      <div class="modal-body modal-axa-smarttravel-body modal-axa-smarttravel-body__benefit_description">
        <h3></h3>
        <p></p>
      </div>
    </div>
  </div>
</div>

<div class="modal modal-axa-smarttravel fade" id="travel-delay-checkbox-warning-modal" tabindex="-1" aria-labelledby="" aria-hidden="true" style="display: none">
  <div class="modal-dialog modal-dialog-centered modal-axa-smarttravel-dialog modal-lg">
    <div class="modal-content modal-axa-smarttravel-content">
      <div class="modal-body modal-axa-smarttravel-body modal-axa-smarttravel-body__travel-delay-checkbox-warning-modal">
        <p>Untuk mengaktifkan manfaat ini. Silahkan aktifkan juga manfaat Keterlambatan atau Pembatalan Perjalanan</p>
      </div>
    </div>
  </div>
</div>

<!-- <div class="modal modal-axa-smarttravel fade" id="promocode-modal" tabindex="-1" aria-labelledby="" aria-hidden="true" style="display: none"> -->
<!--   <div class="modal-dialog modal-axa-smarttravel-dialog modal-lg"> -->
<!--     <div class="modal-content modal-axa-smarttravel-content"> -->
<!--           <div class="modal-header modal-axa-smarttravel-header"> -->
<!--         <h1 class="modal-title fs-5" id="">Info Tambahan</h1> -->
<!--         <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"> -->
<!--           <i class="far fa-times fa-fw"></i> -->
<!--         </button> -->
<!--       </div> -->
<!--       <div class="modal-body modal-axa-smarttravel-body"> -->
<!--         <h3>Kode promo berhasil dipakai</h3> -->
<!--         <p></p> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
