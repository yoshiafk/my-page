package com.mypage.product.it2.helper;

import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionHelper {

    private EncryptionHelper() {
        throw new IllegalStateException("Utility class");
    }

    private static final String ALGORITHM = "AES";
    private static final String MODE = "AES/GCM/NoPadding";
    private static final String MASTER_GLOBAL_VAR_TOKEN_GROUP = "Token";
    private static final String MASTER_GLOBAL_VAR_TOKEN_ENCRYPTKEY = "Encrypt_Key";
    private static final String MASTER_GLOBAL_VAR_TOKEN_ENCRYPTIV = "Encrypt_IV";

    /**
     * encrypt with AES algoritm
     *
     * @param input
     * @return
     * @throws Exception
     */
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

    /**
     * decrypt with AES algoritm
     *
     * @param encrypted
     * @return
     * @throws Exception
     */
    // decrypt original from pimcore
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

    private static byte[] generateKey() throws NoSuchAlgorithmException {
        String encryptKey = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(MASTER_GLOBAL_VAR_TOKEN_GROUP).stream()
                .filter(v -> v.getName().equalsIgnoreCase(MASTER_GLOBAL_VAR_TOKEN_ENCRYPTKEY) && v.getActive() == 1).findFirst()
                .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "" : v.getValue()).orElse("");

        byte[] encryptKeyByte = encryptKey.getBytes(StandardCharsets.UTF_8);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = encryptKeyByte;
        digest.update(keyBytes);
        return digest.digest();
    }

    /**
     * String compress like in MyPage Primcore
     *
     * @param text
     * @return
     * @throws Exception
     */
    public static String stringCompress(String text) throws IOException {
        byte[] compressedData = deflate(text.getBytes());
        return Base64.getEncoder().encodeToString(compressedData).replace('+', '-').replace('/', '_');
    }

    /**
     * String decompress like in MyPage Primcore
     *
     * @param text
     * @return
     * @throws Exception
     */
    public static String stringDecompress(String text) throws DataFormatException, IOException {
        byte[] decompressedData = inflate(Base64.getDecoder().decode(text.replace('-', '+').replace('_', '/')));
        return new String(decompressedData);
    }

    private static byte[] deflate(byte[] data) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        return outputStream.toByteArray();
    }

    private static byte[] inflate(byte[] data) throws DataFormatException, IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        return outputStream.toByteArray();
    }

    public static String generateSecureToken(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public static String encryptPassword(String input) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        String encryptIv = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(MASTER_GLOBAL_VAR_TOKEN_GROUP).stream()
                .filter(v -> v.getName().equalsIgnoreCase(MASTER_GLOBAL_VAR_TOKEN_ENCRYPTIV) && v.getActive() == 1).findFirst()
                .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "" : v.getValue()).orElse("");

        byte[] encryptIvByte = encryptIv.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKey = new SecretKeySpec(generateKey(), ALGORITHM);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, encryptIvByte);
        Cipher cipher = Cipher.getInstance(MODE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes());

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
