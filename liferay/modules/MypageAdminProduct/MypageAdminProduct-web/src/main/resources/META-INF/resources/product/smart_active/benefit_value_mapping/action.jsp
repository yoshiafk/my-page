<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartActiveBenefitValueMapping benefitValueMappingRow = (SmartActiveBenefitValueMapping) row.getObject();
	String publishText = benefitValueMappingRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingBenefitValueMappingURL">
	<portlet:param name="benefitValueMappingId"
		value="<%= String.valueOf(benefitValueMappingRow.getSmartActiveBenefitValueMappingId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/benefit_value_mapping/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteBenefitValueMappingURL" name="deleteBenefitValueMapping"
	copyCurrentRenderParameters="true">
	<portlet:param name="benefitValueMappingId" value="<%= String.valueOf(benefitValueMappingRow.getSmartActiveBenefitValueMappingId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="benefitValueMappingId"
		value="<%= String.valueOf(benefitValueMappingRow.getSmartActiveBenefitValueMappingId()) %>" />
	<portlet:param name="action"
		value="<%= benefitValueMappingRow.getActive() != 1 ? "publish" : "unpublish" %>" />
</portlet:actionURL>

<%
	final String _editExistingBenefitValueMappingURL = editExistingBenefitValueMappingURL;
	final String _deleteBenefitValueMappingURL = deleteBenefitValueMappingURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingBenefitValueMappingURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />