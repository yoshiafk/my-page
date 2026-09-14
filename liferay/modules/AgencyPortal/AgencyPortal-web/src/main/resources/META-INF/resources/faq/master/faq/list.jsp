<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	AgentFAQDisplayContext faqDisplayContext = new AgentFAQDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	//Search Container
	SearchContainer entriesSearchContainerFaq = faqDisplayContext.faqSearchContainer();
	
	// Management Toolbar Display Context
		AgentFAQManagementToolbarDisplayContext faqManagementToolbarDisplayContext = new AgentFAQManagementToolbarDisplayContext(
				request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerFaq);

	PortletURL iteratorURL = faqManagementToolbarDisplayContext._getCurrentSortingURL();

	
	// Variable to include in javascript
	String product = "faqSearchContainer";
	List<AgentFAQCategory> agentFaqCategory = AgentFAQCategoryLocalServiceUtil.getActiveCategory();
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "faq";
				final String _editAgentFaqURL = editAgentFaqURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="tag" markupView="lexicon" />
						<span class="pl-2 text-truncate">FAQ</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=faqDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=faqManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="50">
									<aui:input label="Title" name="searchTitle" type="text" />
								</aui:col>
								
								<aui:col width="50">
									<aui:select label="Category" name="searchCategory">
										<aui:option value="">Select Category</aui:option>
									    <% if (agentFaqCategory.size() > 0) {  %>
									    	<% for (int i = 0; i < agentFaqCategory.size(); i++) { %>
									    		<aui:option value="<%= agentFaqCategory.get(i).getCategory() %>"><%= agentFaqCategory.get(i).getCategory() %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=agentFaqURL%>" primary="true"
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
					searchContainerId="faqSearchContainer"
					displayContext="<%=faqManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportFaqURL">
					<portlet:param name="exportFaq"
						value="exportFaq" />
				</portlet:resourceURL>

				<aui:form action="<%=exportFaqURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="faq" type="hidden" />
				</aui:form>


				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=agentFaqURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="faq" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="faqSearchContainer"
						searchContainer="<%=entriesSearchContainerFaq%>">

						<liferay-ui:search-container-row
							className="com.mypage.agencyportal.model.AgentFAQ"
							modelVar="agentFaq" keyProperty="agentFaqId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/faq/master/faq/edit.jsp" />
								<portlet:param name="agentFaqId"
									value="<%=String.valueOf(agentFaq.getAgentFaqId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = agentFaq.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(agentFaq.getAgentFaqId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="title"
								title="Title" name="Title" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<liferay-ui:search-container-column-text property="category"
								title="Category" name="Category" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/faq/master/faq/action.jsp" />

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