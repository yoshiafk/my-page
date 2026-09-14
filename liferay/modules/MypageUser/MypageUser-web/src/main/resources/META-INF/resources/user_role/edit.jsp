<%@ include file="../includes/init.jsp"%>

<%
	long mypageUserRoleId = ParamUtil.getLong(renderRequest, "mypageUserRoleId", 0);
	MypageUserRole mypageUserRole = null;

	if (mypageUserRoleId > 0) {
		mypageUserRole = MypageUserRoleLocalServiceUtil.fetchMypageUserRole(mypageUserRoleId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "user_role";
			%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addUserRoleURL%>" name="userRole">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="tag" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=mypageUserRoleId > 0 ? "Edit User Role" : "Add New User Role"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= mypageUserRoleId != 0 && mypageUserRole != null ? mypageUserRole.getActive() == 1 ? true : false : true %>" name="active"
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
											value="<%=mypageUserRole == null ? "" : String.valueOf(mypageUserRole.getName())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (mypageUserRole != null) {
						%>
						<aui:input type="hidden" name="mypageUserRoleId"
							value="<%=String.valueOf(mypageUserRole.getMypageUserRoleId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=userRoleURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
