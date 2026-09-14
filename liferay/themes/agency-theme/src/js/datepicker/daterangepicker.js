var nowDate = new Date();
var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
var maxLimitDate = new Date(nowDate.getFullYear() + 1, nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
var minDateForSecondPicker;
moment.locale('id');

$('input[name="periode-promo"]').daterangepicker({
	parentEl: ".periode-mulai",
  	autoUpdateInput: false,
	showDropdowns: true,
	singleDatePicker: true,
	minDate: new Date(),
	maxDate: maxLimitDate,
	buttonClasses: "btn-date",
	applyButtonClasses: "btn-apply",
	cancelClass: "btn-cancel",
	locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
		format: 'DD MMM YYYY',
		"daysOfWeek": [
			"Min",
			"Sen",
			"Sel",
			"Rab",
			"Kam",
			"Jum",
			"Sab"
		],
		"monthNames": [
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
		],
  }
}, function(start, end) {
	const indonesianMonths = {
        'January': 'Januari',
        'February': 'Februari',
        'March': 'Maret',
        'April': 'April',
        'May': 'Mei',
        'June': 'Juni',
        'July': 'Juli',
        'August': 'Agustus',
        'September': 'September',
        'October': 'Oktober',
        'November': 'November',
        'December': 'Desember'
    };

    const formattedDate = start.format('DD MMMM YYYY');
    const englishMonth = start.format('MMMM');

    const indonesianMonth = indonesianMonths[englishMonth];

    $("#periode-promo").val(`${formattedDate.replace(englishMonth, indonesianMonth)}`);
	$('#periode-promo').parent().parent().removeClass('has-error');

//   $("#periode-promo").val(start.format('DD MMM YYYY'));
//   console.log($("#periode-promo").val());

  var aMinDate = new Date(Date.parse(start));
  
$('input[name="periode-promo-selesai"]').daterangepicker({
	parentEl: ".periode-selesai",
	showDropdowns: true,
   autoUpdateInput: false,
   singleDatePicker: true,
   minDate: aMinDate,
   maxDate: maxLimitDate,
	buttonClasses: "btn-date",
	applyButtonClasses: "btn-apply",
	cancelClass: "btn-cancel",
   locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
      format: 'DD MMM YYYY',
		"daysOfWeek": [
			"Min",
			"Sen",
			"Sel",
			"Rab",
			"Kam",
			"Jum",
			"Sab"
		],
		"monthNames": [
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
		],
    }
  }, function(start, end) {
	const indonesianMonths = {
        'January': 'Januari',
        'February': 'Februari',
        'March': 'Maret',
        'April': 'April',
        'May': 'Mei',
        'June': 'Juni',
        'July': 'Juli',
        'August': 'Agustus',
        'September': 'September',
        'October': 'Oktober',
        'November': 'November',
        'December': 'Desember'
    };

    const formattedDate = start.format('DD MMMM YYYY');
    const englishMonth = start.format('MMMM');

    const indonesianMonth = indonesianMonths[englishMonth];

    $("#periode-promo-selesai").val(`${formattedDate.replace(englishMonth, indonesianMonth)}`);	
    $('#periode-promo-selesai').parent().parent().removeClass('has-error');

    // $("#periode-promo-selesai").val(start.format('DD MMM YYYY'));
  });
});

$('input[name="periode-promo-edit"]').daterangepicker({
	parentEl: ".periode-mulai-edit",
  	autoUpdateInput: false,
	showDropdowns: true,
	singleDatePicker: true,
	minDate: new Date(),
	maxDate: maxLimitDate,
	buttonClasses: "btn-date",
	applyButtonClasses: "btn-apply",
	cancelClass: "btn-cancel",
	locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
		format: 'DD MMM YYYY',
		"daysOfWeek": [
			"Min",
			"Sen",
			"Sel",
			"Rab",
			"Kam",
			"Jum",
			"Sab"
		],
		"monthNames": [
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
		],
  }
}, function(start, end) {
	const indonesianMonths = {
        'January': 'Januari',
        'February': 'Februari',
        'March': 'Maret',
        'April': 'April',
        'May': 'Mei',
        'June': 'Juni',
        'July': 'Juli',
        'August': 'Agustus',
        'September': 'September',
        'October': 'Oktober',
        'November': 'November',
        'December': 'Desember'
    };

    const formattedDate = start.format('DD MMMM YYYY');
    const englishMonth = start.format('MMMM');

    const indonesianMonth = indonesianMonths[englishMonth];

    $("#periode-promo-edit").val(`${formattedDate.replace(englishMonth, indonesianMonth)}`);
	$('#periode-promo-edit').parent().parent().removeClass('has-error');

//   $("#periode-promo").val(start.format('DD MMM YYYY'));
//   console.log($("#periode-promo").val());

  var aMinDate = new Date(Date.parse(start));
  
$('input[name="periode-promo-selesai-edit"]').daterangepicker({
	parentEl: ".periode-selesai-edit",
	showDropdowns: true,
   autoUpdateInput: false,
   singleDatePicker: true,
   minDate: aMinDate,
   maxDate: maxLimitDate,
	buttonClasses: "btn-date",
	applyButtonClasses: "btn-apply",
	cancelClass: "btn-cancel",
   locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
      format: 'DD MMM YYYY',
		"daysOfWeek": [
			"Min",
			"Sen",
			"Sel",
			"Rab",
			"Kam",
			"Jum",
			"Sab"
		],
		"monthNames": [
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
		],
    }
  }, function(start, end) {
	const indonesianMonths = {
        'January': 'Januari',
        'February': 'Februari',
        'March': 'Maret',
        'April': 'April',
        'May': 'Mei',
        'June': 'Juni',
        'July': 'Juli',
        'August': 'Agustus',
        'September': 'September',
        'October': 'Oktober',
        'November': 'November',
        'December': 'Desember'
    };

    const formattedDate = start.format('DD MMMM YYYY');
    const englishMonth = start.format('MMMM');

    const indonesianMonth = indonesianMonths[englishMonth];

    $("#periode-promo-selesai-edit").val(`${formattedDate.replace(englishMonth, indonesianMonth)}`);	
    $('#periode-promo-selesai-edit').parent().parent().removeClass('has-error');

    // $("#periode-promo-selesai").val(start.format('DD MMM YYYY'));
  });
});

// $('input[name="periode-promo"]').on('click', function(){
// 	$('.daterangepicker td.active').removeClass('active');
// 	$('.daterangepicker td.in-range').removeClass('in-range');
// 	$('.daterangepicker td.in-range').removeClass('in-range');
	
// });

if($('#Fromdateonline, #Todateonline').length){
	// check if element is available to bind ITS ONLY ON HOMEPAGE
	var currentDate = moment().format("DD MMM YYYY");

	$('#Fromdateonline, #Todateonline').daterangepicker({
		parentEl: ".calendar-wrapper",
		"alwaysShowCalendars": true,
		"minDate": currentDate,
		"showDropdowns": true,
		buttonClasses: "btn-date",
		applyButtonClasses: "btn-apply",
		cancelClass: "btn-cancel",
		autoApply: false,
		autoUpdateInput: false,
		locale: {
			firstDay: 1,
			applyLabel: 'Pilih', 
			cancelLabel: 'Batal',
			format: 'DD MMM YYYY',
			"daysOfWeek": [
				"Min",
				"Sen",
				"Sel",
				"Rab",
				"Kam",
				"Jum",
				"Sab"
			],
			"monthNames": [
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
			],
	  },
	}, function(start, end, label) {
	  // console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
	  // Lets update the fields manually this event fires on selection of range
	  var selectedStartDate = start.format('DD MMM YYYY'); // selected start
	  var selectedEndDate = end.format('DD MMM YYYY'); // selected end

	  $checkinInput = $('#Fromdateonline');
	  $checkoutInput = $('#Todateonline');

	  // Updating Fields with selected dates
	  $checkinInput.val(selectedStartDate);
	  $checkoutInput.val(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKOUT FIELD (To get this it must be binded by Ids not Calss)
	  var checkOutPicker = $checkoutInput.data('daterangepicker');
	  checkOutPicker.setStartDate(selectedStartDate);
	  checkOutPicker.setEndDate(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKIN FIELD (To get this it must be binded by Ids not Calss)
	  var checkInPicker = $checkinInput.data('daterangepicker');
	  checkInPicker.setStartDate(selectedStartDate);
	  checkInPicker.setEndDate(selectedEndDate);
	});
}

if($('#Frompdateall, #Topdateall').length){
	// check if element is available to bind ITS ONLY ON HOMEPAGE
	var currentDate = moment().format("DD MMM YYYY");

	$('#Frompdateall, #Topdateall').daterangepicker({
		parentEl: "#calendar-wrapper-policy-purchase-date",
		"alwaysShowCalendars": true,
		"minDate": currentDate,
		"showDropdowns": true,
		buttonClasses: "btn-date",
		applyButtonClasses: "btn-apply",
		cancelClass: "btn-cancel",
		autoApply: false,
		autoUpdateInput: false,
		locale: {
			firstDay: 1,
			applyLabel: 'Pilih', 
			cancelLabel: 'Batal',
			format: 'DD MMM YYYY',
			"daysOfWeek": [
				"Min",
				"Sen",
				"Sel",
				"Rab",
				"Kam",
				"Jum",
				"Sab"
			],
			"monthNames": [
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
			],
	  },
	}, function(start, end, label) {
	  // console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
	  // Lets update the fields manually this event fires on selection of range
	  var selectedStartDate = start.format('DD MMM YYYY'); // selected start
	  var selectedEndDate = end.format('DD MMM YYYY'); // selected end

	  $checkinInput = $('#Frompdateall');
	  $checkoutInput = $('#Topdateall');

	  // Updating Fields with selected dates
	  $checkinInput.val(selectedStartDate);
	  $checkoutInput.val(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKOUT FIELD (To get this it must be binded by Ids not Calss)
	  var checkOutPicker = $checkoutInput.data('daterangepicker');
	  checkOutPicker.setStartDate(selectedStartDate);
	  checkOutPicker.setEndDate(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKIN FIELD (To get this it must be binded by Ids not Calss)
	  var checkInPicker = $checkinInput.data('daterangepicker');
	  checkInPicker.setStartDate(selectedStartDate);
	  checkInPicker.setEndDate(selectedEndDate);
	});
}

if($('#Frombdateall, #Tobdateall').length){
	// check if element is available to bind ITS ONLY ON HOMEPAGE
	var currentDate = moment().format("DD MMM YYYY");

	$('#Frombdateall, #Tobdateall').daterangepicker({
		parentEl: "#calendar-wrapper-policy-effective-date",
		"alwaysShowCalendars": true,
		"minDate": currentDate,
		"showDropdowns": true,
		buttonClasses: "btn-date",
		applyButtonClasses: "btn-apply",
		cancelClass: "btn-cancel",
		autoApply: false,
		autoUpdateInput: false,
		locale: {
			firstDay: 1,
			applyLabel: 'Pilih', 
			cancelLabel: 'Batal',
			format: 'DD MMM YYYY',
			"daysOfWeek": [
				"Min",
				"Sen",
				"Sel",
				"Rab",
				"Kam",
				"Jum",
				"Sab"
			],
			"monthNames": [
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
			],
	  },
	}, function(start, end, label) {
	  // console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
	  // Lets update the fields manually this event fires on selection of range
	  var selectedStartDate = start.format('DD MMM YYYY'); // selected start
	  var selectedEndDate = end.format('DD MMM YYYY'); // selected end

	  $checkinInput = $('#Frombdateall');
	  $checkoutInput = $('#Tobdateall');

	  // Updating Fields with selected dates
	  $checkinInput.val(selectedStartDate);
	  $checkoutInput.val(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKOUT FIELD (To get this it must be binded by Ids not Calss)
	  var checkOutPicker = $checkoutInput.data('daterangepicker');
	  checkOutPicker.setStartDate(selectedStartDate);
	  checkOutPicker.setEndDate(selectedEndDate);

	  // Setting the Selection of dates on calender on CHECKIN FIELD (To get this it must be binded by Ids not Calss)
	  var checkInPicker = $checkinInput.data('daterangepicker');
	  checkInPicker.setStartDate(selectedStartDate);
	  checkInPicker.setEndDate(selectedEndDate);
	});
}