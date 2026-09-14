<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	InternationalTravelStandardNewDisplayContext smartTravelInternationalDisplayContext = new InternationalTravelStandardNewDisplayContext(liferayPortletRequest,liferayPortletResponse);
		
	//Search Container
	SearchContainer entriesSearchContainerBenefitValueMapping = smartTravelInternationalDisplayContext.benefitValueMappingSearchContainer();

	// Management Toolbar Display Context
	InternationalTravelStandardNewManagementToolbarDisplayContext smartTravelInternationallManagementToolbarDisplayContext = new InternationalTravelStandardNewManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerBenefitValueMapping);			

	PortletURL iteratorURL = smartTravelInternationallManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "benefitValueMappingSearchContainer";
	
	List<BenefitType> benefitTypes = BenefitTypeLocalServiceUtil.getActiveBenefitType();
	List<Benefit> benefits = BenefitLocalServiceUtil.getBenefits();
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "benefit_value_mapping";
				final String _editBenefitURL = editBenefitValueMappingURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Benefit Value Mapping</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3" defaultState="<%=smartTravelInternationalDisplayContext._getOnSearch() ? "open" : "collapsed"%>" extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search" action="<%=smartTravelInternationallManagementToolbarDisplayContext._getSearchActionURL()%>" method="post">
						<liferay-ui:panel-container extended="false" id="innerPanelContainer">
						<aui:row>
								<aui:col width="45">
									<aui:select label="Benefit Type" name="searchBenefitType">
										<aui:option value="" disabled="true" selected="true">Select Type</aui:option>
									    <% if (benefitTypes.size() > 0) {  %>
									    	<% for (int i = 0; i < benefitTypes.size(); i++) { 
									    		String benefitTypeName =  benefitTypes.get(i).getNameId();
									    	%>
									    		<aui:option value="<%= benefitTypes.get(i).getBenefitTypeId() %>"><%= benefitTypeName %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
								
																<aui:col width="45">
									<aui:select label="Benefit Name" name="searchBenefitName">
										<aui:option value="" disabled="true" selected="true">Select Benefit Name</aui:option>
									    <% if (benefits.size() > 0) {  %>
									    	<% for (int i = 0; i < benefits.size(); i++) { 
									    		String benefitName =  benefits.get(i).getNameId();
									    	%>
									    		<aui:option value="<%= benefits.get(i).getBenefitId() %>"><%= benefitName %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
								
								</aui:row>
															<aui:button-row>
								<aui:button name="search[search_button]" type="reset" value="Reset" href="<%=benefitValueMappingURL%>" primary="true" icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit" value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
 				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>" searchContainerId="benefitValueMappingSearchContainer" displayContext="<%=smartTravelInternationallManagementToolbarDisplayContext%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportBenefitURL">
					<portlet:param name="exportBenefit" value="exportBenefit" />
				</portlet:resourceURL>

				<aui:form action="<%=exportBenefitURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="benefit" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=benefitValueMappingURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="benefit" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="benefitValueMappingSearchContainer" searchContainer="<%=entriesSearchContainerBenefitValueMapping%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.BenefitValueMapping" modelVar="benefitValueMapping" keyProperty="benefitValueMappingId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit_value_mapping/edit.jsp" />
								<portlet:param name="benefitValueMappingId"
									value="<%=String.valueOf(benefitValueMapping.getBenefitValueMappingId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = benefitValueMapping.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="benefitValueMappingId" title="ID" name="ID" valign="middle" cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<%
							BenefitType _benefitType = BenefitTypeLocalServiceUtil.getBenefitType(benefitValueMapping.getBenefitTypeId());
							%>
							<liferay-ui:search-container-column-text value="<%= _benefitType.getNameId() %>" title="Benefit Type" name="Benefit Type" valign="middle" cssClass="<%=classInactive%>" />
							
														<%
							Benefit _benefit = BenefitLocalServiceUtil.getBenefit(benefitValueMapping.getBenefitId());
							%>
								
							<liferay-ui:search-container-column-text value="<%= _benefit.getNameId() %>" title="Benefit Name" name="Benefit Name" valign="middle" cssClass="<%=classInactive%>" />
							
																					<%
																					SmartTravelIntPlan _plan = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(benefitValueMapping.getPlanId());
							%>
							
							<liferay-ui:search-container-column-text value="<%= _plan.getNameId() %>" title="Plan Name" name="Plan Name" valign="middle" cssClass="<%=classInactive%>" />
							
							<liferay-ui:search-container-column-text property="benefitValue" title="Benefit Value" name="Benefit Value" valign="middle" cssClass="<%=classInactive%>" />
							
<%-- 							<liferay-ui:search-container-column-jsp name="Action" align="right" path="/product/international_travel_standard_new/benefit/action.jsp" /> --%>

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