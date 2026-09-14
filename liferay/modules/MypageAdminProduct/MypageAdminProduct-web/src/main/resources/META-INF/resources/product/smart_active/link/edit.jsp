<%@ include file="../includes/init.jsp"%>

<%
	long linkId = ParamUtil.getLong(renderRequest, "linkId", 0);
	SmartActiveLink link = null;
	
	if (linkId > 0) {
		link = SmartActiveLinkLocalServiceUtil.fetchSmartActiveLink(linkId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "link";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addFileURL %>" name="link">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= linkId > 0 ? "Edit Link Files" : "Add Link Files" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= linkId != 0 && link != null ? link.getActive() == 1 ? true : false : true %>"
									name="active" type="toggle-switch" value="1" label="Active"
									wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>

					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">

								<aui:row>
									<aui:col width="100">
										<aui:input label="Category" name="category"
											type="text" required="true"
											value="<%= link == null ? "" : String.valueOf(link.getCategory()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Title" name="title"
											type="text" required="true"
											value="<%= link == null ? "" : String.valueOf(link.getTitle()) %>" />
									</aui:col>
									
								</aui:row>
								
								<% if (linkId > 0 && Validator.isNotNull(link.getFileUploadUrl())) { %>
									<aui:row>
										<aui:col width="100">
											<aui:input label="Source File" name="fileUrl" type="text" disabled="true" 
											value="<%= link == null ? "" : String.valueOf(link.getFileUploadUrl())%>" />
										</aui:col>
									</aui:row>
								<% } %>
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="File" name="file" type="file" required="<%= linkId > 0 && Validator.isNotNull(link.getFileUploadUrl()) ? false : true %>">
											<aui:validator name="acceptFiles">'pdf'</aui:validator>
										</aui:input>
									</aui:col>
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (link != null) {
						%>
						<aui:input type="hidden" name="linkId" value="<%= String.valueOf(link.getSmartActiveLinkId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= fileURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
