<%@ include file="../../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CreditType creditTypeRow = (CreditType) row.getObject();
	String publishText = creditTypeRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingURL">
	<portlet:param name="creditTypeId"
		value="<%=String.valueOf(creditTypeRow.getCreditTypeId())%>" />
	<portlet:param name="mvcPath" value="/user_credit/credit_type/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="/user_credit/update_data" var="deleteURL">
    <portlet:param name="entryId" value="<%= String.valueOf(creditTypeRow.getCreditTypeId()) %>" />
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
    <portlet:param name="redirect" value="<%= creditTypeURL %>" />
    <portlet:param name="type" value="creditType" />
</portlet:actionURL>

<portlet:actionURL name="/user_credit/update_data" var="setStatusURL">
    <portlet:param name="entryId" value="<%= String.valueOf(creditTypeRow.getCreditTypeId()) %>" />
    <portlet:param name="<%= Constants.CMD %>" value="<%= creditTypeRow.getActive()==1?Constants.REMOVE:Constants.PUBLISH %>" />
    <portlet:param name="redirect" value="<%= creditTypeURL %>" />
    <portlet:param name="type" value="creditType" />
</portlet:actionURL>

<%
	final String _editExistingURL = editExistingURL;
	final String _deleteURL = deleteURL;
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
					add(dropdownItem -> {
						dropdownItem.setHref(_deleteURL.toString());
						dropdownItem.setLabel("Delete");
					});
				}
			}%>" />