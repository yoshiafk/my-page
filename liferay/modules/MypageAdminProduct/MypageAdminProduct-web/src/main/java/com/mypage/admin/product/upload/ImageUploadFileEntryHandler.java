package com.mypage.admin.product.upload;

import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepository;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;
import com.liferay.upload.UploadFileEntryHandler;
import com.mypage.admin.product.model.MasterBank;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	service = ImageUploadFileEntryHandler.class
)
public class ImageUploadFileEntryHandler implements UploadFileEntryHandler {

	@Override
	public FileEntry upload(UploadPortletRequest uploadPortletRequest)
		throws IOException, PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)uploadPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		String fileName = uploadPortletRequest.getFileName(_PARAMETER_NAME);
		String contentType = uploadPortletRequest.getContentType(
			_PARAMETER_NAME);

		_validateFile(
			fileName, contentType,
			uploadPortletRequest.getSize(_PARAMETER_NAME));

		try (InputStream inputStream = uploadPortletRequest.getFileAsStream(
				_PARAMETER_NAME)) {

			return uploadImage(uploadPortletRequest);
		}
	}
	
	protected FileEntry uploadImage(UploadPortletRequest uploadPortletRequest) throws PortalException {
		PortalException portalException = null;
		
			UploadPortletRequest uploadRequest = uploadPortletRequest;
			
			ThemeDisplay themeDisplay =
					(ThemeDisplay)uploadPortletRequest.getAttribute(
						WebKeys.THEME_DISPLAY);
			
			
			File file = uploadRequest.getFile(_PARAMETER_NAME);
			String fileName = uploadRequest.getFileName(_PARAMETER_NAME);
			String contentType = uploadRequest.getContentType(
				_PARAMETER_NAME);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MasterBank.class.getName(), uploadPortletRequest);
			long repositoryId = DLFolderConstants.getDataRepositoryId(
		            serviceContext.getScopeGroupId(), 
		            DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			
			// check folder exist or not
			DLFolder getFolder = DLFolderLocalServiceUtil.fetchFolder(themeDisplay.getScopeGroupId(), 0, _FOLDER_NAME);
			
			DLFolder dlFolder;
			if(getFolder == null) {
				// create new folder
				dlFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), repositoryId, false, 0, "Master Bank", "", false, serviceContext);
			} else {
				// get folder
				dlFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, _FOLDER_NAME);
			}
			
			// set filename
			String uniqueFileName = _uniqueFileNameProvider.provide(
					fileName, curFileName -> _exists(themeDisplay, dlFolder.getFolderId(), curFileName));
			
			return DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
	                repositoryId, dlFolder.getFolderId(), uniqueFileName, 
	                contentType, uniqueFileName, "", "", 
	                file, serviceContext
	        );
	}

	private boolean _exists(ThemeDisplay themeDisplay, long folderId, String curFileName) {
		try {
			FileEntry tempFileEntry = DLAppLocalServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, curFileName);

			if (tempFileEntry != null) {
				return true;
			}

			return false;
		}
		catch (PortalException portalException) {
			if (_log.isDebugEnabled()) {
				_log.debug(portalException, portalException);
			}

			return false;
		}
	}
	
	private void _validateFile(String fileName, String contentType, long size)
		throws PortalException {

		long blogsImageMaxSize = _IMAGE_MAX_SIZE;

		if ((blogsImageMaxSize > 0) && (size > blogsImageMaxSize)) {
			throw new EntryImageSizeException();
		}

		Set<String> extensions = MimeTypesUtil.getExtensions(contentType);

		boolean validContentType = Stream.of(
				_IMAGE_EXTENSIONS
		).anyMatch(
			extension ->
				extension.equals(StringPool.STAR) ||
				extensions.contains(extension)
		);

		if (!validContentType) {
			throw new EntryImageNameException(
				"Invalid image for file name " + fileName);
		}
	}

	private static final String _PARAMETER_NAME = "imageSelectorFileName";
	
	private static final Object[] _IMAGE_EXTENSIONS = {".gif", ".jpeg", ".jpg", ".png"};
	
	private static final long _IMAGE_MAX_SIZE = 5242880;
	
	private static final String _FOLDER_NAME = "Master Bank";
	
	private static final Log _log = LogFactoryUtil.getLog(
			ImageUploadFileEntryHandler.class);
	
	@Reference
	protected PortletFileRepository portletFileRepository;
	
	@Reference
	private UniqueFileNameProvider _uniqueFileNameProvider;
	
}
