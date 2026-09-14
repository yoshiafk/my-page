<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	BlacklistCustomer blacklistCustomerRow = (BlacklistCustomer) row.getObject();
	String publishText = blacklistCustomerRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingBlacklistCustomerURL">
	<portlet:param name="blacklistCustomerId"
		value="<%=String.valueOf(blacklistCustomerRow.getBlacklistCustomerId())%>" />
	<portlet:param name="mvcPath"
		value="/master/blacklist_customer/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteBlacklistCustomerURL"
	name="deleteBlacklistCustomer" copyCurrentRenderParameters="true">
	<portlet:param name="blacklistCustomerId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="blacklistCustomerId"
		value="<%=String.valueOf(blacklistCustomerRow.getBlacklistCustomerId())%>" />
	<portlet:param name="action"
		value="<%=blacklistCustomerRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingBlacklistCustomerURL = editExistingBlacklistCustomerURL;
	final String _deleteBlacklistCustomerURL = deleteBlacklistCustomerURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingBlacklistCustomerURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />