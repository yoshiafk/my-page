package com.mypage.admin.product.portlet;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.admin.product.constants.InternationalTravelStandardNewAdminPortletKeys;
import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.model.Industry;
import com.mypage.admin.product.model.IndustryCategory;
import com.mypage.admin.product.model.Plan;
import com.mypage.admin.product.model.Premi;
import com.mypage.admin.product.service.BenefitLocalService;
import com.mypage.admin.product.service.BenefitTypeLocalService;
import com.mypage.admin.product.service.BenefitValueMappingLocalService;
import com.mypage.admin.product.service.IntTravelStandardNewPremiLocalService;
import com.mypage.admin.product.service.PlanLocalService;
import com.mypage.admin.product.service.PremiLocalService;
import com.mypage.admin.product.service.ProductConfigurationLocalService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.jumpmind.symmetric.csv.CsvReader;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=myPage",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/internationaltravelstandardnew_admin.css",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=Smart Travel International",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/product/international_travel_standard_new/configuration.jsp",
		"javax.portlet.name=" + InternationalTravelStandardNewAdminPortletKeys.IT_STANDARD_NEW_ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class InternationalTravelStandardNewAdminPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		super.render(renderRequest, renderResponse);
	}

	public void updateProductConfiguration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(InternationalTravelStandardNewAdminPortlet.class.getName(), actionRequest);

		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		String productCode = InternationalTravelStandardNewAdminPortletKeys.PRODUCT_CODE;
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

//	/**
//	 * CREATE/UPDATE PREMI
//	 */
//	public void updatePremi(ActionRequest request, ActionResponse response) throws PortalException {
//
//		ServiceContext serviceContext = ServiceContextFactory
//				.getInstance(InternationalTravelStandardNewAdminPortlet.class.getName(), request);
//		long userId = serviceContext.getUserId();
//
//		ParamUtil.print(request);
//
//		long premiId = ParamUtil.getLong(request, "premiId");
//		String travelType = ParamUtil.getString(request, "travel_type");
//		String packageType = ParamUtil.getString(request, "package_type");
//		String peopleType = ParamUtil.getString(request, "traveller_type");
//
//		int mainInsured = Integer.valueOf("1");
//		int spouse = ParamUtil.getInteger(request, "spouse");
//		int child = ParamUtil.getInteger(request, "child");
//
//		String currency = ParamUtil.getString(request, "currency");
//		BigDecimal amount = new BigDecimal(ParamUtil.getString(request, "amount"));
//		BigDecimal additionalPrice = new BigDecimal(ParamUtil.getString(request, "additional_price"));
//		int active = ParamUtil.getInteger(request, "active");
//
//		if (premiId > 0) {
//			try {
//				_intTravelStandardNewPremiLocalService.updateIntTravelStandardNewPremi(premiId, travelType, packageType,
//						peopleType, mainInsured, spouse, child, currency, amount, additionalPrice, active);
//				response.setRenderParameter("mvcPath", "/product/international_travel_standard_new/premi/list.jsp");
//				SessionMessages.add(request, "data-updated");
//			} catch (Exception e) {
//				log.info(e.getMessage());
//				PortalUtil.copyRequestParameters(request, response);
//
//				SessionErrors.add(request, e.getClass().getName());
//				response.setRenderParameter("mvcPath", "/product/international_travel_standard_new/premi/edit.jsp");
//			}
//		} else {
//			try {
//				_intTravelStandardNewPremiLocalService.addIntTravelStandardNewPremi(travelType, packageType, peopleType,
//						mainInsured, spouse, child, currency, amount, additionalPrice, active);
//				response.setRenderParameter("mvcPath", "/product/international_travel_standard_new/premi/list.jsp");
//				SessionMessages.add(request, "data-updated");
//			} catch (Exception e) {
//				log.info(e.getMessage());
//				PortalUtil.copyRequestParameters(request, response);
//
//				SessionErrors.add(request, e.getClass().getName());
//				response.setRenderParameter("mvcPath", "/product/international_travel_standard_new/premi/edit.jsp");
//			}
//		}
////		try {
////			_travelInternationalPremiLocalService.addPremi(userId, premiId, packageType, peopleType, adultCount, childrenCount, currency, amount, minDuration, maxDuration, active, serviceContext);
////			response.setRenderParameter("mvcPath", "/product/international_travel/premi/list.jsp");
////			SessionMessages.add(request, "dataUpdated");
////		} catch (Exception e) {
////			e.printStackTrace();
////			PortalUtil.copyRequestParameters(request, response);
////
////			SessionErrors.add(request, e.getClass().getName());
////			response.setRenderParameter("mvcPath", "/product/international_travel/premi/edit.jsp");
////		}
//	}

	public void addBenefitType(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String _listViewPath = "/product/international_travel_standard_new/benefit_type/list.jsp";
		String _editViewPath = "/product/international_travel_standard_new/benefit_type/edit.jsp";

		// process param
		int benefitTypeId = ParamUtil.get(actionRequest, "benefitTypeId", 0);
		String nameId = ParamUtil.getString(actionRequest, "nameId", "");
		String nameEn = ParamUtil.getString(actionRequest, "nameEn", "");
		int sort = ParamUtil.getInteger(actionRequest, "sort", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (benefitTypeId > 0) {
			try {
				_BenefitTypeLocalService.updateBenefitType(benefitTypeId, nameId, nameEn, sort, active);

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
				_BenefitTypeLocalService.addBenefitType(nameId, nameEn, sort, active);

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

		String _listViewPath = "/product/international_travel_standard_new/benefit/list.jsp";
		String _editViewPath = "/product/international_travel_standard_new/benefit/edit.jsp";

		// process param
		int benefitId = ParamUtil.get(actionRequest, "benefitId", 0);
		String nameId = ParamUtil.getString(actionRequest, "nameId", "");
		String nameEn = ParamUtil.getString(actionRequest, "nameEn", "");
		
		String planName = ParamUtil.getString(actionRequest, "planName", "");
		String benefitValue = ParamUtil.getString(actionRequest, "benefitValue", "");
		
		int benefitTypeId = ParamUtil.get(actionRequest, "benefitTypeId", 0);
		int sort = ParamUtil.getInteger(actionRequest, "sort", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		
		String externalCode = ParamUtil.getString(actionRequest, "externalCode", "");
		String benefitDescription = ParamUtil.getString(actionRequest, "benefitDescription", "");

		if (benefitId > 0) {
			try {
				_BenefitLocalService.updateBenefit(benefitId, benefitTypeId, nameId, nameEn, sort, active, planName, benefitValue, externalCode, benefitDescription);

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
				_BenefitLocalService.addBenefit(nameId, nameEn, sort, active, benefitTypeId, planName ,benefitValue, externalCode, benefitDescription);

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

	public void addBenefitValueMapping(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		String _listViewPath = "/product/international_travel_standard_new/benefit_value_mapping/list.jsp";
		String _editViewPath = "/product/international_travel_standard_new/benefit_value_mapping/edit.jsp";

		// process param
		long benefitValueMappingId = ParamUtil.getLong(actionRequest, "benefitValueMappingId", 0);
		long planId = ParamUtil.getLong(actionRequest, "planId", 0);
		long benefitTypeId = ParamUtil.getLong(actionRequest, "benefitTypeId", 0);
		long benefitId = ParamUtil.getLong(actionRequest, "benefitId", 0);
		String benefitValue = ParamUtil.getString(actionRequest, "benefitValue", "");
		String benefitValueUSD = ParamUtil.getString(actionRequest, "benefitValueUSD", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		int sort = 1;

		if (benefitValueMappingId > 0) {
			try {
				_benefitValueMappingLocalService.updateBenefit(benefitValueMappingId, benefitTypeId, benefitId, planId, benefitValue, benefitValueUSD, sort, active);

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
				_benefitValueMappingLocalService.addBenefitValueMapping(benefitTypeId, benefitId, planId, benefitValue, benefitValueUSD, sort, active);

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

	/* Add or update Plan */
	public void addPlan(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		String _listViewPath = "/product/international_travel_standard_new/plan/list.jsp";
		String _editViewPath = "/product/international_travel_standard_new/plan/edit.jsp";

		// process param
		int planId = ParamUtil.get(actionRequest, "planId", 0);
		String nameId = ParamUtil.getString(actionRequest, "nameId", "");
		String nameEn = ParamUtil.getString(actionRequest, "nameEn", "");
		int sort = ParamUtil.getInteger(actionRequest, "sort", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (planId > 0) {
			try {
				_PlanLocalService.updatePlan(planId, nameId, nameEn, sort, active);
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
				_PlanLocalService.addPlan(nameId, nameEn, sort, active);

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

		String _listViewPath = "/product/international_travel_standard_new/premi2/list.jsp";
		String _editViewPath = "/product/international_travel_standard_new/premi2/edit.jsp";

		// process param
		int premiId = ParamUtil.get(actionRequest, "premiId", 0);
		String travellerType = ParamUtil.getString(actionRequest, "travellerType", "");

		String currency = ParamUtil.getString(actionRequest, "currency", "");

		double basic = ParamUtil.getDouble(actionRequest, "basic", 0);
		double additional = ParamUtil.getDouble(actionRequest, "additional", 0);
		double annual = ParamUtil.getDouble(actionRequest, "annual", 0);

		int benefitId = ParamUtil.get(actionRequest, "benefitId", 0);
		int planId = ParamUtil.get(actionRequest, "planId", 0);

		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;

		if (premiId > 0) {
			try {
				_PremiLocalService.updatePremi(premiId, benefitId, planId, travellerType, currency,
						BigDecimal.valueOf(basic), BigDecimal.valueOf(additional), BigDecimal.valueOf(annual), active);

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
				_PremiLocalService.addPremi(travellerType, currency, BigDecimal.valueOf(basic),
						BigDecimal.valueOf(additional), BigDecimal.valueOf(annual), active, benefitId, planId);

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
	
	/**
	 * Set Status
	 */
	public void setStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		
		log.info("InternationalTravelStandardNewAdminPortlet.setStatus() set status");

		long benefitTypeId = ParamUtil.getLong(actionRequest, "benefitTypeId", 0);
		long benefitId = ParamUtil.getLong(actionRequest, "benefitId", 0);
		long planId = ParamUtil.getLong(actionRequest, "planId", 0);
		long premiId = ParamUtil.getLong(actionRequest, "premiId", 0);
		
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
				ServiceContext serviceContext = ServiceContextFactory.getInstance(BenefitType.class.getName(),
						actionRequest);
				_BenefitTypeLocalService.setActive(benefitTypeId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/international_travel_standard_new/benefit_type/list.jsp");
			}
			
			if (benefitId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Benefit.class.getName(),
						actionRequest);
				_BenefitLocalService.setActive(benefitId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/international_travel_standard_new/benefit/list.jsp");
			}
			
			if (planId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Plan.class.getName(),
						actionRequest);
				_PlanLocalService.setActive(planId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/international_travel_standard_new/plan/list.jsp");
			}
			
			if (premiId != 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Premi.class.getName(),
						actionRequest);
				_PremiLocalService.setActive(premiId, active, serviceContext);
				SessionMessages.add(actionRequest, "dataUpdated");
				actionResponse.setRenderParameter("mvcPath", "/product/international_travel_standard_new/premi2/list.jsp");
			}
			
		} catch (Exception e) {
//			log.info(e);
		}
	}


	/**
	 * EXPORT & IMPORT
	 */

	// Method for resource URL
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		String type = ParamUtil.getString(resourceRequest, "type");

		if (cmd.equals(Constants.EXPORT) || cmd.equals("exportAll")) {

			if (type.equals("benefit_type")) {
				exportBenefitType(resourceRequest, resourceResponse);
				log.info("InternationalTravelStandardNewAdminPortlet.serveResource() export benefit type");
			}
			if (type.equals("benefit")) {
				exportBenefit(resourceRequest, resourceResponse);
				log.info("InternationalTravelStandardNewAdminPortlet.serveResource() export benefit");
			}

			if (type.equals("plan")) {
				exportPlan(resourceRequest, resourceResponse);
				log.info("InternationalTravelStandardNewAdminPortlet.serveResource() export plan");
			}
			if (type.equals("premi")) {
				exportPremi(resourceRequest, resourceResponse);
				log.info("InternationalTravelStandardNewAdminPortlet.serveResource() export premi");
			}
		}
		return;
	}

	private String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}

	// Export Benefit Type
	private void exportBenefitType(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] benefitTypes = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Benefit Type ID", "Name (Indonesia)", "Name (English)", "Sort", "Active");

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
				List<BenefitType> _benefitTypes = _BenefitTypeLocalService.getBenefitTypes();

				for (BenefitType _btype : _benefitTypes) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_btype.getBenefitTypeId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_btype.getNameId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_btype.getNameEn())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_btype.getSort())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_btype.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (benefitTypes.length < 1)
					return;

				for (long benefitTypeId : benefitTypes) {

					BenefitType _BenefitType = _BenefitTypeLocalService.getBenefitType(benefitTypeId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_BenefitType.getBenefitTypeId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_BenefitType.getNameId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_BenefitType.getNameEn())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_BenefitType.getSort())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_BenefitType.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsBenefitType.csv", bytes,
					contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Benefit Type
	public void importBenefitType(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String _currentListPath = "/product/international_travel_standard_new/benefit_type/list.jsp";

		String filePath = "C:/liferayTmp/importBenefitType.csv";
		List<String> csvHeadLines = Arrays.asList("Benefit Type ID","Name (Indonesia)", "Name (English)", "Sort");

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

			ServiceContext serviceContext = ServiceContextFactory.getInstance(IndustryCategory.class.getName(),
					actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long benefitTypeId = null;
			String nameId, nameEn;
			int sort, active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				// Apabila kolom id null, proses CRUD tetap berlanjut
				// dengan kondisi apabila null maka method update yang berjalan
				// apabila sebaliknya, maka method add yang berjalan
				String benefitTypeIdCurrColVal = csvReader.get("Benefit Type ID");
				if (benefitTypeIdCurrColVal != null && !benefitTypeIdCurrColVal.equals(""))
					benefitTypeId = Long.parseLong(benefitTypeIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name (Indonesia)");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name (Indonesia).");
					continue;
				} else {
					nameId = nameCurrColVal;
				}

				String nameEnCurrColVal = csvReader.get("Name (English)");
				if (nameEnCurrColVal == null || nameEnCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name (English).");
					continue;
				} else {
					nameEn = nameEnCurrColVal;
				}

				String sortCurrColVal = csvReader.get("Sort");
				if (sortCurrColVal == null) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Sort.");
					continue;
				} else {
					sort = Integer.parseInt(sortCurrColVal);
				}

				log.info(benefitTypeId + " , " + nameId + ", " + nameEn + ", " + sort + " , " + 1);

				// Insert all evaluated data to database
				if (benefitTypeId != null) {
					log.info("InternationalTravelStandardNewAdminPortlet.importBenefitType() >> UPDATE");
					try {
						_BenefitTypeLocalService.updateBenefitType(benefitTypeId, nameId, nameEn, sort, 1);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				} else {
					log.info("InternationalTravelStandardNewAdminPortlet.importBenefitType() >> ADD");
					try {
						_BenefitTypeLocalService.addBenefitType(nameId, nameEn, sort, 1);
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", _currentListPath);

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Benefit
	private void exportBenefit(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {

			long[] benefits = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Benefit ID", "Name (Indonesia)", "Name (English)", "Sort", "Plan Name", "Benefit Value","Active",
					"Benefit Type");

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
				List<Benefit> _benefits = _BenefitLocalService.getBenefits();

				for (Benefit _ben : _benefits) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_ben.getBenefitId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_ben.getNameId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_ben.getNameEn())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_ben.getSort())));
						sb.append(COMMA);
						
						sb.append(getCSVFormattedValue(String.valueOf(_ben.getPlanName())));
						sb.append(COMMA);
						
						sb.append(getCSVFormattedValue(String.valueOf(_ben.getBenefitValue())));
						sb.append(COMMA);
						
						sb.append(getCSVFormattedValue(String.valueOf(_ben.getActive())));
						sb.append(COMMA);

						BenefitType type = _BenefitTypeLocalService.getBenefitType(_ben.getBenefitTypeId());
						sb.append(getCSVFormattedValue(
								String.valueOf(type.getNameId() != null ? type.getNameId() : type.getNameEn())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (benefits.length < 1)
					return;

				for (long benefitId : benefits) {

					Benefit _benefit = _BenefitLocalService.getBenefit(benefitId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_benefit.getBenefitId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_benefit.getNameId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_benefit.getNameEn())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_benefit.getSort())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_benefit.getActive())));
						sb.append(COMMA);

						BenefitType type = _BenefitTypeLocalService.getBenefitType(_benefit.getBenefitTypeId());
						sb.append(getCSVFormattedValue(
								String.valueOf(type.getNameId() != null ? type.getNameId() : type.getNameEn())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsBenefit.csv", bytes, contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Benefit
	public void importBenefit(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String _currentListPath = "/product/international_travel_standard_new/benefit/list.jsp";

		String filePath = "C:/liferayTmp/importBenefit.csv";
		List<String> csvHeadLines = Arrays.asList("Benefit ID","Name (Indonesia)", "Name (English)", "Sort", "Benefit Type ID", "Plan Name", "Benefit Value");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');
			//csvReader.setTextQualifier('"');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Industry.class.getName(), actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long benefitId = null;
			String nameId, nameEn, planName, benefitValue;
			int sort, active;
			Long benefitTypeId = null;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				// Apabila kolom id null, proses CRUD tetap berlanjut
				// dengan kondisi apabila null maka method update yang berjalan
				// apabila sebaliknya, maka method add yang berjalan
				String benefitIdCurrColVal = csvReader.get("Benefit ID");
				if (benefitIdCurrColVal != null && !benefitIdCurrColVal.equals(""))
					benefitId = Long.parseLong(benefitIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name (Indonesia)");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name (Indonesia).");
					continue;
				} else {
					nameId = nameCurrColVal;
				}

				String nameEnCurrColVal = csvReader.get("Name (English)");
				if (nameEnCurrColVal == null || nameEnCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name (English).");
					continue;
				} else {
					nameEn = nameEnCurrColVal;
				}

				String sortCurrColVal = csvReader.get("Sort");
				if (sortCurrColVal == null) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Sort.");
					continue;
				} else {
					sort = Integer.parseInt(sortCurrColVal);
				}
				
				String planNameCurrColVal = csvReader.get("Plan Name");
				if (planNameCurrColVal == null || planNameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Plan Name.");
					continue;
				} else {
					planName = planNameCurrColVal;
				}
				
				String benefitValueCurrColVal = csvReader.get("Benefit Value");
				if (benefitValueCurrColVal == null || benefitValueCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Benefit Value.");
					continue;
				} else {
					benefitValue = benefitValueCurrColVal;
				}

				String benefitTypeIdCurrColVal = csvReader.get("Benefit Type ID");
				if (benefitTypeIdCurrColVal != null && !benefitTypeIdCurrColVal.equals("")) {

					BenefitType _benType = _BenefitTypeLocalService
							.fetchBenefitType(Long.parseLong(benefitTypeIdCurrColVal));

					if (_benType != null) {
						benefitTypeId = Long.parseLong(benefitTypeIdCurrColVal);
					} else {
						invalid.append(
								"<br>Baris " + row + ", Kolom " + "Benefit Type ID - Benefit Type ID is not exist.");
						continue;
					}

				} else {
					invalid.append("<br>Baris " + row + ", Kolom " + "Benefit Type ID.");
					continue;
				}

				log.info(benefitId + "," + nameId + "," + nameEn + "," + sort + "," + 1 + "," + benefitTypeId);
				// Insert all evaluated data to database
				if (benefitId != null) {
					try {
						//_BenefitLocalService.updateBenefit(benefitId, benefitTypeId, nameId, nameEn, sort, 1);
//						_BenefitLocalService.updateBenefit(benefitId, benefitTypeId, nameId, nameEn, sort, 1, planName, benefitValue);
						log.info("InternationalTravelStandardNewAdminPortlet.importBenefit() update");

					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				} else {
					try {
						//_BenefitLocalService.addBenefit(nameId, nameEn, sort, 1, benefitTypeId);
//						_BenefitLocalService.addBenefit(nameId, nameEn, sort, 1, benefitTypeId ,planName ,benefitValue);
						log.info("InternationalTravelStandardNewAdminPortlet.importBenefit() add");
						
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", _currentListPath);

		} catch (Exception e) {
			log.info(e);
		}
	}

	// Export Plan
	private void exportPlan(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {
			long[] plans = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Plan ID", "Name (Indonesia)", "Name (English)", "Sort", "Active");

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
				List<Plan> _plans = _PlanLocalService.getPlans();

				for (Plan _plan : _plans) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_plan.getPlanId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_plan.getNameId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_plan.getNameEn())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_plan.getSort())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_plan.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (plans.length < 1)
					return;

				for (long planId : plans) {

					Plan _plan = _PlanLocalService.getPlan(planId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_plan.getPlanId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_plan.getNameId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_plan.getNameEn())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_plan.getSort())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_plan.getActive())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsPlan.csv", bytes, contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Plan
	public void importPlan(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String _currentListPath = "/product/international_travel_standard_new/plan/list.jsp";

		String filePath = "C:/liferayTmp/importPlan.csv";
		List<String> csvHeadLines = Arrays.asList("Plan ID","Name (Indonesia)", "Name (English)", "Sort");

		try (FileOutputStream fOut = new FileOutputStream(filePath);) {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			InputStream is = uploadRequest.getFileAsStream("importFile");
			int i;
			while ((i = is.read()) != -1) {
				fOut.write(i);
			}

			CsvReader csvReader = new CsvReader(new FileReader(filePath));
			csvReader.setDelimiter(';');
			//csvReader.setTextQualifier('"');

			csvReader.readHeaders();
			String[] headers = csvReader.getHeaders();
			if (!Arrays.asList(headers).containsAll(csvHeadLines)) {
				throw new RuntimeException("Cannot parse csv, expecting headers: [" + csvHeadLines.toString() + "]");
			}

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Industry.class.getName(), actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long planId = null;
			String nameId, nameEn;
			int sort, active;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				// Apabila kolom id null, proses CRUD tetap berlanjut
				// dengan kondisi apabila null maka method update yang berjalan
				// apabila sebaliknya, maka method add yang berjalan
				String planIdCurrColVal = csvReader.get("Plan ID");
				if (planIdCurrColVal != null && !planIdCurrColVal.equals(""))
					planId = Long.parseLong(planIdCurrColVal);

				String nameCurrColVal = csvReader.get("Name (Indonesia)");
				if (nameCurrColVal == null || nameCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name (Indonesia).");
					continue;
				} else {
					nameId = nameCurrColVal;
				}

				String nameEnCurrColVal = csvReader.get("Name (English)");
				if (nameEnCurrColVal == null || nameEnCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Name (English).");
					continue;
				} else {
					nameEn = nameEnCurrColVal;
				}

				String sortCurrColVal = csvReader.get("Sort");
				if (sortCurrColVal == null) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Sort.");
					continue;
				} else {
					sort = Integer.parseInt(sortCurrColVal);
				}

				log.info(planId + " , " + nameId + ", " + nameEn + ", " + sort + " , " + 1);

				// Insert all evaluated data to database
				if (planId != null) {
					try {
						_PlanLocalService.updatePlan(planId, nameId, nameEn, sort, 1);
						log.info("InternationalTravelStandardNewAdminPortlet.importPlan() >> Update");

					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				} else {
					try {
						_PlanLocalService.addPlan(nameId, nameEnCurrColVal, sort, 1);
						log.info("InternationalTravelStandardNewAdminPortlet.importPlan() >> add");
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", _currentListPath);

		} catch (Exception e) {
			log.info(e);
		}
	}

	/* PREMI */

	// Export Premi
	private void exportPremi(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		try {

			long[] premis = StringUtil.split(ParamUtil.getString(resourceRequest, "entryIds"), 0L);
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
			List<String> csvHeadLines = Arrays.asList("Premi ID", "Traveller Type", "Currency", "Basic", "Additional",
					"Annual", "Active", "Benefit", "Plan");

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
				List<Premi> _premis = _PremiLocalService.getPremis();

				for (Premi _premi : _premis) {
					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_premi.getPremiId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getTravellerType())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getCurrency())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getBasic())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getAdditional())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getAnnual())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getActive())));
						sb.append(COMMA);

						Benefit findBen = _BenefitLocalService.getBenefit(_premi.getBenefitId());
						sb.append(getCSVFormattedValue(String
								.valueOf(findBen.getNameId() != null ? findBen.getNameId() : findBen.getNameEn())));
						sb.append(COMMA);

						Plan findPlan = _PlanLocalService.getPlan(_premi.getPlanId());
						sb.append(getCSVFormattedValue(String
								.valueOf(findPlan.getNameId() != null ? findPlan.getNameId() : findPlan.getNameEn())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			} else {

				if (premis.length < 1)
					return;

				for (long premiId : premis) {

					Premi _premi = _PremiLocalService.getPremi(premiId);

					try {
						// Populate each column in row to single csv row
						sb.append(getCSVFormattedValue(String.valueOf(_premi.getPremiId())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getTravellerType())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getCurrency())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getBasic())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getAdditional())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getAnnual())));
						sb.append(COMMA);

						sb.append(getCSVFormattedValue(String.valueOf(_premi.getActive())));
						sb.append(COMMA);

						Benefit findBen = _BenefitLocalService.getBenefit(_premi.getBenefitId());
						sb.append(getCSVFormattedValue(String
								.valueOf(findBen.getNameId() != null ? findBen.getNameId() : findBen.getNameEn())));
						sb.append(COMMA);

						Plan findPlan = _PlanLocalService.getPlan(_premi.getPlanId());
						sb.append(getCSVFormattedValue(String
								.valueOf(findPlan.getNameId() != null ? findPlan.getNameId() : findPlan.getNameEn())));
						sb.append(COMMA);

						// Add new line
						sb.setIndex(sb.index() - 1);
						sb.append(CharPool.NEW_LINE);
					} catch (Exception e) {
						log.info(e);
					}
				}
			}

			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;

			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "ExportsPremi.csv", bytes, contentType);
			return;

		} catch (PortalException | IOException e) {
			log.info(e);
		}
	}

	// Import Premi
	public void importPremi(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		String _currentListPath = "/product/international_travel_standard_new/premi2/list.jsp";

		String filePath = "C:/liferayTmp/importPremi.csv";
		List<String> csvHeadLines = Arrays.asList("Premi ID","Traveller Type", "Currency", "Basic", "Additional",
				"Annual", "Benefit ID", "Plan ID");

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

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Industry.class.getName(), actionRequest);
			long userId = serviceContext.getUserId();

			// Error identifier
			int row = 0;
			StringBuilder invalid = new StringBuilder();
			String _tmp;

			Long premiId = null;
			String travellerType, currency;
			String basic, additional, annual;
			Long benefitId = null;
			Long planId = null;

			// Start read each record in file
			while (csvReader.readRecord()) {
				++row;

				// Apabila kolom id null, proses CRUD tetap berlanjut
				// dengan kondisi apabila null maka method update yang berjalan
				// apabila sebaliknya, maka method add yang berjalan
				String premiIdCurrColVal = csvReader.get("Premi ID");
				if (premiIdCurrColVal != null && !premiIdCurrColVal.equals(""))
					premiId = Long.parseLong(premiIdCurrColVal);

				String travellerTypeCurrColVal = csvReader.get("Traveller Type");
				if (travellerTypeCurrColVal == null || travellerTypeCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Traveller.");
					continue;
				} else {
					travellerType = travellerTypeCurrColVal;
				}

				String currencyCurrColVal = csvReader.get("Currency");
				if (currencyCurrColVal == null || currencyCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Currency.");
					continue;
				} else {
					currency = currencyCurrColVal;
				}

				String basicCurrColVal = csvReader.get("Basic");
				log.info("InternationalTravelStandardNewAdminPortlet.importPremi() >>basic : "+basicCurrColVal);
				
				if (basicCurrColVal == null || basicCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Basic.");
					continue;
				} else {
					basic = basicCurrColVal;
				}

				String additionalCurrColVal = csvReader.get("Additional");
				log.info("InternationalTravelStandardNewAdminPortlet.importPremi() >>additional : "+additionalCurrColVal);
				
				if (additionalCurrColVal == null || additionalCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Additional.");
					continue;
				} else {
					additional = additionalCurrColVal;
				}

				String annualCurrColVal = csvReader.get("Annual");
				log.info("InternationalTravelStandardNewAdminPortlet.importPremi() >>annual : "+annualCurrColVal);
				
				if (annualCurrColVal == null || annualCurrColVal.equals("")) {
					invalid.append("<br>Baris " + row + ", Kolom " + "Annual.");
					continue;
				} else {
					annual = annualCurrColVal;
				}

				String benefitIdCurrColVal = csvReader.get("Benefit ID");
				if (benefitIdCurrColVal != null && !benefitIdCurrColVal.equals("")) {

					Benefit _benefit = _BenefitLocalService.fetchBenefit(Long.parseLong(benefitIdCurrColVal));

					if (_benefit != null) {
						benefitId = Long.parseLong(benefitIdCurrColVal);
					} else {
						invalid.append("<br>Baris " + row + ", Kolom " + " ID - Benefit ID is not exist.");
						continue;
					}

				} else {
					invalid.append("<br>Baris " + row + ", Kolom " + "Benefit ID.");
					continue;
				}

				String planIdCurrColVal = csvReader.get("Plan ID");
				if (planIdCurrColVal != null && !planIdCurrColVal.equals("")) {

					Plan _plan = _PlanLocalService.fetchPlan(Long.parseLong(planIdCurrColVal));

					if (_plan != null) {
						planId = Long.parseLong(planIdCurrColVal);
					} else {
						invalid.append("<br>Baris " + row + ", Kolom " + " ID - Plan ID is not exist.");
						continue;
					}

				} else {
					invalid.append("<br>Baris " + row + ", Kolom " + "Plan ID.");
					continue;
				}

				log.info(premiId + "," + travellerType + "," + currency + "," + basic + ","
						+ additional + " ," + annual + "," + 1 + "," + benefitId + "," + planId);
				// Insert all evaluated data to database
				if (premiId != null) {
					try {
						_PremiLocalService.updatePremi(premiId, benefitId, planId, travellerType, currency,
								new BigDecimal(basic), new BigDecimal(additional), new BigDecimal(annual), 1);
						log.info("InternationalTravelStandardNewAdminPortlet.importPremi() update");						
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-update-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				} else {
					try {
						_PremiLocalService.addPremi(travellerType, currency, new BigDecimal(basic),
								new BigDecimal(additional), new BigDecimal(annual), 1, benefitId, planId);
						log.info("InternationalTravelStandardNewAdminPortlet.importPremi() add");
					} catch (Exception e) {
						SessionErrors.add(actionRequest, "data-add-failed");
						log.info(e);
						actionResponse.setRenderParameter("mvcPath", _currentListPath);
					}
				}
			}

			String _error = invalid.toString();
			if (_error.length() > 0) {
				SessionErrors.add(actionRequest, _error);
				log.info(_error);
			}

			actionResponse.setRenderParameter("mvcPath", _currentListPath);

		} catch (Exception e) {
			log.info(e);
		}
	}

	private boolean _setGuestPermission(ThemeDisplay themeDisplay, String name, long primKey) {
		Map<Long, String[]> roleIdsToActionIds = new HashMap<>();
		roleIdsToActionIds.put(
				RoleLocalServiceUtil.fetchRole(themeDisplay.getCompanyId(), RoleConstants.GUEST).getRoleId(),
				new String[] { ActionKeys.VIEW });

		try {
			ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(), name,
					ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(primKey), roleIdsToActionIds);

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

	public String getConfig(String key) {
		String result = StringPool.BLANK;

		try {
			String currentDir = System.getProperty("catalina.base");
			String filePath = currentDir + "/../agency-portal.json";

			JsonElement jsonElement = JsonParser.parseReader(new FileReader(filePath));
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			if (Validator.isNotNull(jsonObject))
				result = jsonObject.get(key).toString().replace("\"", "");
		} catch (Exception e) {
			log.info(e);
		}

		return result;
	}

	private static final Object[] _IMAGE_EXTENSIONS = { ".gif", ".jpeg", ".jpg", ".png", ".svg" };
	private static final long _IMAGE_MAX_SIZE = 5242880;

	private static final Log log = LogFactoryUtil.getLog(InternationalTravelStandardNewAdminPortlet.class);

	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;

	@Reference
	private ProductConfigurationLocalService _productConfigurationLocalService;

	@Reference
	private IntTravelStandardNewPremiLocalService _intTravelStandardNewPremiLocalService;

	@Reference
	private BenefitTypeLocalService _BenefitTypeLocalService;

	@Reference
	private BenefitLocalService _BenefitLocalService;

	@Reference
	private PlanLocalService _PlanLocalService;

	@Reference
	private PremiLocalService _PremiLocalService;
	
	@Reference
	private BenefitValueMappingLocalService _benefitValueMappingLocalService;

}
