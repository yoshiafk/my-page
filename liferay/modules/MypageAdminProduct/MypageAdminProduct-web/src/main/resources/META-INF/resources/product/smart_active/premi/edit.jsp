<%@ include file="../includes/init.jsp"%>

<%

	long premiId = ParamUtil.getLong(renderRequest, "premiId", 0);
	SmartActivePremi premi = null;
	
	if (premiId > 0) {
		premi = SmartActivePremiLocalServiceUtil.fetchSmartActivePremi(premiId);
	}
	
	List<SmartActiveBenefit> benefits = SmartActiveBenefitLocalServiceUtil.getActiveBenefit();
	List<SmartActiveClassRate> classRates = SmartActiveClassRateLocalServiceUtil.getActiveClassRate();
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
			<aui:form action="<%= addPremiURL %>" name="premi">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= premiId > 0 ? "Edit Premi" : "Add Premi" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= premiId != 0 && premi != null ? premi.getActive() == 1 ? true : false : true %>"
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
										<aui:input label="Rate" name="rate" type="number" min="0" step="any" 
											required="true" pattern="/^-?\d+\.?\d*$/" value="<%= premi == null ? "" : String.valueOf(premi.getRate()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:select name="benefitId" label="Benefit" required="true">
											<%
												for (int i = 0; i < benefits.size(); i++) {
											%>
											<%
												boolean isSelectedBenefit = false;
												if (premi != null) {
													isSelectedBenefit = benefits.get(i).getSmartActiveBenefitId() == premi.getSmartActiveBenefitId() ? true : false;
												}
												
												String benefitName = benefits.get(i).getNameId();
											    if (benefitName == null || benefitName.isEmpty()) {
											    	benefitName = benefits.get(i).getNameEn();
											    }								
																			
											%>
											<aui:option
												value="<%= benefits.get(i).getSmartActiveBenefitId() %>"
												label="<%= benefitName %>"
												selected="<%= isSelectedBenefit %>" />
											<%
												}
											%>
										</aui:select>
									</aui:col>
									
									<aui:col width="100">
										<aui:select name="classRateId" label="Class Rate" required="true">
											<%
												for (int i = 0; i < classRates.size(); i++) {
											%>
											<%
												boolean isSelectedClassRate = false;
												if (premi != null) {
													isSelectedClassRate = classRates.get(i).getSmartActiveClassRateId() == premi.getSmartActiveClassRateId() ? true : false;
												}
												
												String classRateName = classRates.get(i).getNameId();
											    if (classRateName == null || classRateName.isEmpty()) {
											    	classRateName = classRates.get(i).getNameEn();
											    }								
																			
											%>
											<aui:option
												value="<%= classRates.get(i).getSmartActiveClassRateId() %>"
												label="<%= classRateName %>"
												selected="<%= isSelectedClassRate %>" />
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
						<aui:input type="hidden" name="premiId" value="<%= String.valueOf(premi.getSmartActivePremiId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= premiURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
