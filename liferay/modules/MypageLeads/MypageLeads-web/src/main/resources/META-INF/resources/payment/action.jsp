<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Payment paymentRow = (Payment) row.getObject();
	String publishText = paymentRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingParentsURL">
	<portlet:param name="PaymentId"
		value="<%=String.valueOf(paymentRow.getPaymentId())%>" />
	<portlet:param name="mvcPath" value="/parents/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteParentsURL" name="deleteParents"
	copyCurrentRenderParameters="true">
	<portlet:param name="PaymentId" value="<%=String.valueOf(paymentRow.getPaymentId())%>" />
</portlet:actionURL>

<portlet:actionURL name="/payment/update_data" var="setStatusURL">
	<portlet:param name="entryId"
		value="<%=String.valueOf(paymentRow.getPaymentId())%>" />
	<portlet:param name="cmd"
		value="<%=paymentRow.getActive() != 1 ? Constants.PUBLISH : Constants.REMOVE %>" />
	<portlet:param name="type"
		value="payment" />
</portlet:actionURL>

<%
	String _editExistingParentsURL = editExistingParentsURL;
	String _deleteParentsURL = deleteParentsURL;
	String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingParentsURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />