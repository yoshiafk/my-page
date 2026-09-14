// === main.js ===
// Global configuration untuk jQuery Validation Plugin
$.validator.setDefaults({
    ignore: ":hidden",
    errorElement: "span",
    errorClass: "error-text text-sm mt-10px mb-5px",

    // Taruh error tepat di bawah input
    errorPlacement: function(error, element) {
        const wrapper = element.closest(".input-text-wrapper");
        if (wrapper.length) {
            error.appendTo(wrapper); // taruh di dalam wrapper
        } else if (element.attr("name") == "occupation") {
            error.insertAfter("#occupation-wrapper")
        } else if (element.attr("name") == "occupationEdit") {
            error.insertAfter("#occupation-wrapper-edit")
        } else if (element.attr("name") == "gender") {
            error.insertAfter("#gender-wrapper")
        } else if (element.attr("name") == "genderEdit") {
            error.insertAfter("#gender-wrapper-edit")
        } else if (element.attr("name") == "product") {
            error.insertAfter("#product-wrapper")
        } else if (element.attr("name") == "productEdit") {
            error.insertAfter("#product-wrapper-edit")
        } else {
            error.insertAfter(element);
        }
    },

    highlight: function(element) {
        $(element)
            .addClass("error-text");
    },
    unhighlight: function(element) {
        $(element)
            .removeClass("error-text");
    }
});
