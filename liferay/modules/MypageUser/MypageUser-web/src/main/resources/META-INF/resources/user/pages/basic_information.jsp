<%@ include file="../variables.jsp"%>

<%
	List<MasterCountry> masterCountry = MasterCountryLocalServiceUtil.getActiveCountries();
	List<MasterProvince> masterProvince = MasterProvinceLocalServiceUtil.getActiveProvinces();
	List<MasterCity> masterCity = MasterCityLocalServiceUtil.getActiveCities();
%>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script src="<%=request.getContextPath()%>/js/nice-select2.js" type="text/javascript"></script>
</liferay-util:html-bottom>

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

<h3 class="sheet-subtitle">Personal Information</h3>

<aui:row>
    <aui:col width="50">
        <aui:input label="Screen Name" name="screenName" type="text" required="true"
            value="<%= liferayUserId > 0 ? liferayUser.getScreenName() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="Email Address" name="emailAddress" type="email" required="true"
            value="<%= liferayUserId > 0 ? liferayUser.getEmailAddress() : "" %>">
            <aui:validator name="email" />
        </aui:input>
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="First Name" name="firstName" type="text" required="true"
            value="<%= liferayUserId > 0 ? liferayUser.getFirstName() : "" %>">
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
        <aui:input label="Middle Name" name="middleName" type="text"
            value="<%= liferayUserId > 0 ? liferayUser.getMiddleName() : "" %>">
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
        <aui:input label="Last Name" name="lastName" type="text" required="true"
            value="<%= liferayUserId > 0 ? liferayUser.getLastName() : "" %>">
            <aui:validator errorMessage="Only letter and space are allowed." 
	        name="custom">
	                function(val, fieldNode, ruleValue) {
	                        var regex = new RegExp(/^(?![\s.]+$)[a-zA-Z\s.]*$/i);
	
	                        return regex.test(val);
	                }
	        </aui:validator>
        </aui:input>
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <%
            Integer dayDC = null;
            Integer monthDC = null;
            Integer yearDC = null;
            
            if(liferayUser != null && String.valueOf(liferayUser.getBirthday()) != "" && String.valueOf(liferayUser.getBirthday()) != "null") {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                LocalDate Dob = LocalDate.parse(date.format(liferayUser.getBirthday()));
            
                dayDC = Dob.getDayOfMonth();
                monthDC = Dob.getMonthValue() - 1;
                yearDC = Dob.getYear();
            }
        %>
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
                <% if(liferayUser != null && String.valueOf(liferayUser.getBirthday()) != "" && String.valueOf(liferayUser.getBirthday()) != "null") { %>
                <liferay-ui:input-date 
                    name="birthday"
                    dayValue="<%= dayDC %>" 
                    monthValue="<%= monthDC %>"
                    yearValue="<%= yearDC %>" 
                    required="true"
                />
                <% } else { %>
                <liferay-ui:input-date 
                    name="birthday"
                    nullable="true"
                    showDisableCheckbox="false"
                    required="true"
                />
                <% } %>
            </aui:col>
        </aui:row>
    </aui:col>
    <aui:col width="50">
        <aui:input label="BirthPlace" name="birthPlace" type="text"
            value="<%= mypageUser != null ? mypageUser.getBirthPlace() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:select label="Gender" name="gender" showEmptyOption="true">
            <aui:option value="M" selected="<%= mypageUser != null && mypageUser.getGender().equals("M") %>">Male</aui:option>
            <aui:option value="F" selected="<%= mypageUser != null && mypageUser.getGender().equals("F") %>">Female</aui:option>
        </aui:select>
    </aui:col>
    
    <aui:col width="50">
        <aui:input label="Id Number" name="idNumber" type="text" value="<%= mypageUser != null ? mypageUser.getIdNumber() : "" %>">
            <aui:validator name="number" />
            <aui:validator name="minLength">16</aui:validator>
        </aui:input>
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Phone" name="phone" type="text"
            value="<%= mypageUser != null ? mypageUser.getPhone() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="Mobile Phone" name="mobilePhone" type="text" required="true"
            value="<%= mypageUser != null ? mypageUser.getMobilePhone() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="100">
        <aui:input label="Address" name="address" type="textarea" required="true"
            value="<%= mypageUser != null ? mypageUser.getAddress() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:select cssClass="custom-nice-select" label="Country" name="country" showEmptyOption="true">
            <%
                if(! masterCountry.isEmpty()) {
                    for(MasterCountry country : masterCountry) {
            %>                                            
            <aui:option value="<%= country.getCountryId() %>" selected="<%= mypageUser != null && country.getCountryId() == mypageUser.getCountry() %>"><%= country.getName() %></aui:option>
            <%
                    }
                }
            %>
        </aui:select>
    </aui:col>
    <aui:col width="50">
        <aui:select cssClass="custom-nice-select" label="Province" name="province" showEmptyOption="true">
            <%
                if(! masterProvince.isEmpty()) {
                    for(MasterProvince province : masterProvince) {
            %>                                            
            <aui:option value="<%= province.getMasterProvinceId() %>" selected="<%= mypageUser != null && province.getMasterProvinceId() == mypageUser.getProvince() %>"><%= province.getName() %></aui:option>
            <%
                    }
                }
            %>
        </aui:select>
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:select cssClass="custom-nice-select" label="City" name="city" showEmptyOption="true">
            <%
                if(! masterCity.isEmpty()) {
                    for(MasterCity city : masterCity) {
            %>                                            
            <aui:option disabled="true" province="<%= city.getProvinceId() %>" value="<%= city.getMasterCityId() %>" selected="<%= mypageUser != null && city.getMasterCityId() == mypageUser.getCity() %>"><%= city.getName() %></aui:option>
            <%
                    }
                }
            %>
        </aui:select>
    </aui:col>
    
    <aui:col width="50">
        <aui:input label="Zip" name="zip" type="text"
            value="<%= mypageUser != null ? mypageUser.getZip() : "" %>">
            <aui:validator name="number" />
        </aui:input>
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Latitude" name="latitude" type="text"
            value="<%= mypageUser != null ? mypageUser.getLatitude() : "" %>" />
    </aui:col>
    <aui:col width="50">
        <aui:input label="Longitude" name="longitude" type="text"
            value="<%= mypageUser != null ? mypageUser.getLongitude() : "" %>" />
    </aui:col>
</aui:row>

<aui:row>
    <aui:col width="50">
        <aui:input label="Position Zoom" name="positionZoom" type="text"
            value="<%= mypageUser != null ? mypageUser.getPositionZoom() : "" %>">
            <aui:validator name="number" />
        </aui:input>
    </aui:col>
</aui:row>

<aui:script>
	AUI().ready('aui-module', function(A){ 
		// nice select2 library
		var options = {searchable: true};
		NiceSelect.bind(document.getElementById('<portlet:namespace />country'), options);
		var province = NiceSelect.bind(document.getElementById('<portlet:namespace />province'), options);
		var city = NiceSelect.bind(document.getElementById('<portlet:namespace />city'), options);
		
		// province on change
		var provinceElm = document.getElementById('<portlet:namespace />province');
		provinceElm.addEventListener('change', function(e) {
			customSelect(false);
		});
		
		function customSelect(onload) {
			var val = document.getElementById('<portlet:namespace />province').value;
			
			// disabled all cities
			var getAllCities = document.querySelectorAll("select#<portlet:namespace />city option");
			if(getAllCities.length) {			
				for(var i of getAllCities) {
					i.disabled = true;
					if(!onload) i.removeAttribute('selected');
				}
			}
			
			if(!onload) document.getElementById('<portlet:namespace />city').value = "";
			
			// enable city based on province
			var getCities = document.querySelectorAll("select#<portlet:namespace />city option[province='"+val+"']");
			if(getCities.length) {
				for(var i=0; i < getCities.length; i++) {
					getCities[i].disabled = false;
				}
			}
			city.destroy();
			city = NiceSelect.bind(document.getElementById('<portlet:namespace />city'), options);
		}
		customSelect(true);
	});
</aui:script>