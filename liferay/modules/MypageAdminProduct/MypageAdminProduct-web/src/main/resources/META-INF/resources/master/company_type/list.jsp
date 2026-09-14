<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainer = masterDisplayContext.companyTypeSearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainer);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "companyTypeSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "company_type";
				final String _editCompanyTypeURL = editCompanyTypeURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">Company Type</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=masterDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=masterManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="50">
									<aui:input label="Name" name="searchName" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=companyTypeURL%>" primary="true"
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
					searchContainerId="companyTypeSearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportCompanyTypeURL">
					<portlet:param name="exportCompanyType" value="exportCompanyType" />
				</portlet:resourceURL>

				<aui:form action="<%=exportCompanyTypeURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="company_type" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=companyTypeURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="company_type" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="companyTypeSearchContainer"
						searchContainer="<%=entriesSearchContainer%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.CompanyType"
							modelVar="companyType" keyProperty="companyTypeId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath"
									value="/master/company_type/edit.jsp" />
								<portlet:param name="companyTypeId"
									value="<%=String.valueOf(companyType.getCompanyTypeId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = companyType.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text
								cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title"%>"
								name="ID"
								value="<%=String.valueOf(companyType.getCompanyTypeId())%>"
								href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="name"
								title="Name" name="Name" valign="middle"
								cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>" />

							<liferay-ui:search-container-column-text property="label"
								title="Label" name="Label" valign="middle"
								cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/company_type/action.jsp" />

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

