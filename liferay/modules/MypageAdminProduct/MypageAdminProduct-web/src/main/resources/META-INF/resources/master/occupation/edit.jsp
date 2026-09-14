<%@ include file="../includes/init.jsp"%>

<%
	long masterOccupationId = ParamUtil.getLong(renderRequest, "masterOccupationId", 0);
	MasterOccupation masterOccupation = null;

	if (masterOccupationId > 0) {
		masterOccupation = MasterOccupationLocalServiceUtil.fetchMasterOccupation(masterOccupationId);
	}
	
	// get occupation category
	List<MasterOccupationCategory> occupationCategory = MasterOccupationCategoryLocalServiceUtil.searchByActive(1);
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "occupation";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addOccupationURL%>" name="pet">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=masterOccupationId > 0 ? "Edit Occupation " : "Add New Occupation "%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= masterOccupationId != 0 && masterOccupation != null ? masterOccupation.getActive() == 1 ? true : false : true %>" name="active"
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
											value="<%=masterOccupation == null ? "" : String.valueOf(masterOccupation.getName())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:select name="masterOccupationCategoryId" label="Occupation Category">
											<aui:option value="" label="-" />
											<%
	                                            	if(! occupationCategory.isEmpty()) {
	                                            		for(MasterOccupationCategory oc : occupationCategory) {
	                                        %>       
	                                        <aui:option value="<%= oc.getMasterOccupationCategoryId() %>" selected="<%= masterOccupation != null && oc.getMasterOccupationCategoryId() == masterOccupation.getMasterOccupationCategoryId() %>" label="<%= oc.getName() %>" />                                     
	                                        <%
	                                           		}
	                                          	}
	                                        %>
										</aui:select>
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (masterOccupation != null) {
						%>
						<aui:input type="hidden" name="masterOccupationId"
							value="<%=String.valueOf(masterOccupation.getMasterOccupationId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=occupationURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
