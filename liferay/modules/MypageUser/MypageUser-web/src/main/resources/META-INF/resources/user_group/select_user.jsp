<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MypageUserDisplayContext mypageUserDisplayContext = new MypageUserDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainerUser = mypageUserDisplayContext.selectUserSearchContainer();

	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectMypageUser");
	String syncEntitiesEventName = ParamUtil.getString(request, "syncEntitiesEventName", liferayPortletResponse.getNamespace() + "syncMypageUsers");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/user_group/select_user.jsp");
	
	portletURL.setParameter("eventName", eventName);
	
	List<Long> ids = new ArrayList<>();
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
			
			<liferay-ui:search-container-column-text
				name="Code"
			>
				<c:if test="<%= !Validator.isNull(mypageUser) %>">
					<%= HtmlUtil.escape(mypageUser.getCode()) %>
				</c:if>
				<c:if test="<%= Validator.isNull(mypageUser) %>">
					<p>User with agent code <b><%= mypageUser.getCode() %></b> not found</p>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text
				name="Full Name"
			>
				<c:if test="<%= !Validator.isNull(mypageUser) %>">
					<%= HtmlUtil.escape(mypageUser.getUserName()) %>
				</c:if>
				<c:if test="<%= Validator.isNull(mypageUser) %>">
					<p>User with agent code <b><%= mypageUser.getCode() %></b> not found</p>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text>
				<c:if test="<%= !Validator.isNull(mypageUser) %>">

					<%
						Map<String, Object> data = new HashMap<String, Object>();
		
						data.put("entityid", mypageUser.getMypageUserId());
						data.put("entitycode", mypageUser.getCode());
						data.put("entityname", mypageUser.getUserName());
						data.put("searchcontainername", "mypageUsers");
						
						ids.add(mypageUser.getMypageUserId());
						
						/* long[] productIds = ParamUtil.getLongValues(request, "productIds", mypageUserDisplayContext.getProductIds());
						boolean disabled = ArrayUtil.contains(productIds, mypageUser.getMypageUserId()); */
					%>

					<aui:button cssClass="selector-button" data="<%= data %>" value="choose" />
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