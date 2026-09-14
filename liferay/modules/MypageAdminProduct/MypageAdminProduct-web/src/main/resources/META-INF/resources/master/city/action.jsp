<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterCity masterCityRow = (MasterCity) row.getObject();
	String publishText = masterCityRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingCityURL">
	<portlet:param name="masterCityId"
		value="<%=String.valueOf(masterCityRow.getMasterCityId())%>" />
	<portlet:param name="mvcPath" value="/master/city/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteCityURL" name="deleteCity"
	copyCurrentRenderParameters="true">
	<portlet:param name="masterCityId" value="<%=String.valueOf(masterCityRow.getMasterCityId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="masterCityId"
		value="<%=String.valueOf(masterCityRow.getMasterCityId())%>" />
	<portlet:param name="action"
		value="<%=masterCityRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingCityURL = editExistingCityURL;
	final String _deleteCityURL = deleteCityURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingCityURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />