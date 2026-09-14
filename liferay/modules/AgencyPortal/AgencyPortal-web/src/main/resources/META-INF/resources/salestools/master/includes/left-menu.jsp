<nav class="menubar menubar-transparent menubar-vertical-expand-lg">
	<ul class="nav nav-nested">
		<li class="nav-item"><strong class="text-truncate text-uppercase">
				Master </strong>
			<ul class="mb-2 nav nav-stacked">

				<li class="nav-item"><a href="<%=agentSalesToolsURL%>"
					class="d-flex nav-link pl-3 <%=_active == "sales_tools" ? " active " : ""%>">
						<aui:icon cssClass="" image="tag" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Sales Tools</span>
				</a></li>
				<li class="nav-item"><a href="<%=agentCategorySalesToolsURL%>"
					class="d-flex nav-link pl-3 <%=_active == "category" ? " active " : ""%>">
						<aui:icon cssClass="" image="tag" markupView="lexicon" /> <span
						class="pl-2 text-truncate">Category</span>
				</a></li>

			</ul></li>

	</ul>
</nav>