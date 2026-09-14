<%@ include file="../../includes/init.jsp"%>

<%
    List<Customer> customers = CustomerLocalServiceUtil.findByLeadsIdAndProductCode(leads.getLeadsId(), leads.getProductCode());
	
	List<MasterProvince> masterProvince = MasterProvinceLocalServiceUtil.getActiveProvinces();
%>

<div id="insured-container">
	<%
	    if(customers.size() > 0) {
	        int num = 0;
	        for(Customer customer : customers) {
	            num++;
	%>
	<div id="sheet-section-<%= num %>" class="sheet-section">
	    <aui:fieldset-group markupView="lexicon">
	        <aui:fieldset cssClass="p-4" label="<%= "Insured " + num %>" collapsible="true" collapsed="false">
	            <aui:row>
	                <aui:col width="50">
	                    <aui:input label="Name" name="Customer_Name[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getName())%>" />
	                </aui:col>
	                
	                <aui:col width="50">
	                    <aui:input label="Email" name="Customer_Email[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getEmail())%>" />
	                </aui:col>
	            </aui:row>
	            
	            <aui:row>
	                <aui:col width="50">
	                    <aui:input label="Mobile Phone" name="Customer_MobilePhone[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getMobilePhone())%>" />
	                </aui:col>
	                
	                <aui:col width="50">
	                    <aui:select label="Gender" name="Customer_Gender[]" showEmptyOption="true">
	                        <aui:option value="M" selected="<%= leads != null && customer.getGender().equals("M") %>">Male</aui:option>
	                        <aui:option value="F" selected="<%= leads != null && customer.getGender().equals("F") %>">Female</aui:option>
	                    </aui:select>
	                </aui:col>
	            </aui:row>
	            
	            <aui:row>
	                <aui:col width="50">
	                    <%
	                        Integer dayDC = null;
	                        Integer monthDC = null;
	                        Integer yearDC = null;
	                        
	                        if(leads != null && String.valueOf(customer.getDob()) != "" && String.valueOf(customer.getDob()) != "null") {
	                            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	                            LocalDate Dob = LocalDate.parse(date.format(customer.getDob()));
	                        
	                            dayDC = Dob.getDayOfMonth();
	                            monthDC = Dob.getMonthValue() - 1;
	                            yearDC = Dob.getYear();
	                        }
	                    %>
	                    <aui:row>
	                        <aui:col width="100">
	                            <label>Date Of Birth</label>
	                        </aui:col>
	                        <aui:col width="100">
	                            <% if(leads != null && String.valueOf(customer.getDob()) != "" && String.valueOf(customer.getDob()) != "null") { %>
	                            <liferay-ui:input-date 
	                                name="Customer_Dob[]"
	                                dayValue="<%= dayDC %>" 
	                                monthValue="<%= monthDC %>"
	                                yearValue="<%= yearDC %>" 
	                            />
	                            <% } else { %>
	                            <liferay-ui:input-date 
	                                name="Customer_Dob[]"
	                                nullable="true"
	                            />
	                            <% } %>
	                        </aui:col>
	                    </aui:row>
	                </aui:col>
	                
	                <aui:col width="50">
	                	<%
	                		if(leads != null && !leads.getProductCode().equals("IT")) {
	                	%>
	                    <aui:select label="Nationality" name="Customer_Nationality[]" showEmptyOption="true">
						<%
                            if(! masterCountry.isEmpty()) {
                           		for(MasterCountry country : masterCountry) {
                        %>                                            
                            <aui:option value="<%= country.getName() %>" selected="<%= leads != null && String.valueOf(country.getName()).toLowerCase().equals(String.valueOf(customer.getNationality()).toLowerCase()) %>"><%= country.getName() %></aui:option>
                        <%
                           		}
                           	}
                        %>
                        </aui:select>
                        <%
	                		} else {
                        %>
                        <aui:input label="Nationality" name="Customer_Nationality[]" type="text"
	                    	value="<%=leads == null ? "" : String.valueOf(customer.getNationality())%>" />
                        <%
	                		}
                        %>
	                </aui:col>
	            </aui:row>
	            
	            <aui:row>
	                <aui:col width="50">
	                    <aui:input label="Id Number" name="Customer_IdNumber[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getIdNumber())%>" />
	                </aui:col>
	                
	                <aui:col width="50">
	                    <aui:row>
	                        <aui:col width="50">
	                            <aui:input label="Passport Number" name="Customer_PassportNumber[]" type="text"
	                                value="<%=leads == null ? "" : String.valueOf(customer.getPassportNumber())%>" />
	                        </aui:col>
	                        
	                        <aui:col width="50">
	                            <aui:input label="KitasNumber" name="Customer_KitasNumber[]" type="text"
	                                value="<%=leads == null ? "" : String.valueOf(customer.getKitasNumber())%>" />
	                        </aui:col>
	                    </aui:row>
	                </aui:col>
	            </aui:row>
	            
	            <aui:row>
	                <aui:col width="50">
	                    <aui:input label="Relationship" name="Customer_Relationship[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getRelationship())%>" />
	                </aui:col>
	                
	                <aui:col width="50">
	                    <aui:input label="Type" name="Customer_Type[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getType())%>" />
	                </aui:col>
	            </aui:row>
	            
	            <aui:row>
	                <aui:col width="50">
	                    <aui:input label="Address" name="Customer_Address[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getAddress())%>" />
	                </aui:col>
	                
	                <aui:col width="50">
	                    <aui:input label="Address 2" name="Customer_Address2[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getAddress2())%>" />
	                </aui:col>
	            </aui:row>
	            
	            <aui:row>
	                <aui:col width="50">
                       <aui:input label="Province" name="Customer_Province[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getProvince())%>" />
	                </aui:col>
	                
	                <aui:col width="50">
	                	<aui:row>
	                		<aui:col width="50">
		                       <aui:input label="City" name="Customer_City[]" type="text"
	                        		value="<%=leads == null ? "" : String.valueOf(customer.getCity())%>" />
			                </aui:col>
			                
			                <aui:col width="50">
		                       <aui:input label="Zip" name="Customer_Zip[]" type="text"
	                        		value="<%=leads == null ? "" : String.valueOf(customer.getZip())%>" />
			                </aui:col>
	                	</aui:row>
	                </aui:col>
	            </aui:row>
	            
	            <aui:row>
	                <aui:col width="50">
	                    <aui:input label="Beneficiary" name="Customer_Beneficiary[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getBeneficiary())%>" />
	                </aui:col>
	                
	                <aui:col width="50">
	                    <aui:input label="BeneficiaryRelationship" name="Customer_BeneficiaryRelationship[]" type="text"
	                        value="<%=leads == null ? "" : String.valueOf(customer.getBeneficiaryRelationship())%>" />
	                </aui:col>
	            </aui:row>
	            
	            <aui:button-row>
					<aui:button onclick="<%= "document.getElementById('sheet-section-"+ num +"').remove()" %>" icon="icon-trash" cssClass="btn btn-danger remove-insured" primary="false" type="button" value="Remove"></aui:button>
				</aui:button-row>
	        </aui:fieldset>
	    </aui:fieldset-group>
	</div>
	<%
	        }
	    }
	%>
</div>

<div class="text-right">
  	<aui:button-row>
		<aui:button id="add-insured" icon="icon-plus-sign" primary="true" type="button" value="Add Insured"></aui:button>
	</aui:button-row>
</div>

<% 
	// For Clone
	// to add new insured
	///////////////////////////
%>
<div id="insured-clone" class="sheet-section d-none">
    <aui:fieldset-group markupView="lexicon">
        <aui:fieldset cssClass="p-4" label="Insured" collapsible="true" collapsed="false">
            <aui:row>
                <aui:col width="50">
                    <aui:input label="Name" name="Customer_Name" type="text" value="" />
                </aui:col>
                
                <aui:col width="50">
                    <aui:input label="Email" name="Customer_Email" type="text" value="" />
                </aui:col>
            </aui:row>
            
            <aui:row>
                <aui:col width="50">
                    <aui:input label="Mobile Phone" name="Customer_MobilePhone" type="text" value="" />
                </aui:col>
                
                <aui:col width="50">
                    <aui:select label="Gender" name="Customer_Gender" showEmptyOption="true">
                        <aui:option value="M">Male</aui:option>
                        <aui:option value="F">Female</aui:option>
                    </aui:select>
                </aui:col>
            </aui:row>
            
            <aui:row>
                <aui:col width="50">
                    <aui:row>
                        <aui:col width="100">
                            <aui:input cssClass="dob" placeholder="mm/dd/yyyy" label="Date Of Birth" name="Customer_Dob" type="text" value="" />
                        </aui:col>
                    </aui:row>
                </aui:col>
                
                <aui:col width="50">
                	<%
                		if(leads != null && !leads.getProductCode().equals("IT")) {
                	%>
                    <aui:select label="Nationality" name="Customer_Nationality" showEmptyOption="true">
						<%
                            if(! masterCountry.isEmpty()) {
                           		for(MasterCountry country : masterCountry) {
                        %>                                            
                            <aui:option value="<%= country.getName() %>"><%= country.getName() %></aui:option>
                        <%
                           		}
                           	}
                        %>
                   </aui:select>
                   <%
              			} else {
                   %>
                   		<aui:input label="Nationality" name="Customer_Nationality[]" type="text"
                  			value="" />
                   <%
              			}
                   %>
                </aui:col>
            </aui:row>
            
            <aui:row>
                <aui:col width="50">
                    <aui:input label="Id Number" name="Customer_IdNumber" type="text" value="" />
                </aui:col>
                
                <aui:col width="50">
                    <aui:row>
                        <aui:col width="50">
                            <aui:input label="Passport Number" name="Customer_PassportNumber" type="text" value="" />
                        </aui:col>
                        
                        <aui:col width="50">
                            <aui:input label="KitasNumber" name="Customer_KitasNumber" type="text" value="" />
                        </aui:col>
                    </aui:row>
                </aui:col>
            </aui:row>
            
            <aui:row>
                <aui:col width="50">
                    <aui:input label="Relationship" name="Customer_Relationship" type="text" value="" />
                </aui:col>
                
                <aui:col width="50">
                    <aui:input label="Type" name="Customer_Type" type="text" value="" />
                </aui:col>
            </aui:row>
            
            <aui:row>
                <aui:col width="50">
                    <aui:input label="Address" name="Customer_Address" type="text" value="" />
                </aui:col>
                
                <aui:col width="50">
                    <aui:input label="Address 2" name="Customer_Address2" type="text" value="" />
                </aui:col>
            </aui:row>
            
            <aui:row>
                <aui:col width="50">
                    <aui:input label="Province" name="Customer_Province" type="text" value="" />
                </aui:col>
                
                <aui:col width="50">
                    <aui:row>
		                <aui:col width="50">
		                    <aui:input label="City" name="Customer_City" type="text" value="" />
		                </aui:col>
		                
		                <aui:col width="50">
		                    <aui:input label="Zip" name="Customer_Zip" type="text" value="" />
		                </aui:col>
		            </aui:row>
                </aui:col>
            </aui:row>
            
            <aui:row>
                <aui:col width="50">
                    <aui:input label="Beneficiary" name="Customer_Beneficiary" type="text" value="" />
                </aui:col>
                
                <aui:col width="50">
                    <aui:input label="BeneficiaryRelationship" name="Customer_BeneficiaryRelationship" type="text" value="" />
                </aui:col>
            </aui:row>
            
            <aui:button-row>
				<aui:button onclick="" icon="icon-trash" cssClass="btn btn-danger remove-insured" primary="false" type="button" value="Remove"></aui:button>
			</aui:button-row>
        </aui:fieldset>
    </aui:fieldset-group>
</div>

<aui:script use="aui-base">
	var addBtn = document.getElementById("<portlet:namespace />add-insured");
	var removeBtn = document.querySelectorAll(".remove-insured");
	
	function addInsured() {
		var insuredContainer = document.getElementById("insured-container");
		var insuredForm = document.getElementById("insured-clone").cloneNode(true);
		var insuredElms = document.querySelectorAll("#insured-container .sheet-section");
		var input = insuredForm.querySelectorAll(".form-control");
		for(var i=0; i < input.length; i++) {
			input[i].name += "[]";
		}
		
		// rename id
		insuredForm.id = "sheet-section-" + (insuredElms.length+1);
		insuredForm.className = "sheet-section";
		insuredForm.querySelector(".collapse-icon").textContent = "Insured " + (insuredElms.length+1);
		insuredForm.querySelector(".collapse-icon").attributes.href.value = "#insured-content-" + (insuredElms.length+1);
		insuredForm.querySelector(".panel-collapse").id = "insured-content-" + (insuredElms.length+1);
		
		// add remove action
		insuredForm.getElementsByTagName("button")[0].attributes.onclick.value = 'document.getElementById("sheet-section-' + (insuredElms.length+1) +'").remove()';
		
		if(insuredElms.length) {
			var num = 0;
			for(var i=0; i < insuredElms.length; i++) {
				num++;
				
				// rename id
				insuredElms[i].id = "sheet-section-" + num;
				insuredElms[i].querySelector(".collapse-icon").text = "Insured " + num;
				insuredElms[i].querySelector(".collapse-icon").attributes.href.value = "#insured-content-" + num;
				insuredElms[i].querySelector(".panel-collapse").id = "insured-content-" + num;
				insuredElms[i].getElementsByTagName("button")[0].attributes.onclick.value = 'document.getElementById("sheet-section-' + num +'").remove()';
			}
		}
		
		insuredContainer.appendChild(insuredForm);
	}
	
	addBtn.onclick = function() {
		addInsured();
	}
	
	// add datepicker to dob
	YUI().use(
	  'aui-datepicker',
	  function(Y) {
	    new Y.DatePicker(
	      {
	        trigger: '.dob',
	        mask: '%m/%d/%Y',
	        popover: {
	          zIndex: 1
	        },
	      }
	    );
	  }
	);
</aui:script>