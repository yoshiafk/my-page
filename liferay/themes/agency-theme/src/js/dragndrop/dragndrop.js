$(document).ready(function() {
    function readFileProfile(input) {
        if (input.files && input.files[0]) {
            var readerProfile = new FileReader();

            readerProfile.onload = function(e) {
                var htmlPreview =
                    '<img width="200" src="' + e.target.result + '" />' +
                    '<div class="agency-text-left agency-self-center">' + '<span class="display-block agency-font-semibold agency-text-grey-600">' + 'Upload Berhasil' + '</span>' + '<span class="text-clamp-1 display-block agency-text-grey-600">' + input.files[0].name + '</span>' + '</div>';
                // '<p class="self-center">' + input.files[0].name + '</p>';
                var wrapperZoneProfile = $(input).parent();
                var previewZoneProfile = $(input).parent().parent().find('.preview-zone-profile');
                var boxZoneProfile = $(input).parent().parent().find('.preview-zone-profile').find('.box-profile').find('.box-body-profile');

                wrapperZoneProfile.removeClass('dragover-profile');
                previewZoneProfile.removeClass('display-none');
                $('.dropzone-profile-desc').addClass('display-none');
                $('.dropzone-profile-wrapper').addClass('display-none');
                boxZoneProfile.empty();
                boxZoneProfile.append(htmlPreview);
            };
            readerProfile.readAsDataURL(input.files[0]);
        }
    }

    function readFileBanner(input) {
        if (input.files && input.files[0]) {
            var readerBanner = new FileReader();

            readerBanner.onload = function(e) {
                var htmlPreview =
                    '<img width="200" src="' + e.target.result + '" />' +
                    '<div class="agency-text-left agency-self-center">' + '<span class="display-block agency-font-semibold agency-text-grey-600">' + 'Upload Berhasil' + '</span>' + '<span class="text-clamp-1 display-block agency-text-grey-600">' + input.files[0].name + '</span>' + '</div>';
                //   '<p class="self-center">' + input.files[0].name + '</p>';
                var wrapperZoneBanner = $(input).parent();
                var previewZoneBanner = $(input).parent().parent().find('.preview-zone-banner');
                var boxZoneBanner = $(input).parent().parent().find('.preview-zone-banner').find('.box-banner').find('.box-body-banner');

                wrapperZoneBanner.removeClass('dragover-banner');
                previewZoneBanner.removeClass('display-none');

                $('.dropzone-banner-desc').addClass('display-none');
                $('.dropzone-banner-wrapper').addClass('display-none');
                boxZoneBanner.empty();
                boxZoneBanner.append(htmlPreview);
            };
            readerBanner.readAsDataURL(input.files[0]);
        }
    }

    function readFileUploadTimeline(input) {
        if (input.files && input.files[0]) {
            var readerUploadTimeline = new FileReader();

            readerUploadTimeline.onload = function(e) {
                var htmlPreview =
                    '<img width="200" src="' + e.target.result + '" />' +
                    '<div class="agency-text-left agency-self-center">' + '<span class="text-success-upload display-block agency-font-semibold agency-text-grey-600">' + 'Upload Berhasil' + '</span>' + '<span class="text-upload-desc text-clamp-1 display-block agency-text-grey-600">' + input.files[0].name + '</span>' + '</div>';
                //   '<p class="self-center">' + input.files[0].name + '</p>';
                var wrapperZoneUploadTimeline = $(input).parent();
                var previewZoneUploadTimeline = $(input).parent().parent().parent().parent().parent().find('.preview-zone-upload-timeline');
                var boxZoneUploadTimeline = $(input).parent().parent().parent().parent().parent().find('.preview-zone-upload-timeline').find('.box-upload-timeline').find('.box-body-upload-timeline');

                wrapperZoneUploadTimeline.removeClass('dragover-upload-timeline');
                previewZoneUploadTimeline.removeClass('display-none');

                $('.dropzone-upload-timeline-desc').addClass('display-none');
                $('.dropzone-upload-timeline-wrapper').addClass('display-none');
                boxZoneUploadTimeline.empty();
                boxZoneUploadTimeline.append(htmlPreview);
            };
            readerUploadTimeline.readAsDataURL(input.files[0]);
        }
    }

    function reset(e) {
        e.wrap('<form>').closest('form').get(0).reset();
        e.unwrap();
    }

    $(".dropzone-profile").change(function() {
        readFileProfile(this);
    });

    $(".dropzone-banner").change(function() {
        readFileBanner(this);
    })

    $(".dropzone-upload-timeline").change(function() {
        readFileUploadTimeline(this);
    })

    $('.remove-preview-profile').on('click', function() {
        var boxZoneProfile = $(this).parents('.preview-zone-profile').find('.box-body-profile');
        var previewZoneProfile = $(this).parents('.preview-zone-profile');
        var dropzoneprofile = $(this).parents('.change-profile').find('.dropzone-profile');
        boxZoneProfile.empty();
        previewZoneProfile.addClass('display-none');
        $('.dropzone-profile-desc').removeClass('display-none');
        $('.dropzone-profile-wrapper').removeClass('display-none');
        reset(dropzoneprofile);
    });
    $('.remove-preview-banner').on('click', function() {
        var boxZoneBanner = $(this).parents('.preview-zone-banner').find('.box-body-banner');
        var previewZoneBanner = $(this).parents('.preview-zone-banner');
        var dropzonebanner = $(this).parents('.change-banner').find('.dropzone-banner');
        boxZoneBanner.empty();
        previewZoneBanner.addClass('display-none');
        $('.dropzone-banner-desc').removeClass('display-none');
        $('.dropzone-banner-wrapper').removeClass('display-none');
        reset(dropzonebanner);
    });
    $('.remove-preview-upload-timeline').on('click', function() {
        var boxZoneUploadTimeline = $(this).parent().parent().parents('.preview-zone-upload-timeline').find('.box-body-upload-timeline');
        var previewZoneUploadTimeline = $(this).parent().parent().parents('.preview-zone-upload-timeline');
        var dropzoneuploadtimeline = $(this).parent().parent().parents('.change-upload-timeline').find('.dropzone-upload-timeline');
        boxZoneUploadTimeline.empty();
        previewZoneUploadTimeline.addClass('display-none');
        $('.dropzone-upload-timeline-desc').removeClass('display-none');
        $('.dropzone-upload-timeline-wrapper').removeClass('display-none');
        reset(dropzoneuploadtimeline);
    });
});

$('.dropzone-upload-timeline').on('mouseenter', function() {
    $('.svg-hover').addClass('active');
})

$('.dropzone-upload-timeline').on('mouseleave', function() {
    $('.svg-hover').removeClass('active');
})