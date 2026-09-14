<%@ include file="../../includes/init.jsp"%>

<%
	long creditTypeId = ParamUtil.getLong(renderRequest, "creditTypeId", 0);
	CreditType creditType = null;
	
	if (creditTypeId > 0) {
		creditType = CreditTypeLocalServiceUtil.fetchCreditType(creditTypeId);
	}
	
	// title
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(creditTypeURL.toString());
	renderResponse.setTitle(creditTypeId > 0 ? "Edit "+creditType.getName() : "Add New Credit Type");

	// setting for menu
	String _active = "creditType";
%>

<liferay-ui:error key="failed" message="Your request failed." />
<liferay-ui:success key="success" message="Your request completed successfully." />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%@ include file="/user_credit/left_menu.jsp"%>
		</div>
		<div class="col-lg-8">
			<aui:form action="<%=addCreditTypeURL%>" enctype="multipart/form-data" name="fm">
            	<clay:sheet>
            		<clay:sheet-header>
            			<h2 class="sheet-title">
	                        <div class="row">
	                            <div class="col-lg-10">
	                                <div class="d-flex">
	                                    <span class="pl-2 text-truncate text-capitalize"><%=creditTypeId > 0 ? "Edit "+creditType.getName() : "Add New Credit Type"%></span>
	                                </div>
	                            </div>
	                            <div class="col-lg-2">
	                                <aui:input checked="<%= creditType != null ? creditType.getActive() == 1 ? true : false : true %>" name="active"
	                                    type="toggle-switch" value="1" label="Active"
	                                    wrapperCssClass="leftToggleTitle" />
	                            </div>
	                        </div>
	                    </h2>
            		</clay:sheet-header>
            		
            		<clay:sheet-section>
            			<h3 class="sheet-subtitle">Credit Type Detail</h3>
            			
            			<aui:row>
							<aui:col width="50">
								<aui:input label="Name" name="name" type="text"
									required="true"
									value="<%=creditType == null ? "" : String.valueOf(creditType.getName())%>">
									<aui:validator errorMessage="Only letter and space are allowed." 
							        name="custom">
							                function(val, fieldNode, ruleValue) {
							                        var regex = new RegExp(/^(?![\s.]+$)[a-zA-Z\s.]*$/i);
							
							                        return regex.test(val);
							                }
							        </aui:validator>
								</aui:input>
							</aui:col>
							
							<aui:col width="50">
								<aui:input label="Agent Type" name="agentType" type="text"
									required="true"
									value="<%=creditType == null ? "" : String.valueOf(creditType.getAgentType())%>" />
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col width="50">
								<aui:input label="Limit" name="limit" type="text"
									required="true"
									value="<%=creditType == null ? "" : String.valueOf(creditType.getLimit())%>">
									<aui:validator name="number" />
								</aui:input>
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col width="100">
						        <aui:input label="Override Grace Period" name="overrideGracePeriod" type="checkbox"
						            value="1" checked="<%=creditType != null && creditType.getOverrideGracePeriod() == 1 %>" />
						    </aui:col>
						    
						    <aui:col width="100">
						        <aui:input label="Nett Premi Allowed" name="nettPremiAllowed" type="checkbox"
						            value="1" checked="<%=creditType != null && creditType.getNettPremiAllowed() == 1 %>" />
						    </aui:col>
						</aui:row>
						
						<%
							if (creditType != null) {
						%>
						<aui:input type="hidden" name="creditTypeId"
							value="<%=String.valueOf(creditType.getCreditTypeId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=creditTypeURL.toString()%>"></aui:button>
						</aui:button-row>
            		</clay:sheet-section>
            	</clay:sheet>
            </aui:form>
		</div>
	</div>
</div>
