<%@ include file="/init.jsp" %>

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
%>

<%String lrToPimcKycMiddlewareUrl = (String)renderRequest.getAttribute("lrToPimcKycMiddlewareUrl");%>
<%String pmcrPaymentUrl = (String)renderRequest.getAttribute("pmcrPaymentUrl");%>

<portlet:renderURL var="paymentURL">
	<portlet:param name="mvcPath" value="/payment.jsp"></portlet:param>
</portlet:renderURL>

<script type="text/javascript">
var paymentURL = '<%= paymentURL%>';
var lrToPimcKycMiddlewareUrl = "<%=lrToPimcKycMiddlewareUrl%>";
var pmcrPaymentUrl = "<%=pmcrPaymentUrl%>";
var aParam = "<%=aParam%>";
</script>

<liferay-util:body-bottom outputKey="petStep4BodyBottom">
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/selectize.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/pet_general.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/step4.js"></script>
</liferay-util:body-bottom> 

	<%@ include file="/includes/jsp/product_title.jsp" %>
	
	<% int stepNumber = 4; boolean stepHalf = false; %>
	<%@ include file="/includes/jsp/breadcrumb.jsp" %>
	
	<section id="step4-page" class="content-section" data-managedby="" data-onepage="" data-pep="">
    <div class="container">
        <div class="row">
        <!-- CONTENT -->
        <div class="col-lg-8 col-md-8">
  <form novalidate="novalidate">
    <div class="wrapper big-pad">
      <div class="title">
        <h3>Persetujuan</h3>
      </div>

      <div class="content">
        <div class="row">
          <div class="col-md-12">
            <ul class="list-group list-group-normal mt-4 mb-4">
              <li class="list-group-item mb-3">
                <div class="d-flex">
                  <div class="form-group">
                    <div class="form-check checkbox-custom yellow">
                      <input name="TncDataPribadi" class="form-check-input change tnc_req required" type="checkbox" id="TncDataPribadi" />
                      <label class="form-check-label" for="TncDataPribadi"></label>
                    </div>
                  </div>
                  <div class="flex-fill">
                    <label class="collapse-a font-weight-normal mandatory" data-toggle="collapse" href="#collapse-data-pribadi" role="button" aria-expanded="false" aria-controls="collapse-data-pribadi">
                    Saya sudah membaca dan menyetujui <span class="c-blue-100 font-italic bold">pernyataan dan penggunaan data pribadi</span>
                    </label>
                  </div>
                </div>
                <div class="collapse" id="collapse-data-pribadi">
                  <div>
                    <div class="mt-3 p-3" style="background: #e0e0e06e">
                    <p>Dengan ini Saya/Kami menyetujui bahwa data dan informasi pribadi yang Saya/Kami berikan kepada PT AXA Insurance Indonesia dapat dikirimkan oleh PT AXA Insurance Indonesia kepada pihak lain yang bekerjasama dengan dan/atau ditunjuk oleh PT AXA Insurance Indonesia, Regulator dan Pihak yang Berwenang dan/atau Asosiasi sehubungan dengan keperluan operasional PT AXA Insurance Indonesia terkait pertanggungan asuransi Saya/Kami, proses penutupan asuransi, proses reasuransi dan klaim.</p>
                    <p>&nbsp;</p>
                    <p><em>Dengan mencentang pernyataan ini, maka Anda menyatakan telah memberikan persetujuan.</em></p>
                    <p>&nbsp;</p>
                    </div>
                  </div>
                </div>
              </li>

              <li class="list-group-item mb-3">
                <div class="d-flex">
                  <div class="form-group">
                    <div class="form-check checkbox-custom yellow">
                      <input name="Tnc" class="form-check-input change tnc_req required" type="checkbox" id="Tnc" />
                      <label class="form-check-label" for="Tnc"></label>
                    </div>
                  </div>
                  <div class="flex-fill">
                    <label class="collapse-a font-weight-normal mandatory" data-toggle="collapse" href="#collapse-tnc" role="button" aria-expanded="false" aria-controls="collapse-tnc">
                    Saya sudah membaca dan menyetujui <span class="c-blue-100 font-italic bold">pernyataan kuasa dan persetujuan</span>
                    </label>
                  </div>
                </div>
                <div class="collapse" id="collapse-tnc">
                  <div>
                    <div class="mt-3 p-3" style="background: #e0e0e06e">
                    <p>Dengan mengirimkan aplikasi dan dokumen kelengkapan ini, saya memahami, menyatakan, memberikan persetujuan, dan menjamin bahwa:</p>
                    <ol>
	<li>Setiap dan seluruh pernyataan, informasi, dan/atau data yang saya berikan, umumkan, kirimkan, atau tampilkan pada Formulir Aplikasi Asuransi ini, atau konfirmasi lain sehubungan dengan Formulir Aplikasi Asuransi ini adalah benar, akurat, lengkap, dan terkini sesuai dengan keadaan saat ini, dan saya sepakat untuk menjamin dan bertanggung jawab atas kebenaran pernyataan, informasi, dan/atau data tersebut.</li>
	<li>Setiap dan seluruh data serta informasi yang saya berikan, umumkan, kirimkan, atau tampilkan pada Formulir Aplikasi Asuransi ini akan menjadi dasar dan bagian dari Polis Anda, termasuk setiap dan seluruh ketentuan umum Polis.</li>
	<li>Jika saya terbukti memberikan data, pernyataan, informasi, dan jawaban yang tidak benar atau tidak lengkap secara sengaja maupun tidak sengaja, saya sadar, memahami, dan menyetujui bahwa PT AXA Insurance Indonesia memiliki hak untuk membatalkan Polis Asuransi Hewan Peliharaan ini, tanpa berkewajiban untuk membayar manfaat apapun atau mengembalikan premi yang telah saya bayarkan.</li>
	<li>Saya telah membaca, memahami, dan menyetujui isi dan ketentuan pada Polis ini. Sehubungan dengan hal tersebut, dengan ini saya memahami, menyatakan, menjamin, dan berusaha dengan usaha terbaik saya dalam menyebabkan ahli waris, keluarga, atau pun pihak yang mengatasnamakan saya untuk selamanya melepaskan serta membebaskan PT AXA Insurance Indonesia, direktur-direktur, komisaris-komisaris, karyawan-karyawan, dan/atau afiliasi-afiliasinya, dari segala bentuk tindakan atau upaya hukum yang saya miliki atau mungkin miliki secara langsung dan/atau tidak langsung sehubungan dengan penggunaan data saya, dan apabila pada kemudian hari terdapat data, serta korespondensi tertulis terkait Formulir Aplikasi Asuransi ini dan/atau Polis yang tidak benar, maka saya bersedia untuk mempertanggungjawabkannya sesuai ketentuan dan hukum yang berlaku.</li>
	<li>Saya memberi kuasa kepada PT AXA Insurance Indonesia untuk mendapatkan informasi terkait Polis saya dari pihak manapun, termasuk di antaranya yaitu lembaga hukum, individu, perusahaan, dan organisasi yang mengetahui dan/atau memiliki catatan atau informasi tentang saya.</li>
	<li>Saya memberi kuasa kepada PT AXA Insurance Indonesia untuk mendebit kartu kredit saya sesuai dengan jumlah premi terutang sesuai dengan syarat dan ketentuan yang berlaku pada Polis saya.</li>
	<li>PT AXA Insurance Indonesia untuk dapat menyimpan, menggunakan, dan mengungkapkan data saya kepada pihak ketiga manapun (sebagaimana diperlukan) sehubungan dengan pelaksanaan penutupan pertanggungan ini.</li>
	<li>Saya akan selalu melakukan pengkinian atas informasi atau data atau data pribadi sehubungan dengan Formulir Aplikasi ini dan/atau Polis saya.</li>
	<li>Saya akan selalu menjaga kerahasiaan informasi terkait Formulir Aplikasi ini dan/atau Polis saya dari pihak-pihak yang tidak berkepentingan.</li>
	<li>Saya menyatakan setuju untuk menerima polis asuransi dan seluruh kelengkapan dokumennya dalam bentuk elektronik (e-policy) yang tidak dapat disunting/diubah serta Saya juga memahami, menyatakan dan menjamin bahwa e-policy ini merupakan dokumen yang sah dan setara dengan polis asuransi dalam bentuk cetak (hardcopy). Oleh karenanya apabila dikemudian hari, Saya tetap membutuhkan polis asuransi beserta seluruh kelengkapan dokumennya dalam bentuk cetak (hardcopy), maka Saya akan menghubungi Customer Call Center PT AXA Insurance Indonesia di nomor telepon : (021) 1500733 (hari Senin s/d Jum'at, pukul 08.00 s/d 17.00 WIB) atau melalui email : <a href="mailto:mailto:customer.general@axa.co.id">customer.general@axa.co.id</a>.</li>
	<li>Saya telah mendapat informasi mengenai manfaat asuransi dan jumlah premi asuransi, yang mana premi dari asuransi produk ini mencakup beberapa faktor yaitu: biaya operasional, tingkat keuntungan, dan imbal jasa dari premi yang diteruskan sebagai komisi kepada pihak bank.</li>
	<li>Jika saya terbukti memberikan data, pernyataan, informasi dan jawaban yang tidak benar atau tidak lengkap secara sengaja maupun tidak sengaja, saya sadar, memahami dan menyetujui bahwa PT AXA Insurance Indonesia memiliki hak untuk membatalkan Polis ini. Tanpa berkewajiban untuk membayar manfaat apapun atau mengembalikan premi yang telah saya bayarkan.</li>
	<li>Dengan ini saya menyatakan bahwa transkasi ini tidak melanggar pencucian uang, korupsi, pendanaan terorisme, anggota terorisme dan pendanaan poliferasi. Jika saya terlibat, terpapar baik sengaja maupun tidak sengaja dalam pencucian uang, korupsi, pendanaan terorisme, anggota terorisme dan pendanaan poliferasi, saya sadar memahami dan menyetujui bahwa PT AXA Insurance Indonesia memiliki hak untuk membatalkan Polis ini, tanpa berkewajiban untuk membayar manfaat apapun atau mengembalikan premi yang telah saya bayarkan.</li>
	<li>Saya telah membaca, memahami, dan menyetujui setiap dan seluruh ketentuan Polis ini.</li>
</ol>
                    </div>
                  </div>
                </div>
              </li>

              <li class="list-group-item mb-3">
                <div class="d-flex">
                  <div class="form-group">
                    <div class="form-check checkbox-custom yellow">
                      <input name="TncPromo" class="form-check-input change tnc_req" type="checkbox" id="TncPromo" />
                      <label class="form-check-label" for="TncPromo"></label>
                    </div>
                  </div>
                  <div class="flex-fill">
                    <label class="collapse-a font-weight-normal" data-toggle="collapse" href="#collapse-tnc-promo" role="button" aria-expanded="false" aria-controls="collapse-tnc-promo">
                    Saya bersedia untuk menerima <span class="c-blue-100 font-italic bold">berita dan informasi dari AXA</span>
                    </label>
                  </div>
                </div>
                <div class="collapse" id="collapse-tnc-promo">
                  <div>
                    <div class="mt-3 p-3" style="background: #e0e0e06e">
                    <p>Dengan ini Saya/Kami menyetujui untuk dilakukan pemasaran, penawaran produk dan aktivitas promosi lainnya melalui sarana komunikasi pribadi Saya/Kami termasuk namun tidak terbatas pada email, telepon, SMS dan media komunikasi online lainnya.</p>
                    <p>&nbsp;</p>
                    <p><em>Dengan mencentang pernyataan ini, maka Anda menyatakan telah memberikan persetujuan.</em></p>
                    </div>
                  </div>
                </div>
              </li>

              <li class="list-group-item mb-3">
                <div class="d-flex">
                  <div class="flex-fill">
                    <label class="collapse-a font-weight-normal" data-toggle="collapse" href="#collapse-pernyataan-magi" role="button" aria-expanded="false" aria-controls="collapse-pernyataan-magi">
                    Klik disini untuk membaca <span class="c-blue-100 font-italic bold">pernyataan PT AXA Insurance Indonesia</span>
                    </label>
                  </div>
                </div>
                <div class="collapse" id="collapse-pernyataan-magi">
                  <div>
                    <div class="mt-3 p-3" style="background: #e0e0e06e">
                    <ol start="1" style="list-style-type:decimal; margin-left:15px">
	<li>PT AXA Insurance Indonesia berkomitmen untuk menjaga kerahasiaan dan melaksanakan pemrosesan data pribadi secara sah sesuai dengan ketentuan peraturan perundang-undangan yang berlaku, sampai dengan batas waktu yang telah ditentukan sesuai dengan kebijakan retensi PT AXA Insurance Indonesia kecuali penyimpanan lebih lanjut diperlukan untuk memenuhi periode retensi yang lebih lama untuk memenuhi persyaratan operasional, hukum, peraturan, pajak, atau akuntansi PT AXA Insurance Indonesia.</li>
	<li>PT AXA Insurance Indonesia akan menghancurkan atau menganonimkan dari catatan dan sistem cadangan PT AXA Insurance Indonesia sesuai dengan kebijakan retensi PT AXA Insurance Indonesia kecuali penyimpanan lebih lanjut diperlukan untuk memenuhi periode retensi yang lebih lama untuk memenuhi persyaratan operasional, hukum, peraturan, pajak, atau akuntansi PT AXA Insurance Indonesia.</li>
	<li>PT AXA Insurance Indonesia memberikan hak akses untuk mendapatkan salinan, melengkapi dan/atau memperbaharui kesalahan data dan informasi pribadi Nasabah berdasarkan permintaan tertulis dari Nasabah.</li>
	<li>PT AXA Insurance Indonesia memberikan hak kepada Nasabah untuk menarik kembali persetujuan mengenai pemrosesan data pribadi Nasabah, mengakhiri pemrosesan, menghapus, dan/atau memusnahkan data pribadi Nasabah, serta hak-hak lainnya sesuai dengan ketentuan peraturan perundang-undangan yang berlaku berdasarkan permintaan tertulis dari Nasabah.</li>
</ol>
                    </div>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <input class="change" name="Step4" type="hidden" value="1" />
  </form>
</div>
        <!-- END CONTENT -->
        
        <!-- MOBILE -->
                    <div class="col-md-12 d-sm-block d-md-none mt-20 d-none">
                    <button type="button" class="btn btn-yellow-box btn-block semi-bold send-quotation" disabled><i class="fas fa-envelope"></i> Kirim Penawaran</button>
                <button type="button" class="btn btn-yellow-box btn-block semi-bold next-step" disabled>Selanjutnya <i class="fas fa-arrow-right"></i></button>
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
                                <button type="button" class="btn btn-yellow-box btn-block semi-bold send-quotation d-none"><i class="fas fa-envelope"></i> Kirim Penawaran</button>
                                    <button type="button" class="btn btn-yellow-box btn-block bold next-step" disabled>Selanjutnya <i class="fas fa-arrow-right"></i></button>
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
        
        <!-- QUOTATION MODAL -->
    <div id="quotation-modal" class="modal fade modal-quotation" tabindex="-1" aria-labelledby="quotation-modal" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="title">
                        <h6>Kirim Penawaran</h6>
                        <div class="icon">
                            <i class="fal fa-envelope"></i>
                        </div>
                    </div>

                    <div class="content">
                        <div class="form-group mb-30">
                            <label class="fz-16 semi-bold" for="quotation-name">Nama Penerima</label>
                            <input name="quotation-name" type="input" class="form-control input-gray semi-bold" id="quotation-name" value="RIFKI" disabled="disabled">
                        </div>

                        <div class="form-group mb-30">
                            <label class="fz-16 semi-bold" for="quotation-email">Email Penerima</label>
                            <input name="quotation-email" type="input" class="form-control input-gray semi-bold" id="quotation-email" value="rifki@localhost.com" disabled="disabled">
                        </div>

                        <div class="text-center">
                            <button type="button" id="quotation-cancel" class="btn btn-yellow-box small semo-bold" data-dismiss="modal"><i class="far fa-times"></i> Batal</button>
                            <button type="button" id="quotation-submit" class="btn btn-yellow-box small semo-bold"><i class="far fa-check"></i> Kirim</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>        
        <!-- END QUOTATION MODAL -->
        
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