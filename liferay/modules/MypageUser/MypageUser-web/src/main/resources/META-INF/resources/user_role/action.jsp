<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MypageUserRole userRoleRow = (MypageUserRole) row.getObject();
	String publishText = userRoleRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingUserRoleURL">
	<portlet:param name="mypageUserRoleId"
		value="<%=String.valueOf(userRoleRow.getMypageUserRoleId())%>" />
	<portlet:param name="mvcPath" value="/user_role/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteUserRoleURL" name="deleteUserRole"
	copyCurrentRenderParameters="true">
	<portlet:param name="mypageUserRoleId" value="<%=String.valueOf(userRoleRow.getMypageUserRoleId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="mypageUserRoleId"
		value="<%=String.valueOf(userRoleRow.getMypageUserRoleId())%>" />
	<portlet:param name="action"
		value="<%=userRoleRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingUserRoleURL = editExistingUserRoleURL;
	final String _deleteUserRoleURL = deleteUserRoleURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingUserRoleURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />