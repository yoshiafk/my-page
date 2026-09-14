<%@ include file="../includes/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.mypage.user.service.MypageUserLocalServiceUtil"%>
<%@ page import="com.mypage.user.model.MypageUser"%>

<%
	Calendar calendar = Calendar.getInstance();
	int depYear = calendar.get(Calendar.YEAR);
	int depMonth = calendar.get(Calendar.MONTH);
	int depDate = calendar.get(Calendar.DATE);
	
	int arrYear = calendar.get(Calendar.YEAR);
	int arrMonth = calendar.get(Calendar.MONTH);
	int arrDate = calendar.get(Calendar.DATE);
	
	long promocodeId = ParamUtil.getLong(renderRequest, "promocodeId", 0);
	MasterPromoCode promocodes = null;
	MypageUser mypageUser = null;

	if (promocodeId > 0) {
		promocodes = MasterPromoCodeLocalServiceUtil.fetchMasterPromoCode(promocodeId);
	}
	
	MasterDisplayContext masterDisplayContext = new MasterDisplayContext(liferayPortletRequest,
            liferayPortletResponse);

	JSONArray products = masterDisplayContext.getProducts();

	/* List<String> selected_products = new ArrayList<String>(); */
	if(promocodes != null){
		/* JSONArray _selected_products = null;
		_selected_products = JSONFactoryUtil.createJSONArray(promocodes.getProducts());
		for(Object _products:_selected_products){
			selected_products.add(_products.toString());
		} */
		
		mypageUser = MypageUserLocalServiceUtil.fetchMypageUser(promocodes.getMypageUserId());
		
		calendar.setTime(promocodes.getStartDate());
		depYear = calendar.get(Calendar.YEAR);
		depMonth = calendar.get(Calendar.MONTH);
		depDate = calendar.get(Calendar.DATE);
		
		calendar.setTime(promocodes.getEndDate());
		
		arrYear = calendar.get(Calendar.YEAR);
		arrMonth = calendar.get(Calendar.MONTH);
		arrDate = calendar.get(Calendar.DATE);
	}


	
%>

<liferay-util:buffer
	var="removeLicenseIcon"
>
	<liferay-ui:icon
		icon="times-circle"
		markupView="lexicon"
		message="remove"
	/>
</liferay-util:buffer>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "promocode";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
			<aui:form action="<%=addPromocodeURL%>" name="fmpromocode">
				<div class="sheet sheet-full">
					<h2 class="sheet-title">
						<div class="row">
							<div class="col-lg-8">
								<div class="d-flex">
									<aui:icon cssClass="" image="tag" markupView="lexicon" />
									<span class="pl-2 text-truncate"><%=promocodeId > 0 ? "Edit Promocode" : "Add New Promocode"%></span>
								</div>
							</div>
							<div class="col-lg-4">
								<aui:input checked="<%= promocodeId != 0 && promocodes != null ? promocodes.getActive() == 1 ? true : false : true %>" name="active"
								type="toggle-switch" value="1" label="Active"
								wrapperCssClass="leftToggleTitle" />
							</div>
						</div>
					</h2>
				
					<nav id="secondary-menu" class="navbar navbar-collapse-absolute navbar-expand-md navbar-underline navigation-bar navigation-bar-secondary">
				    	<div class="container-fluid container-fluid-max-xl">
				    		<button class="navbar-toggler navbar-toggler-link collapsed btn btn-unstyled" type="button" aria-expanded="false">
				    			<span class="navbar-text-truncate">General</span>
				    			<svg class="lexicon-icon lexicon-icon-caret-bottom" role="presentation">
									<use xlink:href="/o/admin-theme/images/clay/icons.svg#caret-bottom"></use>
				            	</svg>
				            </button>
				        	<div class="navbar-collapse collapse">
				            	<div class="container-fluid container-fluid-max-xl">
				                	<ul class="navbar-nav">
				                    	<li data-nav-item-index="0" class="nav-item"><a class="nav-link axa-secondary-link active link-unstyled" data-tab="general" href="javascript:;" onclick="javascript:secondaryChange(this);">General</a></li>
										<li data-nav-item-index="1" class="nav-item"><a class="nav-link axa-secondary-link link-unstyled" data-tab="agent" href="javascript:;" onclick="javascript:secondaryChange(this);">Agent</a></li>
										<li data-nav-item-index="2" class="nav-item"><a class="nav-link axa-secondary-link link-unstyled" data-tab="travel" href="javascript:;" onclick="javascript:secondaryChange(this);">Travel</a></li>
				                	</ul>
				            	</div>
				        	</div>
				    	</div>
					</nav>

					<div class="sheet-section">
					
						<!-- GENERAL SECTION -->
						<div id="general" class="tab-items">
							<aui:fieldset-group markupView="lexicon">
								<aui:fieldset cssClass="pt-4 pl-4">
									<aui:row>
										<aui:col width="50">
											<% boolean _isDefault = !Validator.isNull(promocodes) && promocodes.getIsDefault()==1?true:false; %>
											<aui:input checked="<%= _isDefault %>" name="isDefault" type="toggle-switch" value="1" label="Default" data-label-on="Allowed" data-label-off="Not ALlowed"   />						
										</aui:col>
										<aui:col width="50">
											<aui:select label="Product" name="product" required="true">
												<aui:option value="">Select</aui:option>
											    <% for(int i = 0; i < products.length(); i++){ %>
										    		<aui:option value="<%= products.getJSONObject(i).getString("Code") %>" selected="<%= promocodes != null && promocodes.getProductCode().equalsIgnoreCase(products.getJSONObject(i).getString("Code")) %>"><%= products.getJSONObject(i).getString("Code").concat(" - ").concat(products.getJSONObject(i).getString("Name")) %></aui:option>
										    	<% } %>
											</aui:select>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="50">
											<aui:select label="Promo Type" name="promotype">
												<aui:option value="">Select</aui:option>
											    <aui:option value="Birthday" selected="<%= promocodes != null && promocodes.getPromoType().equalsIgnoreCase("birthday") %>">Birthday</aui:option>
											    <aui:option value="Normal" selected="<%= promocodes != null && promocodes.getPromoType().equalsIgnoreCase("normal") %>">Normal</aui:option>
											</aui:select>
										</aui:col>
										<aui:col width="50">
											<aui:input label="Promocode" name="promocode" type="text"
											required="true"
											value="<%=promocodes == null ? "" : String.valueOf(promocodes.getPromoCode())%>" />
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="50">
											<aui:input label="Discount" name="discount" type="number"
											required="true" pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==2) return false;"
											value="<%=promocodes == null ? "" : String.valueOf(promocodes.getDiscount())%>" />
										</aui:col>
										<aui:col width="25">
											<label class="control-label">Start Date</label>	
											<liferay-ui:input-date name="startdate"
											yearValue="<%=depYear%>"
											monthValue="<%=depMonth%>"
											dayValue="<%=depDate%>" />
										</aui:col>
										<aui:col width="25">
											<label class="control-label">End Date</label>
											<liferay-ui:input-date name="enddate"
											yearValue="<%=arrYear%>"
											monthValue="<%=arrMonth%>"
											dayValue="<%=arrDate%>" />
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="50">
											<aui:select label="Active Day" name="activeday" multiple="true">
												<aui:option value="">None</aui:option>
												<aui:option value="Mon" selected="<%= promocodes != null && promocodes.getActiveDay().toLowerCase().contains("mon") %>">Senin</aui:option>
												<aui:option value="Tue" selected="<%= promocodes != null && promocodes.getActiveDay().toLowerCase().contains("tue") %>">Selasa</aui:option>
												<aui:option value="Wed" selected="<%= promocodes != null && promocodes.getActiveDay().toLowerCase().contains("wed") %>">Rabu</aui:option>
												<aui:option value="Thu" selected="<%= promocodes != null && promocodes.getActiveDay().toLowerCase().contains("thu") %>">Kamis</aui:option>
												<aui:option value="Fri" selected="<%= promocodes != null && promocodes.getActiveDay().toLowerCase().contains("fri") %>">Jumat</aui:option>
												<aui:option value="Sat" selected="<%= promocodes != null && promocodes.getActiveDay().toLowerCase().contains("sat") %>">Sabtu</aui:option>
												<aui:option value="Sun" selected="<%= promocodes != null && promocodes.getActiveDay().toLowerCase().contains("sun") %>">Minggu</aui:option>
											</aui:select>
										</aui:col>
										<aui:col width="50">
											<aui:input label="Limit" name="limit" type="text"
											value="<%=promocodes == null ? "" : String.valueOf(promocodes.getLimit())%>" />
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="50">
											<aui:input label="Network" name="network" type="text"
											value="<%=promocodes == null ? "" : String.valueOf(promocodes.getNetwork())%>" />
										</aui:col>
										<aui:col width="50">
											<aui:input label="Channel / Role" name="channel" type="text"
											value="<%=promocodes == null ? "" : String.valueOf(promocodes.getChannel())%>" />
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="30">
											<% boolean _isB2C = !Validator.isNull(promocodes) && promocodes.getIsB2C()==1?true:false; %>
											<aui:input checked="<%= _isB2C %>" name="isB2C" type="toggle-switch" value="1" label="B2C" data-label-on="Allowed" data-label-off="Not ALlowed"   />						
										</aui:col>	
										<aui:col width="30">
											<% boolean _isB2B2C = !Validator.isNull(promocodes) && promocodes.getIsB2B2C()==1?true:false; %>
											<aui:input checked="<%= _isB2B2C %>" name="isB2B2C" type="toggle-switch" value="1" label="B2B2C" data-label-on="Allowed" data-label-off="Not ALlowed"   />						
										</aui:col>	
										<aui:col width="30">
											<% boolean _isB2B = !Validator.isNull(promocodes) && promocodes.getIsB2B()==1?true:false; %>
											<aui:input checked="<%= _isB2B %>" name="isB2B" type="toggle-switch" value="1" label="B2B" data-label-on="Allowed" data-label-off="Not ALlowed"   />						
										</aui:col>	
									</aui:row>
									<aui:row>
										<aui:col width="50">
											<aui:select label="Payment" name="payment">
												<aui:option value="">Select</aui:option>
											    <aui:option value="HSBC" selected="<%= promocodes != null && promocodes.getPayment().equalsIgnoreCase("hsbc") %>">HSBC</aui:option>
											    <aui:option value="AllDoku" selected="<%= promocodes != null && promocodes.getPayment().equalsIgnoreCase("alldoku") %>">AllDoku</aui:option>
											</aui:select>
										</aui:col>
										<aui:col width="50">
											<aui:select label="Birthday Month" name="birthdaymonth">
												<aui:option value="">Select</aui:option>
											    <aui:option value="01" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("01") %>">Januari</aui:option>
											    <aui:option value="02" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("02") %>">Februari</aui:option>
											    <aui:option value="03" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("03") %>">Maret</aui:option>
											    <aui:option value="04" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("04") %>">April</aui:option>
											    <aui:option value="05" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("05") %>">Mei</aui:option>
											    <aui:option value="06" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("06") %>">Juni</aui:option>
											    <aui:option value="07" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("07") %>">Juli</aui:option>
											    <aui:option value="08" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("08") %>">Agustus</aui:option>
											    <aui:option value="09" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("09") %>">September</aui:option>
											    <aui:option value="10" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("10") %>">Oktober</aui:option>
											    <aui:option value="11" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("11") %>">November</aui:option>
											    <aui:option value="12" selected="<%= promocodes != null && promocodes.getBirthdayMonth().equalsIgnoreCase("12") %>">Desember</aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="100">
											<liferay-editor:editor 
									            contents="<%= promocodes != null ? String.valueOf(promocodes.getRemarks()) : "" %>" 
												cssClass="product-admin-editor" 
									            editorName="ckeditor" 
									            name="remarks" 
									            placeholder="Remarks"
									            showSource="true"
									        />
										</aui:col>
									</aui:row>
								</aui:fieldset>
							</aui:fieldset-group>
						</div>
						<!-- END GENERAL SECTION -->
						
						<!-- AGENT SECTION -->
						<div id="agent" class="d-none tab-items">
							<aui:fieldset-group markupView="lexicon">
								<aui:fieldset cssClass="pt-4 pl-4">
									<clay:content-row
									    containerElement="h3"
									    cssClass="sheet-subtitle"
									    >
									    <clay:content-col expand="<%= true %>">
									        <span class="heading-text">
									            User
									        </span>
									    </clay:content-col>
									    <clay:content-col>
									        <span class="heading-end">
									            <liferay-ui:icon
									                cssClass="add-user"
									                id="selectUser"
									                label="<%= true %>"
									                linkCssClass="btn btn-secondary btn-sm"
									                message="select"
									                method="get"
									                url="javascript:;"
									                />
									        </span>
									    </clay:content-col>
									</clay:content-row>
									<aui:row>
										<aui:input 
										    name="mypageUserId" 
										    type="hidden"
										    value="<%= Validator.isNull(mypageUser) ? "" : mypageUser.getMypageUserId() %>"
										     />
										<aui:col width="100">
										    <p id="no-user" class="text-muted pb-4 <%= Validator.isNull(mypageUser) ? "" : "d-none" %>">
										        list of user
										    </p>
										    
										    <table class="show-quick-actions-on-hover table table-autofit table-heading-nowrap table-list mb-4 <%= Validator.isNull(mypageUser) ? "d-none" : "" %>" 
										        id="user-table">
										        <thead>
										            <tr>
										            	<th class="lfr-title-column">Code</th>
										                <th class="lfr-title-column">Full Name</th>
										                <th class="lfr-entry-action-column"> &nbsp; </th>
										            </tr>
										        </thead>
										        <tbody id="user-table-body">
										        	<% if (Validator.isNotNull(mypageUser)) { %>
											            <tr id="user-row-<%= mypageUser.getMypageUserId() %>">
											                <td>
																<span><%= mypageUser.getCode() %></span>
															</td>
											                <td>
											                    <span><%= mypageUser.getUserName() %></span>
											                </td>
											                <td>
											                    <a onclick="removeUser(this)" data-id="<%= mypageUser.getMypageUserId() %>" id="remove-user" href="javascript:;">
											                        <%= removeLicenseIcon %>
											                    </a>
											                </td>
											            </tr>
													<% } %>
										        </tbody>
										    </table>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="30">
											<aui:input label="Agent Name" name="agentname" type="text"
											value="<%=promocodes == null ? "" : String.valueOf(promocodes.getAgentName())%>" />
										</aui:col>
										<aui:col width="30">
											<aui:input label="Deptore Code" name="deptorecode" type="text"
											value="<%=promocodes == null ? "" : String.valueOf(promocodes.getDeptoreCode())%>" />
										</aui:col>
										<aui:col width="30">
											<aui:input label="Commission" name="commission" type="number"
											pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==2) return false;"
											value="<%=promocodes == null ? "" : String.valueOf(promocodes.getCommission())%>" />
										</aui:col>
									</aui:row>
								</aui:fieldset>	
							</aui:fieldset-group>
						</div>
						<!-- END AGENT SECTION -->
						
						<!-- TRAVEL SECTION -->
						<div id="travel" class="d-none tab-items">
							<aui:fieldset-group markupView="lexicon">
								<aui:fieldset cssClass="pt-4 pl-4">
									<aui:row>
										<aui:col width="50">
											<aui:select label="Plan" name="plan">
												<aui:option value="">Select</aui:option>
											    <aui:option value="Platinum" selected="<%= promocodes != null && promocodes.getPlan_().equalsIgnoreCase("platinum") %>">Platinum</aui:option>
											    <aui:option value="Gold" selected="<%= promocodes != null && promocodes.getPlan_().equalsIgnoreCase("gold") %>">Gold</aui:option>
											    <aui:option value="SpesialAsia" selected="<%= promocodes != null && promocodes.getPlan_().equalsIgnoreCase("spesialasia") %>">Spesial Asia</aui:option>
											    <aui:option value="Standard" selected="<%= promocodes != null && promocodes.getPlan_().equalsIgnoreCase("standard") %>">Standard</aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="50">
											<aui:select label="Promocode Terms" name="promocodeterms">
												<aui:option value="">Select</aui:option>
											    <aui:option value="Annual" selected="<%= promocodes != null && promocodes.getPromoCodeTerms().equalsIgnoreCase("annual") %>">Annual</aui:option>
											    <aui:option value="ShortTerm" selected="<%= promocodes != null && promocodes.getPromoCodeTerms().equalsIgnoreCase("shortterm") %>">Short Term</aui:option>
											    <aui:option value="Both" selected="<%= promocodes != null && promocodes.getPromoCodeTerms().equalsIgnoreCase("both") %>">Both</aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col width="50">
											<aui:select label="Traveller Type" name="travellertype">
												<aui:option value="">Select</aui:option>
											    <aui:option value="All" selected="<%= promocodes != null && promocodes.getTravellerType().equalsIgnoreCase("all") %>">All</aui:option>
											    <aui:option value="Individu" selected="<%= promocodes != null && promocodes.getTravellerType().equalsIgnoreCase("individu") %>">Individu</aui:option>
											    <aui:option value="Family" selected="<%= promocodes != null && promocodes.getTravellerType().equalsIgnoreCase("family") %>">Family</aui:option>
											    <aui:option value="Duo" selected="<%= promocodes != null && promocodes.getTravellerType().equalsIgnoreCase("duo") %>">Duo</aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
								</aui:fieldset>	
							</aui:fieldset-group>
						</div>
						<!-- END TRAVEL SECTION -->

						<% if (promocodes != null) { %>
						
							<aui:input type="hidden" name="promocodeId" value="<%=String.valueOf(promocodes.getPromoCodeId())%>" />
						
						<% } %>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=promocodeURL.toString()%>"></aui:button>
						</aui:button-row>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<aui:script use="liferay-search-container">
   	var selectUserButton = document.getElementById('<portlet:namespace />selectUser');
   	var searchContainer = Liferay.SearchContainer.get("user-table");
   	var rowColumns = [];
	
   	selectUserButton.addEventListener('click', function(event) {
		
        new Liferay.Util.openSelectionModal({
            onSelect: function(event) {
            	var no_user = document.getElementById('no-user');
            	var row = `
            		<tr id="user-row-`+event.entityid+`">
	            		<td>
			                <span>`+event.entitycode+`</span>
			            </td>
	            		<td>
			                <span>`+event.entityname+`</span>
			            </td>
			            <td>
			                <a onclick="removeUser(this)" data-id="`+ event.entityid +`" id="remove-user" href="javascript:;"><%= UnicodeFormatter.toString(removeLicenseIcon) %></a>
			            </td>
		            </tr>`;
		            
            	if(no_user != null) no_user.classList.add('d-none');
            	var currentValues = document.<portlet:namespace />fmpromocode.<portlet:namespace />mypageUserId.value ? document.<portlet:namespace />fmpromocode.<portlet:namespace />mypageUserId.value.split(',') : []
            	if (!currentValues.includes(event.entityid)) {
            		document.getElementById("user-table-body").innerHTML += row;
            		currentValues.push(event.entityid);
            	}
            	document.<portlet:namespace />fmpromocode.<portlet:namespace />mypageUserId.value = currentValues.join(',');
            	document.getElementById("user-table").classList.remove('d-none')
            	selectUserButton.classList.add('d-none');
            },
            title: 'Select User',
            <%
            	String eventName = liferayPortletResponse.getNamespace() + "selectMypageUser";
    			PortletURL selectUserURL = PortletProviderUtil.getPortletURL(renderRequest, MypageUser.class.getName(), PortletProvider.Action.BROWSE);
    			selectUserURL.setParameter("mvcPath", "/user_group/select_user.jsp");
    			selectUserURL.setParameter("eventName", eventName);
    			selectUserURL.setWindowState(LiferayWindowState.POP_UP);
            %>

            selectEventName: '<%= eventName %>',
            selectedData: [document.<portlet:namespace />fmpromocode.<portlet:namespace />mypageUserId.value],
            url: '<%= selectUserURL %>'
        });
	});
	
	removeUser = function(e) {
		var no_user = document.getElementById('no-user');
		var data_id = e.dataset.id;
		document.getElementById("user-row-" + data_id + "").remove();
		var valueArray = document.<portlet:namespace />fmpromocode.<portlet:namespace />mypageUserId.value.split(',');
		var indexToRemove = valueArray.indexOf(data_id);
		if (indexToRemove !== -1) {
		    valueArray.splice(indexToRemove, 1);
		}
        document.<portlet:namespace />fmpromocode.<portlet:namespace />mypageUserId.value = valueArray.join(',');
        if (!document.<portlet:namespace />fmpromocode.<portlet:namespace />mypageUserId.value) {
	        document.getElementById("user-table").classList.add('d-none')
	        if(no_user != null) no_user.classList.remove('d-none');
		}
		selectUserButton.classList.remove('d-none');
	}
</aui:script>

<script>
	function secondaryChange(el){
		var el = el || false;
		var tabName = "";
		if(!el) return el;
		var boxes = Array.from(document.getElementsByClassName('axa-secondary-link'));
		
		boxes.forEach(box => {
		  box.classList.remove("active"); 
		});
		
		el.classList.add("active");
		tabName = el.dataset.tab;
		
		var tabs = Array.from(document.getElementsByClassName('tab-items'));
		tabs.forEach(tab => {
		  tab.classList.add("d-none");
		});	
		
		var activeTab=document.getElementById(tabName);
		activeTab.classList.remove("d-none");
	
	}
</script>