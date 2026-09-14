$(function () {
    'use strict';

    // remarks default value
    var $_remarks_default = {};
    // custom plan id
    var $_custom_plan_id;
    
    function init() {
    	// remarks default value
        $('.remarks-value').each(function(key) {
            $_remarks_default[$(this).attr('name')] = $(this).data('default');
        });
        
    	// set field
        let sessionData = getSessionData(_sessionName);
        
    	if(sessionData) {    	
    		updateFormGeneral(sessionData);
    		updateFormStep1_2(sessionData);
    	}
    	
        $_custom_plan_id = $('#step1-page').data('customplan');

        // select
        $('.selectize').selectize();
        $('.item .plan:checked').closest('.row').addClass('bg-blue-400');
        $('.plan:checked').siblings('label').html('Plan Dipilih');

        // user custom amount
        if($("#UserCustom").is(':checked')) {
            $('.remarks-input').prop("readonly", false);
        } else {
            $('.remarks-input').prop("readonly", true);
        }

        checkCustomPlan();

        //calculate        
        if(validateForm(false)) {
        	jqAjaxJSON({}, calculateURL, function(msg) {
                if(msg && msg['Status']) {
                    if(msg['Data'] && msg['Data']['Discount']) $('.promo .info').html($('#promocode').val()+' berhasil dipakai.');
                    updateSidebar(msg['Data']);
                    loadingBtnNext(true);
                }
            });
        }
    }

    function initTrigger() {
        
        $('body').on('change', '#sidebar-plan', function() {
            checkCustomPlan();
        });

        $('body').on('click', '#UserCustom', function() {
            if($(this).is(':checked')) {
                $('.remarks-input').prop("readonly", false);
                
                SessionStorage.set(_sessionName, "UserCustom", 1);
            } else {
                $('.remarks-input').prop("readonly", true);
                
                SessionStorage.set(_sessionName, "UserCustom", 0);
                resetRemarks();
            }
        });

        $('body').on('change', '.remarks-input', function() {
            var string = $(this).val();
                string = string.replace(/\./g,'');
            $(this).siblings('input').val(string).change();
        });

        $('body').on('change', '.remarks-value', function() {
            var btnText = $('.next-step').html();

            // validate remarks
            if(validateRemarks() == false) {
                $('.next-step').prop('disabled', true);
                return false;
            } else {
                $('.next-step').prop('disabled', false);
            }

            // loading
            $('.next-step').html('<span class="spinner-border spinner-border-sm mr-2 mb-1" role="status" aria-hidden="true"></span>Loading...').prop('disabled', true);

//            getData(function(data) {
//                $('.remarks-value').each(function() {
//                    data[$(this).attr('name')] = $(this).val();
//                    SessionStorage.set(_sessionName, $(this).attr('name'), $(this).val());
//                });
//
//                jqAjax(data, _product.url.kyc, function() {
//                    jqAjax(data, _product.url.calculate, function(msg) {
//                        if(msg.Status == undefined || !msg.Status) {
//                            alertMsg({
//                                type: 'warning',
//                                text: msg.Message != undefined ? msg.Message : 'Terjadi kesalahan, error'
//                            });
//
//                            $('.next-step').html(btnText);
//                        }
//
//                        if(msg && msg['Status']) {
//                            _product.updateSidebar(msg['Data']);
//
//                            if(validateForm(false)) {
//                                $('.next-step').html(btnText).prop('disabled', false)
//                            } else {
//                                $('.next-step').html(btnText).prop('disabled', true)
//                            }
//
//                            $_net_premium = msg['Data']['NetPremium'];
//                        }
//                    });
//                });
//            });
        });
        
        // Next step
        $('body').on('click', '.next-step', function() {
            if(validateForm()) {
                alertMsg({
                    type: 'success',
                    title: 'Informasi',
                    text: 'Plan yang saya pilih sudah sesuai dengan estimasi nilai hewan peliharaan saya di pasaran.  ',
                    close: false,
                    button: '<button type="button" class="btn btn-yellow-box small semo-bold" id="agree-next-step">Mengerti</button> '+
                            '<button type="button" class="btn btn-red-box small semo-bold" id="disagree-next-step" data-dismiss="modal">Batal</button>'
                })
            }
        });

        $('body').on('click', '#agree-next-step', function() {
            var _self = $(this);
            loadingBtnNext(false);

            $('#agree-next-step').html('<span class="spinner-border spinner-border-sm mr-2 mb-1" role="status" aria-hidden="true"></span>Loading...').prop('disabled', true);
            $('#disagree-next-step').prop('disabled', true);

            if(!validateForm()) {
                loadingBtnNext(true);
                return false;
            }

            // fetch all data
//            getData(function(data) {
//                jqAjax(data, _product.url.kyc, function(msg) {
//                    if(msg.Status == undefined || !msg.Status) {
//                        _self.trigger('click');
//                        
//                        alertMsg({
//                            type: 'warning',
//                            text: msg.Message != undefined ? msg.Message : 'Terjadi kesalahan, error'
//                        });  
//                        return false;                                                   
//                    }   
//                    window.location.href = "/web/guest/pet/-/quote/pet/step2";
//                });
//            });
            
            window.location.href = petStep2URL;
            
        });
    }

    /**
     * revert each remarks value to default
     */
    function resetRemarks() {
        $('.remarks-value').each(function(key) {
            $(this).siblings('.remarks-input').val(thousandFormat($_remarks_default[$(this).attr('name')]));
            $(this).val($_remarks_default[$(this).attr('name')]);
            if($('.remarks-value').length == key+1) $(this).change();
        });
    }

    /**
     * validate each remarks
     */
    function validateRemarks() {
        var _return = true;

        $('.remarks-value').each(function() {
            if($(this).attr('name') == 'LimitMedical') {
                var maxLimitMedical = $("[name=LimitDisability]").val() * 0.2;
                var minLimitMedical = 500000;

                if($(this).val() != 0 && $(this).val() < minLimitMedical) {
                    $(this).closest('.form-group').addClass('has-error has-validated');
                    if($(this).closest('.form-group').find('.error-msg').length==0) {
                        $(this).closest('.form-group').append('<span class="error-msg">*Minimal Rp 500.000 atau Rp 0 jika tidak mau memilih benefit ini</span>');
                    } else {
                        $(this).closest('.form-group').find('.error-msg').html('*Minimal Rp 500.000 atau Rp 0 jika tidak mau memilih benefit ini');
                    }

                    _return = false;
                } else {
                    $(this).closest('.form-group').removeClass('has-error has-validated');
                    $(this).closest('.form-group').find('.error-msg').remove();
                }

                if($(this).val() > maxLimitMedical) {
                    $(this).closest('.form-group').addClass('has-error has-validated');
                    
                    if($(this).closest('.form-group').find('.error-msg').length==0) {
                        $(this).closest('.form-group').append('<span class="error-msg">*Limit pertanggungan adalah 20% dari Benefit Kematian dan Cacat Tetap Total</span>');
                    } else {
                        $(this).closest('.form-group').find('.error-msg').html('*Limit pertanggungan adalah 20% dari Benefit Kematian dan Cacat Tetap Total');
                    }

                    _return = false;
                }
            }

            if($(this).attr('name') == 'LimitCustody') {
                var minLimitCustody = 250000;
                
                if($(this).val() != 0 && $(this).val() < minLimitCustody) {
                    $(this).closest('.form-group').addClass('has-error has-validated');
                    if($(this).closest('.form-group').find('.error-msg').length==0) $(this).closest('.form-group').append('<span class="error-msg">*Minimal Rp 250.000 atau Rp 0 jika tidak mau memilih benefit ini</span>');

                    _return = false;
                } else {
                    $(this).closest('.form-group').removeClass('has-error has-validated');
                    $(this).closest('.form-group').find('.error-msg').remove();
                }
            }
    
            if($(this).val() > 25000000) {
                $(this).closest('.form-group').addClass('has-error has-validated');
                if($(this).closest('.form-group').find('.error-msg').length==0) $(this).closest('.form-group').append('<span class="error-msg">*Limit pertanggungan adalah 25.0000.000</span>');
                
                _return = false;
            }
        });

        return _return;
    }

    function checkCustomPlan() {
        if($('#sidebar-plan').val() != $_custom_plan_id) {
            // disable if its not custom plan
            $('#form-fieldset').prop('disabled', true);
            $('#alert-plan').removeClass('d-none');
        } else {
            $('#form-fieldset').prop('disabled', false);
            $('#alert-plan').addClass('d-none');
        }
    }

    ///////////////////////////
    init();
    initTrigger();
})