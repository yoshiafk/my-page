var html = $("html");
var body = $("body");

html.addClass("html__agency");
body.addClass("body__agency body-white");

var rToken = window.rToken;
var apToken = window.apToken;
var hostpim = window.hostpim;


function createPagination(start, dataPerPage, startPage, endPage, currPage, totalPages, isDisabled, isDisabledNext, stringClassPaginationElement) {
    //console.log('script createPagination !!!')
	var paginationHtml = '';
    paginationHtml += '<li>';
	    paginationHtml += '<a class="' + (isDisabled ? 'disabled prev' : 'prev') + '" aria-label="Previous" onclick="goPaging(\'' + (start - dataPerPage) + '\')" >Sebelumnya</a>';
	    paginationHtml += '<a class="' + (isDisabled ? 'disabled prev-mobile' : 'prev-mobile') + '" aria-label="Previous" onclick="goPaging(\'' + (start - dataPerPage) + '\')" ><i class="fas fa-chevron-left"></i></a>';
    paginationHtml += '</li>';

    if (startPage > 1) {
        paginationHtml += '<li>';
        	paginationHtml += '<a onclick="goPaging(\'0\')">1</a>';
        paginationHtml += '</li>';

        if (startPage > 2) {
            paginationHtml += '<li><a class="disabled"> . . . </a></li>';
        }
    }

    for (var i = startPage; i <= endPage; i++) {
        paginationHtml += '<li>';
        	paginationHtml += '<a class="' + (i == currPage ? 'active' : '') + '" onclick="goPaging(\'' + ((i - 1) * dataPerPage) + '\')" ' + (i == currPage ? 'aria-current="page"' : '') + '>' + i + '</a>';
        paginationHtml += '</li>';
    }

    if (endPage < totalPages) {
        if (endPage < totalPages - 1) {
            paginationHtml += '<li><a class="disabled"> . . . </a></li>';
        }

        paginationHtml += '<li>';
        	paginationHtml += '<a onclick="goPaging(\'' + ((totalPages - 1) * dataPerPage) + '\')" ' + (totalPages == currPage ? 'aria-current="page"' : '') + '>' + totalPages + '</a>';
        paginationHtml += '</li>';
    }

    paginationHtml += '<li>';
	    paginationHtml += '<a class="' + (isDisabledNext ? 'disabled next' : 'next') + '" aria-label="Next" onclick="goPaging(\'' + (start + dataPerPage) + '\')">Selanjutnya</a>';
	    paginationHtml += '<a class="' + (isDisabledNext ? 'disabled next-mobile' : 'next-mobile') + '" aria-label="Next" onclick="goPaging(\'' + (start + dataPerPage) + '\')"><i class="fas fa-chevron-right"></i></a>';
    paginationHtml += '</li>';

    $(stringClassPaginationElement).html(paginationHtml); //'.pagination'
}


//loading table
function showLoading() {
	 //console.log('script showLoading !!!!')
    document.getElementById('loadingOverlay').style.display = 'flex';
}

function hideLoading() {
	 //console.log('script hideLoading !!!!')
    document.getElementById('loadingOverlay').style.display = 'none';
}


// Add the keyframes animation inline
const styleSheet = document.createElement("style");
styleSheet.type = "text/css";
styleSheet.innerText = `
    @keyframes spin {
        to { transform: rotate(360deg); }
    }
`;
document.head.appendChild(styleSheet);

//end loading table


function goPaging(start) {
	 //console.log('script goPaging!!!!')
	var urlParam = searchFilter();	
	var formData = createFormData(urlParam);
	renderPage(formData, start);
	  	
}

function getAllUrlParams(url) {
	 //console.log('script getAllUrlParams!!!!')

	var queryString = url ? url.split('?')[1] : window.location.search.slice(1);
    var obj = {};
    if (queryString) {
        queryString = queryString.split('#')[0];
        var arr = queryString.split('&');
        for (var i = 0; i < arr.length; i++) {
            var a = arr[i].split('=');
            var paramName = a[0];
            var paramValue = typeof (a[1]) === 'undefined' ? true : decodeURIComponent(a[1]);
            if (paramName.match(/\[(\d+)?\]$/)) {
                var key = paramName.replace(/\[(\d+)?\]/, '');
                if (!obj[key]) obj[key] = [];
                if (paramName.match(/\[\d+\]$/)) {
                    var index = /\[(\d+)\]/.exec(paramName)[1];
                    obj[key][index] = paramValue;
                } else {
                    obj[key].push(paramValue);
                }
            } else {
                if (!obj[paramName]) {
                    obj[paramName] = paramValue;
                } else if (obj[paramName] && typeof obj[paramName] === 'string'){
                    obj[paramName] = [obj[paramName]];
                    obj[paramName].push(paramValue);
                } else {
                    obj[paramName].push(paramValue);
                }
            }
        }
    }
    return obj;
}

function createFormData(url){
	//console.log('script createFormData!!!!', url)
	var queryParams = getAllUrlParams(url);
    var formData = new FormData();
    for (var key in queryParams) {
        if (queryParams.hasOwnProperty(key)) {
            formData.append(key, queryParams[key]);
        }
    }
    
    return formData;
}


function sortTable(n) {
	 //console.log('script sortTable!!!!')

    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("Table");
    switching = true;
    //Set the sorting direction to ascending:
    dir = "asc";
    /*Make a loop that will continue until
    no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /*Loop through all table rows (except the
        first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
            one from current row and one from the next:*/
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /*check if the two rows should switch place,
            based on the direction, asc or desc:*/
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /*If a switch has been marked, make the switch
            and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            //Each time a switch is done, increase this count by 1:
            switchcount++;
        } else {
            /*If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again.*/
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

//add height frame
function sendHeightToParent() {
	setTimeout(function() {
		var contentElement = document.getElementById('content');
		if (contentElement) {
			var height = contentElement.scrollHeight;
			//console.log('Sending height:', height);
			window.parent.postMessage({ height: height }, '*');
		} else {
			console.error('Element with id "content" not found');
		}
	}, 100); // Delay 100ms
} 

$(document).ready(function() {
	 //console.log('script doc ready product!!!!')

    /*$('.btn-filter-advance').click(function() {
        var $this = $('.filter-text');
        $this.toggleClass('filter-change-text');
        if ($this.hasClass('filter-change-text')) {
            $this.text('Tutup Filter');
            $(this).addClass('is-open');
            $('#btn-search').addClass('is-hidden');
        } else {
            $this.text('Filter');
            $(this).removeClass('is-open');
            $('#btn-search').removeClass('is-hidden');
        }
        
       
    });*/
    
    $(function () { 
        $('.btn-filter-advance').on('click', function (e) {
            var FilterGridContent = $( e.currentTarget );
            var $this = $('.filter-text');

            if (FilterGridContent.attr( 'aria-expanded') === 'false') {
                $('.filter-grid').attr( 'aria-expanded', 'false');
                $this.text('Filter');
            } else {
                $this.text('Tutup Filter');
                $('.filter-grid').attr( 'aria-expanded', 'true');
            }
        });
    });
    
    
    $('.btn-filter-advance').click(function() {
        $('#type-polis').select2({
            placeholder: "Pilih tipe polis",
            width: '100%',
            minimumResultsForSearch: -1
        });
        $('#status').select2({
            placeholder: "Pilih status",
            width: '100%',
            minimumResultsForSearch: -1
        });
    });
    
    
    const myCollapsible = document.getElementById('collapseFilter')
    myCollapsible.addEventListener('shown.bs.collapse', event => {
    	sendHeightToParent();
    })
    
    myCollapsible.addEventListener('hidden.bs.collapse', event => {
    	sendHeightToParent();
    })
    
    $('#product').multiselect({
        includeSelectAllOption: true,
        nSelectedText: 'Produk yang terpilih',
        selectAllText: 'Pilih semua',
        allSelectedText: 'Pilih semua produk',
        maxHeight: 200,
        numberDisplayed: 2,
        nonSelectedText: 'Pilih Produk',
        templates: {
            button: '<button type="button" class="multiselect dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"><span class="multiselect-selected-text"></span></button>',
            popupContainer: '<div class="multiselect-container dropdown-menu"></div>',
            filter: '<div class="multiselect-filter"><i class="fas fa-sm fa-search"></i><input type="search" class="multiselect-search" /></div>',
            buttonGroup: '<div class="multiselect-buttons btn-group" style="display:flex;"></div>',
            buttonGroupReset: '<button type="button" class="multiselect-reset"></button>',
            option: '<button type="button" class="multiselect-option dropdown-item"></button>',
            divider: '<div class="dropdown-divider"></div>',
            optionGroup: '<button type="button" class="multiselect-group dropdown-item"></button>',
            resetButton: '<div class="multiselect-reset"><button type="button" class="btn"></button></div>'
        }
    });
    $('#product').on('change', function() {
        var check = $(this).val();
        if (check.length === 0) {
            $('.multiselect-selected-text').removeClass("selected");
        } else {
            $('.multiselect-selected-text').addClass("selected");
        }
    });
    	
	$('.link-dashboard').click(function(e) {
		e.preventDefault();
		parent.location.href = this.href;
	});
	
});

