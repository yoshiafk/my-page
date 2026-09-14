$(document).ready(function () {
	
	
  var masterData = {};
  function formatRupiah(bilangan, prefix) {
    var number_string = bilangan.replace(/[^,\d]/g, "").toString(),
      split = number_string.split(","),
      sisa = split[0].length % 3,
      rupiah = split[0].substr(0, sisa),
      ribuan = split[0].substr(sisa).match(/\d{1,3}/gi);

    if (ribuan) {
      separator = sisa ? "." : "";
      rupiah += separator + ribuan.join(".");
    }

    rupiah = split[1] != undefined ? rupiah + "," + split[1] : rupiah;

    return prefix == undefined ? rupiah : rupiah ? "Rp. " + rupiah : "";
  }

  function limitCharacter(event) {
    key = event.which || event.keyCode;
    if (
      key != 9 &&
      key != 188 && // Comma
      key != 8 && // Backspace
      key != 17 &&
      (key != 86) & (key != 67) && // Ctrl c, ctrl v
      (key < 48 || key > 57) &&
      key < 96 &&
      key > 105 // Non digit
    ) {
      event.preventDefault();
      return false;
    }
  }

  var AmtTmp = document.getElementById("idHarga");
  AmtTmp.addEventListener("keyup", function (e) {
    $("#idHargaTmp").val(AmtTmp.value.replace(/\./g, "").replace(",", "."));
    AmtTmp.value = formatRupiah(this.value);
  });

  AmtTmp.addEventListener("keydown", function (event) {
    limitCharacter(event);
  });

  // CLOSE DATE INIT
  $("#CloseDate").datepicker({
    autoclose: true,
    dateFormat: "dd/mm/yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "-100:+100",
    todayHighlight: true,
  });
  $("#CloseDate").datepicker("setDate", new Date());

  var sDate = $("#CloseDate").datepicker("getDate");

  // START DATE INIT
  $("#StartDate").datepicker({
    autoclose: true,
    dateFormat: "dd/mm/yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "-100:+100",
    todayHighlight: true,
  });
  $("#StartDate").datepicker("setDate", new Date());

  // END DATE INIT
  $("#EndDate").datepicker({
	  dateFormat: "dd/mm/yy",
  });

  $("#EndDate").datepicker("setDate", new Date());

  // INIT SELECT
  $("#Pertanggungan").html("<option value='' > Loading... </option>");
  $("#KelasKonstruksi").html("<option value='' > Loading... </option>");
  $("#Periode").html("<option value='' > Loading... </option>");

  // INIT MASTER DATA
  $.ajax({
    type: "POST",
    url: asmikEIPURL,
    dataType: "json",
    data: { cat: "fire", type: "MasterFire" },
    success: function (response) {
      if (response) {
        if (response.status) {
          masterData = response.data;
          // Init Pertanggungan / Okupansi
          var htmlPertanggungan = "<option value='' >-- Pilih --</option>";
          $.each(response.data.occupancy, function (i, v) {
            htmlPertanggungan += "<option value='" + v.key + "'>" + v.name + "</option>";
          });
          $("#Pertanggungan").html(htmlPertanggungan);

          // Init Kelas konstruksi
          var htmlkk = "<option value='' >-- Pilih --</option>";
          $.each(response.data.constructionClass, function (i, v) {
            htmlkk += "<option value='" + v.code + "'>" + v.name + "</option>";
          });
          $("#KelasKonstruksi").html(htmlkk);

//          // Init Tenor
//          var htmlTenor = "<option value='' >-- Pilih --</option>";
//          $.each(response.data.tenor, function (i, v) {
//            htmlTenor += "<option value='" + v.key + "'>" + v.text + "</option>";
//          });
//          $("#Periode").html(htmlTenor);
          
          // Init Tenor
          var htmlTenor = "<option value=''>-- Pilih --</option>";
          // Sort berdasarkan key ascending
          var sortedTenor = response.data.tenor.sort(function(a, b) {
            return parseInt(a.key) - parseInt(b.key);
          });

          $.each(sortedTenor, function(i, v) {
            htmlTenor += "<option value='" + v.key + "'>" + v.text + "</option>";
          });

          $("#Periode").html(htmlTenor);
          
          
          /**
           * ENHANCE UPDATE API
           * SET BENEFIT OPTION DARI API SEBELUMNYA HARDCODE
           */
          
          // Init Benefit
          var htmlBenefit = "<option value='' >-- Pilih --</option>";
          $.each(response.data.jenisPertanggungan, function (i, v) {
        	  htmlBenefit += "<option value='" + v.key + "'>" + v.text + "</option>";
          });
          $("#Benefit").html(htmlBenefit);

        }
      }
    },
  });

  // CLOSE DATE CHANGE
  $("#CloseDate").change(function () {
    var cDate = $("#CloseDate").datepicker("getDate");
    var sDate = $("#StartDate").datepicker("getDate");

    if (sDate > cDate) {
      var daydif = new Date(sDate - cDate) / 1000 / 60 / 60 / 24;
      if (daydif > 30) {
        var clsDate = $("#CloseDate").datepicker("getDate");
        var maxDate = clsDate.setDate(clsDate.getDate() + 30);
        var futureDate = new Date(maxDate);
        var dateStr = futureDate.toString();
        var dateArr = dateStr.split(" ");
        alert("Pengajuan FutureDated maksimal " + dateArr[2] + " " + dateArr[1] + " " + dateArr[3] + "!");
        $("#CloseDate").datepicker("setDate", new Date());
        $("#StartDate").datepicker("setDate", new Date());
        $("#idRate").val("N/A");
        $("#idPremi").val("N/A");
      }
    } else {
      var daydif = new Date(cDate - sDate) / 1000 / 60 / 60 / 24;
      if (daydif > 30) {
        var clsDate = $("#CloseDate").datepicker("getDate");
        var maxDate = clsDate.setDate(clsDate.getDate() - 30);
        var backDate = new Date(maxDate);
        var dateStr = backDate.toString();
        var dateArr = dateStr.split(" ");
        alert("Pengajuan BackDated maksimal " + dateArr[2] + " " + dateArr[1] + " " + dateArr[3] + "!");
        $("#StartDate").datepicker("setDate", new Date());
        $("#CloseDate").datepicker("setDate", new Date());
        $("#idRate").val("N/A");
        $("#idPremi").val("N/A");
      }
    }
  });

  // START DATE CHANGE
  $("#StartDate").change(function () {
    var cDate = $("#CloseDate").datepicker("getDate");
    var sDate = $("#StartDate").datepicker("getDate");

    var limitDate = new Date("02/01/2022");

    if (sDate < limitDate) {
      alert("Kalkulator berlaku untuk tanggal mulai asuransi 1 Februari 2022 dan sesudahnya !");
      $("#StartDate").datepicker("setDate", new Date());
      $("#idRate").val("N/A");
      $("#idPremi").val("N/A");
    }

    if (sDate > cDate) {
      var daydif = new Date(sDate - cDate) / 1000 / 60 / 60 / 24;
      if (daydif > 30) {
        var clsDate = $("#CloseDate").datepicker("getDate");
        var maxDate = clsDate.setDate(clsDate.getDate() + 30);
        var futureDate = new Date(maxDate);
        var dateStr = futureDate.toString();
        var dateArr = dateStr.split(" ");
        alert("Pengajuan FutureDated maksimal " + dateArr[2] + " " + dateArr[1] + " " + dateArr[3] + "!");
        $("#CloseDate").datepicker("setDate", new Date());
        $("#StartDate").datepicker("setDate", new Date());
        $("#idRate").val("N/A");
        $("#idPremi").val("N/A");
      }
    } else {
      var daydif = new Date(cDate - sDate) / 1000 / 60 / 60 / 24;
      if (daydif > 30) {
        var clsDate = $("#CloseDate").datepicker("getDate");
        var maxDate = clsDate.setDate(clsDate.getDate() - 30);
        var backDate = new Date(maxDate);
        var dateStr = backDate.toString();
        var dateArr = dateStr.split(" ");
        alert("Pengajuan BackDated maksimal " + dateArr[2] + " " + dateArr[1] + " " + dateArr[3] + "!");
        $("#StartDate").datepicker("setDate", new Date());
        $("#CloseDate").datepicker("setDate", new Date());
        $("#idRate").val("N/A");
        $("#idPremi").val("N/A");
      }
    }

    sDate = $("#StartDate").datepicker("getDate");

    var periode = parseInt($("#Periode").val());
    var eDate = sDate.setMonth(sDate.getMonth() + periode);
    var endDate = new Date(eDate);
    $("#EndDate").datepicker("setDate", endDate);
  });

  // BENEFIT / JENIS PERTANGGUNGAN CHANGE EVENT
  $("#Benefit").change(function () {
	  console.log('Benefit change');
    callGetRate();
  });

  // KELAS KONSTRUKSI CHANGE
  $("#KelasKonstruksi").change(function () {
    document.getElementById("idDeskripsiKelas").style.fontSize = 10;
    document.getElementById("idDeskripsiKelas").style.color = "blue";
    $("#idDeskripsiKelas").text("");

    let kelasKonstruksiVal = $(this).val();
    let kelasKonstruksiFilter = masterData.constructionClass.filter((v, i, arr) => {
      return v.code === kelasKonstruksiVal;
    });

    $("#idDeskripsiKelas").text(kelasKonstruksiFilter[0].description);

    callGetRate();
  });

  // PERTANGGUNGAN CHANGE
  $("#Pertanggungan").change(function () {
    let pertanggunanVal = $(this).val();

    let occupancyFilter = masterData.occupancy.filter((v, i, arr) => {
      return v.key == pertanggunanVal;
    });

    $("#idKodeOkupansi").val(occupancyFilter[0].key);
    $("#idDeskripsi").val(occupancyFilter[0].description);

    callGetRate();
  });

  $("#Periode").change(function () {
    var periode = parseInt($("#Periode").val());
    var sDate = $("#StartDate").datepicker("getDate");
    var eDate = sDate.setMonth(sDate.getMonth() + periode);
    var endDate = new Date(eDate);
    $("#EndDate").datepicker("setDate", endDate);

    callGetRate();
  });

  $("#idHarga").change(function () {
    var tipe = $("#Pertanggungan").val();
    var tenor = $("#Periode").val();
    var kelas = $("#KelasKonstruksi").val();
    var coverage = $("#Benefit").val();

    var harga = parseFloat($("#idHargaTmp").val());

    document.getElementById("errorHarga").hidden = "hidden";

    callGetRate();
  });

  // GET RATE
  function callGetRate() {
    console.log("get rate running...");

    var periode = parseInt($("#Periode").val());
    var sDate = $("#StartDate").datepicker("getDate");
    var eDate = sDate.setMonth(sDate.getMonth() + periode);
    var endDate = new Date(eDate);
    $("#EndDate").datepicker("setDate", endDate);

    var tipe = $("#Pertanggungan").val();
    var tenor = $("#Periode").val();
    var kelas = $("#KelasKonstruksi").val();
    var coverage = $("#Benefit").val();

    var harga = parseFloat($("#idHargaTmp").val());

//     console.log("tenor: " + tenor);
//     console.log("pertanggungan:" + tipe);
//     console.log("kelas:" + kelas);
//     console.log("jenis pertanggungan:" + coverage);
//     console.log("harga:" + harga);

    /*if (harga > 500000000) {
      alert("Harga Pertanggungan melebihi batas maksimal Rp. 500,000,000 !");*/
      
    
    /* point 3. nilai pertanggungan 500 jt -> 3M */
      if (harga > 3000000000) {
          alert("Harga Pertanggungan melebihi batas maksimal Rp. 3,000,000,000 !");
        
      
      document.getElementById("errorHarga").hidden = "";
      $("#idRate").val("N/A");
      $("#idPremi").val("N/A");
      return false;
    }

    if (harga > 0 && tipe != "" && coverage != "" && tenor != "" && kelas != "") {
      $.ajax({
        type: "POST",
        url: asmikEIPURL,
        dataType: "json",
        data: { cat: "fire", type: "RateFire", tenor: tenor, pertanggungan: tipe, kelas: kelas, jenis_pertanggungan: coverage, harga: harga },
        success: function (response) {
          $("#idRate").val(response.data.Rate.replace(".", ","));
          $("#idRateTmp").val(response.data.Rate);
          var rate = parseFloat($("#idRateTmp").val());
          var premi = parseFloat((harga * rate) / 1000).toFixed(0);

          $("#idPremi").val(formatRupiah(premi));

          // console.log(harga + "," + rate + "," + premi);
          //console.log(tipe + '/' + tenor + '/' + kelas + '/' + coverage + '/' + a.rate);
          document.getElementById("errorHarga").hidden = "hidden";
        },
      });
    }
  }
});

