<%@ include file="../includes/init.jsp"%>
<%
	long userRegistrationId = ParamUtil.getLong(renderRequest, "userRegistrationId", 0L);
	UserRegistration userRegistration = null;

	if (userRegistrationId > 0) {
		userRegistration = UserRegistrationLocalServiceUtil.fetchUserRegistration(userRegistrationId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
			<aui:form action="<%=addUserRegistrationURL%>"
				enctype="multipart/form-data" name="user_registration">
				<clay:sheet>
					<clay:sheet-header>
						<h2 class="sheet-title">
							<div class="row">
								<div class="col-lg-10">
									<div class="d-flex">
										<span class="pl-2 text-truncate text-capitalize">Edit
											User Registration</span>
									</div>
								</div>
							</div>
						</h2>
					</clay:sheet-header>

					<clay:sheet-section>
						<h3 class="sheet-subtitle">Basic Information</h3>
						<aui:row>
							<aui:col width="100">
								<aui:input label="Full Name" name="name" type="text"
									value="<%=userRegistration != null ? userRegistration.getName() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<aui:input label="ID Number" name="idNumber" type="text"
									value="<%=userRegistration != null ? userRegistration.getIdNumber() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<aui:input label="License Number" name="licenseNumber"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getLicenseNumber() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<aui:input label="Address" name="address" type="text"
									value="<%=userRegistration != null ? userRegistration.getAddress() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<aui:input label="Postal Address" name="postalAddress"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getPostalAddress() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="50">
								<aui:input label="Province" name="province" type="text"
									value="<%=userRegistration != null ? userRegistration.getProvince() : ""%>" />
							</aui:col>
							<aui:col width="50">
								<aui:input label="City" name="city" type="text"
									value="<%=userRegistration != null ? userRegistration.getCity() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<aui:input label="ZIP" name="zip" type="text"
									value="<%=userRegistration != null ? userRegistration.getZip() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="50">
								<aui:input label="Phone" name="phone" type="text"
									value="<%=userRegistration != null ? userRegistration.getPhone() : ""%>" />
							</aui:col>
							<aui:col width="50">
								<aui:input label="Mobile Phone" name="mobilePhone" type="text"
									value="<%=userRegistration != null ? userRegistration.getMobilePhone() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<aui:input label="Email" name="email" type="text"
									value="<%=userRegistration != null ? userRegistration.getEmail() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="50">
								<aui:input label="Birth Place" name="birthPlace" type="text"
									value="<%=userRegistration != null ? userRegistration.getBirthPlace() : ""%>" />
							</aui:col>
							<aui:col width="50">
								<aui:input label="Date of Birth" name="dob" type="text"
									value="<%=userRegistration != null ? userRegistration.getDob() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="50">
								<aui:input label="Gender" name="gender" type="text"
									value="<%=userRegistration != null ? userRegistration.getGender() : ""%>" />
							</aui:col>
							<aui:col width="50">
								<aui:input label="Marital Status" name="maritalStatus"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getMaritalStatus() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="50">
								<aui:input label="Residence Status" name="residenceStatus"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getResidenceStatus() : ""%>" />
							</aui:col>
							<aui:col width="50">
								<aui:input label="Stay Period" name="stayPeriod" type="text"
									value="<%=userRegistration != null ? userRegistration.getStayPeriod() : ""%>" />
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col width="100">
								<%
									HashMap<Integer, String> knownAXAFromOption = new HashMap<Integer, String>();
														knownAXAFromOption.put(1, "Televisi");
														knownAXAFromOption.put(2, "Majalah/Surat Kabar");
														knownAXAFromOption.put(3, "Referensi Kenalan");
														knownAXAFromOption.put(4, "Lainnya");
								%>
								<aui:select name="knowAXAFrom" label="Known AXA from">
									<%
										for (Map.Entry m : knownAXAFromOption.entrySet()) {
									%>
									<aui:option value="<%=m.getKey()%>"
										label="<%=m.getValue()%>"
										selected="<%=(userRegistration != null
												&& Integer.valueOf(userRegistration.getKnowAXAFrom()) == m.getKey())
														? true
														: false%>" />
									<%
										}
									%>
								</aui:select>
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="Known AXA From Other" name="knowAXAFromOther"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getKnowAXAFromOther() : ""%>" disabled="<%= true %>" />
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="Join Reason" name="joinReason" type="textarea" value="<%= userRegistration != null ? userRegistration.getJoinReason() : "" %>"/>
							</aui:col>
						</aui:row>
						
						<h3 class="sheet-subtitle">Bank & NPWP Information</h3>
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="Bank Name" name="bankName"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getBankName() : ""%>" />
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="Bank Account Name" name="bankAccountName"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getBankAccountName() : ""%>" />
							</aui:col>
						</aui:row>						
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="Bank Account Number" name="bankAccountNo"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getBankAccountNo() : ""%>" />
							</aui:col>
						</aui:row>					
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="NPWP" name="npwp"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getNpwp() : ""%>" />
							</aui:col>
						</aui:row>																		
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="NPWP Name" name="npwpName"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getNpwpName() : ""%>" />
							</aui:col>
						</aui:row>										
						
					<h3 class="sheet-subtitle">Portfolio</h3>
						
						<aui:row>
							<aui:col width="50">
								<aui:input label="Fire" name="portfolioFire"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getPortfolioFire() : ""%>" />
							</aui:col>
							
							<aui:col width="50">
								<aui:input label="Motor" name="portfolioMotor"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getPortfolioMotor() : ""%>" />
							</aui:col>							
						</aui:row>								
						
						<aui:row>
							<aui:col width="50">
								<aui:input label="Marine" name="portfolioMarine"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getPortfolioMarine() : ""%>" />
							</aui:col>
							
							<aui:col width="50">
								<aui:input label="Health" name="portfolioHealth"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getPortfolioHealth() : ""%>" />
							</aui:col>							
						</aui:row>
						
						<aui:row>
							<aui:col width="50">
								<aui:input label="Other" name="portfolioOther"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getPortfolioOther() : ""%>" />
							</aui:col>
						</aui:row>
						
					<h3 class="sheet-subtitle">Target</h3>
						
						<aui:row>
							<aui:col width="50">
								<aui:input label="Fire" name="targetFire"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getTargetFire() : ""%>" />
							</aui:col>
							
							<aui:col width="50">
								<aui:input label="Motor" name="targetMotor"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getTargetMotor() : ""%>" />
							</aui:col>							
						</aui:row>								
						
						<aui:row>
							<aui:col width="50">
								<aui:input label="Marine" name="targetMarine"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getTargetMarine() : ""%>" />
							</aui:col>
							
							<aui:col width="50">
								<aui:input label="Health" name="targetHealth"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getTargetHealth() : ""%>" />
							</aui:col>							
						</aui:row>
						
						<aui:row>
							<aui:col width="50">
								<aui:input label="Other" name="targetOther"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getTargetOther() : ""%>" />
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="Annual Premi Income" name="annualPremiIncome"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getAnnualPremiIncome() : ""%>" />
							</aui:col>
						</aui:row>
						
						<aui:row>
							<aui:col width="50">
								<aui:input label="Target Case" name="targetCase"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getTargetCase() : ""%>" />
							</aui:col>
							<aui:col width="50">
								<aui:input label="Target Premi" name="targetPremi"
									type="number"
									value="<%=userRegistration != null ? userRegistration.getTargetPremi() : ""%>" />
							</aui:col>							
						</aui:row>
						
						<aui:row>
							<aui:col width="100">
								<aui:input label="Prospect Source" name="prospectSource"
									type="text"
									value="<%=userRegistration != null ? userRegistration.getProspectSource() : ""%>" />
							</aui:col>
						</aui:row>

					</clay:sheet-section>
				</clay:sheet>
			</aui:form>
		</div>
	</div>
</div>

<aui:script use="aui-base" sandbox="<%= true %>">
$(document).ready(function (e) {
  $("select[name='<portlet:namespace />knowAXAFrom']").on("change", function () {
    let knowAXADesc = $("input[name='<portlet:namespace/>knowAXAFromOther']");
    if ($(this).val() === "4") {
      knowAXADesc.prev().removeClass("disabled");
      knowAXADesc.prop("disabled", false).removeClass("disabled");
    } else {
      knowAXADesc.prev().addClass("disabled");
      knowAXADesc.prop("disabled", true).addClass("disabled").val("");
    }
  });

  $("select[name='<portlet:namespace />knowAXAFrom']").trigger("change");
});

</aui:script>