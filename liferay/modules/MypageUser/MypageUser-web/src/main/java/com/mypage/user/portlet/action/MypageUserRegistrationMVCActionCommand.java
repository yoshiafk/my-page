package com.mypage.user.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.mypage.user.constants.MypageUserRegistrationPortletKeys;
import com.mypage.user.model.UserRegistration;
import com.mypage.user.service.UserRegistrationLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + MypageUserRegistrationPortletKeys.MYPAGEUSERREGISTRATION,
		"mvc.command.name=/mypageuserregistration/update_data" }, service = MVCActionCommand.class)
public class MypageUserRegistrationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.PUBLISH)) {
				publish(actionRequest);
			}

			if (cmd.equals(Constants.REMOVE)) {
				unpublish(actionRequest);
			}

//			if (cmd.equals(Constants.DELETE)) {
//				delete(actionRequest);
//			}

			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void publish(ActionRequest actionRequest) throws Exception {

		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");

		ServiceContext serviceContext = null;

		if (type.equals("user_registration")) {
			serviceContext = ServiceContextFactory.getInstance(UserRegistration.class.getName(), actionRequest);
		}

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("user_registration")) {
				_userRegistrationLocalService.setActive(serviceContext.getUserId(), entry, Integer.valueOf(1),
						serviceContext);
			}
		}
	}

	protected void unpublish(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (type.equals("user_registration")) {
			serviceContext = ServiceContextFactory.getInstance(UserRegistration.class.getName(), actionRequest);
		}

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {

			if (type.equals("user_registration")) {
				_userRegistrationLocalService.setActive(serviceContext.getUserId(), entry, Integer.valueOf(0),
						serviceContext);
			}
		}
	}

	@Reference
	private UserRegistrationLocalService _userRegistrationLocalService;

}
