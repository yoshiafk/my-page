<%@ include file="/init.jsp" %>

<%
	LocalDateTime timestampForJSURI = LocalDateTime.now();
	DateTimeFormatter formatterForJSURI = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String numericTimestamptimestampForJSURI = timestampForJSURI.format(formatterForJSURI);

	String csrfTokenApi = Optional.ofNullable((String) renderRequest.getAttribute("CSRF_TOKEN_API")).orElse("");

	String portalURL = themeDisplay.getPortalURL();
%>

<portlet:renderURL var="step4BaseURL">
	<portlet:param name="mvcPath" value="/step4.jsp"></portlet:param>
</portlet:renderURL>

<%@ include file="/includes/header.jsp" %>

<div class="dashboard">
    <div class="dashboard__monitoring">
        <input type="hidden" name="csrfTokenApi" value="<%= csrfTokenApi %>" />
        <div class="container sm:max-w-full md:max-w-[1140px] lg:max-w-[1170px] min-[1300px]:max-w-[1200px] min-[1440px]:max-w-[1300px] xl:max-w-[1220px] 2xl:max-w-[1336px] p-[0px_15px] lg:mx-auto xl:p-0 xl:mx-auto">
            <div class="mb-[30px]">
                <h1>Daftar Pengajuan SPPK</h1>
                <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 mt-[30px] container-form">
                    <div class="input-col">
                        <label for="input-name">Nama Lengkap</label>
                        <input class="input-control input-control--outline" type="text" id="input-name" placeholder="Nama Lengkap" name="input-name" autocomplete="off">
                    </div>
                    <div class="input-col">
                        <label for="input-idNumber">NIK</label>
                        <input class="input-control input-control--outline" type="text" id="input-idNumber" placeholder="Nomor Induk Kependudukan" name="input-idNumber" maxlength="16" autocomplete="off">
                    </div>
                    <div class="input-col calendar input-calendar-birth-date relative">
                        <label for="input-birthDate">Tanggal Lahir</label>
                        <input class="input-control input-control--outline input-date" type="text" id="input-birthDate" placeholder="Tanggal Lahir" name="input-birthDate" autocomplete="off">
                        <input type="hidden" name="input-birthDateAlt">
                    </div>
                    <div class="input-col">
                        <label for="input-status">Status</label>
                        <select class="input-control input-control--outline" name="input-status" id="input-status" autocomplete="off">
                            <option></option>
                            <option value="Eligible">Eligible</option>
                            <option value="Not Eligible">Not Eligible</option>
                        </select>
                    </div>
                    <div class="input-col">
                        <label for="input-submissionNumber">Nomor Pengajuan</label>
                        <input class="input-control input-control--outline" type="text" id="input-submissionNumber" placeholder="Nomor Pengajuan" name="input-submissionNumber" autocomplete="off">
                    </div>
                    <div class="input-col calendar input-calendar-submit-date relative">
                        <label for="input-submitEsppkDate">Tanggal Pengajuan</label>
                        <input class="input-control input-control--outline input-date" type="text" id="input-submitEsppkDate" placeholder="Tanggal Pengajuan" name="input-submitEsppkDate" autocomplete="off">
                        <input type="hidden" name="input-submitEsppkDateAlt">
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
                </div>
            </div>
            <div class="monitoring">
                <div class="monitoring__settings">
                    <div class="monitoring__settings--table">
                        <div class="table-wrapper overflow-x-hidden">
                            <table id="table-header" class="table">
                                <thead>
                                    <tr>
                                        <th>Tanggal Pengajuan</th>
                                        <th>Nomor Pengajuan</th>
                                        <th>Status</th>
                                        <th>Nama</th>
                                        <th>NIK</th>
                                        <th>Jenis Kelamin</th>
                                        <th>Tanggal Lahir</th>
                                        <th>No. HP</th>
                                        <th>Email</th>
                                        <th>Alamat Domisili</th>
                                        <th>Limit Pengajuan</th>
                                        <th>Tipe Pekerjaan</th>
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

<script type="text/javascript">
    var ns = '<portlet:namespace />';
	var _nextStepURL = "<%= step4BaseURL %>";
	var _apiURL = "<%= portalURL %>";
</script>

<script src="<%= request.getContextPath() %>/js/main.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/js/step3.js?v=<%= numericTimestamptimestampForJSURI %>" type="text/javascript"></script>

<%@ include file="/includes/footer.jsp" %>