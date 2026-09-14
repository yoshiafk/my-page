<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page
	import="com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.DetailInternationalTravel"%>
<%@page import="com.mypage.leads.service.CustomerLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.mypage.leads.service.LeadsLocalServiceUtil"%>
<%@page import="com.mypage.leads.model.Leads"%>
<%@ include file="init.jsp"%>

<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<% String sanctionCountry = (String)renderRequest.getAttribute("sanctionCountry"); %>

<%
LocalDateTime timestampForJSURI = LocalDateTime.now();
DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>

<%
	String _datainfo = (String) renderRequest.getAttribute("_data-info");
	String _dataItemUtama = (String) renderRequest.getAttribute("item-utama");
	String _dataFiturUtama = (String) renderRequest.getAttribute("fitur-utama");
	String _dataItemManfaat = (String) renderRequest.getAttribute("item-manfaat");
	String _dataItemResiko = (String) renderRequest.getAttribute("item-resiko");
	String _dataItemBiaya = (String) renderRequest.getAttribute("item-biaya");
	String _dataItemKecuali = (String) renderRequest.getAttribute("item-pengecualian");
	String _dataItemSyarat = (String) renderRequest.getAttribute("item-persyaratan");
	String _dataItemSimulasi = (String) renderRequest.getAttribute("item-simulasi");
	String _dataItemInfoTambahan = (String) renderRequest.getAttribute("item-info-tambahan");
	String _dataItemCatatanPenting = (String) renderRequest.getAttribute("item-catatan-penting");
	String _dataItemDisclaimer = (String) renderRequest.getAttribute("item-disclaimer");

	String _riplayVersi = (String) renderRequest.getAttribute("riplay-version");
	String capitalizedVersionRiplay = _riplayVersi.substring(0, 1).toUpperCase()
			+ _riplayVersi.substring(1).toLowerCase();

	String portalURL = PortalUtil.getPortalURL(request);
	String restApiProcessUrl = portalURL + "/o/api/sti/process";
	
	String managedBy = (String)renderRequest.getAttribute("managedBy"); 
	
	String businessModel = (String)renderRequest.getAttribute("businessModel");
	String aParam = (String) renderRequest.getAttribute("a");
	String rcParam = (String) renderRequest.getAttribute("rc");
	String bParam = (String) renderRequest.getAttribute("b");
%>


<script>
var restApiProcessUrl = "<%=restApiProcessUrl%>";
</script>

<script src="<%=request.getContextPath()%>/js/main.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>

<%-- Membuat URL untuk payment.jsp --%>
<portlet:renderURL var="paymentURL">
	<portlet:param name="jspPage" value="/dashboard/payment.jsp" />
</portlet:renderURL>

<portlet:renderURL var="stepBase3URL">
	<portlet:param name="jspPage" value="/step3.jsp" />
</portlet:renderURL>

<%
	String step3URL = stepBase3URL;
	if (Validator.isNotNull(aParam)) step3URL = step3URL + "&a=" + aParam;
	if (Validator.isNotNull(rcParam)) step3URL = step3URL + "&rc=" + rcParam;
	if (Validator.isNotNull(bParam)) step3URL = step3URL + "&b=" + bParam;
%>

<script>
var linkstep3 = "<%=step3URL%>";
</script>

<header class="hero">
	<img src="/o/mypage-theme/images/step2hero.png" alt="herostep2"
		class="width-full height-full">
</header>


<!-- navbar -->
<%@ include file="/includes/navbar.jsp"%>


	<!-- step bar -->
		<div class="stepper-wrapper">
		<div class="stepper-item completed">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Pilih Perlindungan</div>
		</div>
		<div class="stepper-item completed">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Data Pemegang Polis</div>
		</div>
		<div class="stepper-item active">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Persetujuan</div>
		</div>
		<div class="stepper-item">
			<div class="step-counter"></div>
			<div class="step-name agency__uppercase agency__text-center">Pembayaran</div>
		</div>
	</div>
	<!-- end step bar -->


<section id="content" class="dashboard agency__text-343C3D">
	<div class="dashboard-riplay">
		<div class="container-riplay">
			<div class="dashboard-riplay__inner">
				<div class="dashboard-left agency__bg-white">
					<div class="dashboard-left__riplay">
						<h1>
							Ringkasan Informasi Produk dan Layanan (RIPLAY) Versi
							<%=capitalizedVersionRiplay%></h1>

						<%=_datainfo%>

						<div class="accordion-wrapper">
							<div id="accordionRiplay" class="accordion">

								<!-- item utama -->
								<%=_dataFiturUtama%>

								<!-- manfaat -->
								<%=_dataItemManfaat%>

								<!-- resiko -->
								<%=_dataItemResiko%>

								<!-- biaya -->
								<%=_dataItemBiaya%>

								<!-- pengecualian -->
								<%=_dataItemKecuali%>

								<!-- syarat -->
								<%=_dataItemSyarat%>

								<!-- simulasi -->
								<%=_dataItemSimulasi%>

								<!-- info tambahan -->
								<%=_dataItemInfoTambahan%>

							</div>
						</div>

						<div class="notes-wrapper">
							<div class="notes">
								<p>Catatan Penting:</p>
							</div>
							<!-- <div class="list-notes">
								<ul>
									<li>Ringkasan Informasi Produk dan Layanan ini dibuat dan
										dipersiapkan oleh PT AXA Insurance Indonesia dan dipergunakan
										sebagai informasi bagi Anda mengenai produk Asuransi
										SmartTravel Internasional (<em>SmartTravel International
											Insurance</em>) dari PT AXA Insurance Indonesia.
									</li>
									<li>Ringkasan Informasi Produk dan Layanan ini bukan
										merupakan Kontrak Asuransi maupun bagian dari Polis Asuransi.</li>
									<li>Bagian dari premi yang berupa biaya akuisisi dapat
										dialokasikan sebagai diskon bagi pihak tertanggung.</li>
									<li>Produk yang dipasarkan adalah Produk Asuransi.</li>
									<li>Semua Pihak yang membaca dan menggunakan Ringkasan
										Informasi Produk dan Layanan ini agar memperhatikan
										syarat-syarat, ketentuan dan penggunaan yang berlaku.</li>
									<li>Apabila terdapat pertanyaan, keluhan atau informasi
										lanjutan, dapat menghubungi PT AXA Insurance Indonesia
										Customer Care Center di 1500733, email ke <a
										href="mailto:customer.general@axa.co.id">customer.general@axa.co.id</a>
										atau melalui website di <a href="http://www.axa.co.id">www.axa.co.id</a>.
									</li>
									<li>Produk Asuransi ini telah mendapatkan persetujuan dari
										dan diawasi oleh Otoritas Jasa Keuangan (OJK).</li>
								</ul>
							</div> -->


							<!-- catatan penting -->
							<%=_dataItemCatatanPenting%>

						</div>


						<div class="disclaimer-wrapper">
							<div class="disclaimer">
								<p>Disclaimer (penting untuk dibaca) :</p>
							</div>
							<!-- <div class="list-disclaimer">
								<ul>
									<li>Anda telah membaca, menerima penjelasan, dan memahami
										produk Asuransi SmartTravel Internasional (<em>SmartTravel
											International Insurance</em>) sesuai Ringkasan Informasi Produk
										dan Layanan.
									</li>
									<li>Ringkasan Informasi Produk dan Layanan ini bukan
										merupakan bagian dari aplikasi pengajuan asuransi dan polis.</li>
									<li>Anda wajib untuk membaca, memahami dan menandatangani
										aplikasi pengajuan asuransi dan polis.</li>
									<li>Informasi yang tercakup dalam Ringkasan Informasi
										Produk dan Layanan ini berlaku sejak tanggal cetak dokumen
										sampai dengan adanya pembaharuan lebih lanjut dari PT AXA
										Insurance Indonesia.</li>
									<li>Anda harus membaca dengan teliti Ringkasan Informasi
										Produk dan Layanan ini dan berhak bertanya kepada pegawai PT
										AXA Insurance Indonesia atas semua hal terkait Ringkasan
										Informasi Produk dan Layanan ini.</li>
								</ul>
							</div> -->

							<!-- disclaimer -->
							<%=_dataItemDisclaimer%>
						</div>

						<div class="agreement-wrapper">
							<div class="statement-agreement">
								<p>
									Saya dengan ini menyatakan bahwa Saya telah membaca, menerima
									penjelasan dan memahami produk Asuransi SmartTravel sesuai
									Ringkasan Informasi Produk dan Layanan <sup>*</sup>
								</p>
							</div>
							<ul class="agreement">
								<li class="list-agreement">
									<div class="radio-custom-wrapper">
										<input id="yes-agree" class="radio-custom" name="type"
											type="radio"> <label for="yes-agree"
											class="radio-custom-label"><span>Ya</span></label>
									</div>
									<div class="radio-custom-wrapper">
										<input id="no-agree" class="radio-custom" name="type"
											type="radio"> <label for="no-agree"
											class="radio-custom-label"><span>Tidak</span></label>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="dashboard-left__agreement">
						<h1>Persetujuan</h1>
						<div class="accordion-wrapper__agreement">
							<div id="accordionAgreement" class="accordion">
								<div class="accordion-item__agreement">
									<div class="accordion-header" id="stayAgreementOne">
										<div class="accordion-button collapsed"
											data-bs-toggle="collapse"
											data-bs-target="#collapseAgreementOne" aria-expanded="true"
											aria-controls="collapseAgreementOne">
											<div class="accordion-button__inner">
												<div class="accordion-button__left">
													<div class="checkbox-custom-wrapper">
														<input id="edit-1" class="checkbox-custom trigger-check"
															name="edit-1" type="checkbox"> <label
															for="edit-1" class="checkbox-custom-label"></label>
													</div>
												</div>
												<div class="accordion-button__right">
													<div class="policy">
														<p>Saya sudah membaca dan menyetujui pernyataan dan
															penggunaan data pribadi</p>
													</div>
													<i
														class="fas fa-chevron-down align-self-center agency__text-center"></i>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseAgreementOne"
										class="accordion-collapse collapse show">
										<div class="accordion-body">
											Dengan ini Saya/Kami menyetujui bahwa data dan informasi
											pribadi yang Saya/Kami berikan kepada PT AXA Insurance
											Indonesia dapat dikirimkan oleh PT AXA Insurance Indonesia
											kepada pihak lain yang bekerjasama dengan dan/atau ditunjuk
											oleh PT AXA Insurance Indonesia, Regulator dan Pihak yang
											Berwenang dan/atau Asosiasi sehubungan dengan keperluan
											operasional PT AXA Insurance Indonesia termasuk namun tidak
											terbatas pada keperluan pertanggungan asuransi Saya/Kami,
											proses penutupan asuransi, proses reasuransi dan klaim. <br>
											<br>Dengan mencentang pernyataan ini, maka Anda
											menyatakan telah memberikan persetujuan.
										</div>
									</div>
								</div>
								<div class="accordion-item__agreement">
									<div class="accordion-header" id="stayAgreementTwo">
										<div class="accordion-button collapsed"
											data-bs-toggle="collapse"
											data-bs-target="#collapseAgreementTwo" aria-expanded="false"
											aria-controls="collapseAgreementTwo">
											<div class="accordion-button__inner">
												<div class="accordion-button__left">
													<div class="checkbox-custom-wrapper">
														<input id="edit-2" class="checkbox-custom trigger-check"
															name="edit-2" type="checkbox"> <label
															for="edit-2" class="checkbox-custom-label"></label>
													</div>
												</div>
												<div class="accordion-button__right">
													<div class="policy">
														<p>Saya sudah membaca dan menyetujui pernyataan kuasa
															dan persetujuan berikut</p>
													</div>
													<i
														class="fas fa-chevron-down align-self-center agency__text-center"></i>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseAgreementTwo"
										class="accordion-collapse collapse show">
										<div class="accordion-body">
                                                <span style="text-align: justify;">Dengan mengirimkan aplikasi dan dokumen kelengkapan ini, saya memahami, menyatakan, memberikan persetujuan, dan menjamin bahwa:</span>
												<div class="point" style="text-align: justify;">
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">1.</span>
												            <span style="flex: 1;">
												                Setiap dan seluruh pernyataan, informasi, dan/atau data yang saya berikan, umumkan, kirimkan, atau tampilkan pada Formulir Aplikasi Asuransi ini, atau konfirmasi lain sehubungan dengan Formulir Aplikasi Asuransi ini adalah
												                benar, akurat, lengkap, dan terkini sesuai dengan keadaan saat ini, dan saya sepakat untuk menjamin dan bertanggung jawab atas kebenaran pernyataan, informasi, dan/atau data tersebut;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">2.</span>
												            <span style="flex: 1;">
												                Untuk tertanggung yang telah berusia lebih dari 65 (enam puluh lima) tahun sampai dengan 75 (tujuh puluh lima) tahun, maka manfaat-manfaat asuransi (bagian 3 dan bagian 6) diberikan sebesar 35% (tiga puluh lima persen) dari
												                batas maksimum yang tercantum dalam ikhtisar polis;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">3.</span>
												            <span style="flex: 1;">
												                Untuk tertanggung yang telah berusia lebih dari 75 (tujuh puluh lima) tahun sampai dengan 85 (delapan puluh lima) tahun, maka manfaat-manfaat asuransi (bagian 3 dan bagian 6) diberikan sebesar 15% (lima belas persen) dari
												                batas maksimum yang tercantum dalam ikhtisar polis;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">4.</span>
												            <span style="flex: 1;">
												                Setiap dan seluruh data serta informasi yang saya berikan, umumkan, kirimkan, atau tampilkan pada Formulir Aplikasi Asuransi ini akan menjadi dasar dan bagian dari Polis, termasuk setiap dan seluruh ketentuan umum Polis
												                "Asuransi SmartTravel Internasional";
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">5.</span>
												            <span style="flex: 1;">
												                Jika saya terbukti memberikan data, pernyataan, informasi dan jawaban yang tidak benar atau tidak lengkap secara sengaja maupun tidak sengaja, saya sadar, memahami dan menyetujui bahwa PT AXA Insurance Indonesia memiliki hak
												                untuk membatalkan Polis ini. Tanpa berkewajiban untuk membayar manfaat apapun atau mengembalikan premi yang telah saya bayarkan;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">6.</span>
												            <span style="flex: 1;">
												                Dengan ini saya menyatakan bahwa transkasi ini tidak melanggar pencucian uang, korupsi, pendanaan terorisme, anggota terorisme dan pendanaan poliferasi. Jika saya terlibat, terpapar baik sengaja maupun tidak sengaja dalam
												                pencucian uang, korupsi, pendanaan terorisme, anggota terorisme dan pendanaan poliferasi, saya sadar memahami dan menyetujui bahwa PT AXA Insurance Indonesia memiliki hak untuk membatalkan Polis ini, tanpa berkewajiban untuk
												                membayar manfaat apapun atau mengembalikan premi yang telah saya bayarkan;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">7.</span>
												            <span style="flex: 1;">
												                Polis Asuransi SmartTravel Internasional ini tidak dapat dibatalkan, dan pengembalian premi hanya dapat dilakukan apabila adanya penolakan pengajuan visa dari kedutaan terkait dengan dikurangi biaya administrasi sebesar
												                Rp65.000,- (enam puluh lima ribu Rupiah) atau yang disetarakan dengan USD5,- (lima Dolar Amerika Serikat);
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">8.</span> <span style="flex: 1;"> Pertanggungan berdasarkan Polis Asuransi SmartTravel Internasional ini adalah untuk perjalanan dari Indonesia ke luar negeri dan kembali lagi ke Indonesia; </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">9.</span>
												            <span style="flex: 1;"> Tertanggung tidak akan melakukan perjalanan bila tidak mendapat persetujuan tertulis dari dokter dan tidak akan melakukan perjalanan untuk mendapatkan perawatan medis;</span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">10.</span> <span style="flex: 1;"> Polis ini diterbitkan pada saat Tertanggung belum melakukan perjalanan;</span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">11.</span>
												            <span style="flex: 1;">
												                Saya telah membaca, memahami, dan menyetujui isi dan ketentuan pada Polis Asuransi SmartTravel Internasional ini. Sehubungan dengan hal tersebut, dengan ini saya memahami, menyatakan, menjamin, dan berusaha dengan usaha
												                terbaik saya dalam menyebabkan ahli waris, keluarga, atau pun pihak yang mengatasnamakan saya untuk selamanya melepaskan serta membebaskan PT AXA Insurance Indonesia, direktur-direktur, komisaris-komisaris,
												                karyawan-karyawan, dan/atau afiliasi-afiliasinya, dari segala bentuk tindakan atau upaya hukum yang saya miliki atau mungkin miliki secara langsung dan/atau tidak langsung sehubungan dengan penggunaan data saya, dan apabila
												                pada kemudian hari terdapat data, serta korespondensi tertulis terkait Formulir Aplikasi Asuransi ini dan/atau Polis yang tidak benar, maka saya bersedia untuk mempertanggungjawabkannya sesuai ketentuan dan hukum yang
												                berlaku;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">12.</span>
												            <span style="flex: 1;">
												                Saya memberi kuasa kepada PT AXA Insurance Indonesia untuk mendapatkan informasi terkait Polis Asuransi SmartTravel Internasional saya dari pihak manapun, termasuk di antaranya yaitu lembaga hukum, individu, perusahaan, dan
												                organisasi yang mengetahui dan/atau memiliki catatan atau informasi tentang saya;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">13.</span>
												            <span style="flex: 1;">
												                PT AXA Insurance Indonesia untuk dapat menyimpan, menggunakan, dan mengungkapkan data saya kepada pihak ketiga manapun (sebagaimana diperlukan) sehubungan dengan pelaksanaan penutupan pertanggungan ini;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">14.</span>
												            <span style="flex: 1;"> Saya akan selalu melakukan pengkinian atas informasi atau data atau data pribadi sehubungan dengan Formulir Aplikasi ini dan/atau Polis Asuransi SmartTravel Internasional saya;</span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">15.</span>
												            <span style="flex: 1;"> Saya akan selalu menjaga kerahasiaan informasi terkait Formulir Aplikasi ini dan/atau Polis Asuransi SmartTravel Internasional saya dari pihak-pihak yang tidak berkepentingan;</span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">16.</span>
												            <span style="flex: 1;">
												                Saya menyatakan setuju untuk menerima polis asuransi dan seluruh kelengkapan dokumennya dalam bentuk elektronik (epolicy) yang tidak dapat disunting/diubah serta Saya juga memahami, menyatakan dan menjamin bahwa e-policy ini
												                merupakan dokumen yang sah dan setara dengan polis asuransi dalam bentuk cetak (hardcopy). Oleh karenanya apabila dikemudian hari, Saya tetap membutuhkan polis asuransi beserta seluruh kelengkapan dokumennya dalam bentuk
												                cetak (hardcopy), maka Saya akan menghubungi Customer Call Center PT AXA Insurance Indonesia di nomor telepon : 1500733 (hari Senin s/d Jum'at, pukul 08.00 s/d 17.00 WIB) atau melalui email : <a style="color: blue; text-decoration: underline;" href="mailto:customer.general@axa.co.id">customer.general@axa.co.id</a>;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">17.</span> <span style="flex: 1;">Saya telah membaca, memahami, dan menyetujui setiap dan seluruh ketentuan Polis Asuransi SmartTravel Internasional.</span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;"><span style="flex-shrink: 0;">18.</span> <span style="flex: 1;">Jangka waktu perjalanan : </span></div>
												
												        <div style="display: flex; flex-direction: column; padding-left: 45px;">
												            <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												                <span style="flex-shrink: 0;">a.</span> <span style="flex: 1;"> Lamanya setiap perjalanan berdasarkan "Perjalanan Tunggal" tidak akan melebihi 90 (sembilan puluh) hari kalender sejak tanggal dimulainya Perjalanan. </span>
												            </div>
												            <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												                <span style="flex-shrink: 0;">b.</span>
												                <span style="flex: 1;">
												                    Lamanya setiap perjalanan berdasarkan "Program Setahun" tidak akan melebihi 90 (sembilan puluh) hari kalender dari tanggal dimulainya Perjalanan dan maksimum total perjalanan adalah 180 (seratus delapan puluh) hari
												                    kalender.
												                </span>
												            </div>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">19.</span> <span style="flex: 1;">Apabila terjadi kerugian, batas kewajiban dari PT AXA Insurance Indonesia harus dibaca sebagai berikut :</span>
												        </div>
												
												        <div style="display: flex; flex-direction: column; padding-left: 30px;">
												            Batas untuk individu: seperti yang tercantum dalam plan yang ditanggung.<br />
												            Batas untuk keluarga atau duo : dua kali dari batas limit individu yang tercantum dalam plan yang ditanggung.&nbsp;<br />
												            Berlaku untuk bagian berikut ini:<br />
												            Bagian 1 (satu) - Kecelakaan Diri<br />
												            Bagian 2 (dua) - Kecelakaan Diri dalam Penerbangan<br />
												            Bagian 3 (tiga) - Biaya Pengobatan, Gigi dan Lainnya<br />
												            Bagian 4 (empat) - Pemulangan Jenazah<br />
												            Bagian 5 (lima) - Manfaat Perawatan Anak dan Kunjungan duka<br />
												            Bagian 6 (enam) - Evakuasi Medis Darurat dan Repatriasi<br />
												            Bagian 9 (sembilan) - Kehilangan Uang Muka atau Pembatalan<br />
												            Bagian 23 (dua puluh tiga) - Kehilangan Pendapatan Akibat Kecelakaan<br />
												            Syarat dan ketentuan lainnya tetap tidak berubah
												        </div>
												    </div>
												</div>

												
												
                                            </div>
									</div>
								</div>
								<div class="accordion-item__agreement">
									<div class="accordion-header" id="stayAgreementThree">
										<div class="accordion-button collapsed"
											data-bs-toggle="collapse"
											data-bs-target="#collapseAgreementThree" aria-expanded="true"
											aria-controls="collapseAgreementThree">
											<div class="accordion-button__inner">
												<div class="accordion-button__left">
													<div class="checkbox-custom-wrapper">
														<input id="edit-3" class="checkbox-custom trigger-check"
															name="edit-3" type="checkbox"> <label
															for="edit-3" class="checkbox-custom-label"></label>
													</div>
												</div>
												<div class="accordion-button__right">
													<div class="policy">
														<p>Saya bersedia untuk menerima berita dan informasi
															dari AXA</p>
													</div>
													<i
														class="fas fa-chevron-down align-self-center agency__text-center"></i>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseAgreementThree"
										class="accordion-collapse collapse show">
										<div class="accordion-body">
											Dengan ini Saya/Kami menyetujui untuk dilakukan pemasaran,
											penawaran produk dan aktivitas promosi lainnya melalui sarana
											komunikasi pribadi Saya/Kami termasuk namun tidak terbatas
											pada email, telepon, SMS dan media komunikasi online lainnya.
											<br> <br>Dengan mencentang pernyataan ini, maka
											Anda menyatakan telah memberikan persetujuan.
											
											
										</div>
									</div>
								</div>
								<div class="accordion-item__agreement">
									<div class="accordion-header" id="stayAgreementFour">
										<div class="accordion-button collapsed"
											data-bs-toggle="collapse"
											data-bs-target="#collapseAgreementFour" aria-expanded="true"
											aria-controls="collapseAgreementFour">
											<div class="accordion-button__inner">
												<div class="accordion-button__left">
													<div class="checkbox-custom-wrapper">
														<input id="edit-4" class="checkbox-custom trigger-check"
															name="edit-4" type="checkbox"> <label
															for="edit-4" class="checkbox-custom-label"></label>
													</div>
												</div>
												<div class="accordion-button__right">
													<div class="policy">
														<p>Pernyataan PT AXA Insurance Indonesia</p>
													</div>
													<i
														class="fas fa-chevron-down align-self-center agency__text-center"></i>
												</div>
											</div>
										</div>
									</div>
									<div id="collapseAgreementFour"
										class="accordion-collapse collapse show">
										<div class="accordion-body">
											<ul>
												<li>PT AXA Insurance Indonesia berkomitmen untuk
													menjaga kerahasiaan dan melaksanakan pemrosesan data
													pribadi secara sah sesuai dengan ketentuan peraturan
													perundang-undangan yang berlaku, sampai dengan batas waktu
													yang telah ditentukan sesuai dengan kebijakan retensi PT
													AXA Insurance Indonesia kecuali penyimpanan lebih lanjut
													diperlukan untuk memenuhi periode retensi yang lebih lama
													untuk memenuhi persyaratan operasional, hukum, peraturan,
													pajak, atau akuntansi PT AXA Insurance Indonesia.</li>
												<li>PT AXA Insurance Indonesia akan menghancurkan atau
													menganonimkan dari catatan dan sistem cadangan PT AXA
													Insurance Indonesia sesuai dengan kebijakan retensi PT AXA
													Insurance Indonesia kecuali penyimpanan lebih lanjut
													diperlukan untuk memenuhi periode retensi yang lebih lama
													untuk memenuhi persyaratan operasional, hukum, peraturan,
													pajak, atau akuntansi PT AXA Insurance Indonesia.</li>
												<li>PT AXA Insurance Indonesia memberikan hak akses
													untuk mendapatkan salinan, melengkapi dan/atau
													memperbaharui kesalahan data dan informasi pribadi Nasabah
													berdasarkan permintaan tertulis dari Nasabah.</li>
												<li>PT AXA Insurance Indonesia memberikan hak kepada
													Nasabah untuk menarik kembali persetujuan mengenai
													pemrosesan data pribadi Nasabah, mengakhiri pemrosesan,
													menghapus, dan/atau memusnahkan data pribadi Nasabah, serta
													hak-hak lainnya sesuai dengan ketentuan peraturan
													perundang-undangan yang berlaku berdasarkan permintaan
													tertulis dari Nasabah.</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="dashboard-right agency__bg-white">
					<div class="dashboard-right__summary">
						<!-- <div class="products">
							
							render plan here
							<div class="container_sideplan"></div>

							<div class="summary-product">
								<div class="input-col">
									<label class="label__travel" for="">Kode Promo</label>
									<div class="input-group input-group-axa">
										<input
											class="input-control input-control-axa normal-case input-control--outline"
											type="text" id="" placeholder="Masukkan Kode Promo">
										<span class="btn-group btnClear"> <svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="17"
												viewBox="0 0 16 17" fill="none">
                                                    <path
													d="M2.11861 10.4996C2.95844 13.0548 5.36373 14.8996 8.1999 14.8996C11.7345 14.8996 14.5999 12.0342 14.5999 8.49961C14.5999 4.96499 11.7345 2.09961 8.1999 2.09961C5.831 2.09961 3.7627 3.38664 2.65611 5.29961M2.11861 4.67437L3.00016 5.49967M4.5999 6.09961H1.3999V2.89961L4.5999 6.09961Z"
													stroke-width="1.25" stroke-linecap="round"
													stroke-linejoin="round"></path>
                                                </svg>
										</span>
									</div>
								</div>

								

								render diskon here
								<div class="container_sidepanel_discount"></div>

								<div class="mt-5level agency__text-center divbutton-submit">
									<a class="btn btn__agency btn--dark-blue width-full"
										onclick="proccessPayment()"> <span
										class="position-relative agency__uppercase agency__pointer">Lanjut
											ke Pembayaran <i class="fas fa-arrow-right"></i>
									</span>
									</a>
								</div>
							</div>
						</div> -->
						
						
						<!-- <div class="col-tabstep2">
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
										<div class="flex-justify-between mb-1level">
											<span>Biaya Polis</span> <span></span> <span
												class="text_nondiscount agency__w-1per3"
												id="PlanSummary-PolicyCost">-</span>
										</div>
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
													<td style="padding-left: 40px;" class="agency__text-axa-ocean-100">-</td>
												</tr>
												<tr class="gohide">
													<td>Total Premi</td>
													<td class="total-premi pl-85px">USD 4.233</td>
												</tr>
												<tr>
													<td>Total Premi</td>
													<td style="font-size: clamp(14px, 2vw, 24px); padding-left: 40px;"  class="cost-total-premi2"
														id="PlanSummary-TotalPremiPrice">-</td>
												</tr>
												<tr class="gohide">
													<td></td>
													<td class="agency__text-axa-ocean-100 pl-85px">-</td>
												</tr>
											</tbody>
										</table>
									</div>

									<div class="sidebar-nav">
										<a class="btn_riplay btn btn--dark-blue width-full" href="javascript:void(0)"  onclick="proccessPayment()"> 
											<span class="position-relative text-transform-uppercase">
									            <span id="btn-text">Lanjut Ke Pembayaran  <i class="fas fa-arrow-right"></i></span> 
									        </span>
										</a>
									</div>

								</div>
							</div> -->
							
							<div class="col-tabstep2">
								<%@ include file="/includes/sidebar.jsp" %>
							</div>
							
					</div>
				</div>


			</div>
		</div>
	</div>
</section>


<!-- MODAL IS PEP -->    
<div class="ispep_modal" id="ispepModal">
        <!-- Modal Inner -->
        <div class="ispep_modal__inner">
            <!-- Modal Header -->
            <div class="ispep_modal__inner-header" style="font-size: 30px;">
                <span class="ispep_modal__inner-header-inner">
                    <i class="text-4xl fas fa-exclamation-triangle"></i>
                </span>
            </div>

            <!-- Modal Content -->
            <div class="ispep_modal__inner-content">
                <div class="ispep_modal__inner-content-h1" style="font-family:Publico ; font-size: 24px; color: rgb(18 56 116);">Informasi</div>
                <p class="ispep_modal__inner-content-p content-message-popup-ispep">
                    <!-- message dinamis here -->
                </p>
            </div>

            <!-- Modal Footer -->
            <div class="ispep_modal__inner-footer">
                <button onclick="closeModalIspep()" class="ispep_modal__inner-footer-btn">
                    <i class="fas fa-check"></i> OK
                </button>
            </div>
        </div>
    </div>    
    

<!-- MODAL ALERT BLOCKED -->
    <div id="modal_alert" class="modal_alert agency__hidden">
        <div class="modal_alert-content">
            <!-- Tombol Tutup -->
            <!-- <button onclick="closeModalAlertBlocked()" class="modal_alert-close-button">&times;</button> -->

            <!-- Bagian Title -->
            <div class="modal_alert-title">
                <h2>Perhatian</h2>
            </div>

            <!-- Garis Pemisah -->
            <hr class="modal_alert-divider">
			
            <!-- Bagian Content -->
            <div class="modal_alert-body">
			
				<!-- content message akan di update disini -->
			
            </div>
            
            <div class="ispep_modal__inner-footer" style="text-align: center; margin-top: 40px;">
                <button onclick="closeModalAlertBlocked()" class="ispep_modal__inner-footer-btn">
                    <i class="fas fa-check"></i> OK
                </button>
            </div>
        </div>
    </div> 


<!-- footer -->
<%@ include file="/includes/footer.jsp"%>

<script src="<%=request.getContextPath()%>/js/step4.js?v=<%=numericTimestamptimestampForJSURI%>" type="text/javascript"></script>


