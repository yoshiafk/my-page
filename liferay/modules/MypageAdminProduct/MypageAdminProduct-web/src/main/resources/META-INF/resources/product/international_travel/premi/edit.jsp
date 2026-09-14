<%@ include file="../includes/init.jsp"%>

<%
long premiId = ParamUtil.getLong(renderRequest, "premiId", Long.valueOf("0"));
TravelInternationalPremi _premi = null;

if(premiId > 0) {
	_premi = TravelInternationalPremiLocalServiceUtil.getTravelInternationalPremi(premiId);
}
%>

<liferay-ui:success key="dataUpdated" message="data-updated" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
    <div class="col-lg-3">
		<%
			// setting for menu
			String _active = "premi";
		%>      
  	<%@ include file="../includes/left-menu.jsp"%>
    </div>
    <div class="col-lg-9">
			<portlet:actionURL name="updatePremi" var="updatePremiURL" />
			
			<aui:form method="post" action="<%= updatePremiURL %>" name="<portlet:namespace />fm">
				<div class="sheet sheet-full">
					<div class="row">
						<div class="col-md-6">
							<h2 class="sheet-title">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />	                    
				                   	<span class="pl-2 text-truncate">Premi</span>
								</div>
							</h2>
						</div>
						<div class="col-md-6">
							<% boolean active = _premi!=null && _premi.getActive()==1 ?true:false; %>
							<aui:input checked="<%= active  %>" name="active" type="toggle-switch" value="1" label="Active" data-label-on="Active" data-label-off="Inactive" wrapperCssClass="leftToggleTitle" />
						</div>
					</div>
					<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">			
								<aui:row>			
									<aui:col width="50">
										<aui:select label="Package" name="package_type" required="true" showEmptyOption="true">
								            <aui:option value="SPA" selected="<%=_premi!=null && _premi.getPackageType().equals("SPA") %>" >Special Asia</aui:option>
								            <aui:option value="GLD" selected="<%=_premi!=null && _premi.getPackageType().equals("GLD") %>">Gold</aui:option>
								            <aui:option value="PLA" selected="<%=_premi!=null && _premi.getPackageType().equals("PLA") %>">Platinum</aui:option>
								        </aui:select>
									</aui:col>
									<aui:col width="50">
										<aui:select label="Group" name="traveller_type" required="true" showEmptyOption="true">
								            <aui:option value="individual" selected="<%=_premi!=null && _premi.getPeopleType().equals("individual") %>">Sendiri</aui:option>
								            <aui:option value="duo" selected="<%=_premi!=null && _premi.getPeopleType().equals("duo") %>">Duo</aui:option>
								            <aui:option value="family" selected="<%=_premi!=null && _premi.getPeopleType().equals("family") %>">Keluarga</aui:option>
								        </aui:select>
									</aui:col>													
								</aui:row>	
								<aui:row>
									<aui:col width="50">
										<aui:input label="Adult" name="adult_count" type="number" value="<%= _premi!=null?_premi.getAdultCount():"" %>" />
									</aui:col>					
									<aui:col width="50">
										<aui:input label="Children" name="children_count" type="number" value="<%= _premi!=null?_premi.getChildrenCount():"" %>" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="50">
										<aui:input label="Min Duration" name="min_duration" type="number" value="<%= _premi!=null?_premi.getMinDuration():"" %>" />
									</aui:col>					
									<aui:col width="50">
										<aui:input label="Max Duration" name="max_duration" type="number" value="<%= _premi!=null?_premi.getMaxDuration():"" %>" />
									</aui:col>
								</aui:row>	
								<aui:row>
									<aui:col width="50">
										<aui:select label="Currency" name="currency" required="true" showEmptyOption="true">
								            <aui:option value="idr" selected="<%=_premi!=null && _premi.getCurrency().equals("idr") %>">IDR</aui:option>
								            <aui:option value="usd" selected="<%=_premi!=null && _premi.getCurrency().equals("usd") %>">USD</aui:option>
								        </aui:select>
									</aui:col>								
									<aui:col width="50">
									<%
										String formattedAmount = "";
									
										if(_premi!=null) {
											DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
											formattedAmount = decimalFormat.format(_premi.getAmount());										
										}
									%>
										<aui:input label="Amount" name="amount" type="text" value="<%= formattedAmount %>" />
									</aui:col>
								</aui:row>								
							</aui:fieldset>
						</aui:fieldset-group>
						<aui:input name="premiId" type="hidden" value="<%= premiId > 0 && _premi != null ? _premi.getPremiId() : "" %>" />
						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= premiURL.toString() %>"></aui:button>						
						</aui:button-row>																						
					</div>
				</div>      
			</aui:form>						
  	</div>
	</div>
</div>