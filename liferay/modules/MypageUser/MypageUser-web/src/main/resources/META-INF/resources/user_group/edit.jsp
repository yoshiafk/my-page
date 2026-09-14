<%@ include file="../includes/init.jsp"%>

<%
	//Display Context
	MypageUserDisplayContext mypageUserDisplayContext = new MypageUserDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	long mypageUserGroupId = ParamUtil.getLong(renderRequest, "mypageUserGroupId", 0);
	MypageUserGroup mypageUserGroup = null;
	List<MypageUser> mypageUsers = new ArrayList<>();

	if (mypageUserGroupId > 0) {
		mypageUserGroup = MypageUserGroupLocalServiceUtil.findBymypageUserGroupId(mypageUserGroupId);
		mypageUsers = mypageUserDisplayContext.getUsers(mypageUserGroupId);
	}
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

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "user_group";
			%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addUserGroupURL%>" name="userGroup">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="tag" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=mypageUserGroupId > 0 ? "Edit User Group" : "Add New User Group"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= mypageUserGroupId != 0 && mypageUserGroup != null ? mypageUserGroup.getActive() == 1 ? true : false : true %>" name="active"
								type="toggle-switch" value="1" label="Active"
								wrapperCssClass="leftToggleTitle" />
						</div>
					</div>
				</h2>

				<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input label="Name" name="name" type="text"
											required="true"
											value="<%=mypageUserGroup == null ? "" : String.valueOf(mypageUserGroup.getName())%>" />
									</aui:col>
								</aui:row>
								
								<clay:content-row
								    containerElement="h3"
								    cssClass="sheet-subtitle"
								    >
								    <clay:content-col expand="<%= true %>">
								        <span class="heading-text">
								            User
								        </span>
								    </clay:content-col>
								    <clay:content-col>
								        <span class="heading-end">
								            <liferay-ui:icon
								                cssClass="add-user"
								                id="selectUser"
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
									<%
										String result = "";
										if (Validator.isNotNull(mypageUsers)) {
											String[] arrMypageUserId = mypageUsers.stream()
								                                    	.map(v -> Long.toString(v.getMypageUserId()))
								                                    	.toArray(String[]::new);
								
									        result = String.join(",", arrMypageUserId);
										}
									%>
									<aui:input 
									    name="mypageUserId" 
									    type="hidden"
									    value="<%= Validator.isNull(result) ? "" : result %>"
									     />
									<aui:col width="100">
									    <p id="no-user" class="text-muted pb-4 <%= mypageUsers.size() == 0 ? "" : "d-none" %>">
									        list of user
									    </p>
									    
									    <table 
									        class="show-quick-actions-on-hover table table-autofit table-heading-nowrap table-list mb-4 <%= mypageUsers.size() == 0 ? "d-none" : "" %>" 
									        id="user-table"
									    >
									        <thead>
									            <tr>
									            	<th class="lfr-title-column">Code</th>
									                <th class="lfr-title-column">Full Name</th>
									                <th class="lfr-entry-action-column"> &nbsp; </th>
									            </tr>
									        </thead>
									        <tbody id="user-table-body">
									        	<% if (Validator.isNotNull(mypageUsers)) { %>
													<% for (MypageUser item : mypageUsers) { %>
											            <tr id="user-row-<%= item.getMypageUserId() %>">
											                <td>
																<span><%= item.getCode() %></span>
															</td>
											                <td>
											                    <span><%= item.getUserName() %></span>
											                </td>
											                <td>
											                    <a onclick="removeUser(this)" data-id="<%= item.getMypageUserId() %>" id="remove-user" href="javascript:;">
											                        <%= removeLicenseIcon %>
											                    </a>
											                </td>
											            </tr>
											    	<% } %>
												<% } %>
									        </tbody>
									    </table>
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (mypageUserGroup != null) {
						%>
						<aui:input type="hidden" name="mypageUserGroupId"
							value="<%=String.valueOf(mypageUserGroup.getMypageUserGroupId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=userGroupURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

<aui:script use="liferay-search-container">
   	var selectUserButton = document.getElementById('<portlet:namespace />selectUser');
   	var searchContainer = Liferay.SearchContainer.get("user-table");
   	var rowColumns = [];
	
   	selectUserButton.addEventListener('click', function(event) {
		
        new Liferay.Util.openSelectionModal({
            onSelect: function(event) {
            	var no_user = document.getElementById('no-user');
            	var row = `
            		<tr id="user-row-`+event.entityid+`">
	            		<td>
			                <span>`+event.entitycode+`</span>
			            </td>
	            		<td>
			                <span>`+event.entityname+`</span>
			            </td>
			            <td>
			                <a onclick="removeUser(this)" data-id="`+ event.entityid +`" id="remove-user" href="javascript:;"><%= UnicodeFormatter.toString(removeLicenseIcon) %></a>
			            </td>
		            </tr>`;
		            
            	if(no_user != null) no_user.classList.add('d-none');
            	var currentValues = document.<portlet:namespace />userGroup.<portlet:namespace />mypageUserId.value ? document.<portlet:namespace />userGroup.<portlet:namespace />mypageUserId.value.split(',') : []
            	if (!currentValues.includes(event.entityid)) {
            		document.getElementById("user-table-body").innerHTML += row;
            		currentValues.push(event.entityid);
            	}
            	document.<portlet:namespace />userGroup.<portlet:namespace />mypageUserId.value = currentValues.join(',');
            	document.getElementById("user-table").classList.remove('d-none')
            },
            title: 'Select User',
            <%
            	String eventName = liferayPortletResponse.getNamespace() + "selectMypageUser";
    			PortletURL selectUserURL = PortletProviderUtil.getPortletURL(renderRequest, MypageUser.class.getName(), PortletProvider.Action.BROWSE);
    			selectUserURL.setParameter("mvcPath", "/user_group/select_user.jsp");
    			selectUserURL.setParameter("eventName", eventName);
    			selectUserURL.setWindowState(LiferayWindowState.POP_UP);
            %>

            selectEventName: '<%= eventName %>',
            selectedData: [document.<portlet:namespace />userGroup.<portlet:namespace />mypageUserId.value],
            url: '<%= selectUserURL %>'
        });
	});
	
	removeUser = function(e) {
		var no_user = document.getElementById('no-user');
		var data_id = e.dataset.id;
		document.getElementById("user-row-" + data_id + "").remove();
		var valueArray = document.<portlet:namespace />userGroup.<portlet:namespace />mypageUserId.value.split(',');
		var indexToRemove = valueArray.indexOf(data_id);
		if (indexToRemove !== -1) {
		    valueArray.splice(indexToRemove, 1);
		}
        document.<portlet:namespace />userGroup.<portlet:namespace />mypageUserId.value = valueArray.join(',');
        if (!document.<portlet:namespace />userGroup.<portlet:namespace />mypageUserId.value) {
	        document.getElementById("user-table").classList.add('d-none')
	        if(no_user != null) no_user.classList.remove('d-none');
		}
	}
</aui:script>