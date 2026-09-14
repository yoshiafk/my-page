package com.mypage.leads.upload;

import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.item.selector.ItemSelectorUploadResponseHandler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseConstants;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.upload.UploadResponseHandler;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		service = ImageUploadResponseHandler.class
	)
public class ImageUploadResponseHandler implements UploadResponseHandler {
	@Override
	public JSONObject onFailure(
			PortletRequest portletRequest, PortalException portalException)
		throws PortalException {

		JSONObject jsonObject = _itemSelectorUploadResponseHandler.onFailure(
			portletRequest, portalException);

		if (portalException instanceof EntryImageNameException ||
			portalException instanceof EntryImageSizeException) {

			String errorMessage = StringPool.BLANK;
			int errorType = 0;

			if (portalException instanceof EntryImageNameException) {
				errorType =
					ServletResponseConstants.SC_FILE_EXTENSION_EXCEPTION;

				errorMessage = StringUtil.merge(_IMAGE_EXTENSIONS);
			}
			else if (portalException instanceof EntryImageSizeException) {
				errorType = ServletResponseConstants.SC_FILE_SIZE_EXCEPTION;
			}

			jsonObject.put(
				"error",
				JSONUtil.put(
					"errorType", errorType
				).put(
					"message", errorMessage
				));
		}

		return jsonObject;
	}

	@Override
	public JSONObject onSuccess(
			UploadPortletRequest uploadPortletRequest, FileEntry fileEntry)
		throws PortalException {

		return _itemSelectorUploadResponseHandler.onSuccess(
			uploadPortletRequest, fileEntry);
	}


	@Reference
	private ItemSelectorUploadResponseHandler
		_itemSelectorUploadResponseHandler;
	
	private static final Object[] _IMAGE_EXTENSIONS = {".gif", ".jpeg", ".jpg", ".png"};
}	
