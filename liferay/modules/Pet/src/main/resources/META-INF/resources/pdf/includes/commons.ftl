<#macro title title subtitle="" type="slash">
	<div class="col-xs-12">
  		<div class="row title ${type}">
  			<div class="col-xs-12">
  				<h3>${title}</h3>
  				<#if subtitle != "">
  				<span>${subtitle}</span>
  				</#if>
  			</div>
  			<#if type == "slash">
  				<div class="slash"></div>
  			</#if>
  		</div>
	</div>
</#macro>