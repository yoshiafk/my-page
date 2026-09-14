package com.axa.payment.helpers;

import com.axa.payment.dto.TokenDto;
import com.axa.payment.dto.eip.BodyDto;
import com.axa.payment.dto.eip.HeaderDto;
import com.axa.payment.dto.eip.PayloadDto;
import com.axa.payment.dto.eip.PolicyAccountDto;
import com.axa.payment.dto.eip.ResponseDto;
import com.axa.payment.dto.eip.SecurityContextDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class ActionHelper {
	private static String apiRequestBody;

	private static GsonBuilder gsonBuilderSetup = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
	private static Gson gsonSetup = gsonBuilderSetup.registerTypeAdapter(PolicyAccountDto.class, new PolicyAccountSerializer()).create();
	
	private static Log _log = LogFactoryUtil.getLog(ActionHelper.class);
	
	public boolean isLog() {
        return Boolean.valueOf(getConfig("com.mypage.agent.config.showLog"));
	}
	
	public boolean isDummy() {
        return Boolean.valueOf(getConfig("com.axa.payment.showDummy"));
	}
	
	public boolean isValidateSignature() {
        return Boolean.valueOf(getConfig("com.axa.payment.validateSignature"));
	}
	
	public String getMode() {
        return getConfig("com.axa.payment.mode");
	}
	
	public String sanitizeHtml(String input) {
		PolicyFactory policy = new HtmlPolicyBuilder().toFactory();
		
        return policy.sanitize(input);
    }
	
	public String obfuscateEmail(String email) {
		int atIndex = email.indexOf('@');
		int lastDotIndex = email.lastIndexOf('.');

		if (atIndex == -1 || lastDotIndex == -1 || atIndex > lastDotIndex) {
			return email;
		}

		String username = email.substring(0, atIndex);
		String domain = email.substring(atIndex + 1, lastDotIndex);
		String afterDomain = email.substring(lastDotIndex);

		String obfuscatedEmail = obfuscateString(username, "email").concat("@")
				.concat(obfuscateString(domain, "domain")).concat(afterDomain);

		return obfuscatedEmail;
	}
	
	public String obfuscateFullName(String fullName) {
		return obfuscateString(fullName, "fullname");
	}
	
	public String obfuscatePhone(String phoneNumber) {
		return obfuscateString(phoneNumber, "phoneNumber");
	}

	private String obfuscateString(String input, String type) {
		String obfuscated = StringPool.BLANK;
		int length = input.length();

		if (length <= 2) {
			return new String(new char[length]).replace('\0', '*');
		}

		if (type.equalsIgnoreCase("email")) {
			String firstTwoCharacters = input.substring(0, 2);
			String obfuscatedPart = new String(new char[length - 2]).replace('\0', '*');
			obfuscated = firstTwoCharacters.concat(obfuscatedPart);
		}

		if (type.equalsIgnoreCase("domain"))
			obfuscated = new String(new char[length]).replace('\0', '*');
		
		if (type.equalsIgnoreCase("fullname")) {
			String[] parts = input.split(" ");

		    StringBuilder obfuscatedName = new StringBuilder();

		    for (int i = 0; i < parts.length; i++) {
		        String namePart = parts[i];
		        if (namePart.length() > 1) {
		            StringBuilder obfuscatedPart = new StringBuilder();
		            obfuscatedPart.append(namePart.charAt(0)); // Karakter pertama tetap
		            for (int j = 1; j < namePart.length(); j++) {
		                obfuscatedPart.append('*'); // Ganti karakter berikutnya dengan '*'
		            }
		            obfuscatedName.append(obfuscatedPart);
		        } else {
		            obfuscatedName.append(namePart);
		        }

		        if (i < parts.length - 1) {
		            obfuscatedName.append(" ");
		        }
		    }

		    obfuscated = obfuscatedName.toString();
		}
		
		if (type.equalsIgnoreCase("phoneNumber")) {
			String firstPart = input.substring(0, 3);
		    String lastPart = input.substring(input.length() - 2);
		    
		    String middlePart = input.substring(3, input.length() - 2);
		    
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < middlePart.length(); i++) {
		        sb.append("*");
		    }
		    String obfuscatedMiddle = sb.toString();;

		    obfuscated = firstPart.concat(obfuscatedMiddle).concat(lastPart);
		}

		return obfuscated;
	}
	
	public String extractInstallment(String input) {
		String regex = "(\\d+ of \\d+)$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(input);
	      
	    if (matcher.find()) {
	        return matcher.group(1);
	    }
	      
	    return null;
	}
	
	public TokenDto CheckToken(HttpServletRequest httpRequest) {
		TokenDto token = new TokenDto();
		
		Cookie[] cookies = httpRequest.getCookies();
		
		if (cookies != null) {
			token.setValid(true);
			
			for (Cookie cookie : cookies) {
				if ("ACCESS_TOKEN".equals(cookie.getName())) { 
					token.setToken(cookie.getValue());
				} else if ("TOKEN_EXP".equals(cookie.getName())) {
					long expiredTime = Long.parseLong(cookie.getValue());
					long currentTime = System.currentTimeMillis() / 1000;
					 
					if (expiredTime < currentTime) {
						token.setValid(false);
					}
				}
			}
		}
		
		return token;
	}
	
	public String getConfig(String key) {
		String result = StringPool.BLANK;

		try {
			String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME); // System.getProperty("catalina.base");
            String filePath = liferayHome + "/agency-portal.json";
			
         // sonia
//			JsonElement jsonElement = JsonParser.parseReader(new FileReader(filePath));
//            JsonObject jsonObject = jsonElement.getAsJsonObject();
            
            // axa
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            
            boolean isValid = isValidJson(jsonData);
            
            if (isValid == false) {
            	jsonData = fixMissingCommas(jsonData);
            }
            
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonData);
            
            if (Validator.isNotNull(jsonObject)) result = jsonObject.get(key).toString().replace("\"", "");
		} catch (Exception e) {
//			e.printStackTrace();
			_log.info(e.getMessage());
		}

		return result;
	}
	
	private boolean isValidJson(String json) {
        try {
        	ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
	private static final Pattern KEY_VALUE_PATTERN = Pattern.compile("^\"[^\"]+\"\\s*:");
	
	private String fixMissingCommas(String json) {
		String[] lines = json.split("\n");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String current = lines[i].trim();
            result.append(lines[i]);
            if (i < lines.length - 2 && KEY_VALUE_PATTERN.matcher(current).find() && !current.endsWith(",")) {
                String next = lines[i + 1].trim();
                if (KEY_VALUE_PATTERN.matcher(next).find()) {
                    result.append(",");
                }
            }
            result.append("\n");
        }
        return result.toString();
	}
	
	public String getConfigDummy() {
		String result = StringPool.BLANK;

		try {
			String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
            String filePath = liferayHome + "/smartpay.json";
            
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            
            boolean isValid = isValidJson(jsonData);
            
            if (isValid == false) {
            	jsonData = fixMissingCommas(jsonData);
            }
            
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonData);
            
            if (Validator.isNotNull(jsonObject)) result = jsonObject.get("getBody").toString();
		} catch (Exception e) {
			_log.info("Failed to get configuration");
		}

		return result;
	}
	
	public static class PolicyAccountSerializer implements JsonSerializer<PolicyAccountDto> {
        @Override
        public JsonElement serialize(PolicyAccountDto policy, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jsonObject = new JsonObject();

            jsonObject.add("policyNO", new JsonPrimitive(policy.getPolicyNO()));
            if (Validator.isNotNull(policy.getApplicationRk())) jsonObject.add("applicationRk", new JsonPrimitive(policy.getApplicationRk()));
            if (Validator.isNotNull(policy.getGeneralRk())) jsonObject.add("generalRk", new JsonPrimitive(policy.getGeneralRk()));
            if (Validator.isNotNull(policy.getPaidToDT())) jsonObject.add("paidToDT", new JsonPrimitive(policy.getPaidToDT()));
            if (Validator.isNotNull(policy.getPaymentStatusCd())) jsonObject.add("paymentStatusCd", new JsonPrimitive(policy.getPaymentStatusCd()));
            if (Validator.isNotNull(policy.getPolicyDueDt())) jsonObject.add("policyDueDt", new JsonPrimitive(policy.getPolicyDueDt()));
            if (Validator.isNotNull(policy.getPremiumAMT())) jsonObject.add("premiumAMT", new JsonPrimitive(policy.getPremiumAMT()));
            jsonObject.add("accountNo", new JsonPrimitive(policy.getAccountNo()));

            return jsonObject;
        }
    }
	
	public ResponseDto setupCallAPI(String url, String operation, BodyDto requestBody, HttpServletRequest httpRequest)
			throws Exception {
		ResponseDto response = new ResponseDto();

		HeaderDto requestHeader = new HeaderDto();
		SecurityContextDto securityContext = new SecurityContextDto();
		securityContext.setUsername(getConfig("com.axa.payment.config.eipUsername"));
		securityContext.setPassword(getConfig("com.axa.payment.config.eipPassword"));
		requestHeader.setSecurityContext(securityContext);

		PayloadDto payload = new PayloadDto();
		payload.setHeader(requestHeader);
		payload.setBody(requestBody);

		apiRequestBody = gsonSetup.toJson(payload);

		response = CallAPI(url, apiRequestBody);

		return response;
	}

	public BodyDto setupRequestBody(String operation, String service) {
		String bodyTransactionId = String.valueOf(System.currentTimeMillis() / 1000);
		BodyDto requestBody = new BodyDto();
		requestBody.setTransactionId(bodyTransactionId);
		requestBody.setAppID(getConfig("com.axa.payment.config.eipAppId"));
		requestBody.setEntity(getConfig("com.mypage.agent.config.eipEntity"));
		requestBody.setOperation(operation);
		requestBody.setService(service);

		return requestBody;
	}
	
	public ResponseDto CallAPI(String url, String payload) throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializerHelper());
		Gson gson = gsonBuilder.create();

		String line = StringPool.BLANK;
		String method = "POST";
		StringBuilder responseBody = new StringBuilder();
		ResponseDto response = new ResponseDto();
		
		if (isLog()) _log.info("Request Body to BE: " + payload);

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
						return null; //new X509Certificate[0];
					}
				} }, new SecureRandom());
	
				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
				
				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}
			
			connection.setRequestMethod(method);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setDoOutput(true);

			if (isLog()) _log.info("Check connection URL: " + connection.getURL());

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
			
			response = gson.fromJson(responseBody.toString(), ResponseDto.class);
			if (isLog()) _log.info("Response Code from BE: " + connection.getResponseCode());
			if (isLog()) _log.info("Response Msg from BE: " + connection.getResponseMessage());
			if (isLog()) _log.info("Response Body from BE: " + responseBody.toString());
		} catch (IOException e) {
			if (isLog()) _log.info("Failed api requests");
		}

		return response;
	}
	
	/**
	 * Call API with body payload JSON
	 * @throws KeyManagementException 
	 * @throws NoSuchAlgorithmException 
	 */
	public JSONObject hitAPI(String url, String payload, String token) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
        String line = StringPool.BLANK;
        String method = "POST";
        StringBuilder responseBody = new StringBuilder();
        int responseCode = 0;
        
		if (isLog()) _log.info("Request Body to DOKU: " + payload);
        
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
						return null; //new X509Certificate[0];
					}
				} }, new SecureRandom());
	
				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
				
				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}
			
            connection.setRequestMethod(Validator.isNotNull(payload) == true ? method : "GET");
            if (Validator.isNotNull(payload) == true) connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            
            JSONObject tokenSignature = JSONFactoryUtil.createJSONObject(token);
            
            if (isLog()) _log.info(tokenSignature.getString("Client-Id"));
            if (isLog()) _log.info(tokenSignature.getString("Request-Id"));
            if (isLog()) _log.info(tokenSignature.getString("Request-Timestamp"));
            if (isLog()) _log.info(tokenSignature.getString("Signature"));
            
            connection.setRequestProperty("Client-Id", tokenSignature.getString("Client-Id"));
            connection.setRequestProperty("Request-Id", tokenSignature.getString("Request-Id"));
            connection.setRequestProperty("Request-Timestamp", tokenSignature.getString("Request-Timestamp"));
            connection.setRequestProperty("Signature", tokenSignature.getString("Signature"));
            
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            if (Validator.isNotNull(payload) == true) connection.setDoOutput(true);
            
            if (Validator.isNotNull(payload) == true) { 
	            OutputStream outputStream = connection.getOutputStream();
	            outputStream.write(payload.getBytes());
	            outputStream.flush();
	            outputStream.close();
            }

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
            
            responseCode = connection.getResponseCode();
            if (isLog()) _log.info("Response Code from DOKU: " + connection.getResponseCode());
            if (isLog()) _log.info("Response Msg from DOKU: " + connection.getResponseMessage());
			if (isLog()) _log.info("Response Body from DOKU: " + responseBody.toString());
		} catch (IOException e) {
			if (isLog()) _log.info("Failed api requests");
		}
		
		_response.put("statusCode", responseCode);
		_response.put("response", responseBody.toString());
		
		return _response;
	}
}
