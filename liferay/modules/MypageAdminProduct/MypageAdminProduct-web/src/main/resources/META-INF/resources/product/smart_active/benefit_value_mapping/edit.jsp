<%@ include file="../includes/init.jsp"%>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.math.RoundingMode" %>

<%
	long benefitValueMappingId = ParamUtil.getLong(renderRequest, "benefitValueMappingId", 0);
	SmartActiveBenefitValueMapping benefitValueMapping = null;
	
	if (benefitValueMappingId > 0) {
		benefitValueMapping = SmartActiveBenefitValueMappingLocalServiceUtil.fetchSmartActiveBenefitValueMapping(benefitValueMappingId);
	}
	
	List<SmartActiveBenefitType> benefitTypes = SmartActiveBenefitTypeLocalServiceUtil.getActiveBenefitType();
	List<SmartActiveBenefit> benefits = SmartActiveBenefitLocalServiceUtil.getActiveBenefit();
	List<SmartActiveBenefitValue> benefitValues = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "benefit_value_mapping";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addBenefitValueMappingURL %>" name="benefitValueMapping">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= benefitValueMappingId > 0 ? "Edit Benefit Value Mapping" : "Add Benefit Value Mapping" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= benefitValueMappingId != 0 && benefitValueMapping != null ? benefitValueMapping.getActive() == 1 ? true : false : true %>"
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
										<aui:select name="benefitTypeId" label="Benefit Type" required="true">
										<% if (benefitTypes != null && benefitTypes.size() > 0) { %>
											<% for (int i = 0; i < benefitTypes.size(); i++) { %>
											
												<% 
													boolean isSelected = false;
													if (benefitValueMapping != null) {
														isSelected = benefitTypes.get(i).getSmartActiveBenefitTypeId() == benefitValueMapping.getSmartActiveBenefitTypeId() ? true : false; 
													}
												%>
										
												<aui:option value="<%= benefitTypes.get(i).getSmartActiveBenefitTypeId() %>" label="<%= benefitTypes.get(i).getNameId() %>" selected="<%= isSelected %>" />
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
								</aui:row>
									
								<aui:row>
									<aui:col width="100">
										<aui:select name="benefitId" label="Benefit Name" required="true">
										<% if (benefits != null && benefits.size() > 0) { %>
											<% for (int i = 0; i < benefits.size(); i++) { %>
											
												<%
													boolean isSelected = false;
													if (benefitValueMapping != null) {
														isSelected = benefits.get(i).getSmartActiveBenefitId() == benefitValueMapping.getSmartActiveBenefitId() ? true : false; 
													}
												%>
										
												<aui:option value="<%= benefits.get(i).getSmartActiveBenefitId() %>" label="<%= benefits.get(i).getNameId() %>" selected="<%= isSelected %>" />
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<aui:select name="benefitValueId" label="Benefit Value" required="true">
										<% if (benefitValues != null && benefitValues.size() > 0) { %>
											<% for (int i = 0; i < benefitValues.size(); i++) { %>
											
												<%
													boolean isSelected = false;
													if (benefitValueMapping != null) {
														isSelected = benefitValues.get(i).getSmartActiveBenefitValueId() == benefitValueMapping.getSmartActiveBenefitValueId() ? true : false; 
													}
													
													Locale idnLocale = new Locale("in", "ID");
													NumberFormat idnFormat = NumberFormat.getCurrencyInstance(idnLocale);
												%>
										
												<aui:option value="<%= benefitValues.get(i).getSmartActiveBenefitValueId() %>" label="<%= idnFormat.format(benefitValues.get(i).getValue()) %>" selected="<%= isSelected %>" />
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="100">
										<aui:input label="Value" name="value" type="textarea" value="<%= benefitValueMapping == null ? "" : String.valueOf(benefitValueMapping.getValue()) %>" required="true" />
									</aui:col>
								</aui:row>
								
								<%
									String _limitValueWithoutDecimal = "";
								if(benefitValueMapping != null) {
									_limitValueWithoutDecimal = benefitValueMapping.getLimitValue().setScale(0, RoundingMode.HALF_UP).toPlainString();
								}
									%>
								
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="Limit Value" name="limitValue" type="number" min="0" value="<%= benefitValueMapping == null ? "" : _limitValueWithoutDecimal %>" required="true" />
									</aui:col>
								</aui:row>
								
								
								
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (benefitValueMapping != null) {
						%>
						<aui:input type="hidden" name="benefitValueMappingId" value="<%= String.valueOf(benefitValueMapping.getSmartActiveBenefitValueMappingId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= benefitValueMappingURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
