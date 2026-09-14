<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	//Search Container
	SearchContainer entriesSearchContainerIndustry = masterDisplayContext.industrySearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerIndustry);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "industrySearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "industry";
				final String _editIndustryURL = editIndustryURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">Industry</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=masterDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=masterManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="25">
									<aui:input label="Name" name="searchName" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=industryURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="industrySearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportIndustryURL">
					<portlet:param name="exportIndustry"
						value="exportIndustry" />
				</portlet:resourceURL>

				<aui:form action="<%=exportIndustryURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="industry" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=industryURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="industry" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="industrySearchContainer"
						searchContainer="<%=entriesSearchContainerIndustry%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.Industry"
							modelVar="industry" keyProperty="industryId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/industry/edit.jsp" />
								<portlet:param name="industryId"
									value="<%=String.valueOf(industry.getIndustryId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = industry.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="industryId"
								title="ID" name="ID" valign="middle"
								cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="name"
								title="Name" name="Name" valign="middle"
								cssClass="<%=classInactive%>" />
								
							<% IndustryCategory industryCategory = IndustryCategoryLocalServiceUtil.getIndustryCategory(industry.getIndustryCategoryId()); %>
							<liferay-ui:search-container-column-text value="<%=industryCategory.getName()%>"
								title="Category" name="Category" valign="middle"
								cssClass="<%=classInactive%>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/industry/action.jsp" />

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