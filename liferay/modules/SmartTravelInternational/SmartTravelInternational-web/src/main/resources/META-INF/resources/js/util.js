// Remove Promo Code when calculate failed
function removePromoCode() {
  let travelData = JSON.parse(sessionStorage.getItem(_smartTravelInternationalFormDetailSess));
  if (travelData && travelData.PromoCode) {
    delete travelData.PromoCode;
  }
  
  sessionStorage.setItem(_smartTravelInternationalFormDetailSess, JSON.stringify(travelData));
  document.querySelector("#clear-promo-code-btn").click();
}

document.addEventListener("DOMContentLoaded", function () {
	
	// Clear Promo Code
	document.querySelector("#clear-promo-code-btn").addEventListener('click', function() {
		document.querySelector('input[name="PromoCode"]').value = "";
		document.querySelector('input[name="PromoCodeSidebar"]').value = "";
		document.querySelector("#promo-code-btn").click();
		document.querySelector(".trigger-collapse-promo").click();// tutup sticky promocode dan tampilkan summary
	});
});
