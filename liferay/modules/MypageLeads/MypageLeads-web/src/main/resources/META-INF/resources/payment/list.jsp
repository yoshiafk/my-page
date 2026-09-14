<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	PaymentDisplayContext paymentDisplayContext = new PaymentDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer _searchContainer = paymentDisplayContext.paymentSearchContainer();

	// Management Toolbar Display Context
	PaymentManagementToolbarDisplayContext paymentManagementToolbarDisplayContext = new PaymentManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, _searchContainer);

	PortletURL iteratorURL = paymentManagementToolbarDisplayContext._getCurrentSortingURL();
	
	// Variable to include in javascript
	String product = "paymentSearchContainer";
	
%>

<portlet:actionURL name="/payment/update_data" var="updateURL" />

<liferay-ui:success key="success-save-payment" message="Payment saved successfully!" /> 
<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="list" markupView="lexicon" />
						<span class="pl-2 text-truncate">Payment Parents</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=paymentDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=paymentManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							
							<aui:row>
								<aui:col width="25">
									<aui:input label="Leads Id" name="s_LeadsId" type="number" />
								</aui:col>
								<aui:col width="25">
									<aui:input label="Transaction Id" name="s_TransactionId" type="text" />
								</aui:col>
								<aui:col width="25">
									<aui:select label="Payment Status" name="s_PaymentStatus" showEmptyOption="true" >
										<aui:option value="pending" >Pending</aui:option>
										<aui:option value="success" >Success</aui:option>
										<aui:option value="refund" >Refund</aui:option>
									</aui:select>
								</aui:col>
								<%
								List<PaymentChannel> getPaymentChannels = PaymentChannelLocalServiceUtil.getPaymentChannels(0, PaymentChannelLocalServiceUtil.getPaymentChannelsCount());
								%>
								<aui:col width="25">
									<aui:select label="Payment Channel" name="s_PaymentChannelId" showEmptyOption="true">
										<%
											if(!getPaymentChannels.isEmpty()) {
												for(PaymentChannel pm : getPaymentChannels) {
										%>
										<aui:option value="<%= pm.getPaymentChannelId() %>" ><%= pm.getName() %></aui:option>
										<%
												}
											}
										%>
									</aui:select>
								</aui:col>
							</aui:row>
							<aui:row>
								<aui:col width="25">
									<aui:input label="Payment Message" name="s_PaymentMessage" type="text" />
								</aui:col>
								<aui:col width="25">
									<label class="control-label">Transaction Date On</label>
									<liferay-ui:input-date name="s_TransactionDateTime" nullable="true" />
								</aui:col>
								<aui:col width="25">
									<label class="control-label">Transaction Date After</label>
									<liferay-ui:input-date name="s_TransactionDateTimeAfter" nullable="true" />
								</aui:col>
								<aui:col width="25">
									<label class="control-label">Transaction Date Before</label>
									<liferay-ui:input-date name="s_TransactionDateTimeBefore" nullable="true" />
								</aui:col>
							</aui:row>
							
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=paymentURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!--  MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="paymentSearchContainer"
					displayContext="<%=paymentManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportParentsURL">
					<portlet:param name="exportParents"
						value="exportParents" />
				</portlet:resourceURL>

				<aui:form action="<%=exportParentsURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="province" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=parentsURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="payment" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="paymentSearchContainer"
						searchContainer="<%=_searchContainer%>">

						<liferay-ui:search-container-row className="com.mypage.leads.model.Payment" 
							modelVar="Payment" keyProperty="paymentId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/payment/edit.jsp" />
								<portlet:param name="paymentId"
									value="<%=String.valueOf(Payment.getPaymentId())%>" />
							</portlet:renderURL>
							

							<%
								String classInactive = Payment.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="Id"
							    value="<%= String.valueOf(Payment.getPaymentId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="leadsId"
								title="Leads Id" name="Leads Id" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<liferay-ui:search-container-column-text property="transactionId"
								title="Transaction Id" name="Transaction Id" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<liferay-ui:search-container-column-text property="paymentStatus"
								title="PaymentStatus" name="PaymentStatus" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text property="amount"
								title="Amount" name="Amount" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<%
								// get payment channel
								String paymentChannel = "";
								if(Payment.getPaymentChannelId() > 0) {								
									PaymentChannel getPaymentChannel = PaymentChannelLocalServiceUtil.getPaymentChannel(Payment.getPaymentChannelId());
									paymentChannel = getPaymentChannel.getName();
								}
							%>
							<liferay-ui:search-container-column-text
								value="<%= paymentChannel %>"
								title="Payment Channel" name="Payment Channel" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text property="transactionDateTime"
								title="Transaction Time" name="Transaction Time" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
								
							<liferay-ui:search-container-column-text
								value="<%= Payment.getPaymentDateTime() != null ? String.valueOf(Payment.getPaymentDateTime()) : "" %>"
								title="Payment Time" name="Payment Time" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/payment/action.jsp" />

						</liferay-ui:search-container-row>
						<liferay-ui:search-iterator markupView="lexicon" />
					</liferay-ui:search-container>
					<!-- SEARCH CONTAINER -->
				</aui:form>
			</div>
		</div>

	</div>
</div>

<%@ include file="../includes/listScript.jsp"%>