<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerBlacklistCustomer = masterDisplayContext
			.blacklistCustomerSearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerBlacklistCustomer);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "blacklistCustomerSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "blacklist_customer";
				final String _editBlacklistCustomerURL = editBlacklistCustomerURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="users" markupView="lexicon" />
						<span class="pl-2 text-truncate">Blacklist Customer</span>
					</div>
				</h2>
				<!-- TITLE -->

				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=masterDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=masterManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:input name="onSearch" value="active" type="hidden" />
							<aui:row>
								<aui:col width="25">
									<aui:input label="Full Name" name="searchFullName" type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:input label="First Name" name="searchFirstName"
										type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:input label="Middle Name" name="searchMiddleName"
										type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:input label="Last Name" name="searchLastName" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=blacklistCustomerURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="blacklistCustomerSearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportBlacklistCustomerURL">
					<portlet:param name="exportBlacklistCustomer"
						value="exportBlacklistCustomer" />
				</portlet:resourceURL>

				<aui:form action="<%=exportBlacklistCustomerURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="blacklist_customer" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=blacklistCustomerURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="blacklist_customer" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="blacklistCustomerSearchContainer"
						searchContainer="<%=entriesSearchContainerBlacklistCustomer%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.BlacklistCustomer"
							modelVar="blacklistCustomer" keyProperty="blacklistCustomerId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath"
									value="/master/blacklist_customer/edit.jsp" />
								<portlet:param name="blacklistCustomerId"
									value="<%=String.valueOf(blacklistCustomer.getBlacklistCustomerId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = blacklistCustomer.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text
								property="blacklistCustomerId" title="ID" name="ID"
								valign="middle" cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="fullName"
								title="Full Name" name="Full Name" valign="middle"
								cssClass="<%=classInactive%>" />

							<liferay-ui:search-container-column-text property="firstName"
								title="First Name" name="First Name" valign="middle"
								cssClass="<%=classInactive%>" />

							<liferay-ui:search-container-column-text property="middleName"
								title="Middle Name" name="Middle Name" valign="middle"
								cssClass="<%=classInactive%>" />

							<liferay-ui:search-container-column-text property="lastName"
								title="Last Name" name="Last Name" valign="middle"
								cssClass="<%=classInactive%>" />

							<%
								SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
											String currentRowDob = sdf.format(blacklistCustomer.getDateOfBirth());
							%>

							<liferay-ui:search-container-column-text title="Date of Birth"
								name="Date of Birth" valign="middle" value="<%=currentRowDob%>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/blacklist_customer/action.jsp" />

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