<%@ include file="../init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SppkUser sppkUserRow = (SppkUser) row.getObject();
	String publishText = sppkUserRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

 <portlet:renderURL var="editExisting">
	<portlet:param name="sppkUserId"
		value="<%=String.valueOf(sppkUserRow.getSppkUserId())%>" />
	<portlet:param name="mvcPath" value="/user/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteExisting" name="deleteSppkUser"
	copyCurrentRenderParameters="true">
	<portlet:param name="sppkUserId" value="" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusExisting">
	<portlet:param name="sppkUserId"
		value="<%=String.valueOf(sppkUserRow.getSppkUserId())%>" />
	<portlet:param name="action"
		value="<%=sppkUserRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>


<%
	final String editExistingURL = editExisting;
	final String deleteExistingURL = deleteExisting;
	final String setStatusUrl = setStatusExisting;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(editExistingURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />