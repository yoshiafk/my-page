<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	SalesToolsDisplayContext salesToolsDisplayContext = new SalesToolsDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerSalesTools = salesToolsDisplayContext.categorySalesToolsSearchContainer();

	// Management Toolbar Display Context
	SalesToolsManagementToolbarDisplayContext salesToolsManagementToolbarDisplayContext = new SalesToolsManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerSalesTools);

	PortletURL iteratorURL = salesToolsManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "categorySalesToolsSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "category";
				final String _editAgentCategorySalesToolsURL = editAgentCategorySalesToolsURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="tag" markupView="lexicon" />
						<span class="pl-2 text-truncate">Category</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=salesToolsDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=salesToolsManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="50">
									<aui:input label="Category" name="searchCategory" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=agentCategorySalesToolsURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!--  MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="categorySalesToolsSearchContainer"
					displayContext="<%=salesToolsManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportCategorySalesToolsURL">
					<portlet:param name="exportCategorySalesTools"
						value="exportCategorySalesTools" />
				</portlet:resourceURL>

				<aui:form action="<%=exportCategorySalesToolsURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="category" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=agentCategorySalesToolsURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="category" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="categorySalesToolsSearchContainer"
						searchContainer="<%=entriesSearchContainerSalesTools%>">

						<liferay-ui:search-container-row
							className="com.mypage.agencyportal.model.AgentCategorySalesTools"
							modelVar="agentCategorySalesTools" keyProperty="agentCategorySalesToolsId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/salestools/master/category/edit.jsp" />
								<portlet:param name="agentCategorySalesToolsId"
									value="<%=String.valueOf(agentCategorySalesTools.getAgentCategorySalesToolsId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = agentCategorySalesTools.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(agentCategorySalesTools.getAgentCategorySalesToolsId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="category"
								title="Category" name="Category" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/salestools/master/category/action.jsp" />

						</liferay-ui:search-container-row>
						<liferay-ui:search-iterator markupView="lexicon" />
					</liferay-ui:search-container>
					<!-- SEARCH CONTAINER -->
				</aui:form>
			</div>
		</div>

	</div>
</div>

<%@ include file="../includes/listScript.jsp"%>