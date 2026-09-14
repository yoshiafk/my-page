<%@ include file="../includes/init.jsp"%>

<%
	long industryCategoryId = ParamUtil.getLong(renderRequest, "industryCategoryId", 0);
	IndustryCategory industryCategory= null;

	if (industryCategoryId > 0) {
		industryCategory = IndustryCategoryLocalServiceUtil.fetchIndustryCategory(industryCategoryId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "industry_category";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%=addIndustryCategoryURL%>" name="industryCategory">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="globe" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=industryCategoryId > 0 ? "Edit Industry Category" : "Add Industry Category"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=industryCategoryId != 0 && industryCategory != null ? industryCategory.getActive() == 1 ? true : false
						: true%>"
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
										<aui:input label="Industry Category Name" name="industryCategoryName"
											type="text" required="true"
											value="<%=industryCategory == null ? "" : String.valueOf(industryCategory.getName())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (industryCategory != null) {
						%>
						<aui:input type="hidden" name="industryCategoryId"
							value="<%=String.valueOf(industryCategory.getIndustryCategoryId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=industryCategoryURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
