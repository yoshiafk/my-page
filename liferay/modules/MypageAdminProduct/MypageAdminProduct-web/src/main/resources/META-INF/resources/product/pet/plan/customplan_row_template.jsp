<%@ include file="../includes/init.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	PetPlan petPlan = (PetPlan) row.getObject();
%>

<%
	if (String.valueOf(petPlan.getCustomPlan()).equals("1")) {
%>
<clay:icon symbol="check-circle" />
<%
	} else {
%>
<clay:icon symbol="times-circle" />
<%
	}
%>
