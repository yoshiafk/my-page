<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AgentFAQCategory dataRow = (AgentFAQCategory) row.getObject();
	String publishText = dataRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingFaqCategoryURL">
	<portlet:param name="agentFaqCategoryId"
		value="<%=String.valueOf(dataRow.getAgentFaqCategoryId())%>" />
	<portlet:param name="mvcPath" value="/faq/master/category/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteFaqCategoryURL" name="deleteFaqCategory"
	copyCurrentRenderParameters="true">
	<portlet:param name="agentFaqCategoryId" value="<%=String.valueOf(dataRow.getAgentFaqCategoryId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="agentFaqCategoryId"
		value="<%=String.valueOf(dataRow.getAgentFaqCategoryId())%>" />
	<portlet:param name="action"
		value="<%=dataRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingFaqCategoryURL = editExistingFaqCategoryURL;
	final String _deleteFaqCategoryURL = deleteFaqCategoryURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingFaqCategoryURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />