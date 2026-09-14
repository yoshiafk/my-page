var loadAgentSalesToolsDataURL = window.loadAgentSalesToolsDataURL;
var rToken = window.rToken;
var apToken = window.apToken;
var qPage = new URL(window.location.href).searchParams.get('page');
var qTitle = new URL(window.location.href).searchParams.get('title');
var qCategory = new URL(window.location.href).searchParams.get('category');
var html = $("html");
var body = $("body");
var title, category, current_page, modal_height

html.addClass("html__agency");
body.addClass("body__agency body-white");

function Play() {
	var $this = $('video');
		$thisBtn = $('.play');

	$('#video')[0].play();
	$thisBtn.addClass('display-none');
	$this.prop("controls", true); 
}

function Pause() {
	var $this = $('video');
		$thisBtn = $('.play');

	$('#video')[0].pause();
	$thisBtn.removeClass('display-none');
	$this.prop("controls", false);
}

$(document).ready(function(){
	$('#Cat-salesTools').select2({
		width: '100%',
		placeholder: "Lihat Semua",
		minimumResultsForSearch: -1,
	});

	$('#Cat-salesTools').on('change', function() {
		category = $(this).val();
		qPage = !qPage ? 1 : qPage;
		page(qPage);
	});

	if (qCategory) {
		$('#Cat-salesTools').val(qCategory).trigger("change");
	}
	
	$('.btn-search').on('click', function() {
		title = $('#search').val();
		qPage = !qPage ? 1 : qPage;
		page(qPage);
	});
	
	$('#search').on('keyup', function(event) {
		if (event.keyCode === 13) {
	        title = $('#search').val();
			qPage = !qPage ? 1 : qPage;
			page(qPage);
	    }
	});
	
	if (qTitle) {
		$('#search').val(qTitle);
		$('.btn-search').click();
	}

	$(document).on('click', '.btn-view', function() {
		$('.modal-agency-content__left, .modal-agency-content__right, .modal-agency-body').html('');
		
		const category = "view";
		const target = $(this).data('target');
		
		$.ajax({
			url: loadAgentSalesToolsDataURL,
			type: "post",
			data: { category: category, target: target, rtoken: rToken, aptoken: apToken },
			timeout: 20000,
			dataType: "json",
			success: function (response) {
				if (response.status) {
					$('#ModalSalesTools').modal('show');
					let color = response.data.item.category.toLowerCase() == 'pengetahuan produk' ? 'ocean-200' : 'sienna'; 
					
					$('.modal-agency-content__left').html(`
						<div class="label-event agency-normalcase letter-spacing-0px display--inline-block ${ color }">
							<span class="text-12px">${ response.data.item.category }</span>
						</div>
						<p class="text-14px agency-uppercase letter-spacing-1px">${ response.data.item.dateFormat }</p>
						<h1>${ response.data.item.title }</h1>`
					);
					
					$('.modal-agency-content__right').html(`
						<a href="javascript:void(0)" class="btn__agency btn--dark-blue text-12px btn-download" data-target="${ response.data.item.target }">
							<span class="position-relative order-10">Unduh</span>
							<svg class="position-relative order-10 display-inline-block vertical-align-min-2px " xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 17 16" fill="none">
								<path d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
							</svg>
						</a>`
					);
					
					$('.modal-agency-body').html(`
						<div class="video-wrapper mb-24px position-relative">
							<video id="video" playsinline>
								<source src="${ response.data.item.filePath }" type="video/mp4" />
							</video>
							<span class="play" onclick="Play()">
								<img src="/o/agency-theme/images/icon_play.png">
							</span>
						</div>
						<div class="description-wrapper">${ response.data.item.description }</div>`
					);
					
					apToken = response.token ? response.token : "";
				}
			}
		});
	});
	
	$(document).on('click', '.btn-download', function() {
		const category = "download";
		const target = $(this).data('target');
        const url = loadAgentSalesToolsDataURL + "&category=" + category + "&target=" + target + "&rtoken=" + rToken + "&aptoken=" + apToken;
        let date = new Date();
        const month = date.getMonth() + 1;
        const year = date.getFullYear();

        $.ajax({
            url: url,
            method: 'GET',
            xhrFields: {
                responseType: 'blob'
            },
            beforeSend: function () {
                $(this).addClass("btn--disabled");
                $(this).css("pointer-events", "none");
            },
            success: function (response, textStatus, xhrObj) {
            	let contentDisposition = xhrObj.getResponseHeader('Content-Disposition');
            	const filename = contentDisposition.split(';')[1].split('=')[1].trim();
            	
                download(response, filename);
                
                apToken = xhrObj.getResponseHeader("Aptoken");
            },
            complete: function () {
            	$(this).removeClass("btn--disabled");
            	$(this).css("pointer-events", "auto");
            }
        });
    });
	
	$('.link-dashboard').click(function(e) {
		e.preventDefault();
		parent.location.href = this.href;
	});
});
	
function page(param) {
	let data = { page: parseInt(param) || 0, rtoken: rToken, aptoken: apToken }
	
	if (title) {
	    data.title = title;
	}
	
	if (category) {
	    data.category = category;
	}
	
	$.ajax({
		url: loadAgentSalesToolsDataURL,
		type: "POST",
		data: data,
		timeout: 20000,
		dataType: "json",
		success: function (response) {
			if (response.status) {
				apToken = response.token ? response.token : "";
				
				let firstContent, secondContent, notfound, paginationContent
				let table = $('.table-wrapper').find('table');
				table.find('tbody tr').remove();
				
				let pagination = $('.pagination').empty();
				
				if (response.data.items.length > 0) {
					for (let i = 0; i < Math.min(5, response.data.items.length); i++) {
						if (response.data.items[i]) {
							let icon = response.data.items[i].extension == 'pdf' ? 'file-pdf' : response.data.items[i].extension == 'mp4' ? 'file-mp4' : '';
							let color = response.data.items[i].category.toLowerCase() == 'pengetahuan produk' ? 'ocean-200' : 'sienna';
							let button = response.data.items[i].extension == 'pdf' ?
									`<a href="javascript:void(0)" class="btn__agency btn--dark-blue display-block text-12px agency-text-center btn-download" data-target="${ response.data.items[i].target }">
										<span class="position-relative order-10">Unduh</span>
										<svg class="position-relative order-10 display-inline-block vertical-align-min-2px" xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 17 16" fill="none">
											<path d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
										</svg>
									</a>` : 
									response.data.items[i].extension == 'mp4' ?
									`<a href="javascript:void(0)" class="btn__agency btn--dark-blue display-block text-12px agency-text-center btn-view" data-target="${ response.data.items[i].target }">
										<span class="position-relative order-10">Tonton <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
									</a>` : '';
							
							firstContent += `<tr class="tr-filter">
												<td><i class="icon ${icon}"></i></td>
												<td>
													<div class="td-inner">
														<div class="label-event agency-normalcase letter-spacing-0px mb-6px ${color}">
															<span class="text-12px">${ response.data.items[i].category }</span>
														</div>
														<p class="agency-normalcase letter-spacing-0px text-16px">${ response.data.items[i].title }</p>
													</div>
												</td>
												<td><p class="date text-14px agency-uppercase letter-spacing-1px">${ response.data.items[i].dateFormat }</p></td>
												<td>
													${ button }
												</td>
											</tr>`;
						}
					}
				} else {
					notfound = `<div class="sales-tools-type not-found" id="Table">
									<div class="col-span-12-12 notfound agency-text-center my-80px">
										<svg class="display-block m-0px-auto-30px-auto" xmlns="http://www.w3.org/2000/svg" width="132" height="132" viewBox="0 0 132 132" fill="none">
											<g clip-path="url(#clip0_460_13723)">
												<path d="M88.7319 0C64.874 0 45.464 19.41 45.464 43.2679C45.464 54.5029 49.7693 64.7502 56.8153 72.45L48.8285 80.4368L48.7344 80.3427C47.5887 79.1969 46.065 78.5655 44.4443 78.5655C42.8237 78.5655 41.3002 79.1966 40.1542 80.3427L2.37839 118.119C-0.792797 121.29 -0.792797 126.45 2.37839 129.622C3.96398 131.207 6.04691 132 8.12984 132C10.2128 132 12.2957 131.207 13.8813 129.622L51.6571 91.8458C52.8031 90.6998 53.4342 89.1763 53.4342 87.5557C53.4342 85.935 52.8031 84.4116 51.6571 83.2656L51.563 83.1715L59.5497 75.1847C67.2495 82.2307 77.4971 86.536 88.7319 86.536C112.59 86.536 132 67.126 132 43.2679C132 19.41 112.59 0 88.7319 0ZM11.1469 126.887C9.4834 128.55 6.77654 128.55 5.11309 126.887C3.44963 125.223 3.44963 122.517 5.11309 120.853L36.8438 89.1225L42.8775 95.1562L11.1469 126.887ZM48.9226 89.1111L45.612 92.4218L39.5782 86.388L42.8889 83.0774C43.3042 82.662 43.8567 82.4331 44.4443 82.4331C45.0319 82.4331 45.5844 82.662 45.9997 83.0774L48.9224 86.0003C49.338 86.4159 49.5667 86.9681 49.5667 87.5557C49.5669 88.1433 49.3383 88.6955 48.9226 89.1111ZM88.7319 82.669C67.0061 82.669 49.3313 64.9939 49.3313 43.2681C49.3313 21.5424 67.0064 3.8673 88.7319 3.8673C110.457 3.8673 128.133 21.5424 128.133 43.2679C128.133 64.9936 110.458 82.669 88.7319 82.669Z" fill="#1F1F9C"/>
												<path d="M113.482 18.5184C101.036 6.07314 81.1767 4.83534 67.2874 15.6385C66.4443 16.2942 66.2925 17.509 66.9484 18.3518C67.6038 19.1949 68.8186 19.3467 69.6617 18.6909C82.0154 9.08216 99.6781 10.1838 110.747 21.2528C121.816 32.3221 122.918 49.9848 113.309 62.338C112.653 63.1811 112.805 64.3959 113.648 65.0515C114.001 65.3259 114.419 65.4589 114.834 65.4589C115.41 65.4589 115.98 65.2024 116.361 64.7122C127.165 50.823 125.927 30.9639 113.482 18.5184Z" fill="#1F1F9C"/>
												<path d="M107.803 67.8445C102.172 72.2244 95.4391 74.379 88.7293 74.3787C80.7186 74.3784 72.7408 71.3065 66.7174 65.2828C55.6484 54.2138 54.547 36.5508 64.1554 24.1976C64.8111 23.3546 64.6592 22.1397 63.8164 21.4841C62.9731 20.8284 61.7585 20.9803 61.1031 21.8231C50.2994 35.7129 51.5375 55.572 63.983 68.0172C70.7562 74.7907 79.7236 78.2442 88.7316 78.2439C96.2747 78.2437 103.847 75.8209 110.177 70.8971C111.02 70.2415 111.172 69.0266 110.516 68.1835C109.86 67.341 108.645 67.1889 107.803 67.8445Z" fill="#1F1F9C"/>
												<path d="M72.8976 42.5685C73.2751 42.9462 73.7701 43.135 74.2648 43.135C74.7596 43.135 75.2546 42.9462 75.632 42.5685L78.3982 39.8024L81.1643 42.5685C81.5418 42.9462 82.0368 43.135 82.5316 43.135C83.0263 43.135 83.5213 42.9462 83.8988 42.5685C84.6539 41.8134 84.6539 40.5892 83.8988 39.8341L81.1326 37.0679L83.8988 34.3018C84.6539 33.5466 84.6539 32.3225 83.8988 31.5673C83.1436 30.8122 81.9192 30.8122 81.1643 31.5673L78.3982 34.3335L75.632 31.5673C74.8769 30.8122 73.6525 30.8122 72.8976 31.5673C72.1424 32.3225 72.1424 33.5469 72.8976 34.3018L75.6638 37.0679L72.8976 39.8341C72.1424 40.5892 72.1424 41.8136 72.8976 42.5685Z" fill="#1F1F9C"/>
												<path d="M93.5649 42.5685C93.9424 42.9462 94.4374 43.135 94.9322 43.135C95.4269 43.135 95.9219 42.9462 96.2994 42.5685L99.0655 39.8024L101.832 42.5685C102.209 42.9462 102.704 43.135 103.199 43.135C103.694 43.135 104.189 42.9462 104.566 42.5685C105.321 41.8134 105.321 40.589 104.566 39.8341L101.8 37.0679L104.566 34.3018C105.321 33.5466 105.321 32.3225 104.566 31.5673C103.811 30.8122 102.587 30.8122 101.832 31.5673L99.0655 34.3335L96.2994 31.5673C95.5442 30.8122 94.3198 30.8122 93.5649 31.5673C92.8098 32.3225 92.8098 33.5469 93.5649 34.3018L96.3311 37.0679L93.5649 39.8341C92.8095 40.5892 92.8095 41.8136 93.5649 42.5685Z" fill="#1F1F9C"/>
												<path d="M77.0299 56.369C76.2755 57.125 76.2766 58.3493 77.0322 59.1037C77.4097 59.4804 77.9039 59.6689 78.3984 59.6689C78.8937 59.6689 79.3892 59.4796 79.7669 59.1014C82.0291 56.8352 85.2967 55.5355 88.7319 55.5355C92.1671 55.5355 95.4349 56.8352 97.697 59.1014C98.4514 59.8573 99.6758 59.8584 100.431 59.1037C101.187 58.3493 101.188 57.125 100.434 56.3693C97.4516 53.3817 93.1862 51.6685 88.7316 51.6685C84.2775 51.6679 80.0121 53.3814 77.0299 56.369Z" fill="#1F1F9C"/>
											</g>
											<defs>
											<clipPath id="clip0_460_13723">
												<rect width="132" height="132" fill="white"/>
											</clipPath>
											</defs>
										</svg>
										<h2>Pencarian Tidak Ditemukan</h2>
										<p class="text-16px">Silakan gunakan kata kunci lain atau refresh halaman ini</p>
									</div>
								</div>`;
				}
				
				if (response.data.items.length > 4) {
					for (let i = 5; i < Math.min(10, response.data.items.length); i++) {
						if (response.data.items[i]) {
							let icon = response.data.items[i].extension == 'pdf' ? 'file-pdf' : response.data.items[i].extension == 'mp4' ? 'file-mp4' : '';
							let color = response.data.items[i].category.toLowerCase() == 'pengetahuan produk' ? 'ocean-200' : 'sienna';
							let button = response.data.items[i].extension == 'pdf' ?
									`<a href="javascript:void(0)" class="btn__agency btn--dark-blue display-block text-12px agency-text-center btn-download" data-target="${ response.data.items[i].target }">
										<span class="position-relative order-10">Unduh</span>
										<svg class="position-relative order-10 display-inline-block vertical-align-min-2px" xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 17 16" fill="none">
											<path d="M3.31006 13.615C3.57261 13.8798 3.92871 14.0285 4.30001 14.0285H12.7C13.0713 14.0285 13.4274 13.8798 13.69 13.615M8.50079 1.9707V9.9707M8.50079 9.9707L11.7008 6.91394M8.50079 9.9707L5.30079 6.91394" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
										</svg>
									</a>` : 
									response.data.items[i].extension == 'mp4' ? 
									`<a href="javascript:void(0)" class="btn__agency btn--dark-blue display-block text-12px agency-text-center btn-view" data-target="${ response.data.items[i].target }">
										<span class="position-relative order-10">Tonton <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
									</a>` : '';
							
							secondContent += `<tr class="tr-filter">
												 <td><i class="icon ${icon}"></i></td>
												 <td>
													 <div class="td-inner">
														 <div class="label-event agency-normalcase letter-spacing-0px mb-6px ${color}">
															 <span class="text-12px">${ response.data.items[i].category }</span>
														 </div>
														 <p class="agency-normalcase letter-spacing-0px text-16px">${ response.data.items[i].title }</p>
													 </div>
												 </td>
												 <td><p class="date text-14px agency-uppercase letter-spacing-1px">${ response.data.items[i].dateFormat }</p></td>
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
				}
				
				if (response.data.items.length > 0) {
					if ($('#Table').hasClass('not-found')) {
						$('#Table').replaceWith(`<div class="sales-tools-type" id="Table">
													<div class="sales-tools-type__left">
														<div class="table-wrapper">
															<table class="table table__agency">
																<thead>
																	<td>Tipe</td>
																	<td>Nama</td>
																	<td>Tanggal</td>
																	<td>Aksi</td>
																</thead>
																<tbody></tbody>
															</table>
														</div>
													</div>
													<div class="sales-tools-type__right">
														<div class="table-wrapper">
															<table class="table table__agency">
																<thead>
																	<td>Tipe</td>
																	<td>Nama</td>
																	<td>Tanggal</td>
																	<td>Aksi</td>
																</thead>
																<tbody></tbody>
															</table>
														</div>
													</div>
												</div>`);
						
						$('#Table').find('tbody').eq(0).append(firstContent);
						$('#Table').find('tbody').eq(1).append(secondContent);
						pagination.html(paginationContent);
						return;
					}
					
					$(table[0]).find('tbody').append(firstContent);
					$(table[1]).find('tbody').append(secondContent);
					pagination.html(paginationContent);
				} else {
					$('#Table').replaceWith(notfound);
				}
				
				sendHeightToParent();
			}
		}
	});
}

function download(object, name) {
    var a = document.createElement('a');
    var url = URL.createObjectURL(object);
    a.href = url;
    a.download = name;
    a.click();
}

//Send the height of the content to the parent document
function sendHeightToParent() {
	var height = document.getElementById('content').scrollHeight;
	window.parent.postMessage({ height: height }, '*');
}

//Call sendHeightToParent when the content of the iframe changes
document.addEventListener('DOMContentLoaded', function() {
	sendHeightToParent();
});

window.addEventListener('resize', function() {
	sendHeightToParent();
});