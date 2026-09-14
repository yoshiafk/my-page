package com.mypage.product.pet.action;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mypage.leads.model.Leads;
import com.mypage.leads.service.DetailPetLocalServiceUtil;
import com.mypage.leads.service.LeadsLocalServiceUtil;
import com.mypage.product.pet.constants.PetPortletKeys;

import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + PetPortletKeys.PET,
		"mvc.command.name=/pet_upload_image" }, service = MVCResourceCommand.class)

public class PetUploadMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
        InputStream inputStream = null;
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        
        String leadToken = ParamUtil.getString(uploadRequest, "token", "");
        String imageType = ParamUtil.getString(uploadRequest, "type", "");
        
        Leads _leads = null;
        
        try {
        	
        	_leads = LeadsLocalServiceUtil.findByToken(leadToken);
        	
        	if(Validator.isNull(_leads)) throw new Exception("Leads not found");
        	
            long repositoryId = themeDisplay.getScopeGroupId();
            long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

            String originalFileName = uploadRequest.getFileName("file");
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uniqueFileName = System.currentTimeMillis() + fileExtension;
            
            
            inputStream = uploadRequest.getFileAsStream("file");
            long fileSize = uploadRequest.getSize("file");

            Folder folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, "PET");

            String mimeType = MimeTypesUtil.getContentType(uniqueFileName);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), resourceRequest);

            FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                themeDisplay.getUserId(),
                repositoryId,
                folder.getFolderId(),
                uniqueFileName,
                mimeType,
                uniqueFileName,
                uniqueFileName,
                "",
                inputStream,
                fileSize,
                serviceContext
            );
            
            String fileUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, "");
            long photoFileEntryId = fileEntry.getFileEntryId();
            
            if(imageType.equals("leadIdPhoto")) {
            	LeadsLocalServiceUtil.setIdPhoto(_leads.getLeadsId(), photoFileEntryId);
            }
            
            if(imageType.equals("petCertificatePhoto")) {
            	DetailPetLocalServiceUtil.setPetCertificatePhoto(_leads.getLeadsId(), photoFileEntryId);
            }
            
            if(imageType.equals("petPhoto")) {
            	DetailPetLocalServiceUtil.setPetPhoto(_leads.getLeadsId(), photoFileEntryId);
            }
            
            JSONObject imageData = JSONFactoryUtil.createJSONObject();
            
            imageData.put("preview", fileUrl);
            imageData.put("id", photoFileEntryId);
            imageData.put("name", uniqueFileName);
            jsonResponse.put("data", imageData);

            jsonResponse.put("status", true);
            
//            System.out.println(jsonResponse);
            
            // update fileEntryId di leads
        } catch (Exception e) {
        	e.printStackTrace();
//            _log.error("Error while uploading file: ", e);
            jsonResponse.put("status", false);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
//                    _log.error("Error while closing input stream: ", e);
                	e.printStackTrace();
                }
            }
            try {
                resourceResponse.getWriter().write(jsonResponse.toString());
            } catch (IOException e) {
            	e.printStackTrace();
//                _log.error("Error while writing JSON response: ", e);
            }
        }
	}

}
