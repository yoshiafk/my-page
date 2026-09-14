<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartActiveFeature featureRow = (SmartActiveFeature) row.getObject();
	String publishText = featureRow.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingFeatureURL">
	<portlet:param name="featureId"
		value="<%= String.valueOf(featureRow.getSmartActiveFeatureId()) %>" />
	<portlet:param name="mvcPath" value="/product/smart_active/feature/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL var="deleteFeatureURL" name="deleteFeature"
	copyCurrentRenderParameters="true">
	<portlet:param name="featureId" value="<%= String.valueOf(featureRow.getSmartActiveFeatureId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="featureId"
		value="<%= String.valueOf(featureRow.getSmartActiveFeatureId()) %>" />
	<portlet:param name="action"
		value="<%= featureRow.getActive() != 1 ? "publish" : "unpublish" %>" />
</portlet:actionURL>

<%
	final String _editExistingFeatureURL = editExistingFeatureURL;
	final String _deleteFeatureURL = deleteFeatureURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingFeatureURL.toString());
						dropdownItem.setLabel("Edit");
					});
					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL.toString());
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />