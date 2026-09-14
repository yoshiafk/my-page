<%@ include file="../../includes/init.jsp"%>

<%
	// Display Context
	UserCreditDisplayContext displayContext = new UserCreditDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainer = displayContext.creditTypeConfigurationSearchContainer();

	// Management Toolbar Display Context
	UserCreditManagementToolbarDisplayContext managementToolbarDisplayContext = new UserCreditManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainer);

	PortletURL iteratorURL = managementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "creditTypeSearchContainer";
	
	// setting for menu
	String _active = "creditType";
%>

<liferay-ui:success key="success" message="Your request completed successfully." />

<portlet:actionURL name="/user_credit/update_data" var="updateURL" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%@ include file="/user_credit/left_menu.jsp"%>
		</div>
		<div class="col-lg-8">
			<clay:sheet>
            	<clay:sheet-header>
            		<!-- TITLE -->
					<h2 class="sheet-title">
						<div class="d-flex">
							<aui:icon cssClass="" image="globe" markupView="lexicon" />
							<span class="pl-2 text-truncate">Credit Type</span>
						</div>
					</h2>
					<!-- TITLE -->
            	</clay:sheet-header>
            	
            	<clay:sheet-section>
					<!--  COLLAPSIBLE PANEL -->
					<liferay-ui:panel collapsible="true" cssClass="p-3"
						defaultState="<%=displayContext._getOnSearch() ? "open" : "collapsed"%>"
						extended="false" title="Search" iconCssClass="icon-search">
		
						<aui:form name="search"
							action="<%=managementToolbarDisplayContext._getSearchActionURL()%>"
							method="post">
							<liferay-ui:panel-container extended="false"
								id="innerPanelContainer">
								<aui:row>
									<aui:col width="50">
										<aui:input label="Name" name="searchName" type="text" />
									</aui:col>
									<aui:col width="50">
										<aui:input label="Agent Type" name="searchAgentType" type="text" />
									</aui:col>
								</aui:row>
								<aui:button-row>
									<aui:button name="search[reset_button]" type="reset"
										value="Reset" href="<%=creditTypeURL%>" primary="true"
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
						searchContainerId="<%= product %>"
						displayContext="<%=managementToolbarDisplayContext%>" />
					<!--  MANAGEMENT TOOLBAR -->
					
					<portlet:resourceURL var="exportCreditTypeURL">
						<portlet:param name="exportCreditType"
							value="exportCreditType" />
					</portlet:resourceURL>
		
					<aui:form action="<%=exportCreditTypeURL%>" name="fmExport">
						<aui:input name="<%=Constants.CMD%>" type="hidden" />
						<aui:input name="redirect" type="hidden"
							value="<%=iteratorURL.toString()%>" />
						<aui:input name="entryIds" type="hidden" />
						<aui:input name="type" value="bank" type="hidden" />
					</aui:form>
					
					<aui:form action="<%=updateURL%>" name="fm">
						<aui:input name="<%=Constants.CMD%>" type="hidden" />
						<aui:input name="redirect" type="hidden" value="<%=creditTypeURL%>" />
						<aui:input name="entryIds" type="hidden" />
						<aui:input name="type" type="hidden" value="creditType" />
		
						<!-- SEARCH CONTAINER -->
						<liferay-ui:search-container id="<%=product %>"
							searchContainer="<%=entriesSearchContainer%>">
		
							<liferay-ui:search-container-row
								className="com.mypage.user.model.CreditType"
								modelVar="creditType" keyProperty="creditTypeId">
		
								<portlet:renderURL var="rowURL">
									<portlet:param name="mvcPath" value="/user_credit/credit_type/edit.jsp" />
									<portlet:param name="creditTypeId"
										value="<%=String.valueOf(creditType.getCreditTypeId())%>" />
								</portlet:renderURL>
		
								<%
									String classInactive = creditType.getActive() != 1 ? "status-inactive" : "status-active";
								%>
								
								<liferay-ui:search-container-column-text
								    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
								    name="ID"
								    value="<%= String.valueOf(creditType.getCreditTypeId()) %>"
								    href="<%= rowURL %>"
								/>
								
								<liferay-ui:search-container-column-text property="name"
									title="Name" name="Name" valign="middle"
									cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
		
								<liferay-ui:search-container-column-text property="agentType"
									title="Agent Type" name="Agent Type" valign="middle"
									cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
									
								<liferay-ui:search-container-column-text property="limit"
									title="Limit" name="Limit" valign="middle"
									cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
		
								<liferay-ui:search-container-column-jsp name="Action"
									align="right" path="/user_credit/credit_type/action.jsp" />
		
							</liferay-ui:search-container-row>
							<liferay-ui:search-iterator markupView="lexicon" />
						</liferay-ui:search-container>
						<!-- SEARCH CONTAINER -->
					</aui:form>
				</clay:sheet-section>
			</clay:sheet>
		</div>
	</div>
</div>

<%@ include file="../../includes/listScript.jsp"%>