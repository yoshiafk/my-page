<%@ include file="../init.jsp"%>


<header class="hero">
	<img src="/o/mypage-theme/images/step2hero.png" alt="herostep2"
		class="width-full height-full">
</header>

<portlet:resourceURL id="/data/payment/report"
	var="loadDataPaymentReport" />

<section class="chosee-plan" id="changePlan">

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
		<div class="stepper-item completed">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Persetujuan</div>
		</div>
		<div class="stepper-item active">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Pembayaran</div>
		</div>
	</div>


	<!-- end step bar -->

	<div class="chosee-plan__tabs">
		<div class="container-axa">
			<div class="tab-content__sm">
				<div class="tab-pane fade show active" tabindex="0">
					<div class="tab-content__step2">
						<div class="col-tabstep2">
							<section class="smart-mediacare-inter__table" id="Sec-1">
								<div class="panel-cover pt-10level px-10level">

									<h1>Pembayaran</h1>

									<h3 class="mt-10level">Pilih metode pembayaran yang ingin
										anda gunakan</h3>

									<div class="radio-group">

										<div class="panel-white-payment" data-radio="kartu_kredit">
											<!-- <div class="methode display-flex align-items-center">
													<input id="kartu_kredit" class="radio-custom display-hidden"
														name="payment_method" type="radio"> <label
														for="kartu_kredit"
														class="radio-custom-label display-flex align-items-center agency__cursor-pointer">
														<span class="custom-radio mr-2level"></span> <span>Kartu
															Kredit</span>
													</label>
												</div> -->
											<div>
												<div
													class="display-inline-flex align-items-center agency__self-center radio-custom-wrapper">
													<input id="kartu_kredit" class="radio-custom"
														name="payment_method" type="radio"> <label
														for="kartu_kredit" class="radio-custom-label mb-0level"><span>Kartu
															Kredit</span></label>
												</div>
											</div>
											<div class="display-flex agency__space-x-2">
												<img src="/o/mypage-theme/images/mastercard.png"
													alt="mastercard"> <img
													src="/o/mypage-theme/images/visa.png" alt="visa">
											</div>
										</div>

										<div class="panel-white-payment" data-radio="virtual_account">
											<!-- <div class="methode display-flex align-items-center">
													<input id="virtual_account" class="radio-custom display-hidden"
														name="payment_method" type="radio"> <label
														for="virtual_account"
														class="radio-custom-label display-flex align-items-center agency__cursor-pointer">
														<span class="custom-radio mr-2level"></span> <span>Virtual
															Account</span>
													</label>
												</div> -->
											<div>
												<div
													class="display-inline-flex align-items-center agency__self-center radio-custom-wrapper">
													<input id="virtual_account" class="radio-custom"
														name="payment_method" type="radio"> <label
														for="virtual_account" class="radio-custom-label mb-0level"><span>Virtual
															Account</span></label>
												</div>
											</div>
											<div class="display-flex agency__space-x-2">
												<img src="/o/mypage-theme/images/BCA.png" alt="bca"> <img
													src="/o/mypage-theme/images/Permata.png" alt="permata">
												<img src="/o/mypage-theme/images/Mandiri.png" alt="mandiri">
											</div>
										</div>

										<div class="panel-white-payment" data-radio="cicilan">
											<!-- <div class="methode display-flex align-items-center">
													<input id="cicilan" class="radio-custom display-hidden"
														name="payment_method" type="radio"> <label
														for="cicilan"
														class="radio-custom-label display-flex align-items-center agency__cursor-pointer">
														<span class="custom-radio mr-2level"></span> <span>Cicilan
															0%</span>
													</label>
												</div> -->
											<div>
												<div
													class="display-inline-flex align-items-center agency__self-center radio-custom-wrapper">
													<input id="cicilan" class="radio-custom"
														name="payment_method" type="radio"> <label
														for="cicilan" class="radio-custom-label mb-0level"><span>Cicilan
															0%</span></label>
												</div>
											</div>
											<div class="display-flex agency__space-x-2">
												<img src="/o/mypage-theme/images/BNI.png" alt="bni"> <img
													src="/o/mypage-theme/images/Mandiri.png" alt="mandiri">
											</div>
										</div>

									</div>
								</div>

							</section>


						</div>

						<div class="col-tabstep2">
							<div class="panel-cover py-5level">
								<h3>Perjalanan International</h3>
								<h1>Plan Bugdet Travel</h1>
								<h4>Proteksi Anda</h4>
								<div class="px-10level my-3level">
									<div class="flex-justify-between mb-1level">
										<span>5 Hari</span> <span></span> <span
											class="text_nondiscount agency__w-1per3">USD 12</span>
									</div>
									<div class="flex-justify-between mb-1level">
										<span>Biaya Polis</span> <span></span> <span
											class="text_nondiscount agency__w-1per3">USD 23</span>
									</div>
									<div class="flex-justify-between mb-1level">
										<span>Materai</span> <span></span> <span
											class="text_nondiscount agency__w-1per3">USD 321</span>
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
												<input class="input-control-axa"
													placeholder="Isi Kode Promo" type="text" maxlength="13">
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
												<td class="agency__text-axa-ocean-100 pl-85px">USD 500</td>
											</tr>
											<tr>
												<td>Total Premi</td>
												<td class="total-premi pl-85px">USD 4.233</td>
											</tr>
											<tr>
												<td></td>
												<td class="cost-total-premi2 pl-85px">USD 3.823</td>
											</tr>
											<tr>
												<td></td>
												<td class="agency__text-axa-ocean-100 pl-85px">IDR
													55.093.800</td>
											</tr>
										</tbody>
									</table>

								</div>

								<div class="mt-5level agency__text-center">
									<a id="btnBayar" class="btn__agency btn--dark-grey width-full"
										href="#"> <span
										class="position-relative agency__uppercase">Bayar <i
											class="fas fa-arrow-right"></i></span>
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

	var loadDataPaymentReportURL = "<%=loadDataPaymentReport%>";
	
    document.addEventListener('DOMContentLoaded', function () {
    	
		/* delete bg-white default liferay */
		
		var contentSection = document.getElementById('content');
	    if (contentSection) {
	        contentSection.classList.remove('bg-white');
	    }
	    
	    /* button clear kode promo */
	    const clearButtons = document.querySelectorAll('.btnClear');

	    clearButtons.forEach(button => {
	        button.addEventListener('click', function() {
	            const inputGroup = button.closest('.input-group-axa');
	            const input = inputGroup.querySelector('.input-control-axa');
	            
	            input.value = '';
	        });
	    });
	    
	    
	    $(document).ready(function() {
	        generateReport();
	    });
	    
	    
	    /* to resource command */
	    function generateReport() {
		    console.log('testt fungsi generate run');
		    const category = "generate";
		    const url = loadDataPaymentReportURL + "&dataCategory=" + category;
		    let date = new Date();
		    const year = date.getFullYear();
		    const timeMillis = Date.now(); // Mendapatkan time-millis yang unik
		    
		    $.ajax({
		        url: url,
		        method: 'GET',
		        xhrFields: {
		            responseType: 'blob'
		        },
		        success: function (response, textStatus, xhrObj) {
		            console.log('response');
		            
		            // Menambahkan timeMillis ke nama file agar unik
		            download(response, 'SIT-Payment-PDF-' + year + '-' + timeMillis + '.pdf');
		        },
		        complete: function () {
		            console.log('okkk sukses');
		        }
		    });
		}

	    
	    function download(object, name) {
	        var a = document.createElement('a');
	        var url = URL.createObjectURL(object);
	        a.href = url;
	        a.download = name;
	        a.click();
	    }
	    
	    
	    /* change btn */ 
        const panels = document.querySelectorAll('.panel-white-payment');
        const btnBayar = document.getElementById('btnBayar');

        panels.forEach(panel => {
            panel.addEventListener('click', function () {
                const radioId = panel.getAttribute('data-radio');
                const radioInput = document.getElementById(radioId);

                radioInput.checked = true;

                panels.forEach(p => p.classList.remove('highlight'));
                panel.classList.add('highlight');

                btnBayar.classList.remove('btn--dark-grey');
                btnBayar.classList.add('btn--dark-blue');
            });
        });
    });


</script>