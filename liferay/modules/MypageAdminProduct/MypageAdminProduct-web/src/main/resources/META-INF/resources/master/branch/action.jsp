<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterBranch masterBranchRow = (MasterBranch) row.getObject();
	String publishText = masterBranchRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingBranchURL">
	<portlet:param name="masterBranchId"
		value="<%=String.valueOf(masterBranchRow.getMasterBranchId())%>" />
	<portlet:param name="mvcPath" value="/master/branch/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteBranchURL" name="deleteBranch"
	copyCurrentRenderParameters="true">
	<portlet:param name="masterBranchId" value="" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="masterBranchId"
		value="<%=String.valueOf(masterBranchRow.getMasterBranchId())%>" />
	<portlet:param name="action"
		value="<%=masterBranchRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingBranchURL = editExistingBranchURL;
	final String _deleteBranchURL = deleteBranchURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingBranchURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />