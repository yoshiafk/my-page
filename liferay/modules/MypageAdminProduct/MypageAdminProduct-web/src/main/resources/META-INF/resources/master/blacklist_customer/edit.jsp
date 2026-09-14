<%@ include file="../includes/init.jsp"%>

<%
	Calendar calendar = Calendar.getInstance();
	long blacklistCustomerId = ParamUtil.getLong(renderRequest, "blacklistCustomerId", 0);
	BlacklistCustomer blacklistCustomer = null;

	if (blacklistCustomerId > 0) {
		blacklistCustomer = BlacklistCustomerLocalServiceUtil.fetchBlacklistCustomer(blacklistCustomerId);
	}
	
	// Set calendar to current blacklist cust's dob
	if(blacklistCustomer != null) {
		calendar.setTime(blacklistCustomer.getDateOfBirth());
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				String _active = "blacklist_customer";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addBlacklistCustomerURL%>" name="blacklistCustomer">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=blacklistCustomerId > 0 ? "Edit Blacklist Customer" : "Add New Blacklist Customer"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input
								checked="<%=blacklistCustomerId != 0 && blacklistCustomer != null
					? blacklistCustomer.getActive() == 1 ? true : false
					: true%>"
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
										<aui:input label="Full Name" name="fullName" type="text"
											required="true"
											value="<%=blacklistCustomer == null ? ""
										: String.valueOf(blacklistCustomer.getFullName())%>" />

										<aui:input label="First Name" name="firstName" type="text"
											required="true"
											value="<%=blacklistCustomer == null ? ""
										: String.valueOf(blacklistCustomer.getFirstName())%>" />

										<aui:input label="Middle Name" name="middleName" type="text"
											value="<%=blacklistCustomer == null ? ""
										: String.valueOf(blacklistCustomer.getMiddleName())%>" />

										<aui:input label="Last Name" name="lastName" type="text"
											value="<%=blacklistCustomer == null ? ""
										: String.valueOf(blacklistCustomer.getLastName())%>" />

										<aui:input label="KTP" name="ktp" type="text" required="true"
											value="<%=blacklistCustomer == null ? "" : String.valueOf(blacklistCustomer.getKtp())%>" />

										<aui:input label="KITAS" name="kitas" type="text"
											value="<%=blacklistCustomer == null ? "" : String.valueOf(blacklistCustomer.getKitas())%>" />

										<aui:input label="Email Address" name="email" type="text"
											value="<%=blacklistCustomer == null ? "" : String.valueOf(blacklistCustomer.getEmail())%>" />
										
										<label class="control-label" for="dateOfBirth">Date of Birth</label>
										<liferay-ui:input-date name="dateOfBirth"
											yearValue="<%=calendar.get(Calendar.YEAR)%>"
											monthValue="<%=calendar.get(Calendar.MONTH)%>"
											dayValue="<%=calendar.get(Calendar.DATE)%>" />

									</aui:col>
								</aui:row>

							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (blacklistCustomer != null) {
						%>
						<aui:input type="hidden" name="blacklistCustomerId"
							value="<%=String.valueOf(blacklistCustomer.getBlacklistCustomerId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel"
								onClick="<%=blacklistCustomerURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
