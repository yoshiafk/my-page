<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CompanyType currentRow = (CompanyType) row.getObject();
	String publishText = currentRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingURL">
	<portlet:param name="companyTypeId"
		value="<%=String.valueOf(currentRow.getCompanyTypeId())%>" />
	<portlet:param name="mvcPath" value="/master/company_type/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="companyTypeId"
		value="<%=String.valueOf(currentRow.getCompanyTypeId())%>" />
	<portlet:param name="action"
		value="<%=currentRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingURL = editExistingURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />