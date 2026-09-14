<%@page import="java.util.Locale"%>
<%@page import="com.mypage.leads.service.DetailSmartactiveLocalServiceUtil"%>
<%@page import="com.mypage.leads.service.LeadsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.mypage.admin.product.service.SmartActiveOccupationLocalServiceUtil"%>
<%@page import="com.mypage.admin.product.model.SmartActiveOccupation"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mypage.leads.model.DetailSmartactive"%>
<%@page import="com.mypage.leads.model.Leads"%>
<%@ include file="/init.jsp" %>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>

<%
    // Retrieve String attributes
    String aParam = (String) renderRequest.getAttribute("a");
	String rcParam = (String) renderRequest.getAttribute("rc");
	String bParam = (String) renderRequest.getAttribute("b");
    String productName = String.valueOf(renderRequest.getAttribute("productName"));
    String managedBy = String.valueOf(renderRequest.getAttribute("managedBy"));
    String managedById = (String) renderRequest.getAttribute("managedById");
    String businessModel = String.valueOf(renderRequest.getAttribute("businessModel"));
    String agentRole = Validator.isNotNull((String) renderRequest.getAttribute("agentRole")) ? (String) renderRequest.getAttribute("agentRole") : "";
    String agentCode = Validator.isNotNull((String) renderRequest.getAttribute("agentCode")) ? (String) renderRequest.getAttribute("agentCode") : "";
	String agentName = Validator.isNotNull((String) renderRequest.getAttribute("agentName")) ? (String) renderRequest.getAttribute("agentName") : "";
	String mobile = Validator.isNotNull((String) renderRequest.getAttribute("mobile")) ? (String) renderRequest.getAttribute("mobile") : "";
    
    String utm_source = String.valueOf(renderRequest.getAttribute("utm_source"));
    String utm_medium = String.valueOf(renderRequest.getAttribute("utm_medium"));
    String utm_campaign = String.valueOf(renderRequest.getAttribute("utm_campaign"));
    String utm_term = String.valueOf(renderRequest.getAttribute("utm_term"));
    String utm_content = String.valueOf(renderRequest.getAttribute("utm_content"));
    
    String lParam = Validator.isNotNull((String) renderRequest.getAttribute("l")) ? (String) renderRequest.getAttribute("l") : "";
    String leadsTemp = Validator.isNotNull((String) renderRequest.getAttribute("qt")) ? (String) renderRequest.getAttribute("qt") : "";
    String promoCode = Validator.isNotNull((String) renderRequest.getAttribute("pc")) ? (String) renderRequest.getAttribute("pc") : "";
    String prettyUrl = Validator.isNotNull((String) renderRequest.getAttribute("pu")) ? (String) renderRequest.getAttribute("pu") : "";
    String quoteCategory = Validator.isNotNull((String) renderRequest.getAttribute("qe")) ? (String) renderRequest.getAttribute("qe") : "";
    String isPep = Validator.isNotNull((String) renderRequest.getAttribute("qp")) ? (String) renderRequest.getAttribute("qp") : "";
    String quoteType = String.valueOf(renderRequest.getAttribute("qq"));
    String csrfToken = Validator.isNotNull((String) renderRequest.getAttribute("CSRF_TOKEN")) ? (String) renderRequest.getAttribute("CSRF_TOKEN") : "";

    // Retrieve boolean and numeric attributes safely
    long lId = renderRequest.getAttribute("lId") != null ? (long) renderRequest.getAttribute("lId") : 0;

    // Retrieve Portal URL and Product Configuration
    String _portalURL = themeDisplay.getPortalURL();
    
    //test dummy
    
    /* lId = Long.parseLong("148201"); */
    
    String _step = "continue";
    List<SmartActiveLink> files = (List<SmartActiveLink>) renderRequest.getAttribute("files");
    List<SmartActiveOccupation> occupations = (List<SmartActiveOccupation>) renderRequest.getAttribute("occupations");
    List<SmartActiveBenefitValue> mainBenefitValue = (List<SmartActiveBenefitValue>) renderRequest.getAttribute("mainBenefitValue");
    
%>

<portlet:resourceURL id="settransaction" var="setTransactionURL" />

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/navbar.jsp"%>
<% } %>


<header class="hero<% if (Validator.isNotNull(mobile)) { %> hero-mobile<% } %>">
	<img src="/o/mypage-theme/images/banner_step_sa.png" alt="Axa SmartActive" class="width-full height-full">
</header>

<section class="step-one" id="Step-1">
	<input type="hidden" name="csrfToken" value="<%= csrfToken %>" />
	<%@ include file="/includes/stepbar.jsp" %>

	<div class="sa-choose-policy form-container">
		<div class="container-axa">
			<div class="choose-policy-grid">
				<div class="sa-choose-policy__left sa-insured-data__left">
					<div class="panel container-form">
						<div class="panel__heading"><h1>Plan SmartActive</h1></div>
						<div class="panel__body">
							<div class="policy-smartactive">
								<p>
									Apakah pemegang polis atau tertanggung memiliki pekerjaan atau aktifitas yang dikecualikan untuk pembelian polis SmartActive?
									<!-- <a class="position-relative" href="#">Baca selengkapnya <i class="far fa-arrow-right"></i></a> -->
								</p>
								<div class="radio-wrapper excluded-activity-status">
									<div class="sa-radio-custom-wrapper">
										<input class="excludedInputNo" type="radio" name="radio-polis" value="0" id="radio-polis-1" disabled>
										<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-polis-1">
											<span class="radio-cloak"></span>
											<span>Tidak</span>
										</label>
									</div>
								
									<div class="sa-radio-custom-wrapper">
										<input class="excludedInputYes" type="radio" name="radio-polis" value="1" id="radio-polis-2" disabled>
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
									<select class="align-self-center job" name="Occupation" id="type-of-work">
										<% if (occupations.size() > 0) { %>
											<% for (SmartActiveOccupation itemOccupation : occupations) { %>
												<option value="<%= itemOccupation.getSmartActiveOccupationId() %>"><%= itemOccupation.getNameId() %></option>
											<% } %>
										<% } %>
										
									</select>
								</div>
								<div class="col-calendar position-relative" id="choose-plan-birth-wrapper">
									<label for="plan-birth" class="sa-label">Tanggal Lahir</label>
									<div class="sa-input-group-axa input-group-axa--border sa-disabled">
										<input class="input-control-axa input-control-axa--outline sa-fv-outline-none" name="plan-birth" id="choose-plan-birth" type="text" autocomplete="off">
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
									<label for="benefit-value" class="sa-label">Nilai Manfaat Utama</label>
									<div class="sa-input-group-axa input-group-axa--border sa-disabled">
										<span class="align-self-center">IDR</span>
										
										<div id="valueSelect-wrapper" class="position-relative">
										    <select class="valueSelect" id="valueSelect" name="MainBenefitValue" >
										        <% if (mainBenefitValue.size() > 0) { %>
													<% for (SmartActiveBenefitValue item : mainBenefitValue) { %>
														<option value="<%= item.getValue() %>"><%= item.getValue() %></option>
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
										<label for="from" class="sa-label">Periode Pertanggungan</label>
										<div class="sa-input-group-axa input-group-axa--border sa-disabled">
											<input class="input-control-axa input-control-axa--outline sa-fv-outline-none" id="from" name="PeriodeFrom" type="text" autocomplete="off">
											<span class="align-self-center">
												<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
													<path d="M6.51479 7.61676H17.9434M5.99961 1.38347V3.41698M5.99961 3.41698L17.9996 3.41676M5.99961 3.41698C4.01132 3.41698 2.39969 5.02864 2.39978 7.01693L2.40034 19.0168C2.40043 21.005 4.01218 22.6167 6.00034 22.6167H18.0003C19.9886 22.6167 21.6004 21.0048 21.6003 19.0165L21.5998 7.01659C21.5997 5.02843 19.9878 3.41676 17.9996 3.41676M17.9996 1.38336V3.41676M9.6005 18.4167V11.2167L7.2005 13.0167M16.2005 18.4167V11.2167L13.8005 13.0167" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
												</svg>
											</span>
										</div>
										<small>DD/MMM/YYYY</small>
									</div>
									<div style="align-content: center; " class="col col-arrow"><i class="fas fa-arrow-right"></i></div>
									<div class="col-calendar position-relative" id="until-wrapper" >
										<div class="label-hidden">&nbsp;</div>
										<div class="sa-input-group-axa input-group-axa--border sa-disabled">
											<input class="input-control-axa input-control-axa--outline sa-fv-outline-none" id="until" name="PeriodeTo" type="text" readonly autocomplete="off">
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

					<div class="panel panel-additional">
						<div class="panel__heading">
							<h1>Manfaat Tambahan</h1>
						</div>
						<div class="sa-panel-inside allowance-cover">
							<div class="panel-inside__heading"><h3>Allowances / Santunan</h3></div>
							<div class="panel-inside__body add-protection">
								<div id="allowance-benefit-container" class="col-panel col-panel-switch">
									
								</div>
							</div>
						</div>
						
						<div class="sa-panel-inside other-cover" style="margin-top: 30px;">
							<div class="panel-inside__heading"><h3>Manfaat Lainnya</h3></div>
							<div class="panel-inside__body add-protection">
								<div id="other-benefit-container" class="col-panel col-panel-switch">
									
								</div>
							</div>
						</div>
					</div>

					<!-- <div class="panel panel-other">
						<div class="sa-panel-inside">
							<div class="panel-inside__heading"><h3>Manfaat Lainnya</h3></div>
							<div class="panel-inside__body add-protection">
								<div id="other-benefit-container" class="col-panel col-panel-switch">
									
								</div>
							</div>
						</div>
					</div> -->
					
					
					
					<!-- BAGIAN TERTANGGUNG -->
					<% if (quoteType.equalsIgnoreCase("simple")) { %>
						<div class="panel container-form">
							<div class="panel__heading"><h1>Data Tertanggung</h1></div>
							<div class="panel__body">
								<div class="sa-id-card-identity">
									<div id="id-card-identity-name-wrapper">
										<label for="id-card-identity-name" class="sa-label">Nama lengkap sesuai KTP / KITAS</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-name" id="id-card-identity-name" type="text" autocomplete="off" >
									</div>
									
									<div id="id-card-identity-email-wrapper">
										<label for="id-card-identity-email" class="sa-label">Email</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-email" id="id-card-identity-email" type="email" autocomplete="off" >
									</div>
								</div>
							</div>
						</div>
					<% } else { %>
						<div class="panel container-form">
							<div class="panel__heading"><h1>Data Tertanggung</h1></div>
							<div class="panel__body">
								<div class="policy-smartactive">
									<p>
										Apakah pemegang polis termasuk ke dalam kategori Orang yang <span>Populer Secara Politis/ Politically Exposed Persons (PEP) ?</span>
										<!-- <a class="position-relative" href="#">Baca selengkapnya <i class="far fa-arrow-right"></i></a> -->
									</p>
									<div class="radio-wrapper">
										<div class="sa-radio-custom-wrapper">
											<input type="radio" name="radio-pep" id="radio-pep-1" value="N" disabled>
											<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-pep-1" disabled>
												<span class="radio-cloak"></span>
												<span>Tidak</span>
											</label>
										</div>
										
										<div class="sa-radio-custom-wrapper">
											<input type="radio" name="radio-pep" id="radio-pep-2" value="Y" disabled>
											<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-pep-2" disabled>
												<span class="radio-cloak"></span>
												<span>Iya</span>
												<small>(Data Anda akan kami tinjau untuk melewati persetujuan dari Underwriting)</small>
											</label>
										</div>
									</div>
								</div>
	
								<div class="sa-upload-photo-ktp">
									<div id="upload-photo-ktp-wrapper">
										<label for="upload" class="sa-label">Upload Foto KTP/KITAS</label>
										<div class="thumbnail-wrapper">
											<div>
												<img class="sa-thumbnail width-full" src="/o/mypage-theme/images/img-unselect.jpg" alt="AXA SmartActive">
												<span class="file-name"></span>
											</div>
											<!-- <div>
												<input type="file" name="upload" id="upload" class="fileInput" accept="image/*" required>
												<button type="button" class="uploadButton">
													<span>Pilih File</span>
												</button>
											</div> -->
										</div>
										<input type="hidden" name="imgUrl"/>
										<input type="hidden" name="imgId"/>
									</div>
								</div>
	
								<div class="sa-id-card-identity">
									<div id="id-card-identity-name-wrapper">
										<label for="id-card-identity-name" class="sa-label">Nama lengkap sesuai KTP / KITAS</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-name" id="id-card-identity-name" type="text" autocomplete="off" >
									</div>
									<div id="citizenship-wrapper">
										<label for="citizenship" class="sa-label">Kewarganegaraan</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="citizenship" id="citizenship" type="text" autocomplete="off" >
									</div>
									<div id="id-card-identity-number-wrapper">
										<label for="id-card-identity-number" class="sa-label">Nomor KTP / KITAS</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-number" id="id-card-identity-number" type="text" maxlength="16" autocomplete="off" >
									</div>
								</div>
								
								<div class="sa-id-card-identity-date-of-birth">
									<div id="id-card-identity-date-of-birth-wrapper">
										<div class="col-calendar position-relative" id="birth-date-wrapper">
											<label for="birth-date" class="sa-label">Tanggal Lahir</label>
											<div class="sa-input-group-axa input-group-axa--border sa-disabled">
												<input class="input-control-axa input-control-axa--outline sa-fv-outline-none" id="birth-date" name="birth-date" type="text" autocomplete="off" >
												<span class="align-self-center">
													<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
														<path d="M6.51479 7.61676H17.9434M5.99961 1.38347V3.41698M5.99961 3.41698L17.9996 3.41676M5.99961 3.41698C4.01132 3.41698 2.39969 5.02864 2.39978 7.01693L2.40034 19.0168C2.40043 21.005 4.01218 22.6167 6.00034 22.6167H18.0003C19.9886 22.6167 21.6004 21.0048 21.6003 19.0165L21.5998 7.01659C21.5997 5.02843 19.9878 3.41676 17.9996 3.41676M17.9996 1.38336V3.41676M9.6005 18.4167V11.2167L7.2005 13.0167M16.2005 18.4167V11.2167L13.8005 13.0167" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
													</svg>
												</span>
											</div>
											<small>DD/MMM/YYYY</small>
										</div>
									</div>
									<div id="age-wrapper">
										<label for="age" class="sa-label">Usia</label>
										<div class="sa-input-group-axa input-group-axa--border sa-disabled">
											<input class="input-control-axa input-control-axa--outline" id="age" name="age" type="text" value="0" disabled autocomplete="off">
											<span class="align-self-center">Tahun</span>
										</div>
										<small class="text-reminder text-message"></small>
									</div>
									<div id="id-card-identity-place-of-birth-wrapper">
										<label for="birth-place" class="sa-label">Tempat Lahir</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="birth-place" id="birth-place" type="text" autocomplete="off" >
									</div>
								</div>
	
								<div class="sa-id-card-identity-gender">
									<label for="gender" class="sa-label">Jenis Kelamin</label>
									<div id="id-card-identity-gender-wrapper">
										<div class="radio-icon">
											<div class="radio-icon-input">
												<input type="radio" name="gender" value="M" disabled>
												<div class="box-radio-wrapper agency__text-center">
													<div class="box-radio">
														<img src="/o/mypage-theme/images/man-nb.png" alt="laki-laki">
													</div>
													<div class="box-text">Laki-Laki</div>
												</div>
											</div>
										</div>
										<div class="radio-icon">
											<div class="radio-icon-input">
												<input type="radio" name="gender" value="F" disabled>
												<div class="box-radio-wrapper agency__text-center">
													<div class="box-radio">
														<img src="/o/mypage-theme/images/woman-nb.png" alt="perempuan">
													</div>
													<div class="box-text">Perempuan</div>
												</div>
											</div>
										</div>
									</div>
								</div>
	
								<div class="sa-id-card-identity">
									<div id="id-card-identity-no-hp-wrapper">
										<label for="id-card-identity-no-hp" class="sa-label">Nomor Handphone</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-no-hp" id="id-card-identity-no-hp" type="text" maxlength="13" autocomplete="off" >
									</div>
									<div id="id-card-identity-email-wrapper">
										<label for="id-card-identity-email" class="sa-label">Email</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-email" id="id-card-identity-email" type="email" autocomplete="off" >
									</div>
								</div>
							</div>
						</div>
	
						<div class="panel container-form">
							<div class="panel__heading"><h1>Alamat Domisili Sekarang</h1></div>
							<div class="panel__body">
								<div class="sa-id-card-identity">
									<div id="id-card-identity-postal-code-wrapper">
										<label for="id-card-identity-postal-code" class="sa-label">Kode Pos</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-postal-code" id="id-card-identity-postal-code" type="text" maxlength="5" autocomplete="off" >
									</div>
									<div id="province-wrapper">
										<label for="province" class="sa-label">Provinsi</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="province" id="province" type="text" autocomplete="off" >
									</div>
									<div id="regency-wrapper">
										<label for="regency" class="sa-label">Kabupaten/Kota</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="regency" id="regency" type="text" autocomplete="off" >
									</div>
								</div>
								<div class="sa-id-card-identity-address">
									<label for="address" class="sa-label">Alamat Lengkap</label>
									<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="address" id="address" type="text" autocomplete="off" >
								</div>
							</div>
						</div>
	
						<div class="panel container-form">
							<div class="panel__body">
								<div class="sa-employment-desc">
									<div id="employment-wrapper">
										<label for="employment" class="sa-label">Pekerjaan Tertanggung</label>
										<select name="employment" id="employment">
											<% if (occupations.size() > 0) { %>
												<% for (SmartActiveOccupation itemOccupation : occupations) { %>
													<option value="<%= itemOccupation.getSmartActiveOccupationId() %>"><%= itemOccupation.getNameId() %></option>
												<% } %>
											<% } %>
										</select>
									</div>
									<div id="locations-and-activities-wrapper">
										<label for="locations-and-activities" class="sa-label">Lokasi dan Aktivitas Sehari Hari</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="locations-and-activities" id="locations-and-activities" type="text" autocomplete="off" >
										<div id="additional-locations-wrapper" class="display-hidden mt-3level">
											<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="additional-locations" id="additional-locations" type="text" autocomplete="off">
										</div>
									</div>
	
									<div id="income-per-month-wrapper">
										<label for="income-per-month" class="sa-label">Penghasilan Per Bulan</label>
										<div class="radio-wrapper">
											<div class="sa-radio-custom-wrapper">
												<input type="radio" name="radio-income" id="radio-income-1" value="< Rp. 10 jt" disabled>
												<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-1" >
													<span class="radio-cloak"></span>
													<span>< Rp. 10 jt</span>
												</label>
											</div>
											
											<div class="sa-radio-custom-wrapper">
												<input type="radio" name="radio-income" id="radio-income-2" value="> Rp. 10 jt - Rp. 25 jt" disabled>
												<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-2">
													<span class="radio-cloak"></span>
													<span>> Rp. 10 jt - Rp. 25 jt</span>
												</label>
											</div>
											<div class="sa-radio-custom-wrapper">
												<input type="radio" name="radio-income" id="radio-income-3" value="> Rp. 25 jt - Rp. 50 jt" disabled>
												<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-3">
													<span class="radio-cloak"></span>
													<span>> Rp. 25 jt - Rp. 50 jt</span>
												</label>
											</div>
											<div class="sa-radio-custom-wrapper">
												<input type="radio" name="radio-income" id="radio-income-4" value="> Rp. 50 jt - Rp. 100 jt" disabled>
												<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-4">
													<span class="radio-cloak"></span>
													<span>> Rp. 50 jt - Rp. 100 jt</span>
												</label>
											</div>
											<div class="sa-radio-custom-wrapper">
												<input type="radio" name="radio-income" id="radio-income-5" value="> Rp. 100 jt - Rp. 200 jt" disabled>
												<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-5">
													<span class="radio-cloak"></span>
													<span>> Rp. 100 jt - Rp. 200 jt</span>
												</label>
											</div>
											<div class="sa-radio-custom-wrapper">
												<input type="radio" name="radio-income" id="radio-income-6" value="Rp. 200 jt" disabled>
												<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-6">
													<span class="radio-cloak"></span>
													<span>Rp. 200 jt</span>
												</label>
											</div>
										</div>
									</div>
	
									<div id="source-of-premium-payments-wrapper">
										<label for="source-of-premium-payments" class="sa-label">Sumber Pembayaran Premi</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="source-of-premium-payments" id="source-of-premium-payments" type="text" autocomplete="off" >
										<div id="additional-payments-wrapper" class="display-hidden mt-3level">
											<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="additional-payments" id="additional-payments" type="text" autocomplete="off">
										</div>
									</div>
									
									<div id="beneficiary-wrapper">
										<label for="beneficiary" class="sa-label">Ahli Waris</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="beneficiary" id="beneficiary" type="text" autocomplete="off">
									</div>
									
									<div id="beneficiary-relationship-wrapper">
										<label for="beneficiary-relationship" class="sa-label">Hubungan dengan Ahli Waris</label>
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="beneficiary-relationship" id="beneficiary-relationship" type="text" autocomplete="off" >
									</div>
								</div>
							</div>
						</div>
					<% } %>
				</div>
				<div class="sa-choose-policy__right summary__container">
					<%@ include file="/includes/panel_summary.jsp" %>
				</div>
			</div>
		</div>
	</div>
</section>


<%
	Leads _leads = null;
	DetailSmartactive detailSmartactive = null;
	JSONObject payloadData = null;
	long classRateId = 0L;
	
	//initiate leads and details
	if(lId > 0) {
		_leads = LeadsLocalServiceUtil.getLeads(lId);
		
		if(_leads != null) {
			detailSmartactive = DetailSmartactiveLocalServiceUtil.findByLeadsId(lId);
			long JobID =  detailSmartactive.getJobType();
			
			SmartActiveOccupation occupation = SmartActiveOccupationLocalServiceUtil.fetchSmartActiveOccupation(JobID);
			
			if(occupation != null){
				classRateId = occupation.getSmartActiveClassRateId();	
			}
		}
	}
%>


<portlet:renderURL var="riplayBaseURL">
	<portlet:param name="mvcPath" value="/step4.jsp" />
</portlet:renderURL>

<% 
    String riplayURL = riplayBaseURL;
    if (Validator.isNotNull(aParam)) riplayURL = riplayURL + "&a=" + aParam;
    if (Validator.isNotNull(rcParam)) riplayURL = riplayURL + "&rc=" + rcParam;
    if (Validator.isNotNull(bParam)) riplayURL = riplayURL + "&b=" + bParam;
    if (Validator.isNotNull(promoCode)) riplayURL = riplayURL + "&pc=" + promoCode;
    if (Validator.isNotNull(prettyUrl)) riplayURL = riplayURL + "&pu=" + prettyUrl;
    if (Validator.isNotNull(lParam)) riplayURL = riplayURL + "&l=" + lParam;
    if (Validator.isNotNull(leadsTemp)) riplayURL = riplayURL + "&qt=" + leadsTemp;
    if (Validator.isNotNull(mobile)) riplayURL = riplayURL + "&mobile=" + mobile;
%>

<portlet:renderURL var="polisBaseURL">
	<portlet:param name="mvcPath" value="/step2.jsp" />
</portlet:renderURL>

<% 
    String polisURL = polisBaseURL;
    if (Validator.isNotNull(aParam)) polisURL = polisURL + "&a=" + aParam;
    if (Validator.isNotNull(rcParam)) polisURL = polisURL + "&rc=" + rcParam;
    if (Validator.isNotNull(bParam)) polisURL = polisURL + "&b=" + bParam;
    if (Validator.isNotNull(promoCode)) polisURL = polisURL + "&pc=" + promoCode;
    if (Validator.isNotNull(prettyUrl)) polisURL = polisURL + "&pu=" + prettyUrl;
    if (Validator.isNotNull(quoteCategory)) polisURL = polisURL + "&qe=" + quoteCategory;
    if (Validator.isNotNull(lParam)) polisURL = polisURL + "&l=" + lParam;
    if (Validator.isNotNull(leadsTemp)) polisURL = polisURL + "&qt=" + leadsTemp;
    if (Validator.isNotNull(mobile)) polisURL = polisURL + "&mobile=" + mobile;
%>

<portlet:renderURL var="insuredBaseURL">
	<portlet:param name="mvcPath" value="/step3.jsp" />
</portlet:renderURL>

<% 
    String insuredURL = insuredBaseURL;
    if (Validator.isNotNull(aParam)) insuredURL = insuredURL + "&a=" + aParam;
    if (Validator.isNotNull(rcParam)) insuredURL = insuredURL + "&rc=" + rcParam;
    if (Validator.isNotNull(bParam)) insuredURL = insuredURL + "&b=" + bParam;
    if (Validator.isNotNull(promoCode)) insuredURL = insuredURL + "&pc=" + promoCode;
    if (Validator.isNotNull(prettyUrl)) insuredURL = insuredURL + "&pu=" + prettyUrl;
    if (Validator.isNotNull(quoteCategory)) insuredURL = insuredURL + "&qe=" + quoteCategory;
    if (Validator.isNotNull(lParam)) insuredURL = insuredURL + "&l=" + lParam;
    if (Validator.isNotNull(leadsTemp)) insuredURL = insuredURL + "&qt=" + leadsTemp;
    if (Validator.isNotNull(mobile)) insuredURL = insuredURL + "&mobile=" + mobile;
%>

<%@ include file="/includes/modal.jsp" %>

<script>
	var _apiURL = "<%=_portalURL %>";
	var _setTransactionURL = "<%= setTransactionURL %>";
	var linkRiplay = "<%=riplayURL%>";
	var linkStep2 = "<%=polisURL%>";
	var linkStep3 = "<%=insuredURL%>";
	
	var _step = "<%= _step %>";
	
	var quoteCategory = "<%= quoteCategory.trim() %>";
    var quoteType = "<%= quoteType.trim() %>";
    var isPep = <% if (isPep.isEmpty()) { %>""<% } else { %><%= isPep %><% } %>;
</script>

<script src="<%=request.getContextPath()%>/js/main.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>


<% 
try {
	
	if(_leads != null && detailSmartactive != null) {
		
		//SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MMM/yyyy");
		
		// Membuat format SimpleDateFormat dengan Locale Indonesia
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MMM/yyyy", new Locale("id", "ID"));
		
		String startdateFormat = (detailSmartactive.getStartPeriode() != null) ? outputFormat.format(detailSmartactive.getStartPeriode()) : "";
		String expdateFormat = (detailSmartactive.getEndPeriode() != null) ? outputFormat.format(detailSmartactive.getEndPeriode()) : "";
		
		if (promoCode.isEmpty()) {
			promoCode = _leads.getPromoCode();
		}
		
		long jobId = detailSmartactive.getJobType();
		
		payloadData = JSONFactoryUtil.createJSONObject();
	    payloadData.put("ExcludedActivityStatus", detailSmartactive.getExcludedActivityStatus());
	    
	    //tidak perlu set ini karena fetch leads pakai token
	    payloadData.put("Occupation", String.valueOf(jobId));
	    //payloadData.put("JobTitle", _leads.getJob());
	    //payloadData.put("Dob", dobFormat);
	    //payloadData.put("PolicyName", _leads.getName());
	    //payloadData.put("BeneficiaryName", "");
	    //payloadData.put("Gender", _leads.getGender());
	    
	    payloadData.put("MainBenefitValue", detailSmartactive.getMainBenefitValue());
	    payloadData.put("PeriodeFrom", startdateFormat);
	    payloadData.put("PeriodeTo", expdateFormat);
	    payloadData.put("Token", _leads.getToken());
	    payloadData.put("PromoCode", _leads.getPromoCode());
	    
	    JSONArray benefitArray = JSONFactoryUtil.createJSONArray(detailSmartactive.getListBenefitId());
	    payloadData.put("AdditionalBenefits", benefitArray);
	    
	    
	%>
	<script type="text/javascript">
	 
	// Key untuk SmartTravelInternationalDataPayload
	let smartActiveFormDetailSessData = sessionStorage.getItem(_smartActiveFormDetailSess);
	smartActiveFormDetailSessData = smartActiveFormDetailSessData ? JSON.parse(smartActiveFormDetailSessData) : {};
	
	smartActiveFormDetailSessData = JSON.parse('<%=payloadData%>');
	sessionStorage.setItem(_smartActiveFormDetailSess, JSON.stringify(smartActiveFormDetailSessData));
	
	//if(repeatOrder == 1) {
	//updateSess(_smartActiveFormDetailSess, "ro", true);
	//} else {
	//updateSess(_smartActiveFormDetailSess, "ro", false);
	//}
	
	
	</script>
	<%} %>
	
	<script type="text/javascript">
		var leadsToken = "<%=_leads.getToken()%>";
		var listBenefitId = '<%=detailSmartactive.getListBenefitId()%>';
		var mainbenefitValue = '<%=detailSmartactive.getMainBenefitValue() %>';
		var classRateId = '<%=classRateId%>';
	
		var businessModel = '<%=businessModel%>';
		updateSess(_smartActiveFormDetailSess, "BusinessModel", businessModel);
		
		var managedBy = '<%=managedBy%>';
		updateSess(_smartActiveFormDetailSess, "ManagedBy", managedBy);
		
		var managedById = '<%=managedById%>';
		updateSess(_smartActiveFormDetailSess, "ManagedById", managedById);
		
		var agentRole = '<%=agentRole%>';
		updateSess(_smartActiveFormDetailSess, "Role", agentRole);
		
		/* UTM SET */
		var utmSource = '<%= utm_source %>';
		updateSess(_smartActiveFormDetailSess, "UtmSource", utmSource);
		
		var utmMedium = '<%= utm_medium %>';
		updateSess(_smartActiveFormDetailSess, "UtmMedium", utmMedium);
		
		var utmCampaign = '<%= utm_campaign %>';
		updateSess(_smartActiveFormDetailSess, "UtmCampaign", utmCampaign);
		
		var utmTerm = '<%= utm_term %>';
		updateSess(_smartActiveFormDetailSess, "UtmTerm", utmTerm);
		
		var utmContent = '<%= utm_content %>';
		updateSess(_smartActiveFormDetailSess, "UtmContent", utmContent);
		
		var quoteCategory = '<%= quoteCategory %>';
		updateSess(_smartActiveFormDetailSess, "QuoteCategory", quoteCategory);
	</script>
	
	<%
} catch(Exception e) {
	out.println(e.getMessage());
}
%>

<script src="<%=request.getContextPath()%>/js/continue.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/footer.jsp" %>
<% } %>