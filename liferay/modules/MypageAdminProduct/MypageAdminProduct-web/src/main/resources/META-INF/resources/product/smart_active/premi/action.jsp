<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	SmartActivePremi premiRow = (SmartActivePremi) row.getObject();
	String publishText = premiRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingPremiURL">
	<portlet:param name="premiId"
		value="<%= String.valueOf(premiRow.getSmartActivePremiId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/premi/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deletePremiURL" name="deletePremi"
	copyCurrentRenderParameters="true">
	<portlet:param name="premiId" value="<%= String.valueOf(premiRow.getSmartActivePremiId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="premiId"
		value="<%= String.valueOf(premiRow.getSmartActivePremiId()) %>" />
	<portlet:param name="action"
		value="<%=premiRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingPremiURL = editExistingPremiURL;
	final String _deletePremiURL = deletePremiURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingPremiURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />