<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Industry industryRow = (Industry) row.getObject();
	String publishText = industryRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingIndustryURL">
	<portlet:param name="industryId"
		value="<%=String.valueOf(industryRow.getIndustryId())%>" />
	<portlet:param name="mvcPath" value="/master/industry/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteIndustryURL" name="deleteIndustry"
	copyCurrentRenderParameters="true">
	<portlet:param name="industryId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="industryId"
		value="<%=String.valueOf(industryRow.getIndustryId())%>" />
	<portlet:param name="action"
		value="<%=industryRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingIndustryURL = editExistingIndustryURL;
	final String _deleteIndustryURL = deleteIndustryURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingIndustryURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />