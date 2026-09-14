<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterCurrency masterCurrencyRow = (MasterCurrency) row.getObject();
	String publishText = masterCurrencyRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingCurrencyURL">
	<portlet:param name="currencyId"
		value="<%=String.valueOf(masterCurrencyRow.getCurrencyId())%>" />
	<portlet:param name="mvcPath" value="/master/currency/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteCurrencyURL" name="deleteCurrency"
	copyCurrentRenderParameters="true">
	<portlet:param name="currencyId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="currencyId"
		value="<%=String.valueOf(masterCurrencyRow.getCurrencyId())%>" />
	<portlet:param name="action"
		value="<%=masterCurrencyRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingCurrencyURL = editExistingCurrencyURL;
	final String _deleteCurrencyURL = deleteCurrencyURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingCurrencyURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />