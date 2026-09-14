package com.axa.payment.portlet;

import com.axa.payment.constants.ProductPortletKeys;
import com.axa.payment.dto.PolicyDto;
import com.axa.payment.dto.ProductSummaryDto;
import com.axa.payment.dto.SettlementDto;
import com.axa.payment.dto.eip.BodyDto;
import com.axa.payment.dto.eip.CustomerDto;
import com.axa.payment.dto.eip.PolicyAccountDto;
import com.axa.payment.dto.eip.ResponseDto;
import com.axa.payment.helpers.ActionHelper;
import com.axa.payment.helpers.EncryptionHelper;
import com.axa.payment.model.PaymentTransaction;
import com.axa.payment.service.PaymentTransactionLocalService;
import com.google.gson.Gson;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Prawiranegara
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=axaPay",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Product Summary SmartPay",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/product/view.jsp",
		"javax.portlet.name=" + ProductPortletKeys.PRODUCT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProductPortlet extends MVCPortlet {
	private static String apiURL;
	private static String bodyOperation;
	private static String bodyService;
	private static String policyNo;
	private static String profileId;
	private static ActionHelper helper = new ActionHelper();
	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
	private static Log _log = LogFactoryUtil.getLog(ProductPortlet.class);
	private static Gson gson = new Gson();
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		
		if (helper.isLog()) _log.info(resourceID);
			
		try {
			if (resourceID.equalsIgnoreCase("getdataproductsummary")) {
				getDataProductSummary(resourceRequest, resourceResponse);
			} else if (resourceID.equalsIgnoreCase("setdatatransaction")) {
				setDataTransaction(resourceRequest, resourceResponse);
			} else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		} catch(Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}
	}
	
	public void getDataProductSummary(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		 
		HttpSession session = httpRequest.getSession();
		policyNo = (String) session.getAttribute("POLICY_NUMBER");
		profileId = (String) session.getAttribute("PROFILE_ID");
		
		if (helper.isLog()) _log.info("SESSION ID: " + session.getId());
		if (helper.isLog()) _log.info(policyNo);
		if (helper.isLog()) _log.info(profileId);
		
		if (Validator.isNull(policyNo) == true && Validator.isNull(profileId) == true) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay") : "/signin-smartpay");
			_response.put("status", false);
			_response.put("message", "Periksa kembali Nomor Polis dan ID Profil Anda, lalu silakan coba lagi.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		String channel = (String) session.getAttribute("CHANNEL");
		if (Validator.isNotNull(channel) == true) session.removeAttribute("CHANNEL");
		
		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
		if (Validator.isNotNull(invoiceNumber) == true) session.removeAttribute("INVOICE_NUMBER");
		
		String vaBca = (String) session.getAttribute("BCA");
		if (Validator.isNotNull(vaBca) == true) session.removeAttribute("BCA");
		
		String vaMandiri = (String) session.getAttribute("MANDIRI");
		if (Validator.isNotNull(vaMandiri) == true) session.removeAttribute("MANDIRI");
		
		ProductSummaryDto productSummary = getProductSummary(httpRequest);
		
		if (Validator.isNull(productSummary) == true) {
			_response.put("status", false);
			_response.put("message", "Mohon maaf koneksi Anda terputus. Silakan muat ulang halaman untuk memproses ulang.");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}

		if (Validator.isNull(productSummary.getFullName()) == true) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay") : "/signin-smartpay");
			_response.put("status", false);
			_response.put("message", "Periksa kembali Nomor Polis dan ID Profil Anda, lalu silakan coba lagi.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		_response.put("status", true);
		_response.put("message", "");
		_response.put("data", gson.fromJson(gson.toJson(productSummary), Object.class));
		
		resourceResponse.getWriter().write(_response.toString());
	}
	
	protected ProductSummaryDto getProductSummary(HttpServletRequest httpRequest) throws Exception {
		CustomerDto bodyCustomer = new CustomerDto();
		List<PolicyAccountDto> bodyPolicies = new ArrayList<PolicyAccountDto>();
		PolicyAccountDto bodyPolicy = new PolicyAccountDto();
		ProductSummaryDto productSummary = new ProductSummaryDto();
		
		bodyOperation = "getPolicyDetail";
		bodyService = "getPolicyDetails";
		
		BodyDto requestBody = helper.setupRequestBody(bodyOperation, bodyService);
		
		bodyPolicy.setPolicyNO(EncryptionHelper.decrypt(policyNo));
		bodyPolicy.setAccountNo(EncryptionHelper.decrypt(profileId));
		bodyPolicies.add(bodyPolicy);
		bodyCustomer.setHasPolicyAccount(bodyPolicies);
		requestBody.setCustomer(bodyCustomer);
		
		apiURL = helper.getConfig("com.axa.payment.config.eipApiPolicyManagementUrl");
		
		ResponseDto response = helper.isDummy() == true ? gson.fromJson(helper.getConfigDummy(), ResponseDto.class) : helper.setupCallAPI(apiURL, bodyOperation, requestBody, httpRequest);
		
		if (helper.isLog()) _log.info(gson.fromJson(gson.toJson(response), Object.class));
		
		if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getCustomer()) == true) {
			return productSummary;
		}
		
		if (response.getBody().getCustomer().getHaveCommunicatedMessage().get(0).getDeliveryStatusCD() == 200) {
			SimpleDateFormat inputFormatter = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat outputFormatterPeriod = new SimpleDateFormat("dd MMM yyyy");
			SimpleDateFormat outputFormatterDue = new SimpleDateFormat("dd / MMM / yyyy");
			
			List<PolicyDto> policies = new ArrayList<PolicyDto>();
			SettlementDto settlement = new SettlementDto();
			
			String formattedPolicyDue = StringPool.BLANK;
			String vaBca = StringPool.BLANK;
			String vaMandiri = StringPool.BLANK;
			String dueDate = StringPool.BLANK;
			double unpaid = 0;
			
			for (PolicyAccountDto item : response.getBody().getCustomer().getHasPolicyAccount().get(0).getHasCustomerInformationIn().get(0).getHasPolicyAccount()) {
				PolicyDto policy = new PolicyDto();
				
				Date policyDue = inputFormatter.parse(item.getPolicyDueDt());
				formattedPolicyDue = outputFormatterDue.format(policyDue);
				
				policy.setDueDate(formattedPolicyDue.toUpperCase());
				policy.setAmount(item.getTargetPremiumAmt());
				policy.setStatus(item.getPolicyStatusCD().equalsIgnoreCase("paid") == true ? "MENUNGGU VERIFIKASI PEMBAYARAN" :
								 item.getPolicyStatusCD().equalsIgnoreCase("undue") == true ? "BELUM JATUH TEMPO" :
								 item.getPolicyStatusCD().equalsIgnoreCase("unpaid") == true ? "BELUM DIBAYARKAN" :
								 item.getPolicyStatusCD().equalsIgnoreCase("settle") == true ? "SUDAH DIBAYARKAN" :
								 item.getPolicyStatusCD().toUpperCase());
				
				policies.add(policy);
				
				if (item.getPolicyStatusCD().equalsIgnoreCase("undue")) {
					unpaid += item.getTargetPremiumAmt();
					settlement.setUnpaid(unpaid);
				}
				
				if (item.getPolicyStatusCD().equalsIgnoreCase("waiting payment")) {
					dueDate = item.getPolicyDueDt();
					double nettPremi = Long.parseLong(item.getPremiumAMT()) - item.getPolicyFeeAmt() - item.getStampDutyAmt();
					
					if (Validator.isNotNull(item.getPolicyRK())) settlement.setInstallment(helper.extractInstallment(item.getPolicyRK()));
					settlement.setAmount(Long.parseLong(item.getPremiumAMT()));
					settlement.setStampDuty(item.getStampDutyAmt());
					settlement.setPolicyCost(item.getPolicyFeeAmt());
					settlement.setNettoPremium(nettPremi);
					settlement.setDiscount(item.getDiscountAMT());
					settlement.setGrossPremium(nettPremi + Math.abs(item.getDiscountAMT()));
				}
				
				if (Validator.isNotNull(item.getHasBilling().getRemark1())) vaBca = item.getHasBilling().getRemark1();
				if (Validator.isNotNull(item.getHasBilling().getRemark2())) vaMandiri = item.getHasBilling().getRemark2();
			}
			
			String fullName = response.getBody().getCustomer()
							  .getHasPolicyAccount().get(0)
							  .getHasCustomerInformationIn().get(0)
							  .getCanBeIndividual().getFullNM().replaceAll("^\\s+|\\s+$", "");
			
			String email = response.getBody().getCustomer()
						   .getHasPolicyAccount().get(0)
						   .getHasCustomerInformationIn().get(0)
						   .getCanBeIndividual().getHasAddressesIn().get(0).getEmailAddress();
			
			if (Validator.isNotNull(email)) email = email.replaceAll("^\\s+|\\s+$", "");
			
			String phone = response.getBody().getCustomer()
						   .getHasPolicyAccount().get(0)
						   .getHasCustomerInformationIn().get(0)
						   .getCanBeIndividual().getHasAddressesIn().get(0).getMobilePhoneNO();
			
			if (Validator.isNotNull(phone)) phone = phone.replaceAll("^\\s+|\\s+$", "");
			
			Date effectivePeriod = inputFormatter.parse(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPolicyEffectiveDTTM());
			Date expirationPeriod = inputFormatter.parse(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPolicyExpirationDTTM());
			String formattedEffectivePeriod = outputFormatterPeriod.format(effectivePeriod);
			String formattedExpirationPeriod = outputFormatterPeriod.format(expirationPeriod);
			String policyPeriod = formattedEffectivePeriod.concat(" - ").concat(formattedExpirationPeriod);
			
			HttpSession session = httpRequest.getSession();
			if (Validator.isNotNull(fullName)) session.setAttribute("FULLNAME", EncryptionHelper.encrypt(fullName));
			if (Validator.isNotNull(email)) session.setAttribute("EMAIL", EncryptionHelper.encrypt(email));
			if (Validator.isNotNull(phone)) session.setAttribute("PHONE", EncryptionHelper.encrypt(phone));
			if (Validator.isNotNull(vaBca)) session.setAttribute("BCA", EncryptionHelper.encrypt(vaBca));
			if (Validator.isNotNull(vaMandiri)) session.setAttribute("MANDIRI", EncryptionHelper.encrypt(vaMandiri));
			session.setAttribute("AMOUNT", settlement.getAmount());
			if (Validator.isNotNull(response.getBody().getCustomer().getHasPolicyAccount().get(0).getHasDetailsOfPolicyTransactionIn().get(0).getReferenceNO())) session.setAttribute("REFERENCE", EncryptionHelper.encrypt(response.getBody().getCustomer().getHasPolicyAccount().get(0).getHasDetailsOfPolicyTransactionIn().get(0).getReferenceNO()));
			session.setAttribute("DUE_DATE", dueDate);
			
			productSummary.setFullName(Validator.isNotNull(fullName) ? fullName.length() > 46 ? helper.obfuscateFullName(fullName).substring(0, 46).concat("....") : helper.obfuscateFullName(fullName) : "");
			productSummary.setEmailAddress(Validator.isNotNull(email) ? helper.obfuscateEmail(email) : "");
			productSummary.setMobileNumber(Validator.isNotNull(phone) ? helper.obfuscatePhone(phone) : "");
			productSummary.setPolicyNumber(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPolicyNO());
			productSummary.setPolicyPeriod(policyPeriod);
			productSummary.setSumInsured(Validator.isNotNull(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPremiumAMT()) ? Long.parseLong(response.getBody().getCustomer().getHasPolicyAccount().get(0).getPremiumAMT()) : 0);
			productSummary.setPolicies(policies);
			productSummary.setSettlement(settlement);
			productSummary.setProductName(response.getBody().getCustomer().getHasPolicyAccount().get(0).getInsuranceProductRk());
			productSummary.setTotal(policies.size());
		}
		
		return productSummary;
	}
	
	public void setDataTransaction(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		HttpSession session = httpRequest.getSession();
		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
		String profileId = (String) session.getAttribute("PROFILE_ID");
		
		if (helper.isLog()) _log.info("SESSION ID TRX: " + session.getId());
		if (helper.isLog()) _log.info(policyNo);
		if (helper.isLog()) _log.info(profileId);
		
		if (Validator.isNull(policyNo) == true && Validator.isNull(profileId) == true) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay") : "/signin-smartpay");
			_response.put("status", false);
			_response.put("message", "Mohon maaf sesi Anda tidak ditemukan. Silakan muat ulang halaman untuk memproses ulang.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		String referenceNumber = (String) session.getAttribute("REFERENCE");
		String dueDate = (String) session.getAttribute("DUE_DATE");
		double amount = (double) session.getAttribute("AMOUNT");
		String invoiceNumber = generateInvoiceNumber(EncryptionHelper.decrypt(policyNo), EncryptionHelper.decrypt(profileId));
		
		int countInvoice = _paymentTransactionLocalService.countByPolicyProfileInvoice(EncryptionHelper.decrypt(policyNo), EncryptionHelper.decrypt(profileId), invoiceNumber);
		
		if (countInvoice > 0) {
			_response.put("status", false);
			_response.put("message", "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		PaymentTransaction trx = _paymentTransactionLocalService.addTransaction(EncryptionHelper.decrypt(policyNo), EncryptionHelper.decrypt(profileId), invoiceNumber, EncryptionHelper.decrypt(referenceNumber), dueDate, amount);
		
		if (Validator.isNull(trx) == true) {
			_response.put("status", false);
			_response.put("message", "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		session.setAttribute("INVOICE_NUMBER", EncryptionHelper.encrypt(trx.getInvoiceNumber()));
		
		_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/payment") : "/payment-smartpay");
		_response.put("status", true);
		_response.put("message", "");
		_response.put("data", _data);
		
		resourceResponse.getWriter().write(_response.toString());
	}
	
	protected String generateInvoiceNumber(String policyNo, String profileId) {
		String latestInvoiceNumber = StringPool.BLANK;
		
		try {
			latestInvoiceNumber = _paymentTransactionLocalService.getByPolicyProfile(policyNo, profileId).get(0).getInvoiceNumber();
		} catch (Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
			return policyNo.concat("/XP0001");
		}
		
		if (Validator.isNull(latestInvoiceNumber) == true) return policyNo.concat("/XP0001");
		
		long incrementNumber = Long.parseLong(latestInvoiceNumber.substring(latestInvoiceNumber.indexOf("XP") + 2)) + 1;
		String formattedNumber = String.format("%04d", incrementNumber);
		
		return policyNo.concat("/XP").concat(formattedNumber);
	}
	
	@Reference
	private PaymentTransactionLocalService _paymentTransactionLocalService;
}
