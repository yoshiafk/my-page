<% if (_step.equalsIgnoreCase("landing") == true || _step.equalsIgnoreCase("one") == true) { %>
	<div class="modal modal-axa-smartactive fade" id="moreinfoModal" tabindex="-1" aria-labelledby="moreinfoModalLabel" aria-hidden="true" style="display: none;">
	    <div class="modal-dialog modal-axa-smartactive-dialog modal-lg modal-dialog modal-axa-smartactive-dialog-centered">
	        <div class="modal-content modal-axa-smartactive-content">
	            <div class="modal-header modal-axa-smartactive-header">
	                <h1 class="modal-title fs-5" id="moreinfoModalLabel">Info Tambahan</h1>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
	                    <i class="far fa-times fa-fw"></i>
	                </button>
	            </div>
	            <div class="modal-body modal-axa-smartactive-body"></div>
	        </div>
	    </div>
	</div>
<% } %>

<% if (_step.equalsIgnoreCase("one") == true || _step.equalsIgnoreCase("two") == true) { %>
	<!-- Modal Warning -->
	<div class="modal modal-axa-smartactive width-full fade" id="modalAlertFailed" tabindex="-1" style="display: none;" aria-labelledby="modalAlertLabel" aria-hidden="true">
		<div class="modal-max-w-430px modal-axa-smartactive-dialog modal-dialog modal-axa-smartactive-dialog-centered">
			<div class="modal-axa-smartactive-content">
				<div class="modal-axa-smartactive-body agency__text-center p-80px-40px-0px-40px position-relative">
					<svg class="warning w-100px-h-100px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" fill="none">
						<path d="M50.0017 54.0462V33.8864M50.0017 68.9888V69.166M75.2014 85.956H24.802C17.9177 85.956 12.108 81.3551 10.2802 75.0604C9.49989 72.3733 10.4586 69.5745 11.9251 67.1915L37.1248 21.2417C43.0288 11.6476 56.9746 11.6476 62.8787 21.2418L88.0783 67.1915C89.5448 69.5745 90.5035 72.3733 89.7232 75.0603C87.8954 81.3551 82.0857 85.956 75.2014 85.956Z" stroke="#1F1F9C" stroke-width="8.33333" stroke-linecap="round" stroke-linejoin="round" />
					</svg>
					<h1>Peringatan!</h1>
					<p>Kode Promo gagal dipakai.</p>
					<button type="button" class="btn btn--dark-blue btn-close" type="button" data-bs-dismiss="modal" aria-label="Close">
						<span class="position-relative order-50"> 
							Keluar 
							<svg class="align-self-center" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
								<path d="M8.83333 3.625L13 8M13 8L8.83333 12.375M13 8L3 8" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
							</svg>
						</span>
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal Success -->
	<div class="modal modal-axa-smartactive width-full fade" id="modalAlertSuccess" tabindex="-1" style="display: none;" aria-labelledby="modalAlertLabel" aria-hidden="true">
		<div class="modal-max-w-430px modal-axa-smartactive-dialog modal-dialog modal-axa-smartactive-dialog-centered">
			<div class="modal-axa-smartactive-content">
				<div class="modal-axa-smartactive-body agency__text-center p-80px-40px-0px-40px position-relative">
					<svg class="success" xmlns="http://www.w3.org/2000/svg" width="73" height="65" viewBox="0 0 73 65" fill="none">
						<path d="M71.479 17.1509C70.7401 15.7021 69.4383 14.6197 67.8792 14.1582C66.3194 13.696 64.6388 13.894 63.2294 14.7066L61.5468 15.6773C61.3212 14.8115 60.8942 14.0112 60.3009 13.3421C59.4979 12.4418 58.4375 11.8098 57.264 11.5318L57.7704 11.0261C60.1015 8.7937 60.2767 5.12631 58.1685 2.68139C57.0798 1.4672 55.5393 0.754558 53.9092 0.711096C52.2783 0.667633 50.7019 1.2968 49.5498 2.45166L46.7241 5.28429C46.0901 2.61102 43.7045 0.722134 40.9567 0.719374H40.9484C39.379 0.715925 37.873 1.34095 36.7664 2.45442L27.0729 12.1465L27.0557 12.1638L25.9733 13.2455C25.7746 11.4973 24.9578 9.87681 23.6691 8.6778C21.9195 7.10005 19.2401 7.17525 17.5809 8.84751L7.37899 19.0625C-1.95023 28.1199 -2.5042 42.9137 6.12134 52.6437C7.86604 54.5533 9.9067 56.1697 12.1654 57.4301C12.6331 57.9289 13.1402 58.429 13.6886 58.9195C21.4221 65.7997 32.6968 66.9442 41.6549 61.7584L65.1535 48.1947C67.9778 46.6383 69.0941 43.1475 67.6971 40.2418C67.1514 39.16 66.2863 38.2722 65.219 37.6982L68.2241 35.9645C71.0575 34.4178 72.1868 30.9243 70.7939 28.0116C70.2517 26.9354 69.3921 26.0524 68.3311 25.4811L68.943 25.1279C71.7742 23.5654 72.8877 20.0615 71.479 17.1509ZM8.2096 50.7403C0.59749 42.1258 1.10869 29.0478 9.36928 21.0535L19.5774 10.8468C20.15 10.2362 21.1034 10.1886 21.7333 10.7392C22.646 11.5925 23.1737 12.7791 23.1958 14.0285C23.2179 15.2772 22.7322 16.4824 21.8505 17.3668H21.8437L12.2502 26.9602C11.6983 27.5128 11.699 28.4076 12.2509 28.9588C12.8028 29.5107 13.6976 29.51 14.2495 28.9581L23.8257 19.3806L38.7457 4.46058C39.3252 3.87763 40.113 3.55132 40.9346 3.55339C42.1937 3.55063 43.3306 4.30881 43.8128 5.47263C44.295 6.63576 44.0267 7.97551 43.134 8.86476L27.173 24.8354C26.8059 25.19 26.6583 25.7157 26.788 26.2097C26.917 26.7036 27.3027 27.0893 27.7966 27.2183C28.2906 27.348 28.8162 27.2003 29.1708 26.8333L45.1519 10.8537L51.5546 4.45092C52.1589 3.84383 52.9861 3.51338 53.8422 3.53683C54.6977 3.5596 55.5062 3.93489 56.0761 4.57372C57.1557 5.90794 57.0267 7.84857 55.7794 9.02826L51.7043 13.1034V13.1116L33.5674 31.2313C33.2004 31.5866 33.0528 32.1116 33.1825 32.6055C33.3115 33.0995 33.6971 33.4851 34.1911 33.6148C34.6857 33.7438 35.2107 33.5969 35.5653 33.2292L53.6884 15.1068C54.2769 14.4817 55.1116 14.1485 55.9684 14.1968C56.8239 14.2161 57.6324 14.5907 58.2009 15.2296C58.8135 15.9415 59.0598 16.8984 58.8694 17.818C58.8432 17.9615 58.808 18.1029 58.7631 18.2416C58.7438 18.3023 58.7238 18.3616 58.7011 18.4209C58.6617 18.5258 58.619 18.6272 58.5714 18.7279C58.5224 18.8245 58.4686 18.919 58.4099 19.0101C58.3706 19.0763 58.334 19.1432 58.2899 19.2067C58.1754 19.3709 58.0464 19.5254 57.9056 19.6689L51.8844 25.7129L51.8754 25.7212L39.9654 37.6278C39.5977 37.9824 39.4507 38.5074 39.5797 39.0014C39.7094 39.4953 40.0951 39.8817 40.589 40.0107C41.083 40.1404 41.608 39.9927 41.9632 39.6257L53.8478 27.7391C53.8478 27.7391 53.865 27.7302 53.8719 27.7233C54.8646 26.6464 56.4976 26.4622 57.7049 27.2914C57.7732 27.3335 57.8463 27.3645 57.9098 27.4128C57.9732 27.4604 58.0443 27.537 58.1133 27.5977C58.2078 27.675 58.2975 27.7571 58.383 27.8433C58.3892 27.8529 58.3961 27.8619 58.403 27.8702C58.6514 28.1744 58.8425 28.5201 58.968 28.8919C59.0474 29.1541 59.0901 29.4252 59.097 29.6984V29.8557C59.0881 30.4117 58.9473 30.9581 58.6873 31.4493C58.6562 31.5086 58.6238 31.5679 58.5879 31.6273C58.4561 31.8494 58.2995 32.0564 58.1202 32.2433C58.105 32.2599 58.094 32.2799 58.0767 32.2971L38.8898 51.4833C38.4663 51.9076 38.042 52.296 37.5956 52.6734C31.582 57.7619 23.2434 59.0989 15.9404 56.1448C15.4264 55.9358 14.9173 55.7054 14.4137 55.4536C12.0722 54.2794 9.96879 52.681 8.2096 50.7403ZM63.7351 45.7477L40.2392 59.3107C34.3925 62.698 27.2792 63.0891 21.0965 60.3634C22.855 60.5752 24.6321 60.5856 26.3934 60.3931C26.5341 60.3793 26.6659 60.3496 26.8046 60.3338C27.511 60.2475 28.2002 60.1372 28.8908 59.9902C29.1357 59.9398 29.3744 59.8702 29.6172 59.8108C30.1981 59.6701 30.7727 59.5114 31.3426 59.3252C31.6137 59.2376 31.8793 59.1389 32.1477 59.0423C32.683 58.8464 33.2101 58.6325 33.7316 58.398C34.0014 58.2766 34.2697 58.1538 34.5367 58.0213C35.0486 57.7681 35.5488 57.4915 36.0441 57.2003C36.2973 57.0589 36.5532 56.9092 36.8016 56.7492C37.3114 56.4242 37.8033 56.0696 38.291 55.7026C38.5042 55.5439 38.7229 55.397 38.9326 55.2307C39.5438 54.7389 40.1344 54.2132 40.7042 53.6537C40.7677 53.593 40.8367 53.5433 40.8988 53.4812L45.543 48.8363H45.5589C45.8066 48.8356 46.0501 48.7707 46.2653 48.6466L60.8459 40.2273L60.8618 40.2149C61.6034 39.7954 62.4843 39.6988 63.2998 39.9458C64.1152 40.1935 64.7934 40.764 65.1776 41.5243C65.8744 43.0923 65.2473 44.9316 63.7379 45.7477H63.7351ZM66.8154 33.512L59.4261 37.7789C59.4178 37.7789 59.413 37.7927 59.4047 37.7968L52.7315 41.6546L60.0925 34.293C60.3437 34.0377 60.572 33.7604 60.7755 33.4651C60.8417 33.372 60.8997 33.2788 60.9604 33.1829C61.0811 32.9905 61.1915 32.7918 61.2909 32.5883C61.3543 32.4593 61.4226 32.3337 61.4757 32.2019C61.6524 31.7549 61.78 31.2899 61.8559 30.8146C61.8786 30.6732 61.9014 30.5421 61.9138 30.4048C61.9324 30.2172 61.9407 30.0309 61.9407 29.8398C61.9407 29.6984 61.9311 29.5576 61.9214 29.4162C61.9214 29.3355 61.9214 29.2562 61.9111 29.1775L63.94 28.0047C64.6795 27.5777 65.5619 27.4735 66.3808 27.7157C67.1997 27.9571 67.8833 28.5249 68.2717 29.2844C68.9651 30.8574 68.3317 32.6986 66.8182 33.512H66.8154ZM67.5218 22.6754L62.5271 25.5619L60.89 26.507C60.7659 26.3152 60.6313 26.1303 60.4858 25.9544C60.3002 25.7537 60.1022 25.5646 59.8925 25.3894C59.8697 25.3708 59.8511 25.3473 59.8283 25.3287C59.7097 25.2314 59.58 25.1535 59.4544 25.0658C59.3282 24.9782 59.2226 24.8892 59.0984 24.814C58.5872 24.5112 58.0333 24.287 57.4551 24.1504L59.9194 21.6875C60.156 21.4405 60.3733 21.1749 60.5692 20.8935C60.6451 20.7879 60.71 20.6817 60.7838 20.5727C60.8866 20.4092 60.977 20.2408 61.0666 20.0698C61.2267 19.7572 61.3605 19.4316 61.4661 19.0963C61.4806 19.0543 61.4985 19.0142 61.5116 18.9722L64.6478 17.1605C65.3867 16.7349 66.2676 16.6307 67.0851 16.8735C67.9026 17.1157 68.5849 17.6835 68.9713 18.4437C69.6632 20.0153 69.0347 21.8552 67.526 22.6754H67.5218Z" fill="#1F1F9C"/>
					</svg> 
					<h1>Sukses</h1>
					<p style="text-align: center;">Kode Promo berhasil dipakai.</p>
					<button type="button" class="btn btn--dark-blue btn-close" type="button" data-bs-dismiss="modal" aria-label="Close">
						<span class="position-relative order-50"> 
							Keluar 
							<svg class="align-self-center" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
								<path d="M8.83333 3.625L13 8M13 8L8.83333 12.375M13 8L3 8" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
							</svg>
						</span>
					</button>
				</div>
			</div>
		</div>
	</div>
<% } %>

<div id="modal_alert" class="modal_alert agency__hidden">
    <div class="modal_alert-content">
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
        
        <div class="ispep_modal__inner-footer agency__text-center mt-8level">
            <button onclick="closeModalAlertBlocked()" class="ispep_modal__inner-footer-btn">
                <i class="fas fa-check"></i> OK
            </button>
        </div>
    </div>
</div>

<div class="modal modal-axa-smarttravel fade" id="quotation-modal" tabindex="-1" aria-labelledby="" aria-hidden="true" style="display: none">
	<div class="modal-dialog modal-axa-smarttravel-dialog modal-lg">
    	<div class="modal_penawaran-modal-content">
			<span id="send_quotation_btn_close" class="modal_penawaran-close-btn">&times;</span>
			<h2 class="modal_penawaran-text_header">KIRIM PENAWARAN</h2>
			<form id="send_quotation_form" style="margin-top: 20px" autocomplete="off">
				<div class="modal_penawaran-form-group">
					<label for="name" class="mb-4level">Nama Lengkap: <span class="modal_penawaran-agency__text-red-500">*</span></label>
					<input type="text" id="name_modal" name="send_quotation_name" required autocomplete="off" />
				</div>
				<div class="modal_penawaran-form-group mt-8level">
					<label for="email" class="modal_penawaran-mb-4level">Email: <span class="modal_penawaran-agency__text-red-500">*</span></label>
					<input type="email" id="email_modal" name="send_quotation_email" required autocomplete="off" />
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