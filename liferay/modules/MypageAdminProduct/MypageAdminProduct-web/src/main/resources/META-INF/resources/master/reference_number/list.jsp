<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerReferenceNumber = masterDisplayContext.referenceNumberSearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerReferenceNumber);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "referenceNumberSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "referenceNumber";
				final String _editReferenceNumberURL = editReferenceNumberURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">ReferenceNumber</span>
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
								<aui:col width="33">
									<aui:select label="Channel" name="searchChannel" showEmptyOption="true">
                                        <aui:option value="Direct">Direct</aui:option>
                                        <aui:option value="Agent">Agent</aui:option>
                                    </aui:select>
								</aui:col>
								<aui:col width="33">
									<aui:select label="Type" name="searchType" showEmptyOption="true">
                                        <aui:option value="leads">Leads</aui:option>
                                        <aui:option value="quotation">Quotation</aui:option>
                                        <aui:option value="kyc">KYC</aui:option>
                                    </aui:select>
								</aui:col>
								<aui:col width="33">
									<aui:select label="Product Code" name="searchProductCode" showEmptyOption="true">
										<%
											List<ProductConfiguration> products = ProductConfigurationLocalServiceUtil.getProductConfigurations(0, ProductConfigurationLocalServiceUtil.getProductConfigurationsCount());
											if(products.size() > 0) {
												for(ProductConfiguration p : products) {
										%>
											<aui:option value="<%= p.getProductCode() %>"><%= p.getProductCode() %></aui:option>
										<%
												}
											}
										%>
                                    </aui:select>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col width="33">
									<aui:select label="Business Type" name="searchBusinessType" showEmptyOption="true">
                                        <aui:option value="B2C">B2C</aui:option>
                                        <aui:option value="B2B">B2B</aui:option>
                                        <aui:option value="B2B2C">B2B2C</aui:option>
                                    </aui:select>
								</aui:col>
								<aui:col width="33">
									<aui:select label="Currency" name="searchCurrency" showEmptyOption="true">
										<%
											List<MasterCurrency> currencies = MasterCurrencyLocalServiceUtil.getMasterCurrencies();
											if(currencies.size() > 0) {
												for(MasterCurrency currency : currencies) {
										%>
											<aui:option value="<%= currency.getName() %>"><%= currency.getName() %></aui:option>
										<%
												}
											}
										%>
                                    </aui:select>
								</aui:col>
								<aui:col width="33">
									<aui:input label="Prefix" name="searchPrefix" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=referenceNumberURL%>" primary="true"
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
					searchContainerId="referenceNumberSearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportReferenceNumberURL">
					<portlet:param name="exportReferenceNumber"
						value="exportReferenceNumber" />
				</portlet:resourceURL>

				<aui:form action="<%=exportReferenceNumberURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="referenceNumber" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=referenceNumberURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="referenceNumber" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="referenceNumberSearchContainer"
						searchContainer="<%=entriesSearchContainerReferenceNumber%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.ReferenceNumber"
							modelVar="referenceNumber" keyProperty="referenceNumberId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/reference_number/edit.jsp" />
								<portlet:param name="referenceNumberId"
									value="<%=String.valueOf(referenceNumber.getReferenceNumberId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = referenceNumber.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(referenceNumber.getReferenceNumberId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="channel"
								title="Channel" name="channel" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-text property="type"
								title="Type" name="type" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text property="productCode"
								title="Product Code" name="productCode" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text property="businessType"
								title="Business Type" name="businessType" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<liferay-ui:search-container-column-text property="prefix"
								title="Prefix" name="prefix" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/reference_number/action.jsp" />

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