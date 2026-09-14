<%@ include file="/init.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %>

<%
    String submissionNumberDebitur = Optional.ofNullable((String) renderRequest.getAttribute("submissionNumberDebitur")).orElse("");
	String fullNameDebitur = Optional.ofNullable((String) renderRequest.getAttribute("fullNameDebitur")).orElse("");
	String idNumber = Optional.ofNullable((String) renderRequest.getAttribute("idNumber")).orElse("");
	String status = Optional.ofNullable((String) renderRequest.getAttribute("status")).orElse("");

	String formattedBirthDate = Optional.ofNullable((Date) renderRequest.getAttribute("birthDate"))
    .map(date -> {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
        return sdf.format(date);
    }).orElse("");

	String esppkQ1 = Optional.ofNullable((String) renderRequest.getAttribute("esppkQ1")).orElse("");
	String esppkQ2 = Optional.ofNullable((String) renderRequest.getAttribute("esppkQ2")).orElse("");
	String esppkQ3 = Optional.ofNullable((String) renderRequest.getAttribute("esppkQ3")).orElse("");
	String agreeRiplay = Optional.ofNullable((String) renderRequest.getAttribute("agreeRiplay")).orElse("");
	String agreeStatement = Optional.ofNullable((String) renderRequest.getAttribute("agreeStatement")).orElse("");
%>

<%@ include file="/includes/header.jsp" %>

<div class="dashboard">
    <div class="dashboard__monitoring">
        <div class="container sm:max-w-full md:max-w-[1140px] lg:max-w-[1170px] min-[1300px]:max-w-[1200px] min-[1440px]:max-w-[1300px] xl:max-w-[1220px] 2xl:max-w-[1336px] p-[0px_15px] lg:mx-auto xl:p-0 xl:mx-auto">
            <div class="mb-[30px]">
                <h1>Jawaban SPPK Debitur</h1>
                <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 mt-[30px] container-form">
                    <div class="input-col">
                        <label for="input-name">Nomor Pengajuan</label>
                        <input class="input-control normal-case input-control--outline bg-transparent" type="text" id="input-submissionNumber" name="input-submissionNumber" value="<%= submissionNumberDebitur %>" readonly>
                    </div>
                    <div class="input-col">
                        <label for="input-name">Nama Lengkap</label>
                        <input class="input-control normal-case input-control--outline bg-transparent" type="text" id="input-name" name="input-name" value="<%= fullNameDebitur %>" readonly>
                    </div>
                    <% if (accessMonitoring) { %>
                        <div class="input-col">
                            <label for="input-idNumber">NIK</label>
                            <input class="input-control normal-case input-control--outline bg-transparent" type="text" id="input-idNumber" name="input-idNumber" value="<%= idNumber %>" readonly>
                        </div>
                        <div class="input-col calendar input-calendar-birth-date relative">
                            <label for="input-birthDate">Tanggal Lahir</label>
                            <input class="input-control normal-case input-control--outline input-date bg-transparent" type="text" id="input-birthDate" name="input-birthDate" value="<%= formattedBirthDate %>" readonly>
                        </div>
                    <% } %>
                    <div class="input-col">
                        <label for="input-status">Status</label>
                        <input class="input-control normal-case input-control--outline bg-transparent" type="text" id="input-status" name="input-status" value="<%= status %>" readonly>
                    </div>
                </div>
            </div>
            <div class="monitoring">
                <div class="monitoring__settings">
                    <div class="monitoring__settings--table mb-[30px]">
                        <div class="table-wrapper">
                            <table id="table-header" class="table">
                                <thead class="text-center">
                                    <tr>
                                        <td>Pertanyaan</td>
                                        <td>Jawaban</td>
                                    </tr>
                                </thead>
                                <tbody class="whitespace-normal">
                                    <tr>
                                        <td>Apakah Anda pernah merasakan gejala apa pun, terdiagnosis, menjalani pemeriksaan, dan/atau berniat menjalani pemeriksaan gangguan jantung, paru-paru, peredaran darah, tekanan darah tinggi, stroke, diabetes, ginjal, liver, kelainan saraf, infeksi HIV atau AIDS, hepatitis B atau C, kanker, melanoma, tumor, atau pertumbuhan jaringan abnormal?</td>
                                        <td><%= esppkQ1 %></td>
                                    </tr>
                                    <tr>
                                        <td>Dalam 5 tahun terakhir, apakah Anda pernah mendapat pengobatan atau perawatan atau dioperasi atau dirawat inap di rumah sakit selama lebih dari 7 (tujuh) hari berturut-turut?</td>
                                        <td><%= esppkQ2 %></td>
                                    </tr>
                                    <tr>
                                        <td>Dalam 5 tahun terakhir, apakah Anda pernah mendapatkan tes kesehatan* yang tidak normal, atau Anda sedang menunggu hasil pemeriksaan tersebut?<br>*Tes Kesehatan misalnya tes darah, tes urine, USG, biopsy, kontrol kehamilan dll<br>(Anda tidak perlu menyatakan hasil tes positif demam berdarah, influenza atau covid yang sudah sembuh total tanpa komplikasi)</td>
                                        <td><%= esppkQ3 %></td>
                                    </tr>
                                    <tr>
                                        <td>Setuju RIPLAY Umum</td>
                                        <td><%= agreeRiplay %></td>
                                    </tr>
                                    <tr>
                                        <td>Setuju syarat dan ketentuan</td>
                                        <td><%= agreeStatement %></td>
                                    </tr>
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
    $("body").addClass("text-base");

	$(function () {
	    $('.nav-link').click(function(e) {
            e.preventDefault();
            window.location.href = this.href;
        });

        $('.nav-link--logout').click(function(e) {
            e.preventDefault();

            let newSignOutURL = new URL(_signoutURL);
            newSignOutURL.searchParams.delete(ns + "mvcPath");
            newSignOutURL.searchParams.delete(ns + "t");

            $.ajax({
                url: newSignOutURL,
                type: "POST",
                dataType: "json",
                success: function (response) {
                    if (response.Status) {
                        setTimeout(() => window.location.href = "/aii-sppk/login", 1000);
                    }
                }
            });
        });
	})
</script>

<%@ include file="/includes/footer.jsp" %>