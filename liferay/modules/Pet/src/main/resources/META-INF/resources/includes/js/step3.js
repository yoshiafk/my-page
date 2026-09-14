$(function () {
  "use strict";

  var _maxImageSize = 5242880; // 5Mb
  var _allowImageType = ["image/jpg", "image/jpeg", "image/png"];

  var calculateURL = "http://localhost:8080/o/pet-insurance/calculate";
  var kycURL = "http://localhost:8080/o/pet-insurance/kyc";

  function init() {
	  
	    // Populate data from session storage to elements container
	  let sessionData = getSessionData(_sessionName);
	    if (sessionData) {
	      updateFormGeneral(sessionData);
	      updateFormStep3(sessionData);

	      // remove token if ubah penawaran
	      //  		if(EditQuotation && getSessionData() && getSessionData().Token) {
	      //  			SessionStorage.set(_sessionName, 'Token', "");
	      //  			SessionStorage.set(_sessionName, 'TempCode', "");
	      //  		}
	    }	  
	  
	  
    // for custom file input
    bsCustomFileInput.init();

    // Date dropdown
    $(".datedropdown").each(function (k, elm) {
    	console.log(elm);
      dateDropdown(elm);
    });

    // select
    $(".selectize").selectize();

    // uncomment later
    // check button
    // if (validateForm(false)) {
    //   $(".next-step").prop("disabled", false);
    // } else {
    //   $(".next-step").prop("disabled", true);
    // }
    // end uncomment later

    // uncomment later
    // calculate
    // jqAjax({}, calculateURL, function(msg) {
    //     if(msg && msg['Status']) {
    //         if(msg['Data'] && msg['Data']['Discount']) $('.promo .info').html($('#promocode').val()+' berhasil dipakai.');
    //         updateSidebar(msg['Data']);
    //     }
    // });
    // end  uncomment later
  }

  function initTrigger() {
    // global init
    // _product.pi.initTrigger();

    // Next step
    $("body").on("click", ".next-step", function () {
      var _self = $(this);

      loadingBtnNext(false);

       if(!validateForm()) {
           loadingBtnNext(true);
           return false;
       }

      // // fetch all data
      // getData(function(data) {
      //     jqAjax(data, _product.pi.url.kyc, function(msg) {
      //         if(msg.Status == undefined || !msg.Status) {
      //             _self.trigger('click');

      //             alertMsg({
      //                 type: 'warning',
      //                 text: msg.Message != undefined ? msg.Message : 'Terjadi kesalahan, error'
      //             });
      //             return false;
      //         }

      //         window.location.href = "/pet/quote/step4";
      //     });
      // });
      // end uncomment later

      window.location.href = petStep4URL + '&a=' + aParam;
    });

    $("body").on("change", "input.required, select.required", function () {
      if (validateForm(false)) {
        $(".next-step").prop("disabled", false);
      } else {
        $(".next-step").prop("disabled", true);
      }
    });

    $("body").on("keyup", "input", function () {
      this.value = this.value.toLocaleUpperCase();
    });

    
    // upload images
    $("body").on("change", "input[name=PetIdNumberFile], input[name=PetPhoto]", function () {
    	console.log('asd');
      var input = $(this);
      var name = input.attr("name");

      // validate image
      var validate_image = validateImage($("input[name=" + name + "]").prop("files")[0]);
      if (!validate_image.Status) {
        alertMsg({
          type: "warning",
          text: validate_image.Message,
        });

        $("input[name=" + name + "Hidden]").val("");
        input.parent().find(".custom-file-label").removeClass("uploading");

        return false;
      }
      
      var formData = new FormData();
      var fileInput = input.prop("files")[0];
      formData.append('file', fileInput);
      
      let curToken = '';
      let sessionData = getSessionData(_sessionName);
      if(sessionData) {
    	  if(sessionData.hasOwnProperty('Token')) {
    		  curToken = sessionData['Token'];
    		  formData.append('token', curToken);
    		  
              if(input.attr('name') === 'PetIdNumberFile') {
            	  formData.append('type', 'petCertificatePhoto');  
              } else {
            	  formData.append('type', 'petPhoto');
              }
    	  }
      }
      
      input.parent().find(".custom-file-label").addClass("uploading");
      
      $.ajax({
          url: 'http://localhost:8080/web/guest/pet-insurance?p_p_id=com_mypage_product_pet_PetPortlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=%2Fpet_upload_image&p_p_cacheability=cacheLevelPage',
          type: 'POST',
          data: formData,
          processData: false,
          contentType: false,
          success: function(response) {
        	  response = JSON.parse(response);
                     if (response && response.status != undefined && !response.status) {
                       alertMsg({
                         type: "warning",
                         text: "Error upload image",
                       });

                       input.siblings("input[type=hidden]").val("");
                       input.siblings(".custom-file-label").removeClass("uploading");
                       return false;
                     }
                     
                   input.parent().find(".custom-file-label").removeClass("uploading");
                     
                     if(input.attr('name') === 'PetIdNumberFile') {
                    	 SessionStorage.set(_sessionName, "PetIdNumberFileHidden", response.data.id);
                    	 SessionStorage.set(_sessionName, "PetIdPhotoPreview", response.data.preview);
                    	 SessionStorage.set(_sessionName, "PetIdPhotoName", response.data.name);
                     } else {
                    	 SessionStorage.set(_sessionName, "PetPhotoHidden", response.data.id);
                    	 SessionStorage.set(_sessionName, "PetPhotoPreview", response.data.preview);
                    	 SessionStorage.set(_sessionName, "PetPhotoName", response.data.name);
                     }
                     
                   var html = '<div class="img-uploaded"><img class="img-thumbnail mb-2" src="' + response.data.preview + '" alt="upload ' + name + '" class="img-thumbnail"></div>';
                   input.closest(".form-group").find(".uploaded-wrappper").html(html);
                   $("input[name=" + name + "Hidden]").val(response.data.id);
                                   
                     
                   if (validateForm(false)) {
                   $(".next-step").prop("disabled", false);
                 } else {
                   $(".next-step").prop("disabled", true);
                 }
          },
          error: function(xhr, status, error) {
              console.log('Error upload image');
          }
      });

//      getData(function (data) {
//        data[name] = $("input[name=" + name + "]").prop("files")[0];
//        var newdata = new FormData();
//
//        $.each(data, function (key, value) {
//          newdata.append(key, value);
//        });
//
//        input.parent().find(".custom-file-label").addClass("uploading");
//        jqAjax(
//          newdata,
//          _product.pi.url.kyc,
//          function (msg) {
//            if (msg && msg.Status != undefined && msg.Status == 0) {
//              alertMsg({
//                type: "warning",
//                text: msg.Message,
//              });
//
//              $("input[name=" + name + "Hidden]").val("");
//              input.parent().find(".custom-file-label").removeClass("uploading");
//              return false;
//            }
//
//            if (msg && msg.Status != undefined && msg.Status) {
//              input.parent().find(".custom-file-label").removeClass("uploading");
//
//              if (msg.Data != undefined && msg.Data[name] != undefined) {
//                var html = '<div class="img-uploaded"><img class="img-thumbnail mb-2" src="' + msg.Data[name] + '" alt="upload ' + name + '" class="img-thumbnail"></div>';
//                input.closest(".form-group").find(".uploaded-wrappper").html(html);
//                $("input[name=" + name + "Hidden]").val(msg.Data[name]);
//              }
//
//              if (validateForm(false)) {
//                $(".next-step").prop("disabled", false);
//              } else {
//                $(".next-step").prop("disabled", true);
//              }
//            } else {
//              alertMsg({
//                type: "warning",
//                title: "Terima kasih telah tertarik pada produk kami",
//                type_color: "bg-blue-1200",
//                text: "Maaf, kami tidak bisa menerima pengajuan Anda secara online saat ini. Silakan hubungi Customer Care Center kami di 1500 733 (Senin-Jumat, 08.00-17.00 WIB) untuk informasi lebih lanjut.",
//              });
//            }
//          },
//          true
//        );
//      });
    });
  }

  function dateDropdown(selector) {
    var min = $(selector).data("min") || "";
    var max = $(selector).data("max") || "";

    $(selector).dateDropdowns({
      dropdownClass: "form-control select-gray semi-bold selectize",
      daySuffixes: false,
      submitFormat: "dd/mm/yyyy",
      defaultDateFormat: "dd/mm/yyyy",
      yearLabel: "YYYY",
      monthLabel: "MM",
      dayLabel: "DD",
      monthFormat: "numeric",
      monthSuffixes: false,
      required: true,
      minDate: min,
      maxDate: max,
      selectize: true, // for combination with selectize plugin
    });
  }

  function validateImage(file) {
    var result = {
      Status: 1,
      Message: "",
    };

    if (file.size > _maxImageSize) {
      result.Status = 0;
      result.Message = "Maksimal ukuran gambar adalah 5Mb";
      return result;
    }

    if (!_allowImageType.includes(file.type)) {
      result.Status = 0;
      result.Message = "Format gambar yang diijinkan adalah *.jpg, *.jpeg dan *.png";
      return result;
    }

    return result;
  }

  init();
  initTrigger();
});
