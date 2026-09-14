<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Leads leadsRow = (Leads) row.getObject();
	String publishText = leadsRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingParentsURL">
	<portlet:param name="LeadsId"
		value="<%=String.valueOf(leadsRow.getLeadsId())%>" />
	<portlet:param name="mvcPath" value="/parents/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteParentsURL" name="deleteParents"
	copyCurrentRenderParameters="true">
	<portlet:param name="LeadsId" value="<%=String.valueOf(leadsRow.getLeadsId())%>" />
</portlet:actionURL>

<portlet:actionURL name="/leads/update_data" var="setStatusURL">
	<portlet:param name="entryId"
		value="<%=String.valueOf(leadsRow.getLeadsId())%>" />
	<portlet:param name="cmd"
		value="<%=leadsRow.getActive() != 1 ? Constants.PUBLISH : Constants.REMOVE %>" />
	<portlet:param name="type"
		value="leads" />
</portlet:actionURL>

<%
	String _editExistingParentsURL = editExistingParentsURL;
	String _deleteParentsURL = deleteParentsURL;
	String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingParentsURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />