<%@ include file="../includes/init.jsp"%>
<%@ page
	import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartHealthPremi _row = (SmartHealthPremi) row.getObject();
	String publishText = _row.getStatus() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingPremiURL">
	<portlet:param name="smartHealthPremiId" value="<%=String.valueOf(_row.getSmartHealthPremiId())%>" />
	<portlet:param name="mvcPath" value="/product/smart_health/premi/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="smartHealthPremiId" value="<%=String.valueOf(_row.getSmartHealthPremiId())%>" />
	<portlet:param name="action" value="<%=_row.getStatus() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingURL = editExistingPremiURL;
	final String _setStatusURL = setStatusURL;
%>
<clay:dropdown-actions
	dropdownItems="<%=new JSPDropdownItemList(pageContext) {
				{
					add(dropdownItem -> {
						dropdownItem.setHref(_editExistingURL.toString());
						dropdownItem.setLabel("Edit");
					});

					add(dropdownItem -> {
						dropdownItem.setHref(_setStatusURL);
						dropdownItem.setLabel(publishText);
					});
				}
			}%>" />