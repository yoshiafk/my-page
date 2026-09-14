package com.mypage.agencyportal.portlet.action;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.AgentDashboardPortofolioTransaksiPortletKeys;
import com.mypage.agencyportal.dto.BodyDto;
import com.mypage.agencyportal.dto.CustomerInformationDto;
import com.mypage.agencyportal.dto.HasNameValueDto;
import com.mypage.agencyportal.dto.PartyDetailsDto;
import com.mypage.agencyportal.dto.PolicyDto;
import com.mypage.agencyportal.dto.PolicySummaryDto;
import com.mypage.agencyportal.dto.ResponseDto;
import com.mypage.agencyportal.dto.ResponseTransaksiKeseluruhanDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AgentDashboardPortofolioTransaksiPortletKeys.AGENT_DASHBOARD_PORTOFOLIO_TRX,
		"mvc.command.name=/data/dashboard/portofolio/transaction/all" }, 
service = MVCResourceCommand.class)
public class PortofolioTransactionAllMVCResourceCommand extends BaseMVCResourceCommand {

	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(PortofolioTransactionAllMVCResourceCommand.class);
	private static final String PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
	//private static final String dashboardApiAgencyLeadsUrl = helpers.getConfig("dashboard.api.agency.leads");
	private static final String dashboardApiAgencyDownloadReport = helpers.getConfig("dashboard.api.agency.download.report");

	
	private static String apiRequestTokenRenew = null;

	private static String apiURL;
	private static String agencyBinderNo;
	private static String bodyOperation;
	private static String bodyService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

		String deptoreCode = StringPool.BLANK;

		/* Validate API Request Token */
		boolean validateApiRequestToken = false;
		String renderToken = ParamUtil.getString(httpRequest, "rtoken");
		String _apiRequestToken = ParamUtil.getString(httpRequest, "aptoken");

		AgentToken verifyAgentToken = _agentTokenLocalService.verifyToken(renderToken, _apiRequestToken);

		if (!Validator.isNull(verifyAgentToken)) {

			apiRequestTokenRenew = verifyAgentToken.getApiRequestToken();

			validateApiRequestToken = true;
			deptoreCode = verifyAgentToken.getDeptCode();
		}

		if (!validateApiRequestToken) {
			if (helpers.isLog()) _log.info("tidak valid validateApiRequestToken!!!");
			_response.put("status", false);
			_response.put("message", "Access Forbidden");

			resourceResponse.getWriter().write(_response.toString());
			return;
		}
		/* END Validate API Request Token */

		String dataCategory = Validator.isNull(ParamUtil.getString(httpRequest, "dataCategory")) == true
				? ParamUtil.getString(uploadPortletRequest, "dataCategory")
				: ParamUtil.getString(httpRequest, "dataCategory");

		int limit = 10; // default
		int start = ParamUtil.getInteger(httpRequest, "start");
		String _polNum = ParamUtil.getString(httpRequest, "policyNumber");
		String _name = ParamUtil.getString(httpRequest, "name");
		String _produk = ParamUtil.getString(httpRequest, "products");

		String _Frompdateall = ParamUtil.getString(httpRequest, "fpDate");
		String _Topdateall = ParamUtil.getString(httpRequest, "tpDate");

		//String _Frombdateall = ParamUtil.getString(httpRequest, "fbDate");
		//String _Tobdateall = ParamUtil.getString(httpRequest, "tbDate");
		
		String _a = ParamUtil.getString(httpRequest, "a");
		String encodeToken = URLEncoder.encode(_a, "UTF-8");

		String _startDate = ParamUtil.getString(httpRequest, "startDate");
		String _endDate = ParamUtil.getString(httpRequest, "endDate");

		// define param
		String PolicyNumber = _polNum;
		String Name = _name;
		String Product = _produk;

		String validFromDttm = _Frompdateall;
		String validToDttm = _Topdateall;

		//String FromBDate = _Frombdateall;
		//String ToBDate = _Tobdateall;

		int page = (limit != 0) ? (start / limit + 1) : 1;

		String postData = "Code=" + deptoreCode + "&Start=" + start + "&Limit=" + limit;

		if (!_polNum.isEmpty())
			postData += "&policyNumber=" + PolicyNumber;
		if (!_name.isEmpty())
			postData += "&Name=" + Name;
		if (!_produk.isEmpty() && Product.contains("multiselect-all"))
			Product = Product.replaceAll("multiselect-all,", ""); // delete multiselect-all,
		if (!_produk.isEmpty())
			postData += "&Product=" + Product;

		SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat outputFormat2 = new SimpleDateFormat("yyyy-MM-dd");

		if (dataCategory.equalsIgnoreCase("download")) {

			// Get last 3 months
			LocalDate startDate = LocalDate.now().minusMonths(3);
			LocalDate endDate = LocalDate.now();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));
			String startDateStr = startDate.format(formatter);
			String endDateStr = endDate.format(formatter);

			// jika start date end date empty, set default startenddate 3 last month
			String formattedStartDate = !_startDate.isEmpty() ? _startDate : startDateStr;
			String formattedEndDate = !_endDate.isEmpty() ? _endDate : endDateStr;

			Date startDateDownload = inputFormat.parse(formattedStartDate.replace("Agt", "Agu")); // format id august ->
																									// ags. once found
			Date endDateDownload = inputFormat.parse(formattedEndDate.replace("Agt", "Agu"));

			String startDateFormatted = outputFormat.format(startDateDownload);
			String endDateFormatted = outputFormat.format(endDateDownload);

			// Menambahkan tanggal ke dalam string postData
			postData += "&StartDate=" + startDateFormatted + "&EndDate=" + endDateFormatted;

			URI uridownload = new URI(PIMCORE_HOST + dashboardApiAgencyDownloadReport);
			String URLDownloadReportTrx = uridownload.toString();

			try {
				HttpURLConnection connection = null;

				URL url = new URL(URLDownloadReportTrx);

				if (url.getProtocol().equalsIgnoreCase("https")) {
					HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();

					//httpsConnection.setHostnameVerifier((hostname, session) -> true);
					httpsConnection.setHostnameVerifier(new HostnameVerifier() {
						@Override
						public boolean verify(String requestedHost, SSLSession remoteServerSession) {
							return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
						}
					});

					SSLContext sslContext = SSLContext.getInstance("TLS");
					sslContext.init(null, new TrustManager[] { new X509TrustManager() {
						public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
						}
		
						public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
						}
		
						public X509Certificate[] getAcceptedIssuers() {
							return null; //new X509Certificate[0];
						}
					} }, new SecureRandom());			
	                
//					TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//	                trustManagerFactory.init((KeyStore) null);
//	                
//	                SSLContext sslContext = SSLContext.getInstance("TLS");
//	                sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

					httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());

					connection = httpsConnection;
				} else {
					connection = (HttpURLConnection) url.openConnection();
				}

				connection.setRequestMethod("POST");
				connection.setRequestProperty("Authorization", encodeToken);
				// conn.setRequestProperty("Content-Type", "application/json");
				connection.setDoOutput(true);

				try (OutputStream os = connection.getOutputStream()) {
					byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
					os.write(postDataBytes);
				}

				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					InputStream inputStream = connection.getInputStream();

					resourceResponse.setContentType("application/vnd.ms-excel");
					resourceResponse.setProperty("Content-Disposition", "attachment; filename=report.xls");

					try (OutputStream outputStream = resourceResponse.getPortletOutputStream()) {
						byte[] buffer = new byte[1024];
						int bytesRead;
						while ((bytesRead = inputStream.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}

						outputStream.flush();
					}
				}

				connection.disconnect();
			} catch (IOException e) {
				if (helpers.isLog()) _log.info("Failed api requests");
			}

			return; // return after run

		}

		if (dataCategory.equalsIgnoreCase("main")) {
			//if (helpers.isLog()) _log.info("exect main");
			agencyBinderNo = getBinderNumber(deptoreCode, httpRequest);

			String _validFromDttmFormatted = "";
			String _validToDttmformatted = "";
			if (!_Frompdateall.isEmpty()) {
				Date tanggalDate = inputFormat.parse(validFromDttm.replace("Agt", "Agu")); // format id august -> ags. once
				_validFromDttmFormatted = outputFormat2.format(tanggalDate);
			}
			if (!_Topdateall.isEmpty()) {
				Date tanggalDate = inputFormat.parse(validToDttm.replace("Agt", "Agu"));
				_validToDttmformatted = outputFormat2.format(tanggalDate);
			}

			Gson gson = new Gson();
			
			//if (helpers.isLog()) _log.info("start>> " + start);
			if (helpers.isLog()) _log.info("page>> " + page);
			if (helpers.isLog()) _log.info("validFromDttm>> " + _validFromDttmFormatted);
			if (helpers.isLog()) _log.info("validToDttm>> " + _validToDttmformatted);
//			if (helpers.isLog()) _log.info("agencyBinderNo>> " + agencyBinderNo);
			
			
			List<HasNameValueDto> reqPagination = new ArrayList<>();
			reqPagination.add(new HasNameValueDto("page", String.valueOf(page)));
			reqPagination.add(new HasNameValueDto("data_perpage", String.valueOf(limit)));
			
			String jsonpag = gson.toJson(reqPagination);
	        if (helpers.isLog()) _log.info("reqPagination>> " + jsonpag);
			
			List<PolicySummaryDto> dailies = new ArrayList<PolicySummaryDto>();
			ResponseTransaksiKeseluruhanDto keseluruhanDto = listPoliciesDaily("daily", _validFromDttmFormatted, _validToDttmformatted, reqPagination ,httpRequest);

			int total = 0;
			if (keseluruhanDto.getDatas().size() > 0) {
			    dailies.addAll(keseluruhanDto.getDatas());
			    total = keseluruhanDto.getTotalData();
			}

			String ResponseTransaksiKeseluruhanDto = gson.toJson(keseluruhanDto);
	        String json = gson.toJson(dailies);
	        if (helpers.isLog()) _log.info("ResponseTransaksiKeseluruhanDto>> " + ResponseTransaksiKeseluruhanDto);
	        if (helpers.isLog()) _log.info("data>> " + json);
	        if (helpers.isLog()) _log.info("total data final>>" + total);
			
			
			_response.put("start", start);
			_response.put("page", page);
			_response.put("totalData", total);
			_response.put("deptoreCode", deptoreCode);
			_response.put("datas", dailies);
			_response.put("status", true);
			_response.put("message", keseluruhanDto.getStatusMessage());
			_response.put("token", apiRequestTokenRenew);

		}

		resourceResponse.getWriter().write(_response.toString());

	}
	
	protected ResponseTransaksiKeseluruhanDto listPoliciesDaily(String dataCategory, String startDate, String endDate, List<HasNameValueDto> hasNameValueDtoReq, HttpServletRequest httpRequest) throws Exception {
	    List<PolicyDto> bodyPolicies = new ArrayList<>();
	    PolicyDto bodyPolicy = new PolicyDto();
	    
	    bodyOperation = "getDailyAgent";
	    bodyService = "getPolicyList";

	    BodyDto requestBody = helpers.setupRequestBody(BodyDto.class, bodyOperation, bodyService, null);

	    bodyPolicy.setAgencyBinderNo(agencyBinderNo);
	    bodyPolicy.setValidFromDttm(startDate);
	    bodyPolicy.setValidToDttm(endDate);
	    bodyPolicy.setHasNameValueDtos(hasNameValueDtoReq);
	    bodyPolicies.add(bodyPolicy);

	    Gson gson = new Gson();
	    String jsonbodyPolicies = gson.toJson(bodyPolicies);
	    if (helpers.isLog()) _log.info("jsonbodyPolicies>> " + jsonbodyPolicies);
	    
	    requestBody.setPolicies(bodyPolicies);

	    String jsonbodyrequestBody = gson.toJson(requestBody);
	    if (helpers.isLog()) _log.info("jsonbodyrequestBody>> " + jsonbodyrequestBody);
	    
	    apiURL = helpers.getConfig("com.mypage.agent.config.eipApiPolicyManagementUrl");

	    Type typeOfResponse = new TypeToken<ResponseDto<BodyDto>>() {}.getType();
	    ResponseDto<BodyDto> response = helpers.setupCallAPI(apiURL, bodyOperation, typeOfResponse, requestBody, httpRequest);
	    
	    if (helpers.isLog()) _log.info(gson.toJson(response.getBody()));
		if(Integer.valueOf(response.getStatusCode()) < 1) {
			if (helpers.isLog()) _log.info(response.getBody().getException().getMessage());
			//return;
		}
	    
	    List<PolicySummaryDto> summaryPolicies = new ArrayList<>();
	    
	    int totalData = 0;
	    if (response.getStatusCode() == 200 && response.getBody().getException().getCode() == null) {
	        List<PolicyDto> respPolicies = response.getBody().getPolicies();
	        
	        // Ambil total_data dari response pada indeks 0
	        if (respPolicies != null && !respPolicies.isEmpty()) {
	            PolicyDto firstPolicy = respPolicies.get(0);
	            List<HasNameValueDto> hasNameValueList = firstPolicy.getHasNameValueDtos();
	            
	            hasNameValueList.forEach(System.out::println);
	            
	            if (hasNameValueList != null) {
	                for (HasNameValueDto hasNameValue : hasNameValueList) {
	                    if ("total_data".equals(hasNameValue.getName())) {
	                        totalData = Integer.parseInt(hasNameValue.getValue());
	                        break;
	                    }
	                }
	            }
	        }

	        
	        for (PolicyDto policy : respPolicies) {
	            PolicySummaryDto summary = new PolicySummaryDto();
	            summary.setPolicyNO(policy.getPolicyNO());
	            summary.setApplicationRk(policy.getApplicationRk());
	            summary.setIssueDt(policy.getIssueDt());

	            // Extract fullNM from hasCustomerInformationIn
	            List<CustomerInformationDto> customers = policy.getHasCustomerInformationIn();
	            if (customers != null && !customers.isEmpty()) {
	                for (CustomerInformationDto customer : customers) {
	                    if (customer.getCanBeIndividual() !=  null) {
	                        summary.setFullNM(customer.getCanBeIndividual().getFullNM());
	                        break;
	                    }
	                }
	            }

	            summary.setInsuranceProductRk(policy.getInsuranceProductRk());
	            summary.setPolicyEffectiveDTTM(policy.getPolicyEffectiveDTTM());
	            summary.setPolicyExpirationDTTM(policy.getPolicyExpirationDTTM());
	            summary.setCurrencyCD(policy.getCurrencyCD());
	            summary.setPremiumAMT(policy.getPremiumAMT());

	            summaryPolicies.add(summary);
	        }
	        
	    } else {
	        if (helpers.isLog()) _log.info("error>>" + response.getBody().getException().getMessage());
	        // Set error response
	        ResponseTransaksiKeseluruhanDto errorResponse = new ResponseTransaksiKeseluruhanDto();
	        errorResponse.setResponseCode(response.getStatusCode());
	        errorResponse.setDatas(new ArrayList<PolicySummaryDto>()); //set data null / [] if error transaction
	        
	        errorResponse.setStatusMessage(response.getBody().getException().getMessage());
	        return errorResponse;
	    }

	    // Prepare the final response
	    ResponseTransaksiKeseluruhanDto finalResponse = new ResponseTransaksiKeseluruhanDto();
	    finalResponse.setResponseCode(response.getStatusCode());
	    finalResponse.setStatusMessage("Success");
	    finalResponse.setTotalData(totalData);
	    finalResponse.setDatas(summaryPolicies);

	    return finalResponse;
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
			agencyBinderNo = Validator
					.isNull(response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO()) == true ? ""
							: response.getBody().getPolicy().getHasPartyDetailsIn().get(0).getPartyNO();
		}

		return agencyBinderNo;
	}

	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
