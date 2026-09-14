//package com.axa.payment.portlet.action;
//
//import com.axa.payment.constants.ProductPortletKeys;
//import com.axa.payment.dto.PolicyDto;
//import com.axa.payment.dto.ProductSummaryDto;
//import com.axa.payment.dto.SettlementDto;
//import com.axa.payment.dto.eip.BodyDto;
//import com.axa.payment.dto.eip.CustomerDto;
//import com.axa.payment.dto.eip.PolicyAccountDto;
//import com.axa.payment.dto.eip.ResponseDto;
//import com.axa.payment.helpers.ActionHelper;
//import com.axa.payment.helpers.EncryptionHelper;
//import com.google.gson.Gson;
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.json.JSONFactoryUtil;
//import com.liferay.portal.kernel.json.JSONObject;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.Validator;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//
////@Component(
////	immediate = true,
////	property = {
////		"javax.portlet.name=" + ProductPortletKeys.PRODUCT,
////		"mvc.command.name=/data/productsummary"
////	},
////	service = MVCResourceCommand.class
////)
//public class ProductMVCResourceCommand extends BaseMVCResourceCommand {
//	private static String apiURL;
//	private static String bodyOperation;
//	private static String bodyService;
//	private static String policyNo;
//	private static String profileId;
//	private static ActionHelper helper = new ActionHelper();
//	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
//	private static String mode = helper.getConfig("com.axa.payment.mode");
//	private static Log _log = LogFactoryUtil.getLog(ProductMVCResourceCommand.class);
//	private static Gson gson = new Gson();
//
//	@Override
//	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
////		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(resourceResponse);
//		JSONObject _response = JSONFactoryUtil.createJSONObject();
//		JSONObject _data = JSONFactoryUtil.createJSONObject();
//		
////		TokenDto token = helper.CheckToken(httpRequest);
////		
////		if (token.getToken() == null || token.isValid() == false) {
////			Cookie[] cookies = httpRequest.getCookies();
////	        	
////			if (cookies != null) {
////				for (Cookie cookie : cookies) {
////					if ("ACCESS_TOKEN".equals(cookie.getName()) || "TOKEN_EXP".equals(cookie.getName())) {
////						cookie.setMaxAge(0);
////						cookie.setPath("/");
////						httpResponse.addCookie(cookie);
////					}
////				}
////			}
////			 
////			JSONObject _data = JSONFactoryUtil.createJSONObject();
////			pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
////			
////			_data.put("target", pimcoreHost.concat("/smartpay"));
////			_response.put("status", false);
////			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
////			_response.put("data", _data);
////
////			resourceResponse.getWriter().write(_response.toString());
////			return;
////		}
////		
////		if (helper.isLog()) _log.info(token.getToken());
//		 
//		HttpSession session = httpRequest.getSession();
//		policyNo = (String) session.getAttribute("POLICY_NUMBER");
//		profileId = (String) session.getAttribute("PROFILE_ID");
//		
//		if (helper.isLog()) _log.info("SESSION ID: " + session.getId());
//		if (helper.isLog()) _log.info(policyNo);
//		if (helper.isLog()) _log.info(profileId);
//		
//		if (Validator.isNull(policyNo) == true && Validator.isNull(profileId) == true) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay") : "/signin-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		String channel = (String) session.getAttribute("CHANNEL");
//		if (Validator.isNotNull(channel) == true) session.removeAttribute("CHANNEL");
//		
//		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
//		if (Validator.isNotNull(invoiceNumber) == true) session.removeAttribute("INVOICE_NUMBER");
//		
//		String vaBca = (String) session.getAttribute("BCA");
//		if (Validator.isNotNull(vaBca) == true) session.removeAttribute("BCA");
//		
//		String vaMandiri = (String) session.getAttribute("MANDIRI");
//		if (Validator.isNotNull(vaMandiri) == true) session.removeAttribute("MANDIRI");
//		
//		ProductSummaryDto productSummary = getProductSummary(httpRequest);
//
//		if (Validator.isNull(productSummary.getFullName()) == true) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay") : "/signin-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//			
//			session.invalidate();
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		_response.put("status", true);
//		_response.put("message", "");
//		_response.put("data", gson.fromJson(gson.toJson(productSummary), Object.class));
//		
//		resourceResponse.getWriter().write(_response.toString());
//	}
//	
//	protected ProductSummaryDto getProductSummary(HttpServletRequest httpRequest) throws Exception {
//		CustomerDto bodyCustomer = new CustomerDto();
//		List<PolicyAccountDto> bodyPolicies = new ArrayList<PolicyAccountDto>();
//		PolicyAccountDto bodyPolicy = new PolicyAccountDto();
//		ProductSummaryDto productSummary = new ProductSummaryDto();
//		
//		bodyOperation = "getPolicyDetail";
//		bodyService = "getPolicyDetails";
//		
//		BodyDto requestBody = helper.setupRequestBody(bodyOperation, bodyService);
//		
//		bodyPolicy.setPolicyNO(EncryptionHelper.decrypt(policyNo));
//		bodyPolicy.setAccountNo(EncryptionHelper.decrypt(profileId));
//		bodyPolicies.add(bodyPolicy);
//		bodyCustomer.setHasPolicyAccount(bodyPolicies);
//		requestBody.setCustomer(bodyCustomer);
//		
//		apiURL = helper.getConfig("com.axa.payment.config.eipApiPolicyManagementUrl");
//		
//		ResponseDto response = gson.fromJson(helper.getConfigDummy(), ResponseDto.class); // helper.setupCallAPI(apiURL, bodyOperation, requestBody, httpRequest);
//		
//		if (helper.isLog()) _log.info(gson.fromJson(gson.toJson(response), Object.class));
//		
//		if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getCustomer()) == true) {
//			return productSummary;
//		}
//		
//		if (response.getBody().getCustomer().getHaveCommunicatedMessage().get(0).getDeliveryStatusCD() == 200) {
//			SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MM-yyyy");
//			SimpleDateFormat outputFormatterPeriod = new SimpleDateFormat("dd MMM yyyy");
//			SimpleDateFormat outputFormatterDue = new SimpleDateFormat("dd / MMM / yyyy");
//			
//			List<PolicyDto> policies = new ArrayList<PolicyDto>();
//			SettlementDto settlement = new SettlementDto();
//			
//			String formattedPolicyDue = StringPool.BLANK;
//			String vaBca = StringPool.BLANK;
//			String vaMandiri = StringPool.BLANK;
//			String dueDate = StringPool.BLANK;
//			double unpaid = 0;
//			
//			for (PolicyAccountDto item : response.getBody().getCustomer().getHasPolicyAccount().get(0).getHasCustomerInformationIn().get(0).getHasPolicyAccount()) {
//				PolicyDto policy = new PolicyDto();
//				
//				Date policyDue = inputFormatter.parse(item.getPolicyDueDt());
//				formattedPolicyDue = outputFormatterDue.format(policyDue);
//				
////				if (item.getPolicyStatusCD().equalsIgnoreCase("overdue") == false) {
//					policy.setDueDate(formattedPolicyDue.toUpperCase());
//					policy.setAmount(item.getTargetPremiumAmt());
//					policy.setStatus(item.getPolicyStatusCD().equalsIgnoreCase("paid") == true ? "LUNAS" :
//									 item.getPolicyStatusCD().equalsIgnoreCase("unpaid") == true ? "BELUM JATUH TEMPO" :
//									 item.getPolicyStatusCD().equalsIgnoreCase("waiting payment") == true ? "MENUNGGU PEMBAYARAN" :
//									 item.getPolicyStatusCD().toUpperCase());
////				}
//				
////				if (policy.getAmount() > 0)
//				policies.add(policy);
//				
//				if (item.getPolicyStatusCD().equalsIgnoreCase("unpaid")) {
//					unpaid += item.getTargetPremiumAmt();
//					settlement.setUnpaid(unpaid);
//				}
//				
//				if (item.getPolicyStatusCD().equalsIgnoreCase("waiting payment")) {
//					dueDate = item.getPolicyDueDt();
//					double nettPremi = item.getPremiumAMT() + item.getPolicyFeeAmt() + item.getStampDutyAmt();
//					
//					if (Validator.isNotNull(item.getPolicyRK())) settlement.setInstallment(helper.extractInstallment(item.getPolicyRK()));
//					settlement.setAmount(item.getPremiumAMT());
//					settlement.setStampDuty(item.getStampDutyAmt());
//					settlement.setPolicyCost(item.getPolicyFeeAmt());
//					settlement.setNettoPremium(nettPremi);
//					settlement.setDiscount(item.getDiscountAMT());
//					settlement.setGrossPremium(nettPremi - item.getDiscountAMT());
//				}
//				
//				if (Validator.isNotNull(item.getHasBilling().getRemark1())) vaBca = item.getHasBilling().getRemark1();
//				if (Validator.isNotNull(item.getHasBilling().getRemark2())) vaMandiri = item.getHasBilling().getRemark2();
//			}
//			
//			String fullName = response.getBody().getCustomer()
//							  .getHasPolicyAccount().get(0)
//							  .getHasCustomerInformationIn().get(0)
//							  .getCanBeIndividual().getFullNM();
//			
//			String email = response.getBody().getCustomer()
//						   .getHasPolicyAccount().get(0)
//						   .getHasCustomerInformationIn().get(0)
//						   .getCanBeIndividual().getHasAddressesIn().get(0).getEmailAddress();
//			
//			String phone = response.getBody().getCustomer()
//						   .getHasPolicyAccount().get(0)
//						   .getHasCustomerInformationIn().get(0)
//						   .getCanBeIndividual().getHasAddressesIn().get(0).getMobilePhoneNO();
//			
//			Date effectivePeriod = inputFormatter.parse(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPolicyEffectiveDTTM());
//			Date expirationPeriod = inputFormatter.parse(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPolicyExpirationDTTM());
//			String formattedEffectivePeriod = outputFormatterPeriod.format(effectivePeriod);
//			String formattedExpirationPeriod = outputFormatterPeriod.format(expirationPeriod);
//			String policyPeriod = formattedEffectivePeriod.concat(" - ").concat(formattedExpirationPeriod);
//			
//			HttpSession session = httpRequest.getSession();
//			if (Validator.isNotNull(fullName)) session.setAttribute("FULLNAME", EncryptionHelper.encrypt(fullName));
//			if (Validator.isNotNull(email)) session.setAttribute("EMAIL", EncryptionHelper.encrypt(email));
//			if (Validator.isNotNull(phone)) session.setAttribute("PHONE", EncryptionHelper.encrypt(phone));
//			if (Validator.isNotNull(vaBca)) session.setAttribute("BCA", EncryptionHelper.encrypt(vaBca));
//			if (Validator.isNotNull(vaMandiri)) session.setAttribute("MANDIRI", EncryptionHelper.encrypt(vaMandiri));
//			session.setAttribute("AMOUNT", settlement.getAmount());
//			if (Validator.isNotNull(response.getBody().getCustomer().getHasPolicyAccount().get(0).getHasDetailsOfPolicyTransactionIn().get(0).getReferenceNO())) session.setAttribute("REFERENCE", EncryptionHelper.encrypt(response.getBody().getCustomer().getHasPolicyAccount().get(0).getHasDetailsOfPolicyTransactionIn().get(0).getReferenceNO()));
//			session.setAttribute("DUE_DATE", dueDate);
//			
//			productSummary.setFullName(Validator.isNotNull(fullName) ? fullName.length() > 46 ? helper.obfuscateFullName(fullName).substring(0, 46).concat("....") : helper.obfuscateFullName(fullName) : "");
//			productSummary.setEmailAddress(Validator.isNotNull(email) ? helper.obfuscateEmail(email) : "");
//			productSummary.setMobileNumber(Validator.isNotNull(phone) ? helper.obfuscatePhone(phone) : "");
//			productSummary.setPolicyNumber(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPolicyNO());
//			productSummary.setPolicyPeriod(policyPeriod);
//			productSummary.setSumInsured(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPremiumAMT());
//			productSummary.setPolicies(policies);
//			productSummary.setSettlement(settlement);
//			productSummary.setProductName(response.getBody().getCustomer().getHasPolicyAccount().get(0).getInsuranceProductRk());
//			productSummary.setTotal(policies.size());
//		}
//		
//		return productSummary;
//	}
//}
