<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	IndustryCategory industryCategoryRow = (IndustryCategory) row.getObject();
	String publishText = industryCategoryRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingIndustryCategoryURL">
	<portlet:param name="industryCategoryId"
		value="<%=String.valueOf(industryCategoryRow.getIndustryCategoryId())%>" />
	<portlet:param name="mvcPath" value="/master/industry_category/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteIndustryCategoryURL" name="deleteIndustryCategory"
	copyCurrentRenderParameters="true">
	<portlet:param name="industryCategoryId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="industryCategoryId"
		value="<%=String.valueOf(industryCategoryRow.getIndustryCategoryId())%>" />
	<portlet:param name="action"
		value="<%=industryCategoryRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingIndustryCategoryURL = editExistingIndustryCategoryURL;
	final String _deleteIndustryCategoryURL = deleteIndustryCategoryURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingIndustryCategoryURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />