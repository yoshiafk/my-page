<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key=" lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />

	<#if !is_signed_in>
		<script type="text/javascript">
			var linkLiferayCSSElements = document.querySelectorAll('link.lfr-css-file');
			linkLiferayCSSElements.forEach(function (linkElement) { linkElement.parentNode.removeChild(linkElement) })
		</script>
	</#if>

	<link rel="stylesheet" href="${css_folder}/datepicker/datepicker.css?v=${version}" />
	<link rel="stylesheet" href="${css_folder}/datatables/jquery.dataTables.min.css" />
	<link rel="stylesheet" href="${css_folder}/fontawesome/fontawesome.min.css" />
	<link rel="stylesheet" href="${css_folder}/select2/select2.css" />
	<link rel="stylesheet" href="${css_folder}/tailwind/dist/output.css?v=${version}" />	

	<script src="${javascript_folder}/bootstrap/popperjs.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/moment/moment.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/moment/moment-local.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/jquery-validation/jquery.validation.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/datepicker/datepicker.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/select2/select2.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/validator.js?v=${version}" type="text/javascript"></script>
	<script src="${javascript_folder}/custom.js?v=${version}" type="text/javascript"></script>
</head>

<body class="${css_class}">
	<@liferay_util["include"] page=body_top_include />
	<@liferay.control_menu />

	<div class="absolute w-full text-center">
		<div class="alert relative text-base p-4 m-0 border-0 border-solid border-transparent rounded-none z-[1] hidden" role="alert">
			<span class="alert-message">Gagal request ke server, silakan coba beberapa saat lagi</span>
			<button type="button" class="text-white text-[1.5rem] absolute right-4 bg-transparent border-none cursor-pointer" id="alert-close">&times;</button>
		</div>
	</div>

	<section id="content">
		<#if selectable>
			<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}

				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
					</@>
		</#if>
	</section>

	<@liferay_util["include"] page=body_bottom_include />

	<@liferay_util["include"] page=bottom_include />

	<script>
		$('button#alert-close').click(function () {
			$('.alert').removeClass('animate-vertical_slide').addClass('hidden')
		})

		function GetFieldData(input){
			return input.replace(/[a-zA-Z]/g, function(c){return String.fromCharCode((c <= "Z" ? 90 : 122) >= (c = c.charCodeAt(0) + 13) ? c : c - 26); }); 
		};
	</script>

</body>

</html>