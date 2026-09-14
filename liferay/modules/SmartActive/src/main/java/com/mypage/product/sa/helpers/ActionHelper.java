package com.mypage.product.sa.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ActionHelper {
	
	public boolean isLog() {
        return Boolean.valueOf(getConfig("com.mypage.agent.config.showLog"));
	}
	
	public String getPimcoreHost() {
        return getConfig("com.mypage.agent.config.pimcoreHost");
	}
	
	public String getPimcoreAddr() {
        return getConfig("com.mypage.agent.config.pimcoreAddress");
	}
	
	public String getLiferayHost() {
        return getConfig("com.mypage.agent.config.liferayDomain");
	}
	
	public String getOcrClientHost() {
        return getConfig("com.mypage.agent.config.ocrClientHostURL");
	}
	
	public String getOcrClientUrl() {
        return getConfig("com.mypage.agent.config.ocrClientPathURL");
	}
	
	public String getOcrClientKey() {
        return getConfig("com.mypage.agent.config.ocrClientApiKey");
	}
	
	public String getOcrClientAuth() {
        return getConfig("com.mypage.agent.config.ocrClientAuthHeader");
	}
	
	/**
	 * Get web content by Friendly URL
	 * @param friendlyUrl
	 * @param themeDisplay
	 * @return
	 */
	public static String getWebContentByFriendlyUrl(String friendlyUrl, ThemeDisplay themeDisplay) {
		long groupId = themeDisplay.getScopeGroupId();
		String webContent = "";
		try {
			JournalArticle _webContent = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, friendlyUrl);
			JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
					_webContent.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay);
			webContent = articleDisplay.getContent();
		} catch (PortalException e) {
			_log.info(e.getMessage());
		}

		return webContent;
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
	
	public static String capitalizeEachWord(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split("\\s+");
        StringBuilder capitalizedString = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                capitalizedString.append(capitalizedWord).append(" ");
            }
        }

        return capitalizedString.toString().trim();
    }

	// Format date string to yyyy-mm-dd for database
	public static String customFormatDate(String dateStr) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate date = LocalDate.parse(dateStr, inputFormatter);
		String formattedDate = date.format(outputFormatter);
		return formattedDate;
	}

	public static String customFormatDateTime(String dateStr) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate date = LocalDate.parse(dateStr, inputFormatter);
		String formattedDate = date.format(outputFormatter);
		return formattedDate + " 00:00:00";
	}

	public static String _customFormatDate(Date date) {
	    if (date == null) {
	        return null;
	    }
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return sdf.format(date);
	}

	public String parseDate(String dateStr) {
	    for (String[] month : MONTHS) {
	        dateStr = dateStr.replaceAll("\\b" + month[0] + "\\b", month[1]); 
	    }

		Date dobParsed = null;
		
		try {
			dobParsed = inputFormat.parse(dateStr);

			return outputFormat.format(dobParsed);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Map<String, Object> convertJsonToMap(String jsonInput) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonInput, LinkedHashMap.class); 
        } catch (Exception e) {
            throw new RuntimeException("Invalid JSON format", e);
        }
    }
	
	/**
	 * 
	 * @param data eg: IDR 10,000,000 atau IDR 25,000/day upto IDR 750,000
	 * 
	 * 
	 * @return 10000000 atau 750000
	 */
	public static BigDecimal extractBigDecimal(String data) {
        // Regex to find the last numeric value in the string
        String regex = "(\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?)\\D*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            // Remove commas and convert to BigDecimal
            String numericValue = matcher.group(1).replace(",", "");
            return new BigDecimal(numericValue);
        }

        return null;
    }
	
	public boolean validateInput(String input, String type) {
        Pattern pattern;
        switch (type.toLowerCase()) {
	        case "text":
	            pattern = Pattern.compile("^[A-Za-z ]+$"); // Only letters and spaces
	            break;
	        case "num":
	            pattern = Pattern.compile("^[0-9]+$"); // Only numbers
	            break;
	        case "textnum":
	            pattern = Pattern.compile("^[A-Za-z0-9 ]+$"); // Letters, numbers, and spaces
	            break;
	        case "email":
	            pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"); // Proper email format
	            break;
	        case "addr":
	            pattern = Pattern.compile("^[A-Za-z0-9., ]+$"); // Alphanumeric + ., and spaces
	            break;
	        default:
	            return false;
	    }

        // Validate input against the selected pattern
        return pattern.matcher(input).matches();
    }
	
	/**
	 * Call API with body payload JSON
	 * @throws KeyManagementException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static JSONObject hitAPI(String url, String payload, String token) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
        String line = StringPool.BLANK;
        String method = Validator.isNull(payload) ? "GET" : "POST";
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
			
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            
//            JSONObject tokenSignature = JSONFactoryUtil.createJSONObject(token);
//            
//            connection.setRequestProperty("User-Id", tokenSignature.getString("User-Id"));
//            connection.setRequestProperty("Request-Id", tokenSignature.getString("Request-Id"));
//            connection.setRequestProperty("Request-Timestamp", tokenSignature.getString("Request-Timestamp"));
//            connection.setRequestProperty("Signature", tokenSignature.getString("Signature"));
            
            if (Validator.isNotNull(token)) connection.setRequestProperty("Authorization", token); // Set Authorization header
            
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.setDoOutput(true);
            
            if (Validator.isNotNull(payload)) {
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
		} catch (IOException e) {
			_log.info("Failed api requests " + e.getMessage());
		}
		
		_response.put("statusCode", responseCode);
		_response.put("response", responseBody.toString());
		
		return _response;
	}
	
	/**
	 * Call API
	 */
	public static JSONObject callAPI(String payload, String targetUrl) throws Exception, IOException {
	    Gson gson = new Gson();
	    String line = StringPool.BLANK;
	    StringBuilder responseBody = new StringBuilder();
	    
	    _log.info("Url Request PromoCode:" + targetUrl);

	    boolean isSSL = targetUrl.contains("https");

	    URLConnection connection;
	    try {
	        URL requestUrl = new URL(targetUrl);

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

	    } catch (IOException e) {
	    	_log.info("Error Request PromoCode:");
	        throw e;
	    }

	    JSONObject _response = JSONFactoryUtil.createJSONObject(responseBody.toString());
	    return _response;
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
	
	private static Log _log = LogFactoryUtil.getLog(ActionHelper.class);
	
	private final SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	
	private final SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

	private static final String[][] MONTHS = { 
		{ "Jan", "January" }, 
		{ "Feb", "February" },
		{ "Mar", "March" }, 
		{ "Apr", "April" }, 
		{ "Mei", "May" }, 
		{ "May", "May" }, 
		{ "Jun", "June" }, 
		{ "Jul", "July" }, 
		{ "Agu", "August" },
		{ "Aug", "August" },
		{ "Agt", "August" },
		{ "Sep", "September" }, 
		{ "Okt", "October" }, 
		{ "Oct", "October" }, 
		{ "Nop", "November" },
		{ "Nov", "November" },
		{ "Des", "December" },
		{ "Dec", "December" } 
	};
}
