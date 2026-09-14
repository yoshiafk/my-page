<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	InternationalTravelStandardNewDisplayContext smartTravelInternationalDisplayContext = new InternationalTravelStandardNewDisplayContext(liferayPortletRequest,
					liferayPortletResponse);

	//Search Container
	SearchContainer entriesSearchContainerPlan = smartTravelInternationalDisplayContext.planSearchContainer();

	// Management Toolbar Display Context
	InternationalTravelStandardNewManagementToolbarDisplayContext smartTravelInternationallManagementToolbarDisplayContext = new InternationalTravelStandardNewManagementToolbarDisplayContext(
					request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerPlan);	

	PortletURL iteratorURL = smartTravelInternationallManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "planSearchContainer";
	
	List<SmartTravelIntPlan> plans = SmartTravelIntPlanLocalServiceUtil.getActivePlan();
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "plan";
				final String _editPlanURL = editPlanURL;
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
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=smartTravelInternationalDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=smartTravelInternationallManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="45">
									<aui:input label="Name (Indonesia)" name="searchName" type="text" />
								</aui:col>
								
								<aui:col width="45">
									<aui:input label="Name (English)" name="searchNameEn" type="text" />
								</aui:col>
								
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=planURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="planSearchContainer"
					displayContext="<%=smartTravelInternationallManagementToolbarDisplayContext%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportPlanURL">
					<portlet:param name="exportPlan"
						value="exportPlan" />
				</portlet:resourceURL>

				<aui:form action="<%=exportPlanURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="plan" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=planURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="plan" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="planSearchContainer"
						searchContainer="<%=entriesSearchContainerPlan%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.SmartTravelIntPlan"
							modelVar="plan" keyProperty="smartTravelIntPlanId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/international_travel_standard_new/plan/edit.jsp" />
								<portlet:param name="planId"
									value="<%=String.valueOf(plan.getSmartTravelIntPlanId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = plan.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartTravelIntPlanId"
								title="ID" name="ID" valign="middle"
								cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="nameId"
								title="Name ID" name="Name (Indonesia)" valign="middle"
								cssClass="<%=classInactive%>" />
								
							<liferay-ui:search-container-column-text property="nameEn"
								title="Name English" name="Name (English)" valign="middle"
								cssClass="<%=classInactive%>" />
								
							<liferay-ui:search-container-column-text property="sort"
								title="Sort" name="Sort" valign="middle"
								cssClass="<%=classInactive%>" />
							

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/product/international_travel_standard_new/plan/action.jsp" />

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