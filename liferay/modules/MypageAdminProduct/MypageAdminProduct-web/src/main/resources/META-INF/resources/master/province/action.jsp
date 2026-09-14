<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	MasterProvince masterProvinceRow = (MasterProvince) row.getObject();
	String publishText = masterProvinceRow.getActive() != 1 ? "Publish" : "Unpublish";
	
%>

<portlet:renderURL var="editExistingProvinceURL">
	<portlet:param name="masterProvinceId"
		value="<%=String.valueOf(masterProvinceRow.getMasterProvinceId())%>" />
	<portlet:param name="mvcPath" value="/master/province/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteProvinceURL" name="deleteProvince"
	copyCurrentRenderParameters="true">
	<portlet:param name="masterProvinceId" value="<%=String.valueOf(masterProvinceRow.getMasterProvinceId())%>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="masterProvinceId"
		value="<%=String.valueOf(masterProvinceRow.getMasterProvinceId())%>" />
	<portlet:param name="action"
		value="<%=masterProvinceRow.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingProvinceURL = editExistingProvinceURL;
	final String _deleteProvinceURL = deleteProvinceURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingProvinceURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />