<%@ include file="../includes/init.jsp"%>
<%@ page
	import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	PetPlan petPlanRow = (PetPlan) row.getObject();
	String publishText = petPlanRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingPlanURL">
	<portlet:param name="petPlanId"
		value="<%=String.valueOf(petPlanRow.getPetPlanId())%>" />
	<portlet:param name="mvcPath" value="/product/pet/plan/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deletePetPlanURL" name="deletePlan"
	copyCurrentRenderParameters="true">
	<portlet:param name="petPlanId" value="4562645" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="petPlanId"
		value="<%=String.valueOf(petPlanRow.getPetPlanId())%>" />
	<portlet:param name="action"
		value="<%=petPlanRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>


<%
	final String _editExistingPlanURL = editExistingPlanURL;
	final String _deletePlanURL = deletePetPlanURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingPlanURL.toString());
						dropdownItem.setLabel("Edit");
					});

					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL);
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />