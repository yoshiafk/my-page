<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterCountry masterCountryRow = (MasterCountry) row.getObject();
	String publishText = masterCountryRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingCountryURL">
	<portlet:param name="countryId"
		value="<%=String.valueOf(masterCountryRow.getCountryId())%>" />
	<portlet:param name="mvcPath" value="/master/country/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteCountryURL" name="deleteCountry"
	copyCurrentRenderParameters="true">
	<portlet:param name="countryId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="countryId"
		value="<%=String.valueOf(masterCountryRow.getCountryId())%>" />
	<portlet:param name="action"
		value="<%=masterCountryRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingCountryURL = editExistingCountryURL;
	final String _deleteCountryURL = deleteCountryURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingCountryURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />