$(document).ready(function () {
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

  // INIT PERIODE (TENOR)
  $.ajax({
    type: "POST",
    url: asmikEIPURL,
    dataType: "json",
    data: { cat: "pa", type: "PeriodePA"},
    beforeSend: function() {
    	$("#Periode").html("<option value='' >Loading...</option>");
    },
    success: function (response) {
      if (response) {
        if (response.status) {
          var html = "<option value='' >-- Pilih --</option>";
          $.each(response.data, function (i, v) {
            html += "<option value='" + parseInt(v.key) + "'>" + v.text + "</option>";
          });
          $("#Periode").html(html);
        }
      }
    },
  });

  // INIT TANGGAL MULAI
  $("#StartDate").datepicker({
    autoclose: true,
    dateFormat: "dd/mm/yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "-100:+100",
    todayHighlight: true,
  });

  $("#StartDate").datepicker("setDate", new Date());

  // INIT TANGGAL AKHIR
  $("#EndDate").datepicker({
	  dateFormat: "dd/mm/yy",
  });

  // INIT BIRTHDATE
  $("#BirthDate").datepicker({
    autoclose: true,
    dateFormat: "dd/mm/yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "-100:+100",
    todayHighlight: true,
  });

  $("#BirthDate").datepicker("setDate", new Date());

  // PERIODE (TENOR) CHANGE EVENT
  $("#Periode").change(function () {
    var periode = parseInt($("#Periode").val());
    var sDate = $("#StartDate").datepicker("getDate");
    var limitkredit = $("#idLimitTmp").val();

    var agestart = $("#ageStartTmp").val();
    var strDate = sDate;

    var eDate = new Date(strDate.setMonth(strDate.getMonth() + periode));

    var bDate = new Date($("#BirthDate").datepicker("getDate"));
    var agelast = 0;

    if (eDate > bDate) {
      var datediff = eDate - bDate;
      agelast = datediff / 1000 / 60 / 60 / 24 / 365;
    }

    agelast = agelast.toFixed(2);
    $("#ageLastTmp").val(agelast);
    $("#AgeLast").val(agelast.toString().replace(".", ","));
    $("#EndDate").datepicker("setDate", eDate);

    if (limitkredit > 500000000) {
      alert("Limit kredit melebihi batas ! Nilai pertanggungan max Rp500,000,000");
      $("#PremiTotal").val("N/A");
      $("#MagiRate").val("N/A");
      $("#AMFSRate").val("N/A");
      $("#TotalRate").val("N/A");
      document.getElementById("errorLimit").hidden = "";
    } else {
      if (periode > 0 && limitkredit > 0 && agestart != "" && agestart >= 18 && agestart <= 52) {
        callAPI();
        return false;
      }
      document.getElementById("errorLimit").hidden = "hidden";
    }
  });

  // TANGGAL MULAI CHANGE EVENT
  $("#StartDate").change(function () {
    var periode = parseInt($("#Periode").val());
    var sDate = $("#StartDate").datepicker("getDate");
    var bDate = new Date($("#BirthDate").datepicker("getDate"));
    var agestart = 0;
    var harga = $("#idLimitTmp").val();
    var tenor = $("#Periode").val();

    if (sDate > bDate) {
      agestart = new Date(sDate - bDate) / 1000 / 60 / 60 / 24 / 365;
    }

    agestart = agestart.toFixed(2);
    $("#ageStartTmp").val(agestart);
    $("#AgeStart").val(agestart.toString().replace(".", "."));

    //console.log('sDate = ' + sDate + ', bDate = ' + bDate + ', agestart = ' + agestart);

    var strDate = sDate;
    var eDate = new Date(strDate.setMonth(strDate.getMonth() + periode));
    $("#EndDate").datepicker("setDate", eDate);

    var agelast = 0;

    if (eDate > bDate) {
      agelast = new Date(eDate - bDate) / 1000 / 60 / 60 / 24 / 365;
    }
    $("#AgeLast").val(agelast.toFixed(2));

    if (agestart >= 52) {
      alert("Usia pertanggungan melebihi batas yang ditetapkan !");
      document.getElementById("errorAgeMax").hidden = "";
      document.getElementById("errorAgeMin").hidden = "hidden";
      $("#PremiTotal").val("N/A");
      $("#MagiRate").val("N/A");
      $("#AMFSRate").val("N/A");
      $("#TotalRate").val("N/A");
    } else {
      if (agestart <= 18) {
        alert("Usia pertanggungan kurang dari batas yang ditetapkan !");
        document.getElementById("errorAgeMin").hidden = "";
        document.getElementById("errorAgeMax").hidden = "hidden";
        $("#PremiTotal").val("N/A");
        $("#MagiRate").val("N/A");
        $("#AMFSRate").val("N/A");
        $("#TotalRate").val("N/A");
      } else {
        document.getElementById("errorAgeMin").hidden = "hidden";
        document.getElementById("errorAgeMax").hidden = "hidden";

        if (harga > 500000000) {
          document.getElementById("errorAgeMin").hidden = "hidden";
          document.getElementById("errorAgeMax").hidden = "hidden";
          alert("Limit kredit melebihi batas ! Nilai pertanggungan max Rp500,000,000");
          $("#PremiTotal").val("N/A");
          $("#MagiRate").val("N/A");
          $("#AMFSRate").val("N/A");
          $("#TotalRate").val("N/A");
          document.getElementById("errorLimit").hidden = "";
        } else {
          if (tenor > 0 && harga > 0 && agestart != "") {
            callAPI();
            return false;
          }
          document.getElementById("errorLimit").hidden = "hidden";
        }
      }
    }
  });

  // TANGGAL LAHIR CHANGE EVENT
  $("#BirthDate").change(function () {
    var sDate = $("#StartDate").datepicker("getDate");
    var eDate = $("#EndDate").datepicker("getDate");
    var bDate = $("#BirthDate").datepicker("getDate");
    var agestart = 0;
    var harga = $("#idLimitTmp").val();
    var tenor = $("#Periode").val();
    
    if(eDate) {
        var a = new Date(sDate);
        var b = new Date(bDate);
        var c = new Date(eDate);

        if (a > b) {
          var datediff = new Date(sDate - bDate);
          agestart = datediff / 1000 / 60 / 60 / 24 / 365;
        }

        if (c > b) {
          var agediff = new Date(eDate - bDate);
          var agelast = agediff / 1000 / 60 / 60 / 24 / 365;
        }

        agestart = agestart.toFixed(2);
        agelast = agelast.toFixed(2);
        $("#ageStartTmp").val(agestart);
        $("#AgeStart").val(agestart.toString().replace(".", ","));
        $("#AgeLast").val(agelast.toString().replace(".", ","));

        if (agestart >= 52) {
          alert("Usia pertanggungan melebihi batas yang ditetapkan !");
          document.getElementById("errorAgeMax").hidden = "";
          document.getElementById("errorAgeMin").hidden = "hidden";
          $("#PremiTotal").val("N/A");
          $("#MagiRate").val("N/A");
          $("#AMFSRate").val("N/A");
          $("#TotalRate").val("N/A");
        } else {
          if (agestart <= 18) {
            alert("Usia pertanggungan kurang dari batas yang ditetapkan !");
            document.getElementById("errorAgeMin").hidden = "";
            document.getElementById("errorAgeMax").hidden = "hidden";
            $("#PremiTotal").val("N/A");
            $("#MagiRate").val("N/A");
            $("#AMFSRate").val("N/A");
            $("#TotalRate").val("N/A");
          } else {
            document.getElementById("errorAgeMin").hidden = "hidden";
            document.getElementById("errorAgeMax").hidden = "hidden";

            if (harga > 500000000) {
              document.getElementById("errorAgeMin").hidden = "hidden";
              document.getElementById("errorAgeMax").hidden = "hidden";
              alert("Limit kredit melebihi batas ! Nilai pertanggungan max Rp500,000,000");
              $("#PremiTotal").val("N/A");
              $("#MagiRate").val("N/A");
              $("#AMFSRate").val("N/A");
              $("#TotalRate").val("N/A");
              document.getElementById("errorLimit").hidden = "";
            } else {
              if (tenor > 0 && harga > 0 && agestart != "") {
                callAPI();
                return false;
              }
              document.getElementById("errorLimit").hidden = "hidden";
            }
          }
        }	
    	
    	
    }
  });

  // NILAI PERTANGGUNGAN (LIMIT KREDIT)
  var AmtTmp = document.getElementById("idLimitKredit");

  AmtTmp.addEventListener("keyup", function (e) {
    $("#idLimitTmp").val(AmtTmp.value.replace(/\./g, "").replace(",", "."));
    AmtTmp.value = formatRupiah(this.value);
  });

  AmtTmp.addEventListener("keydown", function (event) {
    limitCharacter(event);
  });

  // NILAI PERTANGGUNGAN CHANGE EVENT
  $("#idLimitKredit").change(function () {
    var harga = $("#idLimitTmp").val();
    var agestart = $("#ageStartTmp").val();
    var tenor = $("#Periode").val();

    if (harga > 500000000) {
      alert("Limit kredit melebihi batas ! Nilai pertanggungan max Rp500,000,000");
      $("#PremiTotal").val("N/A");
      $("#MagiRate").val("N/A");
      $("#AMFSRate").val("N/A");
      $("#TotalRate").val("N/A");
      document.getElementById("errorLimit").hidden = "";
    } else {
      if (tenor > 0 && harga > 0 && agestart != "" && agestart <= 52 && agestart >= 18) {
        callAPI();
        return false;
      }
      document.getElementById("errorLimit").hidden = "hidden";
    }
  });

  // CALL API
  function callAPI() {
    $.ajax({
      type: "POST",
      url: asmikEIPURL,
      dataType: "json",
      data: { cat: "pa", type: "RatePA", tenor: $("#Periode").val() },
      success: function (response) {
        $("#idMagiTmp").val(response.data.Magi_Rate);
        $("#MagiRate").val(response.data.Magi_Rate.replace(".", ","));
        $("#idAMFSTmp").val(response.data.AMFS_Rate);
        $("#AMFSRate").val(response.data.AMFS_Rate.replace(".", ","));

        var totalRate = (parseFloat($("#idMagiTmp").val()) + parseFloat($("#idAMFSTmp").val())).toFixed(3);
        $("#idTotalTmp").val(totalRate);
        $("#TotalRate").val(totalRate.toString().replace(".", ","));

        var premitotal = (parseFloat($("#idTotalTmp").val()) * parseFloat($("#idLimitTmp").val())) / 1000;
        $("#PremiTotal").val(formatRupiah(premitotal.toFixed(0)));
        document.getElementById("errorLimit").hidden = "hidden";
      },
    });
  }
});
