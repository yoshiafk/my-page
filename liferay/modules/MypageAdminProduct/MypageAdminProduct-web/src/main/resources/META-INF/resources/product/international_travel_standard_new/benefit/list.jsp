<%@ include file="../includes/init.jsp"%>

<%
	// Display Context
	InternationalTravelStandardNewDisplayContext smartTravelInternationalDisplayContext = new InternationalTravelStandardNewDisplayContext(liferayPortletRequest,
			liferayPortletResponse);
		
	//Search Container
	SearchContainer entriesSearchContainerBenefit = smartTravelInternationalDisplayContext.benefitSearchContainer();

	// Management Toolbar Display Context
	InternationalTravelStandardNewManagementToolbarDisplayContext smartTravelInternationallManagementToolbarDisplayContext = new InternationalTravelStandardNewManagementToolbarDisplayContext(
					request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainerBenefit);			

	PortletURL iteratorURL = smartTravelInternationallManagementToolbarDisplayContext._getCurrentSortingURL();

	// Variable to include in javascript
	String product = "benefitSearchContainer";
	
	List<BenefitType> benefitTypes = BenefitTypeLocalServiceUtil.getActiveBenefitType();
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">

		<div class="col-lg-3">
			<%
				String _active = "benefit";
				final String _editBenefitURL = editBenefitURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Benefit</span>
					</div>
				</h2>
				<!-- TITLE -->

				<!--  COLLAPSIBLE PANEL -->
				<liferay-ui:panel collapsible="true" cssClass="p-3"
					defaultState="<%=smartTravelInternationalDisplayContext._getOnSearch() ? "open" : "collapsed"%>"
					extended="false" title="Search" iconCssClass="icon-search">

					<aui:form name="search"
						action="<%=smartTravelInternationallManagementToolbarDisplayContext._getSearchActionURL()%>"
						method="post">
						<liferay-ui:panel-container extended="false"
							id="innerPanelContainer">
							<aui:row>
								<aui:col width="45">
									<aui:input label="Name (Indonesia)" name="searchName" type="text" />
								</aui:col>
								
								<aui:col width="45">
									<aui:input label="Name (English)" name="searchNameEn" type="text" />
								</aui:col>
								
								<aui:col width="45">
									<aui:select label="Benefit Type" name="searchBenefitType">
										<aui:option value="" disabled="true" selected="true">Select Type</aui:option>
									    <% if (benefitTypes.size() > 0) {  %>
									    	<% for (int i = 0; i < benefitTypes.size(); i++) { 
									    		String benefitTypeName =  benefitTypes.get(i).getNameId();
											    if (benefitTypeName == null || benefitTypeName.isEmpty()) {
											        benefitTypeName = benefitTypes.get(i).getNameEn();
											    }
									    	%>
									    		<aui:option value="<%= benefitTypes.get(i).getBenefitTypeId() %>"><%= benefitTypeName %></aui:option>
									    	<% } %>
										<% } %>
									</aui:select>
								</aui:col>
								
							</aui:row>
							<aui:button-row>
								<aui:button name="search[search_button]" type="reset"
									value="Reset" href="<%=benefitURL%>" primary="true"
									icon="icon-repeat" />
								<aui:button name="search[search_button]" type="submit"
									value="Search" />
							</aui:button-row>
						</liferay-ui:panel-container>
					</aui:form>
				</liferay-ui:panel>
				<!--  COLLAPSIBLE PANEL -->

				<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="benefitSearchContainer"
					displayContext="<%=smartTravelInternationallManagementToolbarDisplayContext%>" />
				<!-- MANAGEMENT TOOLBAR -->

				<portlet:resourceURL var="exportBenefitURL">
					<portlet:param name="exportBenefit"
						value="exportBenefit" />
				</portlet:resourceURL>

				<aui:form action="<%=exportBenefitURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="benefit" type="hidden" />
				</aui:form>

				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=benefitURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="benefit" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="benefitSearchContainer"
						searchContainer="<%=entriesSearchContainerBenefit%>">

						<liferay-ui:search-container-row
							className="com.mypage.admin.product.model.Benefit"
							modelVar="benefit" keyProperty="benefitId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit/edit.jsp" />
								<portlet:param name="benefitId"
									value="<%=String.valueOf(benefit.getBenefitId())%>" />
							</portlet:renderURL>

							<%
								String classInactive = benefit.getActive() != 1 ? "status-inactive" : "status-active";
							%>

							<liferay-ui:search-container-column-text property="benefitId"
								title="ID" name="ID" valign="middle"
								cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="nameId"
								title="Name ID" name="Name (Indonesia)" valign="middle"
								cssClass="<%=classInactive%>" />
								
							<liferay-ui:search-container-column-text property="nameEn"
								title="Name English" name="Name (English)" valign="middle"
								cssClass="<%=classInactive%>" />
								
															<% 
								BenefitType benefitType = BenefitTypeLocalServiceUtil.getBenefitType(benefit.getBenefitTypeId());
							
							    String benefitTypeName = benefitType.getNameId();
							    if (benefitTypeName == null || benefitTypeName.isEmpty()) {
							        benefitTypeName = benefitType.getNameEn();
							    }
							%>
								
								<liferay-ui:search-container-column-text value="<%= benefitTypeName %>"
								title="Benefit Type" name="Benefit Type" valign="middle"
								cssClass="<%=classInactive%>" />
								
															<liferay-ui:search-container-column-text property="externalCode"
								title="External Code" name="External Code" valign="middle"
								cssClass="<%=classInactive%>" />
								
																
								
<%-- 							<liferay-ui:search-container-column-text property="planName" --%>
<%-- 								title="Plan Name" name="Plan Name" valign="middle" --%>
<%-- 								cssClass="<%=classInactive%>" /> --%>
								
<%-- 							<liferay-ui:search-container-column-text property="benefitValue" --%>
<%-- 								title="Benefit Value" name="Benefit Value" valign="middle" --%>
<%-- 								cssClass="<%=classInactive%>" /> --%>
								
							<liferay-ui:search-container-column-text property="sort"
								title="Sort" name="Sort" valign="middle"
								cssClass="<%=classInactive%>" />

							<liferay-ui:search-container-column-jsp name="Action"
								align="right" path="/product/international_travel_standard_new/benefit/action.jsp" />

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