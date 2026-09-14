<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartActiveBenefitValue benefitValueRow = (SmartActiveBenefitValue) row.getObject();
	String publishText = benefitValueRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingBenefitValueURL">
	<portlet:param name="benefitValueId"
		value="<%= String.valueOf(benefitValueRow.getSmartActiveBenefitValueId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/benefit_value/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteBenefitValueURL" name="deleteBenefitValue"
	copyCurrentRenderParameters="true">
	<portlet:param name="benefitValueId" value="<%= String.valueOf(benefitValueRow.getSmartActiveBenefitValueId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="benefitValueId"
		value="<%= String.valueOf(benefitValueRow.getSmartActiveBenefitValueId()) %>" />
	<portlet:param name="action"
		value="<%= benefitValueRow.getActive() != 1 ? "publish" : "unpublish" %>" />
</portlet:actionURL>

<%
	final String _editExistingBenefitValueURL = editExistingBenefitValueURL;
	final String _deleteBenefitValueURL = deleteBenefitValueURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingBenefitValueURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />