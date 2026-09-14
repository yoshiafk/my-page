package com.mypage.user.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.user.constants.UserCreditPortletKeys;
import com.mypage.user.service.CreditTypeLocalService;
import com.mypage.user.service.CreditWalletLocalService;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author gositus
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=User Credit",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/user_credit/credit_type/list.jsp",
		"javax.portlet.name=" + UserCreditPortletKeys.USERCREDIT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class UserCreditPortlet extends MVCPortlet {
	/*
	 * Add or Update Credit Type
	 */
	public void addCreditType(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long creditTypeId = ParamUtil.get(actionRequest, "creditTypeId", 0);
		String name = ParamUtil.getString(actionRequest, "name", "");
		String agentType = ParamUtil.getString(actionRequest, "agentType", "");
		double limit = ParamUtil.getDouble(actionRequest, "limit", 0);
		int overrideGracePeriod = ParamUtil.getInteger(actionRequest, "overrideGracePeriod", 0);
		int nettPremiAllowed = ParamUtil.getInteger(actionRequest, "nettPremiAllowed", 0);
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		
		try {
			if (creditTypeId > 0) {
				_creditTypeLocalService.updateCreditType(creditTypeId, name, agentType, limit, overrideGracePeriod, nettPremiAllowed, active);
				actionResponse.setRenderParameter("mvcPath", "/user_credit/credit_type/edit.jsp");
			} else {
				_creditTypeLocalService.addCreditType(name, agentType, limit, overrideGracePeriod, nettPremiAllowed, active);
				actionResponse.setRenderParameter("mvcPath", "/user_credit/credit_type/list.jsp");
			}
			
			if (creditTypeId > 0) actionResponse.setRenderParameter("creditTypeId", String.valueOf(creditTypeId));
			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			SessionErrors.add(actionRequest, "failed");
			actionResponse.setRenderParameter("mvcPath", "/user_credit/credit_type/edit.jsp");
			if (creditTypeId > 0) actionResponse.setRenderParameter("creditTypeId", String.valueOf(creditTypeId));
			
			e.printStackTrace();
		}
	}
	
	/*
	 * Add or Update Credit Wallet
	 */
	public void addCreditWallet(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		long creditWalletId = ParamUtil.get(actionRequest, "creditWalletId", 0);
		long mypageUserId = ParamUtil.get(actionRequest, "mypageUserId", 0);
		long creditTypeId = ParamUtil.get(actionRequest, "creditTypeId", 0);
		String dateIssuedParam = ParamUtil.getString(actionRequest, "dateIssued", "");
		String dateExpiredParam = ParamUtil.getString(actionRequest, "dateExpired", "");
		double amount = ParamUtil.getDouble(actionRequest, "amount", 0);
		String status = ParamUtil.getString(actionRequest, "status", "");
		int active = ParamUtil.getBoolean(actionRequest, "active", false) ? 1 : 0;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			Date dateIssued = null;
			if (Validator.isNotNull(dateIssuedParam)) {
				dateIssued = sdf.parse(dateIssuedParam);
			}
			
			Date dateExpired = null;
			if (Validator.isNotNull(dateExpiredParam)) {
				dateExpired = sdf.parse(dateExpiredParam);
			}

			if (creditWalletId > 0) {
				_creditWalletLocalService.updateCreditWallet(creditWalletId, creditTypeId, dateIssued, dateExpired, amount, active);
				actionResponse.setRenderParameter("mvcPath", "/user_credit/credit_wallet/edit.jsp");
			} else {
				_creditWalletLocalService.addCreditWallet(creditTypeId, dateIssued, dateExpired, amount, active);
				actionResponse.setRenderParameter("mvcPath", "/user_credit/credit_wallet/list.jsp");
			}
			
			if (creditWalletId > 0) actionResponse.setRenderParameter("creditWalletId", String.valueOf(creditWalletId));
			SessionMessages.add(actionRequest, "success");
			
		} catch (Exception e) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			SessionErrors.add(actionRequest, "failed");
			actionResponse.setRenderParameter("mvcPath", "/user_credit/credit_wallet/edit.jsp");
			if (creditWalletId > 0) actionResponse.setRenderParameter("creditWalletId", String.valueOf(creditWalletId));
			
			e.printStackTrace();
		}
	}
	
	@Reference
	private CreditTypeLocalService _creditTypeLocalService;
	@Reference
	private CreditWalletLocalService _creditWalletLocalService;
}
