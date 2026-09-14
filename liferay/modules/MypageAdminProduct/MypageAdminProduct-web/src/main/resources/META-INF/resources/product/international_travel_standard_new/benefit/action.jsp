<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Benefit benefitRow = (Benefit) row.getObject();
	String publishText = benefitRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingBenefitURL">
	<portlet:param name="benefitId"
		value="<%=String.valueOf(benefitRow.getBenefitId())%>" />
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/benefit/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteBenefitURL" name="deleteBenefit"
	copyCurrentRenderParameters="true">
	<portlet:param name="benefitId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="benefitId"
		value="<%=String.valueOf(benefitRow.getBenefitId())%>" />
	<portlet:param name="action"
		value="<%=benefitRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingBenefitURL = editExistingBenefitURL;
	final String _deleteBenefitURL = deleteBenefitURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingBenefitURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />