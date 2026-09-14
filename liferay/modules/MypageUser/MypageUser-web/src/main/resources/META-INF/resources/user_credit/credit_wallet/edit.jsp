<%@ include file="../../includes/init.jsp"%>

<%
	long creditWalletId = ParamUtil.getLong(renderRequest, "creditWalletId", 0);
	CreditWallet creditWallet = null;
	
	if (creditWalletId > 0) {
		creditWallet = CreditWalletLocalServiceUtil.fetchCreditWallet(creditWalletId);
	}
	
	// title
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(creditWalletURL.toString());
	renderResponse.setTitle(creditWalletId > 0 ? "Edit Credit Wallet" : "Add New Credit Wallet");

	// setting for menu
	String _active = "creditWallet";
%>

<liferay-ui:error key="failed" message="Your request failed." />
<liferay-ui:success key="success" message="Your request completed successfully." />

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
		<div class="col-lg-3">
			<%@ include file="/user_credit/left_menu.jsp"%>
		</div>
		<div class="col-lg-8">
			<aui:form action="<%=addCreditWalletURL%>" enctype="multipart/form-data" name="fm">
            	<clay:sheet>
            		<c:if test="<%= creditWalletId > 0 %>">
	            		<clay:sheet-header>
	            			<portlet:renderURL var="currentWalletURL">
								<portlet:param name="mvcPath" value="/user_credit/credit_wallet/edit.jsp" />
								<portlet:param name="creditWalletId"
									value="<%=String.valueOf(creditWalletId)%>" />
							</portlet:renderURL>
							<%
								final String currentWalletURL2 = currentWalletURL;
							%>
		            		<clay:navigation-bar
								navigationItems='<%=
									new JSPNavigationItemList(pageContext) {
										{
											add(
												navigationItem -> {
													navigationItem.setActive(true);
													navigationItem.setLabel("Wallet");
													navigationItem.setHref(currentWalletURL2);
												}
											);
											add(
												navigationItem -> {
													navigationItem.setLabel("History");
													navigationItem.setHref("#");
												}
											);
										}
									}
								%>'
							/>
						</clay:sheet-header>
					</c:if>
            	
            		<clay:sheet-header>
            			<h2 class="sheet-title">
	                        <div class="row">
	                            <div class="col-lg-10">
	                                <div class="d-flex">
	                                    <span class="pl-2 text-truncate text-capitalize"><%=creditWalletId > 0 ? "Edit Credit Wallet" : "Add New Credit Wallet"%></span>
	                                </div>
	                            </div>
	                            <div class="col-lg-2">
	                                <aui:input checked="<%= creditWallet != null ? creditWallet.getActive() == 1 ? true : false : true %>" name="active"
	                                    type="toggle-switch" value="1" label="Active"
	                                    wrapperCssClass="leftToggleTitle" />
	                            </div>
	                        </div>
	                    </h2>
            		</clay:sheet-header>
            		
            		<clay:sheet-section>
						<clay:content-row
						    containerElement="h3"
						    cssClass="sheet-subtitle"
						    >
						    <clay:content-col expand="<%= true %>">
						        <span class="heading-text">
						            Credit Type
						        </span>
						    </clay:content-col>
						    <clay:content-col>
						        <span class="heading-end">
						            <liferay-ui:icon
						                cssClass="add-credit-type"
						                id="selectCreditType"
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
						    name="creditTypeId" 
						    type="hidden"
						    value="<%=creditWallet == null ? "" : String.valueOf(creditWallet.getCreditTypeId())%>" />
							<aui:col width="100">
							    <p id="no-credit-type" class="text-muted pb-4 <%= creditWallet == null || (creditWallet != null && Validator.isNull(creditWallet.getCreditTypeId())) ? "" : "d-none" %>">
							        this user is not assigned any credit type
							    </p>
							    
							    <table 
							        class="show-quick-actions-on-hover table table-autofit table-heading-nowrap table-list mb-4 <%= creditWallet == null || (creditWallet != null && Validator.isNull(creditWallet.getCreditTypeId())) ? "d-none" : "" %>" 
							        id="credit-type-table"
							    >
							        <thead>
							            <tr>
							                <th class="lfr-title-column">Credit Type</th>
							                <th class="lfr-entry-action-column"> &nbsp; </th>
							            </tr>
							        </thead>
							        <tbody>
							            <tr id="credit-type-row">
							                <% if(creditWallet != null && !Validator.isNull(creditWallet.getCreditTypeId())) { %>
							                <td>
							                    <%
							                    	CreditType getCreditType = CreditTypeLocalServiceUtil.fetchCreditType(creditWallet.getCreditTypeId());
							                    %>
							                    <c:if test="<%= getCreditType != null %>">                    
								                    <span><%= getCreditType.getName() %></span>
							                    </c:if>
							                    <c:if test="<%= getCreditType == null %>">                    
								                    <span>Please Check, Credit Type with id <%= creditWallet.getCreditTypeId() %> not found</span>
							                    </c:if>
							                </td>
							                <td>
							                    <a onclick="removeCreditType(this)" id="remove-credit-type" href="javascript:;">
							                        <%= removeLicenseIcon %>
							                    </a>
							                </td>
							                <% } %>
							            </tr>
							        </tbody>
							    </table>
							</aui:col>
						</aui:row>
            			
						<aui:row cssClass="pb-4">
							<aui:col width="50">
						        <%
						            Integer dayIssued = null;
						            Integer monthIssued = null;
						            Integer yearIssued = null;
						            
						            if(creditWallet != null && String.valueOf(creditWallet.getDateIssued()) != "" && String.valueOf(creditWallet.getDateIssued()) != "null") {
						                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
						                LocalDate Dob = LocalDate.parse(date.format(creditWallet.getDateIssued()));
						            
						                dayIssued = Dob.getDayOfMonth();
						                monthIssued = Dob.getMonthValue() - 1;
						                yearIssued = Dob.getYear();
						            }
						        %>
						        <aui:row>
						            <aui:col width="100">
						                <label>Issued Date</label>
						            </aui:col>
						            <aui:col width="100">
						                <% if(creditWallet != null && String.valueOf(creditWallet.getDateIssued()) != "" && String.valueOf(creditWallet.getDateIssued()) != "null") { %>
						                <liferay-ui:input-date 
						                    name="dateIssued"
						                    dayValue="<%= dayIssued %>" 
						                    monthValue="<%= monthIssued %>"
						                    yearValue="<%= yearIssued %>" 
						                />
						                <% } else { %>
						                <liferay-ui:input-date 
						                    name="dateIssued"
						                    nullable="true"
						                    showDisableCheckbox="false"
						                />
						                <% } %>
						            </aui:col>
						        </aui:row>
						    </aui:col>
						    
						    <aui:col width="50">
						        <%
						            Integer dayExpired = null;
						            Integer monthExpired = null;
						            Integer yearExpired = null;
						            
						            if(creditWallet != null && String.valueOf(creditWallet.getDateExpired()) != "" && String.valueOf(creditWallet.getDateExpired()) != "null") {
						                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
						                LocalDate Dob = LocalDate.parse(date.format(creditWallet.getDateExpired()));
						            
						                dayExpired = Dob.getDayOfMonth();
						                monthExpired = Dob.getMonthValue() - 1;
						                yearExpired = Dob.getYear();
						            }
						        %>
						        <aui:row>
						            <aui:col width="100">
						                <label>Expired Date</label>
						            </aui:col>
						            <aui:col width="100">
						                <% if(creditWallet != null && String.valueOf(creditWallet.getDateExpired()) != "" && String.valueOf(creditWallet.getDateExpired()) != "null") { %>
						                <liferay-ui:input-date 
						                    name="dateExpired"
						                    dayValue="<%= dayExpired %>" 
						                    monthValue="<%= monthExpired %>"
						                    yearValue="<%= yearExpired %>" 
						                />
						                <% } else { %>
						                <liferay-ui:input-date 
						                    name="dateExpired"
						                    nullable="true"
						                    showDisableCheckbox="false"
						                />
						                <% } %>
						            </aui:col>
						        </aui:row>
						    </aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col width="50">
						        <aui:input label="Amount" name="amount" type="text"
						            value="<%= creditWallet != null ? creditWallet.getAmount() : "" %>">
						            <aui:validator name="number" />
						        </aui:input>
						    </aui:col>
						</aui:row>
						
						<%
							if (creditWallet != null) {
						%>
						<aui:input type="hidden" name="creditWalletId"
							value="<%=String.valueOf(creditWallet.getCreditWalletId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=creditWalletURL.toString()%>"></aui:button>
						</aui:button-row>
            		</clay:sheet-section>
            	</clay:sheet>
            </aui:form>
		</div>
	</div>
</div>

<aui:script use="liferay-search-container">
   	var selectCreditTypeButton = document.getElementById('<portlet:namespace />selectCreditType');
   	var searchCreditTypeContainer = Liferay.SearchContainer.get("credit-type-table");
   	var rowColumns = [];

   	selectCreditTypeButton.addEventListener('click', function(event) {
		
        new Liferay.Util.openSelectionModal({
            onSelect: function(event) {
            	var no_credit_type = document.getElementById('no-credit-type');
            	var row = `<td>
		                <span>`+event.entityname+`</span>
		            </td>
		            <td>
		                <a onclick="removeCreditType(this)" id="remove-credit-type" href="javascript:;"><liferay-ui:icon icon="times-circle" markupView="lexicon" /></a>
		            </td>`;
            	if(no_credit_type != null) no_credit_type.classList.add('d-none');
            	document.getElementById("credit-type-row").innerHTML = row;
            	document.<portlet:namespace />fm.<portlet:namespace />creditTypeId.value = event.entityid;
            	document.getElementById("credit-type-table").classList.remove('d-none')
            },
            title: 'Select Credit Type',
            <%
            	String eventName = liferayPortletResponse.getNamespace() + "selectCreditType";
    			PortletURL selectUserURL = PortletProviderUtil.getPortletURL(renderRequest, CreditType.class.getName(), PortletProvider.Action.BROWSE);
    			selectUserURL.setParameter("mvcPath", "/user_credit/credit_type/select_credit_type.jsp");
    			selectUserURL.setParameter("eventName", eventName);
    			selectUserURL.setWindowState(LiferayWindowState.POP_UP);
    			if(creditWallet != null) {
    				selectUserURL.setParameter("creditWalletId", String.valueOf(creditWallet.getCreditWalletId()));
    			}
            %>

            selectEventName: '<%= eventName %>',
            selectedData: [document.<portlet:namespace />fm.<portlet:namespace />creditTypeId.value],
            url: '<%= selectUserURL %>'
        });
	});
	
	removeCreditType = function(e) {
		var no_credit_type = document.getElementById('no-credit-type');
		document.getElementById("credit-type-row").innerHTML = "";
        document.<portlet:namespace />fm.<portlet:namespace />creditTypeId.value = "";
        document.getElementById("credit-type-table").classList.add('d-none')
        if(no_credit_type != null) no_credit_type.classList.remove('d-none');
	}
</aui:script>