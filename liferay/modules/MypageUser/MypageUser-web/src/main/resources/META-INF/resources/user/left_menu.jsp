<nav class="menubar menubar-transparent menubar-vertical-expand-lg">
	<ul class="nav nav-nested">
		<%
			// variable di ini di variables.jsp
			// karena dipake di tempat lain juga
			///////////////////////////////////
			if(pages.length > 0) {
				for(int i = 0; i < pages.length; i++) {
					if(!allowAdd && Arrays.stream(onlyAdmin).anyMatch(pages[i]::equals)) continue;
		%>
			<portlet:renderURL var="accountURL">
				<portlet:param name="mvcPath" value="/user/edit.jsp" />
				<portlet:param name="pageKey" value="<%= pages[i] %>" />
				<portlet:param name="mypageUserId" value="<%= String.valueOf(mypageUserId) %>" />
			</portlet:renderURL>
			
			<li class="nav-item">
				<a href="<%= accountURL %>" class="d-flex nav-link pl-3 text-capitalize <%= pageKey.equals(pages[i]) ? "active" : "" %>">
					<%= pages[i].replace("_", " ") %>
				</a>
			</li>
		<%
				}
			}
		%>
	</ul>
</nav>