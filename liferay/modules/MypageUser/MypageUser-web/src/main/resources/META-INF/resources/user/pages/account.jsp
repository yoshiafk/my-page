<%@ include file="../variables.jsp"%>

<liferay-ui:error exception="<%= MypageUserException.CreditWalletIdMustNotBeDuplicate.class %>" focusField="creditWalletId" message="the-credit-wallet-you-requested-is-already-taken" />

<liferay-util:buffer
	var="removeLicenseIcon"
>
	<liferay-ui:icon
		icon="times-circle"
		markupView="lexicon"
		message="remove"
	/>
</liferay-util:buffer>

<aui:row>
    <aui:col width="50">
        <aui:select label="Status" name="status" showEmptyOption="true">
            <aui:option value="active" selected="<%= mypageUser != null && mypageUser.getStatus().equals("active") %>">Active</aui:option>
            <aui:option value="inactive" selected="<%= mypageUser != null && mypageUser.getStatus().equals("inactive") %>">Inactive</aui:option>
            <aui:option value="locked" selected="<%= mypageUser != null && mypageUser.getStatus().equals("locked") %>">Locked</aui:option>
        </aui:select>
    </aui:col>
</aui:row>

<clay:content-row
    containerElement="h3"
    cssClass="sheet-subtitle"
    >
    <clay:content-col expand="<%= true %>">
        <span class="heading-text">
            <liferay-ui:message key="regular-roles" />
        </span>
    </clay:content-col>
    <clay:content-col>
        <span class="heading-end">
            <liferay-ui:icon
                cssClass="modify-link"
                id="selectRegularRoleLink"
                label="<%= true %>"
                linkCssClass="btn btn-secondary btn-sm"
                message="select"
                method="get"
                url="javascript:;"
                />
        </span>
    </clay:content-col>
</clay:content-row>

<%
    InitDisplayContext initDisplayContext = new InitDisplayContext(request, portletName);	
    boolean filterManageableOrganizations = initDisplayContext.isFilterManageableOrganizations();
    MypageUserDisplayContext userDisplayContext = new MypageUserDisplayContext(liferayPortletRequest,
            liferayPortletResponse);	
    User selUser = userDisplayContext.getSelectedUser();

    PortletURL currentURLObj = renderResponse.createRenderURL();
    currentURLObj.setParameter("historyKey", liferayPortletResponse.getNamespace() + "roles");
    List<Role> roles = userDisplayContext.getRoles();
%>

<liferay-ui:search-container
    compactEmptyResultsMessage="<%= true %>"
    cssClass="lfr-search-container-roles"
    curParam="regularRolesCur"
    emptyResultsMessage="this-user-is-not-assigned-any-regular-roles"
    headerNames="title,null"
    id="rolesSearchContainer"
    iteratorURL="<%= currentURLObj %>"
    total="<%= roles.size() %>"
>
    <liferay-ui:search-container-results
        results="<%= roles.subList(searchContainer.getStart(), searchContainer.getResultEnd()) %>"
    />

    <liferay-ui:search-container-row
        className="com.liferay.portal.kernel.model.Role"
        keyProperty="roleId"
        modelVar="role"
    >
        <liferay-ui:search-container-column-text
            cssClass="table-cell-content"
            name="title"
        >
            <liferay-ui:icon
                iconCssClass="<%= RolesAdminUtil.getIconCssClass(role) %>"
                label="<%= true %>"
                message="<%= HtmlUtil.escape(role.getTitle(locale)) %>"
            />
        </liferay-ui:search-container-column-text>

        <c:if test="<%= !RoleMembershipPolicyUtil.isRoleRequired(selUser.getUserId(), role.getRoleId()) %>">
            <liferay-ui:search-container-column-text>
                <a class="modify-link" data-rowId="<%= role.getRoleId() %>" href="javascript:;"><%= removeLicenseIcon %></a>
            </liferay-ui:search-container-column-text>
        </c:if>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator
        markupView="lexicon"
    />
</liferay-ui:search-container>

<clay:content-row
    containerElement="h3"
    cssClass="sheet-subtitle"
    >
    <clay:content-col expand="<%= true %>">
        <span class="heading-text">
            User Parent
        </span>
    </clay:content-col>
    <clay:content-col>
        <span class="heading-end">
            <liferay-ui:icon
                cssClass="add-user-parent"
                id="selectUserParent"
                label="<%= true %>"
                linkCssClass="btn btn-secondary btn-sm"
                message="select"
                method="get"
                url="javascript:;"
                />
        </span>
    </clay:content-col>
</clay:content-row>

<aui:row>
	<aui:input 
	    name="userParent" 
	    type="hidden"
	    value="<%=mypageUser == null ? "" : String.valueOf(mypageUser.getUserParent())%>" />
	<aui:col width="100">
	    <p id="no-user-parent" class="text-muted pb-4 <%= mypageUser == null || (mypageUser != null && Validator.isNull(mypageUser.getUserParent())) ? "" : "d-none" %>">
	        this user is not assigned any user parent
	    </p>
	    
	    <table 
	        class="show-quick-actions-on-hover table table-autofit table-heading-nowrap table-list mb-4 <%= mypageUser == null || (mypageUser != null && Validator.isNull(mypageUser.getUserParent())) ? "d-none" : "" %>" 
	        id="user-parent-table"
	    >
	        <thead>
	            <tr>
	            	<th class="lfr-title-column">Screeen Name</th>
	                <th class="lfr-title-column">Full Name</th>
	                <th class="lfr-entry-action-column"> &nbsp; </th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr id="user-parent-row">
	                <% if(mypageUser != null && !Validator.isNull(mypageUser.getUserParent())) { %>
	                <%
	                	MypageUser getUserParent = MypageUserLocalServiceUtil.getMypageUser(mypageUser.getUserParent());
	                	User getLiferayParent = UserLocalServiceUtil.getUser(getUserParent.getLiferayUserId());
	                %>
	                <td>
						<span><%= getLiferayParent.getScreenName() %></span>
					</td>
	                <td>
	                    <span><%= getLiferayParent.getFirstName() %><%= Validator.isNull(getLiferayParent.getMiddleName()) ? " " : " "+getLiferayParent.getMiddleName()+" " %><%= getLiferayParent.getLastName() %></span>
	                </td>
	                <td>
	                    <a onclick="removeUserParent(this)" id="remove-user-parent" href="javascript:;">
	                        <%= removeLicenseIcon %>
	                    </a>
	                </td>
	                <% } %>
	            </tr>
	        </tbody>
	    </table>
	</aui:col>
</aui:row>

<clay:content-row
    containerElement="h3"
    cssClass="sheet-subtitle"
    >
    <clay:content-col expand="<%= true %>">
        <span class="heading-text">
            Branch
        </span>
    </clay:content-col>
    <clay:content-col>
        <span class="heading-end">
            <liferay-ui:icon
                cssClass="add-branch"
                id="selectBranch"
                label="<%= true %>"
                linkCssClass="btn btn-secondary btn-sm"
                message="select"
                method="get"
                url="javascript:;"
                />
        </span>
    </clay:content-col>
</clay:content-row>

<aui:row>
	<aui:input 
    name="userBranch" 
    type="hidden"
    value="<%=mypageUser == null ? "" : String.valueOf(mypageUser.getUserBranch())%>" />
	<aui:col width="100">
	    <p id="no-branch" class="text-muted pb-4 <%= mypageUser == null || (mypageUser != null && Validator.isNull(mypageUser.getUserBranch())) ? "" : "d-none" %>">
	        this user is not assigned any branch
	    </p>
	    
	    <table 
	        class="show-quick-actions-on-hover table table-autofit table-heading-nowrap table-list mb-4 <%= mypageUser == null || (mypageUser != null && Validator.isNull(mypageUser.getUserBranch())) ? "d-none" : "" %>" 
	        id="branch-table"
	    >
	        <thead>
	            <tr>
	                <th class="lfr-title-column">Branch Name</th>
	                <th class="lfr-entry-action-column"> &nbsp; </th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr id="branch-row">
	                <% if(mypageUser != null && !Validator.isNull(mypageUser.getUserBranch())) { %>
	                <td>
	                    <%
	                        MasterBranch getBranch = MasterBranchLocalServiceUtil.getMasterBranch(mypageUser.getUserBranch());
	                    %>
	                    <span><%= getBranch.getName() %></span>
	                </td>
	                <td>
	                    <a onclick="removeBranch(this)" id="remove-branch" href="javascript:;">
	                        <%= removeLicenseIcon %>
	                    </a>
	                </td>
	                <% } %>
	            </tr>
	        </tbody>
	    </table>
	</aui:col>
</aui:row>

<clay:content-row
    containerElement="h3"
    cssClass="sheet-subtitle"
    >
    <clay:content-col expand="<%= true %>">
        <span class="heading-text">
            Credit Wallet
        </span>
    </clay:content-col>
    <c:if test="<%= mypageUser != null && Validator.isNull(mypageUser.getCreditWalletId()) %>">
	    <clay:content-col>
	        <span class="heading-end">
	            <liferay-ui:icon
	                cssClass="add-credit-wallet"
	                id="selectCreditWallet"
	                label="<%= true %>"
	                linkCssClass="btn btn-secondary btn-sm"
	                message="select"
	                method="get"
	                url="javascript:;"
	                />
	        </span>
	    </clay:content-col>
    </c:if>
</clay:content-row>
<aui:row>
	<aui:input 
    name="creditWalletId" 
    type="hidden"
    value="" />
	<aui:col width="100">
	    <p id="no-credit-wallet" class="text-muted pb-4 <%= mypageUser == null || (mypageUser != null && Validator.isNull(mypageUser.getCreditWalletId())) ? "" : "d-none" %>">
	        this user is not assigned any credit wallet
	    </p>
	    
	    <table 
	        class="show-quick-actions-on-hover table table-autofit table-heading-nowrap table-list mb-4 <%= mypageUser == null || (mypageUser != null && Validator.isNull(mypageUser.getCreditWalletId())) ? "d-none" : "" %>" 
	        id="credit-wallet-table"
	    >
	        <thead>
	            <tr>
	                <th class="lfr-title-column">Credit Wallet Id</th>
	                <th class="lfr-entry-action-column"> &nbsp; </th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr id="credit-wallet-row">
	                <c:if test="<%= mypageUser != null %>">
	                	<%
			    			PortletURL getWalletEditURL = PortletProviderUtil.getPortletURL(renderRequest, CreditType.class.getName(), PortletProvider.Action.BROWSE);
							getWalletEditURL.setParameter("mvcPath", "/user_credit/credit_wallet/edit.jsp");
							getWalletEditURL.setParameter("creditWalletId", String.valueOf(mypageUser.getCreditWalletId()));
							CreditWallet creditWallet = null;
							if(!Validator.isNull(mypageUser.getCreditWalletId())) creditWallet = CreditWalletLocalServiceUtil.fetchCreditWallet(mypageUser.getCreditWalletId());
			            %>
		                <td>
		                    <span><%= mypageUser.getCreditWalletId() %></span>
		                </td>
		                <c:if test="<%= creditWallet != null %>">
			                <td>
			                	<b><%= creditWallet.getActive() == 1 ? "Active" : "Inactive" %></b>
			                </td>
		                </c:if>
		                <td>
		                    <a href="<%= getWalletEditURL %>">
		                        <i class='icon-edit'></i> Open
		                    </a>
		                </td>
	                </c:if>
	            </tr>
	        </tbody>
	    </table>
	</aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:select label="Credit Status" name="creditStatus" showEmptyOption="true">
            <aui:option value="active" selected="<%= mypageUser != null && mypageUser.getCreditStatus().equals("active") %>">Active</aui:option>
            <aui:option value="freeze" selected="<%= mypageUser != null && mypageUser.getCreditStatus().equals("freeze") %>">Freeze</aui:option>
            <aui:option value="temporaryFreeze" selected="<%= mypageUser != null && mypageUser.getCreditStatus().equals("temporaryFreeze") %>">Temporary Freeze</aui:option>
        </aui:select>
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:select label="Payment Method" name="paymentMethod" showEmptyOption="true">
            <aui:option value="gross" selected="<%= mypageUser != null && mypageUser.getPaymentMethod().equals("gross") %>">Gross Premi</aui:option>
            <aui:option value="nett" selected="<%= mypageUser != null && mypageUser.getPaymentMethod().equals("nett") %>">Nett Premi</aui:option>
        </aui:select>
    </aui:col>
</aui:row>

<aui:row>
	<aui:col width="50">
        <aui:input label="Cash Payment" name="cashPayment" type="checkbox"
            value="1" checked="<%=mypageUser != null && mypageUser.getCashPayment() == 1 %>" />
    </aui:col>
</aui:row>

<aui:input name="addRoleIds" type="hidden" />
<aui:input name="deleteRoleIds" type="hidden" />

<aui:script sandbox="<%= true %>" use="liferay-search-container">
	var <portlet:namespace />addRoleIds = [];
	var <portlet:namespace />deleteRoleIds = [];
	
	var selectRegularRoleLink = document.getElementById(
		'<portlet:namespace />selectRegularRoleLink'
	);

	if (selectRegularRoleLink) {
		selectRegularRoleLink.addEventListener('click', function (event) {
			var searchContainerName = '<portlet:namespace />rolesSearchContainer';

			var searchContainer = Liferay.SearchContainer.get(searchContainerName);

			Liferay.Util.openSelectionModal({
				onSelect: function (event) {
					<portlet:namespace />selectRole(
						event.entityid,
						event.entityname,
						event.searchcontainername,
						event.groupdescriptivename,
						event.groupid,
						event.iconcssclass
					);
				},

				<%
					String regularRoleEventName = liferayPortletResponse.getNamespace() + "selectRegularRole";
					String _selectRegularRoleURL = request.getAttribute("selectRegularRoleURL").toString();
				%>

				selectEventName: '<%= regularRoleEventName %>',
				selectedData: searchContainer.getData(true),
				title:
					'<liferay-ui:message arguments="regular-role" key="select-x" />',
				url:'<%=_selectRegularRoleURL.toString() %>'

			});
		});
	}

	function <portlet:namespace />deleteRegularRole(roleId) {
		var A = AUI();

		A.Array.removeItem(<portlet:namespace />addRoleIds, roleId);

		<portlet:namespace />deleteRoleIds.push(roleId);

		document.<portlet:namespace />user.<portlet:namespace />addRoleIds.value = <portlet:namespace />addRoleIds.join(
			','
		);
		document.<portlet:namespace />user.<portlet:namespace />deleteRoleIds.value = <portlet:namespace />deleteRoleIds.join(
			','
		);
	}
	

	window['<portlet:namespace />selectRole'] = function (
		roleId,
		name,
		searchContainer,
		groupName,
		groupId,
		iconCssClass
	) {
		var A = AUI();
		var LString = A.Lang.String;

		var searchContainerName =
			'<portlet:namespace />' + searchContainer + 'SearchContainer';

		searchContainer = Liferay.SearchContainer.get(searchContainerName);

		var rowColumns = [];

		rowColumns.push(
			'<i class="' + iconCssClass + '"></i> ' + Liferay.Util.escapeHTML(name)
		);

		if (groupName) {
			rowColumns.push(groupName);
		}

		if (groupId) {
			rowColumns.push(
				'<a class="modify-link" data-groupId="' +
					groupId +
					'" data-rowId="' +
					roleId +
					'" href="javascript:;"><%= UnicodeFormatter.toString(removeLicenseIcon) %></a>'
			);

			for (
				var i = 0;
				i < <portlet:namespace />deleteGroupRolesRoleIds.length;
				i++
			) {
				if (
					<portlet:namespace />deleteGroupRolesGroupIds[i] === groupId &&
					<portlet:namespace />deleteGroupRolesRoleIds[i] === roleId
				) {
					<portlet:namespace />deleteGroupRolesGroupIds.splice(i, 1);
					<portlet:namespace />deleteGroupRolesRoleIds.splice(i, 1);

					break;
				}
			}

			<portlet:namespace />addGroupRolesGroupIds.push(groupId);
			<portlet:namespace />addGroupRolesRoleIds.push(roleId);

			document.<portlet:namespace />user.<portlet:namespace />addGroupRolesGroupIds.value = <portlet:namespace />addGroupRolesGroupIds.join(
				','
			);
			document.<portlet:namespace />user.<portlet:namespace />addGroupRolesRoleIds.value = <portlet:namespace />addGroupRolesRoleIds.join(
				','
			);
			document.<portlet:namespace />user.<portlet:namespace />deleteGroupRolesGroupIds.value = <portlet:namespace />deleteGroupRolesGroupIds.join(
				','
			);
			document.<portlet:namespace />user.<portlet:namespace />deleteGroupRolesRoleIds.value = <portlet:namespace />deleteGroupRolesRoleIds.join(
				','
			);

			searchContainer.addRow(rowColumns, groupId + '-' + roleId);
		}
		else {
			rowColumns.push(
				'<a class="modify-link" data-rowId="' +
					roleId +
					'" href="javascript:;"><%= UnicodeFormatter.toString(removeLicenseIcon) %></a>'
			);

			A.Array.removeItem(<portlet:namespace />deleteRoleIds, roleId);

			<portlet:namespace />addRoleIds.push(roleId);

			document.<portlet:namespace />user.<portlet:namespace />addRoleIds.value = <portlet:namespace />addRoleIds.join(
				','
			);
			document.<portlet:namespace />user.<portlet:namespace />deleteRoleIds.value = <portlet:namespace />deleteRoleIds.join(
				','
			);

			searchContainer.addRow(rowColumns, roleId);
		}

		searchContainer.updateDataStore();
	};
	

	var Util = Liferay.Util;

	var searchContainer = Liferay.SearchContainer.get(
		'<portlet:namespace />rolesSearchContainer'
	);

	var searchContainerContentBox = searchContainer.get('contentBox');

	searchContainerContentBox.delegate(
		'click',
		function (event) {
			var link = event.currentTarget;

			var rowId = link.attr('data-rowId');

			var tr = link.ancestor('tr');

			var selectRegularRole = Util.getWindow(
				'<portlet:namespace />selectRegularRole'
			);

			if (selectRegularRole) {
				var selectButton = selectRegularRole.iframe.node
					.get('contentWindow.document')
					.one('.selector-button[data-entityid="' + rowId + '"]');

				Util.toggleDisabled(selectButton, false);
			}

			searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));

			<portlet:namespace />deleteRegularRole(rowId);
		},
		'.modify-link'
	);
</aui:script>

<aui:script use="liferay-search-container">
   	var selectUserButton = document.getElementById('<portlet:namespace />selectUserParent');
   	var searchContainer = Liferay.SearchContainer.get("user-parent-table");
   	var rowColumns = [];
	
   	selectUserButton.addEventListener('click', function(event) {
		
        new Liferay.Util.openSelectionModal({
            onSelect: function(event) {
            	var no_parent = document.getElementById('no-user-parent');
            	var row = `
            		<td>
		                <span>`+event.screenname+`</span>
		            </td>
            		<td>
		                <span>`+event.fullname+`</span>
		            </td>
		            <td>
		                <a onclick="removeUserParent(this)" id="remove-user-parent" href="javascript:;"><%= UnicodeFormatter.toString(removeLicenseIcon) %></a>
		            </td>`;
            	if(no_parent != null) no_parent.classList.add('d-none');
            	document.getElementById("user-parent-row").innerHTML = row;
            	document.<portlet:namespace />user.<portlet:namespace />userParent.value = event.entityid;
            	document.getElementById("user-parent-table").classList.remove('d-none')
            },
            title: 'Select User',
            <%
            	String eventName = liferayPortletResponse.getNamespace() + "selectMypageUser";
    			PortletURL selectUserURL = PortletProviderUtil.getPortletURL(renderRequest, MypageUser.class.getName(), PortletProvider.Action.BROWSE);
    			selectUserURL.setParameter("mvcPath", "/user/select_user.jsp");
    			selectUserURL.setParameter("eventName", eventName);
    			selectUserURL.setWindowState(LiferayWindowState.POP_UP);
    			if(liferayUserId > 0) {
    				selectUserURL.setParameter("liferayUserId", String.valueOf(liferayUserId));
    			}
            %>

            selectEventName: '<%= eventName %>',
            selectedData: [document.<portlet:namespace />user.<portlet:namespace />userParent.value],
            url: '<%= selectUserURL %>'
        });
	});
	
	removeUserParent = function(e) {
		var no_parent = document.getElementById('no-user-parent');
		document.getElementById("user-parent-row").innerHTML = "";
        document.<portlet:namespace />user.<portlet:namespace />userParent.value = "";
        document.getElementById("user-parent-table").classList.add('d-none')
        if(no_parent != null) no_parent.classList.remove('d-none');
	}
</aui:script>

<aui:script use="liferay-search-container">
   	var selectBranchButton = document.getElementById('<portlet:namespace />selectBranch');
   	var searchBranchContainer = Liferay.SearchContainer.get("branch-table");
   	var rowColumns = [];

   	selectBranchButton.addEventListener('click', function(event) {
		
        new Liferay.Util.openSelectionModal({
            onSelect: function(event) {
            	var no_branch = document.getElementById('no-branch');
            	var row = `<td>
		                <span>`+event.entityname+`</span>
		            </td>
		            <td>
		                <a onclick="removeBranch(this)" id="remove-branch" href="javascript:;"><liferay-ui:icon icon="times-circle" markupView="lexicon" /></a>
		            </td>`;
            	if(no_branch != null) no_branch.classList.add('d-none');
            	document.getElementById("branch-row").innerHTML = row;
            	document.<portlet:namespace />user.<portlet:namespace />userBranch.value = event.entityid;
            	document.getElementById("branch-table").classList.remove('d-none')
            },
            title: 'Select Branch',
            <%
            	String eventName = liferayPortletResponse.getNamespace() + "selectMasterBranch";
    			PortletURL selectUserURL = PortletProviderUtil.getPortletURL(renderRequest, MasterCountry.class.getName(), PortletProvider.Action.BROWSE);
    			selectUserURL.setParameter("mvcPath", "/master/branch/select_branch.jsp");
    			selectUserURL.setParameter("eventName", eventName);
    			selectUserURL.setWindowState(LiferayWindowState.POP_UP);
    			if(liferayUserId > 0) {
    				selectUserURL.setParameter("liferayUserId", String.valueOf(liferayUserId));
    			}
            %>

            selectEventName: '<%= eventName %>',
            selectedData: [document.<portlet:namespace />user.<portlet:namespace />userBranch.value],
            url: '<%= selectUserURL %>'
        });
	});
	
	removeBranch = function(e) {
		var no_branch = document.getElementById('no-branch');
		document.getElementById("branch-row").innerHTML = "";
        document.<portlet:namespace />user.<portlet:namespace />userBranch.value = "";
        document.getElementById("branch-table").classList.add('d-none')
        if(no_branch != null) no_branch.classList.remove('d-none');
	}
</aui:script>

<c:if test="<%= mypageUser != null && Validator.isNull(mypageUser.getCreditWalletId()) %>">
	<aui:script use="liferay-search-container">
	   	var selectCreditWalletButton = document.getElementById('<portlet:namespace />selectCreditWallet');
	   	var searchCreditWalletContainer = Liferay.SearchContainer.get("credit-wallet-table");
	   	var rowColumns = [];
	
	   	selectCreditWalletButton.addEventListener('click', function(event) {
			
	        new Liferay.Util.openSelectionModal({
	            onSelect: function(event) {
	            	var no_credit_wallet = document.getElementById('no-credit-wallet');
	            	var row = `<td>
			                <span>`+event.entityname+`</span>
			            </td>
			            <td>
			                <a onclick="removeCreditWallet(this)" id="remove-credit-wallet" href="javascript:;"><liferay-ui:icon icon="times-circle" markupView="lexicon" /></a>
			            </td>`;
	            	if(no_credit_wallet != null) no_credit_wallet.classList.add('d-none');
	            	document.getElementById("credit-wallet-row").innerHTML = row;
	            	document.<portlet:namespace />user.<portlet:namespace />creditWalletId.value = event.entityid;
	            	document.getElementById("credit-wallet-table").classList.remove('d-none')
	            },
	            title: 'Select Credit Type',
	            <%
	            	String eventName = liferayPortletResponse.getNamespace() + "selectCreditWallet";
	    			PortletURL selectUserURL = PortletProviderUtil.getPortletURL(renderRequest, CreditType.class.getName(), PortletProvider.Action.BROWSE);
	    			selectUserURL.setParameter("mvcPath", "/user_credit/credit_wallet/select_credit_wallet.jsp");
	    			selectUserURL.setParameter("eventName", eventName);
	    			selectUserURL.setWindowState(LiferayWindowState.POP_UP);
	    			if(liferayUserId > 0) {
	    				selectUserURL.setParameter("liferayUserId", String.valueOf(liferayUserId));
	    			}
	            %>
	
	            selectEventName: '<%= eventName %>',
	            selectedData: [document.<portlet:namespace />user.<portlet:namespace />creditWalletId.value],
	            url: '<%= selectUserURL %>'
	        });
		});
		
		removeCreditWallet = function(e) {
			var no_credit_wallet = document.getElementById('no-credit-wallet');
			document.getElementById("credit-wallet-row").innerHTML = "";
	        document.<portlet:namespace />user.<portlet:namespace />creditWalletId.value = "";
	        document.getElementById("credit-wallet-table").classList.add('d-none')
	        if(no_credit_wallet != null) no_credit_wallet.classList.remove('d-none');
		}
	</aui:script>
</c:if>