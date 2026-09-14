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
import com.liferay.portal.kernel.json.JSONArray;
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
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.agencyportal.constants.AgentAuthenticationPortletKeys;
import com.mypage.agencyportal.constants.AgentPagePortletKeys;
import com.mypage.agencyportal.dto.LocationDto;
import com.mypage.agencyportal.dto.ProfileAgentDto;
import com.mypage.agencyportal.dto.UserDetailAPIResponseDto;
import com.mypage.agencyportal.dto.WorkingHourDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.portlet.PortofolioDetailPortlet;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.agencyportal.upload.ImageUploadFileEntryHandler;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.UserOneTimeCode;
import com.mypage.user.model.MypageUserWorkingHour;
import com.mypage.user.service.MypageUserLocalService;
import com.mypage.user.service.MypageUserLocalServiceUtil;
import com.mypage.user.service.UserOneTimeCodeLocalServiceUtil;
import com.mypage.user.service.MypageUserWorkingHourLocalService;

import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
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

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AgentPagePortletKeys.AGENT_PAGE,
		"mvc.command.name=/data/agentpage"
	},
	service = MVCResourceCommand.class
)
public class AgentEditProfileMVCResourceCommand extends BaseMVCResourceCommand {
	private static String deptoreCode = StringPool.BLANK;
	private static String apiRequestTokenRenew = StringPool.BLANK;
	private static String PIMCORE_HOST = StringPool.BLANK;
	private static String dashboardApiUpdateProfileUrl = StringPool.BLANK;
	private static String dashboardApiChangePasswordUrl = StringPool.BLANK;
	private static String userProfilePayload = StringPool.BLANK;
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _logs = LogFactoryUtil.getLog(AgentEditProfileMVCResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		JSONObject userDetailResponse = JSONFactoryUtil.createJSONObject();
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		Gson gson = new Gson();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AgentEditProfileMVCResourceCommand.class.getName(),
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
		String dataCategory = Validator.isNull(ParamUtil.getString(httpRequest, "dataCategory")) == true ?
				ParamUtil.getString(uploadPortletRequest, "dataCategory") : ParamUtil.getString(httpRequest, "dataCategory");
				
		PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
		dashboardApiUpdateProfileUrl = helpers.getConfig("dashboard.api.agency.update.profile");
		dashboardApiChangePasswordUrl = helpers.getConfig("dashboard.api.agency.change.password");
		
		String _eToken = Validator.isNull(ParamUtil.getString(httpRequest, "etoken")) == true
				? ParamUtil.getString(uploadPortletRequest, "etoken")
				: ParamUtil.getString(httpRequest, "etoken");

		if (dataCategory.equalsIgnoreCase("profile")) {
			MypageUser user = _mypageUserLocalService.getMypageUser(userId);

			LocationDto location = new LocationDto();
			location.setLatitude(user.getLatitude());
			location.setLongitude(user.getLongitude());

			List<MypageUserWorkingHour> dataWorkingHours = _mypageUserWorkingHourLocalService
					.getByMypageUserId(user.getMypageUserId());
			List<WorkingHourDto> workingHours = new ArrayList<WorkingHourDto>();

			for (MypageUserWorkingHour _item : dataWorkingHours) {
				WorkingHourDto workingHour = new WorkingHourDto();

				workingHour.setDay(_item.getDay());
				workingHour.setStartTime(_item.getStartTime());
				workingHour.setEndTime(_item.getEndTime());

				workingHours.add(workingHour);
			}

			ProfileAgentDto data = new ProfileAgentDto();
			data.setAgentLocation(location);
			data.setAgentProfileImage(user.getProfileImageURL());
			data.setAgentIs24Hours(user.getIs24Hours());
			data.setAgentWorkingHour(workingHours);

			_response.put("status", true);
			_response.put("message", "");
			_response.put("data", gson.fromJson(gson.toJson(data), Object.class));
			_response.put("token", apiRequestTokenRenew);
		}

		if (dataCategory.equalsIgnoreCase("basicInfo")) {
			try {
				MypageUser user = _mypageUserLocalService.getMypageUser(userId);
				String prettyUrl = helpers.sanitizeHtml(ParamUtil.getString(uploadPortletRequest, "prettyUrl"));
				String numberHp = ParamUtil.getString(uploadPortletRequest, "numberHp");
				String numberTlp = ParamUtil.getString(uploadPortletRequest, "numberTlp");
				String dasarPerhitungan = ParamUtil.getString(uploadPortletRequest, "dasarPerhitungan");

				// upload banner image
				String bannerPath = StringPool.BLANK;
				String bannerBase64 = StringPool.BLANK;
				String bannerContentType = StringPool.BLANK;
				long bannerFileEntryId = 0;
				
				if (Validator.isNotNull(uploadPortletRequest.getFileName("banner"))) {
					byte[] data = FileUtil.getBytes(uploadPortletRequest.getFile("banner"));
					bannerBase64 = Base64.getEncoder().encodeToString(data);
					bannerContentType = uploadPortletRequest.getContentType("banner");
					
					File bannerFile = uploadPortletRequest.getFile("banner");
					String imageFileName = uploadPortletRequest.getFileName("banner");

					if (Validator.isNotNull(imageFileName)) {
						String imageFileContentType = uploadPortletRequest.getContentType("banner");
						
						// validate file
						_validateFile(imageFileName, imageFileContentType, uploadPortletRequest.getSize("banner"));
						
						// get user folder
						DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Image Profile");
						if (userFolder == null) {
							userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
									themeDisplay.getScopeGroupId(), false, 0, "Image Profile", "", false, serviceContext);
						}
						
						_setGuestPermission(themeDisplay, DLFolder.class.getName(), userFolder.getPrimaryKey());
						
						long folderId = userFolder.getFolderId();
						
						// set filename
						String uniqueFileName = _uniqueFileNameProvider.provide(
								imageFileName, curFileName -> _exists(themeDisplay, folderId, curFileName));
						
						// add file
						FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
				                repositoryId, folderId, uniqueFileName, 
				                imageFileContentType, uniqueFileName, "", "", 
				                bannerFile, serviceContext
				        );
						
						_setGuestPermission(themeDisplay, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());
						
						bannerFileEntryId = fileEntry.getFileEntryId();
						fileEntry = DLAppLocalServiceUtil.getFileEntry(bannerFileEntryId);
						bannerPath = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getFileName();
					}
				}
				
				// upload profile image
				String profilePath = StringPool.BLANK;
				String profileBase64 = StringPool.BLANK;
				String profileContentType = StringPool.BLANK;
				long profileFileEntryId = 0;
				
				if (Validator.isNotNull(uploadPortletRequest.getFileName("profile"))) {
					byte[] data = FileUtil.getBytes(uploadPortletRequest.getFile("profile"));
					profileBase64 = Base64.getEncoder().encodeToString(data);
					profileContentType = uploadPortletRequest.getContentType("profile");
					
					File bannerFile = uploadPortletRequest.getFile("profile");
					String imageFileName = uploadPortletRequest.getFileName("profile");

					if (Validator.isNotNull(imageFileName)) {
						String imageFileContentType = uploadPortletRequest.getContentType("profile");
						
						// validate file
						_validateFile(imageFileName, imageFileContentType, uploadPortletRequest.getSize("profile"));
						
						// get user folder
						DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Image Profile");
						if (userFolder == null) {
							userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
									themeDisplay.getScopeGroupId(), false, 0, "Image Profile", "", false, serviceContext);
						}
						
						_setGuestPermission(themeDisplay, DLFolder.class.getName(), userFolder.getPrimaryKey());
						
						long folderId = userFolder.getFolderId();
						
						// set filename
						String uniqueFileName = _uniqueFileNameProvider.provide(
								imageFileName, curFileName -> _exists(themeDisplay, folderId, curFileName));
						
						// add file
						FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
				                repositoryId, folderId, uniqueFileName, 
				                imageFileContentType, uniqueFileName, "", "", 
				                bannerFile, serviceContext
				        );
						
						_setGuestPermission(themeDisplay, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());
						
						profileFileEntryId = fileEntry.getFileEntryId();
						fileEntry = DLAppLocalServiceUtil.getFileEntry(profileFileEntryId);
						profilePath = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getFileName();
					}
				}
				
				// upload banner image
//				String bannerPath = StringPool.BLANK;
//				long bannerFileEntryId = 0;
//				
//				if (Validator.isNotNull(uploadPortletRequest.getFileName("banner"))) {
//					ImageUploadFileEntryHandler uploadBanner = new ImageUploadFileEntryHandler("banner", "Profile");
//					FileEntry bannerFileEntry = uploadBanner.upload(uploadPortletRequest);
//					bannerFileEntryId = bannerFileEntry.getFileEntryId();
//					bannerFileEntry = DLAppLocalServiceUtil.getFileEntry(bannerFileEntryId);
//					bannerPath = "/documents/" + bannerFileEntry.getGroupId() + "/" + bannerFileEntry.getFolderId() + "/" + bannerFileEntry.getFileName();
//				}
				
				// upload profile image
//				String profilePath = StringPool.BLANK;
//				long profileFileEntryId = 0;
//				
//				if (Validator.isNotNull(uploadPortletRequest.getFileName("profile"))) {
//					ImageUploadFileEntryHandler uploadProfile = new ImageUploadFileEntryHandler("profile", "Profile");
//					FileEntry profileFileEntry = uploadProfile.upload(uploadPortletRequest);
//					profileFileEntryId = profileFileEntry.getFileEntryId();
//					profileFileEntry = DLAppLocalServiceUtil.getFileEntry(profileFileEntryId);
//					profilePath = "/documents/" + profileFileEntry.getGroupId() + "/" + profileFileEntry.getFolderId() + "/" + profileFileEntry.getFileName();
//				}

				if (user.getPrettyUrlChange() < 2) user.setPrettyUrl(prettyUrl);
				user.setMobilePhone(numberHp.replaceAll("\\s", ""));
				user.setPhone(numberTlp);
				
				if (Validator.isNotNull(profilePath)) {
					user.setProfileImageURL(profilePath);
					user.setProfileImageFileEntryId(profileFileEntryId);
				}
				
				if (Validator.isNotNull(bannerPath)) {
					user.setBannerImageURL(bannerPath);
					user.setBannerImageFileEntryId(bannerFileEntryId);
				}
				
				user.setPaymentMethod(dasarPerhitungan);
				
				HashMap<String, Object> _userProfilePayload = new HashMap<String, Object>();
				_userProfilePayload.put("Code", deptoreCode);
				if (user.getPrettyUrlChange() < 2) _userProfilePayload.put("PrettyUrl", prettyUrl);
				_userProfilePayload.put("MobilePhone", numberHp.replaceAll("\\s", ""));
				if (Validator.isNotNull(bannerBase64)) _userProfilePayload.put("BannerImage", "data:".concat(bannerContentType).concat(";base64,").concat(bannerBase64));
				if (Validator.isNotNull(profileBase64)) _userProfilePayload.put("ProfileImage", "data:".concat(profileContentType).concat(";base64,").concat(profileBase64));
				_userProfilePayload.put("PaymentMethod", dasarPerhitungan.toLowerCase());
				userProfilePayload = gson.toJson(_userProfilePayload);
				
				userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiUpdateProfileUrl, userProfilePayload, _eToken);
				
				JSONObject userDetailAPIResponseDto = JSONFactoryUtil.createJSONObject(userDetailResponse.get("response").toString());
				
				if (userDetailAPIResponseDto.getInt("Status") == 0) {
					if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getString("Message"));
					_response.put("status", false);
					_response.put("message", AgentPagePortletKeys.MSG_FAILED_BASIC_INFO);
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}

				_mypageUserLocalService.updateMypageUser(user);

				_response.put("status", true);
				_response.put("message", AgentPagePortletKeys.MSG_SUCCESS);
				_response.put("token", apiRequestTokenRenew);
			} catch (Exception e) {
				_response.put("status", false);
				_response.put("message", AgentPagePortletKeys.MSG_FAILED_BASIC_INFO);
				_response.put("token", apiRequestTokenRenew);
				if (helpers.isLog()) _log.info(e.getStackTrace());
			}

		}

		if (dataCategory.equalsIgnoreCase("location")) {
			String jsonStringify = ParamUtil.getString(httpRequest, "data");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStringify);
			String address = helpers.sanitizeHtml(jsonObject.getString("address"));
			String latitude = jsonObject.getString("latitude");
			String longitude = jsonObject.getString("longitude");

			MypageUser user = _mypageUserLocalService.getMypageUser(userId);
			user.setAddress(address);
			user.setLatitude(latitude);
			user.setLongitude(longitude);
			
			HashMap<String, Object> _userProfilePayload = new HashMap<String, Object>();
			_userProfilePayload.put("Code", deptoreCode);
			_userProfilePayload.put("Address", address);
			_userProfilePayload.put("Latitude", latitude);
			_userProfilePayload.put("Longitude", longitude);
			userProfilePayload = gson.toJson(_userProfilePayload);
			
			userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiUpdateProfileUrl, userProfilePayload, _eToken);
			
			JSONObject userDetailAPIResponseDto = JSONFactoryUtil.createJSONObject(userDetailResponse.get("response").toString());
			
			if (userDetailAPIResponseDto.getInt("Status") == 0) {
				if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getString("Message"));
				_response.put("status", false);
				_response.put("message", AgentPagePortletKeys.MSG_FAILED_BASIC_INFO);
				_response.put("token", apiRequestTokenRenew);
				
				resourceResponse.getWriter().write(_response.toString());
				return;
			}

			_mypageUserLocalService.updateMypageUser(user);

			_response.put("status", true);
			_response.put("message", AgentPagePortletKeys.MSG_SUCCESS);
			_response.put("token", apiRequestTokenRenew);
		}

		if (dataCategory.equalsIgnoreCase("socmed")) {
			String jsonStringify = ParamUtil.getString(httpRequest, "data");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStringify);
			String facebook = helpers.sanitizeHtml(jsonObject.getString("facebook"));
			String twitter = helpers.sanitizeHtml(jsonObject.getString("twitter"));
			String instagram = helpers.sanitizeHtml(jsonObject.getString("instagram"));
			String tiktok = helpers.sanitizeHtml(jsonObject.getString("tiktok"));
			String linkedIn = helpers.sanitizeHtml(jsonObject.getString("linkedin"));
			String blog = helpers.sanitizeHtml(jsonObject.getString("blog"));

			MypageUser user = _mypageUserLocalService.getMypageUser(userId);
			user.setFacebook(facebook);
			user.setTwitter(twitter);
			user.setInstagram(instagram);
			user.setTiktok(tiktok);
			user.setLinkedIn(linkedIn);
			user.setBlog(blog);
			
			HashMap<String, Object> _userProfilePayload = new HashMap<String, Object>();
			_userProfilePayload.put("Code", deptoreCode);
			_userProfilePayload.put("Facebook", facebook);
			_userProfilePayload.put("Twitter", twitter);
			_userProfilePayload.put("LinkedIn", linkedIn);
			_userProfilePayload.put("Blog", blog);
			userProfilePayload = gson.toJson(_userProfilePayload);
			
			userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiUpdateProfileUrl, userProfilePayload, _eToken);
			
			JSONObject userDetailAPIResponseDto = JSONFactoryUtil.createJSONObject(userDetailResponse.get("response").toString());
			
			if (userDetailAPIResponseDto.getInt("Status") == 0) {
				if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getString("Message"));
				_response.put("status", false);
				_response.put("message", AgentPagePortletKeys.MSG_FAILED_BASIC_INFO);
				_response.put("token", apiRequestTokenRenew);
				
				resourceResponse.getWriter().write(_response.toString());
				return;
			}

			_mypageUserLocalService.updateMypageUser(user);

			_response.put("status", true);
			_response.put("message", AgentPagePortletKeys.MSG_SUCCESS);
			_response.put("token", apiRequestTokenRenew);
		}

		if (dataCategory.equalsIgnoreCase("workingHour")) {
			String jsonStringify = ParamUtil.getString(httpRequest, "data");
			JSONArray dataArray = JSONFactoryUtil.createJSONArray();
			JSONObject data = JSONFactoryUtil.createJSONObject(jsonStringify);
			boolean is24Hours = data.getBoolean("is24Hours");
			JSONObject hourList = JSONFactoryUtil
					.createJSONObject(data.getString("hourList") != null ? data.getString("hourList") : null);

			MypageUser user = _mypageUserLocalService.getMypageUser(userId);

			if (is24Hours) {
				// set is24Hours true
				user.setIs24Hours(1);
				
				JSONObject dataWorkingHours = JSONFactoryUtil.createJSONObject();
				dataWorkingHours.put("Day", "");
				dataWorkingHours.put("StartTime", "");
				dataWorkingHours.put("FinishTime", "");
				dataWorkingHours.put("Status", 0);
				
				dataArray.put(dataWorkingHours);
				
				JSONObject _userProfilePayload = JSONFactoryUtil.createJSONObject();
				_userProfilePayload.put("Code", deptoreCode);
				_userProfilePayload.put("is24Hours", true);
				_userProfilePayload.put("WorkingHours", dataArray);
				
				userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiUpdateProfileUrl, _userProfilePayload.toString(), _eToken);
				
				JSONObject userDetailAPIResponseDto = JSONFactoryUtil.createJSONObject(userDetailResponse.get("response").toString());
				
				if (userDetailAPIResponseDto.getInt("Status") == 0) {
					if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getString("Message"));
					_response.put("status", false);
					_response.put("message", AgentPagePortletKeys.MSG_FAILED_BASIC_INFO);
					_response.put("token", apiRequestTokenRenew);
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				// update mypageuser is24Hours
				_mypageUserLocalService.updateMypageUser(user);

				// delete working hour by mypageuserid
				_mypageUserWorkingHourLocalService.removeByMypageUserId(user.getMypageUserId());

			} else {

				// set is24Hours false
				user.setIs24Hours(0);
				// update mypageuser is24Hours
				_mypageUserLocalService.updateMypageUser(user);

				// delete working hour by mypageuserid
				_mypageUserWorkingHourLocalService.removeByMypageUserId(user.getMypageUserId());

				String[] ORDERED_DAYS = { "senin", "selasa", "rabu", "kamis", "jumat", "sabtu", "minggu" };

				for (String day : ORDERED_DAYS) {
					if (hourList.has(day)) {
						String startTime = hourList.getJSONObject(day).getString("startTime");
						String endTime = hourList.getJSONObject(day).getString("endTime");

						// add
						_mypageUserWorkingHourLocalService.addWorkingHour(user.getMypageUserId(), day, startTime,
								endTime, 1);

						JSONObject dataWorkingHours = JSONFactoryUtil.createJSONObject();
						dataWorkingHours.put("Day", helpers.getDayLong(day));
						dataWorkingHours.put("StartTime", startTime);
						dataWorkingHours.put("FinishTime", endTime);
						dataWorkingHours.put("Status", 1);
						
						dataArray.put(dataWorkingHours);
					}
				}
				
				JSONObject _userProfilePayload = JSONFactoryUtil.createJSONObject();
				_userProfilePayload.put("Code", deptoreCode);
				_userProfilePayload.put("is24Hours", false);
				_userProfilePayload.put("WorkingHours", dataArray);
				
				ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiUpdateProfileUrl, _userProfilePayload.toString(), _eToken);
			}

			_response.put("status", true);
			_response.put("message", AgentPagePortletKeys.MSG_SUCCESS);
			_response.put("token", apiRequestTokenRenew);
		}

		if (dataCategory.equalsIgnoreCase("changePassword")) {
			String jsonStringify = ParamUtil.getString(httpRequest, "data");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonStringify);

//			String username = jsonObject.getString("username");
//			MypageUser user = MypageUserLocalServiceUtil.getUserByEmail(username);
			String currPassword = jsonObject.getString("currPassword");
			String newPassword = jsonObject.getString("newPassword");
			String confirmNewPassword = jsonObject.getString("confirmNewPassword");
//			byte[] encryptedOldBytes = Base64.getDecoder().decode(jsonObject.getString("oldPassword"));
//			String oldPassword = new String(encryptedOldBytes);
//			String encryptedOldPassword = EncryptionHelper.encryptPassword(oldPassword);
//			byte[] encryptedNewBytes = Base64.getDecoder().decode(jsonObject.getString("newPassword"));
//			String newPassword = new String(encryptedNewBytes);
//			String encryptedNewPassword = EncryptionHelper.encryptPassword(newPassword);
//			String sharedSecret = jsonObject.getString("verification");
//			userId = user.getMypageUserId();

//			UserOneTimeCode userOneTimeCode = UserOneTimeCodeLocalServiceUtil.getUserOTP(userId, sharedSecret);
//
//			if (Validator.isNull(userOneTimeCode)) {
//				_response.put("status", false);
//				_response.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
//
//				resourceResponse.getWriter().write(_response.toString());
//				return;
//			}

//			long currentTime = System.currentTimeMillis() / 1000;
//			long expireTime = userOneTimeCode.getTimestampExpiryDate();
//			boolean isUsed = (userOneTimeCode.getIsUsed() > 0);
//
//			if ((currentTime > expireTime) && isUsed == false) {
//				UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, sharedSecret);
//
//				_response.put("status", false);
//				_response.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
//
//				resourceResponse.getWriter().write(_response.toString());
//				return;
//			}
//
//			if (isUsed == true) {
//				_response.put("status", false);
//				_response.put("message", AgentAuthenticationPortletKeys.MSG_OTP_INVALID);
//
//				resourceResponse.getWriter().write(_response.toString());
//				return;
//			}
//
//			UserOneTimeCodeLocalServiceUtil.updateUserOTP(userId, sharedSecret);
//
//			boolean isAuthenticated = (MypageUserLocalServiceUtil.authenticateForBasic(username, encryptedOldPassword) > 0);
//			boolean isSamePassword = (MypageUserLocalServiceUtil.authenticateForBasic(username, encryptedNewPassword) > 0);
//
//			if (isAuthenticated == false) {
//				_response.put("status", false);
//				_response.put("message", AgentPagePortletKeys.MSG_FAILED_CHANGE);
//				
//				resourceResponse.getWriter().write(_response.toString());
//				return;
//			}
//			
//			if (isSamePassword == false) {
//				MypageUser data = MypageUserLocalServiceUtil.fetchMypageUser(userId);
//				data.setUserPassword(encryptedNewPassword);
//				
//				MypageUserLocalServiceUtil.updateMypageUser(data);
//			}
			
			if (helpers.passwordValidation(newPassword, confirmNewPassword) == false) {
				_response.put("status", false);
				_response.put("message", AgentPagePortletKeys.MSG_FAILED_CHANGE);
				_response.put("token", apiRequestTokenRenew);
				
				resourceResponse.getWriter().write(_response.toString());
				return;
			}
			
			HashMap<String, Object> _userProfilePayload = new HashMap<String, Object>();
			_userProfilePayload.put("Code", deptoreCode);
			_userProfilePayload.put("CurrentPassword", currPassword);
			_userProfilePayload.put("NewPassword", newPassword);
			userProfilePayload = gson.toJson(_userProfilePayload);
			
			userDetailResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiChangePasswordUrl, userProfilePayload, _eToken);
			
			JSONObject userDetailAPIResponseDto = JSONFactoryUtil.createJSONObject(userDetailResponse.get("response").toString());
			
			if (userDetailAPIResponseDto.getInt("Status") == 0) {
				if (helpers.isLog()) _log.info(userDetailAPIResponseDto.getString("Message"));
				_response.put("status", false);
				_response.put("message", AgentPagePortletKeys.MSG_FAILED_CHANGE);
				_response.put("token", apiRequestTokenRenew);
				
				resourceResponse.getWriter().write(_response.toString());
				return;
			}

			_response.put("status", true);
			_response.put("message", AgentPagePortletKeys.MSG_SUCCESS);
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
			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, curFileName);

			if (tempFileEntry != null) {
				return true;
			}

			return false;
		}
		catch (PortalException portalException) {
			if (_log.isDebugEnabled()) {
				_log.debug(portalException, portalException);
			}

			return false;
		}
	}
	
	
	private void _validateFile(String fileName, String contentType, long size)
		throws PortalException {

		long blogsImageMaxSize = _IMAGE_MAX_SIZE;

		if ((blogsImageMaxSize > 0) && (size > blogsImageMaxSize)) {
			throw new EntryImageSizeException();
		}

		Set<String> extensions = MimeTypesUtil.getExtensions(contentType);

		boolean validContentType = Stream.of(
				_IMAGE_EXTENSIONS
		).anyMatch(
			extension ->
				extension.equals(StringPool.STAR) ||
				extensions.contains(extension)
		);

		if (!validContentType) {
			throw new EntryImageNameException(
				"Invalid image for file name " + fileName);
		}
	}

	private static final Object[] _IMAGE_EXTENSIONS = {".gif", ".jpeg", ".jpg", ".png"};
	
	private static final long _IMAGE_MAX_SIZE = 5242880;
	
	private static final Log _log = LogFactoryUtil.getLog(ImageUploadFileEntryHandler.class);
	
	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;

	@Reference
	private MypageUserLocalService _mypageUserLocalService;

	@Reference
	private MypageUserWorkingHourLocalService _mypageUserWorkingHourLocalService;
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
