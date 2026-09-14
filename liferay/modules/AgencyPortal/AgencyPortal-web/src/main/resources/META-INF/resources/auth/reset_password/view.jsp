<%@ include file="../../init.jsp" %>

<% 
    String email = (String) renderRequest.getAttribute("email");
%>

<div class="topbar">
	<div class="container-axa">
		<div class="flex-justify-between">
			<div class="topbar__logo">
				<a href="auth">
					<img class="h-50px" src="/o/agency-theme/images/logo_axa_mandiri.png">
				</a>
			</div>
			<div class="topbar__link">
				<a href="https://mypage.axa.co.id/">Kembali ke AXA myPage</a>
			</div>
		</div>
	</div>
</div>
<div class="login-wrapper">
	<div class="login-wrapper__style-bg-img">
		<div class="container-axa-login">
			<div class="login-wrapper__container">
				<div class="login-wrapper__heading">
					<p>Portal Agen</p>
					<h1>AXA Insurance</h1>
				</div>
				<div class="login-wrapper__form">
					<div class="multi-step-form">
						<form class="login-form" id="formLogin" action="javascript:void()" autocomplete="off" novalidate="novalidate">
							<fieldset aria-label="Create New Password" id="create-new-password">
								<div class="pt-25px px-30px">
									<h3 class="text-32px mb-6px">Buat Kata Sandi</h3>
									<p class="text-16px m-15px-0px-8px-0px">Silakan masukan kata sandi baru anda</p>
									<div id="confirmation-password-failed" class="error-text-wrapper text-center display-none"></div>
									<div class="alert-agency display-none">
										<span class="agency-font-semibold"></span>
									</div>
								</div>
								<div class="login-form__body p-20px-30px-30px-30px">
									<div class="mb-15px position-relative">
										<label class="label__agency display-flex gap-12px">
											<span>Kata Sandi</span>
											<div class="agency-tooltip position-relative" id="tooltip-password">
												<span class="tooltip-click agency-pointer">
													<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
														<path d="M11.9999 11.9999L11.9999 16.7999M11.9999 8.44209V8.3999M2.3999 11.9999C2.3999 6.69797 6.69797 2.3999 11.9999 2.3999C17.3018 2.3999 21.5999 6.69797 21.5999 11.9999C21.5999 17.3018 17.3018 21.5999 11.9999 21.5999C6.69797 21.5999 2.3999 17.3018 2.3999 11.9999Z" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
													</svg>
												</span>
												<div class="tooltip__wrapper">
													<div class="bubble">
														<p>Kata sandi terdiri dari 8 karakter, mengunakan huruf kapital, huruf biasa, dan angka.</p>
														<div class="arrow-triangle-right"></div>
													</div>
												</div>
											</div>
										</label>
										<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="password" name="create_new_password" id="create_new_password" placeholder="Masukkan kata sandi" autocomplete="off" onkeypress="return event.charCode != 32" maxlength="50" required />
										<span toggle="#create_new_password" class="toggle-password position-absolute top-50px right-18px agency-pointer">
											<i class="eye-close eye-position">
												<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
													<path d="M20.3999 19.5L5.3999 4.5M10.1999 10.4416C9.82648 10.8533 9.5999 11.394 9.5999 11.9863C9.5999 13.2761 10.6744 14.3217 11.9999 14.3217C12.611 14.3217 13.1688 14.0994 13.5926 13.7334M20.4387 14.3217C21.2649 13.0848 21.5999 12.0761 21.5999 12.0761C21.5999 12.0761 19.4153 5.1 11.9999 5.1C11.5836 5.1 11.1838 5.12199 10.7999 5.16349M17.3999 17.3494C16.0225 18.2281 14.2492 18.8495 11.9999 18.8127C4.67683 18.693 2.3999 12.0761 2.3999 12.0761C2.3999 12.0761 3.45776 8.69808 6.5999 6.64332" stroke-linecap="round"/>
												</svg>
											</i>
											<i class="eye-open eye-position">
												<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
													<path fill-rule="evenodd" clip-rule="evenodd" d="M3.47139 12.103C3.53662 11.9408 3.63002 11.724 3.75499 11.4692C4.04899 10.8696 4.51161 10.0711 5.18309 9.27615C6.51416 7.70025 8.65372 6.14282 11.9999 6.14282C15.3461 6.14282 17.4856 7.70025 18.8167 9.27615C19.4882 10.0711 19.9508 10.8696 20.2448 11.4692C20.3715 11.7276 20.4657 11.9467 20.5311 12.1096C20.4639 12.2689 20.3678 12.4821 20.2394 12.7329C19.9391 13.32 19.469 14.1005 18.793 14.8742C17.453 16.4078 15.3163 17.9097 12.0163 17.8557C8.69468 17.8014 6.54376 16.2875 5.20096 14.7778C4.52406 14.0167 4.05425 13.2568 3.75477 12.6885C3.63137 12.4543 3.53783 12.2545 3.47139 12.103ZM21.5999 12.119C22.5542 11.8201 22.5541 11.8196 22.5539 11.8191L22.5535 11.818L22.5527 11.8152L22.5503 11.8077L22.543 11.7853C22.5369 11.7671 22.5286 11.7423 22.5178 11.7114C22.4963 11.6498 22.4651 11.5637 22.4235 11.4566C22.3403 11.2427 22.2148 10.944 22.0406 10.5887C21.6932 9.88026 21.1462 8.93467 20.3446 7.98562C18.7295 6.07346 16.0691 4.14282 11.9999 4.14282C7.9307 4.14282 5.27026 6.07346 3.65518 7.98562C2.85358 8.93467 2.30659 9.88026 1.95924 10.5887C1.78504 10.944 1.65955 11.2427 1.57631 11.4566C1.53466 11.5637 1.50347 11.6498 1.48197 11.7114C1.47122 11.7423 1.46288 11.7671 1.45685 11.7853L1.44953 11.8077L1.44715 11.8152L1.44627 11.818L1.44591 11.8191C1.44575 11.8196 1.4456 11.8201 2.3999 12.119L1.4456 11.8201L1.34741 12.1337L1.45432 12.4443L2.3999 12.119C1.45432 12.4443 1.45449 12.4448 1.45466 12.4453L1.45505 12.4465L1.45601 12.4492L1.45856 12.4565L1.46633 12.4782C1.47269 12.4958 1.48146 12.5196 1.49272 12.5491C1.51522 12.6082 1.54772 12.6905 1.59092 12.7928C1.67726 12.9971 1.8068 13.282 1.98542 13.6209C2.34171 14.297 2.89883 15.1988 3.70654 16.1069C5.33297 17.9356 7.98204 19.79 11.9836 19.8554C16.0066 19.9212 18.6699 18.0547 20.2991 16.1901C21.1077 15.2647 21.6645 14.3386 22.02 13.6438C22.1982 13.2954 22.3274 13.002 22.4134 12.7918C22.4564 12.6866 22.4887 12.6019 22.511 12.5412C22.5222 12.5108 22.5309 12.4865 22.5372 12.4685L22.5448 12.4463L22.5473 12.439L22.5482 12.4362L22.5486 12.4351C22.5488 12.4346 22.5489 12.4341 21.5999 12.119ZM21.5999 12.119L22.5489 12.4341L22.6506 12.128L22.5542 11.8201L21.5999 12.119ZM11.9999 10.6938C11.2008 10.6938 10.5999 11.3172 10.5999 12.0291C10.5999 12.7411 11.2008 13.3645 11.9999 13.3645C12.799 13.3645 13.3999 12.7411 13.3999 12.0291C13.3999 11.3172 12.799 10.6938 11.9999 10.6938ZM20.6463 12.42C20.6465 12.4205 20.6465 12.4205 20.6463 12.4202L20.6463 12.42ZM8.5999 12.0291C8.5999 10.1615 10.148 8.69377 11.9999 8.69377C13.8518 8.69377 15.3999 10.1615 15.3999 12.0291C15.3999 13.8968 13.8518 15.3645 11.9999 15.3645C10.148 15.3645 8.5999 13.8968 8.5999 12.0291Z" />
												</svg>
											</i>
										</span>
									</div>
									<div class="mb-15px position-relative">
										<label class="label__agency" for="confirm_new_password">Konfirmasi Kata Sandi</label>
										<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="password" name="confirm_new_password" id="confirm_new_password" placeholder="Masukkan kembali kata sandi" autocomplete="new-password" onkeypress="return event.charCode != 32" maxlength="50" required />
										<span toggle="#confirm_new_password" class="toggle-password position-absolute top-50px right-18px agency-pointer">
											<i class="eye-close eye-position">
												<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
													<path d="M20.3999 19.5L5.3999 4.5M10.1999 10.4416C9.82648 10.8533 9.5999 11.394 9.5999 11.9863C9.5999 13.2761 10.6744 14.3217 11.9999 14.3217C12.611 14.3217 13.1688 14.0994 13.5926 13.7334M20.4387 14.3217C21.2649 13.0848 21.5999 12.0761 21.5999 12.0761C21.5999 12.0761 19.4153 5.1 11.9999 5.1C11.5836 5.1 11.1838 5.12199 10.7999 5.16349M17.3999 17.3494C16.0225 18.2281 14.2492 18.8495 11.9999 18.8127C4.67683 18.693 2.3999 12.0761 2.3999 12.0761C2.3999 12.0761 3.45776 8.69808 6.5999 6.64332" stroke-linecap="round"/>
												</svg>
											</i>
											<i class="eye-open eye-position">
												<svg class="w-24px-h-24px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
													<path fill-rule="evenodd" clip-rule="evenodd" d="M3.47139 12.103C3.53662 11.9408 3.63002 11.724 3.75499 11.4692C4.04899 10.8696 4.51161 10.0711 5.18309 9.27615C6.51416 7.70025 8.65372 6.14282 11.9999 6.14282C15.3461 6.14282 17.4856 7.70025 18.8167 9.27615C19.4882 10.0711 19.9508 10.8696 20.2448 11.4692C20.3715 11.7276 20.4657 11.9467 20.5311 12.1096C20.4639 12.2689 20.3678 12.4821 20.2394 12.7329C19.9391 13.32 19.469 14.1005 18.793 14.8742C17.453 16.4078 15.3163 17.9097 12.0163 17.8557C8.69468 17.8014 6.54376 16.2875 5.20096 14.7778C4.52406 14.0167 4.05425 13.2568 3.75477 12.6885C3.63137 12.4543 3.53783 12.2545 3.47139 12.103ZM21.5999 12.119C22.5542 11.8201 22.5541 11.8196 22.5539 11.8191L22.5535 11.818L22.5527 11.8152L22.5503 11.8077L22.543 11.7853C22.5369 11.7671 22.5286 11.7423 22.5178 11.7114C22.4963 11.6498 22.4651 11.5637 22.4235 11.4566C22.3403 11.2427 22.2148 10.944 22.0406 10.5887C21.6932 9.88026 21.1462 8.93467 20.3446 7.98562C18.7295 6.07346 16.0691 4.14282 11.9999 4.14282C7.9307 4.14282 5.27026 6.07346 3.65518 7.98562C2.85358 8.93467 2.30659 9.88026 1.95924 10.5887C1.78504 10.944 1.65955 11.2427 1.57631 11.4566C1.53466 11.5637 1.50347 11.6498 1.48197 11.7114C1.47122 11.7423 1.46288 11.7671 1.45685 11.7853L1.44953 11.8077L1.44715 11.8152L1.44627 11.818L1.44591 11.8191C1.44575 11.8196 1.4456 11.8201 2.3999 12.119L1.4456 11.8201L1.34741 12.1337L1.45432 12.4443L2.3999 12.119C1.45432 12.4443 1.45449 12.4448 1.45466 12.4453L1.45505 12.4465L1.45601 12.4492L1.45856 12.4565L1.46633 12.4782C1.47269 12.4958 1.48146 12.5196 1.49272 12.5491C1.51522 12.6082 1.54772 12.6905 1.59092 12.7928C1.67726 12.9971 1.8068 13.282 1.98542 13.6209C2.34171 14.297 2.89883 15.1988 3.70654 16.1069C5.33297 17.9356 7.98204 19.79 11.9836 19.8554C16.0066 19.9212 18.6699 18.0547 20.2991 16.1901C21.1077 15.2647 21.6645 14.3386 22.02 13.6438C22.1982 13.2954 22.3274 13.002 22.4134 12.7918C22.4564 12.6866 22.4887 12.6019 22.511 12.5412C22.5222 12.5108 22.5309 12.4865 22.5372 12.4685L22.5448 12.4463L22.5473 12.439L22.5482 12.4362L22.5486 12.4351C22.5488 12.4346 22.5489 12.4341 21.5999 12.119ZM21.5999 12.119L22.5489 12.4341L22.6506 12.128L22.5542 11.8201L21.5999 12.119ZM11.9999 10.6938C11.2008 10.6938 10.5999 11.3172 10.5999 12.0291C10.5999 12.7411 11.2008 13.3645 11.9999 13.3645C12.799 13.3645 13.3999 12.7411 13.3999 12.0291C13.3999 11.3172 12.799 10.6938 11.9999 10.6938ZM20.6463 12.42C20.6465 12.4205 20.6465 12.4205 20.6463 12.4202L20.6463 12.42ZM8.5999 12.0291C8.5999 10.1615 10.148 8.69377 11.9999 8.69377C13.8518 8.69377 15.3999 10.1615 15.3999 12.0291C15.3999 13.8968 13.8518 15.3645 11.9999 15.3645C10.148 15.3645 8.5999 13.8968 8.5999 12.0291Z" />
												</svg>
											</i>
										</span>
									</div>
									<div class="mb-15px position-relative">
										<label for="otp" class="label__agency label-otp display-none">OTP</label>
										<p class="alert-otp text-16px line-height-24px mb-10px display-none">
											Masukkan kode OTP yang sudah dikirimkan ke email <span class="agency-text-blue-400 email-otp"></span>
										</p>
										<div class="otp-field position-relative" id="otp-field-password" style="display: none">
											<input type="number" id="otp_creatpass_1" name="otp_1" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
											<input type="number" id="otp_creatpass_2" name="otp_2" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
											<input type="number" id="otp_creatpass_3" name="otp_3" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
											<input type="number" id="otp_creatpass_4" name="otp_4" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
											<input type="number" id="otp_creatpass_5" name="otp_5" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
											<input type="number" id="otp_creatpass_6" name="otp_6" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()"> 
										</div>
										<input type="hidden" name="otp-password">
										<input type="hidden" name="email" value="<%= email %>">
										<div class="otp-timer mt-16px mb-24px">
											<a href="javascript:void(0)" class="link-otp-password text-14px mb-8px display-none" onclick="generateOtp('new')">Kirim Kode OTP</a>
											<span class="link-otp text-14px agency-hover-underline agency-pointer mb-8px disabled display-none" disabled onclick="generateOtp('resend')">Kirim Ulang Kode OTP</span>
											<span class="text-16px agency-text-grey-800 display-none" id="timer">05:00</span>
										</div>
									</div>
								</div>
								<div class="login-form__footer p-20px-30px flex-justify-end">
									<!-- <button class="btn-back-otp text-14px agency-uppercase agency-self-center" type="button" aria-controls="" data-bs-toggle="modal" data-bs-target="#ModalBack">Kembali</button> -->
									<button class="btn__agency btn--dark-blue agency-self-center btn-finish-create-new-password btn--disabled disabled" disabled type="button" aria-controls="login" onclick="submitForm()"><span class="position-relative order-10">Masuk <i class="fas fa-arrow-right fa-fw ml-5px"></i></span></button>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script src="/o/agency-theme/js/multiform/multiform.js" type="text/javascript"></script>
	<script src="/o/agency-theme/js/multiform/otp.js" type="text/javascript"></script>
    <script src="<%= request.getContextPath() %>/auth/reset_password/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>