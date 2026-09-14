<%@ include file="../includes/init.jsp"%>

<nav class="menubar menubar-transparent menubar-vertical-expand-lg">
	<ul class="nav nav-nested">
		<li class="nav-item">
			<a href="<%= creditTypeURL %>" class="d-flex nav-link pl-3 text-capitalize <%=_active.equals("creditType") ? " active " : ""%>">
				Credit Type
			</a>
		</li>
		
		<li class="nav-item">
			<a href="<%= creditWalletURL %>" class="d-flex nav-link pl-3 text-capitalize <%=_active.equals("creditWallet") ? " active " : ""%>">
				Credit Wallet
			</a>
		</li>
	</ul>
</nav>