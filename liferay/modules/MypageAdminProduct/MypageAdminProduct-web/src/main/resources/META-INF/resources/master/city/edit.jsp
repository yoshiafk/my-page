<%@ include file="../includes/init.jsp"%>

<%
	long masterCityId = ParamUtil.getLong(renderRequest, "masterCityId", 0);
	MasterCity masterCity = null;

	if (masterCityId > 0) {
		masterCity = MasterCityLocalServiceUtil.fetchMasterCity(masterCityId);
	}
	
	List<MasterProvince> masterProvince = MasterProvinceLocalServiceUtil.getActiveProvinces();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "city";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addCityURL%>" name="city">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=masterCityId > 0 ? "Edit City" : "Add New City"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= masterCityId != 0 && masterCity != null ? masterCity.getActive() == 1 ? true : false : true %>" name="active"
								type="toggle-switch" value="1" label="Active"
								wrapperCssClass="leftToggleTitle" />
						</div>
					</div>
				</h2>

				<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="50">
										<aui:input label="City Name" name="name" type="text"
											required="true"
											value="<%=masterCity == null ? "" : String.valueOf(masterCity.getName())%>" />
									</aui:col>
									
									<aui:col width="50">
                                        <aui:select label="Province" name="provinceId" required="true" showEmptyOption="true">
                                            <%
                                            	if(! masterProvince.isEmpty()) {
                                            		for(MasterProvince city : masterProvince) {
                                            %>                                            
                                            <aui:option value="<%= city.getMasterProvinceId() %>" selected="<%= masterCity != null && city.getMasterProvinceId() == masterCity.getProvinceId() %>"><%= city.getName() %></aui:option>
                                            <%
                                            		}
                                            	}
                                            %>
                                        </aui:select>
                                    </aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Status" name="status" type="text"
											required="true"
											value="<%=masterCity == null ? "" : String.valueOf(masterCity.getStatus())%>" />
									</aui:col>
									<aui:col width="50">
										<aui:input label="ParEarthquakeZone" name="parEarthquakeZone" type="number"
											required="true"
											value="<%=masterCity == null ? "" : String.valueOf(masterCity.getParEarthquakeZone())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (masterCity != null) {
						%>
						<aui:input type="hidden" name="masterCityId"
							value="<%=String.valueOf(masterCity.getMasterCityId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=cityURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
