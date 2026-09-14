var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency body-white");

var responseClubYearTarget;
var responseClubYearAPI;
var resonseProfile;

var loadAgentViewDashboardDataURL = window.loadAgentViewDashboardDataURL;
var rToken = window.rToken;
var apToken = window.apToken;

$(document).ready(function() {
	$('.alert-member-club__left p.text-member').html('Ayo jadi Member dengan cara selesaikan progres di atas sebelum <strong>31 Des ' +new Date().getFullYear()+ '!</strong>');
	$('.text-member-btn strong').text('31 Des '+new Date().getFullYear()+'!'); 
	loadPage();
	
	$('.btn-scorecard').click(function(e) {
		e.preventDefault();
		parent.location.href = this.href;
	});
});

/*function createClubTarget(data){
	var clubDiv = document.createElement('div');
    clubDiv.className = 'level-after';
    
    var clubIdDiv = document.createElement('div');
    clubIdDiv.id = 'level-' + data.name.toLowerCase();
    clubIdDiv.className = 'w-40px-h-50px agency-self-center';
    
    clubDiv.appendChild(clubIdDiv);
    
    var clubNameDiv = document.createElement('div');
    clubNameDiv.className = 'level-name agency-self-center ml-24px';
    
    var klubNowSpan = document.createElement('span');
    klubNowSpan.className = 'display-block text-responsive-14px agency-uppercase agency-leading-none';
    klubNowSpan.textContent = 'Klub Selanjutnya'; // + new Date().getFullYear();
    
    var clubNameSpan = document.createElement('span');
    clubNameSpan.className = 'display-block text-responsive-16px';
    clubNameSpan.textContent = data.name;
    

    clubNameDiv.appendChild(klubNowSpan);
    clubNameDiv.appendChild(clubNameSpan);

    clubDiv.appendChild(clubNameDiv);

    return clubDiv;
	
}

function createClubNow(data){
	var clubDiv = document.createElement('div');
	clubDiv.className = 'level-now';
	
	var clubIdDiv = document.createElement('div');
	clubIdDiv.id = 'level-' + data.club.toLowerCase().replace(/\s+/g, '');
	
	clubDiv.appendChild(clubIdDiv);
	
	var clubNameDiv = document.createElement('div');
	clubNameDiv.className = 'level-name agency-self-center line-height-30px';
	
	var klubNowSpan = document.createElement('span');
	klubNowSpan.className = 'display-block text-responsive-14px agency-uppercase agency-leading-normal mb-responsive-4px';
	klubNowSpan.textContent = 'Klub Sekarang';
	
	var clubNameSpan = document.createElement('span');
	clubNameSpan.className = 'display-block text-responsive-35px agency-break-all';
    clubNameSpan.textContent = data.club;
    
    clubNameDiv.appendChild(klubNowSpan);
    clubNameDiv.appendChild(clubNameSpan);

    clubDiv.appendChild(clubNameDiv);
    
    return clubDiv;
}


function setPriceAndProgressBar(totalProduksi, keTarget, isPalladium){
    var totalProduksiFormatted = totalProduksi.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
    $('.club-total-product__left strong').text('Rp ' + totalProduksiFormatted);
    
    if(!isPalladium){
    	var keTargetFormatted = keTarget.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
    	$('.club-total-product__right strong').text('Rp ' + keTargetFormatted);    	
    }
    
	var progressPercentage;
	if (totalProduksi >= keTarget) {
	    progressPercentage = 100;
	} else {
	    progressPercentage = (totalProduksi / keTarget) * 100;
	}

	var progressBar = document.querySelector(".club-progress-bar");
	progressBar.style.width = progressPercentage.toFixed(2) + "%";
	
}*/


/*function setProfile(responseData){
	var branchNameElement = document.querySelector('.branch-name');
	var nameElement = document.querySelector('.name');

	branchNameElement.textContent = 'Cabang ' + responseData.agentRegional;
	nameElement.textContent = responseData.agentName;
}*/

function createClubTarget(data){
    if (!data || !data.name) return null;
    
    var clubDiv = document.createElement('div');
    clubDiv.className = 'level-after';
    
    var clubIdDiv = document.createElement('div');
    clubIdDiv.id = 'level-' + data.name.toLowerCase();
    clubIdDiv.className = 'w-40px-h-50px agency-self-center';
    
    clubDiv.appendChild(clubIdDiv);
    
    var clubNameDiv = document.createElement('div');
    clubNameDiv.className = 'level-name agency-self-center ml-24px';
    
    var klubNowSpan = document.createElement('span');
    klubNowSpan.className = 'display-block text-responsive-14px agency-uppercase agency-leading-none';
    klubNowSpan.textContent = 'Klub Selanjutnya'; // + new Date().getFullYear();
    
    var clubNameSpan = document.createElement('span');
    clubNameSpan.className = 'display-block text-responsive-16px';
    clubNameSpan.textContent = data.name;
    
    clubNameDiv.appendChild(klubNowSpan);
    clubNameDiv.appendChild(clubNameSpan);

    clubDiv.appendChild(clubNameDiv);

    return clubDiv;
}

function createClubNow(data){
    if (!data || !data.club) return null;
    
    var clubDiv = document.createElement('div');
    clubDiv.className = 'level-now';
    
    var clubIdDiv = document.createElement('div');
    clubIdDiv.id = 'level-' + data.club.toLowerCase().replace(/\s+/g, '');
    
    clubDiv.appendChild(clubIdDiv);
    
    var clubNameDiv = document.createElement('div');
    clubNameDiv.className = 'level-name agency-self-center line-height-30px';
    
    var klubNowSpan = document.createElement('span');
    klubNowSpan.className = 'display-block text-responsive-14px agency-uppercase agency-leading-normal mb-responsive-4px';
    klubNowSpan.textContent = 'Klub Sekarang';
    
    var clubNameSpan = document.createElement('span');
    clubNameSpan.className = 'display-block text-responsive-35px agency-break-all';
    clubNameSpan.textContent = data.club;
    
    clubNameDiv.appendChild(klubNowSpan);
    clubNameDiv.appendChild(clubNameSpan);

    clubDiv.appendChild(clubNameDiv);
    
    return clubDiv;
}

function setPriceAndProgressBar(totalProduksi, keTarget, isPalladium){
    if (totalProduksi == null || keTarget == null) return;
    
    var totalProduksiFormatted = totalProduksi.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
    $('.club-total-product__left strong').text('Rp ' + totalProduksiFormatted);
    
    if(!isPalladium){
        var keTargetFormatted = keTarget.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
        $('.club-total-product__right strong').text('Rp ' + keTargetFormatted);        
    }
    
    var progressPercentage;
    if (totalProduksi >= keTarget) {
        progressPercentage = 100;
    } else {
        progressPercentage = (totalProduksi / keTarget) * 100;
    }

    var progressBar = document.querySelector(".club-progress-bar");
    progressBar.style.width = progressPercentage.toFixed(2) + "%";
}

function setProfile(responseData){
    var branchNameElement = document.querySelector('.branch-name');
    var nameElement = document.querySelector('.name');

    branchNameElement.textContent = (responseData && responseData.agentRegional ? 'Cabang ' + responseData.agentRegional : '');
    nameElement.textContent = responseData && responseData.agentName ? responseData.agentName : '';
}

function loadPage() {
    $.ajax({
        url: loadAgentViewDashboardDataURL,
        type: "POST",
        data: {
            dataCategory: "main",
            rtoken: rToken,
            aptoken: apToken
        },
        timeout: 120000,
        dataType: "json",
        success: function(response) {
        	
            if (response.status) {
                responseProfile = response.dataProfile;

            	setProfile(responseProfile);
                
                apToken = response.token ? response.token : "";
            	
            	loadClubYears();
            }
        },
        error: function(xhr, status, error) {
            console.error("Error while fetch data:", status, error);
        }
    });
}

function loadClubYears(){
	$.ajax({
        url: loadAgentViewDashboardDataURL,
        type: "POST",
        data: {
            dataCategory: "club",
            rtoken: rToken,
            aptoken: apToken
        },
        timeout: 120000,
        dataType: "json",
        success: function(response) {
        	
            if (response.status) {
            	
                responseClubYearTarget = response.dataTargetClubYear;
                responseClubYearAPI = response.data;
            	
            	var bannerClub =  document.querySelector('.club__hero');
            	bannerClub.id = responseClubYearAPI.club.toLowerCase().replace(/\s+/g, '-');
            	
            	var alertMemberClubLeft = document.querySelector('.alert-member-club__left');
            	var alertMemberClubRight = document.querySelector('.alert-member-club__right');
            	                
            	$('.level-now').remove();
                $('.level-after').remove();
                                
                var amountOfLatestYear = parseFloat(responseClubYearAPI.amount);
                var amountOfTarget = parseFloat(responseClubYearTarget.minGwp);
                
                var container = document.querySelector('.club__hero--left');
                // append club now
                container.appendChild(createClubNow(responseClubYearAPI));
                
                // check if club target needs to append
                if(response.data.club.toLowerCase().replace(/\s+/g, '') !== 'diamond'){
                	// append club target
                	container.appendChild(createClubTarget(responseClubYearTarget));                	                                   
                	
                	//is not palladium
                	setPriceAndProgressBar(amountOfLatestYear, amountOfTarget, false);

                	// show info price target
                    $('.club-total-product__right span').text('Untuk ke ' + responseClubYearTarget.name);                                                
                	$('.alert-member-club__left p.text-member').html('Ayo jadi Member ' +responseClubYearTarget.name+' dengan cara selesaikan progres di atas sebelum <strong>31 Des ' +new Date().getFullYear()+ '!</strong>');
                    
                }else{
                	//is palladium
                    setPriceAndProgressBar(amountOfLatestYear, amountOfTarget, true);
                	
                    // remove info
                    $('.alert-member-club__left p.text-member').html('');
                	$('.text-member-btn strong').text('');

                	//Untuk Ke
                	$('.club-total-product__right span').text(''); 
                	//RP
                	$('.club-total-product__right strong').text('');  
                }
                                                               
                
                apToken = response.token ? response.token : "";
            }
        },
        error: function(xhr, status, error) {
            console.error("Error while fetch data:", status, error);
        }
    });
	
}

//Send the height of the content to the parent document
function sendHeightToParent() {
	var height = document.getElementById('content').scrollHeight;
	window.parent.postMessage({ height: height }, '*');
}

//Call sendHeightToParent when the content of the iframe changes
document.addEventListener('DOMContentLoaded', function() {
	sendHeightToParent();
});

window.addEventListener('resize', function() {
	sendHeightToParent();
});