package com.mypage.product.it.portlet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.model.Premi;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.SmartTravelIntPlan;
import com.mypage.admin.product.service.BenefitLocalServiceUtil;
import com.mypage.admin.product.service.BenefitTypeLocalServiceUtil;
import com.mypage.admin.product.service.PremiLocalServiceUtil;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.SmartTravelIntPlanLocalServiceUtil;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class SmartTravelInternationalPortletTest {

	private SmartTravelInternationalPortlet service;
	
	@BeforeEach
    void setUp() {
        service = new SmartTravelInternationalPortlet();
    }
	
	private String invokeGenerateLowerPremiPrice() throws Exception {
        Method method = SmartTravelInternationalPortlet.class.getDeclaredMethod("generateLowerPremiPrice");
        method.setAccessible(true);
        return (String) method.invoke(service);
    }
	
	private ProductConfiguration mockProductConfig() {
		ProductConfiguration mockConfig = Mockito.mock(ProductConfiguration.class);
        Mockito.when(mockConfig.getPolicyCostIDR()).thenReturn(1000.0);
        Mockito.when(mockConfig.getPolicyCostUSD()).thenReturn(10.0);
        Mockito.when(mockConfig.getStampdutyIDR()).thenReturn(500.0);
        Mockito.when(mockConfig.getStampdutyUSD()).thenReturn(1.0);
        return mockConfig;
    }
	
	@Test
    void testGenerateLowerPremiPrice_success() throws Exception {
        SmartTravelIntPlan plan1 = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan1.getSmartTravelIntPlanId()).thenReturn(1L);
        Mockito.when(plan1.getNameId()).thenReturn("Plan A");

        SmartTravelIntPlan plan2 = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan2.getSmartTravelIntPlanId()).thenReturn(2L);
        Mockito.when(plan2.getNameId()).thenReturn("Plan B");

        Premi premi1 = Mockito.mock(Premi.class);
        Mockito.when(premi1.getPlanId()).thenReturn(1L);
        Mockito.when(premi1.getBenefitId()).thenReturn(100L);
        Mockito.when(premi1.getBasic()).thenReturn(BigDecimal.valueOf(100000));

        Premi premi2 = Mockito.mock(Premi.class);
        Mockito.when(premi2.getPlanId()).thenReturn(2L);
        Mockito.when(premi2.getBenefitId()).thenReturn(200L);
        Mockito.when(premi2.getBasic()).thenReturn(BigDecimal.valueOf(200000));

        Benefit benefit1 = Mockito.mock(Benefit.class);
        Mockito.when(benefit1.getBenefitTypeId()).thenReturn(10L);

        Benefit benefit2 = Mockito.mock(Benefit.class);
        Mockito.when(benefit2.getBenefitTypeId()).thenReturn(20L);

        BenefitType bt1 = Mockito.mock(BenefitType.class);
        Mockito.when(bt1.getNameId()).thenReturn("Jaminan Utama");

        BenefitType bt2 = Mockito.mock(BenefitType.class);
        Mockito.when(bt2.getNameId()).thenReturn("Jaminan Utama");

        try (MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<PremiLocalServiceUtil> premiMock =
                     Mockito.mockStatic(PremiLocalServiceUtil.class);
             MockedStatic<BenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(BenefitLocalServiceUtil.class);
             MockedStatic<BenefitTypeLocalServiceUtil> btMock =
                     Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
    		 MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
             			 Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {

          	ProductConfiguration mockConfig = mockProductConfig();
              productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

            planMock.when(SmartTravelIntPlanLocalServiceUtil::getActivePlan)
                    .thenReturn(Arrays.asList(plan1, plan2));
            premiMock.when(() ->
                    PremiLocalServiceUtil.findByCurrencyAndTravellerType("idr", "individual"))
                    .thenReturn(Arrays.asList(premi1, premi2));

            benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(100L)).thenReturn(benefit1);
            benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(200L)).thenReturn(benefit2);

            btMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(10L)).thenReturn(bt1);
            btMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(20L)).thenReturn(bt2);

            String result = invokeGenerateLowerPremiPrice();

            NumberFormat f = NumberFormat.getInstance(new Locale("id", "ID"));
            assertEquals("IDR " + f.format(100500), result);
        }
    }

    @Test
    void testGenerateLowerPremiPrice_noPlans() throws Exception {
        try (MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<PremiLocalServiceUtil> premiMock =
                     Mockito.mockStatic(PremiLocalServiceUtil.class)) {

            planMock.when(SmartTravelIntPlanLocalServiceUtil::getActivePlan).thenReturn(null);
            premiMock.when(() ->
                    PremiLocalServiceUtil.findByCurrencyAndTravellerType("idr", "individual"))
                    .thenReturn(null);

            assertEquals("", invokeGenerateLowerPremiPrice());
        }
    }

    @Test
    void testGenerateLowerPremiPrice_allBenefitsNotMain() throws Exception {
        SmartTravelIntPlan plan1 = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan1.getSmartTravelIntPlanId()).thenReturn(1L);
        Mockito.when(plan1.getNameId()).thenReturn("Plan A");

        Premi premi1 = Mockito.mock(Premi.class);
        Mockito.when(premi1.getPlanId()).thenReturn(1L);
        Mockito.when(premi1.getBenefitId()).thenReturn(100L);
        Mockito.when(premi1.getBasic()).thenReturn(BigDecimal.valueOf(100000));

        Benefit benefit1 = Mockito.mock(Benefit.class);
        Mockito.when(benefit1.getBenefitTypeId()).thenReturn(10L);

        BenefitType bt1 = Mockito.mock(BenefitType.class);
        Mockito.when(bt1.getNameId()).thenReturn("Tambahan"); // bukan Jaminan Utama

        try (MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<PremiLocalServiceUtil> premiMock =
                     Mockito.mockStatic(PremiLocalServiceUtil.class);
             MockedStatic<BenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(BenefitLocalServiceUtil.class);
             MockedStatic<BenefitTypeLocalServiceUtil> btMock =
                     Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
           			 Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {

        	ProductConfiguration mockConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);
            
            planMock.when(SmartTravelIntPlanLocalServiceUtil::getActivePlan).thenReturn(Arrays.asList(plan1));
            premiMock.when(() ->
                    PremiLocalServiceUtil.findByCurrencyAndTravellerType("idr", "individual"))
                    .thenReturn(Arrays.asList(premi1));

            benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(100L)).thenReturn(benefit1);
            btMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(10L)).thenReturn(bt1);

            String result = invokeGenerateLowerPremiPrice();
            assertEquals("", result);
        }
    }

    @Test
    void testGenerateLowerPremiPrice_benefitServiceThrowsException() throws Exception {
        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getSmartTravelIntPlanId()).thenReturn(1L);
        Mockito.when(plan.getNameId()).thenReturn("Plan X");

        Premi premi = Mockito.mock(Premi.class);
        Mockito.when(premi.getPlanId()).thenReturn(1L);
        Mockito.when(premi.getBenefitId()).thenReturn(999L);
        Mockito.when(premi.getBasic()).thenReturn(BigDecimal.valueOf(123456));

        try (MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<PremiLocalServiceUtil> premiMock =
                     Mockito.mockStatic(PremiLocalServiceUtil.class);
             MockedStatic<BenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(BenefitLocalServiceUtil.class);
        	 MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
           			 Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {

        	ProductConfiguration mockConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);
        	
            planMock.when(SmartTravelIntPlanLocalServiceUtil::getActivePlan).thenReturn(Arrays.asList(plan));
            premiMock.when(() ->
                    PremiLocalServiceUtil.findByCurrencyAndTravellerType("idr", "individual"))
                    .thenReturn(Arrays.asList(premi));

            benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(999L))
                    .thenThrow(new RuntimeException("Service down"));

            String result = invokeGenerateLowerPremiPrice();
            assertEquals("", result);
        }
    }

    @Test
    void testGenerateLowerPremiPrice_benefitTypeServiceThrowsException() throws Exception {
        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getSmartTravelIntPlanId()).thenReturn(1L);
        Mockito.when(plan.getNameId()).thenReturn("Plan Y");

        Premi premi = Mockito.mock(Premi.class);
        Mockito.when(premi.getPlanId()).thenReturn(1L);
        Mockito.when(premi.getBenefitId()).thenReturn(100L);
        Mockito.when(premi.getBasic()).thenReturn(BigDecimal.valueOf(99999));

        Benefit benefit = Mockito.mock(Benefit.class);
        Mockito.when(benefit.getBenefitTypeId()).thenReturn(10L);

        try (MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<PremiLocalServiceUtil> premiMock =
                     Mockito.mockStatic(PremiLocalServiceUtil.class);
             MockedStatic<BenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(BenefitLocalServiceUtil.class);
             MockedStatic<BenefitTypeLocalServiceUtil> btMock =
                     Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
        	 MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
        			 Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
        	
        	ProductConfiguration mockConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

            planMock.when(SmartTravelIntPlanLocalServiceUtil::getActivePlan).thenReturn(Arrays.asList(plan));
            premiMock.when(() ->
                    PremiLocalServiceUtil.findByCurrencyAndTravellerType("idr", "individual"))
                    .thenReturn(Arrays.asList(premi));

            benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(100L)).thenReturn(benefit);
            btMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(10L))
                    .thenThrow(new RuntimeException("DB timeout"));

            String result = invokeGenerateLowerPremiPrice();
            assertEquals("", result);
        }
    }

    @Test
    void testGenerateLowerPremiPrice_planWithoutPremis() throws Exception {
        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getSmartTravelIntPlanId()).thenReturn(1L);
        Mockito.when(plan.getNameId()).thenReturn("Plan Empty");

        try (MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<PremiLocalServiceUtil> premiMock =
                     Mockito.mockStatic(PremiLocalServiceUtil.class)) {

            planMock.when(SmartTravelIntPlanLocalServiceUtil::getActivePlan).thenReturn(Arrays.asList(plan));
            premiMock.when(() ->
                    PremiLocalServiceUtil.findByCurrencyAndTravellerType("idr", "individual"))
                    .thenReturn(Collections.emptyList());

            String result = invokeGenerateLowerPremiPrice();
            assertEquals("", result);
        }
    }

    @Test
    void testGenerateLowerPremiPrice_noPremiMatchPlanId() throws Exception {
        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getSmartTravelIntPlanId()).thenReturn(1L);
        Mockito.when(plan.getNameId()).thenReturn("Plan Z");

        Premi premi = Mockito.mock(Premi.class);
        Mockito.when(premi.getPlanId()).thenReturn(99L); // beda ID
        Mockito.when(premi.getBenefitId()).thenReturn(100L);
        Mockito.when(premi.getBasic()).thenReturn(BigDecimal.valueOf(55555));

        Benefit benefit = Mockito.mock(Benefit.class);
        Mockito.when(benefit.getBenefitTypeId()).thenReturn(10L);

        BenefitType bt = Mockito.mock(BenefitType.class);
        Mockito.when(bt.getNameId()).thenReturn("Jaminan Utama");

        try (MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<PremiLocalServiceUtil> premiMock =
                     Mockito.mockStatic(PremiLocalServiceUtil.class);
             MockedStatic<BenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(BenefitLocalServiceUtil.class);
             MockedStatic<BenefitTypeLocalServiceUtil> btMock =
                     Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
    		 MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
              			 Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {

           	ProductConfiguration mockConfig = mockProductConfig();
               productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6")).thenReturn(mockConfig);

            planMock.when(SmartTravelIntPlanLocalServiceUtil::getActivePlan).thenReturn(Arrays.asList(plan));
            premiMock.when(() ->
                    PremiLocalServiceUtil.findByCurrencyAndTravellerType("idr", "individual"))
                    .thenReturn(Arrays.asList(premi));

            benefitMock.when(() -> BenefitLocalServiceUtil.getBenefit(100L)).thenReturn(benefit);
            btMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(10L)).thenReturn(bt);

            String result = invokeGenerateLowerPremiPrice();
            assertEquals("", result);
        }
    }
}
