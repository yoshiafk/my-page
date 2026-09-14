package com.mypage.user.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.mypage.user.constants.MypageUserPortletKeys;
import com.mypage.user.model.MypageUser;
import com.mypage.user.service.MypageUserLocalService;
import com.mypage.user.service.MypageUserTimelineLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
	"javax.portlet.name=" + MypageUserPortletKeys.MYPAGEUSER,
	"mvc.command.name=/mypageuser/update_data" }
, service = MVCActionCommand.class)
public class MypageUserMVCActionCommand extends BaseMVCActionCommand {
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
			
			if (cmd.equals("deleteTimeline")) {
				deleteTimeline(actionRequest);
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

		if (type.equals("user"))
			serviceContext = ServiceContextFactory.getInstance(MypageUser.class.getName(), actionRequest);

		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("user"))
				_mypageUserLocalService.setActive(entry, 1, serviceContext);
		}
	}
	
	protected void unpublish(ActionRequest actionRequest) throws Exception {
		long[] entryIds = null;
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String type = ParamUtil.getString(actionRequest, "type");
		ServiceContext serviceContext = null;

		if (type.equals("user"))
			serviceContext = ServiceContextFactory.getInstance(MypageUser.class.getName(), actionRequest);
		
		if (entryId > 0) {
			entryIds = new long[] { entryId };
		} else {
			entryIds = StringUtil.split(ParamUtil.getString(actionRequest, "entryIds"), 0L);
		}

		for (long entry : entryIds) {
			if (type.equals("user"))
				_mypageUserLocalService.setActive(entry, 0, serviceContext);
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
			if (type.equals("user"))
				_mypageUserLocalService.deleteMypageUser(entry);
		}
	}
	
	protected void deleteTimeline(ActionRequest request) {
        try {
        	long entryId = ParamUtil.getLong(request, "entryId");
			_timeline.deleteMypageUserTimeline(entryId);
			SessionMessages.add(request, "timeline-deleted-ok");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionErrors.add(request, "timeline-deleted-no");
		}
	}
	
	@Reference
	private MypageUserLocalService _mypageUserLocalService;
	
	@Reference
	private MypageUserTimelineLocalService _timeline;
}
