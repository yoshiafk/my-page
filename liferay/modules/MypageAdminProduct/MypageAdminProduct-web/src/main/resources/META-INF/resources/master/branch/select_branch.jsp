<%@ include file="../includes/init.jsp"%>

<%
//Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest, liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerBranch = masterDisplayContext.branchSearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerBranch);
	
	String p_u_i_d = ParamUtil.getString(request, "p_u_i_d");
	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectMasterBranch");
	String syncEntitiesEventName = ParamUtil.getString(request, "syncEntitiesEventName", liferayPortletResponse.getNamespace() + "syncMasterBranchs");
	
	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/master/branch/select_branch.jsp");
	portletURL.setParameter("eventName", eventName);

	// Variable to include in javascript
	String product = "masterBranchSearchContainer";
%>

<!--  MANAGEMENT TOOLBAR -->
<clay:management-toolbar supportsBulkActions="<%=true%>"
	searchContainerId="masterBranchSearchContainer"
	selectable="<%= false %>"
	searchActionURL="<%= portletURL.toString() %>"
	clearResultsURL="<%= portletURL.toString() %>"
	itemsTotal="<%= entriesSearchContainerBranch.getTotal() %>"
/>
<!--  MANAGEMENT TOOLBAR -->

<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="selectMasterBranchFm">
	<!-- SEARCH CONTAINER -->
	<liferay-ui:search-container id="masterBranchSearchContainer"
		searchContainer="<%=entriesSearchContainerBranch%>">

		<liferay-ui:search-container-row
			className="com.mypage.admin.product.model.MasterBranch"
			modelVar="masterBranch" keyProperty="masterBranchId">

			<%
				String classInactive = masterBranch.getActive() != 1 ? "status-inactive" : "status-active";
			%>

			<liferay-ui:search-container-column-text property="masterBranchId"
				title="ID" name="ID" valign="middle"
				cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>" />

			<liferay-ui:search-container-column-text property="name"
				title="Name" name="Name" valign="middle"
				cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>" />
			
			<liferay-ui:search-container-column-text>
				<c:if test="<%= Validator.isNull(p_u_i_d) %>">

					<%
						Map<String, Object> data = new HashMap<String, Object>();
		
						data.put("entityid", masterBranch.getMasterBranchId());
						data.put("entityname", masterBranch.getName());
						data.put("searchcontainername", "masterBranchs");
						
						long[] productIds = ParamUtil.getLongValues(request, "productIds");
						boolean disabled = ArrayUtil.contains(productIds, masterBranch.getMasterBranchId());
					%>

					<aui:button cssClass="selector-button" data="<%= data %>" disabled="<%= disabled %>" value="choose" />
				</c:if>
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
	<!-- SEARCH CONTAINER -->
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

	Util.selectEntityHandler('#<portlet:namespace />selectMasterBranchFm', '<%= HtmlUtil.escapeJS(eventName) %>');
</aui:script>