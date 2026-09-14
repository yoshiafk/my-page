<%@ include file="../includes/init.jsp"%>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>


<%
	long agentFaqId = ParamUtil.getLong(renderRequest, "agentFaqId", 0);
	AgentFAQ agentFaq = null;
	List<AgentFAQCategory> agentFaqCategory = AgentFAQCategoryLocalServiceUtil.getActiveCategory();
	
	if (agentFaqId > 0) {
		agentFaq = AgentFAQLocalServiceUtil.fetchAgentFAQ(agentFaqId);
	}
	
	String imageSelectedItemEventName = (String) renderRequest.getAttribute("imageSelectedItemEventName");
	String itemSelectorURL = (String) renderRequest.getAttribute("itemSelectorURL");
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "faq";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addAgentFaqURL%>" name="faq">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="tag" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=agentFaqId > 0 ? "Edit FAQ" : "Add New FAQ"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= agentFaqId != 0 && agentFaq != null ? agentFaq.getActive() == 1 ? true : false : true %>" name="active"
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
											value="<%=agentFaq == null ? "" : String.valueOf(agentFaq.getTitle())%>" />
									</aui:col>
									
									<aui:col width="100" cssClass="mb-4">
										<liferay-editor:editor 
								            contents="<%= agentFaq != null ? agentFaq.getDescription() : "" %>" 
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
										    <% if (agentFaqCategory.size() > 0) {  %>
										    	<% for (int i = 0; i < agentFaqCategory.size(); i++) { %>
										    		<aui:option selected="<%= agentFaq == null ? false : agentFaq.getCategory().equalsIgnoreCase(agentFaqCategory.get(i).getCategory()) %>" value="<%= agentFaqCategory.get(i).getAgentFaqCategoryId() %>"><%= agentFaqCategory.get(i).getCategory() %></aui:option>
										    	<% } %>
											<% } %>
										</aui:select>
									</aui:col>
								</aui:row>
								
								<%-- <aui:row>
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
								 --%>
								<%-- <% if (agentSalesToolsId > 0 && Validator.isNotNull(agentSalesTools.getFileUploadUrl())) { %>
									<aui:row>
										<aui:col width="100">
											<aui:input label="Source File" name="fileUrl" type="text" disabled="true" 
											value="<%=agentSalesTools == null ? "" : String.valueOf(agentSalesTools.getFileUploadUrl())%>" />
										</aui:col>
									</aui:row>
								<% } %> --%>
								
								<%-- <aui:row>
									<aui:col width="100">
										<aui:input label="File" name="file" type="file" required="<%= agentSalesToolsId > 0 && Validator.isNotNull(agentSalesTools.getFileUploadUrl()) ? false : true %>">
											<aui:validator name="acceptFiles">'pdf,mp4'</aui:validator>
										</aui:input>
									</aui:col>
								</aui:row> --%>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (agentFaq != null) {
						%>
						<aui:input type="hidden" name="agentFaqId"
							value="<%=String.valueOf(agentFaq.getAgentFaqId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=agentFaqURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
