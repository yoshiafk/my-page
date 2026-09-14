var resourceURL = window.resourceURL;
var host = window.host;
var rToken = window.rToken;
var apToken = window.apToken;

$(document).ready(function() {
	$('#title').on('keyup', function() {
		if ($('#title').val() == '') {
			$('.btn-cancel-create-reminder').removeClass('display-none');
			$('.btn-prev-create-reminder').addClass('display-none');
		} else {
			$('.btn-cancel-create-reminder').addClass('display-none');
			$('.btn-prev-create-reminder').removeClass('display-none');
		}
	})
	
	$('.time').mask('00:00');
	
	$('.input-switch').on('click', function(){
		if($(this).is(':checked')){
			$('#time').attr('disabled', true);
			$('#time').addClass('disabled');
		} else {
			$('#time').attr('disabled', false);
			$('#time').removeClass('disabled');
	  }
	});
	
	$('.btn-prev-modal').on('click', function() {
		var validator = $("#formReminder").validate();
		
		validator.resetForm();
	});
	
	$('#days').on('change', function(event) {
		if (event.target.checked) {
	        $(this).val(true);
	        $('form input[name="time"]').val('');
	    } else {
	        $(this).val(false);
	    }
	}); 
	
	$(document).on('click', '.mark-event', function() {
		let target = $(this).data('target');
		let card = $(this).parent().parent();
		
		$.ajax({
           	url: resourceURL,
			type: "POST",
           	data: { dataCategory: 'mark', target: target, rtoken: rToken, aptoken: apToken },
           	dataType: "json",
           	timeout: 20000,
           	success: function (response) {
				if (response.status) { 
					card.remove();
				}
				
				apToken = response.token ? response.token : "";
           	}
       	});
	});
	
	$('.btn-create-reminder').on('click', function() {
		let title = $('form input[name="title"]').val();
		let date = $('form input[name="datepickerReminder"]').val();
		let time = $('form input[name="time"]').val();
		let isAllDay = $('form input[id="days"]').val() == 'on' ? true : $('form input[id="days"]').val();
		let link = $('form input[name="url"]').val();
		let description = $('form textarea[name="message"]').val();
		
		if ($("form").valid()) {
			$.ajax({
	           	url: resourceURL,
				type: "POST",
	           	data: { dataCategory: 'create', title: title, date: date, time: time, isAllDay: isAllDay, link: link, description: description, rtoken: rToken, aptoken: apToken },
	           	dataType: "json",
	           	timeout: 20000,
	           	success: function (response) {
					if (!response.status) {
						parent.location.href = `${host}/dashboard`;
						
						return;
					}
					
					card(response.data);
					
					$("#ModalSuccessReminder").modal('show');
					
					apToken = response.token ? response.token : "";
	           	}
	       	});
		}
	});
	
	$('.btn-reminder').on('click', function(e) {
		e.preventDefault();
		
		$('#formReminder input[type="text"], #formReminder textarea').val('');
		$('#days').prop('checked', true);
		$('#time').attr('disabled', true);
		$('#time').addClass('disabled');
		
		$("#ModalCreateReminder").modal('show');
	});
	
    $(document).on('click', '.link-event', function(e) {
    	e.preventDefault();
        parent.location.href = this.href;
    });
    
    $(document).on('click', '.link-meet', function(e) {
    	e.preventDefault();
        window.open(this.href, '_blank');
    });
});

function card(param) {
	let content
	let today = new Date();
	let childEventBottom = $('.dashboard__event-bottom').find('.card-event-wrapper, .bg-gradient-bottom-scroll');
	
	childEventBottom.remove();
	
	if (param.data.length > 0) {
		content = `<div class="card-event-wrapper">`;
		
		let today = new Date();
		today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);
		today.setMilliseconds(0);

		let timestamp = Math.floor(today.getTime() / 1000);
		
		for (let i = 0; i < param.data.length; i++) {
			
			var url = `${host}/dashboard/event-detail/${param.data[i].group}`;
			var display = param.data[i].link ? "flex-justify-between" : "flex-justify-end";
			var startDate = new Date(param.data[i].startDate);
			var endDate = new Date(param.data[i].endDate);
			var description = param.data[i].description.length >= 250 ? param.data[i].description.substring(0, 250) : param.data[i].description;
		
			if (timestamp == (startDate.getTime() / 1000) || ((timestamp >= startDate.getTime() / 1000) && (endDate.getTime() != NaN && timestamp <= endDate.getTime() / 1000))) {
				content += `<div class="card-event" id="bg-sienna">
								<a href="${url}" class="card-event__header flex-justify-between link-event">
									<div class="card-date-time flex-justify-between gap-12px align-items-center">
										<div class="display-flex gap-8px">
											<svg class="icon-calendar" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
												<path d="M3.67666 16.7742L2.87061 16.1824L2.87061 16.1824L3.67666 16.7742ZM4.903 13.1768L3.903 13.165V13.1768H4.903ZM4.92874 11.0018L5.92874 11.0137V11.0018H4.92874ZM20.3324 16.7917L21.15 16.216L21.15 16.216L20.3324 16.7917ZM19.1522 13.1768L18.1522 13.1644V13.1768H19.1522ZM19.1779 11.1096L20.1779 11.1221V11.1096H19.1779ZM9.79131 19.8966C9.35033 19.5641 8.7233 19.6521 8.3908 20.093C8.0583 20.534 8.14624 21.1611 8.58722 21.4936L9.79131 19.8966ZM15.4152 21.4936C15.8562 21.1611 15.9442 20.534 15.6117 20.093C15.2792 19.6521 14.6521 19.5641 14.2111 19.8966L15.4152 21.4936ZM2.07181 5.63229C1.8663 6.14492 2.11527 6.72708 2.6279 6.93259C3.14053 7.13809 3.72269 6.88912 3.92819 6.37649L2.07181 5.63229ZM6.64253 3.28029C7.12876 3.01837 7.31059 2.41187 7.04867 1.92565C6.78674 1.43942 6.18025 1.25759 5.69402 1.51952L6.64253 3.28029ZM18.293 1.53434C17.8096 1.26726 17.2012 1.44264 16.9341 1.92606C16.6671 2.40947 16.8424 3.01786 17.3258 3.28494L18.293 1.53434ZM20.0679 6.35675C20.2679 6.87154 20.8474 7.12672 21.3622 6.9267C21.877 6.72669 22.1321 6.14722 21.9321 5.63243L20.0679 6.35675ZM4.48271 17.3661C5.19348 16.3981 5.903 14.9487 5.903 13.1768H3.903C3.903 14.407 3.4079 15.4506 2.87061 16.1824L4.48271 17.3661ZM5.90293 13.1887L5.92867 11.0137L3.92881 10.99L3.90307 13.165L5.90293 13.1887ZM21.15 16.216C20.6353 15.485 20.1522 14.4291 20.1522 13.1768H18.1522C18.1522 14.9473 18.8321 16.3979 19.5147 17.3674L21.15 16.216ZM20.1521 13.1893L20.1778 11.122L18.178 11.0971L18.1522 13.1644L20.1521 13.1893ZM20.1779 11.1096C20.1779 6.48905 16.5488 2.68486 12.0012 2.68486V4.68486C15.3807 4.68486 18.1779 7.52901 18.1779 11.1096H20.1779ZM19.9029 18.7997C20.6648 18.7997 21.1248 18.2494 21.304 17.8139C21.4845 17.3752 21.523 16.7457 21.15 16.216L19.5147 17.3674C19.4555 17.2834 19.4401 17.2048 19.4376 17.1591C19.4351 17.1151 19.4428 17.0811 19.4544 17.0529C19.4655 17.0259 19.4935 16.9725 19.5612 16.9176C19.6359 16.8569 19.7557 16.7997 19.9029 16.7997V18.7997ZM5.92874 11.0018C5.92874 7.48076 8.67925 4.68486 12.0012 4.68486V2.68486C7.51116 2.68486 3.92874 6.4408 3.92874 11.0018H5.92874ZM4.10062 16.7997C4.25103 16.7997 4.37233 16.8592 4.44655 16.9206C4.51344 16.9759 4.53989 17.0287 4.54985 17.0537C4.56038 17.0801 4.5676 17.1125 4.56469 17.1558C4.56168 17.2008 4.54525 17.2809 4.48271 17.3661L2.87061 16.1824C2.48078 16.7133 2.51603 17.3532 2.69229 17.795C2.86688 18.2325 3.32603 18.7997 4.10062 18.7997V16.7997ZM19.9029 16.7997H4.10062V18.7997H19.9029V16.7997ZM12.0012 20.5999C11.13 20.5999 10.3577 20.3237 9.79131 19.8966L8.58722 21.4936C9.51332 22.1918 10.7119 22.5999 12.0012 22.5999V20.5999ZM14.2111 19.8966C13.6448 20.3237 12.8724 20.5999 12.0012 20.5999V22.5999C13.2906 22.5999 14.4891 22.1918 15.4152 21.4936L14.2111 19.8966ZM3.92819 6.37649C4.46301 5.04239 5.41497 3.94157 6.64253 3.28029L5.69402 1.51952C4.02696 2.41754 2.76905 3.89303 2.07181 5.63229L3.92819 6.37649ZM17.3258 3.28494C18.5894 3.98301 19.5652 5.06289 20.0679 6.35675L21.9321 5.63243C21.2476 3.87053 19.936 2.44204 18.293 1.53434L17.3258 3.28494Z" />
											</svg>
											<span>Hari ini</span>
										</div>`;
				
				if (param.data[i].startTime) {
					content += `<div class="display-flex gap-8px">
									<svg class="icon-time" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
										<path d="M15.2838 15.3486C15.8077 15.5232 16.3741 15.2401 16.5487 14.7161C16.7234 14.1922 16.4402 13.6259 15.9163 13.4512L15.2838 15.3486ZM12 13.1999H11C11 13.6303 11.2755 14.0125 11.6838 14.1486L12 13.1999ZM13 8.18216C13 7.62988 12.5523 7.18216 12 7.18216C11.4477 7.18216 11 7.62988 11 8.18216H13ZM15.9163 13.4512L12.3163 12.2512L11.6838 14.1486L15.2838 15.3486L15.9163 13.4512ZM13 13.1999V8.18216H11V13.1999H13ZM20.6 11.9999C20.6 16.7495 16.7497 20.5999 12 20.5999V22.5999C17.8542 22.5999 22.6 17.8541 22.6 11.9999H20.6ZM12 20.5999C7.25037 20.5999 3.40002 16.7495 3.40002 11.9999H1.40002C1.40002 17.8541 6.14581 22.5999 12 22.5999V20.5999ZM3.40002 11.9999C3.40002 7.25025 7.25037 3.3999 12 3.3999V1.3999C6.14581 1.3999 1.40002 6.14568 1.40002 11.9999H3.40002ZM12 3.3999C16.7497 3.3999 20.6 7.25025 20.6 11.9999H22.6C22.6 6.14568 17.8542 1.3999 12 1.3999V3.3999Z" />
									</svg>
									<span>${param.data[i].startTime}</span>
								</div>`;
				}
											
				content += `</div><div class="label-event white">`;
				
				if (param.data[i].category.toLowerCase() == 'event') {
					content += `<svg class="mt-2px mr-6px" xmlns="http://www.w3.org/2000/svg" width="11" height="13" viewBox="0 0 11 13" fill="none">
									<path d="M0 11.375V5H10.5V11.375C10.5 12.0078 9.98438 12.5 9.375 12.5H1.125C0.492188 12.5 0 12.0078 0 11.375ZM7.5 6.78125V7.71875C7.5 7.88281 7.61719 8 7.78125 8H8.71875C8.85938 8 9 7.88281 9 7.71875V6.78125C9 6.64062 8.85938 6.5 8.71875 6.5H7.78125C7.61719 6.5 7.5 6.64062 7.5 6.78125ZM7.5 9.78125V10.7188C7.5 10.8828 7.61719 11 7.78125 11H8.71875C8.85938 11 9 10.8828 9 10.7188V9.78125C9 9.64062 8.85938 9.5 8.71875 9.5H7.78125C7.61719 9.5 7.5 9.64062 7.5 9.78125ZM4.5 6.78125V7.71875C4.5 7.88281 4.61719 8 4.78125 8H5.71875C5.85938 8 6 7.88281 6 7.71875V6.78125C6 6.64062 5.85938 6.5 5.71875 6.5H4.78125C4.61719 6.5 4.5 6.64062 4.5 6.78125ZM4.5 9.78125V10.7188C4.5 10.8828 4.61719 11 4.78125 11H5.71875C5.85938 11 6 10.8828 6 10.7188V9.78125C6 9.64062 5.85938 9.5 5.71875 9.5H4.78125C4.61719 9.5 4.5 9.64062 4.5 9.78125ZM1.5 6.78125V7.71875C1.5 7.88281 1.61719 8 1.78125 8H2.71875C2.85938 8 3 7.88281 3 7.71875V6.78125C3 6.64062 2.85938 6.5 2.71875 6.5H1.78125C1.61719 6.5 1.5 6.64062 1.5 6.78125ZM1.5 9.78125V10.7188C1.5 10.8828 1.61719 11 1.78125 11H2.71875C2.85938 11 3 10.8828 3 10.7188V9.78125C3 9.64062 2.85938 9.5 2.71875 9.5H1.78125C1.61719 9.5 1.5 9.64062 1.5 9.78125ZM9.375 2C9.98438 2 10.5 2.51562 10.5 3.125V4.25H0V3.125C0 2.51562 0.492188 2 1.125 2H2.25V0.875C2.25 0.6875 2.41406 0.5 2.625 0.5H3.375C3.5625 0.5 3.75 0.6875 3.75 0.875V2H6.75V0.875C6.75 0.6875 6.91406 0.5 7.125 0.5H7.875C8.0625 0.5 8.25 0.6875 8.25 0.875V2H9.375Z" />
								</svg>`;
				} else {
					content += `<svg class="mt-2px mr-6px" xmlns="http://www.w3.org/2000/svg" width="12" height="13" viewBox="0 0 12 13" fill="none">
									<path d="M6.25 12.5C5.40625 12.5 4.75 11.8438 4.75 11H7.72656C7.72656 11.8438 7.07031 12.5 6.25 12.5ZM11.2891 9.00781C11.4297 9.14844 11.5 9.33594 11.5 9.5C11.4766 9.89844 11.1953 10.25 10.7266 10.25H1.75C1.28125 10.25 1 9.89844 1 9.5C0.976562 9.33594 1.04688 9.14844 1.1875 9.00781C1.63281 8.51562 2.5 7.78906 2.5 5.375C2.5 3.57031 3.76562 2.11719 5.5 1.74219V1.25C5.5 0.851562 5.82812 0.5 6.25 0.5C6.64844 0.5 6.97656 0.851562 6.97656 1.25V1.74219C8.71094 2.11719 9.97656 3.57031 9.97656 5.375C9.97656 7.78906 10.8438 8.51562 11.2891 9.00781Z" />
								</svg>`;
				}
			
				content += `<span class="text-12px">${param.data[i].category}</span>
								</div>
							</a>
							<a href="${url}" class="card-event__body link-event">
								<h5>${param.data[i].title}</h5>
								<p class="agency-line-clamp-2">${description}</p>
							</a>`;
				
				content += `<div class="card-event__footer ${display}">
							<a class="link-hover link-hover--white agency-self-center mark-event display-flex gap-8px" href="javascript:void(0)" data-target="${param.data[i].group}">
								<svg class="agency-self-center" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
									<path d="M21.5999 11.9999C21.5999 17.3018 17.3018 21.5999 11.9999 21.5999C6.69797 21.5999 2.3999 17.3018 2.3999 11.9999C2.3999 6.69797 6.69797 2.3999 11.9999 2.3999C13.5061 2.3999 14.9313 2.74677 16.1999 3.36498M19.7999 5.9999L11.3999 14.3999L8.9999 11.9999" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
								</svg>
								<span class="agency-self-center">Tandai selesai</span>
							</a>`;
				
				if (param.data[i].link) {
					content += `<a href="${param.data[i].link}" class="btn__agency btn--dark-blue display-block agency-text-center link-meet">
									<span class="position-relative order-10">Buka <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
								</a>`;
				}
				
				content += `</div></div>`;
			} else if ((startDate.getTime() / 1000) > timestamp) {
				content += `<div class="card-event" id="bg-white">
							<a href="${url}" class="card-event__header flex-justify-between link-event">
								<div class="card-date-time flex-justify-between gap-12px align-items-center">
									<div class="display-flex gap-8px">
										<svg class="icon-calendar" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
											<path d="M7.25 17.5534V17.4688M12.3125 17.5534V17.4688M12.3125 12.9688V12.8842M16.8125 12.9688V12.8842M3.875 8.46875H19.625M5.91071 2V3.68771M17.375 2V3.6875M17.375 3.6875H6.125C4.26104 3.6875 2.75 5.19854 2.75 7.0625V18.3126C2.75 20.1766 4.26104 21.6876 6.125 21.6876H17.375C19.239 21.6876 20.75 20.1766 20.75 18.3126L20.75 7.0625C20.75 5.19854 19.239 3.6875 17.375 3.6875Z" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
										</svg>`;
				
				var formattedDate = moment(param.data[i].startDate).format('D MMM YYYY');
				
				content += `<span>${formattedDate}</span></div>`;
				
				if (param.data[i].startTime) {
					content += `<div class="display-flex gap-8px">
									<svg class="icon-time" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
										<path d="M15.2838 15.3486C15.8077 15.5232 16.3741 15.2401 16.5487 14.7161C16.7234 14.1922 16.4402 13.6259 15.9163 13.4512L15.2838 15.3486ZM12 13.1999H11C11 13.6303 11.2755 14.0125 11.6838 14.1486L12 13.1999ZM13 8.18216C13 7.62988 12.5523 7.18216 12 7.18216C11.4477 7.18216 11 7.62988 11 8.18216H13ZM15.9163 13.4512L12.3163 12.2512L11.6838 14.1486L15.2838 15.3486L15.9163 13.4512ZM13 13.1999V8.18216H11V13.1999H13ZM20.6 11.9999C20.6 16.7495 16.7497 20.5999 12 20.5999V22.5999C17.8542 22.5999 22.6 17.8541 22.6 11.9999H20.6ZM12 20.5999C7.25037 20.5999 3.40002 16.7495 3.40002 11.9999H1.40002C1.40002 17.8541 6.14581 22.5999 12 22.5999V20.5999ZM3.40002 11.9999C3.40002 7.25025 7.25037 3.3999 12 3.3999V1.3999C6.14581 1.3999 1.40002 6.14568 1.40002 11.9999H3.40002ZM12 3.3999C16.7497 3.3999 20.6 7.25025 20.6 11.9999H22.6C22.6 6.14568 17.8542 1.3999 12 1.3999V3.3999Z" />
									</svg>
									<span>${param.data[i].startTime}</span>
								</div>`;
				}
									
				content += `</div><div class="label-event ocean">`;
				
				if (param.data[i].category.toLowerCase() == 'event') {
					content += `<svg class="mt-2px mr-6px" xmlns="http://www.w3.org/2000/svg" width="11" height="13" viewBox="0 0 11 13" fill="none">
									<path d="M0 11.375V5H10.5V11.375C10.5 12.0078 9.98438 12.5 9.375 12.5H1.125C0.492188 12.5 0 12.0078 0 11.375ZM7.5 6.78125V7.71875C7.5 7.88281 7.61719 8 7.78125 8H8.71875C8.85938 8 9 7.88281 9 7.71875V6.78125C9 6.64062 8.85938 6.5 8.71875 6.5H7.78125C7.61719 6.5 7.5 6.64062 7.5 6.78125ZM7.5 9.78125V10.7188C7.5 10.8828 7.61719 11 7.78125 11H8.71875C8.85938 11 9 10.8828 9 10.7188V9.78125C9 9.64062 8.85938 9.5 8.71875 9.5H7.78125C7.61719 9.5 7.5 9.64062 7.5 9.78125ZM4.5 6.78125V7.71875C4.5 7.88281 4.61719 8 4.78125 8H5.71875C5.85938 8 6 7.88281 6 7.71875V6.78125C6 6.64062 5.85938 6.5 5.71875 6.5H4.78125C4.61719 6.5 4.5 6.64062 4.5 6.78125ZM4.5 9.78125V10.7188C4.5 10.8828 4.61719 11 4.78125 11H5.71875C5.85938 11 6 10.8828 6 10.7188V9.78125C6 9.64062 5.85938 9.5 5.71875 9.5H4.78125C4.61719 9.5 4.5 9.64062 4.5 9.78125ZM1.5 6.78125V7.71875C1.5 7.88281 1.61719 8 1.78125 8H2.71875C2.85938 8 3 7.88281 3 7.71875V6.78125C3 6.64062 2.85938 6.5 2.71875 6.5H1.78125C1.61719 6.5 1.5 6.64062 1.5 6.78125ZM1.5 9.78125V10.7188C1.5 10.8828 1.61719 11 1.78125 11H2.71875C2.85938 11 3 10.8828 3 10.7188V9.78125C3 9.64062 2.85938 9.5 2.71875 9.5H1.78125C1.61719 9.5 1.5 9.64062 1.5 9.78125ZM9.375 2C9.98438 2 10.5 2.51562 10.5 3.125V4.25H0V3.125C0 2.51562 0.492188 2 1.125 2H2.25V0.875C2.25 0.6875 2.41406 0.5 2.625 0.5H3.375C3.5625 0.5 3.75 0.6875 3.75 0.875V2H6.75V0.875C6.75 0.6875 6.91406 0.5 7.125 0.5H7.875C8.0625 0.5 8.25 0.6875 8.25 0.875V2H9.375Z" fill="white"/>
								</svg>`;
				} else {
					content += `<svg class="mt-2px mr-6px" xmlns="http://www.w3.org/2000/svg" width="12" height="13" viewBox="0 0 12 13" fill="none">
									<path d="M6.25 12.5C5.40625 12.5 4.75 11.8438 4.75 11H7.72656C7.72656 11.8438 7.07031 12.5 6.25 12.5ZM11.2891 9.00781C11.4297 9.14844 11.5 9.33594 11.5 9.5C11.4766 9.89844 11.1953 10.25 10.7266 10.25H1.75C1.28125 10.25 1 9.89844 1 9.5C0.976562 9.33594 1.04688 9.14844 1.1875 9.00781C1.63281 8.51562 2.5 7.78906 2.5 5.375C2.5 3.57031 3.76562 2.11719 5.5 1.74219V1.25C5.5 0.851562 5.82812 0.5 6.25 0.5C6.64844 0.5 6.97656 0.851562 6.97656 1.25V1.74219C8.71094 2.11719 9.97656 3.57031 9.97656 5.375C9.97656 7.78906 10.8438 8.51562 11.2891 9.00781Z" />
								</svg>`;
				}
				
				content += `<span class="text-12px">${param.data[i].category}</span>
								</div>
							</a>
							<a href="${url}" class="card-event__body link-event">
								<h5>${param.data[i].title}</h5>
								<p class="agency-line-clamp-2">${description}</p>
							</a>`;
				
				content += `<div class="card-event__footer ${display}">
							<a class="link-hover link-hover--blue agency-self-center link-event" href="${url}">Baca</a>`;
				
				if (param.data[i].link) {
					content += `<a href="${param.data[i].link}" class="btn__agency btn--dark-blue display-block agency-text-center link-meet">
									<span class="position-relative order-10">Buka <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
								</a>`;
				}
				
				content += `</div></div>`;
			}
		}
		
		content += `</div><div class="bg-gradient-bottom-scroll"></div>`;
	}
	
	$('.dashboard__event-bottom').html(content);
}