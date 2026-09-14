<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	LeadsDisplayContext leadsDisplayContext = new LeadsDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer _searchContainer = leadsDisplayContext.leadsSearchContainer();

	// Management Toolbar Display Context
	LeadsManagementToolbarDisplayContext leadsManagementToolbarDisplayContext = new LeadsManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, _searchContainer);

	PortletURL iteratorURL = leadsManagementToolbarDisplayContext._getCurrentSortingURL();
	
	// Variable to include in javascript
	String product = "leadsSearchContainer";
	
	//boolean checkCurrentUserPermission = LeadsPermission.contains(permissionChecker, scopeGroupId, "ADD_LEADS");
	
%>


<portlet:actionURL name="/leads/update_data" var="updateURL" />

<liferay-ui:error key="error" message="Sorry, an error prevented saving your Leads" />
<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="list" markupView="lexicon" />
						<span class="pl-2 text-truncate">Leads Parents</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=leadsDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=leadsManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							
							<aui:row>
								<aui:col width="25">
									<%
										int _totalProd = ProductConfigurationLocalServiceUtil.getProductConfigurationsCount();		
										List<ProductConfiguration> products = ProductConfigurationLocalServiceUtil.getProductConfigurations(0, _totalProd);
									%>
									<aui:select label="Product" name="s_product" showEmptyOption="true">
										<% for(ProductConfiguration _prod:products){ %>
									    <aui:option value="<%= _prod.getProductCode() %>" ><%= _prod.getProductName() %></aui:option>
									    <% } %>
									</aui:select>
								</aui:col>
								<aui:col width="25">
									<aui:input label="Reference Number" name="s_referenceNumber" type="text" />
								</aui:col>
								<aui:col width="20">
									<aui:select label="Type" name="s_type" showEmptyOption="true" >
										<aui:option value="leads" >Leads</aui:option>
										<aui:option value="quotation" >Quotation</aui:option>
										<aui:option value="kyc" >KYC</aui:option>
									</aui:select>
								</aui:col>
								<aui:col width="20">
									<aui:select label="Channel" name="s_channel" showEmptyOption="true">
										<aui:option value="b2c" >B2C</aui:option>
										<aui:option value="b2b" >B2B</aui:option>
										<aui:option value="b2b2c" >B2B2C</aui:option>
										<aui:option value="agent" >B2B+B2B2C</aui:option>
									</aui:select>
								</aui:col>
								<aui:col width="20">
									<aui:input label="Promocode" name="s_promocode" type="text" />
								</aui:col>		
								
								
							</aui:row>
							<aui:row>
								<aui:col width="25">
									<aui:input label="Name" name="s_name" type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:input label="Email" name="s_email" type="text" />
								</aui:col>
								<aui:col width="20">
									<label class="control-label">Create Date On</label>
									<liferay-ui:input-date name="s_create_on" nullable="true" />
								</aui:col>
								<aui:col width="20">
									<label class="control-label">Create Date After</label>
									<liferay-ui:input-date name="s_create_after" nullable="true" />
								</aui:col>
								<aui:col width="20">
									<label class="control-label">Create Date Before</label>
									<liferay-ui:input-date name="s_create_before" nullable="true" />
								</aui:col>
							</aui:row>
							
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=parentsURL%>" primary="true"
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
					searchContainerId="leadsSearchContainer"
					displayContext="<%=leadsManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportParentsURL">
					<portlet:param name="exportParents"
						value="exportParents" />
				</portlet:resourceURL>

				<aui:form action="<%=exportParentsURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="leads" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=parentsURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="leads" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="leadsSearchContainer"
						searchContainer="<%=_searchContainer%>">

						<liferay-ui:search-container-row className="com.mypage.leads.model.Leads" 
							modelVar="Leads" keyProperty="leadsId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/parents/edit.jsp" />
								<portlet:param name="LeadsId"
									value="<%=String.valueOf(Leads.getLeadsId())%>" />
							</portlet:renderURL>
							

							<%
								String classInactive = Leads.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Id"
							    value="<%= String.valueOf(Leads.getLeadsId()) %>"
							    href="<%= rowURL %>"
							/>

							<% 
								SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");
							%>
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Date"
							    value="<%= sdf.format(Leads.getCreateDate()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Type"
							    value="<%= String.valueOf(Leads.getLeadsType()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Reference Number"
							    value="<%= String.valueOf(Leads.getReferenceNumber()) %>"
							    href="<%= rowURL %>"
							/>
							
							<%
								List<ProductConfiguration> _product = ProductConfigurationLocalServiceUtil.getConfigByCode(String.valueOf(Leads.getProductCode()));
								String _productName = "";
								if(_product.size()>0) {
									_productName = _product.get(0).getProductName();
								}
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Product"
							    value="<%= _productName %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Channel"
							    value="<%= String.valueOf(Leads.getChannel()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Name"
							    value="<%= String.valueOf(Leads.getName()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Email"
							    value="<%= String.valueOf(Leads.getEmail()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Net Premium"
							    value="<%= String.format("%,.2f", Leads.getNetPremium()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="PromoCode"
							    value="<%= String.valueOf(Leads.getPromoCode()) %>"
							    href="<%= rowURL %>"
							/>

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/parents/action.jsp" />

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