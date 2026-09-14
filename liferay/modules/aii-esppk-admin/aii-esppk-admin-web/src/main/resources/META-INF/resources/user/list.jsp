<%@ include file="../init.jsp"%>
<%
	UserEsppkDisplayContext userEsppkDisplayContext = new UserEsppkDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	SearchContainer entriesSearchContainer = userEsppkDisplayContext.userEsppkSearchContainer();

	UserEsppkManagementToolbarDisplayContext userEsppkManagementToolbarDisplayContext = new UserEsppkManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainer);
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
			<div class="sheet sheet-full">
				<aui:form name="search" action="#" method="post"></aui:form>

				<!--  MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="userSppkSearchContainer"
					displayContext="<%=userEsppkManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<clay:container-fluid>
					<liferay-ui:search-container id="userSppkSearchContainer"
						searchContainer="<%=entriesSearchContainer%>">

						<liferay-ui:search-container-row
							className="com.aii.esppk.admin.model.SppkUser"
							modelVar="userSppk" escapedModel="<%=true%>"
							keyProperty="sppkUserId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/user/edit.jsp" />
								<portlet:param name="sppkUserId"
									value="<%=String.valueOf(userSppk.getSppkUserId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = userSppk.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text
								cssClass="<%=classInactive + "table-cell-expand-smallest table-cell-ws-nowrap table-title"%>"
								name="ID" value="<%=String.valueOf(userSppk.getSppkUserId())%>"
								href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="fullName"
								title="Full Name" name="Full Name" valign="middle"
								cssClass="<%=classInactive%>" />

							<liferay-ui:search-container-column-text property="sppkLoginCode"
								title="Login Code" name="Login Code" valign="middle"
								cssClass="<%=classInactive%>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/user/action.jsp" />

						</liferay-ui:search-container-row>

						<liferay-ui:search-iterator markupView="lexicon" />

					</liferay-ui:search-container>
				</clay:container-fluid>
			</div>
		</div>
	</div>
</div>
