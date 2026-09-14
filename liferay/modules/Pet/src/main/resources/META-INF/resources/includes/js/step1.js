$(document).ready(function () {
  var $_kyc_error;
  var $_recommendedselect;
  var $_custom_plan;

  function init() {
	  console.log(petStep1_2URL + '&a=' + aParam);
    let sessionData = getSessionData(_sessionName);
    
    // Populate data from session storage to elements container
    if (sessionData) {
      updateFormGeneral(sessionData);
      updateFormStep1(sessionData);

      // remove token if ubah penawaran
      //  		if(EditQuotation && getSessionData() && getSessionData().Token) {
      //  			SessionStorage.set(_sessionName, 'Token', "");
      //  			SessionStorage.set(_sessionName, 'TempCode', "");
      //  		}
    }

    $_kyc_error = $("#step1-page").data("error");
    $_recommendedselect = $("#step1-page").data("recommendedselect");
    
    // get custom plan
    $_custom_plan = [];
    $("input[name=Plan]").each(function () {
      if ($(this).data("custom")) $_custom_plan.push($(this).val());
    });

    if ($_kyc_error)
      alertMsg({
        type: "warning",
        text: "Mohon maaf. Data tidak lengkap, silahkan isi kembali <i>(" + $_kyc_error + ")</i>",
      });

    // Button "Pilih Plan" change event
    $(".selectize").selectize(); // ini harusnya didefine di pet_general
    
    $(".item .plan:checked").closest(".row").addClass("bg-blue-400");
    $(".plan:checked").siblings("label").html("Plan Dipilih");

    // Hit calculate when page loaded
    if (validateForm(false)) {
      jqAjaxJSON({}, calculateURL, function (msg) {
        if (msg && msg["Status"]) {
          if (msg["Data"] && msg["Data"]["Discount"]) $(".promo .info").html($("#promocode").val() + " berhasil dipakai.");
          updateSidebar(msg["Data"]);
          loadingBtnNext(true);
        }
      });
    }
  }

  function initTrigger() {
	  
	  // Must choose plan first
      $("body").on("click", ".plan", function (e) {
    	  let currentData = getData();
          if(currentData.hasOwnProperty('StartDate')) {
            	if(!currentData.StartDate) {
                    alertMsg({
      	              type: "warning",
      	              text: "Please select policy periode first",
      	            });
                    e.preventDefault();
            	}
            }
      });
	  
	  
	  
    // Input change event
    $("body").on("change", ".plan", function (e) {

	      $(".plan").siblings("label").html("Pilih Plan");
	      $(this).siblings("label").html("Plan Dipilih");

	      // Ubah value plan pada option di sidebar, setelah option keubah, maka akan trigger onChange #sidebar-plan dan calculate akan berjalan
	      $("#sidebar-plan").data("selectize").setValue($(".plan:checked").val());
        
    });

    // #sidebar-plan change event
    $("body").on("change", "#sidebar-plan", function () {
      var plan = $(".plan[value=" + $(this).val() + "]");
      $(".plan").siblings("label").html("Pilih Plan");
      $(".plans .item .row").removeClass("bg-blue-400");

      plan.siblings("label").html("Plan Dipilih");
      plan.prop("checked", true);

      if (plan.hasClass("itemplan")) plan.closest(".row").addClass("bg-blue-400");
    });

    $("body").on("change", ".item .plan", function () {
      $(".plans .item .row").removeClass("bg-blue-400");
      $(this).closest(".row").addClass("bg-blue-400");
    });

    $("body").on("change", ".recomended-plan .plan", function () {
      $(".plans .item .row").removeClass("bg-blue-400");
    });
    
    
    // datepicker
    $(".datepicker").datepicker({
      minDate: "+0d",
      // maxDate: '+3m',
      dateFormat: "dd/mm/yy",
      onSelect: function (dateText, instance) {
        var dateMin = $("[name=StartDate]").datepicker("getDate");

        // CEK EXPIRED AGENT
        // uncomment later
        // if (ManagedByEndDate) {
        //   var agentExpiredDate = new Date(ManagedByEndDate);
        //   agentExpiredDate = new Date(agentExpiredDate);
        //   if (dateMin.getTime() > agentExpiredDate.getTime()) {
        //     if (user != "") {
        //       alertMsg({
        //         type: "warning",
        //         type_color: "bg-blue-1200",
        //         text: "Mohon Maaf, Harap segera perbarui lisensi keagenan Anda",
        //       });
        //     }
        //   }
        // }
        // uncomment later
        dateMin = new Date(dateMin.getFullYear() + 1, dateMin.getMonth(), dateMin.getDate() - 1);
        dateMin = moment(dateMin).format("DD/MM/YYYY");
        $("[name=ExpiredDate]").val(dateMin).trigger('change');
      },
    });    

    // Next Step button change event
    $("body").on("click", ".next-step", function () {
      var _self = $(this);
      loadingBtnNext(false);
      $("#agree-next-step").html('<span class="spinner-border spinner-border-sm mr-2 mb-1" role="status" aria-hidden="true"></span>Loading...').prop("disabled", true);
      $("#disagree-next-step").prop("disabled", true);

      if (!validateForm()) {
        loadingBtnNext(true);
        return false;
      }

      // uncomment later
      //        getData(function (data) {
      //          jqAjax(data, kycURL, function (msg) {
      //            var url = "/pet/quote/step1";
      //            var form = $('<form action="' + url + '" method="post">' + '<input type="text" name="NextPage" value="true" />' + "</form>");
      //            $("body").append(form);
      //            if (msg.Status == undefined || !msg.Status) {
      //              // retry
      //              _self.trigger("click");
      //
      //              alertMsg({
      //                type: "warning",
      //                text: msg.Message != undefined ? msg.Message : "Terjadi kesalahan, error",
      //              });
      //              return false;
      //            } else {
      //              if (!$_custom_plan.includes($("input[name=Plan]:checked").val())) {
      //                window.location.href = "/pet/quote/step2";
      //              } else {
      //                form.submit();
      //              }
      //            }
      //          });
      //        });
      // end uncomment later


      if (!$_custom_plan.includes($("input[name=Plan]:checked").val())) {
    	  window.location.href = petStep2URL + '&a=' + aParam;
    	  } else {
    		  window.location.href = petStep1_2URL + '&a=' + aParam;
    	  }
      //window.location.href = petStep2URL; // variable ini didefine di step1.jsp
    });
  }

  function afterInit() {
    // automate select recomended plan if has promocode on url
    if ($_recommendedselect) {
      $("#recommended-plan").click();
    }
  }

  init();
  initTrigger();
  afterInit();
});
