package com.mypage.agencyportal.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.constants.PortofolioDetailPortletKeys;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.helpers.LogHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + PortofolioDetailPortletKeys.PORTOFLIO_DETAIL_PORTLET_KEYS,
		"mvc.command.name=/data/dashboard/portofolio/detail" }, 
service = MVCResourceCommand.class)
public class PortofolioDetailResourceCommand extends BaseMVCResourceCommand {
	private static ActionHelpers helpers = new ActionHelpers();
//	private static LogHelper<Object> logs = new LogHelper<>();
	private static Log _log = LogFactoryUtil.getLog(PortofolioDetailResourceCommand.class);
	private static final String PIMCORE_HOST = helpers.getConfig("com.mypage.agent.config.pimcoreAddress");
	private static final String dashboardApiAgencyLeadsResendQuotationUrl = helpers.getConfig("dashboard.api.agency.leads.detail.resendQuotation");
	private static String apiRequestTokenRenew = StringPool.BLANK;
	private static String deptoreCode = StringPool.BLANK;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		String referenceResend = ParamUtil.getString(httpRequest, "referenceResend");
		String type = ParamUtil.getString(httpRequest, "type");
		
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
		
		String _eToken = ParamUtil.getString(httpRequest, "etoken");
		
		JSONObject payload = JSONFactoryUtil.createJSONObject();
		payload.put("Code", deptoreCode);
		payload.put("ReferenceNumber", referenceResend);
		if (type.isEmpty() == false) payload.put("Type", type);
		
		JSONObject response = ActionHelpers.hitAPI(PIMCORE_HOST + dashboardApiAgencyLeadsResendQuotationUrl, payload.toString(), _eToken);
		
		if (helpers.isLog()) _log.info(response.toString());
		
		JSONObject responseObject = JSONFactoryUtil.createJSONObject(response.get("response").toString());
		
		if (helpers.isLog()) _log.info(responseObject);
		
		if (responseObject.getInt("Status") == 0) {
			_response.put("status", false);
			_response.put("message", responseObject.getString("Message"));
			_response.put("token", apiRequestTokenRenew);
			
			resourceResponse.getWriter().write(_response.toString());
			return;
		}

		_response.put("status", true);
		_response.put("message", responseObject.getString("Message"));
		_response.put("token", apiRequestTokenRenew);
		
		resourceResponse.getWriter().write(_response.toString());
	}
	
	public static JSONObject hitAPI(String url) throws Exception {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
        String line = StringPool.BLANK;
        StringBuilder responseBody = new StringBuilder();
        int responseCode = 0;
        
		try {
			URL requestUrl = new URL(url);
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
			HttpURLConnection connection = null;

			if (requestUrl.getProtocol().equalsIgnoreCase("https")) {
				HttpsURLConnection httpsConnection = (HttpsURLConnection) requestUrl.openConnection();

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
                
//				TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//                trustManagerFactory.init((KeyStore) null);
//                
//                SSLContext sslContext = SSLContext.getInstance("TLS");
//                sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

				httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());

				connection = httpsConnection;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}
			
            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.setDoOutput(true);
            
//            OutputStream outputStream = connection.getOutputStream();
//            outputStream.flush();
//            outputStream.close();

            if (connection.getResponseCode() == 200) {
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));            
	            while ((line = bufferedReader.readLine()) != null) {
	                responseBody.append(line);
	            }
	            bufferedReader.close();
            } else {
            	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));            
	            while ((line = bufferedReader.readLine()) != null) {
	                responseBody.append(line);
	            }
	            bufferedReader.close();
            }
            
            responseCode = connection.getResponseCode();
		} catch (IOException e) {
			if (helpers.isLog()) _log.info("Failed api requests");
		}
		
		_response.put("statusCode", responseCode);
		_response.put("response", responseBody.toString());
		
		return _response;
	}
	
	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
