								<div class="panel-cover py-5level">
									<h3>Perjalanan International</h3>
									<h1 class="my-3level" id="PlanSummary-PlanName">-</h1>
									<h4>Proteksi Anda</h4>
									<div class="px-10level">
										<div class="flex-justify-between mb-1level">
											<span id="PlanSummary-TotalDays">0 Hari</span> <span></span>
											<span class="text_nondiscount agency__w-1per3"
												id="PlanSummary-SubTotalPremiPrice">-</span>
										</div>
<!-- 										<div class="flex-justify-between mb-1level"> -->
<!-- 											<span>Biaya Polis</span> <span></span> <span -->
<!-- 												class="text_nondiscount agency__w-1per3" -->
<!-- 												id="PlanSummary-PolicyCost">-</span> -->
<!-- 										</div> -->
										<div class="flex-justify-between mb-1level">
											<span>Materai</span> <span></span> <span
												class="text_nondiscount agency__w-1per3"
												id="PlanSummary-Stamp">-</span>
										</div>
									</div>

								</div>
								<div class="panel-cover py-3level">
									<div class="sticky-collapse-promo">
										<div class="sticky-collapse-promo-step2">
											<div class="col">
												<label for="kode-promo">Kode Promo</label>
												<div class="input-group-axa input-group-axa--border input-group-step2">
													<input class="input-control-axa promo-code"
														placeholder="Isi Kode Promo" type="text" maxlength="30"
														id="promo_code" name="PromoCodeSidebar">
													<button type="button" id="clear-promo-code-btn-sidebar">
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
													<td class="agency__text-axa-ocean-100 pl-85px" id="PlanSummary-TotalPremiPrice-discount"></td>
												</tr>
												<tr class="gohide">
													<td>Total Premi</td>
													<td class="total-premi pl-85px"></td>
												</tr>
												<tr>
													<td>Total Premi</td>
													<td class="cost-total-premi2 pl-85px" id="PlanSummary-TotalPremiPrice">-</td>
												</tr>
												<tr class="PlanSummary-TotalPremiPrice-idr-wrapper gohide">
													<td></td>
													<td class="agency__text-axa-ocean-100 pl-85px" id="PlanSummary-TotalPremiPrice-idr"></td>
												</tr>
											</tbody>
										</table>
									</div>

									<div class="sidebar-nav" id="sidebarNav">
										<a class="btn btn--dark-blue width-full next-step-btn mb-15px" href="javascript:void(0)" id="next-step-btn-sidebar"><span class="position-relative text-transform-uppercase">Lanjut ke Data pemegang polis <i class="fas fa-arrow-right"></i></span></a>
										<%
											String showClass = "gohide";
											if(businessModel.equalsIgnoreCase("B2B")) {
												showClass = "";
											}
										%>
										<a class="btn btn--dark-blue width-full <%= showClass %> href="javascript:void(0)" id="submit-quotation-btn" style="margin-top:15px"><span class="position-relative text-transform-uppercase">Kirim Penawaran</span></a>

										<!-- REQUEST ADD BTN BACK, cc @eki -->
			                            <!-- <a class="btn btn--dark-blue-outline width-full " href="#">
			                               <span class="position-relative text-transform-uppercase "><i class="fas fa-arrow-left"></i> Kembali
			                              </span>
			                            </a> -->
										
                            
										<!-- Jika ada perubahan di Form Data -->
										<!--                             <a class="btn btn--dark-blue w-full hidden" href="#">
                              <span class="relative uppercase ">Perbaharui perhitungan <i class="fas fa-arrow-right"></i>
                              </span>
                            </a> -->
									</div>
									
									
									

								</div>