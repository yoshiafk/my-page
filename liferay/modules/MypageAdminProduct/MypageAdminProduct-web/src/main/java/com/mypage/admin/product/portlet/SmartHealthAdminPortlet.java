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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.constants.SmartHealthAdminPortletKeys;
import com.mypage.admin.product.model.SmartHealthBenefit;
import com.mypage.admin.product.model.SmartHealthBenefitGroup;
import com.mypage.admin.product.model.SmartHealthPlan;
import com.mypage.admin.product.service.ProductConfigurationLocalService;
import com.mypage.admin.product.service.SmartHealthBenefitGroupLocalService;
import com.mypage.admin.product.service.SmartHealthBenefitLocalService;
import com.mypage.admin.product.service.SmartHealthPlanLocalService;
import com.mypage.admin.product.service.SmartHealthPremiLocalService;

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
		"com.liferay.portlet.use-default-template=true", "javax.portlet.display-name=Smarth Health",
		"javax.portlet.expiration-cache=0", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/product/smart_health/configuration.jsp",
		"javax.portlet.name=" + SmartHealthAdminPortletKeys.SMARTHEALTHADMIN,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",

}, service = Portlet.class)
public class SmartHealthAdminPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

//		ParamUtil.print(renderRequest);
		super.render(renderRequest, renderResponse);
	}

	/**
	 * Add/Update Plan
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 */
	public void addPlan(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
//		ParamUtil.print(actionRequest);

		long smartHealthPlanId = ParamUtil.getLong(actionRequest, "smartHealthPlanId", 0L);
		String planName = ParamUtil.getString(actionRequest, "planName", "");
		String planGroup = ParamUtil.getString(actionRequest, "planGroup", "");
		boolean _recommended = ParamUtil.getBoolean(actionRequest, "isRecommended", false);
		int isRecommended = _recommended ? 1 : 0;
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		
		// Reset all isRecommended field in DB
		if(_recommended) {
			_smartHealthPlanLocalService.resetAllRecommendedStatus();
		}

		if (smartHealthPlanId > 0) {
			try {
				_smartHealthPlanLocalService.updateSmartHealthPlan(smartHealthPlanId, planName, planGroup, isRecommended, active);
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/plan/list.jsp");
				SessionMessages.add(actionRequest, "dataUpdated");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/plan/edit.jsp");
			}
		} else {
			try {
				_smartHealthPlanLocalService.addSmartHealthPlan(planName, planGroup, isRecommended, active);
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/plan/list.jsp");
				SessionMessages.add(actionRequest, "dataAdded");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/plan/edit.jsp");
			}
		}

	}
	
	/**
	 * Add/Update Premi
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 */
	public void addPremi(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long smartHealthPremiId = ParamUtil.getLong(actionRequest, "smartHealthPremiId", 0L);
		int age = ParamUtil.getInteger(actionRequest, "age", 0);
		String gender = ParamUtil.getString(actionRequest, "gender", "");
		String currency = ParamUtil.getString(actionRequest, "currency", "");
		double amount = ParamUtil.getDouble(actionRequest, "amount", 0d);
		long planId = ParamUtil.getLong(actionRequest, "planId", 0L);
		int status = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (smartHealthPremiId > 0) {
			try {
				_smartHealthPremiLocalService.updateSmartHealthPremi(smartHealthPremiId, age, gender, currency, amount, planId, status);
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/premi/list.jsp");
				SessionMessages.add(actionRequest, "dataUpdated");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/premi/edit.jsp");
			}
		} else {
			try {
				_smartHealthPremiLocalService.addSmartHealthPremi(age, gender, currency, amount, planId, status);
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/premi/list.jsp");
				SessionMessages.add(actionRequest, "dataAdded");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/premi/edit.jsp");
			}
		}
	}
	
	/**
	 * Add/Update Benefit Group
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 */
	public void addBenefitGroup(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long smartHealthBenefitGroupId = ParamUtil.getLong(actionRequest, "smartHealthBenefitGroupId", 0L);
		String groupName = ParamUtil.getString(actionRequest, "groupName", "");
		String groupDescription = ParamUtil.getString(actionRequest, "groupDescription", "");
		String groupCode = ParamUtil.getString(actionRequest, "groupCode", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (smartHealthBenefitGroupId > 0) {
			try {
				_smartHealthBenefitGroupLocalService.updateSmartHealthBenefitGroup(smartHealthBenefitGroupId, groupName, groupDescription, groupCode, active);
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/benefit_group/list.jsp");
				SessionMessages.add(actionRequest, "dataUpdated");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/benefit_group/edit.jsp");
			}
		} else {
			try {
				_smartHealthBenefitGroupLocalService.addSmartHealthBenefitGroup(groupName, groupDescription, groupCode, active);
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/benefit_group/list.jsp");
				SessionMessages.add(actionRequest, "dataAdded");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/benefit_group/edit.jsp");
			}
		}
	}	

	/**
	 * Add/Update Benefit
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 */
	public void addBenefit(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long smartHealthBenefitId = ParamUtil.getLong(actionRequest, "smartHealthBenefitId", 0L);
		String benefitTitle = ParamUtil.getString(actionRequest, "benefitTitle", "");
		String benefitContent = ParamUtil.getString(actionRequest, "benefitContent", "");
		long smartHealthBenefitGroupId = ParamUtil.getLong(actionRequest, "smartHealthBenefitGroupId", 0L);
		long smartHealthPlanId = ParamUtil.getLong(actionRequest, "smartHealthplanId", 0L);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (smartHealthBenefitId > 0) {
			try {
				_smartHealthBenefitLocalService.updateSmartHealthBenefit(smartHealthBenefitId, benefitTitle,
						benefitContent, smartHealthBenefitGroupId, smartHealthPlanId, active);
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/benefit/list.jsp");
				SessionMessages.add(actionRequest, "dataUpdated");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/benefit/edit.jsp");
			}
		} else {
			try {
				_smartHealthBenefitLocalService.addSmartHealthBenefit(benefitTitle, benefitContent,
						smartHealthBenefitGroupId, smartHealthPlanId, active);
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/benefit/list.jsp");
				SessionMessages.add(actionRequest, "dataAdded");
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", "/product/smart_health/benefit/edit.jsp");
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

		String productCode = "SH";
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

				String uniqueFileName = "SHProductImage_" + uniqueNumber;

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

				String uniqueFileName = "SHProductImage_" + uniqueNumber;

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

		long smartHealthPlanId = ParamUtil.getLong(request, "smartHealthPlanId");
		long smartHealthPremiId = ParamUtil.getLong(request, "smartHealthPremiId");
		long smartHealthBenefitGroupId = ParamUtil.getLong(request, "smartHealthBenefitGroupId");
		long smartHealthBenefitId = ParamUtil.getLong(request, "smartHealthBenefitId");
		
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
			if (smartHealthPlanId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartHealthPlan.class.getName(),
						request);
				_smartHealthPlanLocalService.setActive(smartHealthPlanId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/smart_health/plan/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}
			
			if (smartHealthPremiId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartHealthPlan.class.getName(),
						request);
				_smartHealthPremiLocalService.setActive(smartHealthPremiId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/smart_health/premi/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}
			
			if (smartHealthBenefitGroupId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartHealthBenefitGroup.class.getName(),
						request);
				_smartHealthBenefitGroupLocalService.setActive(smartHealthBenefitGroupId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/smart_health/benefit_group/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}
			
			if (smartHealthBenefitId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartHealthBenefit.class.getName(),
						request);
				_smartHealthBenefitLocalService.setActive(smartHealthBenefitId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/smart_health/benefit/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}			

		} catch (Exception e) {
			log.info(e);
		}
	}

	private static final Object[] _IMAGE_EXTENSIONS = { ".gif", ".jpeg", ".jpg", ".png", ".svg" };
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log log = LogFactoryUtil.getLog(SmartHealthAdminPortlet.class);
	@Reference
	private ProductConfigurationLocalService _productConfigurationLocalService;
	@Reference
	private SmartHealthPlanLocalService _smartHealthPlanLocalService;
	@Reference
	private SmartHealthPremiLocalService _smartHealthPremiLocalService;
	@Reference
	private SmartHealthBenefitGroupLocalService _smartHealthBenefitGroupLocalService;
	@Reference
	private SmartHealthBenefitLocalService _smartHealthBenefitLocalService;		

}
