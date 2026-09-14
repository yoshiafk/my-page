package com.mypage.asmik.portlet.action;

import com.google.gson.Gson;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.mypage.asmik.constants.AsmikPersonalAccidentPortletKeys;
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

@Component(immediate = true, property = { "javax.portlet.name=" + AsmikPersonalAccidentPortletKeys.ASMIK_PERSONAL_ACCIDENT,
"mvc.command.name=/data/asmik/pa" }, service = MVCResourceCommand.class)
public class AsmikPersonalAccidentMVCResourceCommand extends BaseMVCResourceCommand {
	
	@Reference
	private EIP _eip;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

		JSONObject _response = JSONFactoryUtil.createJSONObject();
		String payload = "";
		
		ParamUtil.print(resourceRequest);

		String _cat = ParamUtil.get(httpRequest, "cat", "");
		String _type = ParamUtil.get(httpRequest, "type", "");
		
		// Personal Accident
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

}
