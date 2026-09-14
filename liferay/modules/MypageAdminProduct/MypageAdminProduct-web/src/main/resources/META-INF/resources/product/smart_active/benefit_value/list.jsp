<%@ include file="../includes/init.jsp"%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>

<%
	// Display Context
	SmartActiveDisplayContext smartActiveDisplayContext = new SmartActiveDisplayContext(liferayPortletRequest,liferayPortletResponse);
		
	//Search Container
	SearchContainer entriesSearchContainerBenefitValue = smartActiveDisplayContext.benefitValueSearchContainer();

	// Management Toolbar Display Context
	SmartActiveManagementToolbarDisplayContext smartActiveManagementToolbarDisplayContext = new SmartActiveManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerBenefitValue);			

	PortletURL iteratorURL = smartActiveManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "benefitValueSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "benefit_value";
				final String _editBenefitURL = editBenefitValueURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Benefit Value</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3" defaultState="<%= smartActiveDisplayContext._getOnSearch() ? "open" : "collapsed" %>" extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search" action="<%= smartActiveManagementToolbarDisplayContext._getSearchActionURL() %>" method="post">
						<liferay-ui:panel-container extended="false" id="innerPanelContainer">
						<aui:row>
							<aui:col width="45">
								<aui:input label="Value" name="searchValue" type="number" />
							</aui:col>
								
						</aui:row>
						<aui:button-row>
							<aui:button name="search[search_button]" type="reset" value="Reset" href="<%= benefitValueURL %>" primary="true" icon="icon-repeat" />
							<aui:button name="search[search_button]" type="submit" value="Search" />
						</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
 				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%= true %>" searchContainerId="benefitValueSearchContainer" displayContext="<%= smartActiveManagementToolbarDisplayContext %>" />
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
					<aui:input name="redirect" type="hidden" value="<%= benefitValueURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="benefit_value" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="benefitValueSearchContainer" searchContainer="<%= entriesSearchContainerBenefitValue %>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.SmartActiveBenefitValue" modelVar="benefitValue" keyProperty="smartActiveBenefitValueId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_active/benefit_value/edit.jsp" />
								<portlet:param name="benefitValueId"
									value="<%= String.valueOf(benefitValue.getSmartActiveBenefitValueId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = benefitValue.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartActiveBenefitValueId" title="ID" name="ID" valign="middle" cssClass="<%= classInactive %>" href="<%= rowURL %>" />
							
							<%
								Locale idnLocale = new Locale("in", "ID");
								NumberFormat idnFormat = NumberFormat.getCurrencyInstance(idnLocale);
							%>
								
							<liferay-ui:search-container-column-text value="<%= idnFormat.format(benefitValue.getValue()) %>" title="Value" name="Value" valign="middle" cssClass="<%= classInactive %>" />
							
							<liferay-ui:search-container-column-jsp name="Action" align="right" path="/product/smart_active/benefit_value/action.jsp" />
							

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