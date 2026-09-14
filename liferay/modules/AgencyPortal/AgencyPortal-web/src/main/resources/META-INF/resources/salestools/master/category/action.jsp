<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AgentCategorySalesTools salesToolsRow = (AgentCategorySalesTools) row.getObject();
	String publishText = salesToolsRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingCategorySalesToolsURL">
	<portlet:param name="agentCategorySalesToolsId"
		value="<%=String.valueOf(salesToolsRow.getAgentCategorySalesToolsId())%>" />
	<portlet:param name="mvcPath" value="/salestools/master/category/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteCategorySalesToolsURL" name="deleteCategorySalesTools"
	copyCurrentRenderParameters="true">
	<portlet:param name="agentCategorySalesToolsId" value="<%=String.valueOf(salesToolsRow.getAgentCategorySalesToolsId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="agentCategorySalesToolsId"
		value="<%=String.valueOf(salesToolsRow.getAgentCategorySalesToolsId())%>" />
	<portlet:param name="action"
		value="<%=salesToolsRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingCategorySalesToolsURL = editExistingCategorySalesToolsURL;
	final String _deleteCategorySalesToolsURL = deleteCategorySalesToolsURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingCategorySalesToolsURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />