package com.mypage.product.it.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.json.JSONException;
import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.model.BenefitValueMapping;
import com.mypage.admin.product.model.MasterCurrency;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.model.Premi;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.SmartTravelIntPlan;
import com.mypage.admin.product.service.BenefitLocalServiceUtil;
import com.mypage.admin.product.service.BenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.BenefitValueMappingLocalServiceUtil;
import com.mypage.admin.product.service.MasterCurrencyLocalServiceUtil;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.admin.product.service.PremiLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.SmartTravelIntPlanLocalServiceUtil;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalServiceUtil;
import com.mypage.product.it.application.SmartTravelApplication.InvalidPlanException;
import com.mypage.product.it.helper.EncryptionHelper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class SmartTravelApplicationTest {
	
	private SmartTravelApplication service;
	private String tokenGroup;
    private String encryptKey;
    
    private MockedStatic<ProductConfigurationLocalServiceUtil> productMock;
    private MockedStatic<EncryptionHelper> encryptMock;
    private MockedStatic<AgentTokenLocalServiceUtil> agentTokenMock;
    private MockedStatic<MasterGlobalVariableLocalServiceUtil> globVarMock;
    private MockedStatic<MasterCurrencyLocalServiceUtil> currencyMock;
    private MockedStatic<PremiLocalServiceUtil> premiMock;
    private MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock;
    private MockedStatic<BenefitLocalServiceUtil> benefitMock;
    private MockedStatic<BenefitTypeLocalServiceUtil> benefitTypeMock;
    private MockedStatic<BenefitValueMappingLocalServiceUtil> benefitValMapMock;

    @BeforeEach
    void setUp() throws Exception {
        service = new SmartTravelApplication();
        
        Field fTokenGroup = EncryptionHelper.class.getDeclaredField("MASTER_GLOBAL_VAR_TOKEN_GROUP");
        fTokenGroup.setAccessible(true);
        tokenGroup = (String) fTokenGroup.get(null); // null karena static
        
        Field fEncryptKey = EncryptionHelper.class.getDeclaredField("MASTER_GLOBAL_VAR_TOKEN_ENCRYPTKEY");
        fEncryptKey.setAccessible(true);
        encryptKey = (String) fEncryptKey.get(null); // null karena static
        
        productMock = Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
        encryptMock = Mockito.mockStatic(EncryptionHelper.class);
        agentTokenMock = Mockito.mockStatic(AgentTokenLocalServiceUtil.class);
        globVarMock = Mockito.mockStatic(MasterGlobalVariableLocalServiceUtil.class);
        currencyMock = Mockito.mockStatic(MasterCurrencyLocalServiceUtil.class);
        premiMock = Mockito.mockStatic(PremiLocalServiceUtil.class);
        planMock = Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
        benefitMock = Mockito.mockStatic(BenefitLocalServiceUtil.class);
        benefitTypeMock = Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
        benefitValMapMock = Mockito.mockStatic(BenefitValueMappingLocalServiceUtil.class);
    }

    @AfterEach
    void tearDown() {
    	productMock.close();
    	encryptMock.close();
    	agentTokenMock.close();
    	globVarMock.close();
    	currencyMock.close();
        premiMock.close();
        planMock.close();
        benefitMock.close();
        benefitTypeMock.close();
        benefitValMapMock.close();
    }

	private ProductConfiguration mockProductConfig() {
		ProductConfiguration mockConfig = Mockito.mock(ProductConfiguration.class);
        Mockito.when(mockConfig.getPolicyCostIDR()).thenReturn(1000.0);
        Mockito.when(mockConfig.getPolicyCostUSD()).thenReturn(10.0);
        Mockito.when(mockConfig.getStampdutyIDR()).thenReturn(500.0);
        Mockito.when(mockConfig.getStampdutyUSD()).thenReturn(1.0);
        return mockConfig;
    }
	
	private MasterCurrency mockMasterCurrency() {
		MasterCurrency masterCurrency = Mockito.mock(MasterCurrency.class);
        Mockito.when(masterCurrency.getAmount()).thenReturn(15000.0); // kurs USD -> IDR
        Mockito.when(masterCurrency.getCurrencyId()).thenReturn(1L);
        Mockito.when(masterCurrency.getName()).thenReturn("USD");
        Mockito.when(masterCurrency.getIsDefault()).thenReturn(1);
        Mockito.when(masterCurrency.getActive()).thenReturn(1);
        return masterCurrency;
    }
	
	@Test
    void testShowAction_agentTokenExists() throws Exception {
        String params = "encryptedParam";
        String decrypted = "abc|DEPT01";
        
        MasterGlobalVariable mockVar = Mockito.mock(MasterGlobalVariable.class);
		Mockito.when(mockVar.getName()).thenReturn(encryptKey);
		Mockito.when(mockVar.getActive()).thenReturn(1);
		Mockito.when(mockVar.getValue()).thenReturn("1234567890123456");
        
        AgentToken mockToken = Mockito.mock(AgentToken.class);
        Mockito.when(mockToken.getAgentTokenId()).thenReturn(123L);

    	globVarMock.when(() -> MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup(tokenGroup)).thenReturn(Collections.singletonList(mockVar));
		
        Mockito.when(EncryptionHelper.decrypt(params)).thenReturn(decrypted);
        Mockito.when(EncryptionHelper.encrypt("secure123")).thenReturn("encryptedToken");

    	encryptMock.when(() -> EncryptionHelper.generateSecureToken(32)).thenReturn("secure123");
        agentTokenMock.when(() -> AgentTokenLocalServiceUtil.getAgentTokenByDeptCode("DEPT01")).thenReturn(mockToken);
        agentTokenMock.when(() -> AgentTokenLocalServiceUtil.editAgentToken(123L, "DEPT01", "secure123", 1)).thenReturn(mockToken);

        JsonObject result = new Gson().fromJson(service.showAction(params), JsonObject.class);

        agentTokenMock.verify(() -> AgentTokenLocalServiceUtil.getAgentTokenByDeptCode("DEPT01"));
        agentTokenMock.verify(() -> AgentTokenLocalServiceUtil.editAgentToken(123L, "DEPT01", "secure123", 1));
        
        assertEquals(1, result.get("Status").getAsInt());
        assertEquals("encryptedToken", result.getAsJsonObject("Data").get("Token").getAsString());
        assertTrue(result.has("Data"));
	}
	
	@Test
    void testShowAction_agentTokenNotExists() throws Exception {
		String params = "encryptedParam";
		
		AgentToken mockToken = Mockito.mock(AgentToken.class);
        Mockito.when(mockToken.getAgentTokenId()).thenReturn(123L);
		
        Mockito.when(EncryptionHelper.decrypt("encryptedParam")).thenReturn("user|DEPT02");
        Mockito.when(EncryptionHelper.encrypt("secureTokenABC")).thenReturn("encryptedToken");

        encryptMock.when(() -> EncryptionHelper.generateSecureToken(32)).thenReturn("secureTokenABC");
        agentTokenMock.when(() -> AgentTokenLocalServiceUtil.getAgentTokenByDeptCode("DEPT02")).thenReturn(null);
        agentTokenMock.when(() -> AgentTokenLocalServiceUtil.addAgentToken("DEPT02", "secureTokenABC", 1)).thenReturn(mockToken);

        JsonObject result = new Gson().fromJson(service.showAction(params), JsonObject.class);

        agentTokenMock.verify(() -> AgentTokenLocalServiceUtil.addAgentToken("DEPT02", "secureTokenABC", 1));

        assertEquals(1, result.get("Status").getAsInt());
        assertEquals("encryptedToken", result.getAsJsonObject("Data").get("Token").getAsString());
        assertTrue(result.has("Data"));
    }
	
	@Test
    void testUpdateCurrency_amountZero() throws JSONException, IOException {
		String request = "{\"usd\":0.0}";
        JsonObject result = new Gson().fromJson(service.updateCurrency(request), JsonObject.class);

        assertEquals(0, result.get("Status").getAsInt());
        assertEquals("Amount cant be 0", result.get("Message").getAsString());
    }
	
	@Test
    void testUpdateCurrency_noCurrencies() throws JSONException, IOException {
		String request = "{\"usd\":10.0}";

        currencyMock.when(MasterCurrencyLocalServiceUtil::getMasterCurrencies).thenReturn(null);

        JsonObject result = new Gson().fromJson(service.updateCurrency(request), JsonObject.class);

        assertEquals(0, result.get("Status").getAsInt());
        assertEquals("No currency available", result.get("Message").getAsString());
    }
	
	@Test
    void testUpdateCurrency_usdNotFound() throws JSONException, IOException {
		String request = "{\"usd\":10.0}";
		
        MasterCurrency eur = Mockito.mock(MasterCurrency.class);
        Mockito.when(eur.getName()).thenReturn("EUR");

        currencyMock.when(MasterCurrencyLocalServiceUtil::getMasterCurrencies).thenReturn(Collections.singletonList(eur));

        JsonObject result = new Gson().fromJson(service.updateCurrency(request), JsonObject.class);

        assertEquals(0, result.get("Status").getAsInt());
        assertEquals("USD currency not found", result.get("Message").getAsString());
    }
	
	@Test
    void testUpdateCurrency_usdFoundAndUpdated() throws JSONException, IOException {
		String request = "{\"usd\":20.0}";
		
        MasterCurrency usd = Mockito.mock(MasterCurrency.class);
        Mockito.when(usd.getName()).thenReturn("USD");
        Mockito.when(usd.getCurrencyId()).thenReturn(1L);
        Mockito.when(usd.getIsDefault()).thenReturn(1);
        Mockito.when(usd.getActive()).thenReturn(1);

        currencyMock.when(MasterCurrencyLocalServiceUtil::getMasterCurrencies).thenReturn(Arrays.asList(usd));
        currencyMock.when(() -> MasterCurrencyLocalServiceUtil.updateMasterCurrency(Mockito.anyLong(), Mockito.any(), Mockito.anyDouble(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(usd);

        JsonObject result = new Gson().fromJson(service.updateCurrency(request), JsonObject.class);

        currencyMock.verify(() -> MasterCurrencyLocalServiceUtil.updateMasterCurrency(1L, "USD", 20.0, 1, 1));

        assertEquals(1, result.get("Status").getAsInt());
        assertEquals("Currency successfully updated", result.get("Message").getAsString());
    }
	
	@Test
    void testUpdateCurrency_exceptionHandling() throws Exception {
        String request = "{\"usd\":50.0}";

        currencyMock.when(MasterCurrencyLocalServiceUtil::getMasterCurrencies).thenThrow(new RuntimeException("DB error"));

        JsonObject result = new Gson().fromJson(service.updateCurrency(request), JsonObject.class);

        assertEquals(0, result.get("Status").getAsInt());
        assertEquals("Failed to update the currency", result.get("Message").getAsString());
    }
	
	private JsonObject invokeFinalResponse(String travellerType, String travelType, String currency, long totalInclusiveDays,
			MasterCurrency masterCurrency, int adultTotal, int childTotal, String departureDisplayDate,
			String arrivalDisplayDate, double discount, boolean spesificPlan, String choosenPlan, double commision,
			double tax, List<Map<String, Object>> planContainer, String promoCode, String paymentMethod, String managedBy) throws Exception {
		
        Method method = SmartTravelApplication.class.getDeclaredMethod("finalResponse", String.class, String.class, String.class, long.class,
    			MasterCurrency.class, int.class, int.class, String.class, String.class, double.class, boolean.class, String.class, double.class,
    			double.class, List.class, String.class, String.class, String.class);
        method.setAccessible(true);
        
        return (JsonObject) method.invoke(service, travellerType, travelType, currency, totalInclusiveDays, masterCurrency, adultTotal, childTotal, departureDisplayDate, arrivalDisplayDate,
        		discount, spesificPlan, choosenPlan, commision, tax, planContainer, promoCode, paymentMethod, managedBy);
    }

    private List<Map<String, Object>> testFinalResponse_dummyPlanContainer() {
        Map<String, Object> plan = new HashMap<>();
        plan.put("TotalMainBenefitPremium", 2000.0);
        plan.put("TotalAdditionalBenefitPremium", 500.0);
        plan.put("TotalAdultMainBenefitPremium", 1000.0);
        plan.put("TotalAdultAdditionalBenefitPremium", 200.0);
        plan.put("TotalChildMainBenefitPremium", 500.0);
        plan.put("TotalChildAdditionalBenefitPremium", 100.0);

        return new ArrayList<>(Collections.singletonList(plan));
    }
	
	@Test
    void testFinalResponse_idrWithCommissionAndTax() throws Exception {
		ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();

        JsonObject result = invokeFinalResponse(
            "adult",              // travellerType
            "single",             // travelType
            "idr",                // currency
            10,                   // totalInclusiveDays
            masterCurrency,
            2,                    // adultTotal
            1,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2025-01-10",         // arrivalDisplayDate
            10.0,                 // discount
            true,                 // spesificPlan
            "PlanA",              // choosenPlan
            5.0,                  // commision %
            2.0,                  // tax %
            testFinalResponse_dummyPlanContainer(),
            "PROMO123",           // promoCode
            "nett",               // paymentMethod
            "AgentX"              // managedBy
        );
        
        assertNotNull(result);
        assertEquals("ADULT", result.get("TravellerType").getAsString());
        assertEquals("SINGLE", result.get("TravelType").getAsString());
        assertEquals("IDR", result.get("Currency").getAsString());

        // PolicyCost & Stamp
        assertEquals(1000.0, result.get("PolicyCost").getAsDouble(), 0.0);
        assertEquals(500.0, result.get("Stamp").getAsDouble(), 0.0);

        // Commission & Tax
        assertEquals(5.0, result.get("Commission").getAsDouble(), 0.0);
        assertTrue(result.get("CommissionValue").getAsDouble() > 0);
        assertEquals(2.0, result.get("Tax").getAsDouble(), 0.0);
        assertTrue(result.get("TaxValue").getAsDouble() > 0);

        // Validate AvailablePlans content
        JsonArray plans = result.get("AvailablePlans").getAsJsonArray();
        assertNotNull(plans);
        JsonObject plan = plans.get(0).getAsJsonObject();
        assertEquals(10.0, plan.get("Discount").getAsDouble(), 0.0);
        assertTrue(plan.get("Premium").getAsDouble() > 0);
        assertTrue(plan.get("NetPremium").getAsDouble() > 0);
        assertTrue(plan.get("NetPremiumIDR").getAsDouble() > 0);
        assertTrue(plan.get("NetPremiumWithoutDiscount").getAsDouble() > 0);
        assertTrue(plan.get("NetPremiumWithoutDiscountIDR").getAsDouble() > 0);

        // Adult & Child Premium check
        assertEquals(1200.0, plan.get("PremiumAdult").getAsDouble(), 0.0);
        assertEquals(600.0, plan.get("PremiumChild").getAsDouble(), 0.0);
    }

    @Test
    void testFinalResponse_idrSpesificPlanFalse() throws Exception {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();

        JsonObject result = invokeFinalResponse(
            "child",              // travellerType
            "single",             // travelType
            "idr",                // currency
            10,                   // totalInclusiveDays
            masterCurrency,
            1,                    // adultTotal
            1,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2025-01-10",         // arrivalDisplayDate
            0.0,                  // discount
            false,                // spesificPlan
            "PlanB",              // choosenPlan
            5.0,                  // commision %
            2.0,                  // tax %
            testFinalResponse_dummyPlanContainer(),
            "PROMO123",           // promoCode
            "nett",               // paymentMethod
            "AgentX"              // managedBy
        );

        assertNotNull(result);
        assertEquals("CHILD", result.get("TravellerType").getAsString());
        assertEquals("IDR", result.get("Currency").getAsString());

        // Karena spesificPlan = false -> field Premium & Commission tidak ada
        assertFalse(result.has("Premium"));
        assertFalse(result.has("Commission"));

        // Tapi AvailablePlans tetap ada
        JsonArray plans = result.get("AvailablePlans").getAsJsonArray();
        assertNotNull(plans);
        assertTrue(plans.size() > 0);
    }

    @Test
    void testFinalResponse_usdGrossPayment() throws Exception {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();

        JsonObject result = invokeFinalResponse(
            "adult",              // travellerType
            "annual",             // travelType
            "usd",                // currency
            365,                  // totalInclusiveDays
            masterCurrency,
            2,                    // adultTotal
            0,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2026-01-01",         // arrivalDisplayDate
            5.0,                  // discount
            true,                 // spesificPlan
            "PlanC",              // choosenPlan
            10.0,                 // commision %
            5.0,                  // tax %
            testFinalResponse_dummyPlanContainer(),
            "PROMO123",           // promoCode
            "gross",              // paymentMethod
            "AgentX"              // managedBy
        );

        assertNotNull(result);
        assertEquals("USD", result.get("Currency").getAsString());
        assertEquals("ANNUAL", result.get("TravelType").getAsString());

        // Karena paymentMethod = gross -> CommissionValue = 0, TaxValue = 0
        assertEquals(0.0, result.get("CommissionValue").getAsDouble(), 0.0);
        assertEquals(0.0, result.get("TaxValue").getAsDouble(), 0.0);
    }

    @Test
    void testFinalResponse_usdNettButManagedByEmpty() throws Exception {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();

        JsonObject result = invokeFinalResponse(
            "adult",              // travellerType
            "annual",             // travelType
            "usd",                // currency
            365,                  // totalInclusiveDays
            masterCurrency,
            2,                    // adultTotal
            0,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2026-01-01",         // arrivalDisplayDate
            5.0,                  // discount
            true,                 // spesificPlan
            "PlanC",              // choosenPlan
            10.0,                 // commision %
            5.0,                  // tax %
            testFinalResponse_dummyPlanContainer(),
            "PROMO123",           // promoCode
            "nett",               // paymentMethod
            ""                    // managedBy
        );

        assertNotNull(result);
        assertEquals("USD", result.get("Currency").getAsString());

        // Karena managedBy kosong -> CommissionValue = 0, TaxValue = 0
        assertEquals(0.0, result.get("CommissionValue").getAsDouble(), 0.0);
        assertEquals(0.0, result.get("TaxValue").getAsDouble(), 0.0);
    }
    
    @Test
    void testFinalResponse_discountZero() throws Exception {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();
        
        List<Map<String, Object>> planContainer = testFinalResponse_dummyPlanContainer();

        JsonObject result = invokeFinalResponse(
            "adult",              // travellerType
            "single",             // travelType
            "idr",                // currency
            10,                   // totalInclusiveDays
            masterCurrency,
            1,                    // adultTotal
            0,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2025-01-10",         // arrivalDisplayDate
            0.0,                  // discount
            true,                 // spesificPlan
            "PlanC",              // choosenPlan
            10.0,                 // commision %
            5.0,                  // tax %
            planContainer,
            "PROMO123",           // promoCode
            "nett",               // paymentMethod
            "AgentX"              // managedBy
        );

        // Assert
        assertNotNull(result);
        assertEquals(0.0, result.get("Discount").getAsDouble());
        assertEquals("PlanC", result.get("Plan").getAsString());
        assertEquals(0.0, result.get("DiscountAmount").getAsDouble());

        // NetPremium = GrossPremium + PolicyCost + StampDuty
        double grossPremium = (double) planContainer.get(0).get("TotalMainBenefitPremium") + (double) planContainer.get(0).get("TotalAdditionalBenefitPremium");
        double expectedNetPremium = Math.round(grossPremium + mockConfig.getPolicyCostIDR() + mockConfig.getStampdutyIDR());

        assertEquals(expectedNetPremium, result.get("NetPremium").getAsDouble());
    }
    
    @Test
    void testFinalResponse_withDiscount() throws Exception {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();
        
        List<Map<String, Object>> planContainer = testFinalResponse_dummyPlanContainer();

        JsonObject result = invokeFinalResponse(
            "adult",              // travellerType
            "single",             // travelType
            "idr",                // currency
            10,                   // totalInclusiveDays
            masterCurrency,
            1,                    // adultTotal
            0,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2025-01-10",         // arrivalDisplayDate
            20.0,                 // discount
            true,                 // spesificPlan
            "PlanC",              // choosenPlan
            10.0,                 // commision %
            5.0,                  // tax %
            planContainer,
            "PROMO123",           // promoCode
            "nett",               // paymentMethod
            "AgentX"              // managedBy
        );

        // Assert
        assertNotNull(result);
        assertEquals(20.0, result.get("Discount").getAsDouble());
        assertEquals("PlanC", result.get("Plan").getAsString());

        double grossPremium = (double) planContainer.get(0).get("TotalMainBenefitPremium") + (double) planContainer.get(0).get("TotalAdditionalBenefitPremium");
        double discountAmount = grossPremium * (20.0 / 100.0);
        double discountedPremium = grossPremium - discountAmount;
        double expectedNetPremium = Math.round(discountedPremium + mockConfig.getPolicyCostIDR() + mockConfig.getStampdutyIDR());

        assertEquals(Math.round(discountAmount), Math.round(result.get("DiscountAmount").getAsDouble()));
        assertEquals(expectedNetPremium, result.get("NetPremium").getAsDouble());
    }
    
    @Test
    void testFinalResponse_annualTravelTypeUses365Days() throws Exception {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();
        
        List<Map<String, Object>> planContainer = testFinalResponse_dummyPlanContainer();

        JsonObject result = invokeFinalResponse(
            "adult",              // travellerType
            "annual",             // travelType
            "idr",                // currency
            365,                  // totalInclusiveDays
            masterCurrency,
            1,                    // adultTotal
            0,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2026-01-01",         // arrivalDisplayDate
            0.0,                  // discount
            true,                 // spesificPlan
            "PlanC",              // choosenPlan
            0.0,                  // commision %
            0.0,                  // tax %
            planContainer,
            "PROMO123",           // promoCode
            "gross",              // paymentMethod
            "AgentX"              // managedBy
        );

        assertEquals(365L, result.get("TotalDays").getAsLong());
    }
    
    @Test
    void testFinalResponse_multiplePlans() throws Exception {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();
        
        List<Map<String, Object>> mockPlanContainer = testFinalResponse_dummyPlanContainer();

        List<Map<String, Object>> planContainer = new ArrayList<>();
        planContainer.add(mockPlanContainer.get(0));
        planContainer.add(mockPlanContainer.get(0)); // tambahkan 2 plan
        
        JsonObject result = invokeFinalResponse(
            "adult",              // travellerType
            "single",             // travelType
            "idr",                // currency
            5,                    // totalInclusiveDays
            masterCurrency,
            1,                    // adultTotal
            1,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2025-01-05",         // arrivalDisplayDate
            10.0,                 // discount
            true,                 // spesificPlan
            "PlanC",              // choosenPlan
            0.0,                  // commision %
            0.0,                  // tax %
            planContainer,
            "PROMO123",           // promoCode
            "gross",              // paymentMethod
            "AgentX"              // managedBy
        );

        JsonArray plans = result.get("AvailablePlans").getAsJsonArray();
        assertEquals(2, plans.size()); // ada 2 plan
        assertTrue(plans.get(0).getAsJsonObject().has("PremiumAdult"));
        assertTrue(plans.get(1).getAsJsonObject().has("PremiumChild"));
    }
    
    @Test
    void testFinalResponse_emptyPlanContainerThrowsException() {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();

        List<Map<String, Object>> emptyPlanContainer = new ArrayList<>();

        InvocationTargetException ex = assertThrows(InvocationTargetException.class, () ->
        	invokeFinalResponse(
                "adult",
                "single",
                "idr",
                5,
                masterCurrency,
                1,
                0,
                "2025-01-01",
                "2025-01-05",
                0.0,
                true,
                "PlanC",
                0.0,
                0.0,
                emptyPlanContainer,
                "PROMO",
                "gross",
                "AgentX"
            )
        );
        
        Throwable cause = ex.getCause();
        assertTrue(cause instanceof InvalidPlanException);
        assertEquals("Plan container must not be empty or null", cause.getMessage());
    }
    
    @Test
    void testFinalResponse_planContainerWithDefaults() throws Exception {
    	ProductConfiguration mockConfig = mockProductConfig();
        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

        MasterCurrency masterCurrency = mockMasterCurrency();

        Map<String, Object> emptyPlan = new HashMap<>(); // tidak isi apapun
        List<Map<String, Object>> planContainer = Collections.singletonList(emptyPlan);
        
        JsonObject result = invokeFinalResponse(
            "adult",              // travellerType
            "single",             // travelType
            "idr",                // currency
            5,                    // totalInclusiveDays
            masterCurrency,
            1,                    // adultTotal
            0,                    // childTotal
            "2025-01-01",         // departureDisplayDate
            "2025-01-05",         // arrivalDisplayDate
            0.0,                  // discount
            true,                 // spesificPlan
            "PlanC",              // choosenPlan
            0.0,                  // commision %
            0.0,                  // tax %
            planContainer,
            "PROMO123",           // promoCode
            "gross",              // paymentMethod
            "AgentX"              // managedBy
        );

        JsonArray plans = result.get("AvailablePlans").getAsJsonArray();
        JsonObject plan = plans.get(0).getAsJsonObject();

        // semua default value 0
        assertEquals(0.0, plan.get("Premium").getAsDouble());
        assertEquals(1500.0, plan.get("NetPremium").getAsDouble());
    }
	
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> invokeCalculateIndividual(Map<String,Object> paramCalc) throws Exception {
        Method method = SmartTravelApplication.class.getDeclaredMethod("calculateIndividual", Map.class);
        method.setAccessible(true);
        return (List<Map<String, Object>>) method.invoke(service, paramCalc);
    }
	
	private Map<String, Object> testCalculateIndividu_baseParam() {
        Map<String, Object> paramCalc = new HashMap<>();
        paramCalc.put("referrer", "");
        paramCalc.put("currency", "USD");
        paramCalc.put("choosenPlan", "");
        paramCalc.put("travelType", "single");
        paramCalc.put("additionalDays", 0);
        paramCalc.put("additionalBenefits", new JsonArray());
        paramCalc.put("additionalBenefitCodes", new JsonArray());
        paramCalc.put("fp", 1);
        return paramCalc;
    }

    private class TestCalculateIndividu_context {
        Map<String, Object> param;

        TestCalculateIndividu_context(Map<String, Object> param) {
            this.param = param;
        }

        List<Map<String, Object>> execute() throws Exception {
            return invokeCalculateIndividual(param);
        }
    }

    private TestCalculateIndividu_context testCalculateIndividu_mockMainBenefitScenario(String travelType, int additionalDays, BigDecimal basic, BigDecimal additional, BigDecimal annual) {
        Map<String, Object> param = testCalculateIndividu_baseParam();
        param.put("travelType", travelType);
        param.put("additionalDays", additionalDays);

        MasterCurrency mc = Mockito.mock(MasterCurrency.class);
        Mockito.when(mc.getAmount()).thenReturn(15000.0);

        Premi premi = Mockito.mock(Premi.class);
        Mockito.when(premi.getPlanId()).thenReturn(1L);
        Mockito.when(premi.getBenefitId()).thenReturn(100L);
        Mockito.when(premi.getBasic()).thenReturn(basic);
        Mockito.when(premi.getAdditional()).thenReturn(additional);
        Mockito.when(premi.getAnnual()).thenReturn(annual);

        Benefit benefit = Mockito.mock(Benefit.class);
        Mockito.when(benefit.getBenefitId()).thenReturn(100L);
        Mockito.when(benefit.getNameId()).thenReturn("MAIN_BENEFIT");
        Mockito.when(benefit.getExternalCode()).thenReturn("EXT100");

        BenefitType bt = Mockito.mock(BenefitType.class);
        Mockito.when(bt.getNameId()).thenReturn("Jaminan Utama");
        Mockito.when(bt.getNameEn()).thenReturn("Main Benefit");

        BenefitValueMapping bvm = Mockito.mock(BenefitValueMapping.class);
        Mockito.when(bvm.getBenefitValue()).thenReturn("100jt");
        Mockito.when(bvm.getBenefitValueUSD()).thenReturn("1000USD");

        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getNameId()).thenReturn("PLAN_A");

        currencyMock.when(() -> MasterCurrencyLocalServiceUtil.searchCurrency("USD")).thenReturn(mc);
        premiMock.when(() -> PremiLocalServiceUtil.findByCurrencyAndTravellerType("USD", "individual")).thenReturn(Collections.singletonList(premi));
        planMock.when(() -> SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(1L)).thenReturn(plan);
        benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(100L)).thenReturn(benefit);
        benefitTypeMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(Mockito.anyLong())).thenReturn(bt);
        benefitValMapMock.when(() -> BenefitValueMappingLocalServiceUtil.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(bvm);

        return new TestCalculateIndividu_context(param);
    }

    private TestCalculateIndividu_context testCalculateIndividu_mockAdditionalBenefitScenario(boolean pimcore) {
        Map<String, Object> param = testCalculateIndividu_baseParam();
        param.put("travelType", "single");
        if (pimcore) {
            param.put("referrer", "pimcore");
        }

        MasterCurrency mc = Mockito.mock(MasterCurrency.class);
        Mockito.when(mc.getAmount()).thenReturn(15000.0);

        Premi premi = Mockito.mock(Premi.class);
        Mockito.when(premi.getPlanId()).thenReturn(1L);
        Mockito.when(premi.getBenefitId()).thenReturn(200L);
        Mockito.when(premi.getBasic()).thenReturn(new BigDecimal("50.0"));
        Mockito.when(premi.getAdditional()).thenReturn(new BigDecimal("5.0"));
        Mockito.when(premi.getAnnual()).thenReturn(new BigDecimal("200.0"));

        Benefit benefit = Mockito.mock(Benefit.class);
        Mockito.when(benefit.getBenefitId()).thenReturn(200L);
        Mockito.when(benefit.getNameId()).thenReturn("BENEFIT_200");
        Mockito.when(benefit.getExternalCode()).thenReturn("EXT200");

        BenefitType bt = Mockito.mock(BenefitType.class);
        Mockito.when(bt.getNameId()).thenReturn("Tambahan");
        Mockito.when(bt.getNameEn()).thenReturn("Additional");

        BenefitValueMapping bvm = Mockito.mock(BenefitValueMapping.class);
        Mockito.when(bvm.getBenefitValue()).thenReturn("50jt");
        Mockito.when(bvm.getBenefitValueUSD()).thenReturn("500USD");

        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getNameId()).thenReturn("PLAN_B");

        currencyMock.when(() -> MasterCurrencyLocalServiceUtil.searchCurrency("USD")).thenReturn(mc);
        premiMock.when(() -> PremiLocalServiceUtil.findByCurrencyAndTravellerType("USD", "individual")).thenReturn(Collections.singletonList(premi));
        planMock.when(() -> SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(1L)).thenReturn(plan);
        benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(200L)).thenReturn(benefit);
        benefitTypeMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(Mockito.anyLong())).thenReturn(bt);
        benefitValMapMock.when(() -> BenefitValueMappingLocalServiceUtil.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong()))
                .thenReturn(bvm);

        return new TestCalculateIndividu_context(param);
    }
	
    @Test
    void testCalculateIndividu_noPremiReturnsEmptyList() throws Exception {
        currencyMock.when(() -> MasterCurrencyLocalServiceUtil.searchCurrency("USD")).thenReturn(Mockito.mock(MasterCurrency.class));
        premiMock.when(() -> PremiLocalServiceUtil.findByCurrencyAndTravellerType("USD", "individual")).thenReturn(Collections.emptyList());

        List<Map<String, Object>> result = invokeCalculateIndividual(testCalculateIndividu_baseParam());

        assertTrue(result.isEmpty());
    }

    @Test
    void testCalculateIndividu_singleTravelTypeNoAdditionalDays() throws Exception {
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockMainBenefitScenario("single", 0, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        List<Map<String, Object>> result = ctx.execute();

        assertEquals(1, result.size());
        assertEquals(100.0, result.get(0).get("TotalMainBenefitPremium"));
    }

    @Test
    void testCalculateIndividu_singleTravelTypeWithAdditionalDays() throws Exception {
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockMainBenefitScenario("single", 2, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        List<Map<String, Object>> result = ctx.execute();

        assertEquals(120.0, result.get(0).get("TotalMainBenefitPremium")); // 100 + (10*2)
    }

    @Test
    void testCalculateIndividu_annualTravelTypePremiumTakenFromAnnualField() throws Exception {
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockMainBenefitScenario("annual", 0, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        List<Map<String, Object>> result = ctx.execute();

        assertEquals(500.0, result.get(0).get("TotalMainBenefitPremium"));
    }

    @Test
    void testCalculateIndividu_choosenPlanMatch() throws Exception {
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockMainBenefitScenario("single", 0, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        ctx.param.put("choosenPlan", "PLAN_A");
        List<Map<String, Object>> result = ctx.execute();

        assertEquals(1, result.size());
        assertEquals("PLAN_A", result.get(0).get("PlanName"));
    }

    @Test
    void testCalculateIndividu_choosenPlanNotMatch() throws Exception {
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockMainBenefitScenario("single", 0, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        ctx.param.put("choosenPlan", "OTHER_PLAN");
        List<Map<String, Object>> result = ctx.execute();

        assertTrue(result.isEmpty());
    }

    @Test
    void testCalculateIndividu_additionalBenefitFromFE() throws Exception {
    	JsonArray arr = new JsonArray();
    	arr.add(200);
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockAdditionalBenefitScenario(false); // referrer kosong
        ctx.param.put("additionalBenefits", arr); // pilih benefit id 200

        List<Map<String, Object>> result = ctx.execute();
        @SuppressWarnings("unchecked")
		List<Map<String, Object>> addList = (List<Map<String, Object>>) result.get(0).get("AdditionalBenefitList");

        assertEquals(1, addList.size());
        assertEquals("BENEFIT_200", addList.get(0).get("Benefit Name"));
    }

    @Test
    void testCalculateIndividu_additionalBenefitFromPimcore() throws Exception {
    	JsonArray arr = new JsonArray();
    	arr.add("EXT200");
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockAdditionalBenefitScenario(true); // referrer tidak kosong
        ctx.param.put("additionalBenefitCodes", arr);

        List<Map<String, Object>> result = ctx.execute();
        @SuppressWarnings("unchecked")
		List<Map<String, Object>> addList = (List<Map<String, Object>>) result.get(0).get("AdditionalBenefitList");

        assertEquals(1, addList.size());
        assertEquals("BENEFIT_200", addList.get(0).get("Benefit Name"));
    }

    @Test
    void testCalculateIndividu_totalAllAdditionalBenefitCalculated() throws Exception {
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockAdditionalBenefitScenario(false);
        List<Map<String, Object>> result = ctx.execute();

        assertTrue((Double) result.get(0).get("TotalAdditionalBenefitPremiumAllChecked") > 0);
    }

    @Test
    void testCalculateIndividu_currencyConversionToIDR() throws Exception {
    	TestCalculateIndividu_context ctx = testCalculateIndividu_mockMainBenefitScenario("single", 0, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        List<Map<String, Object>> result = ctx.execute();

        assertEquals(100.0 * 15000, result.get(0).get("TotalMainBenefitPremiumInIDR"));
    }

    @Test
    void testCalculateIndividu_exceptionHandledGracefully() throws Exception {
        currencyMock.when(() -> MasterCurrencyLocalServiceUtil.searchCurrency("USD")).thenThrow(new RuntimeException("DB down"));

        List<Map<String, Object>> result = invokeCalculateIndividual(testCalculateIndividu_baseParam());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
    
    private JsonObject invokeCalculatePremi(JsonObject params, boolean spesificPlan) throws Exception {
        Method method = SmartTravelApplication.class.getDeclaredMethod("calculatePremi", JsonObject.class, boolean.class);
        method.setAccessible(true);
        return (JsonObject) method.invoke(service, params, spesificPlan);
    }
    
    private JsonObject testCalculateDuo_baseParam() {
        JsonObject params = new JsonObject();
        params.addProperty("Referrer", "");
        params.add("AdditionalBenefitCodes", new JsonArray());
        params.add("AdditionalBenefits", new JsonArray());
        params.addProperty("fp", 1);
        params.addProperty("ManagedBy", "system");
        params.addProperty("Currency", "usd");
        params.addProperty("TravellerType", "duo");
        params.addProperty("TravelType", "single");
        params.addProperty("AdultTotal", 2);
        params.addProperty("ChildTotal", 0);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        LocalDate from = LocalDate.of(2025, 1, 1);
        LocalDate to = LocalDate.of(2025, 1, 5);
        params.addProperty("DepartureDate", from.format(fmt));
        params.addProperty("ArrivalDate", to.format(fmt));

        params.addProperty("PromoCode", "PROMO123");
        params.addProperty("SpesificPlan", "");
        params.addProperty("Commission", 0.1);
        params.addProperty("Tax", 0.05);
        params.addProperty("PaymentMethod", "CC");
        params.addProperty("Discount", 0.0);
        return params;
    }
    
    private class TestCalculatePremi_context {
        JsonObject params;
        boolean spesificPlan;

        TestCalculatePremi_context(JsonObject params, boolean spesificPlan) {
            this.params = params;
            this.spesificPlan = spesificPlan;
        }

        JsonObject execute() throws Exception {
            return invokeCalculatePremi(params, spesificPlan);
        }
    }
    
    private TestCalculatePremi_context testCalculatePremiDuo(JsonObject params, BigDecimal basic, BigDecimal additional, BigDecimal annual) {
        ProductConfiguration mockConfig = mockProductConfig();

        MasterCurrency mc = mockMasterCurrency();

        Premi premi1 = Mockito.mock(Premi.class);
        Mockito.when(premi1.getPlanId()).thenReturn(1L);
        Mockito.when(premi1.getBenefitId()).thenReturn(101L);
        Mockito.when(premi1.getBasic()).thenReturn(basic);
        Mockito.when(premi1.getAdditional()).thenReturn(additional);
        Mockito.when(premi1.getAnnual()).thenReturn(annual);
        
        Premi premi2 = Mockito.mock(Premi.class);
        Mockito.when(premi2.getPlanId()).thenReturn(1L);
        Mockito.when(premi2.getBenefitId()).thenReturn(102L);
        Mockito.when(premi2.getBasic()).thenReturn(basic);
        Mockito.when(premi2.getAdditional()).thenReturn(additional);
        Mockito.when(premi2.getAnnual()).thenReturn(annual);
        
        Premi premi3 = Mockito.mock(Premi.class);
        Mockito.when(premi3.getPlanId()).thenReturn(1L);
        Mockito.when(premi3.getBenefitId()).thenReturn(103L);
        Mockito.when(premi3.getBasic()).thenReturn(basic);
        Mockito.when(premi3.getAdditional()).thenReturn(additional);
        Mockito.when(premi3.getAnnual()).thenReturn(annual);
        
        Premi premi4 = Mockito.mock(Premi.class);
        Mockito.when(premi4.getPlanId()).thenReturn(1L);
        Mockito.when(premi4.getBenefitId()).thenReturn(104L);
        Mockito.when(premi4.getBasic()).thenReturn(basic);
        Mockito.when(premi4.getAdditional()).thenReturn(additional);
        Mockito.when(premi4.getAnnual()).thenReturn(annual);

        Benefit benefit1 = Mockito.mock(Benefit.class);
        Mockito.when(benefit1.getBenefitTypeId()).thenReturn(201L);
        Mockito.when(benefit1.getBenefitId()).thenReturn(101L);
        Mockito.when(benefit1.getNameId()).thenReturn("Biaya Pengobatan, Gigi dan Lainnya");
        Mockito.when(benefit1.getExternalCode()).thenReturn("BENEFIT-101");
        
        Benefit benefit2 = Mockito.mock(Benefit.class);
        Mockito.when(benefit2.getBenefitTypeId()).thenReturn(202L);
        Mockito.when(benefit2.getBenefitId()).thenReturn(102L);
        Mockito.when(benefit2.getNameId()).thenReturn("Kecelakaan Diri");
        Mockito.when(benefit2.getExternalCode()).thenReturn("BENEFIT-102");
        
        Benefit benefit3 = Mockito.mock(Benefit.class);
        Mockito.when(benefit3.getBenefitTypeId()).thenReturn(203L);
        Mockito.when(benefit3.getBenefitId()).thenReturn(103L);
        Mockito.when(benefit3.getNameId()).thenReturn("Evakuasi Medis Darurat dan Repatriasi");
        Mockito.when(benefit3.getExternalCode()).thenReturn("BENEFIT-103");
        
        Benefit benefit4 = Mockito.mock(Benefit.class);
        Mockito.when(benefit4.getBenefitTypeId()).thenReturn(204L);
        Mockito.when(benefit4.getBenefitId()).thenReturn(104L);
        Mockito.when(benefit4.getNameId()).thenReturn("Pemulangan Jenazah");
        Mockito.when(benefit4.getExternalCode()).thenReturn("BENEFIT-104");

        BenefitType bt1 = Mockito.mock(BenefitType.class);
        Mockito.when(bt1.getBenefitTypeId()).thenReturn(201L);
        Mockito.when(bt1.getNameId()).thenReturn("Jaminan Utama");
        Mockito.when(bt1.getNameEn()).thenReturn("Main Benefit");
        
        BenefitType bt2 = Mockito.mock(BenefitType.class);
        Mockito.when(bt2.getBenefitTypeId()).thenReturn(202L);
        Mockito.when(bt2.getNameId()).thenReturn("Jaminan Utama");
        Mockito.when(bt2.getNameEn()).thenReturn("Main Benefit");
        
        BenefitType bt3 = Mockito.mock(BenefitType.class);
        Mockito.when(bt3.getBenefitTypeId()).thenReturn(203L);
        Mockito.when(bt3.getNameId()).thenReturn("Jaminan Utama");
        Mockito.when(bt3.getNameEn()).thenReturn("Main Benefit");
        
        BenefitType bt4 = Mockito.mock(BenefitType.class);
        Mockito.when(bt4.getBenefitTypeId()).thenReturn(204L);
        Mockito.when(bt4.getNameId()).thenReturn("Jaminan Utama");
        Mockito.when(bt4.getNameEn()).thenReturn("Main Benefit");

        BenefitValueMapping bvm1 = Mockito.mock(BenefitValueMapping.class);
        Mockito.when(bvm1.getBenefitId()).thenReturn(101L);
        Mockito.when(bvm1.getBenefitTypeId()).thenReturn(201L);
        Mockito.when(bvm1.getBenefitValue()).thenReturn("100jt");
        Mockito.when(bvm1.getBenefitValueUSD()).thenReturn("1000USD");
        
        BenefitValueMapping bvm2 = Mockito.mock(BenefitValueMapping.class);
        Mockito.when(bvm2.getBenefitId()).thenReturn(102L);
        Mockito.when(bvm2.getBenefitTypeId()).thenReturn(202L);
        Mockito.when(bvm2.getBenefitValue()).thenReturn("200jt");
        Mockito.when(bvm2.getBenefitValueUSD()).thenReturn("2000USD");
        
        BenefitValueMapping bvm3 = Mockito.mock(BenefitValueMapping.class);
        Mockito.when(bvm3.getBenefitId()).thenReturn(103L);
        Mockito.when(bvm3.getBenefitTypeId()).thenReturn(203L);
        Mockito.when(bvm3.getBenefitValue()).thenReturn("300jt");
        Mockito.when(bvm3.getBenefitValueUSD()).thenReturn("3000USD");
        
        BenefitValueMapping bvm4 = Mockito.mock(BenefitValueMapping.class);
        Mockito.when(bvm4.getBenefitId()).thenReturn(104L);
        Mockito.when(bvm4.getBenefitTypeId()).thenReturn(204L);
        Mockito.when(bvm4.getBenefitValue()).thenReturn("400jt");
        Mockito.when(bvm4.getBenefitValueUSD()).thenReturn("4000USD");

        Premi premi5 = Mockito.mock(Premi.class);
    	Benefit additionalBenefit = Mockito.mock(Benefit.class);
        BenefitType additionalBt = Mockito.mock(BenefitType.class);
        BenefitValueMapping additionalBvm = Mockito.mock(BenefitValueMapping.class);
        
        boolean hasAdditionalPimcore = params.has("AdditionalBenefitCodes") && params.get("AdditionalBenefitCodes").getAsJsonArray().size() > 0;
        boolean hasAdditionalFE = params.has("AdditionalBenefits") && params.get("AdditionalBenefits").getAsJsonArray().size() > 0;
        
        if (hasAdditionalPimcore || hasAdditionalFE) {
            Mockito.when(premi5.getPlanId()).thenReturn(1L);
            Mockito.when(premi5.getBenefitId()).thenReturn(201L);
            Mockito.when(premi5.getBasic()).thenReturn(basic);
            Mockito.when(premi5.getAdditional()).thenReturn(additional);
            Mockito.when(premi5.getAnnual()).thenReturn(annual);
        	
        	Mockito.when(additionalBenefit.getBenefitTypeId()).thenReturn(301L);
            Mockito.when(additionalBenefit.getBenefitId()).thenReturn(201L);
            Mockito.when(additionalBenefit.getNameId()).thenReturn("Keterlambatan atau Pembatalan Perjalanan");
            Mockito.when(additionalBenefit.getExternalCode()).thenReturn("BENEFIT-201");

            Mockito.when(additionalBt.getBenefitTypeId()).thenReturn(301L);
            Mockito.when(additionalBt.getNameId()).thenReturn("Tambahan");
            Mockito.when(additionalBt.getNameEn()).thenReturn("Additional");
            
            Mockito.when(additionalBvm.getBenefitId()).thenReturn(201L);
            Mockito.when(additionalBvm.getBenefitTypeId()).thenReturn(301L);
            Mockito.when(additionalBvm.getBenefitValue()).thenReturn("150jt");
            Mockito.when(additionalBvm.getBenefitValueUSD()).thenReturn("1500USD");
            
            benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(201L)).thenReturn(additionalBenefit);
        }

        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getNameId()).thenReturn("PLAN_A");

        productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);
        currencyMock.when(() -> MasterCurrencyLocalServiceUtil.searchCurrency("usd")).thenReturn(mc);

        premiMock.when(() -> PremiLocalServiceUtil.findByCurrencyAndTravellerType(Mockito.eq("usd"), Mockito.anyString()))
        .thenAnswer(invocation -> {
            String travellerType = invocation.getArgument(1);
            if (params.has("SpousePremisNull") && params.get("SpousePremisNull").getAsBoolean() && "SPOUSE".equalsIgnoreCase(travellerType)) {
                return Collections.emptyList();
            }
            if (hasAdditionalPimcore || hasAdditionalFE) {
            	return Arrays.asList(premi1, premi2, premi3, premi4, premi5);
            }
            return Arrays.asList(premi1, premi2, premi3, premi4);
        });
        
        planMock.when(() -> SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(Mockito.anyLong())).thenReturn(plan);
        
        benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(Mockito.anyLong()))
        .thenAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            if (id.equals(101L)) return benefit1;
            if (id.equals(102L)) return benefit2;
            if (id.equals(103L)) return benefit3;
            if (id.equals(104L)) return benefit4;
            if (id.equals(201L) && (hasAdditionalPimcore || hasAdditionalFE)) return additionalBenefit;
            return null;
        });
        
        benefitTypeMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(Mockito.anyLong()))
        .thenAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            if (id.equals(201L)) return bt1;
            if (id.equals(202L)) return bt2;
            if (id.equals(203L)) return bt3;
            if (id.equals(204L)) return bt4;
            if (id.equals(301L) && (hasAdditionalPimcore || hasAdditionalFE)) return additionalBt;
            return null;
        });
        
        benefitValMapMock.when(() -> 
        BenefitValueMappingLocalServiceUtil.getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
            Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong()))
        .thenAnswer(invocation -> {
            Long typeId = invocation.getArgument(0);
            Long benefitId = invocation.getArgument(1);
            if (benefitId.equals(101L) && typeId.equals(201L)) return bvm1;
            if (benefitId.equals(102L) && typeId.equals(202L)) return bvm2;
            if (benefitId.equals(103L) && typeId.equals(203L)) return bvm3;
            if (benefitId.equals(104L) && typeId.equals(204L)) return bvm4;
            if (benefitId.equals(201L) && typeId.equals(301L) && (hasAdditionalPimcore || hasAdditionalFE)) return additionalBvm;
            return null;
        });

        return new TestCalculatePremi_context(params, true);
    }

    @Test
    void testCalculateDuo_singleHappyPath() throws Exception {
        TestCalculatePremi_context ctx = testCalculatePremiDuo(testCalculateDuo_baseParam(), new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        JsonObject result = ctx.execute();

        assertTrue(result.has("Calculation"));
        assertEquals("DUO", result.get("Calculation").getAsJsonObject().get("TravellerType").getAsString());
    }

    @Test
    void testCalculateDuo_annualHappyPath() throws Exception {
    	JsonObject params = testCalculateDuo_baseParam();
    	params.addProperty("TravelType", "annual");
    	
    	TestCalculatePremi_context ctx = testCalculatePremiDuo(params, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        JsonObject result = ctx.execute();
        
        assertTrue(result.has("Calculation"));
        assertEquals("DUO", result.get("Calculation").getAsJsonObject().get("TravellerType").getAsString());
    }

    @Test
    void testCalculateDuo_choosenPlanFiltered() throws Exception {
        JsonObject params = testCalculateDuo_baseParam();
        params.addProperty("SpesificPlan", "PLAN_A");

        TestCalculatePremi_context ctx = testCalculatePremiDuo(params, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        JsonObject result = ctx.execute();
        
        assertTrue(result.toString().contains("PLAN_A"));
    }

    @Test
    void testCalculateDuo_spousePremisNull() throws Exception {
        JsonObject params = testCalculateDuo_baseParam();
        params.addProperty("SpousePremisNull", true);

        TestCalculatePremi_context ctx = testCalculatePremiDuo(params, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        JsonObject result = ctx.execute();
        
        assertFalse(result.has("Calculation"));
    }

    @Test
    void testCalcualteDuo_additionalBenefitCodesFromPimcore() throws Exception {
        JsonObject params = testCalculateDuo_baseParam();
        JsonArray codes = new JsonArray();
        codes.add("BENEFIT-201");
        params.add("AdditionalBenefitCodes", codes);
        params.addProperty("Referrer", "pimcore");

        TestCalculatePremi_context ctx = testCalculatePremiDuo(params, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        JsonObject result = ctx.execute();
        
        JsonArray addList = result.get("Calculation").getAsJsonObject().get("AvailablePlans").getAsJsonArray().get(0).getAsJsonObject().get("AdditionalBenefitList").getAsJsonArray();
        
        assertEquals(1, addList.size());
        assertEquals("BENEFIT-201", addList.get(0).getAsJsonObject().get("BenefitCode").getAsString());
    }

    @Test
    void testCalculateDuo_additionalBenefitsFromFE() throws Exception {
    	JsonObject params = testCalculateDuo_baseParam();
        JsonArray codes = new JsonArray();
        codes.add(201);
        params.add("AdditionalBenefits", codes);
        params.addProperty("Referrer", "");

        TestCalculatePremi_context ctx = testCalculatePremiDuo(params, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        JsonObject result = ctx.execute();
        
        JsonArray addList = result.get("Calculation").getAsJsonObject().get("AvailablePlans").getAsJsonArray().get(0).getAsJsonObject().get("AdditionalBenefitList").getAsJsonArray();
        
        assertEquals(1, addList.size());
        assertEquals("BENEFIT-201", addList.get(0).getAsJsonObject().get("BenefitCode").getAsString());
    }

    @Test
    void testCalculateDuo_discountZeroCommissionTaxNormal() throws Exception {
        JsonObject params = testCalculateDuo_baseParam();
        params.addProperty("Discount", 0.0);
        params.addProperty("Commission", 0.2);
        params.addProperty("Tax", 0.1);

        TestCalculatePremi_context ctx = testCalculatePremiDuo(params, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        JsonObject result = ctx.execute();
        
        assertTrue(result.toString().contains("PLAN_A"));
    }

    @Test
    void testCalculateDuo_mainBenefitAggregation() throws Exception {
        JsonObject params = testCalculateDuo_baseParam();

        TestCalculatePremi_context ctx = testCalculatePremiDuo(params, new BigDecimal("100.0"), new BigDecimal("10.0"), new BigDecimal("500.0"));
        JsonObject result = ctx.execute();
        
        JsonArray addList = result.get("Calculation").getAsJsonObject().get("AvailablePlans").getAsJsonArray().get(0).getAsJsonObject().get("MainBenefitList").getAsJsonArray();
        List<String> benefitNames = new ArrayList<>();
        for (JsonElement el : addList) {
            benefitNames.add(el.getAsJsonObject().get("Name").getAsString());
        }

        assertTrue(benefitNames.contains("Biaya Pengobatan, Gigi dan Lainnya"));
        assertTrue(benefitNames.contains("Kecelakaan Diri"));
        assertTrue(benefitNames.contains("Evakuasi Medis Darurat dan Repatriasi"));
        assertTrue(benefitNames.contains("Pemulangan Jenazah"));
    }
}
