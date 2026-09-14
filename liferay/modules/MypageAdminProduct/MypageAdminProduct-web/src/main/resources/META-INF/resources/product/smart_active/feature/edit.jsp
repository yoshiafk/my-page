<%@ include file="../includes/init.jsp"%>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory" %>
<%@ page import="com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/adaptive-media-image" prefix="liferay-adaptive-media" %>

<%
	long featureId = ParamUtil.getLong(renderRequest, "featureId", 0);
	SmartActiveFeature feature = null;
	
	if (featureId > 0) {
		feature = SmartActiveFeatureLocalServiceUtil.fetchSmartActiveFeature(featureId);
	}
%>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<div class="col-lg-3">
			<%
				// setting for menu
				String _active = "feature";
			%>
			<%@ include file="../includes/left-menu.jsp"%>
		</div>
		<div class="col-lg-9">
		<aui:form action="<%= addFeatureURL %>" name="feature">
			<div class="sheet sheet-full">

				<h2 class="sheet-title">
					<div class="row">
						<div class="col-lg-8">
							<div class="d-flex">
								<aui:icon cssClass="" image="globe" markupView="lexicon" />
								<span class="pl-2 text-truncate"><%= featureId > 0 ? "Edit Feature" : "Add New Feature" %></span>
							</div>
						</div>
						<div class="col-lg-4">
							<aui:input checked="<%= featureId != 0 && feature != null ? feature.getActive() == 1 ? true : false : true %>" name="active"
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
										<aui:input label="Title" name="title" type="text"
											required="true"
											value="<%= feature == null ? "" : String.valueOf(feature.getTitle()) %>" />
									</aui:col>
									
									<aui:col width="100">
										<aui:input label="Sort" name="sort"
											type="number" required="false"
											value="<%= feature == null ? "" : String.valueOf(feature.getSort()) %>" />
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="100">
										<div class="alloy-editor-container">
											<liferay-editor:editor cssClass="mypage-editor" editorName="ckeditor" name="description" placeholder="Description" showSource="true" contents="<%= feature == null ? "" : String.valueOf(feature.getDescription()) %>" />
										</div>
									</aui:col>
								</aui:row>
								
								<aui:row>
									<aui:col width="50">
										<label class="control-label">Image</label>
										
										<div class="upload-image-wrapper mb-4">
											<div class="iconPreview">
												<%
													Long fileEntryId = feature == null ? 0 : Long.parseLong(String.valueOf(feature.getFileUploadEntryId()));
													FileEntry file = null;
												%>
												<c:if test="<%= fileEntryId > 0  %>">
													<%
														file = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
														String fileUrl = "/documents/" + file.getGroupId() + "/" + file.getFolderId() + "/" + file.getFileName(); 
													%>
													<liferay-adaptive-media:img class="img-fluid mb-4" fileVersion="<%= file.getFileVersion() %>" />
												</c:if>
											</div>
											<div class="custom-file custom-file-grey">
												<input name="<portlet:namespace/>imageFile" type="file" class="custom-file-input semi-bold selectUploadImg">
												<label class="custom-file-label" for="customFile"><%= fileEntryId > 0 ? file.getFileName() : "" %></label>
											</div>
										</div>
									</aui:col>
								</aui:row>
							</aui:fieldset>
						</aui:fieldset-group>

						<%
							if (feature != null) {
						%>
						<aui:input type="hidden" name="featureId"
							value="<%= String.valueOf(feature.getSmartActiveFeatureId()) %>" />
						<%
							}
						%>

						<aui:button-row>
							<aui:button name="submitButton" type="submit" value="Save" />
							<aui:button type="cancel" onClick="<%= featureURL.toString() %>"></aui:button>
						</aui:button-row>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

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
</aui:script>