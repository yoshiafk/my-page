package com.mypage.admin.product.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.mypage.admin.product.constants.PetAdminPortletKeys;
import com.mypage.admin.product.model.PetAnimalType;
import com.mypage.admin.product.model.PetPlan;
import com.mypage.admin.product.model.PetRate;
import com.mypage.admin.product.model.PetRemarks;
import com.mypage.admin.product.service.PetAnimalTypeLocalService;
import com.mypage.admin.product.service.PetPlanLocalService;
import com.mypage.admin.product.service.PetRateLocalService;
import com.mypage.admin.product.service.PetRemarksLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, property = { "javax.portlet.name=" + PetAdminPortletKeys.PET_ADMIN,
"mvc.command.name=/pet/update_data" }, service = MVCActionCommand.class)

public class PetMVCActionCommand extends BaseMVCActionCommand {

	// 
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
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void publish(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (type.equals("plan"))
			serviceContext = ServiceContextFactory.getInstance(PetPlan.class.getName(), actionRequest);
		if (type.equals("remarks"))
			serviceContext = ServiceContextFactory.getInstance(PetRemarks.class.getName(), actionRequest);
		if (type.equals("rate"))
			serviceContext = ServiceContextFactory.getInstance(PetRate.class.getName(), actionRequest);
		if (type.equals("animalType"))
			serviceContext = ServiceContextFactory.getInstance(PetAnimalType.class.getName(), actionRequest);

		long userId = serviceContext.getUserId();

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("plan"))
				_petPlanLocalService.setActive(userId, entry, 1, serviceContext);
			if (type.equals("remarks"))
				_petRemarksLocalService.setActive(userId, entry, 1, serviceContext);
			if (type.equals("rate"))
				_petRateLocalService.setActive(userId, entry, 1, serviceContext);
			if (type.equals("animalType"))
				_petAnimalTypeLocalService.setActive(entry, 1, serviceContext);
		}
	}

	protected void unpublish(ActionRequest actionRequest) throws Exception {

		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (type.equals("plan"))
			serviceContext = ServiceContextFactory.getInstance(PetPlan.class.getName(), actionRequest);
		if (type.equals("remarks"))
			serviceContext = ServiceContextFactory.getInstance(PetRemarks.class.getName(), actionRequest);
		if (type.equals("rate"))
			serviceContext = ServiceContextFactory.getInstance(PetRate.class.getName(), actionRequest);
		if (type.equals("animalType"))
			serviceContext = ServiceContextFactory.getInstance(PetAnimalType.class.getName(), actionRequest);

		long userId = serviceContext.getUserId();

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("plan"))
				_petPlanLocalService.setActive(userId, entry, 0, serviceContext);
			if (type.equals("remarks"))
				_petRemarksLocalService.setActive(userId, entry, 0, serviceContext);
			if (type.equals("rate"))
				_petRateLocalService.setActive(userId, entry, 0, serviceContext);
			if (type.equals("animalType"))
				_petAnimalTypeLocalService.setActive(entry, 0, serviceContext);
		}
	}
	
	protected void delete(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("plan"))
				_petPlanLocalService.deletePetPlan(entry);
			if (type.equals("remarks"))
				_petRemarksLocalService.deletePetRemarks(entry);
			if (type.equals("rate"))
				_petRateLocalService.deletePetRate(entry);
			if (type.equals("animalType"))
				_petAnimalTypeLocalService.deletePetAnimalType(entry);
		}
	}

	@Reference
	private PetPlanLocalService _petPlanLocalService;

	@Reference
	private PetRemarksLocalService _petRemarksLocalService;

	@Reference
	private PetRateLocalService _petRateLocalService;

	@Reference
	private PetAnimalTypeLocalService _petAnimalTypeLocalService;

}
