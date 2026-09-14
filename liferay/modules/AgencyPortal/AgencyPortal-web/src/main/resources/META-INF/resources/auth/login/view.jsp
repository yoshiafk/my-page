<%@ include file="../../init.jsp" %>

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
							<fieldset aria-label="Login" id="login">
								<div class="pt-25px px-30px">
									<h3>Masuk</h3>
									<p>Belum memilik Akun? <a href="#">Daftar Disini</a></p>
									<div id="login-failed" class="alert failed error-text-wrapper text-center display-none"></div>
									<div class="alert-agency display-none">
										<span class="agency-font-semibold"></span>
									</div>
								</div>
								<div class="login-form__body p-20px-30px-30px-30px">
									<div class="mb-15px">
										<label class="label__agency display-block" for="email_agen">Email / Kode Agen</label>
										<input class="input-control input-control--outline agency-bg-transparent agency-uppercase" type="text" name="email_agen" id="email_agen" placeholder="Masukkan email / kode agen" autocomplete="off" onkeypress="return /^([a-zA-Z0-9 . @]+)$/i.test(event.key)" maxlength="50" multiple required />
									</div>
									<div class="mb-15px position-relative">
										<label class="label__agency flex-justify-between" for="password_agen">
											<span>Kata Sandi</span>
											<span><button class="btn-forgot-password" type="reset">Lupa Kata Sandi?</button></span>
										</label>
										<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="password" name="password_agen" id="password_agen" onkeypress="return event.charCode != 32" placeholder="Masukkan kata sandi" autocomplete="new-password" maxlength="50" required/>
										<span toggle="#password_agen" class="toggle-password position-absolute top-50px right-18px agency-pointer">
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
								</div>
								<div class="login-form__footer p-20px-30px flex-justify-between">
									<a class="btn-enter-account-activation" href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#ModalLoading" aria-controls="account-activation">Aktivasi Akun</a>
									<button id="sendOTP" class="btn__agency btn--dark-blue agency-self-center btn-next" type="button" aria-controls="otp" onclick="generateOtpLogin('new')"><span class="position-relative order-10">Lanjutkan <i class="fas fa-arrow-right fa-fw ml-5px"></i></span></button>
								</div>
							</fieldset>

							<fieldset aria-label="OTP" id="otp">
								<div class="pt-25px px-30px">
									<h3 class="text-32px mb-6px">Masukkan OTP</h3>
									<p class="text-16px line-height-24px mb-10px">
										Masukkan kode OTP yang sudah dikirimkan ke email <span class="agency-text-blue-400 email-otp"></span>
									</p>
									<div class="alert-agency display-none">
										<span class="agency-font-semibold"></span>
									</div>
								</div>
								<div class="login-form__body p-20px-30px-30px-30px">
									<div class="otp-field justify-content-center position-relative" id="otp-field">
										<input type="number" name="otp_1" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
										<input type="number" name="otp_2" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
										<input type="number" name="otp_3" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
										<input type="number" name="otp_4" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
										<input type="number" name="otp_5" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
										<input type="number" name="otp_6" step="1" min="0" max="9" autocomplete="no" pattern="\d*" placeholder="-" onpaste="paste()">
									</div>
									<input type="hidden" name="otp">
									<div class="agency-text-center mt-32px mb-24px">
										<span class="link-otp text-14px agency-hover-underline agency-pointer mb-8px disabled" disabled id="resend-otp">Kirim Ulang Kode OTP</span>
										<span class="text-16px agency-text-grey-800 display-block" id="timer">05:00</span>
									</div>
								</div>
								<div class="login-form__footer p-20px-30px mt-16px flex-justify-end">
									<button class="btn__agency btn--dark-blue agency-self-center" id="submit" aria-controls="otp" type="button" onclick="submitForm()"><span class="position-relative order-10">Masuk <i class="fas fa-arrow-right fa-fw ml-5px"></i></span></button>
								</div>
							</fieldset>

							<fieldset aria-label="Forgot Password" id="forgotpass">
								<div class="pt-25px px-30px">
									<h3 class="text-32px mb-6px">Lupa Kata Sandi</h3>
									<p class="text-16px mb-10px">Silakan masukkan alamat email Anda yang valid untuk mendapatkan kata sandi baru.</p>
									<div id="forgotpass-failed" class="error-text-wrapper text-center display-none"></div>
									<div class="alert-agency display-none">
										<span class="agency-font-semibold"></span>
									</div>
								</div>
								<div class="login-form__body p-20px-30px-30px-30px">
									<div class="mb-15px">
										<label class="label__agency display-block" for="email_forgotpassword">Email</label>
										<input class="input-control input-control--outline agency-bg-transparent agency-uppercase" type="text" name="email_forgotpassword" id="email_forgotpassword" placeholder="Masukkan email" autocomplete="off" onkeypress="return /^([a-zA-Z0-9 . @]+)$/i.test(event.key)" maxlength="50" required />
									</div>
								</div>
								<div class="login-form__footer p-20px-30px mt-48px flex-justify-between">
									<a class="btn-cancel-forgot-password text-14px agency-uppercase agency-self-center agency-pointer display-none" data-bs-toggle="modal" data-bs-target="#ModalBack">Kembali</a>
									<button type="button" class="btn-prev-forgot-password text-14px agency-uppercase agency-self-center agency-pointer">Kembali</button>
									<button class="btn__agency btn--dark-blue agency-self-center btn-send-forgotpass" type="button" aria-controls="create-password" onclick="generateLinkForgot()"><span class="position-relative order-10">Kirim <i class="fas fa-arrow-right fa-fw ml-5px"></i></span></button>
								</div>
							</fieldset>

							<fieldset aria-label="Account Activation" id="account-activation">
								<div class="pt-25px px-30px">
									<h3 class="text-32px mb-6px">Aktivasi Akun</h3>
									<p class="text-16px m-0px-0px-8px-0px">Silakan masukkan Kode Agen dan kata sandi baru untuk mengaktifkan akun Anda sekarang.</p>
									<div id="activationaccount-failed" class="error-text-wrapper text-center display-none"></div>
									<div class="alert-agency display-none">
										<span class="agency-font-semibold"></span>
									</div>
								</div>
								<div class="login-form__body p-20px-30px-30px-30px">
									<div class="mb-15px">
										<label class="label__agency" for="kode_agen_activation">Kode Agen</label>
										<input class="input-control input-control--outline agency-bg-transparent agency-uppercase" type="text" name="kode_agen_activation" id="kode_agen_activation" maxlength="50" onkeypress="return event.charCode != 32"placeholder="Masukkan kode agen" required>
									</div>
									<div class="mb-15px position-relative">
										<label class="label__agency display-flex gap-12px">
											<span>Kata Sandi</span>
											<div class="agency-tooltip position-relative" id="tooltip-account-activation">
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
										<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="password" name="account_activation_password" id="account_activation_password" placeholder="Masukkan kata sandi" autocomplete="new-password" onkeypress="return event.charCode != 32" maxlength="50" required />
										<span toggle="#account_activation_password" class="toggle-password position-absolute top-50px right-18px agency-pointer">
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
										<label class="label__agency" for="account_activation_password_confirmation">
											<span>Konfirmasi Kata Sandi</span>
										</label>
										<input class="input-control agency-normalcase input-control--outline agency-bg-transparent" type="password" name="account_activation_password_confirmation" id="account_activation_password_confirmation" placeholder="Masukkan kata sandi" autocomplete="new-password" onkeypress="return event.charCode != 32" maxlength="50" required />
										<span toggle="#account_activation_password_confirmation" class="toggle-password position-absolute top-50px right-18px agency-pointer">
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
								</div>
								<div class="login-form__footer p-20px-30px flex-justify-between">
									<a class="btn-modal-activation text-14px agency-uppercase agency-self-center agency-pointer display-none" data-bs-toggle="modal" data-bs-target="#ModalBack">Kembali</a>
									<button type="button" class="btn-prev-activation text-14px agency-uppercase agency-self-center agency-pointer">Kembali</button>
									<button class="btn__agency btn--dark-blue agency-self-center btn-account-activation" type="button" aria-controls="otp" onclick="generateOtpActivation('new')"><span class="position-relative order-10">Masuk <i class="fas fa-arrow-right fa-fw ml-5px"></i></span></button>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal Success Forgot Password -->
<div class="modal modal-agency width-full fade" id="ModalSuccessForgotpass" tabindex="-1" style="display: none;" aria-labelledby="ModalSuccessForgotpassLabel" aria-hidden="true">
	<div class="modal-dialog modal-agency-dialog modal-max-w-560px modal-agency-dialog-centered">
		<div class="modal-content modal-agency-content">
			<div class="modal-agency-body agency-text-center p-80px-40px position-relative">
				<svg class="w-82px-h-82px m-0-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 82 82" fill="none">
					<g clip-path="url(#clip0_559_15798)">
						<path d="M71.479 34.1509C70.7401 32.7021 69.4383 31.6197 67.8792 31.1582C66.3194 30.696 64.6388 30.894 63.2294 31.7066L61.5468 32.6773C61.3212 31.8115 60.8942 31.0112 60.3009 30.3421C59.4979 29.4418 58.4375 28.8098 57.264 28.5318L57.7704 28.0261C60.1015 25.7937 60.2767 22.1263 58.1685 19.6814C57.0798 18.4672 55.5393 17.7546 53.9092 17.7111C52.2783 17.6676 50.7019 18.2968 49.5498 19.4517L46.7241 22.2843C46.0901 19.611 43.7045 17.7221 40.9567 17.7194H40.9484C39.379 17.7159 37.873 18.341 36.7664 19.4544L27.0729 29.1465L27.0557 29.1638L25.9733 30.2455C25.7746 28.4973 24.9578 26.8768 23.6691 25.6778C21.9195 24.1001 19.2401 24.1752 17.5809 25.8475L7.37899 36.0625C-1.95023 45.1199 -2.5042 59.9137 6.12134 69.6437C7.86604 71.5533 9.9067 73.1697 12.1654 74.4301C12.6331 74.9289 13.1402 75.429 13.6886 75.9195C21.4221 82.7997 32.6968 83.9442 41.6549 78.7584L65.1535 65.1947C67.9778 63.6383 69.0941 60.1475 67.6971 57.2418C67.1514 56.16 66.2863 55.2722 65.219 54.6982L68.2241 52.9645C71.0575 51.4178 72.1868 47.9243 70.7939 45.0116C70.2517 43.9354 69.3921 43.0524 68.3311 42.4811L68.943 42.1279C71.7742 40.5654 72.8877 37.0615 71.479 34.1509ZM8.2096 67.7403C0.59749 59.1258 1.10869 46.0478 9.36928 38.0535L19.5774 27.8468C20.15 27.2362 21.1034 27.1886 21.7333 27.7392C22.646 28.5925 23.1737 29.7791 23.1958 31.0285C23.2179 32.2772 22.7322 33.4824 21.8506 34.3668H21.8437L12.2502 43.9602C11.6983 44.5128 11.699 45.4076 12.2509 45.9588C12.8028 46.5107 13.6976 46.51 14.2495 45.9581L23.8257 36.3806L38.7457 21.4606C39.3252 20.8776 40.113 20.5513 40.9346 20.5534C42.1937 20.5506 43.3306 21.3088 43.8128 22.4726C44.295 23.6358 44.0267 24.9755 43.134 25.8648L27.173 41.8354C26.8059 42.19 26.6583 42.7157 26.788 43.2097C26.917 43.7036 27.3027 44.0893 27.7966 44.2183C28.2906 44.348 28.8162 44.2003 29.1708 43.8333L45.1519 27.8537L51.5546 21.4509C52.1589 20.8438 52.9861 20.5134 53.8422 20.5368C54.6977 20.5596 55.5062 20.9349 56.0761 21.5737C57.1557 22.9079 57.0267 24.8486 55.7794 26.0283L51.7043 30.1034V30.1116L33.5674 48.2313C33.2004 48.5866 33.0528 49.1116 33.1825 49.6055C33.3115 50.0995 33.6971 50.4851 34.1911 50.6148C34.6857 50.7438 35.2107 50.5969 35.5653 50.2292L53.6884 32.1068C54.2769 31.4817 55.1116 31.1485 55.9684 31.1968C56.8239 31.2161 57.6324 31.5907 58.2009 32.2296C58.8135 32.9415 59.0598 33.8984 58.8694 34.818C58.8432 34.9615 58.808 35.1029 58.7631 35.2416C58.7438 35.3023 58.7238 35.3616 58.7011 35.4209C58.6617 35.5258 58.619 35.6272 58.5714 35.7279C58.5224 35.8245 58.4686 35.919 58.4099 36.0101C58.3706 36.0763 58.334 36.1432 58.2899 36.2067C58.1754 36.3709 58.0464 36.5254 57.9056 36.6689L51.8844 42.7129L51.8754 42.7212L39.9654 54.6278C39.5977 54.9824 39.4507 55.5074 39.5797 56.0014C39.7094 56.4953 40.0951 56.8817 40.589 57.0107C41.083 57.1404 41.608 56.9927 41.9632 56.6257L53.8478 44.7391C53.8478 44.7391 53.865 44.7302 53.8719 44.7233C54.8646 43.6464 56.4976 43.4622 57.7049 44.2914C57.7732 44.3335 57.8463 44.3645 57.9098 44.4128C57.9732 44.4604 58.0443 44.537 58.1133 44.5977C58.2078 44.675 58.2975 44.7571 58.383 44.8433C58.3892 44.8529 58.3961 44.8619 58.403 44.8702C58.6514 45.1744 58.8425 45.5201 58.968 45.8919C59.0474 46.1541 59.0901 46.4252 59.097 46.6984V46.8557C59.0881 47.4117 58.9473 47.9581 58.6873 48.4493C58.6562 48.5086 58.6238 48.5679 58.5879 48.6273C58.4561 48.8494 58.2995 49.0564 58.1202 49.2433C58.105 49.2599 58.094 49.2799 58.0767 49.2971L38.8898 68.4833C38.4663 68.9076 38.042 69.296 37.5956 69.6734C31.582 74.7619 23.2434 76.0989 15.9404 73.1448C15.4264 72.9358 14.9173 72.7054 14.4137 72.4536C12.0722 71.2794 9.96879 69.681 8.2096 67.7403ZM63.7351 62.7477L40.2392 76.3107C34.3925 79.698 27.2792 80.0891 21.0965 77.3634C22.855 77.5752 24.6321 77.5856 26.3934 77.3931C26.5341 77.3793 26.6659 77.3496 26.8046 77.3338C27.511 77.2475 28.2002 77.1372 28.8908 76.9902C29.1357 76.9398 29.3744 76.8702 29.6172 76.8108C30.1981 76.6701 30.7727 76.5114 31.3426 76.3252C31.6137 76.2376 31.8793 76.1389 32.1477 76.0423C32.683 75.8464 33.2101 75.6325 33.7316 75.398C34.0014 75.2766 34.2697 75.1538 34.5367 75.0213C35.0486 74.7681 35.5488 74.4915 36.0441 74.2003C36.2973 74.0589 36.5532 73.9092 36.8016 73.7492C37.3114 73.4242 37.8033 73.0696 38.291 72.7026C38.5042 72.5439 38.7229 72.397 38.9326 72.2307C39.5438 71.7389 40.1344 71.2132 40.7042 70.6537C40.7677 70.593 40.8367 70.5433 40.8988 70.4812L45.543 65.8363H45.5589C45.8066 65.8356 46.0501 65.7707 46.2653 65.6466L60.8459 57.2273L60.8618 57.2149C61.6034 56.7954 62.4843 56.6988 63.2998 56.9458C64.1152 57.1935 64.7934 57.764 65.1776 58.5243C65.8744 60.0923 65.2473 61.9316 63.7379 62.7477H63.7351ZM66.8154 50.512L59.4261 54.7789C59.4178 54.7789 59.413 54.7927 59.4047 54.7968L52.7315 58.6546L60.0925 51.293C60.3437 51.0377 60.572 50.7604 60.7755 50.4651C60.8417 50.372 60.8997 50.2788 60.9604 50.1829C61.0811 49.9905 61.1915 49.7918 61.2909 49.5883C61.3543 49.4593 61.4226 49.3337 61.4757 49.2019C61.6524 48.7549 61.78 48.2899 61.8559 47.8146C61.8786 47.6732 61.9014 47.5421 61.9138 47.4048C61.9324 47.2172 61.9407 47.0309 61.9407 46.8398C61.9407 46.6984 61.9311 46.5576 61.9214 46.4162C61.9214 46.3355 61.9214 46.2562 61.9111 46.1775L63.94 45.0047C64.6795 44.5777 65.5619 44.4735 66.3808 44.7157C67.1997 44.9571 67.8833 45.5249 68.2717 46.2844C68.9651 47.8574 68.3317 49.6986 66.8182 50.512H66.8154ZM67.5218 39.6754L62.5271 42.5619L60.89 43.507C60.7659 43.3152 60.6313 43.1303 60.4858 42.9544C60.3002 42.7537 60.1022 42.5646 59.8925 42.3894C59.8697 42.3708 59.8511 42.3473 59.8283 42.3287C59.7097 42.2314 59.58 42.1535 59.4544 42.0658C59.3282 41.9782 59.2226 41.8892 59.0984 41.814C58.5872 41.5112 58.0333 41.287 57.4551 41.1504L59.9194 38.6875C60.156 38.4405 60.3733 38.1749 60.5692 37.8935C60.6451 37.7879 60.71 37.6817 60.7838 37.5727C60.8866 37.4092 60.977 37.2408 61.0666 37.0698C61.2267 36.7572 61.3605 36.4316 61.4661 36.0963C61.4806 36.0543 61.4985 36.0142 61.5116 35.9722L64.6478 34.1605C65.3867 33.7349 66.2676 33.6307 67.0851 33.8735C67.9026 34.1157 68.5849 34.6835 68.9713 35.4437C69.6632 37.0153 69.0347 38.8552 67.526 39.6754H67.5218Z" fill="#1F1F9C"/>
						<path d="M70.3826 15.8686C70.9345 16.4198 71.8286 16.4198 72.3805 15.8686L81.5642 6.68496C81.9312 6.33036 82.0788 5.80467 81.9491 5.31072C81.8201 4.81677 81.4345 4.43113 80.9405 4.30212C80.4466 4.17242 79.9209 4.32006 79.5663 4.68707L70.3826 13.8707C69.8314 14.4226 69.8314 15.3167 70.3826 15.8686Z" fill="#1F1F9C"/>
						<path d="M79.8372 15.7789L72.7729 20.0175C72.3307 20.2727 72.0602 20.7467 72.0658 21.2579C72.072 21.7684 72.3527 22.2361 72.8012 22.481C73.2496 22.726 73.7953 22.7101 74.2285 22.439L81.2929 18.2004C81.7351 17.9451 82.0055 17.4712 82 16.96C81.9938 16.4494 81.7123 15.9817 81.2646 15.7368C80.8162 15.4919 80.2705 15.5078 79.8372 15.7789Z" fill="#1F1F9C"/>
						<path d="M64.3926 15.4357C65.0907 15.7847 65.94 15.5012 66.2883 14.803L70.527 6.32583C70.876 5.62699 70.5925 4.77844 69.8936 4.42936C69.1955 4.08097 68.3469 4.36382 67.9979 5.06267L63.7593 13.5399C63.4102 14.238 63.6937 15.0873 64.3926 15.4357Z" fill="#1F1F9C"/>
						<path d="M31.229 11.8952C31.5436 12.601 32.3659 12.9231 33.0758 12.6182C33.7863 12.314 34.1202 11.4958 33.8257 10.7818L29.5871 0.891679C29.2725 0.185934 28.4501 -0.136239 27.7396 0.168687C27.0297 0.472923 26.6958 1.29112 26.9904 2.00514L31.229 11.8952Z" fill="#1F1F9C"/>
						<path d="M38.1792 12.751C38.9595 12.751 39.5921 12.1183 39.5921 11.3381V2.86087C39.5921 2.08062 38.9595 1.448 38.1792 1.448C37.399 1.448 36.7664 2.08062 36.7664 2.86087V11.3381C36.7664 12.1183 37.399 12.751 38.1792 12.751Z" fill="#1F1F9C"/>
						<path d="M25.7724 15.047C26.2601 15.6561 27.1501 15.7548 27.7592 15.2671C28.3684 14.78 28.4671 13.8901 27.9793 13.2809L22.3278 6.21655C21.8408 5.60739 20.9508 5.50874 20.3417 5.99648C19.7325 6.48353 19.6339 7.37348 20.1209 7.98264L25.7724 15.047Z" fill="#1F1F9C"/>
					</g>
					<defs>
						<clipPath id="clip0_559_15798">
							<rect width="82" height="82" fill="white"/>
						</clipPath>
					</defs>
				</svg>
				<h1 class="agency-heading text-32px mb-15px">Sukses</h1>
				<p class="agency-text-grey-600 mb-20px">Anda telah berhasil membuat kata sandi baru tekan tombol ini untuk masuk</p>
				<button type="button" class="btn__agency btn--dark-blue btn-enter-login p-12px-30px-10px-30px" data-bs-dismiss="modal" aria-label="Close"><span class="position-relative order-50">Masuk <i class="fas fa-arrow-right fa-fw ml-5px"></i></span></button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Warning -->
<div class="modal modal-agency width-full fade" id="ModalBack" tabindex="-1" style="display: none;" aria-labelledby="ModalBackLabel" aria-hidden="true">
	<div class="modal-dialog modal-agency-dialog modal-max-w-430px modal-agency-dialog-centered">
		<div class="modal-content modal-agency-content">
			<div class="modal-agency-body agency-text-center p-80px-40px-0px-40px position-relative">
				<svg class="w-100px-h-100px m-0-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" fill="none">
					<path d="M50.0017 54.0462V33.8864M50.0017 68.9888V69.166M75.2014 85.956H24.802C17.9177 85.956 12.108 81.3551 10.2802 75.0604C9.49989 72.3733 10.4586 69.5745 11.9251 67.1915L37.1248 21.2417C43.0288 11.6476 56.9746 11.6476 62.8787 21.2418L88.0783 67.1915C89.5448 69.5745 90.5035 72.3733 89.7232 75.0603C87.8954 81.3551 82.0857 85.956 75.2014 85.956Z" stroke="#1F1F9C" stroke-width="8.33333" stroke-linecap="round" stroke-linejoin="round"/>
				</svg>
				<h1 class="agency-heading text-32px mb-15px">Peringatan!</h1>
				<p class="agency-text-grey-600 mb-20px">Apakah anda yakin membatalkan proses ini?</p>
			</div>
			<div class="modal-agency-footer">
				<button class="btn-no agency-uppercase agency-self-center" data-bs-dismiss="modal" aria-label="Close">Tidak</button>
				<button type="button" class="btn__agency btn--dark-blue btn-close btn-prev-modal p-12px-25px-10px-25px" type="button" data-bs-dismiss="modal" aria-label="Close" aria-controls="login">
					<span class="position-relative order-50">
						Iya
						<svg class="display-inline-block position-relative top-min-1px left-6px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
							<path d="M5.22353 4L11.9059 4.09412M11.9059 4.09412L12 10.7765M11.9059 4.09412L4 12" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
						</svg>
					</span>
				</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Loading -->
<div class="modal modal-agency width-full fade" id="ModalLoading" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" style="display: none;" aria-labelledby="ModalLoadingLabel" aria-hidden="true">
	<div class="modal-dialog modal-agency-dialog modal-max-w-360px modal-agency-dialog-centered">
		<div class="modal-content modal-agency-content">
			<div class="modal-agency-body agency-text-center p-100px-40px-100px-40px position-relative">
				<img class="w-75px display-block m-x-auto" src="/o/agency-theme/images/loading-1.gif" />
			</div>
		</div>
	</div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script src="/o/agency-theme/js/multiform/multiform.js" type="text/javascript"></script>
	<script src="/o/agency-theme/js/multiform/otp.js" type="text/javascript"></script>
    <script src="<%= request.getContextPath() %>/auth/login/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>