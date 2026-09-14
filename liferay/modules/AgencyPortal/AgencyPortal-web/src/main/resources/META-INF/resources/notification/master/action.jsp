<%@ include file="includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AgentNotification notificationRow = (AgentNotification) row.getObject();
	String publishText = notificationRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingNotificationURL">
	<portlet:param name="agentNotificationId"
		value="<%=String.valueOf(notificationRow.getAgentNotificationId())%>" />
	<portlet:param name="mvcPath" value="/notification/master/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteNotificationURL" name="deleteNotification"
	copyCurrentRenderParameters="true">
	<portlet:param name="agentNotificationId" value="<%=String.valueOf(notificationRow.getAgentNotificationId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="agentNotificationId"
		value="<%=String.valueOf(notificationRow.getAgentNotificationId())%>" />
	<portlet:param name="action"
		value="<%=notificationRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingNotificationURL = editExistingNotificationURL;
	final String _deleteNotificationURL = deleteNotificationURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingNotificationURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />