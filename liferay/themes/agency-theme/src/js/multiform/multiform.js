/**
 * @name Multi-step form - WIP
 * @description Prototype for basic multi-step form
 * @deps jQuery, jQuery Validate
 * Author By Sarah - https://codepen.io/smount
 */

var app = {

	init: function() {
		this.cacheDOM();
		this.setupAria();
		this.nextButton();
		this.prevButton();
		this.validateForm();
		this.startOver();
		this.editForm();
		this.finishForm();
		this.sendloginForm();
		this.forgotpassForm();
		this.sendforgotpassForm();
		this.sendforgoresettEmailForm();
		//this.finishCreatenewPassForm();
		this.accountActivationForm();
		this.enterAccountActivationForm();
		this.sendCreateReminderForm();
		this.sendPromoCodeForm();
		this.sendEditPromoCodeForm()
		this.killEnterKey();
		this.handleStepClicks();
	},

	cacheDOM: function() {
		if ($(".multi-step-form").length === 0) {
			return;
		}
		this.$formParent = $(".multi-step-form");
		this.$form = this.$formParent.find("form");
		this.$formedit = this.$formParent.find("form");
		this.$formStepParents = this.$form.find("fieldset"),
		this.$formStepParents = this.$formedit.find("fieldset"),

		this.$loginButton = this.$form.find(".btn-login");
		this.$nextButton = this.$form.find(".btn-next");
		this.$prevButton = this.$form.find(".btn-prev");
		this.$prevforgotpassButton = this.$form.find(".btn-prev-forgot-password");
		this.$prevactivationaccountButton = this.$form.find(".btn-prev-activation");
		this.$prevactivationaccountButton = this.$form.find(".btn-prev-activation");
		this.$editButton = this.$form.find(".btn-edit");
		this.$prevforgotpassModalButton = this.$form.find(".btn-prev-modal");
		this.$forgotpassButton = this.$form.find(".btn-forgot-password");
		this.$sendforgotpassButton = this.$form.find(".btn-send-forgotpass");
		this.$sendforgoresettEmailButton = this.$form.find(".btn-send-reset-email-password");
		//this.$finishCreatepassButton = this.$form.find(".btn-finish-create-new-password");
		this.$sendAccountActivationButton = this.$form.find(".btn-account-activation");
		this.$enterAccountActivationButton = this.$form.find(".btn-enter-account-activation");
		this.$sendCreateReminderButton = this.$form.find(".btn-create-reminder");
		this.$sendPromoCodeButton = this.$form.find(".btn-promo-code");
		this.$sendEditPromoCodeButton = this.$form.find(".btn-edit-promo-code");
		this.$finishButton = this.$form.find(".btn-finish");
		this.$resetButton = this.$form.find("[type='reset']");

		this.$stepsParent = $(".steps");
		this.$steps = this.$stepsParent.find("button");
		this.$stepsParentProgressBar = $(".steps-progressbar");
		this.$stepsProgressBar = this.$stepsParentProgressBar.find(".button-steps-progress");
	},

	htmlClasses: {
		activeClass: "active",
		hiddenClass: "hidden",
		hideCLass: "hide",
		showClass: 'show',
		visibleClass: "visible",
		editFormClass: "edit-form",
		animatedVisibleClass: "animated fadeIn",
		animatedHiddenClass: "animated fadeOut",
		animatingClass: "animating"
	},

	setupAria: function() {

		// set first parent to visible
		this.$formStepParents.eq(0).attr("aria-hidden", false);

		// set all other parents to hidden
		this.$formStepParents.not(":first").attr("aria-hidden", true);

		// handle aria-expanded on next/prev buttons
		app.handleAriaExpanded();

	},

	sendCreateReminderForm: function() {
		this.$sendCreateReminderButton.on("click", function(e) {
			e.preventDefault();
			var $this = $(this),
				modalCurrent = $("#ModalCreateReminder"),
				modal = $("#ModalSuccessReminder");
			if (app.checkForValidForm()) {
				modalCurrent.modal('hide');
			}
			// if (app.checkForValidForm()) {
			// 	modal.modal('show');
			// }
		});
	},

	sendPromoCodeForm: function() {
		this.$sendPromoCodeButton.on("click", function(e) {
			e.preventDefault();
			var $this = $(this),
				modalCurrent = $("#ModalPromoCode"),
				modal = $("#ModalSuccessPromoCode");
			// if (app.checkForValidForm()) {
			// 	modalCurrent.modal('hide');
			// }
			// if (app.checkForValidForm()) {
			// 	modal.modal('show');
			// }
		});
	},

	sendEditPromoCodeForm: function() {
		this.$sendEditPromoCodeButton.on("click", function(e) {
			e.preventDefault();
			var $this = $(this),
				modalCurrentEdit = $("#ModalEditPromoCode"),
				modalEdit = $("#ModalSuccessEditPromoCode");
			// if (app.checkForValidForm()) {
			// 	modalCurrentEdit.modal('hide');
			// }
			// if (app.checkForValidForm()) {
			// 	modalEdit.modal('show');
			// }
		});
	},

	enterAccountActivationForm: function() {
		this.$enterAccountActivationButton.on("click", function(e) {
			e.preventDefault();
			var $this = $(this),
				currentParent = $('#login').closest("fieldset"),
				nextParent = $("#account-activation").closest("fieldset"),
				login = $('#login').closest("fieldset"),
				validator = $("#formLogin").validate();

			currentParent.addClass(app.htmlClasses.visibleClass);
			login.removeClass(app.htmlClasses.visibleClass);
			validator.resetForm();
			setTimeout(function() {
				$('#ModalLoading').modal('hide');
				login.addClass(app.htmlClasses.hiddenClass);
				app.showNextStep(currentParent, nextParent);
				validator.resetForm();
			}, 4000);
		});
	},

	accountActivationForm: function() {
		this.$sendAccountActivationButton.on("click", function(e) {
			e.preventDefault();

//			var $this = $(this),
//				currentParent = $this.closest("fieldset"),
//				nextParent = $("#account-activation").closest("fieldset"),
			var	errorText = $('.error-text-wrapper')
//				otp = $("#otp").closest("fieldset"),
//				account = $('#account-activation').closest("fieldset")

			if (app.checkForValidForm()) {
//				currentParent.addClass(app.htmlClasses.visibleClass);
//				app.showNextStep(currentParent, nextParent);
//				otp.addClass(app.htmlClasses.visibleClass);
//				account.addClass(app.htmlClasses.hiddenClass);
//				account.removeClass(app.htmlClasses.visibleClass);
			} else {
				errorText.addClass('is-error');
			}
		});
		this.$prevactivationaccountButton.on("click", function(e) {
			e.preventDefault();
			var $this = $(this),
				login = $('#login').closest("fieldset"),
				accountactivation = $('#account-activation'),
				validator = $("#formLogin").validate();

			login.addClass(app.htmlClasses.visibleClass);
			login.removeClass(app.htmlClasses.hiddenClass);
			accountactivation.addClass(app.htmlClasses.hiddenClass);
			accountactivation.removeClass(app.htmlClasses.visibleClass);
			validator.resetForm();
		});
	},

	sendforgoresettEmailForm: function() {
		this.$sendforgoresettEmailButton.on("click", function(e) {

			e.preventDefault();

			// grab current step and next step parent
			var $this = $(this),
				currentParent = $this.closest("fieldset"),
				login = $('#login').closest("fieldset"),
				nextParent = currentParent.next();

			// if the form is valid hide current step
			// trigger next step
			if (app.checkForValidForm()) {
				currentParent.removeClass(app.htmlClasses.visibleClass);
				app.showNextStep(currentParent, nextParent);
			}

		});
	},

	sendloginForm: function() {
		this.$loginButton.on("click", function(e) { 
			e.preventDefault();

			var $this = $(this),
				currentParent = $this.closest("fieldset"),
				alertFailed = $("#alert-failed")
			
				if (app.checkForValidForm()) {
					currentParent.removeClass(app.htmlClasses.visibleClass);
					alertFailed.removeClass('hidden');
					console.log("berhasil");
				} else {
					alertFailed.addClass('hidden');
					console.log("gagal");
				}
		});
	},

	forgotpassForm: function() {
		this.$forgotpassButton.on("click", function(e) {
			e.preventDefault();

			var $this = $(this),
				currentParent = $('#forgotpass').closest("fieldset"),
				login = $('#login').closest("fieldset"),
				forgotpass = $('#forgotpass').closest("fieldset"),
				validator = $("#formLogin").validate();

			currentParent.addClass(app.htmlClasses.visibleClass);
			login.addClass(app.htmlClasses.hiddenClass);
			login.removeClass(app.htmlClasses.visibleClass);
			forgotpass.removeClass(app.htmlClasses.hiddenClass);
			validator.resetForm();

		});
		this.$prevforgotpassModalButton.on("click", function(e) {
			e.preventDefault();
			var $this = $(this),
				login = $('#login').closest("fieldset"),
				forgotpass = $('#forgotpass').find("fieldset"),
				validator = $("#formLogin").validate();

			login.addClass(app.htmlClasses.visibleClass);
			login.removeClass(app.htmlClasses.hiddenClass);
			forgotpass.addClass(app.htmlClasses.hiddenClass);
			forgotpass.removeClass(app.htmlClasses.visibleClass);
			validator.resetForm();
		});
		this.$prevforgotpassButton.on("click", function(e) {
			e.preventDefault();
			var $this = $(this),
				login = $('#login').closest("fieldset"),
				forgotpass = $('#forgotpass'),
				validator = $("#formLogin").validate();

				login.addClass(app.htmlClasses.visibleClass);
				login.removeClass(app.htmlClasses.hiddenClass);
				forgotpass.addClass(app.htmlClasses.hiddenClass);
				forgotpass.removeClass(app.htmlClasses.visibleClass);
				validator.resetForm();
		});
	},

	nextButton: function() {

		this.$nextButton.on("click", function(e) {

			e.preventDefault();

			// grab current step and next step parent
			var $this = $(this),
				// currentParent = $this.closest("fieldset"),
				errorText = $('.error-text-wrapper'),
				// nextParent = currentParent.next();
				modalCurrentEdit = $("#ModalEditPromoCode"),
				modalEdit = $("#ModalSuccessEditPromoCode");

			// if the form is valid hide current step
			// trigger next step
			if (app.checkForValidForm()) {
				// currentParent.removeClass(app.htmlClasses.visibleClass);
				// app.showNextStep(currentParent, nextParent);
				modalCurrentEdit.modal('hide');
				errorText.removeClass('is-error');
			} else {
				errorText.addClass('is-error');
				modalEdit.modal('show');
			}

		});
	},

	prevButton: function() {

		this.$prevButton.on("click", function(e) {

			e.preventDefault();

			// grab current step parent and previous parent
			var $this = $(this),
				currentParent = $(this).closest("fieldset"),
				prevParent = currentParent.prev();

			// hide current step and show previous step
			// no need to validate form here
			currentParent.removeClass(app.htmlClasses.visibleClass);
			app.showPrevStep(currentParent, prevParent);

		});
	},

	sendforgotpassForm: function() {
		this.$sendforgotpassButton.on("click", function(e) {
			e.preventDefault();

//			var $this = $(this),
//				currentParent = $this.closest("fieldset"),
				// modal = $("#ModalSuccessForgotpass"), 
			var	errorText = $('.error-text-wrapper')
//				nextParent = currentParent.next();

			if (app.checkForValidForm()) {
//				currentParent.removeClass(app.htmlClasses.visibleClass);
//				app.showNextStep(currentParent, nextParent);
				// modal.modal('show');
				errorText.removeClass('is-error');
			} else {
				errorText.addClass('is-error');
			}

		});
	},

	// finishCreatenewPassForm: function() {
	// 	this.$finishCreatepassButton.on("click", function(e) {

	// 		e.preventDefault();

	// 		// grab current step and next step parent
	// 		var $this = $(this),
	// 			currentParent = $this.closest("fieldset"),
	// 			errorText = $('.error-text-wrapper'),
	// 			modal = $("#ModalSuccessForgotpass"),
	// 			account = $("#account-activation").closest("fieldset"),
	// 			nextParent = currentParent.next();

	// 		// if the form is valid hide current step
	// 		// trigger next step
	// 		if (app.checkForValidForm()) {
	// 			currentParent.addClass(app.htmlClasses.visibleClass);
	// 			app.showNextStep(currentParent, nextParent);
	// 			account.removeClass(app.htmlClasses.visibleClass);
	// 			account.addClass(app.htmlClasses.hiddenClass);
	// 			modal.modal('show');
	// 			errorText.removeClass('is-error');
	// 		} else {
	// 			errorText.addClass('is-error');
	// 		}

	// 	});
	// },

	showNextStep: function(currentParent, nextParent) {

		// hide previous parent
		currentParent
			.addClass(app.htmlClasses.hiddenClass)
			.attr("aria-hidden", true);

		// show next parent
		nextParent
			.removeClass(app.htmlClasses.hiddenClass)
			.addClass(app.htmlClasses.visibleClass)
			.attr("aria-hidden", false);

		// focus first input on next parent
		// nextParent.focus();

		// browning: focus first input on next parent
		nextParent.find(":input").first().focus();

		// activate appropriate step
		app.handleState(nextParent.index());
		app.handleStateBar(nextParent.index());

		// handle aria-expanded on next/prev buttons
		app.handleAriaExpanded();

	},

	showPrevStep: function(currentParent, prevParent) {

		// hide previous parent
		currentParent
			.addClass(app.htmlClasses.hiddenClass)
			.attr("aria-hidden", true);

		// show next parent
		prevParent
			.removeClass(app.htmlClasses.hiddenClass)
			.addClass(app.htmlClasses.visibleClass)
			.attr("aria-hidden", false);

		// send focus to first input on next parent
		// prevParent.focus();

		// browning: send focus to first input on next parent
		prevParent.find(":input").first().focus();

		// activate appropriate step
		app.handleState(prevParent.index());
		app.handleStateBar(prevParent.index());

		// handle aria-expanded on next/prev buttons
		app.handleAriaExpanded();

	},

	handleAriaExpanded: function() {
		/*
			Loop thru each next/prev button
			Check to see if the parent it conrols is visible
			Handle aria-expanded on buttons
		*/
		$.each(this.$nextButton, function(idx, item) {
			var controls = $(item).attr("aria-controls");
			if ($("#" + controls).attr("aria-hidden") == "true") {
				$(item).attr("aria-expanded", false);
			} else {
				$(item).attr("aria-expanded", true);
			}
		});

		$.each(this.$prevButton, function(idx, item) {
			var controls = $(item).attr("aria-controls");
			if ($("#" + controls).attr("aria-hidden") == "true") {
				$(item).attr("aria-expanded", false);
			} else {
				$(item).attr("aria-expanded", true);
			}
		});

	},

	validateForm: function() {
		var ValidationCharactersRegex;

		$.validator.addMethod('ValidationCharactersRegex', function (value, element, parameter) {
			if (this.optional(element)) {
                return true;
            } else if (!/[A-Z]/.test(value)) {
                return false;
            } else if (!/[a-z]/.test(value)) {
                return false;
            } else if (!/[0-9]/.test(value)) {
                return false;
            }
			return value.match(ValidationCharactersRegex);
		}, '');

		this.$form.validate({
			onfocusout: false,
			onkeyup: false,
			ignore: ":hidden", // any children of hidden desc are ignored
			errorElement: "span", // wrap error elements in span not label
			validClass: 'success',
			errorClass: "error-text", // added error class to span
			errorLabelContainer: " .error-text-wrapper",

			rules: {
				'gender': {
					required: true
				},
				'email_agen': {
					required: true,
				},
				'password_agen': {
					required: true,
				},
				'email_forgotpassword': {
					required: true,
				},
				create_new_password: {
					minlength: 8,
					equalTo: "#confirm_new_password",
					ValidationCharactersRegex: true
				},
				confirm_new_password: {
					minlength: 8,
					equalTo: "#create_new_password",
					ValidationCharactersRegex: true
				},
				'old_password': {
					required: true,
				},
				'profile_old_password': {
					required: true,
				},
				change_profile_new_password: {
					minlength: 8,
					equalTo: "#change_profile_password_confirmation",
					ValidationCharactersRegex: true
				},
				change_profile_password_confirmation: {
					minlength: 8,
					equalTo: "#change_profile_new_password",
					ValidationCharactersRegex: true
				},
				'kode_agen_activation': {
					required: true
				},
				account_activation_password: {
					minlength: 8,
					equalTo: "#account_activation_password_confirmation",
					ValidationCharactersRegex: true
				},
				account_activation_password_confirmation: {
					minlength: 8,
					equalTo: "#account_activation_password",
					ValidationCharactersRegex: true
				},
//				'otp_1': {
//					required: true
//				},
//				'otp_2': {
//					required: true
//				},
//				'otp_3': {
//					required: true
//				},
//				'otp_4': {
//					required: true
//				},
//				'otp_5': {
//					required: true
//				},
//				'otp_6': {
//					required: true
//				},
				'otp_password_1': {
					required: true
				},
				'title': {
					required: true
				},
				'datepickerReminder': {
					required: true
				},
				'time': {
					required: true
				},
				'kode-promo': {
					required: true
				},
				'edit-kode-promo': {
					required: true
				},
				'Product': {
					required: true
				},
				'Product-edit': {
					required: true
				},
				// 'Terminologi-kodePromo': {
				// 	required: true
				// },
				'periode-promo': {
					required: true
				},
				'periode-promo-edit': {
					required: true
				},
				'periode-promo-selesai': {
					required: true
				},
				'periode-promo-selesai-edit': {
					required: true
				},
				'jumlah-diskon': {
					required: true
				},
				'Status': {
					required: true
				},
				'Status-edit': {
					required: true
				},
				'discount': {
					required: true
				},
				'discount-edit': {
					required: true
				},
				'name_contact': {
					required: true
				},
				'kode_agen_contact': {
					required: true
				},
				'email_contact': {
					required: true
				},
				'number_contact': {
					required: true
				},
				'number-hp': {
					required: true
				}
			},
			groups: {
				// otp: "otp_1 otp_2 otp_3 otp_4 otp_5 otp_6"
				create_new_password_group: "create_new_password confirm_new_password",
				create_new_password_activation_group: "account_activation_password account_activation_password_confirmation",
				change_profile_password_group: "change_profile_new_password change_profile_password_confirmation"
			},
			messages: {
				'email_agen': {
					required: 'Maaf Email / Kode Agen Anda tidak sesuai',
					email: 'Maaf Email / Kode Agen Anda tidak sesuai',
				},
				'password_agen': {
					required: 'Kata Sandi belum diisi',
				},
				'email_forgotpassword': {
					required: 'Maaf Email Anda tidak sesuai',
					email: 'Maaf Email Anda tidak sesuai'
				},
				create_new_password: {
					required: 'Harap isi Kata Sandi dan Konfirmasi Kata Sandi',
					equalTo: 'Konfirmasi Kata Sandi tidak sama',
					minlength: 'Harap masukkan 8 karakter',
					ValidationCharactersRegex: "Harus berisi huruf kapital, huruf kecil, angka dan simbol"
				},
				confirm_new_password: {
					required: 'Harap isi Kata Sandi dan Konfirmasi Kata Sandi',
					equalTo: 'Konfirmasi Kata Sandi tidak sama',
					minlength: 'Harap masukkan 8 karakter',
					ValidationCharactersRegex: "Harus berisi huruf kapital, huruf kecil, angka dan simbol"
				},
				'profile_old_password': {
					required: 'Harap isi Kata Sandi',
				},
				change_profile_new_password: {
					required: 'Harap isi Kata Sandi',
					equalTo: 'Konfirmasi Kata Sandi tidak sama',
					minlength: 'Harap masukkan 8 karakter',
					ValidationCharactersRegex: "Harus berisi huruf kapital, huruf kecil, angka dan simbol"
				},
				change_profile_password_confirmation: {
					required: 'Harap isi Kata Sandi',
					equalTo: 'Konfirmasi Kata Sandi tidak sama',
					minlength: 'Harap masukkan 8 karakter',
					ValidationCharactersRegex: "Harus berisi huruf kapital, huruf kecil, angka dan simbol"
				},
				'kode_agen_activation': {
					required: 'Kode Agen belum diisi'
				},
				account_activation_password: {
					required: 'Harap isi Kata Sandi dan Konfirmasi Kata Sandi',
					equalTo: 'Konfirmasi Kata Sandi tidak sama',
					minlength: 'Harap masukkan 8 karakter',
					ValidationCharactersRegex: "Harus berisi huruf kapital, huruf kecil, angka dan simbol"
				},
				account_activation_password_confirmation: {
					ValidationCharactersRegex: "Harus berisi huruf kapital, huruf kecil, angka dan simbol",
					required: 'Harap isi Kata Sandi dan Konfirmasi Kata Sandi',
					equalTo: 'Konfirmasi Kata Sandi tidak sama',
					minlength: 'Harap masukkan 8 karakter'
				},
				'otp_password_1': {
					required: 'Harap isi OTP dengan benar'
				},
//				'otp_1': {
//					required: 'Masukkan Kode OTP Anda'
//				},
//				'otp_2': {
//					required: 'Masukkan Kode OTP Anda'
//				},
//				'otp_3': {
//					required: 'Masukkan Kode OTP Anda'
//				},
//				'otp_4': {
//					required: 'Masukkan Kode OTP Anda'
//				},
//				'otp_5': {
//					required: 'Masukkan Kode OTP Anda'
//				},
//				'otp_6': {
//					required: 'Masukkan Kode OTP Anda'
//				},
				'title': {
					required: 'Wajib diisi'
				},
				'datepickerReminder': {
					required: 'Wajib dipilih'
				},
				'time': {
					required: 'Wajib diisi'
				},
				'edit-kode-promo': {
					required: 'Wajib diisi'
				},
				'kode-promo': {
					required: 'Wajib diisi'
				},
				'Product': {
					required: 'Wajib diisi'
				},
				'Product-edit': {
					required: 'Wajib diisi'
				},
				// 'Terminologi-kodePromo': {
				// 	required: 'Wajib diisi'
				// },
				'periode-promo': {
					required: 'Wajib diisi'
				},
				'periode-promo-edit': {
					required: 'Wajib diisi'
				},
				'periode-promo-selesai': {
					required: 'Wajib diisi'
				},
				'periode-promo-selesai-edit': {
					required: 'Wajib diisi'
				},
				'jumlah-diskon': {
					required: 'Wajib diisi'
				},
				'Status': {
					required: 'Wajib diisi'
				},
				'Status-edit': {
					required: 'Wajib diisi'
				},
				'discount': {
					required: 'Wajib diisi'
				},
				'discount-edit': {
					required: 'Wajib diisi'
				},
				'name_contact': {
					required: 'Wajib diisi'
				},
				'kode_agen_contact': {
					required: 'Wajib diisi'
				},
				'email_contact': {
					required: 'Wajib diisi'
				},
				'number_contact': {
					required: 'Wajib diisi'
				},
				'number-hp': {
					required: 'Wajib diisi'
				}
			},
			errorPlacement: function(error, element) {
				if (element.attr("name") == "Product")
					error.insertAfter("#product-wrapper")
				// else if (element.attr("name") == "Terminologi-kodePromo")
				// 	error.insertAfter("#terminologi-wrapper")
				else if (element.attr("name") == "Status")
					error.insertAfter("#status-wrapper")
				else if (element.attr("name") == "discount")
					error.insertAfter("#discount-wrapper")
				else if (element.attr("name") == "Product-edit")
					error.insertAfter("#product-edit-wrapper")
				else if (element.attr("name") == "Status-edit")
					error.insertAfter("#status-edit-wrapper")
				else if (element.attr("name") == "discount-edit")
					error.insertAfter("#discount-edit-wrapper")
				else if (element.attr("name") == "email_agen")
					error.appendTo("#login-failed"),
					error.hide();
				else if (element.attr("name") == "password_agen")
					error.appendTo("#login-failed"),
					error.hide();
				else if (element.attr("name") == "email_forgotpassword")
					error.appendTo("#forgotpass-failed"),
					error.hide();
				else if (element.attr("name") == "account_activation_password" || element.attr("name") == "account_activation_password_confirmation")
					error.appendTo("#activationaccount-failed"),
					error.hide();
				// else if (element.attr("name") == "kode_agen_activation")
				// 	error.appendTo("#activationaccount-failed"),
				// 	error.hide();
				// else if (element.attr("name") == "account_activation_password")
				// 	error.appendTo("#activationaccount-failed"),
				// 	error.hide();
				// else if (element.attr("name") == "account_activation_password_confirmation")
				// 	error.appendTo("#forgotpass-failed"),
				// 	error.hide();
				else if (element.attr("name") == "create_new_password" || element.attr("name") == "confirm_new_password" || element.attr("name") == "change_profile_new_password" || element.attr("name") == "change_profile_password_confirmation")
					error.appendTo("#confirmation-password-failed"),
					error.hide();
				// else if (element.attr("name") == "create_new_password")
				// 	error.appendTo("#createnew-password-failed"),
				// 	error.hide();
				// else if (element.attr("name") == "confirm_new_password")
				// 	error.appendTo("#createnew-password-failed"),
				// 	error.hide();
				else if (element.attr("name") == "otp_creatpass_1")
					error.appendTo("#createnew-password-failed"),
					error.hide();
				else if (element.attr("name") == "otp_creatpass_2")
					error.appendTo("#createnew-password-failed"),
					error.hide();
				else if (element.attr("name") == "otp_creatpass_3")
					error.appendTo("#createnew-password-failed"),
					error.hide();
				else if (element.attr("name") == "otp_creatpass_4")
					error.appendTo("#createnew-password-failed"),
					error.hide();
				else if (element.attr("name") == "otp_creatpass_5")
					error.appendTo("#createnew-password-failed"),
					error.hide();
				else if (element.attr("name") == "otp_creatpass_6")
					error.appendTo("#createnew-password-failed"),
					error.hide();
				else if (element.attr("type") == "radio") 
					error.insertBefore(element);
				else if (element.attr("type") == "gender") 
					error.insertBefore(element);
				else if (element.attr("name") == "otp_1" 
					|| element.attr("name") == "otp_2" || element.attr("name") == "otp_3" || element.attr("name") == "otp_4" || element.attr("name") == "otp_5" || element.attr("name") == "otp_6" )
					error.appendTo("#otp-error");
				else
					error.insertAfter(element);
					error.appendTo($('#login-failed'));
					error.appendTo($('#forgotpass-failed'));
					error.appendTo($('#confirmation-password-failed'));
					error.appendTo($('#createnew-password-failed'));
					error.appendTo($('#activationaccount-failed'));
		  	},
			showErrors: function(errorMap, errorList) {
            this.defaultShowErrors();
            $('#login-failed').removeClass('hidden');
				$('#forgotpass-failed').removeClass('hidden');
				$('#activationaccount-failed').removeClass('hidden');
        },
			invalidHandler: function(event, validator) { // add aria-invalid to el with error
				$.each(validator.errorList, function(idx, item) {
					if (idx === 0) {
						$(item.element).focus(); // send focus to first el with error
					}
					$(item.element).attr({
						"aria-invalid": true,
						"aria-required": true
					}); // add invalid aria added & aria-required
				})
			},
			submitHandler: function(form) {
				alert("form submitted!");
				form.submit();
			}
		});
	},

	checkForValidForm: function() {
		if (this.$form.valid()) {
			return true;
		}
	},

	startOver: function() {

		var $parents = this.$formStepParents,
			$firstParent = this.$formStepParents.eq(0),
			$formParent = this.$formParent,
			$stepsParent = this.$stepsParent,
			$stepsParentProgressBar = this.$stepsParentProgressBar;

		this.$resetButton.on("click", function(e) {

			// hide all parents - show first
			$parents
				.removeClass(app.htmlClasses.visibleClass)
				.addClass(app.htmlClasses.hiddenClass)
				.eq(0).removeClass(app.htmlClasses.hiddenClass)
				.eq(0).addClass(app.htmlClasses.visibleClass);

			// remove edit state if present
			$formParent.removeClass(app.htmlClasses.editFormClass);

			// manage state - set to first item
			app.handleState(0);
			app.handleStateBar(0);

			// reset stage for initial aria state
			app.setupAria();

			// send focus to first item
			setTimeout(function() {
				$firstParent.focus();
			}, 200);

		}); // click

	},

	handleState: function(step) {

		this.$steps.eq(step).prevAll().removeAttr("disabled");
		this.$steps.eq(step).addClass(app.htmlClasses.activeClass);
		

		// restart scenario
		if (step === 0) {
			this.$steps
				.removeClass(app.htmlClasses.activeClass)
				.attr("disabled", "disabled");
			this.$steps.eq(0).addClass(app.htmlClasses.activeClass)
		}
	},

	handleStateBar: function(step2) { 
		this.$stepsProgressBar.eq(step2).prevAll().removeAttr("disabled");
		this.$stepsProgressBar.eq(step2).addClass(app.htmlClasses.activeClass);
		

		// restart scenario
		if (step2 === 0) {
			this.$stepsProgressBar
				.removeClass(app.htmlClasses.activeClass)
				.attr("disabled", "disabled");
			this.$stepsProgressBar.eq(0).addClass(app.htmlClasses.activeClass)
		}
	},

	editForm: function() {
		var $formParent = this.$formParent,
			$formStepParents = this.$formStepParents,
			$stepsParent = this.$stepsParent,
			stepsParentProgressBar = this.stepsParentProgressBar;

		this.$editButton.on("click", function() {
			$formParent.toggleClass(app.htmlClasses.editFormClass);
			$formStepParents.attr("aria-hidden", false);
			$formStepParents.eq(0).find("input").eq(0).focus();
			app.handleAriaExpanded();
		});
	},

	killEnterKey: function() {
		$(document).on("keypress", ":input:not(textarea,button)", function(event) {
			return event.keyCode != 13;
		});
	},

	handleStepClicks: function() {

		var $stepTriggers = this.$steps,
			$stepTriggers2 = this.$stepsProgressBar,
			$stepParents = this.$formStepParents,
			$stepsParentProgressBar = this.$formStepParents;

		$stepTriggers.on("click", function(e) {

			e.preventDefault();

			var btnClickedIndex = $(this).index();

			// kill active state for items after step trigger
			$stepTriggers.nextAll()
				.removeClass(app.htmlClasses.activeClass)
				.attr("disabled", true);
			
			// $stepTriggers2.nextAll()
			// 	.removeClass(app.htmlClasses.activeClass)
			// 	.attr("disabled", true);

			// activate button clicked
			$(this)
				.addClass(app.htmlClasses.activeClass)
				.attr("disabled", false);

			$(this).prevAll()
				.addClass(app.htmlClasses.activeClass)
				.attr("disabled", false);
				
			// hide all step parents
			$stepParents
				.removeClass(app.htmlClasses.visibleClass)
				.addClass(app.htmlClasses.hiddenClass)
				.attr("aria-hidden", true);
			$stepsParentProgressBar
				.removeClass(app.htmlClasses.visibleClass)
				.addClass(app.htmlClasses.hiddenClass)
				.attr("aria-hidden", true);
			
			
			// show step that matches index of button
			$stepParents.eq(btnClickedIndex)
				.removeClass(app.htmlClasses.hiddenClass)
				.addClass(app.htmlClasses.visibleClass)
				.attr("aria-hidden", false)
				.focus();

			$stepsParentProgressBar.eq(btnClickedIndex)
				.removeClass(app.htmlClasses.hiddenClass)
				.addClass(app.htmlClasses.visibleClass)
				.attr("aria-hidden", false)
				.focus();


		});

		$stepTriggers2.on("click", function(e) {

			e.preventDefault();

			var btnClickedIndex2 = $(this).index();

			// kill active state for items after step trigger
			$stepTriggers2.nextAll()
				.removeClass(app.htmlClasses.activeClass)
				.attr("disabled", true);

			// activate button clicked
			$(this)
				.addClass(app.htmlClasses.activeClass)
				.attr("disabled", false)

			// hide all step parents

			$stepsParentProgressBar
				.removeClass(app.htmlClasses.visibleClass)
				.addClass(app.htmlClasses.hiddenClass)
				.attr("aria-hidden", true);

			// show step that matches index of button
			$stepsParentProgressBar.eq(btnClickedIndex2)
				.removeClass(app.htmlClasses.hiddenClass)
				.addClass(app.htmlClasses.visibleClass)
				.attr("aria-hidden", false)
				.focus();

		});

	},

	finishForm: function() {
		var $stepTriggers = this.$steps,
			$stepTriggers2 = this.$stepsProgressBar,
			$stepParents = this.$formStepParents,
			$stepsParentProgressBar = this.$formStepParents;

		$stepTriggers.on("click", function(e) {

			e.preventDefault();

			var btnClickedIndex = $(this).index();

			$stepParents.eq(btnClickedIndex)
				.removeClass(app.htmlClasses.hiddenClass)
				.addClass(app.htmlClasses.visibleClass)
				.attr("aria-hidden", false)
				.focus();

			$stepsParentProgressBar.eq(btnClickedIndex)
				.removeClass(app.htmlClasses.hiddenClass)
				.addClass(app.htmlClasses.visibleClass)
				.attr("aria-hidden", false)
				.focus();

		});


		$stepTriggers2.on("click", function(e) {

			e.preventDefault();

			var btnClickedIndex2 = $(this).index();

			$stepsParentProgressBar.eq(btnClickedIndex2)
				.removeClass(app.htmlClasses.hiddenClass)
				.addClass(app.htmlClasses.visibleClass)
				.attr("aria-hidden", false)
				.focus();

		});
	}
};

app.init();

// End Multi-step form