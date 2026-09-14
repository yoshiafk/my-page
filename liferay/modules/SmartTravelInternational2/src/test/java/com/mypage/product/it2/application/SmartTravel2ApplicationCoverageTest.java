package com.mypage.product.it2.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.mypage.admin.product.model.BenefitType;
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
import com.mypage.agencyportal.model.AgentTokenLimiter;
import com.mypage.agencyportal.service.AgentTokenLimiterLocalServiceUtil;
import com.mypage.leads.model.Customer;
import com.mypage.leads.model.DetailInternationalTravel;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.CustomerLocalService;
import com.mypage.leads.service.CustomerLocalServiceUtil;
import com.mypage.leads.service.DetailInternationalTravelLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalServiceUtil;
import com.mypage.product.it2.constants.SmartTravel2ApplicationKeys;
import com.mypage.product.it2.helper.EncryptionHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Variant;
import javax.ws.rs.core.Variant.VariantListBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class SmartTravel2ApplicationCoverageTest {
    private static final AtomicBoolean URL_FACTORY_SET = new AtomicBoolean(false);
    private static final Map<String, MockResponse> URL_RESPONSES = new ConcurrentHashMap<>();

    @Test
    void comparePlan_success() throws Exception {
        BenefitType benefitType = Mockito.mock(BenefitType.class);
        Mockito.when(benefitType.getSort()).thenReturn(1);
        Mockito.when(benefitType.getNameId()).thenReturn("Main");
        Mockito.when(benefitType.getNameEn()).thenReturn("Main");
        Mockito.when(benefitType.getBenefitTypeId()).thenReturn(10L);

        StiBenefit benefit = Mockito.mock(StiBenefit.class);
        Mockito.when(benefit.getBenefitId()).thenReturn(11L);
        Mockito.when(benefit.getNameId()).thenReturn("Benefit");
        Mockito.when(benefit.getBenefitDescription()).thenReturn("Desc");

        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getSmartTravelIntPlanId()).thenReturn(100L);
        Mockito.when(plan.getNameId()).thenReturn("PLAN_A");

        StiBenefitValueMapping mapping = Mockito.mock(StiBenefitValueMapping.class);
        Mockito.when(mapping.getBenefitValue()).thenReturn("100");
        Mockito.when(mapping.getBenefitValueUSD()).thenReturn("10");

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
             MockedStatic<BenefitTypeLocalServiceUtil> btMock =
                     Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
             MockedStatic<StiBenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(StiBenefitLocalServiceUtil.class);
             MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<StiBenefitValueMappingLocalServiceUtil> mappingMock =
                     Mockito.mockStatic(StiBenefitValueMappingLocalServiceUtil.class)) {

            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(() -> JSONFactoryUtil.createJSONArray(Mockito.anyCollection()))
                    .thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>(inv.getArgument(0))));
            ProductConfiguration productConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(productConfig);

            btMock.when(BenefitTypeLocalServiceUtil::getActiveBenefitType)
                  .thenReturn(Arrays.asList(benefitType));
            benefitMock.when(() -> StiBenefitLocalServiceUtil.getBenefitByTypeId(10L))
                       .thenReturn(Arrays.asList(benefit));
            planMock.when(SmartTravelIntPlanLocalServiceUtil::getActivePlan)
                    .thenReturn(Arrays.asList(plan));
            mappingMock.when(() -> StiBenefitValueMappingLocalServiceUtil
                    .getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(10L, 11L, 100L))
                       .thenReturn(mapping);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.comparePlan("{}", null);
            assertTrue(result.contains("\"Status\":1"));
        }
    }

    @Test
    void additionalBenefit_success() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("Plan", "PLAN_A");

        BenefitType main = Mockito.mock(BenefitType.class);
        Mockito.when(main.getNameId()).thenReturn("Jaminan Utama");
        Mockito.when(main.getBenefitTypeId()).thenReturn(1L);

        BenefitType additional = Mockito.mock(BenefitType.class);
        Mockito.when(additional.getNameId()).thenReturn("Tambahan");
        Mockito.when(additional.getBenefitTypeId()).thenReturn(2L);

        StiBenefitValueMapping mapping = Mockito.mock(StiBenefitValueMapping.class);
        Mockito.when(mapping.getPlanId()).thenReturn(100L);
        Mockito.when(mapping.getBenefitId()).thenReturn(200L);
        Mockito.when(mapping.getBenefitValue()).thenReturn("1000");
        Mockito.when(mapping.getBenefitValueUSD()).thenReturn("10");

        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getNameId()).thenReturn("PLAN_A");

        StiBenefit benefit = Mockito.mock(StiBenefit.class);
        Mockito.when(benefit.getActive()).thenReturn(1);
        Mockito.when(benefit.getSort()).thenReturn(1);
        Mockito.when(benefit.getNameId()).thenReturn("Add");
        Mockito.when(benefit.getBenefitId()).thenReturn(200L);
        Mockito.when(benefit.getBenefitDescription()).thenReturn("Desc");

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
             MockedStatic<BenefitTypeLocalServiceUtil> btMock =
                     Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
             MockedStatic<StiBenefitValueMappingLocalServiceUtil> mappingMock =
                     Mockito.mockStatic(StiBenefitValueMappingLocalServiceUtil.class);
             MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<StiBenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(StiBenefitLocalServiceUtil.class)) {

            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(() -> JSONFactoryUtil.createJSONArray(Mockito.anyCollection()))
                    .thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>(inv.getArgument(0))));
            ProductConfiguration productConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(productConfig);

            btMock.when(BenefitTypeLocalServiceUtil::getActiveBenefitType)
                  .thenReturn(Arrays.asList(main, additional));
            mappingMock.when(() -> StiBenefitValueMappingLocalServiceUtil
                    .getAllBenefitValueMappingByBenefitType(2L))
                       .thenReturn(Arrays.asList(mapping));
            planMock.when(() -> SmartTravelIntPlanLocalServiceUtil.fetchSmartTravelIntPlan(100L))
                    .thenReturn(plan);
            benefitMock.when(() -> StiBenefitLocalServiceUtil.fetchStiBenefit(200L))
                       .thenReturn(benefit);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.additionalBenefit("{}", null);
            assertTrue(result.contains("\"Status\":1"));
        }
    }

    @Test
    void processOCR_success() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("dataCategory", "ocr");
        params.put("_fotoBase64", "data:image/jpeg;base64,AA==");
        params.put("_fileName", "test.jpg");

        Response.ResponseBuilder okBuilder = Mockito.mock(Response.ResponseBuilder.class);
        Response.ResponseBuilder statusBuilder = Mockito.mock(Response.ResponseBuilder.class);
        Response okResponse = Mockito.mock(Response.class);
        Mockito.when(okResponse.getStatus()).thenReturn(200);
        Mockito.when(okBuilder.type(Mockito.anyString())).thenReturn(okBuilder);
        Mockito.when(okBuilder.entity(Mockito.any())).thenReturn(okBuilder);
        Mockito.when(okBuilder.build()).thenReturn(okResponse);
        Mockito.when(statusBuilder.entity(Mockito.any())).thenReturn(statusBuilder);
        Mockito.when(statusBuilder.build()).thenReturn(okResponse);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<Response> responseMock = Mockito.mockStatic(Response.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            ProductConfiguration productConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(productConfig);

            responseMock.when(() -> Response.ok(Mockito.any())).thenReturn(okBuilder);
            responseMock.when(() -> Response.status(Mockito.any(Response.Status.class))).thenReturn(statusBuilder);

            SmartTravel2Application app = Mockito.spy(new SmartTravel2Application());
            Mockito.doReturn(java.io.File.createTempFile("ocr", ".jpg"))
                   .when(app).decodeBase64ToFile(Mockito.anyString(), Mockito.anyString());
            Mockito.doReturn("{\"read\":{},\"status\":\"SUCCESS\"}")
                   .when(app).hitApiOCR(Mockito.anyString(), Mockito.any(), Mockito.anyString(), Mockito.anyString(),
                           Mockito.anyString());
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString()))
                    .thenAnswer(inv -> {
                        String arg = inv.getArgument(0);
                        return arg.contains("SUCCESS") ? JsonStubs.newJsonObject() : params;
                    });
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());

        }
    }

    @Test
    void fetchCountries_success() throws Exception {
        installMockUrlFactory();
        registerMockUrl("mock://countries", 200, "{\"Status\":1}");

        JSONObject apiResponse = JsonStubs.newJsonObject();
        apiResponse.put("Status", 1);
        JSONArray data = JsonStubs.newJsonArray(new ArrayList<>());
        JSONObject country = JsonStubs.newJsonObject();
        country.put("Id", 7L);
        country.put("Name", "Japan");
        data.put(country);
        apiResponse.put("Data", data);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {
            ProductConfiguration productConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(productConfig);
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(apiResponse);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(JSONFactoryUtil::createJSONArray).thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>()));

            SmartTravel2Application app = new SmartTravel2Application();
            setField(app, "finalApiLRCountries", "mock://countries");

            String result = app.fetchCountries(Mockito.mock(HttpServletRequest.class));
            assertTrue(result.contains("\"status\":1"));
        }
    }

    @Test
    void getImage_success() throws Exception {
        FileEntry fileEntry = Mockito.mock(FileEntry.class);
        FileVersion fileVersion = Mockito.mock(FileVersion.class);
        InputStream stream = new ByteArrayInputStream("img".getBytes());

        Mockito.when(fileEntry.getFileVersion()).thenReturn(fileVersion);
        Mockito.when(fileVersion.getContentStream(true)).thenReturn(stream);
        Mockito.when(fileEntry.getMimeType()).thenReturn("image/png");

        Response.ResponseBuilder okBuilder = Mockito.mock(Response.ResponseBuilder.class);
        Response.ResponseBuilder statusBuilder = Mockito.mock(Response.ResponseBuilder.class);
        Response okResponse = Mockito.mock(Response.class);
        Mockito.when(okResponse.getStatus()).thenReturn(200);
        Mockito.when(okBuilder.type(Mockito.anyString())).thenReturn(okBuilder);
        Mockito.when(okBuilder.entity(Mockito.any())).thenReturn(okBuilder);
        Mockito.when(okBuilder.build()).thenReturn(okResponse);
        Mockito.when(statusBuilder.entity(Mockito.any())).thenReturn(statusBuilder);
        Mockito.when(statusBuilder.build()).thenReturn(okResponse);

        try (MockedStatic<Response> responseMock = Mockito.mockStatic(Response.class);
             MockedStatic<EncryptionHelper> encMock = Mockito.mockStatic(EncryptionHelper.class);
             MockedStatic<DLAppLocalServiceUtil> appMock =
                     Mockito.mockStatic(DLAppLocalServiceUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class)) {

            ProductConfiguration productConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(productConfig);
            responseMock.when(() -> Response.ok(Mockito.any())).thenReturn(okBuilder);
            responseMock.when(() -> Response.status(Mockito.any(Response.Status.class))).thenReturn(statusBuilder);

            encMock.when(() -> EncryptionHelper.decrypt("token")).thenReturn("123");
            appMock.when(() -> DLAppLocalServiceUtil.getFileEntry(123L)).thenReturn(fileEntry);

            SmartTravel2Application app = new SmartTravel2Application();
            Response response = app.getImage("token");
            assertEquals(200, response.getStatus());
        }
    }

    @Test
    void hitAPI_success() throws Exception {
        installMockUrlFactory();
        registerMockUrl("mock://hit", 200, "{\"Status\":1}");

        JSONObject body = JsonStubs.newJsonObject();
        body.put("Status", 1);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class)) {
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(body);

            JSONObject result = SmartTravel2Application.hitAPI("mock://hit", "{\"a\":1}");
            assertEquals(200, result.get("httpStatusCode"));
        }
    }

    @Test
    void callAPI_success() throws Exception {
        installMockUrlFactory();
        registerMockUrl("mock://call", 200, "{\"Status\":1}");

        JSONObject body = JsonStubs.newJsonObject();
        body.put("Status", 1);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class)) {
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(body);
            JSONObject result = SmartTravel2Application.callAPI("{}", "mock://call");
            assertNotNull(result);
        }
    }

    @Test
    void installMockUrlFactory_is_idempotent_and_allows_calls() throws Exception {
        // verify factory installation and repeated calls do not break mock handling
        installMockUrlFactory();
        registerMockUrl("mock://ping", 200, "{\"Status\":1}");

        JSONObject body = JsonStubs.newJsonObject();
        body.put("Status", 1);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class)) {
            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(body);

            // first call should work
            JSONObject first = SmartTravel2Application.callAPI("{}", "mock://ping");
            assertNotNull(first);

            // second attempt to install factory must not break existing handler
            installMockUrlFactory();

            JSONObject second = SmartTravel2Application.callAPI("{}", "mock://ping");
            assertNotNull(second);
        }
    }

    @Test
    void manageFile_success() throws Exception {
        try (MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
             MockedStatic<ServiceContextFactory> scMock = Mockito.mockStatic(ServiceContextFactory.class);
             MockedStatic<MimeTypesUtil> mimeMock = Mockito.mockStatic(MimeTypesUtil.class);
             MockedStatic<com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil> folderMock =
                     Mockito.mockStatic(com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil.class);
             MockedStatic<DLAppLocalServiceUtil> appMock = Mockito.mockStatic(DLAppLocalServiceUtil.class);
             MockedStatic<com.liferay.portal.kernel.service.RoleLocalServiceUtil> roleMock =
                     Mockito.mockStatic(com.liferay.portal.kernel.service.RoleLocalServiceUtil.class);
             MockedStatic<com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil> permMock =
                     Mockito.mockStatic(com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil.class)) {

            ProductConfiguration productConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(productConfig);

            SmartTravel2Application app = Mockito.spy(new SmartTravel2Application());
            java.io.File temp = java.io.File.createTempFile("sti", ".png");
            Mockito.doReturn(temp).when(app).decodeBase64ToFile(Mockito.anyString(), Mockito.anyString());

            com.liferay.upload.UniqueFileNameProvider nameProvider =
                    Mockito.mock(com.liferay.upload.UniqueFileNameProvider.class);
            Mockito.when(nameProvider.provide(Mockito.anyString(), Mockito.any())).thenAnswer(inv -> inv.getArgument(0));
            setField(app, "_uniqueFileNameProvider", nameProvider);

            ServiceContext sc = Mockito.mock(ServiceContext.class);
            Mockito.when(sc.getScopeGroupId()).thenReturn(1L);
            Mockito.when(sc.getGuestOrUserId()).thenReturn(2L);
            Mockito.when(sc.getCompanyId()).thenReturn(3L);

            com.liferay.document.library.kernel.model.DLFolder folder =
                    Mockito.mock(com.liferay.document.library.kernel.model.DLFolder.class);
            Mockito.when(folder.getFolderId()).thenReturn(4L);
            Mockito.when(folder.getPrimaryKey()).thenReturn(4L);

            FileEntry fileEntry = Mockito.mock(FileEntry.class);
            Mockito.when(fileEntry.getFileEntryId()).thenReturn(123L);
            Mockito.when(fileEntry.getGroupId()).thenReturn(1L);
            Mockito.when(fileEntry.getFolderId()).thenReturn(4L);
            Mockito.when(fileEntry.getFileName()).thenReturn("file.png");

            com.liferay.portal.kernel.model.Role role =
                    Mockito.mock(com.liferay.portal.kernel.model.Role.class);
            Mockito.when(role.getRoleId()).thenReturn(5L);

            scMock.when(() -> ServiceContextFactory.getInstance(Mockito.anyString(), Mockito.any(HttpServletRequest.class)))
                  .thenReturn(sc);
            mimeMock.when(() -> MimeTypesUtil.getExtensions("image/png"))
                    .thenReturn(new HashSet<>(Arrays.asList(".png")));
            folderMock.when(() -> com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil
                    .fetchFolder(1L, 0L, "Folder")).thenReturn(null);
            folderMock.when(() -> com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil
                    .addFolder(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyBoolean(),
                            Mockito.anyLong(), Mockito.anyString(), Mockito.anyString(), Mockito.anyBoolean(),
                            Mockito.any(ServiceContext.class)))
                      .thenReturn(folder);
            appMock.when(() -> DLAppLocalServiceUtil
                    .addFileEntry(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString(),
                            Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                            Mockito.any(java.io.File.class), Mockito.any(ServiceContext.class)))
                   .thenReturn(fileEntry);
            roleMock.when(() -> com.liferay.portal.kernel.service.RoleLocalServiceUtil
                    .fetchRole(3L, com.liferay.portal.kernel.model.role.RoleConstants.GUEST))
                    .thenReturn(role);

            Method manageFile = SmartTravel2Application.class.getDeclaredMethod(
                    "manageFile", String.class, String.class, String.class, HttpServletRequest.class);
            manageFile.setAccessible(true);
            @SuppressWarnings("unchecked")
            List<String> result = (List<String>) manageFile.invoke(app,
                    "data:image/png;base64,AA==", "img", "Folder", Mockito.mock(HttpServletRequest.class));

            assertTrue(result.get(1).contains("/documents/"));
        }
    }

    @Test
    void updateLeadsAndCustomers_success() throws Exception {
        JSONObject policyholder = JsonStubs.newJsonObject();
        policyholder.put("_fotoktp", "");
        policyholder.put("_dob", "01/Jan/2024");
        policyholder.put("_name", "Alice");
        policyholder.put("_email", "alice@example.com");
        policyholder.put("_hp", "081");
        policyholder.put("_gender", "F");
        policyholder.put("_pdob", "Jakarta");
        policyholder.put("_negara", "indonesia");
        policyholder.put("_ktpkitas", "ID123");
        policyholder.put("_ktppaspor", "P123");
        policyholder.put("_alamat", "Street");
        policyholder.put("_kodepos", "12345");
        policyholder.put("_ispep", "0");
        policyholder.put("_kodenegara", "ID");
        policyholder.put("_job", "Dev");
        policyholder.put("_otherjob", "");
        policyholder.put("_age", 30);
        policyholder.put("_statuskawin", "Single");
        policyholder.put("_telepon", "021");

        JSONObject insured = JsonStubs.newJsonObject();
        insured.put("_fotoktp", "");
        insured.put("_dob", "02/Jan/2024");
        insured.put("_name", "Bob");
        insured.put("_email", "bob@example.com");
        insured.put("_hp", "081");
        insured.put("_gender", "M");
        insured.put("_pdob", "Bandung");
        insured.put("_negara", "indonesia");
        insured.put("_ktpkitas", "ID456");
        insured.put("_ktppaspor", "P456");
        insured.put("_alamat", "Street 2");
        insured.put("_kodepos", "67890");
        insured.put("_relationship", "Tertanggung Utama");
        insured.put("_ispep", "0");
        insured.put("_kodenegara", "ID");
        insured.put("_job", "Dev");
        insured.put("_otherjob", "");
        insured.put("_age", 25);
        insured.put("_statuskawin", "Single");
        insured.put("_telepon", "022");

        JSONArray insuredList = JsonStubs.newJsonArray(new ArrayList<>());
        insuredList.put(insured);

        JSONObject paramSanitized = JsonStubs.newJsonObject();
        paramSanitized.put("policyholder", policyholder);
        paramSanitized.put("insured", insuredList);
        paramSanitized.put("insuredIsPolis", true);

        Leads leads = Mockito.mock(Leads.class);
        Mockito.when(leads.getLeadsId()).thenReturn(10L);

        ServiceContext sc = Mockito.mock(ServiceContext.class);
        Mockito.when(sc.getGuestOrUserId()).thenReturn(2L);
        Mockito.when(sc.getCompanyId()).thenReturn(3L);

        CustomerLocalService customerService = Mockito.mock(CustomerLocalService.class);
        Mockito.when(customerService.findByLeadsId(10L)).thenReturn(Collections.emptyList());

        try (MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
             MockedStatic<ServiceContextFactory> scMock = Mockito.mockStatic(ServiceContextFactory.class);
             MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<LeadsLocalServiceUtil> leadsMock =
                     Mockito.mockStatic(LeadsLocalServiceUtil.class);
             MockedStatic<CustomerLocalServiceUtil> customerMock =
                     Mockito.mockStatic(CustomerLocalServiceUtil.class)) {

            ProductConfiguration productConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(productConfig);

            SmartTravel2Application app = new SmartTravel2Application();
            setField(app, "customerLocalService", customerService);

            scMock.when(() -> ServiceContextFactory.getInstance(Mockito.anyString(), Mockito.any(HttpServletRequest.class)))
                  .thenReturn(sc);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(JSONFactoryUtil::createJSONArray).thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>()));

            leadsMock.when(() -> LeadsLocalServiceUtil.findByToken("token")).thenReturn(leads);
            leadsMock.when(() -> LeadsLocalServiceUtil.updateLeads(Mockito.anyLong(), Mockito.anyLong(),
                    Mockito.any(JSONObject.class), Mockito.any(ServiceContext.class)))
                     .thenReturn(leads);
            customerMock.when(() -> CustomerLocalServiceUtil
                    .removeCustomerByLeadsIdAndProductCode(Mockito.anyLong(), Mockito.anyString()))
                        .thenAnswer(inv -> null);
            customerMock.when(() -> CustomerLocalServiceUtil
                    .addCustomer(Mockito.anyLong(), Mockito.anyLong(), Mockito.any(JSONObject.class),
                            Mockito.any(ServiceContext.class)))
                        .thenAnswer(inv -> null);

            Method update = SmartTravel2Application.class.getDeclaredMethod(
                    "updateLeadsAndCustomers", JSONObject.class, String.class, HttpServletRequest.class);
            update.setAccessible(true);

            update.invoke(app, paramSanitized, "token", Mockito.mock(HttpServletRequest.class));
        }
    }

    @Test
    void process_payment_success() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put("Token", "tok");
        params.put("type", "payment");
        params.put("QuouteId", "Q1");
        params.put("utmSource", "google");
        params.put("mbid", "MB1");
        params.put("AdditionalBenefit", JsonStubs.newJsonArray(Arrays.asList(1)));

        Leads leads = mockLeads();

        DetailInternationalTravel detail = Mockito.mock(DetailInternationalTravel.class);
        Mockito.when(detail.getLeadsId()).thenReturn(99L);
        Mockito.when(detail.getDestination()).thenReturn("World");
        Mockito.when(detail.getDepartureDate()).thenReturn(java.sql.Date.valueOf(LocalDate.of(2024, 1, 1)));
        Mockito.when(detail.getArrivalDate()).thenReturn(java.sql.Date.valueOf(LocalDate.of(2024, 1, 2)));
        Mockito.when(detail.getTravelType()).thenReturn("single");
        Mockito.when(detail.getPackageType()).thenReturn("PLAN_A");
        Mockito.when(detail.getTravellerType()).thenReturn("Family");
        Mockito.when(detail.getAdult()).thenReturn(1);
        Mockito.when(detail.getChild()).thenReturn(1);

        Customer adult = mockCustomer("Tertanggung Utama");
        Customer child = mockCustomer("Anak");

        CustomerLocalService customerService = Mockito.mock(CustomerLocalService.class);
        Mockito.when(customerService.findByLeadsId(99L)).thenReturn(Arrays.asList(adult, child));

        JSONObject responseData = JsonStubs.newJsonObject();
        responseData.put("Status", 1);
        JSONObject tokenObj = JsonStubs.newJsonObject();
        tokenObj.put("Token", "PAY123");
        responseData.put("Data", tokenObj);

        JSONObject responsePimcore = JsonStubs.newJsonObject();
        responsePimcore.put("httpStatusCode", 200);
        responsePimcore.put("data", responseData);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
             MockedStatic<PortalUtil> portalMock = Mockito.mockStatic(PortalUtil.class);
             MockedStatic<LeadsLocalServiceUtil> leadsMock =
                     Mockito.mockStatic(LeadsLocalServiceUtil.class);
             MockedStatic<DetailInternationalTravelLocalServiceUtil> detailMock =
                     Mockito.mockStatic(DetailInternationalTravelLocalServiceUtil.class);
             MockedStatic<StiBenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(StiBenefitLocalServiceUtil.class);
             MockedStatic<SmartTravel2Application> appMock =
                     Mockito.mockStatic(SmartTravel2Application.class, Mockito.CALLS_REAL_METHODS)) {

            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(JSONFactoryUtil::createJSONArray).thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>()));
            ProductConfiguration productConfig = mockProductConfig();
            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(productConfig);

            portalMock.when(() -> PortalUtil.getPortalURL(Mockito.any(HttpServletRequest.class)))
                      .thenReturn("http://host");
            leadsMock.when(() -> LeadsLocalServiceUtil.findByToken("tok")).thenReturn(leads);
            detailMock.when(() -> DetailInternationalTravelLocalServiceUtil.findByLeadsId(99L)).thenReturn(detail);

            StiBenefit benefit = Mockito.mock(StiBenefit.class);
            Mockito.when(benefit.getExternalCode()).thenReturn("BEN-1");
            benefitMock.when(() -> StiBenefitLocalServiceUtil.fetchStiBenefit(1)).thenReturn(benefit);

            appMock.when(() -> SmartTravel2Application.hitAPI(Mockito.anyString(), Mockito.anyString()))
                   .thenReturn(responsePimcore);

            SmartTravel2Application app = new SmartTravel2Application();
            setField(app, "customerLocalService", customerService);

            String result = app.process("{}", Mockito.mock(HttpServletRequest.class));
            assertTrue(result.contains("\"Status\":1"));
        }
    }

    @Test
    void purchaseDetail_nonQuotation_success() throws Exception {
        JSONObject params = JsonStubs.newJsonObject();
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_QUOTATION, "0");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_CURRENCY, "idr");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_DEPARTUREDATE, "01/Jan/2024");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_ARRIVALDATE, "02/Jan/2024");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_TRAVELTYPE, "single");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_TRAVELLERTYPE, "individual");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_CHOOSENPLAN, "PLAN_A");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_MANAGEDBY, "");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_MANAGEDBYID, "");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_ROLE, "");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_BUSINESSMODEL, "b2c");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_NAME, "Alice");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_EMAIL, "alice@example.com");
        params.put(SmartTravel2ApplicationKeys.PARAM_PURCHASE_DETAIL_TOKEN, "");
        params.put("ModifyOrRepeatOrderStat", false);
        params.put("AdditionalBenefits", JsonStubs.newJsonArray(new ArrayList<>()));
        params.put("AdditionalBenefitCodes", JsonStubs.newJsonArray(new ArrayList<>()));
        params.put("Referrer", "");
        params.put("AdultTotal", 1);
        params.put("ChildTotal", 0);
        params.put("fp", 1);
        params.put("PromoCode", "");
        params.put("Currency", "usd");
        params.put("TravellerType", "individual");
        params.put("DepartureDate", "01/Jan/2024");
        params.put("ArrivalDate", "02/Jan/2024");
        params.put("TravelType", "single");
        params.put("SpesificPlan", "PLAN_A");
        params.put("Commission", 5.0);
        params.put("Tax", 2.0);
        params.put("PaymentMethod", "nett");
        params.put("Discount", 0.0);
        params.put("BusinessModel", "b2c");
        params.put("ManagedBy", "");
        params.put("ManagedById", "");
        params.put("Role", "");

        com.mypage.admin.product.model.MasterCurrency mc =
                Mockito.mock(com.mypage.admin.product.model.MasterCurrency.class);
        Mockito.when(mc.getAmount()).thenReturn(15000.0);

        SmartTravelIntPlan plan = Mockito.mock(SmartTravelIntPlan.class);
        Mockito.when(plan.getNameId()).thenReturn("PLAN_A");

        StiPremi premi = Mockito.mock(StiPremi.class);
        Mockito.when(premi.getPlanId()).thenReturn(1L);
        Mockito.when(premi.getBenefitId()).thenReturn(101L);
        Mockito.when(premi.getBasic()).thenReturn(new BigDecimal("100"));
        Mockito.when(premi.getAnnual()).thenReturn(new BigDecimal("10"));
        Mockito.when(premi.getAdditional()).thenReturn(new BigDecimal("5"));

        StiBenefit benefit = Mockito.mock(StiBenefit.class);
        Mockito.when(benefit.getBenefitId()).thenReturn(101L);
        Mockito.when(benefit.getBenefitTypeId()).thenReturn(201L);
        Mockito.when(benefit.getNameId()).thenReturn("Main");
        Mockito.when(benefit.getExternalCode()).thenReturn("BEN-1");

        BenefitType benefitType = Mockito.mock(BenefitType.class);
        Mockito.when(benefitType.getNameId()).thenReturn("Jaminan Utama");
        Mockito.when(benefitType.getNameEn()).thenReturn("Main Benefit");
        Mockito.when(benefitType.getBenefitTypeId()).thenReturn(201L);

        StiBenefitValueMapping mapping = Mockito.mock(StiBenefitValueMapping.class);
        Mockito.when(mapping.getBenefitValue()).thenReturn("100");
        Mockito.when(mapping.getBenefitValueUSD()).thenReturn("10");

        ProductConfiguration config = Mockito.mock(ProductConfiguration.class);
        Mockito.when(config.getPolicyCostIDR()).thenReturn(1000.0);
        Mockito.when(config.getPolicyCostUSD()).thenReturn(10.0);
        Mockito.when(config.getStampdutyIDR()).thenReturn(500.0);
        Mockito.when(config.getStampdutyUSD()).thenReturn(1.0);
        Mockito.when(config.getProductCode()).thenReturn("IT6");

        Leads leads = mockLeads();
        Mockito.when(leads.getToken()).thenReturn("TOK1");

        DetailInternationalTravel detail = Mockito.mock(DetailInternationalTravel.class);

        ServiceContext sc = Mockito.mock(ServiceContext.class);
        Mockito.when(sc.getGuestOrUserId()).thenReturn(2L);

        try (MockedStatic<JSONFactoryUtil> jsonMock = Mockito.mockStatic(JSONFactoryUtil.class);
             MockedStatic<ProductConfigurationLocalServiceUtil> productMock =
                     Mockito.mockStatic(ProductConfigurationLocalServiceUtil.class);
             MockedStatic<MasterCurrencyLocalServiceUtil> currencyMock =
                     Mockito.mockStatic(MasterCurrencyLocalServiceUtil.class);
             MockedStatic<StiPremiLocalServiceUtil> premiMock =
                     Mockito.mockStatic(StiPremiLocalServiceUtil.class);
             MockedStatic<SmartTravelIntPlanLocalServiceUtil> planMock =
                     Mockito.mockStatic(SmartTravelIntPlanLocalServiceUtil.class);
             MockedStatic<StiBenefitLocalServiceUtil> benefitMock =
                     Mockito.mockStatic(StiBenefitLocalServiceUtil.class);
             MockedStatic<BenefitTypeLocalServiceUtil> benefitTypeMock =
                     Mockito.mockStatic(BenefitTypeLocalServiceUtil.class);
             MockedStatic<StiBenefitValueMappingLocalServiceUtil> mappingMock =
                     Mockito.mockStatic(StiBenefitValueMappingLocalServiceUtil.class);
             MockedStatic<ServiceContextFactory> scMock =
                     Mockito.mockStatic(ServiceContextFactory.class);
             MockedStatic<LeadsLocalServiceUtil> leadsMock =
                     Mockito.mockStatic(LeadsLocalServiceUtil.class);
             MockedStatic<DetailInternationalTravelLocalServiceUtil> detailMock =
                     Mockito.mockStatic(DetailInternationalTravelLocalServiceUtil.class)) {

            jsonMock.when(() -> JSONFactoryUtil.createJSONObject(Mockito.anyString())).thenReturn(params);
            jsonMock.when(JSONFactoryUtil::createJSONObject).thenAnswer(inv -> JsonStubs.newJsonObject());
            jsonMock.when(JSONFactoryUtil::createJSONArray).thenAnswer(inv -> JsonStubs.newJsonArray(new ArrayList<>()));

            productMock.when(() -> ProductConfigurationLocalServiceUtil.getConfigByCode("IT6"))
                       .thenReturn(config);
            currencyMock.when(() -> MasterCurrencyLocalServiceUtil.searchCurrency(Mockito.anyString()))
                        .thenReturn(mc);
            planMock.when(() -> SmartTravelIntPlanLocalServiceUtil.getSmartTravelIntPlan(Mockito.anyLong()))
                    .thenReturn(plan);
            premiMock.when(() -> StiPremiLocalServiceUtil.findByCurrencyAndTravellerType(Mockito.anyString(), Mockito.anyString()))
                     .thenReturn(Arrays.asList(premi));
            benefitMock.when(() -> StiBenefitLocalServiceUtil.getStiBenefit(101L)).thenReturn(benefit);
            benefitTypeMock.when(() -> BenefitTypeLocalServiceUtil.getBenefitType(201L)).thenReturn(benefitType);
            mappingMock.when(() -> StiBenefitValueMappingLocalServiceUtil
                    .getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong()))
                       .thenReturn(mapping);
            scMock.when(() -> ServiceContextFactory.getInstance(Mockito.anyString(), Mockito.any(HttpServletRequest.class)))
                  .thenReturn(sc);
            leadsMock.when(() -> LeadsLocalServiceUtil.updateLeads(Mockito.anyLong(), Mockito.anyLong(),
                    Mockito.any(JSONObject.class), Mockito.any(ServiceContext.class)))
                     .thenReturn(leads);
            detailMock.when(() -> DetailInternationalTravelLocalServiceUtil
                    .addDetail(Mockito.anyLong(), Mockito.anyLong(), Mockito.any(JSONObject.class),
                            Mockito.any(ServiceContext.class)))
                      .thenReturn(detail);

            SmartTravel2Application app = new SmartTravel2Application();
            String result = app.purchaseDetail("{}", Mockito.mock(HttpServletRequest.class));
            assertTrue(result.contains("\"Status\":1"));
        }
    }

    private static ProductConfiguration mockProductConfig() {
        ProductConfiguration config = Mockito.mock(ProductConfiguration.class);
        Mockito.when(config.getProductCode()).thenReturn("IT6");
        Mockito.when(config.getPolicyCostIDR()).thenReturn(1000.0);
        Mockito.when(config.getPolicyCostUSD()).thenReturn(10.0);
        Mockito.when(config.getStampdutyIDR()).thenReturn(500.0);
        Mockito.when(config.getStampdutyUSD()).thenReturn(1.0);
        return config;
    }

    private static Leads mockLeads() {
        Leads leads = Mockito.mock(Leads.class);
        Mockito.when(leads.getLeadsId()).thenReturn(99L);
        Mockito.when(leads.getManagedBy()).thenReturn("MAN");
        Mockito.when(leads.getProductCode()).thenReturn("IT6");
        Mockito.when(leads.getChannel()).thenReturn("DIRECT");
        Mockito.when(leads.getCurrency()).thenReturn("idr");
        Mockito.when(leads.getStampDuty()).thenReturn(100.0);
        Mockito.when(leads.getPromoCode()).thenReturn("");
        Mockito.when(leads.getDiscount()).thenReturn(0.0);
        Mockito.when(leads.getDiscountAmount()).thenReturn(0.0);
        Mockito.when(leads.getPremium()).thenReturn(1000.0);
        Mockito.when(leads.getNetPremium()).thenReturn(900.0);
        Mockito.when(leads.getCommission()).thenReturn(0.0);
        Mockito.when(leads.getBussinesModel()).thenReturn("b2c");
        Mockito.when(leads.getCommercialOffers()).thenReturn(0);
        Mockito.when(leads.getIsPep()).thenReturn(0);
        Mockito.when(leads.getName()).thenReturn("Name");
        Mockito.when(leads.getGender()).thenReturn("M");
        Mockito.when(leads.getDob()).thenReturn(java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
        Mockito.when(leads.getAge()).thenReturn(30);
        Mockito.when(leads.getEmail()).thenReturn("a@b.com");
        Mockito.when(leads.getIdNumber()).thenReturn("123");
        Mockito.when(leads.getKitasNumber()).thenReturn("");
        Mockito.when(leads.getPassportNumber()).thenReturn("P1");
        Mockito.when(leads.getAddress()).thenReturn("addr");
        Mockito.when(leads.getZip()).thenReturn("12345");
        Mockito.when(leads.getMobilePhone()).thenReturn("081");
        Mockito.when(leads.getPhone()).thenReturn("081");
        Mockito.when(leads.getNationality()).thenReturn("Indonesia");
        Mockito.when(leads.getCountryCode()).thenReturn("ID");
        Mockito.when(leads.getMaritalStatus()).thenReturn("S");
        Mockito.when(leads.getJob()).thenReturn("Dev");
        Mockito.when(leads.getJobOther()).thenReturn("");
        Mockito.when(leads.getBirthPlace()).thenReturn("Jakarta");
        Mockito.when(leads.getPhotoFileUrl()).thenReturn("");
        return leads;
    }

    private static Customer mockCustomer(String relationship) {
        Customer customer = Mockito.mock(Customer.class);
        Mockito.when(customer.getRelationship()).thenReturn(relationship);
        Mockito.when(customer.getIsPep()).thenReturn(0);
        Mockito.when(customer.getName()).thenReturn("Cust");
        Mockito.when(customer.getGender()).thenReturn("M");
        Mockito.when(customer.getDob()).thenReturn(new Date());
        Mockito.when(customer.getAge()).thenReturn(20);
        Mockito.when(customer.getEmail()).thenReturn("cust@example.com");
        Mockito.when(customer.getNationality()).thenReturn("Indonesia");
        Mockito.when(customer.getIdNumber()).thenReturn("ID1");
        Mockito.when(customer.getKitasNumber()).thenReturn("");
        Mockito.when(customer.getPassportNumber()).thenReturn("P1");
        Mockito.when(customer.getAddress()).thenReturn("Addr");
        Mockito.when(customer.getZip()).thenReturn("11111");
        Mockito.when(customer.getMobilePhone()).thenReturn("081");
        Mockito.when(customer.getPhone()).thenReturn("021");
        Mockito.when(customer.getCountryCode()).thenReturn("ID");
        Mockito.when(customer.getMaritalStatus()).thenReturn("S");
        Mockito.when(customer.getJob()).thenReturn("Dev");
        Mockito.when(customer.getJobOther()).thenReturn("");
        Mockito.when(customer.getBirthPlace()).thenReturn("Jakarta");
        Mockito.when(customer.getPhotoFileUrl()).thenReturn("");
        return customer;
    }

    private static void setField(Object target, String name, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    private static void installMockUrlFactory() {
        // Ensure the factory is installed only when setURLStreamHandlerFactory succeeds.
        if (URL_FACTORY_SET.get()) {
            return;
        }

        synchronized (URL_FACTORY_SET) {
            if (URL_FACTORY_SET.get()) {
                return;
            }

            try {
                URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
                    @Override
                    public URLStreamHandler createURLStreamHandler(String protocol) {
                        if (!"mock".equals(protocol)) {
                            return null;
                        }
                        return new URLStreamHandler() {
                            @Override
                            protected URLConnection openConnection(URL url) {
                                MockResponse response = URL_RESPONSES.get(url.toString());
                                if (response == null) {
                                    response = new MockResponse(500, "{}");
                                }
                                return new MockHttpURLConnection(url, response);
                            }
                        };
                    }
                });

                // mark as installed only after successful registration
                URL_FACTORY_SET.set(true);
            } catch (Error ignored) {
                // Factory already set by another component — do NOT mark URL_FACTORY_SET so
                // subsequent calls may still attempt to install or verify handlers.
            }
        }
    }

    private static void registerMockUrl(String url, int responseCode, String body) {
        URL_RESPONSES.put(url, new MockResponse(responseCode, body));
    }

    private static class MockResponse {
        private final int responseCode;
        private final String body;

        MockResponse(int responseCode, String body) {
            this.responseCode = responseCode;
            this.body = body;
        }
    }

    private static class MockHttpURLConnection extends HttpURLConnection {
        private final MockResponse response;
        private final ByteArrayOutputStream output = new ByteArrayOutputStream();

        MockHttpURLConnection(URL url, MockResponse response) {
            super(url);
            this.response = response;
        }

        @Override
        public int getResponseCode() {
            return response.responseCode;
        }

        @Override
        public InputStream getInputStream() {
            return new ByteArrayInputStream(response.body.getBytes());
        }

        @Override
        public InputStream getErrorStream() {
            return new ByteArrayInputStream(response.body.getBytes());
        }

        @Override
        public OutputStream getOutputStream() {
            return output;
        }

        @Override
        public void disconnect() {
            // no-op
        }

        @Override
        public boolean usingProxy() {
            return false;
        }

        @Override
        public void connect() {
            // no-op
        }
    }

    private static class JsonStubs {
        static JSONObject newJsonObject() {
            return newJsonObject(new HashMap<>());
        }

        static JSONObject newJsonObject(Map<String, Object> seed) {
            Map<String, Object> store = new HashMap<>(seed);
            final JSONObject[] ref = new JSONObject[1];

            JSONObject obj = Mockito.mock(JSONObject.class, invocation -> {
                String name = invocation.getMethod().getName();
                Object[] args = invocation.getArguments();

                if ("put".equals(name)) {
                    store.put((String) args[0], args[1]);
                    return ref[0];
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
                if ("getLong".equals(name)) {
                    Object value = store.get(args[0]);
                    if (args.length == 2) {
                        return value == null ? args[1] : ((Number) value).longValue();
                    }
                    return ((Number) value).longValue();
                }
                if ("getDouble".equals(name)) {
                    Object value = store.get(args[0]);
                    if (args.length == 2) {
                        return value == null ? args[1] : ((Number) value).doubleValue();
                    }
                    return ((Number) value).doubleValue();
                }
                if ("getBoolean".equals(name)) {
                    Object value = store.get(args[0]);
                    if (args.length == 2) {
                        return value == null ? args[1] : (Boolean) value;
                    }
                    return value != null && (Boolean) value;
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
                if ("length".equals(name)) {
                    return store.size();
                }
                if ("remove".equals(name)) {
                    return store.remove(args[0]);
                }
                if ("toString".equals(name)) {
                    return toJson(store);
                }
                return null;
            });

            ref[0] = obj;
            return obj;
        }

        static JSONArray newJsonArray(List<Object> seed) {
            List<Object> items = new ArrayList<>(seed);
            final JSONArray[] ref = new JSONArray[1];

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
                if ("getLong".equals(name)) {
                    return ((Number) items.get((int) args[0])).longValue();
                }
                if ("getJSONObject".equals(name)) {
                    return items.get((int) args[0]);
                }
                if ("get".equals(name)) {
                    return items.get((int) args[0]);
                }
                if ("put".equals(name)) {
                    items.add(args[0]);
                    return ref[0];
                }
                if ("toString".equals(name)) {
                    return toJson(items);
                }
                return null;
            });

            ref[0] = array;
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
