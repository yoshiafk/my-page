<%@ include file="../includes/init.jsp"%>

<%
	long toproBenefitMappingId = ParamUtil.getLong(renderRequest, "toproBenefitMappingId", 0);
	SmartActiveToproBenefitMapping toproBenefitMapping = null;
	
	if (toproBenefitMappingId > 0) {
		toproBenefitMapping = SmartActiveToproBenefitMappingLocalServiceUtil.fetchSmartActiveToproBenefitMapping(toproBenefitMappingId);
	}
	
	List<SmartActiveTopro> topros = SmartActiveToproLocalServiceUtil.getActiveTopro();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "topro_benefit_mapping";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addToproBenefitMappingURL %>" name="toproBenefitMapping">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= toproBenefitMappingId > 0 ? "Edit Topro Benefit Mapping" : "Add Topro Benefit Mapping" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= toproBenefitMappingId != 0 && toproBenefitMapping != null ? toproBenefitMapping.getActive() == 1 ? true : false : true %>"
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
										<aui:select name="toproId" label="Topro" required="true">
										<% if (topros != null && topros.size() > 0) { %>
											<% for (int i = 0; i < topros.size(); i++) { %>
											
												<%
													boolean isSelected = false;
													if (toproBenefitMapping != null) {
														isSelected = topros.get(i).getSmartActiveToproId() == toproBenefitMapping.getSmartActiveToproId() ? true : false; 
													}
												%>
										
												<aui:option value="<%= topros.get(i).getSmartActiveToproId() %>" label="<%= topros.get(i).getTopro() %>" selected="<%= isSelected %>" />
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (toproBenefitMapping != null) {
						%>
						<aui:input type="hidden" name="toproBenefitMappingId" value="<%= String.valueOf(toproBenefitMapping.getSmartActiveToproBenefitMappingId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= toproBenefitMappingURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
