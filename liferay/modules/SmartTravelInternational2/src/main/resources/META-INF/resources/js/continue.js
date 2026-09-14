//Calculate premi
function calculatePremi() {
    
    let existingSession = sessionStorage.getItem(_smartTravelInternationalFormDetailSess);
    if (existingSession) {
        try {
            let existingSessionData = JSON.parse(existingSession);
//            console.log(existingSessionData);
            
            $.ajax({
                url: _apiURL + "/o/api/sti2/calculate",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(existingSessionData),
                success: function (response) {
                    if (response.Status) {
                        if (response.Data.Calculation.AvailablePlans) {
                            if (response.Data.Calculation.AvailablePlans.length > 0) {
                                sessionStorage.setItem(_smartTravelInternationalCalculation, JSON.stringify(response.Data.Calculation));
                                
                                // redirect
                                if(window.modifyQuotation === 1) {
//                                	window.location.href = window.linkStep3;
                                	window.location.href = window.linkStep2;
                                } else if(window.repeatOrder === 1) {
//                                	updateSess(_smartTravelInternationalFormDetailSess, "ro", true); // ro = repeat order, apabila diakses via beli kembali, maka set indikator beli kembali ini ke true
                                	window.location.href = window.linkStep2;
                                } 
                                
//                                else if (window.docPhotoComplete === "false") {
//                                	window.location.href = window.linkStep3;
//                                } 
                                
                                else {
                                	window.location.href = existingSessionData.DocPhotoComplete ? window.linkRiplay : window.linkStep3;
                                }
                                
                            }
                        }
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Error:", error);
                }
            });
        } catch (e) {
            console.error('Error parsing session data:', e);
        }
    } else {
        console.error('No data found in session storage.');
    }
}


document.addEventListener('DOMContentLoaded', function() {

	/* delete bg-white default liferay */
		
	//call calculataion
	calculatePremi();

});







