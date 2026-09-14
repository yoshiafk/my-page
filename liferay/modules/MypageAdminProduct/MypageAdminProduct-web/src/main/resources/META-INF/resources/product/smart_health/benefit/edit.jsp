<%@ include file="../includes/init.jsp"%>
<%
	List<SmartHealthBenefitGroup> _smartHealthBenefitGroup = null;
	_smartHealthBenefitGroup = SmartHealthBenefitGroupLocalServiceUtil.getSmartHealthBenefitGroups();
	
	List<SmartHealthPlan> _smartHealthPlan = null;
	_smartHealthPlan = SmartHealthPlanLocalServiceUtil.getSmartHealthPlans();

	long smartHealthBenefitId = ParamUtil.getLong(renderRequest, "smartHealthBenefitId");
	SmartHealthBenefit smartHealthBenefit = null;

	if (smartHealthBenefitId > 0) {
		smartHealthBenefit = SmartHealthBenefitLocalServiceUtil.fetchSmartHealthBenefit(smartHealthBenefitId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "benefit";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<aui:form action="<%=addBenefitURL%>" name="sHBenefit">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=smartHealthBenefitId > 0 ? "Edit Benefit" : "Add New Benefit"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=smartHealthBenefitId != 0 && smartHealthBenefit != null
						? smartHealthBenefit.getActive() == 1 ? true : false
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
										<aui:input label="Benefit Title" name="benefitTitle" type="text" required="true"
											value="<%=smartHealthBenefit == null ? "" : String.valueOf(smartHealthBenefit.getBenefitTitle())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="100">
										<aui:input label="Benefit Content" name="benefitContent" type="textarea"
											value="<%=smartHealthBenefit == null ? ""
										: String.valueOf(smartHealthBenefit.getBenefitContent())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
									<aui:select name="smartHealthBenefitGroupId" label="Benefit Group">
										<% if (_smartHealthBenefitGroup != null) { %>
											<%for(SmartHealthBenefitGroup smartHealthBenefitGroup : _smartHealthBenefitGroup) { %>
											<aui:option value="<%= smartHealthBenefitGroup.getSmartHealthBenefitGroupId() %>" label="<%= smartHealthBenefitGroup.getGroupName()%>"></aui:option>
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
									<aui:select name="smartHealthplanId" label="Plan">
										<% if (_smartHealthPlan != null) { %>
											<%for(SmartHealthPlan smartHealthPlan : _smartHealthPlan) { %>
											<aui:option value="<%= smartHealthPlan.getSmartHealthPlanId() %>" label="<%= smartHealthPlan.getPlanName()%>"></aui:option>
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
								</aui:row>

								<aui:button-row>
									<aui:button name="submitButton" type="submit" value="Save" />
									<aui:button type="cancel" onClick="<%=benefitURL.toString()%>"></aui:button>
								</aui:button-row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (smartHealthBenefit != null) {
						%>
						<aui:input type="hidden" name="smartHealthBenefitId" value="<%=String.valueOf(smartHealthBenefit.getSmartHealthBenefitId())%>" />
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