
// Ambil semua kode benefit dari data
var benefitCodes = [];

document.addEventListener('DOMContentLoaded', function() {

	const sessionData = sessionStorage.getItem(_smartActiveFormDetailSess);

    updateTanggalSaatIni();
    updateValueFiturUtama();

    
    var btnNext = document.querySelector('.btn__next');
    if (btnNext) {
        btnNext.classList.remove('btn--dark-grey');
        btnNext.classList.add('btn--dark-blue');
    }

    btnNext.addEventListener('click', function() {
        var radioYesChecked = document.querySelector('input[name="radio-polis"][value="Ya"]:checked');

        const checkboxes = [
            "checkbox-persetujuan-1",
            "checkbox-persetujuan-2"
            //,"checkbox-persetujuan-3"
        ];
        const allChecked = checkboxes.every(id => document.getElementById(id).checked);

        
        if (radioYesChecked === null || !allChecked ) {
        	document.querySelector(".modal_alert-body").innerHTML = 'Silakan Baca dan Setujui penjelasan RIPLAY sebelum melanjutkan.';
            const modalContent = document.querySelector(".modal_alert-content");
            const okButton = document.querySelector('.ispep_modal__inner-footer-btn');
            
            if (modalContent) {
                modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
            }
            
            openModalAlertBlocked();
            return;
        }
        
        
        if (radioYesChecked && allChecked) {
        	
            if (sessionData) {
                const data = JSON.parse(sessionData);

                //hit process
                process(data);
            }

        	
        }
    });


    if (sessionData) {
        const data = JSON.parse(sessionData);

        //update field yg dari session
        updateValueFiturUtama(data);
        
        //check leads api
        checkLeads(data);
        
    }
});


$(document).ready(function() {
	
	let calculation = JSON.parse(sessionStorage.getItem(_smartActiveCalculation));
	
	var dataBenefits = calculation;
	
//	var dataBenefits = {
//			  "Discount": 0,
//			  "ManagedBy": "",
//			  "PromoCode": "",
//			  "BusinessModel": "B2C",
//			  "StampDuty": 10000,
//			  "Commission": 0,
//			  "TaxValue": 0,
//			  "Premium": 121250,
//			  "Tax": 0,
//			  "Benefits": {
//			    "MainBenefit": [
//			      {
//			        "BenefitType": "Jaminan Utama",
//			        "BenefitList": [
//			          {
//			            "Premium": 36300,
//			            "MainBenefitValue": 50000000,
//			            "Code": "BN01",
//			            "Rate": 0.0726,
//			            "Name": "Kematian karena Kecelakaan (Jaminan A) / Cacat Tetap (Jaminan B)"
//			          }
//			        ]
//			      }
//			    ],
//			    "AdditionalBenefit": [
//			      {
//			        "BenefitType": "Santunan",
//			        "BenefitList": [
//			          {
//			            "Premium": 36300,
//			            "MainBenefitValue": 50000000,
//			            "Code": "BN02",
//			            "Rate": 0.0726,
//			            "Name": "Santunan Tunai Rumah Sakit akibat Kecelakaan"
//			          },
//			          {
//			            "Premium": 36300,
//			            "MainBenefitValue": 50000000,
//			            "Code": "BN03",
//			            "Rate": 0.0726,
//			            "Name": "Santunan Tunai Segera karena Meninggal Dunia"
//			          },
//			          {
//			            "Premium": 12350,
//			            "MainBenefitValue": 50000000,
//			            "Code": "BN07",
//			            "Rate": 0.0247,
//			            "Name": "Santunan Transportasi"
//			          }
//			        ]
//			      },
//			      {
//			        "BenefitType": "Jaminan Lainnya",
//			        "BenefitList": []
//			      }
//			    ]
//			  },
//			  "DiscountAmount": 0,
//			  "NettPremium": 156250,
//			  "Currency": "IDR",
//			  "PolicyCost": 25000,
//			  "CommissionValue": 0,
//			  "Detail": {
//			    "StartDate": "",
//			    "SumInsured": 50000000,
//			    "ToproCode": "",
//			    "OccupationCode": "A31",
//			    "ExpiredDate": "",
//			    "TocCode": "",
//			    "OccupationClass": 2
//			  },
//			  "NetPremium": 156250
//			};
	
	
	//benefit fitur utama dan simulasi
	renderBenefits(dataBenefits);
	
	//table lampiran 1
	renderBenefitsTable(dataBenefits);
	
	//value summary premi
	updateValuePremi(dataBenefits);
	
	
	/**
	 * PUSH BENEFIT CODE
	 * @param data
	 * @returns
	 */
	
	// Cek apakah Benefits ada
	if (dataBenefits.Benefits) {
	    
	    // Cek apakah MainBenefit ada dan berupa array sebelum menggunakan forEach
	    if (Array.isArray(dataBenefits.Benefits.MainBenefit)) {
	        dataBenefits.Benefits.MainBenefit.forEach(category => {
	            if (Array.isArray(category.BenefitList)) {
	                category.BenefitList.forEach(benefit => {
	                    benefitCodes.push(benefit.Code);
	                });
	            }
	        });
	    }

	    // Cek apakah AdditionalBenefit ada dan berupa array sebelum menggunakan forEach
	    if (Array.isArray(dataBenefits.Benefits.AdditionalBenefit)) {
	        dataBenefits.Benefits.AdditionalBenefit.forEach(category => {
	            if (Array.isArray(category.BenefitList)) {
	                category.BenefitList.forEach(benefit => {
	                    benefitCodes.push(benefit.Code);
	                });
	            }
	        });
	    }
	}
	
	//console.log('code additional >> ', benefitCodes);
	
	//show manfaat sesuai kode
	document.querySelectorAll('[id^="BN"]').forEach(element => {
	    if (!benefitCodes.includes(element.id)) {
	        // Jika ID elemen tidak ada dalam benefitCodes, sembunyikan
	        element.style.display = "none";
	    }
	});
	
	
	/**
	 * UNTUK URUTKAN NOMOR MANFAAT
	 */
	// Ambil semua elemen yang sesuai dengan id "BN" yang tidak memiliki display: none
	const visibleBenefits = Array.from(document.querySelectorAll('.pasal4 [id^="BN"]'))
	    .filter(element => element.style.display !== "none");

	let no = 1
	visibleBenefits.forEach((element) => {
	    const numberElement = element.querySelector('.no-benefit b');
	    if (numberElement) {
	        numberElement.textContent = `${no}.`;
	        no++;
	    }
	});
	
	
	//call sidebar
	updatePlanSummarySidebar();
	
	
});


function updateValuePremi(data){
	
	 /**
     * BIAYA PREMI SIMULASI
     */

    	// Pastikan nilai dalam format angka
    	var policyCost = parseFloat(data.PolicyCost);
    	var stampDuty = parseFloat(data.StampDuty);
    	
    	var grossPremi = parseFloat(data.Premium);
    	
    	//var grossPremi = parseFloat('1087575'); //mainonly = 29025 / additional = 1087575
    	
    	var curr = data.Currency;
    	

    	// Hitung total biaya
    	var totalCost1 = grossPremi + stampDuty;
    	
    	var totalCostAll = grossPremi + stampDuty + policyCost;
    	
    	
    	if (data.PolicyCost === '0' || parseFloat(data.PolicyCost) === 0) {
    	    document.querySelectorAll('.div_biaya_polis').forEach(function(div) {
    	        div.style.display = 'none';
    	    });
    	}
    	
    	
    	// Update elemen .biaya_polis
    	document.querySelectorAll('.biaya_polis').forEach(function(element) {
    	    element.textContent = `${curr} ${policyCost.toLocaleString("id-ID")}`;
    	});

    	// Update elemen .biaya_materai
    	document.querySelectorAll('.biaya_materai').forEach(function(element) {
    	    element.textContent = `${curr} ${stampDuty.toLocaleString("id-ID")}`;
    	});

    	// Update elemen .total_1
    	document.querySelectorAll('.total_1').forEach(function(element) {
    	    element.textContent = `${curr} ${totalCost1.toLocaleString("id-ID")}`;
    	});
    	

        // Update elemen .gross_premium
        var grossPremiumElements = document.querySelectorAll('.gross_premium');
        grossPremiumElements.forEach(function(element) {
            element.textContent = `${curr} ${grossPremi.toLocaleString("id-ID")}`;
        });


        // Update elemen .total_biaya
        var totalBiayaElements = document.querySelectorAll('.total_biaya');
        totalBiayaElements.forEach(function(element) {
            element.textContent = `${curr} ${totalCostAll.toLocaleString("id-ID")}`;
        });

        
    
    if(data.Detail.OccupationClass) {
    	var classCategory = data.Detail.OccupationClass;
    	document.querySelectorAll('.class_job').forEach(function(element) {
    	    element.textContent = `Kategori ${classCategory}`;
    	});
    	
    }
    
    if(data.Currency) {
    	var curr = data.Currency;
    	document.querySelectorAll('.currency').forEach(function(element) {
    	    element.textContent = `${curr}`;
    	});
    	
    }
	
}


function updateValueFiturUtama(formData) {

    //console.log('Data session -> ', formData);

    // Cek jika data ada
    if (formData) {

        // Data dari session
        var startDateSession = formData.PeriodeFrom;
        var expiredDateSession = formData.PeriodeTo;

        // Konversi tanggal sesi ke objek Date
        var periodeMulai = parseTanggal(startDateSession);
        var periodeAkhir = parseTanggal(expiredDateSession);


        // Format tanggal menjadi "dd MMMM yyyy"
        var periodeMulaiFormat = `${periodeMulai.getDate()} ${bulanMapping[startDateSession.split("/")[1]]} ${periodeMulai.getFullYear()}`;
        var periodeAkhirFormat = `${periodeAkhir.getDate()} ${bulanMapping[expiredDateSession.split("/")[1]]} ${periodeAkhir.getFullYear()}`;

        // Update elemen dengan class .periode_mulai dan .periode_akhir
        document.querySelectorAll('.periode_mulai').forEach(el => el.textContent = periodeMulaiFormat);
        document.querySelectorAll('.periode_akhir').forEach(el => el.textContent = periodeAkhirFormat);

        // Hitung selisih hari
        var diffTime = Math.abs(periodeAkhir - periodeMulai);
        var diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)) + 1; // startdate hitung 1

        // Konversi ke tahun + hari jika lebih dari 365 hari
        var totalHariText = diffDays > 365 ?
            `${Math.floor(diffDays / 365)} tahun` :
            `${diffDays} hari`;

        // Update elemen dengan class .total_hari
        document.querySelectorAll('.total_hari').forEach(el => el.textContent = totalHariText);
        
        

    }
}

function generateTanggalSaatIni(includeTanggalPrefix = true) {
    var now = new Date();
    var namaBulan = [
        "Januari",
        "Februari",
        "Maret",
        "April",
        "Mei",
        "Juni",
        "Juli",
        "Agustus",
        "September",
        "Oktober",
        "November",
        "Desember"
    ];
    var jam = String(now.getHours()).padStart(2, "0");
    var menit = String(now.getMinutes()).padStart(2, "0");
    var tanggalText = `${now.getDate()} ${namaBulan[now.getMonth()]} ${now.getFullYear()} pukul ${jam}.${menit}`;

    return includeTanggalPrefix ? `tanggal ${tanggalText}` : tanggalText;
}

function updateTanggalSaatIni() {
    var thisTime = document.getElementById("thisTime");

    if (thisTime) {
        thisTime.textContent = generateTanggalSaatIni(false);
    }
}

function updateMainValue(dataLeads) {

    //console.log('Data leads -> ', dataLeads);

    if (dataLeads.PolicyName || dataLeads.BeneficiaryName) {
        const title = dataLeads.Gender === "F" ? "Nyonya" : "Tuan";

        const policyName = dataLeads.PolicyName ? `${title} ${dataLeads.PolicyName}` : "Tuan A";
        const beneficiaryName = dataLeads.BeneficiaryName ? `${title} ${dataLeads.BeneficiaryName}` : " - ";

        document.querySelectorAll('.tuan_A').forEach(el => el.textContent = policyName);
        document.querySelectorAll('.tuan_B').forEach(el => el.textContent = beneficiaryName);
    }

    // Menghitung umur dari DOB
    var usia = document.querySelectorAll('.usia');
    if (dataLeads.Dob) {

        var birthDate = dataLeads.Dob;
        var usiaText = hitungUsiaDalamTahun(birthDate);

        usia.forEach(el => el.textContent = usiaText);

    } else {
        usia.forEach(function(element) {
            element.textContent = '0 tahun';
        });
    }


    // Update elemen .pekerjaan
    var pekerjaanElements = document.querySelectorAll('.job');
    pekerjaanElements.forEach(function(element) {
        //element.textContent = `${dataLeads.JobTitle}`;
        element.textContent = dataLeads.JobTitle ?? " - ";
    });
        
    
    // Update elemen dengan class .country
    var country = dataLeads.Nationality === 'WNI' 
    	  ? 'Indonesia' 
    	  : dataLeads.Nationality === 'WNA' 
    	    ? 'Asing' 
    	    : dataLeads.Nationality;

    document.querySelectorAll('.country').forEach(el => el.textContent = country);


}

/**
 * 
 * @param tanggalStr tanggal indo misal 12/Feb/2025, 20/Mei/2025
 * @returns
 */
function parseTanggal(tanggalStr) {
    var parts = tanggalStr.split("/"); // Pisahkan dd/MMM/yyyy
    var day = parseInt(parts[0], 10);
    var month = bulanMapping[parts[1]] ? Object.keys(bulanMapping).indexOf(parts[1]) : Object.values(bulanMapping).indexOf(parts[1]);
    var year = parseInt(parts[2], 10);
    return new Date(year, month, day);
}

//====== Tambahan: Hitung Usia dalam Tahun ======
function hitungUsiaDalamTahun(tanggalLahirStr) {
    var today = new Date();
    var tanggalLahir = new Date(tanggalLahirStr); // Konversi string ke Date

    if (isNaN(tanggalLahir)) {
        return "Format tanggal tidak valid";
    }

    var birthYear = tanggalLahir.getFullYear();
    var usiaTahun = today.getFullYear() - birthYear;

    // Jika ulang tahun belum terjadi tahun ini, kurangi 1 tahun
    var ulangTahunBelumTerjadi = (today.getMonth() < tanggalLahir.getMonth()) ||
        (today.getMonth() === tanggalLahir.getMonth() && today.getDate() < tanggalLahir.getDate());

    if (ulangTahunBelumTerjadi) {
        usiaTahun--;
    }

    return `${usiaTahun} tahun`;
}


function renderBenefits(data) {
	
	//console.log('render benefit...');
	
	var curr = data.Currency;
	
	//main benefit
    document.querySelectorAll(".main_benefit_simulasi_cover").forEach(mainBenefitContainer => {
        const parentContainer = mainBenefitContainer.closest(".uang_pertanggungan, .rate_pertanggungan");
        const isRatePertanggungan = parentContainer?.classList.contains("rate_pertanggungan");

        mainBenefitContainer.innerHTML = "";

        if (data.Benefits.MainBenefit.length > 0) {
            let mainBenefits = data.Benefits.MainBenefit[0].BenefitList.map(benefit => benefit.Name).join(" dan ");
            let value = isRatePertanggungan 
                ? `${data.Benefits.MainBenefit[0].BenefitList[0].Rate.toFixed(4)} %` 
                : `${curr} ${data.Benefits.MainBenefit[0].BenefitList[0].LimitBenefitValue.toLocaleString("id-ID")}`;

            mainBenefitContainer.innerHTML = `
                <span style="flex: 1;">
                    <span class="name_benefit">${mainBenefits} :</span>
                    <span class="${isRatePertanggungan ? 'rate_benefit' : 'value_benefit'}">${value}</span>
                </span>
            `;
        }
    });

    //additional / perluasan
    document.querySelectorAll(".allowance_benefit_simulasi_cover, .other_benefit_simulasi_cover").forEach(benefitContainer => {
        const parentContainer = benefitContainer.closest(".uang_pertanggungan, .rate_pertanggungan");
        const isRatePertanggungan = parentContainer?.classList.contains("rate_pertanggungan");

        benefitContainer.innerHTML = "";

        data.Benefits.AdditionalBenefit.forEach(category => {
            let targetContainer = category.BenefitType.toLowerCase().includes("santunan".toLowerCase()) 
            ? ".allowance_benefit_simulasi_cover" 
            : ".other_benefit_simulasi_cover";

            
            if (!benefitContainer.matches(targetContainer)) return;

            category.BenefitList.forEach(benefit => {
                let value = isRatePertanggungan 
                    ? `${benefit.Rate.toFixed(4)} %` 
                    : `${curr} ${benefit.LimitBenefitValue.toLocaleString("id-ID")}`;

                let benefitHTML = `
                    <div style="display: flex; align-items: flex-start; gap: 10px; margin-bottom: 5px;">
                        <span style="flex-shrink: 0;">•</span>
                        <span style="flex: 1;">
                            <span class="name_benefit">${benefit.Name} :</span>
                            <span class="${isRatePertanggungan ? 'rate_benefit' : 'value_benefit'}">${value}</span>
                        </span>
                    </div>
                `;

                benefitContainer.innerHTML += benefitHTML;
            });
        });
    });
    
    //hapus title jika tidak perlu
    /**
     * param object array additional benefit
     */
    checkAndRemoveBenefitElements(data.Benefits.AdditionalBenefit);
    
}


function renderBenefitsTable(data) {
	
	//console.log('render benefits table...');
	
    const mainBenefitContainer = document.querySelector(".main_benefit");
    const allowanceBenefitContainer = document.querySelector(".allowance_benefit");
    const otherBenefitContainer = document.querySelector(".other_benefit");

    mainBenefitContainer.innerHTML = "";
    allowanceBenefitContainer.innerHTML = "";
    otherBenefitContainer.innerHTML = "";

    // Render Main Benefit, Gabungkan semua Main Benefit dalam satu baris
    if (data.Benefits.MainBenefit.length > 0) {
        const mainBenefitNames = data.Benefits.MainBenefit[0].BenefitList.map(benefit => benefit.Name).join(" / ");
        
        let mainBenefitNamesEnArray = data.Benefits.MainBenefit[0].BenefitList.map(benefit => benefit.NameEn ? benefit.NameEn : "").filter(name => name !== "");
        let mainBenefitNamesEn = mainBenefitNamesEnArray.length > 0 ? mainBenefitNamesEnArray.join(" / ") : "";
        
        const mainBenefitValue = data.Benefits.MainBenefit[0].BenefitList[0].LimitBenefitValue; // Ambil nilai pertama saja

        mainBenefitContainer.insertAdjacentHTML("beforebegin", `
            <tr>
                <td style="border: 1px solid #ddd; padding: 4px; text-align: center;">1</td>
                <td style="border: 1px solid #ddd; padding: 4px;">
                    <span class="nameId">
                    	<b>${mainBenefitNames}</b>
	                    <br>
	                    <i>${mainBenefitNamesEn}</i>
                    </span>
                </td>
                <td style="border: 1px solid #ddd; padding: 4px; font-weight: bold; text-align: left; vertical-align: top;">
                    ${mainBenefitValue.toLocaleString("id-ID")}
                </td>
            </tr>
        `);
    }

    // Render Additional Benefits (Allowance & Other)
    data.Benefits.AdditionalBenefit.forEach(category => {
        
        let targetContainer = category.BenefitType.toLowerCase().includes("santunan".toLowerCase()) 
        ? allowanceBenefitContainer 
        : otherBenefitContainer;

        category.BenefitList.forEach((benefit, index) => {
        	
        	let benefitNameEn = benefit.NameEn ? benefit.NameEn : "";
        	
            targetContainer.insertAdjacentHTML("beforebegin", `
                <tr>
                    <td style="border: 1px solid #ddd; padding: 4px; text-align: center;">${index + 1}</td>
                    <td style="border: 1px solid #ddd; padding: 4px;">
                        <span class="nameId">
	                        <b>${benefit.Name}</b>
	                        <br>
	                        <i>${benefitNameEn}</i>
                        </span>
                    </td>
                    <td style="border: 1px solid #ddd; padding: 4px; font-weight: bold; text-align: left; vertical-align: top;">
                        ${benefit.LimitBenefitValue.toLocaleString("id-ID")}
                    </td>
                </tr>
            `);
        });
    });
    
    
    /**
     * param object array additional benefit
     */
    checkAndRemoveBenefitElements(data.Benefits.AdditionalBenefit);
}


function checkAndRemoveBenefitElements(additionalBenefits) {
    const hasSantunan = additionalBenefits.some(benefit => 
        benefit.BenefitType && 
        benefit.BenefitType.toLowerCase() === "santunan" &&
        benefit.BenefitList.length > 0
    );
    const hasJaminanLainnya = additionalBenefits.some(benefit => 
        benefit.BenefitType && 
        benefit.BenefitType.toLowerCase() === "jaminan lainnya" &&
        benefit.BenefitList.length > 0
    );

    if (!hasSantunan) {
        document.querySelectorAll('.allowance').forEach(el => el.remove());
    }

    if (!hasJaminanLainnya) {
        //document.querySelectorAll('.other').forEach(el => el.remove());
        document.querySelectorAll('.other').forEach(el => {
            if (!['BODY', 'HTML', 'HEAD'].includes(el.tagName)) {
                el.style.display = "none";
            }
        });
    }
    
    if (!hasSantunan && !hasJaminanLainnya) {
        document.querySelectorAll('.perluasan, .pasal4').forEach(el => el.remove());
    }
}



function checkLeads(sessionData) {

    let token = sessionData.Token;

    //console.log('Hit checkLeads >> Try check data in step1 with token >> ' + token);

    $.ajax({
        url: _apiURL + `/o/api/sa/check/leads?t=${token}`,
        type: "GET",
        success: function(response) {

            if (response.status) {
                //console.log('response.data >> ', response.data);

                const dataLeads = response.data;

                //update value
                updateMainValue(dataLeads);

            }

        },
        error: function() {
            //console.error("Gagal mengambil informasi tambahan.");
        }
    });
}



function process(sessionData) {
	
	const payload = {
		ExcludedActivityStatus: sessionData.ExcludedActivityStatus,
		Job: sessionData.Occupation,
		PeriodeFrom: sessionData.PeriodeFrom,
		PeriodeTo: sessionData.PeriodeTo,
		MainBenefitValue: sessionData.MainBenefitValue,
		AdditionalBenefits: sessionData.AdditionalBenefits,
        Token: sessionData.Token,
        TokenLimiter: $('input[name="csrfToken"]').val()
    };
	
	if (sessionData.BusinessModel) payload.BusinessModel = sessionData.BusinessModel;
	if (sessionData.ManagedBy) payload.ManagedBy = sessionData.ManagedBy;
    if (sessionData.ManagedById) payload.ManagedById = sessionData.ManagedById;
    if (sessionData.Role) payload.Role = sessionData.Role;
    if (sessionData.LeadsTemp) payload.LeadsTemp = sessionData.LeadsTemp;
    if (sessionData.PromoCode) payload.PromoCode = sessionData.PromoCode;
	
    //console.log('hit process with token>>', token);

    $.ajax({
    	url: _setTransactionURL,
    	type: "POST",
    	dataType: "json",
    	data: { data: JSON.stringify(payload), type: 'process' },
        beforeSend: function () {
        	displayLoading();
        },
        success: function(response) {
        	if (response.Data && response.Data.TokenLimiter) {
        		$('input[name="csrfToken"]').val(response.Data.TokenLimiter);
        	}
        	
            if (!response.Status) {
            	hideLoading();
            	document.querySelector(".modal_alert-body").innerHTML = response.Message;
                const modalContent = document.querySelector(".modal_alert-content");
                const okButton = document.querySelector('.ispep_modal__inner-footer-btn');
                
                if (modalContent) {
                    modalContent.style.width = (typeof mobile === 'boolean') ? "90%" : "40%";
                }
                
                openModalAlertBlocked();
                return;
            }
            
            sessionStorage.clear();
            
            //redirect
            window.parent.location.href = response.RedirectTarget;

        },
        error: function() {
            //console.error("Gagal mengambil informasi tambahan.");
        },
		complete: function() {
			hideLoading();
		}
    });
}
