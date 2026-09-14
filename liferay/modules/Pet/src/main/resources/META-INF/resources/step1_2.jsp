<%@ include file="/init.jsp"%>

<%
List<PetPlan> petPlans = PetPlanLocalServiceUtil.getPetPlans();
PetPlan customPlan = (PetPlan)renderRequest.getAttribute("CustomPlan");
%>

<portlet:renderURL var="step2URL">
	<portlet:param name="mvcPath" value="/step2.jsp"></portlet:param>
</portlet:renderURL>

<script type="text/javascript">
      var petStep2URL = "<%=step2URL%>";
</script>

<liferay-util:body-bottom outputKey="petStep1BodyBottom">
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/selectize.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/moment.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/pet_general.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/step1_2.js"></script>
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

<!-- CONTENT START -->
<section id="step1-page" data-customplan="<%= customPlan.getPetPlanId() %>" class="content-section mb-50">
    <div class="container">
        <div class="row">
            <!-- CONTENT START -->
            <div class="col-lg-8 col-md-8">
                <form novalidate="novalidate" autocomplete="off">
                    <fieldset id="form-fieldset">
                        <div class="wrapper big-pad">
                            <div class="title">
                                <h3>Limit Pertanggungan</h3>
                            </div>
                            <div class="content mt-30 mb-30">
                                <div id="alert-plan" class="alert alert-danger mb-30 d-none" role="alert">
                                    <i class="fal fa-exclamation-circle fa-fw"></i> Untuk mengatur limit pertanggungan Anda harus memilih <b>Plan Flexible</b>
                                </div>

                                <div class="row">
                                    <div class="form-group col-lg-12 col-md-12 box-line">
                                        <div class="form-check checkbox-custom yellow">
                                            <input name="UserCustom" class="form-check-input" type="checkbox" id="UserCustom" value="1">
                                            <label class="form-check-label bold" for="UserCustom">
                                                Atur sendiri limit pertanggungan paket pilihan saya
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                
                            	<div class="row">
								    <div class="form-group col-lg-12 mb-30">
								        <label class="fz-16 semi-bold mandatory mb-2" for="remarks_a">Kematian dan Cacat Tetap Total akibat Kecelakaan</label>
								        <div class="row">
								            <div class="input-group col-lg-10">
								                <div class="input-group-prepend">
								                    <span class="input-group-text" id="basic-addon1">Rp</span>
								                </div>
								                <input type="text" class="form-control input-gray semi-bold remarks-input pl-3" placeholder="Kematian dan Cacat Tetap Total akibat Kecelakaan" value="<%= customPlan.getLimitDisability() %>" maxlength="22" data-mask="RP 000.000.000.000.000" data-mask-reverse="true">
								                <input data-default="<%= customPlan.getLimitDisability() %>" type="hidden" class="remarks-value hidden-required" id="remarks_a" name="LimitDisability" value="<%= customPlan.getLimitDisability() %>">
								            </div>
								        </div>
								    </div>
								</div>
								
								<div class="row">
								    <div class="form-group col-lg-12 mb-30">
								        <label class="fz-16 semi-bold mandatory mb-2" for="remarks_b">Biaya Pengobatan Hewan Peliharaan karena cidera akibat Kecelakaan</label>
								        <div class="row">
								            <div class="input-group col-lg-10">
								                <div class="input-group-prepend">
								                    <span class="input-group-text" id="basic-addon1">Rp</span>
								                </div>
								                <input type="text" class="form-control input-gray semi-bold remarks-input pl-3" placeholder="Biaya Pengobatan Hewan Peliharaan karena cidera akibat Kecelakaan" value="<%= customPlan.getLimitMedical() %>" maxlength="22" data-mask="RP 000.000.000.000.000" data-mask-reverse="true">
								                <input data-default="<%= customPlan.getLimitMedical() %>" type="hidden" class="remarks-value hidden-required" id="remarks_b" name="LimitMedical" value="<%= customPlan.getLimitDisability() %>">
								            </div>
								        </div>
								    </div>
								</div>
								
								<div class="row">
								    <div class="form-group col-lg-12 mb-30">
								        <label class="fz-16 semi-bold mandatory mb-2" for="remarks_c">Tanggung Jawab Hukum Terhadap Pihak Ketiga (Biaya pencegahan/pengobatan rabies terhadap pihak ketiga)</label>
								        <div class="row">
								            <div class="input-group col-lg-10">
								                <div class="input-group-prepend">
								                    <span class="input-group-text" id="basic-addon1">Rp</span>
								                </div>
								                <input type="text" class="form-control input-gray semi-bold remarks-input pl-3" placeholder="Tanggung Jawab Hukum Terhadap Pihak Ketiga (Biaya pencegahan/pengobatan rabies terhadap pihak ketiga)" value="<%= customPlan.getLimitThirdParty() %>" maxlength="22" data-mask="RP 000.000.000.000.000" data-mask-reverse="true">
								                <input data-default="<%= customPlan.getLimitThirdParty() %>" type="hidden" class="remarks-value hidden-required" id="remarks_c" name="LimitThirdParty" value="<%= customPlan.getLimitThirdParty() %>">
								            </div>
								        </div>
								    </div>
								</div>
								
								<div class="row">
								    <div class="form-group col-lg-12 mb-30">
								        <label class="fz-16 semi-bold mandatory mb-2" for="remarks_d">Biaya Tambahan Penitipan Hewan akibat keterlambatan pesawat</label>
								        <div class="row">
								            <div class="input-group col-lg-10">
								                <div class="input-group-prepend">
								                    <span class="input-group-text" id="basic-addon1">Rp</span>
								                </div>
								                <input type="text" class="form-control input-gray semi-bold remarks-input pl-3" placeholder="Biaya Tambahan Penitipan Hewan akibat keterlambatan pesawat" value="<%= customPlan.getLimitCustody() %>" maxlength="22" data-mask="RP 000.000.000.000.000" data-mask-reverse="true">
								                <input data-default="<%= customPlan.getLimitCustody() %>" type="hidden" class="remarks-value hidden-required" id="remarks_d" name="LimitCustody" value="<%= customPlan.getLimitCustody() %>">
								            </div>
								        </div>
								    </div>
								</div>
                            </div>
                        </div>
                    </fieldset>
                    <input class="change" name="Step1_2" type="hidden" value="1">
                </form>
            </div>
            <!-- CONTENT END -->

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
<!-- CONTENT START -->

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