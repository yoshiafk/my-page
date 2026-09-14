package com.mypage.leads.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.mypage.leads.constants.MypageLeadsPortletKeys;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.LeadsLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
	"javax.portlet.name=" + MypageLeadsPortletKeys.MYPAGELEADS,
	"mvc.command.name=/leads/update_data" 
}, service = MVCActionCommand.class)

public class LeadsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
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
			log.info(e);
		}
		
	}

	protected void publish(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;
		
		if (type.equals("leads"))
			serviceContext = ServiceContextFactory.getInstance(Leads.class.getName(), actionRequest);

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("leads"))
				_leadsLocalService.setActive(entry, 1, serviceContext);
		}
	}

	protected void unpublish(ActionRequest actionRequest) throws Exception {

		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (type.equals("leads"))
			serviceContext = ServiceContextFactory.getInstance(Leads.class.getName(), actionRequest);
		
		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("leads"))
				_leadsLocalService.setActive(entry, 0, serviceContext);
		}
	}

	protected void delete(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("leads"))
				_leadsLocalService.deleteLeads(entry);
		}
	}

	private static final Log log = LogFactoryUtil.getLog(LeadsMVCActionCommand.class);

	@Reference
	private LeadsLocalService _leadsLocalService;

}
