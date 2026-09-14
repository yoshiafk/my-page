<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterBank masterBankRow = (MasterBank) row.getObject();
	String publishText = masterBankRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingBankURL">
	<portlet:param name="masterBankId"
		value="<%=String.valueOf(masterBankRow.getMasterBankId())%>" />
	<portlet:param name="mvcPath" value="/master/bank/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteBankURL" name="deleteBank"
	copyCurrentRenderParameters="true">
	<portlet:param name="masterBankId" value="<%=String.valueOf(masterBankRow.getMasterBankId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="masterBankId"
		value="<%=String.valueOf(masterBankRow.getMasterBankId())%>" />
	<portlet:param name="action"
		value="<%=masterBankRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingBankURL = editExistingBankURL;
	final String _deleteBankURL = deleteBankURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingBankURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />