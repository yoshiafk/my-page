package com.mypage.asmik.misc;

import com.google.gson.Gson;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsUtil;
import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalService;
import com.mypage.asmik.constants.EIPOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Muhammad Baharuddin
 *catatan penyesuaian ubah dari props ke global variable
 *1. add annotation @Component(service = EIP.class)
 *2. function tidak boleh static karena static tidak mengiijnkan @reference 
 *3. define initial String _EIPUsername sebelum diakses 
 *4. di resource command call initial @reference class EIP, tidak lagi lagi static EIP.createPayloadMV tapi _eip.createPayloadMV
 *5. get data dari table global variable dengan group Asmik , ada 3 name URL, Username, Password 
 */
@Component(service = EIP.class)
public class EIP {
	//private static String _EIPUrl = PropsUtil.get("com.mypage.asmik.config.eipURL");
	//private static String _EIPUsername = PropsUtil.get("com.mypage.asmik.config.eipUname");
	//private static String _EIPPassword = PropsUtil.get("com.mypage.asmik.config.eipPass");
	
	
	@Reference
	private MasterGlobalVariableLocalService _masterGlobalVariableLocalService;

//	// Tambahkan cache untuk menyimpan hasil fetch pertama
//	private Map < String, String > _cachedGlobalVariables = null;
//
//	// Method untuk memuat semua variable aktif ke dalam cache
//	private void loadGlobalVariablesToCache() {
//	  if (_cachedGlobalVariables == null) {
//	    _cachedGlobalVariables = new HashMap < > ();
//	    List < MasterGlobalVariable > props = _masterGlobalVariableLocalService.getActiveGlobalVariableByGroup("Asmik");
//	    for (MasterGlobalVariable variable: props) {
//	      if (variable.getName() != null) {
//	        _cachedGlobalVariables.put(variable.getName(), variable.getValue());
//	      }
//	    }
//	    log.info("Global variables loaded into cache.");
//	  }
//	}
//
//	public String getGlobalVariableValueByName(String name) {
//	  log.info("Call function getGlobalVariableValueByName");
//
//	  loadGlobalVariablesToCache();
//
//	  // Ambil dari cache
//	  for (Map.Entry < String, String > entry: _cachedGlobalVariables.entrySet()) {
//	    if (entry.getKey().contains(name)) {
//	      log.info("Get " + name + " return >> " + entry.getValue());
//	      return entry.getValue();
//	    }
//	  }
//
//	  return "";
//	}
	
	
	 
	 public String getGlobalVariableValueByName(String name) {
//	   log.info("call function getGlobalVariableValueByName");
//
//	   log.info("total >> " + _masterGlobalVariableLocalService.getMasterGlobalVariablesCount());
	   List < MasterGlobalVariable > props = _masterGlobalVariableLocalService.getActiveGlobalVariableByGroup("Asmik");

	   for (MasterGlobalVariable masterGlobalVariable: props) {
	     if (masterGlobalVariable.getName() != null && masterGlobalVariable.getName().contains(name)) {
//	       log.info("get " + name + " return >> " + masterGlobalVariable.getValue());
	       return masterGlobalVariable.getValue();
	     }
	   }
	   return "";
	 }


	public  String createPayloadMV(String _operation, int _duration, long _sumInsured, int _age, int vehicleType, int _zone ) {
		Gson gson = new Gson();
		String payload = "";
		
		String _EIPUsername = getGlobalVariableValueByName("Username");
        String _EIPPassword = getGlobalVariableValueByName("Password");
		
		// Content of header
		HashMap<String, String> securityContext = new HashMap<>();
		securityContext.put("username", _EIPUsername);
		securityContext.put("password", _EIPPassword);

		// Header
		HashMap<String, Object> headerPayload = new HashMap<>();
		headerPayload.put("SecurityContext", securityContext);

		// Content of customers in body
		HashMap<String, Object> customerPayload = new HashMap<>();

		// END DATE
		if (_operation.equals(EIPOperation.MV_GET_END_DATE)) {

		}

		// MAX AGE
		if (_operation.equals(EIPOperation.MV_GET_MAX_AGE)) {

		}

		// START DATE VALIDATION
		if (_operation.equals(EIPOperation.MV_GET_START_DATE_VALIDATION)) {

		}

		// RATE
		if (_operation.equals(EIPOperation.MV_GET_RATE)) {

			List<Map<String, Object>> hasPolicyAccountList = new ArrayList<>();

			Map<String, Object> hasPolicyAccountMap = new HashMap<>();
			hasPolicyAccountMap.put("issueTypeCD", String.valueOf(vehicleType));
			hasPolicyAccountMap.put("issueBranchCD", String.valueOf(_zone));
			hasPolicyAccountMap.put("duration", String.valueOf(_duration));

			List<Map<String, Object>> isAssociatedWithGIInsuranceProductList = new ArrayList<>();
			Map<String, Object> giInsuranceProductMap = new HashMap<>();

			List<Map<String, Object>> hasGIPolicySegmentDetailsInList = new ArrayList<>();
			Map<String, Object> gIPolicySegmentDetailsMap = new HashMap<>();
			gIPolicySegmentDetailsMap.put("sumInsured", String.valueOf(_sumInsured));

			hasGIPolicySegmentDetailsInList.add(gIPolicySegmentDetailsMap);

			giInsuranceProductMap.put("hasGIPolicySegmentDetailsIn", hasGIPolicySegmentDetailsInList);
			isAssociatedWithGIInsuranceProductList.add(giInsuranceProductMap);

			hasPolicyAccountMap.put("isAssociatedWithGIInsuranceProduct", isAssociatedWithGIInsuranceProductList);

			List<Map<String, Object>> hasDetailsOfPolicyInList = new ArrayList<>();
			Map<String, Object> detailsOfPolicyMap = new HashMap<>();
			detailsOfPolicyMap.put("requestedMaturityAge", String.valueOf(_age));

			hasDetailsOfPolicyInList.add(detailsOfPolicyMap);
			hasPolicyAccountMap.put("hasDetailsOfPolicyIn", hasDetailsOfPolicyInList);

			hasPolicyAccountList.add(hasPolicyAccountMap);

			customerPayload.put("hasPolicyAccount", hasPolicyAccountList);
		}

		// Content of body
		HashMap<String, Object> bodyPayload = new HashMap<>();
		bodyPayload.put("transactionId", generateTransactionId(10));
		bodyPayload.put("operation", _operation);
		bodyPayload.put("appID", "CALCULATOR");
		bodyPayload.put("entity", "AII");
		bodyPayload.put("service", "getUWData");
		bodyPayload.put("Customer", customerPayload);

		// Main payload
		HashMap<String, Object> mainPayload = new HashMap<>();
		mainPayload.put("Header", headerPayload);
		mainPayload.put("Body", bodyPayload);

		payload = gson.toJson(mainPayload);

		return payload;
	}

	public  String createPayloadPA(String _operation, int _duration, long _sumInsured) {
		Gson gson = new Gson();
		String payload = "";
		
		String _EIPUsername = getGlobalVariableValueByName("Username");
        String _EIPPassword = getGlobalVariableValueByName("Password");

		// Content of header
		HashMap<String, String> securityContext = new HashMap<>();
		securityContext.put("username", _EIPUsername);
		securityContext.put("password", _EIPPassword);

		// Header
		HashMap<String, Object> headerPayload = new HashMap<>();
		headerPayload.put("SecurityContext", securityContext);

		// Content of customers in body
		HashMap<String, Object> customerPayload = new HashMap<>();

		// GET RATE
		if (_operation.equals(EIPOperation.PA_GET_RATE)) {
			List<Map<String, Object>> hasPolicyAccountList = new ArrayList<>();

			Map<String, Object> hasPolicyAccountMap = new HashMap<>();
			hasPolicyAccountMap.put("duration", String.valueOf(_duration));

			List<Map<String, Object>> isAssociatedWithGIInsuranceProductList = new ArrayList<>();
			Map<String, Object> giInsuranceProductMap = new HashMap<>();

			List<Map<String, Object>> hasGIPolicySegmentDetailsInList = new ArrayList<>();
			Map<String, Object> gIPolicySegmentDetailsMap = new HashMap<>();
			gIPolicySegmentDetailsMap.put("sumInsured", String.valueOf(_sumInsured));

			hasGIPolicySegmentDetailsInList.add(gIPolicySegmentDetailsMap);

			giInsuranceProductMap.put("hasGIPolicySegmentDetailsIn", hasGIPolicySegmentDetailsInList);
			isAssociatedWithGIInsuranceProductList.add(giInsuranceProductMap);

			hasPolicyAccountMap.put("isAssociatedWithGIInsuranceProduct", isAssociatedWithGIInsuranceProductList);
			
			hasPolicyAccountList.add(hasPolicyAccountMap);
			customerPayload.put("hasPolicyAccount", hasPolicyAccountList);			
		}
		
		// Content of body
		HashMap<String, Object> bodyPayload = new HashMap<>();
		bodyPayload.put("transactionId", generateTransactionId(10));
		bodyPayload.put("operation", _operation);
		bodyPayload.put("appID", "CALCULATOR");
		bodyPayload.put("entity", "AII");
		bodyPayload.put("service", "getUWData");
		bodyPayload.put("Customer", customerPayload);

		// Main payload
		HashMap<String, Object> mainPayload = new HashMap<>();
		mainPayload.put("Header", headerPayload);
		mainPayload.put("Body", bodyPayload);

		payload = gson.toJson(mainPayload);

		return payload;		
	}
	
	public  String createPayloadFIRE(String _operation, String tenor, String pertanggungan, String kelas, String jenisPertanggungan, String harga) {
		Gson gson = new Gson();
		String payload = "";

		String _EIPUsername = getGlobalVariableValueByName("Username");
        String _EIPPassword = getGlobalVariableValueByName("Password");
		
		// Content of header
		HashMap<String, String> securityContext = new HashMap<>();
		securityContext.put("username", _EIPUsername);
		securityContext.put("password", _EIPPassword);

		// Header
		HashMap<String, Object> headerPayload = new HashMap<>();
		headerPayload.put("SecurityContext", securityContext);

		// Content of customers in body
		HashMap<String, Object> customerPayload = new HashMap<>();
		
		if (_operation.equals(EIPOperation.FIRE_GET_MASTER_FIRE)) {
		}
		
		if(_operation.equals(EIPOperation.FIRE_GET_RATE_FIRE)) {
	        List<Map<String, Object>> hasPolicyAccountList = new ArrayList<>();
	        Map<String, Object> hasPolicyAccountMap = new HashMap<>();
	        hasPolicyAccountMap.put("duration", tenor);

	        List<Map<String, Object>> hasDetailsOfRisksInList = new ArrayList<>();
	        Map<String, Object> hasDetailsOfRisksInMap = new HashMap<>();
	        hasDetailsOfRisksInMap.put("partyRk", jenisPertanggungan);
	        hasDetailsOfRisksInMap.put("occupationClassCd", kelas);
	        hasDetailsOfRisksInMap.put("stdOccupationCd", pertanggungan);
	        hasDetailsOfRisksInList.add(hasDetailsOfRisksInMap);

	        hasPolicyAccountMap.put("hasDetailsOfRisksIn", hasDetailsOfRisksInList);

//	        List<Map<String, Object>> isAssociatedWithGIInsuranceProductList = new ArrayList<>();
//	        Map<String, Object> isAssociatedWithGIInsuranceProductMap = new HashMap<>();
//	        isAssociatedWithGIInsuranceProductMap.put("sumInsured", harga);
//	        isAssociatedWithGIInsuranceProductList.add(isAssociatedWithGIInsuranceProductMap);
	        
	        List<Map<String, Object>> isAssociatedWithGIInsuranceProduct = new ArrayList<>();
	        Map<String, Object> associatedProduct = new HashMap<>();
	        List<Map<String, Object>> hasGIPolicySegmentDetailsIn = new ArrayList<>();
	        Map<String, Object> policySegmentDetails = new HashMap<>();
	        policySegmentDetails.put("sumInsured", harga);
	        hasGIPolicySegmentDetailsIn.add(policySegmentDetails);
	        associatedProduct.put("hasGIPolicySegmentDetailsIn", hasGIPolicySegmentDetailsIn);
	        isAssociatedWithGIInsuranceProduct.add(associatedProduct);

	        hasPolicyAccountMap.put("isAssociatedWithGIInsuranceProduct", isAssociatedWithGIInsuranceProduct);

	        hasPolicyAccountList.add(hasPolicyAccountMap);
	        customerPayload.put("hasPolicyAccount", hasPolicyAccountList);
		}
		
		// Content of body
		HashMap<String, Object> bodyPayload = new HashMap<>();
		bodyPayload.put("transactionId", generateTransactionId(10));
		bodyPayload.put("operation", _operation);
		bodyPayload.put("appID", "CALCULATOR");
		bodyPayload.put("entity", "AII");
		bodyPayload.put("service", "getUWData");
		bodyPayload.put("Customer", customerPayload);

		// Main payload
		HashMap<String, Object> mainPayload = new HashMap<>();
		mainPayload.put("Header", headerPayload);
		mainPayload.put("Body", bodyPayload);

		payload = gson.toJson(mainPayload);

		return payload;
	}	
	
	/**
	 * Call API
	 */
	public  JSONObject callAPI(String payload) throws Exception {
		Gson gson = new Gson();
		JSONObject _response = JSONFactoryUtil.createJSONObject();
        String line = StringPool.BLANK;
        StringBuilder responseBody = new StringBuilder();
        int responseCode = 0;
        
		try {
			
			String _EIPUrl = getGlobalVariableValueByName("URL");
			log.info("_EIPUrl>>" + _EIPUrl);
			log.info("_EIPPayload>>" + payload);
			
			URL requestUrl = new URL(_EIPUrl);
            HttpsURLConnection connection = (HttpsURLConnection) requestUrl.openConnection();
             
//          connection.setHostnameVerifier((hostname, session) -> true);
            connection.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String requestedHost, SSLSession remoteServerSession) {
					return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
				}
			});

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {}

                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {}

                public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
            }}, new SecureRandom());
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init((KeyStore) null);
//            
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

            connection.setSSLSocketFactory(sslContext.getSocketFactory());
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(payload.getBytes());
            outputStream.flush();
            outputStream.close();
            
//            log.info(connection.getResponseCode());

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
            
            log.info("_EIPResponse>>" + responseBody.toString());
        	
//            response = gson.fromJson(responseBody.toString(), ResponseDto.class);
//            response.setStatusCode(connection.getResponseCode());
		} catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
			log.info(e.getMessage());
		}
		
		_response.put("statusCode", responseCode);
		_response.put("response", responseBody.toString());
		
		return _response;
	}
	
	/**
	 * Generate random alphanumeric for transactionId based on length
	 * 
	 * @param length
	 * @return
	 */
	private static String generateTransactionId(int length) {
		String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			sb.append(characters.charAt(randomIndex));
		}

		return sb.toString();
	}
	
	private static Log log = LogFactoryUtil.getLog(EIP.class);
}
