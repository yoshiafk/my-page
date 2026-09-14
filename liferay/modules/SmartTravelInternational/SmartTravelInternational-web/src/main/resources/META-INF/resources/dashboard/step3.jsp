<%-- <%@ include file="../init.jsp"%>

<%
	String portalURL = PortalUtil.getPortalURL(request);
	String restApiUrl = portalURL + "/o/api/sti/kyc"; //  /o access from osgi, /api/sti/kyc is path api
%>

Membuat URL untuk riplay.jsp
<portlet:renderURL var="riplayURL">
	<portlet:param name="jspPage" value="/dashboard/riplay.jsp" />
</portlet:renderURL>

<portlet:resourceURL id="/data/step3/ocr" var="loadDataStep3OCR" />

<header class="hero">
	<img src="/o/mypage-theme/images/step2hero.png" alt="herostep2"
		class="width-full height-full">
</header>


<section class="chosee-plan">

	<!-- navbar -->
	<%@ include file="navbar.jsp"%>


	<!-- step bar -->
	<div class="stepper-wrapper">
		<div class="stepper-item completed">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Pilih Perlindungan</div>
		</div>
		<div class="stepper-item active">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Data Pemegang Polis</div>
		</div>
		<div class="stepper-item">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Persetujuan</div>
		</div>
		<div class="stepper-item">
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
							<section class="smart-mediacare-inter__table step3" id="Sec-1">

								<!-- data polis holder -->
								<div class="panel-cover pt-10level px-10level container-form">

									<h1>Data Pemegang Polis</h1>

									<div class="ispep">
										<span class="agency__underline"> Apakah pemegang polis
											termasuk ke dalam kategori Orang yang <span
											class="agency__text-axa-sienna-400"> Populer secara
												politisi / <span class="agency__italic">Politically
													Exposed Persons </span> (PEP)
										</span> ?
										</span> <a class="btn--white__step3  ml-2level" href="#"> <span>
												Baca Selengkapnya <i class="fas fa-arrow-right"></i>
										</span>
										</a>

										<div class="radio-group">

											<div>
												<div
													class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
													<input id="no" class="radio-custom"
														name="input_ispep_polisholder" type="radio" value="0" checked="checked">
													<label for="no" class="radio-custom-label mb-0"><span>Tidak</span></label>
												</div>
											</div>
											<div>
												<div
													class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
													<input id="yes" class="radio-custom"
														name="input_ispep_polisholder" type="radio" value="1">
													<label for="yes" class="radio-custom-label mb-0"><span>Ya
															<span class="ispepYes">(Data Anda akan kami tinjau
																untuk melewati persetujuan dari Underwriting)</span>
													</span></label>
												</div>
											</div>

										</div>

									</div>


									<div
										class="form-column display-flex agency__flex-wrap gap-4level">
										<form class="display-flex agency__flex-wrap gap-4level">

											<!-- Kolom Kiri -->
											<div class="agency__flex-1 agency__min-w-300px">

												<!-- foto ktp -->
												<div class="upload-container">
													<label for="name"> Upload Foto KTP / KITAS <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="thumbnail-wrapper">
														<img class="thumbnail img-thumbnail img-fluid "
															src="/o/mypage-theme/images/ktp-image.png" alt="foto ktp">

														<div class="ml-5level mt-2level">
															<span class="file-name agency__text-xs"></span>
															<button type="button"
																class="uploadButton agency__rounded-4px">Pilih
																File</button>

														</div>
														<input type="file"
															class="fileInput input_fotoktp_polisholder display-hidden "
															accept="image/*" name="input_fotoktp_polisholder"
															required="required">
													</div>
												</div>


												<!-- name -->
												<div>
													<label for="name"> Nama lengkap sesuai KTP / KITAS
														<span class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputName" placeholder="Tulis Nama"
															name="input_name_polisholder" type="text"
															required="required">
													</div>
												</div>

												<!-- ktppasspor -->
												<div>
													<label for="ktppasspor"> Nomor Paspor <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Nomor Paspor"
															name="input_ktppaspor_polisholder" type="text"
															maxlength="16" required="required"
															oninput="handleInput(event)">
													</div>
												</div>

												<!-- dob -->
												<div>
													<label class="display-block" for="dateofbirth">Tanggal
														Lahir <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="calendar-wrapper position-relative"
														id="calendar-wrapper-claim">
														<div class="calendar-col position-relative dob-wrapper">
															<input
																class="input-control-axa input-control-axa--outline input-icon-date dob"
																type="text" name="input_dob_polisholder"
																autocomplete="off" placeholder="Pilih Tanggal Lahir"
																readonly="readonly" required="required">
														</div>
													</div>
												</div>

												<!-- place -->
												<div class="place">
													<label for="place"> Tempat Lahir <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputPlaceOfBirth"
															placeholder="Tulis Tempat Lahir"
															name="input_pdob_polisholder" type="text"
															required="required">
													</div>
												</div>

												<!-- gender -->
												<div>
													<label for="gender">Jenis Kelamin <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>

													<div class="form-radio-wrapper display-flex">
														<div class="display-flex gender-container">
															<div class="form-radio mr-8px">
																<input class="classInputGenderMale" type="radio" name="input_gender_polisholder"
																	value="M" required="required">
																<div class="box-radio-wrapper agency__text-center">
																	<div class="box-radio">
																		<img src="/o/mypage-theme/images/man-nb.png"
																			alt="laki">
																	</div>
																	<div class="box-text">Laki-Laki</div>
																</div>
															</div>
															<div class="form-radio">
																<div class="form-radio-input">
																	<input type="radio" name="input_gender_polisholder"
																		value="F" class="form-control classInputGenderFemale" required="required">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/woman-nb.png"
																				alt="perempuan">
																		</div>
																		<div class="box-text">Perempuan</div>
																	</div>
																</div>
															</div>
														</div>

													</div>
												</div>

												<!-- Kode negara dan telepon -->
												<div>
													<label for="kode">Kode Negara dan Telepon </label>
													<div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa kode"
															name="input_kodenegara_polisholder">

															<!-- Options will be dynamically added by JavaScript -->

														</select>
													</div>
												</div>

												<!-- hp -->
												<div>
													<label for="hp"> Nomor Handphone <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Nomor Handphone"
															name="input_hp_polisholder" type="text" maxlength="15"
															required="required" oninput="handleInput(event)">
													</div>
												</div>

												<!-- provinsi -->
												<!-- <div>
													<label for="provinsi">Provinsi <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa provinsi" name="provinsi"
															required>
															<option></option>
															<option value="Lorem Ipsum">provinsi lorem1</option>
															<option value="Lorem Ipsum 2">provinsi lorem2</option>
														</select>
													</div>
												</div> -->

												<!-- job -->
												<div>
													<label for="job">Pekerjaan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative job-container">
														<select class="input-control-axa job"
															name="input_job_polisholder" required>
															<option></option>
															<option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option>
															<option value="Karyawan Swasta">Karyawan Swasta</option>
															<option value="TNI/POLRI">TNI/POLRI</option>
															<option value="PNS">PNS</option>
															<option value="Ibu Rumah Tangga">Ibu Rumah
																Tangga</option>
															<option value="Wiraswasta">Wiraswasta</option>
															<option value="Lainnya">Lainnya</option>

														</select>
													</div>
												</div>

											</div>

											<!-- Kolom Kanan -->
											<div class="agency__flex-1 agency__min-w-300px">
											
												<!-- Negara -->
												<div class="passpordiv">
													<label for="negara">Kewarganegaraan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative negara-container">
														<select class="input-control-axa negara"
															name="input_negara_polisholder" required>

															<!-- Options will be dynamically added by JavaScript -->
														</select>
													</div>
												</div>
											
												<!-- passpor -->
												<div>
													<label for="ktppaspor"> Nomor KTP / KITAS <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputKtpKitas"
															placeholder="Tulis No. KTP / KITAS"
															name="input_ktpkitas_polisholder" type="text"
															maxlength="16" required="required"
															oninput="handleInput(event)">
													</div>
												</div>

												<!-- age -->
												<div>
													<label for="age"> Usia </label>
													<div
														class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome">
														<input disabled="disabled" class="input-control-axa age"
															placeholder="0" name="input_age_polisholder" type="text">
														<span class="font_tahun">Tahun</span>
													</div>
												</div>


												<!-- status kawin -->
												<div class="mt-150px">
													<label for="status-kawin">Status Perkawinan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative status-kawin-container">
														<select class="input-control-axa status-kawin"
															name="input_status-kawin_polisholder" required>
															<option></option>
															<option value="Belum Menikah">Belum Menikah</option>
															<option value="Sudah Menikah">Sudah Menikah</option>
														</select>
													</div>
												</div>

												<!-- telepon -->
												<div class="telepondiv">
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Nomor Telepon"
															name="input_telepon_polisholder" type="text">
													</div>
												</div>

												<!-- email -->
												<div>
													<label for="email">Email <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa" placeholder="Tulis email"
															name="input_email_polisholder" type="text"
															required="required">
													</div>
												</div>

												<!-- kode pos -->
												<div>
													<label for="kodepos">Kode Pos <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Kode Pos"
															name="input_kodepos_polisholder" type="text"
															required="required">
													</div>
												</div>

												<!-- kab -->
												<!-- <div>
													<label for="kabupaten">Kabupaten/Kota <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa kabupaten"
															name="kabupaten" required>
															<option></option>
															<option value="Lorem Ipsum">kabupaten lorem1</option>
															<option value="Lorem Ipsum 2">kabupaten lorem2</option>
														</select>
													</div>
												</div> -->


											</div>

											<!-- alamat -->
											<div class="alamatdiv">
												<label for="alamat">Alamat Lengkap <span
													class="agency__text-axa-sienna-400 agency__text-xs">*</span>
												</label>
												<div class="input-group-axa input-group-axa--border">
													<textarea class="input-control-axa classInputAddress"
														placeholder="Tulis Alamat Lengkap"
														name="input_alamat_polisholder" required="required"></textarea>
												</div>
											</div>
										</form>
									</div>
								</div>
								
								<!-- //HERE INSURED FORM LOOP-->
								<div id="container-generate-insured"></div>

								<!-- data tertanggung utama -->
								<!-- <div
									class="panel-cover pt-10level mt-10level px-10level container-form">
									<div class="flex-justify-between align-items-center">
										<h1 class="agency__text-xl agency__font-bold">Data
											Tertanggung Utama</h1>
										<button id="btn__accordion-toggle"
											class="flex-justify-center align-items-center agency__w-10__h-10 agency__bg-axa-blue-400 agency__text-white">
											<i id="accordion-icon"
												class="fas fa-chevron-down agency__text-xs"></i>
										</button>
									</div>
									<div class="pb-2level">

										<div class="display-flex align-items-center">
											<input type="checkbox" id="custom-checkbox"
												class="display-hidden" /> <label for="custom-checkbox-x"
												class="display-flex align-items-center">
												<div
													class="checkbox-container w-4level h-4level agency__border-border-gray-300 agency__rounded-sm display-flex align-items-center agency__justify-center mr-2level position-relative">

													<input type="checkbox"
														class="display-hidden checkbox-input"
														name="insuredIsPolis">

													<svg
														class="checkboxSamePolis display-hidden agency__bg-axa-blue-400 w-4level h-4level agency__text-white position-absolute"
														xmlns="http://www.w3.org/2000/svg" fill="none"
														viewBox="0 0 24 24" stroke="currentColor">
                                                            <path
															stroke-linecap="round" stroke-linejoin="round"
															stroke-width="2" d="M5 13l4 4L19 7" />
                                                        </svg>
												</div> <span class="checkBoxSpanDataSamePolis">Data
													Tertanggung Utama sama dengan data pemegang polis</span>
											</label>
										</div>

									</div>

									child collapse terteanggung utama
									<div id="collapseOne" class="accordion-collapse show">

										<div class="insured-form">

											<div class="ispep">
												<span class="agency__underline"> Apakah pemegang
													polis termasuk ke dalam kategori Orang yang <span
													class="agency__text-axa-sienna-400"> Populer secara
														politisi / <span class="agency__italic">Politically
															Exposed Persons </span> (PEP)
												</span> ?
												</span> <a class="btn--white__step3  ml-2level" href="#"> <span>
														Baca Selengkapnya <i class="fas fa-arrow-right"></i>
												</span>
												</a>

												<div class="radio-group">

													<div>
														<div
															class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
															<input id="no2" class="radio-custom"
																name="input_ispep_insured_0" type="radio" value="0" checked="checked">
															<label for="no2" class="radio-custom-label mb-0"><span>Tidak</span></label>
														</div>
													</div>
													<div>
														<div
															class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
															<input id="yes2" class="radio-custom"
																name="input_ispep_insured_0" type="radio" value="1">
															<label for="yes2" class="radio-custom-label mb-0"><span>Ya
																	<span class="ispepYes">(Data Anda akan kami
																		tinjau untuk melewati persetujuan dari Underwriting)</span>
															</span></label>
														</div>
													</div>

												</div>

											</div>


											<div
												class="form-column display-flex agency__flex-wrap gap-4level">
												<form class="display-flex agency__flex-wrap gap-4level">

													Kolom Kiri
													<div class="agency__flex-1 agency__min-w-300px">

														foto ktp
														<div class="upload-container">
															<label for="name"> Upload Foto KTP / KITAS <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="thumbnail-wrapper">
																<img class="thumbnail img-thumbnail img-fluid "
																	src="/o/mypage-theme/images/ktp-image.png"
																	alt="foto ktp">

																<div class="ml-5level mt-2level">
																	<span class="file-name agency__text-xs"></span>
																	<button type="button"
																		class="uploadButton agency__rounded-4px">Pilih
																		File</button>

																</div>
																<input type="file"
																	class="fileInput input_fotoktp_insured_0 display-hidden"
																	accept="image/*" name="input_fotoktp_insured_0"
																	required="required">
															</div>
														</div>


														name
														<div>
															<label for="name"> Nama lengkap sesuai KTP /
																KITAS <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa classInputName"
																	placeholder="Tulis Nama" name="input_name_insured_0"
																	type="text" required="required">
															</div>
														</div>

														ktppasspor
														<div>
															<label for="ktppasspor"> Nomor Paspor <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis Nomor Paspor"
																	name="input_ktppaspor_insured_0" type="text"
																	maxlength="16" required="required"
																	oninput="handleInput(event)">
															</div>
														</div>

														dob
														<div>
															<label class="display-block" for="dateofbirth">Tanggal
																Lahir <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="calendar-wrapper position-relative"
																id="calendar-wrapper-claim">
																<div class="calendar-col position-relative dob-wrapper">
																	<input
																		class="input-control-axa input-control-axa--outline input-icon-date dob"
																		type="text" name="input_dob_insured_0"
																		autocomplete="off" placeholder="Pilih Tanggal Lahir"
																		readonly="readonly" required="required">
																</div>
															</div>
														</div>

														place
														<div class="place">
															<label for="place"> Tempat Lahir <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa classInputPlaceOfBirth"
																	placeholder="Tulis Tempat Lahir"
																	name="input_pdob_insured_0" type="text"
																	required="required">
															</div>
														</div>

														gender
														<div>
															<label for="gender">Jenis Kelamin <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>

															<div class="form-radio-wrapper display-flex">
																<div class="display-flex gender-container">
																	<div class="form-radio mr-8px">
																		<input class="classInputGenderMale" type="radio" name="input_gender_insured_0"
																			value="M" required="required">
																		<div class="box-radio-wrapper agency__text-center">
																			<div class="box-radio">
																				<img src="/o/mypage-theme/images/man-nb.png"
																					alt="laki">
																			</div>
																			<div class="box-text">Laki-Laki</div>
																		</div>
																	</div>
																	<div class="form-radio">
																		<div class="form-radio-input">
																			<input type="radio" name="input_gender_insured_0"
																				value="F" class="form-control classInputGenderFemale" required="required">
																			<div class="box-radio-wrapper agency__text-center">
																				<div class="box-radio">
																					<img src="/o/mypage-theme/images/woman-nb.png"
																						alt="perempuan">
																				</div>
																				<div class="box-text">Perempuan</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														Kode negara dan telepon
														<div>
															<label for="kode">Kode Negara dan Telepon </label>
															<div id="single-journey-wrapper"
																class="position-relative">
																<select class="input-control-axa kode"
																	name="input_kodenegara_insured_0">

																	Options will be dynamically added by JavaScript
																</select>
															</div>
														</div>

														hp
														<div>
															<label for="hp"> Nomor Handphone <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis Nomor Handphone"
																	name="input_hp_insured_0" type="text" maxlength="15"
																	required="required" oninput="handleInput(event)">
															</div>
														</div>

														provinsi
														<div>
														<label for="provinsi">Provinsi <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa provinsi"
																name="provinsi" required>
																<option></option>
																<option value="Lorem Ipsum">provinsi lorem1</option>
																<option value="Lorem Ipsum 2">provinsi lorem2</option>
															</select>
														</div>
													</div>

														job
														<div>
															<label for="job">Pekerjaan <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div id="single-journey-wrapper"
																class="position-relative job-container">
																<select class="input-control-axa job"
																	name="input_job_insured_0" required>
																	<option></option>
																	<option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option>
																	<option value="Karyawan Swasta">Karyawan
																		Swasta</option>
																	<option value="TNI/POLRI">TNI/POLRI</option>
																	<option value="PNS">PNS</option>
																	<option value="Ibu Rumah Tangga">Ibu Rumah
																		Tangga</option>
																	<option value="Wiraswasta">Wiraswasta</option>
																	<option value="Lainnya">Lainnya</option>
																</select>
															</div>
														</div>

													</div>

													Kolom Kanan
													<div class="agency__flex-1 agency__min-w-300px">
													
														Negara
														<div class="passpordiv">
															<label for="negara">Kewarganegaraan <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div id="single-journey-wrapper"
																class="position-relative negara-container">
																<select class="input-control-axa negara"
																	name="input_negara_insured_0" required>

																	Options will be dynamically added by JavaScript
																</select>
															</div>
														</div>
													
														passpor
														<div>
															<label for="ktppaspor"> Nomor KTP / KITAS <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa classInputKtpKitas"
																	placeholder="Tulis No. KTP / KITAS"
																	name="input_ktpkitas_insured_0" type="text"
																	maxlength="16" required="required"
																	oninput="handleInput(event)">
															</div>
														</div>

														age
														<div>
															<label for="age"> Usia </label>
															<div
																class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome">
																<input disabled="disabled" class="input-control-axa age"
																	placeholder="0" name="input_age_insured_0" type="text">
																<span class="font_tahun">Tahun</span>
															</div>
														</div>

														hubungan
														<div>
															<label for="relationship">Hubungan <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div id="single-journey-wrapper"
																class="position-relative relationship-container">
																<select class="input-control-axa relationship"
																	name="input_relationship_insured_0" required>
																	<option></option>
																	<option value="Tertangggung Utama" selected="selected">Tertangggung
																		Utama</option>
																	<option value="Kerabat">Kerabat</option>
																	<option value="Teman">Teman</option>
																</select>
															</div>
														</div>


														status kawin
														<div>
															<label for="status-kawin">Status Perkawinan <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div id="single-journey-wrapper"
																class="position-relative status-kawin-container">
																<select class="input-control-axa status-kawin"
																	name="input_status-kawin_insured_0" required>
																	<option></option>
																	<option value="Belum Menikah">Belum Menikah</option>
																	<option value="Sudah Menikah">Sudah Menikah</option>
																</select>
															</div>
														</div>

														telepon
														<div class="telepondiv">
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis Nomor Telepon"
																	name="input_telepon_insured_0" type="text">
															</div>
														</div>

														email
														<div>
															<label for="email">Email <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis email" name="input_email_insured_0"
																	type="text" required="required">
															</div>
														</div>

														kode pos
														<div>
															<label for="kodepos">Kode Pos <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis Kode Pos"
																	name="input_kodepos_insured_0" type="text"
																	required="required">
															</div>
														</div>

														kab
														<div>
														<label for="kabupaten">Kabupaten/Kota <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa kabupaten"
																name="kabupaten" required>
																<option></option>
																<option value="Lorem Ipsum">kabupaten lorem1</option>
																<option value="Lorem Ipsum 2">kabupaten lorem2</option>
															</select>
														</div>
													</div>


													</div>

													alamat
													<div class="alamatdiv">
														<label for="alamat">Alamat Lengkap <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<textarea class="input-control-axa classInputAddress"
																placeholder="Tulis Alamat Lengkap"
																name="input_alamat_insured_0" required="required"></textarea>
														</div>
													</div>
												</form>
											</div>
										</div>

									</div>

								</div> -->

								<!-- TEST DUPLICATE -->

								<!-- <div class="panel-cover pt-10level mt-10level px-10level">

									<h1>Data Tertanggung 2</h1>

									<div class="insured-form">

										<div class="ispep">
											<span class="agency__underline"> Apakah pemegang polis
												termasuk ke dalam kategori Orang yang <span
												class="agency__text-axa-sienna-400"> Populer secara
													politisi / <span class="agency__italic">Politically
														Exposed Persons </span> (PEP)
											</span> ?
											</span> <a class="btn--white__step3  ml-2level" href="#"> <span>
													Baca Selengkapnya <i class="fas fa-arrow-right"></i>
											</span>
											</a>

											<div class="radio-group">

												<div>
													<div
														class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
														<input id="no3" class="radio-custom"
															name="input_ispep_insured_1" type="radio" value="0"> <label
															for="no3" class="radio-custom-label mb-0"><span>Tidak</span></label>
													</div>
												</div>
												<div>
													<div
														class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
														<input id="yes3" class="radio-custom"
															name="input_ispep_insured_1" type="radio" value="1"> <label
															for="yes3" class="radio-custom-label mb-0"><span>Ya
																<span class="ispepYes">(Data Anda akan kami
																	tinjau untuk melewati persetujuan dari Underwriting)</span>
														</span></label>
													</div>
												</div>
											</div>
										</div>


										<div
											class="form-column display-flex agency__flex-wrap gap-4level">
											<form class="display-flex agency__flex-wrap gap-4level">

												Kolom Kiri
												<div class="agency__flex-1 agency__min-w-300px">

													foto ktp
													<div class="upload-container">
														<label for="name"> Upload Foto KTP / Paspor <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="thumbnail-wrapper">
															<img
																class="thumbnail img-thumbnail img-fluid "
																src="/o/mypage-theme/images/ktp-image.png"
																alt="foto ktp">

															<div class="ml-5level mt-2level">
																<span class="file-name agency__text-xs"></span>
																<button type="button" class="uploadButton">Pilih
																	File</button>

															</div>
															<input type="file"
																class="fileInput input_fotoktp_insured_1 display-hidden"
																accept="image/*" name="input_fotoktp_insured_1">
														</div>
													</div>


													name
													<div>
														<label for="name"> Nama lengkap sesuai KTP /
															Paspor <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa" placeholder="Tulis Nama"
																name="input_name_insured_1" type="text">
														</div>
													</div>

													ktppasspor
													<div>
														<label for="ktppasspor"> Nomor KTP / Paspor <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Nomor Paspor"
																name="input_ktppaspor_insured_1" type="text">
														</div>
													</div>

													dob
													<div>
														<label class="display-block" for="dateofbirth">Tanggal
															Lahir <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="calendar-wrapper position-relative"
															id="calendar-wrapper-claim">
															<div class="calendar-col position-relative dob-wrapper">
																<input
																	class="input-control-axa input-control-axa--outline input-icon-date dob"
																	type="text" name="input_dob_insured_1"
																	autocomplete="off" placeholder="Pilih Tanggal Lahir"
																	readonly="readonly">
															</div>
														</div>
													</div>

													place
													<div class="place">
														<label for="place"> Tempat Lahir <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Tempat Lahir"
																name="input_pdob_insured_1" type="text">
														</div>
													</div>

													gender
													<div>
														<label for="gender">Jenis Kelamin <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>

														<div
															class="form-radio-wrapper display-flex agency__space-x-4">
															<div class="form-radio">
																<input type="radio" name="input_gender_insured_1"
																	value="M">
																<div class="box-radio-wrapper agency__text-center">
																	<div class="box-radio">
																		<img src="/o/mypage-theme/images/man-nb.png"
																			alt="laki">
																	</div>
																	<div class="box-text">Laki-Laki</div>
																</div>
															</div>
															<div class="form-radio">
																<div class="form-radio-input">
																	<input type="radio" name="input_gender_insured_1"
																		value="F" class="form-control">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/woman-nb.png"
																				alt="perempuan">
																		</div>
																		<div class="box-text">Perempuan</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													Kode negara dan telepon
													<div>
														<label for="kode">Kode Negara dan Telepon </label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa kode"
																name="input_kodenegara_insured_1" required>
																
																Options will be dynamically added by JavaScript
																
															</select>
														</div>
													</div>

													hp
													<div>
														<label for="hp"> Nomor Handphone <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Nomor Handphone"
																name="input_hp_insured_1" type="number">
														</div>
													</div>

													Negara
													<div>
														<label for="negara">Kewarganegaraan <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa negara"
																name="input_negara_insured_1" required>
																
																Options will be dynamically added by JavaScript
															</select>
														</div>
													</div>

													job
													<div>
														<label for="job">Pekerjaan <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa job"
																name="input_job_insured_1" required>
																<option></option>
																<option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option>
																<option value="Karyawan Swasta">Karyawan Swasta</option>
																<option value="TNI/POLRI">TNI/POLRI</option>
																<option value="PNS">PNS</option>
																<option value="Ibu Rumah Tangga">Ibu Rumah
																	Tangga</option>
																<option value="Wiraswasta">Wiraswasta</option>
																<option value="Lainnya">Lainnya</option>
															</select>
														</div>
													</div>

												</div>

												Kolom Kanan
												<div class="agency__flex-1 agency__min-w-300px">
													passpor
													<div class="passpordiv">
														<label for="ktppaspor"> Nomor KTP / KITAS <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis No. KTP / KITAS"
																name="input_ktpkitas_insured_1" type="text">
														</div>
													</div>

													age
													<div class="mt-150px">
														<label for="age"> Usia </label>
														<div
															class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome">
															<input disabled="disabled" class="input-control-axa age"
																placeholder="0" name="input_age_insured_1" type="text">
															<span class="font_tahun">Tahun</span>
														</div>
													</div>

													hubungan
													<div>
														<label for="relationship">Hubungan <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa relationship"
																name="input_relationship_insured_1" required>
																<option></option>
																<option value="Tertangggung Utama">Tertangggung Utama</option>
																<option value="Kerabat">Kerabat</option>
															</select>
														</div>
													</div>


													status kawin
													<div>
														<label for="status-kawin">Status Perkawinan <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa status-kawin"
																name="input_status-kawin_insured_1" required>
																<option></option>
																<option value="Belum Menikah">Belum Menikah</option>
																<option value="Sudah Menikah">Sudah Menikah</option>
															</select>
														</div>
													</div>

													telepon
													<div class="telepondiv">
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Nomor Telepon"
																name="input_telepon_insured_1" type="text">
														</div>
													</div>

													email
													<div>
														<label for="email">Email <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis email" name="input_email_insured_1"
																type="text">
														</div>
													</div>

													kode pos
													<div>
														<label for="kodepos">Kode Pos <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Kode Pos"
																name="input_kodepos_insured_1" type="text">
														</div>
													</div>

												</div>

												alamat
												<div class="alamatdiv">
													<label for="alamat">Alamat Lengkap <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<textarea class="input-control-axa"
															placeholder="Tulis Alamat Lengkap"
															name="input_alamat_insured_1"></textarea>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div> -->


							</section>
						</div>

						<div class="col-tabstep2">
							<!-- <div class="panel-cover py-5level">
								<h3>Perjalanan International</h3>
								<h1>Plan Spesial Asia</h1>
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
							</div> -->

							<div class="panel-cover py-5level">
								<h3>Perjalanan Domestik</h3>
								<h1>Plan Gold</h1>
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
												<input class="input-control-axa promo-code" id="promo-code"
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

								<div class="mt-5level agency__text-center divbutton-submit">
									<a class="btn__submit btn__agency btn--dark-blue width-full" >
										<span
										class="position-relative agency__uppercase agency__pointer">Lanjut
											ke Persetujuan <i class="fas fa-arrow-right"></i>
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
<script>

var kycURL = "<%=restApiUrl%>";
var link = "<%=riplayURL%>";

var loadDataStep3OCR_URL = "<%=loadDataStep3OCR%>";

let base64Result = null;

const indonesianMonths = {
    'January': 'Jan',
    'February': 'Feb',
    'March': 'Mar',
    'April': 'Apr',
    'May': 'Mei',
    'June': 'Jun',
    'July': 'Jul',
    'August': 'Agu',
    'September': 'Sep',
    'October': 'Okt',
    'November': 'Nov',
    'December': 'Des'
};


//OCR
async function handleFileChange(fileInput) {

    console.log('testt handleFileChange');
    const file_foto = await collectDataFoto(fileInput);

    // Create the payload
    const payload = {
        dataCategory: "ocr",
        _fotoBase64: file_foto._fotoktp, // Base64 string
        _fileName: file_foto._fileName // File name
    };

    console.log('Payload ready to send:', payload);

    $.ajax({
        type: "POST",
        url: loadDataStep3OCR_URL,
        data: payload,
        timeout: 120000,
        dataType: "json",
        success: function(response) {
            console.log('Success get response:', response.response);

            // Check if the response does not contain the error
            if (response.response.status === "SUCCESS") {
                updateNearestFields(fileInput, response);
            } else if (response.response.status === "FILE_INVALID_FORMAT"){
                fileInput.value = ''; // Kosongkan input file
                alert(response.response.reason);
            }else {
            	console.error('Error >> ', response.response.error);
            }

        },
        error: function(error) {
            console.log('Error:', error);
        }
    });

}

async function collectDataFoto(fileInput) {
    console.log('collectDataFoto');

    const data = {
        _fotoktp: '',
        _fileName: ''
    };

    if (fileInput && fileInput.files.length > 0) {
        data._fotoktp = await getBase64(fileInput.files[0]);
        data._fileName = fileInput.files[0].name;
    }

    return data;
}

 
//Fungsi untuk memperbarui field input terdekat dengan hasil response
 function updateNearestFields(fileInput, response) {
     console.log('updateNearestFields.......>>', response.response);

     var dataRead = response.response.read; // response.response.read.(nama, alamat, etc)

     // Temukan container-form terdekat
     const container = fileInput.closest('.container-form');

     // Update nilai field terdekat
     if (container) {
         const nameInput = container.querySelector('.classInputName');
         const addressInput = container.querySelector('.classInputAddress');
         const placeBirth = container.querySelector('.classInputPlaceOfBirth');
         const ktpKitas = container.querySelector('.classInputKtpKitas');

         // Update name
         if (dataRead.nama && dataRead.nama.confidence > 70 && nameInput) {
             nameInput.value = dataRead.nama.value;
         }

         // Update address
         if (dataRead.alamat && dataRead.alamat.confidence > 70 && addressInput) {
             let alamat = dataRead.alamat ? dataRead.alamat.value : '';
             let rtRw = (dataRead.rtRw && dataRead.rtRw.confidence > 70 ? 'RT ' + dataRead.rtRw.value.split('/')[0] + ' RW ' + dataRead.rtRw.value.split('/')[1] : '');
             let kelDesa = (dataRead.kelurahanDesa && dataRead.kelurahanDesa.confidence > 70 ? 'Kelurahan ' + dataRead.kelurahanDesa.value : '');
             let kec = (dataRead.kecamatan && dataRead.kecamatan.confidence > 70 ? 'Kecamatan ' + dataRead.kecamatan.value : '');
             let kotaKab = (dataRead.kotaKabupaten && dataRead.kotaKabupaten.confidence > 70 ? dataRead.kotaKabupaten.value : '');
             let prov = (dataRead.provinsi && dataRead.provinsi.confidence > 70 ? dataRead.provinsi.value : '');

             let fullAddress = alamat + ', ' + rtRw + ', ' + kelDesa + ', ' + kec + ', ' + kotaKab + ', ' + prov;
             addressInput.value = fullAddress.replace(/ ,/g, ''); // Remove any extra commas if any part is missing
         }

         // Update birth place
         if (dataRead.tempatLahir && dataRead.tempatLahir.confidence > 70 && placeBirth) {
             placeBirth.value = dataRead.tempatLahir.value;
         }

         // Update KTP/KITAS number
         if (dataRead.nik && dataRead.nik.confidence > 70 && ktpKitas) {
             ktpKitas.value = dataRead.nik.value;
         }

         // Update kewarganegaraan (negara)
         let kewarganegaraan = dataRead.kewarganegaraan && dataRead.kewarganegaraan.confidence > 70 ? dataRead.kewarganegaraan.value : '';
         const select2Kewarganegaraan = container.querySelector('.negara');
         if (select2Kewarganegaraan) {
             if (kewarganegaraan === "WNI") {
                 $(select2Kewarganegaraan).val('Indonesia').trigger('change');
             }
         }

         // Update status perkawinan
         let statusKawin = dataRead.statusPerkawinan && dataRead.statusPerkawinan.confidence > 70 ? dataRead.statusPerkawinan.value : '';
         const select2statusKawin = container.querySelector('.status-kawin');
         if (select2statusKawin) {
             if (statusKawin === "BELUM KAWIN") {
                 $(select2statusKawin).val('Belum Menikah').trigger('change');
             } else {
                 $(select2statusKawin).val('Sudah Menikah').trigger('change');
             }
         }

         // Update pekerjaan (job)
         let job = dataRead.pekerjaan && dataRead.pekerjaan.confidence > 70 ? dataRead.pekerjaan.value : '';
         const select2Job = container.querySelector('.job');
         if (select2Job) {
             $(select2Job).val(job).trigger('change');
         }

         // Update gender
         const maleRadio = container.querySelector('.classInputGenderMale');
         const femaleRadio = container.querySelector('.classInputGenderFemale');

         if (dataRead.jenisKelamin && dataRead.jenisKelamin.confidence > 70) {
             if (dataRead.jenisKelamin.value === "LAKI-LAKI") {
                 maleRadio.checked = true;
             } else {
                 femaleRadio.checked = true;
             }
         }

         // Update tanggal lahir
         var dateofbirth = dataRead.tanggalLahir && dataRead.tanggalLahir.confidence > 70 ? dataRead.tanggalLahir.value : '';
         var formattedDOB = dateofbirth.replace(/-/g, "/"); // Format - to /
         
         if (dateofbirth) {
             const formattedDOBToSet = moment(formattedDOB, "DD/MM/YYYY");
             const day = formattedDOBToSet.format('DD');
             const englishMonth = formattedDOBToSet.format('MMMM');
             const year = formattedDOBToSet.format('YYYY');
             const indonesianMonth = indonesianMonths[englishMonth];

             const formattedDate = day + '/' + indonesianMonth + '/' + year;

             const dobInputClosest = container.querySelector('.dob');
             if (dobInputClosest) {
                 dobInputClosest.value = formattedDate;
                 initDatepickerFromScan(dobInputClosest, formattedDOBToSet);
             }

             // Calculate age
             const birthDate = moment(formattedDOB, "DD/MM/YYYY");
             const today = moment();
             let age = today.diff(birthDate, 'years');

             const ageInputClosest = container.querySelector('.age');
             if (ageInputClosest) {
                 ageInputClosest.value = age;
             }
         }
     }
 }
  
 
$('.btn__submit').on('click', function() {
    console.log('EXECUTE HERE!!!! to>>' + kycURL);

    const requiredFields = document.querySelectorAll('.container-form [required]');
    let isValid = true;

    requiredFields.forEach(function(field) {
        // Cek apakah field adalah radio buttons
        if (field.type === 'radio') {
            const name = field.name;
            const selectedRadio = document.querySelector('input[name="' + name + '"]:checked');

            if (!selectedRadio) {
                field.classList.add('invalid');
                isValid = false;

                // Menandai kelas invalid pada kontainer radio
                const radioContainer = field.closest('.gender-container');
                if (radioContainer) {
                    radioContainer.classList.add('invalid');
                }
            } else {
                // Jika ada radio yang dipilih, hapus kelas invalid
                field.classList.remove('invalid');
                const radioContainer = field.closest('.gender-container');
                if (radioContainer) {
                    radioContainer.classList.remove('invalid');
                }
            }
            //return;
        }

        // Validasi untuk input lainnya
        if (!field.value.trim()) {
            field.classList.add('invalid');
            isValid = false;

            // Cek jika field adalah fileInput
            if (field.classList.contains('fileInput')) {
                const containerTarget = field.closest('div').querySelector('.thumbnail');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah dob
            if (field.classList.contains('dob')) {
                const containerTarget = field.closest('.dob-wrapper');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah marital status
            if (field.classList.contains('status-kawin')) {
                const containerTarget = field.closest('.status-kawin-container');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah nationality
            if (field.classList.contains('negara')) {
                const containerTarget = field.closest('.negara-container');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah job
            if (field.classList.contains('job')) {
                const containerTarget = field.closest('.job-container');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah relation
            if (field.classList.contains('relationship')) {
                const containerTarget = field.closest('.relationship-container');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }
        } else {
            // remove class 
            field.classList.remove('invalid');

            // Cek jika field adalah fileInput
            if (field.classList.contains('fileInput')) {
                const thumbnail = field.closest('div').querySelector('.thumbnail');
                if (thumbnail) {
                    thumbnail.classList.remove('invalid');
                }
            }

            // Jika field adalah dob, hapus invalid dari dob-wrapper
            if (field.classList.contains('dob')) {
                const dobWrapper = field.closest('.dob-wrapper');
                if (dobWrapper) {
                    dobWrapper.classList.remove('invalid');
                }
            }

            // Cek jika field adalah marital status
            if (field.classList.contains('status-kawin')) {
                const containerTarget = field.closest('.status-kawin-container');
                if (containerTarget) {
                    containerTarget.classList.remove('invalid');
                }
            }

            // Cek jika field adalah nationality
            if (field.classList.contains('negara')) {
                const containerTarget = field.closest('.negara-container');
                if (containerTarget) {
                    containerTarget.classList.remove('invalid');
                }
            }

            // Cek jika field adalah job
            if (field.classList.contains('job')) {
                const containerTarget = field.closest('.job-container');
                if (containerTarget) {
                    containerTarget.classList.remove('invalid');
                }
            }

            // Cek jika field adalah relation
            if (field.classList.contains('relationship')) {
                const containerTarget = field.closest('.relationship-container');
                if (containerTarget) {
                    containerTarget.classList.remove('invalid');
                }
            }
        }
    });

    console.log('is valid', isValid);

    if (isValid) {
        //alert('ready submitted successfully!');
        preparePayload();
    }
});


// Helper function to extract input values
function getValue(selector) {
    console.log('getValue>>' + selector);
    const element = document.querySelector(selector);
    return element ? element.value : '';
}

// Helper function to extract checked radio/checkbox values
function getCheckedValue(selector) {
    console.log('getCheckedValue>>' + selector);
    const element = document.querySelector(selector + ':checked');
    return element ? element.value : '';
}

// Convert image to Base64
function getBase64(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.onload = () => resolve(reader.result);
        reader.onerror = reject;
        reader.readAsDataURL(file);
    });
}

async function preparePayload() {
    console.log('call preparePayload!!');

    //check if insured is polis
    const checkbox = document.querySelector('input[type="checkbox"][name="insuredIsPolis"]');
    const isChecked = checkbox ? checkbox.checked : false;

    const promoCode = $('#promo-code').val();


    // Collect policyholder data
    const policyholderData = await collectData('polisholder');

    // Collect insured data (with additional relationship field)
    const insuredDataList = [];
    const insuredCount = document.querySelectorAll('.insured-form').length; // Or any dynamic count you have

    console.log('total tertanggung>>' + insuredCount);

    for (let i = 0; i < insuredCount; i++) {
        // Collect data for each insured
        const insuredData = await collectData('insured', i);

        // Construct the selector for the relationship field
        const relationshipSelector = 'select[name="input_relationship_insured_' + i + '"]';
        insuredData._relationship = getValue(relationshipSelector);

        // Add collected data to the list
        insuredDataList.push(insuredData);
    }

    // Combine policyholder data and insured data into one payload
    const payload = {
        policyholder: policyholderData,
        insured: insuredDataList,
        insuredIsPolis: isChecked,
        promoCode
    };

    console.log('Payload ready to send:', payload);

    // Send payload as JSON via AJAX
    $.ajax({
        type: "POST",
        url: kycURL,
        data: JSON.stringify(payload),
        contentType: "application/json",
        success: function(response) {
            console.log('Success:', response);

            //redirect to next step
           window.location.href = link;
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
}

//Helper function to collect form data based on a type (policyholder or insured) and an index for insured persons
async function collectData(type, index = null) {

    // If an index is provided (for insured data), append it to field selectors
    const indexSuffix = index !== null ? '_' + index : '';

    const data = {
        _ispep: getCheckedValue('input[name="input_ispep_' + type + indexSuffix + '"]'),
        _fotoktp: '',
        _name: getValue('input[name="input_name_' + type + indexSuffix + '"]'),
        _ktppaspor: getValue('input[name="input_ktppaspor_' + type + indexSuffix + '"]'),
        _dob: getValue('input[name="input_dob_' + type + indexSuffix + '"]'),
        _pdob: getValue('input[name="input_pdob_' + type + indexSuffix + '"]'),
        _gender: getCheckedValue('input[name="input_gender_' + type + indexSuffix + '"]'),
        _kodenegara: getValue('select[name="input_kodenegara_' + type + indexSuffix + '"]'),
        _hp: getValue('input[name="input_hp_' + type + indexSuffix + '"]'),
        _negara: getValue('select[name="input_negara_' + type + indexSuffix + '"]'),
        _job: getValue('select[name="input_job_' + type + indexSuffix + '"]'),
        _ktpkitas: getValue('input[name="input_ktpkitas_' + type + indexSuffix + '"]'),
        _age: getValue('input[name="input_age_' + type + indexSuffix + '"]'),
        _statuskawin: getValue('select[name="input_status-kawin_' + type + indexSuffix + '"]'),
        _telepon: getValue('input[name="input_telepon_' + type + indexSuffix + '"]'),
        _email: getValue('input[name="input_email_' + type + indexSuffix + '"]'),
        _kodepos: getValue('input[name="input_kodepos_' + type + indexSuffix + '"]'),
        _alamat: getValue('textarea[name="input_alamat_' + type + indexSuffix + '"]')
    };
    
 	// Handle image conversion (if applicable)
    const fileInput = document.querySelector('input[name="input_fotoktp_' + type + indexSuffix + '"]');
    if (fileInput && fileInput.files.length > 0) {
        base64Result = await getBase64(fileInput.files[0]);
        data._fotoktp = base64Result;
    }

    return data;
}


function initDatepickerFromScan(inputClass, date) {
    console.log('call initial datepicker scan');
    $(inputClass).daterangepicker({
        parentEl: ".dob-wrapper",
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        startDate: date,
        maxDate: moment(),
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        locale: {
            applyLabel: 'Pilih',
            cancelLabel: 'Batal',
            "daysOfWeek": [
                "Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"
            ],
            "monthNames": [
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            ],
        }
    });
}

document.addEventListener('DOMContentLoaded', function() {

    /* delete bg-white default liferay */

    var contentSection = document.getElementById('content');
    if (contentSection) {
        contentSection.classList.remove('bg-white');
    }

});


$(document).ready(function() {

    //call render form insured
    renderInsuredForm(3);

    //negara
    fetch('https://restcountries.com/v3.1/all')
        .then(response => response.json())
        .then(data => {
            const select = $('.negara');

            // Clear existing options (if any)
            select.empty();

            // Add placeholder option
            select.append('<option></option>');

            // Append country options
            data.forEach(function(country) {
                select.append('<option value="' + country.name.common + '">' + country.name.common + '</option>');
            });

            // Initialize Select2 after populating the options
            $('.negara').select2({
                dropdownParent: '#single-journey-wrapper',
                placeholder: "Pilih Negara",
                width: '100%',
                minimumResultsForSearch: 0
            });
        })
        .catch(error => {
            console.error('Error fetching country data:', error);
        });



    //kode negara
    fetch('https://restcountries.com/v3.1/all')
        .then(response => response.json())
        .then(data => {
            const select = $('.kode');

            // Clear existing options (if any)
            select.empty();

            // Add placeholder option
            select.append('<option></option>');

            // Append country code options (calling code + country name)
            data.forEach(function(country) {
                const callingCode = country.idd.root + (country.idd.suffixes ? country.idd.suffixes[0] : '');
                select.append('<option value="' + callingCode + '">' + callingCode + ' (' + country.name.common + ')</option>');
            });

            // Initialize Select2 after populating the options
            $('.kode').select2({
                dropdownParent: '#single-journey-wrapper',
                placeholder: "Pilih Kode Negara",
                width: '100%',
                minimumResultsForSearch: 0
            });
        })
        .catch(error => {
            console.error('Error fetching country data:', error);
        });

    $('.job').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Pekerjaan",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('.relationship').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Hubungan",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('.status-kawin').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Status Perkawinan",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('.provinsi').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Provinsi",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('.kabupaten').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Kabupaten/Kota",
        width: '100%',
        minimumResultsForSearch: -1
    });


    // start dob datepicker
    $('.dob').daterangepicker({
        parentEl: ".dob-wrapper",
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        maxDate: moment(),
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        locale: {
            applyLabel: 'Pilih',
            cancelLabel: 'Batal',
            "daysOfWeek": [
                "Min",
                "Sen",
                "Sel",
                "Rab",
                "Kam",
                "Jum",
                "Sab",
            ],
            "monthNames": [
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember"
            ],
        }
    });

    $('.dob').on('apply.daterangepicker', function(ev, picker) {

        console.log('test apply date');

        // Ambil hari, bulan, dan tahun
        const day = picker.startDate.format('DD');
        const englishMonth = picker.startDate.format('MMMM');
        const year = picker.startDate.format('YYYY');
        const indonesianMonth = indonesianMonths[englishMonth];

        // Format tanggal tanpa menggunakan backtick
        const formattedDate = day + '/' + indonesianMonth + '/' + year;

        $(this).val(formattedDate);

        const birthDate = picker.startDate;
        const today = moment();
        let age = today.diff(birthDate, 'years');
        const monthDiff = today.diff(birthDate, 'months') % 12;

        if (monthDiff < 0 || (monthDiff === 0 && today.date() < birthDate.date())) {
            age--;
        }

        // Cari input age yang terdekat dalam div dengan class 'panel-cover'
        $(this).closest('.panel-cover').find('.age').val(age);
    });

    $('.dob').on('cancel.daterangepicker', function(ev, picker) {
        $(this).val('');
        // Kosongkan input age yang terdekat dalam div dengan class 'panel-cover'
        $(this).closest('.panel-cover').find('.age').val('');
    });



    //detect button upload
    //Image upload
    document.querySelectorAll('.uploadButton').forEach(button => {
        console.log('');
        button.addEventListener('click', function() {
            this.closest('.thumbnail-wrapper').querySelector('.fileInput').click();
        });
    });

    document.querySelectorAll('.fileInput').forEach(input => {
        input.addEventListener('change', function(event) {

            // Panggil handleFileChange saat file di-upload
            handleFileChange(this); //this bawa fileInput


            //manipulate name file
            const file = event.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function(e) {
                    const wrapper = input.closest('.thumbnail-wrapper');
                    wrapper.querySelector('.thumbnail').src = e.target.result;

                    // Update file name span
                    const fileNameSpan = wrapper.querySelector('.file-name');
                    let fileName = file.name;

                    if (fileName.length > 70) {
                        // Only keep the last 50 characters and prepend "..."
                        fileName = "..." + fileName.slice(-50);

                        let formattedName = '';
                        for (let i = 0; i < fileName.length; i += 20) {
                            formattedName += fileName.slice(i, i + 20) + "\n";
                        }
                        fileName = formattedName.trim(); // Remove the last newline

                        fileName = formattedName.trim();
                    }


                    fileNameSpan.textContent = fileName;
                }
                reader.readAsDataURL(file);
            }
        });
    });



    $('#btn__accordion-toggle').on('click', function() {
        const content = $('#collapseOne');
        const icon = $('#accordion-icon');
        if (content.hasClass('show')) {
            // Jika konten sudah ditampilkan, sembunyikan dan ubah ikon
            content.removeClass('show');
            icon.removeClass('fa-chevron-up').addClass('fa-chevron-down');
        } else {
            // Jika konten belum ditampilkan, tampilkan dan ubah ikon
            content.addClass('show');
            icon.removeClass('fa-chevron-down').addClass('fa-chevron-up');
        }
    });



    $('.checkbox-container').on('click', function() {
        console.log('check CHECKBOX')

        const checkbox = $(this).find('.checkbox-input');

        // Toggle checked state
        checkbox.prop('checked', !checkbox.prop('checked'));

        // Toggle classes based on checked state
        $(this).toggleClass('checked', checkbox.prop('checked'));

        // Ambil elemen collapse dan ikon
        const content = document.getElementById('collapseOne');
        const icon = document.getElementById('accordion-icon');

        //get panel insured
        const containerformsInsured = $(this).closest('.panel-cover');

        if (checkbox.prop('checked')) {
            // Jika checkbox dicentang, sembunyikan konten dan ubah ikon
            if (content.classList.contains('show')) {
                content.classList.remove('show');
                icon.classList.remove('fa-chevron-up');
                icon.classList.add('fa-chevron-down');
            }

            //copy value polis
            copyPolisholderToInsured();

            // Nonaktifkan semua input dalam #collapseOne
            $('#collapseOne').find('input, select, textarea, button').prop('disabled', true);

            // remove (not check validation)
            containerformsInsured.removeClass('container-form');
            // Hapus semua class 'invalid' dari seluruh cucu elemen
            containerformsInsured.find('.invalid').removeClass('invalid');

        } else {
            // Jika checkbox tidak dicentang, tampilkan konten dan ubah ikon
            content.classList.add('show');
            icon.classList.remove('fa-chevron-down');
            icon.classList.add('fa-chevron-up');

            //reset value 
            resetInsuredFields(0);

            // Aktifkan kembali semua input dalam #collapseOne
            $('#collapseOne').find('input, select, textarea, button').prop('disabled', false);

            // add (need check validation)
            containerformsInsured.addClass('container-form');
        }
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


});


function handleInput(event) {
    const input = event.target;
    // Hanya mengizinkan angka dengan regex
    input.value = input.value.replace(/[^0-9]/g, '');
}

async function copyPolisholderToInsured() {
    console.log('copy value polis holder!!!')
    // Dapatkan nilai dari field polisholder
    const polisholderData = {
        _ispep: getCheckedValue('input[name="input_ispep_polisholder"]'),
        _fotoktp: '', // Tidak bisa disalin secara langsung karena ini adalah file, bisa handle terpisah
        _name: getValue('input[name="input_name_polisholder"]'),
        _ktppaspor: getValue('input[name="input_ktppaspor_polisholder"]'),
        _dob: getValue('input[name="input_dob_polisholder"]'),
        _pdob: getValue('input[name="input_pdob_polisholder"]'),
        _gender: getCheckedValue('input[name="input_gender_polisholder"]'),
        _kodenegara: getValue('select[name="input_kodenegara_polisholder"]'),
        _hp: getValue('input[name="input_hp_polisholder"]'),
        _negara: getValue('select[name="input_negara_polisholder"]'),
        _job: getValue('select[name="input_job_polisholder"]'),
        _ktpkitas: getValue('input[name="input_ktpkitas_polisholder"]'),
        _age: getValue('input[name="input_age_polisholder"]'),
        _statuskawin: getValue('select[name="input_status-kawin_polisholder"]'),
        _telepon: getValue('input[name="input_telepon_polisholder"]'),
        _email: getValue('input[name="input_email_polisholder"]'),
        _kodepos: getValue('input[name="input_kodepos_polisholder"]'),
        _alamat: getValue('textarea[name="input_alamat_polisholder"]')
    };


    // Set nilai ke field insured_0
    const gett = document.querySelector('input[name="input_ispep_insured_0"][value="' + polisholderData._ispep + '"]');
    gett.checked = true;
    document.querySelector('input[name="input_name_insured_0"]').value = polisholderData._name;
    document.querySelector('input[name="input_ktppaspor_insured_0"]').value = polisholderData._ktppaspor;
    document.querySelector('input[name="input_dob_insured_0"]').value = polisholderData._dob;
    document.querySelector('input[name="input_pdob_insured_0"]').value = polisholderData._pdob;
    document.querySelector('input[name="input_gender_insured_0"][value="' + polisholderData._gender + '"]').checked = true;
    document.querySelector('input[name="input_hp_insured_0"]').value = polisholderData._hp;
    document.querySelector('input[name="input_ktpkitas_insured_0"]').value = polisholderData._ktpkitas;
    document.querySelector('input[name="input_age_insured_0"]').value = polisholderData._age;
    document.querySelector('input[name="input_telepon_insured_0"]').value = polisholderData._telepon;
    document.querySelector('input[name="input_email_insured_0"]').value = polisholderData._email;
    document.querySelector('input[name="input_kodepos_insured_0"]').value = polisholderData._kodepos;
    document.querySelector('textarea[name="input_alamat_insured_0"]').value = polisholderData._alamat;
    
 	// Handle image conversion (if applicable)
    document.querySelector('input[name="input_fotoktp_insured_0"]').value = base64Result;
 	
    //using select 2
    const closestContainer = document.querySelector('input[name="input_ktppaspor_insured_0"]').closest('.panel-cover');
    
    if (closestContainer) {
        $(closestContainer).find('.status-kawin').val(polisholderData._statuskawin).trigger('change');
        $(closestContainer).find('.negara').val(polisholderData._negara).trigger('change');
        $(closestContainer).find('.job').val(polisholderData._job).trigger('change');
        $(closestContainer).find('.kode').val(polisholderData._kodenegara).trigger('change');
    }
}

function resetInsuredFields(index) {
    document.querySelector('input[name="input_ispep_insured_' + index + '"]').checked = false;
    document.querySelector('input[name="input_name_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_ktppaspor_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_dob_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_pdob_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_gender_insured_' + index + '"]').checked = false;
    document.querySelector('input[name="input_hp_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_ktpkitas_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_age_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_telepon_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_email_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_kodepos_insured_' + index + '"]').value = '';
    document.querySelector('textarea[name="input_alamat_insured_' + index + '"]').value = '';
    
    document.querySelector('input[name="input_fotoktp_insured_' + index + '"]').value= '';

    //using select 2
    const closestContainer = document.querySelector('input[name="input_ktppaspor_insured_0"]').closest('.container-form');

    if (closestContainer) {
        // Set nilai select2 dalam container terdekat
        $(closestContainer).find('.status-kawin').val('').trigger('change');
        $(closestContainer).find('.negara').val('').trigger('change');
        $(closestContainer).find('.job').val('').trigger('change');
        $(closestContainer).find('.kode').val('').trigger('change');
    }


}

function renderCheckboxSection(container) {
    console.log('call renderCheckboxSection');
    // Create the outer container div
    const outerDiv = document.createElement('div');
    outerDiv.className = 'pb-2level';

    // Create the flex container
    const flexContainer = document.createElement('div');
    flexContainer.className = 'display-flex align-items-center';

    // Hidden checkbox input
    const checkboxInput = document.createElement('input');
    checkboxInput.type = 'checkbox';
    checkboxInput.id = 'custom-checkbox';
    checkboxInput.className = 'display-hidden';

    // Label for the checkbox
    const label = document.createElement('label');
    label.htmlFor = 'custom-checkbox-x';
    label.className = 'display-flex align-items-center';

    // Checkbox container div
    const checkboxContainer = document.createElement('div');
    checkboxContainer.className = 'checkbox-container w-4level h-4level agency__border-border-gray-300 agency__rounded-sm display-flex align-items-center agency__justify-center mr-2level position-relative';

    // Inner hidden checkbox input
    const innerCheckbox = document.createElement('input');
    innerCheckbox.type = 'checkbox';
    innerCheckbox.className = 'display-hidden checkbox-input';
    innerCheckbox.name = 'insuredIsPolis';

    // SVG for the custom checkbox
    const svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');

    svg.setAttribute('class', 'checkboxSamePolis display-hidden agency__bg-axa-blue-400 w-4level h-4level agency__text-white position-absolute');
    svg.setAttribute('xmlns', 'http://www.w3.org/2000/svg');
    svg.setAttribute('fill', 'none');
    svg.setAttribute('viewBox', '0 0 24 24');
    svg.setAttribute('stroke', 'currentColor');

    // Path for the SVG
    const path = document.createElementNS('http://www.w3.org/2000/svg', 'path');
    path.setAttribute('stroke-linecap', 'round');
    path.setAttribute('stroke-linejoin', 'round');
    path.setAttribute('stroke-width', '2');
    path.setAttribute('d', 'M5 13l4 4L19 7');
    svg.appendChild(path);

    // Span for the checkbox description
    const span = document.createElement('span');
    span.className = 'checkBoxSpanDataSamePolis';
    span.textContent = 'Data Tertanggung Utama sama dengan data pemegang polis';

    // Append elements to build the structure
    checkboxContainer.appendChild(innerCheckbox);
    checkboxContainer.appendChild(svg);
    label.appendChild(checkboxContainer);
    label.appendChild(span);
    flexContainer.appendChild(checkboxInput);
    flexContainer.appendChild(label);
    outerDiv.appendChild(flexContainer);

    // Append the entire structure to the desired location in the DOM
    container.appendChild(outerDiv);
}


//render form insured
function renderInsuredForm(count) {

    console.log('CALL renderInsuredForm');
    const mainContainer = document.getElementById('container-generate-insured');
    mainContainer.innerHTML = ''; // Clear previous content

    for (let i = 0; i < count; i++) {

        // Container untuk menyimpan elemen yang akan dirender
        const container = document.createElement('div');
        container.className = 'panel-cover pt-10level mt-10level px-10level container-form';

        // Header
        const headerDiv = document.createElement('div');
        headerDiv.className = 'flex-justify-between align-items-center';
        const title = document.createElement('h1');
        title.className = 'agency__text-xl agency__font-bold';
        if (i === 0) {
            title.textContent = 'Data Tertanggung Utama';
        } else {
            title.textContent = 'Data Tertanggung ' + i;
        }

        headerDiv.appendChild(title);

        if (i === 0) {
            // Button untuk toggle accordion
            const toggleButton = document.createElement('button');
            toggleButton.id = 'btn__accordion-toggle';
            toggleButton.className = 'flex-justify-center align-items-center agency__w-10__h-10 agency__bg-axa-blue-400 agency__text-white';
            toggleButton.innerHTML = '<i id="accordion-icon" class="fas fa-chevron-down agency__text-xs"></i>';

            headerDiv.appendChild(toggleButton);
        }

        container.appendChild(headerDiv);

        // Create the checkbox element if index is 0
        if (i === 0) {
            renderCheckboxSection(container);
        }

        // Child collapse untuk tertanggung utama
        const collapseDiv = document.createElement('div');
        if (i === 0) {
            collapseDiv.id = 'collapseOne';
        }
        collapseDiv.className = 'accordion-collapse show';


        const insuredFormDiv = document.createElement('div');
        insuredFormDiv.className = 'insured-form';

        const ispepDiv = document.createElement('div');
        ispepDiv.className = 'ispep';
        ispepDiv.innerHTML =
            '<span class="agency__underline">' +
            'Apakah pemegang polis termasuk ke dalam kategori Orang yang ' +
            '<span class="agency__text-axa-sienna-400"> Populer secara politisi / ' +
            '<span class="agency__italic">Politically Exposed Persons </span> (PEP) </span> ?' +
            '</span>' +
            '<a class="btn--white__step3 ml-2level" href="#">' +
            '<span> Baca Selengkapnya <i class="fas fa-arrow-right"></i> </span>' +
            '</a>' +
            '<div class="radio-group">' +
            '<div>' +
            '<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">' +
            '<input id="no' + i + '" class="radio-custom" name="input_ispep_insured_' + i + '" type="radio" value="0" checked="checked" />' +
            '<label for="no' + i + '" class="radio-custom-label mb-0"><span>Tidak</span></label>' +
            '</div>' +
            '</div>' +
            '<div>' +
            '<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">' +
            '<input id="yes' + i + '" class="radio-custom" name="input_ispep_insured_' + i + '" type="radio" value="1" />' +
            '<label for="yes' + i + '" class="radio-custom-label mb-0">' +
            '<span>' +
            'Ya' +
            '<span class="ispepYes">(Data Anda akan kami tinjau untuk melewati persetujuan dari Underwriting)</span>' +
            '</span>' +
            '</label>' +
            '</div>' +
            '</div>' +
            '</div>';

        insuredFormDiv.appendChild(ispepDiv);

        const formColumnDiv = document.createElement('div');
        formColumnDiv.className = 'form-column display-flex agency__flex-wrap gap-4level';
        const form = document.createElement('form');
        form.className = 'display-flex agency__flex-wrap gap-4level';

        // Kolom Kiri
        const leftColumn = document.createElement('div');
        leftColumn.className = 'agency__flex-1 agency__min-w-300px';

        //foto ktp
        const fotoDiv = document.createElement('div');
        fotoDiv.innerHTML =
            '<div class="upload-container">' +
            '<label for="upload"> Upload Foto KTP / KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
            '<div class="thumbnail-wrapper">' +
            '<img class="thumbnail img-thumbnail img-fluid" src="/o/mypage-theme/images/ktp-image.png" alt="foto ktp" />' +
            '<div class="ml-5level mt-2level">' +
            '<span class="file-name agency__text-xs"></span>' +
            '<button type="button" class="uploadButton agency__rounded-4px">Pilih File</button>' +
            '</div>' +
            '<input type="file" class="fileInput input_fotoktp_insured_' + i + ' display-hidden" accept="image/*" name="input_fotoktp_insured_' + i + '" required="required" />' +
            '</div>' +
            '</div>';

        //<!-- name -->
        const nameDiv = document.createElement('div');
        nameDiv.innerHTML =
            '<div> <label for="name"> Nama lengkap sesuai KTP / KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputName" placeholder="Tulis Nama" name="input_name_insured_' + i + '" type="text" required="required" /> </div> </div>';

        //<!-- ktppasspor -->
        const ktppasporDiv = document.createElement('div');
        ktppasporDiv.innerHTML =
            '<div><label for="ktppasspor"> Nomor Paspor <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Nomor Paspor" name="input_ktppaspor_insured_' + i + '" type="text" maxlength="16" required="required" oninput="handleInput(event)" /> </div> </div>';

        //<!-- dob --> 
        const dobDiv = document.createElement('div');
        dobDiv.innerHTML =
            '<div> <label class="display-block" for="dateofbirth">Tanggal Lahir <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="calendar-wrapper position-relative" id="calendar-wrapper-claim"> <div class="calendar-col position-relative dob-wrapper"> <input class="input-control-axa input-control-axa--outline input-icon-date dob" type="text" name="input_dob_insured_' + i + '" autocomplete="off" placeholder="Pilih Tanggal Lahir" readonly="readonly" required="required" /> </div> </div> </div>';

        //<!-- place -->
        const placeDiv = document.createElement('div');
        placeDiv.innerHTML =
            '<div class="place"> <label for="place"> Tempat Lahir <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputPlaceOfBirth" placeholder="Tulis Tempat Lahir" name="input_pdob_insured_' + i + '" type="text" required="required" /> </div> </div>';


        //<!-- gender -->
        const genderDiv = document.createElement('div');
        genderDiv.innerHTML =
            '<div> <label for="gender">Jenis Kelamin <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="form-radio-wrapper display-flex"> <div class="display-flex gender-container"> <div class="form-radio mr-8px"> <input class="classInputGenderMale" type="radio" name="input_gender_insured_' + i + '" value="M" required="required" /> <div class="box-radio-wrapper agency__text-center"> <div class="box-radio"> <img src="/o/mypage-theme/images/man-nb.png" alt="laki" /> </div> <div class="box-text">Laki-Laki</div> </div> </div> <div class="form-radio"> <div class="form-radio-input"> <input type="radio" name="input_gender_insured_' + i + '" value="F" class="form-control classInputGenderFemale" required="required" /> <div class="box-radio-wrapper agency__text-center"> <div class="box-radio"> <img src="/o/mypage-theme/images/woman-nb.png" alt="perempuan" /> </div> <div class="box-text">Perempuan</div> </div> </div> </div> </div>  </div> </div>';

        //<!-- Kode negara dan telepon -->
        const kodeDiv = document.createElement('div');
        kodeDiv.innerHTML =
            '<div> <label for="kode">Kode Negara dan Telepon </label> <div id="single-journey-wrapper" class="position-relative"> <select class="input-control-axa kode" name="input_kodenegara_insured_' + i + '"> </select> </div> </div>';

        //<!-- hp -->
        const hpDiv = document.createElement('div');
        hpDiv.innerHTML =
            '<div> <label for="hp"> Nomor Handphone <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Nomor Handphone" name="input_hp_insured_' + i + '" type="text" maxlength="15" required="required" oninput="handleInput(event)" /> </div> </div>';

        //<!-- job -->
        const jobDiv = document.createElement('div');
        jobDiv.innerHTML =
            '<div> <label for="job">Pekerjaan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div id="single-journey-wrapper" class="position-relative job-container"> <select class="input-control-axa job" name="input_job_insured_' + i + '" required> <option></option> <option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option> <option value="Karyawan Swasta">Karyawan Swasta</option> <option value="TNI/POLRI">TNI/POLRI</option> <option value="PNS">PNS</option> <option value="Ibu Rumah Tangga">Ibu Rumah Tangga</option> <option value="Wiraswasta">Wiraswasta</option> <option value="Lainnya">Lainnya</option> </select> </div> </div> ';


        //append left
        leftColumn.appendChild(fotoDiv);
        leftColumn.appendChild(nameDiv);
        leftColumn.appendChild(ktppasporDiv);
        leftColumn.appendChild(dobDiv);
        leftColumn.appendChild(placeDiv);
        leftColumn.appendChild(genderDiv);
        leftColumn.appendChild(kodeDiv);
        leftColumn.appendChild(hpDiv);
        leftColumn.appendChild(jobDiv);



        // Kolom Kanan
        const rightColumn = document.createElement('div');
        rightColumn.className = 'agency__flex-1 agency__min-w-300px';

        //negara
        const negaraDiv = document.createElement('div');
        negaraDiv.innerHTML =
            '<div class="passpordiv">' +
            '<label for="negara">Kewarganegaraan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
            '<div id="single-journey-wrapper" class="position-relative negara-container">' +
            '<select class="input-control-axa negara" name="input_negara_insured_' + i + '" required>' +
            '<!-- Options will be dynamically added by JavaScript -->' +
            '</select>' +
            '</div>' +
            '</div>';


        //<!-- passpor -->
        const pasporDiv = document.createElement('div');
        pasporDiv.innerHTML =
            '<div> <label for="ktppaspor"> Nomor KTP / KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputKtpKitas" placeholder="Tulis No. KTP / KITAS" name="input_ktpkitas_insured_' + i + '" type="text" maxlength="16" required="required" oninput="handleInput(event)" /> </div> </div>';

        //<!-- age -->
        const ageDiv = document.createElement('div');
        ageDiv.innerHTML =
            '<div> <label for="age"> Usia </label> <div class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome"> <input disabled="disabled" class="input-control-axa age" placeholder="0" name="input_age_insured_' + i + '" type="text" /> <span class="font_tahun">Tahun</span> </div> </div>';

        //<!-- hubungan -->
        const hubunganDiv = document.createElement('div');
        hubunganDiv.innerHTML =
            '<div> <label for="relationship">Hubungan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div id="single-journey-wrapper" class="position-relative relationship-container"> <select class="input-control-axa relationship" name="input_relationship_insured_' + i + '" required> <option></option> <option value="Tertangggung Utama" selected="selected">Tertangggung Utama</option> <option value="Kerabat">Kerabat</option> <option value="Teman">Teman</option> </select>  </div> </div>';


        // <!-- status kawin -->
        const statusKawinDiv = document.createElement('div');
        statusKawinDiv.innerHTML =
            '<div> <label for="status-kawin">Status Perkawinan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div id="single-journey-wrapper" class="position-relative status-kawin-container"> <select class="input-control-axa status-kawin" name="input_status-kawin_insured_' + i + '" required> <option></option> <option value="Belum Menikah">Belum Menikah</option> <option value="Sudah Menikah">Sudah Menikah</option> </select> </div> </div>';


        //<!-- telepon -->
        const teleponDiv = document.createElement('div');
        teleponDiv.innerHTML =
            '<div class="telepondiv"> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Nomor Telepon" name="input_telepon_insured_' + i + '" type="text" /> </div> </div>';


        //<!-- email -->
        const emailDiv = document.createElement('div');
        emailDiv.innerHTML =
            '<div> <label for="email">Email <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis email" name="input_email_insured_' + i + '" type="text" required="required" /> </div> </div>';

        //<!-- kode pos -->
        const posDiv = document.createElement('div');
        posDiv.innerHTML =
            '<div> <label for="kodepos">Kode Pos <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Kode Pos" name="input_kodepos_insured_' + i + '" type="text" required="required" /> </div> </div>';

        //append right
        rightColumn.appendChild(negaraDiv);
        rightColumn.appendChild(pasporDiv);
        rightColumn.appendChild(ageDiv);
        rightColumn.appendChild(hubunganDiv);
        rightColumn.appendChild(statusKawinDiv);
        rightColumn.appendChild(teleponDiv);
        rightColumn.appendChild(emailDiv);
        rightColumn.appendChild(posDiv);


        // Alamat
        const alamatDiv = document.createElement('div');
        alamatDiv.className = 'alamatdiv';
        alamatDiv.innerHTML =
            '<label for="alamat">Alamat Lengkap <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
            '<div class="input-group-axa input-group-axa--border">' +
            '<textarea class="input-control-axa classInputAddress" placeholder="Tulis Alamat Lengkap" name="input_alamat_insured_' + i + '" required="required"></textarea>' +
            '</div>';

        form.appendChild(leftColumn);
        form.appendChild(rightColumn);
        form.appendChild(alamatDiv);
        formColumnDiv.appendChild(form);
        insuredFormDiv.appendChild(formColumnDiv);
        collapseDiv.appendChild(insuredFormDiv);
        container.appendChild(collapseDiv);

        // Menambahkan container ke body atau elemen yang diinginkan
        mainContainer.appendChild(container);
    }
}

</script>


<script src="<%=request.getContextPath()%>/dashboard/js/main.js"
	type="text/javascript"></script> --%>
	
	
	
	
	
	
	<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../init.jsp"%>

<%
	String portalURL = PortalUtil.getPortalURL(request);
	String restApiUrl = portalURL + "/o/api/sti/step3"; ///o access from osgi, /api/sti/kyc is path api 
	String restApiOcrUrl = portalURL + "/o/api/sti/ocr";
%>

<%-- Membuat URL untuk riplay.jsp --%>
<portlet:renderURL var="riplayURL">
	<portlet:param name="jspPage" value="/dashboard/riplay.jsp" />
</portlet:renderURL>

<script>
					var kycURL = "<%=restApiUrl%>";
					var ocrURL = "<%=restApiOcrUrl%>";
					var link = "<%=riplayURL%>";
</script>


<script src="<%=request.getContextPath()%>/js/main.js"
	type="text/javascript"></script>

<header class="hero">
	<img src="/o/mypage-theme/images/step2hero.png" alt="herostep2"
		class="width-full height-full">
</header>

<section class="chosee-plan">

	<!-- navbar -->
	<%@ include file="navbar.jsp"%>


	<!-- step bar -->
	<div class="stepper-wrapper">
		<div class="stepper-item completed">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Pilih Perlindungan</div>
		</div>
		<div class="stepper-item active">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Data Pemegang Polis</div>
		</div>
		<div class="stepper-item">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Persetujuan</div>
		</div>
		<div class="stepper-item">
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
							<section class="smart-mediacare-inter__table step3" id="Sec-1">

								<!-- data polis holder -->
								<div class="panel-cover pt-10level px-10level container-form">

									<h1>Data Pemegang Polis</h1>

									<div class="ispep">
										<span class="agency__underline"> Apakah pemegang polis
											termasuk ke dalam kategori Orang yang <span
											class="agency__text-axa-sienna-400"> Populer secara
												politisi / <span class="agency__italic">Politically
													Exposed Persons </span> (PEP)
										</span> ?
										</span> <a class="btn--white__step3  ml-2level" href="#"> <span>
												Baca Selengkapnya <i class="fas fa-arrow-right"></i>
										</span>
										</a>

										<div class="radio-group">

											<div>
												<div
													class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
													<input id="no" class="radio-custom"
														name="input_ispep_polisholder" type="radio" value="0"
														checked="checked"> <label for="no"
														class="radio-custom-label mb-0"><span>Tidak</span></label>
												</div>
											</div>
											<div>
												<div
													class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
													<input id="yes" class="radio-custom"
														name="input_ispep_polisholder" type="radio" value="1">
													<label for="yes" class="radio-custom-label mb-0"><span>Ya
															<span class="ispepYes">(Data Anda akan kami tinjau
																untuk melewati persetujuan dari Underwriting)</span>
													</span></label>
												</div>
											</div>

										</div>

									</div>


									<div
										class="form-column display-flex agency__flex-wrap gap-4level">
										<form class="display-flex agency__flex-wrap gap-4level">

											<!-- Kolom Kiri -->
											<div class="agency__flex-1 agency__min-w-300px">

												<!-- Negara -->
												<div>
													<label for="negara">Kewarganegaraan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative negara-container">
														<select class="input-control-axa negara"
															name="input_negara_polisholder" required>

															<!-- Options will be dynamically added by JavaScript -->
														</select>
													</div>
												</div>


												<!-- foto ktp -->
												<div class="upload-container">
													<label for="name"> Upload Foto KTP / KITAS <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="thumbnail-wrapper">
														<img class="thumbnail img-thumbnail img-fluid "
															src="/o/mypage-theme/images/ktp-image.png" alt="foto ktp">

														<div class="ml-5level mt-2level">
															<span class="file-name agency__text-xs"></span>
															<button type="button"
																class="uploadButton agency__rounded-4px">Pilih
																File</button>

														</div>
														<input type="file"
															class="fileInput input_fotoktp_polisholder display-hidden "
															accept="image/*" name="input_fotoktp_polisholder"
															required="required">
													</div>
												</div>


												<!-- name -->
												<div>
													<label for="name"> Nama lengkap sesuai KTP / KITAS
														<span class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputName"
															placeholder="Tulis Nama" name="input_name_polisholder"
															type="text" required="required"
															oninput="handleInputHurufDanSpasi(event)">
													</div>
												</div>

												<!-- ktppasspor -->
												<div>
													<label for="ktppasspor"> Nomor Paspor <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Nomor Paspor"
															name="input_ktppaspor_polisholder" type="text"
															maxlength="16" required="required"
															oninput="handleInput(event)">
													</div>
												</div>

												<!-- dob -->
												<div>
													<label class="display-block" for="dateofbirth">Tanggal
														Lahir <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="calendar-wrapper position-relative"
														id="calendar-wrapper-claim">
														<div class="calendar-col position-relative dob-wrapper">
															<input
																class="input-control-axa input-control-axa--outline input-icon-date dob"
																type="text" name="input_dob_polisholder"
																autocomplete="off" placeholder="Pilih Tanggal Lahir"
																readonly="readonly" required="required">
														</div>
													</div>
												</div>

												<!-- place -->
												<!-- move to right column below age -->
												<!-- <div class="place">
													<label for="place"> Tempat Lahir <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputPlaceOfBirth"
															placeholder="Tulis Tempat Lahir"
															name="input_pdob_polisholder" type="text"
															required="required">
													</div>
												</div> -->

												<!-- gender -->
												<div>
													<label for="gender">Jenis Kelamin <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>

													<div class="form-radio-wrapper display-flex">
														<div class="display-flex gender-container">
															<div class="form-radio mr-8px">
																<input class="classInputGenderMale" type="radio"
																	name="input_gender_polisholder" value="M"
																	required="required">
																<div class="box-radio-wrapper agency__text-center">
																	<div class="box-radio">
																		<img src="/o/mypage-theme/images/man-nb.png"
																			alt="laki">
																	</div>
																	<div class="box-text">Laki-Laki</div>
																</div>
															</div>
															<div class="form-radio">
																<div class="form-radio-input">
																	<input type="radio" name="input_gender_polisholder"
																		value="F" class="form-control classInputGenderFemale"
																		required="required">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/woman-nb.png"
																				alt="perempuan">
																		</div>
																		<div class="box-text">Perempuan</div>
																	</div>
																</div>
															</div>
														</div>

													</div>
												</div>

												<!-- Kode negara dan telepon -->
												<div>
													<label for="kode">Kode Negara dan Telepon </label>
													<div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa kode"
															name="input_kodenegara_polisholder">

															<!-- Options will be dynamically added by JavaScript -->

														</select>
													</div>
												</div>

												<!-- hp -->
												<div>
													<label for="hp"> Nomor Handphone <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Nomor Handphone"
															name="input_hp_polisholder" type="text" maxlength="15"
															required="required" oninput="handleInput(event)">
													</div>
												</div>

												<!-- provinsi -->
												<!-- <div>
													<label for="provinsi">Provinsi <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa provinsi" name="provinsi"
															required>
															<option></option>
															<option value="Lorem Ipsum">provinsi lorem1</option>
															<option value="Lorem Ipsum 2">provinsi lorem2</option>
														</select>
													</div>
												</div> -->

												<!-- job -->
												<div>
													<label for="job">Pekerjaan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative job-container">
														<select class="input-control-axa job"
															name="input_job_polisholder" required>
															<option></option>
															<option value="Pelajar/Mahasiswa">
																Pelajar/Mahasiswa</option>
															<option value="Karyawan Swasta">Karyawan Swasta</option>
															<option value="TNI/POLRI">TNI/POLRI</option>
															<option value="PNS">PNS</option>
															<option value="Ibu Rumah Tangga">Ibu Rumah
																Tangga</option>
															<option value="Wiraswasta">Wiraswasta</option>
															<option value="Lainnya">Lainnya</option>

														</select>
													</div>
												</div>

											</div>

											<!-- Kolom Kanan -->
											<div class="agency__flex-1 agency__min-w-300px">

												<!-- Negara -->
												<!-- move to top left column -->
												<!-- <div class="passpordiv">
													<label for="negara">Kewarganegaraan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative negara-container">
														<select class="input-control-axa negara"
															name="input_negara_polisholder" required>

															Options will be dynamically added by JavaScript
														</select>
													</div>
												</div> -->

												<!-- passpor -->
												<div style="margin-top: 321px">
													<label for="ktppaspor"> Nomor KTP / KITAS <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputKtpKitas"
															placeholder="Tulis No. KTP / KITAS"
															name="input_ktpkitas_polisholder" type="text"
															maxlength="16" required="required"
															oninput="handleInput(event)">
													</div>
												</div>

												<!-- place -->
												<div class="place">
													<label for="place"> Tempat Lahir <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa classInputPlaceOfBirth"
															placeholder="Tulis Tempat Lahir"
															name="input_pdob_polisholder" type="text"
															required="required">
													</div>
												</div>

												<!-- age -->
												<div>
													<label for="age"> Usia </label>
													<div
														class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome">
														<input disabled="disabled" class="input-control-axa age"
															placeholder="0" name="input_age_polisholder" type="text">
														<span class="font_tahun">Tahun</span>
													</div>
												</div>


												<!-- status kawin -->
												<div>
													<!--no need 150 px top.  before <div class="mt-150px"> -->
													<label for="status-kawin">Status Perkawinan <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper"
														class="position-relative status-kawin-container">
														<select class="input-control-axa status-kawin"
															name="input_status-kawin_polisholder" required>
															<option></option>
															<option value="Belum Menikah">Belum Menikah</option>
															<option value="Sudah Menikah">Sudah Menikah</option>
														</select>
													</div>
												</div>

												<!-- telepon -->
												<div class="telepondiv">
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Nomor Telepon"
															name="input_telepon_polisholder" type="text">
													</div>
												</div>

												<!-- email -->
												<div>
													<label for="email">Email <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa" placeholder="Tulis email"
															name="input_email_polisholder" type="text"
															required="required">
													</div>
												</div>

												<!-- kode pos -->
												<div>
													<label for="kodepos">Kode Pos <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<input class="input-control-axa"
															placeholder="Tulis Kode Pos"
															name="input_kodepos_polisholder" type="text"
															required="required" maxlength="5">
													</div>
												</div>

												<!-- kab -->
												<!-- <div>
													<label for="kabupaten">Kabupaten/Kota <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div id="single-journey-wrapper" class="position-relative">
														<select class="input-control-axa kabupaten"
															name="kabupaten" required>
															<option></option>
															<option value="Lorem Ipsum">kabupaten lorem1</option>
															<option value="Lorem Ipsum 2">kabupaten lorem2</option>
														</select>
													</div>
												</div> -->


											</div>

											<!-- alamat -->
											<div class="alamatdiv">
												<label for="alamat">Alamat Lengkap <span
													class="agency__text-axa-sienna-400 agency__text-xs">*</span>
												</label>
												<div class="input-group-axa input-group-axa--border">
													<textarea class="input-control-axa classInputAddress"
														placeholder="Tulis Alamat Lengkap"
														name="input_alamat_polisholder" required="required"></textarea>
												</div>
											</div>
										</form>
									</div>
								</div>

								<!-- //HERE INSURED FORM LOOP-->
								<div id="container-generate-insured"></div>

								<!-- data tertanggung utama -->
								<!-- <div
									class="panel-cover pt-10level mt-10level px-10level container-form">
									<div class="flex-justify-between align-items-center">
										<h1 class="agency__text-xl agency__font-bold">Data
											Tertanggung Utama</h1>
										<button id="btn__accordion-toggle"
											class="flex-justify-center align-items-center agency__w-10__h-10 agency__bg-axa-blue-400 agency__text-white">
											<i id="accordion-icon"
												class="fas fa-chevron-down agency__text-xs"></i>
										</button>
									</div>
									<div class="pb-2level">

										<div class="display-flex align-items-center">
											<input type="checkbox" id="custom-checkbox"
												class="display-hidden" /> <label for="custom-checkbox-x"
												class="display-flex align-items-center">
												<div
													class="checkbox-container w-4level h-4level agency__border-border-gray-300 agency__rounded-sm display-flex align-items-center agency__justify-center mr-2level position-relative">

													<input type="checkbox"
														class="display-hidden checkbox-input"
														name="insuredIsPolis">

													<svg
														class="checkboxSamePolis display-hidden agency__bg-axa-blue-400 w-4level h-4level agency__text-white position-absolute"
														xmlns="http://www.w3.org/2000/svg" fill="none"
														viewBox="0 0 24 24" stroke="currentColor">
                                                            <path
															stroke-linecap="round" stroke-linejoin="round"
															stroke-width="2" d="M5 13l4 4L19 7" />
                                                        </svg>
												</div> <span class="checkBoxSpanDataSamePolis">Data
													Tertanggung Utama sama dengan data pemegang polis</span>
											</label>
										</div>

									</div>

									child collapse terteanggung utama
									<div id="collapseOne" class="accordion-collapse show">

										<div class="insured-form">

											<div class="ispep">
												<span class="agency__underline"> Apakah pemegang
													polis termasuk ke dalam kategori Orang yang <span
													class="agency__text-axa-sienna-400"> Populer secara
														politisi / <span class="agency__italic">Politically
															Exposed Persons </span> (PEP)
												</span> ?
												</span> <a class="btn--white__step3  ml-2level" href="#"> <span>
														Baca Selengkapnya <i class="fas fa-arrow-right"></i>
												</span>
												</a>

												<div class="radio-group">

													<div>
														<div
															class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
															<input id="no2" class="radio-custom"
																name="input_ispep_insured_0" type="radio" value="0" checked="checked">
															<label for="no2" class="radio-custom-label mb-0"><span>Tidak</span></label>
														</div>
													</div>
													<div>
														<div
															class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
															<input id="yes2" class="radio-custom"
																name="input_ispep_insured_0" type="radio" value="1">
															<label for="yes2" class="radio-custom-label mb-0"><span>Ya
																	<span class="ispepYes">(Data Anda akan kami
																		tinjau untuk melewati persetujuan dari Underwriting)</span>
															</span></label>
														</div>
													</div>

												</div>

											</div>


											<div
												class="form-column display-flex agency__flex-wrap gap-4level">
												<form class="display-flex agency__flex-wrap gap-4level">

													Kolom Kiri
													<div class="agency__flex-1 agency__min-w-300px">

														foto ktp
														<div class="upload-container">
															<label for="name"> Upload Foto KTP / KITAS <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="thumbnail-wrapper">
																<img class="thumbnail img-thumbnail img-fluid "
																	src="/o/mypage-theme/images/ktp-image.png"
																	alt="foto ktp">

																<div class="ml-5level mt-2level">
																	<span class="file-name agency__text-xs"></span>
																	<button type="button"
																		class="uploadButton agency__rounded-4px">Pilih
																		File</button>

																</div>
																<input type="file"
																	class="fileInput input_fotoktp_insured_0 display-hidden"
																	accept="image/*" name="input_fotoktp_insured_0"
																	required="required">
															</div>
														</div>


														name
														<div>
															<label for="name"> Nama lengkap sesuai KTP /
																KITAS <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa classInputName"
																	placeholder="Tulis Nama" name="input_name_insured_0"
																	type="text" required="required">
															</div>
														</div>

														ktppasspor
														<div>
															<label for="ktppasspor"> Nomor Paspor <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis Nomor Paspor"
																	name="input_ktppaspor_insured_0" type="text"
																	maxlength="16" required="required"
																	oninput="handleInput(event)">
															</div>
														</div>

														dob
														<div>
															<label class="display-block" for="dateofbirth">Tanggal
																Lahir <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="calendar-wrapper position-relative"
																id="calendar-wrapper-claim">
																<div class="calendar-col position-relative dob-wrapper">
																	<input
																		class="input-control-axa input-control-axa--outline input-icon-date dob"
																		type="text" name="input_dob_insured_0"
																		autocomplete="off" placeholder="Pilih Tanggal Lahir"
																		readonly="readonly" required="required">
																</div>
															</div>
														</div>

														place
														<div class="place">
															<label for="place"> Tempat Lahir <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa classInputPlaceOfBirth"
																	placeholder="Tulis Tempat Lahir"
																	name="input_pdob_insured_0" type="text"
																	required="required">
															</div>
														</div>

														gender
														<div>
															<label for="gender">Jenis Kelamin <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>

															<div class="form-radio-wrapper display-flex">
																<div class="display-flex gender-container">
																	<div class="form-radio mr-8px">
																		<input class="classInputGenderMale" type="radio" name="input_gender_insured_0"
																			value="M" required="required">
																		<div class="box-radio-wrapper agency__text-center">
																			<div class="box-radio">
																				<img src="/o/mypage-theme/images/man-nb.png"
																					alt="laki">
																			</div>
																			<div class="box-text">Laki-Laki</div>
																		</div>
																	</div>
																	<div class="form-radio">
																		<div class="form-radio-input">
																			<input type="radio" name="input_gender_insured_0"
																				value="F" class="form-control classInputGenderFemale" required="required">
																			<div class="box-radio-wrapper agency__text-center">
																				<div class="box-radio">
																					<img src="/o/mypage-theme/images/woman-nb.png"
																						alt="perempuan">
																				</div>
																				<div class="box-text">Perempuan</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														Kode negara dan telepon
														<div>
															<label for="kode">Kode Negara dan Telepon </label>
															<div id="single-journey-wrapper"
																class="position-relative">
																<select class="input-control-axa kode"
																	name="input_kodenegara_insured_0">

																	Options will be dynamically added by JavaScript
																</select>
															</div>
														</div>

														hp
														<div>
															<label for="hp"> Nomor Handphone <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis Nomor Handphone"
																	name="input_hp_insured_0" type="text" maxlength="15"
																	required="required" oninput="handleInput(event)">
															</div>
														</div>

														provinsi
														<div>
														<label for="provinsi">Provinsi <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa provinsi"
																name="provinsi" required>
																<option></option>
																<option value="Lorem Ipsum">provinsi lorem1</option>
																<option value="Lorem Ipsum 2">provinsi lorem2</option>
															</select>
														</div>
													</div>

														job
														<div>
															<label for="job">Pekerjaan <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div id="single-journey-wrapper"
																class="position-relative job-container">
																<select class="input-control-axa job"
																	name="input_job_insured_0" required>
																	<option></option>
																	<option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option>
																	<option value="Karyawan Swasta">Karyawan
																		Swasta</option>
																	<option value="TNI/POLRI">TNI/POLRI</option>
																	<option value="PNS">PNS</option>
																	<option value="Ibu Rumah Tangga">Ibu Rumah
																		Tangga</option>
																	<option value="Wiraswasta">Wiraswasta</option>
																	<option value="Lainnya">Lainnya</option>
																</select>
															</div>
														</div>

													</div>

													Kolom Kanan
													<div class="agency__flex-1 agency__min-w-300px">
													
														Negara
														<div class="passpordiv">
															<label for="negara">Kewarganegaraan <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div id="single-journey-wrapper"
																class="position-relative negara-container">
																<select class="input-control-axa negara"
																	name="input_negara_insured_0" required>

																	Options will be dynamically added by JavaScript
																</select>
															</div>
														</div>
													
														passpor
														<div>
															<label for="ktppaspor"> Nomor KTP / KITAS <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa classInputKtpKitas"
																	placeholder="Tulis No. KTP / KITAS"
																	name="input_ktpkitas_insured_0" type="text"
																	maxlength="16" required="required"
																	oninput="handleInput(event)">
															</div>
														</div>

														age
														<div>
															<label for="age"> Usia </label>
															<div
																class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome">
																<input disabled="disabled" class="input-control-axa age"
																	placeholder="0" name="input_age_insured_0" type="text">
																<span class="font_tahun">Tahun</span>
															</div>
														</div>

														hubungan
														<div>
															<label for="relationship">Hubungan <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div id="single-journey-wrapper"
																class="position-relative relationship-container">
																<select class="input-control-axa relationship"
																	name="input_relationship_insured_0" required>
																	<option></option>
																	<option value="Tertanggung Utama" selected="selected">Tertanggung
																		Utama</option>
																	<option value="Kerabat">Kerabat</option>
																	<option value="Teman">Teman</option>
																</select>
															</div>
														</div>


														status kawin
														<div>
															<label for="status-kawin">Status Perkawinan <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div id="single-journey-wrapper"
																class="position-relative status-kawin-container">
																<select class="input-control-axa status-kawin"
																	name="input_status-kawin_insured_0" required>
																	<option></option>
																	<option value="Belum Menikah">Belum Menikah</option>
																	<option value="Sudah Menikah">Sudah Menikah</option>
																</select>
															</div>
														</div>

														telepon
														<div class="telepondiv">
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis Nomor Telepon"
																	name="input_telepon_insured_0" type="text">
															</div>
														</div>

														email
														<div>
															<label for="email">Email <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis email" name="input_email_insured_0"
																	type="text" required="required">
															</div>
														</div>

														kode pos
														<div>
															<label for="kodepos">Kode Pos <span
																class="agency__text-axa-sienna-400 agency__text-xs">*</span>
															</label>
															<div class="input-group-axa input-group-axa--border">
																<input class="input-control-axa"
																	placeholder="Tulis Kode Pos"
																	name="input_kodepos_insured_0" type="text"
																	required="required">
															</div>
														</div>

														kab
														<div>
														<label for="kabupaten">Kabupaten/Kota <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa kabupaten"
																name="kabupaten" required>
																<option></option>
																<option value="Lorem Ipsum">kabupaten lorem1</option>
																<option value="Lorem Ipsum 2">kabupaten lorem2</option>
															</select>
														</div>
													</div>


													</div>

													alamat
													<div class="alamatdiv">
														<label for="alamat">Alamat Lengkap <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<textarea class="input-control-axa classInputAddress"
																placeholder="Tulis Alamat Lengkap"
																name="input_alamat_insured_0" required="required"></textarea>
														</div>
													</div>
												</form>
											</div>
										</div>

									</div>

								</div> -->

								<!-- TEST DUPLICATE -->

								<!-- <div class="panel-cover pt-10level mt-10level px-10level">

									<h1>Data Tertanggung 2</h1>

									<div class="insured-form">

										<div class="ispep">
											<span class="agency__underline"> Apakah pemegang polis
												termasuk ke dalam kategori Orang yang <span
												class="agency__text-axa-sienna-400"> Populer secara
													politisi / <span class="agency__italic">Politically
														Exposed Persons </span> (PEP)
											</span> ?
											</span> <a class="btn--white__step3  ml-2level" href="#"> <span>
													Baca Selengkapnya <i class="fas fa-arrow-right"></i>
											</span>
											</a>

											<div class="radio-group">

												<div>
													<div
														class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
														<input id="no3" class="radio-custom"
															name="input_ispep_insured_1" type="radio" value="0"> <label
															for="no3" class="radio-custom-label mb-0"><span>Tidak</span></label>
													</div>
												</div>
												<div>
													<div
														class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
														<input id="yes3" class="radio-custom"
															name="input_ispep_insured_1" type="radio" value="1"> <label
															for="yes3" class="radio-custom-label mb-0"><span>Ya
																<span class="ispepYes">(Data Anda akan kami
																	tinjau untuk melewati persetujuan dari Underwriting)</span>
														</span></label>
													</div>
												</div>
											</div>
										</div>


										<div
											class="form-column display-flex agency__flex-wrap gap-4level">
											<form class="display-flex agency__flex-wrap gap-4level">

												Kolom Kiri
												<div class="agency__flex-1 agency__min-w-300px">

													foto ktp
													<div class="upload-container">
														<label for="name"> Upload Foto KTP / Paspor <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="thumbnail-wrapper">
															<img
																class="thumbnail img-thumbnail img-fluid "
																src="/o/mypage-theme/images/ktp-image.png"
																alt="foto ktp">

															<div class="ml-5level mt-2level">
																<span class="file-name agency__text-xs"></span>
																<button type="button" class="uploadButton">Pilih
																	File</button>

															</div>
															<input type="file"
																class="fileInput input_fotoktp_insured_1 display-hidden"
																accept="image/*" name="input_fotoktp_insured_1">
														</div>
													</div>


													name
													<div>
														<label for="name"> Nama lengkap sesuai KTP /
															Paspor <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa" placeholder="Tulis Nama"
																name="input_name_insured_1" type="text">
														</div>
													</div>

													ktppasspor
													<div>
														<label for="ktppasspor"> Nomor KTP / Paspor <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Nomor Paspor"
																name="input_ktppaspor_insured_1" type="text">
														</div>
													</div>

													dob
													<div>
														<label class="display-block" for="dateofbirth">Tanggal
															Lahir <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="calendar-wrapper position-relative"
															id="calendar-wrapper-claim">
															<div class="calendar-col position-relative dob-wrapper">
																<input
																	class="input-control-axa input-control-axa--outline input-icon-date dob"
																	type="text" name="input_dob_insured_1"
																	autocomplete="off" placeholder="Pilih Tanggal Lahir"
																	readonly="readonly">
															</div>
														</div>
													</div>

													place
													<div class="place">
														<label for="place"> Tempat Lahir <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Tempat Lahir"
																name="input_pdob_insured_1" type="text">
														</div>
													</div>

													gender
													<div>
														<label for="gender">Jenis Kelamin <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>

														<div
															class="form-radio-wrapper display-flex agency__space-x-4">
															<div class="form-radio">
																<input type="radio" name="input_gender_insured_1"
																	value="M">
																<div class="box-radio-wrapper agency__text-center">
																	<div class="box-radio">
																		<img src="/o/mypage-theme/images/man-nb.png"
																			alt="laki">
																	</div>
																	<div class="box-text">Laki-Laki</div>
																</div>
															</div>
															<div class="form-radio">
																<div class="form-radio-input">
																	<input type="radio" name="input_gender_insured_1"
																		value="F" class="form-control">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/woman-nb.png"
																				alt="perempuan">
																		</div>
																		<div class="box-text">Perempuan</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													Kode negara dan telepon
													<div>
														<label for="kode">Kode Negara dan Telepon </label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa kode"
																name="input_kodenegara_insured_1" required>
																
																Options will be dynamically added by JavaScript
																
															</select>
														</div>
													</div>

													hp
													<div>
														<label for="hp"> Nomor Handphone <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Nomor Handphone"
																name="input_hp_insured_1" type="number">
														</div>
													</div>

													Negara
													<div>
														<label for="negara">Kewarganegaraan <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa negara"
																name="input_negara_insured_1" required>
																
																Options will be dynamically added by JavaScript
															</select>
														</div>
													</div>

													job
													<div>
														<label for="job">Pekerjaan <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa job"
																name="input_job_insured_1" required>
																<option></option>
																<option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option>
																<option value="Karyawan Swasta">Karyawan Swasta</option>
																<option value="TNI/POLRI">TNI/POLRI</option>
																<option value="PNS">PNS</option>
																<option value="Ibu Rumah Tangga">Ibu Rumah
																	Tangga</option>
																<option value="Wiraswasta">Wiraswasta</option>
																<option value="Lainnya">Lainnya</option>
															</select>
														</div>
													</div>

												</div>

												Kolom Kanan
												<div class="agency__flex-1 agency__min-w-300px">
													passpor
													<div class="passpordiv">
														<label for="ktppaspor"> Nomor KTP / KITAS <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis No. KTP / KITAS"
																name="input_ktpkitas_insured_1" type="text">
														</div>
													</div>

													age
													<div class="mt-150px">
														<label for="age"> Usia </label>
														<div
															class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome">
															<input disabled="disabled" class="input-control-axa age"
																placeholder="0" name="input_age_insured_1" type="text">
															<span class="font_tahun">Tahun</span>
														</div>
													</div>

													hubungan
													<div>
														<label for="relationship">Hubungan <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa relationship"
																name="input_relationship_insured_1" required>
																<option></option>
																<option value="Tertanggung Utama">Tertanggung Utama</option>
																<option value="Kerabat">Kerabat</option>
															</select>
														</div>
													</div>


													status kawin
													<div>
														<label for="status-kawin">Status Perkawinan <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div id="single-journey-wrapper" class="position-relative">
															<select class="input-control-axa status-kawin"
																name="input_status-kawin_insured_1" required>
																<option></option>
																<option value="Belum Menikah">Belum Menikah</option>
																<option value="Sudah Menikah">Sudah Menikah</option>
															</select>
														</div>
													</div>

													telepon
													<div class="telepondiv">
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Nomor Telepon"
																name="input_telepon_insured_1" type="text">
														</div>
													</div>

													email
													<div>
														<label for="email">Email <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis email" name="input_email_insured_1"
																type="text">
														</div>
													</div>

													kode pos
													<div>
														<label for="kodepos">Kode Pos <span
															class="agency__text-axa-sienna-400 agency__text-xs">*</span>
														</label>
														<div class="input-group-axa input-group-axa--border">
															<input class="input-control-axa"
																placeholder="Tulis Kode Pos"
																name="input_kodepos_insured_1" type="text">
														</div>
													</div>

												</div>

												alamat
												<div class="alamatdiv">
													<label for="alamat">Alamat Lengkap <span
														class="agency__text-axa-sienna-400 agency__text-xs">*</span>
													</label>
													<div class="input-group-axa input-group-axa--border">
														<textarea class="input-control-axa"
															placeholder="Tulis Alamat Lengkap"
															name="input_alamat_insured_1"></textarea>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div> -->


							</section>
						</div>

						<div class="col-tabstep2">
							<!-- <div class="panel-cover py-5level">
								<h3>Perjalanan International</h3>
								<h1>Plan Spesial Asia</h1>
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
							</div> -->

							<!-- <div class="panel-cover py-5level">
								<h3>Perjalanan Domestik</h3>
								<h1>Plan Gold</h1>
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
							</div> -->

							<!-- render html here -->
							<div class="container_sideplan"></div>


							<div class="panel-cover py-3level">
								<div class="sticky-collapse-promo">
									<div class="sticky-collapse-promo-step2">
										<div class="col">
											<label for="kode-promo">Kode Promo</label>
											<div
												class="input-group-axa input-group-axa--border input-group-step2">
												<input class="input-control-axa promo-code" id="promo-code"
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

								<!-- <div class="mt-5level">
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
								</div> -->

								<!-- render here -->
								<div class="container_sidepanel_discount"></div>


								<div class="mt-5level agency__text-center divbutton-submit">
									<a class="btn__submit btn__agency btn--dark-blue width-full">
										<span
										class="position-relative agency__uppercase agency__pointer">Lanjut
											ke Persetujuan <i class="fas fa-arrow-right"></i>
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

<script>



//var kycURL = window.kycURL;
//var ocrURL = window.ocrURL;
//var link = window.link;

let base64Result = null;

const indonesianMonths = {
    'January': 'Jan',
    'February': 'Feb',
    'March': 'Mar',
    'April': 'Apr',
    'May': 'Mei',
    'June': 'Jun',
    'July': 'Jul',
    'August': 'Agu',
    'September': 'Sep',
    'October': 'Okt',
    'November': 'Nov',
    'December': 'Des'
};


//get main benefit premi
var totalMainBenefitPremium, totalMainBenefitPremiumInIDR;
var totalAdditionalBenefitPremium, totalAdditionalBenefitPremiumInIDR;

const calculation = JSON.parse(sessionStorage.getItem("SmartTravelInternationalCalculation"));

if (sessionStorage.getItem(_smartTravelInternationalCalculation)) {
    let formDetail = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    let choosenPlan = formDetail.ChoosenPlan;

    let calculation = JSON.parse(sessionStorage.getItem(_smartTravelInternationalCalculation));

    for (const plan of calculation.AvailablePlans) {
        if (plan.PlanName === choosenPlan) {

            //get main total
            totalMainBenefitPremium = plan.TotalMainBenefitPremium;
            totalMainBenefitPremiumInIDR = plan.TotalMainBenefitPremiumInIDR;

            //get additional total
            totalAdditionalBenefitPremium = plan.TotalAdditionalBenefitPremium;
            totalAdditionalBenefitPremiumInIDR = plan.TotalAdditionalBenefitPremiumInIDR;

            console.log(totalMainBenefitPremium);
            console.log(totalMainBenefitPremiumInIDR);

            console.log(totalAdditionalBenefitPremium);
            console.log(totalAdditionalBenefitPremiumInIDR);

        }
    }
}

//Mendapatkan data dari sessionStorage
const formDetail = JSON.parse(sessionStorage.getItem("SmartTravelInternationalFormDetail"));

// Memastikan data ada sebelum mengakses properti
let token = null;
let totalInsured = 0;
let totalAdult = 0;
let totalChild = 0;
let travellerType = null;
if (formDetail) {
    token = formDetail.Token;
    console.log("Token:", token);

    totalAdult = parseInt(formDetail.AdultTotal, 10) || 0; // Ensure it's an integer
    console.log("Adult:", totalAdult);

    totalChild = parseInt(formDetail.ChildTotal, 10) || 0; // Ensure it's an integer
    console.log("Child:", totalChild);

    totalInsured = totalAdult + totalChild;
    console.log("Total Insured:", totalInsured);


    travellerType = formDetail.TravellerType;
    console.log('travellerType>>', travellerType);


    //render sideplan
    let totalPremiJaminan = totalMainBenefitPremium + totalAdditionalBenefitPremium;
    renderSidePanelPlanFromFormDetail(formDetail, totalPremiJaminan);

    //render sidepanel discount
    renderDiscountTable(formDetail, totalPremiJaminan);
} else {
    console.error("Data 'SmartTravelInternationalFormDetail' tidak ditemukan di sessionStorage.");
}

//Function to render sidepanelplan for formDetail data
function renderSidePanelPlanFromFormDetail(formDetail, totalJaminanPremi) {
    // Container where the HTML will be appended
    const container = document.querySelector(".container_sideplan"); // Make sure you have a parent element with this class

    // Clear any existing content in the container
    container.innerHTML = "";

    // Create the main wrapper div
    const secondProductDiv = document.createElement("div");
    secondProductDiv.className = "panel-cover py-5level second-product";

    // Create the description div
    const descriptionDiv = document.createElement("div");
    descriptionDiv.className = "description";

    // Create and append the span elements
    const travelTypeSpan = document.createElement("span");
    travelTypeSpan.textContent = "Perjalanan " + formDetail.TravelType;
    descriptionDiv.appendChild(travelTypeSpan);

    const planH1 = document.createElement("h1");
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
    //set total jaminan
    costTd.textContent = formDetail.Currency.toUpperCase() + " " + (calculation.Currency === 'IDR' ? formatToIDR(totalJaminanPremi) : formatCurrencyBasic(totalJaminanPremi));
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
    policyCostTd.textContent = formDetail.Currency.toUpperCase() + " " + (calculation.Currency === 'IDR' ? formatToIDR(calculation.PolicyCost) : formatCurrencyBasic(calculation.PolicyCost));
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
    stampCostTd.textContent = formDetail.Currency.toUpperCase() + " " + (calculation.Currency === 'IDR' ? formatToIDR(calculation.Stamp) : formatCurrencyBasic(calculation.Stamp));
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
    //set total premi
    tdTotalPremiValue.textContent = _currency + " " + (calculation.Currency === 'IDR' ? formatToIDR(_totalPremi) : formatCurrencyBasic(_totalPremi));



    row2.appendChild(tdTotalPremi);
    row2.appendChild(tdTotalPremiValue);
    tbody.appendChild(row2);

    // Append tbody to table and table to wrapperDiv
    table.appendChild(tbody);
    wrapperDiv.appendChild(table);

    // Append the main div to the container
    container.appendChild(wrapperDiv);
}


function formatCurrencyBasic(value) {
    return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
}

function formatToIDR(value) {
    return value.toLocaleString('id-ID', {
        minimumFractionDigits: 2,
        maximumFractionDigits: 2
    });
}


//OCR
async function handleFileChange(fileInput) {

    console.log('testt handleFileChange');
    const file_foto = await collectDataFoto(fileInput);

    // Create the payload
    const payload = {
        dataCategory: "ocr",
        _fotoBase64: file_foto._fotoktp, // Base64 string
        _fileName: file_foto._fileName // File name
    };

    console.log('Payload ready to send:', payload);

    $.ajax({
        /* type: "POST",
        url: loadDataStep3OCR_URL,
        data: payload,
        timeout: 120000,
        dataType: "json", */

        type: "POST",
        url: ocrURL,
        data: JSON.stringify(payload),
        contentType: "application/json",

        success: function (response) {
            console.log('Success get response:', response.response);

            // Check if the response does not contain the error
            if (response.response.status === "SUCCESS") {
                updateNearestFields(fileInput, response);
            } else if (response.response.status === "FILE_INVALID_FORMAT") {
                fileInput.value = ''; // Kosongkan input file
                alert(response.response.reason);
            } else {
                console.error('Error >> ', response.response.error);
            }

        },
        error: function (error) {
            console.log('Error:', error);
        }
    });

}

async function collectDataFoto(fileInput) {
    console.log('collectDataFoto');

    const data = {
        _fotoktp: '',
        _fileName: ''
    };

    if (fileInput && fileInput.files.length > 0) {
        data._fotoktp = await getBase64(fileInput.files[0]);
        data._fileName = fileInput.files[0].name;
    }

    return data;
}


//Fungsi untuk memperbarui field input terdekat dengan hasil response
function updateNearestFields(fileInput, response) {
    console.log('updateNearestFields.......>>', response.response);

    var dataRead = response.response.read; // response.response.read.(nama, alamat, etc)

    // Temukan container-form terdekat
    const container = fileInput.closest('.container-form');

    // Update nilai field terdekat
    if (container) {
        const nameInput = container.querySelector('.classInputName');
        const addressInput = container.querySelector('.classInputAddress');
        const placeBirth = container.querySelector('.classInputPlaceOfBirth');
        const ktpKitas = container.querySelector('.classInputKtpKitas');

        // Update name
        if (dataRead.nama && dataRead.nama.confidence > 70 && nameInput) {
            nameInput.value = dataRead.nama.value;
        }

        // Update address
        if (dataRead.alamat && dataRead.alamat.confidence > 70 && addressInput) {
            let alamat = dataRead.alamat ? dataRead.alamat.value : '';
            let rtRw = (dataRead.rtRw && dataRead.rtRw.confidence > 70 ? 'RT ' + dataRead.rtRw.value.split('/')[0] + ' RW ' + dataRead.rtRw.value.split('/')[1] : '');
            let kelDesa = (dataRead.kelurahanDesa && dataRead.kelurahanDesa.confidence > 70 ? 'Kelurahan ' + dataRead.kelurahanDesa.value : '');
            let kec = (dataRead.kecamatan && dataRead.kecamatan.confidence > 70 ? 'Kecamatan ' + dataRead.kecamatan.value : '');
            let kotaKab = (dataRead.kotaKabupaten && dataRead.kotaKabupaten.confidence > 70 ? dataRead.kotaKabupaten.value : '');
            let prov = (dataRead.provinsi && dataRead.provinsi.confidence > 70 ? dataRead.provinsi.value : '');

            let fullAddress = alamat + ', ' + rtRw + ', ' + kelDesa + ', ' + kec + ', ' + kotaKab + ', ' + prov;
            addressInput.value = fullAddress.replace(/ ,/g, ''); // Remove any extra commas if any part is missing
        }

        // Update birth place
        if (dataRead.tempatLahir && dataRead.tempatLahir.confidence > 70 && placeBirth) {
            placeBirth.value = dataRead.tempatLahir.value;
        }

        // Update KTP/KITAS number
        if (dataRead.nik && dataRead.nik.confidence > 70 && ktpKitas) {
            ktpKitas.value = dataRead.nik.value;
        }

        // Update kewarganegaraan (negara)
        /* let kewarganegaraan = dataRead.kewarganegaraan && dataRead.kewarganegaraan.confidence > 70 ? dataRead.kewarganegaraan.value : '';
        const select2Kewarganegaraan = container.querySelector('.negara');
        if (select2Kewarganegaraan) {
            if (kewarganegaraan === "WNI") {
                $(select2Kewarganegaraan).val('Indonesia').trigger('change');
            }
        } */

        // Update status perkawinan
        let statusKawin = dataRead.statusPerkawinan && dataRead.statusPerkawinan.confidence > 70 ? dataRead.statusPerkawinan.value : '';
        const select2statusKawin = container.querySelector('.status-kawin');
        if (select2statusKawin) {
            if (statusKawin === "BELUM KAWIN") {
                $(select2statusKawin).val('Belum Menikah').trigger('change');
            } else {
                $(select2statusKawin).val('Sudah Menikah').trigger('change');
            }
        }

        // Update pekerjaan (job)
        let job = dataRead.pekerjaan && dataRead.pekerjaan.confidence > 70 ? dataRead.pekerjaan.value : '';
        const select2Job = container.querySelector('.job');
        if (select2Job) {
            $(select2Job).val(job).trigger('change');
        }

        // Update gender
        const maleRadio = container.querySelector('.classInputGenderMale');
        const femaleRadio = container.querySelector('.classInputGenderFemale');

        if (dataRead.jenisKelamin && dataRead.jenisKelamin.confidence > 70) {
            if (dataRead.jenisKelamin.value === "LAKI-LAKI") {
                maleRadio.checked = true;
            } else {
                femaleRadio.checked = true;
            }
        }

        // Update tanggal lahir
        var dateofbirth = dataRead.tanggalLahir && dataRead.tanggalLahir.confidence > 70 ? dataRead.tanggalLahir.value : '';
        var formattedDOB = dateofbirth.replace(/-/g, "/"); // Format - to /

        if (dateofbirth) {
            const formattedDOBToSet = moment(formattedDOB, "DD/MM/YYYY");
            const day = formattedDOBToSet.format('DD');
            const englishMonth = formattedDOBToSet.format('MMMM');
            const year = formattedDOBToSet.format('YYYY');
            const indonesianMonth = indonesianMonths[englishMonth];

            const formattedDate = day + '/' + indonesianMonth + '/' + year;

            const dobInputClosest = container.querySelector('.dob');
            if (dobInputClosest) {
                dobInputClosest.value = formattedDate;
                initDatepickerFromScan(dobInputClosest, formattedDOBToSet);
            }

            // Calculate age
            const birthDate = moment(formattedDOB, "DD/MM/YYYY");
            const today = moment();
            let age = today.diff(birthDate, 'years');

            const ageInputClosest = container.querySelector('.age');
            if (ageInputClosest) {
                ageInputClosest.value = age;
            }
        }
    }
}


$('.btn__submit').on('click', function () {
    console.log('EXECUTE HERE!!!! to>>' + kycURL);

    const requiredFields = document.querySelectorAll('.container-form [required]');
    let isValid = true;

    requiredFields.forEach(function (field) {
        // Cek apakah field adalah radio buttons
        if (field.type === 'radio') {
            const name = field.name;
            const selectedRadio = document.querySelector('input[name="' + name + '"]:checked');

            if (!selectedRadio) {
                field.classList.add('invalid');
                isValid = false;

                // Menandai kelas invalid pada kontainer radio
                const radioContainer = field.closest('.gender-container');
                if (radioContainer) {
                    radioContainer.classList.add('invalid');
                }
            } else {
                // Jika ada radio yang dipilih, hapus kelas invalid
                field.classList.remove('invalid');
                const radioContainer = field.closest('.gender-container');
                if (radioContainer) {
                    radioContainer.classList.remove('invalid');
                }
            }
            //return;
        }

        // Validasi untuk input lainnya
        if (!field.value.trim()) {
            field.classList.add('invalid');
            isValid = false;

            // Cek jika field adalah fileInput
            if (field.classList.contains('fileInput')) {
                const containerTarget = field.closest('div').querySelector('.thumbnail');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah dob
            if (field.classList.contains('dob')) {
                const containerTarget = field.closest('.dob-wrapper');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah marital status
            if (field.classList.contains('status-kawin')) {
                const containerTarget = field.closest('.status-kawin-container');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah nationality
            if (field.classList.contains('negara')) {
                const containerTarget = field.closest('.negara-container');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah job
            if (field.classList.contains('job')) {
                const containerTarget = field.closest('.job-container');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }

            // Cek jika field adalah relation
            if (field.classList.contains('relationship')) {
                const containerTarget = field.closest('.relationship-container');
                if (containerTarget) {
                    containerTarget.classList.add('invalid');
                }
            }
        } else {
            // remove class 
            field.classList.remove('invalid');

            // Cek jika field adalah fileInput
            if (field.classList.contains('fileInput')) {
                const thumbnail = field.closest('div').querySelector('.thumbnail');
                if (thumbnail) {
                    thumbnail.classList.remove('invalid');
                }
            }

            // Jika field adalah dob, hapus invalid dari dob-wrapper
            if (field.classList.contains('dob')) {
                const dobWrapper = field.closest('.dob-wrapper');
                if (dobWrapper) {
                    dobWrapper.classList.remove('invalid');
                }
            }

            // Cek jika field adalah marital status
            if (field.classList.contains('status-kawin')) {
                const containerTarget = field.closest('.status-kawin-container');
                if (containerTarget) {
                    containerTarget.classList.remove('invalid');
                }
            }

            // Cek jika field adalah nationality
            if (field.classList.contains('negara')) {
                const containerTarget = field.closest('.negara-container');
                if (containerTarget) {
                    containerTarget.classList.remove('invalid');
                }
            }

            // Cek jika field adalah job
            if (field.classList.contains('job')) {
                const containerTarget = field.closest('.job-container');
                if (containerTarget) {
                    containerTarget.classList.remove('invalid');
                }
            }

            // Cek jika field adalah relation
            if (field.classList.contains('relationship')) {
                const containerTarget = field.closest('.relationship-container');
                if (containerTarget) {
                    containerTarget.classList.remove('invalid');
                }
            }
        }
    });

    console.log('is valid', isValid);

    if (isValid) {
        //alert('ready submitted successfully!');
        preparePayload();
    }
});


// Helper function to extract input values
function getValue(selector) {
    console.log('getValue>>' + selector);
    const element = document.querySelector(selector);
    return element ? element.value : '';
}

// Helper function to extract checked radio/checkbox values
function getCheckedValue(selector) {
    console.log('getCheckedValue>>' + selector);
    const element = document.querySelector(selector + ':checked');
    return element ? element.value : '';
}

// Convert image to Base64
function getBase64(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.onload = () => resolve(reader.result);
        reader.onerror = reject;
        reader.readAsDataURL(file);
    });
}

async function preparePayload() {
    console.log('call preparePayload!!');

    //check if insured is polis
    const checkbox = document.querySelector('input[type="checkbox"][name="insuredIsPolis"]');
    const isChecked = checkbox ? checkbox.checked : false;

    const promoCode = $('#promo-code').val();


    // Collect policyholder data
    const policyholderData = await collectData('polisholder');

    // Collect insured data (with additional relationship field)
    const insuredDataList = [];
    const insuredCount = document.querySelectorAll('.insured-form').length; // Or any dynamic count you have

    console.log('total tertanggung>>' + insuredCount);

    for (let i = 0; i < insuredCount; i++) {
        // Collect data for each insured
        const insuredData = await collectData('insured', i);

        // Construct the selector for the relationship field
        const relationshipSelector = 'select[name="input_relationship_insured_' + i + '"]';
        insuredData._relationship = getValue(relationshipSelector);

        // Add collected data to the list
        insuredDataList.push(insuredData);
    }

    // Combine policyholder data and insured data into one payload
    const payload = {
        policyholder: policyholderData,
        insured: insuredDataList,
        insuredIsPolis: isChecked,
        promoCode,
        token: token
    };

    console.log('Payload ready to send:', payload);

    // Send payload as JSON via AJAX
    $.ajax({
        type: "POST",
        url: kycURL,
        data: JSON.stringify(payload),
        contentType: "application/json",
        success: function (response) {
            console.log('Success:', response);

            // Save payload to session storage
            sessionStorage.setItem('SmartTravelInternationalDataPayload', JSON.stringify(payload));

            //redirect to next step
            window.location.href = link;
        },
        error: function (error) {
            console.log('Error:', error);
        }
    });
}

//Helper function to collect form data based on a type (policyholder or insured) and an index for insured persons
async function collectData(type, index = null) {

    // If an index is provided (for insured data), append it to field selectors
    const indexSuffix = index !== null ? '_' + index : '';

    const data = {
        _ispep: getCheckedValue('input[name="input_ispep_' + type + indexSuffix + '"]'),
        _fotoktp: '',
        _name: getValue('input[name="input_name_' + type + indexSuffix + '"]'),
        _ktppaspor: getValue('input[name="input_ktppaspor_' + type + indexSuffix + '"]'),
        _dob: getValue('input[name="input_dob_' + type + indexSuffix + '"]'),
        _pdob: getValue('input[name="input_pdob_' + type + indexSuffix + '"]'),
        _gender: getCheckedValue('input[name="input_gender_' + type + indexSuffix + '"]'),
        _kodenegara: getValue('select[name="input_kodenegara_' + type + indexSuffix + '"]'),
        _hp: getValue('input[name="input_hp_' + type + indexSuffix + '"]'),
        _negara: getValue('select[name="input_negara_' + type + indexSuffix + '"]'),
        _job: getValue('select[name="input_job_' + type + indexSuffix + '"]'),
        _ktpkitas: getValue('input[name="input_ktpkitas_' + type + indexSuffix + '"]'),
        _age: getValue('input[name="input_age_' + type + indexSuffix + '"]'),
        _statuskawin: getValue('select[name="input_status-kawin_' + type + indexSuffix + '"]'),
        _telepon: getValue('input[name="input_telepon_' + type + indexSuffix + '"]'),
        _email: getValue('input[name="input_email_' + type + indexSuffix + '"]'),
        _kodepos: getValue('input[name="input_kodepos_' + type + indexSuffix + '"]'),
        _alamat: getValue('textarea[name="input_alamat_' + type + indexSuffix + '"]')
    };

    // Handle image conversion (if applicable)
    const fileInput = document.querySelector('input[name="input_fotoktp_' + type + indexSuffix + '"]');
    if (fileInput && fileInput.files.length > 0) {
        base64Result = await getBase64(fileInput.files[0]);
        data._fotoktp = base64Result;
    }

    return data;
}


function initDatepickerFromScan(inputClass, date) {
    console.log('call initial datepicker scan');
    $(inputClass).daterangepicker({
        parentEl: ".dob-wrapper",
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        startDate: date,
        maxDate: moment(),
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        locale: {
            applyLabel: 'Pilih',
            cancelLabel: 'Batal',
            "daysOfWeek": [
                "Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"
            ],
            "monthNames": [
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            ],
        }
    });
}

document.addEventListener('DOMContentLoaded', function () {

    /* delete bg-white default liferay */

    var contentSection = document.getElementById('content');
    if (contentSection) {
        contentSection.classList.remove('bg-white');
    }

});


$(document).ready(function () {

    console.log('total data insured to generate>>', totalInsured);
    console.log('type travller>>', travellerType);
    console.log('total adult>>', totalAdult);

    //call render form insured
    renderInsuredForm(totalInsured, travellerType, totalAdult);

    //negara
    fetch('https://restcountries.com/v3.1/all')
        .then(response => response.json())
        .then(data => {
            const select = $('.negara');

            // Clear existing options (if any)
            select.empty();

            // Add placeholder option
            select.append('<option></option>');

            // Append country options
            data.forEach(function (country) {
                select.append('<option value="' + country.name.common + '">' + country.name.common + '</option>');
            });

            // Initialize Select2 after populating the options
            $('.negara').select2({
                dropdownParent: '#single-journey-wrapper',
                placeholder: "Pilih Negara",
                width: '100%',
                minimumResultsForSearch: 0
            });
        })
        .catch(error => {
            console.error('Error fetching country data:', error);
        });



    //kode negara
    fetch('https://restcountries.com/v3.1/all')
        .then(response => response.json())
        .then(data => {
            const select = $('.kode');

            // Clear existing options (if any)
            select.empty();

            // Add placeholder option
            select.append('<option></option>');

            // Append country code options (calling code + country name)
            data.forEach(function (country) {
                const callingCode = country.idd.root + (country.idd.suffixes ? country.idd.suffixes[0] : '');
                select.append('<option value="' + callingCode + '">' + callingCode + ' (' + country.name.common + ')</option>');
            });

            // Initialize Select2 after populating the options
            $('.kode').select2({
                dropdownParent: '#single-journey-wrapper',
                placeholder: "Pilih Kode Negara",
                width: '100%',
                minimumResultsForSearch: 0
            });
        })
        .catch(error => {
            console.error('Error fetching country data:', error);
        });

    $('.job').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Pekerjaan",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('.relationship').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Hubungan",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('.status-kawin').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Status Perkawinan",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('.provinsi').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Provinsi",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('.kabupaten').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Kabupaten/Kota",
        width: '100%',
        minimumResultsForSearch: -1
    });


    // start dob datepicker
    $('.dob').daterangepicker({
        parentEl: ".dob-wrapper",
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        maxDate: moment(),
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        locale: {
            applyLabel: 'Pilih',
            cancelLabel: 'Batal',
            "daysOfWeek": [
                "Min",
                "Sen",
                "Sel",
                "Rab",
                "Kam",
                "Jum",
                "Sab",
            ],
            "monthNames": [
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember"
            ],
        }
    });

    $('.dob').on('apply.daterangepicker', function (ev, picker) {

        console.log('test apply date');

        // Ambil hari, bulan, dan tahun
        const day = picker.startDate.format('DD');
        const englishMonth = picker.startDate.format('MMMM');
        const year = picker.startDate.format('YYYY');
        const indonesianMonth = indonesianMonths[englishMonth];

        // Format tanggal tanpa menggunakan backtick
        const formattedDate = day + '/' + indonesianMonth + '/' + year;

        $(this).val(formattedDate);

        const birthDate = picker.startDate;
        const today = moment();
        let age = today.diff(birthDate, 'years');
        const monthDiff = today.diff(birthDate, 'months') % 12;

        if (monthDiff < 0 || (monthDiff === 0 && today.date() < birthDate.date())) {
            age--;
        }

        // Cari input age yang terdekat dalam div dengan class 'panel-cover'
        $(this).closest('.panel-cover').find('.age').val(age);
    });

    $('.dob').on('cancel.daterangepicker', function (ev, picker) {
        $(this).val('');
        // Kosongkan input age yang terdekat dalam div dengan class 'panel-cover'
        $(this).closest('.panel-cover').find('.age').val('');
    });



    //detect button upload
    //Image upload
    document.querySelectorAll('.uploadButton').forEach(button => {
        console.log('');
        button.addEventListener('click', function () {
            this.closest('.thumbnail-wrapper').querySelector('.fileInput').click();
        });
    });

    document.querySelectorAll('.fileInput').forEach(input => {
        input.addEventListener('change', function (event) {

            // Panggil handleFileChange saat file di-upload
            //handleFileChange(this); //this bawa fileInput

            const containerForm = input.closest('.container-form');
            const negaraElement = containerForm.querySelector('.negara');
            console.log(negaraElement.value);
            if (negaraElement && negaraElement.value === "") {
                // Alert user to select a country
                alert('Harap pilih kewarganegaraan terlebih dahulu.');
                return; // Exit the function early
            }
            if (negaraElement && negaraElement.value.toUpperCase() === "INDONESIA") {
                console.log('WNI call scan ocr');
                handleFileChange(this); // this refers to fileInput
            }

            //manipulate name file
            const file = event.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    const wrapper = input.closest('.thumbnail-wrapper');
                    wrapper.querySelector('.thumbnail').src = e.target.result;

                    // Update file name span
                    const fileNameSpan = wrapper.querySelector('.file-name');
                    let fileName = file.name;

                    if (fileName.length > 70) {
                        // Only keep the last 50 characters and prepend "..."
                        fileName = "..." + fileName.slice(-50);

                        let formattedName = '';
                        for (let i = 0; i < fileName.length; i += 20) {
                            formattedName += fileName.slice(i, i + 20) + "\n";
                        }
                        fileName = formattedName.trim(); // Remove the last newline

                        fileName = formattedName.trim();
                    }


                    fileNameSpan.textContent = fileName;
                }
                reader.readAsDataURL(file);
            }
        });
    });



    $('#btn__accordion-toggle').on('click', function () {
        const content = $('#collapseOne');
        const icon = $('#accordion-icon');
        if (content.hasClass('show')) {
            // Jika konten sudah ditampilkan, sembunyikan dan ubah ikon
            content.removeClass('show');
            icon.removeClass('fa-chevron-up').addClass('fa-chevron-down');
        } else {
            // Jika konten belum ditampilkan, tampilkan dan ubah ikon
            content.addClass('show');
            icon.removeClass('fa-chevron-down').addClass('fa-chevron-up');
        }
    });



    $('.checkbox-container').on('click', function () {
        console.log('check CHECKBOX')

        const checkbox = $(this).find('.checkbox-input');

        // Toggle checked state
        checkbox.prop('checked', !checkbox.prop('checked'));

        // Toggle classes based on checked state
        $(this).toggleClass('checked', checkbox.prop('checked'));

        // Ambil elemen collapse dan ikon
        const content = document.getElementById('collapseOne');
        const icon = document.getElementById('accordion-icon');

        //get panel insured
        const containerformsInsured = $(this).closest('.panel-cover');

        if (checkbox.prop('checked')) {
            // Jika checkbox dicentang, sembunyikan konten dan ubah ikon
            if (content.classList.contains('show')) {
                content.classList.remove('show');
                icon.classList.remove('fa-chevron-up');
                icon.classList.add('fa-chevron-down');
            }

            //copy value polis
            copyPolisholderToInsured();

            // Nonaktifkan semua input dalam #collapseOne
            $('#collapseOne').find('input, select, textarea, button').prop('disabled', true);

            // remove (not check validation)
            containerformsInsured.removeClass('container-form');
            // Hapus semua class 'invalid' dari seluruh cucu elemen
            containerformsInsured.find('.invalid').removeClass('invalid');

        } else {
            // Jika checkbox tidak dicentang, tampilkan konten dan ubah ikon
            content.classList.add('show');
            icon.classList.remove('fa-chevron-down');
            icon.classList.add('fa-chevron-up');

            //reset value 
            resetInsuredFields(0);

            // Aktifkan kembali semua input dalam #collapseOne
            $('#collapseOne').find('input, select, textarea, button').prop('disabled', false);

            // add (need check validation)
            containerformsInsured.addClass('container-form');
        }
    });



    /* button clear kode promo */
    const clearButtons = document.querySelectorAll('.btnClear');

    clearButtons.forEach(button => {
        button.addEventListener('click', function () {
            const inputGroup = button.closest('.input-group-axa');
            const input = inputGroup.querySelector('.input-control-axa');

            input.value = '';
        });
    });


});


function handleInput(event) {
    const input = event.target;
    // Hanya mengizinkan angka dengan regex
    input.value = input.value.replace(/[^0-9]/g, '');
}

async function copyPolisholderToInsured() {
    console.log('copy value polis holder!!!')
    // Dapatkan nilai dari field polisholder
    const polisholderData = {
        _ispep: getCheckedValue('input[name="input_ispep_polisholder"]'),
        _fotoktp: '', // Tidak bisa disalin secara langsung karena ini adalah file, bisa handle terpisah
        _name: getValue('input[name="input_name_polisholder"]'),
        _ktppaspor: getValue('input[name="input_ktppaspor_polisholder"]'),
        _dob: getValue('input[name="input_dob_polisholder"]'),
        _pdob: getValue('input[name="input_pdob_polisholder"]'),
        _gender: getCheckedValue('input[name="input_gender_polisholder"]'),
        _kodenegara: getValue('select[name="input_kodenegara_polisholder"]'),
        _hp: getValue('input[name="input_hp_polisholder"]'),
        _negara: getValue('select[name="input_negara_polisholder"]'),
        _job: getValue('select[name="input_job_polisholder"]'),
        _ktpkitas: getValue('input[name="input_ktpkitas_polisholder"]'),
        _age: getValue('input[name="input_age_polisholder"]'),
        _statuskawin: getValue('select[name="input_status-kawin_polisholder"]'),
        _telepon: getValue('input[name="input_telepon_polisholder"]'),
        _email: getValue('input[name="input_email_polisholder"]'),
        _kodepos: getValue('input[name="input_kodepos_polisholder"]'),
        _alamat: getValue('textarea[name="input_alamat_polisholder"]')
    };


    // Set nilai ke field insured_0
    const gett = document.querySelector('input[name="input_ispep_insured_0"][value="' + polisholderData._ispep + '"]');
    gett.checked = true;
    document.querySelector('input[name="input_name_insured_0"]').value = polisholderData._name;
    document.querySelector('input[name="input_ktppaspor_insured_0"]').value = polisholderData._ktppaspor;
    document.querySelector('input[name="input_dob_insured_0"]').value = polisholderData._dob;
    document.querySelector('input[name="input_pdob_insured_0"]').value = polisholderData._pdob;
    document.querySelector('input[name="input_gender_insured_0"][value="' + polisholderData._gender + '"]').checked = true;
    document.querySelector('input[name="input_hp_insured_0"]').value = polisholderData._hp;
    document.querySelector('input[name="input_ktpkitas_insured_0"]').value = polisholderData._ktpkitas;
    document.querySelector('input[name="input_age_insured_0"]').value = polisholderData._age;
    document.querySelector('input[name="input_telepon_insured_0"]').value = polisholderData._telepon;
    document.querySelector('input[name="input_email_insured_0"]').value = polisholderData._email;
    document.querySelector('input[name="input_kodepos_insured_0"]').value = polisholderData._kodepos;
    document.querySelector('textarea[name="input_alamat_insured_0"]').value = polisholderData._alamat;

    // Handle image conversion (if applicable)
    document.querySelector('input[name="input_fotoktp_insured_0"]').value = base64Result;

    //using select 2
    const closestContainer = document.querySelector('input[name="input_ktppaspor_insured_0"]').closest('.panel-cover');

    if (closestContainer) {
        $(closestContainer).find('.status-kawin').val(polisholderData._statuskawin).trigger('change');
        $(closestContainer).find('.negara').val(polisholderData._negara).trigger('change');
        $(closestContainer).find('.job').val(polisholderData._job).trigger('change');
        $(closestContainer).find('.kode').val(polisholderData._kodenegara).trigger('change');
    }
}

function resetInsuredFields(index) {
    document.querySelector('input[name="input_ispep_insured_' + index + '"]').checked = false;
    document.querySelector('input[name="input_name_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_ktppaspor_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_dob_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_pdob_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_gender_insured_' + index + '"]').checked = false;
    document.querySelector('input[name="input_hp_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_ktpkitas_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_age_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_telepon_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_email_insured_' + index + '"]').value = '';
    document.querySelector('input[name="input_kodepos_insured_' + index + '"]').value = '';
    document.querySelector('textarea[name="input_alamat_insured_' + index + '"]').value = '';

    document.querySelector('input[name="input_fotoktp_insured_' + index + '"]').value = '';

    //using select 2
    const closestContainer = document.querySelector('input[name="input_ktppaspor_insured_0"]').closest('.container-form');

    if (closestContainer) {
        // Set nilai select2 dalam container terdekat
        $(closestContainer).find('.status-kawin').val('').trigger('change');
        $(closestContainer).find('.negara').val('').trigger('change');
        $(closestContainer).find('.job').val('').trigger('change');
        $(closestContainer).find('.kode').val('').trigger('change');
    }


}

function renderCheckboxSection(container) {
    console.log('call renderCheckboxSection');
    // Create the outer container div
    const outerDiv = document.createElement('div');
    outerDiv.className = 'pb-2level';

    // Create the flex container
    const flexContainer = document.createElement('div');
    flexContainer.className = 'display-flex align-items-center';

    // Hidden checkbox input
    const checkboxInput = document.createElement('input');
    checkboxInput.type = 'checkbox';
    checkboxInput.id = 'custom-checkbox';
    checkboxInput.className = 'display-hidden';

    // Label for the checkbox
    const label = document.createElement('label');
    label.htmlFor = 'custom-checkbox-x';
    label.className = 'display-flex align-items-center';

    // Checkbox container div
    const checkboxContainer = document.createElement('div');
    checkboxContainer.className = 'checkbox-container w-4level h-4level agency__border-border-gray-300 agency__rounded-sm display-flex align-items-center agency__justify-center mr-2level position-relative';

    // Inner hidden checkbox input
    const innerCheckbox = document.createElement('input');
    innerCheckbox.type = 'checkbox';
    innerCheckbox.className = 'display-hidden checkbox-input';
    innerCheckbox.name = 'insuredIsPolis';

    // SVG for the custom checkbox
    const svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');

    svg.setAttribute('class', 'checkboxSamePolis display-hidden agency__bg-axa-blue-400 w-4level h-4level agency__text-white position-absolute');
    svg.setAttribute('xmlns', 'http://www.w3.org/2000/svg');
    svg.setAttribute('fill', 'none');
    svg.setAttribute('viewBox', '0 0 24 24');
    svg.setAttribute('stroke', 'currentColor');

    // Path for the SVG
    const path = document.createElementNS('http://www.w3.org/2000/svg', 'path');
    path.setAttribute('stroke-linecap', 'round');
    path.setAttribute('stroke-linejoin', 'round');
    path.setAttribute('stroke-width', '2');
    path.setAttribute('d', 'M5 13l4 4L19 7');
    svg.appendChild(path);

    // Span for the checkbox description
    const span = document.createElement('span');
    span.className = 'checkBoxSpanDataSamePolis';
    span.textContent = 'Data Tertanggung Utama sama dengan data pemegang polis';

    // Append elements to build the structure
    checkboxContainer.appendChild(innerCheckbox);
    checkboxContainer.appendChild(svg);
    label.appendChild(checkboxContainer);
    label.appendChild(span);
    flexContainer.appendChild(checkboxInput);
    flexContainer.appendChild(label);
    outerDiv.appendChild(flexContainer);

    // Append the entire structure to the desired location in the DOM
    container.appendChild(outerDiv);
}

//render form insured
function renderInsuredForm(count, travellerType, totalAdult) {

    console.log('total>>', count);
    console.log('type>>  ', travellerType);
    console.log('total adult>>', totalAdult);

    console.log('CALL renderInsuredForm');
    const mainContainer = document.getElementById('container-generate-insured');
    mainContainer.innerHTML = ''; // Clear previous content

    for (let i = 0; i < count; i++) {

        // Container untuk menyimpan elemen yang akan dirender
        const container = document.createElement('div');
        container.className = 'panel-cover pt-10level mt-10level px-10level container-form';

        // Header
        const headerDiv = document.createElement('div');
        headerDiv.className = 'flex-justify-between align-items-center';
        const title = document.createElement('h1');
        title.className = 'agency__text-xl agency__font-bold';
        if (i === 0) {
            title.textContent = 'Data Tertanggung Utama';
        } else {
            title.textContent = 'Data Tertanggung ' + (i + 1);
        }

        headerDiv.appendChild(title);

        if (i === 0) {
            // Button untuk toggle accordion
            const toggleButton = document.createElement('button');
            toggleButton.id = 'btn__accordion-toggle';
            toggleButton.className = 'flex-justify-center align-items-center agency__w-10__h-10 agency__bg-axa-blue-400 agency__text-white';
            toggleButton.innerHTML = '<i id="accordion-icon" class="fas fa-chevron-down agency__text-xs"></i>';

            headerDiv.appendChild(toggleButton);
        }

        container.appendChild(headerDiv);

        // Create the checkbox element if index is 0
        if (i === 0) {
            renderCheckboxSection(container);
        }

        // Child collapse untuk tertanggung utama
        const collapseDiv = document.createElement('div');
        if (i === 0) {
            collapseDiv.id = 'collapseOne';
        }
        collapseDiv.className = 'accordion-collapse show';


        const insuredFormDiv = document.createElement('div');
        insuredFormDiv.className = 'insured-form';

        const ispepDiv = document.createElement('div');
        ispepDiv.className = 'ispep';
        ispepDiv.innerHTML =
            '<span class="agency__underline">' +
            'Apakah pemegang polis termasuk ke dalam kategori Orang yang ' +
            '<span class="agency__text-axa-sienna-400"> Populer secara politisi / ' +
            '<span class="agency__italic">Politically Exposed Persons </span> (PEP) </span> ?' +
            '</span>' +
            '<a class="btn--white__step3 ml-2level" href="#">' +
            '<span> Baca Selengkapnya <i class="fas fa-arrow-right"></i> </span>' +
            '</a>' +
            '<div class="radio-group">' +
            '<div>' +
            '<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">' +
            '<input id="no' + i + '" class="radio-custom" name="input_ispep_insured_' + i + '" type="radio" value="0" checked="checked" />' +
            '<label for="no' + i + '" class="radio-custom-label mb-0"><span>Tidak</span></label>' +
            '</div>' +
            '</div>' +
            '<div>' +
            '<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">' +
            '<input id="yes' + i + '" class="radio-custom" name="input_ispep_insured_' + i + '" type="radio" value="1" />' +
            '<label for="yes' + i + '" class="radio-custom-label mb-0">' +
            '<span>' +
            'Ya' +
            '<span class="ispepYes">(Data Anda akan kami tinjau untuk melewati persetujuan dari Underwriting)</span>' +
            '</span>' +
            '</label>' +
            '</div>' +
            '</div>' +
            '</div>';

        insuredFormDiv.appendChild(ispepDiv);

        const formColumnDiv = document.createElement('div');
        formColumnDiv.className = 'form-column display-flex agency__flex-wrap gap-4level';
        const form = document.createElement('form');
        form.className = 'display-flex agency__flex-wrap gap-4level';

        // Kolom Kiri
        const leftColumn = document.createElement('div');
        leftColumn.className = 'agency__flex-1 agency__min-w-300px';

        //negara
        const negaraDiv = document.createElement('div');
        negaraDiv.innerHTML =
            '<div>' +
            '<label for="negara">Kewarganegaraan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
            '<div id="single-journey-wrapper" class="position-relative negara-container">' +
            '<select class="input-control-axa negara" name="input_negara_insured_' + i + '" required>' +
            '<!-- Options will be dynamically added by JavaScript -->' +
            '</select>' +
            '</div>' +
            '</div>';

        //foto ktp
        const fotoDiv = document.createElement('div');
        fotoDiv.innerHTML =
            '<div class="upload-container">' +
            '<label for="upload"> Upload Foto KTP / KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
            '<div class="thumbnail-wrapper">' +
            '<img class="thumbnail img-thumbnail img-fluid" src="/o/mypage-theme/images/ktp-image.png" alt="foto ktp" />' +
            '<div class="ml-5level mt-2level">' +
            '<span class="file-name agency__text-xs"></span>' +
            '<button type="button" class="uploadButton agency__rounded-4px">Pilih File</button>' +
            '</div>' +
            '<input type="file" class="fileInput input_fotoktp_insured_' + i + ' display-hidden" accept="image/*" name="input_fotoktp_insured_' + i + '" required="required" />' +
            '</div>' +
            '</div>';

        //<!-- name -->
        const nameDiv = document.createElement('div');
        nameDiv.innerHTML =
            '<div> <label for="name"> Nama lengkap sesuai KTP / KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputName" placeholder="Tulis Nama" name="input_name_insured_' + i + '" type="text" required="required" oninput="handleInputHurufDanSpasi(event)" /> </div> </div>';

        //<!-- ktppasspor -->
        const ktppasporDiv = document.createElement('div');
        ktppasporDiv.innerHTML =
            '<div><label for="ktppasspor"> Nomor Paspor <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Nomor Paspor" name="input_ktppaspor_insured_' + i + '" type="text" maxlength="16" required="required" oninput="handleInput(event)" /> </div> </div>';

        //<!-- dob --> 
        const dobDiv = document.createElement('div');
        dobDiv.innerHTML =
            '<div> <label class="display-block" for="dateofbirth">Tanggal Lahir <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="calendar-wrapper position-relative" id="calendar-wrapper-claim"> <div class="calendar-col position-relative dob-wrapper"> <input class="input-control-axa input-control-axa--outline input-icon-date dob" type="text" name="input_dob_insured_' + i + '" autocomplete="off" placeholder="Pilih Tanggal Lahir" readonly="readonly" required="required" /> </div> </div> </div>';

        //<!-- place -->
        const placeDiv = document.createElement('div');
        placeDiv.innerHTML =
            '<div class="place"> <label for="place"> Tempat Lahir <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputPlaceOfBirth" placeholder="Tulis Tempat Lahir" name="input_pdob_insured_' + i + '" type="text" required="required" /> </div> </div>';


        //<!-- gender -->
        const genderDiv = document.createElement('div');
        genderDiv.innerHTML =
            '<div> <label for="gender">Jenis Kelamin <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="form-radio-wrapper display-flex"> <div class="display-flex gender-container"> <div class="form-radio mr-8px"> <input class="classInputGenderMale" type="radio" name="input_gender_insured_' + i + '" value="M" required="required" /> <div class="box-radio-wrapper agency__text-center"> <div class="box-radio"> <img src="/o/mypage-theme/images/man-nb.png" alt="laki" /> </div> <div class="box-text">Laki-Laki</div> </div> </div> <div class="form-radio"> <div class="form-radio-input"> <input type="radio" name="input_gender_insured_' + i + '" value="F" class="form-control classInputGenderFemale" required="required" /> <div class="box-radio-wrapper agency__text-center"> <div class="box-radio"> <img src="/o/mypage-theme/images/woman-nb.png" alt="perempuan" /> </div> <div class="box-text">Perempuan</div> </div> </div> </div> </div>  </div> </div>';

        //<!-- Kode negara dan telepon -->
        const kodeDiv = document.createElement('div');
        kodeDiv.innerHTML =
            '<div> <label for="kode">Kode Negara dan Telepon </label> <div id="single-journey-wrapper" class="position-relative"> <select class="input-control-axa kode" name="input_kodenegara_insured_' + i + '"> </select> </div> </div>';

        //<!-- hp -->
        const hpDiv = document.createElement('div');
        hpDiv.innerHTML =
            '<div> <label for="hp"> Nomor Handphone <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Nomor Handphone" name="input_hp_insured_' + i + '" type="text" maxlength="15" required="required" oninput="handleInput(event)" /> </div> </div>';

        //<!-- job -->
        const jobDiv = document.createElement('div');
        jobDiv.innerHTML =
            '<div> <label for="job">Pekerjaan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div id="single-journey-wrapper" class="position-relative job-container"> <select class="input-control-axa job" name="input_job_insured_' + i + '" required> <option></option> <option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option> <option value="Karyawan Swasta">Karyawan Swasta</option> <option value="TNI/POLRI">TNI/POLRI</option> <option value="PNS">PNS</option> <option value="Ibu Rumah Tangga">Ibu Rumah Tangga</option> <option value="Wiraswasta">Wiraswasta</option> <option value="Lainnya">Lainnya</option> </select> </div> </div> ';


        //append left
        leftColumn.appendChild(negaraDiv); //update negara sebelum upload file
        leftColumn.appendChild(fotoDiv);
        leftColumn.appendChild(nameDiv);
        leftColumn.appendChild(ktppasporDiv);
        leftColumn.appendChild(dobDiv);
        leftColumn.appendChild(placeDiv);
        leftColumn.appendChild(genderDiv);
        leftColumn.appendChild(kodeDiv);
        leftColumn.appendChild(hpDiv);
        leftColumn.appendChild(jobDiv);


        // Kolom Kanan
        const rightColumn = document.createElement('div');
        rightColumn.className = 'agency__flex-1 agency__min-w-300px';


        //<!-- passpor -->
        const pasporDiv = document.createElement('div');
        pasporDiv.innerHTML =
            '<div style="margin-top:321px"> <label for="ktppaspor"> Nomor KTP / KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputKtpKitas" placeholder="Tulis No. KTP / KITAS" name="input_ktpkitas_insured_' + i + '" type="text" maxlength="16" required="required" oninput="handleInput(event)" /> </div> </div>';


        //<!-- age -->
        const ageDiv = document.createElement('div');
        ageDiv.innerHTML =
            '<div> <label for="age"> Usia </label> <div class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome"> <input disabled="disabled" class="input-control-axa age" placeholder="0" name="input_age_insured_' + i + '" type="text" /> <span class="font_tahun">Tahun</span> </div> </div>';


        //Hubungan
        const hubunganDiv = document.createElement('div');
        let hubunganOptions = '';

        if (travellerType === 'Individual') {
            hubunganOptions = '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>';
        } else if (travellerType === 'Duo') {
            hubunganOptions = i === 0 ?
                '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>' :
                '<option value="Pasangan" selected>Pasangan</option>';
        } else if (travellerType === 'Family') {
            if (totalAdult === 1) {
                hubunganOptions = i === 0 ?
                    '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>' :
                    '<option value="Anak">Anak</option><option value="Anak / Pelajar">Anak / Pelajar</option>';
            } else if (totalAdult === 2) {
                hubunganOptions = i === 0 ?
                    '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>' :
                    i === 1 ?
                        '<option value="Pasangan" selected>Pasangan</option>' :
                        '<option value="Anak">Anak</option><option value="Anak / Pelajar">Anak / Pelajar</option>';
            }
        }

        hubunganDiv.innerHTML =
            '<div> <label for="relationship">Hubungan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div id="single-journey-wrapper" class="position-relative relationship-container"> <select class="input-control-axa relationship" name="input_relationship_insured_' + i + '" required>' +
            '<option></option>' + hubunganOptions +
            '</select> </div> </div>';

        // <!-- status kawin -->
        const statusKawinDiv = document.createElement('div');
        statusKawinDiv.innerHTML =
            '<div style="margin-top:150px"> <label for="status-kawin">Status Perkawinan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div id="single-journey-wrapper" class="position-relative status-kawin-container"> <select class="input-control-axa status-kawin" name="input_status-kawin_insured_' + i + '" required> <option></option> <option value="Belum Menikah">Belum Menikah</option> <option value="Sudah Menikah">Sudah Menikah</option> </select> </div> </div>';


        //<!-- telepon -->
        const teleponDiv = document.createElement('div');
        teleponDiv.innerHTML =
            '<div class="telepondiv"> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Nomor Telepon" name="input_telepon_insured_' + i + '" type="text" /> </div> </div>';


        //<!-- email -->
        const emailDiv = document.createElement('div');
        emailDiv.innerHTML =
            '<div> <label for="email">Email <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis email" name="input_email_insured_' + i + '" type="text" required="required" /> </div> </div>';

        //<!-- kode pos -->
        const posDiv = document.createElement('div');
        posDiv.innerHTML =
            '<div> <label for="kodepos">Kode Pos <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Kode Pos" name="input_kodepos_insured_' + i + '" type="text" required="required" /> </div> </div>';

        //append right
        //rightColumn.appendChild(negaraDiv);
        rightColumn.appendChild(pasporDiv);
        rightColumn.appendChild(hubunganDiv);
        rightColumn.appendChild(ageDiv);
        rightColumn.appendChild(statusKawinDiv);
        rightColumn.appendChild(teleponDiv);
        rightColumn.appendChild(emailDiv);
        rightColumn.appendChild(posDiv);


        // Alamat
        const alamatDiv = document.createElement('div');
        alamatDiv.className = 'alamatdiv';
        alamatDiv.innerHTML =
            '<label for="alamat">Alamat Lengkap <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
            '<div class="input-group-axa input-group-axa--border">' +
            '<textarea class="input-control-axa classInputAddress" placeholder="Tulis Alamat Lengkap" name="input_alamat_insured_' + i + '" required="required"></textarea>' +
            '</div>';

        form.appendChild(leftColumn);
        form.appendChild(rightColumn);
        form.appendChild(alamatDiv);
        formColumnDiv.appendChild(form);
        insuredFormDiv.appendChild(formColumnDiv);
        collapseDiv.appendChild(insuredFormDiv);
        container.appendChild(collapseDiv);

        // Menambahkan container ke body atau elemen yang diinginkan
        mainContainer.appendChild(container);
    }
}



//reopen UPDATE 

function handleInputHurufDanSpasi(event) {
    const input = event.target;
    // Mengganti semua karakter yang bukan huruf atau spasi dengan string kosong
    input.value = input.value.replace(/[^A-Za-z\s]/g, '');
}

function handleInputHurufAngkaDanKarakter(event) {
    const input = event.target;
    // Mengganti semua karakter yang bukan huruf, angka, atau karakter khusus tertentu dengan string kosong
    input.value = input.value.replace(/[^A-Za-z0-9@._-]/g, '');
}



</script>