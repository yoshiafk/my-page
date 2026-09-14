<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartTravelIntPlan planRow = (SmartTravelIntPlan) row.getObject();
	String publishText = planRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingPlanURL">
	<portlet:param name="planId"
		value="<%=String.valueOf(planRow.getSmartTravelIntPlanId())%>" />
	<portlet:param name="mvcPath" value="/product/international_travel_standard_new/plan/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deletePlanURL" name="deletePlan"
	copyCurrentRenderParameters="true">
	<portlet:param name="planId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="planId"
		value="<%=String.valueOf(planRow.getSmartTravelIntPlanId())%>" />
	<portlet:param name="action"
		value="<%=planRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingPlanURL = editExistingPlanURL;
	final String _deletePlanURL = deletePlanURL;
	final String _setStatusUrl = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingPlanURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusUrl.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />