<%@ include file="../../includes/init.jsp"%>

<%
	// Display Context
	UserCreditDisplayContext userCreditDisplayContext = new UserCreditDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainer = userCreditDisplayContext.creditWalletConfigurationSearchContainer();

	String p_u_i_d = ParamUtil.getString(request, "p_u_i_d");
	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectcreditWallet");
	String syncEntitiesEventName = ParamUtil.getString(request, "syncEntitiesEventName", liferayPortletResponse.getNamespace() + "syncProductConfigurations");
	String getLiferayUserId = ParamUtil.getString(request, "liferayUserId", "");
	
	User selUser = PortalUtil.getSelectedUser(request);
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/user_credit/credit_wallet/select_credit_wallet.jsp");
	if(getLiferayUserId != "") {		
		portletURL.setParameter("liferayUserId", getLiferayUserId);
	}
	
	if (selUser != null) {
		portletURL.setParameter("p_u_i_d", String.valueOf(selUser.getUserId()));
	}
	portletURL.setParameter("eventName", eventName);
%>

<!--  MANAGEMENT TOOLBAR -->
<clay:management-toolbar supportsBulkActions="<%=true%>"
	searchContainerId="creditWalletSearchContainer"
	selectable="<%= false %>"
	searchActionURL="<%= portletURL.toString() %>"
	clearResultsURL="<%= portletURL.toString() %>"
	itemsTotal="<%= entriesSearchContainer.getTotal() %>"
/>
<!--  MANAGEMENT TOOLBAR -->

<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="selectcreditWalletFm">
	<liferay-ui:search-container
		headerNames="name"
		id="creditWalletSearchContainer"
		searchContainer="<%= entriesSearchContainer %>"
	>
		<liferay-ui:search-container-row
			className="com.mypage.user.model.CreditWallet"
			keyProperty="creditWalletId"
			modelVar="creditWallet"
		>
			<liferay-ui:search-container-column-text
				name="CreditWalletId"
				value="<%= String.valueOf(creditWallet.getCreditWalletId()) %>"
			/>
		
			<liferay-ui:search-container-column-text
				name="Amount"
				value="<%= String.valueOf(creditWallet.getAmount()) %>"
			/>
			
			<liferay-ui:search-container-column-text>
				<c:if test="<%= Validator.isNull(p_u_i_d) %>">

					<%
						Map<String, Object> data = new HashMap<String, Object>();
	
						data.put("entityid", creditWallet.getCreditWalletId());
						data.put("entityname", creditWallet.getCreditWalletId());
						data.put("searchcontainername", "creditWallets");
						
						//long[] creditWallets = ParamUtil.getLongValues(request, "creditWallets", userCreditDisplayContext.getProductIds());
						//boolean disabled = ArrayUtil.contains(creditWallets, creditWallet.getcreditWalletId());
						boolean disabled = false;
					%>

					<aui:button cssClass="selector-button" data="<%= data %>" disabled="<%= disabled %>" value="choose" />
				</c:if>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	var Util = Liferay.Util;

	var openingLiferay = Util.getOpener().Liferay;

	openingLiferay.fire(
		'<%= HtmlUtil.escape(syncEntitiesEventName) %>',
		{
			selectors: A.all('.selector-button:disabled')
		}
	);

	Util.selectEntityHandler('#<portlet:namespace />selectCreditWalletFm', '<%= HtmlUtil.escapeJS(eventName) %>');
</aui:script>