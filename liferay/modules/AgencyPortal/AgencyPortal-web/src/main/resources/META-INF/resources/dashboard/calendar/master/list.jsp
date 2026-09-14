<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	CalendarDisplayContext calendarDisplayContext = new CalendarDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerCalendar = calendarDisplayContext.calendarSearchContainer();

	// Management Toolbar Display Context
	CalendarManagementToolbarDisplayContext calendarManagementToolbarDisplayContext = new CalendarManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerCalendar);

	PortletURL iteratorURL = calendarManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "calendarSearchContainer";
	
	List<MypageUserRole> mypageUserRole = MypageUserRoleLocalServiceUtil.getActiveRole();
	List<MypageUserGroup> mypageUserGroup = MypageUserGroupLocalServiceUtil.getActiveGroup();
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "calendar";
				final String _editAgentCalendarURL = editAgentCalendarURL;
			%>
			
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="tag" markupView="lexicon" />
						<span class="pl-2 text-truncate">Event</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=calendarDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=calendarManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="25">
									<aui:input label="Title" name="searchTitle" type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:input label="Location" name="searchLocation" type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:select label="User Role" name="searchUserRole">
										<aui:option value="">Select Role</aui:option>
									    <% if (mypageUserRole.size() > 0) {  %>
									    	<% for (int i = 0; i < mypageUserRole.size(); i++) { %>
									    		<aui:option value="<%= mypageUserRole.get(i).getName() %>"><%= mypageUserRole.get(i).getName() %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
								<aui:col width="25">
									<aui:select label="User Group" name="searchUserGroup">
										<aui:option value="">Select Group</aui:option>
									    <% if (mypageUserGroup.size() > 0) {  %>
									    	<% for (int i = 0; i < mypageUserGroup.size(); i++) { %>
									    		<aui:option value="<%= mypageUserGroup.get(i).getName() %>"><%= mypageUserGroup.get(i).getName() %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col width="50">
									<aui:input label="Start Date" name="searchStartDate" type="date">
										<aui:validator name="custom" errorMessage="Start date must be before End date">
											function (val, fieldNode, ruleValue) {
												var endDate = $('#<portlet:namespace />searchEndDate').val();
												var startDateObj = new Date(val);
       											var endDateObj = new Date(endDate);
												
												if (!isNaN(endDateObj.getTime())) {
													if (startDateObj > endDateObj) {
														return false;
													}
												}
												
												return true;
											}
										</aui:validator>
									</aui:input>
								</aui:col>
								<aui:col width="50">
									<aui:input label="End Date" name="searchEndDate" type="date">
										<aui:validator name="custom" errorMessage="End date must be after Start date">
											function (val, fieldNode, ruleValue) {
												var startDate = $('#<portlet:namespace />searchStartDate').val();
												var startDateObj = new Date(startDate);
       											var endDateObj = new Date(val);
												
												if (!isNaN(startDateObj.getTime())) {
													if (startDateObj > endDateObj) {
														return false;
													}
												}
												
												return true;
											}
										</aui:validator>
									</aui:input>
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=agentCalendarURL%>" primary="true"
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
					searchContainerId="calendarSearchContainer"
					displayContext="<%=calendarManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportCalendarURL">
					<portlet:param name="exportCalendar"
						value="exportCalendar" />
				</portlet:resourceURL>

				<aui:form action="<%=exportCalendarURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="calendar" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=agentCalendarURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="calendar" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="calendarSearchContainer"
						searchContainer="<%=entriesSearchContainerCalendar%>">

						<liferay-ui:search-container-row
							className="com.mypage.agencyportal.model.AgentCalendar"
							modelVar="agentCalendar" keyProperty="agentCalendarId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/dashboard/calendar/master/edit.jsp" />
								<portlet:param name="agentCalendarId"
									value="<%=String.valueOf(agentCalendar.getAgentCalendarId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = agentCalendar.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(agentCalendar.getAgentCalendarId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="title"
								title="Title" name="Title" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text property="location"
								title="Location" name="Location" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text property="role"
								title="User Role" name="User Role" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text property="group"
								title="User Group" name="User Group" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<%
								AgentCalendar calendarRow = (AgentCalendar) row.getObject();
						        Date startDt = (Date) calendarRow.getStartDate();
						        Date endDt = (Date) calendarRow.getEndDate();
						        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(startDt);
						        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(endDt);
						    %>
								
							<liferay-ui:search-container-column-text value="<%= startDate %>"
								title="Start Date" name="Start Date" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text value="<%= endDate %>"
								title="End Date" name="End Date" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/dashboard/calendar/master/action.jsp" />

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