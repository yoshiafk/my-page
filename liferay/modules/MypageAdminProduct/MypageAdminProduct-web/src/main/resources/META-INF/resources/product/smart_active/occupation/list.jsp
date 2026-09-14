<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	SmartActiveDisplayContext smartActiveDisplayContext = new SmartActiveDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
		
	//Search Container
	SearchContainer entriesSearchContainerOccupation = smartActiveDisplayContext.occupationSearchContainer();

	// Management Toolbar Display Context
	SmartActiveManagementToolbarDisplayContext smartActiveManagementToolbarDisplayContext = new SmartActiveManagementToolbarDisplayContext(
					request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerOccupation);			

	PortletURL iteratorURL = smartActiveManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "occupationSearchContainer";
	
	List<SmartActiveClassRate> classRates = SmartActiveClassRateLocalServiceUtil.getActiveClassRate();
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "occupation";
				final String _editOccupationURL = editOccupationURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Occupation</span>
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
									<aui:input label="Name (Indonesia)" name="searchName" type="text" />
								</aui:col>
								
								<aui:col width="45">
									<aui:input label="Name (English)" name="searchNameEn" type="text" />
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
									value="Reset" href="<%= occupationURL %>" primary="true"
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
					searchContainerId="occupationSearchContainer"
					displayContext="<%= smartActiveManagementToolbarDisplayContext %>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportOccupationURL">
					<portlet:param name="exportOccupation"
						value="exportOccupation" />
				</portlet:resourceURL>

				<aui:form action="<%= exportOccupationURL %>" name="fmExport">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%= iteratorURL.toString() %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="occupation" type="hidden" />
				</aui:form>

				<aui:form action="<%= updateURL %>" name="fm">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= occupationURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="occupation" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="occupationSearchContainer"
						searchContainer="<%= entriesSearchContainerOccupation %>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.SmartActiveOccupation"
							modelVar="occupation" keyProperty="smartActiveOccupationId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_active/occupation/edit.jsp" />
								<portlet:param name="occupationId"
									value="<%= String.valueOf(occupation.getSmartActiveOccupationId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = occupation.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartActiveOccupationId"
								title="ID" name="ID" valign="middle"
								cssClass="<%= classInactive %>" href="<%= rowURL %>" />
								
							<liferay-ui:search-container-column-text property="code"
								title="Code" name="Code" valign="middle"
								cssClass="<%= classInactive %>" />

							<liferay-ui:search-container-column-text property="nameId"
								title="Name ID" name="Name (Indonesia)" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<liferay-ui:search-container-column-text property="nameEn"
								title="Name English" name="Name (English)" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<% 
								SmartActiveClassRate classRate = SmartActiveClassRateLocalServiceUtil.getSmartActiveClassRate(occupation.getSmartActiveClassRateId());
							
							    String classRateName = classRate.getNameId();
							    if (classRateName == null || classRateName.isEmpty()) {
							    	classRateName = classRate.getNameEn();
							    }
							%>
								
							<liferay-ui:search-container-column-text value="<%= classRateName %>"
								title="Class Rate" name="Class Rate" valign="middle"
								cssClass="<%= classInactive %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/product/smart_active/occupation/action.jsp" />

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