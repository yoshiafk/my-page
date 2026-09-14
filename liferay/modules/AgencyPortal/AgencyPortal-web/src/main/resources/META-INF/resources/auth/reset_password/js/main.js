var ajax_url = Liferay.ThemeDisplay.getPortalURL();
var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency");

$(document).ready(function(){
	$(".toggle-password").click(function() {
		$(this).toggleClass("is-show");
		var inputpass = $($(this).attr("toggle"));
		if (inputpass.attr("type") == "password") {
			inputpass.attr("type", "text");
		} else {
			inputpass.attr("type", "password");
		}
	});
	
	$(".tooltip-click").on("click", function() {
		$("#tooltip-password").toggleClass("is-show");
	});
	
	$(document).mouseup(function(e){
		var container = $("#tooltip-password");
		if(!container.is(e.target) && container.has(e.target).length === 0) {
			container.removeClass('is-show');
		}
  	});
	
	$(".link-otp-password").on("click", function() {
		$(this).addClass('display-none');
		$('.otp-field').css('display', '');
		$('.link-otp').removeClass('display-none');
		$('.btn-finish-create-new-password').removeClass('btn--disabled');
		$('.btn-finish-create-new-password').removeClass('disabled');
		$('.btn-finish-create-new-password').addClass('btn--dark-blue');
		$('.btn-finish-create-new-password').attr('disabled', false);
		$('#timer').addClass('display-block');
		$('#timer').removeClass('display-none');
	});
	
	$('#confirm_new_password').bind('keyup', function() {
		var inputPass = $(this).val().length;
		var total = inputPass
		if ($('#timer').hasClass('display-none')) {
			if (total > 7) {
				$('.label-otp').removeClass('display-none');
				$('.link-otp-password').removeClass('display-none');
			} else {
				$('.label-otp').addClass('display-none');
				$('.link-otp-password').addClass('display-none');
			}
		}
    });
	
	$('input.required, textarea.required').on('change keyup keydown', function(){
		if ($(this).hasClass('error-text') && $(this).val().length > 0) $(this).removeClass('error-text');
	});
});

function generateOtp(params) {
	var url = ajax_url + "/o/user/otp-forgot-password";
	
	if (params == 'resend' && timeInSecs != 0) {
		return;
	}

	let data = {
		Username: $('form input[name="email"]').val()
	};

	$.ajax({
		type: "post",
		url: url,
		data: JSON.stringify(data),
		contentType: "application/json",
		timeout: 45000,
		success: function (response) {
			if (response.status == false) {
				$(".alert-agency").removeClass('display-none').addClass('failed');
        		$(".alert-agency span").empty().append(response.message);
				
				return;
			}
			
			if ($(".alert-agency").hasClass('display-none') == false) {
        		$(".alert-agency").addClass('display-none').removeClass('failed success');
        		$(".alert-agency span").empty();
        	}
			
			if (params == 'new') {
				$(".alert-otp").removeClass('display-none');
				$(".email-otp").empty().append(response.data.email);
			}

			resettimerOTP();
		}
	});
}

function submitForm() {
	var api = "/o/user/forgot-password";
	var url = ajax_url + api;

	if ($("form").valid()) {
		let number = $('form input[name="otp-password"]').val();
		
		if (number.length < 6) {
			$(".alert-agency").removeClass('display-none').addClass('failed');
    		$(".alert-agency span").empty().append('Masukkan Kode OTP Anda');
			
			return;
		}
		
		let data = {
			Username: $('form input[name="email"]').val(),
			Password: btoa($('form input[name="create_new_password"]').val()),
			Verification: number
		};

		$.ajax({
			type: "post",
			url: url,
			data: JSON.stringify(data),
			contentType: "application/json",
			timeout: 45000,
			success: function (response) {
				if (response.status == false) {
					$(".alert-agency").removeClass('display-none').addClass('failed');
	        		$(".alert-agency span").empty().append(response.message);
					
					return;
				}
				
				if ($(".alert-agency").hasClass('display-none') == false) {
	        		$(".alert-agency").addClass('display-none').removeClass('failed success');
	        		$(".alert-agency span").empty();
	        	}
				
				$(".alert-agency").removeClass('display-none').addClass('success');
        		$(".alert-agency span").empty().append(response.message);
				
				$(".btn-finish-create-new-password").addClass("btn--disabled");
                $(".btn-finish-create-new-password").css("pointer-events", "none");
				
				setTimeout(function() {
				    location.href = response.data.url;
				}, 3000);
			}
		});
	}
}