<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterOccupationCategory masterOccupationCategoryRow = (MasterOccupationCategory) row.getObject();
	String publishText = masterOccupationCategoryRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingOccupationCategoryURL">
	<portlet:param name="masterOccupationCategoryId"
		value="<%=String.valueOf(masterOccupationCategoryRow.getMasterOccupationCategoryId())%>" />
	<portlet:param name="mvcPath" value="/master/occupation_category/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteOccupationCategoryURL" name="deleteOccupationCategory"
	copyCurrentRenderParameters="true">
	<portlet:param name="masterOccupationCategoryId" value="" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="masterOccupationCategoryId"
		value="<%=String.valueOf(masterOccupationCategoryRow.getMasterOccupationCategoryId())%>" />
	<portlet:param name="action"
		value="<%=masterOccupationCategoryRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingOccupationCategoryURL = editExistingOccupationCategoryURL;
	final String _deleteOccupationCategoryURL = deleteOccupationCategoryURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingOccupationCategoryURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />