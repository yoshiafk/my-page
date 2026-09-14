<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MypageUserDisplayContext mypageUserDisplayContext = new MypageUserDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainerUser = mypageUserDisplayContext.selectUserSearchContainer();

	String p_u_i_d = ParamUtil.getString(request, "p_u_i_d");
	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectMypageUser");
	String syncEntitiesEventName = ParamUtil.getString(request, "syncEntitiesEventName", liferayPortletResponse.getNamespace() + "syncMypageUsers");
	String getLiferayUserId = ParamUtil.getString(request, "liferayUserId", "");
	
	User selUser = PortalUtil.getSelectedUser(request);
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/user/select_user.jsp");
	if(getLiferayUserId != "") {		
		portletURL.setParameter("liferayUserId", getLiferayUserId);
	}
	
	if (selUser != null) {
		portletURL.setParameter("p_u_i_d", String.valueOf(selUser.getUserId()));
	}
	portletURL.setParameter("eventName", eventName);
%>

<!--  MANAGEMENT TOOLBAR -->
<clay:management-toolbar supportsBulkActions="<%=true%>"
	searchContainerId="mypageUserSearchContainer"
	selectable="<%= false %>"
	searchActionURL="<%= portletURL.toString() %>"
	clearResultsURL="<%= portletURL.toString() %>"
	itemsTotal="<%= entriesSearchContainerUser.getTotal() %>"
/>
<!--  MANAGEMENT TOOLBAR -->

<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="selectMypageUserFm">
	<liferay-ui:search-container
		headerNames="name"
		id="mypageUserSearchContainer"
		searchContainer="<%= entriesSearchContainerUser %>"
	>
		<liferay-ui:search-container-row
			className="com.mypage.user.model.MypageUser"
			keyProperty="mypageUserId"
			modelVar="mypageUser"
		>
			<%
				User liferayUser = UserLocalServiceUtil.fetchUser(mypageUser.getLiferayUserId());
			%>
			
			<liferay-ui:search-container-column-text
				name="Screen Name"
			>
				<c:if test="<%= !Validator.isNull(liferayUser) %>">
					<%= HtmlUtil.escape(liferayUser.getScreenName()) %>
				</c:if>
				<c:if test="<%= Validator.isNull(liferayUser) %>">
					<p>Liferay User with id <b><%= mypageUser.getLiferayUserId() %></b> not found</p>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text
				name="Full Name"
			>
				<c:if test="<%= !Validator.isNull(liferayUser) %>">
					<%
						String middleName = !Validator.isNull(liferayUser.getMiddleName()) ? liferayUser.getMiddleName() + " " : "";
					%>
					<%= HtmlUtil.escape(liferayUser.getFirstName() + " " + middleName + liferayUser.getLastName()) %>
				</c:if>
				<c:if test="<%= Validator.isNull(liferayUser) %>">
					<p>Liferay User with id <b><%= mypageUser.getLiferayUserId() %></b> not found</p>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text
				name="Roles"
			>
				<c:if test="<%= !Validator.isNull(liferayUser) %>">
					<%
						List<Role> roles = RoleLocalServiceUtil.getUserRoles(liferayUser.getUserId());
					%>
					<%
						if(roles.size() > 0) {
							int num = 0;
							for(Role role : roles) {
					%>
						<c:if test="<%= roles.size() > 1 && num > 0 %>">
							<%= "," %>
						</c:if>
						<%= role.getName() %>
					<%
								num++;
							}
						}
					%>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text>
				<c:if test="<%= Validator.isNull(p_u_i_d) && !Validator.isNull(liferayUser) %>">

					<%
						Map<String, Object> data = new HashMap<String, Object>();
		
						data.put("entityid", mypageUser.getMypageUserId());
						String middleName = Validator.isNull(liferayUser.getMiddleName()) ? " " : " "+liferayUser.getMiddleName()+" ";
						data.put("screenname", liferayUser.getScreenName());
						data.put("fullname", liferayUser.getFirstName() + middleName + liferayUser.getLastName());
						data.put("searchcontainername", "mypageUsers");
						
						long[] productIds = ParamUtil.getLongValues(request, "productIds", mypageUserDisplayContext.getProductIds());
						boolean disabled = ArrayUtil.contains(productIds, mypageUser.getMypageUserId());
					%>

					<aui:button cssClass="selector-button" data="<%= data %>" disabled="<%= disabled %>" value="choose" />
				</c:if>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	var Util = Liferay.Util;

	var openingLiferay = Util.getOpener().Liferay;

	openingLiferay.fire(
		'<%= HtmlUtil.escape(syncEntitiesEventName) %>',
		{
			selectors: A.all('.selector-button:disabled')
		}
	);

	Util.selectEntityHandler('#<portlet:namespace />selectMypageUserFm', '<%= HtmlUtil.escapeJS(eventName) %>');
</aui:script>