<%@ include file="../init.jsp"%>

<script src="<%=request.getContextPath()%>/dashboard/js/main.js" type="text/javascript"></script>

<%-- Membuat URL untuk step2.jsp --%>
<portlet:renderURL var="step2URL">
	<portlet:param name="jspPage" value="/dashboard/step2.jsp" />
</portlet:renderURL>

<div class="topbar">
	<div class="container-axa">
		<div class="display-flex justify-content-end">
			<ul class="topbar__nav">
				<li><a class="topbar-link" href="#"><i
						class="fas fa-calculator"></i> Simulasi</a></li>
				<li><a class="topbar-link" href="#"><i
						class="fas fa-phone-alt"></i> Hubungi Kami</a></li>
				<li><a class="btn btn__agency btn--dark-blue overflow-hidden"
					href="#"><span class="position-relative">Login Agen</span></a></li>
			</ul>
		</div>
	</div>
</div>

<nav class="navbar-axa-wrapper">
	<div class="navbar-axa">
		<div class="container-axa">
			<div class="navbar-axa__inner">
				<div class="btn-responsive-wrapper" id="toggle-menu">
					<!-- Mobile menu button-->
					<button class="display-block">
						<div id="hamburger">
							<span></span> <span></span> <span></span>
						</div>
					</button>
				</div>
				<div class="brand-logo-wrapper">
					<img class="brand-logo"
						src="/o/mypage-theme/images/logo_axa_mandiri.png"
						alt="Your Company">
					<div class="cloak"></div>
				</div>
				<div class="nav-axa-wrapper">
					<div class="nav-axa">
						<div class="nav-axa__inner">
							<div class="nav-axa__mega-menu">
								<span>Asuransi Kami</span>
								<div class="nav-axa__mega-menu--hover">
									<div class="container-axa">
										<div class="nav-axa__mega-menu-content">
											<div class="col align-self-center border-separate">
												<h3>Asuransi Kami</h3>
												<p>Temukan berbagai jenis asuransi dengan solusi
													perlindungan sempurna dan manfaat optimal, sesuai dengan
													kebutuhan Anda dan keluarga.</p>
											</div>
											<div class="col">
												<div class="col-grid">
													<div class="col">
														<span>Solusi Kamu</span>
														<ul>
															<li><a class="insurance-solutions" href="#"
																data-id="travel-insurance">Asuransi Perjalanan <i
																	class="far fa-chevron-right fa-fw"></i></a></li>
															<li><a class="insurance-solutions" href="#"
																data-id="vehicle-insurance">Asuransi Kendaraan <i
																	class="far fa-chevron-right fa-fw"></i></a></li>
															<li><a class="insurance-solutions" href="#"
																data-id="health-insurance">Asuransi Kesehatan <i
																	class="far fa-chevron-right fa-fw"></i></a></li>
															<li><a class="insurance-solutions" href="#"
																data-id="other-insurance">Asuransi Lainnya <i
																	class="far fa-chevron-right fa-fw"></i></a></li>
														</ul>
													</div>
													<div class="col">
														<div class="card-mega-menu insurance-solutions-details"
															id="travel-insurance" style="display: block;">
															<span>Asuransi Perjalanan</span>
															<div class="card-mega-menu-inner">
																<div class="col">
																	<a href="#">
																		<figure>
																			<img
																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp"
																				class="img-product"
																				alt="Asuransi SmartTravel Domestik">
																		</figure>
																		<figcaption>Asuransi SmartTravel Domestik</figcaption>
																	</a>
																</div>
																<div class="col">
																	<a href="#">
																		<figure>
																			<img
																				src="https://mypage.axa.co.id/Product/Banner - Travel International.webp">
																		</figure>
																		<figcaption>Asuransi SmartTravel
																			Internasional</figcaption>
																	</a>
																</div>
															</div>
														</div>
														<div class="card-mega-menu insurance-solutions-details"
															id="vehicle-insurance">
															<span>Asuransi Kendaraan</span>
															<div class="card-mega-menu-inner">
																<div class="col">
																	<a href="#">
																		<figure>
																			<img
																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp"
																				class="img-product"
																				alt="Asuransi SmartTravel Domestik">
																		</figure>
																		<figcaption>Asuransi SmartTravel Domestik</figcaption>
																	</a>
																</div>
																<div class="col">
																	<a href="#">
																		<figure>
																			<img
																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp"
																				class="img-product"
																				alt="Asuransi SmartTravel Domestik">
																		</figure>
																		<figcaption>Asuransi SmartTravel Domestik</figcaption>
																	</a>
																</div>
															</div>
														</div>
														<div class="card-mega-menu insurance-solutions-details"
															id="health-insurance">
															<span>Asuransi Kesehatan</span>
															<div class="card-mega-menu-inner">
																<div class="col">
																	<a href="#">
																		<figure>
																			<img
																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp"
																				class="img-product"
																				alt="Asuransi SmartTravel Domestik">
																		</figure>
																		<figcaption>Asuransi SmartTravel Domestik</figcaption>
																	</a>
																</div>
																<div class="col">
																	<a href="#">
																		<figure>
																			<img
																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp"
																				class="img-product"
																				alt="Asuransi SmartTravel Domestik">
																		</figure>
																		<figcaption>Asuransi SmartTravel Domestik</figcaption>
																	</a>
																</div>
															</div>
														</div>
														<div class="card-mega-menu insurance-solutions-details"
															id="other-insurance">
															<span>Asuransi Lainnya</span>
															<div class="card-mega-menu-inner">
																<div class="col">
																	<a href="#">
																		<figure>
																			<img
																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp"
																				class="img-product"
																				alt="Asuransi SmartTravel Domestik">
																		</figure>
																		<figcaption>Asuransi SmartTravel Domestik</figcaption>
																	</a>
																</div>
																<div class="col">
																	<a href="#">
																		<figure>
																			<img
																				src="https://mypage.axa.co.id/Product/Banner - Domestik Travel.webp"
																				class="img-product"
																				alt="Asuransi SmartTravel Domestik">
																		</figure>
																		<figcaption>Asuransi SmartTravel Domestik</figcaption>
																	</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<a href="#" class="nav-link-axa align-self-center">Promo &
								News</a> <a href="#" class="nav-link-axa align-self-center">Kirim
								Ulang Polis</a> <a href="#" class="nav-link-axa align-self-center">Tentang
								Axa Insurance</a> <a href="#" class="nav-link-axa align-self-center">Emma
								By Axa</a>
						</div>
					</div>
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

<header class="hero">
	<div class="hero__home">
		<div class="hero__home--grid">
			<div class="col">
				<img src="/o/mypage-theme/images/banner_home_1.jpg" alt="">
			</div>
			<div class="col">
				<h1>
					Asuransi SmartTravel <br /> Internasional
				</h1>
				<p>
					Bebas melangkah lebih yakin dengan Asuransi <br />AXA Travel
					International!
				</p>
				<div class="card-hero">
					<div class="card-header-hero">
						<h3>Plan International</h3>
					</div>
					<div class="card-body-hero">
						<p>Polis ini untuk perjalanan dari Indonesia dan kembali ke Indonesia. dengan jangkauan hampir seluruh negara di Asia**</p>
						<a href="#Sec-2">Pelajari Plan</a>
					</div>
					<div class="card-footer-hero">
						<p class="agency__text_axa_bluesky_900">Mulai Dari</p>
						<div class="price">
							<span class="display-block agency__text_axa_bluesky_900">IDR 62.000</span>
						</div>
						<small class="agency__text_axa_bluesky_900">*ketentuan berlaku</small>
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
							<input class="input-control-axa input-control-axa--outline form-item" type="text" id="Fromtravel" name="DepartureDate" autocomplete="off">
							<div class="label-text">Dari</div>
						</div>
						<div class="separated-arrow">
							<i class="fas fa-arrow-right align-self-center text-12px"></i>
						</div>
						<div class="calendar-col position-relative" id="Totravel-wrapper">
							<input class="input-control-axa input-control-axa--outline input-icon-date form-item" type="text" id="Totravel" name="ArrivalDate" autocomplete="off">
							<div class="label-text">Ke</div>
						</div>
					</div>
				</div>
				<div class="mb-27px">
					<label class="display-block" for="destinasi">Destinasi</label>
					<div class="destinasi-wrapper">
						<select id="destinasi" multiple="multiple" autocomplete="off">
							<option value="Worldwide">Worldwide</option>
							<option value="Asia" selected>Asia</option>
						</select>
					</div>
				</div>
			</div>
			<div class="simulasi__inner--right">
				<div>
					<label class="display-block" for="pilih-jenis-penumpang">Pilih jenis penumpang</label>
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
							<div id="select-adult-wrapper">
								<select class="align-self-center" name="" id="select-adult">
								</select>
							</div>
						</div>
						<div class="input-group-axa input-group-axa--border child-total gohide">
							<div id="select-kid-wrapper">
								<select class="align-self-center" name="" id="select-kid">
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
				<div class="grid-bottom">
					<div>
					<ul>
						<li>Polis ini untuk perjalanan dari Indonesia dan kembali ke Indonesia.</li>
						<li>Perjalanan harus dilakukan secara bersama - sama dalam kondisi pergi dan kembali ke Indonesia.</li>
						<li>Apabila terpisah disarankan untuk melakukan pembelian terpisah dengan polis individu.</li>
					</ul>
					</div>
					<div>
						<div class="mb-30px align-self-center">
							<button class="btn btn__agency btn--dark-blue width-full h-54px" type="submit">
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
			<div class="swiper swiper-plan overflow-visible">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<div class="card-plan-wrapper">
							<div class="card-plan__inner">
								<div class="card-plan">
									<div class="card-plan-body">
										<div class="flex-justify-between">
											<strong>Platinum</strong>
										</div>
										<h3 id="PriceWrapper-Platinum">IDR 15.093.800,00</h3>
										<p>USD 9.23</p>
										<div class="benefit_type">
											<span class="benefit_type__title">Jaminan Utama</span>
											<div class="benefit_type__item">
												<ul class="list-disc">
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 2.900</strong>
													</span></li>
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 230 per malam</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
												</ul>
											</div>
										</div>

										<div class="benefit_type">
											<span class="benefit_type__title">Jaminan Optional</span>
											<div class="benefit_type__item">
												<ul class="list-disc">
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 2.900</strong>
													</span></li>
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 230 per malam</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="card-plan-footer">
										<div class="btn-buy agency__text-center">
											<a class="btn btn__agency btn--dark-blue-outline" href="#">
												<span class="position-relative">Pilih <i
													class="fas fa-arrow-right"></i></span>
											</a>
										</div>
										<div class="link-comparison agency__text-center">
											<a href="#">Lihat Perbandingan Plan</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="swiper-slide">
						<div class="card-plan-wrapper">
							<div class="card-plan__inner">
								<div class="card-plan">
									<div class="card-plan-body">
										<div class="flex-justify-between">
											<strong>Gold</strong> <span
												class="card-label align-self-center">Rekomendasi <i
												class="fas fa-star"></i>
											</span>
										</div>
										<h3 id="PriceWrapper-Gold"></h3>
										<p>USD 5.69</p>
										<div class="benefit_type">
											<span class="benefit_type__title">Jaminan Utama</span>
											<div class="benefit_type__item">
												<ul class="list-disc">
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 2.900</strong>
													</span></li>
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 230 per malam</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
												</ul>
											</div>
										</div>

										<div class="benefit_type">
											<span class="benefit_type__title">Jaminan Optional</span>
											<div class="benefit_type__item">
												<ul class="list-disc">
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 2.900</strong>
													</span></li>
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 230 per malam</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="card-plan-footer">
										<div class="btn-buy agency__text-center">
											<a class="btn btn__agency btn--dark-blue-outline" href="#">
												<span class="position-relative">Pilih <i
													class="fas fa-arrow-right"></i></span>
											</a>
										</div>
										<div class="link-comparison agency__text-center">
											<a href="#">Lihat Perbandingan Plan</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="swiper-slide">
						<div class="card-plan-wrapper">
							<div class="card-plan__inner">
								<div class="card-plan">
									<div class="card-plan-body">
										<div class="flex-justify-between">
											<strong>Silver</strong> <span
												class="card-label minimum align-self-center">Min
												Persyaratan visa</span>
										</div>
										<h3 id="PriceWrapper-Silver">IDR 62.000,00</h3>
										<p>USD 4.06</p>
										<div class="benefit_type">
											<span class="benefit_type__title">Jaminan Utama</span>
											<div class="benefit_type__item">
												<ul class="list-disc">
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 2.900</strong>
													</span></li>
													<li><span class="card-cols"> <span>Batas
																Tahunan</span> <strong>USD 230 per malam</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
													<li><span class="card-cols"> <span>Akomodasi
																orang tua</span> <strong>Max USD 1.500</strong>
													</span></li>
												</ul>
											</div>
										</div>


									</div>
									<div class="card-plan-footer">
										<div class="btn-buy agency__text-center">
											<a class="btn btn__agency btn--dark-blue" href="#"> <span
												class="position-relative"> <svg
														class="display-inline-block vertical-align-middle"
														xmlns="http://www.w3.org/2000/svg" width="16" height="16"
														viewBox="0 0 16 16" fill="none">
                                                            <path
															d="M15.75 8C15.75 12.2812 12.25 15.75 8 15.75C3.71875 15.75 0.25 12.2812 0.25 8C0.25 3.75 3.71875 0.25 8 0.25C12.25 0.25 15.75 3.75 15.75 8ZM7.09375 12.125L12.8438 6.375C13.0312 6.1875 13.0312 5.84375 12.8438 5.65625L12.125 4.96875C11.9375 4.75 11.625 4.75 11.4375 4.96875L6.75 9.65625L4.53125 7.46875C4.34375 7.25 4.03125 7.25 3.84375 7.46875L3.125 8.15625C2.9375 8.34375 2.9375 8.6875 3.125 8.875L6.375 12.125C6.5625 12.3125 6.90625 12.3125 7.09375 12.125Z"
															fill="white" />
                                                        </svg> Plan Dipilih
											</span>
											</a>
										</div>
										<div class="link-comparison agency__text-center">
											<a href="#">Lihat Perbandingan Plan</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>

	<div class="chosee-plan__tabs">
		<ul class="nav nav-tabs" id="TabPlan" role="tablist">
			<li class="nav-item row-span-1" role="presentation">
				<button class="nav-link active" id="SMI-tab" data-bs-toggle="tab"
					data-bs-target="#SMI-tab-pane" type="button" role="tab"
					aria-controls="SMI-tab-pane" aria-selected="true">Perjalanan
					International</button>
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
									<option value="#Sec-1">1. Manfaat Produk</option>
									<option value="#Sec-2">2. Perbandingan Plan</option>
									<option value="#Sec-3">3. FAQ</option>
								</select>
							</div>
							<div class="sticky-tab-pane">
								<ul class="sitemap-tabs">
									<li class="tab-link-pane Sec-1 is-active"><a href="#Sec-1">Manfaat
											Produk</a></li>
									<li class="tab-link-pane Sec-2"><a href="#Sec-2">Perbandingan
											Plan</a></li>
									<li class="tab-link-pane Sec-3"><a href="#Sec-3">FAQ</a></li>
								</ul>
								<ul class="download-tab">
									<li><a class="display-flex gap-4level" href="#"> <span>Brosur</span>
									</a></li>
									<li><a class="display-flex gap-4level" href="#"> <span>RIPLAY SmartTravel International</span>
									</a></li>
								</ul>
							</div>
						</div>
						<div class="col-tab">
							<section class="smart-mediacare-inter__benefit" id="Sec-1">
								<h1>Manfaat Produk</h1>
								<div class="card-benefit-wrapper">
									<div class="card-benefit">
										<img src="/o/mypage-theme/images/icon_sun-cream_2.svg">
										<h3>Kecelakaan diri</h3>
										<p>Melindungi Tertanggung dari risiko kecelakaan yang
											tidak disengaja dan menyebabkan kematian atau cacat tetap
											selama perjalanan.</p>
									</div>
									<div class="card-benefit">
										<img src="/o/mypage-theme/images/icon_sun-cream_2.svg">
										<h3>Ketidaknyamanan selama Perjalanan</h3>
										<p>Melindungi Tertanggung dari risiko kecelakaan yang
											tidak disengaja dan menyebabkan kematian atau cacat tetap
											selama perjalanan.</p>
									</div>
									<div class="card-benefit">
										<img src="/o/mypage-theme/images/icon_sun-cream_2.svg">
										<h3>Santunan Tunai Rumah Sakit</h3>
										<p>Melindungi Tertanggung dari risiko kecelakaan yang
											tidak disengaja dan menyebabkan kematian atau cacat tetap
											selama perjalanan.</p>
									</div>
								</div>
							</section>
							<section class="smart-mediacare-inter__table" id="Sec-2">
								<h1>Perbandingan Plan</h1>

								<div class="panel-table">
									<div class="panel-table-header">
										<h4>Main Benefit</h4>
									</div>
									<div class="panel-table-body">
										<div class="table-wrapper">
											<table>
												<thead>
													<tr>
														<td>&nbsp;</td>
														<td>Platinum</td>
														<td>Gold</td>
														<td>Silver</td>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>Medical, Dental and Other Expenses <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Childcare & Compassionate Benefit <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Hospital Cash Allowance (Overseas) <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Loss of Income due to Accident <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>

								<div class="panel-table">
									<div class="panel-table-header">
										<h4>Travel Inconvenience Cover</h4>
									</div>
									<div class="panel-table-body">
										<div class="table-wrapper">
											<table>
												<thead>
													<tr>
														<td>&nbsp;</td>
														<td>Platinum</td>
														<td>Gold</td>
														<td>Silver</td>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>Medical, Dental and Other Expenses <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Childcare & Compassionate Benefit <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Hospital Cash Allowance (Overseas) <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Loss of Income due to Accident <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>

								<div class="panel-table">
									<div class="panel-table-header">
										<h4>Accident & Medical Cover</h4>
									</div>
									<div class="panel-table-body">
										<div class="table-wrapper">
											<table>
												<thead>
													<tr>
														<td>&nbsp;</td>
														<td>Platinum</td>
														<td>Gold</td>
														<td>Silver</td>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>Medical, Dental and Other Expenses <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Childcare & Compassionate Benefit <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Hospital Cash Allowance (Overseas) <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
													<tr>
														<td>Loss of Income due to Accident <a href="#"
															class="info-link">?</a>
														</td>
														<td>Rp 2.040.000.000</td>
														<td>Rp 4.000.000.000</td>
														<td>Rp 4.000.000.000</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>

								<div class="panel-table">
									<div class="panel-table-header">
										<h4>Other Cover</h4>
									</div>
									<div class="panel-table-body">
										<div class="table-wrapper">
											<table>
												<thead>
													<tr>
														<td>&nbsp;</td>
														<td>Platinum</td>
														<td>Gold</td>
														<td>Silver</td>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>Hijacking</td>
														<td>IDR 500,000/24 hrs<br /> upto IDR 10,000,000
														</td>
														<td>IDR 500,000/24 hrs<br /> upto IDR 10,000,000
														</td>
														<td>IDR 500,000/24 hrs<br /> upto IDR 10,000,000
														</td>
													</tr>
													<tr>
														<td>Terrorism</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
													</tr>
													<tr>
														<td>Personal Liability</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
													</tr>
													<tr>
														<td>Emergency Call</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
													</tr>
													<tr>
														<td>Household Protection</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
													</tr>
													<tr>
														<td>Damage / Loss of Golfing Equipment including Hole
															in One celebration expenses</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
														<td>Rp 2.000.000.000</td>
													</tr>
													<tr>
														<td>Own Risk for Damage of Rental Vehicle</td>
														<td>Rp 10.000.000</td>
														<td>Rp 10.000.000</td>
														<td>Rp 10.000.000</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>

							</section>
							<section class="smart-mediacare-inter__faq" id="Sec-3">
								<h1 class="agency__uppercase">Faq</h1>
								<div class="accordion" id="accordionFAQ">
									<div class="accordion-item">
										<div class="accordion-header">
											<button class="accordion-button" data-bs-toggle="collapse"
												data-bs-target="#collapseOne" aria-expanded="true"
												aria-controls="collapseOne">
												Usia peserta diatas 60 tahun bisa membeli polis Asuransi
												Smart Travel (Travel International) ? <i
													class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
											</button>
										</div>
										<div id="collapseOne" class="accordion-collapse collapse show"
											data-bs-parent="#accordionFAQ">
											<div class="accordion-body">
												<p>Bisa, asuransi kami melindungi peserta hingga usia 85
													tahun, dengan ketentuan:</p>
												<p>- Diatas Usia 65 s/d 75 (Maks 35% untuk Benefit
													Medical (3&6))</p>
												<p>- Diatas Usia 75 s/d 85 (Maks 15% untuk Benefit
													Medical (3&6))</p>

											</div>
										</div>
									</div>
									<div class="accordion-item">
										<div class="accordion-header">
											<button class="accordion-button collapsed"
												data-bs-toggle="collapse" data-bs-target="#collapseTwo"
												aria-expanded="false" aria-controls="collapseTwo">
												Apakah Flight Misconnection dijamin? <i
													class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
											</button>
										</div>
										<div id="collapseTwo" class="accordion-collapse collapse"
											data-bs-parent="#accordionFAQ">
											<div class="accordion-body">
												<p>Dijamin, dengan ketentuan yang mengalami
													keterlambatan adalah pada pesawat kedua, minimal 4 jam.
													Apabila pesawat pertama terlambat dan menyebabkan
													tertanggung tertinggal untuk penerbangan lanjutan, maka
													keterlambatan tersebut tidak dijamin.</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<div class="accordion-header">
											<button class="accordion-button collapsed"
												data-bs-toggle="collapse" data-bs-target="#collapseThree"
												aria-expanded="false" aria-controls="collapseThree">
												Bagaimana jika bagasi mengalami keterlambatan sehingga saya
												harus membeli perlengkapan tambahan? <i
													class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
											</button>
										</div>
										<div id="collapseThree" class="accordion-collapse collapse"
											data-bs-parent="#accordionFAQ">
											<div class="accordion-body">
												<p>Dijamin, dengan ketentuan pada waktu klaim,
													Tertanggung harus melampirkan Kwitansi pembelian.</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<div class="accordion-header">
											<button class="accordion-button collapsed"
												data-bs-toggle="collapse" data-bs-target="#collapseFour"
												aria-expanded="false" aria-controls="collapseFour">
												Jika saya telah berada di Luar Negeri, apakah dapat membeli
												Polis Asuransi perjalanan AXA (Travel International) sampai
												dengan perjalanan saya berakhir? <i
													class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
											</button>
										</div>
										<div id="collapseFour" class="accordion-collapse collapse"
											data-bs-parent="#accordionFAQ">
											<div class="accordion-body">
												<p>Tidak, sesuai ketentuan polis, perjalanan yang
													dijamin adalah dimulai dari Indonesia dan kembali ke
													Indonesia, sehingga pembelian jika telah berada di Luar
													Negeri tidak dijamin oleh polis.</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<div class="accordion-header">
											<button class="accordion-button collapsed"
												data-bs-toggle="collapse" data-bs-target="#collapseFive"
												aria-expanded="false" aria-controls="collapseFive">
												Jika Saya berolahraga bermain Ski atau melakukan diving,
												apakah dijamin? <i
													class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
											</button>
										</div>
										<div id="collapseFive" class="accordion-collapse collapse"
											data-bs-parent="#accordionFAQ">
											<div class="accordion-body">
												<p>Tidak, semua olahraga musim dingin, olahraga
													berbahaya, aktivitas dalam air, pendakian tidak dijamin
													oleh polis Asuransi perjalanan AXA.</p>
											</div>
										</div>
									</div>
									<div class="accordion-item">
										<div class="accordion-header">
											<button class="accordion-button collapsed"
												data-bs-toggle="collapse" data-bs-target="#collapseSix"
												aria-expanded="false" aria-controls="collapseSix">
												Apa yang dimaksud dengan Pre Existing Conditions dan
												contohnya? <i
													class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
											</button>
										</div>
										<div id="collapseSix" class="accordion-collapse collapse"
											data-bs-parent="#accordionFAQ">
											<div class="accordion-body">
												<p>"Kondisi Yang Sudah Ada Sebelumnya berarti sebagai
													setiap penyakit, kelemahan cacat pisik atau kondisi yang
													telah anda sadari dan/atau telah Anda derita sebelum
													tanggal awal penutupan polis ini, contoh, tapi tidak
													terbatas atas:</p>
												<ul>
													<li>Tekanan Darah Tinggi, Penyakit Jantung dan
														Pembuluh Darah (Kardiovaskuler), Penyakit Pembuluh Darah
														Otak (Cerebro Vasculer Disease); Kelainan Darah</li>
													<li>Katarak;</li>
													<li>Semua jenis kanker / tumor / polip / kista/
														benjolan termasuk benjolan apapun di payudara;</li>
													<li>Kencing manis (Diabetes melitus), Pembesaran
														kelenjar gondok (Hipertiroid), Kekurangan hormon tiroid;</li>
													<li>Hepatitis;</li>
													<li>Radang atau tukak pada lambung atau pada usus dua
														belas jari;</li>
													<li>Radang persendian (rheumatik/ gout) atau gangguan
														tulang persendian dan penyakit otot lainnya;</li>
													<li>TBC, Asma</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</section>
							<div class="smart-mediacare-inter__download">
								<h1>Unduh</h1>
								<div class="table-wrapper">
									<table>
										<tr>
											<td><i class="icon file-pdf"></i></td>
											<td>
												<div class="td-inner">
													<p class="agency__normalcase letter-spacing-0px text-16px">Brosur-Asuransi-SmartMedicare</p>
												</div>
											</td>
											<td><p
													class="date text-14px agency__uppercase letter-spacing-1px">29
													aug 2023</p></td>
											<td>
												<div class="agency__text-center">
													<a href="#"
														class="btn__agency btn--dark-blue display-block text-12px agency__text-center">
														<span class="position-relative order-10">Downlaod</span> <svg
															class="position-relative order-10 display-inline-block vertical-align-min-2px"
															xmlns="http://www.w3.org/2000/svg" width="14" height="14"
															viewBox="0 0 17 16" fill="none">
                                                                <path
																d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394"
																stroke="white" stroke-width="2" stroke-linecap="round"
																stroke-linejoin="round"></path>
                                                            </svg>
													</a>
												</div>
											</td>
										</tr>
										<tr>
											<td><i class="icon file-pdf"></i></td>
											<td>
												<div class="td-inner">
													<p class="agency__normalcase letter-spacing-0px text-16px">Brosur-Asuransi-SmartMedicare</p>
												</div>
											</td>
											<td><p
													class="date text-14px agency__uppercase letter-spacing-1px">29
													aug 2023</p></td>
											<td>
												<div class="agency__text-center">
													<a href="#"
														class="btn__agency btn--dark-blue display-block text-12px agency__text-center">
														<span class="position-relative order-10">Download</span> <svg
															class="position-relative order-10 display-inline-block vertical-align-min-2px"
															xmlns="http://www.w3.org/2000/svg" width="14" height="14"
															viewBox="0 0 17 16" fill="none">
                                                                <path
																d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394"
																stroke="white" stroke-width="2" stroke-linecap="round"
																stroke-linejoin="round"></path>
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

<div class="sticky-plan">
	<div class="sticky-plan__inner position-relative">
		<div class="code-promo">
			<a class="trigger-collapse-promo" href="javascript:void(0)">
				<div class="container-axa">
					<div class="code-promo__inner">
						<span>gunakan kode promo</span> <i
							class="fas fa-chevron-right fa-fw"></i>
					</div>
				</div>
			</a>
		</div>
		<div class="detail-summary">
			<a class="trigger-collapse-summary-detail" href="javascript:void(0)">
				<div class="container-axa">
					<div class="detail-summary__inner">
						<span>Detail</span> <i class="far fa-times fa-fw"></i>
					</div>
				</div>
			</a>
		</div>

		<div class="sticky-collapse-promo" id="collapseCodepromo">
			<div class="container-axa">
				<form action="">
					<div class="sticky-collapse-promo__grid">
						<div class="col">
							<label for="kode-promo">Kode Promo</label>
							<div class="input-group-axa input-group-axa--border">
								<input class="input-control-axa" placeholder="Isi Kode Promo"
									type="text" maxlength="13">
								<button type="button" class="btnClear">
									<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
										viewBox="0 0 24 24" fill="none">
                                            <path
											d="M3.17766 14.9999C4.43741 18.8326 8.04535 21.5999 12.2996 21.5999C17.6015 21.5999 21.8996 17.3018 21.8996 11.9999C21.8996 6.69797 17.6015 2.3999 12.2996 2.3999C8.74625 2.3999 5.6438 4.33046 3.98392 7.1999M6.89961 8.3999H2.09961V3.5999"
											stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round" />
                                        </svg>
								</button>
							</div>
						</div>
						<div class="col">
							<button class="btn btn__agency btn--dark-blue" type="button">
								<span class="position-relative order-10">Pakai Kode Promo
									<i class="fas fa-arrow-right"></i>
								</span>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="sticky-plan__summary">
			<div class="container-axa">
				<div class="sticky-plan__summary-grid">
					<div class="col">
						<div class="price">
							<div class="price-left">
								<p>Harga</p>
								<strong>IDR 23.823.000,00</strong>
							</div>
							<div class="price-right">
								<a class="trigger-collapse-plan-detail"
									href="javascript:void(0)"><span>Lihat Detail <i
										class="far fa-search"></i></span></a>
							</div>
						</div>
					</div>
					<div class="col">

						<!-- <a class="btn btn__agency btn--dark-blue" href="#"> <span
							class="position-relative">Lanjutkan <i
								class="fas fa-arrow-right"></i>
						</span>
						</a> -->

						<a class="btn btn__agency btn--dark-blue" href="<%=step2URL%>">
							<span class="position-relative">Lanjutkan <i
								class="fas fa-arrow-right"></i></span>
						</a>

					</div>
				</div>
			</div>
		</div>
		<div class="sticky-plan-collapse-summary" id="collapsePlandetail">
			<div class="container-axa">
				<div class="sticky-plan-collapse-summary__grid">
					<div class="col">
						<p>Plan Pilihan</p>
						<div id="select-plan-wrapper" class="position-relative">
							<select name="select-plan" id="select-plan">
								<option value="Plan A">Plan A</option>
								<option value="Plan B">Plan B</option>
								<option value="Plan C">Plan C</option>
							</select>
						</div>
					</div>
					<div class="col">
						<div class="col-grid">
							<div class="col">
								<p>Proteksi Anda</p>
								<div class="protection">
									<div class="col">
										<ul>
											<li><span>Dewasa</span> <span>2 Dewasa</span> <span>USD
													62.460.222,62</span></li>
										</ul>
										<ul>
											<li><span>Anak</span> <span>1 anak</span> <span>USD
													3.089</span></li>
										</ul>
									</div>
									<div class="col">
										<ul>
											<li><span>Biaya Polis</span> <span>USD
													62.460.222,62</span></li>
										</ul>
										<ul>
											<li><span>Materai</span> <span>USD 7</span></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col">
								<p>Total Premi</p>
								<div class="total-premi">
									<span class="discount">IDR 23.823.000,00</span> <span>IDR
										23.823.000,00</span> <small>IDR 55.093.800</small>
								</div>
							</div>
						</div>
						<div class="col-grid-responsive">
							<p>Proteksi Anda</p>
							<ul>
								<li><span>Dewasa</span> <span>2 Dewasa</span> <span>USD
										62.460.222,62</span></li>
								<li><span>Anak</span> <span>1 Anak</span> <span>USD
										3.089</span></li>
								<li><span>Biaya Polis</span> <span>USD 62.460.222,62</span>
									<span>Materai</span> <span>USD 7</span></li>
							</ul>
							<div class="total-premi">
								<div class="col">
									<p>Total Premi</p>
								</div>
								<div class="col">
									<span class="discount">IDR 23.823.000,00</span> <span>IDR
										155.093.800</span> <small>IDR 55.093.800</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col">
						<!-- <a class="btn btn__agency btn--dark-blue" href="#"> <span
							class="position-relative">Lanjutkan <i
								class="fas fa-arrow-right"></i>
						</span>
						</a> -->

						<a class="btn btn__agency btn--dark-blue" href="<%=step2URL%>">
							<span class="position-relative">Lanjutkan <i
								class="fas fa-arrow-right"></i></span>
						</a>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="banner-bottom">
	<div class="banner-bottom__inner">
		<div class="col align-self-center">
			<div class="col--inner">
				<h1>
					Klaim mudah <br />dengan AXA MyInsurance
				</h1>
				<a class="btn btn__agency btn--white" href="#"> <span
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
<%@ include file="footer.jsp"%>

<!-- Modal Warning -->
<div class="modal modal-axa-smarttravel-theme width-full fade"
	id="modalAlert" tabindex="-1" style="display: none;"
	aria-labelledby="modalAlertLabel" aria-hidden="true">
	<div
		class="modal-max-w-430px modal-axa-smarttravel-theme-dialog modal-dialog modal-axa-smarttravel-theme-dialog-centered">
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

<script>
$(document).ready(function () {
	  document.location.hash = "";
	  // $("#modalAlert").modal('show');
	  options = [];

	  // create an array of select options for a lookup
	  $("#destinasi option").each(function (idx) {
	    options.push({
	      id: $(this).val(),
	      text: $(this).text(),
	    });
	  });

	  $("#destinasi").select2({
	    tags: "true",
	    dropdownParent: ".destinasi-wrapper",
	    placeholder: "Pilih Destinasi",
	    allowClear: true,
	    width: "100%",
	    createTag: function (params) {
	      var term = $.trim(params.term);

	      if (term === "") {
	        return null;
	      }

	      // check whether the term matches an id
	      var search = $.grep(options, function (n, i) {
	        return n.id === term || n.text === term; // check against id and text
	      });

	      // if a match is found replace the term with the options' text
	      if (search.length) term = search[0].text;
	      else return null; // didn't match id or text value so don't add it to selection

	      return {
	        id: term,
	        text: term,
	        value: true,
	        // add additional parameters
	      };
	    },
	  });
	  

	  $("#single-journey").select2({
	    dropdownParent: "#single-journey-wrapper",
	    placeholder: "Perjalanan Tunggal",
	    width: "100%",
	    minimumResultsForSearch: -1,
	  });
	  
	  $("#select-adult").select2({
	    dropdownParent: "#select-adult-wrapper",
	    placeholder: "",
	    width: "100%",
	    minimumResultsForSearch: -1,
	  });
	  $("#select-kid").select2({
	    dropdownParent: "#select-kid-wrapper",
	    placeholder: "",
	    width: "100%",
	    minimumResultsForSearch: -1,
	  });
	  $("#select-plan").select2({
	    dropdownParent: "#select-plan-wrapper",
	    placeholder: "Pilih Plan",
	    width: "100%",
	    minimumResultsForSearch: -1,
	  });
	  $("#select-anchor").select2({
	    dropdownParent: "#select-anchor-wrapper",
	    placeholder: "",
	    width: "100%",
	    minimumResultsForSearch: -1,
	  });

	  $(".btn-buy").click(function () {
	    $(".sticky-plan").addClass("is-active");
	  });

	  $(".trigger-collapse-promo").click(function () {
	    $("#collapseCodepromo").toggleClass("is-show");
	    $(this).toggleClass("is-active");
	    $(".sticky-plan__inner").toggleClass("is-active");
	  });

	  $(".trigger-collapse-plan-detail").click(function () {
	    $("#collapsePlandetail").toggleClass("is-show");
	    $(".sticky-plan__summary").toggleClass("is-hide");
	    $(".sticky-plan__inner").toggleClass("is-active-detail");
	    $(".detail-summary").toggleClass("is-active");
	    $(".code-promo").toggleClass("display-hidden");
	  });

	  $(".trigger-sub-menu").click(function () {
	    $(".sub-menu").toggleClass("is-active");
	  });

	  $(".back-sub-menu").click(function () {
	    $(".sub-menu").removeClass("is-active");
	  });

	  $(".detail-summary").click(function () {
	    $(".sticky-plan-collapse-summary").removeClass("is-show");
	    $(this).removeClass("is-active");
	    $(".sticky-plan__summary").removeClass("is-hide");
	    $(".sticky-plan__inner").removeClass("is-active-detail");
	    $(".detail-summary").removeClass("is-active");
	    $(".code-promo").removeClass("display-hidden");
	  });

	  $(function () {
	    $("#planSelector").change(function () {
	      $(".plans").hide();
	      $("#" + $(this).val()).show();
	    });
	  });
	  
	  var firstDate = moment().format("DD/MMM/YYYY");
	  var endDate = moment().add(1, 'days').format("DD/MMM/YYYY");
	  
	  // Date picker
	  $("#Fromtravel").daterangepicker({
	    parentEl: "#Fromtravel-wrapper",
	    autoUpdateInput: false,
	    singleDatePicker: true,
	    showDropdowns: true,
	    buttonClasses: "btn-date",
	    applyButtonClasses: "btn-apply",
	    cancelClass: "btn-cancel",
	    locale: {
	      applyLabel: "Pilih",
	      cancelLabel: "Batal",
	      daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
	      monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
	    },
	  });
	  //$('#Fromtravel').val(moment().format("DD/MMM/YYYY"));
	  //$('#Fromtravel').data('daterangepicker').setStartDate(moment().format("DD/MMM/YYYY"));
	  
	  
	  $("#Totravel").daterangepicker({
	    parentEl: "#Totravel-wrapper",
	    autoUpdateInput: false,
	    singleDatePicker: true,
	    showDropdowns: true,
	    buttonClasses: "btn-date",
	    applyButtonClasses: "btn-apply",
	    cancelClass: "btn-cancel",
	    locale: {
	      applyLabel: "Pilih",
	      cancelLabel: "Batal",
	      daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
	      monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
	    },
	  });
	  //$('#Totravel').val(moment().add(1, 'days').format("DD/MMM/YYYY"));
	  
	  
	  	// set date initial
	  	//$("#Fromtravel").data("daterangepicker").setStartDate(firstDate);
		//$("#Totravel").data("daterangepicker").setStartDate(endDate);
		
	  // Apply event daterangepicker
	  $("#Fromtravel, #Totravel").on("apply.daterangepicker", function (ev, picker) {
		  const indonesianMonths = {
				  Jan: "Jan",
				  Feb: "Feb",
				  Mar: "Mar",
				  Apr: "Apr",
				  May: "Mei",
				  Jun: "Jun",
				  Jul: "Jul",
				  Aug: "Agu",
				  Sep: "Sep",
				  Oct: "Okt",
				  Nov: "Nov",
				  Dec: "Des",
				};
		  
	    const formattedDate = picker.startDate.format("DD/MMM/YYYY");
	    const englishMonth = picker.startDate.format("MMM");
	    const indonesianMonth = indonesianMonths[englishMonth];
	    
	    //console.log('apply kepanggil, tapi change pada inputnya gak ketrigger');
	    
	    //$(this).val(formattedDate.replace(englishMonth, indonesianMonth)).trigger('change');
	    $(this).val(formattedDate).trigger('change'); // sementara
	  });
	  
// 	  $("#Fromtravel, #Totravel").on('change', function(e) {
// 		 	 console.log('on change jalan');
// 	  });
	  
	  // Cancel event daterangepicker
	  $("#Fromtravel, #Totravel").on("cancel.daterangepicker", function (ev, picker) {
	    $(this).val("").trigger('change');
	  });
	  
	  
	  
	  //$("#Fromtravel").data('daterangepicker').clickApply();
	  //$("#Totravel").data('daterangepicker').clickApply();
	  
	  
	  var _sessionName = "SmartTravelInternational";

	  $("#travel-type").select2({
	    dropdownParent: "#travel-type-wrapper",
	    placeholder: "Perjalanan Tunggal",
	    width: "100%",
	    minimumResultsForSearch: -1,
	  });
	  
	  // jumlah dewasa dan anak
	  function updateSelectOptions(travellerType) {
  var select = $("#select-adult");
  select.empty(); // Clear previous options

  if (travellerType === "Individual") {
    select.append('<option value="1">1 Dewasa</option>');
    
    if(!$('.child-total').hasClass('gohide')) {
    	$('.child-total').addClass('gohide');	
    }
    
  } else if (travellerType === "Duo") {
    select.append('<option value="2">2 Dewasa</option>');
    
    if(!$('.child-total').hasClass('gohide')) {
    	$('.child-total').addClass('gohide');	
    }
    
  } else if(travellerType === "Family") {
    select.append('<option value="1">1 Dewasa</option>');
    select.append('<option value="2">2 Dewasa</option>');
    $('.child-total').removeClass('gohide');
  }
}

	  // traveller type
	  $('[name="TravellerType"]').on('change', function() {
	      var selectedTravellerType = $(this).val();
	      updateSelectOptions(selectedTravellerType);
	    });

	  // set session storage
	  $(document).on("change", ".form-item", function (e) {
	    let existingSession = sessionStorage.getItem(_sessionName);

	    let _dataForSession = {};

	    let inputType = $(this).attr("type");
	    let inputName = $(this).attr("name");

	    const sessKey = $(this).attr("name");

	    if (inputType === "radio") {
	      if (inputName === "Currency") {
	        let currentVal = $(this).attr("id") || "idr";
	        _dataForSession[sessKey] = currentVal;
	      }

	      if (inputName === "TravellerType") {
	        let currentVal = $(this).val() || "";
	        _dataForSession[sessKey] = currentVal;
	      }
	    } else {
	      let currentVal = $(this).val() || "";
	      _dataForSession[sessKey] = currentVal;
	    }

	    // jika ada session sebelumnya, maka merge dengan yang baru
	    if (existingSession) {
	      let mergedSession = { ...JSON.parse(existingSession), ..._dataForSession };
	      sessionStorage.setItem(_sessionName, JSON.stringify(mergedSession));
	    } else {
	      sessionStorage.setItem(_sessionName, JSON.stringify(_dataForSession));
	    }
	  });

	  // Submit form simulation
	  $("#form-simulation").on("submit", function (e) {
	    e.preventDefault();

	    let existingSession = sessionStorage.getItem(_sessionName);

	    if (existingSession) {
	      existingSession = JSON.parse(existingSession);

	      $.ajax({
	        url: "http://localhost:8080/o/api/sti/calculate",
	        type: "POST",
	        contentType: "application/json",
	        data: JSON.stringify(existingSession),
	        success: function (response) {
	        	if(response.Status) {
	        		response.Data.forEach(plan => {
	        			if(plan.PlanName === "Platinum") {
	        				let formattedAmount = plan.TotalMainBenefitBasicPremium.toLocaleString('id-ID', {
	        				    style: 'currency',
	        				    currency: 'IDR'
	        				});
	        				
	        				$('#PriceWrapper-Platinum').text(formattedAmount);
	        			}
	        			
	        			if(plan.PlanName === "Gold") {
	        				let formattedAmount = plan.TotalMainBenefitBasicPremium.toLocaleString('id-ID', {
	        				    style: 'currency',
	        				    currency: 'IDR'
	        				});
	        				
	        				$('#PriceWrapper-Gold').text(formattedAmount);
	        			}
	        		});
	        		
	        		$('.choosen-plan-wrapper').removeClass('gohide');
	        	}
	        },
	        error: function (xhr, status, error) {
	          console.error("Error:", error);
	        },
	      });
	    }
	  });

	  // init form simulation
	  $("#idr").prop("checked", true).trigger("change");
	  $("#travel-type").val("Single").trigger("change");
	  $("#individual").prop("checked", true).trigger("change");
	  $("#destinasi").trigger("change");
	}); // end document ready
	

	document.addEventListener("DOMContentLoaded", function () {
	  /* delete bg-white default liferay */

	  var contentSection = document.getElementById("content");
	  if (contentSection) {
	    contentSection.classList.remove("bg-white");
	  }

	  /* button clear kode promo */
	  const clearButtons = document.querySelectorAll(".btnClear");

	  clearButtons.forEach((button) => {
	    button.addEventListener("click", function () {
	      const inputGroup = button.closest(".input-group-axa");
	      const input = inputGroup.querySelector(".input-control-axa");

	      input.value = "";
	    });
	  });
	});
</script>

<script>

</script>
