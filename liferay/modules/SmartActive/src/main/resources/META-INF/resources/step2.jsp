<%@ include file="/init.jsp" %>

<%
	int pageNum = 2;
%>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>

<%
	String _step = "one";
	List<SmartActiveLink> files = (List<SmartActiveLink>) renderRequest.getAttribute("files");
	List<SmartActiveOccupation> occupations = (List<SmartActiveOccupation>) renderRequest.getAttribute("occupations");
	List<SmartActiveBenefitValue> mainBenefitValue = (List<SmartActiveBenefitValue>) renderRequest.getAttribute("mainBenefitValue");
	String occupationExceptionContent = (String) renderRequest.getAttribute("occupationExceptionContent");
	String aParam = (String) renderRequest.getAttribute("a");
	String rcParam = (String) renderRequest.getAttribute("rc");
	String bParam = (String) renderRequest.getAttribute("b");
	String quoteCategory = Validator.isNotNull((String) renderRequest.getAttribute("qe")) ? (String) renderRequest.getAttribute("qe") : "";
	String promoCode = Validator.isNotNull((String) renderRequest.getAttribute("pc")) ? (String) renderRequest.getAttribute("pc") : "";
	String prettyUrl = Validator.isNotNull((String) renderRequest.getAttribute("pu")) ? (String) renderRequest.getAttribute("pu") : "";
	String agentRole = Validator.isNotNull((String) renderRequest.getAttribute("agentRole")) ? (String) renderRequest.getAttribute("agentRole") : "";
	String agentCode = Validator.isNotNull((String) renderRequest.getAttribute("agentCode")) ? (String) renderRequest.getAttribute("agentCode") : "";
	String agentName = Validator.isNotNull((String) renderRequest.getAttribute("agentName")) ? (String) renderRequest.getAttribute("agentName") : "";
	String agentDeptCode = Validator.isNotNull((String) renderRequest.getAttribute("agentDeptCode")) ? (String) renderRequest.getAttribute("agentDeptCode") : "";
	String mobile = Validator.isNotNull((String) renderRequest.getAttribute("mobile")) ? (String) renderRequest.getAttribute("mobile") : "";
	String lParam = Validator.isNotNull((String) renderRequest.getAttribute("l")) ? (String) renderRequest.getAttribute("l") : "";
	String leadsTemp = Validator.isNotNull((String) renderRequest.getAttribute("qt")) ? (String) renderRequest.getAttribute("qt") : "";
	String csrfToken = Validator.isNotNull((String) renderRequest.getAttribute("CSRF_TOKEN")) ? (String) renderRequest.getAttribute("CSRF_TOKEN") : "";

	String portalURL = themeDisplay.getPortalURL();
%>

<%
	String managedBy = (String) renderRequest.getAttribute("managedBy");
	String managedById = (String) renderRequest.getAttribute("managedById");
	String businessModel = (String) renderRequest.getAttribute("businessModel");
	String utm_source = (String) renderRequest.getAttribute("utm_source");
	String utm_medium = (String) renderRequest.getAttribute("utm_medium");
	String utm_campaign = (String) renderRequest.getAttribute("utm_campaign");
	String utm_term = (String) renderRequest.getAttribute("utm_term");
	String utm_content = (String) renderRequest.getAttribute("utm_content");
%>

<portlet:renderURL var="step3BaseURL">
	<portlet:param name="mvcPath" value="/step3.jsp"></portlet:param>
</portlet:renderURL>

<% 
    String step3URL = step3BaseURL;
    if (Validator.isNotNull(aParam)) step3URL = step3URL + "&a=" + aParam;
    if (Validator.isNotNull(rcParam)) step3URL = step3URL + "&rc=" + rcParam;
    if (Validator.isNotNull(bParam)) step3URL = step3URL + "&b=" + bParam;
    if (Validator.isNotNull(promoCode)) step3URL = step3URL + "&pc=" + promoCode;
    if (Validator.isNotNull(prettyUrl)) step3URL = step3URL + "&pu=" + prettyUrl;
    if (Validator.isNotNull(lParam)) step3URL = step3URL + "&l=" + lParam;
    if (Validator.isNotNull(leadsTemp)) step3URL = step3URL + "&qt=" + leadsTemp;
    if (Validator.isNotNull(quoteCategory)) step3URL = step3URL + "&qe=" + quoteCategory;
    if (Validator.isNotNull(mobile)) step3URL = step3URL + "&mobile=" + mobile;
%>

<portlet:resourceURL id="settransaction" var="setTransactionURL" />

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/navbar.jsp" %>
<% } %>

<header class="hero<% if (Validator.isNotNull(mobile)) { %> hero-mobile<% } %>">
	<img src="/o/mypage-theme/images/banner_step_sa.png" alt="Axa SmartActive" class="width-full height-full">
</header>

<section class="step-one" id="Step-1">
	<input type="hidden" name="csrfToken" value="<%= csrfToken %>" />
	<%@ include file="/includes/stepbar.jsp" %>

	<div class="sa-choose-policy">
		<div class="container-axa">
			<div class="choose-policy-grid">
				<div class="sa-choose-policy__left">
					<div class="panel container-form">
						<div class="panel__heading"><h1>Pilih Plan SmartActive</h1></div>
						<div class="panel__body">
							<div class="policy-smartactive">
								<p>
									Apakah pemegang polis atau tertanggung memiliki pekerjaan atau aktifitas yang dikecualikan untuk pembelian polis SmartActive?
									<a class="position-relative" href="javascript:void(0)" onclick="openModal()">Baca selengkapnya <i class="far fa-arrow-right"></i></a>
								</p>
								<div class="radio-wrapper excluded-activity-status">
									<div class="sa-radio-custom-wrapper">
										<input class="excludedInputNo form-item" type="radio" name="radio-polis" value="0" id="radio-polis-1" required>
										<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-polis-1">
											<span class="radio-cloak"></span>
											<span>Tidak</span>
										</label>
									</div>
								
									<div class="sa-radio-custom-wrapper">
										<input class="excludedInputYes form-item" type="radio" name="radio-polis" value="1" id="radio-polis-2" required>
										<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-polis-2">
											<span class="radio-cloak"></span>
											<span>Iya</span>
										</label>
									</div>
								</div>
							</div>
							
							<div class="sa-type-of-work-datebirth">
								<div id="type-of-work-wrapper">
									<label for="type-of-work" class="sa-label">Jenis Pekerjaan</label>
									<select class="align-self-center job form-item" name="Occupation" id="type-of-work" required>
										<option></option>
										<% if (occupations.size() > 0) { %>
											<% for (SmartActiveOccupation itemOccupation : occupations) { %>
												<option value="<%= itemOccupation.getSmartActiveOccupationId() %>"><%= itemOccupation.getNameId() %></option>
											<% } %>
										<% } %>
									</select>
								</div>
								<div class="col-calendar position-relative" id="choose-plan-birth-wrapper">
									<label for="plan-birth" class="sa-label">Tanggal Lahir</label>
									<div class="sa-input-group-axa input-group-axa--border">
										<input class="input-control-axa input-control-axa--outline sa-fv-outline-none blocked-input-date" name="plan-birth" id="choose-plan-birth" placeholder="Pilih Tanggal Lahir" type="text" required autocomplete="off">
										<input class="form-item" type="hidden" name="Dob"/>
										<span class="align-self-center">
											<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
												<path d="M6.51479 7.61676H17.9434M5.99961 1.38347V3.41698M5.99961 3.41698L17.9996 3.41676M5.99961 3.41698C4.01132 3.41698 2.39969 5.02864 2.39978 7.01693L2.40034 19.0168C2.40043 21.005 4.01218 22.6167 6.00034 22.6167H18.0003C19.9886 22.6167 21.6004 21.0048 21.6003 19.0165L21.5998 7.01659C21.5997 5.02843 19.9878 3.41676 17.9996 3.41676M17.9996 1.38336V3.41676M9.6005 18.4167V11.2167L7.2005 13.0167M16.2005 18.4167V11.2167L13.8005 13.0167" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
											</svg>
										</span>
									</div>
								</div>
							</div>

							<div class="sa-main-benefit-value">
								<div id="benefit-value-wrapper">
									<label for="valueSelect" class="sa-label">Pilih Nilai Manfaat Utama</label>
									<div class="sa-input-group-axa input-group-axa--border">
										<span class="align-self-center">IDR</span>
										
										<div id="valueSelect-wrapper" class="position-relative">
										    <select class="valueSelect form-item" id="valueSelect" name="MainBenefitValue" required>
										        <% if (mainBenefitValue.size() > 0) { %>
										        
										        <% for (int i = 0; i < mainBenefitValue.size(); i++) { %>
										        	<% SmartActiveBenefitValue item = mainBenefitValue.get(i); %>
										        	<option value="<%= item.getValue() %>" <%= (i == 0) ? "selected" : "" %>><%= item.getValue() %></option>
										        <% } %>
										        
										        
												<% } %>
										    </select>
										</div>
									</div>
								</div>
								<div id="input-slider">
									<input type="range" id="range">
								</div>
							</div>

							<div class="sa-coverage">
								<div id="coverage-period-wrapper">
									<div class="col-calendar position-relative" id="from-wrapper">
										<label for="from" class="sa-label">Periode Pertanggungan<sup>*</sup></label>
										<div class="sa-input-group-axa input-group-axa--border">
											<input class="input-control-axa input-control-axa--outline sa-fv-outline-none blocked-input-date" id="from" name="PeriodeFromDisplay" type="text" placeholder="Dari Tanggal" required autocomplete="off">
											<input class="form-item" type="hidden" name="PeriodeFrom"/>
											<span class="align-self-center">
												<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
													<path d="M6.51479 7.61676H17.9434M5.99961 1.38347V3.41698M5.99961 3.41698L17.9996 3.41676M5.99961 3.41698C4.01132 3.41698 2.39969 5.02864 2.39978 7.01693L2.40034 19.0168C2.40043 21.005 4.01218 22.6167 6.00034 22.6167H18.0003C19.9886 22.6167 21.6004 21.0048 21.6003 19.0165L21.5998 7.01659C21.5997 5.02843 19.9878 3.41676 17.9996 3.41676M17.9996 1.38336V3.41676M9.6005 18.4167V11.2167L7.2005 13.0167M16.2005 18.4167V11.2167L13.8005 13.0167" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
												</svg>
											</span>
										</div>
										<small>DD/MMM/YYYY</small>
									</div>
									<div style="align-content: center;" class="col col-arrow"><i class="fas fa-arrow-right"></i></div>
									<div class="col-calendar position-relative" id="until-wrapper">
										<div class="label-hidden">&nbsp;</div>
										<div class="sa-input-group-axa input-group-axa--border sa-disabled">
											<input class="input-control-axa input-control-axa--outline sa-fv-outline-none blocked-input-date" id="until" name="PeriodeToDisplay" type="text" placeholder="Sampai Tanggal" disabled autocomplete="off">
											<input class="form-item" type="hidden" name="PeriodeTo"/>
											<span class="align-self-center">
												<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
													<path d="M6.51479 7.61676H17.9434M5.99961 1.38347V3.41698M5.99961 3.41698L17.9996 3.41676M5.99961 3.41698C4.01132 3.41698 2.39969 5.02864 2.39978 7.01693L2.40034 19.0168C2.40043 21.005 4.01218 22.6167 6.00034 22.6167H18.0003C19.9886 22.6167 21.6004 21.0048 21.6003 19.0165L21.5998 7.01659C21.5997 5.02843 19.9878 3.41676 17.9996 3.41676M17.9996 1.38336V3.41676M9.6005 18.4167V11.2167L7.2005 13.0167M16.2005 18.4167V11.2167L13.8005 13.0167" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
												</svg>
											</span>
										</div>
										<small>DD/MMM/YYYY</small>
									</div>
									<span class="text-reminder">(Kedua tanggal tersebut pukul 12.00 siang waktu setempat di mana obyek pertanggungan berada)</span>
								</div>
							</div>

							<div class="sa-panel-inside">
								<div class="panel-inside__heading"><h3>Manfaat Utama</h3></div>
								<div class="panel-inside__body main-benefit">
									
									<div class="col-panel mainBenefitName">
                                    	<!-- name here -->
	                                </div>
	                                <div class="col-panel align-self-center mainBenefitValue">
	                                    <!-- value here -->
	                                </div>

								</div>
							</div>

						</div>
					</div>

					<div class="panel">
						<div class="panel__heading">
							<h1>Tambah Proteksi</h1>
						</div>
						<div class="sa-panel-inside">
							<div class="panel-inside__heading"><h3>Allowances / Santunan</h3></div>
							<div class="panel-inside__body add-protection">
								<div id="allowance-benefit-container" class="col-panel col-panel-switch">
									
								</div>
							</div>
						</div>
					</div>

					<div class="panel">
						<div class="sa-panel-inside">
							<div class="panel-inside__heading"><h3>Manfaat Lainnya</h3></div>
							<div class="panel-inside__body add-protection">
								<div id="other-benefit-container" class="col-panel col-panel-switch">
									
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="sa-choose-policy__right">
					<%@ include file="/includes/panel_summary.jsp" %>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="/includes/sticky.jsp" %>

<div id="modal_baca" class="modal_baca agency__hidden">
	<div class="modal_baca-content">
	    <!-- Tombol Tutup -->
	    <button onclick="closeModal()" class="modal_baca-close-button">&times;</button>
	
	    <!-- Bagian Title -->
	    <div class="modal_baca-title">
	        <h2>JENIS PEKERJAAN DAN AKTIVITAS TERTANGGUNG YANG DIKECUALIKAN</h2>
	    </div>
	
	    <!-- Garis Pemisah -->
	    <hr class="modal_baca-divider">
	
	    <!-- Bagian Content -->
        <div class="modal_baca-body">
        	<% if (Validator.isNotNull(occupationExceptionContent)) { %>
            	<%= occupationExceptionContent %>
            <% } %>
        </div>
    </div>
</div>

<%@ include file="/includes/modal.jsp" %>

<script type="text/javascript">
	var _nextStepURL = "<%= step3URL %>";
	var _step = "<%= _step %>";
	var _apiURL = "<%= portalURL %>";
	var _setTransactionURL = "<%= setTransactionURL %>";
	var _quoteCategory = "<%= quoteCategory %>";
	var mobile = <% if (mobile.isEmpty()) { %>""<% } else { %><%= mobile %><% } %>;
</script>

<script src="<%= request.getContextPath() %>/js/main.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<script type="text/javascript">
	let sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);
	if (sessionData) {
		sessionData = JSON.parse(sessionData);
		
		if (!_quoteCategory && (sessionData.QuoteCategory && sessionData.QuoteCategory == 'edit')) {
			sessionStorage.clear();
		}
		
		if (sessionData.QuoteCategory == 'continue') {
			sessionStorage.clear();
		}
	}

	var managedBy = '<%= managedBy %>'.trim();
	var managedByParam = '<%= agentDeptCode %>'.trim();
	if (managedBy !== "null" && managedBy !== "") {
	    updateSess(_smartActiveFormDetailSess, "ManagedBy", managedBy);
	}
	
	var managedById = '<%= managedById %>'.trim();
	if (managedById !== "null" && managedById !== "") {
	    updateSess(_smartActiveFormDetailSess, "ManagedById", managedById);
	}
	
	var agentRole = '<%= agentRole %>'.trim();
	if (agentRole !== "null" && agentRole !== "") {
	    updateSess(_smartActiveFormDetailSess, "Role", agentRole);
	}
	
	var businessModel = '<%= businessModel %>'.trim();
	if (businessModel !== "null" && businessModel !== "") {
	    updateSess(_smartActiveFormDetailSess, "BusinessModel", businessModel);
	}
	
	var promoCode = '<%= promoCode %>'.trim();
	if (promoCode !== "null" && promoCode !== "") {
	    updateSess(_smartActiveFormDetailSess, "PromoCode", promoCode);
	}
	
	/* UTM SET */
	var utmSource = '<%= utm_source %>'.trim();
	if (utmSource !== "null" && utmSource !== "") {
	    updateSess(_smartActiveFormDetailSess, "UtmSource", utmSource);
	}
	
	var utmMedium = '<%= utm_medium %>'.trim();
	if (utmMedium !== "null" && utmMedium !== "") {
	    updateSess(_smartActiveFormDetailSess, "UtmMedium", utmMedium);
	}
	
	var utmCampaign = '<%= utm_campaign %>'.trim();
	if (utmCampaign !== "null" && utmCampaign !== "") {
	    updateSess(_smartActiveFormDetailSess, "UtmCampaign", utmCampaign);
	}
	
	var utmTerm = '<%= utm_term %>'.trim();
	if (utmTerm !== "null" && utmTerm !== "") {
	    updateSess(_smartActiveFormDetailSess, "UtmTerm", utmTerm);
	}
	
	var utmContent = '<%= utm_content %>'.trim();
	if (utmContent !== "null" && utmContent !== "") {
	    updateSess(_smartActiveFormDetailSess, "UtmContent", utmContent);
	}
</script>

<script src="<%= request.getContextPath() %>/js/step2.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/footer.jsp" %>
<% } %>