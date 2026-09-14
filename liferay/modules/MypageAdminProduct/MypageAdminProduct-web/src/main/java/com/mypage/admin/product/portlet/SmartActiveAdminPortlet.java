package com.mypage.admin.product.portlet;

import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.admin.product.constants.SmartActiveAdminPortletKeys;
import com.mypage.admin.product.model.MasterCountry;
import com.mypage.admin.product.model.SmartActiveBenefit;
import com.mypage.admin.product.model.SmartActiveBenefitType;
import com.mypage.admin.product.model.SmartActiveBenefitValue;
import com.mypage.admin.product.model.SmartActiveBenefitValueMapping;
import com.mypage.admin.product.model.SmartActiveClassRate;
import com.mypage.admin.product.model.SmartActiveFeature;
import com.mypage.admin.product.model.SmartActiveLink;
import com.mypage.admin.product.model.SmartActiveOccupation;
import com.mypage.admin.product.model.SmartActivePremi;
import com.mypage.admin.product.model.SmartActiveTopro;
import com.mypage.admin.product.model.SmartActiveToproBenefitMapping;
import com.mypage.admin.product.service.ProductConfigurationLocalService;
import com.mypage.admin.product.service.SmartActiveBenefitLocalService;
import com.mypage.admin.product.service.SmartActiveBenefitTypeLocalService;
import com.mypage.admin.product.service.SmartActiveBenefitValueLocalService;
import com.mypage.admin.product.service.SmartActiveBenefitValueLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitValueMappingLocalService;
import com.mypage.admin.product.service.SmartActiveClassRateLocalService;
import com.mypage.admin.product.service.SmartActiveFeatureLocalService;
import com.mypage.admin.product.service.SmartActiveLinkLocalService;
import com.mypage.admin.product.service.SmartActiveOccupationLocalService;
import com.mypage.admin.product.service.SmartActivePremiLocalService;
import com.mypage.admin.product.service.SmartActiveToproBenefitMappingLocalService;
import com.mypage.admin.product.service.SmartActiveToproLocalService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.jumpmind.symmetric.csv.CsvReader;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.layout-cacheable=true", "com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false", "com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true", "javax.portlet.display-name=Smarth Active",
		"javax.portlet.expiration-cache=0", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/product/smart_active/configuration.jsp",
		"javax.portlet.name=" + SmartActiveAdminPortletKeys.SMART_ACTIVE_ADMIN,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",

}, service = Portlet.class)
public class SmartActiveAdminPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		super.render(renderRequest, renderResponse);
	}
	
	public void updateProductConfiguration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(SmartActiveAdminPortlet.class.getName(), actionRequest);

		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		String productCode = SmartActiveAdminPortletKeys.PRODUCT_CODE;
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
		String link = ParamUtil.getString(actionRequest, "link");
		int isB2C = ParamUtil.getInteger(actionRequest, "isB2C", 0);
		int isB2B = ParamUtil.getInteger(actionRequest, "isB2B", 0);
		int isB2B2C = ParamUtil.getInteger(actionRequest, "pepEnable", 0);
		int pepEnable = ParamUtil.getInteger(actionRequest, "pepEnable", 0);

		String metaTitle = ParamUtil.getString(actionRequest, "meta_title");
		String metaDescription = ParamUtil.getString(actionRequest, "meta_description");
		String metaKeywords = ParamUtil.getString(actionRequest, "meta_keywords");

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		// Get icon image from frontend
		File iconFile = uploadRequest.getFile("iconFile");

		// Upload icon images
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
				
				_setGuestPermission(themeDisplay, DLFolder.class.getName(), userFolder.getPrimaryKey());

				long folderId = userFolder.getFolderId();

				// set filename
				String uniqueFileName = _uniqueFileNameProvider.provide(iconFileName,
						curFileName -> _exists(themeDisplay, folderId, curFileName));
				// add file
				iconFileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId,
						userFolder.getFolderId(), uniqueFileName, iconFileContentType, uniqueFileName, "", "", iconFile,
						serviceContext);
				iconFileEntryId = iconFileEntry.getFileEntryId();
			}
		}

		// Get product image from frontend
		File imageFile = uploadRequest.getFile("imageFile");

		// Upload product image
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
				String uniqueFileName = _uniqueFileNameProvider.provide(imageFileName,
						curFileName -> _exists(themeDisplay, folderId, curFileName));
				// add file
				imageFileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId,
						userFolder.getFolderId(), uniqueFileName, imageFileContentType, uniqueFileName, "", "",
						imageFile, serviceContext);

				imageFileEntryId = imageFileEntry.getFileEntryId();
			}
		}

		// policy wording file
		File policyWordingFile = uploadRequest.getFile("policyWordingFile");

		FileEntry policyWordingEntry = null;
		long policyWordingFileEntryId = 0;

		if (policyWordingFile != null) {
			String policyWordingFileName = uploadRequest.getFileName("policyWordingFile");

			if (policyWordingFileName != null && !policyWordingFileName.equals("")) {
				String policyWordingFileContentType = uploadRequest.getContentType("policyWordingFile");

				// get user folder
				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0,
						"Policy Wording");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(),
							themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), false, 0, "Policy Wording",
							"", false, serviceContext);
				}

				long folderId = userFolder.getFolderId();

				// set filename
				String uniqueFileName = _uniqueFileNameProvider.provide(policyWordingFileName,
						curFileName -> _exists(themeDisplay, folderId, curFileName));

				// add file
				policyWordingEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId,
						userFolder.getFolderId(), uniqueFileName, policyWordingFileContentType, uniqueFileName, "", "",
						policyWordingFile, serviceContext);
				policyWordingFileEntryId = policyWordingEntry.getFileEntryId();
			}

		}

		_productConfigurationLocalService.addConfig(productId, productName, productCode, commission, stampdutyIDR,
				stampdutyUSD, policyCostIDR, policyCostUSD, aclStatus, aclGracePeriod, webContentFolderId, link, isB2C,
				isB2B, isB2B2C, iconFileEntryId, imageFileEntryId, ojkName, pepEnable, policyWordingFileEntryId,
				metaTitle, metaDescription, metaKeywords);
	}
	
	/* Add or update Benefit Type */
	
	public void addBenefitType(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String _listViewPath = "/product/smart_active/benefit_type/list.jsp";
		String _editViewPath = "/product/smart_active/benefit_type/edit.jsp";

		// process param
		int benefitTypeId = ParamUtil.get(actionRequest, "benefitTypeId", 0);
		String nameId = ParamUtil.getString(actionRequest, "nameId", "");
		String nameEn = ParamUtil.getString(actionRequest, "nameEn", "");
		int sort = ParamUtil.getInteger(actionRequest, "sort", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (benefitTypeId > 0) {
			try {
				_smartActiveBenefitTypeLocalService.updateBenefitType(benefitTypeId, nameId, nameEn, sort, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_smartActiveBenefitTypeLocalService.addBenefitType(nameId, nameEn, sort, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}

	/* Add or update Benefit */

	public void addBenefit(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		String _listViewPath = "/product/smart_active/benefit/list.jsp";
		String _editViewPath = "/product/smart_active/benefit/edit.jsp";

		// process param
		int benefitId = ParamUtil.get(actionRequest, "benefitId", 0);
		String nameId = ParamUtil.getString(actionRequest, "nameId", "");
		String nameEn = ParamUtil.getString(actionRequest, "nameEn", "");
		
		int benefitTypeId = ParamUtil.get(actionRequest, "benefitTypeId", 0);
		int sort = ParamUtil.getInteger(actionRequest, "sort", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		
		String externalCode = ParamUtil.getString(actionRequest, "externalCode", "");
		String benefitLimit = ParamUtil.getString(actionRequest, "benefitLimit", "");
		String benefitDescription = ParamUtil.getString(actionRequest, "benefitDescription", "");

		if (benefitId > 0) {
			try {
				_smartActiveBenefitLocalService.updateBenefit(benefitId, benefitTypeId, nameId, nameEn, sort, active, benefitLimit, externalCode, benefitDescription);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_smartActiveBenefitLocalService.addBenefit(nameId, nameEn, sort, active, benefitTypeId, benefitLimit, externalCode, benefitDescription);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}
	
	/* Add or update Benefit Value */
	
	public void addBenefitValue(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String _listViewPath = "/product/smart_active/benefit_value/list.jsp";
		String _editViewPath = "/product/smart_active/benefit_value/edit.jsp";

		// process param
		int benefitValueId = ParamUtil.get(actionRequest, "benefitValueId", 0);
		long value = ParamUtil.getLong(actionRequest, "value", 0);
		value = value < 0 ? 0 : value;
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (benefitValueId > 0) {
			try {
				_smartActiveBenefitValueLocalService.updateBenefitValue(benefitValueId, value, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_smartActiveBenefitValueLocalService.addBenefitValue(value, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}
	
	/* Add or update Benefit Value Mapping */

	public void addBenefitValueMapping(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		String _listViewPath = "/product/smart_active/benefit_value_mapping/list.jsp";
		String _editViewPath = "/product/smart_active/benefit_value_mapping/edit.jsp";

		// process param
		long benefitValueMappingId = ParamUtil.getLong(actionRequest, "benefitValueMappingId", 0);
		long benefitTypeId = ParamUtil.getLong(actionRequest, "benefitTypeId", 0);
		long benefitId = ParamUtil.getLong(actionRequest, "benefitId", 0);
		long benefitValueId = ParamUtil.getLong(actionRequest, "benefitValueId", 0);
		String benefitValue = ParamUtil.getString(actionRequest, "value", "");
		String _limitValue = ParamUtil.getString(actionRequest, "limitValue", "0");
		BigDecimal limitValue = new BigDecimal(_limitValue);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (benefitValueMappingId > 0) {
			try {
				_smartActiveBenefitValueMappingLocalService.updateBenefitValueMapping(benefitValueMappingId, benefitTypeId, benefitId, benefitValueId, benefitValue, limitValue, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_smartActiveBenefitValueMappingLocalService.addBenefitValueMapping(benefitTypeId, benefitId, benefitValueId, benefitValue, limitValue, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}

	}
	
	/* Add or update Class Rate */
	
	public void addClassRate(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String _listViewPath = "/product/smart_active/class_rate/list.jsp";
		String _editViewPath = "/product/smart_active/class_rate/edit.jsp";

		// process param
		int classRateId = ParamUtil.get(actionRequest, "classRateId", 0);
		String nameId = ParamUtil.getString(actionRequest, "nameId", "");
		String nameEn = ParamUtil.getString(actionRequest, "nameEn", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (classRateId > 0) {
			try {
				_smartActiveClassRateLocalService.updateClassRate(classRateId, nameId, nameEn, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_smartActiveClassRateLocalService.addClassRate(nameId, nameEn, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}
	
	/* Add or update Occupation */
	
	public void addOccupation(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String _listViewPath = "/product/smart_active/occupation/list.jsp";
		String _editViewPath = "/product/smart_active/occupation/edit.jsp";

		// process param
		int occupationId = ParamUtil.get(actionRequest, "occupationId", 0);
		String code = ParamUtil.getString(actionRequest, "code", "");
		String nameId = ParamUtil.getString(actionRequest, "nameId", "");
		String nameEn = ParamUtil.getString(actionRequest, "nameEn", "");
		
		int classRateId = ParamUtil.get(actionRequest, "classRateId", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (occupationId > 0) {
			try {
				SmartActiveOccupation data = _smartActiveOccupationLocalService.getByCode(code);
				
				if (Validator.isNotNull(data) && data.getSmartActiveOccupationId() == occupationId) _smartActiveOccupationLocalService.updateOccupation(occupationId, code, nameId, nameEn, classRateId, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				SmartActiveOccupation data = _smartActiveOccupationLocalService.getByCode(code);
				
				if (Validator.isNull(data)) _smartActiveOccupationLocalService.addOccupation(code, nameId, nameEn, classRateId, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}
	
	/* Add or update Topro */
	
	public void addTopro(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String _listViewPath = "/product/smart_active/topro/list.jsp";
		String _editViewPath = "/product/smart_active/topro/edit.jsp";

		// process param
		int toproId = ParamUtil.get(actionRequest, "toproId", 0);
		String topro = ParamUtil.getString(actionRequest, "topro", "");
		String description = ParamUtil.getString(actionRequest, "description", "");
		String annotations = ParamUtil.getString(actionRequest, "annotations", "");
		long benefitValueId = ParamUtil.getLong(actionRequest, "benefitValueId", 0);
		String toc = ParamUtil.getString(actionRequest, "toc", "");
		
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (toproId > 0) {
			try {
				SmartActiveTopro data = _smartActiveToproLocalService.getByTopro(topro);
				
				if (Validator.isNotNull(data) && data.getSmartActiveToproId() == toproId) _smartActiveToproLocalService.updateTopro(toproId, topro, description, annotations, benefitValueId, toc, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				SmartActiveTopro data = _smartActiveToproLocalService.getByTopro(topro);
				
				if (Validator.isNull(data)) _smartActiveToproLocalService.addTopro(topro, description, annotations, benefitValueId, toc, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}
	
	/* Add or update Topro Benefit Mapping */

	public void addToproBenefitMapping(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		String _listViewPath = "/product/smart_active/topro_benefit_mapping/list.jsp";
		String _editViewPath = "/product/smart_active/topro_benefit_mapping/edit.jsp";

		// process param
		long toproBenefitMappingId = ParamUtil.getLong(actionRequest, "toproBenefitMappingId", 0);
		long toproId = ParamUtil.getLong(actionRequest, "toproId", 0);
		String benefit = ParamUtil.getString(actionRequest, "benefit", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (toproBenefitMappingId > 0) {
			try {
				_smartActiveToproBenefitMappingLocalService.updateToproBenefitMapping(toproBenefitMappingId, toproId, benefit, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_smartActiveToproBenefitMappingLocalService.addToproBenefitMapping(toproId, benefit, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}

	}
	
	/* Add or update Premi */

	public void addPremi(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		String _listViewPath = "/product/smart_active/premi/list.jsp";
		String _editViewPath = "/product/smart_active/premi/edit.jsp";

		// process param
		int premiId = ParamUtil.get(actionRequest, "premiId", 0);
		int benefitId = ParamUtil.get(actionRequest, "benefitId", 0);
		int classRateId = ParamUtil.get(actionRequest, "classRateId", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		double rate = ParamUtil.getDouble(actionRequest, "rate", 0);
		rate = rate < 0 ? 0 : rate;

		if (premiId > 0) {
			try {
				_SmartActivePremiLocalService.updatePremi(premiId, rate, benefitId, classRateId, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_SmartActivePremiLocalService.addPremi(rate, active, benefitId, classRateId);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}
	
	/* Add or update Feature */
	
	public void addFeature(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		String _listViewPath = "/product/smart_active/feature/list.jsp";
		String _editViewPath = "/product/smart_active/feature/edit.jsp";
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveAdminPortlet.class.getName(),
				actionRequest);
		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		int featureId = ParamUtil.getInteger(actionRequest, "featureId");
		String title = ParamUtil.getString(actionRequest, "title", "");
		int sort = ParamUtil.getInteger(actionRequest, "sort", 0);
		String description = ParamUtil.getString(actionRequest, "description", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		String fileURL = "";
		String fileName = "";
		long fileEntryId = 0;
		long groupId = 0;
		
		if (Validator.isNotNull(uploadPortletRequest.getFileName("imageFile"))) {
			File file = uploadPortletRequest.getFile("imageFile");
			String imageFileName = uploadPortletRequest.getFileName("imageFile");

			if (Validator.isNotNull(imageFileName)) {
				String imageFileContentType = uploadPortletRequest.getContentType("imageFile");
				
				// validate file
				_validateFile(imageFileName, imageFileContentType, uploadPortletRequest.getSize("imageFile"));

				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Product-Icons");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							themeDisplay.getScopeGroupId(), false, 0, "Product-Icons", "", false, serviceContext);
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
		                file, serviceContext
		        );
				
				_setGuestPermission(themeDisplay, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());
				
				fileEntryId = fileEntry.getFileEntryId();
				fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
				groupId = fileEntry.getGroupId();
				fileName = fileEntry.getFileName();
				fileURL = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getFileName();
			}
		}

		if (featureId > 0) {
			try {
				_SmartActiveFeatureLocalService.updateFeature(featureId, title, description, fileURL, fileEntryId, sort, active);
				
				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, 0);

				for (DLFileEntry fileEntry : fileEntries) {
					if (fileEntry.getFileName().equalsIgnoreCase(fileName))
						DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
				}

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				
				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, 0);

				for (DLFileEntry fileEntry : fileEntries) {
					if (fileEntry.getFileName().equalsIgnoreCase(fileName))
						DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
				}

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_SmartActiveFeatureLocalService.addFeature(title, description, fileURL, fileEntryId, sort, active);
				
				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, 0);

				for (DLFileEntry fileEntry : fileEntries) {
					if (fileEntry.getFileName().equalsIgnoreCase(fileName))
						DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
				}

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				
				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, 0);

				for (DLFileEntry fileEntry : fileEntries) {
					if (fileEntry.getFileName().equalsIgnoreCase(fileName))
						DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
				}

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}
	
	/* Add or update Link Files */
	
	public void addFile(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		String _listViewPath = "/product/smart_active/link/list.jsp";
		String _editViewPath = "/product/smart_active/link/edit.jsp";
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveAdminPortlet.class.getName(),
				actionRequest);
		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		int linkId = ParamUtil.getInteger(actionRequest, "linkId");
		String category = ParamUtil.getString(actionRequest, "category", "");
		String title = ParamUtil.getString(actionRequest, "title", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		String fileURL = ParamUtil.getString(actionRequest, "fileUrl", "");
		long fileEntryId = 0;
		
		if (Validator.isNotNull(uploadPortletRequest.getFileName("file"))) {
			File file = uploadPortletRequest.getFile("file");
			String imageFileName = uploadPortletRequest.getFileName("file");

			if (Validator.isNotNull(imageFileName)) {
				String imageFileContentType = uploadPortletRequest.getContentType("file");

				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Product-Files");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							themeDisplay.getScopeGroupId(), false, 0, "Product-Files", "", false, serviceContext);
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
		                file, serviceContext
		        );
				
				_setGuestPermission(themeDisplay, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());
				
				fileEntryId = fileEntry.getFileEntryId();
				fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
				fileURL = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getFileName();
			}
		}

		if (linkId > 0) {
			try {
				_SmartActiveLinkLocalService.updateLink(linkId, category, title, fileURL, fileEntryId, active);

				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		} else {
			try {
				_SmartActiveLinkLocalService.addLink(category, title, fileURL, fileEntryId, active);

				SessionMessages.add(actionRequest, "dataAdded");
				actionResponse.setRenderParameter("mvcPath", _listViewPath);
			} catch (Exception e) {
				log.info(e);
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("mvcPath", _editViewPath);
			}
		}
	}
	
	// Import Occupation
	public void importOccupation(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
        String filePath = liferayHome + "/liferayTmp/importOccupation.csv";
		List<String> csvHeadLines = Arrays.asList("Code", "Name Id", "Name En", "Class Rate", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath)) {
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

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String code;
				String nameId;
				String nameEn;
				long classRateId;
				int active;

				String codeVal = csvReader.get("Code");
				if (codeVal == null || codeVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Code.");
					continue;
				} else {
					code = codeVal;
				}
				
				SmartActiveOccupation data = _smartActiveOccupationLocalService.getByCode(code);
				
				if (Validator.isNotNull(data)) {
					invalid.append("<br>Kode " + code + " sudah ada.");
					continue;
				}

				String nameIdVal = csvReader.get("Name Id");
				if (nameIdVal == null || nameIdVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Name Id.");
					continue;
				} else {
					nameId = nameIdVal;
				}
				
				String nameEnVal = csvReader.get("Name En");
				if (nameEnVal == null || nameEnVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Name En.");
					continue;
				} else {
					nameEn = nameEnVal;
				}

				String classRateVal = csvReader.get("Class Rate");
				long _classRateId = _smartActiveClassRateLocalService.getClassRateIdByNameId(classRateVal);
				if (_classRateId == 0 || classRateVal == null || classRateVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Class Rate.");
					continue;
				} else {
					classRateId = _classRateId;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
//				if (occupationId != null) {
//					try {
//						_occupationLocalService.updateMasterOccupation(occupationId, name, occupationCategoryId,
//								active);
//					} catch (Exception e) {
//						SessionErrors.add(actionRequest, "data-update-failed");
//						log.info(e);
//						actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");
//					}
//				} else {
					try {
						_smartActiveOccupationLocalService.addOccupation(code, nameId, nameEn, classRateId, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/product/smart_active/occupation/list.jsp");
					}
//				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info("Error import occupation, msg: " + _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/product/smart_active/occupation/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}
	
	// Import Topro
	public void importTopro(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
        String filePath = liferayHome + "/liferayTmp/importTopro.csv";
		List<String> csvHeadLines = Arrays.asList("Topro", "Description", "Annotations", "Main Benefit Value", "TOC", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath)) {
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

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String topro;
				String description;
				String annotations;
				String benefitValue;
				String toc;
				int active;

				String toproVal = csvReader.get("Topro");
				if (toproVal == null || toproVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Topro.");
					continue;
				} else {
					topro = toproVal;
				}
				
				SmartActiveTopro data = _smartActiveToproLocalService.getByTopro(topro);
				
				if (Validator.isNotNull(data)) {
					invalid.append("<br>Topro " + topro + " sudah ada.");
					continue;
				}
				
				String descriptionVal = csvReader.get("Description");
				if (descriptionVal == null || descriptionVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Description.");
					continue;
				} else {
					description = descriptionVal;
				}

				String annotationsVal = csvReader.get("Annotations");
				if (annotationsVal == null || annotationsVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Annotations.");
					continue;
				} else {
					annotations = annotationsVal;
				}
				
				String benefitValueVal = csvReader.get("Main Benefit Value");
				if (benefitValueVal == null || benefitValueVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Main Benefit Value.");
					continue;
				} else {
					benefitValue = benefitValueVal;
				}
				
				SmartActiveBenefitValue dataBenefitValue = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitByValue(Long.parseLong(benefitValueVal));
				
				long benefitValueId = Validator.isNull(dataBenefitValue) == true ? 0 : dataBenefitValue.getSmartActiveBenefitValueId();
				
				String tocVal = csvReader.get("TOC");
				if (tocVal == null || tocVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom TOC.");
					continue;
				} else {
					toc = tocVal;
				}

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
//					if (occupationId != null) {
//						try {
//							_occupationLocalService.updateMasterOccupation(occupationId, name, occupationCategoryId,
//									active);
//						} catch (Exception e) {
//							SessionErrors.add(actionRequest, "data-update-failed");
//							log.info(e);
//							actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");
//						}
//					} else {
					try {
						_smartActiveToproLocalService.addTopro(topro, description, annotations, benefitValueId, toc, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/product/smart_active/topro/list.jsp");
					}
//					}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info("Error import topro, msg: " + _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/product/smart_active/topro/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}
	
	// Import Topro Benefit Mapping
	public void importToproBenefitMapping(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
        String filePath = liferayHome + "/liferayTmp/importToproBenefitMapping.csv";
		List<String> csvHeadLines = Arrays.asList("Topro", "Benefit Code", "Active");

		try (FileOutputStream fOut = new FileOutputStream(filePath)) {
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

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterCountry.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				String topro;
				JSONArray benefit;
				int active;
				List<Long> listBenefit = new ArrayList<>();
				String joinBenefit;

				String toproVal = csvReader.get("Topro");
				if (toproVal == null || toproVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Topro.");
					continue;
				} else {
					topro = toproVal;
				}
				
				SmartActiveTopro _topro = _smartActiveToproLocalService.getByTopro(topro);
				
				String benefitVal = csvReader.get("Benefit Code");
				if (benefitVal == null || benefitVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom Benefit Code.");
					continue;
				} else {
					benefit = JSONFactoryUtil.createJSONArray(benefitVal);
				}
				
				if (benefit.length() > 0) {
					for (int j = 0; j < benefit.length(); j++) {
						SmartActiveBenefit _benefit = _smartActiveBenefitLocalService.getByExternalCode(benefit.getString(j));
						listBenefit.add(_benefit.getSmartActiveBenefitId());
					}
				}
				
				joinBenefit = "[" + listBenefit.stream()
				              .map(String::valueOf)
				              .collect(Collectors.joining(","))
				              + "]";

				String activeCurrColVal = csvReader.get("Active");
				if (activeCurrColVal == null || Integer.parseInt(activeCurrColVal) > 1) {
					invalid.append("<br>Baris " + row + ", Kolom Active.");
					continue;
				} else {
					active = Integer.parseInt(activeCurrColVal);
				}

				// Insert all evaluated data to database
//						if (occupationId != null) {
//							try {
//								_occupationLocalService.updateMasterOccupation(occupationId, name, occupationCategoryId,
//										active);
//							} catch (Exception e) {
//								SessionErrors.add(actionRequest, "data-update-failed");
//								log.info(e);
//								actionResponse.setRenderParameter("mvcPath", "/master/occupation/list.jsp");
//							}
//						} else {
					try {
						_smartActiveToproBenefitMappingLocalService.addToproBenefitMapping(_topro.getSmartActiveToproId(), joinBenefit, active);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", "/product/smart_active/topro_benefit_mapping/list.jsp");
					}
//						}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info("Error import topro benefit mapping, msg: " + _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", "/product/smart_active/topro_benefit_mapping/list.jsp");

		} catch (Exception e) {
			log.info(e);
		}
	}
	
	/* Set Status */
	
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long benefitTypeId = ParamUtil.getLong(actionRequest, "benefitTypeId", 0);
		long benefitId = ParamUtil.getLong(actionRequest, "benefitId", 0);
		long benefitValueId = ParamUtil.getLong(actionRequest, "benefitValueId", 0);
		long benefitValueMappingId = ParamUtil.getLong(actionRequest, "benefitValueMappingId", 0);
		long classRateId = ParamUtil.getLong(actionRequest, "classRateId", 0);
		long occupationId = ParamUtil.getLong(actionRequest, "occupationId", 0);
		long toproId = ParamUtil.getLong(actionRequest, "toproId", 0);
		long toproBenefitMappingId = ParamUtil.getLong(actionRequest, "toproBenefitMappingId", 0);
		long premiId = ParamUtil.getLong(actionRequest, "premiId", 0);
		long featureId = ParamUtil.getLong(actionRequest, "featureId", 0);
		long linkId = ParamUtil.getLong(actionRequest, "linkId", 0);
		
		String _actionVal = ParamUtil.getString(actionRequest, "action", "");
		int active = 1;

		long[] entryIds = ParamUtil.getLongValues(actionRequest, "EntryIds");
		String cmd = ParamUtil.getString(actionRequest, "cmd", "");

		try {
			if (_actionVal.equals("unpublish")) {
				active = 0;
			}
		} catch (Exception e) {
//			log.info(e);
		}

		try {
			if (benefitTypeId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveBenefitType.class.getName(),
						actionRequest);
				_smartActiveBenefitTypeLocalService.setActive(benefitTypeId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/benefit_type/list.jsp");
			}
			
			if (benefitId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveBenefit.class.getName(),
						actionRequest);
				_smartActiveBenefitLocalService.setActive(benefitId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/benefit/list.jsp");
			}
			
			if (benefitValueId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveBenefitValue.class.getName(),
						actionRequest);
				_smartActiveBenefitValueLocalService.setActive(benefitValueId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/benefit_value/list.jsp");
			}
			
			if (benefitValueMappingId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveBenefitValueMapping.class.getName(),
						actionRequest);
				_smartActiveBenefitValueMappingLocalService.setActive(benefitValueMappingId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/benefit_value_mapping/list.jsp");
			}
			
			if (classRateId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveClassRate.class.getName(),
						actionRequest);
				_smartActiveClassRateLocalService.setActive(classRateId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/class_rate/list.jsp");
			}
			
			if (occupationId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveOccupation.class.getName(),
						actionRequest);
				_smartActiveOccupationLocalService.setActive(occupationId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/occupation/list.jsp");
			}
			
			if (toproId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveTopro.class.getName(),
						actionRequest);
				_smartActiveToproLocalService.setActive(toproId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/topro/list.jsp");
			}
			
			if (toproBenefitMappingId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveToproBenefitMapping.class.getName(),
						actionRequest);
				_smartActiveToproBenefitMappingLocalService.setActive(toproBenefitMappingId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/topro_benefit_mapping/list.jsp");
			}
			
			if (premiId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActivePremi.class.getName(),
						actionRequest);
				_SmartActivePremiLocalService.setActive(premiId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/premi/list.jsp");
			}
			
			if (featureId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveFeature.class.getName(),
						actionRequest);
				_SmartActiveFeatureLocalService.setActive(featureId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/feature/list.jsp");
			}
			
			if (linkId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveLink.class.getName(),
						actionRequest);
				_SmartActiveLinkLocalService.setActive(linkId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/smart_active/link/list.jsp");
			}
		} catch (Exception e) {
//			log.info(e);
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
	
	private static final Object[] _IMAGE_EXTENSIONS = { ".gif", ".jpeg", ".jpg", ".png", ".svg" };
	private static final long _IMAGE_MAX_SIZE = 5242880;

	private static final Log log = LogFactoryUtil.getLog(SmartActiveAdminPortlet.class);

	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;

	@Reference
	private ProductConfigurationLocalService _productConfigurationLocalService;

	@Reference
	private SmartActiveBenefitTypeLocalService _smartActiveBenefitTypeLocalService;

	@Reference
	private SmartActiveBenefitLocalService _smartActiveBenefitLocalService;
	
	@Reference
	private SmartActiveBenefitValueLocalService _smartActiveBenefitValueLocalService;
	
	@Reference
	private SmartActiveBenefitValueMappingLocalService _smartActiveBenefitValueMappingLocalService;
	
	@Reference
	private SmartActiveClassRateLocalService _smartActiveClassRateLocalService;
	
	@Reference
	private SmartActiveOccupationLocalService _smartActiveOccupationLocalService;
	
	@Reference
	private SmartActiveToproLocalService _smartActiveToproLocalService;
	
	@Reference
	private SmartActiveToproBenefitMappingLocalService _smartActiveToproBenefitMappingLocalService;

	@Reference
	private SmartActivePremiLocalService _SmartActivePremiLocalService;
	
	@Reference
	private SmartActiveFeatureLocalService _SmartActiveFeatureLocalService;
	
	@Reference
	private SmartActiveLinkLocalService _SmartActiveLinkLocalService;
}
