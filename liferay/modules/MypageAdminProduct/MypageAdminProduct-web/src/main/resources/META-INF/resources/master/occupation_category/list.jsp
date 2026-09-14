<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest, liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerOccupationCategory = masterDisplayContext.occupationCategorySearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerOccupationCategory);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "masterOccupationCategorySearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "occupationCategory";
				final String _editOccupationCategoryURL = editOccupationCategoryURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">OccupationCategory</span>
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
								<aui:col width="100">
									<aui:input label="Name" name="searchName" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=occupationCategoryURL%>" primary="true"
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
					searchContainerId="masterOccupationCategorySearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportMasterOccupationCategoryURL">
					<portlet:param name="exportMasterOccupationCategory"
						value="exportMasterOccupationCategory" />
				</portlet:resourceURL>

				<aui:form action="<%=exportMasterOccupationCategoryURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="occupationCategory" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=occupationCategoryURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="occupationCategory" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="masterOccupationCategorySearchContainer"
						searchContainer="<%=entriesSearchContainerOccupationCategory%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.MasterOccupationCategory"
							modelVar="masterOccupationCategory" keyProperty="masterOccupationCategoryId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/occupation_category/edit.jsp" />
								<portlet:param name="masterOccupationCategoryId"
									value="<%=String.valueOf(masterOccupationCategory.getMasterOccupationCategoryId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = masterOccupationCategory.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="masterOccupationCategoryId"
								title="ID" name="ID" valign="middle"
								cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title"%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="name"
								title="Name" name="Name" valign="middle"
								cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/occupation_category/action.jsp" />

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