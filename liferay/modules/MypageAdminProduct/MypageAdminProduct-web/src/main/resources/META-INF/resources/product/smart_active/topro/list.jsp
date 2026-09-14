<%@ include file="../includes/init.jsp"%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>

<%
	// Display Context
	SmartActiveDisplayContext smartActiveDisplayContext = new SmartActiveDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
		
	//Search Container
	SearchContainer entriesSearchContainerTopro = smartActiveDisplayContext.toproSearchContainer();

	// Management Toolbar Display Context
	SmartActiveManagementToolbarDisplayContext smartActiveManagementToolbarDisplayContext = new SmartActiveManagementToolbarDisplayContext(
					request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerTopro);			

	PortletURL iteratorURL = smartActiveManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "toproSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "topro";
				final String _editToproURL = editToproURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Topro</span>
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
									<aui:input label="Topro" name="searchTopro" type="text" />
								</aui:col>
								
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%= toproURL %>" primary="true"
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
					searchContainerId="toproSearchContainer"
					displayContext="<%= smartActiveManagementToolbarDisplayContext %>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportToproURL">
					<portlet:param name="exportTopro"
						value="exportTopro" />
				</portlet:resourceURL>

				<aui:form action="<%= exportToproURL %>" name="fmExport">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%= iteratorURL.toString() %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="topro" type="hidden" />
				</aui:form>

				<aui:form action="<%= updateURL %>" name="fm">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= toproURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="topro" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="toproSearchContainer"
						searchContainer="<%= entriesSearchContainerTopro %>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.SmartActiveTopro"
							modelVar="topro" keyProperty="smartActiveToproId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_active/topro/edit.jsp" />
								<portlet:param name="toproId"
									value="<%= String.valueOf(topro.getSmartActiveToproId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = topro.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartActiveToproId"
								title="ID" name="ID" valign="middle"
								cssClass="<%= classInactive %>" href="<%= rowURL %>" />
								
							<liferay-ui:search-container-column-text property="topro"
								title="Topro" name="Topro" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<liferay-ui:search-container-column-text property="description"
								title="Description" name="Description" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<liferay-ui:search-container-column-text property="annotations"
								title="Annotations" name="Annotations" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<liferay-ui:search-container-column-text property="toc"
								title="TOC" name="TOC" valign="middle"
								cssClass="<%= classInactive %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/product/smart_active/topro/action.jsp" />

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