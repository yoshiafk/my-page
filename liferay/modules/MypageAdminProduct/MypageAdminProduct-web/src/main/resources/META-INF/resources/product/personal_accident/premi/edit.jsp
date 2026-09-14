<%@ include file="../includes/init.jsp"%>
<%
	long personalAccidentPremiId = ParamUtil.getLong(renderRequest, "personalAccidentPremiId");
	PersonalAccidentPremi personalAccidentPremi = null;

	if (personalAccidentPremiId > 0) {
		personalAccidentPremi = PersonalAccidentPremiLocalServiceUtil.fetchPersonalAccidentPremi(personalAccidentPremiId);
	}
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
			<aui:form action="<%=addPremiURL%>" name="pAPremi">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=personalAccidentPremiId > 0 ? "Edit Premi" : "Add New Premi"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input checked="<%=personalAccidentPremiId != 0 && personalAccidentPremi != null ? personalAccidentPremi.getActive() == 1 ? true : false : true%>" name="active" type="toggle-switch" value="1" label="Active" wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>

					<!--  START SHEET SECTION -->
					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="50">
											<% List<String> types = Arrays.asList("all", "standard", "non-standard"); %>
											<aui:select name="premiType" label="Select Type">
											<% for(String premiType : types) { %>
												<% boolean isSelected = false;%>
												<% if(personalAccidentPremi != null) {
													if(personalAccidentPremi.getPremiType().equals(premiType)) {
														isSelected = true;
													}
												} %>
												
												<aui:option value="<%= premiType %>" label="<%= premiType.toUpperCase() %>" selected="<%= isSelected %>"></aui:option>
												
											<% } %>
											</aui:select>
									</aui:col>								
								</aui:row>
															
								<aui:row>
									<aui:col width="100">
										<aui:input label="Amount" name="amount" type="text" required="true" value="<%=personalAccidentPremi == null ? "" : String.valueOf(personalAccidentPremi.getAmount())%>" />
									</aui:col>
								</aui:row>

								<aui:button-row>
									<aui:button name="submitButton" type="submit" value="Save" />
									<aui:button type="cancel" onClick="<%=premiURL.toString()%>"></aui:button>
								</aui:button-row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (personalAccidentPremi != null) {
						%>
						<aui:input type="hidden" name="personalAccidentPremiId"
							value="<%=String.valueOf(personalAccidentPremi.getPersonalAccidentPremiId())%>" />
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