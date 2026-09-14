<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
			liferayPortletResponse);

	// Search Container
	SearchContainer entriesSearchContainerPaymentchannel = masterDisplayContext.paymentchannelSearchContainer();

	// Management Toolbar Display Context
	MasterManagementToolbarDisplayContext masterManagementToolbarDisplayContext = new MasterManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerPaymentchannel);

	PortletURL iteratorURL = masterManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "paymentchannelSearchContainer";
	
	// get banks
	List<MasterBank> masterBanks = MasterBankLocalServiceUtil.getActiveBanks();
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "paymentchannel";
				final String _editPaymentchannelURL = editPaymentchannelURL;
			%>

			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="globe" markupView="lexicon" />
						<span class="pl-2 text-truncate">Paymentchannel</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=masterDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=masterManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="33">
									<aui:input label="Code" name="searchCode" type="text" />
								</aui:col>
								<aui:col width="33">
									<aui:input label="Name" name="searchName" type="text" />
								</aui:col>
								<aui:col width="33">
									<aui:select label="Bank Group" name="searchBank" showEmptyOption="true">
                                    	<%
                                         	if(! masterBanks.isEmpty()) {
                                           		for(MasterBank bank : masterBanks) {
                                        %>                                            
                                        <aui:option value="<%= bank.getMasterBankId() %>"><%= bank.getName() %></aui:option>
                                        <%
                                           		}
                                           	}
                                        %>
                                	</aui:select>
								</aui:col>
							</aui:row>
							<aui:button-row>
								<aui:button name="search[reset_button]" type="reset"
									value="Reset" href="<%=paymentchannelURL%>" primary="true"
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
					searchContainerId="paymentchannelSearchContainer"
					displayContext="<%=masterManagementToolbarDisplayContext%>" />
				<!--  MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportPaymentchannelURL">
					<portlet:param name="exportPaymentchannel"
						value="exportPaymentchannel" />
				</portlet:resourceURL>

				<aui:form action="<%=exportPaymentchannelURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="paymentchannel" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=paymentchannelURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="paymentchannel" />

					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="paymentchannelSearchContainer"
						searchContainer="<%=entriesSearchContainerPaymentchannel%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.PaymentChannel"
							modelVar="paymentchannel" keyProperty="paymentChannelId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/master/paymentchannel/edit.jsp" />
								<portlet:param name="paymentChannelId"
									value="<%=String.valueOf(paymentchannel.getPaymentChannelId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = paymentchannel.getActive() != 1 ? "status-inactive" : "status-active";
							%>
							
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap table-title" %>"
							    name="ID"
							    value="<%= String.valueOf(paymentchannel.getPaymentChannelId()) %>"
							    href="<%= rowURL %>"
							/>
							
							<liferay-ui:search-container-column-text property="code"
								title="Code" name="Code" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-text property="name"
								title="Name" name="Name" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<%
								MasterBank masterBank = null;
								if(paymentchannel.getMasterBankId() > 0) {
									masterBank = MasterBankLocalServiceUtil.fetchMasterBank(paymentchannel.getMasterBankId());
								}
							%>
							<liferay-ui:search-container-column-text
							    cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>"
							    name="Bank Group"
							    value="<%= paymentchannel.getMasterBankId() > 0 ? String.valueOf(masterBank.getName()) : "" %>"
							/>
							
							<liferay-ui:search-container-column-text property="minPayment"
								title="Minimum Payment" name="Minimum Payment" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />
							
							<liferay-ui:search-container-column-text property="maxPayment"
								title="Maximum Payment" name="Maximum Payment" valign="middle"
								cssClass="<%= classInactive + " table-cell-expand-smallest table-cell-ws-nowrap" %>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/master/paymentchannel/action.jsp" />

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