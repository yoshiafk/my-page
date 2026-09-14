var _sessionName = "AXA_PET"; // simpen diluar scope jquery supaya bisa diakses di file lain
var updateFormGeneral, updateFormStep1, updateFormStep2, updateFormStep3, updateFormStep4; // simpen diluar scope jquery supaya bisa diakses di file lain
var calculateURL = "http://localhost:8080/o/api/pet/calculate";
var kycURL = "http://localhost:8080/o/pet-insurance/kyc";''

var sidebarProcess;

$(document).ready(function () {
  // sementara session storage dihapus saat load, development purpose
  //	sessionStorage.clear();

  var calculateURL = "http://localhost:8080/o/api/pet/calculate";
  var kycURL = "http://localhost:8080/o/api/pet/kyc";
  var onUpdateKyc = false;

  // Body Change Event > Running Update KYC
  $("body").on("change", ".change", function (e) {
	  let hasPlan = true;
    let currentData = getData();
    
    // check plan
    if(currentData.hasOwnProperty('Plan')) {
    	if(!currentData.Plan) {
    		hasPlan = false;
    	}
    }
    
    if (onUpdateKyc) return false;
    onUpdateKyc = true;
    
    let sessionData = getSessionData(_sessionName);
    let data = Object.assign({}, sessionData, currentData); // merge data 
    setSessionData(_sessionName, data);
    
if(hasPlan) {
    jqAjaxJSON(data, kycURL, function (msg) {
        onUpdateKyc = false;
        
        if(!msg.Status) {
      	  alert(msg.Message);
      	  return false;
        }
        
        if(msg.Status) {
      	  SessionStorage.set(_sessionName, "Token", msg.Data.Token);  
        }

        if (msg && msg.Status && msg.Data && msg.Data.ManagedBy) {
          var html =
            '<div class="row fz-12 text-uppercase pt-2 pb-2 sidebar-detail-agent">\
                                  <div class="col-xl-3 col-lg-3 col-md-3 col-3">\
                                      <span class="semi-bold"><i class="fal fa-user fa-fw"></i> Agent</span>\
                                  </div>\
                                  <div class="col-xl-9 col-lg-9 col-md-9 col-9 text-right">\
                                      <span class="semi-bold">' +
            msg.Data.ManagedBy.Code +
            " - " +
            msg.Data.ManagedBy.Name +
            "</span>\
                                  </div>\
                              </div>";
          $(".sidebar-detail-agent-wrap").html(html);
        }
        
        // run sidebar process
        if(msg.Status) {
      	  sidebarProcess();  
        }
      });	
} else {
	onUpdateKyc = false;
}

    // ini gak dipake lagi
    //        getData(function(data) {
    //        	jqAjaxJSON(data, kycURL, function(msg) {
    //                onUpdateKyc = false;
    //                SessionStorage.set(_sessionName, "Token", msg.Data.Token);
    //
    //                if(msg && msg.Status && msg.Data && msg.Data.ManagedBy) {
    //                    var html = '<div class="row fz-12 text-uppercase pt-2 pb-2 sidebar-detail-agent">\
    //                                    <div class="col-xl-3 col-lg-3 col-md-3 col-3">\
    //                                        <span class="semi-bold"><i class="fal fa-user fa-fw"></i> Agent</span>\
    //                                    </div>\
    //                                    <div class="col-xl-9 col-lg-9 col-md-9 col-9 text-right">\
    //                                        <span class="semi-bold">'+ msg.Data.ManagedBy.Code +' - '+ msg.Data.ManagedBy.Name +'</span>\
    //                                    </div>\
    //                                </div>';
    //                    $('.sidebar-detail-agent-wrap').html(html);
    //                }
    //
    //            });
    //        });
    // ini gak dipake lagi
  });

  var btnText = $(".next-step").html();
  
  // sidebar process
  sidebarProcess = function() {
	  let sidebarPlan = $('#sidebar-plan');
	  let plan = sidebarPlan.val();
	    // loading
	    $(".next-step").html('<span class="spinner-border spinner-border-sm mr-2 mb-1" role="status" aria-hidden="true"></span>Loading...').prop("disabled", true);
	    
	    let currentData = getData();
	    let sessionData = getSessionData(_sessionName);
	    let data = Object.assign({}, sessionData, currentData); // merge data 
	    setSessionData(_sessionName, data);
	    
	    jqAjaxJSON(data, kycURL, function () {
	        jqAjaxJSON(data, calculateURL, function (msg) {
	          if (msg.Status == undefined || !msg.Status) {
	            alertMsg({
	              type: "warning",
	              text: msg.Message != undefined ? msg.Message : "Terjadi kesalahan, error",
	            });

	            $(".next-step").html(btnText);
	          }

	          if (msg && msg["Status"]) {
	            updateSidebar(msg["Data"]);
	            $(".btn-next").find(".error-msg").remove();
	            $(".next-step").html(btnText).prop("disabled", false);

	            $_net_premium = msg["Data"]["netPremiNew"] ? msg["Data"]["netPremiNew"] : msg["Data"]["NetPremium"];
	            // reset payment channel if its payment page
	            //_payment.resetPayment();
	          }
	        });
	      });
  }
  

  // sidebar plan on change
//  $("body").on("change", "#sidebar-plan", function () {
//    var plan = $(this).val();

    // loading
//    $(".next-step").html('<span class="spinner-border spinner-border-sm mr-2 mb-1" role="status" aria-hidden="true"></span>Loading...').prop("disabled", true);

    // ini gak dipake lagi
    // calculate
    //        getData(function(data) {
    //            jqAjaxJSON(data, kycURL, function() {
    //                jqAjaxJSON(data, calculateURL, function(msg) {
    //                    if(msg.Status == undefined || !msg.Status) {
    //                        alertMsg({
    //                            type: 'warning',
    //                            text: msg.Message != undefined ? msg.Message : 'Terjadi kesalahan, error'
    //                        });
    //
    //                        $('.next-step').html(btnText);
    //                    }
    //
    //                    if(msg && msg['Status']) {
    //                        updateSidebar(msg['Data']);
    //                        $('.btn-next').find('.error-msg').remove();
    //                        $('.next-step').html(btnText).prop('disabled', false)
    //
    //                        $_net_premium = (msg['Data']['netPremiNew']) ? msg['Data']['netPremiNew'] : msg['Data']['NetPremium'];
    //                        // reset payment channel if its payment page
    //                        //_payment.resetPayment();
    //                    }
    //                });
    //            });
    //        });
    // ini gak dipake lagi

//    let currentData = getData();
//    let sessionData = getSessionData(_sessionName);
//    console.log('kyc2', sessionData);
//    let data = Object.assign({}, sessionData, currentData); // merge data 
//    setSessionData(_sessionName, data);
    
    
//    jqAjaxJSON(data, kycURL, function () {
//      jqAjaxJSON(data, calculateURL, function (msg) {
//        if (msg.Status == undefined || !msg.Status) {
//          alertMsg({
//            type: "warning",
//            text: msg.Message != undefined ? msg.Message : "Terjadi kesalahan, error",
//          });
//
//          $(".next-step").html(btnText);
//        }
//
//        if (msg && msg["Status"]) {
//          updateSidebar(msg["Data"]);
//          $(".btn-next").find(".error-msg").remove();
//          $(".next-step").html(btnText).prop("disabled", false);
//
//          $_net_premium = msg["Data"]["netPremiNew"] ? msg["Data"]["netPremiNew"] : msg["Data"]["NetPremium"];
//          // reset payment channel if its payment page
//          //_payment.resetPayment();
//        }
//      });
//    });
    
//  });

  // promocode
  //    $('body').on('click', '.btn-promocode', function() {
  //        var btn = $(this);
  //        var data = {};
  //
  //        // calculate
  //        if($('select[name=SidebarPlan]').val()) {
  //            btn.find('i').addClass('fa-spin');
  //            data['PromoCode'] = $('#promocode').val();
  //            data['Plan'] = $('select[name=SidebarPlan]').val();
  //
  //            jqAjax(data, _product.pi.url.kyc, function() {
  //                jqAjax({}, _product.pi.url.calculate, function(msg) {
  //                    if(msg && msg['Status']) {
  //                        _product.pi.updateSidebar(msg['Data']);
  //
  //                        $_net_premium = (msg['Data']['netPremiNew']) ? msg['Data']['netPremiNew'] : msg['Data']['NetPremium'];
  //                        // reset payment channel if its payment page
  //                        _payment.checkMinMax();
  //                        _payment.resetPayment();
  //
  //                        if(msg['Status']=='1'){
  //                            btn.find('i').removeClass('fa-spin');
  //                            $('.btn-next').find('.error-msg').remove();
  //                            $('.next-step').html(btnText).prop('disabled', false)
  //                        }
  //
  //                    } else {
  //                        $('.sidebar .promo .info').html("<div class='c-red-100'>"+msg['Message']+"</div>");
  //                        btn.find('i').removeClass('fa-spin');
  //                    }
  //                });
  //            });
  //        } else {
  //            btn.closest('.promo').find('.info').html('<i class="c-red-100">Silahkan pilih plan anda terlebih dahulu.</i>');
  //        }
  //    });

  // UPDATE SIDEBAR
  function updateSidebar(data) {
    var html = "";

    // update summary
    if (data["PetDetail"]) {
      html +=
        '<div class="row item">\
                        <div class="col-md-12">\
                            <span class="fz-12 semi-bold text-uppercase">Periode Perlindungan</span>\
                        </div>\
                        <div class="col-xl-7 col-lg-6 col-md-12 col-7">\
                            <span class="pl-3 light">1 tahun</span>\
                        </div>\
                        <div class="col-xl-5 col-lg-6 col-md-12 col-5 text-right">\
                            <div class="idr semi-bold fz-16">\
                                <span class="text-break">' +
        thousandFormat(data["PetDetail"]["Premi"]) +
        "</span>\
                            </div>\
                        </div>\
                    </div>";
    }

    $(".sidebar-detail-eh").html(html).removeClass("d-none");
    $(".sidebar .Discount").removeClass("d-none");

    // update total
    if (data["Premium"]) $(".sidebar .Premium").removeClass("d-none").find(".amount").html(thousandFormat(data["Premium"]));
    if (data["NetPremium"]) $(".sidebar .NetPremium").removeClass("d-none").find(".amount").html(thousandFormat(data["NetPremium"]));
    if (data["NetPremium"]) $(".mobile-sidebar .NetPremium").find(".amount").html(thousandFormat(data["NetPremium"]));
    if (data["PolicyCost"]) $(".sidebar .PolicyCost").removeClass("d-none").find(".amount").html(thousandFormat(data["PolicyCost"]));
    if (data["StampDuty"]) $(".sidebar .StampDuty").removeClass("d-none").find(".amount").html(thousandFormat(data["StampDuty"]));
    if (data["Discount"]) {
      $(".sidebar .Discount")
        .find(".amount")
        .html("-" + thousandFormat(data["DiscountAmount"]));
      $(".sidebar .promo .info").html(data["PromoCode"] + " berhasil dipakai.");
    } else {
      $(".sidebar .Discount").find(".amount").html("-");
      $(".sidebar .promo .info").html("");
    }
    // nett premi
    if (window.location.pathname == "/payment" || window.location.pathname == "/payment/") {
      if (data["netPremiNew"] && data["Tax"] && data["TaxValue"] && data["LoginAgent"] != undefined && data["LoginAgent"]) {
        $(".sidebar .NetPremium").find(".nett-amount").html(thousandFormat(data["netPremiNew"]));
        $(".sidebar .NetPremium").find(".nett-wrap").removeClass("d-none");
        $(".sidebar .NetPremium").find(".amount").parent().addClass("line-through");
      } else {
        $(".sidebar .NetPremium").find(".nett-amount").html("-");
        $(".sidebar .NetPremium").find(".nett-wrap").addClass("d-none");
        $(".sidebar .NetPremium").find(".amount").parent().removeClass("line-through");
      }
    }
  }

  // UPDATE FORM IN EACH STEP
  updateFormGeneral = function (kyc) {
    $(".change").each(function (i, val) {
      if ((val.nodeName == "INPUT" && $(this).attr("type") == "text") || val.nodeName == "SELECT") {
        $(this).val(kyc[val.name]);
      } else if (val.nodeName == "INPUT" && $(this).attr("type") == "radio") {
        $("input[name=" + val.name + "][value='" + kyc[val.name] + "']").prop("checked", true);
      } else if (val.nodeName == "INPUT" && $(this).attr("type") == "checkbox") {
        if (kyc[val.name] == $("input[name=" + val.name + "]").val()) $("input[name=" + val.name + "]").prop("checked", true);
      } else {
        $(this).val(kyc[val.name]);
      }
    });
  };
  
  updateFormStep1_2 = function(kyc) {
		$('input[name=UserCustom][value='+kyc.UserCustom+']').prop('checked', true);
		if(kyc.LimitCustody) $('input[name=LimitCustody]').val(kyc.LimitCustody);
		
		// add remarks sessionstorage
		$('.remarks-value').each(function(key) {
			if(kyc[$(this).attr('name')]) {    				
				$(this).val(kyc[$(this).attr('name')]);
				$(this).siblings('.remarks-input').val(thousandFormat(kyc[$(this).attr('name')]));
				SessionStorage.set(_sessionName, $(this).attr('name'), $(this).val());
			}
        });
		
	    $("#sidebar-plan").val(kyc.Plan);
	    $("#sidebar-plan").trigger("change");
	    sidebarProcess();		
  }

  updateFormStep1 = function (kyc) {
	  if(kyc.hasOwnProperty('Plan')) {
		  if(kyc.Plan) {
			  $("input[name=Plan][value=" + kyc.Plan + "]").prop("checked", true);
			  $("#sidebar-plan").val(kyc.Plan);
			  $("#sidebar-plan").trigger("change");
			  sidebarProcess();  
		  }  
	  }
  };
  

  updateFormStep2 = function (kyc) {
    $("input[name=UserCustom][value=" + kyc.UserCustom + "]").prop("checked", true);
    if (kyc.LimitCustody) $("input[name=LimitCustody]").val(kyc.LimitCustody);

    // add remarks sessionstorage
    $(".remarks-value").each(function (key) {
      if (kyc[$(this).attr("name")]) {
        $(this).val(kyc[$(this).attr("name")]);
        $(this)
          .siblings(".remarks-input")
          .val(thousandFormat(kyc[$(this).attr("name")]));
        SessionStorage.set(_sessionName, $(this).attr("name"), $(this).val());
      }
    });
    
    if(kyc.hasOwnProperty('idPhotoFileEntryId')) {
    	if(kyc.idPhotoFileEntryId) {
    		$('input[name=IdPhotoHidden]').val(kyc.idPhotoFileEntryId);
    	}
    }
    
    if(kyc.hasOwnProperty('idPhotoPreview')) {
    	if(kyc.idPhotoPreview) {
    	    var html =
    	        '<div class="img-uploaded"><img class="img-thumbnail mb-2" src="' +
    	        kyc.idPhotoPreview +
    	        '" alt="upload ' +
    	        name +
    	        '" class="img-thumbnail"></div>';
    	      $('#idPhotoUplaodedWrapper').html(html);
    	}
    }

    $("#sidebar-plan").val(kyc.Plan);
    $("#sidebar-plan").trigger("change");
    sidebarProcess();
  };
  

  updateFormStep3 = function (kyc) {
	  
	    if(kyc.hasOwnProperty('PetIdNumberFileHidden')) {
	    	if(kyc.PetIdNumberFileHidden) {
	    		let _input = $('input[name=PetIdNumberFileHidden]');
	    		_input.val(kyc.PetIdNumberFileHidden);
	    		_input.parent().find('label').text(kyc.PetIdPhotoName);
	    		
	    	    if(kyc.hasOwnProperty('PetIdPhotoPreview')) {
	    	    	if(kyc.PetIdPhotoPreview) {
	    	    	    var html =
	    	    	        '<div class="img-uploaded"><img class="img-thumbnail mb-2" src="' +
	    	    	        kyc.PetIdPhotoPreview +
	    	    	        '" alt="upload ' +
	    	    	        name +
	    	    	        '" class="img-thumbnail"></div>';
	    	    	      $('#PetIdNumberUploadedWrapper').html(html);
	    	    	}
	    	    }
	    	}
	    }
	    
	    if(kyc.hasOwnProperty('PetPhotoHidden')) {
	    	if(kyc.PetPhotoHidden) {
	    		var _input = $('input[name=PetPhotoHidden]');
	    		_input.val(kyc.PetPhotoHidden);
	    		_input.parent().find('label').text(kyc.PetPhotoName);
	    		
	    	    if(kyc.hasOwnProperty('PetPhotoPreview')) {
	    	    	if(kyc.PetPhotoPreview) {
	    	    	    var html =
	    	    	        '<div class="img-uploaded"><img class="img-thumbnail mb-2" src="' +
	    	    	        kyc.PetPhotoPreview +
	    	    	        '" alt="upload ' +
	    	    	        name +
	    	    	        '" class="img-thumbnail"></div>';
	    	    	      $('#PetPhotoUploadedWrapper').html(html);
	    	    	}
	    	    }
	    	}
	    }

    $("#sidebar-plan").val(kyc.Plan);
    $("#sidebar-plan").trigger("change");
    sidebarProcess();
  };
  
  updateFormStep4 = function(kyc) {
	    $("#sidebar-plan").val(kyc.Plan);
	    $("#sidebar-plan").trigger("change");
	    sidebarProcess();	  
  }
});