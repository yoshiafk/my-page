var loadPaymentStatusDataURL = window.loadPaymentStatusDataURL;

$(document).ready(function(){
	$(".link-product").click(function(e) {
		e.preventDefault();
		parent.location.href = this.href;
	});
});

fetchData()

function fetchData() {
	$.ajax({
       	url: loadPaymentStatusDataURL,
		type: "GET",
		dataType: "json",
       	success: function (response) {
			if (!response.status) {
				parent.location.href = response.data.target;
				
				return;
			}
			
			$("div.information-transfer span").each(function(index) {
		        switch(index) {
		            case 0:
		                $(this).html(`<strong>${response.data.channel}</strong>`);
		                break;
		            case 1:
		                break;
		            case 2:
		                break;
		            case 3:
		                $(this).html(`<strong>${formatToIDR(response.data.amount)}</strong>`);
		                break;
		        }
		    });
			$('#v-account').html(`<strong>${response.data.vaNumber}</strong>`)
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

function copyText(elem) {
	let element = document.getElementById(elem);
	let elementText = element.value || element.innerText || element.textContent;;
	let o = document.createElement("textarea");
	
	o.style.position = "fixed";
	o.style.left = "0";
	o.style.top = "0";
	o.style.opacity = "0";
	o.value = elementText;
	
	document.body.appendChild(o);
	o.focus();
	o.select();
	document.execCommand("copy");
	document.body.removeChild(o);
	
	alert("Nomor virtual account sudah tersalin");
}