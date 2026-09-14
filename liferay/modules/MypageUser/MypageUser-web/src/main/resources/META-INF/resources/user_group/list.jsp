<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	UserGroupDisplayContext userGroupDisplayContext = new UserGroupDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerUserGroup = userGroupDisplayContext.userGroupSearchContainer();

	// Management Toolbar Display Context
	UserGroupManagementToolbarDisplayContext userGroupManagementToolbarDisplayContext = new UserGroupManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerUserGroup);

	PortletURL iteratorURL = userGroupManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "userGroupSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "user_group";
				final String _editUserGroupURL = editUserGroupURL;
			%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="tag" markupView="lexicon" />
						<span class="pl-2 text-truncate">User Group</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=userGroupDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=userGroupManagementToolbarDisplayContext._getSearchActionURL()%>"
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
									value="Reset" href="<%=userGroupURL%>" primary="true"
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
					searchContainerId="userGroupSearchContainer"
					displayContext="<%=userGroupManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportUserGroupURL">
					<portlet:param name="exportUserGroup"
						value="exportUserGroup" />
				</portlet:resourceURL>

				<aui:form action="<%=exportUserGroupURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="user_group" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=userGroupURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="user_group" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="userGroupSearchContainer"
						searchContainer="<%=entriesSearchContainerUserGroup%>">

						<liferay-ui:search-container-row
							className="com.mypage.user.model.MypageUserGroup"
							modelVar="userGroup" keyProperty="mypageUserGroupId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/user_group/edit.jsp" />
								<portlet:param name="mypageUserGroupId"
									value="<%=String.valueOf(userGroup.getMypageUserGroupId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = userGroup.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(userGroup.getMypageUserGroupId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="name"
								title="Name" name="Name" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/user_group/action.jsp" />

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