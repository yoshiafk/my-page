<%@ include file="../includes/init.jsp"%>

<%
	//Display Context 
	UserRegistrationDisplayContext userRegistrationDisplayContext = new UserRegistrationDisplayContext(
			liferayPortletRequest, liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainerUserRegistration = userRegistrationDisplayContext
			.userRegistrationSearchContainer();

	// Management Toolbar Display Context
	UserRegistrationManagementToolbarDisplayContext userRegistrationManagementToolbarDisplayContext = new UserRegistrationManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerUserRegistration);

	PortletURL iteratorURL = userRegistrationManagementToolbarDisplayContext._getCurrentSortingURL();
	
	// Variable to include in javascript
	String product = "mypageUserRegistrationSearchContainer";
%>

<portlet:actionURL name="/mypageuserregistration/update_data"
	var="updateURL" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
			<div class="sheet sheet-full">
				<aui:form name="search" action="#" method="post"></aui:form>


		<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%= userRegistrationDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=userRegistrationManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="50">
									<aui:input label="Full Name" name="searchFullName" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=userRegistrationURL%>" primary="true"
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
					searchContainerId="mypageUserRegistrationSearchContainer"
					displayContext="<%=userRegistrationManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportUserRegistrationURL">
					<portlet:param name="exportUserRegistration"
						value="exportUserRegistration" />
				</portlet:resourceURL>
				<aui:form action="<%=exportUserRegistrationURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="user" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=userRegistrationURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="user_registration" />
					
					<clay:container-fluid>
						<liferay-ui:search-container id="mypageUserRegistrationSearchContainer"
							searchContainer="<%=entriesSearchContainerUserRegistration%>">

							<liferay-ui:search-container-row
								className="com.mypage.user.model.UserRegistration"
								modelVar="userRegistration" escapedModel="<%=true%>"
								keyProperty="userRegistrationId">

								<portlet:renderURL var="rowURL">
									<portlet:param name="mvcPath"
										value="/user_registration/edit.jsp" />
									<portlet:param name="userRegistrationId"
										value="<%=String.valueOf(userRegistration.getUserRegistrationId())%>" />
								</portlet:renderURL>

								<%
									String inactive = userRegistration.getActive() != 1 ? "Inactive" : "Active";
								%>

								<liferay-ui:search-container-column-text
									cssClass="<%=inactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title"%>"
									name="ID"
									value="<%=String.valueOf(userRegistration.getUserRegistrationId())%>"
									href="<%=rowURL%>" />

								<liferay-ui:search-container-column-text
									cssClass="<%=inactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>"
									name="Full Name"
									value="<%=String.valueOf(userRegistration.getName())%>" />

								<liferay-ui:search-container-column-text
									cssClass="<%=inactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>"
									name="ID Number"
									value="<%=String.valueOf(userRegistration.getIdNumber())%>" />

								<liferay-ui:search-container-column-text
									cssClass="<%=inactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>"
									name="Email"
									value="<%=String.valueOf(userRegistration.getEmail())%>" />

								<liferay-ui:search-container-column-text
									cssClass="<%=inactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>"
									name="Mobile Phone Number"
									value="<%=String.valueOf(userRegistration.getMobilePhone())%>" />

								<liferay-ui:search-container-column-jsp name="Action"
									align="right" path="/user_registration/action.jsp" />

							</liferay-ui:search-container-row>

							<liferay-ui:search-iterator markupView="lexicon" />

						</liferay-ui:search-container>
					</clay:container-fluid>
				</aui:form>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/listScript.jsp" %>