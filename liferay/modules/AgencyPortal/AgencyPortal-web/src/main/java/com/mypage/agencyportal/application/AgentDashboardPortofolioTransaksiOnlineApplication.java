package com.mypage.agencyportal.application;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.helpers.CorsFilterHelper;
import com.mypage.agencyportal.helpers.EncryptionHelper;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.portlet.PortletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/portofolio-transaction-online",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=AgentDashboardPortofolioTransaksiOnlineApplication.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
public class AgentDashboardPortofolioTransaksiOnlineApplication extends Application {
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();
		return Collections.<Object>singleton(this);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(CorsFilterHelper.class);

		return classes;
	}

	@GET
	@Path("/show")
	@Produces("application/json")
	public String showAction(@QueryParam("a") String params) throws PortletException, IOException {
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		try {
			EncryptionHelper encryptionHelper = new EncryptionHelper();
			String _secureToken = EncryptionHelper.generateSecureToken(32);
			@SuppressWarnings("static-access")
			String param = encryptionHelper.decrypt(params);
			String[] paramSplit = param.split("\\|");
			String deptCode = paramSplit[1];
			AgentToken _agentToken = _agentTokenLocalService.getAgentTokenByDeptCode(deptCode);
			
			if (!Validator.isNull(_agentToken)) {
				long agentTokenId = _agentToken.getAgentTokenId();
				_agentToken = _agentTokenLocalService.editAgentToken(agentTokenId, deptCode, _secureToken, 1);
			} else {
				_agentToken = _agentTokenLocalService.addAgentToken(deptCode, _secureToken, 1);
			}

			System.out.println("_secureToken liferay  >>" + _secureToken);
			
			@SuppressWarnings("static-access")
			String token = encryptionHelper.encrypt(_secureToken);
			
			System.out.println("token PIMCORE >>" + token);

			_data.put("Token", token);
			_response.put("Status", 1);
			_response.put("Data", _data);
			

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return _response.toString();
	}

	@Reference
	private AgentTokenLocalService _agentTokenLocalService;
}
