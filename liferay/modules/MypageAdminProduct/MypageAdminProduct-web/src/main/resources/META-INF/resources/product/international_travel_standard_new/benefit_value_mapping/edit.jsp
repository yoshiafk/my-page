<%@ include file="../includes/init.jsp"%>

<%

	//List<BenefitType> benefitTypes = BenefitTypeLocalServiceUtil.getActiveBenefitType();
	long benefitValueMappingId = ParamUtil.getLong(renderRequest, "benefitValueMappingId", 0);
	BenefitValueMapping benefitValueMapping = null;
	
	if (benefitValueMappingId > 0) {
		benefitValueMapping = BenefitValueMappingLocalServiceUtil.fetchBenefitValueMapping(benefitValueMappingId);
	}
	
	List<SmartTravelIntPlan> plans = SmartTravelIntPlanLocalServiceUtil.getPlans();
	List<BenefitType> benefitTypes = BenefitTypeLocalServiceUtil.getBenefitTypes();
	List<Benefit> benefits = BenefitLocalServiceUtil.getBenefits();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "benefit_value_mapping";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%=addBenefitValueMappingURL%>" name="benefitValueMapping">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=benefitValueMappingId > 0 ? "Edit Benefit Value Mapping" : "Add Benefit Value Mapping"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=benefitValueMappingId != 0 && benefitValueMapping != null ? benefitValueMapping.getActive() == 1 ? true : false : true%>"
									name="active" type="toggle-switch" value="1" label="Active"
									wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>

					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">

								<aui:row>
								
								<aui:col width="100">
									<aui:select name="planId" label="Plan" required="true">
									<% if (plans != null && plans.size() > 0) { %>
										<% for (int i = 0; i < plans.size(); i++) { %>
										
										<% boolean isSelected = false;
										if (benefitValueMapping != null) {
											isSelected = plans.get(i).getSmartTravelIntPlanId() == benefitValueMapping.getPlanId() ? true : false; 
										} %>
										
											<aui:option value="<%=plans.get(i).getSmartTravelIntPlanId()%>" label="<%= plans.get(i).getNameId() %>" selected="<%=isSelected%>" />
											<% } %>
									<% } %>
										</aui:select>
									</aui:col>
									</aui:row>
									
									<aui:row>
									<aui:col width="100">
										<aui:select name="benefitTypeId" label="Benefit Type" required="true">
										<% if (benefitTypes != null && benefitTypes.size() > 0) { %>
											<% for (int i = 0; i < benefitTypes.size(); i++) { %>
											
																					<% boolean isSelected = false;
										if (benefitValueMapping != null) {
											isSelected = benefitTypes.get(i).getBenefitTypeId() == benefitValueMapping.getBenefitTypeId() ? true : false; 
										} %>
										
												<aui:option value="<%=benefitTypes.get(i).getBenefitTypeId()%>" label="<%= benefitTypes.get(i).getNameId() %>" selected="<%=isSelected%>" />
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
									
									</aui:row>
									
									<aui:row>
									<aui:col width="100">
										<aui:select name="benefitId" label="Benefit Name" required="true">
										<% if (benefits != null && benefits.size() > 0) { %>
											<% for (int i = 0; i < benefits.size(); i++) { %>
											
																																<% boolean isSelected = false;
										if (benefitValueMapping != null) {
											isSelected = benefits.get(i).getBenefitId() == benefitValueMapping.getBenefitId() ? true : false; 
										} %>
										
												<aui:option value="<%=benefits.get(i).getBenefitId()%>" label="<%= benefits.get(i).getNameId() %>" selected="<%=isSelected%>" />
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
									</aui:row>

									<aui:row>
									<aui:col width="100">
										<aui:input label="Benefit Value" name="benefitValue" type="textarea" value="<%=benefitValueMapping == null ? "" : String.valueOf(benefitValueMapping.getBenefitValue())%>" required="true" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Benefit Value USD" name="benefitValueUSD" type="textarea" value="<%=benefitValueMapping == null ? "" : String.valueOf(benefitValueMapping.getBenefitValueUSD())%>" required="true" />
									</aui:col>
								</aui:row>
									
								

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (benefitValueMapping != null) {
						%>
						<aui:input type="hidden" name="benefitValueMappingId" value="<%=String.valueOf(benefitValueMapping.getBenefitValueMappingId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=benefitValueMappingURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
