package com.mypage.product.pet.helpers;

import com.google.gson.Gson;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.leads.model.DetailPet;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.DetailPetLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

public class Uploader {
	private static String _PetAPIURL = "https://dev-gateway.axa.co.id/gateway/aii-eip-sit/1.0/MessagingManagementR-id-v2/1.0/messagingRest/MessagingManagementR-id-v2-general/receive/notify/general/aii";
	
	public static String createPayload(long leadId) {
		Gson gson = new Gson();
		String payload = "";
		
		long _leadId = Long.valueOf(leadId);
		
		Leads _leads = LeadsLocalServiceUtil.fetchLeads(_leadId);
		DetailPet _detailPet = DetailPetLocalServiceUtil.searchByLeadsId(_leadId);
		
		HashMap<String, Object> mainBodyPayload = new HashMap<>();
		mainBodyPayload.put("productcode", "MYINS");
		mainBodyPayload.put("partnercode", "PETINS");
		mainBodyPayload.put("holderid", "");
		mainBodyPayload.put("holdername", _leads.getName());
		mainBodyPayload.put("currency", "IDR");
		mainBodyPayload.put("refno", "");
		mainBodyPayload.put("regno", "");
		
		SimpleDateFormat _dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		String policyStartDateFormatted = _dateFormatter.format(_leads.getPolicyStartDate());
		String policyEndDateFormatted = _dateFormatter.format(_leads.getPolicyEndDate());
		
		mainBodyPayload.put("inception", policyStartDateFormatted);
		mainBodyPayload.put("expiry", policyEndDateFormatted);
		mainBodyPayload.put("MO", "Nopal Sidauruk");
		
		HashMap<String, Object> bodyinsured = new HashMap<>();
		bodyinsured.put("insuredname", _leads.getName());
		String insuredBirthdateFormatted = _dateFormatter.format(_leads.getDob());
		bodyinsured.put("birthdate", insuredBirthdateFormatted);
		bodyinsured.put("birthplace", _leads.getBirthPlace());
		bodyinsured.put("email", "");
//		bodyinsured.put("address", "TANGERANG, BANTEN 15144");
		bodyinsured.put("address", _leads.getAddress() + " " + _leads.getZip());
		bodyinsured.put("citizen", "INDONESIA");
		bodyinsured.put("gender", _leads.getGender());
		bodyinsured.put("ktp", _leads.getIdNumber());
		bodyinsured.put("paspor", "");
		bodyinsured.put("npwp", "");
		bodyinsured.put("marital_status", "");
		bodyinsured.put("mobilephone", _leads.getMobilePhone());
		bodyinsured.put("employment", "");
		
		mainBodyPayload.put("insured", bodyinsured);
		
		// objinfo
		HashMap<String, Object> bodyObjInfo = new HashMap<>();
		bodyObjInfo.put("type", !Validator.isBlank(_detailPet.getPetType()) ? _detailPet.getPetType().toUpperCase() : "");
		bodyObjInfo.put("petname", _detailPet.getPetName());
		
		LocalDate localDateFromDb = _detailPet.getPetDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate currentDate = LocalDate.now();
		
		int yearsDifference = Period.between(localDateFromDb, currentDate).getYears();
		int monthDifference = Period.between(localDateFromDb, currentDate).getMonths();
		
		bodyObjInfo.put("petage", yearsDifference + " TAHUN " + monthDifference + " BULAN");
		bodyObjInfo.put("certificateno", _detailPet.getPetIdNumber());
		bodyObjInfo.put("locationaddr", _detailPet.getPetLocation());
		bodyObjInfo.put("locationzipcd", _leads.getZip());
		bodyObjInfo.put("brand", "");
		bodyObjInfo.put("model", "");
		bodyObjInfo.put("submodel", "");
		bodyObjInfo.put("manufacturing", "");
		bodyObjInfo.put("lisenceno", "");
		bodyObjInfo.put("machineno", "");
		bodyObjInfo.put("chasisno", "");
		bodyObjInfo.put("function", "");
		bodyObjInfo.put("seat", "");
		bodyObjInfo.put("color", "");
		bodyObjInfo.put("stnk", "");
		bodyObjInfo.put("cubiccapacity", "");
		bodyObjInfo.put("addequipment", "");
		bodyObjInfo.put("destination", "");
		bodyObjInfo.put("plan", "");
		bodyObjInfo.put("numofchildren", "");
		bodyObjInfo.put("numofadults", "");
		
		mainBodyPayload.put("objinfo", bodyObjInfo);
		
		// main
		HashMap<String, Object> bodyMain = new HashMap<>();
		bodyMain.put("coveragecode", "PET-01");
		bodyMain.put("coverageremark", "Death and Permanent Disability");
		bodyMain.put("rate", "149915");
		bodyMain.put("coveragesdate", "");
		bodyMain.put("coverageedate", "");
		bodyMain.put("pcalc", "F");
		bodyMain.put("unit", "F");
		bodyMain.put("interestcode", "A02");
		bodyMain.put("interestremark", "Kematian Dan Cacat Tetap Total");
		bodyMain.put("suminsured", "15000000");
		bodyMain.put("currency", "IDR");
		
		mainBodyPayload.put("main", bodyMain);
		
		//add coverage
		List<Map<String, Object>> addCoverageList = new ArrayList<>();
		HashMap<String, Object> addCoverageMap1 = new HashMap<>();
		addCoverageMap1.put("coveragecode", "");
		addCoverageMap1.put("coverageremark", "");
		addCoverageMap1.put("coveragesdate", "");
		addCoverageMap1.put("coverageedate", "");
		addCoverageMap1.put("rate", "");
		addCoverageMap1.put("unit", "");
		addCoverageMap1.put("pcalc", "");
		
		addCoverageList.add(addCoverageMap1);
		mainBodyPayload.put("addcoverage", addCoverageList);
		
		// addinterest
		List<Map<String, Object>> addInterestList = new ArrayList<>();
		HashMap<String, Object> addInterestMap1 = new HashMap<>();
		addInterestMap1.put("interestcode", "C19");
		addInterestMap1.put("interestremark", "Biaya Pengobatan Hewan");
		addInterestMap1.put("suminsured", "2500000");
		addInterestMap1.put("currency", "IDR");
		
		addInterestList.add(addInterestMap1);
		
		HashMap<String, Object> addInterestMap2 = new HashMap<>();
		addInterestMap2.put("interestcode", "P04");
		addInterestMap2.put("interestremark", "Tanggung Jawab Hukum Pihak Ketiga");
		addInterestMap2.put("suminsured", "4000000");
		addInterestMap2.put("currency", "IDR");
		
		addInterestList.add(addInterestMap2);
		
		HashMap<String, Object> addInterestMap3 = new HashMap<>();
		addInterestMap3.put("interestcode", "P32");
		addInterestMap3.put("interestremark", "Biaya Tambahan Penitipan Hewan");
		addInterestMap3.put("suminsured", "1500000");
		addInterestMap3.put("currency", "IDR");
		
		addInterestList.add(addInterestMap3);
		
		mainBodyPayload.put("addinterest", addInterestList);
		
		// member
		List<Map<String, Object>> memberList = new ArrayList<>();
		HashMap<String, Object> member1 = new HashMap<>();
		member1.put("fullname", "");
		member1.put("gender", "");
		member1.put("birthdate", "");
		member1.put("birthplace", "");
		member1.put("ktp", "");
		member1.put("npwp", "");
		member1.put("paspor", "");
		member1.put("relation", "");
		
		memberList.add(member1);
		
		mainBodyPayload.put("member", memberList);		
		
		
		payload = gson.toJson(mainBodyPayload);
		return payload;
	}
	
	public static JSONObject callAPI(String payload) throws Exception {
		
		MypageHelpers _mypageHelpers = new MypageHelpers();
		_PetAPIURL = _mypageHelpers.getConfig("com.mypage.product.pet.config.petCareAPIUrl");
		
		Gson gson = new Gson();
		JSONObject _response = JSONFactoryUtil.createJSONObject();
        String line = StringPool.BLANK;
        StringBuilder responseBody = new StringBuilder();
        int responseCode = 0;
        
        try {
        	URL requestUrl = new URL(_PetAPIURL);
            HttpsURLConnection connection = (HttpsURLConnection) requestUrl.openConnection();
            
//            connection.setHostnameVerifier(new HostnameVerifier() {
//				@Override
//				public boolean verify(String requestedHost, SSLSession remoteServerSession) {
//					return requestedHost.equalsIgnoreCase(remoteServerSession.getPeerHost());
//				}
//			});
//            
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init((KeyStore) null);
//            
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
//            
//            connection.setSSLSocketFactory(sslContext.getSocketFactory());
            
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Cookie", "5305402e0cd0554b91f514292f4fd836=26f9fa68f15e1274e80286b69a50b75f; d4a80cebe50a50bd699bc853f924e95e=65e3e5bbcd11f4aaaf081b9a79fe52f1");
            
            connection.setDoOutput(true);
            
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(payload.getBytes());
            outputStream.flush();
            outputStream.close();
            
            System.out.println(connection.getResponseCode());
            
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
            
//		} catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
        } catch (IOException e) {
			e.printStackTrace();
		}
        
		_response.put("statusCode", responseCode);
		_response.put("response", responseBody.toString());
		
		return _response;
	}
}
