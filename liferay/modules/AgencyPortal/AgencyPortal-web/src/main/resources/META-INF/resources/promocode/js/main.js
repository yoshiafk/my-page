var loadAgentPromoCodeDataURL = window.loadAgentPromoCodeDataURL;
var host = window.host;
var rToken = window.rToken;
var apToken = window.apToken;
var eToken = window.eToken;
var qPage = new URL(window.location.href).searchParams.get('page');
var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency body-white");

$(document).ready(function(){
	const ModalPromoCode = document.getElementById('ModalPromoCode')
	const ModalEditPromoCode = document.getElementById('ModalEditPromoCode')
	
	ModalPromoCode.addEventListener('shown.bs.modal', event => {
		$('#Product').select2({
			dropdownParent: '#product-wrapper',
			placeholder: "Pilih produk",
			width: '100%',
			minimumResultsForSearch: -1
		});
		
		$('#Terminologi-kodePromo').select2({
			dropdownParent: '#terminologi-wrapper',
			width: '100%',
			placeholder: "Pilih",
			minimumResultsForSearch: -1
		});
		
		$('#Status').select2({
			dropdownParent: '#status-wrapper',
			width: '100%',
			placeholder: "Pilih",
			minimumResultsForSearch: -1
		});
	})

	ModalEditPromoCode.addEventListener('shown.bs.modal', event => {
		$('#Product-edit').select2({
			dropdownParent: '#product-edit-wrapper',
			width: '100%',
			placeholder: "Pilih produk",
			minimumResultsForSearch: -1
		});
		
		$('#Terminologi-kodePromo-edit').select2({
			dropdownParent: '#terminologi-edit-wrapper',
			width: '100%',
			placeholder: "Pilih",
			minimumResultsForSearch: -1
		});
		
		$('#Status-edit').select2({
			dropdownParent: '#status-edit-wrapper',
			width: '100%',
			placeholder: "Pilih",
			minimumResultsForSearch: -1
		});
	})
	
	$('#periode-promo').on('focus', function(){
		$('#periode-promo-selesai').attr('disabled', false);
		$('#periode-promo-selesai').removeClass('disabled');
	});
	
	$('#periode-promo-edit').on('focus', function(){
		$('#periode-promo-selesai-edit').attr('disabled', false);
		$('#periode-promo-selesai-edit').removeClass('disabled');
	});
	
	$('#kode-promo').on('keyup', function() {
		if ($('#kode-promo').val() == '') {
			$('.btn-cancel-create-promo').removeClass('display-none');
			$('.btn-prev-promo-code').addClass('display-none');
		} else {
			$('.btn-cancel-create-promo').addClass('display-none');
			$('.btn-prev-promo-code').removeClass('display-none');
		}
	});
	
	$('#edit-kode-promo').on('keyup', function() {
		if ($('#edit-kode-promo').val() == '') {
			$('.btn-cancel-edit-promo').removeClass('display-none');
			$('.btn-prev-promo-code').addClass('display-none');
		} else {
			$('.btn-cancel-edit-promo').addClass('display-none');
			$('.btn-prev-promo-code').removeClass('display-none');
		}
	});
	
	$('.input-switch').on('click', function(){
		if ($(this).is(':checked')) {
			$('#maksimal-kupon').attr('disabled', true);
			$('#maksimal-kupon').addClass('disabled');
			$('#maksimal-kupon').val('Tidak dibatasi');
		} else {
			$('#maksimal-kupon').val('');
			$('#maksimal-kupon').attr('disabled', false);
			$('#maksimal-kupon').removeClass('disabled');
		}
	});
	
	$('.btn-promo-code').on('click', function() {
		let promoCode = $('#kode-promo').val();
		let maxCoupon = $('#maksimal-kupon').val();
		let product = $('#Product').val();
		let promoCodeTerm = $('#Terminologi-kodePromo').val();
		let startPromo = $('#periode-promo').val();
		let endPromo = $('#periode-promo-selesai').val();
		let discount = $('#discount').val();
		let isActive = $('#Status').val().toLowerCase() == "aktif" ? true : false;
		
		let jsonData = JSON.stringify({
	        promoCode: promoCode,
	        maxCoupon: maxCoupon,
	        product: product,
	        promoCodeTerm: promoCodeTerm,
	        startPromo: startPromo,
	        endPromo: endPromo,
	        discount: discount,
	        isActive: isActive
	    });
		
		if ($("form").valid()) {
			$.ajax({
	           	url: loadAgentPromoCodeDataURL,
				type: "POST",
	           	data: { rtoken: rToken, aptoken: apToken, etoken: eToken, data: jsonData },
	           	dataType: "json",
	           	timeout: 20000,
	           	beforeSend: function () {
	                $(this).addClass("btn--disabled");
	                $(this).css("pointer-events", "none");
	            },
	           	success: function (response) {
					apToken = response.token ? response.token : "";
					
					if (!response.status) {
						document.querySelector(".modal-agency-alert-body").innerHTML = response.message;
						
						$("#ModalPromoCode").modal('hide');
			            
			            $("#ModalFailedPromoCode").modal('show');
						
						return;
					}
					
					$("#ModalPromoCode").modal('hide');
					
					$("#ModalSuccessPromoCode").modal('show');
					
					qPage = !qPage ? 1 : qPage;
					page(qPage);
	           	},
	           	complete: function () {
	            	$(this).removeClass("btn--disabled");
	            	$(this).css("pointer-events", "auto");
	            }
	       	});
		}
	});
	
	$('.btn-input-promo-code').on('click', function(e) {
		e.preventDefault();
		
		$('#formPromoCode input[type="text"], #formPromoCode input[type="number"]').val('');
		$('#coupon').prop('checked', true);
		$('#maksimal-kupon').attr('disabled', true);
		$('#maksimal-kupon').addClass('disabled');
		$('#periode-promo-selesai').attr('disabled', true);
		$('#periode-promo-selesai').addClass('disabled');
		$("#Product").val(null).trigger("change");
		$("#Terminologi-kodePromo").val(null).trigger("change");
		$("#Status").val(null).trigger("change");
		if ($('.btn-cancel-create-promo').hasClass('display-none')) $('.btn-cancel-create-promo').removeClass('display-none');
		if (!$('.btn-prev-promo-code').hasClass('display-none')) $('.btn-prev-promo-code').addClass('display-none');
		
		$("#ModalPromoCode").modal('show');
	});
	
	$(document).on('click', '.btn-view', function() {
		const category = "view";
		const target = $(this).data('target');
		
		$('#formEditPromoCode input[type="text"], #formEditPromoCode input[type="number"]').val('');
		$('#periode-promo-selesai-edit').attr('disabled', true);
		$('#periode-promo-selesai-edit').addClass('disabled');
		$("#Product-edit").val(null).trigger("change");
		$("#Terminologi-kodePromo-edit").val(null).trigger("change");
		$("#Status-edit").val(null).trigger("change");
		$('.btn-cancel-edit-promo').addClass('display-none');
		$('.btn-prev-promo-code').removeClass('display-none');
		
		$.ajax({
			url: loadAgentPromoCodeDataURL,
			type: "post",
			data: { category: category, target: target, rtoken: rToken, aptoken: apToken },
			timeout: 20000,
			dataType: "json",
			success: function (response) {
				if (response.status) {
					$('#ModalEditPromoCode').modal('show');
					
					$('input[name="promo-code-target"]').val(target);
					$('#edit-kode-promo').val(response.data.promoCode);
					$('#edit-maksimal-kupon').val(response.data.limit);
					$('#Product-edit').val(response.data.product);
					$('#Terminologi-kodePromo-edit').val(response.data.promoCodeTerms);
					$('#periode-promo-edit').val(response.data.startDate);
					$('#periode-promo-selesai-edit').val(response.data.endDate);
					$('#discount-edit').val(response.data.discount);
					$('#Status-edit').val(response.data.status);
					
					apToken = response.token ? response.token : "";
				}
			}
		});
	});
	
	$('.btn-edit-promo-code').on('click', function() {
		let target = $('input[name="promo-code-target"]').val();
		let promoCode = $('#edit-kode-promo').val();
		let maxCoupon = $('#edit-maksimal-kupon').val();
		let product = $('#Product-edit').val();
		let promoCodeTerm = $('#Terminologi-kodePromo-edit').val();
		let startPromo = $('#periode-promo-edit').val();
		let endPromo = $('#periode-promo-selesai-edit').val();
		let discount = $('#discount-edit').val();
		let isActive = $('#Status-edit').val().toLowerCase() == "aktif" ? true : false;
		
		let jsonData = JSON.stringify({
	        promoCode: promoCode,
	        maxCoupon: maxCoupon,
	        product: product,
	        promoCodeTerm: promoCodeTerm,
	        startPromo: startPromo,
	        endPromo: endPromo,
	        discount: discount,
	        isActive: isActive
	    });
		
		if ($("form").valid()) {
			$.ajax({
	           	url: loadAgentPromoCodeDataURL,
				type: "POST",
	           	data: { target: target, rtoken: rToken, aptoken: apToken, etoken: eToken, data: jsonData },
	           	dataType: "json",
	           	timeout: 20000,
	           	beforeSend: function () {
	                $(this).addClass("btn--disabled");
	                $(this).css("pointer-events", "none");
	            },
	           	success: function (response) {
					apToken = response.token ? response.token : "";
					
					if (!response.status) {
						document.querySelector(".modal-agency-alert-body").innerHTML = response.message;
						
						$("#ModalEditPromoCode").modal('hide');
			            
			            $("#ModalFailedPromoCode").modal('show');
						
						return;
					}
					
					$("#ModalEditPromoCode").modal('hide');
					
					$("#ModalSuccessEditPromoCode").modal('show');
					
					qPage = !qPage ? 1 : qPage;
					page(qPage);
	           	},
	           	complete: function () {
	            	$(this).removeClass("btn--disabled");
	            	$(this).css("pointer-events", "auto");
	            }
	       	});
		}
	});
	
	$(document).on('input', '#formPromoCode input#kode-promo, #formPromoCode input#maksimal-kupon, #formEditPromoCode input#edit-kode-promo, #formEditPromoCode input#edit-maksimal-kupon', function(e) {
		let fieldName = e.target.name;
		let fieldType = 'textNum';
		
		if (fieldName.includes('maksimal-kupon')) {
	    	fieldType = 'num';
		}

	    validateInput(e, fieldType);
	});
});

function page(param) {
	let data = { page: parseInt(param) || 0, rtoken: rToken, aptoken: apToken }
	
	$.ajax({
		url: loadAgentPromoCodeDataURL,
		type: "POST",
		data: data,
		timeout: 20000,
		dataType: "json",
		success: function (response) {
			if (response.status) {
				apToken = response.token ? response.token : "";
				
				let content, paginationContent
				let table = $('.table-wrapper').find('table');
				table.find('tbody tr').remove();
				
				let pagination = $('.pagination').empty();
				let currentPage = response.data.paging.page || 1;
				
				if (response.data.items.length > 0) {
					for (let i = 0; i < response.data.items.length; i++) {
						if (response.data.items[i]) {
							let active = response.data.items[i].active == 1 ? 'Aktif' : 'NonAktif'; 
							let button = `<a href="javascript:void(0)" class="btn__agency btn--dark-blue display-block agency-text-center btn-view" data-target="${ response.data.items[i].target }">
											 <span class="position-relative order-10 flex-justify-center">
												 <span class="display-inline-block">Ubah</span> 
												 <svg class="display-inline-block ml-4px" xmlns="http://www.w3.org/2000/svg" width="17" height="16" viewBox="0 0 17 16" fill="none">
													 <path d="M9.70001 13.0346H13.7M3.30005 13.0346L6.21071 12.4481C6.36522 12.417 6.5071 12.3409 6.61853 12.2294L13.1343 5.71007C13.4467 5.3975 13.4465 4.89084 13.1338 4.57853L11.7536 3.19981C11.441 2.88764 10.9346 2.88785 10.6224 3.20029L4.10589 9.72032C3.99468 9.83159 3.91875 9.97318 3.88758 10.1274L3.30005 13.0346Z" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
												 </svg>
											 </span>
										 </a>`;
							
							content += `<tr>
											<td>${ (currentPage - 1) * response.data.paging.itemPerPage + i + 1 }</td>
											<td>${ response.data.items[i].promoCode }</td>
											<td>${ response.data.items[i].productName }</td>
											<td>${ response.data.items[i].discount }</td>
											<td>${ response.data.items[i].limit }</td>
											<td>${ response.data.items[i].formattedStartDate }</td>
											<td>${ response.data.items[i].formattedEndDate }</td>
											<td>${ active }</td>
											<td>
												${ button }
											</td>
										</tr>`;
						}
					}
				}
				
				let previousPage = Math.max(1, response.data.paging.page - 1);
			    let nextPage = Math.min(response.data.paging.totalPage, response.data.paging.page + 1);
				let prev = response.data.paging.page > 1 ?
						   `<a class="prev" aria-label="Previous" href="javascript:void(0)" onclick="page(${previousPage})">Sebelumnya</a>
						    <a class="prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(${previousPage})"><i class="fas fa-chevron-left"></i></a>` :
						   `<a class="disabled prev" aria-label="Previous" href="javascript:void(0)" onclick="page(${previousPage})">Sebelumnya</a>
						    <a class="disabled prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(${previousPage})"><i class="fas fa-chevron-left"></i></a>`;
				let firstEllipsis = response.data.paging.page > 4 && response.data.paging.totalPage > 5 ?
						       		`<li><a href="javascript:void(0)" onclick="page(1)">1</a></li>
									 <li><a class="disabled">...</a></li>` : "";
				let lastEllipsis = response.data.paging.page < response.data.paging.totalPage - 4 ?
							   	   `<li><a class="disabled">...</a></li>
									<li><a href="javascript:void(0)" onclick="page(${response.data.paging.totalPage})">${response.data.paging.totalPage}</a></li>` : "";
				let iteratorUp = response.data.paging.page == 1 ? 4 : response.data.paging.page == 2 ? 3 : response.data.paging.page == 3 ? 2 : 1;
				let iteratorDown = response.data.paging.page == (response.data.paging.totalPage - 4) ? 0 : response.data.paging.page == (response.data.paging.totalPage - 3) ? 1 : response.data.paging.page == (response.data.paging.totalPage - 2) ? 2 : response.data.paging.page == (response.data.paging.totalPage - 1) ? 3 : 4;
				let next = response.data.paging.page < response.data.paging.totalPage ?
						   `<a class="next" aria-label="Next" href="javascript:void(0)" onclick="page(${nextPage})">Selanjutnya</a>
							<a class="next-mobile" aria-label="Next" href="javascript:void(0)" onclick="page(${nextPage})"><i class="fas fa-chevron-right"></i></a>` :
						   `<a class="disabled prev" aria-label="Previous" href="javascript:void(0)" onclick="page(${nextPage})">Selanjutnya</a>
						    <a class="disabled prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(${nextPage})"><i class="fas fa-chevron-left"></i></a>`;
				
				if (response.data.items.length > 0) {
					paginationContent = `<li>
											${prev}
									  	 </li>
									  	 ${firstEllipsis}`;
			        
					if (response.data.paging.page <= 4) {
						for (let i = Math.max(1, response.data.paging.page - 4); i <= Math.min(response.data.paging.totalPage, response.data.paging.page + iteratorUp); i++) {
							let active = i == response.data.paging.page ? 'class="active" aria-current="page"' : "";
							paginationContent += `<li><a ${active} href="javascript:void(0)" onclick="page(${i})">${i}</a></li>`; 
						}
					} else if (response.data.paging.page >= response.data.paging.totalPage - 4) {
						for (let i = Math.max(1, response.data.paging.page - iteratorDown); i <= response.data.paging.totalPage; i++) {
							let active = i == response.data.paging.page ? 'class="active" aria-current="page"' : "";
							paginationContent += `<li><a ${active} href="javascript:void(0)" onclick="page(${i})">${i}</a></li>`; 
						}
					} else {
						for (let i = Math.max(1, response.data.paging.page - 1); i <= Math.min(response.data.paging.totalPage, response.data.paging.page + 1); i++) {
							let active = i == response.data.paging.page ? 'class="active" aria-current="page"' : "";
							paginationContent += `<li><a ${active} href="javascript:void(0)" onclick="page(${i})">${i}</a></li>`; 
						}
					}
			        
					paginationContent += `${lastEllipsis}
										  <li>
										     ${next}
										  </li>`;

					$(table[0]).find('tbody').append(content);
					pagination.html(paginationContent);
				}
			}
		}
	});
}

function validateInput(e, type) {
    let input = e.target;
    let value = input.value;
    
    const patterns = {
        num:   /[^0-9]/g,           // Allow only numbers
        textNum:  /[^A-Za-z0-9]/g  // Allow letters, numbers and spaces
    };

    // Remove invalid characters based on type
    if (patterns[type]) {
    	input.value = value.replace(patterns[type], '');
    }
}

function closeModalFailedPromoCode() {
	$("#ModalFailedPromoCode").modal('hide');
}