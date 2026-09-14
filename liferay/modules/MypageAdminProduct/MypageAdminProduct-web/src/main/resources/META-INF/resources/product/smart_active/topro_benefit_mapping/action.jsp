<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartActiveToproBenefitMapping toproBenefitMappingRow = (SmartActiveToproBenefitMapping) row.getObject();
	String publishText = toproBenefitMappingRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingToproBenefitMappingURL">
	<portlet:param name="toproBenefitMappingId"
		value="<%= String.valueOf(toproBenefitMappingRow.getSmartActiveToproBenefitMappingId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/topro_benefit_mapping/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteToproBenefitMappingURL" name="deleteToproBenefitMapping"
	copyCurrentRenderParameters="true">
	<portlet:param name="toproBenefitMappingId" value="<%= String.valueOf(toproBenefitMappingRow.getSmartActiveToproBenefitMappingId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="toproBenefitMappingId"
		value="<%= String.valueOf(toproBenefitMappingRow.getSmartActiveToproBenefitMappingId()) %>" />
	<portlet:param name="action"
		value="<%= toproBenefitMappingRow.getActive() != 1 ? "publish" : "unpublish" %>" />
</portlet:actionURL>

<%
	final String _editExistingToproBenefitMappingURL = editExistingToproBenefitMappingURL;
	final String _deleteToproBenefitMappingURL = deleteToproBenefitMappingURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />