<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	BenefitType benefitTypeRow = (BenefitType) row.getObject();
	String publishText = benefitTypeRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingBenefitTypeURL">
	<portlet:param name="benefitTypeId"
		value="<%=String.valueOf(benefitTypeRow.getBenefitTypeId())%>" />
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit_type/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteBenefitTypeURL" name="deleteBenefitType"
	copyCurrentRenderParameters="true">
	<portlet:param name="benefitTypeId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="benefitTypeId"
		value="<%=String.valueOf(benefitTypeRow.getBenefitTypeId())%>" />
	<portlet:param name="action"
		value="<%=benefitTypeRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingBenefitTypeURL = editExistingBenefitTypeURL;
	final String _deleteBenefitTypeURL = deleteBenefitTypeURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingBenefitTypeURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />