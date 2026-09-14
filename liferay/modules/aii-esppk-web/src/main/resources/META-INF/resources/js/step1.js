const RESEND_DELAY = 60;
const STORAGE_KEY = "resendOtpEndTime";
let resendTimer = null;

$(document).ready(function () {
  $("#formLogin").validate({
    rules: {
      username: {
        required: true,
        maxlength: 50,
      },
      password: {
        required: true,
        maxlength: 32,
      },
    },
    messages: {
      username: {
        required: "Wajib diisi",
        maxlength: "Maksimal 50 karakter",
      },
      password: {
        required: "Wajib diisi",
        maxlength: "Maksimal 32 karakter",
      },
    },
  });

  // Fungsi login AJAX
  function handleLogin() {
    const $btn = $("#btnLogin");

    const data = {
      username: $("#username").val().trim(),
      password: GetFieldData($("#password").val().trim()),
      TokenLimiter: $("input[name='csrfToken']").val().trim(),
    };

    $.ajax({
      url: _signinEntryURL,
      type: "POST",
      data: { data: JSON.stringify(data) },
      dataType: "json",
      xhrFields: {
        withCredentials: true,
      },
      beforeSend: function () {
        $btn.prop("disabled", true).addClass("opacity-50").text("Loading....");
      },
      success: function (response) {
        if (response.Status) {
          if(response.Type === 1) {
            setTimeout(() => window.location.href = "/aii-sppk/dashboard", 1000);
          } else {
            setTimeout(() => window.location.reload(), 1000);
          }
        } else {
          $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
          $(".alert").removeClass("alert-axa-success hidden").addClass("alert-axa-danger animate-vertical_slide");
          $(".alert-message").text(response.Message);
        }
      },
      complete: function () {
        $btn.prop("disabled", false).removeClass("opacity-50").text("Login");
      },
    });
  }

  // Saat tombol login diklik
  $("#btnLogin").on("click", function () {
    const form = $("#formLogin");

    if (form.valid()) {
      // Form valid
      handleLogin();
    }
  });

  const endTime = localStorage.getItem(STORAGE_KEY);

  if (endTime) {
    const remaining = Math.ceil((endTime - Date.now()) / 1000);

    if (remaining > 0) {
      startResendCountdown(
        $('#resend'),
        $('#resend').find('b'),
        remaining
      );
    } else {
      localStorage.removeItem(STORAGE_KEY);
    }
  }

  $('#resend-otp').on('submit', function(e) {
    e.preventDefault();

    const $btn = $('#resend');
    const $btnText = $btn.find('b');

    const data = {
      TokenLimiter: $("input[name='csrfToken']").val().trim(),
    };

    $.ajax({
      url: _resendOtpEntryURL,
      type: "POST",
      data: { data: JSON.stringify(data) },
      dataType: "json",
      xhrFields: {
        withCredentials: true,
      },
      beforeSend: function () {
        $btn.prop("disabled", true);
        $btnText.text("Mengirim....");
      },
      success: function (response) {
        if (response.Status) {
          // $(".alert-message").text("Kode OTP telah dikirim kembali.");
          alert("Kode OTP telah dikirim kembali.");
          $('input[name="csrfToken"]').val(response.Data.TokenLimiter);

          saveResendEndTime(RESEND_DELAY);
          startResendCountdown($btn, $btnText, RESEND_DELAY);
        } else {
          $('input[name="csrfToken"]').val(response.Data.TokenLimiter);
          $(".alert").removeClass("alert-axa-success hidden").addClass("alert-axa-danger animate-vertical_slide");
          $(".alert-message").text(response.Message);
          resetButton($btn, $btnText);
        }
      },
      error: function () {
        resetButton($btn, $btnText);
      },
    });
  });
});

function startResendCountdown($btn, $btnText, seconds) {
  let remaining = seconds;

  clearInterval(resendTimer);

  $btn.prop("disabled", true);
  $btnText.text(`Kirim ulang (${remaining}s)`);

  resendTimer = setInterval(function () {
    remaining--;

    if (remaining <= 0) {
      clearInterval(resendTimer);
      localStorage.removeItem(STORAGE_KEY);
      resetButton($btn, $btnText);
    } else {
      $btnText.text(`Kirim ulang (${remaining}s)`);
    }
  }, 1000);
}

function saveResendEndTime(seconds) {
  const endTime = Date.now() + seconds * 1000;
  localStorage.setItem(STORAGE_KEY, endTime);
}

function resetButton($btn, $btnText) {
  $btn.prop("disabled", false);
  $btnText.text("Kirim ulang");
}