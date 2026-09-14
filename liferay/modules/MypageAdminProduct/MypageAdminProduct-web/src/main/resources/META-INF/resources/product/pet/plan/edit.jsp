<%@ include file="../includes/init.jsp"%>

<%
	long petPlanId = ParamUtil.getLong(renderRequest, "petPlanId");
	PetPlan petPlan = null;
	boolean recommendedCheckStatus = false;
	boolean customPlanCheckStatus = false;

	if (petPlanId > 0) {
		petPlan = PetPlanLocalServiceUtil.fetchPetPlan(petPlanId);
	}
%>

<%
	if (petPlan != null) {
		recommendedCheckStatus = String.valueOf(petPlan.getRecommended()).equals("1") ? true : false;
		customPlanCheckStatus = String.valueOf(petPlan.getCustomPlan()).equals("1") ? true : false;
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

			<aui:form action="<%=addPlanURL%>" name="pet">

				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=petPlanId > 0 ? "Edit Plan" : "Add New Plan"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=petPlanId != 0 && petPlan != null ? petPlan.getActive() == 1 ? true : false : true%>"
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
										<aui:input label="Plan Name" name="planName" type="text"
											required="true"
											value="<%=petPlan == null ? "" : String.valueOf(petPlan.getName())%>" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="50">
										<aui:input label="Limit Disability" name="limitDisability"
											type="number"
											value="<%=petPlan == null ? "" : String.valueOf(petPlan.getLimitDisability())%>" />
									</aui:col>
									<aui:col width="50">
										<aui:input label="Limit Medical" name="limitMedical"
											type="number"
											value="<%=petPlan == null ? "" : String.valueOf(petPlan.getLimitMedical())%>" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="50">
										<aui:input label="Limit Third Party" name="limitThirdParty"
											type="number"
											value="<%=petPlan == null ? "" : String.valueOf(petPlan.getLimitThirdParty())%>" />
									</aui:col>
									<aui:col width="50">
										<aui:input label="Limit Custody" name="limitCustody"
											type="number"
											value="<%=petPlan == null ? "" : String.valueOf(petPlan.getLimitCustody())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Pimcore Plan ID" name="pimcorePlanId"
											type="number"
											value="<%=petPlan == null ? "" : String.valueOf(petPlan.getPimcorePlanId())%>" />
									</aui:col>
								</aui:row>								

								<aui:row>
									<aui:col width="100">
										<aui:input label="Benefit" name="benefit" type="textarea"
											value="<%=petPlan == null ? "" : String.valueOf(petPlan.getBenefit())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col>
										<aui:input name="isRecommended" type="checkbox"
											label="Recommended" checked="<%=recommendedCheckStatus%>" />
										<aui:input name="customPlan" type="checkbox"
											label="Custom Plan" checked="<%=customPlanCheckStatus%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (petPlan != null) {
						%>
						<aui:input type="hidden" name="petPlanId"
							value="<%=String.valueOf(petPlan.getPetPlanId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=planURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
