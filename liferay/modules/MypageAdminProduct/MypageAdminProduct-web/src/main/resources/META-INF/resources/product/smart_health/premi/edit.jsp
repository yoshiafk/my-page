<%@ include file="../includes/init.jsp"%>
<%
	long smartHealthPremiId = ParamUtil.getLong(renderRequest, "smartHealthPremiId");
	SmartHealthPremi smartHealthPremi = null;
	List<SmartHealthPlan> smartHealthPlans = null;

	if (smartHealthPremiId > 0) {
		smartHealthPremi = SmartHealthPremiLocalServiceUtil.fetchSmartHealthPremi(smartHealthPremiId);
	}
	
	smartHealthPlans = SmartHealthPlanLocalServiceUtil.getSmartHealthPlans();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "premi";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<aui:form action="<%=addPremiURL%>" name="sHPlan">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=smartHealthPremiId > 0 ? "Edit Premi" : "Add New Premi"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input checked="<%=smartHealthPremiId != 0 && smartHealthPremi != null ? smartHealthPremi.getStatus() == 1 ? true : false : true%>" name="active" type="toggle-switch" value="1" label="Active" wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>

					<!--  START SHEET SECTION -->
					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input label="Age" name="age" type="number" required="true" value="<%=smartHealthPremi == null ? "" : String.valueOf(smartHealthPremi.getAge())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
											<% List<String> genders = Arrays.asList("all", "male", "female"); %>
											<aui:select name="gender" label="Select Gender">
											<% for(String gender : genders) { %>
												<% boolean isSelected = false;%>
												<% if(smartHealthPremi != null) {
													if(smartHealthPremi.getGender().equals(gender)) {
														isSelected = true;
													}
												} %>
												
												<aui:option value="<%= gender %>" label="<%= gender.toUpperCase() %>" selected="<%= isSelected %>"></aui:option>
												
											<% } %>
											</aui:select>
									</aui:col>
									
									<aui:col width="50">
											<% List<String> currencies = Arrays.asList("idr", "usd"); %>
											<aui:select name="currency" label="Select Currency">
											<% for(String currency : currencies) { %>
												<% boolean isSelected = false;%>
												<% if(smartHealthPremi != null) {
													if(smartHealthPremi.getCurrency().equals(currency)) {
														isSelected = true;
													}
												} %>
												
												<aui:option value="<%= currency %>" label="<%= currency.toUpperCase() %>" selected="<%= isSelected %>"></aui:option>
												
											<% } %>
											</aui:select>
									</aui:col>									
								</aui:row>
															
								<aui:row>
									<aui:col width="100">
										<aui:input label="Amount" name="amount" type="text" required="true" value="<%=smartHealthPremi == null ? "" : String.valueOf(smartHealthPremi.getAmount())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
									<aui:select name="planId" label="Plan">
										<% if (smartHealthPlans != null) { %>
											<%for(SmartHealthPlan smartHealthPlan : smartHealthPlans) { %>
											<aui:option value="<%= smartHealthPlan.getSmartHealthPlanId() %>" label="<%= smartHealthPlan.getPlanName()%>"></aui:option>
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
								</aui:row>										
								

								<aui:button-row>
									<aui:button name="submitButton" type="submit" value="Save" />
									<aui:button type="cancel" onClick="<%=premiURL.toString()%>"></aui:button>
								</aui:button-row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (smartHealthPremi != null) {
						%>
						<aui:input type="hidden" name="smartHealthPremiId"
							value="<%=String.valueOf(smartHealthPremi.getSmartHealthPremiId())%>" />
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