var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency body-white");

var firstLoadStep1 = true;
var firstLoadStep2 = false;
var continueQuote = false;

  let ajaxQueue = [];
  let ajaxBusy = false;

window.addEventListener('load', (event) => {
  if (performance.getEntriesByType("navigation")[0].type === "navigate") {
    firstLoadStep2 = true;
  }
});

// SESSION STORAGE NAME
var _smartTravelInternationalFormDetailSess = "SmartTravelInternationalFormDetail";
var _smartTravelInternationalPlansSess = "SmartTravelInternationalPlans";
var _smartTravelInternationalCalculation = "SmartTravelInternationalCalculation";
var currentStep = 0;

function showModalSanctionCountry() {
	  const sanctionCountryModal = new bootstrap.Modal(document.getElementById('sanctionCountryModal'), {
		  backdrop: 'static'
	  });
	  sanctionCountryModal.show();
}

// Update Session Storage Content
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

function formatStringToList(str) {
	
	const trimmedStr = str.trim();
	
    if (trimmedStr === '') {
        return '';
    }
    
    if (!trimmedStr.includes('\n')) {
        return `${trimmedStr.trim()}`;
    }

    const lines = trimmedStr.split('\n').filter(line => line.trim() !== '');
    const listItems = lines.map(line => `<li>${line.trim()}</li>`).join('');
    return `<ul style="list-style:disc; margin: 0 0 0 15px;">${listItems}</ul>`;
}

// Format Currency
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

// Update summary premi di sidebar
function updatePlanSummarySidebar() {
  if (sessionStorage.getItem(_smartTravelInternationalCalculation)) {
    let formDetail = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    let choosenPlan = formDetail.ChoosenPlan;

    let calculation = JSON.parse(sessionStorage.getItem(_smartTravelInternationalCalculation));

    for (const plan of calculation.AvailablePlans) {
      if (plan.PlanName === choosenPlan) {
        $("#PlanSummary-PlanName").text("Plan " + plan.PlanName);

        let totalDaysDisplay = calculation.TravelType.toLowerCase() === "annual" ? "1 Tahun" : calculation.TotalDays + " Hari";
        $("#PlanSummary-TotalDays").text(totalDaysDisplay);
        $("#PlanSummary-SubTotalPremiPrice").text(formatCurrency(plan.TotalMainBenefitPremium + plan.TotalAdditionalBenefitPremium, calculation.Currency));

        $("#PlanSummary-PolicyCost").text(formatCurrency(calculation.PolicyCost, calculation.Currency));
        $("#PlanSummary-Stamp").text(formatCurrency(calculation.Stamp, calculation.Currency));
        
        if(plan.Discount > 0) {
        	$("#PlanSummary-TotalPremiPrice-discount").text(plan.Discount + "%");	
        } else {
        	$("#PlanSummary-TotalPremiPrice-discount").text('-');
        }
       
        // total price
        let totalPrice = plan.NetPremium;
        let totalPremiInIDR = plan.NetPremiumIDR;
        $("#PlanSummary-TotalPremiPrice").text(formatCurrency(totalPrice, calculation.Currency));

        if (formDetail.Currency == "usd") {
          $(".PlanSummary-TotalPremiPrice-idr-wrapper").removeClass("gohide");
          $("#PlanSummary-TotalPremiPrice-idr").text(formatCurrency(totalPremiInIDR, "idr"));
        } else {
          $(".PlanSummary-TotalPremiPrice-idr-wrapper").addClass("gohide");
          $("#PlanSummary-TotalPremiPrice-idr").empty();
        }
      }
    }
  }
}

// Update sticky price wrapper
function updateStickyPrice(debug=false) {

  // console.log("updateStickyPrice: " + debug);
  let _formDetail = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
  let _calculation = JSON.parse(sessionStorage.getItem(_smartTravelInternationalCalculation));

  $("#select-plan-sticky").empty();

  let optionPlan = "";
  _calculation.AvailablePlans.forEach((plan) => {
    let _isSelected = _formDetail.ChoosenPlan === plan.PlanName ? "selected" : "";
    optionPlan += '<option value="' + plan.PlanName + '" ' + _isSelected + ">" + plan.PlanName + "</option>";
  });

  $("#select-plan-sticky").html(optionPlan);

  // reset
  $("#sticky-summary-total-adult-wrapper").text("-");
  $("#sticky-summary-total-adult-wrapper-mobile").text("-");
  $("#sticky-summary-total-adult-amountprice-wrapper").text("-");
  $("#sticky-summary-total-adult-amountprice-wrapper-mobile").text("-");
  
  $("#sticky-summary-policycost-wrapper").text("");
  $("#sticky-summary-policycost-wrapper-mobile").text("");
  $("#sticky-summary-stamp-wrapper").text("");
  $("#sticky-summary-stamp-wrapper-mobile").text("");

  const wrapper = $("#sticky-price-wrapper");
  let choosenPlan = _formDetail.ChoosenPlan;

  const choosenCurrency = _formDetail.Currency;
  const choosenPlanDetail = _calculation.AvailablePlans.filter((plan) => plan.PlanName === choosenPlan);

  if (choosenPlanDetail.length > 0) {

    $('#sticky-plan-name').text("Plan " + choosenPlanDetail[0].PlanName);
	  
	  // POPUP DAN HARGA CORET DI SUMMARY APABILA ADA PROMOCODE (DISKON
	  if(_calculation.PromoCode && choosenPlanDetail.Discount !== 0) {
//		  const promoCodeModal = new bootstrap.Modal(document.getElementById('promocode-modal'));
//		  promoCodeModal.show();
		  
		  let currentPromoCode = sessionStorage.getItem("pc");
		  
		  if(currentPromoCode === null) {
			  sessionStorage.setItem("pc", _calculation.PromoCode);
		  } else if(currentPromoCode !== _calculation.PromoCode) {
			  sessionStorage.setItem("pc", _calculation.PromoCode);
		  }
			 
		  $("#sticky-price-wrapper-original").empty();
		  let totalPremiWithoutDiscount = choosenPlanDetail[0].NetPremiumWithoutDiscount;
		  $("#sticky-price-wrapper-original").text(formatCurrency(totalPremiWithoutDiscount, choosenCurrency));
		  
		  if(currentPromoCode !== _calculation.PromoCode) {
			  alert("Kode promo " +_calculation.PromoCode+ " berhasil dipakai.");  
		  }
	  } else {
		  $("#sticky-price-wrapper-original").empty();
		  sessionStorage.removeItem("pc");
	  }
	  
//    let totalPremi = _calculation.Stamp + _calculation.PolicyCost + choosenPlanDetail[0].TotalMainBenefitPremium + choosenPlanDetail[0].TotalAdditionalBenefitPremium;
	  let totalPremi = choosenPlanDetail[0].NetPremium;
    // console.log("Total Premi yang Muncul di Display: " + totalPremi);

    $("#sticky-price-wrapper").text(formatCurrency(totalPremi, choosenCurrency));

//    let totalPremiAdult = choosenPlanDetail[0].TotalAdultMainBenefitPremium + choosenPlanDetail[0].TotalAdultAdditionalBenefitPremium;
    let totalPremiAdult = choosenPlanDetail[0].PremiumAdult;
    $("#sticky-summary-total-adult-wrapper").text(_calculation.TotalAdult + " Dewasa");
    $("#sticky-summary-total-adult-wrapper-mobile").text(_calculation.TotalAdult + " Dewasa");
    $("#sticky-summary-total-adult-amountprice-wrapper").text(formatCurrency(totalPremiAdult, choosenCurrency));
    $("#sticky-summary-total-adult-amountprice-wrapper-mobile").text(formatCurrency(totalPremiAdult, choosenCurrency));

    // jika ada/tidak ada jumlah anak
    if (choosenPlanDetail[0].TotalChildMainBenefitPremium < 1) {
    	$("#sticky-summary-total-child-container").closest('ul').addClass('gohide');
    	$("#sticky-summary-total-child-container-mobile").closest('li').addClass('gohide');
    	
    	$("#sticky-summary-total-child-container").text("");
    	$("#sticky-summary-total-child-container-mobile").text("");
    	
    	$("#sticky-summary-total-child-amountprice-wrapper").text("");
    	$("#sticky-summary-total-child-amountprice-wrapper-mobile").text("");
    } else {
    	$("#sticky-summary-total-child-container").closest('ul').removeClass('gohide');
    	$("#sticky-summary-total-child-container-mobile").closest('li').removeClass('gohide');
    	
    	$("#sticky-summary-total-child-container").text(_calculation.TotalChild + " Anak");
    	$("#sticky-summary-total-child-container-mobile").text(_calculation.TotalChild + " Anak");
    	let totalPremiChild = choosenPlanDetail[0].PremiumChild;
    	$("#sticky-summary-total-child-amountprice-wrapper").text(formatCurrency(totalPremiChild, choosenCurrency));
    	$("#sticky-summary-total-child-amountprice-wrapper-mobile").text(formatCurrency(totalPremiChild, choosenCurrency));
    }

    $("#sticky-summary-stamp-wrapper").text(formatCurrency(_calculation.Stamp, choosenCurrency));
    $("#sticky-summary-stamp-wrapper-mobile").text(formatCurrency(_calculation.Stamp, choosenCurrency));

    // total premi
    $("#sticky-summary-totalpremi-wrapper").text(formatCurrency(totalPremi, choosenCurrency));
    $("#sticky-summary-totalpremi-wrapper-mobile").text(formatCurrency(totalPremi, choosenCurrency));

    if(_calculation.Discount > 0) {
    	$('#sticky-summary-totalpremi-wrapper-discounted').removeClass("gohide");
    	$('#sticky-summary-totalpremi-wrapper-discounted-mobile').removeClass("gohide");
    	$('#sticky-summary-totalpremi-wrapper-discounted').text(formatCurrency(choosenPlanDetail[0].NetPremiumWithoutDiscount, choosenCurrency));
    	$('#sticky-summary-totalpremi-wrapper-discounted-mobile').text(formatCurrency(choosenPlanDetail[0].NetPremiumWithoutDiscount, choosenCurrency));
    } else {
    	$('#sticky-summary-totalpremi-wrapper-discounted').addClass("gohide");
    	$('#sticky-summary-totalpremi-wrapper-discounted-mobile').addClass("gohide");
    	$('#sticky-summary-totalpremi-wrapper-discounted').empty();
    	$('#sticky-summary-totalpremi-wrapper-discounted-mobile').empty();
    }

    if (choosenCurrency === "usd") {
//      let totalPremiInIDR = choosenPlanDetail[0].TotalMainBenefitPremiumInIDR + choosenPlanDetail[0].TotalAdditionalBenefitPremiumInIDR + _calculation.StampInIDR + _calculation.PolicyCostInIDR;
    	let totalPremiInIDR = choosenPlanDetail[0].NetPremiumIDR;
      $(".sticky-summary-totalpremi-wrapper-idr").removeClass("gohide");
      $(".sticky-summary-totalpremi-wrapper-idr-mobile").removeClass("gohide");
      $(".sticky-summary-totalpremi-wrapper-idr").text(formatCurrency(totalPremiInIDR, "idr"));
      $(".sticky-summary-totalpremi-wrapper-idr-mobile").text(formatCurrency(totalPremiInIDR, "idr"));
    } else {
      $(".sticky-summary-totalpremi-wrapper-idr").addClass("gohide");
      $(".sticky-summary-totalpremi-wrapper-idr-mobile").addClass("gohide");
      $(".sticky-summary-totalpremi-wrapper-idr").empty();
      $(".sticky-summary-totalpremi-wrapper-idr-mobile").empty();
    }
  }
}

$(document)
  .off("change", '[name="select-plan-sticky"]')
  .on("change", '[name="select-plan-sticky"]', function (e) {
    let _val = $(this).val();

    if (currentStep === 1) {
      $('a.choose-plan-btn[data-plan="' + _val + '"]').click();
    } else if (currentStep === 2) {
      $("#plan-option").val(_val).trigger("change");
    }
  });

// SEND QUOTATION
$("#submit-quotation-btn").on("click", function (e) {
  e.preventDefault();
  console.log("Testing....");
});

function displayLoading() {
	$('#mypage-loading-spinner-backdrop').removeClass('gohide');
}

function hideLoading() {
	$('#mypage-loading-spinner-backdrop').addClass('gohide');
}