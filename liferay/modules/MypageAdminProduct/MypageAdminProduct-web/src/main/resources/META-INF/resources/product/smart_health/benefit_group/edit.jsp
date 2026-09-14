<%@ include file="../includes/init.jsp"%>
<%
	long smartHealthBenefitGroupId = ParamUtil.getLong(renderRequest, "smartHealthBenefitGroupId");
	SmartHealthBenefitGroup smartHealthBenefitGroup = null;

	if (smartHealthBenefitGroupId > 0) {
		smartHealthBenefitGroup = SmartHealthBenefitGroupLocalServiceUtil.fetchSmartHealthBenefitGroup(smartHealthBenefitGroupId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "benefit_group";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<aui:form action="<%=addBenefitGroupURL%>" name="sHBenefitGroup">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=smartHealthBenefitGroupId > 0 ? "Edit Benefit Group" : "Add New Benefit Group"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=smartHealthBenefitGroupId != 0 && smartHealthBenefitGroup != null
						? smartHealthBenefitGroup.getActive() == 1 ? true : false
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
										<aui:input label="Group Name" name="groupName" type="text" required="true"
											value="<%=smartHealthBenefitGroup == null ? "" : String.valueOf(smartHealthBenefitGroup.getGroupName())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="100">
										<aui:input label="Description" name="groupDescription" type="textarea"
											value="<%=smartHealthBenefitGroup == null ? ""
										: String.valueOf(smartHealthBenefitGroup.getGroupDescription())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="100">
										<aui:input label="Code" name="groupCode" type="text" required="true"
											value="<%=smartHealthBenefitGroup == null ? "" : String.valueOf(smartHealthBenefitGroup.getGroupCode())%>" />
									</aui:col>
								</aui:row>								

								<aui:button-row>
									<aui:button name="submitButton" type="submit" value="Save" />
									<aui:button type="cancel" onClick="<%=benefitGroupURL.toString()%>"></aui:button>
								</aui:button-row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (smartHealthBenefitGroup != null) {
						%>
						<aui:input type="hidden" name="smartHealthBenefitGroupId" value="<%=String.valueOf(smartHealthBenefitGroup.getSmartHealthBenefitGroupId())%>" />
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