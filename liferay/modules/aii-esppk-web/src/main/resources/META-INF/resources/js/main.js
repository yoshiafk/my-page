$("body").addClass("body-smoke text-base");
moment.locale('id');

$(function () {
    $(document).on('input', '.container-form input', function(e) {
        let fieldName = e.target.name;
        let fieldType = 'text';

        // Define specific field types
        if (fieldName.includes('email')) {
            fieldType = 'email';
        } else if (fieldName.includes('idNumber') || fieldName.includes('phoneNumber') || fieldName.includes('sumInsured')) {
            fieldType = 'num';
        } else if (fieldName.includes('birthPlace')) {
            fieldType = 'place';
        } else if (fieldName.includes('address')) {
            fieldType = 'addr';
        }

        if (!fieldName.includes('upload') && !fieldName.includes('applicationNumber') && !fieldName.includes('submissionNumber')) validateInput(e, fieldType);
    });

    $('input[name="input-birthDate"]').daterangepicker({
        parentEl: ".input-calendar-birth-date",
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        startDate: moment().subtract(18, 'years').endOf('day'),
        minDate: moment().subtract(51, 'years').startOf('day'),
        maxDate: moment().subtract(18, 'years').endOf('day'),
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

    $('input[name="input-submitEsppkDate"]').daterangepicker({
        parentEl: ".input-calendar-submit-date",
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        startDate: moment().endOf('day'),
        minDate: moment().subtract(5, 'years').startOf('day'),
        maxDate: moment().endOf('day'),
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

    $('input[name="input-createDate"]').daterangepicker({
        parentEl: ".input-calendar-create-date",
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        buttonClasses: "btn-date",
        applyButtonClasses: "btn-apply",
        cancelClass: "btn-cancel",
        startDate: moment().endOf('day'),
        minDate: moment().subtract(5, 'years').startOf('day'),
        maxDate: moment().endOf('day'),
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

    $('input[name="input-birthDate"], input[name="input-submitEsppkDate"], input[name="input-createDate"]').on('apply.daterangepicker', function(ev, picker) {
        const formattedDate = picker.startDate.format('DD MMMM YYYY');

        $(this).val(formattedDate);
        $('input[name="input-birthDateAlt"], input[name="input-submitEsppkDateAlt"], input[name="input-createDateAlt"]').val(picker.startDate.format("YYYY-MM-DD"));
    });

    $('input[name="input-birthDate"], input[name="input-submitEsppkDate"], input[name="input-createDate"]').on('cancel.daterangepicker', function(ev, picker) {
        $(this).val('');
        $('input[name="input-birthDateAlt"], input[name="input-submitEsppkDateAlt"], input[name="input-createDateAlt"]').val('');
    });
})

function validateInput(e, type) {
    let input = e.target;
    let value = input.value;

    const patterns = {
        text: /[^A-Za-z ]/g,          // Allow only letters and spaces
        num: /[^0-9]/g,               // Allow only numbers
        place: /[^A-Za-z.' \-]/g,
        addr: /[^A-Za-z0-9.,/ \-]/g,
    };

    // Remove invalid characters based on type
    if (patterns[type]) {
    	input.value = value.replace(patterns[type], '');
    }
}