$(function () {
    var tblHeader = $("#table-header").DataTable({
        autoWidth: true,
        processing: true,
        serverSide: true,
        ajax: {
            url: _apiURL + "/o/api/sppk/monitoring/list",
            type: "POST",
            contentType: "application/json",
            xhrFields: { withCredentials: true },
            beforeSend: function (xhr) {
                const csrfToken = $('input[name="csrfTokenApi"]').val();
                if (csrfToken) {
                    xhr.setRequestHeader("X-CSRF-TOKEN", csrfToken);
                }
            },
            data: function (d) {
                d.fullNameFilter = $('[name="input-name"]').val();
                d.idNumberFilter = $('[name="input-idNumber"]').val();
                d.birthDateFilter = $('[name="input-birthDate"]').val() ? $('[name="input-birthDateAlt"]').val() : "";
                d.statusFilter = $('[name="input-status"]').val();
                d.submitEsppkDateFilter = $('[name="input-submitEsppkDate"]').val() ? $('[name="input-submitEsppkDateAlt"]').val() : "";
                d.applicationNumberFilter = $('[name="input-applicationNumber"]').val();
                d.submissionNumberFilter = $('[name="input-submissionNumber"]').val();
                return JSON.stringify(d);
            },
            dataSrc: "data"
        },
        columns: [
            {
                data: "submitEsppkDate",
                title: "Tanggal Pengajuan",
                render: function (data) {
                    if (!data) return "-";
                    const date = new Date(data);
                    return date.toLocaleDateString("id-ID", {
                        day: "2-digit",
                        month: "short",
                        year: "numeric",
                    }).toUpperCase();
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
            { data: "status", title: "Status" },
            { data: "fullName", title: "Nama" },
            { data: "idNumber", title: "NIK" },
            { data: "gender", title: "Jenis Kelamin" },
            {
                data: "birthDate",
                title: "Tanggal Lahir",
                render: function (data) {
                    if (!data) return "-";
                    const date = new Date(data);
                    return date.toLocaleDateString("id-ID", {
                        day: "2-digit",
                        month: "short",
                        year: "numeric",
                    }).toUpperCase();
                },
            },
            { data: "phoneNumber", title: "No. HP" },
            { data: "email", title: "Email" },
            { data: "address", title: "Alamat Domisili" },
            {
                data: "sumInsured",
                title: "Limit Pengajuan",
                render: function (data) {
                    return new Intl.NumberFormat("id-ID").format(data);
                },
            },
            { data: "occupation", title: "Tipe Pekerjaan" },
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
                data: "target",
                title: "Action",
                orderable: false,
                searchable: false,
                createdCell: function (td, cellData, rowData, row, col) {
                    $(td).addClass("flex justify-center");
                },
                render: function (target, type, row) {
                    return `<button class="btn btn-sm btn--sienna-outline self-end font-semibold" data-target="${target}">
                                <span class="relative z-10 flex justify-center">
                                    <span>SPPK</span>
                                </span>
                            </button>`;
                },
            },
        ],
        paging: true,
        pageLength: 10,
        pagingType: "simple_numbers",
        lengthMenu: [ [10, 25, 50, -1], [10, 25, 50, "All"] ],
        dom: "<'flex flex-col overflow-x-auto'tr>" +
               "<'flex flex-wrap items-center justify-between mt-4'<'text-sm text-gray-500'i><'flex items-center space-x-2'p><'text-sm'l>>",
        order: [[0, "desc"]],
        language: {
            info: "Show _END_ of _TOTAL_",
            paginate: {
                next: ">",
                previous: "<"
            },
            lengthMenu: "Show _MENU_",
            processing: "Loading data..."
        }
    });

    $("#filter-data-btn").on("click", function () {
        tblHeader.ajax.reload();
    });

    $("#reset-data-btn").on("click", function () {
        $('#input-name').val('');
        $('#input-idNumber').val('');
        $('#input-birthDate').val('');
        $('[name="input-birthDateAlt"]').val('');
        $('#input-status').val(null).trigger('change');
        $('#input-submitEsppkDate').val('');
        $('[name="input-submitEsppkDateAlt"]').val('');
        $('#input-applicationNumber').val('');
        $("#input-submissionNumber").val('');

        tblHeader.ajax.reload(); // reload data dengan filter
    });

    $('#table-header tbody').on('click', 'button', function () {
        const target = $(this).data('target');
        window.location.href = _nextStepURL + '&' + ns + 't=' + target;
    });

    $('.nav-link').click(function(e) {
        e.preventDefault();
        window.location.href = this.href;
    });

    $('.nav-link--logout').click(function(e) {
        e.preventDefault();

        $.ajax({
            url: _signoutURL,
            type: "POST",
            dataType: "json",
            success: function (response) {
                if (response.Status) {
                    setTimeout(() => window.location.href = "/aii-sppk/login", 1000);
                }
            }
        });
    });

    $('#input-status').select2({
        placeholder: "Pilih status",
        width: '100%',
        minimumResultsForSearch: -1
    });
});