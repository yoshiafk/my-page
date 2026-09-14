<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	SmartHealthDisplayContext smartHealthDisplayContext = new SmartHealthDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainer = smartHealthDisplayContext.benefitSearchContainer();
	
	SmartHealthManagementToolbarDisplayContext smartHealthManagementToolbarDisplayContext = new SmartHealthManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainer);
	PortletURL iteratorURL = smartHealthManagementToolbarDisplayContext._getCurrentSortingURL();
	
	// Variable to include in javascript
	String product = "smartHealthBenefitSearchContainer";
%>

<portlet:actionURL name="/smart_health/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />
<liferay-ui:success key="dataStatusChanged" message="data-status-changed" />

<div class="container-fluid container-fluid-max-xl container-view MypageAdminProduct-web">
	<div class="row">
		<div class="col-lg-3">
			<% String _active = "benefit"; %>
			<%@ include file="../includes/left-menu.jsp"%> 
		</div
		
		<!-- BODY -->
		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Benefit</span>
					</div>
				</h2>
				
				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3" defaultState="<%=smartHealthDisplayContext._getOnSearch() ? "open" : "collapsed"%>" extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search" action="<%=smartHealthManagementToolbarDisplayContext._getSearchActionURL()%>" method="post">
						<liferay-ui:panel-container extended="false" id="innerPanelContainer">
							<aui:row>
								<aui:col width="25">
									<aui:input label="Title" name="searchTitle" type="text" />
								</aui:col>
							</aui:row>
							
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset" value="Reset" href="<%=benefitURL%>" primary="true" icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit" value="Search" icon="icon-search" />
							</aui:button-row>

						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->				

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar displayContext="<%=smartHealthManagementToolbarDisplayContext%>"
					searchContainerId="smartHealthBenefitSearchContainer" supportsBulkActions="<%=true%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=benefitURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="benefit" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="smartHealthBenefitSearchContainer"
						searchContainer="<%=entriesSearchContainer%>">

						<liferay-ui:search-container-row className="com.mypage.admin.product.model.SmartHealthBenefit"
							modelVar="smartHealthBenefit" escapedModel="<% true %>" keyProperty="smartHealthBenefitId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_health/benefit/edit.jsp" />
								<portlet:param name="smartHealthBenefitId"
									value="<%= String.valueOf(smartHealthBenefit.getSmartHealthBenefitId()) %>" />
							</portlet:renderURL>


							<%
								String classInactive = smartHealthBenefit.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartHealthBenefitId"
								cssClass="<%=classInactive%>" title="ID" name="ID" valign="middle" href="<%=rowURL%>" />
								
							<liferay-ui:search-container-column-text property="benefitTitle" cssClass="<%=classInactive%>" title="Benefit Title" name="Title" valign="middle" />
							<liferay-ui:search-container-column-text property="benefitContent" cssClass="<%=classInactive%>" title="Benefit Content" name="Content" valign="middle" />
							
							<liferay-ui:search-container-column-jsp align="right" path="/product/smart_health/benefit/action.jsp" />
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