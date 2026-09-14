package com.mypage.agencyportal.helpers;

import com.liferay.petra.string.StringPool;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SignatureHelper {
	private static String USER_ID = "User-Id";
    private static String REQUEST_ID = "Request-Id";
    private static String REQUEST_TIMESTAMP = "Request-Timestamp";
    private static String DIGEST = "Digest";
    private static String COLON_SYMBOL = ":";
    private static String NEW_LINE = "\n";
	private static LogHelper<Object> logs = new LogHelper<>();
	
	public static String generateDigest(String requestBody) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(requestBody.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return Base64.getEncoder().encodeToString(digest);
    }
	
	public static String generateSignature(String userId, String requestId, String requestTimestamp, String digest) throws NoSuchAlgorithmException, InvalidKeyException {
		StringBuilder component = new StringBuilder();
        component.append(USER_ID).append(COLON_SYMBOL).append(userId);
        component.append(NEW_LINE);
        component.append(REQUEST_ID).append(COLON_SYMBOL).append(requestId);
        component.append(NEW_LINE);
        component.append(REQUEST_TIMESTAMP).append(COLON_SYMBOL).append(requestTimestamp);
        component.append(NEW_LINE);
        component.append(DIGEST).append(COLON_SYMBOL).append(digest);
        
        logs.log(component.toString());
        
        List<MasterGlobalVariable> listToken = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("token");
		String secret = StringPool.BLANK;
		
		for (MasterGlobalVariable item : listToken) {
			if (item.getName().equalsIgnoreCase("secret signature")) secret = item.getValue();
		}
        
        byte[] decodedKey = secret.getBytes();
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        hmacSha256.init(originalKey);
        hmacSha256.update(component.toString().getBytes());
        byte[] HmacSha256DigestBytes = hmacSha256.doFinal();
        String signature = Base64.getEncoder().encodeToString(HmacSha256DigestBytes);
        return "HMACSHA256=".concat(signature);
    }
}
