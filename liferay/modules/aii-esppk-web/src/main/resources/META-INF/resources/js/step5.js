$(function () {
    const radioGroups = [
        "radio-first-sppk",
        "radio-second-sppk",
        "radio-third-sppk",
        "radio-polis"
    ];

    const $button = $(".btn__next");
    const $checkbox = $("#checkbox-persetujuan-1");

    radioGroups.forEach(function (name) {
        $(`input[name='${name}']`).on("change", validate);
    });

    $checkbox.on("change", validate);

    validate();

    $button.on("click", function (e) {
        if ($button.hasClass("btn--disabled")) {
            e.preventDefault();
            return false;
        }

        if (!isAllValid()) {
            e.preventDefault();
            alert("Silakan baca dan setujui RIPLAY, lengkapi semua pertanyaan SPPK, dan setujui pernyataan sebelum melanjutkan");
            return false;
        }

        handleAgreement();
    });

    function isAllValid() {
        const radiosChecked = radioGroups.every(function (name) {
            return $(`input[name='${name}']:checked`).length > 0;
        });

        const checkboxChecked = $checkbox.is(":checked");

        return radiosChecked && checkboxChecked;
    }

    function validate() {
        if (isAllValid()) {
            $button.removeClass("btn--disabled");
        } else {
            $button.addClass("btn--disabled");
        }
    }
})

function handleAgreement() {
    const $btn = $(".btn__next");

    const data = {
        agreeRiplay: $("input[name='radio-polis']:checked").val() || null,
        firstSppk: $("input[name='radio-first-sppk']:checked").val() || null,
        secondSppk: $("input[name='radio-second-sppk']:checked").val() || null,
        thirdSppk: $("input[name='radio-third-sppk']:checked").val() || null,
        agreeStatement: $("#checkbox-persetujuan-1").is(":checked"),
        TokenLimiter: $("input[name='csrfToken']").val().trim()
    };

    $.ajax({
        url: _signAgreementURL,
        type: "POST",
        data: { data: JSON.stringify(data) },
        dataType: "json",
        beforeSend: function () {
            $btn.prop("disabled", true).addClass("opacity-50");
        },
        success: function (response) {
            if (response.Status) {
                if (response.Message.toLowerCase() == "eligible") {
                    setTimeout(() => window.location.href = _successStepURL, 1000);
                } else {
                    setTimeout(() => window.location.href = _failedStepURL, 1000);
                }
            } else {
                $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
                alert(response.Message);
            }
        },
        complete: function () {
            $btn.prop("disabled", false).removeClass("opacity-50");
        }
    });
}