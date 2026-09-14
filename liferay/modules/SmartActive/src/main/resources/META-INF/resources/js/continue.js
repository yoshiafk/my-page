function disableForm(){
	
	// Inisialisasi Select2
    $('.form-container select').select2();

    // Membuat input & textarea readonly
    $('.form-container input, .form-container textarea')
        .not('.summary__container *')
        .prop('disabled', true);

    // Mencegah pengguna membuka Select2 (readonly effect)
    $('.form-container select')
        .not('.summary__container *')
        .prop('disabled', true)
        .on('select2:opening', function (e) {
        	if ($(this).prop('disabled')) {
        		e.preventDefault(); // Mencegah dropdown terbuka
        	}
        });
    
    $('.form-container input[type="radio"]')
    .not('.summary__container *')
    .prop('disabled', true); // Disable radio button
}

//Function untuk format angka dengan titik
function formatNumber(num) {
    return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
}

$(document).ready(function () {
	if (quoteCategory == "edit") {
		displayLoading();
		window.location.href = linkStep2; //ke step1 (step2.jsp) polis
	}
	
    $(".btn__next, .btn__ubah_quote")
        .removeClass("btn--dark-grey")
        .addClass("btn--dark-blue")
        .css({ pointerEvents: "auto", opacity: "1" });
    
    $(".btn__next").on("click", function (e) {
    	e.preventDefault();
    	
    	var qType = quoteType.trim().toLowerCase();
    	let sessData = sessionStorage.getItem(_smartActiveFormDetailSess);
    	if (sessData) sessData = JSON.parse(sessData);

    	if (typeof isPep === 'boolean') {
    		qType = "full";
	        if (qType === "full") {
	        	let kycPayload = collectDataFull();
	        	Object.assign(kycPayload, collectDataSimple());
	            
	            let payload = {
	    	      kyc: kycPayload,
	    	      Quotation: 0,
	    	      AdditionalBenefits: sessData.AdditionalBenefits,
	    	      Type: "full"
	    	    };
	
	            if (sessData) {
	            	Object.assign(payload, {
	            		BusinessModel: sessData.BusinessModel,
	            		ManagedBy: sessData.ManagedBy,
	            		ManagedById: sessData.ManagedById,
	            		Role: sessData.Role,
	            		UtmSource: sessData.UtmSource,
	            		UtmMedium: sessData.UtmMedium,
	            		UtmCampaign: sessData.UtmCampaign,
	            		UtmTerm: sessData.UtmTerm,
	            		UtmContent: sessData.UtmContent,
	            		PromoCode: sessData.PromoCode,
	            		TokenLimiter: $('input[name="csrfToken"]').val()
	    		    });
	            }
	
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
	                    Token: token
	                  };
	
	                  // Simpan ke sessionStorage
	                  Object.entries(sessionData).forEach(([key, value]) => {
	                    updateSess(_smartActiveFormDetailSess, key, value);
	                  });
	
	                  	if (!kycPayload.PhotoFileUrl) {
		              		window.location.href = linkStep3;
		              	} else {
		              		window.location.href = linkRiplay;
		              	}
	                } else {
	                  $('input[name="csrfToken"]').val(response.Data.TokenLimiter)
	                  document.querySelector(".modal_alert-body").innerHTML =
	                    response.Message;
	                  const modalContent = document.querySelector(".modal_alert-content");
	
	                  if (modalContent) {
	                    modalContent.style.width = "40%";
	                  }
	
	                  openModalAlertBlocked();
	                  hideLoading();
	                  return;
	                }
	              },
	            });
	        } else if (qType === "simple") {
	            const kycPayload = collectDataSimple();
	            
	            let payload = {
	    	      kyc: kycPayload,
	    	      Quotation: 0,
	    	      AdditionalBenefits: sessData.AdditionalBenefits,
	    	    };
	
	            if (sessData) {
	            	Object.assign(payload, {
	            		BusinessModel: sessData.BusinessModel,
	            		ManagedBy: sessData.ManagedBy,
	            		ManagedById: sessData.ManagedById,
	            		Role: sessData.Role,
	            		UtmSource: sessData.UtmSource,
	            		UtmMedium: sessData.UtmMedium,
	            		UtmCampaign: sessData.UtmCampaign,
	            		UtmTerm: sessData.UtmTerm,
	            		UtmContent: sessData.UtmContent,
	            		PromoCode: sessData.PromoCode,
	            		TokenLimiter: $('input[name="csrfToken"]').val()
	    		    });
	            }
	
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
	                    Token: token
	                  };
	
	                  // Simpan ke sessionStorage
	                  Object.entries(sessionData).forEach(([key, value]) => {
	                    updateSess(_smartActiveFormDetailSess, key, value);
	                  });
	
	                  window.location.href = linkStep3;
	                } else {
	                  $('input[name="csrfToken"]').val(response.Data.TokenLimiter)
	                  document.querySelector(".modal_alert-body").innerHTML =
	                    response.Message;
	                  const modalContent = document.querySelector(".modal_alert-content");
	
	                  if (modalContent) {
	                    modalContent.style.width = "40%";
	                  }
	
	                  openModalAlertBlocked();
	                  hideLoading();
	                  return;
	                }
	              },
	            });
	        }
    	}
    });
    
    $(".btn__ubah_quote").on("click", function (e) {
    	e.preventDefault();
    	displayLoading();
    	
    	// Format ulang data sesuai yang diinginkan
        let sessionData = {
          QuoteCategory: 'edit'
        };

        // Simpan ke sessionStorage
        Object.entries(sessionData).forEach(([key, value]) => {
          updateSess(_smartActiveFormDetailSess, key, value);
        });
        
        let url = linkStep2;
    	
        if (quoteType.trim().toLowerCase() === "full") {
	        url = new URL(url);
		    url.searchParams.set('qe', 'edit');
		    url.searchParams.set('qq', 'full');
        }
        
        if (quoteType.trim().toLowerCase() === "simple") {
	        url = new URL(url);
		    url.searchParams.set('qe', 'edit');
        }
        
    	window.location.href = url; //ke step1 (step2.jsp) polis
    });
    
    
    disableForm();
    

    //INIT JS
   
    var $rangeSlider = $("#range");

	// Ambil nilai dari option dalam #valueSelect
	var sliderValues = $("#valueSelect option").map(function() {
	    return parseInt($(this).val(), 10);
	}).get();

	// Inisialisasi range slider dengan nilai dari select option
	$rangeSlider.ionRangeSlider({
	    skin: "round",
	    values: sliderValues.map(String), // Konversi ke string untuk kompatibilitas
	    from: 0,
	    prettify: function(value) {
	        return formatNumber(value); // Format angka dengan titik
	    },
	    onStart: function(data) { 
	        $(".irs-single").text(formatNumber(sliderValues[data.from])); 
	    },
	    onChange: function(data) {
	        var selectedValue = sliderValues[data.from]; // Ambil nilai numerik
	        $("#valueSelect").val(selectedValue).trigger("change");

	        $(".irs-single").text(formatNumber(selectedValue)); // Update tampilan

	        $('.irs-single').removeClass('low medium high');
	        if (data.from <= 1) {
	            $('.irs-single').addClass('low');
	        } else if (data.from <= 3) {
	            $('.irs-single').addClass('medium');
	        } else {
	            $('.irs-single').addClass('high');
	        }
	    }
	});
	
	// Handle perubahan di select dan update slider
	$('#valueSelect').on('change', function() {
	    var selectedValue = parseInt($(this).val(), 10);
	    var index = sliderValues.indexOf(selectedValue);
	    if (index !== -1) {
	        var sliderInstance = $rangeSlider.data("ionRangeSlider");
	        sliderInstance.update({
	            from: index
	        });

	        $(".irs-single").text(formatNumber(selectedValue)); // Update tampilan

	        $('.irs-single').removeClass('low medium high');
	        if (index <= 1) {
	            $('.irs-single').addClass('low');
	        } else if (index <= 3) {
	            $('.irs-single').addClass('medium');
	        } else {
	            $('.irs-single').addClass('high');
	        }
	    }
	    
	});
    
	// Nonaktifkan Range Slider
    var sliderInstance = $rangeSlider.data("ionRangeSlider");
    sliderInstance.update({ disable: true });
    
    $("#valueSelect option").each(function() {
	    var num = parseInt($(this).val(), 10);
	    if (!isNaN(num)) {
	        $(this).text(formatNumber(num)); // Gunakan function formatNumber yang sudah ada
	    }
	});
	
	$('#type-of-work, #employment').select2({
		dropdownParent: '#type-of-work-wrapper',
		placeholder: "Pekerjaan",
		width: '100%'
	});
	
	$('.valueSelect').select2({
		width: '100%',
		dropdownParent: '#valueSelect-wrapper',
		minimumResultsForSearch: -1
	});
	
	//CHECK SESSION DATA GET TOKEN
    const sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);
    if (sessionData) {
    	const data = JSON.parse(sessionData);
    	
    	reinitDataForm(data);
    	
    	//check leads api
    	checkLeads(data);
    	
    	//create calculation
    	calculatePremi(data);
    	
    }
	
	
	// call pertama saat load
    updateAdditionalBenefitSection();
});


function updateAdditionalBenefitSection(debug = false) {
    let selectedMainBenefitValue = $("#valueSelect").val();

    // Ambil daftar benefit yang tersimpan di session
    let additionalBenefitsFromSession = [];
    const sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);
    if (sessionData) {
        const parsedData = JSON.parse(sessionData);
        if (parsedData.AdditionalBenefits) {
            additionalBenefitsFromSession = parsedData.AdditionalBenefits;
        }
    }

    // Elemen yang akan dikontrol tampilannya
    const panelAdditional = document.querySelector(".panel-additional");
    const allowanceCover = document.querySelector(".allowance-cover");
    const otherCover = document.querySelector(".other-cover");

    // Jika tidak ada AdditionalBenefits, sembunyikan panel utama dan keluar dari fungsi
    if (additionalBenefitsFromSession.length === 0) {
        panelAdditional.style.display = "none";
    }

    $.ajax({
        url: _apiURL + "/o/api/sa/additionalbenefit",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ MainBenefitValue: selectedMainBenefitValue }),
        success: function (response) {
            try {
                let data = response.Data;
                if (typeof data === 'string') {
                    data = JSON.parse(data);
                }

                if (Array.isArray(data)) {
                    const allowancesContainer = document.querySelector("#allowance-benefit-container");
                    const otherBenefitContainer = document.querySelector("#other-benefit-container");
                    const mainBenefitNameContainer = document.querySelector(".panel-inside__body.main-benefit .mainBenefitName");
                    const mainBenefitValueContainer = document.querySelector(".panel-inside__body.main-benefit .mainBenefitValue");

                    if (!allowancesContainer || !otherBenefitContainer || !mainBenefitNameContainer || !mainBenefitValueContainer) {
                        return;
                    }

                    let allowancesContent = "";
                    let otherBenefitsContent = "";
                    let mainBenefitNameHTML = "";
                    let mainBenefitValueHTML = "";

                    let lastValue = null;
                    let hasAllowance = false;
                    let hasOtherBenefit = false;

                    data.forEach(benefit => {
                        // Menampilkan "Jaminan Utama" pada panel utama
                        if (benefit.benefitType.toLowerCase() === "jaminan utama") {
                            mainBenefitNameHTML += `<p>${benefit.benefitName}</p>`;
                            if (benefit.value !== lastValue) {
                                mainBenefitValueHTML += `<p>${benefit.value || "-"}</p>`;
                                lastValue = benefit.value;
                            }
                        }

                        // Hanya tampilkan benefit jika ID-nya ada dalam session
                        if (!additionalBenefitsFromSession.includes(benefit.benefitId)) {
                            return;
                        }

                        // Menampilkan benefit lainnya tanpa toggle dan tombol penjelasan
                        const benefitRow = `
                            <div class="col-panel-row">
                                <div class="col-panel">
                                    <span>${benefit.benefitName}</span>
                                </div>
                                <div class="col-panel">
                                    ${benefit.value || "-"}
                                </div>
                            </div>
                        `;

                        if (benefit.benefitType.toLowerCase() === "santunan") {
                            allowancesContent += benefitRow;
                            hasAllowance = true;
                        } else if (benefit.benefitType.toLowerCase() === "jaminan lainnya") {
                            otherBenefitsContent += benefitRow;
                            hasOtherBenefit = true;
                        }
                    });

                    mainBenefitNameContainer.innerHTML = mainBenefitNameHTML;
                    mainBenefitValueContainer.innerHTML = mainBenefitValueHTML;
                    allowancesContainer.innerHTML = allowancesContent;
                    otherBenefitContainer.innerHTML = otherBenefitsContent;

                    // Tampilkan allowanceCover jika ada "santunan"
                    allowanceCover.style.display = hasAllowance ? "block" : "none";

                    // Tampilkan otherCover jika ada "lainnya"
                    otherCover.style.display = hasOtherBenefit ? "block" : "none";
                }
            } catch (e) {
                console.error("Error parsing response.Data:", e);
            }
        },
        error: function (xhr, status, error) {
            console.error("Error:", error);
        },
    });
}



function infoBenefit(e, element) {
    e.preventDefault();
    const target = $(element).data('target');
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
            //console.error("Gagal mengambil informasi tambahan.");
        }
    });
}


function checkLeads(sessionData) {
	
	let token = sessionData.Token;
	
	//console.log('Hit checkLeads >> Try check data in step1 with token >> ' + token);

	$.ajax({
        url: _apiURL + `/o/api/sa/check/leads?t=${leadsToken}`,
        type: "GET",
        success: function (response) {
        	
        	if(response.status){
        		//console.log('response.data leads>> ', response.data);
        		
        		const dataLeads =  response.data;
        		
        		// Mengisi kembali select option untuk pekerjaan
        	    if (dataLeads.Job) {
        	        const jobSelect = $('select[name="Occupation"]');
        	        if (jobSelect.length) {
        	            jobSelect.val(dataLeads.Job).trigger('change'); // Update nilai dan trigger event change
        	        }
        	    }
        		

        	    if (typeof moment !== "undefined") {
        	        // Mengisi kembali tanggal lahir
        	        if (dataLeads.Dob) {
        	        	moment.locale('id');
        	        	let value = moment(new Date(dataLeads.Dob)).format("DD/MMM/YYYY");
        	        	$('#choose-plan-birth').val(value);
        	        }
        	        
        	    } else {
        	        //console.error("Moment.js tidak tersedia. Pastikan moment.js sudah dimuat.");
        	    }
        	    
        	    
        	    //DATA TERTANGGUNG
        	    
        	    if (typeof dataLeads.IsPEP !== "undefined") {
        	        let selectedValue = dataLeads.IsPEP == 1 ? "Y" : "N"; // Pastikan dalam format string untuk kecocokan nilai
        	        $('input[name="radio-pep"][value="' + selectedValue + '"]').prop('checked', true);
        	    }
        	    
        	    if (typeof dataLeads.Preview !== "undefined") {
        	    	let val = dataLeads.Preview;
        	        $('input[name="imgUrl"]').val(val);
        	        
        	        let valId = dataLeads.ImgId;
        	        $('input[name="imgId"]').val(valId);
        	    	
        	    	let file = {
    	    			preview: dataLeads.Preview,
    	    			name: dataLeads.ImgName
    	    		};
    	    		
    	    		previewImg(file);
        	    }
        	    
        	    if (typeof dataLeads.PolicyName !== "undefined") {
        	        let val = dataLeads.PolicyName;
        	        $('input[name="id-card-identity-name"]').val(val);
        	    }
        	    
        	    if (dataLeads.Nationality) {
        	        $('#citizenship').val(dataLeads.Nationality);
        	    }
        	    
        	    if (typeof dataLeads.IdNumber !== "undefined") {
        	        let val = dataLeads.IdNumber;
        	        $('input[name="id-card-identity-number"]').val(val);
        	    }
        	    
        	    if (typeof moment !== "undefined") {
        	        if (dataLeads.Dob) {
        	            moment.locale('id');
        	            let dob = moment(new Date(dataLeads.Dob));

        	            let formattedDob = dob.format("DD/MMM/YYYY");
        	            $('input[name="birth-date"]').val(formattedDob);
        	            $('input[name="age"]').val(dataLeads.Age);
        	        }
        	    }
        	    
        	    if (typeof dataLeads.BirthPlace !== "undefined") {
        	        let val = dataLeads.BirthPlace;
        	        $('input[name="birth-place"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.Gender !== "undefined") {
        	        let selectedValue = dataLeads.Gender;
        	        $('input[name="gender"][value="' + selectedValue + '"]').prop('checked', true);
        	    }
        	    
        	    if (typeof dataLeads.MobilePhone !== "undefined") {
        	        let val = dataLeads.MobilePhone;
        	        $('input[name="id-card-identity-no-hp"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.Email !== "undefined") {
        	        let val = dataLeads.Email;
        	        $('input[name="id-card-identity-email"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.ZipCode !== "undefined") {
        	        let val = dataLeads.ZipCode;
        	        $('input[name="id-card-identity-postal-code"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.Province !== "undefined") {
        	    	let val = dataLeads.Province;
        	        $('input[name="province"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.City !== "undefined") {
        	    	let val = dataLeads.City;
        	        $('input[name="regency"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.Address !== "undefined") {
        	        let val = dataLeads.Address;
        	        $('input[name="address"]').val(val);
        	    }
        	    
        	    if (dataLeads.Job) {
        	        const jobSelect = $('select[name="employment"]');
        	        if (jobSelect.length) {
        	            jobSelect.val(dataLeads.Job).trigger('change');
        	        }
        	    }
        	    
        	    if (typeof dataLeads.WorkLocation !== "undefined") {
        	    	let val = dataLeads.WorkLocation;
        	        $('input[name="locations-and-activities"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.AdditionalWorkLocation !== "undefined") {
        	    	let val = dataLeads.AdditionalWorkLocation;
        	        $('input[name="additional-locations"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.MonthlyIncome !== "undefined") {
        	        let selectedValue = dataLeads.MonthlyIncome;
        	        $('input[name="radio-income"][value="' + selectedValue + '"]').prop('checked', true);
        	    }
        	    
        	    if (typeof dataLeads.PaymentSource !== "undefined") {
        	    	let val = dataLeads.PaymentSource;
        	        $('input[name="source-of-premium-payments"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.AdditionalPaymentSource !== "undefined") {
        	    	let val = dataLeads.AdditionalPaymentSource;
        	        $('input[name="additional-payments"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.BeneficiaryName !== "undefined") {
        	        let val = dataLeads.BeneficiaryName;
        	        $('input[name="beneficiary"]').val(val);
        	    }
        	    
        	    if (typeof dataLeads.BeneficiaryRelationship !== "undefined") {
        	    	let val = dataLeads.BeneficiaryRelationship;
        	        $('input[name="beneficiary-relationship"]').val(val);
        	    }
        		
        	}
        	
        },
        error: function () {
            //console.error("Gagal mengambil informasi tambahan.");
        }
    });
}


function reinitDataForm(sessData){
	moment.locale('id');
	
	//console.log('REINIT DATA FORM!!');
	
    const datasess = sessData;
    
    //console.log('datasess', datasess);
    
    /**
     * SET FROM SESSION 
     */
    // Mengisi kembali radio button
    if (typeof datasess.ExcludedActivityStatus !== "undefined") {
        const radio = document.querySelector(`input[name="radio-polis"][value="${datasess.ExcludedActivityStatus}"]`);
        if (radio) {
            radio.checked = true;
        }
    }

    // Mengisi kembali nilai manfaat utama
    if (datasess.MainBenefitValue) {
        const benefitSelect = $('select[name="MainBenefitValue"]');
        if (benefitSelect.length) {
            benefitSelect.val(datasess.MainBenefitValue).trigger('change'); // Update Select2
        }
    }
    
    
    if (typeof moment !== "undefined") { //datepicker butuh 06/MAR/1995 -> 03-06-1995
    	
    	// Proses StartDate
    	if (datasess.PeriodeFrom) {
    		let value = moment(datasess.PeriodeFrom, "DD/MMM/YYYY").format("DD/MMM/YYYY");
    		$('#from').val(value);
    	}
    	
    	if (datasess.PeriodeTo) {
    		let value = moment(datasess.PeriodeTo, "DD/MMM/YYYY").format("DD/MMM/YYYY");
    		$('#until').val(value);
    		
    	}

    } else {
        //console.error("Moment.js tidak tersedia. Pastikan moment.js sudah dimuat.");
    }
    
    /**
     * END 
     */
    
}



function calculatePremi(existingSession) {
	
	//console.log('HIT API CALCULATION CONTINUE.JS')
	
	$.ajax({
		  url: _apiURL + "/o/api/sa/calculate",
		  type: "POST",
		  contentType: "application/json",
		  data: JSON.stringify(existingSession),
		  success: function (response) {
			  if (!response.Status) {
				  document.querySelector(".modal_alert-body").innerHTML = 'Data kalkulasi tidak ditemukan [CN01]';
                  const modalContent = document.querySelector(".modal_alert-content");
                  const okButton = document.querySelector('.ispep_modal__inner-footer-btn');
                  
                  if (modalContent) {
                      modalContent.style.width = "40%";
                  }
                  
                  openModalAlertBlocked();
                  return;
			  }
			  
			  if (response.Data.Calculation) {
				  sessionStorage.setItem(_smartActiveCalculation, JSON.stringify(response.Data.Calculation));
				  
				  // call sidebar
//				  updateStickyPrice();
				  updatePlanSummarySidebar();
			  }
		  },
		  error: function (xhr, status, error) {
		  },
		});


}

function collectDataSimple() {
  const data = {
    ExcludedActivityStatus: getCheckedValue('input[name="radio-polis"]'),

    Job: getValue('select[name="Occupation"]'),

    Dob: getValue('input[name="plan-birth"]'), //tanggal lahir

    MainBenefitValue: getValue('select[name="MainBenefitValue"]'),

    PeriodeFrom: getValue('input[name="PeriodeFrom"]'),

    PeriodeTo: getValue('input[name="PeriodeTo"]'),
    
    Name: getValue('input[name="id-card-identity-name"]'),
    
    Email: getValue('input[name="id-card-identity-email"]'),
  };

  return data;
}

function collectDataFull() {
	let data = {};

	if ($('input[name="radio-pep"]').length) {
		const isPep = getCheckedValue('input[name="radio-pep"]');
		if (isPep) data.IsPep = isPep == "Y" ? 1 : 0;
	}
	
	if ($('input[name="imgUrl"]').length) {
		const photoFileUrl = getValue('input[name="imgUrl"]');
		if (photoFileUrl) data.PhotoFileUrl = photoFileUrl;
	}
	
	if ($('input[name="imgId"]').length) {
		const imageId = getValue('input[name="imgId"]');
		if (imageId) data.ImageId = imageId;
	}

	if ($('input[name="id-card-identity-name"]').length) {
		const name = getValue('input[name="id-card-identity-name"]');
		if (name) data.Name = name;
	}

	if ($('input[name="citizenship"]').length) {
		const citizenship = getValue('input[name="citizenship"]');
		if (citizenship) data.Citizenship = citizenship;
	}
	
	if ($('input[name="id-card-identity-number"]').length) {
		const idNumber = getValue('input[name="id-card-identity-number"]');
		if (idNumber) data.IdNum = idNumber;
	}
	
	if ($('input[name="birth-date"]').length) {
		const dob = getValue('input[name="birth-date"]');
		if (dob) data.Dob = dob;
	}
	
	if ($('input[name="age"]').length) {
		const age = getValue('input[name="age"]');
		if (age) data.Age = age;
	}

	if ($('input[name="birth-place"]').length) {
		const pob = getValue('input[name="birth-place"]');
		if (pob) data.Pob = pob;
	}

	if ($('input[name="gender"]').length) {
		const gender = getCheckedValue('input[name="gender"]');
		if (gender) data.Gender = gender;
	}
	
	if ($('input[name="id-card-identity-no-hp"]').length) {
		const phoneNumber = getValue('input[name="id-card-identity-no-hp"]');
		if (phoneNumber) data.PhoneNumber = phoneNumber;
	}
	
	if ($('input[name="id-card-identity-email"]').length) {
		const email = getValue('input[name="id-card-identity-email"]');
		if (email) data.Email = email;
	}
	
	if ($('input[name="id-card-identity-postal-code"]').length) {
		const zip = getValue('input[name="id-card-identity-postal-code"]');
		if (zip) data.Zip = zip;
	}
	
	if ($('input[name="province"]').length) {
		const province = getValue('input[name="province"]');
		if (province) data.Province = province;
	}
	
	if ($('input[name="regency"]').length) {
		const city = getValue('input[name="regency"]');
		if (city) data.City = city;
	}
	
	if ($('input[name="address"]').length) {
		const address = getValue('input[name="address"]');
		if (address) data.Address = address;
	}
	
	if ($('select[name="employment"]').length) {
		const job = getTitleOption('select[name="employment"]');
		if (job) data.Job = job;
	}
	
	if ($('input[name="locations-and-activities"]').length) {
		const workLocation = getValue('input[name="locations-and-activities"]');
		if (workLocation) data.WorkLocation = workLocation;
	
		if ($('input[name="additional-locations"]').length) {
			const additionalWorkLocation = getValue('input[name="additional-locations"]');
			if (workLocation == 'Lainnya') data.AdditionalWorkLocation = additionalWorkLocation;	
		}
	}

	if ($('input[name="radio-income"]').length) {
		const monthlyIncome = getCheckedText('input[name="radio-income"]');
		if (monthlyIncome) data.MonthlyIncome = monthlyIncome;
	}

	if ($('input[name="source-of-premium-payments"]').length) {
		const paymentSource = getValue('input[name="source-of-premium-payments"]');
		if (paymentSource) data.PaymentSource = paymentSource;

		if ($('input[name="additional-payments"]').length) {
			const additionalPaymentSource = getValue('input[name="additional-payments"]');
			if (paymentSource == 'Lainnya') data.AdditionalPaymentSource = additionalPaymentSource;
		}
	}

	if ($('input[name="beneficiary"]').length) {
		const beneficiary = getValue('input[name="beneficiary"]');
		if (beneficiary) data.Beneficiary = beneficiary;
	}

	if ($('input[name="beneficiary-relationship"]').length) {
		const beneficiaryRelationship = getValue('input[name="beneficiary-relationship"]');
		if (beneficiaryRelationship) data.BeneficiaryRelationship = beneficiaryRelationship;
	}

    return data;
}