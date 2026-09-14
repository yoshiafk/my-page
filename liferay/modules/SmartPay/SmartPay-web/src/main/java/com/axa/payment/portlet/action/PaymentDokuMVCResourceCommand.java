//package com.axa.payment.portlet.action;
//
//import com.axa.payment.constants.PaymentPortletKeys;
//import com.axa.payment.dto.doku.AdditionalInfoDto;
//import com.axa.payment.dto.doku.AddressDto;
//import com.axa.payment.dto.doku.CustomerDto;
//import com.axa.payment.dto.doku.LineItemDto;
//import com.axa.payment.dto.doku.OrderDto;
//import com.axa.payment.dto.doku.PaymentDto;
//import com.axa.payment.dto.doku.PaymentRequestDto;
//import com.axa.payment.helpers.ActionHelper;
//import com.axa.payment.helpers.EncryptionHelper;
//import com.axa.payment.helpers.SignatureHelper;
//import com.axa.payment.service.PaymentTransactionLocalService;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.json.JSONFactoryUtil;
//import com.liferay.portal.kernel.json.JSONObject;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.util.Validator;
//import com.mypage.admin.product.model.MasterGlobalVariable;
//import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
//
//import java.net.URL;
//import java.time.ZoneOffset;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(
//	immediate = true,
//	property = {
//		"javax.portlet.name=" + PaymentPortletKeys.PAYMENT_DOKU,
//		"mvc.command.name=/data/doku"
//	},
//	service = MVCResourceCommand.class
//)
//public class PaymentDokuMVCResourceCommand extends BaseMVCResourceCommand {;
//	private static String DOKU_API;
//	private static String GENERATE_SECRET_KEY;
//	private static String GENERATE_CLIENT_ID;
//	private static String REQUEST_TARGET;
//	private static String CLIENT_ID = "Client-Id";
//    private static String REQUEST_ID = "Request-Id";
//    private static String REQUEST_TIMESTAMP = "Request-Timestamp";
//    private static String SIGNATURE = "Signature";
//    private static ActionHelper helper = new ActionHelper();
//	private static String PIMCORE_HOST = helper.getConfig("com.mypage.agent.config.pimcoreHost");
//	private static String mode = helper.getConfig("com.axa.payment.mode");
//    private static Gson gson = new Gson();
//	private static Log _log = LogFactoryUtil.getLog(PaymentDokuMVCResourceCommand.class);
//	
//	@Override
//	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
//		JSONObject _response = JSONFactoryUtil.createJSONObject();
//		JSONObject _responseApi = JSONFactoryUtil.createJSONObject();
//		JSONObject _data = JSONFactoryUtil.createJSONObject();
//		
//		boolean status = true;
//		String message = StringPool.BLANK;
//		String target = ParamUtil.getString(httpRequest, "target");
//		
//		if (Validator.isNull(target) == true) {
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		List<MasterGlobalVariable> variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Doku");
//		
//		for (MasterGlobalVariable item : variables) {
//			if (item.getName().equalsIgnoreCase("checkout v1 payment")) DOKU_API = item.getValue();
//			if (item.getName().equalsIgnoreCase("secret key")) GENERATE_SECRET_KEY = item.getValue();
//			if (item.getName().equalsIgnoreCase("client id")) GENERATE_CLIENT_ID = item.getValue();
//		}
//		
////		DOKU_API = helper.getConfig("com.axa.payment.doku.paymentUrl");
////		GENERATE_SECRET_KEY = helper.getConfig("com.axa.payment.doku.secretKey");
////		GENERATE_CLIENT_ID = helper.getConfig("com.axa.payment.doku.clientId");
//		
//		HttpSession session = httpRequest.getSession();
//		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
//		String profileId = (String) session.getAttribute("PROFILE_ID");
//		
//		if (helper.isLog()) _log.info("SESSION ID PAYMENT DOKU: " + session.getId());
//		if (helper.isLog()) _log.info(policyNo);
//		if (helper.isLog()) _log.info(profileId);
//		
//		if (Validator.isNull(policyNo) == true && Validator.isNull(profileId) == true) {
//			_data.put("target", mode.equalsIgnoreCase("prod") ? PIMCORE_HOST.concat("/smartpay") : "/signin-smartpay");
//			_response.put("status", false);
//			_response.put("message", "Sorry we couldn't complete your request, please try again in a moment");
//			_response.put("data", _data);
//
//			resourceResponse.getWriter().write(_response.toString());
//			return;
//		}
//		
//		double amount = (double) session.getAttribute("AMOUNT");
//		String invoiceNumber = (String) session.getAttribute("INVOICE_NUMBER");
//		String fullName = (String) session.getAttribute("FULLNAME");
//		String emailAddress = (String) session.getAttribute("EMAIL");
//		String mobileNumber = (String) session.getAttribute("PHONE");
//		
//		URL url = new URL(DOKU_API);
//		
//		REQUEST_TARGET = url.getPath();
//		
//		if (helper.isLog()) _log.info(DOKU_API);
//		if (helper.isLog()) _log.info(GENERATE_SECRET_KEY);
//		if (helper.isLog()) _log.info(GENERATE_CLIENT_ID);
//		if (helper.isLog()) _log.info(REQUEST_TARGET);
//		
//		PaymentRequestDto requestPayload = new PaymentRequestDto();
//		
//		/* Order */
//		OrderDto order = new OrderDto();
//		order.setAmount((int) amount);
//		order.setInvoiceNumber(EncryptionHelper.decrypt(invoiceNumber));
////		order.setCurrency("IDR");
//		order.setCallbackUrl(PIMCORE_HOST.concat("/product-summary-smartpay"));
////		order.setCallbackUrlCancel("https://merchantcallbackurl-cancel.domain");
//		order.setCallbackUrlResult(PIMCORE_HOST.concat("/product-summary-smartpay"));
////		order.setLanguage("EN");
//		order.setAutoRedirect(true);
//		if (target.equalsIgnoreCase("credit_card")) order.setDisableRetryPayment(true);
//
////		List<LineItemDto> lineItems = new ArrayList<LineItemDto>();
////		
////		LineItemDto item1 = new LineItemDto();
////		item1.setId("001");
////        item1.setName("Fresh flowers");
////        item1.setQuantity(1);
////        item1.setPrice( 40000);
////        item1.setSku("FF01");
////        item1.setCategory("gift-and-flowers");
////        item1.setUrl("http://item-url.domain/");
////        item1.setImageUrl("http://image-url.domain/");
////        item1.setType("ABC");
////        lineItems.add(item1);
////		
////        LineItemDto item2 = new LineItemDto();
////		item2.setId("002");
////        item2.setName("T-shirt");
////        item2.setQuantity(1);
////        item2.setPrice(40000);
////        item2.setSku("T01");
////        item2.setCategory("clothing");
////        item2.setUrl("http://item-url.domain/");
////        item2.setImageUrl("http://image-url.domain/");
////        item2.setType("ABC");
////        lineItems.add(item2);
////        
////        order.setLineItems(lineItems);
//        
//        requestPayload.setOrder(order);
//        
//        /* Payment */
//        PaymentDto payment = new PaymentDto();
//        payment.setPaymentDueDate(60);
////        payment.setType("SALE");
//        
//        List<String> paymentMethodTypes = new ArrayList<String>();
//        paymentMethodTypes.add(target);
////        paymentMethodTypes.add("VIRTUAL_ACCOUNT_BANK_MANDIRI");
////        paymentMethodTypes.add("VIRTUAL_ACCOUNT_BANK_SYARIAH_MANDIRI");
////        paymentMethodTypes.add("VIRTUAL_ACCOUNT_DOKU");
////        paymentMethodTypes.add("VIRTUAL_ACCOUNT_BRI");
////        paymentMethodTypes.add("VIRTUAL_ACCOUNT_BNI");
////        paymentMethodTypes.add("VIRTUAL_ACCOUNT_BANK_PERMATA");
////        paymentMethodTypes.add("VIRTUAL_ACCOUNT_BANK_CIMB");
////        paymentMethodTypes.add("VIRTUAL_ACCOUNT_BANK_DANAMON");
////        paymentMethodTypes.add("ONLINE_TO_OFFLINE_ALFA");
////        paymentMethodTypes.add("CREDIT_CARD");
////        paymentMethodTypes.add("DIRECT_DEBIT_BRI");
////        paymentMethodTypes.add("EMONEY_SHOPEEPAY");
////        paymentMethodTypes.add("EMONEY_OVO");
////        paymentMethodTypes.add("EMONEY_DANA");
////        paymentMethodTypes.add("QRIS");
////        paymentMethodTypes.add("PEER_TO_PEER_AKULAKU");
////        paymentMethodTypes.add("PEER_TO_PEER_KREDIVO");
////        paymentMethodTypes.add("PEER_TO_PEER_INDODANA");
//        
//        payment.setPaymentMethodTypes(paymentMethodTypes);
//        
//        requestPayload.setPayment(payment);
//        
//        /* Customer */
//        CustomerDto customer = new CustomerDto();
////        if (target.equalsIgnoreCase("credit_card")) customer.setId(EncryptionHelper.decrypt(profileId));
//        customer.setName(EncryptionHelper.decrypt(fullName).replaceAll("[^a-zA-Z\\s]", ""));
////        customer.setLastName("Anggraeni");
//        customer.setPhone(EncryptionHelper.decrypt(mobileNumber));
//        customer.setEmail(EncryptionHelper.decrypt(emailAddress));
////        customer.setAddress("taman setiabudi");
////        customer.setPostcode("120129");
////        customer.setState("Jakarta");
////        customer.setCity("Jakarta Selatan");
////        customer.setCountry("ID");
//        
//        requestPayload.setCustomer(customer);
//        
//        /* Shipping */
////        AddressDto shipping = new AddressDto();
////        shipping.setFirstName("Joe");
////        shipping.setLastName("Doe");
////        shipping.setAddress("Jalan DOKU no 15");
////        shipping.setCity("Jakarta");
////        shipping.setPostalCode("11923");
////        shipping.setPhone("081312345678");
////        shipping.setCountryCode("IDN");
////        
////        requestPayload.setShippingAddress(shipping);
//        
//        /* Billing */
////        AddressDto billing = new AddressDto();
////        billing.setFirstName("Joe");
////        billing.setLastName("Doe");
////        billing.setAddress("Jalan DOKU no 15");
////        billing.setCity("Jakarta");
////        billing.setPostalCode("11923");
////        billing.setPhone("081312345678");
////        billing.setCountryCode("IDN");
////        
////        requestPayload.setBillingAddress(billing);
//        
//        /* Additional Info */
////        AdditionalInfoDto additionalInfo = new AdditionalInfoDto();
////        
////        List<Integer> allowTenor = new ArrayList<Integer>();
////        allowTenor.add(0);
////        allowTenor.add(3);
////        allowTenor.add(6);
////        allowTenor.add(12);
////        
////        additionalInfo.setAllowTenor(allowTenor);
////        additionalInfo.setDokuWalletNotifyUrl("https://dw-notification.merchantdomain");
////        
////        requestPayload.setAdditionalInfo(additionalInfo);
//        
//        if (helper.isLog()) _log.info(gson.toJson(requestPayload));
//		
//        String digest = SignatureHelper.generateDigest(gson.toJson(requestPayload));
//
//        JsonObject signatureObject = new JsonObject();
//		String uuid = UUID.randomUUID().toString();
//		ZonedDateTime nowInUTC = ZonedDateTime.now(ZoneOffset.UTC);
//        String reqTimestamp = nowInUTC.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
//        
//        signatureObject.addProperty(CLIENT_ID, GENERATE_CLIENT_ID);
//		signatureObject.addProperty(REQUEST_ID, uuid);
//		signatureObject.addProperty(REQUEST_TIMESTAMP, reqTimestamp);
//		signatureObject.addProperty(SIGNATURE, SignatureHelper.generateSignature(GENERATE_CLIENT_ID, uuid, reqTimestamp, REQUEST_TARGET, digest, GENERATE_SECRET_KEY));
//		
//		try {
//			_responseApi = helper.hitAPI(DOKU_API, gson.toJson(requestPayload), gson.toJson(signatureObject));
//			
//			if (helper.isLog()) _log.info(_responseApi.toString());
//			
//			if (_responseApi.getInt("statusCode") == 200) {
//				JSONObject paymentResponse = JSONFactoryUtil.createJSONObject(_responseApi.get("response").toString());
//				String paymentUrl = paymentResponse.getJSONObject("response").getJSONObject("payment").get("url").toString();
//				
//				_paymentTransactionLocalService.updateTransactionMethodChannel(EncryptionHelper.decrypt(invoiceNumber), target, "DOKU");
//
//				_data.put("paymentUrl", paymentUrl);
//				_response.put("data", _data);
//			} else {
//				status = false;
//				
//				JSONObject errorResponse = JSONFactoryUtil.createJSONObject(_responseApi.get("response").toString());
//				message = errorResponse.getJSONArray("message").get(0).toString();
//			}
//		} catch (Exception e) {
//			status = false;
//			message = "Sorry we couldn't complete your request, please try again in a moment";
//		}
//
//		_response.put("status", status);
//		_response.put("message", message);
//		resourceResponse.getWriter().write(_response.toString());
//	}
//	
//	@Reference
//	private PaymentTransactionLocalService _paymentTransactionLocalService;
//}
