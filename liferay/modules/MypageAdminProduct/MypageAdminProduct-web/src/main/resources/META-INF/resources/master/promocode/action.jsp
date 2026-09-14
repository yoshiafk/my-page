<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterPromoCode PromocodesRow = (MasterPromoCode) row.getObject();
	String publishText = PromocodesRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingPromocodeURL">
	<portlet:param name="promocodeId"
		value="<%=String.valueOf(PromocodesRow.getPromoCodeId())%>" />
	<portlet:param name="mvcPath" value="/master/promocode/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deletePromocodeURL" name="deletePromocode"
	copyCurrentRenderParameters="true">
	<portlet:param name="promocodeId"
		value="<%=String.valueOf(PromocodesRow.getPromoCodeId())%>" />
	<portlet:param name="action"
		value="delete" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="promocodeId"
		value="<%=String.valueOf(PromocodesRow.getPromoCodeId())%>" />
	<portlet:param name="action"
		value="<%=PromocodesRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingPromocodeURL = editExistingPromocodeURL;
	final String _deletePromocodeURL = deletePromocodeURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingPromocodeURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />