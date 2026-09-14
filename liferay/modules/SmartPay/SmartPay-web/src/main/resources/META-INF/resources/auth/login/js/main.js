var verifyCaptchaURL = window.verifyCaptchaURL;
var namespace = $('.login').data('namespace');

$(document).ready(function() {
    $(`#${namespace}captchaTextHelper`).addClass('display-none');
    
    $('#myform').validate({
        onfocusout: false,
        onkeyup: false,
        ignore: ":hidden", // any children of hidden desc are ignored
        errorElement: "span", // wrap error elements in span not label
        validClass: 'success',
        errorClass: "error-input", // added error class to span
        rules: {
            no_polis: {
                required: true,
            },
            id_profile: {
                required: true,
            },
            _com_axa_payment_AuthenticationPortlet_captchaText: {
                required: true,
            }
        },
        groups: {
			polis_profile_group: "no_polis id_profile _com_axa_payment_AuthenticationPortlet_captchaText",
		},
        messages: { 
            no_polis: {
                required: 'Periksa kembali Nomor Polis, ID Profil, dan Verifikasi Teks Anda, lalu silakan coba lagi',
            },
            id_profile: {
                required: 'Periksa kembali Nomor Polis, ID Profil, dan Verifikasi Teks Anda, lalu silakan coba lagi',
            },
            _com_axa_payment_AuthenticationPortlet_captchaText: {
            	required: 'Periksa kembali Nomor Polis, ID Profil, dan Verifikasi Teks Anda, lalu silakan coba lagi',
            }
        },
        errorPlacement: function(error, element) { 
        	if (element.attr("name") == "no_polis" || element.attr("name") == "id_profile" || element.attr("name") == "_com_axa_payment_AuthenticationPortlet_captchaText") {
                error.appendTo("#login-nop-id-failed"),
                error.hide(),
            	$(`#${namespace}captchaTextHelper`).addClass('display-none');
        	} else {
                error.appendTo($('#login-nop-id-failed'));
                $(`#${namespace}captchaTextHelper`).addClass('display-none');
        	}
        },
        showErrors: function(errorMap, errorList) {
            this.defaultShowErrors();
            $('#login-nop-id-failed').removeClass('display-none');
            $(`#${namespace}captchaTextHelper`).addClass('display-none');
        },
    });
    
    $('.login-form__footer button').on('click', function() {
    	$(".alert").addClass('display-none');
    	
    	if ($(".alert-login").hasClass('display-none') == false) {
    		$(".alert-login").addClass('display-none').removeClass('failed');
    		$(".alert-login span").empty();
    	}
    	
    	let policyNo = $('#no_polis').val();
    	let profileId = $('#id_profile').val();
    	let captchaText = $(`#${namespace}captchaText`).val();
    	
    	if ($('form').valid()) {
    		$.ajax({
	           	url: verifyCaptchaURL,
				type: "POST",
				data: { policyNo: policyNo, profileId: profileId, captchaText: captchaText },
				dataType: "json",
	           	beforeSend: function () {
	           		$('#ModalLoading').modal('show');
	                $(".login-form__footer button").addClass("btn--disabled");
	                $(".login-form__footer button").css("pointer-events", "none");
	                $(".alert").addClass('display-none');
	            },
	           	success: function (response) {
					$(".alert").addClass('display-none');
					
					if (!response.status) {
						$(".alert-login").removeClass('display-none').addClass('failed');
		        		$(".alert-login span").empty().append(response.message);
		        		
		        		$(".login-form__footer button").removeClass("btn--disabled");
		            	$(".login-form__footer button").css("pointer-events", "auto");
						
						return;
					}
					
					if ($(".alert-login").hasClass('display-none') == false) {
		        		$(".alert-login").addClass('display-none').removeClass('failed');
		        		$(".alert-login span").empty();
		        	}
					
					parent.location.href = response.data.target;
	           	},
	           	complete: function() {
	           		$('#ModalLoading').modal('hide');
	           	}
	       	});
    	}
    });
});