<%@ include file="../includes/init.jsp"%>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil" %>

<%
	long agentSalesToolsId = ParamUtil.getLong(renderRequest, "agentSalesToolsId", 0);
	AgentSalesTools agentSalesTools = null;
	List<AgentCategorySalesTools> agentCategorySalesTools = AgentCategorySalesToolsLocalServiceUtil.getActiveCategory();
	List<MypageUserRole> mypageUserRole = MypageUserRoleLocalServiceUtil.getActiveRole();

	if (agentSalesToolsId > 0) {
		agentSalesTools = AgentSalesToolsLocalServiceUtil.fetchAgentSalesTools(agentSalesToolsId);
	}
	
	String imageSelectedItemEventName = (String) renderRequest.getAttribute("imageSelectedItemEventName");
	String itemSelectorURL = (String) renderRequest.getAttribute("itemSelectorURL");
%>

<portlet:actionURL name="/masterdata/upload_image" var="uploadSalesToolsFileURL" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "sales_tools";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addAgentSalesToolsURL%>" name="salesTools">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="tag" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=agentSalesToolsId > 0 ? "Edit Sales Tools" : "Add New Sales Tools"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= agentSalesToolsId != 0 && agentSalesTools != null ? agentSalesTools.getActive() == 1 ? true : false : true %>" name="active"
								type="toggle-switch" value="1" label="Active"
								wrapperCssClass="leftToggleTitle" />
						</div>
					</div>
				</h2>

				<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input label="Title" name="title" type="text"
											required="true"
											value="<%=agentSalesTools == null ? "" : String.valueOf(agentSalesTools.getTitle())%>" />
									</aui:col>
									
									<aui:col width="100" cssClass="mb-4">
										<liferay-editor:editor 
								            contents="<%= agentSalesTools != null ? agentSalesTools.getDescription() : "" %>" 
											cssClass="product-admin-editor" 
								            editorName="ckeditor" 
								            name="description" 
								            placeholder="description" 
								            required="true" 
								            showSource="true"
								        />
									</aui:col>
									
									<aui:col width="100">
										<aui:select label="Category" name="category" required="true">
											<aui:option value="">Select Category</aui:option>
										    <% if (agentCategorySalesTools.size() > 0) {  %>
										    	<% for (int i = 0; i < agentCategorySalesTools.size(); i++) { %>
										    		<aui:option selected="<%= agentSalesTools == null ? false : agentSalesTools.getCategory().equalsIgnoreCase(agentCategorySalesTools.get(i).getCategory()) %>" value="<%= agentCategorySalesTools.get(i).getAgentCategorySalesToolsId() %>"><%= agentCategorySalesTools.get(i).getCategory() %></aui:option>
										    	<% } %>
											<% } %>
										</aui:select>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<aui:select label="Recipient" name="role" required="true">
											<aui:option value="">Select Recipient</aui:option>
										    <% if (mypageUserRole.size() > 0) {  %>
										    	<% for (int i = 0; i < mypageUserRole.size(); i++) { %>
										    		<aui:option selected="<%= agentSalesTools == null ? false : agentSalesTools.getRole().equalsIgnoreCase(mypageUserRole.get(i).getName()) %>" value="<%= mypageUserRole.get(i).getMypageUserRoleId() %>"><%= mypageUserRole.get(i).getName() %></aui:option>
										    	<% } %>
											<% } %>
										</aui:select>
									</aui:col>
								</aui:row>
								
								<% if (agentSalesToolsId > 0 && Validator.isNotNull(agentSalesTools.getFileUploadUrl())) { %>
									<aui:row>
										<aui:col width="100">
											<aui:input label="Source File" name="fileUrl" type="text" disabled="true" 
											value="<%=agentSalesTools == null ? "" : String.valueOf(agentSalesTools.getFileUploadUrl())%>" />
										</aui:col>
									</aui:row>
								<% } %>
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="File" name="file" type="file" required="<%= agentSalesToolsId > 0 && Validator.isNotNull(agentSalesTools.getFileUploadUrl()) ? false : true %>">
											<aui:validator name="acceptFiles">'pdf,mp4'</aui:validator>
										</aui:input>
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (agentSalesTools != null) {
						%>
						<aui:input type="hidden" name="agentSalesToolsId"
							value="<%=String.valueOf(agentSalesTools.getAgentSalesToolsId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=agentSalesToolsURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
