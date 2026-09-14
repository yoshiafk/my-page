<%@ include file="../includes/init.jsp"%>

<%
	InternationalTravelStandardNewDisplayContext smartTravelInternationalDisplayContext = new InternationalTravelStandardNewDisplayContext(liferayPortletRequest, liferayPortletResponse);
	SearchContainer entriesSearchContainer = smartTravelInternationalDisplayContext.linkSearchContainer();
	
	InternationalTravelStandardNewManagementToolbarDisplayContext smartTravelInternationallManagementToolbarDisplayContext = new InternationalTravelStandardNewManagementToolbarDisplayContext(
			request, liferayPortletRequest, liferayPortletResponse, entriesSearchContainer);
	
	PortletURL iteratorURL = smartTravelInternationallManagementToolbarDisplayContext._getCurrentSortingURL();
	String product = "linkSearchContainer";
%>

<portlet:actionURL name="/masterdata/update_data" var="updateURL" />

<liferay-ui:success key="dataAdded" message="data-added" />
<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				String _active = "link";
				final String _editLinkURL = editLinkURL;
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		
				<div class="col-lg-9">
			<div class="sheet sheet-full">

				<!-- TITLE -->
				<h2 class="sheet-title">
					<div class="d-flex">
						<aui:icon cssClass="" image="categories" markupView="lexicon" />
						<span class="pl-2 text-truncate">Links</span>
					</div>
				</h2>
				<!-- TITLE -->
				
								<!-- MANAGEMENT TOOLBAR -->
				<clay:management-toolbar supportsBulkActions="<%=true%>"
					searchContainerId="linkSearchContainer"
					displayContext="<%=smartTravelInternationallManagementToolbarDisplayContext%>" />
				<!-- MANAGEMENT TOOLBAR -->
				
				<portlet:resourceURL var="exportLinkURL">
					<portlet:param name="exportLink" value="exportLink" />
				</portlet:resourceURL>

				<aui:form action="<%=exportLinkURL%>" name="fmExport">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=iteratorURL.toString()%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" value="premi" type="hidden" />
				</aui:form>
				
				
				<aui:form action="<%=updateURL%>" name="fm">
					<aui:input name="<%=Constants.CMD%>" type="hidden" />
					<aui:input name="redirect" type="hidden" value="<%=linkURL%>" />
					<aui:input name="entryIds" type="hidden" />
					<aui:input name="type" type="hidden" value="link" />
					
					<!-- SEARCH CONTAINER -->
					<liferay-ui:search-container id="linkSearchContainer" searchContainer="<%=entriesSearchContainer%>">

						<liferay-ui:search-container-row className="com.mypage.admin.product.model.SmartTravelIntLink" modelVar="link" keyProperty="smartTravelIntLinkId">

							<portlet:renderURL var="rowURL">
								<portlet:param name="mvcPath" value="/product/international_travel_standard_new/link/edit.jsp" />
								<portlet:param name="smartTravelIntLinkId" value="<%=String.valueOf(link.getSmartTravelIntLinkId())%>" />
							</portlet:renderURL>

							<%
								//String classInactive = premi.getActive() != 1 ? "status-inactive" : "status-active";
								String classInactive = "status-active";
							%>

							<liferay-ui:search-container-column-text property="smartTravelIntLinkId"
								title="ID" name="ID" valign="middle" cssClass="<%=classInactive%>" href="<%=rowURL%>" />

							<liferay-ui:search-container-column-text property="linkType" title="Type" name="Type" valign="middle" cssClass="<%=classInactive%>" />
							<liferay-ui:search-container-column-text property="linkTitle" title="Title" name="Title" valign="middle" cssClass="<%=classInactive%>" />
							<liferay-ui:search-container-column-text property="linkHref" title="HREF" name="HREF" valign="middle" cssClass="<%=classInactive%>" />
							
<%-- 							<liferay-ui:search-container-column-jsp name="Action" align="right" path="/product/international_travel_standard_new/link/action.jsp" /> --%>

						</liferay-ui:search-container-row>

						<liferay-ui:search-iterator markupView="lexicon" />

					</liferay-ui:search-container>
					<!-- SEARCH CONTAINER -->
				</aui:form>
				
				</div>
				</div>
	</div>
</div>