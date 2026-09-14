<%@ include file="../includes/init.jsp"%>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil" %>

<%
	long paymentId = ParamUtil.getLong(renderRequest, "paymentId", 0);
	Payment payment = null;
	String paymentChannelName = "";

	if (paymentId > 0) {
		// set page title
		renderResponse.setTitle("Edit Payment "+paymentId);
		
		payment = PaymentLocalServiceUtil.fetchPayment(paymentId);
		paymentChannelName = PaymentChannelLocalServiceUtil.getPaymentChannel(payment.getPaymentChannelId()).getName();
	} else {
		// set page title
		renderResponse.setTitle("Add Payment");
	}
	
	List<PaymentChannel> getPaymentChannels = PaymentChannelLocalServiceUtil.getPaymentChannels(0, PaymentChannelLocalServiceUtil.getPaymentChannelsCount());
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
			<aui:form action="<%=addPaymentURL%>" name="payment">
				<div class="sheet sheet-full">
	
					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="globe" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=paymentId > 0 ? "Edit Payment" : "Add New Payment"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input checked="<%= paymentId != 0 && payment != null ? payment.getActive() == 1 ? true : false : true %>" name="active"
									type="toggle-switch" value="1" label="Active"
									wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>
	
					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="p-4" label="Dependencies" collapsible="true" collapsed="false" helpMessage="Please edit this depencies carefully!">
								<aui:row>
									<aui:col width="50">
										<% 
											String leadsLink = ""; 
										  	if(payment != null && payment.getLeadsId() > 0) { 
										%>
											<portlet:renderURL var="leadsURL">
												<portlet:param name="mvcPath" value="/parents/edit.jsp" />
												<portlet:param name="LeadsId"
													value="<%=String.valueOf(payment.getLeadsId())%>" />
											</portlet:renderURL>
										<% 
												leadsLink = "<a href='"+ leadsURL +"'><i class='icon-edit'></i> Open</a>";
										  	} 
										%>
									
										<aui:input label="Leads Id" name="LeadsId" type="number"
											required="true"
											value="<%=payment == null ? "" : String.valueOf(payment.getLeadsId())%>" suffix="<%= leadsLink %>" />
									</aui:col>
									
									<aui:col width="50">
										<%
											String paymentUrl = "";
											if(payment != null && payment.getLeadsId() > 0) { 
												paymentUrl = "<a href='"+PortalUtil.getPortalURL(renderRequest)+"/group/guest/~/control_panel/manage/-/masterData/paymentchannel/edit?_com_mypage_admin_product_MasterAdminPortlet_paymentChannelId="+String.valueOf(payment.getPaymentChannelId())+"'><i class='icon-edit'></i> Open</a>";
											}
										%>
										<aui:input label="Payment Channel Id" type="number" name="paymentchannelidtext"
											disabled="true"
											value="<%=payment == null ? "" : String.valueOf(payment.getPaymentChannelId())%>" suffix="<%= paymentUrl %>" />
									</aui:col>	
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Managed By Id" name="ManagedBy" type="number"
											value="<%=payment == null ? "" : payment.getManagedBy() != 0 ? String.valueOf(payment.getManagedBy()) : ""%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="User Credit Id" name="UserCreditId" type="number"
											value="<%=payment == null ? "" : payment.getUserCreditId() != 0 ? String.valueOf(payment.getUserCreditId()) : ""%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Utm Id" name="UtmId" type="number"
											value="<%=payment == null ? "" : payment.getUtmId() != 0 ? String.valueOf(payment.getUtmId()) : ""%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>
						
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="p-4" label="Details" collapsible="true" collapsed="false">
								<aui:row>
									<aui:col width="50">
										<aui:input label="Transaction Id" name="TransactionId" type="text"
											required="true"
											value="<%=payment == null ? "" : String.valueOf(payment.getTransactionId())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Session Id" name="SessionId" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getSessionId())%>" />
									</aui:col>
								</aui:row>

								<aui:row>
									<aui:col width="50">
										<aui:select label="Payment Status" name="PaymentStatus" showEmptyOption="true" required="true" >
											<aui:option value="pending" selected="<%= payment != null && payment.getPaymentStatus().equals("pending") %>">Pending</aui:option>
											<aui:option value="success" selected="<%= payment != null && payment.getPaymentStatus().equals("success") %>">Success</aui:option>
											<aui:option value="refund" selected="<%= payment != null && payment.getPaymentStatus().equals("refund") %>">Refund</aui:option>
										</aui:select>
									</aui:col>
									<aui:col width="50">
										<aui:select label="Payment Channel" name="PaymentChannelId" showEmptyOption="true" required="true">
											<%
												if(!getPaymentChannels.isEmpty()) {
													for(PaymentChannel pm : getPaymentChannels) {
											%>
											<aui:option value="<%= pm.getPaymentChannelId() %>" selected="<%= payment != null && pm.getPaymentChannelId() == payment.getPaymentChannelId() %>"><%= pm.getName() %></aui:option>
											<%
													}
												}
											%>
										</aui:select>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Credit Card Type" name="CreditCardType" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getCreditCardType())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Bank" name="Bank" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getBank())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Amount" name="Amount" type="text"
											required="true"
											value="<%=payment == null ? "" : String.valueOf(payment.getAmount())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:row>
											<aui:col width="50">
												<aui:input label="Discount" name="Discount" type="text"
													value="<%=payment == null ? "" : String.valueOf(payment.getDiscount())%>" />
											</aui:col>
											
											<aui:col width="50">
												<aui:input label="Discount Amount" name="DiscountAmount" type="text"
													value="<%=payment == null ? "" : String.valueOf(payment.getDiscountAmount())%>" />
											</aui:col>
										</aui:row>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Payment Code" name="PaymentCode" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getPaymentCode())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Tenor" name="Tenor" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getTenor())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="Payment Message" name="PaymentMessage" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getPaymentMessage())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<%
											Integer day = null;
											Integer month = null;
											Integer year = null;
											String timeVal = "";
											
											if(payment != null && String.valueOf(payment.getTransactionDateTime()) != "") {
												SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
												SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
												LocalDate TransactionDateTime = LocalDate.parse(date.format(payment.getTransactionDateTime()));
											
												day = TransactionDateTime.getDayOfMonth();
												month = TransactionDateTime.getMonthValue() - 1;
												year = TransactionDateTime.getYear();
												timeVal = time.format(payment.getTransactionDateTime());
											}
										%>
										<aui:row>
											<aui:col width="100">
												<label>Transaction Date Time</label>
											</aui:col>
											<aui:col width="50">
												<% if(payment != null && String.valueOf(payment.getTransactionDateTime()) != "" && String.valueOf(payment.getTransactionDateTime()) != "null") { %>
												<liferay-ui:input-date 
													name="TransactionDateTime"
													dayValue="<%= day %>" 
													monthValue="<%= month %>"
													yearValue="<%= year %>" 
												/>
												<% } else { %>
												<liferay-ui:input-date 
													name="TransactionDateTime"
													nullable="true"
												/>
												<% } %>
											</aui:col>
											<aui:col width="50">
												<div class="form-group">
													<aui:input label="" name="TransactionDateTime_time" type="text" value="<%=timeVal%>" placeholder="hh:mm:ss" />
												</div>
											</aui:col>
										</aui:row>
									</aui:col>
									
									<aui:col width="50">
										<%
											Integer dayP = null;
											Integer monthP = null;
											Integer yearP = null;
											String timeValP = "";
											
											if(payment != null && String.valueOf(payment.getPaymentDateTime()) != "" && String.valueOf(payment.getPaymentDateTime()) != "null") {
												SimpleDateFormat dateP = new SimpleDateFormat("yyyy-MM-dd");
												SimpleDateFormat timeP = new SimpleDateFormat("HH:mm:ss");
												LocalDate PaymentDateTime = LocalDate.parse(dateP.format(payment.getPaymentDateTime()));
											
												dayP = PaymentDateTime.getDayOfMonth();
												monthP = PaymentDateTime.getMonthValue() - 1;
												yearP = PaymentDateTime.getYear();
												timeValP = timeP.format(payment.getPaymentDateTime());
											}
										%>
										<aui:row>
											<aui:col width="100">
												<label>Payment Date Time</label>
											</aui:col>
											<aui:col width="50">
											<% if(payment != null && String.valueOf(payment.getPaymentDateTime()) != "" && String.valueOf(payment.getPaymentDateTime()) != "null") { %>
												<liferay-ui:input-date
													name="PaymentDateTime"
													dayValue="<%= dayP %>" 
													monthValue="<%= monthP %>"
													yearValue="<%= yearP %>" 
													nullable="true"
												/>
											<% } else { %>
												<liferay-ui:input-date
													name="PaymentDateTime"
													nullable="true"
												/>
											<% } %>
											</aui:col>
											<aui:col width="50">
												<aui:input label="" name="PaymentDateTime_time" type="text" value="<%=timeValP%>" placeholder="hh:mm:ss" />
											</aui:col>
										</aui:row>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="LinkAjaRefNum" name="LinkAjaRefNum" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getLinkAjaRefNum())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Check Status Counter" name="CheckStatusCounter" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getCheckStatusCounter())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Report Generated" name="ReportGenerated" type="checkbox"
											value="1" checked="<%=payment != null && payment.getReportGenerated() == 1 %>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Daily Report Generated" name="DailyReportGenerated" type="checkbox"
											value="1" checked="<%=payment != null && payment.getDailyReportGenerated() == 1 %>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Weekly Report Generated" name="WeeklyReportGenerated" type="checkbox"
											value="1" checked="<%=payment != null && payment.getWeeklyReportGenerated() == 1 %>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Monthly Report Generated" name="MonthlyReportGenerated" type="checkbox"
											value="1" checked="<%=payment != null && payment.getMonthlyReportGenerated() == 1 %>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>
						
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="p-4" label="Agent Credit Limit" collapsible="true" collapsed="false">
								<aui:row>
									<aui:col width="50">
										<aui:select label="Credit Payment Status" name="CreditPaymentStatus" showEmptyOption="true">
											<aui:option value="paid" selected="<%= payment != null && payment.getCreditPaymentStatus().equals("paid") %>">Paid</aui:option>
											<aui:option value="unpaid" selected="<%= payment != null && payment.getCreditPaymentStatus().equals("unpaid") %>">Unpaid</aui:option>
										</aui:select>
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Settlement Invoice No" name="CreditTransactionId" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getCreditTransactionId())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<%
											Integer dayC = null;
											Integer monthC = null;
											Integer yearC = null;
											String timeValC = "";
											
											if(payment != null && String.valueOf(payment.getCreditPaymentDate()) != "" && String.valueOf(payment.getCreditPaymentDate()) != "null") {
												SimpleDateFormat dateC = new SimpleDateFormat("yyyy-MM-dd");
												SimpleDateFormat timeC = new SimpleDateFormat("HH:mm:ss");
												LocalDate CreditPaymentDate = LocalDate.parse(dateC.format(payment.getCreditPaymentDate()));
											
												dayC = CreditPaymentDate.getDayOfMonth();
												monthC = CreditPaymentDate.getMonthValue() - 1;
												yearC = CreditPaymentDate.getYear();
												timeValC = timeC.format(payment.getPaymentDateTime());
											}
										%>
										<aui:row>
											<aui:col width="100">
												<label>Settlement Date</label>
											</aui:col>
											<aui:col width="50">
											<% if(payment != null && String.valueOf(payment.getCreditPaymentDate()) != "" && String.valueOf(payment.getCreditPaymentDate()) != "null") { %>
												<liferay-ui:input-date
													name="CreditPaymentDate"
													dayValue="<%= dayC %>" 
													monthValue="<%= monthC %>"
													yearValue="<%= yearC %>" 
													nullable="true"
												/>
											<% } else { %>
												<liferay-ui:input-date
													name="CreditPaymentDate"
													nullable="true"
												/>
											<% } %>
											</aui:col>
											<aui:col width="50">
												<aui:input label="" name="CreditPaymentDate_time" type="text" value="<%=timeValC%>" placeholder="hh:mm:ss" />
											</aui:col>
										</aui:row>
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Credit Bank" name="CreditBank" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getCreditBank())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:select label="Credit Payment Channel" name="CreditPaymentChannelId" showEmptyOption="true">
											<%
												if(!getPaymentChannels.isEmpty()) {
													for(PaymentChannel pm : getPaymentChannels) {
											%>
											<aui:option value="<%= pm.getPaymentChannelId() %>" selected="<%= payment != null && pm.getPaymentChannelId() == payment.getCreditPaymentChannelId() %>"><%= pm.getName() %></aui:option>
											<%
													}
												}
											%>
										</aui:select>
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Credit Payment Code" name="CreditPaymentCode" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getCreditPaymentCode())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="Credit Payment Message" name="CreditPaymentMessage" type="text"
											value="<%=payment == null ? "" : String.valueOf(payment.getCreditPaymentMessage())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Report Settlement Generated" name="ReportSettlementGenerated" type="checkbox"
											value="1" checked="<%=payment != null && payment.getReportSettlementGenerated() == 1 %>"  />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>
						
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="p-4" label="Tracker" collapsible="true" collapsed="false">
								<aui:row>
									<aui:col width="33">
										<aui:input label="Sojern" name="Sojern" type="checkbox"
											value="1" checked="<%=payment != null && payment.getSojern() == 1 %>" />
									</aui:col>
									
									<aui:col width="33">
										<aui:input label="InvolveAsia" name="InvolveAsia" type="checkbox"
											value="1" checked="<%=payment != null && payment.getInvolveAsia() == 1 %>" />
									</aui:col>
									
									<aui:col width="33">
										<aui:input label="Ada" name="Ada" type="checkbox"
											value="1" checked="<%=payment != null && payment.getAda() == 1 %>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (payment != null) {
						%>
						<aui:input type="hidden" name="paymentId"
							value="<%=String.valueOf(payment.getPaymentId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=paymentURL.toString()%>"></aui:button>
						</aui:button-row>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>
