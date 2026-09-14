<%@ include file="../includes/init.jsp"%>

<%
	boolean allowPermission = MypageUserPermission.contains(permissionChecker, scopeGroupId, "ADD_ENTRY");
%>

<c:if test="<%= !allowPermission %>">
	<jsp:include page="/user/edit.jsp" /> 
</c:if>
<c:if test="<%= allowPermission %>">
	<jsp:include page="/user/list.jsp" /> 
</c:if>