$(document).ready(function () {
  $(".brand-logo-link").on("click", function (e) {
    //		let mypageUserURL = sessionStorage.getItem("mypageUserURL");
    //		if(mypageUserURL) {
    //			window.location.href = window.mypageUserURL;
    //		}
  });

  currentStep = 1;
  var isCalculateButtonClicked = false;

  // init swiper
  var swiper = new Swiper(".swiper-plan", {
    slidesPerView: "auto",
    observer: true,
    observeParents: true,
    autoHeight: false,
    freeMode: true,
    speed: 800,
    spaceBetween: 8,
    mousewheel: {
      forceToAxis: true,
    },
  });

  document.location.hash = "";
  // $("#modalAlert").modal('show');
  options = [];

  // create an array of select options for a lookup
  $("#destinasi option").each(function (idx) {
    options.push({
      id: $(this).val(),
      text: $(this).text(),
    });
  });

  $("#destinasi").select2({
    tags: "true",
    dropdownParent: ".destinasi-wrapper",
    placeholder: "Pilih Destinasi",
    allowClear: true,
    width: "100%",
    createTag: function (params) {
      var term = $.trim(params.term);

      if (term === "") {
        return null;
      }

      // check whether the term matches an id
      var search = $.grep(options, function (n, i) {
        return n.id === term || n.text === term; // check against id and text
      });

      // if a match is found replace the term with the options' text
      if (search.length) term = search[0].text;
      else return null; // didn't match id or text value so don't add it to selection

      return {
        id: term,
        text: term,
        value: true,
        // add additional parameters
      };
    },
  });

  $("#single-journey").select2({
    dropdownParent: "#single-journey-wrapper",
    placeholder: "Perjalanan Tunggal",
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

  $(".btn-buy").click(function () {
    $(".sticky-plan").addClass("is-active");
  });

  $(".trigger-collapse-promo").click(function () {
    $("#collapseCodepromo").toggleClass("is-show");
    $(this).toggleClass("is-active");
    $(".sticky-plan__inner").toggleClass("is-active");
  });

  $(".trigger-collapse-plan-detail").click(function () {
    $("#collapsePlandetail").toggleClass("is-show");
    $(".sticky-plan__summary").toggleClass("is-hide");
    $(".sticky-plan__inner").toggleClass("is-active-detail");
    $(".detail-summary").toggleClass("is-active");
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

  $(function () {
    $("#planSelector").change(function () {
      $(".plans").hide();
      $("#" + $(this).val()).show();
    });
  });

  // DATE PICKER INIT.
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

  $("#Fromtravel, #Totravel").on("apply.daterangepicker", function (e, picker) {
    const formattedDate = picker.startDate.format("DD/MMM/YYYY");

    // Departure
    if (e.target.getAttribute("id") === "Fromtravel") {
      if ($("#travel-type").val() === "Annual") {
        let _annual = moment(picker.startDate).add(1, "year").subtract(1, "day");

        fromTravel.data("daterangepicker").maxDate = _annual;

        toTravel.data("daterangepicker").minDate = _annual;
        toTravel.data("daterangepicker").maxDate = _annual;
        toTravel.data("daterangepicker").setStartDate(_annual);
        toTravel.data("daterangepicker").setEndDate(_annual);
        toTravel.val(moment(picker.startDate).add(1, "year").subtract(1, "day").format("DD/MMM/YYYY"));
        toTravel.data("daterangepicker").updateCalendars();

        $('[name="DepartureDate"]').val(formattedDate).trigger("change");
        $('[name="ArrivalDate"]').val(moment(picker.startDate).add(1, "year").subtract(1, "day").format("DD/MMM/YYYY")).trigger("change");
      } else {
        // picker.startDate adalah tanggal yang dipilih

        fromTravel.data("daterangepicker").maxDate = moment(picker.startDate).add(180, "days").subtract(1, "day");

        toTravel.data("daterangepicker").minDate = moment(picker.startDate);
        toTravel.data("daterangepicker").maxDate = moment(picker.startDate).add(90, "days").subtract(1, "day");
        toTravel.data("daterangepicker").setStartDate(picker.startDate);
        toTravel.data("daterangepicker").setEndDate(picker.startDate);
        toTravel.val(formattedDate);
        toTravel.data("daterangepicker").updateCalendars();

        $('[name="DepartureDate"]').val(formattedDate).trigger("change");
        $('[name="ArrivalDate"]').val(formattedDate).trigger("change");
      }
    }

    // Arrival
    if (e.target.getAttribute("id") === "Totravel") {
      $('[name="ArrivalDate"]').val(formattedDate).trigger("change");
    }

    $(this).val(formattedDate);
  });

  // Cancel event daterangepicker
  $("#Fromtravel, #Totravel").on("cancel.daterangepicker", function (ev, picker) {
    $(this).val("").trigger("change");
  });

  $("#travel-type").on("change", function (e) {
    if (!firstLoadStep1 && $(e.target).val() === "Annual") {
      showModalSanctionCountry();
    }

    $("#Fromtravel").trigger("apply.daterangepicker", $("#Fromtravel").data("daterangepicker"));
  });

  $("#travel-type").select2({
    dropdownParent: "#travel-type-wrapper",
    placeholder: "Perjalanan Tunggal",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  // delete child traveller object in session storage
  function removeChildTotal() {
    let travelData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    if (travelData && travelData.ChildTotal) {
      delete travelData.ChildTotal;
    }
    sessionStorage.setItem(_smartTravelInternationalFormDetailSess, JSON.stringify(travelData));
  }

  function removeChildTotalFromStep1() {
    let travelData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    if (travelData && travelData.ChildTotalFromStep1) {
      delete travelData.ChildTotalFromStep1;
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

  function createChildOptionFamily(total) {
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
    var select = $("#select-adult");
    select.empty();

    if (travellerType === "Individual") {
      select.append('<option value="1" selected>1 Dewasa</option>');
      $(select).trigger("change");

      removeChildTotal();
      if (!$(".child-total").hasClass("gohide")) {
        $(".child-total").addClass("gohide");
      }
    } else if (travellerType === "Duo") {
      select.append('<option value="1" selected>1 Dewasa</option>');
      select.append('<option value="2">2 Dewasa</option>');
      $(select).trigger("change");

      removeChildTotal();
      createChildOption(1);
      $("#select-kid").val("1").trigger("change");
      $(".child-total").removeClass("gohide");
    } else if (travellerType === "Family") {
      select.append('<option value="1">1 Dewasa</option>');
      select.append('<option value="2" selected>2 Dewasa</option>');
      $(select).trigger("change");

      createChildOptionFamily(5);

      // Set option 1 Anak to selected when Family re-reselect
      $("#select-kid").val("0").trigger("change");
      $(".child-total").removeClass("gohide");
    }
  }

  // Traveller Type Change Event
  // --------------------------------------------------------------------------

  $(document).on("change", ".select-adult", function () {
    updateSess(_smartTravelInternationalFormDetailSess, "AdultTotalFromStep1", $(this).val());

    let currentTravellerType = $('[name="TravellerType"]:checked').val();

    if (currentTravellerType === "Duo") {
      if ($(this).val() === "2") {
        removeChildTotal();
        removeChildTotalFromStep1();
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
        createChildOption(4);
        $("#select-kid").val("1").trigger("change");
      } else {
        removeChildTotal();
        createChildOptionFamily(4);
        $("#select-kid").val("0").trigger("change");
      }
    }
  });

  $(document).on("change", ".select-kid", function () {
    updateSess(_smartTravelInternationalFormDetailSess, "ChildTotalFromStep1", $(this).val());
  });

  $('[name="TravellerType"]').on("change", function () {
    var selectedTravellerType = $(this).val();
    updateSelectOptions(selectedTravellerType);
  });

  // Set Session Storage.
  // --------------------------------------------------------------------------
  $(document).on("change", ".form-item", function (e) {
    let existingSession = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);

    let _dataForSession = {};

    let inputType = $(this).attr("type");
    let inputName = $(this).attr("name");

    const sessKey = $(this).attr("name");

    if (inputType === "radio") {
      if (inputName === "Currency") {
        let currentVal = $(this).attr("id") || "idr";
        _dataForSession[sessKey] = currentVal;
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
  });

  // Choose Plan Button
  // --------------------------------------------------------------------------
  $(document).on("click", ".choose-plan-btn", function (e) {
    let planName = $(this).data("plan");
    $(".choose-plan-btn").removeClass("btn--dark-blue");

    $(".choose-plan-btn").each(function (idx, el) {
      if (!$(el).hasClass("btn--dark-blue-outline")) {
        $(el).addClass("btn--dark-blue-outline");
      }

      if ($(el).closest(".card-plan").hasClass("optimal-chosee")) {
        $(el).closest(".card-plan").removeClass("optimal-chosee");
      }

      $(el).html("");
      $(el).html('<span class="position-relative">Pilih <i class="fas fa-arrow-right"></i></span>');
    });

    $(this).removeClass("btn--dark-blue-outline");
    $(this).addClass("btn--dark-blue");
    $(this).html("");
    $(this).html(
      '<span class="position-relative"> <svg class="display-inline-block vertical-align-middle" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16" fill="none"> <path d="M15.75 8C15.75 12.2812 12.25 15.75 8 15.75C3.71875 15.75 0.25 12.2812 0.25 8C0.25 3.75 3.71875 0.25 8 0.25C12.25 0.25 15.75 3.75 15.75 8ZM7.09375 12.125L12.8438 6.375C13.0312 6.1875 13.0312 5.84375 12.8438 5.65625L12.125 4.96875C11.9375 4.75 11.625 4.75 11.4375 4.96875L6.75 9.65625L4.53125 7.46875C4.34375 7.25 4.03125 7.25 3.84375 7.46875L3.125 8.15625C2.9375 8.34375 2.9375 8.6875 3.125 8.875L6.375 12.125C6.5625 12.3125 6.90625 12.3125 7.09375 12.125Z" fill="white" /> </svg> Plan Dipilih </span>'
    );

    $(this).closest(".card-plan").addClass("optimal-chosee");

    updateSess(_smartTravelInternationalFormDetailSess, "ChoosenPlan", planName);

    updateStickyPrice();
  });

  // Create plan card result
  function createPlanCard(currency, plan, formattedAmount, formattedConvertAmount = null, formattedFullBenefitAmount, formattedFullBenefitConvertAmount = null) {
    const mainBenefitObject = [
      {
        plan: "Platinum",
        mainBenefitLimit: [
          {
            nameID: "Kecelakaan Diri",
            nameEN: "Personal Accident",
            limitAmountIDR: "IDR 2.000.000.000",
            limitAmountUSD: "USD 125.000,00",
            sub: false,
          },
          {
            nameID: "Biaya Pengobatan, Gigi dan Lainnya",
            nameEN: "Medical, Dental and Other Expenses",
            limitAmountIDR: "",
            limitAmountUSD: "",
            sub: true,
            subTitle1: "* Perawatan Medis di Luar Negeri",
            subTitleAmount1IDR: "IDR 2.000.000.000",
            subTitleAmount1USD: "USD 125.000,00",
            subTitle2: "* Tindakan Lanjutan Medis di Indonesia",
            subTitleAmount2IDR: "IDR 40.000.000",
            subTitleAmount2USD: "USD 2.500,00",
            subTitle: [
              {
                titleIDR: "* Perawatan Medis di Luar Negeri",
                titleUSD: "* Overseas Medical Treatment",
                amountIDR: "IDR 2.000.000.000",
                amountUSD: "USD 125.000,00",
              },
              {
                titleIDR: "Perawatan Medis di Luar Negeri (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
                titleUSD: "Overseas Medical Treatments (if continue to travel against the government advise)",
                amountIDR: "IDR 400.000.000",
                amountUSD: "USD 25.000,00",
              },
              {
                titleIDR: "* Tindakan Lanjutan Medis di Indonesia",
                titleUSD: "* Follow Up Medical in Indonesia",
                amountIDR: "IDR 40.000.000",
                amountUSD: "USD 2.500,00",
              },
              {
                titleIDR: "Tindakan Lanjutan Medis di Indonesia  (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
                titleUSD: "Follow Up Medical Treatment in Indonesia (if continue to travel against the government advise)",
                amountIDR: "IDR 8.000.000",
                amountUSD: "USD 500,00",
              },
            ],
          },
          {
            nameID: "Evakuasi Medis Darurat dan Repatriasi",
            nameEN: "Emergency Medical Evacuation and Repatriation",
            limitAmountIDR: "IDR 2.000.000.000",
            limitAmountUSD: "USD 125.000,00",
            sub: false,
          },
          {
            nameID: "Evakuasi Medis Darurat dan Repatriasi (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
            nameEN: "Emergency Medical Evacuation & Repatriation (if continue to travel against the government advise)",
            limitAmountIDR: "IDR 400.000.000",
            limitAmountUSD: "USD 25.000,00",
            sub: false,
          },
          {
            nameID: "Pemulangan Jenazah",
            nameEN: "Repatriation of Mortal Remains",
            limitAmountIDR: "IDR 2.000.000.000",
            limitAmountUSD: "USD 125.000,00",
            sub: false,
          },
          {
            nameID: "Pemulangan Jenazah (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
            nameEN: "Repatriation of Mortal Remain (if continue to travel against the government advise)",
            limitAmountIDR: "IDR 400.000.000",
            limitAmountUSD: "USD 25.000,00",
            sub: false,
          },
        ],
      },
      {
        plan: "Gold",
        mainBenefitLimit: [
          {
            nameID: "Kecelakaan Diri",
            nameEN: "Personal Accident",
            limitAmountIDR: "IDR 1.000.000.000",
            limitAmountUSD: "USD 62.500,00",
            sub: false,
          },
          {
            nameID: "Biaya Pengobatan, Gigi dan Lainnya",
            nameEN: "Medical, Dental and Other Expenses",
            limitAmountIDR: "",
            sub: true,
            subTitle1: "* Perawatan Medis di Luar Negeri",
            subTitleAmount1IDR: "IDR 1.000.000.000",
            subTitleAmount1USD: "USD 62.500,00",
            subTitle2: "* Tindakan Lanjutan Medis di Indonesia",
            subTitleAmount2IDR: "IDR 20.000.000",
            subTitleAmount2USD: "USD 1.250,00",
            subTitle: [
              {
                titleIDR: "* Perawatan Medis di Luar Negeri",
                titleUSD: "* Overseas Medical Treatment",
                amountIDR: "IDR 1.000.000.000",
                amountUSD: "USD 62.500,00",
              },
              {
                titleIDR: "Perawatan Medis di Luar Negeri (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
                titleUSD: "Overseas Medical Treatments (if continue to travel against the government advise)",
                amountIDR: "IDR 200.000.000",
                amountUSD: "USD 12.500,00",
              },
              {
                titleIDR: "* Tindakan Lanjutan Medis di Indonesia",
                titleUSD: "* Follow Up Medical in Indonesia",
                amountIDR: "IDR 20.000.000",
                amountUSD: "USD 1.250,00",
              },
              {
                titleIDR: "Tindakan Lanjutan Medis di Indonesia  (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
                titleUSD: "Follow Up Medical Treatment in Indonesia (if continue to travel against the government advise)",
                amountIDR: "IDR 4.000.000",
                amountUSD: "USD 250,00",
              },
            ],
          },
          {
            nameID: "Evakuasi Medis Darurat dan Repatriasi",
            nameEN: "Emergency Medical Evacuation and Repatriation",
            limitAmountIDR: "IDR 1.000.000.000",
            limitAmountUSD: "USD 62.500,00",
            sub: false,
          },
          {
            nameID: "Evakuasi Medis Darurat dan Repatriasi (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
            nameEN: "Emergency Medical Evacuation & Repatriation (if continue to travel against the government advise)",
            limitAmountIDR: "IDR 200.000.000",
            limitAmountUSD: "USD 12.500,00",
            sub: false,
          },
          {
            nameID: "Pemulangan Jenazah",
            nameEN: "Repatriation of Mortal Remains",
            limitAmountIDR: "IDR 1.000.000.000",
            limitAmountUSD: "USD 62.500,00",
            sub: false,
          },
          {
            nameID: "Pemulangan Jenazah (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
            nameEN: "Repatriation of Mortal Remain (if continue to travel against the government advise)",
            limitAmountIDR: "IDR 200.000.000",
            limitAmountUSD: "USD 12.500,00",
            sub: false,
          },
        ],
      },
      {
        plan: "Silver",
        mainBenefitLimit: [
          {
            nameID: "Kecelakaan Diri",
            nameEN: "Personal Accident",
            limitAmountIDR: "IDR 600.000.000",
            limitAmountUSD: "USD 37.500,00",
            sub: false,
          },
          {
            nameID: "Biaya Pengobatan, Gigi dan Lainnya",
            nameEN: "Medical, Dental and Other Expenses",
            limitAmountIDR: "",
            sub: true,
            subTitle1: "* Perawatan Medis di Luar Negeri",
            subTitleAmount1IDR: "IDR 600.000.000",
            subTitleAmount1USD: "USD 37.500,00",
            subTitle2: "* Tindakan Lanjutan Medis di Indonesia",
            subTitleAmount2IDR: "IDR 10.000.000",
            subTitleAmount2USD: "USD 625,00",
            subTitle: [
              {
                titleIDR: "* Perawatan Medis di Luar Negeri",
                titleUSD: "* Overseas Medical Treatment",
                amountIDR: "IDR 600.000.000",
                amountUSD: "USD 37.500,00",
              },
              {
                titleIDR: "Perawatan Medis di Luar Negeri (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
                titleUSD: "Overseas Medical Treatments (if continue to travel against the government advise)",
                amountIDR: "IDR 120.000.000",
                amountUSD: "USD 7.500,00",
              },
              {
                titleIDR: "* Tindakan Lanjutan Medis di Indonesia",
                titleUSD: "* Follow Up Medical in Indonesia",
                amountIDR: "IDR 10.000.000",
                amountUSD: "USD 625,00",
              },
              {
                titleIDR: "Tindakan Lanjutan Medis di Indonesia  (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
                titleUSD: "Follow Up Medical Treatment in Indonesia (if continue to travel against the government advise)",
                amountIDR: "IDR 2.000.000",
                amountUSD: "USD 125,00",
              },
            ],
          },
          {
            nameID: "Evakuasi Medis Darurat dan Repatriasi",
            nameEN: "Emergency Medical Evacuation and Repatriation",
            limitAmountIDR: "IDR 600.000.000",
            limitAmountUSD: "USD 37.500,00",
            sub: false,
          },
          {
            nameID: "Evakuasi Medis Darurat dan Repatriasi (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
            nameEN: "Emergency Medical Evacuation & Repatriation (if continue to travel against the government advise)",
            limitAmountIDR: "IDR 120.000.000",
            limitAmountUSD: "USD 7.500,00",
            sub: false,
          },
          {
            nameID: "Pemulangan Jenazah",
            nameEN: "Repatriation of Mortal Remains",
            limitAmountIDR: "IDR 600.000.000",
            limitAmountUSD: "USD 37.500,00",
            sub: false,
          },
          {
            nameID: "Pemulangan Jenazah (jika tetap berpergian walaupun disarankan untuk tidak berpergian oleh pemerintah)",
            nameEN: "Repatriation of Mortal Remain (if continue to travel against the government advise)",
            limitAmountIDR: "IDR 120.000.000",
            limitAmountUSD: "USD 7.500,00",
            sub: false,
          },
        ],
      },
    ];

    let _htmlMainBenefit = "";
    let choosenMainBenefit = mainBenefitObject.filter((b) => b.plan === plan.PlanName);
    choosenMainBenefit[0].mainBenefitLimit.forEach((d) => {
      let currentBenefitName = "";
      if (currency === "idr") {
        currentBenefitName = d.nameID;
      } else {
        currentBenefitName = d.nameEN;
      }

      let amount = currency === "idr" ? d.limitAmountIDR : d.limitAmountUSD;
      let subTitleAmount1 = currency === "idr" ? d.subTitleAmount1IDR : d.subTitleAmount1USD;
      let subTitleAmount2 = currency === "idr" ? d.subTitleAmount2IDR : d.subTitleAmount2USD;

      if (d.sub) {
        //    		_htmlMainBenefit += '<li><span class="card-cols"> <span>' + d.nameID + "</span><span>"+d.subTitle1+"</span> <strong>"+subTitleAmount1+"</strong><span>"+d.subTitle2+"</span> <strong>"+subTitleAmount2+"</strong></span></li>";

        _htmlMainBenefitElement = "";

        if (d.subTitle) {
          d.subTitle.forEach((item) => {
            if (currency === "idr") {
              _htmlMainBenefitElement += `<span>${item.titleIDR}</span><strong>${item.amountIDR}</strong>`;
            } else {
              _htmlMainBenefitElement += `<span>${item.titleUSD}</span><strong>${item.amountUSD}</strong>`;
            }
          });

          _htmlMainBenefit += '<li><span class="card-cols"> <span>' + currentBenefitName + "</span>" + _htmlMainBenefitElement + "</span></li>";
        } else {
          _htmlMainBenefit +=
            '<li><span class="card-cols"> <span>' +
            currentBenefitName +
            "</span><span>" +
            d.subTitle1 +
            "</span> <strong>" +
            subTitleAmount1 +
            "</strong><span>" +
            d.subTitle2 +
            "</span> <strong>" +
            subTitleAmount2 +
            "</strong></span></li>";
        }
      } else {
        _htmlMainBenefit += '<li><span class="card-cols"> <span>' + currentBenefitName + "</span> <strong>" + amount + "</strong></span></li>";
      }
    });

    const additionalBenefitObject = [
      {
        plan: "Platinum",
        additionalBenefitLimit: [
          {
            nameID: "Keterlambatan Perjalanan",
            nameEN: "Travel Delay",
            limitAmountIDR: "IDR 750.000 / 4 jam sampai dengan IDR 6.000.000",
            limitAmountUSD: "USD 46.88 / 4 jam sampai dengan USD 375.00",
          },
          {
            nameID: "Keterlambatan Perjalanan Karena Alasan Operasional",
            nameEN: "Travel Delay due to operational reason",
            limitAmountIDR: "IDR 500.000 / 4 jam sampai dengan IDR 4.000.000",
            limitAmountUSD: "USD 31.25 / 4 jam sampai dengan USD 250",
          },
          {
            nameID: "Pembatalan Perjalanan",
            nameEN: "Travel Cancellation",
            limitAmountIDR: "IDR 40.000.000",
            limitAmountUSD: "USD 2.500,00",
          },
          {
            nameID: "Penerbangan Tidak Sinambung",
            nameEN: "Flight Misconnection",
            limitAmountIDR: "IDR 650.000/4 jam sampai dengan IDR 6.500.000",
            limitAmountUSD: "USD 40.63/4 jam sampai dengan USD 406.25",
          },
          {
            nameID: "Bagasi dan Barang Milik Pribadi",
            nameEN: "Baggage and Personal Effects",
            limitAmountIDR: "IDR 4.000.000/item/set, maks. IDR 30.000.000 (dalam Agregat)",
            limitAmountUSD: "USD 250.00/item/set, maks. USD 1,875.00 (dalam Agregat)",
          },
        ],
      },
      {
        plan: "Gold",
        additionalBenefitLimit: [
          {
            nameID: "Keterlambatan Perjalanan",
            nameEN: "Travel Delay",
            limitAmountIDR: "IDR 500.000 / 4 jam sampai dengan IDR 3.000.000",
            limitAmountUSD: "USD 31.25 / 4 jam sampai dengan USD 187.50",
          },
          {
            nameID: "Keterlambatan Perjalanan Karena Alasan Operasional",
            nameEN: "Travel Delay due to operational reason",
            limitAmountIDR: "IDR 250.000 / 4 jam sampai dengan IDR 2.000.000",
            limitAmountUSD: "USD 15.63 / 4  jam sampai dengan  USD 125",
          },
          {
            nameID: "Pembatalan Perjalanan",
            nameEN: "Travel Cancellation",
            limitAmountIDR: "IDR 20.000.000",
            limitAmountUSD: "USD 1.250,00",
          },
          {
            nameID: "Penerbangan Tidak Sinambung",
            nameEN: "Flight Misconnection",
            limitAmountIDR: "IDR 325.000/4 jam sampai dengan IDR 3.250.000",
            limitAmountUSD: "USD 20.31/4 jam sampai dengan USD 203.13",
          },
          {
            nameID: "Bagasi dan Barang Milik Pribadi",
            nameEN: "Baggage and Personal Effects",
            limitAmountIDR: "IDR 2.000.000/item/set, maks. IDR 15.000.000 (dalam Agregat)",
            limitAmountUSD: "USD 125.00/item/set, maks. USD 937.50 (dalam Agregat)",
          },
        ],
      },
      {
        plan: "Silver",
        additionalBenefitLimit: [
          {
            nameID: "Keterlambatan Perjalanan",
            nameEN: "Travel Delay",
            limitAmountIDR: "IDR 250.000 / 4 jam sampai dengan IDR 1.500.000",
            limitAmountUSD: "USD 15.63 / 4 jam sampai dengan USD 93.75",
          },
          {
            nameID: "Keterlambatan Perjalanan Karena Alasan Operasional",
            nameEN: "Travel Delay due to operational reason",
            limitAmountIDR: "IDR 125.000 / 4  jam sampai dengan IDR 1.000.000",
            limitAmountUSD: "USD 7.81 / 4 jam sampai dengan USD 62.50",
          },
          {
            nameID: "Pembatalan Perjalanan",
            nameEN: "Travel Cancellation",
            limitAmountIDR: "IDR 10.000.000",
            limitAmountUSD: "USD 625,00",
          },
          {
            nameID: "Penerbangan Tidak Sinambung",
            nameEN: "Flight Misconnection",
            limitAmountIDR: "IDR 162.500/4 jam sampai dengan IDR 1.625.000",
            limitAmountUSD: "USD 10.16/4 jam sampai dengan USD 101.56",
          },
          {
            nameID: "Bagasi dan Barang Milik Pribadi",
            nameEN: "Baggage and Personal Effects",
            limitAmountIDR: "IDR 1.000.000/item/set, maks. IDR 7.500.000 (dalam Agregat)",
            limitAmountUSD: "USD 62.50/item/set, maks. USD 468.75 (dalam Agregat)",
          },
        ],
      },
    ];

    let _htmlAdditionalBenefit = "";
    let choosenAdditionalBenefit = additionalBenefitObject.filter((b) => b.plan === plan.PlanName);
    choosenAdditionalBenefit[0].additionalBenefitLimit.forEach((d) => {
      let amountAdditional = currency === "idr" ? d.limitAmountIDR : d.limitAmountUSD;
      _htmlAdditionalBenefit += '<li><span class="card-cols"> <span>' + d.nameID + "</span> <strong>" + amountAdditional + "</strong></span></li>";
    });

    let planListResultHTML = `
            <div class="swiper-slide">
              <div class="card-plan-wrapper">
                <div class="card-plan__inner">
                  <div class="card-plan">
                    <div class="card-plan-body">
                      <div class="flex-justify-between">
                        <strong>${plan.PlanName}</strong>
                        ${plan.PlanName === "Platinum" ? '<span class="card-label align-self-center">Paling Diminati <i class="fas fa-star"></i></span>' : ""}
                      </div>
                      <h3 id="PriceWrapper-${plan.PlanName}">${formattedAmount} s/d ${formattedFullBenefitAmount}<span class="text-red">*</span></h3>
                      <p id="PriceWrapper-${plan.PlanName}-Convert" class="${formattedConvertAmount ? "" : "gohide"}">${formattedConvertAmount ? formattedConvertAmount : ""} s/d ${
      formattedFullBenefitConvertAmount ? formattedFullBenefitConvertAmount : ""
    }</p>
                      <div class="benefit_type">
                        <span class="benefit_type__title">Jaminan Utama</span>
                        <div class="benefit_type__item">
                          <ul class="list-disc">
                            ${_htmlMainBenefit}
                          </ul>
                        </div>
                      </div>
                      <div class="benefit_type">
                        <span class="benefit_type__title">Jaminan Tambahan (Pilihan)</span>
                        <div class="benefit_type__item">
                          <ul class="list-disc">
                          ${_htmlAdditionalBenefit}
                          </ul>
                          <!--<p style="margin: 20px 0 0 15px;font-size: 14px;">*) Harga yang tercantum belum termasuk biaya materai</p>-->
                        </div>
                      </div>
                    </div>
                    <div class="card-plan-footer">
                      <div class="btn-buy agency__text-center">
                        <a class="btn btn__agency btn--dark-blue-outline choose-plan-btn" data-plan="${plan.PlanName}" href="javascript:void(0)">
                          <span class="position-relative">Pilih <i class="fas fa-arrow-right"></i></span>
                        </a>
                      </div>
                      <div class="link-comparison agency__text-center">
                        <a href="#Sec-2">Lihat Perbandingan Plan</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            `;

    return planListResultHTML;
  }

  $("#calculate-btn").on("click", function (e) {
    isCalculateButtonClicked = true;
  });

  // Calculate Premi
  function calculatePremi() {
    let existingSession = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    if (existingSession) {
      existingSession = JSON.parse(existingSession);
      existingSession["fp"] = 1;

      var promoCodeIncluded = false;
      if (existingSession.PromoCode) {
        promoCodeIncluded = true;
      }

      $.ajax({
        url: _apiURL + "/o/api/sti2/calculate",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(existingSession),
        success: function (response) {
          $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');

          $("#swiper-wrapper").empty();
          let finalPlanCardResult = "";

          if (response.Status) {
            if (response.Data.Calculation.AvailablePlans.length > 0) {
              const planOrder = { Platinum: 1, Gold: 2, Silver: 3 };
              response.Data.Calculation.AvailablePlans.sort((a, b) => planOrder[a.PlanName] - planOrder[b.PlanName]);
              let currency = response.Data.Calculation.Currency;
              let stampDuty = response.Data.Calculation.Stamp;
              let stampDutyIDR = response.Data.Calculation.StampInIDR;

              response.Data.Calculation.AvailablePlans.forEach((plan) => {
                let formattedAmount = "-";
                let formattedConvertAmount = "-";

                let formattedFullBenefitAmount = "-";
                let formattedFullBenefitConvertAmount = "-";

                let _TotalMainBenefitPremiumWithStamp = plan.TotalMainBenefitPremium + stampDuty;

                // IDR
                if (currency === "IDR") {
                  formattedAmount = _TotalMainBenefitPremiumWithStamp.toLocaleString("id-ID", {
                    style: "currency",
                    currency: "IDR",
                    minimumFractionDigits: 0,
                    maximumFractionDigits: 0,
                  });
                  formattedAmount = formattedAmount.replace("Rp", "IDR");

                  let fullBenefitAmount = plan.TotalMainBenefitPremium + plan.TotalAdditionalBenefitPremiumAllChecked + stampDuty;

                  formattedFullBenefitAmount = fullBenefitAmount.toLocaleString("id-ID", {
                    style: "currency",
                    currency: "IDR",
                    minimumFractionDigits: 0,
                    maximumFractionDigits: 0,
                  });
                  formattedFullBenefitAmount = formattedFullBenefitAmount.replace("Rp", "IDR");
                }

                // USD
                if (currency === "USD") {
                  formattedAmount = _TotalMainBenefitPremiumWithStamp.toLocaleString("en-US", {
                    style: "currency",
                    currency: "USD",
                  });

                  formattedAmount = formattedAmount.replace("$", "USD ");

                  let fullBenefitAmount = plan.TotalMainBenefitPremium + plan.TotalAdditionalBenefitPremiumAllChecked + stampDuty;

                  formattedFullBenefitAmount = fullBenefitAmount.toLocaleString("en-US", {
                    style: "currency",
                    currency: "USD",
                  });

                  formattedFullBenefitAmount = formattedFullBenefitAmount.replace("$", "USD ");

                  // Convert ke IDR
                  formattedConvertAmount = (plan.TotalMainBenefitPremiumInIDR + parseInt(stampDutyIDR || "0", 10)).toLocaleString("id-ID", {
                    style: "currency",
                    currency: "IDR",
                    minimumFractionDigits: 0,
                    maximumFractionDigits: 0,
                  });

                  let fullBenefitAmountInIDR = plan.TotalMainBenefitPremiumInIDR + plan.TotalAdditionalBenefitPremiumAllCheckedInIDR + parseInt(stampDutyIDR || "0", 10);

                  formattedFullBenefitConvertAmount = fullBenefitAmountInIDR.toLocaleString("id-ID", {
                    style: "currency",
                    currency: "IDR",
                    minimumFractionDigits: 0,
                    maximumFractionDigits: 0,
                  });
                }

                if (plan.PlanName === "Platinum") {
                  if (currency === "USD") {
                    finalPlanCardResult += createPlanCard("usd", plan, formattedAmount, formattedConvertAmount, formattedFullBenefitAmount, formattedFullBenefitConvertAmount);
                  } else {
                    finalPlanCardResult += createPlanCard("idr", plan, formattedAmount, null, formattedFullBenefitAmount);
                  }
                } else if (plan.PlanName === "Gold") {
                  if (currency === "USD") {
                    finalPlanCardResult += createPlanCard("usd", plan, formattedAmount, formattedConvertAmount, formattedFullBenefitAmount, formattedFullBenefitConvertAmount);
                  } else {
                    finalPlanCardResult += createPlanCard("idr", plan, formattedAmount, null, formattedFullBenefitAmount);
                  }
                } else if (plan.PlanName === "Silver") {
                  if (currency === "USD") {
                    finalPlanCardResult += createPlanCard("usd", plan, formattedAmount, formattedConvertAmount, formattedFullBenefitAmount, formattedFullBenefitConvertAmount);
                  } else {
                    finalPlanCardResult += createPlanCard("idr", plan, formattedAmount, null, formattedFullBenefitAmount);
                  }
                }
              });

              // add calculation detail to session storage
              sessionStorage.setItem(_smartTravelInternationalCalculation, JSON.stringify(response.Data.Calculation));

              $("#swiper-wrapper").html(finalPlanCardResult);

              $(".choosen-plan-wrapper").removeClass("gohide");

              // jika ada choosenplan sebelumnya, maka pakai itu
              // jika tidak ada, default pilih yang pertama, yaitu Platinum.
              if (existingSession.ChoosenPlan) {
                $('.choose-plan-btn[data-plan="' + existingSession.ChoosenPlan + '"]').click();
              } else {
                setTimeout(function () {
                  $(".choose-plan-btn").first().click();
                }, 1000);
              }

              if (isCalculateButtonClicked) {
                $("html, body").animate(
                  {
                    scrollTop: $(".choosen-plan-wrapper").offset().top,
                  },
                  400
                );
              }
            } else {
              $(".choosen-plan-wrapper").addClass("gohide");
            }
          } else {
            if (promoCodeIncluded) {
              if (typeof response.PromoCodeResponse !== "undefined") {
                if (response.PromoCodeResponse) {
                  removePromoCode();
                  alert(response.Message ? response.Message : "Calculate Failed");
                  return false;
                }
              }
            }
            //	        	  removePromoCode();
            //	            alert(response.Message ? response.Message : "Calculate Failed");
          }
        },
        error: function (xhr, status, error) {
          $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
          console.error("Error:", error);
        },
      });
    }
  }

  // Submit Form Simulation
  // --------------------------------------------------------------------------
  $("#form-simulation").on("submit", function (e) {
    e.preventDefault();
    calculatePremi();
  });

  function showModal(title, description) {
    console.log(title);
    console.log(description);
  }

  $('input[name="Currency"]').on("change", function () {
    let choosenCurrency = $(this).attr("id");
    $(".plan-comparation").empty();
    $(".modal-plan-description-wrapper").empty();

    $.ajax({
      url: _apiURL + "/o/api/sti2/compareplan",
      type: "GET",
      success: function (response) {
        if (response && response.Status) {
          if (response.Data.length > 0) {
            let panelHTML = "";
            var randomIdA = 1;
            response.Data.forEach((item) => {
              let tBody = "";
              var randomId = 1;
              item.benefit.forEach((b) => {
                tBody += `<tr>
            					  <td><span>${b.benefitName}</span><a href="javascript:void(0)" class="info-link" data-bs-toggle="modal" data-bs-target="#rnd${randomIdA}${randomId}">?</a></td>
            					  <td>${choosenCurrency === "idr" ? formatStringToList(b.idr.Platinum) : formatStringToList(b.usd.Platinum)}</td>
            					  <td>${choosenCurrency === "idr" ? formatStringToList(b.idr.Gold) : formatStringToList(b.usd.Gold)}</td>
            					  <td>${choosenCurrency === "idr" ? formatStringToList(b.idr.Silver) : formatStringToList(b.usd.Silver)}</td>
            					  </tr>`;

                // modal

                let modalHTML = `
          					    <!-- Modal -->
          					    <div class="modal modal-axa-smarttravel fade" id="rnd${randomIdA}${randomId}" tabindex="-1" aria-labelledby="rnd${randomIdA}${randomId}_label" aria-hidden="true" style="display: none;">
          					        <div class="modal-dialog modal-axa-smarttravel-dialog modal-lg">
          					            <div class="modal-content modal-axa-smarttravel-content">
          					                <div class="modal-header modal-axa-smarttravel-header">
          					                    <h1 class="modal-title fs-5" id="rnd${randomIdA}${randomId}_label">Info Tambahan</h1>
          					                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
          					                        <i class="far fa-times fa-fw"></i>
          					                    </button>
          					                </div>
          					                <div class="modal-body modal-axa-smarttravel-body modal-axa-smarttravel-body__benefit_description">
          					                    <h3>${b.benefitName}</h3>
          					                    <p>${b.benefitDescription}</p>
          					                </div>
          					            </div>
          					        </div>
          					    </div>
          					`;

                $(".modal-plan-description-wrapper").append(modalHTML);

                randomId++;
              });

              let planCompareAdditionalBenefitSection =
                item.nameId === "Jaminan Ketidaknyamanan Perjalanan" ? '<div><h4 class="plan-compare-additional-benefit-section">Jaminan Tambahan (Pilihan)</h4></div>' : "";

              panelHTML += `${planCompareAdditionalBenefitSection}<div class="panel-table"><div class="panel-table-header"><h4>${item.nameId}</h4></div>
        				  <div class="panel-table-body">
        				  <div class="table-wrapper">
        				  <table class="table-axa table-w-auto">
        				  <thead>
        					  <tr>
        					  	<td>&nbsp;</td>
        					  	<td style="text-transform: none">Platinum</td>
        					  	<td style="text-transform: none">Gold</td>
        					  	<td style="text-transform: none">Silver</td>
        					  </tr>
        				  </thead>
        				  <tbody style="vertical-align:top;">${tBody}</tbody>
        				  </table>
        				  </div>
        				  </div>
        				  </div>`;

              randomIdA++;
            });

            $(".plan-comparation").html(panelHTML);
          }
        }
      },
    });
  });

  // Init Form Simulation
  // Using pageshow to prevent cache when user using back navigation from step2
  //  $(window).on("pageshow", function (event) {
  sessionStorage.clear();
  $("#form-simulation")[0].reset();
  $("#idr").prop("checked", true).trigger("change");
  $("#travel-type").val("Single").trigger("change");
  $("#individual").prop("checked", true).trigger("change");
  $("#destinasi").trigger("change");
  $('[name="DepartureDate"]').trigger("change");
  $('[name="ArrivalDate"]').trigger("change");
  $("#destinasi").trigger("change");

  updateSess(_smartTravelInternationalFormDetailSess, "FromStep1", true);
  firstLoadStep1 = false;

  if (utm_source !== "null" && utm_source !== "") {
    updateSess(_smartTravelInternationalFormDetailSess, "UtmSource", utm_source);
  }

  if (pc !== "null" && pc !== "") {
    updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
    updateSess(_smartTravelInternationalFormDetailSess, "ChoosenPlan", "Platinum");
    calculatePremi();
  } else {
    $("#form-simulation").submit();
  }

  $(".next-step-btn").on("click", function (e) {
    e.preventDefault();
    displayLoading();
    window.location.href = _nextStepURL;
  });

  $("#promo-code-btn").on("click", function (e) {
    $(this).html('<span class="position-relative order-10">Loading....</span>');
    let el = $(this);
    let pc = $('input[name="PromoCode"]').val();
    updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
    calculatePremi();

    $(".trigger-collapse-promo").trigger("click"); // tutup sticky promocode dan tampilkan summary
  });
}); // end document ready
