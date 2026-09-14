<%@ include file="../includes/init.jsp"%>

<%
	long currencyId = ParamUtil.getLong(renderRequest, "currencyId", 0);
	MasterCurrency masterCurrency = null;

	boolean isDefaultCheckStatus = false;

	if (currencyId > 0) {
		masterCurrency = MasterCurrencyLocalServiceUtil.fetchMasterCurrency(currencyId);
	}

	if (masterCurrency != null) {
		isDefaultCheckStatus = String.valueOf(masterCurrency.getIsDefault()).equals("1") ? true : false;
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "currency";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%=addCurrencyURL%>" name="masterCurrency">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="globe" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=currencyId > 0 ? "Edit Currency" : "Add New Currency"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=currencyId != 0 && masterCurrency != null ? masterCurrency.getActive() == 1 ? true : false
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
										<aui:input label="Currency Name" name="currencyName"
											type="text" required="true"
											value="<%=masterCurrency == null ? "" : String.valueOf(masterCurrency.getName())%>" />

										<aui:input label="Amount" name="amount" type="number"
											required="true"
											value="<%=masterCurrency == null ? "" : String.valueOf(masterCurrency.getAmount())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col>
										<aui:input name="isDefault" type="checkbox"
											label="Default Currency" checked="<%=isDefaultCheckStatus%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (masterCurrency != null) {
						%>
						<aui:input type="hidden" name="currencyId"
							value="<%=String.valueOf(masterCurrency.getCurrencyId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=currencyURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
