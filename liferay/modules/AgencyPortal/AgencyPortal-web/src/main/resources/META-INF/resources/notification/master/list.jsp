<%@ include file="includes/init.jsp"%>

<%
	// Display Context
	NotificationDisplayContext notificationDisplayContext = new NotificationDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerNotification = notificationDisplayContext.notificationSearchContainer();

	// Management Toolbar Display Context
	NotificationManagementToolbarDisplayContext notificationManagementToolbarDisplayContext = new NotificationManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerNotification);

	PortletURL iteratorURL = notificationManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "notificationSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "notification";
				final String _editAgentNotificationURL = editAgentNotificationURL;
			%>

			<%@ include file="includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="tag" markupView="lexicon" />
						<span class="pl-2 text-truncate">Notification</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=notificationDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=notificationManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="50">
									<aui:input label="Title" name="searchTitle" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=agentNotificationURL%>" primary="true"
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
					searchContainerId="notificationSearchContainer"
					displayContext="<%=notificationManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportNotificationURL">
					<portlet:param name="exportNotification"
						value="exportNotification" />
				</portlet:resourceURL>

				<aui:form action="<%=exportNotificationURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="notification" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=agentNotificationURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="notification" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="notificationSearchContainer"
						searchContainer="<%=entriesSearchContainerNotification%>">

						<liferay-ui:search-container-row
							className="com.mypage.agencyportal.model.AgentNotification"
							modelVar="agentNotification" keyProperty="agentNotificationId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/notification/master/edit.jsp" />
								<portlet:param name="agentNotificationId"
									value="<%=String.valueOf(agentNotification.getAgentNotificationId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = agentNotification.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(agentNotification.getAgentNotificationId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="title"
								title="Title" name="Title" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<liferay-ui:search-container-column-text property="category"
								title="Category" name="Category" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/notification/master/action.jsp" />

						</liferay-ui:search-container-row>
						<liferay-ui:search-iterator markupView="lexicon" />
					</liferay-ui:search-container>
					<!-- SEARCH CONTAINER -->
				</aui:form>
			</div>
		</div>

	</div>
</div>

<%@ include file="includes/listScript.jsp"%>