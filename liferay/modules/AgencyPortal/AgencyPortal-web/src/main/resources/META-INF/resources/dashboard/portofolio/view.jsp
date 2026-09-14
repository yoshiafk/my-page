<%@page import="com.mypage.agencyportal.dto.DataItemDto"%>
<%@page import="com.mypage.agencyportal.dto.APIResponse"%>
<%@ include file="../../init.jsp"%>

<%
	APIResponse<DataItemDto> _response = (APIResponse<DataItemDto>) renderRequest.getAttribute("response");	
	String _pimcoreHost = (String) renderRequest.getAttribute("pimcoreHost");
%>
