var outURL = window.outURL;

$(document).ready(function() {
	$(".link-out").on('click', function() {
		$.ajax({
	       	url: outURL,
			type: "GET",
			dataType: "json",
	       	success: function (response) {
	       		if (response.status) {
	       			parent.location.href = response.data.target;
	       		}
	       	}
		});
	});
});