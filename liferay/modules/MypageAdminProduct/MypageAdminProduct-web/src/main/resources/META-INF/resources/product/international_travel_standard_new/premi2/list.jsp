<%@ include file="../includes/init.jsp"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.DecimalFormat" %>

<%
	// Display Context
	InternationalTravelStandardNewDisplayContext smartTravelInternationalDisplayContext = new InternationalTravelStandardNewDisplayContext(liferayPortletRequest,
					liferayPortletResponse);
			
	//Search Container
	SearchContainer entriesSearchContainerPremi = smartTravelInternationalDisplayContext.premiSearchContainer2();
			
	// Management Toolbar Display Context
	InternationalTravelStandardNewManagementToolbarDisplayContext smartTravelInternationallManagementToolbarDisplayContext = new InternationalTravelStandardNewManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerPremi);

	PortletURL iteratorURL = smartTravelInternationallManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "premiSearchContainer";
	
	List<Benefit> benefits = BenefitLocalServiceUtil.getActiveBenefit();
	
	List<SmartTravelIntPlan> plans = SmartTravelIntPlanLocalServiceUtil.getActivePlan();
	
%>


<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "premi";
				final String _editPremiURL = editPremiURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Premi</span>
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
									<aui:input label="Traveller Type" name="searchTravellerType" type="text" />
								</aui:col>
								
								<aui:col width="45">
									<aui:select label="Benefit" name="searchBenefit">
										<aui:option value="" disabled="true" selected="true">Select Benefit</aui:option>
									    <% if (benefits.size() > 0) {  %>
									    	<% for (int i = 0; i < benefits.size(); i++) { 
									    		String benefitName =  benefits.get(i).getNameId();
											    if (benefitName == null || benefitName.isEmpty()) {
											    	benefitName = benefits.get(i).getNameEn();
											    }
									    	%>
									    		<aui:option value="<%= benefits.get(i).getBenefitId() %>"><%= benefitName %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
								
								<aui:col width="45">
									<aui:select label="Plan" name="searchPlan">
										<aui:option value="" disabled="true" selected="true">Select Plan</aui:option>
									    <% if (plans.size() > 0) {  %>
									    	<% for (int i = 0; i < plans.size(); i++) { 
									    		String planName =  plans.get(i).getNameId();
											    if (planName == null || planName.isEmpty()) {
											    	planName = plans.get(i).getNameEn();
											    }
									    	%>
									    		<aui:option value="<%= plans.get(i).getSmartTravelIntPlanId() %>"><%= planName %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
								
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=premiURL%>" primary="true"
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
					searchContainerId="premiSearchContainer"
					displayContext="<%=smartTravelInternationallManagementToolbarDisplayContext%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportPremiURL">
					<portlet:param name="exportPremi"
						value="exportPremi" />
				</portlet:resourceURL>

				<aui:form action="<%=exportPremiURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="premi" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=premiURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="premi" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="premiSearchContainer" searchContainer="<%=entriesSearchContainerPremi%>">

						<liferay-ui:search-container-row className="com.mypage.admin.product.model.Premi" modelVar="premi" keyProperty="premiId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/international_travel_standard_new/premi2/edit.jsp" />
								<portlet:param name="premiId"
									value="<%=String.valueOf(premi.getPremiId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = premi.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="premiId"
								title="ID" name="ID" valign="middle"
								cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="travellerType"
								title="Traveller Type" name="Traveller Type" valign="middle"
								cssClass="<%=classInactive%>" />
								
							<liferay-ui:search-container-column-text property="currency" title="Currency" name="Currency" valign="middle" cssClass="<%=classInactive%>" />
							
							
							<%
							DecimalFormat df = new DecimalFormat("#.##");
							String basicFormattedValue = df.format(premi.getBasic());
							String additionalFormattedValue = df.format(premi.getAdditional());
							String annualFormattedValue = df.format(premi.getAnnual());
							%>
							<liferay-ui:search-container-column-text title="Basic" name="Basic" valign="middle" cssClass="<%=classInactive%>" value="<%=basicFormattedValue%>" />
							<liferay-ui:search-container-column-text title="Additional" name="Additional" valign="middle" cssClass="<%=classInactive%>" value="<%=additionalFormattedValue%>" />
							
							<liferay-ui:search-container-column-text title="Annual" name="Annual" valign="middle" cssClass="<%=classInactive%>" value="<%=annualFormattedValue%>" />
								
							<% 

								Benefit benefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
								String benefitName = benefit.getNameId();
							    if (benefitName == null || benefitName.isEmpty()) {
							        benefitName = benefit.getNameEn();
							    }
							    
							    SmartTravelIntPlan plan = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(premi.getPlanId());
								String planName = plan.getNameId();
							    if (planName == null || planName.isEmpty()) {
							    	planName = plan.getNameEn();
							    }
							    
							%>	
							<liferay-ui:search-container-column-text value="<%= benefitName %>"
								title="Benefit" name="Benefit" valign="middle"
								cssClass="<%=classInactive%>" />
							
							<liferay-ui:search-container-column-text value="<%= planName %>"
								title="Plan" name="Plan" valign="middle"
								cssClass="<%=classInactive%>" />
							

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/product/international_travel_standard_new/premi2/action.jsp" />

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