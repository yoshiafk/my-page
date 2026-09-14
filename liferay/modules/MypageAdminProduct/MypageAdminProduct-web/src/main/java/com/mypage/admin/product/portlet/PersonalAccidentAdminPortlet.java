package com.mypage.admin.product.portlet;

import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.constants.PersonalAccidentAdminPortletKeys;
import com.mypage.admin.product.model.PersonalAccidentPremi;
import com.mypage.admin.product.service.PersonalAccidentPremiLocalService;
//import com.mypage.admin.product.constants.SmartHealthAdminPortletKeys;
//import com.mypage.admin.product.model.SmartHealthBenefit;
//import com.mypage.admin.product.model.SmartHealthBenefitGroup;
//import com.mypage.admin.product.model.SmartHealthPlan;
import com.mypage.admin.product.service.ProductConfigurationLocalService;
//import com.mypage.admin.product.service.SmartHealthBenefitGroupLocalService;
//import com.mypage.admin.product.service.SmartHealthBenefitLocalService;
//import com.mypage.admin.product.service.SmartHealthPlanLocalService;
//import com.mypage.admin.product.service.SmartHealthPremiLocalService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.layout-cacheable=true", "com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false", "com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true", "javax.portlet.display-name=Personal Accident",
		"javax.portlet.expiration-cache=0", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/product/personal_accident/configuration.jsp",
		"javax.portlet.name=" + PersonalAccidentAdminPortletKeys.PERSONALACCIDENTADMIN,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",

}, service = Portlet.class)
public class PersonalAccidentAdminPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

//		ParamUtil.print(renderRequest);
		super.render(renderRequest, renderResponse);
	}
	
	/**
	 * Add/Update Premi
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 */
	public void addPremi(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long personalAccidentPremiId = ParamUtil.getLong(actionRequest, "personalAccidentPremiId", 0L);
		String type = ParamUtil.getString(actionRequest, "premiType", "");
		double amount = ParamUtil.getDouble(actionRequest, "amount", 0d);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (personalAccidentPremiId > 0) {
			try {
				_personalAccidentPremiLocalService.updatePersonalAccidentPremi(personalAccidentPremiId, type, amount, active);
				actionResponse.setRenderParameter("mvcPath", "/product/personal_accident/premi/list.jsp");
				SessionMessages.add(actionRequest, "dataUpdated");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/personal_accident/premi/edit.jsp");
			}
		} else {
			try {
				_personalAccidentPremiLocalService.addPersonalAccidentPremi(type, amount, active);
				actionResponse.setRenderParameter("mvcPath", "/product/personal_accident/premi/list.jsp");
				SessionMessages.add(actionRequest, "dataAdded");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/personal_accident/premi/edit.jsp");
			}
		}
	}
	
	/**
	 * Update Product Configuration
	 */
	public void updateProductConfiguration(ActionRequest request, ActionResponse response) throws PortalException {

//		ParamUtil.print(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartHealthAdminPortlet.class.getName(),
				request);
		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		String productCode = "PA2";
		long productId = ParamUtil.getLong(request, "productId");
		String productName = ParamUtil.getString(request, "product_name");
		double commission = ParamUtil.getDouble(request, "agent_commission");
		double stampdutyIDR = ParamUtil.getDouble(request, "stampduty_idr");
		double stampdutyUSD = ParamUtil.getDouble(request, "stampduty_usd");
		double policyCostIDR = ParamUtil.getDouble(request, "policy_cost_idr");
		double policyCostUSD = ParamUtil.getDouble(request, "policy_cost_usd");
		int aclStatus = ParamUtil.getInteger(request, "acl_status");
		int aclGracePeriod = ParamUtil.getInteger(request, "acl_grace_period");
		int webContentFolderId = ParamUtil.getInteger(request, "web_content_folder_id", 0);
		String link = ParamUtil.getString(request, "link");
		int isB2C = ParamUtil.getInteger(request, "isB2C", 0);
		int isB2B = ParamUtil.getInteger(request, "isB2B", 0);
		int isB2B2C = ParamUtil.getInteger(request, "isB2B2C", 0);
		
		String ojkName = "";
        int pepEnable = 0;
        long policyWordingEntryId = 0L;
        
        String metaTitle = ParamUtil.getString(request,"meta_title");
        String metaDescription = ParamUtil.getString(request,"meta_description");
        String metaKeywords = ParamUtil.getString(request,"meta_keywords");
//
//        // Product Icon Upload
		File iconFile = uploadRequest.getFile("iconFile");
//		
		// upload images
		FileEntry iconFileEntry = null;
		long iconFileEntryId = 0;
		if (iconFile != null) {
			String iconFileName = uploadRequest.getFileName("iconFile");

			if (iconFileName != null && !iconFileName.equals("")) {
				String iconFileContentType = uploadRequest.getContentType("iconFile");
				// validate file
				_validateFile(iconFileName, iconFileContentType, uploadRequest.getSize("iconFile"));
				// get user folder
				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0,
						"Product-Icons");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(),
							themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, 0, "Product-Icons",
							"", false, serviceContext);
				}

				long folderId = userFolder.getFolderId();

				// set filename
//				String uniqueFileName = _uniqueFileNameProvider.provide(iconFileName,
//						curFileName -> _exists(themeDisplay, folderId, curFileName));

				Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String uniqueNumber = dateFormat.format(now);

				String uniqueFileName = "PA2ProductImage_" + uniqueNumber;

				// add file
				iconFileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId,
						userFolder.getFolderId(), uniqueFileName, iconFileContentType, uniqueFileName, "", "", iconFile,
						serviceContext);

				iconFileEntryId = iconFileEntry.getFileEntryId();
			}
		}

		// Product Image Upload
		File imageFile = uploadRequest.getFile("imageFile");

		// upload images
		FileEntry imageFileEntry = null;
		long imageFileEntryId = 0;
		if (imageFile != null) {
			String imageFileName = uploadRequest.getFileName("imageFile");

			if (imageFileName != null && !imageFileName.equals("")) {
				String imageFileContentType = uploadRequest.getContentType("imageFile");
				// validate file
				_validateFile(imageFileName, imageFileContentType, uploadRequest.getSize("imageFile"));
				// get user folder
				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0,
						"Product-Images");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(),
							themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, 0, "Product-Images",
							"", false, serviceContext);
				}

				long folderId = userFolder.getFolderId();

				// set filename
//				String uniqueFileName = _uniqueFileNameProvider.provide(imageFileName,
//						curFileName -> _exists(themeDisplay, folderId, curFileName));

				Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String uniqueNumber = dateFormat.format(now);

				String uniqueFileName = "PA2ProductImage_" + uniqueNumber;

				// add file
				imageFileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId,
						userFolder.getFolderId(), uniqueFileName, imageFileContentType, uniqueFileName, "", "",
						imageFile, serviceContext);

				imageFileEntryId = imageFileEntry.getFileEntryId();
			}
		}

		try {
			_productConfigurationLocalService.addConfig(productId, productName, productCode, commission, stampdutyIDR,
					stampdutyUSD, policyCostIDR, policyCostUSD, aclStatus, aclGracePeriod, webContentFolderId, link,
					isB2C, isB2B, isB2B2C, iconFileEntryId, imageFileEntryId, ojkName, pepEnable, policyWordingEntryId, metaTitle, metaDescription, metaKeywords);
		} catch (Exception e) {
			log.info(e);
		}

	}

//	private boolean _exists(ThemeDisplay themeDisplay, long folderId, String curFileName) {
//		try {
//			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId,
//					curFileName);
//
//			if (tempFileEntry != null) {
//				return true;
//			}
//
//			return false;
//		} catch (PortalException portalException) {
//			portalException.printStackTrace();
//			return false;
//		}
//	}

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
	
	/**
	 * Set status
	 */
	public void setStatus(ActionRequest request, ActionResponse response) throws PortalException {

		long personalAccidentPremiId = ParamUtil.getLong(request, "personalAccidentPremiId");
		
		String _actionVal = ParamUtil.getString(request, "action", "");
		int active = 1; // set active var to 1

		try {
			if (_actionVal.equals("unpublish")) {
				active = 0;
			}
		} catch (Exception e) {
			log.info(e);
		}

		try {
			if (personalAccidentPremiId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PersonalAccidentPremi.class.getName(),
						request);
				_personalAccidentPremiLocalService.setActive(personalAccidentPremiId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/personal_accident/premi/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}		

		} catch (Exception e) {
			log.info(e);
		}
	}

	private static final Object[] _IMAGE_EXTENSIONS = { ".gif", ".jpeg", ".jpg", ".png", ".svg" };
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log log = LogFactoryUtil.getLog(PersonalAccidentAdminPortlet.class);
	@Reference
	private ProductConfigurationLocalService _productConfigurationLocalService;
	@Reference
	private PersonalAccidentPremiLocalService _personalAccidentPremiLocalService;

}
