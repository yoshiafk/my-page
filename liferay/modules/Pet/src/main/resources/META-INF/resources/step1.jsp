<%@ include file="/init.jsp"%>
<%@ page import="com.mypage.product.pet.helpers.MypageHelpers" %>

<%
	PetDisplayContext petDisplayContext = new PetDisplayContext(liferayPortletRequest, liferayPortletResponse);
%>
<%
	List<PetPlan> petPlans = PetPlanLocalServiceUtil.getPetPlans();
	PetPlan recommendedPlan = null;
	if (petPlans != null) {
		List<PetPlan> _recommendedPlans = PetPlanLocalServiceUtil.getRecommendedPlans();
		if (_recommendedPlans.size() > 0) {
			recommendedPlan = _recommendedPlans.get(0);
		}
	}
%>

<%
String lrToPimcKycMiddlewareUrl = (String)renderRequest.getAttribute("lrToPimcKycMiddlewareUrl");
String aParam = !Validator.isNull((String) renderRequest.getAttribute("aParam")) ? (String) renderRequest.getAttribute("aParam") : ""; // a param
%>



<portlet:renderURL var="step2URL">
	<portlet:param name="mvcPath" value="/step2.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="step1_2URL">
	<portlet:param name="mvcPath" value="/step1_2.jsp" />
</portlet:renderURL>

<script type="text/javascript">
      var petStep1_2URL = "<%=step1_2URL%>";
      var petStep2URL = "<%=step2URL%>";
      var aParam = "<%=aParam%>";
</script>

<liferay-util:body-bottom outputKey="petStep1BodyBottom">
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/selectize.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/moment.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/pet_general.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/step1.js"></script>
</liferay-util:body-bottom>

<%-- PRODUCT TITLE --%>
<%@ include file="/includes/jsp/product_title.jsp"%>

<%-- BREADCRUMBS --%>
<%
	int stepNumber = 1;
	boolean stepHalf = true;
%>
<%@ include file="/includes/jsp/breadcrumb.jsp"%>

<%@ include file="/includes/jsp/product_desc.jsp" %>

<%-- CONTENT START --%>
<section id="step1-page" class="content-section" data-error="" data-recommendedselect="false">
	<div class="container">
		<div class="row">

			<%-- CONTENT --%>
			<div class="col-lg-8 col-md-8">
			
			    <div class="wrapper big-pad mb-30">
      <div class="title">
        <h3>Periode Polis</h3>
      </div>

      <div class="content mt-30 mb-30">
        <div class="row">
          <div class="col-lg-10">
            <div class="row">
              <div class="form-group col-md-6">
                <label class="fz-16 semi-bold mandatory" for="StartDate">Tanggal Aktif Polis</label>
                <div class="date">
                  <input type="text" class="form-control input-gray semi-bold datepicker change required" id="StartDate" name="StartDate" placeholder="Tanggal Aktif Polis" value="" autocomplete="off"/>
                  <div class="icon"><i class="fas fa-calendar-alt"></i></div>
                </div>
              </div>
              <div class="form-group col-md-6">
                <label class="fz-16 semi-bold mandatory" for="ExpiredDate">Berlaku Hingga</label>
                <div class="date">
                  <input type="text" class="form-control input-gray semi-bold change required" id="ExpiredDate" name="ExpiredDate" placeholder="Berlaku Hingga" value="" readonly />
                  <div class="icon"><i class="fas fa-calendar-alt"></i></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
				<div class="wrapper">
					<div class="title">
						<h3>Pilih Proteksi Terbaikmu</h3>
					</div>
					<div class="content">
						<form novalidate="novalidate">

							<%-- RECOMMENDED PLAN --%>
							<%
								if (recommendedPlan != null) {
							%>

							<div class="recomended-plan">
								<div class="title">
								<% 	String recomName = MypageHelpers.capitalizeEachWord(recommendedPlan.getName());%>
									<h4><%=recomName%>
										<img class="hover ml-3"
											src="<%=themeDisplay.getPathThemeImages() + "/mypage/icons/recommended.svg"%>"
											alt="specialoffer" data-container="body" data-toggle="popover" data-placement="top"
											data-content="Recommended for you">
									</h4>
								</div>
								<div class="plan-box">
									<%
										if (Validator.isNotNull(recommendedPlan.getBenefit())) {
									%>
									<div class="plan-section">
										<p>
											<b>Keunggulan Produk</b>
										</p>
										<p><%=recommendedPlan.getBenefit()%></p>
									</div>
									<%
										}
									%>

									<div class="plan-section">
										<p>Kematian dan Cacat Tetap Total akibat Kecelakaan</p>
										<span class="fz-11"><i>Maksimal</i></span>
										<%
											String recommendedLimitDisability = NumberFormatHelper
														.formatNumber(recommendedPlan.getLimitDisability());
										%>
										<span class="fz-25 bold">IDR <%=recommendedLimitDisability%></span> <span class="fz-11"><i>(secara
												agregat)</i></span>
										<div class="">
											<div class="row mt-4">
												<div class="col">
													<span>Biaya Pengobatan Hewan Peliharaan karena cidera akibat Kecelakaan</span> <span
														class="fz-11"><i>Maksimal</i></span>
													<%
														String recommendedLimitMedical = NumberFormatHelper.formatNumber(recommendedPlan.getLimitMedical());
													%>
													<span class="fz-20 bold">IDR <%=recommendedLimitMedical%></span> <span class="fz-11"><i>(secara
															agregat)</i></span>
												</div>
												<div class="col">
													<span>Tanggung Jawab Hukum Terhadap Pihak Ketiga</span> <span class="fz-11"><i>(Biaya
															pencegahan/pengobatan rabies terhadap pihak ketiga)</i></span> <span class="fz-11"><i>Maksimal</i></span>
													<%
														String recommendedLimitThirdParty = NumberFormatHelper
																	.formatNumber(recommendedPlan.getLimitThirdParty());
													%>
													<span class="fz-20 bold">IDR <%=recommendedLimitThirdParty%></span> <span
														class="fz-11"><i>(secara agregat)</i></span>
												</div>
												<div class="col">
													<span>Biaya Tambahan Penitipan Hewan akibat keterlambatan pesawat </span> <span
														class="fz-11"><i>Maksimal</i></span>
													<%
														String recommendedLimitCustody = NumberFormatHelper.formatNumber(recommendedPlan.getLimitCustody());
													%>
													<span class="fz-20 bold">IDR <%=recommendedLimitCustody%></span> <span class="fz-11"><i>(secara
															agregat)</i></span>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="radio-btn blue text-center">
									<input type="radio" id="recommended-plan" name="Plan" class="plan change"
										value="<%=recommendedPlan.getPetPlanId()%>" /> <label class="btn-block bold"
										for="recommended-plan">Pilih Plan</label>
								</div>
							</div>
							<%
								}
							%>
							<%-- END RECOMMENDED PLAN --%>

							<!-- OTHER PLAN -->
							<div class="other-plans">
								<div class="wrapper mt-5">
									<div class="title medium">
										<h3 class="semi-bold text-center text-uppercase text-collapse" data-toggle="collapse"
											href="#collapseOtherPlans" aria-expanded="false">Other Plans You Might Want to Look
											At</h3>
									</div>

									<div class="collapse" id="collapseOtherPlans">
										<div class="plans">
											<div class="item">
												<div class="row">
													<div class="col-3">
														<span><strong>Jenis Plan</strong></span>
													</div>
													<div class="col text-center">
														<span><strong>Kematian dan Cacat Tetap Total akibat Kecelakaan</strong> </span>
													</div>
													<div class="col text-center d-none">
														<span class="light">Keunggulan</span>
													</div>
													<div class="col"></div>
												</div>
											</div>

											<!--  LOOPING PLANS -->
											<%
												if (!Validator.isNull(petPlans)) {
											%>
											<%
												int keyloop = 0;
											%>
											<%
												for (PetPlan _plan : petPlans) {
											%>
											<%
												if (_plan.getPetPlanId() == recommendedPlan.getPetPlanId()) {
															continue;
														}
											%>
											<div class="item">
												<div class="row">
													<div class="col-3">
														<span class="semi-bold c-blue-500">
														<%=_plan.getName()%> <% if (_plan.getCustomPlan() > 0) { %><br />
														<i class="fz-12">* Limit pertanggungan flexible</i>
														<% } %>
														</span>
													</div>

													<div class="col text-center">
														<span class="fz-11"><i>Maksimal &nbsp;</i></span>
														<%
															String planLimitDisability = NumberFormatHelper.formatNumber(_plan.getLimitDisability());
														%>
														<span class="semi-bold">IDR <%=planLimitDisability%></span> <span class="fz-11"><i>
																&nbsp;(secara agregat)</i></span>
													</div>

													<div class="col text-center d-none">
														<ul class="list-inline icons">
															<li class="list-inline-item"><img
																src="<%=themeDisplay.getPathThemeImages() + "/mypage/icons/health/axa-icon-medical-assistance.svg"%>"
																alt="axa-icon-medical-assistance" data-toggle="tooltip" data-placement="top"
																title="Medical Assistance"></li>
														</ul>
													</div>

													<div class="col">
														<div class="radio-btn yellow text-center">
															<input data-custom="<%= _plan.getCustomPlan() %>" type="radio" id="plan<%=keyloop + 1%>" name="Plan"
																class="plan itemplan change" value="<%=_plan.getPetPlanId()%>" /> <label
																class="btn-block" for="plan<%=keyloop + 1%>">Pilih Plan</label> <span
																class="text-collapse c-blue-500 f-12 semi-bold" data-toggle="collapse"
																data-target="#collapseReadMore<%=keyloop + 1%>" aria-expanded="false">selengkapnya</span>
														</div>
													</div>

													<div class="collapse" id="collapseReadMore<%=keyloop + 1%>">
														<div class="col-lg-12">
															<div class="card card-body mt-3 bg-none read-more-content text-center">
																<div class="row">
																	<div class="col-12">
																		<h4>Manfaat Lainnya</h4>
																	</div>

																	<div class="col-6">
																		<p>Biaya Pengobatan Hewan Peliharaan karena cidera akibat Kecelakaan</p>
																		<%
																			String planLimitMedical = NumberFormatHelper.formatNumber(_plan.getLimitMedical());
																		%>
																		<strong>Maksimal Rp. <%=planLimitMedical%> secara agregat
																		</strong>
																	</div>

																	<div class="col-6">
																		<p>Biaya Tambahan Penitipan Hewan akibat keterlambatan pesawat</p>
																		<%
																			String planLimitCustody = NumberFormatHelper.formatNumber(_plan.getLimitCustody());
																		%>
																		<strong>Maksimal Rp. <%=planLimitCustody%> secara agregat
																		</strong>
																	</div>

																	<div class="col-6 ml-auto mr-auto mt-3">
																		<p>Tanggung Jawab Hukum Terhadap Pihak Ketiga (Biaya pencegahan/pengobatan
																			rabies terhadap pihak ketiga)</p>
																		<%
																			String planLimitThirdParty = NumberFormatHelper.formatNumber(_plan.getLimitThirdParty());
																		%>
																		<strong>Maksimal Rp. <%=planLimitThirdParty%> secara agregat
																		</strong>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<%
												keyloop++;
											%>
											<%
												}
											%>
											<%
												}
											%>
											<!--  END LOOPING PLANS -->
										</div>
									</div>
								</div>
							</div>
							<!-- OTHER PLAN END -->

							<input class="change" name="Step1" type="hidden" value="1" />
						</form>
					</div>
				</div>
			</div>
			<!-- END CONTENT -->

			<!-- MOBILE -->
			<div class="col-md-12 d-sm-block d-md-none mt-20">
				<button type="button" class="btn btn-yellow-box btn-block semi-bold small next-step" disabled>
					Selanjutnya <i class="fas fa-arrow-right"></i>
				</button>
			</div>

			<div class="mobile-sidebar fixed-bottom" data-toggle="collapse" data-target="#sidebar-responsive"
				aria-expanded="false" aria-controls="sidebar-responsive">
				<div class="row">
					<div class="col">
						<span>TOTAL BIAYA</span>
					</div>
					<div class="col NetPremium text-right">
						<span>Rp. </span><span class="amount">-</span>
					</div>
				</div>
			</div>
			<!-- END MOBILE -->

			<!-- SIDEBAR -->
			<div class="col-lg-4 col-md-4 sidebar-wrapper">
				<div id="sidebar-responsive" class="sticky-top sidebar-responsive collapse">
					<div class="sidebar-responsive-wrap">
						<!--  RINGKASAN PRODUK -->
						<%@ include file="/includes/jsp/summary.jsp"%>
						<!--  END RINGKASAN PRODUK -->

						<div class="wrapper sidebar">
							<div class="title gray">
								<h4>Keunggulan Produk AXA</h4>
							</div>

							<div class="content">
								<!-- BENEFIT -->
								<%@ include file="/includes/jsp/benefits.jsp"%>
								<!--  END BENEFIT -->
							</div>
						</div>

						<div class="wrapper sidebar">
							<div class="title blue">
								<h4>Rincian</h4>
							</div>

							<div class="content small-pad">
								<!-- SUMMARY TRANSAKSI -->
								<%@ include file="/includes/jsp/transaction_summary.jsp"%>
								<!-- END SUMMARY TRANSAKSI -->

								<div class="sidebar-pad mt-3 btn-next">
									<button type="button" class="btn btn-yellow-box btn-block bold next-step" disabled>
										Selanjutnya <i class="fas fa-arrow-right"></i>
									</button>
								</div>

								<!--  ICONS -->
								<%@ include file="/includes/jsp/icons.jsp"%>
								<!-- END ICONS -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END SIDEBAR -->
		</div>
	</div>
</section>

<section class="content-section freq-asked">
	<div class="container">
		<div class="row">
			<!-- CONTENT START -->
			<div class="col-lg-12">
				<div class="wrapper">
					<div class="title">
						<h3>Frequently Asked Question</h3>
					</div>
					<div class="content">
						<ul class="list-group list-group-border mt-4 mb-4">
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-1" role="button" aria-expanded="false" aria-controls="collapse-list-1">
									Apakah biaya pengobatan dijamin? </a>
								<div class="collapse" id="collapse-list-1">
									<div class="mt-4 pr-5">
										<p>Biaya pengobatan yang dijamin hanya akibat kecelakaan saja, untuk akibat sakit
											tidak dijamin, karena dasar dari produk ini adalah kecelakaan diri.</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-2" role="button" aria-expanded="false" aria-controls="collapse-list-2">
									Hewan apa saja yang bisa dicover? </a>
								<div class="collapse" id="collapse-list-2">
									<div class="mt-4 pr-5">
										<p>Untuk hewan peliharan yang bisa dijamin adalah anjing dan kucing yang mempunyai
											sertifikat resmi (anjing dari PERKIN, untuk kucing dari ICA)</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-3" role="button" aria-expanded="false" aria-controls="collapse-list-3">
									Berapa usia hewan yang dapat diasuransikan? </a>
								<div class="collapse" id="collapse-list-3">
									<div class="mt-4 pr-5">
										<p>Hewan peliharaan yang dapat diasuransikan dimulai 30 hari sampai dengan maksimal 10
											tahun (9 tahun untuk pertama kali diasuransikan).</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-4" role="button" aria-expanded="false" aria-controls="collapse-list-4">
									Apabila hewan peliharaan mengalami kecelakaan dan dibutuhkan tambahan vaksin apakah
									dijamin? </a>
								<div class="collapse" id="collapse-list-4">
									<div class="mt-4 pr-5">
										<p>Ya, jika vaksin tersebut dibutuhkan untuk pengobatan akibat kecelakaan dijamin,
											jika tidak terkait untuk kecelakaannya, tidak dijamin.</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-5" role="button" aria-expanded="false" aria-controls="collapse-list-5">
									Apabila hewan peliharaan keracunan kemudian meninggal dunia, apakah dijamin? </a>
								<div class="collapse" id="collapse-list-5">
									<div class="mt-4 pr-5">
										<p>Ya, jika keracunan tersebut adalah tindakan tidak disengaja, kecuali Tertanggung
											dengan sengaja memberikan obat-obatan atau zat lainvkepada hewan peliharaan tanpa resep
											dari dokter hewan.</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-6" role="button" aria-expanded="false" aria-controls="collapse-list-6">
									Apabila hewan peliharaan dicuri, apakah dijamin? </a>
								<div class="collapse" id="collapse-list-6">
									<div class="mt-4 pr-5">
										<p>Tidak, Pencurian tidak dijamin, masuk ke dalam pengecualian polis.</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-7" role="button" aria-expanded="false" aria-controls="collapse-list-7">
									Apabila hewan peliharaan Anda menggigit orang serumah apakah biaya vaksin dijamin? </a>
								<div class="collapse" id="collapse-list-7">
									<div class="mt-4 pr-5">
										<p>Tidak, yang dijamin apabila hewan peliharaan menggigit orang lain selain dari orang
											yang tinggal serumah dengan Anda atau anggota keluarga dekat Anda atau yang dipekerjakan
											oleh Anda</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-8" role="button" aria-expanded="false" aria-controls="collapse-list-8">
									Jika hewan peliharaan Anda dirawat inap tetapi menurut dokter hewan tidak diperlukan apakah
									biaya tersebut dapat diklaim? </a>
								<div class="collapse" id="collapse-list-8">
									<div class="mt-4 pr-5">
										<p>Tidak, jika tidak disarankan oleh dokter hewan maka biaya rawat inap tidak
											ditanggung.</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-9" role="button" aria-expanded="false" aria-controls="collapse-list-9">
									Jika hewan peliharaan Anda terlepas dan menggigit orang lain yang sedang lewat, apakah
									biaya pengobatan orang tersebut dijamin? </a>
								<div class="collapse" id="collapse-list-9">
									<div class="mt-4 pr-5">
										<p>Biaya yang dijamin adalah Biaya yang diperlukan untuk pemberian Vaksin Rabies saja,
											untuk biaya pengobatan lainnya terhadap orang tersebut tidak dijamin.</p>
									</div>
								</div></li>
							<li class="list-group-item"><a class="collapse-a" data-toggle="collapse"
								href="#collapse-list-10" role="button" aria-expanded="false"
								aria-controls="collapse-list-10"> Apabila Anda melakukan perjalanan dan hewan peliharaan
									dititipkan di tempat penitipan hewan, tetapi Anda berencana untuk memperpanjang liburan
									Anda, apakah biaya tambahan penitipan hewan ter </a>
								<div class="collapse" id="collapse-list-10">
									<div class="mt-4 pr-5">
										<p>Tidak dijamin, yang dijamin adalah apabila keterlambatan jadwal kedatangan dari
											pesawat Tertanggung karena cuaca buruk, kerusakan mekanis atau penutupan bandara atau
											yang disebabkan oleh suatu kejadian diluar kendali Tertanggung.</p>
									</div>
								</div></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="/includes/jsp/cookie.jsp"%>