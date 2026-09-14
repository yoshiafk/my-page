<%@page import="com.mypage.agencyportal.dto.DataLeadsStatusDto"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.mypage.agencyportal.dto.APIResponse"%>
<%@page import="com.mypage.agencyportal.dto.DataItemProductDto"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.mypage.agencyportal.dto.DataItemDto"%>
<%@include file="../../init.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
    APIResponse<DataItemProductDto> _products = (APIResponse<DataItemProductDto>) renderRequest.getAttribute("products");    
	APIResponse<DataLeadsStatusDto> _statusLeads = (APIResponse<DataLeadsStatusDto>) renderRequest.getAttribute("statusLeads");
	
    ActionHelpers helpers = new ActionHelpers();
    String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
    String tokenMobile = !Validator.isNull((String) renderRequest.getAttribute("tokenMobile")) ? (String) renderRequest.getAttribute("tokenMobile") : "";
    String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
    String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
    
%>

<portlet:resourceURL id="/data/dashboard/portofolio/transaction/online" var="loadAgentDashboardPortofolioTransactionOnlineData" />

<div class="breadcrumbs container-breadcrumbs-axa">
	<nav class="width-full">
		<ol class="list-reset display-inline-flex">
			<li class="text-13px agency-self-center"><a href="<%= host %>/dashboard" class="link-dashboard">Beranda</a></li>
			<li class="agency-self-center"><span class="text-13px">/</span></li>
			<li class="text-13px agency-uppercase agency-self-center">Portofolio Transaksi Online</li>
		</ol>
	</nav>
</div>

<div class="dashboard">
	<div class="dashboard__portofolio">
		<div class="container-axa">
			
			<div class="col-portofolio">
					<div class="col">
						<h1>Daftar Transaksi AXA myPage</h1>
						<p class="col-text">
							<span>Rentang Waktu</span> <span class="mx-3level">:</span> <span id="rentang-waktu"><!-- 30 OKT 2023 - 6 NOV 2023 --></span>
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
							<% if (Validator.isNull(tokenMobile) == true) { %>
								<div>
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
								</div>
							<% } %>
						</div>
					</div>
				</div>
			
			<div class="filter-wrapper mb-30px">
				<!-- <form action=""> -->
					<div class="filter-grid" aria-expanded="false">
						<div class="filter__left">
							<div class="display-grid grid-cols-repeat-12 gap-4level">
								<div class="input-col reference-name">
									<label class="label__agency" for="reference_name">Nomor Referensi</label> <input
										class="input-control agency-normalcase input-control--outline"
										type="text" id="reference_name" placeholder="Nomor Referensi">
								</div>
								<div class="input-col customer-name">
									<label class="label__agency" for="customer_name">Nama Nasabah</label> <input
										class="input-control agency-normalcase input-control--outline"
										type="text" id="customer_name" placeholder="Nama Nasabah">
								</div>
								<div class="btn-col input-col">
									<div>
										<button id="btn-search" type="button"
											class="btn__agency btn--sienna w-190px-h-54px">
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
									<div class="agency-self-center">
										<a href="javascript:void(0)"
											class="btn-filter-advance display-none-lg display-inline-block"
											data-bs-toggle="collapse" data-bs-target="#collapseFilter"
											aria-expanded="false" aria-controls="collapseFilter"> <span
											class="flex-justify-end gap-2level"> <span
												class="filter-text">Filter</span> <svg
													xmlns="http://www.w3.org/2000/svg" width="24" height="24"
													viewBox="0 0 24 24" fill="none">
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
							</div>
						</div>
						<div class="filter__right">
							<a href="javascript:void(0)"
								class="btn-filter-advance display-inline-block"
								data-bs-toggle="collapse" data-bs-target="#collapseFilter"
								aria-expanded="false" aria-controls="collapseFilter"> <span
								class="flex-justify-end gap-2level"> <span class="filter-text">Filter</span>
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
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
						</div>
					</div>
					<div class="filter-wrapper__advance collapse" id="collapseFilter">
						<div class="filter-advance--inner pt-20px mt-26px">
							<h3 class="mb-20px">Filter</h3>
							<div class="filter-advance--inner-grid mb-15px">
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
								<div class="input-col position-relative">
									<label class="label__agency" for="type-polis">Tipe Polis</label> 
									<select
										class="input-control" name="type-polis" id="type-polis">
										<option></option>
										<option value="Policy">Polis</option>
										<option value="Quotation">Penawaran</option>
									</select>
								</div>
								<div class="input-col position-relative">
									<label class="label__agency" for="status">Status</label> 
									<select
										class="input-control" name="status" id="status">
										<option></option>
										<% for(int i = 0 ; i < _statusLeads.getData().size(); i++ ) { 
											DataLeadsStatusDto statusDto = _statusLeads.getData().get(i);
											
											String status = statusDto.getValue().equalsIgnoreCase("Expired") ? "Kedaluwarsa Penawaran" : statusDto.getName();
										%>
										<option value="<%=statusDto.getValue() %>"><%=status %></option>
										<%  } %>
										
									</select>
								</div>
							</div>
							<div class="calendar-wrapper col-calendar edit position-relative">
								<div class="display-grid grid-cols-repeat-2 position-relative">
									<div class="calendar calendar-col">
										<label class="label__agency" for="time_span">Rentang Waktu</label>
										<!-- <input
											class="input-control agency-normalcase input-control--outline"
											type="text" id="Fromtimespan" placeholder="Dari" readonly="readonly"> -->
											
										<input class="input-control agency-self-center agency-uppercase input-control--outline" type="text" id="Fromtimespan" name="from" placeholder="Dari">
										
										<!-- <label for="time_span">Rentang Waktu</label>
										<div class="inner-input">
												<input class="input-control agency-normalcase input-control--outline" type="text" id="Fromtimespan" name="from" placeholder="Dari" autocomplete="off">
												<div class="separated-arrow">
													<i class="fas fa-arrow-right agency-self-center text-12px"></i>
												</div>
											</div> -->
										
									</div>
									<div class="position-absolute left-50-percent top-35px bg-white w-26px-h-52px ml-min-25px display-flex">
										<i class="agency-text-grey-800 fas fa-arrow-right agency-self-center text-12px"></i>
									</div>
									
									<div class="calendar-col">
										<label class="label__agency" for="time_span">&nbsp;</label>
										<!-- <input
											class="input-control input-date agency-normalcase input-control--outline"
											type="text" id="Totimespan" placeholder="Ke" readonly="readonly"> -->
										
										<input class="input-control input-date agency-uppercase input-control--outline" type="text" id="Totimespan" name="to" placeholder="Ke">
										
										<!-- <label for="time_span">&nbsp;</label>
										<input class="input-control agency-normalcase input-control--outline" type="text" id="Totimespan" name="to" placeholder="Ke" autocomplete="off"> -->
									
									</div>
								</div>
								<div class="display-flex gap-4level">
									<button onclick="resetFilter()" class="btn__agency btn--dark-blue-outline w-190px-h-54px agency-self-end reset">
										<span class="position-relative order-10 flex-justify-center gap-2level">
											<span>Atur ulang</span> 
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="17" viewBox="0 0 16 17" fill="none">
													<path d="M2.11861 10.4996C2.95844 13.0548 5.36373 14.8996 8.1999 14.8996C11.7345 14.8996 14.5999 12.0342 14.5999 8.49961C14.5999 4.96499 11.7345 2.09961 8.1999 2.09961C5.831 2.09961 3.7627 3.38664 2.65611 5.29961M2.11861 4.67437L3.00016 5.49967M4.5999 6.09961H1.3999V2.89961L4.5999 6.09961Z" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round"/>
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
								
								<!-- hapus button -->
								<div class="btn-delete">
                                        <a href="javascript:void(0)" class="btn btn__agency btn--dark-blue gap-2level flex-justify-center agency-text-center p-12px-25px-10px-25px">
                                            <span class="position-relative order-10">Hapus</span>
                                            <svg class="w-16px-h-16px position-relative order-10" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="none">
                                                <path d="M1.59998 3.6002H14.4M6.39998 11.6002V6.8002M9.59998 11.6002V6.8002M11.2 14.8002H4.79998C3.91632 14.8002 3.19998 14.0839 3.19998 13.2002V4.4002C3.19998 3.95837 3.55815 3.6002 3.99998 3.6002H12C12.4418 3.6002 12.8 3.95837 12.8 4.4002V13.2002C12.8 14.0839 12.0836 14.8002 11.2 14.8002ZM6.39998 3.6002H9.59998C10.0418 3.6002 10.4 3.24202 10.4 2.8002V2.0002C10.4 1.55837 10.0418 1.2002 9.59998 1.2002H6.39998C5.95815 1.2002 5.59998 1.55837 5.59998 2.0002V2.8002C5.59998 3.24202 5.95815 3.6002 6.39998 3.6002Z" stroke-width="1.25" stroke-linecap="round" stroke-linejoin="round"></path>
                                            </svg>
                                        </a>
                                    </div>
								
							</div>
						</div>
					</div>
				<!-- </form> -->
			</div>
			<div class="portofolio">
				<div class="portofolio__transaction-mypage">
					<!-- <div class="portofolio__transaction-mypage--table edit"> -->
					<div class="portofolio__transaction-mypage--table">
						<div class="table-wrapper position-relative">
						
							<!-- add overlay for loading effect --> 
							<div id="loadingOverlay" style="display: none; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(255, 255, 255, 0.8); justify-content: center; align-items: center; z-index: 1000;">
					            <div class="spinner" style="border: 4px solid rgba(0, 0, 0, 0.1); border-left-color: #000; border-radius: 50%; width: 40px; height: 40px; animation: spin 1s linear infinite;"></div>
					        </div>
						
							<table class="table table__agency" id="Table">
								<thead>
									<tr>
										
										<!-- checkbox head for delete -->
										<td>
											<div id="checkboxhead" class="display-inline-flex align-items-center checkbox-custom-wrapper">
													<input id="edit-h" class="checkbox-custom selectall" name="edit-h" type="checkbox">
													<label for="edit-h" class="checkbox-custom-label">
														<span></span>
													</label>
											</div>
                                        </td>
                                            
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
										<td>No ref</td>
										<td>Tanggal</td>
										<td>Nama</td>
										<td>Produk</td>
										<td>
											<div class="display-flex gap-1level">
												<span class="agency-self-center agency-pointer"
													onclick="sortTable(0)">Tipe Polis</span> <span
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
													onclick="sortTable(0)">Total Premi</span> <span
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
													onclick="sortTable(0)">Status</span> <span
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
								<tbody> <!-- render append here --> </tbody>
								
							</table>
						</div>
						
						<div class="agency-text-center">
							<nav aria-label="Page navigation">
								<ul class="pagination agency-pointer">
									<!-- render append here -->
								</ul>								
							</nav>
						</div>
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

var loadAgentDashboardPortofolioTransactionOnlineDataURL = "<%=loadAgentDashboardPortofolioTransactionOnlineData%>";

function renderPage(formData, start = 0) {

    var formDataObj = {
        dataCategory: "main",
        start: start,
        rtoken: rToken,
        aptoken: apToken
    };

    formData.forEach(function(value, key) {
        formDataObj[key] = value;
    });
    
    $.ajax({
        url: loadAgentDashboardPortofolioTransactionOnlineDataURL,
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

                var rtoken = response.rtoken;
                //console.log('rtoken',rtoken)
            	
                var start = response.start;
                var dataPerPage = 10;
                var currPage = response.page;

                var totalData = response.totalData;
                $("#total-data").text(totalData);

                <% if (Validator.isNull(tokenMobile) == true) { %>
	                var btnDownload = document.getElementById("downloadLink");
	                if (totalData < 1) {
	                    btnDownload.classList.add("btn--disabled");
	                } else {
	                    btnDownload.classList.remove("btn--disabled");
	                }
	            <% } %>

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
                var hasExpired = false; //for flag btn-delete
                
                for (var i = 0; i < response.leads.length; i++) {
                    var idx = startIdx + i + 1;

                    var data = response.leads[i];

                    var netPremium = parseFloat(data.netPremium);
                    
                    //var formattedPremi = new Intl.NumberFormat('id-ID').format(Math.round(netPremium));
                    var formattedPremi = new Intl.NumberFormat('id-ID', {
					    minimumFractionDigits: 0,
					    maximumFractionDigits: 2
					}).format(netPremium);
                    

                    var polisType = data.policyType.toLowerCase() === 'policy' ? 'Polis' : 'Penawaran';

                    var status = "";
                    var statusClass = "";
                    
                    if (data.status !== null) {
                        switch (data.status.toLowerCase()) {
                            case "paymentsuccess":
                                status = "Polis Terbit";
                                statusClass = "approve";
                                break;
                            case "paymentwaiting":
                                status = "Menunggu Pembayaran";
                                break;
                            case "expired":
                                status = "Kedaluwarsa Penawaran";
                                statusClass = "expire";
                                hasExpired = true;
                                break;
                            default:
                                status = "Lain lain";
                                break;
                        }
                    }


                    tbodyContent += '<tr class="' + statusClass + '">';
                    
                 	// Only add checkbox if the status is "expired" or "quotation"
                    if (data.status.toLowerCase() === "expired") { //if penawaran and expired
                        tbodyContent += '<td>';
                        tbodyContent += '<div class="inline-flex items-center checkbox-custom-wrapper">';
                        tbodyContent += '<input id="edit-' + idx + '" class="checkbox-custom" name="edit-' + idx + '" type="checkbox">';
                        tbodyContent += '<label for="edit-' + idx + '" class="checkbox-custom-label"><span></span></label>';
                        tbodyContent += '</div>';
                        tbodyContent += '</td>';
                    } else {
                        tbodyContent += '<td></td>';
                    }

                    tbodyContent += '<td>' + (currPage === 1 ? i + 1 : idx) + '</td>';
                    
                    tbodyContent += '<td><a href="javascript:void(0)" onclick="handleClickLihatDetail(\'' + data.target + '\')" >' + data.referenceNumber + '</a></td>';
                    
                  	tbodyContent += '<td>' + (data.transactionDate ? data.transactionDate.substring(0, 11).toUpperCase() : '') + '</td>';
                    tbodyContent += '<td>' + (data.name ? data.name : '') + '</td>';
                  
                    tbodyContent += '<td><a href="javascript:void(0)" onclick="handleClickLihatDetail(\'' + data.target + '\')" >' + (data.product ? data.product : '') + '</a></td>';
                    
                    tbodyContent += '<td>' + polisType + '</td>';
                    tbodyContent += '<td>' + (data.currency ? data.currency : '') + ' ' + formattedPremi + '</td>';
                    tbodyContent += '<td>' + status + '</td>';

                    tbodyContent += '</tr>';

                }

                $('#Table tbody').html(tbodyContent);
                
                
                // check if filter to delete
                // console.log(hasExpired)
                if (hasExpired) {
                    $('.btn-delete').show();
                    $('#checkboxhead').show();
                    $('.portofolio__transaction-mypage--table').addClass('edit');
                } else {
                    $('.btn-delete').hide();
                    $('#checkboxhead').hide();
                    $('.portofolio__transaction-mypage--table').removeClass('edit');
                }

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
        	
        	//uncheck if render
          	$('#edit-h').prop('checked', false);
        }
    });
    
}

$(document).ready(function() {
	var urlParam = searchFilter();
    var formData = createFormData(urlParam);
    
    //first load page
  	renderPage(formData);
    
    setTimeout(sendHeightToParent(), 1000);
    
    
 	//checked #edit-h
    $('#edit-h').on('change', function() {
        var checked = $(this).is(':checked');
        $('tbody .checkbox-custom').prop('checked', checked);
        checkAllCheckboxes();
    });

    $('tbody').on('change', '.checkbox-custom', function() {
        checkAllCheckboxes();
    });

    function checkAllCheckboxes() {
        var allChecked = true;
        $('tbody .checkbox-custom').each(function() {
            if (!$(this).is(':checked')) {
                allChecked = false;
            }
        });

        $('#edit-h').prop('checked', allChecked);
    }
    
    //end checkbox function
    
    
    $(".btn-delete").click(function(e) {
        e.preventDefault();
        var selectedoids = getSelectedOID();
        var selectedReferences = getSelectedReferences();
        
        if (selectedoids.length > 0) {
            var confirmDelete = confirm("Apakah Anda yakin ingin menghapus penawaran dengan No Ref : "+ selectedReferences + " ?");
            if (confirmDelete) {
                deleteSelectedReferences(selectedoids, formData);
            } else {
                alert("Batal hapus!!");
            }
        } else {
            alert("Tidak ada referensi yang dipilih untuk dihapus.");
        }
    });
});

function getSelectedOID() {
    var selectedOID = [];
    $("#Table tbody input[type='checkbox']:checked").each(function() {
        var oId = $(this).closest('tr').find('td a').attr('onclick').match(/'([^']+)'/)[1];
        selectedOID.push(oId);
    });
    return selectedOID.join(',');
}

function getSelectedReferences() {
    var selectedReferences = [];
    $("#Table tbody input[type='checkbox']:checked").each(function() {
    	var ref = $(this).closest('tr').find('td').eq(2).text().trim();
        // console.log('>>', ref);
        selectedReferences.push(ref);
    });
    return selectedReferences.join(',');
}


function deleteSelectedReferences(references, formData) {
	
	var formDataObj = {
        dataCategory: "unpublish",
        rtoken: rToken,
        aptoken: apToken,
        oid: references
    };
	
	formData.forEach(function(value, key) {
        formDataObj[key] = value;
    });
	
    $.ajax({
    	url: loadAgentDashboardPortofolioTransactionOnlineDataURL,
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
                //console.log('sukses respon sum>>', response.totalDelete);
                //console.log('status>>', response.statusDelete);
                //console.log('message>>', response.messageDelete);
                
                var urlParam = searchFilter();
			    var formData = createFormData(urlParam);
			    
			  	renderPage(formData);
			  	
			  	alert("Penawaran Berhasil dihapus.");
			  	
			  	//uncheck after success
			  	$('#edit-h').prop('checked', false);
			  	
            }else{
            	alert(response.messageDelete);
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

function handleClickLihatDetail(getO_id) {
    window.open(hostpim+"/dashboard/leads/online/"+getO_id, '_blank'); //target blank deceive reload token once
}


document.getElementById('btn-search').addEventListener('click', function() {
	var referenceNumber = document.getElementById('reference_name').value;
    var name = document.getElementById('customer_name').value;

    var _startDate = $('#Fromtimespan').val();
    var _endDate = $('#Totimespan').val();
   
    var url = new URL(window.location.href);
    var urlWithParams = '';
    if (url.search && url.searchParams.has('a')) {
		
		//var searchParamA = url.searchParams.get('a');
    	var searchParamA = encodeURIComponent(url.searchParams.get('a'));
    	
    	var _qParamAuth = "?a="+searchParamA;
    	
    	urlWithParams = _qParamAuth; 
    	
    	 if (referenceNumber) {
    		 urlWithParams += '&referenceNumber=' + encodeURIComponent(referenceNumber);
    	 }
    	 if (name) {
    		 urlWithParams += '&name=' + encodeURIComponent(name);
    	 }
    	 if (_startDate) {
             urlWithParams += '&startDate=' + encodeURIComponent(_startDate);
         }
         if (_endDate) {
             urlWithParams += '&endDate=' + encodeURIComponent(_endDate);
         }
         
         if(_startDate && _endDate) $("#rentang-waktu").text(_startDate +' - '+ _endDate);
    	 
    }else{
    	if(!referenceNumber && !name){
    		urlWithParams = url.toString().split('?')[0];
    	}
    	if (referenceNumber) {
            urlWithParams += '?referenceNumber=' + encodeURIComponent(referenceNumber);
        }
        if (name) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'name=' + encodeURIComponent(name);
        }
        if (_startDate) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'startDate=' + encodeURIComponent(_startDate);
        }
        if (_endDate) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'endDate=' + encodeURIComponent(_endDate);
        }
        
        if(_startDate && _endDate) $("#rentang-waktu").text(_startDate +' - '+ _endDate);

    }
    
    var url = window.location.origin + window.location.pathname + urlWithParams;
    var formData = createFormData(url);
	renderPage(formData);
	
});


document.getElementById('btn-search-advance').addEventListener('click', function() {
	var urlParam = searchFilter();
	var _startDate = $('#Fromtimespan').val(); 
	var warningUnduh = document.getElementById("warningMessage");
	if(!_startDate){
         warningUnduh.classList.add("display-none");
	}
	
	var formData = createFormData(urlParam);
	renderPage(formData);
	
});


function searchFilter(){
	
	var referenceNumber = document.getElementById('reference_name').value.trim();
    var name = document.getElementById('customer_name').value.trim();
    
    var selectPolicy = document.getElementById('type-polis');
    var _policyType = selectPolicy.value.trim();
    
    var selectStatus = document.getElementById('status');
    var _status = selectStatus.value.trim();
    
    var _startDate = $('#Fromtimespan').val();
    var _endDate = $('#Totimespan').val();
    
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
    	
    	if(referenceNumber){
    		urlWithParams += '&referenceNumber=' + encodeURIComponent(referenceNumber);
    	}
    	if(name){
    		urlWithParams += '&name=' + encodeURIComponent(name);
    	}
    	if (filterProduct) {
             urlWithParams += '&products=' + encodeURIComponent(filterProduct);
        }
    	if (_policyType) {
            urlWithParams += '&policyType=' + encodeURIComponent(_policyType);
        }
    	if (_status) {
             urlWithParams += '&state=' + encodeURIComponent(_status);
        }
    	
    	if (_startDate) {
            urlWithParams += '&startDate=' + encodeURIComponent(_startDate);
        }
        if (_endDate) {
            urlWithParams += '&endDate=' + encodeURIComponent(_endDate);
        }
        
        if(_startDate && _endDate) $("#rentang-waktu").text(_startDate +' - '+ _endDate);	
    }else{
    
    	if (referenceNumber) {
    		urlWithParams += '?referenceNumber=' + encodeURIComponent(referenceNumber);
        }
        if (name) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'name=' + encodeURIComponent(name);
        }
        
        if (filterProduct) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'products=' + encodeURIComponent(filterProduct);
        }

        if (_policyType) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'policyType=' + encodeURIComponent(_policyType);
        }
        if (_status) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'state=' + encodeURIComponent(_status);
        }
        
        if (_startDate) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'startDate=' + encodeURIComponent(_startDate);
        }
        if (_endDate) {
            urlWithParams += (urlWithParams ? '&' : '?') + 'endDate=' + encodeURIComponent(_endDate);
        }
        
        if(_startDate && _endDate) $("#rentang-waktu").text(_startDate +' - '+ _endDate);
    }
    
    var url = window.location.origin + window.location.pathname + urlWithParams 
    return url;
}

function resetFilter(){
	
	document.getElementById('reference_name').value = '';
    document.getElementById('customer_name').value = '';
    
    $('#type-polis').val(null).trigger('change');
    $('#status').val(null).trigger('change');
    
    $('#Fromtimespan').val('');
    $('#Totimespan').val('');
    
    $('#product option:selected').each(function() {
        $(this).prop('selected', false);
    });
    $('#product').multiselect('refresh');
    
    $("#rentang-waktu").text('');
    
}

function getQueryParameters(url) {
    var queryString = url.split('?')[1];
    if (!queryString) {
        return {};
    }

    var params = {};
    var queryStringArray = queryString.split('&');
    for (var i = 0; i < queryStringArray.length; i++) {
        var pair = queryStringArray[i].split('=');
        var key = decodeURIComponent(pair[0]);
        var value = decodeURIComponent(pair[1] || '');
        params[key] = value;
    }
    return params;
} 


function formatDate(dateString) {
    var date = new Date(dateString);
    var year = date.getFullYear();
    var month = (date.getMonth() + 1).toString().padStart(2, '0');
    var day = date.getDate().toString().padStart(2, '0');
    return year + month + day;
}


function formatDateIndo(dateString){
	
    var parts = dateString.split(' ');
    var day = parts[0];
    var month = parts[1];
    var year = parts[2];
    
    switch(month) {
        case "Jan":
            month = "01";
            break;
        case "Feb":
            month = "02";
            break;
        case "Mar":
            month = "03";
            break;
        case "Apr":
            month = "04";
            break;
        case "Mei":
            month = "05";
            break;
        case "Jun":
            month = "06";
            break;
        case "Jul":
            month = "07";
            break;
        case "Agt":
            month = "08";
            break;
        case "Sep":
            month = "09";
            break;
        case "Okt":
            month = "10";
            break;
        case "Nov":
            month = "11";
            break;
        case "Des":
            month = "12";
            break;
    }
    
    if(day.length == 1) {
        day = "0" + day;
    }
    
    var formattedDate = year + month + day;
    return formattedDate;
}

<% if (Validator.isNull(tokenMobile) == true) { %>
document.getElementById("downloadLink").addEventListener("click", function(event) {
    event.preventDefault(); 
    
    var urlParam = searchFilter();
    var params = getQueryParameters(urlParam);
    var StartDate = params["startDate"];
    var EndDate = params["endDate"];
    
    var sdateReq = null;
    var edateReq = null;
	var threeMonthsAgo = new Date();
    threeMonthsAgo.setMonth(threeMonthsAgo.getMonth() - 3);
    
    if (StartDate && EndDate) {
        sdateReq = formatDateIndo(StartDate);
        edateReq = formatDateIndo(EndDate);
        
        var threeMonthsAgoFormatted = formatDate(threeMonthsAgo);
        var warningUnduh = document.getElementById("warningMessage");

        if (sdateReq < threeMonthsAgoFormatted) {
            warningUnduh.classList.remove("display-none");
            return;
        } else {
            warningUnduh.classList.add("display-none");
        }
    }
    
 	this.classList.add("btn--disabled");
    this.querySelector('span').textContent = 'Mengunduh';
    
    var formDataDownload = createFormData(urlParam);
	downloadFileViaPortlet(formDataDownload);
   
});

function downloadFileViaPortlet(formData) {
    var formDataObj = {
        dataCategory: "download",
        rtoken: rToken,
        aptoken: apToken
    };

    formData.forEach(function(value, key) {
        formDataObj[key] = value;
    });

    var now = new Date();
    var formattedDateTime = new Intl.DateTimeFormat('id-ID', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit',
        hour12: false
    }).format(now).replace(/[^\d]/g, '');

    var fileName = "Transaction-Online-Report_" + formattedDateTime + ".xls"; //the extention should same with api service

    $.ajax({
        type: "POST",
        url: loadAgentDashboardPortofolioTransactionOnlineDataURL,
        data: formDataObj,
        xhrFields: {
            responseType: 'blob'
        },
        success: function(data, textStatus, xhr) {
            var downloadLink = document.getElementById("downloadLink");
            downloadLink.classList.remove("btn--disabled");
            downloadLink.querySelector('span').textContent = 'Unduh';

            var blob = new Blob([data], {
                type: 'application/vnd.ms-excel'
            });
            var url = window.URL.createObjectURL(blob);
            var a = document.createElement('a');
            a.href = url;
            a.download = fileName;
            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
            window.URL.revokeObjectURL(url);
        },
        error: function(xhr, textStatus, errorThrown) {
            console.error("Error downloading Excel file:", errorThrown);
        }
    });
}

<% } %>

/*date picker*/

var nowDate = new Date();
moment.locale('id');

var currentDate = moment().format("DD MMM YYYY");
var minDate = moment().subtract(3, 'months');

$('#Fromtimespan').val(minDate.format("DD MMM YYYY"));
$('#Totimespan').val(currentDate);

function initializeDatePickers() {
    $('#Fromtimespan').daterangepicker({
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

    $('#Totimespan').daterangepicker({
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

$('#Fromtimespan, #Totimespan').on('apply.daterangepicker', function(ev, picker) {
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
    
   /*  if (this.id === 'Fromtimespan') {
        $('#Totimespan').data('daterangepicker').minDate = picker.startDate;
        $('#Totimespan').data('daterangepicker').setStartDate(picker.startDate);
        //$('#Totimespan').val(''); // Clear the value
    } */
    
    if (this.id === 'Fromtimespan') {
		const toTimespanPicker = $('#Totimespan').data('daterangepicker');
        
        const topdateallVal = $('#Totimespan').val();
        const topdateallDate = moment(topdateallVal, 'DD MMM YYYY');
        
        if (picker.startDate.isAfter(topdateallDate)) {
            toTimespanPicker.minDate = picker.startDate;
            toTimespanPicker.setStartDate(picker.startDate);
            $('#Totimespan').val(formattedDate);
        } else {
            toTimespanPicker.minDate = picker.startDate;
            toTimespanPicker.setStartDate(picker.startDate);
        }
    }
   
});

$('#Fromtimespan, #Totimespan').on('cancel.daterangepicker', function(ev, picker) {
    $(this).val('');
});

/** end date picker */


window.addEventListener('resize', function() {
 sendHeightToParent();
});

</script>
