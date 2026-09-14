var loadPaymentDataURL = window.loadPaymentDataURL;
var loadPaymentInternalDataURL = window.loadPaymentInternalDataURL;
var loadPaymentDokuDataURL = window.loadPaymentDokuDataURL;

$(document).ready(function(){
	$('.radio-custom').on('change', function() {
		if ($(this).attr('id') == 'va-mandiri' || $(this).attr('id') == 'va-bca') {
			$('.payment-internal').removeClass('display-none');
			$('.payment-doku').addClass('display-none');
		} else {
			$('.payment-internal').addClass('display-none');
			$('.payment-doku').removeClass('display-none');
		}
	});
	
	$('.payment-internal').on('click', function() {
		const target = $('.radio-custom:checked').data('target');
		
		if (!target) {
			alert(`Harap pilih metode pembayaran terlebih dahulu.`);
			
			return;
		}
		
		$.ajax({
			url: loadPaymentInternalDataURL,
			type: "post",
			data: { target: target },
			dataType: "json",
			beforeSend: function () {
	            $('.payment-internal').addClass("btn--disabled");
	            $('.payment-internal').css("pointer-events", "none");
	        },
			success: function (response) {
				if (!response.status) {
					if (response.data?.target) {
						alert(response.message);
						parent.location.href = response.data.target;
						
						return;
	       			}
					
					alert(response.message);
					
					return;
				}
				
				parent.location.href = response.data.target;
			},
			complete: function() {
				$('.payment-internal').removeClass("btn--disabled");
	       		$('.payment-internal').css("pointer-events", "auto");
			}
		});
	});
	
	$('.payment-doku').on('click', function() {
		const target = $('.radio-custom:checked').data('target');
		
		if (!target) {
			alert(`Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan pilih metode pembayaran terlebih dahulu.`);
			
			return;
		}
		
		$.ajax({
			url: loadPaymentDokuDataURL,
			type: "post",
			data: { target: target },
			dataType: "json",
			beforeSend: function () {
	            $('.payment-doku').addClass("btn--disabled");
	            $('.payment-doku').css("pointer-events", "none");
	        },
			success: function (response) {
				if (!response.status) {
					if (response.data?.target) {
						alert(response.message);
						parent.location.href = response.data.target;
						
						return;
	       			}
					
					alert(response.message);
					
					return;
				}
				
				parent.location.href = response.data.paymentUrl;
			},
			complete: function() {
				$('.payment-doku').removeClass("btn--disabled");
	       		$('.payment-doku').css("pointer-events", "auto");
			}
		});
	});
});

fetchData();

function fetchData() {
	$.ajax({
       	url: loadPaymentDataURL,
		type: "GET",
		dataType: "json",
       	success: function (response) {
			if (!response.status) {
				parent.location.href = response.data.target;
				
				return;
			}
			
			$("div.summary_payment-body span").each(function(index) {
		        switch(index) {
		            case 0:
		                $(this).text(response.data.fullName);
		                break;
		            case 1:
		            	if (!response.data.emailAddress) {
		                    $(this).closest('li').remove();
		                } else {
		                    $(this).text(response.data.emailAddress);
		                }
		                break;
		            case 2:
		            	if (!response.data.mobileNumber) {
		                    $(this).closest('li').remove();
		                } else {
		                    $(this).text(response.data.mobileNumber);
		                }
		                $(this).text(response.data.mobileNumber);
		                break;
		        }
		    });
			$("div.summary_payment-heading span").text(`Nomor Invoice : ${response.data.invoiceNumber}`);
			$("div.summary_payment-heading li:nth-of-type(2)").html(`<strong>${formatToIDR(response.data.amount)}</strong>`);
     	}
   	});
}

function formatToIDR(amount) {
    const formattedCurrency = new Intl.NumberFormat("id-ID", {
        style: "currency",
        currency: "IDR",
        minimumFractionDigits: 0,
        maximumFractionDigits: 0
    }).format(amount);
    return formattedCurrency;
}