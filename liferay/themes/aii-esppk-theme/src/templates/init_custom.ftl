<#assign root_css_class = root_css_class + " h-full w-full scroll-smooth" />
<#assign css_class = css_class + " h-full font-sourcesans font-normal" />
<#assign version = .now?long />
<#assign showHeader=getterUtil.getBoolean(theme_settings["Show Header"])>
<#assign showFooter=getterUtil.getBoolean(theme_settings["Show Footer"])>