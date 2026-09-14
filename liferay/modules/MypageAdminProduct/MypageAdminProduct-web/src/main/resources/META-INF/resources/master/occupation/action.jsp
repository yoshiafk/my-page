<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterOccupation masterOccupationRow = (MasterOccupation) row.getObject();
	String publishText = masterOccupationRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingOccupationURL">
	<portlet:param name="masterOccupationId"
		value="<%=String.valueOf(masterOccupationRow.getMasterOccupationId())%>" />
	<portlet:param name="mvcPath" value="/master/occupation/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteOccupationURL" name="deleteOccupation"
	copyCurrentRenderParameters="true">
	<portlet:param name="masterOccupationId" value="" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="masterOccupationId"
		value="<%=String.valueOf(masterOccupationRow.getMasterOccupationId())%>" />
	<portlet:param name="action"
		value="<%=masterOccupationRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingOccupationURL = editExistingOccupationURL;
	final String _deleteOccupationURL = deleteOccupationURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingOccupationURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />