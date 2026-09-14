<%@ include file="../../includes/init.jsp"%>

<%
	long leadsId = ParamUtil.getLong(renderRequest, "LeadsId", 0);
	Leads leads = null;
	DetailDomesticTravel detail = null;
	
	if (leadsId > 0) {
		leads = LeadsLocalServiceUtil.fetchLeads(leadsId);
		detail = DetailDomesticTravelLocalServiceUtil.searchByLeadsId(leadsId);
	}
	
	List<TravelDomesticPlan> plans = TravelDomesticPlanLocalServiceUtil.getTravelDomesticPlans(0, TravelDomesticPlanLocalServiceUtil.getTravelDomesticPlansCount());
	List<TravelDomesticInsuredType> insureds = TravelDomesticInsuredTypeLocalServiceUtil.getTravelDomesticInsuredTypes(0, TravelDomesticInsuredTypeLocalServiceUtil.getTravelDomesticInsuredTypesCount());
%>

<div class="sheet-section">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset cssClass="p-4" label="Leads Detail" collapsible="true" collapsed="false">
			<aui:row>
				<aui:col width="50">
					<aui:input label="Travel Type" name="TravelType" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getTravelType())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:select label="Travel Plan" name="TravelPlan" required="true" showEmptyOption="true">
						<%
							if(plans.size() > 0) {
								for(TravelDomesticPlan plan : plans) {
						%>						
                        <aui:option value="<%= plan.getCode() %>" selected="<%= detail != null && plan.getCode().equals(String.valueOf(detail.getTravelPlan())) %>"><%= plan.getName() %></aui:option>
						<%
								}
							}
						%>
                    </aui:select>
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:select label="Traveller Type" name="TravellerType" required="true" showEmptyOption="true">
                        <%
							if(insureds.size() > 0) {
								for(TravelDomesticInsuredType insured : insureds) {
						%>						
                        <aui:option value="<%= insured.getName() %>" selected="<%= detail != null && insured.getName().equals(String.valueOf(detail.getTravellerType())) %>"><%= insured.getName() %></aui:option>
						<%
								}
							}
						%>
                    </aui:select>
				</aui:col>
				
				<aui:col width="50">
					<aui:row>
						<aui:col width="50">
							<aui:input label="Adult" name="Adult" type="text" required="true"
								value="<%=detail == null ? "" : String.valueOf(detail.getAdult())%>" />
						</aui:col>
						
						<aui:col width="50">
							<aui:input label="Child" name="Child" type="text"
								value="<%=detail == null ? "" : String.valueOf(detail.getChild())%>" />
						</aui:col>
					</aui:row>
				</aui:col>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
</div>