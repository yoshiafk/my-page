<%
	//String webContentURL = String.valueOf(renderRequest.getAttribute("webContentURL"));
	//if(webContentURL.isEmpty() || webContentURL == "null") {
		//webContentURL = "javascript:void(0)";
	//}
%>

<nav class="menubar menubar-transparent menubar-vertical-expand-lg">
	<ul class="nav nav-nested">
		<li class="nav-item"><strong class="text-truncate text-uppercase">General </strong>
			<ul class="mb-2 nav nav-stacked">
				<li class="nav-item">
					<a href="<%=configurationURL%>" class="d-flex nav-link pl-3 <%=_active == "configuration" ? " active " : ""%>">
						<aui:icon cssClass="" image="cog" markupView="lexicon" />&nbsp;<span class="pl-2 text-truncate">Configuration</span>
					</a>
				</li>
                <%-- <li class="nav-item">
                    <a href="<%=premiURL%>" class="d-flex nav-link pl-3 <%= _active == "premi" ? " active " : "" %>">
                        <aui:icon cssClass="" image="categories" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Premi</span>
                    </a>
                </li> --%>
                
                
				<li class="nav-item"><a href="<%=benefitTypeURL%>"
					class="d-flex nav-link pl-3 <%=_active == "benefit_type" ? " active " : ""%>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Benefit Type</span>
				</a></li>
				
				<li class="nav-item"><a href="<%=benefitURL%>"
					class="d-flex nav-link pl-3 <%=_active == "benefit" ? " active " : ""%>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Benefit</span>
				</a></li>
				
				<li class="nav-item">
					<a href="<%=benefitValueMappingURL%>" class="d-flex nav-link pl-3 <%=_active == "benefit_value_mapping" ? " active " : ""%>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /> <span class="pl-2 text-truncate">Benefit Value Mapping</span>
					</a></li>
				
				<li class="nav-item"><a href="<%=planURL%>"
					class="d-flex nav-link pl-3 <%=_active == "plan" ? " active " : ""%>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Plan</span>
				</a></li>
				
				<li class="nav-item"><a href="<%=premiURL%>"
					class="d-flex nav-link pl-3 <%=_active == "premi" ? " active " : ""%>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Premi</span>
				</a></li>
				
				<li class="nav-item"><a href="<%=linkURL%>"
					class="d-flex nav-link pl-3 <%=_active == "link" ? " active " : ""%>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Links</span>
				</a></li>				
                				
			</ul>
		</li>

	</ul>
</nav>