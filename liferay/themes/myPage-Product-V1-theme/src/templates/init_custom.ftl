<#--
This file allows you to override and define new FreeMarker variables.
-->
<#assign
	show_header_menu = getterUtil.getBoolean(theme_settings["show-menu"])
	select_header_type = getterUtil.getString(theme_settings["header-type"])
/>

<#assign
	sign_in_url="/auth"
/>