<%@ include file="../includes/init.jsp"%>

<%
	long agentFaqCategoryId = ParamUtil.getLong(renderRequest, "agentFaqCategoryId", 0);
	AgentFAQCategory agentFaqCategory = null;
	if (agentFaqCategoryId > 0) {
		agentFaqCategory = AgentFAQCategoryLocalServiceUtil.fetchAgentFAQCategory(agentFaqCategoryId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "category";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addAgentFaqCategoryURL%>" name="faqCategory">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="tag" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=agentFaqCategoryId > 0 ? "Edit FAQ Category" : "Add New FAQ Category"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= agentFaqCategoryId != 0 && agentFaqCategory != null ? agentFaqCategory.getActive() == 1 ? true : false : true %>" name="active"
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
										<aui:input label="Category" name="category" type="text"
											required="true"
											value="<%=agentFaqCategory == null ? "" : String.valueOf(agentFaqCategory.getCategory())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (agentFaqCategory != null) {
						%>
						<aui:input type="hidden" name="agentFaqCategoryId"
							value="<%=String.valueOf(agentFaqCategory.getAgentFaqCategoryId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=agentFaqCategoryURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
