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
import com.mypage.admin.product.constants.InternationalTravelAdminPortletKeys;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.service.ProductConfigurationLocalService;
import com.mypage.admin.product.service.TravelInternationalPremiLocalService;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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

@Component(immediate = true, property = { "com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=mypage", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/internationaltravel_admin.css",
		"com.liferay.portlet.layout-cacheable=true", "com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false", "com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=International Travel Admin", "javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/product/international_travel/configuration.jsp",
		"javax.portlet.name=" + InternationalTravelAdminPortletKeys.IT_ADMIN,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",

}, service = Portlet.class)
public class InternationalTravelAdminPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletURL webContentURL = null;

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getScopeGroupId();

			ProductConfiguration _conf = _productConfigurationLocalService
					.getConfigByCode(InternationalTravelAdminPortletKeys.PRODUCT_CODE);

			if (!Validator.isNull(_conf) && _conf.getWebContentFolderId() > 0) {
				int webContentFolderId = _conf.getWebContentFolderId();

				webContentURL = PortletURLFactoryUtil.create(renderRequest,
						"com_liferay_journal_web_portlet_JournalPortlet", renderRequest.RENDER_PHASE);
				webContentURL.setWindowState(WindowState.MAXIMIZED);
				webContentURL.setPortletMode(PortletMode.VIEW);
				webContentURL.setParameter("_com_liferay_journal_web_portlet_JournalPortlet_groupId",
						String.valueOf(groupId));
				webContentURL.setParameter("_com_liferay_journal_web_portlet_JournalPortlet_folderId",
						String.valueOf(webContentFolderId));
				webContentURL.setParameter("_com_liferay_journal_web_portlet_JournalPortlet_displayStyle",
						"descriptive");
			}
		} catch (Exception e) {
			throw new PortletException(e);
		}

		renderRequest.setAttribute("webContentURL", webContentURL);
		super.render(renderRequest, renderResponse);
	}

	// UPDATE CONFIGURATION
	public void updateProductConfiguration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(InternationalTravelAdminPortlet.class.getName(),
				actionRequest);

		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

//		String productCode = InternationalTravelAdminPortletKeys.PRODUCT_CODE;
		String productCode = "ITTEST";
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

		// Product Icon Upload
		File iconFile = uploadRequest.getFile("iconFile");

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
				String uniqueFileName = _uniqueFileNameProvider.provide(iconFileName,
						curFileName -> _exists(themeDisplay, folderId, curFileName));
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
				// validate file
//				_validateFile(iconFileName, iconFileContentType, uploadRequest.getSize("iconFile"));
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
	
	/**
	 * CREATE/UPDATE PREMI
	 */
	public void updatePremi(ActionRequest request, ActionResponse response) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(InternationalTravelAdminPortlet.class.getName(),request);
		long userId = serviceContext.getUserId();
		long premiId = ParamUtil.getLong(request, "premiId");
		String packageType = ParamUtil.getString(request, "package_type");
		String peopleType = ParamUtil.getString(request, "traveller_type");
		int adultCount = ParamUtil.getInteger(request, "adult_count");
		int childrenCount = ParamUtil.getInteger(request, "children_count");
		String currency = ParamUtil.getString(request, "currency");
		BigDecimal amount = new BigDecimal(ParamUtil.getString(request, "amount"));
		int minDuration = ParamUtil.getInteger(request, "min_duration");
		int maxDuration = ParamUtil.getInteger(request, "max_duration");
		int active = ParamUtil.getInteger(request, "active");
		
//		ParamUtil.print(request);

		try {
			_travelInternationalPremiLocalService.addPremi(userId, premiId, packageType, peopleType, adultCount, childrenCount, currency, amount, minDuration, maxDuration, active, serviceContext);
			response.setRenderParameter("mvcPath", "/product/international_travel/premi/list.jsp");
			SessionMessages.add(request, "dataUpdated");
		} catch (Exception e) {
			log.info(e);
			PortalUtil.copyRequestParameters(request, response);

			SessionErrors.add(request, e.getClass().getName());
			response.setRenderParameter("mvcPath", "/product/international_travel/premi/edit.jsp");
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
			if (log.isDebugEnabled()) {
				log.debug(portalException, portalException);
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

	private static final Object[] _IMAGE_EXTENSIONS = { ".gif", ".jpeg", ".jpg", ".png", ".svg" };
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log log = LogFactoryUtil.getLog(InternationalTravelAdminPortlet.class);

	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;

	@Reference
	private ProductConfigurationLocalService _productConfigurationLocalService;
	
	@Reference
	private TravelInternationalPremiLocalService _travelInternationalPremiLocalService;
}
