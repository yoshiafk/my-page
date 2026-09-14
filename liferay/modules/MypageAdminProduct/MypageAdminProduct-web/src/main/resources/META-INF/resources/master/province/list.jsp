<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerProvince = masterDisplayContext.provinceSearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerProvince);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();
	
	// get country
	List<MasterCountry> masterCountry = MasterCountryLocalServiceUtil.getActiveCountries();

	// Variable to include in javascript
	String product = "masterProvinceSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "province";
				final String _editProvinceURL = editProvinceURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">Province</span>
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
								<aui:col width="50">
									<aui:input label="Name" name="searchName" type="text" />
								</aui:col>
								<aui:col width="50">
									<aui:select name="searchCountryId" label="Country">
										<aui:option value="" label="-" />
										
										<%
                                            	if(! masterCountry.isEmpty()) {
                                            		for(MasterCountry c : masterCountry) {
                                        %>       
                                        <aui:option value="<%= c.getCountryId() %>" label="<%= c.getName() %>" />                                     
                                        <%
                                           		}
                                          	}
                                        %>
									</aui:select>
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=provinceURL%>" primary="true"
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
					searchContainerId="masterProvinceSearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportMasterProvinceURL">
					<portlet:param name="exportMasterProvince"
						value="exportMasterProvince" />
				</portlet:resourceURL>

				<aui:form action="<%=exportMasterProvinceURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="province" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=provinceURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="province" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="masterProvinceSearchContainer"
						searchContainer="<%=entriesSearchContainerProvince%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.MasterProvince"
							modelVar="masterProvince" keyProperty="masterProvinceId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/province/edit.jsp" />
								<portlet:param name="masterProvinceId"
									value="<%=String.valueOf(masterProvince.getMasterProvinceId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = masterProvince.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(masterProvince.getMasterProvinceId()) %>"
							    href="<%= rowURL %>"
							/>

							<liferay-ui:search-container-column-text property="name"
								title="Province Name" name="Province Name" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<%
								MasterProvince masterProvinceRow = (MasterProvince) row.getObject();
								MasterCountry country = MasterCountryLocalServiceUtil.fetchMasterCountry(masterProvinceRow.getCountryId());
							%>
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>"
							    name="Country Name"
							    value="<%= String.valueOf(country.getName()) %>"
							/>

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/province/action.jsp" />

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