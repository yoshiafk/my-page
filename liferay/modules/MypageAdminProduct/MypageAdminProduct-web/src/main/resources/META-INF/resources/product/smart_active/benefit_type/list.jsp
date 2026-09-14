<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	SmartActiveDisplayContext smartActiveDisplayContext = new SmartActiveDisplayContext(liferayPortletRequest,
		liferayPortletResponse);
	
	//Search Container
	SearchContainer entriesSearchContainerBenefitType = smartActiveDisplayContext.benefitTypeSearchContainer();
	
	// Management Toolbar Display Context
	SmartActiveManagementToolbarDisplayContext smartActiveManagementToolbarDisplayContext = new SmartActiveManagementToolbarDisplayContext(
					request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerBenefitType);		

	PortletURL iteratorURL = smartActiveManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "benefitTypeSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "benefit_type";
				final String _editBenefitTypeURL = editBenefitTypeURL;
			%>
			<%@ include file="../includes/left-menu.jsp" %>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Benefit Type</span>
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
								
								<!-- add search -->
								<aui:col width="45">
									<aui:input label="Name (English)" name="searchNameEn" type="text" />
								</aui:col>
								
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%= benefitTypeURL %>" primary="true"
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
					searchContainerId="benefitTypeSearchContainer"
					displayContext="<%= smartActiveManagementToolbarDisplayContext %>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportBenefitTypeURL">
					<portlet:param name="exportBenefitType"
						value="exportBenefitType" />
				</portlet:resourceURL>

				<aui:form action="<%= exportBenefitTypeURL %>" name="fmExport">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%= iteratorURL.toString() %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="benefit_type" type="hidden" />
				</aui:form>

				<aui:form action="<%= updateURL %>" name="fm">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= benefitTypeURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="benefit_type" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="benefitTypeSearchContainer"
						searchContainer="<%= entriesSearchContainerBenefitType %>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.SmartActiveBenefitType"
							modelVar="benefitType" keyProperty="smartActiveBenefitTypeId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/smart_active/benefit_type/edit.jsp" />
								<portlet:param name="benefitTypeId"
									value="<%= String.valueOf(benefitType.getSmartActiveBenefitTypeId()) %>" />
							</portlet:renderURL>

							<%
								String classInactive = benefitType.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartActiveBenefitTypeId"
								title="ID" name="ID" valign="middle"
								cssClass="<%= classInactive %>" href="<%= rowURL %>" />

							<liferay-ui:search-container-column-text property="nameId"
								title="Name ID" name="Name (Indonesia)" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<liferay-ui:search-container-column-text property="nameEn"
								title="Name English" name="Name (English)" valign="middle"
								cssClass="<%= classInactive %>" />
								
							<liferay-ui:search-container-column-text property="sort"
								title="Sort" name="Sort" valign="middle"
								cssClass="<%= classInactive %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/product/smart_active/benefit_type/action.jsp" />

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