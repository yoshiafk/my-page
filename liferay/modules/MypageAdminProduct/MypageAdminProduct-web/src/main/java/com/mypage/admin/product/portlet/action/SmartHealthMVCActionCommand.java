package com.mypage.admin.product.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.mypage.admin.product.constants.SmartHealthAdminPortletKeys;
import com.mypage.admin.product.model.SmartHealthBenefitGroup;
import com.mypage.admin.product.model.SmartHealthPlan;
import com.mypage.admin.product.model.SmartHealthPremi;
import com.mypage.admin.product.portlet.InternationalTravelAdminPortlet;
import com.mypage.admin.product.service.SmartHealthBenefitGroupLocalService;
import com.mypage.admin.product.service.SmartHealthPlanLocalService;
import com.mypage.admin.product.service.SmartHealthPremiLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SmartHealthAdminPortletKeys.SMARTHEALTHADMIN,
		"mvc.command.name=/smart_health/update_data" }, service = MVCActionCommand.class)
public class SmartHealthMVCActionCommand extends BaseMVCActionCommand {

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

			if (cmd.equals(Constants.DELETE)) {
				log.info("delete");
//					delete(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			log.info(e);
		}
	}

	/**
	 * Publish Action
	 * 
	 * @param actionRequest
	 * @throws Exception
	 */
	protected void publish(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (type.equals("plan")) {
			serviceContext = ServiceContextFactory.getInstance(SmartHealthPlan.class.getName(), actionRequest);
		}

		if (type.equals("premi")) {
			serviceContext = ServiceContextFactory.getInstance(SmartHealthPremi.class.getName(), actionRequest);
		}
		
		if (type.equals("benefit_group")) {
			serviceContext = ServiceContextFactory.getInstance(SmartHealthBenefitGroup.class.getName(), actionRequest);
		}

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("plan")) {
				_smartHealthPlanLocalService.setActive(entry, 1, serviceContext);
			}

			if (type.equals("premi")) {
				_smartHealthPremiLocalService.setActive(entry, 1, serviceContext);
			}
			
			if (type.equals("benefit_group")) {
				_smartHealthBenefitGroupLocalService.setActive(entry, 1, serviceContext);
			}			

		}
	}

	/**
	 * Unpublish Action
	 * 
	 * @param actionRequest
	 * @throws Exception
	 */
	protected void unpublish(ActionRequest actionRequest) throws Exception {

		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (type.equals("plan")) {
			serviceContext = ServiceContextFactory.getInstance(SmartHealthPlan.class.getName(), actionRequest);
		}

		if (type.equals("premi")) {
			serviceContext = ServiceContextFactory.getInstance(SmartHealthPremi.class.getName(), actionRequest);
		}
		
		if (type.equals("benefit_group")) {
			serviceContext = ServiceContextFactory.getInstance(SmartHealthBenefitGroup.class.getName(), actionRequest);
		}		

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("plan")) {
				_smartHealthPlanLocalService.setActive(entry, 0, serviceContext);
			}

			if (type.equals("premi")) {
				_smartHealthPremiLocalService.setActive(entry, 0, serviceContext);
			}
			
			if (type.equals("benefit_group")) {
				_smartHealthBenefitGroupLocalService.setActive(entry, 0, serviceContext);
			}			
		}
	}

	private static final Log log = LogFactoryUtil.getLog(SmartHealthMVCActionCommand.class);
	@Reference
	private SmartHealthPlanLocalService _smartHealthPlanLocalService;
	@Reference
	private SmartHealthPremiLocalService _smartHealthPremiLocalService;
	@Reference
	private SmartHealthBenefitGroupLocalService _smartHealthBenefitGroupLocalService;	

}
