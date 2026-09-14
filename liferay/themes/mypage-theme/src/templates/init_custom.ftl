<#assign
    current_url=theme_display.getURLCurrent()
    parts=current_url?split("/")
    last_part=parts[parts?size - 1]
/>

<#if last_part?index_of("?")!=-1>
    <#assign last_part=last_part?split("?")[0]>
</#if>

<#assign showHeader=getterUtil.getBoolean(theme_settings["Show Header"])>
<#assign showFooter=getterUtil.getBoolean(theme_settings["Show Footer"])>