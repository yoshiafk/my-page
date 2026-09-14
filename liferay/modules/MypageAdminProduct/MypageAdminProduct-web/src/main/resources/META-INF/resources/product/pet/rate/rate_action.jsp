<%@ include file="../includes/init.jsp"%>
<%@ page
	import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	PetRate petRateRow = (PetRate) row.getObject();
	String publishText = petRateRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingRateURL">
	<portlet:param name="petRateId"
		value="<%=String.valueOf(petRateRow.getPetRateId())%>" />
	<portlet:param name="mvcPath" value="/product/pet/rate/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deletePetRateURL" name="deleteRate"
	copyCurrentRenderParameters="true">
	<portlet:param name="petRateId"
		value="<%=String.valueOf(petRateRow.getPetRateId())%>" />
</portlet:actionURL>


<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="petRateId"
		value="<%=String.valueOf(petRateRow.getPetRateId())%>" />
	<portlet:param name="action"
		value="<%=petRateRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingRateURL = editExistingRateURL;
	final String _deletePetRateURL = deletePetRateURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingRateURL.toString());
						dropdownItem.setLabel("Edit");
					});

					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL);
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />