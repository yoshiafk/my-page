<%@ include file="../../includes/init.jsp"%>

<%
	long leadsId = ParamUtil.getLong(renderRequest, "LeadsId", 0);
	DetailInternationalTravel detail = null;
	
	if (leadsId > 0) {
		detail = DetailInternationalTravelLocalServiceUtil.findByLeadsId(leadsId);
	}	
%>

<div class="sheet-section">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset cssClass="p-4" label="Leads Detail" collapsible="true" collapsed="false">
			<aui:row>
				<aui:col width="50">
					<aui:select label="Package Type" name="PackageType" required="true" showEmptyOption="true">
			            <aui:option value="SPA" selected="<%=detail!=null && detail.getPackageType().equals("SPA") %>" >Special Asia</aui:option>
			            <aui:option value="GLD" selected="<%=detail!=null && detail.getPackageType().equals("GLD") %>">Gold</aui:option>
			            <aui:option value="PLA" selected="<%=detail!=null && detail.getPackageType().equals("PLA") %>">Platinum</aui:option>
			        </aui:select>
				</aui:col>
				
				<aui:col width="50">
					<aui:select label="Traveller Type" name="TravellerType" required="true" showEmptyOption="true">
			            <aui:option value="individual" selected="<%=detail!=null && detail.getTravellerType().equals("individual") %>">Sendiri</aui:option>
			            <aui:option value="duo" selected="<%=detail!=null && detail.getTravellerType().equals("duo") %>">Duo</aui:option>
			            <aui:option value="family" selected="<%=detail!=null && detail.getTravellerType().equals("family") %>">Keluarga</aui:option>
			        </aui:select>
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Travel Type" name="TravelType" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getTravelType())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Destination" name="Destination" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getDestination())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Adult" name="Adult" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getAdult())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Child" name="Child" type="text" required="true"
						value="<%=detail == null ? "" : String.valueOf(detail.getChild())%>" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
</div>