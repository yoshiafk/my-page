<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	PetDisplayContext petDisplayContext = new PetDisplayContext(liferayPortletRequest, liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerPet = petDisplayContext.planSearchContainer();

	// Management Toolbar Display Context
	PetManagementToolbarDisplayContext petManagementToolbarDisplayContext = new PetManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerPet);

	PortletURL iteratorURL = petManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "petPlanSearchContainer";
%>

<portlet:actionURL name="/pet/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />
<liferay-ui:success key="dataStatusChanged" message="data-status-changed" />

<portlet:resourceURL var="exportPetPlanURL">
	<portlet:param name="exportPetPlan" value="exportPetPlan" />
</portlet:resourceURL>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "plan";
				final String _newPlan = editPlanURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Plan</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3" defaultState="<%=petDisplayContext._getOnSearch() ? "open" : "collapsed"%>" extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search" action="<%=petManagementToolbarDisplayContext._getSearchActionURL()%>" method="post">
						<liferay-ui:panel-container extended="false" id="innerPanelContainer">
							<aui:row>
								<aui:col width="25">
									<aui:input label="Name" name="searchName" type="text" />
								</aui:col>

								<aui:col width="25">
									<aui:select label="Recommended" name="searchRecommended" showEmptyOption="true">
										<aui:option value="yes">Yes</aui:option>
										<aui:option value="no">No</aui:option>
									</aui:select>
								</aui:col>

								<aui:col width="25">
									<aui:select label="Custom" name="searchCustomPlan" showEmptyOption="true">
										<aui:option value="yes">Yes</aui:option>
										<aui:option value="no">No</aui:option>
									</aui:select>
								</aui:col>

							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=planURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" icon="icon-search" />
							</aui:button-row>

						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar
					displayContext="<%=petManagementToolbarDisplayContext%>" searchContainerId="petPlanSearchContainer" supportsBulkActions="<%=true%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<aui:form action="<%=exportPetPlanURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="plan" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=planURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="plan" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="petPlanSearchContainer" searchContainer="<%=entriesSearchContainerPet%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.PetPlan" modelVar="petPlan" escapedModel="<% true %>" keyProperty="petPlanId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/pet/plan/edit.jsp" />
								<portlet:param name="petPlanId" value="<%= String.valueOf(petPlan.getPetPlanId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = petPlan.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="petPlanId"
								cssClass="<%=classInactive%>" title="ID" name="ID"
								valign="middle" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="name"
								cssClass="<%=classInactive%>" title="Name" name="Name"
								valign="middle" />

							<liferay-ui:search-container-column-text
								cssClass="<%=classInactive%>" property="limitDisability"
								title="Limit Disability" name="Limit Disability" />

							<liferay-ui:search-container-column-text property="limitMedical"
								cssClass="<%=classInactive%>" title="Limit Medical"
								name="Limit Medical" />

							<liferay-ui:search-container-column-text
								cssClass="<%=classInactive%>" property="limitThirdParty"
								title="Limit Third Party" name="Limit Third Party" />

							<liferay-ui:search-container-column-text property="limitCustody"
								cssClass="<%=classInactive%>" title="Limit Custody"
								name="Limit Custody" />

							<liferay-ui:search-container-column-jsp
								path="/product/pet/plan/recommended_row_template.jsp"
								name="Recommended" align="center" />

							<liferay-ui:search-container-column-jsp
								path="/product/pet/plan/customplan_row_template.jsp"
								name="Custom Plan" align="center" />

							<liferay-ui:search-container-column-jsp align="right"
								path="/product/pet/plan/plan_action.jsp" />
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





