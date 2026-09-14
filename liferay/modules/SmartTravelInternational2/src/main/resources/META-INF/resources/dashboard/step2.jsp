<%@page import="java.util.ArrayList"%>
<%@page import="com.mypage.admin.product.service.BenefitTypeLocalServiceUtil"%>
<%@page import="com.mypage.admin.product.model.BenefitType"%>
<%@page import="com.mypage.admin.product.service.BenefitLocalServiceUtil"%>
<%@page import="com.mypage.admin.product.model.Benefit"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp"%>

<%-- Membuat URL untuk step3.jsp --%>
<portlet:renderURL var="step3URL">
	<portlet:param name="jspPage" value="/dashboard/step3.jsp" />
</portlet:renderURL>


<%

String portalURL = PortalUtil.getPortalURL(request);
String restApiUrl = portalURL + "/o/api/sti/step2"; //  /o access from osgi, /api/sti/step2 is path api

	List<BenefitType> type = BenefitTypeLocalServiceUtil.getBenefitTypeAdditional();
	List<BenefitType> typeMain = BenefitTypeLocalServiceUtil.getBenefitTypeMain();

	String plan = (String) request.getAttribute("plan");
	
	String benefitChosen = (String) renderRequest.getAttribute("benefit-chosen");

	// Pecah string menjadi array dengan separator ","
	String[] chosenBenefitIds = benefitChosen.split(",");

	// Convert array of Strings to a List of Longs
	List<Long> chosenBenefits = new ArrayList<>();
	for (String id : chosenBenefitIds) {
	    chosenBenefits.add(Long.valueOf(id));
	}
%>

<header class="hero">
	<img src="/o/mypage-theme/images/step2hero.png" alt="herostep2" class="width-full height-full">
</header>

<portlet:resourceURL id="/data/dashboard/smart_travel_international" var="loadSmartTravelInternationalData" />

<section class="chosee-plan">

	<!-- navbar -->
	<%@ include file="navbar.jsp"%>

	<!-- step bar -->
	<div class="stepper-wrapper">
		<div class="stepper-item active">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase">Pilih Perlindungan</div>
		</div>
		<div class="stepper-item">
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

	<form id="step2Form">
		<div class="chosee-plan__tabs">
			<div class="container-axa">
				<div class="tab-content__sm">
					<div class="tab-pane fade show active" tabindex="0">
						<div class="tab-content__step2">

							<div class="col-tabstep2">
								<section class="smart-mediacare-inter__table" id="Sec-1">

									<div class="panel-cover mb-10level">
										<section class="simulasi">
											<div class="container-axa">
												<h1>Pilih Plan SmartActive</h1>
												<div class="simulasi__inner__step2">
													<div class="simulasi__inner--left-step2">
														<div class="mt-4level">
															<label class="display-block" for="pilih-mata-uang">Pilih
																Jenis Mata Uang</label>
															<!-- <div class="grid-radio mb-8level">
																<div>
																	<div
																		class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
																		<input id="usd" class="radio-custom" name="type"
																			type="radio"> <label for="usd"
																			class="radio-custom-label mb-0level"><span>USD</span></label>
																	</div>
																</div>
																<div>
																	<div
																		class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
																		<input id="idr" class="radio-custom" name="type"
																			type="radio"> <label for="idr"
																			class="radio-custom-label mb-0level"><span>IDR</span></label>
																	</div>
																</div>
															</div> -->
															<div class="grid-radio mb-8level">
																<div>
																	<div
																		class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
																		<input id="usd" class="radio-custom" name="type"
																			type="radio" value="USD"
																			<%="USD".equals(request.getAttribute("currency")) ? "checked" : ""%>>
																		<label for="usd" class="radio-custom-label mb-0level"><span>USD</span></label>
																	</div>
																</div>
																<div>
																	<div
																		class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">
																		<input id="idr" class="radio-custom" name="type"
																			type="radio" value="IDR"
																			<%="IDR".equals(request.getAttribute("currency")) ? "checked" : ""%>>
																		<label for="idr" class="radio-custom-label mb-0level"><span>IDR</span></label>
																	</div>
																</div>
															</div>
														</div>


														<!-- penumpang -->
														<div class="mt-4level">
															<label class="display-block" for="pilih-jenis-penumpang">Pilih
																jenis penumpang</label>
															<div class="form-radio-wrapper">
																<!-- <div class="form-radio">
																	<input type="radio" name="gender" value="M">
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/man-nb.png"
																				alt="Sendiri">
																		</div>
																		<div class="box-text">Sendiri</div>
																	</div>
																</div>
																<div class="form-radio">
																	<div class="form-radio-input">
																		<input type="radio" name="gender" value="D"
																			class="form-control">
																		<div class="box-radio-wrapper agency__text-center">
																			<div class="box-radio">
																				<img src="/o/mypage-theme/images/duo-nb.png"
																					alt="Duo">
																			</div>
																			<div class="box-text">Duo</div>
																		</div>
																	</div>
																</div>
																<div class="form-radio">
																	<div class="form-radio-input">
																		<input type="radio" name="gender" value="F"
																			class="form-control">
																		<div class="box-radio-wrapper agency__text-center">
																			<div class="box-radio">
																				<img src="/o/mypage-theme/images/familiy-nb.png"
																					alt="Family">
																			</div>
																			<div class="box-text">Keluarga</div>
																		</div>
																	</div>
																</div> -->


																<div class="form-radio">
																	<input type="radio" name="jenis-penumpang" value="M"
																		<%="M".equals(request.getAttribute("jenis-penumpang")) ? "checked" : ""%>>
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/man-nb.png"
																				alt="Sendiri">
																		</div>
																		<div class="box-text">Sendiri</div>
																	</div>
																</div>
																<div class="form-radio">
																	<input type="radio" name="jenis-penumpang" value="D"
																		<%="D".equals(request.getAttribute("jenis-penumpang")) ? "checked" : ""%>>
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/duo-nb.png"
																				alt="Duo">
																		</div>
																		<div class="box-text">Duo</div>
																	</div>
																</div>
																<div class="form-radio">
																	<input type="radio" name="jenis-penumpang" value="F"
																		<%="F".equals(request.getAttribute("jenis-penumpang")) ? "checked" : ""%>>
																	<div class="box-radio-wrapper agency__text-center">
																		<div class="box-radio">
																			<img src="/o/mypage-theme/images/familiy-nb.png"
																				alt="Family">
																		</div>
																		<div class="box-text">Keluarga</div>
																	</div>
																</div>

															</div>
														</div>


														<!-- jumlah tanggungan -->
														<div class="simulasi__inner--right">
															<div class="mt-4level">
																<label class="display-block" for="jumlah-tanggungan">Jumlah
																	Tanggungan</label>
																<div class="input-grid w-400px">
																	<!-- <div class="input-group-axa input-group-axa--border">
																		<input class="input-control-axa w-90px" type="text"
																			value="2">
																		<div id="select-adult-wrapper">
																			<select class="self-center" name="" id="select-adult">
																				<option value="Dewasa">Dewasa</option>
																			</select>
																		</div>
																	</div>
																	<div class="input-group-axa input-group-axa--border">
																		<input class="input-control-axa w-90px" type="text"
																			value="1">
																		<div id="select-kid-wrapper">
																			<select class="self-center" name="" id="select-kid">
																				<option value="Anak">Anak</option>
																			</select>
																		</div>
																	</div> -->

																	<div class="input-group-axa input-group-axa--border">
																		<input class="input-control-axa w-90px" type="text" name="adult-tanggungan"
																			value="<%=request.getAttribute("jumlah-tanggungan-dewasa")%>">
																		<div id="select-adult-wrapper">
																			<select class="self-center" name="" id="select-adult">
																				<option value="Dewasa">Dewasa</option>
																			</select>
																		</div>
																	</div>
																	<div class="input-group-axa input-group-axa--border">
																		<input class="input-control-axa w-90px" type="text" name="kid-tanggungan"
																			value="<%=request.getAttribute("jumlah-tanggungan-anak")%>">
																		<div id="select-kid-wrapper">
																			<select class="self-center" name="" id="select-kid">
																				<option value="Anak">Anak</option>
																			</select>
																		</div>
																	</div>

																</div>
															</div>

														</div>

														<!-- jenis perjalanan -->
														<div class="mt-4level w-400px">
															<label class="display-block" for="pilih-jebis-perjalanan">Pilih
																jenis perjalanan</label>
															<!-- <div id="single-journey-wrapper"
																class="position-relative">
																<select class="input-control-axa" name="single-journey"
																	id="single-journey" required>
																	<option></option>
																	<option value="Perjalanan Tunggal">Perjalanan
																		Tunggal</option>
																	<option value="Perjalanan Trip">Perjalanan
																		Trip</option>
																</select>
															</div> -->

															<div id="single-journey-wrapper"
																class="position-relative">
																<select class="input-control-axa" name="single-journey"
																	id="single-journey" required>
																	<option></option>
																	<option value="Perjalanan Tunggal"
																		<%="Perjalanan Tunggal".equals(request.getAttribute("jenis-perjalanan")) ? "selected" : ""%>>Perjalanan
																		Tunggal</option>
																	<option value="Perjalanan Trip"
																		<%="Perjalanan Trip".equals(request.getAttribute("jenis-perjalanan")) ? "selected" : ""%>>Perjalanan
																		Trip</option>
																</select>
															</div>

														</div>

														<!-- tanggal perjalanan -->
														<div class="mt-4level w-400px">
															<label class="display-block" for="tgl-perjalanan">Tanggal
																Perjalanan</label>
															<div class="calendar-wrapper position-relative"
																id="calendar-wrapper-claim">
																<div class="calendar-col position-relative"
																	id="Fromtravel-wrapper">
																	<input
																		class="input-control-axa input-control-axa--outline"
																		type="text" id="Fromtravel" name="from"
																		autocomplete="off">
																	<div class="label-text">Dari</div>
																</div>
																<div class="separated-arrow">
																	<i
																		class="fas fa-arrow-right align-self-center text-12px"></i>
																</div>
																<div class="calendar-col position-relative"
																	id="Totravel-wrapper">
																	<input
																		class="input-control-axa input-control-axa--outline input-icon-date"
																		type="text" id="Totravel" name="to" autocomplete="off">
																	<div class="label-text">Ke</div>
																</div>
															</div>

														</div>


														<!-- jenis plan polis -->
														<div class="mt-4level w-400px">
															<label class="display-block" for="pilih-plan-type">Pilih
																Plan Polis </label>
															<!-- <div id="single-journey-wrapper"
																class="position-relative">
																<select class="input-control-axa" name="plan-type"
																	id="plan-type" required>
																	<option></option>
																	<option value="Silver">Silver</option>
																	<option value="Gold">Gold</option>
																	<option value="Platinum">Platinum</option>

																</select>
															</div> -->

															<div id="single-journey-wrapper"
																class="position-relative">
																<select class="input-control-axa" name="plan-type"
																	id="plan-type" required>
																	<option></option>
																	<option value="Silver"
																		<%="Silver".equals(request.getAttribute("plan-type")) ? "selected" : ""%>>Silver</option>
																	<option value="Gold"
																		<%="Gold".equals(request.getAttribute("plan-type")) ? "selected" : ""%>>Gold</option>
																	<option value="Platinum"
																		<%="Platinum".equals(request.getAttribute("plan-type")) ? "selected" : ""%>>Platinum</option>
																</select>
															</div>

														</div>
													</div>
												</div>

												<!-- main benefit -->
												<div class="panel-table hide__checkbox__step2 mt-8level">
													<div class="panel-table-header">
														<h4 class="agency__font-bold">ManfaatUtama</h4>
													</div>

													<div class="panel-main-benefit">

														<%
															List<Benefit> main = BenefitLocalServiceUtil.getBenefitByPlan(plan, typeMain.get(0).getBenefitTypeId());
															for (int i = 0; i < main.size(); i++) {
														%>

														<div class="main-benefit-row main-benefit-inner">
															<span class="agency__col-span-1"> <%=main.get(i).getNameId()%>
															</span> <span
																class="agency__col-span-1 agency__text-axa-blue-500 text-left">
																<%=main.get(i).getBenefitValue()%>
															</span>
														</div>

														<%
															}
														%>


													</div>

												</div>

											</div>
										</section>
									</div>

									<div class="content__left panel-cover pt-10level">
										<h1>Tambahan Proteksi</h1>

										<%
											for (int i = 0; i < type.size(); i++) {
												List<Benefit> bens = BenefitLocalServiceUtil.getBenefitByPlan(plan, type.get(i).getBenefitTypeId());
										%>

										<div class="panel-table hide__checkbox__step2">
											<div class="panel-table-header">
												<h4 class="agency__font-bold"><%=type.get(i).getNameId()%>
													(Tambahan)
												</h4>
											</div>

											<div class="panel-table-body">
												<div class="toogle__row">
													<!-- Responsive layout -->
													<div class="display-flex align-items-center">
														<input type="checkbox" id="switch-<%=i%>_"
															name="switch-<%=i%>_" class="parent" /> <label
															class="label_toggle" for="switch-<%=i%>_">Toggle</label>
														<span class="agency__font-bold ml-3level">Pilih
															Semua</span>
													</div>
													<span class="toogle__row-span_parent"></span>
												</div>

												<%
													for (int j = 0; j < bens.size(); j++) {
														Long benId = bens.get(j).getBenefitId();
												%>

												<div class="toogle__row">
													<!-- Responsive layout -->
													<div class="display-flex align-items-center">
													
														<input type="checkbox" id="switch-<%=i%>_<%=j%>"
															name="switch-<%=i%>_<%=j%>" class="child" value="<%=benId %>" <%= chosenBenefits.contains(benId) ? "checked" : "" %> /> <label
															class="label_toggle" for="switch-<%=i%>_<%=j%>">Toggle</label>
														<span class="toogle__row-span-item"><%=bens.get(j).getNameId()%>
														</span> <span class="penjelasan-link-mobile"><a href="#">Penjelasan</a></span>
														<!-- Penjelasan di mobile -->
													</div>
													<div class="toogle__row-span_cost">
														<span class="cost-text"><%=bens.get(j).getBenefitValue()%></span>
														<span class="penjelasan-link"><a href="#">Penjelasan</a></span>
														<!-- Penjelasan di desktop -->
													</div>
												</div>

												<%
													}
												%>
											</div>
										</div>

										<%
											}
										%>


										<!-- end panel group benefit -->
									</div>

									<div class="agency__text-center mt-5level">
										<a class="btn__agency btn--dark-blue width-full" href="#">
											<span class="position-relative">Perbarui Perhitungan <i
												class="fas fa-arrow-right"></i></span>
										</a>
									</div>
								</section>
							</div>

							<div class="col-tabstep2">
								<div class="panel-cover py-5level">
									<h3>Perjalanan International</h3>
									<h1 class="my-3level">Plan Bugdet Travel</h1>
									<h4>Proteksi Anda</h4>
									<div class="px-10level">
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
													<input class="input-control-axa promo-code"
														placeholder="Isi Kode Promo" type="text" maxlength="13"
														id="promo_code">
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
										<!-- <a class="btn__agency btn--dark-blue width-full" href="#">
										<span class="position-relative agency__uppercase ">Lanjut
											ke Pemegang Polis <i class="fas fa-arrow-right"></i>
									</span>
									</a> -->

										<!-- NEXT HERE -->
										<%-- <a class="btn__agency btn--dark-blue width-full"
											href="<%=step3URL%>"> <span
											class="position-relative agency__uppercase ">Lanjut ke
												Pemegang Polis <i class="fas fa-arrow-right"></i>
										</span>
										</a> --%>
										<a class="btn__submit btn__agency btn--dark-blue width-full" >
										<span
										class="position-relative agency__uppercase agency__pointer">Lanjut ke
												Pemegang Polis <i class="fas fa-arrow-right"></i>
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
	</form>
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
								<input class="input-control-axa promo-code" placeholder="Isi Kode Promo"
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

						<a class="btn btn__agency btn--dark-blue" href="<%=step3URL%>">
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
											<li><span>Dewasa</span> <span>2 Dewasa</span> <span>USD 62.460.222,62</span></li>
										</ul>
										<ul>
											<li><span>Anak</span> <span>1 anak</span> <span>USD 3.089</span></li>
										</ul>
									</div>
									<div class="col">
										<ul>
											<li><span>Biaya Polis</span> <span>USD 62.460.222,62</span></li>
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

						<a class="btn btn__agency btn--dark-blue" href="<%=step3URL%>">
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

var kycURL = "<%=restApiUrl%>";
var link = "<%=step3URL%>";


$('.btn__submit').on('click', function() {
    console.log('EXECUTE HERE!!!! to>>' + kycURL);
    
    // Mengumpulkan nilai checkbox yang dipilih
    const selectedCheckboxes = [];
    document.querySelectorAll('#step2Form .child:checked').forEach(function(checkbox) {
        selectedCheckboxes.push(checkbox.value);
    });
    
 	//Ambil nilai dari radio button mata uang yang dipilih
    var currency = $('input[name="type"]:checked').val();
    
    // Ambil nilai dari radio button jenis penumpang yang dipilih
    var jenisPenumpang = $('input[name="jenis-penumpang"]:checked').val();
    
    // Ambil nilai jumlah tanggungan dewasa dan anak
    var jumlahDewasa = $('input[name="adult-tanggungan"]').val();
    var jumlahAnak = $('input[name="kid-tanggungan"]').val();
    
    // Ambil nilai dari select jenis perjalanan
    var jenisPerjalanan = $('#single-journey').val();
    
    // Ambil tanggal perjalanan dari input date
    var tanggalDari = $('#Fromtravel').val();
    var tanggalKe = $('#Totravel').val();
    
    // Ambil nilai dari select plan polis
    var planType = $('#plan-type').val();
    
    var datadiri = {
    	      currency,
    	      jenisPenumpang,
    	      jumlahDewasa,
    	      jumlahAnak,
    	      jenisPerjalanan,
    	      tanggalDari,
    	      tanggalKe,
    	      planType
    	    };
    
    console.log(datadiri);
    
    console.log('Selected checkboxes:', selectedCheckboxes);
    
    const promoCode = $('.promo-code').val();
    
    preparePayload(datadiri, selectedCheckboxes, promoCode);
});


async function preparePayload(data = null, items = null, promoCode = null) {
    console.log('call preparePayload!!');
    
    
    const payload = {
		items: items,
		data: data,
        promoCode,
        step: 'step2'
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

$(document).ready(function() {
	
    $('#single-journey').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Perjalanan Tunggal",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('#plan-type').select2({
        dropdownParent: '#single-journey-wrapper',
        placeholder: "Pilih Plan",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $('#select-adult').select2({
        dropdownParent: '#select-adult-wrapper',
        placeholder: "",
        width: '100%',
        minimumResultsForSearch: -1
    });
    $('#select-kid').select2({
        dropdownParent: '#select-kid-wrapper',
        placeholder: "",
        width: '100%',
        minimumResultsForSearch: -1
    });
    $('#select-plan').select2({
        dropdownParent: '#select-plan-wrapper',
        placeholder: "Pilih Plan",
        width: '100%',
        minimumResultsForSearch: -1
    });
    $('#select-anchor').select2({
        dropdownParent: '#select-anchor-wrapper',
        placeholder: "",
        width: '100%',
        minimumResultsForSearch: -1
    });

    $(".btn-buy").click(function() {
        $('.sticky-plan').addClass('is-active');
    });

    $(".trigger-collapse-promo").click(function() {
        $("#collapseCodepromo").toggleClass('is-show');
        $(this).toggleClass('is-active');
        $('.sticky-plan__inner').toggleClass('is-active');
    });

    $(".trigger-collapse-plan-detail").click(function() {
        console.log('jalan');
        $('.detail-summary').toggleClass('is-active');

        $("#collapsePlandetail").toggleClass('is-show');
        $('.sticky-plan__summary').toggleClass('is-hide');
        $('.sticky-plan__inner').toggleClass('is-active-detail');

        $('.code-promo').toggleClass('display-hidden');
    });

    $(".trigger-sub-menu").click(function() {
        $('.sub-menu').toggleClass('is-active');
    });

    $(".back-sub-menu").click(function() {
        $('.sub-menu').removeClass('is-active');
    });

    $(".detail-summary").click(function() {

        $('.sticky-plan-collapse-summary').removeClass('is-show');
        $(this).removeClass('is-active');
        $('.sticky-plan__summary').removeClass('is-hide');
        $('.sticky-plan__inner').removeClass('is-active-detail');
        $('.detail-summary').removeClass('is-active');
        $('.code-promo').removeClass('display-hidden');
    });

    $(function() {
        $('#planSelector').change(function() {
            $('.plans').hide();
            $('#' + $(this).val()).show();
        });
    });


    /* datepicker */
    // Ambil nilai dari atribut yang sudah di-set di server-side (misalnya melalui JSP atau backend lain)
    var tglPerjalananDari = '<%= request.getAttribute("tgl-perjalanan-dari") %>';
    var tglPerjalananKe = '<%= request.getAttribute("tgl-perjalanan-ke") %>';

    // Objek bulan dalam bahasa Indonesia
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

    // Jika nilai dari server ada, gunakan itu, jika tidak gunakan tanggal hari ini
    var dateToSet = tglPerjalananDari ? moment(tglPerjalananDari, "DD/MM/YYYY") : moment();
    var dateToSetTo = tglPerjalananKe ? moment(tglPerjalananKe, "DD/MM/YYYY") : moment();


    if (tglPerjalananDari) {
        const day = dateToSet.format('DD');
        const englishMonth = dateToSet.format('MMMM');
        const year = dateToSet.format('YYYY');
        const indonesianMonth = indonesianMonths[englishMonth];

        const formattedDate = day + '/' + indonesianMonth + '/' + year;

        $('#Fromtravel').val(formattedDate);
    }
    if (tglPerjalananKe) {
        const day = dateToSetTo.format('DD');
        const englishMonth = dateToSetTo.format('MMMM');
        const year = dateToSetTo.format('YYYY');
        const indonesianMonth = indonesianMonths[englishMonth];

        const formattedDate = day + '/' + indonesianMonth + '/' + year;

        $('#Totravel').val(formattedDate);
    }

    // Inisialisasi datepicker dan set agar mengarah ke tanggal yang sudah diatur
    $('#Fromtravel').daterangepicker({
        parentEl: "#Fromtravel-wrapper",
        autoUpdateInput: false, // Tetap false untuk mengatur format manual
        singleDatePicker: true,
        showDropdowns: true,
        startDate: dateToSet, // Set tanggal awal (dari server atau sekarang)
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        locale: {
            applyLabel: "Pilih",
            cancelLabel: "Batal",
            daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
            monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
        }
    });

    $('#Totravel').daterangepicker({
        parentEl: "#Totravel-wrapper",
        autoUpdateInput: false, // Tetap false untuk mengatur format manual
        singleDatePicker: true,
        showDropdowns: true,
        startDate: dateToSetTo, // Set tanggal awal (dari server atau sekarang)
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        locale: {
            applyLabel: "Pilih",
            cancelLabel: "Batal",
            daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
            monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
        }
    });

    // Event listener untuk memformat tanggal yang dipilih sesuai bahasa Indonesia
    $("#Fromtravel , #Totravel").on("apply.daterangepicker", function(ev, picker) {

        const day = picker.startDate.format('DD');
        const englishMonth = picker.startDate.format('MMMM');
        const year = picker.startDate.format('YYYY');
        const indonesianMonth = indonesianMonths[englishMonth];

        const formattedDate = day + '/' + indonesianMonth + '/' + year;

        $(this).val(formattedDate);

    });

    // Event listener untuk clear input saat membatalkan pilihan tanggal
    $("#Fromtravel , #Totravel").on("cancel.daterangepicker", function(ev, picker) {
        $(this).val("");
    });

    /* end init date */


    /* additional */
    /* toogle benefit*/
    const panels = document.querySelectorAll('.panel-table-body');

    panels.forEach(panel => {
        const parentCheckbox = panel.querySelector('.parent');
        const childCheckboxes = panel.querySelectorAll('.child');

        function updateParentCheckbox() {
            const allChecked = Array.from(childCheckboxes).every(cb => cb.checked);
            const someChecked = Array.from(childCheckboxes).some(cb => cb.checked);

            parentCheckbox.checked = allChecked;
            parentCheckbox.indeterminate = !allChecked && someChecked;
        }

        parentCheckbox.addEventListener('change', function() {
            childCheckboxes.forEach(cb => {
                cb.checked = parentCheckbox.checked;
            });
        });

        childCheckboxes.forEach(cb => {
            cb.addEventListener('change', updateParentCheckbox);
        });

        // Initial update to ensure correct state on page load
        updateParentCheckbox();
    });


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

});


// for remove panel-cover while mobile
function handlePanelCover() {
    // Ambil semua elemen dengan class .panel-cover
    const panelCoverElements = document.querySelectorAll('.panel-cover');

    // Cek apakah layar lebih kecil dari 768px (mobile)
    if (window.innerWidth < 768) {
        panelCoverElements.forEach(element => {
            // Jika elemen juga memiliki class .content__left, hapus class .panel-cover
            if (element.classList.contains('content__left')) {
                element.classList.remove('panel-cover');
            }
        });
    } else {
        panelCoverElements.forEach(element => {
            // Tambahkan class .panel-cover kembali saat layar lebih besar dari 768px
            if (element.classList.contains('content__left')) {
                element.classList.add('panel-cover');
            }
        });
    }
}

// Jalankan fungsi saat halaman dimuat
handlePanelCover();

// Jalankan fungsi saat ukuran jendela diubah (resize)
window.addEventListener('resize', handlePanelCover);



</script>


<script src="<%=request.getContextPath()%>/dashboard/js/main.js" type="text/javascript"></script>
