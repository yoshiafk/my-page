<%@ include file="../../includes/init.jsp"%>

<%
	long leadsId = ParamUtil.getLong(renderRequest, "LeadsId", 0);
	Leads leads = null;
	DetailHealthIndividu detail = null;
	
	if (leadsId > 0) {
		leads = LeadsLocalServiceUtil.fetchLeads(leadsId);
		detail = DetailHealthIndividuLocalServiceUtil.searchByLeadsId(leadsId);
	}
%>

<div class="sheet-section">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset cssClass="p-4" label="Leads Detail" collapsible="true" collapsed="false">
			<aui:row>
				<aui:col width="50" cssClass="pt-4">
					<aui:input label="Same Address" name="SameAddress" type="checkbox"
						value="1" checked="<%=leads != null && detail.getSameAddress() == 1 %>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Plan Id" name="PlanId" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getPlanId())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Current Address" name="CurrentAddress" type="text"
						value="<%=detail == null ? "" : String.valueOf(detail.getCurrentAddress())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Current Zip" name="CurrentZip" type="text"
						value="<%=detail == null ? "" : String.valueOf(detail.getCurrentZip())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Job Category" name="JobCat" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getJobCat())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Job Type" name="JobType" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getJobType())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Job" name="Job" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getJob())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Job Position" name="JobPosition" type="text"
						value="<%=detail == null ? "" : String.valueOf(detail.getJobPosition())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="33">
					<aui:input label="Account Bank Number" name="AccountBankNumber" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getAccountBankNumber())%>" />
				</aui:col>
				
				<aui:col width="33">
					<aui:input label="Account Bank Name" name="AccountBankName" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getAccountBankName())%>" />
				</aui:col>
				
				<aui:col width="33">
					<aui:input label="Bank Name" name="BankName" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getBankName())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="33" cssClass="pt-4">
					<aui:input label="Health Agreement" name="HealthAgreement" type="checkbox"
						value="1" checked="<%=leads != null && detail.getHealthAgreement() == 1 %>" />
				</aui:col>
				
				<aui:col width="33" cssClass="pt-4">
					<aui:input label="Child Agreement" name="ChildAgreement" type="checkbox"
						value="1" checked="<%=leads != null && detail.getChildAgreement() == 1 %>" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
</div>