<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	SmartActiveDisplayContext smartActiveDisplayContext = new SmartActiveDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
		
	//Search Container
	SearchContainer entriesSearchContainerFile = smartActiveDisplayContext.fileSearchContainer();

	// Management Toolbar Display Context
	SmartActiveManagementToolbarDisplayContext smartActiveManagementToolbarDisplayContext = new SmartActiveManagementToolbarDisplayContext(
					request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerFile);			

	PortletURL iteratorURL = smartActiveManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "fileSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "link";
				final String _editFileURL = editFileURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Link Files</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%= smartActiveDisplayContext._getOnSearch() ? "open" : "collapsed" %>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%= smartActiveManagementToolbarDisplayContext._getSearchActionURL() %>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="45">
									<aui:input label="Category" name="searchCategory" type="text" />
								</aui:col>
								
								<aui:col width="45">
									<aui:input label="Title" name="searchTitle" type="text" />
								</aui:col>
								
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%= fileURL %>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%= true %>"
					searchContainerId="fileSearchContainer"
					displayContext="<%= smartActiveManagementToolbarDisplayContext %>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportFileURL">
					<portlet:param name="exportFile"
						value="exportFile" />
				</portlet:resourceURL>

				<aui:form action="<%= exportFileURL %>" name="fmExport">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%= iteratorURL.toString() %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="file" type="hidden" />
				</aui:form>

				<aui:form action="<%= updateURL %>" name="fm">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= fileURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="file" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="fileSearchContainer"
						searchContainer="<%= entriesSearchContainerFile %>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.SmartActiveLink"
							modelVar="link" keyProperty="smartActiveLinkId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_active/link/edit.jsp" />
								<portlet:param name="linkId"
									value="<%= String.valueOf(link.getSmartActiveLinkId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = link.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartActiveLinkId"
								title="ID" name="ID" valign="middle"
								cssClass="<%= classInactive %>" href="<%= rowURL %>" />

							<liferay-ui:search-container-column-text property="category"
								title="Category" name="Category" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<liferay-ui:search-container-column-text property="title"
								title="Title" name="Title" valign="middle"
								cssClass="<%= classInactive %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/product/smart_active/link/action.jsp" />

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