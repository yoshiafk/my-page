<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AgentCalendar calendarRow = (AgentCalendar) row.getObject();
	String publishText = calendarRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingCalendarURL">
	<portlet:param name="agentCalendarId"
		value="<%=String.valueOf(calendarRow.getAgentCalendarId())%>" />
	<portlet:param name="mvcPath" value="/dashboard/calendar/master/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteCalendarURL" name="deleteCalendar"
	copyCurrentRenderParameters="true">
	<portlet:param name="agentCalendarId" value="<%=String.valueOf(calendarRow.getAgentCalendarId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="agentCalendarId"
		value="<%=String.valueOf(calendarRow.getAgentCalendarId())%>" />
	<portlet:param name="action"
		value="<%=calendarRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingCalendarURL = editExistingCalendarURL;
	final String _deleteCalendarURL = deleteCalendarURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingCalendarURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />