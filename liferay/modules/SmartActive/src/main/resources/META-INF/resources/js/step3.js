let sessionDataDetail = JSON.parse(sessionStorage.getItem(_smartActiveFormDetailSess));
let leads;
let promoCodeSubmitStat = false;
let birthDateOcr;

$(document).ready(function() {
	let dynamicType = 'num';
	
	initData();
	
	$('#select-plan').select2({
		dropdownParent: '#select-plan-wrapper',
		placeholder: "Pilih Plan",
		width: '100%',
		minimumResultsForSearch: -1
	});
	
	// Image upload
	$('.uploadButton').on('click', function () {
		$(this).closest('.thumbnail-wrapper').find('.fileInput').trigger('click');
	});
	
	$('.fileInput').on('change', function () {
		const input = $(this);
	    const file = this.files[0];
	    const allowedTypes = ["image/jpeg", "image/png", "image/gif", "image/bmp", "image/webp"];
	    const citizenship = getTitleOption('select[name="citizenship"]');
	    
	    if (!allowedTypes.includes(file.type)) {
	    	document.querySelector(".modal_alert-body").innerHTML = 'Gagal mengunggah gambar, harap gunakan format gambar (jpg, jpeg, png, gif, bmp, webp) atau dengan ukuran yang lebih kecil.';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            this.value = "";
            return;
        }
		
		const maxSize = 1048576; // 1MB

		if (file.size > maxSize) {
			document.querySelector(".modal_alert-body").innerHTML = 'Gagal mengunggah gambar, harap gunakan format gambar (jpg, jpeg, png, gif, bmp, webp) atau dengan ukuran yang lebih kecil.';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            this.value = "";
		    return;
		}
		
		if (!citizenship) {
            document.querySelector(".modal_alert-body").innerHTML = 'Gagal mengunggah gambar, harap pilih kewarganegaraan terlebih dahulu.';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            this.value = "";
            return; // Exit the function early
        }
	    
	    if (file) {
	        let formData = new FormData();
	        formData.append('file', file);
	        formData.append('token', sessionDataDetail.Token);
	        formData.append('tokenLimiter', $('input[name="csrfToken"]').val());

	        $.ajax({
	            url: _uploadImageURL,
	            type: "POST",
	            data: formData,
	            processData: false,
	            contentType: false,
	            beforeSend: function () {
	            	displayLoading();
	            },
	            success: async function (response) {
	            	response = JSON.parse(response);
	            	
	            	if (response.Data && response.Data.tokenLimiter) {
	            		$('input[name="csrfToken"]').val(response.Data.tokenLimiter);
	            	}
	            	
	                if (!response.Status) {
	                	document.querySelector(".modal_alert-body").innerHTML = response.Message;
	                    const modalContent = document.querySelector(".modal_alert-content");
	                    
	                    if (modalContent) {
	                    	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
	                    }
	                    
	                    openModalAlertBlocked();
	        		    return;
	                }
	        		
	        		if (citizenship && citizenship.toLowerCase() === "indonesia") {
	                    if (isScanOcr === 'true') {
	                        await handleOCR(response.Data.ocr);
	                    }
	                }
	                
	                updateSess(_smartActiveFormDetailSess, "ImageId", response.Data.imageId);
	                
	                $('input[name="imgUrl"]').val(response.Data.preview);
	                previewImg(response.Data, file);
	                setTimeout(() => {
	                    validateForm();
	                }, 1000);
	            },
	            complete: function() {
                	hideLoading();
	            }
	        });
	    }
	});
	
	$('#citizenship').select2({
		dropdownParent: '#citizenship-wrapper',
		placeholder: "Pilih Status Kewarganegaran",
		width: '100%'
	});

	$('#province').select2({
		dropdownParent: '#province-wrapper',
		placeholder: "Pilih Provinsi",
		width: '100%'
	});

	$('#regency').select2({
		dropdownParent: '#regency-wrapper',
		placeholder: "Pilih Kabupaten/Kota",
		width: '100%'
	});
	
	$('#employment').select2({
		dropdownParent: '#employment-wrapper',
		placeholder: "Pilih Perkerjaan",
		width: '100%'
	});
	
	$('#locations-and-activities').select2({
		dropdownParent: '#locations-and-activities-wrapper',
		placeholder: "Pilih Lokasi",
		width: '100%',
		minimumResultsForSearch: -1
	});

	$('#source-of-premium-payments').select2({
		dropdownParent: '#source-of-premium-payments-wrapper',
		placeholder: "Pilih Sumber Pembayaran",
		width: '100%',
		minimumResultsForSearch: -1
	});
	
	$('#beneficiary-relationship').select2({
		dropdownParent: '#beneficiary-relationship-wrapper',
		placeholder: "Pilih Hubungan dengan Ahli Waris",
		width: '100%',
		minimumResultsForSearch: -1
	});
	
	$('#select-plan').select2({
		dropdownParent: '#select-plan-wrapper',
		placeholder: "Pilih Plan",
		width: '100%',
		minimumResultsForSearch: -1
	});
	
	$('#birth-date').daterangepicker({
		parentEl: "#birth-date-wrapper",
		singleDatePicker: true,
		showDropdowns: true,
		startDate: maxBirthDate,
		minDate: minBirthDate,
        maxDate: maxBirthDate,
		autoUpdateInput: false,
		"buttonClasses": "btn-date",
		"applyButtonClasses": "btn-apply",
		"cancelClass": "btn-cancel",
		locale: {
			format: 'DD/MMM/YYYY',
			firstDay: 1,
			applyLabel: 'Pilih',
			cancelLabel: 'Batal',
			"daysOfWeek": ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
			"monthNames": ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
		},
	});
	  
	$('#birth-date').on('apply.daterangepicker', function(ev, picker) {
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
		let formattedDate = picker.startDate.format('DD/MMM/YYYY');
		const englishMonth = picker.startDate.format('MMM');
		if (monthMap[englishMonth] && formattedDate.includes(`/${englishMonth}/`)) {
			// Replace bagian bulan (mid) dari formattedDate
			formattedDate = formattedDate.replace(`/${englishMonth}/`, `/${monthMap[englishMonth]}/`);
		}
		$(this).val(formattedDate);
		
		calculateAge($(this).val());
		
		validateForm();
	});
				
	$('#birth-date').on('cancel.daterangepicker', function(ev, picker) {
		$(this).val('');
		ageInDays = 0;
		ageInYears = 0;
		$('#age').val(0);
		
		if ($('#age').val() > 0) {
			$('#age').attr('required', true);
		} else {
			$('#age').removeAttr('required');
		}
		
		validateForm();
	});
	
	$("#citizenship").on("change", function(e) {
		let value = getTitleOption('select[name="citizenship"]');
		dynamicType = value.toLowerCase() != 'indonesia' ? 'textNum' : 'num';
		let maxLength = value.toLowerCase() != 'indonesia' ? 25 : 16;
		$('#id-card-identity-number').attr('maxlength', maxLength);
		$('#id-card-identity-number').val('');
		
		validateForm();
	});
	
	$("#province").on("change", async function(e) {
		let $this = $(this);
		let value = $this.val();
		
		$('#regency').empty().prop('disabled', true);
		$('#regency').removeAttr('required');
		
		await getCity(value);
	});

	$('#employment').on('change', function(e) {
		let v = $(this).val();
		updateSess(_smartActiveFormDetailSess, "Occupation", v);
		calculatePremi();
	})
	
	$('#locations-and-activities').on('change', function() {
		$('span#locations-and-activities-error').addClass('display-hidden');
		var selectedValue = $(this).val();
		if (selectedValue == 'Lainnya') {
        	$('#additional-locations-wrapper').removeClass('display-hidden');
        	$('#additional-locations').attr('required', true);
		} else {
			$('#additional-locations-wrapper').addClass('display-hidden');
			$('#additional-locations').removeAttr('required');
		}
	});

	$('#source-of-premium-payments').on('change', function() {
		$('span#locations-and-activities-error').addClass('display-hidden');
		var selectedValue = $(this).val();
		if (selectedValue == 'Lainnya') {
        	$('#additional-payments-wrapper').removeClass('display-hidden');
        	$('#additional-payments').attr('required', true);
		} else {
			$('#additional-payments-wrapper').addClass('display-hidden');
			$('#additional-payments').removeAttr('required');
		}
	});
	
	$(".btn__next").on("click", function (e) {
		e.preventDefault();
		let kycPayload = collectData();
		
		if ((kycPayload.Citizenship.toLowerCase() == 'indonesia' && kycPayload.IdNum.length != 16) || (kycPayload.Citizenship.toLowerCase() != 'indonesia' && kycPayload.IdNum.length > 25)) {
			document.querySelector(".modal_alert-body").innerHTML = 'Nomor Identitas tidak sesuai';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            return;
		}
		
		if (kycPayload.Zip.length < 5) {
			document.querySelector(".modal_alert-body").innerHTML = 'Kode Pos tidak sesuai';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            return;
		}

        let sessData = sessionStorage.getItem(_smartActiveFormDetailSess);
		if (sessData) {
			sessData = JSON.parse(sessData);

		    Object.assign(kycPayload, {
		    	MainBenefitValue: sessData.MainBenefitValue,
		    	PeriodeFrom: sessData.PeriodeFrom,
		    	PeriodeTo: sessData.PeriodeTo,
		    	AdditionalBenefits: sessData.AdditionalBenefits,
		    	ExcludedActivityStatus: sessData.ExcludedActivityStatus,
		    	UtmSource: sessData.UtmSource,
		    	UtmMedium: sessData.UtmMedium,
		    	utmCampaign: sessData.utmCampaign,
		    	UtmTerm: sessData.UtmTerm,
		    	UtmContent: sessData.UtmContent
		    });
		    
		    if (sessData.ManagedBy) {
		    	Object.assign(kycPayload, {
		    		ManagedBy: sessData.ManagedBy
			    });
		    }
		    
		    if (sessData.ManagedById) {
		    	Object.assign(kycPayload, {
		    		ManagedById: sessData.ManagedById
			    });
		    }
		    
		    if (sessData.Role) {
		    	Object.assign(kycPayload, {
		    		Role: sessData.Role
			    });
		    }
		    
		    if (sessData.ImageId) {
		    	Object.assign(kycPayload, {
		    		ImageId: sessData.ImageId
			    });
		    }
		    
		    if (sessData.PromoCode) {
		    	Object.assign(kycPayload, {
		    		PromoCode: sessData.PromoCode
			    });
		    }
		    
		    if (sessData.BusinessModel) {
		    	Object.assign(kycPayload, {
		    		BusinessModel: sessData.BusinessModel
			    });
		    }
		}
        
        let payload = {
    		kyc: kycPayload,
            Quotation: 0
        };
		
		if (_quoteCategory == 'continue' || _quoteCategory == 'edit') {
			Object.assign(payload, {
		    	Category: _quoteCategory
		    });
			
//	    	if (sessionDataDetail.Token) {
//	    		delete sessionDataDetail.Token;
//	        }
	    }
		
		if (sessionDataDetail.Token) payload.Token = sessionDataDetail.Token;
		payload.TokenLimiter = $('input[name="csrfToken"]').val();
        
        $.ajax({
        	url: _setTransactionURL,
        	type: "POST",
        	dataType: "json",
        	data: { data: JSON.stringify(payload), type: 'submit' },
        	beforeSend: function () {
            	displayLoading();
            },
        	success: function(response) {
        		if (!response.Status) {
        			$('input[name="csrfToken"]').val(response.Data.TokenLimiter);
        			hideLoading();
        			document.querySelector(".modal_alert-body").innerHTML = response.Message;
                    const modalContent = document.querySelector(".modal_alert-content");
                    const okButton = document.querySelector('.ispep_modal__inner-footer-btn');
                    
                    if (modalContent) {
                    	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
                    }
                    
                    openModalAlertBlocked();
                    
                    if (typeof response.Blocked !== 'undefined' || typeof response.Pep !== 'undefined') {
                    	sessionStorage.clear();
                    	
                		if (okButton) {
                			okButton.onclick = () => closeModalAlertBlocked(response.Data.target);
                		}
                	}
                    return;
        		}
        		
        		if (response.Data && response.Data.Token) {
        			 let token = response.Data.Token;

                     // Format ulang data sesuai yang diinginkan
                     let sessionData = {
                       Token: token
                     };

                     // Simpan ke sessionStorage
                     Object.entries(sessionData).forEach(([key, value]) => {
                       updateSess(_smartActiveFormDetailSess, key, value);
                     });
        		}

                if (birthDateOcr) updateSess(_smartActiveFormDetailSess, "Dob", birthDateOcr);
        		
        		window.location.href = _nextStepURL;
        	}
        });
	});

  // PROMO CODE
  $('#promo-code-btn').on('click', function (e) {
	
  $(this).html('<span class="position-relative order-10">Loading....</span>');
   let pc = $('input[name="PromoCode"]').val();
   $('input[name="PromoCodeSidebar"]').val(pc);
   
   updateSess(_smartActiveFormDetailSess, "PromoCode", pc.toUpperCase());
   promoCodeSubmitStat = true;
   calculatePremi();
   $(".trigger-collapse-promo").trigger('click'); // tutup sticky promocode dan tampilkan summary

});	

$('#clear-promo-code-btn-sidebar').on('click', function(e) {
	let pc = $('input[name="PromoCodeSidebar"]').val();
	$('input[name="PromoCode"]').val(pc);
	
	updateSess(_smartActiveFormDetailSess, "PromoCode", pc.toUpperCase());
	promoCodeSubmitStat = true;
	calculatePremi();
});
	
	$('#send_quotation_btn_close').on('click', function() {
		quotationModal.hide();
	});
    
    $('#submit-quotation-btn').on('click', function() {
    	$('input[name="send_quotation_name"]').val($('input[name="id-card-identity-name"]').val().toUpperCase());
    	$('input[name="send_quotation_email"]').val($('input[name="id-card-identity-email"]').val());
    	$('input[name="send_quotation_name"], input[name="send_quotation_email').prop('disabled', true);
    	$('input[name="send_quotation_name"], input[name="send_quotation_email').addClass("sa-disabled");
    	quotationModal.show();
	});
    
    $('#send_quotation_form').on('submit', function(e) {
		e.preventDefault();
		
		let _name = $('input[name="id-card-identity-name"]').val().toUpperCase();
		let _email = $('input[name="id-card-identity-email"]').val();
		let _btn = $(this).find('button[type="submit"]');
		
		if (_name.length == 0) {
			quotationModal.hide();
			document.querySelector(".modal_alert-body").innerHTML = 'Nama atau email tidak sesuai';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            return;
		}
		
		if (_email.length == 0 || !/^[a-zA-Z0-9._-]+@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,10}$/.test(_email)) {
			quotationModal.hide();
			document.querySelector(".modal_alert-body").innerHTML = 'Nama atau email tidak sesuai';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            return;
		}
		
		let kycPayload = collectData();
		
		if ((kycPayload.Citizenship.toLowerCase() == 'indonesia' && kycPayload.IdNum.length != 16) || (kycPayload.Citizenship.toLowerCase() != 'indonesia' && kycPayload.IdNum.length > 25)) {
			quotationModal.hide();
			document.querySelector(".modal_alert-body").innerHTML = 'Nomor Identitas tidak sesuai';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            return;
		}
		
		if (kycPayload.Zip.length < 5) {
			quotationModal.hide();
			document.querySelector(".modal_alert-body").innerHTML = 'Kode Pos tidak sesuai';
            const modalContent = document.querySelector(".modal_alert-content");
            
            if (modalContent) {
            	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            return;
		}

		let sessData = sessionStorage.getItem(_smartActiveFormDetailSess);
		if (sessData) {
			sessData = JSON.parse(sessData);

		    Object.assign(kycPayload, {
		    	BusinessModel: sessData.BusinessModel,
		    	ExcludedActivityStatus: sessData.ExcludedActivityStatus,
		    	MainBenefitValue: sessData.MainBenefitValue,
		    	PeriodeFrom: sessData.PeriodeFrom,
		    	PeriodeTo: sessData.PeriodeTo,
		    	AdditionalBenefits: sessData.AdditionalBenefits,
		    	UtmSource: sessData.UtmSource,
		    	UtmMedium: sessData.UtmMedium,
		    	utmCampaign: sessData.utmCampaign,
		    	UtmTerm: sessData.UtmTerm,
		    	UtmContent: sessData.UtmContent
		    });
		    
		    if (sessData.ManagedBy) {
		    	Object.assign(kycPayload, {
		    		ManagedBy: sessData.ManagedBy
			    });
		    }
		    
		    if (sessData.ManagedById) {
		    	Object.assign(kycPayload, {
		    		ManagedById: sessData.ManagedById
			    });
		    }
		    
		    if (sessData.Role) {
		    	Object.assign(kycPayload, {
		    		Role: sessData.Role
			    });
		    }
		    
		    if (sessData.ImageId) {
		    	Object.assign(kycPayload, {
		    		ImageId: sessData.ImageId
			    });
		    }
		    
		    if (sessData.PromoCode) {
		    	Object.assign(kycPayload, {
		    		PromoCode: sessData.PromoCode
			    });
		    }
		}
		
		const payload = {
    		kyc: kycPayload,
            Quotation: 1
        };
		
		payload.TokenLimiter = $('input[name="csrfToken"]').val();
		
		$.ajax({
			url: _setTransactionURL,
			type: "POST",
			dataType: "json",
			data: { data: JSON.stringify(payload), type: 'submit' },
			beforeSend: function() {
				$(_btn).html('<span class="modal_penawaran-agency__text-amber-300"> LOADING... </span>').attr('disabled', true);
			},
			success: function(response) {
    			document.querySelector(".modal_alert-body").innerHTML = response.Message;
                const modalContent = document.querySelector(".modal_alert-content");
            	const okButton = document.querySelector('.ispep_modal__inner-footer-btn');
                
                if (modalContent) {
                	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
                }
                
                openModalAlertBlocked();
            	
                if (response.Status) {
                	sessionStorage.clear();
                	
            		if (okButton) {
            			okButton.onclick = () => closeModalAlertBlocked(response.Data.target);
            		}
                } else {
                	$('input[name="csrfToken"]').val(response.Data.TokenLimiter);
                	if (typeof response.Blocked !== 'undefined' || typeof response.Pep !== 'undefined') {
                    	sessionStorage.clear();
                    	
                		if (okButton) {
                			okButton.onclick = () => closeModalAlertBlocked(response.Data.target);
                		}
                	}
                }
			},
			complete: function() {
				$(_btn).html('<span class="modal_penawaran-agency__text-amber-300"> KIRIM </span><i class="fas fa-arrow-right ml-2level"></i>').attr('disabled', false);
				quotationModal.hide();
			}
		});
	});	
	
	/* Validate function in main.js */
	$(document).on('input', '.container-form input', function(e) {
	    let fieldName = e.target.name;
	    let fieldType = 'text';

	    // Define specific field types
	    if (fieldName.includes('email')) {
	        fieldType = 'email';
	    } else if (fieldName.includes('identity-number')) {
	    	fieldType = dynamicType;
	    } else if (fieldName.includes('no-hp')) {
	    	fieldType = 'phone';
	    } else if (fieldName.includes('postal-code')) {
	        fieldType = 'num';
	    } else if (fieldName.includes('address')) {
	    	fieldType = 'addr';
	    }

	    if (!fieldName.includes('upload')) validateInput(e, fieldType);
	});


	const sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);
	if (sessionData) {
	  const data = JSON.parse(sessionData);
	  
	  let promoCode = data["PromoCode"];
  
	  if (promoCode) {
		  $('input[name="PromoCode"]').val(promoCode);
		  $('input[name="PromoCodeSidebar"]').val(promoCode);
	  }
	}
	
	$('#id-card-identity-no-hp').on('keydown', function(e) {
	    const pos = this.selectionStart;

	    // Prevent backspace/delete inside the prefix '+62'
	    if ((e.key === 'Backspace' && pos <= 3) || (e.key === 'Delete' && pos < 3)) {
	        e.preventDefault();
	        this.setSelectionRange(3, 3); // Keep cursor right after '+62'
	    }
	});

	$('#id-card-identity-no-hp').on('input', function () {
		let input = $(this).val();
		
		// Strip everything except digits
	    input = input.replace(/[^0-9]/g, '');

	    // Remove leading 0 or 62
	    if (input.startsWith("62")) {
	        input = input.substring(2);
	    } else if (input.startsWith("0")) {
	        input = input.substring(1);
	    }

	    // Limit to 12 digits after '+62'
	    input = input.substring(0, 12);

	    // Final formatted value
	    $(this).val("+62" + input);
	});
});

function initData() {
	let dto = { target: sessionDataDetail.Token, step: _step };
	if (sessionDataDetail.ImageId) dto.imageId = sessionDataDetail.ImageId;
	
	$.ajax({
        url: _getLeadsURL,
        type: "POST",
        data: dto,
		dataType: "json",
        success: function (response) {
        	if (response.Status) {
        		leads = response.Data.leads;
        	}
        },
        complete: function() {
        	setForm();
        }
	});
}

async function setForm() {
	moment.locale('id');
	
	let fields = $(".container-form [required]").toArray();
	
	for (let fieldElement of fields) {
		let field = $(fieldElement);
        let name = field.attr("name");
		
		if (field.is(":radio")) {
	        let value = name == 'radio-income' ? leads.monthlyIncome : name == 'gender' ? leads.gender : "";
	        if (value) $(`input[name="${name}"][value="${value}"]`).prop("checked", true);
		} else if (field.is("select")) {
			if (name == 'locations-and-activities' || name == 'source-of-premium-payments') {
				let value = name == 'locations-and-activities' ? leads.workLocation :
							name == 'source-of-premium-payments' ? leads.paymentSource : '';
				if (value) $(`select[name="${name}"]`).val(value).trigger('change');
			} else if (leads.province && name == 'regency') {
				let selected = selectByText('province', leads.province);
				
				await getCity(selected);
				
				$(`select[name="regency"]`).val('').trigger('change'); // Reset first
				setTimeout(() => {
					$(`select[name="regency"]`).val(leads.city).trigger('change');
				}, 3000);
			} else if (leads.job && name == 'employment') {
				selectByText('employment', leads.job);
			} else if (leads.nationality && name == 'citizenship') {
				selectByText('citizenship', leads.nationality);
			}
		} else if (field.is(":file")) {
			updateSess(_smartActiveFormDetailSess, "ImageId", leads.imageId);
			
			let file = {
				preview: leads.preview,
				name: leads.imgName
			};
			
			previewImg(file);
		} else {
			let value = name == 'id-card-identity-name' ? leads.name :
						name == 'id-card-identity-number' ? leads.idNumber :
						name == 'birth-date' ? moment(new Date(leads.birthDate)).format("DD/MMM/YYYY") :
						name == 'birth-place' ? leads.birthPlace :
						name == 'id-card-identity-no-hp' ? leads.phoneNumber :
						name == 'id-card-identity-email' ? leads.email :
						name == 'id-card-identity-postal-code' ? leads.zip :
						name == 'address' ? leads.address : '';
			if (value) $(`input[name="${name}"]`).val(value);
			if (name == 'birth-date' && value) {
				const startDate = moment(sessionDataDetail.PeriodeFrom, 'DD/MMM/YYYY', true);
	        	
	        	maxBirthDate = startDate.clone().subtract(30, 'days');
	    		minBirthDate = startDate.clone().subtract(75, 'years');
	    		
	        	$('#birth-date').data('daterangepicker').minDate = minBirthDate;
	        	$('#birth-date').data('daterangepicker').maxDate = maxBirthDate;
				
				$(`input[name="${name}"]`).data('daterangepicker').setStartDate(value);
				$(`input[name="${name}"]`).data('daterangepicker').setEndDate(value);
			}
		}
    }
	
	if (_quoteCategory && leads.paymentSource) {
		let value = leads.isPep == 1 ? "Y" : "N";
		$(`input[name="radio-pep"][value="${value}"]`).prop("checked", true);
	}
	
	if ($('.fileInput').is(":file")) {
		updateSess(_smartActiveFormDetailSess, "ImageId", leads.imageId);
		
		$('input[name="imgUrl"]').val(leads.preview);
		
		let file = {
			preview: leads.preview,
			name: leads.imgName
		};
		
		previewImg(file);
	}
	
	calculateAge($(`input[name="birth-date"]`).val());
	
	if (leads.additionalWorkLocation) $(`input[name="additional-locations"]`).val(leads.additionalWorkLocation);
	if (leads.additionalPaymentSource) $(`input[name="additional-payments"]`).val(leads.additionalPaymentSource);
	
	if (leads.beneficiary && leads.beneficiaryRelationship) {
		$(`input[name="beneficiary"]`).val(leads.beneficiary);
		$(`select[name="beneficiary-relationship"]`).val(leads.beneficiaryRelationship).trigger('change');
	}
	
	updateStickyPrice();
	updatePlanSummarySidebar();
	
	if (_quoteCategory == "edit") {
    	setTimeout(() => {
        	validateForm();
	    }, 500)
    }
}

function collectData() {
	let data = {};

	const isPep = getCheckedValue('input[name="radio-pep"]');
	if (isPep) data.IsPep = isPep == "Y" ? 1 : 0;
	
	const photoFileUrl = getValue('input[name="imgUrl"]');
	if (photoFileUrl) data.PhotoFileUrl = photoFileUrl;

	const name = getValue('input[name="id-card-identity-name"]');
	if (name) data.Name = name;

	const citizenship = getTitleOption('select[name="citizenship"]');
	if (citizenship) data.Citizenship = citizenship;
	
	const idNumber = getValue('input[name="id-card-identity-number"]');
	if (idNumber) data.IdNum = idNumber;
	
	const dob = getValue('input[name="birth-date"]');
	if (dob) data.Dob = dob;
	
	const age = getValue('input[name="age"]');
	if (age) data.Age = age;

	const pob = getValue('input[name="birth-place"]');
	if (pob) data.Pob = pob;

	const gender = getCheckedValue('input[name="gender"]');
	if (gender) data.Gender = gender;
	
	const phoneNumber = getValue('input[name="id-card-identity-no-hp"]');
	if (phoneNumber) data.PhoneNumber = phoneNumber;
	
	const email = getValue('input[name="id-card-identity-email"]');
	if (email) data.Email = email;
	
	const zip = getValue('input[name="id-card-identity-postal-code"]');
	if (zip) data.Zip = zip;
	
	const province = getTitleOption('select[name="province"]');
	if (province) data.Province = province;
	
	const city = getValue('select[name="regency"]');
	if (city) data.City = city;
	
	const address = getValue('input[name="address"]');
	if (address) data.Address = address;
	
	const job = getTitleOption('select[name="employment"]');
	if (job) data.Job = job;

	const workLocation = getValue('select[name="locations-and-activities"]');
	if (workLocation) data.WorkLocation = workLocation;

	const additionalWorkLocation = getValue('input[name="additional-locations"]');
	if (workLocation == 'Lainnya') data.AdditionalWorkLocation = additionalWorkLocation;

	const monthlyIncome = getCheckedText('input[name="radio-income"]');
	if (monthlyIncome) data.MonthlyIncome = monthlyIncome;

	const paymentSource = getValue('select[name="source-of-premium-payments"]');
	if (paymentSource) data.PaymentSource = paymentSource;

	const additionalPaymentSource = getValue('input[name="additional-payments"]');
	if (paymentSource == 'Lainnya') data.AdditionalPaymentSource = additionalPaymentSource;

	const beneficiary = getValue('input[name="beneficiary"]');
	if (beneficiary) data.Beneficiary = beneficiary;

	const beneficiaryRelationship = getValue('select[name="beneficiary-relationship"]');
	if (beneficiaryRelationship) data.BeneficiaryRelationship = beneficiaryRelationship;

    return data;
}

function calculateAge(param) {
	moment.locale('id');
	let birthDate = moment(param, 'DD/MMM/YYYY', true);
	let startDate = moment(sessionDataDetail.PeriodeFrom, 'DD/MMM/YYYY', true);

	ageInDays = startDate.diff(birthDate, 'days');
	ageInYears = startDate.diff(birthDate, 'years');
	
	let lastBirthday = birthDate.clone().year(startDate.year());
	if (startDate.isBefore(lastBirthday)) {
		lastBirthday.subtract(1, 'years');
	}

	// Calculate extra days since last birthday
	extraDays = startDate.diff(lastBirthday, 'days');
	
	$('#age').val(ageInYears);
	
	if ($('#age').val() > 0) {
		$('#age').attr('required', true);
	} else {
		$('#age').removeAttr('required');
	}
}

function selectByText(name, text) {
	let $option = $(`select[name="${name}"] option`).filter(function() {
        return $(this).text().trim().toLowerCase() === text.toLowerCase();
    });

    if ($option.length > 0) {
        let value = $option.val();
        $(`select[name="${name}"]`).val(value).trigger("change"); // Set the value properly
        return value; // Return the correct value
    }

    return null;
}

function selectByLikeText(name, text) {
	let $option = $(`select[name="${name}"] option`).filter(function() {
        return $(this).text().trim().toLowerCase().includes(text.toLowerCase());
    });

    if ($option.length > 0) {
        let value = $option.val();
        $(`select[name="${name}"]`).val(value).trigger("change"); // Set the value properly
        return value; // Return the correct value
    }

    return null;
}

async function getCity(param) {
	return new Promise((resolve, reject) => {
		$.ajax({
	        url: _getCitiesURL,
	        type: "POST",
	        data: { target: param },
			dataType: "json",
	        success: function (response) {
	        	if (response.Data.cities.length > 0) {
	        		let opt = '<option></option>';
	        		
	        		for (const item of response.Data.cities) {
	        			opt += `<option value="${item.name}">${item.name}</option>`;
	        		}
	        		
	        		$('#regency').empty().append(opt);
	            	$('#regency').attr('required', true);
	            	
		            resolve();
	        	}
	        },
	        complete: function() {
            	$('#regency').prop('disabled', false);
	        }
		});
	});
}

// CALCULATE PREMI
function calculatePremi() {
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
      },
      error: function (xhr, status, error) {
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

async function handleOCR(data) {
	if (typeof data.error === "string" && data.error.toLowerCase() == "quota exceeded") {
    	document.querySelector(".modal_alert-body").innerHTML = "Gambar berhasil diunggah";
        const modalContent = document.querySelector(".modal_alert-content");
        
        if (modalContent) {
        	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
        }
        
        openModalAlertBlocked();
		return;
    } else if (data.status.toLowerCase() !== "success") {
    	document.querySelector(".modal_alert-body").innerHTML = data.reason;
        const modalContent = document.querySelector(".modal_alert-content");
        
        if (modalContent) {
        	modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
        }
        
        openModalAlertBlocked();
        $('.fileInput').val('');
		return;
    }

	if (data.read.nama && data.read.nama.confidence > 70) {
		$('input[name="id-card-identity-name"]').val(data.read.nama.value);
    }
	
	if (data.read.nik && data.read.nik.confidence > 70) {
		$('input[name="id-card-identity-number"]').val(data.read.nik.value);
    }
	
	if (data.read.tanggalLahir && data.read.tanggalLahir.confidence > 70) {
		moment.locale("id");

	    let dateOcr = moment(data.read.tanggalLahir.value, 'DD-MM-YYYY', true);
	    let dateSes = moment(sessionDataDetail.Dob, 'DD/MMM/YYYY', true);

	    if (dateOcr.isValid() && dateSes.isValid()) {
	        const diffDays = dateOcr.diff(dateSes, 'days');

	        if (diffDays != 0) {
	            let value = dateOcr.format("DD/MMM/YYYY");
	            birthDateOcr = value;
	            $('input[name="birth-date"]').val(value);
	            calculateAge(value);
	        }
	    }
    }
	
	if (data.read.tempatLahir && data.read.tempatLahir.confidence > 70) {
		$('input[name="birth-place"]').val(data.read.tempatLahir.value);
    }
	
	if (data.read.jenisKelamin && data.read.jenisKelamin.confidence > 70) {
		const value = data.read.jenisKelamin.value === "LAKI-LAKI" ? "M" : "F";
		$(`input[name="gender"][value="${value}"]`).prop("checked", true);
    }
	
	if (data.read.provinsi && data.read.provinsi.confidence > 70) {
		let selected = selectByText('province', data.read.provinsi.value);
		
		if (data.read.kotaKabupaten && data.read.kotaKabupaten.confidence > 70) {
			await getCity(selected);
			
			$(`select[name="regency"]`).val('').trigger('change'); // Reset first
			setTimeout(() => {
				selectByLikeText('regency', data.read.kotaKabupaten.value);
			}, 3000);
		}
    }
	
	if (data.read.alamat && data.read.alamat.confidence > 70) {
		const rt = data.read.rtRw && data.read.rtRw.confidence > 70 ? ` RT ${data.read.rtRw.value.split('/')[0]}` : "";
		const rw = data.read.rtRw && data.read.rtRw.confidence > 70 ? ` RW ${data.read.rtRw.value.split('/')[1]}` : "";
		$('input[name="address"]').val(`${data.read.alamat.value}${rt}${rw}`);
    }
}