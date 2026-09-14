<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	//Search Container
	SearchContainer entriesSearchContainerCurrency = masterDisplayContext.currencySearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerCurrency);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "masterCurrencySearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "currency";
				final String _editCurrencyURL = editCurrencyURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">Currency</span>
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
									value="Reset" href="<%=currencyURL%>" primary="true"
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
					searchContainerId="masterCurrencySearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportMasterCurrencyURL">
					<portlet:param name="exportMasterCurrency"
						value="exportMasterCurrency" />
				</portlet:resourceURL>

				<aui:form action="<%=exportMasterCurrencyURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="currency" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=currencyURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="currency" />
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="masterCurrencySearchContainer"
						searchContainer="<%=entriesSearchContainerCurrency%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.MasterCurrency"
							modelVar="masterCurrency" keyProperty="currencyId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/currency/edit.jsp" />
								<portlet:param name="currencyId"
									value="<%=String.valueOf(masterCurrency.getCurrencyId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = masterCurrency.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="currencyId"
								title="ID" name="ID" valign="middle"
								cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="name"
								title="Currency Name" name="Currency Name" valign="middle"
								cssClass="<%=classInactive%>" />

							<liferay-ui:search-container-column-text property="amount"
								title="Amount" name="Amount" valign="middle" />

							<%
								String checkedIcon = masterCurrency.getIsDefault() == 0 ? "times-small" : "check-small";
							%>
							<liferay-ui:search-container-column-icon icon="<%=checkedIcon%>"
								name="Default" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/currency/action.jsp" />

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