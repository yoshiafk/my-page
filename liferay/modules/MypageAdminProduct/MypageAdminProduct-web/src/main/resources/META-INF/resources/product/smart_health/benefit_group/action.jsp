<%@ include file="../includes/init.jsp"%>
<%@ page
	import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SmartHealthBenefitGroup _row = (SmartHealthBenefitGroup) row.getObject();
	String publishText = _row.getActive() != 1 ? "Publish" : "Unpublish";
%>

<portlet:renderURL var="editExistingURL">
	<portlet:param name="smartHealthBenefitGroupId" value="<%=String.valueOf(_row.getSmartHealthBenefitGroupId())%>" />
	<portlet:param name="mvcPath" value="/product/smart_health/benefit_group/edit.jsp" />
</portlet:renderURL>

<portlet:actionURL name="setStatus" var="setStatusURL">
	<portlet:param name="smartHealthBenefitGroupId" value="<%=String.valueOf(_row.getSmartHealthBenefitGroupId())%>" />
	<portlet:param name="action" value="<%=_row.getActive() != 1 ? "publish" : "unpublish"%>" />
</portlet:actionURL>

<%
	final String _editExistingURL = editExistingURL;
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