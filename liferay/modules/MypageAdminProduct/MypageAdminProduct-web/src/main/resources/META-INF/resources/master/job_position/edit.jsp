<%@ include file="../includes/init.jsp"%>

<%
	long jobPositionId = ParamUtil.getLong(renderRequest, "jobPositionId", 0);
	JobPosition jobPosition = null;

	if (jobPositionId > 0) {
		jobPosition = JobPositionLocalServiceUtil.fetchJobPosition(jobPositionId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "job_position";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%=addJobPositionURL%>" name="jobPosition">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="globe" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=jobPositionId > 0 ? "Edit Job Position" : "Add Job Position"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=jobPositionId != 0 && jobPosition != null ? jobPosition.getActive() == 1 ? true : false : true%>"
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
										<aui:input label="Job Position Name" name="jobPositionName"
											type="text" required="true"
											value="<%=jobPosition == null ? "" : String.valueOf(jobPosition.getName())%>" />
									</aui:col>
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (jobPosition != null) {
						%>
						<aui:input type="hidden" name="jobPositionId"
							value="<%=String.valueOf(jobPosition.getJobPositionId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel"
								onClick="<%=jobPositionURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
