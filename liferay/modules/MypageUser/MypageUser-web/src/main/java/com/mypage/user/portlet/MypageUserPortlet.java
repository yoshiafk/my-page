package com.mypage.user.portlet;

import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.service.ProductConfigurationLocalService;
import com.mypage.user.constants.MypageUserPortletKeys;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserLicenses;
import com.mypage.user.service.MypageUserGracePeriodLocalServiceUtil;
import com.mypage.user.service.MypageUserLicensesLocalService;
import com.mypage.user.service.MypageUserLicensesLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalService;
import com.mypage.user.service.MypageUserLocalServiceUtil;
import com.mypage.user.service.MypageUserTimelineLocalServiceUtil;
import com.mypage.user.service.MypageUserWorkingHourLocalServiceUtil;
import com.mypage.user.service.permission.MypageUserPermission;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.jumpmind.symmetric.csv.CsvReader;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author gositus
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MypageUser",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/user/view.jsp",
		"javax.portlet.name=" + MypageUserPortletKeys.MYPAGEUSER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class MypageUserPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();

		String liferayUserId = ParamUtil.getString(renderRequest, "liferayUserId", "");
		
		PortletURL selectRegularRoleURL = null;
		User selUser = null;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(MypageUser.class.getName(), renderRequest);
			long userId = serviceContext.getUserId();
			selUser = UserLocalServiceUtil.getUser(userId);
			selectRegularRoleURL = PortletProviderUtil.getPortletURL(renderRequest, Role.class.getName(), PortletProvider.Action.BROWSE);
			selectRegularRoleURL.setParameter("p_u_i_d", (selUser == null) ? "0" : String.valueOf(selUser.getUserId()));
			String regularRoleEventName = renderResponse.getNamespace() + "selectRegularRole";
			selectRegularRoleURL.setParameter("eventName", regularRoleEventName);
			selectRegularRoleURL.setWindowState(LiferayWindowState.POP_UP);
			
			renderRequest.setAttribute("selectRegularRoleURL", selectRegularRoleURL);
			
			// get current user
			User currentUser = PortalUtil.getUser(renderRequest);
			boolean hasAdministrator = UserLocalServiceUtil.hasRoleUser(companyId, "Administrator", userId, true);
			
			renderRequest.setAttribute("isAgent", false);
			renderRequest.setAttribute("isAdministrator", hasAdministrator);
			if(!hasAdministrator) {
				renderRequest.setAttribute("liferayUserId", currentUser.getUserId());
				renderRequest.setAttribute("isAgent", true);
			}
			
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		} catch (PortalException e) {
			e.printStackTrace();
		}		

		super.render(renderRequest, renderResponse);
	}
	
	private String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		String type = ParamUtil.getString(resourceRequest, "type");

		if (cmd.equals(Constants.EXPORT) || cmd.equals("exportAll")) {
			if (type.equals("user")) {
				exportUser(resourceRequest, resourceResponse);
			}
		}
		
		return;
	}
	
	public void addUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		long liferayUserId = ParamUtil.getLong(actionRequest, "liferayUserId", 0);
		long mypageUserId = ParamUtil.getLong(actionRequest, "mypageUserId", 0);
		String pageKey = ParamUtil.getString(actionRequest, "pageKey");
		
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(MypageUser.class.getName(), actionRequest);
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId = themeDisplay.getCompanyId();
			long userId = serviceContext.getUserId();
			long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			long groupId = serviceContext.getScopeGroupId();
			
			// PERMISSIONS
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
			boolean allowAdd = MypageUserPermission.contains(permissionChecker, groupId, "ADD_ENTRY");
			
			JSONObject data = JSONFactoryUtil.createJSONObject();
			data.put("liferayUserId", liferayUserId);
			data.put("mypageUserId", mypageUserId);
			data.put("companyId", companyId);
			data.put("userId", userId);
			data.put("pageKey", pageKey);

			// account
			data.put("userParent", ParamUtil.getLong(actionRequest, "userParent"));
			data.put("userBranch", ParamUtil.getLong(actionRequest, "userBranch"));
			data.put("password", ParamUtil.getString(actionRequest, "password"));
			data.put("status", ParamUtil.getString(actionRequest, "status"));
			data.put("creditStatus", ParamUtil.getString(actionRequest, "creditStatus"));
			data.put("creditWalletId", ParamUtil.getLong(actionRequest, "creditWalletId"));
			data.put("cashPayment", ParamUtil.getInteger(actionRequest, "cashPayment"));
			data.put("paymentMethod", ParamUtil.getString(actionRequest, "paymentMethod"));
					
			// basic information
			data.put("agentFlag", ParamUtil.getString(actionRequest, "agentFlag"));
			data.put("screenName", ParamUtil.getString(actionRequest, "screenName"));
			data.put("emailAddress", ParamUtil.getString(actionRequest, "emailAddress"));
			data.put("firstName", ParamUtil.getString(actionRequest, "firstName"));
			data.put("middleName", ParamUtil.getString(actionRequest, "middleName"));
			data.put("lastName", ParamUtil.getString(actionRequest, "lastName"));
			data.put("birthday", ParamUtil.getString(actionRequest, "birthday"));
			data.put("birthPlace", ParamUtil.getString(actionRequest, "birthPlace"));
			data.put("gender", ParamUtil.getString(actionRequest, "gender"));
			data.put("idNumber", ParamUtil.getString(actionRequest, "idNumber"));
			data.put("phone", ParamUtil.getString(actionRequest, "phone"));
			data.put("mobilePhone", ParamUtil.getString(actionRequest, "mobilePhone"));
			data.put("address", ParamUtil.getString(actionRequest, "address"));
			data.put("zip", ParamUtil.getString(actionRequest, "zip"));
			data.put("country", ParamUtil.getLong(actionRequest, "country"));
			data.put("province", ParamUtil.getLong(actionRequest, "province"));
			data.put("city", ParamUtil.getLong(actionRequest, "city"));
			data.put("latitude", ParamUtil.getString(actionRequest, "latitude"));
			data.put("longitude", ParamUtil.getString(actionRequest, "longitude"));
			data.put("positionZoom", ParamUtil.getInteger(actionRequest, "positionZoom"));
			
			// agent
			data.put("code", ParamUtil.getString(actionRequest, "code"));
			data.put("branch", ParamUtil.getLong(actionRequest, "branch"));
			data.put("promoCode", ParamUtil.getString(actionRequest, "promoCode"));
			data.put("agsPromoCode", ParamUtil.getString(actionRequest, "agsPromoCode"));
			data.put("deptoreCode", ParamUtil.getString(actionRequest, "deptoreCode"));
			data.put("leader", ParamUtil.getLong(actionRequest, "leader"));
			data.put("statusAgent", ParamUtil.getString(actionRequest, "statusAgent"));
			data.put("licenseNumber", ParamUtil.getString(actionRequest, "licenseNumber"));
			data.put("joinDate", ParamUtil.getString(actionRequest, "joinDate"));
			data.put("endDate", ParamUtil.getString(actionRequest, "endDate"));
			data.put("prettyUrl", ParamUtil.getString(actionRequest, "prettyUrl"));
			data.put("prettyUrlChange", ParamUtil.getInteger(actionRequest, "prettyUrlChange"));
			data.put("taxRate", ParamUtil.getDouble(actionRequest, "taxRate"));
			data.put("visitedCount", ParamUtil.getInteger(actionRequest, "visitedCount"));
			data.put("isPartnership", ParamUtil.getInteger(actionRequest, "isPartnership"));
			data.put("partnershipName", ParamUtil.getString(actionRequest, "partnershipName"));
			
			// about me
			data.put("myTitle", ParamUtil.getString(actionRequest, "myTitle"));
			data.put("myVideo", ParamUtil.getString(actionRequest, "myVideo"));
			data.put("aboutMe", ParamUtil.getString(actionRequest, "aboutMe"));
			
			// social media
			data.put("facebook", ParamUtil.getString(actionRequest, "facebook"));
			data.put("googlePlus", ParamUtil.getString(actionRequest, "googlePlus"));
			data.put("twitter", ParamUtil.getString(actionRequest, "twitter"));
			data.put("linkedIn", ParamUtil.getString(actionRequest, "linkedIn"));
			data.put("blog", ParamUtil.getString(actionRequest, "blog"));
			data.put("whatsapp", ParamUtil.getString(actionRequest, "whatsapp"));
			data.put("skype", ParamUtil.getString(actionRequest, "skype"));
			
			// roles
			data.put("addRoleIds", ParamUtil.getString(actionRequest, "addRoleIds"));
			data.put("deleteRoleIds", ParamUtil.getString(actionRequest, "deleteRoleIds"));
			
			
			// working hour
			String[] workingHourDay = ParamUtil.getParameterValues(actionRequest, "workingHourDay[]");
			String[] workingHourStartDate = ParamUtil.getParameterValues(actionRequest, "workingHourStartDate[]");
			String[] workingHourEndDate = ParamUtil.getParameterValues(actionRequest, "workingHourEndDate[]");
			String[] workingHourStatus = ParamUtil.getParameterValues(actionRequest, "workingHourStatus[]");
			
			// images
			File profilePicFile = uploadRequest.getFile("profileImage");
			File bannerPicFile = uploadRequest.getFile("bannerImage");
			
			// active
			data.put("active", ParamUtil.getLong(actionRequest, "active"));
			
			// upload images
			if(pageKey.equals("image")) {
				FileEntry profilePicEntry = null;
				if(profilePicFile != null) {
					String profilePicName = uploadRequest.getFileName("profileImage");
		
					if(profilePicName != null && profilePicName != "") {
						String profilePicContentType = uploadRequest.getContentType("profileImage");
						// validate file
						_validateFile(profilePicName, profilePicContentType, uploadRequest.getSize("profileImage"));
						// get mypage user folder
						DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "com.mypage.user");
						if (userFolder == null) {
							userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
									themeDisplay.getScopeGroupId(), false, 0, "com.mypage.user", "", true, serviceContext);
						}
						
						long folderId = userFolder.getFolderId();
						
						// set filename
						String uniqueFileName = _uniqueFileNameProvider.provide(
								profilePicName, curFileName -> _exists(themeDisplay, folderId, curFileName));
						// add file
						profilePicEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
				                repositoryId, userFolder.getFolderId(), uniqueFileName, 
				                profilePicContentType, uniqueFileName, "", "", 
				                profilePicFile, serviceContext
				        );
						
						data.put("profileImageFileEntryId", profilePicEntry.getFileEntryId());
					}
				}
				
				FileEntry bannerPicEntry = null;
				if(bannerPicFile != null) {
					String bannerPicName = uploadRequest.getFileName("bannerImage");
					
					if(bannerPicName != null && bannerPicName != "") {
						String bannerPicContentType = uploadRequest.getContentType("bannerImage");
						
						// validate file
						_validateFile(bannerPicName, bannerPicContentType, uploadRequest.getSize("bannerImage"));
						// get mypage user folder
						DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "com.mypage.user");
						if (userFolder == null) {
							userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
									themeDisplay.getScopeGroupId(), false, 0, "com.mypage.user", "", true, serviceContext);
						}
						
						long folderId = userFolder.getFolderId();
						
						// set filename
						String uniqueFileName = _uniqueFileNameProvider.provide(
								bannerPicName, curFileName -> _exists(themeDisplay, folderId, curFileName));
						// add file
						bannerPicEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
				                repositoryId, userFolder.getFolderId(), uniqueFileName, 
				                bannerPicContentType, uniqueFileName, "", "", 
				                bannerPicFile, serviceContext
				        );
						
						data.put("bannerImageFileEntryId", bannerPicEntry.getFileEntryId());
					}
				}
			}
	
			// add/update licenses
			//////////////////////
			if(allowAdd && pageKey.equals("license")) {
				String productIds = ParamUtil.getString(actionRequest, "productConfigurationsSearchContainerPrimaryKeys");
	
				String[] _productIds = productIds.split(",");
				// remove all licenses
				MypageUserLicensesLocalServiceUtil.removeByMypageUserId(mypageUserId);
				// add new licenses
				if(_productIds.length > 0) {
					for(int i = 0; i < _productIds.length; i++) {
						if(_productIds[i].length()>0) {
							MypageUserLicensesLocalServiceUtil.addMypageUserLicense(mypageUserId, Long.parseLong(_productIds[i]));
						}
					}
				}
			}
			
			// add/update grace period
			//////////////////////
			if(allowAdd && pageKey.equals("grace_period")) {
				// remove all grace period
				MypageUserGracePeriodLocalServiceUtil.removeByMypageUserId(mypageUserId);
				
				String[] gracePeriodCodes = ParamUtil.getParameterValues(actionRequest, "gracePeriodCode[]");
				String[] gracePeriodValues = ParamUtil.getParameterValues(actionRequest, "gracePeriodValue[]");
				if(gracePeriodCodes.length > 0) {
					for(int i = 0; i < gracePeriodCodes.length; i++) {
						MypageUserGracePeriodLocalServiceUtil.addGracePeriod(mypageUserId, gracePeriodCodes[i], Integer.parseInt(gracePeriodValues[i]));
					}
				}
			}
			
			// update working hour
			if(pageKey.equals("working_hour")) {
				MypageUserWorkingHourLocalServiceUtil.removeByMypageUserId(mypageUserId);
				if(workingHourDay.length > 0) {
					for(int i = 0; i < workingHourDay.length; i++) {
						int workingStatus = workingHourStatus[i].equals("1") ? 1 : 0;
						MypageUserWorkingHourLocalServiceUtil.addWorkingHour(mypageUserId, workingHourDay[i], workingHourStartDate[i], workingHourEndDate[i], workingStatus);
					}
				}
			}
			
			// update Timeline
			if(pageKey.equals("timeline")) {
				MypageUserTimelineLocalServiceUtil.addTimeline(mypageUserId, ParamUtil.getString(actionRequest, "timelineText"), 0, null, null);
				SessionMessages.add(actionRequest, "timeline-added-ok");
			}
		
			// add/update user
			///////////////////
			MypageUser mypageUser = _mypageUserLocalService.addMypageUser(mypageUserId, data, userId, serviceContext);
			
			// redirect after update user
			// if add user redirect to update
			if(pageKey.equals("add_user")) {
				String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
				PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,themeDisplay.getLayout().getPlid(), actionRequest.RENDER_PHASE);
				redirectURL.setParameter("jspPage", "/user/edit.jsp");
				redirectURL.setParameter("mypageUserId", String.valueOf(mypageUser.getMypageUserId()));
				redirectURL.setParameter("pageKey", "account");
				actionResponse.sendRedirect(redirectURL.toString());
			} else {
				actionResponse.setRenderParameter("jspPage", "/user/edit.jsp");
				actionResponse.setRenderParameter("mypageUserId", String.valueOf(mypageUser.getMypageUserId()));
				actionResponse.setRenderParameter("pageKey", pageKey);
			}
			

			// success message
			SessionMessages.add(actionRequest, "success");
		} catch(SystemException | PortalException | ParseException | IOException e) {
			// error message
			SessionErrors.add(actionRequest, e.getClass());
			System.out.print(e.getClass());
System.out.print("======");
			// redirect if error
			if(pageKey.equals("add_user")) {
				actionResponse.setRenderParameter("jspPage", "/user/add.jsp");
			} else {
				actionResponse.setRenderParameter("jspPage", "/user/edit.jsp");
				actionResponse.setRenderParameter("mypageUserId", String.valueOf(mypageUserId));
				actionResponse.setRenderParameter("pageKey", pageKey);
			}
			
			e.printStackTrace();
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
	
	public void importUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		String filePath = "C:/liferayTmp/importDtPremi.csv";
		List<String> csvHeadLines = Arrays.asList(
				"mypageUserId", "liferayUserId", "Code", "Branch", "Name", "Birthday", "Email", "Mobile Phone", "Agent Flag", "Licenses", "Address",
				"User Parent", "Join Date", "End Date", "Id Number", "Active"
			);

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MypageUser.class.getName(),
					actionRequest);
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId = themeDisplay.getCompanyId();
			long userId = serviceContext.getUserId();

			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;
			
			Long mypageUserId = null;
			Long liferayUserId = null;
			String code = "";
			long branch = 0;
			String name = "";
			String birthday = "";
			String email = "";
			String mobilePhone = "";
			String agentFlag = "";
			String licenses = "";
			String address = "";
			long userParent = 0;
			String joinDate = "";
			String endDate = "";
			String idNumber = "";
			int active = 0;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			while (csvReader.readRecord()) { // Reading the individual line
				++row;

				// mypageUserId
				if (csvReader.get("mypageUserId") != null && !csvReader.get("mypageUserId").equals("")) {
					mypageUserId = Long.parseLong(csvReader.get("mypageUserId"));
				}
				// mypageUserId
				if (csvReader.get("liferayUserId") != null && !csvReader.get("liferayUserId").equals("")) {
					liferayUserId = Long.parseLong(csvReader.get("liferayUserId"));
				}

				// Code
				if (csvReader.get("Code") != null && !csvReader.get("Code").equals("")) {
					code = csvReader.get("Code");
				} else {
					invalid.append("<br>Baris " + row + ", Kolom " + "Code.");
					continue;
				}
				
				// Branch
				if (csvReader.get("Branch") != null && !csvReader.get("Branch").equals("")) {
					branch = Long.parseLong(csvReader.get("Branch"));
				}
				
				// Name
				if (csvReader.get("Name") != null && !csvReader.get("Name").equals("")) {
					name = csvReader.get("Name").toUpperCase();
				} else {
					invalid.append("<br>Baris " + row + ", Name " + "Code.");
					continue;
				}
				
				// Birthday
				if (csvReader.get("Birthday") != null && !csvReader.get("Birthday").equals("")) {
					birthday = csvReader.get("Birthday");
				} else {
					invalid.append("<br>Baris " + row + ", Birthday " + "Code.");
					continue;
				}
				
				// Email
				if (csvReader.get("Email") != null && !csvReader.get("Email").equals("")) {
					email = csvReader.get("Email").toUpperCase();
				} else {
					invalid.append("<br>Baris " + row + ", Email " + "Code.");
					continue;
				}
				
				// Mobile Phone
				if (csvReader.get("Mobile Phone") != null && !csvReader.get("Mobile Phone").equals("")) {
					mobilePhone = csvReader.get("Mobile Phone");
				}
				
				// Agent Flag
				if (csvReader.get("Agent Flag") != null && !csvReader.get("Agent Flag").equals("")) {
					agentFlag = csvReader.get("Agent Flag");
				}
				
				// Licenses
				if (csvReader.get("Licenses") != null && !csvReader.get("Licenses").equals("")) {
					licenses = csvReader.get("Licenses");
				}
				
				// Address
				if (csvReader.get("Address") != null && !csvReader.get("Address").equals("")) {
					address = csvReader.get("Address");
				}
				
				// User Parent
				if (csvReader.get("User Parent") != null && !csvReader.get("User Parent").equals("")) {
					userParent = Long.parseLong(csvReader.get("User Parent"));
				}
				
				// Join Date
				if (csvReader.get("Join Date") != null && !csvReader.get("Join Date").equals("")) {
					joinDate = csvReader.get("Join Date");
				}
				
				// End Date
				if (csvReader.get("End Date") != null && !csvReader.get("End Date").equals("")) {
					endDate = csvReader.get("End Date");
				}
				
				// Id Number
				if (csvReader.get("Id Number") != null && !csvReader.get("Id Number").equals("")) {
					idNumber = csvReader.get("Id Number");
				}
				
				// active
				if (csvReader.get("Active") != null && !csvReader.get("Active").equals("")) {
					active = Integer.parseInt(csvReader.get("Active"));
				}
				
				if (mypageUserId != null) {
					// update user liferay
					User getUser = UserLocalServiceUtil.getUserById(liferayUserId);
					
					getUser.setEmailAddress(email);
					
					// set firstname & lastname
					int idx = name.lastIndexOf(' ');
					if (idx == -1) throw new IllegalArgumentException("Only a single name: " + name);
					String firstName = name.substring(0, idx);
					String lastName  = name.substring(idx + 1);

					getUser.setFirstName(firstName);
					getUser.setLastName(lastName);

					User user = UserLocalServiceUtil.updateUser(getUser);
					
					// update mypage user
					MypageUser setMypageUser = MypageUserLocalServiceUtil.getByLiferayUserId(liferayUserId);

					setMypageUser.setCode(code);
					setMypageUser.setUserBranch(branch);
					setMypageUser.setMobilePhone(mobilePhone);
					setMypageUser.setAgentFlag(agentFlag);
					setMypageUser.setAddress(address);
					setMypageUser.setUserParent(userParent);
					
					if (Validator.isNotNull(joinDate)) {
						Date setJoinDate = sdf.parse(joinDate);
						setMypageUser.setJoinDate(setJoinDate);
					}
					if (Validator.isNotNull(endDate)) {
						Date setEndDate = sdf.parse(endDate);
						setMypageUser.setEndDate(setEndDate);
					}
					
					setMypageUser.setIdNumber(idNumber);
					setMypageUser.setActive(active);

					MypageUser mypageUser = MypageUserLocalServiceUtil.updateMypageUser(setMypageUser);
					
					// update licenses
					String[] _licenses = licenses.split(",");
					// remove all licenses
					MypageUserLicensesLocalServiceUtil.removeByMypageUserId(mypageUser.getMypageUserId());
					// add new licenses
					if(_licenses.length > 0) {
						for(int j = 0; j < _licenses.length; j++) {
							ProductConfiguration product = null;
							product = _productConfigurationLocalService.getConfigByCode(_licenses[j]);
							MypageUserLicensesLocalServiceUtil.addMypageUserLicense(mypageUser.getMypageUserId(), product.getProductId());
						}
					}
				} else {
					// set firstname & lastname
					int idx = name.lastIndexOf(' ');
					if (idx == -1) throw new IllegalArgumentException("Only a single name: " + name);
					String firstName = name.substring(0, idx);
					String lastName  = name.substring(idx + 1);
					
					Integer day = null;
					Integer month = null;
					Integer year = null;
					if (Validator.isNotNull(birthday)) {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

					  	//convert String to LocalDate
					  	LocalDate Dob = LocalDate.parse(birthday, formatter);
		            
		                day = Dob.getDayOfMonth();
		                month = Dob.getMonthValue() - 1;
		                year = Dob.getYear();
					}
					
					User user = UserLocalServiceUtil.addUser(
							PortalUtil.getUserId(actionRequest), 
							companyId, 
							true, 
							null, 
							null, 
							false, 
							code, 
							email, 
							LocaleUtil.getDefault(), 
							firstName, 
							"", 
							lastName, 
							0, 
							0, 
							false, 
							month, 
							day, 
							year, 
							null, 
							null, 
							null, 
							null, 
							null, 
							false, 
							null
						);
					
					// add mypage user
					long getMypageUserId = CounterLocalServiceUtil.increment(MypageUser.class.getName());
					MypageUser setMypageUser = MypageUserLocalServiceUtil.createMypageUser(getMypageUserId);

					setMypageUser.setCode(code);
					setMypageUser.setUserBranch(branch);
					setMypageUser.setMobilePhone(mobilePhone);
					setMypageUser.setAgentFlag(agentFlag);
					setMypageUser.setAddress(address);
					setMypageUser.setUserParent(userParent);
					
					if (Validator.isNotNull(joinDate)) {
						Date setJoinDate = sdf.parse(joinDate);
						setMypageUser.setJoinDate(setJoinDate);
					}
					if (Validator.isNotNull(endDate)) {
						Date setEndDate = sdf.parse(endDate);
						setMypageUser.setEndDate(setEndDate);
					}
					
					setMypageUser.setIdNumber(idNumber);
					setMypageUser.setActive(active);

					MypageUser mypageUser = MypageUserLocalServiceUtil.addMypageUser(setMypageUser);
					
					// add licenses
					String[] _licenses = licenses.split(",");
					// add new licenses
					if(_licenses.length > 0) {
						for(int j = 0; j < _licenses.length; j++) {
							ProductConfiguration product = null;
							product = _productConfigurationLocalService.getConfigByCode(_licenses[j]);
							MypageUserLicensesLocalServiceUtil.addMypageUserLicense(mypageUser.getMypageUserId(), product.getProductId());
						}
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
			}
			actionResponse.setRenderParameter("mvcPath", "/user/list.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Export User
	private void exportUser(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			long[] mypageUsers = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList(
						"mypageUserId", "liferayUserId", "Code", "Branch", "Name", "Birthday", "Email", "Mobile Phone", "Agent Flag", "Licenses", "Address",
						"User Parent", "Join Date", "End Date", "Id Number", "Active"
					);

			String COMMA = ";";
			StringBundler sb = new StringBundler();
			for (String columnName : csvHeadLines) {
				sb.append(getCSVFormattedValue(String.valueOf(columnName)));
				sb.append(COMMA);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);

			// If ExportAll
			if (cmd.equals("exportAll")) {
				List<MypageUser> _mypageUsers = _mypageUserLocalService.getMypageUsers(0, _mypageUserLocalService.getMypageUsersCount());
				
				for (MypageUser _mypageUser : _mypageUsers) {
					try {
						List<MypageUserLicenses> _mypageUserLicenses = _mypageUserLicensesLocalService.getByMypageUserId(_mypageUser.getMypageUserId());
						
						// get liferay user
						User liferayUser = _userLocalService.getUser(_mypageUser.getLiferayUserId());

						// mypageUserId
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getMypageUserId())));
						sb.append(COMMA);
						
						// liferayUserId
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getLiferayUserId())));
						sb.append(COMMA);
						
						// Code
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getCode())));
						sb.append(COMMA);
						
						// Branch
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getBranch())));
						sb.append(COMMA);
						
						// get name
						String name = liferayUser.getFirstName();
						if(!liferayUser.getMiddleName().isEmpty()) name += " " + liferayUser.getMiddleName();
						if(!liferayUser.getLastName().isEmpty()) name += " " + liferayUser.getLastName();
						
						// Name
						sb.append(getCSVFormattedValue(String.valueOf(name)));
						sb.append(COMMA);
						
						// Email
						sb.append(getCSVFormattedValue(String.valueOf(liferayUser.getEmailAddress())));
						sb.append(COMMA);
						
						// Mobile Phone
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getMobilePhone())));
						sb.append(COMMA);
						
						// Agent Flag
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getAgentFlag())));
						sb.append(COMMA);
						
						// get licenses
						String licenses = "";
						if(_mypageUserLicenses.size() > 0) {
							for(MypageUserLicenses license : _mypageUserLicenses) {
								ProductConfiguration product =  _productConfigurationLocalService.getProductConfiguration(license.getProductId());
								if(!licenses.isEmpty()) licenses += ",";
								licenses += product.getProductCode();
							}
						}
						
						// Licenses
						sb.append(getCSVFormattedValue(String.valueOf(licenses)));
						sb.append(COMMA);
						
						// Address
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getAddress())));
						sb.append(COMMA);
						
						// User Parent
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getUserParent() > 0 ? _mypageUser.getUserParent() : "")));
						sb.append(COMMA);
						
						// get join date
					    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
					    String joinDate = "";
					    if(_mypageUser.getJoinDate() != null) joinDate = dateFormat.format(_mypageUser.getJoinDate());
						
						// Join Date
						sb.append(getCSVFormattedValue(String.valueOf(joinDate)));
						sb.append(COMMA);
						
						// get end date
						String endDate = "";
					    if(_mypageUser.getEndDate() != null) endDate = dateFormat.format(_mypageUser.getEndDate());
					    
						// End Date
						sb.append(getCSVFormattedValue(String.valueOf(endDate)));
						sb.append(COMMA);
						
						// Id Number
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getIdNumber())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			} else {

				if (mypageUsers.length < 1)
					return;

				for (long userId : mypageUsers) {

					MypageUser _mypageUser = _mypageUserLocalService.getMypageUser(userId);
					List<MypageUserLicenses> _mypageUserLicenses = _mypageUserLicensesLocalService.getByMypageUserId(userId);

					try {
						// get liferay user
						User liferayUser = _userLocalService.getUser(_mypageUser.getLiferayUserId());

						// mypageUserId
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getMypageUserId())));
						sb.append(COMMA);
						
						// liferayUserId
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getLiferayUserId())));
						sb.append(COMMA);
						
						// Code
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getCode())));
						sb.append(COMMA);
						
						// Branch
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getUserBranch())));
						sb.append(COMMA);
						
						// get name
						String name = liferayUser.getFirstName();
						if(!liferayUser.getMiddleName().isEmpty()) name += " " + liferayUser.getMiddleName();
						if(!liferayUser.getLastName().isEmpty()) name += " " + liferayUser.getLastName();
						
						// Name
						sb.append(getCSVFormattedValue(String.valueOf(name)));
						sb.append(COMMA);
						
						// get Birthday
					    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
					    String birthDate = "";
					    if(liferayUser.getBirthday() != null) birthDate = dateFormat.format(liferayUser.getBirthday());
						
						// Birthday
						sb.append(getCSVFormattedValue(String.valueOf(birthDate)));
						sb.append(COMMA);
						
						// Email
						sb.append(getCSVFormattedValue(String.valueOf(liferayUser.getEmailAddress())));
						sb.append(COMMA);
						
						// Mobile Phone
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getMobilePhone())));
						sb.append(COMMA);
						
						// Agent Flag
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getAgentFlag())));
						sb.append(COMMA);
						
						// get licenses
						String licenses = "";
						if(_mypageUserLicenses.size() > 0) {
							for(MypageUserLicenses license : _mypageUserLicenses) {
								ProductConfiguration product =  _productConfigurationLocalService.getProductConfiguration(license.getProductId());
								if(!licenses.isEmpty()) licenses += ",";
								licenses += product.getProductCode();
							}
						}
						
						// Licenses
						sb.append(getCSVFormattedValue(String.valueOf(licenses)));
						sb.append(COMMA);
						
						// Address
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getAddress())));
						sb.append(COMMA);
						
						// User Parent
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getUserParent() > 0 ? _mypageUser.getUserParent() : "")));
						sb.append(COMMA);
						
						// get join date
					    String joinDate = "";
					    if(_mypageUser.getJoinDate() != null) joinDate = dateFormat.format(_mypageUser.getJoinDate());
						
						// Join Date
						sb.append(getCSVFormattedValue(String.valueOf(joinDate)));
						sb.append(COMMA);
						
						// get end date
						String endDate = "";
					    if(_mypageUser.getEndDate() != null) endDate = dateFormat.format(_mypageUser.getEndDate());
					    
						// End Date
						sb.append(getCSVFormattedValue(String.valueOf(endDate)));
						sb.append(COMMA);
						
						// Id Number
						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getIdNumber())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_mypageUser.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportMypageUser.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final Object[] _IMAGE_EXTENSIONS = {".gif", ".jpeg", ".jpg", ".png"};
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log _log = LogFactoryUtil.getLog(MypageUserPortlet.class);
	
	@Reference
	private ItemSelector _itemSelector;
	@Reference
	private UserService _userService;
	@Reference
	private UserLocalService _userLocalService;
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	@Reference
	private MypageUserLicensesLocalService _mypageUserLicensesLocalService;
	@Reference
	private ProductConfigurationLocalService _productConfigurationLocalService;
	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;
}