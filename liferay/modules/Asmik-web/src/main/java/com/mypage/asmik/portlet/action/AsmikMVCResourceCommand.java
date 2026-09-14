package com.mypage.asmik.portlet.action;

import com.google.gson.Gson;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.asmik.constants.AsmikPortletKeys;
import com.mypage.asmik.constants.EIPOperation;
import com.mypage.asmik.misc.EIP;
import com.mypage.asmik.model.DetailsRecord;
import com.mypage.asmik.model.EIPCanHave;
import com.mypage.asmik.model.EIPHasDetailsOfRisksIn;
import com.mypage.asmik.model.EIPHasNameValue;
import com.mypage.asmik.model.EIPHaveCommunicatedMessage;
import com.mypage.asmik.model.EIPResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + AsmikPortletKeys.ASMIK,
		"mvc.command.name=/data/asmik" }, service = MVCResourceCommand.class)

public class AsmikMVCResourceCommand extends BaseMVCResourceCommand {
	
	@Reference
	private EIP _eip;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

		JSONObject _response = JSONFactoryUtil.createJSONObject();
		String payload = "";
		
		
//		ParamUtil.print(httpRequest);

		String _cat = ParamUtil.get(httpRequest, "cat", "");
		String _type = ParamUtil.get(httpRequest, "type", "");
		
		// MV
		if(_cat.equals("mv")) {
			int _vehicleType = ParamUtil.get(httpRequest, "vehicleType", 0);
			int _duration = ParamUtil.get(httpRequest, "duration", 0); // tenor
			long _sumInsured = ParamUtil.get(httpRequest, "sumInsured", 0L);
			int _age = ParamUtil.get(httpRequest, "age", 0);
			int _zone = ParamUtil.get(httpRequest, "zone", 0);

			if (_type.equals("MasterKendaraan") || _type.equals("MasterZona") || _type.equals("MasterPeriod")) {
				if (_type.equals("MasterKendaraan")) {
					payload = _eip.createPayloadMV(EIPOperation.MV_GET_MASTER_KENDARAAN, _duration, _sumInsured, _age,
							_vehicleType, _zone);
				}
				if (_type.equals("MasterZona")) {
					payload = _eip.createPayloadMV(EIPOperation.MV_GET_MASTER_ZONA, _duration, _sumInsured, _age,
							_vehicleType, _zone);
				}
				if (_type.equals("MasterPeriod")) {
					payload = _eip.createPayloadMV(EIPOperation.MV_GET_MASTER_PERIOD, _duration, _sumInsured, _age,
							_vehicleType, _zone);
				}

				JSONObject responseapi = _eip.callAPI(payload);

				EIPResponse eipResponse = new Gson().fromJson(responseapi.get("response").toString(), EIPResponse.class);
				List<EIPCanHave> canHave = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getCanHave();

				List<Object> _listForResponse = new ArrayList<>();
				for (EIPCanHave _canHave : canHave) {
					if (_canHave.getPlanNotationTxt().trim().equals("--Choose--")) {
						continue;
					}

					Map<String, String> _map = new HashMap<>();
					_map.put("key", _canHave.getKey());
					_map.put("text", _canHave.getPlanNotationTxt());
					_listForResponse.add(_map);
				}

				_response.put("status", true);
				_response.put("data", _listForResponse);

				resourceResponse.flushBuffer();
				resourceResponse.getWriter().write(_response.toString());

			}

			if (_type.equals("RateMV")) {
				payload = _eip.createPayloadMV(EIPOperation.MV_GET_RATE, _duration, _sumInsured, _age, _vehicleType, _zone);
				JSONObject responseapi = _eip.callAPI(payload);
				
				EIPResponse eipResponse = new Gson().fromJson(responseapi.get("response").toString(), EIPResponse.class);

				Map<String, Object> _mapForResponse = new HashMap<>();

				String premiumAMT = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getPremiumAMT();
				_mapForResponse.put("Premi", Long.valueOf(premiumAMT));

				List<EIPHasNameValue> hasNameValue = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0)
						.getHasNameValue();
				for (EIPHasNameValue _hasNameValue : hasNameValue) {
					if (_hasNameValue.getName().equals("RateTLO")) {
						_mapForResponse.put("RateTLO", _hasNameValue.getValue());
					}

					if (_hasNameValue.getName().equals("RateRSCC")) {
						_mapForResponse.put("RateRSCC", _hasNameValue.getValue());
					}
					
					/**
					 * ENHANCE 
					 */
					if (_hasNameValue.getName().equals("RateEQ_T")) {
						_mapForResponse.put("RateEQ_T", _hasNameValue.getValue());
					}
					
					if (_hasNameValue.getName().equals("RateSRCC_T")) {
						_mapForResponse.put("RateSRCC_T", _hasNameValue.getValue());
					}
					
					if (_hasNameValue.getName().equals("RateSRCC_TS")) {
						_mapForResponse.put("RateSRCC_TS", _hasNameValue.getValue());
					}
					
					if (_hasNameValue.getName().equals("RateFlood_T")) {
						_mapForResponse.put("RateFlood_T", _hasNameValue.getValue());
					}
				}
				
				System.out.println("data _mapForResponse >> " + _mapForResponse);
				
				EIPHaveCommunicatedMessage haveCommunicatedMessage = eipResponse.getBody().getCustomer().getHaveCommunicatedMessage().get(0);
				
				if(Boolean.valueOf(haveCommunicatedMessage.getDeliveryStatusCD()) != true) {
					_response.put("status", false);
					System.out.println("status false");
				} else {
					_response.put("status", true);
					System.out.println("status true");
				}
				
				_response.put("message", haveCommunicatedMessage.getDeliveryStatusDesc());
				
				_response.put("data", _mapForResponse);
				resourceResponse.getWriter().write(_response.toString());
			}
		}
		
		// PERSONAL ACCIDENT
		if(_cat.equals("pa")) {
			int _duration = ParamUtil.get(httpRequest, "tenor", 0); // tenor
			long _sumInsured = ParamUtil.get(httpRequest, "sumInsured", 0L);
			
			// Periode / Tenor
			if (_type.equals("PeriodePA")) {
				payload = _eip.createPayloadPA(EIPOperation.PA_GET_PERIODE, _duration, _sumInsured);
//				System.out.println(payload);
//				System.out.println("--------------------------------------------------");
				
				JSONObject responseapi = _eip.callAPI(payload);
				EIPResponse eipResponse = new Gson().fromJson(responseapi.get("response").toString(), EIPResponse.class);
//				System.out.println(responseapi);
				
				List<EIPCanHave> canHave = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getCanHave();

				List<Object> _listForResponse = new ArrayList<>();
				for(EIPCanHave _canhave : canHave) {
					Map<String, Object> _mapForResponse = new HashMap<>();
					_mapForResponse.put("key", Integer.valueOf(_canhave.getPlanNotationTxt()));
					_mapForResponse.put("text", _canhave.getPlanNotationTxt());
					_listForResponse.add(_mapForResponse);
				}
				
				_response.put("status", true);
				_response.put("data", _listForResponse);
				
			}
			
			if (_type.equals("RatePA")) {
				payload = _eip.createPayloadPA(EIPOperation.PA_GET_RATE, _duration, _sumInsured);
//				System.out.println(payload);
//				System.out.println("--------------------------------------------------");
				
				JSONObject responseapi = _eip.callAPI(payload);
				EIPResponse eipResponse = new Gson().fromJson(responseapi.get("response").toString(), EIPResponse.class);
//				System.out.println(responseapi);
				
				Map<String, Object> _mapForResponse = new HashMap<>();
				
				List<EIPHasNameValue> hasNameValue = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0)
						.getHasNameValue();
				for (EIPHasNameValue _hasNameValue : hasNameValue) {
					if (_hasNameValue.getName().equals("magiRate")) {
						_mapForResponse.put("Magi_Rate", _hasNameValue.getValue());
					}

					if (_hasNameValue.getName().equals("amfsRate")) {
						_mapForResponse.put("AMFS_Rate", _hasNameValue.getValue());
					}
				}
				
				EIPHaveCommunicatedMessage haveCommunicatedMessage = eipResponse.getBody().getCustomer().getHaveCommunicatedMessage().get(0);
				
				if(Boolean.valueOf(haveCommunicatedMessage.getDeliveryStatusCD()) != true) {
					_response.put("status", false);
				} else {
					_response.put("status", true);
				}
				_response.put("data", _mapForResponse);				
			}
		
		resourceResponse.getWriter().write(_response.toString());			
		}
		
		// FIRE
		if(_cat.equals("fire")) {
			if (_type.equals("MasterFire")) {
				payload = _eip.createPayloadFIRE(EIPOperation.FIRE_GET_MASTER_FIRE, "", "", "", "", "");
				
				JSONObject responseapi = _eip.callAPI(payload);
				EIPResponse eipResponse = new Gson().fromJson(responseapi.get("response").toString(), EIPResponse.class);
				
				Gson gson = new Gson();
		        String json = gson.toJson(eipResponse);
		        System.out.println("eipResponse>>" + json);
				
				Map<String, Object> _responseMap = new HashMap<String, Object>();
				
				// HasDetailsOfRisksIn / Kelas konstruksi
				List<Object> _kelasList = new ArrayList<>();
				
				List<EIPHasDetailsOfRisksIn> hasDetailsOfRisksIn = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getHasDetailsOfRisksIn();
				for(EIPHasDetailsOfRisksIn _hasDetailsOfRisksIn : hasDetailsOfRisksIn) {
					
					if(_hasDetailsOfRisksIn.getStdOccupationCd().trim().equals("--Choose--")) {
						continue;
					}
					
					Map<String, String> _kelasMap = new HashMap<String, String>();
					
					int _kelasVal = 0;
					String _kelasName = "";
					
					if(_hasDetailsOfRisksIn.getStdOccupationCd().equals("Class_1")) {
						_kelasVal = 1;
						_kelasName = "Kelas 1";
					} else if(_hasDetailsOfRisksIn.getStdOccupationCd().equals("Class_2")) {
						_kelasVal = 2;
						_kelasName = "Kelas 2";
					} else if (_hasDetailsOfRisksIn.getStdOccupationCd().equals("Class_3")) {
						_kelasVal = 3;
						_kelasName = "Kelas 3";
					}
					
					_kelasMap.put("name", _kelasName);
					_kelasMap.put("value", String.valueOf(_kelasVal));
					_kelasMap.put("code", _hasDetailsOfRisksIn.getStdOccupationCd());
					_kelasMap.put("description", _hasDetailsOfRisksIn.getAgrRk());
					
					_kelasList.add(_kelasMap);
				}
				
				_responseMap.put("constructionClass", _kelasList);
				
				// HasDetailsRecordIn / Okupansi
				List<Object> _okupansiList = new ArrayList<>();
				
				List<List<DetailsRecord>> hasDetailsRecordIn = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getHasDetailsRecordIn();
				
				for(List<DetailsRecord> _hasDetailsRecordIn : hasDetailsRecordIn) {
					for(DetailsRecord __hasDetailsRecord : _hasDetailsRecordIn) {
						
//						if(__hasDetailsRecord.getAccountNo().trim().equals("")) {
						if(__hasDetailsRecord.getAccountNo().trim().equals("--Choose--")) {
							continue;
						}
						
						Map<String, String> _okupansiMap = new HashMap<String, String>();
						_okupansiMap.put("key", __hasDetailsRecord.getKey());
						_okupansiMap.put("name", __hasDetailsRecord.getAccountNo());
						_okupansiMap.put("description", __hasDetailsRecord.getAccountValue());
						
						_okupansiList.add(_okupansiMap);
					}
				}
				
				_responseMap.put("occupancy", _okupansiList);
				
				// CanHave / Tenor
				List<Object> _tenorList = new ArrayList<>();
				List<EIPCanHave> canHave = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getCanHave();
				
				for (EIPCanHave _canHave : canHave) {
					if (_canHave.getPlanNotationTxt().trim().equals("--Choose--")) {
						continue;
					}

					Map<String, String> _tenorMap = new HashMap<>();
					_tenorMap.put("key", _canHave.getPlanNotationTxt());
					_tenorMap.put("text", _canHave.getPlanNotationTxt());
					_tenorList.add(_tenorMap);
				}
				
				_responseMap.put("tenor", _tenorList);

				
				/**
				 * @author Muhammad Baharuddin
				 *VERSI 2 SETELAH UPDATE API ASMIK
				 *
				 *ENHANCE BENEFIT OPTION
				 */
				
				// nameValue
				List<Object> _jenisPertanggunganList = new ArrayList<>();
				List<EIPHasNameValue> jenisPertanggungans = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getHasNameValue();
				
				for (EIPHasNameValue jp : jenisPertanggungans) {
					if (jp.getName().trim().equals("--Choose--")) {
						continue;
					}

					Map<String, String> _jenisPertanggunganListMap = new HashMap<>();
					_jenisPertanggunganListMap.put("key", jp.getName());
					_jenisPertanggunganListMap.put("text", jp.getValue());
					_jenisPertanggunganList.add(_jenisPertanggunganListMap);
				}
				
				_responseMap.put("jenisPertanggungan", _jenisPertanggunganList);
				
				
				_response.put("status", true);
				_response.put("data", _responseMap);
				resourceResponse.getWriter().write(_response.toString());
			}
			
			if (_type.equals("RateFire")) {
				
				String tenor = ParamUtil.getString(httpRequest, "tenor", "");
//				int tenor = ParamUtil.getInteger(httpRequest, "tenor", 0);
//				long pertanggungan = ParamUtil.getLong(httpServletRequest, "pertanggungan", 0L);
				String pertanggungan = ParamUtil.getString(httpRequest, "pertanggungan", "");
				String kelas = ParamUtil.getString(httpRequest, "kelas", "");
				String jenisPertanggungan = ParamUtil.getString(httpRequest, "jenis_pertanggungan", "");
				String harga = ParamUtil.getString(httpRequest, "harga", "");
				
				// Hilangkan semua spasi (termasuk di tengah-tengah)
//				jenisPertanggungan = jenisPertanggungan.replaceAll("\\s+", "");
				
				payload = _eip.createPayloadFIRE(EIPOperation.FIRE_GET_RATE_FIRE, tenor, pertanggungan, kelas, jenisPertanggungan, harga);
				
				System.out.println("payload fire rate>>"+ payload);
//				System.out.println("--------------------------------------------------");
				
				JSONObject responseapi = _eip.callAPI(payload);
				EIPResponse eipResponse = new Gson().fromJson(responseapi.get("response").toString(), EIPResponse.class);
//				System.out.println(responseapi);
				
				Map<String, Object> _mapForResponse = new HashMap<>();
				
				String premiumAMT = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getPremiumAMT();
				_mapForResponse.put("Premi", String.valueOf(premiumAMT));
				
				String rate = eipResponse.getBody().getCustomer().getHasPolicyAccount().get(0).getPremiumIndexRt();
				_mapForResponse.put("Rate", String.valueOf(rate));
				
				_response.put("data", _mapForResponse);
				
				System.out.println("rate >> " + _mapForResponse);
				
				resourceResponse.getWriter().write(_response.toString());
			}
		}
	}
}

