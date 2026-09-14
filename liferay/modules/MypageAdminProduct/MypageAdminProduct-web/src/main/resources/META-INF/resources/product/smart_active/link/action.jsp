<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartActiveLink linkRow = (SmartActiveLink) row.getObject();
	String publishText = linkRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingFileURL">
	<portlet:param name="linkId"
		value="<%= String.valueOf(linkRow.getSmartActiveLinkId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/link/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteFileURL" name="deleteFile"
	copyCurrentRenderParameters="true">
	<portlet:param name="linkId" value="<%= String.valueOf(linkRow.getSmartActiveLinkId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="linkId"
		value="<%= String.valueOf(linkRow.getSmartActiveLinkId()) %>" />
	<portlet:param name="action"
		value="<%= linkRow.getActive() != 1 ? "publish" : "unpublish" %>" />
</portlet:actionURL>

<%
	final String _editExistingFileURL = editExistingFileURL;
	final String _deleteFileURL = deleteFileURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%= new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingFileURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			} %>" />