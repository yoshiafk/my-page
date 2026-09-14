$(document).ready(function () {

  $(".brand-logo-link").on("click", function (e) {
    //		let mypageUserURL = sessionStorage.getItem("mypageUserURL");
    //		if(mypageUserURL) {
    //			window.location.href = window.mypageUserURL;
    //		}
  });

  var calculateStat = false;
  currentStep = 2;

  // Read Session Storage
  let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
  var benefitPlanDescription = [];

  var travellerTypeChange = false;
  var duoClicked = false;

  // Travel type init
  $("#travel-type-step2").select2({
    dropdownParent: "#travel-type-wrapper",
    placeholder: "Perjalanan Tunggal",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $("#destination").select2({
    dropdownParent: "#destination-wrapper",
    placeholder: "Worldwide including Schengen Countries",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  // Plan option init
  $("#plan-option").select2({
    dropdownParent: "#plan-option-wrapper",
    placeholder: "Pilih Plan",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $("#select-adult").select2({
    dropdownParent: "#select-adult-wrapper",
    placeholder: "",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $("#select-kid").select2({
    dropdownParent: "#select-kid-wrapper",
    placeholder: "",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $("#select-plan-sticky").select2({
    dropdownParent: "#select-plan-wrapper",
    placeholder: "Pilih Plan",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $("#select-anchor").select2({
    dropdownParent: "#select-anchor-wrapper",
    placeholder: "",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  // CALCULATE PREMI
  function calculatePremi(dontupdatebenefit = false, callback = false, debug = false) {
    console.log("RUN CALCULATE PREMI: " + debug);

    if (!calculateStat) {
      return;
    }

    var dontupdatebenefit = dontupdatebenefit || false;
    let existingSession = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    var promoCodeIncluded = false;
    if (JSON.parse(existingSession).PromoCode) {
      promoCodeIncluded = true;
    }

    $.ajax({
      url: _apiURL + "/o/api/sti/calculate",
      type: "POST",
      contentType: "application/json",
      data: existingSession,
      success: function (response) {
        $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
        if (response.Status) {
          if (response.Data.Calculation.AvailablePlans) {
            // DEBUG
            // let testdebug = response.Data.Calculation.AvailablePlans;
            // testdebug = testdebug.filter((item) => item.PlanName === "Gold");
            // console.log(testdebug);

            if (response.Data.Calculation.AvailablePlans.length > 0) {
              // add calculation detail to session storage
              sessionStorage.setItem(_smartTravelInternationalCalculation, JSON.stringify(response.Data.Calculation));

              let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

              if (sessData && typeof sessData["ChoosenPlan"] === "undefined") {
                // jika pas diload tidak ada ChoosenPlan. ini untuk B2B dan B2B2C
                let _planOptionHtml = "";
                for (const plan of response.Data.Calculation.AvailablePlans) {
                  let selectedStat = plan.PlanName === "Platinum" ? "selected" : "";
                  _planOptionHtml += '<option value="' + plan.PlanName + '"' + selectedStat + ">" + plan.PlanName + "</option>";
                }
                $("#plan-option").html(_planOptionHtml).val("Platinum").trigger("change");
              } else {
                updateMainBenefitListSection();

                if (!dontupdatebenefit) {
                  updateCheckBoxBenefit();
                }

                updateStickyPrice("updateStickyPrice: Di dalam calculatePremi");
                updatePlanSummarySidebar();
              }
            }
          }
        } else {
          // if response status is 0
          // alert(response.Message ? response.Message : "Calculate Failed");
          if (promoCodeIncluded) {
            if (typeof response.PromoCodeResponse !== "undefined") {
              if (response.PromoCodeResponse) {
                removePromoCode();
                alert(response.Message ? response.Message : "Calculate Failed");
                return false;
              }
            }
          }
        }

        if (typeof callback === "function") callback();
      },
      error: function (xhr, status, error) {
        $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
        console.error("Error:", error);
      },
    });
  }

  // CALCULATE PREMI NEW
  //   function _calculatePremiNew(dontupdatebenefit = false, callback = false, debug = false) {
  //     console.log("RUN CALCULATE PREMI: " + debug);

  //     if (!calculateStat) {
  //       return;
  //     }

  //     var dontupdatebenefit = dontupdatebenefit || false;
  //     let existingSession = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
  //     var promoCodeIncluded = false;
  //     if (JSON.parse(existingSession).PromoCode) {
  //       promoCodeIncluded = true;
  //     }

  //     $.ajax({
  //       url: _apiURL + "/o/api/sti/calculate",
  //       type: "POST",
  //       contentType: "application/json",
  //       data: existingSession,
  //       success: function (response) {
  //         $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
  //         if (response.Status) {
  //           if (response.Data.Calculation.AvailablePlans) {
  //             // DEBUG
  //             let testdebug = response.Data.Calculation.AvailablePlans;
  //             testdebug = testdebug.filter((item) => item.PlanName === "Gold");
  //             console.log(testdebug);

  //             if (response.Data.Calculation.AvailablePlans.length > 0) {
  //               // add calculation detail to session storage
  //               sessionStorage.setItem(_smartTravelInternationalCalculation, JSON.stringify(response.Data.Calculation));

  //               let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

  //               if (sessData && typeof sessData["ChoosenPlan"] === "undefined") {
  //                 // jika pas diload tidak ada ChoosenPlan. ini untuk B2B dan B2B2C
  //                 let _planOptionHtml = "";
  //                 for (const plan of response.Data.Calculation.AvailablePlans) {
  //                   let selectedStat = plan.PlanName === "Platinum" ? "selected" : "";
  //                   _planOptionHtml += '<option value="' + plan.PlanName + '"' + selectedStat + ">" + plan.PlanName + "</option>";
  //                 }
  //                 $("#plan-option").html(_planOptionHtml).val("Platinum").trigger("change");
  //               } else {
  //                 updateMainBenefitListSection();

  //                 if (!dontupdatebenefit) {
  //                   updateCheckBoxBenefit();
  //                 }

  //                 updateStickyPrice();
  //                 updatePlanSummarySidebar();
  //               }
  //             }
  //           }
  //         } else {
  //           // if response status is 0
  //           // alert(response.Message ? response.Message : "Calculate Failed");
  //           if (promoCodeIncluded) {
  //             if (typeof response.PromoCodeResponse !== "undefined") {
  //               if (response.PromoCodeResponse) {
  //                 removePromoCode();
  //                 alert(response.Message ? response.Message : "Calculate Failed");
  //                 return false;
  //               }
  //             }
  //           }
  //         }

  //         if (typeof callback === "function") callback();
  //       },
  //       error: function (xhr, status, error) {
  //         $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
  //         console.error("Error:", error);
  //       },
  //     });
  //   }

  function calculatePremiNew(dontupdatebenefit = false, callback = false, debug = false) {
    ajaxQueue.push({ dontupdatebenefit, callback, debug });
    runQueue();
  }

  // RUN QUEUE
  function runQueue() {
    if (ajaxBusy || ajaxQueue.length === 0) {
      // console.log("NO AJAX");
      return;
    }

    if (!calculateStat) {
      return;
    }

    // console.log("---------------");
    // console.log(ajaxQueue);

    ajaxBusy = true;
    const { _dontupdatebenefit, callback, debug } = ajaxQueue.shift();
    // console.log("RUN CALCULATE PREMI: " + debug);
    // console.log("---------------");

    var dontupdatebenefit = _dontupdatebenefit || false;
    let existingSession = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    var promoCodeIncluded = false;
    if (JSON.parse(existingSession).PromoCode) {
      promoCodeIncluded = true;
    }

    $.ajax({
      url: _apiURL + "/o/api/sti/calculate",
      type: "POST",
      contentType: "application/json",
      data: existingSession,
      success: function (response) {
        $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
        if (response.Status) {
          if (response.Data.Calculation.AvailablePlans) {
            // DEBUG
            // let testdebug = response.Data.Calculation.AvailablePlans;
            // testdebug = testdebug.filter((item) => item.PlanName === "Gold");
            // console.log(testdebug);

            if (response.Data.Calculation.AvailablePlans.length > 0) {
              // add calculation detail to session storage
              sessionStorage.setItem(_smartTravelInternationalCalculation, JSON.stringify(response.Data.Calculation));

              let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

              if (sessData && typeof sessData["ChoosenPlan"] === "undefined") {
                // jika pas diload tidak ada ChoosenPlan. ini untuk B2B dan B2B2C
                let _planOptionHtml = "";
                for (const plan of response.Data.Calculation.AvailablePlans) {
                  let selectedStat = plan.PlanName === "Platinum" ? "selected" : "";
                  _planOptionHtml += '<option value="' + plan.PlanName + '"' + selectedStat + ">" + plan.PlanName + "</option>";
                }
                $("#plan-option").html(_planOptionHtml).val("Platinum").trigger("change");
              } else {
                updateMainBenefitListSection();

                if (!dontupdatebenefit) {
                  updateCheckBoxBenefit();
                }

                // jika sudah tidak ada lagi antrian berikutnya, maka panggil ini
                if (ajaxQueue.length < 1) {
                  updateStickyPrice("updateStickyPrice: Di dalam calculatePremi");
                  updatePlanSummarySidebar();
                }
              }
            }
          }
        } else {
          // if response status is 0
          // alert(response.Message ? response.Message : "Calculate Failed");
          if (promoCodeIncluded) {
            if (typeof response.PromoCodeResponse !== "undefined") {
              if (response.PromoCodeResponse) {
                removePromoCode();
                alert(response.Message ? response.Message : "Calculate Failed");
                return false;
              }
            }
          }
        }

        if (typeof callback === "function") callback();
      },
      error: function (xhr, status, error) {
        $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
        console.error("Error:", error);
      },
      complete: function () {
        ajaxBusy = false;
        runQueue(); // proses request berikutnya
      },
    });
  }

  $(".btn-buy").click(function () {
    $(".sticky-plan").addClass("is-active");
  });

  $(".trigger-collapse-promo").click(function () {
    $("#collapseCodepromo").toggleClass("is-show");
    $(this).toggleClass("is-active");
    $(".sticky-plan__inner").toggleClass("is-active");
  });

  $(".trigger-collapse-plan-detail").click(function () {
    $(".detail-summary").toggleClass("is-active");

    $("#collapsePlandetail").toggleClass("is-show");
    $(".sticky-plan__summary").toggleClass("is-hide");
    $(".sticky-plan__inner").toggleClass("is-active-detail");

    $(".code-promo").toggleClass("display-hidden");
  });

  $(".trigger-sub-menu").click(function () {
    $(".sub-menu").toggleClass("is-active");
  });

  $(".back-sub-menu").click(function () {
    $(".sub-menu").removeClass("is-active");
  });

  $(".detail-summary").click(function () {
    $(".sticky-plan-collapse-summary").removeClass("is-show");
    $(this).removeClass("is-active");
    $(".sticky-plan__summary").removeClass("is-hide");
    $(".sticky-plan__inner").removeClass("is-active-detail");
    $(".detail-summary").removeClass("is-active");
    $(".code-promo").removeClass("display-hidden");
  });

  // DATEPICKER
  // -------------------------------------------------------------------------------
  // Date picker
  var fromTravel = $("#Fromtravel").daterangepicker({
    parentEl: "#Fromtravel-wrapper",
    autoUpdateInput: false,
    singleDatePicker: true,
    showDropdowns: true,
    buttonClasses: "btn-date",
    applyButtonClasses: "btn-apply",
    cancelClass: "btn-cancel",
    minDate: moment(),
    locale: {
      applyLabel: "Pilih",
      cancelLabel: "Batal",
      daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
      monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
    },
  });

  if (sessData && sessData["DepartureDate"] !== undefined) {
    let existingDateStr = sessData["DepartureDate"];
    let dateMoment = moment(existingDateStr, "DD/MMM/YYYY");

    fromTravel.data("daterangepicker").setStartDate(dateMoment);
    fromTravel.data("daterangepicker").setEndDate(dateMoment);
    fromTravel.val(dateMoment.format("DD/MMM/YYYY"));
    fromTravel.data("daterangepicker").updateCalendars();
  }

  var toTravel = $("#Totravel").daterangepicker({
    parentEl: "#Totravel-wrapper",
    autoUpdateInput: false,
    singleDatePicker: true,
    showDropdowns: true,
    buttonClasses: "btn-date",
    applyButtonClasses: "btn-apply",
    cancelClass: "btn-cancel",
    minDate: moment(),
    locale: {
      applyLabel: "Pilih",
      cancelLabel: "Batal",
      daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
      monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
    },
  });

  if (sessData && sessData["ArrivalDate"] !== undefined) {
    let existingArrivalDateStr = sessData["ArrivalDate"];
    let arrivalDateMoment = moment(existingArrivalDateStr, "DD/MMM/YYYY");

    toTravel.data("daterangepicker").setStartDate(arrivalDateMoment);
    toTravel.data("daterangepicker").setEndDate(arrivalDateMoment);
    toTravel.val(arrivalDateMoment.format("DD/MMM/YYYY"));
    toTravel.data("daterangepicker").updateCalendars();
  }

  $("#Fromtravel, #Totravel").on("apply.daterangepicker", function (e, picker) {
    let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    const formattedDate = picker.startDate.format("DD/MMM/YYYY");

    // Departure
    if (e.target.getAttribute("id") === "Fromtravel") {
      if ($("#travel-type-step2").val() === "Annual") {
        let _annual = moment(picker.startDate).add(1, "year").subtract(1, "day");

        fromTravel.data("daterangepicker").maxDate = _annual;

        toTravel.data("daterangepicker").minDate = _annual;
        toTravel.data("daterangepicker").maxDate = _annual;
        toTravel.data("daterangepicker").setStartDate(_annual);
        toTravel.data("daterangepicker").setEndDate(_annual);
        toTravel.val(moment(picker.startDate).add(1, "year").subtract(1, "day").format("DD/MMM/YYYY"));
        toTravel.data("daterangepicker").updateCalendars();

        // jika sudah ada session dari step1, tidak usah trigger change lagi
        if (!sessData.FromStep1) {
          $('[name="DepartureDate"]').val(formattedDate).trigger("change");
          $('[name="ArrivalDate"]').val(moment(picker.startDate).add(1, "year").subtract(1, "day").format("DD/MMM/YYYY")).trigger("change");
        }
      } else {
        fromTravel.data("daterangepicker").maxDate = moment(picker.startDate).add(180, "days").subtract(1, "day");

        toTravel.data("daterangepicker").minDate = moment(picker.startDate);
        toTravel.data("daterangepicker").maxDate = moment(picker.startDate).add(90, "days").subtract(1, "day");
        toTravel.data("daterangepicker").setStartDate(picker.startDate);
        toTravel.data("daterangepicker").setEndDate(picker.startDate);

        // jika sudah ada session dari step1, tidak usah set val lagi
        // karena sudah diset pada saat init
        if (!sessData.FromStep1) {
          toTravel.val(formattedDate);
        }

        toTravel.data("daterangepicker").updateCalendars();

        if (!sessData.FromStep1) {
          $('[name="DepartureDate"]').val(formattedDate).trigger("change");
          $('[name="ArrivalDate"]').val(formattedDate).trigger("change");
        }
      }
    }

    // Arrival
    if (e.target.getAttribute("id") === "Totravel") {
      $('[name="ArrivalDate"]').val(formattedDate).trigger("change");
    }

    $(this).val(formattedDate);
  });

  // Cancel event daterangepicker.
  $("#Fromtravel, #Totravel").on("cancel.daterangepicker", function (ev, picker) {
    $(this).val("").trigger("change");
  });

  $("#travel-type-step2").on("change", function (e) {
    // if (!firstLoadStep2 && $(e.target).val() === 'Annual') {
    //     showModalSanctionCountry();
    // }
    $("#Fromtravel").trigger("apply.daterangepicker", $("#Fromtravel").data("daterangepicker"));
  });

  // delete child traveller object in session storage
  function removeChildTotal() {
    let travelData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    if (travelData && travelData.ChildTotal) {
      delete travelData.ChildTotal;
    }
    sessionStorage.setItem(_smartTravelInternationalFormDetailSess, JSON.stringify(travelData));
  }

  function createChildOption(total) {
    $('select[name="ChildTotal"]').empty();
    let optionHtml = "";
    for (i = 0; i < total; i++) {
      let counter = i + 1;
      optionHtml += '<option value="' + counter + '">' + counter + " Anak</option>";
    }
    $('select[name="ChildTotal"]').html(optionHtml);
  }

  function createChildOptionWithZero(total) {
    $('select[name="ChildTotal"]').empty();
    let optionHtml = "";
    for (i = 0; i <= total; i++) {
      let counter = i;
      optionHtml += '<option value="' + counter + '">' + counter + " Anak</option>";
    }
    $('select[name="ChildTotal"]').html(optionHtml);
  }

  // Atur jumlah dewasa dan anak
  function updateSelectOptions(travellerType) {
    let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

    var select = $("#select-adult");
    select.empty(); // Clear previous options

    if (travellerType === "Individual") {
      $('select[name="ChildTotal"]').empty();

      select.append('<option value="1" selected>1 Dewasa</option>');
      $(select).trigger("change");

      removeChildTotal();
      if (!$(".child-total").hasClass("gohide")) {
        $(".child-total").addClass("gohide");
      }

      //   calculatePremi(false, false, "updateSelectOptions:Individual");
      calculatePremiNew(false, false, "updateSelectOptions:Individual");
    } else if (travellerType === "Duo") {
      select.append('<option value="1" ' + (sessData.AdultTotal === "1" ? "selected" : "") + ">1 Dewasa</option>");
      select.append('<option value="2" ' + (sessData.AdultTotal === "2" ? "selected" : "") + ">2 Dewasa</option>");
      $(select).trigger("change");

      //   calculatePremi(false, false, "updateSelectOptions:Duo");
      calculatePremiNew(false, false, "updateSelectOptions:Duo");
    } else if (travellerType === "Family") {
      let adultTotalFromStep1 = sessData["AdultTotalFromStep1"];

      let adultTotal = sessData["AdultTotal"];
      let valAdultTotal = "1";

      if (adultTotalFromStep1) {
        if (adultTotalFromStep1 === "2") {
          createChildOptionWithZero(4);
          select.append('<option value="1">1 Dewasa</option>');
          select.append('<option value="2" selected>2 Dewasa</option>');
          valAdultTotal = "2";
        } else {
          createChildOption(4);
          select.append('<option value="1" selected>1 Dewasa</option>');
          select.append('<option value="2">2 Dewasa</option>');
        }
      } else {
        // cek jika di session ada adultTotal
        // ini bisa terjadi, apabila sebelumnya yg dipilih adalah individual atau DUO
        // sehingga adulttotal di session tidak hilang
        // dan untuk membedakan bahwa sebelumnya dari DUO atau bukan
        // gunakan nilai dari variable duoClicked

        createChildOptionWithZero(4);
        select.append('<option value="1">1 Dewasa</option>');
        select.append('<option value="2" selected>2 Dewasa</option>');
        valAdultTotal = "2";
        duoClicked = false;
      }

      $(select).trigger("change");
      updateSess(_smartTravelInternationalFormDetailSess, "AdultTotal", valAdultTotal);

      // Family re-reselect
      let childTotalFromStep1 = sessData["ChildTotalFromStep1"];
      let childTotal = sessData["ChildTotal"];
      let valChildTotal = "0";

      if (childTotalFromStep1) {
        $("#select-kid").val(childTotalFromStep1.toString()).trigger("change");
        valChildTotal = childTotalFromStep1.toString();
      } else {
        $("#select-kid").val("0").trigger("change");
      }

      updateSess(_smartTravelInternationalFormDetailSess, "ChildTotal", valChildTotal);

      if ($(".child-total").hasClass("gohide")) {
        $(".child-total").removeClass("gohide");
      }

      travellerTypeChange = false;
      // calculatePremi(false, false, "updateSelectOptions:Family");
      calculatePremiNew(false, false, "updateSelectOptions:Family");
    }

    updateSess(_smartTravelInternationalFormDetailSess, "AdultTotalFromStep1", false);
    updateSess(_smartTravelInternationalFormDetailSess, "ChildTotalFromStep1", false);
  }

  // Traveller Type Change Event
  // --------------------------------------------------------------------------
  $('[name="AdultTotal"]').on("change", function () {
    updateSess(_smartTravelInternationalFormDetailSess, "AdultTotal", $(this).val());

    let currentTravellerType = $('[name="TravellerType"]:checked').val();

    if (currentTravellerType === "Duo") {
      if ($(this).val() === "2") {
        removeChildTotal();
        $('select[name="ChildTotal"]').empty();
        if (!$(".child-total").hasClass("gohide")) {
          $(".child-total").addClass("gohide");
        }
      } else {
        removeChildTotal();
        createChildOption(1);
        $("#select-kid").val("1").trigger("change");
        $(".child-total").removeClass("gohide");
      }
    }

    if (currentTravellerType === "Family") {
      if ($(this).val() === "1") {
        removeChildTotal();
        createChildOption(5);
        $("#select-kid").val("1").trigger("change");
      } else {
        removeChildTotal();
        createChildOptionWithZero(5);
        $("#select-kid").val("0").trigger("change");
      }
    }

    if (!travellerTypeChange) {
      //   calculatePremi(false, false, "Field AdultTotal onChange");
      calculatePremiNew(false, false, "Field AdultTotal onChange");
    }
  });

  $('[name="ChildTotal"]').on("change", function () {
    updateSess(_smartTravelInternationalFormDetailSess, "ChildTotal", $(this).val());
    if (!travellerTypeChange) {
      // calculatePremi(false, false, "Field ChildTotal onChange");
      calculatePremiNew(false, false, "Field ChildTotal onChange");
    }
  });

  $('[name="TravellerType"]').on("change", function () {
    var selectedTravellerType = $(this).val();

    if (selectedTravellerType === "Duo") {
      duoClicked = true;
    }
    updateSess(_smartTravelInternationalFormDetailSess, "TravellerType", selectedTravellerType);
    travellerTypeChange = true;
    updateSelectOptions(selectedTravellerType);
  });

  // delete additionalbenefits object in session storage
  function removeAdditionalBenefitSess() {
    let travelData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    if (travelData && travelData.AdditionalBenefits) {
      delete travelData.AdditionalBenefits;
    }
    sessionStorage.setItem(_smartTravelInternationalFormDetailSess, JSON.stringify(travelData));
  }

  // Update Additional Benefit Section
  function updateAdditionalBenefitSection(debug = false) {
    // console.log(debug);
    let existingSession = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

    if (existingSession && existingSession.ChoosenPlan) {
      let choosenPlan = existingSession.ChoosenPlan;
      let choosenCurrency = existingSession.Currency;

      $.ajax({
        url: _apiURL + "/o/api/sti/additionalbenefit",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ Plan: choosenPlan }),
        success: function (response) {
          if (response.Status) {
            benefitPlanDescription = [];

            if (response.Data) {
              let panelHTML = "";
              var descId = 1;
              response.Data.forEach((benefitGroup) => {
                let benefitTypeName = benefitGroup.BenefitType;
                let benefitItems = benefitGroup.BenefitItems;
                let benefitItemHtml = "";

                if (benefitItems.length > 0) {
                  benefitItems.sort((a, b) => a.Sort - b.Sort);

                  benefitItems.forEach((item) => {
                    parentCheckboxClass = "";
                    subCheckboxClass = "";
                    if (item.Name === "Keterlambatan atau Pembatalan Perjalanan") {
                      parentCheckboxClass = "kapp";
                    }
                    if (item.Name === "Keterlambatan Perjalanan Karena Alasan Operasional") {
                      subCheckboxClass = "subkapp";
                    }
                    let limitInfo = choosenCurrency === "idr" ? item.LimitInfo : item.LimitInfoUSD;
                    limitInfo = formatStringToList(limitInfo);
                    benefitItemHtml += `
                                                  <div class="toogle__row">
                                                      <div class="display-flex">
                                                          <input type="checkbox" id="switch-${item.Code}" name="switch-${item.Code}" class="child benefitcheckbox ${parentCheckboxClass} ${subCheckboxClass}" data-benefit="${item.Code}" />
                                                          <label class="label_toggle" for="switch-${item.Code}">Toggle</label>
                                                          <span class="toogle__row-span-item">${item.Name}</span>
                                                          <span class="penjelasan-link-mobile">
                                                              <a href="javascript:void(0)" data-descid="rnd${descId}" class="benefit-plan-desc-btn">Penjelasan</a>
                                                          </span>
                                                      </div>
                                                      <div class="toogle__row-span_cost">
                                                          <span class="cost-text">${limitInfo}</span>
                                                          <span class="penjelasan-link">
                                                              <a href="javascript:void(0)" data-descid="rnd${descId}" class="benefit-plan-desc-btn">Penjelasan</a>
                                                          </span>
                                                      </div>
                                                  </div>
                                              `;

                    // for modal
                    let _tmp = {
                      randId: "rnd" + descId,
                      name: item.Name,
                      description: item.Description,
                    };
                    benefitPlanDescription.push(_tmp);

                    descId++;
                  });
                }

                panelHTML += `<div class="panel-table hide__checkbox__step2">
                    <div class="panel-table-header"><h4 class="agency__font-bold">${benefitTypeName} (Tambahan)</h4></div>
                    <div class="panel-table-body">
                      <div class="toogle__row">
                        <div class="display-flex align-items-center"><input type="checkbox" id="switch-${benefitGroup.BenefitType.replace(
                          /[\s&]+/g,
                          ""
                        )}" name="switch-${benefitGroup.BenefitType.replace(/[\s&]+/g, "")}" class="parent" /> <label class="label_toggle" for="switch-${benefitGroup.BenefitType.replace(
                  /[\s&]+/g,
                  ""
                )}">Toggle</label> <span class="agency__font-bold ml-3level">Pilih Semua</span></div>
                        <span class="toogle__row-span_parent"></span>
                      </div>
                      ${benefitItemHtml}
                    </div>
                  </div>
                  `;
              });

              $("#additional-benefit-wrapper").empty();
              $("#additional-benefit-wrapper").html(panelHTML);
            }

            if (checkAdditionalBenefit && fromPrev == false) {
              if(existingSession['BusinessModel'] === "B2C") {
                $("input#switch-JaminanKetidaknyamananPerjalanan").prop("checked", true).trigger("change");
                $("input#switch-JaminanKecelakaanMedis").prop("checked", true).trigger("change");
                $("input#switch-JaminanLainnya").prop("checked", true).trigger("change");
              } else {
                $("input#switch-JaminanKetidaknyamananPerjalanan").prop("checked", true).trigger("change");
                $("input#switch-JaminanKecelakaanMedis").prop("checked", true).trigger("change");
              }
            }

            if (fromPrev) {
              updateCheckBoxBenefit();
            }
          }
        },
        error: function (xhr, status, error) {
          console.error("Error:", error);
        },
      });
    }
  }

  $(document).on("click", ".benefit-plan-desc-btn", function () {
    let _id = $(this).data("descid");
    let _filtered;
    if (_id) {
      if (benefitPlanDescription) {
        _filtered = benefitPlanDescription.find((item) => item.randId === _id);

        $("#benefit-plan-description-modal").attr("aria-labelledby", _id + "_label");
        $("#benefit-plan-description-modal")
          .find("h1.modal-title")
          .attr("id", _id + "_label");
        $("#benefit-plan-description-modal").find(".modal-body").find("h3").html(_filtered["name"]);
        $("#benefit-plan-description-modal").find(".modal-body").find("p").html(_filtered["description"]);

        const quotationModal = new bootstrap.Modal(document.getElementById("benefit-plan-description-modal"));
        quotationModal.show();
      }
    }
  });

  // Update Main Benefit list section
  function updateMainBenefitListSection() {
    if (sessionStorage.getItem(_smartTravelInternationalCalculation)) {
      let formDetail = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
      let choosenCurrency = formDetail.Currency;
      let choosenPlan = formDetail.ChoosenPlan;
      let calculation = JSON.parse(sessionStorage.getItem(_smartTravelInternationalCalculation));
      let htmlMainBenefitList = "";
      for (const plan of calculation.AvailablePlans) {
        if (plan.PlanName === choosenPlan) {
          for (const benefitItem of plan.MainBenefitListDesc) {
            htmlMainBenefitList +=
              '<div class="main-benefit-row main-benefit-inner"><span class="agency__col-span-1">' +
              benefitItem["Name"] +
              '</span> <span class="agency__col-span-1 agency__text-axa-blue-500 text-left">' +
              (choosenCurrency === "idr" ? formatStringToList(benefitItem["Desc"]) : formatStringToList(benefitItem["DescUSD"])) +
              "</span></div>";
          }
        }
      }

      $("#main-benefit-list-wrapper").html(htmlMainBenefitList);
    }
  }

  function updateCheckBoxBenefit() {
    let formDetail = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    if (formDetail && formDetail.AdditionalBenefits) {
      if (formDetail.AdditionalBenefits.length > 0) {
        formDetail.AdditionalBenefits.forEach((idPlan) => {
          $("#switch-" + idPlan).prop("checked", true);
        });
      }
    }
  }

  // PLAN OPTION EVENT LISTENER
  $("#plan-option").on("change", function (e) {
    if (!continueQuote && !ro) {
      removeAdditionalBenefitSess(); // hapus dulu additional benefits yang sudah ada di sess storage
    }
    updateSess(_smartTravelInternationalFormDetailSess, "ChoosenPlan", $(this).val());

    if (!continueQuote) {
      //   calculatePremi(false, false, "id plan-option onChange");
      calculatePremiNew(false, false, "id plan-option onChange");
    }

    let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    if (sessData && sessData["ChoosenPlan"]) {
      updateMainBenefitListSection();

      // disini ajax additional benefit dipanggil saat pertama kali
      updateAdditionalBenefitSection("updateAdditionalBenefitSection setelah updatePlan");
      updatePlanSummarySidebar();
      updateStickyPrice("plan-option on Change");
    }

    continueQuote = false;
  });

  $(".next-step-btn").on("click", function (e) {
    let purchaseBeforeDepartsStat = $("#it-purchase-before-departs-checkbox");
    if (!purchaseBeforeDepartsStat.is(":checked")) {
      alert("Anda belum setuju bahwa anda harus membeli asuransi sebelum berangkat dari Indonesia");
      purchaseBeforeDepartsStat.siblings(".it-purchase-before-departs-label").find("span").addClass("it-error-required");

      $("html, body").animate(
        {
          scrollTop: purchaseBeforeDepartsStat.offset().top - 200,
        },
        600
      );
      return;
    }

    purchaseBeforeDepartsStat.siblings(".it-purchase-before-departs-label").find("span").removeClass("it-error-required");

    e.preventDefault();
    let thisEl = $(this);
    let sessData = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    if (sessData) {
      $.ajax({
        url: _apiURL + "/o/api/sti/pd",
        type: "POST",
        contentType: "application/json",
        data: sessData,
        beforeSend: function () {
          displayLoading();
        },
        success: function (response) {
          if (response.Status) {
            if (fromPrev == false) {
              let token = response.Data.Token;
              updateSess(_smartTravelInternationalFormDetailSess, "Token", token);
            }

            //            window.addEventListener("beforeunload", function () {
            //                displayLoading(); // Ensure the loading is shown during navigation
            //              });
            //
            window.location.href = step3URL;
          } else {
            alert(response.Message);
            hideLoading();
          }
        },
      });
    }
  });

  //CHECKBOX ADDITIONAL BENEFIT
  //-----------------------------------------------------------------------------------------
  $(document).on("change", ".parent", function () {
    const parent = $(this);
    const panel = $(this).closest(".panel-table");
    const childCheckboxes = panel.find(".child");

    childCheckboxes.prop("checked", $(this).is(":checked"));

    let additionalBenefitsArr = [];
    let travelData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

    if (travelData && travelData.AdditionalBenefits) {
      additionalBenefitsArr = travelData.AdditionalBenefits;
    }

    childCheckboxes.each(function (i, e) {
      let currentBenefit = $(e).data("benefit");

      if (parent.is(":checked")) {
        if (!additionalBenefitsArr.includes(currentBenefit)) {
          // tambahkan benefit ke array
          additionalBenefitsArr.push(currentBenefit);
        }
      } else {
        if (additionalBenefitsArr.includes(currentBenefit)) {
          // hapus benefit dari array
          additionalBenefitsArr = additionalBenefitsArr.filter((item) => item !== currentBenefit);
        }
      }
    });

    updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", additionalBenefitsArr);

    // calculatePremi(false, false, ".parent onChange");
    calculatePremiNew(false, false, ".parent onChange");
  });

  // INI MESTINYA SAAT RUNNING HARUS ADA MODAL OVERLAY YANG DISABLE HALAMAN
  // SUPAYA TIDAK BISA DIKLIK. KARENA TAKUTNYA BALAP REQUEST DENGAN PARAM BERBEDA
  // SAAT DIKLIK ..
  $(document).on("change", ".child", function () {
    let additionalBenefitsArr = [];
    let travelData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

    if (travelData && travelData.AdditionalBenefits) {
      additionalBenefitsArr = travelData.AdditionalBenefits;
    }

    let currentBenefit = $(this).data("benefit");

    if ($(this).is(":checked")) {
      if (!additionalBenefitsArr.includes(currentBenefit)) {
        additionalBenefitsArr.push(currentBenefit);
      }
    } else {
      if (additionalBenefitsArr.includes(currentBenefit)) {
        additionalBenefitsArr = additionalBenefitsArr.filter((item) => item !== currentBenefit);
      }
    }

    updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", additionalBenefitsArr);

    // jika semua checked, maka parent checked juga
    const panel = $(this).closest(".panel-table");
    const parentCheckbox = panel.find(".parent");
    const childCheckboxes = panel.find(".child");

    const allChecked = childCheckboxes.length === childCheckboxes.filter(":checked").length;
    parentCheckbox.prop("checked", allChecked);

    if ($(this).siblings(".toogle__row-span-item").text() === "Keterlambatan atau Pembatalan Perjalanan") {
      $(document).find(".subkapp").prop("checked", false).trigger("change");
      // $('.subkapp').prop('checked', false);
    }

    // calculatePremi(false, false, ".child onChange");
    calculatePremiNew(false, false, ".child onChange");
  });

  // END CHECKBOX ADDITIONAL BENEFIT
  //-----------------------------------------------------------------------------------------

  // Set Session Storage.
  // --------------------------------------------------------------------------
  $(document).on("change", ".form-item-step2", function (e) {
    let existingSession = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);

    let _dataForSession = {};

    let inputType = $(this).attr("type");
    let inputName = $(this).attr("name");

    const sessKey = $(this).attr("name");

    if (inputType === "radio") {
      if (inputName === "Currency") {
        let currentVal = $(this).attr("id") || "idr";
        _dataForSession[sessKey] = currentVal;
        // updateAdditionalBenefitSection("update additional benefit saat currency diganti");
      }

      if (inputName === "TravellerType") {
        let currentVal = $(this).val() || "";
        _dataForSession[sessKey] = currentVal;
      }
    } else {
      let currentVal = $(this).val() || "";
      _dataForSession[sessKey] = currentVal;
    }

    // jika ada session sebelumnya, maka merge dengan yang baru
    if (existingSession) {
      let mergedSession = { ...JSON.parse(existingSession), ..._dataForSession };
      sessionStorage.setItem(_smartTravelInternationalFormDetailSess, JSON.stringify(mergedSession));
    } else {
      sessionStorage.setItem(_smartTravelInternationalFormDetailSess, JSON.stringify(_dataForSession));
    }

    // Jika currency direselect, maka reset semua checkbox additional benefit
    if (inputName === "Currency") {
      updateSess(_smartTravelInternationalFormDetailSess, "AdditionalBenefits", []);
      updateAdditionalBenefitSection("update additional benefit saat currency diganti");
    }

    // NOTES: apabila travellertype dipilih Family, maka calculate premi akan
    // dipanggil dua kali, karena saat pilih travellertype,
    // select jumlah dewasa dan anak akan ketrigger change juga.

    // calculatePremi(false, false, "Field .form-item-step2 onChange");
    calculatePremiNew(false, false, "Field .form-item-step2 onChange");
  });

  const quotationModal = new bootstrap.Modal(document.getElementById("quotation-modal"));
  $("#send_quotation_btn_close").on("click", function () {
    quotationModal.hide();
  });

  // KIRIM PENAWARAN
  $("#submit-quotation-btn").on("click", function (e) {
    let sessData = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    if (sessData) {
      sessData = JSON.parse(sessData);

      let a = sessData.Currency;
      b = sessData.TravellerType;
      c = sessData.TravelType;
      d = sessData.DepartureDate;
      e = sessData.ArrivalDate;

      if (a && b && c && d && e) {
        quotationModal.show();
      } else {
        //				alert("invalid");
      }
    }
  });

  $("#send_quotation_form").on("submit", function (e) {
    e.preventDefault();

    let btn = $(this).find('button[type="submit"]');

    let sessData = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    sessData = JSON.parse(sessData);
    let _name = $(this).find('input[name="send_quotation_name"]').val().toUpperCase();
    _name = _name ? _name.trim() : _name;
    let _email = $(this).find('input[name="send_quotation_email"]').val();
    _email = _email ? _email.trim() : _email;
    sessData["Quotation"] = "1";
    sessData["Name"] = _name;
    sessData["Email"] = _email;

    $.ajax({
      url: _apiURL + "/o/api/sti/pd",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify(sessData),
      beforeSend: function () {
        $(btn).html('<span class="modal_penawaran-agency__text-amber-300"> LOADING... </span>').attr("disabled", true);
      },
      success: function (response) {
        //	        	  console.log(response);
        $(btn).html('<span class="modal_penawaran-agency__text-amber-300"> KIRIM </span><i class="fas fa-arrow-right ml-2level"></i>').attr("disabled", false);
        quotationModal.hide();
        if (response.Status) {
          alert(response.Message);
          window.parent.location.href = response.Data;
        } else {
          alert(response.Message);
        }
      },
    });
  });

  // PROMOCODE
  $("#promo-code-btn").on("click", function (e) {
    $(this).html('<span class="position-relative order-10">Loading....</span>');
    let el = $(this);
    let pc = $('input[name="PromoCode"]').val();
    $('input[name="PromoCodeSidebar"]').val(pc);

    updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
    // calculatePremi(false, false, "#promo-code-btn onClick");
    calculatePremiNew(false, false, "#promo-code-btn onClick");

    $(".trigger-collapse-promo").trigger("click"); // tutup sticky promocode dan tampilkan summary
  });

  $("#clear-promo-code-btn-sidebar").on("click", function (e) {
    let pc = $('input[name="PromoCodeSidebar"]').val();
    $('input[name="PromoCode"]').val(pc);

    updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
    // calculatePremi(false, false, "#clear-promo-code-btn-sidebar onClick");
    calculatePremiNew(false, false, "#clear-promo-code-btn-sidebar onClick");
  });

  // POPUP KIRIM PENAWARAN
  $('input[name="send_quotation_name"]').on("input", function (e) {
    let inputValue = e.target.value;
    let sanitizedValue = inputValue.replace(/[^a-zA-Z ]/g, "");

    if (inputValue !== sanitizedValue) {
      e.target.value = sanitizedValue;
    }
  });

  $('input[name="send_quotation_email"]').on("input", function (e) {
    let inputValue = e.target.value;
    let sanitizedValue = inputValue.replace(/[^a-zA-Z0-9@\-_.]/g, "");

    if (inputValue !== sanitizedValue) {
      e.target.value = sanitizedValue;
    }
  });

  // CHECK SESSION WHEN PAGE LOADING
  // ------------------------------------------------------------------------
  if (sessData) {
    let promoCode = sessData["PromoCode"];

    if (promoCode) {
      $('input[name="PromoCode"]').val(promoCode);
      $('input[name="PromoCodeSidebar"]').val(promoCode);
    }

    let currency = sessData["Currency"];
    if (currency) {
      if (currency === "idr") {
        $("#idr").prop("checked", true);
      } else {
        $("#usd").prop("checked", true);
      }
    }

    let travellerType = sessData["TravellerType"];
    if (travellerType) {
      $('input[name="TravellerType"][value="' + travellerType + '"]').prop("checked", true);
      updateSelectOptions(travellerType); // set jumlah tanggunan
    }

    let travelType = sessData["TravelType"];
    if (travelType) {
      $("#travel-type-step2").val(travelType).trigger("change");
    }

    // Jika ada SmartTravelInternationalPlans di session storage
    // maka looping isinya dan set ke option plan

    calculateStat = true;
    // calculatePremi(
    //   true,
    //   () => {
    //     let _calculation = sessionStorage.getItem(_smartTravelInternationalCalculation);

    //     if (_calculation) {
    //       _calculation = JSON.parse(_calculation);

    //       let choosenPlan = sessData["ChoosenPlan"];
    //       let _planOptionHtml = "";
    //       for (const plan of _calculation.AvailablePlans) {
    //         let selectedStat = plan.PlanName === choosenPlan ? "selected" : "";
    //         _planOptionHtml += '<option value="' + plan.PlanName + '"' + selectedStat + ">" + plan.PlanName + "</option>";
    //       }
    //       $("#plan-option").html(_planOptionHtml).trigger("change");

    //       updateMainBenefitListSection();
    //       updateStickyPrice();
    //       updatePlanSummarySidebar();

    //       setTimeout(() => {
    //         updateCheckBoxBenefit();
    //       }, 500);

    //       updateSess(_smartTravelInternationalFormDetailSess, "FromStep1", false);
    //     }
    //   },
    //   "CalculatePremi saat check ada sesi di awal"
    // );

    calculatePremiNew(
      true,
      () => {
        let _calculation = sessionStorage.getItem(_smartTravelInternationalCalculation);

        if (_calculation) {
          _calculation = JSON.parse(_calculation);

          let choosenPlan = sessData["ChoosenPlan"];
          let _planOptionHtml = "";
          for (const plan of _calculation.AvailablePlans) {
            let selectedStat = plan.PlanName === choosenPlan ? "selected" : "";
            _planOptionHtml += '<option value="' + plan.PlanName + '"' + selectedStat + ">" + plan.PlanName + "</option>";
          }
          $("#plan-option").html(_planOptionHtml).trigger("change");

          updateMainBenefitListSection();
          updateStickyPrice("updateStickyPrice: " + "Check Sesi di awal");
          updatePlanSummarySidebar();

          setTimeout(() => {
            updateCheckBoxBenefit();
          }, 500);

          updateSess(_smartTravelInternationalFormDetailSess, "FromStep1", false);
        }
      },
      "CalculatePremi saat check ada sesi di awal"
    );
  }

  if (sessData && typeof sessData["ChoosenPlan"] === "undefined") {
    $("#travel-type-step2").val("Single").trigger("change");
  }

  window.addEventListener("load", (event) => {
    if (performance.getEntriesByType("navigation")[0].type === "navigate") {
      if (firstLoadStep2) {
        showModalSanctionCountry();
      }
    }
  });

  firstLoadStep2 = false;

  // END CHECK SESSION WHEN PAGE LOADING
  // ------------------------------------------------------------------------

  $(document).on("change", ".subkapp", function () {
    if ($(this).is(":checked")) {
      if (!$(".kapp").is(":checked")) {
        $(this).prop("checked", false).trigger("change");
        //const travelDelayCheckboxWarningModal = new bootstrap.Modal(document.getElementById('travel-delay-checkbox-warning-modal'));
        //travelDelayCheckboxWarningModal.show();
        alert("Untuk mengaktifkan manfaat ini. Silahkan aktifkan juga manfaat Keterlambatan atau Pembatalan Perjalanan");
      }
    }
  });
}); // end doc ready

document.addEventListener("DOMContentLoaded", function () {
  /* delete bg-white default liferay */
  var contentSection = document.getElementById("content");
  if (contentSection) {
    contentSection.classList.remove("bg-white");
  }

  /* button clear kode promo */
  const clearButtons = document.querySelectorAll(".btnClear");
  clearButtons.forEach((button) => {
    button.addEventListener("click", function () {
      const inputGroup = button.closest(".input-group-axa");
      const input = inputGroup.querySelector(".input-control-axa");
      input.value = "";
    });
  });

  // jika halaman diakses dari back button di browser (BFCache)
  // maka reload page untuk reset semuanya
  window.addEventListener("pageshow", function (event) {
    // console.log(event);
    // console.log(event.persisted);
    //        if (event.persisted) {
    //            location.reload();
    //        }
  });
});
