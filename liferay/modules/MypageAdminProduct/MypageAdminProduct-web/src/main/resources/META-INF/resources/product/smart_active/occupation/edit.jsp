<%@ include file="../includes/init.jsp"%>

<%
	long occupationId = ParamUtil.getLong(renderRequest, "occupationId", 0);
	SmartActiveOccupation occupation = null;
	
	if (occupationId > 0) {
		occupation = SmartActiveOccupationLocalServiceUtil.fetchSmartActiveOccupation(occupationId);
	}
	
	List<SmartActiveClassRate> classRates = SmartActiveClassRateLocalServiceUtil.getActiveClassRate();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "occupation";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addOccupationURL %>" name="occupation">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= occupationId > 0 ? "Edit Occupation" : "Add Occupation" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= occupationId != 0 && occupation != null ? occupation.getActive() == 1 ? true : false : true %>"
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
										<aui:input label="Code" name="code"
											type="text" required="true"
											value="<%= occupation == null ? "" : String.valueOf(occupation.getCode()) %>" />
									</aui:col>
								
									<aui:col width="100">
										<aui:input label="Name (Indonesia)" name="nameId"
											type="text" required="true"
											value="<%= occupation == null ? "" : String.valueOf(occupation.getNameId()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Name (English)" name="nameEn"
											type="text" required="true"
											value="<%= occupation == null ? "" : String.valueOf(occupation.getNameEn()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:select name="classRateId" label="Class Rate" required="true">
											<%
												for (int i = 0; i < classRates.size(); i++) {
											%>
											<%
												boolean isSelectedClassRates = false;
												if (occupation != null) {
													isSelectedClassRates = classRates.get(i).getSmartActiveClassRateId() == occupation.getSmartActiveClassRateId() ? true : false;
												}
												
												String classRateName = classRates.get(i).getNameId();
											    if (classRateName == null || classRates.isEmpty()) {
											    	classRateName = classRates.get(i).getNameEn();
											    }								
																			
											%>
											<aui:option
												value="<%= classRates.get(i).getSmartActiveClassRateId() %>"
												label="<%= classRateName %>"
												selected="<%= isSelectedClassRates %>" />
											<%
												}
											%>
										</aui:select>
									</aui:col>
									
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (occupation != null) {
						%>
						<aui:input type="hidden" name="occupationId" value="<%= String.valueOf(occupation.getSmartActiveOccupationId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= occupationURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
