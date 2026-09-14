package com.mypage.agencyportal.portlet.action;

import com.google.gson.Gson;
import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.agencyportal.constants.AgentDashboardPortletKeys;
import com.mypage.agencyportal.constants.AgentPagePortletKeys;
import com.mypage.agencyportal.dto.AgentDashboardDto;
import com.mypage.agencyportal.dto.LocationDto;
import com.mypage.agencyportal.dto.TimelineDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserTimeline;
import com.mypage.user.service.MypageUserLocalService;
import com.mypage.user.service.MypageUserTimelineLocalService;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, 
			property = { 
					"javax.portlet.name=" + AgentPagePortletKeys.AGENT_PAGE,
					"mvc.command.name=/data/agentprofile" 
			}, service = MVCResourceCommand.class)
public class AgentProfileMVCResourceCommand extends BaseMVCResourceCommand {
	private static String deptoreCode = StringPool.BLANK;
	private static String apiRequestTokenRenew = StringPool.BLANK;
	private static ActionHelpers helpers = new ActionHelpers();

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		JSONObject _response = JSONFactoryUtil.createJSONObject();
		Gson gson = new Gson();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentProfileMVCResourceCommand.class.getName(),
				resourceRequest);

		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		/* Validate API Request Token */
		boolean validateApiRequestToken = false;
		String renderToken = Validator.isNull(ParamUtil.getString(httpRequest, "rtoken")) == true
				? ParamUtil.getString(uploadPortletRequest, "rtoken")
				: ParamUtil.getString(httpRequest, "rtoken");
		String _apiRequestToken = Validator.isNull(ParamUtil.getString(httpRequest, "aptoken")) == true
				? ParamUtil.getString(uploadPortletRequest, "aptoken")
				: ParamUtil.getString(httpRequest, "aptoken");

		AgentToken verifyAgentToken = _agentTokenLocalService.verifyToken(renderToken, _apiRequestToken);

		if (!Validator.isNull(verifyAgentToken)) {

			AgentToken renewAgentApiRequestToken = _agentTokenLocalService.renewAgentToken(verifyAgentToken.getAgentTokenId());

			if (!Validator.isNull(renewAgentApiRequestToken)) {
				apiRequestTokenRenew = renewAgentApiRequestToken.getApiRequestToken();
			}

			validateApiRequestToken = true;
			deptoreCode = verifyAgentToken.getDeptCode();
		}

		if (!validateApiRequestToken) {
			_response.put("status", false);
			_response.put("message", "Access Forbidden");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		/* END Validate API Request Token */

		/* Init Params Request */
		long userId = _mypageUserLocalService.getByDeptoreCode(deptoreCode).getMypageUserId();
		String dataCategory = Validator.isNull(ParamUtil.getString(httpRequest, "dataCategory")) == true
				? ParamUtil.getString(uploadPortletRequest, "dataCategory")
				: ParamUtil.getString(httpRequest, "dataCategory");

		if (dataCategory.equalsIgnoreCase("profile")) {
			List<MypageUserTimeline> datas = _mypageUserTimelineLocalService.getByMypageUserId(userId);
			List<TimelineDto> dataTimelines = new ArrayList<TimelineDto>();
			AgentDashboardDto dashboardDto = new AgentDashboardDto();

			MypageUser user = _mypageUserLocalService.getMypageUser(userId);

			LocationDto location = new LocationDto();
			location.setLatitude(user.getLatitude());
			location.setLongitude(user.getLongitude());

			for (MypageUserTimeline data : datas) {
				TimelineDto status = new TimelineDto();

				status.setUserName(data.getUserName());
				status.setTextStatus(data.getText());
				status.setCreateDate(data.getCreateDate());
				status.setTimelineId(data.getMypageUserTimelineId());

				status.setProfileFileEntryId(user.getProfileImageFileEntryId());
				status.setImgUrlAvatar(user.getProfileImageURL());

				status.setTimelineFileEntryId(data.getImgUploadTimelineEntryId());
				status.setImgUrlTimeline(data.getImgUploadTimelineUrl());

				status.setVideoUrl(data.getVideoUploadTimelineUrl());

				dataTimelines.add(status);
			}

			dashboardDto.setTimelineUser(dataTimelines);
			dashboardDto.setAgentLocation(location);

			_response.put("status", true);
			_response.put("message", "");
			_response.put("data", gson.fromJson(gson.toJson(dashboardDto), Object.class));
			_response.put("token", apiRequestTokenRenew);
		}

		if (dataCategory.equalsIgnoreCase("timeline")) {
			String status = helpers.sanitizeHtml(ParamUtil.getString(uploadPortletRequest, "status"));
			String linkVideo = ParamUtil.getString(uploadPortletRequest, "linkVideo");
		
			// upload profile image
			String filePath = StringPool.BLANK;
			long fileEntryId = 0;

			if (Validator.isNotNull(uploadPortletRequest.getFileName("file"))) {
				File file = uploadPortletRequest.getFile("file");
				String imageFileName = uploadPortletRequest.getFileName("file");

				if (Validator.isNotNull(imageFileName)) {
					String imageFileContentType = uploadPortletRequest.getContentType("file");

					// validate file
					_validateFile(imageFileName, imageFileContentType, uploadPortletRequest.getSize("file"));

					// get user folder
					DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0,
							"Image Timeline");
					if (userFolder == null) {
						userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(),
								themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, 0,
								"Image Timeline", "", false, serviceContext);
					}
					
					_setGuestPermission(themeDisplay, DLFolder.class.getName(), userFolder.getPrimaryKey());

					long folderId = userFolder.getFolderId();

					// set filename
					String uniqueFileName = _uniqueFileNameProvider.provide(imageFileName,
							curFileName -> _exists(themeDisplay, folderId, curFileName));

					// add file
					FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId,
							folderId, uniqueFileName, imageFileContentType, uniqueFileName, "", "", file,
							serviceContext);
					
					_setGuestPermission(themeDisplay, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());

					fileEntryId = fileEntry.getFileEntryId();
					fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
					filePath = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/"
							+ fileEntry.getFileName();
				}
			}

			MypageUser user = _mypageUserLocalService.getMypageUser(userId);

			_mypageUserTimelineLocalService.addTimeline(user.getMypageUserId(), status, fileEntryId, filePath, linkVideo);

			_response.put("status", true);
			_response.put("message", AgentDashboardPortletKeys.MSG_SUCCESS);
			_response.put("token", apiRequestTokenRenew);
		}

		if (dataCategory.equalsIgnoreCase("deleteTimeline")) {
			long timelineId = ParamUtil.getLong(httpRequest, "timelineId");
			_mypageUserTimelineLocalService.deleteMypageUserTimeline(timelineId);
			
			_response.put("token", apiRequestTokenRenew);
		}

		resourceResponse.getWriter().write(_response.toString());

	}
	
	private boolean _setGuestPermission(ThemeDisplay themeDisplay, String name, long primKey) {
		Map<Long, String[]> roleIdsToActionIds = new HashMap<>();
		roleIdsToActionIds.put(RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), RoleConstants.GUEST).getRoleId(), new String[]{ActionKeys.VIEW});
		
		try {
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
	                themeDisplay.getCompanyId(), name,
	                ResourceConstants.SCOPE_INDIVIDUAL,
	                String.valueOf(primKey),
	                roleIdsToActionIds);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean _exists(ThemeDisplay themeDisplay, long folderId, String curFileName) {
		try {
			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId,
					curFileName);

			if (tempFileEntry != null) {
				return true;
			}

			return false;
		} catch (PortalException portalException) {
			if (_log.isDebugEnabled()) {
				_log.debug(portalException, portalException);
			}

			return false;
		}
	}

	private void _validateFile(String fileName, String contentType, long size) throws PortalException {

		long blogsImageMaxSize = _IMAGE_MAX_SIZE;

		if ((blogsImageMaxSize > 0) && (size > blogsImageMaxSize)) {
			throw new EntryImageSizeException();
		}

		Set<String> extensions = MimeTypesUtil.getExtensions(contentType);

		boolean validContentType = Stream.of(_IMAGE_EXTENSIONS)
				.anyMatch(extension -> extension.equals(StringPool.STAR) || extensions.contains(extension));

		if (!validContentType) {
			throw new EntryImageNameException("Invalid image for file name " + fileName);
		}
	}

	private static final Object[] _IMAGE_EXTENSIONS = { ".gif", ".jpeg", ".png", ".jpg" };
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log _log = LogFactoryUtil.getLog(AgentProfileMVCResourceCommand.class);

	@Reference
	private MypageUserTimelineLocalService _mypageUserTimelineLocalService;

	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;

	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;

}
