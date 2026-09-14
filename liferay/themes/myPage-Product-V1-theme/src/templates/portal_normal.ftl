<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	<script src="${javascript_folder}/main-oldtheme.js" type="text/javascript"></script>
</head>

<body class="${css_class}">

	<@liferay_ui["quick-access"] contentId="#main-content" />
	<@liferay_util["include"] page=body_top_include />
	
<#if show_control_panel>
	<@liferay.control_menu />
</#if>

<div id="wrapper" class="pt-0">	
	<#if select_header_type=="agency">
		<#if show_header_menu>
			<#include "${full_templates_path}/mypage/header_agency.ftl" />
		</#if>
	<#else>
		<#if show_header_menu>
			<#include "${full_templates_path}/mypage/header.ftl" />
		<#else>
			<#include "${full_templates_path}/mypage/header_product.ftl" />
		</#if>
	</#if>

	<section id="content">
		<h2 class="hide-accessible d-none" role="heading" aria-level="1">${the_title}</h2>

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

	<#include "${full_templates_path}/mypage/footer.ftl" />
</div>

<@liferay_util["include"] page=body_bottom_include />

<!--<script src="/o/myPage-Product-V1-theme/js/plugins/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="/o/myPage-Product-V1-theme/js/plugins/popper.min.js" type="text/javascript"></script>
<script src="/o/myPage-Product-V1-theme/js/plugins/bootstrap.js" type="text/javascript"></script>-->

<@liferay_util["include"] page=bottom_include />

</body>

</html>