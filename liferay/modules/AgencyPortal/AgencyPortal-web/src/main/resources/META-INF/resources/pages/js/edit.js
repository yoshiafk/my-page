var ajax_url = Liferay.ThemeDisplay.getPortalURL();
var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency body-white");

var loadAgentPageDataURL = window.loadAgentPageDataURL;
var host = window.host;
var rToken = window.rToken;
var apToken = window.apToken;
var eToken = window.eToken;

var selectedOption = 'aturjam';
var lat = 1.1774514,
	lng = 120.9315706,
	isNull = true

$(document).ready(function(){
	const tabEl = document.querySelector('button[data-bs-toggle="pill"]')
	tabEl.addEventListener('shown.bs.tab', event => {
		event.target // newly activated tab
		event.relatedTarget // previous active tab
	})

	$(".toggle-password").click(function() {
		$(this).toggleClass("is-show");
		var inputpass = $($(this).attr("toggle"));
		if (inputpass.attr("type") == "password") {
			inputpass.attr("type", "text");
		} else {
			inputpass.attr("type", "password");
		}
	});
	
	$(".tooltip-click").on("click", function() {
		$("#tooltip-password").toggleClass("is-show");
	});
	
	$(".tooltip-click-new-password").on("click", function() { 
		$("#tooltip-new-password").toggleClass("is-show");
	});
	
	$(".tooltip-click-confirmation-new-password").on("click", function() { 
		$("#tooltip-confirmation-new-password").toggleClass("is-show");
	});
	
	$(document).mouseup(function(e){
		var container = $("#tooltip-password");
			container2 = $("#tooltip-new-password");
			container3 = $("#tooltip-confirmation-new-password");
		if(!container.is(e.target) && container.has(e.target).length === 0) {
			container.removeClass('is-show');
		}
		if(!container2.is(e.target) && container2.has(e.target).length === 0) {
			container2.removeClass('is-show');
	  	}
		if(!container3.is(e.target) && container3.has(e.target).length === 0) {
			container3.removeClass('is-show');
	  	}
  	});

	$('#markEvent').on('click', function(){
		$(this).parent().parent().hide().attr('id');
	});
	
	$('.time').mask('00:00');
	$('.phone').mask('+0000 0000 00000');
	$('.telephone').mask('(000) 000-0000');
	
	$('.hour').click(function () {
		$(this).parent().parent().parent().toggleClass('is-open');
  	});
	
	$('#SelectTabs').on('change', function (e) {
		$('#v-pills-tab button').eq($(this).val()).tab('show');
    });
	
	$(".link-otp-password").on("click", function() {
		$(this).addClass('display-none');
		$('.otp-field').css('display', '');
		$('.link-otp').removeClass('display-none');
		$('.btn-save-password').removeClass('btn--disabled');
		$('.btn-save-password').removeClass('disabled');
		$('.btn-save-password').addClass('btn--dark-blue');
		$('.btn-save-password').attr('disabled', false);
		$('#timer').addClass('display-block');
		$('#timer').removeClass('display-none');
	});
	
	$('#change_profile_password_confirmation').bind('keyup', function() {
		var inputPass = $(this).val().length;
		var total = inputPass
		if (total > 7) {
			$('.btn-save-password').removeClass('btn--disabled');
			$('.btn-save-password').removeClass('disabled');
			$('.btn-save-password').addClass('btn--dark-blue');
			$('.btn-save-password').attr('disabled', false);
		} else {
			$('.btn-save-password').addClass('btn--disabled');
			$('.btn-save-password').addClass('disabled');
			$('.btn-save-password').removeClass('btn--dark-blue');
			$('.btn-save-password').attr('disabled', true);
		}
    });
	
	$('input.required, textarea.required').on('change keyup keydown', function(){
		if ($(this).hasClass('error-text') && $(this).val().length > 0) $(this).removeClass('error-text');
	});
	
	$('.link-dashboard, .link-profile').click(function(e) {
		e.preventDefault();
		parent.location.href = this.href;
	});
	
	$('.link-pretty-url').on('click', function(e) {
    	e.preventDefault();
        window.open(this.href, '_blank');
    });
	
	loadProfile();
});

$('#DasarPerhitungan').select2({
	width: '100%',
	placeholder: "Pilih Perhitungan",
	minimumResultsForSearch: -1
});

$('#SelectTabs').select2({
	width: '100%',
	minimumResultsForSearch: -1
});

function initMap() {
    var latlng = new google.maps.LatLng(lat, lng),
    	image = '/o/agency-theme/images/pin-axa.png';

    var mapOptions = {
        center: new google.maps.LatLng(lat, lng),
        zoom: isNull ? 4 : 12,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        panControl: true,
        panControlOptions: {
            position: google.maps.ControlPosition.TOP_RIGHT
        },
        zoomControl: true,
        zoomControlOptions: {
            style: google.maps.ZoomControlStyle.LARGE,
            position: google.maps.ControlPosition.TOP_left
        }
    },
    map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions),
        marker = new google.maps.Marker({
            position: latlng,
            map: map,
            icon: image
        });
    
    if (isNull) marker.setVisible(false);

    var input = document.getElementById('searchTextField');
    var autocomplete = new google.maps.places.Autocomplete(input, {
        types: ["geocode"]
    });

    autocomplete.bindTo('bounds', map);
    var infowindow = new google.maps.InfoWindow();

    google.maps.event.addListener(autocomplete, 'place_changed', function (event) {
        infowindow.close();
        var place = autocomplete.getPlace();
        if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
            map.setZoom(19);
            marker.setVisible(true);
        } else {
            map.setCenter(place.geometry.location);
            map.setZoom(isNull ? 4 : 12);
            marker.setVisible(true);
        }

        moveMarker(place.name, place.geometry.location);
        $('#latitude').val(place.geometry.location.lat());
        $('#longitude').val(place.geometry.location.lng());
    });
    
    google.maps.event.addListener(map, 'click', function (event) {
        $('#latitude').val(event.latLng.lat());
        $('#longitude').val(event.latLng.lng());
        infowindow.close();
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({
            "latLng":event.latLng
        }, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                var lat = results[0].geometry.location.lat(),
                    lng = results[0].geometry.location.lng(),
                    placeName = results[0].address_components[0].long_name,
                    latlng = new google.maps.LatLng(lat, lng);

                moveMarker(placeName, latlng);
                $("#searchTextField").val(results[0].formatted_address);
            }
        });
    });
   
    function moveMarker(placeName, latlng) {
        marker.setIcon(image);
        marker.setPosition(latlng);
        infowindow.setContent(placeName);
    }
}

function loadProfile() {
	$.ajax({
        url: loadAgentPageDataURL,
        type: "POST",
        data: { dataCategory: "profile", rtoken: rToken, aptoken: apToken },
        timeout: 20000,
        dataType: "json",
        success: function (response) {
            if (response.status) {
            	apToken = response.token ? response.token : "";
            	
            	if (response.data.agentLocation.latitude) {
            		lat = response.data.agentLocation.latitude;
            		isNull = false;
            	}
            	if (response.data.agentLocation.longitude) lng = response.data.agentLocation.longitude;
            	
            	initMap();
            	
            	if (response.data.agentIs24Hours === 1) {
            		$("#24jam").prop("checked", true);
            		$("#aturjam").prop("checked", false);
            		
            		$('.hours-list').addClass('display-none');
            		
            	} else {
            		$("#24jam").prop("checked", false);
            		$("#aturjam").prop("checked", true);
            		
            		$('.hours-list').removeClass('display-none');

            		updateCheckboxAndTime(response.data.agentWorkingHour);
            	}
            }
		}
    });
}

function saveBasicInfo() {
    let fileInputBanner = document.querySelector(".dropzone-banner");
    let fileInputProfile = document.querySelector(".dropzone-profile");

    let formData = new FormData();
    formData.append('prettyUrl', $("#pretty-url").val());
    formData.append('numberHp', $("#number-hp").val());
    formData.append('numberTlp', $("#number-tlp").val());
    formData.append('dasarPerhitungan', $("#DasarPerhitungan").val());
    formData.append('banner', fileInputBanner.files[0]);
    formData.append('profile', fileInputProfile.files[0]);
    formData.append('dataCategory', "basicInfo");
    formData.append('rtoken', rToken);
	formData.append('aptoken', apToken);
	formData.append('etoken', eToken);

	if ($("form").valid()) {
	    $.ajax({
	        type: "POST",
	        url: loadAgentPageDataURL,
	        data: formData,
	        processData: false,
	        contentType: false,
	        beforeSend: function() {
	        	$(".information-wrapper-bottom button").addClass("btn--disabled");
	        	$(".information-wrapper-bottom button").css("pointer-events", "none");
	        },
	        success: function (response) {
	        	response = JSON.parse(response);
	        	
	        	if (response.status == false) {
	        		$(".alert-agency").removeClass('display-none').addClass('failed');
	        		$(".alert-agency span").empty().append(response.message);
	    			
	        		$(".information-wrapper-bottom button").removeClass("btn--disabled");
	            	$(".information-wrapper-bottom button").css("pointer-events", "auto");
	            	
	            	apToken = response.token ? response.token : "";
	            	
	            	return;
	        	}
	        	
	        	if ($(".alert-agency").hasClass('display-none') == false) {
	        		$(".alert-agency").addClass('display-none').removeClass('failed success');
	        		$(".alert-agency span").empty();
	        	}
	
	        	$(".alert-agency").removeClass('display-none').addClass('success');
	    		$(".alert-agency span").empty().append(response.message);
	    		
	    		apToken = response.token ? response.token : "";
				
//				setTimeout(function() {
					parent.location.href = `${host}/dashboard/edit-profile`;
//				}, 3000);
			},
	        error: function (error) {
	        	$(".alert-agency").removeClass('display-none').addClass('failed');
	    		$(".alert-agency span").empty().append('Informasi dasar Anda gagal diperbarui');
				
				$(".information-wrapper-bottom button").removeClass("btn--disabled");
	        	$(".information-wrapper-bottom button").css("pointer-events", "auto");
	        }
	    });
	}
}

$('#24jam').click(function () {
	selectedOption = '24jam';
	$('.hours-list').addClass('display-none');
});

$('#aturjam').click(function () {
	selectedOption = 'aturjam';
	$('.hours-list').removeClass('display-none');
});

function updateCheckboxAndTime(params) {
	params.map(function (object) {			
		var checkboxElement = $("#" + object.day);
		var startTimeElement = $("#jam-buka-" + object.day);
	    var endTimeElement = $("#jam-tutup-" + object.day);
	    
	    checkboxElement.prop("checked", true);
        checkboxElement.parent().parent().parent().toggleClass('is-open');
        startTimeElement.val(object.startTime);
        endTimeElement.val(object.endTime);
	})
}

// Fungsi untuk mendapatkan array hari berdasarkan kondisi ceklis
function getDynamicDaysArray() {
    const days = ['senin', 'selasa', 'rabu', 'kamis', 'jumat', 'sabtu', 'minggu'];
    const dynamicDays = days.filter(day => document.getElementById(day).checked);
    return dynamicDays;
}


//Function to get values from non-null inputs
function getNonNullValues() {
    const dynamicDays = getDynamicDaysArray();
    const workingHours = {};
    
    let check = dynamicDays.every(day => {
        const startTime = document.getElementById('jam-buka-' + day).value;
        const endTime = document.getElementById('jam-tutup-' + day).value;
        
        return (startTime && endTime);
    });
    
    if (!check) {
        return false;
    }
   
 	dynamicDays.forEach(day => {
        const startTime = document.getElementById('jam-buka-' + day).value;
        const endTime = document.getElementById('jam-tutup-' + day).value;
        
        workingHours[day] = { 'startTime': startTime, 'endTime': endTime };
    });
 	
    return workingHours;
}

function saveWorkingHour(){
	let jsonData = {};

	if (selectedOption === '24jam') {
        jsonData = JSON.stringify({
        	is24Hours : true
	    });
    } else {
	    const allDaysValues = getNonNullValues();
	    
	    if (!allDaysValues) {
        	$(".alert-agency").removeClass('display-none').addClass('failed');
    		$(".alert-agency span").empty().append(`Mohon isi jam operasional Anda`);
    		
    		return;
	    }
    
	    jsonData = JSON.stringify({
	    	is24Hours : false,
	        hourList : allDaysValues
	    });
    }
	
	$.ajax({
        url: loadAgentPageDataURL,
        type: "POST",
        data: { dataCategory: "workingHour", rtoken: rToken, aptoken: apToken, etoken: eToken, data: jsonData },
        timeout: 20000,
        dataType: "json",
        beforeSend: function() {
        	$(".operational-hour-wrapper-bottom button").addClass("btn--disabled");
        	$(".operational-hour-wrapper-bottom button").css("pointer-events", "none");
        },
        success: function (response) {
        	if (response.status == false) {
        		$(".alert-agency").removeClass('display-none').addClass('failed');
        		$(".alert-agency span").empty().append(response.message);
    			
        		$(".operational-hour-wrapper-bottom button").removeClass("btn--disabled");
            	$(".operational-hour-wrapper-bottom button").css("pointer-events", "auto");
            	
            	apToken = response.token ? response.token : "";
            	
            	return;
        	}
        	
        	if ($(".alert-agency").hasClass('display-none') == false) {
        		$(".alert-agency").addClass('display-none').removeClass('failed success');
        		$(".alert-agency span").empty();
        	}

        	$(".alert-agency").removeClass('display-none').addClass('success');
    		$(".alert-agency span").empty().append(response.message);
			
    		apToken = response.token ? response.token : "";
			
			setTimeout(function() {
				parent.location.href = `${host}/dashboard/edit-profile`;
			}, 3000);
		},
        error: function (error) {
        	$(".alert-agency").removeClass('display-none').addClass('failed');
    		$(".alert-agency span").empty().append('Jam operasional Anda gagal diperbarui');
			
			$(".operational-hour-wrapper-bottom button").removeClass("btn--disabled");
        	$(".operational-hour-wrapper-bottom button").css("pointer-events", "auto");
        }
    });
}

function saveSocialMedia() {
	let jsonData = JSON.stringify({
        "facebook": $("#fb-url").val(),
        "twitter": $("#x-twitter-url").val(),
        "tiktok": $("#tiktok-url").val(),
        "linkedin": $("#linkedin-url").val(),
        "instagram": $("#instagram-url").val(),
        "blog": $("#blog-url").val()
    });

	$.ajax({
        url: loadAgentPageDataURL,
        type: "POST",
        data: { dataCategory: "socmed", rtoken: rToken, aptoken: apToken, etoken: eToken, data: jsonData },
        timeout: 20000,
        dataType: "json",
        beforeSend: function() {
        	$(".social-media-wrapper-bottom button").addClass("btn--disabled");
        	$(".social-media-wrapper-bottom button").css("pointer-events", "none");
        },
        success: function (response) {
        	if (response.status == false) {
        		$(".alert-agency").removeClass('display-none').addClass('failed');
        		$(".alert-agency span").empty().append(response.message);
    			
        		$(".social-media-wrapper-bottom button").removeClass("btn--disabled");
            	$(".social-media-wrapper-bottom button").css("pointer-events", "auto");
            	
            	apToken = response.token ? response.token : "";
            	
            	return;
        	}
        	
        	if ($(".alert-agency").hasClass('display-none') == false) {
        		$(".alert-agency").addClass('display-none').removeClass('failed success');
        		$(".alert-agency span").empty();
        	}

        	$(".alert-agency").removeClass('display-none').addClass('success');
    		$(".alert-agency span").empty().append(response.message);
			
    		apToken = response.token ? response.token : "";
			
			setTimeout(function() {
				parent.location.href = `${host}/dashboard/edit-profile`;
			}, 3000);
		},
        error: function (error) {
        	$(".alert-agency").removeClass('display-none').addClass('failed');
    		$(".alert-agency span").empty().append('Tautan media sosial Anda gagal diperbarui');
			
			$(".social-media-wrapper-bottom button").removeClass("btn--disabled");
        	$(".social-media-wrapper-bottom button").css("pointer-events", "auto");
        }
    });
}

function saveLocation() {
	let jsonData = JSON.stringify({
        "address": $("#address").val(),
        "latitude": $("#latitude").val(),
        "longitude": $("#longitude").val()
    });

	$.ajax({
        url: loadAgentPageDataURL,
        type: "POST",
        data: { dataCategory: "location", rtoken: rToken, aptoken: apToken, etoken: eToken, data: jsonData },
        timeout: 20000,
        dataType: "json",
        beforeSend: function() {
        	$(".location-wrapper-bottom button").addClass("btn--disabled");
        	$(".location-wrapper-bottom button").css("pointer-events", "none");
        },
        success: function (response) {
        	if (response.status == false) {
        		$(".alert-agency").removeClass('display-none').addClass('failed');
        		$(".alert-agency span").empty().append(response.message);
    			
        		$(".location-wrapper-bottom button").removeClass("btn--disabled");
            	$(".location-wrapper-bottom button").css("pointer-events", "auto");
            	
            	apToken = response.token ? response.token : "";
            	
            	return;
        	}
        	
        	if ($(".alert-agency").hasClass('display-none') == false) {
        		$(".alert-agency").addClass('display-none').removeClass('failed success');
        		$(".alert-agency span").empty();
        	}

        	$(".alert-agency").removeClass('display-none').addClass('success');
    		$(".alert-agency span").empty().append(response.message);
			
    		apToken = response.token ? response.token : "";
			
			setTimeout(function() {
				parent.location.href = `${host}/dashboard/edit-profile`;
			}, 3000);
		},
        error: function (error) {
        	$(".alert-agency").removeClass('display-none').addClass('failed');
    		$(".alert-agency span").empty().append('Lokasi Anda gagal diperbarui');
			
			$(".location-wrapper-bottom button").removeClass("btn--disabled");
        	$(".location-wrapper-bottom button").css("pointer-events", "auto");
        }
    });
}

function saveChange() {
	let number = $('input[name="otp-password"]').val();
	let emailElement = $('.list-group-biodata li span:contains("Email")').siblings('strong');
    let emailValue = emailElement.text().trim();
	
	if ($(".alert-agency").hasClass('display-none') == false) {
		$(".alert-agency").addClass('display-none').removeClass('failed success');
		$(".alert-agency span").empty();
	}
	
	let jsonData = JSON.stringify({
		"currPassword": $('input[name="profile_old_password"]').val(),
		"newPassword": $('input[name="change_profile_new_password"]').val(),
		"confirmNewPassword": $('input[name="change_profile_password_confirmation"]').val()
	});
	
	if ($("form").valid()) {
		$.ajax({
		    url: loadAgentPageDataURL,
		    type: "POST",
		    data: { dataCategory: "changePassword", rtoken: rToken, aptoken: apToken, etoken: eToken, data: jsonData },
		    timeout: 20000,
		    dataType: "json",
		    beforeSend: function() {
		    	$(".change-password-wrapper-bottom button").addClass("btn--disabled");
		    	$(".change-password-wrapper-bottom button").css("pointer-events", "none");
		    },
		    success: function (response) {
		    	if (response.status == false) {
		    		$(".alert-agency").removeClass('display-none').addClass('failed');
		    		$(".alert-agency span").empty().append(response.message);
					
					$(".change-password-wrapper-bottom button").removeClass("btn--disabled");
		        	$(".change-password-wrapper-bottom button").css("pointer-events", "auto");
		        	
		        	apToken = response.token ? response.token : "";
		        	
		        	return;
		    	}
		    	
		    	if ($(".alert-agency").hasClass('display-none') == false) {
		    		$(".alert-agency").addClass('display-none').removeClass('failed success');
		    		$(".alert-agency span").empty();
		    	}
		    	
		    	$(".alert-agency").removeClass('display-none').addClass('success');
				$(".alert-agency span").empty().append(response.message);
				
				apToken = response.token ? response.token : "";
				
				setTimeout(function() {
					parent.location.href = `${host}/dashboard/edit-profile`;
				}, 3000);
			},
		    error: function (error) {
		    	$(".alert-agency").removeClass('display-none').addClass('failed');
				$(".alert-agency span").empty().append('Password Anda gagal diperbarui');
				
				$(".change-password-wrapper-bottom button").removeClass("btn--disabled");
		    	$(".change-password-wrapper-bottom button").css("pointer-events", "auto");
		    }
		});
	}
}