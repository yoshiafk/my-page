<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AgentFAQ faqRow = (AgentFAQ) row.getObject();
	String publishText = faqRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingFaqURL">
	<portlet:param name="agentFaqId"
		value="<%=String.valueOf(faqRow.getAgentFaqId())%>" />
	<portlet:param name="mvcPath" value="/faq/master/faq/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteFaqURL" name="deleteFaq"
	copyCurrentRenderParameters="true">
	<portlet:param name="agentFaqId" value="<%=String.valueOf(faqRow.getAgentFaqId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="agentFaqId"
		value="<%=String.valueOf(faqRow.getAgentFaqId())%>" />
	<portlet:param name="action"
		value="<%=faqRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingFaqURL = editExistingFaqURL;
	final String _deleteFaqURL = deleteFaqURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingFaqURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />