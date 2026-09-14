<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	PetDisplayContext petDisplayContext = new PetDisplayContext(liferayPortletRequest, liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerRemarks = petDisplayContext.remarksSearchContainer();

	// Management Toolbar Display Context
	PetManagementToolbarDisplayContext petManagementToolbarDisplayContext = new PetManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerRemarks);

	PortletURL iteratorURL = petManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "petRemarksSearchContainer";
%>

<portlet:actionURL name="/pet/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />


<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "remarks";
				final String _newRemarks = editRemarksURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Remarks</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!-- COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=petDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=petManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="25">
									<aui:input label="Remarks Name" name="searchName" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=remarksURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!-- COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar
					displayContext="<%=petManagementToolbarDisplayContext%>"
					supportsBulkActions="<%=true%>"
					searchContainerId="petRemarksSearchContainer" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportPetRemarksURL">
					<portlet:param name="exportPetRemarks" value="exportPetRemarks" />
				</portlet:resourceURL>

				<aui:form action="<%=exportPetRemarksURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="remarks" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=remarksURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="remarks" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="petRemarksSearchContainer"
						searchContainer="<%=entriesSearchContainerRemarks%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.PetRemarks"
							modelVar="petRemarks" escapedModel="<% true %>"
							keyProperty="petRemarksId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath"
									value="/product/pet/remarks/edit.jsp" />
								<portlet:param name="petRemarksId"
									value="<%= String.valueOf(petRemarks.getPetRemarksId()) %>" />
							</portlet:renderURL>

							<%
									String classInactive = petRemarks.getActive() != 1 ? "status-inactive" : "status-active";
								%>

							<liferay-ui:search-container-column-text property="petRemarksId"
								cssClass="<%=classInactive%>" title="ID" name="ID" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="name"
								cssClass="<%=classInactive%>" title="Name" name="Name" />

							<liferay-ui:search-container-column-jsp align="right"
								path="/product/pet/remarks/remarks_action.jsp" />
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