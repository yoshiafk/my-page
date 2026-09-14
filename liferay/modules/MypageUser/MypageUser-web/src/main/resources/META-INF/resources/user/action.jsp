<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MypageUser mypageUserRow = (MypageUser) row.getObject();
	String publishText = mypageUserRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingUserURL">
	<portlet:param name="liferayUserId"
		value="<%=String.valueOf(mypageUserRow.getLiferayUserId())%>" />
	<portlet:param name="mvcPath" value="/user/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="/mypageuser/update_data" var="setStatusURL">
    <portlet:param name="entryId" value="<%= String.valueOf(mypageUserRow.getMypageUserId()) %>" />
    <portlet:param name="<%= Constants.CMD %>" value="<%= mypageUserRow.getActive()==1?Constants.REMOVE:Constants.PUBLISH %>" />
    <portlet:param name="redirect" value="<%= userURL %>" />
    <portlet:param name="type" value="user" />
</portlet:actionURL>	

<%
	final String _editExistingUserURL = editExistingUserURL;
	final String _setStatusURL = setStatusURL;
%>

<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingUserURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />