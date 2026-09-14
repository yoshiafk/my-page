<%@ include file="../includes/init.jsp"%>

<%
	long leadsId = ParamUtil.getLong(renderRequest, "LeadsId", 0);
	Leads leads = null;
	String leadsChannelName = "";

	if (leadsId > 0) {
		// set page title
		renderResponse.setTitle("Edit Leads "+leadsId);
		
		leads = LeadsLocalServiceUtil.fetchLeads(leadsId);
	} else {
		// set page title
		renderResponse.setTitle("Add Leads");
	}
	
	List<MasterCountry> masterCountry = MasterCountryLocalServiceUtil.getActiveCountries();
%>
<liferay-ui:error key="errorProductCode" message="Wrong product code" />

<liferay-util:buffer
	var="removeLicenseIcon"
>
	<liferay-ui:icon
		icon="times-circle"
		markupView="lexicon"
		message="remove"
	/>
</liferay-util:buffer>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
			<aui:form action="<%=addLeadsURL%>" name="leads">
				<div class="sheet sheet-full">
	
					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="globe" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=leadsId > 0 ? "Edit Leads" : "Add New Leads"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input checked="<%= leadsId != 0 && leads != null ? leads.getActive() == 1 ? true : false : true %>" name="active"
									type="toggle-switch" value="1" label="Active"
									wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>
					
					<liferay-ui:tabs names="Leads Detail, Product Detail, Insured" refresh="false" tabsValues="Leads Detail, Product Detail, Insured">
					    <liferay-ui:section>
					        <div class="sheet-section">
								<aui:fieldset-group markupView="lexicon">
									<aui:fieldset cssClass="p-4" label="Leads Detail" collapsible="true" collapsed="false">
										<clay:content-row
										    containerElement="h3"
										    cssClass="sheet-subtitle"
										    >
										    <clay:content-col expand="<%= true %>">
										        <span class="heading-text">
										            Managed By
										        </span>
										    </clay:content-col>
										    <clay:content-col>
										        <span class="heading-end">
										            <liferay-ui:icon
										                cssClass="add-user-parent"
										                id="selectMypageUserId"
										                label="<%= true %>"
										                linkCssClass="btn btn-secondary btn-sm"
										                message="select"
										                method="get"
										                url="javascript:;"
										                />
										        </span>
										    </clay:content-col>
										</clay:content-row>
										
										<aui:row>
											<aui:input 
											    name="ManagedBy" 
											    type="hidden"
											    value="<%=leads == null ? "" : String.valueOf(leads.getMypageUserId())%>" />
											<aui:col width="100">
											    <p id="no-user-parent" class="text-muted pb-4 <%= leads == null || (leads != null && Validator.isNull(leads.getMypageUserId())) ? "" : "d-none" %>">
											        this user is not assigned any user parent
											    </p>
											    
											    <table 
											        class="show-quick-actions-on-hover table table-autofit table-heading-nowrap table-list mb-4 <%= leads == null || (leads != null && Validator.isNull(leads.getMypageUserId())) ? "d-none" : "" %>" 
											        id="user-parent-table"
											    >
											        <thead>
											            <tr>
											            	<th class="lfr-title-column">Screeen Name</th>
											                <th class="lfr-title-column">Full Name</th>
											                <th class="lfr-entry-action-column"> &nbsp; </th>
											            </tr>
											        </thead>
											        <tbody>
											            <tr id="user-parent-row">
											                <% if(leads != null && !Validator.isNull(leads.getMypageUserId())) { %>
											                <%
											                    MypageUser getUserMypageUserId = MypageUserLocalServiceUtil.getMypageUser(leads.getMypageUserId());
											                	User getLiferayUser = UserLocalServiceUtil.getUser(getUserMypageUserId.getLiferayUserId());
											                %>
											                <td>
											                    <span><%= getLiferayUser.getScreenName() %></span>
											                </td>
											                <td>
											                    <span><%= getLiferayUser.getFirstName() %><%= Validator.isNull(getLiferayUser.getMiddleName()) ? " " : " "+getLiferayUser.getMiddleName()+" " %><%= getLiferayUser.getLastName() %></span>
											                </td>
											                <td>
											                    <a onclick="removeMypageUserId(this)" id="remove-user-parent" href="javascript:;">
											                        <%= removeLicenseIcon %>
											                    </a>
											                </td>
											                <% } %>
											            </tr>
											        </tbody>
											    </table>
											</aui:col>
										</aui:row>
									
										<aui:row>
											<aui:col width="50">
												<aui:row>
													<aui:col width="50">
														<aui:select label="Type" name="LeadsType" showEmptyOption="true" required="true">
															<aui:option value="leads" selected="<%= leads != null && leads.getLeadsType().equals("leads") %>">Leads</aui:option>
															<aui:option value="quotation" selected="<%= leads != null && leads.getLeadsType().equals("quotation") %>">Quotation</aui:option>
															<aui:option value="kyc" selected="<%= leads != null && leads.getLeadsType().equals("kyc") %>">KYC</aui:option>
														</aui:select>
													</aui:col>
													
													<aui:col width="50">
														<aui:input label="Product Code" name="ProductCode" type="text" required="true"
															value="<%=leads == null ? "" : String.valueOf(leads.getProductCode())%>" />
													</aui:col>
												</aui:row>
											</aui:col>
											
											<aui:col width="50">
												<aui:row>
													<aui:col width="50">
														<aui:select label="BussinesModel" name="BussinesModel" showEmptyOption="true" required="true">
															<aui:option value="B2C" selected="<%= leads != null && leads.getBussinesModel().equals("B2C") %>">B2C</aui:option>
															<aui:option value="B2B" selected="<%= leads != null && leads.getBussinesModel().equals("B2B") %>">B2B</aui:option>
															<aui:option value="B2B2C" selected="<%= leads != null && leads.getBussinesModel().equals("B2B2C") %>">B2B2C</aui:option>
														</aui:select>
													</aui:col>
													
													<aui:col width="50">
														<aui:input label="Channel" name="Channel" type="text"
															value="<%=leads == null ? "" : String.valueOf(leads.getChannel())%>" />
													</aui:col>
												</aui:row>
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="PolicyNumber" name="PolicyNumber" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getPolicyNumber())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="ReferenceNumber" name="ReferenceNumber" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getReferenceNumber())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:row>
													<aui:col width="30">
														<%
															List<MasterCurrency> currencies = MasterCurrencyLocalServiceUtil.getMasterCurrencies();
														%>
														<aui:select label="Currency" name="Currency" showEmptyOption="true" required="true">
															<%
																if(currencies.size() > 0) {
																	for(MasterCurrency currency : currencies) {
															%>
															<aui:option value="<%= currency.getName() %>" selected="<%= leads != null && leads.getCurrency().equals(currency.getName()) %>"><%= currency.getName() %></aui:option>
															<%
																	}
																}
															%>
														</aui:select>
													</aui:col>
													
													<aui:col width="70">
														<aui:input label="Premium" name="Premium" type="number" required="true"
															value="<%=leads == null ? "" : String.format("%.0f", leads.getPremium())%>" />
													</aui:col>
												</aui:row>
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="NetPremium" name="NetPremium" type="number" required="true"
													value="<%=leads == null ? "" : String.format("%.0f", leads.getNetPremium())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="StampDuty" name="StampDuty" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getStampDuty())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="PolicyCost" name="PolicyCost" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getPolicyCost())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:row>
													<aui:col width="30">
														<aui:input label="PromoCode" name="PromoCode" type="text"
															value="<%=leads == null ? "" : String.valueOf(leads.getPromoCode())%>" />
													</aui:col>
													
													<aui:col width="30">
														<aui:input label="Discount" name="Discount" type="number"
															value="<%=leads == null ? "" : String.valueOf(leads.getDiscount())%>" />
													</aui:col>
													
													<aui:col width="30">
														<aui:input label="Discount Amount" name="DiscountAmount" type="number"
															value="<%=leads == null ? "" : String.valueOf(leads.getDiscountAmount())%>" />
													</aui:col>
												</aui:row>
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="Commission" name="Commission" type="number"
													value="<%=leads == null ? "" : String.valueOf(leads.getCommission())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row cssClass="pb-4">
											<aui:col width="50">
												<%
													Integer day = null;
													Integer month = null;
													Integer year = null;
													
													if(leads != null && String.valueOf(leads.getPolicyStartDate()) != "" && String.valueOf(leads.getPolicyStartDate()) != "null") {
														SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
														LocalDate PolicyStartDate = LocalDate.parse(date.format(leads.getPolicyStartDate()));
													
														day = PolicyStartDate.getDayOfMonth();
														month = PolicyStartDate.getMonthValue() - 1;
														year = PolicyStartDate.getYear();
													}
												%>
												<aui:row>
													<aui:col width="100">
														<label>Policy Start Date <aui:icon cssClass="reference-mark text-warning" image="asterisk" markupView="lexicon" /></label>
													</aui:col>
													<aui:col width="100">
														<% if(leads != null && String.valueOf(leads.getPolicyStartDate()) != "" && String.valueOf(leads.getPolicyStartDate()) != "null") { %>
														<liferay-ui:input-date 
															name="PolicyStartDate"
															dayValue="<%= day %>" 
															monthValue="<%= month %>"
															yearValue="<%= year %>"
															required="true"
														/>
														<% } else { %>
														<liferay-ui:input-date 
															name="PolicyStartDate"
															nullable="true"
															required="true"
														/>
														<% } %>
													</aui:col>
												</aui:row>
											</aui:col>
											
											<aui:col width="50">
												<%
													Integer dayE = null;
													Integer monthE = null;
													Integer yearE = null;
													
													if(leads != null && String.valueOf(leads.getPolicyEndDate()) != "" && String.valueOf(leads.getPolicyEndDate()) != "null") {
														SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
														LocalDate PolicyEndDate = LocalDate.parse(date.format(leads.getPolicyEndDate()));
													
														dayE = PolicyEndDate.getDayOfMonth();
														monthE = PolicyEndDate.getMonthValue() - 1;
														yearE = PolicyEndDate.getYear();
													}
												%>
												<aui:row>
													<aui:col width="100">
														<label>Policy End Date <aui:icon cssClass="reference-mark text-warning" image="asterisk" markupView="lexicon" /></label>
													</aui:col>
													<aui:col width="100">
														<% if(leads != null && String.valueOf(leads.getPolicyEndDate()) != "" && String.valueOf(leads.getPolicyEndDate()) != "null") { %>
														<liferay-ui:input-date 	
															name="PolicyEndDate"
															dayValue="<%= dayE %>" 
															monthValue="<%= monthE %>"
															yearValue="<%= yearE %>" 
															required="true"
														/>
														<% } else { %>
														<liferay-ui:input-date 
															name="PolicyEndDate"
															nullable="true"
															required="true"
														/>
														<% } %>
													</aui:col>
												</aui:row>
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="Token" name="Token" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getToken())%>" />
											</aui:col>
											<aui:col width="50">
												<aui:input label="Temp Code" name="TempCode" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getTempCode())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="33" cssClass="pt-4">
												<aui:input label="CommercialOffers" name="CommercialOffers" type="checkbox"
													value="1" checked="<%=leads != null && leads.getCommercialOffers() == 1 %>" />
											</aui:col>
										</aui:row>
									</aui:fieldset>
								</aui:fieldset-group>
								
								<aui:fieldset-group markupView="lexicon">
									<aui:fieldset cssClass="p-4" label="Policy Holder" collapsible="true" collapsed="false">
										<aui:row>
											<aui:col width="50">
												<aui:input label="Name" name="Name" type="text" required="true"
													value="<%=leads == null ? "" : String.valueOf(leads.getName())%>" />
											</aui:col>
											
											<aui:col width="50">
												<%
							                		if(leads != null && !leads.getProductCode().equals("IT")) {
							                	%>
												<aui:select label="Nationality" name="Nationality" showEmptyOption="true" required="true">
													<%
		                                            	if(! masterCountry.isEmpty()) {
		                                            		for(MasterCountry country : masterCountry) {
		                                            %>                                            
		                                            <aui:option value="<%= country.getName() %>" selected="<%= leads != null && String.valueOf(country.getName()).toLowerCase().equals(String.valueOf(leads.getNationality()).toLowerCase()) %>"><%= country.getName() %></aui:option>
		                                            <%
		                                            		}
		                                            	}
		                                            %>
		                                        </aui:select>
		                                        <%
							              			} else {
							                   %>
							                   		<aui:input label="Nationality" name="Nationality" type="text"
							                  			value="<%=leads == null ? "" : String.valueOf(leads.getNationality())%>" />
							                   <%
							              			}
							                   %>
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:select label="Gender" name="Gender" showEmptyOption="true" required="true">
													<aui:option value="M" selected="<%= leads != null && leads.getGender().equals("M") %>">Male</aui:option>
													<aui:option value="F" selected="<%= leads != null && leads.getGender().equals("F") %>">Female</aui:option>
												</aui:select>
											</aui:col>
											
											<aui:col width="50">
												<%
													Integer dayD = null;
													Integer monthD = null;
													Integer yearD = null;
													
													if(leads != null && String.valueOf(leads.getDob()) != "" && String.valueOf(leads.getDob()) != "null") {
														SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
														LocalDate Dob = LocalDate.parse(date.format(leads.getDob()));
													
														dayD = Dob.getDayOfMonth();
														monthD = Dob.getMonthValue() - 1;
														yearD = Dob.getYear();
													}
												%>
												<aui:row>
													<aui:col width="50">
														<aui:row>
															<aui:col width="100">
																<label>Date Of Birth</label>
															</aui:col>
															<aui:col width="100">
																<% if(leads != null && String.valueOf(leads.getDob()) != "" && String.valueOf(leads.getDob()) != "null") { %>
																<liferay-ui:input-date 
																	name="Dob"
																	dayValue="<%= dayD %>" 
																	monthValue="<%= monthD %>"
																	yearValue="<%= yearD %>" 
																/>
																<% } else { %>
																<liferay-ui:input-date 
																	name="Dob"
																	nullable="true"
																/>
																<% } %>
															</aui:col>
														</aui:row>
													</aui:col>
													
													<aui:col width="50">
														<aui:input label="Birth Place" name="BirthPlace" type="text"
															value="<%=leads == null ? "" : String.valueOf(leads.getBirthPlace())%>" />
													</aui:col>
												</aui:row>
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="Email" name="Email" type="email" required="true"
													value="<%=leads == null ? "" : String.valueOf(leads.getEmail())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="Mobile Phone" name="MobilePhone" type="text" required="true"
													value="<%=leads == null ? "" : String.valueOf(leads.getMobilePhone())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="Id Number" name="IdNumber" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getIdNumber())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:row>
													<aui:col width="50">
														<aui:input label="Passport Number" name="PassportNumber" type="text"
															value="<%=leads == null ? "" : String.valueOf(leads.getPassportNumber())%>" />
													</aui:col>
													
													<aui:col width="50">
														<aui:input label="Kitas Number" name="KitasNumber" type="text"
															value="<%=leads == null ? "" : String.valueOf(leads.getKitasNumber())%>" />
													</aui:col>
												</aui:row>
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="Address" name="Address" type="text" required="true"
													value="<%=leads == null ? "" : String.valueOf(leads.getAddress())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="Address 2" name="Address2" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getAddress2())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="Province" name="Province" type="text" required="true"
													value="<%=leads == null ? "" : String.valueOf(leads.getProvince())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:row>
													<aui:col width="50">
														<aui:input label="City" name="City" type="text"
															value="<%=leads == null ? "" : String.valueOf(leads.getCity())%>" />
													</aui:col>
													
													<aui:col width="50">
														<aui:input label="Zip" name="Zip" type="text" required="true"
															value="<%=leads == null ? "" : String.valueOf(leads.getZip())%>" />
													</aui:col>
												</aui:row>
											</aui:col>
										</aui:row>
									</aui:fieldset>
								</aui:fieldset-group>
								
								<aui:fieldset-group markupView="lexicon">
									<aui:fieldset cssClass="p-4" label="UTM" collapsible="true" collapsed="false">
										<aui:row>
											<aui:col width="50">
												<aui:input label="UtmSource" name="UtmSource" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getUtmSource())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="UtmMedium" name="UtmMedium" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getUtmMedium())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="UtmCampaign" name="UtmCampaign" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getUtmCampaign())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="UtmTerm" name="UtmTerm" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getUtmTerm())%>" />
											</aui:col>
										</aui:row>
										
										<aui:row>
											<aui:col width="50">
												<aui:input label="UtmContent" name="UtmContent" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getUtmContent())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="ClickId" name="ClickId" type="text"
													value="<%=leads == null ? "" : String.valueOf(leads.getClickId())%>" />
											</aui:col>
										</aui:row>
									</aui:fieldset>
								</aui:fieldset-group>
								
								<%
									if (leads != null) {
								%>
								<aui:input type="hidden" name="LeadsId"
									value="<%=String.valueOf(leads.getLeadsId())%>" />
								<%
									}
								%>
							</div>
					    </liferay-ui:section>
					    <liferay-ui:section>
					    	<% if(leads != null && String.valueOf(leads.getProductCode()) != "" && String.valueOf(leads.getProductCode()) != "null") { %>
					        <% String includeDetail = "/parents/details/" + String.valueOf(leads.getProductCode()).toLowerCase() + ".jsp"; %>
					        <jsp:include page="<%= includeDetail %>" flush="true">
					        	<jsp:param name="leadsId" value="<%= leadsId %>"/>
					        	<jsp:param name="leadsId" value="<%=String.valueOf(leads.getProductCode())%>"/>
					        </jsp:include>
					        <% } %>
					    </liferay-ui:section>
					    <liferay-ui:section>
					    	<%@ include file="includes/insured.jsp"%>
					    </liferay-ui:section>
					</liferay-ui:tabs>
					
					<aui:button-row>
						<aui:button name="submitButton" type="submit" value="Save" />
						<aui:button type="cancel" onClick="<%=parentsURL.toString()%>"></aui:button>
					</aui:button-row>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<aui:script use="liferay-search-container">
   	var selectUserButton = document.getElementById('<portlet:namespace />selectMypageUserId');
   	var searchContainer = Liferay.SearchContainer.get("user-parent-table");
   	var rowColumns = [];
	
   	selectUserButton.addEventListener('click', function(event) {
		
        new Liferay.Util.openSelectionModal({
            onSelect: function(event) {
            	var no_parent = document.getElementById('no-user-parent');
            	var row = `
            		<td>
		                <span>`+event.screenname+`</span>
		            </td>
		            <td>
		                <span>`+event.fullname+`</span>
		            </td>
		            <td>
		                <a onclick="removeMypageUserId(this)" id="remove-user-parent" href="javascript:;"><%= UnicodeFormatter.toString(removeLicenseIcon) %></a>
		            </td>`;
            	if(no_parent != null) no_parent.classList.add('d-none');
            	document.getElementById("user-parent-row").innerHTML = row;
            	document.<portlet:namespace />leads.<portlet:namespace />ManagedBy.value = event.entityid;
            	document.getElementById("user-parent-table").classList.remove('d-none')
            },
            title: 'Select User',
            <%
            	String eventName = liferayPortletResponse.getNamespace() + "selectMypageUser";
    			PortletURL selectUserURL = PortletProviderUtil.getPortletURL(renderRequest, MypageUser.class.getName(), PortletProvider.Action.BROWSE);
    			selectUserURL.setParameter("mvcPath", "/user/select_user.jsp");
    			selectUserURL.setParameter("eventName", eventName);
    			selectUserURL.setWindowState(LiferayWindowState.POP_UP);
            %>

            selectEventName: '<%= eventName %>',
            selectedData: [document.<portlet:namespace />leads.<portlet:namespace />ManagedBy.value],
            url: '<%= selectUserURL %>'
        });
	});
	
	removeMypageUserId = function(e) {
		var no_parent = document.getElementById('no-user-parent');
		document.getElementById("user-parent-row").innerHTML = "";
        document.<portlet:namespace />leads.<portlet:namespace />ManagedBy.value = "";
        document.getElementById("user-parent-table").classList.add('d-none')
        if(no_parent != null) no_parent.classList.remove('d-none');
	}
</aui:script>