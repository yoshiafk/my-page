package com.mypage.user.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.upload.UploadHandler;
import com.mypage.user.constants.MypageUserPortletKeys;
import com.mypage.user.upload.ImageUploadFileEntryHandler;
import com.mypage.user.upload.ImageUploadResponseHandler;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=" + MypageUserPortletKeys.MYPAGEUSER,
				"mvc.command.name=/masterdata/upload_image" 
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
