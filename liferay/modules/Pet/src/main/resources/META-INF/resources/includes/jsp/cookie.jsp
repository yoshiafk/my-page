<div class="modal-cookie hide">
    <div class="d-block">
        <div class="text">
            <p>Laman ini menggunakan cookies untuk memastikan Anda mendapatkan pengalaman terbaik. Informasi lebih lanjut perihal informasi yang dikumpulkan dan digunakan silakan lihat Kebijakan Cookie dan Kebijakan Privasi</p>
        </div>
        <div class="button-wrapper mt-3">
            <button aria-label="Accept Cookie" class="btn btn-biru btn-block bold accept-cookie" type="button">MENGERTI</button>
        </div>
    </div>
</div>
<script type="text/javascript">
    function getCookie(name) {
        var nameEQ = name + "=";
        var ca = document.cookie.split(";");
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == " ") c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    }
    
    function acceptCookie() {
        var getcookie = getCookie("accept-cookies");
        var modal = $(".modal-cookie");
        var btn = $(modal).find(".accept-cookie");       
        
        if (!getcookie || getcookie == "undefined" || getcookie == "null") {
            $(modal).fadeIn();
            $(modal).removeClass("hide");
        }
    }
    
    //to run
    var waitForJQuery = setInterval(function () {
        if (typeof $ != 'undefined') {

            $(".accept-cookie").on("click", function (e) {
                e.stopPropagation();
                var cookieName = "accept-cookies";
                var modal = $(".modal-cookie");
                var options = { secure: true, "max-age": 31104000 };
                var value = "true";
                    
                $(modal).fadeOut();
                $(modal).addClass("hide");

                options = {
                    path: "/",
                    // secure: true,
                    "max-age": 31104000,
                };

                if (options.expires instanceof Date) {
                    options.expires = options.expires.toUTCString();
                }

                let updatedCookie = encodeURIComponent(cookieName) + "=" + encodeURIComponent(value);

                for (let optionKey in options) {
                    updatedCookie += "; " + optionKey;
                    let optionValue = options[optionKey];
                    if (optionValue !== true) {
                        updatedCookie += "=" + optionValue;
                    }
                }
                
                document.cookie = updatedCookie;
            });

            acceptCookie();
            clearInterval(waitForJQuery);
        }
    }, 10);    
</script>
<style type="text/css">
.modal-cookie {
  position: fixed;
  z-index: 10000;
  background: rgba(0, 0, 0, 0.9);
  color: #fff;
  padding: 20px;
  font-size: 12px;
  letter-spacing: 1px;
}
@media (min-width: 501px) {
  .modal-cookie {
    max-width: 384px;
    bottom: 20px;
    left: 20px;
  }
}
@media (max-width: 500px) {
  .modal-cookie {
    left: 10px;
    right: 10px;
    bottom: 0;
  }
}
.modal-cookie a {
  color: #fff;
  text-decoration: underline;
}
.modal-cookie p {
  color: #fff;
  font-family: 'Source Sans Pro', sans-serif;
  letter-spacing: 1px;
}
.modal-cookie .button-wrapper .btn {
  display: block;
  width: 100%;
}
.btn-biru {
    padding: 8px 26px;
    border-radius: 3px;
    background-color: #00008f;
    color: #fff;
    border-color: #00008f;
    text-transform: uppercase;
    font-weight: 600;
    letter-spacing: 1px;
}
.btn-biru:hover {
    color: #e6e6e6;
    background-color: #00005c;
    border-color: #00005c;
}
</style>