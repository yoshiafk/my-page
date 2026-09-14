<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	SmartActiveDisplayContext smartActiveDisplayContext = new SmartActiveDisplayContext(liferayPortletRequest,liferayPortletResponse);
		
	//Search Container
	SearchContainer entriesSearchContainerToproBenefitMapping = smartActiveDisplayContext.toproBenefitMappingSearchContainer();

	// Management Toolbar Display Context
	SmartActiveManagementToolbarDisplayContext smartActiveManagementToolbarDisplayContext = new SmartActiveManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerToproBenefitMapping);			

	PortletURL iteratorURL = smartActiveManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "toproBenefitMappingSearchContainer";
	
	List<SmartActiveTopro> topros = SmartActiveToproLocalServiceUtil.getActiveTopro();
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "topro_benefit_mapping";
				final String _editBenefitURL = editToproBenefitMappingURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Topro Benefit Mapping</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3" defaultState="<%= smartActiveDisplayContext._getOnSearch() ? "open" : "collapsed" %>" extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search" action="<%= smartActiveManagementToolbarDisplayContext._getSearchActionURL() %>" method="post">
						<liferay-ui:panel-container extended="false" id="innerPanelContainer">
						<aui:row>
							<aui:col width="45">
								<aui:select label="Topro" name="searchTopro">
									<aui:option value="" disabled="true" selected="true">Select Topro</aui:option>
								    <% if (topros.size() > 0) {  %>
								    	<% for (int i = 0; i < topros.size(); i++) { 
								    		String toproName =  topros.get(i).getTopro();
								    	%>
								    		<aui:option value="<%= topros.get(i).getSmartActiveToproId() %>"><%= toproName %></aui:option>
								    	<% } %>
									<% } %>
								</aui:select>
							</aui:col>
								
						</aui:row>
						<aui:button-row>
							<aui:button name="search[search_button]" type="reset" value="Reset" href="<%= toproBenefitMappingURL %>" primary="true" icon="icon-repeat" />
							<aui:button name="search[search_button]" type="submit" value="Search" />
						</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
 				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%= true %>" searchContainerId="toproBenefitMappingSearchContainer" displayContext="<%= smartActiveManagementToolbarDisplayContext %>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportToproBenefitMappingURL">
					<portlet:param name="exportToproBenefitMapping" value="exportToproBenefitMapping" />
				</portlet:resourceURL>

				<aui:form action="<%= exportToproBenefitMappingURL %>" name="fmExport">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%= iteratorURL.toString() %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="toproBenefitMapping" type="hidden" />
				</aui:form>

				<aui:form action="<%= updateURL %>" name="fm">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= toproBenefitMappingURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="topro_benefit_mapping" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="toproBenefitMappingSearchContainer" searchContainer="<%= entriesSearchContainerToproBenefitMapping %>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.SmartActiveToproBenefitMapping" modelVar="toproBenefitMapping" keyProperty="smartActiveToproBenefitMappingId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_active/topro_benefit_mapping/edit.jsp" />
								<portlet:param name="toproBenefitMappingId"
									value="<%= String.valueOf(toproBenefitMapping.getSmartActiveToproBenefitMappingId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = toproBenefitMapping.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartActiveToproBenefitMappingId" title="ID" name="ID" valign="middle" cssClass="<%= classInactive %>" href="<%= rowURL %>" />

							<%
								SmartActiveTopro _topro = SmartActiveToproLocalServiceUtil.getSmartActiveTopro(toproBenefitMapping.getSmartActiveToproId());
							%>
							
							<liferay-ui:search-container-column-text value="<%= _topro.getTopro() %>" title="Topro" name="Topro" valign="middle" cssClass="<%= classInactive %>" />
							
							<liferay-ui:search-container-column-text property="listBenefitId" title="Benefit" name="Benefit" valign="middle" cssClass="<%= classInactive %>" />
							
							<liferay-ui:search-container-column-jsp name="Action" align="right" path="/product/smart_active/topro_benefit_mapping/action.jsp" />

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