<%@ include file="../includes/init.jsp"%>

<%
	long referenceNumberId = ParamUtil.getLong(renderRequest, "referenceNumberId", 0);
	ReferenceNumber referenceNumber = null;
	if (referenceNumberId > 0) {
		referenceNumber = ReferenceNumberLocalServiceUtil.fetchReferenceNumber(referenceNumberId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "referenceNumber";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addReferenceNumberURL%>" name="referenceNumber">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=referenceNumberId > 0 ? "Edit ReferenceNumber" : "Add New ReferenceNumber"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= referenceNumberId != 0 && referenceNumber != null ? referenceNumber.getActive() == 1 ? true : false : true %>" name="active"
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
										<aui:select label="User Role" name="userRole" showEmptyOption="true" required="true">
											<aui:option value="Direct" 
                                            	selected="<%= referenceNumber != null && referenceNumber.getUserRole().equals("Direct") %>">Direct</aui:option>
                                            <aui:option value="Agent" 
                                            	selected="<%= referenceNumber != null && referenceNumber.getUserRole().equals("Agent") %>">Agent</aui:option>
                                        </aui:select>
									</aui:col>
									
									<aui:col width="50">
										<aui:select label="Channel" name="channel" showEmptyOption="true" required="true">
                                            <aui:option value="Direct" 
                                            	selected="<%= referenceNumber != null && referenceNumber.getChannel().equals("Direct") %>">Direct</aui:option>
                                            <aui:option value="Agent" 
                                            	selected="<%= referenceNumber != null && referenceNumber.getChannel().equals("Agent") %>">Agent</aui:option>
                                        </aui:select>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:row>
											<aui:col width="50">
												<aui:select label="Product Code" name="productCode" showEmptyOption="true" required="true">
													<%
														List<ProductConfiguration> products = ProductConfigurationLocalServiceUtil.getProductConfigurations(0, ProductConfigurationLocalServiceUtil.getProductConfigurationsCount());
														if(products.size() > 0) {
															for(ProductConfiguration product : products) {
													%>
														<aui:option value="<%= product.getProductCode() %>" 
			                                            	selected="<%= referenceNumber != null && referenceNumber.getProductCode().equals(product.getProductCode()) %>"><%= product.getProductCode() %></aui:option>
													<%
															}
														}
													%>
		                                        </aui:select>
		                                    </aui:col>
		                                    
		                                    <aui:col width="50">
												<aui:select label="Type" name="type" showEmptyOption="true" required="true">
		                                            <aui:option value="leads" 
		                                            	selected="<%= referenceNumber != null && referenceNumber.getType().equals("leads") %>">Leads</aui:option>
		                                            <aui:option value="quotation" 
		                                            	selected="<%= referenceNumber != null && referenceNumber.getType().equals("quotation") %>">Quotation</aui:option>
		                                            <aui:option value="kyc" 
		                                            	selected="<%= referenceNumber != null && referenceNumber.getType().equals("kyc") %>">KYC</aui:option>
		                                        </aui:select>
											</aui:col>
		                            	</aui:row>
									</aui:col>
									
									<aui:col width="50">
										<aui:select label="Business Type" name="businessType" showEmptyOption="true" required="true">
                                            <aui:option value="B2C" 
                                            	selected="<%= referenceNumber != null && referenceNumber.getBusinessType().equals("B2C") %>">B2C</aui:option>
                                            <aui:option value="B2B" 
                                            	selected="<%= referenceNumber != null && referenceNumber.getBusinessType().equals("B2B") %>">B2B</aui:option>
                                            <aui:option value="B2B2C" 
                                            	selected="<%= referenceNumber != null && referenceNumber.getBusinessType().equals("B2B2C") %>">B2B2C</aui:option>
                                        </aui:select>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:select label="Currency" name="currency" showEmptyOption="true" required="true">
											<%
												List<MasterCurrency> currencies = MasterCurrencyLocalServiceUtil.getMasterCurrencies();
												if(currencies.size() > 0) {
													for(MasterCurrency currency : currencies) {
											%>
												<aui:option value="<%= currency.getName() %>" 
	                                            	selected="<%= referenceNumber != null && referenceNumber.getCurrency().equals(currency.getName()) %>"><%= currency.getName() %></aui:option>
											<%
													}
												}
											%>
                                        </aui:select>
									</aui:col>
									
									<aui:col width="50">
                                        <aui:input label="Prefix" name="prefix" type="text" required="true"
											value="<%=referenceNumber == null ? "" : String.valueOf(referenceNumber.getPrefix())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>
						
						<%
							if (referenceNumber != null) {
						%>
						<aui:input type="hidden" name="referenceNumberId"
							value="<%=String.valueOf(referenceNumber.getReferenceNumberId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=referenceNumberURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
