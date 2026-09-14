<%@ include file="../includes/init.jsp"%>

<%
	InternationalTravelStandardNewDisplayContext _displayContext = new InternationalTravelStandardNewDisplayContext(
			liferayPortletRequest, liferayPortletResponse);
	SearchContainer _searchContainer = _displayContext.premiSearchContainer();

	InternationalTravelStandardNewManagementToolbarDisplayContext managementToolbar = new InternationalTravelStandardNewManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, _searchContainer);

	PortletURL iteratorURL = managementToolbar._getCurrentSortingURL();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				String _active = "premi";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>

		<div class="col-lg-9">
			<div class="sheet sheet-full">
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="list" markupView="lexicon" />
						<span class="pl-2 text-truncate">Premi</span>
					</div>
				</h2>

				<clay:management-toolbar displayContext="<%=managementToolbar%>"
					searchContainerId="intTravelStandardNewPremiSearchContainer"
					supportsBulkActions="<%=true%>" />

				<portlet:resourceURL var="exportPremiURL">
					<portlet:param name="exportPremi" value="exportPremi" />
				</portlet:resourceURL>

				<aui:form action="<%=exportPremiURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="EntryIds" type="hidden" />
				</aui:form>

				<portlet:actionURL name="multipleStatus" var="multipleStatusURL">
					<portlet:param name="mvcPath"
						value="/product/international_travel/premi/list.jsp" />
				</portlet:actionURL>

				<aui:form action="<%=multipleStatusURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden"
						value="<%=iteratorURL.toString()%>" />
					<aui:input name="EntryIds" type="hidden" />

					<clay:container-fluid>
						<liferay-ui:search-container
							id="intTravelStandardNewPremiSearchContainer"
							searchContainer="<%=_searchContainer%>">

							<liferay-ui:search-container-row
								className="com.mypage.admin.product.model.IntTravelStandardNewPremi"
								modelVar="intTravelStandardNewPremi"
								keyProperty="intTravelStandardNewPremiId"
								escapedModel="<%=true%>">
								<portlet:renderURL var="rowURL">
									<portlet:param name="mvcPath"
										value="/product/international_travel_standard_new/premi/edit.jsp" />
									<portlet:param name="premiId"
										value="<%=String.valueOf(intTravelStandardNewPremi.getIntTravelStandardNewPremiId())%>" />
								</portlet:renderURL>

								<portlet:actionURL name="setStatus" var="setStatusURL">
									<portlet:param name="premiId"
										value="<%=String.valueOf(intTravelStandardNewPremi.getIntTravelStandardNewPremiId())%>" />
									<portlet:param name="action"
										value="<%=intTravelStandardNewPremi.getActive() != 1 ? "publish" : "unpublish"%>" />
								</portlet:actionURL>

								<%
									String classInactive = intTravelStandardNewPremi.getActive() != 1 ? "Inactive" : "Active";

													String travelType = "";
													if (intTravelStandardNewPremi.getTravelType().equals("single")) {
														travelType = "Single";
													} else if (intTravelStandardNewPremi.getTravelType().equals("annual")) {
														travelType = "Annual";
													}

													String packageName = "";

													if (intTravelStandardNewPremi.getPackageType().equals("SPA")) {
														packageName = "Special Asia";
													} else if (intTravelStandardNewPremi.getPackageType().equals("GLD")) {
														packageName = "Gold";
													} else if (intTravelStandardNewPremi.getPackageType().equals("PLA")) {
														packageName = "Platinum";
													}

													String peopleType = "";
													if (intTravelStandardNewPremi.getPeopleType().equals("individual")) {
														peopleType = "Individual";
													} else if (intTravelStandardNewPremi.getPeopleType().equals("duo")) {
														peopleType = "Duo";
													} else if (intTravelStandardNewPremi.getPeopleType().equals("family")) {
														peopleType = "Family";
													}
								%>

								<liferay-ui:search-container-column-text
									property="intTravelStandardNewPremiId"
									cssClass="<%=classInactive%>" title="ID" name="ID"
									valign="middle" href="<%=rowURL%>" />
								<liferay-ui:search-container-column-text
									value="<%=travelType%>" cssClass="<%=classInactive%>"
									name="Travel Type" title="Travel Type" />
								<liferay-ui:search-container-column-text
									value="<%=packageName%>" cssClass="<%=classInactive%>"
									name="Package Type" title="Package Type" />
								<liferay-ui:search-container-column-text
									value="<%=peopleType%>" cssClass="<%=classInactive%>"
									name="Group" title="Group" />
									
								<liferay-ui:search-container-column-text value="1"
									cssClass="<%=classInactive%>" name="Main Insured"
									title="Main Insured" />
									
								<liferay-ui:search-container-column-text property="spouse"
									cssClass="<%=classInactive%>" name="Spouse" title="Spouse" />
									
								<liferay-ui:search-container-column-text property="child"
									cssClass="<%=classInactive%>" name="Child" title="Child" />
									
								<liferay-ui:search-container-column-text property="currency"
									cssClass="<%=classInactive%>" name="Currency" title="Currency" />
									
								<liferay-ui:search-container-column-text property="currency"
									cssClass="<%=classInactive%>" name="Currency" title="Currency" />

								<%
									DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
													String formattedAmount = decimalFormat.format(intTravelStandardNewPremi.getAmount());
								%>
								
								<liferay-ui:search-container-column-text value="<%= formattedAmount %>" cssClass="<%=classInactive%>" name="Amount" title="Amount" />								

							</liferay-ui:search-container-row>

							<liferay-ui:search-iterator markupView="lexicon" />
						</liferay-ui:search-container>
					</clay:container-fluid>
				</aui:form>

			</div>
		</div>
	</div>
</div>