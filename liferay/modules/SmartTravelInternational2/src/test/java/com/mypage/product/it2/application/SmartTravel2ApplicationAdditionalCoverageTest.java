package com.mypage.product.it2.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.agencyportal.service.AgentTokenLocalServiceUtil;
import com.mypage.product.it2.helper.EncryptionHelper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class SmartTravel2ApplicationAdditionalCoverageTest {
    private static final AtomicBoolean URL_FACTORY_SET = new AtomicBoolean(false);
    private static final Map<String, MockResponse> URL_RESPONSES = new ConcurrentHashMap<>();

    @Test
    void showAction_exceptionCovered() throws Exception {
        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
             MockedStatic<EncryptionHelper> encMock = Mockito.mockStatic(EncryptionHelper.class);
             MockedStatic<AgentTokenLocalServiceUtil> tokenMock =
                     Mockito.mockStatic(AgentTokenLocalServiceUtil.class)) {
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(Mockito.mock(ProductConfiguration.class));
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            encMock.when(() -> EncryptionHelper.decrypt(Mockito.anyString()))
                   .thenThrow(new RuntimeException("boom"));

            SmartTravel2Application app = new SmartTravel2Application();
            String response = app.showAction("bad");

            assertTrue(response.contains("{"));
        }
    }

    @Test
    void processOCR_successCoversLogs() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("dataCategory", "ocr");
        params.put("_fotoBase64", "data:image/jpeg;base64,AA==");
        params.put("_fileName", "test.jpg");

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(Mockito.mock(ProductConfiguration.class));

            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString()))
                    .thenAnswer(inv -> {
                        String arg = inv.getArgument(0);
                        if (arg.contains("SUCCESS")) {
                            JSONObject ocrResponse = JsonStubs.newJsonObject();
                            ocrResponse.put("status", "SUCCESS");
                            ocrResponse.put("read", JsonStubs.newJsonObject());
                            return ocrResponse;
                        }
                        return params;
                    });
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

            SmartTravel2Application app = Mockito.spy(new SmartTravel2Application());
            Mockito.doReturn(java.io.File.createTempFile("ocr", ".jpg"))
                   .when(app).decodeBase64ToFile(Mockito.anyString(), Mockito.anyString());
            Mockito.doReturn("{\"read\":{},\"status\":\"SUCCESS\"}")
                   .when(app).hitApiOCR(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.anyString(),
                           Mockito.anyString());

            String response = app.processOCR("{}", Mockito.mock(HttpServletRequest.class));
            assertTrue(response.contains("status"));
            assertTrue(response.contains("true"));
        }
    }

    @Test
    void processOCR_handlesException() {
        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(Mockito.mock(ProductConfiguration.class));
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString()))
                    .thenThrow(new RuntimeException("invalid"));
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

            SmartTravel2Application app = new SmartTravel2Application();
            String response = app.processOCR("{}", Mockito.mock(HttpServletRequest.class));

            assertTrue(response.contains("Internal Server"));
        }
    }

    @Test
    void fetchCountries_statusNotOk() throws Exception {
        installMockUrlFactory();
        registerMockUrl("mock://countries-status0", 200, "{\"Status\":0,\"Message\":\"fail\"}");

        JSONObject apiResponse = JsonStubs.newJsonObject();
        apiResponse.put("Status", 0);
        apiResponse.put("Message", "fail");

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(Mockito.mock(ProductConfiguration.class));
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(apiResponse);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(JSONFactoryUtil::createJSONArray).thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>()));

            SmartTravel2Application app = new SmartTravel2Application();
            setField(app, "finalApiLRCountries", "mock://countries-status0");

            String response = app.fetchCountries(Mockito.mock(HttpServletRequest.class));
            assertTrue(response.contains("Status"));
            assertTrue(response.contains("0"));
        }
    }

    @Test
    void fetchCountries_httpError() throws Exception {
        installMockUrlFactory();
        registerMockUrl("mock://countries-500", 500, "error");

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(Mockito.mock(ProductConfiguration.class));
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(JSONFactoryUtil::createJSONArray).thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>()));

            SmartTravel2Application app = new SmartTravel2Application();
            setField(app, "finalApiLRCountries", "mock://countries-500");

            String response = app.fetchCountries(Mockito.mock(HttpServletRequest.class));
            assertTrue(response.contains("Gagal mengambil data negara"));
        }
    }

    private static void installMockUrlFactory() {
        if (URL_FACTORY_SET.get()) {
            return;
        }

        synchronized (URL_FACTORY_SET) {
            if (URL_FACTORY_SET.get()) {
                return;
            }

            try {
                URL.setURLStreamHandlerFactory(new MockUrlStreamHandlerFactory());
                URL_FACTORY_SET.set(true);
            } catch (Error ignored) {
                // Factory already set by another test/runtime. Do not mark URL_FACTORY_SET
                // so subsequent callers can still attempt verification or installation.
            }
        }
    }

    private static void registerMockUrl(String url, int statusCode, String body) {
        URL_RESPONSES.put(url, new MockResponse(statusCode, body));
    }

    private static void setField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    private static class MockUrlStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            if ("mock".equals(protocol)) {
                return new MockUrlHandler();
            }
            return null;
        }
    }

    private static class MockUrlHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL url) {
            MockResponse response = URL_RESPONSES.get(url.toString());
            if (response == null) {
                response = new MockResponse(404, "");
            }
            return new MockHttpURLConnection(url, response);
        }
    }

    private static class MockHttpURLConnection extends HttpURLConnection {
        private final MockResponse response;

        protected MockHttpURLConnection(URL url, MockResponse response) {
            super(url);
            this.response = response;
        }

        @Override
        public int getResponseCode() {
            return response.statusCode;
        }

        @Override
        public InputStream getInputStream() {
            return new ByteArrayInputStream(response.body.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        public void disconnect() {
        }

        @Override
        public boolean usingProxy() {
            return false;
        }

        @Override
        public void connect() {
        }
    }

    private static class MockResponse {
        private final int statusCode;
        private final String body;

        private MockResponse(int statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }
    }

    private static class JsonStubs {
        static JSONObject newJsonObject() {
            return newJsonObject(new HashMap<>());
        }

        static JSONObject newJsonObject(Map<String, Object> seed) {
            Map<String, Object> store = new HashMap<>(seed);
            JSONObject obj = Mockito.mock(JSONObject.class, invocation -> {
                String name = invocation.getMethod().getName();
                Object[] args = invocation.getArguments();

                if ("put".equals(name)) {
                    store.put((String) args[0], args[1]);
                    return invocation.getMock();
                }
                if ("get".equals(name)) {
                    return store.get(args[0]);
                }
                if ("getString".equals(name)) {
                    Object value = store.get(args[0]);
                    return value == null ? "" : value.toString();
                }
                if ("getInt".equals(name)) {
                    Object value = store.get(args[0]);
                    return value == null ? 0 : ((Number) value).intValue();
                }
                if ("getLong".equals(name)) {
                    Object value = store.get(args[0]);
                    return value == null ? 0L : ((Number) value).longValue();
                }
                if ("getJSONArray".equals(name)) {
                    return store.get(args[0]);
                }
                if ("getJSONObject".equals(name)) {
                    return store.get(args[0]);
                }
                if ("toString".equals(name)) {
                    return store.toString().replace("=", ":");
                }
                return null;
            });
            return obj;
        }

        static JSONArray newJsonArray(List<Object> seed) {
            List<Object> items = new ArrayList<>(seed);
            JSONArray array = Mockito.mock(JSONArray.class, invocation -> {
                String name = invocation.getMethod().getName();
                Object[] args = invocation.getArguments();

                if ("length".equals(name)) {
                    return items.size();
                }
                if ("getJSONObject".equals(name)) {
                    return items.get((int) args[0]);
                }
                if ("getInt".equals(name)) {
                    return ((Number) items.get((int) args[0])).intValue();
                }
                if ("getLong".equals(name)) {
                    return ((Number) items.get((int) args[0])).longValue();
                }
                if ("getString".equals(name)) {
                    return String.valueOf(items.get((int) args[0]));
                }
                if ("put".equals(name)) {
                    items.add(args[0]);
                    return invocation.getMock();
                }
                return null;
            });
            return array;
        }
    }
}
