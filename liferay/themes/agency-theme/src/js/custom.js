$(document).ready(function(){
	//Windows
	if (navigator.appVersion.indexOf("Win") != -1){
		document.getElementsByTagName("body")[0].classList.add("win");  
	}
	//Mac
	else if (navigator.appVersion.indexOf("Mac") != -1){
		document.getElementsByTagName("body")[0].classList.add("mac");
	}
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
		$("#tooltip-account-activation").toggleClass("is-show");
	});
	$(".tooltip-click-new-password").on("click", function() { 
		$("#tooltip-new-password").toggleClass("is-show");
	});
	$(".tooltip-click-confirmation-new-password").on("click", function() { 
		$("#tooltip-confirmation-new-password").toggleClass("is-show");
	});
	$(".tooltip-click-premi").on("click", function() { 
		$("#tooltip-click-premi").toggleClass("is-show");
	});
	$(document).mouseup(function(e){
		var container = $("#tooltip-password");
			container2 = $("#tooltip-account-activation");
			container3 = $("#tooltip-new-password");
			container4 = $("#tooltip-confirmation-new-password");
			container5 = $("#tooltip-click-premi");
		if(!container.is(e.target) && container.has(e.target).length === 0) {
			container.removeClass('is-show');
		}
		if(!container2.is(e.target) && container2.has(e.target).length === 0) {
			container2.removeClass('is-show');
	  	}
		if(!container3.is(e.target) && container3.has(e.target).length === 0) {
			container3.removeClass('is-show');
	  	}
		if(!container4.is(e.target) && container4.has(e.target).length === 0) {
			container4.removeClass('is-show');
	  	}
		  if(!container5.is(e.target) && container5.has(e.target).length === 0) {
			container5.removeClass('is-show');
	  	}
  	});
	$('.btn-enter-login').on('click', function() {
		$('#login').addClass('visible');
		$('#login').removeClass('hidden');
		$('#create-new-password').addClass('hidden');
		$('#create-new-password').removeClass('visible');
	});
	$('.btn-prev-modal').on('click', function() {
		var validator = $("#formLogin").validate();
		
		$('#forgotpass').removeClass('visible');
		$('#create-new-password').removeClass('visible');
		$('#account-activation').removeClass('visible');
		$('#login').addClass('visible');
		$('#login').removeClass('hidden');
		validator.resetForm();
	});

   var swiperAnnouncement = new Swiper(".swiper-announcement", {
		speed: 1000,
		loop: true,
		autoplay: {
        delay: 5000,
        disableOnInteraction: false,
      },
		pagination: {
			el: ".swiper-pagination-announcement",
			clickable: true
		},
  });

	$('#markEvent').on('click', function(){
		$(this).parent().parent().hide().attr('id');
	});
	$('.time').mask('00:00');
	$('.phone').mask('+0000 0000 00000');
	$('.telephone').mask('(000) 000-0000');
  	$('.input-switch').on('click', function(){
		if($(this).is(':checked')){
			$('#time').attr('disabled', true);
			$('#time').addClass('disabled');
			$('#maksimal-kupon').attr('disabled', true);
			$('#maksimal-kupon').addClass('disabled');
			$('#maksimal-kupon').val('Tidak terbatas');
			$('#time-error').show();
		} else {
			$('#time').attr('disabled', false);
			$('#time').removeClass('disabled');
			$('#maksimal-kupon').val('');
			$('#maksimal-kupon').attr('disabled', false);
			$('#maksimal-kupon').removeClass('disabled');
			$('#time-error').hide();
	  }
	});
	$('#virtual-account').on('click', function(){
		if($(this).is(':checked')){
			$('#bank').attr('disabled', false);
			$('#bank').removeClass('disabled');
			$('.btn-credit-total-summary .btn--disabled').attr('disabled', false);
			$('.btn-credit-total-summary .btn--disabled').removeClass('btn--disabled');
			$('.btn-credit-total-summary .btn').removeClass('disabled');
			$('.btn-credit-total-summary .btn').addClass('btn--dark-blue');
		} else {
			$('#bank').attr('disabled', true);
			$('#bank').addClass('disabled');
	  }
	});
	$('#cc').on('click', function(){
		$('#bank').attr('disabled', true);
		$('#bank').addClass('disabled');
		$('.btn-credit-total-summary .btn--disabled').attr('disabled', false);
		$('.btn-credit-total-summary .btn--disabled').removeClass('btn--disabled');
		$('.btn-credit-total-summary .btn').removeClass('disabled');
		$('.btn-credit-total-summary .btn').addClass('btn--dark-blue');
	});
	$('#selectAllInvoice').click(function (e) {
		$(this).closest('table').find('tbody td input:checkbox').prop('checked', this.checked);
	});
	$('#periode-promo').on('focus', function(){
		$('#periode-promo-selesai').attr('disabled', false);
		$('#periode-promo-selesai').removeClass('disabled');
	});
	$('#periode-promo-edit').on('focus', function(){
		$('#periode-promo-selesai-edit').attr('disabled', false);
	}); 
	$('.hour').click(function () {
		$(this).parent().parent().parent().toggleClass('is-open');
  	});
	$('#SelectTabs').on('change', function (e) {
		$('#v-pills-tab button').eq($(this).val()).tab('show');
    });
	$('#FaqSelect').on('change', function(){
		var target = $(this).val();
		$(target).collapse('show');
		setTimeout(function() {
			$('html, body').stop().animate({
				scrollTop: $(target).offset().top - 2
			}, 800, function () {
				window.location.hash = target;
			});
		}, 1000);
	});
	$('#24jam').click(function () {
		$('.hours-list').addClass('hidden');
  	});
	$('#aturjam').click(function () {
		$('.hours-list').removeClass('hidden');
  	});
	$('#email_forgotpassword').on('keyup', function() {
		if ($('#email_forgotpassword').val() == '') {
			$('.btn-cancel-forgot-password').addClass('hidden');
			$('.btn-prev-forgot-password').removeClass('hidden');
		} else {
			$('.btn-cancel-forgot-password').removeClass('hidden');
			$('.btn-prev-forgot-password').addClass('hidden');
		}
	})
	$('#kode_agen_activation').on('keyup', function() {
		if ($('#kode_agen_activation').val() == '') {
			$('.btn-modal-activation').addClass('hidden');
			$('.btn-prev-activation').removeClass('hidden');
		} else {
			$('.btn-modal-activation').removeClass('hidden');
			$('.btn-prev-activation').addClass('hidden');
		}
	})
	$('#account_activation_password').on('keyup', function() {
		if ($('#account_activation_password').val() == '') {
			$('.btn-modal-activation').addClass('hidden');
			$('.btn-prev-activation').removeClass('hidden');
		} else {
			$('.btn-modal-activation').removeClass('hidden');
			$('.btn-prev-activation').addClass('hidden');
		}
	})
	$('#account_activation_password_confirmation').on('keyup', function() {
		if ($('#account_activation_password_confirmation').val() == '') {
			$('.btn-modal-activation').addClass('hidden');
			$('.btn-prev-activation').removeClass('hidden');
		} else {
			$('.btn-modal-activation').removeClass('hidden');
			$('.btn-prev-activation').addClass('hidden');
		}
	})
	$('#kode-promo').on('keyup', function() {
		if ($('#kode-promo').val() == '') {
			$('.btn-modal').removeClass('hidden');
			$('.btn-prev-promo-code').addClass('hidden');
		} else {
			$('.btn-modal').addClass('hidden');
			$('.btn-prev-promo-code').removeClass('hidden');
		}
	})
	$('#title').on('keyup', function() {
		if ($('#title').val() == '') {
			$('.btn-cancel-create-reminder').removeClass('hidden');
			$('.btn-prev-create-reminder').addClass('hidden');
		} else {
			$('.btn-cancel-create-reminder').addClass('hidden');
			$('.btn-prev-create-reminder').removeClass('hidden');
		}
	})
	$(".link-otp-password").on("click", function() {
		$(this).addClass('hidden');
		$('.otp-field').removeClass('hidden');
		$('.text-otp').removeClass('hidden');
		$('.btn-save-password').removeClass('btn--disabled');
		$('.btn-save-password').removeClass('disabled');
		$('.btn-save-password').addClass('btn--dark-blue');
		$('.link-otp-password').hide();
		$('.link-resend-otp-password').removeClass('hidden');
		$('.btn-save-password').attr('disabled', false);
		$('input[type="number"]').attr('disabled', false);
		$('#timer').addClass('block');
		$('#timer').removeClass('hidden');
	});
	// $('#change_profile_password_confirmation').keyup(function() {
	// 	var inputPass = $(this).val().length;
	// 	var total = inputPass
	// 	if(total > 0) {
	// 		$('.label-otp').removeClass('hidden');
	// 		$('.link-otp-password').removeClass('hidden');
	// 	} else if(total > 0) {
	// 		$('.link-otp-password').removeClass('hidden');
	// 		console.log("else if");
	// 	}
	// });
	$('#change_profile_new_password, #change_profile_password_confirmation, #profile_old_password').on('keyup', function() {
        if(!$(this).valid()){
			$('.label-otp').removeClass('hidden');
			$('.link-otp-password').removeClass('hidden');
        } 
    });
	$(".reset").click(function() {
		$(this).closest('form').find("input, select").val("");
	});
	$('input.required, textarea.required').on('change keyup keydown', function(){
		if ($(this).hasClass('error-text') && $(this).val().length > 0) $(this).removeClass('error-text');
	});
});

// $(window).on('load', function() {
// 	$('#ModalLostConnection').modal('show');
// });