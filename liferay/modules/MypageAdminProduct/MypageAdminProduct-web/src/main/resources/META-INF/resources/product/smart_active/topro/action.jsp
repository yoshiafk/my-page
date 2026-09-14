<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartActiveTopro toproRow = (SmartActiveTopro) row.getObject();
	String publishText = toproRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingToproURL">
	<portlet:param name="toproId"
		value="<%= String.valueOf(toproRow.getSmartActiveToproId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/topro/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteToproURL" name="deleteTopro"
	copyCurrentRenderParameters="true">
	<portlet:param name="toproId" value="<%= String.valueOf(toproRow.getSmartActiveToproId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="toproId"
		value="<%= String.valueOf(toproRow.getSmartActiveToproId()) %>" />
	<portlet:param name="action"
		value="<%= toproRow.getActive() != 1 ? "publish" : "unpublish" %>" />
</portlet:actionURL>

<%
	final String _editExistingToproURL = editExistingToproURL;
	final String _deleteToproURL = deleteToproURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%= new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingToproURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			} %>" />