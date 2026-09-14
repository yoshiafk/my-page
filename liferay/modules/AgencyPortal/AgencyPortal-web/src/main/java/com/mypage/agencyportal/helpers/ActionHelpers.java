package com.mypage.agencyportal.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.base.BodyBase;
import com.mypage.agencyportal.constants.AgentPagePortletKeys;
import com.mypage.agencyportal.constants.AgentPerformanceBookingPortletKeys;
import com.mypage.agencyportal.dto.APIResponse;
import com.mypage.agencyportal.dto.HeaderDto;
import com.mypage.agencyportal.dto.PayloadDto;
import com.mypage.agencyportal.dto.ResponseDto;
import com.mypage.agencyportal.dto.SecurityContextDto;
import com.mypage.agencyportal.dto.StatusUserDto;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalServiceUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class ActionHelpers {
	private static String apiRequestBody;

	private String securityContextUsername = getConfig("com.mypage.agent.config.eipUsername");
	private String securityContextPassword = getConfig("com.mypage.agent.config.eipPassword");
	private String bodyTransactionId = getConfig("com.mypage.agent.config.eipTransactionId");
	private String bodyAppId = getConfig("com.mypage.agent.config.eipAppId");
	private String bodyEntity = getConfig("com.mypage.agent.config.eipEntity");

	private static GsonBuilder gsonBuilderSetup = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
	private static Gson gsonSetup = gsonBuilderSetup.create();
	
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(ActionHelpers.class);

	public String ConvertDateFormat(String dateString, String format) {
		String inputFormat = "EEE MMM dd HH:mm:ss zzz yyyy";

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(inputFormat);
			Date date = dateFormat.parse(dateString);

			dateFormat = new SimpleDateFormat(format);
			String formatted = dateFormat.format(date);

			return formatted;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean isParsableToDouble(String value) {
	    try {
	        Double.parseDouble(value);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	public String ConvertAmountFormat(double amount) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator('.');

		DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
		return decimalFormat.format(amount);
	}

	public String getMonthAbbreviation(int dataMonth) {
		String[] monthAbbreviations = { AgentPerformanceBookingPortletKeys.MONTH_ABBR_JANUARY,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_FEBRUARY,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_MARCH,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_APRIL,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_MAY,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_JUNE,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_JULY,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_AUGUST,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_SEPTEMBER,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_OCTOBER,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_NOVEMBER,
				AgentPerformanceBookingPortletKeys.MONTH_ABBR_DECEMBER };

		return monthAbbreviations[dataMonth - 1];
	}

	public String getMonthLong(int dataMonth) {
		String[] monthAbbreviations = { AgentPerformanceBookingPortletKeys.MONTH_LONG_JANUARY,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_FEBRUARY,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_MARCH,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_APRIL,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_MAY,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_JUNE,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_JULY,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_AUGUST,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_SEPTEMBER,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_OCTOBER,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_NOVEMBER,
				AgentPerformanceBookingPortletKeys.MONTH_LONG_DECEMBER };

		return monthAbbreviations[dataMonth - 1];
	}
	
	public String getDayLong(String dataDay) {
		HashMap<String, String> dayLongMap = new HashMap<>();
        dayLongMap.put("senin", AgentPagePortletKeys.DAY_LONG_MONDAY);
        dayLongMap.put("selasa", AgentPagePortletKeys.DAY_LONG_TUESDAY);
        dayLongMap.put("rabu", AgentPagePortletKeys.DAY_LONG_WEDNESDAY);
        dayLongMap.put("kamis", AgentPagePortletKeys.DAY_LONG_THURSDAY);
        dayLongMap.put("jumat", AgentPagePortletKeys.DAY_LONG_FRIDAY);
        dayLongMap.put("sabtu", AgentPagePortletKeys.DAY_LONG_SATURDAY);
        dayLongMap.put("minggu", AgentPagePortletKeys.DAY_LONG_SUNDAY);

		return dayLongMap.get(dataDay);
	}
	
	public String getCobDescription(String cob) {
		HashMap<String, String> cobMap = new HashMap<>();
		cobMap.put("01", AgentPerformanceBookingPortletKeys.COB_01);
		cobMap.put("02", AgentPerformanceBookingPortletKeys.COB_02);
		cobMap.put("03", AgentPerformanceBookingPortletKeys.COB_03);
		cobMap.put("04", AgentPerformanceBookingPortletKeys.COB_04);
		cobMap.put("05", AgentPerformanceBookingPortletKeys.COB_05);
		cobMap.put("06", AgentPerformanceBookingPortletKeys.COB_06);
		cobMap.put("07", AgentPerformanceBookingPortletKeys.COB_07);
		cobMap.put("08", AgentPerformanceBookingPortletKeys.COB_08);
		cobMap.put("09", AgentPerformanceBookingPortletKeys.COB_09);
		cobMap.put("10", AgentPerformanceBookingPortletKeys.COB_10);
		cobMap.put("11", AgentPerformanceBookingPortletKeys.COB_11);
		cobMap.put("12", AgentPerformanceBookingPortletKeys.COB_12);
		cobMap.put("13", AgentPerformanceBookingPortletKeys.COB_13);
		cobMap.put("TR", AgentPerformanceBookingPortletKeys.COB_TR);

		return cobMap.get(cob);
	}
	
	public boolean passwordValidation(String password, String confirmPassword) {

	    Pattern specialCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	    Pattern upperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");

	    if (password.equalsIgnoreCase(confirmPassword) == false) {
			if (isLog()) _log.info("Confirm password must be equal password");
	        return false;
	    }
	    
	    if (password.length() < 8) {
	    	if (isLog()) _log.info("Password min 8 char");
	        return false;
	    }
	    
	    if (specialCharPatten.matcher(password).find() == false) {
	    	if (isLog()) _log.info("Must contain a special char");
	        return false;
	    }
	    
	    if (upperCasePatten.matcher(password).find() == false) {
	    	if (isLog()) _log.info("Must contain an uppercase");
	        return false;
	    }
	    
	    if (lowerCasePatten.matcher(password).find() == false) {
	    	if (isLog()) _log.info("Must contain a lowercase");
	        return false;
	    }
	    
	    if (digitCasePatten.matcher(password).find() == false) {
	    	if (isLog()) _log.info("Must contain a number");
	        return false;
	    }

	    return true;

	}

	public int getWeekNumber(String date) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date transactionDate = dateFormat.parse(date);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(transactionDate);

		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int weekNumber = (dayOfMonth - 1) / 7 + 1;

		// Membetulkan minggu terakhir jika masih di bulan berikutnya
		if (weekNumber > 4) {
			weekNumber = 4;
		}

		return weekNumber;
	}

	public int getQuarterByMonthName(String month) {
		switch (month.toLowerCase()) {
		case "jan":
		case "feb":
		case "mar":
			return 1;
		case "apr":
		case "may":
		case "june":
			return 2;
		case "july":
		case "aug":
		case "sept":
			return 3;
		case "oct":
		case "nov":
		case "dec":
			return 4;
		default:
			return 0;
		}
	}
	
	public int getQuarterByMonthNumber(int month) {
        if (month >= 1 && month <= 3) return 1;
        if (month >= 4 && month <= 6) return 2;
        if (month >= 7 && month <= 9) return 3;
        return 4;
    }

	public void mergeAmountWeekData(Map<Integer, Double> weeklyTotalMap, int targetWeek, int sourceWeek) {
		double sourceWeekTotal = weeklyTotalMap.getOrDefault(sourceWeek, 0.0);

		// Menambahkan jumlah dari minggu source ke minggu target
		weeklyTotalMap.merge(targetWeek, sourceWeekTotal, Double::sum);
	}

	public void mergeProductWeekData(Map<Integer, Map<String, Double>> weeklyProductSumMap, int targetWeek,
			int sourceWeek) {
		Map<String, Double> sourceProductSumMap = weeklyProductSumMap.getOrDefault(sourceWeek, Collections.emptyMap());

		// Menambahkan produk dan jumlah dari minggu source ke minggu target
		weeklyProductSumMap.computeIfAbsent(targetWeek, k -> new HashMap<>()).putAll(sourceProductSumMap);
	}

	public byte[] convertHtmlToPdf(String html) throws IOException {
		try (ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream()) {
			HtmlConverter.convertToPdf(html, pdfOutputStream);

			return pdfOutputStream.toByteArray();
		}
	}

	public String getFileContent(InputStream inputStream) throws IOException {
		StringBuilder content = new StringBuilder();
		int ch;

		while ((ch = inputStream.read()) != -1) {
			content.append((char) ch);
		}

		return content.toString();
	}

	public String getEmail(JSONObject params) {
		String username = params.getString("Username");

		if (Validator.isEmailAddress(username) == false) {
			MypageUser mypageUser = MypageUserLocalServiceUtil.getByAgentCode(username);

			if (Validator.isNotNull(mypageUser)) {
				User user = UserLocalServiceUtil.fetchUser(mypageUser.getLiferayUserId());
				username = user.getEmailAddress();
			}
		}

		return username;
	}

	public String obfuscateEmail(String email) {
		int atIndex = email.indexOf('@');
		int dotIndex = email.indexOf('.');

		if (atIndex == -1 || dotIndex == -1) {
			return email;
		}

		String username = email.substring(0, atIndex);
		String domain = email.substring(atIndex + 1, dotIndex);
		String afterDomain = email.substring(dotIndex);

		String obfuscatedEmail = obfuscateString(username, "email").concat("@")
				.concat(obfuscateString(domain, "domain")).concat(afterDomain);

		return obfuscatedEmail;
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

		return obfuscated;
	}

	public StatusUserDto checkUserExist(JSONObject params) throws Exception {
		String username = getEmail(params);
		byte[] encryptedBytes = Base64.getDecoder().decode(params.getString("Password"));
		String password = new String(encryptedBytes);
		String encryptedPassword = EncryptionHelper.encryptPassword(password);

		StatusUserDto statusUser = new StatusUserDto();

		if (Validator.isEmailAddress(username)) {
			MypageUser user = MypageUserLocalServiceUtil.getUserByEmail(username);
			long userId = user.getMypageUserId();
			String status = user.getStatus();
			long currentTime = System.currentTimeMillis() / 1000;
			long expiresTime = status.equalsIgnoreCase("active") == true
					? (user.getEndDate().getTime() / 1000) + (-7 * 3600)
					: status.equalsIgnoreCase("locked") == true
							? (user.getLastSubmitLoginDate().getTime() / 1000) + (-7 * 3600 + 600)
							: 0;

			statusUser.setUserId(userId);
			statusUser.setAuthUserId(userId);
			statusUser.setStatus(status);
			if (status.equalsIgnoreCase("active"))
				statusUser.setExpiresTime(expiresTime);

			if ((status.equalsIgnoreCase("active") && expiresTime > currentTime)
					|| (status.equalsIgnoreCase("locked") && currentTime > expiresTime)) {
				if (Validator.isNotNull(password)) {
					userId = MypageUserLocalServiceUtil.authenticateForBasic(username, encryptedPassword);
					statusUser.setUserId(userId);

					if (status.equalsIgnoreCase("locked") && userId > 0)
						statusUser.setIsTimetoUnlock(true);
				}
			}
		}

		return statusUser;
	}

	public String getOTP(int len) {
		String otp = StringPool.BLANK;

		try {
			SecureRandom secureRandom = SecureRandom.getInstanceStrong();

			int upperBound = (int) Math.pow(10, len);
			otp = String.valueOf(secureRandom.nextInt(upperBound));

			if (otp.length() < len)
				otp = "0".concat(otp);
		} catch (NoSuchAlgorithmException e) {
			if (isLog()) _log.info("Failed to send OTP");
		}

		return otp;
	}
	
	public boolean isLog() {
        return Boolean.valueOf(getConfig("com.mypage.agent.config.showLog"));
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
	
	public String getConfigDummy(String key) {
		String result = StringPool.BLANK;

		try {
			String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME); // System.getProperty("catalina.base");
            String filePath = liferayHome + "/dummy.json";
			
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
            
            if (Validator.isNotNull(jsonObject)) result = jsonObject.get(key).toString();
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
	
	public String sanitizeHtml(String input) {
		PolicyFactory policy = new HtmlPolicyBuilder().toFactory();
		
        return policy.sanitize(input);
    }

	public <T extends BodyBase> T setupRequestBody(Class<T> clazz, String operation, String service, String application) throws Exception {
		try {
	        T requestBody = clazz.getDeclaredConstructor().newInstance();

	        requestBody.setTransactionId(bodyTransactionId);
	        requestBody.setAppID(Validator.isNull(application) ? bodyAppId : application);
	        requestBody.setEntity(bodyEntity);
	        requestBody.setOperation(operation);
	        requestBody.setService(service);

	        return requestBody;
	    } catch (Exception e) {
	    	_log.info("Failed to instantiate request body");
			return null;
	    }
	}

	public <T> ResponseDto<T> setupCallAPI(String url, String operation, Type typeOfResponse, T requestBodyObj, HttpServletRequest httpRequest)
			throws Exception {
		ResponseDto<T> response = new ResponseDto<T>();

		HeaderDto requestHeader = new HeaderDto();
		SecurityContextDto securityContext = new SecurityContextDto();

		String username;
		String password;

		if ("getTripReward".equalsIgnoreCase(operation)) {
			username = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Scorecard").stream()
					.filter(v -> "username miles".equalsIgnoreCase(v.getName()) && v.getActive() == 1)
					.map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "" : v.getValue())
					.findFirst()
					.orElse("");

			password = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Scorecard").stream()
					.filter(v -> "password miles".equalsIgnoreCase(v.getName()) && v.getActive() == 1)
					.map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "" : v.getValue())
					.findFirst()
					.orElse("");
		} else {
			username = securityContextUsername;
			password = securityContextPassword;
		}

		securityContext.setUsername(username);
		securityContext.setPassword(password);
		requestHeader.setSecurityContext(securityContext);

		PayloadDto<T> payload = new PayloadDto<T>();
		payload.setHeader(requestHeader);
		payload.setBody(requestBodyObj);

		apiRequestBody = gsonSetup.toJson(payload);

		response = CallAPI(url, apiRequestBody, typeOfResponse);

		return response;
	}

	protected <T> ResponseDto<T> CallAPI(String url, String payload, Type typeOfResponse) throws Exception {
		GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer());
		Gson gson = gsonBuilder.create();

		String line = StringPool.BLANK;
		String method = "POST";
		StringBuilder responseBody = new StringBuilder();
		ResponseDto<T> response = new ResponseDto<>();

		if (payload.contains("dummy")) {
			if (payload.contains("getProfileAgentAlias")) {
				response = gson.fromJson(getConfigDummy("getProfileAgentAlias"), typeOfResponse);
			} else if (payload.contains("getProfileAgent")) {
				response = gson.fromJson(getConfigDummy("getProfileAgent"), typeOfResponse);
			} else if (payload.contains("getClubYears")) {
				response = gson.fromJson(getConfigDummy("getClubYears"), typeOfResponse);
			} else if (payload.contains("getDailyAgent") && !payload.contains("page")) {
				response = gson.fromJson(getConfigDummy("getDailyAgent"), typeOfResponse);
			} else if (payload.contains("getMonthlyAgentByLob")) {
				response = gson.fromJson(getConfigDummy("getMonthlyAgentByLob"), typeOfResponse);
			} else if (payload.contains("getDailyAgent") && payload.contains("page")) {
				response = gson.fromJson(getConfigDummy("getDailyAllAgent"), typeOfResponse);
			} else if (payload.contains("getTripReward")) {
				response = gson.fromJson(getConfigDummy("getTripReward"), typeOfResponse);
			} else {
				response = gson.fromJson(responseBody.toString(), typeOfResponse);
			}

			response.setStatusCode(200);
			return response;
		}


		try {
			URL requestUrl = new URL(url);
			
			HttpURLConnection connection = null;

			if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();
				
//				httpsConnection.setHostnameVerifier((hostname, session) -> true);
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
//                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//                trustManagerFactory.init((KeyStore) null);
//                
//                SSLContext sslContext = SSLContext.getInstance("TLS");
//                sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
	
				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
				
				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}
			
			connection.setRequestMethod(method);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
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

			response = gson.fromJson(responseBody.toString(), typeOfResponse);
			response.setStatusCode(connection.getResponseCode());
		} catch (IOException e) {
			if (isLog()) _log.info("Failed api requests");
		}

		return response;
	}

	/**
	 * this function for response general object
	 * 
	 * @param <T>                 generics type
	 * @param url                 base url
	 * @param paramsPostDataBytes params req
	 * @param clazz               class spesific
	 * @return spesific response dto
	 * @content type for form-data / x-www-form-urlencoded
	 */
	public <T> APIResponse<T> APIClients(String url, byte[] paramsPostDataBytes, Class<T> clazz, String token) {
		APIResponse<T> apiResponse = null;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        int maxRetries = 3;
        int currentRetry = 1;

        while (currentRetry <= maxRetries) {
            try {
                URL requestUrl = new URL(url);

    			if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
    				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();
    				
//    				httpsConnection.setHostnameVerifier((hostname, session) -> true);
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
//                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//                    trustManagerFactory.init((KeyStore) null);
//                    
//                    SSLContext sslContext = SSLContext.getInstance("TLS");
//                    sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
    	
    				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
    				
    				connection = httpsConnection;            
    			} else {
    				connection = (HttpURLConnection) requestUrl.openConnection();
    			}

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                
//                JSONObject tokenSignature = JSONFactoryUtil.createJSONObject(token);
//                
//                connection.setRequestProperty("User-Id", tokenSignature.getString("User-Id"));
//                connection.setRequestProperty("Request-Id", tokenSignature.getString("Request-Id"));
//                connection.setRequestProperty("Request-Timestamp", tokenSignature.getString("Request-Timestamp"));
//                connection.setRequestProperty("Signature", tokenSignature.getString("Signature"));
                
                connection.setRequestProperty("Authorization", token); // Set Authorization header

                connection.setConnectTimeout(60000);
                connection.setReadTimeout(60000);
                connection.setDoOutput(true);

                try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                	if(paramsPostDataBytes != null) {
                		wr.write(paramsPostDataBytes);
                	}
                }

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    Gson gson = new Gson();
                    Type responseType = TypeToken.getParameterized(APIResponse.class, clazz).getType();
                    apiResponse = gson.fromJson(response.toString(), responseType);
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    StringBuilder errorResponse = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        errorResponse.append(line);
                    }
                }

                break; // Break out of the retry loop if successful
            } catch (Exception e) {
            	if (isLog()) _log.info("Failed api requests");
                currentRetry++;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                    	if (isLog()) _log.info("Failed api requests");
                    }
                }
            }
        }

        return apiResponse;
    }
	
	
	/**
	 * Call API with body payload JSON
	 * @throws KeyManagementException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static JSONObject hitAPI(String url, String payload, String token) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
        String line = StringPool.BLANK;
        StringBuilder responseBody = new StringBuilder();
        int responseCode = 0;
        
		try {
			URL requestUrl = new URL(url);
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
			HttpURLConnection connection = null;

			if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();
				
//				httpsConnection.setHostnameVerifier((hostname, session) -> true);
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
//	            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//                trustManagerFactory.init((KeyStore) null);
//                
//                SSLContext sslContext = SSLContext.getInstance("TLS");
//                sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
	
				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
				
				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}
			
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            
//            JSONObject tokenSignature = JSONFactoryUtil.createJSONObject(token);
//            
//            connection.setRequestProperty("User-Id", tokenSignature.getString("User-Id"));
//            connection.setRequestProperty("Request-Id", tokenSignature.getString("Request-Id"));
//            connection.setRequestProperty("Request-Timestamp", tokenSignature.getString("Request-Timestamp"));
//            connection.setRequestProperty("Signature", tokenSignature.getString("Signature"));
            
            connection.setRequestProperty("Authorization", token); // Set Authorization header
            
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
            
            responseCode = connection.getResponseCode();
		} catch (IOException e) {
			_log.info("Failed api requests");
		}
		
		_response.put("statusCode", responseCode);
		_response.put("response", responseBody.toString());
		
		return _response;
	}
}