package com.mypage.product.it2.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.nio.file.Files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MypageHelpersTest {

    private MypageHelpers helpers;

    @BeforeEach
    void setUp() {
        helpers = new MypageHelpers();
    }

    @Test
    void testGetConfig_ValidJson() throws Exception {
        String jsonData = "{ \"pimcoreHost\": \"http://localhost\" }";
        JSONObject jsonObject = Mockito.mock(JSONObject.class);
        Mockito.when(jsonObject.get("pimcoreHost")).thenReturn("http://localhost");

        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class);
             MockedStatic<PropsUtil> mockedProps = Mockito.mockStatic(PropsUtil.class);
             MockedStatic<JSONFactoryUtil> mockedJsonFactory = Mockito.mockStatic(JSONFactoryUtil.class)) {
            mockedProps.when(() -> PropsUtil.get(PropsKeys.LIFERAY_HOME)).thenReturn("C:/liferay");
            mockedFiles.when(() -> Files.readAllBytes(Mockito.any())).thenReturn(jsonData.getBytes());
            mockedJsonFactory.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString()))
                             .thenReturn(jsonObject);

            String result = helpers.getConfig("pimcoreHost");

            assertEquals("http://localhost", result);
        }
    }

    @Test
    void testGetConfig_InvalidJson_FixMissingCommas() throws Exception {
        String jsonData = "{ \"pimcoreHost\": \"http://localhost\" \"apiKey\": \"ABC123\" }";
        JSONObject jsonObject = Mockito.mock(JSONObject.class);
        Mockito.when(jsonObject.get("pimcoreHost")).thenReturn("http://localhost");

        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class);
             MockedStatic<PropsUtil> mockedProps = Mockito.mockStatic(PropsUtil.class);
             MockedStatic<JSONFactoryUtil> mockedJsonFactory = Mockito.mockStatic(JSONFactoryUtil.class)) {
            mockedProps.when(() -> PropsUtil.get(PropsKeys.LIFERAY_HOME)).thenReturn("C:/liferay");
            mockedFiles.when(() -> Files.readAllBytes(Mockito.any())).thenReturn(jsonData.getBytes());
            mockedJsonFactory.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString()))
                             .thenReturn(jsonObject);

            String result = helpers.getConfig("pimcoreHost");

            assertEquals("http://localhost", result);
        }
    }

    @Test
    void testGetConfig_exceptionReturnsBlank() throws Exception {
        String jsonData = "{ \"pimcoreHost\": \"http://localhost\" }";

        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class);
             MockedStatic<PropsUtil> mockedProps = Mockito.mockStatic(PropsUtil.class);
             MockedStatic<JSONFactoryUtil> mockedJsonFactory = Mockito.mockStatic(JSONFactoryUtil.class)) {
            mockedProps.when(() -> PropsUtil.get(PropsKeys.LIFERAY_HOME)).thenReturn("C:/liferay");
            mockedFiles.when(() -> Files.readAllBytes(Mockito.any())).thenReturn(jsonData.getBytes());
            mockedJsonFactory.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString()))
                             .thenThrow(new RuntimeException("boom"));

            String result = helpers.getConfig("pimcoreHost");

            assertEquals("", result);
        }
    }

    @Test
    void testCapitalizeEachWord() {
        assertEquals("Hello World", MypageHelpers.capitalizeEachWord("hello world"));
        assertEquals("Java Is Fun", MypageHelpers.capitalizeEachWord("java IS fun"));
        assertEquals("", MypageHelpers.capitalizeEachWord(""));
        assertNull(MypageHelpers.capitalizeEachWord(null));
    }
}
