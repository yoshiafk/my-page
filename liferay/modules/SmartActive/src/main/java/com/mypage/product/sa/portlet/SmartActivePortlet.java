package com.mypage.product.sa.portlet;

import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.SmartActiveBenefit;
import com.mypage.admin.product.model.SmartActiveBenefitType;
import com.mypage.admin.product.model.SmartActiveBenefitValue;
import com.mypage.admin.product.model.SmartActiveFeature;
import com.mypage.admin.product.model.SmartActiveLink;
import com.mypage.admin.product.model.SmartActiveOccupation;
import com.mypage.admin.product.model.SmartActivePremi;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitValueLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveFeatureLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveLinkLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveOccupationLocalServiceUtil;
import com.mypage.admin.product.service.SmartActivePremiLocalServiceUtil;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.leads.model.DetailSmartactive;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.DetailSmartactiveLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalServiceUtil;
import com.mypage.product.sa.constants.SmartActivePortletKeys;
import com.mypage.product.sa.helpers.ActionHelper;
import com.mypage.product.sa.helpers.EncryptionHelper;
import com.mypage.product.sa.helpers.XSSValidator;
import com.mypage.product.sa.service.TransactionService;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.model.JournalArticleModel;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Smart Active",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/step1.jsp",
		"javax.portlet.name=" + SmartActivePortletKeys.SMARTACTIVE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SmartActivePortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		//GET PARAM URL IFRAME
		
		String aParam = ParamUtil.getString(httpRequest, "a"); // Token liferay | dari api liferay (khusus jika login)
		String bParam = ParamUtil.getString(httpRequest, "b"); // Token liferay | dari api liferay (khusus jika login)
		String lParam = ParamUtil.getString(httpRequest, "l"); // LiferayId | dari parameter q dari halaman penawaran
		String rcParam = ParamUtil.getString(httpRequest, "rc"); // ManagedBy B2B | dari URL
		String puParam = ParamUtil.getString(httpRequest, "pu"); // Pretty Url | dari URL
		String qtParam = ParamUtil.getString(httpRequest, "qt"); // o_id Leads | dari parameter q dari halaman penawaran
		String qeParam = ParamUtil.getString(httpRequest, "qe"); // continue | edit
		String qqParam = ParamUtil.getString(httpRequest, "qq"); // dari iframe qq -> quote type : simple | full
		String qpParam = ParamUtil.getString(httpRequest, "qp"); // dari iframe qp -> pep : true : false
		String pcParam = ParamUtil.getString(httpRequest, "pc"); // PromoCode | dari URL
		String mobileParam = ParamUtil.getString(httpRequest, "mobile");
		String utm_source = ParamUtil.getString(httpRequest, "utm_source");
		String utm_medium = ParamUtil.getString(httpRequest, "utm_medium");
		String utm_campaign = ParamUtil.getString(httpRequest, "utm_campaign");
		String utm_term = ParamUtil.getString(httpRequest, "utm_term");
		String utm_content = ParamUtil.getString(httpRequest, "utm_content");
		String path = ParamUtil.getString(httpRequest, "_".concat(SmartActivePortletKeys.SMARTACTIVE).concat("_mvcPath"));
		
		String l = StringPool.BLANK;
		String qt = StringPool.BLANK; // ini nantinya pas dikirim ke pimcore namanya QuoteId
		String pc = StringPool.BLANK;
		String pu = StringPool.BLANK;
		String _managedBy = StringPool.BLANK;
		String _managedById = StringPool.BLANK;
		String mobile = StringPool.BLANK;

		String businessModel = "B2C";
		String _token = StringPool.BLANK;
		
		long lId = 0L;

		// B2B
		try {
			if (!Validator.isBlank(aParam)) {
				_token = EncryptionHelper.decrypt(aParam);
				AgentToken agentToken = _agentTokenLocalService.getAgentTokenByToken(_token);
				if (agentToken != null) {
					_managedBy = agentToken.getDeptCode();
					businessModel = "B2B";
					
					renderRequest.setAttribute("a", aParam);
				}
			}
		} catch (Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}

		// L PARAM (Continue/Edit Quotation)
		if (!lParam.isEmpty() && lParam != null) {
			try {
				String lParamDecrypted = EncryptionHelper.decrypt(lParam);
				String[] lParamDecryptedSplit = lParamDecrypted.split("\\|");
				long _leadsId = Long.valueOf(lParamDecryptedSplit[1]);
				lId = _leadsId;
				qt = qtParam;
				l = lParam;
			} catch (Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
			}
		}

		// RC PARAM
		if (!rcParam.isEmpty() && rcParam != null) {
			try {
				String rcParamDecrypted = EncryptionHelper.decrypt(rcParam);
				String[] rcParamDecryptedSplit = rcParamDecrypted.split("\\|");
				String rc = rcParamDecryptedSplit[1];
				if (_managedBy.isEmpty()) {
					businessModel = "B2B2C";
					_managedBy = rc;
				}
				renderRequest.setAttribute("rc", rc);
			} catch (Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
			}
		}

		// PC PARAM
		if (!pcParam.isEmpty() && pcParam != null) {
			try {
				pc = pcParam;
			} catch (Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
			}
		}
		
		// PU PARAM
		if (!puParam.isEmpty() && puParam != null) {
			try {
				pu = puParam;
			} catch (Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
			}
		}
		
		// MOBILE PARAM
		if (!mobileParam.isEmpty() && mobileParam != null) {
			try {
				mobile = mobileParam;
			} catch (Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
			}
		}

		renderRequest.setAttribute("lId", lId);
		renderRequest.setAttribute("l", l);
		renderRequest.setAttribute("qt", qt);
		renderRequest.setAttribute("pc", pc);
		renderRequest.setAttribute("pu", pu);
		renderRequest.setAttribute("mobile", mobile);
		
		if (!bParam.isEmpty() && bParam != null) {
			String agentRole = StringPool.BLANK;
			String agentCode = StringPool.BLANK;
			String agentName = StringPool.BLANK;
			String agentDeptCode = StringPool.BLANK;
			try {
				String bDecrypt = EncryptionHelper.decrypt(bParam);
				String[] bDecryptSplit = bDecrypt.split("\\|");
				
				JSONObject objectB = JSONFactoryUtil.createJSONObject(bDecryptSplit[1]);
				if (helper.isLog()) _log.info(objectB);
				
				_managedById = objectB.has("UserId") ? objectB.getString("UserId") : StringPool.BLANK;
				agentRole = objectB.has("Role") ? objectB.getString("Role") : agentRole;
				agentCode = objectB.has("Code") ? objectB.getString("Code") : agentCode;
				agentName = objectB.has("Name") ? objectB.getString("Name") : agentName;
				agentDeptCode = objectB.has("DeptoreCode") ? objectB.getString("DeptoreCode") : agentDeptCode;
			} catch (Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
			}
			renderRequest.setAttribute("agentRole", agentRole);
			renderRequest.setAttribute("agentCode", agentCode);
			renderRequest.setAttribute("agentName", agentName);
			renderRequest.setAttribute("agentDeptCode", agentDeptCode);
			renderRequest.setAttribute("b", bParam);
		}
		
		renderRequest.setAttribute("businessModel", businessModel);
		renderRequest.setAttribute("managedBy", _managedBy);
		renderRequest.setAttribute("managedById", _managedById);
		renderRequest.setAttribute("qe", qeParam);
		renderRequest.setAttribute("qq", qqParam);
		renderRequest.setAttribute("qp", qpParam);
		renderRequest.setAttribute("utm_source", utm_source);
		renderRequest.setAttribute("utm_medium", utm_medium);
		renderRequest.setAttribute("utm_campaign", utm_campaign);
		renderRequest.setAttribute("utm_term", utm_term);
		renderRequest.setAttribute("utm_content", utm_content);
		
		//END GET PARAM URL
		
		if (path.isEmpty() || path.contains("step1") == true) {
			ProductConfiguration product = ProductConfigurationLocalServiceUtil.getConfigByCode("SA");

			List<SmartActiveBenefitType> benefitTypes = SmartActiveBenefitTypeLocalServiceUtil.getActiveBenefitType();
			List<SmartActiveBenefit> benefits = SmartActiveBenefitLocalServiceUtil.getActiveBenefit();
			List<SmartActiveBenefit> mainCover = null, allowances = null, otherCover = null;
			
			for (SmartActiveBenefitType item : benefitTypes) {
				if (item.getNameId().equalsIgnoreCase("jaminan utama"))
					mainCover = benefits.stream().filter(v -> v.getSmartActiveBenefitTypeId() == item.getSmartActiveBenefitTypeId())
								.map(v -> {
									String encryptedId = StringPool.BLANK;
									try {
										encryptedId = EncryptionHelper.encrypt(String.valueOf(v.getSmartActiveBenefitId()));
									} catch (Exception e) {
										if (helper.isLog()) _log.info(e.getMessage());
									}
									v.setUserName(encryptedId);
									return v;
								})
								.collect(Collectors.toList());
				
				if (item.getNameId().equalsIgnoreCase("santunan"))
					allowances = benefits.stream().filter(v -> v.getSmartActiveBenefitTypeId() == item.getSmartActiveBenefitTypeId())
								 .map(v -> {
									 String encryptedId = StringPool.BLANK;
									 try {
										 encryptedId = EncryptionHelper.encrypt(String.valueOf(v.getSmartActiveBenefitId()));
									 } catch (Exception e) {
										 if (helper.isLog()) _log.info(e.getMessage());
									 }
									 v.setUserName(encryptedId);
									 return v;
								 })
								 .collect(Collectors.toList());
				
				if (item.getNameId().equalsIgnoreCase("jaminan lainnya"))
					otherCover = benefits.stream().filter(v -> v.getSmartActiveBenefitTypeId() == item.getSmartActiveBenefitTypeId())
								 .map(v -> {
									 String encryptedId = StringPool.BLANK;
									 try {
										 encryptedId = EncryptionHelper.encrypt(String.valueOf(v.getSmartActiveBenefitId()));
									 } catch (Exception e) {
										 if (helper.isLog()) _log.info(e.getMessage());
									 }
									 v.setUserName(encryptedId);
									 return v;
								 })
								 .collect(Collectors.toList());
			}
			
			HashMap<Long, String> faqContents = new HashMap<Long, String>();
			List<Map.Entry<Long, String>> sortedFaqContents = new ArrayList<>();
			String descriptionContent = StringPool.BLANK;
			String productAdvantagesContent = StringPool.BLANK;
			
			try {
				long _folderId = JournalFolderLocalServiceUtil.getFolders(groupId).stream()
								 .filter(v -> v.getName().equalsIgnoreCase("faq"))
								 .findFirst().get().getFolderId();
				
				Map<String, JournalArticle> _faqContents = JournalArticleLocalServiceUtil.getArticles(groupId, _folderId).stream()
														  .collect(Collectors.toMap(
																  JournalArticle::getArticleId,
																  article -> article,
																  (existing, replacement) -> ((JournalArticleModel) existing).getVersion() > ((JournalArticleModel) replacement).getVersion() ? existing : replacement
														  ));
				
				_faqContents.forEach((articleId, article) -> {
			    try {
			    	JournalArticleDisplay _faqContentDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
							articleId, "", themeDisplay.getLocale().toString(), themeDisplay);
			    	faqContents.put(Long.valueOf(articleId), _faqContentDisplay.getContent());
			    } catch (Exception e) {
			    	if (helper.isLog()) _log.info(e.getMessage());
			    }});
				
				sortedFaqContents.addAll(faqContents.entrySet());
				sortedFaqContents.sort(Map.Entry.comparingByKey());
				
				JournalArticle _descriptionContent = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, "smartactive-description");
				JournalArticleDisplay _descriptionContentDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
						_descriptionContent.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay);
				descriptionContent = _descriptionContentDisplay.getContent();
				
				JournalArticle _productAdvantagesContent = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, "smartactive-product-advantages");
				JournalArticleDisplay _productAdvantagesContentDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
						_productAdvantagesContent.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay);
				productAdvantagesContent = _productAdvantagesContentDisplay.getContent();
			} catch(Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
			}

			List<SmartActiveFeature> features = SmartActiveFeatureLocalServiceUtil.getActiveFeature();

			renderRequest.setAttribute("productName", product.getProductName());
			renderRequest.setAttribute("price", getLowerPrice());
			renderRequest.setAttribute("mainCover", mainCover);
			renderRequest.setAttribute("allowances", allowances);
			renderRequest.setAttribute("otherCover", otherCover);
			renderRequest.setAttribute("faqContents", sortedFaqContents);
			renderRequest.setAttribute("features", features);
			renderRequest.setAttribute("descriptionContent", descriptionContent);
			renderRequest.setAttribute("productAdvantagesContent", productAdvantagesContent);
		}
		
		if (path.contains("step1") == false || path.contains("step2") == false) {
			String occupationExceptionContent = StringPool.BLANK;
			
			try {
				JournalArticle _occupationExceptionContent = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, "smartactive-occupation-exception");
				JournalArticleDisplay _occupationExceptionContentDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
						_occupationExceptionContent.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay);
				occupationExceptionContent = _occupationExceptionContentDisplay.getContent();
			} catch (Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
			}
			
			renderRequest.setAttribute("occupationExceptionContent", occupationExceptionContent);
		}

		if (path.contains("step1") == false || path.contains("step4") == false) {
			List<SmartActiveOccupation> occupations = SmartActiveOccupationLocalServiceUtil.getActiveOccupation();
			renderRequest.setAttribute("occupations", occupations);
		}
		
		if (path.contains("step2") == true || path.contains("continue") == true) {
			List<SmartActiveBenefitValue> valueMainbenefit = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue();
			renderRequest.setAttribute("mainBenefitValue", valueMainbenefit);
		}
		
		/**
		 * BY SAFAR for web content in RIPLAY STEP
		 */

		if (path.contains("step4") == true) {
			String riplayVersi = "personal"; // umum/personal
	
			// Web Content
			String infoProduk = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-informasi-produk", themeDisplay);
			String fiturUtama = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-fitur-utama", themeDisplay);
			String manfaat = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-manfaat", themeDisplay);
			String risiko = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-risiko", themeDisplay);
			String biaya = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-biaya", themeDisplay);
			String pengecualian = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-pengecualian", themeDisplay);
			String persyaratan = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-persyaratan", themeDisplay);
			String simulasi = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-simulasi", themeDisplay);
			String infoTambahan = ActionHelper.getWebContentByFriendlyUrl("sa-"+riplayVersi+"-info-tambahan", themeDisplay);
			
			renderRequest.setAttribute("info-produk", infoProduk);
			renderRequest.setAttribute("fitur-utama", fiturUtama);
			renderRequest.setAttribute("manfaat", manfaat);
			renderRequest.setAttribute("risiko", risiko);
			renderRequest.setAttribute("biaya", biaya);
			renderRequest.setAttribute("pengecualian", pengecualian);
			renderRequest.setAttribute("persyaratan", persyaratan);
			renderRequest.setAttribute("simulasi", simulasi);
			renderRequest.setAttribute("info-tambahan", infoTambahan);
		}
		
		if (path.contains("step3") == true) {
			PIMCORE_HOST = helper.getPimcoreAddr();
			apiCountry = helper.getConfig("com.mypage.client.api.liferay.countries");
			apiProvince = helper.getConfig("product.api.provinces");
			
			JSONArray countries = getApiPimcore(PIMCORE_HOST.concat(apiCountry));
			JSONArray provinces = getApiPimcore(PIMCORE_HOST.concat(apiProvince));
			
			List<JSONObject> countryList = new ArrayList<>();

		    // Convert JSONArray ke List<JSONObject>
			if (countries.length() > 0) {
				try {
					for (int i = 0; i < countries.length(); i++) {
						JSONObject data = JSONFactoryUtil.createJSONObject(countries.get(i).toString());
				        countryList.add(data);
					}
			    } catch (JSONException e) {
			    	if (helper.isLog()) _log.info(e.getMessage());
				}

			    // Sort ascending by "name", with "Indonesia" on top
			    Collections.sort(countryList, new Comparator<JSONObject>() {
			        @Override
			        public int compare(JSONObject o1, JSONObject o2) {
			            String name1 = o1.getString("name");
			            String name2 = o2.getString("name");

			            if (name1.equalsIgnoreCase("Indonesia")) return -1;
			            if (name2.equalsIgnoreCase("Indonesia")) return 1;

			            return name1.compareToIgnoreCase(name2);
			        }
			    });
			}
			
			boolean isScanOcrboolean = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("IT6").stream()
					.filter(v -> v.getName().equalsIgnoreCase("Scan OCR") && v.getActive() == 1).findFirst().map(v -> {
						if (v.getValue() == null || v.getValue().isEmpty()) {
							return false;
						}
						return Long.parseLong(v.getValue()) == 1;
					}).orElse(false);
			
			renderRequest.setAttribute("countries", countryList);
			renderRequest.setAttribute("provinces", provinces);
			renderRequest.setAttribute("isScanOcr", isScanOcrboolean);
		}
		
		List<SmartActiveLink> files = SmartActiveLinkLocalServiceUtil.getActiveLink();
		renderRequest.setAttribute("files", files);
		
		List<MasterGlobalVariable> medias = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Social Media");
		renderRequest.setAttribute("medias", medias);
		
		// Set CSRF Token
		String _secureToken = EncryptionHelper.generateSecureToken(32);
		renderRequest.getPortletSession().setAttribute("CSRF_TOKEN", _secureToken, PortletSession.PORTLET_SCOPE);
    	
    	renderRequest.setAttribute("CSRF_TOKEN", _secureToken);
    	
    	_log.info(renderRequest.getPortletSession().getAttribute("CSRF_TOKEN", PortletSession.PORTLET_SCOPE));
		
//		 Cek semua render attribute - for debug purpose only
//		Enumeration<String> renderSmartActiveAttributes = renderRequest.getAttributeNames();
//		while (renderSmartActiveAttributes.hasMoreElements()) {
//            System.out.println(renderSmartActiveAttributes.nextElement());
//        }
		
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
			
		try {
			if (resourceID.equalsIgnoreCase("uploadimage")) {
				uploadImage(resourceRequest, resourceResponse);
			} else if (resourceID.equalsIgnoreCase("getcities")) {
				getCities(resourceRequest, resourceResponse);
			} else if (resourceID.equalsIgnoreCase("getLeads")) {
				getLeads(resourceRequest, resourceResponse);
			} else if (resourceID.equalsIgnoreCase("settransaction")) {
				setTransaction(resourceRequest, resourceResponse);
			} else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		} catch(Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}
	}
	
	public void uploadImage(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		JSONObject _responseOCR = null;
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActivePortlet.class.getName(),
				resourceRequest);
		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		String leadToken = ParamUtil.getString(uploadPortletRequest, "token", "");
		
		Leads _leads = null;
		
		String host = helper.getLiferayHost();
		String imagePath = StringPool.BLANK;
		String uniqueFileName = StringPool.BLANK;
		String imageId = StringPool.BLANK;
		long imageFileEntryId = 0;
		
		String csrfTokenFromSession = (String) resourceRequest.getPortletSession().getAttribute("CSRF_TOKEN", PortletSession.PORTLET_SCOPE);
		String secureToken = EncryptionHelper.generateSecureToken(32);
		
		_log.info(csrfTokenFromSession);
		_log.info(ParamUtil.getString(uploadPortletRequest, "tokenLimiter"));
		
		boolean isValidCsrfToken = Validator.isNotNull(csrfTokenFromSession) && ParamUtil.getString(uploadPortletRequest, "tokenLimiter").equalsIgnoreCase(csrfTokenFromSession);
		
		resourceRequest.getPortletSession().setAttribute("CSRF_TOKEN", secureToken, PortletSession.PORTLET_SCOPE);
    	_data.put("tokenLimiter", secureToken);
    	
		if (!isValidCsrfToken) {
	    	_response.put("Status", 0);
	    	_response.put("Message", "Terjadi kesalahan, silakan coba beberapa saat lagi.");
	    	_response.put("Data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return; 
		}
		
		if (Validator.isNotNull(uploadPortletRequest.getFileName("file"))) {
			File imageFile = uploadPortletRequest.getFile("file");
			String imageFileName = uploadPortletRequest.getFileName("file");
			String fileExtension = imageFileName.substring(imageFileName.lastIndexOf("."));

			if (Validator.isNotNull(imageFileName)) {
				try {
					_leads = LeadsLocalServiceUtil.findByToken(leadToken);
				} catch(Exception e) {
					_response.put("Status", 0);
					_response.put("Message", "Gagal mengunggah gambar, data leads tidak ditemukan.");
					_response.put("Data", _data);

					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				String imageFileContentType = uploadPortletRequest.getContentType("file");
				
				// validate file
				try {
					_validateFile(imageFileName, imageFileContentType, uploadPortletRequest.getSize("file"));
				} catch(Exception e) {
					_response.put("Status", 0);
					_response.put("Message", "Gagal mengunggah gambar, harap gunakan format gambar (jpg, jpeg, png, gif, bmp, webp) atau dengan ukuran yang lebih kecil.");
					_response.put("Data", _data);

					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				// get user folder
				DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, "Kyc-Image");
				if (userFolder == null) {
					userFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							themeDisplay.getScopeGroupId(), false, 0, "Kyc-Image", "", false, serviceContext);
				}
				
				_setGuestPermission(themeDisplay, DLFolder.class.getName(), userFolder.getPrimaryKey());
				
				long folderId = userFolder.getFolderId();
				
				// set filename
				uniqueFileName = System.currentTimeMillis() + fileExtension;
				
				// add file
				FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
		                repositoryId, folderId, uniqueFileName, 
		                imageFileContentType, uniqueFileName, "", "", 
		                imageFile, serviceContext
		        );
				
				_setGuestPermission(themeDisplay, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());
				
				imageFileEntryId = fileEntry.getFileEntryId();
				fileEntry = DLAppLocalServiceUtil.getFileEntry(imageFileEntryId);
//				imagePath = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getFileName();
				imageId = EncryptionHelper.encrypt(String.valueOf(imageFileEntryId));
				imagePath = host.concat("/o/api/sa/images/").concat(imageId).concat("/").concat(uniqueFileName);
				
//				LeadsLocalServiceUtil.setIdPhoto(_leads.getLeadsId(), imageFileEntryId, imagePath);
				
				String OCR_CLIENT_HOST_URL = helper.getOcrClientHost();
				
				String OCR_PATH_URL = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Glair").stream()
						  			  .filter(v -> v.getName().equalsIgnoreCase("endpoint ktp") && v.getActive() == 1).findFirst()
					  			  	  .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "" : v.getValue()).orElse("");
				
				String API_KEY = helper.getOcrClientKey();
				String AUTH_HEADERS = helper.getOcrClientAuth();
				String ocrRequestUrl = OCR_CLIENT_HOST_URL + OCR_PATH_URL;
				String response = helper.hitApiOCR(ocrRequestUrl, imageFile, API_KEY, AUTH_HEADERS, imageFileContentType);
				_responseOCR = JSONFactoryUtil.createJSONObject(response);
				
				_log.info(_responseOCR.toString());
			}
		}
		
		_data.put("preview", imagePath);
		_data.put("name", uniqueFileName);
		_data.put("imageId", imageId);
		_data.put("ocr", _responseOCR);
		_response.put("Status", 1);
		_response.put("Message", "");
		_response.put("Data", _data);

		resourceResponse.getWriter().write(_response.toString());
		return;
	}
	
	public void getCities(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		JSONArray cities = JSONFactoryUtil.createJSONArray();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		long provinceId = 0L;
		
		if (Validator.isNotNull(ParamUtil.getString(httpRequest, "target"))) {
			String param = EncryptionHelper.decrypt(ParamUtil.getString(httpRequest, "target"));
			String[] paramSplit = param.split("\\|");
			provinceId = Long.parseLong(paramSplit[1]);
		}
		
		PIMCORE_HOST = helper.getPimcoreAddr();
		apiProvince = helper.getConfig("product.api.provinces");
		
		try {
			JSONObject cityResponse = ActionHelper.hitAPI(PIMCORE_HOST.concat(apiProvince).concat("/").concat(String.valueOf(provinceId)).concat("/cities"), "", "");
			
			if (cityResponse.has("statusCode")) {
		    	if (cityResponse.getInt("statusCode") != 200) {
		    		_response.put("Status", 0);
					_response.put("Message", "Gagal request ke server.");

					resourceResponse.getWriter().write(_response.toString());
					return;
		    	}
		    }
			
			JSONObject cityResponseDto = JSONFactoryUtil.createJSONObject(cityResponse.get("response").toString());
			
			if (cityResponseDto.getInt("Status") == 0) {
				_response.put("Status", 0);
				_response.put("Message", "Data tidak ditemukan.");

				resourceResponse.getWriter().write(_response.toString());
				return;
			}
			
			for (int i = 0; i < cityResponseDto.getJSONArray("Data").length(); i++) {
				JSONObject data = JSONFactoryUtil.createJSONObject(cityResponseDto.getJSONArray("Data").get(i).toString());
				JSONObject dto = JSONFactoryUtil.createJSONObject();
				
				dto.put("name", data.getString("Name"));
				
				cities.put(dto);
			}
		} catch (Exception e) {
			_response.put("Status", 0);
			_response.put("Message", "Gagal request ke server.");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		_data.put("cities", cities);
		_response.put("Status", 1);
		_response.put("Message", "");
		_response.put("Data", _data);

		resourceResponse.getWriter().write(_response.toString());
		return;
	}
	
	public void getLeads(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		JSONObject _leads = JSONFactoryUtil.createJSONObject();
		JSONObject _detailLeads = JSONFactoryUtil.createJSONObject();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		String token = ParamUtil.getString(httpRequest, "target", "");
		String step = sanitizer.sanitizeHtml(ParamUtil.getString(httpRequest, "step", ""));
		String paramImg = ParamUtil.getString(httpRequest, "imageId", "");
		long imageId = 0L;
		
		if (Validator.isNotNull(paramImg)) {
			imageId = Long.parseLong(EncryptionHelper.decrypt(paramImg));
		}
		
		Leads leads = null;
		DetailSmartactive detailLeads = null;
		String host = helper.getLiferayHost();
		
		try {
			leads = LeadsLocalServiceUtil.findByToken(token);
			
			if (step.equalsIgnoreCase("one")) {
				detailLeads = DetailSmartactiveLocalServiceUtil.findByLeadsId(leads.getLeadsId());
				
				_detailLeads.put("excludedActivityStatus", detailLeads.getExcludedActivityStatus());
				_detailLeads.put("mainBenefitValue", detailLeads.getMainBenefitValue());
				_detailLeads.put("startPeriod", detailLeads.getStartPeriode());
				_detailLeads.put("endPeriod", detailLeads.getEndPeriode());
				_detailLeads.put("listBenefit", detailLeads.getListBenefitId());
			}
			
			if (step.equalsIgnoreCase("two")) {
				_leads.put("isPep", leads.getIsPep());
				
				if (imageId > 0) {
					if (Validator.isNull(leads.getPhotoFileUrl()) == true) {
						FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(imageId);
						String uniqueFileName = System.currentTimeMillis() + "." + fileEntry.getExtension();
						_leads.put("preview", host.concat("/o/api/sa/images/").concat(paramImg).concat("/").concat(uniqueFileName));
					} else {
						_leads.put("preview", leads.getPhotoFileUrl());
					}
				
					_leads.put("imgName", leads.getNationality().equalsIgnoreCase("Indonesia") == true ? "KTP" : leads.getNationality().toLowerCase().equals("Indonesia") == false ? "KITAS" : "");
				}
				
				if (Validator.isNotNull(leads.getIdPhotoFileEntryId()) && Validator.isNotNull(leads.getPhotoFileUrl())) {
					_leads.put("imageId", EncryptionHelper.encrypt(String.valueOf(leads.getIdPhotoFileEntryId())));
					_leads.put("preview", leads.getPhotoFileUrl());
					_leads.put("imgName", leads.getNationality().equalsIgnoreCase("Indonesia") == true ? "KTP" : leads.getNationality().equalsIgnoreCase("Indonesia") == false ? "KITAS" : "");
				}
				
				_leads.put("name", leads.getName());
				_leads.put("nationality", leads.getNationality());
				_leads.put("idNumber", leads.getNationality().equalsIgnoreCase("Indonesia") == true ? leads.getIdNumber() : leads.getKitasNumber());
				_leads.put("birthDate", leads.getDob());
				_leads.put("age", leads.getAge());
				_leads.put("birthPlace", leads.getBirthPlace());
				_leads.put("gender", leads.getGender());
				_leads.put("phoneNumber", leads.getMobilePhone());
				_leads.put("email", leads.getEmail());
				_leads.put("zip", leads.getZip());
				_leads.put("province", leads.getProvince());
				_leads.put("city", leads.getCity());
				_leads.put("address", leads.getAddress());
				_leads.put("job", leads.getJob());
				_leads.put("workLocation", leads.getWorkLocation());
				if (leads.getWorkLocation().equalsIgnoreCase("lainnya")) _leads.put("additionalWorkLocation", leads.getWorkLocationOther());
				_leads.put("monthlyIncome", leads.getMonthlyIncome());
				_leads.put("paymentSource", leads.getPaymentSource());
				if (leads.getPaymentSource().equalsIgnoreCase("lainnya")) _leads.put("additionalPaymentSource", leads.getPaymentSourceOther());
				_leads.put("beneficiary", leads.getBeneficiary()); 
				_leads.put("beneficiaryRelationship", leads.getBeneficiaryRelationship()); 
			}
			
			if (step.equalsIgnoreCase("one")) _leads.put("detail", _detailLeads);
		} catch(Exception e) {
			_response.put("Status", 0);
			_response.put("Message", "Data leads tidak ditemukan.");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		_data.put("leads", _leads);
		_response.put("Status", 1);
		_response.put("Message", "");
		_response.put("Data", _data);
		
		resourceResponse.getWriter().write(_response.toString());
		return;
	}
	
	public void setTransaction(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		String jsonStringify = ParamUtil.getString(httpReq, "data");
		String type = ParamUtil.getString(httpReq, "type");
		JSONObject params = JSONFactoryUtil.createJSONObject(jsonStringify);
		String csrfTokenFromSession = (String) resourceRequest.getPortletSession().getAttribute("CSRF_TOKEN", PortletSession.PORTLET_SCOPE);
		JSONObject response = JSONFactoryUtil.createJSONObject();
		JSONObject data = JSONFactoryUtil.createJSONObject();
		
		String secureToken = EncryptionHelper.generateSecureToken(32);
		
		_log.info(csrfTokenFromSession);
		_log.info(params.getString("TokenLimiter"));
		
		boolean isValidCsrfToken = Validator.isNotNull(csrfTokenFromSession) && params.getString("TokenLimiter").equalsIgnoreCase(csrfTokenFromSession);

		resourceRequest.getPortletSession().setAttribute("CSRF_TOKEN", secureToken, PortletSession.PORTLET_SCOPE);
    	data.put("TokenLimiter", secureToken);
    	
		if (!isValidCsrfToken) {	
	    	response.put("Status", 0);
			response.put("Message", "Terjadi kesalahan, silakan coba beberapa saat lagi.");
			response.put("Data", data);
			
			resourceResponse.getWriter().write(response.toString());
			return;
		}
		
		JSONObject callApi = null;
		JSONObject responseApi = JSONFactoryUtil.createJSONObject();
		
		try {
			if (type.equalsIgnoreCase("initiate")) {
				callApi = responseApi.put("response", _transactionService.initPurchase(params.toString(), httpReq));
			}
			
			if (type.equalsIgnoreCase("submit")) {
				callApi = responseApi.put("response", _transactionService.submitPurchase(params.toString(), httpReq));
			}
			
			if (type.equalsIgnoreCase("process")) {
				callApi = responseApi.put("response", _transactionService.process(params.toString(), httpReq));
			}
	    } catch (Exception e) {
    		response.put("Status", 0);
			response.put("Message", "Gagal request ke server, silakan coba beberapa saat lagi [TR01_01]");
			response.put("Data", data);
			
			resourceResponse.getWriter().write(response.toString());
			return;
	    }
		
		JSONObject apiResponseDto = null;
		if (callApi.has("response")) apiResponseDto = JSONFactoryUtil.createJSONObject(callApi.get("response").toString());
		
		if (Validator.isNull(apiResponseDto)) {
			response.put("Status", 0);
			response.put("Message", "Gagal request ke server, silakan coba beberapa saat lagi [TR01_02]");
			response.put("Data", data);
			
			resourceResponse.getWriter().write(response.toString());
			return;
		}
		
		if (apiResponseDto.has("Data")) {
			apiResponseDto.getJSONObject("Data").put("TokenLimiter", secureToken);
		} else {
			apiResponseDto.put("Data", data);	
		}
		
		resourceResponse.getWriter().write(apiResponseDto.toString());
		return;
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
	
	private void _validateFile(String fileName, String contentType, long size)
		throws PortalException {

		long blogsImageMaxSize = _IMAGE_MAX_SIZE;

		if ((blogsImageMaxSize > 0) && (size > blogsImageMaxSize)) {
			throw new EntryImageSizeException();
		}
		
		boolean validContentType = Arrays.asList("image/jpeg",
					    						 "image/png",
					    						 "image/gif",
					    						 "image/bmp",
					    						 "image/webp"
								   ).contains(contentType.toLowerCase());

		if (!validContentType) {
			throw new EntryImageNameException(
				"Invalid image for file name " + fileName);
		}
	}
	
	private String getLowerPrice() {
		long benefitTypeId = SmartActiveBenefitTypeLocalServiceUtil.getActiveBenefitType().get(0).getSmartActiveBenefitTypeId(); 
		long benefitId = SmartActiveBenefitLocalServiceUtil.getBenefitByTypeId(benefitTypeId).get(0).getSmartActiveBenefitId();
		long lowerBenefitValue = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue().stream()
				 				 .mapToLong(SmartActiveBenefitValue::getValue)
				 				 .min().orElse(0);
		double lowerPremiRate = SmartActivePremiLocalServiceUtil.getActivePremi().stream()
								.filter(v -> v.getSmartActiveBenefitId() == benefitId)
				 			  	.mapToDouble(SmartActivePremi::getRate)
				 			  	.min().orElse(0);
		
		int lowerPremiPrice = (int) (lowerBenefitValue * (lowerPremiRate / 100));
		
		NumberFormat formatter = NumberFormat.getInstance(new Locale("id", "ID"));

		return lowerPremiPrice > 0 ? "IDR " + formatter.format(lowerPremiPrice) : "";
	}
	
	private JSONArray getApiPimcore(String url) {
		JSONArray response = JSONFactoryUtil.createJSONArray();
		
		try {
			JSONObject _response = ActionHelper.hitAPI(url, "", "");
			
			if (_response.has("statusCode")) {
		    	if (_response.getInt("statusCode") != 200) {
					return response;
		    	}
		    }
			
			JSONObject _responseDto = JSONFactoryUtil.createJSONObject(_response.get("response").toString());
			
			if (_responseDto.getInt("Status") == 1) {
				for (int i = 0; i < _responseDto.getJSONArray("Data").length(); i++) {
					JSONObject data = JSONFactoryUtil.createJSONObject(_responseDto.getJSONArray("Data").get(i).toString());
					JSONObject dto = JSONFactoryUtil.createJSONObject();
					
					dto.put("id", EncryptionHelper.encryptRandom(String.valueOf(data.getLong("Id"))));
					dto.put("name", data.getString("Name"));
					
					response.put(dto);
				}
			}
		} catch (Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}
		
		return response;
	}
	
	private static String PIMCORE_HOST;
	
	private static String apiCountry;
	
	private static String apiProvince;
	
	private static final long _IMAGE_MAX_SIZE = 1048576;

	private static ActionHelper helper = new ActionHelper();
	
	private static XSSValidator sanitizer = new XSSValidator();
	
	private static Log _log = LogFactoryUtil.getLog(SmartActivePortlet.class);
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
	
	@Reference
    private TransactionService _transactionService;
}