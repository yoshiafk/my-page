package com.axa.payment.helpers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SignatureHelper {
	private static String CLIENT_ID = "Client-Id";
    private static String REQUEST_ID = "Request-Id";
    private static String REQUEST_TIMESTAMP = "Request-Timestamp";
    private static String REQUEST_TARGET = "Request-Target";
    private static String DIGEST = "Digest";
    private static String COLON_SYMBOL = ":";
    private static String NEW_LINE = "\n";
    private static Log _log = LogFactoryUtil.getLog(SignatureHelper.class);
    private static ActionHelper helper = new ActionHelper();
	
	public static String generateDigest(String requestBody) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(requestBody.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return Base64.getEncoder().encodeToString(digest);
    }
	
	public static String generateSignature(String clientId, String requestId, String requestTimestamp, String requestTarget, String digest, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
		StringBuilder component = new StringBuilder();
        component.append(CLIENT_ID).append(COLON_SYMBOL).append(clientId);
        component.append(NEW_LINE);
        component.append(REQUEST_ID).append(COLON_SYMBOL).append(requestId);
        component.append(NEW_LINE);
        component.append(REQUEST_TIMESTAMP).append(COLON_SYMBOL).append(requestTimestamp);
        component.append(NEW_LINE);
        component.append(REQUEST_TARGET).append(COLON_SYMBOL).append(requestTarget);
        if(digest != null && !digest.isEmpty()) {
            component.append(NEW_LINE);
            component.append(DIGEST).append(COLON_SYMBOL).append(digest);
        }
        
        if (helper.isLog()) _log.info(component.toString());
        
        byte[] decodedKey = secret.getBytes();
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        hmacSha256.init(originalKey);
        hmacSha256.update(component.toString().getBytes());
        byte[] HmacSha256DigestBytes = hmacSha256.doFinal();
        String signature = Base64.getEncoder().encodeToString(HmacSha256DigestBytes);
        return "HMACSHA256=".concat(signature);
    }
	
	// Fungsi untuk memformat JSON menjadi bentuk yang lebih terbaca dengan 2 spasi
	public static String beautifyJson(String json) {
        StringBuilder beautifiedJson = new StringBuilder();
        int indentLevel = 0;
        boolean insideString = false; // Menandai apakah kita berada dalam nilai string (diapit tanda kutip)

        // Loop melalui setiap karakter dalam JSON string
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            switch (c) {
                case '{':
                case '[':
                    if (!insideString) {
                        beautifiedJson.append(c);
                        beautifiedJson.append("\n");
                        indentLevel++;
                        appendIndentation(beautifiedJson, indentLevel);
                    } else {
                        beautifiedJson.append(c);
                    }
                    break;

                case '}':
                case ']':
                    if (!insideString) {
                        beautifiedJson.append("\n");
                        indentLevel--;
                        appendIndentation(beautifiedJson, indentLevel);
                        beautifiedJson.append(c);
                    } else {
                        beautifiedJson.append(c);
                    }
                    break;

                case ',':
                    if (!insideString) {
                        beautifiedJson.append(c);
                        beautifiedJson.append("\n");
                        appendIndentation(beautifiedJson, indentLevel);
                    } else {
                        beautifiedJson.append(c);
                    }
                    break;

                case ':':
                    if (!insideString) {
                        beautifiedJson.append(c).append(" "); // Tambahkan spasi setelah titik dua hanya di luar string
                    } else {
                        beautifiedJson.append(c);
                    }
                    break;

                case '"':
                    beautifiedJson.append(c);
                    // Berpindah state apakah sedang di dalam atau di luar string
                    insideString = !insideString;
                    break;

                default:
                    beautifiedJson.append(c);
                    break;
            }
        }

        return beautifiedJson.toString();
    }
	
	// Fungsi untuk menambahkan indentasi (2 spasi) sesuai level indentasi
    public static void appendIndentation(StringBuilder sb, int level) {
        for (int i = 0; i < level; i++) {
            sb.append("  "); // Gunakan 2 spasi untuk indentasi
        }
    }
    
    public static String minifyJson(String json) {
        StringBuilder minifiedJson = new StringBuilder();
        boolean insideString = false;

        for (int i = 0; i < json.length(); i++) {
            char currentChar = json.charAt(i);

            // Toggle the insideString flag if we encounter an unescaped double-quote
            if (currentChar == '"' && (i == 0 || json.charAt(i - 1) != '\\')) {
                insideString = !insideString;
            }

            // Append the character if inside a string or if it is not whitespace
            if (insideString || !Character.isWhitespace(currentChar)) {
                minifiedJson.append(currentChar);
            }
        }

        return minifiedJson.toString();
    }
}
