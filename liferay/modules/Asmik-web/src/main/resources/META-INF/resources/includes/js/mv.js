$(document).ready(function () {
  document.getElementById("errorAgeMsg").style.fontSize = 12;
  document.getElementById("errorAgeMsg").style.color = "red";
  document.getElementById("errorHargaMsg").style.fontSize = 12;
  document.getElementById("errorHargaMsg").style.color = "red";
  reset();

  // Tanggal sekarang
  $("#CloseDate").datepicker({
    autoclose: true,
    dateFormat: "dd/mm/yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "-100:+100",
    todayHighlight: true,
  });
  $("#CloseDate").datepicker("setDate", new Date());

  // Mulai asuransi
  $("#StartDate").datepicker({
    autoclose: true,
    dateFormat: "dd/mm/yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "-100:+100",
    todayHighlight: true,
  });
  $("#StartDate").datepicker("setDate", new Date());

  $("#EndDate").datepicker({
	  dateFormat: "dd/mm/yy",
  });

  // Tanggal Pengajuan Penutupan Asuransi change event
  $("#CloseDate").change(function () {
    var cDate = $("#CloseDate").datepicker("getDate");
    var sDate = $("#StartDate").datepicker("getDate");
  });

  // Tanggal Mulai Asuransi change event
  $("#StartDate").change(function () {
    var cDate = $("#CloseDate").datepicker("getDate");
    var sDate = $("#StartDate").datepicker("getDate");

    // Kalkulator hanya bisa digunakan untuk tanggal mulai asuransi 1 Februari 2022 dan sesudahnya
    var limitDate = new Date("02/01/2022");
    if (sDate < limitDate) {
      $("#StartDate").datepicker("setDate", new Date()).datepicker("hide").blur();
      $("#RateTLO").val("N/A");
      $("#RateSRCC").val("N/A");
      $("#idPremi").val("N/A");
      
      //ENHANCEMENT
      $("#RateSRCC_plusTS").val("N/A");
      $("#RateEQ").val("N/A");
      $("#RateFlood").val("N/A");
      
      alert("Kalkulator berlaku untuk tanggal mulai asuransi 1 Februari 2022 dan sesudahnya !");
      return;
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
        $("#RateTLO").val("N/A");
        $("#RateSRCC").val("N/A");
        $("#idPremi").val("N/A");
        
        //ENHANCEMENT
        $("#RateSRCC_plusTS").val("N/A");
        $("#RateEQ").val("N/A");
        $("#RateFlood").val("N/A");
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
        $("#RateTLO").val("N/A");
        $("#RateSRCC").val("N/A");
        $("#idPremi").val("N/A");
        
        //ENHANCEMENT
        $("#RateSRCC_plusTS").val("N/A");
        $("#RateEQ").val("N/A");
        $("#RateFlood").val("N/A");
      }
    }

    sDate = $("#StartDate").datepicker("getDate");

    var periode = parseInt($("#Periode").val());
    var eDate = sDate.setMonth(sDate.getMonth() + periode);
    var endDate = new Date(eDate);
    $("#EndDate").datepicker("setDate", endDate);
  });

  // JENIS KENDARAAN
  $.ajax({
    type: "POST",
    url: asmikEIPURL,
    dataType: "json",
    data: { cat: "mv", type: "MasterKendaraan"},
    beforeSend: function() {
    	$("#JenisKendaraan").html("<option value='' >Loading...</option>");
    },
    success: function (response) {
    	if(response) {
    	      if (response.status) {
    	          var html = "<option value='' >-- Pilih --</option>";
    	          $.each(response.data, function (i, v) {
    	            html += "<option value='" + v.key + "'>" + v.text + "</option>";
    	          });
    	          $("#JenisKendaraan").html(html);
    	        }	
    	}
    },
  });

  // #JenisKendaraan change event
  $("#JenisKendaraan").change(function () {
    updatePremi();
  });

  // USIA KENDARAAN
  $("#UsiaKendaraan").change(function () {
    updatePremi();
  });

  // HARGA PERTANGGUNGAN
  var AmtTmp = document.getElementById("Harga");
  AmtTmp.addEventListener("keyup", function (e) {
    $("#HargaTmp").val(AmtTmp.value.replace(/\./g, "").replace(",", "."));
    AmtTmp.value = formatRupiah(this.value);
  });

  AmtTmp.addEventListener("keydown", function (event) {
    limitCharacter(event);
  });

  $("#Harga").change(function () {
    updatePremi();
  });

  // ZONA
  $.ajax({
    type: "POST",
    url: asmikEIPURL,
    dataType: "json",
    data: { cat: "mv", type: "MasterZona"},
    beforeSend: function() {
    	$("#Zona").html("<option value='' >Loading...</option>");
    },
    success: function (response) {
    	
    	if(response) {
  	      if (response.status) {
  	          var html = "<option value='' >-- Pilih --</option>";
  	          $.each(response.data, function (i, v) {
  	            html += "<option value='" + v.key + "'>" + v.text + "</option>";
  	          });
  	        $("#Zona").html(html);
  	        }	
  	}

    },
  });

  $("#Zona").change(function () {
    updatePremi();
  });

  // BENEFIT
  $("#AddBenefit").change(function () {
	let value = $(this).val();
	
	if (value.toLowerCase() === 'yes') {
		$('#AddBenefit_SRCC_plusTS').prop('disabled', false);
	} else {
		$('#AddBenefit_SRCC_plusTS').prop('disabled', true);
		$("#AddBenefit_SRCC_plusTS").val("No").trigger('change');
	}
	  
    updatePremi();
  });
  
  /**
   * ENHANCE TRIGGER benefit 
   */
  $("#AddBenefit_EQ, #AddBenefit_SRCC_plusTS, #AddBenefit_Flood").change(function () {
	    updatePremi();
  });

  // PERIODE (TENOR)
  $.ajax({
    type: "POST",
    url: asmikEIPURL,
    dataType: "json",
    data: { cat: "mv", type: "MasterPeriod"},
    beforeSend: function() {
    	$("#Periode").html("<option value='' >Loading...</option>");
    },
    success: function (response) {
    	if(response) {
    	      if (response.status) {
    	          var html = "<option value='' >-- Pilih --</option>";
    	          $.each(response.data, function (i, v) {
    	            html += "<option value='" + v.key + "'>" + v.text + "</option>";
    	          });
    	        $("#Periode").html(html);
    	        }	
    	}
    },
  });
  $("#Periode").change(function () {
    var periode = parseInt($("#Periode").val());
    var sDate = $("#StartDate").datepicker("getDate");
    var eDate = sDate.setMonth(sDate.getMonth() + periode);
    var endDate = new Date(eDate);
    $("#EndDate").datepicker("setDate", endDate);

    updatePremi();
  });

  function reset() {
    $("#RateTLO").val("N/A");
    $("#RateSRCC").val("N/A");
    $("#idPremi").val("N/A");
    $("#RateTLOTmp").val(0);
    $("#RateSRCCTmp").val(0);
    $("#errorHargaMsg").text("").hide();
    $("#errorAgeMsg").text("").hide();
    $("#errorHarga").hide();
    $("#errorRate").hide();
    $("#errorAge").hide();
    
    
    //ENHANCEMENT
    $("#RateSRCC_plusTS").val("N/A");
    $("#RateSRCCTmp_plusTS").val(0);
    
    $("#RateEQ").val("N/A");
    $("#RateFlood").val(0);
    
    $("#RateFlood").val("N/A");
    $("#RateFloodTmp").val(0);
  }

  function updatePremi() {
	console.log('CALL PREMI FUNCTION');
    reset();

    var tipe = $("#JenisKendaraan").val();
    var harga = parseFloat($("#HargaTmp").val());
    var tenor = $("#Periode").val();
    var zona = $("#Zona").val();
    var srcc = $("#AddBenefit").val();
    
    /**
     * enhancement
     */
    var EQ = $("#AddBenefit_EQ").val();
    var SRCC_plusTS = $("#AddBenefit_SRCC_plusTS").val();
    var Flood = $("#AddBenefit_Flood").val();
    
    var age = $("#UsiaKendaraan").val();
    var tipeOJK = "";

    if (harga > 0 && tenor != "" && zona != "" && tipe != "" && age != "") {
      $.ajax({
        type: "POST",
        url: asmikEIPURL,
        dataType: "json",
//        data: { tipe: tipe, zona: zona, tenor: tenor, harga: harga, umur: age },
        data: { cat: "mv", type: "RateMV", vehicleType: tipe, zone: zona, duration: tenor, sumInsured: harga, age: age },
        success: function (response) {
          if (!response.status) {
        	
        	if (response.message.length > 1) {
        		 alert("Rate indikasi ! Check harga dan usia kendaraan !. Delivery Status : " + response.message);
        	}else{
        		alert("Rate indikasi ! Check harga dan usia kendaraan !");
        	}
        	  
            if (tipe == "1") {
              //if (harga < 3000000 || harga > 50000000) $("#errorHargaMsg").text("min harga pertanggungan Rp. 3.000.000, Max 50.000.000").show();
              
              //point 1.a min 3jt - max 1M
              if (harga < 3000000 || harga > 1000000000) $("#errorHargaMsg").text("Min harga pertanggungan Rp. 3.000.000, Max 1.000.000.000").show();
              
              if (age > 10) $("#errorAgeMsg").text("usia max 10 tahun").show();
            } else if (tipe == "2" || tipe == "3") {
              //if (harga < 10000000 || harga > 500000000) $("#errorHargaMsg").text("min harga pertanggungan Rp. 10.000.000, Max 500.000.000").show();
              
              //point 1.b min 10jt - max 2M
              if (harga < 10000000 || harga > 2000000000) $("#errorHargaMsg").text("Min harga pertanggungan Rp. 10.000.000, Max 2.000.000.000").show();
              
              
              if (age > 25) $("#errorAgeMsg").text("usia max 25 tahun").show();
            
            } else if (tipe == "4") { //penambahan kondisi else untuk poin 1.c
            	//point 1.c min 50jt - max 2M
                if (harga < 50000000 || harga > 2000000000) $("#errorHargaMsg").text("Min harga pertanggungan Rp. 50.000.000, Max 2.000.000.000").show();
                
                
                if (age > 25) $("#errorAgeMsg").text("usia max 25 tahun").show();
            }
          } else {
        	    // Rate TLO
        	    var rateTLO = parseFloat(response.data.RateTLO).toFixed(3);
        	    $("#RateTLO").val(rateTLO.replace(".", ","));
        	    $("#RateTLOTmp").val(response.data.RateTLO);

        	    // Rate SRCC
        	    var rateSRCC = 0;
        	    if (srcc == "Yes") {
        	        rateSRCC = parseFloat(response.data.RateRSCC).toFixed(3);
        	        $("#RateSRCC").val(rateSRCC.replace(".", ","));
        	        $("#RateSRCCTmp").val(response.data.RateRSCC);
        	    } else {
        	        $("#RateSRCC").val("N/A");
        	        $("#RateSRCCTmp").val("0");
        	        rateSRCC = 0;
        	    }

        	    /**
        	     * ENHANCEMENT
        	     */
        	    
        	    // Rate EQ
        	    var rateEQ = 0;
        	    if (EQ == "Yes") {
        	        rateEQ = parseFloat(response.data.RateEQ_T).toFixed(3);
        	        $("#RateEQ").val(rateEQ.replace(".", ","));
        	        $("#RateEQTmp").val(response.data.RateEQ_T);
        	    } else {
        	        $("#RateEQ").val("N/A");
        	        $("#RateEQTmp").val("0");
        	        rateEQ = 0;
        	    }

        	    // Rate SRCC_TS
        	    var rateRateSRCC_TS = 0;
        	    if (SRCC_plusTS == "Yes") {
        	        rateRateSRCC_TS = parseFloat(response.data.RateSRCC_TS).toFixed(3);
        	        $("#RateSRCC_plusTS").val(rateRateSRCC_TS.replace(".", ","));
        	        $("#RateSRCCTmp_plusTS").val(response.data.RateSRCC_TS);
        	    } else {
        	        $("#RateSRCC_plusTS").val("N/A");
        	        $("#RateSRCCTmp_plusTS").val("0");
        	        rateRateSRCC_TS = 0;
        	    }

        	    // Rate Flood
        	    var rateRateFlood = 0;
        	    if (Flood == "Yes") {
        	        rateRateFlood = parseFloat(response.data.RateFlood_T).toFixed(3);
        	        $("#RateFlood").val(rateRateFlood.replace(".", ","));
        	        $("#RateFloodTmp").val(response.data.RateFlood_T);
        	    } else {
        	        $("#RateFlood").val("N/A");
        	        $("#RateFloodTmp").val("0");
        	        rateRateFlood = 0;
        	    }
        	    

        	    // Hitung total rate & premi
        	    var totalrate = parseFloat(rateSRCC) + parseFloat(rateTLO) + parseFloat(rateEQ) + parseFloat(rateRateSRCC_TS) + parseFloat(rateRateFlood);
        	    var premi = ((harga * totalrate) / 100).toFixed(0);
        	    $("#idPremi").val(formatRupiah(premi));
        	}

        },
      });
    }
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
});
