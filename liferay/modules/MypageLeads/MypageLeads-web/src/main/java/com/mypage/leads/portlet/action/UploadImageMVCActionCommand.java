package com.mypage.leads.portlet.action;


import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.upload.UploadHandler;
import com.mypage.leads.constants.MypageLeadsPortletKeys;
import com.mypage.leads.upload.ImageUploadFileEntryHandler;
import com.mypage.leads.upload.ImageUploadResponseHandler;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + MypageLeadsPortletKeys.MYPAGELEADS,
				"mvc.command.name=/leads/upload_image" 
		}, 
		service = MVCActionCommand.class
)

public class UploadImageMVCActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		
		_uploadHandler.upload(
				_imageUploadFileEntryHandler,
				_imageUploadResponseHandler, actionRequest, actionResponse);
	}
	
	@Reference
	private ImageUploadResponseHandler _imageUploadResponseHandler;

	@Reference
	private ImageUploadFileEntryHandler _imageUploadFileEntryHandler;

	@Reference
	private UploadHandler _uploadHandler;
}
