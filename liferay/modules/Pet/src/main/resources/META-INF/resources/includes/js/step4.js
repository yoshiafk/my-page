$(function () {
    'use strict';

    var $_managed_by;
    var $_one_page;

    function init() {
    	
        let sessionData = getSessionData(_sessionName);

        // Populate data from session storage to elements container
        if (sessionData) {
          updateFormGeneral(sessionData);
          updateFormStep4(sessionData);

          // remove token if ubah penawaran
          //  		if(EditQuotation && getSessionData() && getSessionData().Token) {
          //  			SessionStorage.set(_sessionName, 'Token', "");
          //  			SessionStorage.set(_sessionName, 'TempCode', "");
          //  		}
        }
        
//        $_managed_by = $('#step4-page').data('managedby');
//        $_one_page = $('#step4-page').data('onepage');

        // select
        $('.selectize').selectize();

        if($('#agree-checkbox').prop('checked')) {
            $('#agreement').removeClass('disabled');
        }
        else {
            $('#agreement').addClass('disabled');
        }

        // check button
        if(validateForm(false)) {
            $('.next-step').prop('disabled', false);
            $('.send-quotation').prop('disabled', false);
        } else {
            $('.next-step').prop('disabled', true);
            $('.send-quotation').prop('disabled', true);
        }

        // calculate
//        jqAjax({}, _product.pi.url.calculate, function(msg) {
//            if(msg && msg['Status']) {
//                if(msg['Data'] && msg['Data']['Discount']) $('.promo .info').html($('#promocode').val()+' berhasil dipakai.');
//                _product.pi.updateSidebar(msg['Data']);
//            }
//        });
    }

    function initTrigger() {
        $('body').on('change', '#agree-checkbox', function() {
            if($(this).prop('checked')) {
                $('#agreement').removeClass('disabled');
            }
            else {
                $('#agreement').addClass('disabled');
            }
        });

        $('body').on('change', 'input.required, select.required', function() {
            if(validateForm(false)) {
                $('.next-step').prop('disabled', false);
                $('.send-quotation').prop('disabled', false);
            } else {
                $('.next-step').prop('disabled', true);
                $('.send-quotation').prop('disabled', true);
            }
        });

        // Next step
        $('body').on('click', '.next-step', function() {
        	
        	loadingBtnNext(false);
        	$('.send-quotation').prop('disabled', false);
        	
            let curToken = '';
            let sessionData = getSessionData(_sessionName);
            if(sessionData) {
          	  if(sessionData.hasOwnProperty('Token')) {
          		  curToken = sessionData['Token'];
          	  }
            }
            
            $.ajax({
                url: lrToPimcKycMiddlewareUrl,
                type: 'POST',
                data: JSON.stringify({currentToken: curToken, rToken: aParam}),
                contentType: 'application/json',
                beforeSend: function() {
                	$('.send-quotation').prop('disabled', false);
                },
                success: function(response) {
                $('.send-quotation').prop('disabled', true);
                console.log(response);
              	  if(response.status) {
              		  let res = JSON.parse(response.response)
              		  let t = res.Data.Token;
              		  let url = pmcrPaymentUrl + t;
              		  window.parent.location.href=url;
              	  }
                },
                error: function(xhr, status, error) {
                    console.log('Error process to Pimcore');
                    $('.send-quotation').prop('disabled', true);
                }
            });
//            var _self = $(this);
//            
//            loadingBtnNext(false);
//
//            if(!validateForm()) {
//                loadingBtnNext(true);
//                return false;
//            }
//
//            checkPep(function() {
//                // fetch all data
//                getData(function(data) {
//                    jqAjax(data, '/pet/api/leads/validate', function(msgValidate) {
//                        if(msgValidate.Redirect) {
//                            window.location.href = msgValidate.Redirect;
//                            return false;
//                        }
//
//                        jqAjax(data, _product.pi.url.kyc, function(msg) {
//                            var url = '/payment/';
//                            var formHtml = '<form action="' + url + '" method="post">' +
//                            '<input type="text" name="product" value="PI" />' +
//                            '<input type="text" name="ManagedBy" value="'+$_managed_by+'" />';
//                            if(payQuotation) formHtml += '<input type="text" name="PayQuotation" value="PI" />';
//                            formHtml += '</form>';
//                            var form = $(formHtml);
//
//                            $('body').append(form);
//
//                            if(msg.Status == undefined || !msg.Status) {
//                                _self.trigger('click');
//                                
//                                alertMsg({
//                                    type: 'warning',
//                                    text: msg.Message != undefined ? msg.Message : 'Terjadi kesalahan, error'
//                                }); 
//                                
//                                return false;
//                            } else {
//                                form.submit();
//                            }
//                        });
//                    });
//                });
//            });
        });

        // QUOTATION
        $('body').on('click', '.send-quotation', function() {
        	let sessionData = getSessionData(_sessionName);
        	console.log(sessionData['Email']);
        	console.log(sessionData['Name']);
        	
        	console.log("click button send quotation");
        	
            $('#quotation-modal').modal({
                'show': true,
                'backdrop': 'static'
            });
        });

        $('body').on('click', '#quotation-submit', function() {
            $('#quotation-submit').html('<span class="spinner-border spinner-border-sm mr-2 mb-1" role="status" aria-hidden="true"></span>Loading...').prop('disabled', true);
            $('.send-quotation').html('<span class="spinner-border spinner-border-sm mr-2 mb-1" role="status" aria-hidden="true"></span>Loading...').prop('disabled', true);
            
          if(!validateForm()) {
        	  $('#quotation-submit').html('Kirim').prop('disabled', false);
        	  $('.send-quotation').html('Kirim Penawaran').prop('disabled', false);
        	  return false;
          }
            
            let curToken = '';
            let sessionData = getSessionData(_sessionName);
            if(sessionData) {
          	  if(sessionData.hasOwnProperty('Token')) {
          		  curToken = sessionData['Token'];
          	  }
            }
            
            $.ajax({
                url: Liferay.ThemeDisplay.getPortalURL() + "/o/api/pet/quotation",
                type: 'POST',
                data: JSON.stringify({t: curToken}),
                contentType: 'application/json',
                beforeSend: function() {
                	$('.send-quotation').prop('disabled', false);
                },
                success: function(response) {
                $('.send-quotation').prop('disabled', true);
                console.log(response);
//              	  if(response.status) {
//              		  
//              		  let res = JSON.parse(response.response)
//              		console.log(response.response);
//              		  let t = res.Data.Token;
//              		  let url = pmcrPaymentUrl + t;
//              		  window.parent.location.href=url;
//              	  }
                },
                error: function(xhr, status, error) {
                    console.log('Error process quotation');
                    $('.send-quotation').prop('disabled', true);
                }
            });
    
//            if(!validateForm()) {
//                $('#quotation-submit').html('Kirim').prop('disabled', false);
//                $('.send-quotation').html('Kirim Penawaran').prop('disabled', false);
//                return false;
//            }
            
//            checkPep(function() {
//                // fetch all data
//                getData(function(data) {
//                    jqAjax(data, _product.pi.url.kyc, function(msgKyc) {
//                        if(msgKyc['Status']) {
//                            jqAjax(data, '/pet/api/leads/create-quote', function(msgLeads) {
//                                if(msgLeads.Status) {
//                                    var params = {
//                                        'LeadsId' : msgLeads.Data.LeadsId
//                                    };
//        
//                                    jqAjax(params, '/pet/api/leads/send-quote', function(msgPayment) {
//                                        if(msgPayment.Status) {
//                                            var redirect = $_one_page ? '/user/login/' : '/dashboard';
//
//                                            $('#quotation-modal').modal('hide');
//                                            
//                                            alertMsg({
//                                                type: 'success',
//                                                text: 'Penawaran Berhasil, Anda Akan Dialihkan Ke Halaman Dashboard',
//                                                close: false,
//                                                button: '<button type="button" class="btn btn-yellow-box small semo-bold"><a class="c-white" href="'+redirect+'"><i class="far fa-check"></i> Ok</a></button>'
//                                            })
//                                        }
//                                    });
//                                }
//                            });
//                        }
//                    });
//                });
//            });
        });
    }

    function checkPep(callback) {
        if($('#step4-page').data('pep')) {
            jqAjax({}, '/pet/api/leads/create-pep', function(msg) {
                if(!msg.Status) {
                    alertMsg({
                        type: 'warning',
                        text: msg.Message != undefined ? msg.Message : 'Terjadi kesalahan, error'
                    });

                    return false;
                }

                if(typeof msg.EnablePep && msg.EnablePep == false) return callback();

                alertMsg({
                    type: 'info',
                    text: msg.Data.Message,
                    type_color: 'bg-blue-1200',
                    close: false,
                    button: '<button type="button" class="btn btn-yellow-box small semo-bold"><a class="c-white" href="'+msg.Data.Redirect+'"><i class="far fa-check"></i> Ok</a></button>'
                })
    
                $('.next-step').html('Selanjutnya <i class="fas fa-arrow-right"></i>').prop('disabled', true);
            });
        } else {
            return callback();
        }
    }

    init();
    initTrigger();
})