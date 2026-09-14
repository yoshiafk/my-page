package com.mypage.product.it2.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
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
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.upload.UniqueFileNameProvider;
import com.mypage.admin.product.model.*;
import com.mypage.admin.product.service.*;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.model.AgentTokenLimiter;
import com.mypage.agencyportal.service.AgentTokenLimiterLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalServiceUtil;
import com.mypage.leads.exception.NoSuchDetailInternationalTravelException;
import com.mypage.leads.model.Customer;
import com.mypage.leads.model.DetailInternationalTravel;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.*;
import com.mypage.product.it2.constants.SmartTravel2ApplicationKeys;
import com.mypage.product.it2.helper.EncryptionHelper;
import com.mypage.product.it2.helper.MypageHelpers;
import com.mypage.product.it2.helper.XSSValidator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.net.ssl.*;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/sti2",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=SmartTravel2Application.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
public class SmartTravel2Application extends Application {
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	// Peta Base64 prefix ke ekstensi file dan tipe konten
	private static final String JPEG_BASE64_PREFIX = "data:image/jpeg;base64,";
	private static final String PNG_BASE64_PREFIX = "data:image/png;base64,";

	private final SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	private final SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

	private final SimpleDateFormat outputFormat2 = new SimpleDateFormat("yyyy-MM-dd");

	private static final MypageHelpers helpers = new MypageHelpers();
	private static final Log _logs = LogFactoryUtil.getLog(SmartTravel2Application.class);

	private static final String OCR_CLIENT_HOST_URL = helpers.getConfig("com.mypage.agent.config.ocrClientHostURL");
	private static final String OCR_PATH_URL = helpers.getConfig("com.mypage.agent.config.ocrClientPathURL");
    private static final String OCR_RESPONSE_STATUS_SUCCESS = "SUCCESS";
	private static final String API_KEY = helpers.getConfig("com.mypage.agent.config.ocrClientApiKey");
	private static final String AUTH_HEADERS = helpers.getConfig("com.mypage.agent.config.ocrClientAuthHeader");
	private static final String PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
	private static final String PIMCORE_ADDRESS = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");

	private static final String KYC_PAYMENT_PIMCORE = helpers.getConfig("smarttravel.api.payment");
	private static final String CREATE_QUOTE_PIMCORE = helpers.getConfig("smarttravel.api.leads.createQuote");
	private static final String CHECK_PROMOCODE_PIMCORE_ENDPOINT = helpers.getConfig("smarttravel.api.leads.checkPromoCode");
	private static final String LEADS_CHECK_VALIDATE_PIMCORE = helpers.getConfig("smarttravel.api.leads.checkValidate");

    private static final String PURCHASE_CHANNEL_DIRECT = "DIRECT";

    private static final String TRAVELLER_TYPE_INDIVIDUAL = "individual";
    private static final String TRAVELLER_TYPE_DUO = "duo";
    private static final String TRAVELLER_TYPE_FAMILY = "family";

    private static final String TRAVEL_TYPE_ANNUAL = "annual";
    private static final String KEY_BIRTH_PLACE = "BirthPlace";

    private static final String KEY_DATANASABAH_PDOB = "_pdob";

    // DATA LEADS
    private static final String DATA_LEADS_KEY_TOKEN = "Token";
    private static final String DATA_LEADS_KEY_NAME = "Name";
    private static final String DATA_LEADS_KEY_EMAIL = "Email";
    private static final String DATA_LEADS_KEY_POLICYSTARTDATE = "PolicyStartDate";
    private static final String DATA_LEADS_KEY_POLICYENDDATE = "PolicyEndDate";
    private static final String DATA_LEADS_KEY_LEADSTYPE = "LeadsType";
    private static final String DATA_LEADS_KEY_BUSINESSMODEL = "BussinesModel";
    private static final String DATA_LEADS_KEY_STAMPDUTY = "StampDuty";
    private static final String DATA_LEADS_KEY_POLICYCOST = "PolicyCost";
    private static final String DATA_LEADS_KEY_PREMIUM = "Premium";
    private static final String DATA_LEADS_KEY_NETPREMIUM = "NetPremium";
    private static final String DATA_LEADS_KEY_DISCOUNT = "Discount";
    private static final String DATA_LEADS_KEY_DISCOUNTAMOUNT = "DiscountAmount";

    // DATA DETAIL INTERNATIONAL TRAVEL
    private static final String DATA_DETAIL_LEADSID = "LeadsId";
    private static final String DATA_DETAIL_TRAVELTYPE = "TravelType";
    private static final String DATA_DETAIL_DESTINATION = "Destination";
    private static final String DATA_DETAIL_PACKAGETYPE = "PackageType";

    private static final String DATA_PAYLOAD_QUOTATION_STAMPDUTY = "StampDuty";
    private static final String DATA_PAYLOAD_QUOTATION_BUSINESSMODEL = "BussinesModel";
    private static final String DATA_PAYLOAD_QUOTATION_DESTINATION = "Destination";
    private static final String DATA_PAYLOAD_QUOTATION_PACKAGETYPE = "PackageType";
    private static final String DATA_PAYLOAD_QUOTATION_ADDITIONALBENEFIT = "AdditionalBenefit";
    private static final String DATA_PAYLOAD_QUOTATION_PH_EMAIL = "Email";

    private static final String PARAM_POLICY_HOLDER_OR_INSURED_EMAIL = "_email";

    // updateCustomer
    private static final String DATA_POLICY_HOLDER_KEY_LEADSTYPE = "LeadsType";
    // updateCustomer
    private static final String DATA_CUSTOMER_KEY_LEADSID = "LeadsId";

    // Process Constant
    private static final String PROCESS_TYPE_PAYMENT = "payment";
    private static final String PROCESS_TYPE_PENAWARAN = "penawaran";
    private static final String PROCESS_INDONESIA = "Indonesia";
    private static final String PROCESS_KEY_PROCESSTYPE = "ProcessType";
    private static final String PROCESS_KEY_REDIRECT_TARGET = "RedirectTarget";
    // Process Param
    private static final String PARAM_PROCESS_ADDITIONAL_TOKEN = "Token";
    private static final String PARAM_PROCESS_ADDITIONAL_TYPE = "type";
    private static final String PARAM_PROCESS_ADDITIONAL_QUOTEID = "QuouteId";
    private static final String PARAM_PROCESS_PAYLOADKYC = "payloadKyc";
    private static final String PARAM_PROCESS_ADDITIONAL_BENEFIT = "AdditionalBenefit";
    // Process
    private static final String DATA_PROCESS_PAYLOAD_KEY_ISPEP = "IsPep";
    private static final String DATA_PROCESS_PAYLOAD_KEY_ADDITIONALBENEFIT = "AdditionalBenefit";
    private static final String DATA_PROCESS_PAYLOAD_KEY_STAMPDUTY = "StampDuty";
    private static final String DATA_PROCESS_PAYLOAD_KEY_BUSINESS_MODEL = "BussinesModel";
    private static final String DATA_PROCESS_PAYLOAD_KEY_DETAIL_DESTINATION = "Destination";
    private static final String DATA_PROCESS_PAYLOAD_KEY_DETAIL_PACKAGETYPE = "PackageType";

    private static final String DATA_PROCESS_PAYLOAD_KEY_POLICYHOLDER_PHONENUMBER = "PhoneNumber";
    private static final String DATA_PROCESS_PAYLOAD_KEY_POLICYHOLDER_NATIONALITYCOUNTRY = "NationalityCountry";
    private static final String DATA_PROCESS_PAYLOAD_KEY_POLICYHOLDER_IDPHOTOURL = "IdPhotoUrl";

    private static final String DATA_PROCESS_PAYLOAD_KEY_ADULTS_ISPEP = "IsPep";
    private static final String DATA_PROCESS_PAYLOAD_KEY_ADULTS_PHONENUMBER = "PhoneNumber";
    private static final String DATA_PROCESS_PAYLOAD_KEY_ADULTS_NATIONALITYCOUNTRY = "NationalityCountry";
    private static final String DATA_PROCESS_PAYLOAD_KEY_ADULTS_IDPHOTOURL = "IdPhotoUrl";

    private static final String DATA_PROCESS_PAYLOAD_KEY_CHILDREN_ISPEP = "IsPep";
    private static final String DATA_PROCESS_PAYLOAD_KEY_CHILDREN_PHONENUMBER = "PhoneNumber";
    private static final String DATA_PROCESS_PAYLOAD_KEY_CHILDREN_NATIONALITYCOUNTRY = "NationalityCountry";
    private static final String DATA_PROCESS_PAYLOAD_KEY_CHILDREN_IDPHOTOURL = "IdPhotoUrl";

    private static final String GENERAL_TEXT_PREMIUM = "Premium";
    private static final String GENERAL_TEXT_NETPREMIUM = "NetPremium";

    private static final String GENERAL_TEXT_LOWERCASE_STATUS = "status";
    private static final String GENERAL_TEXT_LOWERCASE_MESSAGE = "message";

	private static final String[][] MONTHS = { { "Mei", "May" }, { "Jan", "January" }, { "Feb", "February" },
			{ "Mar", "March" }, { "Apr", "April" }, { "Jun", "June" }, { "Jul", "July" }, { "Agu", "August" },
			{ "Sep", "September" }, { "Okt", "October" }, { "Nov", "November" }, { "Des", "December" } };

	private ProductConfiguration _productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6");

	// TOKEN UNTUK IFRAME
	@GET
	@Path("/show")
	@Produces("application/json")
	public String showAction(@QueryParam("a") String params) throws PortletException, IOException {
		JSONObject responseApi = JSONFactoryUtil.createJSONObject();
		JSONObject dataResult = JSONFactoryUtil.createJSONObject();
		try {
			String secureToken = EncryptionHelper.generateSecureToken(32);

			@SuppressWarnings("static-access")
			String param = EncryptionHelper.decrypt(params);
			String[] paramSplit = param.split("\\|");
			String deptCode = paramSplit[1];

			AgentToken agentToken = AgentTokenLocalServiceUtil.getAgentTokenByDeptCode(deptCode);

			if (!Validator.isNull(agentToken)) {
				long agentTokenId = agentToken.getAgentTokenId();
                AgentTokenLocalServiceUtil.editAgentToken(agentTokenId, deptCode, secureToken, 1);
			} else {
                AgentTokenLocalServiceUtil.addAgentToken(deptCode, secureToken, 1);
			}

			@SuppressWarnings("static-access")
			String token = EncryptionHelper.encrypt(secureToken);
            dataResult.put("Token", token);
            responseApi.put("Status", 1);
            responseApi.put("Data", dataResult);

		} catch (Exception e) {
			_logs.info(e.getMessage());
		}

		return responseApi.toString();
	}

	@POST
	@Path("/updatecurrency")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCurrency(String request, @Context HttpServletRequest httpServletRequest)
			throws JSONException, IOException {
		JSONObject response = JSONFactoryUtil.createJSONObject();

		try {
			JSONObject params = JSONFactoryUtil.createJSONObject(request);
			double usdAmount = params.getDouble("usd", 0);

			if (usdAmount == 0.0) {
				response.put("Status", 0);
				response.put("Message", "Amount cant be 0");
			} else {
				List<MasterCurrency> allCurrencies = MasterCurrencyLocalServiceUtil.getMasterCurrencies();
				if (allCurrencies == null) {
					response.put("Status", 0);
					response.put("Message", "No currency available");
				}

				MasterCurrency currentUsdCurrency = null;

				for (MasterCurrency currency : allCurrencies) {
					if (currency.getName().equalsIgnoreCase("usd")) {
						currentUsdCurrency = currency;
					}
				}

				if (currentUsdCurrency == null) {
					response.put("Status", 0);
					response.put("Message", "USD currency not found");
					return response.toString();
				}

				MasterCurrencyLocalServiceUtil.updateMasterCurrency(currentUsdCurrency.getCurrencyId(),
						currentUsdCurrency.getName(), usdAmount, currentUsdCurrency.getIsDefault(),
						currentUsdCurrency.getActive());

				response.put("Status", 1);
				response.put("Message", "Currency successfully updated");
			}

		} catch (Exception e) {
			response.put("Status", 0);
			response.put("Message", "Failed to update the currency");
		}

		return response.toString();
	}

	// CALCULATE PREMI
	private List<Map<String, Object>> calculateIndividual(Map<String, Object> paramCalc) {
		List<Map<String, Object>> individualPlanContainer = new ArrayList<>();

		String referrer = (String) paramCalc.get("referrer");
		String currency = (String) paramCalc.get("currency");
		String choosenPlan = (String) paramCalc.get("choosenPlan");
		String travelType = (String) paramCalc.get("travelType");
		int additionalDays = (int) paramCalc.get("additionalDays");
		JSONArray additionalBenefits = (JSONArray) paramCalc.get("additionalBenefits");
		JSONArray additionalBenefitCodes = (JSONArray) paramCalc.get("additionalBenefitCodes");
		int fp = (int) paramCalc.get("fp");

		try {
			MasterCurrency masterCurrency = MasterCurrencyLocalServiceUtil.searchCurrency(currency);

			List<StiPremi> premis = new ArrayList<>(
					StiPremiLocalServiceUtil.findByCurrencyAndTravellerType(currency, TRAVELLER_TYPE_INDIVIDUAL));
			if (Validator.isNull(premis)) {
				return individualPlanContainer;
			}

			Set<Long> planIds = new HashSet<>();
			for (StiPremi premi : premis) {
				planIds.add(premi.getPlanId());
			}
			Long[] planIdsArray = planIds.toArray(new Long[0]);

			for (Long planId : planIdsArray) {

				SmartTravelIntPlan planObj = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(planId);

				// JIKA ADA CHOOSEN PLAN, TAMPILKAN SATU PLAN AJA SESUAI CHOOSEN PLAN
				if (!choosenPlan.isEmpty()) {
					if (!planObj.getNameId().equals(choosenPlan)) {
						continue;
					}
				}

				LinkedHashMap<String, Object> itemData = new LinkedHashMap<>();

				itemData.put("PlanName", planObj.getNameId());

				// Data jaminan utama dan tambahan serta harga preminya di plan saat ini
				double totalMainBenefitPremiPrice = 0;
				double totalAdditionalPrice = 0;
				List<HashMap> mainBenefitList = new ArrayList<>();
				List<HashMap> mainBenefitListDesc = new ArrayList<>();
				HashMap<String, Double> mainBenefit = new HashMap<>();
				List<HashMap> additionalBenefitList = new ArrayList<>();

				double totalAllAdditionalPrice = 0;

				for (StiPremi premi : premis) {
					if (premi.getPlanId() == planId) {

						// Benefit yang terhubung dengan premi saat ini
						StiBenefit currentBenefit = StiBenefitLocalServiceUtil.getStiBenefit(premi.getBenefitId());
						BenefitType currentBenefitType = BenefitTypeLocalServiceUtil
								.getBenefitType(currentBenefit.getBenefitTypeId());

						// MAIN BENEFIT
						if (currentBenefitType.getNameId().equals("Jaminan Utama")
								&& currentBenefitType.getNameEn().equals("Main Benefit")) {
							if (travelType.equals("single")) {
								totalMainBenefitPremiPrice += premi.getBasic().doubleValue();

								if (additionalDays > 0) {
									totalMainBenefitPremiPrice += premi.getAdditional().doubleValue() * additionalDays;
								}

							} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
								totalMainBenefitPremiPrice += premi.getAnnual().doubleValue();
							}

							StiBenefit benefitObj = StiBenefitLocalServiceUtil.getStiBenefit(premi.getBenefitId());
							mainBenefit.put(benefitObj.getNameId(), premi.getBasic().doubleValue());

							HashMap<String, Object> mainBenefitItem = new HashMap<>();
							mainBenefitItem.put("Name", benefitObj.getNameId());
							mainBenefitItem.put("Amount", premi.getBasic().doubleValue());

							mainBenefitList.add(mainBenefitItem);

							HashMap<String, Object> mainBenefitListDescItem = new HashMap<>();
							mainBenefitListDescItem.put("Name", benefitObj.getNameId());

							StiBenefitValueMapping bvm = StiBenefitValueMappingLocalServiceUtil
									.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
											currentBenefitType.getBenefitTypeId(), benefitObj.getBenefitId(),
											premi.getPlanId());
							mainBenefitListDescItem.put("Desc", bvm.getBenefitValue());
							mainBenefitListDescItem.put("DescUSD", bvm.getBenefitValueUSD());
							mainBenefitListDesc.add(mainBenefitListDescItem);
						}

						// ADDITIONAL BENEFITS
						if (!currentBenefitType.getNameId().equals("Jaminan Utama")
								&& !currentBenefitType.getNameEn().equals("Main Benefit")) {

							// Jika ada dari pimcore
							if (!referrer.isEmpty()) {
								if (!Validator.isNull(additionalBenefitCodes)) {
									for (int i = 0; i < additionalBenefitCodes.length(); i++) {
										if (additionalBenefitCodes.getString(i)
												.equalsIgnoreCase(currentBenefit.getExternalCode())) {
											// single atau tahunan
											if (travelType.equals("single")) {
												totalAdditionalPrice += premi.getBasic().doubleValue();

												// jika ada additional day
												if (additionalDays > 0) {
													totalAdditionalPrice += premi.getAdditional().doubleValue()
															* additionalDays;
												}

											} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
												totalAdditionalPrice += premi.getAnnual().doubleValue();
											}

											HashMap<String, Object> additionalBenefitItem = new HashMap<>();
											additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
											additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
											additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());

											StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
													.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
															currentBenefitType.getBenefitTypeId(),
															currentBenefit.getBenefitId(), premi.getPlanId());
											additionalBenefitItem.put("BenefitValueIDR", benefitValueMappingObj.getBenefitValue());
											additionalBenefitItem.put("BenefitValueUSD", benefitValueMappingObj.getBenefitValueUSD());
//											additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

											additionalBenefitList.add(additionalBenefitItem);
										}
									}
								}

							} else {

								// Additional benefits dari FE liferay (bukan pimcore)
								if (!Validator.isNull(additionalBenefits)) {
									for (int i = 0; i < additionalBenefits.length(); i++) {
										if (additionalBenefits.getInt(i) == currentBenefit.getBenefitId()) {

											// Single atau tahunan
											if (travelType.equals("single")) {
												totalAdditionalPrice += premi.getBasic().doubleValue();

												if (additionalDays > 0) {
													totalAdditionalPrice += premi.getAdditional().doubleValue()
															* additionalDays;
												}

											} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
												totalAdditionalPrice += premi.getAnnual().doubleValue();
											}

											HashMap<String, Object> additionalBenefitItem = new HashMap<>();
											additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
											additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
											additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());

											StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
													.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
															currentBenefitType.getBenefitTypeId(),
															currentBenefit.getBenefitId(), premi.getPlanId());
											additionalBenefitItem.put("BenefitValueIDR", benefitValueMappingObj.getBenefitValue());
											additionalBenefitItem.put("BenefitValueUSD", benefitValueMappingObj.getBenefitValueUSD());
//											additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

											additionalBenefitList.add(additionalBenefitItem);
										}
									}
								}
							}

							// HITUNG SEMUA ADDITIONAL BENEFIT BY DEFAULT
							// BUKAN BERDASARKAN BENEFIT YANG DIPILIH
							// --------------------------------------------
							if (travelType.equals("single")) {
								totalAllAdditionalPrice += premi.getBasic().doubleValue();

								if (fp == 1) {
									totalAdditionalPrice += premi.getBasic().doubleValue();
								}

								if (additionalDays > 0) {
									totalAllAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;
									if (fp == 1) {
										totalAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;
									}
								}

							} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
								totalAllAdditionalPrice += premi.getAnnual().doubleValue();
								if (fp == 1) {
									totalAdditionalPrice += premi.getAnnual().doubleValue();
								}
							}
						} // end if this premi is for additional benefit
					} // end if plan id in premi same as current plan loop
				} // end looping premi

				itemData.put("MainBenefit", mainBenefit);
				itemData.put("MainBenefitList", mainBenefitList);
				itemData.put("MainBenefitListDesc", mainBenefitListDesc);
				itemData.put("AdditionalBenefitList", additionalBenefitList);

				itemData.put("TotalMainBenefitPremium", totalMainBenefitPremiPrice);
				itemData.put("TotalAdditionalBenefitPremium", totalAdditionalPrice);
				itemData.put("TotalAdditionalBenefitPremiumAllChecked", totalAllAdditionalPrice);

				itemData.put("TotalAdultMainBenefitPremium", totalMainBenefitPremiPrice);
				itemData.put("TotalAdultAdditionalBenefitPremium", totalAdditionalPrice);

				itemData.put("TotalChildMainBenefitPremium", 0.0);
				itemData.put("TotalChildAdditionalBenefitPremium", 0.0);

				// konversi berdasarkan currency
				double totalMainBenefitPremiPriceUSDInIDR = 0.0;
				double totalAdditionalPriceUSDInIDR = 0.0;
				double totalAllAdditionalPriceUSDInIDR = 0.0;

				totalMainBenefitPremiPriceUSDInIDR = (double) (totalMainBenefitPremiPrice * masterCurrency.getAmount());
				totalAdditionalPriceUSDInIDR = (double) (totalAdditionalPrice * masterCurrency.getAmount());
				totalAllAdditionalPriceUSDInIDR = (double) (totalAllAdditionalPrice * masterCurrency.getAmount());

				itemData.put("TotalMainBenefitPremiumInIDR", totalMainBenefitPremiPriceUSDInIDR);
				itemData.put("TotalAdditionalBenefitPremiumInIDR", totalAdditionalPriceUSDInIDR);
				itemData.put("TotalAdditionalBenefitPremiumAllCheckedInIDR", totalAllAdditionalPriceUSDInIDR);

				// data kalkulasi masing-masing plan
				individualPlanContainer.add(itemData);
			}
		} catch (Exception e) {
			_logs.info(e.getMessage());
		}

		return individualPlanContainer;
	}

	// Final response
	private JSONObject finalResponse(String travellerType, String travelType, String currency, long totalInclusiveDays,
			MasterCurrency masterCurrency, int adultTotal, int childTotal, String departureDisplayDate,
			String arrivalDisplayDate, double discount, boolean spesificPlan, String choosenPlan, double commision,
			double tax, List<Map<String, Object>> planContainer, String promoCode, String paymentMethod,
			String managedBy) throws Exception {
		JSONObject dataBody = JSONFactoryUtil.createJSONObject();
		
		int scale = currency.equalsIgnoreCase("idr") ? 0 : 2;

		double policyCostIDR = _productConfiguration.getPolicyCostIDR();
		double policyCostUSD = _productConfiguration.getPolicyCostUSD();
		double policyCost = (currency.equals("idr")) ? policyCostIDR : policyCostUSD;
		double stampDutyIDR = _productConfiguration.getStampdutyIDR();
		double stampDutyUSD = _productConfiguration.getStampdutyUSD();
		double stampDuty = (currency.equals("idr")) ? stampDutyIDR : stampDutyUSD;
		long totalDays = (travelType.equals("single")) ? Long.valueOf(totalInclusiveDays) : Long.valueOf("365");

		dataBody.put("TravellerType", travellerType.toUpperCase());
		dataBody.put("TravelType", travelType.toUpperCase());
		dataBody.put("Currency", currency.toUpperCase());
		dataBody.put("TotalDays", totalDays);
		dataBody.put("PolicyCost", policyCost);
		dataBody.put("PolicyCostInIDR", Math.round(policyCost * masterCurrency.getAmount()));
		dataBody.put("Stamp", stampDuty);
		dataBody.put("StampInIDR", Math.round(stampDuty * masterCurrency.getAmount()));
		dataBody.put("TotalAdult", adultTotal);
		dataBody.put("TotalChild", childTotal);
		dataBody.put("DepartureDate", departureDisplayDate);
		dataBody.put("ArrivalDate", arrivalDisplayDate);
		dataBody.put("PromoCode", promoCode);

		for (Map<String, Object> _planContainerItem : planContainer) {

			BigDecimal totalMainBenefitPremium = new BigDecimal(String.valueOf(_planContainerItem.getOrDefault("TotalMainBenefitPremium", 0)));
			BigDecimal totalAdditionalBenefitPremium = new BigDecimal(String.valueOf(_planContainerItem.getOrDefault("TotalAdditionalBenefitPremium", 0)));
			BigDecimal premiumForSpecificPlan = totalMainBenefitPremium.add(totalAdditionalBenefitPremium);
			BigDecimal premium = premiumForSpecificPlan.setScale(scale, RoundingMode.HALF_UP);

			BigDecimal discountRate = BigDecimal.valueOf(discount).divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
			BigDecimal discountAmount = premium.multiply(discountRate).setScale(2, RoundingMode.HALF_UP);

			BigDecimal basicPrice = premium.subtract(discountAmount).setScale(scale, RoundingMode.HALF_UP);
			BigDecimal administrasiPrice = BigDecimal.valueOf(stampDuty).add(BigDecimal.valueOf(policyCost)).setScale(scale, RoundingMode.HALF_UP);
			
			BigDecimal netPremium = basicPrice.add(administrasiPrice).setScale(scale, RoundingMode.HALF_UP);
			BigDecimal netPremiumIDR = netPremium.multiply(BigDecimal.valueOf(masterCurrency.getAmount())).setScale(0, RoundingMode.HALF_UP);
			BigDecimal netPremiumWithoutDiscount = premium.add(administrasiPrice).setScale(scale, RoundingMode.HALF_UP);

			_planContainerItem.put("Discount", discount);
			_planContainerItem.put(GENERAL_TEXT_PREMIUM, premium);
			_planContainerItem.put(GENERAL_TEXT_NETPREMIUM, netPremium);
			_planContainerItem.put("NetPremiumIDR", netPremiumIDR);
			_planContainerItem.put("NetPremiumWithoutDiscount", netPremiumWithoutDiscount);
			_planContainerItem.put("NetPremiumWithoutDiscountIDR", netPremiumWithoutDiscount.multiply(BigDecimal.valueOf(masterCurrency.getAmount())).setScale(0, RoundingMode.HALF_UP));
			
			// ===== ADULT =====
			BigDecimal adultMainBenefit = new BigDecimal(String.valueOf(_planContainerItem.getOrDefault("TotalAdultMainBenefitPremium", 0)));
			BigDecimal adultAdditionalBenefit = new BigDecimal(String.valueOf(_planContainerItem.getOrDefault("TotalAdultAdditionalBenefitPremium", 0)));
			BigDecimal adultTotalPremium = adultMainBenefit.add(adultAdditionalBenefit).setScale(scale, RoundingMode.HALF_UP);
			_planContainerItem.put("PremiumAdult", adultTotalPremium.doubleValue());

			// ===== CHILD =====
			BigDecimal childMainBenefit = new BigDecimal(String.valueOf(_planContainerItem.getOrDefault("TotalChildMainBenefitPremium", 0)));
			BigDecimal childAdditionalBenefit =new BigDecimal(String.valueOf(_planContainerItem.getOrDefault("TotalChildAdditionalBenefitPremium", 0)));
			BigDecimal childTotalPremium =childMainBenefit.add(childAdditionalBenefit).setScale(scale, RoundingMode.HALF_UP);
			_planContainerItem.put("PremiumChild", childTotalPremium.doubleValue());
		}
		
		dataBody.put("AvailablePlans", JSONFactoryUtil.createJSONArray(planContainer));
		dataBody.put("Discount", discount);

		BigDecimal totalMainBenefitPremium = new BigDecimal(String.valueOf(planContainer.get(0).getOrDefault("TotalMainBenefitPremium", 0)));
		BigDecimal totalAdditionalBenefitPremium = new BigDecimal(String.valueOf(planContainer.get(0).getOrDefault("TotalAdditionalBenefitPremium", 0)));
		BigDecimal premiumForSpecificPlan = totalMainBenefitPremium.add(totalAdditionalBenefitPremium);
		BigDecimal premium = premiumForSpecificPlan.setScale(scale, RoundingMode.HALF_UP);
		
		BigDecimal premiumBD = premium;
		_logs.info("#1 PREMIUM: " + premiumBD);

		BigDecimal discountRateBD = BigDecimal.valueOf(discount)
		        .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
		_logs.info("#2 DISCOUNT RATE: " + discountRateBD);
		
		BigDecimal discountAmount = premiumBD.multiply(discountRateBD).setScale(2, RoundingMode.HALF_UP);
		_logs.info("#3 DISCOUNT AMOUNT: " + discountAmount);

		BigDecimal basicPrice = premiumBD
		        .subtract(discountAmount)
		        .setScale(scale, RoundingMode.HALF_UP);
		_logs.info("#4 BASIC PRICE: " + basicPrice);

		BigDecimal administrasiPrice = BigDecimal.valueOf(stampDuty)
		        .add(BigDecimal.valueOf(policyCost))
		        .setScale(scale, RoundingMode.HALF_UP);
		_logs.info("#5 ADMINISTRASI PRICE: " + administrasiPrice);

		BigDecimal netPremium = basicPrice
		        .add(administrasiPrice)
		        .setScale(scale, RoundingMode.HALF_UP);
		_logs.info("#6 NET PREMIUM: " + netPremium);

		BigDecimal netPremiumIDR = netPremium
		        .multiply(BigDecimal.valueOf(masterCurrency.getAmount()))
		        .setScale(0, RoundingMode.HALF_UP);
		_logs.info("#7 NET PREMIUM IDR: " + netPremiumIDR);

		if (spesificPlan) {

			dataBody.put(GENERAL_TEXT_PREMIUM, premium);
			dataBody.put("DiscountAmount", discountAmount);
			dataBody.put(GENERAL_TEXT_NETPREMIUM, netPremium);
			dataBody.put("NetPremiumIDR", netPremiumIDR.doubleValue());
			dataBody.put("Plan", choosenPlan);
			dataBody.put("CurrencyAmount", masterCurrency.getAmount());

			// jika nettpremi, maka dihitung commisionValue dan tax
			// jika gross, commisionValue dan tax 0
			if (paymentMethod.equalsIgnoreCase("nett") && !managedBy.isEmpty()) {
				
				BigDecimal commissionRate = BigDecimal.valueOf(commision).divide(BigDecimal.valueOf(100));
				_logs.info("#8 COMMISSION RATE: " + commissionRate);
			    BigDecimal commissionValue =
			            commissionRate
			                    .multiply(basicPrice)
			                    .setScale(scale, RoundingMode.HALF_UP);
			    _logs.info("#9 COMMISION VALUE: " + commissionValue);
			    
			    BigDecimal taxRate = BigDecimal.valueOf(tax).divide(BigDecimal.valueOf(100));
			    _logs.info("#10 TAX RATE: " + taxRate);
			    BigDecimal taxValue = commissionValue
			            .multiply(taxRate)
			            .setScale(scale, RoundingMode.HALF_UP);
			    _logs.info("#11 TAX VALUE: " + taxValue);
			    
			    BigDecimal nettPremium;
			    if(tax > 0) {
				    nettPremium = basicPrice
				            .subtract(commissionValue)
				            .add(taxValue)
				            .add(administrasiPrice)
				            .setScale(scale, RoundingMode.HALF_UP);
				    _logs.info("#12 NETT PREMIUM: " + nettPremium);			    	
			    } else {
				    nettPremium = netPremium;
				    _logs.info("#12 NETT PREMIUM TAX 0: " + nettPremium);			    	
			    }

			    dataBody.put("Commission", commision);
			    dataBody.put("CommissionValue", commissionValue.doubleValue());
			    dataBody.put("Tax", tax);
			    dataBody.put("TaxValue", taxValue.doubleValue());
			    dataBody.put("NettPremium", nettPremium.doubleValue());

			    dataBody.put(
			        "NettPremiumIDR",
			        nettPremium
			            .multiply(BigDecimal.valueOf(masterCurrency.getAmount()))
			            .setScale(0, RoundingMode.HALF_UP)
			            .doubleValue()
			    );
			    
			} else {
				dataBody.put("Commission", commision);
				dataBody.put("CommissionValue", 0);
				dataBody.put("Tax", 0);
				dataBody.put("TaxValue", 0);
				dataBody.put("NettPremium", 0);
				dataBody.put("NettPremiumIDR", 0);
			}
		}
		
		_logs.info("FULL RESPONSE: " + dataBody);

		return dataBody;
	}

	private JSONObject calculatePremi(JSONObject params, boolean spesificPlan) throws JSONException, Exception {
		try {
			String mainbenefitKey1 = "Biaya Pengobatan, Gigi dan Lainnya";
			String mainbenefitKey2 = "Kecelakaan Diri";
			String mainbenefitKey3 = "Evakuasi Medis Darurat dan Repatriasi";
			String mainbenefitKey4 = "Pemulangan Jenazah";

			JSONObject result = JSONFactoryUtil.createJSONObject();

			// START Request dari Pimcore dibedakan oleh isi di param Refferer ini
			String referrer = params.getString("Referrer");
			JSONArray additionalBenefitCodes = params.getJSONArray("AdditionalBenefitCodes");
			// END Request dari Pimcore dibedakan oleh isi di param Refferer ini

			JSONArray additionalBenefits = params.getJSONArray("AdditionalBenefits");
			String _managedBy = params.getString("ManagedBy");

			String currency = params.getString("Currency");
			currency = !Validator.isNull(currency) ? currency.toLowerCase() : "";

			String travellerType = params.getString("TravellerType");
			travellerType = !Validator.isNull(travellerType) ? travellerType.toLowerCase() : "";

			String travelType = params.getString("TravelType");
			travelType = !Validator.isNull(travelType) ? travelType.toLowerCase() : "";

			int adultTotal = params.getInt("AdultTotal", 0);
			int childTotal = params.getInt("ChildTotal", 0);

			// Harga basic premium berlaku untuk 1-3 hari, lebih dari itu dikenakan harga
			// additional
			// Hitung total additional day
			String dateFrom = params.getString("DepartureDate");
			DateTimeFormatter dateFromFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");

			LocalDate _dateFrom = LocalDate.parse(dateFrom, dateFromFormatter);
			String departureDisplayDate = _dateFrom.format(dateFromFormatter);

			String dateTo = params.getString("ArrivalDate");
			DateTimeFormatter dateToFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");

			LocalDate _dateTo = LocalDate.parse(dateTo, dateToFormatter);
			String arrivalDisplayDate = _dateTo.format(dateFromFormatter);

			long totalInclusiveDays = ChronoUnit.DAYS.between(_dateFrom, _dateTo) + 1;

			int basicPremiumDays = 3;
			int additionalDays = 0;

			if (totalInclusiveDays > 3) {
				additionalDays = (int) totalInclusiveDays - basicPremiumDays;
			}

			MasterCurrency masterCurrency = MasterCurrencyLocalServiceUtil.searchCurrency(currency);

			String promoCode = params.getString("PromoCode");
			String choosenPlan = params.getString("SpesificPlan");
			double commision = params.getDouble("Commission");
			double tax = params.getDouble("Tax");

			String paymentMethod = params.getString("PaymentMethod");

			// discount
			double discount = params.getDouble("Discount", 0.0);

			// full package
			int fp = params.getInt("fp");

			Map<String, Object> paramCalc = new HashMap<String, Object>();
			paramCalc.put("referrer", referrer);
			paramCalc.put("currency", currency);
			paramCalc.put("choosenPlan", choosenPlan);
			paramCalc.put("travelType", travelType);
			paramCalc.put("additionalDays", additionalDays);
			paramCalc.put("additionalBenefits", additionalBenefits);
			paramCalc.put("additionalBenefitCodes", additionalBenefitCodes);

			paramCalc.put("adultTotal", adultTotal);
			paramCalc.put("childTotal", childTotal);
			paramCalc.put("travellerType", travellerType);
			paramCalc.put("totalInclusiveDays", totalInclusiveDays);
			paramCalc.put("promoCode", promoCode);
			paramCalc.put("discount", discount);
			paramCalc.put("fp", fp);

			// INDIVIDUAL
			List<Map<String, Object>> individualPlanContainer = calculateIndividual(paramCalc);
			// END INDIVIDUAL

			// DUO
			// Hasil akhir duo adalah hasil penjumlahan dari individualContainer diatas
			// dengan duoContainer di dalam blok if duo dibawah.
			if (travellerType.equals("duo")) {

				List<Map<String, Object>> spousePlanContainer = new ArrayList<>();

				List<StiPremi> spousePremis = new ArrayList<>(
						StiPremiLocalServiceUtil.findByCurrencyAndTravellerType(currency, "spouse"));

				// Premi spouse harus ada untuk duo
				if (Validator.isNull(spousePremis)) {
					return result;
				}

				Set<Long> planSpouseIds = new HashSet<>();
				for (StiPremi spousePremi : spousePremis) {
					planSpouseIds.add(spousePremi.getPlanId());

				}
				Long[] planSpouseIdsArray = planSpouseIds.toArray(new Long[0]);

				for (Long planId : planSpouseIdsArray) {
					SmartTravelIntPlan _plan = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(planId);

					// JIKA ADA CHOOSEN PLAN, TAMPILKAN SATU PLAN AJA SESUAI CHOOSEN PLAN
					if (!choosenPlan.isEmpty()) {
						if (!_plan.getNameId().equals(choosenPlan)) {
							continue;
						}
					}

					HashMap<String, Object> itemData = new HashMap<>();

					itemData.put("PlanName", _plan.getNameId());

					// data jaminan utama dan harga basic premi di plan saat ini
					double totalMainBenefitPremiPrice = 0;
					double totalAdditionalPrice = 0;
					List<HashMap> mainBenefitList = new ArrayList<>();
					HashMap<String, Double> mainBenefit = new HashMap<>();
					List<HashMap> additionalBenefitList = new ArrayList<>();

					double totalAllAdditionalPrice = 0;

					for (StiPremi premi : spousePremis) {
						if (premi.getPlanId() == planId) {

							StiBenefit currentBenefit = StiBenefitLocalServiceUtil.getStiBenefit(premi.getBenefitId());
							BenefitType currentBenefitType = BenefitTypeLocalServiceUtil
									.getBenefitType(currentBenefit.getBenefitTypeId());

							// MAIN BENEFIT
							if (currentBenefitType.getNameId().equals("Jaminan Utama")
									&& currentBenefitType.getNameEn().equals("Main Benefit")) {
								// single atau tahunan
								if (travelType.equals("single")) {
									totalMainBenefitPremiPrice += premi.getBasic().doubleValue();

									// jika ada additional day
									if (additionalDays > 0) {
										totalMainBenefitPremiPrice += premi.getAdditional().doubleValue()
												* additionalDays;
									}

								} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
									totalMainBenefitPremiPrice += premi.getAnnual().doubleValue();
								}

								StiBenefit benefitObj = StiBenefitLocalServiceUtil.getStiBenefit(premi.getBenefitId());
								mainBenefit.put(benefitObj.getNameId(), premi.getBasic().doubleValue());

								HashMap<String, Object> mainBenefitItem = new HashMap<>();
								mainBenefitItem.put("Name", benefitObj.getNameId());
//								mainBenefitItem.put("Amount", premi.getBasic().doubleValue());

								mainBenefitList.add(mainBenefitItem);
							}

							// ADDITIONAL BENEFITS
							if (!currentBenefitType.getNameId().equals("Jaminan Utama")
									&& !currentBenefitType.getNameEn().equals("Main Benefit")) {

								// jika ada dari pimcore
								if (!referrer.isEmpty()) {
									if (!Validator.isNull(additionalBenefitCodes)) {
										for (int i = 0; i < additionalBenefitCodes.length(); i++) {
											if (additionalBenefitCodes.getString(i)
													.equalsIgnoreCase(currentBenefit.getExternalCode())) {
												// single atau tahunan
												if (travelType.equals("single")) {
													totalAdditionalPrice += premi.getBasic().doubleValue();

													// jika ada additional day
													if (additionalDays > 0) {
														totalAdditionalPrice += premi.getAdditional().doubleValue()
																* additionalDays;
													}

												} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
													totalAdditionalPrice += premi.getAnnual().doubleValue();
												}

												HashMap<String, Object> additionalBenefitItem = new HashMap<>();
												additionalBenefitItem.put("BenefitCode",
														currentBenefit.getExternalCode());
												additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
												additionalBenefitItem.put("Benefit Type",
														currentBenefitType.getNameId());

												StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
														.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																currentBenefitType.getBenefitTypeId(),
																currentBenefit.getBenefitId(), premi.getPlanId());
												additionalBenefitItem.put("BenefitValueIDR", benefitValueMappingObj.getBenefitValue());
												additionalBenefitItem.put("BenefitValueUSD", benefitValueMappingObj.getBenefitValueUSD());
//												additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

												additionalBenefitList.add(additionalBenefitItem);

											}
										}
									}
								} else {

									// additional benefits dari FE liferay (bukan pimcore)
									if (!Validator.isNull(additionalBenefits)) {
										for (int i = 0; i < additionalBenefits.length(); i++) {
											if (additionalBenefits.getInt(i) == currentBenefit.getBenefitId()) {

												// single atau tahunan
												if (travelType.equals("single")) {
													totalAdditionalPrice += premi.getBasic().doubleValue();

													// jika ada additional day
													if (additionalDays > 0) {
														totalAdditionalPrice += premi.getAdditional().doubleValue()
																* additionalDays;
													}

												} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
													totalAdditionalPrice += premi.getAnnual().doubleValue();
												}

												HashMap<String, Object> additionalBenefitItem = new HashMap<>();
												additionalBenefitItem.put("BenefitCode",
														currentBenefit.getExternalCode());
												additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
												additionalBenefitItem.put("Benefit Type",
														currentBenefitType.getNameId());

												StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
														.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																currentBenefitType.getBenefitTypeId(),
																currentBenefit.getBenefitId(), premi.getPlanId());
												additionalBenefitItem.put("BenefitValueIDR", benefitValueMappingObj.getBenefitValue());
												additionalBenefitItem.put("BenefitValueUSD", benefitValueMappingObj.getBenefitValueUSD());
//												additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

												additionalBenefitList.add(additionalBenefitItem);
											}
										}
									}
									// end additional benefit liferay (bukan pimcore

								}

								// HITUNG SEMUA ADDITIONAL BENEFIT BY DEFAULT
								// BUKAN BERDASARKAN BENEFIT YANG DIPILIH
								// --------------------------------------------
								// single atau tahunan
								if (travelType.equals("single")) {
									totalAllAdditionalPrice += premi.getBasic().doubleValue();

									if (fp == 1) {
										totalAdditionalPrice += premi.getBasic().doubleValue();
									}

									// jika ada additional day
									if (additionalDays > 0) {
										totalAllAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;
										if (fp == 1) {
											totalAdditionalPrice += premi.getAdditional().doubleValue()
													* additionalDays;
										}

									}

								} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
									totalAllAdditionalPrice += premi.getAnnual().doubleValue();
									if (fp == 1) {
										totalAdditionalPrice += premi.getAnnual().doubleValue();
									}
								}
							}
							// END ADDITIONAL BENEFITS
						}
					}

					itemData.put("MainBenefit", mainBenefit);
					itemData.put("MainBenefitList", mainBenefitList);
					itemData.put("AdditionalBenefitList", additionalBenefitList);

					itemData.put("TotalMainBenefitPremium", totalMainBenefitPremiPrice);
					itemData.put("TotalAdditionalBenefitPremium", totalAdditionalPrice);
					itemData.put("TotalAdditionalBenefitPremiumAllChecked", totalAllAdditionalPrice);

					itemData.put("TotalAdultMainBenefitPremium", totalMainBenefitPremiPrice);
					itemData.put("TotalAdultAdditionalBenefitPremium", totalAdditionalPrice);

					itemData.put("TotalChildMainBenefitPremium", 0.0);
					itemData.put("TotalChildAdditionalBenefitPremium", 0.0);

					// konversi berdasarkan currency
					double totalMainBenefitPremiPriceUSDInIDR = 0.0;
					double totalAdditionalPriceUSDInIDR = 0.0;
					double totalAllAdditionalPriceUSDInIDR = 0.0;

					totalMainBenefitPremiPriceUSDInIDR = (double) (totalMainBenefitPremiPrice
							* masterCurrency.getAmount());
					totalAdditionalPriceUSDInIDR = (double) (totalAdditionalPrice * masterCurrency.getAmount());
					totalAllAdditionalPriceUSDInIDR = (double) (totalAllAdditionalPrice * masterCurrency.getAmount());

					// ada isinya jika currency yang dipilih USD
					itemData.put("TotalMainBenefitPremiumInIDR", totalMainBenefitPremiPriceUSDInIDR);
					itemData.put("TotalAdditionalBenefitPremiumInIDR", totalAdditionalPriceUSDInIDR);
					itemData.put("TotalAdditionalBenefitPremiumAllCheckedInIDR", totalAllAdditionalPriceUSDInIDR);

					spousePlanContainer.add(itemData);
				}

				// CALCULATE DUO
				// INDIVIDUAL + SPOUSE = DUO
				List<Map<String, Object>> duoPlanContainer = new ArrayList<>();

				for (Map<String, Object> _individualItem : individualPlanContainer) {
					String currentIndividualPlanName = (String) _individualItem.get("PlanName");
//					
					for (Map<String, Object> _spouseItem : spousePlanContainer) {
						String currentSpousePlanName = (String) _spouseItem.get("PlanName");

						if (currentSpousePlanName.equals(currentIndividualPlanName)) {

							// TotalMainBenefitPremium
							double currentIndividualTotalBasicPremium = (double) _individualItem
									.get("TotalMainBenefitPremium");
							double currentSpouseTotalBasicPremium = (double) _spouseItem.get("TotalMainBenefitPremium");
							_individualItem.put("TotalMainBenefitPremium",
									currentIndividualTotalBasicPremium + currentSpouseTotalBasicPremium);

							// TotalAdditionalBenefitPremium
							double currentIndividualTotalAdditionalPremium = (double) _individualItem
									.get("TotalAdditionalBenefitPremium");
							double currentSpouseTotalAdditionalPremium = (double) _spouseItem
									.get("TotalAdditionalBenefitPremium");
							_individualItem.put("TotalAdditionalBenefitPremium",
									currentIndividualTotalAdditionalPremium + currentSpouseTotalAdditionalPremium);

							// TotalAdditionalBenefitPremiumAllChecked
							double currentIndividualTotalAdditionalPremiumAllChecked = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumAllChecked");
							double currentSpouseTotalAdditionalPremiumAllChecked = (double) _spouseItem
									.get("TotalAdditionalBenefitPremiumAllChecked");
							_individualItem.put("TotalAdditionalBenefitPremiumAllChecked",
									currentIndividualTotalAdditionalPremiumAllChecked
											+ currentSpouseTotalAdditionalPremiumAllChecked);

							// TotalAdultMainBenefitPremium
							double currentIndividualTotalAdultMainBenefitPremium = (double) _individualItem
									.get("TotalAdultMainBenefitPremium");
							double currentSpouseTotalAdultMainBenefitPremium = (double) _spouseItem
									.get("TotalAdultMainBenefitPremium");
							_individualItem.put("TotalAdultMainBenefitPremium",
									currentIndividualTotalAdultMainBenefitPremium
											+ currentSpouseTotalAdultMainBenefitPremium);

							// TotalAdultAdditionalBenefitPremium
							double currentIndividualTotalAdultAdditionalBenefitPremium = (double) _individualItem
									.get("TotalAdultAdditionalBenefitPremium");
							double currentSpouseTotalAdultAdditionalBenefitPremium = (double) _spouseItem
									.get("TotalAdultAdditionalBenefitPremium");
							_individualItem.put("TotalAdultAdditionalBenefitPremium",
									currentIndividualTotalAdultAdditionalBenefitPremium
											+ currentSpouseTotalAdultAdditionalBenefitPremium);

							// TotalChildMainBenefitPremium tidak perlu karena ini DUO

							// TotalMainBenefitPremiumInIDR
							double currentIndividualTotalMainBenefitPremiumInIDR = (double) _individualItem
									.get("TotalMainBenefitPremiumInIDR");
							double currentSpouseTotalMainBenefitPremiumInIDR = (double) _spouseItem
									.get("TotalMainBenefitPremiumInIDR");
							_individualItem.put("TotalMainBenefitPremiumInIDR",
									currentIndividualTotalMainBenefitPremiumInIDR
											+ currentSpouseTotalMainBenefitPremiumInIDR);

							// TotalAdditionalBenefitPremiumInIDR
							double currentIndividualTotalAdditionalBenefitPremiumInIDR = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumInIDR");
							double currentSpouseTotalAdditionalBenefitPremiumInIDR = (double) _spouseItem
									.get("TotalAdditionalBenefitPremiumInIDR");
							_individualItem.put("TotalAdditionalBenefitPremiumInIDR",
									currentIndividualTotalAdditionalBenefitPremiumInIDR
											+ currentSpouseTotalAdditionalBenefitPremiumInIDR);

							// TotalAdditionalBenefitPremiumAllcheckedInIDR
							double currentIndividualTotalAdditionalBenefitPremiumAllCheckedInIDR = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
							double currentSpouseTotalAdditionalBenefitPremiumAllCheckedInIDR = (double) _spouseItem
									.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
							_individualItem.put("TotalAdditionalBenefitPremiumAllCheckedInIDR",
									currentIndividualTotalAdditionalBenefitPremiumAllCheckedInIDR
											+ currentSpouseTotalAdditionalBenefitPremiumAllCheckedInIDR);

							// Update total nilai pada masing-masing main benefit di individual (ditambahkan
							// dengan main benefit yang ada di spouse)
							HashMap<String, Double> newMainBenefit = new HashMap<>();

							@SuppressWarnings("unchecked")
							HashMap<String, Double> currentIndividualMainBenefit = (HashMap<String, Double>) _individualItem
									.get("MainBenefit");

							@SuppressWarnings("unchecked")
							HashMap<String, Double> currentSpouseMainBenefit = (HashMap<String, Double>) _spouseItem
									.get("MainBenefit");

							double new1 = currentIndividualMainBenefit.get(mainbenefitKey1)
									+ currentSpouseMainBenefit.get(mainbenefitKey1);
							newMainBenefit.put(mainbenefitKey1, new1);

							double new2 = currentIndividualMainBenefit.get(mainbenefitKey2)
									+ currentSpouseMainBenefit.get(mainbenefitKey2);
							newMainBenefit.put(mainbenefitKey2, new2);
							double new3 = currentIndividualMainBenefit.get(mainbenefitKey3)
									+ currentSpouseMainBenefit.get(mainbenefitKey3);
							newMainBenefit.put(mainbenefitKey3, new3);

							double new4 = currentIndividualMainBenefit.get(mainbenefitKey4)
									+ currentSpouseMainBenefit.get(mainbenefitKey4);
							newMainBenefit.put(mainbenefitKey4, new4);

							// update
							_individualItem.put("MainBenefit", newMainBenefit);

							// add to duo plan container
							duoPlanContainer.add(_individualItem);
						}
					}
				}

				// RETURN RESPONSE DUO
				JSONObject finalResponse = finalResponse(travellerType, travelType, currency, totalInclusiveDays,
						masterCurrency, adultTotal, childTotal, departureDisplayDate, arrivalDisplayDate, discount,
						spesificPlan, choosenPlan, commision, tax, duoPlanContainer, promoCode, paymentMethod,
						_managedBy);
				result.put("Calculation", finalResponse);
				return result;
			}
			// END DUO CONDITION
			// ------------------------------------------------------------

			// FAMILY CONDITION
			// ------------------------------------------------------------

			if (travellerType.equals("family")) {

				if (adultTotal > 1) {
					List<Map<String, Object>> spousePlanContainer = new ArrayList<>();

					List<StiPremi> spousePremis = new ArrayList<>(
							StiPremiLocalServiceUtil.findByCurrencyAndTravellerType(currency, "spouse"));

					// Jika travellerType adalah DUO dan tidak ada data premi untuk spouse,
					// maka return empty JSON
					if (Validator.isNull(spousePremis)) {
						return result;
					}

					Set<Long> planSpouseIds = new HashSet<>();
					for (StiPremi spousePremi : spousePremis) {
						planSpouseIds.add(spousePremi.getPlanId());

					}
					Long[] planSpouseIdsArray = planSpouseIds.toArray(new Long[0]);

					for (Long planId : planSpouseIdsArray) {
						SmartTravelIntPlan _plan = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(planId);

						// JIKA ADA CHOOSEN PLAN, TAMPILKAN SATU PLAN AJA SESUAI CHOOSEN PLAN
						if (!choosenPlan.isEmpty()) {
							if (!_plan.getNameId().equals(choosenPlan)) {
								continue;
							}
						}

						HashMap<String, Object> itemData = new HashMap<>();

						itemData.put("PlanName", _plan.getNameId());

						// data jaminan utama dan harga basic premi di plan saat ini
						double totalMainBenefitPremiPrice = 0;
						double totalAdditionalPrice = 0;
						List<HashMap> mainBenefitList = new ArrayList<>();
						HashMap<String, Double> mainBenefit = new HashMap<>();
						List<HashMap> additionalBenefitList = new ArrayList<>();

						double totalAllAdditionalPrice = 0;

						for (StiPremi premi : spousePremis) {
							if (premi.getPlanId() == planId) {

								StiBenefit currentBenefit = StiBenefitLocalServiceUtil.getStiBenefit(premi.getBenefitId());
								BenefitType currentBenefitType = BenefitTypeLocalServiceUtil
										.getBenefitType(currentBenefit.getBenefitTypeId());

								// MAIN BENEFIT
								if (currentBenefitType.getNameId().equals("Jaminan Utama")
										&& currentBenefitType.getNameEn().equals("Main Benefit")) {
									// single atau tahunan
									if (travelType.equals("single")) {
										totalMainBenefitPremiPrice += premi.getBasic().doubleValue();

										// jika ada additional day
										if (additionalDays > 0) {
											totalMainBenefitPremiPrice += premi.getAdditional().doubleValue()
													* additionalDays;
										}

									} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
										totalMainBenefitPremiPrice += premi.getAnnual().doubleValue();
									}

									StiBenefit benefitObj = StiBenefitLocalServiceUtil.getStiBenefit(premi.getBenefitId());
									mainBenefit.put(benefitObj.getNameId(), premi.getBasic().doubleValue());

									HashMap<String, Object> mainBenefitItem = new HashMap<>();
									mainBenefitItem.put("Name", benefitObj.getNameId());
//									mainBenefitItem.put("Amount", premi.getBasic().doubleValue());

									mainBenefitList.add(mainBenefitItem);
								}

								// ADDITIONAL BENEFITS
								if (!currentBenefitType.getNameId().equals("Jaminan Utama")
										&& !currentBenefitType.getNameEn().equals("Main Benefit")) {

									// jika ada dari pimcore
									if (!referrer.isEmpty()) {
										if (!Validator.isNull(additionalBenefitCodes)) {
											for (int i = 0; i < additionalBenefitCodes.length(); i++) {
												if (additionalBenefitCodes.getString(i)
														.equalsIgnoreCase(currentBenefit.getExternalCode())) {
													// single atau tahunan
													if (travelType.equals("single")) {
														totalAdditionalPrice += premi.getBasic().doubleValue();

														// jika ada additional day
														if (additionalDays > 0) {
															totalAdditionalPrice += premi.getAdditional().doubleValue()
																	* additionalDays;
														}

													} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
														totalAdditionalPrice += premi.getAnnual().doubleValue();
													}

													HashMap<String, Object> additionalBenefitItem = new HashMap<>();
													additionalBenefitItem.put("BenefitCode",
															currentBenefit.getExternalCode());
													additionalBenefitItem.put("Benefit Name",
															currentBenefit.getNameId());
													additionalBenefitItem.put("Benefit Type",
															currentBenefitType.getNameId());

													StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
															.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																	currentBenefitType.getBenefitTypeId(),
																	currentBenefit.getBenefitId(), premi.getPlanId());
													additionalBenefitItem.put("BenefitValueIDR",
                                                            benefitValueMappingObj.getBenefitValue());
													additionalBenefitItem.put("BenefitValueUSD",
                                                            benefitValueMappingObj.getBenefitValueUSD());
//													additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

													additionalBenefitList.add(additionalBenefitItem);

												}
											}
										}
									} else {

										// additional benefits dari FE liferay (bukan pimcore)
										if (!Validator.isNull(additionalBenefits)) {
											for (int i = 0; i < additionalBenefits.length(); i++) {
												if (additionalBenefits.getInt(i) == currentBenefit.getBenefitId()) {

													// single atau tahunan
													if (travelType.equals("single")) {
														totalAdditionalPrice += premi.getBasic().doubleValue();

														// jika ada additional day
														if (additionalDays > 0) {
															totalAdditionalPrice += premi.getAdditional().doubleValue()
																	* additionalDays;
														}

													} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
														totalAdditionalPrice += premi.getAnnual().doubleValue();
													}

													HashMap<String, Object> additionalBenefitItem = new HashMap<>();
													additionalBenefitItem.put("BenefitCode",
															currentBenefit.getExternalCode());
													additionalBenefitItem.put("Benefit Name",
															currentBenefit.getNameId());
													additionalBenefitItem.put("Benefit Type",
															currentBenefitType.getNameId());

													StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
															.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																	currentBenefitType.getBenefitTypeId(),
																	currentBenefit.getBenefitId(), premi.getPlanId());
													additionalBenefitItem.put("BenefitValueIDR",
                                                            benefitValueMappingObj.getBenefitValue());
													additionalBenefitItem.put("BenefitValueUSD",
                                                            benefitValueMappingObj.getBenefitValueUSD());
//													additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

													additionalBenefitList.add(additionalBenefitItem);
												}
											}
										}
										// end additional benefit liferay (bukan pimcore

									}

									// HITUNG SEMUA ADDITIONAL BENEFIT BY DEFAULT
									// BUKAN BERDASARKAN BENEFIT YANG DIPILIH
									// --------------------------------------------
									// single atau tahunan
									if (travelType.equals("single")) {
										totalAllAdditionalPrice += premi.getBasic().doubleValue();
										if (fp == 1) {
											totalAdditionalPrice += premi.getBasic().doubleValue();
										}

										// jika ada additional day
										if (additionalDays > 0) {
											totalAllAdditionalPrice += premi.getAdditional().doubleValue()
													* additionalDays;
											if (fp == 1) {
												totalAdditionalPrice += premi.getAdditional().doubleValue()
														* additionalDays;
											}
										}

									} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
										totalAllAdditionalPrice += premi.getAnnual().doubleValue();
										if (fp == 1) {
											totalAdditionalPrice += premi.getAnnual().doubleValue();
										}
									}

								}
								// END ADDITIONAL BENEFITS
							}
						}

						itemData.put("MainBenefit", mainBenefit);
						itemData.put("MainBenefitList", mainBenefitList);
						itemData.put("AdditionalBenefitList", additionalBenefitList);

						itemData.put("TotalMainBenefitPremium", totalMainBenefitPremiPrice);
						itemData.put("TotalAdditionalBenefitPremium", totalAdditionalPrice);
						itemData.put("TotalAdditionalBenefitPremiumAllChecked", totalAllAdditionalPrice);

						itemData.put("TotalAdultMainBenefitPremium", totalMainBenefitPremiPrice);
						itemData.put("TotalAdultAdditionalBenefitPremium", totalAdditionalPrice);

						itemData.put("TotalChildMainBenefitPremium", 0.0);
						itemData.put("TotalChildAdditionalBenefitPremium", 0.0);

						// konversi berdasarkan currency
						double totalMainBenefitPremiPriceUSDInIDR = 0.0;
						double totalAdditionalPriceUSDInIDR = 0.0;
						double totalAllAdditionalPriceUSDInIDR = 0.0;

						totalMainBenefitPremiPriceUSDInIDR = (double) (totalMainBenefitPremiPrice
								* masterCurrency.getAmount());
						totalAdditionalPriceUSDInIDR = (double) (totalAdditionalPrice * masterCurrency.getAmount());
						totalAllAdditionalPriceUSDInIDR = (double) (totalAllAdditionalPrice
								* masterCurrency.getAmount());

						// ada isinya jika currency yang dipilih USD
						itemData.put("TotalMainBenefitPremiumInIDR", totalMainBenefitPremiPriceUSDInIDR);
						itemData.put("TotalAdditionalBenefitPremiumInIDR", totalAdditionalPriceUSDInIDR);
						itemData.put("TotalAdditionalBenefitPremiumAllCheckedInIDR", totalAllAdditionalPriceUSDInIDR);

						spousePlanContainer.add(itemData);
					}

					// JUMLAHKAN INDIVIDU DAN SPOUSE UNTUK FAMILY
					for (Map<String, Object> _individualItem : individualPlanContainer) {
						String currentIndividualPlanName = (String) _individualItem.get("PlanName");
//						
						for (Map<String, Object> _spouseItem : spousePlanContainer) {
							String currentSpousePlanName = (String) _spouseItem.get("PlanName");

							if (currentSpousePlanName.equals(currentIndividualPlanName)) {

								// TotalMainBenefitPremium
								double currentIndividualTotalBasicPremium = (double) _individualItem
										.get("TotalMainBenefitPremium");
								double currentSpouseTotalBasicPremium = (double) _spouseItem
										.get("TotalMainBenefitPremium");
								_individualItem.put("TotalMainBenefitPremium",
										currentIndividualTotalBasicPremium + currentSpouseTotalBasicPremium);

								// TotalAdditionalBenefitPremium
								double currentIndividualTotalAdditionalPremium = (double) _individualItem
										.get("TotalAdditionalBenefitPremium");
								double currentSpouseTotalAdditionalPremium = (double) _spouseItem
										.get("TotalAdditionalBenefitPremium");
								_individualItem.put("TotalAdditionalBenefitPremium",
										currentIndividualTotalAdditionalPremium + currentSpouseTotalAdditionalPremium);

								// TotalAdditionalBenefitPremiumAllChecked
								double currentIndividualTotalAdditionalPremiumAllChecked = (double) _individualItem
										.get("TotalAdditionalBenefitPremiumAllChecked");
								double currentSpouseTotalAdditionalPremiumAllChecked = (double) _spouseItem
										.get("TotalAdditionalBenefitPremiumAllChecked");
								_individualItem.put("TotalAdditionalBenefitPremiumAllChecked",
										currentIndividualTotalAdditionalPremiumAllChecked
												+ currentSpouseTotalAdditionalPremiumAllChecked);

								// TotalAdultMainBenefitPremium
								double currentIndividualTotalAdultMainBenefitPremium = (double) _individualItem
										.get("TotalAdultMainBenefitPremium");
								double currentSpouseTotalAdultMainBenefitPremium = (double) _spouseItem
										.get("TotalAdultMainBenefitPremium");
								_individualItem.put("TotalAdultMainBenefitPremium",
										currentIndividualTotalAdultMainBenefitPremium
												+ currentSpouseTotalAdultMainBenefitPremium);

								// TotalAdultAdditionalBenefitPremium
								double currentIndividualTotalAdultAdditionalBenefitPremium = (double) _individualItem
										.get("TotalAdultAdditionalBenefitPremium");
								double currentSpouseTotalAdultAdditionalBenefitPremium = (double) _spouseItem
										.get("TotalAdultAdditionalBenefitPremium");
								_individualItem.put("TotalAdultAdditionalBenefitPremium",
										currentIndividualTotalAdultAdditionalBenefitPremium
												+ currentSpouseTotalAdultAdditionalBenefitPremium);

								// TotalChildMainBenefitPremium tidak perlu karena ini DUO

								// TotalMainBenefitPremiumInIDR
								double currentIndividualTotalMainBenefitPremiumInIDR = (double) _individualItem
										.get("TotalMainBenefitPremiumInIDR");
								double currentSpouseTotalMainBenefitPremiumInIDR = (double) _spouseItem
										.get("TotalMainBenefitPremiumInIDR");
								_individualItem.put("TotalMainBenefitPremiumInIDR",
										currentIndividualTotalMainBenefitPremiumInIDR
												+ currentSpouseTotalMainBenefitPremiumInIDR);

								// TotalAdditionalBenefitPremiumInIDR
								double currentIndividualTotalAdditionalBenefitPremiumInIDR = (double) _individualItem
										.get("TotalAdditionalBenefitPremiumInIDR");
								double currentSpouseTotalAdditionalBenefitPremiumInIDR = (double) _spouseItem
										.get("TotalAdditionalBenefitPremiumInIDR");
								_individualItem.put("TotalAdditionalBenefitPremiumInIDR",
										currentIndividualTotalAdditionalBenefitPremiumInIDR
												+ currentSpouseTotalAdditionalBenefitPremiumInIDR);

								// TotalAdditionalBenefitPremiumAllCheckedInIDR
								double currentIndividualTotalAdditionalBenefitPremiumAllCheckedInIDR = (double) _individualItem
										.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
								double currentSpouseTotalAdditionalBenefitPremiumAllCheckedInIDR = (double) _spouseItem
										.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
								_individualItem.put("TotalAdditionalBenefitPremiumAllCheckedInIDR",
										currentIndividualTotalAdditionalBenefitPremiumAllCheckedInIDR
												+ currentSpouseTotalAdditionalBenefitPremiumAllCheckedInIDR);

								// Update total nilai pada masing-masing main benefit di individual (ditambahkan
								// dengan main benefit yang ada di spouse)
								HashMap<String, Double> newMainBenefit = new HashMap<>();

								@SuppressWarnings("unchecked")
								HashMap<String, Double> currentIndividualMainBenefit = (HashMap<String, Double>) _individualItem
										.get("MainBenefit");

								@SuppressWarnings("unchecked")
								HashMap<String, Double> currentSpouseMainBenefit = (HashMap<String, Double>) _spouseItem
										.get("MainBenefit");

								double new1 = currentIndividualMainBenefit.get(mainbenefitKey1)
										+ currentSpouseMainBenefit.get(mainbenefitKey1);
								newMainBenefit.put(mainbenefitKey1, new1);

								double new2 = currentIndividualMainBenefit.get(mainbenefitKey2)
										+ currentSpouseMainBenefit.get(mainbenefitKey2);
								newMainBenefit.put(mainbenefitKey2, new2);

								double new3 = currentIndividualMainBenefit.get(mainbenefitKey3)
										+ currentSpouseMainBenefit.get(mainbenefitKey3);
								newMainBenefit.put(mainbenefitKey3, new3);

								double new4 = currentIndividualMainBenefit.get(mainbenefitKey4)
										+ currentSpouseMainBenefit.get(mainbenefitKey4);
								newMainBenefit.put(mainbenefitKey4, new4);

								// update
								_individualItem.put("MainBenefit", newMainBenefit);
							}
						}
					}

				}

				// Calculate children premi
				List<Map<String, Object>> childrenPlanContainer = new ArrayList<>();
				List<StiPremi> childrenPremis = new ArrayList<>(
						StiPremiLocalServiceUtil.findByCurrencyAndTravellerType(currency, "children"));
				if (Validator.isNull(childrenPremis)) {
					return result;
				}

				Set<Long> planChildrenIds = new HashSet<>();
				for (StiPremi childrenPremi : childrenPremis) {
					planChildrenIds.add(childrenPremi.getPlanId());
				}
				Long[] planChildrenIdsArray = planChildrenIds.toArray(new Long[0]);

				for (Long planId : planChildrenIdsArray) {
					SmartTravelIntPlan _plan = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(planId);
					HashMap<String, Object> itemData = new HashMap<>();

					itemData.put("PlanName", _plan.getNameId());

					// data jaminan utama dan harga basic premi di plan saat ini
					double totalMainBenefitPremiPrice = 0;
					double totalAdditionalPrice = 0;
					List<HashMap> mainBenefitList = new ArrayList<>();
					HashMap<String, Double> mainBenefit = new HashMap<>();
					List<HashMap> additionalBenefitList = new ArrayList<>();

					double totalAllAdditionalPrice = 0;

					for (StiPremi premi : childrenPremis) {
						if (premi.getPlanId() == planId) {

							StiBenefit currentBenefit = StiBenefitLocalServiceUtil.getStiBenefit(premi.getBenefitId());
							BenefitType currentBenefitType = BenefitTypeLocalServiceUtil
									.getBenefitType(currentBenefit.getBenefitTypeId());

							// MAIN BENEFIT
							if (currentBenefitType.getNameId().equals("Jaminan Utama")
									&& currentBenefitType.getNameEn().equals("Main Benefit")) {
								// single atau tahunan
								if (travelType.equals("single")) {
									totalMainBenefitPremiPrice += premi.getBasic().doubleValue();

									// jika ada additional day
									if (additionalDays > 0) {
										totalMainBenefitPremiPrice += premi.getAdditional().doubleValue()
												* additionalDays;
									}

								} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
									totalMainBenefitPremiPrice += premi.getAnnual().doubleValue();
								}

								StiBenefit benefitObj = StiBenefitLocalServiceUtil.getStiBenefit(premi.getBenefitId());
								mainBenefit.put(benefitObj.getNameId(), premi.getBasic().doubleValue() * childTotal);

								HashMap<String, Object> mainBenefitItem = new HashMap<>();
								mainBenefitItem.put("Name", benefitObj.getNameId());
								mainBenefitItem.put("Amount", premi.getBasic().doubleValue() * childTotal);

								mainBenefitList.add(mainBenefitItem);
							}

							// ADDITIONAL BENEFITS
							if (!currentBenefitType.getNameId().equals("Jaminan Utama")
									&& !currentBenefitType.getNameEn().equals("Main Benefit")) {

								// jika ada dari pimcore
								if (!referrer.isEmpty()) {
									if (!Validator.isNull(additionalBenefitCodes)) {
										for (int i = 0; i < additionalBenefitCodes.length(); i++) {
											if (additionalBenefitCodes.getString(i)
													.equalsIgnoreCase(currentBenefit.getExternalCode())) {
												// single atau tahunan
												if (travelType.equals("single")) {
													totalAdditionalPrice += premi.getBasic().doubleValue();

													// jika ada additional day
													if (additionalDays > 0) {
														totalAdditionalPrice += premi.getAdditional().doubleValue()
																* additionalDays;
													}

												} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
													totalAdditionalPrice += premi.getAnnual().doubleValue();
												}

												HashMap<String, Object> additionalBenefitItem = new HashMap<>();
												additionalBenefitItem.put("BenefitCode",
														currentBenefit.getExternalCode());
												additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
												additionalBenefitItem.put("Benefit Type",
														currentBenefitType.getNameId());

												StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
														.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																currentBenefitType.getBenefitTypeId(),
																currentBenefit.getBenefitId(), premi.getPlanId());
												additionalBenefitItem.put("BenefitValueIDR", benefitValueMappingObj.getBenefitValue());
												additionalBenefitItem.put("BenefitValueUSD", benefitValueMappingObj.getBenefitValueUSD());
//												additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

												additionalBenefitList.add(additionalBenefitItem);

											}
										}
									}
								} else {

									// additional benefits dari FE liferay (bukan pimcore)
									if (!Validator.isNull(additionalBenefits)) {
										for (int i = 0; i < additionalBenefits.length(); i++) {
											if (additionalBenefits.getInt(i) == currentBenefit.getBenefitId()) {

												// single atau tahunan
												if (travelType.equals("single")) {
													totalAdditionalPrice += premi.getBasic().doubleValue();

													// jika ada additional day
													if (additionalDays > 0) {
														totalAdditionalPrice += premi.getAdditional().doubleValue()
																* additionalDays;
													}

												} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
													totalAdditionalPrice += premi.getAnnual().doubleValue();
												}

												HashMap<String, Object> additionalBenefitItem = new HashMap<>();
												additionalBenefitItem.put("BenefitCode",
														currentBenefit.getExternalCode());
												additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
												additionalBenefitItem.put("Benefit Type",
														currentBenefitType.getNameId());

												StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
														.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																currentBenefitType.getBenefitTypeId(),
																currentBenefit.getBenefitId(), premi.getPlanId());
												additionalBenefitItem.put("BenefitValueIDR", benefitValueMappingObj.getBenefitValue());
												additionalBenefitItem.put("BenefitValueUSD", benefitValueMappingObj.getBenefitValueUSD());
//												additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

												additionalBenefitList.add(additionalBenefitItem);
											}
										}
									}
									// end additional benefit liferay (bukan pimcore

								}

								// HITUNG SEMUA ADDITIONAL BENEFIT BY DEFAULT
								// BUKAN BERDASARKAN BENEFIT YANG DIPILIH
								// --------------------------------------------
								// single atau tahunan
								if (travelType.equals("single")) {
									totalAllAdditionalPrice += premi.getBasic().doubleValue();
									if (fp == 1) {
										totalAdditionalPrice += premi.getBasic().doubleValue();
									}

									// jika ada additional day
									if (additionalDays > 0) {
										totalAllAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;
										if (fp == 1) {
											totalAdditionalPrice += premi.getAdditional().doubleValue()
													* additionalDays;
										}
									}

								} else if (travelType.equals(TRAVEL_TYPE_ANNUAL)) {
									totalAllAdditionalPrice += premi.getAnnual().doubleValue();
									if (fp == 1) {
										totalAdditionalPrice += premi.getAnnual().doubleValue();
									}
								}

							}
							// END ADDITIONAL BENEFITS
						}
					}

					itemData.put("MainBenefit", mainBenefit);
					itemData.put("MainBenefitList", mainBenefitList);
					itemData.put("AdditionalBenefitList", additionalBenefitList);

					itemData.put("TotalMainBenefitPremium", totalMainBenefitPremiPrice * childTotal);
					itemData.put("TotalAdditionalBenefitPremium", totalAdditionalPrice * childTotal);
					itemData.put("TotalAdditionalBenefitPremiumAllChecked", totalAllAdditionalPrice * childTotal);

					itemData.put("TotalAdultMainBenefitPremium", 0.0);
					itemData.put("TotalAdultAdditionalBenefitPremium", 0.0);

					itemData.put("TotalChildMainBenefitPremium", totalMainBenefitPremiPrice * childTotal);
					itemData.put("TotalChildAdditionalBenefitPremium", totalAdditionalPrice * childTotal);

					// konversi berdasarkan currency
					double totalMainBenefitPremiPriceUSDInIDR = 0.0;
					double totalAdditionalPriceUSDInIDR = 0.0;
					double totalAllAdditionalPriceUSDInIDR = 0.0;

					totalMainBenefitPremiPriceUSDInIDR = (long) (totalMainBenefitPremiPrice
							* masterCurrency.getAmount());
					totalAdditionalPriceUSDInIDR = (long) (totalAdditionalPrice * masterCurrency.getAmount());
					totalAllAdditionalPriceUSDInIDR = (double) (totalAllAdditionalPrice * masterCurrency.getAmount());

					// ada isinya jika currency yang dipilih USD
					itemData.put("TotalMainBenefitPremiumInIDR", totalMainBenefitPremiPriceUSDInIDR * childTotal);
					itemData.put("TotalAdditionalBenefitPremiumInIDR", totalAdditionalPriceUSDInIDR * childTotal);
					itemData.put("TotalAdditionalBenefitPremiumAllCheckedInIDR",
							totalAllAdditionalPriceUSDInIDR * childTotal);

					childrenPlanContainer.add(itemData);

				}

				// CALCULATE PREMI (INDIVIDU YANG SUDAH DIJUMLAH DENGAN SPOUSE) + CHILDREN
				List<Map<String, Object>> familyPlanContainer = new ArrayList<>();

				// individualPlanContainer disini adalah individu yang sudah dijumlah dengan
				// spouse
				for (Map<String, Object> _individualItem : individualPlanContainer) {
					String currentIndividualPlanName = (String) _individualItem.get("PlanName");
//					
					for (Map<String, Object> _childrenItem : childrenPlanContainer) {
						String currentChildrenPlanName = (String) _childrenItem.get("PlanName");

						if (currentChildrenPlanName.equals(currentIndividualPlanName)) {

							double currentIndividualTotalBasicPremium = (double) _individualItem
									.get("TotalMainBenefitPremium");
							double currentChildrenTotalBasicPremium = (double) _childrenItem
									.get("TotalMainBenefitPremium");
							currentIndividualTotalBasicPremium = currentIndividualTotalBasicPremium
									+ currentChildrenTotalBasicPremium;
							_individualItem.put("TotalMainBenefitPremium", currentIndividualTotalBasicPremium);

							// IN IDR
							double currentIndividualTotalBasicPremiumInIDR = (double) _individualItem
									.get("TotalMainBenefitPremiumInIDR");
							double currentChildrenTotalBasicPremiumInIDR = (double) _childrenItem
									.get("TotalMainBenefitPremiumInIDR");
							currentIndividualTotalBasicPremiumInIDR = currentIndividualTotalBasicPremiumInIDR
									+ currentChildrenTotalBasicPremiumInIDR;
							_individualItem.put("TotalMainBenefitPremiumInIDR",
									currentIndividualTotalBasicPremiumInIDR);

							// -----------------------

							double currentIndividualTotalAdditionalPremium = (double) _individualItem
									.get("TotalAdditionalBenefitPremium");
							double currentChildrenTotalAdditionalPremium = (double) _childrenItem
									.get("TotalAdditionalBenefitPremium");
							currentIndividualTotalAdditionalPremium = currentIndividualTotalAdditionalPremium
									+ currentChildrenTotalAdditionalPremium;
							_individualItem.put("TotalAdditionalBenefitPremium",
									currentIndividualTotalAdditionalPremium);

							// IN IDR
							double currentIndividualTotalAdditionalPremiumInIDR = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumInIDR");
							double currentChildrenTotalAdditionalPremiumInIDR = (double) _childrenItem
									.get("TotalAdditionalBenefitPremiumInIDR");
							currentIndividualTotalAdditionalPremiumInIDR = currentIndividualTotalAdditionalPremiumInIDR
									+ currentChildrenTotalAdditionalPremiumInIDR;
							_individualItem.put("TotalAdditionalBenefitPremiumInIDR",
									currentIndividualTotalAdditionalPremiumInIDR);

							// -----------------------

							double currentIndividualTotalAdditionalPremiumAllChecked = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumAllChecked");
							double currentChildrenTotalAdditionalPremiumAllChecked = (double) _childrenItem
									.get("TotalAdditionalBenefitPremiumAllChecked");
							currentIndividualTotalAdditionalPremiumAllChecked = currentIndividualTotalAdditionalPremiumAllChecked
									+ currentChildrenTotalAdditionalPremiumAllChecked;
							_individualItem.put("TotalAdditionalBenefitPremiumAllChecked",
									currentIndividualTotalAdditionalPremiumAllChecked);

							// IN IDR
							double currentIndividualTotalAdditionalPremiumAllCheckedInIDR = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
							double currentChildrenTotalAdditionalPremiumAllCheckedInIDR = (double) _childrenItem
									.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
							currentIndividualTotalAdditionalPremiumAllCheckedInIDR = currentIndividualTotalAdditionalPremiumAllCheckedInIDR
									+ currentChildrenTotalAdditionalPremiumAllCheckedInIDR;
							_individualItem.put("TotalAdditionalBenefitPremiumAllCheckedInIDR",
									currentIndividualTotalAdditionalPremiumAllCheckedInIDR);

							// -----------------------

							// ADULT
							double currentIndividualTotalAdultMainBenefitPremium = (double) _individualItem
									.get("TotalAdultMainBenefitPremium");
							double currentChildrenTotalAdultMainBenefitPremium = (double) _childrenItem
									.get("TotalAdultMainBenefitPremium");
							currentIndividualTotalAdultMainBenefitPremium = currentIndividualTotalAdultMainBenefitPremium
									+ currentChildrenTotalAdultMainBenefitPremium;
							_individualItem.put("TotalAdultMainBenefitPremium",
									currentIndividualTotalAdultMainBenefitPremium);

							// CHILD
							double currentIndividualTotalChildMainBenefitPremium = (double) _individualItem
									.get("TotalChildMainBenefitPremium");
							double currentChildrenTotalChildMainBenefitPremium = (double) _childrenItem
									.get("TotalChildMainBenefitPremium");
							currentIndividualTotalChildMainBenefitPremium = currentIndividualTotalChildMainBenefitPremium
									+ currentChildrenTotalChildMainBenefitPremium;
							_individualItem.put("TotalChildMainBenefitPremium",
									currentIndividualTotalChildMainBenefitPremium);

							// CHILD ADDITIONAL
							double currentIndividualTotalChildAdditionalBenefitPremium = (double) _individualItem
									.get("TotalChildAdditionalBenefitPremium");
							double currentTotalChildAdditionalBenefitPremium = (double) _childrenItem
									.get("TotalChildAdditionalBenefitPremium");
							currentIndividualTotalChildAdditionalBenefitPremium = currentIndividualTotalChildAdditionalBenefitPremium
									+ currentTotalChildAdditionalBenefitPremium;
							_individualItem.put("TotalChildAdditionalBenefitPremium",
									currentIndividualTotalChildAdditionalBenefitPremium);

							HashMap<String, Double> newMainBenefit = new HashMap<>();

							@SuppressWarnings("unchecked")
							HashMap<String, Double> currentIndividualMainBenefit = (HashMap<String, Double>) _individualItem
									.get("MainBenefit");

							@SuppressWarnings("unchecked")
							HashMap<String, Double> currentChildrenMainBenefit = (HashMap<String, Double>) _childrenItem
									.get("MainBenefit");

							double new1 = currentIndividualMainBenefit.get(mainbenefitKey1)
									+ currentChildrenMainBenefit.get(mainbenefitKey1);
							newMainBenefit.put(mainbenefitKey1, new1);

							double new2 = currentIndividualMainBenefit.get(mainbenefitKey2)
									+ currentChildrenMainBenefit.get(mainbenefitKey2);
							newMainBenefit.put(mainbenefitKey2, new2);

							double new3 = currentIndividualMainBenefit.get(mainbenefitKey3)
									+ currentChildrenMainBenefit.get(mainbenefitKey3);
							newMainBenefit.put(mainbenefitKey3, new3);

							double new4 = currentIndividualMainBenefit.get(mainbenefitKey4)
									+ currentChildrenMainBenefit.get(mainbenefitKey4);
							newMainBenefit.put(mainbenefitKey4, new4);

							// update
							_individualItem.put("MainBenefit", newMainBenefit);

							// add to duo plan container
							familyPlanContainer.add(_individualItem);
						}
					}
				}

				// Final response for family
				JSONObject finalResponse = finalResponse(travellerType, travelType, currency, totalInclusiveDays,
						masterCurrency, adultTotal, childTotal, departureDisplayDate, arrivalDisplayDate, discount,
						spesificPlan, choosenPlan, commision, tax, familyPlanContainer, promoCode, paymentMethod,
						_managedBy);
				result.put("Calculation", finalResponse);
				return result;
			}
			// END FAMILY CONDITION
			// -----------------------------------------------------------

			// Final response for Individual Only
			JSONObject finalResponse = finalResponse(travellerType, travelType, currency, totalInclusiveDays,
					masterCurrency, adultTotal, childTotal, departureDisplayDate, arrivalDisplayDate, discount,
					spesificPlan, choosenPlan, commision, tax, individualPlanContainer, promoCode, paymentMethod,
					_managedBy);
			result.put("Calculation", finalResponse);
			return result;
		} catch (Exception e) {
            _logs.error("Error during API call", e);
			throw e;
		}
	}

	// CALCULATE PREMI ENDPOINT
	@POST
	@Path("/calculate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String calculate(String request, @Context HttpServletRequest httpServletRequest)
			throws JSONException, IOException {
		JSONObject response = JSONFactoryUtil.createJSONObject();

		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		int fp = params.getInt("fp"); // full package
		String promoCode = params.getString("PromoCode");

		String _currency = params.getString("Currency");
		String _travellerType = params.getString("TravellerType");
		String startDate = params.getString("DepartureDate");
		String expiredDate = params.getString("ArrivalDate");
		String _traveltype = params.getString("TravelType");
		String _adultTotal = params.getString("AdultTotal");

		String _businessModel = params.getString("BusinessModel");
		String _managedBy = params.getString("ManagedBy");
		String _managedById = params.getString("ManagedById");

		String __plan = "";
		String _spesificPlan = params.getString("SpesificPlan");
		String _choosenPlan = params.getString("ChoosenPlan");
		String _roleUser = params.getString("Role", "");

		if (!promoCode.isEmpty()) {

			if (!_spesificPlan.isEmpty()) {
				__plan = _spesificPlan;
			} else if (!_choosenPlan.isEmpty()) {
				__plan = _choosenPlan;
			}

			if (!startDate.isEmpty() && !expiredDate.isEmpty() && !__plan.isEmpty() && !_travellerType.isEmpty()) {
				try {
					double promoCodeDiscount = 0.0;

					HashMap<String, Object> mainBody = new HashMap<String, Object>();
					mainBody.put("PromoCode", promoCode.toUpperCase());
					mainBody.put("ProductCode", "IT6");

					String _channel = "DIRECT";
					if (_businessModel.equalsIgnoreCase("b2b") || _businessModel.equalsIgnoreCase("b2b2c")) {
						_channel = _roleUser;
					}
					mainBody.put("Channel", _channel);

					String _encryptedManagedBy = "";
					if (!_managedBy.isEmpty()) {
						_encryptedManagedBy = _managedBy;
					}
//					mainBody.put("ManagedBy", _encryptedManagedBy);
					mainBody.put("ManagedById", _managedById);

					DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
					DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

					LocalDate _startdate = LocalDate.parse(startDate, inputFormatter);
					String _startdateFormatted = _startdate.format(outputFormatter);

					LocalDate _expiredDate = LocalDate.parse(expiredDate, inputFormatter);
					String _expiredDateFormatted = _expiredDate.format(outputFormatter);

					mainBody.put("leadsStartDate", _startdateFormatted);
					mainBody.put("leadsExpiredDate", _expiredDateFormatted);

					mainBody.put("Plan", __plan);

					// Traveller type
					if (_travellerType.equalsIgnoreCase(TRAVELLER_TYPE_INDIVIDUAL)) {
						_travellerType = "Sendiri";
					} else if (_travellerType.equalsIgnoreCase("duo")) {
						_travellerType = "Duo";
					} else if (_travellerType.equalsIgnoreCase("family")) {
						_travellerType = "Keluarga";
					}
					mainBody.put("TravellerType", _travellerType);

					Gson gson = new Gson();
					String payload = "";
					payload = gson.toJson(mainBody);

					JSONObject _callAPI = null;
					try {
						_callAPI = callAPI(payload, PIMCORE_ADDRESS + CHECK_PROMOCODE_PIMCORE_ENDPOINT);

						if (_callAPI.getInt("Status") > 0) {
							promoCodeDiscount = _callAPI.getJSONObject("Data").getDouble("Discount");
							double _commisionFromResponsePromoCode = _callAPI.getJSONObject("Data")
									.getJSONObject("Agent").getDouble("Commission");
							params.put("Commission", _commisionFromResponsePromoCode);

						} else {
							JSONObject _responsePromoCode = JSONFactoryUtil.createJSONObject();
							_responsePromoCode.put("Status", 0);
							_responsePromoCode.put("Message", _callAPI.getString("Message"));
							_responsePromoCode.put("Data", "");
							_responsePromoCode.put("PromoCodeResponse", true);

							return _responsePromoCode.toString();
						}
					} catch (Exception e) {
						_log.debug("[CALL API][PROMOCODE][EXCEPTION]: " + e.getMessage());
						return errorMessage("Calculate Failed").toString();
					}

					params.put("Discount", promoCodeDiscount);

				} catch (Exception e) {
					_log.debug("[CALCULATE][PROMOCODE][EXCEPTION]: " + e.getMessage());
					return errorMessage(e.getMessage()).toString();
				}
			}
		}

		String choosenPlan = params.getString("SpesificPlan");

		try {

			if (_currency.isEmpty() || _travellerType.isEmpty() || startDate.isEmpty() || expiredDate.isEmpty()
					|| _traveltype.isEmpty() || _adultTotal.isEmpty()) {
				throw new Exception("Invalid Param");
			}

			JSONObject _calculatePremi = null;
			if (!Validator.isBlank(choosenPlan)) {
				_calculatePremi = calculatePremi(params, true);
			} else {
				_calculatePremi = calculatePremi(params, false);
			}

//			_logs.info("CALCULATE PREMI][RESULT]["+currentNumericTimeStamp+"]: " + _calculatePremi);

			response.put("Status", 1);
			response.put("Message", "Data is ready");
			response.put("Data", _calculatePremi);
		} catch (Exception e) {
			response.put("Status", 0);
			response.put("Message", e.getMessage());
			response.put("Data", "");
		}

		return response.toString();
	}

	// PURCHASE DETAILS
	@POST
	@Path("/pd")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String purchaseDetail(String request, @Context HttpServletRequest httpServletRequest)
			throws PortalException {

		/**
		 * calc PD01: something wrong when init variable PD02: XSS validation is not
		 * passed PD03: token limiter param is empty PD04: token limiter is null or is
		 * not valid PD05: error when process XSS validation and agent token limiter
		 * PD06: currency is empty / not exist in parameter PD07: product configuration
		 * is null and product code is not found PD08: departure date param is empty
		 * PD09: arrival date param is empty
		 */

		// Init Variables
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONObject dataLeads = JSONFactoryUtil.createJSONObject(); // Data untuk param LeadsLocalService

		ProductConfiguration productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartTravel2Application.class.getName(), httpServletRequest);

        String paramPurchaseDetailQuotation = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_QUOTATION);
        boolean quotation = "1".equals(paramPurchaseDetailQuotation);
		long agentTokenLimiterId = 0;
		long currentLeadsId = 0;
		String leadsType = "kyc";
		Leads existingLeads = null;
		boolean modifyOrReorder = params.getBoolean("ModifyOrRepeatOrderStat");
        long userId = serviceContext.getGuestOrUserId();

		// CHECK XSS AND TOKEN LIMITER
		try {
			if (quotation) {
				Map<String, Object> payloadMap = convertJsonToMap(request);
                // XSSValidator.validatePayload(payloadMap);

                String tokenLimiter = params.getString("Tlmtr");
				_logs.info("[PURCHASE_DETAIL][TOKEN LIMITER]: " + tokenLimiter);

				if (tokenLimiter.isEmpty()) {
					return errorMessage("Failed to process quotation - PD03").toString();
				} else {
					AgentTokenLimiter atl = AgentTokenLimiterLocalServiceUtil.getAgentTokenLimiterByToken(tokenLimiter);
					agentTokenLimiterId = atl.getAgentTokenLimiterId();
					_logs.info("[PURCHASE_DETAIL][AGENT TOKEN LIMITER OBJECT]: " + atl);
					if (atl == null || atl.getIsValid() < 1) {
						return errorMessage("Failed to process quotation - PD04").toString();
					}
				}
			}
		} catch (Exception e) {
			_logs.info("[PURCHASE_DETAIL][XSS AND TOKEN LIMITER ERROR]: " + e.getMessage());
			return errorMessage("Failed to process quotation - PD05").toString();
		}

		// Currency
		String choosenCurrency = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_CURRENCY);
		if (!choosenCurrency.isEmpty()) {
			if (choosenCurrency.equals("idr")) {
				choosenCurrency = "IDR";
			} else {
				choosenCurrency = "USD";
			}
		} else {
			return errorMessage("Currency is empty - PD06").toString();
		}

		// Product Code
		String productCode = "";
		if (!Validator.isNull(productConfiguration)) {
			productCode = productConfiguration.getProductCode();
		} else {
			return errorMessage("Product code is not found - PD07").toString();
		}

		// Check departure date param
		String departureDate = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_DEPARTUREDATE, null);
		if (departureDate != null && !departureDate.isEmpty()) {
            dataLeads.put(DATA_LEADS_KEY_POLICYSTARTDATE, customFormatDate(departureDate));
		} else {
			return errorMessage("Departure date is empty - PD08").toString();
		}

		// Check arrival date param
		String arrivalDate = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_ARRIVALDATE, null);
		if (arrivalDate != null && !arrivalDate.isEmpty()) {
            dataLeads.put(DATA_LEADS_KEY_POLICYENDDATE, customFormatDate(arrivalDate));
		} else {
			return errorMessage("Arrival date is empty - PD09").toString();
		}

		// Get value from quotation form
		if (quotation) {
			leadsType = "quotation";
            dataLeads.put(DATA_LEADS_KEY_NAME, params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_NAME));
            dataLeads.put(DATA_LEADS_KEY_EMAIL, params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_EMAIL).trim());
		}

		// Check param token
		// this token will be used as param to edit leads
		if (!params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_TOKEN).isEmpty()) {
			existingLeads = LeadsLocalServiceUtil.findByToken(params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_TOKEN));

			if (existingLeads != null) {
				currentLeadsId = existingLeads.getLeadsId();
                dataLeads.put(DATA_LEADS_KEY_TOKEN, params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_TOKEN));
			}
		}

		String pdManagedBy = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_MANAGEDBY);
		String pdManagedById = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_MANAGEDBYID);
		String pdRole = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_ROLE);
		String pdBusinessModel = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_BUSINESSMODEL);
		String pdChannel = PURCHASE_CHANNEL_DIRECT;

		if (pdBusinessModel.equalsIgnoreCase("b2b") || pdBusinessModel.equalsIgnoreCase("b2b2c")) {
            pdChannel = pdRole;
		}

		// Check promocode param
		String promoCode = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_PROMOCODE);

        dataLeads.put("Currency", choosenCurrency);
        dataLeads.put(DATA_LEADS_KEY_LEADSTYPE, leadsType);
        dataLeads.put(DATA_LEADS_KEY_BUSINESSMODEL, pdBusinessModel);
        dataLeads.put("Channel", pdChannel);
        dataLeads.put("ManagedBy", pdManagedBy);
        dataLeads.put("ProductCode", productCode);
        dataLeads.put("Active", 1);
        dataLeads.put("PromoCode", promoCode);

		// Jika ada promocode, ambil nilai diskon ke API Promocode Pimcore
		if (!promoCode.isEmpty()) {
			try {
				double promoCodeDiscount = 0;
				HashMap<String, Object> mainBody = new HashMap<>();

				String encryptedManagedBy = "";
				if (!pdManagedBy.isEmpty()) {
                    encryptedManagedBy = pdManagedBy;
				}

				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
				DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate departureDateParsed = LocalDate.parse(departureDate, inputFormatter);
				String departureDateFormatted = departureDateParsed.format(outputFormatter);
				LocalDate arrivalDateParsed = LocalDate.parse(arrivalDate, inputFormatter);
				String arrivalDateParsedFormatted = arrivalDateParsed.format(outputFormatter);

				String choosenPlanForPromoCode = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_CHOOSENPLAN);

				// traveller type
				String travellerTypeForPromoCode = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_TRAVELLERTYPE);
				if (travellerTypeForPromoCode.equalsIgnoreCase(TRAVELLER_TYPE_INDIVIDUAL)) {
					travellerTypeForPromoCode = "Sendiri";
				} else if (travellerTypeForPromoCode.equalsIgnoreCase(TRAVELLER_TYPE_DUO)) {
					travellerTypeForPromoCode = "Duo";
				} else if (travellerTypeForPromoCode.equalsIgnoreCase(TRAVELLER_TYPE_FAMILY)) {
					travellerTypeForPromoCode = "Keluarga";
				}

				mainBody.put("PromoCode", promoCode.toUpperCase());
				mainBody.put("ProductCode", "IT6");
				mainBody.put("Channel", pdChannel);
				mainBody.put("ManagedBy", encryptedManagedBy);
				mainBody.put("ManagedById", pdManagedById);
				mainBody.put("leadsStartDate", departureDateFormatted);
				mainBody.put("leadsExpiredDate", arrivalDateParsedFormatted);
				mainBody.put("Plan", choosenPlanForPromoCode);
				mainBody.put("TravellerType", travellerTypeForPromoCode);

				Gson gson = new Gson();
				String payload = "";
				payload = gson.toJson(mainBody);
				_logs.info("[PURCHASE_DETAIL][PROMOCODE][PAYLOAD API PROMOCODE]: " + payload);

				JSONObject callAPIPromoCode = null;
				try {
                    callAPIPromoCode = callAPI(payload, PIMCORE_ADDRESS + CHECK_PROMOCODE_PIMCORE_ENDPOINT);

					if (callAPIPromoCode.getInt("Status") > 0) {
						promoCodeDiscount = callAPIPromoCode.getJSONObject("Data").getDouble("Discount");

					} else {
						return errorMessage(callAPIPromoCode.getString("Message")).toString();
					}
				} catch (Exception e) {
					_log.debug("[PURCHASE_DETAIL][PROMOCODE][EXCEPTION]: " + e.getMessage());
					return errorMessage("Calculate Failed").toString();
				}
				params.put("Discount", promoCodeDiscount);
			} catch (Exception e) {
				_logs.info("[PURCHASE_DETAIL][PROMOCODE][EXCEPTION]: " + e.getMessage());
				return errorMessage(e.getMessage()).toString();
			}
		}

		// Calculate premi di purchase detail
		// -------------------------------------------
		// tambahkan property SpesificPlan ke params
		// supaya hasil yang ditambahkan ke DB
		// sama dengan hasil yang keluar pada response calculate saat dipanggil pimcore
		String choosenPlan = params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_CHOOSENPLAN);
		params.put("SpesificPlan", choosenPlan);

		JSONObject calculatePremiResult = null;
		try {
			if (!Validator.isBlank(choosenPlan)) {
				calculatePremiResult = calculatePremi(params, true);
			} else {
				calculatePremiResult = calculatePremi(params, false);
			}
		} catch (Exception e) {
			return errorMessage("Calculate Premi Failed: " + e.getMessage()).toString();
		}

		JSONObject detail = calculatePremiResult.getJSONObject("Calculation");

		// Net Premi
		if (calculatePremiResult.length() > 0) {
            dataLeads.put(DATA_LEADS_KEY_POLICYCOST, detail.getDouble("PolicyCost"));
            dataLeads.put(DATA_LEADS_KEY_STAMPDUTY, detail.getDouble("Stamp"));
            dataLeads.put(DATA_LEADS_KEY_PREMIUM, detail.getDouble(GENERAL_TEXT_PREMIUM));
            dataLeads.put(DATA_LEADS_KEY_NETPREMIUM, detail.getDouble(GENERAL_TEXT_NETPREMIUM));
            dataLeads.put(DATA_LEADS_KEY_DISCOUNT, detail.getDouble("Discount"));
            dataLeads.put(DATA_LEADS_KEY_DISCOUNTAMOUNT, detail.getDouble("DiscountAmount"));
		}

		// Jika modify or reorder, promocode di leads dikosongkan
		if (modifyOrReorder) {
            String currentPromoCode = existingLeads != null ? existingLeads.getPromoCode() : "";
			if (!currentPromoCode.isEmpty() && promoCode.isEmpty()) {
                dataLeads.put("PromoCode", "");
			}
		}

		// Jika reorder, maka set currentLeadsId jadi 0
		// supaya create Leads baru.
		if(modifyOrReorder) {
			currentLeadsId = 0;
		}

        _logs.debug("---------------------------------------------------");
        _logs.debug("DATA UNTUK TABLE detailInternationalTravel:");
        _logs.debug(dataLeads);
        _logs.debug("---------------------------------------------------");

		// Save leads
		Leads saveLeads = LeadsLocalServiceUtil.updateLeads(userId, quotation ? (long) 0 : currentLeadsId, dataLeads,
				serviceContext);

		if (saveLeads == null) {
			return errorMessage("Failed to save leads").toString();
		}

		// Save detail international travel
		// ---------------------------------
		DetailInternationalTravel saveDetail = null;
		try {
			JSONObject dataDetail = JSONFactoryUtil.createJSONObject();
            dataDetail.put(DATA_DETAIL_LEADSID, saveLeads.getLeadsId());
            dataDetail.put(DATA_DETAIL_TRAVELTYPE, params.getString(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_TRAVELTYPE));
            dataDetail.put(DATA_DETAIL_DESTINATION, "Worldwide");
            dataDetail.put(DATA_DETAIL_PACKAGETYPE, params.getString("ChoosenPlan"));
            dataDetail.put("TravellerType", params.getString("TravellerType"));
            dataDetail.put("DepartureDate", customFormatDateTime(departureDate));
            dataDetail.put("ArrivalDate", customFormatDateTime(arrivalDate));
            dataDetail.put("Adult", params.getString("AdultTotal"));
            dataDetail.put("Child", params.getString("ChildTotal"));
            dataDetail.put("ListBenefitId", params.getString("AdditionalBenefits"));

			long detailId = 0;
			if (currentLeadsId > 0) {
				DetailInternationalTravel detailIT = DetailInternationalTravelLocalServiceUtil.findByLeadsId(currentLeadsId);
				if (detailIT != null) {
					detailId = detailIT.getDetailId();
				}
			}

			saveDetail = DetailInternationalTravelLocalServiceUtil.addDetail(userId, detailId, dataDetail,
					serviceContext);

			if (Validator.isNull(saveDetail)) {
				throw new NoSuchDetailInternationalTravelException("FAILED TO SAVE DETAIL INTERNATIONAL TRAVEL");
			}
		} catch (Exception e) {
			// Failed to create detail Smart Travel International
			_logs.info("[KYC][DETAIL][LEADS ID:" + saveLeads.getLeadsId() + "]: " + e.getMessage());
			return errorMessage("FAILED KYC #14 - Please try again").toString();
		}
		// END Save detail international travel
		// ---------------------------------

		// Send quotation to Pimcore
		if (quotation) {
			try {
				HashMap<String, Object> mainBody = new HashMap<String, Object>();
				mainBody.put("LiferayId", String.valueOf(saveLeads.getLeadsId()));
				mainBody.put("ManagedBy", saveLeads.getManagedBy());
				mainBody.put("ManagedById", pdManagedById);
				mainBody.put("PdCode", _productConfiguration.getProductCode());
				mainBody.put("Channel", saveLeads.getChannel());
				mainBody.put("Currency", saveLeads.getCurrency());

				double premiumDataPayloadQuotation = (saveLeads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(saveLeads.getPremium())
						: Math.round(saveLeads.getPremium() * 100.0) / 100.0;
				double netPremiumDataPayloadQuotation = (saveLeads.getCurrency().equalsIgnoreCase("idr"))
						? Math.round(saveLeads.getNetPremium())
						: Math.round(saveLeads.getNetPremium() * 100.0) / 100.0;
				mainBody.put(DATA_PAYLOAD_QUOTATION_STAMPDUTY, saveLeads.getStampDuty());
				mainBody.put(GENERAL_TEXT_PREMIUM, premiumDataPayloadQuotation);
				mainBody.put(GENERAL_TEXT_NETPREMIUM, netPremiumDataPayloadQuotation);

				mainBody.put("PromoCode", saveLeads.getPromoCode());
				mainBody.put("Discount", saveLeads.getDiscount());
				mainBody.put("DiscountAmount",
						(saveLeads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(saveLeads.getDiscountAmount())
								: Math.round(saveLeads.getDiscountAmount() * 100.0) / 100.0);

				mainBody.put("Commission", String.valueOf(saveLeads.getCommission()));
				mainBody.put(DATA_PAYLOAD_QUOTATION_BUSINESSMODEL, saveLeads.getBussinesModel());

				HashMap<String, Object> detailBody = new HashMap<String, Object>();
				detailBody.put(DATA_PAYLOAD_QUOTATION_DESTINATION, saveDetail.getDestination());
				detailBody.put("DepartureDate", _customFormatDate(saveDetail.getDepartureDate()));
				detailBody.put("ArrivalDate", _customFormatDate(saveDetail.getArrivalDate()));
				detailBody.put("TravelType", saveDetail.getTravelType());
				detailBody.put("TravellerType", saveDetail.getTravellerType());
				detailBody.put(DATA_PAYLOAD_QUOTATION_PACKAGETYPE, saveDetail.getPackageType());
				detailBody.put("TotalAdult", String.valueOf(saveDetail.getAdult()));
				detailBody.put("TotalChildren", String.valueOf(saveDetail.getChild()));

				mainBody.put("Detail", detailBody);

				String listBenefit = saveDetail.getListBenefitId();
				List<String> externalCodeArray = new ArrayList<String>();
				if (listBenefit == null || listBenefit.isEmpty() || listBenefit.equalsIgnoreCase("[]")) {

				} else {
					String[] benefitArray = listBenefit.replace("[", "").replace("]", "").split(",");
					long[] longArray = Arrays.stream(benefitArray).map(String::trim) // Trim spaces around elements
							.filter(s -> !s.isEmpty()) // Ensure no empty elements
							.mapToLong(Long::parseLong) // Convert to long
							.toArray();

					for (long value : longArray) {
						StiBenefit benefit = StiBenefitLocalServiceUtil.getStiBenefit(value);
						externalCodeArray.add(benefit.getExternalCode());
					}
				}

				mainBody.put(DATA_PAYLOAD_QUOTATION_ADDITIONALBENEFIT, externalCodeArray);

				HashMap<String, Object> policyHolderBody = new HashMap<String, Object>();
				policyHolderBody.put("Name", saveLeads.getName());
				policyHolderBody.put(DATA_PAYLOAD_QUOTATION_PH_EMAIL, saveLeads.getEmail());

				mainBody.put("PolicyHolder", policyHolderBody);

				mainBody.put("QuotationType", "simple");

				Gson gson = new Gson();
				String payload = "";
				payload = gson.toJson(mainBody);

				_logs.info("[PURCHASE_DETAIL][QUOTATION][PAYLOAD FOR PIMCORE]: " + payload);

				JSONObject callPimcoreAPI = callAPI(payload, PIMCORE_ADDRESS + CREATE_QUOTE_PIMCORE);

				if (callPimcoreAPI.getInt("Status") == 0) {
					return errorMessage(callPimcoreAPI.getString("Message")).toString();
				} else {

					// Set token limiter to invalid
					AgentTokenLimiterLocalServiceUtil.setToInvalid(agentTokenLimiterId);

                    responseData.put("Status", 1);
                    responseData.put("Data", PIMCORE_HOST + "/dashboard/leads/online");
                    responseData.put("Message", "Kirim Penawaran Berhasil");
				}
			} catch (Exception e) {
                return errorMessage(e.getMessage()).toString();
			}
		} else {
			if (saveLeads.getLeadsId() > 0) {
				JSONObject dataContentNonQuotation = JSONFactoryUtil.createJSONObject();
                responseData.put("Status", 1);
                dataContentNonQuotation.put("Token", saveLeads.getToken());
                responseData.put("Data", dataContentNonQuotation);
			} else {
				return errorMessage("Failed KYC #12").toString();
			}
		}
        return responseData.toString();
	}

	// Update data leads and customers
	/**
	 * ULAC01: get leads by token null / leads not found ULAC02: update leads gagal
	 * ULAC03: data insured dari param payload tidak ada ULAC04: create/update
	 * customer gagal
	 */
	private void updateLeadsAndCustomers(JSONObject paramSanitized, String leadsToken,
			HttpServletRequest httpServletRequest) throws Exception {

		// Find leads by token
		Leads leads = null;
		String leadsType = "kyc";
		leads = LeadsLocalServiceUtil.findByToken(leadsToken);

		if (leads == null) {
			throw new Exception("Data cannot be processed [ULAC01]");
		}

		// Update leads
		ServiceContext serviceContext = null;
		long userId = 0L;

		serviceContext = ServiceContextFactory.getInstance(SmartTravel2Application.class.getName(), httpServletRequest);
		userId = serviceContext.getGuestOrUserId();

		JSONObject policyholderData = paramSanitized.getJSONObject("policyholder");
		JSONArray insuredDataList = paramSanitized.getJSONArray("insured");
		boolean insuredIsPolis = paramSanitized.getBoolean("insuredIsPolis");

//		POLICY HOLDER
		try {
			long fileEntryId = 0;
			String filePath = "";

			String base64Image = policyholderData.getString("_fotoktp");

			if (Validator.isNotNull(base64Image) && !Validator.isBlank(base64Image)) {
				List<String> fileData = manageFile(base64Image, "img_policyholder", "Image Policy Holder",
						httpServletRequest);
				String fileEntryIdStr = fileData.get(0);
				filePath = fileData.get(1);
				fileEntryId = Long.parseLong(fileEntryIdStr);
			}

			JSONObject _dataPolicyHolder = JSONFactoryUtil.createJSONObject();
			_dataPolicyHolder.put(DATA_POLICY_HOLDER_KEY_LEADSTYPE, leadsType);

			String dobRaw = policyholderData.getString("_dob").replaceAll("/", "-");
			String formattedDob = parseDate(dobRaw);

			_dataPolicyHolder.put("Name", policyholderData.getString("_name"));
			_dataPolicyHolder.put("Email", policyholderData.getString(PARAM_POLICY_HOLDER_OR_INSURED_EMAIL).trim());
			_dataPolicyHolder.put("MobilePhone", policyholderData.getString("_hp"));
			_dataPolicyHolder.put("Gender", policyholderData.getString("_gender"));
			_dataPolicyHolder.put("Dob", formattedDob);
			_dataPolicyHolder.put(KEY_BIRTH_PLACE, policyholderData.getString(KEY_DATANASABAH_PDOB));

			String nationality = policyholderData.getString("_negara");
			String ktpkitas = policyholderData.getString("_ktpkitas");
			_dataPolicyHolder.put("Nationality", nationality);
			if (nationality.equalsIgnoreCase("indonesia")) {
				_dataPolicyHolder.put("IdNumber", ktpkitas);
			} else {
				_dataPolicyHolder.put("KitasNumber", ktpkitas);
			}

			_dataPolicyHolder.put("PassportNumber", policyholderData.getString("_ktppaspor"));
			_dataPolicyHolder.put("Address", policyholderData.getString("_alamat").replace("\n", " "));
			_dataPolicyHolder.put("Zip", policyholderData.getString("_kodepos"));

			_dataPolicyHolder.put("isPEP", policyholderData.getString("_ispep"));
			_dataPolicyHolder.put("CountryCode", policyholderData.getString("_kodenegara"));

			_dataPolicyHolder.put("Job", policyholderData.getString("_job"));
			_dataPolicyHolder.put("JobOther", policyholderData.getString("_otherjob"));

			_dataPolicyHolder.put("Age", policyholderData.getInt("_age"));
			_dataPolicyHolder.put("MaritalStatus", policyholderData.getString("_statuskawin"));
			_dataPolicyHolder.put("Phone", policyholderData.getString("_telepon"));

			if (Validator.isNotNull(base64Image) && !Validator.isBlank(base64Image)) {
				_dataPolicyHolder.put("IdPhotoFileEntry", fileEntryId);
				_dataPolicyHolder.put("PhotoFileUrl", filePath);
			}
			LeadsLocalServiceUtil.updateLeads(userId, leads.getLeadsId(), _dataPolicyHolder, serviceContext);
		} catch (Exception e) {
			_logs.error("GAGAL CREATE/UPDATE LEADS", e);
			throw new Exception("Data cannot be processed [ULAC02]");
		}

//		INSURED
		if (insuredDataList == null) {
			throw new Exception("Data cannot be processed [ULAC03]");
		}

		try {
			JSONArray dataPhotoExisting = JSONFactoryUtil.createJSONArray();

			List<Customer> insuredListCus = customerLocalService.findByLeadsId(leads.getLeadsId());

			for (Customer item : insuredListCus) {
				JSONObject dataPhotoExistingDto = JSONFactoryUtil.createJSONObject();

				dataPhotoExistingDto.put("PasporNumber", item.getPassportNumber());
				dataPhotoExistingDto.put("FileEntryId", item.getIdPhotoFileEntryId());
				dataPhotoExistingDto.put("PhotoUrl", item.getPhotoFileUrl());

				dataPhotoExisting.put(dataPhotoExistingDto);
			}

			// hapus jika sebelumnya ada data customer ini
			CustomerLocalServiceUtil.removeCustomerByLeadsIdAndProductCode(leads.getLeadsId(), "STI");

			for (int i = 0; i < insuredDataList.length(); i++) {
				JSONObject insuredData = insuredDataList.getJSONObject(i);

				// image
				String customerBase64Image = "";
				if (insuredData.getString("_fotoktp").length() > 0) {
					customerBase64Image = insuredData.getString("_fotoktp");
				}

				String fileEntryIdStr = "";
				long fileEntryId = 0;
				String filePath = "";

				if (dataPhotoExisting.length() > 0) {
					for (int j = 0; j < dataPhotoExisting.length(); j++) {
						if (insuredData.getString("_ktppaspor")
								.equalsIgnoreCase(dataPhotoExisting.getJSONObject(j).getString("PasporNumber"))) {
							fileEntryId = dataPhotoExisting.getJSONObject(j).getLong("FileEntryId");
							filePath = dataPhotoExisting.getJSONObject(j).getString("PhotoUrl");
						}
					}
				}

				if (Validator.isNotNull(customerBase64Image) && !Validator.isBlank(customerBase64Image)) {
					List<String> fileData = manageFile(customerBase64Image, "img_insured", "Image Insured",
							httpServletRequest);

					fileEntryIdStr = fileData.get(0);
					filePath = fileData.get(1);
					fileEntryId = Long.parseLong(fileEntryIdStr);
				}

				String insuredDobRaw = insuredData.getString("_dob").replaceAll("/", "-");
				String insuredFormattedDob = parseDate(insuredDobRaw);

				JSONObject customerData = JSONFactoryUtil.createJSONObject();
				customerData.put(DATA_CUSTOMER_KEY_LEADSID, leads.getLeadsId());
				customerData.put("Name", insuredData.getString("_name"));
				customerData.put("Email", insuredData.getString(PARAM_POLICY_HOLDER_OR_INSURED_EMAIL).trim());
				customerData.put("MobilePhone", insuredData.getString("_hp"));
				customerData.put("Gender", insuredData.getString("_gender"));
				customerData.put("Dob", insuredFormattedDob);
				customerData.put(KEY_BIRTH_PLACE, insuredData.getString(KEY_DATANASABAH_PDOB));

				String nationality = insuredData.getString("_negara");
				String ktpkitas = insuredData.getString("_ktpkitas");
				customerData.put("Nationality", nationality);
				if (nationality.equalsIgnoreCase("indonesia")) {
					customerData.put("IdNumber", ktpkitas);
				} else {
					customerData.put("KitasNumber", ktpkitas);
				}

				customerData.put("PassportNumber", insuredData.getString("_ktppaspor"));
				customerData.put("Address", insuredData.getString("_alamat").replace("\n", " "));
				customerData.put("Zip", insuredData.getString("_kodepos"));
				customerData.put("Relationship", insuredData.getString("_relationship"));
				customerData.put("isPEP", insuredData.getString("_ispep"));
				customerData.put("CountryCode", insuredData.getString("_kodenegara"));
				customerData.put("Job", insuredData.getString("_job"));
				customerData.put("JobOther", insuredData.getString("_otherjob"));
				customerData.put("Age", insuredData.getInt("_age"));
				customerData.put("MaritalStatus", insuredData.getString("_statuskawin"));
				customerData.put("Phone", insuredData.getString("_telepon"));
				customerData.put("IdPhotoFileEntry", fileEntryId);
				customerData.put("PhotoFileUrl", filePath);
				customerData.put("ProductCode", "STI");

				CustomerLocalServiceUtil.addCustomer(userId, 0, customerData, serviceContext);
			}

		} catch (Exception e) {
			_logs.error("GAGAL CREATE/UPDATE CUSTOMER", e);
			throw new Exception("Data cannot be processed [ULAC04]");
		}
	}

	// Process data to Pimcore and redirect to Pimcore payment page if success
	/**
	 * 
	 * PR01:token tidak ada saat masuk ke endpoint /process PR02:ada error saat
	 * sanitasi XSS PR03:detail international travel null PR04: error saat membuat
	 * list adult dan list children untuk payload ke pimcore PR05: error saat
	 * membuat payload untuk dikirim ke pimcore PR06: error saat proses request
	 * kirim data ke pimcore. method hitAPI nge-throw sesuatu. ini artinya ada error
	 * di dalam hitAPI (bukan dari pimcore) PR07: status http requestnya 200 tapi
	 * body response dari pimcore kosong PR08: status http request ke pimcore bukan
	 * 200, bisa jadi 400 atau 500 error internal server PR09: return dari method
	 * hitAPI kosong sama sekali tidak ada isinya/null
	 */
	@POST
	@Path("/process")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String process(String request, @Context HttpServletRequest httpServletRequest) throws Exception {

		String host = PortalUtil.getPortalURL(httpServletRequest);
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();

		String token = params.getString(PARAM_PROCESS_ADDITIONAL_TOKEN);
		if (token.isEmpty()) {
			return errorMessage("Data cannot be processed [PR01]").toString();
		}

		String type = params.getString(PARAM_PROCESS_ADDITIONAL_TYPE);
		String quouteId = params.getString(PARAM_PROCESS_ADDITIONAL_QUOTEID);

//		IF REQUEST TYPE IS NOT PAYMENT
		if (!type.equalsIgnoreCase(PROCESS_TYPE_PAYMENT)) {
			String sanitizedReqStrToKyc = "";
			try {
				JSONObject joPayloadKyc = JSONFactoryUtil.createJSONObject(params.getString(PARAM_PROCESS_PAYLOADKYC));
				Map<String, Object> payloadMap = convertJsonToMap(joPayloadKyc.toString());

				Map<String, Object> sanitizedPayload = XSSValidator.sanitizePayload(payloadMap);
				ObjectMapper objectMapper = new ObjectMapper();
				sanitizedReqStrToKyc = objectMapper.writeValueAsString(sanitizedPayload);
			} catch (Exception e) {
				_logs.error(e.getMessage());
				return errorMessage("Data cannot be processed [PR02]").toString();
			}

			JSONObject paramSanitized = JSONFactoryUtil.createJSONObject(sanitizedReqStrToKyc);

			try {
				updateLeadsAndCustomers(paramSanitized, token, httpServletRequest);
			} catch (Exception e) {
				_logs.error(e.getMessage());
				return errorMessage(e.getMessage()).toString();
			}
		}

		Leads leads = LeadsLocalServiceUtil.findByToken(token);
		DetailInternationalTravel detailInternationalTravel = DetailInternationalTravelLocalServiceUtil
				.findByLeadsId(leads.getLeadsId());

		if (detailInternationalTravel == null) {
			return errorMessage("Data cannot be processed [PR03]").toString();
		}

		// LOAD DATA ADULT AND CHILDREN FROM CUSTOMER FOR PAYLOAD PIMCORE
		List<Customer> insuredListCus = customerLocalService.findByLeadsId(leads.getLeadsId());
		List<Customer> listAdult = new ArrayList<>();
		List<Customer> listChildren = new ArrayList<>();

		// ADDITIONAL BENEFIT
		List<Object> additionalBenefit = new ArrayList<Object>();

		try {
			int totalAdults = detailInternationalTravel.getAdult();
			int totalChildren = detailInternationalTravel.getChild();

			String travellerType = detailInternationalTravel.getTravellerType();
			if ("Duo".equalsIgnoreCase(travellerType)) {
				Customer utama = insuredListCus.stream()
						.filter(cus -> "Pasangan".equalsIgnoreCase(cus.getRelationship())
								|| "Tertanggung Utama".equalsIgnoreCase(cus.getRelationship()))
						.collect(Collectors.toList()).get(0);

				Customer kerabatTeman = insuredListCus.stream()
						.filter(cus -> "Kerabat".equalsIgnoreCase(cus.getRelationship())
								|| "Teman".equalsIgnoreCase(cus.getRelationship()))
						.collect(Collectors.toList()).get(0);

				if (totalAdults == 2) {
					if (utama != null)
						listAdult.add(utama);
					if (kerabatTeman != null)
						listAdult.add(kerabatTeman);
				} else if (totalChildren == 1 && totalAdults == 1) {
					if (utama != null)
						listAdult.add(utama); // Data pertama menjadi dewasa
					if (kerabatTeman != null)
						listChildren.add(kerabatTeman); // Data kedua menjadi anak
				}
			} else {
				listChildren = insuredListCus.stream()
						.filter(cus -> "Anak".equalsIgnoreCase(cus.getRelationship())
								|| "Anak / Pelajar".equalsIgnoreCase(cus.getRelationship()))
						.collect(Collectors.toList());

				listAdult = insuredListCus.stream()
						.filter(cus -> "Pasangan".equalsIgnoreCase(cus.getRelationship())
								|| "Tertanggung Utama".equalsIgnoreCase(cus.getRelationship()))
						.collect(Collectors.toList());
			}
		} catch (Exception e) {
			_logs.error(e.getMessage());
			return errorMessage("Data cannot be processed [PR04]").toString();
		}

		// PAYLOAD FOR PIMCORE
		Gson gson = new Gson();
		String payloadForPimcore = "";

		try {
			HashMap<String, Object> mainBodyPayload = new LinkedHashMap<>();
			mainBodyPayload.put("LiferayId", String.valueOf(leads.getLeadsId()));
			mainBodyPayload.put("QuoteId", quouteId);
			mainBodyPayload.put("ManagedBy", leads.getManagedBy());

			if (!leads.getManagedBy().isEmpty()) {
				mainBodyPayload.put("ManagedById", params.get("mbid"));
			}

			mainBodyPayload.put("PdCode", leads.getProductCode());
			mainBodyPayload.put("Channel", leads.getChannel());
			mainBodyPayload.put("Currency", leads.getCurrency().toUpperCase());
			mainBodyPayload.put(DATA_PROCESS_PAYLOAD_KEY_STAMPDUTY, String.valueOf(leads.getStampDuty()));
			mainBodyPayload.put("PromoCode", leads.getPromoCode());
			mainBodyPayload.put("Discount", leads.getDiscount());
			mainBodyPayload.put("DiscountAmount",
					(leads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(leads.getDiscountAmount())
							: Math.round(leads.getDiscountAmount() * 100.0) / 100.0);

			double currentPremium = (leads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(leads.getPremium())
					: Math.round(leads.getPremium() * 100.0) / 100.0;
			mainBodyPayload.put(GENERAL_TEXT_PREMIUM, String.valueOf(currentPremium));

			double netPremium = (leads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(leads.getNetPremium())
					: Math.round(leads.getNetPremium() * 100.0) / 100.0;
			mainBodyPayload.put(GENERAL_TEXT_NETPREMIUM, String.valueOf(netPremium));

			mainBodyPayload.put("Commission", String.valueOf(leads.getCommission()));
			mainBodyPayload.put(DATA_PROCESS_PAYLOAD_KEY_BUSINESS_MODEL, leads.getBussinesModel());
			mainBodyPayload.put("CommercialOffers", String.valueOf(leads.getCommercialOffers()));

			mainBodyPayload.put("UserCustom", "");
			mainBodyPayload.put("UtmCampaign", "");
			mainBodyPayload.put("UtmMedium", "");
			String utmSource = params.getString("utmSource");
			mainBodyPayload.put("UtmSource", !utmSource.isEmpty() ? utmSource.toLowerCase() : utmSource);
			mainBodyPayload.put("UtmTerm", "");
			mainBodyPayload.put("ClickId", "");

			// DETAIL
			HashMap<String, Object> detailPayload = new LinkedHashMap<>();

			detailPayload.put(DATA_PROCESS_PAYLOAD_KEY_DETAIL_DESTINATION, detailInternationalTravel.getDestination());
			Date departuredate = detailInternationalTravel.getDepartureDate();
			String formattedDeparturedate = outputFormat2.format(departuredate);
			detailPayload.put("DepartureDate", formattedDeparturedate);

			Date arrivalDate = detailInternationalTravel.getArrivalDate();
			String formattedArrivalDate = outputFormat2.format(arrivalDate);
			detailPayload.put("ArrivalDate", formattedArrivalDate);

			detailPayload.put("TravelType", detailInternationalTravel.getTravelType());
			detailPayload.put(DATA_PROCESS_PAYLOAD_KEY_DETAIL_PACKAGETYPE, detailInternationalTravel.getPackageType());
			detailPayload.put("TravellerType", detailInternationalTravel.getTravellerType());
			detailPayload.put("TotalAdult", String.valueOf(detailInternationalTravel.getAdult()));
			detailPayload.put("TotalChildren", String.valueOf(detailInternationalTravel.getChild()));

			if (params.has(PARAM_PROCESS_ADDITIONAL_BENEFIT) && params.getJSONArray(PARAM_PROCESS_ADDITIONAL_BENEFIT) != null) {
				JSONArray additionalBenefitArray = params.getJSONArray(PARAM_PROCESS_ADDITIONAL_BENEFIT);
				if (additionalBenefitArray.length() > 0) {
					for (int i = 0; i < additionalBenefitArray.length(); i++) {
						int benefitId = additionalBenefitArray.getInt(i);
						StiBenefit benefit = StiBenefitLocalServiceUtil.fetchStiBenefit(benefitId);

						if (benefit != null) {
							additionalBenefit.add(String.valueOf(benefit.getExternalCode()));
						}
					}
				} else {
					_logs.info("AdditionalBenefit ada tetapi kosong.");
				}
			}

			// POLICY HOLDER
			HashMap<String, Object> policyHolderPayload = new LinkedHashMap<>();
			policyHolderPayload.put(DATA_PROCESS_PAYLOAD_KEY_ISPEP, leads.getIsPep());
			policyHolderPayload.put("Name", leads.getName());
			policyHolderPayload.put("Gender", leads.getGender());

			Date dobPolicyHolder = leads.getDob();
			String formatteddobPolicyHolder = outputFormat2.format(dobPolicyHolder);
			policyHolderPayload.put("Dob", formatteddobPolicyHolder);

			policyHolderPayload.put("Age", String.valueOf(leads.getAge()));
			policyHolderPayload.put("Email", leads.getEmail().trim());
			policyHolderPayload.put("IdNumber", leads.getIdNumber());
			policyHolderPayload.put("KitasNumber", leads.getKitasNumber());
			policyHolderPayload.put("PassportNumber", leads.getPassportNumber());
			policyHolderPayload.put("Address", leads.getAddress());
			policyHolderPayload.put("Zip", leads.getZip());
			policyHolderPayload.put("MobilePhone", leads.getMobilePhone());
			policyHolderPayload.put(DATA_PROCESS_PAYLOAD_KEY_POLICYHOLDER_PHONENUMBER, leads.getPhone());
			policyHolderPayload.put("Nationality",
					leads.getNationality().equalsIgnoreCase(PROCESS_INDONESIA) ? "WNI" : "WNA");
			policyHolderPayload.put(DATA_PROCESS_PAYLOAD_KEY_POLICYHOLDER_NATIONALITYCOUNTRY, leads.getNationality());
			policyHolderPayload.put("CountryCode", leads.getCountryCode());
			policyHolderPayload.put("MotherMaidenName", "");
			policyHolderPayload.put("MaritalStatus", leads.getMaritalStatus());
			policyHolderPayload.put("Job", leads.getJob());
			policyHolderPayload.put("JobOther", leads.getJobOther());
			policyHolderPayload.put(KEY_BIRTH_PLACE, leads.getBirthPlace());

			if (!leads.getPhotoFileUrl().isEmpty()) {
				String fullUrlPhoto = host + leads.getPhotoFileUrl();
				policyHolderPayload.put(DATA_PROCESS_PAYLOAD_KEY_POLICYHOLDER_IDPHOTOURL, fullUrlPhoto);
			} else {
				policyHolderPayload.put(DATA_PROCESS_PAYLOAD_KEY_POLICYHOLDER_IDPHOTOURL, "");
			}

			// ADULT
			List<Object> adultDataContainer = new ArrayList<Object>();
			for (Customer adult : listAdult) {
				if (adult == null) {
					continue;
				}

				HashMap<String, Object> adultObj = new LinkedHashMap<>();
				adultObj.put(DATA_PROCESS_PAYLOAD_KEY_ADULTS_ISPEP, adult.getIsPep());
				adultObj.put("Name", adult.getName());
				adultObj.put("Gender", adult.getGender());

				Date dobAdult = adult.getDob();
				String formatteddobAdult = outputFormat2.format(dobAdult);
				adultObj.put("Dob", formatteddobAdult);

				adultObj.put("Age", String.valueOf(adult.getAge()));
				adultObj.put("Email", adult.getEmail().trim());

				if (adult.getNationality().equalsIgnoreCase(PROCESS_INDONESIA)) {
					adultObj.put("IdNumber", adult.getIdNumber());
					adultObj.put("KitasNumber", "");
				} else {
					adultObj.put("IdNumber", "");
					adultObj.put("KitasNumber", adult.getKitasNumber());
				}

				adultObj.put("PassportNumber", adult.getPassportNumber());
				adultObj.put("Address", adult.getAddress());
				adultObj.put("Zip", adult.getZip());
				adultObj.put("MobilePhone", adult.getMobilePhone());
				adultObj.put(DATA_PROCESS_PAYLOAD_KEY_ADULTS_PHONENUMBER, adult.getPhone());
				adultObj.put("Nationality", adult.getNationality().equalsIgnoreCase(PROCESS_INDONESIA) ? "WNI" : "WNA");
				adultObj.put(DATA_PROCESS_PAYLOAD_KEY_ADULTS_NATIONALITYCOUNTRY, adult.getNationality());
				adultObj.put("CountryCode", adult.getCountryCode());
				adultObj.put("MaritalStatus", adult.getMaritalStatus());
				adultObj.put("Relationship", adult.getRelationship());
				adultObj.put("Job", adult.getJob());
				adultObj.put("JobOther", adult.getJobOther());
				adultObj.put(GENERAL_TEXT_PREMIUM, "");
				adultObj.put(KEY_BIRTH_PLACE, adult.getBirthPlace());

				if (!adult.getPhotoFileUrl().isEmpty()) {
					String fullUrlPhotoAdult = host + adult.getPhotoFileUrl();
					adultObj.put(DATA_PROCESS_PAYLOAD_KEY_ADULTS_IDPHOTOURL, fullUrlPhotoAdult);
				} else {
					adultObj.put(DATA_PROCESS_PAYLOAD_KEY_ADULTS_IDPHOTOURL, "");
				}
				adultDataContainer.add(adultObj);
			}

			// CHILDREN
			List<Object> childrenDataContainer = new ArrayList<Object>();
			for (Customer child : listChildren) {
				if (child == null) {
					continue;
				}

				HashMap<String, Object> childrenObj = new LinkedHashMap<>();
				childrenObj.put(DATA_PROCESS_PAYLOAD_KEY_CHILDREN_ISPEP, child.getIsPep());
				childrenObj.put("Name", child.getName());
				childrenObj.put("Gender", child.getGender());

				Date dobChild = child.getDob();
				String formatteddobChild = outputFormat2.format(dobChild);
				childrenObj.put("Dob", formatteddobChild);

				childrenObj.put("Age", String.valueOf(child.getAge()));
				childrenObj.put("Email", child.getEmail().trim());

				if (child.getNationality().equalsIgnoreCase(PROCESS_INDONESIA)) {
					childrenObj.put("IdNumber", child.getIdNumber());
					childrenObj.put("KitasNumber", "");
				} else {
					childrenObj.put("IdNumber", "");
					childrenObj.put("KitasNumber", child.getKitasNumber());
				}

				childrenObj.put("PassportNumber", child.getPassportNumber());
				childrenObj.put("Address", child.getAddress());
				childrenObj.put("Zip", child.getZip());
				childrenObj.put("MobilePhone", child.getMobilePhone());
				childrenObj.put(DATA_PROCESS_PAYLOAD_KEY_CHILDREN_PHONENUMBER, child.getPhone());
				childrenObj.put("Nationality", child.getNationality().equalsIgnoreCase(PROCESS_INDONESIA) ? "WNI" : "WNA");
				childrenObj.put(DATA_PROCESS_PAYLOAD_KEY_CHILDREN_NATIONALITYCOUNTRY, child.getNationality());
				childrenObj.put("CountryCode", child.getCountryCode());
				childrenObj.put("MaritalStatus", child.getMaritalStatus());
				childrenObj.put("Relationship", child.getRelationship());
				childrenObj.put("Job", child.getJob());
				childrenObj.put("JobOther", child.getJobOther());
				childrenObj.put(GENERAL_TEXT_PREMIUM, "");
				childrenObj.put(KEY_BIRTH_PLACE, child.getBirthPlace());

				if (!child.getPhotoFileUrl().isEmpty()) {
					String fullUrlPhotoChild = host + child.getPhotoFileUrl();
					childrenObj.put(DATA_PROCESS_PAYLOAD_KEY_CHILDREN_IDPHOTOURL, fullUrlPhotoChild);
				} else {
					childrenObj.put(DATA_PROCESS_PAYLOAD_KEY_CHILDREN_IDPHOTOURL, "");
				}
				childrenDataContainer.add(childrenObj);
			}

			// PAYMENT
			HashMap<String, Object> paymentPayload = new LinkedHashMap<>();
			paymentPayload.put("Currency", leads.getCurrency().toUpperCase()); // IDR

			// sub total basic premi + additional
			// premium yang ada disini isinya selalu IDR.
			// kalau dia gross, berarti pakai dari NetPremium di mainBodyPayload
			// kalau dia nett, berarti pakai perhitungan yang dikurang komisi (harus IDR)
			double premiumForPayment = (leads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(leads.getPremium())
					: Math.round(leads.getPremium() * 100.0) / 100.0;
			paymentPayload.put(GENERAL_TEXT_PREMIUM, String.valueOf(premiumForPayment));

			mainBodyPayload.put("Detail", detailPayload);
			mainBodyPayload.put(DATA_PROCESS_PAYLOAD_KEY_ADDITIONALBENEFIT, additionalBenefit);
			mainBodyPayload.put("PolicyHolder", policyHolderPayload);
			mainBodyPayload.put("Adults", adultDataContainer);
			mainBodyPayload.put("Children", childrenDataContainer);
			mainBodyPayload.put("Payment", paymentPayload);

			// PENAWARAN FULL
			if (type.equalsIgnoreCase(PROCESS_TYPE_PENAWARAN)) {
				mainBodyPayload.put("QuotationType", "full");
			}

			payloadForPimcore = gson.toJson(mainBodyPayload);

            _logs.info("PAYLOAD YANG DIKIRIM KE PIMCORE:");
            _logs.info(payloadForPimcore);
            _logs.info("DEBUG UTM SOURCE:");
            _logs.info(utmSource);
			
		} catch (Exception e) {
			_logs.error(e.getMessage());
			return errorMessage("Data cannot be processed [PR05]").toString();
		}

		// SEND TO PIMCORE
		JSONObject responsePimcore = JSONFactoryUtil.createJSONObject();
		try {
			String pimcoreAPIURL = "";
			if (type.equalsIgnoreCase(PROCESS_TYPE_PENAWARAN)) {
				pimcoreAPIURL = PIMCORE_ADDRESS + CREATE_QUOTE_PIMCORE;
			} else if (type.equalsIgnoreCase(PROCESS_TYPE_PAYMENT)) {
				pimcoreAPIURL = PIMCORE_ADDRESS + KYC_PAYMENT_PIMCORE;
			} else {
				pimcoreAPIURL = PIMCORE_ADDRESS + LEADS_CHECK_VALIDATE_PIMCORE;
			}
			responsePimcore = hitAPI(pimcoreAPIURL, payloadForPimcore);

		} catch (Exception e) {
			_logs.error(e.getMessage());
			return errorMessage("Data cannot be processed [PR06]").toString();
		}

		String redirectTo = "";

        if (responsePimcore.getInt("httpStatusCode") != 200) {
			return errorMessage("Data cannot be processed [PR08] - Please try again.").toString();
		}

		JSONObject responsePimcoreData = responsePimcore.getJSONObject("data"); // Body response dari pimcore
		if (responsePimcoreData == null) {
			return errorMessage("Data cannot be processed [PR07]").toString();
		}
		int responsePimcoreDataStatus = responsePimcoreData.getInt("Status");
		if (responsePimcoreDataStatus == 1) {
			responseData.put("Message", "Success");
			if (type.equalsIgnoreCase(PROCESS_TYPE_PENAWARAN)) {
				String dashboardPimcore = "/dashboard/leads/online";
				redirectTo = PIMCORE_HOST + dashboardPimcore;
				responseData.put(PROCESS_KEY_PROCESSTYPE, "quotation");
				responseData.put(PROCESS_KEY_REDIRECT_TARGET, redirectTo);
			} else if (type.equalsIgnoreCase(PROCESS_TYPE_PAYMENT)) {
				JSONObject dataFromPimcore = responsePimcoreData.getJSONObject("Data");
				String tokenForPayment = dataFromPimcore.getString("Token");
				redirectTo = PIMCORE_HOST + "/payment/process" + "/" + tokenForPayment;
				responseData.put(PROCESS_KEY_PROCESSTYPE, PROCESS_TYPE_PAYMENT);
				responseData.put(PROCESS_KEY_REDIRECT_TARGET, redirectTo);
			} else {
				responseData.put(PROCESS_KEY_PROCESSTYPE, "normal");
				responseData.put(PROCESS_KEY_REDIRECT_TARGET, "");
				responseData.put("additionalBenefitsCode", additionalBenefit);
			}
		} else {
			responseData.put("Message", responsePimcoreData.getString("Message"));
			String redirectVal = responsePimcoreData.getString("Redirect");
			int isBlocked = responsePimcoreData.getInt("Blocked");
			if (!redirectVal.isEmpty()) {
				if (isBlocked != 0) {
					responseData.put("Blocked", true);
				} else {
					responseData.put("Pep", true);
				}
			}
		}
		responseData.put("Status", responsePimcoreDataStatus);
		return responseData.toString();
	}

	// GET COMPARE PLAN
	@GET
	@Path("/compareplan")
	@Produces("application/json")
	public String comparePlan(String request, @Context HttpServletRequest httpServletRequest)
			throws JSONException, IOException {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		List<HashMap<String, Object>> comparePlanList = new ArrayList<>();
		List<BenefitType> _benefitTypes = BenefitTypeLocalServiceUtil.getActiveBenefitType();

		if (_benefitTypes != null && _benefitTypes.size() > 0) {

			for (BenefitType _benefitType : _benefitTypes) {
				HashMap<String, Object> _item = new HashMap<String, Object>();
				_item.put("sort", _benefitType.getSort());
				_item.put("nameId", _benefitType.getNameId());
				_item.put("nameEn", _benefitType.getNameEn());

				List<HashMap<String, Object>> currentBenefitList = new ArrayList<>();
				List<StiBenefit> currentBenefit = StiBenefitLocalServiceUtil
						.getBenefitByTypeId(_benefitType.getBenefitTypeId());
				if (currentBenefit != null && currentBenefit.size() > 0) {
					for (StiBenefit _benefit : currentBenefit) {
						HashMap<String, Object> _itemBenefit = new HashMap<String, Object>();
						_itemBenefit.put("benefitName", _benefit.getNameId());
						_itemBenefit.put("benefitDescription", _benefit.getBenefitDescription());

						HashMap<String, Object> idrContainer = new HashMap<>();
						HashMap<String, Object> usdContainer = new HashMap<>();

						List<SmartTravelIntPlan> plans = SmartTravelIntPlanLocalServiceUtil.getActivePlan();
						if (plans != null && plans.size() > 0) {
							for (SmartTravelIntPlan plan : plans) {

								StiBenefitValueMapping benefitValueMappingObj = StiBenefitValueMappingLocalServiceUtil
										.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
												_benefitType.getBenefitTypeId(), _benefit.getBenefitId(),
												plan.getSmartTravelIntPlanId());

								if (benefitValueMappingObj != null) {
									idrContainer.put(plan.getNameId(), benefitValueMappingObj.getBenefitValue());
									usdContainer.put(plan.getNameId(), benefitValueMappingObj.getBenefitValueUSD());
								}
							}

						}

						_itemBenefit.put("idr", idrContainer);
						_itemBenefit.put("usd", usdContainer);

						currentBenefitList.add(_itemBenefit);
					}
				}
				_item.put("benefit", currentBenefitList);

				comparePlanList.add(_item);
			}

		}

		if (comparePlanList.size() > 0) {
			response.put("Status", 1);
			response.put("Data", JSONFactoryUtil.createJSONArray(comparePlanList));
		} else {
			response.put("Status", 0);
			response.put("Data", "");
		}

		return response.toString();
	}

	// GET ADDITIONAL BENEFIT LIST
	@POST
	@Path("/additionalbenefit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String additionalBenefit(String request, @Context HttpServletRequest httpServletRequest)
			throws JSONException, IOException {
		JSONObject response = JSONFactoryUtil.createJSONObject();

		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		String choosenPlan = params.getString("Plan");

		try {

			List<BenefitType> benefitTypes = BenefitTypeLocalServiceUtil.getActiveBenefitType();

			List<Object> benefitTypesContainer = new ArrayList<>();

			if (!Validator.isNull(benefitTypes)) {
				for (BenefitType benefitType : benefitTypes) {

					if (benefitType.getNameId().equals("Jaminan Utama")) {
						continue;
					}

					HashMap<String, Object> benefitTypeItem = new HashMap<String, Object>();
					benefitTypeItem.put("BenefitType", benefitType.getNameId());

					List<Object> benefitItemList = new ArrayList<>();

					List<StiBenefitValueMapping> benefitValueMappings = StiBenefitValueMappingLocalServiceUtil
							.getAllBenefitValueMappingByBenefitType(benefitType.getBenefitTypeId());

					for (StiBenefitValueMapping benefitValueMapping : benefitValueMappings) {

						HashMap<String, Object> benefitItemListContent = new HashMap<String, Object>();

						SmartTravelIntPlan currentPlan = SmartTravelIntPlanLocalServiceUtil
								.fetchSmartTravelIntPlan(benefitValueMapping.getPlanId());
						if (!currentPlan.getNameId().equals(choosenPlan)) {
							continue;
						}
						StiBenefit currentBenefit = StiBenefitLocalServiceUtil
								.fetchStiBenefit(benefitValueMapping.getBenefitId());

						if (currentBenefit.getActive() < 1) {
							continue;
						}

						benefitItemListContent.put("Sort", currentBenefit.getSort());
						benefitItemListContent.put("Name", currentBenefit.getNameId());
						benefitItemListContent.put("LimitInfo", benefitValueMapping.getBenefitValue());
						benefitItemListContent.put("LimitInfoUSD", benefitValueMapping.getBenefitValueUSD());
						benefitItemListContent.put("Code", currentBenefit.getBenefitId());
						benefitItemListContent.put("Description", currentBenefit.getBenefitDescription());

						benefitItemList.add(benefitItemListContent);
					}

					benefitTypeItem.put("BenefitItems", benefitItemList);

					benefitTypesContainer.add(benefitTypeItem);
				}
			}

			JSONArray benefitValueMapping = JSONFactoryUtil.createJSONArray(benefitTypesContainer);

			response.put("Status", 1);
			response.put("Message", "Data is ready");
			response.put("Data", benefitValueMapping);
		} catch (Exception e) {
			_logs.info("calculate: " + e.getMessage());
			response.put("Status", 0);
			response.put("Message", "Failed to get data");
			response.put("Data", "");
		}

		return response.toString();
	}

	public String parseDate(String dateStr) throws ParseException {
		for (String[] month : MONTHS) {
			dateStr = dateStr.replace(month[0], month[1]);
		}

		Date dobParsed = inputFormat.parse(dateStr);

		return outputFormat.format(dobParsed);
	}

	public String parseDate2(String dateStr) throws ParseException {
		for (String[] month : MONTHS) {
			dateStr = dateStr.replace(month[0], month[1]);
		}

		Date dobParsed = inputFormat.parse(dateStr);

		return outputFormat2.format(dobParsed);
	}

	private List<String> manageFile(String base64Image, String prefixTypeFileName, String folderInLR,
			HttpServletRequest httpServletRequest) throws PortalException, IOException {

		List<String> datafile = new ArrayList<>();

		String filePath = StringPool.BLANK;
		long fileEntryId = 0;

		// Ambil ServiceContext dari HttpServletRequest
		ServiceContext serviceContextFile = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
				httpServletRequest);

		try {

			// Default ke ".jpg" dan "image/jpeg"
			String imageFileName = prefixTypeFileName + "_" + new Date().getTime();
			String imageFileExtension = ".jpg";
			String imageFileContentType = "image/jpeg";

			// Deteksi ekstensi berdasarkan prefix Base64
			if (base64Image.startsWith(JPEG_BASE64_PREFIX)) {
				imageFileExtension = ".jpeg";
				imageFileContentType = "image/jpeg";
				base64Image = base64Image.replace(JPEG_BASE64_PREFIX, "");
			} else if (base64Image.startsWith(PNG_BASE64_PREFIX)) {
				imageFileExtension = ".png";
				imageFileContentType = "image/png";
				base64Image = base64Image.replace(PNG_BASE64_PREFIX, "");
			}

			String imageFileNameFull = imageFileName + imageFileExtension;

			// Decode base64 ke File
			File file = decodeBase64ToFile(base64Image, imageFileNameFull);

			// Validasi file
			_validateFile(imageFileNameFull, imageFileContentType, file.length());

			// Dapatkan folder user atau buat folder baru jika belum ada
			long scopeGroupId = serviceContextFile.getScopeGroupId();
			long userIdFile = serviceContextFile.getGuestOrUserId();

			DLFolder userFolder = DLFolderLocalServiceUtil.fetchFolder(scopeGroupId, 0, folderInLR);
			if (userFolder == null) {
				userFolder = DLFolderLocalServiceUtil.addFolder(userIdFile, // ID pengguna
						scopeGroupId, // ID grup
						scopeGroupId, // Parent folder ID (root folder)
						false, // Folder bukan inheriting per-site permissions
						0, // Parent folder ID
						folderInLR, // Nama folder
						"", // Deskripsi
						false, // Tidak menggunakan manualIndexing
						serviceContextFile // ServiceContext berisi informasi pengguna dan grup
				);
			}

			// Set permission untuk guest (opsional)
			_setGuestPermission(serviceContextFile, DLFolder.class.getName(), userFolder.getPrimaryKey());

			long folderId = userFolder.getFolderId();

			// Set unique filename
			String uniqueFileName = _uniqueFileNameProvider.provide(imageFileNameFull,
					curFileName -> _exists(serviceContextFile, folderId, curFileName));

			// Tambahkan file ke Liferay Document Library
			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userIdFile, // ID pengguna
					scopeGroupId, // ID grup
					folderId, // Folder tempat file akan diunggah
					uniqueFileName, // Nama file
					imageFileContentType, // Tipe konten file
					uniqueFileName, // Nama file
					"", // Deskripsi
					"", // ChangeLog
					file, // File yang akan diunggah
					serviceContextFile // ServiceContext dengan metadata file dan izin
			);

			// Set permission untuk file yang diunggah (opsional)
			_setGuestPermission(serviceContextFile, DLFileEntry.class.getName(), fileEntry.getPrimaryKey());

			// Simpan fileEntryId dan path file
			fileEntryId = fileEntry.getFileEntryId();
			filePath = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/"
					+ fileEntry.getFileName();

			datafile.add(Long.toString(fileEntryId));
			datafile.add(filePath);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return datafile;

	}

	public File decodeBase64ToFile(String base64ImageString, String fileName) throws IOException {
		// Tentukan direktori sementara untuk menyimpan file sementara
		String tempDir = System.getProperty("java.io.tmpdir");
		File file = new File(tempDir, fileName);

		// Decode string Base64 menjadi byte array
		byte[] decodedBytes = Base64.getDecoder().decode(base64ImageString);

		// Tulis byte array ke dalam file
		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(decodedBytes);
			fos.flush();
		}

		return file;
	}

	private boolean _setGuestPermission(ServiceContext serviceContext, String name, long primKey) {
		Map<Long, String[]> roleIdsToActionIds = new HashMap<>();

		// Ambil role GUEST berdasarkan companyId dari serviceContext
		long guestRoleId = RoleLocalServiceUtil.fetchRole(serviceContext.getCompanyId(), RoleConstants.GUEST)
				.getRoleId();

		roleIdsToActionIds.put(guestRoleId, new String[] { ActionKeys.VIEW });

		try {
			// Set resource permissions dengan companyId dari serviceContext
			ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(), name,
					ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(primKey), roleIdsToActionIds);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean _exists(ServiceContext serviceContext, long folderId, String curFileName) {
		try {
			// Menggunakan serviceContext untuk mendapatkan scopeGroupId
			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(serviceContext.getScopeGroupId(), folderId,
					curFileName);

			if (tempFileEntry != null) {
				return true;
			}

			return false;
		} catch (PortalException portalException) {
			if (_log.isDebugEnabled()) {
				_log.debug(portalException, portalException);
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

	private static JSONObject errorMessage(String message) {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		_response.put("Status", 0);
		_response.put("Message", message);
		_response.put("Data", "");

		return _response;
	}

	// Format date string to yyyy-mm-dd for database
	private static String customFormatDate(String dateStr) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate date = LocalDate.parse(dateStr, inputFormatter);
		String formattedDate = date.format(outputFormatter);
		return formattedDate;
	}

	private static String customFormatDateTime(String dateStr) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate date = LocalDate.parse(dateStr, inputFormatter);
		String formattedDate = date.format(outputFormatter);
		return formattedDate + " 00:00:00";
	}

	private static String _customFormatDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	// OCR API
	@POST
	@Path("/ocr")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
public String processOCR(String request, @Context HttpServletRequest httpServletRequest) {
		JSONObject _response = JSONFactoryUtil.createJSONObject();

		try {
			JSONObject params = JSONFactoryUtil.createJSONObject(request);
			String dataCategory = params.getString("dataCategory");

			if ("ocr".equalsIgnoreCase(dataCategory)) {
				String base64Image = params.getString("_fotoBase64");
				String fileName = params.getString("_fileName");

				String imageFileName = "ktpkitas" + "_" + new Date().getTime();
				String imageFileExtension = ".jpg";
				String imageFileContentType = "image/jpeg";

				// Deteksi ekstensi berdasarkan prefix Base64
				if (base64Image.startsWith(JPEG_BASE64_PREFIX)) {
					imageFileExtension = ".jpeg";
					imageFileContentType = "image/jpeg";
					base64Image = base64Image.replace(JPEG_BASE64_PREFIX, "");
				} else if (base64Image.startsWith(PNG_BASE64_PREFIX)) {
					imageFileExtension = ".png";
					imageFileContentType = "image/png";
					base64Image = base64Image.replace(PNG_BASE64_PREFIX, "");
				}

				String imageFileNameFull = imageFileName + imageFileExtension;

				// Decode base64 ke File
				File file = decodeBase64ToFile(base64Image, imageFileNameFull);
				_log.info("API_KEY>>" + API_KEY);
				_log.info("AUTH_HEADERS>>" + AUTH_HEADERS);
				_log.info("OCR_CLIENT_URL>>" + OCR_CLIENT_HOST_URL);

				String ocrRequestUrl = OCR_CLIENT_HOST_URL + OCR_PATH_URL;
				String response = hitApiOCR(ocrRequestUrl, file, API_KEY, AUTH_HEADERS, imageFileContentType);

				_logs.info("response from glair scan ocr :" + response);

				JSONObject _responseOCR = JSONFactoryUtil.createJSONObject(response);

				_response.put(GENERAL_TEXT_LOWERCASE_STATUS, OCR_RESPONSE_STATUS_SUCCESS.equalsIgnoreCase(_responseOCR.getString(GENERAL_TEXT_LOWERCASE_STATUS)));
				_response.put(GENERAL_TEXT_LOWERCASE_MESSAGE, "");
				_response.put("data", _responseOCR.get("read"));

				return _response.toString();
			} else {
				_response.put(GENERAL_TEXT_LOWERCASE_STATUS, false);
				_response.put(GENERAL_TEXT_LOWERCASE_MESSAGE, "Invalid data category / Bad Request");
				return _response.toString();
			}
		} catch (Exception e) {
			_logs.error("Error processing OCR request", e);
			_response.put(GENERAL_TEXT_LOWERCASE_STATUS, false);
			_response.put(GENERAL_TEXT_LOWERCASE_MESSAGE, "Error processing OCR request / Internal Server");
			return _response.toString();
		}
	}

	String apiLiferayCountries = String.valueOf(helpers.getConfig("com.mypage.client.api.liferay.countries"));
	String finalApiLRCountries = PIMCORE_ADDRESS + apiLiferayCountries;

	@GET
	@Path("/countries")
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchCountries(@Context HttpServletRequest request) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		HttpURLConnection connection = null;
		try {
			String apiUrl = finalApiLRCountries;
			URL requestUrl = new URL(apiUrl);
			if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();

				httpsConnection.setHostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String requestedHost, SSLSession remoteServerSession) {
						return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
					}
				});

				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, new TrustManager[] { new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
					}

					public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
					}

					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
				} }, new SecureRandom());

				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());

				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			// Check response code
			int responseCode = connection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder result = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					result.append(line);
				}
				reader.close();

				// Parse response JSON
				JSONObject apiResponse = JSONFactoryUtil.createJSONObject(result.toString());
				int status = apiResponse.getInt("Status");
				if (status == 1) {
					JSONArray data = apiResponse.getJSONArray("Data");
					JSONArray countries = JSONFactoryUtil.createJSONArray();

					for (int i = 0; i < data.length(); i++) {
						JSONObject country = data.getJSONObject(i);
						JSONObject formattedCountry = JSONFactoryUtil.createJSONObject();
						formattedCountry.put("id", country.getLong("Id"));
						formattedCountry.put("name", country.getString("Name"));
						countries.put(formattedCountry);
					}

					response.put(GENERAL_TEXT_LOWERCASE_STATUS, 1);
					response.put("data", countries);
					return response.toString();
				} else {
					response.put(GENERAL_TEXT_LOWERCASE_STATUS, 0);
					return errorMessage(apiResponse.getString("Message")).toString();
				}
			} else {
				response.put(GENERAL_TEXT_LOWERCASE_STATUS, 0);
				response.put(GENERAL_TEXT_LOWERCASE_MESSAGE, "Gagal memuat data");
				return errorMessage("Gagal mengambil data negara.").toString();
			}
		} catch (Exception e) {
			_log.error("Error fetching countries from Pimcore.", e);
			return errorMessage("Gagal mengambil data negara.").toString();
		}
	}

	@GET
	@Path("/images/{token}")
	@Produces("image/*")
	public Response getImage(@PathParam("token") String token) throws Exception {
		try {
			Long imageId = 0L;

			if (Validator.isNotNull(token)) {
				imageId = Long.parseLong(EncryptionHelper.decrypt(token));
			}

			if (imageId == 0) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}

			// Get the FileEntry from Liferay's Document Library
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(imageId);
			FileVersion fileVersion = fileEntry.getFileVersion();
			InputStream imageStream = fileVersion.getContentStream(true); // Get input stream of the image

			// Get MIME type dynamically
			String mimeType = fileEntry.getMimeType();

			return Response.ok(imageStream).type(mimeType).build();

		} catch (Exception e) {
			_log.error("Error get image", e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	public String hitApiOCR(String url, File imageFile, String apiKey, String auth, String contentTypeImg) {
		int maxRetries = 3;
		int currentRetry = 1;
		String response = "";

		while (currentRetry <= maxRetries) {
			HttpURLConnection connection = null;
			BufferedReader reader = null;

			try {
				connection = openConnection(url);
				prepareRequest(connection, apiKey, auth);
				sendMultipartData(connection, imageFile, contentTypeImg);

				int responseCode = connection.getResponseCode();
				reader = new BufferedReader(
						new InputStreamReader(responseCode == HttpURLConnection.HTTP_OK ? connection.getInputStream()
								: connection.getErrorStream()));

				response = readResponse(reader);
				_log.info((responseCode == HttpURLConnection.HTTP_OK ? "Success >>" : "Error >>") + response);
				break;
			} catch (Exception e) {
				_log.info("Failed API request >> " + e.getMessage());
				currentRetry++;
			} finally {
				if (connection != null)
					connection.disconnect();
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						_log.info("Failed to close reader >> " + e.getMessage());
					}
				}
			}
		}

		return response;
	}

	private HttpURLConnection openConnection(String urlStr)
			throws IOException, NoSuchAlgorithmException, KeyManagementException {
		URL url = new URL(urlStr);
		if (url.getProtocol().equalsIgnoreCase("https")) {
			HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
			httpsConnection.setHostnameVerifier((host, session) -> host.equalsIgnoreCase(session.getPeerHost()));

			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] { new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) {
					// This implementation trusts all client certificates. Only for internal API
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) {
					// This implementation trusts all server certificates. Only for internal API
				}

				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			} }, new SecureRandom());

			httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
			return httpsConnection;
		} else {
			return (HttpURLConnection) url.openConnection();
		}
	}

	private void prepareRequest(HttpURLConnection connection, String apiKey, String auth) throws ProtocolException {
		String boundary = Long.toHexString(System.currentTimeMillis());
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		connection.setRequestProperty("x-api-key", apiKey);
		connection.setRequestProperty("Authorization", "Basic " + auth);
		connection.setConnectTimeout(60000);
		connection.setReadTimeout(60000);
		connection.setDoOutput(true);
		connection.setRequestProperty("boundary", boundary);
	}

	private void sendMultipartData(HttpURLConnection connection, File imageFile, String contentTypeImg)
			throws IOException {
		String boundary = connection.getRequestProperty("boundary");
		try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				FileInputStream fileInputStream = new FileInputStream(imageFile)) {

			wr.writeBytes("--" + boundary + "\r\n");
			wr.writeBytes(
					"Content-Disposition: form-data; name=\"image\"; filename=\"" + imageFile.getName() + "\"\r\n");
			wr.writeBytes("Content-Type: " + contentTypeImg + "\r\n\r\n");

			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = fileInputStream.read(buffer)) != -1) {
				wr.write(buffer, 0, bytesRead);
			}
			wr.writeBytes("\r\n--" + boundary + "--\r\n");
		}
	}

	private String readResponse(BufferedReader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	/**
	 * end block scan ocr
	 */

	/**
	 * SEND DATA TO PIMCORE API
	 */
	public static JSONObject hitAPI(String url, String payload) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		String line = StringPool.BLANK;
		StringBuilder responseBody = new StringBuilder();
		int httpResponseCode = 0;

		try {
			URL requestUrl = new URL(url);
			HttpURLConnection connection = null;

			if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();

				httpsConnection.setHostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String requestedHost, SSLSession remoteServerSession) {
						return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
					}
				});

				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, new TrustManager[] { new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
					}

					public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
					}

					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
				} }, new SecureRandom());

				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());

				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}

			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			// connection.setRequestProperty("Authorization", token); // Set Authorization
			// header

			connection.setConnectTimeout(60000);
			connection.setReadTimeout(60000);
			connection.setDoOutput(true);

			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(payload.getBytes());
			outputStream.flush();
			outputStream.close();

			if (connection.getResponseCode() == 200) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = bufferedReader.readLine()) != null) {
					responseBody.append(line);
				}
				bufferedReader.close();
			} else {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = bufferedReader.readLine()) != null) {
					responseBody.append(line);
				}
				bufferedReader.close();
			}
			httpResponseCode = connection.getResponseCode();
		} catch (IOException e) {
            _logs.error("ERROR", e);
			throw e;
		}

		_response.put("httpStatusCode", httpResponseCode);
		JSONObject _pimcoreResponseBody = JSONFactoryUtil.createJSONObject(responseBody.toString());
		_response.put("data", _pimcoreResponseBody);

		return _response;
	}

	/**
	 * Call API
	 */
	public static JSONObject callAPI(String payload, String targetUrl) throws Exception, IOException {
        JSONObject responseAPI = null;
        String line = StringPool.BLANK;
        StringBuilder responseBody = new StringBuilder();
        
        _logs.info("callAPI METHOD TARGET URL PARAM: " + targetUrl);

        try {
            URL requestUrl = new URL(targetUrl);
            HttpURLConnection connection = null;

            if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();

				httpsConnection.setHostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String requestedHost, SSLSession remoteServerSession) {
						return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
					}
				});

				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, new TrustManager[] { new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
					}

					public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
					}

					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
				} }, new SecureRandom());

				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());

				connection = httpsConnection;
            } else {
                connection = (HttpURLConnection) requestUrl.openConnection();
            }

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            // connection.setRequestProperty("Authorization", token); // Set Authorization
            // header

            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(payload.getBytes());
            outputStream.flush();
            outputStream.close();

            if (connection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = bufferedReader.readLine()) != null) {
                    responseBody.append(line);
                }
                bufferedReader.close();
            } else {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = bufferedReader.readLine()) != null) {
                    responseBody.append(line);
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            _logs.error("ERROR", e);
            throw e;
        }

        responseAPI = JSONFactoryUtil.createJSONObject(responseBody.toString());
        return responseAPI;
	}

//	@SuppressWarnings("unchecked")
//	public static Map<String, Object> convertJsonToMap(String jsonInput) {
//	    try {
//	        ObjectMapper objectMapper = new ObjectMapper();
//
//	        // Parse JSON input menjadi Map
//	        Map<String, Object> rawData = objectMapper.readValue(jsonInput, new TypeReference<Map<String, Object>>() {});
//
//	        if (rawData.containsKey("policyholder") && rawData.containsKey("insured")) {
//	            // Extract "policyholder" dan "insured"
//	            Map<String, Object> policy = (Map<String, Object>) rawData.get("policyholder");
//	            List<Map<String, Object>> insuredList = (List<Map<String, Object>>) rawData.get("insured");
//
//	            Map<String, Object> result = new HashMap<>();
//	            result.put("policyholder", policy);
//	            result.put("insured", insuredList);
//
//	            return result;
//	        }
//	        
//	        
//	        // Kirim penawaran
//	        if (rawData.containsKey("Name") && rawData.containsKey("Email")) {
//	            String fullName = (String) rawData.get("Name");
//	            String emailAddress = (String) rawData.get("Email");
//
//	            Map<String, Object> result = new HashMap<>();
//	            result.put("Name", fullName);
//	            result.put("Email", emailAddress);
//
//	            return result;
//	        }
//	        
//
//	        throw new RuntimeException("Unrecognized JSON structure");
//	    } catch (Exception e) {
//			_logs.info("[Try Catch][Message]: " + e.getMessage());
//	        throw new RuntimeException("Failed to convert JSON to Map", e);
//	    }
//	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> convertJsonToMap(String jsonInput) {
		try {
			Gson gson = new Gson();

			// Tentukan tipe Map untuk parsing JSON
			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();
			Map<String, Object> rawData = gson.fromJson(jsonInput, type);

			if (rawData.containsKey("policyholder") && rawData.containsKey("insured")) {
				Map<String, Object> policy = (Map<String, Object>) rawData.get("policyholder");
				List<Map<String, Object>> insuredList = (List<Map<String, Object>>) rawData.get("insured");

				Map<String, Object> result = new HashMap<>();
				result.put("policyholder", policy);
				result.put("insured", insuredList);
				result.put("insuredIsPolis", rawData.get("insuredIsPolis"));
				result.put("token", rawData.get("token"));

				return result;
			}

			if (rawData.containsKey("Name") && rawData.containsKey("Email")) {
				String fullName = (String) rawData.get("Name");
				String emailAddress = (String) rawData.get("Email");

				Map<String, Object> result = new HashMap<>();
				result.put("Name", fullName);
				result.put("Email", emailAddress);

				return result;
			}

			throw new RuntimeException("Unrecognized JSON structure");
		} catch (Exception e) {
			throw new RuntimeException("Failed to convert JSON to Map", e);
		}
	}

	/**
	 * END HIT PAYMENT PIMCORE
	 */

	private double roundCustom(double target, String currency) {
		double result = (currency.equalsIgnoreCase("idr")) ? Math.round(target) : Math.round(target * 100.0) / 100.0;
		return result;
	}

	private static String generateNumericCurrentTimeStamp() {
		LocalDateTime timestamp = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String numericTimestamp = timestamp.format(formatter);
		return numericTimestamp;
	}

	private static final String currentNumericTimeStamp = generateNumericCurrentTimeStamp();
	private static final Object[] _IMAGE_EXTENSIONS = { ".jpeg", ".jpg", ".png" };
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log _log = LogFactoryUtil.getLog(SmartTravel2Application.class);

	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;

	@Reference
	LeadsLocalService leadsLocalService;

	@Reference
	CustomerLocalService customerLocalService;

	@Reference
	StiBenefitLocalService stiBenefitLocalService;
}