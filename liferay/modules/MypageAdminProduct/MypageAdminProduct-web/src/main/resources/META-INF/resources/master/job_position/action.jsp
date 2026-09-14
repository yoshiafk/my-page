<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	JobPosition jobPositionRow = (JobPosition) row.getObject();
	String publishText = jobPositionRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingJobPositionURL">
	<portlet:param name="jobPositionId"
		value="<%=String.valueOf(jobPositionRow.getJobPositionId())%>" />
	<portlet:param name="mvcPath" value="/master/job_position/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteJobPositionURL" name="deleteJobPosition"
	copyCurrentRenderParameters="true">
	<portlet:param name="jobPositionId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="jobPositionId"
		value="<%=String.valueOf(jobPositionRow.getJobPositionId())%>" />
	<portlet:param name="action"
		value="<%=jobPositionRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingJobPositionURL = editExistingJobPositionURL;
	final String _deleteJobPositionURL = deleteJobPositionURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingJobPositionURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />