package com.axa.payment.portlet;

import com.axa.payment.constants.PaymentPortletKeys;
import com.axa.payment.dto.doku.CustomerDto;
import com.axa.payment.dto.doku.OrderDto;
import com.axa.payment.dto.doku.PaymentDto;
import com.axa.payment.dto.doku.PaymentRequestDto;
import com.axa.payment.helpers.ActionHelper;
import com.axa.payment.helpers.EncryptionHelper;
import com.axa.payment.helpers.SignatureHelper;
import com.axa.payment.service.PaymentTransactionLocalService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
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
		"javax.portlet.display-name=Payment SmartPay",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/payment/view.jsp",
		"javax.portlet.name=" + PaymentPortletKeys.PAYMENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PaymentPortlet extends MVCPortlet {
	private static String DOKU_API;
	private static String GENERATE_SECRET_KEY;
	private static String GENERATE_CLIENT_ID;
	private static String REQUEST_TARGET;
	private static String CLIENT_ID = "Client-Id";
    private static String REQUEST_ID = "Request-Id";
    private static String REQUEST_TIMESTAMP = "Request-Timestamp";
    private static String SIGNATURE = "Signature";
	private static ActionHelper helper = new ActionHelper();
	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
	private static Gson gson = new Gson();
	private static Log _log = LogFactoryUtil.getLog(PaymentPortlet.class);
	
	@Override 
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		 
		HttpSession session = httpRequest.getSession();
		String vaBca = (String) session.getAttribute("BCA");
		String vaMandiri = (String) session.getAttribute("MANDIRI");
		 
		request.setAttribute("vaBca", vaBca);
		request.setAttribute("vaMandiri", vaMandiri);
		 
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/META-INF/resources/payment/view.jsp");
		dispatcher.include(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		
		if (helper.isLog()) _log.info(resourceID);
			
		try {
			if (resourceID.equalsIgnoreCase("getdatapayment")) {
				getDataPayment(resourceRequest, resourceResponse);
			} else if (resourceID.equalsIgnoreCase("setinternalpayment")) {
				setInternalPayment(resourceRequest, resourceResponse);
			} else if (resourceID.equalsIgnoreCase("setdokupayment")) {
				setDokuPayment(resourceRequest, resourceResponse);
			} else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		} catch(Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}
	}
	
	public void getDataPayment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		HttpSession session = httpRequest.getSession();
		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
		String profileId = (String) session.getAttribute("PROFILE_ID");
		
		if (helper.isLog()) _log.info("SESSION ID PAYMENT: " + session.getId());
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
		
		if (Validator.isNotNull(channel) == true) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
			_response.put("status", false);
			_response.put("message", "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.");
			_response.put("data", _data);
			
			session.removeAttribute("CHANNEL");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		double amount = (double) session.getAttribute("AMOUNT");
		
		if (amount == 0) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
			_response.put("status", false);
			_response.put("message", "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}

		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
		
		if (Validator.isNull(invoiceNumber) == true) {
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
			_response.put("status", false);
			_response.put("message", "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.");
			_response.put("data", _data);

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		String fullName = (String) session.getAttribute("FULLNAME");
		String emailAddress = (String) session.getAttribute("EMAIL");
		String mobileNumber = (String) session.getAttribute("PHONE");
		
		_data.put("invoiceNumber", EncryptionHelper.decrypt(invoiceNumber));
		_data.put("fullName", Validator.isNotNull(fullName) ? EncryptionHelper.decrypt(fullName).length() > 46 ? helper.obfuscateFullName(EncryptionHelper.decrypt(fullName)).substring(0, 46).concat("....") : helper.obfuscateFullName(EncryptionHelper.decrypt(fullName)) : "");
		_data.put("emailAddress", Validator.isNotNull(emailAddress) ? helper.obfuscateEmail(EncryptionHelper.decrypt(emailAddress)) : "");
		_data.put("mobileNumber", Validator.isNotNull(mobileNumber) ? helper.obfuscatePhone(EncryptionHelper.decrypt(mobileNumber)) : "");
		_data.put("amount", amount);
		_response.put("status", true);
		_response.put("message", "");
		_response.put("data", _data);
		
		resourceResponse.getWriter().write(_response.toString());
	}
	
	public void setInternalPayment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		boolean status = true;
		String message = StringPool.BLANK;
		String target = ParamUtil.getString(httpRequest, "target");
		
		if (Validator.isNull(target) == true) {
			_response.put("status", false);
			_response.put("message", "Harap pilih metode pembayaran terlebih dahulu.");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		HttpSession session = httpRequest.getSession();
		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
		String profileId = (String) session.getAttribute("PROFILE_ID");
		
		if (helper.isLog()) _log.info("SESSION ID PAYMENT INTERNAL: " + session.getId());
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
		
		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
		
		try {
			String paymentChannel = target.contains("BCA") ? "BCA" : "MANDIRI";
			_paymentTransactionLocalService.updateTransactionMethodChannel(EncryptionHelper.decrypt(invoiceNumber), null, target, paymentChannel);
			
			session.setAttribute("CHANNEL", paymentChannel);
			_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/payment/instruction") : "/payment-instruction-smartpay");
			_response.put("data", _data);
		} catch (Exception e) {
			status = false;
			message = "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.";
		}
		
		_response.put("status", status);
		_response.put("message", message);
		resourceResponse.getWriter().write(_response.toString());
	}
	
	public void setDokuPayment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _responseApi = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		boolean status = true;
		String message = StringPool.BLANK;
		String target = ParamUtil.getString(httpRequest, "target");
		
		if (Validator.isNull(target) == true) {
			_response.put("status", false);
			_response.put("message", "Harap pilih metode pembayaran terlebih dahulu.");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		
		List<MasterGlobalVariable> variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Doku");
		
		for (MasterGlobalVariable item : variables) {
			if (item.getName().equalsIgnoreCase("checkout v1 payment")) DOKU_API = item.getValue();
			if (item.getName().equalsIgnoreCase("target checkout v1 payment")) REQUEST_TARGET = item.getValue();
			if (item.getName().equalsIgnoreCase("secret key")) GENERATE_SECRET_KEY = item.getValue();
			if (item.getName().equalsIgnoreCase("client id")) GENERATE_CLIENT_ID = item.getValue();
		}
		
		HttpSession session = httpRequest.getSession();
		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
		String profileId = (String) session.getAttribute("PROFILE_ID");
		
		if (helper.isLog()) _log.info("SESSION ID PAYMENT DOKU: " + session.getId());
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
		
		double amount = (double) session.getAttribute("AMOUNT");
		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
		String fullName = (String) session.getAttribute("FULLNAME");
		String emailAddress = (String) session.getAttribute("EMAIL");
		String mobileNumber = (String) session.getAttribute("PHONE");
		
		if (helper.isLog()) _log.info(DOKU_API);
		if (helper.isLog()) _log.info(GENERATE_SECRET_KEY);
		if (helper.isLog()) _log.info(GENERATE_CLIENT_ID);
		if (helper.isLog()) _log.info(REQUEST_TARGET);
		
		PaymentRequestDto requestPayload = new PaymentRequestDto();
		
		/* Order */
		OrderDto order = new OrderDto();
		order.setAmount((int) amount);
		order.setInvoiceNumber(EncryptionHelper.decrypt(invoiceNumber));
		order.setCallbackUrl(helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "http://agencyportal-uat.axa-id.intraxa:8080/product-summary-smartpay");
		order.setCallbackUrlResult(helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/payment/verification") : "http://agencyportal-uat.axa-id.intraxa:8080/payment-verification-smartpay");
		order.setAutoRedirect(false);
		if (target.equalsIgnoreCase("credit_card")) order.setDisableRetryPayment(true);
        
        requestPayload.setOrder(order);
        
        /* Payment */
        PaymentDto payment = new PaymentDto();
        payment.setPaymentDueDate(60);
        
        List<String> paymentMethodTypes = new ArrayList<String>();
        paymentMethodTypes.add(target);
        
        payment.setPaymentMethodTypes(paymentMethodTypes);
        
        requestPayload.setPayment(payment);
        
        /* Customer */
        CustomerDto customer = new CustomerDto();
        customer.setName(EncryptionHelper.decrypt(fullName).replaceAll("[^a-zA-Z\\s]", "").length() > 30 ? EncryptionHelper.decrypt(fullName).replaceAll("[^a-zA-Z\\s]", "").substring(0, 30) : EncryptionHelper.decrypt(fullName).replaceAll("[^a-zA-Z\\s]", ""));
        if (Validator.isNotNull(mobileNumber)) customer.setPhone(EncryptionHelper.decrypt(mobileNumber));
        if (Validator.isNotNull(emailAddress)) customer.setEmail(EncryptionHelper.decrypt(emailAddress));
        
        requestPayload.setCustomer(customer);
        
        if (helper.isLog()) _log.info(gson.toJson(requestPayload));
		
        String digest = SignatureHelper.generateDigest(gson.toJson(requestPayload));

        JsonObject signatureObject = new JsonObject();
		String uuid = UUID.randomUUID().toString();
		ZonedDateTime nowInUTC = ZonedDateTime.now(ZoneOffset.UTC);
        String reqTimestamp = nowInUTC.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        
        signatureObject.addProperty(CLIENT_ID, GENERATE_CLIENT_ID);
		signatureObject.addProperty(REQUEST_ID, uuid);
		signatureObject.addProperty(REQUEST_TIMESTAMP, reqTimestamp);
		signatureObject.addProperty(SIGNATURE, SignatureHelper.generateSignature(GENERATE_CLIENT_ID, uuid, reqTimestamp, REQUEST_TARGET, digest, GENERATE_SECRET_KEY));
		
		try {
			_responseApi = helper.hitAPI(DOKU_API, gson.toJson(requestPayload), gson.toJson(signatureObject));
			
			if (helper.isLog()) _log.info(_responseApi.toString());
			
			if (_responseApi.getInt("statusCode") == 200) {
				JSONObject paymentResponse = JSONFactoryUtil.createJSONObject(_responseApi.get("response").toString());
				String paymentUrl = paymentResponse.getJSONObject("response").getJSONObject("payment").get("url").toString();
				
				_paymentTransactionLocalService.updateTransactionMethodChannel(EncryptionHelper.decrypt(invoiceNumber), uuid, target, "DOKU");

				_data.put("paymentUrl", paymentUrl);
				_response.put("data", _data);
			} else {
				status = false;
				
				JSONObject errorResponse = JSONFactoryUtil.createJSONObject(_responseApi.get("response").toString());
				message = errorResponse.getJSONArray("message").get(0).toString();
			}
		} catch (Exception e) {
			status = false;
			message = "Mohon maaf permintaan Anda saat ini tidak dapat diproses. Silakan coba beberapa saat lagi.";
		}

		_response.put("status", status);
		_response.put("message", message);
		resourceResponse.getWriter().write(_response.toString());
	}
	
	@Reference
	private PaymentTransactionLocalService _paymentTransactionLocalService;
}