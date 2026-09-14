<%@ include file="../includes/init.jsp"%>

<%
	long masterProvinceId = ParamUtil.getLong(renderRequest, "masterProvinceId", 0);
	MasterProvince masterProvince = null;

	if (masterProvinceId > 0) {
		masterProvince = MasterProvinceLocalServiceUtil.fetchMasterProvince(masterProvinceId);
	}
	
	List<MasterCountry> masterCountry = MasterCountryLocalServiceUtil.getActiveCountries();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "province";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addProvinceURL%>" name="provinnce">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=masterProvinceId > 0 ? "Edit Province" : "Add New Province"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= masterProvinceId != 0 && masterProvince != null ? masterProvince.getActive() == 1 ? true : false : true %>" name="active"
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
										<aui:input label="Province Name" name="name" type="text"
											required="true"
											value="<%=masterProvince == null ? "" : String.valueOf(masterProvince.getName())%>" />
									</aui:col>
									
									<aui:col width="100">
                                        <aui:select label="Country" name="countryId" required="true" showEmptyOption="true">
                                            <%
                                            	if(! masterCountry.isEmpty()) {
                                            		for(MasterCountry country : masterCountry) {
                                            %>                                            
                                            <aui:option value="<%= country.getCountryId() %>" selected="<%= masterProvince != null && country.getCountryId() == masterProvince.getCountryId() %>"><%= country.getName() %></aui:option>
                                            <%
                                            		}
                                            	}
                                            %>
                                        </aui:select>
                                    </aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (masterProvince != null) {
						%>
						<aui:input type="hidden" name="masterProvinceId"
							value="<%=String.valueOf(masterProvince.getMasterProvinceId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=provinceURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
