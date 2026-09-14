<%@ include file="includes/init.jsp"%>

<%
	String _code = "PET";
	ProductConfiguration _config = null;
	_config = ProductConfigurationLocalServiceUtil.getConfigByCode(_code);
%>

<portlet:actionURL name="updateProductConfiguration" var="updateProductConfigurationURL" />

<div class="container-fluid container-fluid-max-xl container-view">
<div class="row">
	<div class="col-lg-3">
		<%
			// setting for menu
			String _active = "configuration";
		%>
	
		<%@ include file="includes/left-menu.jsp"%>
	</div>
	
	<div class="col-lg-9">
		<div class="sheet sheet-full">
			<h2 class="sheet-title">
				<div class="d-flex">
					<aui:icon cssClass="" image="cog" markupView="lexicon" />	                    
                   	<span class="pl-2 text-truncate">Configuration</span>
				</div>
			</h2>
			
			<nav id="secondary-menu" class="navbar navbar-collapse-absolute navbar-expand-md navbar-underline navigation-bar navigation-bar-secondary">
			    <div class="container-fluid container-fluid-max-xl"><button class="navbar-toggler navbar-toggler-link collapsed btn btn-unstyled" type="button" aria-expanded="false">
			    		<span class="navbar-text-truncate">General</span>
			    		<svg class="lexicon-icon lexicon-icon-caret-bottom" role="presentation">
			                <use xlink:href="/o/admin-theme/images/clay/icons.svg#caret-bottom"></use>
			            </svg></button>
			        <div class="navbar-collapse collapse">
			            <div class="container-fluid container-fluid-max-xl">
			                <ul class="navbar-nav">
			                    <li data-nav-item-index="0" class="nav-item"><a class="nav-link axa-secondary-link active link-unstyled" data-tab="general" href="javascript:;" onclick="javascript:secondaryChange(this);">General</a></li>
								<li data-nav-item-index="1" class="nav-item"><a class="nav-link axa-secondary-link link-unstyled" data-tab="acl" href="javascript:;" onclick="javascript:secondaryChange(this);">Agent Credit Limit</a></li>
								<li data-nav-item-index="2" class="nav-item"><a class="nav-link axa-secondary-link link-unstyled" data-tab="linkImages" href="javascript:;" onclick="javascript:secondaryChange(this);">Link & Images</a></li>
								<li data-nav-item-index="3" class="nav-item"><a class="nav-link axa-secondary-link link-unstyled" data-tab="seosection" href="javascript:;" onclick="javascript:secondaryChange(this);">SEO</a></li>
			                </ul>
			            </div>
			        </div>
			    </div>
			</nav>
			
			<div class="sheet-section">
				<aui:form method="post" action="<%= updateProductConfigurationURL %>" name="<portlet:namespace />fm">
				<!--  GENERAL -->
					<div id="general" class="tab-items">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getProductName() %>" label="Product Name" name="product_name" type="text" required="true" />
									</aui:col>	
								</aui:row>
								<aui:row>
									<aui:col width="100">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getOjkName() %>" label="OJK Name" name="ojk_name" type="text" required="true" />
									</aui:col>	
								</aui:row>												
								<aui:row>			
									<aui:col width="50">
										<aui:input value="PET" label="Product Code" name="product_code" type="text" required="true" />
									</aui:col>
									<aui:col width="50">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getCommission() %>" label="Default Agent Commission" name="agent_commission" type="text" />
									</aui:col>						
								</aui:row>	
								<aui:row>
									<aui:col width="50">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getStampdutyIDR() %>" label="Stampduty IDR" name="stampduty_idr" type="text" />
									</aui:col>					
									<aui:col width="50">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getStampdutyUSD() %>" label="Stampduty USD" name="stampduty_usd" type="text" />
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col width="50">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getPolicyCostIDR() %>" label="Policy Cost IDR" name="policy_cost_idr" type="text" />
									</aui:col>					
									<aui:col width="50">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getPolicyCostUSD() %>" label="Policy Cost USD" name="policy_cost_usd" type="text" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<aui:input
											value="<%=Validator.isNull(_config) ? "" : _config.getWebContentFolderId()%>"
											label="Web Content Folder ID" name="web_content_folder_id"
											type="number" required="false" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<label class="control-label">Policy Wording</label>
										
										<div class="upload-image-wrapper mb-4">
												<%
													Long policyWordingEntryId = Validator.isNull(_config) ? 0 : _config.getPolicyWordingEntryId();
													FileEntry policyWordingFile = null;
												%>
												<c:if test="<%= policyWordingEntryId > 0  %>">
													<%
														policyWordingFile = DLAppLocalServiceUtil.getFileEntry(policyWordingEntryId);
													%>
												</c:if>										
											<div class="custom-file custom-file-grey">
												<input name="<portlet:namespace/>policyWordingFile" type="file" class="custom-file-input semi-bold browseInputFile">
												<label class="custom-file-label" for="customFile"><%= policyWordingEntryId > 0 ? policyWordingFile.getFileName() : ""  %></label>
											</div>
										</div>
									</aui:col>
								</aui:row>								
								
								<aui:row>
									<aui:col width="30">
										<% boolean _isB2C = !Validator.isNull(_config) && _config.getIsB2C()==1?true:false; %>
										<aui:input checked="<%= _isB2C %>" name="isB2C" type="toggle-switch" value="1" label="B2C" data-label-on="Allowed" data-label-off="Not ALlowed"   />						
									</aui:col>	
									<aui:col width="30">
										<% boolean _isB2B = !Validator.isNull(_config) && _config.getIsB2B()==1?true:false; %>
										<aui:input checked="<%= _isB2B %>" name="isB2B" type="toggle-switch" value="1" label="B2B" data-label-on="Allowed" data-label-off="Not ALlowed"   />						
									</aui:col>	
									<aui:col width="30">
										<% boolean _isB2B2C = !Validator.isNull(_config) && _config.getIsB2B2C()==1?true:false; %>
										<aui:input checked="<%= _isB2B2C %>" name="isB2B2C" type="toggle-switch" value="1" label="B2B2C" data-label-on="Allowed" data-label-off="Not ALlowed"   />						
									</aui:col>	
								</aui:row>		
								<aui:row>
									<aui:col width="30">
										<% boolean _pepEnable = !Validator.isNull(_config) && _config.getPepEnable()==1?true:false; %>
										<aui:input checked="<%= _pepEnable %>" name="pepEnable" type="toggle-switch" value="1" label="Enable PEP" data-label-on="Allowed" data-label-off="Not ALlowed"/>						
									</aui:col>
								</aui:row>
								
							</aui:fieldset>
						</aui:fieldset-group>
						
					</div>
					<!--  END GENERAL -->
					
					<!-- ACL -->
					<div id="acl" class="d-none tab-items">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="50">
										<% boolean _aclStatus = !Validator.isNull(_config) && _config.getAclStatus()==1?true:false; %>
										<aui:input checked="<%= _aclStatus %>" name="acl_status" type="toggle-switch" value="1" label="Allow ACL" data-label-on="Allowed" data-label-off="Not ALlowed"   />						
									</aui:col>	
													
									<aui:col width="50">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getAclGracePeriod() %>" label="ACL Grace Period" name="acl_grace_period" type="number" />
									</aui:col>
								</aui:row>	
							</aui:fieldset>	
						</aui:fieldset-group>
					</div>
					<!-- END ACL -->
					
					<!-- IMAGE -->
										<div id="linkImages" class="d-none tab-items">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input value="<%= Validator.isNull(_config)?"":_config.getLink() %>" label="Product URL" name="link" type="text" required="false" />
									</aui:col>	
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<label class="control-label">Product Icon</label>
										
										<div class="upload-image-wrapper mb-4">
											<div class="profilePreview">
												<%
													Long iconEntryId = Validator.isNull(_config) ? 0 : _config.getIconFileEntryId();
													FileEntry icon = null;
												%>
												<c:if test="<%= iconEntryId > 0  %>">
													<%
														icon = DLAppLocalServiceUtil.getFileEntry(iconEntryId);
														String iconUrl = "/documents/" + icon.getGroupId() + "/" + icon.getFolderId() + "/" + icon.getFileName(); 
													%>
													<liferay-adaptive-media:img class="img-fluid mb-4" fileVersion="<%= icon.getFileVersion() %>" />
												</c:if>
											</div>
											<div class="custom-file custom-file-grey">
												<input name="<portlet:namespace/>iconFile" type="file" class="custom-file-input semi-bold selectUploadImg">
												<label class="custom-file-label" for="customFile"><%= iconEntryId > 0 ? icon.getFileName() : ""  %></label>
											</div>
										</div>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<label class="control-label">Product Image</label>
										
										<div class="upload-image-wrapper mb-4">
											<div class="profilePreview">
												<%
													Long imageEntryId = Validator.isNull(_config) ? 0 : _config.getImageFileEntryId();
													FileEntry image = null;
												%>
												<c:if test="<%= imageEntryId > 0  %>">
													<%
														image = DLAppLocalServiceUtil.getFileEntry(imageEntryId);
														String imageUrl = "/documents/" + image.getGroupId() + "/" + image.getFolderId() + "/" + image.getFileName(); 
													%>
													<liferay-adaptive-media:img class="img-fluid mb-4" fileVersion="<%= image.getFileVersion() %>" />
												</c:if>
											</div>
											<div class="custom-file custom-file-grey">
												<input name="<portlet:namespace/>imageFile" type="file" class="custom-file-input semi-bold selectUploadImg">
												<label class="custom-file-label" for="customFile"><%= imageEntryId > 0 ? image.getFileName() : ""  %></label>
											</div>
										</div>
									</aui:col>
								</aui:row>

							</aui:fieldset>	
						</aui:fieldset-group>
					</div>
					<!-- END IMAGE -->
					
					<!-- SEO -->
					<div id="seosection" class="d-none tab-items">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">										
								<aui:row>
									<aui:col width="100">
										<aui:input label="Meta Title" name="meta_title" type="textarea" value="<%= Validator.isNull(_config)?"":_config.getMetaTitle() %>" />
									</aui:col>
									<aui:col width="100">
										<aui:input label="Meta Description" name="meta_description" type="textarea" value="<%= Validator.isNull(_config)?"":_config.getMetaDescription() %>" />
									</aui:col>
									<aui:col width="100">
										<aui:input label="Meta Keywords" name="meta_keywords" type="textarea" value="<%= Validator.isNull(_config)?"":_config.getMetaKeywords() %>" />
									</aui:col>									
								</aui:row>

							</aui:fieldset>	
						</aui:fieldset-group>
					</div>
					<!-- END SEO -->
					
					
					<aui:input name="productId" type="hidden" value='<%=  Validator.isNull(_config) ? "0" : _config.getProductId() %>'/>
					<aui:button-row>
						<aui:button name="submitButton" type="submit" value="Save" />
					</aui:button-row>	
				</aui:form>
			</div>	
			
		</div>
	</div>
</div>
</div>

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
<aui:script>
	var selectImgs = document.querySelectorAll(".selectUploadImg");
	for(var i = 0; i < selectImgs.length; i++) {
		var selectImgButton = selectImgs[i];
		selectImgButton.addEventListener('change', function(event) {
			var elm = event.target;
			var [file] = elm.files;
			
			if (file) {
				elm.parentNode.previousElementSibling.innerHTML = "<img class='img-thumbnail mb-4' src='"+URL.createObjectURL(file)+"' />";
				elm.nextElementSibling.innerHTML = event.target.files[0].name;
			}
		});
	}
	
	var bif = document.querySelectorAll(".browseInputFile");
	for(var i = 0; i < bif.length; i++) {
		var _bif = bif[i];
		_bif.addEventListener('change', function(event) {
			var elm = event.target;
			var [file] = elm.files;
			
			if (file) {
				elm.nextElementSibling.innerHTML = event.target.files[0].name;
			}
		});
	}	
</aui:script>