<%@ include file="../includes/init.jsp"%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>

<%
	// Display Context
	SmartActiveDisplayContext smartActiveDisplayContext = new SmartActiveDisplayContext(liferayPortletRequest,liferayPortletResponse);
		
	//Search Container
	SearchContainer entriesSearchContainerBenefitValueMapping = smartActiveDisplayContext.benefitValueMappingSearchContainer();

	// Management Toolbar Display Context
	SmartActiveManagementToolbarDisplayContext smartActiveManagementToolbarDisplayContext = new SmartActiveManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerBenefitValueMapping);			

	PortletURL iteratorURL = smartActiveManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "benefitValueMappingSearchContainer";
	
	List<SmartActiveBenefitType> benefitTypes = SmartActiveBenefitTypeLocalServiceUtil.getActiveBenefitType();
	List<SmartActiveBenefit> benefits = SmartActiveBenefitLocalServiceUtil.getActiveBenefit();
	List<SmartActiveBenefitValue> benefitValues = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue();
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
				
				Locale idnLocale = new Locale("in", "ID");
				NumberFormat idnFormat = NumberFormat.getCurrencyInstance(idnLocale);
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
				<liferay-ui:panel collapsible="true" cssClass="p-3" defaultState="<%= smartActiveDisplayContext._getOnSearch() ? "open" : "collapsed" %>" extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search" action="<%= smartActiveManagementToolbarDisplayContext._getSearchActionURL() %>" method="post">
						<liferay-ui:panel-container extended="false" id="innerPanelContainer">
						<aui:row>
							<aui:col width="45">
								<aui:select label="Benefit Type" name="searchBenefitType">
									<aui:option value="" disabled="true" selected="true">Select Type</aui:option>
								    <% if (benefitTypes.size() > 0) {  %>
								    	<% for (int i = 0; i < benefitTypes.size(); i++) { 
								    		String benefitTypeName =  benefitTypes.get(i).getNameId();
								    	%>
								    		<aui:option value="<%= benefitTypes.get(i).getSmartActiveBenefitTypeId() %>"><%= benefitTypeName %></aui:option>
								    	<% } %>
									<% } %>
								</aui:select>
							</aui:col>
							
							<aui:col width="45">
								<aui:select label="Benefit" name="searchBenefit">
									<aui:option value="" disabled="true" selected="true">Select Benefit</aui:option>
								    <% if (benefits.size() > 0) {  %>
								    	<% for (int i = 0; i < benefits.size(); i++) { 
								    		String benefitName =  benefits.get(i).getNameId();
								    	%>
								    		<aui:option value="<%= benefits.get(i).getSmartActiveBenefitId() %>"><%= benefitName %></aui:option>
								    	<% } %>
									<% } %>
								</aui:select>
							</aui:col>
							
							<aui:col width="45">
								<aui:select label="Benefit Value" name="searchBenefitValue">
									<aui:option value="" disabled="true" selected="true">Select Benefit</aui:option>
								    <% if (benefitValues.size() > 0) {  %>
								    	<% for (int i = 0; i < benefitValues.size(); i++) { 
								    		String benefitName = idnFormat.format(benefitValues.get(i).getValue());
								    	%>
								    		<aui:option value="<%= benefitValues.get(i).getSmartActiveBenefitValueId() %>"><%= benefitName %></aui:option>
								    	<% } %>
									<% } %>
								</aui:select>
							</aui:col>
								
						</aui:row>
						<aui:button-row>
							<aui:button name="search[search_button]" type="reset" value="Reset" href="<%= benefitValueMappingURL %>" primary="true" icon="icon-repeat" />
							<aui:button name="search[search_button]" type="submit" value="Search" />
						</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
 				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%= true %>" searchContainerId="benefitValueMappingSearchContainer" displayContext="<%= smartActiveManagementToolbarDisplayContext %>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportBenefitURL">
					<portlet:param name="exportBenefit" value="exportBenefit" />
				</portlet:resourceURL>

				<aui:form action="<%= exportBenefitURL %>" name="fmExport">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%= iteratorURL.toString() %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="benefit" type="hidden" />
				</aui:form>

				<aui:form action="<%= updateURL %>" name="fm">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= benefitValueMappingURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="benefit_value_mapping" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="benefitValueMappingSearchContainer" searchContainer="<%= entriesSearchContainerBenefitValueMapping %>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.SmartActiveBenefitValueMapping" modelVar="benefitValueMapping" keyProperty="smartActiveBenefitValueMappingId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_active/benefit_value_mapping/edit.jsp" />
								<portlet:param name="benefitValueMappingId"
									value="<%= String.valueOf(benefitValueMapping.getSmartActiveBenefitValueMappingId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = benefitValueMapping.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartActiveBenefitValueMappingId" title="ID" name="ID" valign="middle" cssClass="<%= classInactive %>" href="<%= rowURL %>" />

							<%
								SmartActiveBenefitType _benefitType = SmartActiveBenefitTypeLocalServiceUtil.getSmartActiveBenefitType(benefitValueMapping.getSmartActiveBenefitTypeId());
							%>
							
							<liferay-ui:search-container-column-text value="<%= _benefitType.getNameId() %>" title="Benefit Type" name="Benefit Type" valign="middle" cssClass="<%= classInactive %>" />
							
							<%
								SmartActiveBenefit _benefit = SmartActiveBenefitLocalServiceUtil.getSmartActiveBenefit(benefitValueMapping.getSmartActiveBenefitId());
							%>
								
							<liferay-ui:search-container-column-text value="<%= _benefit.getNameId() %>" title="Benefit Name" name="Benefit Name" valign="middle" cssClass="<%= classInactive %>" />
							
							<%
								SmartActiveBenefitValue _benefitValue = SmartActiveBenefitValueLocalServiceUtil.getSmartActiveBenefitValue(benefitValueMapping.getSmartActiveBenefitValueId());
							%>
								
							<liferay-ui:search-container-column-text value="<%= idnFormat.format(_benefitValue.getValue()) %>" title="Benefit Value" name="Benefit Value" valign="middle" cssClass="<%= classInactive %>" />
							
							<liferay-ui:search-container-column-text property="value" title="Value" name="Value" valign="middle" cssClass="<%= classInactive %>" />
							
							<%
							String asd = idnFormat.format(benefitValueMapping.getLimitValue());
							%>
							
							<liferay-ui:search-container-column-text value="<%= asd %>" title="Limit Value" name="Limit Value" valign="middle" cssClass="<%= classInactive %>" />
							
							<liferay-ui:search-container-column-jsp name="Action" align="right" path="/product/smart_active/benefit_value_mapping/action.jsp" />

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