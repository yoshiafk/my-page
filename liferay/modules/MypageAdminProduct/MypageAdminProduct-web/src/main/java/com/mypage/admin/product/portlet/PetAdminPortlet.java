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
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.admin.product.constants.PetAdminPortletKeys;
import com.mypage.admin.product.model.PetAnimalType;
import com.mypage.admin.product.model.PetPlan;
import com.mypage.admin.product.model.PetRate;
import com.mypage.admin.product.model.PetRemarks;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.service.PetAnimalTypeLocalService;
import com.mypage.admin.product.service.PetPlanLocalService;
import com.mypage.admin.product.service.PetRateLocalService;
import com.mypage.admin.product.service.PetRemarksLocalService;
import com.mypage.admin.product.service.ProductConfigurationLocalService;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/pet_admin.css",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Pet Insurance Admin",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/product/pet/configuration.jsp",
		"javax.portlet.name=" + PetAdminPortletKeys.PET_ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",

}, service = Portlet.class)
public class PetAdminPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletURL webContentURL = null;

		try {

			ProductConfiguration _conf = _productConfigurationLocalService.getConfigByCode(PetAdminPortletKeys.PRODUCT_CODE);

			if (!Validator.isNull(_conf) && _conf.getWebContentFolderId() > 0) {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				long groupId = themeDisplay.getScopeGroupId();
				int webContentFolderId = _conf.getWebContentFolderId();

				webContentURL = PortletURLFactoryUtil.create(renderRequest, "com_liferay_journal_web_portlet_JournalPortlet", renderRequest.RENDER_PHASE);
				webContentURL.setWindowState(WindowState.MAXIMIZED);
				webContentURL.setPortletMode(PortletMode.VIEW);
				webContentURL.setParameter("_com_liferay_journal_web_portlet_JournalPortlet_groupId", String.valueOf(groupId));
				webContentURL.setParameter("_com_liferay_journal_web_portlet_JournalPortlet_folderId", String.valueOf(webContentFolderId));
				webContentURL.setParameter("_com_liferay_journal_web_portlet_JournalPortlet_displayStyle", "descriptive");
			}
		} catch (Exception e) {
			throw new PortletException(e);
		}

		renderRequest.setAttribute("webContentURL", webContentURL);
		super.render(renderRequest, renderResponse);
	}
	
	public void updateProductConfiguration(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(PetAdminPortlet.class.getName(), actionRequest);
		
		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		String productCode = PetAdminPortletKeys.PET_PRODUCT_CODE;
		long productId = ParamUtil.getLong(actionRequest, "productId");
		String productName = ParamUtil.getString(actionRequest, "product_name");
		String ojkName = ParamUtil.getString(actionRequest, "ojk_name");
		double commission = ParamUtil.getDouble(actionRequest, "agent_commission");
		double stampdutyIDR = ParamUtil.getDouble(actionRequest, "stampduty_idr");
		double stampdutyUSD = ParamUtil.getDouble(actionRequest, "stampduty_usd");
		double policyCostIDR = ParamUtil.getDouble(actionRequest, "policy_cost_idr");
		double policyCostUSD = ParamUtil.getDouble(actionRequest, "policy_cost_usd");
		int aclStatus = ParamUtil.getInteger(actionRequest, "acl_status");
		int aclGracePeriod = ParamUtil.getInteger(actionRequest, "acl_grace_period");
		int webContentFolderId = ParamUtil.getInteger(actionRequest, "web_content_folder_id", 0);
        String link = ParamUtil.getString(actionRequest,"link");
        int isB2C = ParamUtil.getInteger(actionRequest,"isB2C",0);
        int isB2B = ParamUtil.getInteger(actionRequest,"isB2B",0);
        int isB2B2C = ParamUtil.getInteger(actionRequest,"pepEnable",0);
        int pepEnable = ParamUtil.getInteger(actionRequest,"pepEnable",0);
        
        String metaTitle = ParamUtil.getString(actionRequest,"meta_title");
        String metaDescription = ParamUtil.getString(actionRequest,"meta_description");
        String metaKeywords = ParamUtil.getString(actionRequest,"meta_keywords");
       
        
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        
        // Product Icon Upload
		File iconFile = uploadRequest.getFile("iconFile");
		
		// upload images
		FileEntry iconFileEntry = null;
		long iconFileEntryId = 0;
		if(iconFile != null) {
			String iconFileName = uploadRequest.getFileName("iconFile");

			if(iconFileName != null && !iconFileName.equals("")) {
				String iconFileContentType = uploadRequest.getContentType("iconFile");
				// validate file
				_validateFile(iconFileName, iconFileContentType, uploadRequest.getSize("iconFile"));
				// get user folder
				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Product-Icons");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							themeDisplay.getScopeGroupId(), false, 0, "Product-Icons", "", false, serviceContext);
				}
				
				long folderId = userFolder.getFolderId();
				
				// set filename
				String uniqueFileName = _uniqueFileNameProvider.provide(
						iconFileName, curFileName -> _exists(themeDisplay, folderId, curFileName));
				// add file
				iconFileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
		                repositoryId, userFolder.getFolderId(), uniqueFileName, 
		                iconFileContentType, uniqueFileName, "", "", 
		                iconFile, serviceContext
		        );
				
				iconFileEntryId = iconFileEntry.getFileEntryId();
			}
		}
		
        // Product Image Upload
		File imageFile = uploadRequest.getFile("imageFile");
		
		// upload images
		FileEntry imageFileEntry = null;
		long imageFileEntryId = 0;
		if(imageFile != null) {
			String imageFileName = uploadRequest.getFileName("imageFile");

			if(imageFileName != null && !imageFileName.equals("")) {
				String imageFileContentType = uploadRequest.getContentType("imageFile");
				// validate file
				_validateFile(imageFileName, imageFileContentType, uploadRequest.getSize("imageFile"));
				// get user folder
				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Product-Images");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							themeDisplay.getScopeGroupId(), false, 0, "Product-Images", "", false, serviceContext);
				}
				
				long folderId = userFolder.getFolderId();
				
				// set filename
				String uniqueFileName = _uniqueFileNameProvider.provide(
						imageFileName, curFileName -> _exists(themeDisplay, folderId, curFileName));
				// add file
				imageFileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
		                repositoryId, userFolder.getFolderId(), uniqueFileName, 
		                imageFileContentType, uniqueFileName, "", "", 
		                imageFile, serviceContext
		        );
				
				imageFileEntryId = imageFileEntry.getFileEntryId();
			}
		}
		
		// policy wording file
		File policyWordingFile = uploadRequest.getFile("policyWordingFile");
		
		FileEntry policyWordingEntry = null;
		long policyWordingFileEntryId = 0;
		
		if(policyWordingFile != null) {
			String policyWordingFileName = uploadRequest.getFileName("policyWordingFile");
			
			if(policyWordingFileName != null && !policyWordingFileName.equals("")) {
				String policyWordingFileContentType = uploadRequest.getContentType("policyWordingFile");
				// validate file
//				_validateFile(iconFileName, iconFileContentType, uploadRequest.getSize("iconFile"));
				// get user folder
				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Policy Wording");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, 0, "Policy Wording", "", false, serviceContext);
				}
				
				long folderId = userFolder.getFolderId();
				
				// set filename
				String uniqueFileName = _uniqueFileNameProvider.provide(policyWordingFileName, curFileName -> _exists(themeDisplay, folderId, curFileName));
				
				// add file
				policyWordingEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId, userFolder.getFolderId(), uniqueFileName, policyWordingFileContentType, uniqueFileName, "", "", policyWordingFile, serviceContext);
				policyWordingFileEntryId = policyWordingEntry.getFileEntryId();
			}
			
		}
		
		_productConfigurationLocalService.addConfig(productId, productName, productCode, commission, stampdutyIDR,
				stampdutyUSD, policyCostIDR, policyCostUSD, aclStatus, aclGracePeriod, webContentFolderId, link, isB2C, isB2B, isB2B2C, iconFileEntryId, imageFileEntryId, ojkName, pepEnable, policyWordingFileEntryId, metaTitle, metaDescription, metaKeywords);
	}
	
	/**
	 * Add New or Edit Plan
	 */
	public void addPlan(ActionRequest request, ActionResponse response) throws PortalException {
		
		ParamUtil.print(request);
		int petPlanId = ParamUtil.get(request, "petPlanId", 0);
		String planName = ParamUtil.getString(request, "planName", "");

		long limitDisability = ParamUtil.getLong(request, "limitDisability", 0);
		long limitMedical = ParamUtil.getLong(request, "limitMedical", 0);
		long limitThirdParty = ParamUtil.getLong(request, "limitThirdParty", 0);
		long limitCustody = ParamUtil.getLong(request, "limitCustody", 0);

		String benefit = ParamUtil.getString(request, "benefit", "");
		long pimcorePlanId = ParamUtil.getLong(request, "pimcorePlanId", 0);
		boolean _isRecommended = ParamUtil.getBoolean(request, "isRecommended", false);
		int isRecommended = _isRecommended ? 1 : 0;
		boolean _customPlan = ParamUtil.getBoolean(request, "customPlan", false);
		int customPlan = _customPlan ? 1 : 0;
		int active = ParamUtil.getBoolean(request, "active", false) ? 1 : 0;

		if (petPlanId > 0) {
			try {
				_petPlanLocalService.updatePetPlan(petPlanId, planName, limitDisability, limitMedical, limitThirdParty,
						limitCustody, benefit, pimcorePlanId, isRecommended, customPlan, active);
				response.setRenderParameter("mvcPath", "/product/pet/plan/list.jsp");
				SessionMessages.add(request, "data-updated");
			} catch (Exception e) {
				System.out.println(e);
				PortalUtil.copyRequestParameters(request, response);

				SessionErrors.add(request, e.getClass().getName());
				response.setRenderParameter("mvcPath", "/product/pet/plan/edit.jsp");
			}

		} else {
			try {
				_petPlanLocalService.addPetPlan(planName, limitDisability, limitMedical, limitThirdParty, limitCustody,
						benefit, pimcorePlanId, isRecommended, customPlan, active);
				SessionMessages.add(request, "dataAdded");
				response.setRenderParameter("mvcPath", "/product/pet/plan/list.jsp");
			} catch (Exception e) {
				System.out.println(e);
				PortalUtil.copyRequestParameters(request, response);

				SessionErrors.add(request, e.getClass().getName());
				response.setRenderParameter("mvcPath", "/product/pet/plan/edit.jsp");
			}
		}
	}	

	/**
	 * Add New Remarks
	 */
	public void addRemarks(ActionRequest request, ActionResponse response) throws PortalException {

		int petRemarksId = ParamUtil.get(request, "petRemarksId", 0);
		String remarksName = ParamUtil.get(request, "remarksName", "");
		String remarksCode = ParamUtil.get(request, "remarksCode", "");
		int active = ParamUtil.getBoolean(request, "active", false) ? 1 : 0;

		if (petRemarksId > 0) {
			try {
				_petRemarksLocalService.updatePetRemarks(petRemarksId, remarksName, remarksCode, active);
				response.setRenderParameter("mvcPath", "/product/pet/remarks/list.jsp");
				SessionMessages.add(request, "dataUpdated"); // message session

			} catch (Exception e) {
				System.out.println(e);
				PortalUtil.copyRequestParameters(request, response);
				SessionErrors.add(request, e.getClass().getName());
				response.setRenderParameter("mvcPath", "/product/pet/remarks/edit.jsp");
			}
		} else {
			try {
				_petRemarksLocalService.addPetRemarks(remarksName, remarksCode, active);
				response.setRenderParameter("mvcPath", "/product/pet/remarks/list.jsp");
				SessionMessages.add(request, "dataAdded"); // message session

			} catch (Exception e) {
				System.out.println(e);
				PortalUtil.copyRequestParameters(request, response);
				SessionErrors.add(request, e.getClass().getName());
				response.setRenderParameter("mvcPath", "/product/pet/remarks/edit.jsp");
			}
		}
	}
	
	/**
	 * Add New Animal Type
	 */
	public void addAnimalType(ActionRequest request, ActionResponse response) throws PortalException {

		int petAnimalTypeId = ParamUtil.get(request, "petAnimalTypeId", 0);
		String name = ParamUtil.get(request, "name", "");
		int active = ParamUtil.getBoolean(request, "active", false) ? 1 : 0;

		if (petAnimalTypeId > 0) {
			try {
				_petAnimalTypeLocalService.updatePetAnimalType(petAnimalTypeId, name, active);
				response.setRenderParameter("mvcPath", "/product/pet/animal_type/list.jsp");
				SessionMessages.add(request, "dataUpdated"); // message session

			} catch (Exception e) {
				System.out.println(e);
				PortalUtil.copyRequestParameters(request, response);
				SessionErrors.add(request, e.getClass().getName());
				response.setRenderParameter("mvcPath", "/product/pet/animal_type/edit.jsp");
			}
		} else {
			try {
				_petAnimalTypeLocalService.addPetAnimalType(name, active);
				response.setRenderParameter("mvcPath", "/product/pet/animal_type/list.jsp");
				SessionMessages.add(request, "dataAdded"); // message session

			} catch (Exception e) {
				System.out.println(e);
				PortalUtil.copyRequestParameters(request, response);
				SessionErrors.add(request, e.getClass().getName());
				response.setRenderParameter("mvcPath", "/product/pet/animal_type/edit.jsp");
			}
		}
	}
	
	/**
	 * Add New Rate
	 */
	public void addRate(ActionRequest request, ActionResponse response) throws PortalException {
		int petRateId = ParamUtil.get(request, "petRateId", 0);
		long petPlanId = ParamUtil.get(request, "petPlanId", 0);
		long petRemarksId = ParamUtil.get(request, "petRemarksId", 0);
		String petRate = ParamUtil.get(request, "petRate", "");
		int active = ParamUtil.getBoolean(request, "active", false) ? 1 : 0;
		if (petRateId > 0) {
			try {
				_petRateLocalService.updatePetRate(petRateId, petPlanId, petRemarksId, petRate, active);
				response.setRenderParameter("mvcPath", "/product/pet/rate/list.jsp");
				SessionMessages.add(request, "dataUpdated");

			} catch (Exception e) {
				System.out.println(e);
				PortalUtil.copyRequestParameters(request, response);
				SessionErrors.add(request, e.getClass().getName());
				response.setRenderParameter("mvcPath", "/product/pet/rate/edit.jsp");
			}
		} else {
			try {
				_petRateLocalService.addPetRate(petPlanId, petRemarksId, petRate, active);

				response.setRenderParameter("mvcPath", "/product/pet/rate/list.jsp");
				SessionMessages.add(request, "dataAdded");

			} catch (Exception e) {
				System.out.println(e);
				PortalUtil.copyRequestParameters(request, response);
				SessionErrors.add(request, e.getClass().getName());
				response.setRenderParameter("mvcPath", "/product/pet/rate/edit.jsp");
			}
		}
	}	
	
	/**
	 * Set status Plan
	 */
	public void setStatus(ActionRequest request, ActionResponse response) throws PortalException {

		long petPlanId = ParamUtil.getLong(request, "petPlanId");
		long petRemarksId = ParamUtil.getLong(request, "petRemarksId");
		long petRateId = ParamUtil.getLong(request, "petRateId");
		long petAnimalTypeId = ParamUtil.getLong(request, "petAnimalTypeId");

		String _actionVal = ParamUtil.getString(request, "action", "");
		int active = 1; // set active var to 1

		try {
			if (_actionVal.equals("unpublish")) {
				active = 0;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			if (petPlanId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PetPlan.class.getName(), request);
				long userId = serviceContext.getUserId();
				_petPlanLocalService.setActive(userId, petPlanId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/pet/plan/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}

			if (petRemarksId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PetRemarks.class.getName(), request);
				long userId = serviceContext.getUserId();
				_petRemarksLocalService.setActive(userId, petRemarksId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/pet/remarks/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}

			if (petRateId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PetRate.class.getName(), request);
				long userId = serviceContext.getUserId();
				_petRateLocalService.setActive(userId, petRateId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/pet/rate/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}
			
			if (petAnimalTypeId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(PetAnimalType.class.getName(), request);
				long userId = serviceContext.getUserId();
				_petAnimalTypeLocalService.setActive(petAnimalTypeId, active, serviceContext);
				response.setRenderParameter("mvcPath", "/product/pet/animal_type/list.jsp");
				SessionMessages.add(request, "dataStatusChanged");
			}
		} catch (Exception e) {
			System.out.println(e);
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
	
	private static final Object[] _IMAGE_EXTENSIONS = {".gif", ".jpeg", ".jpg", ".png", ".svg"};
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log _log = LogFactoryUtil.getLog(PetAdminPortlet.class);	
	
	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;
	
	@Reference
	private ProductConfigurationLocalService _productConfigurationLocalService;	
	
	@Reference
	private PetPlanLocalService _petPlanLocalService;
	
	@Reference
	private PetRemarksLocalService _petRemarksLocalService;
	
	@Reference
	private PetAnimalTypeLocalService _petAnimalTypeLocalService;
	
	@Reference
	private PetRateLocalService _petRateLocalService;	
}
