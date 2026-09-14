<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="robots" content="noindex, nofollow">
	<link rel="apple-touch-icon" sizes="57x57" href="${images_folder}/ico/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="${images_folder}/ico/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="${images_folder}/ico/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="${images_folder}/ico/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="${images_folder}/ico/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="${images_folder}/ico/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="${images_folder}/ico/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="${images_folder}/ico/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="${images_folder}/ico/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="${images_folder}/ico/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="${images_folder}/ico/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${images_folder}/ico/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${images_folder}/ico/favicon-16x16.png">
	<link rel="manifest" href="${images_folder}/ico/manifest.json">
	<meta name="msapplication-TileColor" content="#00008F">
	<meta name="msapplication-TileImage" content="${images_folder}/ico/ms-icon-144x144.png">
	<meta name="theme-color" content="#00008F">

	<@liferay_util["include"] page=top_head_include />

	<#if !is_signed_in>
		<script type="text/javascript">
			var linkLiferayCSSElements = document.querySelectorAll('link.lfr-css-file');
			linkLiferayCSSElements.forEach(function (linkElement) { linkElement.parentNode.removeChild(linkElement) })
		</script>
	</#if>

	<link rel="stylesheet" href="${css_folder}/fontawesome/fontawesome.min.css" />
	<link rel="stylesheet" href="${css_folder}/datepicker/datepicker.css" />

	<script src="${javascript_folder}/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/datepicker/moment.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/jquery-validation/jquery.validation.min.js" type="text/javascript"></script>
	<script src="${javascript_folder}/datepicker/datepicker.min.js" type="text/javascript"></script>

	<link rel="stylesheet" href="${css_folder}/tailwind/dist/output.css" />
</head>

<body class="${css_class}">

<!-- <@liferay_ui["quick-access"] contentId="#main-content" /> -->

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<!-- <div class="container-fluid" id="wrapper"> -->

	<#if showHeader>
		<#include "${full_templates_path}/header.ftl" />
	</#if>

	<section id="content">
		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<#if showFooter>
		<#include "${full_templates_path}/footer.ftl" />
	</#if>

<!-- </div> -->

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>