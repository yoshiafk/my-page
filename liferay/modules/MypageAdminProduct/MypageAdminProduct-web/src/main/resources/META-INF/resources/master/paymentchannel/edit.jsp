<%@ include file="../includes/init.jsp"%>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil" %>

<%
	long paymentChannelId = ParamUtil.getLong(renderRequest, "paymentChannelId", 0);
	PaymentChannel paymentChannel = null;
	List<PaymentChannelTenor> paymentTenor = null;

	if (paymentChannelId > 0) {
		paymentChannel = PaymentChannelLocalServiceUtil.fetchPaymentChannel(paymentChannelId);
		paymentTenor = PaymentChannelTenorLocalServiceUtil.findBysearchByPaymentChannelId(paymentChannelId);
	}

	String imageSelectedItemEventName = (String) renderRequest.getAttribute("imageSelectedItemEventName");
	String itemSelectorURL = (String) renderRequest.getAttribute("itemSelectorURL");
	
	List<MasterBank> masterBanks = MasterBankLocalServiceUtil.getActiveBanks();
%>

<portlet:actionURL name="/masterdata/upload_image" var="uploadPaymentchannelImageURL" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "paymentchannel";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addPaymentchannelURL%>" name="paymentchannel">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=paymentChannelId > 0 ? "Edit Paymentchannel" : "Add New Paymentchannel"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= paymentChannelId != 0 && paymentChannel != null ? paymentChannel.getActive() == 1 ? true : false : true %>" name="active"
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
										<aui:input label="Code" name="code" type="text"
											required="true"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getCode())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Name" name="name" type="text"
											required="true"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getName())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="30">
										<div class="lfr-blogs-small-image-selector form-group input-text-wrapper">
											<label class="product-admin-editor__heading">Image</label>
											<%
												Long fileEntryId = paymentChannel == null ? 0 : Long.parseLong(String.valueOf(paymentChannel.getImageFileEntryId()));
											%>
											
											<portlet:actionURL name="/masterdata/upload_image" var="uploadBankImageURL" />
											
											<liferay-item-selector:image-selector
												fileEntryId="<%= fileEntryId %>"
												itemSelectorEventName="<%= imageSelectedItemEventName %>"
												itemSelectorURL="<%= itemSelectorURL %>"
												maxFileSize="5242880"
												paramName="image"
												uploadURL="<%= uploadBankImageURL %>"
												validExtensions="jpeg,.jpg,.png"
											/>
										</div>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Minimum Payment" name="minPayment" type="number"
											required="false"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getMinPayment())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Maximum Payment" name="maxPayment" type="number"
											required="false"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getMaxPayment())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
                                        <aui:select label="Bank Group" name="masterBankId" required="true" showEmptyOption="true">
                                            <%
                                            	if(! masterBanks.isEmpty()) {
                                            		for(MasterBank bank : masterBanks) {
                                            %>                                            
                                            <aui:option value="<%= bank.getMasterBankId() %>" selected="<%= paymentChannel != null && bank.getMasterBankId() == paymentChannel.getMasterBankId() %>"><%= bank.getName() %></aui:option>
                                            <%
                                            		}
                                            	}
                                            %>
                                        </aui:select>
                                    </aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="MDR AXA" name="mdrAxa" type="text"
											required="false"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getMdrAxa())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="MDR User" name="mdrUser" type="text"
											required="false"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getMdrUser())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<aui:input label="Pg Fee Pct" name="pgFeePct" type="text"
											required="false"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getPgFeePct())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Pg Fee Amt" name="pgFeeAmt" type="textv"
											required="false"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getPgFeeAmt())%>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<label class="product-admin-editor__heading">Description</label>
										<liferay-ui:input-editor cssClass="product-admin-editor"
												editorName="ckeditor"
												name="description" showSource="true"
												contents="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getDescription())%>" />
                                    </aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>
						
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<label>Tenor</label>
								<div id="data-tenor">
									<%
										if(paymentTenor != null) {
											for(PaymentChannelTenor pm : paymentTenor) {
									%>
									<div class="row">
										<div class="col">
											<aui:input label="Promoid" name="promoid[]" type="text"
												required="false"
												value="<%= String.valueOf(pm.getPromoid()) %>" />
										</div>
										<div class="col">
											<aui:input label="Tenor" name="tenor[]" type="text"
												required="false"
												value="<%= String.valueOf(pm.getTenor()) %>" />
										</div>
										<div class="col">
											<aui:input label="Tenor Id" name="tenorid[]" type="text"
												required="false"
												value="<%= String.valueOf(pm.getTenorid()) %>" />
										</div>
										<div class="col">
											<aui:input label="Acquirer" name="acquirer[]" type="text"
												required="false"
												value="<%= String.valueOf(pm.getAcquirer()) %>" />
										</div>
										<div class="col">
											<div class="form-group input-text-wrapper">										
												<label class="d-block">&nbsp</label>
												<aui:button cssClass="btn btn-danger btn-block remove-tenor" primary="false" name="addTenor" type="button" value="Remove Tenor" />
											</div>
										</div>
									</div>
									<%
											}
										}
									%>
								</div>
								<div id="tenor" class="row">
									<div class="col">
										<aui:input label="Promoid" name="promoid[]" type="text"
											required="false"
											value="" />
									</div>
									<div class="col">
										<aui:input label="Tenor" name="tenor[]" type="text"
											required="false"
											value="" />
									</div>
									<div class="col">
										<aui:input label="Tenor Id" name="tenorid[]" type="text"
											required="false"
											value="" />
									</div>
									<div class="col">
										<aui:input label="Acquirer" name="acquirer[]" type="text"
											required="false"
											value="" />
									</div>
									<div class="col">
										<div class="form-group input-text-wrapper">										
											<label class="d-block">&nbsp</label>
											<aui:button id="add-tenor" cssClass="btn-block" primary="true" name="addTenor" type="button" value="Add Tenor" />
										</div>
									</div>
								</div>
							</aui:fieldset>
						</aui:fieldset-group>
						
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input label="Utm Only" name="utmOnly" type="checkbox"
											required="false"
											value="1" checked="<%= paymentChannelId != 0 && paymentChannel != null ? paymentChannel.getUtmOnly() == 1 ? true : false : false %>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="MallId" name="mallId" type="text"
											required="false"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getMallId())%>" />
									</aui:col>
									
									<aui:col width="50">
										<aui:input label="Shared Key" name="sharedKey" type="text"
											required="false"
											value="<%=paymentChannel == null ? "" : String.valueOf(paymentChannel.getSharedKey())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (paymentChannel != null) {
						%>
						<aui:input type="hidden" name="paymentChannelId"
							value="<%=String.valueOf(paymentChannel.getPaymentChannelId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=paymentchannelURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

<aui:script use="aui-base">
	var addTenor = document.getElementById("<portlet:namespace />add-tenor");
	var removeBtn = document.querySelectorAll(".remove-tenor");
	addTenor.onclick = function() {
		var tenorData = document.getElementById("data-tenor");
		var tenor = document.getElementById("tenor").cloneNode(true);
		tenor.id = "";
		tenor.getElementsByTagName("button")[0].id = "";
		tenor.getElementsByTagName("button")[0].className = "btn btn-danger btn-block remove-tenor";
		tenor.getElementsByTagName("button")[0].textContent = "Remove Tenor";
		
		// remove action
		tenor.getElementsByTagName("button")[0].onclick = function(e) {
			e.target.parentElement.parentElement.parentElement.remove();
		}
		
		// append tenor
		tenorData.appendChild(tenor);
		
		// reset input
		document.getElementById("tenor").getElementsByTagName("input")[0].value = "";
		document.getElementById("tenor").getElementsByTagName("input")[1].value = "";
		document.getElementById("tenor").getElementsByTagName("input")[2].value = "";
		document.getElementById("tenor").getElementsByTagName("input")[3].value = "";
	}
	
	
	if(removeBtn.length) {
		removeBtn.forEach(function(e) {
			e.onclick = function(e) {			
				e.target.parentElement.parentElement.parentElement.parentElement.remove();
			}
		})
	}
</aui:script>