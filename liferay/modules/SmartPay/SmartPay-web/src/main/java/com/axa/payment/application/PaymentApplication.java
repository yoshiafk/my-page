package com.axa.payment.application;

import com.axa.payment.dto.eip.BodyDto;
import com.axa.payment.dto.eip.CustomerDto;
import com.axa.payment.dto.eip.PolicyAccountDto;
import com.axa.payment.dto.eip.ResponseDto;
import com.axa.payment.helpers.ActionHelper;
import com.axa.payment.helpers.SignatureHelper;
import com.axa.payment.model.PaymentTransaction;
import com.axa.payment.service.PaymentTransactionLocalServiceUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/payment",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Payment.Rest",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true"
	},
	service = Application.class
)
public class PaymentApplication extends Application {
	private static ActionHelper helper = new ActionHelper();
	private static Log _log = LogFactoryUtil.getLog(PaymentApplication.class);
	private static Gson gson = new Gson();
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	@POST
	@Path("/notify/qris")
	@Produces("application/json")
	public String notifyQris(String request, @Context HttpHeaders headers, @Context HttpServletRequest httpRequest) throws Exception {
		JsonObject jsonObject = JsonParser.parseString(request).getAsJsonObject();
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		
		if (helper.isLog()) _log.info(jsonObject.toString());
		
		String clientId = StringPool.BLANK;
		String secretKey = StringPool.BLANK;
		String reqTarget = StringPool.BLANK;
		
		List<MasterGlobalVariable> variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Doku");
		
		for (MasterGlobalVariable item : variables) {
			if (item.getName().equalsIgnoreCase("notify qris")) reqTarget = item.getValue();
			if (item.getName().equalsIgnoreCase("secret key")) secretKey = item.getValue();
			if (item.getName().equalsIgnoreCase("client id")) clientId = item.getValue();
		}
		
		if (helper.isLog()) _log.info("CLIENTID: " + clientId);
		if (helper.isLog()) _log.info("SECRETKEY: " + secretKey);
		if (helper.isLog()) _log.info("REQTARGET: " + reqTarget);
		
		String uuid = headers.getHeaderString("Request-Id");
        String reqTimestamp = headers.getHeaderString("Request-Timestamp");
		String signature = headers.getHeaderString("Signature");
		String beautifiedJson = SignatureHelper.beautifyJson(jsonObject.toString());
		String digest = SignatureHelper.generateDigest(beautifiedJson);
		
		URL url = new URL(reqTarget);
		String target = url.getPath();
		
		if (helper.isLog()) _log.info("REQBD: " + beautifiedJson);
		if (helper.isLog()) _log.info("REQID: " + uuid);
		if (helper.isLog()) _log.info("REQTS: " + reqTimestamp);
		if (helper.isLog()) _log.info("REQTG: " + target);
		if (helper.isLog()) _log.info("SIGNATURE from DOKU: " + signature);
		if (helper.isLog()) _log.info("DIGEST: " + digest);
		
		String generateSignature = SignatureHelper.generateSignature(clientId, uuid, reqTimestamp, target, digest, secretKey);
		
		if (helper.isLog()) _log.info("GENERATE SIGNATURE: " + generateSignature);
		
		if (helper.isValidateSignature() == true) {
			if (signature.equalsIgnoreCase(generateSignature) == false) {
	        	_output.put("status", false);
	    		_output.put("message", "Access Forbidden");
	    		
	    		return _output.toString();
	        }
		}
		
		if (jsonObject.getAsJsonObject("transaction").get("status").getAsString().equalsIgnoreCase("success")) {
			PaymentTransaction data = null;
			
			try {
				data = PaymentTransactionLocalServiceUtil.getByInvoiceNumber(jsonObject.getAsJsonObject("order").get("invoice_number").getAsString());

				SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = inputFormat.parse(data.getPolicyDueDate());
				String dueDate = outputFormat.format(date);
		        String paidDate = outputFormat.format(data.getModifiedDate());
		        ResponseDto pushNotif = setupPushNotification(httpRequest, data.getPolicyNumber(), data.getInvoiceNumber(), jsonObject.getAsJsonObject("channel").get("id").getAsString(),
									  						 paidDate, "Paid", dueDate, String.valueOf(data.getAmount()), "");
				
				if (Validator.isNotNull(pushNotif) == true) {
					data.setStatus_(jsonObject.getAsJsonObject("transaction").get("status").getAsString());
					TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
					Calendar calendar = Calendar.getInstance(wibTimeZone);
					Date currentDate = calendar.getTime();
					Instant instant = currentDate.toInstant();
					LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
					ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
					Instant instantDate = zonedDateTime.toInstant();
					Date modifiedDate = Date.from(instantDate);
					data.setModifiedDate(modifiedDate);
					data.setModifiedBy("DOKU NOTIFY");
					
					PaymentTransactionLocalServiceUtil.updatePaymentTransaction(data);
				}
			} catch(Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
				
				_output.put("status", false);
	    		_output.put("message", "Your transaction is not found");
	    		
	    		return _output.toString();
			}
		}
		
		_output.put("status", true);
		_output.put("message", "Notification has been successfully received");
		
		return _output.toString();
	}
	
	@POST
	@Path("/notify/all")
	@Produces("application/json")
	public String notifAll(String request, @Context HttpHeaders headers, @Context HttpServletRequest httpRequest) throws Exception {
		JsonObject jsonObject = JsonParser.parseString(request).getAsJsonObject();
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		
		if (helper.isLog()) _log.info(jsonObject.toString());
		
		String clientId = StringPool.BLANK;
		String secretKey = StringPool.BLANK;
		String reqTarget = StringPool.BLANK;
		
		List<MasterGlobalVariable> variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Doku");
		
		for (MasterGlobalVariable item : variables) {
			if (item.getName().equalsIgnoreCase("notify all")) reqTarget = item.getValue();
			if (item.getName().equalsIgnoreCase("secret key")) secretKey = item.getValue();
			if (item.getName().equalsIgnoreCase("client id")) clientId = item.getValue();
		}
		
		if (helper.isLog()) _log.info("CLIENTID: " + clientId);
		if (helper.isLog()) _log.info("SECRETKEY: " + secretKey);
		if (helper.isLog()) _log.info("REQTARGET: " + reqTarget);
		
		String uuid = headers.getHeaderString("Request-Id");
        String reqTimestamp = headers.getHeaderString("Request-Timestamp");
		String signature = headers.getHeaderString("Signature");
		String formattedJson = uuid.contains("CREDIT_CARD") == true ? SignatureHelper.minifyJson(jsonObject.toString()) : SignatureHelper.beautifyJson(jsonObject.toString());
		String digest = SignatureHelper.generateDigest(formattedJson);
		
		URL url = new URL(reqTarget);
		String target = url.getPath();
		
		if (helper.isLog()) _log.info("REQBD: " + formattedJson);
		if (helper.isLog()) _log.info("REQID: " + uuid);
		if (helper.isLog()) _log.info("REQTS: " + reqTimestamp);
		if (helper.isLog()) _log.info("REQTG: " + target);
		if (helper.isLog()) _log.info("SIGNATURE from DOKU: " + signature);
		if (helper.isLog()) _log.info("DIGEST: " + digest);
		
		String generateSignature = SignatureHelper.generateSignature(clientId, uuid, reqTimestamp, target, digest, secretKey);
		
		if (helper.isLog()) _log.info("GENERATE SIGNATURE: " + generateSignature);
		
		if (helper.isValidateSignature() == true) {
			if (signature.equalsIgnoreCase(generateSignature) == false) {
	        	_output.put("status", false);
	    		_output.put("message", "Access Forbidden");
	    		
	    		return _output.toString();
	        }
		}
		
		if (jsonObject.getAsJsonObject("transaction").get("status").getAsString().equalsIgnoreCase("success")) {
			PaymentTransaction data = null;
			
			try {
				data = PaymentTransactionLocalServiceUtil.getByInvoiceNumber(jsonObject.getAsJsonObject("order").get("invoice_number").getAsString());
				
				SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = inputFormat.parse(data.getPolicyDueDate());
				String dueDate = outputFormat.format(date);
		        String paidDate = outputFormat.format(data.getModifiedDate());
		        ResponseDto pushNotif = setupPushNotification(httpRequest, data.getPolicyNumber(), data.getInvoiceNumber(), jsonObject.getAsJsonObject("channel").get("id").getAsString(),
									  						 paidDate, "Paid", dueDate, String.valueOf(data.getAmount()), "");
				
				if (Validator.isNotNull(pushNotif) == true) {
					data.setStatus_(jsonObject.getAsJsonObject("transaction").get("status").getAsString());
					TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
					Calendar calendar = Calendar.getInstance(wibTimeZone);
					Date currentDate = calendar.getTime();
					Instant instant = currentDate.toInstant();
					LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
					ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
					Instant instantDate = zonedDateTime.toInstant();
					Date modifiedDate = Date.from(instantDate);
					data.setModifiedDate(modifiedDate);
					data.setModifiedBy("DOKU NOTIFY");
					
					PaymentTransactionLocalServiceUtil.updatePaymentTransaction(data);
				}
			} catch(Exception e) {
				if (helper.isLog()) _log.info(e.getMessage());
				
				_output.put("status", false);
	    		_output.put("message", "Your transaction is not found");
	    		
	    		return _output.toString();
			}
		}
		
		_output.put("status", true);
		_output.put("message", "Notification has been successfully received");
		
		return _output.toString();
	}
	
	@GET
	@Path("/check/status")
	@Produces("application/json")
	public String checkStatus(@Context HttpServletRequest httpRequest) throws Exception {
		JSONObject _responseApi = JSONFactoryUtil.createJSONObject();
		JSONObject _output = JSONFactoryUtil.createJSONObject();
		
		boolean status = true;
		String message = StringPool.BLANK;
		String DOKU_API = StringPool.BLANK;
		String GENERATE_SECRET_KEY = StringPool.BLANK;
		String GENERATE_CLIENT_ID = StringPool.BLANK;
		String REQUEST_TARGET = StringPool.BLANK;
		String CLIENT_ID = "Client-Id";
	    String REQUEST_ID = "Request-Id";
	    String REQUEST_TIMESTAMP = "Request-Timestamp";
	    String SIGNATURE = "Signature";
	    int size = Integer.parseInt(helper.getConfig("com.axa.payment.limitTrx"));
	    
	    if (helper.isLog()) _log.info("LIMIT TRX: " + size);
	    
	    List<PaymentTransaction> trx = PaymentTransactionLocalServiceUtil.getByStatus(size);
	    
	    if (helper.isLog()) _log.info("SIZE TRX: " + trx.size());
	    
	    if (trx.size() > 0) {
	    	for (PaymentTransaction itemtrx : trx) {
	    		TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
				Calendar calendar = Calendar.getInstance(wibTimeZone);
				Date currentDate = calendar.getTime();
				Instant instant = currentDate.toInstant();
				LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
				ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
				Instant instantDate = zonedDateTime.toInstant();
				Date modifiedDate = Date.from(instantDate);
	    		
				List<MasterGlobalVariable> variables = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Doku");
				
				for (MasterGlobalVariable item : variables) {
					if (item.getName().equalsIgnoreCase("orders v1 status")) DOKU_API = item.getValue().concat("/").concat(itemtrx.getRequestId());
					if (item.getName().equalsIgnoreCase("target orders v1 status")) REQUEST_TARGET = item.getValue().concat("/").concat(itemtrx.getRequestId());
					if (item.getName().equalsIgnoreCase("secret key")) GENERATE_SECRET_KEY = item.getValue();
					if (item.getName().equalsIgnoreCase("client id")) GENERATE_CLIENT_ID = item.getValue();
				}
				
				JsonObject signatureObject = new JsonObject();
				String uuid = UUID.randomUUID().toString();
				ZonedDateTime nowInUTC = ZonedDateTime.now(ZoneOffset.UTC);
		        String reqTimestamp = nowInUTC.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
				
				if (helper.isLog()) _log.info("REQID: " + uuid);
				if (helper.isLog()) _log.info("REQTS: " + reqTimestamp);
				if (helper.isLog()) _log.info("REQTG: " + REQUEST_TARGET);
				if (helper.isLog()) _log.info("CLIENTID: " + GENERATE_CLIENT_ID);
				if (helper.isLog()) _log.info("SECRETKEY: " + GENERATE_SECRET_KEY);
		        
		        signatureObject.addProperty(CLIENT_ID, GENERATE_CLIENT_ID);
				signatureObject.addProperty(REQUEST_ID, uuid);
				signatureObject.addProperty(REQUEST_TIMESTAMP, reqTimestamp);
				signatureObject.addProperty(SIGNATURE, SignatureHelper.generateSignature(GENERATE_CLIENT_ID, uuid, reqTimestamp, REQUEST_TARGET, "", GENERATE_SECRET_KEY));
				
				try {
					_responseApi = helper.hitAPI(DOKU_API, "", gson.toJson(signatureObject));
					
					if (helper.isLog()) _log.info(_responseApi.getString("response"));
					
					JsonObject jsonObject = JsonParser.parseString(_responseApi.getString("response")).getAsJsonObject();
					
					if (Validator.isNotNull(jsonObject.getAsJsonObject("error")) == true && jsonObject.getAsJsonObject("error").get("code").getAsString().equalsIgnoreCase("data_not_found") == true) {
				        itemtrx.setModifiedDate(modifiedDate);
				        itemtrx.setModifiedBy("DOKU CHECK STATUS");
						itemtrx.setCheckCounter(itemtrx.getCheckCounter() + 1);
						
						PaymentTransactionLocalServiceUtil.updatePaymentTransaction(itemtrx);
						
						continue;
					}
					
					if (helper.isLog()) _log.info("TRX STATUS: " + jsonObject.getAsJsonObject("transaction").get("status").getAsString());
					
					if (jsonObject.getAsJsonObject("transaction").get("status").getAsString().equalsIgnoreCase("pending") == false) {
						if (jsonObject.getAsJsonObject("transaction").get("status").getAsString().equalsIgnoreCase("success") == true) {
							SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
					        String paidDate = outputFormat.format(itemtrx.getModifiedDate());
					        
					        if (helper.isLog()) _log.info("PAID DATE: " + paidDate);
					        
							setupPushNotification(httpRequest, itemtrx.getPolicyNumber(), itemtrx.getInvoiceNumber(), jsonObject.getAsJsonObject("channel").get("id").getAsString(),
												  paidDate, "Paid", itemtrx.getPolicyDueDate(), String.valueOf(itemtrx.getAmount()), "");
						}
						
						itemtrx.setStatus_(jsonObject.getAsJsonObject("transaction").get("status").getAsString());
					}
					
			        itemtrx.setModifiedDate(modifiedDate);
			        itemtrx.setModifiedBy("DOKU CHECK STATUS");
					itemtrx.setCheckCounter(itemtrx.getCheckCounter() + 1);
					
					PaymentTransactionLocalServiceUtil.updatePaymentTransaction(itemtrx);
				} catch (Exception e) {
					if (helper.isLog()) _log.info(e.getMessage());
					
					itemtrx.setModifiedDate(modifiedDate);
			        itemtrx.setModifiedBy("DOKU CHECK STATUS");
					itemtrx.setCheckCounter(itemtrx.getCheckCounter() + 1);
					
					PaymentTransactionLocalServiceUtil.updatePaymentTransaction(itemtrx);
					
					status = false;
					message = "Sorry we couldn't complete your request, please try again in a moment";
				}
	    	}
	    }

		_output.put("status", status);
		_output.put("message", message);
		
		return _output.toString();
	}
	
	protected ResponseDto setupPushNotification(@Context HttpServletRequest httpRequest, String policyNumber, String invoiceNumber, 
											   String paymentChannel, String paidDate, String paymentStatus, String policyDue, 
											   String amount, String profileId) throws Exception {
		
		CustomerDto bodyCustomer = new CustomerDto();
		List<PolicyAccountDto> bodyPolicies = new ArrayList<PolicyAccountDto>();
		PolicyAccountDto bodyPolicy = new PolicyAccountDto();
		
		String bodyOperation = "submitPaymentdoku";
		String bodyService = "submitPayment";
		
		BodyDto requestBody = helper.setupRequestBody(bodyOperation, bodyService);
		
		bodyPolicy.setPolicyNO(policyNumber);
		bodyPolicy.setApplicationRk("AXAPAY");
		bodyPolicy.setGeneralRk(paymentChannel.contains("DOKU") == true ? paymentChannel.replace('_', ' ') : paymentChannel.replace('_', ' ').concat(" DOKU"));
		bodyPolicy.setPaidToDT(paidDate);
		bodyPolicy.setPaymentStatusCd(paymentStatus);
		bodyPolicy.setPolicyDueDt(policyDue);
		bodyPolicy.setPremiumAMT(amount.replace(".0", ""));
		bodyPolicy.setAccountNo(invoiceNumber);
		bodyPolicies.add(bodyPolicy);
		bodyCustomer.setHasPolicyAccount(bodyPolicies);
		requestBody.setCustomer(bodyCustomer);
		
		String apiURL = helper.getConfig("com.axa.payment.config.eipApiPaymentManagementUrl");
		
		ResponseDto response = helper.setupCallAPI(apiURL, bodyOperation, requestBody, httpRequest);
		
		return response;
	}
}
