var kycURL = window.kycURL;
var ocrURL = window.ocrURL;
var link = window.link;
var restApiProcessUrl = window.restApiProcessUrl;
var isB2B = false;

var lId = window.lId;

var isScanOcr = window.isScanOcr;
var linkstep2 = window.linkstep2;
var apiLRCountries = window.apiLRCountries;

var restApiCountriesUrl = window.restApiCountriesUrl;
var restApiImageUrl = window.restApiImageUrl;

// var countriesGlobal = fetchCountries();
let countriesGlobal = [];

const quotationModal = new bootstrap.Modal(document.getElementById("quotation-modal"));

const indonesianMonths = {
  January: "Jan",
  February: "Feb",
  March: "Mar",
  April: "Apr",
  May: "Mei",
  June: "Jun",
  July: "Jul",
  August: "Agu",
  September: "Sep",
  October: "Okt",
  November: "Nov",
  December: "Des",
};

let lastOcrRequestId = 0;

// Get main benefit premi
var totalMainBenefitPremium, totalMainBenefitPremiumInIDR;
var totalAdditionalBenefitPremium, totalAdditionalBenefitPremiumInIDR;

if (simpleQuotation == "false") {
  const calculation = JSON.parse(sessionStorage.getItem("SmartTravelInternationalCalculation"));

  if (sessionStorage.getItem(_smartTravelInternationalCalculation)) {
    let formDetail = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
    let choosenPlan = formDetail.ChoosenPlan;

    let calculation = JSON.parse(sessionStorage.getItem(_smartTravelInternationalCalculation));

    for (const plan of calculation.AvailablePlans) {
      if (plan.PlanName === choosenPlan) {
        // Get main total
        totalMainBenefitPremium = plan.TotalMainBenefitPremium;
        totalMainBenefitPremiumInIDR = plan.TotalMainBenefitPremiumInIDR;

        // Get additional total
        totalAdditionalBenefitPremium = plan.TotalAdditionalBenefitPremium;
        totalAdditionalBenefitPremiumInIDR = plan.TotalAdditionalBenefitPremiumInIDR;
      }
    }
  }
} else {
  calculatePremi();
}

//Mendapatkan data dari sessionStorage
const formDetail = JSON.parse(sessionStorage.getItem("SmartTravelInternationalFormDetail"));

// Memastikan data ada sebelum mengakses properti
let token = null;
let totalInsured = 0;
let totalAdult = 0;
let totalChild = 0;
let travellerType = null;
if (formDetail) {
  token = formDetail.Token;
  totalAdult = parseInt(formDetail.AdultTotal, 10) || 0;
  totalChild = parseInt(formDetail.ChildTotal, 10) || 0;
  totalInsured = totalAdult + totalChild;
  travellerType = formDetail.TravellerType;

  // Render sideplan
  let totalPremiJaminan = totalMainBenefitPremium + totalAdditionalBenefitPremium;

  let promoCode = formDetail["PromoCode"];

  if (promoCode) {
    $('input[name="PromoCode"]').val(promoCode);
    $('input[name="PromoCodeSidebar"]').val(promoCode);
  }

  // Update plan summary yang ada di sidebar
  updatePlanSummarySidebar();

  // Update sticky summary
  updateStickyPrice();
} else {
  alert("Data 'SmartTravelInternationalFormDetail' tidak ditemukan di sessionStorage.");
}

if (formDetail && formDetail.Name && formDetail.Name.trim() !== "") {
  const namePolisField = document.querySelector('input[name="input_name_polisholder"]');
  if (namePolisField) {
    namePolisField.value = formDetail.Name;
  }
}

if (formDetail && formDetail.Email && formDetail.Email.trim() !== "") {
  const emailPolisField = document.querySelector('input[name="input_email_polisholder"]');
  if (emailPolisField) {
    emailPolisField.value = formDetail.Email;
  }
}

// OCR
async function handleFileChange(fileInput) {
  const requestId = ++lastOcrRequestId;

  resetNearestFieldsPaspor(fileInput);
  await new Promise(requestAnimationFrame);

  const file_foto = await collectDataFoto(fileInput);

  // Kalau sudah ada request baru → stop
  if (requestId !== lastOcrRequestId) return;

  const payload = {
    dataCategory: "ocr",
    _fotoBase64: file_foto._fotoktp,
    _fileName: file_foto._fileName,
  };

  const nearestLoadingIcon = fileInput.closest(".thumbnail-wrapper")?.querySelector(".loading-icon");

  $.ajax({
    type: "POST",
    url: ocrURL,
    data: JSON.stringify(payload),
    contentType: "application/json",

    beforeSend: function () {
      if (nearestLoadingIcon) {
        nearestLoadingIcon.classList.add("display-visible");
      }
    },

    success: function (response) {
      // Abaikan response lama
      if (requestId !== lastOcrRequestId) return;

      if (response.status) {
        updateNearestFieldsPaspor(fileInput, response);
      }
    },

    error: function () {
      if (requestId !== lastOcrRequestId) return;
      alert("Terjadi kesalahan. Silahkan coba kembali.");
    },

    complete: function () {
      if (requestId !== lastOcrRequestId) return;

      if (nearestLoadingIcon) {
        nearestLoadingIcon.classList.remove("display-visible");
      }
    },
  });
}


async function collectDataFoto(fileInput) {
  const data = {
    _fotoktp: "",
    _fileName: "",
  };

  if (fileInput && fileInput.files.length > 0) {
    data._fotoktp = await getBase64(fileInput.files[0]);
    data._fileName = fileInput.files[0].name;
  }

  return data;
}

// Fungsi untuk memperbarui field input terdekat dengan hasil response
function updateNearestFields(fileInput, response) {
  //console.log('updateNearestFields.......>>', response.response);

  var dataRead = response.response.read; // response.response.read.(nama, alamat, etc)

  // Temukan container-form terdekat
  const container = fileInput.closest(".container-form");

  // Update nilai field terdekat
  if (container) {
    const nameInput = container.querySelector(".classInputName");
    const addressInput = container.querySelector(".classInputAddress");
    const placeBirth = container.querySelector(".classInputPlaceOfBirth");
    const ktpKitas = container.querySelector(".classInputKtpKitas");

    // Update name
    if (dataRead.nama && dataRead.nama.confidence > 70 && nameInput) {
      nameInput.value = dataRead.nama.value;
      nameInput.classList.remove("invalid");
    }

    // Update address
    if (dataRead.alamat && dataRead.alamat.confidence > 70 && addressInput) {
      let alamat = dataRead.alamat ? dataRead.alamat.value : "";
      let rtRw = dataRead.rtRw && dataRead.rtRw.confidence > 70 ? "RT " + dataRead.rtRw.value.split("/")[0] + " RW " + dataRead.rtRw.value.split("/")[1] : "";
      let kelDesa = dataRead.kelurahanDesa && dataRead.kelurahanDesa.confidence > 70 ? "Kelurahan " + dataRead.kelurahanDesa.value : "";
      let kec = dataRead.kecamatan && dataRead.kecamatan.confidence > 70 ? "Kecamatan " + dataRead.kecamatan.value : "";
      let kotaKab = dataRead.kotaKabupaten && dataRead.kotaKabupaten.confidence > 70 ? dataRead.kotaKabupaten.value : "";
      let prov = dataRead.provinsi && dataRead.provinsi.confidence > 70 ? dataRead.provinsi.value : "";

      let fullAddress = alamat + ", " + rtRw + ", " + kelDesa + ", " + kec + ", " + kotaKab + ", " + prov;
      addressInput.value = fullAddress.replace(/ ,/g, ""); // Remove any extra commas if any part is missing

      addressInput.classList.remove("invalid");
    }

    // Update birth place
    if (dataRead.tempatLahir && dataRead.tempatLahir.confidence > 70 && placeBirth) {
      placeBirth.value = dataRead.tempatLahir.value;
      placeBirth.classList.remove("invalid");
    }

    // Update KTP/KITAS number
    if (dataRead.nik && dataRead.nik.confidence > 70 && ktpKitas) {
      ktpKitas.value = dataRead.nik.value;
      ktpKitas.classList.remove("invalid");
    }

    // Update status perkawinan
    let statusKawin = dataRead.statusPerkawinan && dataRead.statusPerkawinan.confidence > 70 ? dataRead.statusPerkawinan.value : "";
    const select2statusKawin = container.querySelector(".status-kawin");
    if (select2statusKawin) {
      if (statusKawin === "KAWIN" || statusKawin === "MARRIED" || statusKawin === "MENIKAH") {
        $(select2statusKawin).val("Sudah Menikah").trigger("change");
      } else {
        $(select2statusKawin).val("Belum Menikah").trigger("change");
      }

      select2statusKawin.closest(".status-kawin-container").classList.remove("invalid");
    }

    // Update pekerjaan (job)
    //let job = dataRead.pekerjaan && dataRead.pekerjaan.confidence > 70 ? dataRead.pekerjaan.value : '';
    //const select2Job = container.querySelector('.job');
    //if (select2Job) {
    //    $(select2Job).val(job).trigger('change');
    //}

    // Update gender
    const maleRadio = container.querySelector(".classInputGenderMale");
    const femaleRadio = container.querySelector(".classInputGenderFemale");

    if (dataRead.jenisKelamin && dataRead.jenisKelamin.confidence > 70) {
      if (["LAKI-LAKI", "PRIA", "MALE"].some((gender) => gender.toLowerCase() === dataRead.jenisKelamin.value.toLowerCase())) {
        maleRadio.checked = true;
      } else {
        femaleRadio.checked = true;
      }

      maleRadio.closest(".gender-container").classList.remove("invalid");
      femaleRadio.closest(".gender-container").classList.remove("invalid");
    }

    // Update tanggal lahir
    var dateofbirth = dataRead.tanggalLahir && dataRead.tanggalLahir.confidence > 70 ? dataRead.tanggalLahir.value : "";
    var formattedDOB = dateofbirth.replace(/-/g, "/"); // Format - to /

    if (dateofbirth) {
      const formattedDOBToSet = moment(formattedDOB, "DD/MM/YYYY");
      const day = formattedDOBToSet.format("DD");
      const englishMonth = formattedDOBToSet.format("MMMM");
      const year = formattedDOBToSet.format("YYYY");
      const indonesianMonth = indonesianMonths[englishMonth];

      const formattedDate = day + "/" + indonesianMonth + "/" + year;

      const dobInputClosest = container.querySelector(".dob");
      if (dobInputClosest) {
        dobInputClosest.value = formattedDate;
        //console.log('Tanggal sebelum init:', $(dobInputClosest).val(), 'Start date:', formattedDOBToSet);
        initDatepickerFromScan(dobInputClosest, formattedDOBToSet);

        dobInputClosest.closest(".dob-wrapper").classList.remove("invalid");
      }

      // Calculate age
      const birthDate = moment(formattedDOB, "DD/MM/YYYY");
      const today = moment();
      let age = today.diff(birthDate, "years");

      // Check if birthday this year has passed
      const isBeforeBirthdayThisYear = today.isBefore(birthDate.clone().add(age, "years"));

      if (isBeforeBirthdayThisYear) {
        age--; // Decrease age if birthday hasn't passed this year
      }

      const ageInputClosest = container.querySelector(".age");
      if (ageInputClosest) {
        ageInputClosest.value = age;
      }
    }
  }
}

// Fungsi untuk memperbarui field input terdekat dengan hasil response
function updateNearestFieldsPaspor(fileInput, response) {
  var dataRead = response.data;

  // Temukan container-form terdekat
  const container = fileInput.closest(".container-form");

  // Update nilai field terdekat
  if (container) {
    const nameInput = container.querySelector(".classInputName");
    const paspor = container.querySelector(".classInputPaspor");

    // Update name
    if (
      dataRead.name &&
      dataRead.name.confidence > 70 &&
      nameInput &&
      dataRead.surname // Ensure surname exists
    ) {
      const fullName = `${dataRead.name.value} ${dataRead.surname.value}`.trim(); // Combine name and surname safely
      nameInput.value = fullName; // Update input with full name
      nameInput.classList.remove("invalid");
    }

    // Update PASPOR number
    if (dataRead.doc_number && dataRead.doc_number.confidence > 70 && paspor) {
      paspor.value = dataRead.doc_number.value;
      paspor.classList.remove("invalid");
    }

    // Update gender
    const maleRadio = container.querySelector(".classInputGenderMale");
    const femaleRadio = container.querySelector(".classInputGenderFemale");

    if (dataRead.sex && dataRead.sex.confidence > 70) {
      if (["P", "F", "PEREMPUAN", "FEMALE"].some((gender) => gender.toLowerCase() === dataRead.sex.value.toLowerCase())) {
        femaleRadio.checked = true;
      } else {
        maleRadio.checked = true;
      }

      maleRadio.closest(".gender-container").classList.remove("invalid");
      femaleRadio.closest(".gender-container").classList.remove("invalid");
    }

    // Update tanggal lahir
    var dateofbirth = dataRead.birth_date && dataRead.birth_date.confidence > 70 ? dataRead.birth_date.value : "";
    var formattedDOB = dateofbirth.replace(/-/g, "/"); // Format - to /

    if (dateofbirth) {
      const formattedDOBToSet = moment(formattedDOB, "DD/MM/YYYY");
      const day = formattedDOBToSet.format("DD");
      const englishMonth = formattedDOBToSet.format("MMMM");
      const year = formattedDOBToSet.format("YYYY");
      const indonesianMonth = indonesianMonths[englishMonth];

      const formattedDate = day + "/" + indonesianMonth + "/" + year;

      const dobInputClosest = container.querySelector(".dob");
      if (dobInputClosest) {
        dobInputClosest.value = formattedDate;
        //console.log('Tanggal sebelum init:', $(dobInputClosest).val(), 'Start date:', formattedDOBToSet);
        initDatepickerFromScan(dobInputClosest, formattedDOBToSet);

        dobInputClosest.closest(".dob-wrapper").classList.remove("invalid");
      }

      // Calculate age
      const birthDate = moment(formattedDOB, "DD/MM/YYYY");
      const today = moment();
      let age = today.diff(birthDate, "years");

      // Check if birthday this year has passed
      const isBeforeBirthdayThisYear = today.isBefore(birthDate.clone().add(age, "years"));

      if (isBeforeBirthdayThisYear) {
        age--; // Decrease age if birthday hasn't passed this year
      }

      const ageInputClosest = container.querySelector(".age");
      if (ageInputClosest) {
        ageInputClosest.value = age;
      }
    }
  }
}

function resetNearestFieldsPaspor(fileInput) {
  const container = fileInput.closest(".container-form");
  if (!container) return;

  // Reset nama
  const nameInput = container.querySelector(".classInputName");
  if (nameInput && nameInput.value.trim() !== "") {
    nameInput.value = "";
    // nameInput.classList.add("invalid");
  }

  // Reset paspor
  const pasporInput = container.querySelector(".classInputPaspor");
  if (pasporInput && pasporInput.value.trim() !== "") {
    pasporInput.value = "";
    // pasporInput.classList.add("invalid");
  }

  // Reset gender
  const maleRadio = container.querySelector(".classInputGenderMale");
  const femaleRadio = container.querySelector(".classInputGenderFemale");

  const wasGenderChecked =
    (maleRadio && maleRadio.checked) ||
    (femaleRadio && femaleRadio.checked);

  if (maleRadio) maleRadio.checked = false;
  if (femaleRadio) femaleRadio.checked = false;

  if (wasGenderChecked) {
    const genderContainer =
      maleRadio?.closest(".gender-container") ||
      femaleRadio?.closest(".gender-container");

    // if (genderContainer) {
    //   // genderContainer.classList.add("invalid");
    // }
  }

  // Reset tanggal lahir
  const dobInput = container.querySelector(".dob");
  if (dobInput && dobInput.value.trim() !== "") {
    dobInput.value = "";
    // dobInput.closest(".dob-wrapper")?.classList.add("invalid");

    if ($(dobInput).data("datepicker")) {
      $(dobInput).datepicker("clearDates");
    }
  }

  // Reset umur
  const ageInput = container.querySelector(".age");
  if (ageInput && ageInput.value.trim() !== "") {
    ageInput.value = "";
  }

    // Reset KTP KITAS
  const ktpKitasInput = container.querySelector(".classInputKtpKitas");
  if (ktpKitasInput && ktpKitasInput.value.trim() !== "") {
    ktpKitasInput.value = "";
  }
}

function escapeHTML(input) {
  //console.log('call escape html');
  return input.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#039;");
}

function getValue(selector) {
  const element = document.querySelector(selector);

  return element ? element.value : "";
}

// Helper function to extract checked radio/checkbox values
function getCheckedValue(selector) {
  const element = document.querySelector(selector + ":checked");
  return element ? element.value : "";
}

// Convert image to Base64
function getBase64(file) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.onload = () => resolve(reader.result);
    reader.onerror = reject;
    reader.readAsDataURL(file);
  });
}

// ID Card Photo upload validation
function validateIdPhoto() {
  let stat = true;
  const docInputs = document.querySelectorAll(".docupload");
  const imgInputs = document.querySelectorAll(".imgupload");

  for (let i = 0; i < docInputs.length; i++) {
    const docVal = docInputs[i].value;
    const imgVal = imgInputs[i].value;

    // Jika kedua-duanya kosong, maka tidak valid
    if (!docVal && !imgVal) {
      return false;
    }
  }

  return true;
}

// Form validation
function checkValidation(policy_holder = null) {
  const selector = policy_holder ? `.container-form.${policy_holder} [required]` : ".container-form [required]";
  const requiredFields = document.querySelectorAll(selector);
  let isValid = true;

  requiredFields.forEach(function (field) {
    if (field.type === "radio") {
      const name = field.name;
      const selectedRadio = document.querySelector('input[name="' + name + '"]:checked');

      if (!selectedRadio) {
        field.classList.add("invalid");
        isValid = false;

        const radioContainer = field.closest(".ispep-container");
        if (radioContainer) {
          radioContainer.classList.add("invalid");
        }
      } else {
        field.classList.remove("invalid");
        const radioContainer = field.closest(".ispep-container");
        if (radioContainer) {
          radioContainer.classList.remove("invalid");
        }
      }
    }

    if (field.type === "radio") {
      const name = field.name;
      const selectedRadio = document.querySelector('input[name="' + name + '"]:checked');

      if (!selectedRadio) {
        field.classList.add("invalid");
        isValid = false;

        // Menandai kelas invalid pada kontainer radio
        const radioContainer = field.closest(".gender-container");
        if (radioContainer) {
          radioContainer.classList.add("invalid");
        }
      } else {
        // Jika ada radio yang dipilih, hapus kelas invalid
        field.classList.remove("invalid");
        const radioContainer = field.closest(".gender-container");
        if (radioContainer) {
          radioContainer.classList.remove("invalid");
        }
      }
    }

    // Validasi untuk input lainnya
    if (!field.value.trim()) {
      if ([...field.classList].some((cls) => cls.includes("fotoktp"))) {
        if (field.files.length === 0 && !field.closest(".thumbnail-wrapper")?.querySelector(".imgupload").value.trim()) {
          const containerTarget = field.closest(".thumbnail-wrapper").querySelector(".thumbnail");
          if (containerTarget) {
            containerTarget.classList.add("invalid");
            isValid = false;
          }
        }
      } else if (field.classList.contains("email")) {
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        const emailValue = field.value.trim();

        if (!emailPattern.test(emailValue)) {
          field.classList.add("invalid");
          isValid = false;
        } else {
          field.classList.remove("invalid");
        }
      } else if (field.classList.contains("dob")) {
        const containerTarget = field.closest(".dob-wrapper");
        if (containerTarget) {
          containerTarget.classList.add("invalid");
          isValid = false;
        }
      } else if (field.classList.contains("status-kawin")) {
        const containerTarget = field.closest(".status-kawin-container");
        if (containerTarget) {
          containerTarget.classList.add("invalid");
          isValid = false;
        }
      } else if (field.classList.contains("negara")) {
        const containerTarget = field.closest(".negara-container");
        if (containerTarget) {
          containerTarget.classList.add("invalid");
          isValid = false;
        }
      } else if (field.classList.contains("job")) {
        const containerTarget = field.closest(".job-container");
        if (containerTarget) {
          containerTarget.classList.add("invalid");
          isValid = false;
        }
      } else if (field.classList.contains("relationship")) {
        const containerTarget = field.closest(".relationship-container");
        if (containerTarget) {
          containerTarget.classList.add("invalid");
          isValid = false;
        }
      } else {
        field.classList.add("invalid");
        isValid = false;
      }
    } else {
      field.classList.remove("invalid");

      if (field.classList.contains("email")) {
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        const emailValue = field.value.trim();
        if (!emailPattern.test(emailValue)) {
          field.classList.add("invalid");
          isValid = false;
        } else {
          field.classList.remove("invalid");
        }
      }

      if (field.classList.contains("fileInput")) {
        const thumbnail = field.closest("div").querySelector(".thumbnail");
        if (thumbnail) {
          thumbnail.classList.remove("invalid");
        }
      }

      if (field.classList.contains("dob")) {
        const dobWrapper = field.closest(".dob-wrapper");
        if (dobWrapper) {
          dobWrapper.classList.remove("invalid");
        }
      }

      if (field.classList.contains("status-kawin")) {
        const containerTarget = field.closest(".status-kawin-container");
        if (containerTarget) {
          containerTarget.classList.remove("invalid");
        }
      }

      if (field.classList.contains("negara")) {
        const containerTarget = field.closest(".negara-container");
        if (containerTarget) {
          containerTarget.classList.remove("invalid");
        }
      }

      if (field.classList.contains("job")) {
        const containerTarget = field.closest(".job-container");
        if (containerTarget) {
          containerTarget.classList.remove("invalid");
        }
      }

      if (field.classList.contains("relationship")) {
        const containerTarget = field.closest(".relationship-container");
        if (containerTarget) {
          containerTarget.classList.remove("invalid");
        }
      }

      if (field.classList.contains("passport-field")) {
        const regex = /^[A-Za-z0-9]{6,10}$/;
        if (regex.test(field.value.trim())) {
          field.classList.remove("invalid");
        } else {
          field.classList.add("invalid");
          isValid = false;
        }
      }

      if (field.classList.contains("ktp-field")) {
        const regex = /^[0-9]{16,16}$/;
        if (regex.test(field.value.trim())) {
          field.classList.remove("invalid");
        } else {
          field.classList.add("invalid");
          isValid = false;
        }
      }

      if (field.classList.contains("kitas-field")) {
        const regex = /^[A-Za-z0-9._\s-]{10,20}$/;
        if (regex.test(field.value.trim())) {
          field.classList.remove("invalid");
        } else {
          field.classList.add("invalid");
          isValid = false;
        }
      }
    }
  });

  return isValid;
}

// Check Forms
function checkForms() {
  const isEachDocUploadValid = validateIdPhoto();
  const selector = ".container-form [required]";
  const requiredFields = document.querySelectorAll(selector);
  let allValid = true;

  requiredFields.forEach(function (field) {
    if (field.type === "radio") {
      const name = field.name;
      const selectedRadio = document.querySelector('input[name="' + name + '"]:checked');

      if (!selectedRadio) {
        allValid = false;
      }
    }

    if (field.type !== "file" && field.value.trim().length === 0) {
      allValid = false;
    }

    if (field.type === "file") {
      const files = field.files;
      if (files.length === 0) {
      } else {
        //console.log('File sudah diupload untuk: ' + field.name);
      }
    }

    if (field.classList.contains("email")) {
      const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
      const emailValue = field.value.trim();

      if (!emailPattern.test(emailValue)) {
        allValid = false;
      }
    }
  });

  // Disable submit button
  const submitButton = document.querySelector(".btn__submit");
  if (allValid && isEachDocUploadValid) {
    submitButton.classList.remove("btn--dark-grey");
    submitButton.classList.add("btn--dark-blue");
    submitButton.style.pointerEvents = "";
  } else {
    submitButton.classList.remove("btn--dark-blue");
    submitButton.classList.add("btn--dark-grey");
    submitButton.style.pointerEvents = "none";
  }

  const quoteButton = document.querySelector("#submit-quotation-btn");
  if (quoteButton) {
    if (allValid) {
      quoteButton.classList.remove("btn--dark-grey");
      quoteButton.classList.add("btn--dark-blue");
      quoteButton.style.pointerEvents = "";
    } else {
      quoteButton.classList.remove("btn--dark-blue");
      quoteButton.classList.add("btn--dark-grey");
      quoteButton.style.pointerEvents = "none";
    }
  }
}

function disableBtnNext() {
  const submitButtons = document.querySelectorAll(".btn__submit, #submit-quotation-btn");

  submitButtons.forEach((submitButton) => {
    submitButton.classList.remove("btn--dark-blue");
    submitButton.classList.add("btn--dark-grey");
    submitButton.style.pointerEvents = "none";
  });
}

function scrollToInvalidField() {
  const invalidElements = document.querySelectorAll(".invalid");
  if (invalidElements.length > 0) {
    for (let i = 0; i < invalidElements.length; i++) {
      const element = invalidElements[i];
      if (element.classList.contains("ignoreValid")) {
        continue;
      }

      element.scrollIntoView({
        behavior: "smooth",
        block: "center",
      });
      element.focus();
      break;
    }
  }
}

function checkIspep(data) {
  if (data.policyholder._ispep === "1") {
    return true; // Terblokir
  }

  for (const insured of data.insured) {
    if (insured._ispep === "1") {
      return true; // Terblokir
    }
  }

  return false; // Tidak terblokir
}

async function preparePayload(typeProcess, linkToProccess) {
  //check if insured same as policy holder
  const checkbox = document.querySelector('input[type="checkbox"][name="insuredIsPolis"]');
  const isChecked = checkbox ? checkbox.checked : false;

  const promoCode = $("#promo-code").val();

  // Collect policyholder data
  const policyholderData = await collectData("polisholder");

  // Collect insured data (with additional relationship field)
  const insuredDataList = [];
  const insuredCount = document.querySelectorAll(".insured-form").length; // Or any dynamic count you have

  //console.log('total tertanggung>>' + insuredCount);

  for (let i = 0; i < insuredCount; i++) {
    // Collect data for each insured
    const insuredData = await collectData("insured", i);

    // Construct the selector for the relationship field
    const relationshipSelector = 'select[name="input_relationship_insured_' + i + '"]';
    insuredData._relationship = getValue(relationshipSelector);

    // Add collected data to the list
    insuredDataList.push(insuredData);
  }

  // Combine policyholder data and insured data into one payload
  const payload = {
    policyholder: policyholderData,
    insured: insuredDataList,
    insuredIsPolis: isChecked,
    promoCode,
    token: token,
  };

  // Retrieve data from sessionStorage
  let formDetail = sessionStorage.getItem("SmartTravelInternationalFormDetail");
  let _Token = null;
  let _AdditionalBenefit = null;
  let _mbid = "";

  if (!formDetail) {
    alert("Form Detail is not found!");
  }

  let formDetailObject = JSON.parse(formDetail);
  _Token = formDetailObject.Token;

  if (formDetailObject.AdditionalBenefits && formDetailObject.AdditionalBenefits.length > 0) {
    _AdditionalBenefit = formDetailObject.AdditionalBenefits;
  }

  if (formDetailObject.ManagedById) {
    _mbid = formDetailObject.ManagedById;
  }

  let utmSource = formDetailObject.UtmSource;

  // Combine the data into a single payload object
  let existingSession = {
    Token: _Token,
    AdditionalBenefit: _AdditionalBenefit,
    type: typeProcess,
    payloadKyc: payload,
    mbid: _mbid,
    utmSource: utmSource
  };

  // PERSETUJUAN
  if (typeProcess === "persetujuan") {
    $.ajax({
      type: "POST",
      url: linkToProccess,
      data: JSON.stringify(existingSession),
      contentType: "application/json",
      beforeSend: function () {
        $(".btn__submit").css({
          "pointer-events": "none",
          opacity: "0.5",
          cursor: "not-allowed",
        });

        $("#btn-text").html('Loading <i class="custom-spinner"></i>');
      },
      success: function (response) {
        if (!response) {
          alert("Something wrong [PRC01]. Please try again.");
        }

        if (response.Status === 1) {
          if (response.ProcessType === "normal") {
            // session for riplay
            sessionStorage.setItem("SmartTravelInternationalDataPayload", JSON.stringify(payload));
            sessionStorage.setItem("AdditionalBenefit", JSON.stringify(response.additionalBenefitsCode));

            // redirect to riplay
            window.location.href = riplayURL;
          }
        } else {
          if (typeof response.Blocked !== "undefined") {
            // blocked
            document.querySelector(".content-message-popup-ispep").innerHTML = !response.Message ? "Something wrong [PRC02]" : response.Message;
          } else if (typeof response.Pep !== "undefined") {
            // pep
            document.querySelector(".content-message-popup-ispep").innerHTML = !response.Message ? "Something wrong [PRC03]" : response.Message;
            document.getElementById("ispepModal").classList.add("is-open");
            const okButton = document.querySelector(".btn__ok__ispep");
            if (okButton) {
              okButton.onclick = () => (window.location.href = linkstep2);
            }
          } else {
            // general error
            document.querySelector(".content-message-popup-ispep").innerHTML = !response.Message ? "Something wrong [PRC04]. Please try again or contact administrator." : response.Message;
          }

          document.getElementById("ispepModal").classList.add("is-open");
        }
      },
      error: function (error) {
        alert("Error!");
      },
      complete: function () {
        $(".btn__submit").css({
          "pointer-events": "",
          opacity: "",
          cursor: "",
        });

        $("#btn-text").html('Lanjut Ke Persetujuan <i class="fas fa-arrow-right"></i>');
      },
    });
  } else {
    // PENAWARAN
    $.ajax({
      url: linkToProccess,
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify(existingSession),
      beforeSend: function () {
        $("#openModalBtn").css({
          "pointer-events": "none",
          opacity: "0.5",
          cursor: "not-allowed",
        });

        $("#send_quotation_btn").html('<span class="modal_penawaran-agency__text-amber-300"> LOADING.... </span> <i class="fas fa-arrow-right ml-2level"></i>').attr("disabled", true);
      },
      success: function (response) {
        if (response.Status === 1) {
          // Redirect jika sukses
          sessionStorage.setItem("SmartTravelInternationalDataPayload", JSON.stringify(payload));
          sessionStorage.setItem("AdditionalBenefit", JSON.stringify(response.additionalBenefitsCode));

          // Tampilkan popup sukses kirim penawaran
          const modalBody = document.querySelector(".modal_alert-body");
          const modalContent = document.querySelector(".modal_alert-content");

          if (modalContent) {
            modalContent.style.width = "40%";
          }

          modalBody.innerHTML = "Penawaran Berhasil, Anda akan dialihkan ke halaman Dashboard";
          openModalAlertBlocked();

          // Simpan URL redirect
          const redirectUrl = response.RedirectTarget;

          // clear session storage
          sessionStorage.clear();

          const okButton = document.querySelector(".ispep_modal__inner-footer-btn");
          if (okButton) {
            okButton.onclick = () => closeModalAlertBlocked(redirectUrl);
          }
        } else {
          if (typeof response.Blocked !== "undefined") {
            // blocked
            document.querySelector(".content-message-popup-ispep").innerHTML = !response.Message ? "Something wrong [PRC05]" : response.Message;
          } else if (typeof response.Pep !== "undefined") {
            // pep
            document.querySelector(".content-message-popup-ispep").innerHTML = !response.Message ? "Something wrong [PRC06]" : response.Message;
            document.getElementById("ispepModal").classList.add("is-open");
            const okButton = document.querySelector(".btn__ok__ispep");
            if (okButton) {
              okButton.onclick = () => (window.location.href = linkstep2);
            }
          } else {
            // general error
            document.querySelector(".content-message-popup-ispep").innerHTML = !response.Message ? "Something wrong [PRC07]. Please try again or contact administrator." : response.Message;
          }

          document.getElementById("ispepModal").classList.add("is-open");
        }
      },
      error: function (xhr, status, error) {
        quotationModal.hide();
        console.error("Error:", error);
        alert("Error!");
      },
      complete: function () {
        quotationModal.hide();
        $("#send_quotation_btn").html('<span class="modal_penawaran-agency__text-amber-300"> KIRIM </span> <i class="fas fa-arrow-right ml-2level"></i>').attr("disabled", false);
        $("#openModalBtn").css({
          "pointer-events": "",
          opacity: "",
          cursor: "",
        });
      },
    });
  }
}

//Helper function to collect form data based on a type (policyholder or insured) and an index for insured persons
async function collectData(type, index = null) {
  // If an index is provided (for insured data), append it to field selectors
  const indexSuffix = index !== null ? "_" + index : "";

  const data = {
    _ispep: getCheckedValue('input[name="input_ispep_' + type + indexSuffix + '"]'),
    _fotoktp: "",
    _name: getValue('input[name="input_name_' + type + indexSuffix + '"]'),
    _ktppaspor: getValue('input[name="input_ktppaspor_' + type + indexSuffix + '"]'),
    _dob: getValue('input[name="input_dob_' + type + indexSuffix + '"]'),
    _pdob: getValue('input[name="input_pdob_' + type + indexSuffix + '"]'),
    _gender: getCheckedValue('input[name="input_gender_' + type + indexSuffix + '"]'),

    //_kodenegara: getValue('select[name="input_kodenegara_' + type + indexSuffix + '"]'),
    _kodenegara: getValue('input[name="input_kodenegara_' + type + indexSuffix + '"]'),

    _hp: getValue('input[name="input_hp_' + type + indexSuffix + '"]'),
    _negara: getValue('select[name="input_negara_' + type + indexSuffix + '"]'),
    _job: getValue('select[name="input_job_' + type + indexSuffix + '"]'),

    _otherjob: getValue('input[name="input_otherjob_' + type + indexSuffix + '"]'),

    _ktpkitas: getValue('input[name="input_ktpkitas_' + type + indexSuffix + '"]'),
    _age: getValue('input[name="input_age_' + type + indexSuffix + '"]'),
    _statuskawin: getValue('select[name="input_status-kawin_' + type + indexSuffix + '"]'),
    _telepon: getValue('input[name="input_telepon_' + type + indexSuffix + '"]'),
    _email: getValue('input[name="input_email_' + type + indexSuffix + '"]'),
    _kodepos: getValue('input[name="input_kodepos_' + type + indexSuffix + '"]'),
    _alamat: getValue('input[name="input_alamat_' + type + indexSuffix + '"]'),
  };

  // Handle image conversion (if applicable)
  const fileInput = document.querySelector('input[name="input_fotoktp_' + type + indexSuffix + '"]');
  if (fileInput) {
    if (fileInput.files.length > 0) {
      data._fotoktp = await getBase64(fileInput.files[0]);
    } else {
      //jika bukan pilih upload foto, maka ambil dari img src, akan dicheck masih pakai foto default atau sudah base on doc db
      //tunggu fix
      //const imgElement = fileInput.closest('.upload-container')?.querySelector('.thumbnail-wrapper img');
      //data._fotoktp = imgElement ? imgElement.src : '';
    }
  }

  return data;
}

/*function initDatepickerFromScan(inputClass, date) {
    //console.log('call initial datepicker scan');
    $(inputClass).daterangepicker({
        parentEl: ".dob-wrapper",
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        startDate: date,
        maxDate: moment(),
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply-ignore",
        cancelClass: "btn-cancel",
        locale: {
            applyLabel: 'Pilih',
            cancelLabel: 'Batal',
            "daysOfWeek": [
                "Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"
            ],
            "monthNames": [
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            ],
        }
    });
}*/

function initDatepickerFromScan(inputClass, date) {
  const $element = $(inputClass);
  //console.log('Inisialisasi update datepicker dengan date:', date);

  // Hapus instance datepicker sebelumnya jika ada
  const datepicker = $element.data("daterangepicker");
  if (datepicker) {
    datepicker.remove();
  }

  // Tentukan rentang tanggal berdasarkan kelas elemen
  let minDate, maxDate;
  if ($element.hasClass("dob-adult")) {
    minDate = moment().subtract(85, "years");
    maxDate = moment().subtract(17, "years");
  } else if ($element.hasClass("dob-child")) {
    minDate = moment().subtract(17, "years");
    maxDate = moment().subtract(1, "years");
  } else if ($element.hasClass("dob-student")) {
    minDate = moment().subtract(25, "years");
    maxDate = moment().subtract(1, "years");
  } else {
    minDate = moment().subtract(100, "years");
    maxDate = moment();
  }

  // Inisialisasi ulang datepicker
  $element
    .daterangepicker({
      parentEl: ".dob-wrapper",
      autoUpdateInput: false,
      singleDatePicker: true,
      showDropdowns: true,
      startDate: date,
      //minDate: minDate,
      maxDate: maxDate,
      buttonClasses: "btn-date",
      applyButtonClasses: "btn-apply-ignore",
      cancelClass: "btn-cancel",
      locale: {
        applyLabel: "Pilih",
        cancelLabel: "Batal",
        daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
        monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
      },
    })
    .on("apply.daterangepicker", function (ev, picker) {
      // Format tanggal ke Indonesia
      const day = picker.startDate.format("DD");
      const englishMonth = picker.startDate.format("MMMM");
      const year = picker.startDate.format("YYYY");
      const indonesianMonth = indonesianMonths[englishMonth];
      const formattedDate = `${day}/${indonesianMonth}/${year}`;

      // Update nilai input
      $element.val(formattedDate);

      // Hitung usia
      const birthDate = picker.startDate;
      const today = moment();
      let age = today.diff(birthDate, "years");

      const isBeforeBirthdayThisYear = today.isBefore(birthDate.clone().add(age, "years"));

      if (isBeforeBirthdayThisYear) {
        age--; // Kurangi usia jika belum melewati ulang tahun tahun ini
      }

      // Set nilai usia ke input .age yang terdekat
      $element.closest(".panel-cover").find(".age").val(age);

      //ketika klik apply ,check jika btn lanjut enable atau disable
      checkForms();
    });
}

document.addEventListener("DOMContentLoaded", function () {
  /* delete bg-white default liferay */
  var contentSection = document.getElementById("content");
  if (contentSection) {
    contentSection.classList.remove("bg-white");
  }
});

//Fungsi untuk menginisialisasi ulang datepicker
function initializeDatePicker($element) {
  //    //console.log('reinit....');
  let minDate, maxDate;

  if ($element.hasClass("dob-adult")) {
    minDate = moment().subtract(85, "years");
    maxDate = moment().subtract(17, "years");
  } else if ($element.hasClass("dob-child")) {
    minDate = moment().subtract(17, "years");
    maxDate = moment().subtract(14, "days");
  } else if ($element.hasClass("dob-student")) {
    minDate = moment().subtract(25, "years");
    maxDate = moment().subtract(14, "days");
  } else {
    minDate = moment().subtract(100, "years");
    maxDate = moment();
  }

  // Reinit atau inisialisasi daterangepicker
  $element.daterangepicker({
    parentEl: $element.closest(".dob-wrapper"),
    autoUpdateInput: false,
    singleDatePicker: true,
    showDropdowns: true,
    minDate: minDate,
    maxDate: maxDate,
    startDate: maxDate,
    buttonClasses: "btn-date",
    applyButtonClasses: "btn-apply-ignore",
    cancelClass: "btn-cancel",
    locale: {
      applyLabel: "Pilih",
      cancelLabel: "Batal",
      daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
      monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
    },
  });

  // Event saat apply tanggal
  $element.on("apply.daterangepicker", function (ev, picker) {
    //console.log('Tanggal dipilih:', picker.startDate.format('DD-MM-YYYY'));

    // Format tanggal ke Indonesia
    const day = picker.startDate.format("DD");
    const englishMonth = picker.startDate.format("MMMM");
    const year = picker.startDate.format("YYYY");
    const indonesianMonth = indonesianMonths[englishMonth];
    const formattedDate = day + "/" + indonesianMonth + "/" + year;

    $element.val(formattedDate);

    // Hitung usia
    const birthDate = picker.startDate;
    const today = moment();
    let age = today.diff(birthDate, "years");

    // Cek apakah bulan dan tanggal kelahiran sudah terlewati dalam tahun berjalan
    const isBeforeBirthdayThisYear = today.isBefore(birthDate.clone().add(age, "years"));

    if (isBeforeBirthdayThisYear) {
      age--; // Kurangi usia jika belum melewati ulang tahun tahun ini
    }

    // Set nilai usia ke input .age yang terdekat
    $element.closest(".panel-cover").find(".age").val(age);

    // Cari elemen terdekat dengan kelas .dob-wrapper
    const $dobWrapper = $element.closest(".dob-wrapper");
    if ($dobWrapper.length && $dobWrapper.hasClass("invalid")) {
      $dobWrapper.removeClass("invalid");
    }

    //ketika klik apply ,check jika btn lanjut enable atau disable
    checkForms();
  });

  // Event saat cancel tanggal
  $element.on("cancel.daterangepicker", function (ev, picker) {
    $element.val("");
    $element.closest(".panel-cover").find(".age").val("");
  });
}

// function fetchCountriesDefault() {
//   return new Promise((resolve, reject) => {
//     $.ajax({
//       url: restApiCountriesUrl,
//       method: "GET",
//       dataType: "json",
//       success: function (response) {
//         if (response.status === 1) {
//           resolve(response.data);
//         } else {
//           reject("Error: " + response.status);
//         }
//       },
//       error: function (xhr, status, error) {
//         reject("AJAX Error: " + error);
//       },
//     });
//   });
// }

async function fetchCountries() {
  //console.log('fetch country for repeatorder');
  try {
    const response = await $.ajax({
      url: restApiCountriesUrl,
      method: "GET",
      dataType: "json",
    });

    if (response.status === 1) {
      countriesGlobal = response.data;
    } else {
      throw new Error("Error: " + response.status);
    }
  } catch (error) {
    console.error("AJAX Error: ", error);
    countriesGlobal = []; // handle error (empty data)
  }
}

function htmlCountries(defaultCountry = "Indonesia", selectElement) {
  if (!countriesGlobal.length) return; // Jangan lanjutkan jika data negara kosong

  //console.log('Countries dari global:', countriesGlobal);

  let indonesia = countriesGlobal.find((country) => country.name === "Indonesia");
  let otherCountries = countriesGlobal.filter((country) => country.name !== "Indonesia").sort((a, b) => a.name.localeCompare(b.name));

  let sortedCountries = [];
  if (indonesia) sortedCountries.push(indonesia);
  sortedCountries = sortedCountries.concat(otherCountries);

  // Kosongkan elemen select sebelum mengisi
  selectElement.innerHTML = "";

  // Tambahkan opsi placeholder
  const placeholderOption = document.createElement("option");
  placeholderOption.textContent = "Pilih Negara";
  placeholderOption.value = "";
  selectElement.appendChild(placeholderOption);

  sortedCountries.forEach((country) => {
    const option = document.createElement("option");
    option.value = country.name;
    option.textContent = country.name;
    if (country.name === defaultCountry) {
      option.selected = true;
    }
    selectElement.appendChild(option);
  });

  // Inisialisasi select2 jika diperlukan
  $(selectElement).select2({
    dropdownParent: "#single-journey-wrapper",
    placeholder: "Pilih Negara",
    width: "100%",
    minimumResultsForSearch: 0,
  });
}

async function generateCountryOptions(index, defaultCountry = "Indonesia") {
  // Tunggu data negara dari fetch jika belum ada
  if (!countriesGlobal || countriesGlobal.length === 0) {
    await fetchCountries();
  }

  // Temukan target container berdasarkan class
  const targetContainer = document.querySelector(`.negara_render_container_${index} #single-journey-wrapper`);

  if (targetContainer) {
    // Buat elemen <select> jika belum ada
    let selectElement = targetContainer.querySelector("select");
    if (!selectElement) {
      selectElement = document.createElement("select");
      selectElement.className = "input-control-axa negara";
      selectElement.name = `input_negara_insured_${index}`;
      selectElement.required = true;
      targetContainer.appendChild(selectElement);
    }

    // Gunakan fungsi htmlCountries untuk mengisi opsi
    htmlCountries(defaultCountry, selectElement);
  }
}

function handleRepeatOrder() {
  // Dapatkan session data
  const sessionData = getSessionData("SmartTravelInternationalDataPayload");
  const policyholder = sessionData.policyholder;

  // Set polis
  copyPolisholderToInsuredBeliKembali(policyholder);

  const _adultsList = sessionData.adults;
  const _childrenList = sessionData.children;
  const travellerType = sessionData.travellerType;
  const adult_total = sessionData.AdultTotal;
  const child_total = sessionData.ChildTotal;

  // Membuat payload untuk digunakan dalam proses berikutnya
  const payload = {
    adultsList: _adultsList || [],
    childrenList: _childrenList || [],
    type: travellerType || "",
    adultTotalOld: adult_total || "",
    childTotalOld: child_total || "",
  };

  // Proses data lebih lanjut dengan payload
  renderInsuredFormFromSession(payload);
}

function handleSelection(container) {
  if (container.classList.contains("invalid")) {
    container.classList.remove("invalid");
  }
}

function handleInput(event) {
  const input = event.target;
  // Hanya mengizinkan angka dengan regex
  input.value = input.value.replace(/[^0-9]/g, "");
}

//async function copyPolisholderToInsured() {
//    //console.log('copy value polis holder!!!')
//    // Dapatkan nilai dari field polisholder
//    const polisholderData = {
//        _ispep: getCheckedValue('input[name="input_ispep_polisholder"]'),
//        _fotoktp: '', // Tidak bisa disalin secara langsung karena ini adalah file, bisa handle terpisah
//        _name: getValue('input[name="input_name_polisholder"]'),
//        _ktppaspor: getValue('input[name="input_ktppaspor_polisholder"]'),
//        _dob: getValue('input[name="input_dob_polisholder"]'),
//        _pdob: getValue('input[name="input_pdob_polisholder"]'),
//        _gender: getCheckedValue('input[name="input_gender_polisholder"]'),
//
//        //        _kodenegara: getValue('select[name="input_kodenegara_polisholder"]'),
//        _kodenegara: getValue('input[name="input_kodenegara_polisholder"]'),
//
//        _hp: getValue('input[name="input_hp_polisholder"]'),
//        _negara: getValue('select[name="input_negara_polisholder"]'),
//        _job: getValue('select[name="input_job_polisholder"]'),
//
//        _otherjob: getValue('input[name="input_otherjob_polisholder"]'),
//
//        _ktpkitas: getValue('input[name="input_ktpkitas_polisholder"]'),
//        _age: getValue('input[name="input_age_polisholder"]'),
//        _statuskawin: getValue('select[name="input_status-kawin_polisholder"]'),
//        _telepon: getValue('input[name="input_telepon_polisholder"]'),
//        _email: getValue('input[name="input_email_polisholder"]'),
//        _kodepos: getValue('input[name="input_kodepos_polisholder"]'),
//        _alamat: getValue('input[name="input_alamat_polisholder"]')
//    };
//
//
//    // Set nilai ke field insured_0
//    const gett = document.querySelector('input[name="input_ispep_insured_0"][value="' + polisholderData._ispep + '"]');
//    gett.checked = true;
//    document.querySelector('input[name="input_name_insured_0"]').value = polisholderData._name;
//    document.querySelector('input[name="input_ktppaspor_insured_0"]').value = polisholderData._ktppaspor;
//    document.querySelector('input[name="input_dob_insured_0"]').value = polisholderData._dob;
//    document.querySelector('input[name="input_pdob_insured_0"]').value = polisholderData._pdob;
//    document.querySelector('input[name="input_gender_insured_0"][value="' + polisholderData._gender + '"]').checked = true;
//    document.querySelector('input[name="input_hp_insured_0"]').value = polisholderData._hp;
//    document.querySelector('input[name="input_ktpkitas_insured_0"]').value = polisholderData._ktpkitas;
//    document.querySelector('input[name="input_age_insured_0"]').value = polisholderData._age;
//    document.querySelector('input[name="input_telepon_insured_0"]').value = polisholderData._telepon;
//    document.querySelector('input[name="input_email_insured_0"]').value = polisholderData._email;
//    document.querySelector('input[name="input_kodepos_insured_0"]').value = polisholderData._kodepos;
//    document.querySelector('input[name="input_alamat_insured_0"]').value = polisholderData._alamat;
//
//    document.querySelector('input[name="input_kodenegara_insured_0"]').value = polisholderData._kodenegara;
//
//    document.querySelector('input[name="input_otherjob_insured_0"]').value = polisholderData._otherjob;
//
//
//
//    // Cari elemen img thumbnail terdekat
//    const inputInsured = document.querySelector('input[name="input_fotoktp_insured_0"]');
//    const thumbnailWrapper = inputInsured.closest('.thumbnail-wrapper');
//    const thumbnailInsured = thumbnailWrapper.querySelector('.thumbnail');
//
//	// Set copy image
//    if (window.base64ResultForInsured) {
//    	//console.log('window.base64ResultForInsured>>', window.base64ResultForInsured);
//
//        const dataTransfer = new DataTransfer();
//        dataTransfer.items.add(window.fileForInsured);
//        inputInsured.files = dataTransfer.files;
//
//        if (thumbnailInsured) {
//            thumbnailInsured.src = window.base64ResultForInsured; // Set src dari elemen img
//
//            // Hapus class 'invalid' dari img jika ada
//            if (thumbnailInsured.classList.contains('invalid')) {
//                thumbnailInsured.classList.remove('invalid');
//                //console.log('Class "invalid" telah dihapus dari elemen img');
//            }
//        } else {
//            console.warn('Thumbnail elemen tidak ditemukan.');
//        }
//
//    } else {
//        console.warn('Gambar belum dipilih di polis holder');
//
//        const inputPolis = document.querySelector('input[name="input_fotoktp_polisholder"]');
//        if (inputPolis) {
//            const thumbnailWrapperPolis = inputPolis.closest('.thumbnail-wrapper');
//            const thumbnailPolis = thumbnailWrapperPolis?.querySelector('.thumbnail');
//
//            if (thumbnailPolis && thumbnailInsured) {
//                // Salin src dari thumbnailPolis ke thumbnailInsured
//                thumbnailInsured.src = thumbnailPolis.src;
//
//                // Hapus class 'invalid' dari img insured jika ada
//                if (thumbnailInsured.classList.contains('invalid')) {
//                    thumbnailInsured.classList.remove('invalid');
//                    //console.log('Class "invalid" telah dihapus dari elemen img insured');
//                }
//
//                //console.log('Gambar dari polis telah disalin ke insured.');
//            } else {
//                console.warn('Thumbnail untuk polis atau insured tidak ditemukan.');
//            }
//        } else {
//            console.warn('Input polis tidak ditemukan.');
//        }
//
//    }
//
//
//
//
//     //using select 2
//    const closestContainer = document.querySelector('input[name="input_ktppaspor_insured_0"]').closest('.panel-cover');
//
//    if (closestContainer) {
//        $(closestContainer).find('.status-kawin').val(polisholderData._statuskawin).trigger('change');
//        $(closestContainer).find('.negara').val(polisholderData._negara).trigger('change');
//        $(closestContainer).find('.job').val(polisholderData._job).trigger('change');
//        //$(closestContainer).find('.kode').val(polisholderData._kodenegara).trigger('change');
//    }
//}

// COPY POLIS V2 -> SUPAYA YANG DI COPY BUKAN CUMA src image tapi juga value dari input file nya
async function copyPolisholderToInsured() {
  //console.log('copy value polis holder!!!');

  // Dapatkan nilai dari field polisholder
  const polisholderData = {
    _ispep: getCheckedValue('input[name="input_ispep_polisholder"]'),
    _name: getValue('input[name="input_name_polisholder"]'),
    _ktppaspor: getValue('input[name="input_ktppaspor_polisholder"]'),
    _dob: getValue('input[name="input_dob_polisholder"]'),
    _pdob: getValue('input[name="input_pdob_polisholder"]'),
    _gender: getCheckedValue('input[name="input_gender_polisholder"]'),
    _kodenegara: getValue('input[name="input_kodenegara_polisholder"]'),
    _hp: getValue('input[name="input_hp_polisholder"]'),
    _negara: getValue('select[name="input_negara_polisholder"]'),
    _job: getValue('select[name="input_job_polisholder"]'),
    _otherjob: getValue('input[name="input_otherjob_polisholder"]'),
    _ktpkitas: getValue('input[name="input_ktpkitas_polisholder"]'),
    _age: getValue('input[name="input_age_polisholder"]'),
    _statuskawin: getValue('select[name="input_status-kawin_polisholder"]'),
    _telepon: getValue('input[name="input_telepon_polisholder"]'),
    _email: getValue('input[name="input_email_polisholder"]'),
    _kodepos: getValue('input[name="input_kodepos_polisholder"]'),
    _alamat: getValue('input[name="input_alamat_polisholder"]'),
  };

  // Set nilai ke field insured_0
  document.querySelector('input[name="input_ispep_insured_0"][value="' + polisholderData._ispep + '"]').checked = true;
  document.querySelector('input[name="input_name_insured_0"]').value = polisholderData._name;
  document.querySelector('input[name="input_ktppaspor_insured_0"]').value = polisholderData._ktppaspor;
  document.querySelector('input[name="input_dob_insured_0"]').value = polisholderData._dob;
  document.querySelector('input[name="input_pdob_insured_0"]').value = polisholderData._pdob;
  document.querySelector('input[name="input_gender_insured_0"][value="' + polisholderData._gender + '"]').checked = true;
  document.querySelector('input[name="input_hp_insured_0"]').value = polisholderData._hp;
  document.querySelector('input[name="input_ktpkitas_insured_0"]').value = polisholderData._ktpkitas;
  document.querySelector('input[name="input_age_insured_0"]').value = polisholderData._age;
  document.querySelector('input[name="input_telepon_insured_0"]').value = polisholderData._telepon;
  document.querySelector('input[name="input_email_insured_0"]').value = polisholderData._email;
  document.querySelector('input[name="input_kodepos_insured_0"]').value = polisholderData._kodepos;
  document.querySelector('input[name="input_alamat_insured_0"]').value = polisholderData._alamat;
  document.querySelector('input[name="input_kodenegara_insured_0"]').value = polisholderData._kodenegara;
  document.querySelector('input[name="input_otherjob_insured_0"]').value = polisholderData._otherjob;

  // Copy Foto KTP
  const inputPolis = document.querySelector('input[name="input_fotoktp_polisholder"]');
  const imgPolis = document.querySelector('input[name="img_polisholder"]').value;
  const inputInsured = document.querySelector('input[name="input_fotoktp_insured_0"]');

  const thumbnailWrapper = inputInsured.closest(".thumbnail-wrapper");
  const thumbnailInsured = thumbnailWrapper?.querySelector(".thumbnail");

  if (imgPolis) {
    if (thumbnailInsured) {
      thumbnailInsured.src = imgPolis;
      thumbnailInsured.classList.remove("invalid"); // Hapus class invalid jika ada
    }
  } else if (window.base64ResultForInsured) {
    // Jika sudah ada file yang disimpan sebelumnya
    const dataTransfer = new DataTransfer();
    dataTransfer.items.add(window.fileForInsured);
    inputInsured.files = dataTransfer.files;

    if (thumbnailInsured) {
      thumbnailInsured.src = window.base64ResultForInsured;
      thumbnailInsured.classList.remove("invalid"); // Hapus class invalid jika ada
    }
  } else if (inputPolis && inputPolis.files.length > 0) {
    // Jika tidak ada file tersimpan, ambil dari inputPolis
    const dataTransfer = new DataTransfer();

    for (let i = 0; i < inputPolis.files.length; i++) {
      dataTransfer.items.add(inputPolis.files[i]);
    }

    inputInsured.files = dataTransfer.files; // Set file ke input insured

    // Copy src image jika ada thumbnail
    const thumbnailPolis = inputPolis.closest(".thumbnail-wrapper")?.querySelector(".thumbnail");
    if (thumbnailPolis && thumbnailInsured) {
      thumbnailInsured.src = thumbnailPolis.src;
      thumbnailInsured.classList.remove("invalid");
    }
  } else {
    console.warn("Tidak ada gambar yang bisa disalin.");
  }

  //console.log('isi value file polis>>', inputPolis.files);
  //console.log('isi value file insured 0>>', inputInsured.files);

  // Menggunakan Select2 untuk select dropdown
  const closestContainer = document.querySelector('input[name="input_ktppaspor_insured_0"]').closest(".panel-cover");

  if (closestContainer) {
    $(closestContainer).find(".status-kawin").val(polisholderData._statuskawin).trigger("change");
    $(closestContainer).find(".negara").val(polisholderData._negara).trigger("change");
    $(closestContainer).find(".job").val(polisholderData._job).trigger("change");
  }
}

async function copyPolisholderToInsuredAdditional(iter) {
  const polisholderData = {
    _kodenegara: getValue('input[name="input_kodenegara_polisholder"]'),
    _hp: getValue('input[name="input_hp_polisholder"]'),
    _telepon: getValue('input[name="input_telepon_polisholder"]'),
    _email: getValue('input[name="input_email_polisholder"]'),
    _kodepos: getValue('input[name="input_kodepos_polisholder"]'),
    _alamat: getValue('input[name="input_alamat_polisholder"]'),
  };

  document.querySelector(`input[name="input_hp_insured_${iter}"]`).value = polisholderData._hp;
  document.querySelector(`input[name="input_telepon_insured_${iter}"]`).value = polisholderData._telepon;
  document.querySelector(`input[name="input_email_insured_${iter}"]`).value = polisholderData._email;
  document.querySelector(`input[name="input_kodepos_insured_${iter}"]`).value = polisholderData._kodepos;
  document.querySelector(`input[name="input_alamat_insured_${iter}"]`).value = polisholderData._alamat;
  document.querySelector(`input[name="input_kodenegara_insured_${iter}"]`).value = polisholderData._kodenegara;

  const closestContainer = document.querySelector(`input[name="input_ktppaspor_insured_${iter}"]`).closest(".panel-cover");
}

async function copyPolisholderToInsuredBeliKembali(polisholderData) {
  //find container polis
  const closestContainer = document.querySelector('input[name="input_ktppaspor_polisholder"]').closest(".panel-cover");

  //fetch countries await
  await fetchCountries();

  //set country
  const selectElement = closestContainer.querySelector("select");
  // Tambahkan negara ke dropdown menggunakan htmlCountries
  htmlCountries(`${polisholderData._negara ?? ""}`, selectElement);

  // Format tanggal secara langsung jika polisholderData._dob tersedia
  polisholderData._dob = new Date(polisholderData._dob).toLocaleDateString("id-ID", { day: "2-digit", month: "2-digit", year: "numeric" });

  //console.log('polisholderData._dob >>'+polisholderData._dob);
  const dobformatted = polisholderData._dob; // Contoh: "16/01/2008"
  //console.log('dobformatted >>'+dobformatted);

  // Update tanggal lahir
  const dateofbirth = dobformatted;
  const formattedDOB = dateofbirth.replace(/-/g, "/"); // Ubah tanda - ke /

  if (dateofbirth) {
    //console.log('masuk')
    // Gunakan moment.js untuk memformat
    const formattedDOBToSet = moment(formattedDOB, "DD/MM/YYYY");
    const day = formattedDOBToSet.format("DD");
    const englishMonth = formattedDOBToSet.format("MMMM");
    const year = formattedDOBToSet.format("YYYY");

    // Ambil bulan dari deklarasi indonesianMonths
    const indonesianMonth = indonesianMonths[englishMonth];
    const formattedDate = `${day}/${indonesianMonth}/${year}`;

    // Perbarui input tanggal lahir
    const dobInputClosest = closestContainer.querySelector(".dob");
    if (dobInputClosest) {
      dobInputClosest.value = formattedDate; // Set nilai input

      //console.log('Tanggal sebelum init:', $(dobInputClosest).val(), 'Start date:', formattedDOBToSet);
      initDatepickerFromScan(dobInputClosest, formattedDOBToSet);

      dobInputClosest.closest(".dob-wrapper").classList.remove("invalid"); // Hapus class invalid jika ada
    }

    // Hitung usia berdasarkan tanggal lahir
    const birthDate = moment(formattedDOB, "DD/MM/YYYY");
    const today = moment();
    let age = today.diff(birthDate, "years");

    // Periksa apakah ulang tahun tahun ini sudah lewat
    const isBeforeBirthdayThisYear = today.isBefore(birthDate.clone().add(age, "years"));

    if (isBeforeBirthdayThisYear) {
      age--; // Kurangi usia jika ulang tahun belum lewat
    }

    // Perbarui input usia
    const ageInputClosest = closestContainer.querySelector(".age");
    if (ageInputClosest) {
      ageInputClosest.value = age;
    }
  }

  //console.log('data polis session : ' + polisholderData);

  // Set nilai ke field insured_0
  const gett = document.querySelector('input[name="input_ispep_polisholder"][value="' + polisholderData._ispep + '"]');
  gett.checked = true;
  document.querySelector('input[name="input_name_polisholder"]').value = polisholderData._name;
  document.querySelector('input[name="input_ktppaspor_polisholder"]').value = polisholderData._ktppaspor;
  document.querySelector('input[name="input_pdob_polisholder"]').value = polisholderData._pdob;
  document.querySelector('input[name="input_gender_polisholder"][value="' + polisholderData._gender + '"]').checked = true;
  document.querySelector('input[name="input_hp_polisholder"]').value = polisholderData._hp;
  document.querySelector('input[name="input_ktpkitas_polisholder"]').value = polisholderData._ktpkitas;
  document.querySelector('input[name="input_age_polisholder"]').value = polisholderData._age;
  document.querySelector('input[name="input_telepon_polisholder"]').value = polisholderData._telepon;
  document.querySelector('input[name="input_email_polisholder"]').value = polisholderData._email;
  document.querySelector('input[name="input_kodepos_polisholder"]').value = polisholderData._kodepos;
  document.querySelector('input[name="input_alamat_polisholder"]').value = polisholderData._alamat;

  document.querySelector('input[name="input_kodenegara_polisholder"]').value = polisholderData._kodenegara;

  document.querySelector('input[name="input_otherjob_polisholder"]').value = polisholderData._otherjob;

  let _roStat = false;
  let _modifyStat = false;
  let __sessData = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
  if (__sessData) {
    __sessData = JSON.parse(__sessData);
    if (__sessData.ro !== undefined) {
      _roStat = __sessData.ro;
    }
    if (__sessData.modify !== undefined) {
      _modifyStat = __sessData.modify;
    }
  }

  //set photo
  //  if(!_roStat && !_modifyStat) {
  if (polisholderData._photoUrl !== undefined) {
    let photoUrl;

    if (polisholderData._photoUrl != null) {
      // && polisholderData._photoUrl.includes('/document')) {
      photoUrl = polisholderData._photoUrl;
      document.querySelector('input[name="img_polisholder"]').value = photoUrl;
    } else {
      photoUrl = "/o/mypage-theme/images/ktp-image.png";
    }

    const imgElement = closestContainer.querySelector(".thumbnail");
    imgElement.src = photoUrl; // Setel URL gambar
    //		  }
  } else {
    const imgElement = closestContainer.querySelector(".thumbnail");
    imgElement.src = "/o/mypage-theme/images/ktp-image.png";
  }

  if (closestContainer) {
    $(closestContainer).find(".status-kawin").val(polisholderData._statuskawin).trigger("change");
    $(closestContainer).find(".negara").val(polisholderData._negara).trigger("change");
    $(closestContainer).find(".job").val(polisholderData._job).trigger("change");
  }

  //AFTER COPY CHECK IF UTAMA SAME POLIS
  //checkDataAndSetCheckbox();
}

function resetInsuredFields(index) {
  document.querySelector('input[name="input_hp_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_telepon_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_email_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_kodepos_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_alamat_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_kodenegara_insured_' + index + '"]').value = "";
}

function resetInsuredFieldsAll(index) {
  document.querySelector('input[name="input_ispep_insured_' + index + '"]').checked = false;
  document.querySelector('input[name="input_name_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_ktppaspor_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_dob_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_pdob_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_gender_insured_' + index + '"]').checked = false;
  document.querySelector('input[name="input_hp_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_ktpkitas_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_age_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_telepon_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_email_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_kodepos_insured_' + index + '"]').value = "";
  document.querySelector('input[name="input_alamat_insured_' + index + '"]').value = "";

  document.querySelector('input[name="input_kodenegara_insured_' + index + '"]').value = "";

  const otherJobInput = document.querySelector(`input[name="input_otherjob_insured_${index}"]`);
  if (otherJobInput) {
    otherJobInput.value = "";
  } else {
    console.warn(`Elemen input[name="input_otherjob_insured_${index}"] tidak ditemukan.`);
  }

  document.querySelector('input[name="input_fotoktp_insured_' + index + '"]').value = "";

  const inputInsured = document.querySelector(`input[name="input_fotoktp_insured_${index}"]`);
  const thumbnailInsured = inputInsured.closest(".thumbnail-wrapper").querySelector(".thumbnail");
  if (thumbnailInsured) {
    thumbnailInsured.src = "/o/mypage-theme/images/ktp-image.png";
  }

  //using select 2
  const closestContainer = inputInsured.closest(".panel-cover");

  if (closestContainer) {
    // Set nilai select2 dalam container terdekat
    $(closestContainer).find(".status-kawin").val(null).trigger("change");
    $(closestContainer).find(".negara").val(null).trigger("change");
    $(closestContainer).find(".job").val(null).trigger("change");
    //$(closestContainer).find('.kode').val(null).trigger('change');
  }
}

function checkDataAndSetCheckbox() {
  const data1 = getValue('input[name="input_ktppaspor_polisholder"]');
  const data2 = getValue('input[name="input_ktppaspor_insured_0"]');

  if (data1 === data2) {
    // Cari checkbox dalam checkbox-container
    const checkboxContainer = document.querySelector(".checkbox-container");
    const checkboxInput = checkboxContainer.querySelector(".checkbox-container .checkbox-input");

    if (checkboxInput) {
      checkboxContainer.classList.add("checked");
      checkboxInput.checked = true; // Centang checkbox

      $(".panel-cover.policy_holder").find("input, select, textarea, button").prop("disabled", true);
    } else {
      console.error("Checkbox tidak ditemukan di dalam checkbox-container.");
    }
  } else {
    //console.log('Data tidak cocok, checkbox tidak dicentang.');

    $(".panel-cover.policy_holder").find("input, select, textarea, button").prop("disabled", false);
  }
}

function renderCheckboxSection(container) {
  //console.log('call renderCheckboxSection');
  // Create the outer container div
  const outerDiv = document.createElement("div");
  outerDiv.className = "pb-2level";

  // Create the flex container
  const flexContainer = document.createElement("div");
  flexContainer.className = "display-flex align-items-center";

  // Hidden checkbox input
  const checkboxInput = document.createElement("input");
  checkboxInput.type = "checkbox";
  checkboxInput.id = "custom-checkbox";
  checkboxInput.className = "display-hidden";

  // Label for the checkbox
  const label = document.createElement("label");
  label.htmlFor = "custom-checkbox-x";
  label.className = "display-flex align-items-center";

  // Checkbox container div
  const checkboxContainer = document.createElement("div");
  checkboxContainer.className =
    "checkbox-container w-4level h-4level agency__border-border-gray-300 agency__rounded-sm display-flex align-items-center agency__justify-center mr-2level position-relative";

  // Inner hidden checkbox input
  const innerCheckbox = document.createElement("input");
  innerCheckbox.type = "checkbox";
  innerCheckbox.className = "display-hidden checkbox-input";
  innerCheckbox.name = "insuredIsPolis";

  // SVG for the custom checkbox
  const svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");

  svg.setAttribute("class", "checkboxSamePolis display-hidden agency__bg-axa-blue-400 w-4level h-4level agency__text-white position-absolute");
  svg.setAttribute("xmlns", "http://www.w3.org/2000/svg");
  svg.setAttribute("fill", "none");
  svg.setAttribute("viewBox", "0 0 24 24");
  svg.setAttribute("stroke", "currentColor");

  // Path for the SVG
  const path = document.createElementNS("http://www.w3.org/2000/svg", "path");
  path.setAttribute("stroke-linecap", "round");
  path.setAttribute("stroke-linejoin", "round");
  path.setAttribute("stroke-width", "2");
  path.setAttribute("d", "M5 13l4 4L19 7");
  svg.appendChild(path);

  // Span for the checkbox description
  const span = document.createElement("span");
  span.className = "checkBoxSpanDataSamePolis agency__pointer";
  span.textContent = "Data Tertanggung Utama sama dengan data pemegang polis";

  // Append elements to build the structure
  checkboxContainer.appendChild(innerCheckbox);
  checkboxContainer.appendChild(svg);
  label.appendChild(checkboxContainer);
  label.appendChild(span);
  flexContainer.appendChild(checkboxInput);
  flexContainer.appendChild(label);
  outerDiv.appendChild(flexContainer);

  // Append the entire structure to the desired location in the DOM
  container.appendChild(outerDiv);
}

// Render form insured
function renderInsuredForm() {
  let count = totalInsured;
  const mainContainer = document.getElementById("container-generate-insured");
  mainContainer.innerHTML = "";

  for (let i = 0; i < count; i++) {
    let isChild = false;

    if (travellerType === "Individual") {
      // Individual selalu dewasa
      isChild = false;
    } else if (travellerType === "Duo") {
      // Duo: 1 dewasa dan 1 anak -> iterasi 0 dewasa, iterasi 1 anak
      // Duo: 2 dewasa dan 0 anak -> iterasi 0 dan 1 adalah dewasa
      if (totalChild > 0) {
        isChild = i === 1; // Iterasi 1 adalah anak
      } else {
        isChild = false; // Kedua iterasi dewasa
      }
    } else if (travellerType === "Family") {
      // Family: 1 dewasa dan beberapa anak
      if (totalAdult === 1 && totalChild > 0) {
        // Iterasi pertama dewasa, setelahnya anak
        isChild = i > 0;
      }
      // Family: 2 dewasa dan beberapa anak
      else if (totalAdult === 2 && totalChild > 0) {
        // Iterasi pertama dan kedua dewasa, setelahnya anak
        isChild = i > 1;
      } else {
        // 2 dewasa dan 0 anak, seluruhnya dewasa
        isChild = false;
      }
    }

    // Hitung offset berdasarkan iterasi loop
    const baseTabIndex = (i + 1) * 100;

    // Container untuk menyimpan elemen yang akan dirender
    const container = document.createElement("div");
    container.className = "panel-cover pt-10level mt-10level px-10level container-form mobile-view";

    // Header
    const headerDiv = document.createElement("div");
    headerDiv.className = "flex-justify-between align-items-center";
    const title = document.createElement("h1");
    title.className = "agency__text-xl agency__font-bold";
    if (i === 0) {
      title.textContent = "Data Tertanggung Utama";
    } else {
      title.textContent = "Data Tertanggung " + (i + 1);
    }

    title.style.textAlign = "left"; // Default untuk semua perangkat
    if (window.innerWidth <= 768) {
      // Breakpoint untuk perangkat mobile
      title.style.fontSize = "22px"; // Ukuran font spesifik untuk mobile
    }

    headerDiv.appendChild(title);

    //        if (i === 0) {
    // Button untuk toggle accordion
    const toggleButton = document.createElement("button");
    //toggleButton.id = 'btn__accordion-toggle';
    toggleButton.className = "btn__accordion-toggle flex-justify-center align-items-center agency__w-10__h-10 agency__bg-axa-blue-400 agency__text-white";
    toggleButton.innerHTML = '<i id="accordion-icon" class="accordion-icon fas fa-chevron-down agency__text-xs"></i>';

    headerDiv.appendChild(toggleButton);
    //        }

    container.appendChild(headerDiv);

    // Create the checkbox element if index is 0
    if (i === 0) {
      renderCheckboxSection(container);
    }

    // Child collapse untuk tertanggung utama
    const collapseDiv = document.createElement("div");
    //        if (i === 0) {
    collapseDiv.id = "collapse" + i;
    //        }
    collapseDiv.className = "accordion-collapse show";

    const insuredFormDiv = document.createElement("div");
    insuredFormDiv.className = "insured-form";

    const ispepDiv = document.createElement("div");
    ispepDiv.className = "ispep";
    ispepDiv.innerHTML =
      "<span>" +
      "Apakah pemegang polis termasuk ke dalam kategori Orang yang " +
      '<span class="agency__text-axa-sienna-400"> Populer secara politisi / ' +
      '<span class="agency__italic">Politically Exposed Persons </span> (PEP) </span> ?' +
      "</span>" +
      '<a class="btn--white__step3 ml-2level agency__pointer" href="javascript:;" onclick="openModal()" >' +
      '<span> Baca Selengkapnya <i class="fas fa-arrow-right"></i> </span>' +
      "</a>" +
      '<div class="radio-group ispep-container">' +
      "<div>" +
      '<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">' +
      '<input id="no' +
      i +
      '" class="radio-custom ispepInputNo" name="input_ispep_insured_' +
      i +
      '" type="radio" value="0" required="required"/>' +
      '<label for="no' +
      i +
      '" class="radio-custom-label mb-0"><span>Tidak</span></label>' +
      "</div>" +
      "</div>" +
      "<div>" +
      '<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">' +
      '<input id="yes' +
      i +
      '" class="radio-custom ispepInputYes" name="input_ispep_insured_' +
      i +
      '" type="radio" value="1" required="required"/>' +
      '<label for="yes' +
      i +
      '" class="radio-custom-label mb-0">' +
      "<span>" +
      "Iya" +
      '<span class="ispepYes">(Data Anda akan kami tinjau untuk melewati persetujuan dari Underwriting)</span>' +
      "</span>" +
      "</label>" +
      "</div>" +
      "</div>" +
      "</div>";

    insuredFormDiv.appendChild(ispepDiv);

    const formColumnDiv = document.createElement("div");
    formColumnDiv.className = "form-column display-flex agency__flex-wrap gap-4level";
    const form = document.createElement("form");
    form.className = "display-flex agency__flex-wrap gap-4level";

    // Kolom Kiri
    const leftColumn = document.createElement("div");
    leftColumn.className = "agency__flex-1 agency__min-w-300px";

    //negara
    const negaraDiv = document.createElement("div");
    negaraDiv.innerHTML =
      "<div>" +
      '<label for="negara">Kewarganegaraan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
      '<div id="single-journey-wrapper" class="position-relative negara-container">' +
      '<select class="input-control-axa negara" name="input_negara_insured_' +
      i +
      '" required>' +
      "<!-- Options will be dynamically added by JavaScript -->" +
      "</select>" +
      "</div>" +
      "</div>";

    //foto ktp
    const fotoDiv = document.createElement("div");
    fotoDiv.innerHTML =
      '<div class="upload-container">' +
      '<label for="upload"> Upload File (Paspor/KTP/KITAS) <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
      '<div class="thumbnail-wrapper">' +
      '<img class="thumbnail img-thumbnail img-fluid" src="/o/mypage-theme/images/ktp-image.png" alt="foto ktp" />' +
      '<div class="loading-icon"> Memindai OCR  <i class="fas fa-spinner fa-spin"></i></div>' +
      '<div class="ml-5level mt-2level agency__pointer">' +
      '<span class="file-name agency__text-xs"></span>' +
      //'<button type="button" class="uploadButton agency__pointer">Pilih File</button>' +

      '<a style="text-align: center; width: 100px; font-size: 12px;" class="uploadButton btn btn__agency btn--dark-blue width-full">' +
      '<span class="position-relative agency__uppercase agency__pointer">' +
      "Pilih File" +
      "</span>" +
      "</a>" +
      "</div>" +
      '<input type="file" class="fileInput input_fotoktp_insured_' +
      i +
      ' display-hidden docupload" accept="image/*" name="input_fotoktp_insured_' +
      i +
      '" />' +
      '<input type="hidden" name="img_insured_' +
      i +
      '" class="imgupload"/>' +
      "</div>" +
      "</div>";

    //<!-- name -->
    const nameDiv = document.createElement("div");
    nameDiv.innerHTML = `<div> <label for="name"> Nama lengkap sesuai Paspor/KTP/KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputName" placeholder="Tulis Nama" name="input_name_insured_${i}" type="text" required="required" oninput="handleInputHurufDanSpasi(event)" tabindex="${
      baseTabIndex + 1
    }" /> </div> </div>`;

    //Hubungan
    const hubunganDiv = document.createElement("div");
    let hubunganOptions = "";

    if (travellerType === "Individual") {
      hubunganOptions = '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>';
    } else if (travellerType === "Duo") {
      if (totalAdult === 2) {
        hubunganOptions = i === 0 ? '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>' : '<option value="Kerabat">Kerabat</option><option value="Teman">Teman</option>';
      } else if (totalAdult === 1) {
        // 1 adult and 1 child
        hubunganOptions = i === 0 ? '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>' : '<option value="Kerabat">Kerabat</option><option value="Teman">Teman</option>';
      }
    } else if (travellerType === "Family") {
      if (totalAdult === 1) {
        hubunganOptions =
          i === 0 ? '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>' : '<option value="Anak">Anak</option><option value="Anak / Pelajar">Anak / Pelajar</option>';
      } else if (totalAdult === 2) {
        hubunganOptions =
          i === 0
            ? '<option value="Tertanggung Utama" selected>Tertanggung Utama</option>'
            : i === 1
            ? '<option value="Pasangan">Pasangan</option>'
            : '<option value="Anak">Anak</option><option value="Anak / Pelajar">Anak / Pelajar</option>';
      }
    }

    hubunganDiv.innerHTML = `<div class="hubunganDiv"> <label for="relationship">Hubungan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div id="single-journey-wrapper" class="position-relative relationship-container"> <select class="input-control-axa relationship" name="input_relationship_insured_${i}" tabindex="${
      baseTabIndex + 4
    }" required>
            <option></option> ${hubunganOptions} 
            </select> </div> </div>`;

    //<!-- dob -->
    let dobType = "dob-adult";

    if (travellerType === "Individual") {
      dobType = "dob-adult"; // Individual selalu dewasa
    } else if (travellerType === "Duo") {
      if (totalChild > 0) {
        // Jika Duo dan ada anak, iterasi pertama dewasa, kedua anak
        dobType = i === 1 ? "dob-child" : "dob-adult";
      } else {
        // Duo dengan 2 dewasa
        dobType = "dob-adult";
      }
    } else if (travellerType === "Family") {
      if (totalAdult === 1 && totalChild > 0) {
        // 1 dewasa dan anak-anak, iterasi pertama dewasa, selebihnya anak
        dobType = i > 0 ? "dob-child" : "dob-adult";
      } else if (totalAdult === 2 && totalChild > 0) {
        // 2 dewasa dan anak-anak, iterasi pertama dan kedua dewasa, selebihnya anak
        dobType = i > 1 ? "dob-child" : "dob-adult";
      } else {
        // 2 dewasa dan tidak ada anak
        dobType = "dob-adult";
      }
    }

    const dobDiv = document.createElement("div");
    dobDiv.innerHTML = `<div> <label class="display-block" for="dateofbirth">Tanggal Lahir <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="calendar-wrapper position-relative" id="calendar-wrapper-claim"> <div class="calendar-col position-relative dob-wrapper"> <input style="color: #00008f;" class="input-control-axa input-control-axa--outline input-icon-date dob ${dobType}" type="text" name="input_dob_insured_${i}" autocomplete="off" placeholder="Pilih Tanggal Lahir" readonly="readonly" required="required" tabindex="${
      baseTabIndex + 5
    }" /> </div> </div> </div>`;

    //<!-- place -->
    const placeDiv = document.createElement("div");
    placeDiv.innerHTML = `<div class="place"> <label for="place"> Tempat Lahir <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputPlaceOfBirth" placeholder="Tulis Tempat Lahir" name="input_pdob_insured_${i}" type="text" required="required" oninput="handleInputHurufDanSpasi(event)" tabindex="${
      baseTabIndex + 6
    }" /> </div> </div>`;

    //<!-- gender -->
    const genderDiv = document.createElement("div");
    genderDiv.className = "gender_container";
    genderDiv.innerHTML = `<label for="gender">Jenis Kelamin <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="form-radio-wrapper display-flex"> <div class="display-flex gender-container"> <div class="form-radio mr-8px"> <input class="classInputGenderMale" type="radio" name="input_gender_insured_${i}" value="M" required="required" tabindex="${
      baseTabIndex + 8
    }" /> <div class="box-radio-wrapper agency__text-center"> <div class="box-radio"> <img src="/o/mypage-theme/images/man-nb.png" alt="laki" /> </div> <div class="box-text">Laki-Laki</div> </div> </div> <div class="form-radio"> <div class="form-radio-input"> <input type="radio" name="input_gender_insured_${i}" value="F" class="form-control classInputGenderFemale" required="required" /> <div class="box-radio-wrapper agency__text-center"> <div class="box-radio"> <img src="/o/mypage-theme/images/woman-nb.png" alt="perempuan" /> </div> <div class="box-text">Perempuan</div> </div> </div> </div> </div>  </div>`;

    const checkboxDiv = document.createElement("div");
    checkboxDiv.className = "pb-2level"; // Pastikan diberi margin agar tidak terlalu rapat

    // Membuat label dan checkbox
    checkboxDiv.innerHTML = `
            <div class="display-inline-flex align-items-center checkbox-custom-wrapper checkbox-container2">
                <input id="custom-checkbox-${i}" class="checkbox-custom hour checkbox-input" name="insuredIsPolis" type="checkbox" /> 
                <label for="custom-checkbox-${i}" class="checkbox-custom-label">
                    <span class="checkBoxSpanDataSamePolis2 ml-2level agency__pointer agency__uppercase">
                        Data sama dengan pemegang polis
                    </span>
                </label>
            </div>
        `;

    //<!-- Kode negara dan telepon -->
    const kodeDiv = document.createElement("div");
    kodeDiv.className = "kodenegara_container";
    kodeDiv.innerHTML = `<label for="kode">Kode Negara dan Telepon </label> <div class="input-group-axa input-group-axa--border"> <input style="border: none;" class="input-control-axa" placeholder="Tulis Kode Negara" name="input_kodenegara_insured_${i}" type="text" maxlength="5" oninput="handleInput(event)" tabindex="${
      baseTabIndex + 10
    }"> </div>`;
    //'<div> <label for="kode">Kode Negara dan Telepon </label> <div id="single-journey-wrapper" class="position-relative"> <select class="input-control-axa kode" name="input_kodenegara_insured_' + i + '"> </select> </div> </div>';

    //<!-- hp -->
    const hpDiv = document.createElement("div");
    hpDiv.innerHTML = `<div> <label for="hp"> Nomor Handphone <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Nomor Handphone" name="input_hp_insured_${i}" type="text" maxlength="15" required="required" oninput="handleInput(event)" tabindex="${
      baseTabIndex + 12
    }"/> </div> </div>`;

    //<!-- kode pos -->
    const posDiv = document.createElement("div");
    posDiv.innerHTML = `<div> <label for="kodepos">Kode Pos <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Kode Pos" name="input_kodepos_insured_${i}" type="text" required="required" maxlength="5" oninput="handleInput(event)" tabindex="${
      baseTabIndex + 14
    }" /> </div> </div>`;

    //append left
    leftColumn.appendChild(negaraDiv); //update negara sebelum upload file
    leftColumn.appendChild(fotoDiv);
    leftColumn.appendChild(nameDiv);
    leftColumn.appendChild(hubunganDiv);
    leftColumn.appendChild(dobDiv);
    leftColumn.appendChild(placeDiv);
    leftColumn.appendChild(genderDiv);

    //        if(i > 0){
    leftColumn.appendChild(checkboxDiv);
    //        }

    leftColumn.appendChild(kodeDiv);
    leftColumn.appendChild(hpDiv);
    leftColumn.appendChild(posDiv);

    // Kolom Kanan
    const rightColumn = document.createElement("div");
    rightColumn.className = "agency__flex-1 agency__min-w-300px";

    //<!-- passpor -->
    const pasporDiv = document.createElement("div");
    pasporDiv.innerHTML = `<div class="mt-desktop-only__mt-321px"> <label for="ktppaspor"> Nomor KTP / KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputKtpKitas" placeholder="Tulis No. KTP / KITAS" name="input_ktpkitas_insured_${i}" type="text" maxlength="16" required="required" oninput="handleInput(event)" tabindex="${
      baseTabIndex + 2
    }" /> </div> </div>`;

    //<!-- ktppasspor -->
    const ktppasporDiv = document.createElement("div");
    ktppasporDiv.innerHTML = `<div><label> Nomor Paspor <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputPaspor passport-field" placeholder="Tulis Nomor Paspor" name="input_ktppaspor_insured_${i}" type="text" maxlength="16" required="required" tabindex="${
      baseTabIndex + 3
    }" /> </div> </div>`;

    //<!-- age -->
    const ageDiv = document.createElement("div");
    ageDiv.innerHTML = `<div> <label for="age"> Usia </label> <div class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome"> <input disabled="disabled" class="input-control-axa age" placeholder="0" name="input_age_insured_${i}" type="text" readonly="readonly" /> <span class="font_tahun">Tahun</span> </div> </div>`;

    /*job move here*/
    //<!-- job -->

    const jobDiv = document.createElement("div");
    const statusKawinDiv = document.createElement("div");

    if (!isChild) {
      //        	//console.log('adult generate job and status!!');

      jobDiv.className = "job-container-wrapper";
      jobDiv.innerHTML = `<label for="job">Pekerjaan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span></label>
				    <div id="single-journey-wrapper" class="position-relative job-container">
				        <select class="input-control-axa job" name="input_job_insured_${i}" tabindex="${baseTabIndex + 7}" required>
				            <option></option>
				            <option value="Pelajar/Mahasiswa">Pelajar/Mahasiswa</option>
				            <option value="Karyawan Swasta">Karyawan Swasta</option>
				            <option value="TNI/POLRI">TNI/POLRI</option>
				            <option value="PNS">PNS</option>
				            <option value="Ibu Rumah Tangga">Ibu Rumah Tangga</option>
				            <option value="Wiraswasta">Wiraswasta</option>
				            <option value="Lainnya">Lainnya</option>
				        </select>
				    </div>
				    <div class="other-job-wrapper agency__hidden" style="margin-top: 20px">
				        <div class="input-group-axa input-group-axa--border">
				            <input class="input-control-axa otherjob" placeholder="Tulis Pekerjaan" name="input_otherjob_insured_${i}" tabindex="${baseTabIndex + 7}" type="text">
				        </div>
				    </div>
				    `;

      // <!-- status kawin -->
      statusKawinDiv.innerHTML = `<div> <label for="status-kawin">Status Perkawinan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div id="single-journey-wrapper" class="position-relative status-kawin-container"> <select class="input-control-axa status-kawin" name="input_status-kawin_insured_${i}" tabindex="${
        baseTabIndex + 9
      }" required> <option></option> <option value="Belum Menikah">Belum Menikah</option> <option value="Sudah Menikah">Sudah Menikah</option> </select> </div> </div>`;
    }

    //<!-- telepon -->
    const teleponDiv = document.createElement("div");
    teleponDiv.className = isChild
      ? "telepondiv_child" // 505px
      : "telepondiv_adult"; // 267px

    teleponDiv.innerHTML = `<div class="input-group-axa input-group-axa--border"> <input style="border: none;" class="input-control-axa" placeholder="Tulis Nomor Telepon" name="input_telepon_insured_${i}" type="text" oninput="handleInput(event)" maxlength="15" tabindex="${
      baseTabIndex + 11
    }" /> </div>`;

    //<!-- email -->
    const emailDiv = document.createElement("div");
    emailDiv.className = "emaildiv";
    emailDiv.innerHTML = `<label for="email">Email <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa email" placeholder="Tulis email" name="input_email_insured_${i}" type="text" required="required" tabindex="${
      baseTabIndex + 13
    }" /> </div>`;

    //<!-- kode pos -->
    /*const posDiv = document.createElement('div');
        posDiv.innerHTML =
            `<div> <label for="kodepos">Kode Pos <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Kode Pos" name="input_kodepos_insured_${i}" type="text" required="required" maxlength="5" oninput="handleInput(event)" tabindex="${baseTabIndex + 14}" /> </div> </div>`;
            */

    //append right
    //rightColumn.appendChild(negaraDiv);
    rightColumn.appendChild(pasporDiv);
    rightColumn.appendChild(ktppasporDiv);
    rightColumn.appendChild(ageDiv);

    if (!isChild) {
      rightColumn.appendChild(jobDiv);
      rightColumn.appendChild(statusKawinDiv);
    }

    rightColumn.appendChild(teleponDiv);
    rightColumn.appendChild(emailDiv);
    //rightColumn.appendChild(posDiv);

    // Alamat
    const alamatDiv = document.createElement("div");
    alamatDiv.className = "alamatdiv";
    alamatDiv.innerHTML = `<label for="alamat">Alamat Lengkap <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>
            <div class="input-group-axa input-group-axa--border">
            <input class="input-control-axa classInputAddress" placeholder="Tulis Alamat Lengkap" name="input_alamat_insured_${i}" tabindex="${
      baseTabIndex + 15
    }" required="required" maxlength="254" oninput="handleInputHurufAngkaDanKarakterAlamat(event)" ></input></div>`;

    form.appendChild(leftColumn);
    form.appendChild(rightColumn);
    form.appendChild(alamatDiv);
    formColumnDiv.appendChild(form);
    insuredFormDiv.appendChild(formColumnDiv);
    collapseDiv.appendChild(insuredFormDiv);
    container.appendChild(collapseDiv);

    // Menambahkan container ke body atau elemen yang diinginkan
    mainContainer.appendChild(container);
  }
}

// FUNGSI CALL PAYLOAD FROM SESSION CHECK DATA EXIST
function getSessionData(key) {
  let sessionData = sessionStorage.getItem(key); // bisa gunakan localStorage jika data ada di sana
  return sessionData ? JSON.parse(sessionData) : null; // Pastikan kita mengembalikan data yang di-parse jika ada
}

function renderInsuredFormFromSession(payload) {
  const { adultsList, childrenList, type, adultTotalOld, childTotalOld } = payload;

  let count = totalInsured;
  let totalAdultPropose = totalAdult;
  let totalAdultExisting = adultTotalOld;

  const mainContainer = document.getElementById("container-generate-insured");
  mainContainer.innerHTML = ""; // Clear previous content

  let idxchild = 0;
  for (let i = 0; i < count; i++) {
    let isChild = false;

    if (travellerType === "Individual") {
      // Individual selalu dewasa
      isChild = false;
    } else if (travellerType === "Duo") {
      // Duo: 1 dewasa dan 1 anak -> iterasi 0 dewasa, iterasi 1 anak
      // Duo: 2 dewasa dan 0 anak -> iterasi 0 dan 1 adalah dewasa
      if (totalChild > 0) {
        isChild = i === 1; // Iterasi 1 adalah anak
      } else {
        isChild = false; // Kedua iterasi dewasa
      }
    } else if (travellerType === "Family") {
      // Family: 1 dewasa dan beberapa anak
      if (totalAdult === 1 && totalChild > 0) {
        // Iterasi pertama dewasa, setelahnya anak
        isChild = i > 0;
      }
      // Family: 2 dewasa dan beberapa anak
      else if (totalAdult === 2 && totalChild > 0) {
        // Iterasi pertama dan kedua dewasa, setelahnya anak
        isChild = i > 1;
      } else {
        // 2 dewasa dan 0 anak, seluruhnya dewasa
        isChild = false;
      }
    }

    //console.log(`Iterasi ${i}: ${isChild ? 'Anak' : 'Dewasa'}`);

    // const insuredData = insuredList[i] || {}; // get berdasarkan i atau jika  < i buat kosong
    // //console.log(`Insured ${i}:`, insuredData);

    // Iterasi dari data sebelumnya (session) = beli kembali
    let insuredData = {};
    if (isChild) {
      if (totalAdultPropose < totalAdultExisting) {
        //kalau di existing 2 dewasa tapi yg di request baru 1, maka ambil data child ke iterasi - 1 , biar matching
        insuredData = childrenList[i - 1] || {};
      } else {
        // jika beli kembali pilih dewasa 2

        if (totalChild < childTotalOld) {
          //jika total child yg dipilih < total child saat beli pertama/sebelumnya

          //console.log('index anak to get (jika dewasa = 2 tapi jumlah anak < jumlah sebelumnya ) >> ' + idxchild );

          insuredData = childrenList[idxchild] || {}; // Ambil data dari childrenList jika isChild

          idxchild++;
        } else {
          insuredData = childrenList[idxchild] || {}; // Ambil data dari childrenList jika isChild
          idxchild++;
        }
      }
    } else {
      insuredData = adultsList[i] || {}; // Ambil data dari adultsList jika isChild adalah false
    }

    // console.log(`Insured ${i}:`, insuredData);

    // Hitung offset berdasarkan iterasi loop
    const baseTabIndex = (i + 1) * 100;

    // Container untuk menyimpan elemen yang akan dirender
    const container = document.createElement("div");
    container.className = "panel-cover pt-10level mt-10level px-10level container-form mobile-view";

    // Header
    const headerDiv = document.createElement("div");
    headerDiv.className = "flex-justify-between align-items-center";
    const title = document.createElement("h1");
    title.className = "agency__text-xl agency__font-bold";
    if (i === 0) {
      title.textContent = "Data Tertanggung Utama";
    } else {
      title.textContent = "Data Tertanggung " + (i + 1);
    }

    title.style.textAlign = "left"; // Default untuk semua perangkat
    if (window.innerWidth <= 768) {
      // Breakpoint untuk perangkat mobile
      title.style.fontSize = "22px"; // Ukuran font spesifik untuk mobile
    }

    headerDiv.appendChild(title);

    //        if (i === 0) {
    // Button untuk toggle accordion
    const toggleButton = document.createElement("button");
    //toggleButton.id = 'btn__accordion-toggle';
    toggleButton.className = "btn__accordion-toggle flex-justify-center align-items-center agency__w-10__h-10 agency__bg-axa-blue-400 agency__text-white";
    toggleButton.innerHTML = '<i id="accordion-icon" class="accordion-icon fas fa-chevron-down agency__text-xs"></i>';

    headerDiv.appendChild(toggleButton);
    //        }

    container.appendChild(headerDiv);

    // Create the checkbox element if index is 0
    if (i === 0) {
      renderCheckboxSection(container);
    }

    // Child collapse untuk tertanggung utama
    const collapseDiv = document.createElement("div");
    //        if (i === 0) {
    collapseDiv.id = "collapse" + i;
    //        }
    collapseDiv.className = "accordion-collapse show";

    const insuredFormDiv = document.createElement("div");
    insuredFormDiv.className = "insured-form";

    const ispepDiv = document.createElement("div");
    ispepDiv.className = "ispep";
    ispepDiv.innerHTML =
      "<span>" +
      "Apakah pemegang polis termasuk ke dalam kategori Orang yang " +
      '<span class="agency__text-axa-sienna-400"> Populer secara politisi / ' +
      '<span class="agency__italic">Politically Exposed Persons </span> (PEP) </span> ?' +
      "</span>" +
      '<a class="btn--white__step3 ml-2level agency__pointer" href="javascript:;" onclick="openModal()" >' +
      '<span> Baca Selengkapnya <i class="fas fa-arrow-right"></i> </span>' +
      "</a>" +
      '<div class="radio-group ispep-container">' +
      "<div>" +
      '<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">' +
      '<input id="no' +
      i +
      '" class="radio-custom ispepInputNo" name="input_ispep_insured_' +
      i +
      '" type="radio" value="0" required="required"/>' +
      '<label for="no' +
      i +
      '" class="radio-custom-label mb-0"><span>Tidak</span></label>' +
      "</div>" +
      "</div>" +
      "<div>" +
      '<div class="display-inline-flex align-items-center align-self-center radio-custom-wrapper">' +
      '<input id="yes' +
      i +
      '" class="radio-custom ispepInputYes" name="input_ispep_insured_' +
      i +
      '" type="radio" value="1" required="required"/>' +
      '<label for="yes' +
      i +
      '" class="radio-custom-label mb-0">' +
      "<span>" +
      "Iya" +
      '<span class="ispepYes">(Data Anda akan kami tinjau untuk melewati persetujuan dari Underwriting)</span>' +
      "</span>" +
      "</label>" +
      "</div>" +
      "</div>" +
      "</div>";

    insuredFormDiv.appendChild(ispepDiv);

    const formColumnDiv = document.createElement("div");
    formColumnDiv.className = "form-column display-flex agency__flex-wrap gap-4level";
    const form = document.createElement("form");
    form.className = "display-flex agency__flex-wrap gap-4level";

    // Kolom Kiri
    const leftColumn = document.createElement("div");
    leftColumn.className = "agency__flex-1 agency__min-w-300px";

    //negara
    const negaraDiv = document.createElement("div");
    negaraDiv.innerHTML = `
            <div class="negara_render_container_${i}">
                <label for="negara">Kewarganegaraan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>
                <div id="single-journey-wrapper" class="position-relative negara-container">
                
                </div>
            </div>
        `;

    //foto ktp
    const fotoDiv = document.createElement("div");
    fotoDiv.innerHTML =
      '<div class="upload-container">' +
      '<label for="upload"> Upload File (Paspor/KTP/KITAS) <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>' +
      '<div class="thumbnail-wrapper">' +
      '<img class="thumbnail img-thumbnail img-fluid" alt="foto ktp" />' +
      '<div class="loading-icon"> Memindai OCR  <i class="fas fa-spinner fa-spin"></i></div>' +
      '<div class="ml-5level mt-2level agency__pointer">' +
      '<span class="file-name agency__text-xs"></span>' +
      '<a style="text-align: center; width: 100px; font-size: 12px;" class="uploadButton btn btn__agency btn--dark-blue width-full">' +
      '<span class="position-relative agency__uppercase agency__pointer">' +
      "Pilih File" +
      "</span>" +
      "</a>" +
      "</div>" +
      '<input type="file" class="fileInput input_fotoktp_insured_' +
      i +
      ' display-hidden docupload" accept="image/*" name="input_fotoktp_insured_' +
      i +
      '" required="required" />' +
      '<input type="hidden" name="img_insured_' +
      i +
      '" class="imgupload"/>' +
      "</div>" +
      "</div>";

    //<!-- name -->
    const nameDiv = document.createElement("div");
    nameDiv.innerHTML = `<div> <label for="name"> Nama lengkap sesuai Paspor/KTP/KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputName" placeholder="Tulis Nama" name="input_name_insured_${i}" type="text" required="required" oninput="handleInputHurufDanSpasi(event)" tabindex="${
      baseTabIndex + 1
    }" value="${insuredData._name ?? ""}" /> </div> </div>`;

    // Hubungan
    const hubunganDiv = document.createElement("div");
    let hubunganOptions = "";

    if (travellerType === "Individual") {
      hubunganOptions = `<option value="Tertanggung Utama" ${insuredData._relationship === "Tertanggung Utama" ? "selected" : ""}>Tertanggung Utama</option>`;
    } else if (travellerType === "Duo") {
      if (totalAdult === 2) {
        hubunganOptions =
          i === 0
            ? `<option value="Tertanggung Utama" ${insuredData._relationship === "Tertanggung Utama" ? "selected" : ""}>Tertanggung Utama</option>`
            : `<option value="Kerabat" ${insuredData._relationship === "Kerabat" ? "selected" : ""}>Kerabat</option>
                       <option value="Teman" ${insuredData._relationship === "Teman" ? "selected" : ""}>Teman</option>`;
      } else if (totalAdult === 1) {
        // 1 adult and 1 child
        hubunganOptions =
          i === 0
            ? `<option value="Tertanggung Utama" ${insuredData._relationship === "Tertanggung Utama" ? "selected" : ""}>Tertanggung Utama</option>`
            : `<option value="Kerabat" ${insuredData._relationship === "Kerabat" ? "selected" : ""}>Kerabat</option>
                       <option value="Teman" ${insuredData._relationship === "Teman" ? "selected" : ""}>Teman</option>`;
      }
    } else if (travellerType === "Family") {
      if (totalAdult === 1) {
        hubunganOptions =
          i === 0
            ? `<option value="Tertanggung Utama" ${insuredData._relationship === "Tertanggung Utama" ? "selected" : ""}>Tertanggung Utama</option>`
            : `<option value="Anak" ${insuredData._relationship === "Anak" ? "selected" : ""}>Anak</option>
                       <option value="Anak / Pelajar" ${insuredData._relationship === "Anak / Pelajar" ? "selected" : ""}>Anak / Pelajar</option>`;
      } else if (totalAdult === 2) {
        hubunganOptions =
          i === 0
            ? `<option value="Tertanggung Utama" ${insuredData._relationship === "Tertanggung Utama" ? "selected" : ""}>Tertanggung Utama</option>`
            : i === 1
            ? `<option value="Pasangan" ${insuredData._relationship === "Pasangan" ? "selected" : ""}>Pasangan</option>`
            : `<option value="Anak" ${insuredData._relationship === "Anak" ? "selected" : ""}>Anak</option>
                           <option value="Anak / Pelajar" ${insuredData._relationship === "Anak / Pelajar" ? "selected" : ""}>Anak / Pelajar</option>`;
      }
    }

    hubunganDiv.innerHTML = `<div class="hubunganDiv"> 
                <label for="relationship">
                    Hubungan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> 
                </label> 
                <div id="single-journey-wrapper" class="position-relative relationship-container"> 
                    <select class="input-control-axa relationship" name="input_relationship_insured_${i}" tabindex="${baseTabIndex + 4}" required>
                        <option></option> 
                        ${hubunganOptions} 
                    </select> 
                </div> 
            </div>`;

    //<!-- dob -->
    let dobType = "dob-adult";

    if (travellerType === "Individual") {
      dobType = "dob-adult"; // Individual selalu dewasa
    } else if (travellerType === "Duo") {
      if (totalChild > 0) {
        // Jika Duo dan ada anak, iterasi pertama dewasa, kedua anak
        dobType = i === 1 ? "dob-child" : "dob-adult";
      } else {
        // Duo dengan 2 dewasa
        dobType = "dob-adult";
      }
    } else if (travellerType === "Family") {
      if (totalAdult === 1 && totalChild > 0) {
        // 1 dewasa dan anak-anak, iterasi pertama dewasa, selebihnya anak
        dobType = i > 0 ? "dob-child" : "dob-adult";
      } else if (totalAdult === 2 && totalChild > 0) {
        // 2 dewasa dan anak-anak, iterasi pertama dan kedua dewasa, selebihnya anak
        dobType = i > 1 ? "dob-child" : "dob-adult";
      } else {
        // 2 dewasa dan tidak ada anak
        dobType = "dob-adult";
      }
    }

    const dobDiv = document.createElement("div");
    dobDiv.innerHTML = `<div> <label class="display-block" for="dateofbirth">Tanggal Lahir <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="calendar-wrapper position-relative" id="calendar-wrapper-claim"> <div class="calendar-col position-relative dob-wrapper"> <input style="color: #00008f;" class="input-control-axa input-control-axa--outline input-icon-date dob ${dobType}" type="text" name="input_dob_insured_${i}" autocomplete="off" placeholder="Pilih Tanggal Lahir" readonly="readonly" required="required" tabindex="${
      baseTabIndex + 5
    }" /> </div> </div> </div>`;

    //<!-- place -->
    const placeDiv = document.createElement("div");
    placeDiv.innerHTML = `<div class="place"> <label for="place"> Tempat Lahir <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputPlaceOfBirth" placeholder="Tulis Tempat Lahir" name="input_pdob_insured_${i}" type="text" required="required" oninput="handleInputHurufDanSpasi(event)" tabindex="${
      baseTabIndex + 6
    }" value="${insuredData._pdob ?? ""}" /> </div> </div>`;

    //<!-- gender -->
    const genderDiv = document.createElement("div");
    genderDiv.className = "gender_container";
    genderDiv.innerHTML = `<label for="gender">Jenis Kelamin <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="form-radio-wrapper display-flex"> <div class="display-flex gender-container"> <div class="form-radio mr-8px"> <input class="classInputGenderMale" type="radio" name="input_gender_insured_${i}" value="M" required="required" tabindex="${
      baseTabIndex + 8
    }" /> <div class="box-radio-wrapper agency__text-center"> <div class="box-radio"> <img src="/o/mypage-theme/images/man-nb.png" alt="laki" /> </div> <div class="box-text">Laki-Laki</div> </div> </div> <div class="form-radio"> <div class="form-radio-input"> <input type="radio" name="input_gender_insured_${i}" value="F" class="form-control classInputGenderFemale" required="required" /> <div class="box-radio-wrapper agency__text-center"> <div class="box-radio"> <img src="/o/mypage-theme/images/woman-nb.png" alt="perempuan" /> </div> <div class="box-text">Perempuan</div> </div> </div> </div> </div>  </div>`;

    const checkboxDiv = document.createElement("div");
    checkboxDiv.className = "pb-2level"; // Pastikan diberi margin agar tidak terlalu rapat
    checkboxDiv.innerHTML = `
            <div class="display-inline-flex align-items-center checkbox-custom-wrapper checkbox-container2">
                <input id="custom-checkbox-${i}" class="checkbox-custom hour checkbox-input" name="insuredIsPolis" type="checkbox" /> 
                <label for="custom-checkbox-${i}" class="checkbox-custom-label">
                    <span class="checkBoxSpanDataSamePolis2 ml-2level agency__pointer agency__uppercase">
                        Data sama dengan pemegang polis
                    </span>
                </label>
            </div>
        `;

    //<!-- Kode negara dan telepon -->
    const kodeDiv = document.createElement("div");
    kodeDiv.className = "kodenegara_container";
    kodeDiv.innerHTML = `<label for="kode">Kode Negara dan Telepon </label> <div class="input-group-axa input-group-axa--border"> <input style="border: none;" class="input-control-axa" placeholder="Tulis Kode Negara" name="input_kodenegara_insured_${i}" type="text" maxlength="5" oninput="handleInput(event)" tabindex="${
      baseTabIndex + 10
    }" value="${insuredData._kodenegara ?? ""}" > </div>`;

    //<!-- hp -->
    const hpDiv = document.createElement("div");
    hpDiv.innerHTML = `<div> <label for="hp"> Nomor Handphone <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Nomor Handphone" name="input_hp_insured_${i}" type="text" maxlength="15" required="required" oninput="handleInput(event)" tabindex="${
      baseTabIndex + 12
    }" value="${insuredData._hp ?? ""}" /> </div> </div>`;

    //<!-- kode pos -->
    const posDiv = document.createElement("div");
    posDiv.innerHTML = `<div> <label for="kodepos">Kode Pos <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Kode Pos" name="input_kodepos_insured_${i}" type="text" required="required" maxlength="5" oninput="handleInput(event)" tabindex="${
      baseTabIndex + 14
    }" value="${insuredData._kodepos ?? ""}" /> </div> </div>`;

    //append left
    leftColumn.appendChild(negaraDiv); //update negara sebelum upload file
    leftColumn.appendChild(fotoDiv);
    leftColumn.appendChild(nameDiv);
    leftColumn.appendChild(hubunganDiv);
    leftColumn.appendChild(dobDiv);
    leftColumn.appendChild(placeDiv);
    leftColumn.appendChild(genderDiv);

    leftColumn.appendChild(checkboxDiv);

    leftColumn.appendChild(kodeDiv);
    leftColumn.appendChild(hpDiv);
    leftColumn.appendChild(posDiv);

    // Kolom Kanan
    const rightColumn = document.createElement("div");
    rightColumn.className = "agency__flex-1 agency__min-w-300px";

    //<!-- passpor -->
    const pasporDiv = document.createElement("div");
    pasporDiv.innerHTML = `<div class="mt-desktop-only__mt-321px"> <label for="ktppaspor"> Nomor KTP / KITAS <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputKtpKitas" placeholder="Tulis No. KTP / KITAS" name="input_ktpkitas_insured_${i}" type="text" maxlength="16" required="required" oninput="handleInput(event)" tabindex="${
      baseTabIndex + 2
    }" value="${insuredData._ktpkitas ?? ""}" /> </div> </div>`;

    //<!-- ktppasspor -->
    const ktppasporDiv = document.createElement("div");
    ktppasporDiv.innerHTML = `<div><label> Nomor Paspor <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa classInputPaspor passport-field" placeholder="Tulis Nomor Paspor" name="input_ktppaspor_insured_${i}" type="text" maxlength="16" required="required" tabindex="${
      baseTabIndex + 3
    }" value="${insuredData._ktppaspor ?? ""}" /> </div> </div>`;

    //<!-- age -->
    const ageDiv = document.createElement("div");
    ageDiv.innerHTML = `<div> <label for="age"> Usia </label> <div class="input-group-axa input-group-axa--border display-flex align-items-center input-group-axa__custome"> <input disabled="disabled" class="input-control-axa age" placeholder="0" name="input_age_insured_${i}" type="text" readonly="readonly" /> <span class="font_tahun">Tahun</span> </div> </div>`;

    /*job move here*/
    //<!-- job -->

    const jobDiv = document.createElement("div");
    const statusKawinDiv = document.createElement("div");

    if (!isChild) {
      //console.log('adult generate job and status!!');

      // Job
      jobDiv.className = "job-container-wrapper";

      let jobOptions = `
        	    <option></option>
        	    <option value="Pelajar/Mahasiswa" ${insuredData._job === "Pelajar/Mahasiswa" ? "selected" : ""}>Pelajar/Mahasiswa</option>
        	    <option value="Karyawan Swasta" ${insuredData._job === "Karyawan Swasta" ? "selected" : ""}>Karyawan Swasta</option>
        	    <option value="TNI/POLRI" ${insuredData._job === "TNI/POLRI" ? "selected" : ""}>TNI/POLRI</option>
        	    <option value="PNS" ${insuredData._job === "PNS" ? "selected" : ""}>PNS</option>
        	    <option value="Ibu Rumah Tangga" ${insuredData._job === "Ibu Rumah Tangga" ? "selected" : ""}>Ibu Rumah Tangga</option>
        	    <option value="Wiraswasta" ${insuredData._job === "Wiraswasta" ? "selected" : ""}>Wiraswasta</option>
        	    <option value="Lainnya" ${insuredData._job === "Lainnya" ? "selected" : ""}>Lainnya</option>
        	`;

      jobDiv.innerHTML = `
        	    <label for="job">Pekerjaan <span class="agency__text-axa-sienna-400 agency__text-xs">*</span></label>
        	    <div id="single-journey-wrapper" class="position-relative job-container">
        	        <select class="input-control-axa job" name="input_job_insured_${i}" tabindex="${baseTabIndex + 7}" required>
        	            ${jobOptions}
        	        </select>
        	    </div>
        	    <div class="other-job-wrapper ${insuredData._job === "Lainnya" ? "" : "agency__hidden"}" style="margin-top: 20px">
        	        <div class="input-group-axa input-group-axa--border">
        	            <input class="input-control-axa otherjob" placeholder="Tulis Pekerjaan" name="input_otherjob_insured_${i}" 
        	                tabindex="${baseTabIndex + 7}" type="text" 
        	                value="${insuredData._otherjob || ""}">
        	        </div>
        	    </div>
        	`;

      // Status Kawin
      statusKawinDiv.innerHTML = `<div> 
	                <label for="status-kawin">Status Perkawinan 
	                    <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> 
	                </label> 
	                <div id="single-journey-wrapper" class="position-relative status-kawin-container"> 
	                    <select class="input-control-axa status-kawin" name="input_status-kawin_insured_${i}" tabindex="${baseTabIndex + 9}" required>
	                        <option></option> 
	                        <option value="Belum Menikah" ${insuredData._statuskawin === "Belum Menikah" ? "selected" : ""}>Belum Menikah</option> 
	                        <option value="Sudah Menikah" ${insuredData._statuskawin === "Sudah Menikah" ? "selected" : ""}>Sudah Menikah</option> 
	                    </select> 
	                </div> 
	            </div>`;
    }

    //<!-- telepon -->
    const teleponDiv = document.createElement("div");
    teleponDiv.className = isChild
      ? "telepondiv_child" // 505px
      : "telepondiv_adult"; // 267px

    teleponDiv.innerHTML = `<div class="input-group-axa input-group-axa--border"> <input style="border: none;" class="input-control-axa" placeholder="Tulis Nomor Telepon" name="input_telepon_insured_${i}" type="text" oninput="handleInput(event)" maxlength="15" tabindex="${
      baseTabIndex + 11
    }" value="${insuredData._telepon ?? ""}" /> </div>`;

    //<!-- email -->
    const emailDiv = document.createElement("div");
    emailDiv.className = "emaildiv";
    emailDiv.innerHTML = `<label for="email">Email <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa email" placeholder="Tulis email" name="input_email_insured_${i}" type="text" required="required" tabindex="${
      baseTabIndex + 13
    }" value="${insuredData._email ?? ""}" /> </div>`;

    //<!-- kode pos -->
    /*const posDiv = document.createElement('div');
        posDiv.innerHTML =
            `<div> <label for="kodepos">Kode Pos <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label> <div class="input-group-axa input-group-axa--border"> <input class="input-control-axa" placeholder="Tulis Kode Pos" name="input_kodepos_insured_${i}" type="text" required="required" maxlength="5" oninput="handleInput(event)" tabindex="${baseTabIndex + 14}" /> </div> </div>`;
            */

    //append right
    //rightColumn.appendChild(negaraDiv);
    rightColumn.appendChild(pasporDiv);
    rightColumn.appendChild(ktppasporDiv);
    rightColumn.appendChild(ageDiv);

    if (!isChild) {
      rightColumn.appendChild(jobDiv);
      rightColumn.appendChild(statusKawinDiv);
    }

    rightColumn.appendChild(teleponDiv);
    rightColumn.appendChild(emailDiv);
    //rightColumn.appendChild(posDiv);

    // Alamat
    const alamatDiv = document.createElement("div");
    alamatDiv.className = "alamatdiv";
    alamatDiv.innerHTML = `<label for="alamat">Alamat Lengkap <span class="agency__text-axa-sienna-400 agency__text-xs">*</span> </label>
            <div class="input-group-axa input-group-axa--border">
            <input class="input-control-axa classInputAddress" placeholder="Tulis Alamat Lengkap" name="input_alamat_insured_${i}" tabindex="${baseTabIndex + 15}" required="required" value="${
      insuredData._alamat ?? ""
    }" maxlength="254" ></input></div>`;

    form.appendChild(leftColumn);
    form.appendChild(rightColumn);
    form.appendChild(alamatDiv);
    formColumnDiv.appendChild(form);
    insuredFormDiv.appendChild(formColumnDiv);
    collapseDiv.appendChild(insuredFormDiv);
    container.appendChild(collapseDiv);

    // Menambahkan container ke body atau elemen yang diinginkan
    mainContainer.appendChild(container);

    let roStat = false;
    let modifyStat = false;
    let _sessData = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    if (_sessData) {
      _sessData = JSON.parse(_sessData);
      if (_sessData.ro !== undefined) {
        roStat = _sessData.ro;
      }
      if (_sessData.modify !== undefined) {
        modifyStat = _sessData.modify;
      }
    }

    // Update foto hanya untuk continue penawaran (bukan beli kembali)
    // kalau beli kembali, foto dikosongkan aja, biar user upload ulang
    //        if(!roStat && !modifyStat) {
    if (insuredData._photoUrl !== undefined) {
      let photoUrl;
      if (insuredData._photoUrl != null) {
        // && insuredData._photoUrl.includes('/document')) {
        photoUrl = insuredData._photoUrl;
        document.querySelector('input[name="img_insured_' + i + '"]').value = photoUrl;
      } else {
        photoUrl = "/o/mypage-theme/images/ktp-image.png"; // default image url
      }

      const imgElement = container.querySelector(".thumbnail");
      imgElement.src = photoUrl;
      //            }
    } else {
      const imgElement = container.querySelector(".thumbnail");
      imgElement.src = "/o/mypage-theme/images/ktp-image.png"; // default image url
    }

    // UPDATE DOB EVERY INSURED
    if (insuredData._dob !== undefined) {
      //console.log('AFTER GENERATE UPDATE DOB INSURED!!');
      // Format tanggal secara langsung jika insuredData._dob tersedia
      insuredData._dob = new Date(insuredData._dob).toLocaleDateString("id-ID", { day: "2-digit", month: "2-digit", year: "numeric" });

      //console.log('insuredData._dob >>'+insuredData._dob);
      const dobformatted = insuredData._dob; // Contoh: "16/01/2008"
      //console.log('dobformatted >>'+dobformatted);

      if (!container) {
        console.warn(`Container-form dengan indeks ${i} tidak ditemukan`);
        continue; // Lewati jika tidak ada elemen
      }
      // Update tanggal lahir
      const dateofbirth = dobformatted;
      const formattedDOB = dateofbirth.replace(/-/g, "/"); // Ubah tanda - ke /

      if (dateofbirth) {
        // Gunakan moment.js untuk memformat
        const formattedDOBToSet = moment(formattedDOB, "DD/MM/YYYY");
        const day = formattedDOBToSet.format("DD");
        const englishMonth = formattedDOBToSet.format("MMMM");
        const year = formattedDOBToSet.format("YYYY");

        // Ambil bulan dari deklarasi indonesianMonths
        const indonesianMonth = indonesianMonths[englishMonth];
        const formattedDate = `${day}/${indonesianMonth}/${year}`;

        // Perbarui input tanggal lahir
        const dobInputClosest = container.querySelector(".dob");
        if (dobInputClosest) {
          dobInputClosest.value = formattedDate; // Set nilai input
          //console.log('Tanggal sebelum init:', $(dobInputClosest).val(), 'Start date:', formattedDOBToSet);
          initDatepickerFromScan(dobInputClosest, formattedDOBToSet);

          dobInputClosest.closest(".dob-wrapper").classList.remove("invalid"); // Hapus class invalid jika ada
        }

        // Hitung usia berdasarkan tanggal lahir
        const birthDate = moment(formattedDOB, "DD/MM/YYYY");
        const today = moment();
        let age = today.diff(birthDate, "years");

        // Periksa apakah ulang tahun tahun ini sudah lewat
        const isBeforeBirthdayThisYear = today.isBefore(birthDate.clone().add(age, "years"));

        if (isBeforeBirthdayThisYear) {
          age--; // Kurangi usia jika ulang tahun belum lewat
        }

        // Perbarui input usia
        const ageInputClosest = container.querySelector(".age");
        if (ageInputClosest) {
          ageInputClosest.value = age;
        }
      }
    }

    // SET GENDER
    if (insuredData._gender !== undefined) {
      // Update gender
      const maleRadio = container.querySelector(".classInputGenderMale");
      const femaleRadio = container.querySelector(".classInputGenderFemale");

      if (insuredData._gender === "M") {
        maleRadio.checked = true;
      } else {
        femaleRadio.checked = true;
      }

      maleRadio.closest(".gender-container").classList.remove("invalid");
      femaleRadio.closest(".gender-container").classList.remove("invalid");
    }

    // SET ISPEP
    if (insuredData._ispep !== undefined) {
      const noRadio = container.querySelector(".ispepInputNo");
      const yesRadio = container.querySelector(".ispepInputYes");

      //console.log('insuredData._ispep>>'+insuredData._ispep);

      if (insuredData._ispep === 0) {
        noRadio.checked = true;
      } else {
        yesRadio.checked = true;
      }
    }

    // Set country
    if (insuredData._negara !== undefined) {
      generateCountryOptions(i, insuredData._negara || "");
    } else {
      generateCountryOptions(i); // negara kosong akan set default ke Indonesia
    }
  }
}

//reopen UPDATE
function handleInputHurufDanSpasi(event) {
  const input = event.target;
  input.value = input.value.replace(/[^A-Za-z\s]/g, "");
}

function handleInputHurufAngkaDanKarakter(event) {
  const input = event.target;
  input.value = input.value.replace(/[^A-Za-z0-9._\s-]/g, ""); // hapus semua yang bukan huruf,angka,titik,underscore,spasi dan tanda minus.
}

function handleInputHurufAngkaDanKarakterAlamat(event) {
  const input = event.target;
  input.value = input.value.replace(/[^A-Za-z0-9.,\-\/\s]/g, "");
}

//Event listener untuk input file pada polis
document.querySelector(".input_fotoktp_polisholder").addEventListener("change", async (event) => {
  const file = event.target.files[0];
  if (file) {
    // Konversi file ke data base64
    const base64Result = await getBase64(file);

    // Simpan base64 ke window agar dapat disalin ke insured
    window.base64ResultForInsured = base64Result;
    window.fileForInsured = file;
  }
});

/*MODAL KIRIM PENAWARAN*/
const modal = document.getElementById("modal");
const openModalBtn = document.getElementById("openModalBtn");
//const closeModalBtn = document.getElementById('closeModalBtn');
const userForm = document.getElementById("userForm");

$("#openModalBtn").on("click", function () {
  //console.log('cek open modal');

  const isValid = checkValidation();
  //console.log('is valid', isValid);

  if (!isValid) {
    scrollToInvalidField();
  }

  if (isValid) {
    const name = getValue('input[name="input_name_polisholder"]');
    const email = getValue('input[name="input_email_polisholder"]');
    //console.log('namepolis>>', name);
    //console.log('emailpolis>>', email);

    $("#name_modal").val(name);
    $("#email_modal").val(email);

    modal.style.display = "block";
  }
});

$(".btn__penawaran").on("click", function () {
  //console.log('kirim penawaran');

  //Menutup modal setelah pengiriman data
  modal.style.display = "none";

  preparePayload("penawaran", restApiProcessUrl);
});

//Menutup modal saat tombol close diklik
//closeModalBtn.onclick = function() {
//    modal.style.display = 'none';
//}

//Menutup modal jika pengguna klik di luar area modal
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";

    const modalBaca = document.getElementById("modal_baca");
    modalBaca.style.display = "none";
  }
};

// MODAL BACA
function openModal() {
  //console.log('open modal ispep');
  document.getElementById("modal_baca").classList.remove("agency__hidden");
}

function closeModal() {
  document.getElementById("modal_baca").classList.add("agency__hidden");
}

// MODAL ALERT BLOCKED
function openModalAlertBlocked() {
  //console.log('buka modal block');
  document.getElementById("modal_alert").classList.remove("agency__hidden");
}

function closeModalAlertBlocked(redirectUrl = null) {
  const modal = document.getElementById("modal_alert");
  if (modal) {
    modal.classList.add("agency__hidden");
  }

  if (redirectUrl) {
    window.parent.location.href = redirectUrl;
  }
}

// MODAL IS PEP
function closeModalIspep() {
  document.getElementById("ispepModal").classList.remove("is-open");
}

// Example to open the modal IS PEP B2B
function openModalIspep(isB2b) {
  //console.log('is B2B>>', isB2b, typeof isB2b);

  let contentMessage = "";

  //b2c
  contentMessage = `Kami sudah menerima pengajuan Polis Asuransi Anda untuk ditinjau. Mohon pastikan email yang
        didaftarkan aktif untuk mendapatkan informasi verifikasi dan kode bayar.

        Info lebih lanjut hubungi Customer Care Center di 100-1551 atau email ke
        customer.general@axa-mandiri.co.id (Senin - Jumat, 08.00-17.00 WIB).`;

  if (isB2b) {
    //console.log('masuk b2b')
    contentMessage = `Terima Kasih! Kami sudah menerima pengajuan Polis Asuransi Anda untuk ditinjau. 
			Mohon pastikan email yang didaftarkan aktif untuk mendapatkan informasi verifikasi dan kode bayar. 
			Silakan menghubungi perwakilan Business Development Kami untuk Informasi lebih lanjut.`;
  }

  // Update isi pesan di modal
  document.querySelector(".content-message-popup-ispep").textContent = contentMessage;

  //open modal
  document.getElementById("ispepModal").classList.add("is-open");
}

/**
 * CUSTOM UPDATE STYLE VIA JS
 */

function adjustElemenMobile() {
  const panelCovers = document.querySelectorAll(".mobile-view");

  panelCovers.forEach((panelCover) => {
    if (window.innerWidth <= 768) {
      panelCover.style.padding = "20px";
    } else {
      // Desktop view
      panelCover.style.padding = "40px";
    }
  });

  const h1Elements = document.querySelectorAll("h1");

  h1Elements.forEach((h1) => {
    if (window.innerWidth <= 768) {
      h1.style.fontSize = "24px";
    } else {
      // Desktop view
      h1.style.fontSize = "36px";
    }
  });

  document.querySelectorAll(".stepper-wrapper .step-name").forEach((stepName) => {
    stepName.style.textAlign = "center";
  });

  document.querySelectorAll(".tab-content__sm .ispep .btn--white__step3").forEach((button) => {
    button.style.borderBottom = "none";
  });
}
window.addEventListener("resize", adjustElemenMobile);

function reorderElementsForMobile() {
  const forms = document.querySelectorAll(".container-form");

  forms.forEach((form) => {
    const teleponDiv = form.querySelector(".telepondiv") || form.querySelector(".telepondiv_child") || form.querySelector(".telepondiv_adult");
    const kodeNegaraContainer = form.querySelector(".kodenegara_container");
    const emailDiv = form.querySelector(".emaildiv");

    if (!teleponDiv || !kodeNegaraContainer || !emailDiv) {
      //console.warn("Salah satu elemen tidak ditemukan di form ini.");
      return;
    }

    if (window.innerWidth <= 768) {
      kodeNegaraContainer.insertAdjacentElement("afterend", teleponDiv);
    } else {
      emailDiv.insertAdjacentElement("beforebegin", teleponDiv);
    }
  });
}
window.addEventListener("resize", reorderElementsForMobile);

//Calculate premi
function calculatePremi() {
  let existingSession = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);

  var promoCodeIncluded = false;
  if (JSON.parse(existingSession).PromoCode) {
    promoCodeIncluded = true;
  }

  $.ajax({
    url: restApiCalculateUrl,
    type: "POST",
    contentType: "application/json",
    data: existingSession,
    success: function (response) {
      $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
      if (response.Status) {
        if (response.Data.Calculation.AvailablePlans) {
          if (response.Data.Calculation.AvailablePlans.length > 0) {
            // add calculation detail to session storage
            sessionStorage.setItem(_smartTravelInternationalCalculation, JSON.stringify(response.Data.Calculation));

            let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));

            updatePlanSummarySidebar();
            updateStickyPrice();
          }
        }
      } else {
        // if response status is 0
        //            alert(response.Message ? response.Message : "Calculate Failed");
        if (promoCodeIncluded) {
          if (typeof response.PromoCodeResponse !== "undefined") {
            if (response.PromoCodeResponse) {
              removePromoCode();
              alert(response.Message ? response.Message : "Calculate Failed");
              return false;
            }
          }
        }
      }
    },
    error: function (xhr, status, error) {
      $("#promo-code-btn").html('<span class="position-relative order-10">Pakai Kode Promo<i class="fas fa-arrow-right"></i></span>');
      console.error("Error:", error);
    },
  });
}

// Get countries data
// function getCountries() {
//   console.log("Ambil data negara running...");
//   fetchCountriesDefault()
//     .then((countries) => {
//       const selectNegara = $(".negara");
//       selectNegara.empty();
//       selectNegara.append("<option></option>");

//       let indonesia = countries.find((country) => country.name === "Indonesia");
//       let otherCountries = countries.filter((country) => country.name !== "Indonesia").sort((a, b) => a.name.localeCompare(b.name));

//       let sortedCountries = [];
//       if (indonesia) sortedCountries.push(indonesia);
//       sortedCountries = sortedCountries.concat(otherCountries);

//       sortedCountries.forEach(function (country) {
//         selectNegara.append('<option value="' + country.name + '">' + country.name + "</option>");
//       });

//       selectNegara.select2({
//         dropdownParent: "#single-journey-wrapper",
//         placeholder: "Pilih Negara",
//         width: "100%",
//         minimumResultsForSearch: 0,
//       });
//     })
//     .catch((error) => {
//       //console.error('Error fetching countries:', error);
//     });
// }

// DOCUMENT READY JQUERY
$(document).ready(function () {
  $("#select-plan-sticky").prop("disabled", true);
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
    $(".detail-summary").toggleClass("is-active");

    $("#collapsePlandetail").toggleClass("is-show");
    $(".sticky-plan__summary").toggleClass("is-hide");
    $(".sticky-plan__inner").toggleClass("is-active-detail");

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

  // PROMOCODE
  $("#promo-code-btn").on("click", function (e) {
    $(this).html('<span class="position-relative order-10">Loading....</span>');
    let el = $(this);
    let pc = $('input[name="PromoCode"]').val();
    $('input[name="PromoCodeSidebar"]').val(pc);

    updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
    calculatePremi();

    $(".trigger-collapse-promo").trigger("click"); // tutup sticky promocode dan tampilkan summary
  });

  $("#clear-promo-code-btn-sidebar").on("click", function (e) {
    let pc = $('input[name="PromoCodeSidebar"]').val();
    $('input[name="PromoCode"]').val(pc);

    updateSess(_smartTravelInternationalFormDetailSess, "PromoCode", pc.toUpperCase());
    calculatePremi();
  });

  // VALIDATE POPUP KIRIM PENAWARAN
  $('input[name="send_quotation_name"]').on("input", function (e) {
    let inputValue = e.target.value;
    let sanitizedValue = inputValue.replace(/[^a-zA-Z ]/g, "");

    if (inputValue !== sanitizedValue) {
      e.target.value = sanitizedValue;
    }
  });

  $('input[name="send_quotation_email"], input[name="input_email_polisholder"], input[name="input_email_insured_0"]').on("input", function (e) {
    let inputValue = e.target.value;
    let sanitizedValue = inputValue.replace(/[^a-zA-Z0-9@\-_.]/g, "");

    if (inputValue !== sanitizedValue) {
      e.target.value = sanitizedValue;
    }
  });

  // GET Countries
  function getCountries() {
    const selectNegara = $(".negara");
    selectNegara.empty();
    
    $.ajax({
      url: restApiCountriesUrl,
      method: "GET",
      dataType: "json",
      beforeSend: function () {
        selectNegara.append("<option>Loading...</option>");
      },
      success: function (response) {
        if (response.status === 1) {
          let countries = response.data;

          if (!countries) {
            throw Error("Gagal mengambil data negara.");
          }

          selectNegara.append("<option></option>"); // option untuk tampung placeholder bawaan dari select2

          let indonesia = countries.find((country) => country.name === "Indonesia");
          let otherCountries = countries.filter((country) => country.name !== "Indonesia").sort((a, b) => a.name.localeCompare(b.name));

          let sortedCountries = [];
          if (indonesia) sortedCountries.push(indonesia);
          sortedCountries = sortedCountries.concat(otherCountries);

          sortedCountries.forEach(function (country) {
            selectNegara.append('<option value="' + country.name + '">' + country.name + "</option>");
          });

          selectNegara.select2({
            dropdownParent: "#single-journey-wrapper",
            placeholder: "Pilih Negara",
            width: "100%",
            minimumResultsForSearch: 0,
          });
        } else {
          alert("Gagal mengambil data negara.");
        }
      },
      complete: function () {
        selectNegara.find('option:first').remove();
        
      },
      error: function (xhr, status, error) {
        alert("Gagal mengambil data negara. Silahkan coba kembali.");
      },
    });
  }

  // Show kirim penawaran button if B2B
  let submitQuotationBtnHTML = "";
  let sessData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
  if (sessData && sessData["BusinessModel"]) {
    if (sessData["BusinessModel"] === "B2B") {
      submitQuotationBtnHTML =
        '<a class="btn btn--dark-blue width-full href="javascript:void(0)" id="submit-quotation-btn" style="margin-top:15px"><span class="position-relative text-transform-uppercase">Kirim Penawaran</span></a>';
    }
  }

  // Target elemen yang ingin di-replace
  const sidebarNav = document.getElementById("sidebarNav");
  if (sidebarNav) {
    // Buat elemen baru dengan innerHTML
    const newSidebarNavContent = `
            <div class="sidebar-nav">
                <a class="btn btn__submit btn--dark-blue width-full" href="javascript:void(0)" id="next-step-btn-a">
                    <span class="position-relative text-transform-uppercase">
                        <span id="btn-text">Lanjut Ke Persetujuan <i class="fas fa-arrow-right"></i></span>
                    </span>
                </a>
                ${submitQuotationBtnHTML}
                <a class="btn btn--dark-blue width-full href="javascript:void(0)" id="prev-step-btn-a" style="margin-top:15px"><span class="position-relative text-transform-uppercase">Kembali</span></a>
            </div>
        `;

    // Replace isi dari elemen
    sidebarNav.outerHTML = newSidebarNavContent;
  }

  // POPUP Kirim Penawaran
  $("#send_quotation_btn_close").on("click", function () {
    quotationModal.hide();
  });

  $("#submit-quotation-btn").on("click", function (e) {
    const validateForm = checkValidation();
    if (!validateForm) {
      return;
    } else {
      const name = getValue('input[name="input_name_polisholder"]');
      const email = getValue('input[name="input_email_polisholder"]');
      $('input[name="send_quotation_name"]').val(name.toUpperCase());
      $('input[name="send_quotation_email"]').val(email.toUpperCase());
    }

    let sessData = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    if (sessData) {
      sessData = JSON.parse(sessData);

      let a = sessData.Currency;
      b = sessData.TravellerType;
      c = sessData.TravelType;
      d = sessData.DepartureDate;
      e = sessData.ArrivalDate;

      if (a && b && c && d && e) {
        quotationModal.show();
      } else {
        alert("Please fill required field.");
      }
    }
  });

  // Submit quotation
  $("#send_quotation_form").on("submit", function (e) {
    e.preventDefault();
    let btn = $(this).find('button[type="submit"]');

    preparePayload("penawaran", restApiProcessUrl);
  });

  // KONDISI BELI KEMBALI ATAU UBAH PENAWARAN
  // ELSE > BELI PERTAMA
  if (lId > 0) {
    const sessionData = getSessionData("SmartTravelInternationalDataPayload");
    if (sessionData && sessionData.policyholder) {
      handleRepeatOrder();
    } else {
      getCountries();
      renderInsuredForm();
    }
  } else {
    // pertama kali form data tertanggung digenerate
    renderInsuredForm();
  }

  // set padding mobile view
  adjustElemenMobile();
  reorderElementsForMobile();

  // Ambil data negara menggunakan fetchCountries default
  if (lId < 1) {
    getCountries();
  }

  $(".job").select2({
    dropdownParent: "#single-journey-wrapper",
    placeholder: "Pilih Pekerjaan",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $(".relationship").select2({
    dropdownParent: "#single-journey-wrapper",
    placeholder: "Pilih Hubungan",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $(".status-kawin").select2({
    dropdownParent: "#single-journey-wrapper",
    placeholder: "Pilih Status Perkawinan",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $(".provinsi").select2({
    dropdownParent: "#single-journey-wrapper",
    placeholder: "Pilih Provinsi",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  $(".kabupaten").select2({
    dropdownParent: "#single-journey-wrapper",
    placeholder: "Pilih Kabupaten/Kota",
    width: "100%",
    minimumResultsForSearch: -1,
  });

  //Inisialisasi awal untuk semua elemen .dob
  $(".dob").each(function () {
    initializeDatePicker($(this));
  });

  // hubungan select option
  $(".relationship").each(function () {
    const $this = $(this);

    $this.on("change", function () {
      //console.log('travellerType>>' + travellerType);
      //console.log('totalAdult>>' + totalAdult);
      //console.log('totalChild>>' + totalChild);

      if (travellerType === "Family") {
        if ($this.val() !== "Anak") {
          $this.closest(".panel-cover").find(".dob").addClass("dob-student").removeClass("dob-child");
        } else {
          $this.closest(".panel-cover").find(".dob").removeClass("dob-student").addClass("dob-child");
        }
      }

      if (travellerType === "Duo") {
        if (totalAdult === 1) {
          //console.log('masuk duo 1 dewasa');
          $this.closest(".panel-cover").find(".dob").removeClass("dob-adult").addClass("dob-child");
        }
      }

      //clear dob and age if value
      $this.closest(".panel-cover").find(".dob").val("");
      $this.closest(".panel-cover").find(".age").val("");

      //reinit
      initializeDatePicker($this.closest(".panel-cover").find(".dob"));
    });
  });

  // Detect button upload
  // Image upload
  document.querySelectorAll(".uploadButton").forEach((button) => {
    button.addEventListener("click", function () {
      this.closest(".thumbnail-wrapper").querySelector(".fileInput").click();
    });
  });

  document.querySelectorAll(".fileInput").forEach((input) => {
    input.addEventListener("change", function (event) {

      const currentFile = event.target.files[0];

      if (!currentFile) return;

      if (!currentFile.type.startsWith("image/")) {
        alert("Gagal upload, hanya file gambar yang diperbolehkan.");
        event.target.value = "";
        return;
      }

      if (currentFile.size > 5 * 1024 * 1024) {
        alert("Gagal upload gambar, ukuran maksimal adalah 5 MB.");
        event.target.value = "";
        return;
      }

      checkForms();

      const containerForm = input.closest(".container-form");
      const negaraElement = containerForm.querySelector(".negara");

      if (negaraElement && negaraElement.value === "") {
        document.querySelector(".modal_alert-body").innerHTML = "Harap pilih kewarganegaraan terlebih dahulu.";
        const modalContent = document.querySelector(".modal_alert-content");

        if (modalContent) {
          modalContent.style.width = "40%";
        }

        openModalAlertBlocked();

        // reset input supaya bisa upload ulang
        event.target.value = "";

        return;
      }

      // OCR OPT-IN
      if (isScanOcr === "true") {
        handleFileChange(this);
      }

      const file = event.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
          const wrapper = input.closest(".thumbnail-wrapper");
          wrapper.querySelector(".thumbnail").src = e.target.result;

          if (wrapper.querySelector(".thumbnail") && wrapper.querySelector(".thumbnail").classList.contains("invalid")) {
            wrapper.querySelector(".thumbnail").classList.remove("invalid");
          }

          const fileNameSpan = wrapper.querySelector(".file-name");
          let fileName = file.name;

          if (fileName.length > 70) {
            // Only keep the last 50 characters and prepend "..."
            fileName = "..." + fileName.slice(-50);

            let formattedName = "";
            for (let i = 0; i < fileName.length; i += 20) {
              formattedName += fileName.slice(i, i + 20) + "\n";
            }

            fileName = formattedName.trim();
          }

          fileNameSpan.textContent = fileName;
        };
        reader.readAsDataURL(file);
      }
    });
  });

  $(".btn__accordion-toggle").on("click", function () {
    //console.log('click trigger btn toggle');
    const button = $(this); // Elemen tombol yang diklik
    const container = button.closest(".panel-cover"); // Panel terkait
    const collapseContent = container.find(".accordion-collapse"); // Elemen collapse terkait
    const icon = container.find(".accordion-icon"); // Ikon terkait

    if (collapseContent.hasClass("show")) {
      // Jika konten sudah ditampilkan, sembunyikan dan ubah ikon
      collapseContent.removeClass("show");
      icon.removeClass("fa-chevron-up").addClass("fa-chevron-down");
    } else {
      // Jika konten belum ditampilkan, tampilkan dan ubah ikon
      collapseContent.addClass("show");
      icon.removeClass("fa-chevron-down").addClass("fa-chevron-up");
    }
  });

  // Bind click event to the span within each panel-cover
  $(".panel-cover").each(function (i) {
    const panel = $(this);

    //untuk check utama tapi klik label
    panel.find(".checkBoxSpanDataSamePolis").on("click", function () {
      panel.find(".checkbox-container").trigger("click");

      if (i === 1) {
        // Jika tertanggung utama ada 2 checkbox
        let con = panel.find(".checkbox-container");
        const cbi1 = con.find(".checkbox-input");

        let con2 = panel.find(".checkbox-container2");
        const cbi2 = con2.find(".checkbox-input");

        // Cek apakah kedua checkbox dalam kondisi yang sama (checked atau unchecked)
        if (cbi1.prop("checked")) {
          cbi2.prop("checked", true);
          con2.toggleClass("checked", cbi2.prop("checked"));
        } else {
          cbi2.prop("checked", false);
          con2.toggleClass("checked", cbi2.prop("checked"));

          //if unchecked btn disable
          disableBtnNext();
        }
      }
    });

    // untuk check utama tapi klik box
    panel.find('label[for="custom-checkbox-x"]').on("click", function () {
      const con = panel.find(".checkbox-container");
      const cbi1 = con.find(".checkbox-input");

      if (i === 1) {
        let con2 = panel.find(".checkbox-container2");
        const cbi2 = con2.find(".checkbox-input");

        if (cbi1.prop("checked")) {
          cbi2.prop("checked", true);
          con2.addClass("checked");
        } else {
          cbi2.prop("checked", false);
          con2.removeClass("checked");

          //if unchecked btn disable
          disableBtnNext();
        }
      }
    });

    //untuk semua check tambahan
    // Event untuk checkbox-custom-label pada semua panel
    panel.find(".checkbox-custom-label").on("click", function () {
      panel.find(".checkbox-container2").trigger("click");
    });
  });

  // FIND CHECK HERE .Event handler untuk checkbox-container
  $(".checkbox-container, .checkbox-container2").on("click", function () {
    const isValidPolicyHolder = checkValidation("policy_holder");
    if (!isValidPolicyHolder) {
      scrollToInvalidField();

      // Cari input checkbox terdekat dari elemen ini dan set ke unchecked
      $(this).closest(".checkbox-custom-wrapper").find('input[type="checkbox"]').prop("checked", false);

      return;
    }

    const isCheckbox2 = $(this).hasClass("checkbox-container2"); // Cek apakah klik dari checkbox-container2
    const checkbox = $(this).find(".checkbox-input");

    // Toggle checked state
    checkbox.prop("checked", !checkbox.prop("checked"));

    // Toggle classes based on checked state
    $(this).toggleClass("checked", checkbox.prop("checked"));

    // Ambil elemen collapse dan ikon berdasarkan panel
    const containerformsInsured = $(this).closest(".panel-cover"); // Mendapatkan konteks panel terkait
    const collapseId = containerformsInsured.find(".accordion-collapse").attr("id"); // Mendapatkan ID collapse dinamis
    //console.log('collapseId >> : ' + collapseId);

    const content = document.getElementById(collapseId); // Collapse terkait
    const icon = containerformsInsured.find(".accordion-icon")[0]; // Ikon terkait
    let idInsured = collapseId.substring(8); // Ekstrak ID Insured

    if (checkbox.prop("checked")) {
      //trigger btn lanjut disable or enable
      checkForms();

      // Jalankan fungsi sesuai dengan tipe checkbox
      if (isCheckbox2) {
        copyPolisholderToInsuredAdditional(idInsured);

        const requiredFields = containerformsInsured.find("[required]");

        requiredFields.each(function () {
          const field = $(this); // Menggunakan jQuery untuk mempermudah akses elemen

          // Jika nilai field tidak kosong, hapus kelas 'invalid'
          if (field.val().trim() !== "") {
            // Memeriksa apakah nilai field tidak kosong
            //                        //console.log('Field tidak kosong, remove invalid class');
            field.removeClass("invalid");
          }

          // Cek jika field adalah nationality
          if (field.hasClass("negara")) {
            // Memeriksa apakah field memiliki kelas 'negara'
            const containerTarget = field.closest(".negara-container");
            if (containerTarget.length) {
              // Jika ditemukan container dengan kelas .negara-container
              containerTarget.removeClass("invalid");
            }
          }
        });
      } else {
        //console.log('copy semua dan hide panel');
        // Jika checkbox dicentang
        if (content && content.classList.contains("show")) {
          content.classList.remove("show");
          if (icon) {
            icon.classList.remove("fa-chevron-up");
            icon.classList.add("fa-chevron-down");
          }
        }

        copyPolisholderToInsured();

        // Aktifkan kembali input dalam panel policy_holder jika semua checkbox tidak dicentang
        $(".panel-cover.policy_holder").find("input, select, textarea, button").prop("disabled", true);

        //COBA COMMENT INI DULU, HAPUS JIKA AMAN
        //containerformsInsured.removeClass('container-form');
        //containerformsInsured.find('.invalid').removeClass('invalid');
      }
    } else {
      //if unchecked btn disable
      disableBtnNext();

      // Jika checkbox tidak dicentang
      if (!isCheckbox2) {
        //console.log('copy semua dan show panel');

        if (content) {
          content.classList.add("show");
          if (icon) {
            icon.classList.remove("fa-chevron-down");
            icon.classList.add("fa-chevron-up");
          }
        }

        resetInsuredFieldsAll(idInsured); //reset all

        // disable kembali input dalam panel policy_holder jika semua checkbox tidak dicentang
        $(".panel-cover.policy_holder").find("input, select, textarea, button").prop("disabled", false);

        //COBA COMMENT INI DULU, HAPUS JIKA AMAN
        // add (need check validation)
        // containerformsInsured.addClass('container-form');
      } else {
        //console.log('reset sebagian');
        resetInsuredFields(idInsured); // reset info tambahan
      }
    }
  });

  /* button clear kode promo */
  const clearButtons = document.querySelectorAll(".btnClear");

  clearButtons.forEach((button) => {
    button.addEventListener("click", function () {
      const inputGroup = button.closest(".input-group-axa");
      const input = inputGroup.querySelector(".input-control-axa");

      input.value = "";
      let currentPromoCode = sessionStorage.getItem("pc");
      if (currentPromoCode) {
        sessionStorage.removeItem("pc");
      }
    });
  });

  // Klik lanjut ke persetujuan
  $(".btn__submit, .next-step-btn").on("click", function () {
    const isValid = checkValidation();
    const isDocUploadValid = validateIdPhoto();

    if (!isDocUploadValid) {
      alert("File Paspor/KTP/KITAS is required");
    }

    if (!isValid) {
      scrollToInvalidField();
    }

    if (isValid && isDocUploadValid) {
      preparePayload("persetujuan", restApiProcessUrl);
    }

    // Check if any panel contains an invalid class
    $(".panel-cover").each(function () {
      const container = $(this); // Panel related to the submit button
      const collapseContent = container.find(".accordion-collapse"); // Collapse element inside the panel
      const icon = container.find(".accordion-icon"); // Icon related to the panel

      // If any element inside the panel has the 'invalid' class
      if (container.find(".invalid").length > 0) {
        // Toggle the collapse content and the icon
        if (!collapseContent.hasClass("show")) {
          collapseContent.addClass("show"); // Show content
          icon.removeClass("fa-chevron-down").addClass("fa-chevron-up"); // Change icon to 'up'
        }
      }
    });
  });

  /**
   * Check field on typing
   */
  document.addEventListener("input", ({ target }) => {
    if (target.classList.contains("email")) {
      const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
      const emailValue = target.value.trim();

      if (!emailPattern.test(emailValue)) {
        target.classList.add("invalid");
      } else {
        target.classList.remove("invalid");
      }
    } else {
      // Validasi umum untuk field lain
      if (target.value.trim()) {
        target.classList.remove("invalid");
      } else {
        target.classList.add("invalid");
      }
    }
  });

  // ALL SELECT NEGARA
  $(".negara").on("select2:select", function (event) {
    const negaraContainer = $(this).closest(".negara-container");
    if (negaraContainer.hasClass("invalid")) {
      negaraContainer.removeClass("invalid");
    }

    const containerForm = negaraContainer.closest(".container-form");
    if (!containerForm.length) {
      console.error(".container-form not found near negaraContainer");
      return;
    }

    const inputKtpKitas = containerForm.find(".classInputKtpKitas").get(0);
    if (!inputKtpKitas) {
      console.error(".classInputKtpKitas not found in containerForm");
      return;
    }

    // RULE FIELD KTP KITAS
    if (this.value.toUpperCase() === "INDONESIA") {
      $(inputKtpKitas).attr("maxlength", "16").attr("minlength", "16").removeClass("kitas-field").addClass("ktp-field");

      inputKtpKitas.oninput = handleInput;
    } else {
      $(inputKtpKitas).attr("maxlength", "20").attr("minlength", "10").removeClass("ktp-field").addClass("kitas-field");
      inputKtpKitas.oninput = handleInputHurufAngkaDanKarakter;
    }
  });

  $(".job").on("select2:select", function (event) {
    const jobContainer = $(this).closest(".job-container");
    if (jobContainer.hasClass("invalid")) {
      jobContainer.removeClass("invalid");
    }
  });

  $(".status-kawin").on("select2:select", function (event) {
    const kawinStatus = $(this).closest(".status-kawin-container");
    if (kawinStatus.hasClass("invalid")) {
      kawinStatus.removeClass("invalid");
    }
  });

  $(".relationship").on("select2:select", function (event) {
    const hub = $(this).closest(".relationship-container");
    if (hub.hasClass("invalid")) {
      hub.removeClass("invalid");
    }
  });

  // gender onchange
  const containers = document.querySelectorAll(".gender-container");
  containers.forEach((container) => {
    const maleRadio = container.querySelector(".classInputGenderMale");
    const femaleRadio = container.querySelector(".classInputGenderFemale");

    if (maleRadio) {
      maleRadio.addEventListener("change", () => {
        handleSelection(container);
      });
    }

    if (femaleRadio) {
      femaleRadio.addEventListener("change", () => {
        handleSelection(container);
      });
    }
  });

  // ispep onchange
  const ispepContainers = document.querySelectorAll(".ispep-container");
  ispepContainers.forEach((container) => {
    const noRadio = container.querySelector(".ispepInputNo");
    const yesRadio = container.querySelector(".ispepInputYes");

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

  // Event listener untuk perubahan pada dropdown
  $(".job").each(function () {
    const $this = $(this);

    $this.on("change", function () {
      const jobContainerWrapper = $this.closest(".job-container-wrapper");
      const otherJobWrapper = jobContainerWrapper.find(".other-job-wrapper");
      const otherJobInput = otherJobWrapper.find("input.otherjob");

      const panel = $this.closest(".container-form");

      const genderContainerWrapper = panel.find(".gender_container");
      //console.log(genderContainerWrapper);
      if ($this.val() === "Lainnya") {
        //console.log('lainnya');
        otherJobWrapper.removeClass("agency__hidden");
        otherJobInput.attr("required", "required");

        // Cek apakah viewport adalah desktop
        if (window.matchMedia("(min-width: 768px)").matches) {
          //console.log('desktop');
          genderContainerWrapper.css("margin-top", "105px"); // Tambahkan margin-top di desktop
        }
      } else {
        //console.log('bukan lainnya');
        otherJobWrapper.addClass("agency__hidden");
        otherJobInput.removeAttr("required");

        // Hapus margin-top jika bukan 'Lainnya'
        genderContainerWrapper.css("margin-top", "");
      }
    });
  });

  // Tangkap semua elemen dengan kelas .checkbox-container2
  document.querySelectorAll(".checkbox-container2").forEach((checkboxDiv) => {
    // Tangkap input checkbox di dalam checkboxDiv
    const checkboxInput = checkboxDiv.querySelector(".checkbox-input");

    // Tambahkan event listener pada label yang terkait dengan checkbox
    const label = checkboxDiv.querySelector(".checkbox-custom-label");
    label.addEventListener("click", (event) => {
      // Pastikan toggle dilakukan pada input checkbox
      if (event.target !== checkboxInput) {
        checkboxInput.checked = !checkboxInput.checked;
        //console.log(`Checkbox ${checkboxInput.id} status: ${checkboxInput.checked}`);
      }
    });
  });

  $(document).on("click", "#prev-step-btn-a", function () {
    let sessData = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    if (sessData) {
      sessData = JSON.parse(sessData);

      displayLoading();

      window.location.href = linkstep2 + "&pvt=" + sessData.Token;
    }
  });

  // CHECK TRIGGER BTN LANJUT. PASTIKAN ALL FIELD TERISI UNTUK ENABLE BUTTON

  // call warning valid saat pertama kali jika perlu
  // checkValidation();

  // call disable pertama kali
  checkForms();

  // Event listener untuk input, select, dan checkbox
  $(document).on("input change", "[required]", checkForms);
  $(document).on("select2:select", ".select2", checkForms);
  $(document).on("changeDate blur", ".dob", checkForms);

  // VALIDATION
  $(".passport-field").on("input", function () {
    let val = $(this)
      .val()
      .replace(/[^A-Za-z0-9]/g, "");
    if (val.length > 10) {
      val = val.substring(0, 10);
    }
    $(this).val(val);
  });
});
