var loadProductSummaryDataURL = window.loadProductSummaryDataURL;
var loadTrxURL = window.loadTrxURL;

$(document).ready(function() {
	$(".link-payment").on('click', function() {
		$.ajax({
	       	url: loadTrxURL,
			type: "GET",
			dataType: "json",
	       	beforeSend: function () {
	       		$(".link-payment").addClass("btn--disabled");
	       		$(".link-payment").css("pointer-events", "none");
	        },
	       	success: function (response) {
	       		if (!response.status) {
	       			if (response.data?.target) {
	   					parent.location.href = response.data.target;
	   					
	   					return;
	       			}
	       			
					alert(response.message)
					
					return;
				}
	       		
	       		parent.location.href = response.data.target;
	       	},
	       	complete: function() {
	       		$(".link-payment").removeClass("btn--disabled");
	       		$(".link-payment").css("pointer-events", "auto");
	       	}
		});
	});
});

fetchData();

function fetchData() {
	$.ajax({
       	url: loadProductSummaryDataURL,
		type: "GET",
		dataType: "json",
       	beforeSend: function () {
       		$('.link-payment').addClass("btn--disabled");
       		$('.link-payment').css("pointer-events", "none");
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
			
			$("div.summary-pay__table tbody").empty();
			$("div.summary-pay__policy span").each(function(index) {
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
			$("div.summary-pay__heading span").text(response.data.policyPeriod);
			$("div.summary-pay__product-name span").text(response.data.productName);
			$("div.summary-pay__product-desc span").each(function(index) {
				switch(index) {
		            case 0:
		                $(this).text(response.data.policyNumber);
		                break;
		            case 1:
		            	if (response.data.sumInsured == 0) {
		                    $(this).closest("div.col-product-desc").remove();
		                } else {
		                    $(this).text(formatToIDR(response.data.sumInsured));
		                }
		                break;
		        }
			});
			response.data.policies.forEach(function(item, index) {
		        var row = $("<tr></tr>");
		        row.append(`
	                <td>${index + 1}</td>
	                <td>${item.dueDate}</td>
	                <td>${formatToIDR(item.amount)}</td>
	                <td class="${item.status === 'SUDAH DIBAYARKAN' ? 'paid-off' : (item.status === 'WAITING PAYMENT' || item.status === 'BELUM DIBAYARKAN') ? 'waiting-payment' : ''}">${item.status === 'WAITING PAYMENT' ? 'BELUM DIBAYARKAN' : item.status}</td>
	            `);

		        $("div.summary-pay__table tbody").append(row);
		    });
		
			const labelMapping = {
			    'Gross Premium': 'grossPremium',
			    'Discount': 'discount',
			    'Premi Netto': 'nettoPremium',
			    'Policy Cost': 'policyCost',
			    'Stamp Duty': 'stampDuty',
			    'Tahap Cicilan': 'installment',
			    'Premi Belum Jatuh Tempo': 'unpaid'
			};
			
			$("div.summary_payment-body li").each(function() {
			    const label = $(this).find("span:first").text().trim();
			    if (labelMapping[label] !== undefined) {
			    	if (labelMapping[label] == "discount") {
			    		$(this).find("span:nth-of-type(2)").text("(" + formatToIDR(response.data.settlement[labelMapping[label]]).replace("-", "") + ")");
			    	} else {
				        $(this).find("span:nth-of-type(2)").text(formatToIDR(response.data.settlement[labelMapping[label]]));
			    	}
			    }
			});
			$("div.summary-footer__total span:nth-of-type(2)").text(formatToIDR(response.data.settlement.amount));
			if (response.data.total > 1 && response.data.settlement.amount > 0) {
				$("div.summary-footer li").each(function() {
					const label = $(this).find("span:first").text().trim();
				    if (labelMapping[label] !== undefined) {
				    	if (labelMapping[label] == "installment") {
				    		$(this).find("span:nth-of-type(2)").html(response.data.settlement[labelMapping[label]].replace("of", "/").replace(/(\d+)$/, "<strong>$1</strong>"));
				    	} else {
					        $(this).find("span:nth-of-type(2)").text(formatToIDR(response.data.settlement[labelMapping[label]]));
				    	}
				    }
				});
			} else {
				$(".installment-desc").remove();
			}
			if (response.data.settlement.amount != 0) {
				$('.link-payment').removeClass("btn--disabled");
	       		$('.link-payment').css("pointer-events", "auto");
			}
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