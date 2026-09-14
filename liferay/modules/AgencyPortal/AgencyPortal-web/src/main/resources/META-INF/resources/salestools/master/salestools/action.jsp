<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AgentSalesTools salesToolsRow = (AgentSalesTools) row.getObject();
	String publishText = salesToolsRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingSalesToolsURL">
	<portlet:param name="agentSalesToolsId"
		value="<%=String.valueOf(salesToolsRow.getAgentSalesToolsId())%>" />
	<portlet:param name="mvcPath" value="/salestools/master/salestools/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteSalesToolsURL" name="deleteSalesTools"
	copyCurrentRenderParameters="true">
	<portlet:param name="agentSalesToolsId" value="<%=String.valueOf(salesToolsRow.getAgentSalesToolsId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="agentSalesToolsId"
		value="<%=String.valueOf(salesToolsRow.getAgentSalesToolsId())%>" />
	<portlet:param name="action"
		value="<%=salesToolsRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingSalesToolsURL = editExistingSalesToolsURL;
	final String _deleteSalesToolsURL = deleteSalesToolsURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingSalesToolsURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />