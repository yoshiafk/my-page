let selectedBenefits = []; //variable global untuk tampung data benefitId
let promoCodeSubmitStat = false;

$(document).ready(function () {

  // CHECKBOX ADDITIONAL BENEFIT
  function updateCheckBoxBenefit() {
    let formDetail = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));
    if (formDetail && formDetail.AdditionalBenefits) {
        if (formDetail.AdditionalBenefits.length > 0) {
            formDetail.AdditionalBenefits.forEach(idBenefit => {
                $('#switch-' + idBenefit).prop('checked', true);
            });
        }
    }
  }
  
	if (businessModel == "B2B" || businessModel == "B2B2C") {
		if (managedBy != managedByParam) {
	        document.querySelector(".modal_alert-body").innerHTML = `Maaf, kami tidak bisa menerima pengajuan Anda secara online saat ini. Silakan hubungi Administrator untuk pengecekan lebih lanjut.`;
	        const modalContent = document.querySelector(".modal_alert-content");
	
	        if (modalContent) {
	          modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
	        }
	
	        openModalAlertBlocked();
	        return;
		}
	}
	
	if (_quoteCategory == "edit") {
		$(".promo-code").val('');
		updateSess(_smartActiveFormDetailSess, "PromoCode", "");
	}
	
  var $rangeSlider = $("#range");

  // Ambil nilai dari option dalam #valueSelect
  var sliderValues = $("#valueSelect option")
    .map(function () {
      return parseInt($(this).val(), 10);
    })
    .get();

  // Function untuk format angka dengan titik
  function formatNumber(num) {
    return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
  }

  // Inisialisasi range slider dengan nilai dari select option
  $rangeSlider.ionRangeSlider({
    skin: "round",
    values: sliderValues.map(String), // Konversi ke string untuk kompatibilitas
    from: 0,
    prettify: function (value) {
      return formatNumber(value); // Format angka dengan titik
    },
    onStart: function (data) {
      $(".irs-single").text(formatNumber(sliderValues[data.from]));
    },
    onChange: function (data) {
      var selectedValue = sliderValues[data.from]; // Ambil nilai numerik
      $("#valueSelect").val(selectedValue).trigger("change");

      $(".irs-single").text(formatNumber(selectedValue)); // Update tampilan

      $(".irs-single").removeClass("low medium high");
      if (data.from <= 1) {
        $(".irs-single").addClass("low");
      } else if (data.from <= 3) {
        $(".irs-single").addClass("medium");
      } else {
        $(".irs-single").addClass("high");
      }
    },
  });

  // Handle perubahan di select dan update slider
  $("#valueSelect").on("change", function () {
    var selectedValue = parseInt($(this).val(), 10);
    var index = sliderValues.indexOf(selectedValue);
    if (index !== -1) {
      var sliderInstance = $rangeSlider.data("ionRangeSlider");
      sliderInstance.update({
        from: index,
      });

      $(".irs-single").text(formatNumber(selectedValue)); // Update tampilan

      $(".irs-single").removeClass("low medium high");
      if (index <= 1) {
        $(".irs-single").addClass("low");
      } else if (index <= 3) {
        $(".irs-single").addClass("medium");
      } else {
        $(".irs-single").addClass("high");
      }
    }

    //setiap ganti main value check trigger benefit;
    updateAdditionalBenefitSection();
    setTimeout(() => {
      updateCheckBoxBenefit();
    }, 500);
  });

  // rangeSlider End
  $("#select-plan").select2({
    dropdownParent: "#select-plan-wrapper",
    placeholder: "Pilih Plan",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $("#type-of-work").select2({
    dropdownParent: "#type-of-work-wrapper",
    placeholder: "Pilih Pekerjaan Anda",
    width: "100%",
  });

  $(".valueSelect").select2({
    width: "100%",
    dropdownParent: "#valueSelect-wrapper",
    minimumResultsForSearch: -1,
  });

  $("#choose-plan-birth").daterangepicker({
    parentEl: "#choose-plan-birth-wrapper",
    singleDatePicker: true,
    showDropdowns: true,
    startDate: maxBirthDate,
    minDate: minBirthDate, // Set minimal 75 tahun lalu
    maxDate: maxBirthDate, // Set maksimal 30 tahun lalu
    autoUpdateInput: false,
    buttonClasses: "btn-date",
    applyButtonClasses: "btn-apply",
    cancelClass: "btn-cancel",
    locale: {
      format: "DD/MMM/YYYY",
      firstDay: 1,
      applyLabel: "Pilih",
      cancelLabel: "Batal",
      "daysOfWeek": ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
      "monthNames": ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
    },
  });

  $("#from").daterangepicker({
    parentEl: "#from-wrapper",
    autoUpdateInput: false,
    singleDatePicker: true,
    showDropdowns: true,
    minDate: today,
    maxDate: today.clone().add(30, "days"),
    buttonClasses: "btn-date",
    applyButtonClasses: "btn-apply",
    cancelClass: "btn-cancel",
    locale: {
      format: "DD/MMM/YYYY",
      firstDay: 1,
      applyLabel: "Pilih",
      cancelLabel: "Batal",
      "daysOfWeek": ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
      "monthNames": ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
    },
  });

  $("#from, #choose-plan-birth").on(
    "apply.daterangepicker",
    function (ev, picker) {
      const monthMap = {
		  Jan: "Jan",
		  Feb: "Feb",
		  Mar: "Mar",
		  Apr: "Apr",
		  May: "Mei",
		  Jun: "Jun",
		  Jul: "Jul",
		  Aug: "Agt",
		  Sep: "Sep",
		  Oct: "Okt",
		  Nov: "Nov",
		  Dec: "Des"
      };
      moment.locale("id");
      let formattedDate = picker.startDate.format("DD/MMM/YYYY");
      const englishMonth = picker.startDate.format("MMM");
      if (monthMap[englishMonth] && formattedDate.includes(`/${englishMonth}/`)) {
    	  // Replace bagian bulan (mid) dari formattedDate
		  formattedDate = formattedDate.replace(`/${englishMonth}/`, `/${monthMap[englishMonth]}/`);
	  }

      $(this).val(formattedDate);

      // Cari elemen terdekat dengan kelas sa-input-group-axa untuk field datepicker
      const $datepickerWrapper = $(this).closest(".sa-input-group-axa");
      if (
        $datepickerWrapper.length &&
        $datepickerWrapper.hasClass("invalid-sa")
      ) {
        $datepickerWrapper.removeClass("invalid-sa");
      }

      //untuk validasi until !> from
      if ($(this).is("#from")) {
    	moment.locale("id");
    	  
        $("input[name='PeriodeFrom']").val(formattedDate).trigger('change');

        maxBirthDate = picker.startDate.clone().subtract(30, "days");
        minBirthDate = picker.startDate.clone().subtract(75, "years");

        $("#choose-plan-birth")
          .data("daterangepicker")
          .setStartDate(maxBirthDate);
        $("#choose-plan-birth")
          .data("daterangepicker")
          .setEndDate(maxBirthDate);
        $("#choose-plan-birth").data("daterangepicker").minDate = minBirthDate;
        $("#choose-plan-birth").data("daterangepicker").maxDate = maxBirthDate;

        //sebelum end otomatis setahun
        //    		const toTimespanPicker = $('#until').data('daterangepicker');
        //
        //            const topdateallVal = $('#until').val();
        //            const topdateallDate = moment(topdateallVal, 'DD MMM YYYY');
        //
        //            if (picker.startDate.isAfter(topdateallDate)) {
        //                toTimespanPicker.minDate = picker.startDate;
        //                toTimespanPicker.setStartDate(picker.startDate);
        //                $('#until').val(formattedDate);
        //            } else {
        //                toTimespanPicker.minDate = picker.startDate;
        //                toTimespanPicker.setStartDate(picker.startDate);
        //            }

        // Tambahkan 1 tahun ke "until"
        const untilDate = picker.startDate.clone().add(1, "year");
        let untilFormatted = untilDate.format("DD/MMM/YYYY");
        const englishMonthUntil = untilDate.format("MMM");
        if (monthMap[englishMonthUntil] && untilFormatted.includes(`/${englishMonthUntil}/`)) {
      	  // Replace bagian bulan (mid) dari formattedDate
        	untilFormatted = untilFormatted.replace(`/${englishMonthUntil}/`, `/${monthMap[englishMonthUntil]}/`);
  	  }
        $("#until").val(untilFormatted); // Set ke input
        $("input[name='PeriodeTo']").val(untilFormatted).trigger('change');
      }
      
      if ($(this).is("#choose-plan-birth")) {
    	$("input[name='Dob']").val(formattedDate).trigger('change');
      }

      //check form trigger button disable or enable
      validateForm();
    }
  );

  $("#from, #choose-plan-birth").on(
    "cancel.daterangepicker",
    function (ev, picker) {
      $(this).val("");

      if ($(this).is("#from")) {
        const today = moment();
        maxBirthDate = today.clone().subtract(30, "days");
        minBirthDate = today.clone().subtract(75, "years");

        $("#choose-plan-birth").val("");
        $("#choose-plan-birth")
          .data("daterangepicker")
          .setStartDate(maxBirthDate);
        $("#choose-plan-birth")
          .data("daterangepicker")
          .setEndDate(maxBirthDate);
        $("#choose-plan-birth").data("daterangepicker").minDate = minBirthDate;
        $("#choose-plan-birth").data("daterangepicker").maxDate = maxBirthDate;
      }

      validateForm();
    }
  );

  $('input[name="radio-polis"]').on("change", function () {
    validateForm();
  });

  $(".btn__next").on("click", function (e) {
    e.preventDefault();

    let sessData = JSON.parse(
      sessionStorage.getItem(_smartActiveFormDetailSess)
    ); //nama refer in main.js
    const kycPayload = collectData();

    const payload = {
      kyc: kycPayload,
      Quotation: 0,
      AdditionalBenefits: sessData.AdditionalBenefits || selectedBenefits,
    };
    
    if (_quoteCategory == 'continue') {
    	if (sessData.Token) {
    		delete sessData.Token;
        }
    }

    if (_quoteCategory == 'edit') payload.Category = _quoteCategory;
    if (sessData.Token) payload.Token = sessData.Token;
    if (sessData.BusinessModel) payload.BusinessModel = sessData.BusinessModel;
    if (sessData.ManagedBy) payload.ManagedBy = sessData.ManagedBy;
    if (sessData.ManagedById) payload.ManagedById = sessData.ManagedById;
    if (sessData.Role) payload.Role = sessData.Role;
    if (sessData.UtmSource) payload.UtmSource = sessData.UtmSource;
    if (sessData.UtmMedium) payload.UtmMedium = sessData.UtmMedium;
    if (sessData.utmCampaign) payload.utmCampaign = sessData.utmCampaign;
    if (sessData.UtmTerm) payload.UtmTerm = sessData.UtmTerm;
    if (sessData.UtmContent) payload.UtmContent = sessData.UtmContent;
    payload.TokenLimiter = $('input[name="csrfToken"]').val();
    
    const promoCode = sessData.PromoCode;
    payload.PromoCode = promoCode;
    
    if (kycPayload.ExcludedActivityStatus == 1) {
        document.querySelector(".modal_alert-body").innerHTML = `Maaf, kami tidak bisa menerima pengajuan Anda secara online saat ini.
Silakan hubungi Customer Care Center kami di 1500 733 (Senin-Jumat, 08.00-17.00 WIB) untuk informasi lebih lanjut.`;
        const modalContent = document.querySelector(".modal_alert-content");

        if (modalContent) {
        	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
        }

        openModalAlertBlocked();
        return;
      }

    let thisEl = $(this);

    $.ajax({
      url: _setTransactionURL,
      type: "POST",
      dataType: "json",
      data: { data: JSON.stringify(payload), type: 'initiate' },
      beforeSend: function () {
        displayLoading();
      },
      success: function (response) {
        if (response.Status) {
          let token = response.Data.Token;

          // Format ulang data sesuai yang diinginkan
          let sessionData = {
            ExcludedActivityStatus: payload.kyc.ExcludedActivityStatus,
            MainBenefitValue: payload.kyc.MainBenefitValue,
            PeriodeFrom: payload.kyc.PeriodeFrom,
            PeriodeTo: payload.kyc.PeriodeTo,
            Token: token,
            AdditionalBenefits: sessData.AdditionalBenefits || selectedBenefits,
          };

          // Simpan ke sessionStorage
          Object.entries(sessionData).forEach(([key, value]) => {
            updateSess(_smartActiveFormDetailSess, key, value);
          });

          window.location.href = _nextStepURL;
        } else {
          $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
          document.querySelector(".modal_alert-body").innerHTML =
            response.Message;
          const modalContent = document.querySelector(".modal_alert-content");

          if (modalContent) {
        	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
          }

          openModalAlertBlocked();
          hideLoading();
          return;
        }
      },
    });
  });

  // PROMO CODE
  $('#promo-code-btn').on('click', function (e) {
	  
	  if(!validateCalculateParam()) {
		  document.querySelector('input[name="PromoCode"]').value = "";
		  document.querySelector(".modal_alert-body").innerHTML = `Silakan lengkapi data yang dibutuhkan terlebih dahulu untuk menggunakan Kode Promo.`;
	      const modalContent = document.querySelector(".modal_alert-content");
	
	      if (modalContent) {
	    	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
	      }
	
	      openModalAlertBlocked();
		  return false;
		}
	  
    $(this).html('<span class="position-relative order-10">Loading....</span>');
     let el = $(this);
     let pc = $('input[name="PromoCode"]').val();
     $('input[name="PromoCodeSidebar"]').val(pc);
     
     updateSess(_smartActiveFormDetailSess, "PromoCode", pc.toUpperCase());
     promoCodeSubmitStat = true;
     calculatePremi();
     $(".trigger-collapse-promo").trigger('click'); // tutup sticky promocode dan tampilkan summary

});
  
  $('#clear-promo-code-btn-sidebar').on('click', function(e) {
	  if(!validateCalculateParam()) {
		  document.querySelector('input[name="PromoCode"]').value = "";
		  document.querySelector(".modal_alert-body").innerHTML = `Silakan lengkapi data yang dibutuhkan terlebih dahulu untuk menggunakan Kode Promo.`;
	      const modalContent = document.querySelector(".modal_alert-content");
	
	      if (modalContent) {
	    	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
	      }
	
	      openModalAlertBlocked();
		  return false;
		}
	  
	  let pc = $('input[name="PromoCodeSidebar"]').val();
	  $('input[name="PromoCode"]').val(pc);
	  
	  updateSess(_smartActiveFormDetailSess, "PromoCode", pc.toUpperCase());
	  promoCodeSubmitStat = true;
	  calculatePremi();
  });
 
  // POPUP KIRIM PENAWARAN
  $("#send_quotation_btn_close").on("click", function () {
    quotationModal.hide();
  });

  $("#submit-quotation-btn").on("click", function (e) {
    $('input[name="send_quotation_name"]').val("");
    $('input[name="send_quotation_email"]').val("");
    //gak harus ada data di session, mungkin aja saat pertama bukan sudah perlu kirim quote
    quotationModal.show();
  });

  // SUBMIT KIRIM PENAWARAN 
  $("#send_quotation_form").on("submit", function (e) {
    e.preventDefault();
    let btn = $(this).find('button[type="submit"]');

    let _name = $(this)
      .find('input[name="send_quotation_name"]')
      .val()
      .toUpperCase();
    let _email = $(this).find('input[name="send_quotation_email"]').val();

    if (_name.length == 0) {
      quotationModal.hide();
      document.querySelector(".modal_alert-body").innerHTML =
        "Nama atau email tidak sesuai";
      const modalContent = document.querySelector(".modal_alert-content");

      if (modalContent) {
    	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
      }

      openModalAlertBlocked();
      return;
    }

    if (
      _email.length == 0 ||
      !/^[A-Za-z0-9.+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/.test(_email)
    ) {
      quotationModal.hide();
      document.querySelector(".modal_alert-body").innerHTML =
        "Nama atau email tidak sesuai";
      const modalContent = document.querySelector(".modal_alert-content");

      if (modalContent) {
    	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
      }

      openModalAlertBlocked();
      return;
    }

    var Data = {};

    //ambil dari session jika ada
    let sessData = sessionStorage.getItem(_smartActiveFormDetailSess); //nama refer in main.js
    if (sessData) {
      sessData = JSON.parse(sessData);
      sessData["Quotation"] = "1";
      sessData["Name"] = _name;
      sessData["Email"] = _email;
      sessData["AdditionalBenefits"] = sessData.AdditionalBenefits || selectedBenefits; // Tetap ambil dari selected karena mungkin ada perubahan

      // Hanya set nilai jika key belum ada di session data
      if (!sessData.hasOwnProperty("ExcludedActivityStatus")) {
        sessData["ExcludedActivityStatus"] = getCheckedValue(
          'input[name="radio-polis"]'
        );
      }
      if (!sessData.hasOwnProperty("Job")) {
        sessData["Job"] = getValue('select[name="Occupation"]');
      }
      if (!sessData.hasOwnProperty("Dob")) {
        sessData["Dob"] = getValue('input[name="plan-birth"]');
      }
      if (!sessData.hasOwnProperty("MainBenefitValue")) {
        sessData["MainBenefitValue"] = getValue(
          'select[name="MainBenefitValue"]'
        );
      }
      if (!sessData.hasOwnProperty("PeriodeFrom")) {
        sessData["PeriodeFrom"] = getValue('input[name="PeriodeFrom"]');
      }
      if (!sessData.hasOwnProperty("PeriodeTo")) {
        sessData["PeriodeTo"] = getValue('input[name="PeriodeTo"]');
      }
      if (!sessData.hasOwnProperty("PromoCode")) {
          sessData["PromoCode"] = getValue('input[name="PromoCode"]') || getValue('input[name="PromoCodeSidebar"]');
      }
      
      if (sessData.hasOwnProperty("Token")) {
    	  delete sessData.Token;
      }

      Data = sessData;
    } else {
      //misal ambil dari form bukan session berarti tidak ada Token

      //ambil dari form
      var kycPayload = collectData();

      kycPayload["Quotation"] = "1";
      kycPayload["Name"] = _name;
      kycPayload["Email"] = _email;

      kycPayload["ExcludedActivityStatus"] = getCheckedValue(
        'input[name="radio-polis"]'
      );
      kycPayload["Job"] = getValue('select[name="Occupation"]');
      kycPayload["Dob"] = getValue('input[name="plan-birth"]');
      kycPayload["MainBenefitValue"] = getValue(
        'select[name="MainBenefitValue"]'
      );
      kycPayload["PeriodeFrom"] = getValue('input[name="PeriodeFrom"]');
      kycPayload["PeriodeTo"] = getValue('input[name="PeriodeTo"]');
      kycPayload["PromoCode"] = getValue('input[name="PromoCode"]');

      kycPayload["AdditionalBenefits"] = selectedBenefits;

      Data = kycPayload;
    }
    
    Data.TokenLimiter = $('input[name="csrfToken"]').val();

    if (
      Data.Job.length == 0 ||
      Data.Dob.length == 0 ||
      Data.MainBenefitValue.length == 0 ||
      Data.PeriodeFrom.length == 0
    ) {
      quotationModal.hide();
      document.querySelector(".modal_alert-body").innerHTML =
        "Periksa kelengkapan data Anda";
      const modalContent = document.querySelector(".modal_alert-content");

      if (modalContent) {
    	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
      }

      openModalAlertBlocked();
      return;
    }
    
    if (Data.ExcludedActivityStatus == 1) {
    	quotationModal.hide();
        document.querySelector(".modal_alert-body").innerHTML = `Maaf, kami tidak bisa menerima pengajuan Anda secara online saat ini.
Silakan hubungi Customer Care Center kami di 1500 733 (Senin-Jumat, 08.00-17.00 WIB) untuk informasi lebih lanjut.`;
        const modalContent = document.querySelector(".modal_alert-content");

        if (modalContent) {
        	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
        }

        openModalAlertBlocked();
        return;
      }
    
    $.ajax({
      url: _setTransactionURL,
      type: "POST",
      dataType: "json",
      data: { data: JSON.stringify(Data), type: 'initiate' },
      beforeSend: function () {
        $(btn)
          .html(
            '<span class="modal_penawaran-agency__text-amber-300"> LOADING... </span>'
          )
          .attr("disabled", true);
      },
      success: function (response) {
        document.querySelector(".modal_alert-body").innerHTML =
          response.Message;
        const modalContent = document.querySelector(".modal_alert-content");
        const okButton = document.querySelector(
          ".ispep_modal__inner-footer-btn"
        );

        if (modalContent) {
        	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
        }

        openModalAlertBlocked();

        if (response.Status) {
          // KENAPA UPDATE BUKAN CLEAR SESSION?
          // UPDATE SESSION SET DataBenefits
          //		    	      let dataBenefits = response.BenefitsAgent;
          //		    	      if (typeof dataBenefits === 'string') {
          //		    	          dataBenefits = JSON.parse(dataBenefits);
          //		    	      }
          //
          //		    	      let sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);
          //		    	      sessionData = sessionData ? JSON.parse(sessionData) : {};
          //		    	      // Update key 'DataBenefits' dengan dataBenefits
          //		    	      sessionData.DataBenefits = dataBenefits;
          //		    	      sessionStorage.setItem(_smartActiveFormDetailSess, JSON.stringify(sessionData));

          sessionStorage.clear();

          if (okButton) {
            okButton.onclick = () =>
              closeModalAlertBlocked(response.Data.target);
          }
        } else {
          $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
          if (typeof response.Blocked !== "undefined") {
            if (okButton) {
              okButton.onclick = () =>
                closeModalAlertBlocked(response.Data.target);
            }
          }
        }
      },
      complete: function () {
        $(btn)
          .html(
            '<span class="modal_penawaran-agency__text-amber-300"> KIRIM </span><i class="fas fa-arrow-right ml-2level"></i>'
          )
          .attr("disabled", false);
        quotationModal.hide();
      },
    });
  });

  // FORM CHANGE EVENT LISTENER
  $(document).on("change", ".form-item", function (e) {
    let existingSession = sessionStorage.getItem(_smartActiveFormDetailSess);

    let _dataForSession = {};
    let inputType = $(this).attr("type");
    let inputName = $(this).attr("name");
    let sessKey = $(this).attr("name");
    sessKey = sessKey == "radio-polis" ? "ExcludedActivityStatus" : sessKey == "plan-birth" ? "Dob" : sessKey;

    let currentVal = $(this).val() || "";
    _dataForSession[sessKey] = currentVal;

    if (existingSession) {
      let mergedSession = {
        ...JSON.parse(existingSession),
        ..._dataForSession,
      };
      sessionStorage.setItem(
        _smartActiveFormDetailSess,
        JSON.stringify(mergedSession)
      );
    } else {
      sessionStorage.setItem(
        _smartActiveFormDetailSess,
        JSON.stringify(_dataForSession)
      );
    }
    calculatePremi();
  });
  
  $(document).on("change", ".parent", function () {
      const parent = $(this);
      const panel = $(this).closest(".col-panel-switch");
      const childCheckboxes = panel.find(".child");

      childCheckboxes.prop("checked", $(this).is(":checked"));

      let additionalBenefitsArr = [];
      let travelData = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));

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

      updateSess(_smartActiveFormDetailSess, "AdditionalBenefits", additionalBenefitsArr);
      selectedBenefits = Array.from(document.querySelectorAll(".child:checked")).map((cb) => Number(cb.id.replace("switch-", "")));

      calculatePremi();
  });

  $(document).on("change", ".child", function () {
      let additionalBenefitsArr = [];
      let _sessData = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));

      if (_sessData && _sessData.AdditionalBenefits) {
          additionalBenefitsArr = _sessData.AdditionalBenefits;
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
      
      updateSess(_smartActiveFormDetailSess, "AdditionalBenefits", additionalBenefitsArr);
      
      // jika semua checked, maka parent checked juga
      const panel = $(this).closest(".col-panel-switch");
      const parentCheckbox = panel.find(".parent");
      const childCheckboxes = panel.find(".child");

      const allChecked = childCheckboxes.length === childCheckboxes.filter(":checked").length;
      parentCheckbox.prop("checked", allChecked);
      
      selectedBenefits = Array.from(document.querySelectorAll(".child:checked")).map((cb) => Number(cb.id.replace("switch-", "")));
      
      calculatePremi();
  });

  // Call saat pertama kali halaman diload
  updateAdditionalBenefitSection();

  // CHECK SESSION DATA GET TOKEN
  const sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);
  if (sessionData) {

    const data = JSON.parse(sessionData);
    let promoCode = data["PromoCode"];

    if (promoCode) {
        $('input[name="PromoCode"]').val(promoCode);
        $('input[name="PromoCodeSidebar"]').val(promoCode);
    }

    // Update Form
    reinitDataForm(data);
    // Checks Leads API
    checkLeads(data);

    setTimeout(() => {
      updateCheckBoxBenefit();
    }, 500)

    if (_quoteCategory == "edit") {
    	setTimeout(() => {
        	validateForm();
	    }, 500)
    }
  }

  $('[name="MainBenefitValue"]').trigger("change");
}); // END DOCUMENT READY

function checkLeads(sessionData) {
  let token = sessionData.Token;

  $.ajax({
    url: _apiURL + `/o/api/sa/check/leads?t=${token}`,
    type: "GET",
    success: function (response) {
      if (response.status) {
        const dataLeads = response.data;

        // Mengisi kembali select option untuk pekerjaan
        if (dataLeads.Job) {
          const jobSelect = $('select[name="Occupation"]');
          if (jobSelect.length) {
            jobSelect.val(dataLeads.Job).trigger("change"); // Update nilai dan trigger event change
          }
        }

        if (typeof moment !== "undefined") {
          // datepicker butuh "16/Mei/2025" -> 03-06-1995
          // Mengisi kembali tanggal lahir
          if (dataLeads.Dob) {
            moment.locale("id");

            const startDate = moment(
              sessionData.PeriodeFrom,
              "DD/MMM/YYYY",
              true
            );

            maxBirthDate = startDate.clone().subtract(30, "days");
            minBirthDate = startDate.clone().subtract(75, "years");

            $("#choose-plan-birth").data("daterangepicker").minDate =
              minBirthDate;
            $("#choose-plan-birth").data("daterangepicker").maxDate =
              maxBirthDate;

            /**
             * kalau data  = Wed Aug 14 00:00:00 GMT 2024 pakai -> new Date(dataLeads.Dob)
             * kalau data = 14/Aug/2024  dataLeads.Dob
             */
            let value = moment(new Date(dataLeads.Dob)).format("DD/MMM/YYYY"); //
            $("#choose-plan-birth").val(value);
            $("#choose-plan-birth").data("daterangepicker").setStartDate(value);
            $("#choose-plan-birth").data("daterangepicker").setEndDate(value);
          }
        } else {
          console.error(
            "Moment.js tidak tersedia. Pastikan moment.js sudah dimuat."
          );
        }

        //trigger button
        validateAndToggleButtons(sessionData);
      }
    },
    error: function () {
      console.error("Gagal mengambil informasi tambahan.");
    },
  });
}

function infoBenefit(e, element) {
  e.preventDefault();
  const target = $(element).data("target");
  $.ajax({
    url: _apiURL + `/o/api/sa/additional-info/benefits?a=${target}`,
    type: "GET",
    success: function (response) {
      const content = `<h3>${response.data.title}</h3>
                             ${response.data.description}`;

      $(".modal-axa-smartactive-body").empty().append(content);
      $(moreinfoModal).modal("show");
    },
    error: function () {
      console.error("Gagal mengambil informasi tambahan.");
    },
  });
}

//function initToggleCheckboxBenefit() {
//  let additionalBenefitsFromSession = [];
//  const sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);
//  if (sessionData) {
//    const parsedData = JSON.parse(sessionData); // Konversi ke objek
//    if (parsedData.AdditionalBenefits) {
//      additionalBenefitsFromSession = parsedData.AdditionalBenefits; // Ambil dari session
//    }
//  }
//
//  const panels = document.querySelectorAll(".col-panel-switch");
//
//  panels.forEach((panel) => {
//    const parentCheckbox = panel.querySelector(".parent");
//    const childCheckboxes = panel.querySelectorAll(".child");
//
//    function updateParentCheckbox() {
//      const allChecked = Array.from(childCheckboxes).every((cb) => cb.checked);
//      const someChecked = Array.from(childCheckboxes).some((cb) => cb.checked);
//      parentCheckbox.checked = allChecked;
//      parentCheckbox.indeterminate = !allChecked && someChecked;
//      getCheckedValues();
//    }
//
//    /**
//     * IF SESSION SECTION
//     * JIKA DI SESSION SUDAH ADA BENEFIT TERPILIH. CHECKED
//     */
//    // Loop untuk menandai child checkbox yang ada di session
//    childCheckboxes.forEach((cb) => {
//      const benefitId = Number(cb.id.replace("switch-", "")); // Ambil ID dari checkbox
//      if (additionalBenefitsFromSession.includes(benefitId)) {
//        cb.checked = true; // Otomatis pilih checkbox
//      }
//    });
//    //END SESSION SECTION
//
//    // Pastikan parent checkbox diperbarui setelah setting child checkboxes
//    updateParentCheckbox();
//
//    parentCheckbox.addEventListener("change", function () {
//      childCheckboxes.forEach((cb) => {
//        cb.checked = parentCheckbox.checked;
//      });
//      getCheckedValues();
//    });
//
//    childCheckboxes.forEach((cb) => {
//      cb.addEventListener("change", updateParentCheckbox);
//    });
//  });
//
//  function getCheckedValues() {
//    selectedBenefits = Array.from(
//      document.querySelectorAll(".child:checked")
//    ).map((cb) => Number(cb.id.replace("switch-", ""))); // Hapus prefix "switch-"
//  }
//}

function handleSelection(container) {
  if (container.classList.contains("invalid-sa")) {
    container.classList.remove("invalid-sa");
  }
}

function collectData() {
  const data = {
    ExcludedActivityStatus: getCheckedValue('input[name="radio-polis"]'),

    Job: getValue('select[name="Occupation"]'),

    Dob: getValue('input[name="plan-birth"]'), //tanggal lahir

    MainBenefitValue: getValue('select[name="MainBenefitValue"]'),

    PeriodeFrom: getValue('input[name="PeriodeFrom"]'),

    PeriodeTo: getValue('input[name="PeriodeTo"]'),
  };

  return data;
}

function updateAdditionalBenefitSection(debug = false) {
  let selectedMainBenefitValue = $("#valueSelect").val();

  $.ajax({
    url: _apiURL + "/o/api/sa/additionalbenefit",
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify({ MainBenefitValue: selectedMainBenefitValue }),
    success: function (response) {
      try {
        let data = response.Data;
        if (typeof data === "string") {
          data = JSON.parse(data);
        }

        if (!Array.isArray(data)) {
          console.error("Expected an array but received:", data);
          document.querySelector(".modal_alert-body").innerHTML = `ERROR [UABS584]`;
	      const modalContent = document.querySelector(".modal_alert-content");
	
	      if (modalContent) {
	    	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
	      }
	
	      openModalAlertBlocked();
        }

          const allowancesContainer = document.querySelector(
            "#allowance-benefit-container"
          );
          const otherBenefitContainer = document.querySelector(
            "#other-benefit-container"
          );

          const mainBenefitNameContainer = document.querySelector(
            ".panel-inside__body.main-benefit .mainBenefitName"
          );
          const mainBenefitValueContainer = document.querySelector(
            ".panel-inside__body.main-benefit .mainBenefitValue"
          );

          if (
            !allowancesContainer ||
            !otherBenefitContainer ||
            !mainBenefitNameContainer ||
            !mainBenefitValueContainer
          ) {
            console.error("Container for benefits not found");
            return;
          }

          let allowancesContent = `
                        <div class="col-panel-row">
                            <div class="col-panel">
                                <div class="sa-switch-wrapper">
                                    <input class="parent" type="checkbox" id="switch-a" name="switch-a">
                                    <label class="sa-label label-toggle" for="switch-a"></label>
                                    <span class="span-bold">Pilih Semua</span>
                                </div>
                            </div>
                        </div>
                    `;

          let otherBenefitsContent = `
                        <div class="col-panel-row">
                            <div class="col-panel">
                                <div class="sa-switch-wrapper">
                                    <input class="parent" type="checkbox" id="switch-b" name="switch-b">
                                    <label class="sa-label label-toggle" for="switch-b"></label>
                                    <span class="span-bold">Pilih Semua</span>
                                </div>
                            </div>
                        </div>
                    `;

          let mainBenefitNameHTML = "";
          let mainBenefitValueHTML = "";


          let defaultAdditionalBenefitCode = ["BN02", "BN03", "BN08", "BN09", "BN11", "BN12"];
          let additionalBenefitsArr = [];
          let _sessData = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));

          let lastValue = null;
          data.forEach((benefit) => {
            // Update main benefit section (tambahkan semua "Jaminan Utama")
            if (benefit.benefitType.toLowerCase() === "jaminan utama") {
              mainBenefitNameHTML += `<p>${benefit.benefitName}</p>`;

              // Cetak value hanya jika berbeda dengan yang sebelumnya
              if (benefit.value !== lastValue) {
                mainBenefitValueHTML += `<p>${benefit.value || "-"}</p>`;
                lastValue = benefit.value; // Simpan nilai terakhir
              }
            }

            const benefitId = `switch-${benefit.benefitId}`;
            const benefitIdNum = benefit.benefitId;
            const benefitCode = benefit.benefitCode;
            const benefitRow = `
                            <div class="col-panel-row">
                                <div class="col-panel">
                                    <div class="sa-switch-wrapper">
                                        <input class="child" type="checkbox" id="${benefitId}" name="${benefitId}" data-benefit="${benefitIdNum}">
                                        <label class="sa-label label-toggle" for="${benefitId}"></label>
                                        <span>${benefit.benefitName}</span>
                                    </div>
                                </div>
                                <div class="col-panel">
                                    ${benefit.value || "-"}
                                </div>
                                <div class="col-panel">
                                    
                                    <a href="#" data-target="${
                                      benefit.benefitId
                                    }" onclick="infoBenefit(event, this)">Penjelasan</a>

                                </div>
                            </div>
                        `;

            if (benefit.benefitType.toLowerCase() === "santunan") {
              allowancesContent += benefitRow;
            } else if (
              benefit.benefitType.toLowerCase() === "jaminan lainnya"
            ) {
              otherBenefitsContent += benefitRow;
            }

            // SET DEFAULT ADDITIONAL BENEFIT
            if(defaultAdditionalBenefitCode.includes(benefitCode)) {
              additionalBenefitsArr.push(benefitIdNum);
            }
          });

          if(!_sessData.AdditionalBenefits || typeof _sessData.AdditionalBenefits === 'undefined') {
            if(additionalBenefitsArr.length > 0) {
              updateSess(_smartActiveFormDetailSess, "AdditionalBenefits", additionalBenefitsArr);
              selectedBenefits = additionalBenefitsArr;
            }
          }

          if (mainBenefitNameContainer && mainBenefitValueContainer) {
            mainBenefitNameContainer.innerHTML = mainBenefitNameHTML;
            mainBenefitValueContainer.innerHTML = mainBenefitValueHTML;
          } else {
            document.querySelector(".modal_alert-body").innerHTML = `Container untuk mainBenefitName atau mainBenefitValue tidak ditemukan.`;
  	        const modalContent = document.querySelector(".modal_alert-content");
  	
  	        if (modalContent) {
  	        	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
  	        }
  	
  	        openModalAlertBlocked();
          }

          allowancesContainer.innerHTML = allowancesContent;
          otherBenefitContainer.innerHTML = otherBenefitsContent;

      } catch (e) {
        console.error("Error parsing response.Data:", e);
        document.querySelector(".modal_alert-body").innerHTML = `ERROR [UABS678]`;
        const modalContent = document.querySelector(".modal_alert-content");
	
        if (modalContent) {
        	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
        }
	
        openModalAlertBlocked();
      }
    },
    error: function (xhr, status, error) {
      console.error("Error:", error);
      document.querySelector(".modal_alert-body").innerHTML = `Failed to load additional benefit information.`;
      const modalContent = document.querySelector(".modal_alert-content");
	
      if (modalContent) {
    	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
      }
	
      openModalAlertBlocked();
      return false;
    },
  });
}

/**
 * FUNGSI UNTUK SET FORM JIKA BACK DARI NEXT STEP . GET FROM SESSION
 */
function reinitDataForm(sessData) {
   moment.locale("id");

  const datasess = sessData;

  /**
   * SET FROM SESSION
   */
  // Mengisi kembali radio button
  if (typeof datasess.ExcludedActivityStatus !== "undefined") {
    const radio = document.querySelector(
      `input[name="radio-polis"][value="${datasess.ExcludedActivityStatus}"]`
    );
    if (radio) {
      radio.checked = true;
    }
  }
  
  if (typeof datasess.Occupation !== "undefined") {
	const jobSelect = $('select[name="Occupation"]');
    if (jobSelect.length) {
      jobSelect.val(datasess.Occupation).trigger("change"); // Update nilai dan trigger event change
    }
  }

  // Mengisi kembali nilai manfaat utama
  if (datasess.MainBenefitValue) {
    const benefitSelect = $('select[name="MainBenefitValue"]');
    if (benefitSelect.length) {
      benefitSelect.val(datasess.MainBenefitValue).trigger("change"); // Update Select2
    }
  }

  if (typeof moment !== "undefined") {
    //datepicker butuh 06/MAR/1995 -> 03-06-1995

    //let fixedExpiredDate = null;
    let formattedExpiredDate = null;

    if (datasess.PeriodeTo) {
      //fixedExpiredDate = convertCustomDate(datasess.ExpiredDate);
      formattedExpiredDate = moment(datasess.PeriodeTo, "DD/MMM/YYYY").format(
        "DD/MMM/YYYY"
      );
    }
    
    if (datasess.Dob) {
      const startDate = moment(
    	datasess.PeriodeFrom,
        "DD/MMM/YYYY",
        true
      );

      maxBirthDate = startDate.clone().subtract(30, "days");
      minBirthDate = startDate.clone().subtract(75, "years");

      $("#choose-plan-birth").data("daterangepicker").minDate =
        minBirthDate;
      $("#choose-plan-birth").data("daterangepicker").maxDate =
        maxBirthDate;

      /**
       * kalau data  = Wed Aug 14 00:00:00 GMT 2024 pakai -> new Date(dataLeads.Dob)
       * kalau data = 14/Aug/2024  dataLeads.Dob
       */
      let value = moment(datasess.Dob, "DD/MMM/YYYY").format("DD/MMM/YYYY"); //
      $("#choose-plan-birth").val(value);
      $("#choose-plan-birth").data("daterangepicker").setStartDate(value);
      $("#choose-plan-birth").data("daterangepicker").setEndDate(value);
    }

    // Proses StartDate
    if (datasess.PeriodeFrom) {
      let value = moment(datasess.PeriodeFrom, "DD/MMM/YYYY").format(
        "DD/MMM/YYYY"
      );

      $("#from").val(value);
      $("#from").data("daterangepicker").setStartDate(value);
      $("#from").data("daterangepicker").setEndDate(value);
      $('input[name="PeriodeFrom"]').val(value);
    }

    if (datasess.PeriodeTo) {
      let value = moment(datasess.PeriodeTo, "DD/MMM/YYYY").format(
        "DD/MMM/YYYY"
      );
      $("#until").val(value);
      $('input[name="PeriodeTo"]').val(value);
    }
  } else {
    console.error("Moment.js tidak tersedia. Pastikan moment.js sudah dimuat.");
  }

  /**
   * END
   */
}

//check all valid form step2 simple
function validateAndToggleButtons(data) {
  const submitButtons = $(".btn__next, #submit-quotation-btn");
  const labelWarning = $("#label__mandatory__warning");

  // Cek apakah jobSelect sudah memiliki nilai terpilih
  const jobSelect = $('select[name="Occupation"]');
  const isJobValid =
    jobSelect.length && jobSelect.val() && jobSelect.val().trim() !== "";

  // Cek apakah dobInput sudah memiliki nilai
  const dobInput = $("#choose-plan-birth");
  const isDobValid =
    dobInput.length && dobInput.val() && dobInput.val().trim() !== "";

  // Validasi semua field yang diperlukan
  const allValid =
    data.ExcludedActivityStatus &&
    isJobValid && // Pastikan job sudah terpilih
    isDobValid && // Pastikan dob sudah diisi
    data.MainBenefitValue &&
    data.PeriodeFrom &&
    data.PeriodeTo;

  if (allValid) {
    submitButtons
      .removeClass("btn--dark-grey")
      .addClass("btn--dark-blue")
      .css({ pointerEvents: "auto", opacity: "1" });
    labelWarning.addClass("agency__hidden");
  } else {
    submitButtons
      .removeClass("btn--dark-blue")
      .addClass("btn--dark-grey")
      .css({ pointerEvents: "none", opacity: "0.5" });
    labelWarning.removeClass("agency__hidden");
  }
}

// VALIDATE CALCULATE PARAMS
function validateCalculateParam() {
  let validationStat = true;
  let existingSession = sessionStorage.getItem(_smartActiveFormDetailSess);
  if (existingSession) {
    existingSession = JSON.parse(existingSession);

    if (typeof existingSession["Occupation"] === "undefined") {
      return false;
    }

    if (typeof existingSession["PeriodeFrom"] === "undefined") {
      return false;
    }
    
    if (typeof existingSession["PeriodeTo"] === "undefined") {
        return false;
      }

    return validationStat;
  } else {
    return false;
  }
}

// CALCULATE PREMI
function calculatePremi() {
	// jika tidak lolos validasi sebelum calculate, maka reset tombol kode promo
	if(!validateCalculateParam()) {
		$('#promo-code-btn').html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
		return false;
	}
	
    let existingSession = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));
    
    // untuk mendeteksi bahwa ada promocode di session
    var promoCodeIncluded = false;
    if (existingSession.PromoCode) {
        promoCodeIncluded = true;
    }
    
    
    $.ajax({
      url: _apiURL + "/o/api/sa/calculate",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify(existingSession),
      success: function (response) {
    	// reset button promocode
    	$('#promo-code-btn').html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');

        if (response.Status) {
          if (response.Data.Calculation) {
        	if(promoCodeSubmitStat) {
        		if (promoCodeIncluded) {
        			$('#modalAlertSuccess').modal('show');
        		}
        	}
        	  
            sessionStorage.setItem(_smartActiveCalculation, JSON.stringify(response.Data.Calculation));
            updateStickyPrice();
            updatePlanSummarySidebar();
          }
        } else {
            // if response status is 0
            if (promoCodeIncluded) {
                if (typeof response.PromoCodeResponse !== "undefined") {
                    if (response.PromoCodeResponse) {
                        removePromoCode();
                        $('#promo-code-btn').html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
                        document.querySelector(".modal_alert-body").innerHTML = response.Message ? response.Message : "Calculate Failed.";
                        const modalContent = document.querySelector(".modal_alert-content");
                  	
                        if (modalContent) {
                        	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
                        }
                  	
                        openModalAlertBlocked();
                        calculatePremi();
                    }
                }
            }
        }
        
        promoCodeSubmitStat = false;
      },
      error: function (xhr, status, error) {
    	  promoCodeSubmitStat = false;
    	  $('#promo-code-btn').html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
          document.querySelector(".modal_alert-body").innerHTML = `ERROR CALCULATE!`;
          const modalContent = document.querySelector(".modal_alert-content");
    	
          if (modalContent) {
        	  modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
          }
    	
          openModalAlertBlocked();
    	  console.error("Error Calculate:", error);
      },
    });
}

document.addEventListener("DOMContentLoaded", function () {
  //event hapus class invalid jika ada
  // Targetkan select2 yang kita gunakan
  const selectElement = document.getElementById("type-of-work");

  if (selectElement) {
    // Tambahkan event listener saat nilai berubah
    $(selectElement).on("change", function () {
      const wrapper = selectElement.closest("#type-of-work-wrapper"); // Ambil wrapper utama
      const select2Wrapper = selectElement.nextElementSibling; // Ambil elemen Select2 <span>

      if (selectElement.value.trim()) {
        if (wrapper) wrapper.classList.remove("invalid-sa"); // Hapus class invalid-sa di wrapper utama
        if (select2Wrapper) select2Wrapper.classList.remove("invalid-sa"); // Hapus class invalid-sa di elemen Select2
      }
    });
  }

  //excluded-activity onchange
  const excludedActStatusContainers = document.querySelectorAll(
    ".excluded-activity-status"
  );
  excludedActStatusContainers.forEach((container) => {
    const noRadio = container.querySelector(".excludedInputNo");
    const yesRadio = container.querySelector(".excludedInputYes");

    if (noRadio) {
      noRadio.addEventListener("change", () => {
        handleSelection(container);
      });
    }

    if (yesRadio) {
      yesRadio.addEventListener("change", () => {
        handleSelection(container);
      });
    }
  });

  const valSel = document.getElementById("valueSelect");

  valSel.querySelectorAll("option").forEach((option) => {
    let value = option.value;
    if (value) {
      let formattedValue = Number(value).toLocaleString("id-ID");
      option.setAttribute("title", formattedValue);
      option.textContent = formattedValue;
    }
  });
});
