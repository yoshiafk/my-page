package com.axa.payment.portlet;

import com.axa.payment.constants.AuthenticationPortletKeys;
import com.axa.payment.dto.ProductSummaryDto;
import com.axa.payment.dto.eip.BodyDto;
import com.axa.payment.dto.eip.CustomerDto;
import com.axa.payment.dto.eip.PolicyAccountDto;
import com.axa.payment.dto.eip.ResponseDto;
import com.axa.payment.helpers.ActionHelper;
import com.axa.payment.helpers.EncryptionHelper;
import com.google.gson.Gson;
import com.liferay.captcha.configuration.CaptchaConfiguration;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.captcha.CaptchaConfigurationException;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Prawiranegara
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=axaPay",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Authentication SmartPay",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/auth/login/view.jsp",
		"javax.portlet.name=" + AuthenticationPortletKeys.ATH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AuthenticationPortlet extends MVCPortlet {
	private static ActionHelper helper = new ActionHelper();
	private static String pimcoreHost = helper.getConfig("com.mypage.agent.config.pimcoreHost");
	private static Log _log = LogFactoryUtil.getLog(AuthenticationPortlet.class);
	private static Gson gson = new Gson();
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		
		if (helper.isLog()) _log.info(resourceID);
			
		try {
			if (resourceID.equalsIgnoreCase("verifycaptcha")) {
				verifyCaptcha(resourceRequest, resourceResponse);
			} else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		} catch(Exception e) {
			if (helper.isLog()) _log.info(e.getMessage());
		}
	}
	
	public void verifyCaptcha(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject _response = JSONFactoryUtil.createJSONObject();
		JSONObject _data = JSONFactoryUtil.createJSONObject();
		
		String policyNo = ParamUtil.getString(httpRequest, "policyNo");
		String profileId = ParamUtil.getString(httpRequest, "profileId");
		
		if (helper.isLog()) _log.info("REQUEST PAYLOAD");
		if (helper.isLog()) _log.info(policyNo);
		if (helper.isLog()) _log.info(profileId);
		if (helper.isLog()) _log.info(ParamUtil.getString(httpRequest, "captchaText"));
		
		boolean status = true;
		String message = StringPool.BLANK;
		
		try {
			ProductSummaryDto check = _checkConnection(policyNo, profileId, httpRequest);
			
			if (Validator.isNull(check) == true) {
				_response.put("status", false);
				_response.put("message", "Koneksi Anda kurang stabil, silakan coba beberapa saat lagi.");

				resourceResponse.getWriter().write(_response.toString());
				return;
			}
			
			if (Validator.isNull(check.getFullName()) == true) {
				_response.put("status", false);
				_response.put("message", "Periksa kembali Nomor Polis dan ID Profil Anda, lalu silakan coba lagi.");

				resourceResponse.getWriter().write(_response.toString());
				return;
			}
			
			_checkCaptcha(httpRequest);

			if (helper.isLog()) _log.info("CAPTCHA verification successful.");
			
			HttpSession session = httpRequest.getSession();
        	session.setAttribute("POLICY_NUMBER", EncryptionHelper.encrypt(policyNo));
        	session.setAttribute("PROFILE_ID", EncryptionHelper.encrypt(profileId));
        	
        	if (helper.isLog()) _log.info("SESSION ID: " + session.getId());
        	if (helper.isLog()) _log.info(session.getAttribute("POLICY_NUMBER"));
    		if (helper.isLog()) _log.info(session.getAttribute("PROFILE_ID"));
    		
    		_data.put("target", helper.getMode().equalsIgnoreCase("prod") ? pimcoreHost.concat("/smartpay/product") : "/product-summary-smartpay");
    		_response.put("data", _data);
        } catch (Exception e) {
        	if (helper.isLog()) _log.info(e.getMessage());
        	if (e instanceof CaptchaException) {
        		if (helper.isLog()) _log.info(e.getMessage());
			}
        	if (e instanceof CaptchaConfigurationException) {
        		if (helper.isLog()) _log.info(e.getMessage());
			}
        	if (helper.isLog()) _log.info("CAPTCHA verification failed.");
        	
        	status = false;
			message = "Maaf Verifikasi Teks Anda tidak sesuai";
        }
		
		_response.put("status", status);
		_response.put("message", message);
		resourceResponse.getWriter().write(_response.toString());
	}
	
	protected CaptchaConfiguration getCaptchaConfiguration()
		throws CaptchaConfigurationException {

		try {
			return _configurationProvider.getSystemConfiguration(
				CaptchaConfiguration.class);
		}
		catch (Exception exception) {
			throw new CaptchaConfigurationException(exception);
		}
	}

	private void _checkCaptcha(HttpServletRequest httpServletRequest)
		throws CaptchaConfigurationException, CaptchaException {

		CaptchaConfiguration captchaConfiguration = getCaptchaConfiguration();

		if (captchaConfiguration.sendPasswordCaptchaEnabled()) {
			CaptchaUtil.check(httpServletRequest);
		}
	}
	
	protected ProductSummaryDto _checkConnection(String policyNo, String profileId, HttpServletRequest httpRequest) throws Exception {
		CustomerDto bodyCustomer = new CustomerDto();
		List<PolicyAccountDto> bodyPolicies = new ArrayList<PolicyAccountDto>();
		PolicyAccountDto bodyPolicy = new PolicyAccountDto();
		ProductSummaryDto productSummary = new ProductSummaryDto();
		
		String bodyOperation = "getPolicyDetail";
		String bodyService = "getPolicyDetails";
		
		BodyDto requestBody = helper.setupRequestBody(bodyOperation, bodyService);
		
		bodyPolicy.setPolicyNO(policyNo);
		bodyPolicy.setAccountNo(profileId);
		bodyPolicies.add(bodyPolicy);
		bodyCustomer.setHasPolicyAccount(bodyPolicies);
		requestBody.setCustomer(bodyCustomer);
		
		String apiURL = helper.getConfig("com.axa.payment.config.eipApiPolicyManagementUrl");
		
		ResponseDto response = helper.isDummy() == true ? gson.fromJson(helper.getConfigDummy(), ResponseDto.class) : helper.setupCallAPI(apiURL, bodyOperation, requestBody, httpRequest);
		
		if (Validator.isNull(response) == true || Validator.isNull(response.getBody()) == true || Validator.isNull(response.getBody().getCustomer()) == true) {
			return productSummary;
		}
		
		if (response.getBody().getCustomer().getHaveCommunicatedMessage().get(0).getDeliveryStatusCD() == 200) {
			productSummary.setFullName(response.getBody().getCustomer()
					  				   .getHasPolicyAccount().get(0)
					  				   .getHasCustomerInformationIn().get(0)
					  				   .getCanBeIndividual().getFullNM());
		}
		
		return productSummary;
	}
	
	@Reference
	private ConfigurationProvider _configurationProvider;
}
