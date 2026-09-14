<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerCountry = masterDisplayContext.countrySearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerCountry);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "masterCountrySearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "country";
				final String _editCountryURL = editCountryURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">Country</span>
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
								<aui:col width="25">
									<aui:select name="searchPlatinum" label="Is Platinum">
										<aui:option value="" label="-" />
										<aui:option value="1" label="Yes" />
										<aui:option value="0" label="No" />
									</aui:select>
								</aui:col>
								<aui:col width="25">
									<aui:select name="searchGold" label="Is Gold">
										<aui:option value="" label="-" />
										<aui:option value="1" label="Yes" />
										<aui:option value="0" label="No" />
									</aui:select>
								</aui:col>
								<aui:col width="25">
									<aui:select name="searchSpecialAsia" label="Is Special Asia">
										<aui:option value="" label="-" />
										<aui:option value="1" label="Yes" />
										<aui:option value="0" label="No" />
									</aui:select>
								</aui:col>
								<aui:col width="25">
									<aui:select name="searchSchengen" label="Is Schengen">
										<aui:option value="" label="-" />
										<aui:option value="1" label="Yes" />
										<aui:option value="0" label="No" />
									</aui:select>
								</aui:col>
								<aui:col width="25">
									<aui:select name="searchSanctionCountry"
										label="Is Sanction Country">
										<aui:option value="" label="-" />
										<aui:option value="1" label="Yes" />
										<aui:option value="0" label="No" />
									</aui:select>
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=countryURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!--  MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="masterCountrySearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportMasterCountryURL">
					<portlet:param name="exportMasterCountry"
						value="exportMasterCountry" />
				</portlet:resourceURL>

				<aui:form action="<%=exportMasterCountryURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="country" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=countryURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="country" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="masterCountrySearchContainer"
						searchContainer="<%=entriesSearchContainerCountry%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.MasterCountry"
							modelVar="masterCountry" keyProperty="countryId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/country/edit.jsp" />
								<portlet:param name="countryId"
									value="<%=String.valueOf(masterCountry.getCountryId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = masterCountry.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="countryId"
								title="ID" name="ID" valign="middle"
								cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="name"
								title="Country Name" name="Country Name" valign="middle"
								cssClass="<%=classInactive%>" />

							<%
								if (masterCountry.getIsPlatinum() == 0) {
							%>
							<liferay-ui:search-container-column-icon icon="times-small"
								name="Platinum" />
							<%
								} else {
							%>
							<liferay-ui:search-container-column-icon icon="check-small"
								name="Platinum" />
							<%
								}
							%>

							<%
								if (masterCountry.getIsGold() == 0) {
							%>
							<liferay-ui:search-container-column-icon icon="times-small"
								name="Gold" />
							<%
								} else {
							%>
							<liferay-ui:search-container-column-icon icon="check-small"
								name="Gold" />
							<%
								}
							%>

							<%
								if (masterCountry.getIsSpecialAsia() == 0) {
							%>
							<liferay-ui:search-container-column-icon icon="times-small"
								name="Special Asia" />
							<%
								} else {
							%>
							<liferay-ui:search-container-column-icon icon="check-small"
								name="Special Asia" />
							<%
								}
							%>

							<%
								if (masterCountry.getIsSchengen() == 0) {
							%>
							<liferay-ui:search-container-column-icon icon="times-small"
								name="Schengen" />
							<%
								} else {
							%>
							<liferay-ui:search-container-column-icon icon="check-small"
								name="Schengen" />
							<%
								}
							%>

							<%
								if (masterCountry.getIsSanctionCountry() == 0) {
							%>
							<liferay-ui:search-container-column-icon icon="times-small"
								name="Sanction Country" />
							<%
								} else {
							%>
							<liferay-ui:search-container-column-icon icon="check-small"
								name="Sanction Country" />
							<%
								}
							%>

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/country/action.jsp" />

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