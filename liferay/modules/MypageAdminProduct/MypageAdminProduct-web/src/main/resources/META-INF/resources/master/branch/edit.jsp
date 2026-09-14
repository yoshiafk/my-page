<%@ include file="../includes/init.jsp"%>

<%
	long masterBranchId = ParamUtil.getLong(renderRequest, "masterBranchId", 0);
	MasterBranch masterBranch = null;

	if (masterBranchId > 0) {
		masterBranch = MasterBranchLocalServiceUtil.fetchMasterBranch(masterBranchId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "branch";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addBranchURL%>" name="pet">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=masterBranchId > 0 ? "Edit Branch " : "Add New Branch "%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= masterBranchId != 0 && masterBranch != null ? masterBranch.getActive() == 1 ? true : false : true %>" name="active"
								type="toggle-switch" value="1" label="Active"
								wrapperCssClass="leftToggleTitle" />
						</div>
					</div>
				</h2>

				<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="50">
										<aui:input label="Name" name="name" type="text"
											required="true"
											value="<%=masterBranch == null ? "" : String.valueOf(masterBranch.getName())%>" />
									</aui:col>
										
									<aui:col width="50">
										<aui:input label="AGI Code" name="agiCode" type="text"
											required="true"
											value="<%=masterBranch == null ? "" : String.valueOf(masterBranch.getAgiCode())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="MAGI Code" name="magiCode" type="text"
											required="true"
											value="<%=masterBranch == null ? "" : String.valueOf(masterBranch.getMagiCode())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (masterBranch != null) {
						%>
						<aui:input type="hidden" name="masterBranchId"
							value="<%=String.valueOf(masterBranch.getMasterBranchId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=branchURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
