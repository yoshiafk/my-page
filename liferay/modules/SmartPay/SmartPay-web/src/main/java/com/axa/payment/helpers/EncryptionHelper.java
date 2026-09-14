package com.axa.payment.helpers;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionHelper {
	private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "MyPageAx@t0werrMyPageAx@L1feR4yy".getBytes(StandardCharsets.UTF_8);
    private static final String MODE = "AES/GCM/NoPadding";
    
    /**
     * encrypt with AES algoritm
     * 
     * @param input
     * @return
     * @throws Exception
     */
    public static String encrypt(String input) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        SecureRandom secureRandom = new SecureRandom();
        int ivLength = 12;
		byte[] iv = new byte[ivLength];
		secureRandom.nextBytes(iv);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, iv);
        Cipher cipher = Cipher.getInstance(MODE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
        byte[] combined = new byte[iv.length + encryptedBytes.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(encryptedBytes, 0, combined, iv.length, encryptedBytes.length);
        return Base64.getEncoder().encodeToString(combined).replace('+', '-').replace('/', '_').replace("=", "");
    }
    
    /**
     * decrypt with AES algoritm
     * 
     * @param encrypted
     * @return
     * @throws Exception
     */
    public static String decrypt(String encrypted) throws Exception {
    	encrypted = encrypted.replace('-', '+').replace('_', '/');
		byte[] ciphertextComplete = Base64.getDecoder().decode(encrypted);
		byte[] iv = Arrays.copyOfRange(ciphertextComplete, 0, 12);
		byte[] ciphertextWithTag = Arrays.copyOfRange(ciphertextComplete, 12, ciphertextComplete.length);
		SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, ALGORITHM);
		GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, iv);
		Cipher cipher = Cipher.getInstance(MODE);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);
		return new String(cipher.doFinal(ciphertextWithTag), StandardCharsets.UTF_8);
    }
}
