<%@ include file="../variables.jsp"%>

<%
	MypageUserDisplayContext mypageUserDisplayContext = new MypageUserDisplayContext(liferayPortletRequest, liferayPortletResponse);
	List<ProductConfiguration> licenses = mypageUserDisplayContext.getLicenses();
	
	PortletURL licenseURLObj = renderResponse.createRenderURL();
	licenseURLObj.setParameter("mvcPath", "/user/edit.jsp");
	licenseURLObj.setParameter("userTab", "License");
	licenseURLObj.setParameter("liferayUserId", String.valueOf(liferayUserId));
	licenseURLObj.setParameter("delta", ParamUtil.getString(request, "delta"));
%>

<liferay-util:buffer
	var="removeLicenseIcon"
>
	<liferay-ui:icon
		icon="times-circle"
		markupView="lexicon"
		message="remove"
	/>
</liferay-util:buffer>

<aui:input name="addProductIds" type="hidden" />
<aui:input name="deleteProductIds" type="hidden" />

<clay:content-row
    containerElement="h3"
    cssClass="sheet-subtitle"
    >
    <clay:content-col expand="<%= true %>">
        <span class="heading-text">
            License
        </span>
    </clay:content-col>
    <clay:content-col>
        <span class="heading-end">
            <liferay-ui:icon
                cssClass="modify-link"
                id="selectLicenseLink"
                label="<%= true %>"
                linkCssClass="btn btn-secondary btn-sm"
                message="select"
                method="get"
                url="javascript:;"
                />
        </span>
    </clay:content-col>
</clay:content-row>

<liferay-ui:search-container
    compactEmptyResultsMessage="<%= true %>"
    cssClass="lfr-search-container-license"
    curParam="LicenseCur"
    emptyResultsMessage="this-user-is-not-assigned-any-regular-license"
    headerNames="license,null"
    id="productConfigurationsSearchContainer"
    iteratorURL="<%= licenseURLObj %>"
    total="<%= licenses.size() %>"
>
    <liferay-ui:search-container-results
        results="<%= licenses.subList(searchContainer.getStart(), searchContainer.getResultEnd()) %>"
    />

    <liferay-ui:search-container-row
        className="com.mypage.admin.product.model.ProductConfiguration"
        keyProperty="productId"
        modelVar="product"
    >
        <liferay-ui:search-container-column-text
            cssClass="table-cell-content"
            name="License Name"
            property="productName"
        />
        
        <liferay-ui:search-container-column-text
            cssClass="table-cell-content"
        >
            <a class="modify-link" data-rowId="<%= product.getProductId() %>" href="javascript:;"><%= removeLicenseIcon %></a>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator
        markupView="lexicon"
    />
</liferay-ui:search-container>

<aui:script>
   	var selectLicenseButton = document.getElementById('<portlet:namespace />selectLicenseLink');
   	
   	var <portlet:namespace />addProductIds = [];
   	var <portlet:namespace />deleteProductIds = [];
	
   	selectLicenseButton.addEventListener('click', function(event) {
   		var searchContainerName = '<portlet:namespace />productConfigurationsSearchContainer';
		var searchContainer = Liferay.SearchContainer.get(searchContainerName);
					
        new Liferay.Util.openSelectionModal({
            onSelect: function(event) {
            	<portlet:namespace />selectLicense(
					event.entityid,
					event.entityname,
					event.searchcontainername,
				);
            },
            title: 'Select License',
            <%
            	String licenseEventName = liferayPortletResponse.getNamespace() + "selectProductConfiguration";
    			PortletURL licenseURL = PortletProviderUtil.getPortletURL(renderRequest, MypageUser.class.getName(), PortletProvider.Action.BROWSE);
    			licenseURL.setParameter("mvcPath", "/user/select_license.jsp");
    			licenseURL.setParameter("eventName", licenseEventName);
    			licenseURL.setWindowState(LiferayWindowState.POP_UP);
    			if(liferayUserId > 0) {
    				licenseURL.setParameter("liferayUserId", String.valueOf(liferayUserId));
    			}
            %>

            selectEventName: '<%= licenseEventName %>',
            selectedData: searchContainer.getData(true),
            url: '<%= licenseURL %>'
        });
	});
	
	function <portlet:namespace />deleteProductId(productId) {
		var A = AUI();

		A.Array.removeItem(<portlet:namespace />addProductIds, productId);

		<portlet:namespace />deleteProductIds.push(productId);

		document.<portlet:namespace />user.<portlet:namespace />addProductIds.value = <portlet:namespace />addProductIds.join(
			','
		);
		document.<portlet:namespace />user.<portlet:namespace />deleteProductIds.value = <portlet:namespace />deleteProductIds.join(
			','
		);
	}
   	
   	window['<portlet:namespace />selectLicense'] = function (
			productId,
			name,
			searchContainer,
		) {
			var A = AUI();
			var LString = A.Lang.String;

			var searchContainerName = '<portlet:namespace />' + searchContainer + 'SearchContainer';
			searchContainer = Liferay.SearchContainer.get(searchContainerName);

			var rowColumns = [];

			rowColumns.push(
				'<i class="icon-times-circle"></i> ' + Liferay.Util.escapeHTML(name)
			);

			rowColumns.push(
				'<a class="modify-link" data-rowId="' + productId + '" href="javascript:;"><%= UnicodeFormatter.toString(removeLicenseIcon) %></a>'
			);

			A.Array.removeItem(<portlet:namespace />deleteProductIds, productId);
			<portlet:namespace />addProductIds.push(productId);

			document.<portlet:namespace />user.<portlet:namespace />addProductIds.value = <portlet:namespace />addProductIds.join(
				','
			);
			document.<portlet:namespace />user.<portlet:namespace />deleteProductIds.value = <portlet:namespace />deleteProductIds.join(
				','
			);

			searchContainer.addRow(rowColumns, productId);
			searchContainer.updateDataStore();
		};
</aui:script>

<aui:script use="liferay-search-container">
	var Util = Liferay.Util;

	var searchContainer = Liferay.SearchContainer.get(
		'<portlet:namespace />productConfigurationsSearchContainer'
	);

	var searchContainerContentBox = searchContainer.get('contentBox');

	searchContainerContentBox.delegate(
		'click',
		function (event) {
			var link = event.currentTarget;

			var rowId = link.attr('data-rowId');

			var tr = link.ancestor('tr');

			var selectProduct = Util.getWindow(
				'<portlet:namespace />selectProductConfiguration'
			);

			if (selectProduct) {
				var selectButton = selectProduct.iframe.node
					.get('contentWindow.document')
					.one('.selector-button[data-entityid="' + rowId + '"]');

				Util.toggleDisabled(selectButton, false);
			}

			searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));

			<portlet:namespace />deleteProductId(rowId);
		},
		'.modify-link'
	);
</aui:script>