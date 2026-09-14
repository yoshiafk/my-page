<%@ include file="../includes/init.jsp"%>

<%
	long benefitId = ParamUtil.getLong(renderRequest, "benefitId", 0);
	SmartActiveBenefit benefit = null;
	
	if (benefitId > 0) {
		benefit = SmartActiveBenefitLocalServiceUtil.fetchSmartActiveBenefit(benefitId);
	}
	
	List<SmartActiveBenefitType> benefitTypes = SmartActiveBenefitTypeLocalServiceUtil.getActiveBenefitType();
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "benefit";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%= addBenefitURL %>" name="benefit">
				<div class="sheet sheet-full">

					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="categories" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%= benefitId > 0 ? "Edit Benefit" : "Add Benefit" %></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input
									checked="<%= benefitId != 0 && benefit != null ? benefit.getActive() == 1 ? true : false : true %>"
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
											value="<%= benefit == null ? "" : String.valueOf(benefit.getNameId()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Name (English)" name="nameEn"
											type="text" required="true"
											value="<%= benefit == null ? "" : String.valueOf(benefit.getNameEn()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:select name="benefitTypeId" label="Benefit Type" required="true">
											<%
												for (int i = 0; i < benefitTypes.size(); i++) {
											%>
											<%
												boolean isSelectedBenefitTypes = false;
												if (benefit != null) {
													isSelectedBenefitTypes = benefitTypes.get(i).getSmartActiveBenefitTypeId() == benefit.getSmartActiveBenefitTypeId() ? true : false;
												}
												
												String benefitTypeName = benefitTypes.get(i).getNameId();
											    if (benefitTypeName == null || benefitTypeName.isEmpty()) {
											        benefitTypeName = benefitTypes.get(i).getNameEn();
											    }								
																			
											%>
											<aui:option
												value="<%= benefitTypes.get(i).getSmartActiveBenefitTypeId() %>"
												label="<%= benefitTypeName %>"
												selected="<%= isSelectedBenefitTypes %>" />
											<%
												}
											%>
										</aui:select>
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="External Code" name="externalCode" type="text" required="true" value="<%= benefit == null ? "" : String.valueOf(benefit.getExternalCode()) %>" />
									</aui:col>									
									
									<aui:col width="100">
										<aui:input label="Sort" name="sort"
											type="number" required="false"
											value="<%= benefit == null ? "" : String.valueOf(benefit.getSort()) %>" />
									</aui:col>
									
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<div class="alloy-editor-container">
											<liferay-editor:editor cssClass="mypage-editor" editorName="ckeditor" name="benefitLimit" placeholder="Limit" showSource="true" contents="<%= benefit == null ? "" : String.valueOf(benefit.getLimit_()) %>" />
										</div>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<div class="alloy-editor-container">
											<liferay-editor:editor cssClass="mypage-editor" editorName="ckeditor" name="benefitDescription" placeholder="Description" showSource="true" contents="<%= benefit == null ? "" : String.valueOf(benefit.getDescription()) %>" />
										</div>
									</aui:col>
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (benefit != null) {
						%>
						<aui:input type="hidden" name="benefitId" value="<%= String.valueOf(benefit.getSmartActiveBenefitId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= benefitURL.toString() %>"></aui:button>
						</aui:button-row>
			</aui:form>
		</div>
	</div>
</div>
</div>
</div>
