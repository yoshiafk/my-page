<%@ include file="../includes/init.jsp"%>

<%
	long petRemarksId = ParamUtil.getLong(renderRequest, "petRemarksId", 0);
	PetRemarks petRemarks = null;

	if (petRemarksId > 0) {
		petRemarks = PetRemarksLocalServiceUtil.fetchPetRemarks(petRemarksId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "remarks";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<aui:form action="<%=addRemarksURL%>" name="petRemarks">

				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=petRemarksId > 0 ? "Edit Remarks" : "Add New Remarks"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=petRemarksId != 0 && petRemarks != null ? petRemarks.getActive() == 1 ? true : false : true%>"
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
										<aui:input label="Remarks Name" name="remarksName" type="text"
											required="true"
											value="<%=petRemarks == null ? "" : String.valueOf(petRemarks.getName())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="Code" name="remarksCode" type="text"
											required="true"
											value="<%=petRemarks == null ? "" : String.valueOf(petRemarks.getCode())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (petRemarks != null) {
						%>
						<aui:input type="hidden" name="petRemarksId"
							value="<%=String.valueOf(petRemarks.getPetRemarksId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=remarksURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>

	</div>

</div>
</div>
</div>
