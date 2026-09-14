package com.mypage.agencyportal.portlet.action;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.constants.AgentPerformanceBookingPortletKeys;
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
import com.mypage.agencyportal.dto.axamiles.GroupTripRewardDto;
import com.mypage.agencyportal.dto.axamiles.TripRewardDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AgentPerformanceBookingPortletKeys.AGENT_PERFORMANCE_BOOKING,
		"mvc.command.name=/data/agentperformancebooking"
	},
	service = MVCResourceCommand.class
)
public class AgentPerformanceBookingMVCResourceCommand extends BaseMVCResourceCommand {
	private static String apiURL;
	private static String agencyBinderNo;
	private static String bodyOperation;
	private static String bodyService;
	private static String templateLocation = "/META-INF/resources/performancebooking/pdf/template.ftl";
	private static String cssLocation = "/META-INF/resources/performancebooking/pdf/output.css";
	private static String apiRequestTokenRenew=null;
	
	private static ActionHelpers helpers = new ActionHelpers();

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		Gson gson = new Gson();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		/* Init Params Request */
		int dataMonth = ParamUtil.getInteger(httpRequest, "dataMonth");
		String dataCategory = ParamUtil.getString(httpRequest, "dataCategory");
		String startDate = ParamUtil.getString(httpRequest, "startDate");
		String dailyEndDate = dataCategory.equalsIgnoreCase("daily") == true ? ParamUtil.getString(httpRequest, "endDate") : "";
		String monthlyEndDate = dataCategory.equalsIgnoreCase("monthly") == true ? ParamUtil.getString(httpRequest, "endDate") : "";
		String deptoreCode = StringPool.BLANK;
		
		/* Validate API Request Token */
		boolean validateApiRequestToken = false;
		String renderToken = ParamUtil.getString(httpRequest, "rtoken");
		String _apiRequestToken = ParamUtil.getString(httpRequest, "aptoken");

		AgentToken verifyAgentToken = _agentTokenLocalService.verifyToken(renderToken, _apiRequestToken);

		if (!Validator.isNull(verifyAgentToken)) {

			AgentToken renewAgentApiRequestToken = _agentTokenLocalService.renewAgentToken(verifyAgentToken.getAgentTokenId());

			if (!Validator.isNull(renewAgentApiRequestToken)) {
				apiRequestTokenRenew = renewAgentApiRequestToken.getApiRequestToken();
			}

			validateApiRequestToken = true;
			deptoreCode = verifyAgentToken.getDeptCode();
		}

		if (!validateApiRequestToken) {
			_response.put("status", false);
			_response.put("message", "Access Forbidden");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		 /* END Validate API Request Token */
		
		/* End Init Params Request */
		
		/* Request EIP */
		
		String exception = checkConnection(startDate, dailyEndDate, httpRequest);

		if (Validator.isNotNull(exception) == true) {
			_response.put("status", false);
			_response.put("message", exception);

			resourceResponse.getWriter().write(_response.toString());
			return;
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
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				_response.put("status", true);
				_response.put("message", "");
				_response.put("data", gson.fromJson(gson.toJson(profile), Object.class));
				_response.put("token", apiRequestTokenRenew);
			}
				
			/* End Profile */
				
			/* Club Years */
				
			if (dataCategory.equalsIgnoreCase("club")) {
				List<ClubYearDto> clubYears = getClub(httpRequest);
					
				if (clubYears.size() == 0) {
					_response.put("status", false);
					_response.put("message", "Your data is not found!");
					_response.put("data", clubYears);
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}

				_response.put("status", true);
				_response.put("message", "");
				_response.put("data", clubYears);
				_response.put("token", apiRequestTokenRenew);
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
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				_response.put("status", true);
				_response.put("message", "");
				_response.put("data", dailies);
				_response.put("token", apiRequestTokenRenew);
			}
			
			/* End Daily */
			
			/* Monthly */
			
			if (dataCategory.equalsIgnoreCase("monthly")) {
				List<GroupTransactionDto> monthlies = new ArrayList<GroupTransactionDto>();
				
				monthlies.addAll(getMonthlyTransaction(startDate, monthlyEndDate, httpRequest));
				
				if (monthlies.size() == 0) {
					_response.put("status", false);
					_response.put("message", "Your data is not found!");
					_response.put("data", monthlies);
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				String json = gson.toJson(monthlies);
				JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();

				for (int i = 0; i < monthlies.size(); i++) {
					GroupTransactionDto monthly = monthlies.get(i);
					
					if (monthly.getTransaction().size() > 0) {
						for (int j = 0; j < monthly.getTransaction().size(); j++) {
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
				Map<String, Object> data = new HashMap<String, Object>();
				List<GroupTransactionDto> dailies = new ArrayList<GroupTransactionDto>();
				ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
				
				JournalArticle _webContent = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, "scorecard-disclaimer");
				JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(groupId,
						_webContent.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay);
				String disclaimerContent = articleDisplay.getContent();
				
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
				double amountFirstWeek = Validator.isNull(firstWeek) == true ? 0.0 : firstWeek.getAmount();
				TransactionReportDto secondWeek = weeklies.stream().filter(v -> v.getPeriod() == 2).findFirst().orElse(null);
				double amountSecondWeek = Validator.isNull(secondWeek) == true ? 0.0 : secondWeek.getAmount();
				TransactionReportDto thirdWeek = weeklies.stream().filter(v -> v.getPeriod() == 3).findFirst().orElse(null);
				double amountThirdWeek = Validator.isNull(thirdWeek) == true ? 0.0 : thirdWeek.getAmount();
				TransactionReportDto fourthWeek = weeklies.stream().filter(v -> v.getPeriod() == 4).findFirst().orElse(null);
				double amountFourthWeek = Validator.isNull(fourthWeek) == true ? 0.0 : fourthWeek.getAmount();
				double totalWeeklies = amountFirstWeek + amountSecondWeek + amountThirdWeek + amountFourthWeek;
				
				/* End Calculate Weekly */
				
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
					amountFirstMonth = Validator.isNull(firstMonth) == true ? 0.0 : firstMonth.getAmount();
					secondMonth = monthlies.stream().filter(v -> v.getPeriod() == 2).findFirst().orElse(null);
					amountSecondMonth = Validator.isNull(secondMonth) == true ? 0.0 : secondMonth.getAmount();
					thirdMonth = monthlies.stream().filter(v -> v.getPeriod() == 3).findFirst().orElse(null);
					amountThirdMonth = Validator.isNull(thirdMonth) == true ? 0.0 : thirdMonth.getAmount();
					totalTriwulan = amountFirstMonth + amountSecondMonth + amountThirdMonth;
					
				} else if (dataMonth > 3 && dataMonth <= 6) {
					
					triwulan = "Triwulan 2";
					monthlies = monthlies.stream().filter(v -> v.getPeriod() > 3 && v.getPeriod() <= 6).collect(Collectors.toList());
					
					firstMonth = monthlies.stream().filter(v -> v.getPeriod() == 4).findFirst().orElse(null);
					amountFirstMonth = Validator.isNull(firstMonth) == true ? 0.0 : firstMonth.getAmount();
					secondMonth = monthlies.stream().filter(v -> v.getPeriod() == 5).findFirst().orElse(null);
					amountSecondMonth = Validator.isNull(secondMonth) == true ? 0.0 : secondMonth.getAmount();
					thirdMonth = monthlies.stream().filter(v -> v.getPeriod() == 6).findFirst().orElse(null);
					amountThirdMonth = Validator.isNull(thirdMonth) == true ? 0.0 : thirdMonth.getAmount();
					totalTriwulan = amountFirstMonth + amountSecondMonth + amountThirdMonth;
					
				} else if (dataMonth > 6 && dataMonth <= 9) {
					
					triwulan = "Triwulan 3";
					monthlies = monthlies.stream().filter(v -> v.getPeriod() > 6 && v.getPeriod() <= 9).collect(Collectors.toList());
					
					firstMonth = monthlies.stream().filter(v -> v.getPeriod() == 7).findFirst().orElse(null);
					amountFirstMonth = Validator.isNull(firstMonth) == true ? 0.0 : firstMonth.getAmount();
					secondMonth = monthlies.stream().filter(v -> v.getPeriod() == 8).findFirst().orElse(null);
					amountSecondMonth = Validator.isNull(secondMonth) == true ? 0.0 : secondMonth.getAmount();
					thirdMonth = monthlies.stream().filter(v -> v.getPeriod() == 9).findFirst().orElse(null);
					amountThirdMonth = Validator.isNull(thirdMonth) == true ? 0.0 : thirdMonth.getAmount();
					totalTriwulan = amountFirstMonth + amountSecondMonth + amountThirdMonth;
					
				} else if (dataMonth > 9 && dataMonth <= 12) {
					
					triwulan = "Triwulan 4";
					monthlies = monthlies.stream().filter(v -> v.getPeriod() > 9 && v.getPeriod() <= 12).collect(Collectors.toList());
					
					firstMonth = monthlies.stream().filter(v -> v.getPeriod() == 10).findFirst().orElse(null);
					amountFirstMonth = Validator.isNull(firstMonth) == true ? 0.0 : firstMonth.getAmount();
					secondMonth = monthlies.stream().filter(v -> v.getPeriod() == 11).findFirst().orElse(null);
					amountSecondMonth = Validator.isNull(secondMonth) == true ? 0.0 : secondMonth.getAmount();
					thirdMonth = monthlies.stream().filter(v -> v.getPeriod() == 12).findFirst().orElse(null);
					amountThirdMonth = Validator.isNull(thirdMonth) == true ? 0.0 : thirdMonth.getAmount();
					totalTriwulan = amountFirstMonth + amountSecondMonth + amountThirdMonth;
					
				} 
				
				/* End Calculate Triwulan */
				
				/* Calculate Tahunan */
				
				List<TransactionReportDto> yearlies = getYearlyTransactionReport(dailies);
				double amountFirstQuarter, amountSecondQuarter, amountThirdQuarter, amountFourthQuarter, totalTahunan = 0.0;
				
				TransactionReportDto firstQuarter = yearlies.stream().filter(v -> v.getPeriod() == 1).findFirst().orElse(null);
				amountFirstQuarter = Validator.isNull(firstQuarter) == true ? 0.0 : firstQuarter.getAmount();
				TransactionReportDto secondQuarter = yearlies.stream().filter(v -> v.getPeriod() == 2).findFirst().orElse(null);
				amountSecondQuarter = secondQuarter == null ?  0.0 : secondQuarter.getAmount();
				TransactionReportDto thirdQuarter = yearlies.stream().filter(v -> v.getPeriod() == 3).findFirst().orElse(null);
				amountThirdQuarter = thirdQuarter == null ? 0.0 : thirdQuarter.getAmount();
				TransactionReportDto fourthQuarter = yearlies.stream().filter(v -> v.getPeriod() == 4).findFirst().orElse(null);
				amountFourthQuarter = fourthQuarter == null ? 0.0 : fourthQuarter.getAmount();
				
				totalTahunan = amountFirstQuarter + amountSecondQuarter + amountThirdQuarter + amountFourthQuarter;
				
				/* End Calculate Tahunan */
				
				List<GroupCobDto> cobs = new ArrayList<GroupCobDto>();
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
				
				for (GroupCobDto item : cobs) item.setCob(helpers.getCobDescription(item.getCob()));
				
				/* End Calculate COB */
				
				int totalCob = cobTransactions.stream().mapToInt(TransactionDto::getPolicyValue).sum();
				
				TripRewardDto reward = getTripReward(httpRequest);
				
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
		        data.put("reward", reward);
		        data.put("totalCob", totalCob);
		        data.put("disclaimerContent", disclaimerContent);
		        
		        template.process(data, new OutputStreamWriter(htmlStream));

		        String htmlContent = htmlStream.toString();
		        
		        InputStream cssStream = AgentPerformanceBookingMVCResourceCommand.class.getClassLoader().getResourceAsStream(cssLocation);
	            String cssContent = helpers.getFileContent(cssStream);
	            
	            htmlContent = htmlContent.replace("<head>", "<head><style>" + cssContent + "</style>");

		        byte[] pdfBytes = helpers.convertHtmlToPdf(htmlContent);

		        resourceResponse.setContentType("application/pdf");
		        resourceResponse.addProperty("Aptoken", apiRequestTokenRenew);
		        resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		        resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=output.pdf");

		        try (OutputStream outputStream = resourceResponse.getPortletOutputStream()) {
		            outputStream.write(pdfBytes);
		        }
				
				return;
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
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				_response.put("status", true);
				_response.put("message", "");
				_response.put("data", cobs);
				_response.put("total", total);
				_response.put("token", apiRequestTokenRenew);
			}
			
			/* End Cob */
			
			/* Miles Trip Reward */
			
			if (dataCategory.equalsIgnoreCase("miles")) {
				TripRewardDto reward = getTripReward(httpRequest);
				
				if (Validator.isNull(reward) == true) {					
					_response.put("status", false);
					_response.put("message", "Your data is not found!");
					_response.put("data", gson.fromJson(gson.toJson(reward), Object.class));
					
					resourceResponse.getWriter().write(_response.toString());
					return;
				}
				
				_response.put("status", true);
				_response.put("message", "");
				_response.put("data", gson.fromJson(gson.toJson(reward), Object.class));
				_response.put("token", apiRequestTokenRenew);
			}
			
			/* End Miles Trip Reward */
			
		} else {
			_response.put("status", false);
			_response.put("message", "Your data is not found!");	 
		}
		
		/* End Request EIP */

		resourceResponse.getWriter().write(_response.toString());
	}
	
	protected String checkConnection(String startDate, String endDate, HttpServletRequest httpRequest) throws Exception {
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
		ResponseDto<BodyDto> response = (ResponseDto<BodyDto>) helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
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
                clubYear.setMiles(policy.getCollectedByAgentAmt());
				
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
	
	protected TripRewardDto getTripReward(HttpServletRequest httpRequest) throws Exception {
		com.mypage.agencyportal.dto.axamiles.PolicyDto bodyPolicy = new com.mypage.agencyportal.dto.axamiles.PolicyDto();
		TripRewardDto reward = new TripRewardDto();
		
		bodyOperation = "getTripReward";
		bodyService = "getAgentInfo";
		String bodyApplication = "AGENCY_CONTEST";
		
		com.mypage.agencyportal.dto.axamiles.BodyDto requestBody = helpers.setupRequestBody(com.mypage.agencyportal.dto.axamiles.BodyDto.class, bodyOperation, bodyService, bodyApplication);
		
		bodyPolicy.setAgencyBinderNo(agencyBinderNo);
		requestBody.setPolicy(bodyPolicy);
		
		String apiMiles = MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Scorecard").stream()
						  .filter(v -> v.getName().equalsIgnoreCase("endpoint miles") && v.getActive() == 1).findFirst()
						  .map(v -> (v.getValue() == null || v.getValue().isEmpty()) ? "" : v.getValue()).orElse("");
		
		if (Validator.isNull(apiMiles) == true) {
			return reward;
		}
		
		Type typeOfResponse = new TypeToken<ResponseDto<com.mypage.agencyportal.dto.axamiles.BodyDto>>() {}.getType();
		ResponseDto<com.mypage.agencyportal.dto.axamiles.BodyDto> response = helpers.setupCallAPI(apiMiles, bodyOperation, typeOfResponse, requestBody, httpRequest);
		
		if (response.getStatusCode() == 200) {
			
			if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getPolicy()) == true || Validator.isNull(response.getBody().getPolicy().getAgencyBinderNo()) == true) {
				return reward;
			}

			String tierBonus = StringPool.BLANK;
			String tierBonusPlus = StringPool.BLANK;
			double allowanceBonus = 0.0;
			double tripAllowanceBonus = 0.0;
			double tripAllowanceBonusPlus = 0.0;
			List<GroupTripRewardDto> terms = new ArrayList<GroupTripRewardDto>();
			List<com.mypage.agencyportal.dto.axamiles.HasNameValueDto> datas = response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getHasNameValue();
			
			for (com.mypage.agencyportal.dto.axamiles.HasNameValueDto data : datas) {
				if (data.getName().contains("GWP") || data.getName().contains("Miles") || data.getName().contains("Policy")) {
					GroupTripRewardDto term = new GroupTripRewardDto();
					
					term.setName(data.getName());
					term.setAmount(Validator.isNull(data.getValue()) || data.getValue().equalsIgnoreCase("-") ? 0 : Double.parseDouble(data.getValue()));
					
					terms.add(term);
				}
				
				if (data.getName().equalsIgnoreCase("RewardTierBonus") && Validator.isNotNull(data.getValue())) {
					tierBonus = data.getValue();
				}

				if (data.getName().equalsIgnoreCase("RewardTierBonusPlus") && Validator.isNotNull(data.getValue())) {
					tierBonusPlus = data.getValue();
				}
				
				if (data.getName().equalsIgnoreCase("AllowanceBonus") && Validator.isNotNull(data.getValue())) {
					allowanceBonus += helpers.isParsableToDouble(data.getValue()) ? Double.parseDouble(data.getValue()) : 0;
				}
				
				if (data.getName().equalsIgnoreCase("TripAllowanceBonus") && Validator.isNotNull(data.getValue())) {
					tripAllowanceBonus += helpers.isParsableToDouble(data.getValue()) ? Double.parseDouble(data.getValue()) : 0;
				}

				if (data.getName().equalsIgnoreCase("TripAllowanceBonusPlus") && Validator.isNotNull(data.getValue())) {
					tripAllowanceBonusPlus += helpers.isParsableToDouble(data.getValue()) ? Double.parseDouble(data.getValue()) : 0;
				}
			}
			
			GroupTripRewardDto totalMiles = new GroupTripRewardDto();
			totalMiles.setName("TotalMiles");
			totalMiles.setAmount(Validator.isNull(response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyRK()) || response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyRK().equalsIgnoreCase("-") ? 0 : Double.parseDouble(response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyRK()));
			terms.add(totalMiles);
			
			String status = response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyStatus();
			
			reward.setTerms(terms);
			reward.setStatus(status);
			reward.setTier(status.equalsIgnoreCase("not eligible") ? "-" : response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyTypeCD());
			reward.setPax(status.equalsIgnoreCase("not eligible") ? "-" : tierBonus);
			reward.setPaxBonus(status.equalsIgnoreCase("not eligible") ? "-" : tierBonusPlus);
			reward.setRank(status.equalsIgnoreCase("not eligible") ? "-" : response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getParentPartyCD());
			reward.setAllowance(status.equalsIgnoreCase("not eligible") ? 0 : allowanceBonus);
			reward.setTripAllowance(status.equalsIgnoreCase("not eligible") ? 0 : tripAllowanceBonus);
			reward.setTripAllowancePlus(status.equalsIgnoreCase("not eligible") ? 0 : tripAllowanceBonusPlus);
		}
		
		return reward;
	}
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
