package com.mypage.product.it.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
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
import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.model.BenefitValueMapping;
import com.mypage.admin.product.model.MasterCurrency;
import com.mypage.admin.product.model.Premi;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.SmartTravelIntPlan;
import com.mypage.admin.product.service.BenefitLocalService;
import com.mypage.admin.product.service.BenefitLocalServiceUtil;
import com.mypage.admin.product.service.BenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.BenefitValueMappingLocalServiceUtil;
import com.mypage.admin.product.service.MasterCurrencyLocalServiceUtil;
import com.mypage.admin.product.service.PremiLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.SmartTravelIntPlanLocalServiceUtil;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.model.AgentTokenLimiter;
import com.mypage.agencyportal.service.AgentTokenLimiterLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalServiceUtil;
import com.mypage.leads.model.Customer;
import com.mypage.leads.model.DetailInternationalTravel;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.CustomerLocalService;
import com.mypage.leads.service.CustomerLocalServiceUtil;
import com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalService;
import com.mypage.leads.service.LeadsLocalServiceUtil;
import com.mypage.product.it.helper.EncryptionHelper;
import com.mypage.product.it.helper.MypageHelpers;
import com.mypage.product.it.helper.XSSValidator;
import com.mypage.product.it.wrapper.PropsUtilService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/sti",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=SmartTravelApplication.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
public class SmartTravelApplication extends Application {
	private PropsUtilService propService;
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	public void setPropService(PropsUtilService propService) {
	    this.propService = propService;
	}

	// Peta Base64 prefix ke ekstensi file dan tipe konten
	private static final String JPEG_BASE64_PREFIX = "data:image/jpeg;base64,";
	private static final String PNG_BASE64_PREFIX = "data:image/png;base64,";

	private final SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	private final SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

	private final SimpleDateFormat outputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	
	private final MypageHelpers helpers = new MypageHelpers();
	private final Log _logs = LogFactoryUtil.getLog(SmartTravelApplication.class);

//	private final String OCR_CLIENT_HOST_URL = helpers.getConfig("com.mypage.agent.config.ocrClientHostURL");
//	private final String OCR_PATH_URL = helpers.getConfig("com.mypage.agent.config.ocrClientPathURL");
//	
//	
//	private final String API_KEY = helpers.getConfig("com.mypage.agent.config.ocrClientApiKey");
//	private final String AUTH_HEADERS = helpers.getConfig("com.mypage.agent.config.ocrClientAuthHeader");
//	private final String PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreHost");
//	private final String PIMCORE_ADDRESS = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
//	
//	private final String KYC_PAYMENT_PIMCORE = helpers.getConfig("smarttravel.api.payment");
//	private final String CREATE_QUOTE_PIMCORE = helpers.getConfig("smarttravel.api.leads.createQuote");
//	private final String CHECK_PROMOCODE_PIMCORE = helpers.getConfig("smarttravel.api.leads.checkPromoCode");
//	
//	private final String LEADS_CHECK_VALIDATE_PIMCORE = helpers.getConfig("smarttravel.api.leads.checkValidate");

	private static final String[][] MONTHS = { { "Mei", "May" }, { "Jan", "January" }, { "Feb", "February" },
			{ "Mar", "March" }, { "Apr", "April" }, { "Jun", "June" }, { "Jul", "July" }, { "Agu", "August" },
			{ "Sep", "September" }, { "Okt", "October" }, { "Nov", "November" }, { "Des", "December" } };
	
//	private ProductConfiguration _productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6");

	// TOKEN UNTUK IFRAME
	@GET
	@Path("/show")
	@Produces("application/json")
	public String showAction(@QueryParam("a") String params) throws PortletException, IOException {
		JsonObject _response = new JsonObject();
		JsonObject _data = new JsonObject();
		try {
			EncryptionHelper encryptionHelper = new EncryptionHelper();
			String _secureToken = EncryptionHelper.generateSecureToken(32);
			
			@SuppressWarnings("static-access")
			String param = encryptionHelper.decrypt(params);
			String[] paramSplit = param.split("\\|");
			String deptCode = paramSplit[1];

			AgentToken _agentToken = AgentTokenLocalServiceUtil.getAgentTokenByDeptCode(deptCode);

			if (!Validator.isNull(_agentToken)) {
				long agentTokenId = _agentToken.getAgentTokenId();
				_agentToken = AgentTokenLocalServiceUtil.editAgentToken(agentTokenId, deptCode, _secureToken, 1);
			} else {
				_agentToken = AgentTokenLocalServiceUtil.addAgentToken(deptCode, _secureToken, 1);
			}

			@SuppressWarnings("static-access")
			String token = encryptionHelper.encrypt(_secureToken);
			_data.addProperty("Token", token);
			_response.addProperty("Status", 1);
			_response.add("Data", _data);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return _response.toString();
	}
	
	@POST
	@Path("/updatecurrency")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCurrency(String request)
			throws JSONException, IOException {
		JsonObject response = new JsonObject();
		
		try {
			JsonObject params = new Gson().fromJson(request, JsonObject.class);
			double usdAmount = params.get("usd").getAsDouble();
			
			if(usdAmount == 0.0) {
				response.addProperty("Status", 0);
				response.addProperty("Message", "Amount cant be 0");
			} else {
				List<MasterCurrency> allCurrencies = MasterCurrencyLocalServiceUtil.getMasterCurrencies();
				if(allCurrencies == null) {
					response.addProperty("Status", 0);
					response.addProperty("Message", "No currency available");
					return response.toString(); 
				}
				
				MasterCurrency currentUsdCurrency = null;
				
				for(MasterCurrency currency : allCurrencies) {
					if(currency.getName().equalsIgnoreCase("usd")) {
						currentUsdCurrency = currency;
					}
				}

				if (currentUsdCurrency == null) {
					response.addProperty("Status", 0);
					response.addProperty("Message", "USD currency not found");
					return response.toString(); 
				}
				
				MasterCurrencyLocalServiceUtil.updateMasterCurrency(currentUsdCurrency.getCurrencyId(), currentUsdCurrency.getName(), usdAmount, currentUsdCurrency.getIsDefault(), currentUsdCurrency.getActive());
				
				response.addProperty("Status", 1);
				response.addProperty("Message", "Currency successfully updated");				
			}
	
		} catch (Exception e) {
			response.addProperty("Status", 0);
			response.addProperty("Message", "Failed to update the currency");
		}
		
		return response.toString();
	}

	// CALCULATE PREMI
	private List<Map<String, Object>> calculateIndividual(Map<String,Object> paramCalc) {
		List<Map<String, Object>> individualPlanContainer = new ArrayList<>();
		
		String referrer = (String) paramCalc.get("referrer");
		String currency = (String) paramCalc.get("currency");
		String choosenPlan = (String) paramCalc.get("choosenPlan");
		String travelType = (String) paramCalc.get("travelType");
		int additionalDays = (int) paramCalc.get("additionalDays");
		JsonArray additionalBenefits = (JsonArray) paramCalc.get("additionalBenefits");
		JsonArray additionalBenefitCodes = (JsonArray) paramCalc.get("additionalBenefitCodes");
		int fp = (int) paramCalc.get("fp");
		
		try {
			MasterCurrency masterCurrency = MasterCurrencyLocalServiceUtil.searchCurrency(currency);
			
			List<Premi> premis = new ArrayList<>(PremiLocalServiceUtil.findByCurrencyAndTravellerType(currency, "individual"));
			if (Validator.isNull(premis)) {
				return individualPlanContainer;
			}
			
			Set<Long> planIds = new HashSet<>();
			for (Premi premi : premis) {
				planIds.add(premi.getPlanId());
			}
			Long[] planIdsArray = planIds.toArray(new Long[0]);
			
			for (Long planId : planIdsArray) {
				
				SmartTravelIntPlan _plan = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(planId);
				
				// JIKA ADA CHOOSEN PLAN, TAMPILKAN SATU PLAN AJA SESUAI CHOOSEN PLAN
				if(!choosenPlan.isEmpty()) {
					if(!_plan.getNameId().equals(choosenPlan)) {
						continue;
					}
				}

				LinkedHashMap<String, Object> itemData = new LinkedHashMap<>();

				itemData.put("PlanName", _plan.getNameId());

				// Data jaminan utama dan tambahan serta harga preminya di plan saat ini
				double totalMainBenefitPremiPrice = 0;
				double totalAdditionalPrice = 0;
				List<HashMap> mainBenefitList = new ArrayList<>();
				List<HashMap> mainBenefitListDesc = new ArrayList<>();
				HashMap<String, Double> mainBenefit = new HashMap<>();
				List<HashMap> additionalBenefitList = new ArrayList<>();
				
				double totalAllAdditionalPrice = 0; 

				for (Premi premi : premis) {
					if (premi.getPlanId() == planId) {

						// Benefit yang terhubung dengan premi saat ini
						Benefit currentBenefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
						BenefitType currentBenefitType = BenefitTypeLocalServiceUtil.getBenefitType(currentBenefit.getBenefitTypeId());

						// MAIN BENEFIT
						if (currentBenefitType.getNameId().equals("Jaminan Utama") && currentBenefitType.getNameEn().equals("Main Benefit")) {
							if (travelType.equals("single")) {
								totalMainBenefitPremiPrice += premi.getBasic().doubleValue();
								
								if (additionalDays > 0) {
									totalMainBenefitPremiPrice += premi.getAdditional().doubleValue() * additionalDays;
								}

							} else if (travelType.equals("annual")) {
								totalMainBenefitPremiPrice += premi.getAnnual().doubleValue();
							}

							Benefit _benefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
							mainBenefit.put(_benefit.getNameId(), premi.getBasic().doubleValue());

							HashMap<String, Object> mainBenefitItem = new HashMap<>();
							mainBenefitItem.put("Name", _benefit.getNameId());
							mainBenefitItem.put("Amount", premi.getBasic().doubleValue());

							mainBenefitList.add(mainBenefitItem);
							
							HashMap<String, Object> mainBenefitListDescItem = new HashMap<>();
							mainBenefitListDescItem.put("Name", _benefit.getNameId());
							
							BenefitValueMapping bvm = BenefitValueMappingLocalServiceUtil.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(currentBenefitType.getBenefitTypeId(), _benefit.getBenefitId(), premi.getPlanId());
							mainBenefitListDescItem.put("Desc", bvm.getBenefitValue());
							mainBenefitListDescItem.put("DescUSD", bvm.getBenefitValueUSD());
							mainBenefitListDesc.add(mainBenefitListDescItem);
						}

						// ADDITIONAL BENEFITS
						if (!currentBenefitType.getNameId().equals("Jaminan Utama")
								&& !currentBenefitType.getNameEn().equals("Main Benefit")) {

							// Jika ada dari pimcore
							if(!referrer.isEmpty()) {
								if (!Validator.isNull(additionalBenefitCodes)) {
									for (int i = 0; i < additionalBenefitCodes.size(); i++) {
										if (additionalBenefitCodes.get(i).getAsString().equalsIgnoreCase(currentBenefit.getExternalCode())) {
											// single atau tahunan
											if (travelType.equals("single")) {
												totalAdditionalPrice += premi.getBasic().doubleValue();

												// jika ada additional day
												if (additionalDays > 0) {
													totalAdditionalPrice += premi.getAdditional().doubleValue()
															* additionalDays;
												}

											} else if (travelType.equals("annual")) {
												totalAdditionalPrice += premi.getAnnual().doubleValue();
											}
											
											HashMap<String, Object> additionalBenefitItem = new HashMap<>();
											additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
											additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
											additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());
											
											BenefitValueMapping _bvm = BenefitValueMappingLocalServiceUtil
													.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
															currentBenefitType.getBenefitTypeId(),
															currentBenefit.getBenefitId(), premi.getPlanId());
											additionalBenefitItem.put("BenefitValueIDR", _bvm.getBenefitValue());
											additionalBenefitItem.put("BenefitValueUSD", _bvm.getBenefitValueUSD());
//											additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

											additionalBenefitList.add(additionalBenefitItem);
										}
									}
								}
								
							} else {
								
								// Additional benefits dari FE liferay (bukan pimcore)
								if (!Validator.isNull(additionalBenefits)) {
									for (int i = 0; i < additionalBenefits.size(); i++) {
										if (additionalBenefits.get(i).getAsInt() == currentBenefit.getBenefitId()) {

											// Single atau tahunan
											if (travelType.equals("single")) {
												totalAdditionalPrice += premi.getBasic().doubleValue();
												
												if (additionalDays > 0) {
													totalAdditionalPrice += premi.getAdditional().doubleValue()
															* additionalDays;
												}

											} else if (travelType.equals("annual")) {
												totalAdditionalPrice += premi.getAnnual().doubleValue();
											}

											HashMap<String, Object> additionalBenefitItem = new HashMap<>();
											additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
											additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
											additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());
											
											BenefitValueMapping _bvm = BenefitValueMappingLocalServiceUtil
													.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
															currentBenefitType.getBenefitTypeId(),
															currentBenefit.getBenefitId(), premi.getPlanId());
											additionalBenefitItem.put("BenefitValueIDR", _bvm.getBenefitValue());
											additionalBenefitItem.put("BenefitValueUSD", _bvm.getBenefitValueUSD());
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
								
								if(fp == 1) {
									totalAdditionalPrice += premi.getBasic().doubleValue();	
								}
								
								if (additionalDays > 0) {
									totalAllAdditionalPrice += premi.getAdditional().doubleValue()
											* additionalDays;
									if(fp == 1) {
										totalAdditionalPrice += premi.getAdditional().doubleValue()
												* additionalDays;
									}
								}

							} else if (travelType.equals("annual")) {
								totalAllAdditionalPrice += premi.getAnnual().doubleValue();
								if(fp == 1) {
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
			System.out.println(e.getMessage());
		}
		
		return individualPlanContainer;
	}
	
	// Final response
	private JsonObject finalResponse(String travellerType, String travelType, String currency, long totalInclusiveDays,
			MasterCurrency masterCurrency, int adultTotal, int childTotal, String departureDisplayDate,
			String arrivalDisplayDate, double discount, boolean spesificPlan, String choosenPlan, double commision,
			double tax, List<Map<String, Object>> planContainer, String promoCode, String paymentMethod, String managedBy) throws Exception {
		JsonObject dataBody = new JsonObject();
		
		ProductConfiguration _productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6");
		double policyCostIDR = _productConfiguration.getPolicyCostIDR();
		double policyCostUSD = _productConfiguration.getPolicyCostUSD();
		double policyCost = (currency.equals("idr")) ? policyCostIDR : policyCostUSD;
		double stampDutyIDR = _productConfiguration.getStampdutyIDR();
		double stampDutyUSD = _productConfiguration.getStampdutyUSD();
		double stampDuty = (currency.equals("idr")) ? stampDutyIDR : stampDutyUSD;
		long totalDays = (travelType.equals("single")) ? Long.valueOf(totalInclusiveDays) : Long.valueOf("365");
		
		dataBody.addProperty("TravellerType", travellerType.toUpperCase());
		dataBody.addProperty("TravelType", travelType.toUpperCase());
		dataBody.addProperty("Currency", currency.toUpperCase());
		dataBody.addProperty("TotalDays", totalDays);
		dataBody.addProperty("PolicyCost", policyCost);
		dataBody.addProperty("PolicyCostInIDR", Math.round(policyCost * masterCurrency.getAmount()));
		dataBody.addProperty("Stamp", stampDuty);
		dataBody.addProperty("StampInIDR", Math.round(stampDuty * masterCurrency.getAmount()));
		dataBody.addProperty("TotalAdult", adultTotal);
		dataBody.addProperty("TotalChild", childTotal);
		dataBody.addProperty("DepartureDate", departureDisplayDate);
		dataBody.addProperty("ArrivalDate", arrivalDisplayDate);
		dataBody.addProperty("PromoCode", promoCode);
		
		if (planContainer == null || planContainer.isEmpty() || planContainer.get(0) == null) {
		    throw new InvalidPlanException("Plan container must not be empty or null");
		}
		
		for (Map<String, Object> _planContainerItem : planContainer) {

			Double __TotalMainBenefitPremium = (Double) _planContainerItem.getOrDefault("TotalMainBenefitPremium", 0.0);
			Double __TotalAdditionalBenefitPremium = (Double) _planContainerItem.getOrDefault("TotalAdditionalBenefitPremium", 0.0);
			double __premiumForSpesificPlan = __TotalMainBenefitPremium + __TotalAdditionalBenefitPremium;
			double __premium = (currency.equals("idr")) ? Math.round(__premiumForSpesificPlan) : Math.round(__premiumForSpesificPlan * 100.0) / 100.0;
			
			double __grossPremium = __premiumForSpesificPlan;
			
			double __discountRate = discount / 100.0;
			double __discountAmount = __grossPremium * __discountRate;
			
			double __discountedPremium = __grossPremium - __discountAmount;
			__discountedPremium = (currency.equals("idr")) ? Math.round(__discountedPremium) : Math.round(__discountedPremium * 100.0) / 100.0;
			
			double __finalAmount = __discountedPremium + stampDuty + policyCost;
			double __finalAmountWithoutDiscount = __grossPremium + stampDuty + policyCost; // tanpa diskon
			
			double __netPremium = (currency.equals("idr")) ? Math.round(__finalAmount) : Math.round(__finalAmount* 100.0) / 100.0;
			double netpwd = (currency.equals("idr")) ? Math.round(__finalAmountWithoutDiscount) : Math.round(__finalAmountWithoutDiscount * 100.0) / 100.0;
			
			_planContainerItem.put("Discount", discount);
			_planContainerItem.put("Premium", __premium);
			_planContainerItem.put("NetPremium", __netPremium);
			_planContainerItem.put("NetPremiumIDR", Math.round(__netPremium * masterCurrency.getAmount()));
			_planContainerItem.put("NetPremiumWithoutDiscount", netpwd);
			_planContainerItem.put("NetPremiumWithoutDiscountIDR", Math.round(__finalAmountWithoutDiscount * masterCurrency.getAmount()));
			
			double adultmb = (double) _planContainerItem.getOrDefault("TotalAdultMainBenefitPremium", 0.0);
			double adultab = (double) _planContainerItem.getOrDefault("TotalAdultAdditionalBenefitPremium", 0.0);
			double _adultTotalPremi = adultmb + adultab;
			double adultTotalPremi = (currency.equals("idr")) ? Math.round(_adultTotalPremi) : Math.round(_adultTotalPremi * 100.0) / 100.0;
			_planContainerItem.put("PremiumAdult", adultTotalPremi);
			
			double childmb = (double) _planContainerItem.getOrDefault("TotalChildMainBenefitPremium", 0.0);
			double childab = (double) _planContainerItem.getOrDefault("TotalChildAdditionalBenefitPremium", 0.0);
			double _childTotalPremi = childmb + childab;
			double childTotalPremi = (currency.equals("idr")) ? Math.round(_childTotalPremi) : Math.round(_childTotalPremi * 100.0) / 100.0;
			_planContainerItem.put("PremiumChild", childTotalPremi);
			
		}
		
		Gson gson = new Gson();
		JsonElement elemPlanContainer = gson.toJsonTree(planContainer);
		
		dataBody.add("AvailablePlans", elemPlanContainer);
		dataBody.addProperty("Discount", discount);
		
		Double _TotalMainBenefitPremium = (Double) planContainer.get(0).getOrDefault("TotalMainBenefitPremium", 0.0);
		Double _TotalAdditionalBenefitPremium = (Double) planContainer.get(0).getOrDefault("TotalAdditionalBenefitPremium", 0.0);

		double premiumForSpesificPlan = _TotalMainBenefitPremium + _TotalAdditionalBenefitPremium;
		double premium = (currency.equals("idr")) ? Math.round(premiumForSpesificPlan) : Math.round(premiumForSpesificPlan * 100.0) / 100.0;

		double grossPremium = premiumForSpesificPlan;
		grossPremium = (currency.equals("idr")) ? Math.round(grossPremium) : Math.round(grossPremium * 100.0) / 100.0;
//		System.out.println("CALCULATE GROSS PREMIUM : " + grossPremium);
		
		double discountRate = discount / 100.0;
		double discountAmount = grossPremium * discountRate; 
//		System.out.println("CALCULATE DISCOUNT AMOUNT : " + discountAmount);
		
		double discountedPremium = grossPremium - discountAmount;
//		discountedPremium = (currency.equals("idr")) ? Math.round(discountedPremium) : Math.round(discountedPremium * 100.0) / 100.0;
		discountedPremium = (currency.equals("idr")) ? Math.round(discountedPremium) : discountedPremium;
//		System.out.println("CALCULATE DISCOUNTED PREMIUM (ROUND) : " + discountedPremium);
		
		double finalAmount = discountedPremium + stampDuty + policyCost;
//		System.out.println("CALCULATE FINAL AMOUNT : " + finalAmount);
		
		double netPremium = (currency.equals("idr")) ? Math.round(finalAmount) : Math.round(finalAmount * 100.0) / 100.0;
//		System.out.println("CALCULATE (ROUND) : " + netPremium);
		
		if (spesificPlan) {
			
			dataBody.addProperty("Premium", premium);
			dataBody.addProperty("DiscountAmount", discountAmount);
			dataBody.addProperty("NetPremium", netPremium);
			dataBody.addProperty("NetPremiumIDR", Math.round(netPremium * masterCurrency.getAmount()));
			dataBody.addProperty("Plan", choosenPlan);
			dataBody.addProperty("CurrencyAmount", masterCurrency.getAmount());
			
			// jika nettpremi, maka dihitung commisionValue dan tax
			// jika gross, commisionValue dan tax 0
			if (paymentMethod.equalsIgnoreCase("nett") && !managedBy.isEmpty()) {
								
				double commisionValue = (double) discountedPremium * commision / 100.0;
				commisionValue = (currency.equals("idr")) ? Math.round(commisionValue) : Math.round(commisionValue * 100.0) / 100.0;
				
				double taxRate = tax / 100.0;
				
				double taxValue = taxRate * commisionValue;
				taxValue = (currency.equals("idr")) ? Math.round(taxValue) :  Math.round(taxValue * 100.0) / 100.0;
				
				double nettPremium = (double) (discountedPremium - commisionValue) + taxValue + stampDuty + policyCost;
				nettPremium = (currency.equals("idr")) ? Math.round(nettPremium) : Math.round(nettPremium * 100.0) / 100.0;
		
				dataBody.addProperty("Commission", commision);
				dataBody.addProperty("CommissionValue", commisionValue);
				dataBody.addProperty("Tax", tax);
				dataBody.addProperty("TaxValue", taxValue);
				dataBody.addProperty("NettPremium", nettPremium);
				dataBody.addProperty("NettPremiumIDR", Math.round(nettPremium * masterCurrency.getAmount()));
			} else {
				dataBody.addProperty("Commission", commision);
				dataBody.addProperty("CommissionValue", 0);
				dataBody.addProperty("Tax", 0);
				dataBody.addProperty("TaxValue", 0);
				dataBody.addProperty("NettPremium", 0);
				dataBody.addProperty("NettPremiumIDR", 0);
			}
		}

		return dataBody;
	}
	
	private JsonObject calculatePremi(JsonObject params, boolean spesificPlan) throws JSONException, Exception {
		try {
			String mainbenefitKey1 = "Biaya Pengobatan, Gigi dan Lainnya";
			String mainbenefitKey2 = "Kecelakaan Diri";
			String mainbenefitKey3 = "Evakuasi Medis Darurat dan Repatriasi";
			String mainbenefitKey4 = "Pemulangan Jenazah";
			
			JsonObject result = new JsonObject();
			
			// START Request dari Pimcore dibedakan oleh isi di param Refferer ini
			String referrer = params.get("Referrer").getAsString();
			JsonArray additionalBenefitCodes = params.get("AdditionalBenefitCodes").getAsJsonArray();
			// END Request dari Pimcore dibedakan oleh isi di param Refferer ini
			
			JsonArray additionalBenefits = params.get("AdditionalBenefits").getAsJsonArray();
			String _managedBy = params.get("ManagedBy").getAsString();

			String currency = params.get("Currency").getAsString();
			currency = !Validator.isNull(currency) ? currency.toLowerCase() : "";
			
			String travellerType = params.get("TravellerType").getAsString();
			travellerType = !Validator.isNull(travellerType) ? travellerType.toLowerCase() : "";
			
			String travelType = params.get("TravelType").getAsString();
			travelType = !Validator.isNull(travelType) ? travelType.toLowerCase() : "";
			
			int adultTotal = params.get("AdultTotal").getAsInt() > 0 ? params.get("AdultTotal").getAsInt() : 0;
			int childTotal = params.get("ChildTotal").getAsInt() > 0 ? params.get("ChildTotal").getAsInt() : 0;

			// Harga basic premium berlaku untuk 1-3 hari, lebih dari itu dikenakan harga additional
			// Hitung total additional day
			String dateFrom = params.get("DepartureDate").getAsString();
			DateTimeFormatter dateFromFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
			
			LocalDate _dateFrom = LocalDate.parse(dateFrom, dateFromFormatter);
			String departureDisplayDate = _dateFrom.format(dateFromFormatter);

			String dateTo = params.get("ArrivalDate").getAsString();
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
			
			String promoCode = params.get("PromoCode").getAsString();
			String choosenPlan = params.get("SpesificPlan").getAsString();
			double commision = params.get("Commission").getAsDouble();
			double tax = params.get("Tax").getAsDouble();
			
			String paymentMethod = params.get("PaymentMethod").getAsString();
			
			// discount
			double discount = params.get("Discount").getAsDouble() > 0 ? params.get("Discount").getAsDouble() : 0.0;
			
			// full package
			int fp = params.get("fp").getAsInt();
			
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
//			System.out.println(individualPlanContainer);
			// END INDIVIDUAL

			// DUO
			// Hasil akhir duo adalah hasil penjumlahan dari individualContainer diatas
			// dengan duoContainer di dalam blok if duo dibawah.
			if (travellerType.equals("duo")) {

				List<Map<String, Object>> spousePlanContainer = new ArrayList<>();

				List<Premi> spousePremis = new ArrayList<>(
						PremiLocalServiceUtil.findByCurrencyAndTravellerType(currency, "spouse"));

				// Premi spouse harus ada untuk duo
				if (spousePremis.isEmpty()) {
					return result;
				}

				Set<Long> planSpouseIds = new HashSet<>();
				for (Premi spousePremi : spousePremis) {
					planSpouseIds.add(spousePremi.getPlanId());
			
				}
				Long[] planSpouseIdsArray = planSpouseIds.toArray(new Long[0]);

				for (Long planId : planSpouseIdsArray) {
					SmartTravelIntPlan _plan = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(planId);
					
					// JIKA ADA CHOOSEN PLAN, TAMPILKAN SATU PLAN AJA SESUAI CHOOSEN PLAN
					if(!choosenPlan.isEmpty()) {
						if(!_plan.getNameId().equals(choosenPlan)) {
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

					for (Premi premi : spousePremis) {
						if (premi.getPlanId() == planId) {

							Benefit currentBenefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
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

								} else if (travelType.equals("annual")) {
									totalMainBenefitPremiPrice += premi.getAnnual().doubleValue();
								}

								Benefit _benefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
								mainBenefit.put(_benefit.getNameId(), premi.getBasic().doubleValue());

								HashMap<String, Object> mainBenefitItem = new HashMap<>();
								mainBenefitItem.put("Name", _benefit.getNameId());
//								mainBenefitItem.put("Amount", premi.getBasic().doubleValue());

								mainBenefitList.add(mainBenefitItem);
							}

							// ADDITIONAL BENEFITS
							if (!currentBenefitType.getNameId().equals("Jaminan Utama")
									&& !currentBenefitType.getNameEn().equals("Main Benefit")) {

								// jika ada dari pimcore
								if(!referrer.isEmpty()) {
									if (!Validator.isNull(additionalBenefitCodes)) {
										for (int i = 0; i < additionalBenefitCodes.size(); i++) {
											if (additionalBenefitCodes.get(i).getAsString().equalsIgnoreCase(currentBenefit.getExternalCode())) {
												// single atau tahunan
												if (travelType.equals("single")) {
													totalAdditionalPrice += premi.getBasic().doubleValue();

													// jika ada additional day
													if (additionalDays > 0) {
														totalAdditionalPrice += premi.getAdditional().doubleValue()
																* additionalDays;
													}

												} else if (travelType.equals("annual")) {
													totalAdditionalPrice += premi.getAnnual().doubleValue();
												}

												HashMap<String, Object> additionalBenefitItem = new HashMap<>();
												additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
												additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
												additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());
												
												BenefitValueMapping _bvm = BenefitValueMappingLocalServiceUtil
														.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																currentBenefitType.getBenefitTypeId(),
																currentBenefit.getBenefitId(), premi.getPlanId());
												additionalBenefitItem.put("BenefitValueIDR", _bvm.getBenefitValue());
												additionalBenefitItem.put("BenefitValueUSD", _bvm.getBenefitValueUSD());
//												additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

												additionalBenefitList.add(additionalBenefitItem);
												
											}
										}
									}
								} else {
									
									// additional benefits dari FE liferay (bukan pimcore)
									if (!Validator.isNull(additionalBenefits)) {
										for (int i = 0; i < additionalBenefits.size(); i++) {
											if (additionalBenefits.get(i).getAsInt() == currentBenefit.getBenefitId()) {

												// single atau tahunan
												if (travelType.equals("single")) {
													totalAdditionalPrice += premi.getBasic().doubleValue();

													// jika ada additional day
													if (additionalDays > 0) {
														totalAdditionalPrice += premi.getAdditional().doubleValue()
																* additionalDays;
													}

												} else if (travelType.equals("annual")) {
													totalAdditionalPrice += premi.getAnnual().doubleValue();
												}

												HashMap<String, Object> additionalBenefitItem = new HashMap<>();
												additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
												additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
												additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());
												
												BenefitValueMapping _bvm = BenefitValueMappingLocalServiceUtil
														.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																currentBenefitType.getBenefitTypeId(),
																currentBenefit.getBenefitId(), premi.getPlanId());
												additionalBenefitItem.put("BenefitValueIDR", _bvm.getBenefitValue());
												additionalBenefitItem.put("BenefitValueUSD", _bvm.getBenefitValueUSD());
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
									
									if(fp == 1) {
										totalAdditionalPrice += premi.getBasic().doubleValue();	
									}

									// jika ada additional day
									if (additionalDays > 0) {
										totalAllAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;
										if(fp == 1) {
											totalAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;	
										}
										
									}

								} else if (travelType.equals("annual")) {
									totalAllAdditionalPrice += premi.getAnnual().doubleValue();
									if(fp == 1) {
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
							_individualItem.put("TotalMainBenefitPremium", currentIndividualTotalBasicPremium + currentSpouseTotalBasicPremium);

							// TotalAdditionalBenefitPremium
							double currentIndividualTotalAdditionalPremium = (double) _individualItem
									.get("TotalAdditionalBenefitPremium");
							double currentSpouseTotalAdditionalPremium = (double) _spouseItem
									.get("TotalAdditionalBenefitPremium");
							_individualItem.put("TotalAdditionalBenefitPremium", currentIndividualTotalAdditionalPremium + currentSpouseTotalAdditionalPremium);
							
							// TotalAdditionalBenefitPremiumAllChecked
							double currentIndividualTotalAdditionalPremiumAllChecked = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumAllChecked");
							double currentSpouseTotalAdditionalPremiumAllChecked = (double) _spouseItem
									.get("TotalAdditionalBenefitPremiumAllChecked");
							_individualItem.put("TotalAdditionalBenefitPremiumAllChecked", currentIndividualTotalAdditionalPremiumAllChecked + currentSpouseTotalAdditionalPremiumAllChecked);
							

							// TotalAdultMainBenefitPremium
							double currentIndividualTotalAdultMainBenefitPremium = (double) _individualItem
									.get("TotalAdultMainBenefitPremium");
							double currentSpouseTotalAdultMainBenefitPremium = (double) _spouseItem
									.get("TotalAdultMainBenefitPremium");
							_individualItem.put("TotalAdultMainBenefitPremium", currentIndividualTotalAdultMainBenefitPremium + currentSpouseTotalAdultMainBenefitPremium);
							
							// TotalAdultAdditionalBenefitPremium
							double currentIndividualTotalAdultAdditionalBenefitPremium = (double) _individualItem
									.get("TotalAdultAdditionalBenefitPremium");
							double currentSpouseTotalAdultAdditionalBenefitPremium = (double) _spouseItem
									.get("TotalAdultAdditionalBenefitPremium");
							_individualItem.put("TotalAdultAdditionalBenefitPremium",
									currentIndividualTotalAdultAdditionalBenefitPremium + currentSpouseTotalAdultAdditionalBenefitPremium);
							
							// TotalChildMainBenefitPremium tidak perlu karena ini DUO
							
							// TotalMainBenefitPremiumInIDR
							double currentIndividualTotalMainBenefitPremiumInIDR = (double) _individualItem.get("TotalMainBenefitPremiumInIDR");
							double currentSpouseTotalMainBenefitPremiumInIDR = (double) _spouseItem.get("TotalMainBenefitPremiumInIDR");
							_individualItem.put("TotalMainBenefitPremiumInIDR", currentIndividualTotalMainBenefitPremiumInIDR + currentSpouseTotalMainBenefitPremiumInIDR);
							
							// TotalAdditionalBenefitPremiumInIDR
							double currentIndividualTotalAdditionalBenefitPremiumInIDR = (double) _individualItem.get("TotalAdditionalBenefitPremiumInIDR");
							double currentSpouseTotalAdditionalBenefitPremiumInIDR = (double) _spouseItem.get("TotalAdditionalBenefitPremiumInIDR");
							_individualItem.put("TotalAdditionalBenefitPremiumInIDR", currentIndividualTotalAdditionalBenefitPremiumInIDR + currentSpouseTotalAdditionalBenefitPremiumInIDR);
							
							// TotalAdditionalBenefitPremiumAllcheckedInIDR
							double currentIndividualTotalAdditionalBenefitPremiumAllCheckedInIDR = (double) _individualItem.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
							double currentSpouseTotalAdditionalBenefitPremiumAllCheckedInIDR = (double) _spouseItem.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
							_individualItem.put("TotalAdditionalBenefitPremiumAllCheckedInIDR", currentIndividualTotalAdditionalBenefitPremiumAllCheckedInIDR + currentSpouseTotalAdditionalBenefitPremiumAllCheckedInIDR);

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
				JsonObject finalResponse = finalResponse(travellerType, travelType, currency, totalInclusiveDays,
						masterCurrency, adultTotal, childTotal, departureDisplayDate, arrivalDisplayDate, discount,
						spesificPlan, choosenPlan, commision, tax, duoPlanContainer, promoCode, paymentMethod, _managedBy);
				result.add("Calculation", finalResponse);
				return result;
			}
			// END DUO CONDITION
			// ------------------------------------------------------------
			
			// FAMILY CONDITION
			// ------------------------------------------------------------
			
			if (travellerType.equals("family")) {
				
				if(adultTotal > 1) {
					List<Map<String, Object>> spousePlanContainer = new ArrayList<>();

					List<Premi> spousePremis = new ArrayList<>(
							PremiLocalServiceUtil.findByCurrencyAndTravellerType(currency, "spouse"));

					// Jika travellerType adalah DUO dan tidak ada data premi untuk spouse, 
					// maka return empty JSON
					if (Validator.isNull(spousePremis)) {
						return result;
					}

					Set<Long> planSpouseIds = new HashSet<>();
					for (Premi spousePremi : spousePremis) {
						planSpouseIds.add(spousePremi.getPlanId());
				
					}
					Long[] planSpouseIdsArray = planSpouseIds.toArray(new Long[0]);
					
					for (Long planId : planSpouseIdsArray) {
						SmartTravelIntPlan _plan = SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(planId);
						
						// JIKA ADA CHOOSEN PLAN, TAMPILKAN SATU PLAN AJA SESUAI CHOOSEN PLAN
						if(!choosenPlan.isEmpty()) {
							if(!_plan.getNameId().equals(choosenPlan)) {
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

						for (Premi premi : spousePremis) {
							if (premi.getPlanId() == planId) {

								Benefit currentBenefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
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

									} else if (travelType.equals("annual")) {
										totalMainBenefitPremiPrice += premi.getAnnual().doubleValue();
									}

									Benefit _benefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
									mainBenefit.put(_benefit.getNameId(), premi.getBasic().doubleValue());

									HashMap<String, Object> mainBenefitItem = new HashMap<>();
									mainBenefitItem.put("Name", _benefit.getNameId());
//									mainBenefitItem.put("Amount", premi.getBasic().doubleValue());

									mainBenefitList.add(mainBenefitItem);
								}

								// ADDITIONAL BENEFITS
								if (!currentBenefitType.getNameId().equals("Jaminan Utama")
										&& !currentBenefitType.getNameEn().equals("Main Benefit")) {

									// jika ada dari pimcore
									if(!referrer.isEmpty()) {
										if (!Validator.isNull(additionalBenefitCodes)) {
											for (int i = 0; i < additionalBenefitCodes.size(); i++) {
												if (additionalBenefitCodes.get(i).getAsString().equalsIgnoreCase(currentBenefit.getExternalCode())) {
													// single atau tahunan
													if (travelType.equals("single")) {
														totalAdditionalPrice += premi.getBasic().doubleValue();

														// jika ada additional day
														if (additionalDays > 0) {
															totalAdditionalPrice += premi.getAdditional().doubleValue()
																	* additionalDays;
														}

													} else if (travelType.equals("annual")) {
														totalAdditionalPrice += premi.getAnnual().doubleValue();
													}

													HashMap<String, Object> additionalBenefitItem = new HashMap<>();
													additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
													additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
													additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());
													
													BenefitValueMapping _bvm = BenefitValueMappingLocalServiceUtil
															.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																	currentBenefitType.getBenefitTypeId(),
																	currentBenefit.getBenefitId(), premi.getPlanId());
													additionalBenefitItem.put("BenefitValueIDR", _bvm.getBenefitValue());
													additionalBenefitItem.put("BenefitValueUSD", _bvm.getBenefitValueUSD());
//													additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

													additionalBenefitList.add(additionalBenefitItem);
													
												}
											}
										}
									} else {
										
										// additional benefits dari FE liferay (bukan pimcore)
										if (!Validator.isNull(additionalBenefits)) {
											for (int i = 0; i < additionalBenefits.size(); i++) {
												if (additionalBenefits.get(i).getAsInt() == currentBenefit.getBenefitId()) {

													// single atau tahunan
													if (travelType.equals("single")) {
														totalAdditionalPrice += premi.getBasic().doubleValue();

														// jika ada additional day
														if (additionalDays > 0) {
															totalAdditionalPrice += premi.getAdditional().doubleValue()
																	* additionalDays;
														}

													} else if (travelType.equals("annual")) {
														totalAdditionalPrice += premi.getAnnual().doubleValue();
													}

													HashMap<String, Object> additionalBenefitItem = new HashMap<>();
													additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
													additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
													additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());
													
													BenefitValueMapping _bvm = BenefitValueMappingLocalServiceUtil
															.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																	currentBenefitType.getBenefitTypeId(),
																	currentBenefit.getBenefitId(), premi.getPlanId());
													additionalBenefitItem.put("BenefitValueIDR", _bvm.getBenefitValue());
													additionalBenefitItem.put("BenefitValueUSD", _bvm.getBenefitValueUSD());
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
										if(fp == 1) {
											totalAdditionalPrice += premi.getBasic().doubleValue();	
										}

										// jika ada additional day
										if (additionalDays > 0) {
											totalAllAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;
											if(fp == 1) {
												totalAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;	
											}	
										}

									} else if (travelType.equals("annual")) {
										totalAllAdditionalPrice += premi.getAnnual().doubleValue();
										if(fp == 1) {
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
								double currentSpouseTotalBasicPremium = (double) _spouseItem.get("TotalMainBenefitPremium");
								_individualItem.put("TotalMainBenefitPremium", currentIndividualTotalBasicPremium + currentSpouseTotalBasicPremium);

								// TotalAdditionalBenefitPremium
								double currentIndividualTotalAdditionalPremium = (double) _individualItem
										.get("TotalAdditionalBenefitPremium");
								double currentSpouseTotalAdditionalPremium = (double) _spouseItem
										.get("TotalAdditionalBenefitPremium");
								_individualItem.put("TotalAdditionalBenefitPremium", currentIndividualTotalAdditionalPremium + currentSpouseTotalAdditionalPremium);
								
								// TotalAdditionalBenefitPremiumAllChecked
								double currentIndividualTotalAdditionalPremiumAllChecked = (double) _individualItem
										.get("TotalAdditionalBenefitPremiumAllChecked");
								double currentSpouseTotalAdditionalPremiumAllChecked = (double) _spouseItem
										.get("TotalAdditionalBenefitPremiumAllChecked");
								_individualItem.put("TotalAdditionalBenefitPremiumAllChecked", currentIndividualTotalAdditionalPremiumAllChecked + currentSpouseTotalAdditionalPremiumAllChecked);

								// TotalAdultMainBenefitPremium
								double currentIndividualTotalAdultMainBenefitPremium = (double) _individualItem
										.get("TotalAdultMainBenefitPremium");
								double currentSpouseTotalAdultMainBenefitPremium = (double) _spouseItem
										.get("TotalAdultMainBenefitPremium");
								_individualItem.put("TotalAdultMainBenefitPremium", currentIndividualTotalAdultMainBenefitPremium + currentSpouseTotalAdultMainBenefitPremium);
								
								// TotalAdultAdditionalBenefitPremium
								double currentIndividualTotalAdultAdditionalBenefitPremium = (double) _individualItem
										.get("TotalAdultAdditionalBenefitPremium");
								double currentSpouseTotalAdultAdditionalBenefitPremium = (double) _spouseItem
										.get("TotalAdultAdditionalBenefitPremium");
								_individualItem.put("TotalAdultAdditionalBenefitPremium",
										currentIndividualTotalAdultAdditionalBenefitPremium + currentSpouseTotalAdultAdditionalBenefitPremium);
								
								// TotalChildMainBenefitPremium tidak perlu karena ini DUO
								
								// TotalMainBenefitPremiumInIDR
								double currentIndividualTotalMainBenefitPremiumInIDR = (double) _individualItem.get("TotalMainBenefitPremiumInIDR");
								double currentSpouseTotalMainBenefitPremiumInIDR = (double) _spouseItem.get("TotalMainBenefitPremiumInIDR");
								_individualItem.put("TotalMainBenefitPremiumInIDR", currentIndividualTotalMainBenefitPremiumInIDR + currentSpouseTotalMainBenefitPremiumInIDR);
								
								// TotalAdditionalBenefitPremiumInIDR
								double currentIndividualTotalAdditionalBenefitPremiumInIDR = (double) _individualItem.get("TotalAdditionalBenefitPremiumInIDR");
								double currentSpouseTotalAdditionalBenefitPremiumInIDR = (double) _spouseItem.get("TotalAdditionalBenefitPremiumInIDR");
								_individualItem.put("TotalAdditionalBenefitPremiumInIDR", currentIndividualTotalAdditionalBenefitPremiumInIDR + currentSpouseTotalAdditionalBenefitPremiumInIDR);
								
								// TotalAdditionalBenefitPremiumAllCheckedInIDR
								double currentIndividualTotalAdditionalBenefitPremiumAllCheckedInIDR = (double) _individualItem.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
								double currentSpouseTotalAdditionalBenefitPremiumAllCheckedInIDR = (double) _spouseItem.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
								_individualItem.put("TotalAdditionalBenefitPremiumAllCheckedInIDR", currentIndividualTotalAdditionalBenefitPremiumAllCheckedInIDR + currentSpouseTotalAdditionalBenefitPremiumAllCheckedInIDR);

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
				List<Premi> childrenPremis = new ArrayList<>(PremiLocalServiceUtil.findByCurrencyAndTravellerType(currency, "children"));
				if (Validator.isNull(childrenPremis)) {
					return result;
				}
				
				Set<Long> planChildrenIds = new HashSet<>();
				for (Premi childrenPremi : childrenPremis) {
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
					
					for (Premi premi : childrenPremis) {
						if (premi.getPlanId() == planId) {

							Benefit currentBenefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
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

								} else if (travelType.equals("annual")) {
									totalMainBenefitPremiPrice += premi.getAnnual().doubleValue();
								}

								Benefit _benefit = BenefitLocalServiceUtil.getBenefit(premi.getBenefitId());
								mainBenefit.put(_benefit.getNameId(), premi.getBasic().doubleValue() * childTotal);

								HashMap<String, Object> mainBenefitItem = new HashMap<>();
								mainBenefitItem.put("Name", _benefit.getNameId());
								mainBenefitItem.put("Amount", premi.getBasic().doubleValue() * childTotal);

								mainBenefitList.add(mainBenefitItem);
							}

							// ADDITIONAL BENEFITS
							if (!currentBenefitType.getNameId().equals("Jaminan Utama")
									&& !currentBenefitType.getNameEn().equals("Main Benefit")) {

								// jika ada dari pimcore
								if(!referrer.isEmpty()) {
									if (!Validator.isNull(additionalBenefitCodes)) {
										for (int i = 0; i < additionalBenefitCodes.size(); i++) {
											if (additionalBenefitCodes.get(i).getAsString().equalsIgnoreCase(currentBenefit.getExternalCode())) {
												// single atau tahunan
												if (travelType.equals("single")) {
													totalAdditionalPrice += premi.getBasic().doubleValue();

													// jika ada additional day
													if (additionalDays > 0) {
														totalAdditionalPrice += premi.getAdditional().doubleValue()
																* additionalDays;
													}

												} else if (travelType.equals("annual")) {
													totalAdditionalPrice += premi.getAnnual().doubleValue();
												}

												HashMap<String, Object> additionalBenefitItem = new HashMap<>();
												additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
												additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
												additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());
												
												BenefitValueMapping _bvm = BenefitValueMappingLocalServiceUtil
														.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																currentBenefitType.getBenefitTypeId(),
																currentBenefit.getBenefitId(), premi.getPlanId());
												additionalBenefitItem.put("BenefitValueIDR", _bvm.getBenefitValue());
												additionalBenefitItem.put("BenefitValueUSD", _bvm.getBenefitValueUSD());
//												additionalBenefitItem.put("Amount", premi.getBasic().doubleValue());

												additionalBenefitList.add(additionalBenefitItem);
												
											}
										}
									}
								} else {
									
									// additional benefits dari FE liferay (bukan pimcore)
									if (!Validator.isNull(additionalBenefits)) {
										for (int i = 0; i < additionalBenefits.size(); i++) {
											if (additionalBenefits.get(i).getAsInt() == currentBenefit.getBenefitId()) {

												// single atau tahunan
												if (travelType.equals("single")) {
													totalAdditionalPrice += premi.getBasic().doubleValue();

													// jika ada additional day
													if (additionalDays > 0) {
														totalAdditionalPrice += premi.getAdditional().doubleValue()
																* additionalDays;
													}

												} else if (travelType.equals("annual")) {
													totalAdditionalPrice += premi.getAnnual().doubleValue();
												}

												HashMap<String, Object> additionalBenefitItem = new HashMap<>();
												additionalBenefitItem.put("BenefitCode", currentBenefit.getExternalCode());
												additionalBenefitItem.put("Benefit Name", currentBenefit.getNameId());
												additionalBenefitItem.put("Benefit Type", currentBenefitType.getNameId());
												
												BenefitValueMapping _bvm = BenefitValueMappingLocalServiceUtil
														.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
																currentBenefitType.getBenefitTypeId(),
																currentBenefit.getBenefitId(), premi.getPlanId());
												additionalBenefitItem.put("BenefitValueIDR", _bvm.getBenefitValue());
												additionalBenefitItem.put("BenefitValueUSD", _bvm.getBenefitValueUSD());
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
									if(fp == 1) {
										totalAdditionalPrice += premi.getBasic().doubleValue();
									}

									// jika ada additional day
									if (additionalDays > 0) {
										totalAllAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;
										if(fp == 1) {
											totalAdditionalPrice += premi.getAdditional().doubleValue() * additionalDays;
										}
									}

								} else if (travelType.equals("annual")) {
									totalAllAdditionalPrice += premi.getAnnual().doubleValue();
									if(fp == 1) {
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
					itemData.put("TotalAdditionalBenefitPremiumAllCheckedInIDR", totalAllAdditionalPriceUSDInIDR * childTotal);

					childrenPlanContainer.add(itemData);
					
				}
			
				// CALCULATE PREMI (INDIVIDU YANG SUDAH DIJUMLAH DENGAN SPOUSE) + CHILDREN
				List<Map<String, Object>> familyPlanContainer = new ArrayList<>();
				
				//individualPlanContainer disini adalah individu yang sudah dijumlah dengan spouse
				for (Map<String, Object> _individualItem : individualPlanContainer) {
					String currentIndividualPlanName = (String) _individualItem.get("PlanName");
//					
					for (Map<String, Object> _childrenItem : childrenPlanContainer) {
						String currentChildrenPlanName = (String) _childrenItem.get("PlanName");

						if (currentChildrenPlanName.equals(currentIndividualPlanName)) {

							double currentIndividualTotalBasicPremium = (double) _individualItem
									.get("TotalMainBenefitPremium");
							double currentChildrenTotalBasicPremium = (double) _childrenItem.get("TotalMainBenefitPremium");
							currentIndividualTotalBasicPremium = currentIndividualTotalBasicPremium
									+ currentChildrenTotalBasicPremium;
							_individualItem.put("TotalMainBenefitPremium", currentIndividualTotalBasicPremium);
							
							// IN IDR
							double currentIndividualTotalBasicPremiumInIDR = (double) _individualItem
									.get("TotalMainBenefitPremiumInIDR");
							double currentChildrenTotalBasicPremiumInIDR = (double) _childrenItem.get("TotalMainBenefitPremiumInIDR");
							currentIndividualTotalBasicPremiumInIDR = currentIndividualTotalBasicPremiumInIDR
									+ currentChildrenTotalBasicPremiumInIDR;
							_individualItem.put("TotalMainBenefitPremiumInIDR", currentIndividualTotalBasicPremiumInIDR);
							
							// -----------------------
							
							double currentIndividualTotalAdditionalPremium = (double) _individualItem
									.get("TotalAdditionalBenefitPremium");
							double currentChildrenTotalAdditionalPremium = (double) _childrenItem
									.get("TotalAdditionalBenefitPremium");
							currentIndividualTotalAdditionalPremium = currentIndividualTotalAdditionalPremium
									+ currentChildrenTotalAdditionalPremium;
							_individualItem.put("TotalAdditionalBenefitPremium", currentIndividualTotalAdditionalPremium);
							
							// IN IDR
							double currentIndividualTotalAdditionalPremiumInIDR = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumInIDR");
							double currentChildrenTotalAdditionalPremiumInIDR = (double) _childrenItem
									.get("TotalAdditionalBenefitPremiumInIDR");
							currentIndividualTotalAdditionalPremiumInIDR = currentIndividualTotalAdditionalPremiumInIDR
									+ currentChildrenTotalAdditionalPremiumInIDR;
							_individualItem.put("TotalAdditionalBenefitPremiumInIDR", currentIndividualTotalAdditionalPremiumInIDR);
							
							// -----------------------
							
							double currentIndividualTotalAdditionalPremiumAllChecked = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumAllChecked");
							double currentChildrenTotalAdditionalPremiumAllChecked = (double) _childrenItem
									.get("TotalAdditionalBenefitPremiumAllChecked");
							currentIndividualTotalAdditionalPremiumAllChecked = currentIndividualTotalAdditionalPremiumAllChecked
									+ currentChildrenTotalAdditionalPremiumAllChecked;
							_individualItem.put("TotalAdditionalBenefitPremiumAllChecked", currentIndividualTotalAdditionalPremiumAllChecked);
							
							// IN IDR
							double currentIndividualTotalAdditionalPremiumAllCheckedInIDR = (double) _individualItem
									.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
							double currentChildrenTotalAdditionalPremiumAllCheckedInIDR = (double) _childrenItem
									.get("TotalAdditionalBenefitPremiumAllCheckedInIDR");
							currentIndividualTotalAdditionalPremiumAllCheckedInIDR = currentIndividualTotalAdditionalPremiumAllCheckedInIDR
									+ currentChildrenTotalAdditionalPremiumAllCheckedInIDR;
							_individualItem.put("TotalAdditionalBenefitPremiumAllCheckedInIDR", currentIndividualTotalAdditionalPremiumAllCheckedInIDR);
							
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
				JsonObject finalResponse = finalResponse(travellerType, travelType, currency, totalInclusiveDays,
						masterCurrency, adultTotal, childTotal, departureDisplayDate, arrivalDisplayDate, discount,
						spesificPlan, choosenPlan, commision, tax, familyPlanContainer, promoCode, paymentMethod, _managedBy);
				result.add("Calculation", finalResponse);
				return result;
			}
			// END FAMILY CONDITION
			// -----------------------------------------------------------
			
			// Final response for Individual Only
			JsonObject finalResponse = finalResponse(travellerType, travelType, currency, totalInclusiveDays,
					masterCurrency, adultTotal, childTotal, departureDisplayDate, arrivalDisplayDate, discount,
					spesificPlan, choosenPlan, commision, tax, individualPlanContainer, promoCode, paymentMethod, _managedBy);
			result.add("Calculation", finalResponse);
			return result;
		} catch (Exception e) {
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
		helpers.setPropService(propService);
		JsonObject response = new JsonObject();

		JsonObject params = new Gson().fromJson(request, JsonObject.class);
		int fp = params.get("fp").getAsInt(); // full package
		String promoCode = params.get("PromoCode").getAsString();
		
		String  _currency = params.get("Currency").getAsString();
		String _travellerType = params.get("TravellerType").getAsString();
		String startDate = params.get("DepartureDate").getAsString();
		String expiredDate = params.get("ArrivalDate").getAsString();
		String _traveltype = params.get("TravelType").getAsString();
		String _adultTotal = params.get("AdultTotal").getAsString();
		
		if(!promoCode.isEmpty()) {
			
			String _businessModel = params.get("BusinessModel").getAsString();
			String _managedBy = params.get("ManagedBy").getAsString();
			String _managedById = params.get("ManagedById").getAsString();
			
			String __plan = "";
			String _spesificPlan = params.get("SpesificPlan").getAsString();
			String _choosenPlan = params.get("ChoosenPlan").getAsString();
			String _roleUser = params.get("Role").getAsString().isEmpty() ? params.get("Role").getAsString() : "";
			
			if(!_spesificPlan.isEmpty()) {
				__plan = _spesificPlan;
			} else if(!_choosenPlan.isEmpty()) {
				__plan = _choosenPlan;
			}
			
			if(!startDate.isEmpty() && !expiredDate.isEmpty() && !__plan.isEmpty() && !_travellerType.isEmpty()) {
				try {
					double promoCodeDiscount = 0.0;
					
					HashMap<String, Object> mainBody = new HashMap<String, Object>();
					mainBody.put("PromoCode", promoCode.toUpperCase());
					mainBody.put("ProductCode", "IT6");
					
					String _channel = "DIRECT";
					if(_businessModel.equalsIgnoreCase("b2b") || _businessModel.equalsIgnoreCase("b2b2c")) {
						_channel = _roleUser;
					}
					mainBody.put("Channel", _channel);
					
					String _encryptedManagedBy = "";
					if(!_managedBy.isEmpty()) { 
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
					if(_travellerType.equalsIgnoreCase("individual")) {
						_travellerType = "Sendiri";
					} else if(_travellerType.equalsIgnoreCase("duo")) {
						_travellerType = "Duo";
					} else if(_travellerType.equalsIgnoreCase("family")) {
						_travellerType = "Keluarga";
					}
					mainBody.put("TravellerType", _travellerType);
					
					Gson gson = new Gson();
					String payload = "";
					payload = gson.toJson(mainBody);
					
					JsonObject _callAPI = null;
					try {
						_callAPI = callAPI(payload, helpers.getApiCheckPromoCode());
						
						if(_callAPI.get("Status").getAsInt() > 0) {
							promoCodeDiscount = _callAPI.get("Data").getAsJsonObject().get("Discount").getAsDouble();
							double _commisionFromResponsePromoCode = _callAPI.get("Data").getAsJsonObject().get("Agent").getAsJsonObject().get("Commission").getAsDouble();
							params.addProperty("Commission", _commisionFromResponsePromoCode);
							
						} else {
							JsonObject _responsePromoCode = new JsonObject();
							_responsePromoCode.addProperty("Status", 0);
							_responsePromoCode.addProperty("Message", _callAPI.get("Message").getAsString());
							_responsePromoCode.addProperty("Data", "");
							_responsePromoCode.addProperty("PromoCodeResponse", true);

							return _responsePromoCode.toString();
						}
					} catch (Exception e) {
						_log.debug("[CALL API][PROMOCODE][EXCEPTION]: " + e.getMessage());
						return errorMessage("Calculate Failed").toString();
					}
					
					params.addProperty("Discount", promoCodeDiscount);
					
				} catch (Exception e) {
					_log.debug("[CALCULATE][PROMOCODE][EXCEPTION]: " + e.getMessage());
					return errorMessage(e.getMessage()).toString();
				}
			}			
		}
		
		String choosenPlan = params.get("SpesificPlan").getAsString();
		
		try {
				
			if (_currency.isEmpty() || _travellerType.isEmpty() || startDate.isEmpty() || expiredDate.isEmpty()
					|| _traveltype.isEmpty() || _adultTotal.isEmpty()) {
				throw new Exception("Invalid Param");
			}
			
			JsonObject _calculatePremi = null;
			if(!Validator.isBlank(choosenPlan)) {
				_calculatePremi = calculatePremi(params, true);
			} else {
				_calculatePremi = calculatePremi(params, false);
			}
			
//			_logs.info("CALCULATE PREMI][RESULT]["+currentNumericTimeStamp+"]: " + _calculatePremi);
			
			response.addProperty("Status", 1);
			response.addProperty("Message", "Data is ready");
			response.add("Data", _calculatePremi);
		} catch (Exception e) {
			response.addProperty("Status", 0);
			response.addProperty("Message", e.getMessage());
			response.addProperty("Data", "");
		}

		return response.toString();
	}
	
	
	// PURCHASE DETAILS
	@POST
	@Path("/pd")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String purchaseDetail(String request, @Context HttpServletRequest httpServletRequest)
			throws JSONException, IOException {

		/**calc
		 * PD01: something wrong when init variable
		 * PD02: XSS validation is not passed
		 * PD03: token limiter param is empty
		 * PD04: token limiter is null or is not valid
		 * PD05: error when process XSS validation and agent token limiter
		 * PD06: currency is empty / not exist in parameter
		 * PD07: product configuration is null and product code is not found
		 * PD08: departure date param is empty
		 * PD09: arrival date param is empty
		 */
		
		helpers.setPropService(propService);

		// init variables
		JsonObject params = null; // Incoming data payload from request
		JsonObject _response = new JsonObject(); // JSON output API
		HashMap<String, Object> _data = null; // data ini untuk di add ke localservice leads

		ProductConfiguration productConfiguration = null;
		ServiceContext serviceContext = null;
		long userId = 0L;
		boolean isB2B = false;

		boolean quotation = false;
		String tokenLimiter = "";
		long agentTokenLimiterId = 0;

		long LeadsId = 0;
		String leadsType = "kyc";
		Leads _leads = null;

		// initial variable assignment
		boolean modifyOrReorder = false;
		try {
			params = new Gson().fromJson(request, JsonObject.class);
			
			modifyOrReorder = params.get("ModifyOrRepeatOrderStat").getAsBoolean();
			quotation = !params.get("Quotation").getAsString().isEmpty() && params.get("Quotation").getAsString().equals("1") ? true
					: false;
			productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6");
			serviceContext = ServiceContextFactory.getInstance(SmartTravelApplication.class.getName(), httpServletRequest);
			userId = serviceContext.getGuestOrUserId();
			_data = new HashMap<String, Object>();
		} catch (Exception e) {
			return errorMessage("Something wrong. Please try again - PD01").toString();
		}

		// check XSS and token limiter
		try {
			if (quotation) {
				Map<String, Object> payloadMap = convertJsonToMap(request);
				try {
					// XSSValidator.validatePayload(payloadMap);
				} catch (IllegalArgumentException e) {
					return errorMessage("Data is not valid - PD02").toString();
				}

				tokenLimiter = params.get("Tlmtr").getAsString();
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
		String _currency = params.get("Currency").getAsString();
		if (!_currency.isEmpty()) {
			if (_currency.equals("idr")) {
				_currency = "IDR";
			} else {
				_currency = "USD";
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
		String departureDate = params.get("DepartureDate").getAsString().isEmpty() ? params.get("DepartureDate").getAsString() : null;
		if (departureDate != null && !departureDate.isEmpty()) {
			_data.put("PolicyStartDate", customFormatDate(departureDate));
		} else {
			return errorMessage("Departure date is empty - PD08").toString();
		}
		
		// Check arrival date param
		String arrivalDate = params.get("ArrivalDate").getAsString().isEmpty() ? params.get("DepartureDate").getAsString() : null;
		if (arrivalDate != null && !arrivalDate.isEmpty()) {
			_data.put("PolicyEndDate", customFormatDate(arrivalDate));
		} else {
			return errorMessage("Arrival date is empty - PD09").toString();
		}
		
		// Get value from quotation form
		if (quotation) {
			leadsType = "quotation";
			_data.put("Name", params.get("Name").getAsString());
			_data.put("Email", params.get("Email").getAsString().trim());
		}

		// Check param token
		// if exist, then this token will be used as param to edit leads
		if (!params.get("Token").getAsString().isEmpty()) {
			_leads = LeadsLocalServiceUtil.findByToken(params.get("Token").getAsString());

			if (_leads != null) {
				LeadsId = _leads.getLeadsId();
				_data.put("Token", params.get("Token").getAsString());
			}
		}
		
		String _managedBy = params.get("ManagedBy").getAsString();
		String _managedById = params.get("ManagedById").getAsString();
		String _role = params.get("Role").getAsString();
		String _businessModel = params.get("BusinessModel").getAsString();
		String _channel = "DIRECT";
		
		if(_businessModel.equalsIgnoreCase("b2b") || _businessModel.equalsIgnoreCase("b2b2c")) {
			_channel = _role;
		}
		
		if(_businessModel.equalsIgnoreCase("b2b")) {
			isB2B = true;
		}
		
		// Check promocode param
		String promoCode = params.get("PromoCode").getAsString();
		
		_data.put("Currency", _currency);
		_data.put("LeadsType", leadsType);
		_data.put("BussinesModel", _businessModel);
		_data.put("Channel", _channel);
		_data.put("ManagedBy", _managedBy);
		_data.put("ProductCode", productCode);
		_data.put("Active", 1);
		_data.put("PromoCode", promoCode);
		
		// Jika ada promocode, ambil nilai diskon ke API Promocode Pimcore
		if(!promoCode.isEmpty()) {
			try {
				
				double promoCodeDiscount = 0;
				HashMap<String, Object> mainBody = new HashMap<String, Object>();
				
				String __businessModel = params.get("BusinessModel").getAsString();
				String __channel = "DIRECT";
				if(__businessModel.equalsIgnoreCase("b2b") || __businessModel.equalsIgnoreCase("b2b2c")) {
					__channel = _role;
				}
				
				String __managedBy = params.get("ManagedBy").getAsString();
				String _encryptedManagedBy = "";
				if(!_managedBy.isEmpty()) {
					_encryptedManagedBy = __managedBy;
				}
				
				String startDate = params.get("DepartureDate").getAsString();
				String expiredDate = params.get("ArrivalDate").getAsString();
				
		        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        
		        LocalDate _startdate = LocalDate.parse(startDate, inputFormatter);
		        String _startdateFormatted = _startdate.format(outputFormatter);
		        
		        LocalDate _expiredDate = LocalDate.parse(expiredDate, inputFormatter);
		        String _expiredDateFormatted = _expiredDate.format(outputFormatter);
				
				String _choosenPlan = params.get("ChoosenPlan").getAsString();
				
				// traveller type
				String _travellerType = params.get("TravellerType").getAsString();
				if(_travellerType.equalsIgnoreCase("individual")) {
					_travellerType = "Sendiri";
				} else if(_travellerType.equalsIgnoreCase("duo")) {
					_travellerType = "Duo";
				} else if(_travellerType.equalsIgnoreCase("family")) {
					_travellerType = "Keluarga";
				}
				
				mainBody.put("PromoCode", promoCode.toUpperCase());
				mainBody.put("ProductCode", "IT6");
				mainBody.put("Channel", _channel);
				mainBody.put("ManagedBy", _encryptedManagedBy);
				mainBody.put("ManagedById", _managedById);
				mainBody.put("leadsStartDate", _startdateFormatted);
				mainBody.put("leadsExpiredDate", _expiredDateFormatted);
				mainBody.put("Plan", _choosenPlan);
				mainBody.put("TravellerType", _travellerType);
				
				Gson gson = new Gson();
				String payload = "";
				payload = gson.toJson(mainBody);
				_logs.info("[PURCHASE_DETAIL][PROMOCODE][PAYLOAD API PROMOCODE]: " + payload);
				
				JsonObject _callAPI = null;
				try {
					_callAPI = callAPI(payload, helpers.getApiCheckPromoCode());
					
					if(_callAPI.get("Status").getAsInt() > 0) {
						promoCodeDiscount = _callAPI.get("Data").getAsJsonObject().get("Discount").getAsDouble();
						
					} else {
						return errorMessage(_callAPI.get("Message").getAsString()).toString();	
					}
				} catch (Exception e) {
					_log.debug("[PURCHASE_DETAIL][PROMOCODE][EXCEPTION]: " + e.getMessage());
					return errorMessage("Calculate Failed").toString();
				}
				
				params.addProperty("Discount", promoCodeDiscount);
			} catch (Exception e) {
				_logs.info("[PURCHASE_DETAIL][PROMOCODE][EXCEPTION]: " + e.getMessage());
				return errorMessage(e.getMessage()).toString();
			}
		}
		// END Jika ada promocode, ambil nilai diskon ke API Promocode Pimcore
		
		// Calculate premi di purchase detail
		// -------------------------------------------
		// tambahkan property SpesificPlan ke params
		// supaya hasil yang ditambahkan ke DB
		// sama dengan hasil yang keluar pada response calculate saat dipanggil pimcore
		String _choosenPlan = params.get("ChoosenPlan").getAsString();
		params.addProperty("SpesificPlan", _choosenPlan);
		
		
		double basicPremium = 0, netPremium = 0, policyCost = 0, stampDuty = 0, discount = 0;
		double discountedPremium = 0;
		double discountAmount = 0;
		String currency = "IDR";
		
		JsonObject calculatePremiResult = null;
		try {
			if(!Validator.isBlank(_choosenPlan)) {
				calculatePremiResult = calculatePremi(params, true);
			} else {
				calculatePremiResult = calculatePremi(params, false);
			}
		} catch (Exception e) {
			return errorMessage("Calculate Premi Failed: " + e.getMessage()).toString();
		}
		
		JsonObject detail = calculatePremiResult.get("Calculation").getAsJsonObject();
		JsonArray calculationArray = detail.get("AvailablePlans").getAsJsonArray();
		
		currency = detail.get("Currency").getAsString();

		// Net Premi
		if (calculatePremiResult.size() > 0) {
			_data.put("PolicyCost", detail.get("PolicyCost").getAsDouble());
			_data.put("StampDuty", detail.get("Stamp").getAsDouble());
			_data.put("Premium", detail.get("Premium").getAsDouble());
			_data.put("NetPremium", detail.get("NetPremium").getAsDouble());
			_data.put("Discount", detail.get("Discount").getAsDouble());
			_data.put("DiscountAmount", detail.get("DiscountAmount").getAsDouble());
		}
		
		// jika modify or reorder, promocode di leads dikosongkan
		if(modifyOrReorder) {
			if(!_leads.getPromoCode().isEmpty() && promoCode.isEmpty()) {
				_data.put("PromoCode", "");
			}
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("DATA");
		System.out.println(_data);
		System.out.println("---------------------------------------------------");

		// Save leads
		Leads saveLeads = LeadsLocalServiceUtil.updateLeadsData(userId, quotation ? (long) 0 : LeadsId, _data,
				serviceContext);

		if (saveLeads == null) {
			return errorMessage("Failed to save leads").toString();
		}
		
		// Save detail international travel
		// ---------------------------------
		DetailInternationalTravel saveDetail = null;
		try {
			HashMap<String, Object> _dataDetail = new HashMap<String, Object>();
			_dataDetail.put("LeadsId", saveLeads.getLeadsId());
			_dataDetail.put("TravelType", params.get("TravelType").getAsString());
//			_dataDetail.put("Destination", params.get("Destination").getAsString());
			_dataDetail.put("Destination", "Worldwide");
			_dataDetail.put("PackageType", params.get("ChoosenPlan").getAsString());
			_dataDetail.put("TravellerType", params.get("TravellerType").getAsString());
			_dataDetail.put("DepartureDate", customFormatDateTime(departureDate));
			_dataDetail.put("ArrivalDate", customFormatDateTime(arrivalDate));
			_dataDetail.put("Adult", params.get("AdultTotal").getAsString());
			_dataDetail.put("Child", params.get("ChildTotal").getAsString());
			_dataDetail.put("ListBenefitId", params.get("AdditionalBenefits").getAsString());
			
			long detailId = 0;
			if(LeadsId > 0) {
				DetailInternationalTravel _detailIT = DetailInternationalTravelLocalServiceUtil.findByLeadsId(LeadsId);
				if(_detailIT != null) {
					detailId = _detailIT.getDetailId();
				}
			}
			
			saveDetail = DetailInternationalTravelLocalServiceUtil.addDetailData(userId, detailId, _dataDetail, serviceContext);
			
			if(Validator.isNull(saveDetail)) {
				throw new Exception("FAILED TO SAVE DETAIL INTERNATIONAL TRAVEL");	
			}
			
		} catch (Exception e) {
			// Failed to create detail Smart Travel International
			_logs.info("[KYC][DETAIL][LEADS ID:"+saveLeads.getLeadsId()+"]: " + e.getMessage());
			return errorMessage("FAILED KYC #14 - Please try again").toString();
		}
		// END Save detail international travel
		// ---------------------------------
		
		// Send quotation to Pimcore
		if(quotation) {
			try {
				ProductConfiguration _productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6");
				HashMap<String, Object> mainBody = new HashMap<String, Object>();
				mainBody.put("LiferayId", String.valueOf(saveLeads.getLeadsId()));
				mainBody.put("ManagedBy", saveLeads.getManagedBy());
				mainBody.put("ManagedById", _managedById);
				mainBody.put("PdCode", _productConfiguration.getProductCode());
				mainBody.put("Channel", saveLeads.getChannel());
				mainBody.put("Currency", saveLeads.getCurrency());
				

				double _premium = (saveLeads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(saveLeads.getPremium()) : Math.round(saveLeads.getPremium() * 100.0) / 100.0;
				double _netpremium = (saveLeads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(saveLeads.getNetPremium()) : Math.round(saveLeads.getNetPremium() * 100.0) / 100.0;
				mainBody.put("StampDuty", saveLeads.getStampDuty());
				mainBody.put("Premium", _premium);
				mainBody.put("NetPremium", _netpremium);
				
				mainBody.put("PromoCode", saveLeads.getPromoCode());
				mainBody.put("Discount", saveLeads.getDiscount());
				mainBody.put("DiscountAmount", (saveLeads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(saveLeads.getDiscountAmount()) : Math.round(saveLeads.getDiscountAmount() * 100.0) / 100.0);
				
				mainBody.put("Commission", String.valueOf(saveLeads.getCommission()));
				mainBody.put("BussinesModel", saveLeads.getBussinesModel());
				
				HashMap<String, Object> detailBody = new HashMap<String, Object>();
				detailBody.put("Destination", saveDetail.getDestination());
				detailBody.put("DepartureDate", _customFormatDate(saveDetail.getDepartureDate()));
				detailBody.put("ArrivalDate",  _customFormatDate(saveDetail.getArrivalDate()));
				detailBody.put("TravelType", saveDetail.getTravelType());
				detailBody.put("TravellerType", saveDetail.getTravellerType());
				detailBody.put("PackageType", saveDetail.getPackageType());
				detailBody.put("TotalAdult", String.valueOf(saveDetail.getAdult()));
				detailBody.put("TotalChildren", String.valueOf(saveDetail.getChild()));
				
				mainBody.put("Detail", detailBody);
				
				String listBenefit = saveDetail.getListBenefitId();
				List<String> externalCodeArray = new ArrayList<String>();
				if(listBenefit == null || listBenefit.isEmpty() || listBenefit.equalsIgnoreCase("[]")) {

				} else {
					String[] benefitArray = listBenefit.replace("[", "").replace("]", "").split(",");
					long[] longArray = Arrays.stream(benefitArray)
		                      .map(String::trim) // Trim spaces around elements
		                      .filter(s -> !s.isEmpty()) // Ensure no empty elements
		                      .mapToLong(Long::parseLong) // Convert to long
		                      .toArray();
					
				    for (long value : longArray) {
				    	Benefit benefit = BenefitLocalServiceUtil.getBenefit(value);
				    	externalCodeArray.add(benefit.getExternalCode());
				    }
				}
				
				mainBody.put("AdditionalBenefit", externalCodeArray);
				
				HashMap<String, Object> policyHolderBody = new HashMap<String, Object>();
				policyHolderBody.put("Name", saveLeads.getName());
				policyHolderBody.put("Email", saveLeads.getEmail());
				
				mainBody.put("PolicyHolder", policyHolderBody);
				
				mainBody.put("QuotationType", "simple");
				
				Gson gson = new Gson();
				String payload = "";
				payload = gson.toJson(mainBody);
				
				_logs.info("[PURCHASE_DETAIL][QUOTATION][PAYLOAD FOR PIMCORE]: " + payload);
				
				JsonObject _callAPI = null;
				try {
					_callAPI = callAPI(payload, helpers.getApiCreateQuote());	
				} catch (Exception e) {
					System.out.println(e);
//					_log.debug("[CALL API][KYC][EXCEPTION]: " + e.getMessage());
					return errorMessage("Failed KYC #10").toString();
				}
				
				if(_callAPI.get("Status").getAsInt() == 0) {
					return errorMessage(_callAPI.get("Message").getAsString()).toString();
				} else {
					
					// set token limiter to invalid
					AgentTokenLimiterLocalServiceUtil.setToInvalid(agentTokenLimiterId);
					
					_response.addProperty("Status", 1);
					_response.addProperty("Data", helpers.getPimcoreHost() + "/dashboard/leads/online");
					_response.addProperty("Message", "Kirim Penawaran Berhasil");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			if (saveLeads.getLeadsId() > 0) {
				JsonObject responseData = new JsonObject();
				responseData.addProperty("Token", saveLeads.getToken());
				if (quotation) {
					responseData.addProperty("LeadsId", saveLeads.getLeadsId());
				}

				_response.addProperty("Status", 1);
				_response.add("Data", responseData);
			} else {
				return errorMessage("Failed KYC #12").toString();
			}
		}

		return _response.toString();
	}

//	@POST
//	@Path("/kyc")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public String kyc(String request, @Context HttpServletRequest httpServletRequest)
//			throws JSONException, IOException {
//		
//		/**
//		 * Failed KYC Error description: #09 - Failed to process quotation #10 - CallAPI
//		 * Failed #12 - Failed when get LeadsId #13 - Unknown #14 - Failed to save
//		 * detail international
//		 */
//
//		JSONObject params = null; // Incoming data payload from request
//		JSONObject _response = jsonFactoryService.createJSONObject(); // JSON output API
//		JSONObject _data = null; // data ini untuk di add ke localservice leads
//
//		ProductConfiguration productConfiguration = null;
//		ServiceContext serviceContext = null;
//		long userId = 0L;
//		boolean isB2B = false;
//
//		boolean quotation = false;
//		String tokenLimiter = "";
//		long agentTokenLimiterId = 0;
//
//		long LeadsId = 0;
//		String leadsType = "kyc";
//		Leads _leads = null;
//		
//		try {
//			params = jsonFactoryService.createJSONObject(request);
//			quotation = !params.getString("Quotation").isEmpty() && params.getString("Quotation").equals("1") ? true
//					: false;
//
//			if (quotation) {
//				Map<String, Object> payloadMap = convertJsonToMap(request);
//				try {
//					// XSSValidator.validatePayload(payloadMap);
//				} catch (IllegalArgumentException e) {
//					_logs.info(e.getMessage());
//					return errorMessage("Data is not valid").toString();
//				}
//
//				// process token limiter
//				tokenLimiter = params.getString("Tlmtr");
//				_logs.info("[KYC][TOKEN LIMITER]: " + tokenLimiter);
//
//				if (tokenLimiter.isEmpty()) {
//
//					return errorMessage("Failed to process quotation").toString();
//
//				} else {
//
//					AgentTokenLimiter atl = AgentTokenLimiterLocalServiceUtil.getAgentTokenLimiterByToken(tokenLimiter);
//					agentTokenLimiterId = atl.getAgentTokenLimiterId();
//					_logs.info("[KYC][AGENT TOKEN LIMITER OBJECT]: " + atl);
//					if (atl == null || atl.getIsValid() < 1) {
//						return errorMessage("Failed to process quotation").toString();
//					}
//
//				}
//			}
//		} catch (Exception e) {
//			return errorMessage("Failed to process quotation - #09").toString();
//		}
//
//		try {
//			productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode("IT6");
//			serviceContext = ServiceContextFactory.getInstance(Leads.class.getName(), httpServletRequest);
//			userId = serviceContext.getGuestOrUserId();
//			_data = jsonFactoryService.createJSONObject();
//
//			if (quotation) {
//				leadsType = "quotation";
//				_data.put("Name", params.getString("Name"));
//				_data.put("Email", params.getString("Email"));
//			}
//
//			// GET leads, jika ada param Token di request
//			if (!params.getString("Token").isEmpty()) {
//				_leads = LeadsLocalServiceUtil.findByToken(params.getString("Token"));
//
//				if (_leads != null) {
//					LeadsId = _leads.getLeadsId();
//				}
//			}
//
//			// GET mypage user jika LeadsId bukan 0 (ada token yang dikirim di param
//			// request)
////			if (LeadsId > 0) {
////				if (_leads.getMypageUserId() > 0) {
////					_mypageUser = MypageUserLocalServiceUtil.getMypageUser(_leads.getMypageUserId());
////
////				}
////			}
//
//			if (LeadsId > 0) {
//				_data.put("Token", params.getString("Token"));
//			}
//			
//			String _managedBy = params.getString("ManagedBy");
//			String _businessModel = params.getString("BusinessModel");;
//			String _channel = "DIRECT";
//			
//			if(_businessModel.equalsIgnoreCase("b2b") || _businessModel.equalsIgnoreCase("b2b2c")) {
//				_channel = "Agent";
//			}
//			
//			if(_businessModel.equalsIgnoreCase("b2b")) {
//				isB2B = true;
//			}
//
//			_data.put("LeadsType", leadsType);
//			_data.put("BussinesModel", _businessModel);
//			_data.put("Channel", _channel);
//			_data.put("ManagedBy", _managedBy);
//
//			// Currency
//			String _currency = params.getString("Currency");
//			if (!_currency.isEmpty()) {
//				if (_currency.equals("idr")) {
//					_currency = "IDR";
//				} else {
//					_currency = "USD";
//				}
//			} else {
//				return errorMessage("Currency is empty").toString();
//			}
//
//			_data.put("Currency", _currency);
//
//			// Product Code
//			String productCode = "";
//			if (!Validator.isNull(productConfiguration)) {
//				productCode = productConfiguration.getProductCode();
//			} else {
//				return errorMessage("Product code is not found").toString();
//			}
//
//			_data.put("ProductCode", productCode);
//			_data.put("Active", 1);
//
//			// Departure and Arrival Date
//			String departureDate = params.getString("DepartureDate", null);
//			if (departureDate != null && !departureDate.isEmpty()) {
//				_data.put("PolicyStartDate", customFormatDate(departureDate));
//			} else {
//				return errorMessage("Departure date is empty").toString();
//			}
//
//			String arrivalDate = params.getString("ArrivalDate", null);
//			if (arrivalDate != null && !arrivalDate.isEmpty()) {
//				_data.put("PolicyEndDate", customFormatDate(arrivalDate));
//			} else {
//				return errorMessage("Arrival date is empty").toString();
//			}
//			
//			String promoCode = params.getString("PromoCode");
//			_data.put("PromoCode", promoCode);
//			
//			// HITUNG PROMOCODE DI KYC
//			if(!promoCode.isEmpty()) {
//				try {
//					
//					double promoCodeDiscount = 0;
//					
//					HashMap<String, Object> mainBody = new HashMap<String, Object>();
//					mainBody.put("PromoCode", promoCode.toUpperCase());
//					mainBody.put("ProductCode", "IT6");
//					
//					String __businessModel = params.getString("BusinessModel");
//					String __channel = "DIRECT";
//					if(__businessModel.equalsIgnoreCase("b2b") || __businessModel.equalsIgnoreCase("b2b2c")) {
//						__channel = "Agent";
//					}
//					mainBody.put("Channel", _channel);
//					
//					String __managedBy = params.getString("ManagedBy");
//					String _encryptedManagedBy = "";
//					if(!_managedBy.isEmpty()) {
//						_encryptedManagedBy = __managedBy;
//					}
//					mainBody.put("ManagedBy", _encryptedManagedBy);
//					
//					
//					String startDate = params.getString("DepartureDate");
//					String expiredDate = params.getString("ArrivalDate");
//					
//			        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
//			        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			        
//			        LocalDate _startdate = LocalDate.parse(startDate, inputFormatter);
//			        String _startdateFormatted = _startdate.format(outputFormatter);
//			        
//			        LocalDate _expiredDate = LocalDate.parse(expiredDate, inputFormatter);
//			        String _expiredDateFormatted = _expiredDate.format(outputFormatter);
//					
//					mainBody.put("leadsStartDate", _startdateFormatted);
//					mainBody.put("leadsExpiredDate", _expiredDateFormatted);
//					
//					String _choosenPlan = params.getString("ChoosenPlan");
//					mainBody.put("Plan", _choosenPlan);
//					
//					// traveller type
//					String _travellerType = params.getString("TravellerType");
//					if(_travellerType.equalsIgnoreCase("individual")) {
//						_travellerType = "Sendiri";
//					} else if(_travellerType.equalsIgnoreCase("duo")) {
//						_travellerType = "Duo";
//					} else if(_travellerType.equalsIgnoreCase("family")) {
//						_travellerType = "Keluarga";
//					}
//					mainBody.put("TravellerType", _travellerType);
//					
//					Gson gson = new Gson();
//					String payload = "";
//					payload = gson.toJson(mainBody);
//					_logs.info("[CALCULATE PREMI][KYC][PAYLOAD API PROMOCODE]: " + payload);
//					
//					JSONObject _callAPI = null;
//					try {
//						_callAPI = callAPI(payload, CHECK_PROMOCODE_PIMCORE);
//						
//						// Sample request dari pimcore
////						JSONObject _subData = jsonFactoryService.createJSONObject();
////						_subData.put("Discount", 20);
////						
////						JSONObject _parentData = jsonFactoryService.createJSONObject();
////						_parentData.put("Status", 1);
////						_parentData.put("Message", "Sample message");
////						_parentData.put("Data", _subData);
////						_callAPI = _parentData;
//						// end Sample request dari pimcore
//						
//						if(_callAPI.getInt("Status") > 0) {
//							promoCodeDiscount = _callAPI.getJSONObject("Data").getDouble("Discount");
//							
//						} else {
//							return errorMessage(_callAPI.getString("Message")).toString();	
//						}
//					} catch (Exception e) {
//						_log.debug("[CALL API][PROMOCODE][KYC][EXCEPTION]: " + e.getMessage());
//						return errorMessage("Calculate Failed").toString();
//					}
//					
//					// jumlah diskon dari response api promocode
//					params.put("Discount", promoCodeDiscount);
//					
////					throw new Exception("Invalid Promo Code");
//				} catch (Exception e) {
//					_logs.info("[CALCULATE PREMI][EXCEPTION]: " + e.getMessage());
//					return errorMessage(e.getMessage()).toString();
//				}
//			}
//			// END HITUNG PROMOCODE DI KYC
//			
//			// Calculate Premi
//			
//			// tambahkan property SpesificPlan ke params
//			// supaya hasil yang ditambahkan ke DB
//			// sama dengan hasil yang keluar pada response saat dipanggil pimcore
//			String _choosenPlan = params.getString("ChoosenPlan");
//			params.put("SpesificPlan", _choosenPlan);
//			
//			
//			double basicPremium = 0, netPremium = 0, policyCost = 0, stampDuty = 0, discount = 0;
//			double discountedPremium = 0;
//			double discountAmount = 0;
//			String currency = "IDR";
//			
//			JSONObject calculatePremiResult = null;
//			if(!Validator.isBlank(_choosenPlan)) {
//				calculatePremiResult = calculatePremi(params, true);
//			} else {
//				calculatePremiResult = calculatePremi(params, false);
//			}
//			
//			JSONObject detail = calculatePremiResult.getJSONObject("Calculation");
//			JSONArray calculationArray = detail.getJSONArray("AvailablePlans");
//			
//			policyCost = detail.getDouble("PolicyCost");
//			stampDuty = detail.getDouble("Stamp");
//			discount = detail.getDouble("Discount");
//			currency = detail.getString("Currency");
//			basicPremium = detail.getDouble("Premium");
//			netPremium = detail.getDouble("NetPremium");
//			discountAmount = detail.getDouble("DiscountAmount");
//
//			// Net Premi
//			if (calculatePremiResult.length() > 0) {
//				_data.put("PolicyCost", policyCost);
//				_data.put("StampDuty", stampDuty);
//				_data.put("Premium", basicPremium);
//				_data.put("NetPremium", netPremium);
//				_data.put("Discount", discount);
//				_data.put("DiscountAmount", discountAmount);
//			}
//		
//
//			// SAVE LEADS
//			Leads saveLeads = LeadsLocalServiceUtil.updateLeads(userId, quotation ? (long) 0 : LeadsId, _data,
//					serviceContext);
//
//			if (saveLeads == null) {
//				return errorMessage("Failed to save leads").toString();
//			}
//			
//			// SAVE DETAIL INTERNATIONAL TRAVEL
//			// --------------------------------------------------------------------------
//			DetailInternationalTravel saveDetail = null;
//			try {
//				JSONObject _dataDetail = jsonFactoryService.createJSONObject();
//				_dataDetail.put("LeadsId", saveLeads.getLeadsId());
//				_dataDetail.put("TravelType", params.getString("TravelType"));
////				_dataDetail.put("Destination", params.getString("Destination"));
//				_dataDetail.put("Destination", "Worldwide");
//				_dataDetail.put("PackageType", params.getString("ChoosenPlan"));
//				_dataDetail.put("TravellerType", params.getString("TravellerType"));
//				_dataDetail.put("DepartureDate", customFormatDateTime(departureDate));
//				_dataDetail.put("ArrivalDate", customFormatDateTime(arrivalDate));
//				_dataDetail.put("Adult", params.getString("AdultTotal"));
//				_dataDetail.put("Child", params.getString("ChildTotal"));
//				_dataDetail.put("ListBenefitId", params.getString("AdditionalBenefits"));
//				
//				long detailId = 0;
//				if(LeadsId > 0) {
//					DetailInternationalTravel _detailIT = DetailInternationalTravelLocalServiceUtil.findByLeadsId(LeadsId);
//					if(_detailIT != null) {
//						detailId = _detailIT.getDetailId();
//					}
//				}
//				
//				saveDetail = DetailInternationalTravelLocalServiceUtil.addDetail(userId, detailId, _dataDetail, serviceContext);
//				
//				if(Validator.isNull(saveDetail)) {
//					throw new Exception("FAILED TO SAVE DETAIL INTERNATIONAL TRAVEL");	
//				}
//				
//			} catch (Exception e) {
//				// Failed to create detail Smart Travel International
//				_logs.info("[KYC][DETAIL][LEADS ID:"+saveLeads.getLeadsId()+"]: " + e.getMessage());
//				return errorMessage("FAILED KYC #14 - Please try again").toString();
//			}
//			// END SAVE DETAIL INTERNATIONAL TRAVEL
//			// --------------------------------------------------------------------------
//			
//			// Send quotation to Pimcore
//			if(quotation) {
//				HashMap<String, Object> mainBody = new HashMap<String, Object>();
//				mainBody.put("LiferayId", String.valueOf(saveLeads.getLeadsId()));
//				mainBody.put("ManagedBy", saveLeads.getManagedBy());
//				mainBody.put("PdCode", _productConfiguration.getProductCode());
//				mainBody.put("Channel", saveLeads.getChannel());
//				mainBody.put("Currency", saveLeads.getCurrency());
//				
//
//				double _premium = (saveLeads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(saveLeads.getPremium()) : Math.round(saveLeads.getPremium() * 100.0) / 100.0;
//				double _netpremium = (saveLeads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(saveLeads.getNetPremium()) : Math.round(saveLeads.getNetPremium() * 100.0) / 100.0;
//				mainBody.put("StampDuty", saveLeads.getStampDuty());
//				mainBody.put("Premium", _premium);
//				mainBody.put("NetPremium", _netpremium);
//				
//				mainBody.put("PromoCode", saveLeads.getPromoCode());
//				mainBody.put("Discount", saveLeads.getDiscount());
//				mainBody.put("DiscountAmount", (saveLeads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(saveLeads.getDiscountAmount()) : Math.round(saveLeads.getDiscountAmount() * 100.0) / 100.0);
//				
//				mainBody.put("Commission", String.valueOf(saveLeads.getCommission()));
//				mainBody.put("BussinesModel", saveLeads.getBussinesModel());
//				
//				HashMap<String, Object> detailBody = new HashMap<String, Object>();
//				detailBody.put("Destination", saveDetail.getDestination());
//				detailBody.put("DepartureDate", _customFormatDate(saveDetail.getDepartureDate()));
//				detailBody.put("ArrivalDate",  _customFormatDate(saveDetail.getArrivalDate()));
//				detailBody.put("TravelType", saveDetail.getTravelType());
//				detailBody.put("TravellerType", saveDetail.getTravellerType());
//				detailBody.put("PackageType", saveDetail.getPackageType());
//				detailBody.put("TotalAdult", String.valueOf(saveDetail.getAdult()));
//				detailBody.put("TotalChildren", String.valueOf(saveDetail.getChild()));
//				
//				mainBody.put("Detail", detailBody);
//				
//				String listBenefit = saveDetail.getListBenefitId();
//				List<String> externalCodeArray = new ArrayList<String>();
//				if(listBenefit == null || listBenefit.isEmpty() || listBenefit.equalsIgnoreCase("[]")) {
////					System.out.println("Without additional benefits");
//				} else {
//					String[] benefitArray = listBenefit.replace("[", "").replace("]", "").split(",");
//					long[] longArray = Arrays.stream(benefitArray)
//		                      .map(String::trim) // Trim spaces around elements
//		                      .filter(s -> !s.isEmpty()) // Ensure no empty elements
//		                      .mapToLong(Long::parseLong) // Convert to long
//		                      .toArray();
//					
//				    for (long value : longArray) {
//				    	Benefit benefit = BenefitLocalServiceUtil.getBenefit(value);
//				    	externalCodeArray.add(benefit.getExternalCode());
//				    }
//				}
//				
//				mainBody.put("AdditionalBenefit", externalCodeArray);
//				
//				HashMap<String, Object> policyHolderBody = new HashMap<String, Object>();
//				policyHolderBody.put("Name", saveLeads.getName());
//				policyHolderBody.put("Email", saveLeads.getEmail());
//				
//				mainBody.put("PolicyHolder", policyHolderBody);
//				
//				Gson gson = new Gson();
//				String payload = "";
//				payload = gson.toJson(mainBody);
//				
//				JSONObject _callAPI = null;
//				try {
//					_callAPI = callAPI(payload, CREATE_QUOTE_PIMCORE);	
//				} catch (Exception e) {
//					_log.debug("[CALL API][KYC][EXCEPTION]: " + e.getMessage());
//					return errorMessage("Failed KYC #10").toString();
//				}
//				
//				if(_callAPI.getInt("Status") == 0) {
//					return errorMessage(_callAPI.getString("Message")).toString();
//				} else {
//					
//					// set token limiter to invalid
//					AgentTokenLimiterLocalServiceUtil.setToInvalid(agentTokenLimiterId);
//					
//					_response.put("Status", 1);
//					_response.put("Data", PIMCORE_HOST + "/dashboard");
//					_response.put("Message", "Kirim Penawaran Berhasil");
//				}
//			} else {
//				if (saveLeads.getLeadsId() > 0) {
//					JSONObject responseData = jsonFactoryService.createJSONObject();
//					responseData.put("Token", saveLeads.getToken());
//					if (quotation) {
//						responseData.put("LeadsId", saveLeads.getLeadsId());
//					}
//
//					_response.put("Status", 1);
//					_response.put("Data", responseData);
//				} else {
//					return errorMessage("Failed KYC #12").toString();
//				}
//			}
//			
//		} catch (Exception e) {
//			return errorMessage("Failed KYC #13").toString();
//		}
//
//		return _response.toString();
//
//	}

	@POST
	@Path("/step3")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String step3(String request, @Context HttpServletRequest httpServletRequest)
			throws Exception {

		JsonObject params = null; // Incoming data payload from request
		JsonObject _response = new JsonObject(); // JSON output API
		
		long LeadsId = 0;
		Leads leads = null;
		long userId = 0L;
		ServiceContext serviceContext = null;
		String leadsType = "kyc";
		try {
			serviceContext = ServiceContextFactory.getInstance(Leads.class.getName(), httpServletRequest);
			userId = serviceContext.getGuestOrUserId();
			params = new Gson().fromJson(request, JsonObject.class);			

			// SAVE LEADS
			String token = params.get("token").getAsString();
			_logs.debug("[STEP3_KYC][PARAMS][TOKEN]" + token);
			
			leads = LeadsLocalServiceUtil.findByToken(token);
			_logs.debug("[STEP3_KYC][PARAMS][LEADS]" + token);
			
			if (leads == null) {
				throw new Exception("Leads not found");
			}

			// DATA INSURED
			String policyholder = "policyholder";
			String insured = "insured";

			HashMap<String, Object> _dataPolicyHolder = new HashMap<String, Object>();
			_dataPolicyHolder.put("LeadsType", leadsType);

			// Check if insured is polis
			boolean insuredIsPolis = params.get("insuredIsPolis").getAsBoolean();

			// Declare JSONArray for insuredDataList
			JsonArray insuredDataList = new JsonArray();

			// If insuredIsPolis is false, use the insured list from params
			insuredDataList = params.get(insured).getAsJsonArray();

			// Update Policy Holder Data
			JsonObject policyholderData = params.get(policyholder).getAsJsonObject();

			// Base64 string to file upload process
			String base64Image = policyholderData.get("_fotoktp").getAsString();
			
			try {
//				if (Validator.isNotNull(base64Image)) {
				
				long fileEntryId = 0;
				String filePath = "";
				
				if (Validator.isNotNull(base64Image) && !Validator.isBlank(base64Image)) {
					List<String> fileData = manageFile(base64Image, "img_policyholder", "Image Policy Holder",
							httpServletRequest);
					// Retrieve fileEntryId and filePath from the list
					String fileEntryIdStr = fileData.get(0);
					filePath = fileData.get(1);

					// If you need fileEntryId as a long
					fileEntryId = Long.parseLong(fileEntryIdStr);
				}

					String dobRaw = policyholderData.get("_dob").getAsString().replaceAll("/", "-");
					String formattedDob = parseDate(dobRaw);

					_dataPolicyHolder.put("Name", policyholderData.get("_name").getAsString());
					_dataPolicyHolder.put("Email", policyholderData.get("_email").getAsString());
					_dataPolicyHolder.put("MobilePhone", policyholderData.get("_hp").getAsString());
					_dataPolicyHolder.put("Gender", policyholderData.get("_gender").getAsString());
					_dataPolicyHolder.put("Dob", formattedDob);
					_dataPolicyHolder.put("BirthPlace", policyholderData.get("_pdob").getAsString());

					String nationality = policyholderData.get("_negara").getAsString();
					String ktpkitas = policyholderData.get("_ktpkitas").getAsString();
					_dataPolicyHolder.put("Nationality", nationality);
					if (nationality.equalsIgnoreCase("indonesia")) {
						_dataPolicyHolder.put("IdNumber", ktpkitas);
					} else {
						_dataPolicyHolder.put("KitasNumber", ktpkitas);
					}

					_dataPolicyHolder.put("PassportNumber", policyholderData.get("_ktppaspor").getAsString());
					_dataPolicyHolder.put("Address", policyholderData.get("_alamat").getAsString().replace("\n", " ")); //escape alamat mungkin pakai enter
					_dataPolicyHolder.put("Zip", policyholderData.get("_kodepos").getAsString());

					_dataPolicyHolder.put("isPEP", policyholderData.get("_ispep").getAsString());
					_dataPolicyHolder.put("CountryCode", policyholderData.get("_kodenegara").getAsString());
					
					_dataPolicyHolder.put("Job", policyholderData.get("_job").getAsString());
					_dataPolicyHolder.put("JobOther", policyholderData.get("_otherjob").getAsString());
					
					_dataPolicyHolder.put("Age", policyholderData.get("_age").getAsInt());
					_dataPolicyHolder.put("MaritalStatus", policyholderData.get("_statuskawin").getAsString());
					_dataPolicyHolder.put("Phone", policyholderData.get("_telepon").getAsString());
					_dataPolicyHolder.put("IdPhotoFileEntry", fileEntryId);
					_dataPolicyHolder.put("PhotoFileUrl", filePath);
					
					_logs.info("[STEP3_KYC][POLICY HOLDER] " + _dataPolicyHolder);

					// Check ManagedBy payload from params
					//String _managedBy = params.get("ManagedBy", "");
					//_dataPolicyHolder.put("ManagedBy", _managedBy);

					// Update data policyholder di kyc
					LeadsLocalServiceUtil.updateLeadsData(userId, leads.getLeadsId(), _dataPolicyHolder, serviceContext);
//				}

			} catch (Exception e) {
				_logs.info("[STEP3_KYC][UPDATE LEADS EXCEPTION] " + e.getMessage());
				return errorMessage("Failed KYC").toString();
			}

			// ====================SAVE INSURED======================
			if (Validator.isNotNull(leads)) {
				LeadsId = leads.getLeadsId();

				// save leads insured data
				// JSONArray insuredDataList = params.getJSONArray(insured);
				try {
					// Update Child Data
					CustomerLocalServiceUtil.removeCustomerByLeadsIdAndProductCode(LeadsId, "STI");
					if (Validator.isNotNull(insuredDataList)) {
						for (int i = 0; i < insuredDataList.size(); i++) {

							JsonObject insuredData = insuredDataList.get(i).getAsJsonObject();
							HashMap<String, Object> _childParams = new HashMap<String, Object>();

							// Base64 string to file upload process
							String base64ImageIs = "";
							
							if(insuredData.get("_fotoktp").getAsString().length() > 0) {
								base64ImageIs = insuredData.get("_fotoktp").getAsString();
							}							

							// save file to liferay
							String fileEntryIdStr = "";
							String filePath = "";
							long fileEntryId = 0;
							if(!base64ImageIs.isEmpty()) {
								List<String> fileData = manageFile(base64ImageIs, "img_insured", "Image Insured",
										httpServletRequest);

								// Retrieve fileEntryId and filePath from the list
								fileEntryIdStr = fileData.get(0);
								filePath = fileData.get(1);

								// If you need fileEntryId as a long
								fileEntryId = Long.parseLong(fileEntryIdStr);								
							}

							String dobRaw = insuredData.get("_dob").getAsString().replaceAll("/", "-");
							String formattedDob = parseDate(dobRaw);

							_childParams.put("LeadsId", LeadsId);
							_childParams.put("Name", insuredData.get("_name").getAsString());
							_childParams.put("Email", insuredData.get("_email").getAsString());
							_childParams.put("MobilePhone", insuredData.get("_hp").getAsString());
							_childParams.put("Gender", insuredData.get("_gender").getAsString());
							_childParams.put("Dob", formattedDob);
							_childParams.put("BirthPlace", insuredData.get("_pdob").getAsString());

							String nationality = insuredData.get("_negara").getAsString();
							String ktpkitas = insuredData.get("_ktpkitas").getAsString();
							_childParams.put("Nationality", nationality);
							
							if (nationality.equalsIgnoreCase("indonesia")) {
								_childParams.put("IdNumber", ktpkitas);
							} else {
								_childParams.put("KitasNumber", ktpkitas);
							}

							_childParams.put("PassportNumber", insuredData.get("_ktppaspor").getAsString());
							_childParams.put("Address", insuredData.get("_alamat").getAsString().replace("\n", " ")); //escape alamat mungkin pakai enter);
							_childParams.put("Zip", insuredData.get("_kodepos").getAsString());
							_childParams.put("Relationship", insuredData.get("_relationship").getAsString());

							_childParams.put("isPEP", insuredData.get("_ispep").getAsString());
							_childParams.put("CountryCode", insuredData.get("_kodenegara").getAsString());
							
							_childParams.put("Job", insuredData.get("_job").getAsString());
							_childParams.put("JobOther", insuredData.get("_otherjob").getAsString());
							
							_childParams.put("Age", insuredData.get("_age").getAsInt());
							_childParams.put("MaritalStatus", insuredData.get("_statuskawin").getAsString());
							_childParams.put("Phone", insuredData.get("_telepon").getAsString());

							_childParams.put("IdPhotoFileEntry", fileEntryId);
							_childParams.put("PhotoFileUrl", filePath);

							_childParams.put("ProductCode", "STI");
							
							_logs.info("[STEP3_KYC][CHILD] " + _childParams);

							Customer _customer = CustomerLocalServiceUtil.addCustomerData(userId, 0, _childParams,
									serviceContext);
						}
					}
				} catch (Exception e) {
					_logs.info("[STEP3_KYC][UPDATE CUSTOMER EXCEPTION] " + e.getMessage());
					return errorMessage("Failed Insured").toString();
				}
			}

		} catch (Exception e) {
			throw e;
		}

		return _response.toString();
	}
	
	// Update data leads and customers
	/**
	 * ULAC01: get leads by token null / leads not found
	 * ULAC02: update leads gagal
	 * ULAC03: data insured dari param payload tidak ada
	 * ULAC04: create/update customer gagal
	 */
	private void updateLeadsAndCustomers(JsonObject paramSanitized, String leadsToken,
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
		
		serviceContext = ServiceContextFactory.getInstance(SmartTravelApplication.class.getName(), httpServletRequest);
		userId = serviceContext.getGuestOrUserId();

		JsonObject policyholderData = paramSanitized.get("policyholder").getAsJsonObject();
		JsonArray insuredDataList = paramSanitized.get("insured").getAsJsonArray();
		boolean insuredIsPolis = paramSanitized.get("insuredIsPolis").getAsBoolean();

//		POLICY HOLDER
		try {
			long fileEntryId = 0;
			String filePath = "";
			
			String base64Image = policyholderData.get("_fotoktp").getAsString();
			
			if (Validator.isNotNull(base64Image) && !Validator.isBlank(base64Image)) {
				List<String> fileData = manageFile(base64Image, "img_policyholder", "Image Policy Holder", httpServletRequest);
				String fileEntryIdStr = fileData.get(0);
				filePath = fileData.get(1);
				fileEntryId = Long.parseLong(fileEntryIdStr);
			}			

			HashMap<String, Object> _dataPolicyHolder = new HashMap<String, Object>();
			_dataPolicyHolder.put("LeadsType", leadsType);

			String dobRaw = policyholderData.get("_dob").getAsString().replaceAll("/", "-");
			String formattedDob = parseDate(dobRaw);

			_dataPolicyHolder.put("Name", policyholderData.get("_name").getAsString());
			_dataPolicyHolder.put("Email", policyholderData.get("_email").getAsString().trim());
			_dataPolicyHolder.put("MobilePhone", policyholderData.get("_hp").getAsString());
			_dataPolicyHolder.put("Gender", policyholderData.get("_gender").getAsString());
			_dataPolicyHolder.put("Dob", formattedDob);
			_dataPolicyHolder.put("BirthPlace", policyholderData.get("_pdob").getAsString());

			String nationality = policyholderData.get("_negara").getAsString();
			String ktpkitas = policyholderData.get("_ktpkitas").getAsString();
			_dataPolicyHolder.put("Nationality", nationality);
			if (nationality.equalsIgnoreCase("indonesia")) {
				_dataPolicyHolder.put("IdNumber", ktpkitas);
			} else {
				_dataPolicyHolder.put("KitasNumber", ktpkitas);
			}

			_dataPolicyHolder.put("PassportNumber", policyholderData.get("_ktppaspor").getAsString());
			_dataPolicyHolder.put("Address", policyholderData.get("_alamat").getAsString().replace("\n", " "));
			_dataPolicyHolder.put("Zip", policyholderData.get("_kodepos").getAsString());

			_dataPolicyHolder.put("isPEP", policyholderData.get("_ispep").getAsString());
			_dataPolicyHolder.put("CountryCode", policyholderData.get("_kodenegara").getAsString());

			_dataPolicyHolder.put("Job", policyholderData.get("_job").getAsString());
			_dataPolicyHolder.put("JobOther", policyholderData.get("_otherjob").getAsString());

			_dataPolicyHolder.put("Age", policyholderData.get("_age").getAsInt());
			_dataPolicyHolder.put("MaritalStatus", policyholderData.get("_statuskawin").getAsString());
			_dataPolicyHolder.put("Phone", policyholderData.get("_telepon").getAsString());
			
			if (Validator.isNotNull(base64Image) && !Validator.isBlank(base64Image)) {
				_dataPolicyHolder.put("IdPhotoFileEntry", fileEntryId);
				_dataPolicyHolder.put("PhotoFileUrl", filePath);
			}
			LeadsLocalServiceUtil.updateLeadsData(userId, leads.getLeadsId(), _dataPolicyHolder, serviceContext);
		} catch (Exception e) {
			throw new Exception("Data cannot be processed [ULAC02]");
		}
		
//		INSURED
		if(insuredDataList == null) {
			throw new Exception("Data cannot be processed [ULAC03]");
		}
		
		try {
			JsonArray dataPhotoExisting = new JsonArray();
			
			List<Customer> insuredListCus = customerLocalService.findByLeadsId(leads.getLeadsId());
			
			for (Customer item : insuredListCus) {
				JsonObject dataPhotoExistingDto = new JsonObject();
				
				dataPhotoExistingDto.addProperty("PasporNumber", item.getPassportNumber());
				dataPhotoExistingDto.addProperty("FileEntryId", item.getIdPhotoFileEntryId());
				dataPhotoExistingDto.addProperty("PhotoUrl", item.getPhotoFileUrl());
				
				dataPhotoExisting.add(dataPhotoExistingDto);
			}
			
			// hapus jika sebelumnya ada data customer ini
			CustomerLocalServiceUtil.removeCustomerByLeadsIdAndProductCode(leads.getLeadsId(), "STI");
			
			for (int i = 0; i < insuredDataList.size(); i++) {
				JsonObject insuredData = insuredDataList.get(i).getAsJsonObject();
				
				// image
				String customerBase64Image = "";
				if(insuredData.get("_fotoktp").getAsString().length() > 0) {
					customerBase64Image = insuredData.get("_fotoktp").getAsString();
				}
				
				String fileEntryIdStr = "";
				long fileEntryId = 0;
				String filePath = "";
				
				if (dataPhotoExisting.size() > 0) {
					for (int j = 0; j < dataPhotoExisting.size(); j++) {
						if (insuredData.get("_ktppaspor").getAsString().equalsIgnoreCase(dataPhotoExisting.get(j).getAsJsonObject().get("PasporNumber").getAsString())) {
							fileEntryId = dataPhotoExisting.get(j).getAsJsonObject().get("FileEntryId").getAsLong();
							filePath = dataPhotoExisting.get(j).getAsJsonObject().get("PhotoUrl").getAsString();
						}
					}
				}
				
				if(Validator.isNotNull(customerBase64Image) && !Validator.isBlank(customerBase64Image)) {
					List<String> fileData = manageFile(customerBase64Image, "img_insured", "Image Insured", httpServletRequest);

					fileEntryIdStr = fileData.get(0);
					filePath = fileData.get(1);
					fileEntryId = Long.parseLong(fileEntryIdStr);		
				}				

				String insuredDobRaw = insuredData.get("_dob").getAsString().replaceAll("/", "-");
				String insuredFormattedDob = parseDate(insuredDobRaw);
				
				HashMap<String, Object> customerData = new HashMap<String, Object>();
				customerData.put("LeadsId", leads.getLeadsId());
				customerData.put("Name", insuredData.get("_name").getAsString());
				customerData.put("Email", insuredData.get("_email").getAsString().trim());
				customerData.put("MobilePhone", insuredData.get("_hp").getAsString());
				customerData.put("Gender", insuredData.get("_gender").getAsString());
				customerData.put("Dob", insuredFormattedDob);
				customerData.put("BirthPlace", insuredData.get("_pdob").getAsString());
				
				String nationality = insuredData.get("_negara").getAsString();
				String ktpkitas = insuredData.get("_ktpkitas").getAsString();
				customerData.put("Nationality", nationality);
				if (nationality.equalsIgnoreCase("indonesia")) {
					customerData.put("IdNumber", ktpkitas);
				} else {
					customerData.put("KitasNumber", ktpkitas);
				}

				customerData.put("PassportNumber", insuredData.get("_ktppaspor").getAsString());
				customerData.put("Address", insuredData.get("_alamat").getAsString().replace("\n", " "));
				customerData.put("Zip", insuredData.get("_kodepos").getAsString());
				customerData.put("Relationship", insuredData.get("_relationship").getAsString());
				customerData.put("isPEP", insuredData.get("_ispep").getAsString());
				customerData.put("CountryCode", insuredData.get("_kodenegara").getAsString());
				customerData.put("Job", insuredData.get("_job").getAsString());
				customerData.put("JobOther", insuredData.get("_otherjob").getAsString());
				customerData.put("Age", insuredData.get("_age").getAsInt());
				customerData.put("MaritalStatus", insuredData.get("_statuskawin").getAsString());
				customerData.put("Phone", insuredData.get("_telepon").getAsString());
				customerData.put("IdPhotoFileEntry", fileEntryId);
				customerData.put("PhotoFileUrl", filePath);
				customerData.put("ProductCode", "STI");
				
				CustomerLocalServiceUtil.addCustomerData(userId, 0, customerData, serviceContext);
			}
			
		} catch (Exception e) {
			System.out.println("GAGAL CREATE CUSTOMER");
			System.out.println(e);
			throw new Exception("Data cannot be processed [ULAC04]");
		}
	}
	
	// Process data to Pimcore and redirect to Pimcore payment page if success
	/**
	 * 
	 * PR01:token tidak ada saat masuk ke endpoint /process
	 * PR02:ada error saat sanitasi XSS
	 * PR03:detail international travel null
	 * PR04: error saat membuat list adult dan list children untuk payload ke pimcore
	 * PR05: error saat membuat payload untuk dikirim ke pimcore
	 * PR06: error saat proses request kirim data ke pimcore. method hitAPI nge-throw sesuatu. ini artinya ada error di dalam hitAPI (bukan dari pimcore)
	 * PR07: status http requestnya 200 tapi body response dari pimcore kosong
	 * PR08: status http request ke pimcore bukan 200, bisa jadi 400 atau 500 error internal server
	 * PR09: return dari method hitAPI kosong sama sekali tidak ada isinya/null
	 */
	@POST
	@Path("/process")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String process(String request, @Context HttpServletRequest httpServletRequest) throws Exception {

		helpers.setPropService(propService);
		String host = PortalUtil.getPortalURL((HttpServletRequest) httpServletRequest);
		JsonObject params = new Gson().fromJson(request, JsonObject.class); // payload
		JsonObject _response = new JsonObject(); // response hasil akhir

		String token = params.get("Token").getAsString();
		if (token.isEmpty()) {
			return errorMessage("Data cannot be processed [PR01]").toString();
		}

		String type = params.get("type").getAsString();
		String quouteId = params.get("QuouteId").getAsString();
		
		// SAMPLE BYPASS XSS DELETE LATER
//		JSONObject paramSanitized = jsonFactoryService.createJSONObject(params.getString("payloadKyc"));

//		IF REQUEST TYPE IS NOT PAYMENT
		if (!type.equalsIgnoreCase("payment")) {
        		String sanitizedReqStrToKyc = "";
        		try {
    		        JsonObject joPayloadKyc = new Gson().fromJson(params.get("payloadKyc").getAsString(), JsonObject.class);
            		Map<String, Object> payloadMap = convertJsonToMap(joPayloadKyc.toString());
            		
        		    Map<String, Object> sanitizedPayload = XSSValidator.sanitizePayload(payloadMap);
        		    ObjectMapper objectMapper = new ObjectMapper();
        		    sanitizedReqStrToKyc = objectMapper.writeValueAsString(sanitizedPayload);
        		} catch (Exception e) {
        			_logs.error(e.getMessage());
        		    return errorMessage("Data cannot be processed [PR02]").toString();
        		}
        		
        		JsonObject paramSanitized = new Gson().fromJson(sanitizedReqStrToKyc, JsonObject.class);
//        		System.out.println("PARAM SANITIZED:");
//        		System.out.println(paramSanitized);
//        		System.out.println("-------------------------------");

//			ASALNYA DARI SAFAR YANG INI UNTUK UPDATE LEADS AND CUSTOMER
//			String doStep3 = step3(sanitizedReqStrToKyc, httpServletRequest);
        		
			try {
				updateLeadsAndCustomers(paramSanitized, token, httpServletRequest);
			} catch (Exception e) {
				_logs.error(e.getMessage());
				return errorMessage(e.getMessage()).toString();
			}
			
		}
			
			Leads leads = LeadsLocalServiceUtil.findByToken(token);
			DetailInternationalTravel detailInternationalTravel = DetailInternationalTravelLocalServiceUtil.findByLeadsId(leads.getLeadsId());
			
			if(detailInternationalTravel == null) {
				return errorMessage("Data cannot be processed [PR03]").toString();
			}
			
			// LOAD DATA ADULT AND CHILDREN FROM CUSTOMER FOR PAYLOAD
			List<Customer> insuredListCus = customerLocalService.findByLeadsId(leads.getLeadsId());
			List<Customer> listAdult = new ArrayList<>();
			List<Customer> listChildren = new ArrayList<>();			

			// ADDITIONAL BENEFIT
			List<Object> _additionalBenefit = new ArrayList<Object>();
			
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
						if (utama != null) listAdult.add(utama);
						if (kerabatTeman != null) listAdult.add(kerabatTeman);
					} else if (totalChildren == 1 && totalAdults == 1) {
						if (utama != null) listAdult.add(utama); // Data pertama menjadi dewasa
						if (kerabatTeman != null) listChildren.add(kerabatTeman); // Data kedua menjadi anak
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
				
				if(!leads.getManagedBy().isEmpty()) {
					mainBodyPayload.put("ManagedById", params.get("mbid"));
				}
				
				mainBodyPayload.put("PdCode", leads.getProductCode());
				mainBodyPayload.put("Channel", leads.getChannel());
				mainBodyPayload.put("Currency", leads.getCurrency().toUpperCase());
				mainBodyPayload.put("StampDuty", String.valueOf(leads.getStampDuty()));
				mainBodyPayload.put("PromoCode", leads.getPromoCode());
				mainBodyPayload.put("Discount", leads.getDiscount());
				mainBodyPayload.put("DiscountAmount",
						(leads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(leads.getDiscountAmount())
								: Math.round(leads.getDiscountAmount() * 100.0) / 100.0);
				
				double _premium = (leads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(leads.getPremium())
						: Math.round(leads.getPremium() * 100.0) / 100.0;
				mainBodyPayload.put("Premium", String.valueOf(_premium));

				double netPremium = (leads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(leads.getNetPremium())
						: Math.round(leads.getNetPremium() * 100.0) / 100.0;
				mainBodyPayload.put("NetPremium", String.valueOf(netPremium));
				
				mainBodyPayload.put("Commission", String.valueOf(leads.getCommission()));
				mainBodyPayload.put("BussinesModel", leads.getBussinesModel());
				mainBodyPayload.put("CommercialOffers", String.valueOf(leads.getCommercialOffers()));
				
				mainBodyPayload.put("UserCustom", "");
				mainBodyPayload.put("UtmCampaign", "");
				mainBodyPayload.put("UtmMedium", "");
				mainBodyPayload.put("UtmSource", "");
				mainBodyPayload.put("UtmTerm", "");
				mainBodyPayload.put("ClickId", "");
				
				// DETAIL
				HashMap<String, Object> detailPayload = new LinkedHashMap<>();
				
				detailPayload.put("Destination", detailInternationalTravel.getDestination());
				Date Departuredate = detailInternationalTravel.getDepartureDate();
				String formattedDeparturedate = outputFormat2.format(Departuredate);
				detailPayload.put("DepartureDate", formattedDeparturedate);

				Date ArrivalDate = detailInternationalTravel.getArrivalDate();
				String formattedArrivalDate = outputFormat2.format(ArrivalDate);
				detailPayload.put("ArrivalDate", formattedArrivalDate);

				detailPayload.put("TravelType", detailInternationalTravel.getTravelType());
				detailPayload.put("PackageType", detailInternationalTravel.getPackageType());
				detailPayload.put("TravellerType", detailInternationalTravel.getTravellerType());
				detailPayload.put("TotalAdult", String.valueOf(detailInternationalTravel.getAdult()));
				detailPayload.put("TotalChildren", String.valueOf(detailInternationalTravel.getChild()));
				
				if (params.has("AdditionalBenefit") && params.get("AdditionalBenefit").getAsJsonArray() != null) {
					JsonArray additionalBenefitArray = params.get("AdditionalBenefit").getAsJsonArray();
					if (additionalBenefitArray.size() > 0) {
						for (int i = 0; i < additionalBenefitArray.size(); i++) {
							int benefitId = additionalBenefitArray.get(i).getAsInt();
							Benefit benefit = benefitLocalService.fetchBenefit(benefitId);

							if (benefit != null) {
								_additionalBenefit.add(String.valueOf(benefit.getExternalCode()));
							}
						}
					} else {
						_logs.info("AdditionalBenefit ada tetapi kosong.");
					}
				}
				
				// POLICY HOLDER
				HashMap<String, Object> policyHolderPayload = new LinkedHashMap<>();
				policyHolderPayload.put("IsPep", leads.getIsPep());
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
				policyHolderPayload.put("PhoneNumber", leads.getPhone());
				policyHolderPayload.put("Nationality",
						leads.getNationality().equalsIgnoreCase("Indonesia") ? "WNI" : "WNA");
				policyHolderPayload.put("NationalityCountry", leads.getNationality());
				policyHolderPayload.put("CountryCode", leads.getCountryCode());
				policyHolderPayload.put("MotherMaidenName", "");
				policyHolderPayload.put("MaritalStatus", leads.getMaritalStatus());
				policyHolderPayload.put("Job", leads.getJob());
				policyHolderPayload.put("JobOther", leads.getJobOther());
				policyHolderPayload.put("BirthPlace", leads.getBirthPlace());
				
				if (leads.getPhotoFileUrl().length() > 0) {
					String fullUrlPhoto = host + leads.getPhotoFileUrl();
					policyHolderPayload.put("IdPhotoUrl", fullUrlPhoto);
				} else {
					policyHolderPayload.put("IdPhotoUrl", "");
				}
				
//				policyHolderPayload.put("IdPhotoUrl", host + "/documents/37244/65703/img_policyholder_1737625560452.png"); // SAMPLE DELETE LATER
				
				// ADULT
				List<Object> _adults = new ArrayList<Object>();
				for (Customer adult : listAdult) {
					if (adult == null) {
			            continue;
			        }
					
					HashMap<String, Object> _adult = new LinkedHashMap<>();
					_adult.put("IsPep", adult.getIsPep());
					_adult.put("Name", adult.getName());
					_adult.put("Gender", adult.getGender());

					Date dobAdult = adult.getDob();
					String formatteddobAdult = outputFormat2.format(dobAdult);
					_adult.put("Dob", formatteddobAdult);

					_adult.put("Age", String.valueOf(adult.getAge()));
					_adult.put("Email", adult.getEmail().trim());

					if (adult.getNationality().equalsIgnoreCase("Indonesia")) {
						_adult.put("IdNumber", adult.getIdNumber());
						_adult.put("KitasNumber", "");
					} else {
						_adult.put("IdNumber", "");
						_adult.put("KitasNumber", adult.getKitasNumber());
					}

					_adult.put("PassportNumber", adult.getPassportNumber());
					_adult.put("Address", adult.getAddress());
					_adult.put("Zip", adult.getZip());
					_adult.put("MobilePhone", adult.getMobilePhone());
					_adult.put("PhoneNumber", adult.getPhone());
					_adult.put("Nationality", adult.getNationality().equalsIgnoreCase("Indonesia") ? "WNI" : "WNA");
					_adult.put("NationalityCountry", adult.getNationality());
					_adult.put("CountryCode", adult.getCountryCode());
					_adult.put("MaritalStatus", adult.getMaritalStatus());
					_adult.put("Relationship", adult.getRelationship());
					_adult.put("Job", adult.getJob());
					_adult.put("JobOther", adult.getJobOther());
					_adult.put("Premium", "");
					_adult.put("BirthPlace", adult.getBirthPlace());

					if (adult.getPhotoFileUrl().length() > 0) {
						String fullUrlPhotoAdult = host + adult.getPhotoFileUrl();
						_adult.put("IdPhotoUrl", fullUrlPhotoAdult);
					} else {
						_adult.put("IdPhotoUrl", "");
					}
					
//					_adult.put("IdPhotoUrl", host + "/documents/37244/65703/img_policyholder_1737625560452.png"); // SAMPLE DELETE LATER

					_adults.add(_adult);
				}
				
				// CHILDREN
				List<Object> _childrens = new ArrayList<Object>();
				for (Customer child : listChildren) {
					if (child == null) {
			            continue;
			        }
					
					HashMap<String, Object> _children = new LinkedHashMap<>();
					_children.put("IsPep", child.getIsPep());
					_children.put("Name", child.getName());
					_children.put("Gender", child.getGender());

					Date dobChild = child.getDob();
					String formatteddobChild = outputFormat2.format(dobChild);
					_children.put("Dob", formatteddobChild);

					_children.put("Age", String.valueOf(child.getAge()));
					_children.put("Email", child.getEmail().trim());

					if (child.getNationality().equalsIgnoreCase("Indonesia")) {
						_children.put("IdNumber", child.getIdNumber());
						_children.put("KitasNumber", "");
					} else {
						_children.put("IdNumber", "");
						_children.put("KitasNumber", child.getKitasNumber());
					}

					_children.put("PassportNumber", child.getPassportNumber());
					_children.put("Address", child.getAddress());
					_children.put("Zip", child.getZip());
					_children.put("MobilePhone", child.getMobilePhone());
					_children.put("PhoneNumber", child.getPhone());
					_children.put("Nationality", child.getNationality().equalsIgnoreCase("Indonesia") ? "WNI" : "WNA");
					_children.put("NationalityCountry", child.getNationality());
					_children.put("CountryCode", child.getCountryCode());
					_children.put("MaritalStatus", child.getMaritalStatus());
					_children.put("Relationship", child.getRelationship());
					_children.put("Job", child.getJob());
					_children.put("JobOther", child.getJobOther());
					_children.put("Premium", "");
					_children.put("BirthPlace", child.getBirthPlace());

					if (child.getPhotoFileUrl().length() > 0) {
						String fullUrlPhotoChild = host + child.getPhotoFileUrl();
						_children.put("IdPhotoUrl", fullUrlPhotoChild);
					} else {
						_children.put("IdPhotoUrl", "");
					}

					_childrens.add(_children);
				}
				
				// PAYMENT
				HashMap<String, Object> _paymentPayload = new LinkedHashMap<>();
				_paymentPayload.put("Currency", leads.getCurrency().toUpperCase()); // IDR

				// sub total basic premi + additional
				// premium yang ada disini isinya selalu IDR.
				// kalau dia gross, berarti pakai dari NetPremium di mainBodyPayload
				// kalau dia nett, berarti pakai perhitungan yang dikurang komisi (harus IDR)
				double premiumForPayment = (leads.getCurrency().equalsIgnoreCase("idr")) ? Math.round(leads.getPremium())
						: Math.round(leads.getPremium() * 100.0) / 100.0;
				_paymentPayload.put("Premium", String.valueOf(premiumForPayment));
				
				
				mainBodyPayload.put("Detail", detailPayload);
				mainBodyPayload.put("AdditionalBenefit", _additionalBenefit);
				mainBodyPayload.put("PolicyHolder", policyHolderPayload);
				mainBodyPayload.put("Adults", _adults);
				mainBodyPayload.put("Children", _childrens);
				mainBodyPayload.put("Payment", _paymentPayload);
				
				// PENAWARAN FULL
				if (type.equalsIgnoreCase("penawaran")) {
					mainBodyPayload.put("QuotationType", "full");
				}			
				
				payloadForPimcore = gson.toJson(mainBodyPayload);
				System.out.println(payloadForPimcore);
			} catch (Exception e) {
				_logs.error(e.getMessage());
				return errorMessage("Data cannot be processed [PR05]").toString();
			}

			// SEND TO PIMCORE
			JsonObject responsePimcore = new JsonObject();
			try {
				String pimcoreAPIURL = "";
				if (type.equalsIgnoreCase("penawaran")) {
					pimcoreAPIURL = helpers.getPimcoreAddress() + helpers.getApiCreateQuote();
				} else if (type.equalsIgnoreCase("payment")) {
					pimcoreAPIURL = helpers.getPimcoreAddress() + helpers.getApiPayment();
				} else {
					pimcoreAPIURL = helpers.getPimcoreAddress() + helpers.getApiCheckValidate();
				}
				
				responsePimcore = hitAPI(pimcoreAPIURL, payloadForPimcore.toString());
				
			} catch (Exception e) {
				_logs.error(e.getMessage());
				return errorMessage("Data cannot be processed [PR06]").toString();
			}
				
			String redirectTo = "";
				
			if (responsePimcore == null) {
				return errorMessage("Data cannot be processed [PR09] - Please try again.").toString();
			}
			
			if (responsePimcore.get("httpStatusCode").getAsInt() != 200) {
				return errorMessage("Data cannot be processed [PR08] - Please try again.").toString();
			}
				
			JsonObject responsePimcoreData = responsePimcore.get("data").getAsJsonObject(); // Body response dari pimcore
			
			if (responsePimcoreData == null) {
				return errorMessage("Data cannot be processed [PR07]").toString();
			}

			int responsePimcoreDataStatus = responsePimcoreData.get("Status").getAsInt();
			if (responsePimcoreDataStatus == 1) {
				
				_response.addProperty("Message", "Success");
				
				if (type.equalsIgnoreCase("penawaran")) {
					
					String dashboardPimcore = "/dashboard/leads/online";
					redirectTo = helpers.getPimcoreHost() + dashboardPimcore;
					_response.addProperty("ProcessType", "quotation");
					_response.addProperty("RedirectTarget", redirectTo);
					
				} else if (type.equalsIgnoreCase("payment")) {
					
					JsonObject _d = responsePimcoreData.get("Data").getAsJsonObject();
					String _tokenForPayment = _d.get("Token").getAsString();
					redirectTo = helpers.getPimcoreHost() + "/payment/process" + "/" + _tokenForPayment;
					_response.addProperty("ProcessType", "payment");
					_response.addProperty("RedirectTarget", redirectTo);
					
				} else {
					
					_response.addProperty("ProcessType", "normal");
					_response.addProperty("RedirectTarget", "");
					_response.add("additionalBenefitsCode", new Gson().toJsonTree(_additionalBenefit).getAsJsonArray());
					
				}

			} else {
				_response.addProperty("Message", responsePimcoreData.get("Message").getAsString());
				
				String _redirect = responsePimcoreData.get("Redirect").getAsString();
				int isBlocked = responsePimcoreData.get("Blocked").getAsInt();
				
				if(!_redirect.isEmpty()) {
					if(isBlocked != 0) {
						// blocked
						_response.addProperty("Blocked", true);
					} else {
						// pep
						_response.addProperty("Pep", true);
					}
				}
			}

			_response.addProperty("Status", responsePimcoreDataStatus);
			
		return _response.toString();
	}

		// GET COMPARE PLAN
		@GET
		@Path("/compareplan")
		@Produces("application/json")
		public String comparePlan(String request, @Context HttpServletRequest httpServletRequest) throws JSONException, IOException {
			JsonObject response = new JsonObject();
			List<HashMap<String, Object>> comparePlanList = new ArrayList<>();
			List<BenefitType> _benefitTypes = BenefitTypeLocalServiceUtil.getActiveBenefitType();
			
			if(_benefitTypes != null && _benefitTypes.size() > 0) {
				
				for(BenefitType _benefitType : _benefitTypes) {
					HashMap<String, Object> _item = new HashMap<String, Object>();
					_item.put("sort", _benefitType.getSort());
					_item.put("nameId", _benefitType.getNameId());
					_item.put("nameEn", _benefitType.getNameEn());
					
					
					List<HashMap<String, Object>> currentBenefitList = new ArrayList<>();
					List<Benefit> _currentBenefit = BenefitLocalServiceUtil.getBenefitByTypeId(_benefitType.getBenefitTypeId());
					if(_currentBenefit != null && _currentBenefit.size() > 0) {
						for(Benefit _benefit : _currentBenefit) {
							HashMap<String, Object> _itemBenefit = new HashMap<String, Object>();
							_itemBenefit.put("benefitName", _benefit.getNameId());
							_itemBenefit.put("benefitDescription", _benefit.getBenefitDescription());
							
							HashMap<String, Object> idrContainer = new HashMap<>();
							HashMap<String, Object> usdContainer = new HashMap<>();
							
							List<SmartTravelIntPlan> plans = SmartTravelIntPlanLocalServiceUtil.getActivePlan();
							if(plans != null && plans.size() > 0) {
								for(SmartTravelIntPlan plan:plans) {
									
									BenefitValueMapping _benefitValueMapping = BenefitValueMappingLocalServiceUtil.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(_benefitType.getBenefitTypeId(), _benefit.getBenefitId(), plan.getSmartTravelIntPlanId());

									if(_benefitValueMapping != null) {
										idrContainer.put(plan.getNameId(), _benefitValueMapping.getBenefitValue());
										usdContainer.put(plan.getNameId(), _benefitValueMapping.getBenefitValueUSD());
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
			
			if(comparePlanList.size() > 0) {
				JsonElement elementPlanList = new Gson().toJsonTree(comparePlanList);
				response.addProperty("Status", 1);
				response.add("Data", elementPlanList.getAsJsonArray());	
			} else {
				response.addProperty("Status", 0);
				response.addProperty("Data", "");
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
		JsonObject response = new JsonObject();

		JsonObject params = new Gson().fromJson(request, JsonObject.class);
		String choosenPlan = params.get("Plan").getAsString();

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

					List<BenefitValueMapping> benefitValueMappings = BenefitValueMappingLocalServiceUtil
							.getAllBenefitValueMappingByBenefitType(benefitType.getBenefitTypeId());

					for (BenefitValueMapping benefitValueMapping : benefitValueMappings) {

						HashMap<String, Object> benefitItemListContent = new HashMap<String, Object>();

						SmartTravelIntPlan currentPlan = SmartTravelIntPlanLocalServiceUtil.fetchSmartTravelIntPlan(benefitValueMapping.getPlanId());
						if (!currentPlan.getNameId().equals(choosenPlan)) {
							continue;
						}
						Benefit currentBenefit = BenefitLocalServiceUtil
								.fetchBenefit(benefitValueMapping.getBenefitId());
						
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

			JsonElement elementBenefitValueMapping = new Gson().toJsonTree(benefitTypesContainer);
			JsonArray benefitValueMapping = elementBenefitValueMapping.getAsJsonArray();

			response.addProperty("Status", 1);
			response.addProperty("Message", "Data is ready");
			response.add("Data", benefitValueMapping);
		} catch (Exception e) {
			System.out.println("calculate: " + e.getMessage());
			response.addProperty("Status", 0);
			response.addProperty("Message", "Failed to get data");
			response.addProperty("Data", "");
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
				System.out.println("Folder kosong, membuat folder baru!");
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

		// Decode string Base64 menjadi byte array menggunakan DatatypeConverter
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

	private JsonObject errorMessage(String message) {
		JsonObject _response = new JsonObject();
		_response.addProperty("Status", 0);
		_response.addProperty("Message", message);
		_response.addProperty("Data", "");

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
	public Response processOCR(String request, @Context HttpServletRequest httpServletRequest) {
		helpers.setPropService(propService);
		JsonObject _response = new JsonObject();

		try {
			JsonObject params = new Gson().fromJson(request, JsonObject.class);
			String dataCategory = params.get("dataCategory").getAsString();

			if ("ocr".equalsIgnoreCase(dataCategory)) {
				String base64Image = params.get("_fotoBase64").getAsString();
				String fileName = params.get("_fileName").getAsString();
				
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
				_log.info("API_KEY>>"+helpers.getOcrClientApiKey());
				_log.info("AUTH_HEADERS>>"+helpers.getOcrClientAuthHeader());
				_log.info("OCR_CLIENT_URL>>"+helpers.getOcrClientHostURL());
				
				String ocrRequestUrl = helpers.getOcrClientHostURL() + helpers.getOcrClientPathURL();
				String response = hitApiOCR(ocrRequestUrl, file, helpers.getOcrClientApiKey(), helpers.getOcrClientAuthHeader(), imageFileContentType);
				
				//String response = "{\"images\":{\"photo\":\"iVBORw0KGgoAAAANSUhEUgAAAQEAAAFKCAIAAACSEX0FAAEAAElEQVR4nLT9W5YkSa4liu0\"},\"read\":{\"agama\":{\"confidence\":96,\"value\":\"ISLAM\"},\"alamat\":{\"confidence\":69,\"value\":\"SALOLOANG\"},\"berlakuHingga\":{\"confidence\":97,\"value\":\"SEUMUR HIDUP\"},\"golonganDarah\":{\"confidence\":90,\"value\":\"-\"},\"jenisKelamin\":{\"confidence\":97,\"value\":\"LAKI-LAKI\"},\"kecamatan\":{\"confidence\":99,\"value\":\"PENAJAM\"},\"kelurahanDesa\":{\"confidence\":99,\"value\":\"SALOLOANG\"},\"kewarganegaraan\":{\"confidence\":99,\"value\":\"WNI\"},\"kotaKabupaten\":{\"confidence\":95,\"value\":\"KABUPATEN PENAJAM PASER UTARA\"},\"nama\":{\"confidence\":98,\"value\":\"MUHAMMAD SAFAR\"},\"nik\":{\"confidence\":99,\"value\":\"6409010712950005\"},\"pekerjaan\":{\"confidence\":96,\"value\":\"PELAJAR / MAHASISWA\"},\"provinsi\":{\"confidence\":49,\"value\":\"KALIMANTAN TIMUR\"},\"rtRw\":{\"confidence\":99,\"value\":\"008/000\"},\"statusPerkawinan\":{\"confidence\":96,\"value\":\"BELUM KAWIN\"},\"tanggalLahir\":{\"confidence\":98,\"value\":\"12-11-2022\"},\"tempatLahir\":{\"confidence\":98,\"value\":\"SALOLOANG\"}},\"reason\":\"File successfully read.\",\"status\":\"SUCCESS\"}\r\n";
				
//				String response = "{\r\n" + 
//						"    \"read\": {\r\n" + 
//						"        \"birth_date\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"28-04-1984\"\r\n" + 
//						"        },\r\n" + 
//						"        \"birth_date_hash\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"0\"\r\n" + 
//						"        },\r\n" + 
//						"        \"country\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"IDN\"\r\n" + 
//						"        },\r\n" + 
//						"        \"doc_number\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"E3299861\"\r\n" + 
//						"        },\r\n" + 
//						"        \"doc_number_hash\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"2\"\r\n" + 
//						"        },\r\n" + 
//						"        \"document_type\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"P\"\r\n" + 
//						"        },\r\n" + 
//						"        \"expiry_date\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"330523\"\r\n" + 
//						"        },\r\n" + 
//						"        \"expiry_date_hash\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"4\"\r\n" + 
//						"        },\r\n" + 
//						"        \"final_hash\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"2\"\r\n" + 
//						"        },\r\n" + 
//						"        \"name\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"GRACE THERESYA\"\r\n" + 
//						"        },\r\n" + 
//						"        \"nationality\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"IDN\"\r\n" + 
//						"        },\r\n" + 
//						"        \"optional_data\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"35782668040002\"\r\n" + 
//						"        },\r\n" + 
//						"        \"optional_data_hash\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"1\"\r\n" + 
//						"        },\r\n" + 
//						"        \"sex\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"F\"\r\n" + 
//						"        },\r\n" + 
//						"        \"surname\": {\r\n" + 
//						"            \"confidence\": 99,\r\n" + 
//						"            \"value\": \"THEOGIANTO\"\r\n" + 
//						"        }\r\n" + 
//						"    },\r\n" + 
//						"    \"reason\": \"File successfully read.\",\r\n" + 
//						"    \"status\": \"SUCCESS\"\r\n" + 
//						"}";
				
				String responseErr = "{\r\n" + "    \"error\": \"Quota exceeded\"\r\n" + "}";
				
				String suksesInvalid = "{\r\n" + "    \"images\": {\r\n" + "        \"photo\": \"\",\r\n"
						+ "        \"sign\": \"\"\r\n" + "    },\r\n" + "    \"read\": {\r\n"
						+ "        \"agama\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        },\r\n" + "        \"alamat\": {\r\n"
						+ "            \"confidence\": 0,\r\n" + "            \"value\": \"\"\r\n" + "        },\r\n"
						+ "        \"berlakuHingga\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        },\r\n" + "        \"golonganDarah\": {\r\n"
						+ "            \"confidence\": 0,\r\n" + "            \"value\": \"\"\r\n" + "        },\r\n"
						+ "        \"jenisKelamin\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        },\r\n" + "        \"kecamatan\": {\r\n"
						+ "            \"confidence\": 0,\r\n" + "            \"value\": \"\"\r\n" + "        },\r\n"
						+ "        \"kelurahanDesa\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        },\r\n" + "        \"kewarganegaraan\": {\r\n"
						+ "            \"confidence\": 0,\r\n" + "            \"value\": \"\"\r\n" + "        },\r\n"
						+ "        \"kotaKabupaten\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        },\r\n" + "        \"nama\": {\r\n"
						+ "            \"confidence\": 0,\r\n" + "            \"value\": \"\"\r\n" + "        },\r\n"
						+ "        \"nik\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        },\r\n" + "        \"pekerjaan\": {\r\n"
						+ "            \"confidence\": 0,\r\n" + "            \"value\": \"\"\r\n" + "        },\r\n"
						+ "        \"provinsi\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        },\r\n" + "        \"rtRw\": {\r\n"
						+ "            \"confidence\": 0,\r\n" + "            \"value\": \"\"\r\n" + "        },\r\n"
						+ "        \"statusPerkawinan\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        },\r\n" + "        \"tanggalLahir\": {\r\n"
						+ "            \"confidence\": 0,\r\n" + "            \"value\": \"\"\r\n" + "        },\r\n"
						+ "        \"tempatLahir\": {\r\n" + "            \"confidence\": 0,\r\n"
						+ "            \"value\": \"\"\r\n" + "        }\r\n" + "    },\r\n"
						+ "    \"reason\": \"Failed to process invalid file format. Please upload the correct file format.\",\r\n"
						+ "    \"status\": \"FILE_INVALID_FORMAT\"\r\n" + "}";

				System.out.println("response from glair scan ocr :"+response);
				
				JsonObject _responseOCR = new Gson().fromJson(response, JsonObject.class);
				_responseOCR.remove("images"); // Tidak diperlukan lagi
				_response.add("response", _responseOCR);
				_response.addProperty("status", true);

				return Response.ok(_response.toString()).build();
			} else {
				_response.addProperty("status", false);
				_response.addProperty("message", "Invalid data category / Bad Request");
				return Response.status(Response.Status.OK).entity(_response.toString()).build();
			}
		} catch (Exception e) {
			_logs.error("Error processing OCR request", e);
			_response.addProperty("status", false);
			_response.addProperty("message", "Error processing OCR request / Internal Server");
			return Response.status(Response.Status.OK).entity(_response.toString()).build();
		}
	}
	
    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchCountries(@Context HttpServletRequest request) {
        JsonObject response = new JsonObject();
        HttpURLConnection connection = null;
    	
        helpers.setPropService(propService);
        
    	String apiLiferayCountries = String.valueOf(helpers.getConfig("com.mypage.client.api.liferay.countries"));
        String finalApiLRCountries = helpers.getPimcoreAddress() + apiLiferayCountries;
        
        try {
            // External API URL for fetching countries
            String apiUrl = finalApiLRCountries;

            // Create HTTP Connection
            //URL url = new URL(apiUrl);
            //HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
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
                JsonObject apiResponse = new Gson().fromJson(result.toString(), JsonObject.class);
                int status = apiResponse.get("Status").getAsInt();
                if (status == 1) {
                    JsonArray data = apiResponse.get("Data").getAsJsonArray();
                    JsonArray countries = new JsonArray();

                    for (int i = 0; i < data.size(); i++) {
                        JsonObject country = data.get(i).getAsJsonObject();
                        JsonObject formattedCountry = new JsonObject();
                        formattedCountry.addProperty("id", country.get("Id").getAsLong());
                        formattedCountry.addProperty("name", country.get("Name").getAsString());
                        countries.add(formattedCountry);
                    }

                    // Build success response
                    response.addProperty("status", 1);
                    response.add("data", countries);
                    return Response.ok(response.toString()).build();
                } else {
                    response.addProperty("status", 0);
                    response.addProperty("message", apiResponse.get("Message").getAsString());
                    return Response.status(Response.Status.OK).entity(response.toString()).build();
                }
            } else {
                response.addProperty("status", 0);
                response.addProperty("message", "Gagal memuat data"); //HTTP Code: " + responseCode
                return Response.status(Response.Status.OK).entity(response.toString()).build();
            }
        } catch (Exception e) {
            _log.error("Error fetching countries", e);
            response.addProperty("status", 0);
            response.addProperty("message", "Data tidak ditemukan");
            return Response.status(Response.Status.OK).entity(response.toString()).build();
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
				reader = new BufferedReader(new InputStreamReader(
					responseCode == HttpURLConnection.HTTP_OK ? 
					connection.getInputStream() : connection.getErrorStream()
				));

				response = readResponse(reader);
				_log.info((responseCode == HttpURLConnection.HTTP_OK ? "Success >>" : "Error >>") + response);
				break;
			} catch (Exception e) {
				_log.info("Failed API request >> " + e.getMessage());
				currentRetry++;
			} finally {
				if (connection != null) connection.disconnect();
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

	private HttpURLConnection openConnection(String urlStr) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		URL url = new URL(urlStr);
		if (url.getProtocol().equalsIgnoreCase("https")) {
			HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
			httpsConnection.setHostnameVerifier((host, session) -> host.equalsIgnoreCase(session.getPeerHost()));

			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] {
				new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] chain, String authType) {
					    // This implementation trusts all client certificates. Only for internal API
					}
					public void checkServerTrusted(X509Certificate[] chain, String authType) {
					    // This implementation trusts all server certificates. Only for internal API
					}
					public X509Certificate[] getAcceptedIssuers() {
						return new X509Certificate[0];
					}
				}
			}, new SecureRandom());

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

	private void sendMultipartData(HttpURLConnection connection, File imageFile, String contentTypeImg) throws IOException {
		String boundary = connection.getRequestProperty("boundary");
		try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			 FileInputStream fileInputStream = new FileInputStream(imageFile)) {

			wr.writeBytes("--" + boundary + "\r\n");
			wr.writeBytes("Content-Disposition: form-data; name=\"image\"; filename=\"" + imageFile.getName() + "\"\r\n");
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
	public JsonObject hitAPI(String url, String payload) throws Exception {
		JsonObject _response = new JsonObject();
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
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {}
	
					public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {}
	
					public X509Certificate[] getAcceptedIssuers() {
						return null; //new X509Certificate[0];
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
            //connection.setRequestProperty("Authorization", token); // Set Authorization header
            
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
			throw e;
		}
		
		_response.addProperty("httpStatusCode", httpResponseCode);
		JsonObject _pimcoreResponseBody = new Gson().fromJson(responseBody.toString(), JsonObject.class);
		_response.add("data", _pimcoreResponseBody);
		
		return _response;
	}
	
	
	/**
	 * Call API
	 */
	public JsonObject callAPI(String payload, String targetUrl) throws Exception, IOException {
		helpers.setPropService(propService);
	    String line = StringPool.BLANK;
	    StringBuilder responseBody = new StringBuilder();

	    _log.debug("[CALL API][PAYLOAD]: " + payload);

	    boolean isSSL = targetUrl.contains("https");

	    URLConnection connection;
	    try {
	        URL requestUrl = new URL(helpers.getPimcoreAddress() + targetUrl);
	        _logs.info("[CALL API][TARGET URL]: " + helpers.getPimcoreAddress() + targetUrl);

	        if (isSSL) {
	            connection = (HttpsURLConnection) requestUrl.openConnection();
	        } else {
	            connection = (HttpURLConnection) requestUrl.openConnection();
	        }

	        if (connection instanceof HttpsURLConnection) {
	            ((HttpsURLConnection) connection).setHostnameVerifier((requestedHost, remoteServerSession) ->
	                requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost())
	            );

	            SSLContext sslContext = SSLContext.getInstance("TLS");
	            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
	                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {}

	                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {}

	                public X509Certificate[] getAcceptedIssuers() {
	                    return new X509Certificate[0];
	                }
	            }}, new SecureRandom());
	            ((HttpsURLConnection) connection).setSSLSocketFactory(sslContext.getSocketFactory());
	        }

	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setDoOutput(true);
	        
	        if (connection instanceof HttpsURLConnection) {
	        	((HttpsURLConnection) connection).setRequestMethod("POST");	
	        } else if (connection instanceof HttpURLConnection ) {
	        	((HttpURLConnection) connection).setRequestMethod("POST");
	        }

	        // Write the payload before accessing response-related methods
	        try (OutputStream outputStream = connection.getOutputStream()) {
	            outputStream.write(payload.getBytes());
	            outputStream.flush();
	        }

	        int responseCode = ((HttpURLConnection) connection).getResponseCode();
	        InputStream inputStream;
	        if (responseCode >= 200 && responseCode < 300) {
	            inputStream = connection.getInputStream();
	        } else {
	            inputStream = ((HttpURLConnection) connection).getErrorStream();
	        }

	        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
	            while ((line = bufferedReader.readLine()) != null) {
	                responseBody.append(line);
	            }
	        }

	        _log.debug("[CALL API][RESPONSE_BODY]: " + responseBody);

	    } catch (IOException e) {
	        _log.debug("[CALL API][EXCEPTION]: " + e.getMessage());
	        throw e;
	    }

	    JsonObject _response = new Gson().fromJson(responseBody.toString(), JsonObject.class);

	    return _response;
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
	        Type type = new TypeToken<Map<String, Object>>() {}.getType();
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
	
	class InvalidPlanException extends RuntimeException {
	    public InvalidPlanException(String message) {
	        super(message);
	    }
	}
	
	private static final String currentNumericTimeStamp = generateNumericCurrentTimeStamp();
	private static final Object[] _IMAGE_EXTENSIONS = { ".jpeg", ".jpg", ".png" };
	private static final long _IMAGE_MAX_SIZE = 5242880;
	private static final Log _log = LogFactoryUtil.getLog(SmartTravelApplication.class);

	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;

	@Reference
	LeadsLocalService leadsLocalService;

	@Reference
	CustomerLocalService customerLocalService;
	
	@Reference
	BenefitLocalService benefitLocalService;
}
