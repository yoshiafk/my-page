<%@ include file="../../includes/init.jsp"%>

<%
	// Display Context
	UserCreditDisplayContext userCreditDisplayContext = new UserCreditDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainer = userCreditDisplayContext.creditTypeConfigurationSearchContainer();

	String p_u_i_d = ParamUtil.getString(request, "p_u_i_d");
	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectCreditType");
	String syncEntitiesEventName = ParamUtil.getString(request, "syncEntitiesEventName", liferayPortletResponse.getNamespace() + "syncProductConfigurations");
	String getLiferayUserId = ParamUtil.getString(request, "liferayUserId", "");
	
	User selUser = PortalUtil.getSelectedUser(request);
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/user_credit/credit_type/select_credit_type.jsp");
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
	searchContainerId="creditTypeSearchContainer"
	selectable="<%= false %>"
	searchActionURL="<%= portletURL.toString() %>"
	clearResultsURL="<%= portletURL.toString() %>"
	itemsTotal="<%= entriesSearchContainer.getTotal() %>"
/>
<!--  MANAGEMENT TOOLBAR -->

<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="selectCreditTypeFm">
	<liferay-ui:search-container
		headerNames="name"
		id="creditTypeSearchContainer"
		searchContainer="<%= entriesSearchContainer %>"
	>
		<liferay-ui:search-container-row
			className="com.mypage.user.model.CreditType"
			keyProperty="creditTypeId"
			modelVar="creditType"
		>
			<liferay-ui:search-container-column-text
				name="Name"
				value="<%= HtmlUtil.escape(creditType.getName()) %>"
			/>
			
			<liferay-ui:search-container-column-text
				name="Agent Type"
				value="<%= HtmlUtil.escape(creditType.getAgentType()) %>"
			/>
			
			<liferay-ui:search-container-column-text>
				<c:if test="<%= Validator.isNull(p_u_i_d) %>">

					<%
						Map<String, Object> data = new HashMap<String, Object>();
	
						data.put("entityid", creditType.getCreditTypeId());
						data.put("entityname", creditType.getName());
						data.put("searchcontainername", "creditTypes");
						
						//long[] creditTypes = ParamUtil.getLongValues(request, "creditTypes", userCreditDisplayContext.getProductIds());
						//boolean disabled = ArrayUtil.contains(creditTypes, creditType.getCreditTypeId());
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

	Util.selectEntityHandler('#<portlet:namespace />selectCreditTypeFm', '<%= HtmlUtil.escapeJS(eventName) %>');
</aui:script>