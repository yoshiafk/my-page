package com.mypage.esppk.helper;

import com.google.gson.JsonParser;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsUtil;
import com.mypage.esppk.constants.AiiEsppkWebPortletKeys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class ActionHelper {
    private static final Log log = LogFactoryUtil.getLog(ActionHelper.class);

    public String getPimcoreAddr() {
        return getConfig("com.mypage.agent.config.pimcoreAddress");
    }

    public String getLiferayAddr() {
        return getConfig("com.mypage.agent.config.liferayDomain");
    }

    public String statusDebitur(int esppkQ1, int esppkQ2, int esppkQ3) {
        if (esppkQ1 == 1 || esppkQ2 == 1 || esppkQ3 == 1) {
            return "NOT ELIGIBLE";
        }
        return "ELIGIBLE";
    }

    public String getConfig(String key) {
        String result = StringPool.BLANK;

        try {
            String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
            String filePath = liferayHome + "/agency-portal.json";

            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));

            boolean isValid = isValidJson(jsonData);

            if (!isValid) {
                jsonData = fixMissingCommas(jsonData);
            }

            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonData);

            if (Validator.isNotNull(jsonObject)) result = jsonObject.get(key).toString().replace("\"", "");
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return result;
    }

    public String sanitizeHtml(String input) {
        PolicyFactory policy = new HtmlPolicyBuilder().toFactory();

        return policy.sanitize(input);
    }

    public Long decryptDebiturId(String encrypted) {
        try {
            String decrypted = EncryptionHelper.decrypt(encrypted);
            return Long.parseLong(decrypted);
        } catch (Exception e) {
            log.debug("Decrypt failed: " + e.getMessage());
            return null;
        }
    }

    private boolean isValidJson(String json) {
        try {
            JsonParser parser = new JsonParser();
            parser.parse(json);
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

    public JSONObject errorMessage(String message, JSONObject data) {
        JSONObject response = JSONFactoryUtil.createJSONObject();
        response.put(AiiEsppkWebPortletKeys.RESPONSE_STATUS, 0);
        response.put(AiiEsppkWebPortletKeys.RESPONSE_MSG, message);
        response.put("Data", data);

        return response;
    }

    public JSONObject hitAPI(String url, String payload, String token) {
        JSONObject response = JSONFactoryUtil.createJSONObject();
        String line = StringPool.BLANK;
        StringBuilder responseBody = new StringBuilder();
        int responseCode = 0;

        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = null;

            if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
                HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();

                httpsConnection.setHostnameVerifier((requestedHost, remoteServerSession) ->
                    requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost())
                );

                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[] { new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
                        // empty
                    }

                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
                        // empty
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

            connection.setRequestMethod(payload.isEmpty() ? "GET" : "POST");
            if (!payload.isEmpty()) {
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
            }

            if (!token.isEmpty()) {
                connection.setRequestProperty("Authorization", token);
            }

            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.setDoOutput(true);

            if (!payload.isEmpty()) {
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
        } catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
            log.info("Failed api requests");
        }

        response.put("statusCode", responseCode);
        response.put("response", responseBody.toString());

        return response;
    }
}
