<%@ include file="../includes/init.jsp"%>

<%
	long petAnimalTypeId = ParamUtil.getLong(renderRequest, "petAnimalTypeId", 0);
	PetAnimalType petAnimalType = null;

	if (petAnimalTypeId > 0) {
		petAnimalType = PetAnimalTypeLocalServiceUtil.fetchPetAnimalType(petAnimalTypeId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "animalType";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<aui:form action="<%=addAnimalTypeURL%>" name="petAnimalType">

				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=petAnimalTypeId > 0 ? "Edit AnimalType" : "Add New AnimalType"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=petAnimalTypeId != 0 && petAnimalType != null ? petAnimalType.getActive() == 1 ? true : false : true%>"
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
										<aui:input label="Animal Type Name" name="name" type="text"
											required="true"
											value="<%=petAnimalType == null ? "" : String.valueOf(petAnimalType.getName())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (petAnimalType != null) {
						%>
						<aui:input type="hidden" name="petAnimalTypeId"
							value="<%=String.valueOf(petAnimalType.getPetAnimalTypeId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=animalTypeURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>

	</div>

</div>
</div>
</div>
