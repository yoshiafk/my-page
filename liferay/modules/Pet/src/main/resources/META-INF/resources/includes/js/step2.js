$(function () {
  "use strict";

  var _maxImageSize = 5242880; // 5Mb
  var _allowImageType = ["image/jpg", "image/jpeg", "image/png"];

  var $_kyc_error;

  function init() {
    let sessionData = getSessionData(_sessionName);

    // Populate data from session storage to elements container
    if (sessionData) {
      updateFormGeneral(sessionData);
      updateFormStep2(sessionData);

      // remove token if ubah penawaran
      //  		if(EditQuotation && getSessionData() && getSessionData().Token) {
      //  			SessionStorage.set(_sessionName, 'Token', "");
      //  			SessionStorage.set(_sessionName, 'TempCode', "");
      //  		}
    }

    // kyc error
    $_kyc_error = $("#main-section").data("error");
    if ($_kyc_error) {
      alertMsg({
        type: "warning",
        text: "Mohon maaf. Data tidak lengkap, <br />" + $_kyc_error,
        button: '<button type="button" class="btn btn-blue-1100" data-dismiss="modal">Ok</button>',
      });

      validateForm(true);
    }

    // Date dropdown
    $(".datedropdown").each(function (k, elm) {
      dateDropdown(elm);
    });

    // check kitas
    //      checkKitas();

    // select
    $(".selectize").selectize();

    // province
    $("select[name=Province]").selectize({
      onChange: function (value) {
        $("select[name=City]").selectize()[0].selectize.destroy();
        $("select[name=City]").val("");
        $("select[name=City]").selectize({
          render: {
            option: function (item, escape) {
              if (escape(item.Province) != value) return "<div></div>";
              return "<div class='option'>" + escape(item.text) + "</div>";
            },
          },
        });
      },
    });

    // city
    if ($("select[name=City]")) {
      $("select[name=City]").selectize({
        render: {
          option: function (item, escape) {
            if (escape(item.Province) != $("select[name=Province]").val()) return "<div></div>";
            return "<div class='option'>" + escape(item.text) + "</div>";
          },
        },
      });
    }

    // countries
    if ($("select[name=NationalityCountry]")) {
      $("select[name=NationalityCountry]").selectize({
        placeholder: "- Pilih Kewarganegaraan -",
      });
    }

    // check button
    if (validateForm(false)) {
      $(".next-step").prop("disabled", false);
    } else {
      $(".next-step").prop("disabled", true);
    }

    // calculate
//    jqAjax({}, calculateURL, function (msg) {
//      if (msg && msg["Status"]) {
//        if (msg["Data"] && msg["Data"]["Discount"]) $(".promo .info").html($("#promocode").val() + " berhasil dipakai.");
//        updateSidebar(msg["Data"]);
//      }
//    });
  }

  function initTrigger() {
    // health global init
    //   _product.pi.initTrigger();

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

    $("body").on("change", "select[name=NationalityCountry]", function () {
      //        checkKitas();
    });

    $("body").on("change", "select[name=Job]", function () {
      if (!$(this).val()) return;

      if (
        $(this)
          .find("option[value=" + $(this).val() + "]")
          .html()
          .toLowerCase() == "lainnya"
      ) {
        $(".job-other").removeClass("d-none");
      } else {
        $(".job-other").addClass("d-none");
        $(".job-other input").val("");
      }
    });

    // Next step
       $("body").on("click", ".next-step", function () {
         var _self = $(this);
         loadingBtnNext(false);
         
         console.log(validateForm());

         if (!validateForm()) {
           loadingBtnNext(true);
           return false;
         }

         // fetch all data
//         getData(function (data) {
//           jqAjax(data, kycURL, function (msg) {
//             if (msg.Status == undefined || !msg.Status) {
//               // retry
//               _self.trigger("click");
//
//               alertMsg({
//                 type: "warning",
//                 text:
//                   msg.Message != undefined
//                     ? msg.Message
//                     : "Terjadi kesalahan, error",
//               });
//               return false;
//             }
//
//             checkBlockedPep(msg.Data.KycId, function () {
//               window.location.href = "/pet/quote/step3";
//             });
//           });
//         });
         
         window.location.href = petStep3URL + '&a=' + aParam; // variable ini didefine di step1.jsp
       });

    $("body").on("change", "input.upload-idphoto", function () {
      var input = $(this);
      var name = input.attr("name");

      // validate image
      var validate_image = validateImage(input.prop("files")[0]);
      if (!validate_image.Status) {
        alertMsg({
          type: "warning",
          text: validate_image.Message,
        });

        input.siblings("input[type=hidden]").val("");
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
    		  formData.append('type', 'leadIdPhoto');
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
//                         text: response.Message,
                         text: "Error upload image",
                       });

                       input.siblings("input[type=hidden]").val("");
                       input.siblings(".custom-file-label").removeClass("uploading");
                       return false;
                     }
                     
                     SessionStorage.set(_sessionName, "idPhotoFileEntryId", response.data.id);
                     SessionStorage.set(_sessionName, "idPhotoPreview", response.data.preview);
                     
        	  	
                     var html =
                       '<div class="img-uploaded"><img class="img-thumbnail mb-2" src="' +
                       response.data.preview +
                       '" alt="upload ' +
                       name +
                       '" class="img-thumbnail"></div>';
                     input.parent().siblings(".uploaded-wrappper").html(html);
                     input.siblings("input[type=hidden]").val(response.data.id);
                     input.siblings(".custom-file-label").html(name);
                     input.siblings(".custom-file-label").removeClass("uploading");
                     
//                     checkValidateForm();
          },
          error: function(xhr, status, error) {
              console.log('Error upload image');
          }
      });

      // getData(function (data) {
      //   var newdata = new FormData();

      //   newdata.append(
      //     "Upload[Type]",
      //     input.data("group") ? input.data("group") : name
      //   );
      //   newdata.append(
      //     "Upload[Key]",
      //     input.data("group-key") != undefined &&
      //       input.data("group-key").toString().length
      //       ? input.data("group-key")
      //       : ""
      //   );
      //   newdata.append("IdPhoto", input.prop("files")[0]);

      //   input.parent().find(".custom-file-label").addClass("uploading");
      //   jqAjax(
      //     newdata,
      //     _product.pi.url.kyc,
      //     function (msg) {
      //       if (msg && msg.Status != undefined && msg.Status == 0) {
      //         alertMsg({
      //           type: "warning",
      //           text: msg.Message,
      //         });

      //         input.siblings("input[type=hidden]").val("");
      //         input.siblings(".custom-file-label").removeClass("uploading");
      //         return false;
      //       }

      //       var html =
      //         '<div class="img-uploaded"><img class="img-thumbnail mb-2" src="' +
      //         msg.Data.Image.download +
      //         '" alt="upload ' +
      //         name +
      //         '" class="img-thumbnail"></div>';
      //       input.parent().siblings(".uploaded-wrappper").html(html);
      //       input.siblings("input[type=hidden]").val(msg.Data.Image.download);
      //       input.siblings(".custom-file-label").html(msg.Data.Image.name);
      //       input.siblings(".custom-file-label").removeClass("uploading");

      //       // validate form
      //       checkValidateForm();
      //     },
      //     true
      //   );
      // });
    });
  }

  function dateDropdown(selector) {
    var min = $(selector).data("min") || "";
    var max = $(selector).data("max") || "";

    $(selector).dateDropdowns({
      dropdownClass: "form-control select-gray semi-bold selectize",
      daySuffixes: false,
      submitFormat: "dd-mm-yyyy",
      defaultDateFormat: "dd-mm-yyyy",
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

  function checkKitas() {
    if ($("select[name=NationalityCountry]").val().toLowerCase() != "indonesia" && $("select[name=NationalityCountry]").val() != "") {
      $("#kitas").removeClass("d-none");
      $("#ktp").addClass("d-none");
      $("input[name=IdNumber]").val("");
    } else {
      $("#kitas").addClass("d-none");
      $("#ktp").removeClass("d-none");
      $("input[name=KitasNumber]").val("");
    }
  }

  function checkBlockedPep(kycId, callback) {
    var data = getData();
    var arr = [];
    arr.push({
      isPep: data.isPep == "0" ? 0 : 1,
      name: data.Name || "",
      dob: data.Dob || "",
      ktp: data.IdNumber || "",
      kitas: data.KitasNumber || "",
      passport: data.KitasNumber || "",
      email: data.Email || "",
      dob: data.Dob || "",
    });

    jqAjax({ Data: arr, KycId: kycId }, "/api/check-blocked-pep", function (msgCal) {
      if (msgCal.Status == undefined || !msgCal.Status) {
        alertMsg({
          type: "warning",
          text: msgCal.Message != undefined ? msgCal.Message : "Terjadi kesalahan, error",
        });

        loadingBtnNext(true);
        return false;
      }

      if (msgCal.Data.Blocked == 1) {
        alertMsg({
          type: "warning",
          text: msgCal.Data.Message,
          type_color: "bg-blue-1200",
          button: '<button type="button" class="btn btn-yellow-box small semo-bold" data-dismiss="modal"><i class="far fa-check"></i> Ok</button>',
        });

        loadingBtnNext(true);
        return false;
      }

      return callback();
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

  ///////////////////////////
  init();
  initTrigger();
});
