var restApiProcessUrl = window.restApiProcessUrl;

function proccessPayment() {
  // Cari semua elemen input dengan ID yang ditentukan
  //	  const requiredCheckboxes = [
  //	    document.getElementById('edit-1'),
  //	    document.getElementById('edit-2'),
  //	    document.getElementById('edit-3'),
  //	    document.getElementById('edit-4')
  //	  ];
  //
  //	  const allChecked = requiredCheckboxes.every(checkbox => checkbox && checkbox.checked);
  //
  //	  if (!allChecked) {
  //
  //	        document.querySelector('.content-message-popup-ispep').textContent = 'Silakan Baca dan Setujui penjelasan RIPLAY sebelum melanjutkan.';
  //        	//open modal
  //            document.getElementById('ispepModal').classList.add('is-open');
  //
  //	    return;
  //	  }

  // Mendapatkan elemen radio button
  const yesAgree = document.getElementById("yes-agree");
  if (yesAgree.checked) {
    // Jika "Ya" dipilih, lanjutkan ke proses pembayaran
    //console.log("Lanjut ke pembayaran");
  } else {
    document.querySelector(".content-message-popup-ispep").textContent =
      "Silakan Baca dan Setujui penjelasan RIPLAY sebelum melanjutkan.";
    //open modal
    document.getElementById("ispepModal").classList.add("is-open");

    //alert("Silakan baca dan setujui penjelasan RIPLAY terlebih dahulu.");
    return;
  }

  // Retrieve data from sessionStorage
  let formDetail = sessionStorage.getItem("SmartTravelInternationalFormDetail");
  let _Token = null;
  let _AdditionalBenefit = null;
  let _QuoteId = "";
  let _mbid = "";

  if (formDetail) {
    let formDetailObject = JSON.parse(formDetail);

    _Token = formDetailObject.Token;

    if (formDetailObject.QuoteId) {
      _QuoteId = formDetailObject.QuoteId;
    }

    if (
      formDetailObject.AdditionalBenefits &&
      formDetailObject.AdditionalBenefits.length > 0
    ) {
      _AdditionalBenefit = formDetailObject.AdditionalBenefits;
    } else {
      //console.log("Additional Benefits tidak tersedia atau kosong.");
    }

    if (formDetailObject.ManagedById) {
      _mbid = formDetailObject.ManagedById;
    }
  } else {
    //console.log("Data SmartTravelInternationalFormDetail tidak ditemukan di sessionStorage.");
  }

  // Combine the data into a single payload object
  let existingSession = {
    Token: _Token,
    AdditionalBenefit: _AdditionalBenefit,
    type: "payment",
    QuouteId: _QuoteId,
    mbid: _mbid,
  };

  // Make the AJAX request
  $.ajax({
    url: restApiProcessUrl,
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(existingSession), // Convert the payload to a JSON string
    beforeSend: function () {
      $(".btn_riplay").css({
        "pointer-events": "none",
        opacity: "0.5",
        cursor: "not-allowed",
      });

      $("#btn-text").html('Loading <i class="custom-spinner"></i>');
    },
    success: function (response) {
      console.log(response);
      //console.log('response>>', response);
      console.log(typeof response.Status);
      if (response.Status === 1 || response.Status === "1") {
        //remove all session before redirect to pimcore payment
        sessionStorage.clear(); //makesure dont back after payment page

        //by key example
        //sessionStorage.removeItem("SmartTravelInternationalDataPayload");

        //redirect
        window.parent.location.href = response.RedirectTarget;
      } else {
        document.querySelector(".content-message-popup-ispep").innerHTML =
          !response.Message || response.Message === ""
            ? "Terjadi Kesalahan Request [PRCRPL01]"
            : response.Message;

        //open modal
        document.getElementById("ispepModal").classList.add("is-open");
      }
    },
    error: function (xhr, status, error) {
      console.error("Error:", error);
    },
    complete: function () {
      //console.log("AJAX complete executed."); // Debug log
      $(".btn_riplay").css({
        "pointer-events": "",
        opacity: "",
        cursor: "",
      });

      $("#btn-text").html(
        'Lanjut Ke Pembayaran <i class="fas fa-arrow-right"></i>'
      );
    },
  });
}

//get main benefit premi
var totalMainBenefitPremium, totalMainBenefitPremiumInIDR;
var totalAdditionalBenefitPremium, totalAdditionalBenefitPremiumInIDR;

var listAdditionalBenefit = null;
var jaminanList = null;
var _dataMainBenefit = null;
var _dataMainBenefitDesc = null;

const calculation = JSON.parse(
  sessionStorage.getItem("SmartTravelInternationalCalculation")
);

if (sessionStorage.getItem(_smartTravelInternationalCalculation)) {
  let formDetail = JSON.parse(
    sessionStorage.getItem(_smartTravelInternationalFormDetailSess)
  );
  let choosenPlan = formDetail.ChoosenPlan;

  let calculation = JSON.parse(
    sessionStorage.getItem(_smartTravelInternationalCalculation)
  );

  for (const plan of calculation.AvailablePlans) {
    if (plan.PlanName === choosenPlan) {
      //get main total
      totalMainBenefitPremium = plan.TotalMainBenefitPremium;
      totalMainBenefitPremiumInIDR = plan.TotalMainBenefitPremiumInIDR;

      //get additional total
      totalAdditionalBenefitPremium = plan.TotalAdditionalBenefitPremium;
      totalAdditionalBenefitPremiumInIDR =
        plan.TotalAdditionalBenefitPremiumInIDR;

      listAdditionalBenefit = plan.AdditionalBenefitList;

      //console.log(totalMainBenefitPremium);
      //console.log(totalMainBenefitPremiumInIDR);

      //console.log(totalAdditionalBenefitPremium);
      //console.log(totalAdditionalBenefitPremiumInIDR);

      //console.log(listAdditionalBenefit);
      //console.log(transformJson(listAdditionalBenefit));

      //for additional benefit
      jaminanList = transformJson(listAdditionalBenefit);
      //console.log('final json need>>', jaminanList);

      //for main benefit
      _dataMainBenefit = plan.MainBenefitList;
      _dataMainBenefitDesc = plan.MainBenefitListDesc;

      //console.log(_dataMainBenefit);
    }
  }
}

var _adultTotal,
  _arrivalDate,
  _choosenPlan,
  _currency,
  _departureDate,
  _policyCost,
  _stamp,
  _totalDays,
  _travelType,
  _travellerType;

//Mendapatkan data dari sessionStorage
const formDetail = JSON.parse(sessionStorage.getItem("SmartTravelInternationalFormDetail"));
if(formDetail) {
    _adultTotal = formDetail.AdultTotal;
    _arrivalDate = formDetail.ArrivalDate;
    _choosenPlan = formDetail.ChoosenPlan;
    _currency = formDetail.Currency;
    _departureDate = formDetail.DepartureDate;
    //_policyCost = formDetail.PolicyCost;
    //_stamp = formDetail.Stamp;
    //_totalDays = formDetail.TotalDays;
    _travelType = formDetail.TravelType;
    _travellerType = formDetail.TravellerType;
    
    let promoCode = formDetail["PromoCode"];
    
    if (promoCode) {
        $('input[name="PromoCodeSidebar"]').val(promoCode);
    }

    // Console logs
    //console.log("Adult Total:", _adultTotal);
    //console.log("Arrival Date:", _arrivalDate);
    //console.log("Choosen Plan:", _choosenPlan);
    //console.log("Currency:", _currency);
    //console.log("Departure Date:", _departureDate);
    //console.log("Policy Cost:", _policyCost);
    //console.log("Stamp:", _stamp);
    //console.log("Total Days:", _totalDays);
    //console.log("Travel Type:", _travelType);
    //console.log("Traveller Type:", _travellerType);
    
    //render sideplan
    
    //let totalPremiJaminan = totalMainBenefitPremium + totalAdditionalBenefitPremium;
    
    
    // update plan summary yang ada di sidebar
    //updatePlanSummarySidebar();
    
} else {
  console.error(
    "Data 'SmartTravelInternationalFormDetail' tidak ditemukan di sessionStorage."
  );
}

//get data payload
var _namePolicyHolder,
  _agePolicyHolder,
  _addressPolicyHolder,
  _genderPolicyHolder,
  _ageSpouse,
  _genderSpouse;

const dataPayload = JSON.parse(
  sessionStorage.getItem("SmartTravelInternationalDataPayload")
);

if (dataPayload) {
  const pasanganObject = dataPayload.insured.find(function (item) {
    return item._relationship === "Pasangan";
  });

  const anakObjects = dataPayload.insured.filter(function (item) {
    return (
      item._relationship === "Anak" || item._relationship === "Anak / Pelajar"
    );
  });

  const jumlahAnak = anakObjects.length;

  // Extract policyholder details
  _namePolicyHolder = dataPayload.policyholder._name;
  _agePolicyHolder = dataPayload.policyholder._age;
  _addressPolicyHolder = dataPayload.policyholder._alamat;
  _genderPolicyHolder = dataPayload.policyholder._gender;

  // Extract spouse details if available
  if (pasanganObject) {
    _ageSpouse = pasanganObject._age;
    _genderSpouse = pasanganObject._gender;
  } else {
    _ageSpouse = null;
    _genderSpouse = null;
  }

  // Collect all ages for min and max calculation
  const ages = [dataPayload.policyholder._age]; // Start with the policyholder's age

  if (pasanganObject) {
    ages.push(pasanganObject._age); // Add spouse's age if available
  }

  if (anakObjects) {
    anakObjects.forEach(function (child) {
      ages.push(child._age); // Add ages of children
    });
  }

  // Find the minimum and maximum ages
  const minAge = Math.min(...ages);
  const maxAge = Math.max(...ages);

  // Helper function to format ages with "dan"
  function formatAges(ages) {
    if (ages.length === 1) {
      return ages[0];
    }
    const lastAge = ages.pop();
    return ages.join(", ") + " dan " + lastAge;
  }

  // .member
  document.querySelectorAll(".member").forEach(function (element) {
    if (pasanganObject && jumlahAnak > 0) {
      element.textContent =
        "dan pasangannya serta " + jumlahAnak + " orang anaknya";
    } else if (pasanganObject) {
      element.textContent = "dan pasangannya";
    } else if (jumlahAnak > 0) {
      element.textContent = "dan " + jumlahAnak + " orang anaknya";
    } else {
      element.remove(); // Remove the element if there is no spouse or children
    }
  });

  // .member_with_age
  document.querySelectorAll(".member_with_age").forEach(function (element) {

    const masingMasingText = jumlahAnak > 1 ? " masing-masing" : "";

    if (pasanganObject && jumlahAnak > 0) {
      const agesOfChildren = anakObjects.map(function (child) {
        return child._age + " tahun";
      });
      const formattedAges = formatAges(agesOfChildren);

      element.textContent =
        "dan pasangannya berusia " +
        _ageSpouse +
        " tahun serta " +
        jumlahAnak +
        " orang anaknya " +
        masingMasingText +
        " berusia " +
        formattedAges;
    } else if (pasanganObject) {
      element.textContent = "dan pasangannya berusia " + _ageSpouse + " tahun";
    } else if (jumlahAnak > 0) {
      const agesOfChildren = anakObjects.map(function (child) {
        return child._age + " tahun";
      });
      const formattedAges = formatAges(agesOfChildren);

      element.textContent =
        "dan " +
        jumlahAnak +
        " orang anaknya" +
        masingMasingText +
        " berusia " +
        formattedAges;
    } else {
      element.remove(); // Remove the element if there is no spouse or children
    }
  });

  // .member_umum
  document.querySelectorAll(".member_umum").forEach(function (element) {
    let anakWording = "";
    if (jumlahAnak === 1) {
      anakWording = "anaknya";
    } else if (jumlahAnak > 1) {
      anakWording = "anak-anaknya";
    }

    let wording = "berkisar " + minAge + " s/d " + maxAge + " tahun";
    if (pasanganObject && jumlahAnak > 0) {
      wording = "dan pasangan serta " + anakWording + " adalah " + wording;
    } else if (pasanganObject) {
      wording = "dan pasangannya adalah " + wording;
    } else if (jumlahAnak > 0) {
      wording = "dan " + anakWording + " adalah " + wording;
    }

    element.textContent = wording;
  });
} else {
  console.error("Data 'SmartTravelInternationalDataPayload' tidak ditemukan di sessionStorage.");
}

function transformJson(data) {
  const groupedData = {};

  data.forEach((item) => {
    const {
      "Benefit Name": benefitName,
      "Benefit Type": benefitType,
      BenefitValueIDR,
      BenefitValueUSD,
    } = item;

    const selectedValue =
      calculation.Currency === "IDR" ? BenefitValueIDR : BenefitValueUSD;

    if (!groupedData[benefitType]) {
      groupedData[benefitType] = [];
    }

    groupedData[benefitType].push({
      name: benefitName,
      value: selectedValue,
    });
  });

  const result = Object.keys(groupedData).map((benefitType) => ({
    title: benefitType,
    items: groupedData[benefitType],
  }));

  return result;
}

var allItems = [];
const jaminanArray = jaminanList; //JSON.parse(jaminanList);

function updateDataByClass() {
  $(".nama").each(function () {
    let namePrefix = _genderPolicyHolder === "F" ? "Nyonya" : "Tuan";
    $(this).text(namePrefix + " " + capitalizeFirstLetter(_namePolicyHolder));
  });

  $(".tempat").each(function () {
    //$(this).text(capitalizeFirstLetter(_destionation));
    $(this).text(capitalizeFirstLetter("Worldwide"));
  });

  // Memformat tanggal dan memperbarui elemen
  $(".waktu").each(function () {
    $(this).text(
      formatDate(_departureDate) + " s/d " + formatDate(_arrivalDate)
    );
  });

  // Update plan
  $(".plan").each(function () {
    $(this).text(capitalizeFirstLetter(_choosenPlan));
  });

  // Update currency
  $(".currency").each(function () {
    $(this).text(_currency.toUpperCase());
  });

  //update currency
  $(".currency_name").each(function () {
    if (_currency.toUpperCase() === "IDR") {
      $(this).text("Rupiah");
    } else {
      $(this).text("US Dollar");
    }
  });

  // Update usia
  $(".age").each(function () {
    $(this).text(_agePolicyHolder);
  });

  // Update usia pasangan
  /* $(".age_spouse").each(function() {
		$(this).text(_ageSpouse);
	}); */

  // Update total hari
  $(".total_hari").each(function () {
    $(this).text(calculation.TotalDays);
  });

  // Update jenis perjalanan
  $(".travel_type").each(function () {
    $(this).text(capitalizeFirstLetter(_travelType));
  });

  // Update jenis wisatawan
  $(".traveller_type").each(function () {
    $(this).text(capitalizeFirstLetter(_travellerType));
  });

  if (_travellerType === "Individual") {
    document
      .querySelectorAll(".jika_bersama, .jika_mereka")
      .forEach(function (element) {
        element.style.display = "none";
      });
  }

  // SET PREMI
  // Call the function with the required values
  setPremiums(
    totalMainBenefitPremium,
    totalAdditionalBenefitPremium,
    calculation.Stamp
  );

  //set amount biaya pengobatan gigi di web content span class = "amount_biaya_obat_gigi"
  const biayaPengobatan = _dataMainBenefitDesc.find(
    (item) => item.Name === "Biaya Pengobatan, Gigi dan Lainnya"
  );

  if (biayaPengobatan) {
    // Ambil angka setelah "IDR" tanpa menyertakan IDR
    const match = biayaPengobatan.Desc.match(/IDR\s([\d.]+)/);
    const amount = match ? match[1] : null; // Ambil grup pertama (angka tanpa IDR)

    if (amount !== null) {
      $(".amount_biaya_obat_gigi").each(function () {
        const formattedAmount =
          calculation.Currency === "IDR"
            ? formatToIDR(amount)
            : formatCurrencyBasic(amount);
        $(this).text(formattedAmount);
      });
    } else {
      console.warn("No valid amount found in Desc.");
    }
  } else {
    console.warn(
      "Item with Name 'Biaya Pengobatan, Gigi dan Lainnya' not found."
    );
  }
}

function setPremiums(
  totalMainBenefitPremium,
  totalAdditionalBenefitPremium,
  _stamp
) {
  //console.log('call set premi');
  // Ensure values are numbers
  totalMainBenefitPremium = parseFloat(totalMainBenefitPremium);
  totalAdditionalBenefitPremium = parseFloat(totalAdditionalBenefitPremium);
  _stamp = parseFloat(_stamp);

  // Calculate total premi_jaminan and total premi
  let totalPremiJaminan =
    totalMainBenefitPremium + totalAdditionalBenefitPremium;
  let totalPremi = totalPremiJaminan + _stamp;

  // Update HTML elements
  $(".premi_jaminan_utama").each(function () {
    $(this).text(formatCurrencyBasic(totalMainBenefitPremium));
  });

  $(".premi_jaminan_tambahan").each(function () {
    $(this).text(formatCurrencyBasic(totalAdditionalBenefitPremium));
  });

  $(".total_premi_jaminan").each(function () {
    $(this).text(formatCurrencyBasic(totalPremiJaminan));
  });

  $(".biaya_materai").each(function () {
    $(this).text(formatCurrencyBasic(_stamp));
  });

  $(".total_premi").each(function () {
    $(this).text(formatCurrencyBasic(totalPremi));
  });
}

function capitalizeFirstLetter(string) {
  if (!string) return ""; // Handle empty string
  return string
    .toLowerCase()
    .split(" ")
    .map((word) => word.charAt(0).toUpperCase() + word.slice(1))
    .join(" ");
}

function formatCurrencyBasic(value) {
  let formattedValue = parseFloat(value).toFixed(2);

  return formattedValue.replace(/\B(?=(\d{3})+(?!\d))/g, ".");
}

function formatToIDR(value) {
  return value.toLocaleString("id-ID", {
    minimumFractionDigits: 2,
    maximumFractionDigits: 2,
  });
}

function formatDate(dateStr) {
  var parts = dateStr.split("/");
  var day = parts[0];
  var month = parts[1];
  var year = parts[2];
  var months = {
    Jan: "January",
    Feb: "February",
    Mar: "March",
    Apr: "April",
    May: "May",
    Jun: "June",
    Jul: "July",
    Aug: "August",
    Sep: "September",
    Oct: "October",
    Nov: "November",
    Dec: "December",
  };
  return day + " " + months[month] + " " + year;
}

//Shorthand for $( document ).ready()
$(function () {
  // Target elemen yang ingin di-replace
  const sidebarNav = document.getElementById("sidebarNav");

  if (sidebarNav) {
    // Buat elemen baru dengan innerHTML
    const newSidebarNavContent = `
            <div class="sidebar-nav">
                <a class="btn_riplay btn btn--dark-blue width-full" href="javascript:void(0)"  onclick="proccessPayment()"> 
											<span class="position-relative text-transform-uppercase">
									            <span id="btn-text">Lanjut Ke Pembayaran  <i class="fas fa-arrow-right"></i></span> 
									        </span>
										</a>
        		<a class="btn btn--dark-blue width-full href="javascript:void(0)" id="prev-step-btn-a" style="margin-top:15px"><span class="position-relative text-transform-uppercase">Kembali</span></a>
            </div>
        `;

    // Replace isi dari elemen
    sidebarNav.outerHTML = newSidebarNavContent;
  }

  //set main benefit in web content
  const nameListDiv = document.getElementById("main_benefit-container");
  let namesHTML = "";

  _dataMainBenefit.forEach(function (item, index) {
    namesHTML += "<p>" + (index + 1) + ". " + item.Name + "</p>";
  });
  nameListDiv.innerHTML = namesHTML;

  //update
  updateDataByClass();

  /**
   * start untuk main benefit table di fitur utama riplay
   *
   */
  //set data to table riplay
  //    var tableBody = document.getElementById("benefit-table-body");
  //    var counter = 1;
  //    _dataMainBenefitDesc.forEach(function (item, index) {
  //    	var description = calculation.Currency === 'IDR' ? item.Desc : item.DescUSD; // Pilih berdasarkan currency
  //        var row = `
  //            <tr>
  //                <td>${counter++}.</td>
  //                <td>${item.Name}</td>
  //                <td>${description}</td>
  //
  //            </tr>
  //        `;
  //        tableBody.innerHTML += row;
  //    });

  var tableBody = document.getElementById("benefit-table-body");
  var counter = 1;

  _dataMainBenefitDesc.forEach(function (item) {
    var descriptions =
      calculation.Currency === "IDR" ? item.Desc : item.DescUSD;

    if (descriptions.includes("\n")) {
      // Jika mengandung \n, split menjadi beberapa baris
      var splitDescriptions = descriptions.split("\n");

      // Baris pertama hanya menampilkan "Name"
      var firstRow = `
	            <tr>
	                <td>${counter++}.</td>
	                <td>${item.Name}</td>
	                <td></td>
	            </tr>
	        `;
      tableBody.innerHTML += firstRow;

      // Baris untuk deskripsi dan harga
      splitDescriptions.forEach(function (desc) {
        var price = desc.match(/(IDR|USD) [0-9.,]+/i)?.[0] || "";

        // Ekstrak teks sebelum harga
        var text = desc.replace(price, "").trim();

        // Tambahkan row untuk deskripsi dan harga
        var row = `
	                <tr>
	                    <td></td>
	                    <td>${text}</td>
	                    <td style="text-align: center;">${price}</td>
	                </tr>
	            `;
        tableBody.innerHTML += row;
      });
    } else {
      // Jika tidak mengandung \n, langsung tambahkan baris
      var price = descriptions.match(/(IDR|USD) [0-9.,]+/i)?.[0] || "";
      var text = descriptions.replace(price, "").trim();

      var row = `
	            <tr>
	                <td>${counter++}.</td>
	                <td>${item.Name}</td>
	                <td style="text-align: center;">${price}</td>
	            </tr>
	        `;
      tableBody.innerHTML += row;
    }
  });

  // render title jaminan tambahan
  if (jaminanArray.length > 0) {
    var titleRow = `
			<tr style="background-color: #deb091;">
			<td colspan="3" style="text-align: center; color: black;">
			<strong>Jaminan Tambahan</strong>
			</td>
			</tr>
			`;
    tableBody.innerHTML += titleRow;
  }

  /**
   * end untuk main benefit table di fitur utama riplay
   */

  /**
   * untuk di manfaat dan pengecualian
   */

  // Hide all div elements inside .jaminan_tambahan  IN MANFAAT ACCORDION
  $(".jaminan_tambahan > div").hide();

  const benefitsCode = JSON.parse(sessionStorage.getItem("AdditionalBenefit"));
  //console.log('data>>', benefitsCode);
  $(".jaminan_tambahan > div").each(function () {
    const className = $(this).attr("class");
    const code = className.split("_")[0]; // Ambil bagian sebelum underscore

    if (benefitsCode.includes(code)) {
      $(this).show(); // Tampilkan div jika code ada di benefitcodes
    } else {
      $(this).hide(); // Sembunyikan div jika tidak
    }
  });

  /**
   * untuk di simulasi dan fitur utama
   */
  // for SIMULASI ACCORDION benefit tambahan
  var html = "";
  jaminanArray.forEach((jaminan, index) => {
    var letter = String.fromCharCode(65 + index); //start from A
    html += "<div>" + letter + ". " + jaminan.title + ":</div>";

    jaminan.items.forEach((item, itemIndex) => {
      var isLastItem = itemIndex === jaminan.items.length - 1;
      var style = isLastItem
        ? "margin-left: 15px; margin-bottom: 20px;"
        : "margin-left: 15px;";
      html +=
        "<div style='" +
        style +
        "'>" +
        (itemIndex + 1) +
        ". " +
        item.name +
        "</div>";
    });

    /**
     * start fitur utama manfaat riplay
     * refer to function transformJson
     */

    var counter = 1;

    //console.log('jaminan', jaminan);
    // render title jaminan
    var titleRow = `
	        <tr style="background-color: #aacb90;">
	            <td colspan="3" style="text-align: center; color: black;">
	                <strong>${jaminan.title}</strong>
	            </td>
	        </tr>
	    `;
    tableBody.innerHTML += titleRow;

    //render item dalam jaminan
    jaminan.items.forEach(function (item) {
      var align = item.value.includes("\n") ? "center" : "right";

      //	        var row = `
      //	            <tr>
      //	                <td>${counter++}.</td>
      //	                <td>${item.name}</td>
      //	                <td style="text-align: center;">${item.value}</td>
      //	            </tr>
      //	        `;
      //	        tableBody.innerHTML += row;

      //custom jika \n\n
      var descriptions = item.value;
      if (item.value.includes(" \n \n") || item.value.includes("\n\n")) {
        const splitDescriptions = descriptions
          .split("\n")
          .map((item) => item.trim())
          .filter((item) => item);

        // Baris pertama hanya menampilkan "Name"
        var firstRow = `
		            <tr>
		                <td>${counter++}.</td>
		                <td>${item.name}</td>
		                <td></td>
		            </tr>
		        `;
        tableBody.innerHTML += firstRow;

        // Baris untuk deskripsi dan harga
        splitDescriptions.forEach(function (desc) {
          var price = desc.match(/(IDR|USD) [0-9.,]+/i)?.[0] || "";

          // Ekstrak teks sebelum harga
          var text = desc.replace(price, "").trim();

          // Tambahkan row untuk deskripsi dan harga
          var row = `
		                <tr>
		                    <td></td>
		                    <td>${text}</td>
		                    <td style="text-align: center;">${price}</td>
		                </tr>
		            `;
          tableBody.innerHTML += row;
        });
      } else {
        var row = `
		            <tr>
		                <td>${counter++}.</td>
		                <td>${item.name}</td>
		                <td style="text-align: center;">${item.value}</td>
		            </tr>
		        `;
        tableBody.innerHTML += row;
      }
    });

    /**
     * end jaminan tambahan di fitur utama manfaat riplay
     */
  });

  //set to container
  document.getElementById("jaminan-container").innerHTML = html;

  //set mobile view penyesuaian
  adjustElemenMobile();

  adjustAccordionForMobile();

  $(document).on("click", "#prev-step-btn-a", function () {
    let sessData = sessionStorage.getItem(
      _smartTravelInternationalFormDetailSess
    );
    if (sessData) {
      sessData = JSON.parse(sessData);

      displayLoading();

      window.location.href = linkstep3 + "&pvt=" + sessData.Token;
    }
  });
});

document.addEventListener("DOMContentLoaded", function () {
  /* delete bg-white default liferay */

  var contentSection = document.getElementById("content");
  if (contentSection) {
    contentSection.classList.remove("bg-white");
  }

  //call sidebar
  updatePlanSummarySidebar();
});

document.querySelectorAll(".trigger-check").forEach(function (checkbox) {
  checkbox.addEventListener("change", function () {
    const accordionCollapse = this.closest(
      ".accordion-item__agreement"
    ).querySelector(".accordion-collapse");

    if (this.checked) {
      accordionCollapse.classList.remove("show");
    } else {
      accordionCollapse.classList.add("show");
    }
  });
});

/* button clear kode promo */
const clearButtons = document.querySelectorAll(".btnClear");

clearButtons.forEach((button) => {
  button.addEventListener("click", function () {
    const inputGroup = button.closest(".input-group-axa");
    const input = inputGroup.querySelector(".input-control-axa");

    input.value = "";
  });
});

//modal is pep
function closeModalIspep() {
  document.getElementById("ispepModal").classList.remove("is-open");
}

//MODAL ALERT BLOCKED
function openModalAlertBlocked() {
  //console.log('buka modal block');
  document.getElementById("modal_alert").classList.remove("agency__hidden");
}

function closeModalAlertBlocked() {
  document.getElementById("modal_alert").classList.add("agency__hidden");
}

/**
 * CUSTOME UPDATE STYLE VIA JS
 */

document.querySelectorAll(".stepper-wrapper .step-name").forEach((stepName) => {
  stepName.style.textAlign = "center";
});

function adjustElemenMobile() {
  const tables = document.querySelectorAll(".table-riplay");
  tables.forEach((table) => {
    if (window.innerWidth <= 768) {
      table.style.fontSize = "12px";
    } else {
      table.style.fontSize = "";
    }
  });

  const panelCovers = document.querySelectorAll(".dashboard-left__riplay");
  panelCovers.forEach((panelCover) => {
    if (window.innerWidth <= 768) {
      panelCover.style.padding = "20px";
    } else {
      panelCover.style.paddingLeft = "47px";
      panelCover.style.paddingRight = "47px";
    }
  });

  const panelCoversAggrement = document.querySelectorAll(
    ".dashboard-left__agreement"
  );
  panelCoversAggrement.forEach((panelAggr) => {
    if (window.innerWidth <= 768) {
      panelAggr.style.padding = "20px";
    } else {
      panelAggr.style.paddingLeft = "47px";
      panelAggr.style.paddingRight = "47px";
    }
  });

  const h1Elements = document.querySelectorAll("h1");
  h1Elements.forEach((h1) => {
    if (window.innerWidth <= 768) {
      h1.style.fontSize = "24px";
    } else {
      h1.style.fontSize = "36px";
    }
  });

  const policyParagraphs = document.querySelectorAll(
    ".accordion-wrapper__agreement .accordion-button__right .policy p"
  );
  if (window.innerWidth <= 768) {
    policyParagraphs.forEach((paragraph) => {
      paragraph.style.fontSize = "12px";
    });
  } else {
    policyParagraphs.forEach((paragraph) => {
      paragraph.style.fontSize = "";
    });
  }

  const policyParagraphsleft = document.querySelectorAll(
    ".accordion-wrapper .accordion-button__left .policy p, .accordion-wrapper__agreement .accordion-button__left .policy p"
  );
  policyParagraphsleft.forEach((paragraph) => {
    if (window.innerWidth <= 768) {
      paragraph.style.fontSize = "12px";
    } else {
      paragraph.style.fontSize = "";
    }
  });

  const container = document.getElementById("jaminan-container");
  const divs = container.querySelectorAll("div");
  if (window.innerWidth <= 768) {
    divs.forEach((div) => {
      div.style.fontSize = "12px";
    });
  } else {
    divs.forEach((div) => {
      div.style.fontSize = "15px";
    });
  }
}

window.addEventListener("resize", adjustElemenMobile);

function adjustAccordionForMobile() {
  const accordionItems = document.querySelectorAll(".accordion-item");

  accordionItems.forEach((accordionItem) => {
    const accordionBody = accordionItem.querySelector(".accordion-body");

    if (window.innerWidth <= 768) {
      if (accordionBody) {
        accordionBody.style.padding = "20px";
        accordionBody.style.fontSize = "12px";

        const paragraphs = accordionBody.querySelectorAll("p");
        paragraphs.forEach((paragraph) => {
          paragraph.style.fontSize = "12px";
        });
      }

      const tables = accordionBody.querySelectorAll("table");
      tables.forEach((table) => {
        table.style.width = "100%";
        table.style.fontSize = "12px";
      });
    } else {
      if (accordionBody) {
        accordionBody.style.padding = "";
        accordionBody.style.fontSize = "";

        const paragraphs = accordionBody.querySelectorAll("p");
        paragraphs.forEach((paragraph) => {
          paragraph.style.fontSize = "";
        });
      }

      const tables = accordionBody.querySelectorAll("table");
      tables.forEach((table) => {
        table.style.width = "fit-content";
        table.style.fontSize = "";
      });
    }
  });
}

window.addEventListener("resize", adjustAccordionForMobile);
