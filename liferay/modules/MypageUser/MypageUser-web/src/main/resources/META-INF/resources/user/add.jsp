<%@ include file="variables.jsp"%>

<liferay-ui:success key="success" message="Your request completed successfully." />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-12">
            <aui:form action="<%=addUserURL%>" enctype="multipart/form-data" name="user">
            	<clay:sheet>
            		<clay:sheet-header>
						<h2 class="sheet-title">
	                        <div class="row">
	                            <div class="col-lg-10">
	                                <div class="d-flex">
	                                    <span class="pl-2 text-truncate text-capitalize">Add User</span>
	                                </div>
	                            </div>
	                            <c:if test="<%= allowAdd %>">  
		                            <div class="col-lg-2">
		                                <aui:input checked="<%= mypageUser != null ? mypageUser.getActive() == 1 ? true : false : true %>" name="active"
		                                    type="toggle-switch" value="1" label="Active"
		                                    wrapperCssClass="leftToggleTitle" />
		                            </div>
		                    	</c:if>
	                        </div>
	                    </h2>
					</clay:sheet-header>
            	
            		<clay:sheet-section>
            			<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeDuplicate.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" focusField="screenName" message="the-screen-name-cannot-be-blank" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNumeric.class %>" focusField="screenName" message="the-screen-name-cannot-contain-only-numeric-values" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeReserved.class %>" focusField="screenName" message="the-screen-name-you-requested-is-reserved" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeReservedForAnonymous.class %>" focusField="screenName" message="the-screen-name-you-requested-is-reserved-for-the-anonymous-user" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeUsedByGroup.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken-by-a-site" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustProduceValidFriendlyURL.class %>" focusField="screenName" message="the-screen-name-you-requested-must-produce-a-valid-friendly-url" />
						
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" focusField="emailAddress" message="the-email-address-you-requested-is-already-taken" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" focusField="emailAddress" message="please-enter-an-email-address" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBePOP3User.class %>" focusField="emailAddress" message="the-email-address-you-requested-is-reserved" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeReserved.class %>" focusField="emailAddress" message="the-email-address-you-requested-is-reserved" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotUseCompanyMx.class %>" focusField="emailAddress" message="the-email-address-you-requested-is-not-valid-because-its-domain-is-reserved" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustValidate.class %>" focusField="emailAddress" message="please-enter-a-valid-email-address" />
            		
            			<aui:row>
						    <aui:col width="50">
						        <aui:input label="Screen Name" name="screenName" type="text" required="true"
						            value="" />
						    </aui:col>
						    <aui:col width="50">
						        <aui:input label="Email Address" name="emailAddress" type="email" required="true"
						            value="">
						            <aui:validator name="email" />
						        </aui:input>
						    </aui:col>
						</aui:row>
            		
            			<aui:row>
						    <aui:col width="50">
						        <aui:input label="First Name" name="firstName" type="text" required="true"
						            value="">
						            <aui:validator name="alpha" />
						        </aui:input>
						    </aui:col>
						    <aui:col width="50">
						        <aui:input label="Middle Name" name="middleName" type="text"
						            value="">
						            <aui:validator name="alpha" />
						        </aui:input>
						    </aui:col>
						    <aui:col width="50">
						        <aui:input label="Last Name" name="lastName" type="text" required="true"
						            value="">
						            <aui:validator name="alpha" />
						        </aui:input>
						    </aui:col>
						</aui:row>
						
						<aui:row>
						    <aui:col width="50">
						        <aui:row>
						            <aui:col width="100">
						                <label>
						                	Date Of Birth
						                	<aui:icon
											     cssClass="reference-mark text-warning"
											     image="asterisk"
											     markupView="lexicon"
											/>
						                </label>
						            </aui:col>
						            <aui:col width="100">
						                <liferay-ui:input-date 
						                    name="birthday"
						                    nullable="true"
						                    showDisableCheckbox="false"
						                    required="true"
						                    dayValue="1" 
						                    monthValue="1"
						                    yearValue="1994" 
						                />
						            </aui:col>
						        </aui:row>
						    </aui:col>
						    <aui:col width="50">
						        <aui:input label="BirthPlace" name="birthPlace" type="text"
						            value="" />
						    </aui:col>
						</aui:row>
						
						<aui:input type="hidden" name="pageKey" value="add_user" />

		                <aui:button-row>
		                    <aui:button name="submitButton" type="submit" value="Save" />
		                    <aui:button type="cancel" onClick="<%=userURL.toString()%>"></aui:button>
		                </aui:button-row>
            		</clay:sheet-section>
            	</clay:sheet>
            </aui:form>
        </div>
	</div>
</div>
