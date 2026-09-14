package com.mypage.product.sa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterCurrency;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.SmartActiveBenefit;
import com.mypage.admin.product.model.SmartActiveBenefitType;
import com.mypage.admin.product.model.SmartActiveBenefitValue;
import com.mypage.admin.product.model.SmartActiveBenefitValueMapping;
import com.mypage.admin.product.model.SmartActiveClassRate;
import com.mypage.admin.product.model.SmartActiveOccupation;
import com.mypage.admin.product.model.SmartActivePremi;
import com.mypage.admin.product.model.SmartActiveTopro;
import com.mypage.admin.product.service.MasterCurrencyLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalService;
import com.mypage.admin.product.service.SmartActiveBenefitLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitValueLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveBenefitValueMappingLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveClassRateLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveOccupationLocalServiceUtil;
import com.mypage.admin.product.service.SmartActivePremiLocalServiceUtil;
import com.mypage.admin.product.service.SmartActiveToproLocalServiceUtil;
import com.mypage.leads.model.DetailSmartactive;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.DetailSmartactiveLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalServiceUtil;
import com.mypage.product.sa.application.SmartActiveApplication;
import com.mypage.product.sa.dto.BenefitDTO;
import com.mypage.product.sa.dto.BenefitDetailDTO;
import com.mypage.product.sa.dto.BenefitListDTO;
import com.mypage.product.sa.helpers.ActionHelper;
import com.mypage.product.sa.helpers.EncryptionHelper;
import com.mypage.product.sa.helpers.ValidationHelper;
import com.mypage.product.sa.helpers.XSSValidator;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    service = TransactionService.class
)
public class TransactionService {
	
	public String calculate(String request, HttpServletRequest httpServletRequest) throws JSONException, IOException {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		JSONObject params = JSONFactoryUtil.createJSONObject(request);
		LinkedHashMap<String, Object> _result = new LinkedHashMap<String, Object>();
		
		// Product Configuration
		ProductConfiguration _productConfiguration = null;
		try {
			_productConfiguration = _productConfigurationLocalService.getConfigByCode("SA");
			
			if(_productConfiguration == null) {
				throw new Exception("Product configuration is not exist");
			}
		} catch (Exception e) {
			return errorMessage(e.getMessage()).toString();
		}
		
		// Currency
		String currency = params.getString("Currency");
		currency = currency.isEmpty() ? "IDR" : currency;
		
		MasterCurrency masterCurrency = null;
		
		try {
			masterCurrency = MasterCurrencyLocalServiceUtil.searchCurrency(currency);
			if(masterCurrency == null) {
				throw new Exception("Currency is not found");
			}
		} catch (Exception e) {
			return errorMessage(e.getMessage()).toString();
		}
		
		// Format Date
		String _startdateFormatted = "";
        String _enddateFormatted = "";
        
		String _startdateFormattedForPromoCode = "";
        String _enddateFormattedForPromoCode = "";
        
        try {
    		String startDate = params.getString("PeriodeFrom");
    		String endDate = params.getString("PeriodeTo");
    		
    		String startdateRaw = startDate.replaceAll("/", "-");
    		String formattedstartdate = helpers.parseDate(startdateRaw);
    		String enddateRaw = endDate.replaceAll("/", "-");
    		String formattedenddate = helpers.parseDate(enddateRaw);
    		
    		if(!startDate.isEmpty() && !endDate.isEmpty()) {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                DateTimeFormatter outputFormatterForPromoCode = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate _startdate = LocalDate.parse(formattedstartdate, inputFormatter);
                LocalDate _enddate = LocalDate.parse(formattedenddate, inputFormatter);
        		
        		_startdateFormatted = _startdate.format(outputFormatter);
                _enddateFormatted = _enddate.format(outputFormatter);
                
                _startdateFormattedForPromoCode = _startdate.format(outputFormatterForPromoCode);
                _enddateFormattedForPromoCode = _enddate.format(outputFormatterForPromoCode);
    		}
		} catch (Exception e) {
			return errorMessage(e.getMessage()).toString();
		}

		String mainBenefitValueStr = params.getString("MainBenefitValue");
		long mainBenefitValueLong = params.getLong("MainBenefitValue", 0);
		BigDecimal mainBenefitValue = null;
		if (mainBenefitValueStr != null && !mainBenefitValueStr.trim().isEmpty()) {
		    try {
		        mainBenefitValue = new BigDecimal(mainBenefitValueStr);
		    } catch (NumberFormatException e) {
		    	return errorMessage(e.getMessage()).toString();
		    }
		}
		
		if (mainBenefitValueLong < Long.valueOf(1)) {
			return errorMessage("Main Benefit Value is 0").toString();
		}
		
		if(mainBenefitValue == null) {
			return errorMessage("Main benefit is empty").toString();
		}
		
		// Smart Active Benefit Value
		SmartActiveBenefitValue _smartActiveBenefitValue = null;
		try {
			_smartActiveBenefitValue = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitByValue(mainBenefitValueLong);
			if(_smartActiveBenefitValue == null) {
				throw new Exception("SmartActiveBenefitValue is missing");
			}
		} catch (Exception e) {
			return errorMessage("SmartActiveBenefitValue is missing").toString();
		}
		
		
		long occupationId = params.getLong("Occupation");
		JSONArray additionalBenefits = params.getJSONArray("AdditionalBenefits");
		JSONArray additionalBenefitCodes = params.getJSONArray("AdditionalBenefitCodes");
		String _refferer = params.getString("Refferer", "");
        String _managedBy = params.getString("ManagedBy", "");
        String _businessModel = params.getString("BusinessModel", "");
        String _roleUser = params.getString("Role", "");
		
		SmartActiveOccupation _occupation = null;
		SmartActiveClassRate _classRate = null;
		try {
			_occupation = SmartActiveOccupationLocalServiceUtil.getSmartActiveOccupation(occupationId);
			_classRate = SmartActiveClassRateLocalServiceUtil.getSmartActiveClassRate(_occupation.getSmartActiveClassRateId());
		} catch (Exception e) {
			return errorMessage(e.getMessage()).toString();
		}
		
		// Benefit Types
		List<SmartActiveBenefitType> _benefitTypes = null;
		try {
			_benefitTypes = SmartActiveBenefitTypeLocalServiceUtil.getAllBenefitTypes();	
		} catch (Exception e) {
			return errorMessage(e.getMessage()).toString();
		}
		
		if(_benefitTypes == null) {
			return errorMessage("Benefit Type is empty").toString();
		}
		
		// Promocode
		String promoCode = params.getString("PromoCode");
		if(!promoCode.isEmpty()) {
			try {
				double promoCodeDiscount = 0.0;
				
				HashMap<String, Object> mainBody = new HashMap<String, Object>();
				mainBody.put("PromoCode", promoCode.toUpperCase());
				mainBody.put("ProductCode", "SA");
				
				String _channel = "DIRECT";
				if(!_roleUser.isEmpty()) {
					_channel = _roleUser;
				}
				
				mainBody.put("Channel", _channel);
				
				String _encryptedManagedBy = "";
				if(!_managedBy.isEmpty()) { 
					_encryptedManagedBy = _managedBy;
				}
				mainBody.put("ManagedBy", _encryptedManagedBy);
				
				mainBody.put("leadsStartDate", _startdateFormattedForPromoCode);
				mainBody.put("leadsExpiredDate", _enddateFormattedForPromoCode);
				
				Gson gson = new Gson();
				String payload = "";
				payload = gson.toJson(mainBody);
				
				if (helpers.isLog()) {
					_logs.info("------------------------------------------------------------------");
					_logs.info("PAYLOAD PROMOCODE");
					_logs.info(payload);
					_logs.info("------------------------------------------------------------------");
				}
				
				try {
					PIMCORE_ADDRESS = helpers.getPimcoreAddr();
					JSONObject _callAPI = null;
					_callAPI = helpers.callAPI(payload, PIMCORE_ADDRESS + CHECK_PROMOCODE_PIMCORE);
					
					if(_callAPI.getInt("Status") > 0) {
						promoCodeDiscount = _callAPI.getJSONObject("Data").getDouble("Discount");
						double _commisionFromResponsePromoCode = _callAPI.getJSONObject("Data").getJSONObject("Agent").getDouble("Commission");
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
					if (helpers.isLog()) _logs.info(e.getMessage());
					return errorMessage("Calculate with Promo Code Failed").toString();
				}
				
				// jumlah diskon dari response api promocode
				params.put("Discount", promoCodeDiscount);
				
			} catch (Exception e) {
				if (helpers.isLog()) _logs.info(e.getMessage());
				return errorMessage(e.getMessage()).toString();
			}
		}
		
		try {
			
			List<LinkedHashMap<String, Object>> _mainBenefit = new ArrayList<LinkedHashMap<String, Object>>();
			List<LinkedHashMap<String, Object>> _additionalBenefit = new ArrayList<LinkedHashMap<String, Object>>();
			
			BigDecimal grossPremium = BigDecimal.ZERO;
			BigDecimal totalMainBenefitPremium = BigDecimal.ZERO;
			BigDecimal totalAdditionalBenefitPremium = BigDecimal.ZERO;
			
			for(SmartActiveBenefitType _benefitType : _benefitTypes) {
				
				LinkedHashMap<String, Object> _rateItem = new LinkedHashMap<String, Object>();
				_rateItem.put("BenefitType", _benefitType.getNameId());
				
				// Benefits
				List<LinkedHashMap<String, Object>> _benefitList = new ArrayList<LinkedHashMap<String, Object>>(); 
				List<SmartActiveBenefit> _benefits = SmartActiveBenefitLocalServiceUtil.getBenefitByTypeId(_benefitType.getSmartActiveBenefitTypeId());
				
				int benefitIndex = 0;
				for(SmartActiveBenefit _benefit : _benefits) {
					
					if(!_benefitType.getNameId().equalsIgnoreCase("Jaminan Utama")) {
						
						boolean _exists = false;
						
						if(!_refferer.isEmpty() && _refferer.equalsIgnoreCase("pimcore")) {
							if (!Validator.isNull(additionalBenefitCodes)) {
								for (int i = 0; i < additionalBenefitCodes.length(); i++) {
									if(additionalBenefitCodes.getString(i).equalsIgnoreCase(_benefit.getExternalCode())) {
										_exists = true;
										break;
									}
								}
							}							
						} else {
							if (!Validator.isNull(additionalBenefits)) {
								for (int i = 0; i < additionalBenefits.length(); i++) {
									
									if(additionalBenefits.getLong(i) == _benefit.getSmartActiveBenefitId()) {
										_exists = true;
										break;
									}
								}
							}							
						}
						
						if (!_exists) {
							continue;
							}	
					}
					
					LinkedHashMap<String, Object> _benefitItem = new LinkedHashMap<String, Object>();
					_benefitItem.put("Name", _benefit.getNameId());
					
					SmartActivePremi _premi = SmartActivePremiLocalServiceUtil.getPremiByBenefitAndClassRate(_benefit.getSmartActiveBenefitId(), _classRate.getSmartActiveClassRateId());
					_benefitItem.put("Rate", _premi.getRate());
					
					double ratePercent = _premi.getRate() / 100;
					
					// Get main benefit value mapping
					// nilainya dikali persen masing-masing benefit sesuai limit
					SmartActiveBenefitValueMapping _smartActiveBenefitValueMapping =  SmartActiveBenefitValueMappingLocalServiceUtil.getBenefitValueMappingByBenefitIdAndBenefitValueId(_benefit.getSmartActiveBenefitId(), _smartActiveBenefitValue.getSmartActiveBenefitValueId());
					BigDecimal _mainBenefitValue = _smartActiveBenefitValueMapping.getLimitValue().setScale(0, RoundingMode.HALF_UP);
					
					BigDecimal calculatePremiWithRate = _mainBenefitValue.multiply(BigDecimal.valueOf(ratePercent)).setScale(0, RoundingMode.HALF_UP);
					_benefitItem.put("Premium", calculatePremiWithRate);
					_benefitItem.put("MainBenefitValue", mainBenefitValue);
					_benefitItem.put("LimitBenefitValue", _mainBenefitValue);
					_benefitItem.put("Code", _benefit.getExternalCode());
					
					_benefitList.add(_benefitItem);
					
					// kalau main benefit hanya hitung 1 untuk grossPremium
					if(_benefitType.getNameId().equalsIgnoreCase("Jaminan Utama")) {
						if(benefitIndex == 0) {
							grossPremium = grossPremium.add(calculatePremiWithRate);
							totalMainBenefitPremium = totalMainBenefitPremium.add(calculatePremiWithRate);
						}
					} else {
						grossPremium = grossPremium.add(calculatePremiWithRate);
						totalAdditionalBenefitPremium = totalAdditionalBenefitPremium.add(calculatePremiWithRate);
					}
					
					benefitIndex++;
				}
				
				_rateItem.put("BenefitList", _benefitList);
				
				if(_benefitType.getNameId().equalsIgnoreCase("Jaminan Utama")) {
					_mainBenefit.add(_rateItem);
				} else {
					_additionalBenefit.add(_rateItem);
				}
			}
			
			// Jaminan utama dari master data ada 2 item.
			// dimerge jadi satu, nama digabung dengan pemisah /
	        List<LinkedHashMap<String, Object>> mergedList = new ArrayList<>();

	        for (LinkedHashMap<String, Object> benefit : _mainBenefit) {
	            LinkedHashMap<String, Object> mergedBenefit = new LinkedHashMap<>(benefit);
	            List<LinkedHashMap<String, Object>> originalList = (List<LinkedHashMap<String, Object>>) benefit.get("BenefitList");

	            if (!originalList.isEmpty()) {
	                LinkedHashMap<String, Object> mergedItem = new LinkedHashMap<>(originalList.get(0));
	                StringBuilder mergedName = new StringBuilder((String) mergedItem.get("Name"));

	                for (int i = 1; i < originalList.size(); i++) {
	                    LinkedHashMap<String, Object> currentItem = originalList.get(i);
	                    mergedName.append(" / ").append(currentItem.get("Name"));
	                }

	                mergedItem.put("Name", mergedName.toString());

	                // Replacing BenefitList with the merged one
	                List<LinkedHashMap<String, Object>> newBenefitList = new ArrayList<>();
	                newBenefitList.add(mergedItem);
	                mergedBenefit.put("BenefitList", newBenefitList);
	            }

	            mergedList.add(mergedBenefit);
	        }
			
			LinkedHashMap<String, Object> _benefitRates = new LinkedHashMap<String, Object>();
			_benefitRates.put("MainBenefit", mergedList);
			_benefitRates.put("AdditionalBenefit", _additionalBenefit);
			
			_result.put("Benefits", _benefitRates);
			
			// Detail
			LinkedHashMap<String, Object> _detailItem = new LinkedHashMap<String, Object>();
			_detailItem.put("StartDate", _startdateFormatted);
			_detailItem.put("ExpiredDate", _enddateFormatted);
			_detailItem.put("SumInsured", mainBenefitValue);
			
			String _cr = _classRate.getNameId();
			int _crNumber = 1;
			if(_cr.equalsIgnoreCase("Tarif Kelas 1")) {
				_crNumber = 1;
			}
			if(_cr.equalsIgnoreCase("Tarif Kelas 2")) {
				_crNumber = 2;
			}
			if(_cr.equalsIgnoreCase("Tarif Kelas 3")) {
				_crNumber = 3;
			}
			
			_detailItem.put("OccupationClass", _crNumber);
			_detailItem.put("OccupationCode", _occupation.getCode());
			_detailItem.put("OccupationId", _occupation.getSmartActiveOccupationId());
			
			// Smart Active Topro
			SmartActiveTopro _smartActiveTopro = null;
			try {
				_smartActiveTopro = SmartActiveToproLocalServiceUtil.getToproByBenefitValue(_smartActiveBenefitValue.getSmartActiveBenefitValueId());
			} catch (Exception e) {
				return errorMessage("SmartActiveTopro is missing").toString();
			}
			
			if(_smartActiveTopro == null) {
				return errorMessage("SmartActiveTopro is missing").toString();
			}
			
			_detailItem.put("ToproCode", _smartActiveTopro.getTopro());
			_detailItem.put("TocCode", _smartActiveTopro.getToc());
			_result.put("Detail", _detailItem);
			
			// Perhitungan stampduty, policycost, net premium dll.
			double stampDutyIDR = _productConfiguration.getStampdutyIDR();
			double stampDutyUSD = _productConfiguration.getStampdutyUSD();
			double stampDuty = (currency.equalsIgnoreCase("idr")) ? stampDutyIDR : stampDutyUSD;
			double policyCostIDR = _productConfiguration.getPolicyCostIDR();
			double policyCostUSD = _productConfiguration.getPolicyCostUSD();
			double policyCost = (currency.equalsIgnoreCase("idr")) ? policyCostIDR : policyCostUSD;
			
			_result.put("Currency", masterCurrency.getName());
			_result.put("StampDuty", (masterCurrency.getName().equalsIgnoreCase("idr")) ? stampDutyIDR : stampDutyUSD);
			_result.put("PolicyCost", (masterCurrency.getName().equalsIgnoreCase("idr")) ? policyCostIDR : policyCostUSD);
	
			
			// hilangkan koma di gross premium
//			grossPremium = grossPremium.setScale(0, RoundingMode.HALF_UP);
			
			if (helpers.isLog()) {
				_logs.info("------------------------");
				_logs.info("GROSS");
				_logs.info(grossPremium);
			}
			
			double discount = params.getDouble("Discount", 0);
			double discountRate = discount / 100.0;
			
			BigDecimal discountAmount = grossPremium.multiply(BigDecimal.valueOf(discountRate));
//			discountAmount = discountAmount.setScale(0, RoundingMode.HALF_UP);
			
			if (helpers.isLog()) {
				_logs.info("------------------------");
				_logs.info("DISCOUNT AMOUNT");
				_logs.info(discountAmount);
			}
			
			BigDecimal discountedPremium = grossPremium.subtract(discountAmount);
//			discountedPremium = discountedPremium.setScale(0, RoundingMode.HALF_UP);
			
			if (helpers.isLog()) {
				_logs.info("------------------------");
				_logs.info("DISCOUNTED PREMIUM");
				_logs.info(discountedPremium);
			}
			
			BigDecimal roundedStampDuty = BigDecimal.valueOf(stampDuty).setScale(0, RoundingMode.HALF_UP);
			BigDecimal roundedPolicyCost = BigDecimal.valueOf(policyCost).setScale(0, RoundingMode.HALF_UP);
			
			BigDecimal netPremium = discountedPremium.add(roundedStampDuty).add(roundedPolicyCost);
			if (helpers.isLog()) {
				_logs.info("------------------------");
				_logs.info("NETPREMIUM BEFORE ROUND");
				_logs.info(netPremium);
			}
			
			netPremium = netPremium.setScale(0, RoundingMode.HALF_UP);
			
			if (helpers.isLog()) {
				_logs.info("------------------------");
				_logs.info("NETPREMIUM");
				_logs.info(netPremium);
			}
			
			BigDecimal netPremiumWithoutDiscount = grossPremium.add(roundedStampDuty).add(roundedPolicyCost).setScale(0, RoundingMode.HALF_UP);
			
			_result.put("Premium", grossPremium);
			_result.put("NetPremium", netPremium);
			_result.put("NetPremiumWithoutDiscount", netPremiumWithoutDiscount);
			
			_result.put("TotalMainBenefitPremium", totalMainBenefitPremium.setScale(0, RoundingMode.HALF_UP));
			_result.put("TotalAdditionalBenefitPremium", totalAdditionalBenefitPremium.setScale(0, RoundingMode.HALF_UP));
			
			double commission = params.getDouble("Commission", 0);
			double tax = params.getDouble("Tax", 0);
			BigDecimal commissionValue = new BigDecimal(0);
			BigDecimal taxValue = new BigDecimal(0);
			BigDecimal nettPremium = new BigDecimal(0);
			
			if(commission > 0) {
				double commissionPercentage = commission / 100.0;
				commissionValue = discountedPremium.multiply(BigDecimal.valueOf(commissionPercentage)).setScale(0, RoundingMode.HALF_UP);
				
				double taxRate = tax / 100.0;
				taxValue = commissionValue.multiply(BigDecimal.valueOf(taxRate)).setScale(0, RoundingMode.HALF_UP);
				
				// hitung nettpremi
		        nettPremium = discountedPremium.subtract(commissionValue).add(taxValue).add(roundedStampDuty).add(roundedPolicyCost);
			} else {
				// nettpremi diisi netpremium jika tidak ada komisi
				nettPremium = netPremium;
			}
			
			nettPremium = nettPremium.setScale(0, RoundingMode.HALF_UP);
			
			_result.put("Commission", commission);
			_result.put("CommissionValue", commissionValue);
			_result.put("Tax", tax);
			_result.put("TaxValue", taxValue);
			_result.put("NettPremium", nettPremium);
			
			_result.put("PromoCode", promoCode);
			_result.put("Discount", discount);
			_result.put("DiscountAmount", discountAmount);
			
			_result.put("BusinessModel", _businessModel);
			_result.put("ManagedBy", _managedBy);
			
			
			JSONObject _finalResult = JSONFactoryUtil.createJSONObject();
			_finalResult.put("Calculation", _result);
			
			response.put("Status", 1);
			response.put("Message", "Calculation success");
			response.put("Data", _finalResult);
			
			if (helpers.isLog()) _logs.info(response);
			
		} catch (Exception e) {
			return errorMessage(e.getMessage()).toString();
		}
		
		return response.toString();
	}

	public String initPurchase(String request, HttpServletRequest httpServletRequest) throws JSONException, IOException, ParseException {
		// init variables
		JSONObject params = null; // Incoming data payload from request
		JSONObject _response = JSONFactoryUtil.createJSONObject(); // JSON output API
		JSONObject _data = null; // data ini untuk di add ke localservice leads

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
		try {
			params = JSONFactoryUtil.createJSONObject(request);
			quotation = !params.getString("Quotation").isEmpty() && params.getString("Quotation").equals("1") ? true : false;

			serviceContext = ServiceContextFactory.getInstance(SmartActiveApplication.class.getName(),
					httpServletRequest);
			userId = serviceContext.getGuestOrUserId();
			_data = JSONFactoryUtil.createJSONObject();
		} catch (Exception e) {
			if (helpers.isLog()) _logs.info(e.getMessage());
			return errorMessage("Terjadi kesalahan, silakan coba beberapa saat lagi [IN01_01]").toString();
		}
		
		if (helpers.isLog()) {
			_logs.info("PARAM INITIATE");
			_logs.info(params);
		}

		// Product Code
		ProductConfiguration productConfig = _productConfigurationLocalService.getConfigByCode("SA"); 
		String productCode = "";
		if (!Validator.isNull(productConfig)) {
			productCode = productConfig.getProductCode();
		} else {
			return errorMessage("Data tidak tersedia [IN02_01 Produk Tidak Ditemukan]").toString();
		}
		
		JSONObject joPayloadtoscan = JSONFactoryUtil.createJSONObject();
		
		// Validate input
		boolean validateInput = validate.validateJSON(params);
		
		if (validateInput == false || Validator.isNull(params.getString("Quotation"))) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [IN03_01 Gagal Validasi Data]").toString();
		}
		
		//CHECK XSS 
		String sanitizedReqStrToKyc = "";
		try {
			if (quotation) {
				  joPayloadtoscan = params;
			} else {
				 joPayloadtoscan = JSONFactoryUtil.createJSONObject(params.getString("kyc"));
			}
			
	        Map<String, Object> payloadMap = ActionHelper.convertJsonToMap(joPayloadtoscan.toString());
	        
		    Map<String, Object> sanitizedPayload = XSSValidator.sanitizePayload(payloadMap);
		    ObjectMapper objectMapper = new ObjectMapper();
		    sanitizedReqStrToKyc = objectMapper.writeValueAsString(sanitizedPayload);
		} catch (Exception e) {
			if (helpers.isLog()) _logs.info(e.getMessage());
		    return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [IN03_02 Gagal Filter Data]").toString();
		}
		
		//paramSanitized adalah object yang sudah bersih siap untuk inject ke db
		JSONObject paramSanitized = JSONFactoryUtil.createJSONObject(sanitizedReqStrToKyc);
		
		if (paramSanitized.getInt("ExcludedActivityStatus") == 1) {
			return errorMessage("Maaf, kami tidak bisa menerima pengajuan Anda secara online saat ini. Silakan hubungi Customer Care Center kami di 1500 733 (Senin-Jumat, 08.00-17.00 WIB) untuk informasi lebih lanjut.").toString();
		}
		
		List<SmartActiveBenefitValue> benefitValues = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue();
		SmartActiveBenefitValue benefitValue = benefitValues.stream()
											   .filter(v -> v.getValue() == paramSanitized.getLong("MainBenefitValue"))
											   .findFirst().orElse(null);
		
		if (Validator.isNull(benefitValue) == true) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [IN03_03 Gagal Validasi Data]").toString();
		}
		
		// get payload kyc from step1
		String _dob = null;
		String _job = null;
		String _mainBenefitValue = null;
		int _excludedActivityStatus = 0;
		String _periodeMulai  = null;
		String _periodeAkhir = null;
		
		String AdditionalBenefits = null;
		
        try {
        	if (paramSanitized.has("Name") && quotation == false) _data.put("Name", paramSanitized.getString("Name"));
        	if (paramSanitized.has("Email") && quotation == false) _data.put("Email", paramSanitized.getString("Email").replace(" ", ""));
            _dob = paramSanitized.getString("Dob");
            _job = paramSanitized.getString("Job");
            _excludedActivityStatus = paramSanitized.getInt("ExcludedActivityStatus");
            _mainBenefitValue = paramSanitized.getString("MainBenefitValue");
            _periodeMulai = paramSanitized.getString("PeriodeFrom");
            _periodeAkhir = paramSanitized.getString("PeriodeTo");
            AdditionalBenefits = params.getString("AdditionalBenefits"); // ambil dari params asli bukan  dari paramSanitized. karena jika !quote , paramSanitized hanya object kyc tidak berisi additional benefit

            if (quotation) {
                leadsType = "quotation";
                _data.put("Name", paramSanitized.getString("Name"));
                _data.put("Email", paramSanitized.getString("Email").replace(" ", ""));
            }
        } catch (Exception e) {
            if (helpers.isLog()) _logs.info(e.getMessage());
            return errorMessage("Parameter filter data tidak tersedia [IN04]").toString();
        }

		if (!_dob.isEmpty()) {
			String dobRaw = _dob.replaceAll("/", "-");
			String formattedDob = helpers.parseDate(dobRaw);
			_data.put("Dob", formattedDob);
		}

		Long classRateId = null;
		if (!_job.isEmpty()) {
			String idJob = _job;
			List<SmartActiveOccupation> occupations = SmartActiveOccupationLocalServiceUtil.getActiveOccupation();
			SmartActiveOccupation targetOccupation = occupations.stream()
													 .filter(o -> o.getSmartActiveOccupationId() == Long.valueOf(idJob))
													 .findFirst().orElse(null);

			if (targetOccupation != null) {
				classRateId = targetOccupation.getSmartActiveClassRateId();
				_data.put("Job", targetOccupation.getNameId());
			}	
		}

		// Check param token
		// if exist, then this token will be used as param to edit leads
		if (!params.getString("Token").isEmpty()) {
			_leads = LeadsLocalServiceUtil.findByToken(params.getString("Token"));

			if (_leads != null) {
				if (params.has("Category") == false) {
					LeadsId = _leads.getLeadsId();
					_data.put("Token", params.getString("Token"));
				}
				
				if (params.has("Category") && params.getString("Category").equalsIgnoreCase("edit")) {
					_data.put("isPEP", _leads.getIsPep());
					_data.put("IdPhotoFileEntry", _leads.getIdPhotoFileEntryId());
					_data.put("PhotoFileUrl", _leads.getPhotoFileUrl());
					_data.put("Name", _leads.getName());
					_data.put("Nationality", _leads.getNationality());
					_data.put("IdNumber", _leads.getIdNumber());
					_data.put("KitasNumber", _leads.getKitasNumber());
					_data.put("Age", _leads.getAge());
					_data.put("BirthPlace", _leads.getBirthPlace());
					_data.put("Gender", _leads.getGender());
					_data.put("MobilePhone", _leads.getMobilePhone());
					_data.put("Email", _leads.getEmail());
					_data.put("Zip", _leads.getZip());
					_data.put("Province", _leads.getProvince());
					_data.put("City", _leads.getCity());
					_data.put("Address", _leads.getAddress());
					_data.put("WorkLocation", _leads.getWorkLocation());
					_data.put("WorkLocationOther", _leads.getWorkLocationOther());
					_data.put("MonthlyIncome", _leads.getMonthlyIncome());
					_data.put("PaymentSource", _leads.getPaymentSource());
					_data.put("PaymentSourceOther", _leads.getPaymentSourceOther());
					_data.put("Beneficiary", _leads.getBeneficiary());
					_data.put("BeneficiaryRelationship", _leads.getBeneficiaryRelationship());
				}
			}
		}
		
		if (params.has("Type")) {
			_data.put("isPEP", paramSanitized.getInt("IsPep"));
			
			long _imageId = 0;
			if (paramSanitized.has("ImageId")) {
				try {
					_imageId = Long.parseLong(EncryptionHelper.decrypt(paramSanitized.getString("ImageId")));
				} catch (Exception e) {
					if (helpers.isLog()) _logs.info(e.getMessage());
				}
				_data.put("IdPhotoFileEntry", _imageId);
				_data.put("PhotoFileUrl", paramSanitized.getString("PhotoFileUrl"));
			}
			
			_data.put("Nationality", paramSanitized.getString("Citizenship"));
			
			if (paramSanitized.getString("Citizenship").equalsIgnoreCase("Indonesia") == true) {
				_data.put("IdNumber", paramSanitized.getString("IdNum"));
			} else {
				_data.put("KitasNumber", paramSanitized.getString("IdNum"));
			}
			
			_data.put("Age", paramSanitized.getInt("Age"));
			_data.put("BirthPlace", paramSanitized.getString("Pob"));
			_data.put("Gender", paramSanitized.getString("Gender"));
			_data.put("MobilePhone", paramSanitized.getString("PhoneNumber"));
			_data.put("Zip", paramSanitized.getString("Zip"));
			_data.put("Province", paramSanitized.getString("Province"));
			_data.put("City", paramSanitized.getString("City"));
			_data.put("Address", paramSanitized.getString("Address"));
			_data.put("WorkLocation", paramSanitized.getString("WorkLocation"));
			_data.put("WorkLocationOther", paramSanitized.getString("AdditionalWorkLocation"));
			_data.put("MonthlyIncome", paramSanitized.getString("MonthlyIncome").replace("&lt;", "<").replace("&gt;", ">"));
			_data.put("PaymentSource", paramSanitized.getString("PaymentSource"));
			_data.put("PaymentSourceOther", paramSanitized.getString("AdditionalPaymentSource"));
			_data.put("Beneficiary", paramSanitized.getString("Beneficiary"));
			_data.put("BeneficiaryRelationship", paramSanitized.getString("BeneficiaryRelationship"));
		}

		String _managedBy = params.getString("ManagedBy");
		String _managedById = params.getString("ManagedById");
		String _role = params.getString("Role");
		String _businessModel = params.getString("BusinessModel");
		String _channel = "DIRECT";
		String _UtmSource = params.getString("UtmSource");
		String _UtmMedium = params.getString("UtmMedium");
		String _UtmCampaign = params.getString("UtmCampaign");
		String _UtmTerm = params.getString("UtmTerm");
		String _UtmContent = params.getString("UtmContent");

		if (_businessModel.equalsIgnoreCase("b2b") || _businessModel.equalsIgnoreCase("b2b2c")) {
			_channel = _role;
		}

		if (_businessModel.equalsIgnoreCase("b2b")) {
			isB2B = true;
		}

		// Check promocode param
		String promoCode = params.getString("PromoCode");

		_data.put("LeadsType", leadsType);
		_data.put("BussinesModel", _businessModel);
		_data.put("Channel", _channel);
		_data.put("ManagedBy", _managedBy);
		_data.put("ProductCode", productCode);
		_data.put("Active", 1);
		_data.put("UtmSource", _UtmSource);
		_data.put("UtmMedium", _UtmMedium);
		_data.put("UtmCampaign", _UtmCampaign);
		_data.put("UtmTerm", _UtmTerm);
		_data.put("UtmContent", _UtmContent);
		_data.put("PromoCode", promoCode);
		
		//==== PROMO CODE HERE ======
		
		//END PROMO CODE
		
		// Calculate premi di purchase detail
		// -------------------------------------------
		// tambahkan property SpesificPlan ke params
		// supaya hasil yang ditambahkan ke DB
		// sama dengan hasil yang keluar pada response calculate saat dipanggil pimcore
		
		String startdateRaw = _periodeMulai.replaceAll("/", "-");
		String formattedstartdate = helpers.parseDate(startdateRaw);
		Date startDatePeriod = null;

		String expdateRaw = _periodeAkhir.replaceAll("/", "-");
		String formattedexpdate = helpers.parseDate(expdateRaw);
		Date endDatePeriod = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			startDatePeriod = sdf.parse(formattedstartdate);
			endDatePeriod = sdf.parse(formattedstartdate);
		} catch(Exception e) {
			if (helpers.isLog()) _logs.info(e.getMessage());
		}
		
		LocalDate today = LocalDate.now();
		LocalDate startDatePeriodMaxLocal = today.plusDays(30);
		Date startDatePeriodMax = Date.from(startDatePeriodMaxLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		if (startDatePeriod.after(endDatePeriod) || startDatePeriod.after(startDatePeriodMax)) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [IN03_04 Periode Pertanggungan tidak sesuai]").toString();
		}
		
		boolean validAge = validateAge(startDatePeriod, _dob);
		
		if (validAge == false) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [IN03_05 Usia tidak sesuai]").toString();
		}
		
		String topro = StringPool.BLANK;
		String toc = StringPool.BLANK;
		
		try {
			JSONObject mainBody = GeneratePayloadCalculate(_job, _periodeMulai, _periodeAkhir, _mainBenefitValue, _managedBy, params.getJSONArray("AdditionalBenefits"), promoCode, _businessModel, _role);
			if (helpers.isLog()) {
				_logs.info("PAYLOAD CALCULATE DI TAHAP INITIATE:");
				_logs.info(mainBody);
			}
		    
		    JSONObject _callAPI = null;
		    
		    try {
		    	
		    	JSONObject responseCalculate = JSONFactoryUtil.createJSONObject();
		    	_callAPI = responseCalculate.put("response", calculate(mainBody.toString(), httpServletRequest));
		         
		    } catch (Exception e) {
		    	if (helpers.isLog()) {
		    		_logs.info(e.getMessage());
		    	}
		        return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [IN07_01]").toString();
		    }
		    
		    JSONObject createCalculateResponseDto = null;
			if (_callAPI.has("response")) createCalculateResponseDto = JSONFactoryUtil.createJSONObject(_callAPI.get("response").toString());
			
			if (Validator.isNull(createCalculateResponseDto)) {
				return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [IN07_02]").toString();
			}
		    
		    if (createCalculateResponseDto.getInt("Status") == 0) {
		    	return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [IN05_01 Calculate " + createCalculateResponseDto.getString("Message") + " ]").toString();
		    }
		    
		    JSONObject dataResponseDto = JSONFactoryUtil.createJSONObject(createCalculateResponseDto.get("Data").toString());
		    JSONObject calculationResponseDto = null;
		    JSONObject detailResponseDto = null;
		    
		    if (dataResponseDto.has("Calculation")) calculationResponseDto = JSONFactoryUtil.createJSONObject(dataResponseDto.get("Calculation").toString());
		    if (Validator.isNotNull(calculationResponseDto)) {
		    	_data.put("Currency", calculationResponseDto.get("Currency"));
		    	_data.put("PolicyCost", calculationResponseDto.get("PolicyCost"));
		    	_data.put("StampDuty", calculationResponseDto.get("StampDuty"));
		    	_data.put("Premium", calculationResponseDto.get("Premium"));
		    	_data.put("NetPremium", calculationResponseDto.get("NetPremium"));
		    	_data.put("Discount", calculationResponseDto.get("Discount"));
		    	_data.put("DiscountAmount", calculationResponseDto.get("DiscountAmount"));
		    	_data.put("Commission", calculationResponseDto.get("Commission"));

			    if (calculationResponseDto.has("Detail")) detailResponseDto = JSONFactoryUtil.createJSONObject(calculationResponseDto.get("Detail").toString());
			    if (Validator.isNotNull(detailResponseDto)) {
			    	topro = detailResponseDto.getString("ToproCode");
			    	toc = detailResponseDto.getString("TocCode");
			    }
		    }
		} catch (Exception e) {
		    if (helpers.isLog()) _logs.info(e.getMessage());
		}

		// Save leads
		Leads saveLeads = LeadsLocalServiceUtil.updateLeads(userId, quotation ? (long) 0 : LeadsId, _data, serviceContext);

		if (saveLeads == null) {
			return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [IN05_02]").toString();
		}

		// Save detail smartactive
		// ---------------------------------
		DetailSmartactive saveDetail = null;
		try {
			JSONObject _dataDetail = JSONFactoryUtil.createJSONObject();
			_dataDetail.put("LeadsId", saveLeads.getLeadsId());
			_dataDetail.put("ExcludedActivityStatus", _excludedActivityStatus);
			_dataDetail.put("JobType", _job);
			_dataDetail.put("MainBenefitValue", _mainBenefitValue);
			_dataDetail.put("StartPeriode", formattedstartdate);
			_dataDetail.put("EndPeriode", formattedexpdate);
			_dataDetail.put("ListBenefitId", AdditionalBenefits);

			long detailId = 0;
			if (LeadsId > 0) {
				DetailSmartactive _detailSA = DetailSmartactiveLocalServiceUtil.findByLeadsId(LeadsId);
				if (_detailSA != null) {
					detailId = _detailSA.getDetailId();
				}
			}

			saveDetail = DetailSmartactiveLocalServiceUtil.addDetail(userId, detailId, _dataDetail, serviceContext);
			
			if (Validator.isNull(saveDetail)) {
				return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [IN06_01 Detail Data]").toString();
			}
		} catch (Exception e) {
			// Failed to create detail Smart Active
			if (helpers.isLog()) _logs.info(e.getMessage());
			return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [IN06_02 Detail Data]").toString();
		}
		// END Save detail smartactive
		// ---------------------------------
		
		/**
		 * BUILD BENEFIT AGENT FOR SET TO SESSION , USE IN RIPLAY
		 */
		//JSONArray dataBenefitsAgent = buildBenefitsAgent(saveDetail.getListBenefitId(), saveDetail.getMainBenefitValue(), classRateId);
		
		// Send quotation to Pimcore
		if (quotation) {
			try {
				JSONObject mainBody = GeneratePayload(saveLeads, saveDetail, classRateId, "simple", _managedById, topro, toc, "");
				
				if (helpers.isLog()) {
					_logs.info("PARAMS QUOTE SIMPLE");
					_logs.info(mainBody.toString());
				}
			    
			    JSONObject _callAPI = null;

				if (params.has("Category") == false) {
				    try {
				    	
				    	PIMCORE_ADDRESS = helpers.getPimcoreAddr();
				    	
				        _callAPI = ActionHelper.hitAPI(PIMCORE_ADDRESS + CREATE_QUOTE_PIMCORE, mainBody.toString(), "");
				         
				    } catch (Exception e) {
				    	if (helpers.isLog()) {
				    		_logs.info(e.getMessage());
				    	}
				        return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [IN07_03]").toString();
				    }
				    
				    if (_callAPI.has("statusCode") && _callAPI.getInt("statusCode") != 200) {
			    		return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [IN07_04]").toString();
				    }
				    
				    JSONObject createQuoteResponseDto = null;
					if (_callAPI.has("response")) createQuoteResponseDto = JSONFactoryUtil.createJSONObject(_callAPI.get("response").toString());
					
					if (Validator.isNull(createQuoteResponseDto)) {
						return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [IN07_05]").toString();
					}
					
				    JSONObject blockedCustResponseDto = null;
				    if (createQuoteResponseDto.has("BlockedCustomer")) blockedCustResponseDto = JSONFactoryUtil.createJSONObject(createQuoteResponseDto.get("BlockedCustomer").toString());
				    
				    if (createQuoteResponseDto.getInt("Status") == 0) {
				    	JSONObject data = JSONFactoryUtil.createJSONObject();
				    	PIMCORE_HOST = helpers.getPimcoreHost();
				    	String errMsg = Validator.isNotNull(blockedCustResponseDto) == true ? blockedCustResponseDto.getString("Text") : createQuoteResponseDto.getString("Message");  
				    	
				    	if (Validator.isNotNull(blockedCustResponseDto) == true) {
				    		data.put("target", blockedCustResponseDto.getString("Redirect"));
				    		_response.put("Blocked", true);
				    	}
				        _response.put("Status", 0);
				        _response.put("Data", data);
				        _response.put("Message", errMsg);
				    } else {
				    	JSONObject data = JSONFactoryUtil.createJSONObject();
				    	PIMCORE_HOST = helpers.getPimcoreHost();
				    	
			    		data.put("target", PIMCORE_HOST + "/dashboard/leads/online");
				        _response.put("Data", data);
				        _response.put("Message", "Penawaran berhasil terkirim");
				        _response.put("Status", 1);
				    }
				} else {
					if (saveLeads.getLeadsId() > 0) {
						JSONObject responseData = JSONFactoryUtil.createJSONObject();
						responseData.put("Token", saveLeads.getToken());

						_response.put("Data", responseData);
						_response.put("Status", 1);
					} else {
						return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [IN05_03]").toString();
					}
				}
			} catch (Exception e) {
			    if (helpers.isLog()) _logs.info(e.getMessage());
			}
		} else {
			if (saveLeads.getLeadsId() > 0) {
				JSONObject responseData = JSONFactoryUtil.createJSONObject();
				responseData.put("Token", saveLeads.getToken());
				if (quotation) {
					responseData.put("LeadsId", saveLeads.getLeadsId());
				}

				_response.put("Status", 1);
				_response.put("Data", responseData);
				//_response.put("BenefitsAgent", dataBenefitsAgent);
			} else {
				return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [IN05_04]").toString();
			}
		}

		return _response.toString();
	}
	
	public String submitPurchase(String request, HttpServletRequest httpServletRequest) throws Exception {
		JSONObject params = JSONFactoryUtil.createJSONObject(request); // Incoming data payload from request
		JSONObject _response = JSONFactoryUtil.createJSONObject(); // JSON output API
		JSONObject _data = JSONFactoryUtil.createJSONObject(); // data ini untuk di add ke localservice leads
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SmartActiveApplication.class.getName(), httpServletRequest);
		
		String tokenLimiter = StringPool.BLANK;
		long userId = serviceContext.getGuestOrUserId();
		long agentTokenLimiterId = 0;
		long LeadsId = 0;
		boolean isB2B = false;
		boolean quotation = !params.getString("Quotation").isEmpty() && params.getString("Quotation").equals("1") ? true : false;
		String leadsType = quotation == true ? "quotation" : "kyc";
		
		if (helpers.isLog()) {
			_logs.info("PARAMS SUBMIT");
			_logs.info(params.toString());
		}
		
		Leads _leads = null;
		JSONObject payload = params;
		
		// Product Code
		ProductConfiguration productConfig = _productConfigurationLocalService.getConfigByCode("SA"); 
		String productCode = "";
		if (!Validator.isNull(productConfig)) {
			productCode = productConfig.getProductCode();
		} else {
			return errorMessage("Data tidak tersedia [SB02 Produk Tidak Ditemukan]").toString();
		}
		
		// Validate input
		boolean validateInput = validate.validateJSON(params);
		
		if (validateInput == false || Validator.isNull(params.getString("Quotation"))) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [SB03_01 Gagal Validasi Data]").toString();
		}
		
		// Check XSS
		String sanitizedPayload = StringPool.BLANK;
		try {
			payload = JSONFactoryUtil.createJSONObject(params.getString("kyc"));
			
	        Map<String, Object> payloadMap = ActionHelper.convertJsonToMap(payload.toString());
		    Map<String, Object> sanitizedPayloadMap = XSSValidator.sanitizePayload(payloadMap);
		    
		    ObjectMapper objectMapper = new ObjectMapper();
		    sanitizedPayload = objectMapper.writeValueAsString(sanitizedPayloadMap);
		} catch (Exception e) {
			if (helpers.isLog()) _logs.info(e.getMessage());
		    return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [SB03_02 Gagal Filter Data]").toString();
		}
		
		//paramSanitized adalah object yang sudah bersih siap untuk inject ke db
		JSONObject paramSanitized = JSONFactoryUtil.createJSONObject(sanitizedPayload);
		
		if (paramSanitized.getInt("ExcludedActivityStatus") == 1) {
			return errorMessage("Maaf, kami tidak bisa menerima pengajuan Anda secara online saat ini. Silakan hubungi Customer Care Center kami di 1500 733 (Senin-Jumat, 08.00-17.00 WIB) untuk informasi lebih lanjut.").toString();
		}
		
		if (quotation) {
			List<SmartActiveBenefitValue> benefitValues = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue();
			SmartActiveBenefitValue benefitValue = benefitValues.stream()
												   .filter(v -> v.getValue() == paramSanitized.getLong("MainBenefitValue"))
												   .findFirst().orElse(null);
			
			if (Validator.isNull(benefitValue) == true) {
				return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [SB03_03 Gagal Validasi Data]").toString();
			}
		}
		
		_data.put("LeadsType", leadsType);
		_data.put("isPEP", paramSanitized.getInt("IsPep"));
		
		long _imageId = 0;
		if (paramSanitized.has("ImageId")) {
			_imageId = Long.parseLong(EncryptionHelper.decrypt(paramSanitized.getString("ImageId")));
			_data.put("IdPhotoFileEntry", _imageId);
			_data.put("PhotoFileUrl", paramSanitized.getString("PhotoFileUrl"));
		}
		
		_data.put("Name", paramSanitized.getString("Name"));
		_data.put("Nationality", paramSanitized.getString("Citizenship"));
		
		if (paramSanitized.getString("Citizenship").equalsIgnoreCase("Indonesia") == true) {
			_data.put("IdNumber", paramSanitized.getString("IdNum"));
		} else {
			_data.put("KitasNumber", paramSanitized.getString("IdNum"));
		}
		
		String _dob = paramSanitized.getString("Dob");

		if (!_dob.isEmpty()) {
			String dobRaw = _dob.replaceAll("/", "-");
			String formattedDob = helpers.parseDate(dobRaw);
			_data.put("Dob", formattedDob);
		}
		
		_data.put("Age", paramSanitized.getInt("Age"));
		_data.put("BirthPlace", paramSanitized.getString("Pob"));
		_data.put("Gender", paramSanitized.getString("Gender"));
		_data.put("MobilePhone", paramSanitized.getString("PhoneNumber"));
		_data.put("Email", paramSanitized.getString("Email").replace(" ", ""));
		_data.put("Zip", paramSanitized.getString("Zip"));
		_data.put("Province", paramSanitized.getString("Province"));
		_data.put("City", paramSanitized.getString("City"));
		_data.put("Address", paramSanitized.getString("Address"));
		_data.put("Job", paramSanitized.getString("Job").replace("&amp;", "&"));
		
		boolean validJobId = validJob(paramSanitized.getString("Job"));
		
		if (validJobId) {
			String idJob = paramSanitized.getString("Job");
			List<SmartActiveOccupation> occupations = SmartActiveOccupationLocalServiceUtil.getActiveOccupation();
			SmartActiveOccupation targetOccupation = occupations.stream()
													 .filter(o -> o.getSmartActiveOccupationId() == Long.valueOf(idJob))
													 .findFirst().orElse(null);

			if (targetOccupation != null) {
				_data.put("Job", targetOccupation.getNameId());
			}	
		}
		
		_data.put("WorkLocation", paramSanitized.getString("WorkLocation"));
		_data.put("WorkLocationOther", paramSanitized.getString("AdditionalWorkLocation"));
		_data.put("MonthlyIncome", paramSanitized.getString("MonthlyIncome").replace("&lt;", "<").replace("&gt;", ">"));
		_data.put("PaymentSource", paramSanitized.getString("PaymentSource"));
		_data.put("PaymentSourceOther", paramSanitized.getString("AdditionalPaymentSource"));
		_data.put("Beneficiary", paramSanitized.getString("Beneficiary"));
		_data.put("BeneficiaryRelationship", paramSanitized.getString("BeneficiaryRelationship"));
		
		if ((paramSanitized.getString("Citizenship").equalsIgnoreCase("Indonesia") == true && paramSanitized.getString("IdNum").length() != 16) ||
			(paramSanitized.getString("Citizenship").equalsIgnoreCase("Indonesia") == false && paramSanitized.getString("IdNum").length() > 25)) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [SB03_04 Nomor Identitas tidak sesuai]").toString();
		}
		
		if (paramSanitized.getString("Zip").length() < 5) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [SB03_05 Kode Pos tidak sesuai]").toString();
		}

		// Check param token
		// if exist, then this token will be used as param to edit leads
		if (!params.getString("Token").isEmpty()) {
			_leads = LeadsLocalServiceUtil.findByToken(params.getString("Token"));

			if (_leads != null) {
				LeadsId = _leads.getLeadsId();
				_data.put("Token", params.getString("Token"));
			}
		}
		
		int _excludedActivityStatus = 0;
		String _mainBenefitValue = paramSanitized.getString("MainBenefitValue");
		String _additionalBenefits = StringPool.BLANK;
        String _periodeMulai = paramSanitized.getString("PeriodeFrom");
        String _periodeAkhir = paramSanitized.getString("PeriodeTo");
		
		String startdateRaw = _periodeMulai.replaceAll("/", "-");
		String formattedstartdate = helpers.parseDate(startdateRaw);
		Date startDatePeriod = null;

		String expdateRaw = _periodeAkhir.replaceAll("/", "-");
		String formattedexpdate = helpers.parseDate(expdateRaw);
		Date endDatePeriod = null;

		// Check promocode param
		String promoCode = paramSanitized.getString("PromoCode");
		String _managedBy = paramSanitized.getString("ManagedBy");
		String _managedById = paramSanitized.getString("ManagedById");
		String _role = paramSanitized.getString("Role");
		String _businessModel = paramSanitized.getString("BusinessModel");
		String topro = StringPool.BLANK;
		String toc = StringPool.BLANK;

//		if (quotation || params.has("Category")) {
			_excludedActivityStatus = paramSanitized.getInt("ExcludedActivityStatus");
			_additionalBenefits = paramSanitized.getString("AdditionalBenefits");
			String _channel = "DIRECT";
			String _UtmSource = paramSanitized.getString("UtmSource");
			String _UtmMedium = paramSanitized.getString("UtmMedium");
			String _UtmCampaign = paramSanitized.getString("UtmCampaign");
			String _UtmTerm = paramSanitized.getString("UtmTerm");
			String _UtmContent = paramSanitized.getString("UtmContent");
	
			if (_businessModel.equalsIgnoreCase("b2b") || _businessModel.equalsIgnoreCase("b2b2c")) {
				_channel = _role;
			}
	
			if (_businessModel.equalsIgnoreCase("b2b")) {
				isB2B = true;
			}

			_data.put("LeadsType", leadsType);
			_data.put("BussinesModel", _businessModel);
			_data.put("Channel", _channel);
			_data.put("ManagedBy", _managedBy);
			_data.put("ProductCode", productCode);
			_data.put("Active", 1);
			_data.put("UtmSource", _UtmSource);
			_data.put("UtmMedium", _UtmMedium);
			_data.put("UtmCampaign", _UtmCampaign);
			_data.put("UtmTerm", _UtmTerm);
			_data.put("UtmContent", _UtmContent);
			_data.put("PromoCode", promoCode);
//		}
		
		try {
			long _job = validJobId ? paramSanitized.getLong("Job") : SmartActiveOccupationLocalServiceUtil.getActiveOccupation().stream()
						.filter(v -> v.getNameId().equalsIgnoreCase(paramSanitized.getString("Job").replace("&amp;", "&")))
						.findFirst().get().getSmartActiveOccupationId();
			
			JSONObject mainBody = GeneratePayloadCalculate(String.valueOf(_job), _periodeMulai, _periodeAkhir, _mainBenefitValue, _managedBy, paramSanitized.getJSONArray("AdditionalBenefits"), promoCode, _businessModel, _role);

			if (helpers.isLog()) {
				_logs.info("PAYLOAD CALCULATE SUBMIT");
				_logs.info(mainBody.toString());
			}
			
		    JSONObject _callAPI = null;
		    
		    try {
		    	
		    	JSONObject responseCalculate = JSONFactoryUtil.createJSONObject();
		    	_callAPI = responseCalculate.put("response", calculate(mainBody.toString(), httpServletRequest));
		         
		    } catch (Exception e) {
		    	if (helpers.isLog()) {
		    		_logs.info(e.getMessage());
		    	}
		        return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [SB07_01]").toString();
		    }
		    
		    JSONObject createCalculateResponseDto = null;
			if (_callAPI.has("response")) createCalculateResponseDto = JSONFactoryUtil.createJSONObject(_callAPI.get("response").toString());
			
			if (Validator.isNull(createCalculateResponseDto)) {
				return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [SB07_02]").toString();
			}
		    
		    if (createCalculateResponseDto.getInt("Status") == 0) {
		    	return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [SB05_01 Calculate " + createCalculateResponseDto.getString("Message") + " ]").toString();
		    }
		    
		    JSONObject dataResponseDto = JSONFactoryUtil.createJSONObject(createCalculateResponseDto.get("Data").toString());
		    JSONObject calculationResponseDto = null;
		    JSONObject detailResponseDto = null;
		    
		    if (dataResponseDto.has("Calculation")) calculationResponseDto = JSONFactoryUtil.createJSONObject(dataResponseDto.get("Calculation").toString());
		    
		    if (Validator.isNotNull(calculationResponseDto)) {
		    	_data.put("Currency", calculationResponseDto.get("Currency"));
		    	_data.put("PolicyCost", calculationResponseDto.get("PolicyCost"));
		    	_data.put("StampDuty", calculationResponseDto.get("StampDuty"));
		    	_data.put("Premium", calculationResponseDto.get("Premium"));
		    	_data.put("NetPremium", calculationResponseDto.get("NetPremium"));
		    	_data.put("Discount", calculationResponseDto.get("Discount"));
		    	_data.put("DiscountAmount", calculationResponseDto.get("DiscountAmount"));
		    	_data.put("Commission", calculationResponseDto.get("Commission"));

			    if (calculationResponseDto.has("Detail")) detailResponseDto = JSONFactoryUtil.createJSONObject(calculationResponseDto.get("Detail").toString());
			    
			    if (Validator.isNotNull(detailResponseDto)) {
			    	topro = detailResponseDto.getString("ToproCode");
			    	toc = detailResponseDto.getString("TocCode");
			    }
		    }
		} catch (Exception e) {
		    if (helpers.isLog()) _logs.info(e.getMessage());
		}
			
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			startDatePeriod = sdf.parse(formattedstartdate);
			endDatePeriod = sdf.parse(formattedstartdate);
		} catch(Exception e) {
			if (helpers.isLog()) _logs.info(e.getMessage());
		}
		
		LocalDate today = LocalDate.now();
		LocalDate startDatePeriodMaxLocal = today.plusDays(30);
		Date startDatePeriodMax = Date.from(startDatePeriodMaxLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		if (startDatePeriod.after(endDatePeriod) || startDatePeriod.after(startDatePeriodMax)) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [SB03_06 Periode Pertanggungan tidak sesuai]").toString();
		}
		
		DetailSmartactive detail = LeadsId > 0 ? DetailSmartactiveLocalServiceUtil.findByLeadsId(LeadsId) : null;
		
		boolean validAge = Validator.isNotNull(detail) == true ? validateAge(detail.getStartPeriode(), _dob) : validateAge(startDatePeriod, _dob);
		
		if (validAge == false) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [SB03_07 Usia tidak sesuai]").toString();
		}
		
		// Save leads
		Leads saveLeads = LeadsLocalServiceUtil.updateLeads(userId, quotation ? (long) 0 : LeadsId, _data, serviceContext);

		if (Validator.isNull(saveLeads)) {
			return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [SB05_02]").toString();
		}
		
//		if (quotation || params.has("Category")) {
			try {
				long _job = SmartActiveOccupationLocalServiceUtil.getActiveOccupation().stream()
							.filter(v -> v.getNameId().equalsIgnoreCase(saveLeads.getJob()))
							.findFirst().get().getSmartActiveOccupationId();
				
				JSONObject _dataDetail = JSONFactoryUtil.createJSONObject();
				_dataDetail.put("LeadsId", saveLeads.getLeadsId());
				_dataDetail.put("ExcludedActivityStatus", _excludedActivityStatus);
				_dataDetail.put("JobType", _job);
				_dataDetail.put("MainBenefitValue", _mainBenefitValue);
				_dataDetail.put("StartPeriode", formattedstartdate);
				_dataDetail.put("EndPeriode", formattedexpdate);
				_dataDetail.put("ListBenefitId", _additionalBenefits);
	
				long detailId = 0;
				if (LeadsId > 0) {
					DetailSmartactive _detailSA = DetailSmartactiveLocalServiceUtil.findByLeadsId(LeadsId);
					if (_detailSA != null) {
						detailId = _detailSA.getDetailId();
					}
				}
	
				detail = DetailSmartactiveLocalServiceUtil.addDetail(userId, detailId, _dataDetail, serviceContext);
				
				if (Validator.isNull(detail)) {
					return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [SB06_01 Detail Data]").toString();
				}
			} catch (Exception e) {
				// Failed to create detail Smart Active
				if (helpers.isLog()) _logs.info(e.getMessage());
				return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [SB06_02 Detail Data]").toString();
			}
//		}
		
		long classRateId = SmartActiveOccupationLocalServiceUtil.getActiveOccupation().stream()
						   .filter(v -> v.getNameId().equalsIgnoreCase(saveLeads.getJob()))
						   .findFirst().get().getSmartActiveClassRateId();
		
		JSONObject mainBody = GeneratePayload(saveLeads, detail, classRateId, "full", _managedById, topro, toc, "");
		
	    JSONObject _callAPI = null;
		JSONObject blockedCustResponseDto = null;
		JSONObject pepCustResponseDto = null;
			
		if (quotation == false) {
		    try {
		    	PIMCORE_ADDRESS = helpers.getPimcoreAddr();
		    	
		    	if (helpers.isLog()) {
		    		_logs.info("PAYLOAD VALIDATE PIMCORE");
			    	_logs.info(mainBody.toString());
		    	}
		    	
		        _callAPI = ActionHelper.hitAPI(PIMCORE_ADDRESS + VALIDATE, mainBody.toString(), "");
		        
		    } catch (Exception e) {
		    	if (helpers.isLog()) {
		    		_logs.info(e.getMessage());
		    	}
		        return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [SB07_03]").toString();
		    }
		    
		    if (_callAPI.has("statusCode") && _callAPI.getInt("statusCode") != 200) {
	    		return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [SB07_04]").toString();
		    }
		    
			JSONObject validateResponseDto = null;
			if (_callAPI.has("response")) validateResponseDto = JSONFactoryUtil.createJSONObject(_callAPI.get("response").toString());
			
			if (Validator.isNull(validateResponseDto)) {
				return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [SB07_05]").toString();
			}
			
			if (validateResponseDto.has("BlockedCustomer")) blockedCustResponseDto = JSONFactoryUtil.createJSONObject(validateResponseDto.get("BlockedCustomer").toString());
			if (validateResponseDto.has("PepCustomer")) pepCustResponseDto = JSONFactoryUtil.createJSONObject(validateResponseDto.get("PepCustomer").toString());
		    
		    if (validateResponseDto.getInt("Status") == 0) {
		    	JSONObject data = JSONFactoryUtil.createJSONObject();
		    	String target = Validator.isNotNull(blockedCustResponseDto) ? blockedCustResponseDto.getString("Redirect") :
		    					Validator.isNotNull(pepCustResponseDto) ? pepCustResponseDto.getString("Redirect") : "";
		    	String msg = Validator.isNotNull(blockedCustResponseDto) ? blockedCustResponseDto.getString("Text") :
		    				 Validator.isNotNull(pepCustResponseDto) ? pepCustResponseDto.getString("Text") :
	    					 validateResponseDto.getString("Message");
		    	
		    	if (Validator.isNotNull(target)) {
		    		data.put("target", target);
		    		_response.put("Data", data);
		    	}
		        _response.put("Status", 0);
		        _response.put("Message", msg);
		        if (Validator.isNotNull(blockedCustResponseDto)) _response.put("Blocked", true);
		        if (Validator.isNotNull(pepCustResponseDto)) _response.put("Pep", true);
		        
		        return _response.toString(); 
		    }
	    }
		
		// Send quotation to Pimcore
		if (quotation) {
		    try {
		    	PIMCORE_ADDRESS = helpers.getPimcoreAddr();
		    	
		    	if (helpers.isLog()) {
		    		_logs.info("PAYLOAD QUOTATION PIMCORE");
			    	_logs.info(mainBody.toString());
		    	}
		    	
		        _callAPI = ActionHelper.hitAPI(PIMCORE_ADDRESS + CREATE_QUOTE_PIMCORE, mainBody.toString(), "");
		         
		    } catch (Exception e) {
		    	if (helpers.isLog()) {
		    		_logs.info(e.getMessage());
		    	}
		        return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [SB07_06]").toString();
		    }
		    
		    if (_callAPI.has("statusCode") && _callAPI.getInt("statusCode") != 200) {
	    		return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [SB07_07]").toString();
		    }
		    
    		JSONObject createQuoteResponseDto = null;
			if (_callAPI.has("response")) createQuoteResponseDto = JSONFactoryUtil.createJSONObject(_callAPI.get("response").toString());
			
			if (Validator.isNull(createQuoteResponseDto)) {
				return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [SB07_08]").toString();
			}
			
    		if (createQuoteResponseDto.has("BlockedCustomer")) blockedCustResponseDto = JSONFactoryUtil.createJSONObject(createQuoteResponseDto.get("BlockedCustomer").toString());
    		if (createQuoteResponseDto.has("PepCustomer")) pepCustResponseDto = JSONFactoryUtil.createJSONObject(createQuoteResponseDto.get("PepCustomer").toString());
		    
		    if (createQuoteResponseDto.getInt("Status") == 0) {
		    	JSONObject data = JSONFactoryUtil.createJSONObject();
		    	String errMsg = Validator.isNotNull(blockedCustResponseDto) == true ? blockedCustResponseDto.getString("Text") :
		    					Validator.isNotNull(pepCustResponseDto) ? pepCustResponseDto.getString("Text") :
		    					createQuoteResponseDto.getString("Message");
		    	
		    	if (Validator.isNotNull(blockedCustResponseDto) == true) {
		    		data.put("target", blockedCustResponseDto.getString("Redirect"));
		    		_response.put("Blocked", true);
			        _response.put("Data", data);
		    	}
		    	
		    	if (Validator.isNotNull(pepCustResponseDto) == true) {
		    		data.put("target", pepCustResponseDto.getString("Redirect"));
		    		_response.put("Pep", true);
			        _response.put("Data", data);
		    	}
		    	
		        _response.put("Status", 0);
		        _response.put("Message", errMsg);
		    } else {
		    	JSONObject data = JSONFactoryUtil.createJSONObject();
		    	PIMCORE_HOST = helpers.getPimcoreHost();
		    	String msg = StringPool.BLANK;

		    	if (params.has("Category") == false) {
		    		msg = "Penawaran berhasil terkirim";
		    		data.put("target", PIMCORE_HOST + "/dashboard/leads/online");
			        _response.put("Data", data);
		    	}
		    	
		        _response.put("Status", 1);
		        _response.put("Message", msg);
		    }
		} else {
			if (params.has("Category") == true) {
				if (saveLeads.getLeadsId() > 0) {
					JSONObject responseData = JSONFactoryUtil.createJSONObject();
					responseData.put("Token", saveLeads.getToken());
	
					_response.put("Data", responseData);
				} else {
					return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [SB05_03]").toString();
				}
			}
			
			_response.put("Status", 1);
			_response.put("Message", "");
		}
		
		return _response.toString(); 
	}
	
	public String process(String request, HttpServletRequest httpServletRequest) throws Exception {
		JSONObject params = JSONFactoryUtil.createJSONObject(request); // Incoming data payload from request
	    JSONObject _response = JSONFactoryUtil.createJSONObject();
	    
        Leads _leads = null;
	    
	    // Validate input
 		boolean validateInput = validate.validateJSON(params);
 		
 		if (validateInput == false) {
 			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [PR01_01 Gagal Validasi Data]").toString();
 		}
 		
 		// Check XSS
 		String sanitizedPayload = StringPool.BLANK;
 		try {
 		    JSONObject payload = params;
 		    
 	        Map<String, Object> payloadMap = ActionHelper.convertJsonToMap(payload.toString());
 		    Map<String, Object> sanitizedPayloadMap = XSSValidator.sanitizePayload(payloadMap);
 		    
 		    ObjectMapper objectMapper = new ObjectMapper();
 		    sanitizedPayload = objectMapper.writeValueAsString(sanitizedPayloadMap);
 		} catch (Exception e) {
 			if (helpers.isLog()) _logs.info(e.getMessage());
 		    return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [PR02_01 Gagal Filter Data]").toString();
 		}
 		
 		//paramSanitized adalah object yang sudah bersih siap untuk inject ke db
 		JSONObject paramSanitized = JSONFactoryUtil.createJSONObject(sanitizedPayload);
 		
 		if (paramSanitized.getInt("ExcludedActivityStatus") == 1) {
 			return errorMessage("Maaf, kami tidak bisa menerima pengajuan Anda secara online saat ini. Silakan hubungi Customer Care Center kami di 1500 733 (Senin-Jumat, 08.00-17.00 WIB) untuk informasi lebih lanjut.").toString();
 		}
 		
		List<SmartActiveBenefitValue> benefitValues = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue();
		SmartActiveBenefitValue benefitValue = benefitValues.stream()
											   .filter(v -> v.getValue() == paramSanitized.getLong("MainBenefitValue"))
											   .findFirst().orElse(null);
		
		if (Validator.isNull(benefitValue) == true) {
			return errorMessage("Verifikasi data gagal, pastikan data telah sesuai [PR01_02 Gagal Validasi Data]").toString();
		}
	    
	    try {
	    	if (!params.getString("Token").isEmpty()) {
				_leads = LeadsLocalServiceUtil.findByToken(params.getString("Token"));
			}
	    	
	    	String _job = paramSanitized.getString("Job");
	    	String _mainBenefitValue = paramSanitized.getString("MainBenefitValue");
	        String _periodeMulai = paramSanitized.getString("PeriodeFrom");
	        String _periodeAkhir = paramSanitized.getString("PeriodeTo");
			String _managedBy = paramSanitized.getString("ManagedBy");
			String _managedById = params.getString("ManagedById");
			String _role = params.getString("Role");
			String _leadsTemp = params.getString("LeadsTemp");
			String _promoCode = paramSanitized.getString("PromoCode");
			String _businessModel = paramSanitized.getString("BusinessModel");
	    	String topro = StringPool.BLANK;
			String toc = StringPool.BLANK;
			
			JSONObject mainBody = GeneratePayloadCalculate(_job, _periodeMulai, _periodeAkhir, _mainBenefitValue, _managedBy, paramSanitized.getJSONArray("AdditionalBenefits"), _promoCode, _businessModel, _role);
		    
		    JSONObject _callAPI = null;
		    
		    try {
		    	
		    	JSONObject responseCalculate = JSONFactoryUtil.createJSONObject();
		    	_callAPI = responseCalculate.put("response", calculate(mainBody.toString(), httpServletRequest));
		         
		    } catch (Exception e) {
		    	if (helpers.isLog()) {
		    		_logs.info(e.getMessage());
		    	}
		        return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [PR03_01]").toString();
		    }
		    
		    JSONObject createCalculateResponseDto = null;
			if (_callAPI.has("response")) createCalculateResponseDto = JSONFactoryUtil.createJSONObject(_callAPI.get("response").toString());
			
			if (Validator.isNull(createCalculateResponseDto)) {
				return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [PR03_02]").toString();
			}
		    
		    if (createCalculateResponseDto.getInt("Status") == 0) {
		    	return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [PR02_02 Calculate " + createCalculateResponseDto.getString("Message") + " ]").toString();
		    }
		    
		    JSONObject dataResponseDto = JSONFactoryUtil.createJSONObject(createCalculateResponseDto.get("Data").toString());
		    JSONObject calculationResponseDto = null;
		    JSONObject detailResponseDto = null;
		    
		    if (dataResponseDto.has("Calculation")) calculationResponseDto = JSONFactoryUtil.createJSONObject(dataResponseDto.get("Calculation").toString());
		    
		    if (Validator.isNotNull(calculationResponseDto)) {
			    if (calculationResponseDto.has("Detail")) detailResponseDto = JSONFactoryUtil.createJSONObject(calculationResponseDto.get("Detail").toString());
			    
			    if (Validator.isNotNull(detailResponseDto)) {
			    	topro = detailResponseDto.getString("ToproCode");
			    	toc = detailResponseDto.getString("TocCode");
			    }
		    }
	        
	        if (!Validator.isNull(_leads)) {
	            DetailSmartactive _detailSA = DetailSmartactiveLocalServiceUtil.findByLeadsId(_leads.getLeadsId());
	            
	            // Simpan nilai job ke dalam variabel final sebelum digunakan dalam lambda
	            final String job = _leads.getJob();

	            long classRateId = SmartActiveOccupationLocalServiceUtil.getActiveOccupation().stream()
	                       .filter(v -> v.getNameId().equalsIgnoreCase(job))
	                       .findFirst()
	                       .map(v -> v.getSmartActiveClassRateId())
	                       .orElseThrow(() -> new Exception("Class rate ID not found"));

	            mainBody = GeneratePayload(_leads, _detailSA, classRateId, "", _managedById, topro, toc, _leadsTemp);
	            
	            try {
	                PIMCORE_ADDRESS = helpers.getPimcoreAddr();
	                
	                if (helpers.isLog()) {
	                	_logs.info("PAYLOAD PAYMENT PROCESS");
		                _logs.info(mainBody.toString());
	                }
	                
	                _callAPI = ActionHelper.hitAPI(PIMCORE_ADDRESS + KYC_PAYMENT_PIMCORE, mainBody.toString(), "");
	                 
	            } catch (Exception e) {
	                if (helpers.isLog()) {
	                	_logs.info(e.getMessage());
	                }
	                return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [PR03_03]").toString();
	            }
	            
	            if (_callAPI.has("statusCode") && _callAPI.getInt("statusCode") != 200) {
		    		return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [PR03_04]").toString();
			    }
	            
	            String redirectTo = "";
					
				JSONObject responsePimcoreData = null;
				if (_callAPI.has("response")) responsePimcoreData = JSONFactoryUtil.createJSONObject(_callAPI.get("response").toString());
				
				if (Validator.isNull(responsePimcoreData)) {
					return errorMessage("Gagal request ke server, silakan coba beberapa saat lagi [PR03_05]").toString();
				}
				
				if (responsePimcoreData.getInt("Status") == 0) {
			    	return errorMessage("Submit data Anda ditolak, pastikan data telah sesuai [PR02_03 Payment " + responsePimcoreData.getString("Message") + " ]").toString();
			    }
				
				JSONObject _d = responsePimcoreData.getJSONObject("Data");
				String _tokenForPayment = _d.getString("Token");
				
				PIMCORE_HOST = helpers.getPimcoreHost();
				
				redirectTo = PIMCORE_HOST + "/payment/process" + "/" + _tokenForPayment;
					
				_response.put("Status", true);
				_response.put("Message", "");
				_response.put("RedirectTarget", redirectTo);
	        } else {
	            _response.put("Status", false);
	            _response.put("Message", "Data Leads tidak ditemukan [PR04_01]");
	        }
	        
	    } catch (Exception e) {
	        _response.put("Status", false);
	        _response.put("Message", "Data Leads tidak ditemukan [PR04_02]");
	    }
	    
	    return _response.toString();
	}
	
	private JSONObject GeneratePayloadCalculate(String job, String startDate, String expiredDate, String benefitValue, String managedBy, JSONArray additionalBenefit, String promoCode, String businessModel, String role) throws JSONException {
		  
		 JSONArray benefit = additionalBenefit;
		 List<String> listBenefit = new ArrayList<>();
		 
		 if (benefit.length() > 0) {
			 for (int j = 0; j < benefit.length(); j++) {
				 SmartActiveBenefit _benefit = SmartActiveBenefitLocalServiceUtil.fetchSmartActiveBenefit(benefit.getLong(j));
				 listBenefit.add(_benefit.getExternalCode());
			 }
		 }
		
		 String joinBenefit = "[" + listBenefit.stream()
		 						.map(String::valueOf)
		 						.collect(Collectors.joining(","))
		 						+ "]";
		
		JSONObject mainBody = JSONFactoryUtil.createJSONObject();
		mainBody.put("Refferer", "Pimcore");
		mainBody.put("Occupation", job);
		mainBody.put("PeriodeFrom", startDate);
		mainBody.put("PeriodeTo", expiredDate);
		mainBody.put("MainBenefitValue", benefitValue);
		mainBody.put("ManagedBy", managedBy);
		mainBody.put("Role", role);
		mainBody.put("PromoCode", promoCode);
		mainBody.put("AdditionalBenefitCodes", JSONFactoryUtil.createJSONArray(joinBenefit));
		mainBody.put("BusinessModel", businessModel);
		
		return mainBody;
	}
	
	private JSONObject GeneratePayload(Leads saveLeads, DetailSmartactive saveDetail, long classRateId, String quotationType, String managedById, String topro, String toc, String leadsTemp) throws JSONException { 
		
		JSONObject mainBody = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(quotationType)) mainBody.put("QuotationType", quotationType);
		if (Validator.isNotNull(leadsTemp)) mainBody.put("LeadsTemp", leadsTemp);
		try {
			mainBody.put("LiferayId", EncryptionHelper.encryptRandom(String.valueOf(saveLeads.getLeadsId())));
		} catch (Exception e) {
			if (helpers.isLog()) _logs.info(e.getMessage());
		}
		mainBody.put("ManagedBy", saveLeads.getManagedBy());
		mainBody.put("ManagedById", managedById);
		mainBody.put("PdCode", saveLeads.getProductCode());
		mainBody.put("Channel", saveLeads.getChannel());
		mainBody.put("Currency", saveLeads.getCurrency());
		mainBody.put("StampDuty", saveLeads.getStampDuty());
		mainBody.put("PolicyCost", saveLeads.getPolicyCost());
		mainBody.put("Premium", saveLeads.getPremium());
		mainBody.put("NetPremium", saveLeads.getNetPremium());
		mainBody.put("PromoCode", saveLeads.getPromoCode());
		mainBody.put("Discount", saveLeads.getDiscount());
		mainBody.put("DiscountAmount", saveLeads.getDiscountAmount());
		mainBody.put("Commission", saveLeads.getCommission());
		mainBody.put("BussinesModel", saveLeads.getBussinesModel());
		mainBody.put("CommercialOffers", 1);
		mainBody.put("UserCustom", "");
		mainBody.put("UtmSource", saveLeads.getUtmSource());
		mainBody.put("UtmMedium", saveLeads.getUtmMedium());
		mainBody.put("UtmCampaign", saveLeads.getUtmCampaign());
		mainBody.put("UtmTerm", saveLeads.getUtmTerm());
		mainBody.put("UtmContent", saveLeads.getUtmContent());
		mainBody.put("ClickId", "");
		
		// Detail
		JSONObject detailBody = JSONFactoryUtil.createJSONObject();
		detailBody.put("SumInsured", saveDetail.getMainBenefitValue());
		detailBody.put("StartDate", ActionHelper._customFormatDate(saveDetail.getStartPeriode()));
		detailBody.put("ExpiredDate", ActionHelper._customFormatDate(saveDetail.getEndPeriode()));
		//detailBody.put("ExcludedActivityStatus", saveDetail.getExcludedActivityStatus());
		
		SmartActiveOccupation jobOcpp = SmartActiveOccupationLocalServiceUtil.fetchSmartActiveOccupation(saveDetail.getJobType());
		SmartActiveClassRate classRate = SmartActiveClassRateLocalServiceUtil.fetchSmartActiveClassRate(jobOcpp.getSmartActiveClassRateId());
		
		detailBody.put("OccupationClass", Integer.valueOf(classRate.getNameId().replaceAll("[^0-9]", ""))); //Tarif Kelas 1 -> 1 . ambil cuma angka 1
		detailBody.put("OccupationCode", jobOcpp.getCode());
		detailBody.put("OccupationId", saveDetail.getJobType());
		detailBody.put("ToproCode", topro); //belum fix
		detailBody.put("TocCode", toc); //belum fix. default dummy 1026
		mainBody.put("Detail", detailBody);
		
		// GET Benefit DARI FUNGSI getBenefit
		BenefitDTO getBenefit = getBenefit(saveDetail, classRateId); 
		
		Gson gson = new Gson();
		String benefitJson = gson.toJson(getBenefit);
		mainBody.put("Benefits", JSONFactoryUtil.createJSONObject(benefitJson));
		
		// Insured
	    JSONObject insuredBody = JSONFactoryUtil.createJSONObject();
	    insuredBody.put("Name", saveLeads.getName());
	    insuredBody.put("Email", saveLeads.getEmail());
	    
	    Date dob = saveLeads.getDob();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    String formattedDob = dateFormat.format(dob);

	    insuredBody.put("Dob", formattedDob);
	    insuredBody.put("Job", jobOcpp.getNameId());
	    
	    if (!quotationType.equalsIgnoreCase("simple")) { // full / payment
	    	insuredBody.put("IsPep", saveLeads.getIsPep());
	    	insuredBody.put("Gender", saveLeads.getGender());
	    	insuredBody.put("BirthPlace", saveLeads.getBirthPlace());
	    	insuredBody.put("Age", saveLeads.getAge());
	    	insuredBody.put("IdNumber", saveLeads.getIdNumber());
	    	insuredBody.put("KitasNumber", saveLeads.getKitasNumber());
	    	insuredBody.put("Address", saveLeads.getAddress());
	    	insuredBody.put("Province", saveLeads.getProvince());
	    	insuredBody.put("City", saveLeads.getCity());
	    	insuredBody.put("Zip", saveLeads.getZip());
	    	insuredBody.put("MobilePhone", saveLeads.getMobilePhone().replace("+", ""));
	    	insuredBody.put("NationalityCountry", saveLeads.getNationality());
	    	insuredBody.put("Nationality", saveLeads.getNationality().equalsIgnoreCase("Indonesia") == true ? "WNI" : "WNA");
	    	insuredBody.put("WorkLocation", saveLeads.getWorkLocation());
	    	insuredBody.put("WorkLocationOther", saveLeads.getWorkLocationOther());
	    	insuredBody.put("SourcePayment", saveLeads.getPaymentSource());
	    	insuredBody.put("SourcePaymentOther", saveLeads.getPaymentSourceOther());
	    	insuredBody.put("Salary", saveLeads.getMonthlyIncome());
	    	insuredBody.put("Beneficiary", saveLeads.getBeneficiary());
	    	insuredBody.put("BeneficiaryRelationship", saveLeads.getBeneficiaryRelationship());
	    	insuredBody.put("IdPhotoUrl", saveLeads.getPhotoFileUrl());
	    }
	    
	    mainBody.put("Insured", insuredBody);
		
		return mainBody;
	}

	private BenefitDTO getBenefit(DetailSmartactive saveDetail, long classRateId) {
		
		// Mendapatkan daftar manfaat yang aktif
		List<SmartActiveBenefit> benefits = SmartActiveBenefitLocalServiceUtil.getActiveBenefit();
		List<SmartActiveBenefit> mainCover = new ArrayList<>();
		
		// Mendapatkan daftar tipe manfaat yang aktif
		List<SmartActiveBenefitType> benefitTypes = SmartActiveBenefitTypeLocalServiceUtil.getActiveBenefitType();
	
		// Iterasi melalui setiap tipe manfaat
		for (SmartActiveBenefitType item : benefitTypes) {
			List<SmartActiveBenefit> filteredList = benefits.stream()
													.filter(v -> v.getSmartActiveBenefitTypeId() == item.getSmartActiveBenefitTypeId())
													.map(v -> {
														 try {
															 String encryptedId = EncryptionHelper.encrypt(String.valueOf(v.getSmartActiveBenefitId()));
															 v.setUserName(encryptedId);
														 } catch (Exception e) {
															 if (helpers.isLog()) _logs.info(e.getMessage());
														 }
														 return v;
									    	        }).collect(Collectors.toList());
	
		    // Memasukkan ke dalam kategori masing-masing
		    switch (item.getNameId().toLowerCase()) {
		        case "jaminan utama":
		            mainCover.addAll(filteredList);
		            break;      
		    }
		}
		
		List<SmartActivePremi> premiTable = SmartActivePremiLocalServiceUtil.getActivePremi();
		SmartActivePremi premiBenefit = null;
		
		// Data MainBenefit
	    List<BenefitDetailDTO> mainBenefits = new ArrayList<>();
	    List<BenefitListDTO> mainBenefitList = new ArrayList<>();
	    List<String> benefitName = new ArrayList<>();
		
	    Set<String> processedCodes = new HashSet<>(); // Menyimpan kode yang sudah diproses
	    for (SmartActiveBenefit benefit : mainCover) {
	    	benefitName.add(benefit.getNameId());
	        if (!processedCodes.contains(benefit.getExternalCode())) {
	        	premiBenefit = premiTable.stream()
			                   .filter(v -> v.getSmartActiveBenefitId() == benefit.getSmartActiveBenefitId() 
			                           && v.getSmartActiveClassRateId() == classRateId)
			                   .findFirst()
			                   .orElse(null);
			
	            // get benefit value
	            SmartActiveBenefitValue benefitValue = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue().stream()
	            									   .filter(v -> Long.valueOf(v.getValue()).equals(Long.parseLong(saveDetail.getMainBenefitValue())))
	        									   	   .findFirst()
	    									   	   	   .orElse(null);
	
	            SmartActiveBenefitValueMapping valueMapping = SmartActiveBenefitValueMappingLocalServiceUtil.getAllBenefitValueMappings().stream()
	                										  .filter(vm -> vm.getSmartActiveBenefitId() == benefit.getSmartActiveBenefitId()
	                										  		  && vm.getSmartActiveBenefitValueId() == benefitValue.getSmartActiveBenefitValueId())
	                										  .findFirst().orElse(null);
	                
	            String rateStr = String.valueOf(premiBenefit.getRate());
	            
	            double ratePercent = premiBenefit.getRate() / 100;
	            
				BigDecimal _mainBenefitValue = valueMapping.getLimitValue().setScale(0, RoundingMode.HALF_UP);
	        
	            BigDecimal manfaatUtama = new BigDecimal(saveDetail.getMainBenefitValue());
	            BigDecimal rate = new BigDecimal(rateStr);
	            BigDecimal premi = _mainBenefitValue.multiply(BigDecimal.valueOf(ratePercent)).setScale(0, RoundingMode.HALF_UP);
	            BigDecimal limit = _mainBenefitValue;
	
	            mainBenefitList.add(new BenefitListDTO(premi, limit, manfaatUtama, benefit.getExternalCode(), rate, benefit.getNameId()));
	        }
	        
	        processedCodes.add(benefit.getExternalCode()); // Tambahkan kode ke set setelah diproses
	    }
	
	    BenefitDetailDTO mainBenefitDetail = new BenefitDetailDTO();
	    mainBenefitDetail.setBenefitType("Jaminan Utama");
	    for (BenefitListDTO list : mainBenefitList) {
	    	list.setName(String.join(" dan ", benefitName));
	    }
	    mainBenefitDetail.setBenefitList(mainBenefitList);
	    mainBenefits.add(mainBenefitDetail);
	
		//ADDITIONAL BENEFIT
		// Data AdditionalBenefit
	    List<BenefitDetailDTO> additionalBenefits = new ArrayList<>();
	    List<BenefitListDTO> allowanceBenefitList = new ArrayList<>();
	    List<BenefitListDTO> otherBenefitList = new ArrayList<>();
	
	     // Pastikan string bukan "[]" sebelum diproses
	     if (saveDetail.getListBenefitId() != null && !saveDetail.getListBenefitId().equals("[]")) {
	         List<String> benefitList = Arrays.asList(saveDetail.getListBenefitId().replaceAll("[\\[\\]\\s]", "").split(","));
	
	         for (String benefitAddId : benefitList) {
	             if (benefitAddId.isEmpty()) continue; // Skip jika string kosong
	
	             SmartActiveBenefit benefit = SmartActiveBenefitLocalServiceUtil.fetchSmartActiveBenefit(Long.parseLong(benefitAddId.trim()));
	             String benefitTypeName = SmartActiveBenefitTypeLocalServiceUtil.fetchSmartActiveBenefitType(benefit.getSmartActiveBenefitTypeId()).getNameId();
	
	             premiBenefit = premiTable.stream()
	                     .filter(v -> v.getSmartActiveBenefitId() == Long.valueOf(benefit.getSmartActiveBenefitId())  
	                               && v.getSmartActiveClassRateId() == classRateId)
	                     .findFirst()
	                     .orElse(null);
	
	             // Get benefit value
	             SmartActiveBenefitValue benefitValue = SmartActiveBenefitValueLocalServiceUtil.getActiveBenefitValue()
	                     .stream()
	                     .filter(v -> Long.valueOf(v.getValue()).equals(Long.parseLong(saveDetail.getMainBenefitValue())))
	                     .findFirst()
	                     .orElse(null);
	
	             // Cari dari table benefit value mapping
	             SmartActiveBenefitValueMapping valueMapping = SmartActiveBenefitValueMappingLocalServiceUtil
	                     .getAllBenefitValueMappings().stream()
	                     .filter(vm -> vm.getSmartActiveBenefitId() == benefit.getSmartActiveBenefitId()
	                               && vm.getSmartActiveBenefitValueId() == benefitValue.getSmartActiveBenefitValueId())
	                     .findFirst().orElse(null);
	
	             String rateStr = String.valueOf(premiBenefit.getRate());
	             
	             double ratePercent = premiBenefit.getRate() / 100;
	             
	             BigDecimal _mainBenefitValue = valueMapping.getLimitValue().setScale(0, RoundingMode.HALF_UP);
	
	             BigDecimal manfaatUtama = new BigDecimal(saveDetail.getMainBenefitValue());
	             BigDecimal rate = new BigDecimal(rateStr); // Rate dalam persen
	             BigDecimal premi = _mainBenefitValue.multiply(BigDecimal.valueOf(ratePercent)).setScale(0, RoundingMode.HALF_UP);
	             BigDecimal limit = _mainBenefitValue;
	
	             if (benefitTypeName.equalsIgnoreCase("santunan")) {
	            	 allowanceBenefitList.add(new BenefitListDTO(premi, limit, manfaatUtama, benefit.getExternalCode(), rate, benefit.getNameId()));
	             } else {
	            	 otherBenefitList.add(new BenefitListDTO(premi, limit, manfaatUtama, benefit.getExternalCode(), rate, benefit.getNameId()));
	             }
	         }
	     }
	     
	     BenefitDetailDTO allowanceBenefitDetail = new BenefitDetailDTO();
	     allowanceBenefitDetail.setBenefitType("Santunan");
	     allowanceBenefitDetail.setBenefitList(allowanceBenefitList);
	     additionalBenefits.add(allowanceBenefitDetail);
	     
	     BenefitDetailDTO otherBenefitDetail = new BenefitDetailDTO();
	     otherBenefitDetail.setBenefitType("Jaminan Lainnya");
	     otherBenefitDetail.setBenefitList(otherBenefitList);
	     additionalBenefits.add(otherBenefitDetail);
	     
		
		// Create BenefitDTO
	    BenefitDTO benefitDTO = new BenefitDTO(mainBenefits, additionalBenefits);
		Gson gson = new Gson();
		
	    // Print the size of each list
	    if (helpers.isLog()) _logs.info("Benefit: " + gson.toJson(benefitDTO));
	    
	    return benefitDTO;
	}
	
	private boolean validateAge(Date startDate, String birthDate) {
		Date startPeriod = startDate;
		String strDateofBirth = birthDate.replaceAll("/", "-");
		Date dateOfBirth = null;
		
		String formattedDob = helpers.parseDate(strDateofBirth);
		
		if (Validator.isNull(formattedDob)) return false;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			dateOfBirth = sdf.parse(formattedDob);
		} catch(Exception e) {
			if (helpers.isLog()) _logs.info(e.getMessage());
			return false;
		}
		
		Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        cal1.setTime(dateOfBirth);

        Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        cal2.setTime(startPeriod);
		
		ZonedDateTime birthDateTime = cal1.toInstant().atZone(ZoneId.of("Asia/Jakarta"));
        ZonedDateTime startDateTime = cal2.toInstant().atZone(ZoneId.of("Asia/Jakarta"));

        long ageInDays = ChronoUnit.DAYS.between(birthDateTime, startDateTime);
        long ageInYears = ChronoUnit.YEARS.between(birthDateTime, startDateTime);
        
        ZonedDateTime lastBirthday = birthDateTime.plus(ageInYears, ChronoUnit.YEARS);
        long extraDays = (long) (startDateTime.getDayOfYear() - lastBirthday.getDayOfYear());
		
		return !(ageInDays < 30 || ageInYears > 75 || (ageInYears == 75 && extraDays > 0));
	}
	
	private boolean validJob(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	private static JSONObject errorMessage(String message) {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		_response.put("Status", 0);
		_response.put("Message", message);
		_response.put("Data", "");

		return _response;
	}
	
	private static String PIMCORE_HOST;

	private static String PIMCORE_ADDRESS;
	
	private static final ActionHelper helpers = new ActionHelper();
	
	private static final ValidationHelper validate = new ValidationHelper();
	
	private static final String CREATE_QUOTE_PIMCORE = helpers.getConfig("smartactive.api.leads.createQuote");
	
	private static final String VALIDATE = helpers.getConfig("smartactive.api.leads.validate");
	
	private static final String KYC_PAYMENT_PIMCORE = helpers.getConfig("smarttravel.api.payment");
	
	private static final String CHECK_PROMOCODE_PIMCORE = helpers.getConfig("smarttravel.api.leads.checkPromoCode");

	private static final Log _logs = LogFactoryUtil.getLog(TransactionService.class);
	
	@Reference
	private ProductConfigurationLocalService _productConfigurationLocalService;
}
