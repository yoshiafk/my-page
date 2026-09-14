<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

	<#if !is_signed_in>
		<script type="text/javascript">
			var linkLiferayCSSElements = document.querySelectorAll('link.lfr-css-file');
			linkLiferayCSSElements.forEach(function (linkElement) { linkElement.parentNode.removeChild(linkElement) })
		</script>
	</#if>

	<link rel="stylesheet" href="${css_folder}/fontawesome/fontawesome.min.css" />

	<#if last_part=="asuransi-perjalanan" || last_part=="asuransi-perjalanan-step2" || last_part=="asuransi-perjalanan-step3" || last_part=="asuransi-perjalanan-riplay" || last_part=="asuransi-perjalanan-payment" || last_part=="asuransi-smartactive">
		<link rel="stylesheet" href="${css_folder}/select2/select2.css" />
		<link rel="stylesheet" href="${css_folder}/swiper/swiper.min.css" />
		<link rel="stylesheet" href="${css_folder}/datepicker/datepicker.css" />
		
		<#if last_part=="asuransi-smartactive">
			<link rel="stylesheet" href="${css_folder}/range-slider/ion.rangeSlider.css" />
		</#if>

		<script src="${javascript_folder}/jquery/jquery.min.js" type="text/javascript"></script>
		<script src="${javascript_folder}/bootstrap/bootstrap.min.js" type="text/javascript"></script>
		<script src="${javascript_folder}/select2/select2.min.js" type="text/javascript"></script>
		<script src="${javascript_folder}/swiper/swiper.min.js" type="text/javascript"></script>
		<script src="${javascript_folder}/datepicker/moment.min.js" type="text/javascript"></script>
		<script src="${javascript_folder}/datepicker/momment-local.min.js" type="text/javascript"></script>
		<script src="${javascript_folder}/datepicker/datepicker.min.js" type="text/javascript"></script>

		<#if last_part=="asuransi-smartactive">
			<script src="${javascript_folder}/range-slider/ion.rangeSlider.min.js" type="text/javascript"></script>
		</#if>

		<script src="${javascript_folder}/custom.js" type="text/javascript"></script>
	</#if>

	<link rel="stylesheet" href="${css_folder}/tailwind/dist/output.css" />

<!-- <@liferay_ui["quick-access"] contentId="#main-content" /> -->

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<!-- <div class="container-fluid" id="wrapper"> -->

	<#if showHeader>

		<header id="banner" role="banner">
			<div id="heading">
				<div aria-level="1" class="site-title" role="heading">
					<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
					</a>

					<#if show_site_name>
						<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							${site_name}
						</span>
					</#if>
				</div>
			</div>

			<#if !is_signed_in>
				<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
			</#if>

			<#if has_navigation && is_setup_complete>
				<#-- <#include "${full_templates_path}/navigation.ftl" /> -->
			</#if>
		</header>

	</#if>


	<section id="content" class="bg-white">
		
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

<!-- </div> -->

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>