<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	UserRoleDisplayContext userRoleDisplayContext = new UserRoleDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerUserRole = userRoleDisplayContext.userRoleSearchContainer();

	// Management Toolbar Display Context
	UserRoleManagementToolbarDisplayContext userRoleManagementToolbarDisplayContext = new UserRoleManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerUserRole);

	PortletURL iteratorURL = userRoleManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "userRoleSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "user_role";
				final String _editUserRoleURL = editUserRoleURL;
			%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="tag" markupView="lexicon" />
						<span class="pl-2 text-truncate">User Role</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=userRoleDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=userRoleManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="50">
									<aui:input label="Name" name="searchName" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=userRoleURL%>" primary="true"
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
					searchContainerId="userRoleSearchContainer"
					displayContext="<%=userRoleManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportUserRoleURL">
					<portlet:param name="exportUserRole"
						value="exportUserRole" />
				</portlet:resourceURL>

				<aui:form action="<%=exportUserRoleURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="user_role" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=userRoleURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="user_role" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="userRoleSearchContainer"
						searchContainer="<%=entriesSearchContainerUserRole%>">

						<liferay-ui:search-container-row
							className="com.mypage.user.model.MypageUserRole"
							modelVar="userRole" keyProperty="mypageUserRoleId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/user_role/edit.jsp" />
								<portlet:param name="mypageUserRoleId"
									value="<%=String.valueOf(userRole.getMypageUserRoleId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = userRole.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(userRole.getMypageUserRoleId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="name"
								title="Name" name="Name" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/user_role/action.jsp" />

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