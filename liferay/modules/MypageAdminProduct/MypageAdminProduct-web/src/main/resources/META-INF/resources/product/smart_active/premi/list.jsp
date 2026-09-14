<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	SmartActiveDisplayContext smartActiveDisplayContext = new SmartActiveDisplayContext(liferayPortletRequest,
					liferayPortletResponse);
			
	//Search Container
	SearchContainer entriesSearchContainerPremi = smartActiveDisplayContext.premiSearchContainer();
			
	// Management Toolbar Display Context
	SmartActiveManagementToolbarDisplayContext smartActiveManagementToolbarDisplayContext = new SmartActiveManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerPremi);

	PortletURL iteratorURL = smartActiveManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "premiSearchContainer";
	
	List<SmartActiveBenefit> benefits = SmartActiveBenefitLocalServiceUtil.getActiveBenefit();
	List<SmartActiveClassRate> classRates = SmartActiveClassRateLocalServiceUtil.getActiveClassRate();
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
			<%@ include file="../includes/left-menu.jsp" %>
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
					defaultState="<%= smartActiveDisplayContext._getOnSearch() ? "open" : "collapsed" %>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%= smartActiveManagementToolbarDisplayContext._getSearchActionURL() %>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
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
									    		<aui:option value="<%= benefits.get(i).getSmartActiveBenefitId() %>"><%= benefitName %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
								
								<aui:col width="45">
									<aui:select label="Class Rate" name="searchClassRate">
										<aui:option value="" disabled="true" selected="true">Select Class Rate</aui:option>
									    <% if (classRates.size() > 0) {  %>
									    	<% for (int i = 0; i < classRates.size(); i++) { 
									    		String classRateName =  classRates.get(i).getNameId();
											    if (classRateName == null || classRateName.isEmpty()) {
											    	classRateName = classRates.get(i).getNameEn();
											    }
									    	%>
									    		<aui:option value="<%= classRates.get(i).getSmartActiveClassRateId() %>"><%= classRateName %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
							</aui:row>
							
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%= premiURL %>" primary="true"
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
					searchContainerId="premiSearchContainer"
					displayContext="<%= smartActiveManagementToolbarDisplayContext %>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportPremiURL">
					<portlet:param name="exportPremi"
						value="exportPremi" />
				</portlet:resourceURL>

				<aui:form action="<%= exportPremiURL %>" name="fmExport">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%= iteratorURL.toString() %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="premi" type="hidden" />
				</aui:form>

				<aui:form action="<%= updateURL %>" name="fm">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= premiURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="premi" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="premiSearchContainer" searchContainer="<%= entriesSearchContainerPremi %>">

						<liferay-ui:search-container-row className="com.mypage.admin.product.model.SmartActivePremi" modelVar="premi" keyProperty="smartActivePremiId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_active/premi/edit.jsp" />
								<portlet:param name="premiId"
									value="<%= String.valueOf(premi.getSmartActivePremiId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = premi.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartActivePremiId"
								title="ID" name="ID" valign="middle"
								cssClass="<%= classInactive %>" href="<%= rowURL %>" />
							
							<liferay-ui:search-container-column-text title="Rate" name="Rate" valign="middle" cssClass="<%= classInactive %>" value="<%= String.valueOf(premi.getRate()) %>" />
								
							<%
								SmartActiveBenefit benefit = SmartActiveBenefitLocalServiceUtil.getSmartActiveBenefit(premi.getSmartActiveBenefitId());
								String benefitName = benefit.getNameId();
							    if (benefitName == null || benefitName.isEmpty()) {
							        benefitName = benefit.getNameEn();
							    }
							%>	
							<liferay-ui:search-container-column-text value="<%= benefitName %>"
								title="Benefit" name="Benefit" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<%
								SmartActiveClassRate classRate = SmartActiveClassRateLocalServiceUtil.getSmartActiveClassRate(premi.getSmartActiveClassRateId());
								String classRateName = classRate.getNameId();
							    if (classRateName == null || classRateName.isEmpty()) {
							        classRateName = classRate.getNameEn();
							    }
							%>	
							<liferay-ui:search-container-column-text value="<%= classRateName %>"
								title="Class Rate" name="Class Rate" valign="middle"
								cssClass="<%= classInactive %>" />
							

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/product/smart_active/premi/action.jsp" />

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