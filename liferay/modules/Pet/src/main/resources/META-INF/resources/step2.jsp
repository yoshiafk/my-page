<%@ include file="/init.jsp" %>

<%
	String aParam = !Validator.isNull((String) renderRequest.getAttribute("aParam")) ? (String) renderRequest.getAttribute("aParam") : ""; // a param
	String _pep_wording_question_content = (String) renderRequest.getAttribute("_pep_wording_question_content");
%>

<%
	List<MasterCountry> masterCountry = MasterCountryLocalServiceUtil.getMasterCountries();
	List<MasterProvince> masterProvince = MasterProvinceLocalServiceUtil.getActiveProvinces();
	List<MasterCity> masterCities = MasterCityLocalServiceUtil.getActiveCities();
%>

<% 
	List<PetPlan> petPlans = PetPlanLocalServiceUtil.getPetPlans();
	PetPlan recommendedPlan = null;
	
	if(petPlans != null) {
		List<PetPlan>_recommendedPlans = PetPlanLocalServiceUtil.getRecommendedPlans();
		
		if(_recommendedPlans.size() > 0) {
			recommendedPlan = _recommendedPlans.get(0);
		} 
	}
%>

<portlet:renderURL var="step3URL">
	<portlet:param name="mvcPath" value="/step3.jsp"></portlet:param>
</portlet:renderURL>

<portlet:resourceURL id="/pet_upload_image" var="petUploadImageURL" />

<script type="text/javascript">
var petStep3URL = '<%= step3URL%>';
var aParam = "<%=aParam%>";
</script>

<liferay-util:body-bottom outputKey="petStep2BodyBottom">
<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery.date-dropdowns.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/selectize.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery.mask.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/pet_general.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/step2.js"></script>
</liferay-util:body-bottom> 

	<%@ include file="/includes/jsp/product_title.jsp" %>
	
		<% int stepNumber = 2; boolean stepHalf = false; %>
	<%@ include file="/includes/jsp/breadcrumb.jsp" %>

<section class="content-section">
    <div class="container">
        <div class="row">
        <!-- CONTENT -->
                    <div class="col-lg-8 col-md-8">
                <form novalidate="novalidate" autocomplete="off">
                    <div class="wrapper  big-pad">
                        <div class="title">
                            <h3>Data Calon Tertanggung</h3>
                        </div>

                        <div class="content mt-30 mb-30">
                            <div class="row">
                                <div class="form-group col-lg-12 col-md-12 mb-3">
                                
                                <!-- WEB CONTENT PERTANYAAN PEP -->
                                <label class="agent-cy-fs-18 control-label mandatory"><span><%=_pep_wording_question_content %> </span><span class="tooltip-info" data-target="#pep-modal" data-toggle="modal"><i class="fa fa-info-circle c-blue-600 axa-blue-3"></i></span></label>
                                <!-- END WEB CONTENT PERTANYAAN PEP -->
                                
                                    <div>
                                        <div class="radio-btn circle custom-control-inline mr-50">
                                            <input type="radio" id="isPepYes" name="isPep" class="custom-control-input change required" value="0">
                                            <label for="isPepYes">Tidak</label>
                                        </div>
                                        <div class="radio-btn circle custom-control-inline">
                                            <input type="radio" id="isPepNo" name="isPep" class="custom-control-input change required" value="1">
                                            <label for="isPepNo">Ya&nbsp;</label>&nbsp;<span style="color: #c91432; font-size: 12px; display: flex; align-items: center;">(Data Anda akan kami tinjau untuk melewati persetujuan dari Underwriting)</span> 
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <p>Klik tombol dibawah untuk membaca penjelasan PEP</p>
                                    <button class="btn btn-biru mb-0 text-capitalize px-3" type="button" data-target="#pep-modal" data-toggle="modal">Baca Penjelasan PEP</button>
                                    <p class="my-4" style="border-bottom: 1px solid rgb(128 128 128 / 50%);"></p>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-7 col-md-12 mb-30">
                                    <label class="fz-16 semi-bold mandatory mb-2" for="Name">Nama Lengkap Sesuai KTP/Paspor</label>
                                    <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="Name" name="Name" placeholder="Nama Lengkap Sesuai KTP/Paspor" value="" maxlength="30" data-mask="N">
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="form-group col-lg-6 col-md-12 mb-30">
                                    <label class="fz-16 semi-bold mandatory mb-2" for="BirthPlace">Tempat Lahir</label>
                                    <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="BirthPlace" name="BirthPlace" placeholder="Tempat Lahir" value="" maxlength="100" data-mask="D">
                                </div>

                                <div class="form-group col-lg-6 col-md-12 mb-30">
                                    <label for="Dob" class="semi-bold mandatory fz-16">Tanggal Lahir</label>
                                    <input data-name="Dob" data-msg-required="Tanggal lahir wajib diisi" type="text" id="Dob" class="datedropdown change required" name="Dob" value="" data-min="" data-max="">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-5 col-md-12 mb-30">
                                    <label class="fz-16 semi-bold mandatory">Kewarganegaraan</label>
                                    <select class="form-control select-gray semi-bold change required" name="NationalityCountry" required>
                                        <option value="Indonesia" >INDONESIA</option>
                                        <%
                                        if(masterCountry != null) {
                                        	for(MasterCountry _masterCountry : masterCountry) {%>
                                        		<% if(_masterCountry.getName().equals("INDONESIA")) continue; %>
                                        		<option value="<%=_masterCountry.getCountryId()%>" ><%=_masterCountry.getName()%></option>
                                        	<% }
                                        }
                                        %>
                                    </select>
                                </div>
                                
                                <div class="col-lg-7 col-md-12 mb-30">
                                    <div id="ktp" class="">
                                        <div class="form-group">
                                            <label class="fz-16 semi-bold mandatory" for="IdNumber">Nomor KTP</label>
                                            <input type="text" class="form-control input-gray text-uppercase semi-bold change required" id="IdNumber" name="IdNumber" placeholder="Nomor KTP" value="" maxlength="24" data-mask="#">
                                        </div>
                                    </div>
    
                                    <div id="kitas" class=" d-none">
                                        <div class="form-group">
                                            <label class="fz-16 semi-bold mandatory" for="KitasNumber">Nomor Kitas</label>
                                            <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="KitasNumber" name="KitasNumber" placeholder="Nomor Kitas" value="" maxlength="24" data-mask="K">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row mb-10">
                                <div class="form-group col-lg-6 col-md-12 mb-30">
                                    <span class="span-label fz-16 semi-bold upload-foto-label mandatory">Upload Foto Kartu Identitas</span>
                                    <div class="uploaded-wrappper" id="idPhotoUplaodedWrapper">
                                        
                                    </div>
                                    <div class="custom-file custom-file-grey">
                                        <input name="IdPhoto" type="file" class="custom-file-input semi-bold upload-idphoto" id="customFile">
                                        <input name="IdPhotoHidden" type="hidden" class="form-control input-gray semi-bold IdPhotoHidden hidden-required" value="">
                                        <label class="custom-file-label" for="customFile">Choose file</label>
                                    </div>
                                </div>                          
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-12 col-md-12 mb-30">
                                    <label class="fz-16 semi-bold mandatory" for="Address">Alamat Lengkap</label>
                                    <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="Address" name="Address" placeholder="Alamat Lengkap" value="" maxlength="100" data-mask="D">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-4 col-md-4 mb-30">
                                    <label class="fz-16 semi-bold mandatory">Provinsi</label>
                                    <select class="form-control select-gray semi-bold change required" name="Province" required>
                                        <option value="">Provinsi</option>
                                        
                                        <% if(masterProvince != null) {
                                        	for(MasterProvince _masterProvince : masterProvince) {%>
                                        		<option value="<%=_masterProvince.getMasterProvinceId()%>" ><%=_masterProvince.getName()%></option>
                                        	<% }
                                        }
                                        %>
                                    </select>
                                </div>

                                <div class="form-group col-lg-4 col-md-4 mb-30">
                                    <label class="fz-16 semi-bold mandatory">Kota</label>
                                    <select class="form-control select-gray semi-bold change required" name="City" required>
                                        <option value="">Kota</option>
                                        <% if(masterCities != null) {
                                        	for(MasterCity _masterCity : masterCities) {%>
                                        		<option class='d-none' data-data='{"Province":"<%=_masterCity.getProvinceId()%>"}' value='<%=_masterCity.getName()%>'><%=_masterCity.getName()%></option>
                                        	<% }
                                        }
                                        %>
                                    </select>
                                </div>

                                <div class="form-group col-lg-4 col-md-4 mb-30">
                                    <label class="fz-16 semi-bold mandatory" for="Zip">Kode Pos</label>
                                    <input type="text" class="form-control input-gray semi-bold change required" id="Zip" name="Zip" placeholder="Kode Pos" value="" maxlength="5" data-mask="#">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-7 col-md-12 mb-30">
                                    <label class="fz-16 semi-bold mandatory" for="MobilePhone">Nomor Handphone / Telepon</label>
                                    <input type="text" class="form-control input-gray semi-bold change required" id="MobilePhone" name="MobilePhone" placeholder="Contoh: 628123456XXXX" value="" maxlength="16" data-mask="#">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-7 col-md-12 mb-30">
                                    <label class="fz-16 semi-bold mandatory" for="Email">Email</label>
                                    <input type="email" class="form-control input-gray semi-bold change required text-uppercase" id="Email" name="Email" placeholder="Alamat email Anda" value="" maxlength="50">
                                </div>
                            </div>

                            <div class="row job-wrapper">
                                <div class="form-group col-lg-7 col-md-7 mb-30">
                                    <label class="fz-16 semi-bold mandatory">Pekerjaan</label>
                                    <select class="form-control select-gray semi-bold change required selectize" name="Job" required data-msg-required="Pekerjaan harus dipilih">
                                        <option value="">Pekerjaan</option>
                                        <option value="77777">Karyawan Swasta</option>
                                    </select>
                                </div>

                                <div class="form-group col-lg-5 col-md-12 mb-30 job-other d-none">
                                    <label class="fz-16 semi-bold mandatory" for="JobOther">Sebutkan</label>
                                    <input type="text" class="form-control input-gray semi-bold change required text-uppercase" id="JobOther" name="JobOther" placeholder="Sebutkan" value="" maxlength="255">
                                </div>
                            </div>

                        </div>
                    </div>
                    <input class="change" name="Step2" type="hidden" value="1">
                </form>
            </div>
            <!-- END CONTENT -->
            
            <!-- MOBILE -->
                        <div class="col-md-12 d-sm-block d-md-none mt-20">
                <button type="button" class="btn btn-yellow-box btn-block semi-bold small next-step" disabled>Selanjutnya <i class="fas fa-arrow-right"></i></button>
                <div class="next-info-error fz-11 c-red pt-1"><i>*Lengkapi data pada form diatas terlebih dahulu <span class="check-validate c-pointer" data-toggle="tooltip" data-placement="top" title="Check form yang belum terisi"><b>(Check)</b></span></i></div>
                
                <!-- <div class="next-info-error fz-11 c-red pt-1"><i>*Data belum lengkap. <span class="check-validate c-pointer" data-toggle="tooltip" data-placement="top" title="Check form yang belum terisi"><a href="javascript:void(0)">Periksa</a></span></i></div> -->
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
        
        <%@ include file="/includes/jsp/cookie.jsp" %>
        
        <script>
        	var petUploadImageURL = '<%=petUploadImageURL%>';
        </script>