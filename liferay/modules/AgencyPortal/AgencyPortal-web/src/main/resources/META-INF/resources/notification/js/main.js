var loadAgentNotificationDataURL = window.loadAgentNotificationDataURL;
var host = window.host;
var rToken = window.rToken;
var apToken = window.apToken;
var qPage = new URL(window.location.href).searchParams.get('page');
var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency body-white");

var stickyHeaderTop = $('#v-pills-tab').offset().top;
$(window).scroll(function(){
	if ($(window).scrollTop() > stickyHeaderTop) {
		$('#v-pills-tab').addClass('is-active');
	    $('#sticky').addClass('display-none');
	} else {
	    $('#v-pills-tab').removeClass('is-active');
	    $('#sticky').removeClass('display-block');
	}
});

$(document).ready(function() {
	$('#v-pills-Notification-tab, #v-pills-Message-tab').on('click', function() {
		qPage = !qPage ? 1 : qPage;
		page(qPage);
		
        sendHeightToParent();
    });
	
	$(document).on('click', '.link-notification', function(e) {
    	e.preventDefault();
		const elem = this;
		const target = $(this).data('target');
		const cardNotif = $(this).closest('.card-notif');
		
		if (!cardNotif.hasClass('unread')) {
			parent.location.href = elem.href;
			
			return;
		}
			
		$.ajax({
			url: loadAgentNotificationDataURL,
			type: "post",
			data: { target: target, rtoken: rToken, aptoken: apToken },
			timeout: 20000,
			dataType: "json",
			success: function (response) {
				if (!response.status) {
					parent.location.href = `${host}/dashboard/notification`;
					
					return;
				}
				
				apToken = response.token ? response.token : "";
				
		        parent.location.href = elem.href;
			}
		});
    });
	
	$('.link-dashboard').click(function(e) {
		e.preventDefault();
		parent.location.href = this.href;
	});
});

function page(param) {
	const category = $('#v-pills-tab .nav-link.active span').text().toLowerCase();
	let data = { category: category, page: parseInt(param) || 0, rtoken: rToken, aptoken: apToken }
    
    $.ajax({
		url: loadAgentNotificationDataURL,
		type: "POST",
		data: data,
		timeout: 20000,
		dataType: "json",
		success: function (response) {
			if (response.status) {
				apToken = response.token ? response.token : "";
				
				let content, paginationContent
				let vpills = category == 'notifikasi' ? $('#v-pills-Notification').empty() : $('#v-pills-Message').empty();
				let currentPage = response.data.paging.page || 1;
				
				if (response.data.items.length > 0) {
					for (let i = 0; i < response.data.items.length; i++) {
						if (response.data.items[i]) {
							var url = response.data.items[i].reference ? `${host}/dashboard/event-detail/${response.data.items[i].reference}` : response.data.items[i].link;
							var unread = response.data.items[i].isRead ? "" : "unread";
							var description = response.data.items[i].description.length >= 250 ? response.data.items[i].description.substring(0, 250) : response.data.items[i].description;
							
							content = `<div class="card-notif ${unread}">
										<a href="${url}" class="link-notification" data-target="${response.data.items[i].target}">
											<div class="card-header-notif">
												<h5>${response.data.items[i].title}</h5>
												<ul>
													<li>
														<svg class="icon-calendar" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none">
															<path d="M7.25 17.5534V17.4688M12.3125 17.5534V17.4688M12.3125 12.9688V12.8842M16.8125 12.9688V12.8842M3.875 8.46875H19.625M5.91071 2V3.68771M17.375 2V3.6875M17.375 3.6875H6.125C4.26104 3.6875 2.75 5.19854 2.75 7.0625V18.3126C2.75 20.1766 4.26104 21.6876 6.125 21.6876H17.375C19.239 21.6876 20.75 20.1766 20.75 18.3126L20.75 7.0625C20.75 5.19854 19.239 3.6875 17.375 3.6875Z" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
														</svg>
														<span>${response.data.items[i].date}</span>
													</li>`;
							
//							if (response.data.items[i].location) {
//								content += `<li>
//												<svg class="icon-marker" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 23 23" fill="none">
//													<path d="M11.0266 16.5396V9.1887V3.67554L15.9885 7.53475L11.5779 10.8426M7.71872 13.1313C4.486 13.6765 2.20557 14.9971 2.20557 16.5396C2.20557 18.5695 6.15489 20.215 11.0266 20.215C15.8984 20.215 19.8477 18.5695 19.8477 16.5396C19.8477 14.9971 17.5672 13.6765 14.3345 13.1313" stroke-width="1.83772" stroke-linecap="round" stroke-linejoin="round"></path>
//												</svg>
//												<span>${response.data.items[i].location}</span>
//											</li></ul></div>`;
//							}
							
							content += `<div class="card-body-notif">
											<p class="agency-line-clamp-2">${description}</p>
										</div></a></div>`;

							$(vpills).append(content);
						}
					}
				}
				
				let previousPage = Math.max(1, response.data.paging.page - 1);
			    let nextPage = Math.min(response.data.paging.totalPage, response.data.paging.page + 1);
				let prev = response.data.paging.page > 1 ?
						   `<a class="prev" aria-label="Previous" href="javascript:void(0)" onclick="page(${previousPage})">Sebelumnya</a>
						    <a class="prev-mobile" aria-label="Previous" href="javascript:void(0)" onclick="page(${previousPage})"><i class="fas fa-chevron-left"></i></a>` :
						   `<a class="disabled prev" aria-label="Previous" href="javascript:void(0)" onclick="page(${previousPage}">Sebelumnya</a>
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
					paginationContent = `<div class="agency-text-center">
											<nav aria-label="Page navigation">
												<ul class="pagination">
													<li>
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
										  </li></ul></nav></div>`;
					
					vpills.append(paginationContent);
				}
				
				sendHeightToParent();
			}
		}
	});
}

//add height frame
function sendHeightToParent() {
	setTimeout(function() {
		var contentElement = document.getElementById('content');
		if (contentElement) {
			var height = contentElement.scrollHeight;
			//console.log('Sending height:', height);
			window.parent.postMessage({ height: height }, '*');
		} else {
			console.error('Element with id "content" not found');
		}
	}, 100); // Delay 100ms
}

// Call sendHeightToParent when the content of the iframe changes
document.addEventListener('DOMContentLoaded', function() {
    sendHeightToParent();
});

window.addEventListener('resize', function() {
    sendHeightToParent();
});