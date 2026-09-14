<%@ include file="../includes/init.jsp"%>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.math.RoundingMode" %>

<%
	long toproId = ParamUtil.getLong(renderRequest, "toproId", 0);
	SmartActiveTopro topro = null;
	
	if (toproId > 0) {
		topro = SmartActiveToproLocalServiceUtil.fetchSmartActiveTopro(toproId);
	}
	
	List<SmartActiveBenefitValue> benefitValues = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "topro";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addToproURL %>" name="topro">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= toproId > 0 ? "Edit Topro" : "Add Topro" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= toproId != 0 && topro != null ? topro.getActive() == 1 ? true : false : true %>"
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
										<aui:input label="Topro" name="topro"
											type="text" required="true"
											value="<%= topro == null ? "" : String.valueOf(topro.getTopro()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Description" name="description"
											type="text" required="true"
											value="<%= topro == null ? "" : String.valueOf(topro.getDescription()) %>" />
									</aui:col>
								
									<aui:col width="100">
										<aui:input label="Annotations" name="annotations"
											type="text" required="true"
											value="<%= topro == null ? "" : String.valueOf(topro.getAnnotations()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:select name="benefitValueId" label="Benefit Value" required="true">
										<% if (benefitValues != null && benefitValues.size() > 0) { %>
											<% for (int i = 0; i < benefitValues.size(); i++) { %>
											
												<%
													boolean isSelected = false;
													if (topro != null) {
														isSelected = benefitValues.get(i).getSmartActiveBenefitValueId() == topro.getSmartActiveBenefitValueId() ? true : false; 
													}
													
													Locale idnLocale = new Locale("in", "ID");
													NumberFormat idnFormat = NumberFormat.getCurrencyInstance(idnLocale);
												%>
										
												<aui:option value="<%= benefitValues.get(i).getSmartActiveBenefitValueId() %>" label="<%= idnFormat.format(benefitValues.get(i).getValue()) %>" selected="<%= isSelected %>" />
											<% } %>
										<% } %>
										</aui:select>
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Toc" name="toc"
											type="text" required="true"
											value="<%= topro == null ? "" : String.valueOf(topro.getToc()) %>" />
									</aui:col>
									
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (topro != null) {
						%>
						<aui:input type="hidden" name="toproId" value="<%= String.valueOf(topro.getSmartActiveToproId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= toproURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
