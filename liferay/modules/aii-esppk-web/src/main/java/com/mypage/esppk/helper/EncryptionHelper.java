package com.mypage.esppk.helper;

import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class EncryptionHelper {

    private EncryptionHelper() {}

    private static final String ALGORITHM = "AES";
    private static final String MODE = "AES/GCM/NoPadding";
    private static final String MASTER_GLOBAL_VAR_TOKEN_GROUP = "Token";
    private static final String MASTER_GLOBAL_VAR_TOKEN_ENCRYPTKEY = "Encrypt_Key";

    public static String encrypt(String input) throws InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        String encryptKey = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(MASTER_GLOBAL_VAR_TOKEN_GROUP).stream()
                .filter(v -> v.getName().equalsIgnoreCase(MASTER_GLOBAL_VAR_TOKEN_ENCRYPTKEY) && v.getActive() == 1).findFirst()
                .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "" : v.getValue()).orElse("");

        byte[] encryptKeyByte = encryptKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKey = new SecretKeySpec(encryptKeyByte, ALGORITHM);
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
        return Base64.getEncoder().encodeToString(combined).replace("+", "-").replace("/", "_").replace("=", "");
    }

    public static String decrypt(String encrypted) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String encryptKey = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(MASTER_GLOBAL_VAR_TOKEN_GROUP).stream()
                .filter(v -> v.getName().equalsIgnoreCase(MASTER_GLOBAL_VAR_TOKEN_ENCRYPTKEY) && v.getActive() == 1).findFirst()
                .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "" : v.getValue()).orElse("");

        byte[] encryptKeyByte = encryptKey.getBytes(StandardCharsets.UTF_8);
        encrypted = encrypted.replace('-', '+').replace('_', '/');
        byte[] ciphertextComplete = Base64.getDecoder().decode(encrypted);
        byte[] iv = Arrays.copyOfRange(ciphertextComplete, 0, 12);
        byte[] ciphertextWithTag = Arrays.copyOfRange(ciphertextComplete, 12, ciphertextComplete.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(encryptKeyByte, ALGORITHM);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, iv);
        Cipher cipher = Cipher.getInstance(MODE);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);
        return new String(cipher.doFinal(ciphertextWithTag), StandardCharsets.UTF_8);
    }

    public static String generateSecureToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public static String rot13(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + 13) % 26 + base);
            }
            result.append(c);
        }
        return result.toString();
    }
}