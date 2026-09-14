<%@ include file="../includes/init.jsp"%>

<%
	long agentCategorySalesToolsId = ParamUtil.getLong(renderRequest, "agentCategorySalesToolsId", 0);
	AgentCategorySalesTools agentCategorySalesTools = null;

	if (agentCategorySalesToolsId > 0) {
		agentCategorySalesTools = AgentCategorySalesToolsLocalServiceUtil.fetchAgentCategorySalesTools(agentCategorySalesToolsId);
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
		<aui:form action="<%=addAgentCategorySalesToolsURL%>" name="categorySalesTools">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="tag" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=agentCategorySalesToolsId > 0 ? "Edit Sales Tools Category" : "Add New Sales Tools Category"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= agentCategorySalesToolsId != 0 && agentCategorySalesTools != null ? agentCategorySalesTools.getActive() == 1 ? true : false : true %>" name="active"
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
											value="<%=agentCategorySalesTools == null ? "" : String.valueOf(agentCategorySalesTools.getCategory())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (agentCategorySalesTools != null) {
						%>
						<aui:input type="hidden" name="agentCategorySalesToolsId"
							value="<%=String.valueOf(agentCategorySalesTools.getAgentCategorySalesToolsId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=agentCategorySalesToolsURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
