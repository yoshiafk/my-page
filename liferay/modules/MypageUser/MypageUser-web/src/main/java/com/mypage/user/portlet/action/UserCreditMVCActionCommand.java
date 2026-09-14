package com.mypage.user.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.mypage.user.constants.UserCreditPortletKeys;
import com.mypage.user.model.CreditType;
import com.mypage.user.service.CreditTypeLocalService;
import com.mypage.user.service.CreditWalletLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + UserCreditPortletKeys.USERCREDIT,
		"mvc.command.name=/user_credit/update_data"
	},
	service = MVCActionCommand.class
)
public class UserCreditMVCActionCommand extends BaseMVCActionCommand  {
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.PUBLISH)) {
				publish(actionRequest);
			}
			
			if (cmd.equals(Constants.REMOVE)) {
				unpublish(actionRequest);
			}
			
			if (cmd.equals(Constants.DELETE)) {
				delete(actionRequest);
			}
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {

		}
	}
	
	protected void publish(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;
		
		if(type.equals("creditType"))
			serviceContext = ServiceContextFactory.getInstance(CreditType.class.getName(), actionRequest);
		
		if (entryId > 0) {
			entryIds = new long[] {entryId};
		}
		else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if(type.equals("creditType"))
				_creditTypeLocalService.setActive(entry, 1);
			if(type.equals("creditWallet"))
				_creditWalletLocalService.setActive(entry, 1);
		}
		
		// success message
		SessionMessages.add(actionRequest, "success");
	}
	
	protected void unpublish(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;
		
		if(type.equals("creditType"))
			serviceContext = ServiceContextFactory.getInstance(CreditType.class.getName(), actionRequest);
		
		if (entryId > 0) {
			entryIds = new long[] {entryId};
		}
		else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}
		
		for (long entry : entryIds) {
			if(type.equals("creditType"))
				_creditTypeLocalService.setActive(entry, 0);
			if(type.equals("creditWallet"))
				_creditWalletLocalService.setActive(entry, 0);
		}
		
		// success message
		SessionMessages.add(actionRequest, "success");
	}
	
	protected void delete(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (entryId > 0) {
			entryIds = new long[] {entryId};
		}
		else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}
		
		for (long entry : entryIds) {
			if(type.equals("creditType"))
				_creditTypeLocalService.deleteCreditType(entry);
			if(type.equals("creditWallet"))
				_creditWalletLocalService.deleteCreditWallet(entry);
		}
		
		// success message
		SessionMessages.add(actionRequest, "success");
	}
	
	@Reference
	private CreditTypeLocalService _creditTypeLocalService;
	@Reference
	private CreditWalletLocalService _creditWalletLocalService;
}
