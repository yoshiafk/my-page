<%@ include file="../../includes/init.jsp"%>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>

<%
	long leadsId = ParamUtil.getLong(renderRequest, "LeadsId", 0);
	Leads leads = null;
	DetailPet detail = null;
	
	if (leadsId > 0) {
		leads = LeadsLocalServiceUtil.fetchLeads(leadsId);
		detail = DetailPetLocalServiceUtil.searchByLeadsId(leadsId);
	}
	
	String imageSelectedItemEventName = (String) renderRequest.getAttribute("imageSelectedItemEventName");
	String itemSelectorURL = (String) renderRequest.getAttribute("itemSelectorURL");
	
	List<PetAnimalType> animalTypes = PetAnimalTypeLocalServiceUtil.getPetAnimalTypes(0, PetAnimalTypeLocalServiceUtil.getPetAnimalTypesCount());
%>

<div class="sheet-section">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset cssClass="p-4" label="Leads Detail" collapsible="true" collapsed="false">
			<aui:row>
				<aui:col width="50">
					<aui:input label="Plan Id" name="PlanId" type="text"
						value="<%=detail == null ? "" : String.valueOf(detail.getPlanId())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Limit Disability" name="LimitDisability" type="text"
						value="<%=detail == null ? "" : String.format("%.0f", detail.getLimitDisability())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Limit Medical" name="LimitMedical" type="text"
						value="<%=detail == null ? "" : String.format("%.0f", detail.getLimitMedical())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Limit Third Party" name="LimitThirdParty" type="text"
						value="<%=detail == null ? "" : String.format("%.0f", detail.getLimitThirdParty())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Limit Custody" name="LimitCustody" type="text"
						value="<%=detail == null ? "" : String.format("%.0f", detail.getLimitCustody())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Pet Name" name="PetName" type="text"
						value="<%=detail == null ? "" : String.valueOf(detail.getPetName())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:select label="Pet Animal Type" name="PetType" showEmptyOption="true" required="true">
						<%
							if(animalTypes.size() > 0) {
								for(PetAnimalType animalType : animalTypes) {
						%>
						<aui:option value="<%= animalType.getName() %>" selected="<%= detail != null && detail.getPetType().equals(animalType.getName()) %>"><%= animalType.getName() %></aui:option>
						<%
								}
							}
						%>
					</aui:select>
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:select label="Pet Gender" name="PetGender" showEmptyOption="true" required="true">
						<aui:option value="M" selected="<%= leads != null && detail.getPetGender().equals("M") %>">Male</aui:option>
						<aui:option value="F" selected="<%= leads != null && detail.getPetGender().equals("F") %>">Female</aui:option>
					</aui:select>
				</aui:col>
				
				<aui:col width="50">
					<%
						Integer dayD = null;
						Integer monthD = null;
						Integer yearD = null;
						
						if(leads != null && String.valueOf(detail.getPetDob()) != "" && String.valueOf(detail.getPetDob()) != "null") {
							SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
							LocalDate Dob = LocalDate.parse(date.format(detail.getPetDob()));
						
							dayD = Dob.getDayOfMonth();
							monthD = Dob.getMonthValue() - 1;
							yearD = Dob.getYear();
						}
					%>
					
					<aui:row>
						<aui:col width="100">
							<label>Pet Date Of Birth</label>
						</aui:col>
						<aui:col width="100">
							<% if(detail != null && String.valueOf(detail.getPetDob()) != "" && String.valueOf(detail.getPetDob()) != "null") { %>
							<liferay-ui:input-date 
								name="PetDob"
								dayValue="<%= dayD %>" 
								monthValue="<%= monthD %>"
								yearValue="<%= yearD %>" 
							/>
							<% } else { %>
							<liferay-ui:input-date 
								name="PetDob"
								nullable="true"
							/>
							<% } %>
						</aui:col>
					</aui:row>
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50">
					<aui:input label="Pet IdNumber" name="PetIdNumber" type="text"
						value="<%=detail == null ? "" : String.valueOf(detail.getPetIdNumber())%>" />
				</aui:col>
				
				<aui:col width="50">
					<aui:input label="Pet IdNumber Issuing" name="PetIdNumberIssuing" type="text"
						value="<%=detail == null ? "" : String.valueOf(detail.getPetIdNumberIssuing())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="100">
					<aui:input label="Pet Location" name="PetLocation" type="text"
						value="<%=detail == null ? "" : String.valueOf(detail.getPetLocation())%>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50" cssClass="pt-4">
					<aui:input label="PetVaccine" name="PetVaccine" type="checkbox"
						value="1" checked="<%=leads != null && detail.getPetVaccine() == 1 %>" />
				</aui:col>
				
				<aui:col width="50" cssClass="pt-4">
					<aui:input label="PetAuthorizedCertificate" name="PetAuthorizedCertificate" type="checkbox"
						value="1" checked="<%=leads != null && detail.getPetAuthorizedCertificate() == 1 %>" />
				</aui:col>
			</aui:row>
			
			<aui:row>
				<aui:col width="50" cssClass="pt-4">
					<aui:row>
						<aui:col width="50">
							<div class="lfr-blogs-small-image-selector form-group input-text-wrapper">
								<label class="product-admin-editor__heading">Pet Certificate</label>
								<%
									Long fileEntryId = detail == null ? 0 : Long.parseLong(String.valueOf(detail.getPetIdNumberFileEntryId()));
								%>
								
								<portlet:actionURL name="/leads/upload_image" var="uploadBankImageURL" />
		
								<liferay-item-selector:image-selector
									fileEntryId="<%= fileEntryId %>"
									itemSelectorEventName="<%= imageSelectedItemEventName %>"
									itemSelectorURL="<%= itemSelectorURL %>"
									maxFileSize="5242880"
									paramName="PetIdNumberFileEntry"
									uploadURL="<%= uploadBankImageURL %>"
									validExtensions="jpeg,.jpg,.png"
								/>
							</div>
						</aui:col>
					</aui:row>
				</aui:col>
				
				<aui:col width="50" cssClass="pt-4">
					<aui:row>
						<aui:col width="50">
							<div class="lfr-blogs-small-image-selector form-group input-text-wrapper">
								<label class="product-admin-editor__heading">Pet Photo</label>
								<%
									Long fileEntryId = detail == null ? 0 : Long.parseLong(String.valueOf(detail.getPetPhotoFileEntryId()));
								%>
								
								<portlet:actionURL name="/leads/upload_image" var="uploadBankImageURL" />
		
								<liferay-item-selector:image-selector
									fileEntryId="<%= fileEntryId %>"
									itemSelectorEventName="<%= imageSelectedItemEventName %>"
									itemSelectorURL="<%= itemSelectorURL %>"
									maxFileSize="5242880"
									paramName="PetPhotoFileEntry"
									uploadURL="<%= uploadBankImageURL %>"
									validExtensions="jpeg,.jpg,.png"
								/>
							</div>
						</aui:col>
					</aui:row>
				</aui:col>
			</aui:row>

		</aui:fieldset>
	</aui:fieldset-group>
</div>