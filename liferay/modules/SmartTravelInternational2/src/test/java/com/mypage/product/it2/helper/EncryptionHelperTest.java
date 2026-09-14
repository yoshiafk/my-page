package com.mypage.product.it2.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class EncryptionHelperTest {

    private static final String TEST_KEY = "1234567890123456";
    private static final String TEST_IV = "123456789012";
    private String tokenGroup;
    private String encryptKey;
    private String encryptIv;

    @BeforeEach
    void setUp() throws Exception {
        Field fTokenGroup = EncryptionHelper.class.getDeclaredField("MASTER_GLOBAL_VAR_TOKEN_GROUP");
        fTokenGroup.setAccessible(true);
        tokenGroup = (String) fTokenGroup.get(null);

        Field fEncryptKey = EncryptionHelper.class.getDeclaredField("MASTER_GLOBAL_VAR_TOKEN_ENCRYPTKEY");
        fEncryptKey.setAccessible(true);
        encryptKey = (String) fEncryptKey.get(null);

        Field fEncryptIv = EncryptionHelper.class.getDeclaredField("MASTER_GLOBAL_VAR_TOKEN_ENCRYPTIV");
        fEncryptIv.setAccessible(true);
        encryptIv = (String) fEncryptIv.get(null);
    }

    @Test
    void encrypt_shouldReturnNonEmptyBase64UrlString() throws Exception {
        MasterGlobalVariable mockVar = Mockito.mock(MasterGlobalVariable.class);
        Mockito.when(mockVar.getName()).thenReturn(encryptKey);
        Mockito.when(mockVar.getActive()).thenReturn(1);
        Mockito.when(mockVar.getValue()).thenReturn(TEST_KEY);

        try (MockedStatic<MasterGlobalVariableLocalServiceUtil> mockedStatic =
                     Mockito.mockStatic(MasterGlobalVariableLocalServiceUtil.class)) {
            mockedStatic.when(() ->
                    MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(tokenGroup)
            ).thenReturn(Arrays.asList(mockVar));

            String encrypted = EncryptionHelper.encrypt("HelloWorld");

            assertNotNull(encrypted);
            assertFalse(encrypted.isEmpty());
            assertTrue(encrypted.matches("^[A-Za-z0-9_-]+$"));
        }
    }

    @Test
    void decrypt_shouldReturnOriginalInput() throws Exception {
        MasterGlobalVariable mockVar = Mockito.mock(MasterGlobalVariable.class);
        Mockito.when(mockVar.getName()).thenReturn(encryptKey);
        Mockito.when(mockVar.getActive()).thenReturn(1);
        Mockito.when(mockVar.getValue()).thenReturn(TEST_KEY);

        try (MockedStatic<MasterGlobalVariableLocalServiceUtil> mockedStatic =
                     Mockito.mockStatic(MasterGlobalVariableLocalServiceUtil.class)) {
            mockedStatic.when(() ->
                    MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(tokenGroup)
            ).thenReturn(Arrays.asList(mockVar));

            String originalText = "HelloWorld";
            String encrypted = EncryptionHelper.encrypt(originalText);
            String decrypted = EncryptionHelper.decrypt(encrypted);

            assertNotNull(decrypted);
            assertEquals(originalText, decrypted);
        }
    }

    @Test
    void generateKey_shouldReturn32ByteSha256() throws Exception {
        MasterGlobalVariable mockVar = Mockito.mock(MasterGlobalVariable.class);
        Mockito.when(mockVar.getName()).thenReturn(encryptKey);
        Mockito.when(mockVar.getActive()).thenReturn(1);
        Mockito.when(mockVar.getValue()).thenReturn(TEST_KEY);

        try (MockedStatic<MasterGlobalVariableLocalServiceUtil> mocked =
                     Mockito.mockStatic(MasterGlobalVariableLocalServiceUtil.class)) {
            mocked.when(() ->
                    MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(tokenGroup)
            ).thenReturn(Arrays.asList(mockVar));

            byte[] key = invokeGenerateKey();
            assertNotNull(key);
            assertEquals(32, key.length);
        }
    }

    @Test
    void stringCompress_shouldWorkCorrectly() throws Exception {
        String compressed = EncryptionHelper.stringCompress("HelloHelloHello");
        assertNotNull(compressed);
        assertFalse(compressed.isEmpty());
    }

    @Test
    void stringDecompress_shouldWorkCorrectly() throws Exception {
        String text = "HelloHelloHello";
        String compressed = EncryptionHelper.stringCompress(text);
        String decompressed = EncryptionHelper.stringDecompress(compressed);
        assertEquals(text, decompressed);
    }

    @Test
    void generateSecureToken_shouldReturnNonEmptyUrlSafeString() {
        String token = EncryptionHelper.generateSecureToken(16);
        assertNotNull(token);
        assertFalse(token.isEmpty());
        assertTrue(token.matches("^[A-Za-z0-9_-]+$"));
    }

    @Test
    void encryptPassword_shouldReturnEncryptedBase64() throws Exception {
        MasterGlobalVariable mockKey = Mockito.mock(MasterGlobalVariable.class);
        Mockito.when(mockKey.getName()).thenReturn(encryptKey);
        Mockito.when(mockKey.getActive()).thenReturn(1);
        Mockito.when(mockKey.getValue()).thenReturn(TEST_KEY);

        MasterGlobalVariable mockIv = Mockito.mock(MasterGlobalVariable.class);
        Mockito.when(mockIv.getName()).thenReturn(encryptIv);
        Mockito.when(mockIv.getActive()).thenReturn(1);
        Mockito.when(mockIv.getValue()).thenReturn(TEST_IV);

        try (MockedStatic<MasterGlobalVariableLocalServiceUtil> mocked =
                     Mockito.mockStatic(MasterGlobalVariableLocalServiceUtil.class)) {
            mocked.when(() ->
                    MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(tokenGroup)
            ).thenReturn(Arrays.asList(mockKey, mockIv));

            String result = EncryptionHelper.encryptPassword("MyPassword123");
            assertNotNull(result);
            assertFalse(result.isEmpty());
            assertTrue(result.matches("^[A-Za-z0-9+/=]+$"));
        }
    }

    private byte[] invokeGenerateKey() throws Exception {
        Method method = EncryptionHelper.class.getDeclaredMethod("generateKey");
        method.setAccessible(true);
        return (byte[]) method.invoke(null);
    }
}
