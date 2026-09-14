<%
	String webContentURL = String.valueOf(renderRequest.getAttribute("webContentURL"));
	if(webContentURL.isEmpty() || webContentURL == "null") {
		webContentURL = "javascript:void(0)";
	}
%>

<nav class="menubar menubar-transparent menubar-vertical-expand-lg">
	<ul class="nav nav-nested">
		<li class="nav-item"><strong class="text-truncate text-uppercase">
				General </strong>
			<ul class="mb-2 nav nav-stacked">

				<li class="nav-item"><a href="<%=configurationURL%>"
					class="d-flex nav-link pl-3 <%=_active == "configuration" ? " active " : ""%>">
						<aui:icon cssClass="" image="cog" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Configuration</span>
				</a></li>
				
				<li class="nav-item"><a href="<%=webContentURL%>" class="d-flex nav-link pl-3 <%=_active == "web_content" ? " active " : ""%>" target="_blank">
						<aui:icon cssClass="" image="cog" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Web Content</span>
				</a></li>				

				<li class="nav-item"><a href="<%=planURL%>"
					class="d-flex nav-link pl-3 <%=_active == "plan" ? " active " : ""%>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Plan</span>
				</a></li>

				<li class="nav-item"><a href="<%=remarksURL%>"
					class="d-flex nav-link pl-3 <%=_active == "remarks" ? " active " : ""%>">
						<aui:icon cssClass="" image="product-menu" markupView="lexicon" />
						<span class="pl-2 text-truncate">Remarks</span>
				</a></li>

				<li class="nav-item"><a href="<%=rateURL%>"
					class="d-flex nav-link pl-3 <%=_active == "rate" ? " active " : ""%>">
						<aui:icon cssClass="" image="product-menu" markupView="lexicon" />
						<span class="pl-2 text-truncate">Rate</span>
				</a></li>
				
				<li class="nav-item"><a href="<%=animalTypeURL%>"
					class="d-flex nav-link pl-3 <%=_active == "animalType" ? " active " : ""%>">
						<aui:icon cssClass="" image="product-menu" markupView="lexicon" />
						<span class="pl-2 text-truncate">Animal Type</span>
				</a></li>
			</ul></li>

	</ul>
</nav>