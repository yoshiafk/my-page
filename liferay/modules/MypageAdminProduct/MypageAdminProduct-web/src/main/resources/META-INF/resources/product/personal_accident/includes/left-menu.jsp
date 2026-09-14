<nav class="menubar menubar-transparent menubar-vertical-expand-lg">
    <ul class="nav nav-nested">
        <li class="nav-item">
            <strong class="text-truncate text-uppercase">General</strong>
            <ul class="mb-2 nav nav-stacked">
                <li class="nav-item">
                    <a href="<%=configurationURL%>" class="d-flex nav-link pl-3 <%= _active == "configuration" ? " active " : "" %>">
                        <aui:icon cssClass="" image="cog" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Configuration</span>
                    </a>
                </li>
                
                <li class="nav-item">
                    <a href="<%=webContentURL%>" target="_blank" class="d-flex nav-link pl-3 <%= _active == "web_content" ? " active " : "" %>">
                        <aui:icon cssClass="" image="cog" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Web Content</span>
                    </a>
                </li>
                
                <li class="nav-item">
                    <%-- <a href="<%=planURL%>" class="d-flex nav-link pl-3 <%= _active == "plan" ? " active " : "" %>">
                        <aui:icon cssClass="" image="categories" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Plan</span>
                    </a> --%>
                </li>
                
                <li class="nav-item">
                    <a href="<%=premiURL%>" class="d-flex nav-link pl-3 <%= _active == "premi" ? " active " : "" %>">
                        <aui:icon cssClass="" image="categories" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Premi</span>
                    </a>
                </li>                
            </ul>
        </li>
        
        <!--  PLAN AND PREMI -->
        <%-- <li class="nav-item">
            <strong class="text-truncate text-uppercase">Benefit</strong>
            <ul class="mb-2 nav nav-stacked">
            
                <li class="nav-item">
                    <a href="<%=benefitGroupURL%>" class="d-flex nav-link pl-3 <%= _active == "benefit_group" ? " active " : "" %>">
                        <aui:icon cssClass="" image="categories" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Benefit Group</span>
                    </a>
                </li> 
                            
                <li class="nav-item">
                    <a href="<%=benefitURL%>" class="d-flex nav-link pl-3 <%= _active == "benefit" ? " active " : "" %>">
                        <aui:icon cssClass="" image="categories" markupView="lexicon" />
                        <span class="pl-2 text-truncate">Benefit</span>
                    </a>
                </li>
                               
            </ul>
        </li> --%>
    </ul>
</nav>