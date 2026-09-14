$(document).ready(function() {
	$('.buy-btn').click(function(e) {
		e.preventDefault();
		displayLoading();
		window.location.href = _nextStepURL;
	});
	
	$('.info-link').on('click', function() {
		const target = $(this).data('target');
		
		$.ajax({
	          url: _apiURL + `/o/api/sa/additional-info/benefits?a=${target}`,
	          type: "GET",
	          success: function (response) {
	        	  const content = `<h3>${response.data.title}</h3>
	        		  			  ${response.data.description}`;
	        	  
	        	  $(".modal-axa-smartactive-body").empty().append(content);
	      		
	        	  $(moreinfoModal).modal("show");
	          }
		});
	});
});