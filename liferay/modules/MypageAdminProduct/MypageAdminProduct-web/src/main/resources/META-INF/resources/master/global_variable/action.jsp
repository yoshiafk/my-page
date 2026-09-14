<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterGlobalVariable masterGlobalVariableRow = (MasterGlobalVariable) row.getObject();
	String publishText = masterGlobalVariableRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingGlobalVariableURL">
	<portlet:param name="masterGlobalVariableId"
		value="<%=String.valueOf(masterGlobalVariableRow.getMasterGlobalVariableId())%>" />
	<portlet:param name="mvcPath" value="/master/global_variable/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteGlobalVariableURL" name="deleteGlobalVariable"
	copyCurrentRenderParameters="true">
	<portlet:param name="masterGlobalVariableId" value="<%=String.valueOf(masterGlobalVariableRow.getMasterGlobalVariableId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="masterGlobalVariableId"
		value="<%=String.valueOf(masterGlobalVariableRow.getMasterGlobalVariableId())%>" />
	<portlet:param name="action"
		value="<%=masterGlobalVariableRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingGlobalVariableURL = editExistingGlobalVariableURL;
	final String _deleteGlobalVariableURL = deleteGlobalVariableURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingGlobalVariableURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />