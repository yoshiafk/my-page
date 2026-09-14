<%@ include file="../includes/init.jsp"%>

<%
//Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest, liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerOccupation = masterDisplayContext.occupationSearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerOccupation);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "masterOccupationSearchContainer";
	
	// get occupation category
	List<MasterOccupationCategory> occupationCategory = MasterOccupationCategoryLocalServiceUtil.searchByActive(1);
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "occupation";
				final String _editOccupationURL = editOccupationURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">Occupation</span>
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
									<aui:select name="searchMasterOccupationCategoryId" label="Occupation Category">
										<aui:option value="" label="-" />
										<%
                                            	if(! occupationCategory.isEmpty()) {
                                            		for(MasterOccupationCategory oc : occupationCategory) {
                                        %>       
                                        <aui:option value="<%= oc.getMasterOccupationCategoryId() %>" label="<%= oc.getName() %>" />                                     
                                        <%
                                           		}
                                          	}
                                        %>
									</aui:select>
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=occupationURL%>" primary="true"
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
					searchContainerId="masterOccupationSearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportMasterOccupationURL">
					<portlet:param name="exportMasterOccupation"
						value="exportMasterOccupation" />
				</portlet:resourceURL>

				<aui:form action="<%=exportMasterOccupationURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="occupation" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=occupationURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="occupation" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="masterOccupationSearchContainer"
						searchContainer="<%=entriesSearchContainerOccupation%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.MasterOccupation"
							modelVar="masterOccupation" keyProperty="masterOccupationId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/occupation/edit.jsp" />
								<portlet:param name="masterOccupationId"
									value="<%=String.valueOf(masterOccupation.getMasterOccupationId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = masterOccupation.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="masterOccupationId"
								title="ID" name="ID" valign="middle"
								cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title"%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="name"
								title="Name" name="Name" valign="middle"
								cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>" />
							
							<%
								MasterOccupationCategory category = MasterOccupationCategoryLocalServiceUtil.getMasterOccupationCategory(masterOccupation.getMasterOccupationCategoryId());
							%>
							<liferay-ui:search-container-column-text value="<%= String.valueOf(category.getName()) %>"
								title="Category" name="Category" valign="middle"
								cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-ws-nowrap"%>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/occupation/action.jsp" />

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