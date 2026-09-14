<%@ include file="../includes/init.jsp"%>

<%
	List<PetPlan> petPlan = PetPlanLocalServiceUtil.getPetPlans();
	List<PetRemarks> petRemarks = PetRemarksLocalServiceUtil.getPetRemarks();

	long petRateId = ParamUtil.getLong(renderRequest, "petRateId", 0);
	PetRate petRate = null;

	if (petRateId > 0) {
		petRate = PetRateLocalServiceUtil.fetchPetRate(petRateId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				String _active = "rate";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%=addRateURL%>" name="petRate">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=petRateId > 0 ? "Edit rate" : "Add New Rate"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=petRateId != 0 && petRate != null ? petRate.getActive() == 1 ? true : false : true%>"
									name="active" type="toggle-switch" value="1" label="Active"
									wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>

					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="50">

										<aui:select name="petPlanId" label="Plan ID">
											<%
												for (int i = 0; i < petPlan.size(); i++) {
											%>
											<%
												boolean isSelected = false;
																			if (petRate != null) {
																				isSelected = petPlan.get(i).getPetPlanId() == petRate.getPetPlan() ? true
																						: false;
																			}
											%>
											<aui:option value="<%=petPlan.get(i).getPetPlanId()%>"
												label="<%=petPlan.get(i).getName()%>"
												selected="<%=isSelected%>" />
											<%
												}
											%>
										</aui:select>
									</aui:col>
									<aui:col width="50">
										<aui:select name="petRemarksId" label="Remarks">
											<%
												for (int i = 0; i < petRemarks.size(); i++) {
											%>
											<%
												boolean isSelectedRemarks = false;
																			if (petRate != null) {
																				isSelectedRemarks = petRemarks.get(i).getPetRemarksId() == petRate
																						.getPetRemarks() ? true : false;
																			}
											%>
											<aui:option value="<%=petRemarks.get(i).getPetRemarksId()%>"
												label="<%=petRemarks.get(i).getName()%>"
												selected="<%=isSelectedRemarks%>" />
											<%
												}
											%>
										</aui:select>
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="100">
										<aui:input label="Rate" name="petRate" type="text"
											required="true"
											value="<%=petRate == null ? "" : String.valueOf(petRate.getRate())%>" />
									</aui:col>
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (petRate != null) {
						%>
						<aui:input type="hidden" name="petRateId"
							value="<%=String.valueOf(petRate.getPetRateId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=rateURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
