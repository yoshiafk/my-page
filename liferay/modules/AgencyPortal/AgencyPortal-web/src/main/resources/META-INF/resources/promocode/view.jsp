<%@page import="com.mypage.agencyportal.dto.APIResponse"%>
<%@page import="com.mypage.agencyportal.dto.DataItemProductDto"%>
<%@ include file="../init.jsp" %>

<%  
	long userId = (long) renderRequest.getAttribute("userId");
	int size = (int) renderRequest.getAttribute("size");
	int current_page = (int) renderRequest.getAttribute("current_page");
	int total_pages = (int) renderRequest.getAttribute("total_pages");
	
	int previousPage = Math.max(1, current_page - 1);
	int nextPage = Math.min(total_pages, current_page + 1);
	
	int start = current_page > 0 ? (current_page - 1) * size : 0;
	int end = current_page > 0 ? current_page * size : 0;
	
	List<MasterPromoCode> items = MasterPromoCodeLocalServiceUtil.findByFilter(start, end, userId);

	APIResponse<DataItemProductDto> _products = (APIResponse<DataItemProductDto>) renderRequest.getAttribute("products");

    ActionHelpers helpers = new ActionHelpers();
    String host = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
    
    String renderToken = !Validator.isNull((String) renderRequest.getAttribute("renderToken")) ? (String) renderRequest.getAttribute("renderToken") : "";
    String apiRequestToken = !Validator.isNull((String) renderRequest.getAttribute("apiRequestToken")) ? (String) renderRequest.getAttribute("apiRequestToken") : "";
    String encodeToken = !Validator.isNull((String) renderRequest.getAttribute("encodeToken")) ? (String) renderRequest.getAttribute("encodeToken") : "";
%>

<portlet:resourceURL id="/data/agentpromocode" var="loadAgentPromoCodeData" />

<div class="breadcrumbs container-breadcrumbs-axa">
	<nav class="width-full">
		<ol class="list-reset display-inline-flex">
			<li class="text-13px agency-self-center">
				<a href="<%= host %>/dashboard" class="link-dashboard">Beranda</a>
			</li>
			<li class="agency-self-center">
				<span class="text-13px">/</span>
			</li>
			<li class="text-13px agency-uppercase agency-self-center">Kode Promo</li>
		</ol>
	</nav>
</div>

<div class="dashboard">
	<div class="dashboard__promo-code">
		<div class="container-axa">
			<div class="col-promo-code mb-30px">
				<h1>Pengaturan Kode Promo</h1>
				<a href="javascript:void(0)" class="btn__agency  btn--sienna agency-self-center display-inline-block btn-input-promo-code">
					<span class="position-relative order-10">
						<span class="text-14px agency-uppercase letter-spacing-1px mr-4px">Buat Kode Promo</span>
						<svg class="w-16px-h-16px display-inline-block vertical-align-middle position-relative top-min-1px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="none">
							<path d="M12.8 7.99995L3.20005 7.99995M8.00005 12.8L8.00005 3.19995" stroke-width="2" stroke-linecap="round"/>
						</svg>
					</span>
				</a>
			</div>
			<div class="promo-code">
				<div class="promo__settings">
					<div class="promo__settings--table">
						<div class="table-wrapper">
							<table class="table__agency" id="Table">
								<thead>
									<tr>
										<td>No</td>
										<td>Kode Promo</td>
										<td>Produk</td>
										<td>Diskon</td>
										<td>Maks Kupon</td>
										<td>Periode Awal</td>
										<td>Periode Akhir</td>
										<td>Status</td>
										<td>Aksi</td>
									</tr>
								</thead>
								<tbody>
									<% if (items.size() > 0) { %>
										<% for (int i = 0; i < items.size(); i++) { %>
											<tr>
												<fmt:formatDate value="<%= items.get(i).getStartDate() %>" pattern="d MMM yyyy" var="formattedStartDate" />
												<fmt:formatDate value="<%= items.get(i).getEndDate() %>" pattern="d MMM yyyy" var="formattedEndDate" />
											
												<td><%= i + 1 %></td>
												<td><%= items.get(i).getPromoCode() %></td>
												<td><%= items.get(i).getProductName() %></td>
												<td><%= (items.get(i).getDiscount() == Math.floor(items.get(i).getDiscount())) ? String.format("%.0f", items.get(i).getDiscount()) : items.get(i).getDiscount() %></td>
												<td><%= items.get(i).getLimit() %></td>
												<td>${ formattedStartDate }</td>
												<td>${ formattedEndDate }</td>
												<td><% if (items.get(i).getActive() == 1) { %>Aktif<% } else { %>NonAktif<% } %></td>
												<td>
													<a href="javascript:void(0)" class="btn__agency btn--dark-blue display-block agency-text-center btn-view" data-target="<%= EncryptionHelper.encryptRandom(String.valueOf(items.get(i).getPromoCodeId())) %>">
														<span class="position-relative order-10 flex-justify-center">
															<span class="display-inline-block">Ubah</span> 
															<svg class="display-inline-block ml-4px" xmlns="http://www.w3.org/2000/svg" width="17" height="16" viewBox="0 0 17 16" fill="none">
																<path d="M9.70001 13.0346H13.7M3.30005 13.0346L6.21071 12.4481C6.36522 12.417 6.5071 12.3409 6.61853 12.2294L13.1343 5.71007C13.4467 5.3975 13.4465 4.89084 13.1338 4.57853L11.7536 3.19981C11.441 2.88764 10.9346 2.88785 10.6224 3.20029L4.10589 9.72032C3.99468 9.83159 3.91875 9.97318 3.88758 10.1274L3.30005 13.0346Z" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
															</svg>
														</span>
													</a>
												</td>
											</tr>
										<% } %>
									<% } %>
								</tbody>
							</table>
						</div>
						<div class="agency-text-center">
							<nav aria-label="Page navigation">
								<ul class="pagination">
									<li>
										<% if (current_page > 1) { %>
											<a class="prev" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPage %>)">Sebelumnya</a>
											<a class="prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPage %>)"><i class="fas fa-chevron-left"></i></a>
										<% } else { %>
											<a class="disabled prev" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPage %>)">Sebelumnya</a>
											<a class="disabled prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(<%= previousPage %>)"><i class="fas fa-chevron-left"></i></a>
										<% } %>
									</li>
									
									<% if (current_page > 4) { %>
							            <li><a href="javascript:void(0)" onclick="page(1)">1</a></li>
							            <li><a class="disabled">...</a></li>
							        <% } %>
							        
							        <%
							        	int iteratorUp = current_page == 1 ? 4 : current_page == 2 ? 3 : current_page == 3 ? 2 : 1;
							        	int iteratorDown = current_page == (total_pages - 4) ? 0 : current_page == (total_pages - 3) ? 1 : current_page == (total_pages - 2) ? 2 : current_page == (total_pages - 1) ? 3 : 4;
							        %>
							        
							        <% if (current_page <= 4) { %>
							        	<% for (int i = Math.max(1, current_page - 4); i <= Math.min(total_pages, current_page + iteratorUp); i++) { %>
								            <li><a <% if (i == current_page) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)"><%= i %></a></li>
								        <% } %>
							        <% } else if (current_page >= total_pages - 4) { %>
							        	<% for (int i = Math.max(1, current_page - iteratorDown); i <= total_pages; i++) { %>
								            <li><a <% if (i == current_page) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)"><%= i %></a></li>
								        <% } %>
							        <% } else { %>
								        <% for (int i = Math.max(1, current_page - 1); i <= Math.min(total_pages, current_page + 1); i++) { %>
								            <li><a <% if (i == current_page) { %>class="active" aria-current="page"<% } %> href="javascript:void(0)" onclick="page(<%= i %>)"><%= i %></a></li>
								        <% } %>
							        <% } %>
							        
							        <% if (current_page < total_pages - 4) { %>
							            <li><a class="disabled">...</a></li>
							            <li><a href="javascript:void(0)" onclick="page(<%= total_pages %>)"><%= total_pages %></a></li>
							        <% } %>
							        
									<li>
										<% if (current_page < total_pages) { %>
											<a class="next" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPage %>)">Selanjutnya</a>
											<a class="next-mobile" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPage %>)"><i class="fas fa-chevron-right"></i></a>
										<% } else { %>
											<a class="disabled next" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPage %>)">Selanjutnya</a>
											<a class="disabled next-mobile" aria-label="Next" href="javascript:void(0)" onclick="page(<%= nextPage %>)"><i class="fas fa-chevron-right"></i></a>
										<% } %>
									</li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal Create Kode Promo -->
<div class="modal modal-agency width-full fade" id="ModalPromoCode" tabindex="-1" style="display: none;" aria-labelledby="ModalPromoCodeLabel" aria-hidden="true">
	<div class="modal-max-w-676px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-agency-content modal-content">
			<div class="modal-agency-header modal-header p-18px-20px">
				<h1>Buat Kode Promo</h1>
			</div>
			<div class="multi-step-form">
				<form class="promo-code-form" id="formPromoCode" action="javascript:void()" autocomplete="off" novalidate="novalidate">
					<fieldset aria-label="CreatePromoCode" id="create-promo-code">
						<div class="modal-agency-body p-20px relative">
							<div class="col-create-promo position-relative mb-15px">
								<div class="input-col">
									<label class="label__agency" for="kode-promo">Kode Promo<sup>*</sup></label>
									<input class="input-control agency-uppercase input-control--outline agency-bg-transparent" type="text" id="kode-promo" name="kode-promo" placeholder="Isi kode promo" maxlength="30" required>
								</div>
								<div class="input-col">
									<label class="label__agency" for="maksimal-kupon">Maksimal Kupon</label>
									<input class="input-control agency-normalcase input-control--outline agency-bg-transparent disabled" type="text" id="maksimal-kupon" name="maksimal-kupon" placeholder="Kupon" value="Tidak dibatasi" maxlength="8" disabled>
									<div class="display-flex mt-16px">
										<input type="checkbox" id="coupon" class="input-switch" checked>
										<label for="coupon" class="label-max-coupon">Tidak Dibatasi</label>
									</div>
								</div>
							</div>
							<div class="col-create-promo position-relative mb-15px">
								<div class="input-col">
									<label class="label__agency" for="Product">Produk<sup>*</sup></label>
									<div id="product-wrapper" class="position-relative">
										<select class="input-control" name="Product" id="Product" required>
											<option></option>
											<% if (_products.getData().size() > 0) {  %>
												<% for (int i = 0; i < _products.getData().size(); i++) { %>
													<option value="<%= _products.getData().get(i).getCode() %>"><%= _products.getData().get(i).getCode().concat(" - ").concat(_products.getData().get(i).getName()) %></option>
												<% } %>
											<% } %>
										</select>
									</div>
								</div>
								<div class="input-col">
									<label class="label__agency" for="Terminologi-kodePromo">Terminologi Kode Promo</label>
									<div id="terminologi-wrapper" class="position-relative">
										<select class="input-control" name="Terminologi-kodePromo" id="Terminologi-kodePromo">
											<option></option>
											<option value="Annual">TAHUNAN</option>
											<option value="ShortTerm">JANGKA PENDEK</option>
											<option value="Both">KEDUANYA</option>
										</select>										
									</div>
								</div>
							</div>
							<div class="col-create-promo mb-15px">
								<div class="input-col periode-mulai position-relative">
									<label class="label__agency" for="periode-promo">Periode Promo<sup>*</sup></label>
									<input class="input-control input-date agency-normalcase input-control--outline agency-bg-transparent" type="text" id="periode-promo" name="periode-promo" placeholder="Tanggal mulai" required>
								</div>
								<div class="input-col periode-selesai position-relative">
									<label class="label__agency" for="periode-promo-selesai">&nbsp;</label>
									<input class="input-control input-date agency-normalcase input-control--outline agency-bg-transparent disabled" type="text" id="periode-promo-selesai" name="periode-promo-selesai" placeholder="Selesai" required disabled>
								</div>
							</div>
							<div class="col-create-promo position-relative mb-15px">
								<div class="input-col">
									<label class="label__agency" for="discount">Diskon<sup>*</sup></label>
									<div id="discount-wrapper">
										<div class="input-group">
											<input class="input-control agency-uppercase input-control--outline agency-bg-transparent" type="number" name="discount" id="discount" placeholder="0" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==2) return false;" required>
											<span class="btn-group">%</span>
										</div>
									</div>
								</div>
								<div class="input-col">
									<label class="label__agency" for="Status">Status<sup>*</sup></label>
									<div id="status-wrapper" class="relative">
										<select class="input-control" name="Status" id="Status" required>
											<option></option>
											<option value="AKTIF">AKTIF</option>
											<option value="NONAKTIF">NONAKTIF</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-agency-footer flex-justify-between p-20px-30px">
							<a class="btn-cancel-create-promo text-14px agency-uppercase agency-self-center agency-pointer" data-bs-toggle="modal" data-bs-target="#ModalPromoCode">Batalkan</a>
							<button type="button" class="btn-prev-promo-code text-14px agency-uppercase agency-self-center display-none" data-bs-toggle="modal" data-bs-target="#ModalBack" aria-label="Close">Batalkan</button>
							<button class="btn__agency btn--dark-blue btn-promo-code p-12px-30px-10px-30px">
								<span class="position-relative order-50">
									Buat Kode 
									<svg class="w-16px-h-16px display-inline-block vertical-align-middle position-relative top-min-1px left-5px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="none">
										<path d="M12.8 7.99995L3.20005 7.99995M8.00005 12.8L8.00005 3.19995" stroke-width="2" stroke-linecap="round"/>
									</svg>
								</span>
							</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Modal Edit Kode Promo -->
<div class="modal modal-agency width-full fade" id="ModalEditPromoCode" tabindex="-1" style="display: none;" aria-labelledby="ModalEditPromoCodeLabel" aria-hidden="true">
	<div class="modal-max-w-676px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-content modal-agency-content">
			<div class="modal-agency-header modal-header p-18px-20px">
				<h1>Ubah Kode Promo</h1>
			</div>
			<div class="multi-step-form">
				<form class="edit-promo-code-form" id="formEditPromoCode" action="javascript:void()" autocomplete="off" novalidate="novalidate">
					<fieldset aria-label="EditPromoCode" id="edit-promo-code">
						<div class="modal-agency-body p-20px position-relative">
							<input type="hidden" name="promo-code-target">
							<div class="col-edit-promo position-relative mb-15px">
								<div class="input-col">
									<label class="label__agency" for="edit-kode-promo">Kode Promo<sup>*</sup></label>
									<input class="input-control agency-uppercase input-control--outline agency-bg-transparent" type="text" id="edit-kode-promo" name="edit-kode-promo" placeholder="Isi kode promo" maxlength="30">
								</div>
								<div class="input-col">
									<label class="label__agency" for="edit-maksimal-kupon">Maksimal Kupon</label>
									<input class="input-control agency-uppercase input-control--outline agency-bg-transparent" type="text" id="edit-maksimal-kupon" placeholder="Kupon" name="maksimal-kupon" maxlength="8">
									<span class="note-text">Kosongkan untuk kupon unlimited</span>
								</div>
							</div>
							<div class="col-edit-promo position-relative mb-15px">
								<div class="input-col">
									<label class="label__agency" for="Product-edit">Produk<sup>*</sup></label>
									<div id="product-edit-wrapper" class="position-relative">
										<select class="input-control" name="Product-edit" id="Product-edit">
											<option></option>
											<% if (_products.getData().size() > 0) { %>
												<% for (int i = 0; i < _products.getData().size(); i++) { %>
													<option value="<%= _products.getData().get(i).getCode() %>"><%= _products.getData().get(i).getCode().concat(" - ").concat(_products.getData().get(i).getName()) %></option>
												<% } %>
											<% } %>
										</select>
									</div>
								</div>
								<div class="input-col">
									<label class="label__agency" for="Terminologi-kodePromo-edit">Terminologi Kode Promo</label>
									<div id="terminologi-edit-wrapper" class="position-relative">
										<select class="input-control" name="Terminologi-kodePromo-edit" id="Terminologi-kodePromo-edit">
											<option></option>
											<option value="Annual">TAHUNAN</option>
											<option value="ShortTerm">JANGKA PENDEK</option>
											<option value="Both">KEDUANYA</option>
										</select>										
									</div>
								</div>
							</div>
							<div class="col-edit-promo mb-15px">
								<div class="input-col periode-mulai-edit position-relative">
									<label class="label__agency" for="periode-promo-edit">Periode Promo <sup>*</sup></label>
									<input class="input-control input-date agency-normalcase input-control--outline agency-bg-transparent" type="text" id="periode-promo-edit" name="periode-promo-edit" placeholder="Tanggal mulai">
								</div>
								<div class="input-col periode-selesai-edit position-relative">
									<label class="label__agency" for="periode-promo-selesai-edit">&nbsp;</label>
									<input class="input-control input-date agency-normalcase input-control--outline agency-bg-transparent disabled" type="text" id="periode-promo-selesai-edit" name="periode-promo-selesai-edit" placeholder="Selesai" disabled>
								</div>
							</div>
							<div class="col-edit-promo position-relative mb-15px">
								<div class="input-col">
									<label class="label__agency" for="discount-edit">Diskon<sup>*</sup></label>
									<div id="discount-edit-wrapper">
										<div class="input-group">
											<input class="input-control agency-uppercase input-control--outline agency-bg-transparent" type="number" name="discount-edit" id="discount-edit" placeholder="0" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==2) return false;" required>
											<span class="btn-group">%</span>
										</div>
									</div>
								</div>
								<div class="input-col">
									<label class="label__agency" for="Status">Status<sup>*</sup></label>
									<div id="status-edit-wrapper" class="position-relative">
										<select class="input-control" name="Status-edit" id="Status-edit">
											<option></option>
											<option value="AKTIF">AKTIF</option>
											<option value="NONAKTIF">NONAKTIF</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-agency-footer flex-justify-between p-20px-30px">
							<a class="btn-cancel-edit-promo text-14px agency-uppercase agency-self-center agency-pointer" data-bs-toggle="modal" data-bs-target="#ModalEditPromoCode">Batalkan</a>
							<button type="button" class="btn-prev-promo-code text-14px agency-uppercase agency-self-center display-none" data-bs-toggle="modal" data-bs-target="#ModalEditBackPromoCode" aria-label="Close">Batalkan</button>
							<button class="btn__agency btn--dark-blue btn-edit-promo-code p-12px-30px-10px-30px ">
								<span class="position-relative order-50">
									Simpan Kode 
									<svg class="w-16px-h-16px display-inline-block vertical-align-middle position-relative top-min-1px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 17 16" fill="none">
										<path class="stroke-white" d="M9.70001 13.0346H13.7M3.30005 13.0346L6.21071 12.4481C6.36522 12.417 6.5071 12.3409 6.61853 12.2294L13.1343 5.71007C13.4467 5.3975 13.4465 4.89084 13.1338 4.57853L11.7536 3.19981C11.441 2.88764 10.9346 2.88785 10.6224 3.20029L4.10589 9.72032C3.99468 9.83159 3.91875 9.97318 3.88758 10.1274L3.30005 13.0346Z" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
									</svg>
								</span>
							</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Modal Failed Create Promo Code -->
<div class="modal modal-agency width-full fade" id="ModalFailedPromoCode" tabindex="-1" style="display: none;" aria-labelledby="ModalFailedPromoCodeLabel" aria-hidden="true">
	<div class="modal-max-w-430px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-content modal-agency-content">
			<div class="modal-agency-header modal-header p-18px-20px">
				<h2 class="text-32px">Perhatian</h2>
			</div>
			<div class="modal-agency-body agency-text-center p-18px-20px position-relative modal-agency-alert-body">
			
			</div>
			<div class="modal-agency-body agency-text-center mb-20px">
				<button type="button" class="btn__agency btn--dark-blue btn-enter-login p-12px-30px-10px-30px"  onclick="closeModalFailedPromoCode()"><span class="position-relative order-50">OK</span></button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Success Create Promo Code -->
<div class="modal modal-agency width-full fade" id="ModalSuccessPromoCode" tabindex="-1" style="display: none;" aria-labelledby="ModalSuccessPromoCodeLabel" aria-hidden="true">
	<div class="modal-max-w-560px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-agency-content">
			<div class="modal-agency-body agency-text-center p-80px-40px position-relative">
				<svg class="w-82px-h-82px m-0-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 82 82" fill="none">
					<g clip-path="url(#clip0_559_15798)">
						<path d="M71.479 34.1509C70.7401 32.7021 69.4383 31.6197 67.8792 31.1582C66.3194 30.696 64.6388 30.894 63.2294 31.7066L61.5468 32.6773C61.3212 31.8115 60.8942 31.0112 60.3009 30.3421C59.4979 29.4418 58.4375 28.8098 57.264 28.5318L57.7704 28.0261C60.1015 25.7937 60.2767 22.1263 58.1685 19.6814C57.0798 18.4672 55.5393 17.7546 53.9092 17.7111C52.2783 17.6676 50.7019 18.2968 49.5498 19.4517L46.7241 22.2843C46.0901 19.611 43.7045 17.7221 40.9567 17.7194H40.9484C39.379 17.7159 37.873 18.341 36.7664 19.4544L27.0729 29.1465L27.0557 29.1638L25.9733 30.2455C25.7746 28.4973 24.9578 26.8768 23.6691 25.6778C21.9195 24.1001 19.2401 24.1752 17.5809 25.8475L7.37899 36.0625C-1.95023 45.1199 -2.5042 59.9137 6.12134 69.6437C7.86604 71.5533 9.9067 73.1697 12.1654 74.4301C12.6331 74.9289 13.1402 75.429 13.6886 75.9195C21.4221 82.7997 32.6968 83.9442 41.6549 78.7584L65.1535 65.1947C67.9778 63.6383 69.0941 60.1475 67.6971 57.2418C67.1514 56.16 66.2863 55.2722 65.219 54.6982L68.2241 52.9645C71.0575 51.4178 72.1868 47.9243 70.7939 45.0116C70.2517 43.9354 69.3921 43.0524 68.3311 42.4811L68.943 42.1279C71.7742 40.5654 72.8877 37.0615 71.479 34.1509ZM8.2096 67.7403C0.59749 59.1258 1.10869 46.0478 9.36928 38.0535L19.5774 27.8468C20.15 27.2362 21.1034 27.1886 21.7333 27.7392C22.646 28.5925 23.1737 29.7791 23.1958 31.0285C23.2179 32.2772 22.7322 33.4824 21.8506 34.3668H21.8437L12.2502 43.9602C11.6983 44.5128 11.699 45.4076 12.2509 45.9588C12.8028 46.5107 13.6976 46.51 14.2495 45.9581L23.8257 36.3806L38.7457 21.4606C39.3252 20.8776 40.113 20.5513 40.9346 20.5534C42.1937 20.5506 43.3306 21.3088 43.8128 22.4726C44.295 23.6358 44.0267 24.9755 43.134 25.8648L27.173 41.8354C26.8059 42.19 26.6583 42.7157 26.788 43.2097C26.917 43.7036 27.3027 44.0893 27.7966 44.2183C28.2906 44.348 28.8162 44.2003 29.1708 43.8333L45.1519 27.8537L51.5546 21.4509C52.1589 20.8438 52.9861 20.5134 53.8422 20.5368C54.6977 20.5596 55.5062 20.9349 56.0761 21.5737C57.1557 22.9079 57.0267 24.8486 55.7794 26.0283L51.7043 30.1034V30.1116L33.5674 48.2313C33.2004 48.5866 33.0528 49.1116 33.1825 49.6055C33.3115 50.0995 33.6971 50.4851 34.1911 50.6148C34.6857 50.7438 35.2107 50.5969 35.5653 50.2292L53.6884 32.1068C54.2769 31.4817 55.1116 31.1485 55.9684 31.1968C56.8239 31.2161 57.6324 31.5907 58.2009 32.2296C58.8135 32.9415 59.0598 33.8984 58.8694 34.818C58.8432 34.9615 58.808 35.1029 58.7631 35.2416C58.7438 35.3023 58.7238 35.3616 58.7011 35.4209C58.6617 35.5258 58.619 35.6272 58.5714 35.7279C58.5224 35.8245 58.4686 35.919 58.4099 36.0101C58.3706 36.0763 58.334 36.1432 58.2899 36.2067C58.1754 36.3709 58.0464 36.5254 57.9056 36.6689L51.8844 42.7129L51.8754 42.7212L39.9654 54.6278C39.5977 54.9824 39.4507 55.5074 39.5797 56.0014C39.7094 56.4953 40.0951 56.8817 40.589 57.0107C41.083 57.1404 41.608 56.9927 41.9632 56.6257L53.8478 44.7391C53.8478 44.7391 53.865 44.7302 53.8719 44.7233C54.8646 43.6464 56.4976 43.4622 57.7049 44.2914C57.7732 44.3335 57.8463 44.3645 57.9098 44.4128C57.9732 44.4604 58.0443 44.537 58.1133 44.5977C58.2078 44.675 58.2975 44.7571 58.383 44.8433C58.3892 44.8529 58.3961 44.8619 58.403 44.8702C58.6514 45.1744 58.8425 45.5201 58.968 45.8919C59.0474 46.1541 59.0901 46.4252 59.097 46.6984V46.8557C59.0881 47.4117 58.9473 47.9581 58.6873 48.4493C58.6562 48.5086 58.6238 48.5679 58.5879 48.6273C58.4561 48.8494 58.2995 49.0564 58.1202 49.2433C58.105 49.2599 58.094 49.2799 58.0767 49.2971L38.8898 68.4833C38.4663 68.9076 38.042 69.296 37.5956 69.6734C31.582 74.7619 23.2434 76.0989 15.9404 73.1448C15.4264 72.9358 14.9173 72.7054 14.4137 72.4536C12.0722 71.2794 9.96879 69.681 8.2096 67.7403ZM63.7351 62.7477L40.2392 76.3107C34.3925 79.698 27.2792 80.0891 21.0965 77.3634C22.855 77.5752 24.6321 77.5856 26.3934 77.3931C26.5341 77.3793 26.6659 77.3496 26.8046 77.3338C27.511 77.2475 28.2002 77.1372 28.8908 76.9902C29.1357 76.9398 29.3744 76.8702 29.6172 76.8108C30.1981 76.6701 30.7727 76.5114 31.3426 76.3252C31.6137 76.2376 31.8793 76.1389 32.1477 76.0423C32.683 75.8464 33.2101 75.6325 33.7316 75.398C34.0014 75.2766 34.2697 75.1538 34.5367 75.0213C35.0486 74.7681 35.5488 74.4915 36.0441 74.2003C36.2973 74.0589 36.5532 73.9092 36.8016 73.7492C37.3114 73.4242 37.8033 73.0696 38.291 72.7026C38.5042 72.5439 38.7229 72.397 38.9326 72.2307C39.5438 71.7389 40.1344 71.2132 40.7042 70.6537C40.7677 70.593 40.8367 70.5433 40.8988 70.4812L45.543 65.8363H45.5589C45.8066 65.8356 46.0501 65.7707 46.2653 65.6466L60.8459 57.2273L60.8618 57.2149C61.6034 56.7954 62.4843 56.6988 63.2998 56.9458C64.1152 57.1935 64.7934 57.764 65.1776 58.5243C65.8744 60.0923 65.2473 61.9316 63.7379 62.7477H63.7351ZM66.8154 50.512L59.4261 54.7789C59.4178 54.7789 59.413 54.7927 59.4047 54.7968L52.7315 58.6546L60.0925 51.293C60.3437 51.0377 60.572 50.7604 60.7755 50.4651C60.8417 50.372 60.8997 50.2788 60.9604 50.1829C61.0811 49.9905 61.1915 49.7918 61.2909 49.5883C61.3543 49.4593 61.4226 49.3337 61.4757 49.2019C61.6524 48.7549 61.78 48.2899 61.8559 47.8146C61.8786 47.6732 61.9014 47.5421 61.9138 47.4048C61.9324 47.2172 61.9407 47.0309 61.9407 46.8398C61.9407 46.6984 61.9311 46.5576 61.9214 46.4162C61.9214 46.3355 61.9214 46.2562 61.9111 46.1775L63.94 45.0047C64.6795 44.5777 65.5619 44.4735 66.3808 44.7157C67.1997 44.9571 67.8833 45.5249 68.2717 46.2844C68.9651 47.8574 68.3317 49.6986 66.8182 50.512H66.8154ZM67.5218 39.6754L62.5271 42.5619L60.89 43.507C60.7659 43.3152 60.6313 43.1303 60.4858 42.9544C60.3002 42.7537 60.1022 42.5646 59.8925 42.3894C59.8697 42.3708 59.8511 42.3473 59.8283 42.3287C59.7097 42.2314 59.58 42.1535 59.4544 42.0658C59.3282 41.9782 59.2226 41.8892 59.0984 41.814C58.5872 41.5112 58.0333 41.287 57.4551 41.1504L59.9194 38.6875C60.156 38.4405 60.3733 38.1749 60.5692 37.8935C60.6451 37.7879 60.71 37.6817 60.7838 37.5727C60.8866 37.4092 60.977 37.2408 61.0666 37.0698C61.2267 36.7572 61.3605 36.4316 61.4661 36.0963C61.4806 36.0543 61.4985 36.0142 61.5116 35.9722L64.6478 34.1605C65.3867 33.7349 66.2676 33.6307 67.0851 33.8735C67.9026 34.1157 68.5849 34.6835 68.9713 35.4437C69.6632 37.0153 69.0347 38.8552 67.526 39.6754H67.5218Z" fill="#1F1F9C"/>
						<path d="M70.3826 15.8686C70.9345 16.4198 71.8286 16.4198 72.3805 15.8686L81.5642 6.68496C81.9312 6.33036 82.0788 5.80467 81.9491 5.31072C81.8201 4.81677 81.4345 4.43113 80.9405 4.30212C80.4466 4.17242 79.9209 4.32006 79.5663 4.68707L70.3826 13.8707C69.8314 14.4226 69.8314 15.3167 70.3826 15.8686Z" fill="#1F1F9C"/>
						<path d="M79.8372 15.7789L72.7729 20.0175C72.3307 20.2727 72.0602 20.7467 72.0658 21.2579C72.072 21.7684 72.3527 22.2361 72.8012 22.481C73.2496 22.726 73.7953 22.7101 74.2285 22.439L81.2929 18.2004C81.7351 17.9451 82.0055 17.4712 82 16.96C81.9938 16.4494 81.7123 15.9817 81.2646 15.7368C80.8162 15.4919 80.2705 15.5078 79.8372 15.7789Z" fill="#1F1F9C"/>
						<path d="M64.3926 15.4357C65.0907 15.7847 65.94 15.5012 66.2883 14.803L70.527 6.32583C70.876 5.62699 70.5925 4.77844 69.8936 4.42936C69.1955 4.08097 68.3469 4.36382 67.9979 5.06267L63.7593 13.5399C63.4102 14.238 63.6937 15.0873 64.3926 15.4357Z" fill="#1F1F9C"/>
						<path d="M31.229 11.8952C31.5436 12.601 32.3659 12.9231 33.0758 12.6182C33.7863 12.314 34.1202 11.4958 33.8257 10.7818L29.5871 0.891679C29.2725 0.185934 28.4501 -0.136239 27.7396 0.168687C27.0297 0.472923 26.6958 1.29112 26.9904 2.00514L31.229 11.8952Z" fill="#1F1F9C"/>
						<path d="M38.1792 12.751C38.9595 12.751 39.5921 12.1183 39.5921 11.3381V2.86087C39.5921 2.08062 38.9595 1.448 38.1792 1.448C37.399 1.448 36.7664 2.08062 36.7664 2.86087V11.3381C36.7664 12.1183 37.399 12.751 38.1792 12.751Z" fill="#1F1F9C"/>
						<path d="M25.7724 15.047C26.2601 15.6561 27.1501 15.7548 27.7592 15.2671C28.3684 14.78 28.4671 13.8901 27.9793 13.2809L22.3278 6.21655C21.8408 5.60739 20.9508 5.50874 20.3417 5.99648C19.7325 6.48353 19.6339 7.37348 20.1209 7.98264L25.7724 15.047Z" fill="#1F1F9C"/>
					</g>
					<defs>
						<clipPath id="clip0_559_15798">
							<rect width="82" height="82" fill="white"/>
						</clipPath>
					</defs>
				</svg>
				<h1 class="text-32px mb-15px">Kode Promo Sudah Di Buat</h1>
				<p class="mb-20px">Kode Promo sudah berhasil di buat anda bisa <br/>tekan tombol &ldquo;kembali&rdquo;</p>
				<button type="button" class="btn__agency btn--dark-blue btn-enter-login p-12px-30px-10px-30px" data-bs-dismiss="modal" aria-label="Close"><span class="position-relative order-50">Kembali</span></button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Success Edit Promo Code -->
<div class="modal modal-agency width-full fade" id="ModalSuccessEditPromoCode" tabindex="-1" style="display: none;" aria-labelledby="ModalSuccessEditPromoCodeLabel" aria-hidden="true">
	<div class="modal-max-w-560px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-content modal-agency-content">
			<div class="modal-agency-body agency-text-center p-80px-40px position-relative">
				<svg class="w-82px-h-82px m-0-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 82 82" fill="none">
					<g clip-path="url(#clip0_559_15798)">
						<path d="M71.479 34.1509C70.7401 32.7021 69.4383 31.6197 67.8792 31.1582C66.3194 30.696 64.6388 30.894 63.2294 31.7066L61.5468 32.6773C61.3212 31.8115 60.8942 31.0112 60.3009 30.3421C59.4979 29.4418 58.4375 28.8098 57.264 28.5318L57.7704 28.0261C60.1015 25.7937 60.2767 22.1263 58.1685 19.6814C57.0798 18.4672 55.5393 17.7546 53.9092 17.7111C52.2783 17.6676 50.7019 18.2968 49.5498 19.4517L46.7241 22.2843C46.0901 19.611 43.7045 17.7221 40.9567 17.7194H40.9484C39.379 17.7159 37.873 18.341 36.7664 19.4544L27.0729 29.1465L27.0557 29.1638L25.9733 30.2455C25.7746 28.4973 24.9578 26.8768 23.6691 25.6778C21.9195 24.1001 19.2401 24.1752 17.5809 25.8475L7.37899 36.0625C-1.95023 45.1199 -2.5042 59.9137 6.12134 69.6437C7.86604 71.5533 9.9067 73.1697 12.1654 74.4301C12.6331 74.9289 13.1402 75.429 13.6886 75.9195C21.4221 82.7997 32.6968 83.9442 41.6549 78.7584L65.1535 65.1947C67.9778 63.6383 69.0941 60.1475 67.6971 57.2418C67.1514 56.16 66.2863 55.2722 65.219 54.6982L68.2241 52.9645C71.0575 51.4178 72.1868 47.9243 70.7939 45.0116C70.2517 43.9354 69.3921 43.0524 68.3311 42.4811L68.943 42.1279C71.7742 40.5654 72.8877 37.0615 71.479 34.1509ZM8.2096 67.7403C0.59749 59.1258 1.10869 46.0478 9.36928 38.0535L19.5774 27.8468C20.15 27.2362 21.1034 27.1886 21.7333 27.7392C22.646 28.5925 23.1737 29.7791 23.1958 31.0285C23.2179 32.2772 22.7322 33.4824 21.8506 34.3668H21.8437L12.2502 43.9602C11.6983 44.5128 11.699 45.4076 12.2509 45.9588C12.8028 46.5107 13.6976 46.51 14.2495 45.9581L23.8257 36.3806L38.7457 21.4606C39.3252 20.8776 40.113 20.5513 40.9346 20.5534C42.1937 20.5506 43.3306 21.3088 43.8128 22.4726C44.295 23.6358 44.0267 24.9755 43.134 25.8648L27.173 41.8354C26.8059 42.19 26.6583 42.7157 26.788 43.2097C26.917 43.7036 27.3027 44.0893 27.7966 44.2183C28.2906 44.348 28.8162 44.2003 29.1708 43.8333L45.1519 27.8537L51.5546 21.4509C52.1589 20.8438 52.9861 20.5134 53.8422 20.5368C54.6977 20.5596 55.5062 20.9349 56.0761 21.5737C57.1557 22.9079 57.0267 24.8486 55.7794 26.0283L51.7043 30.1034V30.1116L33.5674 48.2313C33.2004 48.5866 33.0528 49.1116 33.1825 49.6055C33.3115 50.0995 33.6971 50.4851 34.1911 50.6148C34.6857 50.7438 35.2107 50.5969 35.5653 50.2292L53.6884 32.1068C54.2769 31.4817 55.1116 31.1485 55.9684 31.1968C56.8239 31.2161 57.6324 31.5907 58.2009 32.2296C58.8135 32.9415 59.0598 33.8984 58.8694 34.818C58.8432 34.9615 58.808 35.1029 58.7631 35.2416C58.7438 35.3023 58.7238 35.3616 58.7011 35.4209C58.6617 35.5258 58.619 35.6272 58.5714 35.7279C58.5224 35.8245 58.4686 35.919 58.4099 36.0101C58.3706 36.0763 58.334 36.1432 58.2899 36.2067C58.1754 36.3709 58.0464 36.5254 57.9056 36.6689L51.8844 42.7129L51.8754 42.7212L39.9654 54.6278C39.5977 54.9824 39.4507 55.5074 39.5797 56.0014C39.7094 56.4953 40.0951 56.8817 40.589 57.0107C41.083 57.1404 41.608 56.9927 41.9632 56.6257L53.8478 44.7391C53.8478 44.7391 53.865 44.7302 53.8719 44.7233C54.8646 43.6464 56.4976 43.4622 57.7049 44.2914C57.7732 44.3335 57.8463 44.3645 57.9098 44.4128C57.9732 44.4604 58.0443 44.537 58.1133 44.5977C58.2078 44.675 58.2975 44.7571 58.383 44.8433C58.3892 44.8529 58.3961 44.8619 58.403 44.8702C58.6514 45.1744 58.8425 45.5201 58.968 45.8919C59.0474 46.1541 59.0901 46.4252 59.097 46.6984V46.8557C59.0881 47.4117 58.9473 47.9581 58.6873 48.4493C58.6562 48.5086 58.6238 48.5679 58.5879 48.6273C58.4561 48.8494 58.2995 49.0564 58.1202 49.2433C58.105 49.2599 58.094 49.2799 58.0767 49.2971L38.8898 68.4833C38.4663 68.9076 38.042 69.296 37.5956 69.6734C31.582 74.7619 23.2434 76.0989 15.9404 73.1448C15.4264 72.9358 14.9173 72.7054 14.4137 72.4536C12.0722 71.2794 9.96879 69.681 8.2096 67.7403ZM63.7351 62.7477L40.2392 76.3107C34.3925 79.698 27.2792 80.0891 21.0965 77.3634C22.855 77.5752 24.6321 77.5856 26.3934 77.3931C26.5341 77.3793 26.6659 77.3496 26.8046 77.3338C27.511 77.2475 28.2002 77.1372 28.8908 76.9902C29.1357 76.9398 29.3744 76.8702 29.6172 76.8108C30.1981 76.6701 30.7727 76.5114 31.3426 76.3252C31.6137 76.2376 31.8793 76.1389 32.1477 76.0423C32.683 75.8464 33.2101 75.6325 33.7316 75.398C34.0014 75.2766 34.2697 75.1538 34.5367 75.0213C35.0486 74.7681 35.5488 74.4915 36.0441 74.2003C36.2973 74.0589 36.5532 73.9092 36.8016 73.7492C37.3114 73.4242 37.8033 73.0696 38.291 72.7026C38.5042 72.5439 38.7229 72.397 38.9326 72.2307C39.5438 71.7389 40.1344 71.2132 40.7042 70.6537C40.7677 70.593 40.8367 70.5433 40.8988 70.4812L45.543 65.8363H45.5589C45.8066 65.8356 46.0501 65.7707 46.2653 65.6466L60.8459 57.2273L60.8618 57.2149C61.6034 56.7954 62.4843 56.6988 63.2998 56.9458C64.1152 57.1935 64.7934 57.764 65.1776 58.5243C65.8744 60.0923 65.2473 61.9316 63.7379 62.7477H63.7351ZM66.8154 50.512L59.4261 54.7789C59.4178 54.7789 59.413 54.7927 59.4047 54.7968L52.7315 58.6546L60.0925 51.293C60.3437 51.0377 60.572 50.7604 60.7755 50.4651C60.8417 50.372 60.8997 50.2788 60.9604 50.1829C61.0811 49.9905 61.1915 49.7918 61.2909 49.5883C61.3543 49.4593 61.4226 49.3337 61.4757 49.2019C61.6524 48.7549 61.78 48.2899 61.8559 47.8146C61.8786 47.6732 61.9014 47.5421 61.9138 47.4048C61.9324 47.2172 61.9407 47.0309 61.9407 46.8398C61.9407 46.6984 61.9311 46.5576 61.9214 46.4162C61.9214 46.3355 61.9214 46.2562 61.9111 46.1775L63.94 45.0047C64.6795 44.5777 65.5619 44.4735 66.3808 44.7157C67.1997 44.9571 67.8833 45.5249 68.2717 46.2844C68.9651 47.8574 68.3317 49.6986 66.8182 50.512H66.8154ZM67.5218 39.6754L62.5271 42.5619L60.89 43.507C60.7659 43.3152 60.6313 43.1303 60.4858 42.9544C60.3002 42.7537 60.1022 42.5646 59.8925 42.3894C59.8697 42.3708 59.8511 42.3473 59.8283 42.3287C59.7097 42.2314 59.58 42.1535 59.4544 42.0658C59.3282 41.9782 59.2226 41.8892 59.0984 41.814C58.5872 41.5112 58.0333 41.287 57.4551 41.1504L59.9194 38.6875C60.156 38.4405 60.3733 38.1749 60.5692 37.8935C60.6451 37.7879 60.71 37.6817 60.7838 37.5727C60.8866 37.4092 60.977 37.2408 61.0666 37.0698C61.2267 36.7572 61.3605 36.4316 61.4661 36.0963C61.4806 36.0543 61.4985 36.0142 61.5116 35.9722L64.6478 34.1605C65.3867 33.7349 66.2676 33.6307 67.0851 33.8735C67.9026 34.1157 68.5849 34.6835 68.9713 35.4437C69.6632 37.0153 69.0347 38.8552 67.526 39.6754H67.5218Z" fill="#1F1F9C"/>
						<path d="M70.3826 15.8686C70.9345 16.4198 71.8286 16.4198 72.3805 15.8686L81.5642 6.68496C81.9312 6.33036 82.0788 5.80467 81.9491 5.31072C81.8201 4.81677 81.4345 4.43113 80.9405 4.30212C80.4466 4.17242 79.9209 4.32006 79.5663 4.68707L70.3826 13.8707C69.8314 14.4226 69.8314 15.3167 70.3826 15.8686Z" fill="#1F1F9C"/>
						<path d="M79.8372 15.7789L72.7729 20.0175C72.3307 20.2727 72.0602 20.7467 72.0658 21.2579C72.072 21.7684 72.3527 22.2361 72.8012 22.481C73.2496 22.726 73.7953 22.7101 74.2285 22.439L81.2929 18.2004C81.7351 17.9451 82.0055 17.4712 82 16.96C81.9938 16.4494 81.7123 15.9817 81.2646 15.7368C80.8162 15.4919 80.2705 15.5078 79.8372 15.7789Z" fill="#1F1F9C"/>
						<path d="M64.3926 15.4357C65.0907 15.7847 65.94 15.5012 66.2883 14.803L70.527 6.32583C70.876 5.62699 70.5925 4.77844 69.8936 4.42936C69.1955 4.08097 68.3469 4.36382 67.9979 5.06267L63.7593 13.5399C63.4102 14.238 63.6937 15.0873 64.3926 15.4357Z" fill="#1F1F9C"/>
						<path d="M31.229 11.8952C31.5436 12.601 32.3659 12.9231 33.0758 12.6182C33.7863 12.314 34.1202 11.4958 33.8257 10.7818L29.5871 0.891679C29.2725 0.185934 28.4501 -0.136239 27.7396 0.168687C27.0297 0.472923 26.6958 1.29112 26.9904 2.00514L31.229 11.8952Z" fill="#1F1F9C"/>
						<path d="M38.1792 12.751C38.9595 12.751 39.5921 12.1183 39.5921 11.3381V2.86087C39.5921 2.08062 38.9595 1.448 38.1792 1.448C37.399 1.448 36.7664 2.08062 36.7664 2.86087V11.3381C36.7664 12.1183 37.399 12.751 38.1792 12.751Z" fill="#1F1F9C"/>
						<path d="M25.7724 15.047C26.2601 15.6561 27.1501 15.7548 27.7592 15.2671C28.3684 14.78 28.4671 13.8901 27.9793 13.2809L22.3278 6.21655C21.8408 5.60739 20.9508 5.50874 20.3417 5.99648C19.7325 6.48353 19.6339 7.37348 20.1209 7.98264L25.7724 15.047Z" fill="#1F1F9C"/>
					</g>
					<defs>
						<clipPath id="clip0_559_15798">
							<rect width="82" height="82" fill="white"/>
						</clipPath>
					</defs>
				</svg>
				<h1 class="text-32px mb-15px">Kode Promo Sudah Di Ubah</h1>
				<p class="mb-20px">Kode Promo sudah berhasil di ubah anda bisa <br/>tekan tombol &ldquo;kembali&rdquo;</p>
				<button type="button" class="btn__agency btn--dark-blue btn-enter-login p-12px-30px-10px-30px" data-bs-dismiss="modal" aria-label="Close"><span class="position-relative order-50">Kembali</span></button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Warning -->
<div class="modal modal-agency width-full fade" id="ModalBack" tabindex="-1" style="display: none;" aria-labelledby="ModalBackLabel" aria-hidden="true">
	<div class="modal-max-w-430px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-agency-content modal-content">
			<div class="modal-agency-body agency-text-center p-80px-40px-0px-40px position-relative">
				<svg class="w-100px-h-100px m-0-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" fill="none">
					<path d="M50.0017 54.0462V33.8864M50.0017 68.9888V69.166M75.2014 85.956H24.802C17.9177 85.956 12.108 81.3551 10.2802 75.0604C9.49989 72.3733 10.4586 69.5745 11.9251 67.1915L37.1248 21.2417C43.0288 11.6476 56.9746 11.6476 62.8787 21.2418L88.0783 67.1915C89.5448 69.5745 90.5035 72.3733 89.7232 75.0603C87.8954 81.3551 82.0857 85.956 75.2014 85.956Z" stroke="#1F1F9C" stroke-width="8.33333" stroke-linecap="round" stroke-linejoin="round"/>
				</svg>
				<h1 class="text-32px mb-15px">Peringatan!</h1>
				<p class="mb-20px">Apakah anda yakin membatalkan proses ini?</p>
			</div>
			<div class="modal-footer flex-justify-between p-20px-30px mt-48px">
				<button class="btn-no text-14px agency-uppercase agency-self-center" data-bs-toggle="modal" data-bs-target="#ModalPromoCode" aria-label="Close">Tidak</button>
				<button type="button" class="btn__agency btn--dark-blue btn-close btn-prev-modal p-12px-25px-10px-25px" type="button" data-bs-dismiss="modal" aria-label="Close">
					<span class="position-relative order-50">
						Iya
						<svg class="display-inline-block position-relative top-min-1px left-6px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
							<path d="M5.22353 4L11.9059 4.09412M11.9059 4.09412L12 10.7765M11.9059 4.09412L4 12" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
						</svg>
					</span>
				</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Warning 2 -->
<div class="modal modal-agency width-full fade" id="ModalEditBackPromoCode" tabindex="-1" style="display: none;" aria-labelledby="ModalEditBackPromoCodeLabel" aria-hidden="true">
	<div class="modal-max-w-430px modal-agency-dialog modal-dialog modal-agency-dialog-centered">
		<div class="modal-agency-content">
			<div class="modal-agency-body agency-text-center p-80px-40px-0px-40px position-relative">
				<svg class="w-100px-h-100px m-0-auto-20px-auto" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" fill="none">
					<path d="M50.0017 54.0462V33.8864M50.0017 68.9888V69.166M75.2014 85.956H24.802C17.9177 85.956 12.108 81.3551 10.2802 75.0604C9.49989 72.3733 10.4586 69.5745 11.9251 67.1915L37.1248 21.2417C43.0288 11.6476 56.9746 11.6476 62.8787 21.2418L88.0783 67.1915C89.5448 69.5745 90.5035 72.3733 89.7232 75.0603C87.8954 81.3551 82.0857 85.956 75.2014 85.956Z" stroke="#1F1F9C" stroke-width="8.33333" stroke-linecap="round" stroke-linejoin="round"/>
				</svg>
				<h1 class="text-32px mb-15px">Peringatan!</h1>
				<p class="mb-20px">Apakah anda yakin membatalkan proses ini?</p>
			</div>
			<div class="modal-agency-footer flex-justify-between p-20px-30px mt-48px">
				<button class="btn-no text-14px agency-uppercase agency-self-center" data-bs-toggle="modal" data-bs-target="#ModalEditPromoCode" aria-label="Close">Tidak</button>
				<button type="button" class="btn__agency btn--dark-blue btn-close btn-prev-modal p-12px-25px-10px-25px" type="button" data-bs-dismiss="modal" aria-label="Close">
					<span class="position-relative order-50">
						Iya
						<svg class="display-inline-block position-relative top-min-1px left-6px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none">
							<path d="M5.22353 4L11.9059 4.09412M11.9059 4.09412L12 10.7765M11.9059 4.09412L4 12" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
						</svg>
					</span>
					
				</button>
			</div>
		</div>
	</div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script>
		window.loadAgentPromoCodeDataURL = "<%= loadAgentPromoCodeData %>";
		window.host = "<%= host %>";
		window.rToken = "<%= renderToken %>";
		window.apToken = "<%= apiRequestToken %>";
		window.eToken = "<%= encodeToken %>";
	</script>
	<script src="/o/agency-theme/js/multiform/multiform.js" type="text/javascript"></script>
	<script src="/o/agency-theme/js/datepicker/single-datepicker.js" type="text/javascript"></script>
	<script src="<%= request.getContextPath() %>/promocode/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>