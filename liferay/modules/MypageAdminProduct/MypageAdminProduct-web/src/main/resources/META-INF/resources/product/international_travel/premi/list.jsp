<%@ include file="../includes/init.jsp"%>

<%
	InternationalTravelDisplayContext _displayContext = new InternationalTravelDisplayContext(
			liferayPortletRequest, liferayPortletResponse);
	SearchContainer _searchContainer = _displayContext.premiSearchContainer();

	InternationalTravelManagementToolbarDisplayContext managementToolbar = new InternationalTravelManagementToolbarDisplayContext(
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
					searchContainerId="internationalTravelPremiSearchContainer" supportsBulkActions="<%=true%>" />

				<portlet:resourceURL var="exportPremiURL">
					<portlet:param name="exportPremi" value="exportPremi" />
				</portlet:resourceURL>

				<aui:form action="<%=exportPremiURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=iteratorURL.toString()%>" />
					<aui:input name="EntryIds" type="hidden" />
				</aui:form>

				<portlet:actionURL name="multipleStatus" var="multipleStatusURL">
					<portlet:param name="mvcPath" value="/product/international_travel/premi/list.jsp" />
				</portlet:actionURL>

				<aui:form action="<%=multipleStatusURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=iteratorURL.toString()%>" />
					<aui:input name="EntryIds" type="hidden" />

					<clay:container-fluid>
						<liferay-ui:search-container id="internationalTravelPremiSearchContainer"
							searchContainer="<%=_searchContainer%>">

							<liferay-ui:search-container-row
								className="com.mypage.admin.product.model.TravelInternationalPremi"
								modelVar="internationalTravelPremi" keyProperty="premiId" escapedModel="<%=true%>">

								<portlet:renderURL var="rowURL">
									<portlet:param name="mvcPath" value="/product/international_travel/premi/edit.jsp" />
									<portlet:param name="premiId"
										value="<%=String.valueOf(internationalTravelPremi.getPremiId())%>" />
								</portlet:renderURL>

								<portlet:actionURL name="setStatus" var="setStatusURL">
									<portlet:param name="premiId"
										value="<%=String.valueOf(internationalTravelPremi.getPremiId())%>" />
									<portlet:param name="action"
										value="<%=internationalTravelPremi.getActive() != 1 ? "publish" : "unpublish"%>" />
								</portlet:actionURL>

								<%
									String classInactive = internationalTravelPremi.getActive() != 1 ? "Inactive" : "Active";

													String packageName = "";

													if (internationalTravelPremi.getPackageType().equals("SPA")) {
														packageName = "Special Asia";
													} else if (internationalTravelPremi.getPackageType().equals("GLD")) {
														packageName = "Gold";
													} else if (internationalTravelPremi.getPackageType().equals("PLA")) {
														packageName = "Platinum";
													}
								%>

								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-150 table-title"%>"
									name="Package" value="<%=packageName%>" href="<%=rowURL%>" />

								<%
									String _group = "";

													if (internationalTravelPremi.getPeopleType().equals("individual")) {
														_group = "Sendiri";
													} else if (internationalTravelPremi.getPeopleType().equals("duo")) {
														_group = "Duo";
													} else if (internationalTravelPremi.getPeopleType().equals("family")) {
														_group = "Keluarga";
													}
								%>
								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-200"%>"
									name="Group" value="<%=_group%>" />

								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-200"%>"
									name="Currency" property="currency" />

								<%
									DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
													String formattedAmount = decimalFormat.format(internationalTravelPremi.getAmount());
								%>

								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-200"%>"
									name="Amount" value="<%=formattedAmount%>" />

								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-200"%>"
									name="Adult" property="adultCount" />

								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-200"%>"
									name="Child" property="childrenCount" />

								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-200"%>"
									name="Min Duration" property="minDuration" />

								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-200"%>"
									name="Max Duration" property="maxDuration" />

								<liferay-ui:search-container-column-text
									cssClass="<%=classInactive + " table-cell-expand-smallest table-cell-minw-200"%>"
									name="Status" value="<%=classInactive%>" />


								<liferay-ui:search-container-column-text>
									<liferay-ui:icon-menu cssClass="text-right" direction="left-side" markupView="lexicon"
										showWhenSingleIcon="<%=true%>">
										<liferay-ui:icon message="Edit" url="<%=rowURL%>" />
										<liferay-ui:icon
											message="<%=internationalTravelPremi.getActive() != 1 ? "Publish" : "Unpublish"%>"
											url="<%=setStatusURL%>" />
									</liferay-ui:icon-menu>
								</liferay-ui:search-container-column-text>

							</liferay-ui:search-container-row>

							<liferay-ui:search-iterator markupView="lexicon" />
						</liferay-ui:search-container>
					</clay:container-fluid>
				</aui:form>
			</div>
		</div>

	</div>
</div>