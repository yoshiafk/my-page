<%@ include file="../includes/init.jsp"%>

<%
	long countryId = ParamUtil.getLong(renderRequest, "countryId", 0);
	MasterCountry masterCountry = null;

	boolean platinumCheckStatus = false;
	boolean goldCheckStatus = false;
	boolean specialAsiaCheckStatus = false;
	boolean schengenCheckStatus = false;
	boolean sanctionCountryCheckStatus = false;

	if (countryId > 0) {
		masterCountry = MasterCountryLocalServiceUtil.fetchMasterCountry(countryId);
	}

	if (masterCountry != null) {
		platinumCheckStatus = String.valueOf(masterCountry.getIsPlatinum()).equals("1") ? true : false;
		goldCheckStatus = String.valueOf(masterCountry.getIsGold()).equals("1") ? true : false;
		specialAsiaCheckStatus = String.valueOf(masterCountry.getIsSpecialAsia()).equals("1") ? true : false;
		schengenCheckStatus = String.valueOf(masterCountry.getIsSchengen()).equals("1") ? true : false;
		sanctionCountryCheckStatus = String.valueOf(masterCountry.getIsSanctionCountry()).equals("1") ? true
				: false;
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "country";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addCountryURL%>" name="pet">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=countryId > 0 ? "Edit Country" : "Add New Country"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= countryId != 0 && masterCountry != null ? masterCountry.getActive() == 1 ? true : false : true %>" name="active"
								type="toggle-switch" value="1" label="Active"
								wrapperCssClass="leftToggleTitle" />
						</div>
					</div>
				</h2>

				<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input label="Country Name" name="countryName" type="text"
											required="true"
											value="<%=masterCountry == null ? "" : String.valueOf(masterCountry.getName())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col>
										<aui:input name="isPlatinum" type="checkbox" label="Platinum"
											checked="<%=platinumCheckStatus%>" />
										<aui:input name="isGold" type="checkbox" label="Gold"
											checked="<%=goldCheckStatus%>" />
										<aui:input name="isSpecialAsia" type="checkbox"
											label="Special Asia" checked="<%=specialAsiaCheckStatus%>" />
										<aui:input name="isSchengen" type="checkbox" label="Schengen"
											checked="<%=schengenCheckStatus%>" />
										<aui:input name="isSanctionCountry" type="checkbox"
											label="Sanction Country"
											checked="<%=sanctionCountryCheckStatus%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (masterCountry != null) {
						%>
						<aui:input type="hidden" name="countryId"
							value="<%=String.valueOf(masterCountry.getCountryId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=countryURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
