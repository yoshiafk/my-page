<%@ include file="../includes/init.jsp"%>

<%
	
	List<SmartTravelIntPlan> plans = SmartTravelIntPlanLocalServiceUtil.getActivePlan();
	long planId = ParamUtil.getLong(renderRequest, "planId", 0);
	SmartTravelIntPlan plan = null;

	if (planId > 0) {
		plan = SmartTravelIntPlanLocalServiceUtil.fetchSmartTravelIntPlan(planId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "plan";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%=addPlanURL%>" name="plan">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=planId > 0 ? "Edit Plan" : "Add Plan"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%=planId != 0 && plan != null ? plan.getActive() == 1 ? true : false : true%>"
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
										<aui:input label="Name (Indonesia)" name="nameId"
											type="text" required="true"
											value="<%=plan == null ? "" : String.valueOf(plan.getNameId())%>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Name (English)" name="nameEn"
											type="text" required="true"
											value="<%=plan == null ? "" : String.valueOf(plan.getNameEn())%>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Sort" name="sort"
											type="number" required="false"
											value="<%=plan == null ? "" : String.valueOf(plan.getSort())%>" />
									</aui:col>
									
									
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (plan != null) {
						%>
						<aui:input type="hidden" name="planId" value="<%=String.valueOf(plan.getSmartTravelIntPlanId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=planURL.toString()%>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
