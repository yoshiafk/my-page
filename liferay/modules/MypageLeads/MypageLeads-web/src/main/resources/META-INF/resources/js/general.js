var _jsonCity = {};
Liferay.Service(
	'/mp.mastercity/get-cities',
	function(obj) {
		if(obj.Status) _jsonCity = obj.Data;
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
		// event on province change
		$(document).on("change", ".province", function() {
			changeProvince($(this));
		});
	}
);


function changeProvince(thisProvince) {
    var cities = _jsonCity;
    var provinceSelected = $(thisProvince).find('option:selected').data('id');
    var thisCity = $(thisProvince).closest('.panel-body').find('.city');
    var cityVal = $(thisProvince).closest('.panel-body').find('.city-val');

    if (!$(thisProvince).val()) {
        thisCity.val('').attr('disabled', 'disabled');
        return false;
    } else {
        thisCity.removeAttr('disabled');
    }
    
    thisCity.html('<option value="" selected> PILIH </option>');
    $.each(cities[provinceSelected], function(k, v) {
        thisCity.append('<option value="' + v.name + '">' + v.name + '</option>');
    });
}
