<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page
	import="com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.DetailInternationalTravel"%>
<%@page import="com.mypage.leads.service.CustomerLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.mypage.leads.service.LeadsLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.Leads"%>
<%@ include file="../init.jsp"%>

<%
	String _datainfo = (String) renderRequest.getAttribute("_data-info");
	String _dataItemUtama = (String) renderRequest.getAttribute("item-utama");
	String _dataFiturUtama = (String) renderRequest.getAttribute("fitur-utama");
	String _dataItemManfaat = (String) renderRequest.getAttribute("item-manfaat");
	String _dataItemResiko = (String) renderRequest.getAttribute("item-resiko");
	String _dataItemBiaya = (String) renderRequest.getAttribute("item-biaya");
	String _dataItemKecuali = (String) renderRequest.getAttribute("item-pengecualian");
	String _dataItemSyarat = (String) renderRequest.getAttribute("item-persyaratan");
	String _dataItemSimulasi = (String) renderRequest.getAttribute("item-simulasi");
	String _dataItemInfoTambahan = (String) renderRequest.getAttribute("item-info-tambahan");
	String _dataItemCatatanPenting = (String) renderRequest.getAttribute("item-catatan-penting");
	String _dataItemDisclaimer = (String) renderRequest.getAttribute("item-disclaimer");

	String _riplayVersi = (String) renderRequest.getAttribute("riplay-version");
	String capitalizedVersionRiplay = _riplayVersi.substring(0, 1).toUpperCase()
			+ _riplayVersi.substring(1).toLowerCase();

	String portalURL = PortalUtil.getPortalURL(request);
	String redirectPaymentURL = portalURL + "/o/api/sti/process";
%>

<script src="<%=request.getContextPath()%>/js/main.js"
	type="text/javascript"></script>

<%-- Membuat URL untuk payment.jsp --%>
<portlet:renderURL var="paymentURL">
	<portlet:param name="jspPage" value="/dashboard/payment.jsp" />
</portlet:renderURL>

<header class="hero">
	<img src="/o/mypage-theme/images/step2hero.png" alt="herostep2"
		class="width-full height-full">
</header>


<!-- navbar -->
<%@ include file="navbar.jsp"%>


<!-- step bar -->
<div class="stepper-wrapper">
	<div class="stepper-item completed">
		<div class="step-counter"></div>
		<div class="step-name agency__uppercase">Pilih Perlindungan</div>
	</div>
	<div class="stepper-item completed">
		<div class="step-counter"></div>
		<div class="step-name agency__uppercase">Data Pemegang Polis</div>
	</div>
	<div class="stepper-item active">
		<div class="step-counter"></div>
		<div class="step-name agency__uppercase">Persetujuan</div>
	</div>
	<div class="stepper-item">
		<div class="step-counter"></div>
		<div class="step-name agency__uppercase">Pembayaran</div>
	</div>
</div>


<section id="content" class="dashboard agency__text-343C3D">
	<div class="dashboard-riplay">
		<div class="container-riplay">
			<div class="dashboard-riplay__inner">
				<div class="dashboard-left agency__bg-white">
					<div class="dashboard-left__riplay">
						<h1>
							Ringkasan Informasi Produk dan Layanan (RIPLAY) Versi
							<%=capitalizedVersionRiplay%></h1>

						<%=_datainfo%>

						<div class="accordion-wrapper">
							<div id="accordionRiplay" class="accordion">

								<!-- item utama -->
								<%=_dataFiturUtama%>

								<!-- manfaat -->
								<%=_dataItemManfaat%>

								<!-- resiko -->
								<%=_dataItemResiko%>

								<!-- biaya -->
								<%=_dataItemBiaya%>

								<!-- pengecualian -->
								<%=_dataItemKecuali%>

								<!-- syarat -->
								<%=_dataItemSyarat%>

								<!-- simulasi -->
								<%=_dataItemSimulasi%>

								<!-- info tambahan -->
								<%=_dataItemInfoTambahan%>

							</div>
						</div>

						<div class="notes-wrapper">
							<div class="notes">
								<p>Catatan Penting:</p>
							</div>
							<!-- <div class="list-notes">
								<ul>
									<li>Ringkasan Informasi Produk dan Layanan ini dibuat dan
										dipersiapkan oleh PT AXA Insurance Indonesia dan dipergunakan
										sebagai informasi bagi Anda mengenai produk Asuransi
										SmartTravel Internasional (<em>SmartTravel International
											Insurance</em>) dari PT AXA Insurance Indonesia.
									</li>
									<li>Ringkasan Informasi Produk dan Layanan ini bukan
										merupakan Kontrak Asuransi maupun bagian dari Polis Asuransi.</li>
									<li>Bagian dari premi yang berupa biaya akuisisi dapat
										dialokasikan sebagai diskon bagi pihak tertanggung.</li>
									<li>Produk yang dipasarkan adalah Produk Asuransi.</li>
									<li>Semua Pihak yang membaca dan menggunakan Ringkasan
										Informasi Produk dan Layanan ini agar memperhatikan
										syarat-syarat, ketentuan dan penggunaan yang berlaku.</li>
									<li>Apabila terdapat pertanyaan, keluhan atau informasi
										lanjutan, dapat menghubungi PT AXA Insurance Indonesia
										Customer Care Center di 1500733, email ke <a
										href="mailto:customer.general@axa.co.id">customer.general@axa.co.id</a>
										atau melalui website di <a href="http://www.axa.co.id">www.axa.co.id</a>.
									</li>
									<li>Produk Asuransi ini telah mendapatkan persetujuan dari
										dan diawasi oleh Otoritas Jasa Keuangan (OJK).</li>
								</ul>
							</div> -->


							<!-- catatan penting -->
							<%=_dataItemCatatanPenting%>

						</div>


						<div class="disclaimer-wrapper">
							<div class="disclaimer">
								<p>Disclaimer (penting untuk dibaca) :</p>
							</div>
							<!-- <div class="list-disclaimer">
								<ul>
									<li>Anda telah membaca, menerima penjelasan, dan memahami
										produk Asuransi SmartTravel Internasional (<em>SmartTravel
											International Insurance</em>) sesuai Ringkasan Informasi Produk
										dan Layanan.
									</li>
									<li>Ringkasan Informasi Produk dan Layanan ini bukan
										merupakan bagian dari aplikasi pengajuan asuransi dan polis.</li>
									<li>Anda wajib untuk membaca, memahami dan menandatangani
										aplikasi pengajuan asuransi dan polis.</li>
									<li>Informasi yang tercakup dalam Ringkasan Informasi
										Produk dan Layanan ini berlaku sejak tanggal cetak dokumen
										sampai dengan adanya pembaharuan lebih lanjut dari PT AXA
										Insurance Indonesia.</li>
									<li>Anda harus membaca dengan teliti Ringkasan Informasi
										Produk dan Layanan ini dan berhak bertanya kepada pegawai PT
										AXA Insurance Indonesia atas semua hal terkait Ringkasan
										Informasi Produk dan Layanan ini.</li>
								</ul>
							</div> -->

							<!-- disclaimer -->
							<%=_dataItemDisclaimer%>
						</div>

						<div class="agreement-wrapper">
							<div class="statement-agreement">
								<p>
									Saya dengan ini menyatakan bahwa Saya telah membaca, menerima
									penjelasan dan memahami produk Asuransi SmartTravel sesuai
									Ringkasan Informasi Produk dan Layanan <sup>*</sup>
								</p>
							</div>
							<ul class="agreement">
								<li class="list-agreement">
									<div class="radio-custom-wrapper">
										<input id="yes-agree" class="radio-custom" name="type"
											type="radio"> <label for="yes-agree"
											class="radio-custom-label"><span>Ya</span></label>
									</div>
									<div class="radio-custom-wrapper">
										<input id="no-agree" class="radio-custom" name="type"
											type="radio"> <label for="no-agree"
											class="radio-custom-label"><span>Tidak</span></label>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="dashboard-left__agreement">
						<h1>Persetujuan</h1>
						<div class="accordion-wrapper__agreement">
							<div id="accordionAgreement" class="accordion">
								<div class="accordion-item__agreement">
									<div class="accordion-header" id="stayAgreementOne">
										<div class="accordion-button collapsed"
											data-bs-toggle="collapse"
											data-bs-target="#collapseAgreementOne" aria-expanded="true"
											aria-controls="collapseAgreementOne">
											<div class="accordion-button__inner">
												<div class="accordion-button__left">
													<div class="checkbox-custom-wrapper">
														<input id="edit-1" class="checkbox-custom trigger-check"
															name="edit-1" type="checkbox"> <label
															for="edit-1" class="checkbox-custom-label"></label>
													</div>
												</div>
												<div class="accordion-button__right">
													<div class="policy">
														<p>Saya sudah membaca dan menyetujui pernyataan dan
															penggunaan data pribadi</p>
													</div>
													<i
														class="fas fa-chevron-down align-self-center agency__text-center"></i>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseAgreementOne"
										class="accordion-collapse collapse show">
										<div class="accordion-body">
											Dengan ini Saya/Kami menyetujui bahwa data dan informasi
											pribadi yang Saya/Kami berikan kepada PT AXA Insurance
											Indonesia dapat dikirimkan oleh PT AXA Insurance Indonesia
											kepada pihak lain yang bekerjasama dengan dan/atau ditunjuk
											oleh PT AXA Insurance Indonesia, Regulator dan Pihak yang
											Berwenang dan/atau Asosiasi sehubungan dengan keperluan
											operasional PT AXA Insurance Indonesia termasuk namun tidak
											terbatas pada keperluan pertanggungan asuransi Saya/Kami,
											proses penutupan asuransi, proses reasuransi dan klaim. <br>
											<br>Dengan mencentang pernyataan ini, maka Anda
											menyatakan telah memberikan persetujuan.
										</div>
									</div>
								</div>
								<div class="accordion-item__agreement">
									<div class="accordion-header" id="stayAgreementTwo">
										<div class="accordion-button collapsed"
											data-bs-toggle="collapse"
											data-bs-target="#collapseAgreementTwo" aria-expanded="false"
											aria-controls="collapseAgreementTwo">
											<div class="accordion-button__inner">
												<div class="accordion-button__left">
													<div class="checkbox-custom-wrapper">
														<input id="edit-2" class="checkbox-custom trigger-check"
															name="edit-2" type="checkbox"> <label
															for="edit-2" class="checkbox-custom-label"></label>
													</div>
												</div>
												<div class="accordion-button__right">
													<div class="policy">
														<p>Saya sudah membaca dan menyetujui pernyataan kuasa
															dan persetujuan berikut</p>
													</div>
													<i
														class="fas fa-chevron-down align-self-center agency__text-center"></i>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseAgreementTwo"
										class="accordion-collapse collapse show">
										<div class="accordion-body">
											Dengan ini Saya/Kami menyetujui bahwa data dan informasi
											pribadi yang Saya/Kami berikan kepada PT AXA Insurance
											Indonesia dapat dikirimkan oleh PT AXA Insurance Indonesia
											kepada pihak lain yang bekerjasama dengan dan/atau ditunjuk
											oleh PT AXA Insurance Indonesia, Regulator dan Pihak yang
											Berwenang dan/atau Asosiasi sehubungan dengan keperluan
											operasional PT AXA Insurance Indonesia termasuk namun tidak
											terbatas pada keperluan pertanggungan asuransi Saya/Kami,
											proses penutupan asuransi, proses reasuransi dan klaim. <br>
											<br>Dengan mencentang pernyataan ini, maka Anda
											menyatakan telah memberikan persetujuan.
										</div>
									</div>
								</div>
								<div class="accordion-item__agreement">
									<div class="accordion-header" id="stayAgreementThree">
										<div class="accordion-button collapsed"
											data-bs-toggle="collapse"
											data-bs-target="#collapseAgreementThree" aria-expanded="true"
											aria-controls="collapseAgreementThree">
											<div class="accordion-button__inner">
												<div class="accordion-button__left">
													<div class="checkbox-custom-wrapper">
														<input id="edit-3" class="checkbox-custom trigger-check"
															name="edit-3" type="checkbox"> <label
															for="edit-3" class="checkbox-custom-label"></label>
													</div>
												</div>
												<div class="accordion-button__right">
													<div class="policy">
														<p>Saya bersedia untuk menerima berita dan informasi
															dari AXA</p>
													</div>
													<i
														class="fas fa-chevron-down align-self-center agency__text-center"></i>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseAgreementThree"
										class="accordion-collapse collapse show">
										<div class="accordion-body">
											Dengan ini Saya/Kami menyetujui untuk dilakukan pemasaran,
											penawaran produk dan aktivitas promosi lainnya melalui sarana
											komunikasi pribadi Saya/Kami termasuk namun tidak terbatas
											pada email, telepon, SMS dan media komunikasi online lainnya.
											<br> <br>Dengan mencentang pernyataan ini, maka
											Anda menyatakan telah memberikan persetujuan.
										</div>
									</div>
								</div>
								<div class="accordion-item__agreement">
									<div class="accordion-header" id="stayAgreementFour">
										<div class="accordion-button collapsed"
											data-bs-toggle="collapse"
											data-bs-target="#collapseAgreementFour" aria-expanded="true"
											aria-controls="collapseAgreementFour">
											<div class="accordion-button__inner">
												<div class="accordion-button__left">
													<div class="checkbox-custom-wrapper">
														<input id="edit-4" class="checkbox-custom trigger-check"
															name="edit-4" type="checkbox"> <label
															for="edit-4" class="checkbox-custom-label"></label>
													</div>
												</div>
												<div class="accordion-button__right">
													<div class="policy">
														<p>Pernyataan PT AXA Insurance Indonesia</p>
													</div>
													<i
														class="fas fa-chevron-down align-self-center agency__text-center"></i>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseAgreementFour"
										class="accordion-collapse collapse show">
										<div class="accordion-body">
											<ul>
												<li>PT AXA Insurance Indonesia berkomitmen untuk
													menjaga kerahasiaan dan melaksanakan pemrosesan data
													pribadi secara sah sesuai dengan ketentuan peraturan
													perundang-undangan yang berlaku, sampai dengan batas waktu
													yang telah ditentukan sesuai dengan kebijakan retensi PT
													AXA Insurance Indonesia kecuali penyimpanan lebih lanjut
													diperlukan untuk memenuhi periode retensi yang lebih lama
													untuk memenuhi persyaratan operasional, hukum, peraturan,
													pajak, atau akuntansi PT AXA Insurance Indonesia.</li>
												<li>PT AXA Insurance Indonesia akan menghancurkan atau
													menganonimkan dari catatan dan sistem cadangan PT AXA
													Insurance Indonesia sesuai dengan kebijakan retensi PT AXA
													Insurance Indonesia kecuali penyimpanan lebih lanjut
													diperlukan untuk memenuhi periode retensi yang lebih lama
													untuk memenuhi persyaratan operasional, hukum, peraturan,
													pajak, atau akuntansi PT AXA Insurance Indonesia.</li>
												<li>PT AXA Insurance Indonesia memberikan hak akses
													untuk mendapatkan salinan, melengkapi dan/atau
													memperbaharui kesalahan data dan informasi pribadi Nasabah
													berdasarkan permintaan tertulis dari Nasabah.</li>
												<li>PT AXA Insurance Indonesia memberikan hak kepada
													Nasabah untuk menarik kembali persetujuan mengenai
													pemrosesan data pribadi Nasabah, mengakhiri pemrosesan,
													menghapus, dan/atau memusnahkan data pribadi Nasabah, serta
													hak-hak lainnya sesuai dengan ketentuan peraturan
													perundang-undangan yang berlaku berdasarkan permintaan
													tertulis dari Nasabah.</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="dashboard-right agency__bg-white">
					<div class="dashboard-right__summary">
						<div class="products">
							<!-- <div class="first-product">
								<div class="description">
									<span>Perjalanan Internasional</span>
									<h1>Plan Spesial Asia</h1>
									<span>Proteksi Anda</span>
								</div>
								<div class="table-wrapper agency__my-auto mt-2level">
									<table class="table table-summary">
										<tbody>
											<tr>
												<td class="pl-25px">5 Hari</td>
												<td class="agency__text-axa-ocean-100">USD 3.789</td>
											</tr>
											<tr>
												<td class="pl-25px">Biaya Polis</td>
												<td class="agency__text-axa-ocean-100">USD 32</td>
											</tr>
											<tr>
												<td class="pl-25px">Materai</td>
												<td class="agency__text-axa-ocean-100">USD 7</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div> -->

							<!-- <div class="second-product">
								<div class="description">
									<span>Perjalanan Domestik</span>
									<h1>Plan Gold</h1>
									<span>Proteksi Anda</span>
								</div>
								<div class="table-wrapper my-auto mt-2">
									<table class="table table-summary">
										<tbody>
											<tr>
												<td class="pl-25px">1 Hari</td>
												<td class="agency__text-axa-ocean-100">USD 3.789</td>
											</tr>
											<tr>
												<td class="pl-25px">Biaya Polis</td>
												<td class="agency__text-axa-ocean-100">USD 32</td>
											</tr>
											<tr>
												<td class="pl-25px">Materai</td>
												<td class="agency__text-axa-ocean-100">USD 7</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div> -->

							<!-- render plan here -->
							<div class="container_sideplan"></div>

							<div class="summary-product">
								<div class="input-col">
									<label class="label__travel" for="">Kode Promo</label>
									<div class="input-group input-group-axa">
										<input
											class="input-control input-control-axa normal-case input-control--outline"
											type="text" id="" placeholder="Masukkan Kode Promo">
										<span class="btn-group btnClear"> <svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="17"
												viewBox="0 0 16 17" fill="none">
                                                    <path
													d="M2.11861 10.4996C2.95844 13.0548 5.36373 14.8996 8.1999 14.8996C11.7345 14.8996 14.5999 12.0342 14.5999 8.49961C14.5999 4.96499 11.7345 2.09961 8.1999 2.09961C5.831 2.09961 3.7627 3.38664 2.65611 5.29961M2.11861 4.67437L3.00016 5.49967M4.5999 6.09961H1.3999V2.89961L4.5999 6.09961Z"
													stroke-width="1.25" stroke-linecap="round"
													stroke-linejoin="round"></path>
                                                </svg>
										</span>
									</div>
								</div>

								<!-- <div class="table-wrapper agency__my-auto mt-4level">
									<table class="table table-discount mt-4level">
										<tbody>
											<tr>
												<td>Diskon</td>
												<td class="agency__text-axa-ocean-100 pl-85px">USD 500</td>
											</tr>
											<tr>
												<td>Total Premi</td>
												<td class="total-premi pl-85px">USD 4.233</td>
											</tr>
											<tr>
												<td></td>
												<td class="cost-total-premi pl-85px">USD 3.823</td>
											</tr>
											<tr>
												<td></td>
												<td class="agency__text-axa-ocean-100 pl-85px">IDR
													55.093.800</td>
											</tr>
										</tbody>
									</table>
								</div> -->

								<!-- render diskon here -->
								<div class="container_sidepanel_discount"></div>

								<div class="mt-5level agency__text-center divbutton-submit">
									<a class="btn__agency btn--dark-blue width-full"
										onclick="proccessPayment()"> <span
										class="position-relative agency__uppercase agency__pointer">Lanjut
											ke Pembayaran <i class="fas fa-arrow-right"></i>
									</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
</section>



<!-- footer -->
<%@ include file="footer.jsp"%>

<script src="<%=request.getContextPath()%>/dashboard/js/main.js"
	type="text/javascript"></script>

<script>

var redirectPaymentURL = "<%=redirectPaymentURL%>";

function proccessPayment() {
	  // Retrieve data from sessionStorage
	  let formDetail = sessionStorage.getItem("SmartTravelInternationalFormDetail");
	  let calculation = sessionStorage.getItem("SmartTravelInternationalCalculation");
	  let payloadPolicy = sessionStorage.getItem("SmartTravelInternationalDataPayload");
	  
	  payloadPolicy = JSON.parse(payloadPolicy);

		// Mengambil insured dan token
		let listInsured = payloadPolicy.insured;
		
		 listInsured.forEach(insured => {
		    delete insured._fotoktp;
		});
	  
		// Mengambil insured dan token
		//let policyHolderObject = payloadPolicy.policyholder;
		

	  // Parse the retrieved data from JSON strings to JavaScript objects
	  let parsedFormDetail = formDetail ? JSON.parse(formDetail) : {};
	  let parsedCalculation = calculation ? JSON.parse(calculation) : {};
	  
	  // Combine the data into a single payload object
	  let existingSession = {
	    formDetail: parsedFormDetail,
	    calculation: parsedCalculation,
	    listInsured: listInsured
	    //policyHolderObject: policyHolderObject
	    
	  };
	  
	  console.log('final all payload>>' , existingSession);

	  // Make the AJAX request
	  $.ajax({
	    url: redirectPaymentURL,
	    type: "POST",
	    contentType: "application/json",
	    data: JSON.stringify(existingSession), // Convert the payload to a JSON string
	    success: function (response) {
	      console.log(response);
	      
	      window.location.href = response.redirectTo;
	     
	    },
	    error: function (xhr, status, error) {
	      console.error("Error:", error);
	    },
	  });
	}


//get main benefit premi
var totalMainBenefitPremium, totalMainBenefitPremiumInIDR;
var totalAdditionalBenefitPremium,  totalAdditionalBenefitPremiumInIDR;


var listAdditionalBenefit = null;
var jaminanList = null;

const calculation = JSON.parse(sessionStorage.getItem("SmartTravelInternationalCalculation"));

if(sessionStorage.getItem(_smartTravelInternationalCalculation)) {
	let formDetail = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
	let choosenPlan = formDetail.ChoosenPlan;
	
	let calculation = JSON.parse(sessionStorage.getItem(_smartTravelInternationalCalculation));
	
	for(const plan of calculation.AvailablePlans) {
		if(plan.PlanName === choosenPlan) {
			
			//get main total
		    totalMainBenefitPremium = plan.TotalMainBenefitPremium;
		    totalMainBenefitPremiumInIDR = plan.TotalMainBenefitPremiumInIDR;
		    
		    //get additional total
		    totalAdditionalBenefitPremium = plan.TotalAdditionalBenefitPremium; 
		    totalAdditionalBenefitPremiumInIDR = plan.TotalAdditionalBenefitPremiumInIDR; 
		    
		    listAdditionalBenefit = plan.AdditionalBenefitList;
		    
		    console.log(totalMainBenefitPremium);
		    console.log(totalMainBenefitPremiumInIDR);
		    
		    console.log(totalAdditionalBenefitPremium);
		    console.log(totalAdditionalBenefitPremiumInIDR);
		    
		    console.log(listAdditionalBenefit);
		    
		    console.log(transformJson(listAdditionalBenefit));
		    
		    jaminanList = transformJson(listAdditionalBenefit);
		    
		    console.log('final json need>>', jaminanList);
			
		}
	}
}

function transformJson(data) {
	  // Object untuk mengelompokkan items berdasarkan "Benefit Type"
	  const groupedData = {};

	  data.forEach(item => {
	    const { "Benefit Name": benefitName, "Benefit Type": benefitType } = item;

	    if (!groupedData[benefitType]) {
	      groupedData[benefitType] = [];
	    }

	    groupedData[benefitType].push(benefitName);
	  });

	  // Konversi groupedData menjadi array dengan struktur yang diinginkan
	  const result = Object.keys(groupedData).map(benefitType => ({
	    title: benefitType,
	    items: groupedData[benefitType]
	  }));

	  return result;
	}

var _adultTotal, _arrivalDate, _choosenPlan, _currency, _departureDate, _policyCost, _stamp, _totalDays, _travelType, _travellerType;

//Mendapatkan data dari sessionStorage
const formDetail = JSON.parse(sessionStorage.getItem("SmartTravelInternationalFormDetail"));
if(formDetail) {
    _adultTotal = formDetail.AdultTotal;
    _arrivalDate = formDetail.ArrivalDate;
    _choosenPlan = formDetail.ChoosenPlan;
    _currency = formDetail.Currency;
    _departureDate = formDetail.DepartureDate;
    _policyCost = formDetail.PolicyCost;
    _stamp = formDetail.Stamp;
    _totalDays = formDetail.TotalDays;
    _travelType = formDetail.TravelType;
    _travellerType = formDetail.TravellerType;

    // Console logs
    console.log("Adult Total:", _adultTotal);
    console.log("Arrival Date:", _arrivalDate);
    console.log("Choosen Plan:", _choosenPlan);
    console.log("Currency:", _currency);
    console.log("Departure Date:", _departureDate);
    console.log("Policy Cost:", _policyCost);
    console.log("Stamp:", _stamp);
    console.log("Total Days:", _totalDays);
    console.log("Travel Type:", _travelType);
    console.log("Traveller Type:", _travellerType);
    
    //render sideplan
    let totalPremiJaminan = totalMainBenefitPremium + totalAdditionalBenefitPremium;
    renderSidePanelPlanFromFormDetail(formDetail, totalPremiJaminan);
    
  	//render sidepanel discount
    renderDiscountTable(formDetail, totalPremiJaminan);
    
} else {
    console.error("Data 'SmartTravelInternationalFormDetail' tidak ditemukan di sessionStorage.");
}


//get data payload
var _namePolicyHolder, _agePolicyHolder, _addressPolicyHolder, _genderPolicyHolder, _ageSpouse, _genderSpouse;

const dataPayload = JSON.parse(sessionStorage.getItem("SmartTravelInternationalDataPayload"));
if (dataPayload) {
    // Object payload.policyholder
    const pasanganObject = dataPayload.insured.find(function(item) {
        return item._relationship === "Pasangan";
    });
    const anakObjects = dataPayload.insured.filter(function(item) {
        return item._relationship === "Anak" || item._relationship === "Anak / Pelajar";
    });

    const jumlahAnak = anakObjects.length; // Count the number of children

    // Extract policyholder details
    _namePolicyHolder = dataPayload.policyholder._name;
    _agePolicyHolder = dataPayload.policyholder._age;
    _addressPolicyHolder = dataPayload.policyholder._alamat;
    _genderPolicyHolder = dataPayload.policyholder._gender;

    // Extract spouse details if available
    if (pasanganObject) {
        _ageSpouse = pasanganObject._age;
        _genderSpouse = pasanganObject._gender;
    } else {
        _ageSpouse = null;
        _genderSpouse = null;
    }

    // Collect all ages for min and max calculation
    const ages = [dataPayload.policyholder._age]; // Start with the policyholder's age

    if (pasanganObject) {
        ages.push(pasanganObject._age); // Add spouse's age if available
    }

    if (anakObjects) {
        anakObjects.forEach(function(child) {
            ages.push(child._age); // Add ages of children
        });
    }

    // Find the minimum and maximum ages
    const minAge = Math.min(...ages);
    const maxAge = Math.max(...ages);

    // Helper function to format ages with "dan"
    function formatAges(ages) {
        if (ages.length === 1) {
            return ages[0];
        }
        const lastAge = ages.pop();
        return ages.join(", ") + " dan " + lastAge;
    }

    // Update or remove the HTML element with the class .member
    document.querySelectorAll('.member').forEach(function(element) {
        if (pasanganObject && jumlahAnak > 0) {
            element.textContent = "dan pasangannya serta " + jumlahAnak + " orang anaknya";
        } else if (pasanganObject) {
            element.textContent = "dan pasangannya";
        } else if (jumlahAnak > 0) {
            element.textContent = "dan " + jumlahAnak + " orang anaknya";
        } else {
            element.remove(); // Remove the element if there is no spouse or children
        }
    });

    // Update or remove the HTML element with the class .member_with_age
    document.querySelectorAll('.member_with_age').forEach(function(element) {
        // Add "masing-masing" only if there are more than one child
        const masingMasingText = jumlahAnak > 1 ? " masing-masing" : "";

        if (pasanganObject && jumlahAnak > 0) {
            // Collect ages of children and format them
            const agesOfChildren = anakObjects.map(function(child) {
                return child._age + " tahun";
            });
            const formattedAges = formatAges(agesOfChildren);

            element.textContent = "dan pasangannya berusia " + _ageSpouse + " tahun serta " + jumlahAnak +
                " orang anaknya " + masingMasingText + " berusia " + formattedAges;
        } else if (pasanganObject) {
            element.textContent = "dan pasangannya berusia " + _ageSpouse + " tahun";
        } else if (jumlahAnak > 0) {
            // Collect ages of children and format them
            const agesOfChildren = anakObjects.map(function(child) {
                return child._age + " tahun";
            });
            const formattedAges = formatAges(agesOfChildren);

            element.textContent = "dan " + jumlahAnak + " orang anaknya" + masingMasingText + " berusia " + formattedAges;
        } else {
            element.remove(); // Remove the element if there is no spouse or children
        }
    });

    // Update or remove the HTML element with the class .member_umum
    document.querySelectorAll('.member_umum').forEach(function(element) {
        let anakWording = "";
        if (jumlahAnak === 1) {
            anakWording = "anaknya";
        } else if (jumlahAnak > 1) {
            anakWording = "anak-anaknya";
        }

        let wording = "berkisar " + minAge + " s/d " + maxAge + " tahun";
        if (pasanganObject && jumlahAnak > 0) {
            wording = "dan pasangan serta " + anakWording + " adalah " + wording;
        } else if (pasanganObject) {
            wording = "dan pasangannya adalah " + wording;
        } else if (jumlahAnak > 0) {
            wording = "dan " + anakWording + " adalah " + wording;
        }

        element.textContent = wording;
    });

} else {
    console.error("Data 'SmartTravelInternationalDataPayload' tidak ditemukan di sessionStorage.");
}


// untuk tampung nama class di elemen html sama dengan nama item benefit yang di pilih dengan fungsi ada dibawah
var allItems = [];

//list benefit additional
const jaminanArray = jaminanList; //JSON.parse(jaminanList); 
console.log("Dummy jaminanArray:", jaminanArray);

function updateDataByClass() {
	console.log('UPDATE FUNCTION!!!');
	
	$(".nama").each(function() {
	    let namePrefix = _genderPolicyHolder === "F" ? "Nyonya" : "Tuan";
	    $(this).text(namePrefix + " " + capitalizeFirstLetter(_namePolicyHolder));
	});

	$(".tempat").each(function() {
		//$(this).text(capitalizeFirstLetter(_destionation));
		$(this).text(capitalizeFirstLetter('Asia'));
	});

	// Memformat tanggal dan memperbarui elemen
	$(".waktu").each(function() {
	    $(this).text(formatDate(_departureDate) + " s/d " + formatDate(_arrivalDate));
	});

	// Update plan
	$(".plan").each(function() {
		$(this).text(capitalizeFirstLetter(_choosenPlan));
	});

	// Update currency
	$(".currency").each(function() {
		$(this).text(_currency.toUpperCase());
	});
	
	//update currency
	$(".currency_name").each(function() {
	    if (_currency.toUpperCase() === "IDR") {
	        $(this).text("Rupiah");
	    } else {
	        $(this).text("US Dollar");
	    }
	});
	

	// Update usia
	$(".age").each(function() {
		$(this).text(_agePolicyHolder);
	});

	// Update usia pasangan
	/* $(".age_spouse").each(function() {
		$(this).text(_ageSpouse);
	}); */

	// Update total hari
	$(".total_hari").each(function() {
		$(this).text(calculation.TotalDays);
	});

	// Update jenis perjalanan
	$(".travel_type").each(function() {
		$(this).text(capitalizeFirstLetter(_travelType));
	});

	// Update jenis wisatawan
	$(".traveller_type").each(function() {
		$(this).text(capitalizeFirstLetter(_travellerType));		
	});
	
	
	// SET PREMI 
	// Call the function with the required values
	setPremiums(totalMainBenefitPremium, totalAdditionalBenefitPremium, calculation.Stamp);
	
}


//Function to render sidepanelplan for formDetail data
function renderSidePanelPlanFromFormDetail(formDetail, totalJaminanPremi) {
    // Container where the HTML will be appended
    const container = document.querySelector(".container_sideplan"); // Make sure you have a parent element with this class

    // Clear any existing content in the container
    container.innerHTML = "";

    // Create the main wrapper div
    const secondProductDiv = document.createElement("div");
    secondProductDiv.className = "second-product";

    // Create the description div
    const descriptionDiv = document.createElement("div");
    descriptionDiv.className = "description";

    // Create and append the span elements
    const travelTypeSpan = document.createElement("span");
    travelTypeSpan.textContent = "Perjalanan " + formDetail.TravelType;
    descriptionDiv.appendChild(travelTypeSpan);

    const planH1 = document.createElement("h1");
    planH1.style.marginBottom = "30px";
    planH1.textContent = 'Plan ' + formDetail.ChoosenPlan;
    descriptionDiv.appendChild(planH1);

    const protectionSpan = document.createElement("span");
    protectionSpan.textContent = "Proteksi Anda";
    descriptionDiv.appendChild(protectionSpan);

    // Append descriptionDiv to the main div
    secondProductDiv.appendChild(descriptionDiv);

    // Create the table wrapper div
    const tableWrapperDiv = document.createElement("div");
    tableWrapperDiv.className = "table-wrapper my-auto mt-2";

    // Create the table and tbody elements
    const table = document.createElement("table");
    table.className = "table table-summary";
    const tbody = document.createElement("tbody");

    // Create and append the rows
    const row1 = document.createElement("tr");
    const dayTd = document.createElement("td");
    dayTd.className = "pl-25px";
    dayTd.textContent = calculation.TotalDays + " Hari";
    const costTd = document.createElement("td");
    costTd.className = "agency__text-axa-ocean-100";
    //set total jaminan premi
    costTd.textContent = formDetail.Currency.toUpperCase() + " " + (calculation.Currency === 'IDR' ? formatToIDR(totalJaminanPremi) : formatCurrency(totalJaminanPremi));
    row1.appendChild(dayTd);
    row1.appendChild(costTd);
    tbody.appendChild(row1);

    const row2 = document.createElement("tr");
    const policyTd = document.createElement("td");
    policyTd.className = "pl-25px";
    policyTd.textContent = "Biaya Polis";
    const policyCostTd = document.createElement("td");
    policyCostTd.className = "agency__text-axa-ocean-100";
    //set biaya polis
    policyCostTd.textContent = formDetail.Currency.toUpperCase() + " " + (calculation.Currency === 'IDR' ? formatToIDR(calculation.PolicyCost) : formatCurrency(calculation.PolicyCost));
    row2.appendChild(policyTd);
    row2.appendChild(policyCostTd);
    tbody.appendChild(row2);

    const row3 = document.createElement("tr");
    const stampTd = document.createElement("td");
    stampTd.className = "pl-25px";
    stampTd.textContent = "Materai";
    const stampCostTd = document.createElement("td");
    stampCostTd.className = "agency__text-axa-ocean-100";
    //set materai
    stampCostTd.textContent = formDetail.Currency.toUpperCase() + " " + (calculation.Currency === 'IDR' ? formatToIDR(calculation.Stamp) : formatCurrency(calculation.Stamp));
    row3.appendChild(stampTd);
    row3.appendChild(stampCostTd);
    tbody.appendChild(row3);

    // Append tbody to table and table to tableWrapperDiv
    table.appendChild(tbody);
    tableWrapperDiv.appendChild(table);

    // Append tableWrapperDiv to the main div
    secondProductDiv.appendChild(tableWrapperDiv);

    // Append the main div to the container
    container.appendChild(secondProductDiv);
}


//Function to render HTML for the discount table
function renderDiscountTable(currency, totalJaminanPremi) {
	
	console.log('RENDER DISKON');
	
	let _stamp = calculation.Stamp;
    let _totalPremi = totalJaminanPremi + _stamp; 
    
    let _currency = formDetail.Currency.toUpperCase();
	
	
    // Container where the HTML will be appended
    const container = document.querySelector(".container_sidepanel_discount"); // Ensure this class exists

    // Create the main wrapper div
    const wrapperDiv = document.createElement("div");
    wrapperDiv.className = "table-wrapper agency__my-auto mt-4level";

    // Create the table and tbody elements
    const table = document.createElement("table");
    table.className = "table table-discount mt-4level";
    const tbody = document.createElement("tbody");

    // Create and append the first row for Discount
    const row1 = document.createElement("tr");
    const tdDiscount = document.createElement("td");
    tdDiscount.textContent = "Diskon";
    const tdDiscountValue = document.createElement("td");
    tdDiscountValue.className = "agency__text-axa-ocean-100";
    tdDiscountValue.style.paddingLeft = "40px";
    //set diskon
    tdDiscountValue.textContent = formDetail.Discount; // Replace with dynamic value if needed formDetail.Discount
    row1.appendChild(tdDiscount);
    row1.appendChild(tdDiscountValue);
    tbody.appendChild(row1);

    // Create and append the second row for Total Premi based on currency
    const row2 = document.createElement("tr");
    const tdTotalPremi = document.createElement("td");
    tdTotalPremi.textContent = "Total Premi";
    const tdTotalPremiValue = document.createElement("td");
    tdTotalPremiValue.className = "agency__text-axa-ocean-100";
    tdTotalPremiValue.style.paddingLeft = "40px";
    tdTotalPremiValue.style.fontSize = "26px";
    tdTotalPremiValue.style.fontWeight = "600";
    tdTotalPremiValue.style.color = "rgb(58 94 148 / var(--tw-text-opacity))";
    //set premi
    tdTotalPremiValue.textContent = _currency +" "+ (calculation.Currency === 'IDR' ? formatToIDR(_totalPremi) : formatCurrency(_totalPremi));
        
   

    row2.appendChild(tdTotalPremi);
    row2.appendChild(tdTotalPremiValue);
    tbody.appendChild(row2);

    // Append tbody to table and table to wrapperDiv
    table.appendChild(tbody);
    wrapperDiv.appendChild(table);

    // Append the main div to the container
    container.appendChild(wrapperDiv);
}

function setPremiums(totalMainBenefitPremium, totalAdditionalBenefitPremium, _stamp) {
	console.log('call set premi');
    // Ensure values are numbers
    totalMainBenefitPremium = parseFloat(totalMainBenefitPremium);
    totalAdditionalBenefitPremium = parseFloat(totalAdditionalBenefitPremium);
    _stamp = parseFloat(_stamp);

    // Calculate total premi_jaminan and total premi
    let totalPremiJaminan = totalMainBenefitPremium + totalAdditionalBenefitPremium;
    let totalPremi = totalPremiJaminan + _stamp;

    // Update HTML elements
    $(".premi_jaminan_utama").each(function() {
        $(this).text(formatCurrency(totalMainBenefitPremium));
    });

    $(".premi_jaminan_tambahan").each(function() {
        $(this).text(formatCurrency(totalAdditionalBenefitPremium));
    });

    $(".total_premi_jaminan").each(function() {
        $(this).text(formatCurrency(totalPremiJaminan));
    });

    $(".biaya_materai").each(function() {
        $(this).text(formatCurrency(_stamp));
    });

    $(".total_premi").each(function() {
        $(this).text(formatCurrency(totalPremi));
    });
}

function capitalizeFirstLetter(string) {
    if (!string) return ""; // Handle empty string
    return string
        .toLowerCase()
        .split(" ")
        .map(word => word.charAt(0).toUpperCase() + word.slice(1))
        .join(" ");
}

function formatCurrency(value) {
    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
}

function formatToIDR(value) {
	  return value.toLocaleString('id-ID', {
	    minimumFractionDigits: 2,
	    maximumFractionDigits: 2
	  });
	}

function formatDate(dateStr) {
    var parts = dateStr.split('/');
    var day = parts[0];
    var month = parts[1];
    var year = parts[2];
    var months = {
        "Jan": "January", "Feb": "February", "Mar": "March", "Apr": "April",
        "May": "May", "Jun": "June", "Jul": "July", "Aug": "August",
        "Sep": "September", "Oct": "October", "Nov": "November", "Dec": "December"
    };
    return day + " " + months[month] + " " + year;
}


//Shorthand for $( document ).ready()
$(function() {

	//update 
	updateDataByClass();

	// Hide all div elements inside .jaminan_tambahan  IN MANFAAT ACCORDION
	$('.jaminan_tambahan > div').hide();

	// Loop through each jaminan and add its items to allItems
	jaminanArray.forEach(function(jaminan) {
		allItems = allItems.concat(
			jaminan.items.map(function(item) {
				return item.toLowerCase().replace(/\s+/g, '_');
			})
		);
	});

	console.log(allItems);
	//untuk mapping class div mana yang akan show berdasarkan benefit tambahan yang dipilih setelah di format dengan fungsi diatas
	allItems.forEach(function(item) {
		// Trim the string to get the part before the underscore
		let trimmedItem = item.split('_')[0];

		// Use jQuery to select divs that contain the class with the trimmed value
		$('.jaminan_tambahan > div').filter(function() {
			return $(this).attr('class').includes(trimmedItem);
		}).show();
	});



	// for SIMULASI ACCORDION
	var html = "";
	jaminanArray.forEach((jaminan, index) => {

		var letter = String.fromCharCode(65 + index); //start from A
		html += "<div>" + letter + ". " + jaminan.title + ":</div>";

		jaminan.items.forEach((item, itemIndex) => {
			var isLastItem = itemIndex === jaminan.items.length - 1;
			var style = isLastItem ? "margin-left: 15px; margin-bottom: 20px;" : "margin-left: 15px;";
			html += "<div style='" + style + "'>" + (itemIndex + 1) + ". " + item + "</div>";
		});
	});


	//set to container
	document.getElementById('jaminan-container').innerHTML = html;

});

document.addEventListener('DOMContentLoaded', function() {

	/* delete bg-white default liferay */

	var contentSection = document.getElementById('content');
	if (contentSection) {
		contentSection.classList.remove('bg-white');
	}

});

document.querySelectorAll('.trigger-check').forEach(
	function(checkbox) {
		checkbox.addEventListener('change', function() {
			const accordionCollapse = this.closest(
				'.accordion-item__agreement').querySelector(
				'.accordion-collapse');

			if (this.checked) {
				accordionCollapse.classList.remove('show');
			} else {
				accordionCollapse.classList.add('show');
			}
		});
	});




/* button clear kode promo */
const clearButtons = document.querySelectorAll('.btnClear');

clearButtons.forEach(button => {
	button.addEventListener('click', function() {
		const inputGroup = button.closest('.input-group-axa');
		const input = inputGroup.querySelector('.input-control-axa');

		input.value = '';
	});
});

</script>
