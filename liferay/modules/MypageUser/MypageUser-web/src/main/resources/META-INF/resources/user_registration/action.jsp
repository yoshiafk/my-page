<%@ include file="../includes/init.jsp"%>

<%
	ResultRow _row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	UserRegistration row = (UserRegistration) _row.getObject();
	String publishText = row.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editURL">
	<portlet:param name="userRegistrationId"
		value="<%=String.valueOf(row.getUserRegistrationId())%>" />
	<portlet:param name="mvcPath" value="/user_registration/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="/mypageuserregistration/update_data" var="setStatusURL">
    <portlet:param name="entryId" value="<%= String.valueOf(row.getUserRegistrationId()) %>" />
    <portlet:param name="<%= Constants.CMD %>" value="<%= row.getActive()==1?Constants.REMOVE:Constants.PUBLISH %>" />
    <portlet:param name="redirect" value="<%= userRegistrationURL %>" />
    <portlet:param name="type" value="user_registration" />
</portlet:actionURL>	

<%
	final String _editURL = editURL;
	final String _setStatusURL = setStatusURL;
	final String _approveURL = approveUserRegistrationURL;
%>

<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_approveURL.toString());
						dropdownItem.setLabel("Approve");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});					
				}
			}%>" />