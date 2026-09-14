<%
	String webContentURL = String.valueOf(renderRequest.getAttribute("webContentURL"));
	if(webContentURL.isEmpty() || webContentURL == "null") {
		webContentURL = "javascript:void(0)";
	}
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
				
				<li class="nav-item">
					<a href="<%=webContentURL%>" class="d-flex nav-link pl-3 <%=_active == "web_content" ? " active " : ""%>" target="_blank">
						<aui:icon cssClass="" image="cog" markupView="lexicon" />&nbsp;<span class="pl-2 text-truncate">Web Content</span>
					</a>
				</li>
				
                <li class="nav-item">
                    <a href="<%=premiURL%>" class="d-flex nav-link pl-3 <%= _active == "premi" ? " active " : "" %>">
                        <aui:icon cssClass="" image="list" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Premi</span>
                    </a>
                </li>							
			</ul>
		</li>

	</ul>
</nav>