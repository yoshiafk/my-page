<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ReferenceNumber referenceNumberRow = (ReferenceNumber) row.getObject();
	String publishText = referenceNumberRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingReferenceNumberURL">
	<portlet:param name="referenceNumberId"
		value="<%=String.valueOf(referenceNumberRow.getReferenceNumberId())%>" />
	<portlet:param name="mvcPath" value="/master/reference_number/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="/masterdata/update_data" var="deleteReferenceNumberURL">
    <portlet:param name="entryId" value="<%= String.valueOf(referenceNumberRow.getReferenceNumberId()) %>" />
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
    <portlet:param name="redirect" value="<%= referenceNumberURL %>" />
    <portlet:param name="type" value="referenceNumber" />
</portlet:actionURL>	

<portlet:actionURL name="/masterdata/update_data" var="setStatusURL">
    <portlet:param name="entryId" value="<%= String.valueOf(referenceNumberRow.getReferenceNumberId()) %>" />
    <portlet:param name="<%= Constants.CMD %>" value="<%= referenceNumberRow.getActive()==1?Constants.REMOVE:Constants.PUBLISH %>" />
    <portlet:param name="redirect" value="<%= referenceNumberURL %>" />
    <portlet:param name="type" value="referenceNumber" />
</portlet:actionURL>	

<%
	final String _editExistingReferenceNumberURL = editExistingReferenceNumberURL;
	final String _deleteReferenceNumberURL = deleteReferenceNumberURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingReferenceNumberURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_deleteReferenceNumberURL.toString());
						dropdownItem.setLabel("Delete");
					});
				}
			}%>" />