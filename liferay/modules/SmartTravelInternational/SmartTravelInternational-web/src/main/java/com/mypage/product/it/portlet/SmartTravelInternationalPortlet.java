package com.mypage.product.it.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.model.Premi;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.SmartTravelIntPlan;
import com.mypage.admin.product.service.BenefitLocalServiceUtil;
import com.mypage.admin.product.service.BenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.admin.product.service.PremiLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.SmartTravelIntPlanLocalServiceUtil;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.model.AgentTokenLimiter;
import com.mypage.agencyportal.service.AgentTokenLimiterLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalService;
import com.mypage.product.it.constants.SmartTravelInternationalPortletKeys;
import com.mypage.product.it.helper.EncryptionHelper;
import com.mypage.product.it.helper.MypageHelpers;
import com.mypage.product.it.wrapper.JournalArticleService;
import com.mypage.product.it.wrapper.PropsUtilService;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=mypage",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Smart Travel International", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/step1.jsp",
		"javax.portlet.name=" + SmartTravelInternationalPortletKeys.SMART_TRAVEL_INTERNATIONAL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SmartTravelInternationalPortlet extends MVCPortlet {

	private final JournalArticleService journalService = new JournalArticleService();
	private final PropsUtilService propService = new PropsUtilService();
	private final MypageHelpers helpers = new MypageHelpers();

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

//		List<MasterGlobalVariable> variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Version Control");
//		System.out.println(variables);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

//		ParamUtil.print(httpRequest);

		String _managedBy = "";
		String aParam = ParamUtil.getString(httpRequest, "a"); // Token liferay | dari api liferay (khusus jika login)
		String bParam = ParamUtil.getString(httpRequest, "b"); // Token liferay | dari api liferay (khusus jika login)
		String qtParam = ParamUtil.getString(httpRequest, "qt"); // o_id Leads | dari parameter q dari halaman penawaran
		String lParam = ParamUtil.getString(httpRequest, "l"); // LiferayId | dari parameter q dari halaman penawaran
		String rcParam = ParamUtil.getString(httpRequest, "rc"); // ManagedBy | dari URL
		String pcParam = ParamUtil.getString(httpRequest, "pc"); // PromoCode | dari URL
		String pvtParam = ParamUtil.getString(httpRequest, "pvt"); // Token from step3 or 4
		int roParam = ParamUtil.getInteger(httpRequest, "ro"); // beli kembali
		int modifyQuotation = ParamUtil.getInteger(httpRequest, "modify"); // beli kembali
		boolean sqParam = ParamUtil.getBoolean(httpRequest, "sq", false); // is simplequote or not
		boolean continueQuotation = false;
		String qt = ""; // ini nantinya pas dikirim ke pimcore namanya QuoteId
		long lId = 0L;
		String pc = "";
		String pvt = "";

		String pu = StringPool.BLANK;
		String _managedById = StringPool.BLANK;
		String mobile = StringPool.BLANK;

		String businessModel = "B2C";
		String _token = StringPool.BLANK;
		String _tokenLimiter = "";

		// B2B
		try {
			if (!Validator.isBlank(aParam)) {
				_token = EncryptionHelper.decrypt(aParam);
				AgentToken agentToken = _agentTokenLocalService.getAgentTokenByToken(_token);
				if (agentToken != null) {
					_managedBy = agentToken.getDeptCode();
					businessModel = "B2B";

					renderRequest.setAttribute("a", aParam);

					AgentTokenLimiter agentTokenLimiter = AgentTokenLimiterLocalServiceUtil
							.getAgentTokenLimiterByDeptCodeAndTokenType(agentToken.getDeptCode(), "limit_kyc");
					String _secureToken = EncryptionHelper.generateSecureToken(32);
					if (!Validator.isNull(agentTokenLimiter)) {
						long agentTokenLimiterId = agentTokenLimiter.getAgentTokenLimiterId();
						agentTokenLimiter = AgentTokenLimiterLocalServiceUtil.editAgentTokenLimiter(agentTokenLimiterId,
								agentToken.getDeptCode(), _secureToken, "limit_kyc", 1);
						_tokenLimiter = agentTokenLimiter.getToken();
					} else {
						agentTokenLimiter = AgentTokenLimiterLocalServiceUtil
								.addAgentTokenLimiter(agentToken.getDeptCode(), _secureToken, "limit_kyc", 1);
						_tokenLimiter = agentTokenLimiter.getToken();
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// L PARAM (Continue/Edit Quotation)
		if (!lParam.isEmpty() && lParam != null) {
			try {
				String lParamDecrypted = EncryptionHelper.decrypt(lParam);
				String[] lParamDecryptedSplit = lParamDecrypted.split("\\|");
				long _leadsId = Long.valueOf(lParamDecryptedSplit[1]);
				lId = _leadsId;
				qt = qtParam;
				continueQuotation = true;

				if (_managedBy.isEmpty()) {
					businessModel = "B2B2C";
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
			}
		}

		// PC PARAM
		if (!pcParam.isEmpty() && pcParam != null) {
			try {
				pc = pcParam;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// B PARAM
		if (!bParam.isEmpty() && bParam != null) {
			String agentRole = StringPool.BLANK;
			String agentCode = StringPool.BLANK;
			String agentName = StringPool.BLANK;
			String agentDeptCode = StringPool.BLANK;
			try {
				String bDecrypt = EncryptionHelper.decrypt(bParam);
				String[] bDecryptSplit = bDecrypt.split("\\|");

				JSONObject objectB = JSONFactoryUtil.createJSONObject(bDecryptSplit[1]);

				_managedById = objectB.has("UserId") ? objectB.getString("UserId") : StringPool.BLANK;
				agentRole = objectB.has("Role") ? objectB.getString("Role") : agentRole;
				agentCode = objectB.has("Code") ? objectB.getString("Code") : agentCode;
				agentName = objectB.has("Name") ? objectB.getString("Name") : agentName;
				agentDeptCode = objectB.has("DeptoreCode") ? objectB.getString("DeptoreCode") : agentDeptCode;
			} catch (Exception e) {
				System.out.println(e.getMessage());
//				if (helper.isLog()) _log.info(e.getMessage());
			}
			renderRequest.setAttribute("agentRole", agentRole);
			renderRequest.setAttribute("agentCode", agentCode);
			renderRequest.setAttribute("agentName", agentName);
			renderRequest.setAttribute("agentDeptCode", agentDeptCode);
			renderRequest.setAttribute("b", bParam);
		}

		// Prevt PARAM
		if (!pvtParam.isEmpty() && pvtParam != null) {
			try {
				pvt = pvtParam;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		renderRequest.setAttribute("tokenLimiter", _tokenLimiter);
		renderRequest.setAttribute("continueQuotation", continueQuotation);
		renderRequest.setAttribute("lId", lId);
		renderRequest.setAttribute("quouteId", qt);
		renderRequest.setAttribute("businessModel", businessModel);
		renderRequest.setAttribute("managedBy", _managedBy);
		renderRequest.setAttribute("managedById", _managedById);
		renderRequest.setAttribute("pc", pc);
		renderRequest.setAttribute("repeatOrder", roParam);
		renderRequest.setAttribute("modifyQuotation", modifyQuotation);
		renderRequest.setAttribute("simpleQuotation", sqParam);
		renderRequest.setAttribute("pvt", pvt);
		
		helpers.setJournalService(journalService);
		helpers.setPropService(propService);
		String riplayVersi = "personal";

		// Web Content
		String _dataHeader = helpers
				.getWebContentByFriendlyUrl("value-riplay-" + riplayVersi + "-informasi-produk", themeDisplay);

		String dataItemManfaat = helpers
				.getWebContentByFriendlyUrl("value-riplay-" + riplayVersi + "-accordion-item-manfaat", themeDisplay);

		String dataItemResiko = helpers
				.getWebContentByFriendlyUrl("value-riplay-" + riplayVersi + "-accordion-resiko", themeDisplay);

		String dataItemBiaya = helpers
				.getWebContentByFriendlyUrl("value-riplay-" + riplayVersi + "-accordion-item-biaya", themeDisplay);

		String dataItemKecuali = helpers.getWebContentByFriendlyUrl(
				"value-riplay-" + riplayVersi + "-accordion-item-pengecualian", themeDisplay);

		String dataItemSyarat = helpers.getWebContentByFriendlyUrl(
				"value-riplay-" + riplayVersi + "-accordion-item-persyaratan", themeDisplay);

		String dataItemSimulasi = helpers
				.getWebContentByFriendlyUrl("value-riplay-" + riplayVersi + "-accordion-item-simulasi", themeDisplay);

		String dataItemInfoTambahan = helpers.getWebContentByFriendlyUrl(
				"value-riplay-" + riplayVersi + "-accordion-item-informasi-tambahan", themeDisplay);

		String dataItemFiturUtama = helpers
				.getWebContentByFriendlyUrl("value-riplay-" + riplayVersi + "-accordion-fitur-utama", themeDisplay);

		String dataItemCatatanPenting = helpers.getWebContentByFriendlyUrl(
				"value-riplay-" + riplayVersi + "-accordion-item-catatan-penting", themeDisplay);

		String dataItemDisclaimer = helpers
				.getWebContentByFriendlyUrl("value-riplay-" + riplayVersi + "-accordion-item-disclaimer", themeDisplay);
		
		String sanctionCountry = helpers.getWebContentByFriendlyUrl("sanction-country", themeDisplay);
		
		// FAQ
		String smartTravelFaq = helpers.getWebContentByFriendlyUrl("smarttravelfaq", themeDisplay);

		// Send web content to JSP
		renderRequest.setAttribute("_data-info", _dataHeader);
		renderRequest.setAttribute("fitur-utama", dataItemFiturUtama);
		renderRequest.setAttribute("item-manfaat", dataItemManfaat);
		renderRequest.setAttribute("item-resiko", dataItemResiko);
		renderRequest.setAttribute("item-biaya", dataItemBiaya);
		renderRequest.setAttribute("item-pengecualian", dataItemKecuali);
		renderRequest.setAttribute("item-persyaratan", dataItemSyarat);
		renderRequest.setAttribute("item-simulasi", dataItemSimulasi);
		renderRequest.setAttribute("item-info-tambahan", dataItemInfoTambahan);
		renderRequest.setAttribute("item-catatan-penting", dataItemCatatanPenting);
		renderRequest.setAttribute("item-disclaimer", dataItemDisclaimer);
		renderRequest.setAttribute("riplay-version", riplayVersi);
		renderRequest.setAttribute("sanctionCountry", sanctionCountry);
		renderRequest.setAttribute("smarttravelfaq", smartTravelFaq);

		boolean isScanOcrboolean = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("IT6").stream()
				.filter(v -> v.getName().equalsIgnoreCase("Scan OCR") && v.getActive() == 1).findFirst().map(v -> {
					if (v.getValue() == null || v.getValue().isEmpty()) {
						return false;
					}
					return Long.parseLong(v.getValue()) == 1;
				}).orElse(false);

		renderRequest.setAttribute("isScanOcr", isScanOcrboolean);

		// DESTINATION DARI GLOBAL VARIABLE
		Map<String, String> destinationMap = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("IT6")
				.stream().filter(v -> v.getName().contains("Destination") && v.getActive() == 1)
				.collect(Collectors.toMap(v -> v.getValue(),
						v -> v.getName().substring(v.getName().indexOf('(') + 1, v.getName().indexOf(')')),
						(oldValue, newValue) -> oldValue, LinkedHashMap::new // Use LinkedHashMap to maintain order
				));

		renderRequest.setAttribute("destinationMap", destinationMap); // return list

		String apiLiferayCountries = String.valueOf(helpers.getConfig("com.mypage.client.api.liferay.countries"));
		String PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
		String finalApiLRCountries = PIMCORE_HOST + apiLiferayCountries;
		renderRequest.setAttribute("apiLiferayCountries", finalApiLRCountries);

		/**
		 * end web content
		 */

//		SmartTravelIntLink brochureLink = SmartTravelIntLinkLocalServiceUtil.getByLinkType("brochure");
//		SmartTravelIntLink riplayLink = SmartTravelIntLinkLocalServiceUtil.getByLinkType("riplay");
//		renderRequest.setAttribute("brochureLink", brochureLink.getLinkHref());
//		renderRequest.setAttribute("riplayLink", riplayLink.getLinkHref());

		MasterGlobalVariable riplayLink = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("IT6")
				.stream().filter(v -> v.getName().contains("Link Riplay Umum") && v.getActive() == 1).findFirst()
				.orElse(null);
		MasterGlobalVariable brochureLink = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("IT6")
				.stream().filter(v -> v.getName().contains("Link Brosur") && v.getActive() == 1).findFirst()
				.orElse(null);

		renderRequest.setAttribute("riplayLink", riplayLink != null ? riplayLink.getValue() : "");
		renderRequest.setAttribute("brochureLink", brochureLink != null ? brochureLink.getValue() : "");
		
		// Link My Insurance
		MasterGlobalVariable myInsuranceLink = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("IT6")
				.stream().filter(v -> v.getName().contains("Link My Insurance") && v.getActive() == 1).findFirst()
				.orElse(null);
		renderRequest.setAttribute("myInsuranceLink", myInsuranceLink != null ? myInsuranceLink.getValue() : "");

		String lowerPremiPrice = generateLowerPremiPrice();
		renderRequest.setAttribute("lowerPremiPrice", lowerPremiPrice);

//		String lrToPimcKycMiddlewareUrl = mypageHelpers.getConfig("com.mypage.product.pet.config.lrToPimcKycMiddlewareUrl");
//		String pmcrPaymentUrl = mypageHelpers.getConfig("com.mypage.product.pet.config.pmcrPaymentUrl");
//		renderRequest.setAttribute("lrToPimcKycMiddlewareUrl", lrToPimcKycMiddlewareUrl);
//		renderRequest.setAttribute("pmcrPaymentUrl", pmcrPaymentUrl);

		List<MasterGlobalVariable> medias = MasterGlobalVariableLocalServiceUtil
				.getActiveGlobalVariableByGroup("Social Media");
		renderRequest.setAttribute("medias", medias);

		super.render(renderRequest, renderResponse);
	}

	private String generateLowerPremiPrice() {
		String result = "";

		// Hitung harga premi terendah
		List<SmartTravelIntPlan> smartTravelIntPlans = SmartTravelIntPlanLocalServiceUtil.getActivePlan();
		List<Premi> _premis = PremiLocalServiceUtil.findByCurrencyAndTravellerType("idr", "individual");
		List<Map<String, Double>> resultContainer = new ArrayList<>();

		if (smartTravelIntPlans != null && _premis != null) {
			for (SmartTravelIntPlan plan : smartTravelIntPlans) {
				HashMap<String, Double> eachPlan = new HashMap<>();

				// calculate main benefit in each plan
				double totalMainBenefitEachPlan = 0.0;

				if (_premis.size() < 1)
					continue;

				for (Premi premi : _premis) {
					Benefit currentBenefit = null;
					try {
						currentBenefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
					} catch (Exception e) {
						System.out.println(e.getMessage());
						continue;
					}

					BenefitType currentBenefitType = null;
					if (currentBenefit != null) { // Tambahkan pengecekan null
						try {
							currentBenefitType = BenefitTypeLocalServiceUtil
									.getBenefitType(currentBenefit.getBenefitTypeId());
						} catch (Exception e) {
							System.out.println(e.getMessage());
							return result;
						}
					}

					if (currentBenefit != null && currentBenefitType != null) {
						if (!currentBenefitType.getNameId().equals("Jaminan Utama")) {
							continue;
						}

						if (plan.getSmartTravelIntPlanId() == premi.getPlanId()) {
							totalMainBenefitEachPlan += premi.getBasic().doubleValue();
						}
					}
				}
				
				if (totalMainBenefitEachPlan <= 0) {
			        // Lewati plan ini, jangan masuk ke resultContainer
			        continue;
			    }

				eachPlan.put(plan.getNameId(), totalMainBenefitEachPlan);
				resultContainer.add(eachPlan);
			}
			
			if (resultContainer.isEmpty()) {
			    return result;
			}
			
			ProductConfiguration _productConf = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6");

			Map<String, Double> lowestAmountEntry = resultContainer.stream()
					.min(Comparator.comparingDouble(map -> map.values().iterator().next()))
					.orElseThrow(() -> new NoSuchElementException("List of Main Benefit Price of each plan is empty"));

			Double lowerPremiPrice = lowestAmountEntry.entrySet().iterator().next().getValue();
			lowerPremiPrice += _productConf.getStampdutyIDR(); // ditambahkan dengan stampduty

			NumberFormat formatter = NumberFormat.getInstance(new Locale("id", "ID"));

			result = "IDR " + formatter.format(lowerPremiPrice);
		}
		return result;
	}

	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
