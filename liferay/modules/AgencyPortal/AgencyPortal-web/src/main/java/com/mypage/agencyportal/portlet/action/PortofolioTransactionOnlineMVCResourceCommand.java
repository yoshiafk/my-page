package com.mypage.agencyportal.portlet.action;

import com.google.gson.Gson;
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
import com.mypage.agencyportal.constants.AgentDashboardPortofolioTransaksiOnlinePortletKeys;
import com.mypage.agencyportal.dto.APIResponse;
import com.mypage.agencyportal.dto.DataItemDto;
import com.mypage.agencyportal.dto.DeleteResponseDto;
import com.mypage.agencyportal.dto.UserDetailAPIResponseDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import java.util.HashMap;
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
		"javax.portlet.name=" + AgentDashboardPortofolioTransaksiOnlinePortletKeys.AGENT_DASHBOARD_PORTOFOLIO_TRX_ONLINE,
		"mvc.command.name=/data/dashboard/portofolio/transaction/online" }, 
service = MVCResourceCommand.class)
public class PortofolioTransactionOnlineMVCResourceCommand extends BaseMVCResourceCommand{

	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(PortofolioTransactionOnlineMVCResourceCommand.class);
	private static final String PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
	private static final String dashboardApiAgencyLeadsUrl = helpers.getConfig("dashboard.api.agency.leads");
	private static final String dashboardApiAgencyDownloadReport = helpers.getConfig("dashboard.api.agency.download.report");
	private static final String dashboardApiAgencyLeadsDeleteUrl = helpers.getConfig("dashboard.api.agency.leads.delete");
	
	
	private static String apiRequestTokenRenew=null;
	
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
		
		//if (helpers.isLog()) _log.info("renderToken>>"+renderToken);
		//if (helpers.isLog()) _log.info("_apiRequestToken>>"+_apiRequestToken);
		
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
		
		int limit = 10; //default
		int start = ParamUtil.getInteger(httpRequest, "start");
		String _refNum = ParamUtil.getString(httpRequest, "referenceNumber");
		String _name =  ParamUtil.getString(httpRequest, "name");
		String _produk =  ParamUtil.getString(httpRequest, "products");
		String _policyType = ParamUtil.getString(httpRequest, "policyType");
		String _status = ParamUtil.getString(httpRequest, "state");
		String _startDate = ParamUtil.getString(httpRequest, "startDate");
		String _endDate = ParamUtil.getString(httpRequest, "endDate");
		String _a = ParamUtil.getString(httpRequest, "a");
		
		String encodeToken = URLEncoder.encode(_a, "UTF-8");
		
		// define param
		String ReferenceNumber = _refNum;
		String Name = _name;
		String Product = _produk;
		String PolicyType = _policyType;
		String Status = _status;
		String StartDate = _startDate;
		String EndDate = _endDate;
		
		int page = (limit != 0) ? (start / limit + 1) : 1;

		String postData = "Code=" + deptoreCode + "&Start=" + start + "&Limit=" + limit;

		if (!_refNum.isEmpty())
			postData += "&ReferenceNumber=" + ReferenceNumber;
		if (!_name.isEmpty())
			postData += "&Name=" + Name;
		if (!_produk.isEmpty() && Product.contains("multiselect-all"))
			Product = Product.replaceAll("multiselect-all,", ""); // delete multiselect-all,
		if (!_produk.isEmpty())
			postData += "&Product=" + Product;
		if (!_policyType.isEmpty())
			postData += "&PolicyType=" + PolicyType;
		if (!_status.isEmpty())
			postData += "&Status=" + Status;

		SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyyMMdd");
		
		if(dataCategory.equalsIgnoreCase("download")) {
			
			// Get last 3 months
			LocalDate startDate = LocalDate.now().minusMonths(3);
			LocalDate endDate = LocalDate.now();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("id", "ID"));
			String startDateStr = startDate.format(formatter);
			String endDateStr = endDate.format(formatter);

			// jika start date end date empty, set default startenddate 3 last month 
			String formattedStartDate = !_startDate.isEmpty() ? _startDate : startDateStr;
			String formattedEndDate = !_endDate.isEmpty() ? _endDate : endDateStr;

			Date startDateDownload = inputFormat.parse(formattedStartDate.replace("Agt", "Agu")); //format id august -> ags. once found
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
	            //conn.setRequestProperty("Content-Type", "application/json");
	            connection.setDoOutput(true);

	            try(OutputStream os = connection.getOutputStream()) {
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
			if (!_startDate.isEmpty()) {
				Date tanggalDate = inputFormat.parse(StartDate.replace("Agt", "Agu")); //format id august -> ags. once found
				String tanggalFormatted = outputFormat.format(tanggalDate);
				postData += "&StartDate=" + tanggalFormatted;
			}
			if (!_endDate.isEmpty()) {
				Date tanggalDate = inputFormat.parse(EndDate.replace("Agt", "Agu"));
				String tanggalFormatted = outputFormat.format(tanggalDate);
				postData += "&EndDate=" + tanggalFormatted;
			}
			
			Gson gson = new Gson();
			
			// get leads
			URI uriLeads = new URI(PIMCORE_HOST + dashboardApiAgencyLeadsUrl);
			String URLleads = uriLeads.toString();
			byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
			if (helpers.isLog()) _log.info(postData);
			APIResponse<DataItemDto> response = helpers.APIClients(URLleads, postDataBytes, DataItemDto.class, encodeToken);
			
			if (helpers.isLog()) _log.info("ress>>>"+gson.toJson(response));
			
			if(Integer.valueOf(response.getStatus()) < 1) {
				if (helpers.isLog()) _log.info(response.getMessage());
				//return;
			}
			
			for (int i = 0; i < response.getData().size(); i++) {
				String encryptOid = EncryptionHelper.encryptRandom(String.valueOf(response.getData().get(i).getO_id()));
				
				response.getData().get(i).setTarget(encryptOid);
			}
			
			_response.put("start", start);
			_response.put("page", page);
			_response.put("totalData", response.getCount());
			_response.put("deptoreCode", deptoreCode);
			_response.put("leads", response.getData());
			_response.put("status", true);
			_response.put("message", "success");
			_response.put("token", apiRequestTokenRenew);
			_response.put("rtoken", renderToken);
			

		}
		
		if (dataCategory.equalsIgnoreCase("unpublish")) {
			String _oId = ParamUtil.getString(httpRequest, "oid");
			String[] arrOid = _oId.split(",");
			List<String> oid = new ArrayList<>();
			
			for (String item : arrOid) {
				String _item = EncryptionHelper.decrypt(item);
				String[] itemSplit = _item.split("\\|");
				oid.add(itemSplit[1]);
			}
			
			Gson gson = new Gson();
			String leadsUnpublishPayload = "";
			JSONObject leadsUnpublishResponse = JSONFactoryUtil.createJSONObject();
			
			HashMap<String, Object> _leadsUnpublishPayload = new HashMap<String, Object>();
			_leadsUnpublishPayload.put("Code", deptoreCode);
			_leadsUnpublishPayload.put("LeadsId", String.join(",", oid));
			
			leadsUnpublishPayload = gson.toJson(_leadsUnpublishPayload);
			if (helpers.isLog()) _log.info(leadsUnpublishPayload);
			
			leadsUnpublishResponse = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyLeadsDeleteUrl, leadsUnpublishPayload, encodeToken);
			
			if (helpers.isLog()) _log.info(leadsUnpublishResponse.get("response").toString());
			
			// Mengonversi respons menjadi JSONObject
			JSONObject responseJson = JSONFactoryUtil.createJSONObject(leadsUnpublishResponse.get("response").toString());

			// Mengambil status dari respons JSON
			String status = responseJson.getString("Status");
			
			if(status.equals("0")) {
				_response.put("status", false);
				_response.put("statusDelete", responseJson.getString("Status"));
				_response.put("messageDelete", responseJson.getString("Message"));
				resourceResponse.getWriter().write(_response.toString());
				return;
			}

			DeleteResponseDto leadsUnpublishAPIResponseDto = new Gson().fromJson(leadsUnpublishResponse.get("response").toString(), DeleteResponseDto.class);
			
			if (helpers.isLog()) _log.info("response"+gson.toJson(leadsUnpublishAPIResponseDto));
			
			_response.put("statusDelete", leadsUnpublishAPIResponseDto.getStatus());
			_response.put("messageDelete", leadsUnpublishAPIResponseDto.getMessage());
			_response.put("totalDelete", leadsUnpublishAPIResponseDto.getData().getTotal());
			_response.put("status", true);
		}
		
		resourceResponse.getWriter().write(_response.toString());
		
	}
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
