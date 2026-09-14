<%@ include file="/init.jsp" %>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);

	String infoProduk = (String) renderRequest.getAttribute("info-produk");
	String fiturUtama = (String) renderRequest.getAttribute("fitur-utama");
	String manfaat = (String) renderRequest.getAttribute("manfaat");
	String risiko = (String) renderRequest.getAttribute("risiko");
	String biaya = (String) renderRequest.getAttribute("biaya");
	String pengecualian = (String) renderRequest.getAttribute("pengecualian");
	String persyaratan = (String) renderRequest.getAttribute("persyaratan");
	String simulasi = (String) renderRequest.getAttribute("simulasi");
	String infoTambahan = (String) renderRequest.getAttribute("info-tambahan");
	String persetujuan = (String) renderRequest.getAttribute("persetujuan");

	Boolean submitted = (Boolean) renderRequest.getAttribute("submitted");
	String csrfToken = Optional.ofNullable((String) renderRequest.getAttribute("CSRF_TOKEN")).orElse("");
%>

<portlet:resourceURL id="signAgreement" var="signAgreementURL" />

<portlet:renderURL var="stepSuccessBaseURL">
	<portlet:param name="mvcPath" value="/success.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="stepFailedBaseURL">
	<portlet:param name="mvcPath" value="/failed.jsp"></portlet:param>
</portlet:renderURL>

<%@ include file="/includes/header.jsp" %>

<div class="esppk-agreement">
    <div class="container-axa">
        <div class="agreement-grid">
            <div class="esppk-agreement__left">
                <input type="hidden" name="csrfToken" value="<%= csrfToken %>" />
                <div class="panel py-[90px] xL:py-[20px]">
                    <div class="panel__heading"><h1 class="font-bold text-[#274168]">Ringkasan Informasi Produk dan Layanan (RIPLAY) Versi Umum</h1></div>
                    <div class="panel__body">

                        <%=infoProduk%>

                        <div class="accordion" id="accordionRiplay">
                            <div class="accordion-item-wrapper">
                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="esppk-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                            Fitur Utama Asuransi Umum Anda
                                            <i class="fas fa-chevron-down absolute right-8 mt-1 text-[13px]"></i>
                                        </button>
                                    </div>
                                    <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
                                        <div class="esppk-accordion-body fitur-utama" style="padding-left: 10px;">

                                            <%=fiturUtama%>

                                        </div>
                                    </div>
                                </div>

                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="esppk-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                            Manfaat
                                            <i class="fas fa-chevron-down absolute right-8 mt-1 text-[13px]"></i>
                                        </button>
                                    </div>
                                    <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">

                                        <%=manfaat %>

                                    </div>
                                </div>

                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="esppk-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                            Risiko
                                            <i class="fas fa-chevron-down absolute right-8 mt-1 text-[13px]"></i>
                                        </button>
                                    </div>
                                    <div id="collapseFour" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">

                                        <%=risiko %>

                                    </div>
                                </div>

                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="esppk-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                            Biaya
                                            <i class="fas fa-chevron-down absolute right-8 mt-1 text-[13px]"></i>
                                        </button>
                                    </div>
                                    <div id="collapseFive" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">

                                        <%=biaya %>

                                    </div>
                                </div>

                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="esppk-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                                            Pengecualian
                                            <i class="fas fa-chevron-down absolute right-8 mt-1 text-[13px]"></i>
                                        </button>
                                    </div>
                                    <div id="collapseSix" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">

                                        <%=pengecualian %>

                                    </div>
                                </div>

                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="esppk-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
                                            Persyaratan dan tata cara
                                            <i class="fas fa-chevron-down absolute right-8 mt-1 text-[13px]"></i>
                                        </button>
                                    </div>
                                    <div id="collapseSeven" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">

                                        <%=persyaratan %>

                                    </div>
                                </div>

                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="esppk-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
                                            Simulasi
                                            <i class="fas fa-chevron-down absolute right-8 mt-1 text-[13px]"></i>
                                        </button>
                                    </div>
                                    <div id="collapseEight" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">

                                        <%=simulasi %>

                                    </div>
                                </div>

                                <div class="accordion-item">
                                    <div class="accordion-header">
                                        <button class="esppk-accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseNine" aria-expanded="false" aria-controls="collapseNine">
                                            Informasi Tambahan
                                            <i class="fas fa-chevron-down absolute right-8 mt-1 text-[13px]"></i>
                                        </button>
                                    </div>
                                    <div id="collapseNine" class="accordion-collapse collapse" data-bs-parent="#accordionRiplay">
                                        <div class="esppk-accordion-body">

                                            <%=infoTambahan %>

                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- CATATAN PENTING -->
                             <div id="collapseTen mt-1">
                                <div class="esppk-accordion-body">
                                    <div class="catatan-penting" style="text-align: justify;">
                                        <p>
                                            <strong>Catatan Penting :</strong>
                                        </p>
                                        <ol>
                                            <li>
                                                Ringkasan Informasi Produk dan Layanan ini dibuat dan dipersiapkan oleh PT AXA Insurance Indonesia dan dipergunakan sebagai informasi bagi Tertanggung mengenai produk Proteksi Kecelakaan Diri Plus dari PT AXA Insurance Indonesia.
                                            </li>
                                            <li>Ringkasan Informasi Produk dan Layanan ini bukan merupakan Kontrak Asuransi maupun bagian dari Polis Asuransi.</li>
                                            <li>Bagian dari premi yang berupa biaya akuisisi dialokasikan sebagai diskon dan/atau komisi bagi pihak tertanggung dan/atau pihak pemasar (agen/broker/intermediary lainnya)</li>
                                            <li>Produk yang dipasarkan adalah produk asuransi dan bukan merupakan produk Bank dan bukan tanggung jawab Bank serta tidak dijamin oleh Lembaga Penjamin Simpanan (LPS).</li>
                                            <li>
                                                Semua Pihak yang membaca dan menggunakan Ringkasan Informasi Produk dan Layanan ini agar memperhatikan syarat-syarat, ketentuan dan penggunaan yang berlaku. Apabila terdapat pertanyaan, keluhan atau informasi lanjutan, dapat
                                                menghubungi PT AXA Insurance Indonesia Customer Care Center di 1500733, email ke
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
                                            <li>PT AXA Insurance Indonesia dapat menolak permohonan produk Anda apabila tidak memenuhi persyaratan dan peraturan yang berlaku</li>
                                            <li>Anda harus membaca dengan teliti Ringkasan Informasi Produk dan Layanan ini dan berhak bertanya kepada pegawai PT AXA Insurance Indonesia atas semua hal terkait Ringkasan Informasi Produk dan Layanan ini</li>
                                        </ol>
                                    </div>
                                    <br />
                                    <p style="text-align: justify;">Saya dengan ini menyatakan bahwa Saya telah membaca, menerima penjelasan dan memahami produk Proteksi Kecelakaan Diri Plus sesuai Ringkasan Informasi Produk dan Layanan <sup style="color: red;">*</sup></p>
                                    <div class="radio-wrapper">
                                        <div class="esppk-radio-custom-wrapper">
                                            <input type="radio" name="radio-polis" value="Ya" id="radio-polis-2" required="">
                                            <label class="esppk-label esppk-radio-custom-label self-center mb-0" for="radio-polis-2">
                                                <span class="radio-cloak"></span>
                                                <span>Ya</span>
                                            </label>
                                        </div>
                                        <div class="esppk-radio-custom-wrapper">
                                            <input type="radio" name="radio-polis" value="Tidak" id="radio-polis-1" required="">
                                            <label class="esppk-label esppk-radio-custom-label self-center mb-0" for="radio-polis-1">
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

                <div class="panel py-[20px]">
                    <div class="panel__heading"><h1 class="font-bold text-[#274168]">Surat Permintaan dan Pernyataan Kesehatan</h1></div>
                    <div class="esppk-question-body">
                        <div class="item-sppk-first">
                            <p style="text-align: justify;">Apakah Anda pernah merasakan gejala apa pun, terdiagnosis, menjalani pemeriksaan, dan/atau berniat menjalani pemeriksaan gangguan jantung, paru-paru, peredaran darah, tekanan darah tinggi, stroke, diabetes, ginjal, liver, kelainan saraf, infeksi HIV atau AIDS, hepatitis B atau C, kanker, melanoma, tumor, atau pertumbuhan jaringan abnormal? <sup style="color: red;">*</sup></p>
                            <div class="radio-wrapper">
                                <div class="esppk-radio-custom-wrapper">
                                    <input type="radio" name="radio-first-sppk" value="Ya" id="radio-first-sppk-2" required="">
                                    <label class="esppk-label esppk-radio-custom-label self-center mb-0" for="radio-first-sppk-2">
                                        <span class="radio-cloak"></span>
                                        <span>Ya</span>
                                    </label>
                                </div>
                                <div class="esppk-radio-custom-wrapper">
                                    <input type="radio" name="radio-first-sppk" value="Tidak" id="radio-first-sppk-1" required="">
                                    <label class="esppk-label esppk-radio-custom-label self-center mb-0" for="radio-first-sppk-1">
                                        <span class="radio-cloak"></span>
                                        <span>Tidak</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="item-sppk-second">
                            <p style="text-align: justify;">Dalam 5 tahun terakhir, apakah Anda pernah mendapat pengobatan atau perawatan atau dioperasi atau dirawat inap di rumah sakit selama lebih dari 7 (tujuh) hari berturut-turut? <sup style="color: red;">*</sup></p>
                            <div class="radio-wrapper">
                                <div class="esppk-radio-custom-wrapper">
                                    <input type="radio" name="radio-second-sppk" value="Ya" id="radio-second-sppk-2" required="">
                                    <label class="esppk-label esppk-radio-custom-label self-center mb-0" for="radio-second-sppk-2">
                                        <span class="radio-cloak"></span>
                                        <span>Ya</span>
                                    </label>
                                </div>
                                <div class="esppk-radio-custom-wrapper">
                                    <input type="radio" name="radio-second-sppk" value="Tidak" id="radio-second-sppk-1" required="">
                                    <label class="esppk-label esppk-radio-custom-label self-center mb-0" for="radio-second-sppk-1">
                                        <span class="radio-cloak"></span>
                                        <span>Tidak</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="item-sppk-third">
                            <p style="text-align: justify;">Dalam 5 tahun terakhir, apakah Anda pernah mendapatkan tes kesehatan* yang tidak normal, atau Anda sedang menunggu hasil pemeriksaan tersebut?<br>*Tes Kesehatan misalnya tes darah, tes urine, USG, biopsy, kontrol kehamilan dll<br>(Anda tidak perlu menyatakan hasil tes positif demam berdarah, influenza atau covid yang sudah sembuh total tanpa komplikasi) <sup style="color: red;">*</sup></p>
                            <div class="radio-wrapper">
                                <div class="esppk-radio-custom-wrapper">
                                    <input type="radio" name="radio-third-sppk" value="Ya" id="radio-third-sppk-2" required="">
                                    <label class="esppk-label esppk-radio-custom-label self-center mb-0" for="radio-third-sppk-2">
                                        <span class="radio-cloak"></span>
                                        <span>Ya</span>
                                    </label>
                                </div>
                                <div class="esppk-radio-custom-wrapper">
                                    <input type="radio" name="radio-third-sppk" value="Tidak" id="radio-third-sppk-1" required="">
                                    <label class="esppk-label esppk-radio-custom-label self-center mb-0" for="radio-third-sppk-1">
                                        <span class="radio-cloak"></span>
                                        <span>Tidak</span>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel py-[20px]">
                    <div class="panel__heading"><h1 class="font-bold text-[#274168]">Persetujuan</h1></div>
                    <div class="panel__body">
                        <div class="accordion" id="accordionAgreement">
                            <div class="accordion-item">
                                <div class="accordion-header">
                                    <div class="esppk-checkbox-custom-wrapper">
                                        <input type="checkbox" name="checkbox-persetujuan-1" id="checkbox-persetujuan-1" required="">
                                        <label class="esppk-label esppk-checkbox-custom-label self-center mb-0" for="checkbox-persetujuan-1">
                                            <span class="checkbox-cloak"></span>
                                        </label>
                                    </div>
                                    <div class="esppk-accordion-button collapsed self-center" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEleven" aria-expanded="true" aria-controls="collapseEleven">
                                        <span class="btn-text">Saya sudah membaca dan menyetujui pernyataan berikut <sup style="color: red;">*</sup></span>
                                        <i class="fas fa-chevron-down text-[13px]"></i>
                                    </div>
                                </div>
                                <div id="collapseEleven" class="accordion-collapse collapse show" data-bs-parent="#accordionAgreement">
                                    <div class="esppk-accordion-body" style="text-align: justify;">
                                        <%= persetujuan %>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <% if (!submitted) { %>
                    <div class="text-center mt-[30px]">
                        <a class="cursor-pointer btn__next btn btn--green btn--disabled inline-block w-[150px]">
                            <span class="relative uppercase">
                                Setuju <i class="fas fa-check"></i>
                            </span>
                        </a>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
</div>

<script>
    $("body").addClass("body-smoke");

	var _signAgreementURL = "<%= signAgreementURL %>";
	var _successStepURL = "<%= stepSuccessBaseURL %>";
	var _failedStepURL = "<%= stepFailedBaseURL %>";
</script>

<script src="<%= request.getContextPath() %>/js/step5.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<%@ include file="/includes/footer.jsp" %>