var inputElement = document.getElementById("input-file-upload");
var cancelButton = document.getElementById("cancel-upload");
var numFiles = 0;

$(document).ready(function() {
	$(document).on('click', '.link-product', function(e) {
		e.preventDefault();
	    window.open(this.href, '_blank');
	});

	$("#toggle-list-details").click(function() {
	    $('#see-all').slideToggle(450);
	    $(this).find('span').text(function(i, text){
	        return text === "Tutup" ? "Lihat Semua" : "Tutup";
	    });                                
	    $(this).find('i').toggleClass('far fa-arrow-up'); 
	});
});

inputElement.onclick = function(event) {
    var target = event.target || event.srcElement;
    if (target.value.length == 0) {
        $('.btn-create-status').addClass('btn--disabled');
        $('.btn-create-status').removeClass('btn--dark-blue');
        $('.btn-create-status').prop('disabled', true);
        $('#toggle-video').removeClass('is-show');
        $('#toggle-video').removeClass('display-none');
        $('#link_video-wrapper').hide();
        cancelButton.onclick();
    } else {
        $('.btn-create-status').addClass('btn--dark-blue');
        $('.btn-create-status').removeClass('btn--disabled');
        $('.btn-create-status').prop('disabled', false);
        $('#toggle-video').removeClass('is-show');
        $('#toggle-video').addClass('display-none');
        $('#link_video-wrapper').hide();
        numFiles = target.files.length;
    }
}

inputElement.onchange = function(event) {
    var target = event.target || event.srcElement;
    if (target.value.length == 0) {
        if (numFiles == target.files.length) {
            $('.btn-create-status').addClass('btn--disabled');
            $('.btn-create-status').removeClass('btn--dark-blue');
            $('.btn-create-status').prop('disabled', true);
            $('#toggle-video').addClass('display-none');
            $('#status').addClass('input-status');
            cancelButton.onclick();
        }
    } else {
        $('.btn-create-status').addClass('btn--dark-blue');
        $('.btn-create-status').removeClass('btn--disabled');
        $('.btn-create-status').prop('disabled', false);
        $('#status').removeClass('input-status');
        $('#toggle-video').removeClass('is-show');
        $('#toggle-video').addClass('display-none');
        $('#link_video-wrapper').hide();
        numFiles = target.files.length;
    }
}

inputElement.onblur = function(event) {
    var target = event.target || event.srcElement;
    if (target.value.length == 0) {
        if (numFiles == target.files.length) {
            $('.btn-create-status').addClass('btn--disabled');
            $('.btn-create-status').removeClass('btn--dark-blue');
            $('.btn-create-status').prop('disabled', true);
            $('#toggle-video').removeClass('display-none');
            cancelButton.onclick();
        }
    } else {
        $('.btn-create-status').addClass('btn--dark-blue');
        $('.btn-create-status').removeClass('btn--disabled');
        $('.btn-create-status').prop('disabled', false);
        $('#link_video-wrapper').hide();
        $('#toggle-video').addClass('display-none');
        $('#toggle-video').removeClass('is-show');
        numFiles = target.files.length;
    }
}

cancelButton.onclick = function(event) {
    $('.btn-create-status').addClass('btn--disabled');
    $('.btn-create-status').removeClass('btn--dark-blue');
    $('.btn-create-status').prop('disabled', true);
}

$('#cancel-upload').on('click', function() {
    $('#toggle-video').removeClass('display-none');
    $('#status').addClass('input-status');
});

$('.input-status, .input-link').keyup(function() {
    var inputStatus = $('.input-status').val().length;
    var inputLink = $('.input-link').val().length;
    var total = inputStatus + inputLink
    if(total > 0) {
        $('.btn-create-status').removeClass('btn--disabled');
        $('.btn-create-status').addClass('btn--dark-blue');
        $('.btn-create-status').prop('disabled', false);
    } else {
        $('.btn-create-status').addClass('btn--disabled');
        $('.btn-create-status').removeClass('btn--dark-blue');
        $('.btn-create-status').prop('disabled', true);
    }
});

$('.input-link').keyup(function() {
    var inputLink = $('.input-link').val().length;
    var total = inputLink
    if(total > 0) {
        $('.dropzone-upload-timeline-wrapper').addClass('display-none');
    } else {
        $('.dropzone-upload-timeline-wrapper').removeClass('display-none');
    }
});

$('#cancel-upload').on('click', function() {
    var inputStatus = $('.input-status').val().length;
    var total = inputStatus
    if(total > 0) {
        $('.btn-create-status').removeClass('btn--disabled');
        $('.btn-create-status').addClass('btn--dark-blue');
        $('.btn-create-status').prop('disabled', false);
    } else {
        $('.btn-create-status').addClass('btn--disabled');
        $('.btn-create-status').addClass('btn--dark-blue');
        $('.btn-create-status').prop('disabled', true);
    }
});

$("#toggle-video").click(function() { 
    $('#link_video-wrapper').slideToggle(450);
    $(this).toggleClass('is-show');
});
