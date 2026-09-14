<%@ include file="../includes/init.jsp"%>

<%
	renderResponse.setTitle("MyPage User");

	//Display Context
	MypageUserDisplayContext mypageUserDisplayContext = new MypageUserDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainerUser = mypageUserDisplayContext.userSearchContainer();
	
	// Management Toolbar Display Context
	MypageUserManagementToolbarDisplayContext userManagementToolbarDisplayContext = new MypageUserManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerUser);

	PortletURL iteratorURL = userManagementToolbarDisplayContext._getCurrentSortingURL();
	
	// Variable to include in javascript
	String product = "mypageUserSearchContainer";
%>

<portlet:actionURL name="/mypageuser/update_data" var="updateURL" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
  		<div class="col-lg-12">
  			<div class="sheet sheet-full">
  				
  				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%= mypageUserDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=userManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="50">
									<aui:input label="Middle Name" name="searchUserName" type="text" />
								</aui:col>
								<%-- <aui:col width="50">
									<aui:input label="First Name" name="searchFirstName" type="text" />
								</aui:col>
								<aui:col width="50">
									<aui:input label="Middle Name" name="searchMiddleName" type="text" />
								</aui:col>
								<aui:col width="50">
									<aui:input label="Last Name" name="searchLastName" type="text" />
								</aui:col>
							</aui:row>
							<aui:row> --%>
								<aui:col width="50">
									<aui:input label="Email Address" name="searchEmailAddress" type="text" />
								</aui:col>
								<aui:col width="50">
									<aui:input label="Code" name="searchCode" type="text" />
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=userURL%>" primary="true"
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
					searchContainerId="mypageUserSearchContainer"
					displayContext="<%=userManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->
				
				<portlet:resourceURL var="exportUserURL">
					<portlet:param name="exportUser" value="exportUser" />
				</portlet:resourceURL>
				<aui:form action="<%= exportUserURL %>" name="fmExport">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= iteratorURL.toString() %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="user" type="hidden" />			
				</aui:form>
				
  				<aui:form action="<%= updateURL %>" name="fm">
					<aui:input name="<%= Constants.CMD %>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%= userURL %>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="user" />
						
					<clay:container-fluid>
						<liferay-ui:search-container
							id="mypageUserSearchContainer"
							searchContainer="<%= entriesSearchContainerUser %>"
						>
	
	                        <liferay-ui:search-container-row
	                            className="com.mypage.user.model.MypageUser" 
	                            modelVar="mypageUser"
	                            escapedModel="<%= true %>"
	                            keyProperty="mypageUserId"
	                        >
	                        	<%
									User liferayUser = UserLocalServiceUtil.fetchUser(mypageUser.getLiferayUserId());
								%>
			
	                            <portlet:renderURL var="rowURL"> 
	                                <portlet:param name="mvcPath" value="/user/edit.jsp" /> 
	                                <portlet:param name="mypageUserId" value="<%= String.valueOf(mypageUser.getMypageUserId()) %>" /> 
	                            </portlet:renderURL>
	                            
	                            <%
	                                String inactive = mypageUser.getActive() != 1 ? "Inactive" : "Active"; 
	                            %>
	                        
	                            <liferay-ui:search-container-column-text
	                                cssClass="<%= inactive +" table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
	                                name="MypageUserId"
	                                value="<%= String.valueOf(mypageUser.getMypageUserId()) %>"
	                                href="<%= rowURL %>"
	                            />
	                            
	                            <liferay-ui:search-container-column-text
	                                cssClass="<%= inactive +" table-cell-expand-smallest table-cell-ws-nowrap" %>"
	                                name="Liferay User Id"
	                                value="<%= String.valueOf(liferayUser.getUserId()) %>"
	                            />
	                            
	                            <liferay-ui:search-container-column-text
	                                cssClass="<%= inactive +" table-cell-expand-smallest table-cell-ws-nowrap" %>"
	                                name="Screen Name"
	                                value="<%= String.valueOf(liferayUser.getScreenName()) %>"
	                            />
	                            
	                            <liferay-ui:search-container-column-text
	                                cssClass="<%= inactive +" table-cell-expand-smallest table-cell-ws-nowrap" %>"
	                                name="First Name"
	                                value="<%= String.valueOf(liferayUser.getFirstName()) %>"
	                            />
	                            
	                            <liferay-ui:search-container-column-text
	                                cssClass="<%= inactive +" table-cell-expand-smallest table-cell-ws-nowrap" %>"
	                                name="Middle Name"
	                                value="<%= String.valueOf(liferayUser.getMiddleName()) %>"
	                            />
	                            
	                            <liferay-ui:search-container-column-text
	                                cssClass="<%= inactive +" table-cell-expand-smallest table-cell-ws-nowrap" %>"
	                                name="Last Name"
	                                value="<%= String.valueOf(liferayUser.getLastName()) %>"
	                            />
	                            
	                            <liferay-ui:search-container-column-text
	                                cssClass="<%= inactive +" table-cell-expand-smallest table-cell-ws-nowrap" %>"
	                                name="Email"
	                                value="<%= String.valueOf(liferayUser.getEmailAddress()) %>"
	                            />
	                            
	                            <liferay-ui:search-container-column-text
	                                cssClass="<%= inactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>"
	                                name="Code"
	                                property="code"
	                            />
	                            
	                            <liferay-ui:search-container-column-jsp name="Action"
									align="right" path="/user/action.jsp" />
	
	                        </liferay-ui:search-container-row>
		
						    <liferay-ui:search-iterator
								markupView="lexicon"
						    />
						
						</liferay-ui:search-container>
					</clay:container-fluid>
				
				</aui:form>
  				
  			</div>
  		</div>
	</div>
</div>

<%@ include file="../includes/listScript.jsp" %>