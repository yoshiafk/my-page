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
		$("#tooltip-account-activation").toggleClass("is-show");
	});
	
	$(document).mouseup(function(e){
		var container = $("#tooltip-account-activation");
		if(!container.is(e.target) && container.has(e.target).length === 0) {
			container.removeClass('is-show');
		}
  	});
	
	$('.btn-enter-login').on('click', function() {
		$('#login').addClass('visible');
		$('#login').removeClass('display-none');
		$('#create-new-password').addClass('display-none');
		$('#create-new-password').removeClass('visible');
	});
	
	$('.btn-prev-modal').on('click', function() {
		var validator = $("#formLogin").validate();
		
		$('#forgotpass').removeClass('visible');
		$('#create-new-password').removeClass('visible');
		$('#account-activation').removeClass('visible');
		$('#login').addClass('visible');
		$('#login').removeClass('display-none');
		validator.resetForm();
	});
	
	$('#email_forgotpassword').on('keyup', function() {
		if ($('#email_forgotpassword').val() == '') {
			$('.btn-cancel-forgot-password').addClass('display-none');
			$('.btn-prev-forgot-password').removeClass('display-none');
		} else {
			$('.btn-cancel-forgot-password').removeClass('display-none');
			$('.btn-prev-forgot-password').addClass('display-none');
		}
	})
	
	$('#kode_agen_activation').on('keyup', function() {
		if ($('#kode_agen_activation').val() == '') {
			$('.btn-modal-activation').addClass('display-none');
			$('.btn-prev-activation').removeClass('display-none');
		} else {
			$('.btn-modal-activation').removeClass('display-none');
			$('.btn-prev-activation').addClass('display-none');
		}
	})
	
	$('#account_activation_password').on('keyup', function() {
		if ($('#account_activation_password').val() == '') {
			$('.btn-modal-activation').addClass('display-none');
			$('.btn-prev-activation').removeClass('display-none');
		} else {
			$('.btn-modal-activation').removeClass('display-none');
			$('.btn-prev-activation').addClass('display-none');
		}
	})
	
	$('#account_activation_password_confirmation').on('keyup', function() {
		if ($('#account_activation_password_confirmation').val() == '') {
			$('.btn-modal-activation').addClass('display-none');
			$('.btn-prev-activation').removeClass('display-none');
		} else {
			$('.btn-modal-activation').removeClass('display-none');
			$('.btn-prev-activation').addClass('display-none');
		}
	})
	
	$('input.required, textarea.required').on('change keyup keydown', function(){
		if ($(this).hasClass('error-text') && $(this).val().length > 0) $(this).removeClass('error-text');
	});
	
	$('form input[name="email_agen"]').on('keypress', function (event) {  
		var key = event.keyCode;
		if (key === 32) {
			event.preventDefault();
		}
	});
	
	$('.btn-enter-account-activation, .btn-prev-activation, .btn-prev-forgot-password, .btn-close').on('click', function() {
		$(".alert-agency").addClass('display-none').removeClass('failed success');
		$(".alert-agency span").empty();
	});
	
	$('#resend-otp').on('click', function () {
		var trx = $('form input[name="email_agen"]').val() ? "login" : "activation";
			
		if (trx == "login") {
			generateOtpLogin('resend');
		} else {
			generateOtpActivation('resend');
		}
	});
});

function generateOtpLogin(params) {
	var url = ajax_url + "/o/user/otp-login";
	
	if (params == 'resend' && timeInSecs != 0) {
		return;
	}

	if ($("form").valid()) {
		let data = {
			Username: $('form input[name="email_agen"]').val(),
			Password: btoa($('form input[name="password_agen"]').val())
		};

		$.ajax({
			type: "post",
			url: url,
			data: JSON.stringify(data),
			contentType: "application/json",
			timeout: 45000,
	        beforeSend: function() {
	        	$(".login-form__footer button").addClass("btn--disabled");
	        	$(".login-form__footer button").css("pointer-events", "none");
	        },
			success: function (response) {
				if (response.status == false) {
					$("#login").attr("aria-hidden", false);
					$("#otp").attr("aria-hidden", true);
					$("#login, #otp").removeAttr("class");
					
					$(".alert-agency").removeClass('display-none').addClass('failed');
	        		$(".alert-agency span").empty().append(response.message);
					
					return;
				}
				
				if ($(".alert-agency").hasClass('display-none') == false) {
	        		$(".alert-agency").addClass('display-none').removeClass('failed success');
	        		$(".alert-agency span").empty();
	        	}
				
				if (params == 'new') {
					var currentParent = $(".btn-next").closest("fieldset"),
						nextParent = currentParent.next()
					
					currentParent.removeClass("visible");
					app.showNextStep(currentParent, nextParent);
					
					$(".email-otp").empty().append(response.data.email);
				}

				resettimerOTP();
			},
	        complete: function() {
	        	$(".login-form__footer button").removeClass("btn--disabled");
	        	$(".login-form__footer button").css("pointer-events", "auto");
	        }
		});
	}
}

function submitForm() {
	var trx = $('form input[name="email_agen"]').val() ? "login" : "activation";
	var api = trx == "login" ? "/o/user/login" : "/o/user/activation";
	var url = ajax_url + api;

	if ($("form").valid()) {
		let number = $('form input[name="otp"]').val();
		
		if (number.length < 6) {
			$(".alert-agency").removeClass('display-none').addClass('failed');
    		$(".alert-agency span").empty().append('Masukkan Kode OTP Anda');
			
			return;
		}
		
		let data = {
			Username: $('form input[name="email_agen"]').val() || $('form input[name="kode_agen_activation"]').val(),
			Password: btoa($('form input[name="password_agen"]').val()) || btoa($('form input[name="account_activation_password"]').val()),
			Verification: number
		};

		$.ajax({
			type: "post",
			url: url,
			data: JSON.stringify(data),
			contentType: "application/json",
			timeout: 45000,
	        beforeSend: function() {
	        	$(".login-form__footer button").addClass("btn--disabled");
	        	$(".login-form__footer button").css("pointer-events", "none");
	        },
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
				
				if (trx == "login") {
					location.href = response.data.url;
				}
				
				if (trx == "activation") {
					$(".alert-agency").removeClass('display-none').addClass('success');
	        		$(".alert-agency span").empty().append(response.message);
					
					setTimeout(function() {
					    location.reload(true);
					}, 3000);
				}
			},
	        complete: function() {
	        	$(".login-form__footer button").removeClass("btn--disabled");
	        	$(".login-form__footer button").css("pointer-events", "auto");
	        }
		});
	}
}

function generateOtpActivation(params) {
	var url = ajax_url + "/o/user/otp-activation";
	
	if (params == 'resend' && timeInSecs != 0) {
		return;
	}

	if ($("form").valid()) {
		let data = {
			Username: $('form input[name="kode_agen_activation"]').val()
		};

		$.ajax({
			type: "post",
			url: url,
			data: JSON.stringify(data),
			contentType: "application/json",
			timeout: 45000,
	        beforeSend: function() {
	        	$(".login-form__footer .btn-account-activation").addClass("btn--disabled");
	        	$(".login-form__footer .btn-account-activation").css("pointer-events", "none");
	        },
			success: function (response) {
				if (response.status == false) {
					$("#account-activation").attr("aria-hidden", false);
					$("#otp").attr("aria-hidden", true);
					$("#account-activation, #otp").removeAttr("class");
					$("#account-activation").addClass("visible");
					
					$(".alert-agency").removeClass('display-none').addClass('failed');
	        		$(".alert-agency span").empty().append(response.message);
					
					return;
				}
				
				if ($(".alert-agency").hasClass('display-none') == false) {
	        		$(".alert-agency").addClass('display-none').removeClass('failed success');
	        		$(".alert-agency span").empty();
	        	}
				
				if (params == 'new') {
					var currentParent = $(".btn-account-activation").closest("fieldset"),
						nextParent = $("#account-activation").closest("fieldset"),
						otp = $("#otp").closest("fieldset"),
						account = $('#account-activation').closest("fieldset")
					
					currentParent.addClass(app.htmlClasses.visibleClass);
					app.showNextStep(currentParent, nextParent);
					otp.addClass(app.htmlClasses.visibleClass);
					account.addClass(app.htmlClasses.hiddenClass);
					account.removeClass(app.htmlClasses.visibleClass);
					
					$(".email-otp").empty().append(response.data.email);
				}

				resettimerOTP();
			},
	        complete: function() {
	        	$(".login-form__footer .btn-account-activation").removeClass("btn--disabled");
	        	$(".login-form__footer .btn-account-activation").css("pointer-events", "auto");
	        }
		});
	}
}

function generateLinkForgot() {
	var url = ajax_url + "/o/user/link-forgot-password";

	if ($("form").valid()) {
		let data = {
			Username: $('form input[name="email_forgotpassword"]').val()
		};

		$.ajax({
			type: "post",
			url: url,
			data: JSON.stringify(data),
			contentType: "application/json",
			timeout: 45000,
            beforeSend: function () {
            	$(".login-form__footer .btn-send-forgotpass").addClass("btn--disabled");
                $(".login-form__footer .btn-send-forgotpass").css("pointer-events", "none");
            },
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
			},
            complete: function () {
            	$(".login-form__footer .btn-send-forgotpass").removeClass("btn--disabled");
                $(".login-form__footer .btn-send-forgotpass").css("pointer-events", "auto");
            }
		});
	}
}