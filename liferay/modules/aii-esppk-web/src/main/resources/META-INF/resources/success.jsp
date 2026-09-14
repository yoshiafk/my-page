<%@ include file="/init.jsp" %>

<%@ include file="/includes/header.jsp" %>

<div class="dashboard flex items-center justify-center">
    <div class="dashboard__success">
        <div class="container sm:max-w-full md:max-w-[1140px] lg:max-w-[1170px] min-[1300px]:max-w-[1200px] min-[1440px]:max-w-[1300px] xl:max-w-[1220px] 2xl:max-w-[1336px] p-[0px_15px] lg:mx-auto xl:p-0 xl:mx-auto self-center">
           <div class="dashboard__success--inner text-center">
               <h1 class="text-[25px] lg:text-[35px] p-bottom text-axa-green-500">&#x1F389; Selamat, pengajuan Anda berhasil tersimpan</h1>
           </div>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>

<script>
    $("body").addClass("body-smoke text-base");
    $(".portlet-body").addClass("h-screen flex flex-col");
    $(".dashboard").addClass("flex-grow");
</script>