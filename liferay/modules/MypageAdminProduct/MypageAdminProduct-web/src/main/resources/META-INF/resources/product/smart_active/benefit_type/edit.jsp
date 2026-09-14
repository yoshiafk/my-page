<%@ include file="../includes/init.jsp"%>

<%
	long benefitTypeId = ParamUtil.getLong(renderRequest, "benefitTypeId", 0);
	SmartActiveBenefitType benefitType = null;
	
	if (benefitTypeId > 0) {
		benefitType = SmartActiveBenefitTypeLocalServiceUtil.fetchSmartActiveBenefitType(benefitTypeId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "benefit_type";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addBenefitTypeURL %>" name="benefitType">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= benefitTypeId > 0 ? "Edit Benefit Type" : "Add Benefit Type" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= benefitTypeId != 0 && benefitType != null ? benefitType.getActive() == 1 ? true : false : true %>"
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
										<aui:input label="Name (Indonesia)" name="nameId"
											type="text" required="true"
											value="<%= benefitType == null ? "" : String.valueOf(benefitType.getNameId()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Name (English)" name="nameEn"
											type="text" required="true"
											value="<%= benefitType == null ? "" : String.valueOf(benefitType.getNameEn()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Sort" name="sort"
											type="number" required="false"
											value="<%= benefitType == null ? "" : String.valueOf(benefitType.getSort()) %>" />
									</aui:col>
									
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (benefitType != null) {
						%>
						<aui:input type="hidden" name="benefitTypeId" value="<%= String.valueOf(benefitType.getSmartActiveBenefitTypeId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= benefitTypeURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
