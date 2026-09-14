let skipLoad = false;

$(function () {
  var tblHeader = $("#table-header").DataTable({
    autoWidth: true,
    processing: true,
    serverSide: true,
    deferLoading: 0,
    ajax: {
      url: _apiURL + "/o/api/sppk/debitur/list",
      type: "POST",
      contentType: "application/json", // ubah ke JSON
      xhrFields: { withCredentials: true },
      beforeSend: function (xhr) {
        const csrfToken = $('input[name="csrfTokenApi"]').val();
        if (csrfToken) {
          xhr.setRequestHeader("X-CSRF-TOKEN", csrfToken);
        }
      },
      data: function (d) {
        if (skipLoad) {
          d._noLoad = true;
        }
        // extra parameter
        d.fullNameFilter = $('[name="input-name"]').val();
        d.idNumberFilter = $('[name="input-idNumber"]').val();
        d.createDateFilter = $('[name="input-createDate"]').val() ? $('[name="input-createDateAlt"]').val() : "";
        d.applicationNumberFilter = $('[name="input-applicationNumber"]').val();
        d.submissionNumberFilter = $('[name="input-submissionNumber"]').val();
        return JSON.stringify(d);
      },
      dataSrc: "data",
    },
    columns: [
      {
        data: "createDate",
        title: "Tanggal Pengajuan",
        render: function (data) {
          if (!data) return "-";

          const date = new Date(data);
          return date
            .toLocaleDateString("id-ID", {
              day: "2-digit",
              month: "short",
              year: "numeric",
            })
            .toUpperCase();
        },
      },
      {
        data: "submissionNumber",
        title: "Nomor Pengajuan",
        render: function (data) {
          if (!data) return "-";
          return data;
        },
      },
      {
        data: "status",
        title: "Status",
        render: function (data) {
          if (!data) return "";
          return data;
        }
      },
      { data: "fullName", title: "Nama" },
      { data: "idNumber", title: "NIK" },
      { data: "phoneNumber", title: "No. HP" },
      { data: "email", title: "Email" },
      {
        data: "sumInsured",
        title: "Limit Pengajuan",
        render: function (data) {
          return new Intl.NumberFormat("id-ID").format(data);
        },
      },
      { data: "product", title: "Produk Asuransi" },
      {
        data: "applicationNumber",
        title: "Nomor Aplikasi",
        render: function (data) {
          if (!data) return "-";
          return data;
        }
      },
      {
        data: "did",
        title: "Action",
        orderable: false,
        searchable: false,
        createdCell: function (td, cellData, rowData, row, col) {
          $(td).addClass("flex justify-center gap-2");

          if (rowData.isSubmittedSppk) {
            $(td).html(`
              <button class="btn btn-sm btn--sienna-outline self-end font-semibold"
                      data-target="${cellData}">
                <span class="relative z-10 flex justify-center">
                  <span>SPPK</span>
                </span>
              </button>
            `);
          } else {
            $(td).css("height", "24px");
            $(td).html("");
          }
        },
      },
    ],
    paging: true,
    pageLength: 10,
    pagingType: "simple_numbers",
    lengthMenu: [
      [10, 25, 50, -1],
      [10, 25, 50, "All"],
    ],
    dom: "<'flex flex-col overflow-x-auto'tr>" + "<'flex flex-wrap items-center justify-between mt-4'<'text-sm text-gray-500'i><'flex items-center space-x-2'p><'text-sm'l>>",
    order: [[0, "desc"]],
    language: {
      info: "Show _END_ of _TOTAL_",
      paginate: {
        next: ">",
        previous: "<",
      },
      lengthMenu: "Show _MENU_",
      processing: "Loading data...",
    },
  });

  tblHeader.on("xhr.dt", function () {
    skipLoad = false;
  });

  $("#filter-data-btn").on("click", function () {
    const fullNameFilter = ($("#input-name").val() || "").trim();
    const idNumberFilter = ($("#input-idNumber").val() || "").trim();
    const applicationNumberFilter = ($("#input-applicationNumber").val() || "").trim();
    const submissionNumberFilter = ($("#input-submissionNumber").val() || "").trim();
    const createDateFilter = ($('[name="input-createDateAlt"]').val() || "").trim();

    const dateFilled = createDateFilter.length > 0;
    const othersEmpty =
        fullNameFilter.length === 0 &&
        idNumberFilter.length === 0 &&
        applicationNumberFilter.length === 0 &&
        submissionNumberFilter.length === 0;

    if (dateFilled && othersEmpty) {
        alert("Pencarian berdasarkan Tanggal Pengajuan harus disertai minimal satu filter tambahan. Silakan isi filter lainnya untuk melanjutkan pencarian.");
        return;
    }

    tblHeader.ajax.reload(); // reload data dengan filter
  });

  $("#reset-data-btn").on("click", function () {
    $("#input-name").val("");
    $("#input-idNumber").val("");
    $("#input-birthDate").val("");
    $("#input-birthDateAlt").val("");
    $("#input-createDate").val("");
    $('[name="input-createDateAlt"]').val("");
    $("#input-applicationNumber").val("");
    $("#input-submissionNumber").val("");

    skipLoad = true;

    tblHeader.ajax.reload(); // reload data dengan filter
  });

  $(".nav-link--logout").click(function (e) {
    e.preventDefault();

    $.ajax({
      url: _signoutURL,
      type: "POST",
      dataType: "json",
      success: function (response) {
        if (response.Status) {
          setTimeout(() => (window.location.href = "/aii-sppk/login"), 1000);
        }
      },
    });
  });

  $("#table-header tbody").on("click", "button", function () {
    const target = $(this).data("target");
    window.location.href = _nextStepURL + "&" + ns + "t=" + target;
  });

  $(".nav-link").click(function (e) {
    e.preventDefault();
    window.location.href = this.href;
  });

  const ModalDebitur = document.getElementById("ModalDebitur");
  const ModalEditDebitur = document.getElementById("ModalEditDebitur");

  $.validator.addMethod(
    "emailWithTLD",
    function (value, element) {
      return this.optional(element) || /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value);
    },
    "Format tidak valid"
  );

  $("#formDebitur").validate({
    rules: {
      name: {
        required: true,
      },
      birthPlace: {
        required: true,
      },
      birthDate: {
        required: true,
      },
      idNumber: {
        required: true,
      },
      address: {
        required: true,
      },
      occupation: {
        required: true,
      },
      email: {
        required: true,
        email: true,
        emailWithTLD: true,
      },
      phoneNumber: {
        required: true,
      },
      gender: {
        required: true,
      },
      sumInsured: {
        required: true,
      },
      product: {
        required: true,
      },
    },
    messages: {
      name: {
        required: "Wajib diisi",
      },
      birthPlace: {
        required: "Wajib diisi",
      },
      birthDate: {
        required: "Wajib diisi",
      },
      idNumber: {
        required: "Wajib diisi",
      },
      address: {
        required: "Wajib diisi",
      },
      occupation: {
        required: "Wajib diisi",
      },
      email: {
        required: "Wajib diisi",
        email: "Format tidak valid",
        emailWithTLD: "Format tidak valid",
      },
      phoneNumber: {
        required: "Wajib diisi",
      },
      gender: {
        required: "Wajib diisi",
      },
      sumInsured: {
        required: "Wajib diisi",
      },
      product: {
        required: "Wajib diisi",
      },
    },
  });

  ModalDebitur.addEventListener("shown.bs.modal", (event) => {
    $("#applicationNumber").val("");
    $("#name").val("");
    $("#idNumber").val("");
    $("#address").val("");
    $("#birthPlace").val("");
    $("#birthDate").val("");
    $("#birthDateAlt").val("");
    $("#email").val("");
    $("#phoneNumber").val("");
    $("#sumInsured").val("");
    $("#occupation").val(null).trigger("change");
    $("#gender").val(null).trigger("change");
    $("#product").val(null).trigger("change");

    $("#occupation")
      .select2({
        dropdownParent: "#occupation-wrapper",
        placeholder: "Pilih tipe pekerjaan",
        width: "100%",
        minimumResultsForSearch: -1,
      })
      .on("change", function () {
        $(this).valid();
      });

    $("#gender")
      .select2({
        dropdownParent: "#gender-wrapper",
        placeholder: "Pilih jenis kelamin",
        width: "100%",
        minimumResultsForSearch: -1,
      })
      .on("change", function () {
        $(this).valid();
      });

    $("#product")
      .select2({
        dropdownParent: "#product-wrapper",
        placeholder: "Pilih produk asuransi",
        width: "100%",
        minimumResultsForSearch: -1,
      })
      .on("change", function () {
        $(this).valid();
      });
  });

  $("#formEditDebitur").validate({
    rules: {
      nameEdit: {
        required: true,
      },
      birthPlaceEdit: {
        required: true,
      },
      birthDateEdit: {
        required: true,
      },
      idNumberEdit: {
        required: true,
      },
      addressEdit: {
        required: true,
      },
      occupationEdit: {
        required: true,
      },
      emailEdit: {
        required: true,
        email: true,
        emailWithTLD: true,
      },
      phoneNumberEdit: {
        required: true,
      },
      genderEdit: {
        required: true,
      },
      sumInsuredEdit: {
        required: true,
      },
      productEdit: {
        required: true,
      },
    },
    messages: {
      nameEdit: {
        required: "Wajib diisi",
      },
      birthPlaceEdit: {
        required: "Wajib diisi",
      },
      birthDateEdit: {
        required: "Wajib diisi",
      },
      idNumberEdit: {
        required: "Wajib diisi",
      },
      addressEdit: {
        required: "Wajib diisi",
      },
      occupationEdit: {
        required: "Wajib diisi",
      },
      emailEdit: {
        required: "Wajib diisi",
        email: "Format tidak valid",
        emailWithTLD: "Format tidak valid",
      },
      phoneNumberEdit: {
        required: "Wajib diisi",
      },
      genderEdit: {
        required: "Wajib diisi",
      },
      sumInsuredEdit: {
        required: "Wajib diisi",
      },
      productEdit: {
        required: "Wajib diisi",
      },
    },
  });

  ModalEditDebitur.addEventListener("shown.bs.modal", (event) => {
    $("#occupationEdit").select2({
      dropdownParent: "#occupation-wrapper-edit",
      placeholder: "Pilih tipe pekerjaan",
      width: "100%",
      minimumResultsForSearch: -1,
    });

    $("#genderEdit").select2({
      dropdownParent: "#gender-wrapper-edit",
      placeholder: "Pilih jenis kelamin",
      width: "100%",
      minimumResultsForSearch: -1,
    });

    $("#productEdit").select2({
      dropdownParent: "#product-wrapper-edit",
      placeholder: "Pilih produk asuransi",
      width: "100%",
      minimumResultsForSearch: -1,
    });
  });

  $('input[name="birthDate"]').daterangepicker({
    parentEl: ".calendar-birth-date",
    autoUpdateInput: false,
    singleDatePicker: true,
    showDropdowns: true,
    buttonClasses: "btn-date",
    applyButtonClasses: "btn-apply",
    cancelClass: "btn-cancel",
    startDate: moment().subtract(18, "years").endOf("day"),
    minDate: moment().subtract(51, "years").startOf("day"),
    maxDate: moment().subtract(18, "years").endOf("day"),
    locale: {
      firstDay: 1,
      applyLabel: "Pilih",
      cancelLabel: "Batal",
      daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
      monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
    },
  });

  $('input[name="birthDate"]').on("apply.daterangepicker", function (ev, picker) {
    $('input[name="birthDateAlt"]').val(picker.startDate.format("YYYY-MM-DD")).trigger("change");
  });

  $('input[name="birthDate"]').on("cancel.daterangepicker", function (ev, picker) {
    $(this).val("");
    $('input[name="birthDateAlt"]').val("");
  });

  $('input[name="birthDateEdit"]').daterangepicker({
    parentEl: ".calendar-birth-date-edit",
    autoUpdateInput: false,
    singleDatePicker: true,
    showDropdowns: true,
    buttonClasses: "btn-date",
    applyButtonClasses: "btn-apply",
    cancelClass: "btn-cancel",
    startDate: moment().subtract(18, "years").endOf("day"),
    minDate: moment().subtract(51, "years").startOf("day"),
    maxDate: moment().subtract(18, "years").endOf("day"),
    locale: {
      firstDay: 1,
      applyLabel: "Pilih",
      cancelLabel: "Batal",
      daysOfWeek: ["Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"],
      monthNames: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
    },
  });

  $('input[name="birthDateEdit"]').on("apply.daterangepicker", function (ev, picker) {
    $('input[name="birthDateEditAlt"]').val(picker.startDate.format("YYYY-MM-DD"));
  });

  $('input[name="birthDateEdit"]').on("cancel.daterangepicker", function (ev, picker) {
    $(this).val("");
    $('input[name="birthDateEditAlt"]').val("");
  });

  $('input[name="birthDate"], input[name="birthDateEdit"]').on("apply.daterangepicker", function (ev, picker) {
    const formattedDate = picker.startDate.format("DD/MMM/YYYY");

    $(this).val(formattedDate).trigger("change").valid();
  });

  $('input[name="birthDate"], input[name="birthDateEdit"]').on("cancel.daterangepicker", function (ev, picker) {
    $(this).val("");
  });

  $(document).on("input", "#sumInsured, #sumInsuredEdit", function () {
    let raw = $(this).val().replace(/\D/g, "");
    const max = 1000000000;
    if (raw !== "" && Number(raw) > max) {
      raw = max.toString();
    }
    value = new Intl.NumberFormat("id-ID").format(raw);
    $(this).val(value);
  });

  $(document).on("change", "#sumInsuredEdit", function () {
    let raw = $(this).val().replace(/\D/g, "");
    const max = 1000000000;
    if (raw !== "" && Number(raw) > max) {
      raw = max.toString();
    }
    value = new Intl.NumberFormat("id-ID").format(raw);
    $(this).val(value);
  });

  // MODAL
  const modalEditDebitur = new bootstrap.Modal(document.getElementById("ModalEditDebitur"));

  // SUBMIT CREATE DEBITUR
  $("#formDebitur").on("submit", function (e) {
    e.preventDefault();
    let formArray = $(this).serializeArray();
    let jsonData = {};

    $.each(formArray, function (_, field) {
      jsonData[field.name] = field.value;
    });

    jsonData.TokenLimiter = $('input[name="csrfToken"]').val();

    if ($(this).valid()) {
      $.ajax({
        url: createDebiturURL,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(jsonData),
        success: function (response) {
          if (response.Status) {
            alert(response.Message);
            window.location.reload();
          } else {
            $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
            alert(response.Message);
          }
        },
        error: function (xhr) {
          let response = JSON.parse(xhr.responseText);

          if (response.Data && response.Data.TokenLimiter) {
            $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
          }

          alert(response.Message || "Gagal menambahkan data debitur");
        },
        complete: function () {},
      });
    }
  });

  $(document).on("click", ".edit-debitur-btn", function (e) {
    let rowData = tblHeader.row($(this).closest("tr")).data();
    $('input[name="did"]').val(rowData["did"]);
    $('input[name="applicationNumberEdit"]').val(rowData["applicationNumber"]);
    $('input[name="nameEdit"]').val(rowData["fullName"]);
    $('input[name="birthPlaceEdit"]').val(rowData["birthPlace"]);

    $('input[name="birthDateEdit"]').data("daterangepicker").setStartDate(moment(rowData["birthDate"], "YYYY-MM-DD HH:mm:ss.S"));
    $('input[name="birthDateEdit"]').data("daterangepicker").element.trigger("apply.daterangepicker", $('input[name="birthDateEdit"]').data("daterangepicker"));

    $('input[name="idNumberEdit"]').val(rowData["idNumber"]);
    $('input[name="addressEdit"]').val(rowData["address"]);
    $('select[name="occupationEdit"]').val(rowData["occupation"].toUpperCase()).trigger("change");
    $('input[name="emailEdit"]').val(rowData["email"]);
    $('input[name="phoneNumberEdit"]').val(rowData["phoneNumber"]);
    $('select[name="genderEdit"]').val(rowData["gender"].toUpperCase()).trigger("change");
    $('input[name="sumInsuredEdit"]').val(rowData["sumInsured"]).trigger("change");
    $('select[name="productEdit"]').val("ASURANSI PROTEKSI KECELAKAAN DIRI PLUS").trigger("change");

    modalEditDebitur.show();
  });

  // EDIT DEBITUR
  $("#formEditDebitur").on("submit", function (e) {
    e.preventDefault();
    let formArray = $(this).serializeArray();
    let jsonData = {};

    $.each(formArray, function (_, field) {
      jsonData[field.name] = field.value;
    });

    jsonData.TokenLimiter = $('input[name="csrfToken"]').val();

    if ($(this).valid()) {
      $.ajax({
        url: editDebiturUrl,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(jsonData),
        success: function (response) {
          if (response.Status) {
            alert(response.Message);
            window.location.reload();
          } else {
            $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
            alert(response.Message);
          }
        },
        error: function (xhr) {
          let response = JSON.parse(xhr.responseText);

          if (response.Data && response.Data.TokenLimiter) {
            $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
          }

          alert(response.Message || "Gagal menambahkan data debitur");
        },
        complete: function () {},
      });
    }
  });

  $(".btn-cancel-create-debitur").on("click", function () {
    $("#applicationNumber").val("");
    $("#name").val("");
    $("#idNumber").val("");
    $("#address").val("");
    $("#birthPlace").val("");
    $("#birthDate").val("");
    $("#birthDateAlt").val("");
    $("#email").val("");
    $("#phoneNumber").val("");
    $("#sumInsured").val("");
    $("#occupation").val(null).trigger("change");
    $("#gender").val(null).trigger("change");
    $("#product").val(null).trigger("change");
  });
});