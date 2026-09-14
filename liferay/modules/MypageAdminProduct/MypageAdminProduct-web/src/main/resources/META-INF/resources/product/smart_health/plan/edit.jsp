<%@ include file="../includes/init.jsp"%>
<%
	long smartHealthPlanId = ParamUtil.getLong(renderRequest, "smartHealthPlanId");
	SmartHealthPlan smartHealthPlan = null;
	boolean recommendedCheckStatus = false;

	if (smartHealthPlanId > 0) {
		smartHealthPlan = SmartHealthPlanLocalServiceUtil.fetchSmartHealthPlan(smartHealthPlanId);
	}
	
	if(smartHealthPlan != null) {
		recommendedCheckStatus = String.valueOf(smartHealthPlan.getIsRecommended()).equals("1") ? true : false;
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "plan";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<aui:form action="<%=addPlanURL%>" name="sHPlan">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=smartHealthPlanId > 0 ? "Edit Plan" : "Add New Plan"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=smartHealthPlanId != 0 && smartHealthPlan != null
						? smartHealthPlan.getActive() == 1 ? true : false
						: true%>"
									name="active" type="toggle-switch" value="1" label="Active"
									wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>

					<!--  START SHEET SECTION -->
					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input label="Plan Name" name="planName" type="text" required="true"
											value="<%=smartHealthPlan == null ? "" : String.valueOf(smartHealthPlan.getPlanName())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
											<% List<String> groupNames = Arrays.asList("D", "E", "F"); %>
											<aui:select name="planGroup" label="Plan Group">
											<% for(String groupName : groupNames) { %>
												<% boolean isSelected = false;%>
												<% if(smartHealthPlan != null) {
													if(smartHealthPlan.getPlanGroup().equals(groupName)) {
														isSelected = true;
													}
												} %>
												
												<aui:option value="<%= groupName %>" label="<%= groupName %>" selected="<%= isSelected %>"></aui:option>
												
											<% } %>
											</aui:select>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col>
										<aui:input name="isRecommended" type="checkbox" label="Recommended" checked="<%=recommendedCheckStatus%>" />
									</aui:col>
								</aui:row>										

								<aui:button-row>
									<aui:button name="submitButton" type="submit" value="Save" />
									<aui:button type="cancel" onClick="<%=planURL.toString()%>"></aui:button>
								</aui:button-row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (smartHealthPlan != null) {
						%>
						<aui:input type="hidden" name="smartHealthPlanId"
							value="<%=String.valueOf(smartHealthPlan.getSmartHealthPlanId())%>" />
						<%
							}
						%>

					</div>
					<!--  END SHEET SECTION -->

				</div>
			</aui:form>
		</div>

	</div>
</div>