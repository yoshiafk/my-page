<%@ include file="../includes/init.jsp"%>

<%
	long companyTypeId = ParamUtil.getLong(renderRequest, "companyTypeId", 0);
	CompanyType companyType = null;

	if (companyTypeId > 0) {
		companyType = CompanyTypeLocalServiceUtil.fetchCompanyType(companyTypeId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "company_type";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<aui:form action="<%=addCompanyTypeURL%>" name="companyType">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="globe" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=companyTypeId > 0 ? "Edit Company Type" : "Add New Company Type"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=companyTypeId != 0 && companyType != null ? companyType.getActive() == 1 ? true : false : true%>"
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
										<aui:input label="Name" name="name" type="text"
											required="true"
											value="<%=companyType == null ? "" : String.valueOf(companyType.getName())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="100">
										<aui:input label="Label" name="label" type="text"
											required="true"
											value="<%=companyType == null ? "" : String.valueOf(companyType.getLabel())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="100">
										<aui:input label="Sort" name="sort" type="number"
											required="true"
											value="<%=companyType == null ? "" : String.valueOf(companyType.getSort())%>" />
									</aui:col>
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (companyType != null) {
						%>
						<aui:input type="hidden" name="companyTypeId"
							value="<%=String.valueOf(companyType.getCompanyTypeId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel"
								onClick="<%=companyTypeURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
