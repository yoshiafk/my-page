var html = $("html");
var body = $("body");
var content = $("#content");
var lastScrollTopArrow = 0;
var scrollToTopButton = document.getElementById('scrollSticky');
const quotationModal = new bootstrap.Modal(document.getElementById('quotation-modal'));
const today = moment();
var maxBirthDate = today.clone().subtract(30, 'days');
var minBirthDate = today.clone().subtract(75, 'years');
var ageInDays = 0;
var ageInYears = 0;
var extraDays = 0;

html.addClass("html__agency");
body.addClass("body__agency body-white");
content.removeClass("bg-white");

//SESSION STORAGE NAME
var _smartActiveFormDetailSess = "SmartActiveFormDetail";
var _smartActiveCalculation = "SmartActiveCalculation";

//Mapping bulan singkatan ke nama lengkap dalam bahasa Indonesia 
//full name month untuk riplay
var bulanMapping = {
    "Jan": "Januari",
    "Feb": "Februari",
    "Mar": "Maret",
    "Apr": "April",
    "May": "Mei",
    "Mei": "Mei",
    "Jun": "Juni",
    "Jul": "Juli",
    "Aug": "Agustus",
    "Agu": "Agustus",
    "Agt": "Agustus",
    "Sep": "September",
    "Oct": "Oktober",
    "Okt": "Oktober",
    "Nov": "November",
    "Nop": "November",
    "Dec": "Desember",
    "Des": "Desember"
};


//untuk english
const monthMapping = {
    "Jan": "January", "Feb": "February", "Mar": "March", "Apr": "April", 
    "Mei": "May", "May": "May", "Jun": "June", "Jul": "July", 
    "Agu": "August", "Aug": "August", "Agt": "August", "Sep": "September", "Okt": "October", 
    "Oct": "October", "Nop": "November", "Nov": "November", 
    "Des": "December", "Dec": "December"
};

$(document).ready(function() {
	$('.brand-logo-wrapper a').click(function(e) {
		e.preventDefault();
		parent.location.href = this.href;
	});
	
	$(".trigger-collapse-promo").click(function() {
	    $("#collapseCodepromo").toggleClass('is-show');
	    $(this).toggleClass('is-active');
	    $('.sticky-plan__inner').toggleClass('is-active');
	});

	$(".trigger-collapse-plan-detail").click(function() {
	    $("#collapsePlandetail").toggleClass('is-show');
	    $('.sticky-plan__summary').toggleClass('is-hide');
	    $('.sticky-plan__inner').toggleClass('is-active-detail');
	    $('.detail-summary').toggleClass('is-active');
	    $('.code-promo').toggleClass('display-hidden');
	});

	$(".detail-summary").click(function() { 
	    $('.sticky-plan-collapse-summary').removeClass('is-show');
	    $('.sticky-plan__summary').removeClass('is-hide');
	    $('.sticky-plan__inner').removeClass('is-active-detail');
	    $(this).removeClass('is-active');
	    $('.code-promo').removeClass('display-hidden');
	});
	
	$(".check-link__mandatory").click(function() {
	    const isValid = checkValidationWarning();
	   
	    if (!isValid) {
	        scrollToInvalidField();
	    }
	});
	
	validateForm();
	
	$(document).on("input change select2:select", "[required]", validateForm);
    
    $(document).on('input', '#send_quotation_form input', function(e) {
	    let fieldName = e.target.name;
	    let fieldType = 'text';

	    // Define specific field types
	    if (fieldName.includes('email')) {
	        fieldType = 'email';
	    }

	    validateInput(e, fieldType);
	});
    
    const inputDates = document.querySelectorAll('.blocked-input-date');

    inputDates.forEach(input => {
        ['keydown', 'keypress', 'keyup', 'paste', 'drop'].forEach(event => {
            input.addEventListener(event, function(e) {
                e.preventDefault();
            });
        });
    });
});

window.addEventListener("scroll", function() {
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    if (scrollToTopButton) {
	    if (scrollTop > lastScrollTopArrow) {
	        scrollToTopButton.classList.remove("is-show");
	    } else {
	        scrollToTopButton.classList.add("is-show");
	    }
    }
    lastScrollTopArrow = scrollTop;
});

function displayLoading() {
	$('#mypage-loading-spinner-backdrop').removeClass('gohide');
}

function hideLoading() {
	$('#mypage-loading-spinner-backdrop').addClass('gohide');
}

//Update Session Storage Content
function updateSess(sessKey, key, value) {
	let existingSessData = sessionStorage.getItem(sessKey);
	if (existingSessData) {
		existingSessData = JSON.parse(existingSessData);
		existingSessData[key] = value;
		sessionStorage.setItem(sessKey, JSON.stringify(existingSessData));
	} else {
		let newSessData = {};
		newSessData[key] = value;
		sessionStorage.setItem(sessKey, JSON.stringify(newSessData));
	}
}

function getSessItem(sessName, sessKey) {
	let val = '';
	let _sess = sessionStorage.getItem(sessName);
	if(_sess) {
		_sess = JSON.parse(_sess);
		if(_sess[sessKey]) {
			val = _sess[sessKey];
		}
	}
	return val;
}

function validateForm() {
    let allValid = true;
    
    $(".container-form [required]").each(function () {
        let field = $(this);
        const elem = _step == 'two' ? ', .input-control-axa--wrap, .fileInput' : '';
        let wrapper = field.closest(`.sa-input-group-axa, .radio-wrapper${elem}`);

        if (field.is(":radio")) {
            let name = field.attr("name");
            let selectedRadio = $(`input[name="${name}"]:checked`);

            if (selectedRadio.length === 0) {
                allValid = false;
            } else {
                wrapper.removeClass("invalid-sa");
                if (_step == 'two') $(`input[name="${name}"]`).closest(".radio-icon, .radio-icon-input").find(".box-radio").removeClass("invalid-sa");
            }
        } else if (field.is("select")) {
            if (field.val().trim().length === 0) {
                allValid = false;
            } else {
            	field.next().removeClass("invalid-sa");
            }
        } else if (field.is(":file")) {
            if (field[0].files.length === 0 && !field.closest(".thumbnail-wrapper").find(".file-name").text()) {
                allValid = false;
            } else {
            	field.closest(".thumbnail-wrapper").find(".sa-thumbnail").removeClass("invalid-sa");
            }
        } else {
            if (field.val().trim().length === 0) {
                allValid = false;
            } else {
                wrapper.removeClass("invalid-sa");
            }
            
            if (field.attr("name") == 'age') {
            	let validAge = validateAge();
            	if (validAge) {
            		$('.text-message').text('');
            	} else {
            		allValid = false;
            	}
            }

            if (field.is('[type="email"]')) {
                const emailPattern = /^[a-zA-Z0-9._-]+@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,10}$/;
                if (!emailPattern.test(field.val().trim())) {
                    allValid = false;
                }
            }
        }
    });

    // Enable/disable submit button based on validation
    const submitButtons = $(".btn__next, #submit-quotation-btn");
    const labelWarning = $("#label__mandatory__warning");
    const enableSubmit = () => {
    	submitButtons.removeClass("btn--dark-grey").addClass("btn--dark-blue").css({ pointerEvents: "auto", opacity: "1" });
	};
	const disableSubmit = () => {
		submitButtons.removeClass("btn--dark-blue").addClass("btn--dark-grey").css({ pointerEvents: "none", opacity: "0.5" });
	};

    if (allValid) {
    	setTimeout(() => {
    		enableSubmit();
    	}, 500);
        labelWarning.addClass("display-hidden");
    } else {
    	setTimeout(() => {
        	disableSubmit();
    	}, 500);
    	labelWarning.removeClass("display-hidden");
    }
    
    if ((_step == 'one' || _step == 'two') && allValid) {
	    if (labelWarning.hasClass("display-hidden")) {
	    	setTimeout(() => {
	    		enableSubmit();
	    	}, 500);
	    } else {
	    	let sessData = sessionStorage.getItem(_smartActiveFormDetailSess);
	    	let qc;
	    	if (sessData) {
	    		sessData = JSON.parse(sessData);
	    		qc = sessData.QuoteCategory;
	    	}
	    	if ((_quoteCategory && _quoteCategory == 'edit') || qc == 'edit') {
	    		setTimeout(() => {
	    			enableSubmit();
			        labelWarning.addClass("display-hidden");
	    		}, 500);
	    	}
	    }
    }
    
    if (_step == 'two' && allValid) {
	    if ($('.fileInput').closest(".thumbnail-wrapper").find(".file-name").text()) {
	    	setTimeout(() => {
	    		$(".btn__next").removeClass("btn--dark-grey").addClass("btn--dark-blue").css({ pointerEvents: "auto", opacity: "1" });
	    	}, 500);
	    } else {
	    	setTimeout(() => {
	    		$(".btn__next").removeClass("btn--dark-blue").addClass("btn--dark-grey").css({ pointerEvents: "none", opacity: "0.5" });
	    	}, 500);
	    }
    }
}

function checkValidationWarning() {
    const selector = '.container-form [required]'; //cover div cari field required
    const requiredFields = document.querySelectorAll(selector);

    let isValid = true;

    requiredFields.forEach(function(field) {
    	const elem = _step == 'two' ? ', .input-control-axa--wrap, .fileInput' : '';
    	const wrapper = field.closest(`.sa-input-group-axa, .radio-wrapper${elem}`); // Menargetkan div pembungkus
    	
        // Cek apakah field adalah radio button
        if (field.type === 'radio') {
            const name = field.name;
            const selectedRadio = document.querySelector(`input[name="${name}"]:checked`);
            const boxRadios = document.querySelectorAll(`input[name="${name}"]`);

            if (!selectedRadio) {
                if (wrapper) wrapper.classList.add('invalid-sa');
                if (boxRadios && _step == 'two') {
            		boxRadios.forEach(radio => {
	                    const boxRadio = radio.closest('.radio-icon, .radio-icon-input')?.querySelector('.box-radio');
	                    if (boxRadio) boxRadio.classList.add('invalid-sa');
	                });
                }
                isValid = false;
            } else {
                if (wrapper) wrapper.classList.remove('invalid-sa');
                if (boxRadios && _step == 'two') {
	                boxRadios.forEach(radio => {
	                    const boxRadio = radio.closest('.radio-icon, .radio-icon-input')?.querySelector('.box-radio');
	                    if (boxRadio) boxRadio.classList.remove('invalid-sa');
	                });
                }
            }
        }
        
        // Cek apakah field adalah Select2
        else if (field.type === 'select-one') {
            const select2Wrapper = field.nextElementSibling; // Select2 container <span> setelah <select>
            
            if (!field.value.trim()) {
                if (select2Wrapper) select2Wrapper.classList.add('invalid-sa'); // Tambahkan class pada <span>
                isValid = false;
            } else {
                if (select2Wrapper) select2Wrapper.classList.remove('invalid-sa'); // Hapus class pada <span>
            }
        }
        
        else if (_step == 'two' && field.type === 'file') {
        	const imgWrapper = field.closest(".thumbnail-wrapper").querySelector(".sa-thumbnail");
        	
            if (!field.closest(".thumbnail-wrapper").querySelector(".file-name").textContent) {
            	if (imgWrapper) imgWrapper.classList.add('invalid-sa');
                isValid = false;
            } else {
            	if (imgWrapper) imgWrapper.classList.remove('invalid-sa');
            }
        }
        
        // Validasi untuk input lainnya
        else {
            if (!field.value.trim()) {
                if (wrapper) wrapper.classList.add('invalid-sa');
                isValid = false;
            } else {
                if (wrapper) wrapper.classList.remove('invalid-sa');
            }
            
            let validAge = validateAge();
            if (field.name == 'age' && ageInDays > 0 && validAge == false) {
            	if (wrapper) wrapper.classList.add('invalid-sa');
            	$('.text-message').text(`Usia anda ${ageInYears} tahun ${extraDays} hari tidak memenuhi syarat`);
            	isValid = false;
            }

            // Validasi khusus untuk email
            if (field.type === 'email') {
                const emailPattern = /^[a-zA-Z0-9._-]+@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,10}$/;
                const emailValue = field.value.trim();

                if (!emailPattern.test(emailValue)) {
                    if (wrapper) wrapper.classList.add('invalid-sa');
                    isValid = false;
                } else {
                    if (wrapper) wrapper.classList.remove('invalid-sa');
                }
            }
            
        }
    });

    return isValid;
}

function scrollToInvalidField() {
    // Cari semua elemen yang memiliki kelas invalid
    const invalidElements = document.querySelectorAll('.invalid-sa');

    if (invalidElements.length > 0) {
        // Temukan elemen invalid pertama yang tidak memiliki kelas ignoreValid
        for (let i = 0; i < invalidElements.length; i++) {
            const element = invalidElements[i];

            // Scroll ke elemen pertama yang tidak valid
            element.scrollIntoView({
                behavior: 'smooth',
                block: 'center'
            });
            element.focus(); // Fokus ke elemen
            break; // Keluar dari loop setelah fokus ke elemen yang valid
        }
    }
}

function validateInput(e, type) {
    let input = e.target;
    let value = input.value;
    
    const patterns = {
        text:  /[^A-Za-z ]/g,       // Allow only letters and spaces
        phone:   /[^0-9+]/g,           // Allow only numbers and +
        num:   /[^0-9]/g,           // Allow only numbers
        textNum:  /[^A-Za-z0-9]/g,  // Allow letters, numbers and spaces
        addr:  /[^A-Za-z0-9.,/ \-]/g  // Allow alphanumeric + ., and spaces
    };

    // Remove invalid characters based on type
    if (patterns[type]) {
    	input.value = value.replace(patterns[type], '');
    }
}

function validateAge() {
	return !(ageInDays < 30 || ageInYears > 75 || (ageInYears === 75 && extraDays > 0));
}

function getCheckedValue(selector) {
    const element = document.querySelector(selector + ':checked');
    return element ? element.value : '';
}

function getCheckedText(selector) {
    const element = document.querySelector(selector + ':checked');
    const label = document.querySelector(`label[for="${element.id}"]`);
    const textSpan = label.querySelector('span:last-child');
    return textSpan ? textSpan.textContent : '';
}

function getValue(selector) {
    const element = document.querySelector(selector);
    
    return element ? element.value : '';
}

function getText(selector) {
    const element = document.querySelector(selector);
    
    return element ? element.textContent : '';
}

function getTitleOption(selector) {
    const element = document.querySelector(selector);
    
    return element ? element.options[element.selectedIndex].text : '';
}

function convertCustomDate(dateString) {
    return dateString.replace(/\b(Jan|Feb|Mar|Apr|Mei|May|Jun|Jul|Agu|Aug|Agt|Sep|Okt|Oct|Nop|Nov|Des|Dec)\b/g, match => monthMapping[match]);
}

function openModalAlertBlocked() {
    document.getElementById('modal_alert').classList.remove('agency__hidden');
}

function closeModalAlertBlocked(redirectUrl = null) {
    const modal = document.getElementById('modal_alert');
    if (modal) {
        modal.classList.add('agency__hidden');
    }

    if (redirectUrl) {
        window.parent.location.href = redirectUrl;
    }
}

function openModal() {
    document.getElementById('modal_baca').classList.remove('agency__hidden');
}

function closeModal() {
    document.getElementById('modal_baca').classList.add('agency__hidden');
}

//Format Currency
function formatCurrency(amount, currency) {
  if (!amount) return null;

  currency = currency.toLowerCase();

  let formattedAmount = "-";
  if (currency === "idr") {
    formattedAmount = amount.toLocaleString("id-ID", {
      style: "currency",
      currency: "IDR",
      minimumFractionDigits: 0,
      maximumFractionDigits: 0,
    });
    formattedAmount = formattedAmount.replace("Rp", "IDR");
  }

  if (currency === "usd") {
    formattedAmount = amount.toLocaleString("en-US", {
      style: "currency",
      currency: "USD",
    });

    formattedAmount = formattedAmount.replace("$", "USD ");
  }

  return formattedAmount;
}

//Update summary premi di sidebar
function updatePlanSummarySidebar() {
	
	// reset
	
	$("#Summary-TotalBenefit").empty();
	$("#Summary-PolicyCost").empty();
	$("#Summary-Stampduty").empty();
	
	
	let _formDetail = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));
	let _calculation = JSON.parse(sessionStorage.getItem(_smartActiveCalculation));
	
	const choosenCurrency = _calculation.Currency;
	let premium = _calculation.Premium;
	let policyCost = _calculation.PolicyCost;
	let stampDuty = _calculation.StampDuty;
	let discount = _calculation.Discount;
	let discountAmount = _calculation.DiscountAmount;
	let netPremium = _calculation.NetPremium;
	
	  if(policyCost > 0) {
		  $("#Summary-PolicyCost").closest('.gohide').removeClass('gohide');
	  } else {
		  $("#Summary-PolicyCost").closest('.gohide').addClass('gohide');
	  }
	  
      if(discount > 0) {
      	$("#Summary-Discount").text(discount + "%");	
      } else {
      	$("#Summary-Discount").text('-');
      }
	
	$("#Summary-TotalBenefit").text(formatCurrency(premium, choosenCurrency));
	$("#Summary-PolicyCost").text(formatCurrency(policyCost, choosenCurrency));
	$("#Summary-Stampduty").text(formatCurrency(stampDuty, choosenCurrency));
	
	$("#Summary-NetPremium").text(formatCurrency(netPremium, choosenCurrency));
}

// Update Sticky Price
function updateStickyPrice() {
	  let _formDetail = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));
	  let _calculation = JSON.parse(sessionStorage.getItem(_smartActiveCalculation));
	  
	  // reset
	  $("#sticky-price-wrapper-original").empty();
	  $("#sticky-price-wrapper").empty();
	  $("#sticky-summary-total-main-benefit-premium").empty();
	  $("#sticky-summary-total-main-benefit-premium-mobile").empty();
	  $("#sticky-summary-total-additional-benefit-premium").empty()
	  $("#sticky-summary-total-additional-benefit-premium-mobile").empty()
	  $("#sticky-summary-policycost-wrapper").empty();
	  $("#sticky-summary-policycost-wrapper-mobile").empty();
	  $("#sticky-summary-stamp-wrapper").empty();
	  $("#sticky-summary-stamp-wrapper-mobile").empty();
	  
	  
	  const choosenCurrency = _calculation.Currency;
	  
	  let totalPremi = _calculation.NetPremium;
	  let totalMainBenefitPremium = _calculation.TotalMainBenefitPremium;
	  let totalAdditionalBenefitPremium = _calculation.TotalAdditionalBenefitPremium;
	  let policyCost = _calculation.PolicyCost;
	  let stampDuty = _calculation.StampDuty;
	  let netPremiumWithoutDiscount = _calculation.NetPremiumWithoutDiscount;
	  
	  if(totalAdditionalBenefitPremium > 0) {
		  $("#sticky-summary-total-additional-benefit-premium").closest('.additional-benefit-premium').removeClass('gohide');
		  $("#sticky-summary-total-additional-benefit-premium-mobile").closest('.additional-benefit-premium-mobile').removeClass('gohide');
	  } else {
		  $("#sticky-summary-total-additional-benefit-premium").closest('.additional-benefit-premium').addClass('gohide');
		  $("#sticky-summary-total-additional-benefit-premium-mobile").closest('.additional-benefit-premium-mobile').addClass('gohide');
	  }
	  
	  if(policyCost > 0) {
		  $("#sticky-summary-policycost-wrapper").closest('.gohide').removeClass('gohide');
		  $("#sticky-summary-policycost-wrapper-mobile").closest('.gohide').removeClass('gohide');
	  } else {
		  $("#sticky-summary-policycost-wrapper").closest('.gohide').addClass('gohide');
		  $("#sticky-summary-policycost-wrapper-mobile").closest('.gohide').addClass('gohide');
	  }
	  
	  if(stampDuty > 0) {
		  $("#sticky-summary-stamp-wrapper").closest('.gohide').removeClass('gohide');
		  $("#sticky-summary-stamp-wrapper-mobile").closest('.gohide').removeClass('gohide');
	  } else {
		  $("#sticky-summary-stamp-wrapper").closest('.gohide').addClass('gohide');
		  $("#sticky-summary-stamp-wrapper-mobile").closest('.gohide').addClass('gohide');
	  }
	  
//	  if(totalAdditionalBenefitPremium > 0) {
//		  $("#sticky-summary-total-additional-benefit-premium").closest('.gohide').removeClass('gohide');
//	  } else {
//		  $("#sticky-summary-total-additional-benefit-premium").closest('.gohide').addClass('gohide');
//	  }
	  
	  $("#sticky-price-wrapper").text(formatCurrency(totalPremi, choosenCurrency));
	  
	  $("#sticky-summary-total-main-benefit-premium").text(formatCurrency(totalMainBenefitPremium, choosenCurrency));
	  $("#sticky-summary-total-main-benefit-premium-mobile").text(formatCurrency(totalMainBenefitPremium, choosenCurrency));
	  
	  $("#sticky-summary-total-additional-benefit-premium").text(formatCurrency(totalAdditionalBenefitPremium, choosenCurrency));
	  $("#sticky-summary-total-additional-benefit-premium-mobile").text(formatCurrency(totalAdditionalBenefitPremium, choosenCurrency));
	  
	  $("#sticky-summary-policycost-wrapper").text(formatCurrency(policyCost, choosenCurrency));
	  $("#sticky-summary-policycost-wrapper-mobile").text(formatCurrency(policyCost, choosenCurrency));
	  
	  $("#sticky-summary-stamp-wrapper").text(formatCurrency(stampDuty, choosenCurrency));
	  $("#sticky-summary-stamp-wrapper-mobile").text(formatCurrency(stampDuty, choosenCurrency));
	  
	  $("#sticky-summary-totalpremi-wrapper").text(formatCurrency(totalPremi, choosenCurrency));
	  $("#sticky-summary-totalpremi-wrapper-mobile").text(formatCurrency(totalPremi, choosenCurrency));
	  
	    if(_calculation.Discount > 0) {
	    	
	    	$("#sticky-price-wrapper-original").text(formatCurrency(netPremiumWithoutDiscount, choosenCurrency));
	    	
	    	$('#sticky-summary-totalpremi-wrapper-withoutdiscount').removeClass("gohide");
	    	$('#sticky-summary-totalpremi-wrapper-withoutdiscount-mobile').removeClass("gohide");
	    	$('#sticky-summary-totalpremi-wrapper-withoutdiscount').text(formatCurrency(netPremiumWithoutDiscount, choosenCurrency));
	    	$('#sticky-summary-totalpremi-wrapper-withoutdiscount-mobile').text(formatCurrency(netPremiumWithoutDiscount, choosenCurrency));
	    } else {
	    	
	    	$("#sticky-price-wrapper-original").empty();
	    	
	    	$('#sticky-summary-totalpremi-wrapper-withoutdiscount').addClass("gohide");
	    	$('#sticky-summary-totalpremi-wrapper-withoutdiscount-mobile').addClass("gohide");
	    	$('#sticky-summary-totalpremi-wrapper-withoutdiscount').empty();
	    	$('#sticky-summary-totalpremi-wrapper-withoutdiscount-mobile').empty();
	    }
}

function previewImg(param, file = null) {
	if (!param.preview) return;

    const name = param.name || 'Kartu Identitas';
    const wrapper = $('.thumbnail-wrapper');
    const fileNameSpan = wrapper.find('.file-name');
    const thumbnail = wrapper.find('.sa-thumbnail');

    const setPreview = (src) => {
        thumbnail.attr('src', src);
        fileNameSpan.text(name);
    };

    if (file) {
        const reader = new FileReader();
        reader.onload = (e) => setPreview(e.target.result);
        reader.readAsDataURL(file);
    } else {
        setPreview(param.preview);
    }
}

//Remove Promo Code when calculate failed
function removePromoCode() {
  let sessData = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));
  if (sessData && sessData.PromoCode) {
    delete sessData.PromoCode;
  }
  
  sessionStorage.setItem(_smartActiveFormDetailSess, JSON.stringify(sessData));
  document.querySelector('input[name="PromoCode"]').value = "";
  document.querySelector('input[name="PromoCodeSidebar"]').value = "";
}

document.addEventListener("DOMContentLoaded", function () {
	// Clear Promo Code
	let clearPromoCodeBtn = document.querySelector("#clear-promo-code-btn");
	
	if(clearPromoCodeBtn) {
		document.querySelector("#clear-promo-code-btn").addEventListener('click', function() {
			document.querySelector('input[name="PromoCode"]').value = "";
			document.querySelector('input[name="PromoCodeSidebar"]').value = "";
			document.querySelector("#promo-code-btn").click(); // supaya calculate ke trigger lagi
//			document.querySelector(".trigger-collapse-promo").click();// tutup sticky promocode dan tampilkan summary
		});
	}
});