<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerCity = masterDisplayContext.citySearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerCity);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();
	
	// get province
	List<MasterProvince> masterProvince = MasterProvinceLocalServiceUtil.getActiveProvinces();

	// Variable to include in javascript
	String product = "masterCitySearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "city";
				final String _editCityURL = editCityURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">City</span>
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
									<aui:select name="searchProvinceId" label="Province">
										<aui:option value="" label="-" />
										<%
                                            	if(! masterProvince.isEmpty()) {
                                            		for(MasterProvince p : masterProvince) {
                                        %>       
                                        <aui:option value="<%= p.getMasterProvinceId() %>" label="<%= p.getName() %>" />                                     
                                        <%
                                           		}
                                          	}
                                        %>
									</aui:select>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col width="50">
									<aui:input label="Status" name="searchStatus" type="text" />
								</aui:col>
								<aui:col width="50">
									<aui:input label="ParEarthquakeZone" name="searchParEarthquakeZone" type="number" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=cityURL%>" primary="true"
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
					searchContainerId="masterCitySearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportMasterCityURL">
					<portlet:param name="exportMasterCity"
						value="exportMasterCity" />
				</portlet:resourceURL>

				<aui:form action="<%=exportMasterCityURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="city" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=cityURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="city" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="masterCitySearchContainer"
						searchContainer="<%=entriesSearchContainerCity%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.MasterCity"
							modelVar="masterCity" keyProperty="masterCityId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/city/edit.jsp" />
								<portlet:param name="masterCityId"
									value="<%=String.valueOf(masterCity.getMasterCityId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = masterCity.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(masterCity.getMasterCityId()) %>"
							    href="<%= rowURL %>"
							/>

							<liferay-ui:search-container-column-text property="name"
								title="City Name" name="City Name" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" 
							/>
							
							<%
								MasterCity masterCityRow = (MasterCity) row.getObject();
								MasterProvince province = MasterProvinceLocalServiceUtil.fetchMasterProvince(masterCityRow.getProvinceId());
							%>
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>"
							    name="Province Name"
							    value="<%= String.valueOf(province.getName()) %>"
							/>
							
							<liferay-ui:search-container-column-text property="status"
								title="Status" name="Status" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" 
							/>
							
							<liferay-ui:search-container-column-text property="parEarthquakeZone"
								title="ParEarthquakeZone" name="ParEarthquakeZone" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" 
							/>

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/city/action.jsp" />

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