<%@ include file="/init.jsp" %>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>

<%
	String _step = "three";

	List<SmartActiveLink> files = (List<SmartActiveLink>) renderRequest.getAttribute("files");
	String infoProduk = (String) renderRequest.getAttribute("info-produk");
	String fiturUtama = (String) renderRequest.getAttribute("fitur-utama");
	String manfaat = (String) renderRequest.getAttribute("manfaat");
	String risiko = (String) renderRequest.getAttribute("risiko");
	String biaya = (String) renderRequest.getAttribute("biaya");
	String pengecualian = (String) renderRequest.getAttribute("pengecualian");
	String persyaratan = (String) renderRequest.getAttribute("persyaratan");
	String simulasi = (String) renderRequest.getAttribute("simulasi");
	String infoTambahan = (String) renderRequest.getAttribute("info-tambahan");
	String managedBy = (String) renderRequest.getAttribute("managedBy");
	String aParam = (String) renderRequest.getAttribute("a");
	String rcParam = (String) renderRequest.getAttribute("rc");
	String bParam = (String) renderRequest.getAttribute("b");
	String businessModel = (String) renderRequest.getAttribute("businessModel");
	String promoCode = Validator.isNotNull((String) renderRequest.getAttribute("pc")) ? (String) renderRequest.getAttribute("pc") : "";
	String prettyUrl = Validator.isNotNull((String) renderRequest.getAttribute("pu")) ? (String) renderRequest.getAttribute("pu") : "";
	String agentCode = Validator.isNotNull((String) renderRequest.getAttribute("agentCode")) ? (String) renderRequest.getAttribute("agentCode") : "";
	String agentName = Validator.isNotNull((String) renderRequest.getAttribute("agentName")) ? (String) renderRequest.getAttribute("agentName") : "";
	String mobile = Validator.isNotNull((String) renderRequest.getAttribute("mobile")) ? (String) renderRequest.getAttribute("mobile") : "";
	String leadsTemp = Validator.isNotNull((String) renderRequest.getAttribute("qt")) ? (String) renderRequest.getAttribute("qt") : "";
	String csrfToken = Validator.isNotNull((String) renderRequest.getAttribute("CSRF_TOKEN")) ? (String) renderRequest.getAttribute("CSRF_TOKEN") : "";
	
	String portalURL = themeDisplay.getPortalURL();
%>

<portlet:renderURL var="paymentURL">
	<portlet:param name="mvcPath" value="/dashboard/payment.jsp"></portlet:param>
</portlet:renderURL>

<portlet:resourceURL id="settransaction" var="setTransactionURL" />

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/navbar.jsp" %>
<% } %>

<header class="hero<% if (Validator.isNotNull(mobile)) { %> hero-mobile<% } %>">
	<img src="/o/mypage-theme/images/banner_step_sa.png" alt="Axa SmartActive" class="width-full height-full">
</header>

<section class="step-three" id="Step-3">
	<input type="hidden" name="csrfToken" value="<%= csrfToken %>" />
	<%@ include file="/includes/stepbar.jsp" %>

	<div class="sa-agreement">
		<div class="container-axa">
			<div class="agreement-grid">
				<div class="sa-agreement__left">
					<div class="panel">
                        <div class="panel__heading"><h1>Ringkasan Informasi Produk dan Layanan<br /> (RIPLAY) Versi Personal</h1></div>
                        <div class="panel__body">
                            
                            <%=infoProduk%>
                            
                            <!-- <ul class="riplay">
                                <li>
                                    <span>Nama Penerbit : </span>
                                    <span>PT AXA Insurance Indonesia</span>
                                </li>
                                <li>
                                    <span>Nama Produk : </span>
                                    <span>Asuransi SmartActive</span>
                                </li>
                                <li>
                                    <span>Jenis Produk : </span>
                                    <span>Asuransi Perlindungan</span>
                                </li>
                                <li>
                                    <span>Deskripsi Produk : </span>
                                    <span>
                                        Produk Asuransi International Exclusive merupakan asuransi kesehatan internasional yang dibuat khusus untuk memenuhi kebutuhan nasabah akan pertanggungan kesehatan dengan akses jaringan rumah sakit di seluruh dunia. Akses layanan jasa bantuan untuk produk asuransi International Exclusive selama 24 jam. Manfaat yang diperoleh berupa menjamin biaya Kesehatan yang timbul baik Rawat Inap, Rawat Harian, Rawat Jalan, Gigi, Persalinan serta manfaat lainnya sesuai dengan kondisi dan manfaat polis.
                                    </span>
                                </li>
                            </ul> -->

							<div class="accordion" id="accordionRiplay">
								
								<div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
											Fitur Utama Asuransi Umum Anda                            
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
										
										<div class="sa-accordion-body fitur-utama" style="padding-left: 10px;">
										
											<%=fiturUtama%> 
											
											<!-- <p>
												Dijamin, dengan ketentuan yang mengalami keterlambatan adalah pada pesawat kedua, minimal 4 jam. Apabila pesawat pertama terlambat dan menyebabkan tertanggung tertinggal untuk penerbangan lanjutan, maka keterlambatan tersebut tidak dijamin.
											</p> -->
										</div>
										
									</div>
								</div>

								<div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
											Manfaat dan Resiko
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
										
										<%=manfaat %>
										
										<!-- <div class="sa-accordion-body">
											<p>
												Dijamin, dengan ketentuan yang mengalami keterlambatan adalah pada pesawat kedua, minimal 4 jam. Apabila pesawat pertama terlambat dan menyebabkan tertanggung tertinggal untuk penerbangan lanjutan, maka keterlambatan tersebut tidak dijamin.
											</p>
										</div> -->
										
										
									</div>
								</div>

								<!-- <div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
											Informasi penting tentang plan Anda                            
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
										<div class="sa-accordion-body">
											<p>
												Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda qui optio vero maxime omnis velit, quasi cumque veritatis sed tenetur id dicta, sint nostrum ex molestias, fugiat alias earum deleniti.
											</p>
										</div>
									</div>
								</div> -->

								<!-- <div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
											Risiko                            
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseFour" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
									</div>
								</div> -->

								<div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
											Biaya                            
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseFive" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
										
										<%=biaya %>
										
										<!-- <div class="sa-accordion-body">
											<p>
												Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda qui optio vero maxime omnis velit, quasi cumque veritatis sed tenetur id dicta, sint nostrum ex molestias, fugiat alias earum deleniti.
											</p>
										</div> -->
									</div>
								</div>

								<div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
											Pengecualian                            
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseSix" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
										
										<%=pengecualian %>
										
										
										<!-- <div class="sa-accordion-body">
											<p>
												Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda qui optio vero maxime omnis velit, quasi cumque veritatis sed tenetur id dicta, sint nostrum ex molestias, fugiat alias earum deleniti.
											</p>
										</div> -->
									</div>
								</div>

								<div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
											Persyaratan dan tata cara                            
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseSeven" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
										
										
										<%=persyaratan %>
										
										<!-- <div class="sa-accordion-body">
											<p>
												Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda qui optio vero maxime omnis velit, quasi cumque veritatis sed tenetur id dicta, sint nostrum ex molestias, fugiat alias earum deleniti.
											</p>
										</div> -->
									</div>
								</div>

								<div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
											Simulasi                            
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseEight" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
										
										<%=simulasi %>
										
										<!-- <div class="sa-accordion-body">
											<p>
												Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda qui optio vero maxime omnis velit, quasi cumque veritatis sed tenetur id dicta, sint nostrum ex molestias, fugiat alias earum deleniti.
											</p>
										</div> -->
									</div>
								</div>

								<div class="accordion-item">
									<div class="accordion-header">
										<button class="sa-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseNine" aria-expanded="false" aria-controls="collapseNine">
											Informasi Tambahan                            
											<i class="fas fa-chevron-down position-absolute right-8level mt-1level text-13px"></i>
										</button>
									</div>
									<div id="collapseNine" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
										<div class="sa-accordion-body">
											
											<%=infoTambahan %>
											
										</div>
										
									</div>
								</div>
								
								
								<!-- CATATAN PENTING -->
								 <div id="collapseTen mt-1level">
										<div class="sa-accordion-body">
											
											
											<div class="info-tambahans" style="text-align: justify;">
												<p>
													<strong>Catatan Penting :</strong>
												</p>
												
												<ol>
											        <li>
											            Ringkasan Informasi Produk dan Layanan ini bukan merupakan Kontrak Asuransi maupun bagian dari Polis Asuransi.
											        </li>
											        <li>Bagian dari premi yang berupa biaya akuisisi dialokasikan sebagai diskon dan/atau komisi bagi pihak tertanggung dan/atau pihak pemasar Produk Asuransi ini. </li>
											        <li>Produk yang dipasarkan adalah Produk Asuransi. </li>
											        <li>
											            Semua Pihak yang membaca dan menggunakan Ringkasan Informasi Produk dan Layanan ini agar memperhatikan syarat-syarat, ketentuan dan penggunaan yang berlaku. Apabila terdapat pertanyaan, keluhan atau informasi lanjutan, dapat menghubungi PT AXA Insurance Indonesia Customer Care Center di 1500733, email ke
											            <a style="color: blue; text-decoration: underline;" href="mailto:customer.general@axa.co.id">customer.general@axa.co.id</a>
											            atau melalui website di
											            <a style="color: blue; text-decoration: underline;" href="https://www.axa.co.id" target="_blank">www.axa.co.id</a>.
											        </li>
											
											        <li>Produk Asuransi ini telah mendapatkan persetujuan dari dan diawasi oleh Otoritas Jasa Keuangan (OJK).</li>
											    </ol>
											    <br />
											    <p>
											        <strong>Disclaimer (penting untuk dibaca) :</strong>
											    </p>
											    <ol>

											        <li>Ringkasan Informasi Produk dan Layanan ini dibuat dan dipersiapkan oleh PT AXA Insurance Indonesia dan dipergunakan sebagai informasi bagi Anda mengenai produk Asuransi <em>SmartActive</em> (<em>SmartActive Insurance</em>) dari PT AXA Insurance Indonesia pada tanggal <span id="thisTime"></span> waktu sistem AXA MyPage dan berlaku sampai dengan batas waktu pembayaran. </li>
											        <li>Anda telah membaca, menerima penjelasan, dan memahami produk Asuransi <em>SmartActive</em> (<em>SmartActive Insurance</em>) sesuai Ringkasan Informasi Produk dan Layanan </li>
											        <li>Ringkasan Informasi Produk dan Layanan ini bukan merupakan bagian dari aplikasi pengajuan asuransi dan polis  </li>
											        <li>Anda wajib untuk membaca, memahami dan menandatangani aplikasi pengajuan asuransi dan polis </li>
											        <li>
											            Anda harus membaca dengan teliti Ringkasan Informasi Produk dan Layanan ini sebelum menyetujui pembelian produk dan berhak bertanya kepada pegawai PT AXA Insurance Indonesia atas semua hal terkait Ringkasan Informasi Produk dan Layanan ini
											        </li>
											    </ol>
											    <br>
											    <p><strong>Penggunaan Data Pribadi dan Pengalihan Sistem Elektronik </strong> </p>
											    <p style="text-align: justify;">Saya menyetujui bahwa data dan informasi pribadi yang Saya/Kami berikan kepada PT AXA Insurance Indonesia dapat dikirimkan oleh PT AXA Insurance Indonesia kepada pihak lain yang bekerjasama dengan dan/atau ditunjuk oleh PT AXA<br>

                                                   Insurance Indonesia, Regulator dan Pihak yang Berwenang dan/atau Asosiasi sehubungan dengan keperluan operasional<br>

                                                   PT AXA Insurance Indonesia termasuk namun tidak terbatas pada keperluan pertanggungan asuransi Saya/Kami, proses

                                                   penutupan asuransi, proses reasuransi dan klaim. Saya menyatakan setuju bahwa data pribadi saya akan dialihkan dan

                                                   disimpan dalam sistem elektronik milik PT AXA Insurance Indonesia, sesuai dengan ketentuan peraturan perundang-undangan yang berlaku mengenai perlindungan data pribadi. </p>
											</div>
											<br />

											<div class="radio-wrapper">
												<div class="sa-radio-custom-wrapper">
													<input type="radio" name="radio-polis" value="Ya" id="radio-polis-2" required="">
													<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-polis-2">
														<span class="radio-cloak"></span>
														<span>Iya</span>
													</label>
												</div>
												<div class="sa-radio-custom-wrapper">
													<input type="radio" name="radio-polis" value="Tidak" id="radio-polis-1" required="">
													<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-polis-1">
														<span class="radio-cloak"></span>
														<span>Tidak</span>
													</label>
												</div>
											</div>
										</div>
										
									</div> 
			
							</div>
							
						</div>
					</div>

					<div class="panel">
						<div class="panel__heading"><h1>Persetujuan</h1></div>
						<div class="panel__body">
							<div class="accordion" id="accordionAgreement">
							
							<div class="accordion-item">
									<div class="accordion-header">
										<div class="sa-checkbox-custom-wrapper">
											<input type="checkbox" name="checkbox-persetujuan-2" id="checkbox-persetujuan-2" required="">
											<label class="sa-label sa-checkbox-custom-label align-self-center mb-0px" for="checkbox-persetujuan-2">
												<span class="checkbox-cloak"></span>
											</label>
										</div>
										<div class="sa-accordion-button collapsed align-self-center" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwelve" aria-expanded="false" aria-controls="collapseTwelve">
											<span class="btn-text">Saya sudah membaca dan menyetujui pernyataan dan penggunaan data pribadi <sup style="color: red;">*</sup></span>
											<i class="fas fa-chevron-down text-13px"></i>
										</div>
									</div>
									<div id="collapseTwelve" class="accordion-collapse collapse" data-bs-parent="#accordionAgreement">
										<div class="sa-accordion-body" style="text-align: justify;">
											
												Dengan ini Saya/Kami menyetujui bahwa data dan informasi pribadi yang Saya/Kami berikan kepada PT AXA Insurance Indonesia dapat dikirimkan oleh PT AXA Insurance Indonesia kepada pihak lain yang bekerjasama dengan dan/atau ditunjuk oleh PT AXA Insurance Indonesia, Regulator dan Pihak yang Berwenang dan/atau Asosiasi sehubungan dengan keperluan operasional PT AXA Insurance Indonesia terkait pertanggungan asuransi Saya/Kami, proses penutupan asuransi, proses reasuransi dan klaim.

											
											<br>
											<br>Dengan mencentang pernyataan ini, maka Anda
											menyatakan telah memberikan persetujuan.
											
										</div>
									</div>
								</div>
							
								<div class="accordion-item">
									<div class="accordion-header">
										<div class="sa-checkbox-custom-wrapper">
											<input type="checkbox" name="checkbox-persetujuan-1" id="checkbox-persetujuan-1" required="">
											<label class="sa-label sa-checkbox-custom-label align-self-center mb-0px" for="checkbox-persetujuan-1">
												<span class="checkbox-cloak"></span>
											</label>
										</div>
										<div class="sa-accordion-button collapsed align-self-center" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEleven" aria-expanded="false" aria-controls="collapseEleven">
											<span class="btn-text">Saya sudah membaca dan menyetujui pernyataan kuasa dan persetujuan <sup style="color: red;">*</sup></span>
											<i class="fas fa-chevron-down text-13px"></i>
										</div>
									</div>
									<div id="collapseEleven" class="accordion-collapse collapse" data-bs-parent="#accordionAgreement">
										<div class="accordion-body" style="text-align: justify;">
                                                <span style="text-align: justify;">Dengan mengirimkan aplikasi dan dokumen kelengkapan ini, saya memahami, menyatakan, memberikan persetujuan, dan menjamin bahwa:</span>
												<div class="point" style="text-align: justify;">
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">1.</span>
												            <span style="flex: 1;">
												                Setiap dan seluruh pernyataan, informasi, dan/atau data yang saya berikan, umumkan, kirimkan, atau tampilkan pada Formulir Aplikasi Asuransi ini, atau konfirmasi lain sehubungan dengan Formulir Aplikasi Asuransi ini adalah benar, akurat, lengkap, dan terkini sesuai dengan keadaan saat ini, dan saya sepakat untuk menjamin dan bertanggung jawab atas kebenaran pernyataan, informasi, dan/atau data tersebut;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">2.</span>
												            <span style="flex: 1;">
												                Setiap dan seluruh data serta informasi yang saya berikan, umumkan, kirimkan, atau tampilkan pada Formulir Aplikasi Asuransi ini akan menjadi dasar dan bagian dari Polis, termasuk setiap dan seluruh ketentuan umum Polis <i>`Asuransi SmartActive`</i>;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">3.</span>
												            <span style="flex: 1;">
												                Jika saya terbukti memberikan data, pernyataan, informasi dan jawaban yang tidak benar atau tidak lengkap secara sengaja maupun tidak sengaja, saya sadar, memahami dan menyetujui bahwa PT AXA Insurance Indonesia memiliki hak untuk membatalkan Polis ini. Tanpa berkewajiban untuk membayar manfaat apapun atau mengembalikan premi yang telah saya bayarkan;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">4.</span>
												            <span style="flex: 1;">
												                Dengan ini saya menyatakan bahwa transkasi ini tidak melanggar pencucian uang, korupsi, pendanaan terorisme, anggota terorisme dan pendanaan poliferasi. Jika saya terlibat, terpapar baik sengaja maupun tidak sengaja dalam pencucian uang, korupsi, pendanaan terorisme, anggota terorisme dan pendanaan poliferasi, saya sadar memahami dan menyetujui bahwa PT AXA Insurance Indonesia memiliki hak untuk membatalkan Polis ini, tanpa berkewajiban untuk membayar manfaat apapun atau mengembalikan premi yang telah saya bayarkan;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">5.</span>
												            <span style="flex: 1;">
												                Saya telah membaca, memahami, dan menyetujui isi dan ketentuan pada Polis Asuransi SmartActive ini. Sehubungan dengan hal tersebut, dengan ini saya memahami, menyatakan, menjamin, dan berusaha dengan usaha terbaik saya dalam menyebabkan ahli waris, keluarga, atau pun pihak yang mengatasnamakan saya untuk selamanya melepaskan serta membebaskan PT AXA Insurance Indonesia, direktur-direktur, komisaris-komisaris, karyawan-karyawan, dan/atau afiliasi-afiliasinya, dari segala bentuk tindakan atau upaya hukum yang saya miliki atau mungkin miliki secara langsung dan/atau tidak langsung sehubungan dengan penggunaan data saya, dan apabila pada kemudian hari terdapat data, serta korespondensi tertulis terkait Formulir Aplikasi Asuransi ini dan/atau Polis yang tidak benar, maka saya bersedia untuk mempertanggungjawabkannya sesuai ketentuan dan hukum yang berlaku;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">6.</span>
												            <span style="flex: 1;">
												                Saya memberi kuasa kepada PT AXA Insurance Indonesia untuk mendapatkan informasi terkait Polis Asuransi SmartActive saya dari pihak manapun, termasuk di antaranya yaitu lembaga hukum, individu, perusahaan, dan organisasi yang mengetahui dan/atau memiliki catatan atau informasi tentang saya;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">7.</span>
												            <span style="flex: 1;">
												                PT AXA Insurance Indonesia untuk dapat menyimpan, menggunakan, dan mengungkapkan data saya kepada pihak ketiga manapun (sebagaimana diperlukan) sehubungan dengan pelaksanaan penutupan pertanggungan ini;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">8.</span> <span style="flex: 1;"> Saya akan selalu melakukan pengkinian atas informasi atau data atau data pribadi sehubungan dengan Formulir Aplikasi ini dan/atau Polis Asuransi SmartActive saya; </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">9.</span>
												            <span style="flex: 1;"> Saya akan selalu menjaga kerahasiaan informasi terkait Formulir Aplikasi ini dan/atau Polis Asuransi SmartActive saya dari pihak-pihak yang tidak berkepentingan;</span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">10.</span>
												            <span style="flex: 1;">
												                Saya menyatakan setuju untuk menerima polis asuransi dan seluruh kelengkapan dokumennya dalam bentuk elektronik (epolicy) yang tidak dapat disunting/diubah serta Saya juga memahami, menyatakan dan menjamin bahwa e-policy ini merupakan dokumen yang sah dan setara dengan polis asuransi dalam bentuk cetak (hardcopy). Oleh karenanya apabila dikemudian hari, Saya tetap membutuhkan polis asuransi beserta seluruh kelengkapan dokumennya dalam bentuk cetak (hardcopy), maka Saya akan menghubungi Customer Call Center PT AXA Insurance Indonesia di nomor telepon : 1500733 (hari Senin s/d Jum'at, pukul 08.00 s/d 17.00 WIB) atau melalui email : <a style="color: blue; text-decoration: underline;" href="mailto:customer.general@axa.co.id">customer.general@axa.co.id</a>;
												            </span>
												        </div>
												    </div>
												
												    <div style="display: flex; flex-direction: column; padding-left: 20px;">
												        <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
												            <span style="flex-shrink: 0;">11.</span> <span style="flex: 1;">Saya telah membaca, memahami, dan menyetujui setiap dan seluruh ketentuan Polis Asuransi SmartActive;</span>
												        </div>
												    </div>
												
												    
												    
												</div>

												
												
                                            </div>
									</div>
								</div>

								

								<div class="accordion-item">
									<div class="accordion-header">
										<div class="sa-checkbox-custom-wrapper">
											<input type="checkbox" name="checkbox-persetujuan-3" id="checkbox-persetujuan-3" required="">
											<label class="sa-label sa-checkbox-custom-label align-self-center mb-0px" for="checkbox-persetujuan-3">
												<span class="checkbox-cloak"></span>
											</label>
										</div>
										<div class="sa-accordion-button collapsed align-self-center" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThirteen" aria-expanded="false" aria-controls="collapseThirteen">
											<span class="btn-text">Saya bersedia untuk menerima berita dan informasi dari AXA </span>
											<i class="fas fa-chevron-down text-13px"></i>
										</div>
									</div>
									<div id="collapseThirteen" class="accordion-collapse collapse" data-bs-parent="#accordionAgreement">
										<div class="sa-accordion-body" style="text-align: justify;">
											Dengan ini Saya/Kami menyetujui untuk dilakukan pemasaran, penawaran produk dan aktivitas promosi lainnya melalui sarana komunikasi pribadi Saya/Kami termasuk namun tidak terbatas pada email, telepon, SMS dan media komunikasi online lainnya.
											
											<br>
											<br>
											Dengan mencentang pernyataan ini, maka Anda menyatakan telah memberikan persetujuan.
										</div>
									</div>
								</div>

								<div class="accordion-item">
									<div class="accordion-header">
										
										<!-- <div class="sa-checkbox-custom-wrapper">
											<input type="checkbox" name="checkbox-persetujuan-4" id="checkbox-persetujuan-4" required="">
											<label class="sa-label sa-checkbox-custom-label align-self-center mb-0px" for="checkbox-persetujuan-4">
												<span class="checkbox-cloak"></span>
											</label>
										</div> -->
										
										<div class="sa-accordion-button collapsed align-self-center" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFourteen" aria-expanded="false" aria-controls="collapseFourteen">
											<span class="btn-text">Pernyataan PT AXA Insurance Indonesia</span>
											<i class="fas fa-chevron-down text-13px"></i>
										</div>
									</div>
									<div id="collapseFourteen" class="accordion-collapse collapse" data-bs-parent="#accordionAgreement">
										<div class="sa-accordion-body" style="text-align: justify;">
											<ol>
												<li>PT AXA Insurance Indonesia berkomitmen untuk menjaga kerahasiaan dan melaksanakan pemrosesan data pribadi secara sah sesuai dengan ketentuan peraturan perundang-undangan yang berlaku, sampai dengan batas waktu yang telah ditentukan sesuai dengan kebijakan retensi PT AXA Insurance Indonesia kecuali penyimpanan lebih lanjut diperlukan untuk memenuhi periode retensi yang lebih lama untuk memenuhi persyaratan operasional, hukum, peraturan, pajak, atau akuntansi PT AXA Insurance Indonesia.</li>
												<li>PT AXA Insurance Indonesia akan menghancurkan atau menganonimkan dari catatan dan sistem cadangan PT AXA Insurance Indonesia sesuai dengan kebijakan retensi PT AXA Insurance Indonesia kecuali penyimpanan lebih lanjut diperlukan untuk memenuhi periode retensi yang lebih lama untuk memenuhi persyaratan operasional, hukum, peraturan, pajak, atau akuntansi PT AXA Insurance Indonesia.</li>
												<li>PT AXA Insurance Indonesia memberikan hak akses untuk mendapatkan salinan, melengkapi dan/atau memperbaharui kesalahan data dan informasi pribadi Nasabah berdasarkan permintaan tertulis dari Nasabah.</li>
												<li>PT AXA Insurance Indonesia memberikan hak kepada Nasabah untuk menarik kembali persetujuan mengenai pemrosesan data pribadi Nasabah, mengakhiri pemrosesan, menghapus, dan/atau memusnahkan data pribadi Nasabah, serta hak-hak lainnya sesuai dengan ketentuan peraturan perundang-undangan yang berlaku berdasarkan permintaan tertulis dari Nasabah.</li>
											</ol>
										</div>
									</div>
								</div>
	
							</div>
						</div>
					</div>
				</div>

				<div class="sa-agreement__right">
					<%@ include file="/includes/panel_summary.jsp" %>
				</div>
			</div>
		</div>
	</div>

</section>

<%-- <%@ include file="/includes/sticky.jsp" %> --%>

<%@ include file="/includes/modal.jsp" %>

<script src="<%= request.getContextPath() %>/js/main.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>
<script type="text/javascript">
	var _nextStepURL = "<%= paymentURL %>";
	var _apiURL = "<%= portalURL %>";
	var _setTransactionURL = "<%= setTransactionURL %>";
	var _step = "<%= _step %>";
	var businessModel = '<%= businessModel %>'.trim();
	var mobile = <% if (mobile.isEmpty()) { %>""<% } else { %><%= mobile %><% } %>;
	
	var leadsTemp = '<%= leadsTemp %>';
	if (leadsTemp !== "null" && leadsTemp !== "") {
	    updateSess(_smartActiveFormDetailSess, "LeadsTemp", leadsTemp);
	}
</script>
<script src="<%= request.getContextPath() %>/js/step4.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/footer.jsp" %>
<% } %>