<%@ include file="../includes/init.jsp"%>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil" %>

<%
	long masterBankId = ParamUtil.getLong(renderRequest, "masterBankId", 0);
	MasterBank masterBank = null;

	if (masterBankId > 0) {
		masterBank = MasterBankLocalServiceUtil.fetchMasterBank(masterBankId);
	}
	
	String imageSelectedItemEventName = (String) renderRequest.getAttribute("imageSelectedItemEventName");
	String itemSelectorURL = (String) renderRequest.getAttribute("itemSelectorURL");
%>

<portlet:actionURL name="/masterdata/upload_image" var="uploadBankImageURL" />

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "bank";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%=addBankURL%>" name="provinnce">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%=masterBankId > 0 ? "Edit Bank" : "Add New Bank"%></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= masterBankId != 0 && masterBank != null ? masterBank.getActive() == 1 ? true : false : true %>" name="active"
								type="toggle-switch" value="1" label="Active"
								wrapperCssClass="leftToggleTitle" />
						</div>
					</div>
				</h2>

				<div class="sheet-section">
						<aui:fieldset-group markupView="lexicon">
							<aui:fieldset cssClass="pt-4 pl-4">
								<aui:row>
									<aui:col width="100">
										<aui:input label="Bank Code" name="bankCode" type="text"
											required="true"
											value="<%=masterBank == null ? "" : String.valueOf(masterBank.getBankCode())%>" />
									</aui:col>
									
									<aui:col width="100">
										<label class="product-admin-editor__heading">Description</label>
										<liferay-ui:input-editor cssClass="product-admin-editor"
												editorName="ckeditor"
												name="bankDesc" showSource="true"
												contents="<%=masterBank == null ? "" : String.valueOf(masterBank.getBankDesc())%>" />
                                    </aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<aui:input label="Bank Name" name="name" type="text"
											required="true"
											value="<%=masterBank == null ? "" : String.valueOf(masterBank.getName())%>" />
									</aui:col>
									
									<aui:col width="100">
										<label class="product-admin-editor__heading">Bank Detail</label>
										<liferay-ui:input-editor cssClass="product-admin-editor"
												editorName="ckeditor"
												name="detail" showSource="true"
												contents="<%=masterBank == null ? "" : String.valueOf(masterBank.getDetail())%>" />
                                    </aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="30">
										<div class="lfr-blogs-small-image-selector">
											<label class="product-admin-editor__heading">Image</label>
											<%
												Long fileEntryId = masterBank == null ? 0 : Long.parseLong(String.valueOf(masterBank.getImageFileEntryId()));
											%>
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
									
									<aui:col width="100">
										<aui:input label="Order" name="order" type="number"
											value="<%=masterBank == null ? "" : String.valueOf(masterBank.getOrder())%>" />
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (masterBank != null) {
						%>
						<aui:input type="hidden" name="masterBankId"
							value="<%=String.valueOf(masterBank.getMasterBankId())%>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%=bankURL.toString()%>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
