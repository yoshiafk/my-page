<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartActiveOccupation occupationRow = (SmartActiveOccupation) row.getObject();
	String publishText = occupationRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingOccupationURL">
	<portlet:param name="occupationId"
		value="<%= String.valueOf(occupationRow.getSmartActiveOccupationId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/occupation/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteOccupationURL" name="deleteOccupation"
	copyCurrentRenderParameters="true">
	<portlet:param name="occupationId" value="<%= String.valueOf(occupationRow.getSmartActiveOccupationId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="occupationId"
		value="<%= String.valueOf(occupationRow.getSmartActiveOccupationId()) %>" />
	<portlet:param name="action"
		value="<%= occupationRow.getActive() != 1 ? "publish" : "unpublish" %>" />
</portlet:actionURL>

<%
	final String _editExistingOccupationURL = editExistingOccupationURL;
	final String _deleteOccupationURL = deleteOccupationURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%= new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingOccupationURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			} %>" />