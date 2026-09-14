package com.axa.payment.portlet.action;

import com.axa.payment.constants.PaymentInstructionPortletKeys;
import com.axa.payment.constants.PaymentPortletKeys;
import com.axa.payment.constants.ProductPortletKeys;
import com.axa.payment.helpers.ActionHelper;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ProductPortletKeys.OUT,
		"javax.portlet.name=" + PaymentPortletKeys.PAYMENT_OUT,
		"javax.portlet.name=" + PaymentInstructionPortletKeys.PAYMENT_INSTRUCTION_OUT,
		"mvc.command.name=/auth/out"
	},
	service = MVCResourceCommand.class
)
public class SignoutMVCResourceCommand extends BaseMVCResourceCommand {
	private static ActionHelper helper = new ActionHelper();
	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		HttpSession session = httpRequest.getSession();
		String policyNo = (String) session.getAttribute("POLICY_NUMBER");
		String profileId = (String) session.getAttribute("PROFILE_ID");
		
		if (Validator.isNotNull(policyNo) == true && Validator.isNotNull(profileId) == true) {
			session.invalidate();
		}
		
		_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay") : "/signin-smartpay");
		_response.put("status", true);
		_response.put("message", "");
		_response.put("data", _data);
		resourceResponse.getWriter().write(_response.toString());
	}

}
