<%@ include file="../includes/init.jsp"%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				String _active = "benefit_type";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<portlet:actionURL name="importBenefitType"
				var="importBenefitTypeURL" />
			<aui:form method="post" action="<%= importBenefitTypeURL %>"
				enctype="multipart/form-data" name="<portlet:namespace />fm">
				<div class="sheet sheet-full">
					<div class="row">
						<div class="col-md-6">
							<h2 class="sheet-title">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate">Import Benefit Type</span>
								</div>
							</h2>
						</div>
					</div>
				</div>
				<div class="sheet-section">
					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset cssClass="pt-4 pl-4">
							<aui:row>
								<aui:col width="50">
									<aui:input type="file" name="importFile" label="CSV File"
										required="true"></aui:input>
									<aui:button type="submit" name="btnUploadFile" value="Import"></aui:button>
								</aui:col>
							</aui:row>
						</aui:fieldset>
					</aui:fieldset-group>
				</div>
			</aui:form>
		</div>
	</div>
</div>