<%@ include file="../includes/init.jsp"%>

<%
	List<IndustryCategory> industryCategories = IndustryCategoryLocalServiceUtil.getActiveIndustryCategories();

	long industryId = ParamUtil.getLong(renderRequest, "industryId", 0);
	Industry industry = null;

	if (industryId > 0) {
		industry = IndustryLocalServiceUtil.fetchIndustry(industryId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "industry";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%=addIndustryURL%>" name="industry">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="globe" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=industryId > 0 ? "Edit Industry" : "Add Industry"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=industryId != 0 && industry != null ? industry.getActive() == 1 ? true : false : true%>"
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
										<aui:input label="Industry Name" name="industryName"
											type="text" required="true"
											value="<%=industry == null ? "" : String.valueOf(industry.getName())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="100">
										<aui:select name="industryCategoryId" label="Category" required="true">
											<%
												for (int i = 0; i < industryCategories.size(); i++) {
											%>
											<%
												boolean isSelectedIndustryCategory = false;
																			if (industry != null) {
																				isSelectedIndustryCategory = industryCategories.get(i)
																						.getIndustryCategoryId() == industry.getIndustryCategoryId() ? true : false;
																			}
											%>
											<aui:option
												value="<%=industryCategories.get(i).getIndustryCategoryId()%>"
												label="<%=industryCategories.get(i).getName()%>"
												selected="<%=isSelectedIndustryCategory%>" />
											<%
												}
											%>
										</aui:select>
									</aui:col>
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (industry != null) {
						%>
						<aui:input type="hidden" name="industryId" value="<%=String.valueOf(industry.getIndustryId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=industryURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
