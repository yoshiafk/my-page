<%@ include file="/init.jsp" %>

<%
	int pageNum = 3;
%>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);
%>

<%
	String _step = "two";
	List<SmartActiveLink> files = (List<SmartActiveLink>) renderRequest.getAttribute("files");
	List<SmartActiveOccupation> occupations = (List<SmartActiveOccupation>) renderRequest.getAttribute("occupations");
	List<JSONObject> countries = (List<JSONObject>) renderRequest.getAttribute("countries");
	JSONArray provinces = (JSONArray) renderRequest.getAttribute("provinces");
	boolean isScanOcr = (Boolean) request.getAttribute("isScanOcr");
	String aParam = (String) renderRequest.getAttribute("a");
	String rcParam = (String) renderRequest.getAttribute("rc");
	String bParam = (String) renderRequest.getAttribute("b");
	String quoteCategory = Validator.isNotNull((String) renderRequest.getAttribute("qe")) ? (String) renderRequest.getAttribute("qe") : "";
	String businessModel = (String) renderRequest.getAttribute("businessModel");
	String promoCode = Validator.isNotNull((String) renderRequest.getAttribute("pc")) ? (String) renderRequest.getAttribute("pc") : "";
	String prettyUrl = Validator.isNotNull((String) renderRequest.getAttribute("pu")) ? (String) renderRequest.getAttribute("pu") : "";
	String agentCode = Validator.isNotNull((String) renderRequest.getAttribute("agentCode")) ? (String) renderRequest.getAttribute("agentCode") : "";
	String agentName = Validator.isNotNull((String) renderRequest.getAttribute("agentName")) ? (String) renderRequest.getAttribute("agentName") : "";
	String mobile = Validator.isNotNull((String) renderRequest.getAttribute("mobile")) ? (String) renderRequest.getAttribute("mobile") : "";
	String lParam = Validator.isNotNull((String) renderRequest.getAttribute("l")) ? (String) renderRequest.getAttribute("l") : "";
	String leadsTemp = Validator.isNotNull((String) renderRequest.getAttribute("qt")) ? (String) renderRequest.getAttribute("qt") : "";
	String csrfToken = Validator.isNotNull((String) renderRequest.getAttribute("CSRF_TOKEN")) ? (String) renderRequest.getAttribute("CSRF_TOKEN") : "";
	
	String portalURL = themeDisplay.getPortalURL();
%>

<portlet:renderURL var="step4BaseURL">
	<portlet:param name="mvcPath" value="/step4.jsp"></portlet:param>
</portlet:renderURL>

<% 
    String step4URL = step4BaseURL;
    if (Validator.isNotNull(aParam)) step4URL = step4URL + "&a=" + aParam;
    if (Validator.isNotNull(rcParam)) step4URL = step4URL + "&rc=" + rcParam;
    if (Validator.isNotNull(bParam)) step4URL = step4URL + "&b=" + bParam;
    if (Validator.isNotNull(promoCode)) step4URL = step4URL + "&pc=" + promoCode;
    if (Validator.isNotNull(prettyUrl)) step4URL = step4URL + "&pu=" + prettyUrl;
    if (Validator.isNotNull(lParam)) step4URL = step4URL + "&l=" + lParam;
    if (Validator.isNotNull(leadsTemp)) step4URL = step4URL + "&qt=" + leadsTemp;
    if (Validator.isNotNull(mobile)) step4URL = step4URL + "&mobile=" + mobile;
%>

<portlet:renderURL var="step2BaseURL">
	<portlet:param name="mvcPath" value="/step2.jsp"></portlet:param>
</portlet:renderURL>

<% 
    String step2URL = step2BaseURL;
    if (Validator.isNotNull(aParam)) step2URL = step2URL + "&a=" + aParam;
    if (Validator.isNotNull(rcParam)) step2URL = step2URL + "&rc=" + rcParam;
    if (Validator.isNotNull(bParam)) step2URL = step2URL + "&b=" + bParam;
    if (Validator.isNotNull(promoCode)) step2URL = step2URL + "&pc=" + promoCode;
    if (Validator.isNotNull(prettyUrl)) step2URL = step2URL + "&pu=" + prettyUrl;
    if (Validator.isNotNull(lParam)) step2URL = step2URL + "&l=" + lParam;
    if (Validator.isNotNull(leadsTemp)) step2URL = step2URL + "&qt=" + leadsTemp;
    if (Validator.isNotNull(quoteCategory)) step2URL = step2URL + "&qe=" + quoteCategory;
    if (Validator.isNotNull(mobile)) step2URL = step2URL + "&mobile=" + mobile;
%>

<portlet:resourceURL id="uploadimage" var="uploadImageURL" />
<portlet:resourceURL id="getcities" var="getCitiesURL" />
<portlet:resourceURL id="getleads" var="getLeadsURL" />
<portlet:resourceURL id="settransaction" var="setTransactionURL" />

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/navbar.jsp" %>
<% } %>

<header class="hero<% if (Validator.isNotNull(mobile)) { %> hero-mobile<% } %>">
	<img src="/o/mypage-theme/images/banner_step_sa.png" alt="Axa SmartActive" class="width-full height-full">
</header>

<section class="step-two" id="Step-2">
	<input type="hidden" name="csrfToken" value="<%= csrfToken %>" />
	<%@ include file="/includes/stepbar.jsp" %>

	<div class="sa-insured-data">
		<div class="container-axa">
			<div class="insured-data-grid">
				<div class="sa-insured-data__left">
					<div class="panel container-form">
						<div class="panel__heading"><h1>Data Tertanggung</h1></div>
						<div class="panel__body">
							<div class="policy-smartactive">
								<p>
									Apakah pemegang polis termasuk ke dalam kategori Orang yang <span>Populer Secara Politis/ Politically Exposed Persons (PEP) ?</span>
									<a class="position-relative" href="javascript:void(0)" onclick="openModal()">Baca selengkapnya <i class="far fa-arrow-right"></i></a>
								</p>
								<div class="radio-wrapper">
									<div class="sa-radio-custom-wrapper">
										<input type="radio" name="radio-pep" id="radio-pep-1" value="N" required>
										<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-pep-1">
											<span class="radio-cloak"></span>
											<span>Tidak</span>
										</label>
									</div>
									
									<div class="sa-radio-custom-wrapper">
										<input type="radio" name="radio-pep" id="radio-pep-2" value="Y" required>
										<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-pep-2">
											<span class="radio-cloak"></span>
											<span>Iya</span>
											<small>(Data Anda akan kami tinjau untuk melewati persetujuan dari Underwriting)</small>
										</label>
									</div>
								</div>
							</div>
							
							<div class="sa-id-card-identity">
								<div id="citizenship-wrapper">
									<label for="citizenship" class="sa-label">Kewarganegaraan<sup>*</sup></label>
									<select name="citizenship" id="citizenship" required>
										<option></option>
										<% if (countries.size() > 0) { %>
											<% for (JSONObject data : countries) { %>
												<option value="<%= data.getString("id") %>"><%= data.getString("name") %></option>
											<% } %>
										<% } %>
									</select>
								</div>
							</div>

							<div class="sa-upload-photo-ktp">
								<div id="upload-photo-ktp-wrapper">
									<label for="upload" class="sa-label">Upload Foto KTP/KITAS<% if (businessModel.equalsIgnoreCase("b2b") == false) {%><sup>*</sup><% } %></label>
									<div class="thumbnail-wrapper">
										<div>
											<img class="sa-thumbnail width-full" src="/o/mypage-theme/images/img-unselect.jpg" alt="AXA SmartActive">
											<span class="file-name"></span>
										</div>
										<div>
											<input type="file" name="upload" id="upload" class="fileInput" accept="image/*" <% if (businessModel.equalsIgnoreCase("b2b") == false) {%>required<% } %>>
											<button type="button" class="uploadButton">
												<span>Pilih File</span>
											</button>
										</div>
									</div>
									<input type="hidden" name="imgUrl"/>
								</div>
							</div>

							<div class="sa-id-card-identity">
								<div id="id-card-identity-name-wrapper">
									<label for="id-card-identity-name" class="sa-label">Nama lengkap sesuai KTP / KITAS<sup>*</sup></label>
									<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-name" id="id-card-identity-name" placeholder="Tulis Nama" type="text" required autocomplete="off">
								</div>
								<div id="id-card-identity-number-wrapper">
									<label for="id-card-identity-number" class="sa-label">Nomor KTP / KITAS<sup>*</sup></label>
									<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-number" id="id-card-identity-number" placeholder="Tulis Nomor KTP / Paspor" type="text" maxlength="16" required autocomplete="off">
								</div>
							</div>
							
							<div class="sa-id-card-identity-date-of-birth">
								<div id="id-card-identity-date-of-birth-wrapper">
									<div class="col-calendar position-relative" id="birth-date-wrapper">
										<label for="birth-date" class="sa-label">Tanggal Lahir<sup>*</sup></label>
										<div class="sa-input-group-axa input-group-axa--border">
											<input class="input-control-axa input-control-axa--outline sa-fv-outline-none blocked-input-date" id="birth-date" name="birth-date" type="text" placeholder="Pilih Tanggal Lahir" required autocomplete="off">
											<span class="align-self-center">
												<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
													<path d="M6.51479 7.61676H17.9434M5.99961 1.38347V3.41698M5.99961 3.41698L17.9996 3.41676M5.99961 3.41698C4.01132 3.41698 2.39969 5.02864 2.39978 7.01693L2.40034 19.0168C2.40043 21.005 4.01218 22.6167 6.00034 22.6167H18.0003C19.9886 22.6167 21.6004 21.0048 21.6003 19.0165L21.5998 7.01659C21.5997 5.02843 19.9878 3.41676 17.9996 3.41676M17.9996 1.38336V3.41676M9.6005 18.4167V11.2167L7.2005 13.0167M16.2005 18.4167V11.2167L13.8005 13.0167" stroke="#00008F" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
												</svg>
											</span>
										</div>
										<small>DD/MMM/YYYY</small>
									</div>
								</div>
								<div id="age-wrapper">
									<label for="age" class="sa-label">Usia</label>
									<div class="sa-input-group-axa input-group-axa--border sa-disabled">
										<input class="input-control-axa input-control-axa--outline" id="age" name="age" type="text" value="0" disabled autocomplete="off">
										<span class="align-self-center">Tahun</span>
									</div>
									<small class="text-reminder text-message"></small>
								</div>
								<div id="id-card-identity-place-of-birth-wrapper">
									<label for="birth-place" class="sa-label">Tempat Lahir<sup>*</sup></label>
									<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="birth-place" id="birth-place" placeholder="Tulis Tempat Lahir" type="text" required autocomplete="off">
								</div>
							</div>

							<div class="sa-id-card-identity-gender">
								<label for="gender" class="sa-label">Jenis Kelamin<sup>*</sup></label>
								<div id="id-card-identity-gender-wrapper">
									<div class="radio-icon">
										<div class="radio-icon-input">
											<input type="radio" name="gender" value="M" required>
											<div class="box-radio-wrapper agency__text-center">
												<div class="box-radio">
													<img src="/o/mypage-theme/images/man-nb.png" alt="laki-laki">
												</div>
												<div class="box-text">Laki-Laki</div>
											</div>
										</div>
									</div>
									<div class="radio-icon">
										<div class="radio-icon-input">
											<input type="radio" name="gender" value="F" required>
											<div class="box-radio-wrapper agency__text-center">
												<div class="box-radio">
													<img src="/o/mypage-theme/images/woman-nb.png" alt="perempuan">
												</div>
												<div class="box-text">Perempuan</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="sa-id-card-identity">
								<div id="id-card-identity-no-hp-wrapper">
									<label for="id-card-identity-no-hp" class="sa-label">Nomor Handphone<sup>*</sup></label>
									<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-no-hp" id="id-card-identity-no-hp" placeholder="Tulis Nomor Telepon" type="text" maxlength="15" required autocomplete="off">
								</div>
								<div id="id-card-identity-email-wrapper">
									<label for="id-card-identity-email" class="sa-label">Email<sup>*</sup></label>
									<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-email" id="id-card-identity-email" placeholder="Tulis Email" type="email" required autocomplete="off">
								</div>
							</div>
						</div>
					</div>

					<div class="panel container-form">
						<div class="panel__heading"><h1>Alamat Domisili Sekarang</h1></div>
						<div class="panel__body">
							<div class="sa-id-card-identity">
								<div id="id-card-identity-postal-code-wrapper">
									<label for="id-card-identity-postal-code" class="sa-label">Kode Pos<sup>*</sup></label>
									<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="id-card-identity-postal-code" id="id-card-identity-postal-code" placeholder="Tulis Kode Pos" type="text" maxlength="5" required autocomplete="off">
								</div>
								<div id="province-wrapper">
									<label for="province" class="sa-label">Provinsi<sup>*</sup></label>
									<select name="province" id="province" required>
										<option></option>
										<% if (provinces.length() > 0) { %>
											<% for (int i = 0; i < provinces.length(); i++) { %>
												<% JSONObject data = JSONFactoryUtil.createJSONObject(provinces.get(i).toString()); %>
												<option value="<%= data.getString("id") %>"><%= data.getString("name") %></option>
											<% } %>
										<% } %>
									</select>
								</div>
								<div id="regency-wrapper">
									<label for="regency" class="sa-label">Kabupaten/Kota<sup>*</sup></label>
									<select name="regency" id="regency" required>
										<option></option>
									</select>
								</div>
							</div>
							<div class="sa-id-card-identity-address">
								<label for="address" class="sa-label">Alamat Lengkap</label>
								<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="address" id="address" placeholder="Tulis Alamat Lengkap" type="text" required autocomplete="off">
							</div>
						</div>
					</div>

					<div class="panel container-form">
						<div class="panel__body">
							<div class="sa-employment-desc">
								<div id="employment-wrapper">
									<label for="employment" class="sa-label">Pekerjaan Tertanggung<sup>*</sup></label>
									<select name="employment" id="employment" required>
										<option></option>
										<% if (occupations.size() > 0) { %>
											<% for (SmartActiveOccupation itemOccupation : occupations) { %>
												<option value="<%= itemOccupation.getSmartActiveOccupationId() %>"><%= itemOccupation.getNameId() %></option>
											<% } %>
										<% } %>
									</select>
								</div>
								<div id="locations-and-activities-wrapper">
									<label for="locations-and-activities" class="sa-label">Lokasi dan Aktivitas Sehari Hari<sup>*</sup></label>
									<select name="locations-and-activities" id="locations-and-activities" required>
										<option></option>
										<option value="Rumah">Rumah</option>
										<option value="Perkantoran">Perkantoran</option>
										<option value="Pertokoan">Pertokoan</option>
										<option value="Pertambangan">Pertambangan</option>
										<option value="Pergudangan">Pergudangan</option>
										<option value="Laut">Laut</option>
										<option value="Perkebunan">Perkebunan</option>
										<option value="Lainnya">Lainnya</option>
									</select>
									<div id="additional-locations-wrapper" class="display-hidden mt-3level">
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="additional-locations" id="additional-locations" placeholder="Tulis Lokasi" type="text" autocomplete="off">
									</div>
								</div>

								<div id="income-per-month-wrapper">
									<label for="income-per-month" class="sa-label">Penghasilan Per Bulan<sup>*</sup></label>
									<div class="radio-wrapper">
										<div class="sa-radio-custom-wrapper">
											<input type="radio" name="radio-income" id="radio-income-1" value="< Rp. 10 jt" required>
											<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-1">
												<span class="radio-cloak"></span>
												<span>< Rp. 10 jt</span>
											</label>
										</div>
										
										<div class="sa-radio-custom-wrapper">
											<input type="radio" name="radio-income" id="radio-income-2" value="> Rp. 10 jt - Rp. 25 jt" required>
											<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-2">
												<span class="radio-cloak"></span>
												<span>> Rp. 10 jt - Rp. 25 jt</span>
											</label>
										</div>
										<div class="sa-radio-custom-wrapper">
											<input type="radio" name="radio-income" id="radio-income-3" value="> Rp. 25 jt - Rp. 50 jt" required>
											<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-3">
												<span class="radio-cloak"></span>
												<span>> Rp. 25 jt - Rp. 50 jt</span>
											</label>
										</div>
										<div class="sa-radio-custom-wrapper">
											<input type="radio" name="radio-income" id="radio-income-4" value="> Rp. 50 jt - Rp. 100 jt" required>
											<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-4">
												<span class="radio-cloak"></span>
												<span>> Rp. 50 jt - Rp. 100 jt</span>
											</label>
										</div>
										<div class="sa-radio-custom-wrapper">
											<input type="radio" name="radio-income" id="radio-income-5" value="> Rp. 100 jt - Rp. 200 jt" required>
											<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-5">
												<span class="radio-cloak"></span>
												<span>> Rp. 100 jt - Rp. 200 jt</span>
											</label>
										</div>
										<div class="sa-radio-custom-wrapper">
											<input type="radio" name="radio-income" id="radio-income-6" value="Rp. 200 jt" required>
											<label class="sa-label sa-radio-custom-label align-self-center mb-0px" for="radio-income-6">
												<span class="radio-cloak"></span>
												<span>Rp. 200 jt</span>
											</label>
										</div>
									</div>
								</div>

								<div id="source-of-premium-payments-wrapper">
									<label for="source-of-premium-payments" class="sa-label">Sumber Pembayaran Premi<sup>*</sup></label>
									<select name="source-of-premium-payments" id="source-of-premium-payments" required>
										<option></option>
										<option value="Gaji Bulanan">Gaji Bulanan</option>
										<option value="Hasil Usaha">Hasil Usaha</option>
										<option value="Komisi">Komisi</option>
										<option value="Lainnya">Lainnya</option>
									</select>
									<div id="additional-payments-wrapper" class="display-hidden mt-3level">
										<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="additional-payments" id="additional-payments" placeholder="Tulis Sumber Pembayaran" type="text" autocomplete="off" autocomplete="off">
									</div>
								</div>
								
								<div id="beneficiary-wrapper">
									<label for="beneficiary" class="sa-label">Ahli Waris</label>
									<input class="input-control-axa input-control-axa--wrap input-control-axa--outline sa-fv-outline-none" name="beneficiary" id="beneficiary" placeholder="Tulis Nama Ahli Waris" type="text" autocomplete="off">
								</div>
								
								<div id="beneficiary-relationship-wrapper">
									<label for="beneficiary-relationship" class="sa-label">Hubungan dengan Ahli Waris</label>
									<select name="beneficiary-relationship" id="beneficiary-relationship">
										<option></option>
										<option value="Orang Tua">Orang Tua</option>
										<option value="Pasangan">Pasangan</option>
										<option value="Anak">Anak</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="sa-insured-data__right">
					<%@ include file="/includes/panel_summary.jsp" %>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="/includes/sticky.jsp" %>

<div id="modal_baca" class="modal_baca agency__hidden">
	<div class="modal_baca-content">
	    <!-- Tombol Tutup -->
	    <button onclick="closeModal()" class="modal_baca-close-button">&times;</button>
	
	    <!-- Bagian Title -->
	    <div class="modal_baca-title">
	        <h2>Politically Exposed Person (PEP)</h2>
	    </div>
	
	    <!-- Garis Pemisah -->
	    <hr class="modal_baca-divider">
	
	    <!-- Bagian Content -->
        <div class="modal_baca-body">
            <p>Politically Exposed Person (PEP) berdasarkan POJK No 12 Tahun 2017 tentang Penerapan Program Anti
                Pencucian Uang dan Pencegahan Pendanaan Terorisme Sektor Jasa Keuangan.</p>

            <p>Orang yang Populer Secara Politis (Politically Exposed Person) yang selanjutnya disingkat PEP
                meliputi:</p>

            <ul class="modal_baca-list">
                <li class="modal_baca-list-item"><strong>PEP Asing</strong> yaitu orang yang diberi kewenangan untuk
                    melakukan fungsi penting
                    (prominent function) oleh negara lain (asing), seperti kepala negara atau pemerintahan, politisi
                    senior, pejabat pemerintah senior, pejabat militer atau pejabat di bidang penegakan hukum,
                    eksekutif senior pada perusahaan yang dimiliki oleh negara, pejabat penting dalam partai
                    politik.</li>

                <li class="modal_baca-list-item"><strong>PEP Domestik</strong> yaitu orang yang diberi kewenangan
                    untuk melakukan fungsi penting
                    (prominent function) oleh negara, seperti kepala negara atau pemerintahan, politisi senior,
                    pejabat pemerintah senior, pejabat militer atau pejabat di bidang penegakan hukum, eksekutif
                    senior pada perusahaan yang dimiliki oleh negara, pejabat penting dalam partai politik.</li>

                <li class="modal_baca-list-item"><strong>PEP Internasional</strong>, yaitu orang yang diberi
                    kewenangan untuk melakukan fungsi
                    penting (prominent function) oleh organisasi internasional, seperti senior manajer yang meliputi
                    antara lain direktur, deputi direktur, dan anggota dewan atau fungsi yang setara.</li>

                <li class="modal_baca-list-item"><strong>Anggota keluarga dan/atau afiliasi (close
                        associates)</strong> dari PEP.</li>
            </ul>

            <br />

            <p><strong>Ketentuan khusus tentang anggota keluarga dan/atau afiliasi (close associates) dari
                    PEP:</strong></p>

            <p>Anggota keluarga dari PEP adalah anggota keluarga PEP sampai dengan derajat kedua, baik horisontal
                maupun vertikal, yaitu:</p>

            <ul class="modal_baca-list">
                <li class="modal_baca-list-item">Orang tua kandung/tiri/angkat;</li>
                <li class="modal_baca-list-item">Saudara kandung/tiri/angkat;</li>
                <li class="modal_baca-list-item">Anak kandung/tiri/angkat;</li>
                <li class="modal_baca-list-item">Kakek atau Nenek kandung/tiri/angkat;</li>
                <li class="modal_baca-list-item">Cucu kandung/tiri/angkat;</li>
                <li class="modal_baca-list-item">Saudara kandung/tiri/angkat dari Orang tua;</li>
                <li class="modal_baca-list-item">Suami atau Istri;</li>
                <li class="modal_baca-list-item">Mertua atau Besan;</li>
                <li class="modal_baca-list-item">Suami atau Istri dari Anak kandung/tiri/angkat;</li>
                <li class="modal_baca-list-item">Kakek atau Nenek dari Suami atau Istri;</li>
                <li class="modal_baca-list-item">Suami atau Istri dari Cucu kandung/tiri/angkat;</li>
                <li class="modal_baca-list-item">Saudara kandung/tiri/angkat dari Suami atau Istri;</li>
                <li class="modal_baca-list-item">Beserta Suami atau Istrinya dari Saudara yang bersangkutan.</li>
            </ul>

            <br />

            <p><strong>Pihak yang terkait dengan PEP antara lain:</strong></p>

            <ul class="modal_baca-list">
                <li class="modal_baca-list-item">Perusahaan yang dimiliki atau dikelola oleh PEP; atau</li>
                <li class="modal_baca-list-item">Pihak-pihak yang secara umum dan diketahui publik mempunyai
                    hubungan dekat dengan PEP. Contoh
                    supir, asisten pribadi, sekretaris pribadi.</li>
            </ul>
        </div>
    </div>
</div>

<%@ include file="/includes/modal.jsp" %>

<script type="text/javascript">
	var _prevStepURL = "<%= step2URL %>";
	var _nextStepURL = "<%= step4URL %>";
	var _step = "<%= _step %>";
	var _apiURL = "<%= portalURL %>";
	var _uploadImageURL = "<%= uploadImageURL %>";
	var _getCitiesURL = "<%= getCitiesURL %>";
	var _getLeadsURL = "<%= getLeadsURL %>";
	var _setTransactionURL = "<%= setTransactionURL %>";
	var _quoteCategory = "<%= quoteCategory %>";
	var mobile = <% if (mobile.isEmpty()) { %>""<% } else { %><%= mobile %><% } %>;
	var isScanOcr = "<%= isScanOcr %>";
</script>
<script src="<%= request.getContextPath() %>/js/main.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/js/step3.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<% if (Validator.isNull(mobile)) { %>
	<%@ include file="/includes/footer.jsp" %>
<% } %>