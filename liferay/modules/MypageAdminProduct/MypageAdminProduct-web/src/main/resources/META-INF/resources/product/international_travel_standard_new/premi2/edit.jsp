<%@ include file="../includes/init.jsp"%>
<%@ page import="java.text.DecimalFormat" %>

<%

	long premiId = ParamUtil.getLong(renderRequest, "premiId", 0);
	Premi premi = null;
	
	if (premiId > 0) {
		premi = PremiLocalServiceUtil.fetchPremi(premiId);
	}
	
	List<Benefit> benefits = BenefitLocalServiceUtil.getActiveBenefit();
	
	List<SmartTravelIntPlan> plans = SmartTravelIntPlanLocalServiceUtil.getActivePlan();
	
	
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
			<aui:form action="<%=addPremiURL%>" name="premi">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=premiId > 0 ? "Edit Premi" : "Add Premi"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=premiId != 0 && premi != null ? premi.getActive() == 1 ? true : false
						: true%>"
									name="active" type="toggle-switch" value="1" label="Active"
									wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>

					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
							
							<% DecimalFormat df = new DecimalFormat("#.##");
							String basicFormattedValue = "";
							String additionalFormattedValue = "";
							String annualFormattedValue = "";
							if(premi != null) {
								basicFormattedValue = df.format(premi.getBasic());
								additionalFormattedValue = df.format(premi.getAdditional());
								annualFormattedValue = df.format(premi.getAnnual());
							}
							%>

								<aui:row>
									<aui:col width="100">
										<aui:input label="Traveller Type" name="travellerType"
											type="text" required="true"
											value="<%=premi == null ? "" : String.valueOf(premi.getTravellerType())%>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Currency" name="currency"
											type="text" required="true"
											value="<%=premi == null ? "" : String.valueOf(premi.getCurrency())%>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Basic" name="basic" type="text" required="true"
											value="<%=basicFormattedValue%>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Additional" name="additional"
											type="text" required="true"
											value="<%=additionalFormattedValue%>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Annual" name="annual"
											type="text" required="true"
											value="<%=annualFormattedValue%>" />
									</aui:col>
									
									
									<aui:col width="100">
											<aui:select name="benefitId" label="Benefit" required="true">
												<%
													for (int i = 0; i < benefits.size(); i++) {
												%>
												<%
													boolean isSelectedBenefit = false;
																				if (premi != null) {
																					isSelectedBenefit = benefits.get(i)
																							.getBenefitId() == premi.getBenefitId() ? true : false;
																				}
																				
																				String benefitName = benefits.get(i).getNameId();
																			    if (benefitName == null || benefitName.isEmpty()) {
																			    	benefitName = benefits.get(i).getNameEn();
																			    }								
																				
												%>
												<aui:option
													value="<%=benefits.get(i).getBenefitId()%>"
													label="<%= benefitName %>"
													selected="<%=isSelectedBenefit%>" />
												<%
													}
												%>
											</aui:select>
										</aui:col>
										
										<aui:col width="100">
											<aui:select name="planId" label="Plan" required="true">
												<%
													for (int i = 0; i < plans.size(); i++) {
												%>
												<%
													boolean isSelectedPlan = false;
																				if (premi != null) {
																					isSelectedPlan = plans.get(i)
																							.getSmartTravelIntPlanId() == premi.getPlanId() ? true : false;
																				}
																				
																				String planName = plans.get(i).getNameId();
																			    if (planName == null || planName.isEmpty()) {
																			    	planName = plans.get(i).getNameEn();
																			    }								
																				
												%>
												<aui:option
													value="<%=plans.get(i).getSmartTravelIntPlanId()%>"
													label="<%= planName %>"
													selected="<%=isSelectedPlan%>" />
												<%
													}
												%>
											</aui:select>
										</aui:col>
									
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (premi != null) {
						%>
						<aui:input type="hidden" name="premiId"
							value="<%=String.valueOf(premi.getPremiId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=premiURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
