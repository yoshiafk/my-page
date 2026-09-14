package com.mypage.asmik.portlet.action;

import com.google.gson.Gson;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.asmik.constants.AsmikMVPortletKeys;
import com.mypage.asmik.constants.EIPOperation;
import com.mypage.asmik.misc.EIP;
import com.mypage.asmik.model.EIPCanHave;
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

@Component(immediate = true, property = { "javax.portlet.name=" + AsmikMVPortletKeys.ASMIK_MV,
"mvc.command.name=/data/asmik/mv" }, service = MVCResourceCommand.class)
public class AsmikMVMVCResourceCommand extends BaseMVCResourceCommand {
	
	@Reference
	private EIP _eip;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

		JSONObject _response = JSONFactoryUtil.createJSONObject();
		
		ParamUtil.print(resourceRequest);
		
		String payload = "";

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
				}
				
				EIPHaveCommunicatedMessage haveCommunicatedMessage = eipResponse.getBody().getCustomer().getHaveCommunicatedMessage().get(0);
				
				if(Boolean.valueOf(haveCommunicatedMessage.getDeliveryStatusCD()) != true) {
					_response.put("status", false);
				} else {
					_response.put("status", true);
				}
				_response.put("data", _mapForResponse);
				resourceResponse.getWriter().write(_response.toString());
			}			
		}
	}

}
