package com.mypage.product.it2.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.model.MasterCurrency;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.SmartTravelIntPlan;
import com.mypage.admin.product.model.StiBenefit;
import com.mypage.admin.product.model.StiBenefitValueMapping;
import com.mypage.admin.product.model.StiPremi;
import com.mypage.admin.product.service.BenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.MasterCurrencyLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.SmartTravelIntPlanLocalServiceUtil;
import com.mypage.admin.product.service.StiBenefitLocalServiceUtil;
import com.mypage.admin.product.service.StiBenefitValueMappingLocalServiceUtil;
import com.mypage.admin.product.service.StiPremiLocalServiceUtil;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalServiceUtil;
import com.mypage.product.it2.helper.EncryptionHelper;

import java.io.BufferedReader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class SmartTravel2ApplicationTest {

    @Test
    void showAction_agentTokenExists() throws Exception {
        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<EncryptionHelper> encMock = Mockito.mockStatic(EncryptionHelper.class);
             MockedStatic<AgentTokenLocalServiceUtil> tokenMock =
                     Mockito.mockStatic(AgentTokenLocalServiceUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {

            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            encMock.when(() -> EncryptionHelper.generateSecureToken(32)).thenReturn("secure123");
            encMock.when(() -> EncryptionHelper.decrypt("encryptedParam")).thenReturn("abc|DEPT01");
            encMock.when(() -> EncryptionHelper.encrypt("secure123")).thenReturn("encryptedToken");

            AgentToken token = Mockito.mock(AgentToken.class);
            Mockito.when(token.getAgentTokenId()).thenReturn(123L);
            tokenMock.when(() -> AgentTokenLocalServiceUtil.getAgentTokenByDeptCode("DEPT01")).thenReturn(token);

            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.showAction("encryptedParam");

            assertTrue(result.contains("\"Status\":1"));
            assertTrue(result.contains("\"Token\":\"encryptedToken\""));
        }
    }

    @Test
    void showAction_agentTokenNotExists() throws Exception {
        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<EncryptionHelper> encMock = Mockito.mockStatic(EncryptionHelper.class);
             MockedStatic<AgentTokenLocalServiceUtil> tokenMock =
                     Mockito.mockStatic(AgentTokenLocalServiceUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {

            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            encMock.when(() -> EncryptionHelper.generateSecureToken(32)).thenReturn("secureABC");
            encMock.when(() -> EncryptionHelper.decrypt("encryptedParam")).thenReturn("abc|DEPT02");
            encMock.when(() -> EncryptionHelper.encrypt("secureABC")).thenReturn("encryptedToken");

            tokenMock.when(() -> AgentTokenLocalServiceUtil.getAgentTokenByDeptCode("DEPT02")).thenReturn(null);

            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.showAction("encryptedParam");

            assertTrue(result.contains("\"Status\":1"));
            assertTrue(result.contains("\"Token\":\"encryptedToken\""));
        }
    }

    @Test
    void updateCurrency_amountZero() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("usd", 0.0);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.updateCurrency("{\"usd\":0.0}", null);

            assertTrue(result.contains("Amount cant be 0"));
        }
    }

    @Test
    void updateCurrency_noCurrencies() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("usd", 10.0);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<MasterCurrencyLocalServiceUtil> currencyMock =
                     Mockito.mockStatic(MasterCurrencyLocalServiceUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

            currencyMock.when(MasterCurrencyLocalServiceUtil::getMasterCurrencies).thenReturn(null);
            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.updateCurrency("{\"usd\":10.0}", null);

            assertTrue(result.contains("No currency available")
                    || result.contains("Failed to update the currency")
                    || result.contains("USD currency not found"));
        }
    }

    @Test
    void updateCurrency_usdNotFound() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("usd", 10.0);

        MasterCurrency eur = Mockito.mock(MasterCurrency.class);
        Mockito.when(eur.getName()).thenReturn("EUR");

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<MasterCurrencyLocalServiceUtil> currencyMock =
                     Mockito.mockStatic(MasterCurrencyLocalServiceUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

            currencyMock.when(MasterCurrencyLocalServiceUtil::getMasterCurrencies)
                        .thenReturn(Arrays.asList(eur));
            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.updateCurrency("{\"usd\":10.0}", null);

            assertTrue(result.contains("USD currency not found"));
        }
    }

    @Test
    void updateCurrency_success() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("usd", 20.0);

        MasterCurrency usd = Mockito.mock(MasterCurrency.class);
        Mockito.when(usd.getName()).thenReturn("USD");
        Mockito.when(usd.getCurrencyId()).thenReturn(1L);
        Mockito.when(usd.getIsDefault()).thenReturn(1);
        Mockito.when(usd.getActive()).thenReturn(1);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<MasterCurrencyLocalServiceUtil> currencyMock =
                     Mockito.mockStatic(MasterCurrencyLocalServiceUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

            currencyMock.when(MasterCurrencyLocalServiceUtil::getMasterCurrencies)
                        .thenReturn(Arrays.asList(usd));
            currencyMock.when(() -> MasterCurrencyLocalServiceUtil.updateMasterCurrency(
                    Mockito.anyLong(), Mockito.anyString(), Mockito.anyDouble(), Mockito.anyInt(), Mockito.anyInt()))
                        .thenReturn(usd);
            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.updateCurrency("{\"usd\":20.0}", null);

            assertTrue(result.contains("Currency successfully updated"));
        }
    }

    @Test
    void updateCurrency_exceptionHandling() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("usd", 50.0);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<MasterCurrencyLocalServiceUtil> currencyMock =
                     Mockito.mockStatic(MasterCurrencyLocalServiceUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

            currencyMock.when(MasterCurrencyLocalServiceUtil::getMasterCurrencies)
                        .thenThrow(new RuntimeException("DB error"));
            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.updateCurrency("{\"usd\":50.0}", null);

            assertTrue(result.contains("Failed to update the currency"));
        }
    }

    @Test
    void convertJsonToMap_policyholderAndInsured() {
        String json = "{\"policyholder\":{\"Name\":\"A\"},\"insured\":[{\"Name\":\"B\"}],\"insuredIsPolis\":true,\"token\":\"t\"}";
        Map<String, Object> result = SmartTravel2Application.convertJsonToMap(json);
        assertTrue(result.containsKey("policyholder"));
        assertTrue(result.containsKey("insured"));
        assertTrue(result.containsKey("insuredIsPolis"));
        assertEquals("t", result.get("token"));
    }

    @Test
    void convertJsonToMap_nameEmail() {
        String json = "{\"Name\":\"A\",\"Email\":\"a@b.com\"}";
        Map<String, Object> result = SmartTravel2Application.convertJsonToMap(json);
        assertEquals("A", result.get("Name"));
        assertEquals("a@b.com", result.get("Email"));
    }

    @Test
    void convertJsonToMap_invalid() {
        String json = "{\"foo\":\"bar\"}";
        assertThrows(RuntimeException.class, () -> SmartTravel2Application.convertJsonToMap(json));
    }

    @Test
    void parseDate_formats() throws Exception {
        try (MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);
            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.parseDate("01-Jan-2024");
            assertEquals("01-01-2024", result);
        }
    }

    @Test
    void parseDate2_formats() throws Exception {
        try (MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);
            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.parseDate2("01-Jan-2024");
            assertEquals("2024-01-01", result);
        }
    }

    @Test
    void privateFormatHelpers() throws Exception {
        Method customFormatDate = SmartTravel2Application.class.getDeclaredMethod("customFormatDate", String.class);
        customFormatDate.setAccessible(true);
        assertEquals("2024-01-01", customFormatDate.invoke(null, "01/Jan/2024"));

        Method customFormatDateTime = SmartTravel2Application.class.getDeclaredMethod("customFormatDateTime", String.class);
        customFormatDateTime.setAccessible(true);
        assertEquals("2024-01-01 00:00:00", customFormatDateTime.invoke(null, "01/Jan/2024"));

        Method customFormatDateObj = SmartTravel2Application.class.getDeclaredMethod("_customFormatDate", java.util.Date.class);
        customFormatDateObj.setAccessible(true);
        assertEquals("2024-01-01", customFormatDateObj.invoke(null,
                java.sql.Date.valueOf(LocalDate.of(2024, 1, 1))));
    }

    @Test
    void roundCustom_and_timestamp() throws Exception {
        try (MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);
            SmartTravel2Application app = new SmartTravel2Application();
            Method roundCustom = SmartTravel2Application.class.getDeclaredMethod("roundCustom", double.class, String.class);
            roundCustom.setAccessible(true);
            assertEquals(100.0, (double) roundCustom.invoke(app, 99.6, "idr"));
            assertEquals(99.6, (double) roundCustom.invoke(app, 99.6, "usd"));

            Method timestamp = SmartTravel2Application.class.getDeclaredMethod("generateNumericCurrentTimeStamp");
            timestamp.setAccessible(true);
            String ts = (String) timestamp.invoke(null);
            assertTrue(ts.matches("\\d{14}"));
        }
    }

    @Test
    void readResponse_collectsLines() throws Exception {
        try (MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);
            SmartTravel2Application app = new SmartTravel2Application();
            Method readResponse = SmartTravel2Application.class.getDeclaredMethod("readResponse", BufferedReader.class);
            readResponse.setAccessible(true);

            StringReader sr = new StringReader("a\nb\nc");
            BufferedReader br = new BufferedReader(sr);
            String result = (String) readResponse.invoke(app, br);

            assertEquals("abc", result);
        }
    }

    @Test
    void calculate_validParams() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withBasicMocks();

            JSONObject params = ctx.baseParams("individual");
            params.put("PromoCode", "");
            params.put("ChoosenPlan", "");
            params.put("BusinessModel", "b2c");
            params.put("ManagedById", "");
            params.put("Role", "");
            params.put("AdultTotal", "1");

            String result = ctx.invokeCalculate("{}", params);
            assertTrue(result.contains("\"Status\":"));
            assertTrue(result.contains("Message"));
        }
    }

    @Test
    void calculate_invalidParams() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withBasicMocks();

            JSONObject params = JsonStubs.newJsonObject();
            params.put("fp", 0);
            params.put("PromoCode", "");
            params.put("Currency", "");
            params.put("TravellerType", "");
            params.put("DepartureDate", "");
            params.put("ArrivalDate", "");
            params.put("TravelType", "");
            params.put("AdultTotal", "");
            String result = ctx.invokeCalculate("{}", params);
            assertTrue(result.contains("\"Status\":0"));
        }
    }

    @Test
    void errorMessage_returnsJson() throws Exception {
        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class)) {
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

            Method errorMessage = SmartTravel2Application.class.getDeclaredMethod("errorMessage", String.class);
            errorMessage.setAccessible(true);
            JSONObject result = (JSONObject) errorMessage.invoke(null, "oops");

            assertEquals("oops", result.get("Message"));
        }
    }

    @Test
    void calculatePremi_individual() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withBasicMocks();
            JSONObject params = ctx.baseParams("individual");

            JSONObject result = ctx.invokeCalculatePremi(params, true);
            assertNotNull(result.get("Calculation"));
        }
    }

    @Test
    void calculatePremi_duo() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withBasicMocks();
            ctx.withSpousePremi();
            JSONObject params = ctx.baseParams("duo");

            JSONObject result = ctx.invokeCalculatePremi(params, true);
            assertNotNull(result.get("Calculation"));
        }
    }

    @Test
    void calculatePremi_family() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withBasicMocks();
            ctx.withSpousePremi();
            ctx.withChildrenPremi();
            JSONObject params = ctx.baseParams("family");
            params.put("AdultTotal", 2);
            params.put("ChildTotal", 1);

            JSONObject result = ctx.invokeCalculatePremi(params, true);
            assertNotNull(result.get("Calculation"));
        }
    }

    @Test
    void calculatePremi_individual_referrerEmpty() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withBasicMocks();
            JSONObject params = ctx.baseParams("individual");
            params.put("Referrer", "");
            params.put("AdditionalBenefits", JsonStubs.newJsonArray(Arrays.asList(105)));
            params.put("AdditionalBenefitCodes", JsonStubs.newJsonArray(new ArrayList<>()));

            JSONObject result = ctx.invokeCalculatePremi(params, true);
            assertNotNull(result.get("Calculation"));
        }
    }

    @Test
    void calculatePremi_individual_annual() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withBasicMocks();
            JSONObject params = ctx.baseParams("individual");
            params.put("TravelType", "annual");

            JSONObject result = ctx.invokeCalculatePremi(params, true);
            assertNotNull(result.get("Calculation"));
        }
    }

    @Test
    void calculatePremi_individual_currencyIdr() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withBasicMocks();
            JSONObject params = ctx.baseParams("individual");
            params.put("Currency", "idr");

            JSONObject result = ctx.invokeCalculatePremi(params, true);
            assertNotNull(result.get("Calculation"));
        }
    }

    @Test
    void calculateIndividual_handlesException() throws Exception {
        try (TestContext ctx = new TestContext()) {
            ctx.withCurrencySearchError();

            Map<String, Object> params = new HashMap<>();
            params.put("referrer", "pimcore");
            params.put("currency", "usd");
            params.put("choosenPlan", "");
            params.put("travelType", "single");
            params.put("additionalDays", 0);
            params.put("additionalBenefits", JsonStubs.newJsonArray(new ArrayList<>()));
            params.put("additionalBenefitCodes", JsonStubs.newJsonArray(new ArrayList<>()));
            params.put("fp", 0);

            List<Map<String, Object>> result = ctx.invokeCalculateIndividual(params);
            assertTrue(result.isEmpty());
        }
    }

    private static ProductConfiguration mockProductConfig() {
        ProductConfiguration mockConfig = Mockito.mock(ProductConfiguration.class);
        Mockito.when(mockConfig.getPolicyCostIDR()).thenReturn(1000.0);
        Mockito.when(mockConfig.getPolicyCostUSD()).thenReturn(10.0);
        Mockito.when(mockConfig.getStampdutyIDR()).thenReturn(500.0);
        Mockito.when(mockConfig.getStampdutyUSD()).thenReturn(1.0);
        return mockConfig;
    }

    private static class TestContext implements AutoCloseable {
        private final MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
        private final MockedStatic<JSONFactoryUtil> jsonMock =
                Mockito.mockStatic(JSONFactoryUtil.class);
        private final MockedStatic<MasterCurrencyLocalServiceUtil> currencyMock =
                Mockito.mockStatic(MasterCurrencyLocalServiceUtil.class);
        private final MockedStatic<StiPremiLocalServiceUtil> premiMock =
                Mockito.mockStatic(StiPremiLocalServiceUtil.class);
        private final MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
        private final MockedStatic<StiBenefitLocalServiceUtil> benefitMock =
                Mockito.mockStatic(StiBenefitLocalServiceUtil.class);
        private final MockedStatic<BenefitTypeLocalServiceUtil> benefitTypeMock =
                Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
        private final MockedStatic<StiBenefitValueMappingLocalServiceUtil> mappingMock =
                Mockito.mockStatic(StiBenefitValueMappingLocalServiceUtil.class);

        private final SmartTravel2Application app;
        private final List<StiPremi> individualPremis = new ArrayList<>();
        private List<StiPremi> spousePremis;
        private List<StiPremi> childrenPremis;

        TestContext() {
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(() -> JSONFactoryUtil.createJSONArray(Mockito.anyCollection()))
                    .thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>(inv.getArgument(0))));
            jsonMock.when(JSONFactoryUtil::createJSONArray).thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>()));

            ProductConfiguration config = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);

            app = new SmartTravel2Application();
        }

        void withBasicMocks() {
            MasterCurrency mc = Mockito.mock(MasterCurrency.class);
            Mockito.when(mc.getAmount()).thenReturn(15000.0);
            currencyMock.when(() -> MasterCurrencyLocalServiceUtil.searchCurrency(Mockito.anyString()))
                        .thenReturn(mc);

            SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
            Mockito.when(plan.getNameId()).thenReturn("PLAN_A");
            planMock.when(() -> SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(Mockito.anyLong()))
                    .thenReturn(plan);

            StiBenefitValueMapping mapping = Mockito.mock(StiBenefitValueMapping.class);
            Mockito.when(mapping.getBenefitValue()).thenReturn("100");
            Mockito.when(mapping.getBenefitValueUSD()).thenReturn("10");
            mappingMock.when(() -> StiBenefitValueMappingLocalServiceUtil
                    .getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong()))
                       .thenReturn(mapping);

            seedBenefitsAndPremis();
            premiMock.when(() -> StiPremiLocalServiceUtil.findByCurrencyAndTravellerType(Mockito.anyString(), Mockito.eq("individual")))
                     .thenReturn(individualPremis);
        }

        void withCurrencySearchError() {
            currencyMock.when(() -> MasterCurrencyLocalServiceUtil.searchCurrency(Mockito.anyString()))
                        .thenThrow(new RuntimeException("Currency error"));
        }

        void withSpousePremi() {
            spousePremis = new ArrayList<>(individualPremis);
            premiMock.when(() -> StiPremiLocalServiceUtil.findByCurrencyAndTravellerType(Mockito.anyString(), Mockito.eq("spouse")))
                     .thenReturn(spousePremis);
        }

        void withChildrenPremi() {
            childrenPremis = new ArrayList<>(individualPremis);
            premiMock.when(() -> StiPremiLocalServiceUtil.findByCurrencyAndTravellerType(Mockito.anyString(), Mockito.eq("children")))
                     .thenReturn(childrenPremis);
        }

        JSONObject baseParams(String travellerType) {
            JSONObject params = JsonStubs.newJsonObject();
            params.put("Referrer", "pimcore");
            params.put("AdditionalBenefitCodes", JsonStubs.newJsonArray(Arrays.asList("BEN-5")));
            params.put("AdditionalBenefits", JsonStubs.newJsonArray(new ArrayList<>()));
            params.put("ManagedBy", "agent");
            params.put("Currency", "usd");
            params.put("TravellerType", travellerType);
            params.put("TravelType", "single");
            params.put("AdultTotal", 1);
            params.put("ChildTotal", 0);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
            params.put("DepartureDate", LocalDate.of(2025, 1, 1).format(fmt));
            params.put("ArrivalDate", LocalDate.of(2025, 1, 2).format(fmt));

            params.put("PromoCode", "PROMO");
            params.put("SpesificPlan", "PLAN_A");
            params.put("Commission", 5.0);
            params.put("Tax", 2.0);
            params.put("PaymentMethod", "nett");
            params.put("Discount", 10.0);
            params.put("fp", 1);
            return params;
        }

        JSONObject invokeCalculatePremi(JSONObject params, boolean spesificPlan) throws Exception {
            Method method = SmartTravel2Application.class.getDeclaredMethod("calculatePremi", JSONObject.class, boolean.class);
            method.setAccessible(true);
            return (JSONObject) method.invoke(app, params, spesificPlan);
        }

        List<Map<String, Object>> invokeCalculateIndividual(Map<String, Object> params) throws Exception {
            Method method = SmartTravel2Application.class.getDeclaredMethod("calculateIndividual", Map.class);
            method.setAccessible(true);
            return (List<Map<String, Object>>) method.invoke(app, params);
        }

        String invokeCalculate(String request, JSONObject params) throws Exception {
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            return app.calculate(request, null);
        }

        private void seedBenefitsAndPremis() {
            individualPremis.clear();

            individualPremis.add(mockPremi(1L, 101L, "100", "10", "5"));
            individualPremis.add(mockPremi(1L, 102L, "200", "20", "5"));
            individualPremis.add(mockPremi(1L, 103L, "300", "30", "5"));
            individualPremis.add(mockPremi(1L, 104L, "400", "40", "5"));
            individualPremis.add(mockPremi(1L, 105L, "50", "5", "1"));

            benefitMock.when(() -> StiBenefitLocalServiceUtil.getStiBenefit(Mockito.anyLong()))
                       .thenAnswer(inv -> buildBenefit(inv.getArgument(0)));
            benefitTypeMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(Mockito.anyLong()))
                           .thenAnswer(inv -> buildBenefitType(inv.getArgument(0)));
        }

        private StiPremi mockPremi(long planId, long benefitId, String basic, String annual, String additional) {
            StiPremi premi = Mockito.mock(StiPremi.class);
            Mockito.when(premi.getPlanId()).thenReturn(planId);
            Mockito.when(premi.getBenefitId()).thenReturn(benefitId);
            Mockito.when(premi.getBasic()).thenReturn(new BigDecimal(basic));
            Mockito.when(premi.getAnnual()).thenReturn(new BigDecimal(annual));
            Mockito.when(premi.getAdditional()).thenReturn(new BigDecimal(additional));
            return premi;
        }

        private StiBenefit buildBenefit(long benefitId) {
            StiBenefit benefit = Mockito.mock(StiBenefit.class);
            Mockito.when(benefit.getBenefitId()).thenReturn(benefitId);
            if (benefitId == 101L) {
                Mockito.when(benefit.getBenefitTypeId()).thenReturn(201L);
                Mockito.when(benefit.getNameId()).thenReturn("Biaya Pengobatan, Gigi dan Lainnya");
                Mockito.when(benefit.getExternalCode()).thenReturn("BEN-1");
            } else if (benefitId == 102L) {
                Mockito.when(benefit.getBenefitTypeId()).thenReturn(202L);
                Mockito.when(benefit.getNameId()).thenReturn("Kecelakaan Diri");
                Mockito.when(benefit.getExternalCode()).thenReturn("BEN-2");
            } else if (benefitId == 103L) {
                Mockito.when(benefit.getBenefitTypeId()).thenReturn(203L);
                Mockito.when(benefit.getNameId()).thenReturn("Evakuasi Medis Darurat dan Repatriasi");
                Mockito.when(benefit.getExternalCode()).thenReturn("BEN-3");
            } else if (benefitId == 104L) {
                Mockito.when(benefit.getBenefitTypeId()).thenReturn(204L);
                Mockito.when(benefit.getNameId()).thenReturn("Pemulangan Jenazah");
                Mockito.when(benefit.getExternalCode()).thenReturn("BEN-4");
            } else {
                Mockito.when(benefit.getBenefitTypeId()).thenReturn(301L);
                Mockito.when(benefit.getNameId()).thenReturn("Additional Benefit");
                Mockito.when(benefit.getExternalCode()).thenReturn("BEN-5");
            }
            return benefit;
        }

        private BenefitType buildBenefitType(long typeId) {
            BenefitType type = Mockito.mock(BenefitType.class);
            Mockito.when(type.getBenefitTypeId()).thenReturn(typeId);
            if (typeId == 301L) {
                Mockito.when(type.getNameId()).thenReturn("Tambahan");
                Mockito.when(type.getNameEn()).thenReturn("Additional");
            } else {
                Mockito.when(type.getNameId()).thenReturn("Jaminan Utama");
                Mockito.when(type.getNameEn()).thenReturn("Main Benefit");
            }
            return type;
        }

        @Override
        public void close() {
            mappingMock.close();
            benefitTypeMock.close();
            benefitMock.close();
            planMock.close();
            premiMock.close();
            currencyMock.close();
            jsonMock.close();
            productMock.close();
        }
    }

    private static class JsonStubs {
        static JSONObject newJsonObject() {
            return newJsonObject(new HashMap<>());
        }

        static JSONObject newJsonObject(Map<String, Object> seed) {
            Map<String, Object> store = new HashMap<>(seed);
            AtomicReference<JSONObject> ref = new AtomicReference<>();

            JSONObject obj = Mockito.mock(JSONObject.class, invocation -> {
                String name = invocation.getMethod().getName();
                Object[] args = invocation.getArguments();

                if ("put".equals(name)) {
                    store.put((String) args[0], args[1]);
                    return ref.get();
                }
                if ("get".equals(name)) {
                    return store.get(args[0]);
                }
                if ("getString".equals(name)) {
                    Object value = store.get(args[0]);
                    if (args.length == 2) {
                        return value == null ? args[1] : value.toString();
                    }
                    return value == null ? "" : value.toString();
                }
                if ("getInt".equals(name)) {
                    Object value = store.get(args[0]);
                    if (args.length == 2) {
                        return value == null ? args[1] : ((Number) value).intValue();
                    }
                    return ((Number) value).intValue();
                }
                if ("getDouble".equals(name)) {
                    Object value = store.get(args[0]);
                    if (args.length == 2) {
                        return value == null ? args[1] : ((Number) value).doubleValue();
                    }
                    return ((Number) value).doubleValue();
                }
                if ("getJSONArray".equals(name)) {
                    return store.get(args[0]);
                }
                if ("getJSONObject".equals(name)) {
                    return store.get(args[0]);
                }
                if ("has".equals(name)) {
                    return store.containsKey(args[0]);
                }
                if ("toString".equals(name)) {
                    return toJson(store);
                }
                return null;
            });

            ref.set(obj);
            return obj;
        }

        static JSONArray newJsonArray(List<Object> seed) {
            List<Object> items = new ArrayList<>(seed);
            AtomicReference<JSONArray> ref = new AtomicReference<>();

            JSONArray array = Mockito.mock(JSONArray.class, invocation -> {
                String name = invocation.getMethod().getName();
                Object[] args = invocation.getArguments();

                if ("length".equals(name)) {
                    return items.size();
                }
                if ("getString".equals(name)) {
                    return String.valueOf(items.get((int) args[0]));
                }
                if ("getInt".equals(name)) {
                    return ((Number) items.get((int) args[0])).intValue();
                }
                if ("get".equals(name)) {
                    return items.get((int) args[0]);
                }
                if ("put".equals(name)) {
                    items.add(args[0]);
                    return ref.get();
                }
                if ("toString".equals(name)) {
                    return toJson(items);
                }
                return null;
            });

            ref.set(array);
            return array;
        }

        private static String toJson(Object value) {
            if (value == null) {
                return "null";
            }
            if (value instanceof String) {
                return "\"" + ((String) value).replace("\"", "\\\"") + "\"";
            }
            if (value instanceof Number || value instanceof Boolean) {
                return value.toString();
            }
            if (value instanceof Map) {
                StringBuilder sb = new StringBuilder();
                sb.append("{");
                boolean first = true;
                for (Map.Entry<?, ?> entry : ((Map<?, ?>) value).entrySet()) {
                    if (!first) {
                        sb.append(",");
                    }
                    first = false;
                    sb.append(toJson(entry.getKey().toString()));
                    sb.append(":");
                    sb.append(toJson(entry.getValue()));
                }
                sb.append("}");
                return sb.toString();
            }
            if (value instanceof List) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                boolean first = true;
                for (Object item : (List<?>) value) {
                    if (!first) {
                        sb.append(",");
                    }
                    first = false;
                    sb.append(toJson(item));
                }
                sb.append("]");
                return sb.toString();
            }
            if (Mockito.mockingDetails(value).isMock()) {
                return value.toString();
            }
            return "\"" + value.toString().replace("\"", "\\\"") + "\"";
        }
    }
}
