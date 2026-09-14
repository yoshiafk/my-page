<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	PetDisplayContext petDisplayContext = new PetDisplayContext(liferayPortletRequest, liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerPet = petDisplayContext.rateSearchContainer();

	// Management Toolbar Display Context
	PetManagementToolbarDisplayContext petManagementToolbarDisplayContext = new PetManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerPet);

	PortletURL iteratorURL = petManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "petRateSearchContainer";
%>

<portlet:actionURL name="/pet/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "rate";
				final String _newRate = editRateURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Rate</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!-- COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=petDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search" action="<%=petManagementToolbarDisplayContext._getSearchActionURL()%>" method="post">
						<liferay-ui:panel-container extended="false" id="innerPanelContainer">
							<aui:row>
								<aui:col width="25">
									<aui:input label="Plan" name="searchPlan" type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:input label="Remarks" name="searchRemarks" type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:input label="Rate Percentage" name="searchRatePercentage"
										type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=rateURL%>" primary="true"
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
					searchContainerId="petRateSearchContainer"
					supportsBulkActions="<%=true%>" />
				<!-- MANAGEMENT TOOLBAR -->


				<portlet:resourceURL var="exportPetRateURL">
					<portlet:param name="exportPetRate" value="exportPetRate" />
				</portlet:resourceURL>

				<aui:form action="<%=exportPetRateURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="rate" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=rateURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="rate" />

					<liferay-ui:search-container id="petRateSearchContainer"
						searchContainer="<%=entriesSearchContainerPet%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.PetRate"
							modelVar="petRate" escapedModel="<% true %>"
							keyProperty="petRateId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/pet/rate/edit.jsp" />
								<portlet:param name="petRateId"
									value="<%= String.valueOf(petRate.getPetRateId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = petRate.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="petRateId"
								cssClass="<%=classInactive%>" title="ID" name="ID"
								href="<%=rowURL%>" />

							<%
							PetPlan _petPlan = PetPlanLocalServiceUtil.getPetPlan(petRate.getPetPlan());
							%>

							<liferay-ui:search-container-column-text
								cssClass="<%=classInactive%>" title="Pet Plan" name="Plan"
								value="<%= String.valueOf( _petPlan.getName() ) %>" />

							<%
							PetRemarks _petRemarks = PetRemarksLocalServiceUtil.getPetRemarks(petRate.getPetRemarks());
							%>

							<liferay-ui:search-container-column-text
								value="<%= String.valueOf( _petRemarks.getName() ) %>"
								cssClass="<%=classInactive%>" title="Pet Remarks" name="Remarks" />

							<liferay-ui:search-container-column-text property="rate"
								cssClass="<%=classInactive%>" title="Pet Rate" name="Rate" />

							<liferay-ui:search-container-column-jsp align="right"
								path="/product/pet/rate/rate_action.jsp" />
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