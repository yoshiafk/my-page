<%@page import="com.mypage.agencyportal.dto.DataLeadsStatusDto"%>
<%@page import="com.mypage.agencyportal.dto.DataItemProductDto"%>
<%@page import="com.mypage.agencyportal.dto.APIResponse"%>
<%@ include file="../../init.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%
    APIResponse<DataItemProductDto> _products = (APIResponse<DataItemProductDto>) renderRequest.getAttribute("products");    
	
    ActionHelpers helpers = new ActionHelpers();
    String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
    
    String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
    String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
    
%>

<portlet:resourceURL id="/data/dashboard/portofolio/transaction/all" var="loadAgentDashboardPortofolioTransactionAllData" />

<div class="breadcrumbs container-breadcrumbs-axa">
	<nav class="width-full">
		<ol class="list-reset display-inline-flex">
			<li class="text-13px agency-self-center"><a href="#">Beranda</a>
			</li>
			<li class="agency-self-center"><span class="text-13px">/</span>
			</li>
			<li class="text-13px agency-uppercase agency-self-center">Portofolio Transaksi Keseluruhan</li>
		</ol>
	</nav>
</div>

<div class="dashboard">
	<div class="dashboard__portofolio">
		<div class="container-axa">
			<div class="col-portofolio">
				<div class="col">
					<h1>Daftar Transaksi Keseluruhan</h1>
					<p class="col-text">
						<span>Rentang Waktu</span> <span class="mx-3level">:</span> <span id="rentang-waktu"><!-- 30 OKT 2023 - 6 Nov 2023 --></span>
					</p>
				</div>
				<div class="col agency-self-center">
					<div class="col-text">
						<div class="agency-self-start">
								<p>
									<span>Data yang ditampilkan</span>
									<span class="mx-2level">:</span>
									<span id="total-data"></span>
								</p>
								<p class="text-13px">
									<span id="warningMessage" class="agency-text-sienna-400 display-none">Unduh data maksimal 3 bulan terakhir</span>
								</p>
							</div>
							
							<!-- <div>
								<a id="downloadLink" href="javascript:void(0)"
								    class="btn__agency btn--dark-blue display-inline-block agency-text-center p-12px-25px-10px-25px">
								    <span class="position-relative order-10">Unduh</span>
								    <svg class="position-relative order-10 display-inline-block vertical-align-min-2px"
								        xmlns="http://www.w3.org/2000/svg" width="17" height="16" viewBox="0 0 17 16" fill="none">
								        <path
								            d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394"
								            stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
								    </svg>
								</a>
							</div> -->
							
							
					</div>
				</div>
			</div>
			<div class="filter-wrapper mb-30px">
				<!-- <form action=""> -->
					<div class="filter-grid" aria-expanded="false">
						<div class="filter__left">
						
							<div class="filter">
									<div class="input-col position-relative" id="calendar-wrapper-policy-purchase-date">
										<div class="display-grid grid-cols-repeat-2 position-relative">
											<div class="calendar calendar-col">
												<label class="label__agency" for="policy_purchase_date">Tanggal Pembelian Polis</label>
												<!-- <input
													class="input-control agency-normalcase input-control--outline"
													type="text" id="Frompdateall" placeholder="Dari"> -->
												<input class="input-control agency-self-center agency-uppercase input-control--outline" type="text" id="Frompdateall" name="from" placeholder="Dari">
											</div>
											<div class="separated-arrow">
												<i class="fas fa-arrow-right agency-self-center text-12px"></i>
											</div>
											<div class="calendar-col">
												<label class="label__agency" for="policy_purchase_date">&nbsp;</label>
												
												<!-- <input
													class="input-control input-date agency-normalcase input-control--outline"
													type="text" id="Topdateall" placeholder="Ke"> -->
													
													<input class="input-control input-date agency-uppercase input-control--outline" type="text" id="Topdateall" name="to" placeholder="Ke">
											</div>
											
											
										</div>
									</div>
									<div class="btn-col">
										<div>
											<button id="btn-search" type="button" class="btn__agency btn--sienna w-190px-h-54px">
												<span class="position-relative order-10 flex-justify-center gap-2level">
													<span>Cari</span>
													<svg class="agency-self-center" xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 14 14" fill="none">
														<path d="M10.5192 10.6L13 13M12.2 6.6C12.2 9.69279 9.69279 12.2 6.6 12.2C3.50721 12.2 1 9.69279 1 6.6C1 3.50721 3.50721 1 6.6 1C9.69279 1 12.2 3.50721 12.2 6.6Z" stroke="white" stroke-width="1.33333" stroke-linecap="round"/>
													</svg>
												</span>
											</button>
										</div>
										
										<!-- filter disable temporary -->
										<!-- <div class="agency-self-center">
											<a href="javascript:void(0)" class="btn-filter-advance display-none-lg display-inline-block" data-bs-toggle="collapse" data-bs-target="#collapseFilter" aria-expanded="false" aria-controls="collapseFilter">
												<span class="flex-justify-end gap-2level">
													<span class="text-axa-blue-300 agency-font-semibold agency-uppercase letter-spacing-1px filter-text">Filter</span>
													<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
														<path class="path-bar" d="M6.59995 11.9992H17.4M4.19995 7.19922H19.8M10.2 16.7992H13.8" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
														<path class="path-close" xmlns="http://www.w3.org/2000/svg" d="M19 5L5 19M19 19L5 5" stroke="#00008F" stroke-width="2" stroke-linecap="round"/>
													</svg>
												</span>
											</a>
										</div> -->
										
										
									</div>
								</div>
						
							<!-- <div class="display-grid grid-cols-repeat-12 gap-4level">
								<div class="input-col number-policy">
									<label class="label__agency" for="number_policy">Nomor Polis</label> <input
										class="input-control agency-normalcase input-control--outline"
										type="text" id="number_policy" placeholder="Nomor Polis">
								</div>
								<div class="input-col customer-name">
									<label class="label__agency" for="customer_name">Nama Nasabah</label> <input
										class="input-control agency-normalcase input-control--outline"
										type="text" id="customer_name" placeholder="Nama Nasabah">
								</div>
								<div class="btn-col">
									<div>
										<button id="btn-search" type="button"
											class="btn__agency btn--sienna w-190px-h-54px">
											<span
												class="position-relative order-10 flex-justify-center gap-2level">
												<span>Cari</span> <svg class="agency-self-center"
													xmlns="http://www.w3.org/2000/svg" width="14" height="14"
													viewBox="0 0 14 14" fill="none">
														<path
														d="M10.5192 10.6L13 13M12.2 6.6C12.2 9.69279 9.69279 12.2 6.6 12.2C3.50721 12.2 1 9.69279 1 6.6C1 3.50721 3.50721 1 6.6 1C9.69279 1 12.2 3.50721 12.2 6.6Z"
														stroke="white" stroke-width="1.33333"
														stroke-linecap="round" />
													</svg>
											</span>
										</button>
									</div>
									<div class="agency-self-center">
										<a href="javascript:void(0)"
											class="btn-filter-advance display-none-lg display-inline-block"
											data-bs-toggle="collapse" data-bs-target="#collapseFilter"
											aria-expanded="false" aria-controls="collapseFilter"> <span
											class="flex-justify-end gap-2level"> <span
												class="text-axa-blue-300 agency-font-semibold agency-uppercase letter-spacing-1px filter-text">Filter</span>
												<svg xmlns="http://www.w3.org/2000/svg" width="24"
													height="24" viewBox="0 0 24 24" fill="none">
														<path class="path-bar"
														d="M6.59995 11.9992H17.4M4.19995 7.19922H19.8M10.2 16.7992H13.8"
														stroke-width="2" stroke-linecap="round"
														stroke-linejoin="round" />
														<path class="path-close"
														xmlns="http://www.w3.org/2000/svg"
														d="M19 5L5 19M19 19L5 5" stroke="#00008F" stroke-width="2"
														stroke-linecap="round" />
													</svg>
										</span>
										</a>
									</div>
								</div>
							</div> -->
						</div>
						
						<!-- filter disable temporary -->
						<!-- <div class="filter__right">
							<a href="javascript:void(0)"
								class="btn-filter-advance display-inline-block"
								data-bs-toggle="collapse" data-bs-target="#collapseFilter"
								aria-expanded="false" aria-controls="collapseFilter"> <span
								class="flex-justify-end gap-2level"> <span
									class="letter-spacing-1px filter-text">Filter</span> <svg
										xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none">
											<path class="path-bar"
											d="M6.59995 11.9992H17.4M4.19995 7.19922H19.8M10.2 16.7992H13.8"
											stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round" />
											<path class="path-close" xmlns="http://www.w3.org/2000/svg"
											d="M19 5L5 19M19 19L5 5" stroke="#00008F" stroke-width="2"
											stroke-linecap="round" />
										</svg>
							</span>
							</a>
						</div> -->
					</div>
					<div class="filter-wrapper__advance collapse" id="collapseFilter">
						<div class="filter-advance--inner pt-20px mt-26px">
							<h3 class="mb-20px">Filter</h3>
							<div class="filter-advance--inner-grid mb-15px">
								
								<div class="input-col number-policy">
									<label class="label__agency" for="number_policy">Nomor Polis</label> <input
										class="input-control agency-normalcase input-control--outline"
										type="text" id="number_policy" placeholder="Nomor Polis">
								</div>
								<div class="input-col customer-name">
									<label class="label__agency" for="customer_name">Nama Nasabah</label> <input
										class="input-control agency-normalcase input-control--outline"
										type="text" id="customer_name" placeholder="Nama Nasabah">
								</div>
							
								<div class="input-col position-relative" id="select-product-wrapper">
									<label class="label__agency" for="product">Produk</label> 
									<select id="product" class="input-control" multiple="multiple">
											<% for(int i = 0 ; i < _products.getData().size(); i++ ) { 
												DataItemProductDto productDto = _products.getData().get(i);								
											%>
												<option value="<%=productDto.getCode() %>"><%=productDto.getName() %> (<%=productDto.getCode() %>)</option>
											<%  } %>
									</select>
								</div>
								
								<!-- <div class="input-col calendar-wrapper position-relative"
									id="calendar-wrapper-policy-purchase-date">
									<div class="display-grid grid-cols-repeat-2 position-relative">
										<div class="calendar-col">
											<label class="label__agency" for="policy_purchase_date">Tanggal Pembelian
												Polis</label> <input
												class="input-control agency-normalcase input-control--outline"
												type="text" id="Frompdateall" placeholder="Dari">
										</div>
										<div class="separated-arrow">
											<i class="fas fa-arrow-right agency-self-center text-12px"></i>
										</div>
										<div class="calendar-col">
											<label class="label__agency" for="policy_purchase_date">&nbsp;</label> <input
												class="input-control input-date agency-normalcase input-control--outline"
												type="text" id="Topdateall" placeholder="Ke">
										</div>
									</div>
								</div> -->
								
								<div class="input-col calendar-wrapper position-relative"
									id="calendar-wrapper-policy-effective-date">
									<div class="display-grid grid-cols-repeat-2 position-relative">
										<div class="calendar-col">
											<label class="label__agency" for="policy_effective_date">Tanggal Berlaku
												Polis</label> <input
												class="input-control agency-normalcase input-control--outline"
												type="text" id="Frombdateall" placeholder="Dari">
										</div>
										<div class="separated-arrow">
											<i class="fas fa-arrow-right agency-self-center text-12px"></i>
										</div>
										<div class="calendar-col">
											<label class="label__agency" for="policy_effective_date">&nbsp;</label> <input
												class="input-control input-date agency-normalcase input-control--outline"
												type="text" id="Tobdateall" placeholder="Ke">
										</div>
									</div>
								</div>
							</div>
							<div class="btn-col-filter">
								<div class="display-flex gap-4level">
									<button onclick="resetFilter()" class="btn__agency btn--dark-blue-outline w-190px-h-54px agency-self-end reset">
										<span class="position-relative order-10 flex-justify-center gap-2level">
											<span>Atur ulang</span> <svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="17"
												viewBox="0 0 16 17" fill="none">
													<path
													d="M2.11861 10.4996C2.95844 13.0548 5.36373 14.8996 8.1999 14.8996C11.7345 14.8996 14.5999 12.0342 14.5999 8.49961C14.5999 4.96499 11.7345 2.09961 8.1999 2.09961C5.831 2.09961 3.7627 3.38664 2.65611 5.29961M2.11861 4.67437L3.00016 5.49967M4.5999 6.09961H1.3999V2.89961L4.5999 6.09961Z"
													stroke-width="1.25" stroke-linecap="round"
													stroke-linejoin="round" />
												</svg>
										</span>
									</button>
									<button id="btn-search-advance" type="button"
										class="btn__agency btn--sienna w-190px-h-54px agency-self-end">
										<span class="position-relative order-10 flex-justify-center gap-2level">
											<span>Cari</span> <svg class="agency-self-center"
												xmlns="http://www.w3.org/2000/svg" width="14" height="14"
												viewBox="0 0 14 14" fill="none">
													<path
													d="M10.5192 10.6L13 13M12.2 6.6C12.2 9.69279 9.69279 12.2 6.6 12.2C3.50721 12.2 1 9.69279 1 6.6C1 3.50721 3.50721 1 6.6 1C9.69279 1 12.2 3.50721 12.2 6.6Z"
													stroke="white" stroke-width="1.33333"
													stroke-linecap="round" />
												</svg>
										</span>
									</button>
								</div>
							</div>
						</div>
					</div>
				<!-- </form> -->
			</div>
			<div class="portofolio">
				<div class="portofolio__transaction-all">
					<div class="portofolio__transaction-all--table">
						<div class="table-wrapper position-relative">
						
							<!-- add overlay for loading effect --> 
							<div id="loadingOverlay" style="display: none; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(255, 255, 255, 0.8); justify-content: center; align-items: center; z-index: 1000;">
					            <div class="spinner" style="border: 4px solid rgba(0, 0, 0, 0.1); border-left-color: #000; border-radius: 50%; width: 40px; height: 40px; animation: spin 1s linear infinite;"></div>
					        </div>
						
							<table class="table table__agency" id="Table">
								<thead>
									<tr>
										<td>
											<div class="display-flex gap-1level">
												<span class="agency-self-center agency-pointer"
													onclick="sortTable(0)">No</span> <span
													class="agency-self-center line-height-0px"> <span
													class="arrow-up" onclick="sortTable(0)"><i
														class="fas fa-caret-up fa-fw"></i></span> <span
													class="arrow-bottom" onclick="sortTable(1)"><i
														class="fas fa-caret-down fa-fw"></i></span>
												</span>
											</div>
										</td>
										<td>
											<div class="display-flex gap-1level">
												<span class="agency-self-center agency-pointer"
													onclick="sortTable(1)">No Polis</span> <span
													class="agency-self-center line-height-0px"> <span
													class="arrow-up" onclick="sortTable(0)"><i
														class="fas fa-caret-up fa-fw"></i></span> <span
													class="arrow-bottom" onclick="sortTable(1)"><i
														class="fas fa-caret-down fa-fw"></i></span>
												</span>
											</div>
										</td>
										<td>
											<div class="display-flex gap-1level">
												<span class="agency-self-center agency-pointer"
													onclick="sortTable(0)">No ref</span> <span
													class="agency-self-center line-height-0px"> <span
													class="arrow-up" onclick="sortTable(0)"><i
														class="fas fa-caret-up fa-fw"></i></span> <span
													class="arrow-bottom" onclick="sortTable(1)"><i
														class="fas fa-caret-down fa-fw"></i></span>
												</span>
											</div>
										</td>
										<td>
											<div class="display-flex gap-1level">
												<span class="agency-self-center agency-pointer"
													onclick="sortTable(1)">Tanggal <br />Pembelian
													Polis
												</span> <span class="agency-self-center line-height-0px"> <span
													class="arrow-up" onclick="sortTable(0)"><i
														class="fas fa-caret-up fa-fw"></i></span> <span
													class="arrow-bottom" onclick="sortTable(1)"><i
														class="fas fa-caret-down fa-fw"></i></span>
												</span>
											</div>
										</td>
										<td>Nama</td>
										<td>Produk</td>
										<td>
											<div class="display-flex gap-1level">
												<span class="agency-self-center agency-pointer"
													onclick="sortTable(0)">Tanggal Berlaku Polis</span> <span
													class="agency-self-center line-height-0px"> <span
													class="arrow-up" onclick="sortTable(0)"><i
														class="fas fa-caret-up fa-fw"></i></span> <span
													class="arrow-bottom" onclick="sortTable(1)"><i
														class="fas fa-caret-down fa-fw"></i></span>
												</span>
											</div>
										</td>
										<td>
											<div class="display-flex gap-1level">
												<span class="agency-self-center agency-pointer"
													onclick="sortTable(1)">Total Premi</span> <span
													class="agency-self-center line-height-0px"> <span
													class="arrow-up" onclick="sortTable(0)"><i
														class="fas fa-caret-up fa-fw"></i></span> <span
													class="arrow-bottom" onclick="sortTable(1)"><i
														class="fas fa-caret-down fa-fw"></i></span>
												</span>
											</div>
										</td>
									</tr>
								</thead>
								<tbody>
									<!-- render append here -->
								</tbody>
							</table>
						</div>
					</div>
					<div class="agency-text-center">
						<nav aria-label="Page navigation">
							<ul class="pagination agency-pointer">
							<!-- pagination here -->
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
	window.rToken = "<%= renderToken %>";
	window.apToken = "<%= apiRequestToken %>";
	window.hostpim = "<%=host%>";
</script>
<script src="<%= request.getContextPath() %>/dashboard/portofolio/js/script.js" type="text/javascript"></script>	

<script>

var loadAgentDashboardPortofolioTransactionAllDataURL = "<%=loadAgentDashboardPortofolioTransactionAllData%>";
 
//custom js
function renderPage(formData, start = 0) {
	
    var formDataObj = {
        dataCategory: "main",
        start: start,
        rtoken: rToken,
        aptoken: apToken
    };

    formData.forEach(function(value, key) {
    	//console.log('-->'+ key + ':'+ value);
        formDataObj[key] = value;
    });
    
    $.ajax({
        url: loadAgentDashboardPortofolioTransactionAllDataURL,
        type: "POST",
        data: formDataObj,
        timeout: 120000,
        dataType: "json",
        beforeSend: function() {
        	$("#btn-search").addClass("btn--disabled");
        	$("#btn-search-advance").addClass("btn--disabled");
        	showLoading();
        },
        success: function(response) {
            if (response.status) {
            	
            	//console.log('start', response.start);
            	//console.log('currPage', response.page);
            	//console.log('totalData', response.totalData);
            	//console.log('leads length', response.datas.length);

                var start = response.start;
                var dataPerPage = 10;
                var currPage = response.page;

                var totalData = response.totalData;
                $("#total-data").text(totalData);

                /* var btnDownload = document.getElementById("downloadLink");
                if (totalData < 1) {
                    btnDownload.classList.add("btn--disabled");
                } else {
                    btnDownload.classList.remove("btn--disabled");
                } */

                var totalPages = Math.ceil(totalData / dataPerPage);
                var isDisabled = start <= 0;
                var isDisabledNext = (start + dataPerPage) >= totalData;

                var maxPagesToShow = 6;
                var startPage = 1;
                var endPage = Math.min(totalPages, maxPagesToShow);

                if (currPage > (totalPages - maxPagesToShow / 2)) {
                    startPage = Math.max(1, totalPages - maxPagesToShow + 1);
                } else {
                    startPage = Math.max(1, currPage - Math.floor(maxPagesToShow / 2));
                }

                endPage = Math.min(totalPages, startPage + maxPagesToShow - 1);

                var tbodyContent = '';

                var startIdx = (currPage - 1) * dataPerPage;
                for (var i = 0; i < response.datas.length; i++) {
                    var idx = startIdx + i + 1;

                    var data = response.datas[i];
                    var netPremium = parseFloat(data.premiumAMT);
                    var formattedPremi = new Intl.NumberFormat('id-ID').format(Math.abs(Math.round(netPremium)));

                    var currencyCD = data.currencyCD ? data.currencyCD : '';
                    var finalFormatPremi = netPremium < 0 ? '(' + currencyCD + ' ' + formattedPremi + ')' : currencyCD + ' ' + formattedPremi;

                    tbodyContent += '<tr>';
                    tbodyContent += '<td>' + (currPage === 1 ? i + 1 : idx) + '</td>';
                    tbodyContent += '<td>' + data.policyNO + '</td>';
                    tbodyContent += '<td>' + data.applicationRk + '</td>';
                    tbodyContent += '<td>' + (data.issueDt ? formatDateIndonesian(data.issueDt) : '') + '</td>';
                    tbodyContent += '<td>' + (data.fullNM ? data.fullNM : '') + '</td>';
                    tbodyContent += '<td>' + (data.insuranceProductRk ? data.insuranceProductRk : '') + '</td>';
                    tbodyContent += '<td>';
                    tbodyContent += '<div class="flex-justify-between gap-2level">';
                    tbodyContent += '<span>' + (data.policyEffectiveDTTM ? formatDateIndonesian(data.policyEffectiveDTTM) : '') + '</span>';
                    tbodyContent += '<span class="agency-self-center"><i class="fas fa-arrow-right agency-self-center text-10px"></i></span>';
                    tbodyContent += '<span>' + (data.policyExpirationDTTM ? formatDateIndonesian(data.policyExpirationDTTM) : '') + '</span>';
                    tbodyContent += '</div>';
                    tbodyContent += '</td>';
                    tbodyContent += '<td>' + finalFormatPremi + '</td>';
                    tbodyContent += '</tr>';
                }


                $('#Table tbody').html(tbodyContent);

                var whereClassToAppend = '.pagination'; //pagination will append in an element with class pagination
                createPagination(start, dataPerPage, startPage, endPage, currPage, totalPages, isDisabled, isDisabledNext, whereClassToAppend);

                //sendHeightToParent();
            }

        },
        error: function(xhr, status, error) {
            console.error("Error while fetch data:", status, error);
            sendHeightToParent();
        },
        complete: function() {
            $("#btn-search").removeClass("btn--disabled");
        	$("#btn-search-advance").removeClass("btn--disabled");
        	sendHeightToParent();
        	hideLoading();
        }
    });
}

$(document).ready(function() {
	var urlParam = searchFilter();
    var formData = createFormData(urlParam);
    
    //first load page
  	renderPage(formData);
    
  	setTimeout(sendHeightToParent(), 1000);
});

function formatDateIndonesian(dateString) {
    const months = ["Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des"];

    // Parse the input date string
    const date = new Date(dateString);

    // Get day, month, and year
    const day = date.getDate();
    const month = months[date.getMonth()]; // getMonth() returns month index starting from 0
    const year = date.getFullYear();

    // Format date as dd Mmm yyyy
    return day.toString().padStart(2, '0') + " " + month + " " + year;
}

document.getElementById('btn-search').addEventListener('click', function() {
	//var policyNumber = document.getElementById('number_policy').value;
    //var name = document.getElementById('customer_name').value;
    
    var _Frompdateall = $('#Frompdateall').val();
    var _Topdateall = $('#Topdateall').val();
   
    var url = new URL(window.location.href);
    var urlWithParams = '';
    if (url.search && url.searchParams.has('a')) {
    	
		//var searchParamA = url.searchParams.get('a');
    	var searchParamA = encodeURIComponent(url.searchParams.get('a'));
		var _qParamAuth = "?a="+searchParamA;
    	
    	urlWithParams = _qParamAuth; 
    	
    	if (_Frompdateall) {
            urlWithParams += '&fpDate=' + encodeURIComponent(_Frompdateall);
        }
        if (_Topdateall) {
            urlWithParams += '&tpDate=' + encodeURIComponent(_Topdateall);
        }
    	
    	 /* if (policyNumber) {
    		 urlWithParams += '&policyNumber=' + encodeURIComponent(policyNumber);
    	 }
    	 if (name) {
    		 urlWithParams += '&name=' + encodeURIComponent(name);
    	 }*/
    	 
        if(_Frompdateall && _Topdateall) $("#rentang-waktu").text(_Frompdateall +' - '+ _Topdateall);	
    	 
    }else{
    	
    	if (_Frompdateall) {
            urlWithParams += '&fpDate=' + encodeURIComponent(_Frompdateall);
        }
        if (_Topdateall) {
            urlWithParams += '&tpDate=' + encodeURIComponent(_Topdateall);
        }
    	
    	/* if(!policyNumber && !name){
    		urlWithParams = url.toString().split('?')[0];
    	}
    	if (policyNumber) {
            urlWithParams += '?policyNumber=' + encodeURIComponent(policyNumber);
        }
        if (name) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'name=' + encodeURIComponent(name);
        } */
        
        if(_Frompdateall && _Topdateall) $("#rentang-waktu").text(_Frompdateall +' - '+ _Topdateall);
     
    }
    
    var url = window.location.origin + window.location.pathname + urlWithParams;
    var formData = createFormData(url);
	renderPage(formData);
	
});

document.getElementById('btn-search-advance').addEventListener('click', function() {
	var urlParam = searchFilter();
	var formData = createFormData(urlParam);
	renderPage(formData);
	
});

function searchFilter(){
	var policyNumber = document.getElementById('number_policy').value.trim();
    var name = document.getElementById('customer_name').value.trim();
    
    var _Frompdateall = $('#Frompdateall').val();
    var _Topdateall = $('#Topdateall').val();
    
    var _Frombdateall = $('#Frombdateall').val();
    var _Tobdateall = $('#Tobdateall').val();
    
    var check = $('#product').val();
    var arrayProduct = check;
    
   	var inputMultiselectAll = document.querySelector('input[type="checkbox"][value="multiselect-all"]');
   	var id = inputMultiselectAll.id;
    if (inputMultiselectAll.checked) arrayProduct.unshift('multiselect-all'); //code pilih semua
    var filterProduct = arrayProduct.join(',');
    
    var url = new URL(window.location.href);
    var urlWithParams = '';
    if(url.search && url.searchParams.has('a')){
    	
    	//var searchParamA = url.searchParams.get('a');
    	var searchParamA = encodeURIComponent(url.searchParams.get('a'));
    	
    	var _qParamAuth = "?a="+searchParamA;
    	
    	
    	urlWithParams = _qParamAuth;
    	
    	if(policyNumber){
    		urlWithParams += '&policyNumber=' + encodeURIComponent(policyNumber);
    	}
    	if(name){
    		urlWithParams += '&name=' + encodeURIComponent(name);
    	}
    	if (filterProduct) {
             urlWithParams += '&products=' + encodeURIComponent(filterProduct);
        }
    	
    	if (_Frompdateall) {
            urlWithParams += '&fpDate=' + encodeURIComponent(_Frompdateall);
        }
        if (_Topdateall) {
            urlWithParams += '&tpDate=' + encodeURIComponent(_Topdateall);
        }
        
        if (_Frombdateall) {
            urlWithParams += '&fbDate=' + encodeURIComponent(_Frombdateall);
        }
        if (_Tobdateall) {
            urlWithParams += '&tbDate=' + encodeURIComponent(_Tobdateall);
        }
        
        if(_Frompdateall && _Topdateall) $("#rentang-waktu").text(_Frompdateall +' - '+ _Topdateall);	
    }else{
    
    	if (policyNumber) {
    		urlWithParams += '?policyNumber=' + encodeURIComponent(policyNumber);
        }
        if (name) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'name=' + encodeURIComponent(name);
        }
        
        if (filterProduct) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'products=' + encodeURIComponent(filterProduct);
        }

        if (_Frompdateall) {
            urlWithParams += '&fpDate=' + encodeURIComponent(_Frompdateall);
        }
        if (_Topdateall) {
            urlWithParams += '&tpDate=' + encodeURIComponent(_Topdateall);
        }
        
        if (_Frombdateall) {
            urlWithParams += '&fbDate=' + encodeURIComponent(_Frombdateall);
        }
        if (_Tobdateall) {
            urlWithParams += '&tbDate=' + encodeURIComponent(_Tobdateall);
        }
        
        if(_Frompdateall && _Topdateall) $("#rentang-waktu").text(_Frompdateall +' - '+ _Topdateall);	
    }
    
    var url = window.location.origin + window.location.pathname + urlWithParams 
    return url;
}

function resetFilter(){
	
	document.getElementById('number_policy').value = '';
    document.getElementById('customer_name').value = '';
    
   	$('#Frompdateall').val('');
    $('#Topdateall').val('');
    
    $('#Frombdateall').val('');
    $('#Tobdateall').val('');
    
    $('#product option:selected').each(function() {
        $(this).prop('selected', false);
    });
    $('#product').multiselect('refresh');
    
    $("#rentang-waktu").text('');
    
}
 
 


/*date picker*/

var nowDate = new Date();
moment.locale('id');

var currentDate = moment().format("DD MMM YYYY");
var minDate = moment().subtract(1, 'years');

$('#Frompdateall').val(minDate.format("DD MMM YYYY"));
$('#Topdateall').val(currentDate);

function initializeDatePickers() {
    $('#Frompdateall').daterangepicker({
        parentEl: ".calendar",
        "startDate": minDate,
        "endDate": currentDate,
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        locale: {
        	firstDay: 1,
            applyLabel: 'Pilih',
            cancelLabel: 'Batal',
            "daysOfWeek": [
            	"Min",
				"Sen",
				"Sel",
				"Rab",
				"Kam",
				"Jum",
				"Sab"
            ],
            "monthNames": [
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember"
            ],
        }
    });

    $('#Topdateall').daterangepicker({
        parentEl: ".calendar",
        "startDate": minDate,
        "endDate": currentDate,
        minDate: minDate,
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        locale: {
        	firstDay: 1,
            applyLabel: 'Pilih',
            cancelLabel: 'Batal',
            "daysOfWeek": [
            	"Min",
				"Sen",
				"Sel",
				"Rab",
				"Kam",
				"Jum",
				"Sab"
            ],
            "monthNames": [
                "Januari",
                "Februari",
                "Maret",
                "April",
                "Mei",
                "Juni",
                "Juli",
                "Agustus",
                "September",
                "Oktober",
                "November",
                "Desember"
            ],
        }
    });
}

initializeDatePickers();

$('#Frompdateall, #Topdateall').on('apply.daterangepicker', function(ev, picker) {
    const indonesianMonths = {
        'January': 'Januari',
        'February': 'Februari',
        'March': 'Maret',
        'April': 'April',
        'May': 'Mei',
        'June': 'Juni',
        'July': 'Juli',
        'August': 'Agustus',
        'September': 'September',
        'October': 'Oktober',
        'November': 'November',
        'December': 'Desember'
    };

    const formattedDate = picker.startDate.format('DD MMM YYYY');
    const englishMonth = picker.startDate.format('MMM');
    const indonesianMonth = indonesianMonths[englishMonth];

    if (indonesianMonth) {
        const indonesianDate = formattedDate.replace(englishMonth, indonesianMonth);
        $(this).val(indonesianDate);
    } else {
        $(this).val(formattedDate);
    }

    /* if (this.id === 'Frompdateall') {
        $('#Topdateall').data('daterangepicker').minDate = picker.startDate;
        $('#Topdateall').data('daterangepicker').setStartDate(picker.startDate);
        //$('#Topdateall').val(''); // Clear the value
    } */
    
    if (this.id === 'Frompdateall') {
		const toTimespanPicker = $('#Topdateall').data('daterangepicker');
        
        const topdateallVal = $('#Topdateall').val();
        const topdateallDate = moment(topdateallVal, 'DD MMM YYYY');
        
        if (picker.startDate.isAfter(topdateallDate)) {
            toTimespanPicker.minDate = picker.startDate;
            toTimespanPicker.setStartDate(picker.startDate);
            $('#Topdateall').val(formattedDate);
        } else {
            toTimespanPicker.minDate = picker.startDate;
            toTimespanPicker.setStartDate(picker.startDate);
        }
    }
});

$('#Frompdateall, #Topdateall').on('cancel.daterangepicker', function(ev, picker) {
    $(this).val('');
});

/** end date picker */

// import js from daterangepicker.js 
/* var nowDate = new Date();
var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
var maxLimitDate = new Date(nowDate.getFullYear() + 1, nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
var minDateForSecondPicker;
moment.locale('id'); 

if($('#Frompdateall, #Topdateall').length){
	// check if element is available to bind ITS ONLY ON HOMEPAGE
	var currentDate = moment().format("DD MMM YYYY");
	var minDate = moment().subtract(1, 'years');
	
	$('#Frompdateall').val(minDate.format("DD MMM YYYY"));
	$('#Topdateall').val(currentDate);
	 

	$('#Frompdateall, #Topdateall').daterangepicker({
		parentEl: "#calendar-wrapper-policy-purchase-date",
		"alwaysShowCalendars": true,
		//"minDate": currentDate,
		"startDate": minDate,
        "endDate": currentDate,
		"showDropdowns": true,
		buttonClasses: "btn-date",
		applyButtonClasses: "btn-apply",
		cancelClass: "btn-cancel",
		autoApply: false,
		autoUpdateInput: false,
		locale: {
			applyLabel: 'Pilih', 
			cancelLabel: 'Batal',
			format: 'DD MMM YYYY',
			"daysOfWeek": [
				"Sen",
				"Sel",
				"Rab",
				"Kam",
				"Jum",
				"Sab",
				"Min",
			],
			"monthNames": [
				"Januari",
				"Februari",
				"Maret",
				"April",
				"Mei",
				"Juni",
				"Juli",
				"Agustus",
				"September",
				"Oktober",
				"November",
				"Desember"
			],
	  },
	}, function(start, end, label) {
	  // console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
	  // Lets update the fields manually this event fires on selection of range
	  var selectedStartDate = start.format('DD MMM YYYY'); // selected start
	  var selectedEndDate = end.format('DD MMM YYYY'); // selected end

	  $checkinInput = $('#Frompdateall');
	  $checkoutInput = $('#Topdateall');

	  // Updating Fields with selected dates
	  $checkinInput.val(selectedStartDate);
	  $checkoutInput.val(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKOUT FIELD (To get this it must be binded by Ids not Calss)
	  var checkOutPicker = $checkoutInput.data('daterangepicker');
	  checkOutPicker.setStartDate(selectedStartDate);
	  checkOutPicker.setEndDate(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKIN FIELD (To get this it must be binded by Ids not Calss)
	  var checkInPicker = $checkinInput.data('daterangepicker');
	  checkInPicker.setStartDate(selectedStartDate);
	  checkInPicker.setEndDate(selectedEndDate);
	});
} */

if($('#Frombdateall, #Tobdateall').length){
	// check if element is available to bind ITS ONLY ON HOMEPAGE
	var currentDate = moment().format("DD MMM YYYY");
	var minDate = moment().subtract(1, 'years');
	
	 //$('#Frombdateall').val(minDate.format("DD MMM YYYY"));
	 //$('#Tobdateall').val(currentDate);
	     

	$('#Frombdateall, #Tobdateall').daterangepicker({
		parentEl: "#calendar-wrapper-policy-effective-date",
		"alwaysShowCalendars": true,
		//"minDate": currentDate,
		//"startDate": minDate,
        //"endDate": currentDate,
		"showDropdowns": true,
		buttonClasses: "btn-date",
		applyButtonClasses: "btn-apply",
		cancelClass: "btn-cancel",
		autoApply: false,
		autoUpdateInput: false,
		locale: {
			firstDay: 1,
			applyLabel: 'Pilih', 
			cancelLabel: 'Batal',
			format: 'DD MMM YYYY',
			"daysOfWeek": [
				"Min",
				"Sen",
				"Sel",
				"Rab",
				"Kam",
				"Jum",
				"Sab"
			],
			"monthNames": [
				"Januari",
				"Februari",
				"Maret",
				"April",
				"Mei",
				"Juni",
				"Juli",
				"Agustus",
				"September",
				"Oktober",
				"November",
				"Desember"
			],
	  },
	}, function(start, end, label) {
	  // console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
	  // Lets update the fields manually this event fires on selection of range
	  var selectedStartDate = start.format('DD MMM YYYY'); // selected start
	  var selectedEndDate = end.format('DD MMM YYYY'); // selected end

	  $checkinInput = $('#Frombdateall');
	  $checkoutInput = $('#Tobdateall');

	  // Updating Fields with selected dates
	  $checkinInput.val(selectedStartDate);
	  $checkoutInput.val(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKOUT FIELD (To get this it must be binded by Ids not Calss)
	  var checkOutPicker = $checkoutInput.data('daterangepicker');
	  checkOutPicker.setStartDate(selectedStartDate);
	  checkOutPicker.setEndDate(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKIN FIELD (To get this it must be binded by Ids not Calss)
	  var checkInPicker = $checkinInput.data('daterangepicker');
	  checkInPicker.setStartDate(selectedStartDate);
	  checkInPicker.setEndDate(selectedEndDate);
	});
}


document.addEventListener('DOMContentLoaded', function() {
 //sendHeightToParent();
});

window.addEventListener('resize', function() {
 sendHeightToParent();
});


</script>