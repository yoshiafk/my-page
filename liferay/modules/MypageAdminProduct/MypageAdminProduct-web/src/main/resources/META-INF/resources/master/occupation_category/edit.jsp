<%@ include file="../includes/init.jsp"%>

<%
	long masterOccupationCategoryId = ParamUtil.getLong(renderRequest, "masterOccupationCategoryId", 0);
	MasterOccupationCategory masterOccupation = null;

	if (masterOccupationCategoryId > 0) {
		masterOccupation = MasterOccupationCategoryLocalServiceUtil.fetchMasterOccupationCategory(masterOccupationCategoryId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "occupationCategory";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addOccupationCategoryURL%>" name="pet">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=masterOccupationCategoryId > 0 ? "Edit Occupation Category" : "Add New Occupation Category"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= masterOccupationCategoryId != 0 && masterOccupation != null ? masterOccupation.getActive() == 1 ? true : false : true %>" name="active"
								type="toggle-switch" value="1" label="Active"
								wrapperCssClass="leftToggleTitle" />
						</div>
					</div>
				</h2>

				<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input label="Name" name="name" type="text"
											required="true"
											value="<%=masterOccupation == null ? "" : String.valueOf(masterOccupation.getName())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (masterOccupation != null) {
						%>
						<aui:input type="hidden" name="masterOccupationCategoryId"
							value="<%=String.valueOf(masterOccupation.getMasterOccupationCategoryId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=occupationCategoryURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
