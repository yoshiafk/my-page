<%@ include file="../includes/init.jsp"%>
<%@ page
	import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	PetRemarks petRemarksRow = (PetRemarks) row.getObject();
	String publishText = petRemarksRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingRemarksURL">
	<portlet:param name="petRemarksId"
		value="<%=String.valueOf(petRemarksRow.getPetRemarksId())%>" />
	<portlet:param name="mvcPath" value="/product/pet/remarks/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deletePetRemarksURL" name="deleteRemarks"
	copyCurrentRenderParameters="true">
	<portlet:param name="petRemarksId"
		value="<%=String.valueOf(petRemarksRow.getPetRemarksId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="petRemarksId"
		value="<%=String.valueOf(petRemarksRow.getPetRemarksId())%>" />
	<portlet:param name="action"
		value="<%=petRemarksRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>


<%
	final String _editExistingRemarksURL = editExistingRemarksURL;
	final String _deletePetRemarksURL = deletePetRemarksURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingRemarksURL.toString());
						dropdownItem.setLabel("Edit");
					});

					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL);
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />