package com.mypage.agencyportal.application.mobileapps;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.liferay.commerce.product.portlet.action.ActionHelper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.mypage.agencyportal.dto.BodyDto;
import com.mypage.agencyportal.dto.ClubYearDto;
import com.mypage.agencyportal.dto.GroupCobDto;
import com.mypage.agencyportal.dto.GroupTransactionDto;
import com.mypage.agencyportal.dto.PartyDetailsDto;
import com.mypage.agencyportal.dto.PolicyDto;
import com.mypage.agencyportal.dto.ProfileAgentDto;
import com.mypage.agencyportal.dto.ResponseDto;
import com.mypage.agencyportal.dto.TransactionCobDto;
import com.mypage.agencyportal.dto.TransactionDto;
import com.mypage.agencyportal.dto.TransactionReportDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.JsonResponseHelper;
import com.mypage.agencyportal.helpers.JwtAuthHelper;
import com.mypage.agencyportal.helpers.JwtKeyService;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;


@Component(
    property = {
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/m/scorecard",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=ScorecardAPI.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)

public class ScorecardAPI extends Application {
	private static String bodyOperation;
	private static String bodyService;
    private static String apiURL;
    private static String agencyBinderNo;
    private static String templateLocation = "/META-INF/resources/performancebooking/pdf/template.ftl";
	private static String cssLocation = "/META-INF/resources/performancebooking/pdf/output.css";
	private static ActionHelpers helpers = new ActionHelpers();
    
    private JwtKeyService _jwtKeyService;
    private static final Log _log = LogFactoryUtil.getLog(ScorecardAPI.class);

    @Reference
    protected void setJwtKeyService(JwtKeyService jwtKeyService) {
        this._jwtKeyService = jwtKeyService;
        _log.info("JwtKeyService has been injected into ScorecardAPI");
    }

@Override
public Set<Object> getSingletons() {
    return Collections.singleton(this);
}

@Override
public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<>();
    classes.add(CorsFilterHelper.class);
    return classes;
}

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getScoreboard(
        @HeaderParam("Authorization") String authHeader,
        @QueryParam("dataMonth") int dataMonth,
        @QueryParam("dataCategory") String dataCategory,
        @QueryParam("startDate") String startDate,
        @QueryParam("endDate") String endDate,
        @Context HttpServletRequest httpRequest
    ) {
        ServiceContext serviceContext;
        Group liferayGroup;
        long groupId;
        Company company;
        User defaultUser;
        try {
            serviceContext = ServiceContextFactory.getInstance(httpRequest);
            groupId = serviceContext.getScopeGroupId();
            liferayGroup = GroupLocalServiceUtil.getGroup(groupId);
            company = CompanyLocalServiceUtil.getCompany(liferayGroup.getCompanyId());
            defaultUser = UserLocalServiceUtil.getDefaultUser(company.getCompanyId());
        
        } catch (Exception e) {
            _log.error("Scorecard API getScoreboard: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Failed to get ServiceContext").toString())
                    .build();
        }

        String languageId = serviceContext.getLanguageId();
        Locale locale = LocaleUtil.fromLanguageId(languageId); 
        JSONObject _response = JSONFactoryUtil.createJSONObject();


        ThemeDisplay themeDisplay = new ThemeDisplay();

        try {
            
            themeDisplay.setScopeGroupId(groupId);
            themeDisplay.setCompany(company);
            themeDisplay.setUser(defaultUser);
            themeDisplay.setLocale(LocaleUtil.fromLanguageId(languageId));
            themeDisplay.setSiteGroupId(liferayGroup.getGroupId());
            themeDisplay.setLanguageId(languageId);
        } catch (Exception e) {
            // TODO: handle exception
            _log.error("Error setting ThemeDisplay: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(JsonResponseHelper.error("Error setting ThemeDisplay: " + e.getMessage()).toString())
                .build();
        }
        
        try {
            Gson gson = new Gson();

            // Validate JWT token
            SecretKey secretKey = _jwtKeyService.getKey();
            JwtAuthHelper.AuthResult authResult = JwtAuthHelper.authenticate(authHeader, secretKey);

            if (!authResult.valid) {
                _log.error("Authentication failed: " + authResult.error);
                return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(JsonResponseHelper.error("Token is not valid!").toString())
                    .build();
            }

            if(Validator.isNull(dataCategory)) {
                _log.error("Data category is null");
                return Response.status(Response.Status.BAD_REQUEST)
                    .entity(JsonResponseHelper.error("Data category is null!").toString())
                    .build();
            }

            String dailyEndDate = dataCategory.equals("daily") ? endDate : null;
            String monthlyEndDate = dataCategory.equals("monthly") ? endDate : null;

            String deptoreCode = authResult.claims.getSubject();

            String exception = checkConnection(httpRequest);
            
            if (Validator.isNotNull(exception)) {
                _log.error("Connection error: " + exception);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error(exception).toString())
                    .build();
            }

		    agencyBinderNo = getBinderNumber(deptoreCode, httpRequest);

            if (Validator.isNotNull(agencyBinderNo) == true) {
			
                /* Profile */
                
                if (dataCategory.equalsIgnoreCase("profile")) {
                    ProfileAgentDto profile = getProfile(httpRequest);
                    
                    if (Validator.isNull(profile.getAgentCode()) == true) {
                        _response.put("status", false);
                        _response.put("message", "Your data is not found!");
                        _response.put("data", gson.fromJson(gson.toJson(profile), Object.class));
                        
                        return Response.status(Response.Status.OK)
                            .entity(_response.toString())
                            .build();
                    }
                    
                    _response.put("status", true);
                    _response.put("message", "Profile data found!");
                    _response.put("data", gson.fromJson(gson.toJson(profile), Object.class));
                }
                    
                /* End Profile */
                    
                /* Club Years */
                    
                if (dataCategory.equalsIgnoreCase("club")) {
                    List<ClubYearDto> clubYears = getClub(httpRequest);
                        
                    if (clubYears.size() == 0) {
                        _response.put("status", false);
                        _response.put("message", "Your data is not found!");
                        _response.put("data", clubYears);
                        
                        return Response.status(Response.Status.OK)
                            .entity(_response.toString())
                            .build();
                    }
    
                    _response.put("status", true);
                    _response.put("message", "Club years data found!");
                    _response.put("data", clubYears);
                }
                    
                /* End Club Years */
                    
                /* Daily */
                    
                if (dataCategory.equalsIgnoreCase("daily")) {
                    List<GroupTransactionDto> dailies = new ArrayList<GroupTransactionDto>();
                    
                    for (int month = 1; month <= 12; month++) {
                        dailies.addAll(getDailyTransaction(dataCategory, startDate, dailyEndDate, month, httpRequest));
                    }
                    
                    if (dailies.size() == 0) {
                        _response.put("status", false);
                        _response.put("message", "Your data is not found!");
                        _response.put("data", dailies);
                        
                        return Response.status(Response.Status.OK)
                            .entity(_response.toString())
                            .build();
                    }
                    
                    _response.put("status", true);
                    _response.put("message", "");
                    _response.put("data", dailies);
                }
                
                /* End Daily */
                
                /* Monthly */

                if(Validator.isNull(dataMonth)) {
                    _log.error("Data Month is null");
                    return Response.status(Response.Status.BAD_REQUEST)
                        .entity(JsonResponseHelper.error("Data Month is null!").toString())
                        .build();
                }
                
                if (dataCategory.equalsIgnoreCase("monthly")) {
                    List<GroupTransactionDto> monthlies = new ArrayList<GroupTransactionDto>();
                    
                    monthlies.addAll(getMonthlyTransaction(startDate, monthlyEndDate, httpRequest));
                    
                    if (monthlies.size() == 0) {
                        _response.put("status", false);
                        _response.put("message", "Your data is not found!");
                        _response.put("data", monthlies);
                        

                        return Response.status(Response.Status.OK)
                            .entity(_response.toString())
                            .build();
                    }
                    
                    String json = gson.toJson(monthlies);
                    JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
    
                    for (int i = 0; i < monthlies.size(); i++) {
                        GroupTransactionDto monthlyTransaction = monthlies.get(i);
                        
                        if (monthlyTransaction.getTransaction().size() > 0) {
                            for (int j = 0; j < monthlyTransaction.getTransaction().size(); j++) {
                                jsonArray.get(i).getAsJsonObject().getAsJsonArray("transaction").get(j).getAsJsonObject().remove("date");
                            }
                        }
                    }
                    
                    json = jsonArray.toString();
                    
                    _response.put("status", true);
                    _response.put("message", "");
                    _response.put("data", gson.fromJson(json, Object.class));
                }
                    
                /* End Monthly */
                
                /* Data Generate Pdf */
                

                if (dataCategory.equalsIgnoreCase("generate")) {

                    try {
                        Map<String, Object> data = new HashMap<>();
                        List<GroupTransactionDto> dailies = new ArrayList<>();
                        ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
                        _log.info("theme display: " + themeDisplay);
                        _log.info("groupId: " + groupId);
                        _log.info("agencyBinderNo: " + agencyBinderNo);
                        _log.info("languageId: " + languageId);

                        // Get disclaimer content
                        JournalArticle _webContent = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, "scorecard-disclaimer");

                        String articleId = _webContent.getArticleId();
                        _log.info("articleId: "+ articleId);
                        JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId, articleId, "", "en_US", themeDisplay);
                        String disclaimerContent = articleDisplay.getContent();
                        // String disclaimerContent = _webContent.getContent();
                        
                        for (int month = 1; month <= dataMonth; month++) {
                            dailies.addAll(getDailyTransaction(dataCategory, startDate, dailyEndDate, month, httpRequest));
                        }
                        
                        String month = helpers.getMonthLong(dataMonth);
                        String monthAbbr = helpers.getMonthAbbreviation(dataMonth);
                        String lastYear = String.valueOf(Year.now().getValue() - 1);
                        String currentYear = String.valueOf(Year.now().getValue());
                        ProfileAgentDto profile = getProfile(httpRequest);
                        
                        List<ClubYearDto> clubYears = getClub(httpRequest);
                        ClubYearDto lastClubYear = clubYears.stream().filter(v -> v.getYear() == Integer.valueOf(lastYear)).findFirst().orElse(null);
                        ClubYearDto currentClubYear = clubYears.stream().filter(v -> v.getYear() == Integer.valueOf(currentYear)).findFirst().orElse(null);
                        
                        /* Calculate Weekly */
                        List<TransactionReportDto> weeklies = getWeeklyTransactionReport(dailies, dataMonth);
                        TransactionReportDto firstWeek = weeklies.stream().filter(v -> v.getPeriod() == 1).findFirst().orElse(null);
                        double amountFirstWeek = Validator.isNull(firstWeek) ? 0.0 : firstWeek.getAmount();
                        TransactionReportDto secondWeek = weeklies.stream().filter(v -> v.getPeriod() == 2).findFirst().orElse(null);
                        double amountSecondWeek = Validator.isNull(secondWeek) ? 0.0 : secondWeek.getAmount();
                        TransactionReportDto thirdWeek = weeklies.stream().filter(v -> v.getPeriod() == 3).findFirst().orElse(null);
                        double amountThirdWeek = Validator.isNull(thirdWeek) ? 0.0 : thirdWeek.getAmount();
                        TransactionReportDto fourthWeek = weeklies.stream().filter(v -> v.getPeriod() == 4).findFirst().orElse(null);
                        double amountFourthWeek = Validator.isNull(fourthWeek) ? 0.0 : fourthWeek.getAmount();
                        double totalWeeklies = amountFirstWeek + amountSecondWeek + amountThirdWeek + amountFourthWeek;
                        
                        /* Calculate Triwulan */
                        List<TransactionReportDto> monthlies = getMonthlyTransactionReport(dailies);
                        TransactionReportDto firstMonth = new TransactionReportDto();
                        TransactionReportDto secondMonth = new TransactionReportDto();
                        TransactionReportDto thirdMonth = new TransactionReportDto();
                        double amountFirstMonth, amountSecondMonth, amountThirdMonth, totalTriwulan = 0.0;
                        String triwulan = StringPool.BLANK;
                        
                        if (dataMonth <= 3) {
                            triwulan = "Triwulan 1";
                            monthlies = monthlies.stream().filter(v -> v.getPeriod() <= 3).collect(Collectors.toList());
                            
                            firstMonth = monthlies.stream().filter(v -> v.getPeriod() == 1).findFirst().orElse(null);
                            amountFirstMonth = Validator.isNull(firstMonth) ? 0.0 : firstMonth.getAmount();
                            secondMonth = monthlies.stream().filter(v -> v.getPeriod() == 2).findFirst().orElse(null);
                            amountSecondMonth = Validator.isNull(secondMonth) ? 0.0 : secondMonth.getAmount();
                            thirdMonth = monthlies.stream().filter(v -> v.getPeriod() == 3).findFirst().orElse(null);
                            amountThirdMonth = Validator.isNull(thirdMonth) ? 0.0 : thirdMonth.getAmount();
                            totalTriwulan = amountFirstMonth + amountSecondMonth + amountThirdMonth;
                        } else if (dataMonth > 3 && dataMonth <= 6) {
                            triwulan = "Triwulan 2";
                            monthlies = monthlies.stream().filter(v -> v.getPeriod() > 3 && v.getPeriod() <= 6).collect(Collectors.toList());
                            
                            firstMonth = monthlies.stream().filter(v -> v.getPeriod() == 4).findFirst().orElse(null);
                            amountFirstMonth = Validator.isNull(firstMonth) ? 0.0 : firstMonth.getAmount();
                            secondMonth = monthlies.stream().filter(v -> v.getPeriod() == 5).findFirst().orElse(null);
                            amountSecondMonth = Validator.isNull(secondMonth) ? 0.0 : secondMonth.getAmount();
                            thirdMonth = monthlies.stream().filter(v -> v.getPeriod() == 6).findFirst().orElse(null);
                            amountThirdMonth = Validator.isNull(thirdMonth) ? 0.0 : thirdMonth.getAmount();
                            totalTriwulan = amountFirstMonth + amountSecondMonth + amountThirdMonth;
                        } else if (dataMonth > 6 && dataMonth <= 9) {
                            triwulan = "Triwulan 3";
                            monthlies = monthlies.stream().filter(v -> v.getPeriod() > 6 && v.getPeriod() <= 9).collect(Collectors.toList());
                            
                            firstMonth = monthlies.stream().filter(v -> v.getPeriod() == 7).findFirst().orElse(null);
                            amountFirstMonth = Validator.isNull(firstMonth) ? 0.0 : firstMonth.getAmount();
                            secondMonth = monthlies.stream().filter(v -> v.getPeriod() == 8).findFirst().orElse(null);
                            amountSecondMonth = Validator.isNull(secondMonth) ? 0.0 : secondMonth.getAmount();
                            thirdMonth = monthlies.stream().filter(v -> v.getPeriod() == 9).findFirst().orElse(null);
                            amountThirdMonth = Validator.isNull(thirdMonth) ? 0.0 : thirdMonth.getAmount();
                            totalTriwulan = amountFirstMonth + amountSecondMonth + amountThirdMonth;
                        } else if (dataMonth > 9 && dataMonth <= 12) {
                            triwulan = "Triwulan 4";
                            monthlies = monthlies.stream().filter(v -> v.getPeriod() > 9 && v.getPeriod() <= 12).collect(Collectors.toList());
                            
                            firstMonth = monthlies.stream().filter(v -> v.getPeriod() == 10).findFirst().orElse(null);
                            amountFirstMonth = Validator.isNull(firstMonth) ? 0.0 : firstMonth.getAmount();
                            secondMonth = monthlies.stream().filter(v -> v.getPeriod() == 11).findFirst().orElse(null);
                            amountSecondMonth = Validator.isNull(secondMonth) ? 0.0 : secondMonth.getAmount();
                            thirdMonth = monthlies.stream().filter(v -> v.getPeriod() == 12).findFirst().orElse(null);
                            amountThirdMonth = Validator.isNull(thirdMonth) ? 0.0 : thirdMonth.getAmount();
                            totalTriwulan = amountFirstMonth + amountSecondMonth + amountThirdMonth;
                        } 
                        
                        /* Calculate Tahunan */
                        List<TransactionReportDto> yearlies = getYearlyTransactionReport(dailies);
                        double amountFirstQuarter, amountSecondQuarter, amountThirdQuarter, amountFourthQuarter, totalTahunan = 0.0;
                        
                        TransactionReportDto firstQuarter = yearlies.stream().filter(v -> v.getPeriod() == 1).findFirst().orElse(null);
                        amountFirstQuarter = Validator.isNull(firstQuarter) ? 0.0 : firstQuarter.getAmount();
                        TransactionReportDto secondQuarter = yearlies.stream().filter(v -> v.getPeriod() == 2).findFirst().orElse(null);
                        amountSecondQuarter = secondQuarter == null ? 0.0 : secondQuarter.getAmount();
                        TransactionReportDto thirdQuarter = yearlies.stream().filter(v -> v.getPeriod() == 3).findFirst().orElse(null);
                        amountThirdQuarter = thirdQuarter == null ? 0.0 : thirdQuarter.getAmount();
                        TransactionReportDto fourthQuarter = yearlies.stream().filter(v -> v.getPeriod() == 4).findFirst().orElse(null);
                        amountFourthQuarter = fourthQuarter == null ? 0.0 : fourthQuarter.getAmount();
                        
                        totalTahunan = amountFirstQuarter + amountSecondQuarter + amountThirdQuarter + amountFourthQuarter;
                        
                        /* COB Data */
                        List<GroupCobDto> cobs = new ArrayList<>();
                        List<TransactionDto> cobTransactions = getCob(dataMonth, httpRequest);
                        cobs.addAll(getCobTransaction(cobTransactions));
                        
                        /* Calculate COB */
                        Map<Integer, Double> mapTotalCobPerQuarter = cobs.stream()
                            .flatMap(group -> group.getTransaction().stream())
                            .collect(Collectors.groupingBy(
                                TransactionCobDto::getQuarter, Collectors.summingDouble(TransactionCobDto::getAmount)
                            ));
                        
                        List<TransactionCobDto> totalCobPerQuarter = mapTotalCobPerQuarter.entrySet().stream()
                            .map(entry -> {
                                TransactionCobDto q = new TransactionCobDto();
                                q.setQuarter(entry.getKey());
                                q.setAmount(entry.getValue());
                                return q;
                            })
                            .sorted(Comparator.comparingInt(TransactionCobDto::getQuarter))
                            .collect(Collectors.toList());
                        
                        for (GroupCobDto item : cobs) {
                            item.setCob(helpers.getCobDescription(item.getCob()));
                        }
                        
                        int totalCob = cobTransactions.stream().mapToInt(TransactionDto::getPolicyValue).sum();
                        
                        // Generate PDF using template
                        Configuration configuration = new Configuration(Configuration.VERSION_2_3_29);
                        configuration.setTemplateLoader(new ClassTemplateLoader(getClass(), "/"));
                        
                        Template template = configuration.getTemplate(templateLocation);
                        data.put("month", month);
                        data.put("triwulan", triwulan);
                        data.put("monthAbbr", monthAbbr);
                        data.put("lastYear", lastYear);
                        data.put("currentYear", currentYear);
                        data.put("profile", profile);
                        data.put("lastClubYear", lastClubYear);
                        data.put("currentClubYear", currentClubYear);
                        data.put("firstWeek", firstWeek);
                        data.put("secondWeek", secondWeek);
                        data.put("thirdWeek", thirdWeek);
                        data.put("fourthWeek", fourthWeek);
                        data.put("totalWeeklies", totalWeeklies);
                        data.put("firstMonth", firstMonth);
                        data.put("secondMonth", secondMonth);
                        data.put("thirdMonth", thirdMonth);
                        data.put("totalTriwulan", totalTriwulan);
                        data.put("firstQuarter", firstQuarter);
                        data.put("secondQuarter", secondQuarter);
                        data.put("thirdQuarter", thirdQuarter);
                        data.put("fourthQuarter", fourthQuarter);
                        data.put("totalTahunan", totalTahunan);
                        data.put("cobs", cobs);
                        data.put("totalCobPerQuarter", totalCobPerQuarter);
                        data.put("totalCob", totalCob);
                        data.put("disclaimerContent", disclaimerContent);
                        
                        template.process(data, new OutputStreamWriter(htmlStream));
                        String htmlContent = htmlStream.toString();
                        
                        // Add CSS to HTML
                        InputStream cssStream = getClass().getClassLoader().getResourceAsStream(cssLocation);
                        String cssContent = helpers.getFileContent(cssStream);
                        htmlContent = htmlContent.replace("<head>", "<head><style>" + cssContent + "</style>");
                        
                        // Convert HTML to PDF
                        byte[] pdfBytes = helpers.convertHtmlToPdf(htmlContent);
                        
                        // Return PDF as response
                        return Response.status(Response.Status.OK)
                            .entity(pdfBytes)
                            .header("Content-Type", "application/pdf")
                            .header(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate")
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=output.pdf")
                            .build();
                            
                    } catch (Exception e) {
                        _log.error("Error generating PDF: ", e);
                        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(JsonResponseHelper.error("Error generating PDF: " + e.getMessage()).toString())
                            .build();
                    }
                }
                
                /* End Data Generate Pdf */
                
                /* COB */
                
                if (dataCategory.equalsIgnoreCase("cob")) {
                    List<GroupCobDto> cobs = new ArrayList<GroupCobDto>();
                    List<TransactionDto> cobTransactions = getCob(dataMonth, httpRequest);
                    
                    cobs.addAll(getCobTransaction(cobTransactions));
                    
                    int total = cobTransactions.stream().mapToInt(TransactionDto::getPolicyValue).sum();
                    
                    if (cobs.size() == 0) {
                        _response.put("status", false);
                        _response.put("message", "Your data is not found!");
                        _response.put("total", total);
                        _response.put("data", cobs);
                        
                        return Response.status(Response.Status.OK)
                            .entity(_response.toString())
                            .build();
                    }
                    
                    _response.put("status", true);
                    _response.put("message", "");
                    _response.put("data", cobs);
                    _response.put("total", total);
                }
                
                /* End Cob */
                
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(JsonResponseHelper.error("Your data is not found!").toString())
                    .build();
            }


            return Response.status(Response.Status.OK)
                .entity(_response.toString())
                .build();

        } catch (Exception e) {
            // Handle any other exceptions that may occur
            _log.error("Error in getScoreboard: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(JsonResponseHelper.error("An error occurred: " + e.getMessage()).toString())
                .build();
        }
    }

    protected String checkConnection( HttpServletRequest httpRequest) throws Exception {
		SecureRandom random = SecureRandom.getInstanceStrong();
		PolicyDto bodyPolicy = new PolicyDto();
		String exception = StringPool.BLANK;
        int randomInt = random.nextInt(10000);
		
		bodyOperation = "getProfileAgent";
		bodyService = "getAgentInfo";
		
		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);
		
		bodyPolicy.setAgencyBinderNo(String.valueOf(randomInt));
		requestBody.setPolicy(bodyPolicy);

		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPartyManagementUrl");

		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
		if (Validator.isNull(response.getBody()) == true && Validator.isNotNull(response.getException()) == true) {
			exception = response.getStatusCode() == 503 ? "Informasi belum tersedia. Silahkan coba kembali beberapa saat kemudian." : response.getException();
		}
				
		return exception;
	}
	

    protected String getBinderNumber(String deptoreCode, HttpServletRequest httpRequest) throws Exception {
		PolicyDto bodyPolicy = new PolicyDto();
		
		bodyOperation = "getProfileAgentAlias";
		bodyService = "getAgentInfo";
		
		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);
		
		List<PartyDetailsDto> bodyPartyDetails = new ArrayList<PartyDetailsDto>();
		PartyDetailsDto bodyPartyDetail = new PartyDetailsDto();
		bodyPartyDetail.setPartyID(deptoreCode);
		bodyPartyDetails.add(bodyPartyDetail);
		
		bodyPolicy.setHasPartyDetailsIn(bodyPartyDetails);
		requestBody.setPolicy(bodyPolicy);
		
		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPartyManagementUrl");
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
		if (response.getStatusCode() == 200) {
			agencyBinderNo = Validator.isNull(response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO()) == true ? "" : response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO();
		}
		
		return agencyBinderNo;
	}
	
	protected ProfileAgentDto getProfile(HttpServletRequest httpRequest) throws Exception {
		PolicyDto bodyPolicy = new PolicyDto();
		ProfileAgentDto profile = new ProfileAgentDto();
		
		bodyOperation = "getProfileAgent";
		bodyService = "getAgentInfo";
		
		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);
		
		bodyPolicy.setAgencyBinderNo(agencyBinderNo);
		requestBody.setPolicy(bodyPolicy);
		
		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPartyManagementUrl");
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
		if (response.getStatusCode() == 200) {
			
			if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getPolicy()) == true || Validator.isNull(response.getBody().getPolicy().getAgencyBinderNo()) == true) {
				return profile;
			}
			
			profile.setAgentCode(response.getBody().getPolicy().getAgencyBinderNo());
			profile.setAgentName(response.getBody().getPolicy().getHasProducerInformationIn().get(0).getHasPersonalDetailsIn().get(0).getFullNM());
			profile.setAgentAge("");
			profile.setAgentJoinDate(response.getBody().getPolicy().getHasProducerInformationIn().get(0).getEffectiveDT() == null ? "" : helpers.ConvertDateFormat(response.getBody().getPolicy().getHasProducerInformationIn().get(0).getEffectiveDT().toString(), "dd MMM yyy"));
			profile.setAgentRegistStatus(response.getBody().getPolicy().getHasProducerInformationIn().get(0).getHasLicensingIInformationIn().get(0).getLicenseStatusCd());
			profile.setAgentRegional(response.getBody().getPolicy().getHasProducerInformationIn().get(0).getHasAssociationWith().get(0).getAreaCD());
			profile.setAgentRegionalHead(response.getBody().getPolicy().getHasProducerInformationIn().get(0).getHasAssociationWith().get(0).getHasStaffInformationIn().get(0).getBranchManagerNM());
			profile.setAgentManager(response.getBody().getPolicy().getHasProducerInformationIn().get(0).getHasPersonalDetailsIn().get(0).getHasPartyAccountDetailsIn().getPartyAccountNM());
			profile.setAgentAauiStatus(response.getBody().getPolicy().getHasProducerInformationIn().get(0).getProducerStatusCD());
		}
		
		return profile;
	}
	
	protected List<ClubYearDto> getClub(HttpServletRequest httpRequest) throws Exception {
		List<PolicyDto> bodyPolicies = new ArrayList<PolicyDto>();
		PolicyDto bodyPolicy = new PolicyDto();
		List<ClubYearDto> clubYears = new ArrayList<ClubYearDto>();
		
		bodyOperation = "getClubYears";
		bodyService = "getPolicyList";
		
		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);
		
		bodyPolicy.setAgencyBinderNo(agencyBinderNo);
		bodyPolicies.add(bodyPolicy);
		
		requestBody.setPolicies(bodyPolicies);
		
		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPolicyManagementUrl");
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
		if (response.getStatusCode() == 200) {
			
			if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getPolicies()) == true) {
				return clubYears;
			}
			
			List<PolicyDto> policies = response.getBody().getPolicies();
			
			for (PolicyDto policy : policies) {
				if (Validator.isNull(policy.getGeneralRk()) == true) {
					break;
				}
				
				ClubYearDto clubYear = new ClubYearDto();
				
				clubYear.setYear(Integer.parseInt(policy.getChangeEffectiveFromDttm()));
				clubYear.setLastUpdate(policy.getChangeEffectiveToDttm() == null ? "" : helpers.ConvertDateFormat(policy.getChangeEffectiveToDttm().toString(), "dd MMM yyy"));
				clubYear.setCurrency(policy.getCurrencyCD());
				clubYear.setClub(policy.getGeneralRk());
				clubYear.setAmount(policy.getPremiumAMT());
				
				clubYears.add(clubYear);
			}
		}
		
		return clubYears;
	}
	
	protected List<GroupTransactionDto> getDailyTransaction(String dataCategory, String startDate, String endDate, int paramMonth, HttpServletRequest httpRequest) throws Exception {
		List<PolicyDto> bodyPolicies = new ArrayList<PolicyDto>();
		PolicyDto bodyPolicy = new PolicyDto();
		List<GroupTransactionDto> dailies = new ArrayList<GroupTransactionDto>();
		
		if (paramMonth > 1 || dataCategory.equalsIgnoreCase("generate")) {
			int currentYear = Year.now().getValue();
            LocalDate startLocalDate = LocalDate.of(currentYear, paramMonth, 1);
            LocalDate endLocalDate = startLocalDate.withDayOfMonth(startLocalDate.lengthOfMonth());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            startDate = startLocalDate.format(formatter);
            endDate = endLocalDate.format(formatter);
		}
		
		bodyOperation = "getDailyAgent";
		bodyService = "getPolicyList";
		
		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);
		
		bodyPolicy.setAgencyBinderNo(agencyBinderNo);
		bodyPolicy.setValidFromDttm(startDate);
		bodyPolicy.setValidToDttm(endDate);
		bodyPolicies.add(bodyPolicy);

		requestBody.setPolicies(bodyPolicies);

		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPolicyManagementUrl");

		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
		if (response.getStatusCode() == 200) {
			if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getPolicies()) == true) {
				return dailies;
			}
			
			List<PolicyDto> policies = response.getBody().getPolicies();
			List<TransactionDto> dailyTransactions = new ArrayList<TransactionDto>();
			
			for (PolicyDto policy : policies) {
				if (Validator.isNull(policy.getIssueDt()) == true) {
					break;
				}
				
				TransactionDto dailyTransaction = new TransactionDto();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date dateObject = dateFormat.parse(policy.getIssueDt());
				LocalDate localDate = dateObject.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				dailyTransaction.setFulldate(helpers.ConvertDateFormat(dateObject.toString(), "dd-MM-yyyy"));
				dailyTransaction.setCurrency(policy.getCurrencyCD());
				dailyTransaction.setProductCode(policy.getIndivProductCd().substring(0, 2));
				dailyTransaction.setDate(localDate.getDayOfMonth());
				dailyTransaction.setMonth(localDate.getMonthValue());
				dailyTransaction.setYear(localDate.getYear());
				dailyTransaction.setAmount(policy.getPremiumAMT());
				
				dailyTransactions.add(dailyTransaction);
			}

			GroupTransactionDto daily = new GroupTransactionDto();
			
			String month = helpers.getMonthAbbreviation(paramMonth);
			
			daily.setMonth(month);
			daily.setTransaction(dailyTransactions);
			
			dailies.add(daily);
		}
		
		return dailies;
	}
	
	protected List<GroupTransactionDto> getMonthlyTransaction(String startDate, String endDate, HttpServletRequest httpRequest) throws Exception {
		List<PolicyDto> bodyPolicies = new ArrayList<PolicyDto>();
		PolicyDto bodyPolicy = new PolicyDto();
		List<GroupTransactionDto> monthlies = new ArrayList<GroupTransactionDto>();
		
		bodyOperation = "getMonthlyAgent";
		bodyService = "getPolicyList";
		
		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
		Date startDateObject = dateFormat.parse(startDate);
		Date endDateObject = dateFormat.parse(endDate);
		startDate = yearMonthFormat.format(startDateObject);
		endDate = yearMonthFormat.format(endDateObject);
		
		bodyPolicy.setAgencyBinderNo(agencyBinderNo);
		bodyPolicy.setValidFromDttm(startDate);
		bodyPolicy.setValidToDttm(endDate);
		bodyPolicies.add(bodyPolicy);
		
		requestBody.setPolicies(bodyPolicies);
		
		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPolicyManagementUrl");
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
		if (response.getStatusCode() == 200) {
			if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getPolicies()) == true) {
				return monthlies;
			}
			
			List<PolicyDto> policies = response.getBody().getPolicies();
			List<TransactionDto> monthlyTransactions = new ArrayList<TransactionDto>();
			
			for (PolicyDto policy : policies) {
				if (Validator.isNull(policy.getIssueDt()) == true) {
					break;
				}
				
				TransactionDto monthlyTransaction = new TransactionDto();
				Date dateObject = yearMonthFormat.parse(policy.getIssueDt());
				LocalDate localDate = dateObject.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				monthlyTransaction.setCurrency(policy.getCurrencyCD());
				monthlyTransaction.setProductCode(policy.getIndivProductCd().substring(0, 2));
				monthlyTransaction.setMonth(localDate.getMonthValue());
				monthlyTransaction.setYear(localDate.getYear());
				monthlyTransaction.setAmount(policy.getPremiumAMT());
				
				monthlyTransactions.add(monthlyTransaction);
			}
			
			if (monthlyTransactions.size() > 0) {
				Map<Integer, List<TransactionDto>> groupedByMonth = new HashMap<>();
				
				for (TransactionDto transaction : monthlyTransactions) {
                    int month = transaction.getMonth();
                    
                    if (!groupedByMonth.containsKey(month)) {
                        groupedByMonth.put(month, new ArrayList<>());
                    }
                    
                    groupedByMonth.get(month).add(transaction);
                }
                
                for (Map.Entry<Integer, List<TransactionDto>> entry : groupedByMonth.entrySet()) {
                    Integer paramMonth = entry.getKey();
                    List<TransactionDto> transactionsInMonth = entry.getValue();
                    String month = helpers.getMonthAbbreviation(paramMonth);

                    GroupTransactionDto monthly = new GroupTransactionDto();
                    
                    monthly.setMonth(month);
                    monthly.setTransaction(transactionsInMonth);

                    monthlies.add(monthly);
                }
			}
		}
		
		return monthlies;
	}
	
	protected List<TransactionReportDto> getWeeklyTransactionReport(List<GroupTransactionDto> dailies, int dataMonth) throws Exception {
		List<TransactionReportDto> weeklies = new ArrayList<TransactionReportDto>();
		
		String month = helpers.getMonthAbbreviation(dataMonth);

		List<GroupTransactionDto> dataFilterWeekly = dailies.stream().filter(v -> v.getMonth().equals(month)).collect(Collectors.toList());
		
		if (dataFilterWeekly.get(0).getTransaction().size() > 0) {
			List<TransactionDto> transactions = dataFilterWeekly.get(0).getTransaction();
		
			// Memproses data transaksi
			Map<Integer, Map<String, Double>> weeklyProductSumMap = new HashMap<>();
			Map<Integer, Double> weeklyTotalMap = new HashMap<>();
			
			for (TransactionDto transaction : transactions) {
                int weekNumber = helpers.getWeekNumber(transaction.getFulldate());
                String productCode = transaction.getProductCode();
                double amount = transaction.getAmount();
                    // Menambahkan data transaksi per minggu
//	            if (weekNumber == 5) {
//	                // Cek apakah minggu 4 sudah ada
//	                int weekNumber4 = 4;
//	                weeklyProductSumMap
//	                        .computeIfAbsent(weekNumber4, k -> new HashMap<>())
//	                        .merge(productCode, amount, Double::sum);
//	                weeklyTotalMap.merge(weekNumber4, amount, Double::sum);
//	            } else {
	                // Minggu selain minggu 5, tambahkan seperti biasa
                weeklyProductSumMap
                        .computeIfAbsent(weekNumber, k -> new HashMap<>())
                        .merge(productCode, amount, Double::sum);
                weeklyTotalMap.merge(weekNumber, amount, Double::sum);
//	            }
			}
			
			// Menggabungkan data minggu 5 ke minggu 4
//	        helpers.mergeAmountWeekData(weeklyTotalMap, 4, 5);
//	        helpers.mergeProductWeekData(weeklyProductSumMap, 4, 5);

			// Menampilkan hasil jumlah mingguan per produk
			for (Map.Entry<Integer, Map<String, Double>> weekEntry : weeklyProductSumMap.entrySet()) {
                int week = weekEntry.getKey();
                Map<String, Double> productSumMap = weekEntry.getValue();
                double weekTotal = weeklyTotalMap.getOrDefault(week, 0.0);
            
                TransactionReportDto weekly = new TransactionReportDto();
                weekly.setPeriod(week);
                weekly.setProduct(productSumMap.size());
                weekly.setAmount(weekTotal);
                
                weeklies.add(weekly);
			}
		}
		
		return weeklies;
	}
	
	protected List<TransactionReportDto> getMonthlyTransactionReport(List<GroupTransactionDto> dailies) throws Exception {
		List<TransactionReportDto> monthlies = new ArrayList<TransactionReportDto>();
		
		// Memproses data transaksi
		Map<Integer, Map<String, Double>> monthlyProductSumMap = new HashMap<>();
		Map<Integer, Double> monthlyTotalMap = new HashMap<>();
		
		for (GroupTransactionDto monthly : dailies) {
            for (TransactionDto transaction : monthly.getTransaction()) {
                int month = transaction.getMonth();
                String productCode = transaction.getProductCode();
                double amount = transaction.getAmount();

                // Menambahkan data transaksi per bulan
                monthlyProductSumMap
                        .computeIfAbsent(month, k -> new HashMap<>())
                        .merge(productCode, amount, Double::sum);

                // Menambahkan jumlah ke total bulanan
                monthlyTotalMap.merge(month, amount, Double::sum);
            }
        }
		
		// Menampilkan hasil jumlah bulanan per produk
		for (Map.Entry<Integer, Map<String, Double>> monthEntry : monthlyProductSumMap.entrySet()) {
            int month = monthEntry.getKey();
            Map<String, Double> productSumMap = monthEntry.getValue();
            double monthTotal = monthlyTotalMap.getOrDefault(month, 0.0);
        
            TransactionReportDto monthly = new TransactionReportDto();
            monthly.setPeriod(month);
            monthly.setProduct(productSumMap.size());
            monthly.setAmount(monthTotal);
            
            monthlies.add(monthly);
		}
		
		return monthlies;
	}
	
	protected List<TransactionReportDto> getYearlyTransactionReport(List<GroupTransactionDto> dailies) throws Exception {
		List<TransactionReportDto> yearlies = new ArrayList<TransactionReportDto>();
		
		// Memproses data transaksi
		Map<Integer, Map<String, Double>> quarterlyProductSumMap = new HashMap<>();
		Map<Integer, Double> quarterlyTotalMap = new HashMap<>();
		
		for (int i = 0; i < dailies.size(); i++) {
			GroupTransactionDto monthData = dailies.get(i);
            int quarter = helpers.getQuarterByMonthName(monthData.getMonth());
			
            for (TransactionDto transaction : monthData.getTransaction()) {
                String productCode = transaction.getProductCode();
                double amount = transaction.getAmount();

                // Menambahkan data transaksi per quarter
                quarterlyProductSumMap
                        .computeIfAbsent(quarter, k -> new HashMap<>())
                        .merge(productCode, amount, Double::sum);

                // Menambahkan jumlah ke total quarter
                quarterlyTotalMap.merge(quarter, amount, Double::sum);
            }
        }
		
		// Menampilkan hasil jumlah quarter per produk
		for (Map.Entry<Integer, Map<String, Double>> quarterEntry : quarterlyProductSumMap.entrySet()) {
            int quarter = quarterEntry.getKey();
            Map<String, Double> productSumMap = quarterEntry.getValue();
            double monthTotal = quarterlyTotalMap.getOrDefault(quarter, 0.0);
        
            TransactionReportDto yearly = new TransactionReportDto();
            yearly.setPeriod(quarter);
            yearly.setProduct(productSumMap.size());
            yearly.setAmount(monthTotal);
            
            yearlies.add(yearly);
		}
		
		return yearlies;
	}
	
	protected List<TransactionDto> getCob(int paramMonth, HttpServletRequest httpRequest) throws Exception {
		List<PolicyDto> bodyPolicies = new ArrayList<PolicyDto>();
		PolicyDto bodyPolicy = new PolicyDto();
		List<TransactionDto> cobTransactions = new ArrayList<TransactionDto>();
		
		bodyOperation = "getMonthlyAgentByLob";
		bodyService = "getPolicyList";
		
		BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);
		
		int currentYear = Year.now().getValue();
        LocalDate startLocalDate = LocalDate.of(currentYear, 1, 1);
        LocalDate endLocalDate = LocalDate.of(currentYear, paramMonth, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String startDate = startLocalDate.format(formatter);
        String endDate = endLocalDate.format(formatter);
		
		bodyPolicy.setAgencyBinderNo(agencyBinderNo);
		bodyPolicy.setValidFromDttm(startDate);
		bodyPolicy.setValidToDttm(endDate);
		bodyPolicies.add(bodyPolicy);
		
		requestBody.setPolicies(bodyPolicies);
		
		apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPolicyManagementUrl");
		
		Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
		ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
		if (response.getStatusCode() == 200) {
			if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getPolicies()) == true) {
				return cobTransactions;
			}
			
			List<PolicyDto> policies = response.getBody().getPolicies();
			
			for (PolicyDto policy : policies) {
				if (Validator.isNull(policy.getIssueDt()) == true) {
					break;
				}
				
				TransactionDto cobTransaction = new TransactionDto();
				SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
				Date dateObject = yearMonthFormat.parse(policy.getIssueDt());
				LocalDate localDate = dateObject.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				cobTransaction.setCurrency(policy.getCurrencyCD());
				cobTransaction.setProductCode(policy.getIndivProductCd().substring(0, 2));
				cobTransaction.setMonth(localDate.getMonthValue());
				cobTransaction.setYear(localDate.getYear());
				cobTransaction.setPolicyTypeCode(policy.getPolicyTypeCd());
				
				int policyValue = policy.getPolicyTypeCd().equalsIgnoreCase("cancel") ? policy.getPolicyValue() * -1 :
                policy.getPolicyTypeCd().equalsIgnoreCase("endorsement") ? 0 :
				policy.getPolicyValue();
				
				cobTransaction.setPolicyValue(policyValue);
				cobTransaction.setAmount(policy.getPremiumAMT());
				
				cobTransactions.add(cobTransaction);
			}
		}
		
		return cobTransactions;
	}
	
	protected List<GroupCobDto> getCobTransaction(List<TransactionDto> cobTransactions) throws Exception {
		List<GroupCobDto> cobs = new ArrayList<GroupCobDto>();
			
		Map<String, Map<Integer, Double>> groupedData = cobTransactions.stream()
                .collect(Collectors.groupingBy(
                    TransactionDto::getProductCode,
                    Collectors.groupingBy(
                        transaction -> helpers.getQuarterByMonthNumber(transaction.getMonth()),
                        Collectors.summingDouble(TransactionDto::getAmount)
                    )
                ));
		
		cobs = groupedData.entrySet().stream()
				.map(entry -> {
                    GroupCobDto group = new GroupCobDto();
                    group.setCob(entry.getKey());

                    List<TransactionCobDto> transactions = entry.getValue().entrySet().stream()
                        .map(subEntry -> {
                            TransactionCobDto cobDto = new TransactionCobDto();
                            cobDto.setQuarter(subEntry.getKey());
                            cobDto.setAmount(subEntry.getValue());
                            return cobDto;
                        })
                        .collect(Collectors.toList());

                    group.setTransaction(transactions);
                    return group;
                })
                .collect(Collectors.toList());
		
		return cobs;
	}
	
}