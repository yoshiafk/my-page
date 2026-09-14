<%@ include file="/init.jsp" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>

<% 
	String aParam = !Validator.isNull((String) renderRequest.getAttribute("aParam")) ? (String) renderRequest.getAttribute("aParam") : ""; // a param
	List<PetPlan> petPlans = PetPlanLocalServiceUtil.getPetPlans();
	PetPlan recommendedPlan = null;
	
	if(petPlans != null) { 
		List<PetPlan>_recommendedPlans = PetPlanLocalServiceUtil.getRecommendedPlans();
		
		if(_recommendedPlans.size() > 0) { 
			recommendedPlan = _recommendedPlans.get(0); 
		} 
	}
	
    // Format the date as "yyyy-MM-dd"
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
	 // Pet Min Age
    Calendar petMinAgecalendar = Calendar.getInstance();
    petMinAgecalendar.add(Calendar.MONTH, -1);
    String petMinAge = sdf.format(petMinAgecalendar.getTime());
    
    // Pet Max Age
    Calendar petMaxAgecalendar = Calendar.getInstance();
    petMaxAgecalendar.add(Calendar.YEAR	, -10);
    String petMaxAge = sdf.format(petMaxAgecalendar.getTime());
%>

<portlet:renderURL var="step4URL">
	<portlet:param name="mvcPath" value="/step4.jsp"></portlet:param>
</portlet:renderURL>

<script type="text/javascript">
var petStep4URL = '<%= step4URL%>';
var aParam = "<%=aParam%>";
</script>

<liferay-util:body-bottom outputKey="petStep3BodyBottom">
<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery.date-dropdowns.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/selectize.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/moment.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery.mask.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/bs-custom-file-input.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/pet_general.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/step3.js"></script>
</liferay-util:body-bottom> 

	<%@ include file="/includes/jsp/product_title.jsp" %>
	
	<% int stepNumber = 3; boolean stepHalf = false; %>
	<%@ include file="/includes/jsp/breadcrumb.jsp" %>
	
	<section class="content-section">
    <div class="container">
        <div class="row">
        
        <!-- CONTENT -->
<div class="col-lg-8 col-md-8">
  <form novalidate="novalidate" autocomplete="off">
    <div class="wrapper big-pad mb-30">
      <div class="title">
        <h3>Data Hewan Peliharaan</h3>
      </div>

      <div class="content mt-30 mb-30">
        <div class="row">
          <div class="form-group col-lg-7 col-md-12 mb-30">
            <label class="fz-16 semi-bold mandatory mb-2" for="PetName">Nama Hewan Peliharaan</label>
            <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="PetName" name="PetName" placeholder="Nama Hewan Peliharaan" value="" maxlength="30" data-mask="N" />
          </div>

          <div class="form-group col-lg-5 col-md-6 mb-30">
            <label for="PetType" class="fz-16 semi-bold mb-2 mandatory">Jenis Hewan Peliharaaan</label>
            <select id="PetType" class="form-control select-gray semi-bold selectize change required" name="PetType" required>
              <option value="">Jenis Hewan</option>
              <option value="kucing">Kucing</option>
              <option value="anjing">Anjing</option>
            </select>
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-12 col-md-12 mb-30">
            <label class="fz-16 semi-bold mandatory mb-2">Jenis Kelamin</label>
            <div>
              <div class="radio-btn gender custom-control-inline mr-30">
                <input type="radio" id="male" name="PetGender" class="custom-control-input change required" value="M" />
                <label class="justify-content-center pr-2 pl-2" for="male"><i class="fas fa-mars sz-14 mr-2 c-blue-100"></i>JANTAN</label>
              </div>
              <div class="radio-btn gender custom-control-inline">
                <input type="radio" id="female" name="PetGender" class="custom-control-input change required" value="F" />
                <label class="justify-content-center pr-2 pl-2" for="female"><i class="fas fa-venus sz-14 mr-2 c-blue-100"></i>BETINA</label>
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-7 col-md-12 mb-30">
            <label for="PetDob" class="semi-bold mandatory fz-16">Tanggal Lahir</label>
            <input data-name="PetDob" data-msg-required="Tanggal lahir wajib diisi" type="text" id="PetDob" class="datedropdown change required" name="PetDob" value="" data-min="<%= petMinAge %>" data-max="<%= petMaxAge %>" />
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-12 mb-30">
            <label class="fz-16 semi-bold mandatory" for="PetIdNumber">No. Sertifikat / Akta Kelahiran Hewan Peliharaan</label>
            <div class="row">
              <div class="col-lg-7">
                <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="PetIdNumber" name="PetIdNumber" placeholder="Nomor Sertifikat" value="" minlength="5" maxlength="24" data-mask="D" />
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-12 mb-30">
            <label class="fz-16 semi-bold mandatory" for="PetIdNumberIssuing">Lembaga yang menerbitkan Sertifikat / Akta kelahiran</label>
            <div class="row">
              <div class="col-lg-7">
                <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="PetIdNumberIssuing" name="PetIdNumberIssuing" placeholder="Nama Lembaga" value="" maxlength="50" data-mask="D" />
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-12 col-md-12 mb-30">
            <label class="fz-16 semi-bold mandatory" for="PetLocation">Lokasi Pemeliharaan</label>
            <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="PetLocation" name="PetLocation" placeholder="Lokasi Pemeliharaan" value="" maxlength="100" data-mask="D" />
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-12 col-md-12 box-line">
            <div class="form-check checkbox-custom yellow">
              <input name="PetVaccine" class="form-check-input change required" type="checkbox" id="PetVaccine" />
              <label class="form-check-label fz-11" for="PetVaccine"> Hewan peliharaan yang diasuransikan pernah mendapatkan vaksinasi rabies sesuai rekomendasi dokter </label>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-12 col-md-12 box-line">
            <div class="form-check checkbox-custom yellow">
              <input name="PetAuthorizedCertificate" class="form-check-input change required" type="checkbox" id="PetAuthorizedCertificate" />
              <label class="form-check-label fz-11" for="PetAuthorizedCertificate"> Hewan peliharaan yang diasuransikan memiliki sertifikat resmi yaitu Anjing yang memiliki sertifikat dari PERKIN atau Kucing yang memiliki sertifikat dari ICA. </label>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="wrapper big-pad">
      <div class="title">
        <h3>Upload Files</h3>
      </div>

      <div class="content mt-30 mb-30">
        <div class="row">
          <div class="form-group col-lg-12 mb-30">
            <span class="span-label fz-16 semi-bold mandatory">Upload Sertifikat / Akta Kelahiran Hewan Peliharaan</span>
            <div class="row">
              <div class="col-lg-8">
                <div class="uploaded-wrappper" id="PetIdNumberUploadedWrapper"></div>
                <div class="custom-file custom-file-grey">
                  <input name="PetIdNumberFile" type="file" class="custom-file-input semi-bold" id="customFile" />
                  <input name="PetIdNumberFileHidden" type="hidden" class="form-control input-gray semi-bold PetIdNumberFileHidden hidden-required" value="" />
                  <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="form-group col-lg-8 col-md-12 mb-30">
            <span class="span-label fz-16 semi-bold mandatory">Upload Foto Hewan Peliharaan</span>
            <div class="uploaded-wrappper" id="PetPhotoUploadedWrapper"></div>
            <div class="custom-file custom-file-grey">
              <input name="PetPhoto" type="file" class="custom-file-input semi-bold" id="customFile" />
              <input name="PetPhotoHidden" type="hidden" class="form-control input-gray semi-bold PetPhotoHidden hidden-required" value="" />
              <label class="custom-file-label" for="customFile">Choose file</label>
            </div>
          </div>
        </div>

        <hr />

        <div class="form-group mt-30">
          <div class="form-check checkbox-custom yellow">
            <input class="form-check-input change required" type="checkbox" name="TnCPhoto" value="" id="photo-checkbox" />
            <label for="photo-checkbox" class="form-check-label fz-11" for="photo-checkbox"> Harap dipastikan foto yang Anda upload adalah foto terbaru sesuai dengan kondisi saat ini. Kami berhak menolak klaim apabila ada kecurangan terhadap foto yang diberikan. </label>
          </div>
        </div>
      </div>
    </div>

    <input class="change" name="Step3" type="hidden" value="1" />
  </form>
</div>
<!-- END CONTENT -->
        
        <!-- MOBILE -->
                    <div class="col-md-12 d-sm-block d-md-none mt-20">
                <button type="button" class="btn btn-yellow-box btn-block semi-bold small next-step" disabled>Selanjutnya <i class="fas fa-arrow-right"></i></button>
                <div class="next-info-error fz-11 c-red pt-1"><i>*Lengkapi data pada form diatas terlebih dahulu <span class="check-validate c-pointer" data-toggle="tooltip" data-placement="top" title="Check form yang belum terisi"><b>(Check)</b></span></i></div>
            </div>

            <div class="mobile-sidebar fixed-bottom" data-toggle="collapse" data-target="#sidebar-responsive" aria-expanded="false" aria-controls="sidebar-responsive">
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
					<%@ include file="/includes/jsp/summary.jsp" %>
					<!--  END RINGKASAN PRODUK -->
                        
                        <div class="wrapper sidebar">
                            <div class="title blue">
                                <h4>Rincian</h4>
                            </div>

                            <div class="content small-pad">
                            
                                <!-- SUMMARY TRANSAKSI -->
								<%@ include file="/includes/jsp/transaction_summary.jsp" %>
								<!-- END SUMMARY TRANSAKSI -->


                                <div class="sidebar-pad mt-3 btn-next">
                                    <button type="button" class="btn btn-yellow-box btn-block bold next-step" disabled>Selanjutnya <i class="fas fa-arrow-right"></i></button>
                                    <div class="next-info-error fz-11 c-red pt-1"><i>*Lengkapi data pada form disamping terlebih dahulu <span class="check-validate c-pointer" data-toggle="tooltip" data-placement="top" title="Check form yang belum terisi"><b>(Check)</b></span></i></div>
                                </div>

                                <!--  ICONS -->
								<%@ include file="/includes/jsp/icons.jsp" %>
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
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-1" role="button" aria-expanded="false" aria-controls="collapse-list-1">
                                            Apakah biaya pengobatan dijamin?                                        </a>
                                        <div class="collapse" id="collapse-list-1">
                                            <div class="mt-4 pr-5">
                                                <p>Biaya pengobatan yang dijamin hanya akibat kecelakaan saja, untuk akibat sakit tidak dijamin, karena dasar dari produk ini adalah kecelakaan diri.</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-2" role="button" aria-expanded="false" aria-controls="collapse-list-2">
                                            Hewan apa saja yang bisa dicover?                                        </a>
                                        <div class="collapse" id="collapse-list-2">
                                            <div class="mt-4 pr-5">
                                                <p>Untuk hewan peliharan yang bisa dijamin adalah anjing dan kucing yang mempunyai sertifikat resmi (anjing dari PERKIN, untuk kucing dari ICA)</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-3" role="button" aria-expanded="false" aria-controls="collapse-list-3">
                                            Berapa usia hewan yang dapat diasuransikan?                                        </a>
                                        <div class="collapse" id="collapse-list-3">
                                            <div class="mt-4 pr-5">
                                                <p>Hewan peliharaan yang dapat diasuransikan dimulai 30 hari sampai dengan maksimal 10 tahun (9 tahun untuk pertama kali diasuransikan).</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-4" role="button" aria-expanded="false" aria-controls="collapse-list-4">
                                            Apabila hewan peliharaan mengalami kecelakaan dan dibutuhkan tambahan vaksin apakah dijamin?                                        </a>
                                        <div class="collapse" id="collapse-list-4">
                                            <div class="mt-4 pr-5">
                                                <p>Ya, jika vaksin tersebut dibutuhkan untuk pengobatan akibat kecelakaan dijamin, jika tidak terkait untuk kecelakaannya, tidak dijamin.</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-5" role="button" aria-expanded="false" aria-controls="collapse-list-5">
                                            Apabila hewan peliharaan keracunan kemudian meninggal dunia, apakah dijamin?                                        </a>
                                        <div class="collapse" id="collapse-list-5">
                                            <div class="mt-4 pr-5">
                                                <p>Ya, jika keracunan tersebut adalah tindakan tidak disengaja, kecuali Tertanggung dengan sengaja memberikan obat-obatan atau zat lainvkepada hewan peliharaan tanpa resep dari dokter hewan.</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-6" role="button" aria-expanded="false" aria-controls="collapse-list-6">
                                            Apabila hewan peliharaan dicuri, apakah dijamin?                                        </a>
                                        <div class="collapse" id="collapse-list-6">
                                            <div class="mt-4 pr-5">
                                                <p>Tidak, Pencurian tidak dijamin, masuk ke dalam pengecualian polis.</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-7" role="button" aria-expanded="false" aria-controls="collapse-list-7">
                                            Apabila hewan peliharaan Anda menggigit orang serumah apakah biaya vaksin dijamin?                                        </a>
                                        <div class="collapse" id="collapse-list-7">
                                            <div class="mt-4 pr-5">
                                                <p>Tidak, yang dijamin apabila hewan peliharaan menggigit orang lain selain dari orang yang tinggal serumah dengan Anda atau anggota keluarga dekat Anda atau yang dipekerjakan oleh Anda</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-8" role="button" aria-expanded="false" aria-controls="collapse-list-8">
                                            Jika hewan peliharaan Anda dirawat inap tetapi menurut dokter hewan tidak diperlukan apakah biaya tersebut dapat diklaim?                                        </a>
                                        <div class="collapse" id="collapse-list-8">
                                            <div class="mt-4 pr-5">
                                                <p>Tidak, jika tidak disarankan oleh dokter hewan maka biaya rawat inap tidak ditanggung.</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-9" role="button" aria-expanded="false" aria-controls="collapse-list-9">
                                            Jika hewan peliharaan Anda terlepas dan menggigit orang lain yang sedang lewat, apakah biaya pengobatan orang tersebut dijamin?                                        </a>
                                        <div class="collapse" id="collapse-list-9">
                                            <div class="mt-4 pr-5">
                                                <p>Biaya yang dijamin adalah Biaya yang diperlukan untuk pemberian Vaksin Rabies saja, untuk biaya pengobatan lainnya terhadap orang tersebut tidak dijamin.</p>
                                            </div>
                                        </div>
                                    </li>
                                                                    <li class="list-group-item">
                                        <a class="collapse-a" data-toggle="collapse" href="#collapse-list-10" role="button" aria-expanded="false" aria-controls="collapse-list-10">
                                            Apabila Anda melakukan perjalanan dan hewan peliharaan dititipkan di tempat penitipan hewan, tetapi Anda berencana untuk memperpanjang liburan Anda, apakah biaya tambahan penitipan hewan ter                                        </a>
                                        <div class="collapse" id="collapse-list-10">
                                            <div class="mt-4 pr-5">
                                                <p>Tidak dijamin, yang dijamin adalah apabila keterlambatan jadwal kedatangan dari pesawat Tertanggung karena cuaca buruk, kerusakan mekanis atau penutupan bandara atau yang disebabkan oleh suatu kejadian diluar kendali Tertanggung.</p>
                                            </div>
                                        </div>
                                    </li>
                                                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>