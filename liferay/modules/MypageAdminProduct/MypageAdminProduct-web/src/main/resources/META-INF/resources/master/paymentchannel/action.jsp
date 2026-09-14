<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	PaymentChannel paymentchannelRow = (PaymentChannel) row.getObject();
	String publishText = paymentchannelRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingBankURL">
	<portlet:param name="paymentChannelId"
		value="<%=String.valueOf(paymentchannelRow.getPaymentChannelId())%>" />
	<portlet:param name="mvcPath" value="/master/paymentchannel/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteBankURL" name="deleteBank"
	copyCurrentRenderParameters="true">
	<portlet:param name="paymentChannelId" value="<%=String.valueOf(paymentchannelRow.getPaymentChannelId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="paymentChannelId"
		value="<%=String.valueOf(paymentchannelRow.getPaymentChannelId())%>" />
	<portlet:param name="action"
		value="<%=paymentchannelRow.getActive() != 1 ? "publish" : "unpublish"%>" />
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