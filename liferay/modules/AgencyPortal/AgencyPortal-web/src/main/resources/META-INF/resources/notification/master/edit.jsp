<%@ include file="includes/init.jsp"%>

<%
	long agentNotificationId = ParamUtil.getLong(renderRequest, "agentNotificationId", 0);
	AgentNotification agentNotification = null;
	List<MypageUserRole> mypageUserRole = MypageUserRoleLocalServiceUtil.getActiveRole();
	List<MypageUserGroup> mypageUserGroup = MypageUserGroupLocalServiceUtil.getActiveGroup();

	if (agentNotificationId > 0) {
		agentNotification = AgentNotificationLocalServiceUtil.fetchAgentNotification(agentNotificationId);
	}
%>

<fmt:formatDate value="<%= agentNotification == null ? null : agentNotification.getStartDate() %>" pattern="yyyy-MM-dd" var="formattedStartDate" />
<fmt:formatDate value="<%= agentNotification == null ? null : agentNotification.getEndDate() %>" pattern="yyyy-MM-dd" var="formattedEndDate" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "calendar";
			%>
			<%@ include file="includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addAgentNotificationURL%>" name="calendar">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="tag" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=agentNotificationId > 0 ? "Edit Notification" : "Add New Notification"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= agentNotificationId != 0 && agentNotification != null ? agentNotification.getActive() == 1 ? true : false : true %>" name="active"
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
										<aui:input label="Title" name="title" type="text"
											required="true"
											value="<%=agentNotification == null ? "" : String.valueOf(agentNotification.getTitle())%>" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="100">
										<aui:input label="Location" name="location" type="text"
											value="<%=agentNotification == null ? "" : String.valueOf(agentNotification.getLocation())%>" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="100">
										<aui:input label="Address" name="address" type="text"
											value="<%=agentNotification == null ? "" : String.valueOf(agentNotification.getAddress())%>" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="100">
										<aui:select label="Show Notification By" name="showNotificationBy" required="true">
											<aui:option value="">Select</aui:option>
											<aui:option selected="<%= agentNotification == null ? false : Validator.isNotNull(agentNotification.getRole()) %>" value="role">User Role</aui:option>
											<aui:option selected="<%= agentNotification == null ? false : Validator.isNotNull(agentNotification.getGroup()) %>" value="group">User Group</aui:option>
										</aui:select>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="100">
										<div class="role-wrapper <%= agentNotification != null && Validator.isNotNull(agentNotification.getRole()) ? "" : "d-none" %>">
											<aui:select label="Recipient" name="role">
												<option value="">Select Recipient</option>
												<% if (mypageUserRole.size() > 0) {  %>
											    	<% for (int i = 0; i < mypageUserRole.size(); i++) { %>
											    		<aui:option selected="<%= agentNotification == null ? false : agentNotification.getRole().equalsIgnoreCase(mypageUserRole.get(i).getName()) %>" value="<%= mypageUserRole.get(i).getMypageUserRoleId() %>"><%= mypageUserRole.get(i).getName() %></aui:option>
											    	<% } %>
												<% } %>
											</aui:select>
										</div>
										<div class="group-wrapper <%= agentNotification != null && Validator.isNotNull(agentNotification.getGroup()) ? "" : "d-none" %>">
											<aui:select label="Recipient" name="group">
												<aui:option value="">Select Recipient</aui:option>
												<% if (mypageUserGroup.size() > 0) {  %>
											    	<% for (int i = 0; i < mypageUserGroup.size(); i++) { %>
											    		<aui:option selected="<%= agentNotification == null ? false : agentNotification.getGroup().equalsIgnoreCase(mypageUserGroup.get(i).getName()) %>" value="<%= mypageUserGroup.get(i).getMypageUserGroupId() %>"><%= mypageUserGroup.get(i).getName() %></aui:option>
											    	<% } %>
												<% } %>
											</aui:select>
										</div>
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="100">
										<aui:input checked="<%= agentNotificationId != 0 && agentNotification != null ? agentNotification.getIsAllDay() == 1 ? true : false : false %>" name="isAllDay"
											type="toggle-switch" label="Is All Day"
											wrapperCssClass="leftToggleTitle" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="50">
										<aui:input label="Start Date" name="startDate" type="date"
											required="true" 
											value="${formattedStartDate}">
											<aui:validator name="custom" errorMessage="Start date cannot be before Today">
												function (val, fieldNode, ruleValue) {
													var startDateObj = new Date(val);
													startDateObj.setHours(0);
													startDateObj.setMinutes(0);
													startDateObj.setSeconds(0);
													startDateObj.setMilliseconds(0);
													var todayObj = new Date();
													todayObj.setHours(0);
													todayObj.setMinutes(0);
													todayObj.setSeconds(0);
													todayObj.setMilliseconds(0);
													
													if ((startDateObj.getTime() / 1000) < Math.floor(todayObj.getTime() / 1000)) {
														return false;
													}
													
													return true;
												}
											</aui:validator>
											<aui:validator name="custom" errorMessage="Start date must be before End date">
												function (val, fieldNode, ruleValue) {
													var endDate = $('#<portlet:namespace />endDate').val();
													var startDateObj = new Date(val);
													startDateObj.setHours(0);
													startDateObj.setMinutes(0);
													startDateObj.setSeconds(0);
													startDateObj.setMilliseconds(0);
	       											var endDateObj = new Date(endDate);
	       											endDateObj.setHours(0);
													endDateObj.setMinutes(0);
													endDateObj.setSeconds(0);
													endDateObj.setMilliseconds(0);
													
													if (!isNaN((endDateObj.getTime() / 1000))) {
														if ((startDateObj.getTime() / 1000) > (endDateObj.getTime() / 1000)) {
															return false;
														}
													}
													
													return true;
												}
											</aui:validator>
										</aui:input>
									</aui:col>
									<aui:col width="50">
										<aui:input label="Start Time" name="startTime" type="time"
											value="<%=agentNotification == null ? "" : String.valueOf(agentNotification.getStartTime())%>"
											disabled="<%= agentNotification == null ? false : agentNotification.getIsAllDay() == 1 ? true : false %>" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="50">
										<aui:input label="End Date" name="endDate" type="date"
											required="true"  
											value="${formattedEndDate}">
											<aui:validator name="custom" errorMessage="End date cannot be before Today">
												function (val, fieldNode, ruleValue) {
													var endDateObj = new Date(val);
													endDateObj.setHours(0);
													endDateObj.setMinutes(0);
													endDateObj.setSeconds(0);
													endDateObj.setMilliseconds(0);
													var todayObj = new Date();
													todayObj.setHours(0);
													todayObj.setMinutes(0);
													todayObj.setSeconds(0);
													todayObj.setMilliseconds(0);
													
													if ((endDateObj.getTime() / 1000) < Math.floor(todayObj.getTime() / 1000)) {
														return false;
													}
													
													return true;
												}
											</aui:validator>
											<aui:validator name="custom" errorMessage="End date must be after Start date">
												function (val, fieldNode, ruleValue) {
													var startDate = $('#<portlet:namespace />startDate').val();
													var startDateObj = new Date(startDate);
													startDateObj.setHours(0);
													startDateObj.setMinutes(0);
													startDateObj.setSeconds(0);
													startDateObj.setMilliseconds(0);
	       											var endDateObj = new Date(val);
	       											endDateObj.setHours(0);
													endDateObj.setMinutes(0);
													endDateObj.setSeconds(0);
													endDateObj.setMilliseconds(0);
													
													if (!isNaN((startDateObj.getTime() / 1000))) {
														if ((startDateObj.getTime() / 1000) > (endDateObj.getTime() / 1000)) {
															return false;
														}
													}
													
													return true;
												}
											</aui:validator>
										</aui:input>
									</aui:col>
									<aui:col width="50">
										<aui:input label="End Time" name="endTime" type="time"
											value="<%=agentNotification == null ? "" : String.valueOf(agentNotification.getEndTime())%>"
											disabled="<%= agentNotification == null ? false : agentNotification.getIsAllDay() == 1 ? true : false %>" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="100">
										<aui:input label="Description" name="description" type="text"
											required="true"
											value="<%=agentNotification == null ? "" : String.valueOf(agentNotification.getDescription())%>" />
									</aui:col>
									<%-- <aui:col width="100" cssClass="mb-4">
										<liferay-editor:editor 
								            contents="<%= agentNotification == null ? "" : String.valueOf(agentNotification.getDescription()) %>" 
											cssClass="product-admin-editor" 
								            editorName="ckeditor" 
								            name="description" 
								            placeholder="description" 
								            required="true" 
								            showSource="true"
								        />
									</aui:col> --%>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="Link" name="link" type="text"
											required="true"
											value="<%=agentNotification == null ? "" : String.valueOf(agentNotification.getLink())%>" />
									</aui:col>
								</aui:row>
								
								<%-- <% if (agentNotificationId > 0 && Validator.isNotNull(agentNotification.getFileUploadUrl())) { %>
									<aui:row>
										<aui:col width="100">
											<aui:input label="Source File" name="fileUrl" type="text" disabled="true" 
											value="<%=agentNotification == null ? "" : String.valueOf(agentNotification.getFileUploadUrl())%>" />
										</aui:col>
									</aui:row>
								<% } %>
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="File" name="file" type="file">
											<aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
										</aui:input>
									</aui:col>
								</aui:row> --%>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (agentNotification != null) {
						%>
						<aui:input type="hidden" name="agentNotificationId"
							value="<%=String.valueOf(agentNotification.getAgentNotificationId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=agentNotificationURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

<aui:script>
	var inputTitle = $('#<portlet:namespace />title');
	var roleValue = $('#<portlet:namespace />role');
	var groupValue = $('#<portlet:namespace />group');
	var role = $('.role-wrapper');
	var group = $('.group-wrapper');
	var toggler = $('#<portlet:namespace />isAllDay');
	var labelStartTime = $('label[for="<portlet:namespace />startTime"]');
	var startTime = $('#<portlet:namespace />startTime');
	var labelEndTime = $('label[for="<portlet:namespace />endTime"]');
	var endTime = $('#<portlet:namespace />endTime');
	var notificationBy = $('#<portlet:namespace />showNotificationBy');
	
	startTime.prop('required', true);
	endTime.prop('required', true);
	
	inputTitle.keyup(function(event) {
		let input = event.target
		const regex = new RegExp(/^[A-Za-z0-9 ]+$/)
		const isValidInput = regex.test(input.value);
		
	  	if (!isValidInput) {
			input.value = input.value.slice(0, -1);
		}
	})
	
    toggler.change(function(event) {
        if (event.target.checked) {
        	labelStartTime.addClass('disabled');
            startTime.prop('disabled', true);
            labelEndTime.addClass('disabled');
            endTime.prop('disabled', true);
            startTime.removeAttr('required');
            endTime.removeAttr('required');
            toggler.val(true);
            startTime.val('');
            endTime.val('');
        } else {
        	labelStartTime.removeClass('disabled');
        	startTime.removeClass('disabled');
            labelEndTime.removeClass('disabled');
            endTime.removeClass('disabled');
            startTime.prop('disabled', false);
            endTime.prop('disabled', false);
            startTime.prop('required', true);
            endTime.prop('required', true);
            toggler.val(false);
        }
    });
    
    notificationBy.change(function(event) {
    	if (event.target.value == "role") {
    		role.removeClass("d-none");
    		roleValue.prop('required', true);
    		group.addClass("d-none");
    		groupValue.removeAttr('required');
    		groupValue.val(0);
    	}
    	
    	if (event.target.value == "group") {
    		group.removeClass("d-none");
    		groupValue.prop('required', true);
    		role.addClass("d-none");
    		roleValue.removeAttr('required');
    		roleValue.val(0);
    	}
    });
</aui:script>