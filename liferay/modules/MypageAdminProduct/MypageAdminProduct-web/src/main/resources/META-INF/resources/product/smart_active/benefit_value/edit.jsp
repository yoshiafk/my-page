<%@ include file="../includes/init.jsp"%>

<%
	long benefitValueId = ParamUtil.getLong(renderRequest, "benefitValueId", 0);
	SmartActiveBenefitValue benefitValue = null;
	
	if (benefitValueId > 0) {
		benefitValue = SmartActiveBenefitValueLocalServiceUtil.fetchSmartActiveBenefitValue(benefitValueId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "benefit_value";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addBenefitValueURL %>" name="benefitValue">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= benefitValueId > 0 ? "Edit Benefit Value" : "Add Benefit Value" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= benefitValueId != 0 && benefitValue != null ? benefitValue.getActive() == 1 ? true : false : true %>"
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
										<aui:input label="Benefit Value" name="value" type="number" min="0" value="<%= benefitValue == null ? "" : String.valueOf(benefitValue.getValue()) %>" required="true" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (benefitValue != null) {
						%>
						<aui:input type="hidden" name="benefitValueId" value="<%= String.valueOf(benefitValue.getSmartActiveBenefitValueId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= benefitValueURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
