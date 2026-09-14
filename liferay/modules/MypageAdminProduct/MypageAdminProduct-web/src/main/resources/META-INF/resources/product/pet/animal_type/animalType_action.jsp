<%@ include file="../includes/init.jsp"%>
<%@ page
	import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	PetAnimalType petAnimalTypeRow = (PetAnimalType) row.getObject();
	String publishText = petAnimalTypeRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingAnimalTypeURL">
	<portlet:param name="petAnimalTypeId"
		value="<%=String.valueOf(petAnimalTypeRow.getPetAnimalTypeId())%>" />
	<portlet:param name="mvcPath" value="/product/pet/animal_type/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deletePetAnimalTypeURL" name="deleteAnimalType"
	copyCurrentRenderParameters="true">
	<portlet:param name="petAnimalTypeId"
		value="<%=String.valueOf(petAnimalTypeRow.getPetAnimalTypeId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="petAnimalTypeId"
		value="<%=String.valueOf(petAnimalTypeRow.getPetAnimalTypeId())%>" />
	<portlet:param name="action"
		value="<%=petAnimalTypeRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>


<%
	final String _editExistingAnimalTypeURL = editExistingAnimalTypeURL;
	final String _deletePetAnimalTypeURL = deletePetAnimalTypeURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingAnimalTypeURL.toString());
						dropdownItem.setLabel("Edit");
					});

					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL);
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />