<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartActiveClassRate classRateRow = (SmartActiveClassRate) row.getObject();
	String publishText = classRateRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingClassRateURL">
	<portlet:param name="classRateId"
		value="<%= String.valueOf(classRateRow.getSmartActiveClassRateId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/class_rate/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteClassRateURL" name="deleteClassRate"
	copyCurrentRenderParameters="true">
	<portlet:param name="classRateId" value="<%= String.valueOf(classRateRow.getSmartActiveClassRateId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="classRateId"
		value="<%= String.valueOf(classRateRow.getSmartActiveClassRateId()) %>" />
	<portlet:param name="action"
		value="<%= classRateRow.getActive() != 1 ? "publish" : "unpublish" %>" />
</portlet:actionURL>

<%
	final String _editExistingClassRateURL = editExistingClassRateURL;
	final String _deleteClassRateURL = deleteClassRateURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingClassRateURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />