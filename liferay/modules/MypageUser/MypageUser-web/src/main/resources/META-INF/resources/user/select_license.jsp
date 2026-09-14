<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MypageUserDisplayContext mypageUserDisplayContext = new MypageUserDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
	// Search Container
	SearchContainer entriesSearchContainerProduct = mypageUserDisplayContext.productConfigurationSearchContainer();

	String p_u_i_d = ParamUtil.getString(request, "p_u_i_d");
	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectProductConfiguration");
	String syncEntitiesEventName = ParamUtil.getString(request, "syncEntitiesEventName", liferayPortletResponse.getNamespace() + "syncProductConfigurations");
	String getLiferayUserId = ParamUtil.getString(request, "liferayUserId", "");
	
	User selUser = PortalUtil.getSelectedUser(request);
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/user/select_license.jsp");
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
	searchContainerId="productConfigurationSearchContainer"
	selectable="<%= false %>"
	searchActionURL="<%= portletURL.toString() %>"
	clearResultsURL="<%= portletURL.toString() %>"
/>
<!--  MANAGEMENT TOOLBAR -->

<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="selectProductConfigurationFm">
	<liferay-ui:search-container
		headerNames="name"
		id="productConfigurationSearchContainer"
		searchContainer="<%= entriesSearchContainerProduct %>"
	>
		<liferay-ui:search-container-row
			className="com.mypage.admin.product.model.ProductConfiguration"
			keyProperty="productId"
			modelVar="ProductConfiguration"
		>
			<liferay-ui:search-container-column-text
				name="Product Name"
				value="<%= HtmlUtil.escape(ProductConfiguration.getProductName()) %>"
			/>
			
			<liferay-ui:search-container-column-text
				name="Product Code"
				value="<%= HtmlUtil.escape(ProductConfiguration.getProductCode()) %>"
			/>
			
			<liferay-ui:search-container-column-text>
				<c:if test="<%= Validator.isNull(p_u_i_d) %>">

					<%
						Map<String, Object> data = new HashMap<String, Object>();
	
						data.put("entityid", ProductConfiguration.getProductId());
						data.put("entityname", ProductConfiguration.getProductName());
						data.put("searchcontainername", "productConfigurations");
						
						long[] productIds = ParamUtil.getLongValues(request, "productIds", mypageUserDisplayContext.getProductIds());
						boolean disabled = ArrayUtil.contains(productIds, ProductConfiguration.getProductId());
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

	Util.selectEntityHandler('#<portlet:namespace />selectProductConfigurationFm', '<%= HtmlUtil.escapeJS(eventName) %>');
</aui:script>