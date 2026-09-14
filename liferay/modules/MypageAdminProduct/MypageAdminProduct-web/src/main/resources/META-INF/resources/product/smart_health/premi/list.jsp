<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	SmartHealthDisplayContext smartHealthDisplayContext = new SmartHealthDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainer = smartHealthDisplayContext.premiSearchContainer();
	
	SmartHealthManagementToolbarDisplayContext smartHealthManagementToolbarDisplayContext = new SmartHealthManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainer);
	PortletURL iteratorURL = smartHealthManagementToolbarDisplayContext._getCurrentSortingURL();
	
	// Variable to include in javascript
	String product = "smartHealthPremiSearchContainer";
%>

<portlet:actionURL name="/smart_health/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />
<liferay-ui:success key="dataStatusChanged" message="data-status-changed" />

<div class="container-fluid container-fluid-max-xl container-view MypageAdminProduct-web">
	<div class="row">
		<div class="col-lg-3">
			<% String _active = "premi"; %>
			<%@ include file="../includes/left-menu.jsp"%> 
		</div
		
		<!-- BODY -->
		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Premi</span>
					</div>
				</h2>
				
				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3" defaultState="<%=smartHealthDisplayContext._getOnSearch() ? "open" : "collapsed"%>" extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search" action="<%=smartHealthManagementToolbarDisplayContext._getSearchActionURL()%>" method="post">
						<liferay-ui:panel-container extended="false" id="innerPanelContainer">
							<aui:row>
								<aui:col width="25">
									<aui:input label="Age" name="searchAge" type="number" />
								</aui:col>
							
								<aui:col width="25">
									<aui:select name="searchGender" label="Gender">
									<aui:option label="All" value=""></aui:option>
									<aui:option label="Male" value="male"></aui:option>
									<aui:option label="Female" value="female"></aui:option>
									</aui:select>
								</aui:col>
								
								<aui:col width="25">
									<aui:select name="searchCurrency" label="Currency">
									<aui:option label="IDR" value="idr"></aui:option>
									<aui:option label="USD" value="usd"></aui:option>
									</aui:select>
								</aui:col>								
							</aui:row>							
							
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset" value="Reset" href="<%=premiURL%>" primary="true" icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit" value="Search" icon="icon-search" />
							</aui:button-row>

						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->				

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar displayContext="<%=smartHealthManagementToolbarDisplayContext%>"
					searchContainerId="smartHealthPremiSearchContainer" supportsBulkActions="<%=true%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=premiURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="premi" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="smartHealthPremiSearchContainer"
						searchContainer="<%=entriesSearchContainer%>">

						<liferay-ui:search-container-row className="com.mypage.admin.product.model.SmartHealthPremi"
							modelVar="smartHealthPremi" escapedModel="<% true %>" keyProperty="smartHealthPremiId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_health/premi/edit.jsp" />
								<portlet:param name="smartHealthPremiId"
									value="<%= String.valueOf(smartHealthPremi.getSmartHealthPremiId()) %>" />
							</portlet:renderURL>


							<%
								String classInactive = smartHealthPremi.getStatus() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartHealthPremiId"
								cssClass="<%=classInactive%>" title="ID" name="ID" valign="middle" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="age" cssClass="<%=classInactive%>" title="Age" name="Age" valign="middle" />
							
							<liferay-ui:search-container-column-jsp align="right" path="/product/smart_health/premi/action.jsp" />
						</liferay-ui:search-container-row>

						<liferay-ui:search-iterator markupView="lexicon" />

					</liferay-ui:search-container>
					<!-- SEARCH CONTAINER -->
				</aui:form>
			</div>
		</div>
	</div>
</div>

<%@ include file="../includes/javascript/module_script.jsp"%>