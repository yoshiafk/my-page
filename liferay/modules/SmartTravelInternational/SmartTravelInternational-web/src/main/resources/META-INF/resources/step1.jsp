<%@ include file="init.jsp"%>
<% String lowerPremiPrice = (String)renderRequest.getAttribute("lowerPremiPrice"); %>
<% String managedBy = (String)renderRequest.getAttribute("managedBy"); %>
<% String managedById = (String)renderRequest.getAttribute("managedById"); %>
<% ProductConfiguration _product = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"); %>
<% String sanctionCountry = (String)renderRequest.getAttribute("sanctionCountry"); %>
<% String agentRole = (String) renderRequest.getAttribute("agentRole"); %>
<% String promoCode = (String)renderRequest.getAttribute("pc"); %>
<% String smartTravelFaq = (String)renderRequest.getAttribute("smarttravelfaq"); %>

<%-- Link Riplay Umum dan Brosur jadi ambil dari MasterGlobalVariable --%>
<% String brochureLink = (String)renderRequest.getAttribute("brochureLink"); %>
<% String riplayLink = (String)renderRequest.getAttribute("riplayLink"); %>

<% String myInsuranceLink = (String)renderRequest.getAttribute("myInsuranceLink"); %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%
LocalDateTime timestampForJSURI = LocalDateTime.now();
DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>

<%
String _portalURL = themeDisplay.getPortalURL();
List<BenefitType> _allBenefitTypes = BenefitTypeLocalServiceUtil.getAllBenefitTypes();
%>

<script src="<%=request.getContextPath()%>/js/main.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/util.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>

<script type="text/javascript">
	var pc = '<%=promoCode%>';
	if (pc !== "null" && pc !== "") {
	    updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
	}
</script>

<script src="<%=request.getContextPath()%>/js/step1.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>

<script type="text/javascript">
	var managedBy = '<%=managedBy%>';
	var managedById = '<%=managedById%>';
	updateSess(_smartTravelInternationalFormDetailSess, "ManagedBy", managedBy);
	updateSess(_smartTravelInternationalFormDetailSess, "ManagedById", managedById);
	
	var agentRole = '<%= agentRole %>'.trim();
	if (agentRole !== "null" && agentRole !== "") {
	    updateSess(_smartTravelInternationalFormDetailSess, "Role", agentRole);
	}
	
	var _apiURL = "<%=_portalURL %>";
</script>

<portlet:renderURL var="step2URL">
	<portlet:param name="mvcPath" value="/step2.jsp"></portlet:param>
</portlet:renderURL>

<script type="text/javascript">
	var _nextStepURL = "<%=step2URL %>";
</script>

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
					<a class="brand-logo-link"><img class="brand-logo" src="/o/mypage-theme/images/logo_axa_mandiri.png" alt="AXA Insurance Indonesia"></a>
					<div class="cloak"></div>
				</div>
				<div class="nav-axa-wrapper">
				</div>
			</div>
		</div>
	</div>
</nav>


<!-- Mobile menu, show/hide based on menu state. -->
<div id="mobile-menu">
	<ul>
		<li><a href="javascript:void(0)" class="trigger-sub-menu"
			aria-current="page"> <span>Asuransi Kami</span> <i
				class="fas fa-chevron-right"></i>
		</a>
			<div class="sub-menu">
				<div class="container-axa">
					<div class="back-sub-menu">
						<a href="javascript:void(0)"><i
							class="far fa-long-arrow-left fa-fw"></i></a>
					</div>
					<h3>Asuransi Kami</h3>
					<p>Temukan berbagai jenis asuransi dengan solusi perlindungan
						sempurna dan manfaat optimal, sesuai dengan kebutuhan Anda dan
						keluarga.</p>
					<ul>
						<li>Solusi Kami</li>
						<li><a href="#"> <span>Asuransi Perjalanan</span> <i
								class="fas fa-chevron-right"></i>
						</a></li>
						<li><a href="#"> <span>Asuransi Kendaraan</span> <i
								class="fas fa-chevron-right"></i>
						</a></li>
						<li><a href="#"> <span>Asuransi Kesehatan</span> <i
								class="fas fa-chevron-right"></i>
						</a></li>
						<li><a href="#"> <span>Asuransi Lainnya</span> <i
								class="fas fa-chevron-right"></i>
						</a></li>
					</ul>
				</div>
			</div></li>
		<li><a href="#" class="">Promo & News</a></li>
		<li><a href="#" class="">Kirim Ulang Polis</a></li>
		<li><a href="#" class="">Tentang Axa Insurance</a></li>
		<li><a href="#" class="">Emma By Axa</a></li>
	</ul>
</div>

<div class="lr-wrapper">
<header class="hero">
	<div class="hero__home">
		<div class="hero__home--grid">
			<div class="col">
				<img src="/o/mypage-theme/images/banner_home_1.jpg" alt="">
			</div>
			<div class="col">
				<h1><%= _product != null ? _product.getProductName() : "Asuransi SmartTravel <br/> Internasional" %></h1>
				<p>Bebas melangkah lebih yakin dengan <br />Asuransi SmartTravel Internasional / <em>SmartTravel International Insurance</em></p>
				<div class="card-hero">
					<div class="card-header-hero">
						<h3>Plan International</h3>
					</div>
					<div class="card-body-hero">
						<p>Polis ini untuk perjalanan dari Indonesia dan kembali ke Indonesia, dengan jangkauan seluruh dunia*</p>
						<a href="#Sec-2">Pelajari Plan</a>
					</div>
					<div class="card-footer-hero">
						<p class="agency__text_axa_bluesky_900">Mulai Dari</p>
						<div class="price">
							<span class="display-block agency__text_axa_bluesky_900"><%= (lowerPremiPrice != null) ? lowerPremiPrice : "" %></span>
						</div>
						<small class="agency__text_axa_bluesky_900">*syarat & ketentuan berlaku</small>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>

<section class="simulasi">
	<div class="container-axa">
		<h1 class="agency__text-center">Simulasi</h1>
		<form class="simulasi__inner" action="#" id="form-simulation">
		
			<div class="simulasi__inner--left">
			
				<label class="block" for="pilih-mata-uang">Pilih Jenis Mata Uang</label>
				<div class="grid-radio mb-27px mt-4level">
					<div>
						<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
							<input id="idr" class="radio-custom form-item" name="Currency" type="radio">
							<label for="idr" class="mb-0px"><span>IDR</span></label>
						</div>
					</div>
					<div>
						<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
							<input id="usd" class="radio-custom form-item" name="Currency" type="radio">
							<label for="usd" class="mb-0px"><span>USD</span></label>
						</div>
					</div>					
				</div>
				
				<div class="mb-27px">
					<label class="display-block" for="travel-type">Pilih jenis perjalanan</label>
					<div id="travel-type-wrapper" class="position-relative">
						<select class="input-control-axa form-item" name="TravelType" id="travel-type" required>
							<option value="Single">Perjalanan Tunggal</option>
							<option value="Annual">Program Tahunan</option>
						</select>
					</div>
				</div>
				<div class="mb-27px">
					<label class="display-block" for="tgl-perjalanan">Tanggal Perjalanan</label>
					<div class="calendar-wrapper position-relative" id="calendar-wrapper-claim">
						<div class="calendar-col position-relative" id="Fromtravel-wrapper">
							<input class="input-control-axa input-control-axa--outline" type="text" id="Fromtravel" name="DepartureDateDisplay" autocomplete="off" readonly>
							<input class="form-item" type="hidden" name="DepartureDate"/>
							<div class="label-text">Dari</div>
						</div>
						<div class="separated-arrow">
							<i class="fas fa-arrow-right align-self-center text-12px"></i>
						</div>
						<div class="calendar-col position-relative" id="Totravel-wrapper">
							<input class="input-control-axa input-control-axa--outline input-icon-date" type="text" id="Totravel" name="ArrivalDateDisplay" autocomplete="off" readonly>
							<input class="form-item" type="hidden" name="ArrivalDate"/>
							<div class="label-text">Ke</div>
						</div>
					</div>
				</div>
				<div class="mb-27px">
					<label class="display-block" for="destinasi">Destinasi</label>
					<div class="destinasi-wrapper">
						<!-- <select id="destinasi" multiple="multiple" autocomplete="off">
							<option value="Worldwide" selected>Worldwide including Schengen Countries</option>
						</select> -->
						
						<select id="destinasi" multiple="multiple" autocomplete="off">
						    <c:forEach var="entry" items="${destinationMap}" varStatus="status">
						        <option value="${entry.key}" ${status.first ? 'selected' : ''}>${entry.value}</option>
						    </c:forEach>
						</select>
						
					</div>
				</div>
			</div>
			<div class="simulasi__inner--right">
				<div>
					<label class="display-block" for="pilih-jenis-penumpang">Anda melakukan perjalanan <a href="javascript:void(0)" class="tooltip"><i class="fas fa-info-circle"></i> <span class="tooltip-content">
                		<ul>
                    		<li>Perorangan Maksimal 1 orang</li>
                    		<li>Keluarga Maksimal 7 orang (tertanggung, pasangan, 5 anak)</li>
                    		<li>Duo Maksimal 2 orang (tertanggung dengan kerabat/teman)</li>
                		</ul>
            </span></a></label>
					<div class="form-radio-wrapper">
						<div class="form-radio">
							<input type="radio" id="individual" name="TravellerType" value="Individual" class="form-control form-item">
							<div class="box-radio-wrapper agency__text-center">
								<div class="box-radio">
									<img src="/o/mypage-theme/images/man-nb.png" alt="Individual">
								</div>
								<div class="box-text">Sendiri</div>
							</div>
						</div>
						<div class="form-radio">
							<div class="form-radio-input">
								<input type="radio" id="duo" class="form-item" name="TravellerType" value="Duo" class="form-control form-item">
								<div class="box-radio-wrapper agency__text-center">
									<div class="box-radio">
										<img src="/o/mypage-theme/images/duo-nb.png" alt="Duo">
									</div>
									<div class="box-text">Duo</div>
								</div>
							</div>
						</div>
						<div class="form-radio">
							<div class="form-radio-input">
								<input type="radio" id="family" class="form-item" name="TravellerType" value="Family" class="form-control form-item">
								<div class="box-radio-wrapper agency__text-center">
									<div class="box-radio">
										<img src="/o/mypage-theme/images/familiy-nb.png" alt="Family">
									</div>
									<div class="box-text">Keluarga</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="select-input-wrapper mb-27px">
					<label class="display-block" for="jumlah-tanggungan">Jumlah tanggungan</label>
					<div class="input-grid">
						<div class="input-group-axa input-group-axa--border adult-total">
							<div id="select-adult-wrapper" class="select-adult-wrapper">
								<select class="align-self-center form-item select-adult" name="AdultTotal" id="select-adult">
								</select>
							</div>
						</div>
						<div class="input-group-axa input-group-axa--border child-total gohide">
							<div id="select-kid-wrapper" class="select-kid-wrapper">
								<select class="align-self-center form-item select-kid" name="ChildTotal" id="select-kid">
<!-- 									<option value="1">1 Anak</option> -->
<!-- 									<option value="2">2 Anak</option> -->
<!-- 									<option value="3">3 Anak</option> -->
<!-- 									<option value="4">4 Anak</option> -->
<!-- 									<option value="5">5 Anak</option> -->
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="grid-bottom">
					<div>
					<ul class="simulation-wording-list">
						<li>Polis ini untuk perjalanan dari Indonesia dan kembali ke Indonesia.</li>
						<li>Perjalanan harus dilakukan secara bersama - sama dalam kondisi pergi dan kembali ke Indonesia.</li>
						<li>Apabila terpisah disarankan untuk melakukan pembelian terpisah dengan polis individu.</li>
					</ul>
					</div>
					<div>
						<div class="mb-30px align-self-center">
							<button class="btn btn__agency btn--dark-blue width-full h-54px" type="submit" id="calculate-btn">
								<span class="position-relative align-self-center">Hitung<i class="fas fa-arrow-right"></i></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</section>

<section class="chosee-plan" id="changePlan">
	<div class="container-axa">
		<h1 class="agency__text-center">Plan Pilihan</h1>
	</div>
	
	<div class="is-overflow choosen-plan-wrapper gohide">
		<div class="container-axa">
			<div class="swiper swiper-plan">
				<div class="swiper-wrapper" id="swiper-wrapper">
					<!-- swiper slide here-->
				</div>
			</div>
		</div>
	</div>

	<div class="chosee-plan__tabs">
		<ul class="nav nav-tabs" id="TabPlan" role="tablist">
			<li class="nav-item row-span-1" role="presentation">
				<button class="nav-link active" id="SMI-tab" data-bs-toggle="tab" data-bs-target="#SMI-tab-pane" type="button" role="tab" aria-controls="SMI-tab-pane" aria-selected="true">Perjalanan International</button>
			</li>
			<!-- <li class="nav-item row-span-2 col-span-1" role="presentation">
                    <button class="nav-link" id="SMD-tab" data-bs-toggle="tab" data-bs-target="#SMD-tab-pane" type="button" role="tab" aria-controls="SMD-tab-pane" aria-selected="false">Smart Medicare Domestik</button>
                </li> -->
		</ul>
		<div class="container-axa">
			<div class="tab-content" id="TabPlanContent">
				<div class="tab-pane fade show active" id="SMI-tab-pane"
					role="tabpanel" aria-labelledby="SMI-tab" tabindex="0">
					<div class="tab-content__inner">
						<div class="col-tab">
							<div id="select-anchor-wrapper" class="position-relative">
								<select class="input-control" name="select-anchor"
									id="select-anchor">
									<option value="#Sec-1">1. Jaminan Produk</option>
									<option value="#Sec-2">2. Perbandingan Plan</option>
									<option value="#Sec-3">3. FAQ</option>
								</select>
							</div>
							<div class="sticky-tab-pane">
								<ul class="sitemap-tabs">
									<li class="tab-link-pane Sec-1 is-active"><a href="#Sec-1">Jaminan
											Produk</a></li>
									<li class="tab-link-pane Sec-2"><a href="#Sec-2">Perbandingan
											Plan</a></li>
									<li class="tab-link-pane Sec-3"><a href="#Sec-3">FAQ</a></li>
								</ul>
								<ul class="download-tab">
									<li><a class="display-flex gap-4level" href="#brosur-section"> <span>Brosur</span>
									</a></li>
									<li><a class="display-flex gap-4level" href="#brosur-section"> <span>RIPLAY SmartTravel International</span>
									</a></li>
								</ul>
							</div>
						</div>
						<div class="col-tab">
							<section class="smart-mediacare-inter__benefit" id="Sec-1">
								<h1>Jaminan Produk</h1>
								<div class="card-benefit-wrapper">
									<div class="card-benefit">
										<img src="/o/mypage-theme/images/icon_sun-cream_2.svg">
										<h3>Biaya Pengobatan, Gigi dan Lainnya</h3>
											<p><b>Perawatan Medis di Luar Negeri</b></p>
											<p>Penggantian biaya pengobatan Tertanggung, seperti biaya rumah sakit, biaya operasi, termasuk pengobatan tradisional yang dialami/terjadi dikarenakan cidera atau sakit serta perawatan gigi karena kecelakaan, selama dalam perjalanan di luar negeri.</p>
											<br/>
											<p><b>Tindakan Lanjutan Medis di Indonesia</b></p>
											<p>Penggantian biaya pengobatan yang didapatkan di rumah sakit di Indonesia sebagai perawatan medis lanjutan dari perawatan yang telah didapatkan di luar negeri untuk cedera atau penyakit yang sama (maksimum 3 bulan setelah Anda kembali dari luar negeri).</p>
									</div>
									<div class="card-benefit">
										<img src="/o/mypage-theme/images/icon_sun-cream_2.svg">
										<h3>Kecelakaan Diri</h3>
											<p>Ketika Kecelakaan terjadi selama perjalanan dan menyebabkan :</p>
											<br/>
											<p>a)Kematian dalam 12 (dua belas) bulan sejak tanggal Kecelakaan; atau</p>
											<p>b)Ketidakmampuan Total dan Permanen dalam 12 (dua belas) bulan sejak tanggal Kecelakaan.</p>
									</div>
									<div class="card-benefit">
										<img src="/o/mypage-theme/images/icon_sun-cream_2.svg">
										<h3>Evakuasi Medis Darurat dan Repatriasi</h3>
											<p>AXA akan membayar kembali pemindahan Anda di bawah pengawasan medis, termasuk biaya transportasi dan pasokan medis yang harus dikeluarkan untuk evakuasi/repatriasi. 
Keputusan apa pun tentang evakuasi/ repatriasi Tertanggung akan dilakukan secara eksklusif dan bersama-sama oleh tim dokter yang hadir dan tim medis AXA atau perwakilan kami.
Biaya Medis yang dikeluarkan untuk evakuasi harus dicakup dalam Jaminan Biaya Pengobatan, Gigi dan Lainnya dan AXA akan memberikan penggantian sesuai dengan limit pertanggungan untuk biaya evakuasi dan repatriasi medis.</p>
									</div>
									<div class="card-benefit">
										<img src="/o/mypage-theme/images/icon_sun-cream_2.svg">
										<h3>Pemulangan Jenazah</h3>
											<p>Biaya pengangkutan jenazah Anda kembali ke Indonesia atau</p>
											<p>Biaya penguburan atau kremasi lokal di negara yang Anda kunjungi (di luar negeri)</p> 
											<p>Biaya wajar yang relevan untuk peti mati, pembalseman dan kremasi (khusus pemakaman di Luar Negeri), jika dipilih, tetapi tidak untuk biaya yang terkait dengan upacara atau ritual keagamaan.</p>
									</div>
								</div>
							</section>
							<section class="smart-mediacare-inter__table" id="Sec-2">
								<h1>Perbandingan Plan</h1>
								<div class="plan-comparation"></div>
							</section>
							
							<!-- start faq -->
							<section class="smart-mediacare-inter__faq" id="Sec-3">
							<h1>Frequently Asked Question Asuransi SmartTravel Internasional (<em>SmartTravel International Insurance</em>)</h1>
							<%= smartTravelFaq %>
							</section>
							<!--  end faq -->
							
							<div class="smart-mediacare-inter__download" id="brosur-section">
								<h1>Unduh</h1>
								<div class="table-wrapper">
									<table class="table-axa">
									<%
    // Get the current date
    Date today = new Date();
    
    // Format the date
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
    String formattedDate = formatter.format(today);
%>
									
                                            <tr>
                                                <td><i class="icon file-pdf"></i></td>
                                                <td>
                                                    <div class="td-inner">
                                                        <p class="normal-case letter-spacing-0px text-16px">Brosur SmartTravel Internasional</p>
                                                    </div>
                                                </td>
                                                <td><p class="date text-14px uppercase letter-spacing-1px"><%= formattedDate %></p></td>
                                                <td>
                                                    <div class="text-center">
                                                        <a href="<%= brochureLink %>" target="_blank" class="btn btn--dark-blue block text-12px text-center">
                                                            <span class="position-relative z-10">Download</span>
                                                            <svg class="position-relative z-10 inline-block vertical-align-min-2px" xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 17 16" fill="none">
                                                                <path d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                                                            </svg>
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                            
                                            <tr>
                                                <td><i class="icon file-pdf"></i></td>
                                                <td>
                                                    <div class="td-inner">
                                                        <p class="normal-case letter-spacing-0px text-16px">RIPLAY SmartTravel Internasional</p>
                                                    </div>
                                                </td>
                                                <td><p class="date text-14px uppercase letter-spacing-1px"><%= formattedDate %></p></td>
                                                <td>
                                                    <div class="text-center">
                                                        <a href="<%=riplayLink %>" target="_blank" class="btn btn--dark-blue block text-12px text-center">
                                                            <span class="position-relative z-10">Download</span>
                                                            <svg class="position-relative z-10 inline-block vertical-align-min-2px" xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 17 16" fill="none">
                                                                <path d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                                                            </svg>
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
										
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="SMD-tab-pane" role="tabpanel"
					aria-labelledby="SMD-tab" tabindex="0"></div>
			</div>
		</div>
	</div>
</section>

<!-- sticky plan -->
<%@include file="/includes/sticky.jsp"%>
<!-- end sticky plan -->

<script type="text/javascript">
	if (pc !== "") {
		$('input[name="PromoCode"]').val(pc);
	}
</script>

<div class="banner-bottom">
	<div class="banner-bottom__inner">
		<div class="col align-self-center">
			<div class="col--inner">
				<h1>
					Klaim mudah <br />dengan AXA MyInsurance
				</h1>
				<a class="btn btn__agency btn--white" href="<%= myInsuranceLink %>" target="_blank"> <span
					class="position-relative order-10">lihat sekarang</span>
				</a>
			</div>
		</div>
		<div class="col">
			<img src="/o/mypage-theme/images/banner_teman_emma.jpg" alt="">
		</div>
	</div>
</div>

<!-- Modal Warning -->
<div class="modal modal-axa-smarttravel-theme width-full fade" id="modalAlert" tabindex="-1" style="display: none;" aria-labelledby="modalAlertLabel" aria-hidden="true">
	<div class="modal-max-w-430px modal-axa-smarttravel-theme-dialog modal-dialog modal-axa-smarttravel-theme-dialog-centered">
		<div class="modal-axa-smarttravel-theme-content">
			<div
				class="modal-axa-smarttravel-theme-body agency__text-center p-80px-40px-0px-40px position-relative">
				<svg class="w-100px-h-100px m-0-auto-20px-auto"
					xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100"
					fill="none">
						<path
						d="M50.0017 54.0462V33.8864M50.0017 68.9888V69.166M75.2014 85.956H24.802C17.9177 85.956 12.108 81.3551 10.2802 75.0604C9.49989 72.3733 10.4586 69.5745 11.9251 67.1915L37.1248 21.2417C43.0288 11.6476 56.9746 11.6476 62.8787 21.2418L88.0783 67.1915C89.5448 69.5745 90.5035 72.3733 89.7232 75.0603C87.8954 81.3551 82.0857 85.956 75.2014 85.956Z"
						stroke="#1F1F9C" stroke-width="8.33333" stroke-linecap="round"
						stroke-linejoin="round" />
					</svg>
				<h1
					class="text-axa-grey-800 font-publico font-bold text-32px mb-15px">Peringatan!</h1>
				<p class="text-axa-grey-600 mb-20px">Apakah anda yakin
					membatalkan proses ini?</p>
			</div>
			<div
				class="modal-axa-smarttravel-theme-footer flex-justify-between p-20px-30px mt-12">
				<button class="btn-no text-14px agency__uppercase align-self-center"
					data-bs-toggle="modal" data-bs-target="#ModalCreateReminder"
					aria-label="Close">Tidak</button>
				<button type="button"
					class="btn btn__agency btn--dark-blue btn-close p-12px-25px-10px-25px"
					type="button" data-bs-dismiss="modal" aria-label="Close"
					aria-controls="login">
					<span class="position-relative order-50"> Iya <svg
							class="display-inline-block position-relative top-min-1px left-6px"
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							viewBox="0 0 16 16" fill="none">
								<path
								d="M5.22353 4L11.9059 4.09412M11.9059 4.09412L12 10.7765M11.9059 4.09412L4 12"
								stroke="white" stroke-width="2" stroke-linecap="round"
								stroke-linejoin="round" />
							</svg>
					</span>
				</button>
			</div>
		</div>
	</div>
</div>

<div class="modal-plan-description-wrapper"></div>

    <!-- Modal -->
    <div class="modal modal-axa-smarttravel fade" id="moreinfoModal" tabindex="-1" aria-labelledby="moreinfoModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog modal-axa-smarttravel-dialog modal-lg">
            <div class="modal-content modal-axa-smarttravel-content">
                <div class="modal-header modal-axa-smarttravel-header">
                    <h1 class="modal-title fs-5" id="moreinfoModalLabel">Info Tambahan</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                        <i class="far fa-times fa-fw"></i>
                    </button>
                </div>
                <div class="modal-body modal-axa-smarttravel-body">
                    <h3>Bagasi dan Barang Milik Pribadi</h3>
                    <p>
                        Jika saat Perjalanan di luar negeri, Anda kehilangan paspor dan tiket perjalanan Anda yang berada dalam kepemilikan Anda karena pencurian atau pencurian dengan kekerasan
                    </p>
                </div>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function () {
    	  /* delete bg-white default liferay */

    	  var contentSection = document.getElementById("content");
    	  if (contentSection) {
    	    contentSection.classList.remove("bg-white");
    	  }
    	});

    </script>
    
    <%@ include file="/includes/footer.jsp"%>
