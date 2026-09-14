<%@ include file="../variables.jsp"%>
<%@ taglib uri="http://liferay.com/tld/adaptive-media-image" prefix="liferay-adaptive-media" %>

<portlet:actionURL name="/masterdata/upload_image" var="uploadBankImageURL" />

<h3 class="sheet-subtitle">Images</h3>

<aui:row>
	<aui:col width="30">
		<label class="control-label">Profile Image</label>
		
		<div class="upload-image-wrapper mb-4">
			<div class="profilePreview">
				<%
					Long fileEntryId = mypageUser == null ? 0 : mypageUser.getProfileImageFileEntryId();
					FileEntry profilePic = null;
				%>
				<c:if test="<%= fileEntryId > 0  %>">
					<%
						profilePic = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
						String profileUrl = "/documents/" + profilePic.getGroupId() + "/" + profilePic.getFolderId() + "/"
								+ profilePic.getFileName();
					%>
					<liferay-adaptive-media:img class="img-fluid mb-4" fileVersion="<%= profilePic.getFileVersion() %>" />
				</c:if>
			</div>
			<div class="custom-file custom-file-grey">
				<input name="profileImage" type="file" class="custom-file-input semi-bold selectUploadImg">
				<label class="custom-file-label" for="customFile"><%= fileEntryId > 0 ? profilePic.getFileName() : ""  %></label>
			</div>
		</div>
	</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<label class="control-label">Banner Image</label>
		
		<div class="upload-image-wrapper">
			<div class="profilePreview">
				<%
					Long bannerFileEntryId = mypageUser == null ? 0 : mypageUser.getBannerImageFileEntryId();
					FileEntry bannerPic = null;
				%>
				<c:if test="<%= bannerFileEntryId > 0  %>">
					<%
						bannerPic = DLAppLocalServiceUtil.getFileEntry(bannerFileEntryId);
						String profileUrl = "/documents/" + bannerPic.getGroupId() + "/" + bannerPic.getFolderId() + "/"
								+ bannerPic.getFileName();
					%>
					<liferay-adaptive-media:img class="img-fluid mb-4" fileVersion="<%= bannerPic.getFileVersion() %>" />
				</c:if>
			</div>
			<div class="custom-file custom-file-grey">
				<input name="bannerImage" type="file" class="custom-file-input semi-bold selectUploadImg">
				<label class="custom-file-label" for="customFile"><%= bannerFileEntryId > 0 ? bannerPic.getFileName() : ""  %></label>
			</div>
		</div>
	</aui:col>
</aui:row>

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