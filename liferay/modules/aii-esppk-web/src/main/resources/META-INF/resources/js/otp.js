$(document).ready(function () {
  // OTP
  const $inputs = $(".otp-input");
  const $form = $("#form-otp");
  const $otpHidden = $("#otp-value");

  function updateOtpValue() {
    let otp = "";
    $inputs.each(function () {
      otp += $(this).val() || "";
    });
    $otpHidden.val(otp);
  }

  function allFilled() {
    let filled = true;
    $inputs.each(function () {
      if ($(this).val().trim() === "") {
        filled = false;
      }
    });
    return filled;
  }

  function submitIfComplete(e) {
    if (e.key === "Enter" && allFilled()) {
      updateOtpValue(); // pastikan hidden input terisi dulu
      $form.trigger("submit");
    }
  }

  // Input → auto pindah + update hidden input
  $inputs.on("input", function () {
    let $this = $(this);
    $this.val($this.val().replace(/\D/g, ""));

    if ($this.val().length === 1) {
      $this.next(".otp-input").focus();
    }

    updateOtpValue();
  });

  // Backspace → mundur + update hidden input
  $inputs.on("keydown", function (e) {
    if (e.key === "Backspace" && $(this).val() === "") {
      $(this).prev(".otp-input").focus();
    }

    submitIfComplete(e);
  });

  // Paste → isi berurutan + update hidden input
  $inputs.on("paste", function (e) {
    e.preventDefault();

    let clipboardData = (e.originalEvent || e).clipboardData;
    let pasted = clipboardData.getData("text").replace(/\D/g, "");
    if (!pasted) return;

    const start = $inputs.index(this);

    for (let i = 0; i < pasted.length && start + i < $inputs.length; i++) {
      $inputs.eq(start + i).val(pasted[i]);
    }

    let lastIndex = Math.min(start + pasted.length - 1, $inputs.length - 1);
    $inputs.eq(lastIndex).focus();

    updateOtpValue();
  });

  $form.on("submit", function (e) {
    e.preventDefault();
    console.log("submitted");

    const data = {
      otp: $("#otp-value").val().trim(),
      email: $("#user-email").val().trim(),
      TokenLimiter: $("input[name='csrfToken']").val().trim(),
    };

    $.ajax({
      url: _otpEntryURL,
      type: "POST",
      data: { data: JSON.stringify(data) },
      dataType: "json",
      xhrFields: {
        withCredentials: true,
      },
      beforeSend: function () {
        // $btn.prop("disabled", true).addClass("opacity-50").text("Loading....");
      },
      success: function (response) {
        if (response.Status) {
          setTimeout(() => (window.location.href = "/aii-sppk/dashboard"), 1000);
        } else {
          $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
          $(".alert").removeClass("alert-axa-success hidden").addClass("alert-axa-danger animate-vertical_slide");
          $(".alert-message").text(response.Message);
        }
      },
      complete: function () {
        // $btn.prop("disabled", false).removeClass("opacity-50").text("Login");
      },
    });
  });
});
