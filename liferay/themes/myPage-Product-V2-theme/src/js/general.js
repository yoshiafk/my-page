// datedropdown plugin
function dateDropdown(selector) {
    var min = $(selector).data('min') || '';
    var max = $(selector).data('max') || '';

    $(selector).dateDropdowns({
        dropdownClass: 'form-control select-gray semi-bold selectize',
        daySuffixes: false,
        submitFormat: 'dd/mm/yyyy',
        defaultDateFormat: 'dd/mm/yyyy',
        yearLabel: 'YYYY',
        monthLabel: 'MM',
        dayLabel: 'DD',
        monthFormat: 'numeric',
        monthSuffixes: false,
        required: true,
        minDate: min,
        maxDate: max,
        selectize: true, // for combination with selectize plugin
    });
}


var _payment = {
    url: { 
        request: '/payment/api/request',
    },
    resetPayment: function() {
        if($('#payment-page').length) {
            if($('#payment-page-form').length) document.getElementById('payment-page-form').reset();
            if($("select[name=payment_channel]").length) {
                $("select[name=payment_channel]").each(function(k, ele) {
                    if(ele.selectize != undefined) ele.selectize.clear();
                });
            }
            if($("select[name=payment_period]").length) {
                $("select[name=payment_period]").each(function(k, ele) {
                    if(ele.selectize != undefined) ele.selectize.clear();
                });
            }
        }
    },
    checkMinMax: function(){
        if(!$('.channel-item').length) return false;

        $('.channel-item').each(function(k, ele) {
            var min = $(ele).data('min');
            var max = $(ele).data('max');

            if( (min > 0 && $_net_premium < min) || (max > 0 && $_net_premium > max) ) {
                $(ele).addClass('d-none');
            }else{
                $(ele).removeClass('d-none');
            }
        });
    }
};

////////////////////////

// get fields value
// use this attribute to make custom data request
// data-name            => (string) for custom field name
// data-group           => (string) for grouping field / array
// ex: GroupName: { FieldName: Value }
// data-group-child     => (boolean) to make array
// ex: GroupName: { 0: { FieldName: Value }, 1: { FieldName1: Value1 } }
// data-group-key       => (int) push child to an array key | data-group-child must be true
// ex: GroupName: { 0: { FieldName1: Value1, FieldName2: Value2 } }

// skip get data if has class visibleonly and the element is not visible
// skip get data if has class parentvisibleonly and the parent element is not visible
function getData(callback) {
    var total = $('.change').length;
    var data = getSessionData() || {}; // get data first from sessionstorage

    // promocode
    data['PromoCode'] = $('#promocode').length ? $('#promocode').val() : '';

    // fetch all value
    $('.change, .getdata').each(function(index) {
        if($(this).prop("tagName") == 'INPUT' || $(this).prop("tagName") == 'SELECT' || $(this).prop("tagName") == 'TEXTAREA') {
            // skip if has class visibleonly and the element is not visible
            if($(this).hasClass('visibleonly') && !$(this).is(":visible")) return;
            // skip if has class parentvisibleonly and the parent element is not visible
            if($(this).hasClass('parentvisibleonly') && !$(this).parent().is(":visible")) return;

            var name = $(this).data('name') !== undefined ? $(this).data('name') : $(this).attr('name');
            var val = '';

            switch($(this).attr('type')) {
                case 'radio':
                    val = $('input[name='+$(this).attr('name')+']:checked').val() || '';
                    if($(this).data('group') !== undefined) {
                        if($(this).data('group-key') !== undefined) {
                            val = $('input[data-group='+$(this).data('group')+'][data-group-key='+$(this).data('group-key')+'][name='+$(this).attr('name')+']:checked').val() || '';
                        } else {
                            val = $('input[data-group='+$(this).data('group')+'][name='+$(this).attr('name')+']:checked').val() || '';
                        }
                    }
                    break;
                case 'checkbox':
                    val = $(this).is(':checked') ? $(this).attr('value') != undefined ? $(this).attr('value') : 1 : 0;
                    break;
                default: 
                    val = $(this).val();
                    break;
            }

            // grouping objects
            if($(this).data('group') !== undefined) {
                if($(this).data('group-child') !== undefined) {
                    var temp = {};
                    // set object
                    temp[name] = val;

                    if(data[$(this).data('group')] === undefined) data[$(this).data('group')] = [];

                    if($(this).data('group-key') !== undefined) {
                        if(data[$(this).data('group')][$(this).data('group-key')] === undefined) data[$(this).data('group')][$(this).data('group-key')] = {};
                        data[$(this).data('group')][$(this).data('group-key')][name] = val;
                    } else {
                        data[$(this).data('group')].push(temp);
                    }

                } else {
                    if(data[$(this).data('group')] === undefined) data[$(this).data('group')] = {};
                    data[$(this).data('group')][name] = val;
                }
            } else {
                data[name] = val;
            }
        }

    });
    
    // callback
    typeof callback === 'function' && callback(data);
    return data;
}

// AJAX
function jqAjax(data, url, callback, processData) {
    var setting = {
        method: "POST",
        url: url,
        data: data,
    };

    if(processData != undefined && processData == true) {
        setting['processData'] = false;
        setting['contentType'] = false;
    }

    var jqXHR = $.ajax(setting)
    .done(function( msg ) {
        typeof callback === 'function' && callback(msg);
    });

    return jqXHR.responseText;
}

function jqAjaxJSON(data, url, callback, processData) {
    var setting = {
            method: "POST",
            url: url,
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
        };

    if(processData != undefined && processData == true) {
        setting['processData'] = false;
        setting['contentType'] = false;
    }

    var jqXHR = $.ajax(setting)
    .done(function( msg ) {
        typeof callback === 'function' && callback(msg);
    });

    return jqXHR.responseText;
}

// convert int to thousand format
function thousandFormat(x) {
    var text = x.toString().split('.');
    return text[0].replace(/\B(?=(\d{3})+(?!\d))/g, ".") + (text[1] != undefined ? ','+text[1] : '');
}

function loadingBtnNext(val) {
    var enable = val || false;

    if(enable) {
        $('.next-step').html('Selanjutnya <i class="fas fa-arrow-right"></i>').prop('disabled', false);
    } else {
        $('.next-step').html('<span class="spinner-border spinner-border-sm mr-2 mb-1" role="status" aria-hidden="true"></span>Loading...').prop('disabled', true);
    }
}

function validateForm (showinfo) {
    var check = true;
    var elm = '';
    var info = showinfo !== undefined ? showinfo : true;

    $('input.required, select.required, textarea.required, input.hidden-required').each(function(k, obj) {
        var ele = $(obj);
        
        if($(ele).hasClass('selectized') || $(ele).parent().hasClass('date-dropdowns')) {
            if($($(ele).parent()).is(':visible')) {
                var err = valErr(ele, info);
                if(! err && ! elm) {
                    elm = ele.parent();
                    check = false;
                }
            }
        } else {
            if($(ele).is(':visible') || $(ele).hasClass('hidden-required')) {
                var err = valErr(ele, info);
                if(! err && ! elm) {
                    elm = $(ele).hasClass('hidden-required') ? ele.parent() : ele;
                    check = false;
                }
            }
        }
    });

    if(elm && info) {
        $('html, body').animate({
            scrollTop: elm.offset().top - ($('#main-menu-product').height() + 30)
        }, 500);
    }
    if(elm) {
        if($('.next-info-error').length) $('.next-info-error').removeClass('d-none');
    } else {
        if($('.next-info-error').length) $('.next-info-error').addClass('d-none');
    }

    return check;
}

function valErr(elm, showinfo, errtype) {
    var result;
    var val;
    var parent = elm.closest('.form-group');

    var msg = {
        'msg-required': elm.data('msg-required') !== undefined ? elm.data('msg-required') : '*wajib diisi',
        'msg-minlength': elm.data('msg-min') !== undefined ? elm.data('msg-min') : '*minimal '+elm.attr('minlength')+' karakter',
    };
    var info = showinfo !== undefined ? showinfo : true;

    if(elm.prop("tagName") == 'INPUT' || elm.prop("tagName") == 'SELECT' || elm.prop("tagName") == 'TEXTAREA') { 
        switch(elm.attr('type')) {
            case 'radio':
                val = $('input[name='+elm.attr('name')+']:checked').val() || '';
                break;
            case 'checkbox':
                val = elm.is(':checked') ? 1 : 0;
                break;
            default: 
                val = elm.val();
                break;
        }
    }

    if(!val || val == '') {
        if(parent.find('span.error-msg').length == 0 && info) {
            parent.addClass('has-validated').append('<span class="error-msg">'+msg['msg-required']+'</span>');
            parent.addClass('has-error');
        }
        return false;
    } else {
        parent.removeClass('has-validated').find('span.error-msg').remove();
        parent.removeClass('has-error');
        result = true;

        // check min charac
        if(elm.attr('minlength') != undefined && val.length < elm.attr('minlength')) {
            parent.addClass('has-validated').append('<span class="error-msg">'+msg['msg-minlength']+'</span>');
            parent.addClass('has-error');
            return false;
        } else {
            parent.removeClass('has-validated').find('span.error-msg').remove();
            parent.removeClass('has-error');
            result = true;
        }

        // validate email
        if(elm.attr('type') == 'email') {
            var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

            if(! regex.test(val)) {
                parent.addClass('has-validated').append('<span class="error-msg">*format email salah</span>');
                parent.addClass('has-error');
                return false;
            } else {
                parent.removeClass('has-validated').find('span.error-msg').remove();
                parent.removeClass('has-error');
                result = true;
            }
        }
    }

    return result;
}

function getDate() {
    now = new Date();

    year = "" + now.getFullYear();
    month = "" + (now.getMonth() + 1); if (month.length == 1) { month = "0" + month; }
    day = "" + now.getDate(); if (day.length == 1) { day = "0" + day; }
    hour = "" + now.getHours(); if (hour.length == 1) { hour = "0" + hour; }
    minute = "" + now.getMinutes(); if (minute.length == 1) { minute = "0" + minute; }
    second = "" + now.getSeconds(); if (second.length == 1) { second = "0" + second; }

    return year + month +  day +  hour + minute + second;
}

function alertMsg(settings) {
    var close = settings.close != undefined ? settings.close : true;
    var backdrop = settings.backdrop != undefined ? settings.backdrop : 'static';
    var size = settings.size || '';
    var text = settings.text || '';
    var btn = settings.button || '';
    var title = settings.title || (settings.type=='success'?'Success!':'INFORMASI');
    var color = settings.type=='success'?'bg-green-100':'bg-red';
    var icon = settings.type=='success'?'<i class="fal fa-check-circle"></i>':'<i class="fal fa-exclamation-triangle"></i>';
    var showTitle = settings.showTitle != undefined ? settings.showTitle : true;
    var showTitleClass = showTitle ? '' : 'd-none'

    if (settings.type_color) {
        color = settings.type_color;
    }

    var html = '<div id="modal-alert" class="modal modal-alert warning '+ size +'" tabindex="-1">\
                    <div class="modal-dialog modal-dialog-centered">\
                        <div class="modal-content">\
                            <div class="modal-body">\
                                <div class="title '+ color +' '+ showTitleClass +'">\
                                    '+ icon;
                                    
    if(close) html += '<button type="button" data-dismiss="modal"><i class="fal fa-times"></i></button>';

        html +=                 '</div>\
                                <div class="content p-4">\
                                    <h6>'+ title +'</h6>\
                                    <p>'+ text +'</p>\
                                    <div class="text-center">\
                                        '+ btn +'\
                                    </div>\
                                </div>\
                            </div>\
                        </div>\
                    </div>\
                </div>';

    if($('#modal-alert').length) $('#modal-alert').modal('hide'), $('#modal-alert').remove();
    $('body').append(html);
    $('#modal-alert').modal({
        'show': true,
        'backdrop': backdrop
    });
    $('#modal-alert').on('hidden.bs.modal', function () {
        if(typeof block_order !== 'undefined' && block_order) {
            alertMsg({
                type: 'warning',
                type_color: 'bg-yellow',
                text: block_order
            });
            block_order = "";
        }
    });
}

// parse utm from url
function parseURLParams(url) {
    var queryStart = url.indexOf("?") + 1,
        queryEnd   = url.indexOf("#") + 1 || url.length + 1,
        query = url.slice(queryStart, queryEnd - 1),
        pairs = query.replace(/\+/g, " ").split("&"),
        parms = {}, i, n, v, nv;

    if (query === url || query === "") return;

    for (i = 0; i < pairs.length; i++) {
        nv = pairs[i].split("=", 2);
        n = decodeURIComponent(nv[0]);
        v = decodeURIComponent(nv[1]);

        if (!parms.hasOwnProperty(n)) parms[n] = '';
        parms[n] = nv.length === 2 ? v : null;
    }
    return parms;
}

function closeCampaign() {
	var modal = document.getElementById('modal-campaign');
	modal.parentNode.removeChild(modal);
}

function utmCampaign() {
    var getDataUrl = parseURLParams(window.location.href);
    wHeight = window.innerHeight - 50;
    
    if(
        typeof getDataUrl !== 'undefined' 
        && (
            getDataUrl['utm_source'] 
            || getDataUrl['utm_medium'] 
            || getDataUrl['utm_campaign'] 
            || getDataUrl['utm_term'] 
            || getDataUrl['utm_content']
        )
    ) {
        // Get the current URL
        var currentUrl = window.location.href;
        // Remove parameters
        var urlWithoutParams = currentUrl.split('?')[0];
        // Remove base URL
        var relativeUrl = urlWithoutParams.replace(window.location.origin, '');

        getDataUrl.ProductUrl = relativeUrl;

        jqAjax(getDataUrl, '/api/utm-campaign', function(response) {
			if (response.Status == 1 && response['Data'] && response['Data']['Image']) {
				// create html for campaign
				var html = '<div class="modal fade modal-campaign-utm" id="modal-campaign" tabindex="-1" aria-hidden="true">\
						        <div class="modal-dialog modal-dialog-centered" role="document">\
						            <div class="modal-content">\
                                        <div class="modal-body p-0 text-center">\
                                            <div class="box-image">\
                                                <button type="button" class="close btn-close" data-dismiss="modal" aria-label="Close" onclick="closeCampaign()"><span aria-hidden="true">&times;</span></button>';

                    if (response['Data']['Url']) {
                        html += '<a href="'+ response['Data']['Url'] +'">';					
                    }
                        html += '<img class="img-fluid img-thumbnail" src="'+ response['Data']['Image'] +'" alt="image campaign" style="max-height:'+ wHeight +'px;" />';

                    if (response['Data']['Url']) {
                        html += '</a>';					
                    }
                    html += '        	    </div>\
                                        </div>\
						            </div>\
						        </div>\
						    </div>';

				var node = document.createElement('div');
			    node.innerHTML += html;

                document.body.appendChild(node);
                $('#modal-campaign').modal('show');
			}
        });
    }
}

