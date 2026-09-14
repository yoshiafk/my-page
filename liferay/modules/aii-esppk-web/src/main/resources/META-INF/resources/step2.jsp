<%@ include file="/init.jsp" %>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);

	String csrfToken = Optional.ofNullable((String) renderRequest.getAttribute("CSRF_TOKEN")).orElse("");
	String csrfTokenApi = Optional.ofNullable((String) renderRequest.getAttribute("CSRF_TOKEN_API")).orElse("");

	String portalURL = themeDisplay.getPortalURL();
%>

<portlet:resourceURL id="createDebitur" var="createDebiturURL" />

<portlet:renderURL var="step4BaseURL">
	<portlet:param name="mvcPath" value="/step4.jsp"></portlet:param>
</portlet:renderURL>

<%@ include file="/includes/header.jsp" %>

<div class="dashboard">
    <div class="dashboard__debitur">
        <input type="hidden" name="csrfToken" value="<%= csrfToken %>" />
        <input type="hidden" name="csrfTokenApi" value="<%= csrfTokenApi %>" />
        <div class="container sm:max-w-full md:max-w-[1140px] lg:max-w-[1170px] min-[1300px]:max-w-[1200px] min-[1440px]:max-w-[1300px] xl:max-w-[1220px] 2xl:max-w-[1336px] p-[0px_15px] lg:mx-auto xl:p-0 xl:mx-auto">
            <div class="mb-[30px]">
                <h1>Daftar Debitur</h1>
                <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 mt-[30px] container-form">
                    <div class="input-col">
                        <label for="input-name">Nama Lengkap</label>
                        <input class="input-control input-control--outline" type="text" id="input-name" placeholder="Nama Lengkap" name="input-name" autocomplete="off">
                    </div>
                    <div class="input-col">
                        <label for="input-idNumber">NIK</label>
                        <input class="input-control input-control--outline" type="text" id="input-idNumber" placeholder="Nomor Induk Kependudukan" name="input-idNumber" maxlength="16" autocomplete="off">
                    </div>
                    <div class="input-col">
                        <label for="input-submissionNumber">Nomor Pengajuan</label>
                        <input class="input-control input-control--outline" type="text" id="input-submissionNumber" placeholder="Nomor Pengajuan" name="input-submissionNumber" autocomplete="off">
                    </div>                    
                    <div class="input-col calendar input-calendar-create-date relative">
                        <label for="input-createDate">Tanggal Pengajuan</label>
                        <input class="input-control input-control--outline input-date" type="text" id="input-createDate" placeholder="Tanggal Pengajuan" name="input-createDate" autocomplete="off">
                        <input type="hidden" name="input-createDateAlt">
                    </div>
                    <div class="input-col">
                        <label for="input-applicationNumber">Nomor Aplikasi</label>
                        <input class="input-control input-control--outline" type="text" id="input-applicationNumber" placeholder="Nomor Aplikasi" name="input-applicationNumber" autocomplete="off">
                    </div>
                    <div class="input-col flex gap-4">
                        <button class="btn btn--dark-blue w-[139px] h-[54px] self-end" id="filter-data-btn">
                            <span class="relative z-10 flex justify-center gap-2">
                                <span>Cari</span>
                                <svg class="self-center" xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 14 14" fill="none">
                                    <path d="M10.5192 10.6L13 13M12.2 6.6C12.2 9.69279 9.69279 12.2 6.6 12.2C3.50721 12.2 1 9.69279 1 6.6C1 3.50721 3.50721 1 6.6 1C9.69279 1 12.2 3.50721 12.2 6.6Z" stroke="white" stroke-width="1.33333" stroke-linecap="round"></path>
                                </svg>
                            </span>
                        </button>
                        <button class="btn btn--sienna-outline w-[139px] h-[54px] self-end" id="reset-data-btn">
                            <span class="relative z-10 flex justify-center gap-2">
                                <span>Atur Ulang</span>
                            </span>
                        </button>
                    </div>
                    <div></div>
                    <div class="input-col flex justify-start md:justify-end">
                        <a href="#ModalDebitur" data-bs-toggle="modal" data-bs-target="#ModalDebitur" class="btn btn--dark-blue self-end inline-block w-[139px] h-[50px]">
                            <span class="relative z-10 flex justify-center">
                                <span>Tambah</span>
                            </span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="debitur">
                <div class="debitur__settings">
                    <div class="debitur__settings--table">
                        <div class="table-wrapper overflow-x-hidden">
                            <table id="table-header" class="table">
                                <thead>
                                    <tr>
                                        <th>Tanggal Pengajuan</th>
                                        <th>Nomor Pengajuan</th>
                                        <th>Status</th>
                                        <th>Nama</th>
                                        <th>NIK</th>
                                        <th>No. HP</th>
                                        <th>Email</th>
                                        <th>Limit Pengajuan</th>
                                        <th>Produk Asuransi</th>
                                        <th>Nomor Aplikasi</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody class="whitespace-nowrap">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal modal-sppk w-full fade" id="ModalDebitur" tabindex="-1" style="display: none;" aria-labelledby="ModalDebiturLabel" aria-hidden="true">
    <div class="modal-max-w-676px modal-dialog modal-sppk-dialog modal-sppk-dialog-centered">
        <div class="modal-sppk-content modal-content">
            <div class="modal-sppk-header py-[18px] px-5">
                <h1>Tambah Debitur</h1>
            </div>

            <div class="multi-step-form">
                <form class="debitur-form" id="formDebitur" action="javascript:void()" autocomplete="off" novalidate="novalidate">
                    <fieldset aria-label="AddDebitur" id="add-debitur">
                        <div class="modal-sppk-body p-5 relative container-form">
                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="applicationNumber">Nomor Aplikasi</label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="applicationNumber" id="applicationNumber" placeholder="Isi nomor aplikasi" autocomplete="off">
                                </div>
                                <div class="input-col">
                                    <label for="name">Nama Lengkap<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="name" id="name" placeholder="Hanya diisi huruf sesuai KTP" autocomplete="off" required>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="birthPlace">Tempat Lahir<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="birthPlace" id="birthPlace" placeholder="Hanya diisi huruf sesuai KTP" autocomplete="off" required>
                                </div>
                                <div class="input-col calendar calendar-birth-date relative">
                                    <label for="birthDate">Tanggal Lahir<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent input-date" name="birthDate" id="birthDate" placeholder="Tanggal Lahir" autocomplete="off" required>
                                    <input type="hidden" name="birthDateAlt"/>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="idNumber">NIK<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="idNumber" id="idNumber" placeholder="Hanya diisi angka sesuai KTP" maxlength="16" autocomplete="off" required>
                                </div>
                                <div class="input-col">
                                    <label for="address">Alamat Domisili<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="address" id="address" placeholder="Isi alamat tempat tinggal" autocomplete="off" required>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="occupation">Tipe Pekerjaan<sup>*</sup></label>
                                    <div id="occupation-wrapper" class="relative">
                                        <select class="input-control" name="occupation" id="occupation" autocomplete="off" required>
                                            <option></option>
                                            <option value="PNS/BUMN">PNS/BUMN</option>
                                            <option value="TNI/POLRI">TNI/POLRI</option>
                                            <option value="SWASTA/WIRASWASTA">SWASTA/WIRASWASTA</option>
                                            <option value="PROFESIONAL">PROFESIONAL</option>
                                            <option value="LAINNYA">LAINNYA</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="input-col">
                                    <label for="email">Email<sup>*</sup></label>
                                    <input type="email" class="input-control input-control--outline bg-transparent" name="email" id="email" placeholder="Contoh: email@gmail.com" autocomplete="off" required>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="phoneNumber">No. HP<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="phoneNumber" id="phoneNumber" placeholder="Contoh: 08XXXXXXXXXX" maxlength="13" autocomplete="off" required>
                                </div>
                                <div class="input-col">
                                    <label for="gender">Jenis Kelamin<sup>*</sup></label>
                                    <div id="gender-wrapper" class="relative">
                                        <select class="input-control" name="gender" id="gender" autocomplete="off" required>
                                            <option></option>
                                            <option value="LAKI-LAKI">LAKI-LAKI</option>
                                            <option value="PEREMPUAN">PEREMPUAN</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="sumInsured">Limit Pengajuan<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="sumInsured" id="sumInsured" placeholder="contoh: 1.000.000" maxlength="13" autocomplete="off" required>
                                </div>
                                <div class="input-col">
                                    <label for="product">Produk Asuransi<sup>*</sup></label>
                                    <div id="product-wrapper" class="relative">
                                        <select class="input-control" name="product" id="product" autocomplete="off" required>
                                            <option></option>
                                            <option value="ASURANSI PROTEKSI KECELAKAAN DIRI PLUS">ASURANSI PROTEKSI KECELAKAAN DIRI PLUS</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="modal-sppk-footer flex justify-between p-[20px_30px]">
                            <a class="btn-cancel-create-debitur text-sm uppercase self-center cursor-pointer" data-bs-toggle="modal" data-bs-target="#ModalDebitur">Batalkan</a>
                            <button class="btn btn--dark-blue p-[12px_30px_10px_30px] btn-create-debitur">
                                <span class="relative z-50">
                                    Simpan
                                </span>
                            </button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal modal-sppk w-full fade" id="ModalEditDebitur" tabindex="-1" style="display: none;" aria-labelledby="ModalEditDebiturLabel" aria-hidden="true">
    <div class="modal-max-w-676px modal-dialog modal-sppk-dialog modal-sppk-dialog-centered">
        <div class="modal-sppk-content modal-content">
            <div class="modal-sppk-header py-[18px] px-5">
                <h1>Ubah Debitur</h1>
            </div>

            <div class="multi-step-form">
                <form class="edit-debitur-form" id="formEditDebitur" action="javascript:void()" autocomplete="off" novalidate="novalidate">
                    <fieldset aria-label="EditDebitur" id="edit-debitur">
                        <div class="modal-sppk-body p-5 relative container-form">
                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="applicationNumberEdit">Nomor Aplikasi</label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="applicationNumberEdit" id="applicationNumberEdit" placeholder="Isi nomor aplikasi" autocomplete="off">
                                </div>
                                <div class="input-col">
                                    <label for="nameEdit">Nama Lengkap<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="nameEdit" id="nameEdit" placeholder="Hanya diisi huruf sesuai KTP" autocomplete="off" required>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="birthPlaceEdit">Tempat Lahir<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="birthPlaceEdit" id="birthPlaceEdit" placeholder="Hanya diisi huruf sesuai KTP" autocomplete="off" required>
                                </div>
                                <div class="input-col calendar calendar-birth-date-edit relative">
                                    <label for="birthDateEdit">Tanggal Lahir<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent input-date" name="birthDateEdit" id="birthDateEdit" placeholder="Tanggal Lahir" autocomplete="off" required>
                                    <input type="hidden" name="birthDateEditAlt"/>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="idNumberEdit">NIK<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="idNumberEdit" id="idNumberEdit" placeholder="Hanya diisi angka sesuai KTP" maxlength="16" autocomplete="off" required>
                                </div>
                                <div class="input-col">
                                    <label for="addressEdit">Alamat Domisili<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="addressEdit" id="addressEdit" placeholder="Isi alamat tempat tinggal" autocomplete="off" required>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="occupationEdit">Tipe Pekerjaan<sup>*</sup></label>
                                    <div id="occupation-wrapper-edit" class="relative">
                                        <select class="input-control" name="occupationEdit" id="occupationEdit" autocomplete="off" required>
                                            <option></option>
                                            <option value="PNS/BUMN">PNS/BUMN</option>
                                            <option value="TNI/POLRI">TNI/POLRI</option>
                                            <option value="SWASTA/WIRASWASTA">SWASTA/WIRASWASTA</option>
                                            <option value="PROFESIONAL">PROFESIONAL</option>
                                            <option value="LAINNYA">LAINNYA</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="input-col">
                                    <label for="emailEdit">Email<sup>*</sup></label>
                                    <input type="email" class="input-control input-control--outline bg-transparent" name="emailEdit" id="emailEdit" placeholder="Contoh: email@gmail.com" autocomplete="off" required>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="phoneNumberEdit">No. HP<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="phoneNumberEdit" id="phoneNumberEdit" placeholder="Contoh: 08XXXXXXXXXX" maxlength="13" autocomplete="off" required>
                                </div>
                                <div class="input-col">
                                    <label for="genderEdit">Jenis Kelamin<sup>*</sup></label>
                                    <div id="gender-wrapper-edit" class="relative">
                                        <select class="input-control" name="genderEdit" id="genderEdit" autocomplete="off" required>
                                            <option></option>
                                            <option value="LAKI-LAKI">LAKI-LAKI</option>
                                            <option value="PEREMPUAN">PEREMPUAN</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="mb-[15px] grid lg:grid-cols-2 gap-3 relative">
                                <div class="input-col">
                                    <label for="sumInsuredEdit">Limit Pengajuan<sup>*</sup></label>
                                    <input type="text" class="input-control input-control--outline bg-transparent" name="sumInsuredEdit" id="sumInsuredEdit" placeholder="contoh: 1.000.000" maxlength="13" autocomplete="off" required>
                                </div>
                                <div class="input-col">
                                    <label for="productEdit">Produk Asuransi<sup>*</sup></label>
                                    <div id="product-wrapper-edit" class="relative">
                                        <select class="input-control" name="productEdit" id="productEdit" autocomplete="off" required>
                                            <option></option>
                                            <option value="ASURANSI PROTEKSI KECELAKAAN DIRI PLUS">ASURANSI PROTEKSI KECELAKAAN DIRI PLUS</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <input type="hidden" name="did"/>

                        <div class="modal-sppk-footer flex justify-between p-[20px_30px]">
                            <a class="btn-cancel-edit-debitur text-sm uppercase self-center cursor-pointer" data-bs-toggle="modal" data-bs-target="#ModalEditDebitur">Batalkan</a>
                            <button class="btn btn--dark-blue p-[12px_30px_10px_30px] btn-edit-debitur">
                                <span class="relative z-50">
                                    Simpan
                                </span>
                            </button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var ns = '<portlet:namespace />';
	var _nextStepURL = "<%= step4BaseURL %>";
	var createDebiturURL = "<%=createDebiturURL%>";
	var _apiURL = "<%= portalURL %>";
</script>

<script src="<%= request.getContextPath() %>/js/main.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/js/step2.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<%@ include file="/includes/footer.jsp" %>