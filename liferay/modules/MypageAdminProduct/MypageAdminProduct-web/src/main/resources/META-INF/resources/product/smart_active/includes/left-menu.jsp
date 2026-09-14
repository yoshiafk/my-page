<nav class="menubar menubar-transparent menubar-vertical-expand-lg">
	<ul class="nav nav-nested">
		<li class="nav-item"><strong class="text-truncate text-uppercase">General </strong>
			<ul class="mb-2 nav nav-stacked">
				<li class="nav-item">
					<a href="<%= configurationURL %>" class="d-flex nav-link pl-3 <%=_active == "configuration" ? " active " : "" %>">
						<aui:icon cssClass="" image="cog" markupView="lexicon" /><span class="pl-2 text-truncate">Configuration</span>
					</a>
				</li>
				
				<li class="nav-item">
					<a href="<%= classRateURL %>" class="d-flex nav-link pl-3 <%= _active == "class_rate" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Class Rate</span>
					</a>
				</li>
				
				<li class="nav-item">
					<a href="<%= occupationURL %>" class="d-flex nav-link pl-3 <%= _active == "occupation" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Occupation</span>
					</a>
				</li>
				
				<li class="nav-item">
					<a href="<%= toproURL %>" class="d-flex nav-link pl-3 <%= _active == "topro" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Topro</span>
					</a>
				</li>
				
				<%-- <li class="nav-item">
					<a href="<%= toproBenefitMappingURL %>" class="d-flex nav-link pl-3 <%= _active == "topro_benefit_mapping" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Topro Benefit Mapping</span>
					</a>
				</li> --%>	
				
				<li class="nav-item">
					<a href="<%= premiURL %>" class="d-flex nav-link pl-3 <%= _active == "premi" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Premi</span>
					</a>
				</li>
				
				<li class="nav-item">
					<a href="<%= featureURL %>" class="d-flex nav-link pl-3 <%= _active == "feature" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Feature</span>
					</a>
				</li>
				
				<li class="nav-item">
					<a href="<%= fileURL %>" class="d-flex nav-link pl-3 <%= _active == "link" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Link Files</span>
					</a>
				</li>		
			</ul>
		</li>
		
		<li class="nav-item">
            <strong class="text-truncate text-uppercase">Benefit</strong>
            <ul class="mb-2 nav nav-stacked">
				<li class="nav-item">
					<a href="<%= benefitTypeURL %>" class="d-flex nav-link pl-3 <%= _active == "benefit_type" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Benefit Type</span>
					</a>
				</li>
				
				<li class="nav-item">
					<a href="<%= benefitURL %>" class="d-flex nav-link pl-3 <%= _active == "benefit" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Benefit</span>
					</a>
				</li>
				
				<li class="nav-item">
					<a href="<%= benefitValueURL %>" class="d-flex nav-link pl-3 <%= _active == "benefit_value" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Benefit Value</span>
					</a>
				</li>
				
				<li class="nav-item">
					<a href="<%= benefitValueMappingURL %>" class="d-flex nav-link pl-3 <%= _active == "benefit_value_mapping" ? " active " : "" %>">
						<aui:icon cssClass="" image="categories" markupView="lexicon" /><span class="pl-2 text-truncate">Benefit Value Mapping</span>
					</a>
				</li>
            </ul>
		</li>
	</ul>
</nav>