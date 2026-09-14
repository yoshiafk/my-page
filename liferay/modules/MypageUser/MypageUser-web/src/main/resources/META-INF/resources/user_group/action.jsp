<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MypageUserGroup userGroupRow = (MypageUserGroup) row.getObject();
	String publishText = userGroupRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingUserGroupURL">
	<portlet:param name="mypageUserGroupId"
		value="<%=String.valueOf(userGroupRow.getMypageUserGroupId())%>" />
	<portlet:param name="mvcPath" value="/user_group/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteUserGroupURL" name="deleteUserGroup"
	copyCurrentRenderParameters="true">
	<portlet:param name="mypageUserGroupId" value="<%=String.valueOf(userGroupRow.getMypageUserGroupId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="mypageUserGroupId"
		value="<%=String.valueOf(userGroupRow.getMypageUserGroupId())%>" />
	<portlet:param name="action"
		value="<%=userGroupRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingUserGroupURL = editExistingUserGroupURL;
	final String _deleteUserGroupURL = deleteUserGroupURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingUserGroupURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />