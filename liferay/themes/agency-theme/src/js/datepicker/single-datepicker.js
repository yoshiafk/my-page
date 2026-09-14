// $(document).ready(function(){
// 	$( function() {
	
// 	// 	}).on('change', function() {
// 	// 		if($('#datepickerReminder').valid()){
// 	// 			$('#datepickerReminder').removeClass('invalid').addClass('success');   
// 	// 		}
// 	// });
// });
// 	$( function() {
// 	})
// });

// $('#ModalCreateReminder').on('shown.bs.modal', function () {
// 	alert("asd");
// 	$("#datepickerReminder").datepicker({
// 		container: '.modal',
// 		changeMonth: true,
// 		changeYear: true,
// 	})
// });

// $('#datepickerReminder').datepicker();
// $('#datepickerReminder').datepicker({ uiLibrary: 'bootstrap5' });

// $("#datepickerReminder").on('click', function(){
// 	$('.gj-picker-bootstrap').addClass('is-show');
// });


// $(document).mouseup(function(e){
// 	var containerCalendar = $(".is-show");

// 	if(!containerCalendar.is(e.target) && containerCalendar.has(e.target).length === 0){
// 		containerCalendar.removeClass('is-show');
// 	}
// });
// $(document).ready(function(){
// 	$(function() {
// 		$('[data-toggle="datepicker"]').datepicker({
// 			format: 'DD/MM/yyyy',
// 			daysMin: ['Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa','Su'],
// 			// monthsShort: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
// 			// months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
// 			autoHide: true,
// 			zIndex: 2048,
// 	});
// 	});
// });

$('#datepickerReminder').daterangepicker({
	parentEl: ".calendar",
	minYear: 2023,
	autoUpdateInput: false,
   singleDatePicker: true,
   showDropdowns: true,
   buttonClasses: "btn-date",
   applyButtonClasses: "btn-apply",
   cancelClass: "btn-cancel",
	minDate: new Date(),
	locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
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
});

$('#datepickerReminder').on('apply.daterangepicker', function(ev, picker) {
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

    const formattedDate = picker.startDate.format('DD MMMM YYYY');
    const englishMonth = picker.startDate.format('MMMM');

    const indonesianMonth = indonesianMonths[englishMonth];

    $(this).val(`${formattedDate.replace(englishMonth, indonesianMonth)}`);
  });
$('#datepickerReminder').on('cancel.daterangepicker', function(ev, picker) {
	$(this).val('');
});

var nowDate = new Date();
var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
var maxLimitDate = new Date(nowDate.getFullYear() + 1, nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
var minDateForSecondPicker;
moment.locale('id');

$('input[name="periode-promo"]').daterangepicker({
	parentEl: ".periode-mulai",
	minYear: 2023,
	autoUpdateInput: false,
   singleDatePicker: true,
   showDropdowns: true,
   buttonClasses: "btn-date",
   applyButtonClasses: "btn-apply",
   cancelClass: "btn-cancel",
	minDate: new Date(),
	maxDate: maxLimitDate,
	locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
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
});

$('input[name="periode-promo-selesai"]').daterangepicker({
	parentEl: ".periode-selesai",
	minYear: 2023,
	autoUpdateInput: false,
   singleDatePicker: true,
   showDropdowns: true,
   buttonClasses: "btn-date",
   applyButtonClasses: "btn-apply",
   cancelClass: "btn-cancel",
	minDate: new Date(),
	maxDate: maxLimitDate,
	locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
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
});

$('input[name="periode-promo-edit"]').daterangepicker({
	parentEl: ".periode-mulai-edit",
	minYear: 2023,
	autoUpdateInput: false,
   singleDatePicker: true,
   showDropdowns: true,
   buttonClasses: "btn-date",
   applyButtonClasses: "btn-apply",
   cancelClass: "btn-cancel",
	minDate: new Date(),
	maxDate: maxLimitDate,
	locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
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
});

$('input[name="periode-promo-selesai-edit"]').daterangepicker({
	parentEl: ".periode-selesai-edit",
	minYear: 2023,
	autoUpdateInput: false,
   singleDatePicker: true,
   showDropdowns: true,
   buttonClasses: "btn-date",
   applyButtonClasses: "btn-apply",
   cancelClass: "btn-cancel",
	minDate: new Date(),
	maxDate: maxLimitDate,
	locale: {
		firstDay: 1,
		applyLabel: 'Pilih', 
		cancelLabel: 'Batal',
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
});

$('input[name="periode-promo"], input[name="periode-promo-selesai"], input[name="periode-promo-edit"], input[name="periode-promo-selesai-edit"]').on('apply.daterangepicker', function(ev, picker) {
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

    const formattedDate = picker.startDate.format('DD MMMM YYYY');
    const englishMonth = picker.startDate.format('MMMM');

    const indonesianMonth = indonesianMonths[englishMonth];

    $(this).val(`${formattedDate.replace(englishMonth, indonesianMonth)}`);
  });
$('input[name="periode-promo"], input[name="periode-promo-selesai"], input[name="periode-promo-edit"], input[name="periode-promo-selesai-edit"]').on('cancel.daterangepicker', function(ev, picker) {
	$(this).val('');
});

